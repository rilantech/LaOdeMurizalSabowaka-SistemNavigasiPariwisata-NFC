package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ShortcutManagerCompat {
    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static final String SHORTCUT_LISTENER_INTENT_FILTER_ACTION = "androidx.core.content.pm.SHORTCUT_LISTENER";
    private static final String SHORTCUT_LISTENER_META_DATA_KEY = "androidx.core.content.pm.shortcut_listener_impl";
    private static volatile List<ShortcutInfoChangeListener> sShortcutInfoChangeListeners = null;
    private static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShortcutMatchFlags {
    }

    private ShortcutManagerCompat() {
    }

    public static boolean isRequestPinShortcutSupported(Context context) {
        return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
    }

    public static boolean requestPinShortcut(Context context, ShortcutInfoCompat shortcut, IntentSender callback) {
        return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).requestPinShortcut(shortcut.toShortcutInfo(), callback);
    }

    public static Intent createShortcutResultIntent(Context context, ShortcutInfoCompat shortcut) {
        Intent result = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).createShortcutResultIntent(shortcut.toShortcutInfo());
        if (result == null) {
            result = new Intent();
        }
        return shortcut.addToIntent(result);
    }

    public static List<ShortcutInfoCompat> getShortcuts(Context context, int matchFlags) {
        return ShortcutInfoCompat.fromShortcuts(context, ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getShortcuts(matchFlags));
    }

    public static boolean addDynamicShortcuts(Context context, List<ShortcutInfoCompat> shortcutInfoList) {
        List<ShortcutInfoCompat> clone = removeShortcutsExcludedFromSurface(shortcutInfoList, 1);
        ArrayList<ShortcutInfo> shortcuts = new ArrayList<>();
        for (ShortcutInfoCompat item : clone) {
            shortcuts.add(item.toShortcutInfo());
        }
        if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).addDynamicShortcuts(shortcuts)) {
            return false;
        }
        getShortcutInfoSaverInstance(context).addShortcuts(clone);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onShortcutAdded(shortcutInfoList);
        }
        return true;
    }

    public static int getMaxShortcutCountPerActivity(Context context) {
        Preconditions.checkNotNull(context);
        return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
    }

    public static boolean isRateLimitingActive(Context context) {
        Preconditions.checkNotNull(context);
        return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).isRateLimitingActive();
    }

    public static int getIconMaxWidth(Context context) {
        Preconditions.checkNotNull(context);
        return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getIconMaxWidth();
    }

    public static int getIconMaxHeight(Context context) {
        Preconditions.checkNotNull(context);
        return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getIconMaxHeight();
    }

    public static void reportShortcutUsed(Context context, String shortcutId) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(shortcutId);
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).reportShortcutUsed(shortcutId);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onShortcutUsageReported(Collections.singletonList(shortcutId));
        }
    }

    public static boolean setDynamicShortcuts(Context context, List<ShortcutInfoCompat> shortcutInfoList) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(shortcutInfoList);
        List<ShortcutInfoCompat> clone = removeShortcutsExcludedFromSurface(shortcutInfoList, 1);
        List<ShortcutInfo> shortcuts = new ArrayList<>(clone.size());
        for (ShortcutInfoCompat compat : clone) {
            shortcuts.add(compat.toShortcutInfo());
        }
        if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).setDynamicShortcuts(shortcuts)) {
            return false;
        }
        getShortcutInfoSaverInstance(context).removeAllShortcuts();
        getShortcutInfoSaverInstance(context).addShortcuts(clone);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onAllShortcutsRemoved();
            listener.onShortcutAdded(shortcutInfoList);
        }
        return true;
    }

    public static List<ShortcutInfoCompat> getDynamicShortcuts(Context context) {
        List<ShortcutInfo> shortcuts = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
        List<ShortcutInfoCompat> compats = new ArrayList<>(shortcuts.size());
        for (ShortcutInfo item : shortcuts) {
            compats.add(new ShortcutInfoCompat.Builder(context, item).build());
        }
        return compats;
    }

    public static boolean updateShortcuts(Context context, List<ShortcutInfoCompat> shortcutInfoList) {
        List<ShortcutInfoCompat> clone = removeShortcutsExcludedFromSurface(shortcutInfoList, 1);
        ArrayList<ShortcutInfo> shortcuts = new ArrayList<>();
        for (ShortcutInfoCompat item : clone) {
            shortcuts.add(item.toShortcutInfo());
        }
        if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).updateShortcuts(shortcuts)) {
            return false;
        }
        getShortcutInfoSaverInstance(context).addShortcuts(clone);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onShortcutUpdated(shortcutInfoList);
        }
        return true;
    }

    static boolean convertUriIconToBitmapIcon(Context context, ShortcutInfoCompat info) {
        Bitmap bitmap;
        IconCompat iconCompat;
        if (info.mIcon == null) {
            return false;
        }
        int type = info.mIcon.mType;
        if (type != 6 && type != 4) {
            return true;
        }
        InputStream is = info.mIcon.getUriInputStream(context);
        if (is == null || (bitmap = BitmapFactory.decodeStream(is)) == null) {
            return false;
        }
        if (type == 6) {
            iconCompat = IconCompat.createWithAdaptiveBitmap(bitmap);
        } else {
            iconCompat = IconCompat.createWithBitmap(bitmap);
        }
        info.mIcon = iconCompat;
        return true;
    }

    static void convertUriIconsToBitmapIcons(Context context, List<ShortcutInfoCompat> shortcutInfoList) {
        for (ShortcutInfoCompat info : new ArrayList<>(shortcutInfoList)) {
            if (!convertUriIconToBitmapIcon(context, info)) {
                shortcutInfoList.remove(info);
            }
        }
    }

    public static void disableShortcuts(Context context, List<String> shortcutIds, CharSequence disabledMessage) {
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).disableShortcuts(shortcutIds, disabledMessage);
        getShortcutInfoSaverInstance(context).removeShortcuts(shortcutIds);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onShortcutRemoved(shortcutIds);
        }
    }

    public static void enableShortcuts(Context context, List<ShortcutInfoCompat> shortcutInfoList) {
        List<ShortcutInfoCompat> clone = removeShortcutsExcludedFromSurface(shortcutInfoList, 1);
        ArrayList<String> shortcutIds = new ArrayList<>(shortcutInfoList.size());
        for (ShortcutInfoCompat shortcut : clone) {
            shortcutIds.add(shortcut.mId);
        }
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).enableShortcuts(shortcutIds);
        getShortcutInfoSaverInstance(context).addShortcuts(clone);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onShortcutAdded(shortcutInfoList);
        }
    }

    public static void removeDynamicShortcuts(Context context, List<String> shortcutIds) {
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(shortcutIds);
        getShortcutInfoSaverInstance(context).removeShortcuts(shortcutIds);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onShortcutRemoved(shortcutIds);
        }
    }

    public static void removeAllDynamicShortcuts(Context context) {
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
        getShortcutInfoSaverInstance(context).removeAllShortcuts();
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onAllShortcutsRemoved();
        }
    }

    public static void removeLongLivedShortcuts(Context context, List<String> shortcutIds) {
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(shortcutIds);
        getShortcutInfoSaverInstance(context).removeShortcuts(shortcutIds);
        for (ShortcutInfoChangeListener listener : getShortcutInfoListeners(context)) {
            listener.onShortcutRemoved(shortcutIds);
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static boolean pushDynamicShortcut(android.content.Context r7, androidx.core.content.pm.ShortcutInfoCompat r8) {
        /*
            androidx.core.util.Preconditions.checkNotNull(r7)
            androidx.core.util.Preconditions.checkNotNull(r8)
            int r0 = getMaxShortcutCountPerActivity(r7)
            r1 = 0
            if (r0 != 0) goto L_0x000f
            return r1
        L_0x000f:
            java.lang.Class<android.content.pm.ShortcutManager> r2 = android.content.pm.ShortcutManager.class
            java.lang.Object r2 = r7.getSystemService(r2)
            android.content.pm.ShortcutManager r2 = (android.content.pm.ShortcutManager) r2
            android.content.pm.ShortcutInfo r3 = r8.toShortcutInfo()
            r2.pushDynamicShortcut(r3)
            androidx.core.content.pm.ShortcutInfoCompatSaver r2 = getShortcutInfoSaverInstance(r7)
            java.util.List r3 = r2.getShortcuts()     // Catch:{ Exception -> 0x0093, all -> 0x006e }
            int r4 = r3.size()     // Catch:{ Exception -> 0x0093, all -> 0x006e }
            r5 = 1
            if (r4 < r0) goto L_0x003e
            java.lang.String[] r4 = new java.lang.String[r5]     // Catch:{ Exception -> 0x0093, all -> 0x006e }
            java.lang.String r6 = getShortcutInfoCompatWithLowestRank(r3)     // Catch:{ Exception -> 0x0093, all -> 0x006e }
            r4[r1] = r6     // Catch:{ Exception -> 0x0093, all -> 0x006e }
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ Exception -> 0x0093, all -> 0x006e }
            r2.removeShortcuts(r4)     // Catch:{ Exception -> 0x0093, all -> 0x006e }
        L_0x003e:
            androidx.core.content.pm.ShortcutInfoCompat[] r4 = new androidx.core.content.pm.ShortcutInfoCompat[]{r8}     // Catch:{ Exception -> 0x0093, all -> 0x006e }
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ Exception -> 0x0093, all -> 0x006e }
            r2.addShortcuts(r4)     // Catch:{ Exception -> 0x0093, all -> 0x006e }
            java.util.List r1 = getShortcutInfoListeners(r7)
            java.util.Iterator r1 = r1.iterator()
        L_0x0052:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0066
            java.lang.Object r4 = r1.next()
            androidx.core.content.pm.ShortcutInfoChangeListener r4 = (androidx.core.content.pm.ShortcutInfoChangeListener) r4
            java.util.List r6 = java.util.Collections.singletonList(r8)
            r4.onShortcutAdded(r6)
            goto L_0x0052
        L_0x0066:
            java.lang.String r1 = r8.getId()
            reportShortcutUsed(r7, r1)
            return r5
        L_0x006e:
            r1 = move-exception
            java.util.List r3 = getShortcutInfoListeners(r7)
            java.util.Iterator r3 = r3.iterator()
        L_0x0077:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x008b
            java.lang.Object r4 = r3.next()
            androidx.core.content.pm.ShortcutInfoChangeListener r4 = (androidx.core.content.pm.ShortcutInfoChangeListener) r4
            java.util.List r5 = java.util.Collections.singletonList(r8)
            r4.onShortcutAdded(r5)
            goto L_0x0077
        L_0x008b:
            java.lang.String r3 = r8.getId()
            reportShortcutUsed(r7, r3)
            throw r1
        L_0x0093:
            r3 = move-exception
            java.util.List r3 = getShortcutInfoListeners(r7)
            java.util.Iterator r3 = r3.iterator()
        L_0x009c:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00b0
            java.lang.Object r4 = r3.next()
            androidx.core.content.pm.ShortcutInfoChangeListener r4 = (androidx.core.content.pm.ShortcutInfoChangeListener) r4
            java.util.List r5 = java.util.Collections.singletonList(r8)
            r4.onShortcutAdded(r5)
            goto L_0x009c
        L_0x00b0:
            java.lang.String r3 = r8.getId()
            reportShortcutUsed(r7, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.pm.ShortcutManagerCompat.pushDynamicShortcut(android.content.Context, androidx.core.content.pm.ShortcutInfoCompat):boolean");
    }

    private static String getShortcutInfoCompatWithLowestRank(List<ShortcutInfoCompat> shortcuts) {
        int rank = -1;
        String target = null;
        for (ShortcutInfoCompat s : shortcuts) {
            if (s.getRank() > rank) {
                target = s.getId();
                rank = s.getRank();
            }
        }
        return target;
    }

    static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver<Void> saver) {
        sShortcutInfoCompatSaver = saver;
    }

    static void setShortcutInfoChangeListeners(List<ShortcutInfoChangeListener> listeners) {
        sShortcutInfoChangeListeners = listeners;
    }

    static List<ShortcutInfoChangeListener> getShortcutInfoChangeListeners() {
        return sShortcutInfoChangeListeners;
    }

    private static int getIconDimensionInternal(Context context, boolean isHorizontal) {
        ActivityManager am = (ActivityManager) context.getSystemService("activity");
        int iconDimensionDp = Math.max(1, am == null || am.isLowRamDevice() ? 48 : 96);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (((float) iconDimensionDp) * ((isHorizontal ? displayMetrics.xdpi : displayMetrics.ydpi) / 160.0f));
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context context) {
        if (sShortcutInfoCompatSaver == null) {
            try {
                sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
            } catch (Exception e) {
            }
            if (sShortcutInfoCompatSaver == null) {
                sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
            }
        }
        return sShortcutInfoCompatSaver;
    }

    private static List<ShortcutInfoChangeListener> getShortcutInfoListeners(Context context) {
        Bundle metaData;
        String shortcutListenerImplName;
        if (sShortcutInfoChangeListeners == null) {
            List<ShortcutInfoChangeListener> result = new ArrayList<>();
            PackageManager packageManager = context.getPackageManager();
            Intent activityIntent = new Intent(SHORTCUT_LISTENER_INTENT_FILTER_ACTION);
            activityIntent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(activityIntent, 128)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (!(activityInfo == null || (metaData = activityInfo.metaData) == null || (shortcutListenerImplName = metaData.getString(SHORTCUT_LISTENER_META_DATA_KEY)) == null)) {
                    try {
                        result.add((ShortcutInfoChangeListener) Class.forName(shortcutListenerImplName, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context}));
                    } catch (Exception e) {
                    }
                }
            }
            if (sShortcutInfoChangeListeners == null) {
                sShortcutInfoChangeListeners = result;
            }
        }
        return sShortcutInfoChangeListeners;
    }

    private static List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface(List<ShortcutInfoCompat> shortcuts, int surfaces) {
        Objects.requireNonNull(shortcuts);
        return shortcuts;
    }

    private static class Api25Impl {
        private Api25Impl() {
        }

        static String getShortcutInfoWithLowestRank(List<ShortcutInfo> shortcuts) {
            int rank = -1;
            String target = null;
            for (ShortcutInfo s : shortcuts) {
                if (s.getRank() > rank) {
                    target = s.getId();
                    rank = s.getRank();
                }
            }
            return target;
        }
    }
}

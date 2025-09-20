package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import java.util.ArrayList;

public final class IntentCompat {
    public static final String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";
    public static final String EXTRA_TIME = "android.intent.extra.TIME";

    private IntentCompat() {
    }

    public static Intent makeMainSelectorActivity(String selectorAction, String selectorCategory) {
        return Api15Impl.makeMainSelectorActivity(selectorAction, selectorCategory);
    }

    public static Intent createManageUnusedAppRestrictionsIntent(Context context, String packageName) {
        if (PackageManagerCompat.areUnusedAppRestrictionsAvailable(context.getPackageManager())) {
            return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", packageName, (String) null));
        }
        throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
    }

    public static <T> T getParcelableExtra(Intent in, String name, Class<T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelableExtra(in, name, clazz);
        }
        T extra = in.getParcelableExtra(name);
        if (clazz.isInstance(extra)) {
            return extra;
        }
        return null;
    }

    public static Parcelable[] getParcelableArrayExtra(Intent in, String name, Class<? extends Parcelable> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (Parcelable[]) Api33Impl.getParcelableArrayExtra(in, name, clazz);
        }
        return in.getParcelableArrayExtra(name);
    }

    public static <T> ArrayList<T> getParcelableArrayListExtra(Intent in, String name, Class<? extends T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelableArrayListExtra(in, name, clazz);
        }
        return in.getParcelableArrayListExtra(name);
    }

    static class Api15Impl {
        private Api15Impl() {
        }

        static Intent makeMainSelectorActivity(String selectorAction, String selectorCategory) {
            return Intent.makeMainSelectorActivity(selectorAction, selectorCategory);
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static <T> T getParcelableExtra(Intent in, String name, Class<T> clazz) {
            return in.getParcelableExtra(name, clazz);
        }

        static <T> T[] getParcelableArrayExtra(Intent in, String name, Class<T> clazz) {
            return in.getParcelableArrayExtra(name, clazz);
        }

        static <T> ArrayList<T> getParcelableArrayListExtra(Intent in, String name, Class<? extends T> clazz) {
            return in.getParcelableArrayListExtra(name, clazz);
        }
    }
}

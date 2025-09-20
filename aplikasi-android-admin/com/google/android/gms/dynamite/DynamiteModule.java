package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    public static final int REMOTE = 1;
    public static final VersionPolicy zza = new zzl();
    private static Boolean zzb;
    private static String zzc;
    private static boolean zzd;
    private static int zze = -1;
    private static Boolean zzf = null;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();
    private static zzq zzk;
    private static zzr zzl;
    private final Context zzj;

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzp zzp) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzp) {
            super(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z) throws LoadingException;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    public static int getLocalVersion(Context context, String moduleId) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + moduleId + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get((Object) null), moduleId)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            Log.e("DynamiteModule", "Module descriptor id '" + valueOf + "' didn't match expected id '" + moduleId + "'");
            return 0;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", "Local module descriptor class for " + moduleId + " not found.");
            return 0;
        } catch (Exception e2) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e2.getMessage())));
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String moduleId) {
        return zza(context, moduleId, false);
    }

    public static DynamiteModule load(Context context, VersionPolicy policy, String moduleId) throws LoadingException {
        int i;
        Boolean bool;
        DynamiteModule dynamiteModule;
        IObjectWrapper iObjectWrapper;
        zzr zzr;
        boolean z;
        Boolean valueOf;
        IObjectWrapper iObjectWrapper2;
        Context context2 = context;
        VersionPolicy versionPolicy = policy;
        String str = moduleId;
        ThreadLocal threadLocal = zzg;
        zzn zzn = (zzn) threadLocal.get();
        zzn zzn2 = new zzn((zzm) null);
        threadLocal.set(zzn2);
        ThreadLocal threadLocal2 = zzh;
        long longValue = ((Long) threadLocal2.get()).longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            VersionPolicy.SelectionResult selectModule = versionPolicy.selectModule(context2, str, zzi);
            Log.i("DynamiteModule", "Considering local module " + str + ":" + selectModule.localVersion + " and remote module " + str + ":" + selectModule.remoteVersion);
            int i2 = selectModule.selection;
            if (i2 != 0) {
                if (i2 == -1) {
                    if (selectModule.localVersion != 0) {
                        i2 = -1;
                    }
                }
                if (!(i2 == 1 && selectModule.remoteVersion == 0)) {
                    if (i2 == -1) {
                        DynamiteModule zzc2 = zzc(context2, str);
                        if (longValue == 0) {
                            threadLocal2.remove();
                        } else {
                            threadLocal2.set(Long.valueOf(longValue));
                        }
                        Cursor cursor = zzn2.zza;
                        if (cursor != null) {
                            cursor.close();
                        }
                        threadLocal.set(zzn);
                        return zzc2;
                    } else if (i2 == 1) {
                        try {
                            int i3 = selectModule.remoteVersion;
                            try {
                                synchronized (DynamiteModule.class) {
                                    if (zzf(context)) {
                                        bool = zzb;
                                    } else {
                                        throw new LoadingException("Remote loading disabled", (zzp) null);
                                    }
                                }
                                if (bool != null) {
                                    if (bool.booleanValue()) {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i3);
                                        synchronized (DynamiteModule.class) {
                                            zzr = zzl;
                                        }
                                        if (zzr != null) {
                                            zzn zzn3 = (zzn) threadLocal.get();
                                            if (zzn3 == null || zzn3.zza == null) {
                                                throw new LoadingException("No result cursor", (zzp) null);
                                            }
                                            Context applicationContext = context.getApplicationContext();
                                            Cursor cursor2 = zzn3.zza;
                                            ObjectWrapper.wrap(null);
                                            synchronized (DynamiteModule.class) {
                                                if (zze >= 2) {
                                                    z = true;
                                                } else {
                                                    z = false;
                                                }
                                                valueOf = Boolean.valueOf(z);
                                            }
                                            if (valueOf.booleanValue()) {
                                                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                iObjectWrapper2 = zzr.zzf(ObjectWrapper.wrap(applicationContext), str, i3, ObjectWrapper.wrap(cursor2));
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                iObjectWrapper2 = zzr.zze(ObjectWrapper.wrap(applicationContext), str, i3, ObjectWrapper.wrap(cursor2));
                                            }
                                            Context context3 = (Context) ObjectWrapper.unwrap(iObjectWrapper2);
                                            if (context3 != null) {
                                                dynamiteModule = new DynamiteModule(context3);
                                            } else {
                                                throw new LoadingException("Failed to get module context", (zzp) null);
                                            }
                                        } else {
                                            throw new LoadingException("DynamiteLoaderV2 was not cached.", (zzp) null);
                                        }
                                    } else {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i3);
                                        zzq zzg2 = zzg(context);
                                        if (zzg2 != null) {
                                            int zze2 = zzg2.zze();
                                            if (zze2 >= 3) {
                                                zzn zzn4 = (zzn) threadLocal.get();
                                                if (zzn4 != null) {
                                                    iObjectWrapper = zzg2.zzi(ObjectWrapper.wrap(context), str, i3, ObjectWrapper.wrap(zzn4.zza));
                                                } else {
                                                    throw new LoadingException("No cached result cursor holder", (zzp) null);
                                                }
                                            } else if (zze2 == 2) {
                                                Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                iObjectWrapper = zzg2.zzj(ObjectWrapper.wrap(context), str, i3);
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                iObjectWrapper = zzg2.zzh(ObjectWrapper.wrap(context), str, i3);
                                            }
                                            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
                                            if (unwrap != null) {
                                                dynamiteModule = new DynamiteModule((Context) unwrap);
                                            } else {
                                                throw new LoadingException("Failed to load remote module.", (zzp) null);
                                            }
                                        } else {
                                            throw new LoadingException("Failed to create IDynamiteLoader.", (zzp) null);
                                        }
                                    }
                                    if (longValue == 0) {
                                        threadLocal2.remove();
                                    } else {
                                        threadLocal2.set(Long.valueOf(longValue));
                                    }
                                    Cursor cursor3 = zzn2.zza;
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                    threadLocal.set(zzn);
                                    return dynamiteModule;
                                }
                                throw new LoadingException("Failed to determine which loading route to use.", (zzp) null);
                            } catch (RemoteException e) {
                                throw new LoadingException("Failed to load remote module.", e, (zzp) null);
                            } catch (LoadingException e2) {
                                throw e2;
                            } catch (Throwable th) {
                                CrashUtils.addDynamiteErrorToDropBox(context2, th);
                                throw new LoadingException("Failed to load remote module.", th, (zzp) null);
                            }
                        } catch (LoadingException e3) {
                            Log.w("DynamiteModule", "Failed to load remote module: " + e3.getMessage());
                            int i4 = selectModule.localVersion;
                            if (i4 != 0) {
                                if (policy.selectModule(context2, str, new zzo(i4, 0)).selection == -1) {
                                    DynamiteModule zzc3 = zzc(context2, str);
                                    if (i != 0) {
                                        zzh.set(Long.valueOf(longValue));
                                    }
                                    return zzc3;
                                }
                            }
                            throw new LoadingException("Remote load failed. No local fallback found.", e3, (zzp) null);
                        }
                    } else {
                        throw new LoadingException("VersionPolicy returned invalid code:" + i2, (zzp) null);
                    }
                }
            }
            throw new LoadingException("No acceptable module " + str + " found. Local version is " + selectModule.localVersion + " and remote version is " + selectModule.remoteVersion + ".", (zzp) null);
        } finally {
            if (longValue == 0) {
                zzh.remove();
            } else {
                zzh.set(Long.valueOf(longValue));
            }
            Cursor cursor4 = zzn2.zza;
            if (cursor4 != null) {
                cursor4.close();
            }
            zzg.set(zzn);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:48:0x008a=Splitter:B:48:0x008a, B:18:0x003d=Splitter:B:18:0x003d} */
    public static int zza(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x01b6 }
            java.lang.Boolean r1 = zzb     // Catch:{ all -> 0x01b3 }
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x00c6
            android.content.Context r1 = r10.getApplicationContext()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x00a7 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x00a7 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r4 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r4 = r4.getName()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x00a7 }
            java.lang.Class r1 = r1.loadClass(r4)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x00a7 }
            java.lang.String r4 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r4)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x00a7 }
            java.lang.Class r4 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x00a7 }
            monitor-enter(r4)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x00a7 }
            java.lang.Object r5 = r1.get(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5     // Catch:{ all -> 0x00a4 }
            java.lang.ClassLoader r6 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00a4 }
            if (r5 != r6) goto L_0x0036
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00a4 }
            goto L_0x00a2
        L_0x0036:
            if (r5 == 0) goto L_0x0040
            zzd(r5)     // Catch:{ LoadingException -> 0x003c }
            goto L_0x003d
        L_0x003c:
            r1 = move-exception
        L_0x003d:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00a4 }
            goto L_0x00a2
        L_0x0040:
            boolean r5 = zzf(r10)     // Catch:{ all -> 0x00a4 }
            if (r5 != 0) goto L_0x0049
            monitor-exit(r4)     // Catch:{ all -> 0x00a4 }
            monitor-exit(r0)     // Catch:{ all -> 0x01b3 }
            return r3
        L_0x0049:
            boolean r5 = zzd     // Catch:{ all -> 0x00a4 }
            if (r5 != 0) goto L_0x0098
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00a4 }
            boolean r5 = r5.equals(r2)     // Catch:{ all -> 0x00a4 }
            if (r5 == 0) goto L_0x0056
            goto L_0x0098
        L_0x0056:
            r5 = 1
            int r5 = zzb(r10, r11, r12, r5)     // Catch:{ LoadingException -> 0x008d }
            java.lang.String r6 = zzc     // Catch:{ LoadingException -> 0x008d }
            if (r6 == 0) goto L_0x008a
            boolean r6 = r6.isEmpty()     // Catch:{ LoadingException -> 0x008d }
            if (r6 == 0) goto L_0x0067
            goto L_0x008a
        L_0x0067:
            java.lang.ClassLoader r6 = com.google.android.gms.dynamite.zzb.zza()     // Catch:{ LoadingException -> 0x008d }
            if (r6 == 0) goto L_0x006e
            goto L_0x007d
        L_0x006e:
            dalvik.system.DelegateLastClassLoader r6 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x008d }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x008d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ LoadingException -> 0x008d }
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x008d }
            r6.<init>(r7, r8)     // Catch:{ LoadingException -> 0x008d }
        L_0x007d:
            zzd(r6)     // Catch:{ LoadingException -> 0x008d }
            r1.set(r2, r6)     // Catch:{ LoadingException -> 0x008d }
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x008d }
            zzb = r6     // Catch:{ LoadingException -> 0x008d }
            monitor-exit(r4)     // Catch:{ all -> 0x00a4 }
            monitor-exit(r0)     // Catch:{ all -> 0x01b3 }
            return r5
        L_0x008a:
            monitor-exit(r4)     // Catch:{ all -> 0x00a4 }
            monitor-exit(r0)     // Catch:{ all -> 0x01b3 }
            return r5
        L_0x008d:
            r5 = move-exception
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00a4 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00a4 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00a4 }
            goto L_0x00a2
        L_0x0098:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00a4 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00a4 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00a4 }
        L_0x00a2:
            monitor-exit(r4)     // Catch:{ all -> 0x00a4 }
            goto L_0x00c4
        L_0x00a4:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00a4 }
            throw r1     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x00a7 }
        L_0x00a7:
            r1 = move-exception
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01b3 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b3 }
            r4.<init>()     // Catch:{ all -> 0x01b3 }
            java.lang.String r5 = "Failed to load module via V2: "
            r4.append(r5)     // Catch:{ all -> 0x01b3 }
            r4.append(r1)     // Catch:{ all -> 0x01b3 }
            java.lang.String r1 = "DynamiteModule"
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01b3 }
            android.util.Log.w(r1, r4)     // Catch:{ all -> 0x01b3 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01b3 }
        L_0x00c4:
            zzb = r1     // Catch:{ all -> 0x01b3 }
        L_0x00c6:
            monitor-exit(r0)     // Catch:{ all -> 0x01b3 }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x01b6 }
            if (r0 == 0) goto L_0x00ee
            int r10 = zzb(r10, r11, r12, r3)     // Catch:{ LoadingException -> 0x00d2 }
            return r10
        L_0x00d2:
            r11 = move-exception
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x01b6 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b6 }
            r12.<init>()     // Catch:{ all -> 0x01b6 }
            java.lang.String r0 = "Failed to retrieve remote module version: "
            r12.append(r0)     // Catch:{ all -> 0x01b6 }
            r12.append(r11)     // Catch:{ all -> 0x01b6 }
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x01b6 }
            android.util.Log.w(r11, r12)     // Catch:{ all -> 0x01b6 }
            return r3
        L_0x00ee:
            com.google.android.gms.dynamite.zzq r4 = zzg(r10)     // Catch:{ all -> 0x01b6 }
            if (r4 != 0) goto L_0x00f6
            goto L_0x01aa
        L_0x00f6:
            int r0 = r4.zze()     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            r1 = 3
            if (r0 < r1) goto L_0x0161
            java.lang.ThreadLocal r0 = zzg     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            com.google.android.gms.dynamite.zzn r0 = (com.google.android.gms.dynamite.zzn) r0     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            if (r0 == 0) goto L_0x0111
            android.database.Cursor r0 = r0.zza     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            if (r0 == 0) goto L_0x0111
            int r3 = r0.getInt(r3)     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            goto L_0x01aa
        L_0x0111:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            java.lang.ThreadLocal r0 = zzh     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            long r8 = r0.longValue()     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            r6 = r11
            r7 = r12
            com.google.android.gms.dynamic.IObjectWrapper r11 = r4.zzk(r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            java.lang.Object r11 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r11)     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            if (r11 == 0) goto L_0x014e
            boolean r12 = r11.moveToFirst()     // Catch:{ RemoteException -> 0x015e, all -> 0x015b }
            if (r12 != 0) goto L_0x0136
            goto L_0x014e
        L_0x0136:
            int r12 = r11.getInt(r3)     // Catch:{ RemoteException -> 0x015e, all -> 0x015b }
            if (r12 <= 0) goto L_0x0144
            boolean r0 = zze(r11)     // Catch:{ RemoteException -> 0x015e, all -> 0x015b }
            if (r0 == 0) goto L_0x0144
            goto L_0x0146
        L_0x0144:
            r2 = r11
        L_0x0146:
            if (r2 == 0) goto L_0x014b
            r2.close()     // Catch:{ all -> 0x01b6 }
        L_0x014b:
            r3 = r12
            goto L_0x01aa
        L_0x014e:
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r12, r0)     // Catch:{ RemoteException -> 0x015e, all -> 0x015b }
            if (r11 == 0) goto L_0x01a8
            r11.close()     // Catch:{ all -> 0x01b6 }
            goto L_0x01a8
        L_0x015b:
            r12 = move-exception
            r2 = r11
            goto L_0x01ad
        L_0x015e:
            r12 = move-exception
            r2 = r11
            goto L_0x0189
        L_0x0161:
            r1 = 2
            if (r0 != r1) goto L_0x0174
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version = 2, no high precision latency measurement."
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            int r3 = r4.zzg(r0, r11, r12)     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            goto L_0x01aa
        L_0x0174:
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            int r3 = r4.zzf(r0, r11, r12)     // Catch:{ RemoteException -> 0x0187, all -> 0x0184 }
            goto L_0x01aa
        L_0x0184:
            r11 = move-exception
            r12 = r11
            goto L_0x01ad
        L_0x0187:
            r11 = move-exception
            r12 = r11
        L_0x0189:
            java.lang.String r11 = r12.getMessage()     // Catch:{ all -> 0x01ab }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ab }
            r12.<init>()     // Catch:{ all -> 0x01ab }
            java.lang.String r0 = "Failed to retrieve remote module version: "
            r12.append(r0)     // Catch:{ all -> 0x01ab }
            r12.append(r11)     // Catch:{ all -> 0x01ab }
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x01ab }
            android.util.Log.w(r11, r12)     // Catch:{ all -> 0x01ab }
            if (r2 == 0) goto L_0x01a9
            r2.close()     // Catch:{ all -> 0x01b6 }
        L_0x01a8:
            goto L_0x01aa
        L_0x01a9:
        L_0x01aa:
            return r3
        L_0x01ab:
            r11 = move-exception
            r12 = r11
        L_0x01ad:
            if (r2 == 0) goto L_0x01b2
            r2.close()     // Catch:{ all -> 0x01b6 }
        L_0x01b2:
            throw r12     // Catch:{ all -> 0x01b6 }
        L_0x01b3:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01b3 }
            throw r11     // Catch:{ all -> 0x01b6 }
        L_0x01b6:
            r11 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r10, r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c8 A[Catch:{ all -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c9 A[Catch:{ all -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(android.content.Context r10, java.lang.String r11, boolean r12, boolean r13) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            java.lang.ThreadLocal r1 = zzh     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.String r10 = "api_force_staging"
            java.lang.String r4 = "api"
            r9 = 1
            if (r9 == r12) goto L_0x0019
            r10 = r4
        L_0x0019:
            android.net.Uri$Builder r12 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            r12.<init>()     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r12 = r12.scheme(r4)     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r12 = r12.authority(r4)     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            android.net.Uri$Builder r10 = r12.path(r10)     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            android.net.Uri$Builder r10 = r10.appendPath(r11)     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            java.lang.String r11 = "requestStartTime"
            java.lang.String r12 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            android.net.Uri$Builder r10 = r10.appendQueryParameter(r11, r12)     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            android.net.Uri r4 = r10.build()     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00c1, all -> 0x00be }
            if (r10 == 0) goto L_0x00aa
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            if (r11 == 0) goto L_0x00aa
            r11 = 0
            int r12 = r10.getInt(r11)     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            if (r12 <= 0) goto L_0x0091
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            r2 = 2
            java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x008e }
            zzc = r2     // Catch:{ all -> 0x008e }
            java.lang.String r2 = "loaderVersion"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008e }
            if (r2 < 0) goto L_0x0070
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008e }
            zze = r2     // Catch:{ all -> 0x008e }
        L_0x0070:
            java.lang.String r2 = "disableStandaloneDynamiteLoader2"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008e }
            if (r2 < 0) goto L_0x0084
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008e }
            if (r2 == 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r9 = r11
        L_0x0080:
            zzd = r9     // Catch:{ all -> 0x008e }
            r11 = r9
            goto L_0x0085
        L_0x0084:
        L_0x0085:
            monitor-exit(r1)     // Catch:{ all -> 0x008e }
            boolean r1 = zze(r10)     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            if (r1 == 0) goto L_0x0092
            r10 = r0
            goto L_0x0092
        L_0x008e:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008e }
            throw r11     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
        L_0x0091:
        L_0x0092:
            if (r13 == 0) goto L_0x00a4
            if (r11 != 0) goto L_0x0097
            goto L_0x00a4
        L_0x0097:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x00a2, all -> 0x009f }
            java.lang.String r12 = "forcing fallback to container DynamiteLoader impl"
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x00a2, all -> 0x009f }
            throw r11     // Catch:{ Exception -> 0x00a2, all -> 0x009f }
        L_0x009f:
            r11 = move-exception
            r0 = r10
            goto L_0x00d3
        L_0x00a2:
            r11 = move-exception
            goto L_0x00c4
        L_0x00a4:
            if (r10 == 0) goto L_0x00a9
            r10.close()
        L_0x00a9:
            return r12
        L_0x00aa:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = "Failed to retrieve remote module version."
            android.util.Log.w(r11, r12)     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            java.lang.String r12 = "Failed to connect to dynamite module ContentResolver."
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
            throw r11     // Catch:{ Exception -> 0x00bc, all -> 0x00b9 }
        L_0x00b9:
            r11 = move-exception
            r0 = r10
            goto L_0x00d3
        L_0x00bc:
            r11 = move-exception
            goto L_0x00c4
        L_0x00be:
            r10 = move-exception
            r11 = r10
            goto L_0x00d3
        L_0x00c1:
            r10 = move-exception
            r11 = r10
            r10 = r0
        L_0x00c4:
            boolean r12 = r11 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00d1 }
            if (r12 == 0) goto L_0x00c9
            throw r11     // Catch:{ all -> 0x00d1 }
        L_0x00c9:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r12 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00d1 }
            java.lang.String r13 = "V2 version check failed"
            r12.<init>(r13, r11, r0)     // Catch:{ all -> 0x00d1 }
            throw r12     // Catch:{ all -> 0x00d1 }
        L_0x00d1:
            r11 = move-exception
            r0 = r10
        L_0x00d3:
            if (r0 == 0) goto L_0x00d8
            r0.close()
        L_0x00d8:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzr;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzr = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    zzr = (zzr) queryLocalInterface;
                } else {
                    zzr = new zzr(iBinder);
                }
            }
            zzl = zzr;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zzp) null);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzn zzn = (zzn) zzg.get();
        if (zzn == null || zzn.zza != null) {
            return false;
        }
        zzn.zza = cursor;
        return true;
    }

    private static boolean zzf(Context context) {
        if (Boolean.TRUE.equals((Object) null) || Boolean.TRUE.equals(zzf)) {
            return true;
        }
        boolean z = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            zzf = valueOf;
            z = valueOf.booleanValue();
            if (z && resolveContentProvider != null && resolveContentProvider.applicationInfo != null && (resolveContentProvider.applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    private static zzq zzg(Context context) {
        zzq zzq;
        synchronized (DynamiteModule.class) {
            zzq zzq2 = zzk;
            if (zzq2 != null) {
                return zzq2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzq = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzq = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzq(iBinder);
                }
                if (zzq != null) {
                    zzk = zzq;
                    return zzq;
                }
            } catch (Exception e) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage());
            }
        }
        return null;
    }

    public Context getModuleContext() {
        return this.zzj;
    }

    public IBinder instantiate(String className) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(className).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(className)), e, (zzp) null);
        }
    }
}

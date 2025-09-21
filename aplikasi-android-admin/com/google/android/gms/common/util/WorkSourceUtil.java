package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class WorkSourceUtil {
    private static final int zza = Process.myUid();
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;
    private static final Method zzh;
    private static final Method zzi;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061 A[SYNTHETIC, Splitter:B:23:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c0  */
    static {
        /*
            java.lang.String r0 = "add"
            int r1 = android.os.Process.myUid()
            zza = r1
            r1 = 1
            r2 = 0
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0018 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0018 }
            r4[r2] = r5     // Catch:{ Exception -> 0x0018 }
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.reflect.Method r4 = r5.getMethod(r0, r4)     // Catch:{ Exception -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            r4 = move-exception
            r4 = r3
        L_0x001a:
            zzb = r4
            boolean r4 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            r5 = 2
            if (r4 == 0) goto L_0x0035
            java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0034 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0034 }
            r4[r2] = r6     // Catch:{ Exception -> 0x0034 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r4[r1] = r6     // Catch:{ Exception -> 0x0034 }
            java.lang.Class<android.os.WorkSource> r6 = android.os.WorkSource.class
            java.lang.reflect.Method r0 = r6.getMethod(r0, r4)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0036
        L_0x0034:
            r0 = move-exception
        L_0x0035:
            r0 = r3
        L_0x0036:
            zzc = r0
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r4 = "size"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0044 }
            java.lang.reflect.Method r0 = r0.getMethod(r4, r6)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r0 = r3
        L_0x0046:
            zzd = r0
            java.lang.Class[] r0 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0057 }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0057 }
            r0[r2] = r4     // Catch:{ Exception -> 0x0057 }
            java.lang.Class<android.os.WorkSource> r4 = android.os.WorkSource.class
            java.lang.String r6 = "get"
            java.lang.reflect.Method r0 = r4.getMethod(r6, r0)     // Catch:{ Exception -> 0x0057 }
            goto L_0x0059
        L_0x0057:
            r0 = move-exception
            r0 = r3
        L_0x0059:
            zze = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            if (r0 == 0) goto L_0x0071
            java.lang.Class[] r0 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0070 }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0070 }
            r0[r2] = r4     // Catch:{ Exception -> 0x0070 }
            java.lang.Class<android.os.WorkSource> r4 = android.os.WorkSource.class
            java.lang.String r6 = "getName"
            java.lang.reflect.Method r0 = r4.getMethod(r6, r0)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0072
        L_0x0070:
            r0 = move-exception
        L_0x0071:
            r0 = r3
        L_0x0072:
            zzf = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            java.lang.String r4 = "WorkSourceUtil"
            if (r0 == 0) goto L_0x008f
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r6 = "createWorkChain"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0087 }
            java.lang.reflect.Method r0 = r0.getMethod(r6, r7)     // Catch:{ Exception -> 0x0087 }
            goto L_0x0090
        L_0x0087:
            r0 = move-exception
            java.lang.String r6 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r4, r6, r0)
            r0 = r3
            goto L_0x0090
        L_0x008f:
            r0 = r3
        L_0x0090:
            zzg = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = "android.os.WorkSource$WorkChain"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x00af }
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x00af }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00af }
            r5[r2] = r6     // Catch:{ Exception -> 0x00af }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r1] = r6     // Catch:{ Exception -> 0x00af }
            java.lang.String r6 = "addNode"
            java.lang.reflect.Method r0 = r0.getMethod(r6, r5)     // Catch:{ Exception -> 0x00af }
            goto L_0x00b8
        L_0x00af:
            r0 = move-exception
            java.lang.String r5 = "Missing WorkChain class"
            android.util.Log.w(r4, r5, r0)
            r0 = r3
            goto L_0x00b8
        L_0x00b7:
            r0 = r3
        L_0x00b8:
            zzh = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L_0x00d0
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r4 = "isEmpty"
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x00ce }
            java.lang.reflect.Method r3 = r0.getMethod(r4, r2)     // Catch:{ Exception -> 0x00ce }
            r3.setAccessible(r1)     // Catch:{ Exception -> 0x00ce }
            goto L_0x00d0
        L_0x00ce:
            r0 = move-exception
            goto L_0x00d1
        L_0x00d0:
        L_0x00d1:
            zzi = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    private WorkSourceUtil() {
    }

    public static void add(WorkSource workSource, int uid, String packageName) {
        Method method = zzc;
        if (method != null) {
            if (packageName == null) {
                packageName = "";
            }
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(uid), packageName});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        } else {
            Method method2 = zzb;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(uid)});
                } catch (Exception e2) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                }
            }
        }
    }

    public static WorkSource fromPackage(Context context, String packageName) {
        if (context == null || context.getPackageManager() == null || packageName == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(packageName, 0);
            if (applicationInfo == null) {
                Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(packageName));
                return null;
            }
            int i = applicationInfo.uid;
            WorkSource workSource = new WorkSource();
            add(workSource, i, packageName);
            return workSource;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("WorkSourceUtil", "Could not find package: ".concat(packageName));
            return null;
        }
    }

    public static WorkSource fromPackageAndModuleExperimentalPi(Context context, String packageName, String moduleName) {
        Method method;
        if (context == null || context.getPackageManager() == null || moduleName == null || packageName == null) {
            Log.w("WorkSourceUtil", "Unexpected null arguments");
            return null;
        }
        int i = -1;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(packageName, 0);
            if (applicationInfo == null) {
                Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(packageName));
            } else {
                i = applicationInfo.uid;
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("WorkSourceUtil", "Could not find package: ".concat(packageName));
        }
        if (i < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method2 = zzg;
        if (method2 == null || (method = zzh) == null) {
            add(workSource, i, packageName);
        } else {
            try {
                Object invoke = method2.invoke(workSource, new Object[0]);
                int i2 = zza;
                if (i != i2) {
                    method.invoke(invoke, new Object[]{Integer.valueOf(i), packageName});
                }
                method.invoke(invoke, new Object[]{Integer.valueOf(i2), moduleName});
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e2);
            }
        }
        return workSource;
    }

    public static int get(WorkSource workSource, int i) {
        Method method = zze;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[]{Integer.valueOf(i)});
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    public static String getName(WorkSource workSource, int i) {
        Method method = zzf;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, new Object[]{Integer.valueOf(i)});
        } catch (Exception e) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            return null;
        }
    }

    public static List<String> getNames(WorkSource workSource) {
        int i;
        ArrayList arrayList = new ArrayList();
        if (workSource == null) {
            i = 0;
        } else {
            i = size(workSource);
        }
        if (i != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                String name = getName(workSource, i2);
                if (!Strings.isEmptyOrWhitespace(name)) {
                    Preconditions.checkNotNull(name);
                    arrayList.add(name);
                }
            }
        }
        return arrayList;
    }

    public static boolean hasWorkSourcePermission(Context context) {
        if (context == null || context.getPackageManager() == null || Wrappers.packageManager(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(WorkSource workSource) {
        Method method = zzi;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                Preconditions.checkNotNull(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception e) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e);
            }
        }
        if (size(workSource) == 0) {
            return true;
        }
        return false;
    }

    public static int size(WorkSource workSource) {
        Method method = zzd;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }
}

package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;

public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    private AppOpsManagerCompat() {
    }

    public static String permissionToOp(String permission) {
        return Api23Impl.permissionToOp(permission);
    }

    public static int noteOp(Context context, String op, int uid, String packageName) {
        return Api19Impl.noteOp((AppOpsManager) context.getSystemService("appops"), op, uid, packageName);
    }

    public static int noteOpNoThrow(Context context, String op, int uid, String packageName) {
        return Api19Impl.noteOpNoThrow((AppOpsManager) context.getSystemService("appops"), op, uid, packageName);
    }

    public static int noteProxyOp(Context context, String op, String proxiedPackageName) {
        return Api23Impl.noteProxyOp((AppOpsManager) Api23Impl.getSystemService(context, AppOpsManager.class), op, proxiedPackageName);
    }

    public static int noteProxyOpNoThrow(Context context, String op, String proxiedPackageName) {
        return Api23Impl.noteProxyOpNoThrow((AppOpsManager) Api23Impl.getSystemService(context, AppOpsManager.class), op, proxiedPackageName);
    }

    public static int checkOrNoteProxyOp(Context context, int proxyUid, String op, String proxiedPackageName) {
        AppOpsManager appOpsManager = Api29Impl.getSystemService(context);
        int checkProxiedOpResult = Api29Impl.checkOpNoThrow(appOpsManager, op, Binder.getCallingUid(), proxiedPackageName);
        if (checkProxiedOpResult != 0) {
            return checkProxiedOpResult;
        }
        return Api29Impl.checkOpNoThrow(appOpsManager, op, proxyUid, Api29Impl.getOpPackageName(context));
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static AppOpsManager getSystemService(Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }

        static int checkOpNoThrow(AppOpsManager appOpsManager, String op, int uid, String packageName) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(op, uid, packageName);
        }

        static String getOpPackageName(Context context) {
            return context.getOpPackageName();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static String permissionToOp(String permission) {
            return AppOpsManager.permissionToOp(permission);
        }

        static <T> T getSystemService(Context context, Class<T> serviceClass) {
            return context.getSystemService(serviceClass);
        }

        static int noteProxyOp(AppOpsManager appOpsManager, String op, String proxiedPackageName) {
            return appOpsManager.noteProxyOp(op, proxiedPackageName);
        }

        static int noteProxyOpNoThrow(AppOpsManager appOpsManager, String op, String proxiedPackageName) {
            return appOpsManager.noteProxyOpNoThrow(op, proxiedPackageName);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static int noteOpNoThrow(AppOpsManager appOpsManager, String op, int uid, String packageName) {
            return appOpsManager.noteOpNoThrow(op, uid, packageName);
        }

        static int noteOp(AppOpsManager appOpsManager, String op, int uid, String packageName) {
            return appOpsManager.noteOp(op, uid, packageName);
        }
    }
}

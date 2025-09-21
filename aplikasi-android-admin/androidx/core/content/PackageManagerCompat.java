package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PackageManagerCompat {
    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";
    public static final String LOG_TAG = "PackageManagerCompat";

    @Retention(RetentionPolicy.SOURCE)
    public @interface UnusedAppRestrictionsStatus {
    }

    private PackageManagerCompat() {
    }

    public static ListenableFuture<Integer> getUnusedAppRestrictionsStatus(Context context) {
        ResolvableFuture<Integer> resultFuture = ResolvableFuture.create();
        if (!UserManagerCompat.isUserUnlocked(context)) {
            resultFuture.set(0);
            Log.e(LOG_TAG, "User is in locked direct boot mode");
            return resultFuture;
        } else if (!areUnusedAppRestrictionsAvailable(context.getPackageManager())) {
            resultFuture.set(1);
            return resultFuture;
        } else {
            int targetSdkVersion = context.getApplicationInfo().targetSdkVersion;
            if (targetSdkVersion < 30) {
                resultFuture.set(0);
                Log.e(LOG_TAG, "Target SDK version below API 30");
                return resultFuture;
            }
            if (Api30Impl.areUnusedAppRestrictionsEnabled(context)) {
                resultFuture.set(Integer.valueOf(targetSdkVersion >= 31 ? 5 : 4));
            } else {
                resultFuture.set(2);
            }
            return resultFuture;
        }
    }

    public static boolean areUnusedAppRestrictionsAvailable(PackageManager packageManager) {
        boolean hasBackportFeature = getPermissionRevocationVerifierApp(packageManager) != null;
        if (1 != 0) {
            return true;
        }
        if (0 == 0 || !hasBackportFeature) {
            return false;
        }
        return true;
    }

    public static String getPermissionRevocationVerifierApp(PackageManager packageManager) {
        String verifierPackageName = null;
        for (ResolveInfo intentResolver : packageManager.queryIntentActivities(new Intent(ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", "com.example", (String) null)), 0)) {
            String packageName = intentResolver.activityInfo.packageName;
            if (packageManager.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", packageName) == 0) {
                if (verifierPackageName != null) {
                    return verifierPackageName;
                }
                verifierPackageName = packageName;
            }
        }
        return verifierPackageName;
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static boolean areUnusedAppRestrictionsEnabled(Context context) {
            return !context.getPackageManager().isAutoRevokeWhitelisted();
        }
    }
}

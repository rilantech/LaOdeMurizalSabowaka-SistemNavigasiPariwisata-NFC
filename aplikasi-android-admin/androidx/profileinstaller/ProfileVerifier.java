package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public final class ProfileVerifier {
    private static final String CUR_PROFILES_BASE_DIR = "/data/misc/profiles/cur/0/";
    private static final String PROFILE_FILE_NAME = "primary.prof";
    private static final String PROFILE_INSTALLED_CACHE_FILE_NAME = "profileInstalled";
    private static final String REF_PROFILES_BASE_DIR = "/data/misc/profiles/ref/";
    private static final Object SYNC_OBJ = new Object();
    private static final String TAG = "ProfileVerifier";
    private static CompilationStatus sCompilationStatus = null;
    private static final ResolvableFuture<CompilationStatus> sFuture = ResolvableFuture.create();

    private ProfileVerifier() {
    }

    public static CompilationStatus writeProfileVerification(Context context) {
        return writeProfileVerification(context, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x00bd A[Catch:{ IOException -> 0x0082, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c6 A[Catch:{ IOException -> 0x0082, all -> 0x0012 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.profileinstaller.ProfileVerifier.CompilationStatus writeProfileVerification(android.content.Context r22, boolean r23) {
        /*
            if (r23 != 0) goto L_0x0007
            androidx.profileinstaller.ProfileVerifier$CompilationStatus r0 = sCompilationStatus
            if (r0 == 0) goto L_0x0007
            return r0
        L_0x0007:
            java.lang.Object r1 = SYNC_OBJ
            monitor-enter(r1)
            if (r23 != 0) goto L_0x0015
            androidx.profileinstaller.ProfileVerifier$CompilationStatus r0 = sCompilationStatus     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0015
            monitor-exit(r1)     // Catch:{ all -> 0x0012 }
            return r0
        L_0x0012:
            r0 = move-exception
            goto L_0x0101
        L_0x0015:
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0012 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0012 }
            java.lang.String r3 = "/data/misc/profiles/ref/"
            java.lang.String r4 = r22.getPackageName()     // Catch:{ all -> 0x0012 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0012 }
            java.lang.String r3 = "primary.prof"
            r0.<init>(r2, r3)     // Catch:{ all -> 0x0012 }
            r2 = r0
            long r3 = r2.length()     // Catch:{ all -> 0x0012 }
            boolean r0 = r2.exists()     // Catch:{ all -> 0x0012 }
            r5 = 0
            r7 = 0
            if (r0 == 0) goto L_0x003d
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x003d
            r0 = 1
            goto L_0x003e
        L_0x003d:
            r0 = r7
        L_0x003e:
            r9 = r0
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0012 }
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x0012 }
            java.lang.String r11 = "/data/misc/profiles/cur/0/"
            java.lang.String r12 = r22.getPackageName()     // Catch:{ all -> 0x0012 }
            r10.<init>(r11, r12)     // Catch:{ all -> 0x0012 }
            java.lang.String r11 = "primary.prof"
            r0.<init>(r10, r11)     // Catch:{ all -> 0x0012 }
            r10 = r0
            long r11 = r10.length()     // Catch:{ all -> 0x0012 }
            boolean r0 = r10.exists()     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0062
            int r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0062
            r7 = 1
        L_0x0062:
            r5 = r7
            long r6 = getPackageLastUpdateTime(r22)     // Catch:{ NameNotFoundException -> 0x00f3 }
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0012 }
            java.io.File r13 = r22.getFilesDir()     // Catch:{ all -> 0x0012 }
            java.lang.String r14 = "profileInstalled"
            r0.<init>(r13, r14)     // Catch:{ all -> 0x0012 }
            r15 = r0
            r13 = 0
            boolean r0 = r15.exists()     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x008d
            androidx.profileinstaller.ProfileVerifier$Cache r0 = androidx.profileinstaller.ProfileVerifier.Cache.readFromFile(r15)     // Catch:{ IOException -> 0x0082 }
            r13 = r0
            r14 = r13
            goto L_0x008e
        L_0x0082:
            r0 = move-exception
            r8 = r0
            r0 = r8
            r8 = 131072(0x20000, float:1.83671E-40)
            androidx.profileinstaller.ProfileVerifier$CompilationStatus r8 = setCompilationStatus(r8, r9, r5)     // Catch:{ all -> 0x0012 }
            monitor-exit(r1)     // Catch:{ all -> 0x0012 }
            return r8
        L_0x008d:
            r14 = r13
        L_0x008e:
            r0 = 2
            if (r14 == 0) goto L_0x00a1
            r20 = r9
            long r8 = r14.mPackageLastUpdateTime     // Catch:{ all -> 0x0012 }
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x00a3
            int r8 = r14.mResultCode     // Catch:{ all -> 0x0012 }
            if (r8 != r0) goto L_0x009e
            goto L_0x00a3
        L_0x009e:
            int r8 = r14.mResultCode     // Catch:{ all -> 0x0012 }
            goto L_0x00ac
        L_0x00a1:
            r20 = r9
        L_0x00a3:
            if (r20 == 0) goto L_0x00a7
            r8 = 1
            goto L_0x00ac
        L_0x00a7:
            if (r5 == 0) goto L_0x00ab
            r8 = 2
            goto L_0x00ac
        L_0x00ab:
            r8 = 0
        L_0x00ac:
            if (r23 == 0) goto L_0x00b4
            if (r5 == 0) goto L_0x00b4
            r9 = 1
            if (r8 == r9) goto L_0x00b4
            r8 = 2
        L_0x00b4:
            if (r14 == 0) goto L_0x00c6
            int r9 = r14.mResultCode     // Catch:{ all -> 0x0012 }
            if (r9 != r0) goto L_0x00c6
            r0 = 1
            if (r8 != r0) goto L_0x00c6
            r0 = r8
            long r8 = r14.mInstalledCurrentProfileSize     // Catch:{ all -> 0x0012 }
            int r8 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x00c7
            r8 = 3
            goto L_0x00c8
        L_0x00c6:
            r0 = r8
        L_0x00c7:
            r8 = r0
        L_0x00c8:
            androidx.profileinstaller.ProfileVerifier$Cache r0 = new androidx.profileinstaller.ProfileVerifier$Cache     // Catch:{ all -> 0x0012 }
            r9 = 1
            r13 = r0
            r21 = r2
            r2 = r14
            r14 = r9
            r9 = r15
            r15 = r8
            r16 = r6
            r18 = r11
            r13.<init>(r14, r15, r16, r18)     // Catch:{ all -> 0x0012 }
            r13 = r0
            if (r2 == 0) goto L_0x00e2
            boolean r0 = r2.equals(r13)     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x00eb
        L_0x00e2:
            r13.writeOnFile(r9)     // Catch:{ IOException -> 0x00e6 }
            goto L_0x00eb
        L_0x00e6:
            r0 = move-exception
            r14 = r0
            r0 = r14
            r8 = 196608(0x30000, float:2.75506E-40)
        L_0x00eb:
            r14 = r20
            androidx.profileinstaller.ProfileVerifier$CompilationStatus r0 = setCompilationStatus(r8, r14, r5)     // Catch:{ all -> 0x0012 }
            monitor-exit(r1)     // Catch:{ all -> 0x0012 }
            return r0
        L_0x00f3:
            r0 = move-exception
            r21 = r2
            r14 = r9
            r2 = r0
            r0 = r2
            r2 = 65536(0x10000, float:9.18355E-41)
            androidx.profileinstaller.ProfileVerifier$CompilationStatus r2 = setCompilationStatus(r2, r14, r5)     // Catch:{ all -> 0x0012 }
            monitor-exit(r1)     // Catch:{ all -> 0x0012 }
            return r2
        L_0x0101:
            monitor-exit(r1)     // Catch:{ all -> 0x0012 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.ProfileVerifier.writeProfileVerification(android.content.Context, boolean):androidx.profileinstaller.ProfileVerifier$CompilationStatus");
    }

    private static CompilationStatus setCompilationStatus(int resultCode, boolean hasReferenceProfile, boolean hasCurrentProfile) {
        CompilationStatus compilationStatus = new CompilationStatus(resultCode, hasReferenceProfile, hasCurrentProfile);
        sCompilationStatus = compilationStatus;
        sFuture.set(compilationStatus);
        return sCompilationStatus;
    }

    private static long getPackageLastUpdateTime(Context context) throws PackageManager.NameNotFoundException {
        return Api33Impl.getPackageInfo(context.getApplicationContext().getPackageManager(), context).lastUpdateTime;
    }

    public static ListenableFuture<CompilationStatus> getCompilationStatusAsync() {
        return sFuture;
    }

    static class Cache {
        private static final int SCHEMA = 1;
        final long mInstalledCurrentProfileSize;
        final long mPackageLastUpdateTime;
        final int mResultCode;
        final int mSchema;

        Cache(int schema, int resultCode, long packageLastUpdateTime, long installedCurrentProfileSize) {
            this.mSchema = schema;
            this.mResultCode = resultCode;
            this.mPackageLastUpdateTime = packageLastUpdateTime;
            this.mInstalledCurrentProfileSize = installedCurrentProfileSize;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || !(o instanceof Cache)) {
                return false;
            }
            Cache cacheFile = (Cache) o;
            if (this.mResultCode == cacheFile.mResultCode && this.mPackageLastUpdateTime == cacheFile.mPackageLastUpdateTime && this.mSchema == cacheFile.mSchema && this.mInstalledCurrentProfileSize == cacheFile.mInstalledCurrentProfileSize) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mResultCode), Long.valueOf(this.mPackageLastUpdateTime), Integer.valueOf(this.mSchema), Long.valueOf(this.mInstalledCurrentProfileSize)});
        }

        /* access modifiers changed from: package-private */
        public void writeOnFile(File file) throws IOException {
            file.delete();
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
            try {
                dos.writeInt(this.mSchema);
                dos.writeInt(this.mResultCode);
                dos.writeLong(this.mPackageLastUpdateTime);
                dos.writeLong(this.mInstalledCurrentProfileSize);
                dos.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        static Cache readFromFile(File file) throws IOException {
            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            try {
                Cache cache = new Cache(dis.readInt(), dis.readInt(), dis.readLong(), dis.readLong());
                dis.close();
                return cache;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }
    }

    public static class CompilationStatus {
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE = 1;
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE_NON_MATCHING = 3;
        public static final int RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ = 131072;
        public static final int RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE = 196608;
        private static final int RESULT_CODE_ERROR_CODE_BIT_SHIFT = 16;
        public static final int RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST = 65536;
        public static final int RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION = 262144;
        public static final int RESULT_CODE_NO_PROFILE = 0;
        public static final int RESULT_CODE_PROFILE_ENQUEUED_FOR_COMPILATION = 2;
        private final boolean mHasCurrentProfile;
        private final boolean mHasReferenceProfile;
        final int mResultCode;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultCode {
        }

        CompilationStatus(int resultCode, boolean hasReferenceProfile, boolean hasCurrentProfile) {
            this.mResultCode = resultCode;
            this.mHasCurrentProfile = hasCurrentProfile;
            this.mHasReferenceProfile = hasReferenceProfile;
        }

        public int getProfileInstallResultCode() {
            return this.mResultCode;
        }

        public boolean isCompiledWithProfile() {
            return this.mHasReferenceProfile;
        }

        public boolean hasProfileEnqueuedForCompilation() {
            return this.mHasCurrentProfile;
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        static PackageInfo getPackageInfo(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }
}

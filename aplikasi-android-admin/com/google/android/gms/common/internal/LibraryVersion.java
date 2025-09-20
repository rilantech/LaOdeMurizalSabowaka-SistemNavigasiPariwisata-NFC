package com.google.android.gms.common.internal;

import java.util.concurrent.ConcurrentHashMap;

@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class LibraryVersion {
    private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    private static LibraryVersion zzb = new LibraryVersion();
    private ConcurrentHashMap zzc = new ConcurrentHashMap();

    protected LibraryVersion() {
    }

    public static LibraryVersion getInstance() {
        return zzb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ac  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getVersion(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "Failed to get app version for libraryName: "
            java.lang.String r1 = "LibraryVersion"
            java.lang.String r2 = "Please provide a valid libraryName"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9, r2)
            java.util.concurrent.ConcurrentHashMap r2 = r8.zzc
            boolean r2 = r2.containsKey(r9)
            if (r2 == 0) goto L_0x001a
            java.util.concurrent.ConcurrentHashMap r0 = r8.zzc
            java.lang.Object r9 = r0.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            return r9
        L_0x001a:
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[]{r9}     // Catch:{ IOException -> 0x007a, all -> 0x0078 }
            java.lang.Class<com.google.android.gms.common.internal.LibraryVersion> r5 = com.google.android.gms.common.internal.LibraryVersion.class
            java.lang.String r6 = "/%s.properties"
            java.lang.String r4 = java.lang.String.format(r6, r4)     // Catch:{ IOException -> 0x007a, all -> 0x0078 }
            java.io.InputStream r4 = r5.getResourceAsStream(r4)     // Catch:{ IOException -> 0x007a, all -> 0x0078 }
            if (r4 == 0) goto L_0x0056
            r2.load(r4)     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            java.lang.String r5 = "version"
            java.lang.String r3 = r2.getProperty(r5, r3)     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            com.google.android.gms.common.internal.GmsLogger r2 = zza     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            r5.<init>()     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            r5.append(r9)     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            java.lang.String r6 = " version is "
            r5.append(r6)     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            r5.append(r3)     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            r2.v(r1, r5)     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            goto L_0x006a
        L_0x0056:
            com.google.android.gms.common.internal.GmsLogger r2 = zza     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            r5.<init>()     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            r5.append(r0)     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            r5.append(r9)     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            r2.w(r1, r5)     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
        L_0x006a:
            if (r4 == 0) goto L_0x0098
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)
            goto L_0x0098
        L_0x0070:
            r9 = move-exception
            r3 = r4
            goto L_0x00aa
        L_0x0073:
            r2 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
            goto L_0x007c
        L_0x0078:
            r9 = move-exception
            goto L_0x00aa
        L_0x007a:
            r2 = move-exception
            r4 = r3
        L_0x007c:
            com.google.android.gms.common.internal.GmsLogger r5 = zza     // Catch:{ all -> 0x00a9 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
            r6.<init>()     // Catch:{ all -> 0x00a9 }
            r6.append(r0)     // Catch:{ all -> 0x00a9 }
            r6.append(r9)     // Catch:{ all -> 0x00a9 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x00a9 }
            r5.e(r1, r0, r2)     // Catch:{ all -> 0x00a9 }
            if (r3 == 0) goto L_0x0096
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r3)
            goto L_0x0097
        L_0x0096:
        L_0x0097:
            r3 = r4
        L_0x0098:
            if (r3 != 0) goto L_0x00a3
            com.google.android.gms.common.internal.GmsLogger r0 = zza
            java.lang.String r2 = ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"
            r0.d(r1, r2)
            java.lang.String r3 = "UNKNOWN"
        L_0x00a3:
            java.util.concurrent.ConcurrentHashMap r0 = r8.zzc
            r0.put(r9, r3)
            return r3
        L_0x00a9:
            r9 = move-exception
        L_0x00aa:
            if (r3 == 0) goto L_0x00af
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r3)
        L_0x00af:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.LibraryVersion.getVersion(java.lang.String):java.lang.String");
    }
}

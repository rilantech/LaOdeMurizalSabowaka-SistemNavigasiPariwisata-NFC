package com.google.android.gms.internal.location;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
public final class zzey {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(java.util.concurrent.CountDownLatch r3, long r4, java.util.concurrent.TimeUnit r6) {
        /*
            r4 = 30
            r0 = 0
            long r4 = r6.toNanos(r4)     // Catch:{ all -> 0x0027 }
            long r1 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0027 }
            long r1 = r1 + r4
        L_0x000c:
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x001e }
            boolean r3 = r3.await(r4, r6)     // Catch:{ InterruptedException -> 0x001e }
            if (r0 == 0) goto L_0x001b
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            r4.interrupt()
        L_0x001b:
            return r3
        L_0x001c:
            r3 = move-exception
            goto L_0x0028
        L_0x001e:
            r4 = move-exception
            r0 = 1
            long r4 = java.lang.System.nanoTime()     // Catch:{ all -> 0x001c }
            long r4 = r1 - r4
            goto L_0x000c
        L_0x0027:
            r3 = move-exception
        L_0x0028:
            if (r0 == 0) goto L_0x0031
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            r4.interrupt()
        L_0x0031:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzey.zza(java.util.concurrent.CountDownLatch, long, java.util.concurrent.TimeUnit):boolean");
    }
}

package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.ColorSpace;
import android.graphics.Paint;

public final class BitmapCompat {
    public static boolean hasMipMap(Bitmap bitmap) {
        return Api17Impl.hasMipMap(bitmap);
    }

    public static void setHasMipMap(Bitmap bitmap, boolean hasMipMap) {
        Api17Impl.setHasMipMap(bitmap, hasMipMap);
    }

    public static int getAllocationByteCount(Bitmap bitmap) {
        return Api19Impl.getAllocationByteCount(bitmap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap createScaledBitmap(android.graphics.Bitmap r30, int r31, int r32, android.graphics.Rect r33, boolean r34) {
        /*
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r33
            if (r1 <= 0) goto L_0x0233
            if (r2 <= 0) goto L_0x0233
            if (r3 == 0) goto L_0x0036
            boolean r4 = r33.isEmpty()
            if (r4 != 0) goto L_0x002d
            int r4 = r3.left
            if (r4 < 0) goto L_0x002d
            int r4 = r3.right
            int r5 = r30.getWidth()
            if (r4 > r5) goto L_0x002d
            int r4 = r3.top
            if (r4 < 0) goto L_0x002d
            int r4 = r3.bottom
            int r5 = r30.getHeight()
            if (r4 > r5) goto L_0x002d
            goto L_0x0036
        L_0x002d:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "srcRect must be contained by srcBm!"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            r4 = r30
            android.graphics.Bitmap r4 = androidx.core.graphics.BitmapCompat.Api27Impl.copyBitmapIfHardware(r30)
            if (r3 == 0) goto L_0x0044
            int r5 = r33.width()
            goto L_0x0048
        L_0x0044:
            int r5 = r30.getWidth()
        L_0x0048:
            if (r3 == 0) goto L_0x004f
            int r6 = r33.height()
            goto L_0x0053
        L_0x004f:
            int r6 = r30.getHeight()
        L_0x0053:
            float r7 = (float) r1
            float r8 = (float) r5
            float r7 = r7 / r8
            float r8 = (float) r2
            float r9 = (float) r6
            float r8 = r8 / r9
            if (r3 == 0) goto L_0x005e
            int r10 = r3.left
            goto L_0x005f
        L_0x005e:
            r10 = 0
        L_0x005f:
            if (r3 == 0) goto L_0x0064
            int r11 = r3.top
            goto L_0x0065
        L_0x0064:
            r11 = 0
        L_0x0065:
            r12 = 1
            if (r10 != 0) goto L_0x0088
            if (r11 != 0) goto L_0x0088
            int r13 = r30.getWidth()
            if (r1 != r13) goto L_0x0088
            int r13 = r30.getHeight()
            if (r2 != r13) goto L_0x0088
            boolean r9 = r30.isMutable()
            if (r9 == 0) goto L_0x0087
            if (r0 != r4) goto L_0x0087
            android.graphics.Bitmap$Config r9 = r30.getConfig()
            android.graphics.Bitmap r9 = r0.copy(r9, r12)
            return r9
        L_0x0087:
            return r4
        L_0x0088:
            android.graphics.Paint r13 = new android.graphics.Paint
            r13.<init>(r12)
            r13.setFilterBitmap(r12)
            androidx.core.graphics.BitmapCompat.Api29Impl.setPaintBlendMode(r13)
            if (r5 != r1) goto L_0x00ad
            if (r6 != r2) goto L_0x00ad
            android.graphics.Bitmap$Config r9 = r4.getConfig()
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r1, r2, r9)
            android.graphics.Canvas r12 = new android.graphics.Canvas
            r12.<init>(r9)
            int r14 = -r10
            float r14 = (float) r14
            int r15 = -r11
            float r15 = (float) r15
            r12.drawBitmap(r4, r14, r15, r13)
            return r9
        L_0x00ad:
            r14 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r14 = java.lang.Math.log(r14)
            r16 = 1065353216(0x3f800000, float:1.0)
            int r17 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r17 <= 0) goto L_0x00c7
            r17 = r10
            double r9 = (double) r7
            double r9 = java.lang.Math.log(r9)
            double r9 = r9 / r14
            double r9 = java.lang.Math.ceil(r9)
            int r9 = (int) r9
            goto L_0x00d4
        L_0x00c7:
            r17 = r10
            double r9 = (double) r7
            double r9 = java.lang.Math.log(r9)
            double r9 = r9 / r14
            double r9 = java.lang.Math.floor(r9)
            int r9 = (int) r9
        L_0x00d4:
            int r10 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r10 <= 0) goto L_0x00e6
            r10 = r13
            double r12 = (double) r8
            double r12 = java.lang.Math.log(r12)
            double r12 = r12 / r14
            double r12 = java.lang.Math.ceil(r12)
            int r12 = (int) r12
            goto L_0x00f2
        L_0x00e6:
            r10 = r13
            double r12 = (double) r8
            double r12 = java.lang.Math.log(r12)
            double r12 = r12 / r14
            double r12 = java.lang.Math.floor(r12)
            int r12 = (int) r12
        L_0x00f2:
            r13 = r9
            r19 = r12
            r20 = 0
            r21 = 0
            if (r34 == 0) goto L_0x015a
            boolean r22 = androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r30)
            if (r22 != 0) goto L_0x014d
            if (r9 <= 0) goto L_0x010a
            r3 = 1
            int r16 = sizeAtStep(r5, r1, r3, r13)
            goto L_0x010d
        L_0x010a:
            r3 = 1
            r16 = r5
        L_0x010d:
            r22 = r16
            if (r12 <= 0) goto L_0x011a
            r16 = r7
            r7 = r19
            int r19 = sizeAtStep(r6, r2, r3, r7)
            goto L_0x0120
        L_0x011a:
            r16 = r7
            r7 = r19
            r19 = r6
        L_0x0120:
            r23 = r19
            r19 = r8
            r8 = r22
            r22 = r9
            r9 = r23
            r23 = r12
            android.graphics.Bitmap r12 = androidx.core.graphics.BitmapCompat.Api27Impl.createBitmapWithSourceColorspace(r8, r9, r0, r3)
            android.graphics.Canvas r3 = new android.graphics.Canvas
            r3.<init>(r12)
            r24 = r8
            r8 = r17
            r17 = r9
            int r9 = -r8
            float r9 = (float) r9
            r25 = r8
            int r8 = -r11
            float r8 = (float) r8
            r3.drawBitmap(r4, r9, r8, r10)
            r8 = 0
            r11 = 0
            r9 = r12
            r20 = r4
            r4 = r9
            r21 = 1
            goto L_0x0168
        L_0x014d:
            r16 = r7
            r22 = r9
            r23 = r12
            r25 = r17
            r7 = r19
            r19 = r8
            goto L_0x0166
        L_0x015a:
            r16 = r7
            r22 = r9
            r23 = r12
            r25 = r17
            r7 = r19
            r19 = r8
        L_0x0166:
            r8 = r25
        L_0x0168:
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>(r8, r11, r5, r6)
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            r17 = r8
            r8 = r20
            r12 = r23
        L_0x0178:
            if (r22 != 0) goto L_0x0185
            if (r12 == 0) goto L_0x017d
            goto L_0x0185
        L_0x017d:
            if (r8 == r0) goto L_0x0184
            if (r8 == 0) goto L_0x0184
            r8.recycle()
        L_0x0184:
            return r4
        L_0x0185:
            if (r22 >= 0) goto L_0x018e
            int r22 = r22 + 1
            r20 = r11
            r11 = r22
            goto L_0x019b
        L_0x018e:
            if (r22 <= 0) goto L_0x0197
            int r22 = r22 + -1
            r20 = r11
            r11 = r22
            goto L_0x019b
        L_0x0197:
            r20 = r11
            r11 = r22
        L_0x019b:
            if (r12 >= 0) goto L_0x01a0
            int r12 = r12 + 1
            goto L_0x01a4
        L_0x01a0:
            if (r12 <= 0) goto L_0x01a4
            int r12 = r12 + -1
        L_0x01a4:
            r22 = r14
            int r14 = sizeAtStep(r5, r1, r11, r13)
            int r15 = sizeAtStep(r6, r2, r12, r7)
            r24 = r3
            r3 = 0
            r9.set(r3, r3, r14, r15)
            if (r11 != 0) goto L_0x01bb
            if (r12 != 0) goto L_0x01bb
            r18 = 1
            goto L_0x01bd
        L_0x01bb:
            r18 = r3
        L_0x01bd:
            if (r8 == 0) goto L_0x01cd
            int r3 = r8.getWidth()
            if (r3 != r1) goto L_0x01cd
            int r3 = r8.getHeight()
            if (r3 != r2) goto L_0x01cd
            r3 = 1
            goto L_0x01ce
        L_0x01cd:
            r3 = 0
        L_0x01ce:
            if (r8 == 0) goto L_0x01e4
            if (r8 == r0) goto L_0x01e4
            if (r34 == 0) goto L_0x01da
            boolean r26 = androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r8)
            if (r26 == 0) goto L_0x01e0
        L_0x01da:
            if (r18 == 0) goto L_0x01e1
            if (r3 == 0) goto L_0x01e0
            if (r21 == 0) goto L_0x01e1
        L_0x01e0:
            goto L_0x01e4
        L_0x01e1:
            r27 = r3
            goto L_0x0216
        L_0x01e4:
            if (r8 == r0) goto L_0x01eb
            if (r8 == 0) goto L_0x01eb
            r8.recycle()
        L_0x01eb:
            r26 = r21
            r27 = r3
            if (r11 <= 0) goto L_0x01f4
            r3 = r26
            goto L_0x01f5
        L_0x01f4:
            r3 = r11
        L_0x01f5:
            int r3 = sizeAtStep(r5, r1, r3, r13)
            if (r12 <= 0) goto L_0x01fe
            r1 = r26
            goto L_0x01ff
        L_0x01fe:
            r1 = r12
        L_0x01ff:
            int r1 = sizeAtStep(r6, r2, r1, r7)
            if (r34 == 0) goto L_0x020b
            if (r18 != 0) goto L_0x020b
            r28 = 1
            goto L_0x020d
        L_0x020b:
            r28 = 0
        L_0x020d:
            r29 = r28
            r2 = r29
            android.graphics.Bitmap r8 = androidx.core.graphics.BitmapCompat.Api27Impl.createBitmapWithSourceColorspace(r3, r1, r0, r2)
        L_0x0216:
            android.graphics.Canvas r1 = new android.graphics.Canvas
            r1.<init>(r8)
            r2 = r24
            r1.drawBitmap(r4, r2, r9, r10)
            r3 = r4
            r4 = r8
            r8 = r3
            r2.set(r9)
            r1 = r31
            r3 = r2
            r14 = r22
            r2 = r32
            r22 = r11
            r11 = r20
            goto L_0x0178
        L_0x0233:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "dstW and dstH must be > 0!"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.BitmapCompat.createScaledBitmap(android.graphics.Bitmap, int, int, android.graphics.Rect, boolean):android.graphics.Bitmap");
    }

    static int sizeAtStep(int srcSize, int dstSize, int step, int totalSteps) {
        if (step == 0) {
            return dstSize;
        }
        if (step > 0) {
            return (1 << (totalSteps - step)) * srcSize;
        }
        return dstSize << ((-step) - 1);
    }

    private BitmapCompat() {
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static boolean hasMipMap(Bitmap bitmap) {
            return bitmap.hasMipMap();
        }

        static void setHasMipMap(Bitmap bitmap, boolean hasMipMap) {
            bitmap.setHasMipMap(hasMipMap);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static int getAllocationByteCount(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    static class Api27Impl {
        private Api27Impl() {
        }

        static Bitmap createBitmapWithSourceColorspace(int w, int h, Bitmap src, boolean linear) {
            Bitmap.Config config = src.getConfig();
            ColorSpace colorSpace = src.getColorSpace();
            ColorSpace linearCs = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (linear && !src.getColorSpace().equals(linearCs)) {
                config = Bitmap.Config.RGBA_F16;
                colorSpace = linearCs;
            } else if (src.getConfig() == Bitmap.Config.HARDWARE) {
                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                config = Api31Impl.getHardwareBitmapConfig(src);
            }
            return Bitmap.createBitmap(w, h, config, src.hasAlpha(), colorSpace);
        }

        static boolean isAlreadyF16AndLinear(Bitmap b) {
            return b.getConfig() == Bitmap.Config.RGBA_F16 && b.getColorSpace().equals(ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB));
        }

        static Bitmap copyBitmapIfHardware(Bitmap bm) {
            if (bm.getConfig() != Bitmap.Config.HARDWARE) {
                return bm;
            }
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            return bm.copy(Api31Impl.getHardwareBitmapConfig(bm), true);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static Bitmap.Config getHardwareBitmapConfig(Bitmap bm) {
            if (bm.getHardwareBuffer().getFormat() == 22) {
                return Bitmap.Config.RGBA_F16;
            }
            return Bitmap.Config.ARGB_8888;
        }
    }
}

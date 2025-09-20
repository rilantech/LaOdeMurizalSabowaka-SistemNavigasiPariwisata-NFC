package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentDrawScope.kt */
public interface ContentDrawScope extends DrawScope {
    void drawContent();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ContentDrawScope.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
        public static void m5504drawImageAZ2fEMs(ContentDrawScope $this, ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(style, "style");
            ContentDrawScope.super.m5561drawImageAZ2fEMs(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, filterQuality);
        }

        @Deprecated
        /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
        public static long m5505getCenterF1C5BW0(ContentDrawScope $this) {
            return ContentDrawScope.super.m5575getCenterF1C5BW0();
        }

        @Deprecated
        /* renamed from: getSize-NH-jbRc  reason: not valid java name */
        public static long m5506getSizeNHjbRc(ContentDrawScope $this) {
            return ContentDrawScope.super.m5576getSizeNHjbRc();
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m5507roundToPxR2X_6o(ContentDrawScope $this, long $receiver) {
            return ContentDrawScope.super.m7528roundToPxR2X_6o($receiver);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m5508roundToPx0680j_4(ContentDrawScope $this, float $receiver) {
            return ContentDrawScope.super.m7529roundToPx0680j_4($receiver);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m5509toDpGaN1DYA(ContentDrawScope $this, long $receiver) {
            return ContentDrawScope.super.m7530toDpGaN1DYA($receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m5510toDpu2uoSUM(ContentDrawScope $this, float $receiver) {
            return ContentDrawScope.super.m7531toDpu2uoSUM($receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m5511toDpu2uoSUM(ContentDrawScope $this, int $receiver) {
            return ContentDrawScope.super.m7532toDpu2uoSUM($receiver);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m5512toDpSizekrfVVM(ContentDrawScope $this, long $receiver) {
            return ContentDrawScope.super.m7533toDpSizekrfVVM($receiver);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m5513toPxR2X_6o(ContentDrawScope $this, long $receiver) {
            return ContentDrawScope.super.m7534toPxR2X_6o($receiver);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m5514toPx0680j_4(ContentDrawScope $this, float $receiver) {
            return ContentDrawScope.super.m7535toPx0680j_4($receiver);
        }

        @Deprecated
        public static Rect toRect(ContentDrawScope $this, DpRect $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return ContentDrawScope.super.toRect($receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m5515toSizeXkaWNTQ(ContentDrawScope $this, long $receiver) {
            return ContentDrawScope.super.m7536toSizeXkaWNTQ($receiver);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m5516toSp0xMU5do(ContentDrawScope $this, float $receiver) {
            return ContentDrawScope.super.m7537toSp0xMU5do($receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m5517toSpkPz2Gy4(ContentDrawScope $this, float $receiver) {
            return ContentDrawScope.super.m7538toSpkPz2Gy4($receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m5518toSpkPz2Gy4(ContentDrawScope $this, int $receiver) {
            return ContentDrawScope.super.m7539toSpkPz2Gy4($receiver);
        }
    }
}

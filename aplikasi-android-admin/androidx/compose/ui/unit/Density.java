package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u000b\u001a\u00020\f*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u000b\u001a\u00020\f*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\r*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0013\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0013\u001a\u00020\r*\u00020\fH\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0015J\f\u0010!\u001a\u00020\"*\u00020#H\u0017J\u0019\u0010$\u001a\u00020\u001b*\u00020\u001aH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u001dJ\u0019\u0010&\u001a\u00020\u0010*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\u0003H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\fH\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007ø\u0001\u0003\u0002\u0015\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!\n\u0004\b!0\u0001¨\u0006+À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "fontScale", "getFontScale$annotations", "getFontScale", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Density.kt */
public interface Density {
    float getDensity();

    float getFontScale();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Density.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        public static /* synthetic */ void getFontScale$annotations() {
        }

        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m7547toPx0680j_4(Density $this, float $receiver) {
            return Density.super.m7535toPx0680j_4($receiver);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m7541roundToPx0680j_4(Density $this, float $receiver) {
            return Density.super.m7529roundToPx0680j_4($receiver);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m7549toSp0xMU5do(Density $this, float $receiver) {
            return Density.super.m7537toSp0xMU5do($receiver);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m7546toPxR2X_6o(Density $this, long $receiver) {
            return Density.super.m7534toPxR2X_6o($receiver);
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m7540roundToPxR2X_6o(Density $this, long $receiver) {
            return Density.super.m7528roundToPxR2X_6o($receiver);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m7542toDpGaN1DYA(Density $this, long $receiver) {
            return Density.super.m7530toDpGaN1DYA($receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m7544toDpu2uoSUM(Density $this, int $receiver) {
            return Density.super.m7532toDpu2uoSUM($receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m7551toSpkPz2Gy4(Density $this, int $receiver) {
            return Density.super.m7539toSpkPz2Gy4($receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m7543toDpu2uoSUM(Density $this, float $receiver) {
            return Density.super.m7531toDpu2uoSUM($receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m7550toSpkPz2Gy4(Density $this, float $receiver) {
            return Density.super.m7538toSpkPz2Gy4($receiver);
        }

        @Deprecated
        public static Rect toRect(Density $this, DpRect $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return Density.super.toRect($receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m7548toSizeXkaWNTQ(Density $this, long $receiver) {
            return Density.super.m7536toSizeXkaWNTQ($receiver);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m7545toDpSizekrfVVM(Density $this, long $receiver) {
            return Density.super.m7533toDpSizekrfVVM($receiver);
        }
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    float m7535toPx0680j_4(float $this$toPx_u2d0680j_4) {
        return getDensity() * $this$toPx_u2d0680j_4;
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    int m7529roundToPx0680j_4(float $this$roundToPx_u2d0680j_4) {
        float px = m7535toPx0680j_4($this$roundToPx_u2d0680j_4);
        if (Float.isInfinite(px)) {
            return Integer.MAX_VALUE;
        }
        return MathKt.roundToInt(px);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    long m7537toSp0xMU5do(float $this$toSp_u2d0xMU5do) {
        return TextUnitKt.getSp($this$toSp_u2d0xMU5do / getFontScale());
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    float m7534toPxR2X_6o(long $this$toPx_u2d_u2dR2X_6o) {
        if (TextUnitType.m7763equalsimpl0(TextUnit.m7734getTypeUIouoOA($this$toPx_u2d_u2dR2X_6o), TextUnitType.Companion.m7768getSpUIouoOA())) {
            return TextUnit.m7735getValueimpl($this$toPx_u2d_u2dR2X_6o) * getFontScale() * getDensity();
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    int m7528roundToPxR2X_6o(long $this$roundToPx_u2d_u2dR2X_6o) {
        return MathKt.roundToInt(m7534toPxR2X_6o($this$roundToPx_u2d_u2dR2X_6o));
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    float m7530toDpGaN1DYA(long $this$toDp_u2dGaN1DYA) {
        if (TextUnitType.m7763equalsimpl0(TextUnit.m7734getTypeUIouoOA($this$toDp_u2dGaN1DYA), TextUnitType.Companion.m7768getSpUIouoOA())) {
            return Dp.m7554constructorimpl(TextUnit.m7735getValueimpl($this$toDp_u2dGaN1DYA) * getFontScale());
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m7532toDpu2uoSUM(int $this$toDp_u2du2uoSUM) {
        return Dp.m7554constructorimpl(((float) $this$toDp_u2du2uoSUM) / getDensity());
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m7539toSpkPz2Gy4(int $this$toSp_u2dkPz2Gy4) {
        return TextUnitKt.getSp(((float) $this$toSp_u2dkPz2Gy4) / (getFontScale() * getDensity()));
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m7531toDpu2uoSUM(float $this$toDp_u2du2uoSUM) {
        return Dp.m7554constructorimpl($this$toDp_u2du2uoSUM / getDensity());
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m7538toSpkPz2Gy4(float $this$toSp_u2dkPz2Gy4) {
        return TextUnitKt.getSp($this$toSp_u2dkPz2Gy4 / (getFontScale() * getDensity()));
    }

    Rect toRect(DpRect $this$toRect) {
        Intrinsics.checkNotNullParameter($this$toRect, "<this>");
        return new Rect(m7535toPx0680j_4($this$toRect.m7637getLeftD9Ej5fM()), m7535toPx0680j_4($this$toRect.m7639getTopD9Ej5fM()), m7535toPx0680j_4($this$toRect.m7638getRightD9Ej5fM()), m7535toPx0680j_4($this$toRect.m7636getBottomD9Ej5fM()));
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    long m7536toSizeXkaWNTQ(long $this$toSize_u2dXkaWNTQ) {
        if ($this$toSize_u2dXkaWNTQ != DpSize.Companion.m7661getUnspecifiedMYxV2XQ()) {
            return SizeKt.Size(m7535toPx0680j_4(DpSize.m7652getWidthD9Ej5fM($this$toSize_u2dXkaWNTQ)), m7535toPx0680j_4(DpSize.m7650getHeightD9Ej5fM($this$toSize_u2dXkaWNTQ)));
        }
        return Size.Companion.m4790getUnspecifiedNHjbRc();
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    long m7533toDpSizekrfVVM(long $this$toDpSize_u2dk_u2drfVVM) {
        if ($this$toDpSize_u2dk_u2drfVVM != Size.Companion.m4790getUnspecifiedNHjbRc()) {
            return DpKt.m7576DpSizeYgX7TsA(m7531toDpu2uoSUM(Size.m4782getWidthimpl($this$toDpSize_u2dk_u2drfVVM)), m7531toDpu2uoSUM(Size.m4779getHeightimpl($this$toDpSize_u2dk_u2drfVVM)));
        }
        return DpSize.Companion.m7661getUnspecifiedMYxV2XQ();
    }
}

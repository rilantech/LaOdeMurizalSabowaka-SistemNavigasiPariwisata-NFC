package androidx.compose.material.ripple;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\r\u001a\u00020\b*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"BoundedRippleExtraRadius", "Landroidx/compose/ui/unit/Dp;", "F", "FadeInDuration", "", "FadeOutDuration", "RadiusDuration", "getRippleStartRadius", "", "size", "Landroidx/compose/ui/geometry/Size;", "getRippleStartRadius-uvyYCjk", "(J)F", "getRippleEndRadius", "Landroidx/compose/ui/unit/Density;", "bounded", "", "getRippleEndRadius-cSwnlzA", "(Landroidx/compose/ui/unit/Density;ZJ)F", "material-ripple_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: RippleAnimation.kt */
public final class RippleAnimationKt {
    private static final float BoundedRippleExtraRadius = Dp.m7554constructorimpl((float) 10);
    private static final int FadeInDuration = 75;
    private static final int FadeOutDuration = 150;
    private static final int RadiusDuration = 225;

    /* renamed from: getRippleStartRadius-uvyYCjk  reason: not valid java name */
    public static final float m3228getRippleStartRadiusuvyYCjk(long size) {
        return Math.max(Size.m4782getWidthimpl(size), Size.m4779getHeightimpl(size)) * 0.3f;
    }

    /* renamed from: getRippleEndRadius-cSwnlzA  reason: not valid java name */
    public static final float m3227getRippleEndRadiuscSwnlzA(Density $this$getRippleEndRadius_u2dcSwnlzA, boolean bounded, long size) {
        Intrinsics.checkNotNullParameter($this$getRippleEndRadius_u2dcSwnlzA, "$this$getRippleEndRadius");
        float radiusCoveringBounds = Offset.m4711getDistanceimpl(OffsetKt.Offset(Size.m4782getWidthimpl(size), Size.m4779getHeightimpl(size))) / 2.0f;
        if (bounded) {
            return $this$getRippleEndRadius_u2dcSwnlzA.m7535toPx0680j_4(BoundedRippleExtraRadius) + radiusCoveringBounds;
        }
        return radiusCoveringBounds;
    }
}

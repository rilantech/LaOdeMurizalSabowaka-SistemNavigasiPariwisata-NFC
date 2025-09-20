package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a-\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\"!\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"!\u0010\u0007\u001a\u00020\u0001*\u00020\u00028FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"!\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006\u001d"}, d2 = {"isFinite", "", "Landroidx/compose/ui/geometry/Offset;", "isFinite-k-4lQ0M$annotations", "(J)V", "isFinite-k-4lQ0M", "(J)Z", "isSpecified", "isSpecified-k-4lQ0M$annotations", "isSpecified-k-4lQ0M", "isUnspecified", "isUnspecified-k-4lQ0M$annotations", "isUnspecified-k-4lQ0M", "Offset", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-Wko1d7g", "(JJF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-3MmeM6k", "(JLkotlin/jvm/functions/Function0;)J", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Offset.kt */
public final class OffsetKt {
    /* renamed from: isFinite-k-4lQ0M$annotations  reason: not valid java name */
    public static /* synthetic */ void m4731isFinitek4lQ0M$annotations(long j) {
    }

    /* renamed from: isSpecified-k-4lQ0M$annotations  reason: not valid java name */
    public static /* synthetic */ void m4733isSpecifiedk4lQ0M$annotations(long j) {
    }

    /* renamed from: isUnspecified-k-4lQ0M$annotations  reason: not valid java name */
    public static /* synthetic */ void m4735isUnspecifiedk4lQ0M$annotations(long j) {
    }

    public static final long Offset(float x, float y) {
        return Offset.m4705constructorimpl((((long) Float.floatToIntBits(x)) << 32) | (4294967295L & ((long) Float.floatToIntBits(y))));
    }

    /* renamed from: lerp-Wko1d7g  reason: not valid java name */
    public static final long m4736lerpWko1d7g(long start, long stop, float fraction) {
        return Offset(MathHelpersKt.lerp(Offset.m4713getXimpl(start), Offset.m4713getXimpl(stop), fraction), MathHelpersKt.lerp(Offset.m4714getYimpl(start), Offset.m4714getYimpl(stop), fraction));
    }

    /* renamed from: isFinite-k-4lQ0M  reason: not valid java name */
    public static final boolean m4730isFinitek4lQ0M(long $this$isFinite) {
        float r0 = Offset.m4713getXimpl($this$isFinite);
        if (!Float.isInfinite(r0) && !Float.isNaN(r0)) {
            float r02 = Offset.m4714getYimpl($this$isFinite);
            if (!Float.isInfinite(r02) && !Float.isNaN(r02)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: isSpecified-k-4lQ0M  reason: not valid java name */
    public static final boolean m4732isSpecifiedk4lQ0M(long $this$isSpecified) {
        return $this$isSpecified != Offset.Companion.m4728getUnspecifiedF1C5BW0();
    }

    /* renamed from: isUnspecified-k-4lQ0M  reason: not valid java name */
    public static final boolean m4734isUnspecifiedk4lQ0M(long $this$isUnspecified) {
        return $this$isUnspecified == Offset.Companion.m4728getUnspecifiedF1C5BW0();
    }

    /* renamed from: takeOrElse-3MmeM6k  reason: not valid java name */
    public static final long m4737takeOrElse3MmeM6k(long $this$takeOrElse_u2d3MmeM6k, Function0<Offset> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return m4732isSpecifiedk4lQ0M($this$takeOrElse_u2d3MmeM6k) ? $this$takeOrElse_u2d3MmeM6k : block.invoke().m4723unboximpl();
    }
}

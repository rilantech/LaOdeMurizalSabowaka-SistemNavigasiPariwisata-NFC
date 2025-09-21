package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a-\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a+\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cH\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\"\u0010\u001f\u001a\u00020\u0002*\u00020 2\u0006\u0010!\u001a\u00020\u0002H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\"\u0010\u001f\u001a\u00020\u0002*\u00020\u00112\u0006\u0010!\u001a\u00020\u0002H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010$\u001a\"\u0010\u001f\u001a\u00020\u0002*\u00020%2\u0006\u0010!\u001a\u00020\u0002H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010&\u001a\u0019\u0010'\u001a\u00020(*\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\"!\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\"\u0010\u0007\u001a\u00020\b*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b\"\"\u0010\f\u001a\u00020\b*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000b\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006+"}, d2 = {"center", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Size;", "getCenter-uvyYCjk$annotations", "(J)V", "getCenter-uvyYCjk", "(J)J", "isSpecified", "", "isSpecified-uvyYCjk$annotations", "isSpecified-uvyYCjk", "(J)Z", "isUnspecified", "isUnspecified-uvyYCjk$annotations", "isUnspecified-uvyYCjk", "Size", "width", "", "height", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-VgWVRYQ", "(JJF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-TmRCtEA", "(JLkotlin/jvm/functions/Function0;)J", "times", "", "size", "times-d16Qtg0", "(DJ)J", "(FJ)J", "", "(IJ)J", "toRect", "Landroidx/compose/ui/geometry/Rect;", "toRect-uvyYCjk", "(J)Landroidx/compose/ui/geometry/Rect;", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
public final class SizeKt {
    /* renamed from: getCenter-uvyYCjk$annotations  reason: not valid java name */
    public static /* synthetic */ void m4793getCenteruvyYCjk$annotations(long j) {
    }

    /* renamed from: isSpecified-uvyYCjk$annotations  reason: not valid java name */
    public static /* synthetic */ void m4795isSpecifieduvyYCjk$annotations(long j) {
    }

    /* renamed from: isUnspecified-uvyYCjk$annotations  reason: not valid java name */
    public static /* synthetic */ void m4797isUnspecifieduvyYCjk$annotations(long j) {
    }

    public static final long Size(float width, float height) {
        return Size.m4773constructorimpl((((long) Float.floatToIntBits(width)) << 32) | (4294967295L & ((long) Float.floatToIntBits(height))));
    }

    /* renamed from: isSpecified-uvyYCjk  reason: not valid java name */
    public static final boolean m4794isSpecifieduvyYCjk(long $this$isSpecified) {
        return $this$isSpecified != Size.Companion.m4790getUnspecifiedNHjbRc();
    }

    /* renamed from: isUnspecified-uvyYCjk  reason: not valid java name */
    public static final boolean m4796isUnspecifieduvyYCjk(long $this$isUnspecified) {
        return $this$isUnspecified == Size.Companion.m4790getUnspecifiedNHjbRc();
    }

    /* renamed from: takeOrElse-TmRCtEA  reason: not valid java name */
    public static final long m4799takeOrElseTmRCtEA(long $this$takeOrElse_u2dTmRCtEA, Function0<Size> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return ($this$takeOrElse_u2dTmRCtEA > Size.Companion.m4790getUnspecifiedNHjbRc() ? 1 : ($this$takeOrElse_u2dTmRCtEA == Size.Companion.m4790getUnspecifiedNHjbRc() ? 0 : -1)) != 0 ? $this$takeOrElse_u2dTmRCtEA : block.invoke().m4787unboximpl();
    }

    /* renamed from: lerp-VgWVRYQ  reason: not valid java name */
    public static final long m4798lerpVgWVRYQ(long start, long stop, float fraction) {
        return Size(MathHelpersKt.lerp(Size.m4782getWidthimpl(start), Size.m4782getWidthimpl(stop), fraction), MathHelpersKt.lerp(Size.m4779getHeightimpl(start), Size.m4779getHeightimpl(stop), fraction));
    }

    /* renamed from: times-d16Qtg0  reason: not valid java name */
    public static final long m4802timesd16Qtg0(int $this$times_u2dd16Qtg0, long size) {
        return Size.m4785times7Ah8Wj8(size, (float) $this$times_u2dd16Qtg0);
    }

    /* renamed from: times-d16Qtg0  reason: not valid java name */
    public static final long m4800timesd16Qtg0(double $this$times_u2dd16Qtg0, long size) {
        return Size.m4785times7Ah8Wj8(size, (float) $this$times_u2dd16Qtg0);
    }

    /* renamed from: toRect-uvyYCjk  reason: not valid java name */
    public static final Rect m4803toRectuvyYCjk(long $this$toRect_u2duvyYCjk) {
        return RectKt.m4753Recttz77jQw(Offset.Companion.m4729getZeroF1C5BW0(), $this$toRect_u2duvyYCjk);
    }

    /* renamed from: times-d16Qtg0  reason: not valid java name */
    public static final long m4801timesd16Qtg0(float $this$times_u2dd16Qtg0, long size) {
        return Size.m4785times7Ah8Wj8(size, $this$times_u2dd16Qtg0);
    }

    /* renamed from: getCenter-uvyYCjk  reason: not valid java name */
    public static final long m4792getCenteruvyYCjk(long $this$center) {
        return OffsetKt.Offset(Size.m4782getWidthimpl($this$center) / 2.0f, Size.m4779getHeightimpl($this$center) / 2.0f);
    }
}

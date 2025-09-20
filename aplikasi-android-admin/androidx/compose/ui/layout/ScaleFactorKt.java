package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a \u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a-\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\"\u0010\u0015\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\f*\u00020\fH\u0002\u001a+\u0010\u001b\u001a\u00020\u0002*\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\"\u0010 \u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0019\u001a\"\u0010 \u001a\u00020\u0016*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0016H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010\u0019\"\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\"\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006$"}, d2 = {"isSpecified", "", "Landroidx/compose/ui/layout/ScaleFactor;", "isSpecified-FK8aYYs$annotations", "(J)V", "isSpecified-FK8aYYs", "(J)Z", "isUnspecified", "isUnspecified-FK8aYYs$annotations", "isUnspecified-FK8aYYs", "ScaleFactor", "scaleX", "", "scaleY", "(FF)J", "lerp", "start", "stop", "fraction", "lerp--bDIf60", "(JJF)J", "div", "Landroidx/compose/ui/geometry/Size;", "scaleFactor", "div-UQTWf7w", "(JJ)J", "roundToTenths", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-oyDd2qo", "(JLkotlin/jvm/functions/Function0;)J", "times", "times-UQTWf7w", "size", "times-m-w2e94", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ScaleFactor.kt */
public final class ScaleFactorKt {
    /* renamed from: isSpecified-FK8aYYs$annotations  reason: not valid java name */
    public static /* synthetic */ void m6469isSpecifiedFK8aYYs$annotations(long j) {
    }

    /* renamed from: isUnspecified-FK8aYYs$annotations  reason: not valid java name */
    public static /* synthetic */ void m6471isUnspecifiedFK8aYYs$annotations(long j) {
    }

    public static final long ScaleFactor(float scaleX, float scaleY) {
        return ScaleFactor.m6453constructorimpl((((long) Float.floatToIntBits(scaleX)) << 32) | (4294967295L & ((long) Float.floatToIntBits(scaleY))));
    }

    /* access modifiers changed from: private */
    public static final float roundToTenths(float $this$roundToTenths) {
        int roundedShifted;
        float f = (float) 10;
        float shifted = $this$roundToTenths * f;
        if (shifted - ((float) ((int) shifted)) >= 0.5f) {
            roundedShifted = ((int) shifted) + 1;
        } else {
            roundedShifted = (int) shifted;
        }
        return ((float) roundedShifted) / f;
    }

    /* renamed from: isSpecified-FK8aYYs  reason: not valid java name */
    public static final boolean m6468isSpecifiedFK8aYYs(long $this$isSpecified) {
        return $this$isSpecified != ScaleFactor.Companion.m6466getUnspecified_hLwfpc();
    }

    /* renamed from: isUnspecified-FK8aYYs  reason: not valid java name */
    public static final boolean m6470isUnspecifiedFK8aYYs(long $this$isUnspecified) {
        return $this$isUnspecified == ScaleFactor.Companion.m6466getUnspecified_hLwfpc();
    }

    /* renamed from: takeOrElse-oyDd2qo  reason: not valid java name */
    public static final long m6473takeOrElseoyDd2qo(long $this$takeOrElse_u2doyDd2qo, Function0<ScaleFactor> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return ($this$takeOrElse_u2doyDd2qo > ScaleFactor.Companion.m6466getUnspecified_hLwfpc() ? 1 : ($this$takeOrElse_u2doyDd2qo == ScaleFactor.Companion.m6466getUnspecified_hLwfpc() ? 0 : -1)) != 0 ? $this$takeOrElse_u2doyDd2qo : block.invoke().m6464unboximpl();
    }

    /* renamed from: times-UQTWf7w  reason: not valid java name */
    public static final long m6474timesUQTWf7w(long $this$times_u2dUQTWf7w, long scaleFactor) {
        return SizeKt.Size(Size.m4782getWidthimpl($this$times_u2dUQTWf7w) * ScaleFactor.m6459getScaleXimpl(scaleFactor), Size.m4779getHeightimpl($this$times_u2dUQTWf7w) * ScaleFactor.m6460getScaleYimpl(scaleFactor));
    }

    /* renamed from: times-m-w2e94  reason: not valid java name */
    public static final long m6475timesmw2e94(long $this$times_u2dm_u2dw2e94, long size) {
        return m6474timesUQTWf7w(size, $this$times_u2dm_u2dw2e94);
    }

    /* renamed from: div-UQTWf7w  reason: not valid java name */
    public static final long m6467divUQTWf7w(long $this$div_u2dUQTWf7w, long scaleFactor) {
        return SizeKt.Size(Size.m4782getWidthimpl($this$div_u2dUQTWf7w) / ScaleFactor.m6459getScaleXimpl(scaleFactor), Size.m4779getHeightimpl($this$div_u2dUQTWf7w) / ScaleFactor.m6460getScaleYimpl(scaleFactor));
    }

    /* renamed from: lerp--bDIf60  reason: not valid java name */
    public static final long m6472lerpbDIf60(long start, long stop, float fraction) {
        return ScaleFactor(MathHelpersKt.lerp(ScaleFactor.m6459getScaleXimpl(start), ScaleFactor.m6459getScaleXimpl(stop), fraction), MathHelpersKt.lerp(ScaleFactor.m6460getScaleYimpl(start), ScaleFactor.m6460getScaleYimpl(stop), fraction));
    }
}

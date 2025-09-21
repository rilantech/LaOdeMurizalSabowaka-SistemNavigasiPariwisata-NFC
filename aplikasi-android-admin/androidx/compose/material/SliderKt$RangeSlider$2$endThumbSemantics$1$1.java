package androidx.compose.material;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "value", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$2$endThumbSemantics$1$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ float $coercedStart;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2$endThumbSemantics$1$1(State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, float f) {
        super(1);
        this.$onValueChangeState = state;
        this.$coercedStart = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float value) {
        this.$onValueChangeState.getValue().invoke(RangesKt.rangeTo(this.$coercedStart, value));
    }
}

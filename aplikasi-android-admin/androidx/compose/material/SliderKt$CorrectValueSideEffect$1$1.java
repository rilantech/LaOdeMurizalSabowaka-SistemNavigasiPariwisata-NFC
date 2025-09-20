package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$CorrectValueSideEffect$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Float, Float> $scaleToOffset;
    final /* synthetic */ ClosedFloatingPointRange<Float> $trackRange;
    final /* synthetic */ float $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;
    final /* synthetic */ MutableState<Float> $valueState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$CorrectValueSideEffect$1$1(ClosedFloatingPointRange<Float> closedFloatingPointRange, Function1<? super Float, Float> function1, float f, MutableState<Float> mutableState, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        super(0);
        this.$valueRange = closedFloatingPointRange;
        this.$scaleToOffset = function1;
        this.$value = f;
        this.$valueState = mutableState;
        this.$trackRange = closedFloatingPointRange2;
    }

    public final void invoke() {
        float error = (this.$valueRange.getEndInclusive().floatValue() - this.$valueRange.getStart().floatValue()) / ((float) 1000);
        float newOffset = this.$scaleToOffset.invoke(Float.valueOf(this.$value)).floatValue();
        if (Math.abs(newOffset - this.$valueState.getValue().floatValue()) > error && this.$trackRange.contains(this.$valueState.getValue())) {
            this.$valueState.setValue(Float.valueOf(newOffset));
        }
    }
}

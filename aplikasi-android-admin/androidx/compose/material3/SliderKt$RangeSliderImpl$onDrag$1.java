package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSliderImpl$onDrag$1 extends Lambda implements Function2<Boolean, Float, Unit> {
    final /* synthetic */ MutableState<Float> $endThumbWidth$delegate;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
    final /* synthetic */ MutableState<Float> $rawOffsetEnd;
    final /* synthetic */ MutableState<Float> $rawOffsetStart;
    final /* synthetic */ MutableState<Float> $startThumbWidth$delegate;
    final /* synthetic */ float[] $tickFractions;
    final /* synthetic */ MutableState<Integer> $totalWidth$delegate;
    final /* synthetic */ ClosedFloatingPointRange<Float> $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSliderImpl$onDrag$1(MutableState<Float> mutableState, MutableState<Float> mutableState2, ClosedFloatingPointRange<Float> closedFloatingPointRange, float[] fArr, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, MutableState<Integer> mutableState3, MutableState<Float> mutableState4, MutableState<Float> mutableState5, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        super(2);
        this.$rawOffsetStart = mutableState;
        this.$rawOffsetEnd = mutableState2;
        this.$value = closedFloatingPointRange;
        this.$tickFractions = fArr;
        this.$onValueChangeState = state;
        this.$totalWidth$delegate = mutableState3;
        this.$endThumbWidth$delegate = mutableState4;
        this.$startThumbWidth$delegate = mutableState5;
        this.$valueRange = closedFloatingPointRange2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), ((Number) p2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isStart, float offset) {
        ClosedFloatingPointRange offsetRange;
        float f = (float) 2;
        float maxPx = Math.max(((float) SliderKt.RangeSliderImpl$lambda$31(this.$totalWidth$delegate)) - (SliderKt.RangeSliderImpl$lambda$28(this.$endThumbWidth$delegate) / f), 0.0f);
        float minPx = Math.min(SliderKt.RangeSliderImpl$lambda$25(this.$startThumbWidth$delegate) / f, maxPx);
        if (isStart) {
            MutableState<Float> mutableState = this.$rawOffsetStart;
            mutableState.setValue(Float.valueOf(mutableState.getValue().floatValue() + offset));
            this.$rawOffsetEnd.setValue(Float.valueOf(SliderKt.RangeSliderImpl$scaleToOffset$34(this.$valueRange, minPx, maxPx, this.$value.getEndInclusive().floatValue())));
            float offsetEnd = this.$rawOffsetEnd.getValue().floatValue();
            offsetRange = RangesKt.rangeTo(SliderKt.snapValueToTick(RangesKt.coerceIn(this.$rawOffsetStart.getValue().floatValue(), minPx, offsetEnd), this.$tickFractions, minPx, maxPx), offsetEnd);
        } else {
            MutableState<Float> mutableState2 = this.$rawOffsetEnd;
            mutableState2.setValue(Float.valueOf(mutableState2.getValue().floatValue() + offset));
            this.$rawOffsetStart.setValue(Float.valueOf(SliderKt.RangeSliderImpl$scaleToOffset$34(this.$valueRange, minPx, maxPx, this.$value.getStart().floatValue())));
            float offsetStart = this.$rawOffsetStart.getValue().floatValue();
            offsetRange = RangesKt.rangeTo(offsetStart, SliderKt.snapValueToTick(RangesKt.coerceIn(this.$rawOffsetEnd.getValue().floatValue(), offsetStart, maxPx), this.$tickFractions, minPx, maxPx));
        }
        this.$onValueChangeState.getValue().invoke(SliderKt.RangeSliderImpl$scaleToUserValue$33(this.$valueRange, minPx, maxPx, offsetRange));
    }
}

package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSliderImpl$2 implements MeasurePolicy {
    final /* synthetic */ MutableState<Float> $endThumbWidth$delegate;
    final /* synthetic */ Ref.ObjectRef<MutableState<Boolean>> $obtainedMeasurements;
    final /* synthetic */ float $positionFractionEnd;
    final /* synthetic */ float $positionFractionStart;
    final /* synthetic */ MutableState<Float> $rawOffsetEnd;
    final /* synthetic */ MutableState<Float> $rawOffsetStart;
    final /* synthetic */ MutableState<Float> $startThumbWidth$delegate;
    final /* synthetic */ MutableState<Integer> $totalWidth$delegate;
    final /* synthetic */ ClosedFloatingPointRange<Float> $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    SliderKt$RangeSliderImpl$2(Ref.ObjectRef<MutableState<Boolean>> objectRef, MutableState<Float> mutableState, ClosedFloatingPointRange<Float> closedFloatingPointRange, MutableState<Float> mutableState2, float f, float f2, MutableState<Float> mutableState3, MutableState<Float> mutableState4, MutableState<Integer> mutableState5, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        this.$obtainedMeasurements = objectRef;
        this.$rawOffsetStart = mutableState;
        this.$value = closedFloatingPointRange;
        this.$rawOffsetEnd = mutableState2;
        this.$positionFractionStart = f;
        this.$positionFractionEnd = f2;
        this.$startThumbWidth$delegate = mutableState3;
        this.$endThumbWidth$delegate = mutableState4;
        this.$totalWidth$delegate = mutableState5;
        this.$valueRange = closedFloatingPointRange2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1970measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        List<? extends Measurable> $this$first$iv = measurables;
        long j = constraints;
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter($this$first$iv, "measurables");
        for (Object element$iv : $this$first$iv) {
            if ((LayoutIdKt.getLayoutId((Measurable) element$iv) == RangeSliderComponents.STARTTHUMB ? 1 : null) != null) {
                Placeable startThumbPlaceable = ((Measurable) element$iv).m4689measureBRTryo0(j);
                for (Object element$iv2 : $this$first$iv) {
                    if ((LayoutIdKt.getLayoutId((Measurable) element$iv2) == RangeSliderComponents.ENDTHUMB ? 1 : null) != null) {
                        Placeable endThumbPlaceable = ((Measurable) element$iv2).m4689measureBRTryo0(j);
                        for (Object element$iv3 : $this$first$iv) {
                            if ((LayoutIdKt.getLayoutId((Measurable) element$iv3) == RangeSliderComponents.TRACK ? 1 : null) != null) {
                                Placeable trackPlaceable = ((Measurable) element$iv3).m4689measureBRTryo0(Constraints.m5779copyZbe2FdA$default(ConstraintsKt.m5805offsetNN6EwU$default(constraints, (-(startThumbPlaceable.getWidth() + endThumbPlaceable.getWidth())) / 2, 0, 2, (Object) null), 0, 0, 0, 0, 11, (Object) null));
                                int sliderWidth = trackPlaceable.getWidth() + ((startThumbPlaceable.getWidth() + endThumbPlaceable.getWidth()) / 2);
                                int sliderHeight = Math.max(trackPlaceable.getHeight(), Math.max(startThumbPlaceable.getHeight(), endThumbPlaceable.getHeight()));
                                SliderKt.RangeSliderImpl$lambda$26(this.$startThumbWidth$delegate, (float) startThumbPlaceable.getWidth());
                                SliderKt.RangeSliderImpl$lambda$29(this.$endThumbWidth$delegate, (float) endThumbPlaceable.getWidth());
                                SliderKt.RangeSliderImpl$lambda$32(this.$totalWidth$delegate, sliderWidth);
                                if (!((Boolean) ((MutableState) this.$obtainedMeasurements.element).getValue()).booleanValue()) {
                                    float f = (float) 2;
                                    float finalizedMaxPx = Math.max(((float) SliderKt.RangeSliderImpl$lambda$31(this.$totalWidth$delegate)) - (SliderKt.RangeSliderImpl$lambda$28(this.$endThumbWidth$delegate) / f), 0.0f);
                                    float finalizedMinPx = Math.min(SliderKt.RangeSliderImpl$lambda$25(this.$startThumbWidth$delegate) / f, finalizedMaxPx);
                                    this.$rawOffsetStart.setValue(Float.valueOf(SliderKt.RangeSliderImpl$scaleToOffset$34(this.$valueRange, finalizedMinPx, finalizedMaxPx, this.$value.getStart().floatValue())));
                                    this.$rawOffsetEnd.setValue(Float.valueOf(SliderKt.RangeSliderImpl$scaleToOffset$34(this.$valueRange, finalizedMinPx, finalizedMaxPx, this.$value.getEndInclusive().floatValue())));
                                    ((MutableState) this.$obtainedMeasurements.element).setValue(true);
                                }
                                return MeasureScope.layout$default($this$Layout, sliderWidth, sliderHeight, (Map) null, new SliderKt$RangeSliderImpl$2$measure$1(trackPlaceable, startThumbPlaceable.getWidth() / 2, (sliderHeight - trackPlaceable.getHeight()) / 2, startThumbPlaceable, MathKt.roundToInt(((float) trackPlaceable.getWidth()) * this.$positionFractionStart), (sliderHeight - startThumbPlaceable.getHeight()) / 2, endThumbPlaceable, MathKt.roundToInt((((float) trackPlaceable.getWidth()) * this.$positionFractionEnd) + ((SliderKt.RangeSliderImpl$lambda$25(this.$startThumbWidth$delegate) - SliderKt.RangeSliderImpl$lambda$28(this.$endThumbWidth$delegate)) / ((float) 2))), (sliderHeight - endThumbPlaceable.getHeight()) / 2), 4, (Object) null);
                            }
                            MeasureScope measureScope = $this$Layout;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    MeasureScope measureScope2 = $this$Layout;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            MeasureScope measureScope3 = $this$Layout;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}

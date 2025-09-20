package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$Track$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Color> $activeTickColor;
    final /* synthetic */ State<Color> $activeTrackColor;
    final /* synthetic */ State<Color> $inactiveTickColor;
    final /* synthetic */ State<Color> $inactiveTrackColor;
    final /* synthetic */ float $positionFractionEnd;
    final /* synthetic */ float $positionFractionStart;
    final /* synthetic */ float $thumbPx;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ float $trackStrokeWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$Track$1(float f, State<Color> state, float f2, float f3, float f4, State<Color> state2, List<Float> list, State<Color> state3, State<Color> state4) {
        super(1);
        this.$thumbPx = f;
        this.$inactiveTrackColor = state;
        this.$trackStrokeWidth = f2;
        this.$positionFractionEnd = f3;
        this.$positionFractionStart = f4;
        this.$activeTrackColor = state2;
        this.$tickFractions = list;
        this.$inactiveTickColor = state3;
        this.$activeTickColor = state4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        Object answer$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        boolean isRtl = $this$Canvas.getLayoutDirection() == LayoutDirection.Rtl;
        long sliderLeft = OffsetKt.Offset(this.$thumbPx, Offset.m4714getYimpl($this$Canvas.m5575getCenterF1C5BW0()));
        long sliderRight = OffsetKt.Offset(Size.m4782getWidthimpl($this$Canvas.m5576getSizeNHjbRc()) - this.$thumbPx, Offset.m4714getYimpl($this$Canvas.m5575getCenterF1C5BW0()));
        long sliderStart = isRtl ? sliderRight : sliderLeft;
        long sliderEnd = isRtl ? sliderLeft : sliderRight;
        long sliderEnd2 = sliderEnd;
        long sliderStart2 = sliderStart;
        DrawScope.m5544drawLineNGM6Ib0$default($this$Canvas, this.$inactiveTrackColor.getValue().m4973unboximpl(), sliderStart, sliderEnd, this.$trackStrokeWidth, StrokeCap.Companion.m5352getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        DrawScope.m5544drawLineNGM6Ib0$default($this$Canvas, this.$activeTrackColor.getValue().m4973unboximpl(), OffsetKt.Offset(Offset.m4713getXimpl(sliderStart2) + ((Offset.m4713getXimpl(sliderEnd2) - Offset.m4713getXimpl(sliderStart2)) * this.$positionFractionStart), Offset.m4714getYimpl($this$Canvas.m5575getCenterF1C5BW0())), OffsetKt.Offset(Offset.m4713getXimpl(sliderStart2) + ((Offset.m4713getXimpl(sliderEnd2) - Offset.m4713getXimpl(sliderStart2)) * this.$positionFractionEnd), Offset.m4714getYimpl($this$Canvas.m5575getCenterF1C5BW0())), this.$trackStrokeWidth, StrokeCap.Companion.m5352getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        float f = this.$positionFractionEnd;
        float f2 = this.$positionFractionStart;
        Map destination$iv$iv = new LinkedHashMap();
        for (Object element$iv$iv : this.$tickFractions) {
            float it = ((Number) element$iv$iv).floatValue();
            Object key$iv$iv = Boolean.valueOf(it > f || it < f2);
            Map $this$getOrPut$iv$iv$iv = destination$iv$iv;
            Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                answer$iv$iv$iv = (List) new ArrayList();
                $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
            } else {
                answer$iv$iv$iv = value$iv$iv$iv;
            }
            ((List) answer$iv$iv$iv).add(element$iv$iv);
        }
        State<Color> state = this.$inactiveTickColor;
        State<Color> state2 = this.$activeTickColor;
        float f3 = this.$trackStrokeWidth;
        for (Map.Entry element$iv : destination$iv$iv.entrySet()) {
            boolean outsideFraction = ((Boolean) element$iv.getKey()).booleanValue();
            Iterable<Number> $this$map$iv = (List) element$iv.getValue();
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Number floatValue : $this$map$iv) {
                long sliderStart3 = sliderStart2;
                State<Color> state3 = state2;
                long sliderEnd3 = sliderEnd2;
                destination$iv$iv2.add(Offset.m4702boximpl(OffsetKt.Offset(Offset.m4713getXimpl(OffsetKt.m4736lerpWko1d7g(sliderStart3, sliderEnd3, floatValue.floatValue())), Offset.m4714getYimpl($this$Canvas.m5575getCenterF1C5BW0()))));
                sliderEnd2 = sliderEnd3;
                state = state;
                state2 = state3;
                isRtl = isRtl;
                sliderStart2 = sliderStart3;
            }
            boolean isRtl2 = isRtl;
            long sliderStart4 = sliderStart2;
            State<Color> state4 = state2;
            State<Color> state5 = state;
            long sliderEnd4 = sliderEnd2;
            DrawScope.m5549drawPointsF8ZwMP8$default($this$Canvas, (List) destination$iv$iv2, PointMode.Companion.m5286getPointsr_lszbg(), (outsideFraction ? state5 : state4).getValue().m4973unboximpl(), f3, StrokeCap.Companion.m5352getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
            f3 = f3;
            state2 = state4;
            state = state5;
            isRtl = isRtl2;
            sliderStart2 = sliderStart4;
            sliderEnd2 = sliderEnd4;
        }
    }
}

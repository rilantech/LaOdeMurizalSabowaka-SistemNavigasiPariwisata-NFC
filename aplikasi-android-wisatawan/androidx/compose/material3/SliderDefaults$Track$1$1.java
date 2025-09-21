package androidx.compose.material3;

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

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderDefaults$Track$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Color> $activeTickColor;
    final /* synthetic */ State<Color> $activeTrackColor;
    final /* synthetic */ State<Color> $inactiveTickColor;
    final /* synthetic */ State<Color> $inactiveTrackColor;
    final /* synthetic */ SliderPositions $sliderPositions;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderDefaults$Track$1$1(State<Color> state, SliderPositions sliderPositions, State<Color> state2, State<Color> state3, State<Color> state4) {
        super(1);
        this.$inactiveTrackColor = state;
        this.$sliderPositions = sliderPositions;
        this.$activeTrackColor = state2;
        this.$inactiveTickColor = state3;
        this.$activeTickColor = state4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        Object answer$iv$iv$iv;
        DrawScope drawScope = $this$Canvas;
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        boolean isRtl = $this$Canvas.getLayoutDirection() == LayoutDirection.Rtl;
        long sliderLeft = OffsetKt.Offset(0.0f, Offset.m3004getYimpl($this$Canvas.m3865getCenterF1C5BW0()));
        long sliderRight = OffsetKt.Offset(Size.m3072getWidthimpl($this$Canvas.m3866getSizeNHjbRc()), Offset.m3004getYimpl($this$Canvas.m3865getCenterF1C5BW0()));
        long sliderStart = isRtl ? sliderRight : sliderLeft;
        long sliderEnd = isRtl ? sliderLeft : sliderRight;
        float tickSize = drawScope.m5825toPx0680j_4(SliderKt.TickSize);
        float r8 = drawScope.m5825toPx0680j_4(SliderKt.getTrackHeight());
        long sliderStart2 = sliderEnd;
        long sliderStart3 = sliderStart;
        DrawScope.m3834drawLineNGM6Ib0$default($this$Canvas, this.$inactiveTrackColor.getValue().m3263unboximpl(), sliderStart, sliderEnd, r8, StrokeCap.Companion.m3642getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        DrawScope.m3834drawLineNGM6Ib0$default($this$Canvas, this.$activeTrackColor.getValue().m3263unboximpl(), OffsetKt.Offset(Offset.m3003getXimpl(sliderStart3) + ((Offset.m3003getXimpl(sliderStart2) - Offset.m3003getXimpl(sliderStart3)) * this.$sliderPositions.getActiveRange().getStart().floatValue()), Offset.m3004getYimpl($this$Canvas.m3865getCenterF1C5BW0())), OffsetKt.Offset(Offset.m3003getXimpl(sliderStart3) + ((Offset.m3003getXimpl(sliderStart2) - Offset.m3003getXimpl(sliderStart3)) * this.$sliderPositions.getActiveRange().getEndInclusive().floatValue()), Offset.m3004getYimpl($this$Canvas.m3865getCenterF1C5BW0())), r8, StrokeCap.Companion.m3642getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        float[] $this$groupBy$iv = this.$sliderPositions.getTickFractions();
        SliderPositions sliderPositions = this.$sliderPositions;
        Map destination$iv$iv = new LinkedHashMap();
        for (float element$iv$iv : $this$groupBy$iv) {
            float it = element$iv$iv;
            Object key$iv$iv = Boolean.valueOf(it > sliderPositions.getActiveRange().getEndInclusive().floatValue() || it < sliderPositions.getActiveRange().getStart().floatValue());
            Map $this$getOrPut$iv$iv$iv = destination$iv$iv;
            Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                answer$iv$iv$iv = (List) new ArrayList();
                $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
            } else {
                answer$iv$iv$iv = value$iv$iv$iv;
            }
            ((List) answer$iv$iv$iv).add(Float.valueOf(element$iv$iv));
        }
        State<Color> state = this.$inactiveTickColor;
        State<Color> state2 = this.$activeTickColor;
        for (Map.Entry element$iv : destination$iv$iv.entrySet()) {
            boolean outsideFraction = ((Boolean) element$iv.getKey()).booleanValue();
            Iterable<Number> $this$map$iv = (List) element$iv.getValue();
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Number floatValue : $this$map$iv) {
                long sliderStart4 = sliderStart3;
                long sliderEnd2 = sliderStart2;
                destination$iv$iv2.add(Offset.m2992boximpl(OffsetKt.Offset(Offset.m3003getXimpl(OffsetKt.m3026lerpWko1d7g(sliderStart4, sliderEnd2, floatValue.floatValue())), Offset.m3004getYimpl($this$Canvas.m3865getCenterF1C5BW0()))));
                sliderStart3 = sliderStart4;
                $this$map$iv = $this$map$iv;
                sliderStart2 = sliderEnd2;
            }
            long sliderStart5 = sliderStart3;
            long sliderEnd3 = sliderStart2;
            Iterable iterable = $this$map$iv;
            DrawScope.m3839drawPointsF8ZwMP8$default($this$Canvas, (List) destination$iv$iv2, PointMode.Companion.m3576getPointsr_lszbg(), (outsideFraction ? state : state2).getValue().m3263unboximpl(), tickSize, StrokeCap.Companion.m3642getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
            sliderStart3 = sliderStart5;
            sliderStart2 = sliderEnd3;
        }
    }
}

package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$CircularProgressIndicator$3 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Float> $baseRotation;
    final /* synthetic */ long $color;
    final /* synthetic */ State<Integer> $currentRotation;
    final /* synthetic */ State<Float> $endAngle;
    final /* synthetic */ State<Float> $startAngle;
    final /* synthetic */ Stroke $stroke;
    final /* synthetic */ float $strokeWidth;
    final /* synthetic */ long $trackColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$CircularProgressIndicator$3(long j, Stroke stroke, State<Integer> state, State<Float> state2, State<Float> state3, State<Float> state4, float f, long j2) {
        super(1);
        this.$trackColor = j;
        this.$stroke = stroke;
        this.$currentRotation = state;
        this.$endAngle = state2;
        this.$startAngle = state3;
        this.$baseRotation = state4;
        this.$strokeWidth = f;
        this.$color = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        ProgressIndicatorKt.m3636drawCircularIndicatorTrackbw27NRU($this$Canvas, this.$trackColor, this.$stroke);
        float sweep = Math.abs(this.$endAngle.getValue().floatValue() - this.$startAngle.getValue().floatValue());
        DrawScope drawScope = $this$Canvas;
        float f = sweep;
        ProgressIndicatorKt.m3638drawIndeterminateCircularIndicatorhrjfTZI(drawScope, this.$startAngle.getValue().floatValue() + -90.0f + ((this.$currentRotation.getValue().floatValue() * 216.0f) % 360.0f) + this.$baseRotation.getValue().floatValue(), this.$strokeWidth, f, this.$color, this.$stroke);
    }
}

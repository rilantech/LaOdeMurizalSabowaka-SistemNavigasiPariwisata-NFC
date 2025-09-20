package androidx.compose.material3;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$CircularProgressIndicator$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ float $coercedProgress;
    final /* synthetic */ long $color;
    final /* synthetic */ Stroke $stroke;
    final /* synthetic */ long $trackColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$CircularProgressIndicator$1(float f, long j, Stroke stroke, long j2) {
        super(1);
        this.$coercedProgress = f;
        this.$trackColor = j;
        this.$stroke = stroke;
        this.$color = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float sweep = this.$coercedProgress * 360.0f;
        ProgressIndicatorKt.m1926drawCircularIndicatorTrackbw27NRU($this$Canvas, this.$trackColor, this.$stroke);
        ProgressIndicatorKt.m1927drawDeterminateCircularIndicator42QJj7c($this$Canvas, 270.0f, sweep, this.$color, this.$stroke);
    }
}

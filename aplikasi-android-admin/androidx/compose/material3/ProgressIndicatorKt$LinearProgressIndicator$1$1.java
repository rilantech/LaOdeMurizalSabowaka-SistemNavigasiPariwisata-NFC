package androidx.compose.material3;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$LinearProgressIndicator$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ float $coercedProgress;
    final /* synthetic */ long $color;
    final /* synthetic */ int $strokeCap;
    final /* synthetic */ long $trackColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$LinearProgressIndicator$1$1(long j, int i, float f, long j2) {
        super(1);
        this.$trackColor = j;
        this.$strokeCap = i;
        this.$coercedProgress = f;
        this.$color = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float strokeWidth = Size.m4779getHeightimpl($this$Canvas.m5576getSizeNHjbRc());
        ProgressIndicatorKt.m3640drawLinearIndicatorTrackAZGd3zU($this$Canvas, this.$trackColor, strokeWidth, this.$strokeCap);
        ProgressIndicatorKt.m3639drawLinearIndicatorqYKTg0g($this$Canvas, 0.0f, this.$coercedProgress, this.$color, strokeWidth, this.$strokeCap);
    }
}

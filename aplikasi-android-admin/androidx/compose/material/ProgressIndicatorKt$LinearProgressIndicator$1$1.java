package androidx.compose.material;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$LinearProgressIndicator$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ float $coercedProgress;
    final /* synthetic */ long $color;
    final /* synthetic */ int $strokeCap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$LinearProgressIndicator$1$1(long j, int i, float f, long j2) {
        super(1);
        this.$backgroundColor = j;
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
        ProgressIndicatorKt.m3097drawLinearIndicatorBackgroundAZGd3zU($this$Canvas, this.$backgroundColor, strokeWidth, this.$strokeCap);
        ProgressIndicatorKt.m3096drawLinearIndicatorqYKTg0g($this$Canvas, 0.0f, this.$coercedProgress, this.$color, strokeWidth, this.$strokeCap);
    }
}

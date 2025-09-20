package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$LinearProgressIndicator$3$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ long $color;
    final /* synthetic */ State<Float> $firstLineHead$delegate;
    final /* synthetic */ State<Float> $firstLineTail$delegate;
    final /* synthetic */ State<Float> $secondLineHead$delegate;
    final /* synthetic */ State<Float> $secondLineTail$delegate;
    final /* synthetic */ int $strokeCap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$LinearProgressIndicator$3$1(long j, int i, long j2, State<Float> state, State<Float> state2, State<Float> state3, State<Float> state4) {
        super(1);
        this.$backgroundColor = j;
        this.$strokeCap = i;
        this.$color = j2;
        this.$firstLineHead$delegate = state;
        this.$firstLineTail$delegate = state2;
        this.$secondLineHead$delegate = state3;
        this.$secondLineTail$delegate = state4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float strokeWidth = Size.m3069getHeightimpl($this$Canvas.m3866getSizeNHjbRc());
        ProgressIndicatorKt.m1387drawLinearIndicatorBackgroundAZGd3zU($this$Canvas, this.$backgroundColor, strokeWidth, this.$strokeCap);
        if (ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$1(this.$firstLineHead$delegate) - ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2(this.$firstLineTail$delegate) > 0.0f) {
            ProgressIndicatorKt.m1386drawLinearIndicatorqYKTg0g($this$Canvas, ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$1(this.$firstLineHead$delegate), ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2(this.$firstLineTail$delegate), this.$color, strokeWidth, this.$strokeCap);
        }
        if (ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$3(this.$secondLineHead$delegate) - ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4(this.$secondLineTail$delegate) > 0.0f) {
            ProgressIndicatorKt.m1386drawLinearIndicatorqYKTg0g($this$Canvas, ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$3(this.$secondLineHead$delegate), ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4(this.$secondLineTail$delegate), this.$color, strokeWidth, this.$strokeCap);
        }
    }
}

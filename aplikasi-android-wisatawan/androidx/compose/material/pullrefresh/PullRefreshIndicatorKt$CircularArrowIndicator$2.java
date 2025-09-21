package androidx.compose.material.pullrefresh;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import com.google.android.material.internal.ViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullRefreshIndicator.kt */
final class PullRefreshIndicatorKt$CircularArrowIndicator$2 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Float> $alphaState;
    final /* synthetic */ long $color;
    final /* synthetic */ Path $path;
    final /* synthetic */ PullRefreshState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullRefreshIndicatorKt$CircularArrowIndicator$2(PullRefreshState pullRefreshState, State<Float> state, long j, Path path) {
        super(1);
        this.$state = pullRefreshState;
        this.$alphaState = state;
        this.$color = j;
        this.$path = path;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        ArrowValues values = PullRefreshIndicatorKt.ArrowValues(this.$state.getProgress());
        float alpha = this.$alphaState.getValue().floatValue();
        float degrees$iv = values.getRotation();
        long j = this.$color;
        Path path = this.$path;
        DrawScope $this$rotate_u2dRg1IO4c_u24default$iv = $this$Canvas;
        long pivot$iv = $this$rotate_u2dRg1IO4c_u24default$iv.m3865getCenterF1C5BW0();
        DrawScope $this$withTransform$iv$iv = $this$rotate_u2dRg1IO4c_u24default$iv;
        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform$iv$iv.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.m3809getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv$iv.getTransform().m3924rotateUv8p0NA(degrees$iv, pivot$iv);
        DrawScope $this$invoke_u24lambda_u240 = $this$withTransform$iv$iv;
        float arcRadius = $this$invoke_u24lambda_u240.m5825toPx0680j_4(PullRefreshIndicatorKt.ArcRadius) + ($this$invoke_u24lambda_u240.m5825toPx0680j_4(PullRefreshIndicatorKt.StrokeWidth) / 2.0f);
        Rect arcBounds = new Rect(Offset.m3003getXimpl(SizeKt.m3082getCenteruvyYCjk($this$invoke_u24lambda_u240.m3866getSizeNHjbRc())) - arcRadius, Offset.m3004getYimpl(SizeKt.m3082getCenteruvyYCjk($this$invoke_u24lambda_u240.m3866getSizeNHjbRc())) - arcRadius, Offset.m3003getXimpl(SizeKt.m3082getCenteruvyYCjk($this$invoke_u24lambda_u240.m3866getSizeNHjbRc())) + arcRadius, Offset.m3004getYimpl(SizeKt.m3082getCenteruvyYCjk($this$invoke_u24lambda_u240.m3866getSizeNHjbRc())) + arcRadius);
        DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv;
        long j2 = pivot$iv;
        DrawScope.m3827drawArcyD3GUKo$default($this$invoke_u24lambda_u240, j, values.getStartAngle(), values.getEndAngle() - values.getStartAngle(), false, arcBounds.m3038getTopLeftF1C5BW0(), arcBounds.m3036getSizeNHjbRc(), alpha, new Stroke($this$invoke_u24lambda_u240.m5825toPx0680j_4(PullRefreshIndicatorKt.StrokeWidth), 0.0f, StrokeCap.Companion.m3643getSquareKaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null), (ColorFilter) null, 0, ViewUtils.EDGE_TO_EDGE_FLAGS, (Object) null);
        Path path2 = path;
        float f = degrees$iv;
        PullRefreshIndicatorKt.m1506drawArrowBx497Mc($this$invoke_u24lambda_u240, path2, arcBounds, j, alpha, values);
        $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv$iv2.m3810setSizeuvyYCjk(previousSize$iv$iv);
    }
}

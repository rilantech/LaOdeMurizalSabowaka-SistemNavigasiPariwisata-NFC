package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: RadioButton.kt */
final class RadioButtonKt$RadioButton$2$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Dp> $dotRadius;
    final /* synthetic */ State<Color> $radioColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RadioButtonKt$RadioButton$2$1(State<Color> state, State<Dp> state2) {
        super(1);
        this.$radioColor = state;
        this.$dotRadius = state2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        DrawScope drawScope = $this$Canvas;
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        float strokeWidth = drawScope.m7535toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
        long r10 = this.$radioColor.getValue().m4973unboximpl();
        float f = (float) 2;
        DrawScope.m5539drawCircleVaOC9Bg$default($this$Canvas, r10, drawScope.m7535toPx0680j_4(RadioButtonKt.RadioRadius) - (strokeWidth / f), 0, 0.0f, new Stroke(strokeWidth, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 108, (Object) null);
        if (Dp.m7553compareTo0680j_4(this.$dotRadius.getValue().m7568unboximpl(), Dp.m7554constructorimpl((float) 0)) > 0) {
            DrawScope.m5539drawCircleVaOC9Bg$default($this$Canvas, this.$radioColor.getValue().m4973unboximpl(), drawScope.m7535toPx0680j_4(this.$dotRadius.getValue().m7568unboximpl()) - (strokeWidth / f), 0, 0.0f, Fill.INSTANCE, (ColorFilter) null, 0, 108, (Object) null);
        }
    }
}

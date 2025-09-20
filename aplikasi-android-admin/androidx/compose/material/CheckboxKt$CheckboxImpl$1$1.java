package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Checkbox.kt */
final class CheckboxKt$CheckboxImpl$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Color> $borderColor$delegate;
    final /* synthetic */ State<Color> $boxColor$delegate;
    final /* synthetic */ CheckDrawingCache $checkCache;
    final /* synthetic */ State<Float> $checkCenterGravitationShiftFraction$delegate;
    final /* synthetic */ State<Color> $checkColor$delegate;
    final /* synthetic */ State<Float> $checkDrawFraction$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckboxKt$CheckboxImpl$1$1(CheckDrawingCache checkDrawingCache, State<Color> state, State<Color> state2, State<Color> state3, State<Float> state4, State<Float> state5) {
        super(1);
        this.$checkCache = checkDrawingCache;
        this.$boxColor$delegate = state;
        this.$borderColor$delegate = state2;
        this.$checkColor$delegate = state3;
        this.$checkDrawFraction$delegate = state4;
        this.$checkCenterGravitationShiftFraction$delegate = state5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float strokeWidthPx = (float) Math.floor((double) $this$Canvas.m7535toPx0680j_4(CheckboxKt.StrokeWidth));
        DrawScope drawScope = $this$Canvas;
        CheckboxKt.m2932drawBox1wkBAMs(drawScope, CheckboxKt.CheckboxImpl$lambda$9(this.$boxColor$delegate), CheckboxKt.CheckboxImpl$lambda$10(this.$borderColor$delegate), $this$Canvas.m7535toPx0680j_4(CheckboxKt.RadiusSize), strokeWidthPx);
        CheckboxKt.m2933drawCheck3IgeMak(drawScope, CheckboxKt.CheckboxImpl$lambda$8(this.$checkColor$delegate), CheckboxKt.CheckboxImpl$lambda$4(this.$checkDrawFraction$delegate), CheckboxKt.CheckboxImpl$lambda$6(this.$checkCenterGravitationShiftFraction$delegate), strokeWidthPx, this.$checkCache);
    }
}

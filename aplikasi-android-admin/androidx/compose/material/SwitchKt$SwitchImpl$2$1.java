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
/* compiled from: Switch.kt */
final class SwitchKt$SwitchImpl$2$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Color> $trackColor$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwitchKt$SwitchImpl$2$1(State<Color> state) {
        super(1);
        this.$trackColor$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        SwitchKt.m3148drawTrackRPmYEkk($this$Canvas, SwitchKt.SwitchImpl$lambda$16(this.$trackColor$delegate), $this$Canvas.m7535toPx0680j_4(SwitchKt.getTrackWidth()), $this$Canvas.m7535toPx0680j_4(SwitchKt.getTrackStrokeWidth()));
    }
}

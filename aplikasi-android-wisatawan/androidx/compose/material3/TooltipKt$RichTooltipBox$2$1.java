package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
final class TooltipKt$RichTooltipBox$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $action;
    final /* synthetic */ RichTooltipState $tooltipState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TooltipKt$RichTooltipBox$2$1(RichTooltipState richTooltipState, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(0);
        this.$tooltipState = richTooltipState;
        this.$action = function2;
    }

    public final void invoke() {
        this.$tooltipState.setPersistent$material3_release(this.$action != null);
    }
}

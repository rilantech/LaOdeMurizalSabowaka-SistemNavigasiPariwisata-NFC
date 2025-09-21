package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
final class TooltipKt$RichTooltipBox$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $action;
    final /* synthetic */ RichTooltipColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TooltipKt$RichTooltipBox$3(RichTooltipColors richTooltipColors, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i) {
        super(2);
        this.$colors = richTooltipColors;
        this.$text = function2;
        this.$title = function22;
        this.$action = function23;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C168@7230L155:Tooltip.kt#uh7d8r");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1423372873, $changed, -1, "androidx.compose.material3.RichTooltipBox.<anonymous> (Tooltip.kt:167)");
            }
            RichTooltipColors richTooltipColors = this.$colors;
            Function2<Composer, Integer, Unit> function2 = this.$text;
            Function2<Composer, Integer, Unit> function22 = this.$title;
            Function2<Composer, Integer, Unit> function23 = this.$action;
            int i = this.$$dirty;
            TooltipKt.RichTooltipImpl(richTooltipColors, function2, function22, function23, $composer, ((i >> 18) & 14) | ((i << 3) & 112) | ((i >> 3) & 896) | ((i >> 3) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

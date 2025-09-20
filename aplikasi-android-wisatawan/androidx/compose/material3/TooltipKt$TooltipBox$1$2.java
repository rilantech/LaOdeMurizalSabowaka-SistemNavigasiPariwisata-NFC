package androidx.compose.material3;

import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
final class TooltipKt$TooltipBox$1$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ float $elevation;
    final /* synthetic */ float $maxWidth;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tooltipContent;
    final /* synthetic */ String $tooltipPaneDescription;
    final /* synthetic */ Transition<Boolean> $transition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TooltipKt$TooltipBox$1$2(Modifier modifier, float f, Transition<Boolean> transition, String str, Shape shape, long j, float f2, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$modifier = modifier;
        this.$maxWidth = f;
        this.$transition = transition;
        this.$tooltipPaneDescription = str;
        this.$shape = shape;
        this.$containerColor = j;
        this.$elevation = f2;
        this.$tooltipContent = function2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv$iv;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C265@10968L38,257@10611L635:Tooltip.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-442150991, i, -1, "androidx.compose.material3.TooltipBox.<anonymous>.<anonymous> (Tooltip.kt:256)");
            }
            Modifier access$animateTooltip = TooltipKt.animateTooltip(SizeKt.m616sizeInqDBjuR0$default(this.$modifier, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), this.$maxWidth, 0.0f, 8, (Object) null), this.$transition);
            Object key1$iv = this.$tooltipPaneDescription;
            String str = this.$tooltipPaneDescription;
            composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = composer.changed(key1$iv);
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = (Function1) new TooltipKt$TooltipBox$1$2$1$1(str);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            Modifier semantics$default = SemanticsModifierKt.semantics$default(access$animateTooltip, false, (Function1) value$iv$iv, 1, (Object) null);
            Shape shape = this.$shape;
            long j = this.$containerColor;
            float f = this.$elevation;
            Function2<Composer, Integer, Unit> function2 = this.$tooltipContent;
            int i2 = this.$$dirty;
            SurfaceKt.m2062SurfaceT9BRK9s(semantics$default, shape, j, 0, f, f, (BorderStroke) null, function2, $composer, ((i2 >> 6) & 112) | ((i2 >> 9) & 896) | (57344 & (i2 >> 6)) | ((i2 >> 3) & 458752) | ((i2 << 21) & 29360128), 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

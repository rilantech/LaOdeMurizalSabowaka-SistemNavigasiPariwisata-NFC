package androidx.compose.material3;

import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$ListItem$decoratedHeadlineContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ ListItemColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $headlineContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListItemKt$ListItem$decoratedHeadlineContent$1(ListItemColors listItemColors, int i, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.$colors = listItemColors;
        this.$$dirty = i;
        this.$headlineContent = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C86@4020L29,85@3974L166:ListItem.kt#uh7d8r");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-403249643, $changed, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:84)");
            }
            ListItemKt.m3541ProvideTextStyleFromToken3JVO9M(this.$colors.headlineColor$material3_release(true, $composer, ((this.$$dirty >> 15) & 112) | 6).getValue().m4973unboximpl(), ListTokens.INSTANCE.getListItemLabelTextFont(), this.$headlineContent, $composer, ((this.$$dirty << 6) & 896) | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

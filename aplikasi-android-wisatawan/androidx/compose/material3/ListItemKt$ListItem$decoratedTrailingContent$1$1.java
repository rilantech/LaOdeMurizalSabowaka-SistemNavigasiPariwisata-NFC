package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$ListItem$decoratedTrailingContent$1$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ ListItemColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $it;
    final /* synthetic */ int $listItemType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListItemKt$ListItem$decoratedTrailingContent$1$1(ListItemColors listItemColors, int i, int i2, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(3);
        this.$colors = listItemColors;
        this.$$dirty = i;
        this.$listItemType = i2;
        this.$it = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((RowScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope $this$null, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        ComposerKt.sourceInformation($composer, "C128@5421L33,127@5366L205:ListItem.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer.changed((Object) $this$null) ? 4 : 2;
        }
        if (($dirty & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1392069445, $dirty, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:126)");
            }
            ListItemKt.m1832TrailingContent3IgeMak($this$null, this.$colors.trailingIconColor$material3_release(true, $composer, ((this.$$dirty >> 15) & 112) | 6).getValue().m3263unboximpl(), ListItemType.m1841equalsimpl0(this.$listItemType, ListItemType.Companion.m1848getThreeLineAlXitO8()), this.$it, $composer, $dirty & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

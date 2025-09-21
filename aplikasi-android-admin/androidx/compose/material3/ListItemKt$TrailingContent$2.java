package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$TrailingContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ RowScope $this_TrailingContent;
    final /* synthetic */ boolean $topAlign;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListItemKt$TrailingContent$2(RowScope rowScope, long j, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$this_TrailingContent = rowScope;
        this.$contentColor = j;
        this.$topAlign = z;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ListItemKt.m3542TrailingContent3IgeMak(this.$this_TrailingContent, this.$contentColor, this.$topAlign, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}

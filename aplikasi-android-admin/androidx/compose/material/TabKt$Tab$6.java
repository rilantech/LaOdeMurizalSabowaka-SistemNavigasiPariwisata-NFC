package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tab.kt */
final class TabKt$Tab$6 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ long $selectedContentColor;
    final /* synthetic */ long $unselectedContentColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabKt$Tab$6(boolean z, Function0<Unit> function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, long j, long j2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i, int i2) {
        super(2);
        this.$selected = z;
        this.$onClick = function0;
        this.$modifier = modifier;
        this.$enabled = z2;
        this.$interactionSource = mutableInteractionSource;
        this.$selectedContentColor = j;
        this.$unselectedContentColor = j2;
        this.$content = function3;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TabKt.m3152TabEVJuX4I(this.$selected, this.$onClick, this.$modifier, this.$enabled, this.$interactionSource, this.$selectedContentColor, this.$unselectedContentColor, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}

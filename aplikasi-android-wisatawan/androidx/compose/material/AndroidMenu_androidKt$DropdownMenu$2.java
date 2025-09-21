package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidMenu.android.kt */
final class AndroidMenu_androidKt$DropdownMenu$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ MutableTransitionState<Boolean> $expandedStates;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ MutableState<TransformOrigin> $transformOriginState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidMenu_androidKt$DropdownMenu$2(MutableTransitionState<Boolean> mutableTransitionState, MutableState<TransformOrigin> mutableState, ScrollState scrollState, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$expandedStates = mutableTransitionState;
        this.$transformOriginState = mutableState;
        this.$scrollState = scrollState;
        this.$modifier = modifier;
        this.$content = function3;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C173@8667L258:AndroidMenu.android.kt#jmzs0o");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-47803778, $changed, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:172)");
            }
            MutableTransitionState<Boolean> mutableTransitionState = this.$expandedStates;
            MutableState<TransformOrigin> mutableState = this.$transformOriginState;
            ScrollState scrollState = this.$scrollState;
            Modifier modifier = this.$modifier;
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$content;
            int i = this.$$dirty;
            MenuKt.DropdownMenuContent(mutableTransitionState, mutableState, scrollState, modifier, function3, $composer, MutableTransitionState.$stable | 48 | ((i >> 6) & 896) | ((i << 3) & 7168) | ((i >> 6) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomNavigation.kt */
final class BottomNavigationKt$BottomNavigationTransition$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ State<Float> $animationProgress$delegate;
    final /* synthetic */ Function3<Float, Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomNavigationKt$BottomNavigationTransition$1(Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, int i, State<Float> state) {
        super(2);
        this.$content = function3;
        this.$$dirty = i;
        this.$animationProgress$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C238@10046L26:BottomNavigation.kt#jmzs0o");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-138092754, $changed, -1, "androidx.compose.material.BottomNavigationTransition.<anonymous> (BottomNavigation.kt:237)");
            }
            this.$content.invoke(Float.valueOf(BottomNavigationKt.BottomNavigationTransition_Klgx_Pg$lambda$3(this.$animationProgress$delegate)), $composer, Integer.valueOf((this.$$dirty >> 6) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

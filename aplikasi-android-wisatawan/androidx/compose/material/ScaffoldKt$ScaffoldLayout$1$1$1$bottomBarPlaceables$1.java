package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scaffold.kt */
final class ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomBar;
    final /* synthetic */ FabPlacement $fabPlacement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1(FabPlacement fabPlacement, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$fabPlacement = fabPlacement;
        this.$bottomBar = function2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C289@12424L144:Scaffold.kt#jmzs0o");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1529070963, $changed, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:288)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ScaffoldKt.getLocalFabPlacement().provides(this.$fabPlacement)}, (Function2<? super Composer, ? super Integer, Unit>) this.$bottomBar, $composer, ((this.$$dirty >> 15) & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

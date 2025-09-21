package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffold$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffold$2(Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, BottomSheetScaffoldState bottomSheetScaffoldState, int i) {
        super(2);
        this.$snackbarHost = function3;
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$$dirty1 = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C119@6159L45:BottomSheetScaffold.kt#uh7d8r");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1629779374, $changed, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:118)");
            }
            this.$snackbarHost.invoke(this.$scaffoldState.getSnackbarHostState(), $composer, Integer.valueOf((this.$$dirty1 >> 3) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

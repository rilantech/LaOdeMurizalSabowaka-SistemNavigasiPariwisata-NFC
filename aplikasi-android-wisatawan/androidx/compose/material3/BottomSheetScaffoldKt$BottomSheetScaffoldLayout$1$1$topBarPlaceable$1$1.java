package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$topBarPlaceable$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$topBarPlaceable$1$1(Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$topBar = function2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C340@14892L8:BottomSheetScaffold.kt#uh7d8r");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-873203005, $changed, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:340)");
            }
            this.$topBar.invoke($composer, Integer.valueOf((this.$$dirty >> 3) & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

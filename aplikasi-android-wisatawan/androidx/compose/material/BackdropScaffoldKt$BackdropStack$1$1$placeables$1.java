package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackdropScaffold.kt */
final class BackdropScaffoldKt$BackdropStack$1$1$placeables$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ float $backLayerHeight;
    final /* synthetic */ long $constraints;
    final /* synthetic */ Function4<Constraints, Float, Composer, Integer, Unit> $frontLayer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$BackdropStack$1$1$placeables$1(Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, long j, float f, int i) {
        super(2);
        this.$frontLayer = function4;
        this.$constraints = j;
        this.$backLayerHeight = f;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C466@19305L40:BackdropScaffold.kt#jmzs0o");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1222642649, $changed, -1, "androidx.compose.material.BackdropStack.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:465)");
            }
            this.$frontLayer.invoke(Constraints.m5776boximpl(this.$constraints), Float.valueOf(this.$backLayerHeight), $composer, Integer.valueOf((this.$$dirty >> 3) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

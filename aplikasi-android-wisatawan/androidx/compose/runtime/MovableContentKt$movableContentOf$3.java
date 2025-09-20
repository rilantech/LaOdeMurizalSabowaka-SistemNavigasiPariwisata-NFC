package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u0002H\u0003H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "P1", "P2", "p1", "p2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: MovableContent.kt */
final class MovableContentKt$movableContentOf$3 extends Lambda implements Function4<P1, P2, Composer, Integer, Unit> {
    final /* synthetic */ MovableContent<Pair<P1, P2>> $movableContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MovableContentKt$movableContentOf$3(MovableContent<Pair<P1, P2>> movableContent) {
        super(4);
        this.$movableContent = movableContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
        invoke(p1, p2, (Composer) p3, ((Number) p4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(P1 p1, P2 p2, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:MovableContent.kt#9igjgp");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer.changed((Object) p1) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer.changed((Object) p2) ? 32 : 16;
        }
        if (($dirty & 731) != 146 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1200019734, $changed, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:88)");
            }
            $composer.insertMovableContent(this.$movableContent, TuplesKt.to(p1, p2));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListIntervalContent.kt */
final class LazyListIntervalContent$item$3 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ Function3<LazyItemScope, Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListIntervalContent$item$3(Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> function3) {
        super(4);
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
        invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope $this$$receiver, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$$receiver, "$this$$receiver");
        ComposerKt.sourceInformation($composer, "C58@2071L9:LazyListIntervalContent.kt#428nma");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer.changed((Object) $this$$receiver) ? 4 : 2;
        }
        if (($dirty & 651) != 130 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1010194746, $dirty, -1, "androidx.compose.foundation.lazy.LazyListIntervalContent.item.<anonymous> (LazyListIntervalContent.kt:58)");
            }
            this.$content.invoke($this$$receiver, $composer, Integer.valueOf($dirty & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

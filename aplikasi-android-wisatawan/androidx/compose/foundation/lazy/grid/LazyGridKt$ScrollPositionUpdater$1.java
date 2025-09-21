package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
final class LazyGridKt$ScrollPositionUpdater$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function0<LazyGridItemProvider> $itemProviderLambda;
    final /* synthetic */ LazyGridState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridKt$ScrollPositionUpdater$1(Function0<? extends LazyGridItemProvider> function0, LazyGridState lazyGridState, int i) {
        super(2);
        this.$itemProviderLambda = function0;
        this.$state = lazyGridState;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LazyGridKt.ScrollPositionUpdater(this.$itemProviderLambda, this.$state, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}

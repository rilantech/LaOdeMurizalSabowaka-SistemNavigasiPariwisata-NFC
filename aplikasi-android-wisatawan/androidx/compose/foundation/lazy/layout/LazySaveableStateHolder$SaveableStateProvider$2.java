package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazySaveableStateHolder.kt */
final class LazySaveableStateHolder$SaveableStateProvider$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Object $key;
    final /* synthetic */ LazySaveableStateHolder $tmp0_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazySaveableStateHolder$SaveableStateProvider$2(LazySaveableStateHolder lazySaveableStateHolder, Object obj, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$tmp0_rcvr = lazySaveableStateHolder;
        this.$key = obj;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp0_rcvr.SaveableStateProvider(this.$key, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}

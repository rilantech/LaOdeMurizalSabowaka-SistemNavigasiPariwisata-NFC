package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridItemProvider.kt */
final class LazyStaggeredGridItemProviderImpl$Item$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $index;
    final /* synthetic */ LazyStaggeredGridItemProviderImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridItemProviderImpl$Item$1(LazyStaggeredGridItemProviderImpl lazyStaggeredGridItemProviderImpl, int i) {
        super(2);
        this.this$0 = lazyStaggeredGridItemProviderImpl;
        this.$index = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C*79@3250L48:LazyStaggeredGridItemProvider.kt#fzvcnm");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(608834466, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderImpl.Item.<anonymous> (LazyStaggeredGridItemProvider.kt:77)");
            }
            int globalIndex$iv = this.$index;
            IntervalList.Interval interval$iv = this.this$0.intervalContent.getIntervals().get(globalIndex$iv);
            ((LazyStaggeredGridInterval) interval$iv.getValue()).getItem().invoke(LazyStaggeredGridItemScopeImpl.INSTANCE, Integer.valueOf(globalIndex$iv - interval$iv.getStartIndex()), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

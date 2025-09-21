package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListItemProvider.kt */
final class LazyListItemProviderImpl$Item$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $index;
    final /* synthetic */ LazyListItemProviderImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListItemProviderImpl$Item$1(LazyListItemProviderImpl lazyListItemProviderImpl, int i) {
        super(2);
        this.this$0 = lazyListItemProviderImpl;
        this.$index = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C*78@3104L27:LazyListItemProvider.kt#428nma");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-824725566, $changed, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item.<anonymous> (LazyListItemProvider.kt:76)");
            }
            int globalIndex$iv = this.$index;
            LazyListItemProviderImpl lazyListItemProviderImpl = this.this$0;
            IntervalList.Interval interval$iv = this.this$0.intervalContent.getIntervals().get(globalIndex$iv);
            ((LazyListInterval) interval$iv.getValue()).getItem().invoke(lazyListItemProviderImpl.getItemScope(), Integer.valueOf(globalIndex$iv - interval$iv.getStartIndex()), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

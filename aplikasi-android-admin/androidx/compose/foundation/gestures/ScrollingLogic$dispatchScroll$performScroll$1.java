package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "delta", "invoke-MK-Hz9U", "(J)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollingLogic$dispatchScroll$performScroll$1 extends Lambda implements Function1<Offset, Offset> {
    final /* synthetic */ int $source;
    final /* synthetic */ ScrollScope $this_dispatchScroll;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollingLogic$dispatchScroll$performScroll$1(ScrollingLogic scrollingLogic, int i, ScrollScope scrollScope) {
        super(1);
        this.this$0 = scrollingLogic;
        this.$source = i;
        this.$this_dispatchScroll = scrollScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return Offset.m4702boximpl(m2084invokeMKHz9U(((Offset) p1).m4723unboximpl()));
    }

    /* renamed from: invoke-MK-Hz9U  reason: not valid java name */
    public final long m2084invokeMKHz9U(long delta) {
        long j = delta;
        NestedScrollDispatcher nestedScrollDispatcher = this.this$0.getNestedScrollDispatcher().getValue();
        long preConsumedByParent = nestedScrollDispatcher.m6074dispatchPreScrollOzD1aCk(j, this.$source);
        long scrollAvailable = Offset.m4717minusMKHz9U(j, preConsumedByParent);
        ScrollingLogic scrollingLogic = this.this$0;
        long axisConsumed = scrollingLogic.m2077reverseIfNeededMKHz9U(scrollingLogic.m2082toOffsettuRUvjQ(this.$this_dispatchScroll.scrollBy(scrollingLogic.m2081toFloatk4lQ0M(scrollingLogic.m2077reverseIfNeededMKHz9U(scrollAvailable)))));
        return Offset.m4718plusMKHz9U(Offset.m4718plusMKHz9U(preConsumedByParent, axisConsumed), nestedScrollDispatcher.m6072dispatchPostScrollDzOQY0M(axisConsumed, Offset.m4717minusMKHz9U(scrollAvailable, axisConsumed), this.$source));
    }
}

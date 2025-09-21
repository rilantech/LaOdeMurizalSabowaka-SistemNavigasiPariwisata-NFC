package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/pager/PagerStateImpl;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
final class PagerStateKt$rememberPagerState$3$1 extends Lambda implements Function0<PagerStateImpl> {
    final /* synthetic */ int $initialPage;
    final /* synthetic */ float $initialPageOffsetFraction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerStateKt$rememberPagerState$3$1(int i, float f) {
        super(0);
        this.$initialPage = i;
        this.$initialPageOffsetFraction = f;
    }

    public final PagerStateImpl invoke() {
        return new PagerStateImpl(this.$initialPage, this.$initialPageOffsetFraction, AnonymousClass1.INSTANCE);
    }
}

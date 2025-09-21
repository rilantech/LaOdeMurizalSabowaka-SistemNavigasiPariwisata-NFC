package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Pager.kt */
final class PagerKt$HorizontalPager$2$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ int $pageCount;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerKt$HorizontalPager$2$1(int i) {
        super(0);
        this.$pageCount = i;
    }

    public final Integer invoke() {
        return Integer.valueOf(this.$pageCount);
    }
}

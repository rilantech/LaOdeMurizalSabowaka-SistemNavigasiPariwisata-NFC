package androidx.compose.foundation.pager;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
final class PagerState$currentPageOffsetFraction$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ PagerState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerState$currentPageOffsetFraction$2(PagerState pagerState) {
        super(0);
        this.this$0 = pagerState;
    }

    public final Float invoke() {
        Object it$iv;
        float f;
        List visiblePagesInfo = this.this$0.getLayoutInfo$foundation_release().getVisiblePagesInfo();
        PagerState pagerState = this.this$0;
        List $this$fastForEach$iv$iv = visiblePagesInfo;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (true) {
            if (index$iv$iv >= size) {
                it$iv = null;
                break;
            }
            it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            if (((PageInfo) it$iv).getIndex() == pagerState.getCurrentPage()) {
                break;
            }
            index$iv$iv++;
        }
        PageInfo pageInfo = (PageInfo) it$iv;
        int currentPagePositionOffset = pageInfo != null ? pageInfo.getOffset() : 0;
        float pageUsedSpace = (float) this.this$0.getPageAvailableSpace();
        if (pageUsedSpace == 0.0f) {
            f = this.this$0.getInitialPageOffsetFraction();
        } else {
            f = RangesKt.coerceIn(((float) (-currentPagePositionOffset)) / pageUsedSpace, -0.5f, 0.5f);
        }
        return Float.valueOf(f);
    }
}

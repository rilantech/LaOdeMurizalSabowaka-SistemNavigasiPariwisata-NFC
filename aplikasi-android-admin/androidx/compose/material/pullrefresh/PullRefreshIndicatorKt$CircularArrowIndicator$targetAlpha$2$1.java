package androidx.compose.material.pullrefresh;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullRefreshIndicator.kt */
final class PullRefreshIndicatorKt$CircularArrowIndicator$targetAlpha$2$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ PullRefreshState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullRefreshIndicatorKt$CircularArrowIndicator$targetAlpha$2$1(PullRefreshState pullRefreshState) {
        super(0);
        this.$state = pullRefreshState;
    }

    public final Float invoke() {
        float f = 1.0f;
        if (this.$state.getProgress() < 1.0f) {
            f = 0.3f;
        }
        return Float.valueOf(f);
    }
}

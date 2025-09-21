package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "S", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
final class Transition$totalDurationNanos$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ Transition<S> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Transition$totalDurationNanos$2(Transition<S> transition) {
        super(0);
        this.this$0 = transition;
    }

    public final Long invoke() {
        long maxDurationNanos = 0;
        for (Transition.TransitionAnimationState it : this.this$0._animations) {
            maxDurationNanos = Math.max(maxDurationNanos, it.getDurationNanos$animation_core_release());
        }
        for (Transition it2 : this.this$0._transitions) {
            maxDurationNanos = Math.max(maxDurationNanos, it2.getTotalDurationNanos());
        }
        return Long.valueOf(maxDurationNanos);
    }
}

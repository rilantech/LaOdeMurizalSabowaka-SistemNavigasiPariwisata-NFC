package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "T", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableState$targetValue$2 extends Lambda implements Function0<T> {
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableState$targetValue$2(AnchoredDraggableState<T> anchoredDraggableState) {
        super(0);
        this.this$0 = anchoredDraggableState;
    }

    public final T invoke() {
        T $this$invoke_u24lambda_u240;
        T access$getAnimationTarget = this.this$0.getAnimationTarget();
        if (access$getAnimationTarget != null) {
            return access$getAnimationTarget;
        }
        AnchoredDraggableState $this$invoke_u24lambda_u2402 = this.this$0;
        float currentOffset = $this$invoke_u24lambda_u2402.getOffset();
        if (!Float.isNaN(currentOffset)) {
            $this$invoke_u24lambda_u240 = $this$invoke_u24lambda_u2402.computeTarget(currentOffset, $this$invoke_u24lambda_u2402.getCurrentValue(), 0.0f);
        } else {
            $this$invoke_u24lambda_u240 = $this$invoke_u24lambda_u2402.getCurrentValue();
        }
        return $this$invoke_u24lambda_u240;
    }
}

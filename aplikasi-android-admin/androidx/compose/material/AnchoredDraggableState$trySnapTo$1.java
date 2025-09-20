package androidx.compose.material;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableState$trySnapTo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ T $targetValue;
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableState$trySnapTo$1(AnchoredDraggableState<T> anchoredDraggableState, T t) {
        super(0);
        this.this$0 = anchoredDraggableState;
        this.$targetValue = t;
    }

    public final void invoke() {
        AnchoredDragScope $this$invoke_u24lambda_u240 = this.this$0.anchoredDragScope;
        AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
        T t = this.$targetValue;
        Float targetOffset = anchoredDraggableState.getAnchors$material_release().get(t);
        if (targetOffset != null) {
            AnchoredDragScope.dragTo$default($this$invoke_u24lambda_u240, targetOffset.floatValue(), 0.0f, 2, (Object) null);
            anchoredDraggableState.setAnimationTarget(null);
        }
        anchoredDraggableState.setCurrentValue(t);
    }
}

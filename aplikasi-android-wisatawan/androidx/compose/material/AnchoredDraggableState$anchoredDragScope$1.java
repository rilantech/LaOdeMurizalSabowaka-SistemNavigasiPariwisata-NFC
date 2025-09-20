package androidx.compose.material;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/compose/material/AnchoredDraggableState$anchoredDragScope$1", "Landroidx/compose/material/AnchoredDragScope;", "dragTo", "", "newOffset", "", "lastKnownVelocity", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
public final class AnchoredDraggableState$anchoredDragScope$1 implements AnchoredDragScope {
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    AnchoredDraggableState$anchoredDragScope$1(AnchoredDraggableState<T> $receiver) {
        this.this$0 = $receiver;
    }

    public void dragTo(float newOffset, float lastKnownVelocity) {
        this.this$0.setOffset(newOffset);
        this.this$0.setLastVelocity(lastKnownVelocity);
    }
}

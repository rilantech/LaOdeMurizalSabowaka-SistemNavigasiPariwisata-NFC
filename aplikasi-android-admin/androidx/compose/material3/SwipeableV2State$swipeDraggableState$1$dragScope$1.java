package androidx.compose.material3;

import androidx.compose.foundation.gestures.DragScope;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/compose/material3/SwipeableV2State$swipeDraggableState$1$dragScope$1", "Landroidx/compose/foundation/gestures/DragScope;", "dragBy", "", "pixels", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeableV2.kt */
public final class SwipeableV2State$swipeDraggableState$1$dragScope$1 implements DragScope {
    final /* synthetic */ SwipeableV2State<T> this$0;

    SwipeableV2State$swipeDraggableState$1$dragScope$1(SwipeableV2State<T> $receiver) {
        this.this$0 = $receiver;
    }

    public void dragBy(float pixels) {
        this.this$0.dispatchRawDelta(pixels);
    }
}

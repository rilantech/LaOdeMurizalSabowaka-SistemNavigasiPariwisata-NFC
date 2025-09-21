package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
final class DraggableNode$_startDragImmediately$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ DraggableNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DraggableNode$_startDragImmediately$1(DraggableNode draggableNode) {
        super(0);
        this.this$0 = draggableNode;
    }

    public final Boolean invoke() {
        return (Boolean) this.this$0.startDragImmediately.invoke();
    }
}

package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.HoverableNode", f = "Hoverable.kt", i = {0}, l = {116}, m = "emitExit", n = {"this"}, s = {"L$0"})
/* compiled from: Hoverable.kt */
final class HoverableNode$emitExit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HoverableNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HoverableNode$emitExit$1(HoverableNode hoverableNode, Continuation<? super HoverableNode$emitExit$1> continuation) {
        super(continuation);
        this.this$0 = hoverableNode;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emitExit(this);
    }
}

package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollDraggableState$drag$2", f = "Scrollable.kt", i = {}, l = {534}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Scrollable.kt */
final class ScrollDraggableState$drag$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<DragScope, Continuation<? super Unit>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ScrollDraggableState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollDraggableState$drag$2(ScrollDraggableState scrollDraggableState, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ScrollDraggableState$drag$2> continuation) {
        super(2, continuation);
        this.this$0 = scrollDraggableState;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollDraggableState$drag$2 scrollDraggableState$drag$2 = new ScrollDraggableState$drag$2(this.this$0, this.$block, continuation);
        scrollDraggableState$drag$2.L$0 = obj;
        return scrollDraggableState$drag$2;
    }

    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((ScrollDraggableState$drag$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.this$0.setLatestScrollScope((ScrollScope) this.L$0);
                Function2<DragScope, Continuation<? super Unit>, Object> function2 = this.$block;
                ScrollDraggableState scrollDraggableState = this.this$0;
                this.label = 1;
                if (function2.invoke(scrollDraggableState, this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}

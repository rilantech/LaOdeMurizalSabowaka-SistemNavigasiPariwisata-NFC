package androidx.compose.ui.input.pointer;

import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1", f = "SuspendingPointerInputFilter.kt", i = {}, l = {720, 721}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SuspendingPointerInputFilter.kt */
final class SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $timeMillis;
    int label;
    final /* synthetic */ SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine<R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1(long j, SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine<R> pointerEventHandlerCoroutine, Continuation<? super SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1> continuation) {
        super(2, continuation);
        this.$timeMillis = j;
        this.this$0 = pointerEventHandlerCoroutine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1(this.$timeMillis, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1 suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1;
        SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1 suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$12 = this;
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$12.label = 1;
                if (DelayKt.delay(suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$12.$timeMillis - 1, suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$12 = this;
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1 = this;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$12.label = 2;
        if (DelayKt.delay(1, suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$12) == coroutine_suspended) {
            return coroutine_suspended;
        }
        suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1 = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$12;
        CancellableContinuation access$getPointerAwaiter$p = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1.this$0.pointerAwaiter;
        if (access$getPointerAwaiter$p != null) {
            Result.Companion companion = Result.Companion;
            access$getPointerAwaiter$p.resumeWith(Result.m6229constructorimpl(ResultKt.createFailure(new PointerEventTimeoutCancellationException(suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1.$timeMillis))));
        }
        return Unit.INSTANCE;
    }
}

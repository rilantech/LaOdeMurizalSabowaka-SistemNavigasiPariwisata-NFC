package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SwipeableV2State$swipe$2", f = "SwipeableV2.kt", i = {}, l = {462}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SwipeableV2.kt */
final class SwipeableV2State$swipe$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $action;
    final /* synthetic */ MutatePriority $swipePriority;
    int label;
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableV2State$swipe$2(SwipeableV2State<T> swipeableV2State, MutatePriority mutatePriority, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super SwipeableV2State$swipe$2> continuation) {
        super(2, continuation);
        this.this$0 = swipeableV2State;
        this.$swipePriority = mutatePriority;
        this.$action = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SwipeableV2State$swipe$2(this.this$0, this.$swipePriority, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SwipeableV2State$swipe$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.this$0.swipeMutex.mutate(this.$swipePriority, this.$action, this) != coroutine_suspended) {
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

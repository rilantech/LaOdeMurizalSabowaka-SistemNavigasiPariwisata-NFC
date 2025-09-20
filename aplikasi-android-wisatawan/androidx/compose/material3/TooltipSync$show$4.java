package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.TooltipSync$show$4", f = "Tooltip.kt", i = {}, l = {771, 642}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Tooltip.kt */
final class TooltipSync$show$4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $persistent;
    final /* synthetic */ TooltipState $state;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TooltipSync$show$4(boolean z, TooltipState tooltipState, Continuation<? super TooltipSync$show$4> continuation) {
        super(1, continuation);
        this.$persistent = z;
        this.$state = tooltipState;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TooltipSync$show$4(this.$persistent, this.$state, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TooltipSync$show$4) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!this.$persistent) {
                    ((RichTooltipState) this.$state).setVisible$material3_release(true);
                    this.label = 2;
                    if (DelayKt.delay(TooltipKt.TooltipDuration, this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                } else {
                    TooltipState tooltipState = this.$state;
                    this.L$0 = tooltipState;
                    this.label = 1;
                    CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                    cancellable$iv.initCancellability();
                    CancellableContinuation cancellableContinuation = cancellable$iv;
                    ((RichTooltipState) tooltipState).setVisible$material3_release(true);
                    Object result = cancellable$iv.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(this);
                    }
                    if (result != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                }
            case 1:
                TooltipState tooltipState2 = (TooltipState) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}

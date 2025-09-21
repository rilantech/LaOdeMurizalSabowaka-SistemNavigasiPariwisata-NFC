package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.TooltipSync$dismissCurrentTooltip$2", f = "Tooltip.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Tooltip.kt */
final class TooltipSync$dismissCurrentTooltip$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;

    TooltipSync$dismissCurrentTooltip$2(Continuation<? super TooltipSync$dismissCurrentTooltip$2> continuation) {
        super(1, continuation);
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TooltipSync$dismissCurrentTooltip$2(continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TooltipSync$dismissCurrentTooltip$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

package androidx.compose.foundation;

import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1", f = "Clickable.kt", i = {1}, l = {293, 296}, m = "invokeSuspend", n = {"press"}, s = {"L$0"})
/* compiled from: Clickable.kt */
final class ClickableKt$handlePressInteraction$2$delayJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Boolean> $delayPressInteraction;
    final /* synthetic */ AbstractClickableNode.InteractionData $interactionData;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $pressPoint;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$handlePressInteraction$2$delayJob$1(Function0<Boolean> function0, long j, MutableInteractionSource mutableInteractionSource, AbstractClickableNode.InteractionData interactionData, Continuation<? super ClickableKt$handlePressInteraction$2$delayJob$1> continuation) {
        super(2, continuation);
        this.$delayPressInteraction = function0;
        this.$pressPoint = j;
        this.$interactionSource = mutableInteractionSource;
        this.$interactionData = interactionData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClickableKt$handlePressInteraction$2$delayJob$1(this.$delayPressInteraction, this.$pressPoint, this.$interactionSource, this.$interactionData, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClickableKt$handlePressInteraction$2$delayJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        PressInteraction.Press press;
        ClickableKt$handlePressInteraction$2$delayJob$1 clickableKt$handlePressInteraction$2$delayJob$1;
        ClickableKt$handlePressInteraction$2$delayJob$1 clickableKt$handlePressInteraction$2$delayJob$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                clickableKt$handlePressInteraction$2$delayJob$12 = this;
                if (clickableKt$handlePressInteraction$2$delayJob$12.$delayPressInteraction.invoke().booleanValue()) {
                    clickableKt$handlePressInteraction$2$delayJob$12.label = 1;
                    if (DelayKt.delay(Clickable_androidKt.getTapIndicationDelay(), clickableKt$handlePressInteraction$2$delayJob$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                clickableKt$handlePressInteraction$2$delayJob$12 = this;
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                clickableKt$handlePressInteraction$2$delayJob$1 = this;
                press = (PressInteraction.Press) clickableKt$handlePressInteraction$2$delayJob$1.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PressInteraction.Press press2 = new PressInteraction.Press(clickableKt$handlePressInteraction$2$delayJob$12.$pressPoint, (DefaultConstructorMarker) null);
        clickableKt$handlePressInteraction$2$delayJob$12.L$0 = press2;
        clickableKt$handlePressInteraction$2$delayJob$12.label = 2;
        if (clickableKt$handlePressInteraction$2$delayJob$12.$interactionSource.emit(press2, clickableKt$handlePressInteraction$2$delayJob$12) == coroutine_suspended) {
            return coroutine_suspended;
        }
        clickableKt$handlePressInteraction$2$delayJob$1 = clickableKt$handlePressInteraction$2$delayJob$12;
        press = press2;
        clickableKt$handlePressInteraction$2$delayJob$1.$interactionData.setPressInteraction(press);
        return Unit.INSTANCE;
    }
}

package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ButtonElevation$animateElevation$3", f = "Button.kt", i = {}, l = {869}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Button.kt */
final class ButtonElevation$animateElevation$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Dp, AnimationVector1D> $animatable;
    final /* synthetic */ Interaction $interaction;
    final /* synthetic */ float $target;
    int label;
    final /* synthetic */ ButtonElevation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ButtonElevation$animateElevation$3(Animatable<Dp, AnimationVector1D> animatable, ButtonElevation buttonElevation, float f, Interaction interaction, Continuation<? super ButtonElevation$animateElevation$3> continuation) {
        super(2, continuation);
        this.$animatable = animatable;
        this.this$0 = buttonElevation;
        this.$target = f;
        this.$interaction = interaction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ButtonElevation$animateElevation$3(this.$animatable, this.this$0, this.$target, this.$interaction, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ButtonElevation$animateElevation$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                float r2 = this.$animatable.getTargetValue().m7568unboximpl();
                Interaction interaction = null;
                if (Dp.m7559equalsimpl0(r2, this.this$0.pressedElevation)) {
                    interaction = new PressInteraction.Press(Offset.Companion.m4729getZeroF1C5BW0(), (DefaultConstructorMarker) null);
                } else if (Dp.m7559equalsimpl0(r2, this.this$0.hoveredElevation)) {
                    interaction = new HoverInteraction.Enter();
                } else if (Dp.m7559equalsimpl0(r2, this.this$0.focusedElevation)) {
                    interaction = new FocusInteraction.Focus();
                }
                Interaction interaction2 = interaction;
                this.label = 1;
                if (ElevationKt.m3465animateElevationrAjV9yQ(this.$animatable, this.$target, interaction2, this.$interaction, this) != coroutine_suspended) {
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

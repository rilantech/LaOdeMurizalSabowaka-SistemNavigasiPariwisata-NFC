package androidx.compose.material3;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ChipElevation$animateElevation$1$1", f = "Chip.kt", i = {}, l = {1497}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Chip.kt */
final class ChipElevation$animateElevation$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ SnapshotStateList<Interaction> $interactions;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipElevation$animateElevation$1$1(InteractionSource interactionSource, SnapshotStateList<Interaction> snapshotStateList, Continuation<? super ChipElevation$animateElevation$1$1> continuation) {
        super(2, continuation);
        this.$interactionSource = interactionSource;
        this.$interactions = snapshotStateList;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChipElevation$animateElevation$1$1(this.$interactionSource, this.$interactions, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChipElevation$animateElevation$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Flow<Interaction> interactions = this.$interactionSource.getInteractions();
                final SnapshotStateList<Interaction> snapshotStateList = this.$interactions;
                this.label = 1;
                if (interactions.collect(new FlowCollector<Interaction>() {
                    public final Object emit(Interaction interaction, Continuation<? super Unit> $completion) {
                        if (interaction instanceof HoverInteraction.Enter) {
                            snapshotStateList.add(interaction);
                        } else if (interaction instanceof HoverInteraction.Exit) {
                            snapshotStateList.remove((Object) ((HoverInteraction.Exit) interaction).getEnter());
                        } else if (interaction instanceof FocusInteraction.Focus) {
                            snapshotStateList.add(interaction);
                        } else if (interaction instanceof FocusInteraction.Unfocus) {
                            snapshotStateList.remove((Object) ((FocusInteraction.Unfocus) interaction).getFocus());
                        } else if (interaction instanceof PressInteraction.Press) {
                            snapshotStateList.add(interaction);
                        } else if (interaction instanceof PressInteraction.Release) {
                            snapshotStateList.remove((Object) ((PressInteraction.Release) interaction).getPress());
                        } else if (interaction instanceof PressInteraction.Cancel) {
                            snapshotStateList.remove((Object) ((PressInteraction.Cancel) interaction).getPress());
                        } else if (interaction instanceof DragInteraction.Start) {
                            snapshotStateList.add(interaction);
                        } else if (interaction instanceof DragInteraction.Stop) {
                            snapshotStateList.remove((Object) ((DragInteraction.Stop) interaction).getStart());
                        } else if (interaction instanceof DragInteraction.Cancel) {
                            snapshotStateList.remove((Object) ((DragInteraction.Cancel) interaction).getStart());
                        }
                        return Unit.INSTANCE;
                    }
                }, this) != coroutine_suspended) {
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

package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0014\u0010\r\u001a\u00020\b*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/FocusableInteractionNode;", "Landroidx/compose/ui/Modifier$Node;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "focusedInteraction", "Landroidx/compose/foundation/interaction/FocusInteraction$Focus;", "disposeInteractionSource", "", "setFocus", "isFocused", "", "update", "emitWithFallback", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Focusable.kt */
final class FocusableInteractionNode extends Modifier.Node {
    private FocusInteraction.Focus focusedInteraction;
    private MutableInteractionSource interactionSource;

    public FocusableInteractionNode(MutableInteractionSource interactionSource2) {
        this.interactionSource = interactionSource2;
    }

    public final void setFocus(boolean isFocused) {
        MutableInteractionSource interactionSource2 = this.interactionSource;
        if (interactionSource2 == null) {
            return;
        }
        if (isFocused) {
            FocusInteraction.Focus oldValue = this.focusedInteraction;
            if (oldValue != null) {
                emitWithFallback(interactionSource2, new FocusInteraction.Unfocus(oldValue));
                this.focusedInteraction = null;
            }
            FocusInteraction.Focus interaction = new FocusInteraction.Focus();
            emitWithFallback(interactionSource2, interaction);
            this.focusedInteraction = interaction;
            return;
        }
        FocusInteraction.Focus oldValue2 = this.focusedInteraction;
        if (oldValue2 != null) {
            emitWithFallback(interactionSource2, new FocusInteraction.Unfocus(oldValue2));
            this.focusedInteraction = null;
        }
    }

    public final void update(MutableInteractionSource interactionSource2) {
        if (!Intrinsics.areEqual((Object) this.interactionSource, (Object) interactionSource2)) {
            disposeInteractionSource();
            this.interactionSource = interactionSource2;
        }
    }

    private final void disposeInteractionSource() {
        FocusInteraction.Focus oldValue;
        MutableInteractionSource interactionSource2 = this.interactionSource;
        if (!(interactionSource2 == null || (oldValue = this.focusedInteraction) == null)) {
            interactionSource2.tryEmit(new FocusInteraction.Unfocus(oldValue));
        }
        this.focusedInteraction = null;
    }

    private final void emitWithFallback(MutableInteractionSource $this$emitWithFallback, Interaction interaction) {
        if (isAttached()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new FocusableInteractionNode$emitWithFallback$1($this$emitWithFallback, interaction, (Continuation<? super FocusableInteractionNode$emitWithFallback$1>) null), 3, (Object) null);
        } else {
            $this$emitWithFallback.tryEmit(interaction);
        }
    }
}

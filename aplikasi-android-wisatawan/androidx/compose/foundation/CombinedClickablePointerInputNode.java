package androidx.compose.foundation;

import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\rJD\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u0015\u0010\u000f\u001a\u00020\b*\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/CombinedClickablePointerInputNode;", "Landroidx/compose/foundation/AbstractClickablePointerInputNode;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onClick", "Lkotlin/Function0;", "", "interactionData", "Landroidx/compose/foundation/AbstractClickableNode$InteractionData;", "onLongClick", "onDoubleClick", "(ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/AbstractClickableNode$InteractionData;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "update", "pointerInput", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class CombinedClickablePointerInputNode extends AbstractClickablePointerInputNode {
    /* access modifiers changed from: private */
    public Function0<Unit> onDoubleClick;
    /* access modifiers changed from: private */
    public Function0<Unit> onLongClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombinedClickablePointerInputNode(boolean enabled, MutableInteractionSource interactionSource, Function0<Unit> onClick, AbstractClickableNode.InteractionData interactionData, Function0<Unit> onLongClick2, Function0<Unit> onDoubleClick2) {
        super(enabled, interactionSource, onClick, interactionData, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(interactionData, "interactionData");
        this.onLongClick = onLongClick2;
        this.onDoubleClick = onDoubleClick2;
    }

    /* access modifiers changed from: protected */
    public Object pointerInput(PointerInputScope $this$pointerInput, Continuation<? super Unit> $completion) {
        Function1 function1;
        Function1 function12;
        AbstractClickableNode.InteractionData interactionData = getInteractionData();
        long $this$toOffset_u2d_u2dgyyYBs$iv = IntSizeKt.m6010getCenterozmzZPI($this$pointerInput.m4516getSizeYbymL2g());
        interactionData.m153setCentreOffsetk4lQ0M(OffsetKt.Offset((float) IntOffset.m5962getXimpl($this$toOffset_u2d_u2dgyyYBs$iv), (float) IntOffset.m5963getYimpl($this$toOffset_u2d_u2dgyyYBs$iv)));
        if (!getEnabled() || this.onDoubleClick == null) {
            function1 = null;
        } else {
            function1 = new CombinedClickablePointerInputNode$pointerInput$2(this);
        }
        if (!getEnabled() || this.onLongClick == null) {
            function12 = null;
        } else {
            function12 = new CombinedClickablePointerInputNode$pointerInput$3(this);
        }
        Object detectTapGestures = TapGestureDetectorKt.detectTapGestures($this$pointerInput, function1, function12, new CombinedClickablePointerInputNode$pointerInput$4(this, (Continuation<? super CombinedClickablePointerInputNode$pointerInput$4>) null), new CombinedClickablePointerInputNode$pointerInput$5(this), $completion);
        return detectTapGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGestures : Unit.INSTANCE;
    }

    public final void update(boolean enabled, MutableInteractionSource interactionSource, Function0<Unit> onClick, Function0<Unit> onLongClick2, Function0<Unit> onDoubleClick2) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        setOnClick(onClick);
        setInteractionSource(interactionSource);
        boolean changed = false;
        if (getEnabled() != enabled) {
            setEnabled(enabled);
            changed = true;
        }
        boolean z = true;
        if ((this.onLongClick == null) != (onLongClick2 == null)) {
            changed = true;
        }
        this.onLongClick = onLongClick2;
        boolean z2 = this.onDoubleClick == null;
        if (onDoubleClick2 != null) {
            z = false;
        }
        if (z2 != z) {
            changed = true;
        }
        this.onDoubleClick = onDoubleClick2;
        if (changed) {
            resetPointerInputHandler();
        }
    }
}

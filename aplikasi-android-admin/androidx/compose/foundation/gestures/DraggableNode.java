package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BÓ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f\u0012<\u0010\u0010\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011¢\u0006\u0002\b\u001a\u0012<\u0010\u001b\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011¢\u0006\u0002\b\u001a\u0012\u0006\u0010\u001e\u001a\u00020\bø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\b\u0010,\u001a\u00020\u0018H\u0002J\b\u0010-\u001a\u00020\u0018H\u0016J\b\u0010.\u001a\u00020\u0018H\u0016J-\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107JÙ\u0001\u00108\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2<\u0010\u0010\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011¢\u0006\u0002\b\u001a2<\u0010\u001b\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011¢\u0006\u0002\b\u001a2\u0006\u0010\u001e\u001a\u00020\bø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0015\u00109\u001a\u00020\u0018*\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010:J\u001d\u0010;\u001a\u00020\u0018*\u00020\u00122\u0006\u0010<\u001a\u00020=H@ø\u0001\u0000¢\u0006\u0002\u0010>J\u001d\u0010?\u001a\u00020\u0018*\u00020\u00122\u0006\u0010<\u001a\u00020@H@ø\u0001\u0000¢\u0006\u0002\u0010AR\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000RL\u0010\u0010\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011¢\u0006\u0002\b\u001aX\u000eø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010'RL\u0010\u001b\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011¢\u0006\u0002\b\u001aX\u000eø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010'R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006B"}, d2 = {"Landroidx/compose/foundation/gestures/DraggableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "state", "Landroidx/compose/foundation/gestures/DraggableState;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "Lkotlin/Function0;", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "reverseDirection", "(Landroidx/compose/foundation/gestures/DraggableState;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)V", "_canDrag", "_startDragImmediately", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/DragEvent;", "dragInteraction", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "Lkotlin/jvm/functions/Function3;", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "disposeInteractionSource", "onCancelPointerInput", "onDetach", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "update", "processDragCancel", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStart", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
public final class DraggableNode extends DelegatingNode implements PointerInputModifierNode {
    /* access modifiers changed from: private */
    public final Function1<PointerInputChange, Boolean> _canDrag = new DraggableNode$_canDrag$1(this);
    /* access modifiers changed from: private */
    public final Function0<Boolean> _startDragImmediately = new DraggableNode$_startDragImmediately$1(this);
    /* access modifiers changed from: private */
    public Function1<? super PointerInputChange, Boolean> canDrag;
    /* access modifiers changed from: private */
    public final Channel<DragEvent> channel = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
    private DragInteraction.Start dragInteraction;
    /* access modifiers changed from: private */
    public boolean enabled;
    private MutableInteractionSource interactionSource;
    private Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted;
    private Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped;
    /* access modifiers changed from: private */
    public Orientation orientation;
    private final SuspendingPointerInputModifierNode pointerInputNode = ((SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new DraggableNode$pointerInputNode$1(this, (Continuation<? super DraggableNode$pointerInputNode$1>) null))));
    /* access modifiers changed from: private */
    public boolean reverseDirection;
    /* access modifiers changed from: private */
    public Function0<Boolean> startDragImmediately;
    /* access modifiers changed from: private */
    public DraggableState state;
    /* access modifiers changed from: private */
    public final VelocityTracker velocityTracker = new VelocityTracker();

    public DraggableNode(DraggableState state2, Function1<? super PointerInputChange, Boolean> canDrag2, Orientation orientation2, boolean enabled2, MutableInteractionSource interactionSource2, Function0<Boolean> startDragImmediately2, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted2, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped2, boolean reverseDirection2) {
        Intrinsics.checkNotNullParameter(state2, "state");
        Intrinsics.checkNotNullParameter(canDrag2, "canDrag");
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        Intrinsics.checkNotNullParameter(startDragImmediately2, "startDragImmediately");
        Intrinsics.checkNotNullParameter(onDragStarted2, "onDragStarted");
        Intrinsics.checkNotNullParameter(onDragStopped2, "onDragStopped");
        this.state = state2;
        this.canDrag = canDrag2;
        this.orientation = orientation2;
        this.enabled = enabled2;
        this.interactionSource = interactionSource2;
        this.startDragImmediately = startDragImmediately2;
        this.onDragStarted = onDragStarted2;
        this.onDragStopped = onDragStopped2;
        this.reverseDirection = reverseDirection2;
    }

    public void onDetach() {
        disposeInteractionSource();
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m2026onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pass, "pass");
        this.pointerInputNode.m6725onPointerEventH0pRuoY(pointerEvent, pass, bounds);
    }

    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    public final void update(DraggableState state2, Function1<? super PointerInputChange, Boolean> canDrag2, Orientation orientation2, boolean enabled2, MutableInteractionSource interactionSource2, Function0<Boolean> startDragImmediately2, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted2, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped2, boolean reverseDirection2) {
        Intrinsics.checkNotNullParameter(state2, "state");
        Intrinsics.checkNotNullParameter(canDrag2, "canDrag");
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        Intrinsics.checkNotNullParameter(startDragImmediately2, "startDragImmediately");
        Intrinsics.checkNotNullParameter(onDragStarted2, "onDragStarted");
        Intrinsics.checkNotNullParameter(onDragStopped2, "onDragStopped");
        boolean resetPointerInputHandling = false;
        if (!Intrinsics.areEqual((Object) this.state, (Object) state2)) {
            this.state = state2;
            resetPointerInputHandling = true;
        }
        this.canDrag = canDrag2;
        if (this.orientation != orientation2) {
            this.orientation = orientation2;
            resetPointerInputHandling = true;
        }
        if (this.enabled != enabled2) {
            this.enabled = enabled2;
            if (!enabled2) {
                disposeInteractionSource();
            }
            resetPointerInputHandling = true;
        }
        if (!Intrinsics.areEqual((Object) this.interactionSource, (Object) interactionSource2)) {
            disposeInteractionSource();
            this.interactionSource = interactionSource2;
        }
        this.startDragImmediately = startDragImmediately2;
        this.onDragStarted = onDragStarted2;
        this.onDragStopped = onDragStopped2;
        if (this.reverseDirection != reverseDirection2) {
            this.reverseDirection = reverseDirection2;
            resetPointerInputHandling = true;
        }
        if (resetPointerInputHandling) {
            this.pointerInputNode.resetPointerInputHandler();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007e, code lost:
        r9 = new androidx.compose.foundation.interaction.DragInteraction.Start();
        r4 = r3.interactionSource;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0086, code lost:
        if (r4 == null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0088, code lost:
        r11.L$0 = r3;
        r11.L$1 = r2;
        r11.L$2 = r10;
        r11.L$3 = r9;
        r11.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009a, code lost:
        if (r4.emit(r9, r11) != r1) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009d, code lost:
        r3.dragInteraction = r9;
        r9 = r3.onDragStarted;
        r4 = androidx.compose.ui.geometry.Offset.m4702boximpl(r10.m1982getStartPointF1C5BW0());
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.L$3 = null;
        r11.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ba, code lost:
        if (r9.invoke(r2, r4, r11) != r1) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00bc, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bf, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processDragStart(kotlinx.coroutines.CoroutineScope r9, androidx.compose.foundation.gestures.DragEvent.DragStarted r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.DraggableNode$processDragStart$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.gestures.DraggableNode$processDragStart$1 r0 = (androidx.compose.foundation.gestures.DraggableNode$processDragStart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DraggableNode$processDragStart$1 r0 = new androidx.compose.foundation.gestures.DraggableNode$processDragStart$1
            r0.<init>(r8, r11)
        L_0x0019:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            switch(r2) {
                case 0: goto L_0x0057;
                case 1: goto L_0x0046;
                case 2: goto L_0x0032;
                case 3: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00bd
        L_0x0032:
            java.lang.Object r9 = r11.L$3
            androidx.compose.foundation.interaction.DragInteraction$Start r9 = (androidx.compose.foundation.interaction.DragInteraction.Start) r9
            java.lang.Object r10 = r11.L$2
            androidx.compose.foundation.gestures.DragEvent$DragStarted r10 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r10
            java.lang.Object r2 = r11.L$1
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            java.lang.Object r3 = r11.L$0
            androidx.compose.foundation.gestures.DraggableNode r3 = (androidx.compose.foundation.gestures.DraggableNode) r3
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x009d
        L_0x0046:
            r9 = 0
            java.lang.Object r10 = r11.L$2
            androidx.compose.foundation.gestures.DragEvent$DragStarted r10 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r10
            java.lang.Object r2 = r11.L$1
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            java.lang.Object r3 = r11.L$0
            androidx.compose.foundation.gestures.DraggableNode r3 = (androidx.compose.foundation.gestures.DraggableNode) r3
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x007d
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r0)
            r3 = r8
            r2 = r9
            androidx.compose.foundation.interaction.DragInteraction$Start r9 = r3.dragInteraction
            if (r9 == 0) goto L_0x007e
            r4 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r3.interactionSource
            if (r5 == 0) goto L_0x007e
            androidx.compose.foundation.interaction.DragInteraction$Cancel r6 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r6.<init>(r9)
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r11.L$0 = r3
            r11.L$1 = r2
            r11.L$2 = r10
            r7 = 1
            r11.label = r7
            java.lang.Object r9 = r5.emit(r6, r11)
            if (r9 != r1) goto L_0x007c
            return r1
        L_0x007c:
            r9 = r4
        L_0x007d:
        L_0x007e:
            androidx.compose.foundation.interaction.DragInteraction$Start r9 = new androidx.compose.foundation.interaction.DragInteraction$Start
            r9.<init>()
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r3.interactionSource
            if (r4 == 0) goto L_0x009d
            r5 = r9
            androidx.compose.foundation.interaction.Interaction r5 = (androidx.compose.foundation.interaction.Interaction) r5
            r11.L$0 = r3
            r11.L$1 = r2
            r11.L$2 = r10
            r11.L$3 = r9
            r6 = 2
            r11.label = r6
            java.lang.Object r4 = r4.emit(r5, r11)
            if (r4 != r1) goto L_0x009d
            return r1
        L_0x009d:
            r3.dragInteraction = r9
            kotlin.jvm.functions.Function3<? super kotlinx.coroutines.CoroutineScope, ? super androidx.compose.ui.geometry.Offset, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r9 = r3.onDragStarted
            long r4 = r10.m1982getStartPointF1C5BW0()
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m4702boximpl(r4)
            r5 = 0
            r11.L$0 = r5
            r11.L$1 = r5
            r11.L$2 = r5
            r11.L$3 = r5
            r5 = 3
            r11.label = r5
            java.lang.Object r9 = r9.invoke(r2, r4, r11)
            if (r9 != r1) goto L_0x00bd
            return r1
        L_0x00bd:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode.processDragStart(kotlinx.coroutines.CoroutineScope, androidx.compose.foundation.gestures.DragEvent$DragStarted, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        r5 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        r4.dragInteraction = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        r10 = r4.onDragStopped;
        r5 = androidx.compose.ui.unit.Velocity.m7770boximpl(r11.m1983getVelocity9UxMQ8M());
        r12.L$0 = null;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0086, code lost:
        if (r10.invoke(r2, r5, r12) != r1) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008b, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processDragStop(kotlinx.coroutines.CoroutineScope r10, androidx.compose.foundation.gestures.DragEvent.DragStopped r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.DraggableNode$processDragStop$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.foundation.gestures.DraggableNode$processDragStop$1 r0 = (androidx.compose.foundation.gestures.DraggableNode$processDragStop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DraggableNode$processDragStop$1 r0 = new androidx.compose.foundation.gestures.DraggableNode$processDragStop$1
            r0.<init>(r9, r12)
        L_0x0019:
            r12 = r0
            java.lang.Object r0 = r12.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r12.label
            r3 = 0
            switch(r2) {
                case 0: goto L_0x0043;
                case 1: goto L_0x0032;
                case 2: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0089
        L_0x0032:
            r10 = 0
            java.lang.Object r11 = r12.L$2
            androidx.compose.foundation.gestures.DragEvent$DragStopped r11 = (androidx.compose.foundation.gestures.DragEvent.DragStopped) r11
            java.lang.Object r2 = r12.L$1
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            java.lang.Object r4 = r12.L$0
            androidx.compose.foundation.gestures.DraggableNode r4 = (androidx.compose.foundation.gestures.DraggableNode) r4
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0069
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r0)
            r4 = r9
            r2 = r10
            androidx.compose.foundation.interaction.DragInteraction$Start r10 = r4.dragInteraction
            if (r10 == 0) goto L_0x006f
            r5 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = r4.interactionSource
            if (r6 == 0) goto L_0x006b
            androidx.compose.foundation.interaction.DragInteraction$Stop r7 = new androidx.compose.foundation.interaction.DragInteraction$Stop
            r7.<init>(r10)
            androidx.compose.foundation.interaction.Interaction r7 = (androidx.compose.foundation.interaction.Interaction) r7
            r12.L$0 = r4
            r12.L$1 = r2
            r12.L$2 = r11
            r8 = 1
            r12.label = r8
            java.lang.Object r10 = r6.emit(r7, r12)
            if (r10 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r10 = r5
        L_0x0069:
            r5 = r10
        L_0x006b:
            r4.dragInteraction = r3
        L_0x006f:
            kotlin.jvm.functions.Function3<? super kotlinx.coroutines.CoroutineScope, ? super androidx.compose.ui.unit.Velocity, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r10 = r4.onDragStopped
            long r5 = r11.m1983getVelocity9UxMQ8M()
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m7770boximpl(r5)
            r12.L$0 = r3
            r12.L$1 = r3
            r12.L$2 = r3
            r3 = 2
            r12.label = r3
            java.lang.Object r10 = r10.invoke(r2, r5, r12)
            if (r10 != r1) goto L_0x0089
            return r1
        L_0x0089:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode.processDragStop(kotlinx.coroutines.CoroutineScope, androidx.compose.foundation.gestures.DragEvent$DragStopped, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        r5 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0065, code lost:
        r4.dragInteraction = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0069, code lost:
        r10 = r4.onDragStopped;
        r5 = androidx.compose.ui.unit.Velocity.m7770boximpl(androidx.compose.ui.unit.Velocity.Companion.m7790getZero9UxMQ8M());
        r11.L$0 = null;
        r11.L$1 = null;
        r11.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
        if (r10.invoke(r2, r5, r11) != r1) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0085, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processDragCancel(kotlinx.coroutines.CoroutineScope r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.DraggableNode$processDragCancel$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.gestures.DraggableNode$processDragCancel$1 r0 = (androidx.compose.foundation.gestures.DraggableNode$processDragCancel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DraggableNode$processDragCancel$1 r0 = new androidx.compose.foundation.gestures.DraggableNode$processDragCancel$1
            r0.<init>(r9, r11)
        L_0x0019:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            r3 = 0
            switch(r2) {
                case 0: goto L_0x003f;
                case 1: goto L_0x0032;
                case 2: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0083
        L_0x0032:
            r10 = 0
            java.lang.Object r2 = r11.L$1
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            java.lang.Object r4 = r11.L$0
            androidx.compose.foundation.gestures.DraggableNode r4 = (androidx.compose.foundation.gestures.DraggableNode) r4
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0063
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r0)
            r4 = r9
            r2 = r10
            androidx.compose.foundation.interaction.DragInteraction$Start r10 = r4.dragInteraction
            if (r10 == 0) goto L_0x0069
            r5 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = r4.interactionSource
            if (r6 == 0) goto L_0x0065
            androidx.compose.foundation.interaction.DragInteraction$Cancel r7 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r7.<init>(r10)
            androidx.compose.foundation.interaction.Interaction r7 = (androidx.compose.foundation.interaction.Interaction) r7
            r11.L$0 = r4
            r11.L$1 = r2
            r8 = 1
            r11.label = r8
            java.lang.Object r10 = r6.emit(r7, r11)
            if (r10 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r10 = r5
        L_0x0063:
            r5 = r10
        L_0x0065:
            r4.dragInteraction = r3
        L_0x0069:
            kotlin.jvm.functions.Function3<? super kotlinx.coroutines.CoroutineScope, ? super androidx.compose.ui.unit.Velocity, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r10 = r4.onDragStopped
            androidx.compose.ui.unit.Velocity$Companion r5 = androidx.compose.ui.unit.Velocity.Companion
            long r5 = r5.m7790getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m7770boximpl(r5)
            r11.L$0 = r3
            r11.L$1 = r3
            r3 = 2
            r11.label = r3
            java.lang.Object r10 = r10.invoke(r2, r5, r11)
            if (r10 != r1) goto L_0x0083
            return r1
        L_0x0083:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode.processDragCancel(kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void disposeInteractionSource() {
        DragInteraction.Start interaction = this.dragInteraction;
        if (interaction != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(new DragInteraction.Cancel(interaction));
            }
            this.dragInteraction = null;
        }
    }
}

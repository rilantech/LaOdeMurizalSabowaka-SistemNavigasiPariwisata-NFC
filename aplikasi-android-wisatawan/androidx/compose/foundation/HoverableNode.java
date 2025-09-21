package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.node.PointerInputModifierNode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J-\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/HoverableNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "hoverInteraction", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "emitEnter", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitExit", "onCancelPointerInput", "onDetach", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "tryEmitExit", "updateInteractionSource", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Hoverable.kt */
final class HoverableNode extends Modifier.Node implements PointerInputModifierNode {
    private HoverInteraction.Enter hoverInteraction;
    private MutableInteractionSource interactionSource;

    public HoverableNode(MutableInteractionSource interactionSource2) {
        Intrinsics.checkNotNullParameter(interactionSource2, "interactionSource");
        this.interactionSource = interactionSource2;
    }

    public final void updateInteractionSource(MutableInteractionSource interactionSource2) {
        Intrinsics.checkNotNullParameter(interactionSource2, "interactionSource");
        if (!Intrinsics.areEqual((Object) this.interactionSource, (Object) interactionSource2)) {
            tryEmitExit();
            this.interactionSource = interactionSource2;
        }
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m223onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pass, "pass");
        if (pass == PointerEventPass.Main) {
            int r0 = pointerEvent.m4423getType7fucELk();
            if (PointerEventType.m4430equalsimpl0(r0, PointerEventType.Companion.m4434getEnter7fucELk())) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new HoverableNode$onPointerEvent$1(this, (Continuation<? super HoverableNode$onPointerEvent$1>) null), 3, (Object) null);
            } else if (PointerEventType.m4430equalsimpl0(r0, PointerEventType.Companion.m4435getExit7fucELk())) {
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new HoverableNode$onPointerEvent$2(this, (Continuation<? super HoverableNode$onPointerEvent$2>) null), 3, (Object) null);
            }
        }
    }

    public void onCancelPointerInput() {
        tryEmitExit();
    }

    public void onDetach() {
        tryEmitExit();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emitEnter(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.HoverableNode$emitEnter$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.foundation.HoverableNode$emitEnter$1 r0 = (androidx.compose.foundation.HoverableNode$emitEnter$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.HoverableNode$emitEnter$1 r0 = new androidx.compose.foundation.HoverableNode$emitEnter$1
            r0.<init>(r7, r8)
        L_0x0019:
            r8 = r0
            java.lang.Object r0 = r8.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            switch(r2) {
                case 0: goto L_0x0039;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x002d:
            java.lang.Object r1 = r8.L$1
            androidx.compose.foundation.interaction.HoverInteraction$Enter r1 = (androidx.compose.foundation.interaction.HoverInteraction.Enter) r1
            java.lang.Object r2 = r8.L$0
            androidx.compose.foundation.HoverableNode r2 = (androidx.compose.foundation.HoverableNode) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x005a
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r7
            androidx.compose.foundation.interaction.HoverInteraction$Enter r3 = r2.hoverInteraction
            if (r3 != 0) goto L_0x005c
            androidx.compose.foundation.interaction.HoverInteraction$Enter r3 = new androidx.compose.foundation.interaction.HoverInteraction$Enter
            r3.<init>()
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r2.interactionSource
            r5 = r3
            androidx.compose.foundation.interaction.Interaction r5 = (androidx.compose.foundation.interaction.Interaction) r5
            r8.L$0 = r2
            r8.L$1 = r3
            r6 = 1
            r8.label = r6
            java.lang.Object r4 = r4.emit(r5, r8)
            if (r4 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r1 = r3
        L_0x005a:
            r2.hoverInteraction = r1
        L_0x005c:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.HoverableNode.emitEnter(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emitExit(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.HoverableNode$emitExit$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            androidx.compose.foundation.HoverableNode$emitExit$1 r0 = (androidx.compose.foundation.HoverableNode$emitExit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.HoverableNode$emitExit$1 r0 = new androidx.compose.foundation.HoverableNode$emitExit$1
            r0.<init>(r8, r9)
        L_0x0019:
            r9 = r0
            java.lang.Object r0 = r9.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r9.label
            switch(r2) {
                case 0: goto L_0x0036;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x002d:
            r1 = 0
            java.lang.Object r2 = r9.L$0
            androidx.compose.foundation.HoverableNode r2 = (androidx.compose.foundation.HoverableNode) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0057
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r8
            androidx.compose.foundation.interaction.HoverInteraction$Enter r3 = r2.hoverInteraction
            if (r3 == 0) goto L_0x005c
            r4 = 0
            androidx.compose.foundation.interaction.HoverInteraction$Exit r5 = new androidx.compose.foundation.interaction.HoverInteraction$Exit
            r5.<init>(r3)
            r3 = r5
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r2.interactionSource
            r6 = r3
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r9.L$0 = r2
            r7 = 1
            r9.label = r7
            java.lang.Object r3 = r5.emit(r6, r9)
            if (r3 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r1 = r4
        L_0x0057:
            r3 = 0
            r2.hoverInteraction = r3
        L_0x005c:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.HoverableNode.emitExit(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void tryEmitExit() {
        HoverInteraction.Enter oldValue = this.hoverInteraction;
        if (oldValue != null) {
            this.interactionSource.tryEmit(new HoverInteraction.Exit(oldValue));
            this.hoverInteraction = null;
        }
    }
}

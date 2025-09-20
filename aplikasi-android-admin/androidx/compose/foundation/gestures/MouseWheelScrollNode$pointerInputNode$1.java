package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1", f = "Scrollable.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Scrollable.kt */
final class MouseWheelScrollNode$pointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MouseWheelScrollNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MouseWheelScrollNode$pointerInputNode$1(MouseWheelScrollNode mouseWheelScrollNode, Continuation<? super MouseWheelScrollNode$pointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = mouseWheelScrollNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MouseWheelScrollNode$pointerInputNode$1 mouseWheelScrollNode$pointerInputNode$1 = new MouseWheelScrollNode$pointerInputNode$1(this.this$0, continuation);
        mouseWheelScrollNode$pointerInputNode$1.L$0 = obj;
        return mouseWheelScrollNode$pointerInputNode$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((MouseWheelScrollNode$pointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1$1", f = "Scrollable.kt", i = {0}, l = {338}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1$1  reason: invalid class name */
    /* compiled from: Scrollable.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(mouseWheelScrollNode, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:9:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                r17 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                r1 = r17
                int r2 = r1.label
                r3 = 1
                switch(r2) {
                    case 0: goto L_0x0022;
                    case 1: goto L_0x0014;
                    default: goto L_0x000c;
                }
            L_0x000c:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0014:
                r1 = r17
                r2 = r18
                java.lang.Object r4 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                kotlin.ResultKt.throwOnFailure(r2)
                r5 = r4
                r4 = r2
                goto L_0x0042
            L_0x0022:
                kotlin.ResultKt.throwOnFailure(r18)
                r1 = r17
                r2 = r18
                java.lang.Object r4 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
            L_0x002d:
                r5 = r1
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r1.L$0 = r4
                r1.label = r3
                java.lang.Object r5 = androidx.compose.foundation.gestures.ScrollableKt.awaitScrollEvent(r4, r5)
                if (r5 != r0) goto L_0x003c
                return r0
            L_0x003c:
                r16 = r4
                r4 = r2
                r2 = r5
                r5 = r16
            L_0x0042:
                androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
                java.util.List r6 = r2.getChanges()
                r7 = 0
                r8 = 0
                r9 = 0
                int r10 = r6.size()
            L_0x0052:
                r11 = 0
                if (r9 >= r10) goto L_0x006f
                java.lang.Object r12 = r6.get(r9)
                r13 = 0
                androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
                r14 = 0
                boolean r15 = r12.isConsumed()
                if (r15 != 0) goto L_0x0066
                r12 = r3
                goto L_0x0067
            L_0x0066:
                r12 = r11
            L_0x0067:
                if (r12 != 0) goto L_0x006b
                r6 = r11
                goto L_0x0071
            L_0x006b:
                int r9 = r9 + 1
                goto L_0x0052
            L_0x006f:
                r6 = r3
            L_0x0071:
                if (r6 == 0) goto L_0x00cc
                androidx.compose.foundation.gestures.MouseWheelScrollNode r6 = r4
                androidx.compose.foundation.gestures.ScrollConfig r6 = r6.getMouseWheelScrollConfig()
                androidx.compose.foundation.gestures.MouseWheelScrollNode r7 = r4
                r8 = 0
                r9 = r5
                androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
                long r12 = r5.m6104getSizeYbymL2g()
                long r9 = r6.m2067calculateMouseWheelScroll8xgXZGE(r9, r2, r12)
                androidx.compose.runtime.State r6 = r7.getScrollingLogicState()
                java.lang.Object r6 = r6.getValue()
                androidx.compose.foundation.gestures.ScrollingLogic r6 = (androidx.compose.foundation.gestures.ScrollingLogic) r6
                r7 = 0
                float r12 = r6.m2081toFloatk4lQ0M(r9)
                float r9 = r6.reverseIfNeeded(r12)
                androidx.compose.foundation.gestures.ScrollableState r10 = r6.getScrollableState()
                float r6 = r10.dispatchRawDelta(r9)
                r9 = 0
                int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
                if (r9 != 0) goto L_0x00a9
                r11 = r3
            L_0x00a9:
                if (r11 != 0) goto L_0x00c8
                java.util.List r2 = r2.getChanges()
                r6 = 0
                r9 = 0
                int r10 = r2.size()
            L_0x00b6:
                if (r9 >= r10) goto L_0x00c7
                java.lang.Object r11 = r2.get(r9)
                r12 = r11
                androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
                r13 = 0
                r12.consume()
                int r9 = r9 + 1
                goto L_0x00b6
            L_0x00c7:
            L_0x00c8:
            L_0x00cc:
                r2 = r4
                r4 = r5
                goto L_0x002d
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final MouseWheelScrollNode mouseWheelScrollNode = this.this$0;
                this.label = 1;
                if (((PointerInputScope) this.L$0).awaitPointerEventScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) != coroutine_suspended) {
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

package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2", f = "DragGestureDetector.kt", i = {0, 0, 1, 1, 1}, l = {811, 828}, m = "invokeSuspend", n = {"$this$withTimeout", "finished", "$this$withTimeout", "event", "finished"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$awaitLongPressOrCancellation$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $currentDown;
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $longPress;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$awaitLongPressOrCancellation$2(Ref.ObjectRef<PointerInputChange> objectRef, Ref.ObjectRef<PointerInputChange> objectRef2, Continuation<? super DragGestureDetectorKt$awaitLongPressOrCancellation$2> continuation) {
        super(2, continuation);
        this.$currentDown = objectRef;
        this.$longPress = objectRef2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(this.$currentDown, this.$longPress, continuation);
        dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0 = obj;
        return dragGestureDetectorKt$awaitLongPressOrCancellation$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$awaitLongPressOrCancellation$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0126 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            r22 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r22
            int r2 = r1.label
            r3 = 0
            r5 = 1
            switch(r2) {
                case 0: goto L_0x003a;
                case 1: goto L_0x0029;
                case 2: goto L_0x0015;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0015:
            r1 = r22
            r2 = r23
            int r6 = r1.I$0
            java.lang.Object r7 = r1.L$1
            androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
            java.lang.Object r8 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r2)
            r3 = r2
            goto L_0x00fe
        L_0x0029:
            r1 = r22
            r2 = r23
            int r6 = r1.I$0
            java.lang.Object r7 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r2)
            r8 = r7
            r7 = r6
            r6 = r2
            goto L_0x0068
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r23)
            r1 = r22
            r2 = r23
            java.lang.Object r6 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
            r7 = 0
            r21 = r7
            r7 = r6
            r6 = r21
        L_0x004b:
            if (r6 != 0) goto L_0x01df
            androidx.compose.ui.input.pointer.PointerEventPass r8 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r9 = r1
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r1.L$0 = r7
            r1.L$1 = r3
            r1.I$0 = r6
            r1.label = r5
            java.lang.Object r8 = r7.awaitPointerEvent(r8, r9)
            if (r8 != r0) goto L_0x0061
            return r0
        L_0x0061:
            r21 = r6
            r6 = r2
            r2 = r8
            r8 = r7
            r7 = r21
        L_0x0068:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r9 = r2.getChanges()
            r10 = 0
            r11 = 0
            r12 = 0
            int r13 = r9.size()
        L_0x0078:
            if (r12 >= r13) goto L_0x0093
            java.lang.Object r14 = r9.get(r12)
            r15 = r14
            r16 = 0
            r17 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r18 = 0
            boolean r17 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r17)
            if (r17 != 0) goto L_0x008f
            r9 = 0
            goto L_0x0095
        L_0x008f:
            int r12 = r12 + 1
            goto L_0x0078
        L_0x0093:
            r9 = r5
        L_0x0095:
            if (r9 == 0) goto L_0x0098
            r7 = 1
        L_0x0098:
            java.util.List r9 = r2.getChanges()
            r10 = 0
            r11 = 0
            r12 = 0
            int r13 = r9.size()
        L_0x00a7:
            if (r12 >= r13) goto L_0x00db
            java.lang.Object r14 = r9.get(r12)
            r15 = 0
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            r16 = 0
            boolean r17 = r14.isConsumed()
            if (r17 != 0) goto L_0x00cc
            long r3 = r8.m6104getSizeYbymL2g()
            r22 = r6
            long r5 = r8.m6103getExtendedTouchPaddingNHjbRc()
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.m6136isOutOfBoundsjwHxaWs(r14, r3, r5)
            if (r3 == 0) goto L_0x00ca
            goto L_0x00ce
        L_0x00ca:
            r3 = 0
            goto L_0x00cf
        L_0x00cc:
            r22 = r6
        L_0x00ce:
            r3 = 1
        L_0x00cf:
            if (r3 == 0) goto L_0x00d3
            r3 = 1
            goto L_0x00df
        L_0x00d3:
            int r12 = r12 + 1
            r6 = r22
            r3 = 0
            r5 = 1
            goto L_0x00a7
        L_0x00db:
            r22 = r6
            r3 = 0
        L_0x00df:
            if (r3 == 0) goto L_0x00e4
            r3 = 1
            r6 = r3
            goto L_0x00e5
        L_0x00e4:
            r6 = r7
        L_0x00e5:
            androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r1.L$0 = r8
            r1.L$1 = r2
            r1.I$0 = r6
            r5 = 2
            r1.label = r5
            java.lang.Object r3 = r8.awaitPointerEvent(r3, r4)
            if (r3 != r0) goto L_0x00fa
            return r0
        L_0x00fa:
            r7 = r2
            r2 = r3
            r3 = r22
        L_0x00fe:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r2 = r2.getChanges()
            r4 = 0
            r5 = 0
            r9 = 0
            int r10 = r2.size()
        L_0x010e:
            if (r9 >= r10) goto L_0x0126
            java.lang.Object r11 = r2.get(r9)
            r12 = r11
            r13 = 0
            r14 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            r15 = 0
            boolean r14 = r14.isConsumed()
            if (r14 == 0) goto L_0x0122
            r2 = 1
            goto L_0x0128
        L_0x0122:
            int r9 = r9 + 1
            goto L_0x010e
        L_0x0126:
            r2 = 0
        L_0x0128:
            if (r2 == 0) goto L_0x012c
            r2 = 1
            r6 = r2
        L_0x012c:
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r2 = r1.$currentDown
            T r2 = r2.element
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
            long r4 = r2.m6189getIdJ3iCeTQ()
            boolean r2 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m2002isPointerUpDmW0f2w(r7, r4)
            if (r2 == 0) goto L_0x0182
            java.util.List r2 = r7.getChanges()
            r4 = 0
            r5 = 0
            r7 = 0
            int r9 = r2.size()
        L_0x014a:
            if (r7 >= r9) goto L_0x0161
            java.lang.Object r10 = r2.get(r7)
            r11 = r10
            r12 = 0
            r13 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            r14 = 0
            boolean r13 = r13.getPressed()
            if (r13 == 0) goto L_0x015d
            goto L_0x0163
        L_0x015d:
            int r7 = r7 + 1
            goto L_0x014a
        L_0x0161:
            r11 = 0
        L_0x0163:
            r2 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
            if (r2 == 0) goto L_0x017b
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r1.$currentDown
            r4.element = r2
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r2 = r1.$longPress
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r1.$currentDown
            T r4 = r4.element
            r2.element = r4
            r22 = r0
            r23 = r1
            r19 = r3
            goto L_0x01d4
        L_0x017b:
            r6 = 1
            r2 = r3
            r7 = r8
            r3 = 0
            r5 = 1
            goto L_0x004b
        L_0x0182:
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r2 = r1.$longPress
            java.util.List r4 = r7.getChanges()
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r5 = r1.$currentDown
            r7 = 0
            r9 = 0
            r10 = 0
            int r11 = r4.size()
        L_0x0194:
            if (r10 >= r11) goto L_0x01c8
            java.lang.Object r12 = r4.get(r10)
            r13 = r12
            r14 = 0
            r15 = r13
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            r16 = 0
            r22 = r0
            r23 = r1
            long r0 = r15.m6189getIdJ3iCeTQ()
            r19 = r3
            T r3 = r5.element
            androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3
            r20 = r4
            long r3 = r3.m6189getIdJ3iCeTQ()
            boolean r0 = androidx.compose.ui.input.pointer.PointerId.m6173equalsimpl0(r0, r3)
            if (r0 == 0) goto L_0x01bc
            goto L_0x01d2
        L_0x01bc:
            int r10 = r10 + 1
            r0 = r22
            r1 = r23
            r3 = r19
            r4 = r20
            goto L_0x0194
        L_0x01c8:
            r22 = r0
            r23 = r1
            r19 = r3
            r20 = r4
            r13 = 0
        L_0x01d2:
            r2.element = r13
        L_0x01d4:
            r0 = r22
            r1 = r23
            r7 = r8
            r2 = r19
            r3 = 0
            r5 = 1
            goto L_0x004b
        L_0x01df:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package androidx.compose.foundation.text;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2", f = "LongPressTextDragObserver.kt", i = {0, 1, 1}, l = {99, 103}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down"}, s = {"L$0", "L$0", "L$1"})
/* compiled from: LongPressTextDragObserver.kt */
final class LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextDragObserver $observer;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2(TextDragObserver textDragObserver, Continuation<? super LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2> continuation) {
        super(2, continuation);
        this.$observer = textDragObserver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 = new LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2(this.$observer, continuation);
        longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2.L$0 = obj;
        return longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0059, code lost:
        r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2;
        r1.$observer.m948onDownk4lQ0M(r2.m4480getPositionF1C5BW0());
        r16 = r4;
        r4 = r2;
        r2 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0069, code lost:
        r1.L$0 = r5;
        r1.L$1 = r4;
        r1.label = 2;
        r6 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r5, (androidx.compose.ui.input.pointer.PointerEventPass) null, r1, r3, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0078, code lost:
        if (r6 != r0) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007b, code lost:
        r16 = r4;
        r4 = r2;
        r2 = r6;
        r6 = r5;
        r5 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0082, code lost:
        r2 = ((androidx.compose.ui.input.pointer.PointerEvent) r2).getChanges();
        r9 = 0;
        r10 = r2.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0092, code lost:
        if (r9 >= r10) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0094, code lost:
        r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r2.get(r9);
        r17 = r4;
        r15 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ac, code lost:
        if (androidx.compose.ui.input.pointer.PointerId.m4463equalsimpl0(r12.m4479getIdJ3iCeTQ(), r5.m4479getIdJ3iCeTQ()) == false) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b2, code lost:
        if (r15.getPressed() == false) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b4, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b6, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b7, code lost:
        if (r11 == false) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b9, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00bb, code lost:
        r9 = r9 + 1;
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c2, code lost:
        r17 = r4;
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c6, code lost:
        if (r11 != false) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c8, code lost:
        r1.$observer.onUp();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cf, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d0, code lost:
        r2 = r17;
        r4 = r5;
        r5 = r6;
        r3 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r17
            int r2 = r1.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x0035;
                case 1: goto L_0x0027;
                case 2: goto L_0x0014;
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
            java.lang.Object r4 = r1.L$1
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            java.lang.Object r5 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.throwOnFailure(r2)
            r6 = r5
            r5 = r4
            r4 = r2
            goto L_0x0082
        L_0x0027:
            r1 = r17
            r2 = r18
            java.lang.Object r4 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
            kotlin.ResultKt.throwOnFailure(r2)
            r5 = r4
            r4 = r2
            goto L_0x0059
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r18)
            r1 = r17
            r2 = r18
            java.lang.Object r4 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
            r8 = r1
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r1.L$0 = r4
            r1.label = r3
            r6 = 0
            r7 = 0
            r9 = 3
            r10 = 0
            r5 = r4
            java.lang.Object r5 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
            if (r5 != r0) goto L_0x0053
            return r0
        L_0x0053:
            r16 = r4
            r4 = r2
            r2 = r5
            r5 = r16
        L_0x0059:
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
            androidx.compose.foundation.text.TextDragObserver r6 = r1.$observer
            long r7 = r2.m4480getPositionF1C5BW0()
            r6.m948onDownk4lQ0M(r7)
            r16 = r4
            r4 = r2
            r2 = r16
        L_0x0069:
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r1.L$0 = r5
            r1.L$1 = r4
            r7 = 2
            r1.label = r7
            r7 = 0
            java.lang.Object r6 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r5, r7, r6, r3, r7)
            if (r6 != r0) goto L_0x007b
            return r0
        L_0x007b:
            r16 = r4
            r4 = r2
            r2 = r6
            r6 = r5
            r5 = r16
        L_0x0082:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r2 = r2.getChanges()
            r7 = 0
            r8 = 0
            r9 = 0
            int r10 = r2.size()
        L_0x0092:
            if (r9 >= r10) goto L_0x00c2
            java.lang.Object r12 = r2.get(r9)
            r13 = 0
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            r14 = 0
            r17 = r4
            long r3 = r12.m4479getIdJ3iCeTQ()
            r15 = r12
            long r11 = r5.m4479getIdJ3iCeTQ()
            boolean r3 = androidx.compose.ui.input.pointer.PointerId.m4463equalsimpl0(r3, r11)
            if (r3 == 0) goto L_0x00b6
            boolean r3 = r15.getPressed()
            if (r3 == 0) goto L_0x00b6
            r11 = 1
            goto L_0x00b7
        L_0x00b6:
            r11 = 0
        L_0x00b7:
            if (r11 == 0) goto L_0x00bb
            r11 = 1
            goto L_0x00c6
        L_0x00bb:
            int r9 = r9 + 1
            r4 = r17
            r3 = 1
            goto L_0x0092
        L_0x00c2:
            r17 = r4
            r11 = 0
        L_0x00c6:
            if (r11 != 0) goto L_0x00d0
            androidx.compose.foundation.text.TextDragObserver r0 = r1.$observer
            r0.onUp()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00d0:
            r2 = r17
            r4 = r5
            r5 = r6
            r3 = 1
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

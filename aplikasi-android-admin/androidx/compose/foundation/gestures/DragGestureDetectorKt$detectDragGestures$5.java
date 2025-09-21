package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5", f = "DragGestureDetector.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {176, 890, 940, 193}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointerDirectionConfig$iv", "pointer$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv", "$this$awaitEachGesture", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointerDirectionConfig$iv", "pointer$iv", "dragEvent$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "F$0", "F$1", "F$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "F$0", "F$1", "F$2"})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$detectDragGestures$5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$detectDragGestures$5(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super DragGestureDetectorKt$detectDragGestures$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onDrag = function2;
        this.$onDragCancel = function0;
        this.$onDragEnd = function02;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGestures$5 dragGestureDetectorKt$detectDragGestures$5 = new DragGestureDetectorKt$detectDragGestures$5(this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
        dragGestureDetectorKt$detectDragGestures$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGestures$5;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGestures$5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00c9, code lost:
        r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2;
        r6 = new kotlin.jvm.internal.Ref.LongRef();
        r6.element = androidx.compose.ui.geometry.Offset.Companion.m4729getZeroF1C5BW0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00d8, code lost:
        r7 = r5;
        r8 = r2.m6189getIdJ3iCeTQ();
        r10 = r2.m6193getTypeT8wyACA();
        r11 = 0;
        r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.getHorizontalPointerDirectionConfig();
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00f1, code lost:
        if (androidx.compose.foundation.gestures.DragGestureDetectorKt.m2002isPointerUpDmW0f2w(r7.getCurrentEvent(), r8) == false) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00f3, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00f6, code lost:
        r10 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m2003pointerSlopE8SPZFQ(r7.getViewConfiguration(), r10);
        r14 = new kotlin.jvm.internal.Ref.LongRef();
        r14.element = r8;
        r8 = 0.0f;
        r9 = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0107, code lost:
        r1.L$0 = r5;
        r1.L$1 = r2;
        r1.L$2 = r6;
        r1.L$3 = r7;
        r1.L$4 = r12;
        r1.L$5 = r14;
        r1.L$6 = null;
        r1.I$0 = r11;
        r1.F$0 = r10;
        r1.F$1 = r8;
        r1.F$2 = r9;
        r30 = r2;
        r1.label = 2;
        r15 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r7, (androidx.compose.ui.input.pointer.PointerEventPass) null, r1, 1, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x012c, code lost:
        if (r15 != r0) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x012e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x012f, code lost:
        r3 = r13;
        r13 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0132, code lost:
        r15 = (androidx.compose.ui.input.pointer.PointerEvent) r15;
        r30 = r15.getChanges();
        r2 = r30.size();
        r19 = r3;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x014a, code lost:
        if (r3 >= r2) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x014c, code lost:
        r18 = r2;
        r2 = r30;
        r21 = r2.get(r3);
        r30 = r6;
        r25 = r7;
        r26 = r4;
        r27 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0170, code lost:
        if (androidx.compose.ui.input.pointer.PointerId.m6173equalsimpl0(((androidx.compose.ui.input.pointer.PointerInputChange) r21).m6189getIdJ3iCeTQ(), r14.element) == false) goto L_0x0175;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0172, code lost:
        r3 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0175, code lost:
        r3 = r3 + 1;
        r6 = r30;
        r30 = r2;
        r2 = r18;
        r7 = r25;
        r4 = r26;
        r5 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0185, code lost:
        r2 = r30;
        r26 = r4;
        r27 = r5;
        r30 = r6;
        r25 = r7;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0191, code lost:
        r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0193, code lost:
        if (r3 != null) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0195, code lost:
        r6 = r30;
        r2 = r13;
        r4 = r26;
        r5 = r27;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x019f, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x01a4, code lost:
        if (r2.isConsumed() == false) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x01a6, code lost:
        r6 = r30;
        r2 = r13;
        r4 = r26;
        r5 = r27;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x01b4, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r2) == false) goto L_0x0204;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x01b6, code lost:
        r2 = r15.getChanges();
        r5 = 0;
        r6 = r2.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01c4, code lost:
        if (r5 >= r6) goto L_0x01df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01c6, code lost:
        r15 = r2.get(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01d7, code lost:
        if (((androidx.compose.ui.input.pointer.PointerInputChange) r15).getPressed() == false) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01d9, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01db, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01df, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01e1, code lost:
        r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01e4, code lost:
        if (r2 != null) goto L_0x01f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01e6, code lost:
        r6 = r30;
        r2 = r13;
        r4 = r26;
        r5 = r27;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01f0, code lost:
        r14.element = r2.m6189getIdJ3iCeTQ();
        r6 = r30;
        r2 = r13;
        r13 = r19;
        r7 = r25;
        r4 = r26;
        r5 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0204, code lost:
        r3 = r2.m6190getPositionF1C5BW0();
        r5 = r2.m6191getPreviousPositionF1C5BW0();
        r7 = (r12.m2029mainAxisDeltak4lQ0M(r3) - r12.m2029mainAxisDeltak4lQ0M(r5)) + r8;
        r6 = r9 + (r12.m2028crossAxisDeltak4lQ0M(r3) - r12.m2028crossAxisDeltak4lQ0M(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0221, code lost:
        if (r11 == 0) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0223, code lost:
        r3 = java.lang.Math.abs(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0228, code lost:
        r3 = androidx.compose.ui.geometry.Offset.m4711getDistanceimpl(r12.m2030offsetFromChangesdBAh8RU(r7, r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0236, code lost:
        if (r3 >= r10) goto L_0x027d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0238, code lost:
        r5 = r27;
        r1.L$0 = r5;
        r1.L$1 = r13;
        r8 = r30;
        r1.L$2 = r8;
        r9 = r25;
        r1.L$3 = r9;
        r1.L$4 = r12;
        r1.L$5 = r14;
        r1.L$6 = r2;
        r1.I$0 = r11;
        r1.F$0 = r10;
        r1.F$1 = r7;
        r1.F$2 = r6;
        r1.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0260, code lost:
        if (r9.awaitPointerEvent(androidx.compose.ui.input.pointer.PointerEventPass.Final, r1) != r0) goto L_0x0263;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0262, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0263, code lost:
        r3 = r10;
        r4 = r26;
        r10 = r2;
        r2 = r13;
        r13 = r19;
        r28 = r9;
        r9 = r6;
        r6 = r8;
        r8 = r7;
        r7 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0275, code lost:
        if (r10.isConsumed() == false) goto L_0x0279;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0277, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0279, code lost:
        r10 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x027d, code lost:
        r8 = r30;
        r9 = r25;
        r5 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0283, code lost:
        if (r11 == 0) goto L_0x0299;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0285, code lost:
        r30 = r1;
        r16 = r12.m2030offsetFromChangesdBAh8RU(r7 - (java.lang.Math.signum(r7) * r10), r6);
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0299, code lost:
        r6 = r12.m2030offsetFromChangesdBAh8RU(r7, r6);
        r4 = r0;
        r30 = r1;
        r16 = androidx.compose.ui.geometry.Offset.m4717minusMKHz9U(r6, androidx.compose.ui.geometry.Offset.m4720timestuRUvjQ(androidx.compose.ui.geometry.Offset.m4708divtuRUvjQ(r6, r3), r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x02af, code lost:
        r2.consume();
        r8.element = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x02c2, code lost:
        if (r2.isConsumed() == false) goto L_0x0336;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x02c4, code lost:
        r1 = r30;
        r3 = r2;
        r0 = r4;
        r6 = r8;
        r2 = r13;
        r4 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x02cd, code lost:
        if (r3 == null) goto L_0x02d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x02d3, code lost:
        if (r3.isConsumed() == false) goto L_0x02d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x02d9, code lost:
        if (r3 == null) goto L_0x0333;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x02db, code lost:
        r1.$onDragStart.invoke(androidx.compose.ui.geometry.Offset.m4702boximpl(r3.m6190getPositionF1C5BW0()));
        r1.$onDrag.invoke(r3, androidx.compose.ui.geometry.Offset.m4702boximpl(r6.element));
        r6 = r3.m6189getIdJ3iCeTQ();
        r8 = r1.$onDrag;
        r1.L$0 = null;
        r1.L$1 = null;
        r1.L$2 = null;
        r1.L$3 = null;
        r1.L$4 = null;
        r1.L$5 = null;
        r1.L$6 = null;
        r1.label = 4;
        r2 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m2000dragjO51t88(r5, r6, new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5.AnonymousClass2(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x031a, code lost:
        if (r2 != r0) goto L_0x031d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x031c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x031d, code lost:
        r0 = r1;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0325, code lost:
        if (((java.lang.Boolean) r1).booleanValue() != false) goto L_0x032d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0327, code lost:
        r0.$onDragCancel.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x032d, code lost:
        r0.$onDragEnd.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0332, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0335, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0336, code lost:
        r1 = r30;
        r6 = r8;
        r7 = r9;
        r2 = r13;
        r13 = r19;
        r9 = 0.0f;
        r8 = 0.0f;
        r0 = r4;
        r4 = r26;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r31) {
        /*
            r30 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r30
            int r2 = r1.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x00a5;
                case 1: goto L_0x0097;
                case 2: goto L_0x005a;
                case 3: goto L_0x001e;
                case 4: goto L_0x0014;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0014:
            r0 = r30
            r1 = r31
            kotlin.ResultKt.throwOnFailure(r1)
            r4 = r1
            goto L_0x031f
        L_0x001e:
            r1 = r30
            r2 = r31
            r5 = 0
            float r6 = r1.F$2
            float r7 = r1.F$1
            float r8 = r1.F$0
            int r9 = r1.I$0
            java.lang.Object r10 = r1.L$6
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            java.lang.Object r11 = r1.L$5
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r12 = r1.L$4
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r12
            java.lang.Object r13 = r1.L$3
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            java.lang.Object r14 = r1.L$2
            kotlin.jvm.internal.Ref$LongRef r14 = (kotlin.jvm.internal.Ref.LongRef) r14
            java.lang.Object r15 = r1.L$1
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            java.lang.Object r4 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
            kotlin.ResultKt.throwOnFailure(r2)
            r3 = r8
            r8 = r7
            r7 = r13
            r13 = r5
            r5 = r4
            r4 = r2
            r2 = r15
            r28 = r9
            r9 = r6
            r6 = r14
            r14 = r11
            r11 = r28
            goto L_0x0271
        L_0x005a:
            r1 = r30
            r2 = r31
            r4 = 0
            float r5 = r1.F$2
            float r6 = r1.F$1
            float r7 = r1.F$0
            int r8 = r1.I$0
            java.lang.Object r9 = r1.L$5
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r1.L$4
            androidx.compose.foundation.gestures.PointerDirectionConfig r10 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r10
            java.lang.Object r11 = r1.L$3
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r1.L$2
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            java.lang.Object r13 = r1.L$1
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            java.lang.Object r14 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r15 = r2
            r2 = r3
            r3 = r4
            r4 = r15
            r28 = r9
            r9 = r5
            r5 = r14
            r14 = r28
            r29 = r8
            r8 = r6
            r6 = r12
            r12 = r10
            r10 = r7
            r7 = r11
            r11 = r29
            goto L_0x0132
        L_0x0097:
            r1 = r30
            r2 = r31
            java.lang.Object r4 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
            kotlin.ResultKt.throwOnFailure(r2)
            r5 = r4
            r4 = r2
            goto L_0x00c9
        L_0x00a5:
            kotlin.ResultKt.throwOnFailure(r31)
            r1 = r30
            r2 = r31
            java.lang.Object r4 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
            r8 = r1
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r1.L$0 = r4
            r1.label = r3
            r6 = 0
            r7 = 0
            r9 = 2
            r10 = 0
            r5 = r4
            java.lang.Object r5 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
            if (r5 != r0) goto L_0x00c3
            return r0
        L_0x00c3:
            r28 = r4
            r4 = r2
            r2 = r5
            r5 = r28
        L_0x00c9:
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
            kotlin.jvm.internal.Ref$LongRef r6 = new kotlin.jvm.internal.Ref$LongRef
            r6.<init>()
            androidx.compose.ui.geometry.Offset$Companion r7 = androidx.compose.ui.geometry.Offset.Companion
            long r7 = r7.m4729getZeroF1C5BW0()
            r6.element = r7
        L_0x00d8:
            r7 = r5
            long r8 = r2.m6189getIdJ3iCeTQ()
            int r10 = r2.m6193getTypeT8wyACA()
            r11 = 0
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.getHorizontalPointerDirectionConfig()
            r13 = 0
            androidx.compose.ui.input.pointer.PointerEvent r14 = r7.getCurrentEvent()
            boolean r14 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m2002isPointerUpDmW0f2w(r14, r8)
            if (r14 == 0) goto L_0x00f6
            r3 = 0
            goto L_0x02cc
        L_0x00f6:
            androidx.compose.ui.platform.ViewConfiguration r14 = r7.getViewConfiguration()
            float r10 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m2003pointerSlopE8SPZFQ(r14, r10)
            kotlin.jvm.internal.Ref$LongRef r14 = new kotlin.jvm.internal.Ref$LongRef
            r14.<init>()
            r14.element = r8
            r8 = 0
            r9 = 0
        L_0x0107:
            r15 = r1
            kotlin.coroutines.Continuation r15 = (kotlin.coroutines.Continuation) r15
            r1.L$0 = r5
            r1.L$1 = r2
            r1.L$2 = r6
            r1.L$3 = r7
            r1.L$4 = r12
            r1.L$5 = r14
            r3 = 0
            r1.L$6 = r3
            r1.I$0 = r11
            r1.F$0 = r10
            r1.F$1 = r8
            r1.F$2 = r9
            r30 = r2
            r2 = 2
            r1.label = r2
            r2 = 1
            java.lang.Object r15 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r7, r3, r15, r2, r3)
            if (r15 != r0) goto L_0x012f
            return r0
        L_0x012f:
            r3 = r13
            r13 = r30
        L_0x0132:
            androidx.compose.ui.input.pointer.PointerEvent r15 = (androidx.compose.ui.input.pointer.PointerEvent) r15
            java.util.List r16 = r15.getChanges()
            r17 = 0
            r30 = r16
            r16 = 0
            r18 = 0
            int r2 = r30.size()
            r19 = r3
            r3 = r18
        L_0x014a:
            if (r3 >= r2) goto L_0x0185
            r18 = r2
            r2 = r30
            java.lang.Object r20 = r2.get(r3)
            r21 = r20
            r22 = 0
            r23 = r21
            androidx.compose.ui.input.pointer.PointerInputChange r23 = (androidx.compose.ui.input.pointer.PointerInputChange) r23
            r24 = 0
            r30 = r6
            r25 = r7
            long r6 = r23.m6189getIdJ3iCeTQ()
            r26 = r4
            r27 = r5
            long r4 = r14.element
            boolean r4 = androidx.compose.ui.input.pointer.PointerId.m6173equalsimpl0(r6, r4)
            if (r4 == 0) goto L_0x0175
            r3 = r21
            goto L_0x0191
        L_0x0175:
            int r3 = r3 + 1
            r6 = r30
            r30 = r2
            r2 = r18
            r7 = r25
            r4 = r26
            r5 = r27
            goto L_0x014a
        L_0x0185:
            r2 = r30
            r26 = r4
            r27 = r5
            r30 = r6
            r25 = r7
            r3 = 0
        L_0x0191:
            androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3
            if (r3 != 0) goto L_0x019f
            r6 = r30
            r2 = r13
            r4 = r26
            r5 = r27
            r3 = 0
            goto L_0x02cc
        L_0x019f:
            r2 = r3
            boolean r3 = r2.isConsumed()
            if (r3 == 0) goto L_0x01b0
            r6 = r30
            r2 = r13
            r4 = r26
            r5 = r27
            r3 = 0
            goto L_0x02cc
        L_0x01b0:
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r2)
            if (r3 == 0) goto L_0x0204
            java.util.List r2 = r15.getChanges()
            r3 = 0
            r4 = 0
            r5 = 0
            int r6 = r2.size()
        L_0x01c4:
            if (r5 >= r6) goto L_0x01df
            java.lang.Object r7 = r2.get(r5)
            r15 = r7
            r16 = 0
            r17 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r18 = 0
            boolean r17 = r17.getPressed()
            if (r17 == 0) goto L_0x01db
            r3 = r15
            goto L_0x01e1
        L_0x01db:
            int r5 = r5 + 1
            goto L_0x01c4
        L_0x01df:
            r3 = 0
        L_0x01e1:
            r2 = r3
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
            if (r2 != 0) goto L_0x01f0
            r6 = r30
            r2 = r13
            r4 = r26
            r5 = r27
            r3 = 0
            goto L_0x02cc
        L_0x01f0:
            long r3 = r2.m6189getIdJ3iCeTQ()
            r14.element = r3
            r6 = r30
            r2 = r13
            r13 = r19
            r7 = r25
            r4 = r26
            r5 = r27
            r3 = 1
            goto L_0x0107
        L_0x0204:
            long r3 = r2.m6190getPositionF1C5BW0()
            long r5 = r2.m6191getPreviousPositionF1C5BW0()
            float r7 = r12.m2029mainAxisDeltak4lQ0M(r3)
            float r15 = r12.m2029mainAxisDeltak4lQ0M(r5)
            float r7 = r7 - r15
            float r3 = r12.m2028crossAxisDeltak4lQ0M(r3)
            float r4 = r12.m2028crossAxisDeltak4lQ0M(r5)
            float r3 = r3 - r4
            float r7 = r7 + r8
            float r6 = r9 + r3
            if (r11 == 0) goto L_0x0228
            float r3 = java.lang.Math.abs(r7)
            goto L_0x0233
        L_0x0228:
            long r3 = r12.m2030offsetFromChangesdBAh8RU(r7, r6)
            float r3 = androidx.compose.ui.geometry.Offset.m4711getDistanceimpl(r3)
        L_0x0233:
            int r4 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r4 >= 0) goto L_0x027d
            androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5 = r27
            r1.L$0 = r5
            r1.L$1 = r13
            r8 = r30
            r1.L$2 = r8
            r9 = r25
            r1.L$3 = r9
            r1.L$4 = r12
            r1.L$5 = r14
            r1.L$6 = r2
            r1.I$0 = r11
            r1.F$0 = r10
            r1.F$1 = r7
            r1.F$2 = r6
            r15 = 3
            r1.label = r15
            java.lang.Object r3 = r9.awaitPointerEvent(r3, r4)
            if (r3 != r0) goto L_0x0263
            return r0
        L_0x0263:
            r3 = r10
            r4 = r26
            r10 = r2
            r2 = r13
            r13 = r19
            r28 = r9
            r9 = r6
            r6 = r8
            r8 = r7
            r7 = r28
        L_0x0271:
            boolean r15 = r10.isConsumed()
            if (r15 == 0) goto L_0x0279
            r3 = 0
            goto L_0x02cc
        L_0x0279:
            r10 = r3
            r3 = 1
            goto L_0x0107
        L_0x027d:
            r8 = r30
            r9 = r25
            r5 = r27
            if (r11 == 0) goto L_0x0299
            float r3 = java.lang.Math.signum(r7)
            float r3 = r3 * r10
            float r7 = r7 - r3
            long r3 = r12.m2030offsetFromChangesdBAh8RU(r7, r6)
            r30 = r1
            r16 = r3
            r4 = r0
            goto L_0x02af
        L_0x0299:
            long r6 = r12.m2030offsetFromChangesdBAh8RU(r7, r6)
            r4 = r0
            r30 = r1
            long r0 = androidx.compose.ui.geometry.Offset.m4708divtuRUvjQ(r6, r3)
            long r0 = androidx.compose.ui.geometry.Offset.m4720timestuRUvjQ(r0, r10)
            long r16 = androidx.compose.ui.geometry.Offset.m4717minusMKHz9U(r6, r0)
        L_0x02af:
            r0 = r16
            r3 = r2
            r6 = r0
            r15 = 0
            r3.consume()
            r8.element = r6
            boolean r3 = r2.isConsumed()
            if (r3 == 0) goto L_0x0336
            r1 = r30
            r3 = r2
            r0 = r4
            r6 = r8
            r2 = r13
            r4 = r26
        L_0x02cc:
            if (r3 == 0) goto L_0x02d9
            boolean r7 = r3.isConsumed()
            if (r7 == 0) goto L_0x02d6
            goto L_0x02d9
        L_0x02d6:
            r3 = 1
            goto L_0x00d8
        L_0x02d9:
            if (r3 == 0) goto L_0x0333
            kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r2 = r1.$onDragStart
            long r7 = r3.m6190getPositionF1C5BW0()
            androidx.compose.ui.geometry.Offset r7 = androidx.compose.ui.geometry.Offset.m4702boximpl(r7)
            r2.invoke(r7)
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r2 = r1.$onDrag
            long r7 = r6.element
            androidx.compose.ui.geometry.Offset r7 = androidx.compose.ui.geometry.Offset.m4702boximpl(r7)
            r2.invoke(r3, r7)
            long r6 = r3.m6189getIdJ3iCeTQ()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$2 r2 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$2
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r8 = r1.$onDrag
            r2.<init>(r8)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r8 = r1
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r15 = 0
            r1.L$0 = r15
            r1.L$1 = r15
            r1.L$2 = r15
            r1.L$3 = r15
            r1.L$4 = r15
            r1.L$5 = r15
            r1.L$6 = r15
            r9 = 4
            r1.label = r9
            java.lang.Object r2 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m2000dragjO51t88(r5, r6, r2, r8)
            if (r2 != r0) goto L_0x031d
            return r0
        L_0x031d:
            r0 = r1
            r1 = r2
        L_0x031f:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x032d
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r0.$onDragCancel
            r1.invoke()
            goto L_0x0332
        L_0x032d:
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r0.$onDragEnd
            r1.invoke()
        L_0x0332:
            r1 = r0
        L_0x0333:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0336:
            r15 = 0
            r3 = 0
            r0 = 0
            r1 = r30
            r6 = r8
            r7 = r9
            r2 = r13
            r13 = r19
            r9 = r0
            r8 = r3
            r0 = r4
            r4 = r26
            r3 = 1
            goto L_0x0107
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

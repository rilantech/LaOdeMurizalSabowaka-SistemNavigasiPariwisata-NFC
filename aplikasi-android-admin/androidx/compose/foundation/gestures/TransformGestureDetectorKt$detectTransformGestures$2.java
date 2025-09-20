package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", f = "TransformGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {59, 61}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitEachGesture", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"})
/* compiled from: TransformGestureDetector.kt */
final class TransformGestureDetectorKt$detectTransformGestures$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> $onGesture;
    final /* synthetic */ boolean $panZoomLock;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    int I$1;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransformGestureDetectorKt$detectTransformGestures$2(boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super TransformGestureDetectorKt$detectTransformGestures$2> continuation) {
        super(2, continuation);
        this.$panZoomLock = z;
        this.$onGesture = function4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformGestureDetectorKt$detectTransformGestures$2 transformGestureDetectorKt$detectTransformGestures$2 = new TransformGestureDetectorKt$detectTransformGestures$2(this.$panZoomLock, this.$onGesture, continuation);
        transformGestureDetectorKt$detectTransformGestures$2.L$0 = obj;
        return transformGestureDetectorKt$detectTransformGestures$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((TransformGestureDetectorKt$detectTransformGestures$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: androidx.compose.ui.input.pointer.AwaitPointerEventScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            r25 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r25
            int r2 = r1.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x004d;
                case 1: goto L_0x0035;
                case 2: goto L_0x0014;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0014:
            r1 = r25
            r2 = r26
            int r4 = r1.I$1
            float r5 = r1.F$2
            int r6 = r1.I$0
            long r7 = r1.J$0
            float r9 = r1.F$1
            float r10 = r1.F$0
            java.lang.Object r11 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r12 = r11
            r11 = r10
            r10 = r9
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r2
            goto L_0x00c6
        L_0x0035:
            r1 = r25
            r2 = r26
            int r4 = r1.I$1
            float r5 = r1.F$2
            int r6 = r1.I$0
            long r7 = r1.J$0
            float r9 = r1.F$1
            float r10 = r1.F$0
            java.lang.Object r11 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x009d
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r26)
            r1 = r25
            r2 = r26
            java.lang.Object r4 = r1.L$0
            r11 = r4
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            r4 = 0
            r12 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.ui.geometry.Offset$Companion r5 = androidx.compose.ui.geometry.Offset.Companion
            long r13 = r5.m4729getZeroF1C5BW0()
            r15 = 0
            androidx.compose.ui.platform.ViewConfiguration r5 = r11.getViewConfiguration()
            float r10 = r5.getTouchSlop()
            r9 = 0
            r8 = r1
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r1.L$0 = r11
            r1.F$0 = r4
            r1.F$1 = r12
            r1.J$0 = r13
            r1.I$0 = r15
            r1.F$2 = r10
            r1.I$1 = r9
            r1.label = r3
            r6 = 0
            r7 = 0
            r16 = 2
            r17 = 0
            r5 = r11
            r18 = r9
            r9 = r16
            r16 = r10
            r10 = r17
            java.lang.Object r5 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
            if (r5 != r0) goto L_0x0095
            return r0
        L_0x0095:
            r10 = r4
            r9 = r12
            r7 = r13
            r6 = r15
            r5 = r16
            r4 = r18
        L_0x009d:
        L_0x009e:
            r12 = r1
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r1.L$0 = r11
            r1.F$0 = r10
            r1.F$1 = r9
            r1.J$0 = r7
            r1.I$0 = r6
            r1.F$2 = r5
            r1.I$1 = r4
            r13 = 2
            r1.label = r13
            r13 = 0
            java.lang.Object r12 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r11, r13, r12, r3, r13)
            if (r12 != r0) goto L_0x00ba
            return r0
        L_0x00ba:
            r24 = r4
            r4 = r2
            r2 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r24
        L_0x00c6:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r13 = r2.getChanges()
            r14 = 0
            r15 = 0
            r16 = 0
            int r3 = r13.size()
            r25 = r0
            r0 = r16
        L_0x00db:
            r26 = r4
            r4 = 0
            if (r0 >= r3) goto L_0x00fc
            java.lang.Object r16 = r13.get(r0)
            r18 = r16
            r19 = 0
            r20 = r18
            androidx.compose.ui.input.pointer.PointerInputChange r20 = (androidx.compose.ui.input.pointer.PointerInputChange) r20
            r21 = 0
            boolean r20 = r20.isConsumed()
            if (r20 == 0) goto L_0x00f6
            r0 = 1
            goto L_0x00fe
        L_0x00f6:
            int r0 = r0 + 1
            r4 = r26
            goto L_0x00db
        L_0x00fc:
            r0 = r4
        L_0x00fe:
            if (r0 != 0) goto L_0x01e2
            float r3 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateZoom(r2)
            float r13 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateRotation(r2)
            long r14 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculatePan(r2)
            if (r7 != 0) goto L_0x0154
            float r10 = r10 * r3
            float r11 = r11 + r13
            long r8 = androidx.compose.ui.geometry.Offset.m4718plusMKHz9U(r8, r14)
            float r16 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroidSize(r2, r4)
            r17 = r5
            r4 = 1
            float r5 = (float) r4
            float r5 = r5 - r10
            float r5 = java.lang.Math.abs(r5)
            float r5 = r5 * r16
            r19 = 1078530011(0x40490fdb, float:3.1415927)
            float r19 = r19 * r11
            float r19 = r19 * r16
            r20 = 1127481344(0x43340000, float:180.0)
            float r19 = r19 / r20
            float r16 = java.lang.Math.abs(r19)
            float r19 = androidx.compose.ui.geometry.Offset.m4711getDistanceimpl(r8)
            int r20 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r20 > 0) goto L_0x0147
            int r5 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x0147
            int r5 = (r19 > r6 ? 1 : (r19 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0144
            goto L_0x0147
        L_0x0144:
            r5 = r17
            goto L_0x0157
        L_0x0147:
            r7 = 1
            boolean r5 = r1.$panZoomLock
            if (r5 == 0) goto L_0x0152
            int r5 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x0152
            r5 = r4
            goto L_0x0153
        L_0x0152:
            r5 = 0
        L_0x0153:
            goto L_0x0157
        L_0x0154:
            r17 = r5
            r4 = 1
        L_0x0157:
            if (r7 == 0) goto L_0x01d3
            r4 = 0
            long r17 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroid(r2, r4)
            r19 = 0
            if (r5 == 0) goto L_0x0164
            r13 = r19
        L_0x0164:
            int r19 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r19 != 0) goto L_0x016b
            r19 = 1
            goto L_0x016d
        L_0x016b:
            r19 = r4
        L_0x016d:
            if (r19 == 0) goto L_0x0193
            r19 = 1065353216(0x3f800000, float:1.0)
            int r19 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r19 != 0) goto L_0x0178
            r19 = 1
            goto L_0x017a
        L_0x0178:
            r19 = r4
        L_0x017a:
            if (r19 == 0) goto L_0x0190
            androidx.compose.ui.geometry.Offset$Companion r19 = androidx.compose.ui.geometry.Offset.Companion
            r20 = r5
            long r4 = r19.m4729getZeroF1C5BW0()
            boolean r4 = androidx.compose.ui.geometry.Offset.m4710equalsimpl0(r14, r4)
            if (r4 != 0) goto L_0x018b
            goto L_0x0195
        L_0x018b:
            r19 = r1
            r22 = r6
            goto L_0x01b0
        L_0x0190:
            r20 = r5
            goto L_0x0195
        L_0x0193:
            r20 = r5
        L_0x0195:
            kotlin.jvm.functions.Function4<androidx.compose.ui.geometry.Offset, androidx.compose.ui.geometry.Offset, java.lang.Float, java.lang.Float, kotlin.Unit> r4 = r1.$onGesture
            androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.m4702boximpl(r17)
            r19 = r1
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m4702boximpl(r14)
            r22 = r6
            java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
            r23 = r3
            java.lang.Float r3 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
            r4.invoke(r5, r1, r6, r3)
        L_0x01b0:
            java.util.List r1 = r2.getChanges()
            r3 = 0
            r4 = 0
            int r5 = r1.size()
        L_0x01bb:
            if (r4 >= r5) goto L_0x01d2
            java.lang.Object r6 = r1.get(r4)
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            r13 = 0
            boolean r14 = androidx.compose.ui.input.pointer.PointerEventKt.positionChanged(r6)
            if (r14 == 0) goto L_0x01cd
            r6.consume()
        L_0x01cd:
            int r4 = r4 + 1
            goto L_0x01bb
        L_0x01d2:
            goto L_0x01db
        L_0x01d3:
            r19 = r1
            r23 = r3
            r20 = r5
            r22 = r6
        L_0x01db:
            r6 = r7
            r7 = r8
            r9 = r10
            r10 = r11
            r4 = r20
            goto L_0x01ee
        L_0x01e2:
            r19 = r1
            r17 = r5
            r22 = r6
            r6 = r7
            r7 = r8
            r9 = r10
            r10 = r11
            r4 = r17
        L_0x01ee:
            if (r0 != 0) goto L_0x022a
            java.util.List r0 = r2.getChanges()
            r1 = 0
            r2 = 0
            r3 = 0
            int r5 = r0.size()
        L_0x01fe:
            if (r3 >= r5) goto L_0x0218
            java.lang.Object r11 = r0.get(r3)
            r13 = r11
            r14 = 0
            r15 = r13
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            r17 = 0
            boolean r15 = r15.getPressed()
            if (r15 == 0) goto L_0x0214
            r21 = 1
            goto L_0x021b
        L_0x0214:
            int r3 = r3 + 1
            goto L_0x01fe
        L_0x0218:
            r21 = 0
        L_0x021b:
            if (r21 != 0) goto L_0x021e
            goto L_0x022a
        L_0x021e:
            r0 = r25
            r2 = r26
            r11 = r12
            r1 = r19
            r5 = r22
            r3 = 1
            goto L_0x009e
        L_0x022a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

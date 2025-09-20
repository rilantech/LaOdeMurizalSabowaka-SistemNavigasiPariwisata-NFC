package androidx.compose.foundation.gestures;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aE\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a6\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005H\u0007\u001a&\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"detectZoom", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "panZoomLock", "Landroidx/compose/runtime/State;", "", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "canPan", "Lkotlin/Function0;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/runtime/State;Lkotlinx/coroutines/channels/Channel;Landroidx/compose/runtime/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "enabled", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transformable.kt */
public final class TransformableKt {
    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    public static final Modifier transformable(Modifier $this$transformable, TransformableState state, boolean lockRotationOnZoomPan, boolean enabled) {
        Intrinsics.checkNotNullParameter($this$transformable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        return transformable($this$transformable, state, TransformableKt$transformable$1.INSTANCE, lockRotationOnZoomPan, enabled);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, Function0 function0, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, function0, z, z2);
    }

    public static final Modifier transformable(Modifier $this$transformable, TransformableState state, Function0<Boolean> canPan, boolean lockRotationOnZoomPan, boolean enabled) {
        Intrinsics.checkNotNullParameter($this$transformable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(canPan, "canPan");
        return ComposedModifierKt.composed($this$transformable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TransformableKt$transformable$$inlined$debugInspectorInfo$1(state, canPan, enabled, lockRotationOnZoomPan) : InspectableValueKt.getNoInspectorInfo(), new TransformableKt$transformable$3(lockRotationOnZoomPan, canPan, enabled, state));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0232, code lost:
        if (((java.lang.Boolean) ((kotlin.jvm.functions.Function0) r14.getValue()).invoke()).booleanValue() != false) goto L_0x023e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0303 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x033a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0307 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0320  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope r28, androidx.compose.runtime.State<java.lang.Boolean> r29, kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r30, androidx.compose.runtime.State<? extends kotlin.jvm.functions.Function0<java.lang.Boolean>> r31, kotlin.coroutines.Continuation<? super kotlin.Unit> r32) {
        /*
            r0 = r32
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.TransformableKt$detectZoom$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.TransformableKt$detectZoom$1 r1 = (androidx.compose.foundation.gestures.TransformableKt$detectZoom$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.TransformableKt$detectZoom$1 r1 = new androidx.compose.foundation.gestures.TransformableKt$detectZoom$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r7 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            switch(r1) {
                case 0: goto L_0x00ac;
                case 1: goto L_0x008c;
                case 2: goto L_0x0066;
                case 3: goto L_0x002f;
                default: goto L_0x0027;
            }
        L_0x0027:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002f:
            int r1 = r0.I$2
            int r2 = r0.I$1
            float r3 = r0.F$2
            int r4 = r0.I$0
            long r5 = r0.J$0
            float r11 = r0.F$1
            float r12 = r0.F$0
            java.lang.Object r13 = r0.L$4
            androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
            java.lang.Object r14 = r0.L$3
            androidx.compose.runtime.State r14 = (androidx.compose.runtime.State) r14
            java.lang.Object r15 = r0.L$2
            kotlinx.coroutines.channels.Channel r15 = (kotlinx.coroutines.channels.Channel) r15
            java.lang.Object r9 = r0.L$1
            androidx.compose.runtime.State r9 = (androidx.compose.runtime.State) r9
            java.lang.Object r10 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            kotlin.ResultKt.throwOnFailure(r7)
            r16 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r6 = r11
            r11 = r15
            r15 = r13
            r13 = r9
            r9 = r8
            r8 = r7
            r26 = r14
            r14 = r10
            r10 = r26
            goto L_0x02ce
        L_0x0066:
            int r1 = r0.I$1
            float r2 = r0.F$2
            int r3 = r0.I$0
            long r4 = r0.J$0
            float r6 = r0.F$1
            float r9 = r0.F$0
            java.lang.Object r10 = r0.L$3
            androidx.compose.runtime.State r10 = (androidx.compose.runtime.State) r10
            java.lang.Object r11 = r0.L$2
            kotlinx.coroutines.channels.Channel r11 = (kotlinx.coroutines.channels.Channel) r11
            java.lang.Object r12 = r0.L$1
            androidx.compose.runtime.State r12 = (androidx.compose.runtime.State) r12
            java.lang.Object r13 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            kotlin.ResultKt.throwOnFailure(r7)
            r14 = r10
            r15 = r11
            r10 = r9
            r9 = r8
            r8 = r7
            goto L_0x0131
        L_0x008c:
            int r1 = r0.I$1
            float r2 = r0.F$2
            int r3 = r0.I$0
            long r4 = r0.J$0
            float r6 = r0.F$1
            float r9 = r0.F$0
            java.lang.Object r10 = r0.L$3
            androidx.compose.runtime.State r10 = (androidx.compose.runtime.State) r10
            java.lang.Object r11 = r0.L$2
            kotlinx.coroutines.channels.Channel r11 = (kotlinx.coroutines.channels.Channel) r11
            java.lang.Object r12 = r0.L$1
            androidx.compose.runtime.State r12 = (androidx.compose.runtime.State) r12
            java.lang.Object r13 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0105
        L_0x00ac:
            kotlin.ResultKt.throwOnFailure(r7)
            r13 = r28
            r11 = r30
            r12 = r29
            r10 = r31
            r9 = 0
            r14 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.Companion
            long r5 = r1.m4729getZeroF1C5BW0()
            r15 = 0
            androidx.compose.ui.platform.ViewConfiguration r1 = r13.getViewConfiguration()
            float r4 = r1.getTouchSlop()
            r3 = 0
            r0.L$0 = r13
            r0.L$1 = r12
            r0.L$2 = r11
            r0.L$3 = r10
            r0.F$0 = r9
            r0.F$1 = r14
            r0.J$0 = r5
            r0.I$0 = r15
            r0.F$2 = r4
            r0.I$1 = r3
            r1 = 1
            r0.label = r1
            r2 = 0
            r17 = 0
            r18 = 2
            r19 = 0
            r1 = r13
            r20 = r3
            r3 = r17
            r17 = r4
            r4 = r0
            r21 = r5
            r5 = r18
            r6 = r19
            java.lang.Object r1 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r1, r2, r3, r4, r5, r6)
            if (r1 != r8) goto L_0x00fd
            return r8
        L_0x00fd:
            r6 = r14
            r3 = r15
            r2 = r17
            r1 = r20
            r4 = r21
        L_0x0105:
        L_0x0106:
            r0.L$0 = r13
            r0.L$1 = r12
            r0.L$2 = r11
            r0.L$3 = r10
            r14 = 0
            r0.L$4 = r14
            r0.F$0 = r9
            r0.F$1 = r6
            r0.J$0 = r4
            r0.I$0 = r3
            r0.F$2 = r2
            r0.I$1 = r1
            r15 = 2
            r0.label = r15
            r15 = 1
            java.lang.Object r14 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r13, r14, r0, r15, r14)
            if (r14 != r8) goto L_0x0128
            return r8
        L_0x0128:
            r15 = r11
            r26 = r8
            r8 = r7
            r7 = r14
            r14 = r10
            r10 = r9
            r9 = r26
        L_0x0131:
            androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
            java.util.List r11 = r7.getChanges()
            r17 = 0
            r18 = 0
            r19 = 0
            r28 = r1
            int r1 = r11.size()
            r29 = r8
            r8 = r19
        L_0x014a:
            if (r8 >= r1) goto L_0x0166
            java.lang.Object r19 = r11.get(r8)
            r20 = r19
            r21 = 0
            r22 = r20
            androidx.compose.ui.input.pointer.PointerInputChange r22 = (androidx.compose.ui.input.pointer.PointerInputChange) r22
            r23 = 0
            boolean r22 = r22.isConsumed()
            if (r22 == 0) goto L_0x0162
            r1 = 1
            goto L_0x0168
        L_0x0162:
            int r8 = r8 + 1
            goto L_0x014a
        L_0x0166:
            r1 = 0
        L_0x0168:
            if (r1 != 0) goto L_0x027f
            float r8 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateZoom(r7)
            float r11 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateRotation(r7)
            r23 = r0
            r30 = r1
            long r0 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculatePan(r7)
            if (r3 != 0) goto L_0x01ea
            float r6 = r6 * r8
            float r10 = r10 + r11
            long r4 = androidx.compose.ui.geometry.Offset.m4718plusMKHz9U(r4, r0)
            r31 = r3
            r3 = 0
            float r17 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroidSize(r7, r3)
            r16 = r11
            r3 = 1
            float r11 = (float) r3
            float r11 = r11 - r6
            float r11 = java.lang.Math.abs(r11)
            float r11 = r11 * r17
            r18 = 1078530011(0x40490fdb, float:3.1415927)
            float r18 = r18 * r10
            float r18 = r18 * r17
            r19 = 1127481344(0x43340000, float:180.0)
            float r18 = r18 / r19
            float r17 = java.lang.Math.abs(r18)
            float r18 = androidx.compose.ui.geometry.Offset.m4711getDistanceimpl(r4)
            int r19 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r19 > 0) goto L_0x01cc
            int r11 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1))
            if (r11 > 0) goto L_0x01cc
            int r11 = (r18 > r2 ? 1 : (r18 == r2 ? 0 : -1))
            if (r11 <= 0) goto L_0x01c7
            java.lang.Object r11 = r14.getValue()
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            java.lang.Object r11 = r11.invoke()
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x01c7
            goto L_0x01cc
        L_0x01c7:
            r3 = r28
            r11 = r31
            goto L_0x01f2
        L_0x01cc:
            r11 = 1
            java.lang.Object r18 = r12.getValue()
            java.lang.Boolean r18 = (java.lang.Boolean) r18
            boolean r18 = r18.booleanValue()
            if (r18 == 0) goto L_0x01e0
            int r18 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1))
            if (r18 >= 0) goto L_0x01e0
            r17 = r3
            goto L_0x01e2
        L_0x01e0:
            r17 = 0
        L_0x01e2:
            androidx.compose.foundation.gestures.TransformEvent$TransformStarted r3 = androidx.compose.foundation.gestures.TransformEvent.TransformStarted.INSTANCE
            r15.m1676trySendJP2dKIU(r3)
            r3 = r17
            goto L_0x01f2
        L_0x01ea:
            r31 = r3
            r16 = r11
            r3 = r28
            r11 = r31
        L_0x01f2:
            if (r11 == 0) goto L_0x0274
            r17 = 0
            if (r3 == 0) goto L_0x01fa
            r16 = r17
        L_0x01fa:
            int r17 = (r16 > r17 ? 1 : (r16 == r17 ? 0 : -1))
            if (r17 != 0) goto L_0x0201
            r17 = 1
            goto L_0x0203
        L_0x0201:
            r17 = 0
        L_0x0203:
            if (r17 == 0) goto L_0x023a
            r17 = 1065353216(0x3f800000, float:1.0)
            int r17 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r17 != 0) goto L_0x020e
            r17 = 1
            goto L_0x0210
        L_0x020e:
            r17 = 0
        L_0x0210:
            if (r17 == 0) goto L_0x0235
            androidx.compose.ui.geometry.Offset$Companion r17 = androidx.compose.ui.geometry.Offset.Companion
            r28 = r3
            r24 = r4
            long r3 = r17.m4729getZeroF1C5BW0()
            boolean r3 = androidx.compose.ui.geometry.Offset.m4710equalsimpl0(r0, r3)
            if (r3 != 0) goto L_0x0250
            java.lang.Object r3 = r14.getValue()
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            java.lang.Object r3 = r3.invoke()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0250
            goto L_0x023e
        L_0x0235:
            r28 = r3
            r24 = r4
            goto L_0x023e
        L_0x023a:
            r28 = r3
            r24 = r4
        L_0x023e:
            androidx.compose.foundation.gestures.TransformEvent$TransformDelta r3 = new androidx.compose.foundation.gestures.TransformEvent$TransformDelta
            r22 = 0
            r17 = r3
            r18 = r8
            r19 = r0
            r21 = r16
            r17.<init>(r18, r19, r21, r22)
            r15.m1676trySendJP2dKIU(r3)
        L_0x0250:
            java.util.List r0 = r7.getChanges()
            r1 = 0
            r3 = 0
            int r4 = r0.size()
        L_0x025b:
            if (r3 >= r4) goto L_0x0272
            java.lang.Object r5 = r0.get(r3)
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            r8 = 0
            boolean r16 = androidx.compose.ui.input.pointer.PointerEventKt.positionChanged(r5)
            if (r16 == 0) goto L_0x026d
            r5.consume()
        L_0x026d:
            int r3 = r3 + 1
            goto L_0x025b
        L_0x0272:
            goto L_0x0278
        L_0x0274:
            r28 = r3
            r24 = r4
        L_0x0278:
            r0 = r28
            r4 = r11
            r11 = r6
            r5 = r24
            goto L_0x0290
        L_0x027f:
            r23 = r0
            r30 = r1
            r31 = r3
            androidx.compose.foundation.gestures.TransformEvent$TransformStopped r0 = androidx.compose.foundation.gestures.TransformEvent.TransformStopped.INSTANCE
            r15.m1676trySendJP2dKIU(r0)
            r0 = r28
            r11 = r6
            r5 = r4
            r4 = r31
        L_0x0290:
            androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r3 = r23
            r3.L$0 = r13
            r3.L$1 = r12
            r3.L$2 = r15
            r3.L$3 = r14
            r3.L$4 = r7
            r3.F$0 = r10
            r3.F$1 = r11
            r3.J$0 = r5
            r3.I$0 = r4
            r3.F$2 = r2
            r3.I$1 = r0
            r8 = r30
            r3.I$2 = r8
            r16 = r0
            r0 = 3
            r3.label = r0
            java.lang.Object r0 = r13.awaitPointerEvent(r1, r3)
            if (r0 != r9) goto L_0x02ba
            return r9
        L_0x02ba:
            r1 = r8
            r8 = r29
            r26 = r7
            r7 = r0
            r0 = r3
            r3 = r4
            r4 = r5
            r6 = r11
            r11 = r15
            r15 = r26
            r27 = r12
            r12 = r10
            r10 = r14
            r14 = r13
            r13 = r27
        L_0x02ce:
            androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
            java.util.List r7 = r7.getChanges()
            r17 = 0
            r18 = 0
            r19 = 0
            r28 = r0
            int r0 = r7.size()
            r29 = r2
            r2 = r19
        L_0x02e7:
            if (r2 >= r0) goto L_0x0303
            java.lang.Object r19 = r7.get(r2)
            r20 = r19
            r21 = 0
            r22 = r20
            androidx.compose.ui.input.pointer.PointerInputChange r22 = (androidx.compose.ui.input.pointer.PointerInputChange) r22
            r23 = 0
            boolean r22 = r22.isConsumed()
            if (r22 == 0) goto L_0x02ff
            r0 = 1
            goto L_0x0305
        L_0x02ff:
            int r2 = r2 + 1
            goto L_0x02e7
        L_0x0303:
            r0 = 0
        L_0x0305:
            if (r0 == 0) goto L_0x030b
            if (r3 != 0) goto L_0x030b
            r0 = 1
            goto L_0x030c
        L_0x030b:
            r0 = 0
        L_0x030c:
            if (r1 != 0) goto L_0x034c
            if (r0 != 0) goto L_0x034c
            java.util.List r0 = r15.getChanges()
            r1 = 0
            r2 = 0
            r7 = 0
            int r15 = r0.size()
        L_0x031e:
            if (r7 >= r15) goto L_0x033a
            java.lang.Object r17 = r0.get(r7)
            r18 = r17
            r19 = 0
            r20 = r18
            androidx.compose.ui.input.pointer.PointerInputChange r20 = (androidx.compose.ui.input.pointer.PointerInputChange) r20
            r21 = 0
            boolean r20 = r20.getPressed()
            if (r20 == 0) goto L_0x0336
            r1 = 1
            goto L_0x033c
        L_0x0336:
            int r7 = r7 + 1
            goto L_0x031e
        L_0x033a:
            r1 = 0
        L_0x033c:
            if (r1 != 0) goto L_0x033f
            goto L_0x034c
        L_0x033f:
            r0 = r28
            r2 = r29
            r7 = r8
            r8 = r9
            r9 = r12
            r12 = r13
            r13 = r14
            r1 = r16
            goto L_0x0106
        L_0x034c:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.runtime.State, kotlinx.coroutines.channels.Channel, androidx.compose.runtime.State, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

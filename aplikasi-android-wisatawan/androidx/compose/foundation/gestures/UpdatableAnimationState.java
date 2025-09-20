package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedSpringSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002JM\u0010\u000f\u001a\u00020\u00102!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017H@ø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState;", "", "()V", "isRunning", "", "lastFrameTime", "", "lastVelocity", "Landroidx/compose/animation/core/AnimationVector1D;", "value", "", "getValue", "()F", "setValue", "(F)V", "animateToZero", "", "beforeFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "valueDelta", "afterFrame", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UpdatableAnimationState.kt */
public final class UpdatableAnimationState {
    /* access modifiers changed from: private */
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final VectorizedSpringSpec<AnimationVector1D> RebasableAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null).vectorize((TwoWayConverter) VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
    @Deprecated
    public static final float VisibilityThreshold = 0.01f;
    /* access modifiers changed from: private */
    public static final AnimationVector1D ZeroVector = new AnimationVector1D(0.0f);
    private boolean isRunning;
    /* access modifiers changed from: private */
    public long lastFrameTime = Long.MIN_VALUE;
    /* access modifiers changed from: private */
    public AnimationVector1D lastVelocity = ZeroVector;
    private float value;

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float f) {
        this.value = f;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0090, code lost:
        if (Companion.isZeroish(r2.value) != false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0092, code lost:
        r1.L$0 = r2;
        r1.L$1 = r10;
        r1.L$2 = r4;
        r1.F$0 = r11;
        r1.label = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a7, code lost:
        if (androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(new androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$3(r2, r11, r10), r1) != r0) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a9, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00aa, code lost:
        r4.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00af, code lost:
        if (r11 != 0.0f) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b1, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b3, code lost:
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b4, code lost:
        if (r12 == false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b6, code lost:
        r14 = r1;
        r1 = r0;
        r0 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bd, code lost:
        r14 = r1;
        r1 = r0;
        r0 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cb, code lost:
        if (java.lang.Math.abs(r3.value) != 0.0f) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ce, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cf, code lost:
        if (r9 != false) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d1, code lost:
        r2.L$0 = r3;
        r2.L$1 = r0;
        r2.L$2 = null;
        r2.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e6, code lost:
        if (androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(new androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$4(r3, r10), r2) != r1) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e8, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e9, code lost:
        r1 = r2;
        r2 = r3;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r0.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ef, code lost:
        r4 = r3;
        r3 = r2;
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f2, code lost:
        r3.lastFrameTime = Long.MIN_VALUE;
        r3.lastVelocity = ZeroVector;
        r3.isRunning = false;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fd, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fe, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ff, code lost:
        r1 = r2;
        r2 = r3;
        r3 = r4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animateToZero(kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r16, kotlin.jvm.functions.Function0<kotlin.Unit> r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            r15 = this;
            r0 = r18
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1 r1 = (androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r15
            goto L_0x001f
        L_0x0018:
            androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1 r1 = new androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1
            r2 = r15
            r1.<init>(r15, r0)
            r0 = r1
        L_0x001f:
            java.lang.Object r3 = r1.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 0
            r6 = -9223372036854775808
            r8 = 0
            r9 = 1
            switch(r4) {
                case 0: goto L_0x0060;
                case 1: goto L_0x0047;
                case 2: goto L_0x0037;
                default: goto L_0x002f;
            }
        L_0x002f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0037:
            java.lang.Object r0 = r1.L$1
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            java.lang.Object r2 = r1.L$0
            androidx.compose.foundation.gestures.UpdatableAnimationState r2 = (androidx.compose.foundation.gestures.UpdatableAnimationState) r2
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x00ec
        L_0x0044:
            r0 = move-exception
            goto L_0x0102
        L_0x0047:
            float r2 = r1.F$0
            java.lang.Object r4 = r1.L$2
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            java.lang.Object r10 = r1.L$1
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r11 = r1.L$0
            androidx.compose.foundation.gestures.UpdatableAnimationState r11 = (androidx.compose.foundation.gestures.UpdatableAnimationState) r11
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x005c }
            r14 = r11
            r11 = r2
            r2 = r14
            goto L_0x00aa
        L_0x005c:
            r0 = move-exception
            r2 = r11
            goto L_0x0102
        L_0x0060:
            kotlin.ResultKt.throwOnFailure(r3)
            r2 = r15
            r4 = r17
            r10 = r16
            boolean r11 = r2.isRunning
            r11 = r11 ^ r9
            if (r11 == 0) goto L_0x010b
            kotlin.coroutines.CoroutineContext r11 = r1.getContext()
            androidx.compose.ui.MotionDurationScale$Key r12 = androidx.compose.ui.MotionDurationScale.Key
            kotlin.coroutines.CoroutineContext$Key r12 = (kotlin.coroutines.CoroutineContext.Key) r12
            kotlin.coroutines.CoroutineContext$Element r11 = r11.get(r12)
            androidx.compose.ui.MotionDurationScale r11 = (androidx.compose.ui.MotionDurationScale) r11
            if (r11 == 0) goto L_0x0083
            float r11 = r11.getScaleFactor()
            goto L_0x0085
        L_0x0083:
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x0085:
            r2.isRunning = r9
        L_0x0088:
            androidx.compose.foundation.gestures.UpdatableAnimationState$Companion r12 = Companion     // Catch:{ all -> 0x0044 }
            float r13 = r2.value     // Catch:{ all -> 0x0044 }
            boolean r12 = r12.isZeroish(r13)     // Catch:{ all -> 0x0044 }
            if (r12 != 0) goto L_0x00bd
            androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$3 r12 = new androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$3     // Catch:{ all -> 0x0044 }
            r12.<init>(r2, r11, r10)     // Catch:{ all -> 0x0044 }
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12     // Catch:{ all -> 0x0044 }
            r1.L$0 = r2     // Catch:{ all -> 0x0044 }
            r1.L$1 = r10     // Catch:{ all -> 0x0044 }
            r1.L$2 = r4     // Catch:{ all -> 0x0044 }
            r1.F$0 = r11     // Catch:{ all -> 0x0044 }
            r1.label = r9     // Catch:{ all -> 0x0044 }
            java.lang.Object r12 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r12, r1)     // Catch:{ all -> 0x0044 }
            if (r12 != r0) goto L_0x00aa
            return r0
        L_0x00aa:
            r4.invoke()     // Catch:{ all -> 0x0044 }
            int r12 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r12 != 0) goto L_0x00b3
            r12 = r9
            goto L_0x00b4
        L_0x00b3:
            r12 = r8
        L_0x00b4:
            if (r12 == 0) goto L_0x0088
            r14 = r1
            r1 = r0
            r0 = r4
            r4 = r3
            r3 = r2
            r2 = r14
            goto L_0x00c3
        L_0x00bd:
            r14 = r1
            r1 = r0
            r0 = r4
            r4 = r3
            r3 = r2
            r2 = r14
        L_0x00c3:
            float r11 = r3.value     // Catch:{ all -> 0x00fe }
            float r11 = java.lang.Math.abs(r11)     // Catch:{ all -> 0x00fe }
            int r5 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x00ce
            goto L_0x00cf
        L_0x00ce:
            r9 = r8
        L_0x00cf:
            if (r9 != 0) goto L_0x00f2
            androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$4 r5 = new androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$4     // Catch:{ all -> 0x00fe }
            r5.<init>(r3, r10)     // Catch:{ all -> 0x00fe }
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5     // Catch:{ all -> 0x00fe }
            r2.L$0 = r3     // Catch:{ all -> 0x00fe }
            r2.L$1 = r0     // Catch:{ all -> 0x00fe }
            r9 = 0
            r2.L$2 = r9     // Catch:{ all -> 0x00fe }
            r9 = 2
            r2.label = r9     // Catch:{ all -> 0x00fe }
            java.lang.Object r5 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r5, r2)     // Catch:{ all -> 0x00fe }
            if (r5 != r1) goto L_0x00e9
            return r1
        L_0x00e9:
            r1 = r2
            r2 = r3
            r3 = r4
        L_0x00ec:
            r0.invoke()     // Catch:{ all -> 0x0044 }
            r4 = r3
            r3 = r2
            r2 = r1
        L_0x00f2:
            r3.lastFrameTime = r6
            androidx.compose.animation.core.AnimationVector1D r0 = ZeroVector
            r3.lastVelocity = r0
            r3.isRunning = r8
            r0 = r3
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00fe:
            r0 = move-exception
            r1 = r2
            r2 = r3
            r3 = r4
        L_0x0102:
            r2.lastFrameTime = r6
            androidx.compose.animation.core.AnimationVector1D r4 = ZeroVector
            r2.lastVelocity = r4
            r2.isRunning = r8
            throw r0
        L_0x010b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r5 = "Check failed."
            java.lang.String r5 = r5.toString()
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.UpdatableAnimationState.animateToZero(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\r\u001a\u00020\u000e*\u00020\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState$Companion;", "", "()V", "RebasableAnimationSpec", "Landroidx/compose/animation/core/VectorizedSpringSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "getRebasableAnimationSpec", "()Landroidx/compose/animation/core/VectorizedSpringSpec;", "VisibilityThreshold", "", "ZeroVector", "getZeroVector", "()Landroidx/compose/animation/core/AnimationVector1D;", "isZeroish", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UpdatableAnimationState.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnimationVector1D getZeroVector() {
            return UpdatableAnimationState.ZeroVector;
        }

        public final VectorizedSpringSpec<AnimationVector1D> getRebasableAnimationSpec() {
            return UpdatableAnimationState.RebasableAnimationSpec;
        }

        public final boolean isZeroish(float $this$isZeroish) {
            return Math.abs($this$isZeroish) < 0.01f;
        }
    }
}

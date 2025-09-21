package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2", f = "LazyAnimateScroll.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1}, l = {137, 237}, m = "invokeSuspend", n = {"$this$scroll", "loop", "anim", "loops", "targetDistancePx", "boundDistancePx", "minDistancePx", "forward", "$this$scroll"}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "F$2", "I$0", "L$0"})
/* compiled from: LazyAnimateScroll.kt */
final class LazyAnimateScrollKt$animateScrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ int $scrollOffset;
    final /* synthetic */ LazyAnimateScrollScope $this_animateScrollToItem;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyAnimateScrollKt$animateScrollToItem$2(int i, LazyAnimateScrollScope lazyAnimateScrollScope, int i2, Continuation<? super LazyAnimateScrollKt$animateScrollToItem$2> continuation) {
        super(2, continuation);
        this.$index = i;
        this.$this_animateScrollToItem = lazyAnimateScrollScope;
        this.$scrollOffset = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LazyAnimateScrollKt$animateScrollToItem$2 lazyAnimateScrollKt$animateScrollToItem$2 = new LazyAnimateScrollKt$animateScrollToItem$2(this.$index, this.$this_animateScrollToItem, this.$scrollOffset, continuation);
        lazyAnimateScrollKt$animateScrollToItem$2.L$0 = obj;
        return lazyAnimateScrollKt$animateScrollToItem$2;
    }

    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((LazyAnimateScrollKt$animateScrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: androidx.compose.foundation.gestures.ScrollScope} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00dd, code lost:
        if (r9.element == false) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e5, code lost:
        if (r2.$this_animateScrollToItem.getItemCount() <= 0) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e7, code lost:
        r4 = r2.$this_animateScrollToItem.expectedDistanceTo(r2.$index, r2.$scrollOffset);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f7, code lost:
        if (java.lang.Math.abs(r4) >= r14) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r4 = java.lang.Math.max(java.lang.Math.abs(r4), r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0101, code lost:
        if (r0 == 0) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0103, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0105, code lost:
        r11 = -r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0108, code lost:
        if (r0 == 0) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x010a, code lost:
        r11 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010c, code lost:
        r11 = -r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r4 = r2.$index;
        r4 = r2.$scrollOffset;
        r4 = r2.$this_animateScrollToItem;
        r10.element = androidx.compose.animation.core.AnimationStateKt.copy$default(r10.element, 0.0f, 0.0f, 0, 0, false, 30, (java.lang.Object) null);
        r12 = new kotlin.jvm.internal.Ref.FloatRef();
        r21 = r10.element;
        r22 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0152, code lost:
        if (((java.lang.Number) r10.element.getVelocity()).floatValue() != r3) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0154, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0156, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0157, code lost:
        if (r4 != false) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0159, code lost:
        r24 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x015c, code lost:
        r24 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x015e, code lost:
        r3 = r2.$this_animateScrollToItem;
        r5 = r2.$index;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0164, code lost:
        if (r0 == 0) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0166, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0169, code lost:
        r16 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x016b, code lost:
        r34 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x016f, code lost:
        r35 = r8;
        r8 = r8;
        r31 = r9;
        r9 = r3;
        r3 = r10;
        r10 = r5;
        r5 = r13;
        r13 = r35;
        r32 = r1;
        r1 = r14;
        r14 = r31;
        r33 = r15;
        r15 = r16;
        r16 = r33;
        r17 = r5;
        r18 = r2.$scrollOffset;
        r19 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r8 = new androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.AnonymousClass3();
        r25 = r8;
        r26 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0196, code lost:
        r4 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r2.L$0 = r4;
        r10 = r31;
        r2.L$1 = r10;
        r2.L$2 = r3;
        r2.L$3 = r5;
        r2.F$0 = r1;
        r8 = r33;
        r2.F$1 = r8;
        r2.F$2 = r7;
        r2.I$0 = r0;
        r2.label = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01b9, code lost:
        r9 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01bb, code lost:
        if (androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r21, r22, (androidx.compose.animation.core.AnimationSpec) null, r24, r25, r26, 2, (java.lang.Object) null) != r9) goto L_0x01be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01bd, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01be, code lost:
        r6 = r34;
        r14 = r1;
        r13 = r5;
        r15 = r8;
        r1 = r9;
        r9 = r10;
        r10 = r3;
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r13.element++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01cd, code lost:
        r3 = 0.0f;
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01d1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01d2, code lost:
        r3 = r0;
        r0 = r2;
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01d7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01d8, code lost:
        r6 = r34;
        r3 = r0;
        r0 = r2;
        r2 = r4;
        r1 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01e1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01e2, code lost:
        r6 = r34;
        r3 = r0;
        r0 = r2;
        r2 = r35;
        r1 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01ed, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01ee, code lost:
        r9 = r1;
        r6 = r34;
        r3 = r0;
        r0 = r2;
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01f6, code lost:
        r4 = r8;
        r3 = r10;
        r5 = r13;
        r1 = r14;
        r8 = r15;
        r10 = r9;
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0202, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0203, code lost:
        r9 = r1;
        r34 = r6;
        r3 = r0;
        r0 = r2;
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0253, code lost:
        r20 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0256, code lost:
        r20 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0280, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0281, code lost:
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0282, code lost:
        r0.$this_animateScrollToItem.snapToItem(r2, r0.$index, r0.$scrollOffset);
        r2 = r0;
        r6 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x028f, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0280 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0281  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r35) {
        /*
            r34 = this;
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r0 = r34
            int r2 = r0.label
            r3 = 0
            r5 = 1
            switch(r2) {
                case 0: goto L_0x004f;
                case 1: goto L_0x0022;
                case 2: goto L_0x0015;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0015:
            r0 = r34
            r1 = r35
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.gestures.ScrollScope r2 = (androidx.compose.foundation.gestures.ScrollScope) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0282
        L_0x0022:
            r2 = r34
            r6 = r35
            int r0 = r2.I$0
            float r7 = r2.F$2
            float r8 = r2.F$1
            float r9 = r2.F$0
            java.lang.Object r10 = r2.L$3
            kotlin.jvm.internal.Ref$IntRef r10 = (kotlin.jvm.internal.Ref.IntRef) r10
            java.lang.Object r11 = r2.L$2
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r12 = r2.L$1
            kotlin.jvm.internal.Ref$BooleanRef r12 = (kotlin.jvm.internal.Ref.BooleanRef) r12
            java.lang.Object r13 = r2.L$0
            androidx.compose.foundation.gestures.ScrollScope r13 = (androidx.compose.foundation.gestures.ScrollScope) r13
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ ItemFoundInScroll -> 0x0049 }
            r15 = r8
            r14 = r9
            r9 = r12
            r8 = r13
            r13 = r10
            r10 = r11
            goto L_0x01c7
        L_0x0049:
            r0 = move-exception
            r3 = r0
            r0 = r2
            r2 = r13
            goto L_0x021d
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r35)
            r2 = r34
            r6 = r35
            java.lang.Object r0 = r2.L$0
            r7 = r0
            androidx.compose.foundation.gestures.ScrollScope r7 = (androidx.compose.foundation.gestures.ScrollScope) r7
            int r0 = r2.$index
            float r8 = (float) r0
            int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r8 < 0) goto L_0x0064
            r8 = r5
            goto L_0x0065
        L_0x0064:
            r8 = 0
        L_0x0065:
            if (r8 == 0) goto L_0x0290
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r0 = r2.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0219 }
            androidx.compose.ui.unit.Density r0 = r0.getDensity()     // Catch:{ ItemFoundInScroll -> 0x0219 }
            r8 = 0
            float r9 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.TargetDistance     // Catch:{ ItemFoundInScroll -> 0x0219 }
            float r9 = r0.m5825toPx0680j_4(r9)     // Catch:{ ItemFoundInScroll -> 0x0219 }
            r0 = r9
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r8 = r2.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0219 }
            androidx.compose.ui.unit.Density r8 = r8.getDensity()     // Catch:{ ItemFoundInScroll -> 0x0219 }
            r9 = 0
            float r10 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.BoundDistance     // Catch:{ ItemFoundInScroll -> 0x0219 }
            float r10 = r8.m5825toPx0680j_4(r10)     // Catch:{ ItemFoundInScroll -> 0x0219 }
            r8 = r10
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r9 = r2.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0219 }
            androidx.compose.ui.unit.Density r9 = r9.getDensity()     // Catch:{ ItemFoundInScroll -> 0x0219 }
            r10 = 0
            float r11 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.MinimumDistance     // Catch:{ ItemFoundInScroll -> 0x0219 }
            float r11 = r9.m5825toPx0680j_4(r11)     // Catch:{ ItemFoundInScroll -> 0x0219 }
            r9 = r11
            kotlin.jvm.internal.Ref$BooleanRef r10 = new kotlin.jvm.internal.Ref$BooleanRef     // Catch:{ ItemFoundInScroll -> 0x0219 }
            r10.<init>()     // Catch:{ ItemFoundInScroll -> 0x0219 }
            r10.element = r5     // Catch:{ ItemFoundInScroll -> 0x0219 }
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ ItemFoundInScroll -> 0x0219 }
            r11.<init>()     // Catch:{ ItemFoundInScroll -> 0x0219 }
            r19 = 30
            r20 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            androidx.compose.animation.core.AnimationState r12 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r12, r13, r14, r16, r18, r19, r20)     // Catch:{ ItemFoundInScroll -> 0x0219 }
            r11.element = r12     // Catch:{ ItemFoundInScroll -> 0x0219 }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r12 = r2.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0219 }
            int r13 = r2.$index     // Catch:{ ItemFoundInScroll -> 0x0219 }
            java.lang.Integer r12 = r12.getTargetItemOffset(r13)     // Catch:{ ItemFoundInScroll -> 0x0219 }
            if (r12 != 0) goto L_0x020b
            int r12 = r2.$index     // Catch:{ ItemFoundInScroll -> 0x0219 }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r13 = r2.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0219 }
            int r13 = r13.getFirstVisibleItemIndex()     // Catch:{ ItemFoundInScroll -> 0x0219 }
            if (r12 <= r13) goto L_0x00cc
            r12 = r5
            goto L_0x00cd
        L_0x00cc:
            r12 = 0
        L_0x00cd:
            kotlin.jvm.internal.Ref$IntRef r13 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ ItemFoundInScroll -> 0x0219 }
            r13.<init>()     // Catch:{ ItemFoundInScroll -> 0x0219 }
            r13.element = r5     // Catch:{ ItemFoundInScroll -> 0x0219 }
            r14 = r0
            r15 = r8
            r0 = r12
            r8 = r7
            r7 = r9
            r9 = r10
            r10 = r11
        L_0x00db:
            boolean r11 = r9.element     // Catch:{ ItemFoundInScroll -> 0x0202 }
            if (r11 == 0) goto L_0x01f6
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r11 = r2.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0202 }
            int r11 = r11.getItemCount()     // Catch:{ ItemFoundInScroll -> 0x0202 }
            if (r11 <= 0) goto L_0x01f6
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r11 = r2.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0202 }
            int r12 = r2.$index     // Catch:{ ItemFoundInScroll -> 0x0202 }
            int r4 = r2.$scrollOffset     // Catch:{ ItemFoundInScroll -> 0x0202 }
            float r4 = r11.expectedDistanceTo(r12, r4)     // Catch:{ ItemFoundInScroll -> 0x0202 }
            float r11 = java.lang.Math.abs(r4)     // Catch:{ ItemFoundInScroll -> 0x0202 }
            int r11 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r11 >= 0) goto L_0x0108
            float r11 = java.lang.Math.abs(r4)     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            float r4 = java.lang.Math.max(r11, r7)     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            if (r0 == 0) goto L_0x0105
            r11 = r4
            goto L_0x010e
        L_0x0105:
            float r4 = -r4
            r11 = r4
            goto L_0x010e
        L_0x0108:
            if (r0 == 0) goto L_0x010c
            r11 = r14
            goto L_0x010e
        L_0x010c:
            float r4 = -r14
            r11 = r4
        L_0x010e:
            int r4 = r2.$index     // Catch:{ ItemFoundInScroll -> 0x0202 }
            int r4 = r2.$scrollOffset     // Catch:{ ItemFoundInScroll -> 0x0202 }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r4 = r2.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0202 }
            r4 = 0
            T r4 = r10.element     // Catch:{ ItemFoundInScroll -> 0x0202 }
            r21 = r4
            androidx.compose.animation.core.AnimationState r21 = (androidx.compose.animation.core.AnimationState) r21     // Catch:{ ItemFoundInScroll -> 0x0202 }
            r29 = 30
            r30 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r26 = 0
            r28 = 0
            androidx.compose.animation.core.AnimationState r4 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r21, (float) r22, (float) r23, (long) r24, (long) r26, (boolean) r28, (int) r29, (java.lang.Object) r30)     // Catch:{ ItemFoundInScroll -> 0x0202 }
            r10.element = r4     // Catch:{ ItemFoundInScroll -> 0x0202 }
            kotlin.jvm.internal.Ref$FloatRef r12 = new kotlin.jvm.internal.Ref$FloatRef     // Catch:{ ItemFoundInScroll -> 0x0202 }
            r12.<init>()     // Catch:{ ItemFoundInScroll -> 0x0202 }
            T r4 = r10.element     // Catch:{ ItemFoundInScroll -> 0x0202 }
            r21 = r4
            androidx.compose.animation.core.AnimationState r21 = (androidx.compose.animation.core.AnimationState) r21     // Catch:{ ItemFoundInScroll -> 0x0202 }
            java.lang.Float r22 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r11)     // Catch:{ ItemFoundInScroll -> 0x0202 }
            T r4 = r10.element     // Catch:{ ItemFoundInScroll -> 0x0202 }
            androidx.compose.animation.core.AnimationState r4 = (androidx.compose.animation.core.AnimationState) r4     // Catch:{ ItemFoundInScroll -> 0x0202 }
            java.lang.Object r4 = r4.getVelocity()     // Catch:{ ItemFoundInScroll -> 0x0202 }
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ ItemFoundInScroll -> 0x0202 }
            float r4 = r4.floatValue()     // Catch:{ ItemFoundInScroll -> 0x0202 }
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 != 0) goto L_0x0156
            r4 = r5
            goto L_0x0157
        L_0x0156:
            r4 = 0
        L_0x0157:
            if (r4 != 0) goto L_0x015c
            r24 = r5
            goto L_0x015e
        L_0x015c:
            r24 = 0
        L_0x015e:
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$3 r4 = new androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$3     // Catch:{ ItemFoundInScroll -> 0x0202 }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r3 = r2.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0202 }
            int r5 = r2.$index     // Catch:{ ItemFoundInScroll -> 0x0202 }
            if (r0 == 0) goto L_0x0169
            r16 = 1
            goto L_0x016b
        L_0x0169:
            r16 = 0
        L_0x016b:
            r34 = r6
            int r6 = r2.$scrollOffset     // Catch:{ ItemFoundInScroll -> 0x01ed }
            r35 = r8
            r8 = r4
            r31 = r9
            r9 = r3
            r3 = r10
            r10 = r5
            r5 = r13
            r13 = r35
            r32 = r1
            r1 = r14
            r14 = r31
            r33 = r15
            r15 = r16
            r16 = r33
            r17 = r5
            r18 = r6
            r19 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            r25 = r4
            kotlin.jvm.functions.Function1 r25 = (kotlin.jvm.functions.Function1) r25     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            r26 = r2
            kotlin.coroutines.Continuation r26 = (kotlin.coroutines.Continuation) r26     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            r4 = r35
            r2.L$0 = r4     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            r10 = r31
            r2.L$1 = r10     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            r2.L$2 = r3     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            r2.L$3 = r5     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            r2.F$0 = r1     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            r8 = r33
            r2.F$1 = r8     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            r2.F$2 = r7     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            r2.I$0 = r0     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            r6 = 1
            r2.label = r6     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            r23 = 0
            r27 = 2
            r28 = 0
            java.lang.Object r6 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r21, r22, r23, r24, r25, r26, r27, r28)     // Catch:{ ItemFoundInScroll -> 0x01d7 }
            r9 = r32
            if (r6 != r9) goto L_0x01be
            return r9
        L_0x01be:
            r6 = r34
            r14 = r1
            r13 = r5
            r15 = r8
            r1 = r9
            r9 = r10
            r10 = r3
            r8 = r4
        L_0x01c7:
            int r3 = r13.element     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            r4 = 1
            int r3 = r3 + r4
            r13.element = r3     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            r3 = 0
            r5 = 1
            goto L_0x00db
        L_0x01d1:
            r0 = move-exception
            r3 = r0
            r0 = r2
            r2 = r8
            goto L_0x021d
        L_0x01d7:
            r0 = move-exception
            r9 = r32
            r6 = r34
            r3 = r0
            r0 = r2
            r2 = r4
            r1 = r9
            goto L_0x021d
        L_0x01e1:
            r0 = move-exception
            r4 = r35
            r9 = r32
            r6 = r34
            r3 = r0
            r0 = r2
            r2 = r4
            r1 = r9
            goto L_0x021d
        L_0x01ed:
            r0 = move-exception
            r9 = r1
            r4 = r8
            r6 = r34
            r3 = r0
            r0 = r2
            r2 = r4
            goto L_0x021d
        L_0x01f6:
            r34 = r6
            r4 = r8
            r3 = r10
            r5 = r13
            r1 = r14
            r8 = r15
            r10 = r9
            r6 = r34
            goto L_0x028d
        L_0x0202:
            r0 = move-exception
            r9 = r1
            r34 = r6
            r4 = r8
            r3 = r0
            r0 = r2
            r2 = r4
            goto L_0x021d
        L_0x020b:
            androidx.compose.foundation.lazy.layout.ItemFoundInScroll r0 = new androidx.compose.foundation.lazy.layout.ItemFoundInScroll     // Catch:{ ItemFoundInScroll -> 0x0219 }
            int r3 = r12.intValue()     // Catch:{ ItemFoundInScroll -> 0x0219 }
            T r4 = r11.element     // Catch:{ ItemFoundInScroll -> 0x0219 }
            androidx.compose.animation.core.AnimationState r4 = (androidx.compose.animation.core.AnimationState) r4     // Catch:{ ItemFoundInScroll -> 0x0219 }
            r0.<init>(r3, r4)     // Catch:{ ItemFoundInScroll -> 0x0219 }
            throw r0     // Catch:{ ItemFoundInScroll -> 0x0219 }
        L_0x0219:
            r0 = move-exception
            r3 = r0
            r0 = r2
            r2 = r7
        L_0x021d:
            androidx.compose.animation.core.AnimationState r7 = r3.getPreviousAnimation()
            r15 = 30
            r16 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            androidx.compose.animation.core.AnimationState r21 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r7, (float) r8, (float) r9, (long) r10, (long) r12, (boolean) r14, (int) r15, (java.lang.Object) r16)
            int r4 = r3.getItemOffset()
            int r5 = r0.$scrollOffset
            int r4 = r4 + r5
            float r3 = (float) r4
            kotlin.jvm.internal.Ref$FloatRef r4 = new kotlin.jvm.internal.Ref$FloatRef
            r4.<init>()
            r5 = 0
            java.lang.Float r22 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
            java.lang.Object r5 = r21.getVelocity()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x0256
            r20 = 1
            goto L_0x0258
        L_0x0256:
            r20 = 0
        L_0x0258:
            r5 = 1
            r24 = r20 ^ 1
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$5 r5 = new androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$5
            r5.<init>(r3, r4, r2)
            r25 = r5
            kotlin.jvm.functions.Function1 r25 = (kotlin.jvm.functions.Function1) r25
            r26 = r0
            kotlin.coroutines.Continuation r26 = (kotlin.coroutines.Continuation) r26
            r0.L$0 = r2
            r5 = 0
            r0.L$1 = r5
            r0.L$2 = r5
            r0.L$3 = r5
            r5 = 2
            r0.label = r5
            r23 = 0
            r27 = 2
            r28 = 0
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r21, r22, r23, r24, r25, r26, r27, r28)
            if (r3 != r1) goto L_0x0281
            return r1
        L_0x0281:
            r1 = r6
        L_0x0282:
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r3 = r0.$this_animateScrollToItem
            int r4 = r0.$index
            int r5 = r0.$scrollOffset
            r3.snapToItem(r2, r4, r5)
            r2 = r0
            r6 = r1
        L_0x028d:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0290:
            r1 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Index should be non-negative ("
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r0 = r3.append(r0)
            r3 = 41
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final boolean invokeSuspend$isOvershot(boolean forward, LazyAnimateScrollScope $this_animateScrollToItem2, int $index2, int $scrollOffset2) {
        if (forward) {
            if ($this_animateScrollToItem2.getFirstVisibleItemIndex() > $index2) {
                return true;
            }
            if ($this_animateScrollToItem2.getFirstVisibleItemIndex() != $index2 || $this_animateScrollToItem2.getFirstVisibleItemScrollOffset() <= $scrollOffset2) {
                return false;
            }
            return true;
        } else if ($this_animateScrollToItem2.getFirstVisibleItemIndex() < $index2) {
            return true;
        } else {
            if ($this_animateScrollToItem2.getFirstVisibleItemIndex() != $index2 || $this_animateScrollToItem2.getFirstVisibleItemScrollOffset() >= $scrollOffset2) {
                return false;
            }
            return true;
        }
    }
}

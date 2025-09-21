package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2", f = "Scrollable.kt", i = {0}, l = {603}, m = "invokeSuspend", n = {"velocityLeft"}, s = {"L$0"})
/* compiled from: Scrollable.kt */
final class DefaultFlingBehavior$performFling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Float>, Object> {
    final /* synthetic */ float $initialVelocity;
    final /* synthetic */ ScrollScope $this_performFling;
    Object L$0;
    int label;
    final /* synthetic */ DefaultFlingBehavior this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultFlingBehavior$performFling$2(float f, DefaultFlingBehavior defaultFlingBehavior, ScrollScope scrollScope, Continuation<? super DefaultFlingBehavior$performFling$2> continuation) {
        super(2, continuation);
        this.$initialVelocity = f;
        this.this$0 = defaultFlingBehavior;
        this.$this_performFling = scrollScope;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultFlingBehavior$performFling$2(this.$initialVelocity, this.this$0, this.$this_performFling, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Float> continuation) {
        return ((DefaultFlingBehavior$performFling$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            r22 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r22
            int r2 = r1.label
            switch(r2) {
                case 0: goto L_0x001f;
                case 1: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0013:
            r0 = r22
            r1 = r23
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.internal.Ref$FloatRef r2 = (kotlin.jvm.internal.Ref.FloatRef) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x007c
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r23)
            r1 = r22
            r2 = r23
            float r3 = r1.$initialVelocity
            float r3 = java.lang.Math.abs(r3)
            r4 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            kotlin.jvm.internal.Ref$FloatRef r3 = new kotlin.jvm.internal.Ref$FloatRef
            r3.<init>()
            float r4 = r1.$initialVelocity
            r3.element = r4
            kotlin.jvm.internal.Ref$FloatRef r4 = new kotlin.jvm.internal.Ref$FloatRef
            r4.<init>()
            float r6 = r1.$initialVelocity
            r12 = 28
            r13 = 0
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            androidx.compose.animation.core.AnimationState r14 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r5, r6, r7, r9, r11, r12, r13)
            androidx.compose.foundation.gestures.DefaultFlingBehavior r5 = r1.this$0
            androidx.compose.animation.core.DecayAnimationSpec r15 = r5.flingDecay
            androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2$1 r5 = new androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2$1
            androidx.compose.foundation.gestures.ScrollScope r6 = r1.$this_performFling
            androidx.compose.foundation.gestures.DefaultFlingBehavior r7 = r1.this$0
            r5.<init>(r4, r6, r3, r7)
            r17 = r5
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            r18 = r1
            kotlin.coroutines.Continuation r18 = (kotlin.coroutines.Continuation) r18
            r1.L$0 = r3
            r5 = 1
            r1.label = r5
            r16 = 0
            r19 = 2
            r20 = 0
            java.lang.Object r4 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r14, r15, r16, r17, r18, r19, r20)
            if (r4 != r0) goto L_0x0079
            return r0
        L_0x0079:
            r0 = r1
            r1 = r2
            r2 = r3
        L_0x007c:
            float r2 = r2.element
            r21 = r1
            r1 = r0
            r0 = r21
            goto L_0x008b
        L_0x0084:
            float r0 = r1.$initialVelocity
            r21 = r2
            r2 = r0
            r0 = r21
        L_0x008b:
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

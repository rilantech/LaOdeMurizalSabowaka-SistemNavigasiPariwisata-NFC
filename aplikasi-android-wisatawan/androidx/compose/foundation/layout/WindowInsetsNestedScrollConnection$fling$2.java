package androidx.compose.foundation.layout;

import android.view.WindowInsetsAnimationController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2", f = "WindowInsetsConnection.android.kt", i = {}, l = {364}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: WindowInsetsConnection.android.kt */
final class WindowInsetsNestedScrollConnection$fling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WindowInsetsAnimationController $animationController;
    final /* synthetic */ int $current;
    final /* synthetic */ Ref.FloatRef $endVelocity;
    final /* synthetic */ float $flingAmount;
    final /* synthetic */ int $hidden;
    final /* synthetic */ int $shown;
    final /* synthetic */ SplineBasedFloatDecayAnimationSpec $spec;
    final /* synthetic */ boolean $targetShown;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowInsetsNestedScrollConnection$fling$2(WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, int i, float f, SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec, int i2, int i3, Ref.FloatRef floatRef, WindowInsetsAnimationController windowInsetsAnimationController, boolean z, Continuation<? super WindowInsetsNestedScrollConnection$fling$2> continuation) {
        super(2, continuation);
        this.this$0 = windowInsetsNestedScrollConnection;
        this.$current = i;
        this.$flingAmount = f;
        this.$spec = splineBasedFloatDecayAnimationSpec;
        this.$hidden = i2;
        this.$shown = i3;
        this.$endVelocity = floatRef;
        this.$animationController = windowInsetsAnimationController;
        this.$targetShown = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowInsetsNestedScrollConnection$fling$2 windowInsetsNestedScrollConnection$fling$2 = new WindowInsetsNestedScrollConnection$fling$2(this.this$0, this.$current, this.$flingAmount, this.$spec, this.$hidden, this.$shown, this.$endVelocity, this.$animationController, this.$targetShown, continuation);
        windowInsetsNestedScrollConnection$fling$2.L$0 = obj;
        return windowInsetsNestedScrollConnection$fling$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WindowInsetsNestedScrollConnection$fling$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                case 0: goto L_0x001b;
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
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0072
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r23)
            r1 = r22
            r2 = r23
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r10 = r1.this$0
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1 r4 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1
            int r12 = r1.$current
            float r13 = r1.$flingAmount
            androidx.compose.foundation.layout.SplineBasedFloatDecayAnimationSpec r14 = r1.$spec
            int r15 = r1.$hidden
            int r5 = r1.$shown
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r6 = r1.this$0
            kotlin.jvm.internal.Ref$FloatRef r7 = r1.$endVelocity
            android.view.WindowInsetsAnimationController r8 = r1.$animationController
            boolean r9 = r1.$targetShown
            r21 = 0
            r11 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r7 = r4
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            r4 = r3
            kotlinx.coroutines.Job r4 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r4, r5, r6, r7, r8, r9)
            r10.animationJob = r4
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r3 = r1.this$0
            kotlinx.coroutines.Job r3 = r3.animationJob
            if (r3 == 0) goto L_0x0074
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5 = 1
            r1.label = r5
            java.lang.Object r3 = r3.join(r4)
            if (r3 != r0) goto L_0x0070
            return r0
        L_0x0070:
            r0 = r1
            r1 = r2
        L_0x0072:
            r2 = r1
            r1 = r0
        L_0x0074:
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r0 = r1.this$0
            r3 = 0
            r0.animationJob = r3
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

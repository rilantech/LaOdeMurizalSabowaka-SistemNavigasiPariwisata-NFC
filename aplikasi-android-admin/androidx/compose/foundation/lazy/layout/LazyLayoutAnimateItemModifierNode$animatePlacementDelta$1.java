package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1", f = "LazyLayoutAnimateItemModifierNode.kt", i = {0}, l = {97, 103}, m = "invokeSuspend", n = {"spec"}, s = {"L$0"})
/* compiled from: LazyLayoutAnimateItemModifierNode.kt */
final class LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutAnimateItemModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode, long j, Continuation<? super LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutAnimateItemModifierNode;
        this.$totalDelta = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(this.this$0, this.$totalDelta, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            switch(r1) {
                case 0: goto L_0x0023;
                case 1: goto L_0x001a;
                case 2: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0011:
            r0 = r14
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ CancellationException -> 0x0017 }
            goto L_0x00d0
        L_0x0017:
            r1 = move-exception
            goto L_0x00d9
        L_0x001a:
            r1 = r14
            java.lang.Object r2 = r1.L$0
            androidx.compose.animation.core.FiniteAnimationSpec r2 = (androidx.compose.animation.core.FiniteAnimationSpec) r2
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ CancellationException -> 0x00d7 }
            goto L_0x007a
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r15)
            r1 = r14
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r2 = r1.this$0     // Catch:{ CancellationException -> 0x00d7 }
            androidx.compose.animation.core.Animatable r2 = r2.placementDeltaAnimation     // Catch:{ CancellationException -> 0x00d7 }
            boolean r2 = r2.isRunning()     // Catch:{ CancellationException -> 0x00d7 }
            if (r2 == 0) goto L_0x004c
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r2 = r1.this$0     // Catch:{ CancellationException -> 0x00d7 }
            androidx.compose.animation.core.FiniteAnimationSpec r2 = r2.getPlacementAnimationSpec()     // Catch:{ CancellationException -> 0x00d7 }
            boolean r2 = r2 instanceof androidx.compose.animation.core.SpringSpec     // Catch:{ CancellationException -> 0x00d7 }
            if (r2 == 0) goto L_0x0045
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r2 = r1.this$0     // Catch:{ CancellationException -> 0x00d7 }
            androidx.compose.animation.core.FiniteAnimationSpec r2 = r2.getPlacementAnimationSpec()     // Catch:{ CancellationException -> 0x00d7 }
            goto L_0x0052
        L_0x0045:
            androidx.compose.animation.core.SpringSpec r2 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNodeKt.InterruptionSpec     // Catch:{ CancellationException -> 0x00d7 }
            androidx.compose.animation.core.FiniteAnimationSpec r2 = (androidx.compose.animation.core.FiniteAnimationSpec) r2     // Catch:{ CancellationException -> 0x00d7 }
            goto L_0x0052
        L_0x004c:
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r2 = r1.this$0     // Catch:{ CancellationException -> 0x00d7 }
            androidx.compose.animation.core.FiniteAnimationSpec r2 = r2.getPlacementAnimationSpec()     // Catch:{ CancellationException -> 0x00d7 }
        L_0x0052:
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r3 = r1.this$0     // Catch:{ CancellationException -> 0x00d7 }
            androidx.compose.animation.core.Animatable r3 = r3.placementDeltaAnimation     // Catch:{ CancellationException -> 0x00d7 }
            boolean r3 = r3.isRunning()     // Catch:{ CancellationException -> 0x00d7 }
            if (r3 != 0) goto L_0x007b
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r3 = r1.this$0     // Catch:{ CancellationException -> 0x00d7 }
            androidx.compose.animation.core.Animatable r3 = r3.placementDeltaAnimation     // Catch:{ CancellationException -> 0x00d7 }
            long r4 = r1.$totalDelta     // Catch:{ CancellationException -> 0x00d7 }
            androidx.compose.ui.unit.IntOffset r4 = androidx.compose.ui.unit.IntOffset.m7663boximpl(r4)     // Catch:{ CancellationException -> 0x00d7 }
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ CancellationException -> 0x00d7 }
            r1.L$0 = r2     // Catch:{ CancellationException -> 0x00d7 }
            r6 = 1
            r1.label = r6     // Catch:{ CancellationException -> 0x00d7 }
            java.lang.Object r3 = r3.snapTo(r4, r5)     // Catch:{ CancellationException -> 0x00d7 }
            if (r3 != r0) goto L_0x007a
            return r0
        L_0x007a:
        L_0x007b:
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r3 = r1.this$0     // Catch:{ CancellationException -> 0x00d7 }
            androidx.compose.animation.core.Animatable r3 = r3.placementDeltaAnimation     // Catch:{ CancellationException -> 0x00d7 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ CancellationException -> 0x00d7 }
            androidx.compose.ui.unit.IntOffset r3 = (androidx.compose.ui.unit.IntOffset) r3     // Catch:{ CancellationException -> 0x00d7 }
            long r3 = r3.m7681unboximpl()     // Catch:{ CancellationException -> 0x00d7 }
            long r5 = r1.$totalDelta     // Catch:{ CancellationException -> 0x00d7 }
            r7 = 0
            int r8 = androidx.compose.ui.unit.IntOffset.m7672getXimpl(r3)     // Catch:{ CancellationException -> 0x00d7 }
            int r9 = androidx.compose.ui.unit.IntOffset.m7672getXimpl(r5)     // Catch:{ CancellationException -> 0x00d7 }
            int r8 = r8 - r9
            int r9 = androidx.compose.ui.unit.IntOffset.m7673getYimpl(r3)     // Catch:{ CancellationException -> 0x00d7 }
            int r10 = androidx.compose.ui.unit.IntOffset.m7673getYimpl(r5)     // Catch:{ CancellationException -> 0x00d7 }
            int r9 = r9 - r10
            long r8 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r8, r9)     // Catch:{ CancellationException -> 0x00d7 }
            r3 = r8
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r5 = r1.this$0     // Catch:{ CancellationException -> 0x00d7 }
            androidx.compose.animation.core.Animatable r6 = r5.placementDeltaAnimation     // Catch:{ CancellationException -> 0x00d7 }
            androidx.compose.ui.unit.IntOffset r7 = androidx.compose.ui.unit.IntOffset.m7663boximpl(r3)     // Catch:{ CancellationException -> 0x00d7 }
            r8 = r2
            androidx.compose.animation.core.AnimationSpec r8 = (androidx.compose.animation.core.AnimationSpec) r8     // Catch:{ CancellationException -> 0x00d7 }
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1$1 r5 = new androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1$1     // Catch:{ CancellationException -> 0x00d7 }
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r9 = r1.this$0     // Catch:{ CancellationException -> 0x00d7 }
            r5.<init>(r9, r3)     // Catch:{ CancellationException -> 0x00d7 }
            r10 = r5
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10     // Catch:{ CancellationException -> 0x00d7 }
            r11 = r1
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch:{ CancellationException -> 0x00d7 }
            r5 = 0
            r1.L$0 = r5     // Catch:{ CancellationException -> 0x00d7 }
            r5 = 2
            r1.label = r5     // Catch:{ CancellationException -> 0x00d7 }
            r9 = 0
            r12 = 4
            r13 = 0
            java.lang.Object r5 = androidx.compose.animation.core.Animatable.animateTo$default(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ CancellationException -> 0x00d7 }
            if (r5 != r0) goto L_0x00cf
            return r0
        L_0x00cf:
            r0 = r1
        L_0x00d0:
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r1 = r0.this$0     // Catch:{ CancellationException -> 0x0017 }
            r2 = 0
            r1.setAnimationInProgress(r2)     // Catch:{ CancellationException -> 0x0017 }
            goto L_0x00d9
        L_0x00d7:
            r0 = move-exception
            r0 = r1
        L_0x00d9:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

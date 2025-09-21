package androidx.compose.runtime;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {526, 537}, m = "invokeSuspend", n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* compiled from: Recomposer.kt */
final class Recomposer$runRecomposeAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeAndApplyChanges$2(Recomposer recomposer, Continuation<? super Recomposer$runRecomposeAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.this$0 = recomposer;
    }

    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2 = new Recomposer$runRecomposeAndApplyChanges$2(this.this$0, continuation);
        recomposer$runRecomposeAndApplyChanges$2.L$0 = monotonicFrameClock;
        return recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r20
            int r2 = r1.label
            switch(r2) {
                case 0: goto L_0x0069;
                case 1: goto L_0x0043;
                case 2: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0013:
            r1 = r20
            r2 = r21
            java.lang.Object r3 = r1.L$5
            java.util.Set r3 = (java.util.Set) r3
            java.lang.Object r4 = r1.L$4
            java.util.Set r4 = (java.util.Set) r4
            java.lang.Object r5 = r1.L$3
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r1.L$2
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r1.L$1
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r1.L$0
            androidx.compose.runtime.MonotonicFrameClock r8 = (androidx.compose.runtime.MonotonicFrameClock) r8
            kotlin.ResultKt.throwOnFailure(r2)
            r17 = r8
            r8 = r3
            r3 = r17
            r18 = r7
            r7 = r4
            r4 = r18
            r19 = r6
            r6 = r5
            r5 = r19
            goto L_0x00f7
        L_0x0043:
            r1 = r20
            r2 = r21
            java.lang.Object r3 = r1.L$5
            java.util.Set r3 = (java.util.Set) r3
            java.lang.Object r4 = r1.L$4
            java.util.Set r4 = (java.util.Set) r4
            java.lang.Object r5 = r1.L$3
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r1.L$2
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r1.L$1
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r1.L$0
            androidx.compose.runtime.MonotonicFrameClock r8 = (androidx.compose.runtime.MonotonicFrameClock) r8
            kotlin.ResultKt.throwOnFailure(r2)
            r15 = r3
            r14 = r4
            r13 = r5
            r12 = r6
            r11 = r7
            r3 = r8
            goto L_0x00bf
        L_0x0069:
            kotlin.ResultKt.throwOnFailure(r21)
            r1 = r20
            r2 = r21
            java.lang.Object r3 = r1.L$0
            androidx.compose.runtime.MonotonicFrameClock r3 = (androidx.compose.runtime.MonotonicFrameClock) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            java.util.Set r7 = (java.util.Set) r7
            java.util.LinkedHashSet r8 = new java.util.LinkedHashSet
            r8.<init>()
            java.util.Set r8 = (java.util.Set) r8
        L_0x0097:
            androidx.compose.runtime.Recomposer r9 = r1.this$0
            boolean r9 = r9.getShouldKeepRecomposing()
            if (r9 == 0) goto L_0x0103
            androidx.compose.runtime.Recomposer r9 = r1.this$0
            r10 = r1
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r1.L$0 = r3
            r1.L$1 = r4
            r1.L$2 = r5
            r1.L$3 = r6
            r1.L$4 = r7
            r1.L$5 = r8
            r11 = 1
            r1.label = r11
            java.lang.Object r9 = r9.awaitWorkAvailable(r10)
            if (r9 != r0) goto L_0x00ba
            return r0
        L_0x00ba:
            r11 = r4
            r12 = r5
            r13 = r6
            r14 = r7
            r15 = r8
        L_0x00bf:
            androidx.compose.runtime.Recomposer r4 = r1.this$0
            boolean r4 = r4.recordComposerModifications()
            if (r4 == 0) goto L_0x00fd
            androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$1 r16 = new androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$1
            androidx.compose.runtime.Recomposer r5 = r1.this$0
            r4 = r16
            r6 = r11
            r7 = r12
            r8 = r14
            r9 = r13
            r10 = r15
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r4 = r16
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r1.L$0 = r3
            r1.L$1 = r11
            r1.L$2 = r12
            r1.L$3 = r13
            r1.L$4 = r14
            r1.L$5 = r15
            r6 = 2
            r1.label = r6
            java.lang.Object r4 = r3.withFrameNanos(r4, r5)
            if (r4 != r0) goto L_0x00f2
            return r0
        L_0x00f2:
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
        L_0x00f7:
            androidx.compose.runtime.Recomposer r9 = r1.this$0
            r9.discardUnusedValues()
            goto L_0x0097
        L_0x00fd:
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            goto L_0x0097
        L_0x0103:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$clearRecompositionState(List<ControlledComposition> toRecompose, List<MovableContentStateReference> toInsert, List<ControlledComposition> toApply, Set<ControlledComposition> toLateApply, Set<ControlledComposition> toComplete) {
        toRecompose.clear();
        toInsert.clear();
        toApply.clear();
        toLateApply.clear();
        toComplete.clear();
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> toInsert, Recomposer this$02) {
        toInsert.clear();
        synchronized (this$02.stateLock) {
            List $this$fastForEach$iv = this$02.compositionValuesAwaitingInsert;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                toInsert.add((MovableContentStateReference) $this$fastForEach$iv.get(index$iv));
            }
            this$02.compositionValuesAwaitingInsert.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}

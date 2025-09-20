package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", f = "Recomposer.kt", i = {0, 0}, l = {945}, m = "invokeSuspend", n = {"callingJob", "unregisterApplyObserver"}, s = {"L$0", "L$1"})
/* compiled from: Recomposer.kt */
final class Recomposer$recompositionRunner$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ MonotonicFrameClock $parentFrameClock;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$recompositionRunner$2(Recomposer recomposer, Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super Recomposer$recompositionRunner$2> continuation) {
        super(2, continuation);
        this.this$0 = recomposer;
        this.$block = function3;
        this.$parentFrameClock = monotonicFrameClock;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Recomposer$recompositionRunner$2 recomposer$recompositionRunner$2 = new Recomposer$recompositionRunner$2(this.this$0, this.$block, this.$parentFrameClock, continuation);
        recomposer$recompositionRunner$2.L$0 = obj;
        return recomposer$recompositionRunner$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Recomposer$recompositionRunner$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a1, code lost:
        r1.dispose();
        r1 = r0.this$0.stateLock;
        r4 = r0.this$0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ad, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b3, code lost:
        if (r4.runnerJob != r3) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b5, code lost:
        r4.runnerJob = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b8, code lost:
        kotlinx.coroutines.CancellableContinuation unused = r4.deriveStateLocked();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bb, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bc, code lost:
        androidx.compose.runtime.Recomposer.Companion.removeRunning(r0.this$0.recomposerInfo);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ca, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 0
            switch(r1) {
                case 0: goto L_0x0023;
                case 1: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0012:
            r0 = r13
            java.lang.Object r1 = r0.L$1
            androidx.compose.runtime.snapshots.ObserverHandle r1 = (androidx.compose.runtime.snapshots.ObserverHandle) r1
            java.lang.Object r3 = r0.L$0
            kotlinx.coroutines.Job r3 = (kotlinx.coroutines.Job) r3
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0020 }
            goto L_0x00a1
        L_0x0020:
            r4 = move-exception
            goto L_0x00d6
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r14)
            r1 = r13
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.coroutines.CoroutineContext r4 = r3.getCoroutineContext()
            kotlinx.coroutines.Job r3 = kotlinx.coroutines.JobKt.getJob(r4)
            androidx.compose.runtime.Recomposer r4 = r1.this$0
            r4.registerRunnerJob(r3)
            androidx.compose.runtime.snapshots.Snapshot$Companion r4 = androidx.compose.runtime.snapshots.Snapshot.Companion
            androidx.compose.runtime.Recomposer$recompositionRunner$2$unregisterApplyObserver$1 r5 = new androidx.compose.runtime.Recomposer$recompositionRunner$2$unregisterApplyObserver$1
            androidx.compose.runtime.Recomposer r6 = r1.this$0
            r5.<init>(r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            androidx.compose.runtime.snapshots.ObserverHandle r4 = r4.registerApplyObserver(r5)
            androidx.compose.runtime.Recomposer$Companion r5 = androidx.compose.runtime.Recomposer.Companion
            androidx.compose.runtime.Recomposer r6 = r1.this$0
            androidx.compose.runtime.Recomposer$RecomposerInfoImpl r6 = r6.recomposerInfo
            r5.addRunning(r6)
            androidx.compose.runtime.Recomposer r5 = r1.this$0     // Catch:{ all -> 0x00d1 }
            java.lang.Object r5 = r5.stateLock     // Catch:{ all -> 0x00d1 }
            androidx.compose.runtime.Recomposer r6 = r1.this$0     // Catch:{ all -> 0x00d1 }
            r7 = 0
            monitor-enter(r5)     // Catch:{ all -> 0x00d1 }
            r8 = 0
            java.util.List r6 = r6.knownCompositions     // Catch:{ all -> 0x00ce }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ all -> 0x00ce }
            java.util.List r6 = kotlin.collections.CollectionsKt.toMutableList(r6)     // Catch:{ all -> 0x00ce }
            monitor-exit(r5)     // Catch:{ all -> 0x00d1 }
            r5 = r6
            r6 = 0
            r7 = 0
            int r8 = r5.size()     // Catch:{ all -> 0x00d1 }
        L_0x0071:
            if (r7 >= r8) goto L_0x0082
            java.lang.Object r9 = r5.get(r7)     // Catch:{ all -> 0x00d1 }
            r10 = r9
            androidx.compose.runtime.ControlledComposition r10 = (androidx.compose.runtime.ControlledComposition) r10     // Catch:{ all -> 0x00d1 }
            r11 = 0
            r10.invalidateAll()     // Catch:{ all -> 0x00d1 }
            int r7 = r7 + 1
            goto L_0x0071
        L_0x0082:
            androidx.compose.runtime.Recomposer$recompositionRunner$2$3 r5 = new androidx.compose.runtime.Recomposer$recompositionRunner$2$3     // Catch:{ all -> 0x00d1 }
            kotlin.jvm.functions.Function3<kotlinx.coroutines.CoroutineScope, androidx.compose.runtime.MonotonicFrameClock, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r1.$block     // Catch:{ all -> 0x00d1 }
            androidx.compose.runtime.MonotonicFrameClock r7 = r1.$parentFrameClock     // Catch:{ all -> 0x00d1 }
            r5.<init>(r6, r7, r2)     // Catch:{ all -> 0x00d1 }
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ all -> 0x00d1 }
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch:{ all -> 0x00d1 }
            r1.L$0 = r3     // Catch:{ all -> 0x00d1 }
            r1.L$1 = r4     // Catch:{ all -> 0x00d1 }
            r7 = 1
            r1.label = r7     // Catch:{ all -> 0x00d1 }
            java.lang.Object r5 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r5, r6)     // Catch:{ all -> 0x00d1 }
            if (r5 != r0) goto L_0x009f
            return r0
        L_0x009f:
            r0 = r1
            r1 = r4
        L_0x00a1:
            r1.dispose()
            androidx.compose.runtime.Recomposer r1 = r0.this$0
            java.lang.Object r1 = r1.stateLock
            androidx.compose.runtime.Recomposer r4 = r0.this$0
            r5 = 0
            monitor-enter(r1)
            r6 = 0
            kotlinx.coroutines.Job r7 = r4.runnerJob     // Catch:{ all -> 0x00cb }
            if (r7 != r3) goto L_0x00b8
            r4.runnerJob = r2     // Catch:{ all -> 0x00cb }
        L_0x00b8:
            kotlinx.coroutines.CancellableContinuation unused = r4.deriveStateLocked()     // Catch:{ all -> 0x00cb }
            monitor-exit(r1)
            androidx.compose.runtime.Recomposer$Companion r1 = androidx.compose.runtime.Recomposer.Companion
            androidx.compose.runtime.Recomposer r2 = r0.this$0
            androidx.compose.runtime.Recomposer$RecomposerInfoImpl r2 = r2.recomposerInfo
            r1.removeRunning(r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00cb:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x00ce:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00d1 }
            throw r0     // Catch:{ all -> 0x00d1 }
        L_0x00d1:
            r0 = move-exception
            r12 = r4
            r4 = r0
            r0 = r1
            r1 = r12
        L_0x00d6:
            r1.dispose()
            androidx.compose.runtime.Recomposer r1 = r0.this$0
            java.lang.Object r1 = r1.stateLock
            androidx.compose.runtime.Recomposer r5 = r0.this$0
            r6 = 0
            monitor-enter(r1)
            r7 = 0
            kotlinx.coroutines.Job r8 = r5.runnerJob     // Catch:{ all -> 0x00fd }
            if (r8 != r3) goto L_0x00ed
            r5.runnerJob = r2     // Catch:{ all -> 0x00fd }
        L_0x00ed:
            kotlinx.coroutines.CancellableContinuation unused = r5.deriveStateLocked()     // Catch:{ all -> 0x00fd }
            monitor-exit(r1)
            androidx.compose.runtime.Recomposer$Companion r1 = androidx.compose.runtime.Recomposer.Companion
            androidx.compose.runtime.Recomposer r2 = r0.this$0
            androidx.compose.runtime.Recomposer$RecomposerInfoImpl r2 = r2.recomposerInfo
            r1.removeRunning(r2)
            throw r4
        L_0x00fd:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$recompositionRunner$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

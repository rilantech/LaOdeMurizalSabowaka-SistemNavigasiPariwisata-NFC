package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 1}, l = {791, 811, 812}, m = "invokeSuspend", n = {"recomposeCoroutineScope", "frameSignal", "frameLoop", "frameLoop"}, s = {"L$0", "L$1", "L$2", "L$0"})
/* compiled from: Recomposer.kt */
final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $recomposeCoroutineContext;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(CoroutineContext coroutineContext, Recomposer recomposer, Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.$recomposeCoroutineContext = coroutineContext;
        this.this$0 = recomposer;
    }

    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(this.$recomposeCoroutineContext, this.this$0, continuation);
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = coroutineScope;
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1 = monotonicFrameClock;
        return recomposer$runRecomposeConcurrentlyAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00ac, code lost:
        if (r1.this$0.getShouldKeepRecomposing() == false) goto L_0x01a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00ae, code lost:
        r1.L$0 = r7;
        r1.L$1 = r14;
        r1.L$2 = r6;
        r1.label = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00bf, code lost:
        if (r1.this$0.awaitWorkAvailable(r1) != r0) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00c1, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c2, code lost:
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c3, code lost:
        r13 = r1.this$0;
        r15 = r1.this$0;
        r7 = r13.snapshotInvalidations;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d1, code lost:
        if (r7.isNotEmpty() == false) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d3, code lost:
        r8 = r13.knownCompositions;
        r10 = 0;
        r11 = r8.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00de, code lost:
        if (r10 >= r11) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e0, code lost:
        ((androidx.compose.runtime.ControlledComposition) r8.get(r10)).recordModificationsOf(r7);
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f6, code lost:
        r13.snapshotInvalidations = new androidx.compose.runtime.collection.IdentityArraySet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ff, code lost:
        r3 = r13.compositionInvalidations;
        r12 = r3.size();
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x010b, code lost:
        if (r11 >= r12) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x010d, code lost:
        r10 = (androidx.compose.runtime.ControlledComposition) r3.get(r11);
        r7 = r15.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x011b, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r23 = r0;
        r15.concurrentCompositionsOutstanding = r15.concurrentCompositionsOutstanding + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x012a, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x012b, code lost:
        r21 = r10;
        kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r5, androidx.compose.runtime.CompositionKt.getRecomposeCoroutineContext(r10), (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2(r15, r10, (kotlin.coroutines.Continuation<? super androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2>) null), 2, (java.lang.Object) null);
        r11 = r11 + 1;
        r0 = r23;
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0156, code lost:
        r23 = r0;
        r0 = r11;
        r13.compositionInvalidations.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0167, code lost:
        if (r13.deriveStateLocked() != null) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0169, code lost:
        r3 = r1.this$0.stateLock;
        r0 = r1.this$0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0174, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x017a, code lost:
        if (r0.getHasConcurrentFrameWorkLocked() == false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0180, code lost:
        r7 = r14.requestFrameLocked();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0182, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0183, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0185, code lost:
        if (r7 == null) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0187, code lost:
        r0 = kotlin.Result.Companion;
        r7.resumeWith(kotlin.Result.m6229constructorimpl(kotlin.Unit.INSTANCE));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0192, code lost:
        r0 = r23;
        r7 = r5;
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01a8, code lost:
        throw new java.lang.IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01a9, code lost:
        r1.L$0 = r6;
        r5 = null;
        r1.L$1 = null;
        r1.L$2 = null;
        r1.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01c2, code lost:
        if (kotlinx.coroutines.JobKt.cancelAndJoin(kotlinx.coroutines.JobKt.getJob(r7.getCoroutineContext()), r1) != r0) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01c4, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01c5, code lost:
        r3 = r6;
        r22 = r1;
        r1 = r0;
        r0 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01cb, code lost:
        r0.L$0 = r5;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01d7, code lost:
        if (kotlinx.coroutines.JobKt.cancelAndJoin(r3, r0) != r1) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01d9, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01da, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01dd, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            r23 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r23
            int r2 = r1.label
            r3 = 1
            r4 = 0
            switch(r2) {
                case 0: goto L_0x0049;
                case 1: goto L_0x0031;
                case 2: goto L_0x001e;
                case 3: goto L_0x0015;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0015:
            r0 = r23
            r1 = r24
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x01db
        L_0x001e:
            r1 = r23
            r2 = r24
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.Job r3 = (kotlinx.coroutines.Job) r3
            kotlin.ResultKt.throwOnFailure(r2)
            r5 = r4
            r22 = r1
            r1 = r0
            r0 = r22
            goto L_0x01cb
        L_0x0031:
            r1 = r23
            r2 = r24
            java.lang.Object r5 = r1.L$2
            kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
            java.lang.Object r6 = r1.L$1
            androidx.compose.runtime.ProduceFrameSignal r6 = (androidx.compose.runtime.ProduceFrameSignal) r6
            java.lang.Object r7 = r1.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            kotlin.ResultKt.throwOnFailure(r2)
            r14 = r6
            r6 = r5
            r5 = r7
            goto L_0x00c3
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r24)
            r1 = r23
            r2 = r24
            java.lang.Object r5 = r1.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            java.lang.Object r6 = r1.L$1
            r12 = r6
            androidx.compose.runtime.MonotonicFrameClock r12 = (androidx.compose.runtime.MonotonicFrameClock) r12
            kotlin.coroutines.CoroutineContext r6 = r1.$recomposeCoroutineContext
            kotlinx.coroutines.Job$Key r7 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r7 = (kotlin.coroutines.CoroutineContext.Key) r7
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r7)
            if (r6 != 0) goto L_0x0067
            r6 = r3
            goto L_0x0068
        L_0x0067:
            r6 = 0
        L_0x0068:
            kotlin.coroutines.CoroutineContext r7 = r1.$recomposeCoroutineContext
            if (r6 == 0) goto L_0x01de
            kotlin.coroutines.CoroutineContext r6 = r5.getCoroutineContext()
            kotlin.coroutines.CoroutineContext r7 = r1.$recomposeCoroutineContext
            kotlin.coroutines.CoroutineContext r6 = r6.plus(r7)
            kotlin.coroutines.CoroutineContext r7 = r5.getCoroutineContext()
            kotlinx.coroutines.Job r7 = kotlinx.coroutines.JobKt.getJob(r7)
            kotlinx.coroutines.CompletableJob r7 = kotlinx.coroutines.JobKt.Job((kotlinx.coroutines.Job) r7)
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            kotlin.coroutines.CoroutineContext r6 = r6.plus(r7)
            kotlinx.coroutines.CoroutineScope r13 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r6)
            androidx.compose.runtime.ProduceFrameSignal r6 = new androidx.compose.runtime.ProduceFrameSignal
            r6.<init>()
            r14 = r6
            androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1 r6 = new androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1
            androidx.compose.runtime.Recomposer r7 = r1.this$0
            r6.<init>(r7, r12, r14, r4)
            r9 = r6
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            r6 = r5
            kotlinx.coroutines.Job r6 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
            r7 = r13
        L_0x00a6:
            androidx.compose.runtime.Recomposer r5 = r1.this$0
            boolean r5 = r5.getShouldKeepRecomposing()
            if (r5 == 0) goto L_0x01a9
            androidx.compose.runtime.Recomposer r5 = r1.this$0
            r8 = r1
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r1.L$0 = r7
            r1.L$1 = r14
            r1.L$2 = r6
            r1.label = r3
            java.lang.Object r5 = r5.awaitWorkAvailable(r8)
            if (r5 != r0) goto L_0x00c2
            return r0
        L_0x00c2:
            r5 = r7
        L_0x00c3:
            androidx.compose.runtime.Recomposer r13 = r1.this$0
            androidx.compose.runtime.Recomposer r15 = r1.this$0
            r16 = 0
            androidx.compose.runtime.collection.IdentityArraySet r7 = r13.snapshotInvalidations
            boolean r8 = r7.isNotEmpty()
            if (r8 == 0) goto L_0x00ff
            java.util.List r8 = r13.knownCompositions
            r9 = 0
            r10 = 0
            int r11 = r8.size()
        L_0x00de:
            if (r10 >= r11) goto L_0x00f6
            java.lang.Object r12 = r8.get(r10)
            r4 = r12
            androidx.compose.runtime.ControlledComposition r4 = (androidx.compose.runtime.ControlledComposition) r4
            r17 = 0
            r3 = r7
            java.util.Set r3 = (java.util.Set) r3
            r4.recordModificationsOf(r3)
            int r10 = r10 + 1
            r3 = 1
            r4 = 0
            goto L_0x00de
        L_0x00f6:
            androidx.compose.runtime.collection.IdentityArraySet r3 = new androidx.compose.runtime.collection.IdentityArraySet
            r3.<init>()
            r13.snapshotInvalidations = r3
        L_0x00ff:
            java.util.List r3 = r13.compositionInvalidations
            r4 = 0
            r7 = 0
            int r12 = r3.size()
            r11 = r7
        L_0x010b:
            if (r11 >= r12) goto L_0x0156
            java.lang.Object r7 = r3.get(r11)
            r10 = r7
            androidx.compose.runtime.ControlledComposition r10 = (androidx.compose.runtime.ControlledComposition) r10
            r17 = 0
            java.lang.Object r7 = r15.stateLock
            r8 = 0
            monitor-enter(r7)
            r9 = 0
            int r19 = r15.concurrentCompositionsOutstanding     // Catch:{ all -> 0x0153 }
            r23 = r0
            r18 = 1
            int r0 = r19 + 1
            r15.concurrentCompositionsOutstanding = r0     // Catch:{ all -> 0x0153 }
            monitor-exit(r7)
            kotlin.coroutines.CoroutineContext r8 = androidx.compose.runtime.CompositionKt.getRecomposeCoroutineContext(r10)
            androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2 r0 = new androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2
            r7 = 0
            r0.<init>(r15, r10, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r19 = 2
            r20 = 0
            r9 = 0
            r7 = r5
            r21 = r10
            r10 = r0
            r0 = r11
            r11 = r19
            r19 = r12
            r12 = r20
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, r8, r9, r10, r11, r12)
            int r11 = r0 + 1
            r0 = r23
            r12 = r19
            goto L_0x010b
        L_0x0153:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        L_0x0156:
            r23 = r0
            r0 = r11
            r18 = 1
            java.util.List r0 = r13.compositionInvalidations
            r0.clear()
            kotlinx.coroutines.CancellableContinuation r0 = r13.deriveStateLocked()
            if (r0 != 0) goto L_0x019d
            androidx.compose.runtime.Recomposer r0 = r1.this$0
            java.lang.Object r3 = r0.stateLock
            androidx.compose.runtime.Recomposer r0 = r1.this$0
            r4 = 0
            monitor-enter(r3)
            r7 = 0
            boolean r0 = r0.getHasConcurrentFrameWorkLocked()     // Catch:{ all -> 0x019a }
            if (r0 == 0) goto L_0x0182
            kotlin.coroutines.Continuation r0 = r14.requestFrameLocked()     // Catch:{ all -> 0x019a }
            r7 = r0
            goto L_0x0183
        L_0x0182:
            r7 = 0
        L_0x0183:
            monitor-exit(r3)
            if (r7 == 0) goto L_0x0192
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            java.lang.Object r0 = kotlin.Result.m6229constructorimpl(r0)
            r7.resumeWith(r0)
        L_0x0192:
            r0 = r23
            r7 = r5
            r3 = r18
            r4 = 0
            goto L_0x00a6
        L_0x019a:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x019d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r3 = "called outside of runRecomposeAndApplyChanges"
            java.lang.String r3 = r3.toString()
            r0.<init>(r3)
            throw r0
        L_0x01a9:
            kotlin.coroutines.CoroutineContext r3 = r7.getCoroutineContext()
            kotlinx.coroutines.Job r3 = kotlinx.coroutines.JobKt.getJob(r3)
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r1.L$0 = r6
            r5 = 0
            r1.L$1 = r5
            r1.L$2 = r5
            r8 = 2
            r1.label = r8
            java.lang.Object r3 = kotlinx.coroutines.JobKt.cancelAndJoin(r3, r4)
            if (r3 != r0) goto L_0x01c5
            return r0
        L_0x01c5:
            r3 = r6
            r22 = r1
            r1 = r0
            r0 = r22
        L_0x01cb:
            r4 = r0
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r0.L$0 = r5
            r5 = 3
            r0.label = r5
            java.lang.Object r3 = kotlinx.coroutines.JobKt.cancelAndJoin(r3, r4)
            if (r3 != r1) goto L_0x01da
            return r1
        L_0x01da:
            r1 = r2
        L_0x01db:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        L_0x01de:
            r0 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "recomposeCoroutineContext may not contain a Job; found "
            java.lang.StringBuilder r3 = r3.append(r4)
            kotlinx.coroutines.Job$Key r4 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r4 = (kotlin.coroutines.CoroutineContext.Key) r4
            kotlin.coroutines.CoroutineContext$Element r4 = r7.get(r4)
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r0 = r3.toString()
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

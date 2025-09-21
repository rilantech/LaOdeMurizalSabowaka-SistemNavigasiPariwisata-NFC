package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {133, 137, 159}, m = "invokeSuspend", n = {"$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "found", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* compiled from: SnapshotFlow.kt */
final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T> $block;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(Function0<? extends T> function0, Continuation<? super SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1> continuation) {
        super(2, continuation);
        this.$block = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(this.$block, continuation);
        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = obj;
        return snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
    }

    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return ((SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e5, code lost:
        r10 = 0;
        r1.L$0 = r9;
        r1.L$1 = r8;
        r1.L$2 = r7;
        r1.L$3 = r6;
        r1.L$4 = r5;
        r1.L$5 = r4;
        r1.I$0 = 0;
        r1.label = 2;
        r11 = r6.receive(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fe, code lost:
        if (r11 != r0) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0100, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0101, code lost:
        r16 = r4;
        r4 = r2;
        r2 = r11;
        r11 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r5;
        r5 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r2 = (java.util.Set) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x010f, code lost:
        if (r10 != 0) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0115, code lost:
        if (androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.intersects$SnapshotStateKt__SnapshotFlowKt(r9, r2) == false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0118, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011a, code lost:
        r2 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011b, code lost:
        r10 = r2;
        r2 = (java.util.Set) kotlinx.coroutines.channels.ChannelResult.m7757getOrNullimpl(r7.m7772tryReceivePtdJZtk());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0126, code lost:
        if (r2 != null) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0128, code lost:
        if (r10 == 0) goto L_0x0181;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x012a, code lost:
        r9.clear();
        r2 = androidx.compose.runtime.snapshots.Snapshot.Companion.takeSnapshot(r8);
        r10 = r1.$block;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0135, code lost:
        r13 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r15 = r13.makeCurrent();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r10 = r10.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r13.restoreCurrent(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r2.dispose();
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0151, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r5) != false) goto L_0x0181;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0153, code lost:
        r5 = r2;
        r1.L$0 = r11;
        r1.L$1 = r9;
        r1.L$2 = r8;
        r1.L$3 = r7;
        r1.L$4 = r6;
        r1.L$5 = r5;
        r1.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x016a, code lost:
        if (r11.emit(r2, r1) != r0) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x016c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x016d, code lost:
        r2 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0176, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0177, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r13.restoreCurrent(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x017b, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x017c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r2.dispose();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0180, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0181, code lost:
        r2 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x018b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x018c, code lost:
        r2 = r4;
        r5 = r6;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r17
            int r2 = r1.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x0079;
                case 1: goto L_0x005b;
                case 2: goto L_0x0033;
                case 3: goto L_0x0014;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0014:
            r1 = r17
            r2 = r18
            java.lang.Object r4 = r1.L$5
            java.lang.Object r5 = r1.L$4
            androidx.compose.runtime.snapshots.ObserverHandle r5 = (androidx.compose.runtime.snapshots.ObserverHandle) r5
            java.lang.Object r6 = r1.L$3
            kotlinx.coroutines.channels.Channel r6 = (kotlinx.coroutines.channels.Channel) r6
            java.lang.Object r7 = r1.L$2
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r1.L$1
            java.util.Set r8 = (java.util.Set) r8
            java.lang.Object r9 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x019a }
            goto L_0x0174
        L_0x0033:
            r1 = r17
            r2 = r18
            int r4 = r1.I$0
            java.lang.Object r5 = r1.L$5
            java.lang.Object r6 = r1.L$4
            androidx.compose.runtime.snapshots.ObserverHandle r6 = (androidx.compose.runtime.snapshots.ObserverHandle) r6
            java.lang.Object r7 = r1.L$3
            kotlinx.coroutines.channels.Channel r7 = (kotlinx.coroutines.channels.Channel) r7
            java.lang.Object r8 = r1.L$2
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r9 = r1.L$1
            java.util.Set r9 = (java.util.Set) r9
            java.lang.Object r10 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0057 }
            r11 = r10
            r10 = r4
            r4 = r2
            goto L_0x010c
        L_0x0057:
            r0 = move-exception
            r5 = r6
            goto L_0x019b
        L_0x005b:
            r1 = r17
            r2 = r18
            java.lang.Object r4 = r1.L$5
            java.lang.Object r5 = r1.L$4
            androidx.compose.runtime.snapshots.ObserverHandle r5 = (androidx.compose.runtime.snapshots.ObserverHandle) r5
            java.lang.Object r6 = r1.L$3
            kotlinx.coroutines.channels.Channel r6 = (kotlinx.coroutines.channels.Channel) r6
            java.lang.Object r7 = r1.L$2
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r1.L$1
            java.util.Set r8 = (java.util.Set) r8
            java.lang.Object r9 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x019a }
            goto L_0x00e4
        L_0x0079:
            kotlin.ResultKt.throwOnFailure(r18)
            r1 = r17
            r2 = r18
            java.lang.Object r4 = r1.L$0
            r9 = r4
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.util.LinkedHashSet r4 = new java.util.LinkedHashSet
            r4.<init>()
            r8 = r4
            java.util.Set r8 = (java.util.Set) r8
            androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1 r4 = new androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1
            r4.<init>(r8)
            r7 = r4
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r4 = 2147483647(0x7fffffff, float:NaN)
            r5 = 6
            r6 = 0
            kotlinx.coroutines.channels.Channel r6 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r4, r6, r6, r5, r6)
            androidx.compose.runtime.snapshots.Snapshot$Companion r4 = androidx.compose.runtime.snapshots.Snapshot.Companion
            androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1 r5 = new androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1
            r5.<init>(r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            androidx.compose.runtime.snapshots.ObserverHandle r5 = r4.registerApplyObserver(r5)
            androidx.compose.runtime.snapshots.Snapshot$Companion r4 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x019a }
            androidx.compose.runtime.snapshots.Snapshot r4 = r4.takeSnapshot(r7)     // Catch:{ all -> 0x019a }
            kotlin.jvm.functions.Function0<T> r10 = r1.$block     // Catch:{ all -> 0x019a }
            r11 = 0
            r12 = r4
            r13 = 0
            androidx.compose.runtime.snapshots.Snapshot r14 = r12.makeCurrent()     // Catch:{ all -> 0x0195 }
            java.lang.Object r10 = r10.invoke()     // Catch:{ all -> 0x018f }
            r12.restoreCurrent(r14)     // Catch:{ all -> 0x0195 }
            r4.dispose()     // Catch:{ all -> 0x019a }
            r4 = r10
            r10 = r1
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch:{ all -> 0x019a }
            r1.L$0 = r9     // Catch:{ all -> 0x019a }
            r1.L$1 = r8     // Catch:{ all -> 0x019a }
            r1.L$2 = r7     // Catch:{ all -> 0x019a }
            r1.L$3 = r6     // Catch:{ all -> 0x019a }
            r1.L$4 = r5     // Catch:{ all -> 0x019a }
            r1.L$5 = r4     // Catch:{ all -> 0x019a }
            r1.label = r3     // Catch:{ all -> 0x019a }
            java.lang.Object r10 = r9.emit(r4, r10)     // Catch:{ all -> 0x019a }
            if (r10 != r0) goto L_0x00e4
            return r0
        L_0x00e4:
        L_0x00e5:
            r10 = 0
            r11 = r1
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch:{ all -> 0x019a }
            r1.L$0 = r9     // Catch:{ all -> 0x019a }
            r1.L$1 = r8     // Catch:{ all -> 0x019a }
            r1.L$2 = r7     // Catch:{ all -> 0x019a }
            r1.L$3 = r6     // Catch:{ all -> 0x019a }
            r1.L$4 = r5     // Catch:{ all -> 0x019a }
            r1.L$5 = r4     // Catch:{ all -> 0x019a }
            r1.I$0 = r10     // Catch:{ all -> 0x019a }
            r12 = 2
            r1.label = r12     // Catch:{ all -> 0x019a }
            java.lang.Object r11 = r6.receive(r11)     // Catch:{ all -> 0x019a }
            if (r11 != r0) goto L_0x0101
            return r0
        L_0x0101:
            r16 = r4
            r4 = r2
            r2 = r11
            r11 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r16
        L_0x010c:
            java.util.Set r2 = (java.util.Set) r2     // Catch:{ all -> 0x018b }
        L_0x010e:
            if (r10 != 0) goto L_0x011a
            boolean r12 = androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.intersects$SnapshotStateKt__SnapshotFlowKt(r9, r2)     // Catch:{ all -> 0x018b }
            if (r12 == 0) goto L_0x0118
            goto L_0x011a
        L_0x0118:
            r2 = 0
            goto L_0x011b
        L_0x011a:
            r2 = r3
        L_0x011b:
            r10 = r2
            java.lang.Object r2 = r7.m7772tryReceivePtdJZtk()     // Catch:{ all -> 0x018b }
            java.lang.Object r2 = kotlinx.coroutines.channels.ChannelResult.m7757getOrNullimpl(r2)     // Catch:{ all -> 0x018b }
            java.util.Set r2 = (java.util.Set) r2     // Catch:{ all -> 0x018b }
            if (r2 != 0) goto L_0x018a
            if (r10 == 0) goto L_0x0181
            r9.clear()     // Catch:{ all -> 0x018b }
            androidx.compose.runtime.snapshots.Snapshot$Companion r2 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x018b }
            androidx.compose.runtime.snapshots.Snapshot r2 = r2.takeSnapshot(r8)     // Catch:{ all -> 0x018b }
            kotlin.jvm.functions.Function0<T> r10 = r1.$block     // Catch:{ all -> 0x018b }
            r12 = 0
            r13 = r2
            r14 = 0
            androidx.compose.runtime.snapshots.Snapshot r15 = r13.makeCurrent()     // Catch:{ all -> 0x017c }
            java.lang.Object r10 = r10.invoke()     // Catch:{ all -> 0x0176 }
            r13.restoreCurrent(r15)     // Catch:{ all -> 0x017c }
            r2.dispose()     // Catch:{ all -> 0x018b }
            r2 = r10
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)     // Catch:{ all -> 0x018b }
            if (r10 != 0) goto L_0x0181
            r5 = r2
            r10 = r1
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch:{ all -> 0x018b }
            r1.L$0 = r11     // Catch:{ all -> 0x018b }
            r1.L$1 = r9     // Catch:{ all -> 0x018b }
            r1.L$2 = r8     // Catch:{ all -> 0x018b }
            r1.L$3 = r7     // Catch:{ all -> 0x018b }
            r1.L$4 = r6     // Catch:{ all -> 0x018b }
            r1.L$5 = r5     // Catch:{ all -> 0x018b }
            r12 = 3
            r1.label = r12     // Catch:{ all -> 0x018b }
            java.lang.Object r10 = r11.emit(r2, r10)     // Catch:{ all -> 0x018b }
            if (r10 != r0) goto L_0x016d
            return r0
        L_0x016d:
            r2 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r11
        L_0x0174:
            goto L_0x00e5
        L_0x0176:
            r0 = move-exception
            r3 = r0
            r13.restoreCurrent(r15)     // Catch:{ all -> 0x017c }
            throw r3     // Catch:{ all -> 0x017c }
        L_0x017c:
            r0 = move-exception
            r2.dispose()     // Catch:{ all -> 0x018b }
            throw r0     // Catch:{ all -> 0x018b }
        L_0x0181:
            r2 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            goto L_0x00e5
        L_0x018a:
            goto L_0x010e
        L_0x018b:
            r0 = move-exception
            r2 = r4
            r5 = r6
            goto L_0x019b
        L_0x018f:
            r0 = move-exception
            r3 = r0
            r12.restoreCurrent(r14)     // Catch:{ all -> 0x0195 }
            throw r3     // Catch:{ all -> 0x0195 }
        L_0x0195:
            r0 = move-exception
            r4.dispose()     // Catch:{ all -> 0x019a }
            throw r0     // Catch:{ all -> 0x019a }
        L_0x019a:
            r0 = move-exception
        L_0x019b:
            r5.dispose()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

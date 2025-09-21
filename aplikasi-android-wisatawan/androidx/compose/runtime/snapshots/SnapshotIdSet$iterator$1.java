package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", i = {0, 0, 1, 1, 2, 2}, l = {295, 300, 307}, m = "invokeSuspend", n = {"$this$sequence", "belowBound", "$this$sequence", "index", "$this$sequence", "index"}, s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
/* compiled from: SnapshotIdSet.kt */
final class SnapshotIdSet$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SnapshotIdSet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotIdSet$iterator$1(SnapshotIdSet snapshotIdSet, Continuation<? super SnapshotIdSet$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = snapshotIdSet;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$1 = new SnapshotIdSet$iterator$1(this.this$0, continuation);
        snapshotIdSet$iterator$1.L$0 = obj;
        return snapshotIdSet$iterator$1;
    }

    public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SnapshotIdSet$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0069, code lost:
        if (r11 >= r10) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006b, code lost:
        r1.L$0 = r13;
        r1.L$1 = r12;
        r1.I$0 = r11;
        r1.I$1 = r10;
        r1.label = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0082, code lost:
        if (r13.yield(kotlin.coroutines.jvm.internal.Boxing.boxInt(r12[r11]), r1) != r0) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0084, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0085, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0087, code lost:
        r10 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0090, code lost:
        if (r1.this$0.lowerSet == 0) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0092, code lost:
        r11 = r10;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0095, code lost:
        if (r10 >= 64) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a2, code lost:
        if ((r1.this$0.lowerSet & (1 << r10)) == 0) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a4, code lost:
        r1.L$0 = r11;
        r1.L$1 = null;
        r1.I$0 = r10;
        r1.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00c0, code lost:
        if (r11.yield(kotlin.coroutines.jvm.internal.Boxing.boxInt(r1.this$0.lowerBound + r10), r1) != r0) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c2, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c4, code lost:
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c6, code lost:
        r10 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cf, code lost:
        if (r1.this$0.upperSet == 0) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d1, code lost:
        r11 = r10;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d4, code lost:
        if (r10 >= 64) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e1, code lost:
        if ((r1.this$0.upperSet & (1 << r10)) == 0) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e3, code lost:
        r1.L$0 = r11;
        r1.L$1 = null;
        r1.I$0 = r10;
        r1.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0101, code lost:
        if (r11.yield(kotlin.coroutines.jvm.internal.Boxing.boxInt((r10 + 64) + r1.this$0.lowerBound), r1) != r0) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0103, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0106, code lost:
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x010a, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r17
            int r2 = r1.label
            r4 = 1
            r6 = 64
            r7 = 1
            r8 = 0
            switch(r2) {
                case 0: goto L_0x004d;
                case 1: goto L_0x0039;
                case 2: goto L_0x002a;
                case 3: goto L_0x001a;
                default: goto L_0x0012;
            }
        L_0x0012:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x001a:
            r1 = r17
            r2 = r18
            int r10 = r1.I$0
            java.lang.Object r11 = r1.L$0
            kotlin.sequences.SequenceScope r11 = (kotlin.sequences.SequenceScope) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r13 = 0
            goto L_0x0104
        L_0x002a:
            r1 = r17
            r2 = r18
            int r10 = r1.I$0
            java.lang.Object r11 = r1.L$0
            kotlin.sequences.SequenceScope r11 = (kotlin.sequences.SequenceScope) r11
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00c3
        L_0x0039:
            r1 = r17
            r2 = r18
            int r10 = r1.I$1
            int r11 = r1.I$0
            java.lang.Object r12 = r1.L$1
            int[] r12 = (int[]) r12
            java.lang.Object r13 = r1.L$0
            kotlin.sequences.SequenceScope r13 = (kotlin.sequences.SequenceScope) r13
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0085
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r18)
            r1 = r17
            r2 = r18
            java.lang.Object r10 = r1.L$0
            kotlin.sequences.SequenceScope r10 = (kotlin.sequences.SequenceScope) r10
            androidx.compose.runtime.snapshots.SnapshotIdSet r11 = r1.this$0
            int[] r11 = r11.belowBound
            if (r11 == 0) goto L_0x0088
            int r12 = r11.length
            r13 = 0
            r16 = r13
            r13 = r10
            r10 = r12
            r12 = r11
            r11 = r16
        L_0x0069:
            if (r11 >= r10) goto L_0x0087
            r14 = r12[r11]
            java.lang.Integer r15 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r14)
            r3 = r1
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r1.L$0 = r13
            r1.L$1 = r12
            r1.I$0 = r11
            r1.I$1 = r10
            r1.label = r7
            java.lang.Object r3 = r13.yield(r15, r3)
            if (r3 != r0) goto L_0x0085
            return r0
        L_0x0085:
            int r11 = r11 + r7
            goto L_0x0069
        L_0x0087:
            r10 = r13
        L_0x0088:
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r1.this$0
            long r11 = r3.lowerSet
            int r3 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x00c7
            r3 = 0
            r11 = r10
            r10 = r3
        L_0x0095:
            if (r10 >= r6) goto L_0x00c6
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r1.this$0
            long r12 = r3.lowerSet
            long r14 = r4 << r10
            long r12 = r12 & r14
            int r3 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x00c4
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r1.this$0
            int r3 = r3.lowerBound
            int r3 = r3 + r10
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            r12 = r1
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r1.L$0 = r11
            r13 = 0
            r1.L$1 = r13
            r1.I$0 = r10
            r13 = 2
            r1.label = r13
            java.lang.Object r3 = r11.yield(r3, r12)
            if (r3 != r0) goto L_0x00c3
            return r0
        L_0x00c3:
        L_0x00c4:
            int r10 = r10 + r7
            goto L_0x0095
        L_0x00c6:
            r10 = r11
        L_0x00c7:
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r1.this$0
            long r11 = r3.upperSet
            int r3 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x0108
            r3 = 0
            r11 = r10
            r10 = r3
        L_0x00d4:
            if (r10 >= r6) goto L_0x0108
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r1.this$0
            long r12 = r3.upperSet
            long r14 = r4 << r10
            long r12 = r12 & r14
            int r3 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x0105
            int r3 = r10 + 64
            androidx.compose.runtime.snapshots.SnapshotIdSet r12 = r1.this$0
            int r12 = r12.lowerBound
            int r3 = r3 + r12
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            r12 = r1
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r1.L$0 = r11
            r13 = 0
            r1.L$1 = r13
            r1.I$0 = r10
            r14 = 3
            r1.label = r14
            java.lang.Object r3 = r11.yield(r3, r12)
            if (r3 != r0) goto L_0x0104
            return r0
        L_0x0104:
            goto L_0x0106
        L_0x0105:
            r13 = 0
        L_0x0106:
            int r10 = r10 + r7
            goto L_0x00d4
        L_0x0108:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

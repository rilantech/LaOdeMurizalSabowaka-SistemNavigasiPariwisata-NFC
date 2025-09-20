package androidx.compose.runtime;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CancellableContinuation;", "", "frameTime", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Recomposer.kt */
final class Recomposer$runFrameLoop$2 extends Lambda implements Function1<Long, CancellableContinuation<? super Unit>> {
    final /* synthetic */ ProduceFrameSignal $frameSignal;
    final /* synthetic */ List<ControlledComposition> $toApply;
    final /* synthetic */ List<ControlledComposition> $toRecompose;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$runFrameLoop$2(Recomposer recomposer, List<ControlledComposition> list, List<ControlledComposition> list2, ProduceFrameSignal produceFrameSignal) {
        super(1);
        this.this$0 = recomposer;
        this.$toRecompose = list;
        this.$toApply = list2;
        this.$frameSignal = produceFrameSignal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).longValue());
    }

    /* Debug info: failed to restart local var, previous not found, register: 21 */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c6, code lost:
        r1 = new androidx.compose.runtime.collection.IdentityArraySet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cb, code lost:
        r2 = r3;
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r7 = r2.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d4, code lost:
        if (r6 >= r7) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d6, code lost:
        r14 = r0.performRecompose(r2.get(r6), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e2, code lost:
        if (r14 == null) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e4, code lost:
        r16 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r4.add(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ef, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f1, code lost:
        r16 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f3, code lost:
        r6 = r6 + 1;
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fb, code lost:
        r16 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r3.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x010b, code lost:
        if ((!r4.isEmpty()) == false) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010d, code lost:
        r0.changeCount = r0.getChangeCount() + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0117, code lost:
        r1 = r4;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r5 = r1.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if (r3 >= r5) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0122, code lost:
        r1.get(r3).applyChanges();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012d, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r4.clear();
        r1 = r0.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013c, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r0 = r0.deriveStateLocked();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0143, code lost:
        androidx.compose.runtime.Trace.INSTANCE.endSection(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x014b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0155, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0156, code lost:
        r16 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0158, code lost:
        r3.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x015b, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.CancellableContinuation<kotlin.Unit> invoke(long r22) {
        /*
            r21 = this;
            r1 = r21
            androidx.compose.runtime.Recomposer r0 = r1.this$0
            boolean r0 = r0.getHasBroadcastFrameClockAwaiters()
            if (r0 == 0) goto L_0x003a
            java.lang.String r2 = "Recomposer:animation"
            androidx.compose.runtime.Recomposer r0 = r1.this$0
            r3 = 0
            androidx.compose.runtime.Trace r4 = androidx.compose.runtime.Trace.INSTANCE
            java.lang.Object r4 = r4.beginSection(r2)
            r5 = 0
            androidx.compose.runtime.BroadcastFrameClock r0 = r0.broadcastFrameClock     // Catch:{ all -> 0x0031 }
            r6 = r22
            r0.sendFrame(r6)     // Catch:{ all -> 0x002f }
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x002f }
            r0.sendApplyNotifications()     // Catch:{ all -> 0x002f }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002f }
            androidx.compose.runtime.Trace r0 = androidx.compose.runtime.Trace.INSTANCE
            r0.endSection(r4)
            goto L_0x003c
        L_0x002f:
            r0 = move-exception
            goto L_0x0034
        L_0x0031:
            r0 = move-exception
            r6 = r22
        L_0x0034:
            androidx.compose.runtime.Trace r5 = androidx.compose.runtime.Trace.INSTANCE
            r5.endSection(r4)
            throw r0
        L_0x003a:
            r6 = r22
        L_0x003c:
            java.lang.String r2 = "Recomposer:recompose"
            androidx.compose.runtime.Recomposer r0 = r1.this$0
            java.util.List<androidx.compose.runtime.ControlledComposition> r3 = r1.$toRecompose
            java.util.List<androidx.compose.runtime.ControlledComposition> r4 = r1.$toApply
            androidx.compose.runtime.ProduceFrameSignal r5 = r1.$frameSignal
            r8 = 0
            androidx.compose.runtime.Trace r9 = androidx.compose.runtime.Trace.INSTANCE
            java.lang.Object r9 = r9.beginSection(r2)
            r10 = 0
            boolean unused = r0.recordComposerModifications()     // Catch:{ all -> 0x0165 }
            java.lang.Object r11 = r0.stateLock     // Catch:{ all -> 0x0165 }
            r12 = 0
            monitor-enter(r11)     // Catch:{ all -> 0x0165 }
            r13 = 0
            java.util.List r14 = r0.compositionsAwaitingApply     // Catch:{ all -> 0x015e }
            r15 = 0
            r16 = 0
            int r1 = r14.size()     // Catch:{ all -> 0x015e }
            r17 = r2
            r2 = r16
        L_0x0069:
            if (r2 >= r1) goto L_0x0089
            java.lang.Object r16 = r14.get(r2)     // Catch:{ all -> 0x015c }
            r18 = r16
            androidx.compose.runtime.ControlledComposition r18 = (androidx.compose.runtime.ControlledComposition) r18     // Catch:{ all -> 0x015c }
            r19 = r18
            r18 = 0
            r20 = r1
            r1 = r4
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x015c }
            r6 = r19
            r1.add(r6)     // Catch:{ all -> 0x015c }
            int r2 = r2 + 1
            r6 = r22
            r1 = r20
            goto L_0x0069
        L_0x0089:
            java.util.List r1 = r0.compositionsAwaitingApply     // Catch:{ all -> 0x015c }
            r1.clear()     // Catch:{ all -> 0x015c }
            java.util.List r1 = r0.compositionInvalidations     // Catch:{ all -> 0x015c }
            r2 = 0
            r6 = 0
            int r7 = r1.size()     // Catch:{ all -> 0x015c }
        L_0x009c:
            if (r6 >= r7) goto L_0x00b5
            java.lang.Object r14 = r1.get(r6)     // Catch:{ all -> 0x015c }
            r15 = r14
            androidx.compose.runtime.ControlledComposition r15 = (androidx.compose.runtime.ControlledComposition) r15     // Catch:{ all -> 0x015c }
            r16 = 0
            r18 = r1
            r1 = r3
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x015c }
            r1.add(r15)     // Catch:{ all -> 0x015c }
            int r6 = r6 + 1
            r1 = r18
            goto L_0x009c
        L_0x00b5:
            r18 = r1
            java.util.List r1 = r0.compositionInvalidations     // Catch:{ all -> 0x015c }
            r1.clear()     // Catch:{ all -> 0x015c }
            r5.takeFrameRequestLocked()     // Catch:{ all -> 0x015c }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x015c }
            monitor-exit(r11)     // Catch:{ all -> 0x0163 }
            androidx.compose.runtime.collection.IdentityArraySet r1 = new androidx.compose.runtime.collection.IdentityArraySet     // Catch:{ all -> 0x0163 }
            r1.<init>()     // Catch:{ all -> 0x0163 }
            r2 = r3
            r5 = 0
            r6 = 0
            int r7 = r2.size()     // Catch:{ all -> 0x0155 }
        L_0x00d4:
            if (r6 >= r7) goto L_0x00fb
            java.lang.Object r11 = r2.get(r6)     // Catch:{ all -> 0x0155 }
            r12 = r11
            androidx.compose.runtime.ControlledComposition r12 = (androidx.compose.runtime.ControlledComposition) r12     // Catch:{ all -> 0x0155 }
            r13 = 0
            androidx.compose.runtime.ControlledComposition r14 = r0.performRecompose(r12, r1)     // Catch:{ all -> 0x0155 }
            if (r14 == 0) goto L_0x00f1
            r15 = 0
            r16 = r1
            r1 = r4
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x00ef }
            r1.add(r14)     // Catch:{ all -> 0x00ef }
            goto L_0x00f3
        L_0x00ef:
            r0 = move-exception
            goto L_0x0158
        L_0x00f1:
            r16 = r1
        L_0x00f3:
            int r6 = r6 + 1
            r1 = r16
            goto L_0x00d4
        L_0x00fb:
            r16 = r1
            r3.clear()     // Catch:{ all -> 0x0163 }
            r1 = r4
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x0163 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0163 }
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x0117
            long r1 = r0.getChangeCount()     // Catch:{ all -> 0x0163 }
            r5 = 1
            long r1 = r1 + r5
            r0.changeCount = r1     // Catch:{ all -> 0x0163 }
        L_0x0117:
            r1 = r4
            r2 = 0
            r3 = 0
            int r5 = r1.size()     // Catch:{ all -> 0x0150 }
        L_0x0120:
            if (r3 >= r5) goto L_0x0132
            java.lang.Object r6 = r1.get(r3)     // Catch:{ all -> 0x0150 }
            r7 = r6
            androidx.compose.runtime.ControlledComposition r7 = (androidx.compose.runtime.ControlledComposition) r7     // Catch:{ all -> 0x0150 }
            r11 = 0
            r7.applyChanges()     // Catch:{ all -> 0x0150 }
            int r3 = r3 + 1
            goto L_0x0120
        L_0x0132:
            r4.clear()     // Catch:{ all -> 0x0163 }
            java.lang.Object r1 = r0.stateLock     // Catch:{ all -> 0x0163 }
            r2 = 0
            monitor-enter(r1)     // Catch:{ all -> 0x0163 }
            r3 = 0
            kotlinx.coroutines.CancellableContinuation r0 = r0.deriveStateLocked()     // Catch:{ all -> 0x014c }
            monitor-exit(r1)     // Catch:{ all -> 0x0163 }
            androidx.compose.runtime.Trace r1 = androidx.compose.runtime.Trace.INSTANCE
            r1.endSection(r9)
            return r0
        L_0x014c:
            r0 = move-exception
            r3 = r0
            monitor-exit(r1)     // Catch:{ all -> 0x0163 }
            throw r3     // Catch:{ all -> 0x0163 }
        L_0x0150:
            r0 = move-exception
            r4.clear()     // Catch:{ all -> 0x0163 }
            throw r0     // Catch:{ all -> 0x0163 }
        L_0x0155:
            r0 = move-exception
            r16 = r1
        L_0x0158:
            r3.clear()     // Catch:{ all -> 0x0163 }
            throw r0     // Catch:{ all -> 0x0163 }
        L_0x015c:
            r0 = move-exception
            goto L_0x0161
        L_0x015e:
            r0 = move-exception
            r17 = r2
        L_0x0161:
            monitor-exit(r11)     // Catch:{ all -> 0x0163 }
            throw r0     // Catch:{ all -> 0x0163 }
        L_0x0163:
            r0 = move-exception
            goto L_0x0168
        L_0x0165:
            r0 = move-exception
            r17 = r2
        L_0x0168:
            androidx.compose.runtime.Trace r1 = androidx.compose.runtime.Trace.INSTANCE
            r1.endSection(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$runFrameLoop$2.invoke(long):kotlinx.coroutines.CancellableContinuation");
    }
}

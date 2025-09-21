package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0017\u0018\u0000 g2\u00020\u0001:\u0001gBC\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\b\u00109\u001a\u00020\tH\u0002J\r\u0010:\u001a\u00020\tH\u0000¢\u0006\u0002\b;J'\u0010:\u001a\u0002H<\"\u0004\b\u0000\u0010<2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H<0>H\bø\u0001\u0000¢\u0006\u0004\b;\u0010?J\b\u0010@\u001a\u00020AH\u0016J\r\u0010B\u001a\u00020\tH\u0010¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\tH\u0016J\b\u0010E\u001a\u00020\rH\u0016J3\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020\u00032\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020J\u0018\u00010I2\u0006\u0010K\u001a\u00020\u0005H\u0000¢\u0006\u0002\bLJ\u0015\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bQJ\r\u0010R\u001a\u00020\tH\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\u0014H\u0010¢\u0006\u0002\bVJ\u0015\u0010W\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bXJ\u0015\u0010Y\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0005H\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\\J\u0015\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020&H\u0000¢\u0006\u0002\b_J\r\u0010`\u001a\u00020\tH\u0010¢\u0006\u0002\baJ\b\u0010b\u001a\u00020\tH\u0002J8\u0010c\u001a\u00020\u00002\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\u001e\u0010d\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\b\u0010e\u001a\u00020\tH\u0002J\b\u0010f\u001a\u00020\tH\u0002R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R4\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u000fR\u0014\u0010/\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,\u0002\u0007\n\u0005\b20\u0001¨\u0006h"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "applied", "", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "merged", "", "Landroidx/compose/runtime/snapshots/StateObject;", "getMerged$runtime_release", "()Ljava/util/List;", "setMerged$runtime_release", "(Ljava/util/List;)V", "<set-?>", "Landroidx/compose/runtime/collection/IdentityArraySet;", "modified", "getModified$runtime_release", "()Landroidx/compose/runtime/collection/IdentityArraySet;", "setModified", "(Landroidx/compose/runtime/collection/IdentityArraySet;)V", "previousIds", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "previousPinnedSnapshots", "", "getPreviousPinnedSnapshots$runtime_release", "()[I", "setPreviousPinnedSnapshots$runtime_release", "([I)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "writeCount", "getWriteCount$runtime_release", "()I", "setWriteCount$runtime_release", "(I)V", "getWriteObserver$runtime_release", "abandon", "advance", "advance$runtime_release", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "closeLocked", "closeLocked$runtime_release", "dispose", "hasPendingChanges", "innerApplyLocked", "snapshotId", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "invalidSnapshots", "innerApplyLocked$runtime_release", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "recordPrevious", "recordPrevious$runtime_release", "recordPreviousList", "recordPreviousList$runtime_release", "recordPreviousPinnedSnapshot", "recordPreviousPinnedSnapshot$runtime_release", "recordPreviousPinnedSnapshots", "handles", "recordPreviousPinnedSnapshots$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePreviouslyPinnedSnapshotsLocked", "takeNestedMutableSnapshot", "takeNestedSnapshot", "validateNotApplied", "validateNotAppliedOrPinned", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
public class MutableSnapshot extends Snapshot {
    public static final int $stable = 8;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int[] EmptyIntArray = new int[0];
    private boolean applied;
    private List<? extends StateObject> merged;
    private IdentityArraySet<StateObject> modified;
    private SnapshotIdSet previousIds = SnapshotIdSet.Companion.getEMPTY();
    private int[] previousPinnedSnapshots = EmptyIntArray;
    private final Function1<Object, Unit> readObserver;
    private int snapshots = 1;
    private int writeCount;
    private final Function1<Object, Unit> writeObserver;

    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutableSnapshot(int id, SnapshotIdSet invalid, Function1<Object, Unit> readObserver2, Function1<Object, Unit> writeObserver2) {
        super(id, invalid, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        this.readObserver = readObserver2;
        this.writeObserver = writeObserver2;
    }

    public boolean hasPendingChanges() {
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        return modified$runtime_release != null && modified$runtime_release.isNotEmpty();
    }

    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot mutableSnapshot, Function1 function1, Function1 function12, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            if ((i & 2) != 0) {
                function12 = null;
            }
            return mutableSnapshot.takeNestedMutableSnapshot(function1, function12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0073, code lost:
        if (getApplied$runtime_release() != false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0079, code lost:
        if (getDisposed$runtime_release() != false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007b, code lost:
        r5 = getId();
        r7 = androidx.compose.runtime.snapshots.SnapshotKt.getLock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0085, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9 = androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId;
        androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId = r9 + 1;
        setId$runtime_release(r9);
        androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots.set(getId());
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a5, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a6, code lost:
        setInvalid$runtime_release(androidx.compose.runtime.snapshots.SnapshotKt.addRange(getInvalid$runtime_release(), r5 + 1, getId()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c0, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006a, code lost:
        r3 = r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.runtime.snapshots.MutableSnapshot takeNestedMutableSnapshot(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r19, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r20) {
        /*
            r18 = this;
            r18.validateNotDisposed$runtime_release()
            r18.validateNotAppliedOrPinned()
            r1 = r18
            r2 = 0
            int r0 = r1.getId()
            r1.recordPrevious$runtime_release(r0)
            r3 = 0
            r4 = 0
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r6 = 0
            monitor-enter(r5)
            r0 = 0
            int r7 = androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId     // Catch:{ all -> 0x00c3 }
            int r8 = r7 + 1
            androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId = r8     // Catch:{ all -> 0x00c3 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r8 = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots     // Catch:{ all -> 0x00c3 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r8 = r8.set(r7)     // Catch:{ all -> 0x00c3 }
            androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots = r8     // Catch:{ all -> 0x00c3 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r8 = r18.getInvalid$runtime_release()     // Catch:{ all -> 0x00c3 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r9 = r8.set(r7)     // Catch:{ all -> 0x00c3 }
            r15 = r18
            r15.setInvalid$runtime_release(r9)     // Catch:{ all -> 0x00c1 }
            androidx.compose.runtime.snapshots.NestedMutableSnapshot r16 = new androidx.compose.runtime.snapshots.NestedMutableSnapshot     // Catch:{ all -> 0x00c1 }
            int r9 = r18.getId()     // Catch:{ all -> 0x00c1 }
            int r9 = r9 + 1
            androidx.compose.runtime.snapshots.SnapshotIdSet r11 = androidx.compose.runtime.snapshots.SnapshotKt.addRange(r8, r9, r7)     // Catch:{ all -> 0x00c1 }
            kotlin.jvm.functions.Function1 r9 = r18.getReadObserver$runtime_release()     // Catch:{ all -> 0x00c1 }
            r10 = 4
            r12 = 0
            r13 = 0
            r14 = r19
            kotlin.jvm.functions.Function1 r12 = androidx.compose.runtime.snapshots.SnapshotKt.mergedReadObserver$default(r14, r9, r13, r10, r12)     // Catch:{ all -> 0x00c1 }
            kotlin.jvm.functions.Function1 r9 = r18.getWriteObserver$runtime_release()     // Catch:{ all -> 0x00c1 }
            r13 = r20
            kotlin.jvm.functions.Function1 r17 = androidx.compose.runtime.snapshots.SnapshotKt.mergedWriteObserver(r13, r9)     // Catch:{ all -> 0x00c1 }
            r9 = r16
            r10 = r7
            r13 = r17
            r14 = r18
            r9.<init>(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x00c1 }
            monitor-exit(r5)
            r3 = r16
            r4 = 0
            boolean r0 = r1.getApplied$runtime_release()
            if (r0 != 0) goto L_0x00bc
            boolean r0 = r1.getDisposed$runtime_release()
            if (r0 != 0) goto L_0x00bc
            int r5 = r1.getId()
            r6 = 0
            java.lang.Object r7 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r8 = 0
            monitor-enter(r7)
            r0 = 0
            int r9 = androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId     // Catch:{ all -> 0x00b9 }
            int r10 = r9 + 1
            androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId = r10     // Catch:{ all -> 0x00b9 }
            r1.setId$runtime_release(r9)     // Catch:{ all -> 0x00b9 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r9 = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots     // Catch:{ all -> 0x00b9 }
            int r10 = r1.getId()     // Catch:{ all -> 0x00b9 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r9 = r9.set(r10)     // Catch:{ all -> 0x00b9 }
            androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots = r9     // Catch:{ all -> 0x00b9 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00b9 }
            monitor-exit(r7)
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r1.getInvalid$runtime_release()
            int r6 = r5 + 1
            int r7 = r1.getId()
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = androidx.compose.runtime.snapshots.SnapshotKt.addRange(r0, r6, r7)
            r1.setInvalid$runtime_release(r0)
            goto L_0x00bc
        L_0x00b9:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        L_0x00bc:
            androidx.compose.runtime.snapshots.MutableSnapshot r16 = (androidx.compose.runtime.snapshots.MutableSnapshot) r16
            return r16
        L_0x00c1:
            r0 = move-exception
            goto L_0x00c6
        L_0x00c3:
            r0 = move-exception
            r15 = r18
        L_0x00c6:
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.takeNestedMutableSnapshot(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):androidx.compose.runtime.snapshots.MutableSnapshot");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00eb, code lost:
        r1.applied = true;
        r6 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00f1, code lost:
        if (r6 == null) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f7, code lost:
        if (r6.isEmpty() == false) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fa, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00fc, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fd, code lost:
        if (r6 != false) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ff, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r6 = r5;
        r7 = r4;
        r9 = 0;
        r12 = r7.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010b, code lost:
        if (r9 >= r12) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x010d, code lost:
        ((kotlin.jvm.functions.Function2) r7.get(r9)).invoke(r6, r1);
        r9 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x011e, code lost:
        r6 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0121, code lost:
        if (r6 == null) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0127, code lost:
        if (r6.isEmpty() == false) goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0129, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x012a, code lost:
        if (r10 != false) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x012c, code lost:
        r6 = r4;
        r8 = 0;
        r9 = r6.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0134, code lost:
        if (r8 >= r9) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0136, code lost:
        ((kotlin.jvm.functions.Function2) r6.get(r8)).invoke(r2, r1);
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0147, code lost:
        r7 = androidx.compose.runtime.snapshots.SnapshotKt.getLock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x014d, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        releasePinnedSnapshotsForCloseLocked$runtime_release();
        androidx.compose.runtime.snapshots.SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0155, code lost:
        if (r5 == null) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0157, code lost:
        r10 = r5;
        r12 = r10.getValues();
        r13 = 0;
        r14 = r10.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0163, code lost:
        if (r13 >= r14) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0165, code lost:
        r15 = r12[r13];
        kotlin.jvm.internal.Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked((androidx.compose.runtime.snapshots.StateObject) r15);
        r13 = r13 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x017a, code lost:
        if (r2 == null) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x017c, code lost:
        r0 = r2;
        r11 = r0.getValues();
        r12 = 0;
        r13 = r0.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0188, code lost:
        if (r12 >= r13) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x018a, code lost:
        r14 = r11[r12];
        kotlin.jvm.internal.Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked((androidx.compose.runtime.snapshots.StateObject) r14);
        r12 = r12 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x019d, code lost:
        r0 = r1.merged;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x019f, code lost:
        if (r0 == null) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01a1, code lost:
        r11 = 0;
        r12 = r0.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01a8, code lost:
        if (r11 >= r12) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01aa, code lost:
        androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked((androidx.compose.runtime.snapshots.StateObject) r0.get(r11));
        r11 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01ba, code lost:
        r1.merged = null;
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01c0, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01c6, code lost:
        return androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            r16 = this;
            r1 = r16
            androidx.compose.runtime.collection.IdentityArraySet r2 = r16.getModified$runtime_release()
            r0 = 0
            if (r2 == 0) goto L_0x0034
            java.util.concurrent.atomic.AtomicReference r3 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot
            java.lang.Object r3 = r3.get()
            java.lang.String r4 = "currentGlobalSnapshot.get()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            androidx.compose.runtime.snapshots.MutableSnapshot r3 = (androidx.compose.runtime.snapshots.MutableSnapshot) r3
            androidx.compose.runtime.snapshots.SnapshotIdSet r4 = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots
            java.util.concurrent.atomic.AtomicReference r5 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot
            java.lang.Object r5 = r5.get()
            androidx.compose.runtime.snapshots.GlobalSnapshot r5 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r5
            int r5 = r5.getId()
            androidx.compose.runtime.snapshots.SnapshotIdSet r4 = r4.clear(r5)
            java.util.Map r3 = androidx.compose.runtime.snapshots.SnapshotKt.optimisticMerges(r3, r1, r4)
            goto L_0x0035
        L_0x0034:
            r3 = r0
        L_0x0035:
            r4 = 0
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            r5 = 0
            r6 = 0
            java.lang.Object r7 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r8 = 0
            monitor-enter(r7)
            r9 = 0
            r10 = r1
            androidx.compose.runtime.snapshots.Snapshot r10 = (androidx.compose.runtime.snapshots.Snapshot) r10     // Catch:{ all -> 0x01ca }
            androidx.compose.runtime.snapshots.SnapshotKt.validateOpen(r10)     // Catch:{ all -> 0x01ca }
            r10 = 0
            r11 = 1
            if (r2 == 0) goto L_0x00a9
            int r12 = r2.size()     // Catch:{ all -> 0x01ca }
            if (r12 != 0) goto L_0x0055
            goto L_0x00a9
        L_0x0055:
            java.util.concurrent.atomic.AtomicReference r12 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot     // Catch:{ all -> 0x01ca }
            java.lang.Object r12 = r12.get()     // Catch:{ all -> 0x01ca }
            androidx.compose.runtime.snapshots.GlobalSnapshot r12 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r12     // Catch:{ all -> 0x01ca }
            int r13 = androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId     // Catch:{ all -> 0x01ca }
            androidx.compose.runtime.snapshots.SnapshotIdSet r14 = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots     // Catch:{ all -> 0x01ca }
            int r15 = r12.getId()     // Catch:{ all -> 0x01ca }
            androidx.compose.runtime.snapshots.SnapshotIdSet r14 = r14.clear(r15)     // Catch:{ all -> 0x01ca }
            androidx.compose.runtime.snapshots.SnapshotApplyResult r13 = r1.innerApplyLocked$runtime_release(r13, r3, r14)     // Catch:{ all -> 0x01ca }
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r14 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE     // Catch:{ all -> 0x01ca }
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)     // Catch:{ all -> 0x01ca }
            if (r14 != 0) goto L_0x007f
            monitor-exit(r7)
            return r13
        L_0x007f:
            r16.closeLocked$runtime_release()     // Catch:{ all -> 0x01ca }
            java.lang.String r14 = "previousGlobalSnapshot"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r14)     // Catch:{ all -> 0x01ca }
            r14 = r12
            androidx.compose.runtime.snapshots.Snapshot r14 = (androidx.compose.runtime.snapshots.Snapshot) r14     // Catch:{ all -> 0x01ca }
            kotlin.jvm.functions.Function1 r15 = androidx.compose.runtime.snapshots.SnapshotKt.emptyLambda     // Catch:{ all -> 0x01ca }
            java.lang.Object unused = androidx.compose.runtime.snapshots.SnapshotKt.takeNewGlobalSnapshot(r14, r15)     // Catch:{ all -> 0x01ca }
            androidx.compose.runtime.collection.IdentityArraySet r14 = r12.getModified$runtime_release()     // Catch:{ all -> 0x01ca }
            r1.setModified(r0)     // Catch:{ all -> 0x01ca }
            r12.setModified(r0)     // Catch:{ all -> 0x01ca }
            java.util.List r15 = androidx.compose.runtime.snapshots.SnapshotKt.applyObservers     // Catch:{ all -> 0x01ca }
            java.util.Collection r15 = (java.util.Collection) r15     // Catch:{ all -> 0x01ca }
            java.util.List r15 = kotlin.collections.CollectionsKt.toMutableList(r15)     // Catch:{ all -> 0x01ca }
            r4 = r15
            r5 = r14
            goto L_0x00e7
        L_0x00a9:
            r16.closeLocked$runtime_release()     // Catch:{ all -> 0x01ca }
            java.util.concurrent.atomic.AtomicReference r12 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot     // Catch:{ all -> 0x01ca }
            java.lang.Object r12 = r12.get()     // Catch:{ all -> 0x01ca }
            androidx.compose.runtime.snapshots.GlobalSnapshot r12 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r12     // Catch:{ all -> 0x01ca }
            java.lang.String r13 = "previousGlobalSnapshot"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)     // Catch:{ all -> 0x01ca }
            r13 = r12
            androidx.compose.runtime.snapshots.Snapshot r13 = (androidx.compose.runtime.snapshots.Snapshot) r13     // Catch:{ all -> 0x01ca }
            kotlin.jvm.functions.Function1 r14 = androidx.compose.runtime.snapshots.SnapshotKt.emptyLambda     // Catch:{ all -> 0x01ca }
            java.lang.Object unused = androidx.compose.runtime.snapshots.SnapshotKt.takeNewGlobalSnapshot(r13, r14)     // Catch:{ all -> 0x01ca }
            androidx.compose.runtime.collection.IdentityArraySet r13 = r12.getModified$runtime_release()     // Catch:{ all -> 0x01ca }
            r14 = r13
            java.util.Collection r14 = (java.util.Collection) r14     // Catch:{ all -> 0x01ca }
            if (r14 == 0) goto L_0x00d8
            boolean r14 = r14.isEmpty()     // Catch:{ all -> 0x01ca }
            if (r14 == 0) goto L_0x00d6
            goto L_0x00d8
        L_0x00d6:
            r14 = r10
            goto L_0x00d9
        L_0x00d8:
            r14 = r11
        L_0x00d9:
            if (r14 != 0) goto L_0x00e7
            java.util.List r14 = androidx.compose.runtime.snapshots.SnapshotKt.applyObservers     // Catch:{ all -> 0x01ca }
            java.util.Collection r14 = (java.util.Collection) r14     // Catch:{ all -> 0x01ca }
            java.util.List r14 = kotlin.collections.CollectionsKt.toMutableList(r14)     // Catch:{ all -> 0x01ca }
            r4 = r14
            r5 = r13
        L_0x00e7:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01ca }
            monitor-exit(r7)
            r1.applied = r11
            r6 = r5
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L_0x00fc
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x00fa
            goto L_0x00fc
        L_0x00fa:
            r6 = r10
            goto L_0x00fd
        L_0x00fc:
            r6 = r11
        L_0x00fd:
            if (r6 != 0) goto L_0x011e
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r6 = r5
            r7 = r4
            r8 = 0
            r9 = 0
            int r12 = r7.size()
        L_0x010b:
            if (r9 >= r12) goto L_0x011d
            java.lang.Object r13 = r7.get(r9)
            r14 = r13
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r15 = 0
            r14.invoke(r6, r1)
            int r9 = r9 + 1
            goto L_0x010b
        L_0x011d:
        L_0x011e:
            r6 = r2
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L_0x0129
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x012a
        L_0x0129:
            r10 = r11
        L_0x012a:
            if (r10 != 0) goto L_0x0147
            r6 = r4
            r7 = 0
            r8 = 0
            int r9 = r6.size()
        L_0x0134:
            if (r8 >= r9) goto L_0x0146
            java.lang.Object r10 = r6.get(r8)
            r11 = r10
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r12 = 0
            r11.invoke(r2, r1)
            int r8 = r8 + 1
            goto L_0x0134
        L_0x0146:
        L_0x0147:
            r6 = 0
            java.lang.Object r7 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r8 = 0
            monitor-enter(r7)
            r9 = 0
            r16.releasePinnedSnapshotsForCloseLocked$runtime_release()     // Catch:{ all -> 0x01c7 }
            androidx.compose.runtime.snapshots.SnapshotKt.checkAndOverwriteUnusedRecordsLocked()     // Catch:{ all -> 0x01c7 }
            if (r5 == 0) goto L_0x017a
            r10 = r5
            r11 = 0
            java.lang.Object[] r12 = r10.getValues()     // Catch:{ all -> 0x01c7 }
            r13 = 0
            int r14 = r10.size()     // Catch:{ all -> 0x01c7 }
        L_0x0163:
            if (r13 >= r14) goto L_0x0179
            r15 = r12[r13]     // Catch:{ all -> 0x01c7 }
            java.lang.String r0 = "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15, r0)     // Catch:{ all -> 0x01c7 }
            androidx.compose.runtime.snapshots.StateObject r15 = (androidx.compose.runtime.snapshots.StateObject) r15     // Catch:{ all -> 0x01c7 }
            r0 = r15
            r15 = 0
            androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked(r0)     // Catch:{ all -> 0x01c7 }
            int r13 = r13 + 1
            r0 = 0
            goto L_0x0163
        L_0x0179:
        L_0x017a:
            if (r2 == 0) goto L_0x019d
            r0 = r2
            r10 = 0
            java.lang.Object[] r11 = r0.getValues()     // Catch:{ all -> 0x01c7 }
            r12 = 0
            int r13 = r0.size()     // Catch:{ all -> 0x01c7 }
        L_0x0188:
            if (r12 >= r13) goto L_0x019c
            r14 = r11[r12]     // Catch:{ all -> 0x01c7 }
            java.lang.String r15 = "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r15)     // Catch:{ all -> 0x01c7 }
            androidx.compose.runtime.snapshots.StateObject r14 = (androidx.compose.runtime.snapshots.StateObject) r14     // Catch:{ all -> 0x01c7 }
            r15 = 0
            androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked(r14)     // Catch:{ all -> 0x01c7 }
            int r12 = r12 + 1
            goto L_0x0188
        L_0x019c:
        L_0x019d:
            java.util.List<? extends androidx.compose.runtime.snapshots.StateObject> r0 = r1.merged     // Catch:{ all -> 0x01c7 }
            if (r0 == 0) goto L_0x01ba
            r10 = 0
            r11 = 0
            int r12 = r0.size()     // Catch:{ all -> 0x01c7 }
        L_0x01a8:
            if (r11 >= r12) goto L_0x01b9
            java.lang.Object r13 = r0.get(r11)     // Catch:{ all -> 0x01c7 }
            r14 = r13
            androidx.compose.runtime.snapshots.StateObject r14 = (androidx.compose.runtime.snapshots.StateObject) r14     // Catch:{ all -> 0x01c7 }
            r15 = 0
            androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked(r14)     // Catch:{ all -> 0x01c7 }
            int r11 = r11 + 1
            goto L_0x01a8
        L_0x01b9:
        L_0x01ba:
            r0 = 0
            r1.merged = r0     // Catch:{ all -> 0x01c7 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01c7 }
            monitor-exit(r7)
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r0 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE
            androidx.compose.runtime.snapshots.SnapshotApplyResult r0 = (androidx.compose.runtime.snapshots.SnapshotApplyResult) r0
            return r0
        L_0x01c7:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        L_0x01ca:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    public boolean getReadOnly() {
        return false;
    }

    public Snapshot getRoot() {
        return this;
    }

    public void dispose() {
        if (!getDisposed$runtime_release()) {
            super.dispose();
            nestedDeactivated$runtime_release(this);
        }
    }

    public Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver2) {
        NestedReadonlySnapshot nestedReadonlySnapshot;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        int previousId = getId();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            int readonlyId = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = readonlyId + 1;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(readonlyId);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(readonlyId, SnapshotKt.addRange(getInvalid$runtime_release(), previousId + 1, readonlyId), readObserver2, this);
        }
        NestedReadonlySnapshot nestedReadonlySnapshot2 = nestedReadonlySnapshot;
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int previousId$iv = getId();
            synchronized (SnapshotKt.getLock()) {
                int access$getNextSnapshotId$p = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p + 1;
                setId$runtime_release(access$getNextSnapshotId$p);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), previousId$iv + 1, getId()));
        }
        return nestedReadonlySnapshot;
    }

    public void nestedActivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.snapshots++;
    }

    public void nestedDeactivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        int i = this.snapshots;
        if (i > 0) {
            int i2 = i - 1;
            this.snapshots = i2;
            if (i2 == 0 && !this.applied) {
                abandon();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public void notifyObjectsInitialized$runtime_release() {
        if (!this.applied && !getDisposed$runtime_release()) {
            advance$runtime_release();
        }
    }

    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId()).andNot(this.previousIds);
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    private final void validateNotApplied() {
        if (!(!this.applied)) {
            throw new IllegalStateException("Unsupported operation on a snapshot that has been applied".toString());
        }
    }

    private final void validateNotAppliedOrPinned() {
        boolean z = true;
        if (this.applied) {
            if ((this.pinningTrackingHandle >= 0 ? 1 : null) == null) {
                z = false;
            }
        }
        if (!z) {
            throw new IllegalStateException("Unsupported operation on a disposed or applied snapshot".toString());
        }
    }

    private final void abandon() {
        IdentityArraySet modified2 = getModified$runtime_release();
        if (modified2 != null) {
            validateNotApplied();
            setModified((IdentityArraySet<StateObject>) null);
            int id = getId();
            IdentityArraySet this_$iv = modified2;
            Object[] values$iv = this_$iv.getValues();
            int size = this_$iv.size();
            for (int i$iv = 0; i$iv < size; i$iv++) {
                Object obj = values$iv[i$iv];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                for (StateRecord current = ((StateObject) obj).getFirstStateRecord(); current != null; current = current.getNext$runtime_release()) {
                    if (current.getSnapshotId$runtime_release() == id || CollectionsKt.contains(this.previousIds, Integer.valueOf(current.getSnapshotId$runtime_release()))) {
                        current.setSnapshotId$runtime_release(0);
                    }
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    public final SnapshotApplyResult innerApplyLocked$runtime_release(int snapshotId, Map<StateRecord, ? extends StateRecord> optimisticMerges, SnapshotIdSet invalidSnapshots) {
        int $i$f$fastForEach;
        IdentityArraySet this_$iv;
        SnapshotIdSet start;
        StateRecord merged2;
        List list;
        List list2;
        Object mergedRecords;
        List list3;
        List list4;
        Map<StateRecord, ? extends StateRecord> map = optimisticMerges;
        SnapshotIdSet snapshotIdSet = invalidSnapshots;
        Intrinsics.checkNotNullParameter(snapshotIdSet, "invalidSnapshots");
        SnapshotIdSet start2 = getInvalid$runtime_release().set(getId()).or(this.previousIds);
        IdentityArraySet modified$runtime_release = getModified$runtime_release();
        Intrinsics.checkNotNull(modified$runtime_release);
        IdentityArraySet this_$iv2 = modified$runtime_release;
        int $i$f$fastForEach2 = false;
        Object[] values$iv = this_$iv2.getValues();
        int size = this_$iv2.size();
        List list5 = null;
        int i$iv = 0;
        List list6 = null;
        while (i$iv < size) {
            Object obj = values$iv[i$iv];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            StateObject state = (StateObject) obj;
            StateRecord first = state.getFirstStateRecord();
            StateRecord access$readable = SnapshotKt.readable(first, snapshotId, snapshotIdSet);
            if (access$readable != null) {
                StateRecord current = access$readable;
                StateRecord previous = SnapshotKt.readable(first, getId(), start2);
                if (previous != null) {
                    start = start2;
                    StateRecord current2 = current;
                    if (!Intrinsics.areEqual((Object) current2, (Object) previous)) {
                        this_$iv = this_$iv2;
                        $i$f$fastForEach = $i$f$fastForEach2;
                        StateRecord applied2 = SnapshotKt.readable(first, getId(), getInvalid$runtime_release());
                        if (applied2 != null) {
                            if (map == null || (merged2 = (StateRecord) map.get(current2)) == null) {
                                MutableSnapshot mutableSnapshot = this;
                                merged2 = state.mergeRecords(previous, current2, applied2);
                            }
                            if (merged2 == null) {
                                return new SnapshotApplyResult.Failure(this);
                            }
                            if (!Intrinsics.areEqual((Object) merged2, (Object) applied2)) {
                                if (Intrinsics.areEqual((Object) merged2, (Object) current2)) {
                                    if (list5 == null) {
                                        List it = new ArrayList();
                                        list5 = it;
                                        list3 = it;
                                    } else {
                                        list3 = list5;
                                    }
                                    List list7 = list3;
                                    list5.add(TuplesKt.to(state, current2.create()));
                                    if (list6 == null) {
                                        List it2 = new ArrayList();
                                        list6 = it2;
                                        list4 = it2;
                                    } else {
                                        list4 = list6;
                                    }
                                    list6.add(state);
                                    list6 = list4;
                                    list5 = list7;
                                } else {
                                    if (list5 == null) {
                                        List it3 = new ArrayList();
                                        list5 = it3;
                                        list = it3;
                                    } else {
                                        list = list5;
                                    }
                                    if (!Intrinsics.areEqual((Object) merged2, (Object) previous)) {
                                        list2 = list;
                                        mergedRecords = TuplesKt.to(state, merged2);
                                    } else {
                                        list2 = list;
                                        mergedRecords = TuplesKt.to(state, previous.create());
                                    }
                                    list5.add(mergedRecords);
                                    list5 = list2;
                                }
                            }
                        } else {
                            Void unused = SnapshotKt.readError();
                            throw new KotlinNothingValueException();
                        }
                    } else {
                        this_$iv = this_$iv2;
                        $i$f$fastForEach = $i$f$fastForEach2;
                    }
                    i$iv++;
                    map = optimisticMerges;
                    snapshotIdSet = invalidSnapshots;
                    start2 = start;
                    this_$iv2 = this_$iv;
                    $i$f$fastForEach2 = $i$f$fastForEach;
                }
            }
            start = start2;
            this_$iv = this_$iv2;
            $i$f$fastForEach = $i$f$fastForEach2;
            i$iv++;
            map = optimisticMerges;
            snapshotIdSet = invalidSnapshots;
            start2 = start;
            this_$iv2 = this_$iv;
            $i$f$fastForEach2 = $i$f$fastForEach;
        }
        int i = snapshotId;
        SnapshotIdSet snapshotIdSet2 = start2;
        IdentityArraySet identityArraySet = this_$iv2;
        int i2 = $i$f$fastForEach2;
        if (list5 != null) {
            List it4 = list5;
            advance$runtime_release();
            List $this$fastForEach$iv = it4;
            int size2 = $this$fastForEach$iv.size();
            int index$iv = 0;
            while (index$iv < size2) {
                Pair merged3 = (Pair) $this$fastForEach$iv.get(index$iv);
                StateObject state2 = (StateObject) merged3.component1();
                List it5 = it4;
                StateRecord stateRecord = (StateRecord) merged3.component2();
                stateRecord.setSnapshotId$runtime_release(getId());
                synchronized (SnapshotKt.getLock()) {
                    stateRecord.setNext$runtime_release(state2.getFirstStateRecord());
                    state2.prependStateRecord(stateRecord);
                    Unit unit = Unit.INSTANCE;
                }
                index$iv++;
                it4 = it5;
            }
        }
        if (list6 != null) {
            List list8 = list6;
            List $this$fastForEach$iv2 = list8;
            int size3 = $this$fastForEach$iv2.size();
            for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
                modified$runtime_release.remove((StateObject) $this$fastForEach$iv2.get(index$iv2));
            }
            List mergedList = this.merged;
            this.merged = mergedList == null ? list8 : CollectionsKt.plus(mergedList, list8);
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    public final <T> T advance$runtime_release(Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        recordPrevious$runtime_release(getId());
        T invoke = block.invoke();
        T t = invoke;
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int previousId = getId();
            synchronized (SnapshotKt.getLock()) {
                try {
                    int access$getNextSnapshotId$p = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p + 1;
                    setId$runtime_release(access$getNextSnapshotId$p);
                    SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), previousId + 1, getId()));
        }
        return invoke;
    }

    public final void advance$runtime_release() {
        recordPrevious$runtime_release(getId());
        Unit unit = Unit.INSTANCE;
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int previousId$iv = getId();
            synchronized (SnapshotKt.getLock()) {
                int access$getNextSnapshotId$p = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p + 1;
                setId$runtime_release(access$getNextSnapshotId$p);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                Unit unit2 = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), previousId$iv + 1, getId()));
        }
    }

    public final void recordPrevious$runtime_release(int id) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.set(id);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int id) {
        if (id >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, id);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(int[] handles) {
        Intrinsics.checkNotNullParameter(handles, "handles");
        boolean z = true;
        if (!(handles.length == 0)) {
            int[] pinned = this.previousPinnedSnapshots;
            if (pinned.length != 0) {
                z = false;
            }
            this.previousPinnedSnapshots = z ? handles : ArraysKt.plus(pinned, handles);
        }
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        for (int releasePinningLocked : this.previousPinnedSnapshots) {
            SnapshotKt.releasePinningLocked(releasePinningLocked);
        }
    }

    public final void recordPreviousList$runtime_release(SnapshotIdSet snapshots2) {
        Intrinsics.checkNotNullParameter(snapshots2, "snapshots");
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.or(snapshots2);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void recordModified$runtime_release(StateObject state) {
        Intrinsics.checkNotNullParameter(state, "state");
        IdentityArraySet it = getModified$runtime_release();
        if (it == null) {
            it = new IdentityArraySet();
            setModified(it);
        }
        it.add(state);
    }

    public int getWriteCount$runtime_release() {
        return this.writeCount;
    }

    public void setWriteCount$runtime_release(int i) {
        this.writeCount = i;
    }

    public IdentityArraySet<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    public void setModified(IdentityArraySet<StateObject> identityArraySet) {
        this.modified = identityArraySet;
    }

    public final List<StateObject> getMerged$runtime_release() {
        return this.merged;
    }

    public final void setMerged$runtime_release(List<? extends StateObject> list) {
        this.merged = list;
    }

    public final SnapshotIdSet getPreviousIds$runtime_release() {
        return this.previousIds;
    }

    public final void setPreviousIds$runtime_release(SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "<set-?>");
        this.previousIds = snapshotIdSet;
    }

    public final int[] getPreviousPinnedSnapshots$runtime_release() {
        return this.previousPinnedSnapshots;
    }

    public final void setPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.previousPinnedSnapshots = iArr;
    }

    public final boolean getApplied$runtime_release() {
        return this.applied;
    }

    public final void setApplied$runtime_release(boolean z) {
        this.applied = z;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot$Companion;", "", "()V", "EmptyIntArray", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Snapshot.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

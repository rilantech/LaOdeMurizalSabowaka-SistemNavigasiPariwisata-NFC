package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.AtomicInt;
import androidx.compose.runtime.SnapshotThreadLocal;
import androidx.compose.runtime.WeakReference;
import androidx.compose.runtime.collection.IdentityArraySet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\u001a\b\u0010)\u001a\u00020\bH\u0002\u001a6\u0010)\u001a\u0002H*\"\u0004\b\u0000\u0010*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H*0\u000fH\u0002¢\u0006\u0002\u0010,\u001a\b\u0010-\u001a\u00020\bH\u0002\u001a4\u0010.\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\b\b\u0002\u00101\u001a\u000202H\u0002\u001a\u001f\u00103\u001a\u0002H*\"\b\b\u0000\u0010**\u0002042\u0006\u00105\u001a\u0002H*H\u0001¢\u0006\u0002\u00106\u001a'\u00103\u001a\u0002H*\"\b\b\u0000\u0010**\u0002042\u0006\u00105\u001a\u0002H*2\u0006\u00107\u001a\u00020\u0007H\u0001¢\u0006\u0002\u00108\u001a\b\u00109\u001a\u00020\u0007H\u0000\u001aL\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\b\b\u0002\u0010<\u001a\u000202H\u0002\u001aB\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0002\u001a\u0018\u0010?\u001a\u00020\b2\u0006\u00107\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0016H\u0001\u001a.\u0010A\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000204\u0018\u00010B2\u0006\u00109\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020\u0010H\u0002\u001a\u0010\u0010F\u001a\u0002022\u0006\u0010@\u001a\u00020\u0016H\u0002\u001a\u0010\u0010G\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u0016H\u0002\u001a\b\u0010H\u001a\u00020IH\u0002\u001a1\u0010J\u001a\u0004\u0018\u0001H*\"\b\b\u0000\u0010**\u0002042\u0006\u00105\u001a\u0002H*2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010L\u001a\u0010\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u0001H\u0000\u001a\b\u0010O\u001a\u00020IH\u0002\u001a%\u0010P\u001a\u0002H*\"\u0004\b\u0000\u0010*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0QH\bø\u0001\u0000¢\u0006\u0002\u0010R\u001a>\u0010S\u001a\u0002H*\"\u0004\b\u0000\u0010*2\u0006\u0010T\u001a\u00020\u00072!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H*0\u000fH\u0002¢\u0006\u0002\u0010U\u001a:\u0010V\u001a\u0002H*\"\b\b\u0000\u0010**\u00020\u00072!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H*0\u000fH\u0002¢\u0006\u0002\u0010W\u001a\u0018\u0010X\u001a\u00020\u00012\u0006\u0010K\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0000\u001a\u0012\u0010Y\u001a\u0004\u0018\u0001042\u0006\u0010@\u001a\u00020\u0016H\u0002\u001a \u0010Z\u001a\u0002022\u0006\u0010[\u001a\u0002042\u0006\u00107\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a \u0010Z\u001a\u0002022\u0006\u00109\u001a\u00020\u00012\u0006\u0010\\\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a\u0010\u0010]\u001a\u00020\b2\u0006\u00107\u001a\u00020\u0007H\u0002\u001a\u001c\u0010^\u001a\u00020\u0010*\u00020\u00102\u0006\u0010_\u001a\u00020\u00012\u0006\u0010`\u001a\u00020\u0001H\u0000\u001a!\u0010a\u001a\u000204*\u0002042\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002020\u000fH\b\u001a#\u0010c\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u0016H\u0000¢\u0006\u0002\u0010d\u001a+\u0010e\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010f\u001a+\u0010g\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010f\u001aN\u0010h\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u0010j\u001a\u0002H*2\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002Hi0\u000f¢\u0006\u0002\bkH\bø\u0001\u0000¢\u0006\u0002\u0010l\u001a3\u0010m\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00072\u0006\u0010j\u001a\u0002H*H\u0000¢\u0006\u0002\u0010n\u001a!\u0010J\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u0016¢\u0006\u0002\u0010d\u001a)\u0010J\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007¢\u0006\u0002\u0010f\u001aH\u0010o\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(5\u0012\u0004\u0012\u0002Hi0\u000fH\bø\u0001\u0000¢\u0006\u0002\u0010p\u001aF\u0010q\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002Hi0\u000f¢\u0006\u0002\bkH\bø\u0001\u0000¢\u0006\u0002\u0010r\u001aN\u0010q\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00072\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002Hi0\u000f¢\u0006\u0002\bkH\bø\u0001\u0000¢\u0006\u0002\u0010s\u001a+\u0010t\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\",\u0010\u0002\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\".\u0010\t\u001a\"\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nj\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b`\rX\u0004¢\u0006\u0002\n\u0000\")\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\u000fX\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000\" \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000f0\u0003X\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0018\u001a\u00020\u00068\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u000e\u0010\u001d\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010#\u001a\u00020\u00078\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010&\"\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070(X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006u"}, d2 = {"INVALID_SNAPSHOT", "", "applyObservers", "", "Lkotlin/Function2;", "", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "", "currentGlobalSnapshot", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "emptyLambda", "Lkotlin/Function1;", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "Lkotlin/ParameterName;", "name", "invalid", "extraStateObjects", "Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "globalWriteObservers", "lock", "getLock$annotations", "()V", "getLock", "()Ljava/lang/Object;", "nextSnapshotId", "openSnapshots", "pendingApplyObserverCount", "Landroidx/compose/runtime/AtomicInt;", "pinningTable", "Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "snapshotInitializer", "getSnapshotInitializer$annotations", "getSnapshotInitializer", "()Landroidx/compose/runtime/snapshots/Snapshot;", "threadSnapshot", "Landroidx/compose/runtime/SnapshotThreadLocal;", "advanceGlobalSnapshot", "T", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "checkAndOverwriteUnusedRecordsLocked", "createTransparentSnapshotWithNoParentReadObserver", "previousSnapshot", "readObserver", "ownsPreviousSnapshot", "", "current", "Landroidx/compose/runtime/snapshots/StateRecord;", "r", "(Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "snapshot", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "currentSnapshot", "mergedReadObserver", "parentObserver", "mergeReadObserver", "mergedWriteObserver", "writeObserver", "notifyWrite", "state", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "applyingSnapshot", "invalidSnapshots", "overwriteUnusedRecordsLocked", "processForUnusedRecordsLocked", "readError", "", "readable", "id", "(Landroidx/compose/runtime/snapshots/StateRecord;ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/StateRecord;", "releasePinningLocked", "handle", "reportReadonlySnapshotWrite", "sync", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "takeNewGlobalSnapshot", "previousGlobalSnapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "takeNewSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "trackPinning", "usedLocked", "valid", "data", "candidateSnapshot", "validateOpen", "addRange", "from", "until", "findYoungestOr", "predicate", "newOverwritableRecordLocked", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecordLocked", "overwritable", "R", "candidate", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "overwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "withCurrent", "(Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writable", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writableRecord", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
public final class SnapshotKt {
    private static final int INVALID_SNAPSHOT = 0;
    /* access modifiers changed from: private */
    public static final List<Function2<Set<? extends Object>, Snapshot, Unit>> applyObservers = new ArrayList();
    /* access modifiers changed from: private */
    public static final AtomicReference<GlobalSnapshot> currentGlobalSnapshot;
    /* access modifiers changed from: private */
    public static final Function1<SnapshotIdSet, Unit> emptyLambda = SnapshotKt$emptyLambda$1.INSTANCE;
    private static final SnapshotWeakSet<StateObject> extraStateObjects = new SnapshotWeakSet<>();
    /* access modifiers changed from: private */
    public static final List<Function1<Object, Unit>> globalWriteObservers = new ArrayList();
    private static final Object lock = new Object();
    /* access modifiers changed from: private */
    public static int nextSnapshotId;
    /* access modifiers changed from: private */
    public static SnapshotIdSet openSnapshots;
    /* access modifiers changed from: private */
    public static AtomicInt pendingApplyObserverCount = new AtomicInt(0);
    private static final SnapshotDoubleIndexHeap pinningTable = new SnapshotDoubleIndexHeap();
    private static final Snapshot snapshotInitializer;
    /* access modifiers changed from: private */
    public static final SnapshotThreadLocal<Snapshot> threadSnapshot = new SnapshotThreadLocal<>();

    public static /* synthetic */ void getLock$annotations() {
    }

    public static /* synthetic */ void getSnapshotInitializer$annotations() {
    }

    public static final int trackPinning(int id, SnapshotIdSet invalid) {
        int add;
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        int pinned = invalid.lowest(id);
        synchronized (getLock()) {
            add = pinningTable.add(pinned);
        }
        return add;
    }

    public static final void releasePinningLocked(int handle) {
        pinningTable.remove(handle);
    }

    public static final Snapshot currentSnapshot() {
        Snapshot snapshot = threadSnapshot.get();
        if (snapshot != null) {
            return snapshot;
        }
        GlobalSnapshot globalSnapshot = currentGlobalSnapshot.get();
        Intrinsics.checkNotNullExpressionValue(globalSnapshot, "currentGlobalSnapshot.get()");
        return globalSnapshot;
    }

    static {
        openSnapshots = SnapshotIdSet.Companion.getEMPTY();
        nextSnapshotId = 1;
        int i = nextSnapshotId;
        nextSnapshotId = i + 1;
        GlobalSnapshot it = new GlobalSnapshot(i, SnapshotIdSet.Companion.getEMPTY());
        openSnapshots = openSnapshots.set(it.getId());
        AtomicReference<GlobalSnapshot> atomicReference = new AtomicReference<>(it);
        currentGlobalSnapshot = atomicReference;
        GlobalSnapshot globalSnapshot = atomicReference.get();
        Intrinsics.checkNotNullExpressionValue(globalSnapshot, "currentGlobalSnapshot.get()");
        snapshotInitializer = globalSnapshot;
    }

    static /* synthetic */ Snapshot createTransparentSnapshotWithNoParentReadObserver$default(Snapshot snapshot, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return createTransparentSnapshotWithNoParentReadObserver(snapshot, function1, z);
    }

    /* access modifiers changed from: private */
    public static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot previousSnapshot, Function1<Object, Unit> readObserver, boolean ownsPreviousSnapshot) {
        if (!(previousSnapshot instanceof MutableSnapshot) && previousSnapshot != null) {
            return new TransparentObserverSnapshot(previousSnapshot, readObserver, false, ownsPreviousSnapshot);
        }
        return new TransparentObserverMutableSnapshot(previousSnapshot instanceof MutableSnapshot ? (MutableSnapshot) previousSnapshot : null, readObserver, (Function1<Object, Unit>) null, false, ownsPreviousSnapshot);
    }

    static /* synthetic */ Function1 mergedReadObserver$default(Function1 function1, Function1 function12, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return mergedReadObserver(function1, function12, z);
    }

    /* access modifiers changed from: private */
    public static final Function1<Object, Unit> mergedReadObserver(Function1<Object, Unit> readObserver, Function1<Object, Unit> parentObserver, boolean mergeReadObserver) {
        Function1 parentObserver2 = mergeReadObserver ? parentObserver : null;
        if (readObserver == null || parentObserver2 == null || Intrinsics.areEqual((Object) readObserver, (Object) parentObserver2)) {
            return readObserver == null ? parentObserver2 : readObserver;
        }
        return new SnapshotKt$mergedReadObserver$1(readObserver, parentObserver2);
    }

    /* access modifiers changed from: private */
    public static final Function1<Object, Unit> mergedWriteObserver(Function1<Object, Unit> writeObserver, Function1<Object, Unit> parentObserver) {
        if (writeObserver == null || parentObserver == null || Intrinsics.areEqual((Object) writeObserver, (Object) parentObserver)) {
            return writeObserver == null ? parentObserver : writeObserver;
        }
        return new SnapshotKt$mergedWriteObserver$1(writeObserver, parentObserver);
    }

    public static final Object getLock() {
        return lock;
    }

    public static final <T> T sync(Function0<? extends T> block) {
        T invoke;
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (getLock()) {
            try {
                invoke = block.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }

    public static final Snapshot getSnapshotInitializer() {
        return snapshotInitializer;
    }

    /* access modifiers changed from: private */
    public static final <T> T takeNewGlobalSnapshot(Snapshot previousGlobalSnapshot, Function1<? super SnapshotIdSet, ? extends T> block) {
        Object result = block.invoke(openSnapshots.clear(previousGlobalSnapshot.getId()));
        synchronized (getLock()) {
            int globalId = nextSnapshotId;
            nextSnapshotId = globalId + 1;
            openSnapshots = openSnapshots.clear(previousGlobalSnapshot.getId());
            currentGlobalSnapshot.set(new GlobalSnapshot(globalId, openSnapshots));
            previousGlobalSnapshot.dispose();
            openSnapshots = openSnapshots.set(globalId);
            Unit unit = Unit.INSTANCE;
        }
        return result;
    }

    /* access modifiers changed from: private */
    public static final <T> T advanceGlobalSnapshot(Function1<? super SnapshotIdSet, ? extends T> block) {
        Object previousGlobalSnapshot;
        IdentityArraySet modified$runtime_release;
        Object takeNewGlobalSnapshot;
        List observers;
        Object previousGlobalSnapshot2 = snapshotInitializer;
        Intrinsics.checkNotNull(previousGlobalSnapshot2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.GlobalSnapshot");
        Object previousGlobalSnapshot3 = (GlobalSnapshot) previousGlobalSnapshot2;
        synchronized (getLock()) {
            Object obj = currentGlobalSnapshot.get();
            Intrinsics.checkNotNullExpressionValue(obj, "currentGlobalSnapshot.get()");
            previousGlobalSnapshot = obj;
            modified$runtime_release = ((GlobalSnapshot) previousGlobalSnapshot).getModified$runtime_release();
            if (modified$runtime_release != null) {
                pendingApplyObserverCount.add(1);
            }
            takeNewGlobalSnapshot = takeNewGlobalSnapshot((Snapshot) previousGlobalSnapshot, block);
        }
        Object result = takeNewGlobalSnapshot;
        if (modified$runtime_release != null) {
            IdentityArraySet it = modified$runtime_release;
            try {
                synchronized (getLock()) {
                    observers = CollectionsKt.toMutableList(applyObservers);
                }
                List $this$fastForEach$iv = observers;
                int size = $this$fastForEach$iv.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    ((Function2) $this$fastForEach$iv.get(index$iv)).invoke(it, previousGlobalSnapshot);
                }
                pendingApplyObserverCount.add(-1);
            } catch (Throwable th) {
                pendingApplyObserverCount.add(-1);
                throw th;
            }
        }
        synchronized (getLock()) {
            checkAndOverwriteUnusedRecordsLocked();
            if (modified$runtime_release != null) {
                IdentityArraySet this_$iv = modified$runtime_release;
                Object[] values$iv = this_$iv.getValues();
                int size2 = this_$iv.size();
                for (int i$iv = 0; i$iv < size2; i$iv++) {
                    Object obj2 = values$iv[i$iv];
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    processForUnusedRecordsLocked((StateObject) obj2);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return result;
    }

    /* access modifiers changed from: private */
    public static final void advanceGlobalSnapshot() {
        advanceGlobalSnapshot(SnapshotKt$advanceGlobalSnapshot$3.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final <T extends Snapshot> T takeNewSnapshot(Function1<? super SnapshotIdSet, ? extends T> block) {
        return (Snapshot) advanceGlobalSnapshot(new SnapshotKt$takeNewSnapshot$1(block));
    }

    /* access modifiers changed from: private */
    public static final void validateOpen(Snapshot snapshot) {
        if (!openSnapshots.get(snapshot.getId())) {
            throw new IllegalStateException("Snapshot is not open".toString());
        }
    }

    private static final boolean valid(int currentSnapshot, int candidateSnapshot, SnapshotIdSet invalid) {
        return candidateSnapshot != 0 && candidateSnapshot <= currentSnapshot && !invalid.get(candidateSnapshot);
    }

    private static final boolean valid(StateRecord data, int snapshot, SnapshotIdSet invalid) {
        return valid(snapshot, data.getSnapshotId$runtime_release(), invalid);
    }

    /* access modifiers changed from: private */
    public static final <T extends StateRecord> T readable(T r, int id, SnapshotIdSet invalid) {
        StateRecord stateRecord;
        StateRecord candidate = null;
        for (StateRecord current = r; current != null; current = current.getNext$runtime_release()) {
            if (valid(current, id, invalid)) {
                if (candidate != null && candidate.getSnapshotId$runtime_release() >= current.getSnapshotId$runtime_release()) {
                    stateRecord = candidate;
                } else {
                    stateRecord = current;
                }
                candidate = stateRecord;
            }
        }
        if (candidate != null) {
            return candidate;
        }
        return null;
    }

    public static final <T extends StateRecord> T readable(T $this$readable, StateObject state) {
        T readable;
        Intrinsics.checkNotNullParameter($this$readable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Snapshot snapshot = Snapshot.Companion.getCurrent();
        Function1<Object, Unit> readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(state);
        }
        T readable2 = readable($this$readable, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable2 != null) {
            return readable2;
        }
        synchronized (getLock()) {
            Snapshot syncSnapshot = Snapshot.Companion.getCurrent();
            StateRecord firstStateRecord = state.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable$lambda$9");
            readable = readable(firstStateRecord, syncSnapshot.getId(), syncSnapshot.getInvalid$runtime_release());
            if (readable == null) {
                readError();
                throw new KotlinNothingValueException();
            }
        }
        return readable;
    }

    public static final <T extends StateRecord> T readable(T $this$readable, StateObject state, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter($this$readable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Function1<Object, Unit> readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(state);
        }
        T readable = readable($this$readable, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable != null) {
            return readable;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    /* access modifiers changed from: private */
    public static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied".toString());
    }

    private static final StateRecord usedLocked(StateObject state) {
        StateRecord validRecord = null;
        int reuseLimit = pinningTable.lowestOrDefault(nextSnapshotId) - 1;
        SnapshotIdSet invalid = SnapshotIdSet.Companion.getEMPTY();
        for (StateRecord current = state.getFirstStateRecord(); current != null; current = current.getNext$runtime_release()) {
            if (current.getSnapshotId$runtime_release() == 0) {
                return current;
            }
            if (valid(current, reuseLimit, invalid)) {
                if (validRecord != null) {
                    return current.getSnapshotId$runtime_release() < validRecord.getSnapshotId$runtime_release() ? current : validRecord;
                }
                validRecord = current;
            }
        }
        return null;
    }

    private static final boolean overwriteUnusedRecordsLocked(StateObject state) {
        StateRecord recordToOverwrite;
        StateRecord overwriteRecord = null;
        StateRecord validRecord = null;
        int reuseLimit = pinningTable.lowestOrDefault(nextSnapshotId);
        int retainedRecords = 0;
        for (StateRecord current = state.getFirstStateRecord(); current != null; current = current.getNext$runtime_release()) {
            int currentId = current.getSnapshotId$runtime_release();
            if (currentId != 0) {
                if (currentId >= reuseLimit) {
                    retainedRecords++;
                } else if (validRecord == null) {
                    validRecord = current;
                    retainedRecords++;
                } else {
                    if (current.getSnapshotId$runtime_release() < validRecord.getSnapshotId$runtime_release()) {
                        recordToOverwrite = current;
                    } else {
                        recordToOverwrite = validRecord;
                        validRecord = current;
                    }
                    if (overwriteRecord == null) {
                        StateRecord $this$findYoungestOr$iv = state.getFirstStateRecord();
                        StateRecord current$iv = $this$findYoungestOr$iv;
                        StateRecord youngest$iv = $this$findYoungestOr$iv;
                        while (true) {
                            if (current$iv == null) {
                                current$iv = youngest$iv;
                                break;
                            }
                            if ((current$iv.getSnapshotId$runtime_release() >= reuseLimit ? 1 : null) != null) {
                                break;
                            }
                            if (youngest$iv.getSnapshotId$runtime_release() < current$iv.getSnapshotId$runtime_release()) {
                                youngest$iv = current$iv;
                            }
                            current$iv = current$iv.getNext$runtime_release();
                        }
                        overwriteRecord = current$iv;
                    }
                    recordToOverwrite.setSnapshotId$runtime_release(0);
                    recordToOverwrite.assign(overwriteRecord);
                }
            }
        }
        if (retainedRecords > 1) {
            return true;
        }
        return false;
    }

    private static final StateRecord findYoungestOr(StateRecord $this$findYoungestOr, Function1<? super StateRecord, Boolean> predicate) {
        StateRecord youngest = $this$findYoungestOr;
        for (StateRecord current = $this$findYoungestOr; current != null; current = current.getNext$runtime_release()) {
            if (predicate.invoke(current).booleanValue()) {
                return current;
            }
            if (youngest.getSnapshotId$runtime_release() < current.getSnapshotId$runtime_release()) {
                youngest = current;
            }
        }
        return youngest;
    }

    /* access modifiers changed from: private */
    public static final void checkAndOverwriteUnusedRecordsLocked() {
        SnapshotWeakSet this_$iv = extraStateObjects;
        int size$iv = this_$iv.getSize$runtime_release();
        int currentUsed$iv = 0;
        int i$iv = 0;
        while (true) {
            Object value$iv = null;
            if (i$iv >= size$iv) {
                break;
            }
            WeakReference entry$iv = this_$iv.getValues$runtime_release()[i$iv];
            if (entry$iv != null) {
                value$iv = entry$iv.get();
            }
            if (value$iv != null && !(!overwriteUnusedRecordsLocked((StateObject) value$iv))) {
                if (currentUsed$iv != i$iv) {
                    this_$iv.getValues$runtime_release()[currentUsed$iv] = entry$iv;
                    this_$iv.getHashes$runtime_release()[currentUsed$iv] = this_$iv.getHashes$runtime_release()[i$iv];
                }
                currentUsed$iv++;
            }
            i$iv++;
        }
        for (int i$iv2 = currentUsed$iv; i$iv2 < size$iv; i$iv2++) {
            this_$iv.getValues$runtime_release()[i$iv2] = null;
            this_$iv.getHashes$runtime_release()[i$iv2] = 0;
        }
        if (currentUsed$iv != size$iv) {
            this_$iv.setSize$runtime_release(currentUsed$iv);
        }
    }

    /* access modifiers changed from: private */
    public static final void processForUnusedRecordsLocked(StateObject state) {
        if (overwriteUnusedRecordsLocked(state)) {
            extraStateObjects.add(state);
        }
    }

    public static final <T extends StateRecord> T writableRecord(T $this$writableRecord, StateObject state, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter($this$writableRecord, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        if (snapshot.getReadOnly()) {
            snapshot.recordModified$runtime_release(state);
        }
        StateRecord readData = readable($this$writableRecord, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readData == null) {
            readError();
            throw new KotlinNothingValueException();
        } else if (readData.getSnapshotId$runtime_release() == snapshot.getId()) {
            return readData;
        } else {
            StateRecord newData = newWritableRecord(readData, state, snapshot);
            snapshot.recordModified$runtime_release(state);
            return newData;
        }
    }

    public static final <T extends StateRecord> T overwritableRecord(T $this$overwritableRecord, StateObject state, Snapshot snapshot, T candidate) {
        StateRecord newOverwritableRecordLocked;
        Intrinsics.checkNotNullParameter($this$overwritableRecord, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Intrinsics.checkNotNullParameter(candidate, "candidate");
        if (snapshot.getReadOnly()) {
            snapshot.recordModified$runtime_release(state);
        }
        int id = snapshot.getId();
        if (candidate.getSnapshotId$runtime_release() == id) {
            return candidate;
        }
        synchronized (getLock()) {
            newOverwritableRecordLocked = newOverwritableRecordLocked($this$overwritableRecord, state);
        }
        StateRecord newData = newOverwritableRecordLocked;
        newData.setSnapshotId$runtime_release(id);
        snapshot.recordModified$runtime_release(state);
        return newData;
    }

    public static final <T extends StateRecord> T newWritableRecord(T $this$newWritableRecord, StateObject state, Snapshot snapshot) {
        T newWritableRecordLocked;
        Intrinsics.checkNotNullParameter($this$newWritableRecord, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        synchronized (getLock()) {
            newWritableRecordLocked = newWritableRecordLocked($this$newWritableRecord, state, snapshot);
        }
        return newWritableRecordLocked;
    }

    private static final <T extends StateRecord> T newWritableRecordLocked(T $this$newWritableRecordLocked, StateObject state, Snapshot snapshot) {
        StateRecord newData = newOverwritableRecordLocked($this$newWritableRecordLocked, state);
        newData.assign($this$newWritableRecordLocked);
        newData.setSnapshotId$runtime_release(snapshot.getId());
        return newData;
    }

    public static final <T extends StateRecord> T newOverwritableRecordLocked(T $this$newOverwritableRecordLocked, StateObject state) {
        Intrinsics.checkNotNullParameter($this$newOverwritableRecordLocked, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        StateRecord $this$newOverwritableRecordLocked_u24lambda_u2414 = usedLocked(state);
        if ($this$newOverwritableRecordLocked_u24lambda_u2414 != null) {
            $this$newOverwritableRecordLocked_u24lambda_u2414.setSnapshotId$runtime_release(Integer.MAX_VALUE);
            return $this$newOverwritableRecordLocked_u24lambda_u2414;
        }
        StateRecord create = $this$newOverwritableRecordLocked.create();
        StateRecord $this$newOverwritableRecordLocked_u24lambda_u2415 = create;
        $this$newOverwritableRecordLocked_u24lambda_u2415.setSnapshotId$runtime_release(Integer.MAX_VALUE);
        $this$newOverwritableRecordLocked_u24lambda_u2415.setNext$runtime_release(state.getFirstStateRecord());
        Intrinsics.checkNotNull($this$newOverwritableRecordLocked_u24lambda_u2415, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked$lambda$15");
        state.prependStateRecord($this$newOverwritableRecordLocked_u24lambda_u2415);
        Intrinsics.checkNotNull(create, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return create;
    }

    public static final void notifyWrite(Snapshot snapshot, StateObject state) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Intrinsics.checkNotNullParameter(state, "state");
        snapshot.setWriteCount$runtime_release(snapshot.getWriteCount$runtime_release() + 1);
        Function1<Object, Unit> writeObserver$runtime_release = snapshot.getWriteObserver$runtime_release();
        if (writeObserver$runtime_release != null) {
            writeObserver$runtime_release.invoke(state);
        }
    }

    public static final <T extends StateRecord, R> R writable(T $this$writable, StateObject state, Snapshot snapshot, Function1<? super T, ? extends R> block) {
        R invoke;
        Intrinsics.checkNotNullParameter($this$writable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (getLock()) {
            try {
                invoke = block.invoke(writableRecord($this$writable, state, snapshot));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        R r = invoke;
        notifyWrite(snapshot, state);
        return invoke;
    }

    public static final <T extends StateRecord, R> R writable(T $this$writable, StateObject state, Function1<? super T, ? extends R> block) {
        Snapshot current;
        R invoke;
        Intrinsics.checkNotNullParameter($this$writable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(block, "block");
        Object snapshot = getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                invoke = block.invoke(writableRecord($this$writable, state, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        R r = invoke;
        notifyWrite(current, state);
        return invoke;
    }

    public static final <T extends StateRecord, R> R overwritable(T $this$overwritable, StateObject state, T candidate, Function1<? super T, ? extends R> block) {
        Snapshot current;
        R invoke;
        Intrinsics.checkNotNullParameter($this$overwritable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(candidate, "candidate");
        Intrinsics.checkNotNullParameter(block, "block");
        Object snapshot = getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                invoke = block.invoke(overwritableRecord($this$overwritable, state, current, candidate));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        R r = invoke;
        notifyWrite(current, state);
        return invoke;
    }

    /* access modifiers changed from: private */
    public static final Map<StateRecord, StateRecord> optimisticMerges(MutableSnapshot currentSnapshot, MutableSnapshot applyingSnapshot, SnapshotIdSet invalidSnapshots) {
        IdentityArraySet modified;
        IdentityArraySet modified2;
        StateRecord previous;
        IdentityArraySet modified3 = applyingSnapshot.getModified$runtime_release();
        int id = currentSnapshot.getId();
        IdentityArraySet identityArraySet = null;
        if (modified3 == null) {
            return null;
        }
        SnapshotIdSet start = applyingSnapshot.getInvalid$runtime_release().set(applyingSnapshot.getId()).or(applyingSnapshot.getPreviousIds$runtime_release());
        Object result = null;
        IdentityArraySet this_$iv = modified3;
        Object[] values$iv = this_$iv.getValues();
        int i$iv = 0;
        int size = this_$iv.size();
        while (i$iv < size) {
            Object obj = values$iv[i$iv];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            StateObject state = (StateObject) obj;
            StateRecord first = state.getFirstStateRecord();
            StateRecord current = readable(first, id, invalidSnapshots);
            if (current == null || (previous = readable(first, id, start)) == null) {
                modified = modified3;
                modified2 = identityArraySet;
            } else if (!Intrinsics.areEqual((Object) current, (Object) previous)) {
                modified = modified3;
                StateRecord applied = readable(first, applyingSnapshot.getId(), applyingSnapshot.getInvalid$runtime_release());
                if (applied != null) {
                    StateRecord merged = state.mergeRecords(previous, current, applied);
                    if (merged != null) {
                        Map map = (Map) result;
                        if (map == null) {
                            Object it = new HashMap();
                            result = it;
                            map = (Map) it;
                        }
                        Map map2 = map;
                        StateRecord stateRecord = applied;
                        map2.put(current, merged);
                        modified2 = null;
                    } else {
                        return null;
                    }
                } else {
                    readError();
                    throw new KotlinNothingValueException();
                }
            } else {
                modified = modified3;
                modified2 = identityArraySet;
            }
            i$iv++;
            identityArraySet = modified2;
            modified3 = modified;
        }
        return (Map) result;
    }

    /* access modifiers changed from: private */
    public static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot".toString());
    }

    public static final <T extends StateRecord> T current(T r, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(r, "r");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        T readable = readable(r, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable != null) {
            return readable;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static final <T extends StateRecord> T current(T r) {
        T readable;
        Intrinsics.checkNotNullParameter(r, "r");
        Snapshot snapshot = Snapshot.Companion.getCurrent();
        T readable2 = readable(r, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable2 != null) {
            return readable2;
        }
        synchronized (getLock()) {
            Snapshot syncSnapshot = Snapshot.Companion.getCurrent();
            readable = readable(r, syncSnapshot.getId(), syncSnapshot.getInvalid$runtime_release());
        }
        if (readable != null) {
            return readable;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static final <T extends StateRecord, R> R withCurrent(T $this$withCurrent, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter($this$withCurrent, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return block.invoke(current($this$withCurrent));
    }

    public static final SnapshotIdSet addRange(SnapshotIdSet $this$addRange, int from, int until) {
        Intrinsics.checkNotNullParameter($this$addRange, "<this>");
        SnapshotIdSet result = $this$addRange;
        for (int invalidId = from; invalidId < until; invalidId++) {
            result = result.set(invalidId);
        }
        return result;
    }
}

package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001NB\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001a\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J)\u0010%\u001a\u00020\u001b2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\bJ\u0016\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001dJ\u0016\u0010*\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010+\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010,J\u0015\u0010-\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u001bH\u0016J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0002J\u0015\u00102\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0016J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000042\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J.\u00105\u001a\u0002H6\"\u0004\b\u0001\u001062\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u0002H60'H\b¢\u0006\u0002\u00107J\"\u00108\u001a\u00020\u001b2\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u001b0'H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u000bH\u0016J\u0015\u0010;\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010<\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0015\u0010=\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010,J\u0016\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010J\u0016\u0010A\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J+\u0010B\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0010H\u0000¢\u0006\u0002\bEJ\u001e\u0010F\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010GJ\u001e\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010H\u0016J\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006J)\u0010J\u001a\u00020\u001e2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\bJ3\u0010K\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'¢\u0006\u0002\bLH\b¢\u0006\u0002\u00107J3\u0010M\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'¢\u0006\u0002\bLH\b¢\u0006\u0002\u00107R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068AX\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148@X\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012¨\u0006O"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList;", "T", "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/List;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "size", "getSize", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "conditionalUpdate", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "mutate", "R", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "mutateBoolean", "prependStateRecord", "value", "remove", "removeAll", "removeAt", "removeRange", "fromIndex", "toIndex", "retainAll", "retainAllInRange", "start", "end", "retainAllInRange$runtime_release", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "toList", "update", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateListStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateList.kt */
public final class SnapshotStateList<T> implements List<T>, StateObject, KMutableList {
    public static final int $stable = 0;
    private StateRecord firstStateRecord = new StateListStateRecord(ExtensionsKt.persistentListOf());

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    public final /* bridge */ T remove(int index) {
        return removeAt(index);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        value.setNext$runtime_release(getFirstStateRecord());
        this.firstStateRecord = (StateListStateRecord) value;
    }

    public final List<T> toList() {
        return getReadable$runtime_release().getList$runtime_release();
    }

    public final int getModification$runtime_release() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2)).getModification$runtime_release();
    }

    public final StateListStateRecord<T> getReadable$runtime_release() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) firstStateRecord2, this);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "list", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "getList$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "setList$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnapshotStateList.kt */
    public static final class StateListStateRecord<T> extends StateRecord {
        private PersistentList<? extends T> list;
        private int modification;

        public final PersistentList<T> getList$runtime_release() {
            return this.list;
        }

        public final void setList$runtime_release(PersistentList<? extends T> persistentList) {
            Intrinsics.checkNotNullParameter(persistentList, "<set-?>");
            this.list = persistentList;
        }

        public StateListStateRecord(PersistentList<? extends T> list2) {
            Intrinsics.checkNotNullParameter(list2, "list");
            this.list = list2;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setModification$runtime_release(int i) {
            this.modification = i;
        }

        public void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            synchronized (SnapshotStateListKt.sync) {
                this.list = ((StateListStateRecord) value).list;
                this.modification = ((StateListStateRecord) value).modification;
                Unit unit = Unit.INSTANCE;
            }
        }

        public StateRecord create() {
            return new StateListStateRecord(this.list);
        }
    }

    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    public boolean contains(Object element) {
        return getReadable$runtime_release().getList$runtime_release().contains(element);
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return getReadable$runtime_release().getList$runtime_release().containsAll(elements);
    }

    public T get(int index) {
        return getReadable$runtime_release().getList$runtime_release().get(index);
    }

    public int indexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(element);
    }

    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    public Iterator<T> iterator() {
        return listIterator();
    }

    public int lastIndexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(element);
    }

    public ListIterator<T> listIterator() {
        return new StateListIterator<>(this, 0);
    }

    public ListIterator<T> listIterator(int index) {
        return new StateListIterator<>(this, index);
    }

    public List<T> subList(int fromIndex, int toIndex) {
        boolean z = true;
        if (!(fromIndex >= 0 && fromIndex <= toIndex) || toIndex > size()) {
            z = false;
        }
        if (z) {
            return new SubList<>(this, fromIndex, toIndex);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* Debug info: failed to restart local var, previous not found, register: 25 */
    /* JADX INFO: finally extract failed */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public boolean add(T r26) {
        /*
            r25 = this;
            r1 = r25
            r2 = 0
            r3 = r1
            androidx.compose.runtime.snapshots.SnapshotStateList r3 = (androidx.compose.runtime.snapshots.SnapshotStateList) r3
            r4 = 0
            r5 = 0
        L_0x0008:
            r6 = 0
            r7 = 0
            java.lang.Object r8 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r9 = 0
            monitor-enter(r8)
            r0 = 0
            r10 = r3
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = r10.getFirstStateRecord()     // Catch:{ all -> 0x00e2 }
            java.lang.String r13 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r13)     // Catch:{ all -> 0x00e2 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r12     // Catch:{ all -> 0x00e2 }
            androidx.compose.runtime.snapshots.StateRecord r12 = (androidx.compose.runtime.snapshots.StateRecord) r12     // Catch:{ all -> 0x00e2 }
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r14 = androidx.compose.runtime.snapshots.SnapshotKt.current(r12)     // Catch:{ all -> 0x00e2 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r14 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r14     // Catch:{ all -> 0x00e2 }
            r15 = 0
            r10 = r14
            int r11 = r10.getModification$runtime_release()     // Catch:{ all -> 0x00e2 }
            r7 = r11
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r11 = r10.getList$runtime_release()     // Catch:{ all -> 0x00e2 }
            r6 = r11
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e2 }
            monitor-exit(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r0 = r6
            r8 = 0
            r10 = r26
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r0.add(r10)
            r8 = r0
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r6)
            if (r0 == 0) goto L_0x0053
            r0 = 0
            r24 = r1
            goto L_0x00cc
        L_0x0053:
            r9 = r3
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r9.getFirstStateRecord()
            java.lang.String r12 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r12)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0
            r12 = r0
            androidx.compose.runtime.snapshots.StateRecord r12 = (androidx.compose.runtime.snapshots.StateRecord) r12
            r13 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r14 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            r15 = 0
            java.lang.Object r16 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r17 = 0
            monitor-enter(r16)
            r18 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00dd }
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.getCurrent()     // Catch:{ all -> 0x00dd }
            r14 = r0
            r0 = r9
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00dd }
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r12, r0, r14)     // Catch:{ all -> 0x00dd }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00dd }
            r19 = r0
            r20 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync     // Catch:{ all -> 0x00dd }
            r21 = r0
            r22 = 0
            monitor-enter(r21)     // Catch:{ all -> 0x00dd }
            r0 = 0
            r23 = r0
            int r0 = r19.getModification$runtime_release()     // Catch:{ all -> 0x00d4 }
            if (r0 != r7) goto L_0x00af
            r24 = r1
            r1 = r19
            r1.setList$runtime_release(r8)     // Catch:{ all -> 0x00ad }
            int r0 = r1.getModification$runtime_release()     // Catch:{ all -> 0x00ad }
            r19 = 1
            int r0 = r0 + 1
            r1.setModification$runtime_release(r0)     // Catch:{ all -> 0x00ad }
            goto L_0x00b5
        L_0x00ad:
            r0 = move-exception
            goto L_0x00d9
        L_0x00af:
            r24 = r1
            r1 = r19
            r19 = 0
        L_0x00b5:
            monitor-exit(r21)     // Catch:{ all -> 0x00db }
            monitor-exit(r16)
            r0 = r19
            r1 = 0
            r15 = r9
            androidx.compose.runtime.snapshots.StateObject r15 = (androidx.compose.runtime.snapshots.StateObject) r15
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r14, r15)
            if (r19 == 0) goto L_0x00d0
            r0 = 1
        L_0x00cc:
            return r0
        L_0x00d0:
            r1 = r24
            goto L_0x0008
        L_0x00d4:
            r0 = move-exception
            r24 = r1
            r1 = r19
        L_0x00d9:
            monitor-exit(r21)     // Catch:{ all -> 0x00db }
            throw r0     // Catch:{ all -> 0x00db }
        L_0x00db:
            r0 = move-exception
            goto L_0x00e0
        L_0x00dd:
            r0 = move-exception
            r24 = r1
        L_0x00e0:
            monitor-exit(r16)
            throw r0
        L_0x00e2:
            r0 = move-exception
            r10 = r26
            r24 = r1
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.add(java.lang.Object):boolean");
    }

    /* Debug info: failed to restart local var, previous not found, register: 28 */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void add(int r29, T r30) {
        /*
            r28 = this;
            r1 = r28
            r2 = 0
            r3 = r1
            r4 = 0
            r5 = r3
            androidx.compose.runtime.snapshots.SnapshotStateList r5 = (androidx.compose.runtime.snapshots.SnapshotStateList) r5
            r6 = 0
            r7 = 0
        L_0x000a:
            r8 = 0
            r9 = 0
            java.lang.Object r10 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r11 = 0
            monitor-enter(r10)
            r0 = 0
            r12 = r5
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r14 = r12.getFirstStateRecord()     // Catch:{ all -> 0x0108 }
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r15)     // Catch:{ all -> 0x0108 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r14 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r14     // Catch:{ all -> 0x0108 }
            androidx.compose.runtime.snapshots.StateRecord r14 = (androidx.compose.runtime.snapshots.StateRecord) r14     // Catch:{ all -> 0x0108 }
            r15 = 0
            androidx.compose.runtime.snapshots.StateRecord r16 = androidx.compose.runtime.snapshots.SnapshotKt.current(r14)     // Catch:{ all -> 0x0108 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r16 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r16     // Catch:{ all -> 0x0108 }
            r17 = 0
            r12 = r16
            int r13 = r12.getModification$runtime_release()     // Catch:{ all -> 0x0108 }
            r9 = r13
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r13 = r12.getList$runtime_release()     // Catch:{ all -> 0x0108 }
            r8 = r13
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0108 }
            monitor-exit(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r0 = r8
            r10 = 0
            r12 = r29
            r13 = r30
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r0.add(r12, r13)
            r10 = r0
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r8)
            if (r0 == 0) goto L_0x005b
            r0 = 0
            r22 = r1
            r27 = r2
            goto L_0x00dd
        L_0x005b:
            r11 = r5
            r14 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r11.getFirstStateRecord()
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r15)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0
            r15 = r0
            androidx.compose.runtime.snapshots.StateRecord r15 = (androidx.compose.runtime.snapshots.StateRecord) r15
            r16 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r17 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            r18 = 0
            java.lang.Object r19 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r20 = 0
            monitor-enter(r19)
            r21 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0101 }
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.getCurrent()     // Catch:{ all -> 0x0101 }
            r17 = r0
            r0 = r11
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00f9 }
            r22 = r1
            r1 = r17
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r15, r0, r1)     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00f3 }
            r17 = r0
            r23 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync     // Catch:{ all -> 0x00f3 }
            r24 = r0
            r25 = 0
            monitor-enter(r24)     // Catch:{ all -> 0x00f3 }
            r0 = 0
            r26 = r0
            int r0 = r17.getModification$runtime_release()     // Catch:{ all -> 0x00e8 }
            if (r0 != r9) goto L_0x00be
            r27 = r2
            r2 = r17
            r2.setList$runtime_release(r10)     // Catch:{ all -> 0x00bc }
            int r0 = r2.getModification$runtime_release()     // Catch:{ all -> 0x00bc }
            r17 = 1
            int r0 = r0 + 1
            r2.setModification$runtime_release(r0)     // Catch:{ all -> 0x00bc }
            goto L_0x00c4
        L_0x00bc:
            r0 = move-exception
            goto L_0x00ed
        L_0x00be:
            r27 = r2
            r2 = r17
            r17 = 0
        L_0x00c4:
            monitor-exit(r24)     // Catch:{ all -> 0x00ef }
            monitor-exit(r19)
            r0 = r17
            r2 = 0
            r18 = r0
            r0 = r11
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r0)
            if (r17 == 0) goto L_0x00e2
            r0 = 1
        L_0x00dd:
            return
        L_0x00e2:
            r1 = r22
            r2 = r27
            goto L_0x000a
        L_0x00e8:
            r0 = move-exception
            r27 = r2
            r2 = r17
        L_0x00ed:
            monitor-exit(r24)     // Catch:{ all -> 0x00ef }
            throw r0     // Catch:{ all -> 0x00ef }
        L_0x00ef:
            r0 = move-exception
            r17 = r1
            goto L_0x0106
        L_0x00f3:
            r0 = move-exception
            r27 = r2
            r17 = r1
            goto L_0x0106
        L_0x00f9:
            r0 = move-exception
            r22 = r1
            r27 = r2
            r1 = r17
            goto L_0x0106
        L_0x0101:
            r0 = move-exception
            r22 = r1
            r27 = r2
        L_0x0106:
            monitor-exit(r19)
            throw r0
        L_0x0108:
            r0 = move-exception
            r12 = r29
            r13 = r30
            r22 = r1
            r27 = r2
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.add(int, java.lang.Object):void");
    }

    public boolean addAll(int index, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return mutateBoolean(new SnapshotStateList$addAll$1(index, elements));
    }

    /* Debug info: failed to restart local var, previous not found, register: 24 */
    public boolean addAll(Collection<? extends T> elements) {
        int currentModification$iv;
        PersistentList it;
        Snapshot current;
        boolean z;
        Collection<? extends T> collection = elements;
        Intrinsics.checkNotNullParameter(collection, "elements");
        SnapshotStateList $this$conditionalUpdate_u24lambda_u2423$iv = this;
        while (true) {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = $this$conditionalUpdate_u24lambda_u2423$iv.getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord current$iv = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                currentModification$iv = current$iv.getModification$runtime_release();
                it = current$iv.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(it);
            PersistentList newList$iv = it.addAll(collection);
            if (Intrinsics.areEqual((Object) newList$iv, (Object) it)) {
                return false;
            }
            SnapshotStateList this_$iv$iv = $this$conditionalUpdate_u24lambda_u2423$iv;
            StateRecord firstStateRecord3 = this_$iv$iv.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord $this$writable$iv$iv$iv = (StateListStateRecord) firstStateRecord3;
            Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv, this_$iv$iv, current);
                synchronized (SnapshotStateListKt.sync) {
                    try {
                        if ($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.getModification$runtime_release() == currentModification$iv) {
                            StateListStateRecord $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv2 = $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv;
                            try {
                                $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv2.setList$runtime_release(newList$iv);
                                z = true;
                                $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv2.setModification$runtime_release($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv2.getModification$runtime_release() + 1);
                            } catch (Throwable th) {
                                th = th;
                            }
                        } else {
                            z = false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        StateListStateRecord stateListStateRecord = $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv;
                        throw th;
                    }
                }
            }
            boolean z2 = z;
            SnapshotKt.notifyWrite(current, this_$iv$iv);
            if (z) {
                return true;
            }
            collection = elements;
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 16 */
    public void clear() {
        Snapshot current;
        int modification$runtime_release;
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateRecord $this$writable$iv$iv = (StateListStateRecord) firstStateRecord2;
        Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            current = Snapshot.Companion.getCurrent();
            StateListStateRecord $this$clear_u24lambda_u245 = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv, this, current);
            synchronized (SnapshotStateListKt.sync) {
                $this$clear_u24lambda_u245.setList$runtime_release(ExtensionsKt.persistentListOf());
                modification$runtime_release = $this$clear_u24lambda_u245.getModification$runtime_release();
                $this$clear_u24lambda_u245.setModification$runtime_release(modification$runtime_release + 1);
            }
        }
        int i = modification$runtime_release;
        SnapshotKt.notifyWrite(current, this);
    }

    /* Debug info: failed to restart local var, previous not found, register: 25 */
    /* JADX INFO: finally extract failed */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public boolean remove(java.lang.Object r26) {
        /*
            r25 = this;
            r1 = r25
            r2 = 0
            r3 = r1
            androidx.compose.runtime.snapshots.SnapshotStateList r3 = (androidx.compose.runtime.snapshots.SnapshotStateList) r3
            r4 = 0
            r5 = 0
        L_0x0008:
            r6 = 0
            r7 = 0
            java.lang.Object r8 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r9 = 0
            monitor-enter(r8)
            r0 = 0
            r10 = r3
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = r10.getFirstStateRecord()     // Catch:{ all -> 0x00e2 }
            java.lang.String r13 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r13)     // Catch:{ all -> 0x00e2 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r12     // Catch:{ all -> 0x00e2 }
            androidx.compose.runtime.snapshots.StateRecord r12 = (androidx.compose.runtime.snapshots.StateRecord) r12     // Catch:{ all -> 0x00e2 }
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r14 = androidx.compose.runtime.snapshots.SnapshotKt.current(r12)     // Catch:{ all -> 0x00e2 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r14 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r14     // Catch:{ all -> 0x00e2 }
            r15 = 0
            r10 = r14
            int r11 = r10.getModification$runtime_release()     // Catch:{ all -> 0x00e2 }
            r7 = r11
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r11 = r10.getList$runtime_release()     // Catch:{ all -> 0x00e2 }
            r6 = r11
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e2 }
            monitor-exit(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r0 = r6
            r8 = 0
            r10 = r26
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r0.remove(r10)
            r8 = r0
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r6)
            if (r0 == 0) goto L_0x0053
            r0 = 0
            r24 = r1
            goto L_0x00cc
        L_0x0053:
            r9 = r3
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r9.getFirstStateRecord()
            java.lang.String r12 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r12)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0
            r12 = r0
            androidx.compose.runtime.snapshots.StateRecord r12 = (androidx.compose.runtime.snapshots.StateRecord) r12
            r13 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r14 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            r15 = 0
            java.lang.Object r16 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r17 = 0
            monitor-enter(r16)
            r18 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00dd }
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.getCurrent()     // Catch:{ all -> 0x00dd }
            r14 = r0
            r0 = r9
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00dd }
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r12, r0, r14)     // Catch:{ all -> 0x00dd }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00dd }
            r19 = r0
            r20 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync     // Catch:{ all -> 0x00dd }
            r21 = r0
            r22 = 0
            monitor-enter(r21)     // Catch:{ all -> 0x00dd }
            r0 = 0
            r23 = r0
            int r0 = r19.getModification$runtime_release()     // Catch:{ all -> 0x00d4 }
            if (r0 != r7) goto L_0x00af
            r24 = r1
            r1 = r19
            r1.setList$runtime_release(r8)     // Catch:{ all -> 0x00ad }
            int r0 = r1.getModification$runtime_release()     // Catch:{ all -> 0x00ad }
            r19 = 1
            int r0 = r0 + 1
            r1.setModification$runtime_release(r0)     // Catch:{ all -> 0x00ad }
            goto L_0x00b5
        L_0x00ad:
            r0 = move-exception
            goto L_0x00d9
        L_0x00af:
            r24 = r1
            r1 = r19
            r19 = 0
        L_0x00b5:
            monitor-exit(r21)     // Catch:{ all -> 0x00db }
            monitor-exit(r16)
            r0 = r19
            r1 = 0
            r15 = r9
            androidx.compose.runtime.snapshots.StateObject r15 = (androidx.compose.runtime.snapshots.StateObject) r15
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r14, r15)
            if (r19 == 0) goto L_0x00d0
            r0 = 1
        L_0x00cc:
            return r0
        L_0x00d0:
            r1 = r24
            goto L_0x0008
        L_0x00d4:
            r0 = move-exception
            r24 = r1
            r1 = r19
        L_0x00d9:
            monitor-exit(r21)     // Catch:{ all -> 0x00db }
            throw r0     // Catch:{ all -> 0x00db }
        L_0x00db:
            r0 = move-exception
            goto L_0x00e0
        L_0x00dd:
            r0 = move-exception
            r24 = r1
        L_0x00e0:
            monitor-exit(r16)
            throw r0
        L_0x00e2:
            r0 = move-exception
            r10 = r26
            r24 = r1
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.remove(java.lang.Object):boolean");
    }

    /* Debug info: failed to restart local var, previous not found, register: 24 */
    public boolean removeAll(Collection<? extends Object> elements) {
        int currentModification$iv;
        PersistentList it;
        Snapshot current;
        boolean z;
        Collection<? extends Object> collection = elements;
        Intrinsics.checkNotNullParameter(collection, "elements");
        SnapshotStateList $this$conditionalUpdate_u24lambda_u2423$iv = this;
        while (true) {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = $this$conditionalUpdate_u24lambda_u2423$iv.getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord current$iv = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                currentModification$iv = current$iv.getModification$runtime_release();
                it = current$iv.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(it);
            PersistentList newList$iv = it.removeAll(collection);
            if (Intrinsics.areEqual((Object) newList$iv, (Object) it)) {
                return false;
            }
            SnapshotStateList this_$iv$iv = $this$conditionalUpdate_u24lambda_u2423$iv;
            StateRecord firstStateRecord3 = this_$iv$iv.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord $this$writable$iv$iv$iv = (StateListStateRecord) firstStateRecord3;
            Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv, this_$iv$iv, current);
                synchronized (SnapshotStateListKt.sync) {
                    try {
                        if ($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.getModification$runtime_release() == currentModification$iv) {
                            StateListStateRecord $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv2 = $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv;
                            try {
                                $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv2.setList$runtime_release(newList$iv);
                                z = true;
                                $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv2.setModification$runtime_release($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv2.getModification$runtime_release() + 1);
                            } catch (Throwable th) {
                                th = th;
                            }
                        } else {
                            z = false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        StateListStateRecord stateListStateRecord = $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv;
                        throw th;
                    }
                }
            }
            boolean z2 = z;
            SnapshotKt.notifyWrite(current, this_$iv$iv);
            if (z) {
                return true;
            }
            collection = elements;
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 30 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004b, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        r1 = r10.removeAt(r31);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005b, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10) == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
        r23 = r3;
        r24 = r4;
        r28 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0066, code lost:
        r2 = r7;
        r13 = r2.getFirstStateRecord();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        r13 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r13;
        r16 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer();
        r20 = androidx.compose.runtime.snapshots.SnapshotKt.getLock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0085, code lost:
        monitor-enter(r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x008e, code lost:
        r16 = androidx.compose.runtime.snapshots.Snapshot.Companion.getCurrent();
        r23 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0095, code lost:
        r24 = r4;
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r3 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r13, r2, r4);
        r25 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a7, code lost:
        monitor-enter(r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a8, code lost:
        r28 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b0, code lost:
        if (r3.getModification$runtime_release() != r11) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r3.setList$runtime_release(r1);
        r29 = true;
        r3.setModification$runtime_release(r3.getModification$runtime_release() + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c1, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c2, code lost:
        r27 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c5, code lost:
        r29 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        monitor-exit(r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cb, code lost:
        monitor-exit(r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        r3 = r29;
        r27 = r1;
        androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00dc, code lost:
        if (r29 == false) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f2, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f3, code lost:
        r27 = r1;
        r16 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f9, code lost:
        r27 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        monitor-exit(r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fc, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fd, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00fe, code lost:
        r16 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0101, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0102, code lost:
        r27 = r1;
        r28 = r5;
        r16 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0109, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x010a, code lost:
        r27 = r1;
        r24 = r4;
        r28 = r5;
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0113, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0114, code lost:
        r27 = r1;
        r23 = r3;
        r24 = r4;
        r28 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x011c, code lost:
        monitor-exit(r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x011d, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T removeAt(int r31) {
        /*
            r30 = this;
            java.lang.Object r0 = r30.get(r31)
            r1 = r0
            r2 = 0
            r3 = r30
            r4 = 0
            r5 = r3
            r6 = 0
            r7 = r5
            androidx.compose.runtime.snapshots.SnapshotStateList r7 = (androidx.compose.runtime.snapshots.SnapshotStateList) r7
            r8 = 0
            r9 = 0
        L_0x0010:
            r10 = 0
            r11 = 0
            java.lang.Object r12 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r13 = 0
            monitor-enter(r12)
            r14 = 0
            r15 = r7
            r16 = 0
            r17 = r1
            androidx.compose.runtime.snapshots.StateRecord r1 = r15.getFirstStateRecord()     // Catch:{ all -> 0x0128 }
            r18 = r2
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch:{ all -> 0x011e }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch:{ all -> 0x011e }
            androidx.compose.runtime.snapshots.StateRecord r1 = (androidx.compose.runtime.snapshots.StateRecord) r1     // Catch:{ all -> 0x011e }
            r2 = 0
            androidx.compose.runtime.snapshots.StateRecord r19 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch:{ all -> 0x011e }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r19 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r19     // Catch:{ all -> 0x011e }
            r20 = 0
            r1 = r19
            int r2 = r1.getModification$runtime_release()     // Catch:{ all -> 0x011e }
            r11 = r2
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r2 = r1.getList$runtime_release()     // Catch:{ all -> 0x011e }
            r10 = r2
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x011e }
            monitor-exit(r12)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r1 = r10
            r2 = 0
            r14 = r31
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.removeAt(r14)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            if (r2 == 0) goto L_0x0066
            r2 = 0
            r23 = r3
            r24 = r4
            r28 = r5
            goto L_0x00e0
        L_0x0066:
            r2 = r7
            r12 = 0
            androidx.compose.runtime.snapshots.StateRecord r13 = r2.getFirstStateRecord()
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r15)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r13 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r13
            androidx.compose.runtime.snapshots.StateRecord r13 = (androidx.compose.runtime.snapshots.StateRecord) r13
            r15 = 0
            r16 = 0
            androidx.compose.runtime.snapshots.Snapshot r16 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            r19 = 0
            java.lang.Object r20 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r21 = 0
            monitor-enter(r20)
            r22 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r23 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0113 }
            androidx.compose.runtime.snapshots.Snapshot r23 = r23.getCurrent()     // Catch:{ all -> 0x0113 }
            r16 = r23
            r23 = r3
            r3 = r2
            androidx.compose.runtime.snapshots.StateObject r3 = (androidx.compose.runtime.snapshots.StateObject) r3     // Catch:{ all -> 0x0109 }
            r24 = r4
            r4 = r16
            androidx.compose.runtime.snapshots.StateRecord r3 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r13, r3, r4)     // Catch:{ all -> 0x0101 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r3 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r3     // Catch:{ all -> 0x0101 }
            r16 = 0
            java.lang.Object r25 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync     // Catch:{ all -> 0x0101 }
            r26 = 0
            monitor-enter(r25)     // Catch:{ all -> 0x0101 }
            r27 = 0
            r28 = r5
            int r5 = r3.getModification$runtime_release()     // Catch:{ all -> 0x00f8 }
            if (r5 != r11) goto L_0x00c5
            r3.setList$runtime_release(r1)     // Catch:{ all -> 0x00c1 }
            int r5 = r3.getModification$runtime_release()     // Catch:{ all -> 0x00c1 }
            r29 = 1
            int r5 = r5 + 1
            r3.setModification$runtime_release(r5)     // Catch:{ all -> 0x00c1 }
            goto L_0x00c7
        L_0x00c1:
            r0 = move-exception
            r27 = r1
            goto L_0x00fb
        L_0x00c5:
            r29 = 0
        L_0x00c7:
            monitor-exit(r25)     // Catch:{ all -> 0x00f2 }
            monitor-exit(r20)
            r3 = r29
            r5 = 0
            r27 = r1
            r1 = r2
            androidx.compose.runtime.snapshots.StateObject r1 = (androidx.compose.runtime.snapshots.StateObject) r1
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r4, r1)
            if (r29 == 0) goto L_0x00e6
            r2 = 1
        L_0x00e0:
            return r0
        L_0x00e6:
            r1 = r17
            r2 = r18
            r3 = r23
            r4 = r24
            r5 = r28
            goto L_0x0010
        L_0x00f2:
            r0 = move-exception
            r27 = r1
            r16 = r4
            goto L_0x011c
        L_0x00f8:
            r0 = move-exception
            r27 = r1
        L_0x00fb:
            monitor-exit(r25)     // Catch:{ all -> 0x00fd }
            throw r0     // Catch:{ all -> 0x00fd }
        L_0x00fd:
            r0 = move-exception
            r16 = r4
            goto L_0x011c
        L_0x0101:
            r0 = move-exception
            r27 = r1
            r28 = r5
            r16 = r4
            goto L_0x011c
        L_0x0109:
            r0 = move-exception
            r27 = r1
            r24 = r4
            r28 = r5
            r4 = r16
            goto L_0x011c
        L_0x0113:
            r0 = move-exception
            r27 = r1
            r23 = r3
            r24 = r4
            r28 = r5
        L_0x011c:
            monitor-exit(r20)
            throw r0
        L_0x011e:
            r0 = move-exception
            r14 = r31
            r23 = r3
            r24 = r4
            r28 = r5
            goto L_0x0133
        L_0x0128:
            r0 = move-exception
            r14 = r31
            r18 = r2
            r23 = r3
            r24 = r4
            r28 = r5
        L_0x0133:
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.removeAt(int):java.lang.Object");
    }

    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return mutateBoolean(new SnapshotStateList$retainAll$1(elements));
    }

    /* Debug info: failed to restart local var, previous not found, register: 31 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004b, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        r1 = r10.set(r32, r33);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005d, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10) == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005f, code lost:
        r16 = r3;
        r24 = r4;
        r25 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0068, code lost:
        r2 = r7;
        r13 = r2.getFirstStateRecord();
        r16 = r3;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        r3 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r13;
        r19 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer();
        r21 = androidx.compose.runtime.snapshots.SnapshotKt.getLock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008a, code lost:
        monitor-enter(r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0093, code lost:
        r19 = androidx.compose.runtime.snapshots.Snapshot.Companion.getCurrent();
        r24 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009a, code lost:
        r25 = r5;
        r5 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r3, r2, r5);
        r26 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ac, code lost:
        monitor-enter(r26);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ad, code lost:
        r29 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b5, code lost:
        if (r4.getModification$runtime_release() != r11) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r4.setList$runtime_release(r1);
        r30 = true;
        r4.setModification$runtime_release(r4.getModification$runtime_release() + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c7, code lost:
        r28 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ca, code lost:
        r30 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        monitor-exit(r26);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d0, code lost:
        monitor-exit(r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d1, code lost:
        r3 = r30;
        r28 = r1;
        androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e1, code lost:
        if (r30 == false) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f9, code lost:
        r28 = r1;
        r19 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fe, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ff, code lost:
        r28 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        monitor-exit(r26);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0102, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0103, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0104, code lost:
        r19 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0107, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0108, code lost:
        r28 = r1;
        r29 = r3;
        r19 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0110, code lost:
        r28 = r1;
        r29 = r3;
        r25 = r5;
        r5 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0119, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x011a, code lost:
        r28 = r1;
        r29 = r3;
        r24 = r4;
        r25 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0122, code lost:
        monitor-exit(r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0123, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T set(int r32, T r33) {
        /*
            r31 = this;
            java.lang.Object r0 = r31.get(r32)
            r1 = r0
            r2 = 0
            r3 = r31
            r4 = 0
            r5 = r3
            r6 = 0
            r7 = r5
            androidx.compose.runtime.snapshots.SnapshotStateList r7 = (androidx.compose.runtime.snapshots.SnapshotStateList) r7
            r8 = 0
            r9 = 0
        L_0x0010:
            r10 = 0
            r11 = 0
            java.lang.Object r12 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r13 = 0
            monitor-enter(r12)
            r14 = 0
            r15 = r7
            r16 = 0
            r17 = r1
            androidx.compose.runtime.snapshots.StateRecord r1 = r15.getFirstStateRecord()     // Catch:{ all -> 0x0130 }
            r18 = r2
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch:{ all -> 0x0124 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch:{ all -> 0x0124 }
            androidx.compose.runtime.snapshots.StateRecord r1 = (androidx.compose.runtime.snapshots.StateRecord) r1     // Catch:{ all -> 0x0124 }
            r2 = 0
            androidx.compose.runtime.snapshots.StateRecord r19 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch:{ all -> 0x0124 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r19 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r19     // Catch:{ all -> 0x0124 }
            r20 = 0
            r1 = r19
            int r2 = r1.getModification$runtime_release()     // Catch:{ all -> 0x0124 }
            r11 = r2
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r2 = r1.getList$runtime_release()     // Catch:{ all -> 0x0124 }
            r10 = r2
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0124 }
            monitor-exit(r12)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r1 = r10
            r2 = 0
            r14 = r32
            r15 = r33
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.set(r14, r15)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            if (r2 == 0) goto L_0x0068
            r2 = 0
            r16 = r3
            r24 = r4
            r25 = r5
            goto L_0x00e5
        L_0x0068:
            r2 = r7
            r12 = 0
            androidx.compose.runtime.snapshots.StateRecord r13 = r2.getFirstStateRecord()
            r16 = r3
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r3)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r13 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r13
            r3 = r13
            androidx.compose.runtime.snapshots.StateRecord r3 = (androidx.compose.runtime.snapshots.StateRecord) r3
            r13 = 0
            r19 = 0
            androidx.compose.runtime.snapshots.Snapshot r19 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            r20 = 0
            java.lang.Object r21 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r22 = 0
            monitor-enter(r21)
            r23 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r24 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0119 }
            androidx.compose.runtime.snapshots.Snapshot r24 = r24.getCurrent()     // Catch:{ all -> 0x0119 }
            r19 = r24
            r24 = r4
            r4 = r2
            androidx.compose.runtime.snapshots.StateObject r4 = (androidx.compose.runtime.snapshots.StateObject) r4     // Catch:{ all -> 0x010f }
            r25 = r5
            r5 = r19
            androidx.compose.runtime.snapshots.StateRecord r4 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r3, r4, r5)     // Catch:{ all -> 0x0107 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r4     // Catch:{ all -> 0x0107 }
            r19 = 0
            java.lang.Object r26 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync     // Catch:{ all -> 0x0107 }
            r27 = 0
            monitor-enter(r26)     // Catch:{ all -> 0x0107 }
            r28 = 0
            r29 = r3
            int r3 = r4.getModification$runtime_release()     // Catch:{ all -> 0x00fe }
            if (r3 != r11) goto L_0x00ca
            r4.setList$runtime_release(r1)     // Catch:{ all -> 0x00c6 }
            int r3 = r4.getModification$runtime_release()     // Catch:{ all -> 0x00c6 }
            r30 = 1
            int r3 = r3 + 1
            r4.setModification$runtime_release(r3)     // Catch:{ all -> 0x00c6 }
            goto L_0x00cc
        L_0x00c6:
            r0 = move-exception
            r28 = r1
            goto L_0x0101
        L_0x00ca:
            r30 = 0
        L_0x00cc:
            monitor-exit(r26)     // Catch:{ all -> 0x00f8 }
            monitor-exit(r21)
            r3 = r30
            r4 = 0
            r28 = r1
            r1 = r2
            androidx.compose.runtime.snapshots.StateObject r1 = (androidx.compose.runtime.snapshots.StateObject) r1
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r1)
            if (r30 == 0) goto L_0x00ec
            r2 = 1
        L_0x00e5:
            return r0
        L_0x00ec:
            r3 = r16
            r1 = r17
            r2 = r18
            r4 = r24
            r5 = r25
            goto L_0x0010
        L_0x00f8:
            r0 = move-exception
            r28 = r1
            r19 = r5
            goto L_0x0122
        L_0x00fe:
            r0 = move-exception
            r28 = r1
        L_0x0101:
            monitor-exit(r26)     // Catch:{ all -> 0x0103 }
            throw r0     // Catch:{ all -> 0x0103 }
        L_0x0103:
            r0 = move-exception
            r19 = r5
            goto L_0x0122
        L_0x0107:
            r0 = move-exception
            r28 = r1
            r29 = r3
            r19 = r5
            goto L_0x0122
        L_0x010f:
            r0 = move-exception
            r28 = r1
            r29 = r3
            r25 = r5
            r5 = r19
            goto L_0x0122
        L_0x0119:
            r0 = move-exception
            r28 = r1
            r29 = r3
            r24 = r4
            r25 = r5
        L_0x0122:
            monitor-exit(r21)
            throw r0
        L_0x0124:
            r0 = move-exception
            r14 = r32
            r15 = r33
            r16 = r3
            r24 = r4
            r25 = r5
            goto L_0x013d
        L_0x0130:
            r0 = move-exception
            r14 = r32
            r15 = r33
            r18 = r2
            r16 = r3
            r24 = r4
            r25 = r5
        L_0x013d:
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.set(int, java.lang.Object):java.lang.Object");
    }

    /* Debug info: failed to restart local var, previous not found, register: 25 */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final void removeRange(int r26, int r27) {
        /*
            r25 = this;
            r1 = r25
            r2 = 0
            r0 = 0
            r3 = r0
        L_0x0005:
            r4 = 0
            r5 = 0
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r7 = 0
            monitor-enter(r6)
            r0 = 0
            r8 = r1
            r9 = 0
            androidx.compose.runtime.snapshots.StateRecord r10 = r8.getFirstStateRecord()     // Catch:{ all -> 0x00ec }
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)     // Catch:{ all -> 0x00ec }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r10 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r10     // Catch:{ all -> 0x00ec }
            androidx.compose.runtime.snapshots.StateRecord r10 = (androidx.compose.runtime.snapshots.StateRecord) r10     // Catch:{ all -> 0x00ec }
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = androidx.compose.runtime.snapshots.SnapshotKt.current(r10)     // Catch:{ all -> 0x00ec }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r12     // Catch:{ all -> 0x00ec }
            r13 = 0
            r8 = r12
            int r9 = r8.getModification$runtime_release()     // Catch:{ all -> 0x00ec }
            r5 = r9
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r9 = r8.getList$runtime_release()     // Catch:{ all -> 0x00ec }
            r4 = r9
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00ec }
            monitor-exit(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder r6 = r4.builder()
            r0 = r6
            java.util.List r0 = (java.util.List) r0
            r7 = 0
            r8 = r26
            r9 = r27
            java.util.List r10 = r0.subList(r8, r9)
            r10.clear()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r3 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r7 = r6.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)
            if (r0 != 0) goto L_0x00e7
            r10 = r1
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r10.getFirstStateRecord()
            java.lang.String r12 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r12)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0
            r12 = r0
            androidx.compose.runtime.snapshots.StateRecord r12 = (androidx.compose.runtime.snapshots.StateRecord) r12
            r13 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r14 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            r15 = 0
            java.lang.Object r16 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r17 = 0
            monitor-enter(r16)
            r18 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00e2 }
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.getCurrent()     // Catch:{ all -> 0x00e2 }
            r14 = r0
            r0 = r10
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00e2 }
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r12, r0, r14)     // Catch:{ all -> 0x00e2 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00e2 }
            r19 = r0
            r20 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync     // Catch:{ all -> 0x00e2 }
            r21 = r0
            r22 = 0
            monitor-enter(r21)     // Catch:{ all -> 0x00e2 }
            r0 = 0
            r23 = r0
            int r0 = r19.getModification$runtime_release()     // Catch:{ all -> 0x00d9 }
            if (r0 != r5) goto L_0x00b9
            r24 = r1
            r1 = r19
            r1.setList$runtime_release(r7)     // Catch:{ all -> 0x00b7 }
            int r0 = r1.getModification$runtime_release()     // Catch:{ all -> 0x00b7 }
            r19 = 1
            int r0 = r0 + 1
            r1.setModification$runtime_release(r0)     // Catch:{ all -> 0x00b7 }
            goto L_0x00bf
        L_0x00b7:
            r0 = move-exception
            goto L_0x00de
        L_0x00b9:
            r24 = r1
            r1 = r19
            r19 = 0
        L_0x00bf:
            monitor-exit(r21)     // Catch:{ all -> 0x00e0 }
            monitor-exit(r16)
            r0 = r19
            r1 = 0
            r15 = r10
            androidx.compose.runtime.snapshots.StateObject r15 = (androidx.compose.runtime.snapshots.StateObject) r15
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r14, r15)
            if (r19 == 0) goto L_0x00d5
            goto L_0x00e9
        L_0x00d5:
            r1 = r24
            goto L_0x0005
        L_0x00d9:
            r0 = move-exception
            r24 = r1
            r1 = r19
        L_0x00de:
            monitor-exit(r21)     // Catch:{ all -> 0x00e0 }
            throw r0     // Catch:{ all -> 0x00e0 }
        L_0x00e0:
            r0 = move-exception
            goto L_0x00e5
        L_0x00e2:
            r0 = move-exception
            r24 = r1
        L_0x00e5:
            monitor-exit(r16)
            throw r0
        L_0x00e7:
            r24 = r1
        L_0x00e9:
            return
        L_0x00ec:
            r0 = move-exception
            r8 = r26
            r9 = r27
            r24 = r1
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.removeRange(int, int):void");
    }

    /* Debug info: failed to restart local var, previous not found, register: 26 */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final int retainAllInRange$runtime_release(java.util.Collection<? extends T> r27, int r28, int r29) {
        /*
            r26 = this;
            r1 = r27
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            int r2 = r26.size()
            r3 = r26
            r4 = 0
            r0 = 0
            r5 = r0
        L_0x0010:
            r6 = 0
            r7 = 0
            java.lang.Object r8 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r9 = 0
            monitor-enter(r8)
            r0 = 0
            r10 = r3
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = r10.getFirstStateRecord()     // Catch:{ all -> 0x0113 }
            java.lang.String r13 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r13)     // Catch:{ all -> 0x0113 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r12     // Catch:{ all -> 0x0113 }
            androidx.compose.runtime.snapshots.StateRecord r12 = (androidx.compose.runtime.snapshots.StateRecord) r12     // Catch:{ all -> 0x0113 }
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r14 = androidx.compose.runtime.snapshots.SnapshotKt.current(r12)     // Catch:{ all -> 0x0113 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r14 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r14     // Catch:{ all -> 0x0113 }
            r15 = 0
            r10 = r14
            int r11 = r10.getModification$runtime_release()     // Catch:{ all -> 0x0113 }
            r7 = r11
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r11 = r10.getList$runtime_release()     // Catch:{ all -> 0x0113 }
            r6 = r11
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0113 }
            monitor-exit(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder r8 = r6.builder()
            r0 = r8
            java.util.List r0 = (java.util.List) r0
            r9 = 0
            r10 = r28
            r11 = r29
            java.util.List r12 = r0.subList(r10, r11)
            r12.retainAll(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r5 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r9 = r8.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r6)
            if (r0 != 0) goto L_0x0108
            r12 = r3
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r12.getFirstStateRecord()
            java.lang.String r14 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r14)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0
            r14 = r0
            androidx.compose.runtime.snapshots.StateRecord r14 = (androidx.compose.runtime.snapshots.StateRecord) r14
            r15 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r16 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            r17 = 0
            java.lang.Object r18 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r19 = 0
            monitor-enter(r18)
            r20 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0103 }
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.getCurrent()     // Catch:{ all -> 0x0103 }
            r16 = r0
            r0 = r12
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00fd }
            r1 = r16
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r14, r0, r1)     // Catch:{ all -> 0x00f7 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00f7 }
            r16 = r0
            r21 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync     // Catch:{ all -> 0x00f7 }
            r22 = r0
            r23 = 0
            monitor-enter(r22)     // Catch:{ all -> 0x00f7 }
            r0 = 0
            r24 = r0
            int r0 = r16.getModification$runtime_release()     // Catch:{ all -> 0x00ec }
            if (r0 != r7) goto L_0x00c8
            r25 = r3
            r3 = r16
            r3.setList$runtime_release(r9)     // Catch:{ all -> 0x00c6 }
            int r0 = r3.getModification$runtime_release()     // Catch:{ all -> 0x00c6 }
            r16 = 1
            int r0 = r0 + 1
            r3.setModification$runtime_release(r0)     // Catch:{ all -> 0x00c6 }
            goto L_0x00ce
        L_0x00c6:
            r0 = move-exception
            goto L_0x00f1
        L_0x00c8:
            r25 = r3
            r3 = r16
            r16 = 0
        L_0x00ce:
            monitor-exit(r22)     // Catch:{ all -> 0x00f3 }
            monitor-exit(r18)
            r0 = r16
            r3 = 0
            r17 = r0
            r0 = r12
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r0)
            if (r16 == 0) goto L_0x00e6
            goto L_0x010a
        L_0x00e6:
            r1 = r27
            r3 = r25
            goto L_0x0010
        L_0x00ec:
            r0 = move-exception
            r25 = r3
            r3 = r16
        L_0x00f1:
            monitor-exit(r22)     // Catch:{ all -> 0x00f3 }
            throw r0     // Catch:{ all -> 0x00f3 }
        L_0x00f3:
            r0 = move-exception
            r16 = r1
            goto L_0x0106
        L_0x00f7:
            r0 = move-exception
            r25 = r3
            r16 = r1
            goto L_0x0106
        L_0x00fd:
            r0 = move-exception
            r25 = r3
            r1 = r16
            goto L_0x0106
        L_0x0103:
            r0 = move-exception
            r25 = r3
        L_0x0106:
            monitor-exit(r18)
            throw r0
        L_0x0108:
            r25 = r3
        L_0x010a:
            int r0 = r26.size()
            int r0 = r2 - r0
            return r0
        L_0x0113:
            r0 = move-exception
            r10 = r28
            r11 = r29
            r25 = r3
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.retainAllInRange$runtime_release(java.util.Collection, int, int):int");
    }

    public final List<T> getDebuggerDisplayValue() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2)).getList$runtime_release();
    }

    private final <R> R writable(Function1<? super StateListStateRecord<T>, ? extends R> block) {
        Snapshot current;
        R invoke;
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateRecord $this$writable$iv = (StateListStateRecord) firstStateRecord2;
        Object snapshot$iv = SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                invoke = block.invoke(SnapshotKt.writableRecord($this$writable$iv, this, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        R r = invoke;
        SnapshotKt.notifyWrite(current, this);
        return invoke;
    }

    private final <R> R withCurrent(Function1<? super StateListStateRecord<T>, ? extends R> block) {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return block.invoke(SnapshotKt.current((StateListStateRecord) firstStateRecord2));
    }

    /* Debug info: failed to restart local var, previous not found, register: 24 */
    /* JADX INFO: finally extract failed */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final boolean mutateBoolean(kotlin.jvm.functions.Function1<? super java.util.List<T>, java.lang.Boolean> r25) {
        /*
            r24 = this;
            r1 = r24
            r2 = 0
            r0 = 0
            r3 = r0
        L_0x0005:
            r4 = 0
            r5 = 0
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r7 = 0
            monitor-enter(r6)
            r0 = 0
            r8 = r1
            r9 = 0
            androidx.compose.runtime.snapshots.StateRecord r10 = r8.getFirstStateRecord()     // Catch:{ all -> 0x00e6 }
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)     // Catch:{ all -> 0x00e6 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r10 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r10     // Catch:{ all -> 0x00e6 }
            androidx.compose.runtime.snapshots.StateRecord r10 = (androidx.compose.runtime.snapshots.StateRecord) r10     // Catch:{ all -> 0x00e6 }
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = androidx.compose.runtime.snapshots.SnapshotKt.current(r10)     // Catch:{ all -> 0x00e6 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r12     // Catch:{ all -> 0x00e6 }
            r13 = 0
            r8 = r12
            int r9 = r8.getModification$runtime_release()     // Catch:{ all -> 0x00e6 }
            r5 = r9
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r9 = r8.getList$runtime_release()     // Catch:{ all -> 0x00e6 }
            r4 = r9
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e6 }
            monitor-exit(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder r6 = r4.builder()
            r8 = r25
            java.lang.Object r3 = r8.invoke(r6)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r7 = r6.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)
            if (r0 != 0) goto L_0x00da
            r9 = r1
            r10 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r9.getFirstStateRecord()
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r11)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0
            r11 = r0
            androidx.compose.runtime.snapshots.StateRecord r11 = (androidx.compose.runtime.snapshots.StateRecord) r11
            r12 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r13 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            r14 = 0
            java.lang.Object r15 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r16 = 0
            monitor-enter(r15)
            r17 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00d5 }
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.getCurrent()     // Catch:{ all -> 0x00d5 }
            r13 = r0
            r0 = r9
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00d5 }
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r11, r0, r13)     // Catch:{ all -> 0x00d5 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00d5 }
            r18 = r0
            r19 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync     // Catch:{ all -> 0x00d5 }
            r20 = r0
            r21 = 0
            monitor-enter(r20)     // Catch:{ all -> 0x00d5 }
            r0 = 0
            r22 = r0
            int r0 = r18.getModification$runtime_release()     // Catch:{ all -> 0x00cc }
            if (r0 != r5) goto L_0x00ac
            r23 = r1
            r1 = r18
            r1.setList$runtime_release(r7)     // Catch:{ all -> 0x00aa }
            int r0 = r1.getModification$runtime_release()     // Catch:{ all -> 0x00aa }
            r18 = 1
            int r0 = r0 + 1
            r1.setModification$runtime_release(r0)     // Catch:{ all -> 0x00aa }
            goto L_0x00b2
        L_0x00aa:
            r0 = move-exception
            goto L_0x00d1
        L_0x00ac:
            r23 = r1
            r1 = r18
            r18 = 0
        L_0x00b2:
            monitor-exit(r20)     // Catch:{ all -> 0x00d3 }
            monitor-exit(r15)
            r0 = r18
            r1 = 0
            r14 = r9
            androidx.compose.runtime.snapshots.StateObject r14 = (androidx.compose.runtime.snapshots.StateObject) r14
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r13, r14)
            if (r18 == 0) goto L_0x00c8
            goto L_0x00dc
        L_0x00c8:
            r1 = r23
            goto L_0x0005
        L_0x00cc:
            r0 = move-exception
            r23 = r1
            r1 = r18
        L_0x00d1:
            monitor-exit(r20)     // Catch:{ all -> 0x00d3 }
            throw r0     // Catch:{ all -> 0x00d3 }
        L_0x00d3:
            r0 = move-exception
            goto L_0x00d8
        L_0x00d5:
            r0 = move-exception
            r23 = r1
        L_0x00d8:
            monitor-exit(r15)
            throw r0
        L_0x00da:
            r23 = r1
        L_0x00dc:
            r0 = r3
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        L_0x00e6:
            r0 = move-exception
            r8 = r25
            r23 = r1
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.mutateBoolean(kotlin.jvm.functions.Function1):boolean");
    }

    /* Debug info: failed to restart local var, previous not found, register: 24 */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00be, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c1, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <R> R mutate(kotlin.jvm.functions.Function1<? super java.util.List<T>, ? extends R> r25) {
        /*
            r24 = this;
            r1 = 0
            r0 = 0
            r2 = r0
        L_0x0003:
            r3 = 0
            r4 = 0
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r6 = 0
            monitor-enter(r5)
            r0 = 0
            r7 = r24
            r8 = 0
            r9 = 1
            androidx.compose.runtime.snapshots.StateRecord r10 = r7.getFirstStateRecord()     // Catch:{ all -> 0x00f3 }
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r10 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r10     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.StateRecord r10 = (androidx.compose.runtime.snapshots.StateRecord) r10     // Catch:{ all -> 0x00f3 }
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = androidx.compose.runtime.snapshots.SnapshotKt.current(r10)     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r12     // Catch:{ all -> 0x00f3 }
            r13 = 0
            r7 = r12
            int r8 = r7.getModification$runtime_release()     // Catch:{ all -> 0x00f3 }
            r4 = r8
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r8 = r7.getList$runtime_release()     // Catch:{ all -> 0x00f3 }
            r3 = r8
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f3 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r9)
            monitor-exit(r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder r5 = r3.builder()
            r7 = r25
            java.lang.Object r2 = r7.invoke(r5)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r6 = r5.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r3)
            if (r0 != 0) goto L_0x00f1
            r8 = r24
            r10 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r8.getFirstStateRecord()
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r11)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0
            r11 = r0
            androidx.compose.runtime.snapshots.StateRecord r11 = (androidx.compose.runtime.snapshots.StateRecord) r11
            r12 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r13 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            r14 = 0
            java.lang.Object r15 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r16 = 0
            monitor-enter(r15)
            r17 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00e7 }
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.getCurrent()     // Catch:{ all -> 0x00e7 }
            r13 = r0
            r0 = r8
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00e7 }
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r11, r0, r13)     // Catch:{ all -> 0x00e7 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00e7 }
            r18 = r0
            r19 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync     // Catch:{ all -> 0x00e7 }
            r20 = r0
            r21 = 0
            monitor-enter(r20)     // Catch:{ all -> 0x00e7 }
            r0 = 0
            int r9 = r18.getModification$runtime_release()     // Catch:{ all -> 0x00da }
            if (r9 != r4) goto L_0x00b2
            r9 = r18
            r9.setList$runtime_release(r6)     // Catch:{ all -> 0x00b0 }
            int r18 = r9.getModification$runtime_release()     // Catch:{ all -> 0x00b0 }
            r23 = r0
            r22 = 1
            int r0 = r18 + 1
            r9.setModification$runtime_release(r0)     // Catch:{ all -> 0x00b0 }
            r0 = 1
            goto L_0x00b7
        L_0x00b0:
            r0 = move-exception
            goto L_0x00dd
        L_0x00b2:
            r23 = r0
            r9 = r18
            r0 = 0
        L_0x00b7:
            r18 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r18)     // Catch:{ all -> 0x00e7 }
            monitor-exit(r20)     // Catch:{ all -> 0x00e7 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r18)     // Catch:{ all -> 0x00e7 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r18)
            monitor-exit(r15)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r18)
            r9 = r0
            r14 = 0
            r15 = r8
            androidx.compose.runtime.snapshots.StateObject r15 = (androidx.compose.runtime.snapshots.StateObject) r15
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r13, r15)
            if (r0 == 0) goto L_0x0003
            goto L_0x00f1
        L_0x00da:
            r0 = move-exception
            r9 = r18
        L_0x00dd:
            r18 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r18)     // Catch:{ all -> 0x00e7 }
            monitor-exit(r20)     // Catch:{ all -> 0x00e7 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r18)     // Catch:{ all -> 0x00e7 }
            throw r0     // Catch:{ all -> 0x00e7 }
        L_0x00e7:
            r0 = move-exception
            r9 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r9)
            monitor-exit(r15)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r9)
            throw r0
        L_0x00f1:
            return r2
        L_0x00f3:
            r0 = move-exception
            r7 = r25
            r8 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r8)
            monitor-exit(r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.mutate(kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* Debug info: failed to restart local var, previous not found, register: 26 */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final void update(kotlin.jvm.functions.Function1<? super androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>, ? extends androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>> r27) {
        /*
            r26 = this;
            r1 = 0
            r2 = r26
            r3 = 0
            r4 = r2
            androidx.compose.runtime.snapshots.SnapshotStateList r4 = (androidx.compose.runtime.snapshots.SnapshotStateList) r4
            r5 = 0
            r6 = 0
        L_0x0009:
            r7 = 0
            r8 = 0
            java.lang.Object r9 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r10 = 0
            monitor-enter(r9)
            r0 = 0
            r11 = r4
            r12 = 0
            r13 = 1
            androidx.compose.runtime.snapshots.StateRecord r14 = r11.getFirstStateRecord()     // Catch:{ all -> 0x011d }
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r15)     // Catch:{ all -> 0x011d }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r14 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r14     // Catch:{ all -> 0x011d }
            androidx.compose.runtime.snapshots.StateRecord r14 = (androidx.compose.runtime.snapshots.StateRecord) r14     // Catch:{ all -> 0x011d }
            r15 = 0
            androidx.compose.runtime.snapshots.StateRecord r16 = androidx.compose.runtime.snapshots.SnapshotKt.current(r14)     // Catch:{ all -> 0x011d }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r16 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r16     // Catch:{ all -> 0x011d }
            r17 = 0
            r11 = r16
            int r12 = r11.getModification$runtime_release()     // Catch:{ all -> 0x011d }
            r8 = r12
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r12 = r11.getList$runtime_release()     // Catch:{ all -> 0x011d }
            r7 = r12
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x011d }
            kotlin.jvm.internal.InlineMarker.finallyStart(r13)
            monitor-exit(r9)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r11 = r27
            java.lang.Object r0 = r11.invoke(r7)
            r9 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r9 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList) r9
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r7)
            if (r0 == 0) goto L_0x005d
            r0 = 0
            r25 = r1
            goto L_0x00ea
        L_0x005d:
            r10 = r4
            r12 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r10.getFirstStateRecord()
            java.lang.String r14 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r14)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0
            r14 = r0
            androidx.compose.runtime.snapshots.StateRecord r14 = (androidx.compose.runtime.snapshots.StateRecord) r14
            r15 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r16 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            r17 = 0
            java.lang.Object r18 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r19 = 0
            monitor-enter(r18)
            r20 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0111 }
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.getCurrent()     // Catch:{ all -> 0x0111 }
            r16 = r0
            r0 = r10
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x010b }
            r13 = r16
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r14, r0, r13)     // Catch:{ all -> 0x0105 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x0105 }
            r16 = r0
            r21 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync     // Catch:{ all -> 0x0105 }
            r22 = r0
            r23 = 0
            monitor-enter(r22)     // Catch:{ all -> 0x0105 }
            r0 = 0
            r24 = r0
            int r0 = r16.getModification$runtime_release()     // Catch:{ all -> 0x00f2 }
            if (r0 != r8) goto L_0x00be
            r25 = r1
            r1 = r16
            r1.setList$runtime_release(r9)     // Catch:{ all -> 0x00bc }
            int r0 = r1.getModification$runtime_release()     // Catch:{ all -> 0x00bc }
            r16 = 1
            int r0 = r0 + 1
            r1.setModification$runtime_release(r0)     // Catch:{ all -> 0x00bc }
            r0 = 1
            goto L_0x00c3
        L_0x00bc:
            r0 = move-exception
            goto L_0x00f7
        L_0x00be:
            r25 = r1
            r1 = r16
            r0 = 0
        L_0x00c3:
            r16 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r16)     // Catch:{ all -> 0x0101 }
            monitor-exit(r22)     // Catch:{ all -> 0x0101 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r16)     // Catch:{ all -> 0x0101 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r16)
            monitor-exit(r18)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r16)
            r1 = r0
            r16 = 0
            r17 = r1
            r1 = r10
            androidx.compose.runtime.snapshots.StateObject r1 = (androidx.compose.runtime.snapshots.StateObject) r1
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r13, r1)
            if (r0 == 0) goto L_0x00ee
            r0 = 1
        L_0x00ea:
            return
        L_0x00ee:
            r1 = r25
            goto L_0x0009
        L_0x00f2:
            r0 = move-exception
            r25 = r1
            r1 = r16
        L_0x00f7:
            r16 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r16)     // Catch:{ all -> 0x0101 }
            monitor-exit(r22)     // Catch:{ all -> 0x0101 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r16)     // Catch:{ all -> 0x0101 }
            throw r0     // Catch:{ all -> 0x0101 }
        L_0x0101:
            r0 = move-exception
            r16 = r13
            goto L_0x0114
        L_0x0105:
            r0 = move-exception
            r25 = r1
            r16 = r13
            goto L_0x0114
        L_0x010b:
            r0 = move-exception
            r25 = r1
            r13 = r16
            goto L_0x0114
        L_0x0111:
            r0 = move-exception
            r25 = r1
        L_0x0114:
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r18)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        L_0x011d:
            r0 = move-exception
            r11 = r27
            r25 = r1
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r9)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.update(kotlin.jvm.functions.Function1):void");
    }

    /* Debug info: failed to restart local var, previous not found, register: 25 */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final boolean conditionalUpdate(kotlin.jvm.functions.Function1<? super androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>, ? extends androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>> r26) {
        /*
            r25 = this;
            r1 = 0
            r2 = r25
            androidx.compose.runtime.snapshots.SnapshotStateList r2 = (androidx.compose.runtime.snapshots.SnapshotStateList) r2
            r3 = 0
            r4 = 0
        L_0x0007:
            r5 = 0
            r6 = 0
            java.lang.Object r7 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r8 = 0
            monitor-enter(r7)
            r0 = 0
            r9 = r2
            r10 = 0
            r11 = 1
            androidx.compose.runtime.snapshots.StateRecord r12 = r9.getFirstStateRecord()     // Catch:{ all -> 0x0104 }
            java.lang.String r13 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r13)     // Catch:{ all -> 0x0104 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r12     // Catch:{ all -> 0x0104 }
            androidx.compose.runtime.snapshots.StateRecord r12 = (androidx.compose.runtime.snapshots.StateRecord) r12     // Catch:{ all -> 0x0104 }
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r14 = androidx.compose.runtime.snapshots.SnapshotKt.current(r12)     // Catch:{ all -> 0x0104 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r14 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r14     // Catch:{ all -> 0x0104 }
            r15 = 0
            r9 = r14
            int r10 = r9.getModification$runtime_release()     // Catch:{ all -> 0x0104 }
            r6 = r10
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r10 = r9.getList$runtime_release()     // Catch:{ all -> 0x0104 }
            r5 = r10
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0104 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r11)
            monitor-exit(r7)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r9 = r26
            java.lang.Object r0 = r9.invoke(r5)
            r7 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r7 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList) r7
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r5)
            if (r0 == 0) goto L_0x0059
            r0 = 0
            r19 = r1
            goto L_0x00e1
        L_0x0059:
            r8 = r2
            r10 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r8.getFirstStateRecord()
            java.lang.String r12 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r12)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0
            r12 = r0
            androidx.compose.runtime.snapshots.StateRecord r12 = (androidx.compose.runtime.snapshots.StateRecord) r12
            r13 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r14 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            r15 = 0
            java.lang.Object r16 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r17 = 0
            monitor-enter(r16)
            r18 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00f8 }
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.getCurrent()     // Catch:{ all -> 0x00f8 }
            r14 = r0
            r0 = r8
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00f8 }
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r12, r0, r14)     // Catch:{ all -> 0x00f8 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00f8 }
            r19 = r0
            r20 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync     // Catch:{ all -> 0x00f8 }
            r21 = r0
            r22 = 0
            monitor-enter(r21)     // Catch:{ all -> 0x00f8 }
            r0 = 0
            int r11 = r19.getModification$runtime_release()     // Catch:{ all -> 0x00e8 }
            if (r11 != r6) goto L_0x00b6
            r11 = r19
            r11.setList$runtime_release(r7)     // Catch:{ all -> 0x00b2 }
            int r19 = r11.getModification$runtime_release()     // Catch:{ all -> 0x00b2 }
            r24 = r0
            r23 = 1
            int r0 = r19 + 1
            r11.setModification$runtime_release(r0)     // Catch:{ all -> 0x00b2 }
            r0 = 1
            goto L_0x00bb
        L_0x00b2:
            r0 = move-exception
            r19 = r1
            goto L_0x00ed
        L_0x00b6:
            r24 = r0
            r11 = r19
            r0 = 0
        L_0x00bb:
            r19 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r19)     // Catch:{ all -> 0x00f8 }
            monitor-exit(r21)     // Catch:{ all -> 0x00f8 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r19)     // Catch:{ all -> 0x00f8 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r19)
            monitor-exit(r16)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r19)
            r11 = r0
            r15 = 0
            r19 = r1
            r1 = r8
            androidx.compose.runtime.snapshots.StateObject r1 = (androidx.compose.runtime.snapshots.StateObject) r1
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r14, r1)
            if (r0 == 0) goto L_0x00e4
            r0 = 1
        L_0x00e1:
            return r0
        L_0x00e4:
            r1 = r19
            goto L_0x0007
        L_0x00e8:
            r0 = move-exception
            r11 = r19
            r19 = r1
        L_0x00ed:
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch:{ all -> 0x00f6 }
            monitor-exit(r21)     // Catch:{ all -> 0x00f6 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch:{ all -> 0x00f6 }
            throw r0     // Catch:{ all -> 0x00f6 }
        L_0x00f6:
            r0 = move-exception
            goto L_0x00fb
        L_0x00f8:
            r0 = move-exception
            r19 = r1
        L_0x00fb:
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r16)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        L_0x0104:
            r0 = move-exception
            r9 = r26
            r19 = r1
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r7)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate(kotlin.jvm.functions.Function1):boolean");
    }
}

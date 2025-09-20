package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004:\u0001LB\u0005¢\u0006\u0002\u0010\u0005J1\u0010&\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*\u0012\u0004\u0012\u00020'0)H\bø\u0001\u0000¢\u0006\u0002\b+J1\u0010,\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*\u0012\u0004\u0012\u00020'0)H\bø\u0001\u0000¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0015\u00100\u001a\u00020'2\u0006\u00101\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00020'2\u0006\u00104\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00102J\u0018\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\b\u00107\u001a\u00020'H\u0016J4\u00108\u001a\u0002H9\"\u0004\b\u0002\u001092\u001e\u0010:\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u0002H90)H\b¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020/2\u0006\u00104\u001a\u00020\u0011H\u0016J\u001f\u0010=\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u00002\u0006\u00104\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010>J\u001e\u0010?\u001a\u00020/2\u0014\u0010@\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0017\u0010A\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00106J1\u0010B\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\u0012\u0004\u0012\u00020'0)H\bø\u0001\u0000¢\u0006\u0002\bCJ\u0017\u0010D\u001a\u00020'2\u0006\u00104\u001a\u00028\u0001H\u0000¢\u0006\u0004\bE\u00102J\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007J5\u0010G\u001a\u00020/2*\u0010:\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010H\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010H0)H\bJ9\u0010I\u001a\u0002H9\"\u0004\b\u0002\u001092#\u0010:\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0004\u0012\u0002H90)¢\u0006\u0002\bJH\b¢\u0006\u0002\u0010;J9\u0010K\u001a\u0002H9\"\u0004\b\u0002\u001092#\u0010:\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0004\u0012\u0002H90)¢\u0006\u0002\bJH\b¢\u0006\u0002\u0010;R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078AX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00188@X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c8@X\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001aR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010#X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u0002\u0007\n\u0005\b20\u0001¨\u0006M"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "K", "V", "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/Map;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "keys", "getKeys", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "all", "", "predicate", "Lkotlin/Function1;", "", "all$runtime_release", "any", "any$runtime_release", "clear", "", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "mutate", "R", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "prependStateRecord", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "remove", "removeIf", "removeIf$runtime_release", "removeValue", "removeValue$runtime_release", "toMap", "update", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateMapStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateMap.kt */
public final class SnapshotStateMap<K, V> implements Map<K, V>, StateObject, KMutableMap {
    public static final int $stable = 0;
    private final Set<Map.Entry<K, V>> entries = new SnapshotMapEntrySet(this);
    private StateRecord firstStateRecord = new StateMapStateRecord(ExtensionsKt.persistentHashMapOf());
    private final Set<K> keys = new SnapshotMapKeySet(this);
    private final Collection<V> values = new SnapshotMapValueSet(this);

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.firstStateRecord = (StateMapStateRecord) value;
    }

    public final Map<K, V> toMap() {
        return getReadable$runtime_release().getMap$runtime_release();
    }

    public int getSize() {
        return getReadable$runtime_release().getMap$runtime_release().size();
    }

    public boolean containsKey(Object key) {
        return getReadable$runtime_release().getMap$runtime_release().containsKey(key);
    }

    public boolean containsValue(Object value) {
        return getReadable$runtime_release().getMap$runtime_release().containsValue(value);
    }

    public V get(Object key) {
        return getReadable$runtime_release().getMap$runtime_release().get(key);
    }

    public boolean isEmpty() {
        return getReadable$runtime_release().getMap$runtime_release().isEmpty();
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return this.entries;
    }

    public Set<K> getKeys() {
        return this.keys;
    }

    public Collection<V> getValues() {
        return this.values;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void clear() {
        /*
            r25 = this;
            r1 = r25
            r2 = 0
            r3 = r1
            r4 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r3.getFirstStateRecord()
            java.lang.String r5 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r5)
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0
            r5 = r0
            androidx.compose.runtime.snapshots.StateRecord r5 = (androidx.compose.runtime.snapshots.StateRecord) r5
            r6 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.current(r5)
            r7 = r0
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r7 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r7
            r8 = 0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r0 = r7.getMap$runtime_release()
            r9 = 0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r0 = androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.persistentHashMapOf()
            r9 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r0 = r7.getMap$runtime_release()
            if (r9 == r0) goto L_0x009a
            r10 = r1
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r10.getFirstStateRecord()
            java.lang.String r12 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r12)
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0
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
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0095 }
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.getCurrent()     // Catch:{ all -> 0x0095 }
            r14 = r0
            r0 = r10
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x0095 }
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r12, r0, r14)     // Catch:{ all -> 0x0095 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x0095 }
            r19 = r0
            r20 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync     // Catch:{ all -> 0x0095 }
            r21 = r0
            r22 = 0
            monitor-enter(r21)     // Catch:{ all -> 0x0095 }
            r0 = 0
            r23 = r1
            r1 = r19
            r1.setMap$runtime_release(r9)     // Catch:{ all -> 0x0090 }
            int r19 = r1.getModification$runtime_release()     // Catch:{ all -> 0x0090 }
            r24 = r0
            int r0 = r19 + 1
            r1.setModification$runtime_release(r0)     // Catch:{ all -> 0x0090 }
            monitor-exit(r21)     // Catch:{ all -> 0x0093 }
            monitor-exit(r16)
            r0 = r19
            r1 = 0
            r15 = r10
            androidx.compose.runtime.snapshots.StateObject r15 = (androidx.compose.runtime.snapshots.StateObject) r15
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r14, r15)
            goto L_0x009c
        L_0x0090:
            r0 = move-exception
            monitor-exit(r21)     // Catch:{ all -> 0x0093 }
            throw r0     // Catch:{ all -> 0x0093 }
        L_0x0093:
            r0 = move-exception
            goto L_0x0098
        L_0x0095:
            r0 = move-exception
            r23 = r1
        L_0x0098:
            monitor-exit(r16)
            throw r0
        L_0x009a:
            r23 = r1
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateMap.clear():void");
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
    public V put(K r26, V r27) {
        /*
            r25 = this;
            r1 = r25
            r2 = 0
            r0 = 0
            r3 = r0
        L_0x0005:
            r4 = 0
            r5 = 0
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r7 = 0
            monitor-enter(r6)
            r0 = 0
            r8 = r1
            r9 = 0
            androidx.compose.runtime.snapshots.StateRecord r10 = r8.getFirstStateRecord()     // Catch:{ all -> 0x00e6 }
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)     // Catch:{ all -> 0x00e6 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r10 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r10     // Catch:{ all -> 0x00e6 }
            androidx.compose.runtime.snapshots.StateRecord r10 = (androidx.compose.runtime.snapshots.StateRecord) r10     // Catch:{ all -> 0x00e6 }
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = androidx.compose.runtime.snapshots.SnapshotKt.current(r10)     // Catch:{ all -> 0x00e6 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r12     // Catch:{ all -> 0x00e6 }
            r13 = 0
            r8 = r12
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r9 = r8.getMap$runtime_release()     // Catch:{ all -> 0x00e6 }
            r4 = r9
            int r9 = r8.getModification$runtime_release()     // Catch:{ all -> 0x00e6 }
            r5 = r9
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e6 }
            monitor-exit(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder r6 = r4.builder()
            r0 = r6
            java.util.Map r0 = (java.util.Map) r0
            r7 = 0
            r8 = r26
            r9 = r27
            java.lang.Object r0 = r0.put(r8, r9)
            r3 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r7 = r6.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)
            if (r0 != 0) goto L_0x00e1
            r10 = r1
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r10.getFirstStateRecord()
            java.lang.String r12 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r12)
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0
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
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00dc }
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.getCurrent()     // Catch:{ all -> 0x00dc }
            r14 = r0
            r0 = r10
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00dc }
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r12, r0, r14)     // Catch:{ all -> 0x00dc }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x00dc }
            r19 = r0
            r20 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync     // Catch:{ all -> 0x00dc }
            r21 = r0
            r22 = 0
            monitor-enter(r21)     // Catch:{ all -> 0x00dc }
            r0 = 0
            r23 = r0
            int r0 = r19.getModification$runtime_release()     // Catch:{ all -> 0x00d3 }
            if (r0 != r5) goto L_0x00b3
            r24 = r1
            r1 = r19
            r1.setMap$runtime_release(r7)     // Catch:{ all -> 0x00b1 }
            int r0 = r1.getModification$runtime_release()     // Catch:{ all -> 0x00b1 }
            r19 = 1
            int r0 = r0 + 1
            r1.setModification$runtime_release(r0)     // Catch:{ all -> 0x00b1 }
            goto L_0x00b9
        L_0x00b1:
            r0 = move-exception
            goto L_0x00d8
        L_0x00b3:
            r24 = r1
            r1 = r19
            r19 = 0
        L_0x00b9:
            monitor-exit(r21)     // Catch:{ all -> 0x00da }
            monitor-exit(r16)
            r0 = r19
            r1 = 0
            r15 = r10
            androidx.compose.runtime.snapshots.StateObject r15 = (androidx.compose.runtime.snapshots.StateObject) r15
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r14, r15)
            if (r19 == 0) goto L_0x00cf
            goto L_0x00e3
        L_0x00cf:
            r1 = r24
            goto L_0x0005
        L_0x00d3:
            r0 = move-exception
            r24 = r1
            r1 = r19
        L_0x00d8:
            monitor-exit(r21)     // Catch:{ all -> 0x00da }
            throw r0     // Catch:{ all -> 0x00da }
        L_0x00da:
            r0 = move-exception
            goto L_0x00df
        L_0x00dc:
            r0 = move-exception
            r24 = r1
        L_0x00df:
            monitor-exit(r16)
            throw r0
        L_0x00e1:
            r24 = r1
        L_0x00e3:
            return r3
        L_0x00e6:
            r0 = move-exception
            r8 = r26
            r9 = r27
            r24 = r1
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateMap.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    /* Debug info: failed to restart local var, previous not found, register: 23 */
    public void putAll(Map<? extends K, ? extends V> from) {
        PersistentMap map$runtime_release;
        int currentModification$iv;
        Snapshot current;
        boolean z;
        Map<? extends K, ? extends V> map = from;
        Intrinsics.checkNotNullParameter(map, TypedValues.TransitionType.S_FROM);
        while (true) {
            synchronized (SnapshotStateMapKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateMapStateRecord current$iv = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) firstStateRecord2);
                map$runtime_release = current$iv.getMap$runtime_release();
                currentModification$iv = current$iv.getModification$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder$iv = map$runtime_release.builder();
            builder$iv.putAll(map);
            Object result$iv = Unit.INSTANCE;
            PersistentMap newMap$iv = builder$iv.build();
            if (!Intrinsics.areEqual((Object) newMap$iv, (Object) map$runtime_release)) {
                StateRecord firstStateRecord3 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateRecord $this$writable$iv$iv$iv = (StateMapStateRecord) firstStateRecord3;
                Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateMapStateRecord $this$mutate_u24lambda_u2411$iv = (StateMapStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv, this, current);
                    synchronized (SnapshotStateMapKt.sync) {
                        try {
                            if ($this$mutate_u24lambda_u2411$iv.getModification$runtime_release() == currentModification$iv) {
                                StateMapStateRecord $this$mutate_u24lambda_u2411$iv2 = $this$mutate_u24lambda_u2411$iv;
                                try {
                                    $this$mutate_u24lambda_u2411$iv2.setMap$runtime_release(newMap$iv);
                                    z = true;
                                    $this$mutate_u24lambda_u2411$iv2.setModification$runtime_release($this$mutate_u24lambda_u2411$iv2.getModification$runtime_release() + 1);
                                } catch (Throwable th) {
                                    th = th;
                                }
                            } else {
                                z = false;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            StateMapStateRecord stateMapStateRecord = $this$mutate_u24lambda_u2411$iv;
                            throw th;
                        }
                    }
                }
                boolean z2 = z;
                SnapshotKt.notifyWrite(current, this);
                if (!z) {
                    map = from;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
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
    public V remove(java.lang.Object r25) {
        /*
            r24 = this;
            r1 = r24
            r2 = 0
            r0 = 0
            r3 = r0
        L_0x0005:
            r4 = 0
            r5 = 0
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r7 = 0
            monitor-enter(r6)
            r0 = 0
            r8 = r1
            r9 = 0
            androidx.compose.runtime.snapshots.StateRecord r10 = r8.getFirstStateRecord()     // Catch:{ all -> 0x00e4 }
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)     // Catch:{ all -> 0x00e4 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r10 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r10     // Catch:{ all -> 0x00e4 }
            androidx.compose.runtime.snapshots.StateRecord r10 = (androidx.compose.runtime.snapshots.StateRecord) r10     // Catch:{ all -> 0x00e4 }
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = androidx.compose.runtime.snapshots.SnapshotKt.current(r10)     // Catch:{ all -> 0x00e4 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r12     // Catch:{ all -> 0x00e4 }
            r13 = 0
            r8 = r12
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r9 = r8.getMap$runtime_release()     // Catch:{ all -> 0x00e4 }
            r4 = r9
            int r9 = r8.getModification$runtime_release()     // Catch:{ all -> 0x00e4 }
            r5 = r9
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e4 }
            monitor-exit(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder r6 = r4.builder()
            r0 = r6
            java.util.Map r0 = (java.util.Map) r0
            r7 = 0
            r8 = r25
            java.lang.Object r0 = r0.remove(r8)
            r3 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r7 = r6.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)
            if (r0 != 0) goto L_0x00df
            r9 = r1
            r10 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r9.getFirstStateRecord()
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r11)
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0
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
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00da }
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.getCurrent()     // Catch:{ all -> 0x00da }
            r13 = r0
            r0 = r9
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00da }
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r11, r0, r13)     // Catch:{ all -> 0x00da }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x00da }
            r18 = r0
            r19 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync     // Catch:{ all -> 0x00da }
            r20 = r0
            r21 = 0
            monitor-enter(r20)     // Catch:{ all -> 0x00da }
            r0 = 0
            r22 = r0
            int r0 = r18.getModification$runtime_release()     // Catch:{ all -> 0x00d1 }
            if (r0 != r5) goto L_0x00b1
            r23 = r1
            r1 = r18
            r1.setMap$runtime_release(r7)     // Catch:{ all -> 0x00af }
            int r0 = r1.getModification$runtime_release()     // Catch:{ all -> 0x00af }
            r18 = 1
            int r0 = r0 + 1
            r1.setModification$runtime_release(r0)     // Catch:{ all -> 0x00af }
            goto L_0x00b7
        L_0x00af:
            r0 = move-exception
            goto L_0x00d6
        L_0x00b1:
            r23 = r1
            r1 = r18
            r18 = 0
        L_0x00b7:
            monitor-exit(r20)     // Catch:{ all -> 0x00d8 }
            monitor-exit(r15)
            r0 = r18
            r1 = 0
            r14 = r9
            androidx.compose.runtime.snapshots.StateObject r14 = (androidx.compose.runtime.snapshots.StateObject) r14
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r13, r14)
            if (r18 == 0) goto L_0x00cd
            goto L_0x00e1
        L_0x00cd:
            r1 = r23
            goto L_0x0005
        L_0x00d1:
            r0 = move-exception
            r23 = r1
            r1 = r18
        L_0x00d6:
            monitor-exit(r20)     // Catch:{ all -> 0x00d8 }
            throw r0     // Catch:{ all -> 0x00d8 }
        L_0x00d8:
            r0 = move-exception
            goto L_0x00dd
        L_0x00da:
            r0 = move-exception
            r23 = r1
        L_0x00dd:
            monitor-exit(r15)
            throw r0
        L_0x00df:
            r23 = r1
        L_0x00e1:
            return r3
        L_0x00e4:
            r0 = move-exception
            r8 = r25
            r23 = r1
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateMap.remove(java.lang.Object):java.lang.Object");
    }

    public final int getModification$runtime_release() {
        return getReadable$runtime_release().getModification$runtime_release();
    }

    public final boolean removeValue$runtime_release(V value) {
        Object element$iv;
        Iterator it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            if (Intrinsics.areEqual(((Map.Entry) element$iv).getValue(), (Object) value)) {
                break;
            }
        }
        Map.Entry it2 = (Map.Entry) element$iv;
        if (it2 == null) {
            return false;
        }
        remove(it2.getKey());
        return true;
    }

    public final StateMapStateRecord<K, V> getReadable$runtime_release() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return (StateMapStateRecord) SnapshotKt.readable((StateMapStateRecord) firstStateRecord2, this);
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final boolean removeIf$runtime_release(kotlin.jvm.functions.Function1<? super java.util.Map.Entry<K, V>, java.lang.Boolean> r26) {
        /*
            r25 = this;
            r1 = r26
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r2 = 0
            r0 = 0
            r3 = r25
            r4 = 0
            r5 = 0
            r6 = r5
            r5 = r0
        L_0x0010:
            r7 = 0
            r8 = 0
            java.lang.Object r9 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r10 = 0
            monitor-enter(r9)
            r0 = 0
            r11 = r3
            r12 = 0
            r13 = 1
            androidx.compose.runtime.snapshots.StateRecord r14 = r11.getFirstStateRecord()     // Catch:{ all -> 0x013d }
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r15)     // Catch:{ all -> 0x013d }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r14 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r14     // Catch:{ all -> 0x013d }
            androidx.compose.runtime.snapshots.StateRecord r14 = (androidx.compose.runtime.snapshots.StateRecord) r14     // Catch:{ all -> 0x013d }
            r15 = 0
            androidx.compose.runtime.snapshots.StateRecord r16 = androidx.compose.runtime.snapshots.SnapshotKt.current(r14)     // Catch:{ all -> 0x013d }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r16 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r16     // Catch:{ all -> 0x013d }
            r17 = 0
            r11 = r16
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r12 = r11.getMap$runtime_release()     // Catch:{ all -> 0x013d }
            r7 = r12
            int r12 = r11.getModification$runtime_release()     // Catch:{ all -> 0x013d }
            r8 = r12
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x013d }
            kotlin.jvm.internal.InlineMarker.finallyStart(r13)
            monitor-exit(r9)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder r9 = r7.builder()
            r0 = r9
            java.util.Map r0 = (java.util.Map) r0
            r10 = 0
            java.util.Set r11 = r25.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x0060:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0081
            java.lang.Object r12 = r11.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.lang.Object r14 = r1.invoke(r12)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x0060
            java.lang.Object r14 = r12.getKey()
            r0.remove(r14)
            r5 = 1
            goto L_0x0060
        L_0x0081:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r6 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r10 = r9.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r7)
            if (r0 != 0) goto L_0x013a
            r11 = r3
            r12 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r11.getFirstStateRecord()
            java.lang.String r14 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r14)
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0
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
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0130 }
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.getCurrent()     // Catch:{ all -> 0x0130 }
            r16 = r0
            r0 = r11
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x012c }
            r13 = r16
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r14, r0, r13)     // Catch:{ all -> 0x0128 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x0128 }
            r16 = r0
            r21 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync     // Catch:{ all -> 0x0128 }
            r22 = r0
            r23 = 0
            monitor-enter(r22)     // Catch:{ all -> 0x0128 }
            r0 = 0
            r24 = r0
            int r0 = r16.getModification$runtime_release()     // Catch:{ all -> 0x011b }
            if (r0 != r8) goto L_0x00ee
            r1 = r16
            r1.setMap$runtime_release(r10)     // Catch:{ all -> 0x00ec }
            int r0 = r1.getModification$runtime_release()     // Catch:{ all -> 0x00ec }
            r16 = 1
            int r0 = r0 + 1
            r1.setModification$runtime_release(r0)     // Catch:{ all -> 0x00ec }
            r0 = 1
            goto L_0x00f1
        L_0x00ec:
            r0 = move-exception
            goto L_0x011e
        L_0x00ee:
            r1 = r16
            r0 = 0
        L_0x00f1:
            r16 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r16)     // Catch:{ all -> 0x0128 }
            monitor-exit(r22)     // Catch:{ all -> 0x0128 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r16)     // Catch:{ all -> 0x0128 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r16)
            monitor-exit(r18)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r16)
            r1 = r0
            r16 = 0
            r17 = r1
            r1 = r11
            androidx.compose.runtime.snapshots.StateObject r1 = (androidx.compose.runtime.snapshots.StateObject) r1
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r13, r1)
            if (r0 == 0) goto L_0x0117
            goto L_0x013a
        L_0x0117:
            r1 = r26
            goto L_0x0010
        L_0x011b:
            r0 = move-exception
            r1 = r16
        L_0x011e:
            r16 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r16)     // Catch:{ all -> 0x0128 }
            monitor-exit(r22)     // Catch:{ all -> 0x0128 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r16)     // Catch:{ all -> 0x0128 }
            throw r0     // Catch:{ all -> 0x0128 }
        L_0x0128:
            r0 = move-exception
            r16 = r13
            goto L_0x0131
        L_0x012c:
            r0 = move-exception
            r13 = r16
            goto L_0x0131
        L_0x0130:
            r0 = move-exception
        L_0x0131:
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r18)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        L_0x013a:
            return r5
        L_0x013d:
            r0 = move-exception
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r9)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateMap.removeIf$runtime_release(kotlin.jvm.functions.Function1):boolean");
    }

    public final boolean any$runtime_release(Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (Map.Entry entry : (ImmutableSet) getReadable$runtime_release().getMap$runtime_release().entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean all$runtime_release(Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (Map.Entry entry : (ImmutableSet) getReadable$runtime_release().getMap$runtime_release().entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public final Map<K, V> getDebuggerDisplayValue() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return ((StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) firstStateRecord2)).getMap$runtime_release();
    }

    private final <R> R withCurrent(Function1<? super StateMapStateRecord<K, V>, ? extends R> block) {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return block.invoke(SnapshotKt.current((StateMapStateRecord) firstStateRecord2));
    }

    private final <R> R writable(Function1<? super StateMapStateRecord<K, V>, ? extends R> block) {
        Snapshot current;
        R invoke;
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateRecord $this$writable$iv = (StateMapStateRecord) firstStateRecord2;
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

    /* Debug info: failed to restart local var, previous not found, register: 24 */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00be, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c1, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <R> R mutate(kotlin.jvm.functions.Function1<? super java.util.Map<K, V>, ? extends R> r25) {
        /*
            r24 = this;
            r1 = 0
            r0 = 0
            r2 = r0
        L_0x0003:
            r3 = 0
            r4 = 0
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r6 = 0
            monitor-enter(r5)
            r0 = 0
            r7 = r24
            r8 = 0
            r9 = 1
            androidx.compose.runtime.snapshots.StateRecord r10 = r7.getFirstStateRecord()     // Catch:{ all -> 0x00f3 }
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r10 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r10     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.StateRecord r10 = (androidx.compose.runtime.snapshots.StateRecord) r10     // Catch:{ all -> 0x00f3 }
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = androidx.compose.runtime.snapshots.SnapshotKt.current(r10)     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r12     // Catch:{ all -> 0x00f3 }
            r13 = 0
            r7 = r12
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r8 = r7.getMap$runtime_release()     // Catch:{ all -> 0x00f3 }
            r3 = r8
            int r8 = r7.getModification$runtime_release()     // Catch:{ all -> 0x00f3 }
            r4 = r8
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f3 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r9)
            monitor-exit(r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder r5 = r3.builder()
            r7 = r25
            java.lang.Object r2 = r7.invoke(r5)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r6 = r5.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r3)
            if (r0 != 0) goto L_0x00f1
            r8 = r24
            r10 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r8.getFirstStateRecord()
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r11)
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0
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
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x00e7 }
            r18 = r0
            r19 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync     // Catch:{ all -> 0x00e7 }
            r20 = r0
            r21 = 0
            monitor-enter(r20)     // Catch:{ all -> 0x00e7 }
            r0 = 0
            int r9 = r18.getModification$runtime_release()     // Catch:{ all -> 0x00da }
            if (r9 != r4) goto L_0x00b2
            r9 = r18
            r9.setMap$runtime_release(r6)     // Catch:{ all -> 0x00b0 }
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateMap.mutate(kotlin.jvm.functions.Function1):java.lang.Object");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final void update(kotlin.jvm.functions.Function1<? super androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, ? extends V>, ? extends androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, ? extends V>> r27) {
        /*
            r26 = this;
            r1 = 0
            r2 = r26
            r3 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r2.getFirstStateRecord()
            java.lang.String r4 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r4)
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0
            r4 = r0
            androidx.compose.runtime.snapshots.StateRecord r4 = (androidx.compose.runtime.snapshots.StateRecord) r4
            r5 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.current(r4)
            r6 = r0
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r6 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r6
            r7 = 0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r0 = r6.getMap$runtime_release()
            r8 = r27
            java.lang.Object r0 = r8.invoke(r0)
            r9 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r9 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap) r9
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r0 = r6.getMap$runtime_release()
            if (r9 == r0) goto L_0x00b7
            r10 = r26
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r10.getFirstStateRecord()
            java.lang.String r12 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r12)
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0
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
            r19 = 1
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00ac }
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.getCurrent()     // Catch:{ all -> 0x00ac }
            r14 = r0
            r0 = r10
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00ac }
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r12, r0, r14)     // Catch:{ all -> 0x00ac }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x00ac }
            r20 = r0
            r21 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync     // Catch:{ all -> 0x00ac }
            r22 = r0
            r23 = 0
            monitor-enter(r22)     // Catch:{ all -> 0x00ac }
            r0 = 0
            r24 = r1
            r1 = r20
            r1.setMap$runtime_release(r9)     // Catch:{ all -> 0x00a1 }
            int r20 = r1.getModification$runtime_release()     // Catch:{ all -> 0x00a1 }
            r25 = r0
            int r0 = r20 + 1
            r1.setModification$runtime_release(r0)     // Catch:{ all -> 0x00a1 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r19)     // Catch:{ all -> 0x00aa }
            monitor-exit(r22)     // Catch:{ all -> 0x00aa }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r19)     // Catch:{ all -> 0x00aa }
            kotlin.jvm.internal.InlineMarker.finallyStart(r19)
            monitor-exit(r16)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r19)
            r0 = r20
            r1 = 0
            r15 = r10
            androidx.compose.runtime.snapshots.StateObject r15 = (androidx.compose.runtime.snapshots.StateObject) r15
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r14, r15)
            goto L_0x00b9
        L_0x00a1:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r19)     // Catch:{ all -> 0x00aa }
            monitor-exit(r22)     // Catch:{ all -> 0x00aa }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r19)     // Catch:{ all -> 0x00aa }
            throw r0     // Catch:{ all -> 0x00aa }
        L_0x00aa:
            r0 = move-exception
            goto L_0x00af
        L_0x00ac:
            r0 = move-exception
            r24 = r1
        L_0x00af:
            kotlin.jvm.internal.InlineMarker.finallyStart(r19)
            monitor-exit(r16)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r19)
            throw r0
        L_0x00b7:
            r24 = r1
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateMap.update(kotlin.jvm.functions.Function1):void");
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\b\u0000\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "K", "V", "Landroidx/compose/runtime/snapshots/StateRecord;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "getMap$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "setMap$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnapshotStateMap.kt */
    public static final class StateMapStateRecord<K, V> extends StateRecord {
        private PersistentMap<K, ? extends V> map;
        private int modification;

        public final PersistentMap<K, V> getMap$runtime_release() {
            return this.map;
        }

        public final void setMap$runtime_release(PersistentMap<K, ? extends V> persistentMap) {
            Intrinsics.checkNotNullParameter(persistentMap, "<set-?>");
            this.map = persistentMap;
        }

        public StateMapStateRecord(PersistentMap<K, ? extends V> map2) {
            Intrinsics.checkNotNullParameter(map2, "map");
            this.map = map2;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setModification$runtime_release(int i) {
            this.modification = i;
        }

        public void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            StateMapStateRecord other = (StateMapStateRecord) value;
            synchronized (SnapshotStateMapKt.sync) {
                this.map = other.map;
                this.modification = other.modification;
                Unit unit = Unit.INSTANCE;
            }
        }

        public StateRecord create() {
            return new StateMapStateRecord(this.map);
        }
    }
}

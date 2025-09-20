package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u000b\u001a\u00020\t2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\u001d\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0002J\"\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\u001b\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0012H\u0002J\u001c\u0010\u0013\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u0014\u001a\u00020\u000f2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\"\u0010\u0015\u001a\u00020\u000f2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotMapEntrySet;", "K", "V", "Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "add", "", "element", "addAll", "elements", "", "contains", "", "containsAll", "iterator", "", "remove", "removeAll", "retainAll", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateMap.kt */
final class SnapshotMapEntrySet<K, V> extends SnapshotMapSet<K, V, Map.Entry<K, V>> {
    public /* bridge */ /* synthetic */ boolean add(Object element) {
        return ((Boolean) add((Map.Entry) element)).booleanValue();
    }

    public final /* bridge */ boolean contains(Object element) {
        if (!TypeIntrinsics.isMutableMapEntry(element)) {
            return false;
        }
        return contains((Map.Entry) element);
    }

    public final /* bridge */ boolean remove(Object element) {
        if (!TypeIntrinsics.isMutableMapEntry(element)) {
            return false;
        }
        return remove((Map.Entry) element);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapshotMapEntrySet(SnapshotStateMap<K, V> map) {
        super(map);
        Intrinsics.checkNotNullParameter(map, "map");
    }

    public Void add(Map.Entry<K, V> element) {
        Intrinsics.checkNotNullParameter(element, "element");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public Void addAll(Collection<? extends Map.Entry<K, V>> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new StateMapMutableEntriesIterator<>(getMap(), ((ImmutableSet) getMap().getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator());
    }

    public boolean remove(Map.Entry<K, V> element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return getMap().remove(element.getKey()) != null;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean removed = false;
        Iterator<? extends Object> it = elements.iterator();
        while (it.hasNext()) {
            removed = getMap().remove(((Map.Entry) it.next()).getKey()) != null || removed;
        }
        return removed;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public boolean retainAll(java.util.Collection<? extends java.lang.Object> r29) {
        /*
            r28 = this;
            r1 = r29
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = r1
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r2 = 0
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r3)
            int r3 = kotlin.collections.MapsKt.mapCapacity(r3)
            r4 = 16
            int r3 = kotlin.ranges.RangesKt.coerceAtLeast((int) r3, (int) r4)
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>(r3)
            java.util.Map r4 = (java.util.Map) r4
            r5 = r0
            r6 = 0
            java.util.Iterator r7 = r5.iterator()
        L_0x0028:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x004e
            java.lang.Object r8 = r7.next()
            r9 = r8
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            r10 = 0
            java.lang.Object r11 = r9.getKey()
            java.lang.Object r12 = r9.getValue()
            kotlin.Pair r9 = kotlin.TuplesKt.to(r11, r12)
            java.lang.Object r10 = r9.getFirst()
            java.lang.Object r9 = r9.getSecond()
            r4.put(r10, r9)
            goto L_0x0028
        L_0x004e:
            r2 = r4
            androidx.compose.runtime.snapshots.SnapshotStateMap r3 = r28.getMap()
            r4 = 0
            r0 = 0
            r5 = r3
            r6 = 0
            r7 = 0
            r8 = r7
            r7 = r0
        L_0x005c:
            r9 = 0
            r10 = 0
            java.lang.Object r11 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r12 = 0
            monitor-enter(r11)
            r0 = 0
            r13 = r5
            r14 = 0
            androidx.compose.runtime.snapshots.StateRecord r15 = r13.getFirstStateRecord()     // Catch:{ all -> 0x01a7 }
            r16 = r0
            java.lang.String r0 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15, r0)     // Catch:{ all -> 0x01a7 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r15 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r15     // Catch:{ all -> 0x01a7 }
            androidx.compose.runtime.snapshots.StateRecord r15 = (androidx.compose.runtime.snapshots.StateRecord) r15     // Catch:{ all -> 0x01a7 }
            r0 = r15
            r15 = 0
            androidx.compose.runtime.snapshots.StateRecord r17 = androidx.compose.runtime.snapshots.SnapshotKt.current(r0)     // Catch:{ all -> 0x01a7 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r17 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r17     // Catch:{ all -> 0x01a7 }
            r18 = 0
            r0 = r17
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r13 = r0.getMap$runtime_release()     // Catch:{ all -> 0x01a7 }
            r9 = r13
            int r13 = r0.getModification$runtime_release()     // Catch:{ all -> 0x01a7 }
            r10 = r13
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01a7 }
            monitor-exit(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder r11 = r9.builder()
            r0 = r11
            java.util.Map r0 = (java.util.Map) r0
            r12 = 0
            java.util.Set r13 = r3.entrySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x00a8:
            boolean r14 = r13.hasNext()
            r16 = 1
            if (r14 == 0) goto L_0x00eb
            java.lang.Object r14 = r13.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r17 = r14
            r18 = 0
            java.lang.Object r15 = r17.getKey()
            boolean r15 = r2.containsKey(r15)
            if (r15 == 0) goto L_0x00d9
            java.lang.Object r15 = r17.getKey()
            java.lang.Object r15 = r2.get(r15)
            java.lang.Object r1 = r17.getValue()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r1)
            if (r1 != 0) goto L_0x00d7
            goto L_0x00d9
        L_0x00d7:
            r15 = 0
            goto L_0x00db
        L_0x00d9:
            r15 = r16
        L_0x00db:
            if (r15 == 0) goto L_0x00e8
            java.lang.Object r1 = r14.getKey()
            r0.remove(r1)
            r7 = 1
            r1 = r29
            goto L_0x00a8
        L_0x00e8:
            r1 = r29
            goto L_0x00a8
        L_0x00eb:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r8 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r1 = r11.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r9)
            if (r0 != 0) goto L_0x019f
            r12 = r5
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r12.getFirstStateRecord()
            java.lang.String r14 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r14)
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0
            r14 = r0
            androidx.compose.runtime.snapshots.StateRecord r14 = (androidx.compose.runtime.snapshots.StateRecord) r14
            r15 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r17 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            r18 = 0
            java.lang.Object r19 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r20 = 0
            monitor-enter(r19)
            r21 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0198 }
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.getCurrent()     // Catch:{ all -> 0x0198 }
            r17 = r0
            r0 = r12
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x0190 }
            r22 = r2
            r2 = r17
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r14, r0, r2)     // Catch:{ all -> 0x018a }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x018a }
            r17 = r0
            r23 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync     // Catch:{ all -> 0x018a }
            r24 = r0
            r25 = 0
            monitor-enter(r24)     // Catch:{ all -> 0x018a }
            r0 = 0
            r26 = r0
            int r0 = r17.getModification$runtime_release()     // Catch:{ all -> 0x017f }
            if (r0 != r10) goto L_0x0159
            r27 = r3
            r3 = r17
            r3.setMap$runtime_release(r1)     // Catch:{ all -> 0x0157 }
            int r0 = r3.getModification$runtime_release()     // Catch:{ all -> 0x0157 }
            int r0 = r0 + 1
            r3.setModification$runtime_release(r0)     // Catch:{ all -> 0x0157 }
            goto L_0x015f
        L_0x0157:
            r0 = move-exception
            goto L_0x0184
        L_0x0159:
            r27 = r3
            r3 = r17
            r16 = 0
        L_0x015f:
            monitor-exit(r24)     // Catch:{ all -> 0x0186 }
            monitor-exit(r19)
            r0 = r16
            r3 = 0
            r17 = r0
            r0 = r12
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r2, r0)
            if (r16 == 0) goto L_0x0177
            goto L_0x01a3
        L_0x0177:
            r1 = r29
            r2 = r22
            r3 = r27
            goto L_0x005c
        L_0x017f:
            r0 = move-exception
            r27 = r3
            r3 = r17
        L_0x0184:
            monitor-exit(r24)     // Catch:{ all -> 0x0186 }
            throw r0     // Catch:{ all -> 0x0186 }
        L_0x0186:
            r0 = move-exception
            r17 = r2
            goto L_0x019d
        L_0x018a:
            r0 = move-exception
            r27 = r3
            r17 = r2
            goto L_0x019d
        L_0x0190:
            r0 = move-exception
            r22 = r2
            r27 = r3
            r2 = r17
            goto L_0x019d
        L_0x0198:
            r0 = move-exception
            r22 = r2
            r27 = r3
        L_0x019d:
            monitor-exit(r19)
            throw r0
        L_0x019f:
            r22 = r2
            r27 = r3
        L_0x01a3:
            return r7
        L_0x01a7:
            r0 = move-exception
            r22 = r2
            r27 = r3
            monitor-exit(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotMapEntrySet.retainAll(java.util.Collection):boolean");
    }

    public boolean contains(Map.Entry<K, V> element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return Intrinsics.areEqual(getMap().get(element.getKey()), (Object) element.getValue());
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterable<Map.Entry> $this$all$iv = elements;
        if (((Collection) $this$all$iv).isEmpty()) {
            return true;
        }
        for (Map.Entry it : $this$all$iv) {
            if (!contains((Object) it)) {
                return false;
            }
        }
        return true;
    }
}

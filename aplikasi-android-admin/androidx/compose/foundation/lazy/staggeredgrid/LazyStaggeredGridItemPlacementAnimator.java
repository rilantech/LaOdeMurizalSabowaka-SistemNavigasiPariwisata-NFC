package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002JD\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\u001cJ\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J!\u0010*\u001a\u00020\u001c*\u00020\u000f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001c0,H\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000bj\b\u0012\u0004\u0012\u00020\u0001`\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u0004\u0018\u00010\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemPlacementAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/staggeredgrid/ItemInfo;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;)Z", "node", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "getNode", "(Ljava/lang/Object;)Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "initializeNode", "", "item", "mainAxisOffset", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "isVertical", "laneCount", "reset", "startAnimationsIfNeeded", "forEachNode", "block", "Lkotlin/Function1;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridItemPlacementAnimator.kt */
public final class LazyStaggeredGridItemPlacementAnimator {
    private int firstVisibleIndex;
    /* access modifiers changed from: private */
    public LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.Empty;
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyStaggeredGridMeasuredItem> movingAwayToEndBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingInFromStartBound = new ArrayList();

    /* JADX WARNING: Removed duplicated region for block: B:149:0x0347 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0342  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasured(int r35, int r36, int r37, java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r38, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r39, boolean r40, int r41) {
        /*
            r34 = this;
            r0 = r34
            r1 = r35
            r2 = r38
            r3 = r39
            r4 = r41
            java.lang.String r5 = "positionedItems"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r5)
            java.lang.String r5 = "itemProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            r5 = r38
            r6 = 0
            r7 = r5
            r8 = 0
            r9 = 0
            int r10 = r7.size()
        L_0x0022:
            r11 = 0
            if (r9 >= r10) goto L_0x003c
            java.lang.Object r13 = r7.get(r9)
            r14 = r13
            r15 = 0
            r12 = r14
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r12 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r12
            r17 = 0
            boolean r12 = r0.getHasAnimations(r12)
            if (r12 == 0) goto L_0x0038
            r5 = 1
            goto L_0x003e
        L_0x0038:
            int r9 = r9 + 1
            goto L_0x0022
        L_0x003c:
            r5 = r11
        L_0x003e:
            if (r5 != 0) goto L_0x004c
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r5 = r0.keyToItemInfoMap
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x004c
            r34.reset()
            return
        L_0x004c:
            int r5 = r0.firstVisibleIndex
            java.lang.Object r6 = kotlin.collections.CollectionsKt.firstOrNull(r38)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r6 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r6
            if (r6 == 0) goto L_0x005b
            int r6 = r6.getIndex()
            goto L_0x005c
        L_0x005b:
            r6 = r11
        L_0x005c:
            r0.firstVisibleIndex = r6
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r6 = r0.keyIndexMap
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r7 = r39.getKeyIndexMap()
            r0.keyIndexMap = r7
            if (r40 == 0) goto L_0x006b
            r7 = r37
            goto L_0x006d
        L_0x006b:
            r7 = r36
        L_0x006d:
            if (r40 == 0) goto L_0x0074
            long r8 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r11, r1)
            goto L_0x0078
        L_0x0074:
            long r8 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r1, r11)
        L_0x0078:
            java.util.LinkedHashSet<java.lang.Object> r10 = r0.movingAwayKeys
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r12 = r0.keyToItemInfoMap
            java.util.Set r12 = r12.keySet()
            java.util.Collection r12 = (java.util.Collection) r12
            r10.addAll(r12)
            r10 = r38
            r12 = 0
            r13 = 0
            int r14 = r10.size()
        L_0x008f:
            if (r13 >= r14) goto L_0x01ed
            java.lang.Object r17 = r10.get(r13)
            r11 = r17
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r11 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r11
            r19 = 0
            java.util.LinkedHashSet<java.lang.Object> r15 = r0.movingAwayKeys
            java.lang.Object r1 = r11.getKey()
            r15.remove(r1)
            boolean r1 = r0.getHasAnimations(r11)
            if (r1 == 0) goto L_0x01bf
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r1 = r0.keyToItemInfoMap
            java.lang.Object r15 = r11.getKey()
            java.lang.Object r1 = r1.get(r15)
            androidx.compose.foundation.lazy.staggeredgrid.ItemInfo r1 = (androidx.compose.foundation.lazy.staggeredgrid.ItemInfo) r1
            if (r1 != 0) goto L_0x0127
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r15 = r0.keyToItemInfoMap
            r21 = r10
            java.lang.Object r10 = r11.getKey()
            r22 = r12
            androidx.compose.foundation.lazy.staggeredgrid.ItemInfo r12 = new androidx.compose.foundation.lazy.staggeredgrid.ItemInfo
            r23 = r14
            int r14 = r11.getLane()
            int r2 = r11.getSpan()
            int r3 = r11.getCrossAxisOffset()
            r12.<init>(r14, r2, r3)
            r15.put(r10, r12)
            java.lang.Object r2 = r11.getKey()
            int r2 = r6.getIndex(r2)
            r3 = -1
            if (r2 == r3) goto L_0x0105
            int r3 = r11.getIndex()
            if (r3 == r2) goto L_0x0105
            if (r2 >= r5) goto L_0x00f8
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r3 = r0.movingInFromStartBound
            r3.add(r11)
            r24 = r5
            r29 = r6
            r30 = r7
            goto L_0x01d4
        L_0x00f8:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r3 = r0.movingInFromEndBound
            r3.add(r11)
            r24 = r5
            r29 = r6
            r30 = r7
            goto L_0x01d4
        L_0x0105:
            long r14 = r11.m2504getOffsetnOccac()
            r3 = 0
            boolean r10 = r11.isVertical()
            if (r10 == 0) goto L_0x0118
            int r10 = androidx.compose.ui.unit.IntOffset.m7673getYimpl(r14)
            goto L_0x011c
        L_0x0118:
            int r10 = androidx.compose.ui.unit.IntOffset.m7672getXimpl(r14)
        L_0x011c:
            r0.initializeNode(r11, r10)
            r24 = r5
            r29 = r6
            r30 = r7
            goto L_0x01d4
        L_0x0127:
            r21 = r10
            r22 = r12
            r23 = r14
            r2 = r11
            r3 = r34
            r10 = 0
            int r12 = r2.getPlaceablesCount()
            r14 = 0
        L_0x0136:
            if (r14 >= r12) goto L_0x019c
            r15 = r14
            r20 = 0
            r24 = r5
            java.lang.Object r5 = r2.getParentData(r15)
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r5 = r3.getNode(r5)
            if (r5 == 0) goto L_0x0185
            r25 = 0
            r26 = r2
            r27 = r3
            long r2 = r5.m2435getRawOffsetnOccac()
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$Companion r28 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode.Companion
            r29 = r6
            r30 = r7
            long r6 = r28.m2437getNotInitializednOccac()
            boolean r2 = androidx.compose.ui.unit.IntOffset.m7671equalsimpl0(r2, r6)
            if (r2 != 0) goto L_0x0183
            long r2 = r5.m2435getRawOffsetnOccac()
            r6 = 0
            int r7 = androidx.compose.ui.unit.IntOffset.m7672getXimpl(r2)
            int r28 = androidx.compose.ui.unit.IntOffset.m7672getXimpl(r8)
            int r7 = r7 + r28
            int r28 = androidx.compose.ui.unit.IntOffset.m7673getYimpl(r2)
            int r31 = androidx.compose.ui.unit.IntOffset.m7673getYimpl(r8)
            r32 = r2
            int r2 = r28 + r31
            long r2 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r7, r2)
            r5.m2436setRawOffsetgyyYBs(r2)
        L_0x0183:
            goto L_0x018d
        L_0x0185:
            r26 = r2
            r27 = r3
            r29 = r6
            r30 = r7
        L_0x018d:
            int r14 = r14 + 1
            r5 = r24
            r2 = r26
            r3 = r27
            r6 = r29
            r7 = r30
            goto L_0x0136
        L_0x019c:
            r26 = r2
            r27 = r3
            r24 = r5
            r29 = r6
            r30 = r7
            int r2 = r11.getLane()
            r1.setLane(r2)
            int r2 = r11.getSpan()
            r1.setSpan(r2)
            int r2 = r11.getCrossAxisOffset()
            r1.setCrossAxisOffset(r2)
            r0.startAnimationsIfNeeded(r11)
            goto L_0x01d4
        L_0x01bf:
            r24 = r5
            r29 = r6
            r30 = r7
            r21 = r10
            r22 = r12
            r23 = r14
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r1 = r0.keyToItemInfoMap
            java.lang.Object r2 = r11.getKey()
            r1.remove(r2)
        L_0x01d4:
            int r13 = r13 + 1
            r1 = r35
            r2 = r38
            r3 = r39
            r10 = r21
            r12 = r22
            r14 = r23
            r5 = r24
            r6 = r29
            r7 = r30
            r11 = 0
            goto L_0x008f
        L_0x01ed:
            r24 = r5
            r29 = r6
            r30 = r7
            r21 = r10
            r22 = r12
            int[] r1 = new int[r4]
            r2 = 0
        L_0x01fb:
            if (r2 >= r4) goto L_0x0203
            r3 = 0
            r1[r2] = r3
            int r2 = r2 + 1
            goto L_0x01fb
        L_0x0203:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r2 = r0.movingInFromStartBound
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r3 = 1
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x0267
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r2 = r0.movingInFromStartBound
            r5 = 0
            int r6 = r2.size()
            if (r6 <= r3) goto L_0x0225
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1 r3 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
            r6 = r29
            r3.<init>(r6)
            java.util.Comparator r3 = (java.util.Comparator) r3
            kotlin.collections.CollectionsKt.sortWith(r2, r3)
            goto L_0x0227
        L_0x0225:
            r6 = r29
        L_0x0227:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r2 = r0.movingInFromStartBound
            r3 = 0
            r5 = 0
            int r7 = r2.size()
        L_0x0231:
            if (r5 >= r7) goto L_0x025c
            java.lang.Object r10 = r2.get(r5)
            r11 = r10
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r11 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r11
            r12 = 0
            int r13 = r11.getLane()
            r14 = r1[r13]
            int r15 = r11.getMainAxisSize()
            int r14 = r14 + r15
            r1[r13] = r14
            int r13 = r11.getLane()
            r13 = r1[r13]
            r14 = 0
            int r13 = 0 - r13
            r0.initializeNode(r11, r13)
            r0.startAnimationsIfNeeded(r11)
            int r5 = r5 + 1
            goto L_0x0231
        L_0x025c:
            r14 = 6
            r15 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r10 = r1
            kotlin.collections.ArraysKt.fill$default((int[]) r10, (int) r11, (int) r12, (int) r13, (int) r14, (java.lang.Object) r15)
            goto L_0x0269
        L_0x0267:
            r6 = r29
        L_0x0269:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r2 = r0.movingInFromEndBound
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r3 = 1
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x02c7
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r2 = r0.movingInFromEndBound
            r5 = 0
            int r7 = r2.size()
            if (r7 <= r3) goto L_0x0288
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1 r3 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1
            r3.<init>(r6)
            java.util.Comparator r3 = (java.util.Comparator) r3
            kotlin.collections.CollectionsKt.sortWith(r2, r3)
        L_0x0288:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r2 = r0.movingInFromEndBound
            r3 = 0
            r5 = 0
            int r7 = r2.size()
        L_0x0292:
            if (r5 >= r7) goto L_0x02bd
            java.lang.Object r10 = r2.get(r5)
            r11 = r10
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r11 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r11
            r12 = 0
            int r13 = r11.getLane()
            r13 = r1[r13]
            int r13 = r30 + r13
            int r14 = r11.getLane()
            r15 = r1[r14]
            int r17 = r11.getMainAxisSize()
            int r15 = r15 + r17
            r1[r14] = r15
            r0.initializeNode(r11, r13)
            r0.startAnimationsIfNeeded(r11)
            int r5 = r5 + 1
            goto L_0x0292
        L_0x02bd:
            r14 = 6
            r15 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r10 = r1
            kotlin.collections.ArraysKt.fill$default((int[]) r10, (int) r11, (int) r12, (int) r13, (int) r14, (java.lang.Object) r15)
        L_0x02c7:
            java.util.LinkedHashSet<java.lang.Object> r2 = r0.movingAwayKeys
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r3 = 0
            java.util.Iterator r5 = r2.iterator()
        L_0x02d0:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0374
            java.lang.Object r7 = r5.next()
            r10 = r7
            r11 = 0
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r12 = r0.keyToItemInfoMap
            java.lang.Object r12 = kotlin.collections.MapsKt.getValue(r12, r10)
            androidx.compose.foundation.lazy.staggeredgrid.ItemInfo r12 = (androidx.compose.foundation.lazy.staggeredgrid.ItemInfo) r12
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r13 = r0.keyIndexMap
            int r13 = r13.getIndex(r10)
            r14 = -1
            if (r13 != r14) goto L_0x02fc
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r15 = r0.keyToItemInfoMap
            r15.remove(r10)
            r19 = r2
            r22 = r3
            r17 = r12
            r12 = r39
            goto L_0x036d
        L_0x02fc:
            int r15 = r12.getLane()
            int r14 = r12.getSpan()
            long r14 = androidx.compose.foundation.lazy.staggeredgrid.SpanRange.m2508constructorimpl(r15, r14)
            r17 = r12
            r12 = r39
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r14 = r12.m2500getAndMeasurejy6DScQ(r13, r14)
            r15 = 0
            r19 = r2
            int r2 = r14.getPlaceablesCount()
            r21 = r15
            r15 = 0
        L_0x031c:
            if (r15 >= r2) goto L_0x034e
            r22 = r15
            r23 = 0
            r25 = r2
            r2 = r22
            r22 = r3
            java.lang.Object r3 = r14.getParentData(r2)
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r3 = r0.getNode(r3)
            if (r3 == 0) goto L_0x033d
            boolean r3 = r3.isAnimationInProgress()
            r26 = r2
            r2 = 1
            if (r3 != r2) goto L_0x033f
            r2 = 1
            goto L_0x0340
        L_0x033d:
            r26 = r2
        L_0x033f:
            r2 = 0
        L_0x0340:
            if (r2 == 0) goto L_0x0346
            r2 = 1
            r21 = r2
            goto L_0x0347
        L_0x0346:
        L_0x0347:
            int r15 = r15 + 1
            r3 = r22
            r2 = r25
            goto L_0x031c
        L_0x034e:
            r22 = r3
            if (r21 != 0) goto L_0x035e
            int r2 = r6.getIndex(r10)
            if (r13 != r2) goto L_0x035e
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r2 = r0.keyToItemInfoMap
            r2.remove(r10)
            goto L_0x036d
        L_0x035e:
            int r2 = r0.firstVisibleIndex
            if (r13 >= r2) goto L_0x0368
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r2 = r0.movingAwayToStartBound
            r2.add(r14)
            goto L_0x036d
        L_0x0368:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r2 = r0.movingAwayToEndBound
            r2.add(r14)
        L_0x036d:
            r2 = r19
            r3 = r22
            goto L_0x02d0
        L_0x0374:
            r12 = r39
            r19 = r2
            r22 = r3
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r2 = r0.movingAwayToStartBound
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r3 = 1
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x0402
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r2 = r0.movingAwayToStartBound
            r5 = 0
            int r7 = r2.size()
            if (r7 <= r3) goto L_0x0399
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2 r3 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
            r3.<init>(r0)
            java.util.Comparator r3 = (java.util.Comparator) r3
            kotlin.collections.CollectionsKt.sortWith(r2, r3)
        L_0x0399:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r2 = r0.movingAwayToStartBound
            r3 = 0
            r5 = 0
            int r7 = r2.size()
        L_0x03a3:
            if (r5 >= r7) goto L_0x03ec
            java.lang.Object r10 = r2.get(r5)
            r11 = r10
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r11 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r11
            r13 = 0
            int r14 = r11.getLane()
            r15 = r1[r14]
            int r17 = r11.getMainAxisSize()
            int r15 = r15 + r17
            r1[r14] = r15
            int r14 = r11.getLane()
            r14 = r1[r14]
            r15 = 0
            int r14 = 0 - r14
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r15 = r0.keyToItemInfoMap
            r17 = r2
            java.lang.Object r2 = r11.getKey()
            java.lang.Object r2 = kotlin.collections.MapsKt.getValue(r15, r2)
            androidx.compose.foundation.lazy.staggeredgrid.ItemInfo r2 = (androidx.compose.foundation.lazy.staggeredgrid.ItemInfo) r2
            int r15 = r2.getCrossAxisOffset()
            r19 = r13
            r13 = r30
            r11.position(r14, r15, r13)
            r15 = r38
            r15.add(r11)
            r0.startAnimationsIfNeeded(r11)
            int r5 = r5 + 1
            r2 = r17
            goto L_0x03a3
        L_0x03ec:
            r15 = r38
            r17 = r2
            r13 = r30
            r14 = 6
            r2 = 0
            r11 = 0
            r3 = 0
            r5 = 0
            r10 = r1
            r12 = r3
            r3 = r13
            r13 = r5
            r5 = r15
            r15 = r2
            kotlin.collections.ArraysKt.fill$default((int[]) r10, (int) r11, (int) r12, (int) r13, (int) r14, (java.lang.Object) r15)
            goto L_0x0406
        L_0x0402:
            r5 = r38
            r3 = r30
        L_0x0406:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r2 = r0.movingAwayToEndBound
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r7 = 1
            r2 = r2 ^ r7
            if (r2 == 0) goto L_0x0479
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r2 = r0.movingAwayToEndBound
            r10 = 0
            int r11 = r2.size()
            if (r11 <= r7) goto L_0x0425
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2 r7 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2
            r7.<init>(r0)
            java.util.Comparator r7 = (java.util.Comparator) r7
            kotlin.collections.CollectionsKt.sortWith(r2, r7)
        L_0x0425:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r2 = r0.movingAwayToEndBound
            r7 = 0
            r10 = 0
            int r11 = r2.size()
        L_0x042f:
            if (r10 >= r11) goto L_0x0474
            java.lang.Object r12 = r2.get(r10)
            r13 = r12
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r13 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r13
            r14 = 0
            int r15 = r13.getLane()
            r15 = r1[r15]
            int r15 = r15 + r3
            int r16 = r13.getLane()
            r17 = r1[r16]
            int r18 = r13.getMainAxisSize()
            int r17 = r17 + r18
            r1[r16] = r17
            r16 = r1
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r1 = r0.keyToItemInfoMap
            r17 = r2
            java.lang.Object r2 = r13.getKey()
            java.lang.Object r1 = kotlin.collections.MapsKt.getValue(r1, r2)
            androidx.compose.foundation.lazy.staggeredgrid.ItemInfo r1 = (androidx.compose.foundation.lazy.staggeredgrid.ItemInfo) r1
            int r2 = r1.getCrossAxisOffset()
            r13.position(r15, r2, r3)
            r5.add(r13)
            r0.startAnimationsIfNeeded(r13)
            int r10 = r10 + 1
            r1 = r16
            r2 = r17
            goto L_0x042f
        L_0x0474:
            r16 = r1
            r17 = r2
            goto L_0x047b
        L_0x0479:
            r16 = r1
        L_0x047b:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r1 = r0.movingInFromStartBound
            r1.clear()
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r1 = r0.movingInFromEndBound
            r1.clear()
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r1 = r0.movingAwayToStartBound
            r1.clear()
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r1 = r0.movingAwayToEndBound
            r1.clear()
            java.util.LinkedHashSet<java.lang.Object> r1 = r0.movingAwayKeys
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator.onMeasured(int, int, int, java.util.List, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider, boolean, int):void");
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.Empty;
        this.firstVisibleIndex = -1;
    }

    private final void initializeNode(LazyStaggeredGridMeasuredItem item, int mainAxisOffset) {
        long targetFirstPlaceableOffset;
        LazyStaggeredGridItemPlacementAnimator this_$iv;
        LazyStaggeredGridMeasuredItem $this$forEachNode$iv;
        long firstPlaceableOffset = item.m2504getOffsetnOccac();
        if (item.isVertical()) {
            targetFirstPlaceableOffset = IntOffset.m7668copyiSbpLlY$default(firstPlaceableOffset, 0, mainAxisOffset, 1, (Object) null);
        } else {
            targetFirstPlaceableOffset = IntOffset.m7668copyiSbpLlY$default(firstPlaceableOffset, mainAxisOffset, 0, 2, (Object) null);
        }
        LazyStaggeredGridMeasuredItem $this$forEachNode$iv2 = item;
        LazyStaggeredGridItemPlacementAnimator this_$iv2 = this;
        int placeablesCount = $this$forEachNode$iv2.getPlaceablesCount();
        int index$iv = 0;
        while (index$iv < placeablesCount) {
            LazyLayoutAnimateItemModifierNode node = this_$iv2.getNode($this$forEachNode$iv2.getParentData(index$iv));
            if (node != null) {
                long arg0$iv = item.m2504getOffsetnOccac();
                $this$forEachNode$iv = $this$forEachNode$iv2;
                this_$iv = this_$iv2;
                long diffToFirstPlaceableOffset = IntOffsetKt.IntOffset(IntOffset.m7672getXimpl(arg0$iv) - IntOffset.m7672getXimpl(firstPlaceableOffset), IntOffset.m7673getYimpl(arg0$iv) - IntOffset.m7673getYimpl(firstPlaceableOffset));
                node.m2436setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m7672getXimpl(targetFirstPlaceableOffset) + IntOffset.m7672getXimpl(diffToFirstPlaceableOffset), IntOffset.m7673getYimpl(targetFirstPlaceableOffset) + IntOffset.m7673getYimpl(diffToFirstPlaceableOffset)));
            } else {
                $this$forEachNode$iv = $this$forEachNode$iv2;
                this_$iv = this_$iv2;
            }
            index$iv++;
            $this$forEachNode$iv2 = $this$forEachNode$iv;
            this_$iv2 = this_$iv;
        }
    }

    private final void startAnimationsIfNeeded(LazyStaggeredGridMeasuredItem item) {
        LazyStaggeredGridMeasuredItem $this$forEachNode$iv = item;
        int placeablesCount = $this$forEachNode$iv.getPlaceablesCount();
        for (int index$iv = 0; index$iv < placeablesCount; index$iv++) {
            LazyLayoutAnimateItemModifierNode node = getNode($this$forEachNode$iv.getParentData(index$iv));
            if (node != null) {
                long newTarget = item.m2504getOffsetnOccac();
                long currentTarget = node.m2435getRawOffsetnOccac();
                if (!IntOffset.m7671equalsimpl0(currentTarget, LazyLayoutAnimateItemModifierNode.Companion.m2437getNotInitializednOccac()) && !IntOffset.m7671equalsimpl0(currentTarget, newTarget)) {
                    node.m2433animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m7672getXimpl(newTarget) - IntOffset.m7672getXimpl(currentTarget), IntOffset.m7673getYimpl(newTarget) - IntOffset.m7673getYimpl(currentTarget)));
                }
                node.m2436setRawOffsetgyyYBs(newTarget);
            }
        }
    }

    private final LazyLayoutAnimateItemModifierNode getNode(Object $this$node) {
        if ($this$node instanceof LazyLayoutAnimateItemModifierNode) {
            return (LazyLayoutAnimateItemModifierNode) $this$node;
        }
        return null;
    }

    private final boolean getHasAnimations(LazyStaggeredGridMeasuredItem $this$hasAnimations) {
        LazyStaggeredGridMeasuredItem $this$forEachNode$iv = $this$hasAnimations;
        int placeablesCount = $this$forEachNode$iv.getPlaceablesCount();
        for (int index$iv = 0; index$iv < placeablesCount; index$iv++) {
            LazyLayoutAnimateItemModifierNode node = getNode($this$forEachNode$iv.getParentData(index$iv));
            if (node != null) {
                LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode = node;
                return true;
            }
        }
        return false;
    }

    private final void forEachNode(LazyStaggeredGridMeasuredItem $this$forEachNode, Function1<? super LazyLayoutAnimateItemModifierNode, Unit> block) {
        int placeablesCount = $this$forEachNode.getPlaceablesCount();
        for (int index = 0; index < placeablesCount; index++) {
            LazyLayoutAnimateItemModifierNode node = getNode($this$forEachNode.getParentData(index));
            if (node != null) {
                block.invoke(node);
            }
        }
    }
}

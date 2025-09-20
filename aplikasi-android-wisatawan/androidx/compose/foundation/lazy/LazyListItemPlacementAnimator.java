package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J<\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020\u001bJ\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002JE\u0010(\u001a\u00020\u001b*\u00020\u000e26\u0010)\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u001b0*H\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00010\nj\b\u0012\u0004\u0012\u00020\u0001`\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u0004\u0018\u00010\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "", "()V", "activeKeys", "", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/LazyListMeasuredItem;)Z", "node", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "getNode", "(Ljava/lang/Object;)Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "initializeNode", "", "item", "mainAxisOffset", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "isVertical", "reset", "startAnimationsIfNeeded", "forEachNode", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "placeableIndex", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListItemPlacementAnimator.kt */
public final class LazyListItemPlacementAnimator {
    private final Set<Object> activeKeys = new LinkedHashSet();
    private int firstVisibleIndex;
    /* access modifiers changed from: private */
    public LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.Empty;
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyListMeasuredItem> movingAwayToEndBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingInFromStartBound = new ArrayList();

    /* JADX WARNING: Removed duplicated region for block: B:130:0x029b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0296  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasured(int r36, int r37, int r38, java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r39, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider r40, boolean r41) {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            r2 = r37
            r3 = r38
            r4 = r39
            r5 = r40
            java.lang.String r6 = "positionedItems"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            java.lang.String r6 = "itemProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            r6 = r39
            r7 = 0
            r8 = r6
            r9 = 0
            r10 = 0
            int r11 = r8.size()
        L_0x0024:
            r12 = 0
            if (r10 >= r11) goto L_0x003f
            java.lang.Object r14 = r8.get(r10)
            r15 = r14
            r16 = 0
            r13 = r15
            androidx.compose.foundation.lazy.LazyListMeasuredItem r13 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r13
            r18 = 0
            boolean r13 = r0.getHasAnimations(r13)
            if (r13 == 0) goto L_0x003b
            r6 = 1
            goto L_0x0041
        L_0x003b:
            int r10 = r10 + 1
            goto L_0x0024
        L_0x003f:
            r6 = r12
        L_0x0041:
            if (r6 != 0) goto L_0x004f
            java.util.Set<java.lang.Object> r6 = r0.activeKeys
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x004f
            r35.reset()
            return
        L_0x004f:
            int r6 = r0.firstVisibleIndex
            java.lang.Object r7 = kotlin.collections.CollectionsKt.firstOrNull(r39)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r7 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r7
            if (r7 == 0) goto L_0x005e
            int r7 = r7.getIndex()
            goto L_0x005f
        L_0x005e:
            r7 = r12
        L_0x005f:
            r0.firstVisibleIndex = r7
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r7 = r0.keyIndexMap
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r8 = r40.getKeyIndexMap()
            r0.keyIndexMap = r8
            if (r41 == 0) goto L_0x006d
            r8 = r3
            goto L_0x006e
        L_0x006d:
            r8 = r2
        L_0x006e:
            if (r41 == 0) goto L_0x0075
            long r9 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r12, r1)
            goto L_0x0079
        L_0x0075:
            long r9 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r1, r12)
        L_0x0079:
            java.util.LinkedHashSet<java.lang.Object> r11 = r0.movingAwayKeys
            java.util.Set<java.lang.Object> r13 = r0.activeKeys
            java.util.Collection r13 = (java.util.Collection) r13
            r11.addAll(r13)
            r11 = r39
            r13 = 0
            r14 = 0
            int r15 = r11.size()
        L_0x008c:
            if (r14 >= r15) goto L_0x01b9
            java.lang.Object r18 = r11.get(r14)
            r12 = r18
            androidx.compose.foundation.lazy.LazyListMeasuredItem r12 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r12
            r20 = 0
            java.util.LinkedHashSet<java.lang.Object> r1 = r0.movingAwayKeys
            r21 = r11
            java.lang.Object r11 = r12.getKey()
            r1.remove(r11)
            boolean r1 = r0.getHasAnimations(r12)
            if (r1 == 0) goto L_0x0193
            java.util.Set<java.lang.Object> r1 = r0.activeKeys
            java.lang.Object r11 = r12.getKey()
            boolean r1 = r1.contains(r11)
            if (r1 != 0) goto L_0x0113
            java.util.Set<java.lang.Object> r1 = r0.activeKeys
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.Object r11 = r12.getKey()
            r1.add(r11)
            java.lang.Object r1 = r12.getKey()
            int r1 = r7.getIndex(r1)
            r11 = -1
            if (r1 == r11) goto L_0x00ed
            int r11 = r12.getIndex()
            if (r11 == r1) goto L_0x00ed
            if (r1 >= r6) goto L_0x00e0
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r11 = r0.movingInFromStartBound
            r11.add(r12)
            r22 = r6
            r23 = r13
            r24 = r15
            goto L_0x01a2
        L_0x00e0:
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r11 = r0.movingInFromEndBound
            r11.add(r12)
            r22 = r6
            r23 = r13
            r24 = r15
            goto L_0x01a2
        L_0x00ed:
            r11 = 0
            long r22 = r12.m684getOffsetBjo55l4(r11)
            r16 = 0
            boolean r19 = r12.isVertical()
            if (r19 == 0) goto L_0x0102
            int r19 = androidx.compose.ui.unit.IntOffset.m5963getYimpl(r22)
            goto L_0x0106
        L_0x0102:
            int r19 = androidx.compose.ui.unit.IntOffset.m5962getXimpl(r22)
        L_0x0106:
            r11 = r19
            r0.initializeNode(r12, r11)
            r22 = r6
            r23 = r13
            r24 = r15
            goto L_0x01a2
        L_0x0113:
            r1 = r12
            r11 = r35
            r19 = 0
            r22 = r6
            int r6 = r1.getPlaceablesCount()
            r23 = r13
            r13 = 0
        L_0x0121:
            if (r13 >= r6) goto L_0x018b
            r24 = r13
            r25 = 0
            r26 = r6
            r6 = r24
            r24 = r15
            java.lang.Object r15 = r1.getParentData(r6)
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r15 = r11.getNode(r15)
            if (r15 == 0) goto L_0x0179
            r27 = 0
            r28 = r15
            r29 = 0
            r30 = r1
            long r1 = r28.m725getRawOffsetnOccac()
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$Companion r31 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode.Companion
            long r3 = r31.m727getNotInitializednOccac()
            boolean r1 = androidx.compose.ui.unit.IntOffset.m5961equalsimpl0(r1, r3)
            if (r1 != 0) goto L_0x0174
            long r1 = r28.m725getRawOffsetnOccac()
            r3 = 0
            int r4 = androidx.compose.ui.unit.IntOffset.m5962getXimpl(r1)
            int r31 = androidx.compose.ui.unit.IntOffset.m5962getXimpl(r9)
            int r4 = r4 + r31
            int r31 = androidx.compose.ui.unit.IntOffset.m5963getYimpl(r1)
            int r32 = androidx.compose.ui.unit.IntOffset.m5963getYimpl(r9)
            r33 = r1
            int r1 = r31 + r32
            long r1 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r4, r1)
            r3 = r28
            r3.m726setRawOffsetgyyYBs(r1)
            goto L_0x0176
        L_0x0174:
            r3 = r28
        L_0x0176:
            goto L_0x017b
        L_0x0179:
            r30 = r1
        L_0x017b:
            int r13 = r13 + 1
            r2 = r37
            r3 = r38
            r4 = r39
            r15 = r24
            r6 = r26
            r1 = r30
            goto L_0x0121
        L_0x018b:
            r30 = r1
            r24 = r15
            r0.startAnimationsIfNeeded(r12)
            goto L_0x01a2
        L_0x0193:
            r22 = r6
            r23 = r13
            r24 = r15
            java.util.Set<java.lang.Object> r1 = r0.activeKeys
            java.lang.Object r2 = r12.getKey()
            r1.remove(r2)
        L_0x01a2:
            int r14 = r14 + 1
            r1 = r36
            r2 = r37
            r3 = r38
            r4 = r39
            r11 = r21
            r6 = r22
            r13 = r23
            r15 = r24
            r12 = 0
            goto L_0x008c
        L_0x01b9:
            r22 = r6
            r21 = r11
            r23 = r13
            r1 = 0
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r2 = r0.movingInFromStartBound
            r3 = 0
            int r4 = r2.size()
            r6 = 1
            if (r4 <= r6) goto L_0x01d5
            androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1 r4 = new androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
            r4.<init>(r7)
            java.util.Comparator r4 = (java.util.Comparator) r4
            kotlin.collections.CollectionsKt.sortWith(r2, r4)
        L_0x01d5:
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r2 = r0.movingInFromStartBound
            r3 = 0
            r4 = 0
            int r6 = r2.size()
        L_0x01df:
            if (r4 >= r6) goto L_0x01fb
            java.lang.Object r11 = r2.get(r4)
            r12 = r11
            androidx.compose.foundation.lazy.LazyListMeasuredItem r12 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r12
            r13 = 0
            int r14 = r12.getSize()
            int r1 = r1 + r14
            int r14 = 0 - r1
            r0.initializeNode(r12, r14)
            r0.startAnimationsIfNeeded(r12)
            int r4 = r4 + 1
            goto L_0x01df
        L_0x01fb:
            r1 = 0
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r2 = r0.movingInFromEndBound
            r3 = 0
            int r4 = r2.size()
            r6 = 1
            if (r4 <= r6) goto L_0x0211
            androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$1 r4 = new androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$1
            r4.<init>(r7)
            java.util.Comparator r4 = (java.util.Comparator) r4
            kotlin.collections.CollectionsKt.sortWith(r2, r4)
        L_0x0211:
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r2 = r0.movingInFromEndBound
            r3 = 0
            r4 = 0
            int r6 = r2.size()
        L_0x021b:
            if (r4 >= r6) goto L_0x0237
            java.lang.Object r11 = r2.get(r4)
            r12 = r11
            androidx.compose.foundation.lazy.LazyListMeasuredItem r12 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r12
            r13 = 0
            int r14 = r8 + r1
            int r15 = r12.getSize()
            int r1 = r1 + r15
            r0.initializeNode(r12, r14)
            r0.startAnimationsIfNeeded(r12)
            int r4 = r4 + 1
            goto L_0x021b
        L_0x0237:
            java.util.LinkedHashSet<java.lang.Object> r2 = r0.movingAwayKeys
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r3 = 0
            java.util.Iterator r4 = r2.iterator()
        L_0x0241:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x02cc
            java.lang.Object r6 = r4.next()
            r11 = r6
            r12 = 0
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r13 = r0.keyIndexMap
            int r13 = r13.getIndex(r11)
            r14 = -1
            if (r13 != r14) goto L_0x0263
            java.util.Set<java.lang.Object> r15 = r0.activeKeys
            r15.remove(r11)
            r20 = r1
            r24 = r2
            r21 = r3
            goto L_0x02c3
        L_0x0263:
            androidx.compose.foundation.lazy.LazyListMeasuredItem r15 = r5.getAndMeasure(r13)
            r18 = 0
            int r14 = r15.getPlaceablesCount()
            r20 = r1
            r1 = 0
        L_0x0270:
            if (r1 >= r14) goto L_0x02a2
            r21 = r1
            r23 = 0
            r24 = r2
            r2 = r21
            r21 = r3
            java.lang.Object r3 = r15.getParentData(r2)
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r3 = r0.getNode(r3)
            if (r3 == 0) goto L_0x0291
            boolean r3 = r3.isAnimationInProgress()
            r25 = r2
            r2 = 1
            if (r3 != r2) goto L_0x0293
            r2 = 1
            goto L_0x0294
        L_0x0291:
            r25 = r2
        L_0x0293:
            r2 = 0
        L_0x0294:
            if (r2 == 0) goto L_0x029a
            r2 = 1
            r18 = r2
            goto L_0x029b
        L_0x029a:
        L_0x029b:
            int r1 = r1 + 1
            r3 = r21
            r2 = r24
            goto L_0x0270
        L_0x02a2:
            r24 = r2
            r21 = r3
            if (r18 != 0) goto L_0x02b4
            int r1 = r7.getIndex(r11)
            if (r13 != r1) goto L_0x02b4
            java.util.Set<java.lang.Object> r1 = r0.activeKeys
            r1.remove(r11)
            goto L_0x02c3
        L_0x02b4:
            int r1 = r0.firstVisibleIndex
            if (r13 >= r1) goto L_0x02be
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r1 = r0.movingAwayToStartBound
            r1.add(r15)
            goto L_0x02c3
        L_0x02be:
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r1 = r0.movingAwayToEndBound
            r1.add(r15)
        L_0x02c3:
            r1 = r20
            r3 = r21
            r2 = r24
            goto L_0x0241
        L_0x02cc:
            r20 = r1
            r24 = r2
            r21 = r3
            r1 = 0
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r2 = r0.movingAwayToStartBound
            r3 = 0
            int r4 = r2.size()
            r6 = 1
            if (r4 <= r6) goto L_0x02e7
            androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2 r4 = new androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
            r4.<init>(r0)
            java.util.Comparator r4 = (java.util.Comparator) r4
            kotlin.collections.CollectionsKt.sortWith(r2, r4)
        L_0x02e7:
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r2 = r0.movingAwayToStartBound
            r3 = 0
            r4 = 0
            int r6 = r2.size()
        L_0x02f1:
            if (r4 >= r6) goto L_0x031e
            java.lang.Object r11 = r2.get(r4)
            r12 = r11
            androidx.compose.foundation.lazy.LazyListMeasuredItem r12 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r12
            r13 = 0
            int r14 = r12.getSize()
            int r1 = r1 + r14
            int r14 = 0 - r1
            r15 = r37
            r16 = r1
            r1 = r38
            r12.position(r14, r15, r1)
            r18 = r2
            r2 = r39
            r2.add(r12)
            r0.startAnimationsIfNeeded(r12)
            int r4 = r4 + 1
            r1 = r16
            r2 = r18
            goto L_0x02f1
        L_0x031e:
            r15 = r37
            r16 = r1
            r18 = r2
            r1 = r38
            r2 = r39
            r3 = 0
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r4 = r0.movingAwayToEndBound
            r6 = 0
            int r11 = r4.size()
            r12 = 1
            if (r11 <= r12) goto L_0x033e
            androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$2 r11 = new androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$2
            r11.<init>(r0)
            java.util.Comparator r11 = (java.util.Comparator) r11
            kotlin.collections.CollectionsKt.sortWith(r4, r11)
        L_0x033e:
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r4 = r0.movingAwayToEndBound
            r6 = 0
            r11 = 0
            int r12 = r4.size()
        L_0x0348:
            if (r11 >= r12) goto L_0x036d
            java.lang.Object r13 = r4.get(r11)
            r14 = r13
            androidx.compose.foundation.lazy.LazyListMeasuredItem r14 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r14
            r16 = 0
            r17 = r4
            int r4 = r8 + r3
            int r18 = r14.getSize()
            int r3 = r3 + r18
            r14.position(r4, r15, r1)
            r2.add(r14)
            r0.startAnimationsIfNeeded(r14)
            int r11 = r11 + 1
            r4 = r17
            goto L_0x0348
        L_0x036d:
            r17 = r4
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r4 = r0.movingInFromStartBound
            r4.clear()
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r4 = r0.movingInFromEndBound
            r4.clear()
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r4 = r0.movingAwayToStartBound
            r4.clear()
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r4 = r0.movingAwayToEndBound
            r4.clear()
            java.util.LinkedHashSet<java.lang.Object> r4 = r0.movingAwayKeys
            r4.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator.onMeasured(int, int, int, java.util.List, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider, boolean):void");
    }

    public final void reset() {
        this.activeKeys.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.Empty;
        this.firstVisibleIndex = -1;
    }

    private final void initializeNode(LazyListMeasuredItem item, int mainAxisOffset) {
        long targetFirstPlaceableOffset;
        LazyListMeasuredItem $this$forEachNode$iv;
        long targetFirstPlaceableOffset2;
        LazyListMeasuredItem lazyListMeasuredItem = item;
        int i = 0;
        long firstPlaceableOffset = lazyListMeasuredItem.m684getOffsetBjo55l4(0);
        if (item.isVertical()) {
            targetFirstPlaceableOffset = IntOffset.m5958copyiSbpLlY$default(firstPlaceableOffset, 0, mainAxisOffset, 1, (Object) null);
        } else {
            targetFirstPlaceableOffset = IntOffset.m5958copyiSbpLlY$default(firstPlaceableOffset, mainAxisOffset, 0, 2, (Object) null);
        }
        LazyListMeasuredItem $this$forEachNode$iv2 = item;
        int placeablesCount = $this$forEachNode$iv2.getPlaceablesCount();
        while (i < placeablesCount) {
            int index$iv = i;
            LazyLayoutAnimateItemModifierNode it$iv = getNode($this$forEachNode$iv2.getParentData(index$iv));
            if (it$iv != null) {
                long arg0$iv = lazyListMeasuredItem.m684getOffsetBjo55l4(index$iv);
                $this$forEachNode$iv = $this$forEachNode$iv2;
                long diffToFirstPlaceableOffset = IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(arg0$iv) - IntOffset.m5962getXimpl(firstPlaceableOffset), IntOffset.m5963getYimpl(arg0$iv) - IntOffset.m5963getYimpl(firstPlaceableOffset));
                targetFirstPlaceableOffset2 = targetFirstPlaceableOffset;
                it$iv.m726setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(targetFirstPlaceableOffset) + IntOffset.m5962getXimpl(diffToFirstPlaceableOffset), IntOffset.m5963getYimpl(targetFirstPlaceableOffset) + IntOffset.m5963getYimpl(diffToFirstPlaceableOffset)));
            } else {
                targetFirstPlaceableOffset2 = targetFirstPlaceableOffset;
                $this$forEachNode$iv = $this$forEachNode$iv2;
            }
            i++;
            lazyListMeasuredItem = item;
            targetFirstPlaceableOffset = targetFirstPlaceableOffset2;
            $this$forEachNode$iv2 = $this$forEachNode$iv;
        }
    }

    private final void startAnimationsIfNeeded(LazyListMeasuredItem item) {
        int i;
        int $i$f$forEachNode;
        LazyListMeasuredItem $this$forEachNode$iv;
        LazyListItemPlacementAnimator this_$iv;
        LazyListMeasuredItem $this$forEachNode$iv2 = item;
        LazyListItemPlacementAnimator this_$iv2 = this;
        int $i$f$forEachNode2 = 0;
        int placeablesCount = $this$forEachNode$iv2.getPlaceablesCount();
        int i2 = 0;
        while (i2 < placeablesCount) {
            int index$iv = i2;
            LazyLayoutAnimateItemModifierNode it$iv = this_$iv2.getNode($this$forEachNode$iv2.getParentData(index$iv));
            if (it$iv != null) {
                LazyLayoutAnimateItemModifierNode node = it$iv;
                long newTarget = item.m684getOffsetBjo55l4(index$iv);
                $this$forEachNode$iv = $this$forEachNode$iv2;
                this_$iv = this_$iv2;
                long currentTarget = node.m725getRawOffsetnOccac();
                $i$f$forEachNode = $i$f$forEachNode2;
                i = placeablesCount;
                if (IntOffset.m5961equalsimpl0(currentTarget, LazyLayoutAnimateItemModifierNode.Companion.m727getNotInitializednOccac())) {
                } else if (!IntOffset.m5961equalsimpl0(currentTarget, newTarget)) {
                    long j = currentTarget;
                    node.m723animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(newTarget) - IntOffset.m5962getXimpl(currentTarget), IntOffset.m5963getYimpl(newTarget) - IntOffset.m5963getYimpl(currentTarget)));
                }
                node.m726setRawOffsetgyyYBs(newTarget);
            } else {
                LazyListMeasuredItem lazyListMeasuredItem = item;
                $this$forEachNode$iv = $this$forEachNode$iv2;
                this_$iv = this_$iv2;
                $i$f$forEachNode = $i$f$forEachNode2;
                i = placeablesCount;
            }
            i2++;
            this_$iv2 = this_$iv;
            $this$forEachNode$iv2 = $this$forEachNode$iv;
            $i$f$forEachNode2 = $i$f$forEachNode;
            placeablesCount = i;
        }
    }

    private final LazyLayoutAnimateItemModifierNode getNode(Object $this$node) {
        if ($this$node instanceof LazyLayoutAnimateItemModifierNode) {
            return (LazyLayoutAnimateItemModifierNode) $this$node;
        }
        return null;
    }

    private final boolean getHasAnimations(LazyListMeasuredItem $this$hasAnimations) {
        LazyListMeasuredItem $this$forEachNode$iv = $this$hasAnimations;
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

    private final void forEachNode(LazyListMeasuredItem $this$forEachNode, Function2<? super Integer, ? super LazyLayoutAnimateItemModifierNode, Unit> block) {
        int placeablesCount = $this$forEachNode.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            int index = i;
            LazyLayoutAnimateItemModifierNode it = getNode($this$forEachNode.getParentData(index));
            if (it != null) {
                block.invoke(Integer.valueOf(index), it);
            }
        }
    }
}

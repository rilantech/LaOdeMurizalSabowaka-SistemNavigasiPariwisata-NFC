package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002JD\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0014J\u0006\u0010)\u001a\u00020\u001cJ\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J!\u0010+\u001a\u00020\u001c*\u00020\u000f2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001c0-H\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000bj\b\u0012\u0004\u0012\u00020\u0001`\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u0004\u0018\u00010\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006."}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/grid/ItemInfo;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;)Z", "node", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "getNode", "(Ljava/lang/Object;)Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "initializeNode", "", "item", "mainAxisOffset", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "isVertical", "reset", "startAnimationsIfNeeded", "forEachNode", "block", "Lkotlin/Function1;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridItemPlacementAnimator.kt */
public final class LazyGridItemPlacementAnimator {
    private int firstVisibleIndex;
    /* access modifiers changed from: private */
    public LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.Empty;
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyGridMeasuredItem> movingAwayToEndBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingInFromStartBound = new ArrayList();

    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, List<LazyGridMeasuredItem> positionedItems, LazyGridMeasuredItemProvider itemProvider, LazyGridSpanLayoutProvider spanLayoutProvider, boolean isVertical) {
        boolean z;
        long j;
        int previousLineMainAxisSize;
        int previousLine;
        int accumulatedOffset;
        long j2;
        int newIndex;
        int previousLineMainAxisSize2;
        int previousFirstVisibleIndex;
        int i;
        int $i$f$fastForEach;
        List $this$fastForEach$iv;
        LazyGridMeasuredItem $this$forEachNode$iv;
        int i2;
        Object item$iv;
        LazyGridItemPlacementAnimator this_$iv;
        int i3 = consumedScroll;
        List<LazyGridMeasuredItem> list = positionedItems;
        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = spanLayoutProvider;
        Intrinsics.checkNotNullParameter(list, "positionedItems");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(lazyGridSpanLayoutProvider, "spanLayoutProvider");
        List $this$fastForEach$iv$iv = positionedItems;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (true) {
            if (index$iv$iv >= size) {
                z = false;
                break;
            } else if (getHasAnimations((LazyGridMeasuredItem) $this$fastForEach$iv$iv.get(index$iv$iv))) {
                z = true;
                break;
            } else {
                index$iv$iv++;
            }
        }
        if (z || !this.keyToItemInfoMap.isEmpty()) {
            int previousFirstVisibleIndex2 = this.firstVisibleIndex;
            LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) CollectionsKt.firstOrNull(positionedItems);
            this.firstVisibleIndex = lazyGridMeasuredItem != null ? lazyGridMeasuredItem.getIndex() : 0;
            LazyLayoutKeyIndexMap previousKeyToIndexMap = this.keyIndexMap;
            this.keyIndexMap = itemProvider.getKeyIndexMap();
            int mainAxisLayoutSize = isVertical ? layoutHeight : layoutWidth;
            if (isVertical) {
                j = IntOffsetKt.IntOffset(0, i3);
            } else {
                j = IntOffsetKt.IntOffset(i3, 0);
            }
            long scrollOffset = j;
            this.movingAwayKeys.addAll(this.keyToItemInfoMap.keySet());
            List $this$fastForEach$iv2 = positionedItems;
            int $i$f$fastForEach2 = false;
            int index$iv = 0;
            int size2 = $this$fastForEach$iv2.size();
            while (index$iv < size2) {
                Object item$iv2 = $this$fastForEach$iv2.get(index$iv);
                LazyGridMeasuredItem item = (LazyGridMeasuredItem) item$iv2;
                this.movingAwayKeys.remove(item.getKey());
                if (getHasAnimations(item)) {
                    ItemInfo itemInfo = this.keyToItemInfoMap.get(item.getKey());
                    if (itemInfo == null) {
                        $this$fastForEach$iv = $this$fastForEach$iv2;
                        $i$f$fastForEach = $i$f$fastForEach2;
                        i = size2;
                        this.keyToItemInfoMap.put(item.getKey(), new ItemInfo(item.getCrossAxisSize(), item.getCrossAxisOffset()));
                        int previousIndex = previousKeyToIndexMap.getIndex(item.getKey());
                        if (previousIndex == -1 || item.getIndex() == previousIndex) {
                            long it = item.m2425getOffsetnOccac();
                            initializeNode(item, item.isVertical() ? IntOffset.m7673getYimpl(it) : IntOffset.m7672getXimpl(it));
                            previousFirstVisibleIndex = previousFirstVisibleIndex2;
                            LazyGridMeasuredItem lazyGridMeasuredItem2 = item$iv2;
                        } else if (previousIndex < previousFirstVisibleIndex2) {
                            this.movingInFromStartBound.add(item);
                            previousFirstVisibleIndex = previousFirstVisibleIndex2;
                            LazyGridMeasuredItem lazyGridMeasuredItem3 = item$iv2;
                        } else {
                            this.movingInFromEndBound.add(item);
                            previousFirstVisibleIndex = previousFirstVisibleIndex2;
                            LazyGridMeasuredItem lazyGridMeasuredItem4 = item$iv2;
                        }
                    } else {
                        $this$fastForEach$iv = $this$fastForEach$iv2;
                        $i$f$fastForEach = $i$f$fastForEach2;
                        i = size2;
                        LazyGridMeasuredItem $this$forEachNode$iv2 = item;
                        LazyGridItemPlacementAnimator this_$iv2 = this;
                        int $i$f$forEachNode = false;
                        int placeablesCount = $this$forEachNode$iv2.getPlaceablesCount();
                        int index$iv2 = 0;
                        while (index$iv2 < placeablesCount) {
                            int previousFirstVisibleIndex3 = previousFirstVisibleIndex2;
                            int previousFirstVisibleIndex4 = index$iv2;
                            int $i$f$forEachNode2 = $i$f$forEachNode;
                            LazyLayoutAnimateItemModifierNode it2 = this_$iv2.getNode($this$forEachNode$iv2.getParentData(previousFirstVisibleIndex4));
                            if (it2 != null) {
                                int i4 = previousFirstVisibleIndex4;
                                this_$iv = this_$iv2;
                                i2 = placeablesCount;
                                item$iv = item$iv2;
                                if (!IntOffset.m7671equalsimpl0(it2.m2435getRawOffsetnOccac(), LazyLayoutAnimateItemModifierNode.Companion.m2437getNotInitializednOccac())) {
                                    long arg0$iv = it2.m2435getRawOffsetnOccac();
                                    $this$forEachNode$iv = $this$forEachNode$iv2;
                                    it2.m2436setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m7672getXimpl(arg0$iv) + IntOffset.m7672getXimpl(scrollOffset), IntOffset.m7673getYimpl(arg0$iv) + IntOffset.m7673getYimpl(scrollOffset)));
                                } else {
                                    $this$forEachNode$iv = $this$forEachNode$iv2;
                                }
                            } else {
                                $this$forEachNode$iv = $this$forEachNode$iv2;
                                int i5 = previousFirstVisibleIndex4;
                                this_$iv = this_$iv2;
                                i2 = placeablesCount;
                                item$iv = item$iv2;
                            }
                            index$iv2++;
                            $i$f$forEachNode = $i$f$forEachNode2;
                            previousFirstVisibleIndex2 = previousFirstVisibleIndex3;
                            this_$iv2 = this_$iv;
                            item$iv2 = item$iv;
                            placeablesCount = i2;
                            $this$forEachNode$iv2 = $this$forEachNode$iv;
                        }
                        previousFirstVisibleIndex = previousFirstVisibleIndex2;
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator = this_$iv2;
                        int i6 = $i$f$forEachNode;
                        Object obj = item$iv2;
                        itemInfo.setCrossAxisSize(item.getCrossAxisSize());
                        itemInfo.setCrossAxisOffset(item.getCrossAxisOffset());
                        startAnimationsIfNeeded(item);
                    }
                } else {
                    previousFirstVisibleIndex = previousFirstVisibleIndex2;
                    $this$fastForEach$iv = $this$fastForEach$iv2;
                    $i$f$fastForEach = $i$f$fastForEach2;
                    i = size2;
                    Object obj2 = item$iv2;
                    this.keyToItemInfoMap.remove(item.getKey());
                }
                index$iv++;
                int i7 = consumedScroll;
                $this$fastForEach$iv2 = $this$fastForEach$iv;
                $i$f$fastForEach2 = $i$f$fastForEach;
                size2 = i;
                previousFirstVisibleIndex2 = previousFirstVisibleIndex;
            }
            List list2 = $this$fastForEach$iv2;
            int i8 = $i$f$fastForEach2;
            int accumulatedOffset2 = 0;
            int previousLine2 = -1;
            int previousLineMainAxisSize3 = 0;
            List $this$sortByDescending$iv = this.movingInFromStartBound;
            if ($this$sortByDescending$iv.size() > 1) {
                CollectionsKt.sortWith($this$sortByDescending$iv, new LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1(previousKeyToIndexMap));
            }
            List $this$fastForEach$iv3 = this.movingInFromStartBound;
            int $i$f$fastForEach3 = false;
            int index$iv3 = 0;
            int size3 = $this$fastForEach$iv3.size();
            while (index$iv3 < size3) {
                LazyGridMeasuredItem item2 = $this$fastForEach$iv3.get(index$iv3);
                List $this$fastForEach$iv4 = $this$fastForEach$iv3;
                int line = isVertical ? item2.getRow() : item2.getColumn();
                int $i$f$fastForEach4 = $i$f$fastForEach3;
                if (line == -1 || line != previousLine2) {
                    accumulatedOffset2 += previousLineMainAxisSize3;
                    previousLineMainAxisSize3 = item2.getMainAxisSize();
                    previousLine2 = line;
                } else {
                    previousLineMainAxisSize3 = Math.max(previousLineMainAxisSize3, item2.getMainAxisSize());
                }
                initializeNode(item2, (0 - accumulatedOffset2) - item2.getMainAxisSize());
                startAnimationsIfNeeded(item2);
                index$iv3++;
                $this$fastForEach$iv3 = $this$fastForEach$iv4;
                $i$f$fastForEach3 = $i$f$fastForEach4;
            }
            int i9 = $i$f$fastForEach3;
            int accumulatedOffset3 = 0;
            int previousLine3 = -1;
            List $this$sortBy$iv = this.movingInFromEndBound;
            if ($this$sortBy$iv.size() > 1) {
                CollectionsKt.sortWith($this$sortBy$iv, new LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1(previousKeyToIndexMap));
            }
            List $this$fastForEach$iv5 = this.movingInFromEndBound;
            int index$iv4 = 0;
            int size4 = $this$fastForEach$iv5.size();
            int previousLineMainAxisSize4 = 0;
            while (index$iv4 < size4) {
                LazyGridMeasuredItem lazyGridMeasuredItem5 = $this$fastForEach$iv5.get(index$iv4);
                LazyGridMeasuredItem item3 = lazyGridMeasuredItem5;
                LazyGridMeasuredItem lazyGridMeasuredItem6 = lazyGridMeasuredItem5;
                int line2 = isVertical ? item3.getRow() : item3.getColumn();
                List $this$fastForEach$iv6 = $this$fastForEach$iv5;
                if (line2 == -1 || line2 != previousLine3) {
                    accumulatedOffset3 += previousLineMainAxisSize4;
                    previousLineMainAxisSize2 = item3.getMainAxisSize();
                    previousLine3 = line2;
                } else {
                    previousLineMainAxisSize2 = Math.max(previousLineMainAxisSize4, item3.getMainAxisSize());
                }
                previousLineMainAxisSize4 = previousLineMainAxisSize2;
                initializeNode(item3, mainAxisLayoutSize + accumulatedOffset3);
                startAnimationsIfNeeded(item3);
                index$iv4++;
                $this$fastForEach$iv5 = $this$fastForEach$iv6;
            }
            for (Object key : this.movingAwayKeys) {
                ItemInfo itemInfo2 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, key);
                int newIndex2 = this.keyIndexMap.getIndex(key);
                if (newIndex2 == -1) {
                    this.keyToItemInfoMap.remove(key);
                    accumulatedOffset = accumulatedOffset3;
                    previousLine = previousLine3;
                    int i10 = newIndex2;
                    Object obj3 = key;
                } else {
                    if (isVertical) {
                        j2 = Constraints.Companion.m7508fixedWidthOenEA2s(itemInfo2.getCrossAxisSize());
                    } else {
                        j2 = Constraints.Companion.m7507fixedHeightOenEA2s(itemInfo2.getCrossAxisSize());
                    }
                    long j3 = j2;
                    int newIndex3 = newIndex2;
                    accumulatedOffset = accumulatedOffset3;
                    previousLine = previousLine3;
                    Object key2 = key;
                    LazyGridMeasuredItem item4 = LazyGridMeasuredItemProvider.m2427getAndMeasure3p2s80s$default(itemProvider, newIndex2, 0, j3, 2, (Object) null);
                    boolean inProgress = false;
                    int placeablesCount2 = item4.getPlaceablesCount();
                    for (int it3 = 0; it3 < placeablesCount2; it3++) {
                        LazyLayoutAnimateItemModifierNode node = getNode(item4.getParentData(it3));
                        if (node != null && node.isAnimationInProgress()) {
                            inProgress = true;
                        }
                    }
                    if (!inProgress) {
                        newIndex = newIndex3;
                        if (newIndex == previousKeyToIndexMap.getIndex(key2)) {
                            this.keyToItemInfoMap.remove(key2);
                        }
                    } else {
                        newIndex = newIndex3;
                    }
                    if (newIndex < this.firstVisibleIndex) {
                        this.movingAwayToStartBound.add(item4);
                    } else {
                        this.movingAwayToEndBound.add(item4);
                    }
                }
                accumulatedOffset3 = accumulatedOffset;
                previousLine3 = previousLine;
            }
            int i11 = previousLine3;
            int accumulatedOffset4 = 0;
            int previousLine4 = -1;
            int previousLineMainAxisSize5 = 0;
            List $this$sortByDescending$iv2 = this.movingAwayToStartBound;
            if ($this$sortByDescending$iv2.size() > 1) {
                CollectionsKt.sortWith($this$sortByDescending$iv2, new LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2(this));
            }
            List $this$fastForEach$iv7 = this.movingAwayToStartBound;
            int $i$f$fastForEach5 = false;
            int index$iv5 = 0;
            int size5 = $this$fastForEach$iv7.size();
            while (index$iv5 < size5) {
                LazyGridMeasuredItem item5 = $this$fastForEach$iv7.get(index$iv5);
                List $this$fastForEach$iv8 = $this$fastForEach$iv7;
                int line3 = lazyGridSpanLayoutProvider.getLineIndexOfItem(item5.getIndex());
                int $i$f$fastForEach6 = $i$f$fastForEach5;
                if (line3 == -1 || line3 != previousLine4) {
                    accumulatedOffset4 += previousLineMainAxisSize5;
                    previousLineMainAxisSize5 = item5.getMainAxisSize();
                    previousLine4 = line3;
                } else {
                    previousLineMainAxisSize5 = Math.max(previousLineMainAxisSize5, item5.getMainAxisSize());
                }
                LazyGridMeasuredItem.position$default(item5, (0 - accumulatedOffset4) - item5.getMainAxisSize(), ((ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, item5.getKey())).getCrossAxisOffset(), layoutWidth, layoutHeight, 0, 0, 48, (Object) null);
                list.add(item5);
                startAnimationsIfNeeded(item5);
                index$iv5++;
                $this$fastForEach$iv7 = $this$fastForEach$iv8;
                $i$f$fastForEach5 = $i$f$fastForEach6;
                accumulatedOffset4 = accumulatedOffset4;
                previousLine4 = previousLine4;
            }
            int i12 = $i$f$fastForEach5;
            int accumulatedOffset5 = 0;
            int previousLine5 = -1;
            int previousLineMainAxisSize6 = 0;
            List $this$sortBy$iv2 = this.movingAwayToEndBound;
            if ($this$sortBy$iv2.size() > 1) {
                CollectionsKt.sortWith($this$sortBy$iv2, new LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2(this));
            }
            List $this$fastForEach$iv9 = this.movingAwayToEndBound;
            int index$iv6 = 0;
            int size6 = $this$fastForEach$iv9.size();
            while (index$iv6 < size6) {
                LazyGridMeasuredItem item6 = $this$fastForEach$iv9.get(index$iv6);
                List $this$fastForEach$iv10 = $this$fastForEach$iv9;
                int line4 = lazyGridSpanLayoutProvider.getLineIndexOfItem(item6.getIndex());
                if (line4 == -1 || line4 != previousLine5) {
                    accumulatedOffset5 += previousLineMainAxisSize6;
                    previousLineMainAxisSize = item6.getMainAxisSize();
                    previousLine5 = line4;
                } else {
                    previousLineMainAxisSize = Math.max(previousLineMainAxisSize6, item6.getMainAxisSize());
                }
                previousLineMainAxisSize6 = previousLineMainAxisSize;
                LazyGridMeasuredItem.position$default(item6, mainAxisLayoutSize + accumulatedOffset5, ((ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, item6.getKey())).getCrossAxisOffset(), layoutWidth, layoutHeight, 0, 0, 48, (Object) null);
                list.add(item6);
                startAnimationsIfNeeded(item6);
                index$iv6++;
                lazyGridSpanLayoutProvider = spanLayoutProvider;
                $this$fastForEach$iv9 = $this$fastForEach$iv10;
                accumulatedOffset5 = accumulatedOffset5;
                previousLine5 = previousLine5;
            }
            this.movingInFromStartBound.clear();
            this.movingInFromEndBound.clear();
            this.movingAwayToStartBound.clear();
            this.movingAwayToEndBound.clear();
            this.movingAwayKeys.clear();
            return;
        }
        reset();
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.Empty;
        this.firstVisibleIndex = -1;
    }

    private final void initializeNode(LazyGridMeasuredItem item, int mainAxisOffset) {
        long targetFirstPlaceableOffset;
        LazyGridItemPlacementAnimator this_$iv;
        LazyGridMeasuredItem $this$forEachNode$iv;
        long firstPlaceableOffset = item.m2425getOffsetnOccac();
        if (item.isVertical()) {
            targetFirstPlaceableOffset = IntOffset.m7668copyiSbpLlY$default(firstPlaceableOffset, 0, mainAxisOffset, 1, (Object) null);
        } else {
            targetFirstPlaceableOffset = IntOffset.m7668copyiSbpLlY$default(firstPlaceableOffset, mainAxisOffset, 0, 2, (Object) null);
        }
        LazyGridMeasuredItem $this$forEachNode$iv2 = item;
        LazyGridItemPlacementAnimator this_$iv2 = this;
        int placeablesCount = $this$forEachNode$iv2.getPlaceablesCount();
        int index$iv = 0;
        while (index$iv < placeablesCount) {
            LazyLayoutAnimateItemModifierNode node = this_$iv2.getNode($this$forEachNode$iv2.getParentData(index$iv));
            if (node != null) {
                long arg0$iv = item.m2425getOffsetnOccac();
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

    private final void startAnimationsIfNeeded(LazyGridMeasuredItem item) {
        LazyGridMeasuredItem $this$forEachNode$iv = item;
        int placeablesCount = $this$forEachNode$iv.getPlaceablesCount();
        for (int index$iv = 0; index$iv < placeablesCount; index$iv++) {
            LazyLayoutAnimateItemModifierNode node = getNode($this$forEachNode$iv.getParentData(index$iv));
            if (node != null) {
                long newTarget = item.m2425getOffsetnOccac();
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

    private final boolean getHasAnimations(LazyGridMeasuredItem $this$hasAnimations) {
        LazyGridMeasuredItem $this$forEachNode$iv = $this$hasAnimations;
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

    private final void forEachNode(LazyGridMeasuredItem $this$forEachNode, Function1<? super LazyLayoutAnimateItemModifierNode, Unit> block) {
        int placeablesCount = $this$forEachNode.getPlaceablesCount();
        for (int index = 0; index < placeablesCount; index++) {
            LazyLayoutAnimateItemModifierNode node = getNode($this$forEachNode.getParentData(index));
            if (node != null) {
                block.invoke(node);
            }
        }
    }
}

package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"calculateLazyLayoutPinnedIndices", "", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "pinnedItemList", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutBeyondBoundsState.kt */
public final class LazyLayoutBeyondBoundsStateKt {
    public static final List<Integer> calculateLazyLayoutPinnedIndices(LazyLayoutItemProvider $this$calculateLazyLayoutPinnedIndices, LazyLayoutPinnedItemList pinnedItemList, LazyLayoutBeyondBoundsInfo beyondBoundsInfo) {
        IntRange beyondBoundsRange;
        LazyLayoutItemProvider lazyLayoutItemProvider = $this$calculateLazyLayoutPinnedIndices;
        LazyLayoutPinnedItemList lazyLayoutPinnedItemList = pinnedItemList;
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "<this>");
        Intrinsics.checkNotNullParameter(lazyLayoutPinnedItemList, "pinnedItemList");
        Intrinsics.checkNotNullParameter(beyondBoundsInfo, "beyondBoundsInfo");
        if (!beyondBoundsInfo.hasIntervals() && pinnedItemList.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List pinnedItems = new ArrayList();
        if (beyondBoundsInfo.hasIntervals()) {
            beyondBoundsRange = new IntRange(beyondBoundsInfo.getStart(), Math.min(beyondBoundsInfo.getEnd(), $this$calculateLazyLayoutPinnedIndices.getItemCount() - 1));
        } else {
            beyondBoundsRange = IntRange.Companion.getEMPTY();
        }
        List $this$fastForEach$iv = lazyLayoutPinnedItemList;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            LazyLayoutPinnedItemList.PinnedItem it = (LazyLayoutPinnedItemList.PinnedItem) $this$fastForEach$iv.get(index$iv);
            int index = LazyLayoutItemProviderKt.findIndexByKey(lazyLayoutItemProvider, it.getKey(), it.getIndex());
            boolean z = false;
            if (!(index <= beyondBoundsRange.getLast() && beyondBoundsRange.getFirst() <= index)) {
                if (index >= 0 && index < $this$calculateLazyLayoutPinnedIndices.getItemCount()) {
                    z = true;
                }
                if (z) {
                    pinnedItems.add(Integer.valueOf(index));
                }
            }
        }
        int i = beyondBoundsRange.getFirst();
        int last = beyondBoundsRange.getLast();
        if (i <= last) {
            while (true) {
                pinnedItems.add(Integer.valueOf(i));
                if (i == last) {
                    break;
                }
                i++;
            }
        }
        return pinnedItems;
    }
}

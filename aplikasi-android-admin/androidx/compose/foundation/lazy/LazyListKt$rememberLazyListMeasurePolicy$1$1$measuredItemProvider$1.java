package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"androidx/compose/foundation/lazy/LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "createItem", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "index", "", "key", "", "contentType", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyList.kt */
public final class LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 extends LazyListMeasuredItemProvider {
    final /* synthetic */ int $afterContentPadding;
    final /* synthetic */ int $beforeContentPadding;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ int $itemsCount;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ int $spaceBetweenItems;
    final /* synthetic */ LazyLayoutMeasureScope $this_null;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ long $visualItemOffset;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(long $contentConstraints, boolean $isVertical2, LazyListItemProvider $itemProvider, LazyLayoutMeasureScope $this_null2, int $itemsCount2, int $spaceBetweenItems2, Alignment.Horizontal $horizontalAlignment2, Alignment.Vertical $verticalAlignment2, boolean $reverseLayout2, int $beforeContentPadding2, int $afterContentPadding2, long $visualItemOffset2) {
        super($contentConstraints, $isVertical2, $itemProvider, $this_null2, (DefaultConstructorMarker) null);
        this.$isVertical = $isVertical2;
        this.$this_null = $this_null2;
        this.$itemsCount = $itemsCount2;
        this.$spaceBetweenItems = $spaceBetweenItems2;
        this.$horizontalAlignment = $horizontalAlignment2;
        this.$verticalAlignment = $verticalAlignment2;
        this.$reverseLayout = $reverseLayout2;
        this.$beforeContentPadding = $beforeContentPadding2;
        this.$afterContentPadding = $afterContentPadding2;
        this.$visualItemOffset = $visualItemOffset2;
    }

    public LazyListMeasuredItem createItem(int index, Object key, Object contentType, List<? extends Placeable> placeables) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(placeables, "placeables");
        return new LazyListMeasuredItem(index, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, index == this.$itemsCount + -1 ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, key, contentType, (DefaultConstructorMarker) null);
    }
}

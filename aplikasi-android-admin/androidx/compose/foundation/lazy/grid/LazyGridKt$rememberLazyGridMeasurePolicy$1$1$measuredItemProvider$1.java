package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"androidx/compose/foundation/lazy/grid/LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "createItem", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "index", "", "key", "", "contentType", "crossAxisSize", "mainAxisSpacing", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
public final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 extends LazyGridMeasuredItemProvider {
    final /* synthetic */ int $afterContentPadding;
    final /* synthetic */ int $beforeContentPadding;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyLayoutMeasureScope $this_null;
    final /* synthetic */ long $visualItemOffset;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1(LazyGridItemProvider $itemProvider, LazyLayoutMeasureScope $this_null2, int $spaceBetweenLines, boolean $isVertical2, boolean $reverseLayout2, int $beforeContentPadding2, int $afterContentPadding2, long $visualItemOffset2) {
        super($itemProvider, $this_null2, $spaceBetweenLines);
        this.$this_null = $this_null2;
        this.$isVertical = $isVertical2;
        this.$reverseLayout = $reverseLayout2;
        this.$beforeContentPadding = $beforeContentPadding2;
        this.$afterContentPadding = $afterContentPadding2;
        this.$visualItemOffset = $visualItemOffset2;
    }

    public LazyGridMeasuredItem createItem(int index, Object key, Object contentType, int crossAxisSize, int mainAxisSpacing, List<? extends Placeable> placeables) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(placeables, "placeables");
        LayoutDirection layoutDirection = this.$this_null.getLayoutDirection();
        return new LazyGridMeasuredItem(index, key, this.$isVertical, crossAxisSize, mainAxisSpacing, this.$reverseLayout, layoutDirection, this.$beforeContentPadding, this.$afterContentPadding, placeables, this.$visualItemOffset, contentType, (DefaultConstructorMarker) null);
    }
}

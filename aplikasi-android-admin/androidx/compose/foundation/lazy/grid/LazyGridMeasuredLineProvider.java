package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0016\u0010\u0017J<\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\u0007H&ø\u0001\u0002¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0007J\u001e\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b'\u0010(R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "", "isVertical", "", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "gridItemsCount", "", "spaceBetweenLines", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "(ZLandroidx/compose/foundation/lazy/grid/LazyGridSlots;IILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;)V", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "startSlot", "span", "childConstraints-JhjzzOo$foundation_release", "(II)J", "createLine", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "index", "items", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "mainAxisSpacing", "(I[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;Ljava/util/List;I)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "getAndMeasure", "lineIndex", "itemConstraints", "itemIndex", "itemConstraints-OenEA2s", "(I)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridMeasuredLineProvider.kt */
public abstract class LazyGridMeasuredLineProvider {
    private final int gridItemsCount;
    private final boolean isVertical;
    private final LazyGridMeasuredItemProvider measuredItemProvider;
    private final LazyGridSlots slots;
    private final int spaceBetweenLines;
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    public abstract LazyGridMeasuredLine createLine(int i, LazyGridMeasuredItem[] lazyGridMeasuredItemArr, List<GridItemSpan> list, int i2);

    public LazyGridMeasuredLineProvider(boolean isVertical2, LazyGridSlots slots2, int gridItemsCount2, int spaceBetweenLines2, LazyGridMeasuredItemProvider measuredItemProvider2, LazyGridSpanLayoutProvider spanLayoutProvider2) {
        Intrinsics.checkNotNullParameter(slots2, "slots");
        Intrinsics.checkNotNullParameter(measuredItemProvider2, "measuredItemProvider");
        Intrinsics.checkNotNullParameter(spanLayoutProvider2, "spanLayoutProvider");
        this.isVertical = isVertical2;
        this.slots = slots2;
        this.gridItemsCount = gridItemsCount2;
        this.spaceBetweenLines = spaceBetweenLines2;
        this.measuredItemProvider = measuredItemProvider2;
        this.spanLayoutProvider = spanLayoutProvider2;
    }

    /* renamed from: childConstraints-JhjzzOo$foundation_release  reason: not valid java name */
    public final long m2429childConstraintsJhjzzOo$foundation_release(int startSlot, int span) {
        int i;
        if (span == 1) {
            i = this.slots.getSizes()[startSlot];
        } else {
            int endSlot = (startSlot + span) - 1;
            i = (this.slots.getPositions()[endSlot] + this.slots.getSizes()[endSlot]) - this.slots.getPositions()[startSlot];
        }
        int crossAxisSize = RangesKt.coerceAtLeast(i, 0);
        if (this.isVertical) {
            return Constraints.Companion.m7508fixedWidthOenEA2s(crossAxisSize);
        }
        return Constraints.Companion.m7507fixedHeightOenEA2s(crossAxisSize);
    }

    /* renamed from: itemConstraints-OenEA2s  reason: not valid java name */
    public final long m2430itemConstraintsOenEA2s(int itemIndex) {
        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = this.spanLayoutProvider;
        return m2429childConstraintsJhjzzOo$foundation_release(0, lazyGridSpanLayoutProvider.spanOf(itemIndex, lazyGridSpanLayoutProvider.getSlotsPerLine()));
    }

    public final LazyGridMeasuredLine getAndMeasure(int lineIndex) {
        int mainAxisSpacing;
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = this.spanLayoutProvider.getLineConfiguration(lineIndex);
        int lineItemsCount = lineConfiguration.getSpans().size();
        if (lineItemsCount == 0 || lineConfiguration.getFirstItemIndex() + lineItemsCount == this.gridItemsCount) {
            mainAxisSpacing = 0;
        } else {
            mainAxisSpacing = this.spaceBetweenLines;
        }
        int startSlot = 0;
        LazyGridMeasuredItem[] items = new LazyGridMeasuredItem[lineItemsCount];
        for (int i = 0; i < lineItemsCount; i++) {
            int span = GridItemSpan.m2404getCurrentLineSpanimpl(lineConfiguration.getSpans().get(i).m2407unboximpl());
            LazyGridMeasuredItem r9 = this.measuredItemProvider.m2428getAndMeasure3p2s80s(lineConfiguration.getFirstItemIndex() + i, mainAxisSpacing, m2429childConstraintsJhjzzOo$foundation_release(startSlot, span));
            LazyGridMeasuredItem lazyGridMeasuredItem = r9;
            startSlot += span;
            Unit unit = Unit.INSTANCE;
            items[i] = r9;
        }
        return createLine(lineIndex, items, lineConfiguration.getSpans(), mainAxisSpacing);
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.measuredItemProvider.getKeyIndexMap();
    }
}

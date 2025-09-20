package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\u0006\u0010\t\u001a\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R+\u0010\u0015\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\""}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "(II)V", "hadFirstNotEmptyLayout", "", "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "lastKnownFirstItemKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "requestPosition", "", "update", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridScrollPosition.kt */
public final class LazyGridScrollPosition {
    private boolean hadFirstNotEmptyLayout;
    private final MutableIntState index$delegate;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableIntState scrollOffset$delegate;

    public LazyGridScrollPosition() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public LazyGridScrollPosition(int initialIndex, int initialScrollOffset) {
        this.index$delegate = SnapshotIntStateKt.mutableIntStateOf(initialIndex);
        this.scrollOffset$delegate = SnapshotIntStateKt.mutableIntStateOf(initialScrollOffset);
        this.nearestRangeState = new LazyLayoutNearestRangeState(initialIndex, 90, 200);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyGridScrollPosition(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    private final void setIndex(int i) {
        this.index$delegate.setIntValue(i);
    }

    public final int getIndex() {
        return this.index$delegate.getIntValue();
    }

    private final void setScrollOffset(int i) {
        this.scrollOffset$delegate.setIntValue(i);
    }

    public final int getScrollOffset() {
        return this.scrollOffset$delegate.getIntValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r0 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) kotlin.collections.ArraysKt.firstOrNull((T[]) (r0 = r0.getItems()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateFromMeasureResult(androidx.compose.foundation.lazy.grid.LazyGridMeasureResult r5) {
        /*
            r4 = this;
            java.lang.String r0 = "measureResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r0 = r5.getFirstVisibleLine()
            if (r0 == 0) goto L_0x001f
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r0 = r0.getItems()
            if (r0 == 0) goto L_0x001f
            java.lang.Object r0 = kotlin.collections.ArraysKt.firstOrNull((T[]) r0)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r0 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r0
            if (r0 == 0) goto L_0x001f
            java.lang.Object r0 = r0.getKey()
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            r4.lastKnownFirstItemKey = r0
            boolean r0 = r4.hadFirstNotEmptyLayout
            if (r0 != 0) goto L_0x002c
            int r0 = r5.getTotalItemsCount()
            if (r0 <= 0) goto L_0x005a
        L_0x002c:
            r0 = 1
            r4.hadFirstNotEmptyLayout = r0
            int r1 = r5.getFirstVisibleLineScrollOffset()
            float r2 = (float) r1
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            r3 = 0
            if (r2 < 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r0 = r3
        L_0x003c:
            if (r0 == 0) goto L_0x005b
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r0 = r5.getFirstVisibleLine()
            if (r0 == 0) goto L_0x0056
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r0 = r0.getItems()
            if (r0 == 0) goto L_0x0056
            java.lang.Object r0 = kotlin.collections.ArraysKt.firstOrNull((T[]) r0)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r0 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r0
            if (r0 == 0) goto L_0x0056
            int r3 = r0.getIndex()
        L_0x0056:
            r0 = r3
            r4.update(r0, r1)
        L_0x005a:
            return
        L_0x005b:
            r0 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "scrollOffset should be non-negative ("
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            r3 = 41
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r0 = r2.toString()
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridScrollPosition.updateFromMeasureResult(androidx.compose.foundation.lazy.grid.LazyGridMeasureResult):void");
    }

    public final void requestPosition(int index, int scrollOffset) {
        update(index, scrollOffset);
        this.lastKnownFirstItemKey = null;
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved(LazyGridItemProvider itemProvider, int index) {
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        int newIndex = LazyLayoutItemProviderKt.findIndexByKey(itemProvider, this.lastKnownFirstItemKey, index);
        if (index != newIndex) {
            setIndex(newIndex);
            this.nearestRangeState.update(index);
        }
        return newIndex;
    }

    private final void update(int index, int scrollOffset) {
        if (((float) index) >= 0.0f) {
            setIndex(index);
            this.nearestRangeState.update(index);
            setScrollOffset(scrollOffset);
            return;
        }
        throw new IllegalArgumentException(("Index should be non-negative (" + index + ')').toString());
    }
}

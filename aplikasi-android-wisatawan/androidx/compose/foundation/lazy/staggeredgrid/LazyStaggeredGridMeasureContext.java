package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001Bv\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0018J*\u0010>\u001a\u000209*\u00020\b2\u0006\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0006ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0012\u00108\u001a\u00020\u000e*\u00020\b2\u0006\u0010?\u001a\u00020\u0006R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u001c\u0010\u000b\u001a\u00020\fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010 R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0016\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0019\u00108\u001a\u00020\u000e*\u0002098Æ\u0002ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0019\u0010%\u001a\u00020\u0006*\u0002098Æ\u0002ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b<\u0010=\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006C"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "mainAxisAvailableSize", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "beforeContentPadding", "afterContentPadding", "reverseLayout", "mainAxisSpacing", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZLandroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJIIZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfterContentPadding", "()I", "getBeforeContentPadding", "getConstraints-msEJaDk", "()J", "J", "getContentOffset-nOcc-ac", "()Z", "getItemProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "laneCount", "getLaneCount", "laneInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getLaneInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getMainAxisAvailableSize", "getMainAxisSpacing", "getMeasureScope", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "getMeasuredItemProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "getPinnedItems", "()Ljava/util/List;", "getResolvedSlots", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "getReverseLayout", "getState", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "isFullSpan", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "isFullSpan-SZVOQXA", "(J)Z", "getLaneInfo-SZVOQXA", "(J)I", "getSpanRange", "itemIndex", "lane", "getSpanRange-lOCCd4c", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;II)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
public final class LazyStaggeredGridMeasureContext {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final long constraints;
    private final long contentOffset;
    private final boolean isVertical;
    private final LazyStaggeredGridItemProvider itemProvider;
    private final int laneCount;
    private final LazyStaggeredGridLaneInfo laneInfo;
    private final int mainAxisAvailableSize;
    private final int mainAxisSpacing;
    private final LazyLayoutMeasureScope measureScope;
    private final LazyStaggeredGridMeasureProvider measuredItemProvider;
    private final List<Integer> pinnedItems;
    private final LazyStaggeredGridSlots resolvedSlots;
    private final boolean reverseLayout;
    private final LazyStaggeredGridState state;

    public /* synthetic */ LazyStaggeredGridMeasureContext(LazyStaggeredGridState lazyStaggeredGridState, List list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j2, int i2, int i3, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i2, i3, z2, i4);
    }

    private LazyStaggeredGridMeasureContext(LazyStaggeredGridState state2, List<Integer> pinnedItems2, LazyStaggeredGridItemProvider itemProvider2, LazyStaggeredGridSlots resolvedSlots2, long constraints2, boolean isVertical2, LazyLayoutMeasureScope measureScope2, int mainAxisAvailableSize2, long contentOffset2, int beforeContentPadding2, int afterContentPadding2, boolean reverseLayout2, int mainAxisSpacing2) {
        LazyStaggeredGridState lazyStaggeredGridState = state2;
        List<Integer> list = pinnedItems2;
        LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider = itemProvider2;
        LazyStaggeredGridSlots lazyStaggeredGridSlots = resolvedSlots2;
        LazyLayoutMeasureScope lazyLayoutMeasureScope = measureScope2;
        Intrinsics.checkNotNullParameter(lazyStaggeredGridState, "state");
        Intrinsics.checkNotNullParameter(list, "pinnedItems");
        Intrinsics.checkNotNullParameter(lazyStaggeredGridItemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(lazyStaggeredGridSlots, "resolvedSlots");
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "measureScope");
        this.state = lazyStaggeredGridState;
        this.pinnedItems = list;
        this.itemProvider = lazyStaggeredGridItemProvider;
        this.resolvedSlots = lazyStaggeredGridSlots;
        this.constraints = constraints2;
        this.isVertical = isVertical2;
        this.measureScope = lazyLayoutMeasureScope;
        this.mainAxisAvailableSize = mainAxisAvailableSize2;
        this.contentOffset = contentOffset2;
        this.beforeContentPadding = beforeContentPadding2;
        this.afterContentPadding = afterContentPadding2;
        this.reverseLayout = reverseLayout2;
        this.mainAxisSpacing = mainAxisSpacing2;
        this.measuredItemProvider = new LazyStaggeredGridMeasureContext$measuredItemProvider$1(this, isVertical2, itemProvider2, measureScope2, resolvedSlots2);
        this.laneInfo = state2.getLaneInfo$foundation_release();
        this.laneCount = resolvedSlots2.getSizes().length;
    }

    public final LazyStaggeredGridState getState() {
        return this.state;
    }

    public final List<Integer> getPinnedItems() {
        return this.pinnedItems;
    }

    public final LazyStaggeredGridItemProvider getItemProvider() {
        return this.itemProvider;
    }

    public final LazyStaggeredGridSlots getResolvedSlots() {
        return this.resolvedSlots;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public final long m779getConstraintsmsEJaDk() {
        return this.constraints;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final LazyLayoutMeasureScope getMeasureScope() {
        return this.measureScope;
    }

    public final int getMainAxisAvailableSize() {
        return this.mainAxisAvailableSize;
    }

    /* renamed from: getContentOffset-nOcc-ac  reason: not valid java name */
    public final long m780getContentOffsetnOccac() {
        return this.contentOffset;
    }

    public final int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    public final int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public final int getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    public final LazyStaggeredGridMeasureProvider getMeasuredItemProvider() {
        return this.measuredItemProvider;
    }

    public final LazyStaggeredGridLaneInfo getLaneInfo() {
        return this.laneInfo;
    }

    public final int getLaneCount() {
        return this.laneCount;
    }

    public final boolean isFullSpan(LazyStaggeredGridItemProvider $this$isFullSpan, int itemIndex) {
        Intrinsics.checkNotNullParameter($this$isFullSpan, "<this>");
        return $this$isFullSpan.getSpanProvider().isFullSpan(itemIndex);
    }

    /* renamed from: getSpanRange-lOCCd4c  reason: not valid java name */
    public final long m782getSpanRangelOCCd4c(LazyStaggeredGridItemProvider $this$getSpanRange_u2dlOCCd4c, int itemIndex, int lane) {
        Intrinsics.checkNotNullParameter($this$getSpanRange_u2dlOCCd4c, "$this$getSpanRange");
        boolean isFullSpan = $this$getSpanRange_u2dlOCCd4c.getSpanProvider().isFullSpan(itemIndex);
        return SpanRange.m798constructorimpl(isFullSpan ? 0 : lane, isFullSpan ? this.laneCount : 1);
    }

    /* renamed from: isFullSpan-SZVOQXA  reason: not valid java name */
    public final boolean m783isFullSpanSZVOQXA(long $this$isFullSpan) {
        return ((int) (4294967295L & $this$isFullSpan)) - ((int) ($this$isFullSpan >> 32)) != 1;
    }

    /* renamed from: getLaneInfo-SZVOQXA  reason: not valid java name */
    public final int m781getLaneInfoSZVOQXA(long $this$laneInfo) {
        long $this$isFullSpan$iv = $this$laneInfo;
        int i = 1;
        if (((int) (4294967295L & $this$isFullSpan$iv)) - ((int) ($this$isFullSpan$iv >> 32)) == 1) {
            i = 0;
        }
        if (i != 0) {
            return -2;
        }
        return (int) ($this$laneInfo >> 32);
    }
}

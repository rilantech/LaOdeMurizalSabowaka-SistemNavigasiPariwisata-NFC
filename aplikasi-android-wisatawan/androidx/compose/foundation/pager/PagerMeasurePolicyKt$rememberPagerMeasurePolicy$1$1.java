package androidx.compose.foundation.pager;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "containerConstraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;J)Landroidx/compose/foundation/pager/PagerMeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerMeasurePolicy.kt */
final class PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult> {
    final /* synthetic */ int $beyondBoundsPageCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Function0<PagerLazyLayoutItemProvider> $itemProviderLambda;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ Function0<Integer> $pageCount;
    final /* synthetic */ PageSize $pageSize;
    final /* synthetic */ float $pageSpacing;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ PagerState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(Orientation orientation, PaddingValues paddingValues, boolean z, PagerState pagerState, float f, PageSize pageSize, Function0<PagerLazyLayoutItemProvider> function0, Function0<Integer> function02, Alignment.Vertical vertical, Alignment.Horizontal horizontal, int i) {
        super(2);
        this.$orientation = orientation;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$state = pagerState;
        this.$pageSpacing = f;
        this.$pageSize = pageSize;
        this.$itemProviderLambda = function0;
        this.$pageCount = function02;
        this.$verticalAlignment = vertical;
        this.$horizontalAlignment = horizontal;
        this.$beyondBoundsPageCount = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m826invoke0kLqBqw((LazyLayoutMeasureScope) p1, ((Constraints) p2).m5794unboximpl());
    }

    /* Debug info: failed to restart local var, previous not found, register: 42 */
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final PagerMeasureResult m826invoke0kLqBqw(LazyLayoutMeasureScope $this$null, long containerConstraints) {
        int i;
        int i2;
        int i3;
        int i4;
        long visualItemOffset;
        int i5;
        int i6;
        int firstVisiblePage;
        Snapshot previous$iv$iv;
        Snapshot this_$iv$iv;
        int spaceBetweenPages;
        int mainAxisAvailableSize;
        int firstVisiblePageOffset;
        LazyLayoutMeasureScope lazyLayoutMeasureScope = $this$null;
        long j = containerConstraints;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
        boolean isVertical = this.$orientation == Orientation.Vertical;
        CheckScrollableContainerConstraintsKt.m195checkScrollableContainerConstraintsK40F9xA(j, isVertical ? Orientation.Vertical : Orientation.Horizontal);
        if (isVertical) {
            i = lazyLayoutMeasureScope.m5819roundToPx0680j_4(this.$contentPadding.m553calculateLeftPaddingu2uoSUM($this$null.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope.m5819roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, $this$null.getLayoutDirection()));
        }
        int startPadding = i;
        if (isVertical) {
            i2 = lazyLayoutMeasureScope.m5819roundToPx0680j_4(this.$contentPadding.m554calculateRightPaddingu2uoSUM($this$null.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope.m5819roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, $this$null.getLayoutDirection()));
        }
        int endPadding = i2;
        int topPadding = lazyLayoutMeasureScope.m5819roundToPx0680j_4(this.$contentPadding.m555calculateTopPaddingD9Ej5fM());
        int bottomPadding = lazyLayoutMeasureScope.m5819roundToPx0680j_4(this.$contentPadding.m552calculateBottomPaddingD9Ej5fM());
        final int totalVerticalPadding = topPadding + bottomPadding;
        final int totalHorizontalPadding = startPadding + endPadding;
        int totalMainAxisPadding = isVertical ? totalVerticalPadding : totalHorizontalPadding;
        if (isVertical && !this.$reverseLayout) {
            i3 = topPadding;
        } else if (isVertical && this.$reverseLayout) {
            i3 = bottomPadding;
        } else if (isVertical || this.$reverseLayout) {
            i3 = endPadding;
        } else {
            i3 = startPadding;
        }
        int beforeContentPadding = i3;
        int afterContentPadding = totalMainAxisPadding - beforeContentPadding;
        long contentConstraints = ConstraintsKt.m5804offsetNN6EwU(j, -totalHorizontalPadding, -totalVerticalPadding);
        this.$state.setDensity$foundation_release(lazyLayoutMeasureScope);
        int spaceBetweenPages2 = lazyLayoutMeasureScope.m5819roundToPx0680j_4(this.$pageSpacing);
        if (isVertical) {
            i4 = Constraints.m5787getMaxHeightimpl(containerConstraints) - totalVerticalPadding;
        } else {
            i4 = Constraints.m5788getMaxWidthimpl(containerConstraints) - totalHorizontalPadding;
        }
        int mainAxisAvailableSize2 = i4;
        if (!this.$reverseLayout || mainAxisAvailableSize2 > 0) {
            visualItemOffset = IntOffsetKt.IntOffset(startPadding, topPadding);
        } else {
            visualItemOffset = IntOffsetKt.IntOffset(isVertical ? startPadding : startPadding + mainAxisAvailableSize2, isVertical ? topPadding + mainAxisAvailableSize2 : topPadding);
        }
        int pageAvailableSize = this.$pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope, mainAxisAvailableSize2, spaceBetweenPages2);
        PagerState pagerState = this.$state;
        if (this.$orientation == Orientation.Vertical) {
            i5 = Constraints.m5788getMaxWidthimpl(contentConstraints);
        } else {
            i5 = pageAvailableSize;
        }
        if (this.$orientation != Orientation.Vertical) {
            i6 = Constraints.m5787getMaxHeightimpl(contentConstraints);
        } else {
            i6 = pageAvailableSize;
        }
        pagerState.m830setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, i5, 0, i6, 5, (Object) null));
        Snapshot.Companion this_$iv = Snapshot.Companion;
        PagerState pagerState2 = this.$state;
        Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
        Snapshot this_$iv$iv2 = snapshot$iv;
        try {
            Snapshot previous$iv$iv2 = this_$iv$iv2.makeCurrent();
            try {
                this_$iv$iv = this_$iv$iv2;
                firstVisiblePage = pagerState2.getFirstVisiblePage$foundation_release();
                spaceBetweenPages = spaceBetweenPages2;
                try {
                    mainAxisAvailableSize = mainAxisAvailableSize2;
                    try {
                        if (Intrinsics.areEqual((Object) pagerState2.getLayoutInfo$foundation_release(), (Object) PagerStateKt.getEmptyLayoutInfo())) {
                            try {
                                firstVisiblePageOffset = MathKt.roundToInt(pagerState2.getInitialPageOffsetFraction() * ((float) pageAvailableSize));
                            } catch (Throwable th) {
                                th = th;
                                int i7 = pageAvailableSize;
                                int i8 = totalHorizontalPadding;
                                int i9 = totalVerticalPadding;
                                int pageAvailableSize2 = topPadding;
                                int i10 = startPadding;
                                previous$iv$iv = previous$iv$iv2;
                                int i11 = mainAxisAvailableSize;
                                int mainAxisAvailableSize3 = spaceBetweenPages;
                                try {
                                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                                    throw th;
                                } catch (Throwable th2) {
                                    th = th2;
                                    int i12 = firstVisiblePage;
                                    snapshot$iv.dispose();
                                    throw th;
                                }
                            }
                        } else {
                            firstVisiblePageOffset = pagerState2.getFirstVisiblePageOffset$foundation_release();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        int i13 = pageAvailableSize;
                        int i14 = totalHorizontalPadding;
                        int i15 = totalVerticalPadding;
                        int pageAvailableSize3 = topPadding;
                        int i16 = startPadding;
                        previous$iv$iv = previous$iv$iv2;
                        int i17 = mainAxisAvailableSize;
                        int mainAxisAvailableSize4 = spaceBetweenPages;
                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                        throw th;
                    }
                    try {
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th4) {
                        th = th4;
                        int i18 = pageAvailableSize;
                        int i19 = totalHorizontalPadding;
                        int i20 = totalVerticalPadding;
                        int pageAvailableSize4 = topPadding;
                        int i21 = startPadding;
                        previous$iv$iv = previous$iv$iv2;
                        int i22 = mainAxisAvailableSize;
                        int mainAxisAvailableSize5 = spaceBetweenPages;
                        int i23 = firstVisiblePageOffset;
                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    int i24 = pageAvailableSize;
                    int i25 = mainAxisAvailableSize2;
                    int i26 = totalHorizontalPadding;
                    int i27 = totalVerticalPadding;
                    int pageAvailableSize5 = topPadding;
                    int mainAxisAvailableSize6 = startPadding;
                    previous$iv$iv = previous$iv$iv2;
                    int i28 = spaceBetweenPages;
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                int i29 = pageAvailableSize;
                int i30 = spaceBetweenPages2;
                int i31 = mainAxisAvailableSize2;
                int i32 = totalHorizontalPadding;
                int i33 = totalVerticalPadding;
                int pageAvailableSize6 = topPadding;
                int mainAxisAvailableSize7 = startPadding;
                this_$iv$iv = this_$iv$iv2;
                previous$iv$iv = previous$iv$iv2;
                firstVisiblePage = 0;
                this_$iv$iv.restoreCurrent(previous$iv$iv);
                throw th;
            }
            try {
                this_$iv$iv.restoreCurrent(previous$iv$iv2);
                snapshot$iv.dispose();
                PagerLazyLayoutItemProvider itemProvider = this.$itemProviderLambda.invoke();
                int pageAvailableSize7 = pageAvailableSize;
                final LazyLayoutMeasureScope lazyLayoutMeasureScope2 = $this$null;
                final long j2 = containerConstraints;
                int i34 = totalHorizontalPadding;
                int i35 = totalVerticalPadding;
                int i36 = topPadding;
                int i37 = startPadding;
                PagerMeasureResult it = PagerMeasureKt.m824measurePagerntgEbfI($this$null, this.$pageCount.invoke().intValue(), itemProvider, mainAxisAvailableSize, beforeContentPadding, afterContentPadding, spaceBetweenPages, firstVisiblePage, firstVisiblePageOffset, this.$state.getScrollToBeConsumed$foundation_release(), contentConstraints, this.$orientation, this.$verticalAlignment, this.$horizontalAlignment, this.$reverseLayout, visualItemOffset, pageAvailableSize7, this.$beyondBoundsPageCount, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(itemProvider, this.$state.getPinnedPages$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release()), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                        return invoke(((Number) p1).intValue(), ((Number) p2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) p3);
                    }

                    public final MeasureResult invoke(int width, int height, Function1<? super Placeable.PlacementScope, Unit> placement) {
                        Intrinsics.checkNotNullParameter(placement, "placement");
                        return lazyLayoutMeasureScope2.layout(ConstraintsKt.m5802constrainWidthK40F9xA(j2, totalHorizontalPadding + width), ConstraintsKt.m5801constrainHeightK40F9xA(j2, totalVerticalPadding + height), MapsKt.emptyMap(), placement);
                    }
                });
                this.$state.applyMeasureResult$foundation_release(it);
                return it;
            } catch (Throwable th7) {
                th = th7;
                int i38 = pageAvailableSize;
                int i39 = totalHorizontalPadding;
                int i40 = totalVerticalPadding;
                int pageAvailableSize8 = topPadding;
                int i41 = startPadding;
                int i42 = mainAxisAvailableSize;
                int mainAxisAvailableSize8 = spaceBetweenPages;
                int i43 = firstVisiblePage;
                int i44 = firstVisiblePageOffset;
                snapshot$iv.dispose();
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            int i45 = pageAvailableSize;
            int i46 = spaceBetweenPages2;
            int i47 = mainAxisAvailableSize2;
            int i48 = totalHorizontalPadding;
            int i49 = totalVerticalPadding;
            int pageAvailableSize9 = topPadding;
            int mainAxisAvailableSize9 = startPadding;
            snapshot$iv.dispose();
            throw th;
        }
    }
}

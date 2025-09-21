package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
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

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "containerConstraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;J)Landroidx/compose/foundation/lazy/LazyListMeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyList.kt */
final class LazyListKt$rememberLazyListMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult> {
    final /* synthetic */ int $beyondBoundsItemCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function0<LazyListItemProvider> $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListKt$rememberLazyListMeasurePolicy$1$1(boolean z, PaddingValues paddingValues, boolean z2, LazyListState lazyListState, Function0<? extends LazyListItemProvider> function0, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, Alignment.Horizontal horizontal2, Alignment.Vertical vertical2) {
        super(2);
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$state = lazyListState;
        this.$itemProviderLambda = function0;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$beyondBoundsItemCount = i;
        this.$horizontalAlignment = horizontal2;
        this.$verticalAlignment = vertical2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m676invoke0kLqBqw((LazyLayoutMeasureScope) p1, ((Constraints) p2).m5794unboximpl());
    }

    /* Debug info: failed to restart local var, previous not found, register: 52 */
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyListMeasureResult m676invoke0kLqBqw(LazyLayoutMeasureScope $this$null, long containerConstraints) {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        long visualItemOffset;
        LazyLayoutMeasureScope lazyLayoutMeasureScope = $this$null;
        long j = containerConstraints;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
        CheckScrollableContainerConstraintsKt.m195checkScrollableContainerConstraintsK40F9xA(j, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        if (this.$isVertical) {
            i = lazyLayoutMeasureScope.m5819roundToPx0680j_4(this.$contentPadding.m553calculateLeftPaddingu2uoSUM($this$null.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope.m5819roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, $this$null.getLayoutDirection()));
        }
        int startPadding = i;
        if (this.$isVertical) {
            i2 = lazyLayoutMeasureScope.m5819roundToPx0680j_4(this.$contentPadding.m554calculateRightPaddingu2uoSUM($this$null.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope.m5819roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, $this$null.getLayoutDirection()));
        }
        int endPadding = i2;
        int topPadding = lazyLayoutMeasureScope.m5819roundToPx0680j_4(this.$contentPadding.m555calculateTopPaddingD9Ej5fM());
        int bottomPadding = lazyLayoutMeasureScope.m5819roundToPx0680j_4(this.$contentPadding.m552calculateBottomPaddingD9Ej5fM());
        int totalVerticalPadding = topPadding + bottomPadding;
        int totalHorizontalPadding = startPadding + endPadding;
        boolean z = this.$isVertical;
        int totalMainAxisPadding = z ? totalVerticalPadding : totalHorizontalPadding;
        if (z && !this.$reverseLayout) {
            i3 = topPadding;
        } else if (z && this.$reverseLayout) {
            i3 = bottomPadding;
        } else if (z || this.$reverseLayout) {
            i3 = endPadding;
        } else {
            i3 = startPadding;
        }
        int beforeContentPadding = i3;
        int afterContentPadding = totalMainAxisPadding - beforeContentPadding;
        long contentConstraints = ConstraintsKt.m5804offsetNN6EwU(j, -totalHorizontalPadding, -totalVerticalPadding);
        this.$state.setDensity$foundation_release(lazyLayoutMeasureScope);
        LazyListItemProvider itemProvider = this.$itemProviderLambda.invoke();
        itemProvider.getItemScope().setMaxSize(Constraints.m5788getMaxWidthimpl(contentConstraints), Constraints.m5787getMaxHeightimpl(contentConstraints));
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical != null) {
                f = vertical.m444getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal != null) {
                f = horizontal.m430getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        float spaceBetweenItemsDp = f;
        int spaceBetweenItems = lazyLayoutMeasureScope.m5819roundToPx0680j_4(spaceBetweenItemsDp);
        int itemsCount = itemProvider.getItemCount();
        if (this.$isVertical) {
            i4 = Constraints.m5787getMaxHeightimpl(containerConstraints) - totalVerticalPadding;
        } else {
            i4 = Constraints.m5788getMaxWidthimpl(containerConstraints) - totalHorizontalPadding;
        }
        int mainAxisAvailableSize = i4;
        if (!this.$reverseLayout || mainAxisAvailableSize > 0) {
            visualItemOffset = IntOffsetKt.IntOffset(startPadding, topPadding);
        } else {
            boolean z2 = this.$isVertical;
            visualItemOffset = IntOffsetKt.IntOffset(z2 ? startPadding : startPadding + mainAxisAvailableSize, z2 ? topPadding + mainAxisAvailableSize : topPadding);
        }
        float f2 = spaceBetweenItemsDp;
        LazyListItemProvider itemProvider2 = itemProvider;
        int totalHorizontalPadding2 = totalHorizontalPadding;
        int totalVerticalPadding2 = totalVerticalPadding;
        int i5 = topPadding;
        int i6 = startPadding;
        LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 measuredItemProvider = new LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(contentConstraints, this.$isVertical, itemProvider, $this$null, itemsCount, spaceBetweenItems, this.$horizontalAlignment, this.$verticalAlignment, this.$reverseLayout, beforeContentPadding, afterContentPadding, visualItemOffset);
        this.$state.m687setPremeasureConstraintsBRTryo0$foundation_release(measuredItemProvider.m685getChildConstraintsmsEJaDk());
        Snapshot.Companion this_$iv = Snapshot.Companion;
        LazyListState lazyListState = this.$state;
        Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
        Snapshot this_$iv$iv = snapshot$iv;
        try {
            Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
            try {
                LazyListItemProvider itemProvider3 = itemProvider2;
                try {
                    int firstVisibleItemIndex = lazyListState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(itemProvider3, lazyListState.getFirstVisibleItemIndex());
                    try {
                        int firstVisibleScrollOffset = lazyListState.getFirstVisibleItemScrollOffset();
                        try {
                            Unit unit = Unit.INSTANCE;
                            try {
                                this_$iv$iv.restoreCurrent(previous$iv$iv);
                                snapshot$iv.dispose();
                                final LazyLayoutMeasureScope lazyLayoutMeasureScope2 = $this$null;
                                final long j2 = containerConstraints;
                                final int i7 = totalHorizontalPadding2;
                                final int i8 = totalVerticalPadding2;
                                LazyListMeasureResult it = LazyListMeasureKt.m680measureLazyListCD5nmq0(itemsCount, measuredItemProvider, mainAxisAvailableSize, beforeContentPadding, afterContentPadding, spaceBetweenItems, firstVisibleItemIndex, firstVisibleScrollOffset, this.$state.getScrollToBeConsumed$foundation_release(), contentConstraints, this.$isVertical, itemProvider3.getHeaderIndexes(), this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, $this$null, this.$state.getPlacementAnimator$foundation_release(), this.$beyondBoundsItemCount, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(itemProvider3, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release()), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                                        return invoke(((Number) p1).intValue(), ((Number) p2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) p3);
                                    }

                                    public final MeasureResult invoke(int width, int height, Function1<? super Placeable.PlacementScope, Unit> placement) {
                                        Intrinsics.checkNotNullParameter(placement, "placement");
                                        return lazyLayoutMeasureScope2.layout(ConstraintsKt.m5802constrainWidthK40F9xA(j2, i7 + width), ConstraintsKt.m5801constrainHeightK40F9xA(j2, i8 + height), MapsKt.emptyMap(), placement);
                                    }
                                });
                                this.$state.applyMeasureResult$foundation_release(it);
                                return it;
                            } catch (Throwable th) {
                                th = th;
                                int i9 = firstVisibleItemIndex;
                                int i10 = firstVisibleScrollOffset;
                                snapshot$iv.dispose();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            int i11 = firstVisibleItemIndex;
                            int i12 = firstVisibleScrollOffset;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        int i13 = firstVisibleItemIndex;
                        try {
                            this_$iv$iv.restoreCurrent(previous$iv$iv);
                            throw th;
                        } catch (Throwable th4) {
                            th = th4;
                            snapshot$iv.dispose();
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                LazyListItemProvider lazyListItemProvider = itemProvider2;
                this_$iv$iv.restoreCurrent(previous$iv$iv);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            LazyListItemProvider lazyListItemProvider2 = itemProvider2;
            snapshot$iv.dispose();
            throw th;
        }
    }
}

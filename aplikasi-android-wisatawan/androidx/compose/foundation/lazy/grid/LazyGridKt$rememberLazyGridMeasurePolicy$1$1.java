package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "containerConstraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;J)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function0<LazyGridItemProvider> $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ Function2<Density, Constraints, LazyGridSlots> $slots;
    final /* synthetic */ LazyGridState $state;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridKt$rememberLazyGridMeasurePolicy$1$1(boolean z, PaddingValues paddingValues, boolean z2, Function0<? extends LazyGridItemProvider> function0, Function2<? super Density, ? super Constraints, LazyGridSlots> function2, LazyGridState lazyGridState, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal) {
        super(2);
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$itemProviderLambda = function0;
        this.$slots = function2;
        this.$state = lazyGridState;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m709invoke0kLqBqw((LazyLayoutMeasureScope) p1, ((Constraints) p2).m5794unboximpl());
    }

    /* Debug info: failed to restart local var, previous not found, register: 53 */
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyGridMeasureResult m709invoke0kLqBqw(LazyLayoutMeasureScope $this$null, long containerConstraints) {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        long visualItemOffset;
        Snapshot previous$iv$iv;
        Snapshot this_$iv$iv;
        int itemsCount;
        int firstVisibleLineScrollOffset;
        int firstVisibleLineIndex;
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
        LazyGridItemProvider itemProvider = this.$itemProviderLambda.invoke();
        LazyGridSpanLayoutProvider spanLayoutProvider = itemProvider.getSpanLayoutProvider();
        LazyGridSlots resolvedSlots = this.$slots.invoke(lazyLayoutMeasureScope, Constraints.m5776boximpl(containerConstraints));
        int slotsPerLine = resolvedSlots.getSizes().length;
        spanLayoutProvider.setSlotsPerLine(slotsPerLine);
        this.$state.setDensity$foundation_release(lazyLayoutMeasureScope);
        this.$state.setSlotsPerLine$foundation_release(slotsPerLine);
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
        float spaceBetweenLinesDp = f;
        int spaceBetweenLines = lazyLayoutMeasureScope.m5819roundToPx0680j_4(spaceBetweenLinesDp);
        int itemsCount2 = itemProvider.getItemCount();
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
        int itemsCount3 = itemsCount2;
        float f2 = spaceBetweenLinesDp;
        int i5 = slotsPerLine;
        LazyGridSpanLayoutProvider spanLayoutProvider2 = spanLayoutProvider;
        LazyGridItemProvider itemProvider2 = itemProvider;
        int totalHorizontalPadding2 = totalHorizontalPadding;
        int totalVerticalPadding2 = totalVerticalPadding;
        int i6 = topPadding;
        LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 measuredItemProvider = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1(itemProvider, $this$null, spaceBetweenLines, this.$isVertical, this.$reverseLayout, beforeContentPadding, afterContentPadding, visualItemOffset);
        final LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 measuredLineProvider = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1(this.$isVertical, resolvedSlots, itemsCount3, spaceBetweenLines, measuredItemProvider, spanLayoutProvider2);
        final LazyGridSpanLayoutProvider spanLayoutProvider3 = spanLayoutProvider2;
        this.$state.setPrefetchInfoRetriever$foundation_release(new Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final ArrayList<Pair<Integer, Constraints>> invoke(int line) {
                LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = spanLayoutProvider3.getLineConfiguration(line);
                int index = lineConfiguration.getFirstItemIndex();
                int slot = 0;
                ArrayList result = new ArrayList(lineConfiguration.getSpans().size());
                List $this$fastForEach$iv = lineConfiguration.getSpans();
                LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = measuredLineProvider;
                int index$iv = 0;
                int size = $this$fastForEach$iv.size();
                while (index$iv < size) {
                    int span = GridItemSpan.m694getCurrentLineSpanimpl($this$fastForEach$iv.get(index$iv).m697unboximpl());
                    result.add(TuplesKt.to(Integer.valueOf(index), Constraints.m5776boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m719childConstraintsJhjzzOo$foundation_release(slot, span))));
                    index++;
                    slot += span;
                    index$iv++;
                    lineConfiguration = lineConfiguration;
                }
                return result;
            }
        });
        Snapshot.Companion this_$iv = Snapshot.Companion;
        LazyGridState lazyGridState = this.$state;
        Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
        Snapshot this_$iv$iv2 = snapshot$iv;
        try {
            Snapshot previous$iv$iv2 = this_$iv$iv2.makeCurrent();
            int firstVisibleLineIndex2 = 0;
            try {
                int index = lazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(itemProvider2, lazyGridState.getFirstVisibleItemIndex());
                long j2 = visualItemOffset;
                itemsCount = itemsCount3;
                if (index < itemsCount || itemsCount <= 0) {
                    try {
                        firstVisibleLineIndex = spanLayoutProvider3.getLineIndexOfItem(index);
                        try {
                            firstVisibleLineScrollOffset = lazyGridState.getFirstVisibleItemScrollOffset();
                        } catch (Throwable th) {
                            th = th;
                            LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = spanLayoutProvider3;
                            this_$iv$iv = this_$iv$iv2;
                            previous$iv$iv = previous$iv$iv2;
                            firstVisibleLineIndex2 = firstVisibleLineIndex;
                            try {
                                this_$iv$iv.restoreCurrent(previous$iv$iv);
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                                int i7 = firstVisibleLineIndex2;
                                snapshot$iv.dispose();
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider2 = spanLayoutProvider3;
                        this_$iv$iv = this_$iv$iv2;
                        previous$iv$iv = previous$iv$iv2;
                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                        throw th;
                    }
                } else {
                    try {
                        firstVisibleLineIndex = spanLayoutProvider3.getLineIndexOfItem(itemsCount - 1);
                        firstVisibleLineScrollOffset = 0;
                    } catch (Throwable th4) {
                        th = th4;
                        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider3 = spanLayoutProvider3;
                        this_$iv$iv = this_$iv$iv2;
                        previous$iv$iv = previous$iv$iv2;
                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                        throw th;
                    }
                }
                try {
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th5) {
                    th = th5;
                    LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider4 = spanLayoutProvider3;
                    this_$iv$iv = this_$iv$iv2;
                    previous$iv$iv = previous$iv$iv2;
                    firstVisibleLineIndex2 = firstVisibleLineIndex;
                    int i8 = firstVisibleLineScrollOffset;
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider5 = spanLayoutProvider3;
                long j3 = visualItemOffset;
                this_$iv$iv = this_$iv$iv2;
                previous$iv$iv = previous$iv$iv2;
                int i9 = itemsCount3;
                this_$iv$iv.restoreCurrent(previous$iv$iv);
                throw th;
            }
            try {
                this_$iv$iv2.restoreCurrent(previous$iv$iv2);
                snapshot$iv.dispose();
                final LazyLayoutMeasureScope lazyLayoutMeasureScope2 = $this$null;
                final long j4 = containerConstraints;
                final int i10 = totalHorizontalPadding2;
                LazyGridSpanLayoutProvider spanLayoutProvider4 = spanLayoutProvider3;
                final int i11 = totalVerticalPadding2;
                LazyGridMeasureResult it = LazyGridMeasureKt.m711measureLazyGridZRKPzZ8(itemsCount, measuredLineProvider, measuredItemProvider, mainAxisAvailableSize, beforeContentPadding, afterContentPadding, spaceBetweenLines, firstVisibleLineIndex, firstVisibleLineScrollOffset, this.$state.getScrollToBeConsumed$foundation_release(), contentConstraints, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$state.getPlacementAnimator$foundation_release(), spanLayoutProvider4, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(itemProvider2, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release()), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                        return invoke(((Number) p1).intValue(), ((Number) p2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) p3);
                    }

                    public final MeasureResult invoke(int width, int height, Function1<? super Placeable.PlacementScope, Unit> placement) {
                        Intrinsics.checkNotNullParameter(placement, "placement");
                        return lazyLayoutMeasureScope2.layout(ConstraintsKt.m5802constrainWidthK40F9xA(j4, i10 + width), ConstraintsKt.m5801constrainHeightK40F9xA(j4, i11 + height), MapsKt.emptyMap(), placement);
                    }
                });
                this.$state.applyMeasureResult$foundation_release(it);
                return it;
            } catch (Throwable th7) {
                th = th7;
                LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider6 = spanLayoutProvider3;
                int i12 = firstVisibleLineIndex;
                int i13 = firstVisibleLineScrollOffset;
                snapshot$iv.dispose();
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider7 = spanLayoutProvider3;
            long j5 = visualItemOffset;
            int i14 = itemsCount3;
            snapshot$iv.dispose();
            throw th;
        }
    }
}

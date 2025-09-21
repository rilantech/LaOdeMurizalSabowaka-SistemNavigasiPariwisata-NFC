package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;J)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasurePolicy.kt */
final class LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Function0<LazyStaggeredGridItemProvider> $itemProviderLambda;
    final /* synthetic */ float $mainAxisSpacing;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ Function2<Density, Constraints, LazyStaggeredGridSlots> $slots;
    final /* synthetic */ LazyStaggeredGridState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1(Orientation orientation, Function2<? super Density, ? super Constraints, LazyStaggeredGridSlots> function2, Function0<? extends LazyStaggeredGridItemProvider> function0, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, float f) {
        super(2);
        this.$orientation = orientation;
        this.$slots = function2;
        this.$itemProviderLambda = function0;
        this.$state = lazyStaggeredGridState;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$mainAxisSpacing = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m788invoke0kLqBqw((LazyLayoutMeasureScope) p1, ((Constraints) p2).m5794unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyStaggeredGridMeasureResult m788invoke0kLqBqw(LazyLayoutMeasureScope $this$null, long constraints) {
        long contentOffset;
        LazyLayoutMeasureScope lazyLayoutMeasureScope = $this$null;
        long j = constraints;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
        CheckScrollableContainerConstraintsKt.m195checkScrollableContainerConstraintsK40F9xA(j, this.$orientation);
        LazyStaggeredGridSlots resolvedSlots = this.$slots.invoke(lazyLayoutMeasureScope, Constraints.m5776boximpl(constraints));
        boolean isVertical = this.$orientation == Orientation.Vertical;
        LazyStaggeredGridItemProvider itemProvider = this.$itemProviderLambda.invoke();
        this.$state.setSlots$foundation_release(resolvedSlots);
        this.$state.setVertical$foundation_release(isVertical);
        this.$state.setSpanProvider$foundation_release(itemProvider.getSpanProvider());
        int beforeContentPadding = lazyLayoutMeasureScope.m5819roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.beforePadding(this.$contentPadding, this.$orientation, this.$reverseLayout, $this$null.getLayoutDirection()));
        int afterContentPadding = lazyLayoutMeasureScope.m5819roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.afterPadding(this.$contentPadding, this.$orientation, this.$reverseLayout, $this$null.getLayoutDirection()));
        int startContentPadding = lazyLayoutMeasureScope.m5819roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.startPadding(this.$contentPadding, this.$orientation, $this$null.getLayoutDirection()));
        int mainAxisAvailableSize = ((isVertical ? Constraints.m5787getMaxHeightimpl(constraints) : Constraints.m5788getMaxWidthimpl(constraints)) - beforeContentPadding) - afterContentPadding;
        if (isVertical) {
            contentOffset = IntOffsetKt.IntOffset(startContentPadding, beforeContentPadding);
        } else {
            contentOffset = IntOffsetKt.IntOffset(beforeContentPadding, startContentPadding);
        }
        PaddingValues $this$invoke_0kLqBqw_u24lambda_u240 = this.$contentPadding;
        int horizontalPadding = lazyLayoutMeasureScope.m5819roundToPx0680j_4(Dp.m5844constructorimpl(PaddingKt.calculateStartPadding($this$invoke_0kLqBqw_u24lambda_u240, $this$null.getLayoutDirection()) + PaddingKt.calculateEndPadding($this$invoke_0kLqBqw_u24lambda_u240, $this$null.getLayoutDirection())));
        PaddingValues $this$invoke_0kLqBqw_u24lambda_u241 = this.$contentPadding;
        int verticalPadding = lazyLayoutMeasureScope.m5819roundToPx0680j_4(Dp.m5844constructorimpl($this$invoke_0kLqBqw_u24lambda_u241.m555calculateTopPaddingD9Ej5fM() + $this$invoke_0kLqBqw_u24lambda_u241.m552calculateBottomPaddingD9Ej5fM()));
        int i = verticalPadding;
        int i2 = horizontalPadding;
        int i3 = startContentPadding;
        long r6 = Constraints.m5779copyZbe2FdA$default(constraints, ConstraintsKt.m5802constrainWidthK40F9xA(j, horizontalPadding), 0, ConstraintsKt.m5801constrainHeightK40F9xA(j, verticalPadding), 0, 10, (Object) null);
        int r23 = lazyLayoutMeasureScope.m5819roundToPx0680j_4(this.$mainAxisSpacing);
        boolean z = isVertical;
        LazyStaggeredGridSlots lazyStaggeredGridSlots = resolvedSlots;
        LazyStaggeredGridMeasureResult it = LazyStaggeredGridMeasureKt.m786measureStaggeredGriddSVRQoE($this$null, this.$state, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(itemProvider, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release()), itemProvider, resolvedSlots, r6, isVertical, this.$reverseLayout, contentOffset, mainAxisAvailableSize, r23, beforeContentPadding, afterContentPadding);
        this.$state.applyMeasureResult$foundation_release(it);
        return it;
    }
}

package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\f\u0010\u000f\u001a\u00020\f*\u00020\rH\u0016J\u0014\u0010\u0010\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\fH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"androidx/compose/foundation/gestures/snapping/LazyGridSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "singleAxisItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "getSingleAxisItems", "()Ljava/util/List;", "calculateApproachOffset", "", "Landroidx/compose/ui/unit/Density;", "initialVelocity", "calculateSnapStepSize", "calculateSnappingOffset", "currentVelocity", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridSnapLayoutInfoProvider.kt */
public final class LazyGridSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1 implements SnapLayoutInfoProvider {
    final /* synthetic */ LazyGridState $lazyGridState;
    final /* synthetic */ SnapPositionInLayout $positionInLayout;

    LazyGridSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1(LazyGridState $lazyGridState2, SnapPositionInLayout $positionInLayout2) {
        this.$lazyGridState = $lazyGridState2;
        this.$positionInLayout = $positionInLayout2;
    }

    private final LazyGridLayoutInfo getLayoutInfo() {
        return this.$lazyGridState.getLayoutInfo();
    }

    public float calculateApproachOffset(Density $this$calculateApproachOffset, float initialVelocity) {
        Intrinsics.checkNotNullParameter($this$calculateApproachOffset, "<this>");
        float finalDecayOffset = RangesKt.coerceAtLeast(Math.abs(DecayAnimationSpecKt.calculateTargetValue(SplineBasedDecayKt.splineBasedDecay($this$calculateApproachOffset), 0.0f, initialVelocity)) - calculateSnapStepSize($this$calculateApproachOffset), 0.0f);
        if (finalDecayOffset == 0.0f) {
            return finalDecayOffset;
        }
        return Math.signum(initialVelocity) * finalDecayOffset;
    }

    private final List<LazyGridItemInfo> getSingleAxisItems() {
        List visibleItemsInfo = this.$lazyGridState.getLayoutInfo().getVisibleItemsInfo();
        LazyGridState lazyGridState = this.$lazyGridState;
        List target$iv = new ArrayList(visibleItemsInfo.size());
        List $this$fastForEach$iv$iv = visibleItemsInfo;
        int size = $this$fastForEach$iv$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            LazyGridItemInfo it = (LazyGridItemInfo) it$iv;
            boolean z = false;
            if (lazyGridState.getLayoutInfo().getOrientation() == Orientation.Horizontal) {
                if (it.getRow() == 0) {
                    z = true;
                }
            } else if (it.getColumn() == 0) {
                z = true;
            }
            if (z) {
                target$iv.add(it$iv);
            }
        }
        return target$iv;
    }

    public float calculateSnappingOffset(Density $this$calculateSnappingOffset, float currentVelocity) {
        Intrinsics.checkNotNullParameter($this$calculateSnappingOffset, "<this>");
        float distanceFromItemBeforeTarget = Float.NEGATIVE_INFINITY;
        List $this$fastForEach$iv = getLayoutInfo().getVisibleItemsInfo();
        SnapPositionInLayout snapPositionInLayout = this.$positionInLayout;
        int size = $this$fastForEach$iv.size();
        float distanceFromItemAfterTarget = Float.POSITIVE_INFINITY;
        int index$iv = 0;
        while (index$iv < size) {
            LazyGridItemInfo item = $this$fastForEach$iv.get(index$iv);
            LazyGridItemInfo lazyGridItemInfo = item;
            int index$iv2 = index$iv;
            float distance = SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition($this$calculateSnappingOffset, LazyGridSnapLayoutInfoProviderKt.getSingleAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(item, getLayoutInfo().getOrientation()), LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(item, getLayoutInfo().getOrientation()), item.getIndex(), snapPositionInLayout);
            if (distance <= 0.0f && distance > distanceFromItemBeforeTarget) {
                distanceFromItemBeforeTarget = distance;
            }
            if (distance >= 0.0f && distance < distanceFromItemAfterTarget) {
                distanceFromItemAfterTarget = distance;
            }
            index$iv = index$iv2 + 1;
        }
        return SnapFlingBehaviorKt.calculateFinalOffset(currentVelocity, distanceFromItemBeforeTarget, distanceFromItemAfterTarget);
    }

    public float calculateSnapStepSize(Density $this$calculateSnapStepSize) {
        int sum$iv;
        Intrinsics.checkNotNullParameter($this$calculateSnapStepSize, "<this>");
        if (!(!getSingleAxisItems().isEmpty())) {
            return 0.0f;
        }
        if (getLayoutInfo().getOrientation() == Orientation.Vertical) {
            sum$iv = 0;
            List $this$fastForEach$iv$iv = getSingleAxisItems();
            int size = $this$fastForEach$iv$iv.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                sum$iv += IntSize.m7713getHeightimpl(((LazyGridItemInfo) $this$fastForEach$iv$iv.get(index$iv$iv)).m2418getSizeYbymL2g());
            }
        } else {
            int sum$iv2 = 0;
            List $this$fastForEach$iv$iv2 = getSingleAxisItems();
            int size2 = $this$fastForEach$iv$iv2.size();
            for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                sum$iv2 = sum$iv + IntSize.m7714getWidthimpl(((LazyGridItemInfo) $this$fastForEach$iv$iv2.get(index$iv$iv2)).m2418getSizeYbymL2g());
            }
        }
        return ((float) sum$iv) / ((float) getSingleAxisItems().size());
    }
}

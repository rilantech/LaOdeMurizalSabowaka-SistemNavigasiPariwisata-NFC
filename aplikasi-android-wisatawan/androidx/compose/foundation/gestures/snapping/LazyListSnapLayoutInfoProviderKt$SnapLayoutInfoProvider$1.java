package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\f\u0010\n\u001a\u00020\u0007*\u00020\bH\u0016J\u0014\u0010\u000b\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"androidx/compose/foundation/gestures/snapping/LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "calculateApproachOffset", "", "Landroidx/compose/ui/unit/Density;", "initialVelocity", "calculateSnapStepSize", "calculateSnappingOffset", "currentVelocity", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListSnapLayoutInfoProvider.kt */
public final class LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1 implements SnapLayoutInfoProvider {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ SnapPositionInLayout $positionInLayout;

    LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1(LazyListState $lazyListState2, SnapPositionInLayout $positionInLayout2) {
        this.$lazyListState = $lazyListState2;
        this.$positionInLayout = $positionInLayout2;
    }

    private final LazyListLayoutInfo getLayoutInfo() {
        return this.$lazyListState.getLayoutInfo();
    }

    public float calculateApproachOffset(Density $this$calculateApproachOffset, float initialVelocity) {
        Intrinsics.checkNotNullParameter($this$calculateApproachOffset, "<this>");
        float finalDecayOffset = RangesKt.coerceAtLeast(Math.abs(DecayAnimationSpecKt.calculateTargetValue(SplineBasedDecayKt.splineBasedDecay($this$calculateApproachOffset), 0.0f, initialVelocity)) - calculateSnapStepSize($this$calculateApproachOffset), 0.0f);
        if (finalDecayOffset == 0.0f) {
            return finalDecayOffset;
        }
        return Math.signum(initialVelocity) * finalDecayOffset;
    }

    public float calculateSnappingOffset(Density $this$calculateSnappingOffset, float currentVelocity) {
        Intrinsics.checkNotNullParameter($this$calculateSnappingOffset, "<this>");
        float lowerBoundOffset = Float.NEGATIVE_INFINITY;
        List $this$fastForEach$iv = getLayoutInfo().getVisibleItemsInfo();
        SnapPositionInLayout snapPositionInLayout = this.$positionInLayout;
        int size = $this$fastForEach$iv.size();
        float upperBoundOffset = Float.POSITIVE_INFINITY;
        int index$iv = 0;
        while (index$iv < size) {
            LazyListItemInfo item = $this$fastForEach$iv.get(index$iv);
            int index$iv2 = index$iv;
            float offset = SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition($this$calculateSnappingOffset, LazyListSnapLayoutInfoProviderKt.getSingleAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), item.getSize(), item.getOffset(), item.getIndex(), snapPositionInLayout);
            if (offset <= 0.0f && offset > lowerBoundOffset) {
                lowerBoundOffset = offset;
            }
            if (offset >= 0.0f && offset < upperBoundOffset) {
                upperBoundOffset = offset;
            }
            index$iv = index$iv2 + 1;
        }
        return SnapFlingBehaviorKt.calculateFinalOffset(currentVelocity, lowerBoundOffset, upperBoundOffset);
    }

    public float calculateSnapStepSize(Density $this$calculateSnapStepSize) {
        Intrinsics.checkNotNullParameter($this$calculateSnapStepSize, "<this>");
        LazyListLayoutInfo $this$calculateSnapStepSize_u24lambda_u242 = getLayoutInfo();
        if (!(!$this$calculateSnapStepSize_u24lambda_u242.getVisibleItemsInfo().isEmpty())) {
            return 0.0f;
        }
        int sum$iv = 0;
        List $this$fastForEach$iv$iv = $this$calculateSnapStepSize_u24lambda_u242.getVisibleItemsInfo();
        int size = $this$fastForEach$iv$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            sum$iv += ((LazyListItemInfo) $this$fastForEach$iv$iv.get(index$iv$iv)).getSize();
        }
        return ((float) sum$iv) / ((float) $this$calculateSnapStepSize_u24lambda_u242.getVisibleItemsInfo().size());
    }
}

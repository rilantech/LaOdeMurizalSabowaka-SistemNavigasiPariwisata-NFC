package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"calculateAlignmentAndPlaceChildAsNeeded", "", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutModifierNodeCoordinator.kt */
public final class LayoutModifierNodeCoordinatorKt {
    /* access modifiers changed from: private */
    public static final int calculateAlignmentAndPlaceChildAsNeeded(LookaheadCapablePlaceable $this$calculateAlignmentAndPlaceChildAsNeeded, AlignmentLine alignmentLine) {
        LookaheadCapablePlaceable child = $this$calculateAlignmentAndPlaceChildAsNeeded.getChild();
        if (!(child != null)) {
            throw new IllegalStateException(("Child of " + $this$calculateAlignmentAndPlaceChildAsNeeded + " cannot be null when calculating alignment line").toString());
        } else if ($this$calculateAlignmentAndPlaceChildAsNeeded.getMeasureResult$ui_release().getAlignmentLines().containsKey(alignmentLine)) {
            Integer num = $this$calculateAlignmentAndPlaceChildAsNeeded.getMeasureResult$ui_release().getAlignmentLines().get(alignmentLine);
            if (num != null) {
                return num.intValue();
            }
            return Integer.MIN_VALUE;
        } else {
            int positionInWrapped = child.get(alignmentLine);
            if (positionInWrapped == Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            child.setShallowPlacing$ui_release(true);
            $this$calculateAlignmentAndPlaceChildAsNeeded.setPlacingForAlignment$ui_release(true);
            $this$calculateAlignmentAndPlaceChildAsNeeded.replace$ui_release();
            child.setShallowPlacing$ui_release(false);
            $this$calculateAlignmentAndPlaceChildAsNeeded.setPlacingForAlignment$ui_release(false);
            if (alignmentLine instanceof HorizontalAlignmentLine) {
                return IntOffset.m5963getYimpl(child.m4890getPositionnOccac()) + positionInWrapped;
            }
            return IntOffset.m5962getXimpl(child.m4890getPositionnOccac()) + positionInWrapped;
        }
    }
}

package androidx.compose.ui.layout;

import androidx.compose.ui.node.NodeMeasuringIntrinsics;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "intrinsicMeasurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: IntermediateLayoutModifierNode.kt */
final class IntermediateLayoutModifierNode$minIntermediateIntrinsicWidth$1 implements NodeMeasuringIntrinsics.MeasureBlock {
    final /* synthetic */ IntermediateLayoutModifierNode this$0;

    IntermediateLayoutModifierNode$minIntermediateIntrinsicWidth$1(IntermediateLayoutModifierNode intermediateLayoutModifierNode) {
        this.this$0 = intermediateLayoutModifierNode;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m6345measure3p2s80s(MeasureScope $this$minWidth, Measurable intrinsicMeasurable, long constraints) {
        Intrinsics.checkNotNullParameter($this$minWidth, "$this$minWidth");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
        return this.this$0.getMeasureBlock$ui_release().invoke(this.this$0.intermediateMeasureScope, intrinsicMeasurable, Constraints.m7486boximpl(constraints));
    }
}

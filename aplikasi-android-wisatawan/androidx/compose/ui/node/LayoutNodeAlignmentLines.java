package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\f\u001a\u00020\r*\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\b*\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0007H\u0014R$\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006*\u00020\t8TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeAlignmentLines;", "Landroidx/compose/ui/node/AlignmentLines;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "(Landroidx/compose/ui/node/AlignmentLinesOwner;)V", "alignmentLinesMap", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "Landroidx/compose/ui/node/NodeCoordinator;", "getAlignmentLinesMap", "(Landroidx/compose/ui/node/NodeCoordinator;)Ljava/util/Map;", "calculatePositionInParent", "Landroidx/compose/ui/geometry/Offset;", "position", "calculatePositionInParent-R5De75A", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "getPositionFor", "alignmentLine", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeAlignmentLines.kt */
public final class LayoutNodeAlignmentLines extends AlignmentLines {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutNodeAlignmentLines(AlignmentLinesOwner alignmentLinesOwner) {
        super(alignmentLinesOwner, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(alignmentLinesOwner, "alignmentLinesOwner");
    }

    /* access modifiers changed from: protected */
    public Map<AlignmentLine, Integer> getAlignmentLinesMap(NodeCoordinator $this$alignmentLinesMap) {
        Intrinsics.checkNotNullParameter($this$alignmentLinesMap, "<this>");
        return $this$alignmentLinesMap.getMeasureResult$ui_release().getAlignmentLines();
    }

    /* access modifiers changed from: protected */
    public int getPositionFor(NodeCoordinator $this$getPositionFor, AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter($this$getPositionFor, "<this>");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return $this$getPositionFor.get(alignmentLine);
    }

    /* access modifiers changed from: protected */
    /* renamed from: calculatePositionInParent-R5De75A  reason: not valid java name */
    public long m4837calculatePositionInParentR5De75A(NodeCoordinator $this$calculatePositionInParent_u2dR5De75A, long position) {
        Intrinsics.checkNotNullParameter($this$calculatePositionInParent_u2dR5De75A, "$this$calculatePositionInParent");
        return $this$calculatePositionInParent_u2dR5De75A.m4942toParentPositionMKHz9U(position);
    }
}

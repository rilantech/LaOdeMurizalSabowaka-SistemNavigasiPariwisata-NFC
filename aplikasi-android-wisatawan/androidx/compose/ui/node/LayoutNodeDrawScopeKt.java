package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"nextDrawNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeDrawScope.kt */
public final class LayoutNodeDrawScopeKt {
    /* access modifiers changed from: private */
    public static final Modifier.Node nextDrawNode(DelegatableNode $this$nextDrawNode) {
        int drawMask = NodeKind.m4956constructorimpl(4);
        int measureMask = NodeKind.m4956constructorimpl(2);
        Modifier.Node child = $this$nextDrawNode.getNode().getChild$ui_release();
        if (child == null || (child.getAggregateChildKindSet$ui_release() & drawMask) == 0) {
            return null;
        }
        Modifier.Node next = child;
        while (next != null && (next.getKindSet$ui_release() & measureMask) == 0) {
            if ((next.getKindSet$ui_release() & drawMask) != 0) {
                return next;
            }
            next = next.getChild$ui_release();
        }
        return null;
    }
}

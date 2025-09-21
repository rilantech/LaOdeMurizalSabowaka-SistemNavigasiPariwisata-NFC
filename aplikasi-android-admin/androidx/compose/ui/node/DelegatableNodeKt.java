package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002\u001a8\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\n\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\rH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u0007H\u0000\u001aG\u0010\u0012\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a%\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a\n\u0010\u001b\u001a\u00020\u0005*\u00020\u0002\u001a6\u0010\u001c\u001a\u0004\u0018\u0001H\u000b\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\u001d*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\rH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010 \u001a\u00020!H\u0000\u001a\u0016\u0010\"\u001a\u0004\u0018\u00010\u0007*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002\u001a%\u0010#\u001a\u00020$*\u00020\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u001a\n\u0010'\u001a\u00020(*\u00020\u0002\u001a\n\u0010)\u001a\u00020**\u00020\u0002\u001a\f\u0010+\u001a\u00020,*\u00020\u0002H\u0000\u001a\f\u0010-\u001a\u00020.*\u00020\u0002H\u0000\u001aQ\u0010/\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\b\b\u0002\u00100\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\u001a6\u0010/\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\b\b\u0002\u00100\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0002\u001aG\u00103\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\u001a,\u00103\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0002\u001aG\u00106\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00105\u001a,\u00106\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0002\u001aG\u00108\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u00105\u001a,\u00108\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0002\u001aS\u0010:\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\n\u0010;\u001a\u0006\u0012\u0002\b\u00030\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=\u001aG\u0010>\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u00105\u001aG\u0010@\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bA\u00105\u001a,\u0010@\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0002\u001aG\u0010B\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00010\u0015H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u00105\u001a,\u0010B\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0015H\bø\u0001\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\u0002\u0012\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006D"}, d2 = {"isDelegationRoot", "", "Landroidx/compose/ui/node/DelegatableNode;", "(Landroidx/compose/ui/node/DelegatableNode;)Z", "addLayoutNodeChildren", "", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Node;", "node", "ancestors", "", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "ancestors-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/util/List;", "asLayoutModifierNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "dispatchForKind", "kind", "block", "Lkotlin/Function1;", "dispatchForKind-6rFNWt0", "(Landroidx/compose/ui/Modifier$Node;ILkotlin/jvm/functions/Function1;)V", "has", "has-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Z", "invalidateSubtree", "nearestAncestor", "", "nearestAncestor-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "mask", "", "pop", "requireCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "requireCoordinator-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Landroidx/compose/ui/node/NodeCoordinator;", "requireDensity", "Landroidx/compose/ui/unit/Density;", "requireLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "requireLayoutNode", "Landroidx/compose/ui/node/LayoutNode;", "requireOwner", "Landroidx/compose/ui/node/Owner;", "visitAncestors", "includeSelf", "visitAncestors-Y-YKmho", "(Landroidx/compose/ui/node/DelegatableNode;IZLkotlin/jvm/functions/Function1;)V", "visitChildren", "visitChildren-6rFNWt0", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;)V", "visitLocalAncestors", "visitLocalAncestors-6rFNWt0", "visitLocalDescendants", "visitLocalDescendants-6rFNWt0", "visitSelfAndAncestors", "untilType", "visitSelfAndAncestors-5BbP62I", "(Landroidx/compose/ui/node/DelegatableNode;IILkotlin/jvm/functions/Function1;)V", "visitSelfAndChildren", "visitSelfAndChildren-6rFNWt0", "visitSubtree", "visitSubtree-6rFNWt0", "visitSubtreeIf", "visitSubtreeIf-6rFNWt0", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DelegatableNode.kt */
public final class DelegatableNodeKt {
    public static final boolean isDelegationRoot(DelegatableNode $this$isDelegationRoot) {
        Intrinsics.checkNotNullParameter($this$isDelegationRoot, "<this>");
        return $this$isDelegationRoot.getNode() == $this$isDelegationRoot;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        r2 = r0.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void visitAncestors$default(androidx.compose.ui.node.DelegatableNode r3, int r4, boolean r5, kotlin.jvm.functions.Function1 r6, int r7, java.lang.Object r8) {
        /*
            r7 = r7 & 2
            if (r7 == 0) goto L_0x0005
            r5 = 0
        L_0x0005:
            java.lang.String r7 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r7)
            java.lang.String r7 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            r7 = 0
            androidx.compose.ui.Modifier$Node r8 = r3.getNode()
            boolean r8 = r8.isAttached()
            if (r8 == 0) goto L_0x0060
            androidx.compose.ui.Modifier$Node r8 = r3.getNode()
            if (r5 == 0) goto L_0x0021
            goto L_0x0025
        L_0x0021:
            androidx.compose.ui.Modifier$Node r8 = r8.getParent$ui_release()
        L_0x0025:
            androidx.compose.ui.node.LayoutNode r0 = requireLayoutNode(r3)
        L_0x0029:
            if (r0 == 0) goto L_0x005f
            androidx.compose.ui.node.NodeChain r1 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r1 = r1.getHead$ui_release()
            int r2 = r1.getAggregateChildKindSet$ui_release()
            r2 = r2 & r4
            if (r2 == 0) goto L_0x004b
        L_0x003a:
            if (r8 == 0) goto L_0x004b
            int r2 = r8.getKindSet$ui_release()
            r2 = r2 & r4
            if (r2 == 0) goto L_0x0046
            r6.invoke(r8)
        L_0x0046:
            androidx.compose.ui.Modifier$Node r8 = r8.getParent$ui_release()
            goto L_0x003a
        L_0x004b:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x005c
            androidx.compose.ui.node.NodeChain r2 = r0.getNodes$ui_release()
            if (r2 == 0) goto L_0x005c
            androidx.compose.ui.Modifier$Node r2 = r2.getTail$ui_release()
            goto L_0x005d
        L_0x005c:
            r2 = 0
        L_0x005d:
            r8 = r2
            goto L_0x0029
        L_0x005f:
            return
        L_0x0060:
            r8 = 0
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "visitAncestors called on an unattached node"
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.DelegatableNodeKt.visitAncestors$default(androidx.compose.ui.node.DelegatableNode, int, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        r4 = r2.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void visitAncestors(androidx.compose.ui.node.DelegatableNode r5, int r6, boolean r7, kotlin.jvm.functions.Function1<? super androidx.compose.ui.Modifier.Node, kotlin.Unit> r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 0
            androidx.compose.ui.Modifier$Node r1 = r5.getNode()
            boolean r1 = r1.isAttached()
            if (r1 == 0) goto L_0x005b
            androidx.compose.ui.Modifier$Node r1 = r5.getNode()
            if (r7 == 0) goto L_0x001c
            goto L_0x0020
        L_0x001c:
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
        L_0x0020:
            androidx.compose.ui.node.LayoutNode r2 = requireLayoutNode(r5)
        L_0x0024:
            if (r2 == 0) goto L_0x005a
            androidx.compose.ui.node.NodeChain r3 = r2.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r3 = r3.getHead$ui_release()
            int r4 = r3.getAggregateChildKindSet$ui_release()
            r4 = r4 & r6
            if (r4 == 0) goto L_0x0046
        L_0x0035:
            if (r1 == 0) goto L_0x0046
            int r4 = r1.getKindSet$ui_release()
            r4 = r4 & r6
            if (r4 == 0) goto L_0x0041
            r8.invoke(r1)
        L_0x0041:
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            goto L_0x0035
        L_0x0046:
            androidx.compose.ui.node.LayoutNode r2 = r2.getParent$ui_release()
            if (r2 == 0) goto L_0x0057
            androidx.compose.ui.node.NodeChain r4 = r2.getNodes$ui_release()
            if (r4 == 0) goto L_0x0057
            androidx.compose.ui.Modifier$Node r4 = r4.getTail$ui_release()
            goto L_0x0058
        L_0x0057:
            r4 = 0
        L_0x0058:
            r1 = r4
            goto L_0x0024
        L_0x005a:
            return
        L_0x005b:
            r1 = 0
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "visitAncestors called on an unattached node"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.DelegatableNodeKt.visitAncestors(androidx.compose.ui.node.DelegatableNode, int, boolean, kotlin.jvm.functions.Function1):void");
    }

    public static final Modifier.Node nearestAncestor(DelegatableNode $this$nearestAncestor, int mask) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter($this$nearestAncestor, "<this>");
        if ($this$nearestAncestor.getNode().isAttached()) {
            Modifier.Node node = $this$nearestAncestor.getNode().getParent$ui_release();
            LayoutNode layout = requireLayoutNode($this$nearestAncestor);
            while (true) {
                Modifier.Node node2 = null;
                if (layout == null) {
                    return null;
                }
                if ((layout.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask) != 0) {
                    while (node != null) {
                        if ((node.getKindSet$ui_release() & mask) != 0) {
                            return node;
                        }
                        node = node.getParent$ui_release();
                    }
                }
                layout = layout.getParent$ui_release();
                if (!(layout == null || (nodes$ui_release = layout.getNodes$ui_release()) == null)) {
                    node2 = nodes$ui_release.getTail$ui_release();
                }
                node = node2;
            }
        } else {
            throw new IllegalStateException("nearestAncestor called on an unattached node".toString());
        }
    }

    public static final void visitSubtree(DelegatableNode $this$visitSubtree, int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitSubtree, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if ($this$visitSubtree.getNode().isAttached()) {
            Modifier.Node node = $this$visitSubtree.getNode().getChild$ui_release();
            NestedVectorStack nodes = new NestedVectorStack();
            for (LayoutNode layout = requireLayoutNode($this$visitSubtree); layout != null; layout = nodes.isNotEmpty() ? (LayoutNode) nodes.pop() : null) {
                Modifier.Node node2 = node == null ? layout.getNodes$ui_release().getHead$ui_release() : node;
                if ((node2.getAggregateChildKindSet$ui_release() & mask) != 0) {
                    while (node2 != null) {
                        if ((node2.getKindSet$ui_release() & mask) != 0) {
                            block.invoke(node2);
                        }
                        node2 = node2.getChild$ui_release();
                    }
                }
                node = null;
                nodes.push(layout.get_children$ui_release());
            }
            return;
        }
        throw new IllegalStateException("visitSubtree called on an unattached node".toString());
    }

    /* access modifiers changed from: private */
    public static final void addLayoutNodeChildren(MutableVector<Modifier.Node> $this$addLayoutNodeChildren, Modifier.Node node) {
        MutableVector this_$iv = requireLayoutNode(node).get_children$ui_release();
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = size$iv - 1;
            Object[] content$iv = this_$iv.getContent();
            do {
                $this$addLayoutNodeChildren.add(((LayoutNode) content$iv[i$iv]).getNodes$ui_release().getHead$ui_release());
                i$iv--;
            } while (i$iv >= 0);
        }
    }

    public static final void visitChildren(DelegatableNode $this$visitChildren, int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitChildren, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if ($this$visitChildren.getNode().isAttached()) {
            MutableVector branches = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child = $this$visitChildren.getNode().getChild$ui_release();
            if (child == null) {
                addLayoutNodeChildren(branches, $this$visitChildren.getNode());
            } else {
                branches.add(child);
            }
            while (branches.isNotEmpty()) {
                Modifier.Node branch = (Modifier.Node) branches.removeAt(branches.getSize() - 1);
                if ((branch.getAggregateChildKindSet$ui_release() & mask) == 0) {
                    addLayoutNodeChildren(branches, branch);
                } else {
                    Modifier.Node node = branch;
                    while (true) {
                        if (node == null) {
                            break;
                        } else if ((node.getKindSet$ui_release() & mask) != 0) {
                            block.invoke(node);
                            break;
                        } else {
                            node = node.getChild$ui_release();
                        }
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    public static final void visitSubtreeIf(DelegatableNode $this$visitSubtreeIf, int mask, Function1<? super Modifier.Node, Boolean> block) {
        Intrinsics.checkNotNullParameter($this$visitSubtreeIf, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if ($this$visitSubtreeIf.getNode().isAttached()) {
            MutableVector branches = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child = $this$visitSubtreeIf.getNode().getChild$ui_release();
            if (child == null) {
                addLayoutNodeChildren(branches, $this$visitSubtreeIf.getNode());
            } else {
                branches.add(child);
            }
            while (branches.isNotEmpty()) {
                Modifier.Node branch = (Modifier.Node) branches.removeAt(branches.getSize() - 1);
                if ((branch.getAggregateChildKindSet$ui_release() & mask) != 0) {
                    Modifier.Node node = branch;
                    while (true) {
                        if (node != null) {
                            if ((node.getKindSet$ui_release() & mask) != 0 && !block.invoke(node).booleanValue()) {
                                break;
                            }
                            node = node.getChild$ui_release();
                        } else {
                            break;
                        }
                    }
                }
                addLayoutNodeChildren(branches, branch);
            }
            return;
        }
        throw new IllegalStateException("visitSubtreeIf called on an unattached node".toString());
    }

    public static final void visitLocalDescendants(DelegatableNode $this$visitLocalDescendants, int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitLocalDescendants, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if ($this$visitLocalDescendants.getNode().isAttached()) {
            Modifier.Node self = $this$visitLocalDescendants.getNode();
            if ((self.getAggregateChildKindSet$ui_release() & mask) != 0) {
                for (Modifier.Node next = self.getChild$ui_release(); next != null; next = next.getChild$ui_release()) {
                    if ((next.getKindSet$ui_release() & mask) != 0) {
                        block.invoke(next);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("visitLocalDescendants called on an unattached node".toString());
    }

    public static final void visitLocalAncestors(DelegatableNode $this$visitLocalAncestors, int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitLocalAncestors, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if ($this$visitLocalAncestors.getNode().isAttached()) {
            for (Modifier.Node next = $this$visitLocalAncestors.getNode().getParent$ui_release(); next != null; next = next.getParent$ui_release()) {
                if ((next.getKindSet$ui_release() & mask) != 0) {
                    block.invoke(next);
                }
            }
            return;
        }
        throw new IllegalStateException("visitLocalAncestors called on an unattached node".toString());
    }

    /* renamed from: visitLocalDescendants-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m6507visitLocalDescendants6rFNWt0(DelegatableNode $this$visitLocalDescendants_u2d6rFNWt0, int type, Function1<? super T, Unit> block) {
        int mask$iv;
        int i;
        Function1<? super T, Unit> function1;
        int mask$iv2;
        int i2;
        int mask$iv3;
        int i3;
        Object obj;
        Function1<? super T, Unit> function12 = block;
        Intrinsics.checkNotNullParameter($this$visitLocalDescendants_u2d6rFNWt0, "$this$visitLocalDescendants");
        Intrinsics.checkNotNullParameter(function12, "block");
        int i4 = 0;
        int mask$iv4 = type;
        DelegatableNode $this$visitLocalDescendants$iv = $this$visitLocalDescendants_u2d6rFNWt0;
        if ($this$visitLocalDescendants$iv.getNode().isAttached()) {
            Modifier.Node self$iv = $this$visitLocalDescendants$iv.getNode();
            if ((self$iv.getAggregateChildKindSet$ui_release() & mask$iv4) != 0) {
                Modifier.Node next$iv = self$iv.getChild$ui_release();
                while (next$iv != null) {
                    if ((next$iv.getKindSet$ui_release() & mask$iv) != 0) {
                        Object stack$iv = null;
                        Object node$iv = next$iv;
                        while (node$iv != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (node$iv instanceof Object) {
                                function1.invoke(node$iv);
                                i2 = i;
                                mask$iv2 = mask$iv;
                            } else {
                                if (!((((Modifier.Node) node$iv).getKindSet$ui_release() & type) != 0) || !(node$iv instanceof DelegatingNode)) {
                                    i2 = i;
                                    mask$iv2 = mask$iv;
                                } else {
                                    int count$iv = 0;
                                    Modifier.Node node$iv$iv = ((DelegatingNode) node$iv).getDelegate$ui_release();
                                    while (node$iv$iv != null) {
                                        Object next$iv2 = node$iv$iv;
                                        if ((next$iv2.getKindSet$ui_release() & type) != 0) {
                                            count$iv++;
                                            i3 = i;
                                            if (count$iv == 1) {
                                                node$iv = next$iv2;
                                                mask$iv3 = mask$iv;
                                            } else {
                                                Object obj2 = (MutableVector) stack$iv;
                                                if (obj2 == null) {
                                                    mask$iv3 = mask$iv;
                                                    obj = new MutableVector(new Modifier.Node[16], 0);
                                                    MutableVector mutableVector = (MutableVector) obj;
                                                } else {
                                                    obj = obj2;
                                                    mask$iv3 = mask$iv;
                                                }
                                                stack$iv = obj;
                                                Modifier.Node theNode$iv = (Modifier.Node) node$iv;
                                                if (theNode$iv != null) {
                                                    MutableVector mutableVector2 = (MutableVector) stack$iv;
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(theNode$iv);
                                                    }
                                                    node$iv = null;
                                                }
                                                MutableVector mutableVector3 = (MutableVector) stack$iv;
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(next$iv2);
                                                }
                                            }
                                        } else {
                                            i3 = i;
                                            mask$iv3 = mask$iv;
                                        }
                                        node$iv$iv = node$iv$iv.getChild$ui_release();
                                        DelegatableNode delegatableNode = $this$visitLocalDescendants_u2d6rFNWt0;
                                        i = i3;
                                        mask$iv = mask$iv3;
                                    }
                                    i2 = i;
                                    mask$iv2 = mask$iv;
                                    if (count$iv == 1) {
                                        DelegatableNode delegatableNode2 = $this$visitLocalDescendants_u2d6rFNWt0;
                                        function1 = block;
                                        i = i2;
                                        mask$iv = mask$iv2;
                                    }
                                }
                            }
                            node$iv = pop((MutableVector) stack$iv);
                            DelegatableNode delegatableNode3 = $this$visitLocalDescendants_u2d6rFNWt0;
                            function1 = block;
                            i = i2;
                            mask$iv = mask$iv2;
                        }
                    }
                    next$iv = next$iv.getChild$ui_release();
                    DelegatableNode delegatableNode4 = $this$visitLocalDescendants_u2d6rFNWt0;
                    function12 = block;
                    i4 = i;
                    mask$iv4 = mask$iv;
                }
                int i5 = i;
                int i6 = mask$iv;
                return;
            }
            int i7 = mask$iv4;
            return;
        }
        throw new IllegalStateException("visitLocalDescendants called on an unattached node".toString());
    }

    /* renamed from: visitLocalAncestors-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m6506visitLocalAncestors6rFNWt0(DelegatableNode $this$visitLocalAncestors_u2d6rFNWt0, int type, Function1<? super T, Unit> block) {
        int mask$iv;
        int i;
        Function1<? super T, Unit> function1;
        int mask$iv2;
        int i2;
        int mask$iv3;
        int i3;
        Object obj;
        Function1<? super T, Unit> function12 = block;
        Intrinsics.checkNotNullParameter($this$visitLocalAncestors_u2d6rFNWt0, "$this$visitLocalAncestors");
        Intrinsics.checkNotNullParameter(function12, "block");
        int i4 = 0;
        int mask$iv4 = type;
        DelegatableNode $this$visitLocalAncestors$iv = $this$visitLocalAncestors_u2d6rFNWt0;
        if ($this$visitLocalAncestors$iv.getNode().isAttached()) {
            Modifier.Node next$iv = $this$visitLocalAncestors$iv.getNode().getParent$ui_release();
            while (next$iv != null) {
                if ((next$iv.getKindSet$ui_release() & mask$iv) != 0) {
                    Object stack$iv = null;
                    Object node$iv = next$iv;
                    while (node$iv != null) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (node$iv instanceof Object) {
                            function1.invoke(node$iv);
                            i2 = i;
                            mask$iv2 = mask$iv;
                        } else {
                            if (!((((Modifier.Node) node$iv).getKindSet$ui_release() & type) != 0) || !(node$iv instanceof DelegatingNode)) {
                                i2 = i;
                                mask$iv2 = mask$iv;
                            } else {
                                int count$iv = 0;
                                Modifier.Node node$iv$iv = ((DelegatingNode) node$iv).getDelegate$ui_release();
                                while (node$iv$iv != null) {
                                    Object next$iv2 = node$iv$iv;
                                    if ((next$iv2.getKindSet$ui_release() & type) != 0) {
                                        count$iv++;
                                        i3 = i;
                                        if (count$iv == 1) {
                                            node$iv = next$iv2;
                                            mask$iv3 = mask$iv;
                                        } else {
                                            Object obj2 = (MutableVector) stack$iv;
                                            if (obj2 == null) {
                                                mask$iv3 = mask$iv;
                                                obj = new MutableVector(new Modifier.Node[16], 0);
                                                MutableVector mutableVector = (MutableVector) obj;
                                            } else {
                                                obj = obj2;
                                                mask$iv3 = mask$iv;
                                            }
                                            stack$iv = obj;
                                            Modifier.Node theNode$iv = (Modifier.Node) node$iv;
                                            if (theNode$iv != null) {
                                                MutableVector mutableVector2 = (MutableVector) stack$iv;
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(theNode$iv);
                                                }
                                                node$iv = null;
                                            }
                                            MutableVector mutableVector3 = (MutableVector) stack$iv;
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(next$iv2);
                                            }
                                        }
                                    } else {
                                        i3 = i;
                                        mask$iv3 = mask$iv;
                                    }
                                    node$iv$iv = node$iv$iv.getChild$ui_release();
                                    DelegatableNode delegatableNode = $this$visitLocalAncestors_u2d6rFNWt0;
                                    i = i3;
                                    mask$iv = mask$iv3;
                                }
                                i2 = i;
                                mask$iv2 = mask$iv;
                                if (count$iv == 1) {
                                    DelegatableNode delegatableNode2 = $this$visitLocalAncestors_u2d6rFNWt0;
                                    function1 = block;
                                    i = i2;
                                    mask$iv = mask$iv2;
                                }
                            }
                        }
                        node$iv = pop((MutableVector) stack$iv);
                        DelegatableNode delegatableNode3 = $this$visitLocalAncestors_u2d6rFNWt0;
                        function1 = block;
                        i = i2;
                        mask$iv = mask$iv2;
                    }
                }
                next$iv = next$iv.getParent$ui_release();
                DelegatableNode delegatableNode4 = $this$visitLocalAncestors_u2d6rFNWt0;
                function12 = block;
                i4 = i;
                mask$iv4 = mask$iv;
            }
            return;
        }
        throw new IllegalStateException("visitLocalAncestors called on an unattached node".toString());
    }

    /* renamed from: visitAncestors-Y-YKmho$default  reason: not valid java name */
    public static /* synthetic */ void m6504visitAncestorsYYKmho$default(DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default, int type, boolean includeSelf, Function1 block, int i, Object obj) {
        boolean count$iv;
        int i2;
        boolean includeSelf2;
        int mask$iv;
        NodeChain nodes$ui_release;
        int mask$iv2;
        int i3;
        Function1 function1;
        int mask$iv3;
        boolean count$iv2;
        int mask$iv4;
        DelegatingNode this_$iv$iv;
        int count$iv3;
        Function1 function12 = block;
        if ((i & 2) != 0) {
            count$iv = false;
        } else {
            count$iv = includeSelf;
        }
        Intrinsics.checkNotNullParameter($this$visitAncestors_u2dY_u2dYKmho_u24default, "$this$visitAncestors");
        Intrinsics.checkNotNullParameter(function12, "block");
        int i4 = 0;
        int mask$iv5 = type;
        DelegatableNode $this$visitAncestors$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default;
        if ($this$visitAncestors$iv.getNode().isAttached()) {
            Modifier.Node node$iv = $this$visitAncestors$iv.getNode();
            if (!count$iv) {
                node$iv = node$iv.getParent$ui_release();
            }
            LayoutNode layout$iv = requireLayoutNode($this$visitAncestors$iv);
            while (layout$iv != null) {
                if ((layout$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv5) != 0) {
                    while (node$iv != null) {
                        if ((node$iv.getKindSet$ui_release() & mask$iv2) != 0) {
                            Object stack$iv = null;
                            Object node$iv2 = node$iv;
                            while (node$iv2 != null) {
                                boolean includeSelf3 = count$iv;
                                int i5 = i3;
                                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                                if (node$iv2 instanceof Object) {
                                    function1.invoke(node$iv2);
                                    mask$iv3 = mask$iv2;
                                } else {
                                    if (!((((Modifier.Node) node$iv2).getKindSet$ui_release() & type) != 0) || !(node$iv2 instanceof DelegatingNode)) {
                                        mask$iv3 = mask$iv2;
                                    } else {
                                        int count$iv4 = 0;
                                        DelegatingNode this_$iv$iv2 = (DelegatingNode) node$iv2;
                                        Modifier.Node node$iv$iv = this_$iv$iv2.getDelegate$ui_release();
                                        while (node$iv$iv != null) {
                                            Object next$iv = node$iv$iv;
                                            if ((next$iv.getKindSet$ui_release() & type) != 0) {
                                                count$iv4++;
                                                this_$iv$iv = this_$iv$iv2;
                                                if (count$iv4 == 1) {
                                                    node$iv2 = next$iv;
                                                    mask$iv4 = mask$iv2;
                                                } else {
                                                    Object obj2 = (MutableVector) stack$iv;
                                                    if (obj2 == null) {
                                                        count$iv3 = count$iv4;
                                                        mask$iv4 = mask$iv2;
                                                        obj2 = new MutableVector(new Modifier.Node[16], 0);
                                                        MutableVector mutableVector = (MutableVector) obj2;
                                                    } else {
                                                        count$iv3 = count$iv4;
                                                        mask$iv4 = mask$iv2;
                                                    }
                                                    stack$iv = obj2;
                                                    Modifier.Node theNode$iv = (Modifier.Node) node$iv2;
                                                    if (theNode$iv != null) {
                                                        MutableVector mutableVector2 = (MutableVector) stack$iv;
                                                        if (mutableVector2 != null) {
                                                            mutableVector2.add(theNode$iv);
                                                        }
                                                        node$iv2 = null;
                                                    }
                                                    MutableVector mutableVector3 = (MutableVector) stack$iv;
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(next$iv);
                                                    }
                                                    count$iv4 = count$iv3;
                                                }
                                            } else {
                                                this_$iv$iv = this_$iv$iv2;
                                                mask$iv4 = mask$iv2;
                                            }
                                            node$iv$iv = node$iv$iv.getChild$ui_release();
                                            DelegatableNode delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default;
                                            this_$iv$iv2 = this_$iv$iv;
                                            mask$iv2 = mask$iv4;
                                        }
                                        mask$iv3 = mask$iv2;
                                        if (count$iv4 == 1) {
                                            DelegatableNode delegatableNode2 = $this$visitAncestors_u2dY_u2dYKmho_u24default;
                                            count$iv2 = includeSelf3;
                                            function1 = block;
                                            i3 = i5;
                                            mask$iv2 = mask$iv3;
                                        }
                                    }
                                }
                                node$iv2 = pop((MutableVector) stack$iv);
                                DelegatableNode delegatableNode3 = $this$visitAncestors_u2dY_u2dYKmho_u24default;
                                count$iv2 = includeSelf3;
                                function1 = block;
                                i3 = i5;
                                mask$iv2 = mask$iv3;
                            }
                        }
                        node$iv = node$iv.getParent$ui_release();
                        DelegatableNode delegatableNode4 = $this$visitAncestors_u2dY_u2dYKmho_u24default;
                        count$iv = count$iv;
                        function12 = block;
                        i4 = i3;
                        mask$iv5 = mask$iv2;
                    }
                    includeSelf2 = count$iv;
                    i2 = i3;
                    mask$iv = mask$iv2;
                } else {
                    includeSelf2 = count$iv;
                    i2 = i4;
                    mask$iv = mask$iv5;
                }
                layout$iv = layout$iv.getParent$ui_release();
                node$iv = (layout$iv == null || (nodes$ui_release = layout$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                DelegatableNode delegatableNode5 = $this$visitAncestors_u2dY_u2dYKmho_u24default;
                count$iv = includeSelf2;
                function12 = block;
                i4 = i2;
                mask$iv5 = mask$iv;
            }
            return;
        }
        boolean z = count$iv;
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    /* renamed from: visitAncestors-Y-YKmho  reason: not valid java name */
    public static final /* synthetic */ <T> void m6503visitAncestorsYYKmho(DelegatableNode $this$visitAncestors_u2dY_u2dYKmho, int type, boolean includeSelf, Function1<? super T, Unit> block) {
        DelegatableNode $this$visitAncestors$iv;
        int mask$iv;
        int i;
        NodeChain nodes$ui_release;
        DelegatableNode $this$visitAncestors$iv2;
        int mask$iv2;
        int count$iv;
        Function1<? super T, Unit> function1;
        DelegatableNode $this$visitAncestors$iv3;
        int mask$iv3;
        DelegatableNode $this$visitAncestors$iv4;
        int mask$iv4;
        int count$iv2;
        Function1<? super T, Unit> function12 = block;
        Intrinsics.checkNotNullParameter($this$visitAncestors_u2dY_u2dYKmho, "$this$visitAncestors");
        Intrinsics.checkNotNullParameter(function12, "block");
        int count$iv3 = 0;
        int mask$iv5 = type;
        DelegatableNode $this$visitAncestors$iv5 = $this$visitAncestors_u2dY_u2dYKmho;
        if ($this$visitAncestors$iv5.getNode().isAttached()) {
            Modifier.Node node$iv = $this$visitAncestors$iv5.getNode();
            if (!includeSelf) {
                node$iv = node$iv.getParent$ui_release();
            }
            LayoutNode layout$iv = requireLayoutNode($this$visitAncestors$iv5);
            while (layout$iv != null) {
                if ((layout$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv5) != 0) {
                    while (node$iv != null) {
                        if ((node$iv.getKindSet$ui_release() & mask$iv2) != 0) {
                            Object stack$iv = null;
                            Object node$iv2 = node$iv;
                            while (node$iv2 != null) {
                                int i2 = count$iv;
                                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                                if (node$iv2 instanceof Object) {
                                    function1.invoke(node$iv2);
                                    mask$iv3 = mask$iv2;
                                    $this$visitAncestors$iv3 = $this$visitAncestors$iv2;
                                } else {
                                    if (!((((Modifier.Node) node$iv2).getKindSet$ui_release() & type) != 0) || !(node$iv2 instanceof DelegatingNode)) {
                                        mask$iv3 = mask$iv2;
                                        $this$visitAncestors$iv3 = $this$visitAncestors$iv2;
                                    } else {
                                        int count$iv4 = 0;
                                        Modifier.Node node$iv$iv = ((DelegatingNode) node$iv2).getDelegate$ui_release();
                                        while (node$iv$iv != null) {
                                            Object next$iv = node$iv$iv;
                                            if ((next$iv.getKindSet$ui_release() & type) != 0) {
                                                count$iv4++;
                                                if (count$iv4 == 1) {
                                                    node$iv2 = next$iv;
                                                    mask$iv4 = mask$iv2;
                                                    $this$visitAncestors$iv4 = $this$visitAncestors$iv2;
                                                } else {
                                                    Object obj = (MutableVector) stack$iv;
                                                    if (obj == null) {
                                                        count$iv2 = count$iv4;
                                                        mask$iv4 = mask$iv2;
                                                        $this$visitAncestors$iv4 = $this$visitAncestors$iv2;
                                                        obj = new MutableVector(new Modifier.Node[16], 0);
                                                        MutableVector mutableVector = (MutableVector) obj;
                                                    } else {
                                                        count$iv2 = count$iv4;
                                                        mask$iv4 = mask$iv2;
                                                        $this$visitAncestors$iv4 = $this$visitAncestors$iv2;
                                                    }
                                                    stack$iv = obj;
                                                    Modifier.Node theNode$iv = (Modifier.Node) node$iv2;
                                                    if (theNode$iv != null) {
                                                        MutableVector mutableVector2 = (MutableVector) stack$iv;
                                                        if (mutableVector2 != null) {
                                                            mutableVector2.add(theNode$iv);
                                                        }
                                                        node$iv2 = null;
                                                    }
                                                    MutableVector mutableVector3 = (MutableVector) stack$iv;
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(next$iv);
                                                    }
                                                    count$iv4 = count$iv2;
                                                }
                                            } else {
                                                mask$iv4 = mask$iv2;
                                                $this$visitAncestors$iv4 = $this$visitAncestors$iv2;
                                            }
                                            node$iv$iv = node$iv$iv.getChild$ui_release();
                                            DelegatableNode delegatableNode = $this$visitAncestors_u2dY_u2dYKmho;
                                            mask$iv2 = mask$iv4;
                                            $this$visitAncestors$iv2 = $this$visitAncestors$iv4;
                                        }
                                        mask$iv3 = mask$iv2;
                                        $this$visitAncestors$iv3 = $this$visitAncestors$iv2;
                                        if (count$iv4 == 1) {
                                            DelegatableNode delegatableNode2 = $this$visitAncestors_u2dY_u2dYKmho;
                                            function1 = block;
                                            count$iv = i2;
                                            mask$iv2 = mask$iv3;
                                            $this$visitAncestors$iv2 = $this$visitAncestors$iv3;
                                        }
                                    }
                                }
                                node$iv2 = pop((MutableVector) stack$iv);
                                DelegatableNode delegatableNode3 = $this$visitAncestors_u2dY_u2dYKmho;
                                function1 = block;
                                count$iv = i2;
                                mask$iv2 = mask$iv3;
                                $this$visitAncestors$iv2 = $this$visitAncestors$iv3;
                            }
                        }
                        node$iv = node$iv.getParent$ui_release();
                        DelegatableNode delegatableNode4 = $this$visitAncestors_u2dY_u2dYKmho;
                        function12 = block;
                        count$iv3 = count$iv;
                        mask$iv5 = mask$iv2;
                        $this$visitAncestors$iv5 = $this$visitAncestors$iv2;
                    }
                    i = count$iv;
                    mask$iv = mask$iv2;
                    $this$visitAncestors$iv = $this$visitAncestors$iv2;
                } else {
                    i = count$iv3;
                    mask$iv = mask$iv5;
                    $this$visitAncestors$iv = $this$visitAncestors$iv5;
                }
                layout$iv = layout$iv.getParent$ui_release();
                node$iv = (layout$iv == null || (nodes$ui_release = layout$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                DelegatableNode delegatableNode5 = $this$visitAncestors_u2dY_u2dYKmho;
                function12 = block;
                count$iv3 = i;
                mask$iv5 = mask$iv;
                $this$visitAncestors$iv5 = $this$visitAncestors$iv;
            }
            return;
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    /* renamed from: visitSelfAndAncestors-5BbP62I  reason: not valid java name */
    public static final /* synthetic */ <T> void m6508visitSelfAndAncestors5BbP62I(DelegatableNode $this$visitSelfAndAncestors_u2d5BbP62I, int type, int untilType, Function1<? super T, Unit> block) {
        int mask$iv;
        Modifier.Node self;
        int i;
        NodeChain nodes$ui_release;
        int mask$iv2;
        Modifier.Node self2;
        int count$iv;
        Function1<? super T, Unit> function1;
        int mask$iv3;
        Modifier.Node self3;
        int mask$iv4;
        Modifier.Node self4;
        int count$iv2;
        Function1<? super T, Unit> function12 = block;
        Intrinsics.checkNotNullParameter($this$visitSelfAndAncestors_u2d5BbP62I, "$this$visitSelfAndAncestors");
        Intrinsics.checkNotNullParameter(function12, "block");
        int count$iv3 = 0;
        Modifier.Node self5 = $this$visitSelfAndAncestors_u2d5BbP62I.getNode();
        int mask$iv5 = type | untilType;
        DelegatableNode $this$visitAncestors$iv = $this$visitSelfAndAncestors_u2d5BbP62I;
        if ($this$visitAncestors$iv.getNode().isAttached()) {
            Modifier.Node node$iv = $this$visitAncestors$iv.getNode();
            LayoutNode layout$iv = requireLayoutNode($this$visitAncestors$iv);
            while (layout$iv != null) {
                if ((layout$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv5) != 0) {
                    while (node$iv != null) {
                        if ((node$iv.getKindSet$ui_release() & mask$iv2) != 0) {
                            Modifier.Node it = node$iv;
                            if (it != self2) {
                                if ((it.getKindSet$ui_release() & untilType) != 0) {
                                    return;
                                }
                            }
                            if ((it.getKindSet$ui_release() & type) != 0) {
                                Object stack$iv = null;
                                Modifier.Node node$iv2 = it;
                                while (node$iv2 != null) {
                                    int i2 = count$iv;
                                    Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                                    if (node$iv2 instanceof Object) {
                                        function1.invoke(node$iv2);
                                        self3 = self2;
                                        mask$iv3 = mask$iv2;
                                    } else {
                                        if (!((node$iv2.getKindSet$ui_release() & type) != 0) || !(node$iv2 instanceof DelegatingNode)) {
                                            self3 = self2;
                                            mask$iv3 = mask$iv2;
                                        } else {
                                            int count$iv4 = 0;
                                            Modifier.Node node$iv$iv = ((DelegatingNode) node$iv2).getDelegate$ui_release();
                                            while (node$iv$iv != null) {
                                                Modifier.Node next$iv = node$iv$iv;
                                                if ((next$iv.getKindSet$ui_release() & type) != 0) {
                                                    count$iv4++;
                                                    if (count$iv4 == 1) {
                                                        node$iv2 = next$iv;
                                                        self4 = self2;
                                                        mask$iv4 = mask$iv2;
                                                    } else {
                                                        Object obj = (MutableVector) stack$iv;
                                                        if (obj == null) {
                                                            count$iv2 = count$iv4;
                                                            self4 = self2;
                                                            mask$iv4 = mask$iv2;
                                                            obj = new MutableVector(new Modifier.Node[16], 0);
                                                            MutableVector mutableVector = (MutableVector) obj;
                                                        } else {
                                                            count$iv2 = count$iv4;
                                                            self4 = self2;
                                                            mask$iv4 = mask$iv2;
                                                        }
                                                        stack$iv = obj;
                                                        Modifier.Node theNode$iv = node$iv2;
                                                        if (theNode$iv != null) {
                                                            MutableVector mutableVector2 = (MutableVector) stack$iv;
                                                            if (mutableVector2 != null) {
                                                                mutableVector2.add(theNode$iv);
                                                            }
                                                            node$iv2 = null;
                                                        }
                                                        MutableVector mutableVector3 = (MutableVector) stack$iv;
                                                        if (mutableVector3 != null) {
                                                            mutableVector3.add(next$iv);
                                                        }
                                                        count$iv4 = count$iv2;
                                                    }
                                                } else {
                                                    self4 = self2;
                                                    mask$iv4 = mask$iv2;
                                                }
                                                node$iv$iv = node$iv$iv.getChild$ui_release();
                                                DelegatableNode delegatableNode = $this$visitSelfAndAncestors_u2d5BbP62I;
                                                Function1<? super T, Unit> function13 = block;
                                                self2 = self4;
                                                mask$iv2 = mask$iv4;
                                            }
                                            self3 = self2;
                                            mask$iv3 = mask$iv2;
                                            if (count$iv4 == 1) {
                                                DelegatableNode delegatableNode2 = $this$visitSelfAndAncestors_u2d5BbP62I;
                                                function1 = block;
                                                count$iv = i2;
                                                self2 = self3;
                                                mask$iv2 = mask$iv3;
                                            }
                                        }
                                    }
                                    node$iv2 = pop((MutableVector) stack$iv);
                                    DelegatableNode delegatableNode3 = $this$visitSelfAndAncestors_u2d5BbP62I;
                                    function1 = block;
                                    count$iv = i2;
                                    self2 = self3;
                                    mask$iv2 = mask$iv3;
                                }
                            }
                        }
                        node$iv = node$iv.getParent$ui_release();
                        DelegatableNode delegatableNode4 = $this$visitSelfAndAncestors_u2d5BbP62I;
                        function12 = block;
                        count$iv3 = count$iv;
                        self5 = self2;
                        mask$iv5 = mask$iv2;
                    }
                    i = count$iv;
                    self = self2;
                    mask$iv = mask$iv2;
                } else {
                    i = count$iv3;
                    self = self5;
                    mask$iv = mask$iv5;
                }
                layout$iv = layout$iv.getParent$ui_release();
                node$iv = (layout$iv == null || (nodes$ui_release = layout$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                DelegatableNode delegatableNode5 = $this$visitSelfAndAncestors_u2d5BbP62I;
                function12 = block;
                count$iv3 = i;
                self5 = self;
                mask$iv5 = mask$iv;
            }
            return;
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    /* renamed from: ancestors-64DMado  reason: not valid java name */
    public static final /* synthetic */ <T> List<T> m6498ancestors64DMado(DelegatableNode $this$ancestors_u2d64DMado, int type) {
        boolean includeSelf$iv;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        int i;
        NodeChain nodes$ui_release;
        boolean includeSelf$iv2;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
        int i2;
        boolean includeSelf$iv3;
        boolean includeSelf$iv4;
        Object result;
        int count$iv$iv;
        Object obj;
        Intrinsics.checkNotNullParameter($this$ancestors_u2d64DMado, "$this$ancestors");
        int i3 = 0;
        Object result2 = null;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3 = $this$ancestors_u2d64DMado;
        boolean includeSelf$iv5 = false;
        int mask$iv$iv = type;
        DelegatableNode $this$visitAncestors$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
        if ($this$visitAncestors$iv$iv.getNode().isAttached()) {
            Modifier.Node node$iv$iv = $this$visitAncestors$iv$iv.getNode().getParent$ui_release();
            LayoutNode layout$iv$iv = requireLayoutNode($this$visitAncestors$iv$iv);
            while (layout$iv$iv != null) {
                if ((layout$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                    while (node$iv$iv != null) {
                        if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            Object stack$iv$iv = null;
                            i2 = i3;
                            Object node$iv$iv2 = node$iv$iv;
                            while (node$iv$iv2 != null) {
                                DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                                if (node$iv$iv2 instanceof Object) {
                                    Object it = node$iv$iv2;
                                    if (result2 == null) {
                                        result2 = (List) new ArrayList();
                                    }
                                    ((List) result2).add(it);
                                    includeSelf$iv3 = includeSelf$iv2;
                                } else {
                                    Modifier.Node this_$iv$iv$iv = (Modifier.Node) node$iv$iv2;
                                    Modifier.Node node = this_$iv$iv$iv;
                                    if (((this_$iv$iv$iv.getKindSet$ui_release() & type) != 0 ? 1 : 0) == 0 || !(node$iv$iv2 instanceof DelegatingNode)) {
                                        includeSelf$iv3 = includeSelf$iv2;
                                        result2 = result2;
                                    } else {
                                        int count$iv$iv2 = 0;
                                        Modifier.Node node$iv$iv$iv = ((DelegatingNode) node$iv$iv2).getDelegate$ui_release();
                                        while (node$iv$iv$iv != null) {
                                            Object next$iv$iv = node$iv$iv$iv;
                                            if ((next$iv$iv.getKindSet$ui_release() & type) != 0) {
                                                count$iv$iv2++;
                                                result = result2;
                                                if (count$iv$iv2 == 1) {
                                                    node$iv$iv2 = next$iv$iv;
                                                    includeSelf$iv4 = includeSelf$iv2;
                                                } else {
                                                    Object obj2 = (MutableVector) stack$iv$iv;
                                                    if (obj2 == null) {
                                                        count$iv$iv = count$iv$iv2;
                                                        includeSelf$iv4 = includeSelf$iv2;
                                                        obj = new MutableVector(new Modifier.Node[16], 0);
                                                        MutableVector mutableVector = (MutableVector) obj;
                                                    } else {
                                                        count$iv$iv = count$iv$iv2;
                                                        includeSelf$iv4 = includeSelf$iv2;
                                                        obj = obj2;
                                                    }
                                                    stack$iv$iv = obj;
                                                    Modifier.Node theNode$iv$iv = (Modifier.Node) node$iv$iv2;
                                                    if (theNode$iv$iv != null) {
                                                        MutableVector mutableVector2 = (MutableVector) stack$iv$iv;
                                                        if (mutableVector2 != null) {
                                                            mutableVector2.add(theNode$iv$iv);
                                                        }
                                                        node$iv$iv2 = null;
                                                    }
                                                    MutableVector mutableVector3 = (MutableVector) stack$iv$iv;
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(next$iv$iv);
                                                    }
                                                    count$iv$iv2 = count$iv$iv;
                                                }
                                            } else {
                                                result = result2;
                                                includeSelf$iv4 = includeSelf$iv2;
                                            }
                                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                            result2 = result;
                                            includeSelf$iv2 = includeSelf$iv4;
                                        }
                                        Object result3 = result2;
                                        includeSelf$iv3 = includeSelf$iv2;
                                        if (count$iv$iv2 == 1) {
                                            DelegatableNode delegatableNode = $this$ancestors_u2d64DMado;
                                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4;
                                            result2 = result3;
                                            includeSelf$iv2 = includeSelf$iv3;
                                        } else {
                                            result2 = result3;
                                        }
                                    }
                                }
                                node$iv$iv2 = pop((MutableVector) stack$iv$iv);
                                DelegatableNode delegatableNode2 = $this$ancestors_u2d64DMado;
                                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4;
                                includeSelf$iv2 = includeSelf$iv3;
                            }
                            Object obj3 = result2;
                        } else {
                            i2 = i3;
                        }
                        node$iv$iv = node$iv$iv.getParent$ui_release();
                        DelegatableNode delegatableNode3 = $this$ancestors_u2d64DMado;
                        i3 = i2;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        includeSelf$iv5 = includeSelf$iv2;
                    }
                    i = i3;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    includeSelf$iv = includeSelf$iv2;
                } else {
                    i = i3;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
                    includeSelf$iv = includeSelf$iv5;
                }
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                node$iv$iv = (layout$iv$iv == null || (nodes$ui_release = layout$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                DelegatableNode delegatableNode4 = $this$ancestors_u2d64DMado;
                i3 = i;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                includeSelf$iv5 = includeSelf$iv;
            }
            int i4 = i3;
            return (List) result2;
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    /* renamed from: nearestAncestor-64DMado  reason: not valid java name */
    public static final /* synthetic */ <T> T m6501nearestAncestor64DMado(DelegatableNode $this$nearestAncestor_u2d64DMado, int type) {
        int i;
        boolean includeSelf$iv;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        int i2;
        NodeChain nodes$ui_release;
        int i3;
        boolean includeSelf$iv2;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
        int i4;
        int i5;
        boolean includeSelf$iv3;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
        int i6;
        boolean includeSelf$iv4;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4;
        int count$iv$iv;
        Intrinsics.checkNotNullParameter($this$nearestAncestor_u2d64DMado, "$this$nearestAncestor");
        int i7 = 0;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv5 = $this$nearestAncestor_u2d64DMado;
        boolean includeSelf$iv5 = false;
        int i8 = 0;
        int mask$iv$iv = type;
        DelegatableNode $this$visitAncestors$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv5;
        if ($this$visitAncestors$iv$iv.getNode().isAttached()) {
            Modifier.Node node$iv$iv = $this$visitAncestors$iv$iv.getNode().getParent$ui_release();
            LayoutNode layout$iv$iv = requireLayoutNode($this$visitAncestors$iv$iv);
            while (layout$iv$iv != null) {
                if ((layout$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                    while (node$iv$iv != null) {
                        if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            Object stack$iv$iv = null;
                            Object node$iv$iv2 = node$iv$iv;
                            while (node$iv$iv2 != null) {
                                int i9 = i4;
                                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                                if (node$iv$iv2 instanceof Object) {
                                    return node$iv$iv2;
                                }
                                Modifier.Node this_$iv$iv$iv = (Modifier.Node) node$iv$iv2;
                                Modifier.Node node = this_$iv$iv$iv;
                                if (((this_$iv$iv$iv.getKindSet$ui_release() & type) != 0 ? 1 : 0) == 0 || !(node$iv$iv2 instanceof DelegatingNode)) {
                                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                                    includeSelf$iv3 = includeSelf$iv2;
                                    i5 = i3;
                                } else {
                                    int count$iv$iv2 = 0;
                                    Modifier.Node node$iv$iv$iv = ((DelegatingNode) node$iv$iv2).getDelegate$ui_release();
                                    while (node$iv$iv$iv != null) {
                                        Object next$iv$iv = node$iv$iv$iv;
                                        if ((next$iv$iv.getKindSet$ui_release() & type) != 0) {
                                            count$iv$iv2++;
                                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                                            if (count$iv$iv2 == 1) {
                                                node$iv$iv2 = next$iv$iv;
                                                includeSelf$iv4 = includeSelf$iv2;
                                                i6 = i3;
                                            } else {
                                                Object obj = (MutableVector) stack$iv$iv;
                                                if (obj == null) {
                                                    count$iv$iv = count$iv$iv2;
                                                    includeSelf$iv4 = includeSelf$iv2;
                                                    i6 = i3;
                                                    obj = new MutableVector(new Modifier.Node[16], 0);
                                                    MutableVector mutableVector = (MutableVector) obj;
                                                } else {
                                                    count$iv$iv = count$iv$iv2;
                                                    includeSelf$iv4 = includeSelf$iv2;
                                                    i6 = i3;
                                                }
                                                stack$iv$iv = obj;
                                                Modifier.Node theNode$iv$iv = (Modifier.Node) node$iv$iv2;
                                                if (theNode$iv$iv != null) {
                                                    MutableVector mutableVector2 = (MutableVector) stack$iv$iv;
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(theNode$iv$iv);
                                                    }
                                                    node$iv$iv2 = null;
                                                }
                                                MutableVector mutableVector3 = (MutableVector) stack$iv$iv;
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(next$iv$iv);
                                                }
                                                count$iv$iv2 = count$iv$iv;
                                            }
                                        } else {
                                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                                            includeSelf$iv4 = includeSelf$iv2;
                                            i6 = i3;
                                        }
                                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4;
                                        includeSelf$iv2 = includeSelf$iv4;
                                        i3 = i6;
                                    }
                                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                                    includeSelf$iv3 = includeSelf$iv2;
                                    i5 = i3;
                                    if (count$iv$iv2 == 1) {
                                        DelegatableNode delegatableNode = $this$nearestAncestor_u2d64DMado;
                                        i4 = i9;
                                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
                                        includeSelf$iv2 = includeSelf$iv3;
                                        i3 = i5;
                                    }
                                }
                                node$iv$iv2 = pop((MutableVector) stack$iv$iv);
                                DelegatableNode delegatableNode2 = $this$nearestAncestor_u2d64DMado;
                                i4 = i9;
                                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
                                includeSelf$iv2 = includeSelf$iv3;
                                i3 = i5;
                            }
                            continue;
                        }
                        node$iv$iv = node$iv$iv.getParent$ui_release();
                        DelegatableNode delegatableNode3 = $this$nearestAncestor_u2d64DMado;
                        i7 = i4;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv5 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        includeSelf$iv5 = includeSelf$iv2;
                        i8 = i3;
                    }
                    i2 = i4;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    includeSelf$iv = includeSelf$iv2;
                    i = i3;
                } else {
                    i2 = i7;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv5;
                    includeSelf$iv = includeSelf$iv5;
                    i = i8;
                }
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                node$iv$iv = (layout$iv$iv == null || (nodes$ui_release = layout$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                DelegatableNode delegatableNode4 = $this$nearestAncestor_u2d64DMado;
                i7 = i2;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv5 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                includeSelf$iv5 = includeSelf$iv;
                i8 = i;
            }
            int i10 = i7;
            return null;
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    /* renamed from: visitSubtree-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m6510visitSubtree6rFNWt0(DelegatableNode $this$visitSubtree_u2d6rFNWt0, int type, Function1<? super T, Unit> block) {
        DelegatableNode $this$visitSubtree$iv;
        int mask$iv;
        int i;
        DelegatableNode $this$visitSubtree$iv2;
        int mask$iv2;
        int count$iv;
        Function1<? super T, Unit> function1;
        DelegatableNode $this$visitSubtree$iv3;
        int mask$iv3;
        DelegatableNode $this$visitSubtree$iv4;
        int mask$iv4;
        int count$iv2;
        Function1<? super T, Unit> function12 = block;
        Intrinsics.checkNotNullParameter($this$visitSubtree_u2d6rFNWt0, "$this$visitSubtree");
        Intrinsics.checkNotNullParameter(function12, "block");
        int count$iv3 = 0;
        int mask$iv5 = type;
        DelegatableNode $this$visitSubtree$iv5 = $this$visitSubtree_u2d6rFNWt0;
        if ($this$visitSubtree$iv5.getNode().isAttached()) {
            Modifier.Node node$iv = $this$visitSubtree$iv5.getNode().getChild$ui_release();
            LayoutNode layout$iv = requireLayoutNode($this$visitSubtree$iv5);
            NestedVectorStack nodes$iv = new NestedVectorStack();
            while (layout$iv != null) {
                Modifier.Node node$iv2 = node$iv == null ? layout$iv.getNodes$ui_release().getHead$ui_release() : node$iv;
                if ((node$iv2.getAggregateChildKindSet$ui_release() & mask$iv5) != 0) {
                    while (node$iv2 != null) {
                        if ((node$iv2.getKindSet$ui_release() & mask$iv2) != 0) {
                            Object stack$iv = null;
                            Object node$iv3 = node$iv2;
                            while (node$iv3 != null) {
                                int i2 = count$iv;
                                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                                if (node$iv3 instanceof Object) {
                                    function1.invoke(node$iv3);
                                    mask$iv3 = mask$iv2;
                                    $this$visitSubtree$iv3 = $this$visitSubtree$iv2;
                                } else {
                                    if (!((((Modifier.Node) node$iv3).getKindSet$ui_release() & type) != 0) || !(node$iv3 instanceof DelegatingNode)) {
                                        mask$iv3 = mask$iv2;
                                        $this$visitSubtree$iv3 = $this$visitSubtree$iv2;
                                    } else {
                                        int count$iv4 = 0;
                                        Modifier.Node node$iv$iv = ((DelegatingNode) node$iv3).getDelegate$ui_release();
                                        while (node$iv$iv != null) {
                                            Object next$iv = node$iv$iv;
                                            if ((next$iv.getKindSet$ui_release() & type) != 0) {
                                                count$iv4++;
                                                if (count$iv4 == 1) {
                                                    node$iv3 = next$iv;
                                                    mask$iv4 = mask$iv2;
                                                    $this$visitSubtree$iv4 = $this$visitSubtree$iv2;
                                                } else {
                                                    Object obj = (MutableVector) stack$iv;
                                                    if (obj == null) {
                                                        count$iv2 = count$iv4;
                                                        mask$iv4 = mask$iv2;
                                                        $this$visitSubtree$iv4 = $this$visitSubtree$iv2;
                                                        obj = new MutableVector(new Modifier.Node[16], 0);
                                                        MutableVector mutableVector = (MutableVector) obj;
                                                    } else {
                                                        count$iv2 = count$iv4;
                                                        mask$iv4 = mask$iv2;
                                                        $this$visitSubtree$iv4 = $this$visitSubtree$iv2;
                                                    }
                                                    stack$iv = obj;
                                                    Modifier.Node theNode$iv = (Modifier.Node) node$iv3;
                                                    if (theNode$iv != null) {
                                                        MutableVector mutableVector2 = (MutableVector) stack$iv;
                                                        if (mutableVector2 != null) {
                                                            mutableVector2.add(theNode$iv);
                                                        }
                                                        node$iv3 = null;
                                                    }
                                                    MutableVector mutableVector3 = (MutableVector) stack$iv;
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(next$iv);
                                                    }
                                                    count$iv4 = count$iv2;
                                                }
                                            } else {
                                                mask$iv4 = mask$iv2;
                                                $this$visitSubtree$iv4 = $this$visitSubtree$iv2;
                                            }
                                            node$iv$iv = node$iv$iv.getChild$ui_release();
                                            DelegatableNode delegatableNode = $this$visitSubtree_u2d6rFNWt0;
                                            mask$iv2 = mask$iv4;
                                            $this$visitSubtree$iv2 = $this$visitSubtree$iv4;
                                        }
                                        mask$iv3 = mask$iv2;
                                        $this$visitSubtree$iv3 = $this$visitSubtree$iv2;
                                        if (count$iv4 == 1) {
                                            DelegatableNode delegatableNode2 = $this$visitSubtree_u2d6rFNWt0;
                                            function1 = block;
                                            count$iv = i2;
                                            mask$iv2 = mask$iv3;
                                            $this$visitSubtree$iv2 = $this$visitSubtree$iv3;
                                        }
                                    }
                                }
                                node$iv3 = pop((MutableVector) stack$iv);
                                DelegatableNode delegatableNode3 = $this$visitSubtree_u2d6rFNWt0;
                                function1 = block;
                                count$iv = i2;
                                mask$iv2 = mask$iv3;
                                $this$visitSubtree$iv2 = $this$visitSubtree$iv3;
                            }
                        }
                        node$iv2 = node$iv2.getChild$ui_release();
                        DelegatableNode delegatableNode4 = $this$visitSubtree_u2d6rFNWt0;
                        function12 = block;
                        count$iv3 = count$iv;
                        mask$iv5 = mask$iv2;
                        $this$visitSubtree$iv5 = $this$visitSubtree$iv2;
                    }
                    i = count$iv;
                    mask$iv = mask$iv2;
                    $this$visitSubtree$iv = $this$visitSubtree$iv2;
                } else {
                    i = count$iv3;
                    mask$iv = mask$iv5;
                    $this$visitSubtree$iv = $this$visitSubtree$iv5;
                }
                node$iv = null;
                nodes$iv.push(layout$iv.get_children$ui_release());
                layout$iv = nodes$iv.isNotEmpty() ? (LayoutNode) nodes$iv.pop() : null;
                DelegatableNode delegatableNode5 = $this$visitSubtree_u2d6rFNWt0;
                function12 = block;
                count$iv3 = i;
                mask$iv5 = mask$iv;
                $this$visitSubtree$iv5 = $this$visitSubtree$iv;
            }
            return;
        }
        throw new IllegalStateException("visitSubtree called on an unattached node".toString());
    }

    /* renamed from: visitChildren-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m6505visitChildren6rFNWt0(DelegatableNode $this$visitChildren_u2d6rFNWt0, int type, Function1<? super T, Unit> block) {
        DelegatableNode $this$visitChildren$iv;
        Function1<? super T, Unit> function1;
        DelegatableNode $this$visitChildren$iv2;
        int mask$iv;
        boolean z;
        DelegatableNode $this$visitChildren$iv3;
        int mask$iv2;
        int count$iv;
        Function1<? super T, Unit> function12 = block;
        Intrinsics.checkNotNullParameter($this$visitChildren_u2d6rFNWt0, "$this$visitChildren");
        Intrinsics.checkNotNullParameter(function12, "block");
        int count$iv2 = false;
        int mask$iv3 = type;
        DelegatableNode $this$visitChildren$iv4 = $this$visitChildren_u2d6rFNWt0;
        if ($this$visitChildren$iv4.getNode().isAttached()) {
            boolean z2 = false;
            MutableVector branches$iv = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$iv = $this$visitChildren$iv4.getNode().getChild$ui_release();
            if (child$iv == null) {
                addLayoutNodeChildren(branches$iv, $this$visitChildren$iv4.getNode());
            } else {
                branches$iv.add(child$iv);
            }
            while (branches$iv.isNotEmpty()) {
                Modifier.Node branch$iv = (Modifier.Node) branches$iv.removeAt(branches$iv.getSize() - 1);
                if ((branch$iv.getAggregateChildKindSet$ui_release() & mask$iv3) != 0) {
                    Modifier.Node node$iv = branch$iv;
                    while (true) {
                        if (node$iv == null) {
                            int i = count$iv2;
                            int i2 = mask$iv3;
                            DelegatableNode $this$visitChildren$iv5 = $this$visitChildren$iv;
                            boolean z3 = z2;
                            DelegatableNode delegatableNode = $this$visitChildren_u2d6rFNWt0;
                            function12 = block;
                            $this$visitChildren$iv4 = $this$visitChildren$iv5;
                            break;
                        } else if ((node$iv.getKindSet$ui_release() & mask$iv3) != 0) {
                            Object stack$iv = null;
                            Object node$iv2 = node$iv;
                            while (node$iv2 != null) {
                                int i3 = count$iv2;
                                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                                if (node$iv2 instanceof Object) {
                                    function1.invoke(node$iv2);
                                    mask$iv = mask$iv3;
                                    $this$visitChildren$iv2 = $this$visitChildren$iv;
                                    z = true;
                                } else {
                                    if (!((((Modifier.Node) node$iv2).getKindSet$ui_release() & type) != 0) || !(node$iv2 instanceof DelegatingNode)) {
                                        mask$iv = mask$iv3;
                                        $this$visitChildren$iv2 = $this$visitChildren$iv;
                                        z = true;
                                    } else {
                                        int count$iv3 = 0;
                                        Modifier.Node node$iv$iv = ((DelegatingNode) node$iv2).getDelegate$ui_release();
                                        while (node$iv$iv != null) {
                                            Object next$iv = node$iv$iv;
                                            if ((next$iv.getKindSet$ui_release() & type) != 0) {
                                                count$iv3++;
                                                if (count$iv3 == 1) {
                                                    node$iv2 = next$iv;
                                                    mask$iv2 = mask$iv3;
                                                    $this$visitChildren$iv3 = $this$visitChildren$iv;
                                                } else {
                                                    Object obj = (MutableVector) stack$iv;
                                                    if (obj == null) {
                                                        count$iv = count$iv3;
                                                        mask$iv2 = mask$iv3;
                                                        $this$visitChildren$iv3 = $this$visitChildren$iv;
                                                        obj = new MutableVector(new Modifier.Node[16], 0);
                                                        MutableVector mutableVector = (MutableVector) obj;
                                                    } else {
                                                        count$iv = count$iv3;
                                                        mask$iv2 = mask$iv3;
                                                        $this$visitChildren$iv3 = $this$visitChildren$iv;
                                                    }
                                                    stack$iv = obj;
                                                    Modifier.Node theNode$iv = (Modifier.Node) node$iv2;
                                                    if (theNode$iv != null) {
                                                        MutableVector mutableVector2 = (MutableVector) stack$iv;
                                                        if (mutableVector2 != null) {
                                                            mutableVector2.add(theNode$iv);
                                                        }
                                                        node$iv2 = null;
                                                    }
                                                    MutableVector mutableVector3 = (MutableVector) stack$iv;
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(next$iv);
                                                    }
                                                    count$iv3 = count$iv;
                                                }
                                            } else {
                                                mask$iv2 = mask$iv3;
                                                $this$visitChildren$iv3 = $this$visitChildren$iv;
                                            }
                                            node$iv$iv = node$iv$iv.getChild$ui_release();
                                            DelegatableNode delegatableNode2 = $this$visitChildren_u2d6rFNWt0;
                                            Function1<? super T, Unit> function13 = block;
                                            mask$iv3 = mask$iv2;
                                            $this$visitChildren$iv = $this$visitChildren$iv3;
                                        }
                                        mask$iv = mask$iv3;
                                        $this$visitChildren$iv2 = $this$visitChildren$iv;
                                        z = true;
                                        if (count$iv3 == 1) {
                                            DelegatableNode delegatableNode3 = $this$visitChildren_u2d6rFNWt0;
                                            count$iv2 = i3;
                                            mask$iv3 = mask$iv;
                                            $this$visitChildren$iv = $this$visitChildren$iv2;
                                            function1 = block;
                                        }
                                    }
                                }
                                node$iv2 = pop((MutableVector) stack$iv);
                                DelegatableNode delegatableNode4 = $this$visitChildren_u2d6rFNWt0;
                                boolean z4 = z;
                                count$iv2 = i3;
                                mask$iv3 = mask$iv;
                                $this$visitChildren$iv = $this$visitChildren$iv2;
                                function1 = block;
                            }
                            int i4 = count$iv2;
                            int i5 = mask$iv3;
                            DelegatableNode delegatableNode5 = $this$visitChildren_u2d6rFNWt0;
                            function12 = block;
                            z2 = false;
                            $this$visitChildren$iv4 = $this$visitChildren$iv;
                        } else {
                            int i6 = count$iv2;
                            int i7 = mask$iv3;
                            DelegatableNode $this$visitChildren$iv6 = $this$visitChildren$iv;
                            boolean z5 = z2;
                            node$iv = node$iv.getChild$ui_release();
                            DelegatableNode delegatableNode6 = $this$visitChildren_u2d6rFNWt0;
                            $this$visitChildren$iv4 = $this$visitChildren$iv6;
                            function12 = block;
                        }
                    }
                } else {
                    addLayoutNodeChildren(branches$iv, branch$iv);
                }
            }
            return;
        }
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    /* renamed from: visitSelfAndChildren-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m6509visitSelfAndChildren6rFNWt0(DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0, int type, Function1<? super T, Unit> block) {
        int count$iv;
        int i;
        int count$iv2;
        int mask$iv;
        Function1<? super T, Unit> function1;
        boolean z;
        DelegatableNode $this$visitChildren$iv;
        int mask$iv2;
        boolean z2;
        DelegatableNode $this$visitChildren$iv2;
        int mask$iv3;
        Object obj;
        int i2;
        int i3;
        Function1<? super T, Unit> function12 = block;
        Intrinsics.checkNotNullParameter($this$visitSelfAndChildren_u2d6rFNWt0, "$this$visitSelfAndChildren");
        Intrinsics.checkNotNullParameter(function12, "block");
        int i4 = 0;
        Object stack$iv = null;
        Object node$iv = $this$visitSelfAndChildren_u2d6rFNWt0.getNode();
        while (true) {
            count$iv = 3;
            i = false;
            int i5 = 1;
            if (node$iv == null) {
                break;
            }
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node$iv instanceof Object) {
                function12.invoke(node$iv);
                i2 = i4;
            } else {
                if (((((Modifier.Node) node$iv).getKindSet$ui_release() & type) != 0 ? 1 : null) == null || !(node$iv instanceof DelegatingNode)) {
                    i2 = i4;
                } else {
                    int count$iv3 = 0;
                    Modifier.Node node$iv$iv = ((DelegatingNode) node$iv).getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        Object next$iv = node$iv$iv;
                        if (((next$iv.getKindSet$ui_release() & type) != 0 ? i5 : 0) != 0) {
                            count$iv3++;
                            if (count$iv3 == i5) {
                                node$iv = next$iv;
                                i3 = i4;
                            } else {
                                Object obj2 = (MutableVector) stack$iv;
                                if (obj2 == null) {
                                    i3 = i4;
                                    Object mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    MutableVector mutableVector2 = (MutableVector) mutableVector;
                                    obj2 = mutableVector;
                                } else {
                                    i3 = i4;
                                }
                                stack$iv = obj2;
                                Modifier.Node theNode$iv = (Modifier.Node) node$iv;
                                if (theNode$iv != null) {
                                    MutableVector mutableVector3 = (MutableVector) stack$iv;
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(theNode$iv);
                                    }
                                    node$iv = null;
                                }
                                MutableVector mutableVector4 = (MutableVector) stack$iv;
                                if (mutableVector4 != null) {
                                    mutableVector4.add(next$iv);
                                }
                            }
                        } else {
                            i3 = i4;
                        }
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        i5 = 1;
                        DelegatableNode delegatableNode = $this$visitSelfAndChildren_u2d6rFNWt0;
                        i4 = i3;
                    }
                    i2 = i4;
                    if (count$iv3 == 1) {
                        DelegatableNode delegatableNode2 = $this$visitSelfAndChildren_u2d6rFNWt0;
                        i4 = i2;
                    }
                }
            }
            node$iv = pop((MutableVector) stack$iv);
            DelegatableNode delegatableNode3 = $this$visitSelfAndChildren_u2d6rFNWt0;
            i4 = i2;
        }
        int i6 = i4;
        int mask$iv4 = type;
        DelegatableNode $this$visitChildren$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0;
        boolean z3 = false;
        if ($this$visitChildren$iv3.getNode().isAttached()) {
            MutableVector branches$iv = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$iv = $this$visitChildren$iv3.getNode().getChild$ui_release();
            if (child$iv == null) {
                addLayoutNodeChildren(branches$iv, $this$visitChildren$iv3.getNode());
            } else {
                branches$iv.add(child$iv);
            }
            while (branches$iv.isNotEmpty()) {
                Modifier.Node branch$iv = (Modifier.Node) branches$iv.removeAt(branches$iv.getSize() - 1);
                if ((branch$iv.getAggregateChildKindSet$ui_release() & mask$iv4) != 0) {
                    Modifier.Node node$iv2 = branch$iv;
                    while (true) {
                        if (node$iv2 == null) {
                            int mask$iv5 = mask$iv;
                            DelegatableNode delegatableNode4 = $this$visitChildren$iv3;
                            boolean z4 = z3;
                            int mask$iv6 = i;
                            function12 = block;
                            mask$iv4 = mask$iv5;
                            count$iv = 3;
                            break;
                        } else if ((node$iv2.getKindSet$ui_release() & mask$iv) != 0) {
                            Object stack$iv2 = null;
                            Object node$iv3 = node$iv2;
                            while (node$iv3 != null) {
                                Intrinsics.reifiedOperationMarker(count$iv2, ExifInterface.GPS_DIRECTION_TRUE);
                                if (node$iv3 instanceof Object) {
                                    function1.invoke(node$iv3);
                                    mask$iv2 = mask$iv;
                                    $this$visitChildren$iv = $this$visitChildren$iv3;
                                    z = z3;
                                } else {
                                    if (!((((Modifier.Node) node$iv3).getKindSet$ui_release() & type) != 0) || !(node$iv3 instanceof DelegatingNode)) {
                                        mask$iv2 = mask$iv;
                                        $this$visitChildren$iv = $this$visitChildren$iv3;
                                        z = z3;
                                    } else {
                                        int count$iv4 = 0;
                                        Modifier.Node node$iv$iv2 = ((DelegatingNode) node$iv3).getDelegate$ui_release();
                                        while (node$iv$iv2 != null) {
                                            Object next$iv2 = node$iv$iv2;
                                            if ((next$iv2.getKindSet$ui_release() & type) != 0) {
                                                count$iv4++;
                                                mask$iv3 = mask$iv;
                                                if (count$iv4 == 1) {
                                                    node$iv3 = next$iv2;
                                                    $this$visitChildren$iv2 = $this$visitChildren$iv3;
                                                    z2 = z3;
                                                } else {
                                                    Object obj3 = (MutableVector) stack$iv2;
                                                    if (obj3 == null) {
                                                        $this$visitChildren$iv2 = $this$visitChildren$iv3;
                                                        z2 = z3;
                                                        obj = new MutableVector(new Modifier.Node[16], 0);
                                                        MutableVector mutableVector5 = (MutableVector) obj;
                                                    } else {
                                                        $this$visitChildren$iv2 = $this$visitChildren$iv3;
                                                        z2 = z3;
                                                        obj = obj3;
                                                    }
                                                    stack$iv2 = obj;
                                                    Modifier.Node theNode$iv2 = (Modifier.Node) node$iv3;
                                                    if (theNode$iv2 != null) {
                                                        MutableVector mutableVector6 = (MutableVector) stack$iv2;
                                                        if (mutableVector6 != null) {
                                                            mutableVector6.add(theNode$iv2);
                                                        }
                                                        node$iv3 = null;
                                                    }
                                                    MutableVector mutableVector7 = (MutableVector) stack$iv2;
                                                    if (mutableVector7 != null) {
                                                        mutableVector7.add(next$iv2);
                                                    }
                                                }
                                            } else {
                                                mask$iv3 = mask$iv;
                                                $this$visitChildren$iv2 = $this$visitChildren$iv3;
                                                z2 = z3;
                                            }
                                            node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                                            Function1<? super T, Unit> function13 = block;
                                            mask$iv = mask$iv3;
                                            $this$visitChildren$iv3 = $this$visitChildren$iv2;
                                            z3 = z2;
                                        }
                                        mask$iv2 = mask$iv;
                                        $this$visitChildren$iv = $this$visitChildren$iv3;
                                        z = z3;
                                        if (count$iv4 == 1) {
                                            function1 = block;
                                            mask$iv = mask$iv2;
                                            $this$visitChildren$iv3 = $this$visitChildren$iv;
                                            z3 = z;
                                            count$iv2 = 3;
                                        }
                                    }
                                }
                                node$iv3 = pop((MutableVector) stack$iv2);
                                function1 = block;
                                mask$iv = mask$iv2;
                                $this$visitChildren$iv3 = $this$visitChildren$iv;
                                z3 = z;
                                count$iv2 = 3;
                            }
                            DelegatableNode delegatableNode5 = $this$visitChildren$iv3;
                            boolean z5 = z3;
                            function12 = block;
                            i = false;
                            mask$iv4 = mask$iv;
                            count$iv = 3;
                        } else {
                            int mask$iv7 = mask$iv;
                            DelegatableNode delegatableNode6 = $this$visitChildren$iv3;
                            boolean z6 = z3;
                            int mask$iv8 = i;
                            node$iv2 = node$iv2.getChild$ui_release();
                            function12 = block;
                            mask$iv4 = mask$iv7;
                            count$iv = 3;
                        }
                    }
                } else {
                    addLayoutNodeChildren(branches$iv, branch$iv);
                }
            }
            return;
        }
        int i7 = mask$iv4;
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    /* renamed from: visitSubtreeIf-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m6511visitSubtreeIf6rFNWt0(DelegatableNode $this$visitSubtreeIf_u2d6rFNWt0, int type, Function1<? super T, Boolean> block) {
        DelegatableNode $this$visitSubtreeIf$iv;
        int mask$iv;
        int count$iv;
        boolean z;
        Function1<? super T, Boolean> function1;
        DelegatableNode $this$visitSubtreeIf$iv2;
        int mask$iv2;
        int i;
        DelegatableNode $this$visitSubtreeIf$iv3;
        boolean z2;
        boolean diveDeeper$iv;
        DelegatableNode $this$visitSubtreeIf$iv4;
        int mask$iv3;
        boolean z3;
        DelegatableNode $this$visitSubtreeIf$iv5;
        int mask$iv4;
        int count$iv2;
        Function1<? super T, Boolean> function12 = block;
        Intrinsics.checkNotNullParameter($this$visitSubtreeIf_u2d6rFNWt0, "$this$visitSubtreeIf");
        Intrinsics.checkNotNullParameter(function12, "block");
        int count$iv3 = 0;
        int mask$iv5 = type;
        DelegatableNode $this$visitSubtreeIf$iv6 = $this$visitSubtreeIf_u2d6rFNWt0;
        if ($this$visitSubtreeIf$iv6.getNode().isAttached()) {
            DelegatableNode $this$visitSubtreeIf$iv7 = null;
            MutableVector branches$iv = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$iv = $this$visitSubtreeIf$iv6.getNode().getChild$ui_release();
            if (child$iv == null) {
                addLayoutNodeChildren(branches$iv, $this$visitSubtreeIf$iv6.getNode());
            } else {
                branches$iv.add(child$iv);
            }
            while (branches$iv.isNotEmpty()) {
                boolean z4 = true;
                Modifier.Node branch$iv = (Modifier.Node) branches$iv.removeAt(branches$iv.getSize() - 1);
                if ((branch$iv.getAggregateChildKindSet$ui_release() & mask$iv) != 0) {
                    Modifier.Node node$iv = branch$iv;
                    while (true) {
                        if (node$iv == null) {
                            break;
                        }
                        if ((node$iv.getKindSet$ui_release() & mask$iv) != 0) {
                            Object stack$iv = null;
                            Object node$iv2 = node$iv;
                            while (true) {
                                if (node$iv2 == null) {
                                    i = count$iv;
                                    mask$iv2 = mask$iv;
                                    $this$visitSubtreeIf$iv2 = $this$visitSubtreeIf$iv;
                                    z2 = z;
                                    $this$visitSubtreeIf$iv3 = null;
                                    diveDeeper$iv = z2;
                                    break;
                                }
                                i = count$iv;
                                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                                if (!(node$iv2 instanceof Object)) {
                                    if (!((((Modifier.Node) node$iv2).getKindSet$ui_release() & type) != 0) || !(node$iv2 instanceof DelegatingNode)) {
                                        mask$iv3 = mask$iv;
                                        $this$visitSubtreeIf$iv4 = $this$visitSubtreeIf$iv;
                                        z3 = true;
                                    } else {
                                        int count$iv4 = 0;
                                        Modifier.Node node$iv$iv = ((DelegatingNode) node$iv2).getDelegate$ui_release();
                                        while (node$iv$iv != null) {
                                            Object next$iv = node$iv$iv;
                                            if ((next$iv.getKindSet$ui_release() & type) != 0) {
                                                count$iv4++;
                                                if (count$iv4 == 1) {
                                                    node$iv2 = next$iv;
                                                    mask$iv4 = mask$iv;
                                                    $this$visitSubtreeIf$iv5 = $this$visitSubtreeIf$iv;
                                                } else {
                                                    Object obj = (MutableVector) stack$iv;
                                                    if (obj == null) {
                                                        count$iv2 = count$iv4;
                                                        mask$iv4 = mask$iv;
                                                        $this$visitSubtreeIf$iv5 = $this$visitSubtreeIf$iv;
                                                        obj = new MutableVector(new Modifier.Node[16], 0);
                                                        MutableVector mutableVector = (MutableVector) obj;
                                                    } else {
                                                        count$iv2 = count$iv4;
                                                        mask$iv4 = mask$iv;
                                                        $this$visitSubtreeIf$iv5 = $this$visitSubtreeIf$iv;
                                                    }
                                                    stack$iv = obj;
                                                    Modifier.Node theNode$iv = (Modifier.Node) node$iv2;
                                                    if (theNode$iv != null) {
                                                        MutableVector mutableVector2 = (MutableVector) stack$iv;
                                                        if (mutableVector2 != null) {
                                                            mutableVector2.add(theNode$iv);
                                                        }
                                                        node$iv2 = null;
                                                    }
                                                    MutableVector mutableVector3 = (MutableVector) stack$iv;
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(next$iv);
                                                    }
                                                    count$iv4 = count$iv2;
                                                }
                                            } else {
                                                mask$iv4 = mask$iv;
                                                $this$visitSubtreeIf$iv5 = $this$visitSubtreeIf$iv;
                                            }
                                            node$iv$iv = node$iv$iv.getChild$ui_release();
                                            DelegatableNode delegatableNode = $this$visitSubtreeIf_u2d6rFNWt0;
                                            Function1<? super T, Boolean> function13 = block;
                                            mask$iv = mask$iv4;
                                            $this$visitSubtreeIf$iv = $this$visitSubtreeIf$iv5;
                                        }
                                        mask$iv3 = mask$iv;
                                        $this$visitSubtreeIf$iv4 = $this$visitSubtreeIf$iv;
                                        z3 = true;
                                        if (count$iv4 == 1) {
                                            function1 = block;
                                            z = true;
                                            count$iv = i;
                                            mask$iv = mask$iv3;
                                            $this$visitSubtreeIf$iv = $this$visitSubtreeIf$iv4;
                                            DelegatableNode delegatableNode2 = $this$visitSubtreeIf_u2d6rFNWt0;
                                        }
                                    }
                                } else if (!function1.invoke(node$iv2).booleanValue()) {
                                    mask$iv2 = mask$iv;
                                    $this$visitSubtreeIf$iv2 = $this$visitSubtreeIf$iv;
                                    z2 = true;
                                    $this$visitSubtreeIf$iv3 = null;
                                    diveDeeper$iv = false;
                                    break;
                                } else {
                                    mask$iv3 = mask$iv;
                                    $this$visitSubtreeIf$iv4 = $this$visitSubtreeIf$iv;
                                    z3 = true;
                                }
                                node$iv2 = pop((MutableVector) stack$iv);
                                function1 = block;
                                z = z3;
                                count$iv = i;
                                mask$iv = mask$iv3;
                                $this$visitSubtreeIf$iv = $this$visitSubtreeIf$iv4;
                                DelegatableNode delegatableNode3 = $this$visitSubtreeIf_u2d6rFNWt0;
                            }
                            if (!diveDeeper$iv) {
                                DelegatableNode delegatableNode4 = $this$visitSubtreeIf_u2d6rFNWt0;
                                function12 = block;
                                $this$visitSubtreeIf$iv7 = $this$visitSubtreeIf$iv3;
                                count$iv3 = i;
                                mask$iv5 = mask$iv2;
                                $this$visitSubtreeIf$iv6 = $this$visitSubtreeIf$iv2;
                                break;
                            }
                        } else {
                            i = count$iv;
                            mask$iv2 = mask$iv;
                            $this$visitSubtreeIf$iv2 = $this$visitSubtreeIf$iv;
                            z2 = z;
                            $this$visitSubtreeIf$iv3 = $this$visitSubtreeIf$iv7;
                        }
                        node$iv = node$iv.getChild$ui_release();
                        function12 = block;
                        z4 = z2;
                        $this$visitSubtreeIf$iv7 = $this$visitSubtreeIf$iv3;
                        count$iv = i;
                        mask$iv = mask$iv2;
                        $this$visitSubtreeIf$iv = $this$visitSubtreeIf$iv2;
                        DelegatableNode delegatableNode5 = $this$visitSubtreeIf_u2d6rFNWt0;
                    }
                }
                addLayoutNodeChildren(branches$iv, branch$iv);
                DelegatableNode delegatableNode6 = $this$visitSubtreeIf_u2d6rFNWt0;
                function12 = block;
                $this$visitSubtreeIf$iv7 = $this$visitSubtreeIf$iv7;
                count$iv3 = count$iv;
                mask$iv5 = mask$iv;
                $this$visitSubtreeIf$iv6 = $this$visitSubtreeIf$iv;
            }
            return;
        }
        throw new IllegalStateException("visitSubtreeIf called on an unattached node".toString());
    }

    /* renamed from: has-64DMado  reason: not valid java name */
    public static final boolean m6500has64DMado(DelegatableNode $this$has_u2d64DMado, int type) {
        Intrinsics.checkNotNullParameter($this$has_u2d64DMado, "$this$has");
        return ($this$has_u2d64DMado.getNode().getAggregateChildKindSet$ui_release() & type) != 0;
    }

    /* renamed from: requireCoordinator-64DMado  reason: not valid java name */
    public static final NodeCoordinator m6502requireCoordinator64DMado(DelegatableNode $this$requireCoordinator_u2d64DMado, int kind) {
        Intrinsics.checkNotNullParameter($this$requireCoordinator_u2d64DMado, "$this$requireCoordinator");
        NodeCoordinator coordinator = $this$requireCoordinator_u2d64DMado.getNode().getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator);
        if (coordinator.getTail() != $this$requireCoordinator_u2d64DMado || !NodeKindKt.m6675getIncludeSelfInTraversalH91voCI(kind)) {
            return coordinator;
        }
        NodeCoordinator wrapped$ui_release = coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        return wrapped$ui_release;
    }

    public static final LayoutNode requireLayoutNode(DelegatableNode $this$requireLayoutNode) {
        Intrinsics.checkNotNullParameter($this$requireLayoutNode, "<this>");
        NodeCoordinator coordinator$ui_release = $this$requireLayoutNode.getNode().getCoordinator$ui_release();
        if (coordinator$ui_release != null) {
            return coordinator$ui_release.getLayoutNode();
        }
        throw new IllegalStateException("Cannot obtain node coordinator. Is the Modifier.Node attached?".toString());
    }

    public static final Owner requireOwner(DelegatableNode $this$requireOwner) {
        Intrinsics.checkNotNullParameter($this$requireOwner, "<this>");
        Owner owner$ui_release = requireLayoutNode($this$requireOwner).getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final Density requireDensity(DelegatableNode $this$requireDensity) {
        Intrinsics.checkNotNullParameter($this$requireDensity, "<this>");
        return requireLayoutNode($this$requireDensity).getDensity();
    }

    public static final LayoutDirection requireLayoutDirection(DelegatableNode $this$requireLayoutDirection) {
        Intrinsics.checkNotNullParameter($this$requireLayoutDirection, "<this>");
        return requireLayoutNode($this$requireLayoutDirection).getLayoutDirection();
    }

    public static final void invalidateSubtree(DelegatableNode $this$invalidateSubtree) {
        Intrinsics.checkNotNullParameter($this$invalidateSubtree, "<this>");
        if ($this$invalidateSubtree.getNode().isAttached()) {
            LayoutNode.invalidateSubtree$default(requireLayoutNode($this$invalidateSubtree), false, 1, (Object) null);
        }
    }

    public static final LayoutModifierNode asLayoutModifierNode(Modifier.Node $this$asLayoutModifierNode) {
        Modifier.Node node;
        Intrinsics.checkNotNullParameter($this$asLayoutModifierNode, "<this>");
        if ((($this$asLayoutModifierNode.getKindSet$ui_release() & NodeKind.m6666constructorimpl(2)) != 0 ? 1 : 0) == 0) {
            return null;
        }
        if ($this$asLayoutModifierNode instanceof LayoutModifierNode) {
            return (LayoutModifierNode) $this$asLayoutModifierNode;
        }
        if ($this$asLayoutModifierNode instanceof DelegatingNode) {
            Modifier.Node node2 = ((DelegatingNode) $this$asLayoutModifierNode).getDelegate$ui_release();
            while (node2 != null) {
                if (node2 instanceof LayoutModifierNode) {
                    return (LayoutModifierNode) node2;
                }
                if (node2 instanceof DelegatingNode) {
                    if (((node2.getKindSet$ui_release() & NodeKind.m6666constructorimpl(2)) != 0 ? 1 : 0) != 0) {
                        node = ((DelegatingNode) node2).getDelegate$ui_release();
                        node2 = node;
                    }
                }
                node = node2.getChild$ui_release();
                node2 = node;
            }
        }
        return null;
    }

    /* renamed from: dispatchForKind-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m6499dispatchForKind6rFNWt0(Modifier.Node $this$dispatchForKind_u2d6rFNWt0, int kind, Function1<? super T, Unit> block) {
        Function1<? super T, Unit> function1 = block;
        Intrinsics.checkNotNullParameter($this$dispatchForKind_u2d6rFNWt0, "$this$dispatchForKind");
        Intrinsics.checkNotNullParameter(function1, "block");
        Object stack = null;
        Object node = $this$dispatchForKind_u2d6rFNWt0;
        while (node != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node instanceof Object) {
                function1.invoke(node);
            } else {
                int i = 1;
                if (((((Modifier.Node) node).getKindSet$ui_release() & kind) != 0 ? 1 : null) != null && (node instanceof DelegatingNode)) {
                    int count = 0;
                    Modifier.Node node$iv = ((DelegatingNode) node).getDelegate$ui_release();
                    while (node$iv != null) {
                        Object next = node$iv;
                        if (((next.getKindSet$ui_release() & kind) != 0 ? i : 0) != 0) {
                            count++;
                            if (count == i) {
                                node = next;
                            } else {
                                Object obj = (MutableVector) stack;
                                if (obj == null) {
                                    Object mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    MutableVector mutableVector2 = (MutableVector) mutableVector;
                                    obj = mutableVector;
                                }
                                stack = obj;
                                Modifier.Node theNode = (Modifier.Node) node;
                                if (theNode != null) {
                                    MutableVector mutableVector3 = (MutableVector) stack;
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(theNode);
                                    }
                                    node = null;
                                }
                                MutableVector mutableVector4 = (MutableVector) stack;
                                if (mutableVector4 != null) {
                                    mutableVector4.add(next);
                                }
                            }
                        }
                        node$iv = node$iv.getChild$ui_release();
                        Function1<? super T, Unit> function12 = block;
                        i = 1;
                    }
                    if (count == 1) {
                        function1 = block;
                    }
                }
            }
            node = pop((MutableVector) stack);
            function1 = block;
        }
    }

    /* access modifiers changed from: private */
    public static final Modifier.Node pop(MutableVector<Modifier.Node> $this$pop) {
        if ($this$pop == null || $this$pop.isEmpty()) {
            return null;
        }
        return $this$pop.removeAt($this$pop.getSize() - 1);
    }
}

package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.SemanticsModifierNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsOwner;", "", "rootNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "rootSemanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRootSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "unmergedRootSemanticsNode", "getUnmergedRootSemanticsNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SemanticsOwner.kt */
public final class SemanticsOwner {
    public static final int $stable = 8;
    private final LayoutNode rootNode;

    public SemanticsOwner(LayoutNode rootNode2) {
        Intrinsics.checkNotNullParameter(rootNode2, "rootNode");
        this.rootNode = rootNode2;
    }

    public final SemanticsNode getRootSemanticsNode() {
        return SemanticsNodeKt.SemanticsNode(this.rootNode, true);
    }

    public final SemanticsNode getUnmergedRootSemanticsNode() {
        Modifier.Node node;
        int i;
        int type$iv;
        NodeChain this_$iv;
        int i2;
        int type$iv2;
        NodeChain this_$iv2;
        int i3;
        int type$iv3;
        int i4;
        int type$iv4;
        int count$iv$iv$iv;
        MutableVector mutableVector;
        NodeChain this_$iv3 = this.rootNode.getNodes$ui_release();
        int type$iv5 = NodeKind.m4956constructorimpl(8);
        int i5 = false;
        int mask$iv$iv$iv = type$iv5;
        NodeChain this_$iv$iv$iv = this_$iv3;
        if ((this_$iv$iv$iv.getAggregateChildKindSet() & mask$iv$iv$iv) != 0) {
            Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv.getHead$ui_release();
            loop0:
            while (true) {
                if (node$iv$iv$iv$iv == null) {
                    int i6 = type$iv;
                    int i7 = i;
                    break;
                }
                Modifier.Node it$iv$iv$iv = node$iv$iv$iv$iv;
                if ((it$iv$iv$iv.getKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                    MutableVector mutableVector2 = null;
                    Modifier.Node node2 = it$iv$iv$iv;
                    while (node2 != null) {
                        NodeChain this_$iv4 = this_$iv;
                        if (node2 instanceof SemanticsModifierNode) {
                            node = node2;
                            break loop0;
                        }
                        Modifier.Node this_$iv$iv$iv$iv = node2;
                        Modifier.Node node3 = this_$iv$iv$iv$iv;
                        if (((this_$iv$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? 1 : 0) == 0 || !(node2 instanceof DelegatingNode)) {
                            type$iv3 = type$iv;
                            i3 = i;
                        } else {
                            int count$iv$iv$iv2 = 0;
                            Modifier.Node node$iv$iv$iv$iv2 = ((DelegatingNode) node2).getDelegate$ui_release();
                            while (node$iv$iv$iv$iv2 != null) {
                                Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv2;
                                if ((next$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0) {
                                    count$iv$iv$iv2++;
                                    type$iv4 = type$iv;
                                    if (count$iv$iv$iv2 == 1) {
                                        node2 = next$iv$iv$iv;
                                        i4 = i;
                                        Modifier.Node node4 = next$iv$iv$iv;
                                    } else {
                                        if (mutableVector2 == null) {
                                            count$iv$iv$iv = count$iv$iv$iv2;
                                            i4 = i;
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        } else {
                                            count$iv$iv$iv = count$iv$iv$iv2;
                                            i4 = i;
                                            mutableVector = mutableVector2;
                                        }
                                        MutableVector mutableVector3 = mutableVector;
                                        Modifier.Node theNode$iv$iv$iv = node2;
                                        if (theNode$iv$iv$iv != null) {
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(theNode$iv$iv$iv);
                                            }
                                            node2 = null;
                                        }
                                        if (mutableVector3 != null) {
                                            mutableVector3.add(next$iv$iv$iv);
                                        }
                                        mutableVector2 = mutableVector3;
                                        count$iv$iv$iv2 = count$iv$iv$iv;
                                    }
                                } else {
                                    type$iv4 = type$iv;
                                    i4 = i;
                                    Modifier.Node node5 = next$iv$iv$iv;
                                }
                                node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                                type$iv = type$iv4;
                                i = i4;
                            }
                            type$iv3 = type$iv;
                            i3 = i;
                            if (count$iv$iv$iv2 == 1) {
                                this_$iv = this_$iv4;
                                type$iv = type$iv3;
                                i = i3;
                            }
                        }
                        node2 = DelegatableNodeKt.pop(mutableVector2);
                        this_$iv = this_$iv4;
                        type$iv = type$iv3;
                        i = i3;
                    }
                    this_$iv2 = this_$iv;
                    type$iv2 = type$iv;
                    i2 = i;
                } else {
                    this_$iv2 = this_$iv;
                    type$iv2 = type$iv;
                    i2 = i;
                }
                if ((it$iv$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv$iv) == 0) {
                    break;
                }
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                this_$iv3 = this_$iv2;
                type$iv5 = type$iv2;
                i5 = i2;
            }
            Intrinsics.checkNotNull(node);
            return new SemanticsNode(((SemanticsModifierNode) node).getNode(), false, this.rootNode, new SemanticsConfiguration());
        }
        int i8 = type$iv5;
        node = null;
        Intrinsics.checkNotNull(node);
        return new SemanticsNode(((SemanticsModifierNode) node).getNode(), false, this.rootNode, new SemanticsConfiguration());
    }
}

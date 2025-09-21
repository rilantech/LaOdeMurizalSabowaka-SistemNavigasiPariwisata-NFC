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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000b\u001a\u00020\u0002H\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0007H\u0002\u001a\"\u0010\u0011\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0013H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0010*\u00020\u0007H\u0002\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00078BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"outerMergingSemantics", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/LayoutNode;", "getOuterMergingSemantics", "(Landroidx/compose/ui/node/LayoutNode;)Landroidx/compose/ui/node/SemanticsModifierNode;", "role", "Landroidx/compose/ui/semantics/Role;", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRole", "(Landroidx/compose/ui/semantics/SemanticsNode;)Landroidx/compose/ui/semantics/Role;", "SemanticsNode", "layoutNode", "mergingEnabled", "", "outerSemanticsNode", "contentDescriptionFakeNodeId", "", "findClosestParentNode", "selector", "Lkotlin/Function1;", "roleFakeNodeId", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SemanticsNode.kt */
public final class SemanticsNodeKt {
    public static final SemanticsNode SemanticsNode(LayoutNode layoutNode, boolean mergingEnabled) {
        Modifier.Node node;
        NodeChain this_$iv$iv;
        int count$iv$iv$iv;
        int type$iv;
        NodeChain this_$iv$iv2;
        int type$iv2;
        int i;
        Object node$iv$iv$iv;
        NodeChain this_$iv$iv3;
        int type$iv3;
        NodeChain this_$iv$iv4;
        int type$iv4;
        int count$iv$iv$iv2;
        MutableVector mutableVector;
        LayoutNode layoutNode2 = layoutNode;
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        Object this_$iv = layoutNode.getNodes$ui_release();
        int type$iv5 = NodeKind.m6666constructorimpl(8);
        int count$iv$iv$iv3 = false;
        Object this_$iv$iv5 = this_$iv;
        int mask$iv$iv$iv = type$iv5;
        NodeChain this_$iv$iv$iv = this_$iv$iv5;
        if ((this_$iv$iv$iv.getAggregateChildKindSet() & mask$iv$iv$iv) != 0) {
            Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv.getHead$ui_release();
            loop0:
            while (true) {
                if (node$iv$iv$iv$iv == null) {
                    int i2 = type$iv;
                    int i3 = count$iv$iv$iv;
                    NodeChain nodeChain = this_$iv$iv;
                    break;
                }
                Modifier.Node it$iv$iv$iv = node$iv$iv$iv$iv;
                if ((it$iv$iv$iv.getKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                    MutableVector mutableVector2 = null;
                    node$iv$iv$iv = this_$iv;
                    Modifier.Node node2 = it$iv$iv$iv;
                    while (node2 != null) {
                        int i4 = count$iv$iv$iv;
                        if ((node2 instanceof SemanticsModifierNode) != 0) {
                            node = node2;
                            break loop0;
                        }
                        Modifier.Node this_$iv$iv$iv$iv = node2;
                        Modifier.Node node3 = this_$iv$iv$iv$iv;
                        if (((this_$iv$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? 1 : 0) == 0 || !(node2 instanceof DelegatingNode)) {
                            type$iv3 = type$iv;
                            this_$iv$iv3 = this_$iv$iv;
                        } else {
                            int count$iv$iv$iv4 = 0;
                            Modifier.Node node$iv$iv$iv$iv2 = ((DelegatingNode) node2).getDelegate$ui_release();
                            while (node$iv$iv$iv$iv2 != null) {
                                Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv2;
                                if ((next$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0) {
                                    count$iv$iv$iv4++;
                                    type$iv4 = type$iv;
                                    if (count$iv$iv$iv4 == 1) {
                                        node2 = next$iv$iv$iv;
                                        this_$iv$iv4 = this_$iv$iv;
                                        Modifier.Node node4 = next$iv$iv$iv;
                                    } else {
                                        if (mutableVector2 == null) {
                                            count$iv$iv$iv2 = count$iv$iv$iv4;
                                            this_$iv$iv4 = this_$iv$iv;
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        } else {
                                            count$iv$iv$iv2 = count$iv$iv$iv4;
                                            this_$iv$iv4 = this_$iv$iv;
                                            mutableVector = mutableVector2;
                                        }
                                        Modifier.Node theNode$iv$iv$iv = node2;
                                        if (theNode$iv$iv$iv != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(theNode$iv$iv$iv);
                                            }
                                            node2 = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(next$iv$iv$iv);
                                        }
                                        mutableVector2 = mutableVector;
                                        count$iv$iv$iv4 = count$iv$iv$iv2;
                                    }
                                } else {
                                    type$iv4 = type$iv;
                                    this_$iv$iv4 = this_$iv$iv;
                                    Modifier.Node node5 = next$iv$iv$iv;
                                }
                                node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                                type$iv = type$iv4;
                                this_$iv$iv = this_$iv$iv4;
                            }
                            type$iv3 = type$iv;
                            this_$iv$iv3 = this_$iv$iv;
                            if (count$iv$iv$iv4 == 1) {
                                count$iv$iv$iv = i4;
                                type$iv = type$iv3;
                                this_$iv$iv = this_$iv$iv3;
                            }
                        }
                        node2 = DelegatableNodeKt.pop(mutableVector2);
                        count$iv$iv$iv = i4;
                        type$iv = type$iv3;
                        this_$iv$iv = this_$iv$iv3;
                    }
                    type$iv2 = type$iv;
                    i = count$iv$iv$iv;
                    this_$iv$iv2 = this_$iv$iv;
                } else {
                    node$iv$iv$iv = this_$iv;
                    type$iv2 = type$iv;
                    i = count$iv$iv$iv;
                    this_$iv$iv2 = this_$iv$iv;
                }
                if ((it$iv$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv$iv) == 0) {
                    break;
                }
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                this_$iv = node$iv$iv$iv;
                count$iv$iv$iv3 = i;
                type$iv5 = type$iv2;
                this_$iv$iv5 = this_$iv$iv2;
            }
            Intrinsics.checkNotNull(node);
            Modifier.Node node6 = ((SemanticsModifierNode) node).getNode();
            SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
            Intrinsics.checkNotNull(collapsedSemantics$ui_release);
            return new SemanticsNode(node6, mergingEnabled, layoutNode2, collapsedSemantics$ui_release);
        }
        int i5 = type$iv5;
        NodeChain nodeChain2 = this_$iv$iv5;
        node = null;
        Intrinsics.checkNotNull(node);
        Modifier.Node node62 = ((SemanticsModifierNode) node).getNode();
        SemanticsConfiguration collapsedSemantics$ui_release2 = layoutNode.getCollapsedSemantics$ui_release();
        Intrinsics.checkNotNull(collapsedSemantics$ui_release2);
        return new SemanticsNode(node62, mergingEnabled, layoutNode2, collapsedSemantics$ui_release2);
    }

    public static /* synthetic */ SemanticsNode SemanticsNode$default(SemanticsModifierNode semanticsModifierNode, boolean z, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 4) != 0) {
            layoutNode = DelegatableNodeKt.requireLayoutNode(semanticsModifierNode);
        }
        return SemanticsNode(semanticsModifierNode, z, layoutNode);
    }

    public static final SemanticsNode SemanticsNode(SemanticsModifierNode outerSemanticsNode, boolean mergingEnabled, LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(outerSemanticsNode, "outerSemanticsNode");
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Modifier.Node node = outerSemanticsNode.getNode();
        SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
        if (collapsedSemantics$ui_release == null) {
            collapsedSemantics$ui_release = new SemanticsConfiguration();
        }
        return new SemanticsNode(node, mergingEnabled, layoutNode, collapsedSemantics$ui_release);
    }

    public static final SemanticsModifierNode getOuterMergingSemantics(LayoutNode $this$outerMergingSemantics) {
        Modifier.Node node;
        NodeChain this_$iv$iv;
        int i;
        int type$iv;
        NodeChain this_$iv$iv2;
        int i2;
        int type$iv2;
        Object node$iv$iv$iv;
        NodeChain this_$iv$iv3;
        int i3;
        int type$iv3;
        NodeChain this_$iv$iv4;
        int i4;
        int type$iv4;
        int count$iv$iv$iv;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter($this$outerMergingSemantics, "<this>");
        Object this_$iv = $this$outerMergingSemantics.getNodes$ui_release();
        int type$iv5 = NodeKind.m6666constructorimpl(8);
        int i5 = false;
        Object this_$iv$iv5 = this_$iv;
        int mask$iv$iv$iv = type$iv5;
        NodeChain this_$iv$iv$iv = this_$iv$iv5;
        if ((this_$iv$iv$iv.getAggregateChildKindSet() & mask$iv$iv$iv) != 0) {
            Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv.getHead$ui_release();
            loop0:
            while (true) {
                if (node$iv$iv$iv$iv == null) {
                    int i6 = type$iv;
                    int i7 = i;
                    NodeChain nodeChain = this_$iv$iv;
                    break;
                }
                Modifier.Node it$iv$iv$iv = node$iv$iv$iv$iv;
                if ((it$iv$iv$iv.getKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                    MutableVector mutableVector2 = null;
                    node$iv$iv$iv = this_$iv;
                    Modifier.Node node2 = it$iv$iv$iv;
                    while (true) {
                        if (node2 == null) {
                            type$iv2 = type$iv;
                            i2 = i;
                            this_$iv$iv2 = this_$iv$iv;
                            break;
                        }
                        if (node2 instanceof SemanticsModifierNode) {
                            node = node2;
                            if (((SemanticsModifierNode) node).getShouldMergeDescendantSemantics()) {
                                break loop0;
                            }
                            type$iv3 = type$iv;
                            i3 = i;
                            this_$iv$iv3 = this_$iv$iv;
                        } else {
                            Modifier.Node this_$iv$iv$iv$iv = node2;
                            Modifier.Node node3 = this_$iv$iv$iv$iv;
                            if (((this_$iv$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? 1 : 0) == 0 || !(node2 instanceof DelegatingNode)) {
                                type$iv3 = type$iv;
                                i3 = i;
                                this_$iv$iv3 = this_$iv$iv;
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
                                            this_$iv$iv4 = this_$iv$iv;
                                            Modifier.Node node4 = next$iv$iv$iv;
                                        } else {
                                            if (mutableVector2 == null) {
                                                count$iv$iv$iv = count$iv$iv$iv2;
                                                i4 = i;
                                                this_$iv$iv4 = this_$iv$iv;
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                count$iv$iv$iv = count$iv$iv$iv2;
                                                i4 = i;
                                                this_$iv$iv4 = this_$iv$iv;
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
                                        this_$iv$iv4 = this_$iv$iv;
                                        Modifier.Node node5 = next$iv$iv$iv;
                                    }
                                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                                    type$iv = type$iv4;
                                    i = i4;
                                    this_$iv$iv = this_$iv$iv4;
                                }
                                type$iv3 = type$iv;
                                i3 = i;
                                this_$iv$iv3 = this_$iv$iv;
                                if (count$iv$iv$iv2 == 1) {
                                    LayoutNode layoutNode = $this$outerMergingSemantics;
                                    type$iv = type$iv3;
                                    i = i3;
                                    this_$iv$iv = this_$iv$iv3;
                                }
                            }
                        }
                        node2 = DelegatableNodeKt.pop(mutableVector2);
                        LayoutNode layoutNode2 = $this$outerMergingSemantics;
                        type$iv = type$iv3;
                        i = i3;
                        this_$iv$iv = this_$iv$iv3;
                    }
                } else {
                    node$iv$iv$iv = this_$iv;
                    type$iv2 = type$iv;
                    i2 = i;
                    this_$iv$iv2 = this_$iv$iv;
                }
                if ((it$iv$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv$iv) == 0) {
                    break;
                }
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                LayoutNode layoutNode3 = $this$outerMergingSemantics;
                this_$iv = node$iv$iv$iv;
                type$iv5 = type$iv2;
                i5 = i2;
                this_$iv$iv5 = this_$iv$iv2;
            }
            return (SemanticsModifierNode) node;
        }
        int i8 = type$iv5;
        NodeChain nodeChain2 = this_$iv$iv5;
        node = null;
        return (SemanticsModifierNode) node;
    }

    public static final LayoutNode findClosestParentNode(LayoutNode $this$findClosestParentNode, Function1<? super LayoutNode, Boolean> selector) {
        Intrinsics.checkNotNullParameter($this$findClosestParentNode, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        for (LayoutNode currentParent = $this$findClosestParentNode.getParent$ui_release(); currentParent != null; currentParent = currentParent.getParent$ui_release()) {
            if (selector.invoke(currentParent).booleanValue()) {
                return currentParent;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final Role getRole(SemanticsNode $this$role) {
        return (Role) SemanticsConfigurationKt.getOrNull($this$role.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
    }

    /* access modifiers changed from: private */
    public static final int contentDescriptionFakeNodeId(SemanticsNode $this$contentDescriptionFakeNodeId) {
        return $this$contentDescriptionFakeNodeId.getId() + 2000000000;
    }

    /* access modifiers changed from: private */
    public static final int roleFakeNodeId(SemanticsNode $this$roleFakeNodeId) {
        return $this$roleFakeNodeId.getId() + 1000000000;
    }
}

package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"getFocusState", "Landroidx/compose/ui/focus/FocusState;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "invalidateFocusEvent", "", "refreshFocusEventNodes", "Landroidx/compose/ui/focus/FocusTargetNode;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusEventModifierNode.kt */
public final class FocusEventModifierNodeKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusEventModifierNode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void invalidateFocusEvent(FocusEventModifierNode $this$invalidateFocusEvent) {
        Intrinsics.checkNotNullParameter($this$invalidateFocusEvent, "<this>");
        DelegatableNodeKt.requireOwner($this$invalidateFocusEvent).getFocusOwner().scheduleInvalidation($this$invalidateFocusEvent);
    }

    public static final FocusState getFocusState(FocusEventModifierNode $this$getFocusState) {
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int mask$iv$iv;
        int type$iv;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int mask$iv$iv2;
        int mask$iv$iv3;
        int type$iv2;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
        int mask$iv$iv4;
        MutableVector mutableVector;
        int i;
        int i2;
        MutableVector mutableVector2;
        FocusEventModifierNode focusEventModifierNode = $this$getFocusState;
        Intrinsics.checkNotNullParameter(focusEventModifierNode, "<this>");
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = focusEventModifierNode;
        int type$iv3 = NodeKind.m6666constructorimpl(1024);
        int i3 = 0;
        MutableVector mutableVector3 = null;
        Modifier.Node this_$iv$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv4.getNode();
        while (true) {
            int count$iv$iv = false;
            int i4 = 1;
            if (this_$iv$iv$iv != null) {
                if (this_$iv$iv$iv instanceof FocusTargetNode) {
                    FocusStateImpl focusState = ((FocusTargetNode) this_$iv$iv$iv).getFocusState();
                    switch (WhenMappings.$EnumSwitchMapping$0[focusState.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                            return focusState;
                        default:
                            i = i3;
                            break;
                    }
                } else {
                    if (((this_$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? 1 : null) == null || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                        i = i3;
                    } else {
                        int count$iv$iv2 = 0;
                        Modifier.Node node$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            Modifier.Node next$iv$iv = node$iv$iv$iv;
                            if (((next$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? i4 : 0) != 0) {
                                count$iv$iv2++;
                                if (count$iv$iv2 == i4) {
                                    this_$iv$iv$iv = next$iv$iv;
                                    i2 = i3;
                                } else {
                                    if (mutableVector3 == null) {
                                        i2 = i3;
                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                    } else {
                                        i2 = i3;
                                        mutableVector2 = mutableVector3;
                                    }
                                    mutableVector3 = mutableVector2;
                                    Modifier.Node theNode$iv$iv = this_$iv$iv$iv;
                                    if (theNode$iv$iv != null) {
                                        if (mutableVector3 != null) {
                                            mutableVector3.add(theNode$iv$iv);
                                        }
                                        this_$iv$iv$iv = null;
                                    }
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(next$iv$iv);
                                    }
                                }
                            } else {
                                i2 = i3;
                            }
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            i4 = 1;
                            FocusEventModifierNode focusEventModifierNode2 = $this$getFocusState;
                            i3 = i2;
                        }
                        i = i3;
                        if (count$iv$iv2 == 1) {
                            FocusEventModifierNode focusEventModifierNode3 = $this$getFocusState;
                            i3 = i;
                        }
                    }
                }
                this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector3);
                FocusEventModifierNode focusEventModifierNode4 = $this$getFocusState;
                i3 = i;
            } else {
                int i5 = i3;
                int mask$iv$iv5 = type$iv3;
                DelegatableNode $this$visitChildren$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                if ($this$visitChildren$iv$iv.getNode().isAttached()) {
                    MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                    Modifier.Node child$iv$iv = $this$visitChildren$iv$iv.getNode().getChild$ui_release();
                    if (child$iv$iv == null) {
                        DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren$iv$iv.getNode());
                    } else {
                        branches$iv$iv.add(child$iv$iv);
                    }
                    while (branches$iv$iv.isNotEmpty()) {
                        Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                        if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv5) == 0) {
                            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                        } else {
                            Modifier.Node node$iv$iv = branch$iv$iv;
                            while (true) {
                                if (node$iv$iv == null) {
                                    int mask$iv$iv6 = mask$iv$iv;
                                    int i6 = type$iv3;
                                    int mask$iv$iv7 = count$iv$iv;
                                    mask$iv$iv5 = mask$iv$iv6;
                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                                    MutableVector mutableVector4 = null;
                                    Modifier.Node this_$iv$iv$iv2 = node$iv$iv;
                                    while (this_$iv$iv$iv2 != null) {
                                        if (this_$iv$iv$iv2 instanceof FocusTargetNode) {
                                            FocusStateImpl focusState2 = ((FocusTargetNode) this_$iv$iv$iv2).getFocusState();
                                            switch (WhenMappings.$EnumSwitchMapping$0[focusState2.ordinal()]) {
                                                case 1:
                                                case 2:
                                                case 3:
                                                    return focusState2;
                                                default:
                                                    mask$iv$iv2 = mask$iv$iv;
                                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                                    type$iv = type$iv3;
                                                    mask$iv$iv3 = 0;
                                                    break;
                                            }
                                        } else {
                                            if (!((this_$iv$iv$iv2.getKindSet$ui_release() & type$iv3) != 0) || !(this_$iv$iv$iv2 instanceof DelegatingNode)) {
                                                mask$iv$iv2 = mask$iv$iv;
                                                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                                type$iv = type$iv3;
                                                mask$iv$iv3 = 0;
                                            } else {
                                                int count$iv$iv3 = 0;
                                                Modifier.Node node$iv$iv$iv2 = ((DelegatingNode) this_$iv$iv$iv2).getDelegate$ui_release();
                                                while (node$iv$iv$iv2 != null) {
                                                    Modifier.Node next$iv$iv2 = node$iv$iv$iv2;
                                                    if ((next$iv$iv2.getKindSet$ui_release() & type$iv3) != 0) {
                                                        count$iv$iv3++;
                                                        mask$iv$iv4 = mask$iv$iv;
                                                        if (count$iv$iv3 == 1) {
                                                            this_$iv$iv$iv2 = next$iv$iv2;
                                                            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                                            type$iv2 = type$iv3;
                                                            Modifier.Node node = next$iv$iv2;
                                                        } else {
                                                            if (mutableVector4 == null) {
                                                                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                                                type$iv2 = type$iv3;
                                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                            } else {
                                                                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                                                type$iv2 = type$iv3;
                                                                mutableVector = mutableVector4;
                                                            }
                                                            mutableVector4 = mutableVector;
                                                            Modifier.Node theNode$iv$iv2 = this_$iv$iv$iv2;
                                                            if (theNode$iv$iv2 != null) {
                                                                if (mutableVector4 != null) {
                                                                    mutableVector4.add(theNode$iv$iv2);
                                                                }
                                                                this_$iv$iv$iv2 = null;
                                                            }
                                                            if (mutableVector4 != null) {
                                                                mutableVector4.add(next$iv$iv2);
                                                            }
                                                        }
                                                    } else {
                                                        mask$iv$iv4 = mask$iv$iv;
                                                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                                        type$iv2 = type$iv3;
                                                        Modifier.Node node2 = next$iv$iv2;
                                                    }
                                                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                                    mask$iv$iv = mask$iv$iv4;
                                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                                    type$iv3 = type$iv2;
                                                }
                                                mask$iv$iv2 = mask$iv$iv;
                                                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                                type$iv = type$iv3;
                                                mask$iv$iv3 = 0;
                                                if (count$iv$iv3 == 1) {
                                                    count$iv$iv = false;
                                                    mask$iv$iv = mask$iv$iv2;
                                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                                                    type$iv3 = type$iv;
                                                }
                                            }
                                        }
                                        this_$iv$iv$iv2 = DelegatableNodeKt.pop(mutableVector4);
                                        count$iv$iv = mask$iv$iv3;
                                        mask$iv$iv = mask$iv$iv2;
                                        $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                                        type$iv3 = type$iv;
                                    }
                                    int mask$iv$iv8 = mask$iv$iv;
                                    int i7 = type$iv3;
                                    int mask$iv$iv9 = count$iv$iv;
                                    mask$iv$iv5 = mask$iv$iv8;
                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                } else {
                                    int mask$iv$iv10 = mask$iv$iv;
                                    int i8 = type$iv3;
                                    int mask$iv$iv11 = count$iv$iv;
                                    node$iv$iv = node$iv$iv.getChild$ui_release();
                                    mask$iv$iv5 = mask$iv$iv10;
                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                }
                            }
                        }
                    }
                    return FocusStateImpl.Inactive;
                }
                int i9 = mask$iv$iv5;
                DelegatableNode delegatableNode = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                throw new IllegalStateException("visitChildren called on an unattached node".toString());
            }
        }
    }

    public static final void refreshFocusEventNodes(FocusTargetNode $this$refreshFocusEventNodes) {
        int untilType$iv;
        int type$iv;
        DelegatableNode $this$visitSelfAndAncestors_u2d5BbP62I$iv;
        NodeChain nodes$ui_release;
        int untilType$iv2;
        int type$iv2;
        DelegatableNode $this$visitSelfAndAncestors_u2d5BbP62I$iv2;
        int untilType$iv3;
        int type$iv3;
        DelegatableNode $this$visitSelfAndAncestors_u2d5BbP62I$iv3;
        int untilType$iv4;
        int type$iv4;
        DelegatingNode this_$iv$iv$iv;
        int count$iv$iv;
        MutableVector mutableVector;
        FocusTargetNode focusTargetNode = $this$refreshFocusEventNodes;
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        DelegatableNode $this$visitSelfAndAncestors_u2d5BbP62I$iv4 = focusTargetNode;
        int type$iv5 = NodeKind.m6666constructorimpl(4096);
        int untilType$iv5 = NodeKind.m6666constructorimpl(1024);
        Modifier.Node self$iv = $this$visitSelfAndAncestors_u2d5BbP62I$iv4.getNode();
        int mask$iv$iv = type$iv5 | untilType$iv5;
        DelegatableNode $this$visitAncestors$iv$iv = $this$visitSelfAndAncestors_u2d5BbP62I$iv4;
        if ($this$visitAncestors$iv$iv.getNode().isAttached()) {
            Modifier.Node node$iv$iv = $this$visitAncestors$iv$iv.getNode();
            LayoutNode layout$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv);
            while (layout$iv$iv != null) {
                if ((layout$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                    while (node$iv$iv != null) {
                        if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            Modifier.Node it$iv = node$iv$iv;
                            if (it$iv != self$iv) {
                                if ((it$iv.getKindSet$ui_release() & untilType$iv2) != 0) {
                                    return;
                                }
                            }
                            if ((it$iv.getKindSet$ui_release() & type$iv2) != 0) {
                                MutableVector mutableVector2 = null;
                                Modifier.Node this_$iv$iv$iv2 = it$iv;
                                while (this_$iv$iv$iv2 != null) {
                                    if (this_$iv$iv$iv2 instanceof FocusEventModifierNode) {
                                        FocusEventModifierNode it = (FocusEventModifierNode) this_$iv$iv$iv2;
                                        $this$visitSelfAndAncestors_u2d5BbP62I$iv3 = $this$visitSelfAndAncestors_u2d5BbP62I$iv2;
                                        it.onFocusEvent(getFocusState(it));
                                        type$iv3 = type$iv2;
                                        untilType$iv3 = untilType$iv2;
                                    } else {
                                        $this$visitSelfAndAncestors_u2d5BbP62I$iv3 = $this$visitSelfAndAncestors_u2d5BbP62I$iv2;
                                        if (!((this_$iv$iv$iv2.getKindSet$ui_release() & type$iv2) != 0) || !(this_$iv$iv$iv2 instanceof DelegatingNode)) {
                                            type$iv3 = type$iv2;
                                            untilType$iv3 = untilType$iv2;
                                        } else {
                                            int count$iv$iv2 = 0;
                                            DelegatingNode this_$iv$iv$iv3 = (DelegatingNode) this_$iv$iv$iv2;
                                            Modifier.Node node$iv$iv$iv = this_$iv$iv$iv3.getDelegate$ui_release();
                                            while (node$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                if ((next$iv$iv.getKindSet$ui_release() & type$iv2) != 0) {
                                                    count$iv$iv2++;
                                                    this_$iv$iv$iv = this_$iv$iv$iv3;
                                                    if (count$iv$iv2 == 1) {
                                                        this_$iv$iv$iv2 = next$iv$iv;
                                                        type$iv4 = type$iv2;
                                                        untilType$iv4 = untilType$iv2;
                                                        Modifier.Node node = next$iv$iv;
                                                    } else {
                                                        if (mutableVector2 == null) {
                                                            count$iv$iv = count$iv$iv2;
                                                            type$iv4 = type$iv2;
                                                            untilType$iv4 = untilType$iv2;
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            count$iv$iv = count$iv$iv2;
                                                            type$iv4 = type$iv2;
                                                            untilType$iv4 = untilType$iv2;
                                                            mutableVector = mutableVector2;
                                                        }
                                                        MutableVector mutableVector3 = mutableVector;
                                                        Modifier.Node theNode$iv$iv = this_$iv$iv$iv2;
                                                        if (theNode$iv$iv != null) {
                                                            if (mutableVector3 != null) {
                                                                mutableVector3.add(theNode$iv$iv);
                                                            }
                                                            this_$iv$iv$iv2 = null;
                                                        }
                                                        if (mutableVector3 != null) {
                                                            mutableVector3.add(next$iv$iv);
                                                        }
                                                        mutableVector2 = mutableVector3;
                                                        count$iv$iv2 = count$iv$iv;
                                                    }
                                                } else {
                                                    this_$iv$iv$iv = this_$iv$iv$iv3;
                                                    type$iv4 = type$iv2;
                                                    untilType$iv4 = untilType$iv2;
                                                    Modifier.Node node2 = next$iv$iv;
                                                }
                                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                                this_$iv$iv$iv3 = this_$iv$iv$iv;
                                                type$iv2 = type$iv4;
                                                untilType$iv2 = untilType$iv4;
                                            }
                                            type$iv3 = type$iv2;
                                            untilType$iv3 = untilType$iv2;
                                            if (count$iv$iv2 == 1) {
                                                FocusTargetNode focusTargetNode2 = $this$refreshFocusEventNodes;
                                                $this$visitSelfAndAncestors_u2d5BbP62I$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv3;
                                                type$iv2 = type$iv3;
                                                untilType$iv2 = untilType$iv3;
                                            }
                                        }
                                    }
                                    this_$iv$iv$iv2 = DelegatableNodeKt.pop(mutableVector2);
                                    FocusTargetNode focusTargetNode3 = $this$refreshFocusEventNodes;
                                    $this$visitSelfAndAncestors_u2d5BbP62I$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv3;
                                    type$iv2 = type$iv3;
                                    untilType$iv2 = untilType$iv3;
                                }
                            }
                        }
                        node$iv$iv = node$iv$iv.getParent$ui_release();
                        FocusTargetNode focusTargetNode4 = $this$refreshFocusEventNodes;
                        $this$visitSelfAndAncestors_u2d5BbP62I$iv4 = $this$visitSelfAndAncestors_u2d5BbP62I$iv2;
                        type$iv5 = type$iv2;
                        untilType$iv5 = untilType$iv2;
                    }
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = $this$visitSelfAndAncestors_u2d5BbP62I$iv2;
                    type$iv = type$iv2;
                    untilType$iv = untilType$iv2;
                } else {
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = $this$visitSelfAndAncestors_u2d5BbP62I$iv4;
                    type$iv = type$iv5;
                    untilType$iv = untilType$iv5;
                }
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                node$iv$iv = (layout$iv$iv == null || (nodes$ui_release = layout$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                FocusTargetNode focusTargetNode5 = $this$refreshFocusEventNodes;
                $this$visitSelfAndAncestors_u2d5BbP62I$iv4 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                type$iv5 = type$iv;
                untilType$iv5 = untilType$iv;
            }
            int i = type$iv5;
            int i2 = untilType$iv5;
            return;
        }
        DelegatableNode delegatableNode = $this$visitSelfAndAncestors_u2d5BbP62I$iv4;
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }
}

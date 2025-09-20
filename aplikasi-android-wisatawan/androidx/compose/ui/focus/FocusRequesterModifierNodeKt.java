package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0005"}, d2 = {"captureFocus", "", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "freeFocus", "requestFocus", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusRequesterModifierNode.kt */
public final class FocusRequesterModifierNodeKt {
    public static final boolean requestFocus(FocusRequesterModifierNode $this$requestFocus) {
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int type$iv;
        int type$iv2;
        DelegatingNode this_$iv$iv$iv;
        int count$iv$iv;
        MutableVector mutableVector;
        int i;
        int i2;
        MutableVector mutableVector2;
        FocusRequesterModifierNode focusRequesterModifierNode = $this$requestFocus;
        Intrinsics.checkNotNullParameter(focusRequesterModifierNode, "<this>");
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = focusRequesterModifierNode;
        int type$iv3 = NodeKind.m4956constructorimpl(1024);
        int i3 = 0;
        MutableVector mutableVector3 = null;
        Modifier.Node this_$iv$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2.getNode();
        while (true) {
            int i4 = 1;
            if (this_$iv$iv$iv2 == null) {
                int i5 = i3;
                int count$iv$iv2 = type$iv3;
                DelegatableNode $this$visitChildren$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
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
                        if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & count$iv$iv2) != 0) {
                            Modifier.Node node$iv$iv = branch$iv$iv;
                            while (true) {
                                if (node$iv$iv == null) {
                                    int mask$iv$iv = count$iv$iv2;
                                    int i6 = type$iv3;
                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                    break;
                                } else if ((node$iv$iv.getKindSet$ui_release() & count$iv$iv2) != 0) {
                                    MutableVector mutableVector4 = null;
                                    Modifier.Node this_$iv$iv$iv3 = node$iv$iv;
                                    while (this_$iv$iv$iv3 != null) {
                                        if (this_$iv$iv$iv3 instanceof FocusTargetNode) {
                                            FocusTargetNode focusTarget = (FocusTargetNode) this_$iv$iv$iv3;
                                            if (focusTarget.fetchFocusProperties$ui_release().getCanFocus()) {
                                                int i7 = count$iv$iv2;
                                                DelegatableNode delegatableNode = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                                return FocusTransactionsKt.requestFocus(focusTarget);
                                            }
                                            int i8 = count$iv$iv2;
                                            DelegatableNode delegatableNode2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                            return TwoDimensionalFocusSearchKt.m2964findChildCorrespondingToFocusEnterOMvw8(focusTarget, FocusDirection.Companion.m2928getEnterdhqQ8s(), FocusRequesterModifierNodeKt$requestFocus$1$1.INSTANCE);
                                        }
                                        int mask$iv$iv2 = count$iv$iv2;
                                        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                        if (!((this_$iv$iv$iv3.getKindSet$ui_release() & type$iv3) != 0) || !(this_$iv$iv$iv3 instanceof DelegatingNode)) {
                                            type$iv = type$iv3;
                                        } else {
                                            int count$iv$iv3 = 0;
                                            DelegatingNode this_$iv$iv$iv4 = (DelegatingNode) this_$iv$iv$iv3;
                                            Modifier.Node node$iv$iv$iv = this_$iv$iv$iv4.getDelegate$ui_release();
                                            while (node$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                if ((next$iv$iv.getKindSet$ui_release() & type$iv3) != 0) {
                                                    count$iv$iv3++;
                                                    this_$iv$iv$iv = this_$iv$iv$iv4;
                                                    if (count$iv$iv3 == 1) {
                                                        this_$iv$iv$iv3 = next$iv$iv;
                                                        type$iv2 = type$iv3;
                                                        Modifier.Node node = next$iv$iv;
                                                    } else {
                                                        if (mutableVector4 == null) {
                                                            count$iv$iv = count$iv$iv3;
                                                            type$iv2 = type$iv3;
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            count$iv$iv = count$iv$iv3;
                                                            type$iv2 = type$iv3;
                                                            mutableVector = mutableVector4;
                                                        }
                                                        mutableVector4 = mutableVector;
                                                        Modifier.Node theNode$iv$iv = this_$iv$iv$iv3;
                                                        if (theNode$iv$iv != null) {
                                                            if (mutableVector4 != null) {
                                                                mutableVector4.add(theNode$iv$iv);
                                                            }
                                                            this_$iv$iv$iv3 = null;
                                                        }
                                                        if (mutableVector4 != null) {
                                                            mutableVector4.add(next$iv$iv);
                                                        }
                                                        count$iv$iv3 = count$iv$iv;
                                                    }
                                                } else {
                                                    this_$iv$iv$iv = this_$iv$iv$iv4;
                                                    type$iv2 = type$iv3;
                                                    Modifier.Node node2 = next$iv$iv;
                                                }
                                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                                this_$iv$iv$iv4 = this_$iv$iv$iv;
                                                type$iv3 = type$iv2;
                                            }
                                            type$iv = type$iv3;
                                            if (count$iv$iv3 == 1) {
                                                count$iv$iv2 = mask$iv$iv2;
                                                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                                type$iv3 = type$iv;
                                            }
                                        }
                                        this_$iv$iv$iv3 = DelegatableNodeKt.pop(mutableVector4);
                                        count$iv$iv2 = mask$iv$iv2;
                                        $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                        type$iv3 = type$iv;
                                    }
                                    int mask$iv$iv3 = count$iv$iv2;
                                    int i9 = type$iv3;
                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                } else {
                                    int mask$iv$iv4 = count$iv$iv2;
                                    int i10 = type$iv3;
                                    node$iv$iv = node$iv$iv.getChild$ui_release();
                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                }
                            }
                        } else {
                            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                        }
                    }
                    int mask$iv$iv5 = count$iv$iv2;
                    return false;
                }
                int i11 = count$iv$iv2;
                DelegatableNode delegatableNode3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                throw new IllegalStateException("visitChildren called on an unattached node".toString());
            } else if (this_$iv$iv$iv2 instanceof FocusTargetNode) {
                FocusTargetNode focusTarget2 = (FocusTargetNode) this_$iv$iv$iv2;
                if (focusTarget2.fetchFocusProperties$ui_release().getCanFocus()) {
                    return FocusTransactionsKt.requestFocus(focusTarget2);
                }
                return TwoDimensionalFocusSearchKt.m2964findChildCorrespondingToFocusEnterOMvw8(focusTarget2, FocusDirection.Companion.m2928getEnterdhqQ8s(), FocusRequesterModifierNodeKt$requestFocus$1$1.INSTANCE);
            } else {
                if (((this_$iv$iv$iv2.getKindSet$ui_release() & type$iv3) != 0 ? 1 : null) == null || !(this_$iv$iv$iv2 instanceof DelegatingNode)) {
                    i = i3;
                } else {
                    int count$iv$iv4 = 0;
                    Modifier.Node node$iv$iv$iv2 = ((DelegatingNode) this_$iv$iv$iv2).getDelegate$ui_release();
                    while (node$iv$iv$iv2 != null) {
                        Modifier.Node next$iv$iv2 = node$iv$iv$iv2;
                        if (((next$iv$iv2.getKindSet$ui_release() & type$iv3) != 0 ? i4 : 0) != 0) {
                            count$iv$iv4++;
                            if (count$iv$iv4 == i4) {
                                this_$iv$iv$iv2 = next$iv$iv2;
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
                                Modifier.Node theNode$iv$iv2 = this_$iv$iv$iv2;
                                if (theNode$iv$iv2 != null) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(theNode$iv$iv2);
                                    }
                                    this_$iv$iv$iv2 = null;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(next$iv$iv2);
                                }
                            }
                        } else {
                            i2 = i3;
                        }
                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                        i4 = 1;
                        FocusRequesterModifierNode focusRequesterModifierNode2 = $this$requestFocus;
                        i3 = i2;
                    }
                    i = i3;
                    if (count$iv$iv4 == 1) {
                        FocusRequesterModifierNode focusRequesterModifierNode3 = $this$requestFocus;
                        i3 = i;
                    }
                }
                this_$iv$iv$iv2 = DelegatableNodeKt.pop(mutableVector3);
                FocusRequesterModifierNode focusRequesterModifierNode4 = $this$requestFocus;
                i3 = i;
            }
        }
    }

    public static final boolean captureFocus(FocusRequesterModifierNode $this$captureFocus) {
        int mask$iv$iv;
        int type$iv;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int mask$iv$iv2;
        int type$iv2;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int mask$iv$iv3;
        MutableVector mutableVector;
        int i;
        int i2;
        MutableVector mutableVector2;
        FocusRequesterModifierNode focusRequesterModifierNode = $this$captureFocus;
        Intrinsics.checkNotNullParameter(focusRequesterModifierNode, "<this>");
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = focusRequesterModifierNode;
        int type$iv3 = NodeKind.m4956constructorimpl(1024);
        int i3 = 0;
        MutableVector mutableVector3 = null;
        Modifier.Node this_$iv$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3.getNode();
        while (true) {
            int i4 = 1;
            if (this_$iv$iv$iv != null) {
                if (!(this_$iv$iv$iv instanceof FocusTargetNode)) {
                    if (((this_$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? 1 : null) == null || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                        i = i3;
                    } else {
                        int count$iv$iv = 0;
                        Modifier.Node node$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            Modifier.Node next$iv$iv = node$iv$iv$iv;
                            if (((next$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? i4 : 0) != 0) {
                                count$iv$iv++;
                                if (count$iv$iv == i4) {
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
                            FocusRequesterModifierNode focusRequesterModifierNode2 = $this$captureFocus;
                            i3 = i2;
                        }
                        i = i3;
                        if (count$iv$iv == 1) {
                            FocusRequesterModifierNode focusRequesterModifierNode3 = $this$captureFocus;
                            i3 = i;
                        }
                    }
                } else if (FocusTransactionsKt.captureFocus((FocusTargetNode) this_$iv$iv$iv)) {
                    return true;
                } else {
                    i = i3;
                }
                this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector3);
                FocusRequesterModifierNode focusRequesterModifierNode4 = $this$captureFocus;
                i3 = i;
            } else {
                int i5 = i3;
                int mask$iv$iv4 = type$iv3;
                DelegatableNode $this$visitChildren$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
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
                        if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv4) != 0) {
                            Modifier.Node node$iv$iv = branch$iv$iv;
                            while (true) {
                                if (node$iv$iv == null) {
                                    DelegatableNode delegatableNode = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                    int i6 = type$iv3;
                                    mask$iv$iv4 = mask$iv$iv;
                                    break;
                                } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                                    MutableVector mutableVector4 = null;
                                    Modifier.Node this_$iv$iv$iv2 = node$iv$iv;
                                    while (this_$iv$iv$iv2 != null) {
                                        if (!(this_$iv$iv$iv2 instanceof FocusTargetNode)) {
                                            if (!((this_$iv$iv$iv2.getKindSet$ui_release() & type$iv3) != 0) || !(this_$iv$iv$iv2 instanceof DelegatingNode)) {
                                                mask$iv$iv2 = mask$iv$iv;
                                                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                                type$iv = type$iv3;
                                            } else {
                                                int count$iv$iv2 = 0;
                                                Modifier.Node node$iv$iv$iv2 = ((DelegatingNode) this_$iv$iv$iv2).getDelegate$ui_release();
                                                while (node$iv$iv$iv2 != null) {
                                                    DelegatableNode next$iv$iv2 = node$iv$iv$iv2;
                                                    if ((next$iv$iv2.getKindSet$ui_release() & type$iv3) != 0) {
                                                        count$iv$iv2++;
                                                        mask$iv$iv3 = mask$iv$iv;
                                                        if (count$iv$iv2 == 1) {
                                                            this_$iv$iv$iv2 = next$iv$iv2;
                                                            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                                            type$iv2 = type$iv3;
                                                            DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = next$iv$iv2;
                                                        } else {
                                                            if (mutableVector4 == null) {
                                                                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                                                type$iv2 = type$iv3;
                                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                            } else {
                                                                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
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
                                                        mask$iv$iv3 = mask$iv$iv;
                                                        $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                                        type$iv2 = type$iv3;
                                                        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv5 = next$iv$iv2;
                                                    }
                                                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                                    mask$iv$iv = mask$iv$iv3;
                                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                                                    type$iv3 = type$iv2;
                                                }
                                                mask$iv$iv2 = mask$iv$iv;
                                                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                                type$iv = type$iv3;
                                                if (count$iv$iv2 == 1) {
                                                    mask$iv$iv = mask$iv$iv2;
                                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                                    type$iv3 = type$iv;
                                                }
                                            }
                                        } else if (FocusTransactionsKt.captureFocus((FocusTargetNode) this_$iv$iv$iv2)) {
                                            return true;
                                        } else {
                                            mask$iv$iv2 = mask$iv$iv;
                                            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                            type$iv = type$iv3;
                                        }
                                        this_$iv$iv$iv2 = DelegatableNodeKt.pop(mutableVector4);
                                        mask$iv$iv = mask$iv$iv2;
                                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                        type$iv3 = type$iv;
                                    }
                                    DelegatableNode delegatableNode2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                    int i7 = type$iv3;
                                    mask$iv$iv4 = mask$iv$iv;
                                } else {
                                    DelegatableNode delegatableNode3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                    int i8 = type$iv3;
                                    node$iv$iv = node$iv$iv.getChild$ui_release();
                                    mask$iv$iv4 = mask$iv$iv;
                                }
                            }
                        } else {
                            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                        }
                    }
                    return false;
                }
                int i9 = mask$iv$iv4;
                DelegatableNode delegatableNode4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                throw new IllegalStateException("visitChildren called on an unattached node".toString());
            }
        }
    }

    public static final boolean freeFocus(FocusRequesterModifierNode $this$freeFocus) {
        int mask$iv$iv;
        int type$iv;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int mask$iv$iv2;
        int type$iv2;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int mask$iv$iv3;
        MutableVector mutableVector;
        int i;
        int i2;
        MutableVector mutableVector2;
        FocusRequesterModifierNode focusRequesterModifierNode = $this$freeFocus;
        Intrinsics.checkNotNullParameter(focusRequesterModifierNode, "<this>");
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = focusRequesterModifierNode;
        int type$iv3 = NodeKind.m4956constructorimpl(1024);
        int i3 = 0;
        MutableVector mutableVector3 = null;
        Modifier.Node this_$iv$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3.getNode();
        while (true) {
            int i4 = 1;
            if (this_$iv$iv$iv != null) {
                if (!(this_$iv$iv$iv instanceof FocusTargetNode)) {
                    if (((this_$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? 1 : null) == null || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                        i = i3;
                    } else {
                        int count$iv$iv = 0;
                        Modifier.Node node$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            Modifier.Node next$iv$iv = node$iv$iv$iv;
                            if (((next$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? i4 : 0) != 0) {
                                count$iv$iv++;
                                if (count$iv$iv == i4) {
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
                            FocusRequesterModifierNode focusRequesterModifierNode2 = $this$freeFocus;
                            i3 = i2;
                        }
                        i = i3;
                        if (count$iv$iv == 1) {
                            FocusRequesterModifierNode focusRequesterModifierNode3 = $this$freeFocus;
                            i3 = i;
                        }
                    }
                } else if (FocusTransactionsKt.freeFocus((FocusTargetNode) this_$iv$iv$iv)) {
                    return true;
                } else {
                    i = i3;
                }
                this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector3);
                FocusRequesterModifierNode focusRequesterModifierNode4 = $this$freeFocus;
                i3 = i;
            } else {
                int i5 = i3;
                int mask$iv$iv4 = type$iv3;
                DelegatableNode $this$visitChildren$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
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
                        if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv4) != 0) {
                            Modifier.Node node$iv$iv = branch$iv$iv;
                            while (true) {
                                if (node$iv$iv == null) {
                                    DelegatableNode delegatableNode = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                    int i6 = type$iv3;
                                    mask$iv$iv4 = mask$iv$iv;
                                    break;
                                } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                                    MutableVector mutableVector4 = null;
                                    Modifier.Node this_$iv$iv$iv2 = node$iv$iv;
                                    while (this_$iv$iv$iv2 != null) {
                                        if (!(this_$iv$iv$iv2 instanceof FocusTargetNode)) {
                                            if (!((this_$iv$iv$iv2.getKindSet$ui_release() & type$iv3) != 0) || !(this_$iv$iv$iv2 instanceof DelegatingNode)) {
                                                mask$iv$iv2 = mask$iv$iv;
                                                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                                type$iv = type$iv3;
                                            } else {
                                                int count$iv$iv2 = 0;
                                                Modifier.Node node$iv$iv$iv2 = ((DelegatingNode) this_$iv$iv$iv2).getDelegate$ui_release();
                                                while (node$iv$iv$iv2 != null) {
                                                    DelegatableNode next$iv$iv2 = node$iv$iv$iv2;
                                                    if ((next$iv$iv2.getKindSet$ui_release() & type$iv3) != 0) {
                                                        count$iv$iv2++;
                                                        mask$iv$iv3 = mask$iv$iv;
                                                        if (count$iv$iv2 == 1) {
                                                            this_$iv$iv$iv2 = next$iv$iv2;
                                                            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                                            type$iv2 = type$iv3;
                                                            DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = next$iv$iv2;
                                                        } else {
                                                            if (mutableVector4 == null) {
                                                                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                                                type$iv2 = type$iv3;
                                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                            } else {
                                                                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
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
                                                        mask$iv$iv3 = mask$iv$iv;
                                                        $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                                        type$iv2 = type$iv3;
                                                        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv5 = next$iv$iv2;
                                                    }
                                                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                                    mask$iv$iv = mask$iv$iv3;
                                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                                                    type$iv3 = type$iv2;
                                                }
                                                mask$iv$iv2 = mask$iv$iv;
                                                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                                type$iv = type$iv3;
                                                if (count$iv$iv2 == 1) {
                                                    mask$iv$iv = mask$iv$iv2;
                                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                                    type$iv3 = type$iv;
                                                }
                                            }
                                        } else if (FocusTransactionsKt.freeFocus((FocusTargetNode) this_$iv$iv$iv2)) {
                                            return true;
                                        } else {
                                            mask$iv$iv2 = mask$iv$iv;
                                            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                            type$iv = type$iv3;
                                        }
                                        this_$iv$iv$iv2 = DelegatableNodeKt.pop(mutableVector4);
                                        mask$iv$iv = mask$iv$iv2;
                                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                        type$iv3 = type$iv;
                                    }
                                    DelegatableNode delegatableNode2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                    int i7 = type$iv3;
                                    mask$iv$iv4 = mask$iv$iv;
                                } else {
                                    DelegatableNode delegatableNode3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                    int i8 = type$iv3;
                                    node$iv$iv = node$iv$iv.getChild$ui_release();
                                    mask$iv$iv4 = mask$iv$iv;
                                }
                            }
                        } else {
                            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                        }
                    }
                    return false;
                }
                int i9 = mask$iv$iv4;
                DelegatableNode delegatableNode4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                throw new IllegalStateException("visitChildren called on an unattached node".toString());
            }
        }
    }
}

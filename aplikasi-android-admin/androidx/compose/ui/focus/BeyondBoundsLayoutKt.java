package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\b\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"searchBeyondBounds", "T", "Landroidx/compose/ui/focus/FocusTargetNode;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BeyondBoundsLayout.kt */
public final class BeyondBoundsLayoutKt {
    /* renamed from: searchBeyondBounds--OM-vw8  reason: not valid java name */
    public static final <T> T m4625searchBeyondBoundsOMvw8(FocusTargetNode $this$searchBeyondBounds_u2d_u2dOM_u2dvw8, int direction, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        FocusTargetNode focusTargetNode;
        T t;
        int i;
        int i2;
        int type$iv;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        NodeChain nodes$ui_release;
        int i3;
        int type$iv2;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        int i4;
        int type$iv3;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
        int i5;
        int type$iv4;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv4;
        int count$iv$iv$iv;
        MutableVector mutableVector;
        FocusTargetNode focusTargetNode2 = $this$searchBeyondBounds_u2d_u2dOM_u2dvw8;
        int i6 = direction;
        Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> function1 = block;
        Intrinsics.checkNotNullParameter(focusTargetNode2, "$this$searchBeyondBounds");
        Intrinsics.checkNotNullParameter(function1, "block");
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv5 = focusTargetNode2;
        int type$iv5 = NodeKind.m6666constructorimpl(1024);
        int i7 = false;
        int mask$iv$iv$iv = type$iv5;
        DelegatableNode $this$visitAncestors$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv5;
        if ($this$visitAncestors$iv$iv$iv.getNode().isAttached()) {
            Modifier.Node node$iv$iv$iv = $this$visitAncestors$iv$iv$iv.getNode().getParent$ui_release();
            LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv$iv);
            loop0:
            while (true) {
                if (layout$iv$iv$iv == null) {
                    int i8 = type$iv5;
                    int i9 = i7;
                    focusTargetNode = null;
                    break;
                }
                if ((layout$iv$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                    while (node$iv$iv$iv != null) {
                        if ((node$iv$iv$iv.getKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                            MutableVector mutableVector2 = null;
                            Modifier.Node node = node$iv$iv$iv;
                            while (node != null) {
                                if (node instanceof FocusTargetNode) {
                                    focusTargetNode = node;
                                    break loop0;
                                }
                                Modifier.Node this_$iv$iv$iv$iv = node;
                                Modifier.Node node2 = this_$iv$iv$iv$iv;
                                if (((this_$iv$iv$iv$iv.getKindSet$ui_release() & type$iv2) != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                                    type$iv3 = type$iv2;
                                    i4 = i3;
                                } else {
                                    int count$iv$iv$iv2 = 0;
                                    Modifier.Node node$iv$iv$iv$iv = ((DelegatingNode) node).getDelegate$ui_release();
                                    while (node$iv$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                        if ((next$iv$iv$iv.getKindSet$ui_release() & type$iv2) != 0) {
                                            count$iv$iv$iv2++;
                                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                            if (count$iv$iv$iv2 == 1) {
                                                node = next$iv$iv$iv;
                                                type$iv4 = type$iv2;
                                                i5 = i3;
                                                Modifier.Node node3 = next$iv$iv$iv;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    count$iv$iv$iv = count$iv$iv$iv2;
                                                    type$iv4 = type$iv2;
                                                    i5 = i3;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    count$iv$iv$iv = count$iv$iv$iv2;
                                                    type$iv4 = type$iv2;
                                                    i5 = i3;
                                                    mutableVector = mutableVector2;
                                                }
                                                MutableVector mutableVector3 = mutableVector;
                                                Modifier.Node theNode$iv$iv$iv = node;
                                                if (theNode$iv$iv$iv != null) {
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(theNode$iv$iv$iv);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(next$iv$iv$iv);
                                                }
                                                mutableVector2 = mutableVector3;
                                                count$iv$iv$iv2 = count$iv$iv$iv;
                                            }
                                        } else {
                                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                            type$iv4 = type$iv2;
                                            i5 = i3;
                                            Modifier.Node node4 = next$iv$iv$iv;
                                        }
                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                        type$iv2 = type$iv4;
                                        i3 = i5;
                                    }
                                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                                    type$iv3 = type$iv2;
                                    i4 = i3;
                                    if (count$iv$iv$iv2 == 1) {
                                        FocusTargetNode focusTargetNode3 = $this$searchBeyondBounds_u2d_u2dOM_u2dvw8;
                                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                                        type$iv2 = type$iv3;
                                        i3 = i4;
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector2);
                                FocusTargetNode focusTargetNode4 = $this$searchBeyondBounds_u2d_u2dOM_u2dvw8;
                                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                                type$iv2 = type$iv3;
                                i3 = i4;
                            }
                            continue;
                        }
                        node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                        FocusTargetNode focusTargetNode5 = $this$searchBeyondBounds_u2d_u2dOM_u2dvw8;
                        $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv2;
                        type$iv5 = type$iv2;
                        i7 = i3;
                    }
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    type$iv = type$iv2;
                    i2 = i3;
                } else {
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv5;
                    type$iv = type$iv5;
                    i2 = i7;
                }
                layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes$ui_release = layout$iv$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                FocusTargetNode focusTargetNode6 = $this$searchBeyondBounds_u2d_u2dOM_u2dvw8;
                $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv;
                type$iv5 = type$iv;
                i7 = i2;
            }
            FocusTargetNode it = focusTargetNode;
            if (it == null) {
                t = null;
            } else if (Intrinsics.areEqual((Object) it.getBeyondBoundsLayoutParent(), (Object) $this$searchBeyondBounds_u2d_u2dOM_u2dvw8.getBeyondBoundsLayoutParent())) {
                return null;
            } else {
                t = null;
            }
            BeyondBoundsLayout beyondBoundsLayoutParent = $this$searchBeyondBounds_u2d_u2dOM_u2dvw8.getBeyondBoundsLayoutParent();
            if (beyondBoundsLayoutParent == null) {
                return t;
            }
            if (FocusDirection.m4629equalsimpl0(i6, FocusDirection.Companion.m4646getUpdhqQ8s())) {
                i = BeyondBoundsLayout.LayoutDirection.Companion.m6311getAbovehoxUOeE();
            } else if (FocusDirection.m4629equalsimpl0(i6, FocusDirection.Companion.m4637getDowndhqQ8s())) {
                i = BeyondBoundsLayout.LayoutDirection.Companion.m6314getBelowhoxUOeE();
            } else if (FocusDirection.m4629equalsimpl0(i6, FocusDirection.Companion.m4641getLeftdhqQ8s())) {
                i = BeyondBoundsLayout.LayoutDirection.Companion.m6315getLefthoxUOeE();
            } else if (FocusDirection.m4629equalsimpl0(i6, FocusDirection.Companion.m4645getRightdhqQ8s())) {
                i = BeyondBoundsLayout.LayoutDirection.Companion.m6316getRighthoxUOeE();
            } else if (FocusDirection.m4629equalsimpl0(i6, FocusDirection.Companion.m4642getNextdhqQ8s())) {
                i = BeyondBoundsLayout.LayoutDirection.Companion.m6312getAfterhoxUOeE();
            } else if (FocusDirection.m4629equalsimpl0(i6, FocusDirection.Companion.m4644getPreviousdhqQ8s())) {
                i = BeyondBoundsLayout.LayoutDirection.Companion.m6313getBeforehoxUOeE();
            } else {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            }
            return beyondBoundsLayoutParent.m6303layouto7g1Pn8(i, function1);
        }
        DelegatableNode delegatableNode = $this$nearestAncestor_u2d64DMado$iv5;
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }
}

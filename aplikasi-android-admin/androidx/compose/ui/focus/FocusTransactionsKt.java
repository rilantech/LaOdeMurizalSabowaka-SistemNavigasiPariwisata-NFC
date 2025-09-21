package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a \u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a!\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a!\u0010\u000f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u000e\u001a!\u0010\u0011\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u000e\u001a!\u0010\u0013\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u000e\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0016\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0002\u001a\f\u0010\u0019\u001a\u00020\u0001*\u00020\u0002H\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"captureFocus", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "clearChildFocus", "forced", "refreshFocusEvents", "clearFocus", "freeFocus", "grantFocus", "performCustomClearFocus", "Landroidx/compose/ui/focus/CustomDestinationResult;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "performCustomClearFocus-Mxy_nc0", "(Landroidx/compose/ui/focus/FocusTargetNode;I)Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomEnter", "performCustomEnter-Mxy_nc0", "performCustomExit", "performCustomExit-Mxy_nc0", "performCustomRequestFocus", "performCustomRequestFocus-Mxy_nc0", "performRequestFocus", "requestFocus", "requestFocusForChild", "childNode", "requestFocusForOwner", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusTransactions.kt */
public final class FocusTransactionsKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusTransactions.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final boolean requestFocus(FocusTargetNode $this$requestFocus) {
        Intrinsics.checkNotNullParameter($this$requestFocus, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[m4664performCustomRequestFocusMxy_nc0($this$requestFocus, FocusDirection.Companion.m4638getEnterdhqQ8s()).ordinal()]) {
            case 1:
                return performRequestFocus($this$requestFocus);
            case 2:
                return true;
            case 3:
            case 4:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean performRequestFocus(FocusTargetNode $this$performRequestFocus) {
        boolean z;
        FocusTargetNode this_$iv$iv$iv$iv;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        boolean z2;
        NodeChain nodes$ui_release;
        boolean z3;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
        boolean z4;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv4;
        int count$iv$iv$iv;
        MutableVector mutableVector;
        FocusTargetNode focusTargetNode = $this$performRequestFocus;
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        boolean z5 = true;
        switch (WhenMappings.$EnumSwitchMapping$1[$this$performRequestFocus.getFocusState().ordinal()]) {
            case 1:
            case 2:
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$performRequestFocus);
                return true;
            case 3:
                boolean success = clearChildFocus$default(focusTargetNode, false, false, 3, (Object) null) && grantFocus($this$performRequestFocus);
                if (success) {
                    FocusEventModifierNodeKt.refreshFocusEventNodes($this$performRequestFocus);
                }
                return success;
            case 4:
                DelegatableNode $this$nearestAncestor_u2d64DMado$iv5 = focusTargetNode;
                int type$iv = NodeKind.m6666constructorimpl(1024);
                int mask$iv$iv$iv = type$iv;
                DelegatableNode $this$visitAncestors$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv5;
                if ($this$visitAncestors$iv$iv$iv.getNode().isAttached()) {
                    Modifier.Node node$iv$iv$iv = $this$visitAncestors$iv$iv$iv.getNode().getParent$ui_release();
                    LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv$iv);
                    while (true) {
                        if (layout$iv$iv$iv != null) {
                            if ((layout$iv$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                                while (node$iv$iv$iv != null) {
                                    if ((node$iv$iv$iv.getKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                                        MutableVector mutableVector2 = null;
                                        this_$iv$iv$iv$iv = node$iv$iv$iv;
                                        while (this_$iv$iv$iv$iv != null) {
                                            if (this_$iv$iv$iv$iv instanceof FocusTargetNode) {
                                                Modifier.Node node = this_$iv$iv$iv$iv;
                                                z = z3;
                                            } else {
                                                if (!((this_$iv$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? z3 : false) || !(this_$iv$iv$iv$iv instanceof DelegatingNode)) {
                                                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                                                    z4 = z3;
                                                } else {
                                                    int count$iv$iv$iv2 = 0;
                                                    Modifier.Node node$iv$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv$iv).getDelegate$ui_release();
                                                    while (node$iv$iv$iv$iv != null) {
                                                        Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                                        if ((next$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? z3 : false) {
                                                            count$iv$iv$iv2++;
                                                            if (count$iv$iv$iv2 == z3) {
                                                                this_$iv$iv$iv$iv = next$iv$iv$iv;
                                                                $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                                Modifier.Node node2 = next$iv$iv$iv;
                                                            } else {
                                                                if (mutableVector2 == null) {
                                                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                                    count$iv$iv$iv = count$iv$iv$iv2;
                                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                                } else {
                                                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                                    count$iv$iv$iv = count$iv$iv$iv2;
                                                                    mutableVector = mutableVector2;
                                                                }
                                                                Modifier.Node theNode$iv$iv$iv = this_$iv$iv$iv$iv;
                                                                if (theNode$iv$iv$iv != null) {
                                                                    if (mutableVector != null) {
                                                                        mutableVector.add(theNode$iv$iv$iv);
                                                                    }
                                                                    this_$iv$iv$iv$iv = null;
                                                                }
                                                                if (mutableVector != null) {
                                                                    mutableVector.add(next$iv$iv$iv);
                                                                }
                                                                mutableVector2 = mutableVector;
                                                                count$iv$iv$iv2 = count$iv$iv$iv;
                                                            }
                                                        } else {
                                                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                            Modifier.Node node3 = next$iv$iv$iv;
                                                        }
                                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                                        z3 = true;
                                                    }
                                                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                                                    z4 = true;
                                                    if (count$iv$iv$iv2 == 1) {
                                                        z3 = true;
                                                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                                                    }
                                                }
                                                this_$iv$iv$iv$iv = DelegatableNodeKt.pop(mutableVector2);
                                                z3 = z4;
                                                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                                            }
                                        }
                                        continue;
                                    }
                                    node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                                    z5 = z3;
                                    $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv2;
                                }
                                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                                z2 = z3;
                            } else {
                                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv5;
                                z2 = z5;
                            }
                            layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                            node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes$ui_release = layout$iv$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                            z5 = z2;
                            $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv;
                        } else {
                            z = z5;
                            this_$iv$iv$iv$iv = null;
                        }
                    }
                    FocusTargetNode focusTargetNode2 = this_$iv$iv$iv$iv;
                    if (focusTargetNode2 != null) {
                        return requestFocusForChild(focusTargetNode2, focusTargetNode);
                    }
                    boolean success2 = (!requestFocusForOwner($this$performRequestFocus) || !grantFocus($this$performRequestFocus)) ? false : z;
                    if (success2) {
                        FocusEventModifierNodeKt.refreshFocusEventNodes($this$performRequestFocus);
                    }
                    return success2;
                }
                DelegatableNode delegatableNode = $this$nearestAncestor_u2d64DMado$iv5;
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean captureFocus(FocusTargetNode $this$captureFocus) {
        Intrinsics.checkNotNullParameter($this$captureFocus, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[$this$captureFocus.getFocusState().ordinal()]) {
            case 1:
                $this$captureFocus.setFocusState(FocusStateImpl.Captured);
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$captureFocus);
                return true;
            case 2:
                return true;
            case 3:
            case 4:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean freeFocus(FocusTargetNode $this$freeFocus) {
        Intrinsics.checkNotNullParameter($this$freeFocus, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[$this$freeFocus.getFocusState().ordinal()]) {
            case 1:
                return true;
            case 2:
                $this$freeFocus.setFocusState(FocusStateImpl.Active);
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$freeFocus);
                return true;
            case 3:
            case 4:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ boolean clearFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return clearFocus(focusTargetNode, z, z2);
    }

    public static final boolean clearFocus(FocusTargetNode $this$clearFocus, boolean forced, boolean refreshFocusEvents) {
        Intrinsics.checkNotNullParameter($this$clearFocus, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[$this$clearFocus.getFocusState().ordinal()]) {
            case 1:
                $this$clearFocus.setFocusState(FocusStateImpl.Inactive);
                if (!refreshFocusEvents) {
                    return true;
                }
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$clearFocus);
                return true;
            case 2:
                if (forced) {
                    $this$clearFocus.setFocusState(FocusStateImpl.Inactive);
                    if (refreshFocusEvents) {
                        FocusEventModifierNodeKt.refreshFocusEventNodes($this$clearFocus);
                    }
                }
                return forced;
            case 3:
                if (!clearChildFocus($this$clearFocus, forced, refreshFocusEvents)) {
                    return false;
                }
                $this$clearFocus.setFocusState(FocusStateImpl.Inactive);
                if (!refreshFocusEvents) {
                    return true;
                }
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$clearFocus);
                return true;
            case 4:
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean grantFocus(FocusTargetNode $this$grantFocus) {
        ObserverModifierNodeKt.observeReads($this$grantFocus, new FocusTransactionsKt$grantFocus$1($this$grantFocus));
        switch (WhenMappings.$EnumSwitchMapping$1[$this$grantFocus.getFocusState().ordinal()]) {
            case 3:
            case 4:
                $this$grantFocus.setFocusState(FocusStateImpl.Active);
                return true;
            default:
                return true;
        }
    }

    static /* synthetic */ boolean clearChildFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return clearChildFocus(focusTargetNode, z, z2);
    }

    private static final boolean clearChildFocus(FocusTargetNode $this$clearChildFocus, boolean forced, boolean refreshFocusEvents) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild($this$clearChildFocus);
        if (activeChild != null) {
            return clearFocus(activeChild, forced, refreshFocusEvents);
        }
        return true;
    }

    private static final boolean requestFocusForChild(FocusTargetNode $this$requestFocusForChild, FocusTargetNode childNode) {
        Modifier.Node node;
        int type$iv;
        Modifier.Node node2;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv;
        int type$iv2;
        int i;
        Object $this$nearestAncestor_u2d64DMado$iv;
        NodeChain nodes$ui_release;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2;
        int count$iv$iv$iv;
        int type$iv3;
        Object node$iv$iv$iv;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv3;
        int type$iv4;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4;
        int type$iv5;
        int count$iv$iv$iv2;
        MutableVector mutableVector;
        int i2;
        int type$iv6;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        NodeChain nodes$ui_release2;
        int i3;
        int i4;
        int type$iv7;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
        int i5;
        int type$iv8;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv4;
        int i6;
        int type$iv9;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv5;
        MutableVector mutableVector2;
        FocusTargetNode focusTargetNode = $this$requestFocusForChild;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv6 = childNode;
        int type$iv10 = NodeKind.m6666constructorimpl(1024);
        int i7 = false;
        int mask$iv$iv$iv = type$iv10;
        DelegatableNode $this$visitAncestors$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv6;
        if ($this$visitAncestors$iv$iv$iv.getNode().isAttached()) {
            Modifier.Node node$iv$iv$iv2 = $this$visitAncestors$iv$iv$iv.getNode().getParent$ui_release();
            LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv$iv);
            loop0:
            while (true) {
                int i8 = 1;
                if (layout$iv$iv$iv == null) {
                    int i9 = type$iv10;
                    int i10 = i7;
                    node = null;
                    break;
                }
                if ((layout$iv$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                    while (node$iv$iv$iv2 != null) {
                        if ((node$iv$iv$iv2.getKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                            MutableVector mutableVector3 = null;
                            Modifier.Node this_$iv$iv$iv$iv = node$iv$iv$iv2;
                            while (this_$iv$iv$iv$iv != null) {
                                if (this_$iv$iv$iv$iv instanceof FocusTargetNode) {
                                    node = this_$iv$iv$iv$iv;
                                    break loop0;
                                }
                                if (((this_$iv$iv$iv$iv.getKindSet$ui_release() & type$iv7) != 0 ? i3 : 0) == 0 || !(this_$iv$iv$iv$iv instanceof DelegatingNode)) {
                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                                    type$iv8 = type$iv7;
                                    i5 = i4;
                                } else {
                                    int count$iv$iv$iv3 = 0;
                                    Modifier.Node node$iv$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv$iv).getDelegate$ui_release();
                                    while (node$iv$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                        if (((next$iv$iv$iv.getKindSet$ui_release() & type$iv7) != 0 ? i3 : 0) != 0) {
                                            count$iv$iv$iv3++;
                                            if (count$iv$iv$iv3 == i3) {
                                                this_$iv$iv$iv$iv = next$iv$iv$iv;
                                                $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv3;
                                                type$iv9 = type$iv7;
                                                i6 = i4;
                                                Modifier.Node node3 = next$iv$iv$iv;
                                            } else {
                                                if (mutableVector3 == null) {
                                                    $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv3;
                                                    type$iv9 = type$iv7;
                                                    i6 = i4;
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv3;
                                                    type$iv9 = type$iv7;
                                                    i6 = i4;
                                                    mutableVector2 = mutableVector3;
                                                }
                                                Modifier.Node theNode$iv$iv$iv = this_$iv$iv$iv$iv;
                                                if (theNode$iv$iv$iv != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(theNode$iv$iv$iv);
                                                    }
                                                    this_$iv$iv$iv$iv = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(next$iv$iv$iv);
                                                }
                                                mutableVector3 = mutableVector2;
                                            }
                                        } else {
                                            $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv3;
                                            type$iv9 = type$iv7;
                                            i6 = i4;
                                            Modifier.Node node4 = next$iv$iv$iv;
                                        }
                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv5;
                                        type$iv7 = type$iv9;
                                        i4 = i6;
                                        i3 = 1;
                                    }
                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                                    type$iv8 = type$iv7;
                                    i5 = i4;
                                    if (count$iv$iv$iv3 == 1) {
                                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                        type$iv7 = type$iv8;
                                        i4 = i5;
                                        i3 = 1;
                                    }
                                }
                                this_$iv$iv$iv$iv = DelegatableNodeKt.pop(mutableVector3);
                                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                type$iv7 = type$iv8;
                                i4 = i5;
                                i3 = 1;
                            }
                            continue;
                        }
                        node$iv$iv$iv2 = node$iv$iv$iv2.getParent$ui_release();
                        $this$nearestAncestor_u2d64DMado$iv6 = $this$nearestAncestor_u2d64DMado$iv3;
                        type$iv10 = type$iv7;
                        i7 = i4;
                        i8 = 1;
                    }
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                    type$iv6 = type$iv7;
                    i2 = i4;
                } else {
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv6;
                    type$iv6 = type$iv10;
                    i2 = i7;
                }
                layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                node$iv$iv$iv2 = (layout$iv$iv$iv == null || (nodes$ui_release2 = layout$iv$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
                $this$nearestAncestor_u2d64DMado$iv6 = $this$nearestAncestor_u2d64DMado$iv2;
                type$iv10 = type$iv6;
                i7 = i2;
            }
            if (Intrinsics.areEqual((Object) node, (Object) focusTargetNode)) {
                switch (WhenMappings.$EnumSwitchMapping$1[$this$requestFocusForChild.getFocusState().ordinal()]) {
                    case 1:
                        boolean success = grantFocus(childNode);
                        if (!success) {
                            return success;
                        }
                        focusTargetNode.setFocusState(FocusStateImpl.ActiveParent);
                        FocusEventModifierNodeKt.refreshFocusEventNodes(childNode);
                        FocusEventModifierNodeKt.refreshFocusEventNodes($this$requestFocusForChild);
                        return success;
                    case 2:
                        return false;
                    case 3:
                        if (FocusTraversalKt.getActiveChild($this$requestFocusForChild) != null) {
                            boolean success2 = clearChildFocus$default(focusTargetNode, false, false, 3, (Object) null) && grantFocus(childNode);
                            if (success2) {
                                FocusEventModifierNodeKt.refreshFocusEventNodes(childNode);
                            }
                            return success2;
                        }
                        throw new IllegalStateException("Required value was null.".toString());
                    case 4:
                        Object $this$nearestAncestor_u2d64DMado$iv7 = focusTargetNode;
                        int type$iv11 = NodeKind.m6666constructorimpl(1024);
                        int count$iv$iv$iv4 = false;
                        Object $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv5 = $this$nearestAncestor_u2d64DMado$iv7;
                        int mask$iv$iv$iv2 = type$iv11;
                        DelegatableNode $this$visitAncestors$iv$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv5;
                        if ($this$visitAncestors$iv$iv$iv2.getNode().isAttached()) {
                            Modifier.Node node$iv$iv$iv3 = $this$visitAncestors$iv$iv$iv2.getNode().getParent$ui_release();
                            LayoutNode layout$iv$iv$iv2 = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv$iv2);
                            while (true) {
                                if (layout$iv$iv$iv2 != null) {
                                    if ((layout$iv$iv$iv2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv$iv2) != 0) {
                                        while (node$iv$iv$iv3 != null) {
                                            if ((node$iv$iv$iv3.getKindSet$ui_release() & mask$iv$iv$iv2) != 0) {
                                                MutableVector mutableVector4 = null;
                                                node$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv7;
                                                Modifier.Node node$iv$iv$iv4 = node$iv$iv$iv3;
                                                while (node$iv$iv$iv4 != null) {
                                                    int i11 = count$iv$iv$iv;
                                                    if ((node$iv$iv$iv4 instanceof FocusTargetNode) != 0) {
                                                        node2 = node$iv$iv$iv4;
                                                        type$iv = 1;
                                                    } else {
                                                        if (!((node$iv$iv$iv4.getKindSet$ui_release() & type$iv3) != 0) || !(node$iv$iv$iv4 instanceof DelegatingNode)) {
                                                            type$iv4 = type$iv3;
                                                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2;
                                                        } else {
                                                            int count$iv$iv$iv5 = 0;
                                                            Modifier.Node node$iv$iv$iv$iv2 = ((DelegatingNode) node$iv$iv$iv4).getDelegate$ui_release();
                                                            while (node$iv$iv$iv$iv2 != null) {
                                                                DelegatableNode next$iv$iv$iv2 = node$iv$iv$iv$iv2;
                                                                if ((next$iv$iv$iv2.getKindSet$ui_release() & type$iv3) != 0) {
                                                                    count$iv$iv$iv5++;
                                                                    type$iv5 = type$iv3;
                                                                    if (count$iv$iv$iv5 == 1) {
                                                                        node$iv$iv$iv4 = next$iv$iv$iv2;
                                                                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2;
                                                                        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv6 = next$iv$iv$iv2;
                                                                    } else {
                                                                        if (mutableVector4 == null) {
                                                                            count$iv$iv$iv2 = count$iv$iv$iv5;
                                                                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2;
                                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                                        } else {
                                                                            count$iv$iv$iv2 = count$iv$iv$iv5;
                                                                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2;
                                                                            mutableVector = mutableVector4;
                                                                        }
                                                                        MutableVector mutableVector5 = mutableVector;
                                                                        Modifier.Node theNode$iv$iv$iv2 = node$iv$iv$iv4;
                                                                        if (theNode$iv$iv$iv2 != null) {
                                                                            if (mutableVector5 != null) {
                                                                                mutableVector5.add(theNode$iv$iv$iv2);
                                                                            }
                                                                            node$iv$iv$iv4 = null;
                                                                        }
                                                                        if (mutableVector5 != null) {
                                                                            mutableVector5.add(next$iv$iv$iv2);
                                                                        }
                                                                        mutableVector4 = mutableVector5;
                                                                        count$iv$iv$iv5 = count$iv$iv$iv2;
                                                                    }
                                                                } else {
                                                                    type$iv5 = type$iv3;
                                                                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2;
                                                                    DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv7 = next$iv$iv$iv2;
                                                                }
                                                                node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                                                                type$iv3 = type$iv5;
                                                                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4;
                                                            }
                                                            type$iv4 = type$iv3;
                                                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2;
                                                            if (count$iv$iv$iv5 == 1) {
                                                                count$iv$iv$iv = i11;
                                                                type$iv3 = type$iv4;
                                                                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv3;
                                                            }
                                                        }
                                                        node$iv$iv$iv4 = DelegatableNodeKt.pop(mutableVector4);
                                                        count$iv$iv$iv = i11;
                                                        type$iv3 = type$iv4;
                                                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv3;
                                                    }
                                                }
                                                continue;
                                            } else {
                                                node$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv7;
                                            }
                                            node$iv$iv$iv3 = node$iv$iv$iv3.getParent$ui_release();
                                            $this$nearestAncestor_u2d64DMado$iv7 = node$iv$iv$iv;
                                            count$iv$iv$iv4 = count$iv$iv$iv;
                                            type$iv11 = type$iv3;
                                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv5 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2;
                                        }
                                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv7;
                                        type$iv2 = type$iv3;
                                        i = count$iv$iv$iv;
                                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2;
                                    } else {
                                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv7;
                                        type$iv2 = type$iv11;
                                        i = count$iv$iv$iv4;
                                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv5;
                                    }
                                    layout$iv$iv$iv2 = layout$iv$iv$iv2.getParent$ui_release();
                                    node$iv$iv$iv3 = (layout$iv$iv$iv2 == null || (nodes$ui_release = layout$iv$iv$iv2.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                                    $this$nearestAncestor_u2d64DMado$iv7 = $this$nearestAncestor_u2d64DMado$iv;
                                    count$iv$iv$iv4 = i;
                                    type$iv11 = type$iv2;
                                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv5 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv;
                                } else {
                                    int i12 = type$iv11;
                                    int i13 = count$iv$iv$iv4;
                                    DelegatableNode delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv5;
                                    type$iv = 1;
                                    node2 = null;
                                }
                            }
                            FocusTargetNode focusParent = (FocusTargetNode) node2;
                            if (focusParent == null && requestFocusForOwner($this$requestFocusForChild)) {
                                focusTargetNode.setFocusState(FocusStateImpl.Active);
                                FocusEventModifierNodeKt.refreshFocusEventNodes($this$requestFocusForChild);
                                return requestFocusForChild($this$requestFocusForChild, childNode);
                            } else if (focusParent == null || !requestFocusForChild(focusParent, focusTargetNode)) {
                                return false;
                            } else {
                                boolean requestFocusForChild = requestFocusForChild($this$requestFocusForChild, childNode);
                                boolean z = requestFocusForChild;
                                if (($this$requestFocusForChild.getFocusState() == FocusStateImpl.ActiveParent ? type$iv : 0) != 0) {
                                    return requestFocusForChild;
                                }
                                throw new IllegalStateException("Check failed.".toString());
                            }
                        } else {
                            Object obj = $this$nearestAncestor_u2d64DMado$iv7;
                            int i14 = type$iv11;
                            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                        }
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            } else {
                throw new IllegalStateException("Non child node cannot request focus.".toString());
            }
        } else {
            DelegatableNode delegatableNode2 = $this$nearestAncestor_u2d64DMado$iv6;
            int i15 = type$iv10;
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
    }

    private static final boolean requestFocusForOwner(FocusTargetNode $this$requestFocusForOwner) {
        LayoutNode layoutNode;
        Owner owner$ui_release;
        NodeCoordinator coordinator$ui_release = $this$requestFocusForOwner.getCoordinator$ui_release();
        if (coordinator$ui_release != null && (layoutNode = coordinator$ui_release.getLayoutNode()) != null && (owner$ui_release = layoutNode.getOwner$ui_release()) != null) {
            return owner$ui_release.requestFocus();
        }
        throw new IllegalStateException("Owner not initialized.".toString());
    }

    /* renamed from: performCustomRequestFocus-Mxy_nc0  reason: not valid java name */
    public static final CustomDestinationResult m4664performCustomRequestFocusMxy_nc0(FocusTargetNode $this$performCustomRequestFocus_u2dMxy_nc0, int focusDirection) {
        int i;
        int type$iv;
        FocusTargetNode focusTargetNode;
        int type$iv2;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        NodeChain nodes$ui_release;
        int i2;
        int type$iv3;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        int type$iv4;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
        int i3;
        int type$iv5;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv4;
        MutableVector mutableVector;
        FocusTargetNode focusTargetNode2 = $this$performCustomRequestFocus_u2dMxy_nc0;
        int i4 = focusDirection;
        Intrinsics.checkNotNullParameter(focusTargetNode2, "$this$performCustomRequestFocus");
        switch (WhenMappings.$EnumSwitchMapping$1[$this$performCustomRequestFocus_u2dMxy_nc0.getFocusState().ordinal()]) {
            case 1:
            case 2:
                return CustomDestinationResult.None;
            case 3:
                FocusTargetNode activeChild = FocusTraversalKt.getActiveChild($this$performCustomRequestFocus_u2dMxy_nc0);
                if (activeChild != null) {
                    return m4661performCustomClearFocusMxy_nc0(activeChild, i4);
                }
                throw new IllegalStateException("Required value was null.".toString());
            case 4:
                DelegatableNode $this$nearestAncestor_u2d64DMado$iv5 = focusTargetNode2;
                int type$iv6 = NodeKind.m6666constructorimpl(1024);
                int mask$iv$iv$iv = type$iv6;
                DelegatableNode $this$visitAncestors$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv5;
                if ($this$visitAncestors$iv$iv$iv.getNode().isAttached()) {
                    Modifier.Node node$iv$iv$iv = $this$visitAncestors$iv$iv$iv.getNode().getParent$ui_release();
                    LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv$iv);
                    while (true) {
                        int i5 = 1;
                        if (layout$iv$iv$iv != null) {
                            if ((layout$iv$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                                while (node$iv$iv$iv != null) {
                                    if ((node$iv$iv$iv.getKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                                        MutableVector mutableVector2 = null;
                                        Modifier.Node this_$iv$iv$iv$iv = node$iv$iv$iv;
                                        while (this_$iv$iv$iv$iv != null) {
                                            if (this_$iv$iv$iv$iv instanceof FocusTargetNode) {
                                                focusTargetNode = this_$iv$iv$iv$iv;
                                                i = i2;
                                                type$iv = 0;
                                            } else {
                                                if (((this_$iv$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? i2 : 0) == 0 || !(this_$iv$iv$iv$iv instanceof DelegatingNode)) {
                                                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                                                    type$iv4 = type$iv3;
                                                    i3 = i2;
                                                } else {
                                                    int count$iv$iv$iv = 0;
                                                    Modifier.Node node$iv$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv$iv).getDelegate$ui_release();
                                                    while (node$iv$iv$iv$iv != null) {
                                                        Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                                        if (((next$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? i2 : 0) != 0) {
                                                            count$iv$iv$iv++;
                                                            if (count$iv$iv$iv == i2) {
                                                                this_$iv$iv$iv$iv = next$iv$iv$iv;
                                                                $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                                type$iv5 = type$iv3;
                                                                Modifier.Node node = next$iv$iv$iv;
                                                            } else {
                                                                if (mutableVector2 == null) {
                                                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                                    type$iv5 = type$iv3;
                                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                                } else {
                                                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                                    type$iv5 = type$iv3;
                                                                    mutableVector = mutableVector2;
                                                                }
                                                                Modifier.Node theNode$iv$iv$iv = this_$iv$iv$iv$iv;
                                                                if (theNode$iv$iv$iv != null) {
                                                                    if (mutableVector != null) {
                                                                        mutableVector.add(theNode$iv$iv$iv);
                                                                    }
                                                                    this_$iv$iv$iv$iv = null;
                                                                }
                                                                if (mutableVector != null) {
                                                                    mutableVector.add(next$iv$iv$iv);
                                                                }
                                                                mutableVector2 = mutableVector;
                                                            }
                                                        } else {
                                                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                            type$iv5 = type$iv3;
                                                            Modifier.Node node2 = next$iv$iv$iv;
                                                        }
                                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                                        FocusTargetNode focusTargetNode3 = $this$performCustomRequestFocus_u2dMxy_nc0;
                                                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                                        type$iv3 = type$iv5;
                                                        i2 = 1;
                                                    }
                                                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                                                    type$iv4 = type$iv3;
                                                    i3 = 1;
                                                    if (count$iv$iv$iv == 1) {
                                                        i2 = 1;
                                                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                                                        type$iv3 = type$iv4;
                                                        FocusTargetNode focusTargetNode4 = $this$performCustomRequestFocus_u2dMxy_nc0;
                                                    }
                                                }
                                                this_$iv$iv$iv$iv = DelegatableNodeKt.pop(mutableVector2);
                                                i2 = i3;
                                                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                                                type$iv3 = type$iv4;
                                                FocusTargetNode focusTargetNode5 = $this$performCustomRequestFocus_u2dMxy_nc0;
                                            }
                                        }
                                        continue;
                                    }
                                    node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                                    i5 = i2;
                                    $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv2;
                                    type$iv6 = type$iv3;
                                    FocusTargetNode focusTargetNode6 = $this$performCustomRequestFocus_u2dMxy_nc0;
                                }
                                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                                type$iv2 = type$iv3;
                            } else {
                                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv5;
                                type$iv2 = type$iv6;
                            }
                            layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                            node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes$ui_release = layout$iv$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                            FocusTargetNode focusTargetNode7 = $this$performCustomRequestFocus_u2dMxy_nc0;
                            $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv;
                            type$iv6 = type$iv2;
                        } else {
                            int i6 = type$iv6;
                            i = 1;
                            type$iv = 0;
                            focusTargetNode = null;
                        }
                    }
                    FocusTargetNode focusTargetNode8 = focusTargetNode;
                    if (focusTargetNode8 == null) {
                        return CustomDestinationResult.None;
                    }
                    FocusTargetNode focusParent = focusTargetNode8;
                    switch (WhenMappings.$EnumSwitchMapping$1[focusParent.getFocusState().ordinal()]) {
                        case 1:
                            return m4662performCustomEnterMxy_nc0(focusParent, i4);
                        case 2:
                            return CustomDestinationResult.Cancelled;
                        case 3:
                            return m4664performCustomRequestFocusMxy_nc0(focusParent, i4);
                        case 4:
                            CustomDestinationResult it = m4664performCustomRequestFocusMxy_nc0(focusParent, i4);
                            CustomDestinationResult customDestinationResult = (it == CustomDestinationResult.None ? i : type$iv) == 0 ? it : null;
                            if (customDestinationResult == null) {
                                return m4662performCustomEnterMxy_nc0(focusParent, i4);
                            }
                            return customDestinationResult;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                } else {
                    DelegatableNode delegatableNode = $this$nearestAncestor_u2d64DMado$iv5;
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: performCustomClearFocus-Mxy_nc0  reason: not valid java name */
    public static final CustomDestinationResult m4661performCustomClearFocusMxy_nc0(FocusTargetNode $this$performCustomClearFocus_u2dMxy_nc0, int focusDirection) {
        Intrinsics.checkNotNullParameter($this$performCustomClearFocus_u2dMxy_nc0, "$this$performCustomClearFocus");
        switch (WhenMappings.$EnumSwitchMapping$1[$this$performCustomClearFocus_u2dMxy_nc0.getFocusState().ordinal()]) {
            case 1:
            case 4:
                return CustomDestinationResult.None;
            case 2:
                return CustomDestinationResult.Cancelled;
            case 3:
                FocusTargetNode activeChild = FocusTraversalKt.getActiveChild($this$performCustomClearFocus_u2dMxy_nc0);
                if (activeChild != null) {
                    CustomDestinationResult it = m4661performCustomClearFocusMxy_nc0(activeChild, focusDirection);
                    if (it == CustomDestinationResult.None) {
                        it = null;
                    }
                    if (it == null) {
                        return m4663performCustomExitMxy_nc0($this$performCustomClearFocus_u2dMxy_nc0, focusDirection);
                    }
                    return it;
                }
                throw new IllegalStateException("Required value was null.".toString());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: performCustomEnter-Mxy_nc0  reason: not valid java name */
    private static final CustomDestinationResult m4662performCustomEnterMxy_nc0(FocusTargetNode $this$performCustomEnter_u2dMxy_nc0, int focusDirection) {
        CustomDestinationResult customDestinationResult;
        FocusTargetNode this_$iv = $this$performCustomEnter_u2dMxy_nc0;
        if (!this_$iv.isProcessingCustomEnter) {
            this_$iv.isProcessingCustomEnter = true;
            try {
                FocusRequester it$iv = this_$iv.fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m4626boximpl(focusDirection));
                if (it$iv != FocusRequester.Companion.getDefault()) {
                    FocusRequester it = it$iv;
                    if (it == FocusRequester.Companion.getCancel()) {
                        customDestinationResult = CustomDestinationResult.Cancelled;
                    } else {
                        customDestinationResult = it.focus$ui_release() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                    }
                    return customDestinationResult;
                }
                this_$iv.isProcessingCustomEnter = false;
            } finally {
                this_$iv.isProcessingCustomEnter = false;
            }
        }
        return CustomDestinationResult.None;
    }

    /* renamed from: performCustomExit-Mxy_nc0  reason: not valid java name */
    private static final CustomDestinationResult m4663performCustomExitMxy_nc0(FocusTargetNode $this$performCustomExit_u2dMxy_nc0, int focusDirection) {
        CustomDestinationResult customDestinationResult;
        FocusTargetNode this_$iv = $this$performCustomExit_u2dMxy_nc0;
        if (!this_$iv.isProcessingCustomExit) {
            this_$iv.isProcessingCustomExit = true;
            try {
                FocusRequester it$iv = this_$iv.fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.m4626boximpl(focusDirection));
                if (it$iv != FocusRequester.Companion.getDefault()) {
                    FocusRequester it = it$iv;
                    if (it == FocusRequester.Companion.getCancel()) {
                        customDestinationResult = CustomDestinationResult.Cancelled;
                    } else {
                        customDestinationResult = it.focus$ui_release() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                    }
                    return customDestinationResult;
                }
                this_$iv.isProcessingCustomExit = false;
            } finally {
                this_$iv.isProcessingCustomExit = false;
            }
        }
        return CustomDestinationResult.None;
    }
}

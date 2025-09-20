package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0001H\u0000\u001a=\u0010\u0013\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0015H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"activeChild", "Landroidx/compose/ui/focus/FocusTargetNode;", "getActiveChild", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusTargetNode;", "isEligibleForFocusSearch", "", "(Landroidx/compose/ui/focus/FocusTargetNode;)Z", "customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "findActiveFocusNode", "findNonDeactivatedParent", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "focusSearch", "onFound", "Lkotlin/Function1;", "focusSearch-sMXa3k8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusTraversal.kt */
public final class FocusTraversalKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusTraversal.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* renamed from: customFocusSearch--OM-vw8  reason: not valid java name */
    public static final FocusRequester m2955customFocusSearchOMvw8(FocusTargetNode $this$customFocusSearch_u2d_u2dOM_u2dvw8, int focusDirection, LayoutDirection layoutDirection) {
        FocusRequester it;
        FocusRequester it2;
        Intrinsics.checkNotNullParameter($this$customFocusSearch_u2d_u2dOM_u2dvw8, "$this$customFocusSearch");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        FocusProperties focusProperties = $this$customFocusSearch_u2d_u2dOM_u2dvw8.fetchFocusProperties$ui_release();
        if (FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2932getNextdhqQ8s())) {
            return focusProperties.getNext();
        }
        if (FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2934getPreviousdhqQ8s())) {
            return focusProperties.getPrevious();
        }
        if (FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2936getUpdhqQ8s())) {
            return focusProperties.getUp();
        }
        if (FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2927getDowndhqQ8s())) {
            return focusProperties.getDown();
        }
        boolean z = true;
        if (FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2931getLeftdhqQ8s())) {
            switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
                case 1:
                    it2 = focusProperties.getStart();
                    break;
                case 2:
                    it2 = focusProperties.getEnd();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (it2 != FocusRequester.Companion.getDefault()) {
                z = false;
            }
            if (z) {
                it2 = null;
            }
            if (it2 == null) {
                return focusProperties.getLeft();
            }
            return it2;
        } else if (FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2935getRightdhqQ8s())) {
            switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
                case 1:
                    it = focusProperties.getEnd();
                    break;
                case 2:
                    it = focusProperties.getStart();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (it != FocusRequester.Companion.getDefault()) {
                z = false;
            }
            if (z) {
                it = null;
            }
            if (it == null) {
                return focusProperties.getRight();
            }
            return it;
        } else if (FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2928getEnterdhqQ8s())) {
            return focusProperties.getEnter().invoke(FocusDirection.m2916boximpl(focusDirection));
        } else {
            if (FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2929getExitdhqQ8s())) {
                return focusProperties.getExit().invoke(FocusDirection.m2916boximpl(focusDirection));
            }
            throw new IllegalStateException("invalid FocusDirection".toString());
        }
    }

    /* renamed from: focusSearch-sMXa3k8  reason: not valid java name */
    public static final boolean m2956focusSearchsMXa3k8(FocusTargetNode $this$focusSearch_u2dsMXa3k8, int focusDirection, LayoutDirection layoutDirection, Function1<? super FocusTargetNode, Boolean> onFound) {
        int direction;
        Boolean r2;
        Intrinsics.checkNotNullParameter($this$focusSearch_u2dsMXa3k8, "$this$focusSearch");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        boolean z = true;
        if (FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2932getNextdhqQ8s()) ? true : FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2934getPreviousdhqQ8s())) {
            return OneDimensionalFocusSearchKt.m2959oneDimensionalFocusSearchOMvw8($this$focusSearch_u2dsMXa3k8, focusDirection, onFound);
        }
        if (!(FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2931getLeftdhqQ8s()) ? true : FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2935getRightdhqQ8s()) ? true : FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2936getUpdhqQ8s()))) {
            z = FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2927getDowndhqQ8s());
        }
        if (z) {
            Boolean r1 = TwoDimensionalFocusSearchKt.m2968twoDimensionalFocusSearchOMvw8($this$focusSearch_u2dsMXa3k8, focusDirection, onFound);
            if (r1 != null) {
                return r1.booleanValue();
            }
            return false;
        } else if (FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2928getEnterdhqQ8s())) {
            switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
                case 1:
                    direction = FocusDirection.Companion.m2935getRightdhqQ8s();
                    break;
                case 2:
                    direction = FocusDirection.Companion.m2931getLeftdhqQ8s();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            FocusTargetNode findActiveFocusNode = findActiveFocusNode($this$focusSearch_u2dsMXa3k8);
            if (findActiveFocusNode == null || (r2 = TwoDimensionalFocusSearchKt.m2968twoDimensionalFocusSearchOMvw8(findActiveFocusNode, direction, onFound)) == null) {
                return false;
            }
            return r2.booleanValue();
        } else if (FocusDirection.m2919equalsimpl0(focusDirection, FocusDirection.Companion.m2929getExitdhqQ8s())) {
            FocusTargetNode findActiveFocusNode2 = findActiveFocusNode($this$focusSearch_u2dsMXa3k8);
            FocusTargetNode it = findActiveFocusNode2 != null ? findNonDeactivatedParent(findActiveFocusNode2) : null;
            if (it == null || Intrinsics.areEqual((Object) it, (Object) $this$focusSearch_u2dsMXa3k8)) {
                return false;
            }
            return onFound.invoke(it).booleanValue();
        } else {
            throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + FocusDirection.m2921toStringimpl(focusDirection)).toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = androidx.compose.ui.layout.LayoutCoordinatesKt.findRootCoordinates(r0).localBoundingBoxOf(r0, false);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.geometry.Rect focusRect(androidx.compose.ui.focus.FocusTargetNode r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            androidx.compose.ui.node.NodeCoordinator r0 = r5.getCoordinator$ui_release()
            if (r0 == 0) goto L_0x001d
            r1 = 0
            r2 = r0
            androidx.compose.ui.layout.LayoutCoordinates r2 = (androidx.compose.ui.layout.LayoutCoordinates) r2
            androidx.compose.ui.layout.LayoutCoordinates r2 = androidx.compose.ui.layout.LayoutCoordinatesKt.findRootCoordinates(r2)
            r3 = r0
            androidx.compose.ui.layout.LayoutCoordinates r3 = (androidx.compose.ui.layout.LayoutCoordinates) r3
            r4 = 0
            androidx.compose.ui.geometry.Rect r0 = r2.localBoundingBoxOf(r3, r4)
            if (r0 != 0) goto L_0x0023
        L_0x001d:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r0 = r0.getZero()
        L_0x0023:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.focusRect(androidx.compose.ui.focus.FocusTargetNode):androidx.compose.ui.geometry.Rect");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r0 = r0.getLayoutNode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isEligibleForFocusSearch(androidx.compose.ui.focus.FocusTargetNode r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            androidx.compose.ui.node.NodeCoordinator r0 = r3.getCoordinator$ui_release()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001b
            androidx.compose.ui.node.LayoutNode r0 = r0.getLayoutNode()
            if (r0 == 0) goto L_0x001b
            boolean r0 = r0.isPlaced()
            if (r0 != r1) goto L_0x001b
            r0 = r1
            goto L_0x001c
        L_0x001b:
            r0 = r2
        L_0x001c:
            if (r0 == 0) goto L_0x0036
            androidx.compose.ui.node.NodeCoordinator r0 = r3.getCoordinator$ui_release()
            if (r0 == 0) goto L_0x0032
            androidx.compose.ui.node.LayoutNode r0 = r0.getLayoutNode()
            if (r0 == 0) goto L_0x0032
            boolean r0 = r0.isAttached()
            if (r0 != r1) goto L_0x0032
            r0 = r1
            goto L_0x0033
        L_0x0032:
            r0 = r2
        L_0x0033:
            if (r0 == 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r1 = r2
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.isEligibleForFocusSearch(androidx.compose.ui.focus.FocusTargetNode):boolean");
    }

    public static final FocusTargetNode getActiveChild(FocusTargetNode $this$activeChild) {
        int type$iv;
        int type$iv2;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv;
        int type$iv3;
        int i;
        int type$iv4;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv2;
        MutableVector mutableVector;
        FocusTargetNode focusTargetNode = $this$activeChild;
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        if (!$this$activeChild.getNode().isAttached()) {
            return null;
        }
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv3 = focusTargetNode;
        int type$iv5 = NodeKind.m4956constructorimpl(1024);
        int mask$iv$iv = type$iv5;
        DelegatableNode $this$visitChildren$iv$iv = $this$visitChildren_u2d6rFNWt0$iv3;
        if ($this$visitChildren$iv$iv.getNode().isAttached()) {
            int count$iv$iv = false;
            MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$iv$iv = $this$visitChildren$iv$iv.getNode().getChild$ui_release();
            if (child$iv$iv == null) {
                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren$iv$iv.getNode());
            } else {
                branches$iv$iv.add(child$iv$iv);
            }
            while (branches$iv$iv.isNotEmpty()) {
                int i2 = 1;
                Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) == 0) {
                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                } else {
                    Modifier.Node node$iv$iv = branch$iv$iv;
                    while (true) {
                        if (node$iv$iv == null) {
                            int type$iv6 = type$iv;
                            int type$iv7 = count$iv$iv;
                            FocusTargetNode focusTargetNode2 = $this$activeChild;
                            type$iv5 = type$iv6;
                        } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            MutableVector mutableVector2 = null;
                            Modifier.Node this_$iv$iv$iv = node$iv$iv;
                            while (this_$iv$iv$iv != null) {
                                if (this_$iv$iv$iv instanceof FocusTargetNode) {
                                    FocusTargetNode it = (FocusTargetNode) this_$iv$iv$iv;
                                    switch (WhenMappings.$EnumSwitchMapping$1[it.getFocusState().ordinal()]) {
                                        case 1:
                                        case 2:
                                        case 3:
                                            return it;
                                        default:
                                            $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                            type$iv2 = type$iv;
                                            i = i2;
                                            type$iv3 = 0;
                                            break;
                                    }
                                } else {
                                    if (((this_$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? i2 : 0) == 0 || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                                        $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                        type$iv2 = type$iv;
                                        i = i2;
                                        type$iv3 = 0;
                                    } else {
                                        int count$iv$iv2 = 0;
                                        Modifier.Node node$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                                        while (node$iv$iv$iv != null) {
                                            Modifier.Node next$iv$iv = node$iv$iv$iv;
                                            if (((next$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? i2 : 0) != 0) {
                                                count$iv$iv2++;
                                                if (count$iv$iv2 == i2) {
                                                    this_$iv$iv$iv = next$iv$iv;
                                                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                    type$iv4 = type$iv;
                                                    Modifier.Node node = next$iv$iv;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                        type$iv4 = type$iv;
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                        type$iv4 = type$iv;
                                                        mutableVector = mutableVector2;
                                                    }
                                                    Modifier.Node theNode$iv$iv = this_$iv$iv$iv;
                                                    if (theNode$iv$iv != null) {
                                                        if (mutableVector != null) {
                                                            mutableVector.add(theNode$iv$iv);
                                                        }
                                                        this_$iv$iv$iv = null;
                                                    }
                                                    if (mutableVector != null) {
                                                        mutableVector.add(next$iv$iv);
                                                    }
                                                    mutableVector2 = mutableVector;
                                                }
                                            } else {
                                                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                type$iv4 = type$iv;
                                                Modifier.Node node2 = next$iv$iv;
                                            }
                                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                            FocusTargetNode focusTargetNode3 = $this$activeChild;
                                            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                                            type$iv = type$iv4;
                                            i2 = 1;
                                        }
                                        $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                        type$iv2 = type$iv;
                                        type$iv3 = 0;
                                        i = 1;
                                        if (count$iv$iv2 == 1) {
                                            i2 = 1;
                                            count$iv$iv = false;
                                            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                                            type$iv = type$iv2;
                                            FocusTargetNode focusTargetNode4 = $this$activeChild;
                                        }
                                    }
                                }
                                this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector2);
                                i2 = i;
                                count$iv$iv = type$iv3;
                                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                                type$iv = type$iv2;
                                FocusTargetNode focusTargetNode5 = $this$activeChild;
                            }
                            int type$iv8 = type$iv;
                            int type$iv9 = count$iv$iv;
                            FocusTargetNode focusTargetNode6 = $this$activeChild;
                            type$iv5 = type$iv8;
                        } else {
                            int type$iv10 = type$iv;
                            int type$iv11 = count$iv$iv;
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                            type$iv5 = type$iv10;
                            FocusTargetNode focusTargetNode7 = $this$activeChild;
                        }
                    }
                }
            }
            return null;
        }
        DelegatableNode delegatableNode = $this$visitChildren_u2d6rFNWt0$iv3;
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    public static final FocusTargetNode findActiveFocusNode(FocusTargetNode $this$findActiveFocusNode) {
        int i;
        int i2;
        int type$iv;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv;
        int i3;
        int i4;
        int i5;
        int type$iv2;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv2;
        MutableVector mutableVector;
        FocusTargetNode focusTargetNode = $this$findActiveFocusNode;
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[$this$findActiveFocusNode.getFocusState().ordinal()]) {
            case 1:
            case 3:
                return focusTargetNode;
            case 2:
                DelegatableNode $this$visitChildren_u2d6rFNWt0$iv3 = focusTargetNode;
                int type$iv3 = NodeKind.m4956constructorimpl(1024);
                int i6 = 0;
                int mask$iv$iv = type$iv3;
                DelegatableNode $this$visitChildren$iv$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                if ($this$visitChildren$iv$iv.getNode().isAttached()) {
                    int count$iv$iv = false;
                    MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                    Modifier.Node child$iv$iv = $this$visitChildren$iv$iv.getNode().getChild$ui_release();
                    if (child$iv$iv == null) {
                        DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren$iv$iv.getNode());
                    } else {
                        branches$iv$iv.add(child$iv$iv);
                    }
                    while (branches$iv$iv.isNotEmpty()) {
                        int i7 = 1;
                        Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                        if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) == 0) {
                            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                        } else {
                            Modifier.Node node$iv$iv = branch$iv$iv;
                            while (true) {
                                if (node$iv$iv == null) {
                                    int i8 = type$iv3;
                                    int i9 = i;
                                    int i10 = count$iv$iv;
                                    i6 = i9;
                                } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                                    MutableVector mutableVector2 = null;
                                    Modifier.Node this_$iv$iv$iv = node$iv$iv;
                                    while (this_$iv$iv$iv != null) {
                                        if (this_$iv$iv$iv instanceof FocusTargetNode) {
                                            FocusTargetNode it = findActiveFocusNode((FocusTargetNode) this_$iv$iv$iv);
                                            if (it != null) {
                                                return it;
                                            }
                                            $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                            type$iv = type$iv3;
                                            i2 = i;
                                            i4 = i7;
                                            i3 = 0;
                                        } else {
                                            if (((this_$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? i7 : 0) == 0 || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                                                $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                                type$iv = type$iv3;
                                                i2 = i;
                                                i4 = i7;
                                                i3 = 0;
                                            } else {
                                                int count$iv$iv2 = 0;
                                                Modifier.Node node$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                                                while (node$iv$iv$iv != null) {
                                                    Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                    if (((next$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? i7 : 0) != 0) {
                                                        count$iv$iv2++;
                                                        if (count$iv$iv2 == i7) {
                                                            this_$iv$iv$iv = next$iv$iv;
                                                            $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                            type$iv2 = type$iv3;
                                                            i5 = i;
                                                            Modifier.Node node = next$iv$iv;
                                                        } else {
                                                            if (mutableVector2 == null) {
                                                                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                                type$iv2 = type$iv3;
                                                                i5 = i;
                                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                            } else {
                                                                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                                type$iv2 = type$iv3;
                                                                i5 = i;
                                                                mutableVector = mutableVector2;
                                                            }
                                                            Modifier.Node theNode$iv$iv = this_$iv$iv$iv;
                                                            if (theNode$iv$iv != null) {
                                                                if (mutableVector != null) {
                                                                    mutableVector.add(theNode$iv$iv);
                                                                }
                                                                this_$iv$iv$iv = null;
                                                            }
                                                            if (mutableVector != null) {
                                                                mutableVector.add(next$iv$iv);
                                                            }
                                                            mutableVector2 = mutableVector;
                                                        }
                                                    } else {
                                                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                        type$iv2 = type$iv3;
                                                        i5 = i;
                                                        Modifier.Node node2 = next$iv$iv;
                                                    }
                                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                                    $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                                                    type$iv3 = type$iv2;
                                                    i = i5;
                                                    i7 = 1;
                                                }
                                                $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                                type$iv = type$iv3;
                                                i2 = i;
                                                i3 = 0;
                                                i4 = 1;
                                                if (count$iv$iv2 == 1) {
                                                    i7 = 1;
                                                    count$iv$iv = false;
                                                    $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                                                    type$iv3 = type$iv;
                                                    i = i2;
                                                }
                                            }
                                        }
                                        this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector2);
                                        i7 = i4;
                                        count$iv$iv = i3;
                                        $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                                        type$iv3 = type$iv;
                                        i = i2;
                                    }
                                    int i11 = type$iv3;
                                    int i12 = i;
                                    int i13 = count$iv$iv;
                                    i6 = i12;
                                } else {
                                    int i14 = type$iv3;
                                    int i15 = i;
                                    int i16 = count$iv$iv;
                                    node$iv$iv = node$iv$iv.getChild$ui_release();
                                    $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv3;
                                    i6 = i15;
                                }
                            }
                        }
                    }
                    return null;
                }
                DelegatableNode delegatableNode = $this$visitChildren_u2d6rFNWt0$iv3;
                throw new IllegalStateException("visitChildren called on an unattached node".toString());
            case 4:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final FocusTargetNode findNonDeactivatedParent(FocusTargetNode $this$findNonDeactivatedParent) {
        int i;
        boolean includeSelf$iv;
        int type$iv;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        NodeChain nodes$ui_release;
        int i2;
        boolean includeSelf$iv2;
        int type$iv2;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
        int i3;
        boolean includeSelf$iv3;
        int type$iv3;
        int i4;
        boolean includeSelf$iv4;
        int type$iv4;
        int count$iv$iv;
        MutableVector mutableVector;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3 = $this$findNonDeactivatedParent;
        int type$iv5 = NodeKind.m4956constructorimpl(1024);
        boolean includeSelf$iv5 = false;
        int i5 = 0;
        int mask$iv$iv = type$iv5;
        DelegatableNode $this$visitAncestors$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
        if ($this$visitAncestors$iv$iv.getNode().isAttached()) {
            Modifier.Node node$iv$iv = $this$visitAncestors$iv$iv.getNode().getParent$ui_release();
            LayoutNode layout$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv);
            while (layout$iv$iv != null) {
                if ((layout$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                    while (node$iv$iv != null) {
                        if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            MutableVector mutableVector2 = null;
                            Modifier.Node node = node$iv$iv;
                            while (node != null) {
                                DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                                if (node instanceof FocusTargetNode) {
                                    FocusTargetNode it = (FocusTargetNode) node;
                                    if (it.fetchFocusProperties$ui_release().getCanFocus()) {
                                        return it;
                                    }
                                    type$iv3 = type$iv2;
                                    includeSelf$iv3 = includeSelf$iv2;
                                    i3 = i2;
                                } else {
                                    Modifier.Node this_$iv$iv$iv = node;
                                    Modifier.Node node2 = this_$iv$iv$iv;
                                    if (((this_$iv$iv$iv.getKindSet$ui_release() & type$iv2) != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                        type$iv3 = type$iv2;
                                        includeSelf$iv3 = includeSelf$iv2;
                                        i3 = i2;
                                    } else {
                                        int count$iv$iv2 = 0;
                                        Modifier.Node node$iv$iv$iv = ((DelegatingNode) node).getDelegate$ui_release();
                                        while (node$iv$iv$iv != null) {
                                            Modifier.Node next$iv$iv = node$iv$iv$iv;
                                            if ((next$iv$iv.getKindSet$ui_release() & type$iv2) != 0) {
                                                count$iv$iv2++;
                                                type$iv4 = type$iv2;
                                                if (count$iv$iv2 == 1) {
                                                    node = next$iv$iv;
                                                    includeSelf$iv4 = includeSelf$iv2;
                                                    i4 = i2;
                                                    Modifier.Node node3 = next$iv$iv;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        count$iv$iv = count$iv$iv2;
                                                        includeSelf$iv4 = includeSelf$iv2;
                                                        i4 = i2;
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        count$iv$iv = count$iv$iv2;
                                                        includeSelf$iv4 = includeSelf$iv2;
                                                        i4 = i2;
                                                        mutableVector = mutableVector2;
                                                    }
                                                    mutableVector2 = mutableVector;
                                                    Modifier.Node theNode$iv$iv = node;
                                                    if (theNode$iv$iv != null) {
                                                        if (mutableVector2 != null) {
                                                            mutableVector2.add(theNode$iv$iv);
                                                        }
                                                        node = null;
                                                    }
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(next$iv$iv);
                                                    }
                                                    count$iv$iv2 = count$iv$iv;
                                                }
                                            } else {
                                                type$iv4 = type$iv2;
                                                includeSelf$iv4 = includeSelf$iv2;
                                                i4 = i2;
                                                Modifier.Node node4 = next$iv$iv;
                                            }
                                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                            type$iv2 = type$iv4;
                                            includeSelf$iv2 = includeSelf$iv4;
                                            i2 = i4;
                                        }
                                        type$iv3 = type$iv2;
                                        includeSelf$iv3 = includeSelf$iv2;
                                        i3 = i2;
                                        if (count$iv$iv2 == 1) {
                                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4;
                                            type$iv2 = type$iv3;
                                            includeSelf$iv2 = includeSelf$iv3;
                                            i2 = i3;
                                        }
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector2);
                                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4;
                                type$iv2 = type$iv3;
                                includeSelf$iv2 = includeSelf$iv3;
                                i2 = i3;
                            }
                            continue;
                        }
                        node$iv$iv = node$iv$iv.getParent$ui_release();
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        type$iv5 = type$iv2;
                        includeSelf$iv5 = includeSelf$iv2;
                        i5 = i2;
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    type$iv = type$iv2;
                    includeSelf$iv = includeSelf$iv2;
                    i = i2;
                } else {
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
                    type$iv = type$iv5;
                    includeSelf$iv = includeSelf$iv5;
                    i = i5;
                }
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                node$iv$iv = (layout$iv$iv == null || (nodes$ui_release = layout$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                type$iv5 = type$iv;
                includeSelf$iv5 = includeSelf$iv;
                i5 = i;
            }
            return null;
        }
        DelegatableNode delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
        int i6 = type$iv5;
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }
}

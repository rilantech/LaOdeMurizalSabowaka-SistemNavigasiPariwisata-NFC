package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u001a5\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a5\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u000f\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0016H\u0002\u001a\f\u0010\u0017\u001a\u00020\t*\u00020\tH\u0002\u001a\u001a\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cH\u0002\u001a1\u0010\u001d\u001a\u0004\u0018\u00010\u0016*\b\u0012\u0004\u0012\u00020\u00160\u001c2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001a5\u0010!\u001a\u00020\u0007*\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070#H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001a=\u0010&\u001a\u00020\u0007*\u00020\u00162\u0006\u0010'\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070#H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001a=\u0010*\u001a\u00020\u0007*\u00020\u00162\u0006\u0010'\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070#H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010)\u001a\f\u0010,\u001a\u00020\t*\u00020\tH\u0002\u001a7\u0010-\u001a\u0004\u0018\u00010\u0007*\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070#H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/\"\u0014\u0010\u0000\u001a\u00020\u0001XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"InvalidFocusDirection", "", "getInvalidFocusDirection$annotations", "()V", "NoActiveChild", "getNoActiveChild$annotations", "beamBeats", "", "source", "Landroidx/compose/ui/geometry/Rect;", "rect1", "rect2", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "beamBeats-I7lrPNg", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;I)Z", "isBetterCandidate", "proposedCandidate", "currentCandidate", "focusedRect", "isBetterCandidate-I7lrPNg", "activeNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "bottomRight", "collectAccessibleChildren", "", "Landroidx/compose/ui/node/DelegatableNode;", "accessibleChildren", "Landroidx/compose/runtime/collection/MutableVector;", "findBestCandidate", "focusRect", "findBestCandidate-4WY_MpI", "(Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/geometry/Rect;I)Landroidx/compose/ui/focus/FocusTargetNode;", "findChildCorrespondingToFocusEnter", "onFound", "Lkotlin/Function1;", "findChildCorrespondingToFocusEnter--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "generateAndSearchChildren", "focusedItem", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "searchChildren", "searchChildren-4C6V_qg", "topLeft", "twoDimensionalFocusSearch", "twoDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TwoDimensionalFocusSearch.kt */
public final class TwoDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 2-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TwoDimensionalFocusSearch.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 2;
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

    private static /* synthetic */ void getInvalidFocusDirection$annotations() {
    }

    private static /* synthetic */ void getNoActiveChild$annotations() {
    }

    /* renamed from: twoDimensionalFocusSearch--OM-vw8  reason: not valid java name */
    public static final Boolean m4678twoDimensionalFocusSearchOMvw8(FocusTargetNode $this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8, int direction, Function1<? super FocusTargetNode, Boolean> onFound) {
        Intrinsics.checkNotNullParameter($this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8, "$this$twoDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8.getFocusState().ordinal()]) {
            case 1:
                FocusTargetNode focusedChild = FocusTraversalKt.getActiveChild($this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8);
                if (focusedChild != null) {
                    switch (WhenMappings.$EnumSwitchMapping$0[focusedChild.getFocusState().ordinal()]) {
                        case 1:
                            Boolean found = m4678twoDimensionalFocusSearchOMvw8(focusedChild, direction, onFound);
                            if (!Intrinsics.areEqual((Object) found, (Object) false)) {
                                return found;
                            }
                            return Boolean.valueOf(m4675generateAndSearchChildren4C6V_qg($this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8, activeNode(focusedChild), direction, onFound));
                        case 2:
                        case 3:
                            return Boolean.valueOf(m4675generateAndSearchChildren4C6V_qg($this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8, focusedChild, direction, onFound));
                        case 4:
                            throw new IllegalStateException(NoActiveChild.toString());
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                } else {
                    throw new IllegalStateException(NoActiveChild.toString());
                }
            case 2:
            case 3:
                return Boolean.valueOf(m4674findChildCorrespondingToFocusEnterOMvw8($this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8, direction, onFound));
            case 4:
                if ($this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8.fetchFocusProperties$ui_release().getCanFocus()) {
                    return onFound.invoke($this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8);
                }
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: androidx.compose.ui.focus.FocusTargetNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: androidx.compose.ui.focus.FocusTargetNode} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: findChildCorrespondingToFocusEnter--OM-vw8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean m4674findChildCorrespondingToFocusEnterOMvw8(androidx.compose.ui.focus.FocusTargetNode r8, int r9, kotlin.jvm.functions.Function1<? super androidx.compose.ui.focus.FocusTargetNode, java.lang.Boolean> r10) {
        /*
            java.lang.String r0 = "$this$findChildCorrespondingToFocusEnter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "onFound"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 16
            r1 = 0
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.focus.FocusTargetNode[] r3 = new androidx.compose.ui.focus.FocusTargetNode[r0]
            r4 = 0
            r2.<init>(r3, r4)
            r0 = r2
            r1 = r8
            androidx.compose.ui.node.DelegatableNode r1 = (androidx.compose.ui.node.DelegatableNode) r1
            collectAccessibleChildren(r1, r0)
            int r1 = r0.getSize()
            r2 = 1
            if (r1 > r2) goto L_0x004b
            r1 = r0
            r2 = 0
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L_0x002f
            r3 = 0
            goto L_0x0039
        L_0x002f:
            r3 = 0
            r5 = r1
            r6 = 0
            java.lang.Object[] r7 = r5.getContent()
            r7 = r7[r3]
            r3 = r7
        L_0x0039:
            androidx.compose.ui.focus.FocusTargetNode r3 = (androidx.compose.ui.focus.FocusTargetNode) r3
            if (r3 == 0) goto L_0x004a
            r1 = r3
            r2 = 0
            java.lang.Object r3 = r10.invoke(r1)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r4 = r3.booleanValue()
        L_0x004a:
            return r4
        L_0x004b:
            androidx.compose.ui.focus.FocusDirection$Companion r1 = androidx.compose.ui.focus.FocusDirection.Companion
            int r1 = r1.m4638getEnterdhqQ8s()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.m4629equalsimpl0(r9, r1)
            if (r1 == 0) goto L_0x0060
            androidx.compose.ui.focus.FocusDirection$Companion r1 = androidx.compose.ui.focus.FocusDirection.Companion
            int r1 = r1.m4645getRightdhqQ8s()
            goto L_0x0061
        L_0x0060:
            r1 = r9
        L_0x0061:
            androidx.compose.ui.focus.FocusDirection$Companion r3 = androidx.compose.ui.focus.FocusDirection.Companion
            int r3 = r3.m4645getRightdhqQ8s()
            boolean r3 = androidx.compose.ui.focus.FocusDirection.m4629equalsimpl0(r1, r3)
            if (r3 == 0) goto L_0x0071
            r3 = r2
            goto L_0x007b
        L_0x0071:
            androidx.compose.ui.focus.FocusDirection$Companion r3 = androidx.compose.ui.focus.FocusDirection.Companion
            int r3 = r3.m4637getDowndhqQ8s()
            boolean r3 = androidx.compose.ui.focus.FocusDirection.m4629equalsimpl0(r1, r3)
        L_0x007b:
            if (r3 == 0) goto L_0x0086
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.ui.focus.FocusTraversalKt.focusRect(r8)
            androidx.compose.ui.geometry.Rect r2 = topLeft(r2)
            goto L_0x00a7
        L_0x0086:
            androidx.compose.ui.focus.FocusDirection$Companion r3 = androidx.compose.ui.focus.FocusDirection.Companion
            int r3 = r3.m4641getLeftdhqQ8s()
            boolean r3 = androidx.compose.ui.focus.FocusDirection.m4629equalsimpl0(r1, r3)
            if (r3 == 0) goto L_0x0093
            goto L_0x009d
        L_0x0093:
            androidx.compose.ui.focus.FocusDirection$Companion r2 = androidx.compose.ui.focus.FocusDirection.Companion
            int r2 = r2.m4646getUpdhqQ8s()
            boolean r2 = androidx.compose.ui.focus.FocusDirection.m4629equalsimpl0(r1, r2)
        L_0x009d:
            if (r2 == 0) goto L_0x00bb
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.ui.focus.FocusTraversalKt.focusRect(r8)
            androidx.compose.ui.geometry.Rect r2 = bottomRight(r2)
        L_0x00a7:
            androidx.compose.ui.focus.FocusTargetNode r3 = m4673findBestCandidate4WY_MpI(r0, r2, r1)
            if (r3 == 0) goto L_0x00ba
            r4 = r3
            r5 = 0
            java.lang.Object r6 = r10.invoke(r4)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r4 = r6.booleanValue()
        L_0x00ba:
            return r4
        L_0x00bb:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "This function should only be used for 2-D focus search"
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt.m4674findChildCorrespondingToFocusEnterOMvw8(androidx.compose.ui.focus.FocusTargetNode, int, kotlin.jvm.functions.Function1):boolean");
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg  reason: not valid java name */
    private static final boolean m4675generateAndSearchChildren4C6V_qg(FocusTargetNode $this$generateAndSearchChildren_u2d4C6V_qg, FocusTargetNode focusedItem, int direction, Function1<? super FocusTargetNode, Boolean> onFound) {
        if (m4677searchChildren4C6V_qg($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, onFound)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m4625searchBeyondBoundsOMvw8($this$generateAndSearchChildren_u2d4C6V_qg, direction, new TwoDimensionalFocusSearchKt$generateAndSearchChildren$1($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, onFound));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg  reason: not valid java name */
    public static final boolean m4677searchChildren4C6V_qg(FocusTargetNode $this$searchChildren_u2d4C6V_qg, FocusTargetNode focusedItem, int direction, Function1<? super FocusTargetNode, Boolean> onFound) {
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv;
        MutableVector branches$iv$iv;
        MutableVector $this$searchChildren_4C6V_qg_u24lambda_u243;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv2;
        MutableVector branches$iv$iv2;
        MutableVector $this$searchChildren_4C6V_qg_u24lambda_u2432;
        MutableVector branches$iv$iv3;
        int i = direction;
        Function1<? super FocusTargetNode, Boolean> function1 = onFound;
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        MutableVector $this$searchChildren_4C6V_qg_u24lambda_u2433 = mutableVector;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv3 = $this$searchChildren_u2d4C6V_qg;
        int type$iv = NodeKind.m6666constructorimpl(1024);
        int mask$iv$iv = type$iv;
        DelegatableNode $this$visitChildren$iv$iv = $this$visitChildren_u2d6rFNWt0$iv3;
        if ($this$visitChildren$iv$iv.getNode().isAttached()) {
            MutableVector branches$iv$iv4 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$iv$iv = $this$visitChildren$iv$iv.getNode().getChild$ui_release();
            if (child$iv$iv == null) {
                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv4, $this$visitChildren$iv$iv.getNode());
            } else {
                branches$iv$iv4.add(child$iv$iv);
            }
            while (branches$iv$iv4.isNotEmpty()) {
                Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv4.removeAt(branches$iv$iv4.getSize() - 1);
                if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                    Modifier.Node node$iv$iv = branch$iv$iv;
                    while (true) {
                        if (node$iv$iv == null) {
                            MutableVector mutableVector2 = branches$iv$iv4;
                            DelegatableNode delegatableNode = $this$visitChildren_u2d6rFNWt0$iv3;
                            break;
                        } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            MutableVector mutableVector3 = null;
                            Modifier.Node this_$iv$iv$iv = node$iv$iv;
                            while (this_$iv$iv$iv != null) {
                                if (this_$iv$iv$iv instanceof FocusTargetNode) {
                                    $this$searchChildren_4C6V_qg_u24lambda_u2433.add((FocusTargetNode) this_$iv$iv$iv);
                                    $this$searchChildren_4C6V_qg_u24lambda_u243 = $this$searchChildren_4C6V_qg_u24lambda_u2433;
                                    branches$iv$iv = branches$iv$iv4;
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                } else {
                                    if (!((this_$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0) || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                                        $this$searchChildren_4C6V_qg_u24lambda_u243 = $this$searchChildren_4C6V_qg_u24lambda_u2433;
                                        branches$iv$iv = branches$iv$iv4;
                                        $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                    } else {
                                        int count$iv$iv = 0;
                                        Modifier.Node node$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                                        while (node$iv$iv$iv != null) {
                                            DelegatableNode next$iv$iv = node$iv$iv$iv;
                                            if ((next$iv$iv.getKindSet$ui_release() & type$iv) != 0) {
                                                count$iv$iv++;
                                                $this$searchChildren_4C6V_qg_u24lambda_u2432 = $this$searchChildren_4C6V_qg_u24lambda_u2433;
                                                if (count$iv$iv == 1) {
                                                    this_$iv$iv$iv = next$iv$iv;
                                                    branches$iv$iv2 = branches$iv$iv4;
                                                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                    DelegatableNode $this$visitChildren_u2d6rFNWt0$iv4 = next$iv$iv;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        branches$iv$iv2 = branches$iv$iv4;
                                                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                        branches$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        branches$iv$iv2 = branches$iv$iv4;
                                                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                        branches$iv$iv3 = mutableVector3;
                                                    }
                                                    MutableVector mutableVector4 = branches$iv$iv3;
                                                    Modifier.Node theNode$iv$iv = this_$iv$iv$iv;
                                                    if (theNode$iv$iv != null) {
                                                        if (mutableVector4 != null) {
                                                            mutableVector4.add(theNode$iv$iv);
                                                        }
                                                        this_$iv$iv$iv = null;
                                                    }
                                                    if (mutableVector4 != null) {
                                                        mutableVector4.add(next$iv$iv);
                                                    }
                                                    mutableVector3 = mutableVector4;
                                                }
                                            } else {
                                                $this$searchChildren_4C6V_qg_u24lambda_u2432 = $this$searchChildren_4C6V_qg_u24lambda_u2433;
                                                branches$iv$iv2 = branches$iv$iv4;
                                                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                DelegatableNode $this$visitChildren_u2d6rFNWt0$iv5 = next$iv$iv;
                                            }
                                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                            $this$searchChildren_4C6V_qg_u24lambda_u2433 = $this$searchChildren_4C6V_qg_u24lambda_u2432;
                                            branches$iv$iv4 = branches$iv$iv2;
                                            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                                        }
                                        $this$searchChildren_4C6V_qg_u24lambda_u243 = $this$searchChildren_4C6V_qg_u24lambda_u2433;
                                        branches$iv$iv = branches$iv$iv4;
                                        $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                        if (count$iv$iv == 1) {
                                            $this$searchChildren_4C6V_qg_u24lambda_u2433 = $this$searchChildren_4C6V_qg_u24lambda_u243;
                                            branches$iv$iv4 = branches$iv$iv;
                                            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                                        }
                                    }
                                }
                                this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector3);
                                $this$searchChildren_4C6V_qg_u24lambda_u2433 = $this$searchChildren_4C6V_qg_u24lambda_u243;
                                branches$iv$iv4 = branches$iv$iv;
                                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                            }
                            MutableVector mutableVector5 = branches$iv$iv4;
                            DelegatableNode delegatableNode2 = $this$visitChildren_u2d6rFNWt0$iv3;
                        } else {
                            MutableVector mutableVector6 = branches$iv$iv4;
                            DelegatableNode delegatableNode3 = $this$visitChildren_u2d6rFNWt0$iv3;
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                        }
                    }
                } else {
                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv4, branch$iv$iv);
                }
            }
            MutableVector mutableVector7 = branches$iv$iv4;
            DelegatableNode delegatableNode4 = $this$visitChildren_u2d6rFNWt0$iv3;
            MutableVector children = mutableVector;
            while (children.isNotEmpty()) {
                FocusTargetNode nextItem = m4673findBestCandidate4WY_MpI(children, FocusTraversalKt.focusRect(focusedItem), i);
                if (nextItem == null) {
                    return false;
                }
                if (nextItem.fetchFocusProperties$ui_release().getCanFocus()) {
                    return function1.invoke(nextItem).booleanValue();
                }
                if (m4675generateAndSearchChildren4C6V_qg(nextItem, focusedItem, i, function1)) {
                    return true;
                }
                children.remove(nextItem);
            }
            FocusTargetNode focusTargetNode = focusedItem;
            return false;
        }
        MutableVector mutableVector8 = $this$searchChildren_4C6V_qg_u24lambda_u2433;
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    private static final void collectAccessibleChildren(DelegatableNode $this$collectAccessibleChildren, MutableVector<FocusTargetNode> accessibleChildren) {
        MutableVector<FocusTargetNode> mutableVector;
        int type$iv;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv;
        boolean z;
        int type$iv2;
        int count$iv$iv;
        MutableVector mutableVector2;
        MutableVector<FocusTargetNode> mutableVector3 = accessibleChildren;
        int type$iv3 = NodeKind.m6666constructorimpl(1024);
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv2 = $this$collectAccessibleChildren;
        int mask$iv$iv = type$iv3;
        DelegatableNode $this$visitChildren$iv$iv = $this$visitChildren_u2d6rFNWt0$iv2;
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
                if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                    Modifier.Node node$iv$iv = branch$iv$iv;
                    while (true) {
                        if (node$iv$iv == null) {
                            DelegatableNode delegatableNode = $this$visitChildren_u2d6rFNWt0$iv2;
                            mutableVector3 = accessibleChildren;
                            break;
                        } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            MutableVector mutableVector4 = null;
                            Modifier.Node this_$iv$iv$iv = node$iv$iv;
                            while (this_$iv$iv$iv != null) {
                                if (this_$iv$iv$iv instanceof FocusTargetNode) {
                                    FocusTargetNode it = (FocusTargetNode) this_$iv$iv$iv;
                                    if (!it.isAttached()) {
                                        $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                                    } else if (it.fetchFocusProperties$ui_release().getCanFocus()) {
                                        mutableVector.add(it);
                                        $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                                    } else {
                                        $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                                        collectAccessibleChildren(it, mutableVector);
                                    }
                                    type$iv = type$iv3;
                                    z = true;
                                } else {
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                                    if (!((this_$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0) || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                                        type$iv = type$iv3;
                                        z = true;
                                    } else {
                                        int count$iv$iv2 = 0;
                                        Modifier.Node node$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                                        while (node$iv$iv$iv != null) {
                                            Modifier.Node next$iv$iv = node$iv$iv$iv;
                                            if ((next$iv$iv.getKindSet$ui_release() & type$iv3) != 0) {
                                                count$iv$iv2++;
                                                if (count$iv$iv2 == 1) {
                                                    this_$iv$iv$iv = next$iv$iv;
                                                    type$iv2 = type$iv3;
                                                    Modifier.Node node = next$iv$iv;
                                                } else {
                                                    if (mutableVector4 == null) {
                                                        type$iv2 = type$iv3;
                                                        count$iv$iv = count$iv$iv2;
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        type$iv2 = type$iv3;
                                                        count$iv$iv = count$iv$iv2;
                                                        mutableVector2 = mutableVector4;
                                                    }
                                                    Modifier.Node theNode$iv$iv = this_$iv$iv$iv;
                                                    if (theNode$iv$iv != null) {
                                                        if (mutableVector2 != null) {
                                                            mutableVector2.add(theNode$iv$iv);
                                                        }
                                                        this_$iv$iv$iv = null;
                                                    }
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(next$iv$iv);
                                                    }
                                                    mutableVector4 = mutableVector2;
                                                    count$iv$iv2 = count$iv$iv;
                                                }
                                            } else {
                                                type$iv2 = type$iv3;
                                                Modifier.Node node2 = next$iv$iv;
                                            }
                                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                            MutableVector<FocusTargetNode> mutableVector5 = accessibleChildren;
                                            type$iv3 = type$iv2;
                                        }
                                        type$iv = type$iv3;
                                        z = true;
                                        if (count$iv$iv2 == 1) {
                                            $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                                            type$iv3 = type$iv;
                                            mutableVector = accessibleChildren;
                                        }
                                    }
                                }
                                this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector4);
                                boolean z2 = z;
                                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                                type$iv3 = type$iv;
                                mutableVector = accessibleChildren;
                            }
                            DelegatableNode delegatableNode2 = $this$visitChildren_u2d6rFNWt0$iv2;
                            mutableVector3 = accessibleChildren;
                        } else {
                            DelegatableNode delegatableNode3 = $this$visitChildren_u2d6rFNWt0$iv2;
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                            mutableVector3 = accessibleChildren;
                        }
                    }
                } else {
                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                }
            }
            return;
        }
        int i = type$iv3;
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    /* renamed from: findBestCandidate-4WY_MpI  reason: not valid java name */
    private static final FocusTargetNode m4673findBestCandidate4WY_MpI(MutableVector<FocusTargetNode> $this$findBestCandidate_u2d4WY_MpI, Rect focusRect, int direction) {
        Rect rect;
        if (FocusDirection.m4629equalsimpl0(direction, FocusDirection.Companion.m4641getLeftdhqQ8s())) {
            rect = focusRect.translate(focusRect.getWidth() + ((float) 1), 0.0f);
        } else if (FocusDirection.m4629equalsimpl0(direction, FocusDirection.Companion.m4645getRightdhqQ8s())) {
            rect = focusRect.translate(-(focusRect.getWidth() + ((float) 1)), 0.0f);
        } else if (FocusDirection.m4629equalsimpl0(direction, FocusDirection.Companion.m4646getUpdhqQ8s())) {
            rect = focusRect.translate(0.0f, focusRect.getHeight() + ((float) 1));
        } else if (FocusDirection.m4629equalsimpl0(direction, FocusDirection.Companion.m4637getDowndhqQ8s())) {
            rect = focusRect.translate(0.0f, -(focusRect.getHeight() + ((float) 1)));
        } else {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        }
        Rect rect2 = rect;
        FocusTargetNode focusTargetNode = null;
        MutableVector this_$iv = $this$findBestCandidate_u2d4WY_MpI;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                FocusTargetNode candidateNode = (FocusTargetNode) content$iv[i$iv];
                if (FocusTraversalKt.isEligibleForFocusSearch(candidateNode)) {
                    Rect candidateRect = FocusTraversalKt.focusRect(candidateNode);
                    if (m4676isBetterCandidateI7lrPNg(candidateRect, rect2, focusRect, direction)) {
                        rect2 = candidateRect;
                        focusTargetNode = candidateNode;
                    }
                }
                i$iv++;
            } while (i$iv < size$iv);
        }
        return focusTargetNode;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect $this$isBetterCandidate_I7lrPNg_u24isCandidate, int $direction, Rect $focusedRect) {
        if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4641getLeftdhqQ8s())) {
            return ($focusedRect.getRight() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getRight() || $focusedRect.getLeft() >= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getRight()) && $focusedRect.getLeft() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getLeft();
        }
        if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4645getRightdhqQ8s())) {
            if (($focusedRect.getLeft() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getLeft() || $focusedRect.getRight() <= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getLeft()) && $focusedRect.getRight() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getRight()) {
                return true;
            }
            return false;
        } else if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4646getUpdhqQ8s())) {
            if (($focusedRect.getBottom() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getBottom() || $focusedRect.getTop() >= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getBottom()) && $focusedRect.getTop() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getTop()) {
                return true;
            }
            return false;
        } else if (!FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4637getDowndhqQ8s())) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        } else if (($focusedRect.getTop() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getTop() || $focusedRect.getBottom() <= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getTop()) && $focusedRect.getBottom() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getBottom()) {
            return true;
        } else {
            return false;
        }
    }

    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(Rect $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance, int $direction, Rect $focusedRect) {
        float majorAxisDistance;
        if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4641getLeftdhqQ8s())) {
            majorAxisDistance = $focusedRect.getLeft() - $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getRight();
        } else if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4645getRightdhqQ8s())) {
            majorAxisDistance = $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getLeft() - $focusedRect.getRight();
        } else if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4646getUpdhqQ8s())) {
            majorAxisDistance = $focusedRect.getTop() - $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getBottom();
        } else if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4637getDowndhqQ8s())) {
            majorAxisDistance = $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getTop() - $focusedRect.getBottom();
        } else {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        }
        return Math.max(0.0f, majorAxisDistance);
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect $this$isBetterCandidate_I7lrPNg_u24minorAxisDistance, int $direction, Rect $focusedRect) {
        boolean z = true;
        if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4641getLeftdhqQ8s()) ? true : FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4645getRightdhqQ8s())) {
            float f = (float) 2;
            return ($focusedRect.getTop() + ($focusedRect.getHeight() / f)) - ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getTop() + ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getHeight() / f));
        }
        if (!FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4646getUpdhqQ8s())) {
            z = FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4637getDowndhqQ8s());
        }
        if (z) {
            float f2 = (float) 2;
            return ($focusedRect.getLeft() + ($focusedRect.getWidth() / f2)) - ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getLeft() + ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getWidth() / f2));
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int $direction, Rect $focusedRect, Rect candidate) {
        long majorAxisDistance = (long) Math.abs(isBetterCandidate_I7lrPNg$majorAxisDistance(candidate, $direction, $focusedRect));
        long minorAxisDistance = (long) Math.abs(isBetterCandidate_I7lrPNg$minorAxisDistance(candidate, $direction, $focusedRect));
        return (((long) 13) * majorAxisDistance * majorAxisDistance) + (minorAxisDistance * minorAxisDistance);
    }

    /* renamed from: isBetterCandidate-I7lrPNg  reason: not valid java name */
    private static final boolean m4676isBetterCandidateI7lrPNg(Rect proposedCandidate, Rect currentCandidate, Rect focusedRect, int direction) {
        if (!isBetterCandidate_I7lrPNg$isCandidate(proposedCandidate, direction, focusedRect)) {
            return false;
        }
        if (!isBetterCandidate_I7lrPNg$isCandidate(currentCandidate, direction, focusedRect)) {
            return true;
        }
        if (m4672beamBeatsI7lrPNg(focusedRect, proposedCandidate, currentCandidate, direction)) {
            return true;
        }
        if (!m4672beamBeatsI7lrPNg(focusedRect, currentCandidate, proposedCandidate, direction) && isBetterCandidate_I7lrPNg$weightedDistance(direction, focusedRect, proposedCandidate) < isBetterCandidate_I7lrPNg$weightedDistance(direction, focusedRect, currentCandidate)) {
            return true;
        }
        return false;
    }

    private static final boolean beamBeats_I7lrPNg$inSourceBeam(Rect $this$beamBeats_I7lrPNg_u24inSourceBeam, int $direction, Rect $source) {
        if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4641getLeftdhqQ8s()) ? true : FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4645getRightdhqQ8s())) {
            return $this$beamBeats_I7lrPNg_u24inSourceBeam.getBottom() > $source.getTop() && $this$beamBeats_I7lrPNg_u24inSourceBeam.getTop() < $source.getBottom();
        }
        if (!(FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4646getUpdhqQ8s()) ? true : FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4637getDowndhqQ8s()))) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        } else if ($this$beamBeats_I7lrPNg_u24inSourceBeam.getRight() <= $source.getLeft() || $this$beamBeats_I7lrPNg_u24inSourceBeam.getLeft() >= $source.getRight()) {
            return false;
        } else {
            return true;
        }
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch, int $direction, Rect $source) {
        if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4641getLeftdhqQ8s())) {
            return $source.getLeft() >= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getRight();
        }
        if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4645getRightdhqQ8s())) {
            if ($source.getRight() <= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getLeft()) {
                return true;
            }
            return false;
        } else if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4646getUpdhqQ8s())) {
            if ($source.getTop() >= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getBottom()) {
                return true;
            }
            return false;
        } else if (!FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4637getDowndhqQ8s())) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        } else if ($source.getBottom() <= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getTop()) {
            return true;
        } else {
            return false;
        }
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistance$6(Rect $this$beamBeats_I7lrPNg_u24majorAxisDistance_u246, int $direction, Rect $source) {
        float majorAxisDistance;
        if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4641getLeftdhqQ8s())) {
            majorAxisDistance = $source.getLeft() - $this$beamBeats_I7lrPNg_u24majorAxisDistance_u246.getRight();
        } else if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4645getRightdhqQ8s())) {
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistance_u246.getLeft() - $source.getRight();
        } else if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4646getUpdhqQ8s())) {
            majorAxisDistance = $source.getTop() - $this$beamBeats_I7lrPNg_u24majorAxisDistance_u246.getBottom();
        } else if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4637getDowndhqQ8s())) {
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistance_u246.getTop() - $source.getBottom();
        } else {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        }
        return Math.max(0.0f, majorAxisDistance);
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(Rect $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge, int $direction, Rect $source) {
        float majorAxisDistance;
        if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4641getLeftdhqQ8s())) {
            majorAxisDistance = $source.getLeft() - $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getLeft();
        } else if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4645getRightdhqQ8s())) {
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getRight() - $source.getRight();
        } else if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4646getUpdhqQ8s())) {
            majorAxisDistance = $source.getTop() - $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getTop();
        } else if (FocusDirection.m4629equalsimpl0($direction, FocusDirection.Companion.m4637getDowndhqQ8s())) {
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getBottom() - $source.getBottom();
        } else {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        }
        return Math.max(1.0f, majorAxisDistance);
    }

    /* renamed from: beamBeats-I7lrPNg  reason: not valid java name */
    private static final boolean m4672beamBeatsI7lrPNg(Rect source, Rect rect1, Rect rect2, int direction) {
        if (beamBeats_I7lrPNg$inSourceBeam(rect2, direction, source) || !beamBeats_I7lrPNg$inSourceBeam(rect1, direction, source)) {
            return false;
        }
        if (!beamBeats_I7lrPNg$isInDirectionOfSearch(rect2, direction, source)) {
            return true;
        }
        if (FocusDirection.m4629equalsimpl0(direction, FocusDirection.Companion.m4641getLeftdhqQ8s()) || FocusDirection.m4629equalsimpl0(direction, FocusDirection.Companion.m4645getRightdhqQ8s())) {
            return true;
        }
        if (beamBeats_I7lrPNg$majorAxisDistance$6(rect1, direction, source) < beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(rect2, direction, source)) {
            return true;
        }
        return false;
    }

    private static final Rect topLeft(Rect $this$topLeft) {
        return new Rect($this$topLeft.getLeft(), $this$topLeft.getTop(), $this$topLeft.getLeft(), $this$topLeft.getTop());
    }

    private static final Rect bottomRight(Rect $this$bottomRight) {
        return new Rect($this$bottomRight.getRight(), $this$bottomRight.getBottom(), $this$bottomRight.getRight(), $this$bottomRight.getBottom());
    }

    private static final FocusTargetNode activeNode(FocusTargetNode $this$activeNode) {
        if ($this$activeNode.getFocusState() == FocusStateImpl.ActiveParent) {
            FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode($this$activeNode);
            if (findActiveFocusNode != null) {
                return findActiveFocusNode;
            }
            throw new IllegalStateException(NoActiveChild.toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}

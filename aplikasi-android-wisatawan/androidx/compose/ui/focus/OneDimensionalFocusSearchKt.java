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
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a \u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001aE\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u000f\u001a\u0002H\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\f0\nH\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u0011\u001aE\u0010\u0012\u001a\u00020\f\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u000f\u001a\u0002H\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\f0\nH\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u0011\u001a \u0010\u0013\u001a\u00020\u0007*\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001a=\u0010\u0014\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u0007*\u00020\bH\u0002\u001a5\u0010\u001b\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a \u0010\u001e\u001a\u00020\u0007*\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001a \u0010\u001f\u001a\u00020\u0007*\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001a=\u0010 \u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0019\"\u0014\u0010\u0000\u001a\u00020\u0001XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"InvalidFocusDirection", "", "getInvalidFocusDirection$annotations", "()V", "NoActiveChild", "getNoActiveChild$annotations", "backwardFocusSearch", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "onFound", "Lkotlin/Function1;", "forEachItemAfter", "", "T", "Landroidx/compose/runtime/collection/MutableVector;", "item", "action", "(Landroidx/compose/runtime/collection/MutableVector;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachItemBefore", "forwardFocusSearch", "generateAndSearchChildren", "focusedItem", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "isRoot", "oneDimensionalFocusSearch", "oneDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "pickChildForBackwardSearch", "pickChildForForwardSearch", "searchChildren", "searchChildren-4C6V_qg", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: OneDimensionalFocusSearch.kt */
public final class OneDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 1-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: OneDimensionalFocusSearch.kt */
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

    /* renamed from: oneDimensionalFocusSearch--OM-vw8  reason: not valid java name */
    public static final boolean m2959oneDimensionalFocusSearchOMvw8(FocusTargetNode $this$oneDimensionalFocusSearch_u2d_u2dOM_u2dvw8, int direction, Function1<? super FocusTargetNode, Boolean> onFound) {
        Intrinsics.checkNotNullParameter($this$oneDimensionalFocusSearch_u2d_u2dOM_u2dvw8, "$this$oneDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        if (FocusDirection.m2919equalsimpl0(direction, FocusDirection.Companion.m2932getNextdhqQ8s())) {
            return forwardFocusSearch($this$oneDimensionalFocusSearch_u2d_u2dOM_u2dvw8, onFound);
        }
        if (FocusDirection.m2919equalsimpl0(direction, FocusDirection.Companion.m2934getPreviousdhqQ8s())) {
            return backwardFocusSearch($this$oneDimensionalFocusSearch_u2d_u2dOM_u2dvw8, onFound);
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final boolean forwardFocusSearch(FocusTargetNode $this$forwardFocusSearch, Function1<? super FocusTargetNode, Boolean> onFound) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$forwardFocusSearch.getFocusState().ordinal()]) {
            case 1:
                FocusTargetNode focusedChild = FocusTraversalKt.getActiveChild($this$forwardFocusSearch);
                if (focusedChild != null) {
                    return forwardFocusSearch(focusedChild, onFound) || m2958generateAndSearchChildren4C6V_qg($this$forwardFocusSearch, focusedChild, FocusDirection.Companion.m2932getNextdhqQ8s(), onFound);
                }
                throw new IllegalStateException(NoActiveChild.toString());
            case 2:
            case 3:
                return pickChildForForwardSearch($this$forwardFocusSearch, onFound);
            case 4:
                if ($this$forwardFocusSearch.fetchFocusProperties$ui_release().getCanFocus()) {
                    return onFound.invoke($this$forwardFocusSearch).booleanValue();
                }
                return pickChildForForwardSearch($this$forwardFocusSearch, onFound);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean backwardFocusSearch(FocusTargetNode $this$backwardFocusSearch, Function1<? super FocusTargetNode, Boolean> onFound) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$backwardFocusSearch.getFocusState().ordinal()]) {
            case 1:
                FocusTargetNode focusedChild = FocusTraversalKt.getActiveChild($this$backwardFocusSearch);
                if (focusedChild != null) {
                    switch (WhenMappings.$EnumSwitchMapping$0[focusedChild.getFocusState().ordinal()]) {
                        case 1:
                            if (backwardFocusSearch(focusedChild, onFound) || m2958generateAndSearchChildren4C6V_qg($this$backwardFocusSearch, focusedChild, FocusDirection.Companion.m2934getPreviousdhqQ8s(), onFound)) {
                                return true;
                            }
                            if (!focusedChild.fetchFocusProperties$ui_release().getCanFocus() || !onFound.invoke(focusedChild).booleanValue()) {
                                return false;
                            }
                            return true;
                        case 2:
                        case 3:
                            return m2958generateAndSearchChildren4C6V_qg($this$backwardFocusSearch, focusedChild, FocusDirection.Companion.m2934getPreviousdhqQ8s(), onFound);
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
                return pickChildForBackwardSearch($this$backwardFocusSearch, onFound);
            case 4:
                if (pickChildForBackwardSearch($this$backwardFocusSearch, onFound)) {
                    return true;
                }
                if ($this$backwardFocusSearch.fetchFocusProperties$ui_release().getCanFocus() ? onFound.invoke($this$backwardFocusSearch).booleanValue() : false) {
                    return true;
                }
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg  reason: not valid java name */
    private static final boolean m2958generateAndSearchChildren4C6V_qg(FocusTargetNode $this$generateAndSearchChildren_u2d4C6V_qg, FocusTargetNode focusedItem, int direction, Function1<? super FocusTargetNode, Boolean> onFound) {
        if (m2960searchChildren4C6V_qg($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, onFound)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m2915searchBeyondBoundsOMvw8($this$generateAndSearchChildren_u2d4C6V_qg, direction, new OneDimensionalFocusSearchKt$generateAndSearchChildren$1($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, onFound));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg  reason: not valid java name */
    public static final boolean m2960searchChildren4C6V_qg(FocusTargetNode $this$searchChildren_u2d4C6V_qg, FocusTargetNode focusedItem, int direction, Function1<? super FocusTargetNode, Boolean> onFound) {
        Modifier.Node child$iv$iv;
        MutableVector $this$searchChildren_4C6V_qg_u24lambda_u242;
        Modifier.Node child$iv$iv2;
        MutableVector $this$searchChildren_4C6V_qg_u24lambda_u2422;
        int count$iv$iv;
        MutableVector mutableVector;
        FocusTargetNode focusTargetNode = $this$searchChildren_u2d4C6V_qg;
        FocusTargetNode focusTargetNode2 = focusedItem;
        int i = direction;
        Function1<? super FocusTargetNode, Boolean> function1 = onFound;
        if ($this$searchChildren_u2d4C6V_qg.getFocusState() == FocusStateImpl.ActiveParent) {
            MutableVector mutableVector2 = new MutableVector(new FocusTargetNode[16], 0);
            MutableVector $this$searchChildren_4C6V_qg_u24lambda_u2423 = mutableVector2;
            DelegatableNode $this$visitChildren_u2d6rFNWt0$iv = focusTargetNode;
            int type$iv = NodeKind.m4956constructorimpl(1024);
            int mask$iv$iv = type$iv;
            DelegatableNode $this$visitChildren$iv$iv = $this$visitChildren_u2d6rFNWt0$iv;
            if ($this$visitChildren$iv$iv.getNode().isAttached()) {
                DelegatableNode delegatableNode = $this$visitChildren_u2d6rFNWt0$iv;
                MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child$iv$iv3 = $this$visitChildren$iv$iv.getNode().getChild$ui_release();
                if (child$iv$iv3 == null) {
                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren$iv$iv.getNode());
                } else {
                    branches$iv$iv.add(child$iv$iv3);
                }
                while (branches$iv$iv.isNotEmpty()) {
                    Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                    if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                        Modifier.Node node$iv$iv = branch$iv$iv;
                        while (true) {
                            if (node$iv$iv == null) {
                                MutableVector mutableVector3 = branches$iv$iv;
                                Modifier.Node node = child$iv$iv3;
                                break;
                            } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                                MutableVector mutableVector4 = null;
                                Modifier.Node this_$iv$iv$iv = node$iv$iv;
                                while (this_$iv$iv$iv != null) {
                                    MutableVector branches$iv$iv2 = branches$iv$iv;
                                    if (this_$iv$iv$iv instanceof FocusTargetNode) {
                                        $this$searchChildren_4C6V_qg_u24lambda_u2423.add((FocusTargetNode) this_$iv$iv$iv);
                                        $this$searchChildren_4C6V_qg_u24lambda_u242 = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                                        child$iv$iv = child$iv$iv3;
                                    } else {
                                        if (!((this_$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0) || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                                            $this$searchChildren_4C6V_qg_u24lambda_u242 = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                                            child$iv$iv = child$iv$iv3;
                                        } else {
                                            int count$iv$iv2 = 0;
                                            Modifier.Node node$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                                            while (node$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                if ((next$iv$iv.getKindSet$ui_release() & type$iv) != 0) {
                                                    count$iv$iv2++;
                                                    $this$searchChildren_4C6V_qg_u24lambda_u2422 = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                                                    if (count$iv$iv2 == 1) {
                                                        this_$iv$iv$iv = next$iv$iv;
                                                        child$iv$iv2 = child$iv$iv3;
                                                        Modifier.Node child$iv$iv4 = next$iv$iv;
                                                    } else {
                                                        if (mutableVector4 == null) {
                                                            count$iv$iv = count$iv$iv2;
                                                            child$iv$iv2 = child$iv$iv3;
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            count$iv$iv = count$iv$iv2;
                                                            child$iv$iv2 = child$iv$iv3;
                                                            mutableVector = mutableVector4;
                                                        }
                                                        MutableVector mutableVector5 = mutableVector;
                                                        Modifier.Node theNode$iv$iv = this_$iv$iv$iv;
                                                        if (theNode$iv$iv != null) {
                                                            if (mutableVector5 != null) {
                                                                mutableVector5.add(theNode$iv$iv);
                                                            }
                                                            this_$iv$iv$iv = null;
                                                        }
                                                        if (mutableVector5 != null) {
                                                            mutableVector5.add(next$iv$iv);
                                                        }
                                                        mutableVector4 = mutableVector5;
                                                        count$iv$iv2 = count$iv$iv;
                                                    }
                                                } else {
                                                    $this$searchChildren_4C6V_qg_u24lambda_u2422 = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                                                    child$iv$iv2 = child$iv$iv3;
                                                    Modifier.Node child$iv$iv5 = next$iv$iv;
                                                }
                                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                                $this$searchChildren_4C6V_qg_u24lambda_u2423 = $this$searchChildren_4C6V_qg_u24lambda_u2422;
                                                child$iv$iv3 = child$iv$iv2;
                                            }
                                            $this$searchChildren_4C6V_qg_u24lambda_u242 = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                                            child$iv$iv = child$iv$iv3;
                                            if (count$iv$iv2 == 1) {
                                                branches$iv$iv = branches$iv$iv2;
                                                $this$searchChildren_4C6V_qg_u24lambda_u2423 = $this$searchChildren_4C6V_qg_u24lambda_u242;
                                                child$iv$iv3 = child$iv$iv;
                                            }
                                        }
                                    }
                                    this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector4);
                                    branches$iv$iv = branches$iv$iv2;
                                    $this$searchChildren_4C6V_qg_u24lambda_u2423 = $this$searchChildren_4C6V_qg_u24lambda_u242;
                                    child$iv$iv3 = child$iv$iv;
                                }
                                MutableVector mutableVector6 = branches$iv$iv;
                                Modifier.Node node2 = child$iv$iv3;
                            } else {
                                MutableVector mutableVector7 = branches$iv$iv;
                                Modifier.Node node3 = child$iv$iv3;
                                node$iv$iv = node$iv$iv.getChild$ui_release();
                            }
                        }
                    } else {
                        DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                    }
                }
                MutableVector mutableVector8 = branches$iv$iv;
                Modifier.Node node4 = child$iv$iv3;
                MutableVector children = mutableVector2;
                children.sortWith(FocusableChildrenComparator.INSTANCE);
                if (FocusDirection.m2919equalsimpl0(i, FocusDirection.Companion.m2932getNextdhqQ8s())) {
                    MutableVector $this$forEachItemAfter$iv = children;
                    boolean itemFound$iv = false;
                    IntRange intRange = new IntRange(0, $this$forEachItemAfter$iv.getSize() - 1);
                    int index$iv = intRange.getFirst();
                    int last = intRange.getLast();
                    if (index$iv <= last) {
                        while (true) {
                            if (itemFound$iv) {
                                FocusTargetNode child = (FocusTargetNode) $this$forEachItemAfter$iv.getContent()[index$iv];
                                if (FocusTraversalKt.isEligibleForFocusSearch(child) && forwardFocusSearch(child, function1)) {
                                    return true;
                                }
                            }
                            if (Intrinsics.areEqual($this$forEachItemAfter$iv.getContent()[index$iv], (Object) focusTargetNode2)) {
                                itemFound$iv = true;
                            }
                            if (index$iv == last) {
                                break;
                            }
                            index$iv++;
                        }
                    }
                } else if (FocusDirection.m2919equalsimpl0(i, FocusDirection.Companion.m2934getPreviousdhqQ8s())) {
                    MutableVector $this$forEachItemBefore$iv = children;
                    boolean itemFound$iv2 = false;
                    IntRange intRange2 = new IntRange(0, $this$forEachItemBefore$iv.getSize() - 1);
                    int first = intRange2.getFirst();
                    int index$iv2 = intRange2.getLast();
                    if (first <= index$iv2) {
                        while (true) {
                            if (itemFound$iv2) {
                                FocusTargetNode child2 = (FocusTargetNode) $this$forEachItemBefore$iv.getContent()[index$iv2];
                                if (FocusTraversalKt.isEligibleForFocusSearch(child2) && backwardFocusSearch(child2, function1)) {
                                    return true;
                                }
                            }
                            if (Intrinsics.areEqual($this$forEachItemBefore$iv.getContent()[index$iv2], (Object) focusTargetNode2)) {
                                itemFound$iv2 = true;
                            }
                            if (index$iv2 == first) {
                                break;
                            }
                            index$iv2--;
                        }
                    }
                } else {
                    throw new IllegalStateException(InvalidFocusDirection.toString());
                }
                if (FocusDirection.m2919equalsimpl0(i, FocusDirection.Companion.m2932getNextdhqQ8s()) || !$this$searchChildren_u2d4C6V_qg.fetchFocusProperties$ui_release().getCanFocus() || isRoot($this$searchChildren_u2d4C6V_qg)) {
                    return false;
                }
                return function1.invoke(focusTargetNode).booleanValue();
            }
            MutableVector mutableVector9 = $this$searchChildren_4C6V_qg_u24lambda_u2423;
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        throw new IllegalStateException("This function should only be used within a parent that has focus.".toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01b1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean pickChildForForwardSearch(androidx.compose.ui.focus.FocusTargetNode r32, kotlin.jvm.functions.Function1<? super androidx.compose.ui.focus.FocusTargetNode, java.lang.Boolean> r33) {
        /*
            r0 = 16
            r1 = 0
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.focus.FocusTargetNode[] r3 = new androidx.compose.ui.focus.FocusTargetNode[r0]
            r4 = 0
            r2.<init>(r3, r4)
            r0 = r2
            r1 = 0
            r3 = r32
            androidx.compose.ui.node.DelegatableNode r3 = (androidx.compose.ui.node.DelegatableNode) r3
            r5 = 0
            r6 = 1024(0x400, float:1.435E-42)
            int r5 = androidx.compose.ui.node.NodeKind.m4956constructorimpl(r6)
            r6 = 0
            r7 = r5
            r8 = r3
            r9 = 0
            androidx.compose.ui.Modifier$Node r10 = r8.getNode()
            boolean r10 = r10.isAttached()
            if (r10 == 0) goto L_0x01bc
            r10 = 0
            r11 = 16
            r12 = 0
            androidx.compose.runtime.collection.MutableVector r13 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r14 = new androidx.compose.ui.Modifier.Node[r11]
            r13.<init>(r14, r4)
            r10 = r13
            androidx.compose.ui.Modifier$Node r11 = r8.getNode()
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            if (r11 != 0) goto L_0x0048
            androidx.compose.ui.Modifier$Node r12 = r8.getNode()
            androidx.compose.ui.node.DelegatableNodeKt.addLayoutNodeChildren(r10, r12)
            goto L_0x004b
        L_0x0048:
            r10.add(r11)
        L_0x004b:
            boolean r12 = r10.isNotEmpty()
            r13 = 1
            if (r12 == 0) goto L_0x0178
            r12 = r10
            r14 = 0
            int r15 = r12.getSize()
            int r15 = r15 - r13
            java.lang.Object r12 = r10.removeAt(r15)
            androidx.compose.ui.Modifier$Node r12 = (androidx.compose.ui.Modifier.Node) r12
            int r14 = r12.getAggregateChildKindSet$ui_release()
            r14 = r14 & r7
            if (r14 != 0) goto L_0x006a
            androidx.compose.ui.node.DelegatableNodeKt.addLayoutNodeChildren(r10, r12)
            goto L_0x004b
        L_0x006a:
            r14 = r12
        L_0x006b:
            if (r14 == 0) goto L_0x016f
            int r15 = r14.getKindSet$ui_release()
            r15 = r15 & r7
            if (r15 == 0) goto L_0x015f
            r15 = r14
            r16 = 0
            r17 = r15
            r18 = 0
            r19 = 0
            r20 = 0
            r20 = r17
            r4 = r20
        L_0x0083:
            if (r4 == 0) goto L_0x0154
            boolean r13 = r4 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r13 == 0) goto L_0x009a
            r13 = r4
            androidx.compose.ui.focus.FocusTargetNode r13 = (androidx.compose.ui.focus.FocusTargetNode) r13
            r21 = 0
            r0.add(r13)
            r26 = r0
            r29 = r1
            r30 = r3
            r0 = 1
            goto L_0x0147
        L_0x009a:
            r13 = r4
            r21 = 0
            int r22 = r13.getKindSet$ui_release()
            r22 = r22 & r5
            if (r22 == 0) goto L_0x00a7
            r13 = 1
            goto L_0x00a8
        L_0x00a7:
            r13 = 0
        L_0x00a8:
            if (r13 == 0) goto L_0x0140
            boolean r13 = r4 instanceof androidx.compose.ui.node.DelegatingNode
            if (r13 == 0) goto L_0x0140
            r13 = 0
            r21 = r4
            androidx.compose.ui.node.DelegatingNode r21 = (androidx.compose.ui.node.DelegatingNode) r21
            r22 = 0
            androidx.compose.ui.Modifier$Node r23 = r21.getDelegate$ui_release()
        L_0x00b9:
            if (r23 == 0) goto L_0x012e
            r24 = r23
            r25 = 0
            r26 = r24
            r27 = 0
            int r28 = r26.getKindSet$ui_release()
            r28 = r28 & r5
            if (r28 == 0) goto L_0x00ce
            r26 = 1
            goto L_0x00d0
        L_0x00ce:
            r26 = 0
        L_0x00d0:
            if (r26 == 0) goto L_0x0119
            int r13 = r13 + 1
            r26 = r0
            r0 = 1
            if (r13 != r0) goto L_0x00e2
            r4 = r24
            r29 = r1
            r30 = r3
            r0 = r24
            goto L_0x0121
        L_0x00e2:
            if (r19 != 0) goto L_0x00fb
            r0 = 0
            r27 = r0
            r0 = 16
            r28 = 0
            r29 = r1
            androidx.compose.runtime.collection.MutableVector r1 = new androidx.compose.runtime.collection.MutableVector
            r30 = r3
            androidx.compose.ui.Modifier$Node[] r3 = new androidx.compose.ui.Modifier.Node[r0]
            r31 = r0
            r0 = 0
            r1.<init>(r3, r0)
            goto L_0x0102
        L_0x00fb:
            r29 = r1
            r30 = r3
            r0 = 0
            r1 = r19
        L_0x0102:
            r3 = r4
            if (r3 == 0) goto L_0x010c
            if (r1 == 0) goto L_0x010b
            r1.add(r3)
        L_0x010b:
            r4 = 0
        L_0x010c:
            if (r1 == 0) goto L_0x0114
            r0 = r24
            r1.add(r0)
            goto L_0x0116
        L_0x0114:
            r0 = r24
        L_0x0116:
            r19 = r1
            goto L_0x0121
        L_0x0119:
            r26 = r0
            r29 = r1
            r30 = r3
            r0 = r24
        L_0x0121:
            androidx.compose.ui.Modifier$Node r23 = r23.getChild$ui_release()
            r0 = r26
            r1 = r29
            r3 = r30
            goto L_0x00b9
        L_0x012e:
            r26 = r0
            r29 = r1
            r30 = r3
            r0 = 1
            if (r13 != r0) goto L_0x0147
            r13 = r0
            r0 = r26
            r1 = r29
            r3 = r30
            goto L_0x0083
        L_0x0140:
            r26 = r0
            r29 = r1
            r30 = r3
            r0 = 1
        L_0x0147:
            androidx.compose.ui.Modifier$Node r4 = androidx.compose.ui.node.DelegatableNodeKt.pop(r19)
            r13 = r0
            r0 = r26
            r1 = r29
            r3 = r30
            goto L_0x0083
        L_0x0154:
            r26 = r0
            r29 = r1
            r30 = r3
            r4 = 0
            goto L_0x004b
        L_0x015f:
            r26 = r0
            r29 = r1
            r30 = r3
            r0 = r13
            androidx.compose.ui.Modifier$Node r14 = r14.getChild$ui_release()
            r0 = r26
            r4 = 0
            goto L_0x006b
        L_0x016f:
            r26 = r0
            r29 = r1
            r30 = r3
            r4 = 0
            goto L_0x004b
        L_0x0178:
            r26 = r0
            r29 = r1
            r30 = r3
            r0 = r13
            r1 = r2
            androidx.compose.ui.focus.FocusableChildrenComparator r2 = androidx.compose.ui.focus.FocusableChildrenComparator.INSTANCE
            java.util.Comparator r2 = (java.util.Comparator) r2
            r1.sortWith(r2)
            r2 = r1
            r3 = 0
            int r4 = r2.getSize()
            if (r4 <= 0) goto L_0x01b8
            r5 = 0
            java.lang.Object[] r6 = r2.getContent()
        L_0x0197:
            r7 = r6[r5]
            androidx.compose.ui.focus.FocusTargetNode r7 = (androidx.compose.ui.focus.FocusTargetNode) r7
            r8 = 0
            boolean r9 = androidx.compose.ui.focus.FocusTraversalKt.isEligibleForFocusSearch(r7)
            if (r9 == 0) goto L_0x01ac
            r10 = r33
            boolean r9 = forwardFocusSearch(r7, r10)
            if (r9 == 0) goto L_0x01ae
            r7 = r0
            goto L_0x01af
        L_0x01ac:
            r10 = r33
        L_0x01ae:
            r7 = 0
        L_0x01af:
            if (r7 == 0) goto L_0x01b3
            r4 = r0
            goto L_0x01bb
        L_0x01b3:
            int r5 = r5 + 1
            if (r5 < r4) goto L_0x0197
            goto L_0x01ba
        L_0x01b8:
            r10 = r33
        L_0x01ba:
            r4 = 0
        L_0x01bb:
            return r4
        L_0x01bc:
            r26 = r0
            r29 = r1
            r0 = 0
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "visitChildren called on an unattached node"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.OneDimensionalFocusSearchKt.pickChildForForwardSearch(androidx.compose.ui.focus.FocusTargetNode, kotlin.jvm.functions.Function1):boolean");
    }

    private static final boolean pickChildForBackwardSearch(FocusTargetNode $this$pickChildForBackwardSearch, Function1<? super FocusTargetNode, Boolean> onFound) {
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv;
        boolean z;
        MutableVector $this$pickChildForBackwardSearch_u24lambda_u249;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv2;
        boolean z2;
        MutableVector $this$pickChildForBackwardSearch_u24lambda_u2492;
        MutableVector mutableVector;
        MutableVector mutableVector2 = new MutableVector(new FocusTargetNode[16], 0);
        MutableVector $this$pickChildForBackwardSearch_u24lambda_u2493 = mutableVector2;
        boolean z3 = false;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv3 = $this$pickChildForBackwardSearch;
        int type$iv = NodeKind.m4956constructorimpl(1024);
        int mask$iv$iv = type$iv;
        DelegatableNode $this$visitChildren$iv$iv = $this$visitChildren_u2d6rFNWt0$iv3;
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
                            boolean z4 = z3;
                            DelegatableNode delegatableNode = $this$visitChildren_u2d6rFNWt0$iv3;
                            break;
                        } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            MutableVector mutableVector3 = null;
                            Modifier.Node this_$iv$iv$iv = node$iv$iv;
                            while (this_$iv$iv$iv != null) {
                                if (this_$iv$iv$iv instanceof FocusTargetNode) {
                                    $this$pickChildForBackwardSearch_u24lambda_u2493.add((FocusTargetNode) this_$iv$iv$iv);
                                    $this$pickChildForBackwardSearch_u24lambda_u249 = $this$pickChildForBackwardSearch_u24lambda_u2493;
                                    z = z3;
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                } else {
                                    if (!((this_$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0) || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                                        $this$pickChildForBackwardSearch_u24lambda_u249 = $this$pickChildForBackwardSearch_u24lambda_u2493;
                                        z = z3;
                                        $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                    } else {
                                        int count$iv$iv = 0;
                                        Modifier.Node node$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                                        while (node$iv$iv$iv != null) {
                                            DelegatableNode next$iv$iv = node$iv$iv$iv;
                                            if ((next$iv$iv.getKindSet$ui_release() & type$iv) != 0) {
                                                count$iv$iv++;
                                                $this$pickChildForBackwardSearch_u24lambda_u2492 = $this$pickChildForBackwardSearch_u24lambda_u2493;
                                                if (count$iv$iv == 1) {
                                                    this_$iv$iv$iv = next$iv$iv;
                                                    z2 = z3;
                                                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                    DelegatableNode $this$visitChildren_u2d6rFNWt0$iv4 = next$iv$iv;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        z2 = z3;
                                                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        z2 = z3;
                                                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                        mutableVector = mutableVector3;
                                                    }
                                                    MutableVector mutableVector4 = mutableVector;
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
                                                $this$pickChildForBackwardSearch_u24lambda_u2492 = $this$pickChildForBackwardSearch_u24lambda_u2493;
                                                z2 = z3;
                                                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                DelegatableNode $this$visitChildren_u2d6rFNWt0$iv5 = next$iv$iv;
                                            }
                                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                            $this$pickChildForBackwardSearch_u24lambda_u2493 = $this$pickChildForBackwardSearch_u24lambda_u2492;
                                            z3 = z2;
                                            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                                        }
                                        $this$pickChildForBackwardSearch_u24lambda_u249 = $this$pickChildForBackwardSearch_u24lambda_u2493;
                                        z = z3;
                                        $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                        if (count$iv$iv == 1) {
                                            $this$pickChildForBackwardSearch_u24lambda_u2493 = $this$pickChildForBackwardSearch_u24lambda_u249;
                                            z3 = z;
                                            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                                        }
                                    }
                                }
                                this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector3);
                                $this$pickChildForBackwardSearch_u24lambda_u2493 = $this$pickChildForBackwardSearch_u24lambda_u249;
                                z3 = z;
                                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                            }
                            boolean z5 = z3;
                            DelegatableNode delegatableNode2 = $this$visitChildren_u2d6rFNWt0$iv3;
                        } else {
                            boolean z6 = z3;
                            DelegatableNode delegatableNode3 = $this$visitChildren_u2d6rFNWt0$iv3;
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                        }
                    }
                } else {
                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                }
            }
            boolean z7 = z3;
            DelegatableNode delegatableNode4 = $this$visitChildren_u2d6rFNWt0$iv3;
            MutableVector children = mutableVector2;
            children.sortWith(FocusableChildrenComparator.INSTANCE);
            MutableVector this_$iv = children;
            int size$iv = this_$iv.getSize();
            if (size$iv > 0) {
                int i$iv = size$iv - 1;
                Object[] content$iv = this_$iv.getContent();
                do {
                    FocusTargetNode it = (FocusTargetNode) content$iv[i$iv];
                    if (!FocusTraversalKt.isEligibleForFocusSearch(it)) {
                        Function1<? super FocusTargetNode, Boolean> function1 = onFound;
                    } else if (backwardFocusSearch(it, onFound)) {
                        return true;
                    }
                    i$iv--;
                } while (i$iv >= 0);
                return false;
            }
            Function1<? super FocusTargetNode, Boolean> function12 = onFound;
            return false;
        }
        MutableVector mutableVector5 = $this$pickChildForBackwardSearch_u24lambda_u2493;
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    private static final boolean isRoot(FocusTargetNode $this$isRoot) {
        boolean z;
        boolean z2;
        Modifier.Node this_$iv$iv$iv$iv;
        int i;
        int type$iv;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        NodeChain nodes$ui_release;
        boolean z3;
        int i2;
        int type$iv2;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        int i3;
        int type$iv3;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
        boolean z4;
        int i4;
        int type$iv4;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv4;
        MutableVector mutableVector;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv5 = $this$isRoot;
        int type$iv5 = NodeKind.m4956constructorimpl(1024);
        int i5 = false;
        int mask$iv$iv$iv = type$iv5;
        DelegatableNode $this$visitAncestors$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv5;
        if ($this$visitAncestors$iv$iv$iv.getNode().isAttached()) {
            Modifier.Node node$iv$iv$iv = $this$visitAncestors$iv$iv$iv.getNode().getParent$ui_release();
            LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv$iv);
            loop0:
            while (true) {
                boolean z5 = true;
                if (layout$iv$iv$iv == null) {
                    int i6 = type$iv5;
                    int i7 = i5;
                    z = true;
                    z2 = false;
                    this_$iv$iv$iv$iv = null;
                    break;
                }
                if ((layout$iv$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                    while (node$iv$iv$iv != null) {
                        if ((node$iv$iv$iv.getKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                            MutableVector mutableVector2 = null;
                            this_$iv$iv$iv$iv = node$iv$iv$iv;
                            while (this_$iv$iv$iv$iv != null) {
                                if (this_$iv$iv$iv$iv instanceof FocusTargetNode) {
                                    Modifier.Node node = this_$iv$iv$iv$iv;
                                    z = z3;
                                    z2 = false;
                                    break loop0;
                                }
                                if (!((this_$iv$iv$iv$iv.getKindSet$ui_release() & type$iv2) != 0 ? z3 : false) || !(this_$iv$iv$iv$iv instanceof DelegatingNode)) {
                                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                                    type$iv3 = type$iv2;
                                    i3 = i2;
                                    z4 = z3;
                                } else {
                                    int count$iv$iv$iv = 0;
                                    Modifier.Node node$iv$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv$iv).getDelegate$ui_release();
                                    while (node$iv$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                        if ((next$iv$iv$iv.getKindSet$ui_release() & type$iv2) != 0 ? z3 : false) {
                                            count$iv$iv$iv++;
                                            if (count$iv$iv$iv == z3) {
                                                this_$iv$iv$iv$iv = next$iv$iv$iv;
                                                $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                type$iv4 = type$iv2;
                                                i4 = i2;
                                                Modifier.Node node2 = next$iv$iv$iv;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                    type$iv4 = type$iv2;
                                                    i4 = i2;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                    type$iv4 = type$iv2;
                                                    i4 = i2;
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
                                            type$iv4 = type$iv2;
                                            i4 = i2;
                                            Modifier.Node node3 = next$iv$iv$iv;
                                        }
                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                        type$iv2 = type$iv4;
                                        i2 = i4;
                                        z3 = true;
                                    }
                                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                                    type$iv3 = type$iv2;
                                    i3 = i2;
                                    z4 = true;
                                    if (count$iv$iv$iv == 1) {
                                        z3 = true;
                                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                                        type$iv2 = type$iv3;
                                        i2 = i3;
                                    }
                                }
                                this_$iv$iv$iv$iv = DelegatableNodeKt.pop(mutableVector2);
                                z3 = z4;
                                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                                type$iv2 = type$iv3;
                                i2 = i3;
                            }
                            continue;
                        }
                        node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                        z5 = z3;
                        $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv2;
                        type$iv5 = type$iv2;
                        i5 = i2;
                    }
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    type$iv = type$iv2;
                    i = i2;
                } else {
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv5;
                    type$iv = type$iv5;
                    i = i5;
                }
                layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes$ui_release = layout$iv$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv;
                type$iv5 = type$iv;
                i5 = i;
            }
            return this_$iv$iv$iv$iv == null ? z : z2;
        }
        DelegatableNode delegatableNode = $this$nearestAncestor_u2d64DMado$iv5;
        int i8 = type$iv5;
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    private static final <T> void forEachItemAfter(MutableVector<T> $this$forEachItemAfter, T item, Function1<? super T, Unit> action) {
        boolean itemFound = false;
        IntRange intRange = new IntRange(0, $this$forEachItemAfter.getSize() - 1);
        int index = intRange.getFirst();
        int last = intRange.getLast();
        if (index <= last) {
            while (true) {
                if (itemFound) {
                    action.invoke($this$forEachItemAfter.getContent()[index]);
                }
                if (Intrinsics.areEqual($this$forEachItemAfter.getContent()[index], (Object) item)) {
                    itemFound = true;
                }
                if (index != last) {
                    index++;
                } else {
                    return;
                }
            }
        }
    }

    private static final <T> void forEachItemBefore(MutableVector<T> $this$forEachItemBefore, T item, Function1<? super T, Unit> action) {
        boolean itemFound = false;
        IntRange intRange = new IntRange(0, $this$forEachItemBefore.getSize() - 1);
        int first = intRange.getFirst();
        int index = intRange.getLast();
        if (first <= index) {
            while (true) {
                if (itemFound) {
                    action.invoke($this$forEachItemBefore.getContent()[index]);
                }
                if (Intrinsics.areEqual($this$forEachItemBefore.getContent()[index], (Object) item)) {
                    itemFound = true;
                }
                if (index != first) {
                    index--;
                } else {
                    return;
                }
            }
        }
    }
}

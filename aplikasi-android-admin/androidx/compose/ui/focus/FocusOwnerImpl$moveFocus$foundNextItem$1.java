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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "destination", "Landroidx/compose/ui/focus/FocusTargetNode;", "invoke", "(Landroidx/compose/ui/focus/FocusTargetNode;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusOwnerImpl.kt */
final class FocusOwnerImpl$moveFocus$foundNextItem$1 extends Lambda implements Function1<FocusTargetNode, Boolean> {
    final /* synthetic */ int $focusDirection;
    final /* synthetic */ Ref.BooleanRef $isCancelled;
    final /* synthetic */ FocusTargetNode $source;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusOwnerImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusOwnerImpl$moveFocus$foundNextItem$1(FocusTargetNode focusTargetNode, int i, Ref.BooleanRef booleanRef) {
        super(1);
        this.$source = focusTargetNode;
        this.$focusDirection = i;
        this.$isCancelled = booleanRef;
    }

    public final Boolean invoke(FocusTargetNode destination) {
        Modifier.Node this_$iv$iv$iv$iv;
        boolean z;
        int type$iv;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        int type$iv2;
        NodeChain nodes$ui_release;
        int i;
        int type$iv3;
        int count$iv$iv$iv;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        int type$iv4;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
        int type$iv5;
        int type$iv6;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv4;
        int count$iv$iv$iv2;
        MutableVector mutableVector;
        FocusTargetNode focusTargetNode = destination;
        Intrinsics.checkNotNullParameter(focusTargetNode, "destination");
        int count$iv$iv$iv3 = 0;
        if (Intrinsics.areEqual((Object) focusTargetNode, (Object) this.$source)) {
            return false;
        }
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv5 = focusTargetNode;
        int type$iv7 = NodeKind.m6666constructorimpl(1024);
        int mask$iv$iv$iv = type$iv7;
        DelegatableNode $this$visitAncestors$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv5;
        if ($this$visitAncestors$iv$iv$iv.getNode().isAttached()) {
            Modifier.Node node$iv$iv$iv = $this$visitAncestors$iv$iv$iv.getNode().getParent$ui_release();
            LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv$iv);
            loop0:
            while (true) {
                int i2 = 1;
                if (layout$iv$iv$iv == null) {
                    int i3 = type$iv7;
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
                                    break loop0;
                                }
                                if (((this_$iv$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? i : 0) == 0 || !(this_$iv$iv$iv$iv instanceof DelegatingNode)) {
                                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                                    type$iv4 = type$iv3;
                                    type$iv5 = 0;
                                } else {
                                    int count$iv$iv$iv4 = 0;
                                    Modifier.Node node$iv$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv$iv).getDelegate$ui_release();
                                    while (node$iv$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                        if (((next$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? i : 0) != 0) {
                                            count$iv$iv$iv4++;
                                            if (count$iv$iv$iv4 == i) {
                                                this_$iv$iv$iv$iv = next$iv$iv$iv;
                                                $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                type$iv6 = type$iv3;
                                                Modifier.Node node2 = next$iv$iv$iv;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                    count$iv$iv$iv2 = count$iv$iv$iv4;
                                                    type$iv6 = type$iv3;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                    count$iv$iv$iv2 = count$iv$iv$iv4;
                                                    type$iv6 = type$iv3;
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
                                                count$iv$iv$iv4 = count$iv$iv$iv2;
                                            }
                                        } else {
                                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                            type$iv6 = type$iv3;
                                            Modifier.Node node3 = next$iv$iv$iv;
                                        }
                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                        type$iv3 = type$iv6;
                                        i = 1;
                                    }
                                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                                    type$iv4 = type$iv3;
                                    type$iv5 = 0;
                                    if (count$iv$iv$iv4 == 1) {
                                        count$iv$iv$iv = 0;
                                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                                        type$iv3 = type$iv4;
                                        i = 1;
                                    }
                                }
                                this_$iv$iv$iv$iv = DelegatableNodeKt.pop(mutableVector2);
                                count$iv$iv$iv = type$iv5;
                                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                                type$iv3 = type$iv4;
                                i = 1;
                            }
                            continue;
                        }
                        node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                        count$iv$iv$iv3 = count$iv$iv$iv;
                        $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv2;
                        type$iv7 = type$iv3;
                        i2 = 1;
                    }
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    type$iv = type$iv3;
                    type$iv2 = count$iv$iv$iv;
                } else {
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv5;
                    type$iv = type$iv7;
                    type$iv2 = count$iv$iv$iv3;
                }
                layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes$ui_release = layout$iv$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                count$iv$iv$iv3 = type$iv2;
                $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv;
                type$iv7 = type$iv;
            }
            if (this_$iv$iv$iv$iv != null) {
                switch (WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m4664performCustomRequestFocusMxy_nc0(focusTargetNode, this.$focusDirection).ordinal()]) {
                    case 1:
                        z = true;
                        break;
                    case 2:
                    case 3:
                        this.$isCancelled.element = true;
                        z = true;
                        break;
                    case 4:
                        z = FocusTransactionsKt.performRequestFocus(destination);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                return Boolean.valueOf(z);
            }
            throw new IllegalStateException("Focus search landed at the root.".toString());
        }
        DelegatableNode delegatableNode = $this$nearestAncestor_u2d64DMado$iv5;
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }
}

package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNodeKt;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusPropertiesModifierNodeKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTargetNodeKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.layout.IntermediateLayoutModifierNode;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.semantics.SemanticsModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0000\u001a \u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0000\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a&\u0010\u001c\u001a\u00020\t*\u00020\u00012\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\nH\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a&\u0010 \u001a\u00020\u0001*\u00020\u00012\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\nH\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\f\u0010$\u001a\u00020\u000e*\u00020%H\u0002\u001a\f\u0010&\u001a\u00020\t*\u00020%H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001XT¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u001f\u0010\b\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\n8@X\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Inserted", "", "getInserted$annotations", "()V", "Removed", "getRemoved$annotations", "Updated", "getUpdated$annotations", "includeSelfInTraversal", "", "Landroidx/compose/ui/node/NodeKind;", "getIncludeSelfInTraversal-H91voCI", "(I)Z", "autoInvalidateInsertedNode", "", "node", "Landroidx/compose/ui/Modifier$Node;", "autoInvalidateNodeIncludingDelegates", "remainingSet", "phase", "autoInvalidateNodeSelf", "selfKindSet", "autoInvalidateRemovedNode", "autoInvalidateUpdatedNode", "calculateNodeKindSetFrom", "element", "Landroidx/compose/ui/Modifier$Element;", "calculateNodeKindSetFromIncludingDelegates", "contains", "value", "contains-64DMado", "(II)Z", "or", "other", "or-64DMado", "(II)I", "scheduleInvalidationOfAssociatedFocusTargets", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "specifiesCanFocusProperty", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeKind.kt */
public final class NodeKindKt {
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private static final int Updated = 0;

    private static /* synthetic */ void getInserted$annotations() {
    }

    private static /* synthetic */ void getRemoved$annotations() {
    }

    private static /* synthetic */ void getUpdated$annotations() {
    }

    /* renamed from: or-64DMado  reason: not valid java name */
    public static final int m4966or64DMado(int $this$or_u2d64DMado, int other) {
        return $this$or_u2d64DMado | other;
    }

    /* renamed from: contains-64DMado  reason: not valid java name */
    public static final boolean m4964contains64DMado(int $this$contains_u2d64DMado, int value) {
        return ($this$contains_u2d64DMado & value) != 0;
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI  reason: not valid java name */
    public static final boolean m4965getIncludeSelfInTraversalH91voCI(int $this$includeSelfInTraversal) {
        return (NodeKind.m4956constructorimpl(128) & $this$includeSelfInTraversal) != 0;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        int mask = NodeKind.m4956constructorimpl(1);
        if (element instanceof LayoutModifier) {
            mask = NodeKind.m4956constructorimpl(2) | mask;
        }
        if (element instanceof DrawModifier) {
            mask = NodeKind.m4956constructorimpl(4) | mask;
        }
        if (element instanceof SemanticsModifier) {
            mask = NodeKind.m4956constructorimpl(8) | mask;
        }
        if (element instanceof PointerInputModifier) {
            mask = NodeKind.m4956constructorimpl(16) | mask;
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider)) {
            mask = NodeKind.m4956constructorimpl(32) | mask;
        }
        if (element instanceof FocusEventModifier) {
            mask = NodeKind.m4956constructorimpl(4096) | mask;
        }
        if (element instanceof FocusOrderModifier) {
            mask = NodeKind.m4956constructorimpl(2048) | mask;
        }
        if (element instanceof OnGloballyPositionedModifier) {
            mask = NodeKind.m4956constructorimpl(256) | mask;
        }
        if (element instanceof ParentDataModifier) {
            mask = NodeKind.m4956constructorimpl(64) | mask;
        }
        if ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier)) {
            return NodeKind.m4956constructorimpl(128) | mask;
        }
        return mask;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node.getKindSet$ui_release() != 0) {
            return node.getKindSet$ui_release();
        }
        int mask = NodeKind.m4956constructorimpl(1);
        if (node instanceof LayoutModifierNode) {
            mask = NodeKind.m4956constructorimpl(2) | mask;
        }
        if (node instanceof DrawModifierNode) {
            mask = NodeKind.m4956constructorimpl(4) | mask;
        }
        if (node instanceof SemanticsModifierNode) {
            mask = NodeKind.m4956constructorimpl(8) | mask;
        }
        if (node instanceof PointerInputModifierNode) {
            mask = NodeKind.m4956constructorimpl(16) | mask;
        }
        if (node instanceof ModifierLocalModifierNode) {
            mask = NodeKind.m4956constructorimpl(32) | mask;
        }
        if (node instanceof ParentDataModifierNode) {
            mask = NodeKind.m4956constructorimpl(64) | mask;
        }
        if (node instanceof LayoutAwareModifierNode) {
            mask = NodeKind.m4956constructorimpl(128) | mask;
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            mask = NodeKind.m4956constructorimpl(256) | mask;
        }
        if (node instanceof IntermediateLayoutModifierNode) {
            mask = NodeKind.m4956constructorimpl(512) | mask;
        }
        if (node instanceof FocusTargetNode) {
            mask = NodeKind.m4956constructorimpl(1024) | mask;
        }
        if (node instanceof FocusPropertiesModifierNode) {
            mask = NodeKind.m4956constructorimpl(2048) | mask;
        }
        if (node instanceof FocusEventModifierNode) {
            mask = NodeKind.m4956constructorimpl(4096) | mask;
        }
        if (node instanceof KeyInputModifierNode) {
            mask = NodeKind.m4956constructorimpl(8192) | mask;
        }
        if (node instanceof RotaryInputModifierNode) {
            mask = NodeKind.m4956constructorimpl(16384) | mask;
        }
        if (node instanceof CompositionLocalConsumerModifierNode) {
            mask = NodeKind.m4956constructorimpl(32768) | mask;
        }
        if (node instanceof SoftKeyboardInterceptionModifierNode) {
            return NodeKind.m4956constructorimpl(131072) | mask;
        }
        return mask;
    }

    public static final void autoInvalidateRemovedNode(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node.isAttached()) {
            autoInvalidateNodeIncludingDelegates(node, -1, 2);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final void autoInvalidateInsertedNode(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node.isAttached()) {
            autoInvalidateNodeIncludingDelegates(node, -1, 1);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final void autoInvalidateUpdatedNode(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node.isAttached()) {
            autoInvalidateNodeIncludingDelegates(node, -1, 0);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final void autoInvalidateNodeIncludingDelegates(Modifier.Node node, int remainingSet, int phase) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node instanceof DelegatingNode) {
            autoInvalidateNodeSelf(node, ((DelegatingNode) node).getSelfKindSet$ui_release() & remainingSet, phase);
            int newRemaining = (~((DelegatingNode) node).getSelfKindSet$ui_release()) & remainingSet;
            for (Modifier.Node node$iv = ((DelegatingNode) node).getDelegate$ui_release(); node$iv != null; node$iv = node$iv.getChild$ui_release()) {
                autoInvalidateNodeIncludingDelegates(node$iv, newRemaining, phase);
            }
            return;
        }
        autoInvalidateNodeSelf(node, node.getKindSet$ui_release() & remainingSet, phase);
    }

    private static final void autoInvalidateNodeSelf(Modifier.Node node, int selfKindSet, int phase) {
        if (phase != 0 || node.getShouldAutoInvalidate()) {
            boolean z = true;
            if (((selfKindSet & NodeKind.m4956constructorimpl(2)) != 0 ? 1 : 0) != 0 && (node instanceof LayoutModifierNode)) {
                LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode) node);
                if (phase == 2) {
                    DelegatableNodeKt.m4792requireCoordinator64DMado(node, NodeKind.m4956constructorimpl(2)).onRelease();
                }
            }
            if (((selfKindSet & NodeKind.m4956constructorimpl(256)) != 0 ? 1 : 0) != 0 && (node instanceof GlobalPositionAwareModifierNode)) {
                DelegatableNodeKt.requireLayoutNode(node).invalidateMeasurements$ui_release();
            }
            if (((selfKindSet & NodeKind.m4956constructorimpl(4)) != 0 ? 1 : 0) != 0 && (node instanceof DrawModifierNode)) {
                DrawModifierNodeKt.invalidateDraw((DrawModifierNode) node);
            }
            if (((selfKindSet & NodeKind.m4956constructorimpl(8)) != 0 ? 1 : 0) != 0 && (node instanceof SemanticsModifierNode)) {
                SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode) node);
            }
            if (((selfKindSet & NodeKind.m4956constructorimpl(64)) != 0 ? 1 : 0) != 0 && (node instanceof ParentDataModifierNode)) {
                ParentDataModifierNodeKt.invalidateParentData((ParentDataModifierNode) node);
            }
            if (((selfKindSet & NodeKind.m4956constructorimpl(1024)) != 0 ? 1 : 0) != 0 && (node instanceof FocusTargetNode)) {
                if (phase == 2) {
                    node.onReset();
                } else {
                    DelegatableNodeKt.requireOwner(node).getFocusOwner().scheduleInvalidation((FocusTargetNode) node);
                }
            }
            if (((selfKindSet & NodeKind.m4956constructorimpl(2048)) != 0 ? 1 : 0) != 0 && (node instanceof FocusPropertiesModifierNode) && specifiesCanFocusProperty((FocusPropertiesModifierNode) node)) {
                if (phase == 2) {
                    scheduleInvalidationOfAssociatedFocusTargets((FocusPropertiesModifierNode) node);
                } else {
                    FocusPropertiesModifierNodeKt.invalidateFocusProperties((FocusPropertiesModifierNode) node);
                }
            }
            if ((selfKindSet & NodeKind.m4956constructorimpl(4096)) == 0) {
                z = false;
            }
            if (z && (node instanceof FocusEventModifierNode)) {
                FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) node);
            }
        }
    }

    private static final void scheduleInvalidationOfAssociatedFocusTargets(FocusPropertiesModifierNode $this$scheduleInvalidationOfAssociatedFocusTargets) {
        boolean z;
        int type$iv;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv;
        boolean z2;
        boolean z3;
        int type$iv2;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv2;
        MutableVector mutableVector;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv3 = $this$scheduleInvalidationOfAssociatedFocusTargets;
        int type$iv3 = NodeKind.m4956constructorimpl(1024);
        boolean z4 = false;
        int mask$iv$iv = type$iv3;
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
                            int i = type$iv3;
                            boolean z5 = z4;
                            break;
                        } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            MutableVector mutableVector2 = null;
                            Modifier.Node this_$iv$iv$iv = node$iv$iv;
                            while (this_$iv$iv$iv != null) {
                                if (this_$iv$iv$iv instanceof FocusTargetNode) {
                                    FocusTargetNodeKt.invalidateFocusTarget((FocusTargetNode) this_$iv$iv$iv);
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                    type$iv = type$iv3;
                                    z = z4;
                                    z2 = true;
                                } else {
                                    if (!((this_$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0) || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                                        $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                        type$iv = type$iv3;
                                        z = z4;
                                        z2 = true;
                                    } else {
                                        int count$iv$iv = 0;
                                        Modifier.Node node$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                                        while (node$iv$iv$iv != null) {
                                            DelegatableNode next$iv$iv = node$iv$iv$iv;
                                            if ((next$iv$iv.getKindSet$ui_release() & type$iv3) != 0) {
                                                count$iv$iv++;
                                                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                if (count$iv$iv == 1) {
                                                    this_$iv$iv$iv = next$iv$iv;
                                                    type$iv2 = type$iv3;
                                                    z3 = z4;
                                                    Modifier.Node node = next$iv$iv;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        type$iv2 = type$iv3;
                                                        z3 = z4;
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        type$iv2 = type$iv3;
                                                        z3 = z4;
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
                                                z3 = z4;
                                                DelegatableNode $this$visitChildren_u2d6rFNWt0$iv4 = next$iv$iv;
                                            }
                                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                                            type$iv3 = type$iv2;
                                            z4 = z3;
                                        }
                                        $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                        type$iv = type$iv3;
                                        z = z4;
                                        z2 = true;
                                        if (count$iv$iv == 1) {
                                            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                                            type$iv3 = type$iv;
                                            z4 = z;
                                        }
                                    }
                                }
                                this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector2);
                                boolean z6 = z2;
                                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                                type$iv3 = type$iv;
                                z4 = z;
                            }
                            int i2 = type$iv3;
                            boolean z7 = z4;
                        } else {
                            int i3 = type$iv3;
                            boolean z8 = z4;
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv3;
                        }
                    }
                } else {
                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                }
            }
            return;
        }
        DelegatableNode delegatableNode = $this$visitChildren_u2d6rFNWt0$iv3;
        int i4 = type$iv3;
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode $this$specifiesCanFocusProperty) {
        CanFocusChecker.INSTANCE.reset();
        $this$specifiesCanFocusProperty.applyFocusProperties(CanFocusChecker.INSTANCE);
        return CanFocusChecker.INSTANCE.isCanFocusSet();
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (!(node instanceof DelegatingNode)) {
            return calculateNodeKindSetFrom(node);
        }
        int mask = ((DelegatingNode) node).getSelfKindSet$ui_release();
        for (Modifier.Node node$iv = ((DelegatingNode) node).getDelegate$ui_release(); node$iv != null; node$iv = node$iv.getChild$ui_release()) {
            mask |= calculateNodeKindSetFromIncludingDelegates(node$iv);
        }
        return mask;
    }
}

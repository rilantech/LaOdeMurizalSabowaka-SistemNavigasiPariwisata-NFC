package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001(B\u0005¢\u0006\u0002\u0010\u0005J5\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00150\u0019H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ5\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00150\u0019H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\r\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J\r\u0010\"\u001a\u00020\u0015H\u0000¢\u0006\u0002\b#J\b\u0010$\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020\u0015H\u0016J\r\u0010&\u001a\u00020\u0015H\u0000¢\u0006\u0002\b'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "beyondBoundsLayoutParent", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "getBeyondBoundsLayoutParent", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "focusState", "Landroidx/compose/ui/focus/FocusStateImpl;", "getFocusState$annotations", "getFocusState", "()Landroidx/compose/ui/focus/FocusStateImpl;", "setFocusState", "(Landroidx/compose/ui/focus/FocusStateImpl;)V", "isProcessingCustomEnter", "", "isProcessingCustomExit", "fetchCustomEnter", "", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusRequester;", "fetchCustomEnter-aToIllA$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "fetchCustomExit", "fetchCustomExit-aToIllA$ui_release", "fetchFocusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "fetchFocusProperties$ui_release", "invalidateFocus", "invalidateFocus$ui_release", "onObservedReadsChanged", "onReset", "scheduleInvalidationForFocusEvents", "scheduleInvalidationForFocusEvents$ui_release", "FocusTargetElement", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusTargetNode.kt */
public final class FocusTargetNode extends Modifier.Node implements FocusTargetModifierNode, ObserverModifierNode, ModifierLocalModifierNode {
    private FocusStateImpl focusState = FocusStateImpl.Inactive;
    /* access modifiers changed from: private */
    public boolean isProcessingCustomEnter;
    /* access modifiers changed from: private */
    public boolean isProcessingCustomExit;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusTargetNode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getFocusState$annotations() {
    }

    public FocusStateImpl getFocusState() {
        return this.focusState;
    }

    public void setFocusState(FocusStateImpl focusStateImpl) {
        Intrinsics.checkNotNullParameter(focusStateImpl, "<set-?>");
        this.focusState = focusStateImpl;
    }

    public final BeyondBoundsLayout getBeyondBoundsLayoutParent() {
        return (BeyondBoundsLayout) getCurrent(BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
    }

    public void onObservedReadsChanged() {
        FocusStateImpl previousFocusState = getFocusState();
        invalidateFocus$ui_release();
        if (previousFocusState != getFocusState()) {
            FocusEventModifierNodeKt.refreshFocusEventNodes(this);
        }
    }

    public void onReset() {
        switch (WhenMappings.$EnumSwitchMapping$0[getFocusState().ordinal()]) {
            case 1:
            case 2:
                DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
                return;
            case 3:
                scheduleInvalidationForFocusEvents$ui_release();
                setFocusState(FocusStateImpl.Inactive);
                return;
            case 4:
                scheduleInvalidationForFocusEvents$ui_release();
                return;
            default:
                return;
        }
    }

    public final FocusProperties fetchFocusProperties$ui_release() {
        int i;
        int type$iv;
        int untilType$iv;
        DelegatableNode $this$visitSelfAndAncestors_u2d5BbP62I$iv;
        NodeChain nodes$ui_release;
        int i2;
        int untilType$iv2;
        int type$iv2;
        DelegatableNode $this$visitSelfAndAncestors_u2d5BbP62I$iv2;
        int i3;
        int type$iv3;
        int untilType$iv3;
        int i4;
        DelegatingNode this_$iv$iv$iv;
        int type$iv4;
        int count$iv$iv;
        MutableVector mutableVector;
        FocusPropertiesImpl properties = new FocusPropertiesImpl();
        DelegatableNode $this$visitSelfAndAncestors_u2d5BbP62I$iv3 = this;
        int type$iv5 = NodeKind.m4956constructorimpl(2048);
        int untilType$iv4 = NodeKind.m4956constructorimpl(1024);
        int i5 = false;
        Modifier.Node self$iv = $this$visitSelfAndAncestors_u2d5BbP62I$iv3.getNode();
        int mask$iv$iv = type$iv5 | untilType$iv4;
        DelegatableNode $this$visitAncestors$iv$iv = $this$visitSelfAndAncestors_u2d5BbP62I$iv3;
        if ($this$visitAncestors$iv$iv.getNode().isAttached()) {
            Modifier.Node node$iv$iv = $this$visitAncestors$iv$iv.getNode();
            LayoutNode layout$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv);
            loop0:
            while (true) {
                if (layout$iv$iv == null) {
                    int i6 = type$iv5;
                    int i7 = untilType$iv4;
                    int i8 = i5;
                    break;
                }
                if ((layout$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                    while (node$iv$iv != null) {
                        if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            Modifier.Node it$iv = node$iv$iv;
                            if (it$iv != self$iv) {
                                if ((it$iv.getKindSet$ui_release() & untilType$iv2) != 0) {
                                    break loop0;
                                }
                            }
                            if ((it$iv.getKindSet$ui_release() & type$iv2) != 0) {
                                MutableVector mutableVector2 = null;
                                Modifier.Node this_$iv$iv$iv2 = it$iv;
                                while (this_$iv$iv$iv2 != null) {
                                    DelegatableNode $this$visitSelfAndAncestors_u2d5BbP62I$iv4 = $this$visitSelfAndAncestors_u2d5BbP62I$iv2;
                                    if (this_$iv$iv$iv2 instanceof FocusPropertiesModifierNode) {
                                        untilType$iv3 = untilType$iv2;
                                        ((FocusPropertiesModifierNode) this_$iv$iv$iv2).applyFocusProperties(properties);
                                        type$iv3 = type$iv2;
                                        i3 = i2;
                                    } else {
                                        untilType$iv3 = untilType$iv2;
                                        if (!((this_$iv$iv$iv2.getKindSet$ui_release() & type$iv2) != 0) || !(this_$iv$iv$iv2 instanceof DelegatingNode)) {
                                            type$iv3 = type$iv2;
                                            i3 = i2;
                                        } else {
                                            int count$iv$iv2 = 0;
                                            DelegatingNode this_$iv$iv$iv3 = (DelegatingNode) this_$iv$iv$iv2;
                                            Modifier.Node node$iv$iv$iv = this_$iv$iv$iv3.getDelegate$ui_release();
                                            while (node$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                if ((next$iv$iv.getKindSet$ui_release() & type$iv2) != 0) {
                                                    count$iv$iv2++;
                                                    type$iv4 = type$iv2;
                                                    if (count$iv$iv2 == 1) {
                                                        this_$iv$iv$iv2 = next$iv$iv;
                                                        this_$iv$iv$iv = this_$iv$iv$iv3;
                                                        i4 = i2;
                                                        Modifier.Node node = next$iv$iv;
                                                    } else {
                                                        if (mutableVector2 == null) {
                                                            count$iv$iv = count$iv$iv2;
                                                            this_$iv$iv$iv = this_$iv$iv$iv3;
                                                            i4 = i2;
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            count$iv$iv = count$iv$iv2;
                                                            this_$iv$iv$iv = this_$iv$iv$iv3;
                                                            i4 = i2;
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
                                                    type$iv4 = type$iv2;
                                                    this_$iv$iv$iv = this_$iv$iv$iv3;
                                                    i4 = i2;
                                                    Modifier.Node node2 = next$iv$iv;
                                                }
                                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                                type$iv2 = type$iv4;
                                                this_$iv$iv$iv3 = this_$iv$iv$iv;
                                                i2 = i4;
                                            }
                                            type$iv3 = type$iv2;
                                            DelegatingNode delegatingNode = this_$iv$iv$iv3;
                                            i3 = i2;
                                            if (count$iv$iv2 == 1) {
                                                $this$visitSelfAndAncestors_u2d5BbP62I$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv4;
                                                untilType$iv2 = untilType$iv3;
                                                type$iv2 = type$iv3;
                                                i2 = i3;
                                            }
                                        }
                                    }
                                    this_$iv$iv$iv2 = DelegatableNodeKt.pop(mutableVector2);
                                    $this$visitSelfAndAncestors_u2d5BbP62I$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv4;
                                    untilType$iv2 = untilType$iv3;
                                    type$iv2 = type$iv3;
                                    i2 = i3;
                                }
                            }
                        }
                        node$iv$iv = node$iv$iv.getParent$ui_release();
                        $this$visitSelfAndAncestors_u2d5BbP62I$iv3 = $this$visitSelfAndAncestors_u2d5BbP62I$iv2;
                        untilType$iv4 = untilType$iv2;
                        type$iv5 = type$iv2;
                        i5 = i2;
                    }
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = $this$visitSelfAndAncestors_u2d5BbP62I$iv2;
                    type$iv = type$iv2;
                    untilType$iv = untilType$iv2;
                    i = i2;
                } else {
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = $this$visitSelfAndAncestors_u2d5BbP62I$iv3;
                    type$iv = type$iv5;
                    untilType$iv = untilType$iv4;
                    i = i5;
                }
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                node$iv$iv = (layout$iv$iv == null || (nodes$ui_release = layout$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                $this$visitSelfAndAncestors_u2d5BbP62I$iv3 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                untilType$iv4 = untilType$iv;
                type$iv5 = type$iv;
                i5 = i;
            }
            return properties;
        }
        DelegatableNode delegatableNode = $this$visitSelfAndAncestors_u2d5BbP62I$iv3;
        int i9 = type$iv5;
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    /* renamed from: fetchCustomEnter-aToIllA$ui_release  reason: not valid java name */
    public final void m2949fetchCustomEnteraToIllA$ui_release(int focusDirection, Function1<? super FocusRequester, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (!this.isProcessingCustomEnter) {
            this.isProcessingCustomEnter = true;
            try {
                FocusRequester it = fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m2916boximpl(focusDirection));
                if (it != FocusRequester.Companion.getDefault()) {
                    block.invoke(it);
                }
            } finally {
                InlineMarker.finallyStart(1);
                this.isProcessingCustomEnter = false;
                InlineMarker.finallyEnd(1);
            }
        }
    }

    /* renamed from: fetchCustomExit-aToIllA$ui_release  reason: not valid java name */
    public final void m2950fetchCustomExitaToIllA$ui_release(int focusDirection, Function1<? super FocusRequester, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (!this.isProcessingCustomExit) {
            this.isProcessingCustomExit = true;
            try {
                FocusRequester it = fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.m2916boximpl(focusDirection));
                if (it != FocusRequester.Companion.getDefault()) {
                    block.invoke(it);
                }
            } finally {
                InlineMarker.finallyStart(1);
                this.isProcessingCustomExit = false;
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public final void invalidateFocus$ui_release() {
        FocusProperties focusProperties;
        switch (WhenMappings.$EnumSwitchMapping$0[getFocusState().ordinal()]) {
            case 1:
            case 2:
                Ref.ObjectRef focusProperties2 = new Ref.ObjectRef();
                ObserverModifierNodeKt.observeReads(this, new FocusTargetNode$invalidateFocus$1(focusProperties2, this));
                if (focusProperties2.element == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
                    focusProperties = null;
                } else {
                    focusProperties = (FocusProperties) focusProperties2.element;
                }
                if (!focusProperties.getCanFocus()) {
                    DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void scheduleInvalidationForFocusEvents$ui_release() {
        int i;
        boolean includeSelf$iv;
        int mask$iv;
        DelegatableNode $this$visitAncestors_u24default$iv;
        int i2;
        NodeChain nodes$ui_release;
        int i3;
        boolean includeSelf$iv2;
        int mask$iv2;
        DelegatableNode $this$visitAncestors_u24default$iv2;
        boolean includeSelf$iv3;
        int mask$iv3;
        DelegatableNode $this$visitAncestors_u24default$iv3;
        int i4;
        boolean includeSelf$iv4;
        int mask$iv4;
        DelegatableNode $this$visitAncestors_u24default$iv4;
        int capacity$iv$iv$iv;
        MutableVector mutableVector;
        MutableVector mutableVector2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv = getNode();
        int kind$iv = NodeKind.m4956constructorimpl(4096);
        MutableVector mutableVector3 = null;
        Modifier.Node this_$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv;
        while (true) {
            i = 0;
            int i5 = 1;
            if (this_$iv$iv == null) {
                break;
            }
            if (this_$iv$iv instanceof FocusEventModifierNode) {
                FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) this_$iv$iv);
            } else {
                if (((this_$iv$iv.getKindSet$ui_release() & kind$iv) != 0 ? 1 : null) != null && (this_$iv$iv instanceof DelegatingNode)) {
                    int count$iv = 0;
                    Modifier.Node node$iv$iv = ((DelegatingNode) this_$iv$iv).getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        Modifier.Node next$iv = node$iv$iv;
                        if (((next$iv.getKindSet$ui_release() & kind$iv) != 0 ? i5 : 0) != 0) {
                            count$iv++;
                            if (count$iv == i5) {
                                this_$iv$iv = next$iv;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                } else {
                                    mutableVector2 = mutableVector3;
                                }
                                mutableVector3 = mutableVector2;
                                Modifier.Node theNode$iv = this_$iv$iv;
                                if (theNode$iv != null) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(theNode$iv);
                                    }
                                    this_$iv$iv = null;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(next$iv);
                                }
                            }
                        }
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        i5 = 1;
                    }
                    if (count$iv == 1) {
                    }
                }
            }
            this_$iv$iv = DelegatableNodeKt.pop(mutableVector3);
        }
        DelegatableNode $this$visitAncestors_u24default$iv5 = this;
        int i6 = 1024;
        int mask$iv5 = NodeKind.m4956constructorimpl(4096) | NodeKind.m4956constructorimpl(1024);
        boolean includeSelf$iv5 = false;
        if ($this$visitAncestors_u24default$iv5.getNode().isAttached()) {
            Modifier.Node node$iv = $this$visitAncestors_u24default$iv5.getNode().getParent$ui_release();
            LayoutNode layout$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors_u24default$iv5);
            while (layout$iv != null) {
                if ((layout$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv5) != 0) {
                    while (node$iv != null) {
                        if ((node$iv.getKindSet$ui_release() & mask$iv2) != 0) {
                            Modifier.Node it = node$iv;
                            if (((it.getKindSet$ui_release() & NodeKind.m4956constructorimpl(i6)) != 0 ? 1 : i3) == 0 && it.isAttached()) {
                                int kind$iv2 = NodeKind.m4956constructorimpl(4096);
                                MutableVector mutableVector4 = null;
                                Modifier.Node this_$iv$iv2 = it;
                                while (this_$iv$iv2 != null) {
                                    if (this_$iv$iv2 instanceof FocusEventModifierNode) {
                                        FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) this_$iv$iv2);
                                        $this$visitAncestors_u24default$iv3 = $this$visitAncestors_u24default$iv2;
                                        mask$iv3 = mask$iv2;
                                        includeSelf$iv3 = includeSelf$iv2;
                                        i4 = i3;
                                    } else {
                                        if (((this_$iv$iv2.getKindSet$ui_release() & kind$iv2) != 0 ? 1 : i3) == 0 || !(this_$iv$iv2 instanceof DelegatingNode)) {
                                            $this$visitAncestors_u24default$iv3 = $this$visitAncestors_u24default$iv2;
                                            mask$iv3 = mask$iv2;
                                            includeSelf$iv3 = includeSelf$iv2;
                                            i4 = i3;
                                        } else {
                                            int count$iv2 = 0;
                                            Modifier.Node node$iv$iv2 = ((DelegatingNode) this_$iv$iv2).getDelegate$ui_release();
                                            while (node$iv$iv2 != null) {
                                                Modifier.Node next$iv2 = node$iv$iv2;
                                                if (((next$iv2.getKindSet$ui_release() & kind$iv2) != 0 ? 1 : i3) != 0) {
                                                    count$iv2++;
                                                    if (count$iv2 == 1) {
                                                        this_$iv$iv2 = next$iv2;
                                                        $this$visitAncestors_u24default$iv4 = $this$visitAncestors_u24default$iv2;
                                                        mask$iv4 = mask$iv2;
                                                        includeSelf$iv4 = includeSelf$iv2;
                                                        Modifier.Node node = next$iv2;
                                                        capacity$iv$iv$iv = 0;
                                                    } else {
                                                        if (mutableVector4 == null) {
                                                            $this$visitAncestors_u24default$iv4 = $this$visitAncestors_u24default$iv2;
                                                            mask$iv4 = mask$iv2;
                                                            includeSelf$iv4 = includeSelf$iv2;
                                                            capacity$iv$iv$iv = 0;
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            $this$visitAncestors_u24default$iv4 = $this$visitAncestors_u24default$iv2;
                                                            mask$iv4 = mask$iv2;
                                                            includeSelf$iv4 = includeSelf$iv2;
                                                            capacity$iv$iv$iv = 0;
                                                            mutableVector = mutableVector4;
                                                        }
                                                        mutableVector4 = mutableVector;
                                                        Modifier.Node theNode$iv2 = this_$iv$iv2;
                                                        if (theNode$iv2 != null) {
                                                            if (mutableVector4 != null) {
                                                                mutableVector4.add(theNode$iv2);
                                                            }
                                                            this_$iv$iv2 = null;
                                                        }
                                                        if (mutableVector4 != null) {
                                                            mutableVector4.add(next$iv2);
                                                        }
                                                    }
                                                } else {
                                                    $this$visitAncestors_u24default$iv4 = $this$visitAncestors_u24default$iv2;
                                                    mask$iv4 = mask$iv2;
                                                    includeSelf$iv4 = includeSelf$iv2;
                                                    capacity$iv$iv$iv = i3;
                                                    Modifier.Node node2 = next$iv2;
                                                }
                                                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                                                i3 = capacity$iv$iv$iv;
                                                $this$visitAncestors_u24default$iv2 = $this$visitAncestors_u24default$iv4;
                                                mask$iv2 = mask$iv4;
                                                includeSelf$iv2 = includeSelf$iv4;
                                            }
                                            $this$visitAncestors_u24default$iv3 = $this$visitAncestors_u24default$iv2;
                                            mask$iv3 = mask$iv2;
                                            includeSelf$iv3 = includeSelf$iv2;
                                            i4 = i3;
                                            if (count$iv2 == 1) {
                                                i3 = i4;
                                                $this$visitAncestors_u24default$iv2 = $this$visitAncestors_u24default$iv3;
                                                mask$iv2 = mask$iv3;
                                                includeSelf$iv2 = includeSelf$iv3;
                                            }
                                        }
                                    }
                                    this_$iv$iv2 = DelegatableNodeKt.pop(mutableVector4);
                                    i3 = i4;
                                    $this$visitAncestors_u24default$iv2 = $this$visitAncestors_u24default$iv3;
                                    mask$iv2 = mask$iv3;
                                    includeSelf$iv2 = includeSelf$iv3;
                                }
                            }
                        }
                        node$iv = node$iv.getParent$ui_release();
                        i = i3;
                        $this$visitAncestors_u24default$iv5 = $this$visitAncestors_u24default$iv2;
                        mask$iv5 = mask$iv2;
                        includeSelf$iv5 = includeSelf$iv2;
                        i6 = 1024;
                    }
                    $this$visitAncestors_u24default$iv = $this$visitAncestors_u24default$iv2;
                    mask$iv = mask$iv2;
                    includeSelf$iv = includeSelf$iv2;
                    i2 = i3;
                } else {
                    $this$visitAncestors_u24default$iv = $this$visitAncestors_u24default$iv5;
                    mask$iv = mask$iv5;
                    includeSelf$iv = includeSelf$iv5;
                    i2 = i;
                }
                layout$iv = layout$iv.getParent$ui_release();
                node$iv = (layout$iv == null || (nodes$ui_release = layout$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                i = i2;
                $this$visitAncestors_u24default$iv5 = $this$visitAncestors_u24default$iv;
                mask$iv5 = mask$iv;
                includeSelf$iv5 = includeSelf$iv;
                i6 = 1024;
            }
            return;
        }
        DelegatableNode delegatableNode = $this$visitAncestors_u24default$iv5;
        int i7 = mask$iv5;
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\f\u0010\u000e\u001a\u00020\f*\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode$FocusTargetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusTargetNode;", "()V", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusTargetNode.kt */
    public static final class FocusTargetElement extends ModifierNodeElement<FocusTargetNode> {
        public static final FocusTargetElement INSTANCE = new FocusTargetElement();

        private FocusTargetElement() {
        }

        public FocusTargetNode create() {
            return new FocusTargetNode();
        }

        public void update(FocusTargetNode node) {
            Intrinsics.checkNotNullParameter(node, "node");
        }

        public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
            Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
            $this$inspectableProperties.setName("focusTarget");
        }

        public int hashCode() {
            return "focusTarget".hashCode();
        }

        public boolean equals(Object other) {
            return other == this;
        }
    }
}

package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001d\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010!J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0016J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001d\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J\b\u0010.\u001a\u00020\u0005H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u000201H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u000202H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0014H\u0016J\b\u00103\u001a\u00020\u0005H\u0016J\u001d\u00104\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u0010-J\u000e\u00106\u001a\u0004\u0018\u000107*\u000208H\u0002J\\\u00109\u001a\u00020\u0005\"\n\b\u0000\u0010:\u0018\u0001*\u000208*\u0002082\f\u0010;\u001a\b\u0012\u0004\u0012\u0002H:0<2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00050\u0003H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006A"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function1;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui_release", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "clearFocus", "force", "", "refreshFocusEvents", "dispatchInterceptedSoftKeyboardEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchKeyEvent", "dispatchKeyEvent-ZmokQxo", "dispatchRotaryEvent", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "getFocusRect", "Landroidx/compose/ui/geometry/Rect;", "moveFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "takeFocus", "wrapAroundFocus", "wrapAroundFocus-3ESFkO8", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "traverseAncestors", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "onPreVisit", "onVisit", "traverseAncestors-Y-YKmho", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusOwnerImpl.kt */
public final class FocusOwnerImpl implements FocusOwner {
    private final FocusInvalidationManager focusInvalidationManager;
    public LayoutDirection layoutDirection;
    private final Modifier modifier;
    private FocusTargetNode rootFocusNode = new FocusTargetNode();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusOwnerImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public FocusOwnerImpl(Function1<? super Function0<Unit>, Unit> onRequestApplyChangesListener) {
        Intrinsics.checkNotNullParameter(onRequestApplyChangesListener, "onRequestApplyChangesListener");
        this.focusInvalidationManager = new FocusInvalidationManager(onRequestApplyChangesListener);
        this.modifier = new FocusOwnerImpl$modifier$1(this);
    }

    public final FocusTargetNode getRootFocusNode$ui_release() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui_release(FocusTargetNode focusTargetNode) {
        Intrinsics.checkNotNullParameter(focusTargetNode, "<set-?>");
        this.rootFocusNode = focusTargetNode;
    }

    public Modifier getModifier() {
        return this.modifier;
    }

    public LayoutDirection getLayoutDirection() {
        LayoutDirection layoutDirection2 = this.layoutDirection;
        if (layoutDirection2 != null) {
            return layoutDirection2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutDirection");
        return null;
    }

    public void setLayoutDirection(LayoutDirection layoutDirection2) {
        Intrinsics.checkNotNullParameter(layoutDirection2, "<set-?>");
        this.layoutDirection = layoutDirection2;
    }

    public void takeFocus() {
        if (this.rootFocusNode.getFocusState() == FocusStateImpl.Inactive) {
            this.rootFocusNode.setFocusState(FocusStateImpl.Active);
        }
    }

    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    public void clearFocus(boolean force) {
        clearFocus(force, true);
    }

    public void clearFocus(boolean force, boolean refreshFocusEvents) {
        FocusStateImpl focusStateImpl;
        if (!force) {
            switch (WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m4661performCustomClearFocusMxy_nc0(this.rootFocusNode, FocusDirection.Companion.m4639getExitdhqQ8s()).ordinal()]) {
                case 1:
                case 2:
                case 3:
                    return;
            }
        }
        FocusStateImpl rootInitialState = this.rootFocusNode.getFocusState();
        if (FocusTransactionsKt.clearFocus(this.rootFocusNode, force, refreshFocusEvents)) {
            FocusTargetNode focusTargetNode = this.rootFocusNode;
            switch (WhenMappings.$EnumSwitchMapping$1[rootInitialState.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    focusStateImpl = FocusStateImpl.Active;
                    break;
                case 4:
                    focusStateImpl = FocusStateImpl.Inactive;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            focusTargetNode.setFocusState(focusStateImpl);
        }
    }

    /* renamed from: moveFocus-3ESFkO8  reason: not valid java name */
    public boolean m4654moveFocus3ESFkO8(int focusDirection) {
        FocusTargetNode source = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (source == null) {
            return false;
        }
        FocusRequester it = FocusTraversalKt.m4665customFocusSearchOMvw8(source, focusDirection, getLayoutDirection());
        if (it == FocusRequester.Companion.getDefault()) {
            Ref.BooleanRef isCancelled = new Ref.BooleanRef();
            boolean foundNextItem = FocusTraversalKt.m4666focusSearchsMXa3k8(this.rootFocusNode, focusDirection, getLayoutDirection(), new FocusOwnerImpl$moveFocus$foundNextItem$1(source, focusDirection, isCancelled));
            if (isCancelled.element) {
                return false;
            }
            if (foundNextItem || m4651wrapAroundFocus3ESFkO8(focusDirection)) {
                return true;
            }
            return false;
        } else if (it == FocusRequester.Companion.getCancel() || !it.focus$ui_release()) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: dispatchKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m4653dispatchKeyEventZmokQxo(KeyEvent keyEvent) {
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        int type$iv;
        DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho$iv;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
        int type$iv2;
        DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho$iv2;
        MutableVector mutableVector;
        int i;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
        int i2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
        MutableVector mutableVector2;
        int i3;
        FocusOwnerImpl this_$iv;
        Modifier.Node focusedKeyInputNode;
        NodeChain nodes$ui_release;
        int i4;
        FocusOwnerImpl this_$iv2;
        Modifier.Node focusedKeyInputNode2;
        int i5;
        FocusOwnerImpl this_$iv3;
        int i6;
        FocusOwnerImpl this_$iv4;
        int count$iv$iv$iv$iv;
        MutableVector mutableVector3;
        KeyInputModifierNode keyInputModifierNode;
        FocusTargetNode activeFocusTarget;
        NodeChain nodes$ui_release2;
        int i7;
        FocusTargetNode activeFocusTarget2;
        FocusTargetNode activeFocusTarget3;
        FocusTargetNode activeFocusTarget4;
        MutableVector mutableVector4;
        KeyEvent keyEvent2 = keyEvent;
        Intrinsics.checkNotNullParameter(keyEvent2, "keyEvent");
        FocusTargetNode activeFocusTarget5 = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (activeFocusTarget5 != null) {
            Modifier.Node lastLocalKeyInputNode = lastLocalKeyInputNode(activeFocusTarget5);
            int i8 = 1;
            if (lastLocalKeyInputNode == null) {
                int type$iv3 = NodeKind.m6666constructorimpl(8192);
                int mask$iv$iv$iv = type$iv3;
                DelegatableNode $this$visitAncestors$iv$iv$iv = activeFocusTarget5;
                if ($this$visitAncestors$iv$iv$iv.getNode().isAttached()) {
                    Modifier.Node node$iv$iv$iv = $this$visitAncestors$iv$iv$iv.getNode().getParent$ui_release();
                    LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv$iv);
                    loop0:
                    while (true) {
                        if (layout$iv$iv$iv == null) {
                            keyInputModifierNode = null;
                            break;
                        }
                        if ((layout$iv$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                            while (node$iv$iv$iv != null) {
                                if ((node$iv$iv$iv.getKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                                    MutableVector mutableVector5 = null;
                                    Modifier.Node this_$iv$iv$iv$iv = node$iv$iv$iv;
                                    while (this_$iv$iv$iv$iv != null) {
                                        if (this_$iv$iv$iv$iv instanceof KeyInputModifierNode) {
                                            keyInputModifierNode = this_$iv$iv$iv$iv;
                                            FocusTargetNode focusTargetNode = activeFocusTarget2;
                                            break loop0;
                                        }
                                        if (((this_$iv$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? i7 : 0) == 0 || !(this_$iv$iv$iv$iv instanceof DelegatingNode)) {
                                            activeFocusTarget3 = activeFocusTarget2;
                                        } else {
                                            int count$iv$iv$iv = 0;
                                            Modifier.Node node$iv$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv$iv).getDelegate$ui_release();
                                            while (node$iv$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                                if (((next$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? i7 : 0) != 0) {
                                                    count$iv$iv$iv++;
                                                    if (count$iv$iv$iv == i7) {
                                                        this_$iv$iv$iv$iv = next$iv$iv$iv;
                                                        activeFocusTarget4 = activeFocusTarget2;
                                                        Modifier.Node node = next$iv$iv$iv;
                                                    } else {
                                                        if (mutableVector5 == null) {
                                                            activeFocusTarget4 = activeFocusTarget2;
                                                            mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            activeFocusTarget4 = activeFocusTarget2;
                                                            mutableVector4 = mutableVector5;
                                                        }
                                                        Modifier.Node theNode$iv$iv$iv = this_$iv$iv$iv$iv;
                                                        if (theNode$iv$iv$iv != null) {
                                                            if (mutableVector4 != null) {
                                                                mutableVector4.add(theNode$iv$iv$iv);
                                                            }
                                                            this_$iv$iv$iv$iv = null;
                                                        }
                                                        if (mutableVector4 != null) {
                                                            mutableVector4.add(next$iv$iv$iv);
                                                        }
                                                        mutableVector5 = mutableVector4;
                                                    }
                                                } else {
                                                    activeFocusTarget4 = activeFocusTarget2;
                                                    Modifier.Node node2 = next$iv$iv$iv;
                                                }
                                                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                                activeFocusTarget2 = activeFocusTarget4;
                                                i7 = 1;
                                            }
                                            activeFocusTarget3 = activeFocusTarget2;
                                            if (count$iv$iv$iv == 1) {
                                                activeFocusTarget2 = activeFocusTarget3;
                                                i7 = 1;
                                            }
                                        }
                                        this_$iv$iv$iv$iv = DelegatableNodeKt.pop(mutableVector5);
                                        activeFocusTarget2 = activeFocusTarget3;
                                        i7 = 1;
                                    }
                                    continue;
                                }
                                node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                                i8 = 1;
                                activeFocusTarget5 = activeFocusTarget2;
                            }
                            activeFocusTarget = activeFocusTarget2;
                        } else {
                            activeFocusTarget = activeFocusTarget5;
                        }
                        layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                        node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes$ui_release2 = layout$iv$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
                        i8 = 1;
                        activeFocusTarget5 = activeFocusTarget;
                    }
                    KeyInputModifierNode keyInputModifierNode2 = keyInputModifierNode;
                    lastLocalKeyInputNode = keyInputModifierNode2 != null ? keyInputModifierNode2.getNode() : null;
                } else {
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
            }
            Modifier.Node focusedKeyInputNode3 = lastLocalKeyInputNode;
            if (focusedKeyInputNode3 != null) {
                DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho$iv3 = focusedKeyInputNode3;
                int type$iv4 = NodeKind.m6666constructorimpl(8192);
                FocusOwnerImpl this_$iv5 = this;
                int i9 = false;
                List list = null;
                int mask$iv$iv$iv$iv = type$iv4;
                DelegatableNode $this$visitAncestors$iv$iv$iv$iv = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                if ($this$visitAncestors$iv$iv$iv$iv.getNode().isAttached()) {
                    Modifier.Node node$iv$iv$iv$iv2 = $this$visitAncestors$iv$iv$iv$iv.getNode().getParent$ui_release();
                    LayoutNode layout$iv$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv$iv$iv);
                    while (layout$iv$iv$iv$iv != null) {
                        if ((layout$iv$iv$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv$iv$iv) != 0) {
                            while (node$iv$iv$iv$iv2 != null) {
                                if ((node$iv$iv$iv$iv2.getKindSet$ui_release() & mask$iv$iv$iv$iv) != 0) {
                                    MutableVector mutableVector6 = null;
                                    Object this_$iv$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                    while (this_$iv$iv$iv$iv$iv != null) {
                                        Modifier.Node focusedKeyInputNode4 = focusedKeyInputNode2;
                                        if (this_$iv$iv$iv$iv$iv instanceof KeyInputModifierNode) {
                                            Object it$iv$iv = this_$iv$iv$iv$iv$iv;
                                            if (list == null) {
                                                list = (List) new ArrayList();
                                            }
                                            list.add(it$iv$iv);
                                            this_$iv3 = this_$iv2;
                                            i5 = i4;
                                        } else {
                                            if (!((this_$iv$iv$iv$iv$iv.getKindSet$ui_release() & type$iv4) != 0) || !(this_$iv$iv$iv$iv$iv instanceof DelegatingNode)) {
                                                this_$iv3 = this_$iv2;
                                                i5 = i4;
                                            } else {
                                                int count$iv$iv$iv$iv2 = 0;
                                                Modifier.Node node$iv$iv$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv$iv$iv).getDelegate$ui_release();
                                                while (node$iv$iv$iv$iv$iv != null) {
                                                    Modifier.Node next$iv$iv$iv$iv = node$iv$iv$iv$iv$iv;
                                                    if ((next$iv$iv$iv$iv.getKindSet$ui_release() & type$iv4) != 0) {
                                                        count$iv$iv$iv$iv2++;
                                                        this_$iv4 = this_$iv2;
                                                        if (count$iv$iv$iv$iv2 == 1) {
                                                            this_$iv$iv$iv$iv$iv = next$iv$iv$iv$iv;
                                                            i6 = i4;
                                                            Modifier.Node node3 = next$iv$iv$iv$iv;
                                                        } else {
                                                            if (mutableVector6 == null) {
                                                                count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                                                i6 = i4;
                                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                            } else {
                                                                count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                                                i6 = i4;
                                                                mutableVector3 = mutableVector6;
                                                            }
                                                            MutableVector mutableVector7 = mutableVector3;
                                                            Modifier.Node theNode$iv$iv$iv$iv = this_$iv$iv$iv$iv$iv;
                                                            if (theNode$iv$iv$iv$iv != null) {
                                                                if (mutableVector7 != null) {
                                                                    mutableVector7.add(theNode$iv$iv$iv$iv);
                                                                }
                                                                this_$iv$iv$iv$iv$iv = null;
                                                            }
                                                            if (mutableVector7 != null) {
                                                                mutableVector7.add(next$iv$iv$iv$iv);
                                                            }
                                                            mutableVector6 = mutableVector7;
                                                            count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                                        }
                                                    } else {
                                                        this_$iv4 = this_$iv2;
                                                        i6 = i4;
                                                        Modifier.Node node4 = next$iv$iv$iv$iv;
                                                    }
                                                    node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                                    this_$iv2 = this_$iv4;
                                                    i4 = i6;
                                                }
                                                this_$iv3 = this_$iv2;
                                                i5 = i4;
                                                if (count$iv$iv$iv$iv2 == 1) {
                                                    focusedKeyInputNode2 = focusedKeyInputNode4;
                                                    this_$iv2 = this_$iv3;
                                                    i4 = i5;
                                                }
                                            }
                                        }
                                        this_$iv$iv$iv$iv$iv = DelegatableNodeKt.pop(mutableVector6);
                                        focusedKeyInputNode2 = focusedKeyInputNode4;
                                        this_$iv2 = this_$iv3;
                                        i4 = i5;
                                    }
                                }
                                node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getParent$ui_release();
                                focusedKeyInputNode3 = focusedKeyInputNode2;
                                this_$iv5 = this_$iv2;
                                i9 = i4;
                            }
                            focusedKeyInputNode = focusedKeyInputNode2;
                            this_$iv = this_$iv2;
                            i3 = i4;
                        } else {
                            focusedKeyInputNode = focusedKeyInputNode3;
                            this_$iv = this_$iv5;
                            i3 = i9;
                        }
                        layout$iv$iv$iv$iv = layout$iv$iv$iv$iv.getParent$ui_release();
                        node$iv$iv$iv$iv2 = (layout$iv$iv$iv$iv == null || (nodes$ui_release = layout$iv$iv$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                        focusedKeyInputNode3 = focusedKeyInputNode;
                        this_$iv5 = this_$iv;
                        i9 = i3;
                    }
                    FocusOwnerImpl focusOwnerImpl = this_$iv5;
                    int i10 = i9;
                    List ancestors$iv = list;
                    if (ancestors$iv != null) {
                        List $this$fastForEachReversed$iv$iv = ancestors$iv;
                        int size = $this$fastForEachReversed$iv$iv.size() - 1;
                        if (size >= 0) {
                            do {
                                int index$iv$iv = size;
                                size--;
                                if (((KeyInputModifierNode) $this$fastForEachReversed$iv$iv.get(index$iv$iv)).m6051onPreKeyEventZmokQxo(keyEvent2)) {
                                    return true;
                                }
                            } while (size >= 0);
                        }
                    }
                    Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$traverseAncestors_u2dY_u2dYKmho$iv3.getNode();
                    int i11 = false;
                    MutableVector mutableVector8 = null;
                    Modifier.Node this_$iv$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                    while (this_$iv$iv$iv != null) {
                        if (!(this_$iv$iv$iv instanceof KeyInputModifierNode)) {
                            if (!((this_$iv$iv$iv.getKindSet$ui_release() & type$iv4) != 0) || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                i = i11;
                            } else {
                                int count$iv$iv = 0;
                                Modifier.Node node$iv$iv$iv2 = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                                while (node$iv$iv$iv2 != null) {
                                    Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                    if ((next$iv$iv.getKindSet$ui_release() & type$iv4) != 0) {
                                        count$iv$iv++;
                                        if (count$iv$iv == 1) {
                                            this_$iv$iv$iv = next$iv$iv;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                            i2 = i11;
                                        } else {
                                            if (mutableVector8 == null) {
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                                i2 = i11;
                                                MutableVector mutableVector9 = mutableVector8;
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                                i2 = i11;
                                                mutableVector2 = mutableVector8;
                                            }
                                            mutableVector8 = mutableVector2;
                                            Modifier.Node theNode$iv$iv = this_$iv$iv$iv;
                                            if (theNode$iv$iv != null) {
                                                if (mutableVector8 != null) {
                                                    mutableVector8.add(theNode$iv$iv);
                                                }
                                                this_$iv$iv$iv = null;
                                            }
                                            if (mutableVector8 != null) {
                                                mutableVector8.add(next$iv$iv);
                                            }
                                        }
                                    } else {
                                        $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                        i2 = i11;
                                        MutableVector mutableVector10 = mutableVector8;
                                    }
                                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                                    i11 = i2;
                                }
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                i = i11;
                                MutableVector mutableVector11 = mutableVector8;
                                if (count$iv$iv == 1) {
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                                    i11 = i;
                                    mutableVector8 = mutableVector11;
                                } else {
                                    mutableVector8 = mutableVector11;
                                }
                            }
                        } else if (((KeyInputModifierNode) this_$iv$iv$iv).m6051onPreKeyEventZmokQxo(keyEvent2)) {
                            return true;
                        } else {
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                            i = i11;
                        }
                        this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector8);
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                        i11 = i;
                    }
                    int i12 = i11;
                    Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$traverseAncestors_u2dY_u2dYKmho$iv3.getNode();
                    MutableVector mutableVector12 = null;
                    Modifier.Node this_$iv$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                    while (this_$iv$iv$iv2 != null) {
                        if (!(this_$iv$iv$iv2 instanceof KeyInputModifierNode)) {
                            if (!((this_$iv$iv$iv2.getKindSet$ui_release() & type$iv4) != 0) || !(this_$iv$iv$iv2 instanceof DelegatingNode)) {
                                $this$traverseAncestors_u2dY_u2dYKmho$iv = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                                type$iv = type$iv4;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                            } else {
                                int count$iv$iv2 = 0;
                                Modifier.Node node$iv$iv$iv3 = ((DelegatingNode) this_$iv$iv$iv2).getDelegate$ui_release();
                                while (node$iv$iv$iv3 != null) {
                                    Modifier.Node next$iv$iv2 = node$iv$iv$iv3;
                                    if ((next$iv$iv2.getKindSet$ui_release() & type$iv4) != 0) {
                                        count$iv$iv2++;
                                        if (count$iv$iv2 == 1) {
                                            this_$iv$iv$iv2 = next$iv$iv2;
                                            $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                                            type$iv2 = type$iv4;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                        } else {
                                            if (mutableVector12 == null) {
                                                $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                                                type$iv2 = type$iv4;
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                                                type$iv2 = type$iv4;
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                                mutableVector = mutableVector12;
                                            }
                                            mutableVector12 = mutableVector;
                                            Modifier.Node theNode$iv$iv2 = this_$iv$iv$iv2;
                                            if (theNode$iv$iv2 != null) {
                                                if (mutableVector12 != null) {
                                                    mutableVector12.add(theNode$iv$iv2);
                                                }
                                                this_$iv$iv$iv2 = null;
                                            }
                                            if (mutableVector12 != null) {
                                                mutableVector12.add(next$iv$iv2);
                                            }
                                        }
                                    } else {
                                        $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                                        type$iv2 = type$iv4;
                                        $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                    }
                                    node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                                    $this$traverseAncestors_u2dY_u2dYKmho$iv3 = $this$traverseAncestors_u2dY_u2dYKmho$iv2;
                                    type$iv4 = type$iv2;
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                                }
                                $this$traverseAncestors_u2dY_u2dYKmho$iv = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                                type$iv = type$iv4;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                if (count$iv$iv2 == 1) {
                                    $this$traverseAncestors_u2dY_u2dYKmho$iv3 = $this$traverseAncestors_u2dY_u2dYKmho$iv;
                                    type$iv4 = type$iv;
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                                }
                            }
                        } else if (((KeyInputModifierNode) this_$iv$iv$iv2).m6050onKeyEventZmokQxo(keyEvent2)) {
                            return true;
                        } else {
                            $this$traverseAncestors_u2dY_u2dYKmho$iv = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                            type$iv = type$iv4;
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                        }
                        this_$iv$iv$iv2 = DelegatableNodeKt.pop(mutableVector12);
                        $this$traverseAncestors_u2dY_u2dYKmho$iv3 = $this$traverseAncestors_u2dY_u2dYKmho$iv;
                        type$iv4 = type$iv;
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                    }
                    int i13 = type$iv4;
                    Modifier.Node node5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                    if (ancestors$iv == null) {
                        return false;
                    }
                    List $this$fastForEach$iv$iv = ancestors$iv;
                    int size2 = $this$fastForEach$iv$iv.size();
                    for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                        if (((KeyInputModifierNode) $this$fastForEach$iv$iv.get(index$iv$iv2)).m6050onKeyEventZmokQxo(keyEvent2)) {
                            return true;
                        }
                    }
                    return false;
                }
                DelegatableNode delegatableNode = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            return false;
        }
        throw new IllegalStateException("Event can't be processed because we do not have an active focus target.".toString());
    }

    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo  reason: not valid java name */
    public boolean m4652dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent) {
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode;
        int type$iv;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho$iv;
        int type$iv2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
        DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho$iv2;
        MutableVector mutableVector;
        int i;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
        int i2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
        MutableVector mutableVector2;
        int i3;
        FocusOwnerImpl this_$iv;
        SoftKeyboardInterceptionModifierNode focusedSoftKeyboardInterceptionNode;
        NodeChain nodes$ui_release;
        int i4;
        FocusOwnerImpl this_$iv2;
        SoftKeyboardInterceptionModifierNode focusedSoftKeyboardInterceptionNode2;
        int i5;
        FocusOwnerImpl this_$iv3;
        int i6;
        FocusOwnerImpl this_$iv4;
        int count$iv$iv$iv$iv;
        MutableVector mutableVector3;
        Modifier.Node node;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        NodeChain nodes$ui_release2;
        int i7;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv4;
        MutableVector mutableVector4;
        KeyEvent keyEvent2 = keyEvent;
        Intrinsics.checkNotNullParameter(keyEvent2, "keyEvent");
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        int i8 = 1;
        if (findActiveFocusNode != null) {
            DelegatableNode $this$nearestAncestor_u2d64DMado$iv5 = findActiveFocusNode;
            int type$iv3 = NodeKind.m6666constructorimpl(131072);
            int mask$iv$iv$iv = type$iv3;
            DelegatableNode $this$visitAncestors$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv5;
            if ($this$visitAncestors$iv$iv$iv.getNode().isAttached()) {
                Modifier.Node node$iv$iv$iv = $this$visitAncestors$iv$iv$iv.getNode().getParent$ui_release();
                LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv$iv);
                loop0:
                while (true) {
                    if (layout$iv$iv$iv == null) {
                        node = null;
                        break;
                    }
                    if ((layout$iv$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                        while (node$iv$iv$iv != null) {
                            if ((node$iv$iv$iv.getKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                                MutableVector mutableVector5 = null;
                                Modifier.Node this_$iv$iv$iv$iv = node$iv$iv$iv;
                                while (this_$iv$iv$iv$iv != null) {
                                    if (this_$iv$iv$iv$iv instanceof SoftKeyboardInterceptionModifierNode) {
                                        node = this_$iv$iv$iv$iv;
                                        break loop0;
                                    }
                                    if (((this_$iv$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? i7 : 0) == 0 || !(this_$iv$iv$iv$iv instanceof DelegatingNode)) {
                                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                                    } else {
                                        int count$iv$iv$iv = 0;
                                        Modifier.Node node$iv$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv$iv).getDelegate$ui_release();
                                        while (node$iv$iv$iv$iv != null) {
                                            Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                            if (((next$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? i7 : 0) != 0) {
                                                count$iv$iv$iv++;
                                                if (count$iv$iv$iv == i7) {
                                                    this_$iv$iv$iv$iv = next$iv$iv$iv;
                                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                    Modifier.Node node2 = next$iv$iv$iv;
                                                } else {
                                                    if (mutableVector5 == null) {
                                                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                        mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                        mutableVector4 = mutableVector5;
                                                    }
                                                    Modifier.Node theNode$iv$iv$iv = this_$iv$iv$iv$iv;
                                                    if (theNode$iv$iv$iv != null) {
                                                        if (mutableVector4 != null) {
                                                            mutableVector4.add(theNode$iv$iv$iv);
                                                        }
                                                        this_$iv$iv$iv$iv = null;
                                                    }
                                                    if (mutableVector4 != null) {
                                                        mutableVector4.add(next$iv$iv$iv);
                                                    }
                                                    mutableVector5 = mutableVector4;
                                                }
                                            } else {
                                                $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                Modifier.Node node3 = next$iv$iv$iv;
                                            }
                                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                            $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                            i7 = 1;
                                        }
                                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                                        if (count$iv$iv$iv == 1) {
                                            $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                                            i7 = 1;
                                        }
                                    }
                                    this_$iv$iv$iv$iv = DelegatableNodeKt.pop(mutableVector5);
                                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                                    i7 = 1;
                                }
                                continue;
                            }
                            node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                            $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv2;
                            i8 = 1;
                        }
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    } else {
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv5;
                    }
                    layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                    node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes$ui_release2 = layout$iv$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
                    $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv;
                    i8 = 1;
                }
                softKeyboardInterceptionModifierNode = (SoftKeyboardInterceptionModifierNode) node;
            } else {
                DelegatableNode delegatableNode = $this$nearestAncestor_u2d64DMado$iv5;
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
        } else {
            softKeyboardInterceptionModifierNode = null;
        }
        SoftKeyboardInterceptionModifierNode focusedSoftKeyboardInterceptionNode3 = softKeyboardInterceptionModifierNode;
        if (focusedSoftKeyboardInterceptionNode3 != null) {
            DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho$iv3 = focusedSoftKeyboardInterceptionNode3;
            int type$iv4 = NodeKind.m6666constructorimpl(131072);
            FocusOwnerImpl this_$iv5 = this;
            int i9 = false;
            List list = null;
            int mask$iv$iv$iv$iv = type$iv4;
            DelegatableNode $this$visitAncestors$iv$iv$iv$iv = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
            if ($this$visitAncestors$iv$iv$iv$iv.getNode().isAttached()) {
                Modifier.Node node$iv$iv$iv$iv2 = $this$visitAncestors$iv$iv$iv$iv.getNode().getParent$ui_release();
                LayoutNode layout$iv$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv$iv$iv);
                while (layout$iv$iv$iv$iv != null) {
                    if ((layout$iv$iv$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv$iv$iv) != 0) {
                        while (node$iv$iv$iv$iv2 != null) {
                            if ((node$iv$iv$iv$iv2.getKindSet$ui_release() & mask$iv$iv$iv$iv) != 0) {
                                MutableVector mutableVector6 = null;
                                Object this_$iv$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                while (this_$iv$iv$iv$iv$iv != null) {
                                    SoftKeyboardInterceptionModifierNode focusedSoftKeyboardInterceptionNode4 = focusedSoftKeyboardInterceptionNode2;
                                    if (this_$iv$iv$iv$iv$iv instanceof SoftKeyboardInterceptionModifierNode) {
                                        Object it$iv$iv = this_$iv$iv$iv$iv$iv;
                                        if (list == null) {
                                            list = (List) new ArrayList();
                                        }
                                        list.add(it$iv$iv);
                                        this_$iv3 = this_$iv2;
                                        i5 = i4;
                                    } else {
                                        if (!((this_$iv$iv$iv$iv$iv.getKindSet$ui_release() & type$iv4) != 0) || !(this_$iv$iv$iv$iv$iv instanceof DelegatingNode)) {
                                            this_$iv3 = this_$iv2;
                                            i5 = i4;
                                        } else {
                                            int count$iv$iv$iv$iv2 = 0;
                                            Modifier.Node node$iv$iv$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv$iv$iv).getDelegate$ui_release();
                                            while (node$iv$iv$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv$iv$iv = node$iv$iv$iv$iv$iv;
                                                if ((next$iv$iv$iv$iv.getKindSet$ui_release() & type$iv4) != 0) {
                                                    count$iv$iv$iv$iv2++;
                                                    this_$iv4 = this_$iv2;
                                                    if (count$iv$iv$iv$iv2 == 1) {
                                                        this_$iv$iv$iv$iv$iv = next$iv$iv$iv$iv;
                                                        i6 = i4;
                                                        Modifier.Node node4 = next$iv$iv$iv$iv;
                                                    } else {
                                                        if (mutableVector6 == null) {
                                                            count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                                            i6 = i4;
                                                            mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                                            i6 = i4;
                                                            mutableVector3 = mutableVector6;
                                                        }
                                                        MutableVector mutableVector7 = mutableVector3;
                                                        Modifier.Node theNode$iv$iv$iv$iv = this_$iv$iv$iv$iv$iv;
                                                        if (theNode$iv$iv$iv$iv != null) {
                                                            if (mutableVector7 != null) {
                                                                mutableVector7.add(theNode$iv$iv$iv$iv);
                                                            }
                                                            this_$iv$iv$iv$iv$iv = null;
                                                        }
                                                        if (mutableVector7 != null) {
                                                            mutableVector7.add(next$iv$iv$iv$iv);
                                                        }
                                                        mutableVector6 = mutableVector7;
                                                        count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                                    }
                                                } else {
                                                    this_$iv4 = this_$iv2;
                                                    i6 = i4;
                                                    Modifier.Node node5 = next$iv$iv$iv$iv;
                                                }
                                                node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                                this_$iv2 = this_$iv4;
                                                i4 = i6;
                                            }
                                            this_$iv3 = this_$iv2;
                                            i5 = i4;
                                            if (count$iv$iv$iv$iv2 == 1) {
                                                focusedSoftKeyboardInterceptionNode2 = focusedSoftKeyboardInterceptionNode4;
                                                this_$iv2 = this_$iv3;
                                                i4 = i5;
                                            }
                                        }
                                    }
                                    this_$iv$iv$iv$iv$iv = DelegatableNodeKt.pop(mutableVector6);
                                    focusedSoftKeyboardInterceptionNode2 = focusedSoftKeyboardInterceptionNode4;
                                    this_$iv2 = this_$iv3;
                                    i4 = i5;
                                }
                            }
                            node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getParent$ui_release();
                            focusedSoftKeyboardInterceptionNode3 = focusedSoftKeyboardInterceptionNode2;
                            this_$iv5 = this_$iv2;
                            i9 = i4;
                        }
                        focusedSoftKeyboardInterceptionNode = focusedSoftKeyboardInterceptionNode2;
                        this_$iv = this_$iv2;
                        i3 = i4;
                    } else {
                        focusedSoftKeyboardInterceptionNode = focusedSoftKeyboardInterceptionNode3;
                        this_$iv = this_$iv5;
                        i3 = i9;
                    }
                    layout$iv$iv$iv$iv = layout$iv$iv$iv$iv.getParent$ui_release();
                    node$iv$iv$iv$iv2 = (layout$iv$iv$iv$iv == null || (nodes$ui_release = layout$iv$iv$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                    focusedSoftKeyboardInterceptionNode3 = focusedSoftKeyboardInterceptionNode;
                    this_$iv5 = this_$iv;
                    i9 = i3;
                }
                FocusOwnerImpl focusOwnerImpl = this_$iv5;
                int i10 = i9;
                List ancestors$iv = list;
                if (ancestors$iv != null) {
                    List $this$fastForEachReversed$iv$iv = ancestors$iv;
                    int size = $this$fastForEachReversed$iv$iv.size() - 1;
                    if (size >= 0) {
                        do {
                            int index$iv$iv = size;
                            size--;
                            if (((SoftKeyboardInterceptionModifierNode) $this$fastForEachReversed$iv$iv.get(index$iv$iv)).m6056onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent2)) {
                                return true;
                            }
                        } while (size >= 0);
                    }
                }
                Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$traverseAncestors_u2dY_u2dYKmho$iv3.getNode();
                int i11 = false;
                MutableVector mutableVector8 = null;
                Modifier.Node this_$iv$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                while (this_$iv$iv$iv != null) {
                    if (!(this_$iv$iv$iv instanceof SoftKeyboardInterceptionModifierNode)) {
                        if (!((this_$iv$iv$iv.getKindSet$ui_release() & type$iv4) != 0) || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                            i = i11;
                        } else {
                            int count$iv$iv = 0;
                            Modifier.Node node$iv$iv$iv2 = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                            while (node$iv$iv$iv2 != null) {
                                Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                if ((next$iv$iv.getKindSet$ui_release() & type$iv4) != 0) {
                                    count$iv$iv++;
                                    if (count$iv$iv == 1) {
                                        this_$iv$iv$iv = next$iv$iv;
                                        $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                        i2 = i11;
                                    } else {
                                        if (mutableVector8 == null) {
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                            i2 = i11;
                                            MutableVector mutableVector9 = mutableVector8;
                                            mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                        } else {
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                            i2 = i11;
                                            mutableVector2 = mutableVector8;
                                        }
                                        mutableVector8 = mutableVector2;
                                        Modifier.Node theNode$iv$iv = this_$iv$iv$iv;
                                        if (theNode$iv$iv != null) {
                                            if (mutableVector8 != null) {
                                                mutableVector8.add(theNode$iv$iv);
                                            }
                                            this_$iv$iv$iv = null;
                                        }
                                        if (mutableVector8 != null) {
                                            mutableVector8.add(next$iv$iv);
                                        }
                                    }
                                } else {
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                    i2 = i11;
                                    MutableVector mutableVector10 = mutableVector8;
                                }
                                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                                i11 = i2;
                            }
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                            i = i11;
                            MutableVector mutableVector11 = mutableVector8;
                            if (count$iv$iv == 1) {
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                                i11 = i;
                                mutableVector8 = mutableVector11;
                            } else {
                                mutableVector8 = mutableVector11;
                            }
                        }
                    } else if (((SoftKeyboardInterceptionModifierNode) this_$iv$iv$iv).m6056onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent2)) {
                        return true;
                    } else {
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                        i = i11;
                    }
                    this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector8);
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                    i11 = i;
                }
                int i12 = i11;
                Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$traverseAncestors_u2dY_u2dYKmho$iv3.getNode();
                MutableVector mutableVector12 = null;
                Modifier.Node this_$iv$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                while (this_$iv$iv$iv2 != null) {
                    if (!(this_$iv$iv$iv2 instanceof SoftKeyboardInterceptionModifierNode)) {
                        if (!((this_$iv$iv$iv2.getKindSet$ui_release() & type$iv4) != 0) || !(this_$iv$iv$iv2 instanceof DelegatingNode)) {
                            $this$traverseAncestors_u2dY_u2dYKmho$iv = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                            type$iv = type$iv4;
                        } else {
                            int count$iv$iv2 = 0;
                            Modifier.Node node$iv$iv$iv3 = ((DelegatingNode) this_$iv$iv$iv2).getDelegate$ui_release();
                            while (node$iv$iv$iv3 != null) {
                                Modifier.Node next$iv$iv2 = node$iv$iv$iv3;
                                if ((next$iv$iv2.getKindSet$ui_release() & type$iv4) != 0) {
                                    count$iv$iv2++;
                                    if (count$iv$iv2 == 1) {
                                        this_$iv$iv$iv2 = next$iv$iv2;
                                        $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                                        $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                        type$iv2 = type$iv4;
                                    } else {
                                        if (mutableVector12 == null) {
                                            $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                            type$iv2 = type$iv4;
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        } else {
                                            $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                            type$iv2 = type$iv4;
                                            mutableVector = mutableVector12;
                                        }
                                        mutableVector12 = mutableVector;
                                        Modifier.Node theNode$iv$iv2 = this_$iv$iv$iv2;
                                        if (theNode$iv$iv2 != null) {
                                            if (mutableVector12 != null) {
                                                mutableVector12.add(theNode$iv$iv2);
                                            }
                                            this_$iv$iv$iv2 = null;
                                        }
                                        if (mutableVector12 != null) {
                                            mutableVector12.add(next$iv$iv2);
                                        }
                                    }
                                } else {
                                    $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                    type$iv2 = type$iv4;
                                }
                                node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                                $this$traverseAncestors_u2dY_u2dYKmho$iv3 = $this$traverseAncestors_u2dY_u2dYKmho$iv2;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                                type$iv4 = type$iv2;
                            }
                            $this$traverseAncestors_u2dY_u2dYKmho$iv = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                            type$iv = type$iv4;
                            if (count$iv$iv2 == 1) {
                                $this$traverseAncestors_u2dY_u2dYKmho$iv3 = $this$traverseAncestors_u2dY_u2dYKmho$iv;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                                type$iv4 = type$iv;
                            }
                        }
                    } else if (((SoftKeyboardInterceptionModifierNode) this_$iv$iv$iv2).m6055onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent2)) {
                        return true;
                    } else {
                        $this$traverseAncestors_u2dY_u2dYKmho$iv = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                        type$iv = type$iv4;
                    }
                    this_$iv$iv$iv2 = DelegatableNodeKt.pop(mutableVector12);
                    $this$traverseAncestors_u2dY_u2dYKmho$iv3 = $this$traverseAncestors_u2dY_u2dYKmho$iv;
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                    type$iv4 = type$iv;
                }
                Modifier.Node node6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                int i13 = type$iv4;
                if (ancestors$iv == null) {
                    return false;
                }
                List $this$fastForEach$iv$iv = ancestors$iv;
                int size2 = $this$fastForEach$iv$iv.size();
                for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                    if (((SoftKeyboardInterceptionModifierNode) $this$fastForEach$iv$iv.get(index$iv$iv2)).m6055onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent2)) {
                        return true;
                    }
                }
                return false;
            }
            DelegatableNode delegatableNode2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        return false;
    }

    public boolean dispatchRotaryEvent(RotaryScrollEvent event) {
        RotaryInputModifierNode rotaryInputModifierNode;
        int type$iv;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho$iv;
        int type$iv2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
        DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho$iv2;
        MutableVector mutableVector;
        int i;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
        int i2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
        MutableVector mutableVector2;
        int i3;
        FocusOwnerImpl this_$iv;
        RotaryInputModifierNode focusedRotaryInputNode;
        NodeChain nodes$ui_release;
        int i4;
        FocusOwnerImpl this_$iv2;
        RotaryInputModifierNode focusedRotaryInputNode2;
        int i5;
        FocusOwnerImpl this_$iv3;
        int i6;
        FocusOwnerImpl this_$iv4;
        int count$iv$iv$iv$iv;
        MutableVector mutableVector3;
        Modifier.Node node;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        NodeChain nodes$ui_release2;
        int i7;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv4;
        MutableVector mutableVector4;
        RotaryScrollEvent rotaryScrollEvent = event;
        Intrinsics.checkNotNullParameter(rotaryScrollEvent, NotificationCompat.CATEGORY_EVENT);
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        int i8 = 1;
        if (findActiveFocusNode != null) {
            DelegatableNode $this$nearestAncestor_u2d64DMado$iv5 = findActiveFocusNode;
            int type$iv3 = NodeKind.m6666constructorimpl(16384);
            int mask$iv$iv$iv = type$iv3;
            DelegatableNode $this$visitAncestors$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv5;
            if ($this$visitAncestors$iv$iv$iv.getNode().isAttached()) {
                Modifier.Node node$iv$iv$iv = $this$visitAncestors$iv$iv$iv.getNode().getParent$ui_release();
                LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv$iv);
                loop0:
                while (true) {
                    if (layout$iv$iv$iv == null) {
                        node = null;
                        break;
                    }
                    if ((layout$iv$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                        while (node$iv$iv$iv != null) {
                            if ((node$iv$iv$iv.getKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                                MutableVector mutableVector5 = null;
                                Modifier.Node this_$iv$iv$iv$iv = node$iv$iv$iv;
                                while (this_$iv$iv$iv$iv != null) {
                                    if (this_$iv$iv$iv$iv instanceof RotaryInputModifierNode) {
                                        node = this_$iv$iv$iv$iv;
                                        break loop0;
                                    }
                                    if (((this_$iv$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? i7 : 0) == 0 || !(this_$iv$iv$iv$iv instanceof DelegatingNode)) {
                                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                                    } else {
                                        int count$iv$iv$iv = 0;
                                        Modifier.Node node$iv$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv$iv).getDelegate$ui_release();
                                        while (node$iv$iv$iv$iv != null) {
                                            Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                            if (((next$iv$iv$iv.getKindSet$ui_release() & type$iv3) != 0 ? i7 : 0) != 0) {
                                                count$iv$iv$iv++;
                                                if (count$iv$iv$iv == i7) {
                                                    this_$iv$iv$iv$iv = next$iv$iv$iv;
                                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                    Modifier.Node node2 = next$iv$iv$iv;
                                                } else {
                                                    if (mutableVector5 == null) {
                                                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                        mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                        mutableVector4 = mutableVector5;
                                                    }
                                                    Modifier.Node theNode$iv$iv$iv = this_$iv$iv$iv$iv;
                                                    if (theNode$iv$iv$iv != null) {
                                                        if (mutableVector4 != null) {
                                                            mutableVector4.add(theNode$iv$iv$iv);
                                                        }
                                                        this_$iv$iv$iv$iv = null;
                                                    }
                                                    if (mutableVector4 != null) {
                                                        mutableVector4.add(next$iv$iv$iv);
                                                    }
                                                    mutableVector5 = mutableVector4;
                                                }
                                            } else {
                                                $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                Modifier.Node node3 = next$iv$iv$iv;
                                            }
                                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                            $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                            i7 = 1;
                                        }
                                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                                        if (count$iv$iv$iv == 1) {
                                            $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                                            i7 = 1;
                                        }
                                    }
                                    this_$iv$iv$iv$iv = DelegatableNodeKt.pop(mutableVector5);
                                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                                    i7 = 1;
                                }
                                continue;
                            }
                            node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                            $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv2;
                            i8 = 1;
                        }
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    } else {
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv5;
                    }
                    layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                    node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes$ui_release2 = layout$iv$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
                    $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv;
                    i8 = 1;
                }
                rotaryInputModifierNode = (RotaryInputModifierNode) node;
            } else {
                DelegatableNode delegatableNode = $this$nearestAncestor_u2d64DMado$iv5;
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
        } else {
            rotaryInputModifierNode = null;
        }
        RotaryInputModifierNode focusedRotaryInputNode3 = rotaryInputModifierNode;
        if (focusedRotaryInputNode3 != null) {
            DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho$iv3 = focusedRotaryInputNode3;
            int type$iv4 = NodeKind.m6666constructorimpl(16384);
            FocusOwnerImpl this_$iv5 = this;
            int i9 = false;
            List list = null;
            int mask$iv$iv$iv$iv = type$iv4;
            DelegatableNode $this$visitAncestors$iv$iv$iv$iv = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
            if ($this$visitAncestors$iv$iv$iv$iv.getNode().isAttached()) {
                Modifier.Node node$iv$iv$iv$iv2 = $this$visitAncestors$iv$iv$iv$iv.getNode().getParent$ui_release();
                LayoutNode layout$iv$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv$iv$iv);
                while (layout$iv$iv$iv$iv != null) {
                    if ((layout$iv$iv$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv$iv$iv) != 0) {
                        while (node$iv$iv$iv$iv2 != null) {
                            if ((node$iv$iv$iv$iv2.getKindSet$ui_release() & mask$iv$iv$iv$iv) != 0) {
                                MutableVector mutableVector6 = null;
                                Object this_$iv$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                while (this_$iv$iv$iv$iv$iv != null) {
                                    RotaryInputModifierNode focusedRotaryInputNode4 = focusedRotaryInputNode2;
                                    if (this_$iv$iv$iv$iv$iv instanceof RotaryInputModifierNode) {
                                        Object it$iv$iv = this_$iv$iv$iv$iv$iv;
                                        if (list == null) {
                                            list = (List) new ArrayList();
                                        }
                                        list.add(it$iv$iv);
                                        this_$iv3 = this_$iv2;
                                        i5 = i4;
                                    } else {
                                        if (!((this_$iv$iv$iv$iv$iv.getKindSet$ui_release() & type$iv4) != 0) || !(this_$iv$iv$iv$iv$iv instanceof DelegatingNode)) {
                                            this_$iv3 = this_$iv2;
                                            i5 = i4;
                                        } else {
                                            int count$iv$iv$iv$iv2 = 0;
                                            Modifier.Node node$iv$iv$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv$iv$iv).getDelegate$ui_release();
                                            while (node$iv$iv$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv$iv$iv = node$iv$iv$iv$iv$iv;
                                                if ((next$iv$iv$iv$iv.getKindSet$ui_release() & type$iv4) != 0) {
                                                    count$iv$iv$iv$iv2++;
                                                    this_$iv4 = this_$iv2;
                                                    if (count$iv$iv$iv$iv2 == 1) {
                                                        this_$iv$iv$iv$iv$iv = next$iv$iv$iv$iv;
                                                        i6 = i4;
                                                        Modifier.Node node4 = next$iv$iv$iv$iv;
                                                    } else {
                                                        if (mutableVector6 == null) {
                                                            count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                                            i6 = i4;
                                                            mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                                            i6 = i4;
                                                            mutableVector3 = mutableVector6;
                                                        }
                                                        MutableVector mutableVector7 = mutableVector3;
                                                        Modifier.Node theNode$iv$iv$iv$iv = this_$iv$iv$iv$iv$iv;
                                                        if (theNode$iv$iv$iv$iv != null) {
                                                            if (mutableVector7 != null) {
                                                                mutableVector7.add(theNode$iv$iv$iv$iv);
                                                            }
                                                            this_$iv$iv$iv$iv$iv = null;
                                                        }
                                                        if (mutableVector7 != null) {
                                                            mutableVector7.add(next$iv$iv$iv$iv);
                                                        }
                                                        mutableVector6 = mutableVector7;
                                                        count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                                    }
                                                } else {
                                                    this_$iv4 = this_$iv2;
                                                    i6 = i4;
                                                    Modifier.Node node5 = next$iv$iv$iv$iv;
                                                }
                                                node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                                this_$iv2 = this_$iv4;
                                                i4 = i6;
                                            }
                                            this_$iv3 = this_$iv2;
                                            i5 = i4;
                                            if (count$iv$iv$iv$iv2 == 1) {
                                                focusedRotaryInputNode2 = focusedRotaryInputNode4;
                                                this_$iv2 = this_$iv3;
                                                i4 = i5;
                                            }
                                        }
                                    }
                                    this_$iv$iv$iv$iv$iv = DelegatableNodeKt.pop(mutableVector6);
                                    focusedRotaryInputNode2 = focusedRotaryInputNode4;
                                    this_$iv2 = this_$iv3;
                                    i4 = i5;
                                }
                            }
                            node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getParent$ui_release();
                            focusedRotaryInputNode3 = focusedRotaryInputNode2;
                            this_$iv5 = this_$iv2;
                            i9 = i4;
                        }
                        focusedRotaryInputNode = focusedRotaryInputNode2;
                        this_$iv = this_$iv2;
                        i3 = i4;
                    } else {
                        focusedRotaryInputNode = focusedRotaryInputNode3;
                        this_$iv = this_$iv5;
                        i3 = i9;
                    }
                    layout$iv$iv$iv$iv = layout$iv$iv$iv$iv.getParent$ui_release();
                    node$iv$iv$iv$iv2 = (layout$iv$iv$iv$iv == null || (nodes$ui_release = layout$iv$iv$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                    focusedRotaryInputNode3 = focusedRotaryInputNode;
                    this_$iv5 = this_$iv;
                    i9 = i3;
                }
                FocusOwnerImpl focusOwnerImpl = this_$iv5;
                int i10 = i9;
                List ancestors$iv = list;
                if (ancestors$iv != null) {
                    List $this$fastForEachReversed$iv$iv = ancestors$iv;
                    int size = $this$fastForEachReversed$iv$iv.size() - 1;
                    if (size >= 0) {
                        do {
                            int index$iv$iv = size;
                            size--;
                            if (((RotaryInputModifierNode) $this$fastForEachReversed$iv$iv.get(index$iv$iv)).onPreRotaryScrollEvent(rotaryScrollEvent)) {
                                return true;
                            }
                        } while (size >= 0);
                    }
                }
                Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$traverseAncestors_u2dY_u2dYKmho$iv3.getNode();
                int i11 = false;
                MutableVector mutableVector8 = null;
                Modifier.Node this_$iv$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                while (this_$iv$iv$iv != null) {
                    if (!(this_$iv$iv$iv instanceof RotaryInputModifierNode)) {
                        if (!((this_$iv$iv$iv.getKindSet$ui_release() & type$iv4) != 0) || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                            i = i11;
                        } else {
                            int count$iv$iv = 0;
                            Modifier.Node node$iv$iv$iv2 = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                            while (node$iv$iv$iv2 != null) {
                                Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                if ((next$iv$iv.getKindSet$ui_release() & type$iv4) != 0) {
                                    count$iv$iv++;
                                    if (count$iv$iv == 1) {
                                        this_$iv$iv$iv = next$iv$iv;
                                        $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                        i2 = i11;
                                    } else {
                                        if (mutableVector8 == null) {
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                            i2 = i11;
                                            MutableVector mutableVector9 = mutableVector8;
                                            mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                        } else {
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                            i2 = i11;
                                            mutableVector2 = mutableVector8;
                                        }
                                        mutableVector8 = mutableVector2;
                                        Modifier.Node theNode$iv$iv = this_$iv$iv$iv;
                                        if (theNode$iv$iv != null) {
                                            if (mutableVector8 != null) {
                                                mutableVector8.add(theNode$iv$iv);
                                            }
                                            this_$iv$iv$iv = null;
                                        }
                                        if (mutableVector8 != null) {
                                            mutableVector8.add(next$iv$iv);
                                        }
                                    }
                                } else {
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                    i2 = i11;
                                    MutableVector mutableVector10 = mutableVector8;
                                }
                                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                                i11 = i2;
                            }
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                            i = i11;
                            MutableVector mutableVector11 = mutableVector8;
                            if (count$iv$iv == 1) {
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                                i11 = i;
                                mutableVector8 = mutableVector11;
                            } else {
                                mutableVector8 = mutableVector11;
                            }
                        }
                    } else if (((RotaryInputModifierNode) this_$iv$iv$iv).onPreRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    } else {
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                        i = i11;
                    }
                    this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector8);
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                    i11 = i;
                }
                int i12 = i11;
                Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$traverseAncestors_u2dY_u2dYKmho$iv3.getNode();
                MutableVector mutableVector12 = null;
                Modifier.Node this_$iv$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                while (this_$iv$iv$iv2 != null) {
                    if (!(this_$iv$iv$iv2 instanceof RotaryInputModifierNode)) {
                        if (!((this_$iv$iv$iv2.getKindSet$ui_release() & type$iv4) != 0) || !(this_$iv$iv$iv2 instanceof DelegatingNode)) {
                            $this$traverseAncestors_u2dY_u2dYKmho$iv = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                            type$iv = type$iv4;
                        } else {
                            int count$iv$iv2 = 0;
                            Modifier.Node node$iv$iv$iv3 = ((DelegatingNode) this_$iv$iv$iv2).getDelegate$ui_release();
                            while (node$iv$iv$iv3 != null) {
                                Modifier.Node next$iv$iv2 = node$iv$iv$iv3;
                                if ((next$iv$iv2.getKindSet$ui_release() & type$iv4) != 0) {
                                    count$iv$iv2++;
                                    if (count$iv$iv2 == 1) {
                                        this_$iv$iv$iv2 = next$iv$iv2;
                                        $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                                        $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                        type$iv2 = type$iv4;
                                    } else {
                                        if (mutableVector12 == null) {
                                            $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                            type$iv2 = type$iv4;
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        } else {
                                            $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                            type$iv2 = type$iv4;
                                            mutableVector = mutableVector12;
                                        }
                                        mutableVector12 = mutableVector;
                                        Modifier.Node theNode$iv$iv2 = this_$iv$iv$iv2;
                                        if (theNode$iv$iv2 != null) {
                                            if (mutableVector12 != null) {
                                                mutableVector12.add(theNode$iv$iv2);
                                            }
                                            this_$iv$iv$iv2 = null;
                                        }
                                        if (mutableVector12 != null) {
                                            mutableVector12.add(next$iv$iv2);
                                        }
                                    }
                                } else {
                                    $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                    type$iv2 = type$iv4;
                                }
                                node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                                $this$traverseAncestors_u2dY_u2dYKmho$iv3 = $this$traverseAncestors_u2dY_u2dYKmho$iv2;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                                type$iv4 = type$iv2;
                            }
                            $this$traverseAncestors_u2dY_u2dYKmho$iv = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                            type$iv = type$iv4;
                            if (count$iv$iv2 == 1) {
                                $this$traverseAncestors_u2dY_u2dYKmho$iv3 = $this$traverseAncestors_u2dY_u2dYKmho$iv;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                                type$iv4 = type$iv;
                            }
                        }
                    } else if (((RotaryInputModifierNode) this_$iv$iv$iv2).onRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    } else {
                        $this$traverseAncestors_u2dY_u2dYKmho$iv = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                        type$iv = type$iv4;
                    }
                    this_$iv$iv$iv2 = DelegatableNodeKt.pop(mutableVector12);
                    $this$traverseAncestors_u2dY_u2dYKmho$iv3 = $this$traverseAncestors_u2dY_u2dYKmho$iv;
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                    type$iv4 = type$iv;
                }
                Modifier.Node node6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                int i13 = type$iv4;
                if (ancestors$iv == null) {
                    return false;
                }
                List $this$fastForEach$iv$iv = ancestors$iv;
                int size2 = $this$fastForEach$iv$iv.size();
                for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                    if (((RotaryInputModifierNode) $this$fastForEach$iv$iv.get(index$iv$iv2)).onRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    }
                }
                return false;
            }
            DelegatableNode delegatableNode2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        return false;
    }

    public void scheduleInvalidation(FocusTargetNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    public void scheduleInvalidation(FocusEventModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    public void scheduleInvalidation(FocusPropertiesModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    /* renamed from: traverseAncestors-Y-YKmho  reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m4650traverseAncestorsYYKmho(DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho, int type, Function1<? super T, Unit> onPreVisit, Function1<? super T, Unit> onVisit) {
        int i;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv;
        int i2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv2;
        int i3;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv3;
        int i4;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv4;
        int i5;
        DelegatableNode $this$ancestors_u2d64DMado$iv;
        int i6;
        NodeChain nodes$ui_release;
        int i7;
        DelegatableNode $this$ancestors_u2d64DMado$iv2;
        int count$iv$iv$iv;
        int i8;
        DelegatableNode $this$ancestors_u2d64DMado$iv3;
        int i9;
        int i10;
        DelegatableNode $this$ancestors_u2d64DMado$iv4;
        Object result$iv;
        int i11;
        int count$iv$iv$iv2;
        Function1<? super T, Unit> function1 = onPreVisit;
        Function1<? super T, Unit> function12 = onVisit;
        int count$iv$iv$iv3 = 0;
        DelegatableNode $this$ancestors_u2d64DMado$iv5 = $this$traverseAncestors_u2dY_u2dYKmho;
        int i12 = false;
        Object result$iv2 = null;
        int mask$iv$iv$iv = type;
        DelegatableNode $this$visitAncestors$iv$iv$iv = $this$ancestors_u2d64DMado$iv5;
        if ($this$visitAncestors$iv$iv$iv.getNode().isAttached()) {
            Modifier.Node node$iv$iv$iv = $this$visitAncestors$iv$iv$iv.getNode().getParent$ui_release();
            LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv$iv);
            while (layout$iv$iv$iv != null) {
                if ((layout$iv$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                    while (node$iv$iv$iv != null) {
                        if ((node$iv$iv$iv.getKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                            Object stack$iv$iv$iv = null;
                            Object node$iv$iv$iv2 = node$iv$iv$iv;
                            while (node$iv$iv$iv2 != null) {
                                int i13 = count$iv$iv$iv;
                                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                                if (node$iv$iv$iv2 instanceof Object) {
                                    Object it$iv = node$iv$iv$iv2;
                                    if (result$iv2 == null) {
                                        result$iv2 = (List) new ArrayList();
                                    }
                                    $this$ancestors_u2d64DMado$iv4 = $this$ancestors_u2d64DMado$iv2;
                                    ((List) result$iv2).add(it$iv);
                                    i10 = i7;
                                } else {
                                    $this$ancestors_u2d64DMado$iv4 = $this$ancestors_u2d64DMado$iv2;
                                    if (!((((Modifier.Node) node$iv$iv$iv2).getKindSet$ui_release() & type) != 0) || !(node$iv$iv$iv2 instanceof DelegatingNode)) {
                                        i10 = i7;
                                        result$iv2 = result$iv2;
                                    } else {
                                        int count$iv$iv$iv4 = 0;
                                        DelegatingNode this_$iv$iv$iv$iv = (DelegatingNode) node$iv$iv$iv2;
                                        Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv.getDelegate$ui_release();
                                        while (node$iv$iv$iv$iv != null) {
                                            DelegatingNode this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv;
                                            Object next$iv$iv$iv = node$iv$iv$iv$iv;
                                            if ((next$iv$iv$iv.getKindSet$ui_release() & type) != 0) {
                                                count$iv$iv$iv4++;
                                                i11 = i7;
                                                if (count$iv$iv$iv4 == 1) {
                                                    node$iv$iv$iv2 = next$iv$iv$iv;
                                                    result$iv = result$iv2;
                                                } else {
                                                    Object obj = (MutableVector) stack$iv$iv$iv;
                                                    if (obj == null) {
                                                        count$iv$iv$iv2 = count$iv$iv$iv4;
                                                        result$iv = result$iv2;
                                                        obj = new MutableVector(new Modifier.Node[16], 0);
                                                        MutableVector mutableVector = (MutableVector) obj;
                                                    } else {
                                                        count$iv$iv$iv2 = count$iv$iv$iv4;
                                                        result$iv = result$iv2;
                                                    }
                                                    stack$iv$iv$iv = obj;
                                                    Modifier.Node theNode$iv$iv$iv = (Modifier.Node) node$iv$iv$iv2;
                                                    if (theNode$iv$iv$iv != null) {
                                                        MutableVector mutableVector2 = (MutableVector) stack$iv$iv$iv;
                                                        if (mutableVector2 != null) {
                                                            mutableVector2.add(theNode$iv$iv$iv);
                                                        }
                                                        node$iv$iv$iv2 = null;
                                                    }
                                                    MutableVector mutableVector3 = (MutableVector) stack$iv$iv$iv;
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(next$iv$iv$iv);
                                                    }
                                                    count$iv$iv$iv4 = count$iv$iv$iv2;
                                                }
                                            } else {
                                                i11 = i7;
                                                result$iv = result$iv2;
                                            }
                                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                            this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                            i7 = i11;
                                            result$iv2 = result$iv;
                                        }
                                        i10 = i7;
                                        Object result$iv3 = result$iv2;
                                        if (count$iv$iv$iv4 == 1) {
                                            count$iv$iv$iv = i13;
                                            $this$ancestors_u2d64DMado$iv2 = $this$ancestors_u2d64DMado$iv4;
                                            i7 = i10;
                                            result$iv2 = result$iv3;
                                        } else {
                                            result$iv2 = result$iv3;
                                        }
                                    }
                                }
                                node$iv$iv$iv2 = DelegatableNodeKt.pop((MutableVector) stack$iv$iv$iv);
                                count$iv$iv$iv = i13;
                                $this$ancestors_u2d64DMado$iv2 = $this$ancestors_u2d64DMado$iv4;
                                i7 = i10;
                            }
                            i9 = count$iv$iv$iv;
                            $this$ancestors_u2d64DMado$iv3 = $this$ancestors_u2d64DMado$iv2;
                            i8 = i7;
                            Object obj2 = result$iv2;
                        } else {
                            i9 = count$iv$iv$iv;
                            $this$ancestors_u2d64DMado$iv3 = $this$ancestors_u2d64DMado$iv2;
                            i8 = i7;
                        }
                        node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                        count$iv$iv$iv3 = i9;
                        $this$ancestors_u2d64DMado$iv5 = $this$ancestors_u2d64DMado$iv3;
                        i12 = i8;
                    }
                    i6 = count$iv$iv$iv;
                    $this$ancestors_u2d64DMado$iv = $this$ancestors_u2d64DMado$iv2;
                    i5 = i7;
                } else {
                    i6 = count$iv$iv$iv3;
                    $this$ancestors_u2d64DMado$iv = $this$ancestors_u2d64DMado$iv5;
                    i5 = i12;
                }
                layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes$ui_release = layout$iv$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                count$iv$iv$iv3 = i6;
                $this$ancestors_u2d64DMado$iv5 = $this$ancestors_u2d64DMado$iv;
                i12 = i5;
            }
            int i14 = count$iv$iv$iv3;
            DelegatableNode delegatableNode = $this$ancestors_u2d64DMado$iv5;
            int i15 = i12;
            List ancestors = (List) result$iv2;
            if (ancestors != null) {
                List $this$fastForEachReversed$iv = ancestors;
                int size = $this$fastForEachReversed$iv.size() - 1;
                if (size >= 0) {
                    do {
                        int index$iv = size;
                        size--;
                        function1.invoke($this$fastForEachReversed$iv.get(index$iv));
                    } while (size >= 0);
                }
            }
            Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv5 = $this$traverseAncestors_u2dY_u2dYKmho.getNode();
            int i16 = false;
            Object stack$iv = null;
            Modifier.Node node$iv = $this$dispatchForKind_u2d6rFNWt0$iv5;
            while (node$iv != null) {
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (node$iv instanceof Object) {
                    function1.invoke(node$iv);
                    $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                    i3 = i16;
                } else {
                    if (!((node$iv.getKindSet$ui_release() & type) != 0) || !(node$iv instanceof DelegatingNode)) {
                        $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                        i3 = i16;
                    } else {
                        int count$iv = 0;
                        Modifier.Node node$iv$iv = ((DelegatingNode) node$iv).getDelegate$ui_release();
                        while (node$iv$iv != null) {
                            Modifier.Node next$iv = node$iv$iv;
                            if ((next$iv.getKindSet$ui_release() & type) != 0) {
                                count$iv++;
                                if (count$iv == 1) {
                                    node$iv = next$iv;
                                    $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                                    i4 = i16;
                                } else {
                                    Object obj3 = (MutableVector) stack$iv;
                                    if (obj3 == null) {
                                        $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                                        i4 = i16;
                                        Object mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                        MutableVector mutableVector5 = (MutableVector) mutableVector4;
                                        obj3 = mutableVector4;
                                    } else {
                                        $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                                        i4 = i16;
                                    }
                                    stack$iv = obj3;
                                    Modifier.Node theNode$iv = node$iv;
                                    if (theNode$iv != null) {
                                        MutableVector mutableVector6 = (MutableVector) stack$iv;
                                        if (mutableVector6 != null) {
                                            mutableVector6.add(theNode$iv);
                                        }
                                        node$iv = null;
                                    }
                                    MutableVector mutableVector7 = (MutableVector) stack$iv;
                                    if (mutableVector7 != null) {
                                        mutableVector7.add(next$iv);
                                    }
                                }
                            } else {
                                $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                                i4 = i16;
                            }
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                            Function1<? super T, Unit> function13 = onPreVisit;
                            $this$dispatchForKind_u2d6rFNWt0$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv4;
                            i16 = i4;
                        }
                        $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                        i3 = i16;
                        if (count$iv == 1) {
                            function1 = onPreVisit;
                            $this$dispatchForKind_u2d6rFNWt0$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                            i16 = i3;
                        }
                    }
                }
                node$iv = DelegatableNodeKt.pop((MutableVector) stack$iv);
                function1 = onPreVisit;
                $this$dispatchForKind_u2d6rFNWt0$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                i16 = i3;
            }
            int i17 = i16;
            Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv6 = $this$traverseAncestors_u2dY_u2dYKmho.getNode();
            int i18 = false;
            Object stack$iv2 = null;
            Modifier.Node node$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv6;
            while (node$iv2 != null) {
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (node$iv2 instanceof Object) {
                    function12.invoke(node$iv2);
                    $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv6;
                    i = i18;
                } else {
                    if (!((node$iv2.getKindSet$ui_release() & type) != 0) || !(node$iv2 instanceof DelegatingNode)) {
                        $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv6;
                        i = i18;
                    } else {
                        int count$iv2 = 0;
                        Modifier.Node node$iv$iv2 = ((DelegatingNode) node$iv2).getDelegate$ui_release();
                        while (node$iv$iv2 != null) {
                            Modifier.Node next$iv2 = node$iv$iv2;
                            if ((next$iv2.getKindSet$ui_release() & type) != 0) {
                                count$iv2++;
                                if (count$iv2 == 1) {
                                    node$iv2 = next$iv2;
                                    $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv6;
                                    i2 = i18;
                                } else {
                                    Object obj4 = (MutableVector) stack$iv2;
                                    if (obj4 == null) {
                                        $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv6;
                                        i2 = i18;
                                        Object mutableVector8 = new MutableVector(new Modifier.Node[16], 0);
                                        MutableVector mutableVector9 = (MutableVector) mutableVector8;
                                        obj4 = mutableVector8;
                                    } else {
                                        $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv6;
                                        i2 = i18;
                                    }
                                    stack$iv2 = obj4;
                                    Modifier.Node theNode$iv2 = node$iv2;
                                    if (theNode$iv2 != null) {
                                        MutableVector mutableVector10 = (MutableVector) stack$iv2;
                                        if (mutableVector10 != null) {
                                            mutableVector10.add(theNode$iv2);
                                        }
                                        node$iv2 = null;
                                    }
                                    MutableVector mutableVector11 = (MutableVector) stack$iv2;
                                    if (mutableVector11 != null) {
                                        mutableVector11.add(next$iv2);
                                    }
                                }
                            } else {
                                $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv6;
                                i2 = i18;
                            }
                            node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                            $this$dispatchForKind_u2d6rFNWt0$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv2;
                            i18 = i2;
                        }
                        $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv6;
                        i = i18;
                        if (count$iv2 == 1) {
                            $this$dispatchForKind_u2d6rFNWt0$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv;
                            i18 = i;
                        }
                    }
                }
                node$iv2 = DelegatableNodeKt.pop((MutableVector) stack$iv2);
                $this$dispatchForKind_u2d6rFNWt0$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv;
                i18 = i;
            }
            int i19 = i18;
            if (ancestors != null) {
                List $this$fastForEach$iv = ancestors;
                int size2 = $this$fastForEach$iv.size();
                for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                    function12.invoke($this$fastForEach$iv.get(index$iv2));
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    public Rect getFocusRect() {
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(findActiveFocusNode);
        }
        return null;
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode $this$lastLocalKeyInputNode) {
        Modifier.Node node = null;
        int arg0$iv = NodeKind.m6666constructorimpl(1024) | NodeKind.m6666constructorimpl(8192);
        DelegatableNode $this$visitLocalDescendants$iv = $this$lastLocalKeyInputNode;
        if ($this$visitLocalDescendants$iv.getNode().isAttached()) {
            Modifier.Node self$iv = $this$visitLocalDescendants$iv.getNode();
            if ((self$iv.getAggregateChildKindSet$ui_release() & arg0$iv) != 0) {
                for (Modifier.Node next$iv = self$iv.getChild$ui_release(); next$iv != null; next$iv = next$iv.getChild$ui_release()) {
                    if ((next$iv.getKindSet$ui_release() & arg0$iv) != 0) {
                        Modifier.Node modifierNode = next$iv;
                        if ((modifierNode.getKindSet$ui_release() & NodeKind.m6666constructorimpl(1024)) != 0) {
                            return node;
                        }
                        node = modifierNode;
                    }
                }
            }
            return node;
        }
        throw new IllegalStateException("visitLocalDescendants called on an unattached node".toString());
    }

    /* renamed from: wrapAroundFocus-3ESFkO8  reason: not valid java name */
    private final boolean m4651wrapAroundFocus3ESFkO8(int focusDirection) {
        if (!this.rootFocusNode.getFocusState().getHasFocus() || this.rootFocusNode.getFocusState().isFocused()) {
            return false;
        }
        if (!(FocusDirection.m4629equalsimpl0(focusDirection, FocusDirection.Companion.m4642getNextdhqQ8s()) ? true : FocusDirection.m4629equalsimpl0(focusDirection, FocusDirection.Companion.m4644getPreviousdhqQ8s()))) {
            return false;
        }
        clearFocus(false);
        if (!this.rootFocusNode.getFocusState().isFocused()) {
            return false;
        }
        return m4654moveFocus3ESFkO8(focusDirection);
    }
}

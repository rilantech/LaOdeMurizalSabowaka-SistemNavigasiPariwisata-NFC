package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.platform.Wrapper_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u0003XYZB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u00100\u001a\u0002012\u001d\u00102\u001a\u0019\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012¢\u0006\u0002\b\u0016ø\u0001\u0000J\u0010\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0010H\u0002J\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0010J\u0006\u0010:\u001a\u000207J\u0012\u0010;\u001a\u0004\u0018\u00010\u00012\u0006\u00105\u001a\u00020\u0010H\u0002J\u0017\u0010<\u001a\u0002072\f\u00102\u001a\b\u0012\u0004\u0012\u0002070=H\bJ\u0006\u0010>\u001a\u000207J\"\u0010?\u001a\u0002072\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00102\b\b\u0002\u0010B\u001a\u00020\u0010H\u0002J(\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010\u00012\u0011\u0010F\u001a\r\u0012\u0004\u0012\u0002070=¢\u0006\u0002\bG¢\u0006\u0002\u0010HJ\u0018\u0010I\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\"H\u0002J2\u0010I\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\b\u0010E\u001a\u0004\u0018\u00010\u00012\u0011\u0010F\u001a\r\u0012\u0004\u0012\u0002070=¢\u0006\u0002\bGH\u0002¢\u0006\u0002\u0010LJ.\u0010I\u001a\b\u0012\u0004\u0012\u00020N0M2\b\u0010E\u001a\u0004\u0018\u00010\u00012\u0011\u0010F\u001a\r\u0012\u0004\u0012\u0002070=¢\u0006\u0002\bG¢\u0006\u0002\u0010OJ:\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010Q2\u0006\u0010S\u001a\u00020\u00032\u0006\u0010T\u001a\u00020\n2\u0011\u0010U\u001a\r\u0012\u0004\u0012\u0002070=¢\u0006\u0002\bGH\u0002¢\u0006\u0002\u0010VJ\u0014\u0010W\u001a\u0004\u0018\u00010\u00032\b\u0010E\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R4\u0010\u0011\u001a\u0019\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012¢\u0006\u0002\b\u0016X\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00060\u001cR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\"0!X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00030!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00060)R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00030!X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u0002\u0004\n\u0002\b\u0019¨\u0006["}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "slotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "NoIntrinsicsMessage", "", "compositionContext", "Landroidx/compose/runtime/CompositionContext;", "getCompositionContext", "()Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroidx/compose/runtime/CompositionContext;)V", "currentIndex", "", "intermediateMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeIntermediateMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "getIntermediateMeasurePolicy$ui_release", "()Lkotlin/jvm/functions/Function2;", "setIntermediateMeasurePolicy$ui_release", "(Lkotlin/jvm/functions/Function2;)V", "intermediateMeasureScope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$IntermediateMeasureScopeImpl;", "isInLookaheadScope", "", "()Z", "nodeToNodeState", "", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "precomposeMap", "precomposedCount", "reusableCount", "reusableSlotIdsSet", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "scope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "slotIdToNode", "value", "getSlotReusePolicy", "()Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "setSlotReusePolicy", "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "createMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "block", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "createNodeAt", "index", "disposeCurrentNodes", "", "disposeOrReuseStartingFromIndex", "startIndex", "forceRecomposeChildren", "getSlotIdAtIndex", "ignoreRemeasureRequests", "Lkotlin/Function0;", "makeSureStateIsConsistent", "move", "from", "to", "count", "precompose", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "slotId", "content", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "subcompose", "node", "nodeState", "(Landroidx/compose/ui/node/LayoutNode;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "Landroidx/compose/ui/layout/Measurable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "subcomposeInto", "Landroidx/compose/runtime/Composition;", "existing", "container", "parent", "composable", "(Landroidx/compose/runtime/Composition;Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "takeNodeFromReusables", "IntermediateMeasureScopeImpl", "NodeState", "Scope", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
public final class LayoutNodeSubcompositionsState {
    private final String NoIntrinsicsMessage = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing,, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";
    private CompositionContext compositionContext;
    /* access modifiers changed from: private */
    public int currentIndex;
    private Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> intermediateMeasurePolicy = LayoutNodeSubcompositionsState$intermediateMeasurePolicy$1.INSTANCE;
    /* access modifiers changed from: private */
    public final IntermediateMeasureScopeImpl intermediateMeasureScope = new IntermediateMeasureScopeImpl();
    private final Map<LayoutNode, NodeState> nodeToNodeState = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final Map<Object, LayoutNode> precomposeMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    public int precomposedCount;
    /* access modifiers changed from: private */
    public int reusableCount;
    private final SubcomposeSlotReusePolicy.SlotIdsSet reusableSlotIdsSet = new SubcomposeSlotReusePolicy.SlotIdsSet((Set) null, 1, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final LayoutNode root;
    /* access modifiers changed from: private */
    public final Scope scope = new Scope();
    /* access modifiers changed from: private */
    public final Map<Object, LayoutNode> slotIdToNode = new LinkedHashMap();
    private SubcomposeSlotReusePolicy slotReusePolicy;

    public LayoutNodeSubcompositionsState(LayoutNode root2, SubcomposeSlotReusePolicy slotReusePolicy2) {
        Intrinsics.checkNotNullParameter(root2, "root");
        Intrinsics.checkNotNullParameter(slotReusePolicy2, "slotReusePolicy");
        this.root = root2;
        this.slotReusePolicy = slotReusePolicy2;
    }

    public final CompositionContext getCompositionContext() {
        return this.compositionContext;
    }

    public final void setCompositionContext(CompositionContext compositionContext2) {
        this.compositionContext = compositionContext2;
    }

    public final SubcomposeSlotReusePolicy getSlotReusePolicy() {
        return this.slotReusePolicy;
    }

    public final void setSlotReusePolicy(SubcomposeSlotReusePolicy value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.slotReusePolicy != value) {
            this.slotReusePolicy = value;
            disposeOrReuseStartingFromIndex(0);
        }
    }

    public final boolean isInLookaheadScope() {
        return this.root.getLookaheadRoot$ui_release() != null;
    }

    public final Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult> getIntermediateMeasurePolicy$ui_release() {
        return this.intermediateMeasurePolicy;
    }

    public final void setIntermediateMeasurePolicy$ui_release(Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.intermediateMeasurePolicy = function2;
    }

    public final List<Measurable> subcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        Object answer$iv;
        Object obj;
        Intrinsics.checkNotNullParameter(content, "content");
        makeSureStateIsConsistent();
        LayoutNode.LayoutState layoutState = this.root.getLayoutState$ui_release();
        boolean z = false;
        if (layoutState == LayoutNode.LayoutState.Measuring || layoutState == LayoutNode.LayoutState.LayingOut || layoutState == LayoutNode.LayoutState.LookaheadMeasuring || layoutState == LayoutNode.LayoutState.LookaheadLayingOut) {
            Map $this$getOrPut$iv = this.slotIdToNode;
            Object value$iv = $this$getOrPut$iv.get(slotId);
            if (value$iv == null) {
                Object precomposed = (LayoutNode) this.precomposeMap.remove(slotId);
                if (precomposed != null) {
                    int i = this.precomposedCount;
                    if (i > 0) {
                        this.precomposedCount = i - 1;
                        obj = precomposed;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    obj = takeNodeFromReusables(slotId);
                    if (obj == null) {
                        obj = createNodeAt(this.currentIndex);
                    }
                }
                answer$iv = obj;
                $this$getOrPut$iv.put(slotId, answer$iv);
            } else {
                answer$iv = value$iv;
            }
            LayoutNode node = (LayoutNode) answer$iv;
            int itemIndex = this.root.getFoldedChildren$ui_release().indexOf(node);
            int i2 = this.currentIndex;
            if (itemIndex >= i2) {
                z = true;
            }
            if (z) {
                if (i2 != itemIndex) {
                    move$default(this, itemIndex, i2, 0, 4, (Object) null);
                }
                this.currentIndex++;
                subcompose(node, slotId, content);
                if (layoutState == LayoutNode.LayoutState.Measuring || layoutState == LayoutNode.LayoutState.LayingOut) {
                    return node.getChildMeasurables$ui_release();
                }
                return node.getChildLookaheadMeasurables$ui_release();
            }
            throw new IllegalArgumentException(("Key \"" + slotId + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.").toString());
        }
        throw new IllegalStateException("subcompose can only be used inside the measure or layout blocks".toString());
    }

    private final void subcompose(LayoutNode node, Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        Object answer$iv;
        Map $this$getOrPut$iv = this.nodeToNodeState;
        Object value$iv = $this$getOrPut$iv.get(node);
        if (value$iv == null) {
            answer$iv = new NodeState(slotId, ComposableSingletons$SubcomposeLayoutKt.INSTANCE.m6317getLambda1$ui_release(), (Composition) null, 4, (DefaultConstructorMarker) null);
            $this$getOrPut$iv.put(node, answer$iv);
        } else {
            answer$iv = value$iv;
        }
        NodeState nodeState = (NodeState) answer$iv;
        Composition composition = nodeState.getComposition();
        boolean hasPendingChanges = composition != null ? composition.getHasInvalidations() : true;
        if (nodeState.getContent() != content || hasPendingChanges || nodeState.getForceRecompose()) {
            nodeState.setContent(content);
            subcompose(node, nodeState);
            nodeState.setForceRecompose(false);
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 20 */
    private final void subcompose(LayoutNode node, NodeState nodeState) {
        NodeState nodeState2 = nodeState;
        Snapshot.Companion this_$iv = Snapshot.Companion;
        Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
        Snapshot this_$iv$iv = snapshot$iv;
        try {
            Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
            try {
                LayoutNode this_$iv$iv2 = this.root;
                this_$iv$iv2.ignoreRemeasureRequests = true;
                Function2 content = nodeState.getContent();
                Composition composition = nodeState.getComposition();
                CompositionContext compositionContext2 = this.compositionContext;
                if (compositionContext2 != null) {
                    Snapshot.Companion companion = this_$iv;
                    try {
                    } catch (Throwable th) {
                        th = th;
                        LayoutNode layoutNode = node;
                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                        throw th;
                    }
                    try {
                        try {
                            nodeState2.setComposition(subcomposeInto(composition, node, compositionContext2, ComposableLambdaKt.composableLambdaInstance(-34810602, true, new LayoutNodeSubcompositionsState$subcompose$3$1$1(nodeState2, content))));
                            this_$iv$iv2.ignoreRemeasureRequests = false;
                            Unit unit = Unit.INSTANCE;
                            try {
                                this_$iv$iv.restoreCurrent(previous$iv$iv);
                                snapshot$iv.dispose();
                            } catch (Throwable th2) {
                                th = th2;
                                snapshot$iv.dispose();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        LayoutNode layoutNode2 = node;
                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                        throw th;
                    }
                } else {
                    LayoutNode layoutNode3 = node;
                    throw new IllegalStateException("parent composition reference not set".toString());
                }
            } catch (Throwable th5) {
                th = th5;
                Snapshot.Companion companion2 = this_$iv;
                LayoutNode layoutNode4 = node;
                this_$iv$iv.restoreCurrent(previous$iv$iv);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            Snapshot.Companion companion3 = this_$iv;
            LayoutNode layoutNode5 = node;
            snapshot$iv.dispose();
            throw th;
        }
    }

    private final Composition subcomposeInto(Composition existing, LayoutNode container, CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> composable) {
        Composition $this$subcomposeInto_u24lambda_u246;
        if (existing == null || existing.isDisposed()) {
            $this$subcomposeInto_u24lambda_u246 = Wrapper_androidKt.createSubcomposition(container, parent);
        } else {
            $this$subcomposeInto_u24lambda_u246 = existing;
        }
        $this$subcomposeInto_u24lambda_u246.setContent(composable);
        return $this$subcomposeInto_u24lambda_u246;
    }

    private final Object getSlotIdAtIndex(int index) {
        NodeState nodeState = this.nodeToNodeState.get(this.root.getFoldedChildren$ui_release().get(index));
        Intrinsics.checkNotNull(nodeState);
        return nodeState.getSlotId();
    }

    /* Debug info: failed to restart local var, previous not found, register: 22 */
    public final void disposeOrReuseStartingFromIndex(int startIndex) {
        int lastReusableIndex;
        boolean z;
        int i = startIndex;
        this.reusableCount = 0;
        int lastReusableIndex2 = (this.root.getFoldedChildren$ui_release().size() - this.precomposedCount) - 1;
        boolean needApplyNotification = false;
        if (i <= lastReusableIndex2) {
            this.reusableSlotIdsSet.clear();
            int i2 = startIndex;
            if (i2 <= lastReusableIndex2) {
                while (true) {
                    this.reusableSlotIdsSet.add(getSlotIdAtIndex(i2));
                    if (i2 == lastReusableIndex2) {
                        break;
                    }
                    i2++;
                }
            }
            this.slotReusePolicy.getSlotsToRetain(this.reusableSlotIdsSet);
            int i3 = lastReusableIndex2;
            Snapshot snapshot$iv = Snapshot.Companion.createNonObservableSnapshot();
            Snapshot this_$iv$iv = snapshot$iv;
            try {
                Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
                while (i3 >= i) {
                    try {
                        LayoutNode node = this.root.getFoldedChildren$ui_release().get(i3);
                        NodeState nodeState = this.nodeToNodeState.get(node);
                        Intrinsics.checkNotNull(nodeState);
                        NodeState nodeState2 = nodeState;
                        Object slotId = nodeState2.getSlotId();
                        if (this.reusableSlotIdsSet.contains(slotId)) {
                            try {
                                node.getMeasurePassDelegate$ui_release().setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                                LayoutNodeLayoutDelegate.LookaheadPassDelegate it = node.getLookaheadPassDelegate$ui_release();
                                if (it != null) {
                                    it.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                                }
                                this.reusableCount++;
                                if (nodeState2.getActive()) {
                                    nodeState2.setActive(false);
                                    needApplyNotification = true;
                                    lastReusableIndex = lastReusableIndex2;
                                    z = true;
                                } else {
                                    lastReusableIndex = lastReusableIndex2;
                                    z = true;
                                }
                            } catch (Throwable th) {
                                th = th;
                                int i4 = lastReusableIndex2;
                                this_$iv$iv.restoreCurrent(previous$iv$iv);
                                throw th;
                            }
                        } else {
                            LayoutNode this_$iv$iv2 = this.root;
                            this_$iv$iv2.ignoreRemeasureRequests = true;
                            this.nodeToNodeState.remove(node);
                            Composition composition = nodeState2.getComposition();
                            if (composition != null) {
                                composition.dispose();
                            }
                            lastReusableIndex = lastReusableIndex2;
                            z = true;
                            this.root.removeAt$ui_release(i3, 1);
                            this_$iv$iv2.ignoreRemeasureRequests = false;
                        }
                        this.slotIdToNode.remove(slotId);
                        i3--;
                        i = startIndex;
                        boolean z2 = z;
                        lastReusableIndex2 = lastReusableIndex;
                    } catch (Throwable th2) {
                        th = th2;
                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                        throw th;
                    }
                }
                Unit unit = Unit.INSTANCE;
                try {
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    snapshot$iv.dispose();
                } catch (Throwable th3) {
                    th = th3;
                    snapshot$iv.dispose();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                int i5 = lastReusableIndex2;
                snapshot$iv.dispose();
                throw th;
            }
        }
        if (needApplyNotification) {
            Snapshot.Companion.sendApplyNotifications();
        }
        makeSureStateIsConsistent();
    }

    public final void makeSureStateIsConsistent() {
        boolean z = true;
        if (this.nodeToNodeState.size() == this.root.getFoldedChildren$ui_release().size()) {
            if ((this.root.getFoldedChildren$ui_release().size() - this.reusableCount) - this.precomposedCount >= 0) {
                if (this.precomposeMap.size() != this.precomposedCount) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException(("Incorrect state. Precomposed children " + this.precomposedCount + ". Map size " + this.precomposeMap.size()).toString());
                }
                return;
            }
            throw new IllegalArgumentException(("Incorrect state. Total children " + this.root.getFoldedChildren$ui_release().size() + ". Reusable children " + this.reusableCount + ". Precomposed children " + this.precomposedCount).toString());
        }
        throw new IllegalArgumentException(("Inconsistency between the count of nodes tracked by the state (" + this.nodeToNodeState.size() + ") and the children count on the SubcomposeLayout (" + this.root.getFoldedChildren$ui_release().size() + "). Are you trying to use the state of the disposed SubcomposeLayout?").toString());
    }

    private final LayoutNode takeNodeFromReusables(Object slotId) {
        int index;
        if (this.reusableCount == 0) {
            return null;
        }
        int reusableNodesSectionEnd = this.root.getFoldedChildren$ui_release().size() - this.precomposedCount;
        int reusableNodesSectionStart = reusableNodesSectionEnd - this.reusableCount;
        int index2 = reusableNodesSectionEnd - 1;
        int chosenIndex = -1;
        while (true) {
            if (index < reusableNodesSectionStart) {
                break;
            } else if (Intrinsics.areEqual(getSlotIdAtIndex(index), slotId)) {
                chosenIndex = index;
                break;
            } else {
                index2 = index - 1;
            }
        }
        if (chosenIndex == -1) {
            index = reusableNodesSectionEnd - 1;
            while (true) {
                if (index < reusableNodesSectionStart) {
                    break;
                }
                NodeState nodeState = this.nodeToNodeState.get(this.root.getFoldedChildren$ui_release().get(index));
                Intrinsics.checkNotNull(nodeState);
                NodeState nodeState2 = nodeState;
                if (this.slotReusePolicy.areCompatible(slotId, nodeState2.getSlotId())) {
                    nodeState2.setSlotId(slotId);
                    chosenIndex = index;
                    break;
                }
                index--;
            }
        }
        if (chosenIndex == -1) {
            return null;
        }
        if (index != reusableNodesSectionStart) {
            move(index, reusableNodesSectionStart, 1);
        }
        this.reusableCount--;
        LayoutNode node = this.root.getFoldedChildren$ui_release().get(reusableNodesSectionStart);
        NodeState nodeState3 = this.nodeToNodeState.get(node);
        Intrinsics.checkNotNull(nodeState3);
        NodeState nodeState4 = nodeState3;
        nodeState4.setActive(true);
        nodeState4.setForceRecompose(true);
        Snapshot.Companion.sendApplyNotifications();
        return node;
    }

    public final MeasurePolicy createMeasurePolicy(Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.intermediateMeasureScope.setLookaheadMeasurePolicy(block);
        return new LayoutNodeSubcompositionsState$createMeasurePolicy$1(this, block, this.NoIntrinsicsMessage);
    }

    public final SubcomposeLayoutState.PrecomposedSlotHandle precompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        Object answer$iv;
        Object obj;
        Intrinsics.checkNotNullParameter(content, "content");
        makeSureStateIsConsistent();
        if (!this.slotIdToNode.containsKey(slotId)) {
            Map $this$getOrPut$iv = this.precomposeMap;
            Object value$iv = $this$getOrPut$iv.get(slotId);
            if (value$iv == null) {
                LayoutNode reusedNode = takeNodeFromReusables(slotId);
                if (reusedNode != null) {
                    move(this.root.getFoldedChildren$ui_release().indexOf(reusedNode), this.root.getFoldedChildren$ui_release().size(), 1);
                    this.precomposedCount++;
                    obj = reusedNode;
                } else {
                    obj = createNodeAt(this.root.getFoldedChildren$ui_release().size());
                    Object obj2 = obj;
                    this.precomposedCount++;
                }
                answer$iv = obj;
                $this$getOrPut$iv.put(slotId, answer$iv);
            } else {
                answer$iv = value$iv;
            }
            subcompose((LayoutNode) answer$iv, slotId, content);
        }
        return new LayoutNodeSubcompositionsState$precompose$1(this, slotId);
    }

    public final void forceRecomposeChildren() {
        for (Map.Entry<LayoutNode, NodeState> element$iv : this.nodeToNodeState.entrySet()) {
            ((NodeState) element$iv.getValue()).setForceRecompose(true);
        }
        if (!this.root.getMeasurePending$ui_release()) {
            LayoutNode.requestRemeasure$ui_release$default(this.root, false, false, 3, (Object) null);
        }
    }

    private final LayoutNode createNodeAt(int index) {
        LayoutNode node = new LayoutNode(true, 0, 2, (DefaultConstructorMarker) null);
        LayoutNode this_$iv$iv = this.root;
        this_$iv$iv.ignoreRemeasureRequests = true;
        this.root.insertAt$ui_release(index, node);
        this_$iv$iv.ignoreRemeasureRequests = false;
        return node;
    }

    static /* synthetic */ void move$default(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 1;
        }
        layoutNodeSubcompositionsState.move(i, i2, i3);
    }

    /* access modifiers changed from: private */
    public final void move(int from, int to, int count) {
        LayoutNode this_$iv$iv = this.root;
        this_$iv$iv.ignoreRemeasureRequests = true;
        this.root.move$ui_release(from, to, count);
        this_$iv$iv.ignoreRemeasureRequests = false;
    }

    private final void ignoreRemeasureRequests(Function0<Unit> block) {
        LayoutNode this_$iv = this.root;
        this_$iv.ignoreRemeasureRequests = true;
        block.invoke();
        this_$iv.ignoreRemeasureRequests = false;
    }

    public final void disposeCurrentNodes() {
        LayoutNode this_$iv = this.root;
        this_$iv.ignoreRemeasureRequests = true;
        for (NodeState it : this.nodeToNodeState.values()) {
            Composition composition = it.getComposition();
            if (composition != null) {
                composition.dispose();
            }
        }
        this.root.removeAll$ui_release();
        this_$iv.ignoreRemeasureRequests = false;
        this.nodeToNodeState.clear();
        this.slotIdToNode.clear();
        this.precomposedCount = 0;
        this.reusableCount = 0;
        this.precomposeMap.clear();
        makeSureStateIsConsistent();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0002\u0018\u00002\u00020\u0001B.\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR+\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R'\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "", "slotId", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "composition", "Landroidx/compose/runtime/Composition;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composition;)V", "<set-?>", "", "active", "getActive", "()Z", "setActive", "(Z)V", "active$delegate", "Landroidx/compose/runtime/MutableState;", "getComposition", "()Landroidx/compose/runtime/Composition;", "setComposition", "(Landroidx/compose/runtime/Composition;)V", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "forceRecompose", "getForceRecompose", "setForceRecompose", "getSlotId", "()Ljava/lang/Object;", "setSlotId", "(Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SubcomposeLayout.kt */
    private static final class NodeState {
        private final MutableState active$delegate;
        private Composition composition;
        private Function2<? super Composer, ? super Integer, Unit> content;
        private boolean forceRecompose;
        private Object slotId;

        public NodeState(Object slotId2, Function2<? super Composer, ? super Integer, Unit> content2, Composition composition2) {
            Intrinsics.checkNotNullParameter(content2, "content");
            this.slotId = slotId2;
            this.content = content2;
            this.composition = composition2;
            this.active$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NodeState(Object obj, Function2 function2, Composition composition2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, function2, (i & 4) != 0 ? null : composition2);
        }

        public final Object getSlotId() {
            return this.slotId;
        }

        public final void setSlotId(Object obj) {
            this.slotId = obj;
        }

        public final Function2<Composer, Integer, Unit> getContent() {
            return this.content;
        }

        public final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.content = function2;
        }

        public final Composition getComposition() {
            return this.composition;
        }

        public final void setComposition(Composition composition2) {
            this.composition = composition2;
        }

        public final boolean getForceRecompose() {
            return this.forceRecompose;
        }

        public final void setForceRecompose(boolean z) {
            this.forceRecompose = z;
        }

        public final boolean getActive() {
            return ((Boolean) this.active$delegate.getValue()).booleanValue();
        }

        public final void setActive(boolean z) {
            this.active$delegate.setValue(Boolean.valueOf(z));
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0002\b\u001dH\u0016¢\u0006\u0002\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "density", "", "getDensity", "()F", "setDensity", "(F)V", "fontScale", "getFontScale", "setFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SubcomposeLayout.kt */
    private final class Scope implements SubcomposeMeasureScope {
        private float density;
        private float fontScale;
        private LayoutDirection layoutDirection = LayoutDirection.Rtl;

        public Scope() {
        }

        public LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public void setLayoutDirection(LayoutDirection layoutDirection2) {
            Intrinsics.checkNotNullParameter(layoutDirection2, "<set-?>");
            this.layoutDirection = layoutDirection2;
        }

        public float getDensity() {
            return this.density;
        }

        public void setDensity(float f) {
            this.density = f;
        }

        public float getFontScale() {
            return this.fontScale;
        }

        public void setFontScale(float f) {
            this.fontScale = f;
        }

        public boolean isLookingAhead() {
            return LayoutNodeSubcompositionsState.this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadLayingOut || LayoutNodeSubcompositionsState.this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadMeasuring;
        }

        public List<Measurable> subcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return LayoutNodeSubcompositionsState.this.subcompose(slotId, content);
        }
    }

    @Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003JH\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020'0*2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-¢\u0006\u0002\b\u001cH\u0001J\u0018\u00100\u001a\b\u0012\u0004\u0012\u000202012\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u001a\u00105\u001a\u00020'*\u000206H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001a\u00105\u001a\u00020'*\u000209H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001a\u0010<\u001a\u000206*\u000209H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001d\u0010<\u001a\u000206*\u00020\u0005H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u001d\u0010<\u001a\u000206*\u00020'H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010AJ\u001a\u0010B\u001a\u00020C*\u00020DH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\u001a\u0010G\u001a\u00020\u0005*\u000206H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010@J\u001a\u0010G\u001a\u00020\u0005*\u000209H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010>J\r\u0010J\u001a\u00020K*\u00020LH\u0001J\u001a\u0010M\u001a\u00020D*\u00020CH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010FJ\u001a\u0010O\u001a\u000209*\u000206H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ\u001d\u0010O\u001a\u000209*\u00020\u0005H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010QJ\u001d\u0010O\u001a\u000209*\u00020'H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010SR\u0014\u0010\u0004\u001a\u00020\u00058\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8WX\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0011\u001a\u00020\u0012X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R4\u0010\u0018\u001a\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001b0\u0019¢\u0006\u0002\b\u001cX.ø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R%\u0010!\u001a\u00020\"X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006T"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$IntermediateMeasureScopeImpl;", "Landroidx/compose/ui/layout/SubcomposeIntermediateMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-msEJaDk", "()J", "setLookaheadConstraints-BRTryo0", "(J)V", "J", "lookaheadMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "getLookaheadMeasurePolicy", "()Lkotlin/jvm/functions/Function2;", "setLookaheadMeasurePolicy", "(Lkotlin/jvm/functions/Function2;)V", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "getLookaheadSize-YbymL2g", "setLookaheadSize-ozmzZPI", "layout", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "measurablesForSlot", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SubcomposeLayout.kt */
    private final class IntermediateMeasureScopeImpl implements SubcomposeIntermediateMeasureScope, MeasureScope {
        private final /* synthetic */ Scope $$delegate_0;
        private long lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null);
        public Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> lookaheadMeasurePolicy;
        private long lookaheadSize = IntSize.Companion.m7719getZeroYbymL2g();

        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        public LayoutDirection getLayoutDirection() {
            return this.$$delegate_0.getLayoutDirection();
        }

        public boolean isLookingAhead() {
            return this.$$delegate_0.isLookingAhead();
        }

        public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super Placeable.PlacementScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(map, "alignmentLines");
            Intrinsics.checkNotNullParameter(function1, "placementBlock");
            return this.$$delegate_0.layout(i, i2, map, function1);
        }

        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public int m6373roundToPxR2X_6o(long j) {
            return this.$$delegate_0.m7528roundToPxR2X_6o(j);
        }

        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public int m6374roundToPx0680j_4(float f) {
            return this.$$delegate_0.m7529roundToPx0680j_4(f);
        }

        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public float m6377toDpGaN1DYA(long j) {
            return this.$$delegate_0.m7530toDpGaN1DYA(j);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public float m6378toDpu2uoSUM(float f) {
            return this.$$delegate_0.m7531toDpu2uoSUM(f);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public float m6379toDpu2uoSUM(int i) {
            return this.$$delegate_0.m7532toDpu2uoSUM(i);
        }

        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public long m6380toDpSizekrfVVM(long j) {
            return this.$$delegate_0.m7533toDpSizekrfVVM(j);
        }

        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public float m6381toPxR2X_6o(long j) {
            return this.$$delegate_0.m7534toPxR2X_6o(j);
        }

        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public float m6382toPx0680j_4(float f) {
            return this.$$delegate_0.m7535toPx0680j_4(f);
        }

        public Rect toRect(DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "<this>");
            return this.$$delegate_0.toRect(dpRect);
        }

        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public long m6383toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.m7536toSizeXkaWNTQ(j);
        }

        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public long m6384toSp0xMU5do(float f) {
            return this.$$delegate_0.m7537toSp0xMU5do(f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public long m6385toSpkPz2Gy4(float f) {
            return this.$$delegate_0.m7538toSpkPz2Gy4(f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public long m6386toSpkPz2Gy4(int i) {
            return this.$$delegate_0.m7539toSpkPz2Gy4(i);
        }

        public IntermediateMeasureScopeImpl() {
            this.$$delegate_0 = LayoutNodeSubcompositionsState.this.scope;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
            r0 = r0.getChildMeasurables$ui_release();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.List<androidx.compose.ui.layout.Measurable> measurablesForSlot(java.lang.Object r2) {
            /*
                r1 = this;
                androidx.compose.ui.layout.LayoutNodeSubcompositionsState r0 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.this
                java.util.Map r0 = r0.slotIdToNode
                java.lang.Object r0 = r0.get(r2)
                androidx.compose.ui.node.LayoutNode r0 = (androidx.compose.ui.node.LayoutNode) r0
                if (r0 == 0) goto L_0x0014
                java.util.List r0 = r0.getChildMeasurables$ui_release()
                if (r0 != 0) goto L_0x0018
            L_0x0014:
                java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            L_0x0018:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.IntermediateMeasureScopeImpl.measurablesForSlot(java.lang.Object):java.util.List");
        }

        /* renamed from: getLookaheadSize-YbymL2g  reason: not valid java name */
        public long m6372getLookaheadSizeYbymL2g() {
            return this.lookaheadSize;
        }

        /* renamed from: setLookaheadSize-ozmzZPI  reason: not valid java name */
        public void m6376setLookaheadSizeozmzZPI(long j) {
            this.lookaheadSize = j;
        }

        public Function2<SubcomposeMeasureScope, Constraints, MeasureResult> getLookaheadMeasurePolicy() {
            Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2 = this.lookaheadMeasurePolicy;
            if (function2 != null) {
                return function2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("lookaheadMeasurePolicy");
            return null;
        }

        public void setLookaheadMeasurePolicy(Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.lookaheadMeasurePolicy = function2;
        }

        /* renamed from: getLookaheadConstraints-msEJaDk  reason: not valid java name */
        public long m6371getLookaheadConstraintsmsEJaDk() {
            return this.lookaheadConstraints;
        }

        /* renamed from: setLookaheadConstraints-BRTryo0  reason: not valid java name */
        public void m6375setLookaheadConstraintsBRTryo0(long j) {
            this.lookaheadConstraints = j;
        }
    }
}

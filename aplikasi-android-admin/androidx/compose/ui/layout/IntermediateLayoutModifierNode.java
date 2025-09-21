package androidx.compose.ui.layout;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.NodeMeasuringIntrinsics;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u000289BK\u0012A\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\b\u0010 \u001a\u00020!H\u0016J7\u0010\"\u001a\u00020\f*\u00020#2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020)*\u00020*2\u0006\u0010\t\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0000¢\u0006\u0002\b-J!\u0010.\u001a\u00020)*\u00020*2\u0006\u0010\t\u001a\u00020+2\u0006\u0010/\u001a\u00020)H\u0000¢\u0006\u0002\b0J)\u00101\u001a\u00020\f*\u00020#2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103J!\u00104\u001a\u00020)*\u00020*2\u0006\u0010\t\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0000¢\u0006\u0002\b5J!\u00106\u001a\u00020)*\u00020*2\u0006\u0010\t\u001a\u00020+2\u0006\u0010/\u001a\u00020)H\u0000¢\u0006\u0002\b7R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00060\u0014R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\nX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000RX\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\rX\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006:"}, d2 = {"Landroidx/compose/ui/layout/IntermediateLayoutModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "measureBlock", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/IntermediateMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Lkotlin/ParameterName;", "name", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "closestLookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "intermediateMeasurable", "Landroidx/compose/ui/layout/IntermediateLayoutModifierNode$IntermediateMeasurablePlaceable;", "intermediateMeasureScope", "Landroidx/compose/ui/layout/IntermediateLayoutModifierNode$IntermediateMeasureScopeImpl;", "isIntermediateChangeActive", "", "()Z", "setIntermediateChangeActive", "(Z)V", "localLookaheadScope", "Landroidx/compose/ui/layout/LookaheadScopeImpl;", "lookaheadConstraints", "getMeasureBlock$ui_release", "()Lkotlin/jvm/functions/Function3;", "setMeasureBlock$ui_release", "onAttach", "", "intermediateMeasure", "Landroidx/compose/ui/layout/MeasureScope;", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "intermediateMeasure-Te-uZzU", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;JJJ)Landroidx/compose/ui/layout/MeasureResult;", "maxIntermediateIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntermediateIntrinsicHeight$ui_release", "maxIntermediateIntrinsicWidth", "height", "maxIntermediateIntrinsicWidth$ui_release", "measure", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntermediateIntrinsicHeight", "minIntermediateIntrinsicHeight$ui_release", "minIntermediateIntrinsicWidth", "minIntermediateIntrinsicWidth$ui_release", "IntermediateMeasurablePlaceable", "IntermediateMeasureScopeImpl", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IntermediateLayoutModifierNode.kt */
public final class IntermediateLayoutModifierNode extends Modifier.Node implements LayoutModifierNode {
    /* access modifiers changed from: private */
    public LookaheadScope closestLookaheadScope;
    private IntermediateMeasurablePlaceable intermediateMeasurable;
    /* access modifiers changed from: private */
    public final IntermediateMeasureScopeImpl intermediateMeasureScope = new IntermediateMeasureScopeImpl();
    private boolean isIntermediateChangeActive;
    private final LookaheadScopeImpl localLookaheadScope;
    /* access modifiers changed from: private */
    public Constraints lookaheadConstraints;
    private Function3<? super IntermediateMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> measureBlock;

    public final Function3<IntermediateMeasureScope, Measurable, Constraints, MeasureResult> getMeasureBlock$ui_release() {
        return this.measureBlock;
    }

    public final void setMeasureBlock$ui_release(Function3<? super IntermediateMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.measureBlock = function3;
    }

    public IntermediateLayoutModifierNode(Function3<? super IntermediateMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> measureBlock2) {
        Intrinsics.checkNotNullParameter(measureBlock2, "measureBlock");
        this.measureBlock = measureBlock2;
        LookaheadScopeImpl lookaheadScopeImpl = new LookaheadScopeImpl(new IntermediateLayoutModifierNode$localLookaheadScope$1(this));
        this.localLookaheadScope = lookaheadScopeImpl;
        this.closestLookaheadScope = lookaheadScopeImpl;
        this.isIntermediateChangeActive = true;
    }

    public final boolean isIntermediateChangeActive() {
        return this.isIntermediateChangeActive;
    }

    public final void setIntermediateChangeActive(boolean z) {
        this.isIntermediateChangeActive = z;
    }

    public void onAttach() {
        LookaheadScope lookaheadScope;
        LookaheadScope lookaheadScope2;
        LookaheadLayoutCoordinatesImpl coordinates;
        LayoutNode layoutNode;
        int i;
        NodeChain nodes$ui_release;
        int i2;
        LayoutNode layoutNode2;
        LookaheadLayoutCoordinatesImpl coordinates2;
        LayoutNode layoutNode3;
        int i3;
        LookaheadLayoutCoordinatesImpl coordinates3;
        LookaheadLayoutCoordinatesImpl coordinates4;
        LayoutNode layoutNode4;
        MutableVector mutableVector;
        NodeCoordinator coordinator$ui_release = getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release);
        LayoutNode layoutNode5 = coordinator$ui_release.getLayoutNode();
        NodeCoordinator coordinator$ui_release2 = getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release2);
        LookaheadDelegate lookaheadDelegate = coordinator$ui_release2.getLookaheadDelegate();
        LookaheadLayoutCoordinatesImpl coordinates5 = lookaheadDelegate != null ? lookaheadDelegate.getLookaheadLayoutCoordinates() : null;
        int i4 = 1;
        if (coordinates5 != null) {
            LayoutNode closestLookaheadRoot = layoutNode5.getLookaheadRoot$ui_release();
            if (closestLookaheadRoot != null && closestLookaheadRoot.isVirtualLookaheadRoot$ui_release()) {
                lookaheadScope = new LookaheadScopeImpl(new IntermediateLayoutModifierNode$onAttach$1(closestLookaheadRoot));
                LayoutNode layoutNode6 = layoutNode5;
                LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl = coordinates5;
            } else {
                IntermediateLayoutModifierNode intermediateLayoutModifierNode = null;
                int type$iv = NodeKind.m6666constructorimpl(512);
                int mask$iv$iv = type$iv;
                DelegatableNode $this$visitAncestors$iv$iv = this;
                if ($this$visitAncestors$iv$iv.getNode().isAttached()) {
                    Modifier.Node node$iv$iv = $this$visitAncestors$iv$iv.getNode().getParent$ui_release();
                    LayoutNode layout$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv);
                    while (layout$iv$iv != null) {
                        if ((layout$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                            while (node$iv$iv != null) {
                                if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                                    MutableVector mutableVector2 = null;
                                    Modifier.Node this_$iv$iv$iv = node$iv$iv;
                                    while (this_$iv$iv$iv != null) {
                                        if (this_$iv$iv$iv instanceof IntermediateLayoutModifierNode) {
                                            intermediateLayoutModifierNode = (IntermediateLayoutModifierNode) this_$iv$iv$iv;
                                            layoutNode3 = layoutNode2;
                                            coordinates2 = coordinates5;
                                            i3 = i2;
                                        } else {
                                            if (((this_$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? i2 : 0) == 0 || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                                                layoutNode3 = layoutNode2;
                                                coordinates2 = coordinates5;
                                                i3 = i2;
                                            } else {
                                                int count$iv$iv = 0;
                                                Modifier.Node node$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                                                while (node$iv$iv$iv != null) {
                                                    Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                    if (((next$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? i2 : 0) != 0) {
                                                        count$iv$iv++;
                                                        if (count$iv$iv == i2) {
                                                            this_$iv$iv$iv = next$iv$iv;
                                                            layoutNode4 = layoutNode2;
                                                            coordinates4 = coordinates5;
                                                            Modifier.Node node = next$iv$iv;
                                                        } else {
                                                            if (mutableVector2 == null) {
                                                                layoutNode4 = layoutNode2;
                                                                coordinates4 = coordinates5;
                                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                            } else {
                                                                layoutNode4 = layoutNode2;
                                                                coordinates4 = coordinates5;
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
                                                        layoutNode4 = layoutNode2;
                                                        coordinates4 = coordinates5;
                                                        Modifier.Node node2 = next$iv$iv;
                                                    }
                                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                                    layoutNode2 = layoutNode4;
                                                    coordinates5 = coordinates4;
                                                    i2 = 1;
                                                }
                                                layoutNode3 = layoutNode2;
                                                coordinates2 = coordinates5;
                                                i3 = 1;
                                                if (count$iv$iv == 1) {
                                                    i2 = 1;
                                                    layoutNode2 = layoutNode3;
                                                    coordinates3 = coordinates2;
                                                }
                                            }
                                        }
                                        this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector2);
                                        i2 = i3;
                                        layoutNode2 = layoutNode3;
                                        coordinates3 = coordinates2;
                                    }
                                }
                                node$iv$iv = node$iv$iv.getParent$ui_release();
                                i4 = i2;
                                layoutNode5 = layoutNode2;
                                coordinates5 = coordinates5;
                            }
                            layoutNode = layoutNode2;
                            coordinates = coordinates5;
                            i = i2;
                        } else {
                            layoutNode = layoutNode5;
                            coordinates = coordinates5;
                            i = i4;
                        }
                        layout$iv$iv = layout$iv$iv.getParent$ui_release();
                        node$iv$iv = (layout$iv$iv == null || (nodes$ui_release = layout$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                        i4 = i;
                        layoutNode5 = layoutNode;
                        coordinates5 = coordinates;
                    }
                    LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl2 = coordinates5;
                    if (intermediateLayoutModifierNode == null || (lookaheadScope2 = intermediateLayoutModifierNode.localLookaheadScope) == null) {
                        lookaheadScope2 = this.localLookaheadScope;
                    }
                    lookaheadScope = lookaheadScope2;
                } else {
                    LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl3 = coordinates5;
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
            }
            this.closestLookaheadScope = lookaheadScope;
            return;
        }
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl4 = coordinates5;
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m6337measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Placeable $this$measure_3p2s80s_u24lambda_u241 = measurable.m6399measureBRTryo0(constraints);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, $this$measure_3p2s80s_u24lambda_u241.getWidth(), $this$measure_3p2s80s_u24lambda_u241.getHeight(), (Map) null, new IntermediateLayoutModifierNode$measure$1$1($this$measure_3p2s80s_u24lambda_u241), 4, (Object) null);
    }

    /* renamed from: intermediateMeasure-Te-uZzU  reason: not valid java name */
    public final MeasureResult m6336intermediateMeasureTeuZzU(MeasureScope $this$intermediateMeasure_u2dTe_u2duZzU, Measurable measurable, long constraints, long lookaheadSize, long lookaheadConstraints2) {
        Intrinsics.checkNotNullParameter($this$intermediateMeasure_u2dTe_u2duZzU, "$this$intermediateMeasure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        this.intermediateMeasureScope.m6341setLookaheadSizeozmzZPI(lookaheadSize);
        this.lookaheadConstraints = Constraints.m7486boximpl(lookaheadConstraints2);
        IntermediateMeasurablePlaceable wrappedMeasurable = this.intermediateMeasurable;
        if (wrappedMeasurable == null) {
            wrappedMeasurable = new IntermediateMeasurablePlaceable(this, measurable);
        }
        IntermediateMeasurablePlaceable $this$intermediateMeasure_Te_uZzU_u24lambda_u242 = wrappedMeasurable;
        this.intermediateMeasurable = $this$intermediateMeasure_Te_uZzU_u24lambda_u242;
        $this$intermediateMeasure_Te_uZzU_u24lambda_u242.setWrappedMeasurable(measurable);
        return (MeasureResult) this.measureBlock.invoke(this.intermediateMeasureScope, wrappedMeasurable, Constraints.m7486boximpl(constraints));
    }

    public final int minIntermediateIntrinsicWidth$ui_release(IntrinsicMeasureScope $this$minIntermediateIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntermediateIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release(new IntermediateLayoutModifierNode$minIntermediateIntrinsicWidth$1(this), $this$minIntermediateIntrinsicWidth, measurable, height);
    }

    public final int minIntermediateIntrinsicHeight$ui_release(IntrinsicMeasureScope $this$minIntermediateIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntermediateIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release(new IntermediateLayoutModifierNode$minIntermediateIntrinsicHeight$1(this), $this$minIntermediateIntrinsicHeight, measurable, width);
    }

    public final int maxIntermediateIntrinsicWidth$ui_release(IntrinsicMeasureScope $this$maxIntermediateIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntermediateIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release(new IntermediateLayoutModifierNode$maxIntermediateIntrinsicWidth$1(this), $this$maxIntermediateIntrinsicWidth, measurable, height);
    }

    public final int maxIntermediateIntrinsicHeight$ui_release(IntrinsicMeasureScope $this$maxIntermediateIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntermediateIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release(new IntermediateLayoutModifierNode$maxIntermediateIntrinsicHeight$1(this), $this$maxIntermediateIntrinsicHeight, measurable, width);
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\u001d\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J@\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0019\u0010'\u001a\u0015\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"\u0018\u00010(¢\u0006\u0002\b*H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006-"}, d2 = {"Landroidx/compose/ui/layout/IntermediateLayoutModifierNode$IntermediateMeasurablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "wrappedMeasurable", "(Landroidx/compose/ui/layout/IntermediateLayoutModifierNode;Landroidx/compose/ui/layout/Measurable;)V", "parentData", "", "getParentData", "()Ljava/lang/Object;", "getWrappedMeasurable", "()Landroidx/compose/ui/layout/Measurable;", "setWrappedMeasurable", "(Landroidx/compose/ui/layout/Measurable;)V", "wrappedPlaceable", "getWrappedPlaceable", "()Landroidx/compose/ui/layout/Placeable;", "setWrappedPlaceable", "(Landroidx/compose/ui/layout/Placeable;)V", "get", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "placeAt", "", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: IntermediateLayoutModifierNode.kt */
    private final class IntermediateMeasurablePlaceable extends Placeable implements Measurable {
        final /* synthetic */ IntermediateLayoutModifierNode this$0;
        private Measurable wrappedMeasurable;
        private Placeable wrappedPlaceable;

        public IntermediateMeasurablePlaceable(IntermediateLayoutModifierNode this$02, Measurable wrappedMeasurable2) {
            Intrinsics.checkNotNullParameter(wrappedMeasurable2, "wrappedMeasurable");
            this.this$0 = this$02;
            this.wrappedMeasurable = wrappedMeasurable2;
        }

        public final Measurable getWrappedMeasurable() {
            return this.wrappedMeasurable;
        }

        public final void setWrappedMeasurable(Measurable measurable) {
            Intrinsics.checkNotNullParameter(measurable, "<set-?>");
            this.wrappedMeasurable = measurable;
        }

        public final Placeable getWrappedPlaceable() {
            return this.wrappedPlaceable;
        }

        public final void setWrappedPlaceable(Placeable placeable) {
            this.wrappedPlaceable = placeable;
        }

        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m6338measureBRTryo0(long constraints) {
            Placeable placeable;
            long j;
            if (this.this$0.isIntermediateChangeActive()) {
                placeable = this.wrappedMeasurable.m6399measureBRTryo0(constraints);
                Placeable it = placeable;
                m6438setMeasurementConstraintsBRTryo0(constraints);
                m6437setMeasuredSizeozmzZPI(IntSizeKt.IntSize(it.getWidth(), it.getHeight()));
            } else {
                Measurable measurable = this.wrappedMeasurable;
                Constraints access$getLookaheadConstraints$p = this.this$0.lookaheadConstraints;
                Intrinsics.checkNotNull(access$getLookaheadConstraints$p);
                placeable = measurable.m6399measureBRTryo0(access$getLookaheadConstraints$p.m7504unboximpl());
                IntermediateLayoutModifierNode intermediateLayoutModifierNode = this.this$0;
                Placeable it2 = placeable;
                Constraints access$getLookaheadConstraints$p2 = intermediateLayoutModifierNode.lookaheadConstraints;
                Intrinsics.checkNotNull(access$getLookaheadConstraints$p2);
                m6438setMeasurementConstraintsBRTryo0(access$getLookaheadConstraints$p2.m7504unboximpl());
                if (intermediateLayoutModifierNode.isIntermediateChangeActive()) {
                    j = IntSizeKt.IntSize(it2.getWidth(), it2.getHeight());
                } else {
                    j = intermediateLayoutModifierNode.intermediateMeasureScope.m6340getLookaheadSizeYbymL2g();
                }
                m6437setMeasuredSizeozmzZPI(j);
            }
            this.wrappedPlaceable = placeable;
            return this;
        }

        /* access modifiers changed from: protected */
        /* renamed from: placeAt-f8xVGno  reason: not valid java name */
        public void m6339placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            Unit unit;
            long offset = this.this$0.isIntermediateChangeActive() ? position : IntOffset.Companion.m7682getZeronOccac();
            if (layerBlock != null) {
                Function1 it = layerBlock;
                Placeable placeable = this.wrappedPlaceable;
                if (placeable != null) {
                    Placeable.PlacementScope.Companion.m6448placeWithLayeraW9wM(placeable, offset, zIndex, it);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) {
                    return;
                }
            }
            Placeable placeable2 = this.wrappedPlaceable;
            if (placeable2 != null) {
                Placeable.PlacementScope.Companion.m6443place70tqf50(placeable2, offset, zIndex);
                Unit unit2 = Unit.INSTANCE;
            }
        }

        public Object getParentData() {
            return this.wrappedMeasurable.getParentData();
        }

        public int get(AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            Placeable placeable = this.wrappedPlaceable;
            Intrinsics.checkNotNull(placeable);
            return placeable.get(alignmentLine);
        }

        public int minIntrinsicWidth(int height) {
            return this.wrappedMeasurable.minIntrinsicWidth(height);
        }

        public int maxIntrinsicWidth(int height) {
            return this.wrappedMeasurable.maxIntrinsicWidth(height);
        }

        public int minIntrinsicHeight(int width) {
            return this.wrappedMeasurable.minIntrinsicHeight(width);
        }

        public int maxIntrinsicHeight(int width) {
            return this.wrappedMeasurable.maxIntrinsicHeight(width);
        }
    }

    @Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003JE\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020$0'2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,H\u0016JD\u0010-\u001a\u00020.*\u00020.26\u0010-\u001a2\u0012\u0013\u0012\u001100¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u001100¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020+0/H\u0017J\f\u00104\u001a\u00020\u001d*\u00020\u001dH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R%\u0010\u0015\u001a\u00020\u0016X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u00020\u001d*\u00020\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00065"}, d2 = {"Landroidx/compose/ui/layout/IntermediateLayoutModifierNode$IntermediateMeasureScopeImpl;", "Landroidx/compose/ui/layout/IntermediateMeasureScope;", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/layout/IntermediateLayoutModifierNode;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "getLookaheadSize-YbymL2g", "()J", "setLookaheadSize-ozmzZPI", "(J)V", "J", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "onPlaced", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "Lkotlin/ParameterName;", "name", "layoutCoordinates", "toLookaheadCoordinates", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: IntermediateLayoutModifierNode.kt */
    private final class IntermediateMeasureScopeImpl implements IntermediateMeasureScope, CoroutineScope {
        private long lookaheadSize = IntSize.Companion.m7719getZeroYbymL2g();

        public IntermediateMeasureScopeImpl() {
        }

        /* renamed from: getLookaheadSize-YbymL2g  reason: not valid java name */
        public long m6340getLookaheadSizeYbymL2g() {
            return this.lookaheadSize;
        }

        /* renamed from: setLookaheadSize-ozmzZPI  reason: not valid java name */
        public void m6341setLookaheadSizeozmzZPI(long j) {
            this.lookaheadSize = j;
        }

        public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates $this$toLookaheadCoordinates) {
            Intrinsics.checkNotNullParameter($this$toLookaheadCoordinates, "<this>");
            return IntermediateLayoutModifierNode.this.closestLookaheadScope.toLookaheadCoordinates($this$toLookaheadCoordinates);
        }

        public LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope $this$lookaheadScopeCoordinates) {
            Intrinsics.checkNotNullParameter($this$lookaheadScopeCoordinates, "<this>");
            return IntermediateLayoutModifierNode.this.closestLookaheadScope.getLookaheadScopeCoordinates($this$lookaheadScopeCoordinates);
        }

        @Deprecated(message = "onPlaced in LookaheadLayoutScope has been deprecated. It's replaced with reading LookaheadLayoutCoordinates directly during placement inIntermediateMeasureScope")
        public Modifier onPlaced(Modifier $this$onPlaced, Function2<? super LookaheadLayoutCoordinates, ? super LookaheadLayoutCoordinates, Unit> onPlaced) {
            Intrinsics.checkNotNullParameter($this$onPlaced, "<this>");
            Intrinsics.checkNotNullParameter(onPlaced, "onPlaced");
            return IntermediateLayoutModifierNode.this.closestLookaheadScope.onPlaced($this$onPlaced, onPlaced);
        }

        public MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
            Intrinsics.checkNotNullParameter(alignmentLines, "alignmentLines");
            Intrinsics.checkNotNullParameter(placementBlock, "placementBlock");
            return new IntermediateLayoutModifierNode$IntermediateMeasureScopeImpl$layout$1(width, height, alignmentLines, this, IntermediateLayoutModifierNode.this, placementBlock);
        }

        public boolean isLookingAhead() {
            return false;
        }

        public LayoutDirection getLayoutDirection() {
            NodeCoordinator coordinator$ui_release = IntermediateLayoutModifierNode.this.getCoordinator$ui_release();
            Intrinsics.checkNotNull(coordinator$ui_release);
            return coordinator$ui_release.getLayoutDirection();
        }

        public float getDensity() {
            NodeCoordinator coordinator$ui_release = IntermediateLayoutModifierNode.this.getCoordinator$ui_release();
            Intrinsics.checkNotNull(coordinator$ui_release);
            return coordinator$ui_release.getDensity();
        }

        public float getFontScale() {
            NodeCoordinator coordinator$ui_release = IntermediateLayoutModifierNode.this.getCoordinator$ui_release();
            Intrinsics.checkNotNull(coordinator$ui_release);
            return coordinator$ui_release.getFontScale();
        }

        public CoroutineContext getCoroutineContext() {
            return IntermediateLayoutModifierNode.this.getCoroutineScope().getCoroutineContext();
        }
    }
}

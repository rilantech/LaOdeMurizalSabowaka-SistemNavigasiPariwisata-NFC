package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.IntermediateLayoutModifierNode;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001dH\u0016J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0016J\u001d\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000eH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001dH\u0016J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0016J\u0010\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020/H\u0016J@\u00100\u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0019\u00105\u001a\u0015\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020!\u0018\u000106¢\u0006\u0002\b8H\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:R$\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f@TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006="}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "measureNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutModifierNode;)V", "<set-?>", "layoutModifierNode", "getLayoutModifierNode", "()Landroidx/compose/ui/node/LayoutModifierNode;", "setLayoutModifierNode$ui_release", "(Landroidx/compose/ui/node/LayoutModifierNode;)V", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrappedNonNull", "getWrappedNonNull", "()Landroidx/compose/ui/node/NodeCoordinator;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "ensureLookaheadDelegateCreated", "", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "Companion", "LookaheadDelegateForLayoutModifierNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutModifierNodeCoordinator.kt */
public final class LayoutModifierNodeCoordinator extends NodeCoordinator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Paint modifierBoundsPaint;
    private LayoutModifierNode layoutModifierNode;
    /* access modifiers changed from: private */
    public Constraints lookaheadConstraints;
    private LookaheadDelegate lookaheadDelegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutModifierNodeCoordinator(LayoutNode layoutNode, LayoutModifierNode measureNode) {
        super(layoutNode);
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Intrinsics.checkNotNullParameter(measureNode, "measureNode");
        this.layoutModifierNode = measureNode;
        this.lookaheadDelegate = layoutNode.getLookaheadRoot$ui_release() != null ? new LookaheadDelegateForLayoutModifierNode() : null;
    }

    public final LayoutModifierNode getLayoutModifierNode() {
        return this.layoutModifierNode;
    }

    public final void setLayoutModifierNode$ui_release(LayoutModifierNode layoutModifierNode2) {
        Intrinsics.checkNotNullParameter(layoutModifierNode2, "<set-?>");
        this.layoutModifierNode = layoutModifierNode2;
    }

    public Modifier.Node getTail() {
        return this.layoutModifierNode.getNode();
    }

    public final NodeCoordinator getWrappedNonNull() {
        NodeCoordinator wrapped$ui_release = getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        return wrapped$ui_release;
    }

    public LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    /* access modifiers changed from: protected */
    public void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate2) {
        this.lookaheadDelegate = lookaheadDelegate2;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForLayoutModifierNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;)V", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutModifierNodeCoordinator.kt */
    private final class LookaheadDelegateForLayoutModifierNode extends LookaheadDelegate {
        public LookaheadDelegateForLayoutModifierNode() {
            super(LayoutModifierNodeCoordinator.this);
        }

        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m6535measureBRTryo0(long constraints) {
            LookaheadDelegate this_$iv = this;
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            this_$iv.m6438setMeasurementConstraintsBRTryo0(constraints);
            layoutModifierNodeCoordinator.lookaheadConstraints = Constraints.m7486boximpl(constraints);
            LookaheadDelegate lookaheadDelegate = layoutModifierNodeCoordinator.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            this_$iv.set_measureResult(layoutModifierNodeCoordinator.getLayoutModifierNode().m6528measure3p2s80s(this, lookaheadDelegate, constraints));
            return this_$iv;
        }

        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            int it = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(it));
            return it;
        }

        public int minIntrinsicWidth(int height) {
            LayoutModifierNode $this$minIntrinsicWidth_u24lambda_u243 = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return $this$minIntrinsicWidth_u24lambda_u243.minIntrinsicWidth(this, lookaheadDelegate, height);
        }

        public int maxIntrinsicWidth(int height) {
            LayoutModifierNode $this$maxIntrinsicWidth_u24lambda_u244 = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return $this$maxIntrinsicWidth_u24lambda_u244.maxIntrinsicWidth(this, lookaheadDelegate, height);
        }

        public int minIntrinsicHeight(int width) {
            LayoutModifierNode $this$minIntrinsicHeight_u24lambda_u245 = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return $this$minIntrinsicHeight_u24lambda_u245.minIntrinsicHeight(this, lookaheadDelegate, width);
        }

        public int maxIntrinsicHeight(int width) {
            LayoutModifierNode $this$maxIntrinsicHeight_u24lambda_u246 = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return $this$maxIntrinsicHeight_u24lambda_u246.maxIntrinsicHeight(this, lookaheadDelegate, width);
        }
    }

    public void ensureLookaheadDelegateCreated() {
        if (getLookaheadDelegate() == null) {
            setLookaheadDelegate(new LookaheadDelegateForLayoutModifierNode());
        }
    }

    /* renamed from: measure-BRTryo0  reason: not valid java name */
    public Placeable m6533measureBRTryo0(long constraints) {
        MeasureResult measureResult;
        long j = constraints;
        m6438setMeasurementConstraintsBRTryo0(j);
        LayoutModifierNode $this$measure_BRTryo0_u24lambda_u242_u24lambda_u241 = getLayoutModifierNode();
        if ($this$measure_BRTryo0_u24lambda_u242_u24lambda_u241 instanceof IntermediateLayoutModifierNode) {
            LookaheadDelegate lookaheadDelegate2 = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate2);
            MeasureResult it = lookaheadDelegate2.getMeasureResult$ui_release();
            long IntSize = IntSizeKt.IntSize(it.getWidth(), it.getHeight());
            Constraints access$getLookaheadConstraints$p = this.lookaheadConstraints;
            Intrinsics.checkNotNull(access$getLookaheadConstraints$p);
            measureResult = ((IntermediateLayoutModifierNode) $this$measure_BRTryo0_u24lambda_u242_u24lambda_u241).m6336intermediateMeasureTeuZzU(this, getWrappedNonNull(), constraints, IntSize, access$getLookaheadConstraints$p.m7504unboximpl());
        } else {
            measureResult = $this$measure_BRTryo0_u24lambda_u242_u24lambda_u241.m6528measure3p2s80s(this, getWrappedNonNull(), j);
        }
        setMeasureResult$ui_release(measureResult);
        Placeable placeable = this;
        onMeasured();
        return this;
    }

    public int minIntrinsicWidth(int height) {
        LayoutModifierNode layoutModifierNode2 = this.layoutModifierNode;
        IntermediateLayoutModifierNode $this$minIntrinsicWidth_u24lambda_u243 = layoutModifierNode2 instanceof IntermediateLayoutModifierNode ? (IntermediateLayoutModifierNode) layoutModifierNode2 : null;
        if ($this$minIntrinsicWidth_u24lambda_u243 != null) {
            return $this$minIntrinsicWidth_u24lambda_u243.minIntermediateIntrinsicWidth$ui_release(this, getWrappedNonNull(), height);
        }
        return this.layoutModifierNode.minIntrinsicWidth(this, getWrappedNonNull(), height);
    }

    public int maxIntrinsicWidth(int height) {
        LayoutModifierNode layoutModifierNode2 = this.layoutModifierNode;
        IntermediateLayoutModifierNode $this$maxIntrinsicWidth_u24lambda_u245 = layoutModifierNode2 instanceof IntermediateLayoutModifierNode ? (IntermediateLayoutModifierNode) layoutModifierNode2 : null;
        if ($this$maxIntrinsicWidth_u24lambda_u245 != null) {
            return $this$maxIntrinsicWidth_u24lambda_u245.maxIntermediateIntrinsicWidth$ui_release(this, getWrappedNonNull(), height);
        }
        return this.layoutModifierNode.maxIntrinsicWidth(this, getWrappedNonNull(), height);
    }

    public int minIntrinsicHeight(int width) {
        LayoutModifierNode layoutModifierNode2 = this.layoutModifierNode;
        IntermediateLayoutModifierNode $this$minIntrinsicHeight_u24lambda_u247 = layoutModifierNode2 instanceof IntermediateLayoutModifierNode ? (IntermediateLayoutModifierNode) layoutModifierNode2 : null;
        if ($this$minIntrinsicHeight_u24lambda_u247 != null) {
            return $this$minIntrinsicHeight_u24lambda_u247.minIntermediateIntrinsicHeight$ui_release(this, getWrappedNonNull(), width);
        }
        return this.layoutModifierNode.minIntrinsicHeight(this, getWrappedNonNull(), width);
    }

    public int maxIntrinsicHeight(int width) {
        LayoutModifierNode layoutModifierNode2 = this.layoutModifierNode;
        IntermediateLayoutModifierNode $this$maxIntrinsicHeight_u24lambda_u249 = layoutModifierNode2 instanceof IntermediateLayoutModifierNode ? (IntermediateLayoutModifierNode) layoutModifierNode2 : null;
        if ($this$maxIntrinsicHeight_u24lambda_u249 != null) {
            return $this$maxIntrinsicHeight_u24lambda_u249.maxIntermediateIntrinsicHeight$ui_release(this, getWrappedNonNull(), width);
        }
        return this.layoutModifierNode.maxIntrinsicHeight(this, getWrappedNonNull(), width);
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m6534placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        super.m6649placeAtf8xVGno(position, zIndex, layerBlock);
        if (!isShallowPlacing$ui_release()) {
            onPlaced();
            Placeable.PlacementScope.Companion this_$iv = Placeable.PlacementScope.Companion;
            int parentWidth$iv = IntSize.m7714getWidthimpl(m6434getMeasuredSizeYbymL2g());
            LayoutDirection parentLayoutDirection$iv = getLayoutDirection();
            LayoutCoordinates previousLayoutCoordinates$iv = Placeable.PlacementScope._coordinates;
            int previousParentWidth$iv = Placeable.PlacementScope.Companion.getParentWidth();
            LayoutDirection previousParentLayoutDirection$iv = Placeable.PlacementScope.Companion.getParentLayoutDirection();
            LayoutNodeLayoutDelegate previousLayoutDelegate$iv = Placeable.PlacementScope.layoutDelegate;
            Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
            Placeable.PlacementScope.parentWidth = parentWidth$iv;
            Placeable.PlacementScope.Companion companion2 = Placeable.PlacementScope.Companion;
            Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection$iv;
            boolean wasPlacingForAlignment$iv = this_$iv.configureForPlacingForAlignment(this);
            Placeable.PlacementScope placementScope = this_$iv;
            getMeasureResult$ui_release().placeChildren();
            setPlacingForAlignment$ui_release(wasPlacingForAlignment$iv);
            Placeable.PlacementScope.Companion companion3 = Placeable.PlacementScope.Companion;
            Placeable.PlacementScope.parentWidth = previousParentWidth$iv;
            Placeable.PlacementScope.Companion companion4 = Placeable.PlacementScope.Companion;
            Placeable.PlacementScope.parentLayoutDirection = previousParentLayoutDirection$iv;
            Placeable.PlacementScope._coordinates = previousLayoutCoordinates$iv;
            Placeable.PlacementScope.layoutDelegate = previousLayoutDelegate$iv;
        }
    }

    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate2 = getLookaheadDelegate();
        if (lookaheadDelegate2 != null) {
            return lookaheadDelegate2.getCachedAlignmentLine$ui_release(alignmentLine);
        }
        return LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
    }

    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getWrappedNonNull().draw(canvas);
        if (LayoutNodeKt.requireOwner(getLayoutNode()).getShowLayoutBounds()) {
            drawBorder(canvas, modifierBoundsPaint);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$Companion;", "", "()V", "modifierBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getModifierBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutModifierNodeCoordinator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getModifierBoundsPaint() {
            return LayoutModifierNodeCoordinator.modifierBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint paint = Paint;
        paint.m5228setColor8_81llA(Color.Companion.m4990getBlue0d7_KjU());
        paint.setStrokeWidth(1.0f);
        paint.m5232setStylek9PVt8s(PaintingStyle.Companion.m5241getStrokeTiuSbCo());
        modifierBoundsPaint = Paint;
    }
}

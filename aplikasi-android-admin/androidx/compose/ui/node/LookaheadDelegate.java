package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010F\u001a\u00020\u00122\u0006\u0010G\u001a\u00020\u0011H\u0000¢\u0006\u0002\bHJ\u0010\u0010I\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u0012H\u0016J\u0010\u0010K\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u0012H\u0016J\u0010\u0010M\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u0012H\u0016J\u0010\u0010N\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u0012H\u0016J/\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00070TH\bø\u0001\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bU\u0010VJ@\u0010W\u001a\u00020X2\u0006\u0010?\u001a\u00020@2\u0006\u0010Y\u001a\u00020\u001f2\u0019\u0010Z\u001a\u0015\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020X\u0018\u00010[¢\u0006\u0002\b]H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010_J\b\u0010`\u001a\u00020XH\u0014J \u0010a\u001a\u00020@2\u0006\u0010b\u001a\u00020\u0000H\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bc\u0010dJ\r\u0010e\u001a\u00020XH\u0010¢\u0006\u0002\bfR\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0014\u0010$\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020*8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.8VX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00078PX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001c\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u00109\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0017R\u0016\u0010;\u001a\u0004\u0018\u00010<8VX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R%\u0010?\u001a\u00020@X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010E\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b20\u0001¨\u0006g"}, d2 = {"Landroidx/compose/ui/node/LookaheadDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "result", "Landroidx/compose/ui/layout/MeasureResult;", "_measureResult", "set_measureResult", "(Landroidx/compose/ui/layout/MeasureResult;)V", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "cachedAlignmentLinesMap", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getCachedAlignmentLinesMap", "()Ljava/util/Map;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "isLookingAhead", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "lookaheadLayoutCoordinates", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "getLookaheadLayoutCoordinates", "()Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "oldAlignmentLines", "parent", "getParent", "parentData", "", "getParentData", "()Ljava/lang/Object;", "position", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", "setPosition--gyyYBs", "(J)V", "J", "getCachedAlignmentLine", "alignmentLine", "getCachedAlignmentLine$ui_release", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "block", "Lkotlin/Function0;", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "", "zIndex", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeChildren", "positionIn", "ancestor", "positionIn-Bjo55l4$ui_release", "(Landroidx/compose/ui/node/LookaheadDelegate;)J", "replace", "replace$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadDelegate.kt */
public abstract class LookaheadDelegate extends LookaheadCapablePlaceable implements Measurable {
    private MeasureResult _measureResult;
    private final Map<AlignmentLine, Integer> cachedAlignmentLinesMap = new LinkedHashMap();
    private final NodeCoordinator coordinator;
    private final LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinates = new LookaheadLayoutCoordinatesImpl(this);
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position = IntOffset.Companion.m7682getZeronOccac();

    public final NodeCoordinator getCoordinator() {
        return this.coordinator;
    }

    public LookaheadDelegate(NodeCoordinator coordinator2) {
        Intrinsics.checkNotNullParameter(coordinator2, "coordinator");
        this.coordinator = coordinator2;
    }

    public LookaheadCapablePlaceable getChild() {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        return wrapped$ui_release != null ? wrapped$ui_release.getLookaheadDelegate() : null;
    }

    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    /* renamed from: getPosition-nOcc-ac  reason: not valid java name */
    public long m6602getPositionnOccac() {
        return this.position;
    }

    /* renamed from: setPosition--gyyYBs  reason: not valid java name */
    public void m6606setPositiongyyYBs(long j) {
        this.position = j;
    }

    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException("LookaheadDelegate has not been measured yet when measureResult is requested.".toString());
    }

    public boolean isLookingAhead() {
        return true;
    }

    public LayoutDirection getLayoutDirection() {
        return this.coordinator.getLayoutDirection();
    }

    public float getDensity() {
        return this.coordinator.getDensity();
    }

    public float getFontScale() {
        return this.coordinator.getFontScale();
    }

    public LookaheadCapablePlaceable getParent() {
        NodeCoordinator wrappedBy$ui_release = this.coordinator.getWrappedBy$ui_release();
        return wrappedBy$ui_release != null ? wrappedBy$ui_release.getLookaheadDelegate() : null;
    }

    public LayoutNode getLayoutNode() {
        return this.coordinator.getLayoutNode();
    }

    public LayoutCoordinates getCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    public final LookaheadLayoutCoordinatesImpl getLookaheadLayoutCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    public AlignmentLinesOwner getAlignmentLinesOwner() {
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = this.coordinator.getLayoutNode().getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
        Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
        return lookaheadAlignmentLinesOwner$ui_release;
    }

    /* access modifiers changed from: private */
    public final void set_measureResult(MeasureResult result) {
        Unit unit;
        if (result != null) {
            MeasureResult it = result;
            m6437setMeasuredSizeozmzZPI(IntSizeKt.IntSize(it.getWidth(), it.getHeight()));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            m6437setMeasuredSizeozmzZPI(IntSize.Companion.m7719getZeroYbymL2g());
        }
        if (!Intrinsics.areEqual((Object) this._measureResult, (Object) result) && result != null) {
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if ((!(map == null || map.isEmpty()) || (!result.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual((Object) result.getAlignmentLines(), (Object) this.oldAlignmentLines)) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                Map oldLines = this.oldAlignmentLines;
                if (oldLines == null) {
                    oldLines = new LinkedHashMap();
                    this.oldAlignmentLines = oldLines;
                }
                oldLines.clear();
                oldLines.putAll(result.getAlignmentLines());
            }
        }
        this._measureResult = result;
    }

    /* access modifiers changed from: protected */
    public final Map<AlignmentLine, Integer> getCachedAlignmentLinesMap() {
        return this.cachedAlignmentLinesMap;
    }

    public final int getCachedAlignmentLine$ui_release(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        Integer num = this.cachedAlignmentLinesMap.get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    public void replace$ui_release() {
        m6604placeAtf8xVGno(m6602getPositionnOccac(), 0.0f, (Function1<? super GraphicsLayerScope, Unit>) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public final void m6604placeAtf8xVGno(long position2, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        if (!IntOffset.m7671equalsimpl0(m6602getPositionnOccac(), position2)) {
            m6606setPositiongyyYBs(position2);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLayoutNode().getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release != null) {
                lookaheadPassDelegate$ui_release.notifyChildrenUsingCoordinatesWhilePlacing();
            }
            invalidateAlignmentLinesFromPositionChange(this.coordinator);
        }
        if (!isShallowPlacing$ui_release()) {
            placeChildren();
        }
    }

    /* access modifiers changed from: protected */
    public void placeChildren() {
        Placeable.PlacementScope.Companion this_$iv = Placeable.PlacementScope.Companion;
        int parentWidth$iv = getMeasureResult$ui_release().getWidth();
        LayoutDirection parentLayoutDirection$iv = this.coordinator.getLayoutDirection();
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

    /* renamed from: performingMeasure-K40F9xA  reason: not valid java name */
    public final Placeable m6603performingMeasureK40F9xA(long constraints, Function0<? extends MeasureResult> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        m6438setMeasurementConstraintsBRTryo0(constraints);
        set_measureResult((MeasureResult) block.invoke());
        return this;
    }

    public Object getParentData() {
        return this.coordinator.getParentData();
    }

    public int minIntrinsicWidth(int height) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate = wrapped$ui_release.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.minIntrinsicWidth(height);
    }

    public int maxIntrinsicWidth(int height) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate = wrapped$ui_release.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.maxIntrinsicWidth(height);
    }

    public int minIntrinsicHeight(int width) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate = wrapped$ui_release.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.minIntrinsicHeight(width);
    }

    public int maxIntrinsicHeight(int width) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate = wrapped$ui_release.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.maxIntrinsicHeight(width);
    }

    /* renamed from: positionIn-Bjo55l4$ui_release  reason: not valid java name */
    public final long m6605positionInBjo55l4$ui_release(LookaheadDelegate ancestor) {
        Intrinsics.checkNotNullParameter(ancestor, "ancestor");
        long aggregatedOffset = IntOffset.Companion.m7682getZeronOccac();
        LookaheadDelegate lookaheadDelegate = this;
        while (!Intrinsics.areEqual((Object) lookaheadDelegate, (Object) ancestor)) {
            long other$iv = lookaheadDelegate.m6602getPositionnOccac();
            aggregatedOffset = IntOffsetKt.IntOffset(IntOffset.m7672getXimpl(aggregatedOffset) + IntOffset.m7672getXimpl(other$iv), IntOffset.m7673getYimpl(aggregatedOffset) + IntOffset.m7673getYimpl(other$iv));
            NodeCoordinator wrappedBy$ui_release = lookaheadDelegate.coordinator.getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release);
            LookaheadDelegate lookaheadDelegate2 = wrappedBy$ui_release.getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate2);
            lookaheadDelegate = lookaheadDelegate2;
        }
        return aggregatedOffset;
    }
}

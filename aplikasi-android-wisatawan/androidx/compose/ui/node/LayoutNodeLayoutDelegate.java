package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0000\u0018\u00002\u00020\u0001:\u0002YZB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010B\u001a\u00020CH\u0000¢\u0006\u0002\bDJ\u0006\u0010E\u001a\u00020CJ\u0006\u0010F\u001a\u00020CJ\r\u0010G\u001a\u00020CH\u0000¢\u0006\u0002\bHJ\r\u0010I\u001a\u00020CH\u0000¢\u0006\u0002\bJJ\r\u0010K\u001a\u00020CH\u0000¢\u0006\u0002\bLJ\r\u0010M\u001a\u00020CH\u0000¢\u0006\u0002\bNJ\u0006\u0010O\u001a\u00020CJ\u001d\u0010P\u001a\u00020C2\u0006\u0010Q\u001a\u00020\u001cH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\u001d\u0010T\u001a\u00020C2\u0006\u0010Q\u001a\u00020\u001cH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bU\u0010SJ\u0006\u0010V\u001a\u00020CJ\u0006\u0010W\u001a\u00020CJ\f\u0010X\u001a\u00020\u0010*\u00020\u0003H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001c8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001c8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013R\u000e\u0010$\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020%@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010)\u001a\u0004\u0018\u00010\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\bR\u001e\u0010+\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0013R\u000e\u0010-\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0013R*\u00101\u001a\b\u0018\u000100R\u00020\u00002\f\u0010!\u001a\b\u0018\u000100R\u00020\u0000@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u00104\u001a\u000605R\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001e\u00108\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0013R\u000e\u0010:\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010<\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006["}, d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner$ui_release", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "value", "", "childrenAccessingCoordinatesDuringPlacement", "getChildrenAccessingCoordinatesDuringPlacement", "()I", "setChildrenAccessingCoordinatesDuringPlacement", "(I)V", "", "coordinatesAccessedDuringModifierPlacement", "getCoordinatesAccessedDuringModifierPlacement", "()Z", "setCoordinatesAccessedDuringModifierPlacement", "(Z)V", "coordinatesAccessedDuringPlacement", "getCoordinatesAccessedDuringPlacement", "setCoordinatesAccessedDuringPlacement", "height", "getHeight$ui_release", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastLookaheadConstraints", "getLastLookaheadConstraints-DWUhwKw", "<set-?>", "layoutPending", "getLayoutPending$ui_release", "layoutPendingForAlignment", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "layoutState", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadAlignmentLinesOwner", "getLookaheadAlignmentLinesOwner$ui_release", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadLayoutPendingForAlignment", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "lookaheadPassDelegate", "getLookaheadPassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "nextChildLookaheadPlaceOrder", "nextChildPlaceOrder", "outerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getOuterCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "width", "getWidth$ui_release", "ensureLookaheadDelegateCreated", "", "ensureLookaheadDelegateCreated$ui_release", "invalidateParentData", "markChildrenDirty", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "onCoordinatesUsed", "performLookaheadMeasure", "constraints", "performLookaheadMeasure-BRTryo0", "(J)V", "performMeasure", "performMeasure-BRTryo0", "resetAlignmentLines", "updateParentData", "isOutMostLookaheadRoot", "LookaheadPassDelegate", "MeasurePassDelegate", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeLayoutDelegate.kt */
public final class LayoutNodeLayoutDelegate {
    private int childrenAccessingCoordinatesDuringPlacement;
    private boolean coordinatesAccessedDuringModifierPlacement;
    private boolean coordinatesAccessedDuringPlacement;
    /* access modifiers changed from: private */
    public final LayoutNode layoutNode;
    /* access modifiers changed from: private */
    public boolean layoutPending;
    /* access modifiers changed from: private */
    public boolean layoutPendingForAlignment;
    /* access modifiers changed from: private */
    public LayoutNode.LayoutState layoutState = LayoutNode.LayoutState.Idle;
    /* access modifiers changed from: private */
    public boolean lookaheadLayoutPending;
    /* access modifiers changed from: private */
    public boolean lookaheadLayoutPendingForAlignment;
    private boolean lookaheadMeasurePending;
    private LookaheadPassDelegate lookaheadPassDelegate;
    private final MeasurePassDelegate measurePassDelegate = new MeasurePassDelegate();
    private boolean measurePending;
    /* access modifiers changed from: private */
    public int nextChildLookaheadPlaceOrder;
    /* access modifiers changed from: private */
    public int nextChildPlaceOrder;

    public LayoutNodeLayoutDelegate(LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        this.layoutNode = layoutNode2;
    }

    public final NodeCoordinator getOuterCoordinator() {
        return this.layoutNode.getNodes$ui_release().getOuterCoordinator$ui_release();
    }

    /* renamed from: getLastConstraints-DWUhwKw  reason: not valid java name */
    public final Constraints m4877getLastConstraintsDWUhwKw() {
        return this.measurePassDelegate.m4885getLastConstraintsDWUhwKw();
    }

    /* renamed from: getLastLookaheadConstraints-DWUhwKw  reason: not valid java name */
    public final Constraints m4878getLastLookaheadConstraintsDWUhwKw() {
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null) {
            return lookaheadPassDelegate2.m4879getLastConstraintsDWUhwKw();
        }
        return null;
    }

    public final int getHeight$ui_release() {
        return this.measurePassDelegate.getHeight();
    }

    public final int getWidth$ui_release() {
        return this.measurePassDelegate.getWidth();
    }

    public final LayoutNode.LayoutState getLayoutState$ui_release() {
        return this.layoutState;
    }

    public final boolean getMeasurePending$ui_release() {
        return this.measurePending;
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutPending;
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.lookaheadMeasurePending;
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.lookaheadLayoutPending;
    }

    public final void markLayoutPending$ui_release() {
        this.layoutPending = true;
        this.layoutPendingForAlignment = true;
    }

    public final void markMeasurePending$ui_release() {
        this.measurePending = true;
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.lookaheadLayoutPending = true;
        this.lookaheadLayoutPendingForAlignment = true;
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.lookaheadMeasurePending = true;
    }

    public final AlignmentLinesOwner getAlignmentLinesOwner$ui_release() {
        return this.measurePassDelegate;
    }

    public final AlignmentLinesOwner getLookaheadAlignmentLinesOwner$ui_release() {
        return this.lookaheadPassDelegate;
    }

    public final boolean getCoordinatesAccessedDuringPlacement() {
        return this.coordinatesAccessedDuringPlacement;
    }

    public final void setCoordinatesAccessedDuringPlacement(boolean value) {
        if (this.coordinatesAccessedDuringPlacement != value) {
            this.coordinatesAccessedDuringPlacement = value;
            if (value && !this.coordinatesAccessedDuringModifierPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
            } else if (!value && !this.coordinatesAccessedDuringModifierPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final boolean getCoordinatesAccessedDuringModifierPlacement() {
        return this.coordinatesAccessedDuringModifierPlacement;
    }

    public final void setCoordinatesAccessedDuringModifierPlacement(boolean value) {
        if (this.coordinatesAccessedDuringModifierPlacement != value) {
            this.coordinatesAccessedDuringModifierPlacement = value;
            if (value && !this.coordinatesAccessedDuringPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
            } else if (!value && !this.coordinatesAccessedDuringPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final int getChildrenAccessingCoordinatesDuringPlacement() {
        return this.childrenAccessingCoordinatesDuringPlacement;
    }

    public final void setChildrenAccessingCoordinatesDuringPlacement(int value) {
        int oldValue = this.childrenAccessingCoordinatesDuringPlacement;
        this.childrenAccessingCoordinatesDuringPlacement = value;
        boolean z = false;
        boolean z2 = oldValue == 0;
        if (value == 0) {
            z = true;
        }
        if (z2 != z) {
            LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
            LayoutNodeLayoutDelegate parentLayoutDelegate = parent$ui_release != null ? parent$ui_release.getLayoutDelegate$ui_release() : null;
            if (parentLayoutDelegate == null) {
                return;
            }
            if (value == 0) {
                parentLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(parentLayoutDelegate.childrenAccessingCoordinatesDuringPlacement - 1);
            } else {
                parentLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(parentLayoutDelegate.childrenAccessingCoordinatesDuringPlacement + 1);
            }
        }
    }

    public final MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.measurePassDelegate;
    }

    public final LookaheadPassDelegate getLookaheadPassDelegate$ui_release() {
        return this.lookaheadPassDelegate;
    }

    public final void onCoordinatesUsed() {
        LayoutNode.LayoutState state = this.layoutNode.getLayoutState$ui_release();
        if (state == LayoutNode.LayoutState.LayingOut || state == LayoutNode.LayoutState.LookaheadLayingOut) {
            if (this.measurePassDelegate.getLayingOutChildren()) {
                setCoordinatesAccessedDuringPlacement(true);
            } else {
                setCoordinatesAccessedDuringModifierPlacement(true);
            }
        }
        if (state == LayoutNode.LayoutState.LookaheadLayingOut) {
            LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
            boolean z = false;
            if (lookaheadPassDelegate2 != null && lookaheadPassDelegate2.getLayingOutChildren()) {
                z = true;
            }
            if (z) {
                setCoordinatesAccessedDuringPlacement(true);
            } else {
                setCoordinatesAccessedDuringModifierPlacement(true);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0014\u0010N\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u0002070OH\u0016J\b\u0010Q\u001a\u00020'H\u0002J\b\u0010R\u001a\u00020'H\u0002J\u001c\u0010S\u001a\u00020'2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020'0%H\u0016J!\u0010U\u001a\u00020'2\u0016\u0010T\u001a\u0012\u0012\b\u0012\u00060\u0000R\u00020\u0007\u0012\u0004\u0012\u00020'0%H\bJ\u0011\u0010V\u001a\u0002072\u0006\u0010W\u001a\u00020PH\u0002J\u000e\u0010X\u001a\u00020'2\u0006\u0010Y\u001a\u00020\u0011J\u0006\u0010Z\u001a\u00020'J\b\u0010[\u001a\u00020'H\u0016J\b\u0010\\\u001a\u00020'H\u0002J\b\u0010]\u001a\u00020'H\u0002J\u0010\u0010^\u001a\u0002072\u0006\u0010_\u001a\u000207H\u0016J\u0010\u0010`\u001a\u0002072\u0006\u0010a\u001a\u000207H\u0016J\u001d\u0010b\u001a\u00020\u00022\u0006\u0010c\u001a\u00020!H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bd\u0010eJ\u0006\u0010f\u001a\u00020'J\u0010\u0010g\u001a\u0002072\u0006\u0010_\u001a\u000207H\u0016J\u0010\u0010h\u001a\u0002072\u0006\u0010a\u001a\u000207H\u0016J\u0006\u0010i\u001a\u00020'J\b\u0010j\u001a\u00020'H\u0002J\b\u0010k\u001a\u00020'H\u0002J\u0006\u0010l\u001a\u00020'J\r\u0010m\u001a\u00020'H\u0000¢\u0006\u0002\bnJ@\u0010o\u001a\u00020'2\u0006\u0010p\u001a\u00020*2\u0006\u0010K\u001a\u00020-2\u0019\u0010q\u001a\u0015\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0018\u00010%¢\u0006\u0002\b(H\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\br\u0010sJ\u0006\u0010t\u001a\u00020'J@\u0010u\u001a\u00020'2\u0006\u0010p\u001a\u00020*2\u0006\u0010K\u001a\u00020-2\u0019\u0010q\u001a\u0015\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0018\u00010%¢\u0006\u0002\b(H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bv\u0010sJ\u001b\u0010w\u001a\u00020\u00112\u0006\u0010c\u001a\u00020!ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bx\u0010yJ\u0006\u0010z\u001a\u00020'J\b\u0010{\u001a\u00020'H\u0016J\b\u0010|\u001a\u00020'H\u0016J\u0010\u0010}\u001a\u00020'2\u0006\u0010~\u001a\u00020H\u0002J\u0007\u0010\u0001\u001a\u00020\u0011R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0000R\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\f\u0012\b\u0012\u00060\u0000R\u00020\u00070\r8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011@PX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001c\u0010 \u001a\u0004\u0018\u00010!8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\"\u0010#R!\u0010$\u001a\u0015\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0018\u00010%¢\u0006\u0002\b(X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010)\u001a\u00020*X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010+R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0013R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00106\u001a\u0002078VX\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u000e\u0010:\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u0002078VX\u0004¢\u0006\u0006\u001a\u0004\b<\u00109R\u0016\u0010=\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\"\u0010A\u001a\u0004\u0018\u00010@2\b\u0010\u001d\u001a\u0004\u0018\u00010@@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u000e\u0010D\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010E\u001a\u0002072\u0006\u0010\u001d\u001a\u000207@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u00109R\u000e\u0010G\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010H\u001a\u0002072\u0006\u0010\u001d\u001a\u000207@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bI\u00109R\u000e\u0010J\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010K\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020-@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bL\u0010M\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "_childDelegates", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "childDelegates", "", "getChildDelegates$ui_release", "()Ljava/util/List;", "childDelegatesDirty", "", "getChildDelegatesDirty$ui_release", "()Z", "setChildDelegatesDirty$ui_release", "(Z)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui_release", "setDuringAlignmentLinesQuery$ui_release", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "<set-?>", "isPlaced", "setPlaced$ui_release", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "lastPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "lastZIndex", "", "layingOutChildren", "getLayingOutChildren", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredOnce", "measuredWidth", "getMeasuredWidth", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "", "parentData", "getParentData", "()Ljava/lang/Object;", "parentDataDirty", "placeOrder", "getPlaceOrder$ui_release", "placedOnce", "previousPlaceOrder", "getPreviousPlaceOrder$ui_release", "relayoutWithoutParentInProgress", "zIndex", "getZIndex$ui_release", "()F", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "checkChildrenPlaceOrderForUpdates", "clearPlaceOrder", "forEachChildAlignmentLinesOwner", "block", "forEachChildDelegate", "get", "alignmentLine", "invalidateIntrinsicsParent", "forceRequest", "invalidateParentData", "layoutChildren", "markNodeAndSubtreeAsPlaced", "markSubtreeAsNotPlaced", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "measureBasedOnLookahead", "minIntrinsicHeight", "minIntrinsicWidth", "notifyChildrenUsingCoordinatesWhilePlacing", "onBeforeLayoutChildren", "onIntrinsicsQueried", "onNodeDetached", "onNodePlaced", "onNodePlaced$ui_release", "placeAt", "position", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeBasedOnLookahead", "placeOuterCoordinator", "placeOuterCoordinator-f8xVGno", "remeasure", "remeasure-BRTryo0", "(J)Z", "replace", "requestLayout", "requestMeasure", "trackMeasurementByParent", "node", "Landroidx/compose/ui/node/LayoutNode;", "updateParentData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNodeLayoutDelegate.kt */
    public final class MeasurePassDelegate extends Placeable implements Measurable, AlignmentLinesOwner {
        private final MutableVector<MeasurePassDelegate> _childDelegates = new MutableVector<>(new MeasurePassDelegate[16], 0);
        private final AlignmentLines alignmentLines = new LayoutNodeAlignmentLines(this);
        private boolean childDelegatesDirty = true;
        private boolean duringAlignmentLinesQuery;
        private boolean isPlaced;
        private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
        private long lastPosition = IntOffset.Companion.m5972getZeronOccac();
        private float lastZIndex;
        private boolean layingOutChildren;
        private LayoutNode.UsageByParent measuredByParent = LayoutNode.UsageByParent.NotUsed;
        private boolean measuredOnce;
        private Object parentData;
        private boolean parentDataDirty = true;
        private int placeOrder = Integer.MAX_VALUE;
        private boolean placedOnce;
        private int previousPlaceOrder = Integer.MAX_VALUE;
        private boolean relayoutWithoutParentInProgress;
        private float zIndex;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* compiled from: LayoutNodeLayoutDelegate.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[LayoutNode.LayoutState.values().length];
                try {
                    iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
                try {
                    iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                } catch (NoSuchFieldError e4) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public MeasurePassDelegate() {
        }

        public final int getPreviousPlaceOrder$ui_release() {
            return this.previousPlaceOrder;
        }

        public final int getPlaceOrder$ui_release() {
            return this.placeOrder;
        }

        /* renamed from: getLastConstraints-DWUhwKw  reason: not valid java name */
        public final Constraints m4885getLastConstraintsDWUhwKw() {
            if (this.measuredOnce) {
                return Constraints.m5776boximpl(m4725getMeasurementConstraintsmsEJaDk());
            }
            return null;
        }

        public final LayoutNode.UsageByParent getMeasuredByParent$ui_release() {
            return this.measuredByParent;
        }

        public final void setMeasuredByParent$ui_release(LayoutNode.UsageByParent usageByParent) {
            Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
            this.measuredByParent = usageByParent;
        }

        public final boolean getDuringAlignmentLinesQuery$ui_release() {
            return this.duringAlignmentLinesQuery;
        }

        public final void setDuringAlignmentLinesQuery$ui_release(boolean z) {
            this.duringAlignmentLinesQuery = z;
        }

        public Object getParentData() {
            return this.parentData;
        }

        public boolean isPlaced() {
            return this.isPlaced;
        }

        public void setPlaced$ui_release(boolean z) {
            this.isPlaced = z;
        }

        public NodeCoordinator getInnerCoordinator() {
            return LayoutNodeLayoutDelegate.this.layoutNode.getInnerCoordinator$ui_release();
        }

        public AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        public final boolean getChildDelegatesDirty$ui_release() {
            return this.childDelegatesDirty;
        }

        public final void setChildDelegatesDirty$ui_release(boolean z) {
            this.childDelegatesDirty = z;
        }

        public final List<MeasurePassDelegate> getChildDelegates$ui_release() {
            LayoutNodeLayoutDelegate.this.layoutNode.updateChildrenIfDirty$ui_release();
            if (!this.childDelegatesDirty) {
                return this._childDelegates.asMutableList();
            }
            LayoutNode $this$updateChildMeasurables$iv = LayoutNodeLayoutDelegate.this.layoutNode;
            MutableVector destination$iv = this._childDelegates;
            MutableVector this_$iv$iv$iv = $this$updateChildMeasurables$iv.get_children$ui_release();
            int size$iv$iv$iv = this_$iv$iv$iv.getSize();
            if (size$iv$iv$iv > 0) {
                int i$iv$iv$iv = 0;
                Object[] content$iv$iv$iv = this_$iv$iv$iv.getContent();
                do {
                    LayoutNode layoutNode$iv = (LayoutNode) content$iv$iv$iv[i$iv$iv$iv];
                    int i$iv = i$iv$iv$iv;
                    if (destination$iv.getSize() <= i$iv) {
                        destination$iv.add(layoutNode$iv.getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release());
                    } else {
                        destination$iv.set(i$iv, layoutNode$iv.getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release());
                    }
                    i$iv$iv$iv++;
                } while (i$iv$iv$iv < size$iv$iv$iv);
            }
            destination$iv.removeRange($this$updateChildMeasurables$iv.getChildren$ui_release().size(), destination$iv.getSize());
            this.childDelegatesDirty = false;
            return this._childDelegates.asMutableList();
        }

        public final boolean getLayingOutChildren() {
            return this.layingOutChildren;
        }

        public void layoutChildren() {
            this.layingOutChildren = true;
            getAlignmentLines().recalculateQueryOwner();
            if (LayoutNodeLayoutDelegate.this.getLayoutPending$ui_release()) {
                onBeforeLayoutChildren();
            }
            if (LayoutNodeLayoutDelegate.this.layoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !getInnerCoordinator().isPlacingForAlignment$ui_release() && LayoutNodeLayoutDelegate.this.getLayoutPending$ui_release())) {
                LayoutNodeLayoutDelegate.this.layoutPending = false;
                LayoutNode.LayoutState oldLayoutState = LayoutNodeLayoutDelegate.this.getLayoutState$ui_release();
                LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LayingOut;
                LayoutNodeLayoutDelegate.this.setCoordinatesAccessedDuringPlacement(false);
                LayoutNode $this$layoutChildren_u24lambda_u241 = LayoutNodeLayoutDelegate.this.layoutNode;
                LayoutNodeKt.requireOwner($this$layoutChildren_u24lambda_u241).getSnapshotObserver().observeLayoutSnapshotReads$ui_release($this$layoutChildren_u24lambda_u241, false, new LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildren$1$1(this, $this$layoutChildren_u24lambda_u241));
                LayoutNodeLayoutDelegate.this.layoutState = oldLayoutState;
                if (getInnerCoordinator().isPlacingForAlignment$ui_release() && LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringPlacement()) {
                    requestLayout();
                }
                LayoutNodeLayoutDelegate.this.layoutPendingForAlignment = false;
            }
            if (getAlignmentLines().getUsedDuringParentLayout$ui_release()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
            }
            if (getAlignmentLines().getDirty$ui_release() && getAlignmentLines().getRequired$ui_release()) {
                getAlignmentLines().recalculate();
            }
            this.layingOutChildren = false;
        }

        /* access modifiers changed from: private */
        public final void checkChildrenPlaceOrderForUpdates() {
            LayoutNode $this$checkChildrenPlaceOrderForUpdates_u24lambda_u243 = LayoutNodeLayoutDelegate.this.layoutNode;
            MutableVector this_$iv$iv = $this$checkChildrenPlaceOrderForUpdates_u24lambda_u243.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    LayoutNode child = (LayoutNode) content$iv$iv[i$iv$iv];
                    if (child.getMeasurePassDelegate$ui_release().previousPlaceOrder != child.getPlaceOrder$ui_release()) {
                        $this$checkChildrenPlaceOrderForUpdates_u24lambda_u243.onZSortedChildrenInvalidated$ui_release();
                        $this$checkChildrenPlaceOrderForUpdates_u24lambda_u243.invalidateLayer$ui_release();
                        if (child.getPlaceOrder$ui_release() == Integer.MAX_VALUE) {
                            child.getMeasurePassDelegate$ui_release().markSubtreeAsNotPlaced();
                        }
                    }
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }

        private final void markSubtreeAsNotPlaced() {
            if (isPlaced()) {
                setPlaced$ui_release(false);
                MutableVector this_$iv$iv$iv = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
                int size$iv$iv$iv = this_$iv$iv$iv.getSize();
                if (size$iv$iv$iv > 0) {
                    int i$iv$iv$iv = 0;
                    Object[] content$iv$iv$iv = this_$iv$iv$iv.getContent();
                    do {
                        ((LayoutNode) content$iv$iv$iv[i$iv$iv$iv]).getMeasurePassDelegate$ui_release().markSubtreeAsNotPlaced();
                        i$iv$iv$iv++;
                    } while (i$iv$iv$iv < size$iv$iv$iv);
                }
            }
        }

        private final void markNodeAndSubtreeAsPlaced() {
            boolean wasPlaced = isPlaced();
            setPlaced$ui_release(true);
            LayoutNode $this$markNodeAndSubtreeAsPlaced_u24lambda_u247 = LayoutNodeLayoutDelegate.this.layoutNode;
            if (!wasPlaced) {
                if ($this$markNodeAndSubtreeAsPlaced_u24lambda_u247.getMeasurePending$ui_release()) {
                    LayoutNode.requestRemeasure$ui_release$default($this$markNodeAndSubtreeAsPlaced_u24lambda_u247, true, false, 2, (Object) null);
                } else if ($this$markNodeAndSubtreeAsPlaced_u24lambda_u247.getLookaheadMeasurePending$ui_release()) {
                    LayoutNode.requestLookaheadRemeasure$ui_release$default($this$markNodeAndSubtreeAsPlaced_u24lambda_u247, true, false, 2, (Object) null);
                }
            }
            LayoutNode this_$iv = $this$markNodeAndSubtreeAsPlaced_u24lambda_u247;
            NodeCoordinator delegate$iv = this_$iv.getOuterCoordinator$ui_release();
            NodeCoordinator final$iv = this_$iv.getInnerCoordinator$ui_release().getWrapped$ui_release();
            while (!Intrinsics.areEqual((Object) delegate$iv, (Object) final$iv) && delegate$iv != null) {
                NodeCoordinator it = delegate$iv;
                if (it.getLastLayerDrawingWasSkipped$ui_release()) {
                    it.invalidateLayer();
                }
                delegate$iv = delegate$iv.getWrapped$ui_release();
            }
            MutableVector this_$iv$iv = $this$markNodeAndSubtreeAsPlaced_u24lambda_u247.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    LayoutNode it2 = (LayoutNode) content$iv$iv[i$iv$iv];
                    if (it2.getPlaceOrder$ui_release() != Integer.MAX_VALUE) {
                        it2.getMeasurePassDelegate$ui_release().markNodeAndSubtreeAsPlaced();
                        $this$markNodeAndSubtreeAsPlaced_u24lambda_u247.rescheduleRemeasureOrRelayout$ui_release(it2);
                    }
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }

        public final float getZIndex$ui_release() {
            return this.zIndex;
        }

        public final void onNodePlaced$ui_release() {
            LayoutNode parent = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            float newZIndex = getInnerCoordinator().getZIndex();
            LayoutNode this_$iv = LayoutNodeLayoutDelegate.this.layoutNode;
            NodeCoordinator inner$iv = this_$iv.getInnerCoordinator$ui_release();
            for (NodeCoordinator coordinator$iv = this_$iv.getOuterCoordinator$ui_release(); coordinator$iv != inner$iv; coordinator$iv = ((LayoutModifierNodeCoordinator) coordinator$iv).getWrapped$ui_release()) {
                Intrinsics.checkNotNull(coordinator$iv, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                newZIndex += ((LayoutModifierNodeCoordinator) coordinator$iv).getZIndex();
            }
            boolean z = false;
            if (!(newZIndex == this.zIndex)) {
                this.zIndex = newZIndex;
                if (parent != null) {
                    parent.onZSortedChildrenInvalidated$ui_release();
                }
                if (parent != null) {
                    parent.invalidateLayer$ui_release();
                }
            }
            if (!isPlaced()) {
                if (parent != null) {
                    parent.invalidateLayer$ui_release();
                }
                markNodeAndSubtreeAsPlaced();
            }
            if (parent == null) {
                this.placeOrder = 0;
            } else if (!this.relayoutWithoutParentInProgress && parent.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut) {
                if (this.placeOrder == Integer.MAX_VALUE) {
                    z = true;
                }
                if (z) {
                    this.placeOrder = parent.getLayoutDelegate$ui_release().nextChildPlaceOrder;
                    LayoutNodeLayoutDelegate layoutDelegate$ui_release = parent.getLayoutDelegate$ui_release();
                    layoutDelegate$ui_release.nextChildPlaceOrder = layoutDelegate$ui_release.nextChildPlaceOrder + 1;
                } else {
                    throw new IllegalStateException("Place was called on a node which was placed already".toString());
                }
            }
            layoutChildren();
        }

        /* access modifiers changed from: private */
        public final void clearPlaceOrder() {
            LayoutNodeLayoutDelegate.this.nextChildPlaceOrder = 0;
            MutableVector this_$iv$iv$iv = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size$iv$iv$iv = this_$iv$iv$iv.getSize();
            if (size$iv$iv$iv > 0) {
                int i$iv$iv$iv = 0;
                Object[] content$iv$iv$iv = this_$iv$iv$iv.getContent();
                do {
                    MeasurePassDelegate child = ((LayoutNode) content$iv$iv$iv[i$iv$iv$iv]).getMeasurePassDelegate$ui_release();
                    child.previousPlaceOrder = child.placeOrder;
                    child.placeOrder = Integer.MAX_VALUE;
                    if (child.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                        child.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                    }
                    i$iv$iv$iv++;
                } while (i$iv$iv$iv < size$iv$iv$iv);
            }
        }

        private final void forEachChildDelegate(Function1<? super MeasurePassDelegate, Unit> block) {
            MutableVector this_$iv$iv = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    block.invoke(((LayoutNode) content$iv$iv[i$iv$iv]).getMeasurePassDelegate$ui_release());
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }

        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m4886measureBRTryo0(long constraints) {
            if (LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNodeLayoutDelegate.this.layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
            }
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            if (layoutNodeLayoutDelegate.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
                this.measuredOnce = true;
                m4728setMeasurementConstraintsBRTryo0(constraints);
                LookaheadPassDelegate $this$measure_BRTryo0_u24lambda_u2412 = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull($this$measure_BRTryo0_u24lambda_u2412);
                $this$measure_BRTryo0_u24lambda_u2412.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                $this$measure_BRTryo0_u24lambda_u2412.m4881measureBRTryo0(constraints);
            }
            trackMeasurementByParent(LayoutNodeLayoutDelegate.this.layoutNode);
            m4888remeasureBRTryo0(constraints);
            return this;
        }

        /* renamed from: remeasure-BRTryo0  reason: not valid java name */
        public final boolean m4888remeasureBRTryo0(long constraints) {
            Owner owner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
            LayoutNode parent = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            boolean sizeChanged = true;
            LayoutNodeLayoutDelegate.this.layoutNode.setCanMultiMeasure$ui_release(LayoutNodeLayoutDelegate.this.layoutNode.getCanMultiMeasure$ui_release() || (parent != null && parent.getCanMultiMeasure$ui_release()));
            if (LayoutNodeLayoutDelegate.this.layoutNode.getMeasurePending$ui_release() || !Constraints.m5781equalsimpl0(m4725getMeasurementConstraintsmsEJaDk(), constraints)) {
                getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
                forEachChildAlignmentLinesOwner(LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$1.INSTANCE);
                this.measuredOnce = true;
                long outerPreviousMeasuredSize = LayoutNodeLayoutDelegate.this.getOuterCoordinator().m4930getSizeYbymL2g();
                m4728setMeasurementConstraintsBRTryo0(constraints);
                LayoutNodeLayoutDelegate.this.m4876performMeasureBRTryo0(constraints);
                if (IntSize.m6002equalsimpl0(LayoutNodeLayoutDelegate.this.getOuterCoordinator().m4930getSizeYbymL2g(), outerPreviousMeasuredSize) && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWidth() == getWidth() && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getHeight() == getHeight()) {
                    sizeChanged = false;
                }
                m4727setMeasuredSizeozmzZPI(IntSizeKt.IntSize(LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWidth(), LayoutNodeLayoutDelegate.this.getOuterCoordinator().getHeight()));
                return sizeChanged;
            }
            Owner.forceMeasureTheSubtree$default(owner, LayoutNodeLayoutDelegate.this.layoutNode, false, 2, (Object) null);
            LayoutNodeLayoutDelegate.this.layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
            return false;
        }

        private final void trackMeasurementByParent(LayoutNode node) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode parent = node.getParent$ui_release();
            if (parent != null) {
                if (this.measuredByParent == LayoutNode.UsageByParent.NotUsed || node.getCanMultiMeasure$ui_release()) {
                    switch (WhenMappings.$EnumSwitchMapping$0[parent.getLayoutState$ui_release().ordinal()]) {
                        case 1:
                            usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                            break;
                        case 2:
                            usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                            break;
                        default:
                            throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent.getLayoutState$ui_release());
                    }
                    this.measuredByParent = usageByParent;
                    return;
                }
                throw new IllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()".toString());
            }
            this.measuredByParent = LayoutNode.UsageByParent.NotUsed;
        }

        public int getMeasuredWidth() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredWidth();
        }

        public int getMeasuredHeight() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredHeight();
        }

        public int get(AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.LayoutState layoutState = null;
            if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.Measuring) {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
            } else {
                LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    layoutState = parent$ui_release2.getLayoutState$ui_release();
                }
                if (layoutState == LayoutNode.LayoutState.LayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
                }
            }
            this.duringAlignmentLinesQuery = true;
            int result = LayoutNodeLayoutDelegate.this.getOuterCoordinator().get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return result;
        }

        /* access modifiers changed from: protected */
        /* renamed from: placeAt-f8xVGno  reason: not valid java name */
        public void m4887placeAtf8xVGno(long position, float zIndex2, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            if (!IntOffset.m5961equalsimpl0(position, this.lastPosition)) {
                if (LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringModifierPlacement() || LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringPlacement()) {
                    LayoutNodeLayoutDelegate.this.layoutPending = true;
                }
                notifyChildrenUsingCoordinatesWhilePlacing();
            }
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            if (layoutNodeLayoutDelegate.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
                Placeable.PlacementScope.Companion $this$placeAt_f8xVGno_u24lambda_u2416 = Placeable.PlacementScope.Companion;
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = LayoutNodeLayoutDelegate.this;
                LookaheadPassDelegate it = layoutNodeLayoutDelegate2.getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(it);
                LayoutNode $this$placeAt_f8xVGno_u24lambda_u2416_u24lambda_u2415_u24lambda_u2414 = layoutNodeLayoutDelegate2.layoutNode.getParent$ui_release();
                if ($this$placeAt_f8xVGno_u24lambda_u2416_u24lambda_u2415_u24lambda_u2414 != null) {
                    $this$placeAt_f8xVGno_u24lambda_u2416_u24lambda_u2415_u24lambda_u2414.getLayoutDelegate$ui_release().nextChildLookaheadPlaceOrder = 0;
                }
                it.setPlaceOrder$ui_release(Integer.MAX_VALUE);
                Placeable.PlacementScope.place$default($this$placeAt_f8xVGno_u24lambda_u2416, it, IntOffset.m5962getXimpl(position), IntOffset.m5963getYimpl(position), 0.0f, 4, (Object) null);
            }
            m4884placeOuterCoordinatorf8xVGno(position, zIndex2, layerBlock);
        }

        /* renamed from: placeOuterCoordinator-f8xVGno  reason: not valid java name */
        private final void m4884placeOuterCoordinatorf8xVGno(long position, float zIndex2, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LayingOut;
            this.lastPosition = position;
            this.lastZIndex = zIndex2;
            this.lastLayerBlock = layerBlock;
            this.placedOnce = true;
            Owner owner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
            if (LayoutNodeLayoutDelegate.this.getLayoutPending$ui_release() || !isPlaced()) {
                getAlignmentLines().setUsedByModifierLayout$ui_release(false);
                LayoutNodeLayoutDelegate.this.setCoordinatesAccessedDuringModifierPlacement(false);
                owner.getSnapshotObserver().observeLayoutModifierSnapshotReads$ui_release(LayoutNodeLayoutDelegate.this.layoutNode, false, new LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinator$1(layerBlock, LayoutNodeLayoutDelegate.this, position, zIndex2));
            } else {
                LayoutNodeLayoutDelegate.this.getOuterCoordinator().m4940placeSelfApparentToRealOffsetf8xVGno(position, zIndex2, layerBlock);
                onNodePlaced$ui_release();
            }
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.Idle;
        }

        /* Debug info: failed to restart local var, previous not found, register: 5 */
        /* JADX INFO: finally extract failed */
        public final void replace() {
            try {
                this.relayoutWithoutParentInProgress = true;
                if (this.placedOnce) {
                    m4884placeOuterCoordinatorf8xVGno(this.lastPosition, this.lastZIndex, this.lastLayerBlock);
                    this.relayoutWithoutParentInProgress = false;
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            } catch (Throwable th) {
                this.relayoutWithoutParentInProgress = false;
                throw th;
            }
        }

        public int minIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicWidth(height);
        }

        public int maxIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicWidth(height);
        }

        public int minIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicHeight(width);
        }

        public int maxIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicHeight(width);
        }

        private final void onIntrinsicsQueried() {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, false, 3, (Object) null);
            LayoutNode parent = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent != null && LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
                switch (WhenMappings.$EnumSwitchMapping$0[parent.getLayoutState$ui_release().ordinal()]) {
                    case 1:
                        usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                        break;
                    case 2:
                        usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                        break;
                    default:
                        usageByParent = parent.getIntrinsicsUsageByParent$ui_release();
                        break;
                }
                access$getLayoutNode$p.setIntrinsicsUsageByParent$ui_release(usageByParent);
            }
        }

        public final void invalidateParentData() {
            this.parentDataDirty = true;
        }

        public final boolean updateParentData() {
            if ((getParentData() == null && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getParentData() == null) || !this.parentDataDirty) {
                return false;
            }
            this.parentDataDirty = false;
            this.parentData = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getParentData();
            return true;
        }

        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            if (!this.duringAlignmentLinesQuery) {
                if (LayoutNodeLayoutDelegate.this.getLayoutState$ui_release() == LayoutNode.LayoutState.Measuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                    if (getAlignmentLines().getDirty$ui_release()) {
                        LayoutNodeLayoutDelegate.this.markLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(true);
                }
            }
            getInnerCoordinator().setPlacingForAlignment$ui_release(true);
            layoutChildren();
            getInnerCoordinator().setPlacingForAlignment$ui_release(false);
            return getAlignmentLines().getLastCalculation();
        }

        public AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutDelegate$ui_release;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || (layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release()) == null) {
                return null;
            }
            return layoutDelegate$ui_release.getAlignmentLinesOwner$ui_release();
        }

        public void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            MutableVector this_$iv$iv = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    block.invoke(((LayoutNode) content$iv$iv[i$iv$iv]).getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release());
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }

        public void requestLayout() {
            LayoutNode.requestRelayout$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, (Object) null);
        }

        public void requestMeasure() {
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, false, 3, (Object) null);
        }

        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            MutableVector this_$iv$iv;
            int size$iv$iv;
            if (LayoutNodeLayoutDelegate.this.getChildrenAccessingCoordinatesDuringPlacement() > 0 && (size$iv$iv = this_$iv$iv.getSize()) > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = (this_$iv$iv = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release()).getContent();
                do {
                    LayoutNode child = (LayoutNode) content$iv$iv[i$iv$iv];
                    LayoutNodeLayoutDelegate childLayoutDelegate = child.getLayoutDelegate$ui_release();
                    if ((childLayoutDelegate.getCoordinatesAccessedDuringPlacement() || childLayoutDelegate.getCoordinatesAccessedDuringModifierPlacement()) && !childLayoutDelegate.getLayoutPending$ui_release()) {
                        LayoutNode.requestRelayout$ui_release$default(child, false, 1, (Object) null);
                    }
                    childLayoutDelegate.getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }

        private final void onBeforeLayoutChildren() {
            LayoutNode this_$iv = LayoutNodeLayoutDelegate.this.layoutNode;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            MutableVector this_$iv$iv = this_$iv.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                    if (it.getMeasurePending$ui_release() && it.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && LayoutNode.m4829remeasure_Sx5XlM$ui_release$default(it, (Constraints) null, 1, (Object) null)) {
                        LayoutNode.requestRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, false, 3, (Object) null);
                    }
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }

        public final void invalidateIntrinsicsParent(boolean forceRequest) {
            LayoutNode parent$ui_release;
            LayoutNode parent = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.UsageByParent intrinsicsUsageByParent = LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release();
            if (parent != null && intrinsicsUsageByParent != LayoutNode.UsageByParent.NotUsed) {
                LayoutNode intrinsicsUsingParent = parent;
                while (intrinsicsUsingParent.getIntrinsicsUsageByParent$ui_release() == intrinsicsUsageByParent && (parent$ui_release = intrinsicsUsingParent.getParent$ui_release()) != null) {
                    intrinsicsUsingParent = parent$ui_release;
                }
                switch (WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent.ordinal()]) {
                    case 1:
                        LayoutNode.requestRemeasure$ui_release$default(intrinsicsUsingParent, forceRequest, false, 2, (Object) null);
                        return;
                    case 2:
                        intrinsicsUsingParent.requestRelayout$ui_release(forceRequest);
                        return;
                    default:
                        throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
                }
            }
        }

        public final void onNodeDetached() {
            this.placeOrder = Integer.MAX_VALUE;
            this.previousPlaceOrder = Integer.MAX_VALUE;
            setPlaced$ui_release(false);
        }

        public final void measureBasedOnLookahead() {
            LookaheadPassDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate$ui_release();
            LayoutNode parent = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            Intrinsics.checkNotNull(parent);
            if (lookaheadDelegate == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            } else if (lookaheadDelegate.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && parent.getLayoutState$ui_release() == LayoutNode.LayoutState.Measuring) {
                Constraints r2 = lookaheadDelegate.m4879getLastConstraintsDWUhwKw();
                Intrinsics.checkNotNull(r2);
                m4886measureBRTryo0(r2.m5794unboximpl());
            } else if (lookaheadDelegate.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InLayoutBlock && parent.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut) {
                Constraints r22 = lookaheadDelegate.m4879getLastConstraintsDWUhwKw();
                Intrinsics.checkNotNull(r22);
                m4886measureBRTryo0(r22.m5794unboximpl());
            }
        }

        public final void placeBasedOnLookahead() {
            LookaheadPassDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate$ui_release();
            if (lookaheadDelegate != null) {
                m4887placeAtf8xVGno(lookaheadDelegate.m4880getLastPositionnOccac$ui_release(), lookaheadDelegate.getLastZIndex$ui_release(), lookaheadDelegate.getLastLayerBlock$ui_release());
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0014\u0010W\u001a\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020B0XH\u0016J\b\u0010Z\u001a\u00020&H\u0002J\b\u0010[\u001a\u00020&H\u0002J\u001c\u0010\\\u001a\u00020&2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020&0$H\u0016J!\u0010^\u001a\u00020&2\u0016\u0010]\u001a\u0012\u0012\b\u0012\u00060\u0000R\u00020\u0007\u0012\u0004\u0012\u00020&0$H\bJ\u0011\u0010_\u001a\u00020B2\u0006\u0010`\u001a\u00020YH\u0002J\u000e\u0010a\u001a\u00020&2\u0006\u0010b\u001a\u00020\u0011J\u0006\u0010c\u001a\u00020&J\b\u0010d\u001a\u00020&H\u0016J\b\u0010e\u001a\u00020&H\u0002J\b\u0010f\u001a\u00020&H\u0002J\u0010\u0010g\u001a\u00020B2\u0006\u0010h\u001a\u00020BH\u0016J\u0010\u0010i\u001a\u00020B2\u0006\u0010j\u001a\u00020BH\u0016J\u001d\u0010k\u001a\u00020\u00012\u0006\u0010l\u001a\u00020 H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bm\u0010nJ\u0010\u0010o\u001a\u00020B2\u0006\u0010h\u001a\u00020BH\u0016J\u0010\u0010p\u001a\u00020B2\u0006\u0010j\u001a\u00020BH\u0016J\u0006\u0010q\u001a\u00020&J\b\u0010r\u001a\u00020&H\u0002J\b\u0010s\u001a\u00020&H\u0002J\u0006\u0010t\u001a\u00020&J\r\u0010u\u001a\u00020&H\u0000¢\u0006\u0002\bvJ@\u0010w\u001a\u00020&2\u0006\u0010x\u001a\u00020+2\u0006\u0010y\u001a\u0002002\u0019\u0010z\u001a\u0015\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010$¢\u0006\u0002\b'H\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b{\u0010|J\u001b\u0010}\u001a\u00020\u00112\u0006\u0010l\u001a\u00020 ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b~\u0010J\u0007\u0010\u0001\u001a\u00020&J\t\u0010\u0001\u001a\u00020&H\u0016J\t\u0010\u0001\u001a\u00020&H\u0016J\u0013\u0010\u0001\u001a\u00020&2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0007\u0010\u0001\u001a\u00020\u0011R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0000R\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\f\u0012\b\u0012\u00060\u0000R\u00020\u00070\r8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b!\u0010\"RD\u0010(\u001a\u0015\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010$¢\u0006\u0002\b'2\u0019\u0010#\u001a\u0015\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010$¢\u0006\u0002\b'@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R)\u0010,\u001a\u00020+2\u0006\u0010#\u001a\u00020+@BX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u001e\u00101\u001a\u0002002\u0006\u0010#\u001a\u000200@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001e\u00104\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0013R\u0019\u00106\u001a\u0004\u0018\u00010 X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0018\u00107\u001a\u000608R\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020B8VX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\u00020B8VX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010DR\u0016\u0010H\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\"\u0010L\u001a\u0004\u0018\u00010K2\b\u0010#\u001a\u0004\u0018\u00010K@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010P\u001a\u00020BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010D\"\u0004\bR\u0010SR\u000e\u0010T\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010U\u001a\u00020B2\u0006\u0010#\u001a\u00020B@BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "_childDelegates", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "childDelegates", "", "getChildDelegates$ui_release", "()Ljava/util/List;", "childDelegatesDirty", "", "getChildDelegatesDirty$ui_release", "()Z", "setChildDelegatesDirty$ui_release", "(Z)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui_release", "setDuringAlignmentLinesQuery$ui_release", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isPlaced", "setPlaced", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "<set-?>", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "lastLayerBlock", "getLastLayerBlock$ui_release", "()Lkotlin/jvm/functions/Function1;", "Landroidx/compose/ui/unit/IntOffset;", "lastPosition", "getLastPosition-nOcc-ac$ui_release", "()J", "J", "", "lastZIndex", "getLastZIndex$ui_release", "()F", "layingOutChildren", "getLayingOutChildren", "lookaheadConstraints", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredOnce", "measuredWidth", "getMeasuredWidth", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "", "parentData", "getParentData", "()Ljava/lang/Object;", "parentDataDirty", "placeOrder", "getPlaceOrder$ui_release", "setPlaceOrder$ui_release", "(I)V", "placedOnce", "previousPlaceOrder", "relayoutWithoutParentInProgress", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "checkChildrenPlaceOrderForUpdates", "clearPlaceOrder", "forEachChildAlignmentLinesOwner", "block", "forEachChildDelegate", "get", "alignmentLine", "invalidateIntrinsicsParent", "forceRequest", "invalidateParentData", "layoutChildren", "markNodeAndSubtreeAsPlaced", "markSubtreeAsNotPlaced", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "notifyChildrenUsingCoordinatesWhilePlacing", "onBeforeLayoutChildren", "onIntrinsicsQueried", "onNodeDetached", "onNodePlaced", "onNodePlaced$ui_release", "placeAt", "position", "zIndex", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "remeasure", "remeasure-BRTryo0", "(J)Z", "replace", "requestLayout", "requestMeasure", "trackLookaheadMeasurementByParent", "node", "Landroidx/compose/ui/node/LayoutNode;", "updateParentData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNodeLayoutDelegate.kt */
    public final class LookaheadPassDelegate extends Placeable implements Measurable, AlignmentLinesOwner {
        private final MutableVector<LookaheadPassDelegate> _childDelegates = new MutableVector<>(new LookaheadPassDelegate[16], 0);
        private final AlignmentLines alignmentLines = new LookaheadAlignmentLines(this);
        private boolean childDelegatesDirty = true;
        private boolean duringAlignmentLinesQuery;
        private boolean isPlaced;
        private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
        private long lastPosition = IntOffset.Companion.m5972getZeronOccac();
        private float lastZIndex;
        private boolean layingOutChildren;
        private Constraints lookaheadConstraints;
        private LayoutNode.UsageByParent measuredByParent = LayoutNode.UsageByParent.NotUsed;
        private boolean measuredOnce;
        private Object parentData = getMeasurePassDelegate$ui_release().getParentData();
        private boolean parentDataDirty = true;
        private int placeOrder = Integer.MAX_VALUE;
        private boolean placedOnce;
        private int previousPlaceOrder = Integer.MAX_VALUE;
        private boolean relayoutWithoutParentInProgress;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* compiled from: LayoutNodeLayoutDelegate.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[LayoutNode.LayoutState.values().length];
                try {
                    iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
                try {
                    iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                } catch (NoSuchFieldError e6) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public LookaheadPassDelegate() {
        }

        public final int getPlaceOrder$ui_release() {
            return this.placeOrder;
        }

        public final void setPlaceOrder$ui_release(int i) {
            this.placeOrder = i;
        }

        public final LayoutNode.UsageByParent getMeasuredByParent$ui_release() {
            return this.measuredByParent;
        }

        public final void setMeasuredByParent$ui_release(LayoutNode.UsageByParent usageByParent) {
            Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
            this.measuredByParent = usageByParent;
        }

        public final MeasurePassDelegate getMeasurePassDelegate$ui_release() {
            return LayoutNodeLayoutDelegate.this.getMeasurePassDelegate$ui_release();
        }

        public final boolean getDuringAlignmentLinesQuery$ui_release() {
            return this.duringAlignmentLinesQuery;
        }

        public final void setDuringAlignmentLinesQuery$ui_release(boolean z) {
            this.duringAlignmentLinesQuery = z;
        }

        /* renamed from: getLastConstraints-DWUhwKw  reason: not valid java name */
        public final Constraints m4879getLastConstraintsDWUhwKw() {
            return this.lookaheadConstraints;
        }

        /* renamed from: getLastPosition-nOcc-ac$ui_release  reason: not valid java name */
        public final long m4880getLastPositionnOccac$ui_release() {
            return this.lastPosition;
        }

        public final float getLastZIndex$ui_release() {
            return this.lastZIndex;
        }

        public final Function1<GraphicsLayerScope, Unit> getLastLayerBlock$ui_release() {
            return this.lastLayerBlock;
        }

        public boolean isPlaced() {
            return this.isPlaced;
        }

        public void setPlaced(boolean z) {
            this.isPlaced = z;
        }

        public NodeCoordinator getInnerCoordinator() {
            return LayoutNodeLayoutDelegate.this.layoutNode.getInnerCoordinator$ui_release();
        }

        public AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        public final boolean getChildDelegatesDirty$ui_release() {
            return this.childDelegatesDirty;
        }

        public final void setChildDelegatesDirty$ui_release(boolean z) {
            this.childDelegatesDirty = z;
        }

        public final List<LookaheadPassDelegate> getChildDelegates$ui_release() {
            int $i$f$updateChildMeasurables;
            List<LayoutNode> children$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getChildren$ui_release();
            if (!this.childDelegatesDirty) {
                return this._childDelegates.asMutableList();
            }
            LayoutNode $this$updateChildMeasurables$iv = LayoutNodeLayoutDelegate.this.layoutNode;
            MutableVector destination$iv = this._childDelegates;
            int $i$f$updateChildMeasurables2 = 0;
            MutableVector this_$iv$iv$iv = $this$updateChildMeasurables$iv.get_children$ui_release();
            int size$iv$iv$iv = this_$iv$iv$iv.getSize();
            if (size$iv$iv$iv > 0) {
                int i$iv$iv$iv = 0;
                Object[] content$iv$iv$iv = this_$iv$iv$iv.getContent();
                while (true) {
                    LayoutNode layoutNode$iv = (LayoutNode) content$iv$iv$iv[i$iv$iv$iv];
                    int i$iv = i$iv$iv$iv;
                    if (destination$iv.getSize() <= i$iv) {
                        $i$f$updateChildMeasurables = $i$f$updateChildMeasurables2;
                        LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode$iv.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                        destination$iv.add(lookaheadPassDelegate$ui_release);
                    } else {
                        $i$f$updateChildMeasurables = $i$f$updateChildMeasurables2;
                        LookaheadPassDelegate lookaheadPassDelegate$ui_release2 = layoutNode$iv.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release2);
                        destination$iv.set(i$iv, lookaheadPassDelegate$ui_release2);
                    }
                    i$iv$iv$iv++;
                    if (i$iv$iv$iv >= size$iv$iv$iv) {
                        break;
                    }
                    $i$f$updateChildMeasurables2 = $i$f$updateChildMeasurables;
                }
            }
            destination$iv.removeRange($this$updateChildMeasurables$iv.getChildren$ui_release().size(), destination$iv.getSize());
            this.childDelegatesDirty = false;
            return this._childDelegates.asMutableList();
        }

        public final boolean getLayingOutChildren() {
            return this.layingOutChildren;
        }

        private final void forEachChildDelegate(Function1<? super LookaheadPassDelegate, Unit> block) {
            MutableVector this_$iv$iv = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = ((LayoutNode) content$iv$iv[i$iv$iv]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    block.invoke(lookaheadPassDelegate$ui_release);
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }

        public void layoutChildren() {
            this.layingOutChildren = true;
            getAlignmentLines().recalculateQueryOwner();
            if (LayoutNodeLayoutDelegate.this.getLookaheadLayoutPending$ui_release()) {
                onBeforeLayoutChildren();
            }
            LookaheadDelegate lookaheadDelegate = getInnerCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            if (LayoutNodeLayoutDelegate.this.lookaheadLayoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !lookaheadDelegate.isPlacingForAlignment$ui_release() && LayoutNodeLayoutDelegate.this.getLookaheadLayoutPending$ui_release())) {
                LayoutNodeLayoutDelegate.this.lookaheadLayoutPending = false;
                LayoutNode.LayoutState oldLayoutState = LayoutNodeLayoutDelegate.this.getLayoutState$ui_release();
                LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
                Owner owner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
                LayoutNodeLayoutDelegate.this.setCoordinatesAccessedDuringPlacement(false);
                OwnerSnapshotObserver.observeLayoutSnapshotReads$ui_release$default(owner.getSnapshotObserver(), LayoutNodeLayoutDelegate.this.layoutNode, false, new LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1(this, lookaheadDelegate), 2, (Object) null);
                LayoutNodeLayoutDelegate.this.layoutState = oldLayoutState;
                if (LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringPlacement() && lookaheadDelegate.isPlacingForAlignment$ui_release()) {
                    requestLayout();
                }
                LayoutNodeLayoutDelegate.this.lookaheadLayoutPendingForAlignment = false;
            }
            if (getAlignmentLines().getUsedDuringParentLayout$ui_release()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
            }
            if (getAlignmentLines().getDirty$ui_release() && getAlignmentLines().getRequired$ui_release()) {
                getAlignmentLines().recalculate();
            }
            this.layingOutChildren = false;
        }

        /* access modifiers changed from: private */
        public final void checkChildrenPlaceOrderForUpdates() {
            MutableVector this_$iv$iv$iv = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size$iv$iv$iv = this_$iv$iv$iv.getSize();
            if (size$iv$iv$iv > 0) {
                int i$iv$iv$iv = 0;
                Object[] content$iv$iv$iv = this_$iv$iv$iv.getContent();
                do {
                    LookaheadPassDelegate child = ((LayoutNode) content$iv$iv$iv[i$iv$iv$iv]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(child);
                    int i = child.previousPlaceOrder;
                    int i2 = child.placeOrder;
                    if (i != i2 && i2 == Integer.MAX_VALUE) {
                        child.markSubtreeAsNotPlaced();
                    }
                    i$iv$iv$iv++;
                } while (i$iv$iv$iv < size$iv$iv$iv);
            }
        }

        private final void markSubtreeAsNotPlaced() {
            if (isPlaced()) {
                setPlaced(false);
                MutableVector this_$iv$iv$iv = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
                int size$iv$iv$iv = this_$iv$iv$iv.getSize();
                if (size$iv$iv$iv > 0) {
                    int i$iv$iv$iv = 0;
                    Object[] content$iv$iv$iv = this_$iv$iv$iv.getContent();
                    do {
                        LookaheadPassDelegate it = ((LayoutNode) content$iv$iv$iv[i$iv$iv$iv]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                        Intrinsics.checkNotNull(it);
                        it.markSubtreeAsNotPlaced();
                        i$iv$iv$iv++;
                    } while (i$iv$iv$iv < size$iv$iv$iv);
                }
            }
        }

        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            if (!this.duringAlignmentLinesQuery) {
                if (LayoutNodeLayoutDelegate.this.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadMeasuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                    if (getAlignmentLines().getDirty$ui_release()) {
                        LayoutNodeLayoutDelegate.this.markLookaheadLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(true);
                }
            }
            LookaheadDelegate lookaheadDelegate = getInnerCoordinator().getLookaheadDelegate();
            if (lookaheadDelegate != null) {
                lookaheadDelegate.setPlacingForAlignment$ui_release(true);
            }
            layoutChildren();
            LookaheadDelegate lookaheadDelegate2 = getInnerCoordinator().getLookaheadDelegate();
            if (lookaheadDelegate2 != null) {
                lookaheadDelegate2.setPlacingForAlignment$ui_release(false);
            }
            return getAlignmentLines().getLastCalculation();
        }

        public AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutDelegate$ui_release;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || (layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release()) == null) {
                return null;
            }
            return layoutDelegate$ui_release.getLookaheadAlignmentLinesOwner$ui_release();
        }

        public void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            MutableVector this_$iv$iv = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = ((LayoutNode) content$iv$iv[i$iv$iv]).getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
                    Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
                    block.invoke(lookaheadAlignmentLinesOwner$ui_release);
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }

        public void requestLayout() {
            LayoutNode.requestLookaheadRelayout$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, (Object) null);
        }

        public void requestMeasure() {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, false, 3, (Object) null);
        }

        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            MutableVector this_$iv$iv;
            int size$iv$iv;
            if (LayoutNodeLayoutDelegate.this.getChildrenAccessingCoordinatesDuringPlacement() > 0 && (size$iv$iv = this_$iv$iv.getSize()) > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = (this_$iv$iv = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release()).getContent();
                do {
                    LayoutNode child = (LayoutNode) content$iv$iv[i$iv$iv];
                    LayoutNodeLayoutDelegate childLayoutDelegate = child.getLayoutDelegate$ui_release();
                    if ((childLayoutDelegate.getCoordinatesAccessedDuringPlacement() || childLayoutDelegate.getCoordinatesAccessedDuringModifierPlacement()) && !childLayoutDelegate.getLayoutPending$ui_release()) {
                        LayoutNode.requestLookaheadRelayout$ui_release$default(child, false, 1, (Object) null);
                    }
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = childLayoutDelegate.getLookaheadPassDelegate$ui_release();
                    if (lookaheadPassDelegate$ui_release != null) {
                        lookaheadPassDelegate$ui_release.notifyChildrenUsingCoordinatesWhilePlacing();
                    }
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }

        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m4881measureBRTryo0(long constraints) {
            trackLookaheadMeasurementByParent(LayoutNodeLayoutDelegate.this.layoutNode);
            if (LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNodeLayoutDelegate.this.layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
            }
            m4883remeasureBRTryo0(constraints);
            return this;
        }

        private final void trackLookaheadMeasurementByParent(LayoutNode node) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode parent = node.getParent$ui_release();
            if (parent != null) {
                if (this.measuredByParent == LayoutNode.UsageByParent.NotUsed || node.getCanMultiMeasure$ui_release()) {
                    switch (WhenMappings.$EnumSwitchMapping$0[parent.getLayoutState$ui_release().ordinal()]) {
                        case 1:
                        case 2:
                            usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                            break;
                        case 3:
                        case 4:
                            usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                            break;
                        default:
                            throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent.getLayoutState$ui_release());
                    }
                    this.measuredByParent = usageByParent;
                    return;
                }
                throw new IllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()".toString());
            }
            this.measuredByParent = LayoutNode.UsageByParent.NotUsed;
        }

        public Object getParentData() {
            return this.parentData;
        }

        /* renamed from: remeasure-BRTryo0  reason: not valid java name */
        public final boolean m4883remeasureBRTryo0(long constraints) {
            LayoutNode parent = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            boolean sizeChanged = true;
            LayoutNodeLayoutDelegate.this.layoutNode.setCanMultiMeasure$ui_release(LayoutNodeLayoutDelegate.this.layoutNode.getCanMultiMeasure$ui_release() || (parent != null && parent.getCanMultiMeasure$ui_release()));
            if (!LayoutNodeLayoutDelegate.this.layoutNode.getLookaheadMeasurePending$ui_release()) {
                Constraints constraints2 = this.lookaheadConstraints;
                if (constraints2 == null ? false : Constraints.m5781equalsimpl0(constraints2.m5794unboximpl(), constraints)) {
                    Owner owner$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getOwner$ui_release();
                    if (owner$ui_release != null) {
                        owner$ui_release.forceMeasureTheSubtree(LayoutNodeLayoutDelegate.this.layoutNode, true);
                    }
                    LayoutNodeLayoutDelegate.this.layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                    return false;
                }
            }
            this.lookaheadConstraints = Constraints.m5776boximpl(constraints);
            getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
            forEachChildAlignmentLinesOwner(LayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$1.INSTANCE);
            this.measuredOnce = true;
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            if (lookaheadDelegate != null) {
                long lastLookaheadSize = IntSizeKt.IntSize(lookaheadDelegate.getWidth(), lookaheadDelegate.getHeight());
                LayoutNodeLayoutDelegate.this.m4875performLookaheadMeasureBRTryo0(constraints);
                m4727setMeasuredSizeozmzZPI(IntSizeKt.IntSize(lookaheadDelegate.getWidth(), lookaheadDelegate.getHeight()));
                if (IntSize.m6004getWidthimpl(lastLookaheadSize) == lookaheadDelegate.getWidth() && IntSize.m6003getHeightimpl(lastLookaheadSize) == lookaheadDelegate.getHeight()) {
                    sizeChanged = false;
                }
                return sizeChanged;
            }
            throw new IllegalStateException("Lookahead result from lookaheadRemeasure cannot be null".toString());
        }

        /* access modifiers changed from: protected */
        /* renamed from: placeAt-f8xVGno  reason: not valid java name */
        public void m4882placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
            this.placedOnce = true;
            if (!IntOffset.m5961equalsimpl0(position, this.lastPosition)) {
                if (LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringModifierPlacement() || LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringPlacement()) {
                    LayoutNodeLayoutDelegate.this.lookaheadLayoutPending = true;
                }
                notifyChildrenUsingCoordinatesWhilePlacing();
            }
            Owner owner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
            if (LayoutNodeLayoutDelegate.this.getLookaheadLayoutPending$ui_release() || !isPlaced()) {
                LayoutNodeLayoutDelegate.this.setCoordinatesAccessedDuringModifierPlacement(false);
                getAlignmentLines().setUsedByModifierLayout$ui_release(false);
                OwnerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release$default(owner.getSnapshotObserver(), LayoutNodeLayoutDelegate.this.layoutNode, false, new LayoutNodeLayoutDelegate$LookaheadPassDelegate$placeAt$1(LayoutNodeLayoutDelegate.this, position), 2, (Object) null);
            } else {
                onNodePlaced$ui_release();
            }
            this.lastPosition = position;
            this.lastZIndex = zIndex;
            this.lastLayerBlock = layerBlock;
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.Idle;
        }

        public int getMeasuredWidth() {
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.getMeasuredWidth();
        }

        public int getMeasuredHeight() {
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.getMeasuredHeight();
        }

        public int get(AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.LayoutState layoutState = null;
            if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LookaheadMeasuring) {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
            } else {
                LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    layoutState = parent$ui_release2.getLayoutState$ui_release();
                }
                if (layoutState == LayoutNode.LayoutState.LookaheadLayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
                }
            }
            this.duringAlignmentLinesQuery = true;
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            int result = lookaheadDelegate.get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return result;
        }

        public int minIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.minIntrinsicWidth(height);
        }

        public int maxIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.maxIntrinsicWidth(height);
        }

        public int minIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.minIntrinsicHeight(width);
        }

        public int maxIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.maxIntrinsicHeight(width);
        }

        private final void onIntrinsicsQueried() {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode.requestLookaheadRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, false, 3, (Object) null);
            LayoutNode parent = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent != null && LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
                switch (WhenMappings.$EnumSwitchMapping$0[parent.getLayoutState$ui_release().ordinal()]) {
                    case 2:
                        usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                        break;
                    case 3:
                        usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                        break;
                    default:
                        usageByParent = parent.getIntrinsicsUsageByParent$ui_release();
                        break;
                }
                access$getLayoutNode$p.setIntrinsicsUsageByParent$ui_release(usageByParent);
            }
        }

        public final void invalidateIntrinsicsParent(boolean forceRequest) {
            LayoutNode parent$ui_release;
            LayoutNode parent = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.UsageByParent intrinsicsUsageByParent = LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release();
            if (parent != null && intrinsicsUsageByParent != LayoutNode.UsageByParent.NotUsed) {
                LayoutNode intrinsicsUsingParent = parent;
                while (intrinsicsUsingParent.getIntrinsicsUsageByParent$ui_release() == intrinsicsUsageByParent && (parent$ui_release = intrinsicsUsingParent.getParent$ui_release()) != null) {
                    intrinsicsUsingParent = parent$ui_release;
                }
                switch (WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent.ordinal()]) {
                    case 1:
                        if (intrinsicsUsingParent.getLookaheadRoot$ui_release() != null) {
                            LayoutNode.requestLookaheadRemeasure$ui_release$default(intrinsicsUsingParent, forceRequest, false, 2, (Object) null);
                            return;
                        } else {
                            LayoutNode.requestRemeasure$ui_release$default(intrinsicsUsingParent, forceRequest, false, 2, (Object) null);
                            return;
                        }
                    case 2:
                        if (intrinsicsUsingParent.getLookaheadRoot$ui_release() != null) {
                            intrinsicsUsingParent.requestLookaheadRelayout$ui_release(forceRequest);
                            return;
                        } else {
                            intrinsicsUsingParent.requestRelayout$ui_release(forceRequest);
                            return;
                        }
                    default:
                        throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
                }
            }
        }

        public final void invalidateParentData() {
            this.parentDataDirty = true;
        }

        public final boolean updateParentData() {
            if (getParentData() == null) {
                LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
                Intrinsics.checkNotNull(lookaheadDelegate);
                if (lookaheadDelegate.getParentData() == null) {
                    return false;
                }
            }
            if (!this.parentDataDirty) {
                return false;
            }
            this.parentDataDirty = false;
            LookaheadDelegate lookaheadDelegate2 = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate2);
            this.parentData = lookaheadDelegate2.getParentData();
            return true;
        }

        public final void onNodePlaced$ui_release() {
            LayoutNode parent = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (!isPlaced()) {
                markNodeAndSubtreeAsPlaced();
            }
            boolean z = false;
            if (parent == null) {
                this.placeOrder = 0;
            } else if (!this.relayoutWithoutParentInProgress && (parent.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut || parent.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadLayingOut)) {
                if (this.placeOrder == Integer.MAX_VALUE) {
                    z = true;
                }
                if (z) {
                    this.placeOrder = parent.getLayoutDelegate$ui_release().nextChildLookaheadPlaceOrder;
                    LayoutNodeLayoutDelegate layoutDelegate$ui_release = parent.getLayoutDelegate$ui_release();
                    layoutDelegate$ui_release.nextChildLookaheadPlaceOrder = layoutDelegate$ui_release.nextChildLookaheadPlaceOrder + 1;
                } else {
                    throw new IllegalStateException("Place was called on a node which was placed already".toString());
                }
            }
            layoutChildren();
        }

        /* access modifiers changed from: private */
        public final void clearPlaceOrder() {
            LayoutNodeLayoutDelegate.this.nextChildLookaheadPlaceOrder = 0;
            MutableVector this_$iv$iv$iv = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size$iv$iv$iv = this_$iv$iv$iv.getSize();
            if (size$iv$iv$iv > 0) {
                int i$iv$iv$iv = 0;
                Object[] content$iv$iv$iv = this_$iv$iv$iv.getContent();
                do {
                    LookaheadPassDelegate child = ((LayoutNode) content$iv$iv$iv[i$iv$iv$iv]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(child);
                    child.previousPlaceOrder = child.placeOrder;
                    child.placeOrder = Integer.MAX_VALUE;
                    if (child.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                        child.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                    }
                    i$iv$iv$iv++;
                } while (i$iv$iv$iv < size$iv$iv$iv);
            }
        }

        private final void markNodeAndSubtreeAsPlaced() {
            boolean wasPlaced = isPlaced();
            setPlaced(true);
            if (!wasPlaced && LayoutNodeLayoutDelegate.this.getLookaheadMeasurePending$ui_release()) {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, true, false, 2, (Object) null);
            }
            MutableVector this_$iv$iv = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                    if (it.getPlaceOrder$ui_release() != Integer.MAX_VALUE) {
                        LookaheadPassDelegate lookaheadPassDelegate$ui_release = it.getLookaheadPassDelegate$ui_release();
                        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                        lookaheadPassDelegate$ui_release.markNodeAndSubtreeAsPlaced();
                        it.rescheduleRemeasureOrRelayout$ui_release(it);
                    }
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }

        private final void onBeforeLayoutChildren() {
            LayoutNode this_$iv = LayoutNodeLayoutDelegate.this.layoutNode;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            MutableVector this_$iv$iv = this_$iv.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                    if (it.getLookaheadMeasurePending$ui_release() && it.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                        LookaheadPassDelegate lookaheadPassDelegate$ui_release = it.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                        Constraints r11 = m4879getLastConstraintsDWUhwKw();
                        Intrinsics.checkNotNull(r11);
                        if (lookaheadPassDelegate$ui_release.m4883remeasureBRTryo0(r11.m5794unboximpl())) {
                            LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, false, 3, (Object) null);
                        }
                    }
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }

        /* Debug info: failed to restart local var, previous not found, register: 5 */
        /* JADX INFO: finally extract failed */
        public final void replace() {
            try {
                this.relayoutWithoutParentInProgress = true;
                if (this.placedOnce) {
                    m4882placeAtf8xVGno(this.lastPosition, 0.0f, (Function1<? super GraphicsLayerScope, Unit>) null);
                    this.relayoutWithoutParentInProgress = false;
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            } catch (Throwable th) {
                this.relayoutWithoutParentInProgress = false;
                throw th;
            }
        }

        public final void onNodeDetached() {
            this.placeOrder = Integer.MAX_VALUE;
            this.previousPlaceOrder = Integer.MAX_VALUE;
            setPlaced(false);
        }
    }

    /* access modifiers changed from: private */
    public final boolean isOutMostLookaheadRoot(LayoutNode $this$isOutMostLookaheadRoot) {
        if ($this$isOutMostLookaheadRoot.getLookaheadRoot$ui_release() != null) {
            LayoutNode parent$ui_release = $this$isOutMostLookaheadRoot.getParent$ui_release();
            if ((parent$ui_release != null ? parent$ui_release.getLookaheadRoot$ui_release() : null) == null) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: performMeasure-BRTryo0  reason: not valid java name */
    public final void m4876performMeasureBRTryo0(long constraints) {
        if (this.layoutState == LayoutNode.LayoutState.Idle) {
            this.layoutState = LayoutNode.LayoutState.Measuring;
            this.measurePending = false;
            LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver().observeMeasureSnapshotReads$ui_release(this.layoutNode, false, new LayoutNodeLayoutDelegate$performMeasure$2(this, constraints));
            if (this.layoutState == LayoutNode.LayoutState.Measuring) {
                markLayoutPending$ui_release();
                this.layoutState = LayoutNode.LayoutState.Idle;
                return;
            }
            return;
        }
        throw new IllegalStateException("layout state is not idle before measure starts".toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: performLookaheadMeasure-BRTryo0  reason: not valid java name */
    public final void m4875performLookaheadMeasureBRTryo0(long constraints) {
        this.layoutState = LayoutNode.LayoutState.LookaheadMeasuring;
        this.lookaheadMeasurePending = false;
        OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release$default(LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver(), this.layoutNode, false, new LayoutNodeLayoutDelegate$performLookaheadMeasure$1(this, constraints), 2, (Object) null);
        markLookaheadLayoutPending$ui_release();
        if (isOutMostLookaheadRoot(this.layoutNode)) {
            markLayoutPending$ui_release();
        } else {
            markMeasurePending$ui_release();
        }
        this.layoutState = LayoutNode.LayoutState.Idle;
    }

    public final void ensureLookaheadDelegateCreated$ui_release() {
        if (this.lookaheadPassDelegate == null) {
            this.lookaheadPassDelegate = new LookaheadPassDelegate();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        if (r0.updateParentData() == true) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateParentData() {
        /*
            r5 = this;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate r0 = r5.measurePassDelegate
            boolean r0 = r0.updateParentData()
            r1 = 0
            r2 = 3
            r3 = 0
            if (r0 == 0) goto L_0x0016
            androidx.compose.ui.node.LayoutNode r0 = r5.layoutNode
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x0016
            androidx.compose.ui.node.LayoutNode.requestRemeasure$ui_release$default(r0, r3, r3, r2, r1)
        L_0x0016:
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate r0 = r5.lookaheadPassDelegate
            if (r0 == 0) goto L_0x0022
            boolean r0 = r0.updateParentData()
            r4 = 1
            if (r0 != r4) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r4 = r3
        L_0x0023:
            if (r4 == 0) goto L_0x0044
            androidx.compose.ui.node.LayoutNode r0 = r5.layoutNode
            boolean r0 = r5.isOutMostLookaheadRoot(r0)
            if (r0 == 0) goto L_0x0039
            androidx.compose.ui.node.LayoutNode r0 = r5.layoutNode
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x0044
            androidx.compose.ui.node.LayoutNode.requestRemeasure$ui_release$default(r0, r3, r3, r2, r1)
            goto L_0x0044
        L_0x0039:
            androidx.compose.ui.node.LayoutNode r0 = r5.layoutNode
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x0044
            androidx.compose.ui.node.LayoutNode.requestLookaheadRemeasure$ui_release$default(r0, r3, r3, r2, r1)
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNodeLayoutDelegate.updateParentData():void");
    }

    public final void invalidateParentData() {
        this.measurePassDelegate.invalidateParentData();
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null) {
            lookaheadPassDelegate2.invalidateParentData();
        }
    }

    public final void resetAlignmentLines() {
        AlignmentLines alignmentLines;
        this.measurePassDelegate.getAlignmentLines().reset$ui_release();
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null && (alignmentLines = lookaheadPassDelegate2.getAlignmentLines()) != null) {
            alignmentLines.reset$ui_release();
        }
    }

    public final void markChildrenDirty() {
        this.measurePassDelegate.setChildDelegatesDirty$ui_release(true);
        LookaheadPassDelegate it = this.lookaheadPassDelegate;
        if (it != null) {
            it.setChildDelegatesDirty$ui_release(true);
        }
    }
}

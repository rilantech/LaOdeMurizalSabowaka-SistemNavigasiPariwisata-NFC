package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001aH\u0002J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\nH\u0016J%\u0010'\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u001d\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u001d\u0010/\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010.J%\u00101\u001a\u0002022\u0006\u0010%\u001a\u00020\u00132\u0006\u00103\u001a\u000204H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001d\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010.R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u00020\u000f8BX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001d\u001a\u00020\u001e8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006:"}, d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isAttached", "", "()Z", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadOffset", "Landroidx/compose/ui/geometry/Offset;", "getLookaheadOffset-F1C5BW0", "()J", "parentCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToWindow", "localToWindow-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadLayoutCoordinates.kt */
public final class LookaheadLayoutCoordinatesImpl implements LookaheadLayoutCoordinates {
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinatesImpl(LookaheadDelegate lookaheadDelegate2) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate2, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate2;
    }

    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m4681getSizeYbymL2g() {
        LookaheadDelegate it = this.lookaheadDelegate;
        return IntSizeKt.IntSize(it.getWidth(), it.getHeight());
    }

    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    public LayoutCoordinates getParentLayoutCoordinates() {
        LookaheadDelegate lookaheadDelegate2;
        if (isAttached()) {
            NodeCoordinator it = getCoordinator().getLayoutNode().getOuterCoordinator$ui_release().getWrappedBy$ui_release();
            if (it == null || (lookaheadDelegate2 = it.getLookaheadDelegate()) == null) {
                return null;
            }
            return lookaheadDelegate2.getCoordinates();
        }
        throw new IllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates.toString());
    }

    public LayoutCoordinates getParentCoordinates() {
        LookaheadDelegate lookaheadDelegate2;
        if (isAttached()) {
            NodeCoordinator wrappedBy$ui_release = getCoordinator().getWrappedBy$ui_release();
            if (wrappedBy$ui_release == null || (lookaheadDelegate2 = wrappedBy$ui_release.getLookaheadDelegate()) == null) {
                return null;
            }
            return lookaheadDelegate2.getCoordinates();
        }
        throw new IllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates.toString());
    }

    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    /* renamed from: getLookaheadOffset-F1C5BW0  reason: not valid java name */
    private final long m4680getLookaheadOffsetF1C5BW0() {
        LookaheadDelegate it = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        return Offset.m3007minusMKHz9U(m4682localPositionOfR5De75A(it.getCoordinates(), Offset.Companion.m3019getZeroF1C5BW0()), getCoordinator().m4935localPositionOfR5De75A(it.getCoordinator(), Offset.Companion.m3019getZeroF1C5BW0()));
    }

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    public long m4686windowToLocalMKHz9U(long relativeToWindow) {
        return Offset.m3008plusMKHz9U(getCoordinator().m4945windowToLocalMKHz9U(relativeToWindow), m4680getLookaheadOffsetF1C5BW0());
    }

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    public long m4684localToWindowMKHz9U(long relativeToLocal) {
        return getCoordinator().m4937localToWindowMKHz9U(Offset.m3008plusMKHz9U(relativeToLocal, m4680getLookaheadOffsetF1C5BW0()));
    }

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    public long m4683localToRootMKHz9U(long relativeToLocal) {
        return getCoordinator().m4936localToRootMKHz9U(Offset.m3008plusMKHz9U(relativeToLocal, m4680getLookaheadOffsetF1C5BW0()));
    }

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    public long m4682localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        LayoutCoordinates layoutCoordinates = sourceCoordinates;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        if (layoutCoordinates instanceof LookaheadLayoutCoordinatesImpl) {
            LookaheadDelegate source = ((LookaheadLayoutCoordinatesImpl) layoutCoordinates).lookaheadDelegate;
            source.getCoordinator().onCoordinatesUsed$ui_release();
            NodeCoordinator commonAncestor = getCoordinator().findCommonAncestor$ui_release(source.getCoordinator());
            LookaheadDelegate ancestor = commonAncestor.getLookaheadDelegate();
            if (ancestor != null) {
                long arg0$iv = source.m4895positionInBjo55l4$ui_release(ancestor);
                long $this$round_u2dk_u2d4lQ0M$iv = relativeToSource;
                long other$iv = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m3003getXimpl($this$round_u2dk_u2d4lQ0M$iv)), MathKt.roundToInt(Offset.m3004getYimpl($this$round_u2dk_u2d4lQ0M$iv)));
                long arg0$iv2 = IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(arg0$iv) + IntOffset.m5962getXimpl(other$iv), IntOffset.m5963getYimpl(arg0$iv) + IntOffset.m5963getYimpl(other$iv));
                long other$iv2 = this.lookaheadDelegate.m4895positionInBjo55l4$ui_release(ancestor);
                long arg0$iv3 = IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(arg0$iv2) - IntOffset.m5962getXimpl(other$iv2), IntOffset.m5963getYimpl(arg0$iv2) - IntOffset.m5963getYimpl(other$iv2));
                LookaheadDelegate lookaheadDelegate2 = source;
                NodeCoordinator nodeCoordinator = commonAncestor;
                return OffsetKt.Offset((float) IntOffset.m5962getXimpl(arg0$iv3), (float) IntOffset.m5963getYimpl(arg0$iv3));
            }
            NodeCoordinator nodeCoordinator2 = commonAncestor;
            LookaheadDelegate sourceRoot = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(source);
            long arg0$iv4 = source.m4895positionInBjo55l4$ui_release(sourceRoot);
            long other$iv3 = sourceRoot.m4892getPositionnOccac();
            long arg0$iv5 = IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(arg0$iv4) + IntOffset.m5962getXimpl(other$iv3), IntOffset.m5963getYimpl(arg0$iv4) + IntOffset.m5963getYimpl(other$iv3));
            long other$iv4 = relativeToSource;
            long other$iv5 = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m3003getXimpl(other$iv4)), MathKt.roundToInt(Offset.m3004getYimpl(other$iv4)));
            long arg0$iv6 = IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(arg0$iv5) + IntOffset.m5962getXimpl(other$iv5), IntOffset.m5963getYimpl(arg0$iv5) + IntOffset.m5963getYimpl(other$iv5));
            LookaheadDelegate $this$localPositionOf_R5De75A_u24lambda_u247_u24lambda_u246 = this.lookaheadDelegate;
            long arg0$iv7 = $this$localPositionOf_R5De75A_u24lambda_u247_u24lambda_u246.m4895positionInBjo55l4$ui_release(LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate($this$localPositionOf_R5De75A_u24lambda_u247_u24lambda_u246));
            long other$iv6 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate($this$localPositionOf_R5De75A_u24lambda_u247_u24lambda_u246).m4892getPositionnOccac();
            LookaheadDelegate lookaheadDelegate3 = source;
            NodeCoordinator nodeCoordinator3 = commonAncestor;
            long other$iv7 = IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(arg0$iv7) + IntOffset.m5962getXimpl(other$iv6), IntOffset.m5963getYimpl(arg0$iv7) + IntOffset.m5963getYimpl(other$iv6));
            long other$iv8 = IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(arg0$iv6) - IntOffset.m5962getXimpl(other$iv7), IntOffset.m5963getYimpl(arg0$iv6) - IntOffset.m5963getYimpl(other$iv7));
            NodeCoordinator wrappedBy$ui_release = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate).getCoordinator().getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release);
            NodeCoordinator wrappedBy$ui_release2 = sourceRoot.getCoordinator().getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release2);
            long $this$toOffset_u2d_u2dgyyYBs$iv = other$iv8;
            return wrappedBy$ui_release.m4935localPositionOfR5De75A(wrappedBy$ui_release2, OffsetKt.Offset((float) IntOffset.m5962getXimpl($this$toOffset_u2d_u2dgyyYBs$iv), (float) IntOffset.m5963getYimpl($this$toOffset_u2d_u2dgyyYBs$iv)));
        }
        LookaheadDelegate rootDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        return Offset.m3008plusMKHz9U(m4682localPositionOfR5De75A(rootDelegate.getLookaheadLayoutCoordinates(), relativeToSource), rootDelegate.getCoordinator().getCoordinates().m4651localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m3019getZeroF1C5BW0()));
    }

    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        return getCoordinator().localBoundingBoxOf(sourceCoordinates, clipBounds);
    }

    /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
    public void m4685transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        getCoordinator().m4943transformFromEL8BTi8(sourceCoordinates, matrix);
    }

    public int get(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return this.lookaheadDelegate.get(alignmentLine);
    }
}

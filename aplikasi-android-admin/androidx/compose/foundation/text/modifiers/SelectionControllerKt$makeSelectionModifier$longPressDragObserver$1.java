package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0007J\u001d\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0007J\u001d\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0007J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R%\u0010\u0002\u001a\u00020\u0003X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R%\u0010\t\u001a\u00020\u0003X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"androidx/compose/foundation/text/modifiers/SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "dragTotalDistance", "Landroidx/compose/ui/geometry/Offset;", "getDragTotalDistance", "()J", "setDragTotalDistance", "(J)V", "J", "lastPosition", "getLastPosition", "setLastPosition", "onCancel", "", "onDown", "point", "onDown-k-4lQ0M", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionController.kt */
public final class SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1 implements TextDragObserver {
    final /* synthetic */ Function0<LayoutCoordinates> $layoutCoordinates;
    final /* synthetic */ long $selectableId;
    final /* synthetic */ Function0<TextLayoutResult> $textLayoutResult;
    final /* synthetic */ SelectionRegistrar $this_makeSelectionModifier;
    private long dragTotalDistance = Offset.Companion.m4729getZeroF1C5BW0();
    private long lastPosition = Offset.Companion.m4729getZeroF1C5BW0();

    SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1(Function0<? extends LayoutCoordinates> $layoutCoordinates2, SelectionRegistrar $receiver, long $selectableId2, Function0<TextLayoutResult> $textLayoutResult2) {
        this.$layoutCoordinates = $layoutCoordinates2;
        this.$this_makeSelectionModifier = $receiver;
        this.$selectableId = $selectableId2;
        this.$textLayoutResult = $textLayoutResult2;
    }

    public final long getLastPosition() {
        return this.lastPosition;
    }

    public final void setLastPosition(long j) {
        this.lastPosition = j;
    }

    public final long getDragTotalDistance() {
        return this.dragTotalDistance;
    }

    public final void setDragTotalDistance(long j) {
        this.dragTotalDistance = j;
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m2734onDownk4lQ0M(long point) {
    }

    public void onUp() {
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m2736onStartk4lQ0M(long startPoint) {
        LayoutCoordinates it = this.$layoutCoordinates.invoke();
        if (it != null) {
            Function0<TextLayoutResult> function0 = this.$textLayoutResult;
            SelectionRegistrar selectionRegistrar = this.$this_makeSelectionModifier;
            long j = this.$selectableId;
            if (it.isAttached()) {
                if (SelectionControllerKt.m2733outOfBoundary2x9bVx0(function0.invoke(), startPoint, startPoint)) {
                    selectionRegistrar.notifySelectionUpdateSelectAll(j);
                } else {
                    selectionRegistrar.m2829notifySelectionUpdateStartd4ec7I(it, startPoint, SelectionAdjustment.Companion.getWord());
                }
                this.lastPosition = startPoint;
            } else {
                return;
            }
        }
        if (SelectionRegistrarKt.hasSelection(this.$this_makeSelectionModifier, this.$selectableId)) {
            this.dragTotalDistance = Offset.Companion.m4729getZeroF1C5BW0();
        }
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m2735onDragk4lQ0M(long delta) {
        LayoutCoordinates it = this.$layoutCoordinates.invoke();
        if (it != null) {
            SelectionRegistrar selectionRegistrar = this.$this_makeSelectionModifier;
            long j = this.$selectableId;
            Function0<TextLayoutResult> function0 = this.$textLayoutResult;
            if (it.isAttached() && SelectionRegistrarKt.hasSelection(selectionRegistrar, j)) {
                long r3 = Offset.m4718plusMKHz9U(this.dragTotalDistance, delta);
                this.dragTotalDistance = r3;
                long newPosition = Offset.m4718plusMKHz9U(this.lastPosition, r3);
                if (!SelectionControllerKt.m2733outOfBoundary2x9bVx0(function0.invoke(), this.lastPosition, newPosition)) {
                    if (selectionRegistrar.m2828notifySelectionUpdate5iVPX68(it, newPosition, this.lastPosition, false, SelectionAdjustment.Companion.getCharacterWithWordAccelerate())) {
                        this.lastPosition = newPosition;
                        this.dragTotalDistance = Offset.Companion.m4729getZeroF1C5BW0();
                    }
                }
            }
        }
    }

    public void onStop() {
        if (SelectionRegistrarKt.hasSelection(this.$this_makeSelectionModifier, this.$selectableId)) {
            this.$this_makeSelectionModifier.notifySelectionUpdateEnd();
        }
    }

    public void onCancel() {
        if (SelectionRegistrarKt.hasSelection(this.$this_makeSelectionModifier, this.$selectableId)) {
            this.$this_makeSelectionModifier.notifySelectionUpdateEnd();
        }
    }
}

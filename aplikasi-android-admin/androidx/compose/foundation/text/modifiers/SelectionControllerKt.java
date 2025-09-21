package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextPointerIcon_androidKt;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a+\u0010\f\u001a\u00020\u000b*\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"makeSelectionModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "selectableId", "", "layoutCoordinates", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "isInTouchMode", "", "outOfBoundary", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "outOfBoundary-2x9bVx0", "(Landroidx/compose/ui/text/TextLayoutResult;JJ)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionController.kt */
public final class SelectionControllerKt {
    /* access modifiers changed from: private */
    public static final Modifier makeSelectionModifier(SelectionRegistrar $this$makeSelectionModifier, long selectableId, Function0<? extends LayoutCoordinates> layoutCoordinates, Function0<TextLayoutResult> textLayoutResult, boolean isInTouchMode) {
        if (isInTouchMode) {
            SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1 longPressDragObserver = new SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1(layoutCoordinates, $this$makeSelectionModifier, selectableId, textLayoutResult);
            return SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) longPressDragObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SelectionControllerKt$makeSelectionModifier$1(longPressDragObserver, (Continuation<? super SelectionControllerKt$makeSelectionModifier$1>) null));
        }
        SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1 mouseSelectionObserver = new SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1(layoutCoordinates, $this$makeSelectionModifier, selectableId);
        return PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) mouseSelectionObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SelectionControllerKt$makeSelectionModifier$2(mouseSelectionObserver, (Continuation<? super SelectionControllerKt$makeSelectionModifier$2>) null)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: outOfBoundary-2x9bVx0  reason: not valid java name */
    public static final boolean m2733outOfBoundary2x9bVx0(TextLayoutResult $this$outOfBoundary_u2d2x9bVx0, long start, long end) {
        if ($this$outOfBoundary_u2d2x9bVx0 == null) {
            return false;
        }
        int lastOffset = $this$outOfBoundary_u2d2x9bVx0.getLayoutInput().getText().getText().length();
        int rawStartOffset = $this$outOfBoundary_u2d2x9bVx0.m7007getOffsetForPositionk4lQ0M(start);
        int rawEndOffset = $this$outOfBoundary_u2d2x9bVx0.m7007getOffsetForPositionk4lQ0M(end);
        if ((rawStartOffset < lastOffset - 1 || rawEndOffset < lastOffset - 1) && (rawStartOffset >= 0 || rawEndOffset >= 0)) {
            return false;
        }
        return true;
    }
}

package androidx.compose.material;

import androidx.compose.material.AnchoredDraggableState;
import androidx.compose.ui.unit.IntSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "layoutSize", "Landroidx/compose/ui/unit/IntSize;", "invoke-ozmzZPI", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheet$1 extends Lambda implements Function1<IntSize, Unit> {
    final /* synthetic */ AnchoredDraggableState.AnchorChangedCallback<BottomSheetValue> $anchorChangeCallback;
    final /* synthetic */ Function1<IntSize, Map<BottomSheetValue, Float>> $calculateAnchors;
    final /* synthetic */ BottomSheetState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheet$1(BottomSheetState bottomSheetState, Function1<? super IntSize, ? extends Map<BottomSheetValue, Float>> function1, AnchoredDraggableState.AnchorChangedCallback<BottomSheetValue> anchorChangedCallback) {
        super(1);
        this.$state = bottomSheetState;
        this.$calculateAnchors = function1;
        this.$anchorChangeCallback = anchorChangedCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        m1199invokeozmzZPI(((IntSize) p1).m6008unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-ozmzZPI  reason: not valid java name */
    public final void m1199invokeozmzZPI(long layoutSize) {
        this.$state.getAnchoredDraggableState$material_release().updateAnchors$material_release(this.$calculateAnchors.invoke(IntSize.m5996boximpl(layoutSize)), this.$anchorChangeCallback);
    }
}

package androidx.compose.material;

import androidx.compose.material.AnchoredDraggableState;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
final class SwitchKt$Switch$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AnchoredDraggableState<Boolean> $anchoredDraggableState;
    final /* synthetic */ float $maxBound;
    final /* synthetic */ float $minBound;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwitchKt$Switch$2$1(AnchoredDraggableState<Boolean> anchoredDraggableState, float f, float f2) {
        super(0);
        this.$anchoredDraggableState = anchoredDraggableState;
        this.$minBound = f;
        this.$maxBound = f2;
    }

    public final void invoke() {
        AnchoredDraggableState.updateAnchors$material_release$default(this.$anchoredDraggableState, MapsKt.mapOf(TuplesKt.to(false, Float.valueOf(this.$minBound)), TuplesKt.to(true, Float.valueOf(this.$maxBound))), (AnchoredDraggableState.AnchorChangedCallback) null, 2, (Object) null);
    }
}

package androidx.compose.material;

import androidx.compose.material.AnchoredDraggableState;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$ModalDrawer$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Density $density;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ float $maxValue;
    final /* synthetic */ float $minValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerKt$ModalDrawer$1$1$1(DrawerState drawerState, Density density, float f, float f2) {
        super(0);
        this.$drawerState = drawerState;
        this.$density = density;
        this.$minValue = f;
        this.$maxValue = f2;
    }

    public final void invoke() {
        this.$drawerState.setDensity$material_release(this.$density);
        AnchoredDraggableState.updateAnchors$material_release$default(this.$drawerState.getAnchoredDraggableState$material_release(), MapsKt.mapOf(TuplesKt.to(DrawerValue.Closed, Float.valueOf(this.$minValue)), TuplesKt.to(DrawerValue.Open, Float.valueOf(this.$maxValue))), (AnchoredDraggableState.AnchorChangedCallback) null, 2, (Object) null);
    }
}

package androidx.compose.material;

import androidx.compose.material.AnchoredDraggableState;
import androidx.compose.ui.unit.IntSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "drawerSize", "Landroidx/compose/ui/unit/IntSize;", "invoke-ozmzZPI", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$BottomDrawer$2$1$2 extends Lambda implements Function1<IntSize, Unit> {
    final /* synthetic */ AnchoredDraggableState.AnchorChangedCallback<BottomDrawerValue> $anchorChangeCallback;
    final /* synthetic */ BottomDrawerState $drawerState;
    final /* synthetic */ float $fullHeight;
    final /* synthetic */ boolean $isLandscape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerKt$BottomDrawer$2$1$2(BottomDrawerState bottomDrawerState, AnchoredDraggableState.AnchorChangedCallback<BottomDrawerValue> anchorChangedCallback, float f, boolean z) {
        super(1);
        this.$drawerState = bottomDrawerState;
        this.$anchorChangeCallback = anchorChangedCallback;
        this.$fullHeight = f;
        this.$isLandscape = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        m2998invokeozmzZPI(((IntSize) p1).m7718unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-ozmzZPI  reason: not valid java name */
    public final void m2998invokeozmzZPI(long drawerSize) {
        float drawerHeight = (float) IntSize.m7713getHeightimpl(drawerSize);
        float f = this.$fullHeight;
        boolean z = this.$isLandscape;
        Map createMapBuilder = MapsKt.createMapBuilder();
        Map $this$invoke_ozmzZPI_u24lambda_u240 = createMapBuilder;
        $this$invoke_ozmzZPI_u24lambda_u240.put(BottomDrawerValue.Closed, Float.valueOf(f));
        float peekHeight = 0.5f * f;
        if (drawerHeight > peekHeight || z) {
            $this$invoke_ozmzZPI_u24lambda_u240.put(BottomDrawerValue.Open, Float.valueOf(peekHeight));
        }
        if (drawerHeight > 0.0f) {
            $this$invoke_ozmzZPI_u24lambda_u240.put(BottomDrawerValue.Expanded, Float.valueOf(Math.max(0.0f, f - drawerHeight)));
        }
        this.$drawerState.getAnchoredDraggableState$material_release().updateAnchors$material_release(MapsKt.build(createMapBuilder), this.$anchorChangeCallback);
    }
}

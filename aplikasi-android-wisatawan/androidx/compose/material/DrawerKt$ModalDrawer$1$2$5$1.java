package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/ui/unit/Density;", "invoke-Bjo55l4", "(Landroidx/compose/ui/unit/Density;)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$ModalDrawer$1$2$5$1 extends Lambda implements Function1<Density, IntOffset> {
    final /* synthetic */ DrawerState $drawerState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerKt$ModalDrawer$1$2$5$1(DrawerState drawerState) {
        super(1);
        this.$drawerState = drawerState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return IntOffset.m5953boximpl(m1295invokeBjo55l4((Density) p1));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m1295invokeBjo55l4(Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        return IntOffsetKt.IntOffset(MathKt.roundToInt(this.$drawerState.requireOffset$material_release()), 0);
    }
}

package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/material/BottomDrawerState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$rememberBottomDrawerState$2$1 extends Lambda implements Function0<BottomDrawerState> {
    final /* synthetic */ Function1<BottomDrawerValue, Boolean> $confirmStateChange;
    final /* synthetic */ Density $density;
    final /* synthetic */ BottomDrawerValue $initialValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerKt$rememberBottomDrawerState$2$1(BottomDrawerValue bottomDrawerValue, Density density, Function1<? super BottomDrawerValue, Boolean> function1) {
        super(0);
        this.$initialValue = bottomDrawerValue;
        this.$density = density;
        this.$confirmStateChange = function1;
    }

    public final BottomDrawerState invoke() {
        return DrawerKt.BottomDrawerState(this.$initialValue, this.$density, this.$confirmStateChange);
    }
}

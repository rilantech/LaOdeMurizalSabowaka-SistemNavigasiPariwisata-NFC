package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$OneRowSnackbar$2$measure$4 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ int $buttonPlaceX;
    final /* synthetic */ int $buttonPlaceY;
    final /* synthetic */ Placeable $buttonPlaceable;
    final /* synthetic */ int $textPlaceY;
    final /* synthetic */ Placeable $textPlaceable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarKt$OneRowSnackbar$2$measure$4(Placeable placeable, int i, Placeable placeable2, int i2, int i3) {
        super(1);
        this.$textPlaceable = placeable;
        this.$textPlaceY = i;
        this.$buttonPlaceable = placeable2;
        this.$buttonPlaceX = i2;
        this.$buttonPlaceY = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable.PlacementScope placementScope = $this$layout;
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$textPlaceable, 0, this.$textPlaceY, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$buttonPlaceable, this.$buttonPlaceX, this.$buttonPlaceY, 0.0f, 4, (Object) null);
    }
}

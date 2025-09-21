package androidx.compose.animation;

import androidx.compose.runtime.State;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class SlideModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ long $measuredSize;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ SlideModifier this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SlideModifier$measure$1(SlideModifier slideModifier, Placeable placeable, long j) {
        super(1);
        this.this$0 = slideModifier;
        this.$placeable = placeable;
        this.$measuredSize = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        State slideOffset = this.this$0.getLazyAnimation().animate(this.this$0.getTransitionSpec(), new SlideModifier$measure$1$slideOffset$1(this.this$0, this.$measuredSize));
        Placeable.PlacementScope.m4732placeWithLayeraW9wM$default($this$layout, this.$placeable, slideOffset.getValue().m5971unboximpl(), 0.0f, (Function1) null, 6, (Object) null);
    }
}

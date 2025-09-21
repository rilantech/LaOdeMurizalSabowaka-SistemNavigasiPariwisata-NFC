package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Offset.kt */
final class OffsetPxNode$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ OffsetPxNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OffsetPxNode$measure$1(OffsetPxNode offsetPxNode, MeasureScope measureScope, Placeable placeable) {
        super(1);
        this.this$0 = offsetPxNode;
        this.$this_measure = measureScope;
        this.$placeable = placeable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        long offsetValue = this.this$0.getOffset().invoke(this.$this_measure).m7681unboximpl();
        if (this.this$0.getRtlAware()) {
            Placeable.PlacementScope.placeRelativeWithLayer$default($this$layout, this.$placeable, IntOffset.m7672getXimpl(offsetValue), IntOffset.m7673getYimpl(offsetValue), 0.0f, (Function1) null, 12, (Object) null);
            return;
        }
        Placeable.PlacementScope.placeWithLayer$default($this$layout, this.$placeable, IntOffset.m7672getXimpl(offsetValue), IntOffset.m7673getYimpl(offsetValue), 0.0f, (Function1) null, 12, (Object) null);
    }
}

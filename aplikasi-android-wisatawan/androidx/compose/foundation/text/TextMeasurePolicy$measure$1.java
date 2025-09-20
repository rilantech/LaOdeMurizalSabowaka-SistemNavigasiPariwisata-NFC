package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class TextMeasurePolicy$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<Pair<Placeable, IntOffset>> $toPlace;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextMeasurePolicy$measure$1(List<? extends Pair<? extends Placeable, IntOffset>> list) {
        super(1);
        this.$toPlace = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        List list = this.$toPlace;
        if (list != null) {
            List $this$fastForEach$iv = list;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Pair pair = $this$fastForEach$iv.get(index$iv);
                Placeable.PlacementScope.m4729place70tqf50$default($this$layout, (Placeable) pair.component1(), ((IntOffset) pair.component2()).m5971unboximpl(), 0.0f, 2, (Object) null);
            }
        }
    }
}

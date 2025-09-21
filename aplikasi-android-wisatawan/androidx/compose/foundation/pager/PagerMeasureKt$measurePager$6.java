package androidx.compose.foundation.pager;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerMeasure.kt */
final class PagerMeasureKt$measurePager$6 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<MeasuredPage> $positionedPages;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerMeasureKt$measurePager$6(List<MeasuredPage> list) {
        super(1);
        this.$positionedPages = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$invoke) {
        Intrinsics.checkNotNullParameter($this$invoke, "$this$invoke");
        List $this$fastForEach$iv = this.$positionedPages;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            $this$fastForEach$iv.get(index$iv).place($this$invoke);
        }
    }
}

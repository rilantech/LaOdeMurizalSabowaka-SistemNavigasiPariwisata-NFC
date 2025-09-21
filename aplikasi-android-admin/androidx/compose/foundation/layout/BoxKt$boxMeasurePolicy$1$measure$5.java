package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Box.kt */
final class BoxKt$boxMeasurePolicy$1$measure$5 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Alignment $alignment;
    final /* synthetic */ Ref.IntRef $boxHeight;
    final /* synthetic */ Ref.IntRef $boxWidth;
    final /* synthetic */ List<Measurable> $measurables;
    final /* synthetic */ Placeable[] $placeables;
    final /* synthetic */ MeasureScope $this_MeasurePolicy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoxKt$boxMeasurePolicy$1$measure$5(Placeable[] placeableArr, List<? extends Measurable> list, MeasureScope measureScope, Ref.IntRef intRef, Ref.IntRef intRef2, Alignment alignment) {
        super(1);
        this.$placeables = placeableArr;
        this.$measurables = list;
        this.$this_MeasurePolicy = measureScope;
        this.$boxWidth = intRef;
        this.$boxHeight = intRef2;
        this.$alignment = alignment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable[] placeableArr = this.$placeables;
        List<Measurable> list = this.$measurables;
        MeasureScope measureScope = this.$this_MeasurePolicy;
        Ref.IntRef intRef = this.$boxWidth;
        Ref.IntRef intRef2 = this.$boxHeight;
        Alignment alignment = this.$alignment;
        int index$iv = 0;
        int i = 0;
        for (int length = placeableArr.length; i < length; length = length) {
            int index = index$iv;
            Placeable placeable = placeableArr[i];
            Intrinsics.checkNotNull(placeable, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
            LayoutDirection layoutDirection = measureScope.getLayoutDirection();
            Placeable placeable2 = placeable;
            LayoutDirection layoutDirection2 = layoutDirection;
            int i2 = index;
            int i3 = i;
            BoxKt.placeInBox($this$layout, placeable, list.get(index), layoutDirection2, intRef.element, intRef2.element, alignment);
            i = i3 + 1;
            index$iv++;
        }
    }
}

package androidx.compose.material3;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$CircularLayout$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ long $constraints;
    final /* synthetic */ Placeable $innerCirclePlaceable;
    final /* synthetic */ List<Placeable> $placeables;
    final /* synthetic */ float $radiusPx;
    final /* synthetic */ Placeable $selectorPlaceable;
    final /* synthetic */ float $theta;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$CircularLayout$1$measure$1(Placeable placeable, List<? extends Placeable> list, Placeable placeable2, long j, float f, float f2) {
        super(1);
        this.$selectorPlaceable = placeable;
        this.$placeables = list;
        this.$innerCirclePlaceable = placeable2;
        this.$constraints = j;
        this.$radiusPx = f;
        this.$theta = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable placeable = this.$selectorPlaceable;
        if (placeable != null) {
            Placeable.PlacementScope.place$default($this$layout, placeable, 0, 0, 0.0f, 4, (Object) null);
        }
        long j = this.$constraints;
        float f = this.$radiusPx;
        float f2 = this.$theta;
        int index$iv = 0;
        for (Object item$iv : this.$placeables) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Placeable it = (Placeable) item$iv;
            int i = index$iv;
            int centerOffsetX = (Constraints.m5788getMaxWidthimpl(j) / 2) - (it.getWidth() / 2);
            int centerOffsetY = (Constraints.m5787getMaxHeightimpl(j) / 2) - (it.getHeight() / 2);
            double d = (double) f;
            double offsetX = ((double) centerOffsetX) + (Math.cos(((double) (((float) i) * f2)) - 1.5707963267948966d) * d);
            double offsetY = (d * Math.sin(((double) (((float) i) * f2)) - 1.5707963267948966d)) + ((double) centerOffsetY);
            int i2 = centerOffsetY;
            int i3 = centerOffsetX;
            int i4 = i;
            Placeable.PlacementScope.place$default($this$layout, it, MathKt.roundToInt(offsetX), MathKt.roundToInt(offsetY), 0.0f, 4, (Object) null);
            Placeable.PlacementScope placementScope = $this$layout;
            index$iv = index$iv2;
            j = j;
        }
        Placeable placeable2 = this.$innerCirclePlaceable;
        if (placeable2 != null) {
            Placeable.PlacementScope.place$default($this$layout, placeable2, (Constraints.m5790getMinWidthimpl(this.$constraints) - this.$innerCirclePlaceable.getWidth()) / 2, (Constraints.m5789getMinHeightimpl(this.$constraints) - this.$innerCirclePlaceable.getHeight()) / 2, 0.0f, 4, (Object) null);
        }
    }
}

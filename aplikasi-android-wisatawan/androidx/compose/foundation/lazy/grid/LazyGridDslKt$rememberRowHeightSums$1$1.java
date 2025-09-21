package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "Landroidx/compose/ui/unit/Density;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/lazy/grid/LazyGridSlots;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridDsl.kt */
final class LazyGridDslKt$rememberRowHeightSums$1$1 extends Lambda implements Function2<Density, Constraints, LazyGridSlots> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ GridCells $rows;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridDslKt$rememberRowHeightSums$1$1(PaddingValues paddingValues, GridCells gridCells, Arrangement.Vertical vertical) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$rows = gridCells;
        this.$verticalArrangement = vertical;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m704invoke0kLqBqw((Density) p1, ((Constraints) p2).m5794unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyGridSlots m704invoke0kLqBqw(Density $this$$receiver, long constraints) {
        Intrinsics.checkNotNullParameter($this$$receiver, "$this$$receiver");
        if (Constraints.m5787getMaxHeightimpl(constraints) != Integer.MAX_VALUE) {
            int gridHeight = Constraints.m5787getMaxHeightimpl(constraints) - $this$$receiver.m5819roundToPx0680j_4(Dp.m5844constructorimpl(this.$contentPadding.m555calculateTopPaddingD9Ej5fM() + this.$contentPadding.m552calculateBottomPaddingD9Ej5fM()));
            GridCells $this$invoke_0kLqBqw_u24lambda_u243 = this.$rows;
            Arrangement.Vertical $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241 = this.$verticalArrangement;
            int[] sizes = CollectionsKt.toIntArray($this$invoke_0kLqBqw_u24lambda_u243.calculateCrossAxisCellSizes($this$$receiver, gridHeight, $this$$receiver.m5819roundToPx0680j_4($this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.m444getSpacingD9Ej5fM())));
            int[] positions = new int[sizes.length];
            $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.arrange($this$$receiver, gridHeight, sizes, positions);
            return new LazyGridSlots(sizes, positions);
        }
        throw new IllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.".toString());
    }
}

package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "Landroidx/compose/ui/unit/Density;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/lazy/grid/LazyGridSlots;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridDsl.kt */
final class LazyGridDslKt$rememberColumnWidthSums$1$1 extends Lambda implements Function2<Density, Constraints, LazyGridSlots> {
    final /* synthetic */ GridCells $columns;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridDslKt$rememberColumnWidthSums$1$1(PaddingValues paddingValues, GridCells gridCells, Arrangement.Horizontal horizontal) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$columns = gridCells;
        this.$horizontalArrangement = horizontal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m703invoke0kLqBqw((Density) p1, ((Constraints) p2).m5794unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyGridSlots m703invoke0kLqBqw(Density $this$$receiver, long constraints) {
        Density density = $this$$receiver;
        Intrinsics.checkNotNullParameter(density, "$this$$receiver");
        if (Constraints.m5788getMaxWidthimpl(constraints) != Integer.MAX_VALUE) {
            int gridWidth = Constraints.m5788getMaxWidthimpl(constraints) - density.m5819roundToPx0680j_4(Dp.m5844constructorimpl(PaddingKt.calculateStartPadding(this.$contentPadding, LayoutDirection.Ltr) + PaddingKt.calculateEndPadding(this.$contentPadding, LayoutDirection.Ltr)));
            GridCells $this$invoke_0kLqBqw_u24lambda_u243 = this.$columns;
            Arrangement.Horizontal $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241 = this.$horizontalArrangement;
            int[] sizes = CollectionsKt.toIntArray($this$invoke_0kLqBqw_u24lambda_u243.calculateCrossAxisCellSizes(density, gridWidth, density.m5819roundToPx0680j_4($this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.m430getSpacingD9Ej5fM())));
            int[] positions = new int[sizes.length];
            $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.arrange($this$$receiver, gridWidth, sizes, LayoutDirection.Ltr, positions);
            return new LazyGridSlots(sizes, positions);
        }
        throw new IllegalArgumentException("LazyVerticalGrid's width should be bound by parent.".toString());
    }
}

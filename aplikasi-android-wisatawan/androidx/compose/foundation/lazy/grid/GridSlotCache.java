package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B'\u0012\u001d\u0010\u0005\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J&\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001a\u00020\u0003X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridSlotCache;", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "calculation", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)V", "cachedConstraints", "J", "cachedDensity", "", "cachedSizes", "invoke", "density", "constraints", "invoke-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridDsl.kt */
final class GridSlotCache implements Function2<Density, Constraints, LazyGridSlots> {
    private long cachedConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null);
    private float cachedDensity;
    private LazyGridSlots cachedSizes;
    private final Function2<Density, Constraints, LazyGridSlots> calculation;

    public GridSlotCache(Function2<? super Density, ? super Constraints, LazyGridSlots> calculation2) {
        Intrinsics.checkNotNullParameter(calculation2, "calculation");
        this.calculation = calculation2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m698invoke0kLqBqw((Density) p1, ((Constraints) p2).m5794unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public LazyGridSlots m698invoke0kLqBqw(Density density, long constraints) {
        Intrinsics.checkNotNullParameter(density, "density");
        Density $this$invoke_0kLqBqw_u24lambda_u241 = density;
        if (this.cachedSizes != null && Constraints.m5781equalsimpl0(this.cachedConstraints, constraints)) {
            if (this.cachedDensity == $this$invoke_0kLqBqw_u24lambda_u241.getDensity()) {
                LazyGridSlots lazyGridSlots = this.cachedSizes;
                Intrinsics.checkNotNull(lazyGridSlots);
                return lazyGridSlots;
            }
        }
        this.cachedConstraints = constraints;
        this.cachedDensity = $this$invoke_0kLqBqw_u24lambda_u241.getDensity();
        LazyGridSlots it = this.calculation.invoke($this$invoke_0kLqBqw_u24lambda_u241, Constraints.m5776boximpl(constraints));
        this.cachedSizes = it;
        return it;
    }
}

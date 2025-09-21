package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/compose/material/ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1", "Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "exposedDropdownSize", "Landroidx/compose/ui/Modifier;", "matchTextFieldWidth", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 implements ExposedDropdownMenuBoxScope {
    final /* synthetic */ Density $density;
    final /* synthetic */ MutableIntState $menuHeight$delegate;
    final /* synthetic */ MutableIntState $width$delegate;

    ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(Density $density2, MutableIntState $menuHeight$delegate2, MutableIntState $width$delegate2) {
        this.$density = $density2;
        this.$menuHeight$delegate = $menuHeight$delegate2;
        this.$width$delegate = $width$delegate2;
    }

    public Modifier exposedDropdownSize(Modifier $this$exposedDropdownSize, boolean matchTextFieldWidth) {
        Intrinsics.checkNotNullParameter($this$exposedDropdownSize, "<this>");
        Density $this$exposedDropdownSize_u24lambda_u241 = this.$density;
        MutableIntState mutableIntState = this.$menuHeight$delegate;
        MutableIntState mutableIntState2 = this.$width$delegate;
        Modifier it = SizeKt.m2310heightInVpY3zN4$default($this$exposedDropdownSize, 0.0f, $this$exposedDropdownSize_u24lambda_u241.m7532toDpu2uoSUM(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$4(mutableIntState)), 1, (Object) null);
        if (matchTextFieldWidth) {
            return SizeKt.m2327width3ABfNKs(it, $this$exposedDropdownSize_u24lambda_u241.m7532toDpu2uoSUM(ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$1(mutableIntState2)));
        }
        return it;
    }
}

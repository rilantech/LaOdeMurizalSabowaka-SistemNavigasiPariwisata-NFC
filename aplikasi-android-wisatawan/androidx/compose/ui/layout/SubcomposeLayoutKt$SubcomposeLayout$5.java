package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
final class SubcomposeLayoutKt$SubcomposeLayout$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult> $intermediateMeasurePolicy;
    final /* synthetic */ Function2<SubcomposeMeasureScope, Constraints, MeasureResult> $measurePolicy;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubcomposeLayoutKt$SubcomposeLayout$5(Modifier modifier, Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> function2, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function22, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$intermediateMeasurePolicy = function2;
        this.$measurePolicy = function22;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SubcomposeLayoutKt.SubcomposeLayout(this.$modifier, (Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult>) this.$intermediateMeasurePolicy, (Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>) this.$measurePolicy, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}

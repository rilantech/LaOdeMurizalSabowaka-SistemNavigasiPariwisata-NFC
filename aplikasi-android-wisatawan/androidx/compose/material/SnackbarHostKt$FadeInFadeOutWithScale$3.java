package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnackbarHost.kt */
final class SnackbarHostKt$FadeInFadeOutWithScale$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function3<SnackbarData, Composer, Integer, Unit> $content;
    final /* synthetic */ SnackbarData $current;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarHostKt$FadeInFadeOutWithScale$3(SnackbarData snackbarData, Modifier modifier, Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3, int i, int i2) {
        super(2);
        this.$current = snackbarData;
        this.$modifier = modifier;
        this.$content = function3;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SnackbarHostKt.FadeInFadeOutWithScale(this.$current, this.$modifier, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}

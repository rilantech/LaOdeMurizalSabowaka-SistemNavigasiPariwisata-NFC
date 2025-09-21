package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "progress", "", "invoke", "(FLandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomNavigation.kt */
final class BottomNavigationKt$BottomNavigationItem$2$1 extends Lambda implements Function3<Float, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ boolean $alwaysShowLabel;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $styledLabel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomNavigationKt$BottomNavigationItem$2$1(boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i) {
        super(3);
        this.$alwaysShowLabel = z;
        this.$icon = function2;
        this.$styledLabel = function22;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke(((Number) p1).floatValue(), (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float progress, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C189@8379L181:BottomNavigation.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer.changed(progress) ? 4 : 2;
        }
        if (($dirty & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1411872801, $changed, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:186)");
            }
            BottomNavigationKt.BottomNavigationItemBaselineLayout(this.$icon, this.$styledLabel, this.$alwaysShowLabel ? 1.0f : progress, $composer, (this.$$dirty >> 9) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

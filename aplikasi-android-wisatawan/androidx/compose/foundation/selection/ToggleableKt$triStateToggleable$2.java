package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Toggleable.kt */
final class ToggleableKt$triStateToggleable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Role $role;
    final /* synthetic */ ToggleableState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ToggleableKt$triStateToggleable$2(ToggleableState toggleableState, boolean z, Role role, Function0<Unit> function0) {
        super(3);
        this.$state = toggleableState;
        this.$enabled = z;
        this.$role = role;
        this.$onClick = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        $composer.startReplaceableGroup(-1808118329);
        ComposerKt.sourceInformation($composer, "C165@6476L39,166@6554L7:Toggleable.kt#gro6r2");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1808118329, $changed, -1, "androidx.compose.foundation.selection.triStateToggleable.<anonymous> (Toggleable.kt:162)");
        }
        Modifier modifier = Modifier.Companion;
        ToggleableState toggleableState = this.$state;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = InteractionSourceKt.MutableInteractionSource();
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(IndicationKt.getLocalIndication());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier r0 = ToggleableKt.m841triStateToggleableO2vRcR0(modifier, toggleableState, (MutableInteractionSource) value$iv$iv, (Indication) consume, this.$enabled, this.$role, this.$onClick);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }
}

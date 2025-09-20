package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Selectable.kt */
final class SelectableKt$selectable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Role $role;
    final /* synthetic */ boolean $selected;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectableKt$selectable$2(boolean z, boolean z2, Role role, Function0<Unit> function0) {
        super(3);
        this.$selected = z;
        this.$enabled = z2;
        this.$role = role;
        this.$onClick = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Object value$iv$iv;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        composer.startReplaceableGroup(-2124609672);
        ComposerKt.sourceInformation(composer, "C72@2940L39,73@3018L7:Selectable.kt#gro6r2");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2124609672, $changed, -1, "androidx.compose.foundation.selection.selectable.<anonymous> (Selectable.kt:67)");
        } else {
            int i = $changed;
        }
        Modifier.Companion companion = Modifier.Companion;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = InteractionSourceKt.MutableInteractionSource();
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(IndicationKt.getLocalIndication());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier r2 = SelectableKt.m833selectableO2vRcR0(companion, this.$selected, (MutableInteractionSource) value$iv$iv, (Indication) consume, this.$enabled, this.$role, this.$onClick);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r2;
    }
}

package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerIcon.kt */
final class PointerIconKt$pointerHoverIcon$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ PointerIcon $icon;
    final /* synthetic */ boolean $overrideDescendants;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PointerIconKt$pointerHoverIcon$2(PointerIcon pointerIcon, boolean z) {
        super(3);
        this.$icon = pointerIcon;
        this.$overrideDescendants = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Modifier modifier;
        Object value$iv$iv;
        Object value$iv$iv2;
        Modifier pointerInputModifier;
        Object value$iv$iv3;
        Modifier modifier2 = $this$composed;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
        composer.startReplaceableGroup(811087536);
        ComposerKt.sourceInformation(composer, "C90@3499L7,97@3759L103,100@3886L226,100@3875L237,108@4265L525:PointerIcon.kt#a556rk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(811087536, $changed, -1, "androidx.compose.ui.input.pointer.pointerHoverIcon.<anonymous> (PointerIcon.kt:89)");
        } else {
            int i = $changed;
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalPointerIconService());
        ComposerKt.sourceInformationMarkerEnd($composer);
        PointerIconService pointerIconService = (PointerIconService) consume;
        if (pointerIconService == null) {
            modifier = Modifier.Companion;
            PointerIconService pointerIconService2 = pointerIconService;
        } else {
            Function1 onSetIcon = new PointerIconKt$pointerHoverIcon$2$onSetIcon$1(pointerIconService);
            PointerIcon pointerIcon = this.$icon;
            boolean z = this.$overrideDescendants;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                PointerIconService pointerIconService3 = pointerIconService;
                value$iv$iv = new PointerIconModifierLocal(pointerIcon, z, onSetIcon);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            PointerIconModifierLocal pointerIconModifierLocal = (PointerIconModifierLocal) value$iv$iv;
            Object[] keys$iv = {pointerIconModifierLocal, this.$icon, Boolean.valueOf(this.$overrideDescendants), onSetIcon};
            PointerIcon pointerIcon2 = this.$icon;
            boolean z2 = this.$overrideDescendants;
            composer.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= composer.changed(key$iv);
            }
            Composer $this$cache$iv$iv2 = $composer;
            Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            if (invalid$iv || it$iv$iv2 == Composer.Companion.getEmpty()) {
                value$iv$iv2 = (Function0) new PointerIconKt$pointerHoverIcon$2$1$1(pointerIconModifierLocal, pointerIcon2, z2, onSetIcon);
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) value$iv$iv2, composer, 0);
            if (pointerIconModifierLocal.shouldUpdatePointerIcon()) {
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = composer.changed((Object) pointerIconModifierLocal);
                Composer $this$cache$iv$iv3 = $composer;
                Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
                if (invalid$iv$iv || it$iv$iv3 == Composer.Companion.getEmpty()) {
                    value$iv$iv3 = (Function2) new PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1(pointerIconModifierLocal, (Continuation<? super PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1>) null);
                    $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
                } else {
                    value$iv$iv3 = it$iv$iv3;
                }
                $composer.endReplaceableGroup();
                pointerInputModifier = SuspendingPointerInputFilterKt.pointerInput(modifier2, (Object) pointerIconModifierLocal, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv3);
            } else {
                pointerInputModifier = Modifier.Companion;
            }
            modifier = pointerIconModifierLocal.then(pointerInputModifier);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return modifier;
    }
}

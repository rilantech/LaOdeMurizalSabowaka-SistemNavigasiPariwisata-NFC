package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InteractiveComponentSize.kt */
final class InteractiveComponentSizeKt$minimumInteractiveComponentSize$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    public static final InteractiveComponentSizeKt$minimumInteractiveComponentSize$2 INSTANCE = new InteractiveComponentSizeKt$minimumInteractiveComponentSize$2();

    InteractiveComponentSizeKt$minimumInteractiveComponentSize$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Modifier modifier;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        $composer.startReplaceableGroup(279503903);
        ComposerKt.sourceInformation($composer, "C55@2553L7:InteractiveComponentSize.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(279503903, $changed, -1, "androidx.compose.material3.minimumInteractiveComponentSize.<anonymous> (InteractiveComponentSize.kt:54)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentEnforcement());
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (((Boolean) consume).booleanValue()) {
            modifier = new MinimumInteractiveComponentSizeModifier(InteractiveComponentSizeKt.minimumInteractiveComponentSize, (DefaultConstructorMarker) null);
        } else {
            modifier = Modifier.Companion;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return modifier;
    }
}

package androidx.compose.foundation.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Spacer", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Spacer.kt */
public final class SpacerKt {
    public static final void Spacer(Modifier modifier, Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        composer.startReplaceableGroup(-72882467);
        ComposerKt.sourceInformation(composer, "C(Spacer)39@1433L68:Spacer.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-72882467, i, -1, "androidx.compose.foundation.layout.Spacer (Spacer.kt:38)");
        }
        SpacerMeasurePolicy spacerMeasurePolicy = SpacerMeasurePolicy.INSTANCE;
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap localMap$iv = $composer.getCurrentCompositionLocalMap();
        Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
        Function3 skippableUpdate$iv$iv = LayoutKt.modifierMaterializerOf(modifier);
        int $changed$iv$iv = (((((i << 3) & 112) | 384) << 9) & 7168) | 6;
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            composer.createNode(factory$iv$iv);
        } else {
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv = Updater.m2865constructorimpl($composer);
        Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, spacerMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 block$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
        Composer $this$set_impl_u24lambda_u240$iv$iv = $this$Layout_u24lambda_u240$iv;
        if ($this$set_impl_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$set_impl_u24lambda_u240$iv$iv.rememberedValue(), (Object) Integer.valueOf(compositeKeyHash$iv))) {
            $this$set_impl_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
            $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
        }
        skippableUpdate$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        int i2 = ($changed$iv$iv >> 9) & 14;
        Composer $composer2 = $composer;
        ComposerKt.sourceInformationMarkerStart($composer2, 348366764, "C:Spacer.kt#2w3rfo");
        ComposerKt.sourceInformationMarkerEnd($composer2);
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }
}

package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: IconButton.kt */
final class IconButtonKt$FilledIconButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IconButtonKt$FilledIconButton$3(Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$content = function2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C213@10377L152:IconButton.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1560623888, i, -1, "androidx.compose.material3.FilledIconButton.<anonymous> (IconButton.kt:212)");
            }
            Modifier modifier$iv = SizeKt.m2322size3ABfNKs(Modifier.Companion, FilledIconButtonTokens.INSTANCE.m4211getContainerSizeD9Ej5fM());
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            Function2<Composer, Integer, Unit> function2 = this.$content;
            int i2 = this.$$dirty;
            composer.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv = ((((54 << 3) & 112) << 9) & 7168) | 6;
            Alignment alignment = contentAlignment$iv;
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                $composer.useNode();
            }
            $composer.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m4575constructorimpl($composer);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            Composer $composer$iv = $composer;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i3 = ((54 >> 6) & 112) | 6;
            int i4 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer2 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, -1557816860, "C217@10514L9:IconButton.kt#uh7d8r");
            function2.invoke($composer2, Integer.valueOf((i2 >> 18) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer.endReplaceableGroup();
            $composer.endNode();
            $composer.endReplaceableGroup();
            $composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

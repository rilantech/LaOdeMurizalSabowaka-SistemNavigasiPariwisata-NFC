package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
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
/* compiled from: AppBar.kt */
final class AppBarKt$TwoRowsTopAppBar$actionsRow$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $actions;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$TwoRowsTopAppBar$actionsRow$1(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$actions = function3;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C1170@52876L157:AppBar.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1048401111, i, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:1169)");
            }
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getEnd();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Function3 content$iv = this.$actions;
            int $changed$iv = ((this.$$dirty >> 12) & 7168) | 432;
            composer.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, composer, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
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
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(Modifier.Companion);
            int $changed$iv$iv$iv = (((($changed$iv << 3) & 112) << 9) & 7168) | 6;
            Arrangement.Horizontal horizontal = horizontalArrangement$iv;
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                composer.createNode(factory$iv$iv$iv);
            } else {
                $composer.useNode();
            }
            $composer.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2865constructorimpl($composer);
            Alignment.Vertical vertical = verticalAlignment$iv;
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            int i2 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            content$iv.invoke(RowScopeInstance.INSTANCE, $composer$iv, Integer.valueOf((($changed$iv >> 6) & 112) | 6));
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

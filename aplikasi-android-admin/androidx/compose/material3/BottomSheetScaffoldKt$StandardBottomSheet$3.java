package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$StandardBottomSheet$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dragHandle;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ boolean $sheetSwipeEnabled;
    final /* synthetic */ SheetState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$StandardBottomSheet$3(Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i, SheetState sheetState, boolean z, CoroutineScope coroutineScope, int i2) {
        super(2);
        this.$dragHandle = function2;
        this.$content = function3;
        this.$$dirty1 = i;
        this.$state = sheetState;
        this.$sheetSwipeEnabled = z;
        this.$scope = coroutineScope;
        this.$$dirty = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer $composer$iv;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C270@11700L2114:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1381492089, i, -1, "androidx.compose.material3.StandardBottomSheet.<anonymous> (BottomSheetScaffold.kt:269)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Function2<Composer, Integer, Unit> function2 = this.$dragHandle;
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$content;
            int i2 = this.$$dirty1;
            SheetState sheetState = this.$state;
            boolean z = this.$sheetSwipeEnabled;
            CoroutineScope coroutineScope = this.$scope;
            int i3 = this.$$dirty;
            composer.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv = (Density) consume;
            Alignment.Horizontal horizontal = horizontalAlignment$iv;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            Arrangement.Vertical vertical = verticalArrangement$iv;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
            int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = materializerOf;
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
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = function33;
            function34.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            int i4 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv2 = $composer;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            int $changed2 = ((6 >> 6) & 112) | 6;
            ColumnScope $this$invoke_u24lambda_u241 = ColumnScopeInstance.INSTANCE;
            int i5 = $changed$iv$iv$iv;
            int i6 = i2;
            Composer $composer2 = $composer$iv2;
            ComposerKt.sourceInformationMarkerStart($composer2, -176229648, "C309@13795L9:BottomSheetScaffold.kt#uh7d8r");
            $composer2.startReplaceableGroup(-176229648);
            ComposerKt.sourceInformation($composer2, "273@11839L54,274@11935L48,275@12024L47,276@12088L1680");
            if (function2 != null) {
                Density density = density$iv$iv;
                String partialExpandActionLabel = Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3704getBottomSheetPartialExpandDescriptionadMyvUU(), $composer2, 6);
                String dismissActionLabel = Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3700getBottomSheetDismissDescriptionadMyvUU(), $composer2, 6);
                MeasurePolicy measurePolicy = measurePolicy$iv;
                $composer$iv = $composer$iv2;
                ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                Modifier modifier$iv2 = SemanticsModifierKt.semantics($this$invoke_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getCenterHorizontally()), true, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1(sheetState, z, Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3702getBottomSheetExpandDescriptionadMyvUU(), $composer2, 6), partialExpandActionLabel, dismissActionLabel, coroutineScope));
                $composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                String str = dismissActionLabel;
                $composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density density$iv$iv2 = (Density) consume4;
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                Alignment alignment = contentAlignment$iv;
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
                Modifier modifier2 = modifier$iv2;
                int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    $composer2.createNode(constructor2);
                } else {
                    $composer2.useNode();
                }
                $composer2.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m4575constructorimpl($composer2);
                Function0<ComposeUiNode> function02 = constructor2;
                Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer2.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer2.startReplaceableGroup(2058660585);
                int i7 = ($changed$iv$iv$iv2 >> 9) & 14;
                Composer $composer$iv3 = $composer2;
                Density density2 = density$iv$iv2;
                ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i8 = ((0 >> 6) & 112) | 6;
                int i9 = $changed$iv$iv$iv2;
                Composer $composer3 = $composer$iv3;
                ComposerKt.sourceInformationMarkerStart($composer3, 1084282841, "C306@13738L12:BottomSheetScaffold.kt#uh7d8r");
                function2.invoke($composer3, Integer.valueOf((i3 >> 27) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer2.endReplaceableGroup();
                $composer2.endNode();
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
            } else {
                $composer$iv = $composer$iv2;
                Density density3 = density$iv$iv;
                ViewConfiguration viewConfiguration3 = viewConfiguration$iv$iv;
            }
            $composer2.endReplaceableGroup();
            function32.invoke($this$invoke_u24lambda_u241, $composer2, Integer.valueOf(($changed2 & 14) | ((i6 << 3) & 112)));
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

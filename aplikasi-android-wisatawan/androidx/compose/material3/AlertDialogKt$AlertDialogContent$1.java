package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
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
/* compiled from: AlertDialog.kt */
final class AlertDialogKt$AlertDialogContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $buttonContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $buttons;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ long $iconContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ long $textContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ long $titleContentColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlertDialogKt$AlertDialogContent$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, long j, int i, long j2, long j3, long j4, Function2<? super Composer, ? super Integer, Unit> function24) {
        super(2);
        this.$icon = function2;
        this.$title = function22;
        this.$text = function23;
        this.$iconContentColor = j;
        this.$$dirty = i;
        this.$titleContentColor = j2;
        this.$textContentColor = j3;
        this.$buttonContentColor = j4;
        this.$buttons = function24;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C57@1973L2491:AlertDialog.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2126308228, i, -1, "androidx.compose.material3.AlertDialogContent.<anonymous> (AlertDialog.kt:56)");
            }
            Modifier modifier$iv = PaddingKt.padding(Modifier.Companion, AlertDialogKt.DialogPadding);
            Function2<Composer, Integer, Unit> function2 = this.$icon;
            Function2<Composer, Integer, Unit> function22 = this.$title;
            Function2<Composer, Integer, Unit> function23 = this.$text;
            long j = this.$iconContentColor;
            int i2 = this.$$dirty;
            long j2 = this.$titleContentColor;
            long j3 = this.$textContentColor;
            long j4 = this.$buttonContentColor;
            Function2<Composer, Integer, Unit> function24 = this.$buttons;
            composer.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Function2<Composer, Integer, Unit> function25 = function24;
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            long j5 = j4;
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            Arrangement.Vertical vertical = verticalArrangement$iv;
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Alignment.Horizontal horizontal = horizontalAlignment$iv;
            String str = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
            long j6 = j3;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            Function2<Composer, Integer, Unit> function26 = function23;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            int i3 = $changed$iv$iv;
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
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2865constructorimpl($composer);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer.enableReusing();
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            function32.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            int i4 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
            Composer $composer$iv2 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope $this$invoke_u24lambda_u244 = ColumnScopeInstance.INSTANCE;
            Density density = density$iv$iv;
            int i5 = $changed$iv$iv$iv;
            int i6 = ((6 >> 6) & 112) | 6;
            Composer $composer2 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 76440726, "C108@4081L373:AlertDialog.kt#uh7d8r");
            $composer2.startReplaceableGroup(76440732);
            ComposerKt.sourceInformation($composer2, "*61@2088L339");
            if (function2 != null) {
                Function2<Composer, Integer, Unit> function27 = function2;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3243boximpl(j))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 934657765, true, new AlertDialogKt$AlertDialogContent$1$1$1$1($this$invoke_u24lambda_u244, function2, i2)), $composer2, 56);
            }
            $composer2.endReplaceableGroup();
            $composer2.startReplaceableGroup(76441127);
            ComposerKt.sourceInformation($composer2, "*72@2483L895");
            if (function22 != null) {
                Function2<Composer, Integer, Unit> function28 = function22;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3243boximpl(j2))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 1845262876, true, new AlertDialogKt$AlertDialogContent$1$1$2$1($this$invoke_u24lambda_u244, function2, function22, i2)), $composer2, 56);
            }
            $composer2.endReplaceableGroup();
            $composer2.startReplaceableGroup(76442077);
            ComposerKt.sourceInformation($composer2, "*93@3433L621");
            if (function26 != null) {
                Function2<Composer, Integer, Unit> function29 = function26;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3243boximpl(j6))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 613970333, true, new AlertDialogKt$AlertDialogContent$1$1$3$1($this$invoke_u24lambda_u244, function26, i2)), $composer2, 56);
            }
            $composer2.endReplaceableGroup();
            Modifier modifier$iv2 = $this$invoke_u24lambda_u244.align(Modifier.Companion, Alignment.Companion.getEnd());
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, str);
            ColumnScope columnScope = $this$invoke_u24lambda_u244;
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
            Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2865constructorimpl($composer2);
            Function0<ComposeUiNode> function02 = constructor2;
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i7 = ($changed$iv$iv$iv2 >> 9) & 14;
            Composer $composer$iv3 = $composer2;
            Density density2 = density$iv$iv2;
            LayoutDirection layoutDirection = layoutDirection$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            int i9 = $changed$iv$iv$iv2;
            Composer $composer3 = $composer$iv3;
            ComposerKt.sourceInformationMarkerStart($composer3, 24965084, "C109@4145L295:AlertDialog.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3243boximpl(j5))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer3, -433542216, true, new AlertDialogKt$AlertDialogContent$1$1$4$1(function25, i2)), $composer3, 56);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
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

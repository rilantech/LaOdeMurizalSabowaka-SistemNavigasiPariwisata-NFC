package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatingActionButton.kt */
final class FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1(Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(3);
        this.$text = function2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((AnimatedVisibilityScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C377@18878L154:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(176242764, $changed, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:376)");
        } else {
            int i = $changed;
        }
        Modifier modifier$iv = SemanticsModifierKt.clearAndSetSemantics(Modifier.Companion, AnonymousClass1.INSTANCE);
        Function2<Composer, Integer, Unit> function2 = this.$text;
        int i2 = this.$$dirty;
        composer.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(composer, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
        int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
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
        int i3 = ($changed$iv$iv$iv >> 9) & 14;
        Composer $composer$iv = $composer;
        ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
        ComposerKt.sourceInformationMarkerStart($composer$iv, -326682283, "C80@4021L9:Row.kt#2w3rfo");
        RowScope rowScope = RowScopeInstance.INSTANCE;
        int i4 = ((0 >> 6) & 112) | 6;
        int i5 = $changed$iv$iv$iv;
        Composer $composer2 = $composer$iv;
        ComposerKt.sourceInformationMarkerStart($composer2, 180818004, "C378@18938L49,379@19008L6:FloatingActionButton.kt#uh7d8r");
        SpacerKt.Spacer(SizeKt.m2327width3ABfNKs(Modifier.Companion, FloatingActionButtonKt.ExtendedFabEndIconPadding), $composer2, 6);
        function2.invoke($composer2, Integer.valueOf(i2 & 14));
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ComposerKt.sourceInformationMarkerEnd($composer$iv);
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}

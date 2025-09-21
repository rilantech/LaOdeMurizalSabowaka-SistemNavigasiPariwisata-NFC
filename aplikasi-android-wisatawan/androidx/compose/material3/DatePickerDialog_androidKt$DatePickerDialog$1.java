package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DialogTokens;
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
import androidx.compose.ui.graphics.Shape;
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
/* compiled from: DatePickerDialog.android.kt */
final class DatePickerDialog_androidKt$DatePickerDialog$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $confirmButton;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissButton;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerDialog_androidKt$DatePickerDialog$1(Shape shape, DatePickerColors datePickerColors, float f, int i, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.$shape = shape;
        this.$colors = datePickerColors;
        this.$tonalElevation = f;
        this.$$dirty = i;
        this.$content = function3;
        this.$dismissButton = function2;
        this.$confirmButton = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C80@3909L1441:DatePickerDialog.android.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-476003174, i, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:79)");
            }
            Modifier r1 = SizeKt.m600heightInVpY3zN4$default(SizeKt.m609requiredWidth3ABfNKs(Modifier.Companion, DatePickerModalTokens.INSTANCE.m2385getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m2384getContainerHeightD9Ej5fM(), 1, (Object) null);
            Shape shape = this.$shape;
            long r3 = this.$colors.m1699getContainerColor0d7_KjU$material3_release();
            float f = this.$tonalElevation;
            final Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$content;
            final int i2 = this.$$dirty;
            final Function2<Composer, Integer, Unit> function2 = this.$dismissButton;
            final Function2<Composer, Integer, Unit> function22 = this.$confirmButton;
            int i3 = this.$$dirty;
            SurfaceKt.m2062SurfaceT9BRK9s(r1, shape, r3, 0, f, 0.0f, (BorderStroke) null, ComposableLambdaKt.composableLambda(composer, 1763752415, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    Composer composer = $composer;
                    int i = $changed;
                    ComposerKt.sourceInformation(composer, "C88@4230L1110:DatePickerDialog.android.kt#uh7d8r");
                    if ((i & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1763752415, i, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:87)");
                        }
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
                        Function3<ColumnScope, Composer, Integer, Unit> function3 = function3;
                        int i2 = i2;
                        Function2<Composer, Integer, Unit> function2 = function2;
                        Function2<Composer, Integer, Unit> function22 = function22;
                        composer.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.Companion;
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                        int $changed$iv$iv = (48 << 3) & 112;
                        composer.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        Arrangement.Vertical vertical = verticalArrangement$iv;
                        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Density density$iv$iv = (Density) consume;
                        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                        Alignment.Horizontal horizontal = horizontalAlignment$iv;
                        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
                        Modifier modifier = modifier$iv;
                        int i3 = $changed$iv$iv;
                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = materializerOf;
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
                        Density density = density$iv$iv;
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
                        function33.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                        composer.startReplaceableGroup(2058660585);
                        int i4 = ($changed$iv$iv$iv >> 9) & 14;
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = function33;
                        Composer $composer$iv = $composer;
                        ComposerKt.sourceInformationMarkerStart($composer$iv, 276693704, "C79@4027L9:Column.kt#2w3rfo");
                        int $changed2 = ((48 >> 6) & 112) | 6;
                        ColumnScope $this$invoke_u24lambda_u241 = ColumnScopeInstance.INSTANCE;
                        LayoutDirection layoutDirection = layoutDirection$iv$iv;
                        ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                        Composer $composer2 = $composer$iv;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1146374379, "C89@4303L9,91@4356L970:DatePickerDialog.android.kt#uh7d8r");
                        function3.invoke($this$invoke_u24lambda_u241, $composer2, Integer.valueOf(($changed2 & 14) | ((i2 >> 21) & 112)));
                        Modifier modifier$iv2 = PaddingKt.padding($this$invoke_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getEnd()), DatePickerDialog_androidKt.DialogButtonsPadding);
                        $composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                        ColumnScope columnScope = $this$invoke_u24lambda_u241;
                        int i5 = $changed$iv$iv$iv;
                        MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        $composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        Alignment alignment = contentAlignment$iv;
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume4 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        Density density$iv$iv2 = (Density) consume4;
                        int i6 = $changed2;
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume5 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                        MeasurePolicy measurePolicy = measurePolicy$iv;
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume6 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
                        int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                        Modifier modifier2 = modifier$iv2;
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
                        Composer $composer$iv2 = $composer2;
                        Density density2 = density$iv$iv2;
                        int i7 = ($changed$iv$iv$iv2 >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i8 = ((0 >> 6) & 112) | 6;
                        ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv2;
                        Composer $composer3 = $composer$iv2;
                        ComposerKt.sourceInformationMarkerStart($composer3, -552861189, "C97@4653L9,96@4542L766:DatePickerDialog.android.kt#uh7d8r");
                        LayoutDirection layoutDirection2 = layoutDirection$iv$iv2;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3243boximpl(ColorSchemeKt.toColor(DialogTokens.INSTANCE.getActionLabelTextColor(), $composer3, 6)))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer3, -926980325, true, new DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1(function2, i2, function22)), $composer3, 56);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        $composer2.endReplaceableGroup();
                        $composer2.endNode();
                        $composer2.endReplaceableGroup();
                        $composer2.endReplaceableGroup();
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
            }), $composer, ((i3 >> 9) & 112) | 12582918 | ((i3 >> 3) & 57344), 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.TimePickerTokens;
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
/* compiled from: TimePicker.kt */
final class TimePickerKt$ClockDisplayNumbers$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$ClockDisplayNumbers$1(TimePickerState timePickerState, TimePickerColors timePickerColors, int i) {
        super(2);
        this.$state = timePickerState;
        this.$colors = timePickerColors;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C845@35326L905:TimePicker.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-477913269, i, -1, "androidx.compose.material3.ClockDisplayNumbers.<anonymous> (TimePicker.kt:844)");
            }
            TimePickerState timePickerState = this.$state;
            TimePickerColors timePickerColors = this.$colors;
            int i2 = this.$$dirty;
            composer.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
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
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2865constructorimpl($composer);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            int i3 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            int i5 = $changed$iv$iv$iv;
            Composer $composer2 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 94464031, "C846@35344L338,856@35695L181,862@35889L332:TimePicker.kt#uh7d8r");
            Composer $composer$iv2 = $composer$iv;
            Modifier r6 = SizeKt.m614sizeVpY3zN4(Modifier.Companion, TimePickerTokens.INSTANCE.m2774getTimeSelectorContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m2773getTimeSelectorContainerHeightD9Ej5fM());
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            int hourForDisplay$material3_release = timePickerState.getHourForDisplay$material3_release();
            Density density = density$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            TimePickerColors timePickerColors2 = timePickerColors;
            Alignment.Vertical vertical = verticalAlignment$iv;
            Composer composer2 = $composer2;
            Arrangement.Horizontal horizontal = horizontalArrangement$iv;
            int i6 = ((i2 << 9) & 57344) | ((i2 << 6) & 896) | 3078;
            TimePickerKt.m2165TimeSelectoruXwN82Y(r6, hourForDisplay$material3_release, timePickerState, Selection.Companion.m1960getHourJiIwxys(), timePickerColors2, composer2, i6);
            TimePickerKt.DisplaySeparator(SizeKt.m614sizeVpY3zN4(Modifier.Companion, TimePickerKt.DisplaySeparatorWidth, TimePickerTokens.INSTANCE.m2770getPeriodSelectorVerticalContainerHeightD9Ej5fM()), $composer2, 6);
            TimePickerKt.m2165TimeSelectoruXwN82Y(SizeKt.m614sizeVpY3zN4(Modifier.Companion, TimePickerTokens.INSTANCE.m2774getTimeSelectorContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m2773getTimeSelectorContainerHeightD9Ej5fM()), timePickerState.getMinute(), timePickerState, Selection.Companion.m1961getMinuteJiIwxys(), timePickerColors2, composer2, i6);
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

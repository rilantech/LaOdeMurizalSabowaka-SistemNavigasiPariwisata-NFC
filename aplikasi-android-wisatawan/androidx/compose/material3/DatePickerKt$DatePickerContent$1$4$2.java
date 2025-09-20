package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePickerContent$1$4$2 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ LazyListState $monthsListState;
    final /* synthetic */ StateData $stateData;
    final /* synthetic */ MutableState<Boolean> $yearPickerVisible$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePickerContent$1$4$2(DatePickerColors datePickerColors, StateData stateData, int i, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, LazyListState lazyListState) {
        super(3);
        this.$colors = datePickerColors;
        this.$stateData = stateData;
        this.$$dirty = i;
        this.$coroutineScope = coroutineScope;
        this.$yearPickerVisible$delegate = mutableState;
        this.$monthsListState = lazyListState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((AnimatedVisibilityScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Object value$iv$iv;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C1191@49681L48,1192@49783L30,1192@49746L1748:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(760161496, $changed, -1, "androidx.compose.material3.DatePickerContent.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1186)");
        } else {
            int i = $changed;
        }
        String yearsPaneTitle = Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m2019getDatePickerYearPickerPaneTitleadMyvUU(), composer, 6);
        Modifier modifier = Modifier.Companion;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) yearsPaneTitle);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function1) new DatePickerKt$DatePickerContent$1$4$2$1$1(yearsPaneTitle);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Modifier modifier$iv = SemanticsModifierKt.semantics$default(modifier, false, (Function1) value$iv$iv, 1, (Object) null);
        DatePickerColors datePickerColors = this.$colors;
        StateData stateData = this.$stateData;
        int i2 = this.$$dirty;
        CoroutineScope coroutineScope = this.$coroutineScope;
        MutableState<Boolean> mutableState = this.$yearPickerVisible$delegate;
        LazyListState lazyListState = this.$monthsListState;
        composer.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        String str = yearsPaneTitle;
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
        Modifier modifier2 = modifier$iv;
        int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
        Alignment.Horizontal horizontalAlignment$iv2 = horizontalAlignment$iv;
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
        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        Composer $composer$iv = $composer;
        LayoutDirection layoutDirection = layoutDirection$iv$iv;
        ComposerKt.sourceInformationMarkerStart($composer$iv, 276693704, "C79@4027L9:Column.kt#2w3rfo");
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        int i3 = ((0 >> 6) & 112) | 6;
        ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
        Composer $composer2 = $composer$iv;
        ComposerKt.sourceInformationMarkerStart($composer2, -1036337673, "C1193@49837L1609,1220@51467L9:DatePicker.kt#uh7d8r");
        int i4 = ($changed$iv$iv$iv >> 9) & 14;
        Density density = density$iv$iv;
        int i5 = $changed$iv$iv$iv;
        Modifier r10 = PaddingKt.m540paddingVpY3zN4$default(SizeKt.m601requiredHeight3ABfNKs(Modifier.Companion, Dp.m5844constructorimpl(Dp.m5844constructorimpl(((float) 7) * DatePickerKt.getRecommendedSizeForAccessibility()) - DividerDefaults.INSTANCE.m1740getThicknessD9Ej5fM())), DatePickerKt.getDatePickerHorizontalPadding(), 0.0f, 2, (Object) null);
        Alignment.Horizontal horizontal = horizontalAlignment$iv2;
        Arrangement.Vertical vertical = verticalArrangement$iv;
        DatePickerKt.YearPicker(r10, new DatePickerKt$DatePickerContent$1$4$2$2$1(coroutineScope, mutableState, stateData, lazyListState), datePickerColors, stateData, $composer2, ((i2 >> 3) & 896) | 6 | ((i2 << 9) & 7168));
        DividerKt.m1741Divider9IZ8Weo((Modifier) null, 0.0f, 0, $composer2, 0, 7);
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

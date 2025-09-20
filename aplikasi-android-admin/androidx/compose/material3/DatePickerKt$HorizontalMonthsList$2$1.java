package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$HorizontalMonthsList$2$1 extends Lambda implements Function1<LazyListScope, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ Function1<Long, Boolean> $dateValidator;
    final /* synthetic */ CalendarMonth $firstMonth;
    final /* synthetic */ Function1<Long, Unit> $onDateSelected;
    final /* synthetic */ StateData $stateData;
    final /* synthetic */ CalendarDate $today;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$HorizontalMonthsList$2$1(StateData stateData, CalendarMonth calendarMonth, Function1<? super Long, Unit> function1, CalendarDate calendarDate, Function1<? super Long, Boolean> function12, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, int i) {
        super(1);
        this.$stateData = stateData;
        this.$firstMonth = calendarMonth;
        this.$onDateSelected = function1;
        this.$today = calendarDate;
        this.$dateValidator = function12;
        this.$dateFormatter = datePickerFormatter;
        this.$colors = datePickerColors;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((LazyListScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(LazyListScope $this$LazyRow) {
        Intrinsics.checkNotNullParameter($this$LazyRow, "$this$LazyRow");
        int totalMonthsInRange = this.$stateData.getTotalMonthsInRange();
        final StateData stateData = this.$stateData;
        final CalendarMonth calendarMonth = this.$firstMonth;
        final Function1<Long, Unit> function1 = this.$onDateSelected;
        final CalendarDate calendarDate = this.$today;
        final Function1<Long, Boolean> function12 = this.$dateValidator;
        final DatePickerFormatter datePickerFormatter = this.$dateFormatter;
        final DatePickerColors datePickerColors = this.$colors;
        final int i = this.$$dirty;
        LazyListScope.items$default($this$LazyRow, totalMonthsInRange, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-65053693, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                LazyItemScope lazyItemScope = $this$items;
                int i = it;
                Composer composer = $composer;
                int i2 = $changed;
                Intrinsics.checkNotNullParameter(lazyItemScope, "$this$items");
                ComposerKt.sourceInformation(composer, "C1306@54250L487:DatePicker.kt#uh7d8r");
                int $dirty = $changed;
                if ((i2 & 14) == 0) {
                    $dirty |= composer.changed((Object) lazyItemScope) ? 4 : 2;
                }
                if ((i2 & 112) == 0) {
                    $dirty |= composer.changed(i) ? 32 : 16;
                }
                if (($dirty & 731) != 146 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-65053693, i2, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1300)");
                    }
                    CalendarMonth month = stateData.getCalendarModel().plusMonths(calendarMonth, i);
                    Modifier modifier$iv = LazyItemScope.fillParentMaxWidth$default(lazyItemScope, Modifier.Companion, 0.0f, 1, (Object) null);
                    Function1<Long, Unit> function1 = function1;
                    CalendarDate calendarDate = calendarDate;
                    StateData stateData = stateData;
                    Function1<Long, Boolean> function12 = function12;
                    DatePickerFormatter datePickerFormatter = datePickerFormatter;
                    DatePickerColors datePickerColors = datePickerColors;
                    int i3 = i;
                    composer.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    composer.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Density density$iv$iv = (Density) consume;
                    int i4 = $dirty;
                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                    Alignment contentAlignment$iv2 = contentAlignment$iv;
                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
                    Modifier modifier = modifier$iv;
                    int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
                    CalendarMonth month2 = month;
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
                    materializerOf.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                    composer.startReplaceableGroup(2058660585);
                    int i5 = ($changed$iv$iv$iv >> 9) & 14;
                    Composer $composer$iv = $composer;
                    Density density = density$iv$iv;
                    MeasurePolicy measurePolicy = measurePolicy$iv;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i6 = ((0 >> 6) & 112) | 6;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
                    Composer $composer2 = $composer$iv;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1656167412, "C1309@54344L379:DatePicker.kt#uh7d8r");
                    int i7 = i3 << 3;
                    LayoutDirection layoutDirection = layoutDirection$iv$iv;
                    int i8 = i3 << 6;
                    int i9 = (i7 & 458752) | (i7 & 112) | 24576 | (i8 & 7168) | (3670016 & (i3 << 9)) | (29360128 & i8);
                    Composer $composer3 = $composer2;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
                    Alignment alignment = contentAlignment$iv2;
                    DatePickerKt.Month(month2, function1, calendarDate, stateData, false, function12, datePickerFormatter, datePickerColors, $composer3, i9);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
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
                int i10 = $dirty;
            }
        }), 6, (Object) null);
    }
}

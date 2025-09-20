package androidx.compose.material3;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerKt$VerticalMonthsList$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ Function1<Long, Boolean> $dateValidator;
    final /* synthetic */ CalendarMonth $firstMonth;
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function1<Long, Unit> $onDateSelected;
    final /* synthetic */ StateData $stateData;
    final /* synthetic */ CalendarDate $today;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$VerticalMonthsList$1(LazyListState lazyListState, int i, StateData stateData, CalendarMonth calendarMonth, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, Function1<? super Long, Unit> function1, CalendarDate calendarDate, Function1<? super Long, Boolean> function12) {
        super(2);
        this.$lazyListState = lazyListState;
        this.$$dirty = i;
        this.$stateData = stateData;
        this.$firstMonth = calendarMonth;
        this.$dateFormatter = datePickerFormatter;
        this.$colors = datePickerColors;
        this.$onDateSelected = function1;
        this.$today = calendarDate;
        this.$dateValidator = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv$iv$iv;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C531@21781L24,532@21847L59,533@21944L55,534@22008L2192:DateRangePicker.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(56792252, i, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous> (DateRangePicker.kt:530)");
            }
            composer.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
            Composer composer$iv = $composer;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv$iv = $composer;
            Object it$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
            if (it$iv$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer$iv));
                $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
            } else {
                value$iv$iv$iv = it$iv$iv$iv;
            }
            $composer.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv).getCoroutineScope();
            $composer.endReplaceableGroup();
            String scrollToPreviousMonthLabel = Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3735getDateRangePickerScrollToShowPreviousMonthadMyvUU(), composer, 6);
            String scrollToNextMonthLabel = Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3734getDateRangePickerScrollToShowNextMonthadMyvUU(), composer, 6);
            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.Companion, false, AnonymousClass1.INSTANCE, 1, (Object) null);
            LazyListState lazyListState = this.$lazyListState;
            StateData stateData = this.$stateData;
            CalendarMonth calendarMonth = this.$firstMonth;
            DatePickerFormatter datePickerFormatter = this.$dateFormatter;
            DatePickerColors datePickerColors = this.$colors;
            Function1<Long, Unit> function1 = this.$onDateSelected;
            CalendarDate calendarDate = this.$today;
            Function1<Long, Boolean> function12 = this.$dateValidator;
            final StateData stateData2 = stateData;
            final CalendarMonth calendarMonth2 = calendarMonth;
            final DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
            final DatePickerColors datePickerColors2 = datePickerColors;
            final Function1<Long, Unit> function13 = function1;
            final CalendarDate calendarDate2 = calendarDate;
            final Function1<Long, Boolean> function14 = function12;
            final int i2 = this.$$dirty;
            final LazyListState lazyListState2 = this.$lazyListState;
            final String str = scrollToPreviousMonthLabel;
            final String str2 = scrollToNextMonthLabel;
            LazyDslKt.LazyColumn(semantics$default, lazyListState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, new Function1<LazyListScope, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((LazyListScope) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyListScope $this$LazyColumn) {
                    Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
                    int totalMonthsInRange = stateData2.getTotalMonthsInRange();
                    final StateData stateData = stateData2;
                    final CalendarMonth calendarMonth = calendarMonth2;
                    final DatePickerFormatter datePickerFormatter = datePickerFormatter2;
                    final DatePickerColors datePickerColors = datePickerColors2;
                    final Function1<Long, Unit> function1 = function13;
                    CalendarDate calendarDate = calendarDate2;
                    Function1<Long, Boolean> function12 = function14;
                    int i = i2;
                    LazyListState lazyListState = lazyListState2;
                    CoroutineScope coroutineScope = coroutineScope;
                    String str = str;
                    final String str2 = str2;
                    final CalendarDate calendarDate2 = calendarDate;
                    final Function1<Long, Boolean> function13 = function12;
                    final int i2 = i;
                    final LazyListState lazyListState2 = lazyListState;
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    final String str3 = str;
                    LazyListScope.items$default($this$LazyColumn, totalMonthsInRange, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1246706073, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                            invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                            String str;
                            LazyItemScope lazyItemScope = $this$items;
                            int i = it;
                            Composer composer = $composer;
                            int i2 = $changed;
                            Intrinsics.checkNotNullParameter(lazyItemScope, "$this$items");
                            ComposerKt.sourceInformation(composer, "C548@22622L1554:DateRangePicker.kt#uh7d8r");
                            int $dirty = $changed;
                            if ((i2 & 14) == 0) {
                                $dirty |= composer.changed((Object) lazyItemScope) ? 4 : 2;
                            }
                            if ((i2 & 112) == 0) {
                                $dirty |= composer.changed(i) ? 32 : 16;
                            }
                            if (($dirty & 731) != 146 || !$composer.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1246706073, i2, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous>.<anonymous>.<anonymous> (DateRangePicker.kt:542)");
                                }
                                CalendarMonth month = stateData.getCalendarModel().plusMonths(calendarMonth, i);
                                Modifier fillParentMaxWidth$default = LazyItemScope.fillParentMaxWidth$default(lazyItemScope, Modifier.Companion, 0.0f, 1, (Object) null);
                                DatePickerFormatter datePickerFormatter = datePickerFormatter;
                                StateData stateData = stateData;
                                DatePickerColors datePickerColors = datePickerColors;
                                Function1<Long, Unit> function1 = function1;
                                CalendarDate calendarDate = calendarDate2;
                                Function1<Long, Boolean> function12 = function13;
                                int i3 = i2;
                                LazyListState lazyListState = lazyListState2;
                                CoroutineScope coroutineScope = coroutineScope2;
                                String str2 = str3;
                                String str3 = str2;
                                Modifier modifier$iv = fillParentMaxWidth$default;
                                composer.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                                int i4 = $dirty;
                                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                Alignment.Horizontal horizontal = horizontalAlignment$iv;
                                composer.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                Arrangement.Vertical verticalArrangement$iv2 = verticalArrangement$iv;
                                Function1<Long, Boolean> function13 = function12;
                                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                Density density$iv$iv = (Density) consume;
                                CalendarDate calendarDate2 = calendarDate;
                                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                                Function1<Long, Unit> function14 = function1;
                                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
                                int i5 = i3;
                                int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
                                Function0<ComposeUiNode> function0 = constructor;
                                if (!($composer.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer.startReusableNode();
                                if ($composer.getInserting()) {
                                    composer.createNode(function0);
                                } else {
                                    $composer.useNode();
                                }
                                $composer.disableReusing();
                                Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m4575constructorimpl($composer);
                                Function0<ComposeUiNode> function02 = function0;
                                Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
                                Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
                                Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
                                $composer.enableReusing();
                                materializerOf.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                composer.startReplaceableGroup(2058660585);
                                int i6 = ($changed$iv$iv$iv >> 9) & 14;
                                Composer $composer$iv = $composer;
                                Density density = density$iv$iv;
                                ComposerKt.sourceInformationMarkerStart($composer$iv, 276693704, "C79@4027L9:Column.kt#2w3rfo");
                                int i7 = ((0 >> 6) & 112) | 6;
                                Composer $composer2 = $composer$iv;
                                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer2, 1680467237, "C555@22915L15,551@22731L992,570@23744L414:DateRangePicker.kt#uh7d8r");
                                MeasurePolicy measurePolicy = measurePolicy$iv;
                                String formatMonthYear$material3_release = datePickerFormatter.formatMonthYear$material3_release(month, stateData.getCalendarModel(), CalendarModel_androidKt.defaultLocale($composer2, 0));
                                if (formatMonthYear$material3_release == null) {
                                    str = "-";
                                } else {
                                    str = formatMonthYear$material3_release;
                                }
                                TextKt.m3858Text4IGK_g(str, SemanticsModifierKt.semantics$default(ClickableKt.m1910clickableXHw0xAI$default(PaddingKt.padding(Modifier.Companion, DateRangePickerKt.getCalendarMonthSubheadPadding()), false, (String) null, (Role) null, DateRangePickerKt$VerticalMonthsList$1$2$1$1$1.INSTANCE, 7, (Object) null), false, new DateRangePickerKt$VerticalMonthsList$1$2$1$1$2(lazyListState, coroutineScope, str2, str3), 1, (Object) null), datePickerColors.m3412getSubheadContentColor0d7_KjU$material3_release(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 0, 131064);
                                int i8 = i5 << 3;
                                int i9 = i5 << 6;
                                int i10 = (i8 & 458752) | (i8 & 112) | 24576 | (i9 & 7168) | (3670016 & (i5 << 9)) | (29360128 & i9);
                                Composer $composer3 = $composer2;
                                Arrangement.Vertical vertical = verticalArrangement$iv2;
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
                                Function0<ComposeUiNode> function03 = function02;
                                LayoutDirection layoutDirection = layoutDirection$iv$iv;
                                ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                                DatePickerKt.Month(month, function14, calendarDate2, stateData, true, function13, datePickerFormatter, datePickerColors, $composer3, i10);
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
                            int i11 = $dirty;
                        }
                    }), 6, (Object) null);
                }
            }, $composer, (this.$$dirty >> 3) & 112, 252);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001eJÓ\u0001\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\"2\b\b\u0002\u0010'\u001a\u00020\"2\b\b\u0002\u0010(\u001a\u00020\"2\b\b\u0002\u0010)\u001a\u00020\"2\b\b\u0002\u0010*\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020\"2\b\b\u0002\u0010,\u001a\u00020\"2\b\b\u0002\u0010-\u001a\u00020\"2\b\b\u0002\u0010.\u001a\u00020\"2\b\b\u0002\u0010/\u001a\u00020\"2\b\b\u0002\u00100\u001a\u00020\"2\b\b\u0002\u00101\u001a\u00020\"2\b\b\u0002\u00102\u001a\u00020\"2\b\b\u0002\u00103\u001a\u00020\"2\b\b\u0002\u00104\u001a\u00020\"H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J'\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<H\u0001¢\u0006\u0004\b>\u0010?R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, d2 = {"Landroidx/compose/material3/DatePickerDefaults;", "", "()V", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "YearAbbrMonthDaySkeleton", "", "YearMonthSkeleton", "YearMonthWeekdayDaySkeleton", "YearRange", "Lkotlin/ranges/IntRange;", "getYearRange", "()Lkotlin/ranges/IntRange;", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "DatePickerHeadline", "", "state", "Landroidx/compose/material3/DatePickerState;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DatePickerTitle", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "colors", "Landroidx/compose/material3/DatePickerColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "yearContentColor", "currentYearContentColor", "selectedYearContentColor", "selectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContentColor", "dayInSelectionRangeContainerColor", "colors-1m2Cg-Y", "(JJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/DatePickerColors;", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "rememberSnapFlingBehavior$material3_release", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
public final class DatePickerDefaults {
    public static final int $stable = 0;
    public static final DatePickerDefaults INSTANCE = new DatePickerDefaults();
    private static final float TonalElevation = DatePickerModalTokens.INSTANCE.m2383getContainerElevationD9Ej5fM();
    public static final String YearAbbrMonthDaySkeleton = "yMMMd";
    public static final String YearMonthSkeleton = "yMMMM";
    public static final String YearMonthWeekdayDaySkeleton = "yMMMMEEEEd";
    private static final IntRange YearRange = new IntRange(1900, 2100);

    private DatePickerDefaults() {
    }

    /* renamed from: colors-1m2Cg-Y  reason: not valid java name */
    public final DatePickerColors m1706colors1m2CgY(long containerColor, long titleContentColor, long headlineContentColor, long weekdayContentColor, long subheadContentColor, long yearContentColor, long currentYearContentColor, long selectedYearContentColor, long selectedYearContainerColor, long dayContentColor, long disabledDayContentColor, long selectedDayContentColor, long disabledSelectedDayContentColor, long selectedDayContainerColor, long disabledSelectedDayContainerColor, long todayContentColor, long todayDateBorderColor, long dayInSelectionRangeContentColor, long dayInSelectionRangeContainerColor, Composer $composer, int $changed, int $changed1, int i) {
        long titleContentColor2;
        long headlineContentColor2;
        long weekdayContentColor2;
        long subheadContentColor2;
        long yearContentColor2;
        long currentYearContentColor2;
        long selectedYearContentColor2;
        long selectedYearContainerColor2;
        long dayContentColor2;
        long disabledDayContentColor2;
        long selectedDayContentColor2;
        long disabledSelectedDayContentColor2;
        long selectedDayContainerColor2;
        long disabledSelectedDayContainerColor2;
        long todayContentColor2;
        long todayDateBorderColor2;
        long dayInSelectionRangeContentColor2;
        long dayInSelectionRangeContainerColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(543433842);
        ComposerKt.sourceInformation(composer, "C(colors)P(0:c#ui.graphics.Color,14:c#ui.graphics.Color,8:c#ui.graphics.Color,17:c#ui.graphics.Color,13:c#ui.graphics.Color,18:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,11:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,10:c#ui.graphics.Color,7:c#ui.graphics.Color,9:c#ui.graphics.Color,6:c#ui.graphics.Color,15:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.Color)359@16109L9,360@16203L9,361@16294L9,362@16387L9,364@16501L9,366@16618L9,367@16716L9,369@16839L9,371@16964L9,372@17059L9,375@17301L9,379@17573L9,382@17826L9,384@17940L9,386@18069L9,388@18209L9:DatePicker.kt#uh7d8r");
        long containerColor2 = (i2 & 1) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getContainerColor(), composer, 6) : containerColor;
        if ((i2 & 2) != 0) {
            titleContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getHeaderSupportingTextColor(), composer, 6);
        } else {
            titleContentColor2 = titleContentColor;
        }
        if ((i2 & 4) != 0) {
            headlineContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getHeaderHeadlineColor(), composer, 6);
        } else {
            headlineContentColor2 = headlineContentColor;
        }
        if ((i2 & 8) != 0) {
            weekdayContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextColor(), composer, 6);
        } else {
            weekdayContentColor2 = weekdayContentColor;
        }
        if ((i2 & 16) != 0) {
            subheadContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadColor(), composer, 6);
        } else {
            subheadContentColor2 = subheadContentColor;
        }
        if ((i2 & 32) != 0) {
            yearContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor(), composer, 6);
        } else {
            yearContentColor2 = yearContentColor;
        }
        if ((i2 & 64) != 0) {
            currentYearContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor(), composer, 6);
        } else {
            currentYearContentColor2 = currentYearContentColor;
        }
        if ((i2 & 128) != 0) {
            selectedYearContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor(), composer, 6);
        } else {
            selectedYearContentColor2 = selectedYearContentColor;
        }
        if ((i2 & 256) != 0) {
            selectedYearContainerColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor(), composer, 6);
        } else {
            selectedYearContainerColor2 = selectedYearContainerColor;
        }
        if ((i2 & 512) != 0) {
            dayContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor(), composer, 6);
        } else {
            dayContentColor2 = dayContentColor;
        }
        if ((i2 & 1024) != 0) {
            disabledDayContentColor2 = Color.m3252copywmQWz5c$default(dayContentColor2, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledDayContentColor2 = disabledDayContentColor;
        }
        if ((i2 & 2048) != 0) {
            selectedDayContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor(), composer, 6);
        } else {
            selectedDayContentColor2 = selectedDayContentColor;
        }
        if ((i2 & 4096) != 0) {
            disabledSelectedDayContentColor2 = Color.m3252copywmQWz5c$default(selectedDayContentColor2, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledSelectedDayContentColor2 = disabledSelectedDayContentColor;
        }
        if ((i2 & 8192) != 0) {
            selectedDayContainerColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor(), composer, 6);
        } else {
            selectedDayContainerColor2 = selectedDayContainerColor;
        }
        if ((i2 & 16384) != 0) {
            disabledSelectedDayContainerColor2 = Color.m3252copywmQWz5c$default(selectedDayContainerColor2, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledSelectedDayContainerColor2 = disabledSelectedDayContainerColor;
        }
        if ((32768 & i2) != 0) {
            todayContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor(), composer, 6);
        } else {
            todayContentColor2 = todayContentColor;
        }
        if ((65536 & i2) != 0) {
            todayDateBorderColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineColor(), composer, 6);
        } else {
            todayDateBorderColor2 = todayDateBorderColor;
        }
        if ((131072 & i2) != 0) {
            dayInSelectionRangeContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getSelectionDateInRangeLabelTextColor(), composer, 6);
        } else {
            dayInSelectionRangeContentColor2 = dayInSelectionRangeContentColor;
        }
        if ((i2 & 262144) != 0) {
            dayInSelectionRangeContainerColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getRangeSelectionActiveIndicatorContainerColor(), composer, 6);
        } else {
            dayInSelectionRangeContainerColor2 = dayInSelectionRangeContainerColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(543433842, $changed, $changed1, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:358)");
        } else {
            int i3 = $changed;
            int i4 = $changed1;
        }
        DatePickerColors datePickerColors = new DatePickerColors(containerColor2, titleContentColor2, headlineContentColor2, weekdayContentColor2, subheadContentColor2, yearContentColor2, currentYearContentColor2, selectedYearContentColor2, selectedYearContainerColor2, dayContentColor2, disabledDayContentColor2, selectedDayContentColor2, disabledSelectedDayContentColor2, selectedDayContainerColor2, disabledSelectedDayContainerColor2, todayContentColor2, todayDateBorderColor2, dayInSelectionRangeContainerColor2, dayInSelectionRangeContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return datePickerColors;
    }

    public final void DatePickerTitle(DatePickerState state, Modifier modifier, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        DatePickerState datePickerState = state;
        Intrinsics.checkNotNullParameter(datePickerState, "state");
        Composer $composer2 = $composer.startRestartGroup(-1157401173);
        ComposerKt.sourceInformation($composer2, "C(DatePickerTitle)P(1):DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) datePickerState) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer2.getSkipping()) {
            Modifier modifier4 = i2 != 0 ? Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1157401173, $dirty2, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerTitle (DatePicker.kt:419)");
            }
            int r0 = state.m1715getDisplayModejFl4v0();
            if (DisplayMode.m1734equalsimpl0(r0, DisplayMode.Companion.m1739getPickerjFl4v0())) {
                $composer2.startReplaceableGroup(-2065111000);
                ComposerKt.sourceInformation($composer2, "422@19876L43,421@19847L123");
                TextKt.m2148Text4IGK_g(Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m2017getDatePickerTitleadMyvUU(), $composer2, 6), modifier4, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, $dirty2 & 112, 0, 131068);
                $composer2.endReplaceableGroup();
            } else if (DisplayMode.m1734equalsimpl0(r0, DisplayMode.Companion.m1738getInputjFl4v0())) {
                $composer2.startReplaceableGroup(-2065110842);
                ComposerKt.sourceInformation($composer2, "427@20034L42,426@20005L122");
                TextKt.m2148Text4IGK_g(Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m2004getDateInputTitleadMyvUU(), $composer2, 6), modifier4, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, $dirty2 & 112, 0, 131068);
                $composer2.endReplaceableGroup();
            } else {
                $composer2.startReplaceableGroup(-2065110710);
                $composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i3 = $dirty2;
            Composer composer = $composer2;
            return;
        }
        int i4 = $dirty2;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new DatePickerDefaults$DatePickerTitle$1(this, state, modifier3, $changed, i));
    }

    public final void DatePickerHeadline(DatePickerState state, DatePickerFormatter dateFormatter, Modifier modifier, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        String headlineText;
        Object value$iv$iv;
        DatePickerState datePickerState = state;
        DatePickerFormatter datePickerFormatter = dateFormatter;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(datePickerState, "state");
        Intrinsics.checkNotNullParameter(datePickerFormatter, "dateFormatter");
        Composer $composer3 = $composer.startRestartGroup(-1893194407);
        ComposerKt.sourceInformation($composer3, "C(DatePickerHeadline)P(2)*448@20771L15,479@22178L135,477@22089L268:DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer3.changed((Object) datePickerState) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if ((i2 & 112) == 0) {
            $dirty |= $composer3.changed((Object) datePickerFormatter) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if ((i2 & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed((Object) modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer3.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1893194407, i2, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:442)");
            }
            StateData $this$DatePickerHeadline_u24lambda_u241 = state.getStateData$material3_release();
            Locale defaultLocale = CalendarModel_androidKt.defaultLocale($composer3, 0);
            String formattedDate = DatePickerFormatter.formatDate$material3_release$default(dateFormatter, $this$DatePickerHeadline_u24lambda_u241.getSelectedStartDate().getValue(), $this$DatePickerHeadline_u24lambda_u241.getCalendarModel(), defaultLocale, false, 8, (Object) null);
            String verboseDateDescription = datePickerFormatter.formatDate$material3_release($this$DatePickerHeadline_u24lambda_u241.getSelectedStartDate().getValue(), $this$DatePickerHeadline_u24lambda_u241.getCalendarModel(), defaultLocale, true);
            $composer3.startReplaceableGroup(729783869);
            String str = "";
            ComposerKt.sourceInformation($composer3, str);
            if (verboseDateDescription == null) {
                int r1 = $this$DatePickerHeadline_u24lambda_u241.getDisplayMode().getValue().m1737unboximpl();
                if (DisplayMode.m1734equalsimpl0(r1, DisplayMode.Companion.m1739getPickerjFl4v0())) {
                    $composer3.startReplaceableGroup(933108990);
                    ComposerKt.sourceInformation($composer3, "460@21322L51");
                    verboseDateDescription = Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m2008getDatePickerNoSelectionDescriptionadMyvUU(), $composer3, 6);
                    $composer3.endReplaceableGroup();
                } else if (DisplayMode.m1734equalsimpl0(r1, DisplayMode.Companion.m1738getInputjFl4v0())) {
                    $composer3.startReplaceableGroup(933109079);
                    ComposerKt.sourceInformation($composer3, "461@21411L46");
                    verboseDateDescription = Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m2003getDateInputNoInputDescriptionadMyvUU(), $composer3, 6);
                    $composer3.endReplaceableGroup();
                } else {
                    $composer3.startReplaceableGroup(-1138387422);
                    $composer3.endReplaceableGroup();
                    verboseDateDescription = str;
                }
            }
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(729784366);
            ComposerKt.sourceInformation($composer3, str);
            if (formattedDate == null) {
                int r5 = $this$DatePickerHeadline_u24lambda_u241.getDisplayMode().getValue().m1737unboximpl();
                if (DisplayMode.m1734equalsimpl0(r5, DisplayMode.Companion.m1739getPickerjFl4v0())) {
                    $composer3.startReplaceableGroup(933109281);
                    ComposerKt.sourceInformation($composer3, "466@21613L37");
                    String r52 = Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m2005getDatePickerHeadlineadMyvUU(), $composer3, 6);
                    $composer3.endReplaceableGroup();
                    headlineText = r52;
                } else if (DisplayMode.m1734equalsimpl0(r5, DisplayMode.Companion.m1738getInputjFl4v0())) {
                    $composer3.startReplaceableGroup(933109356);
                    ComposerKt.sourceInformation($composer3, "467@21688L36");
                    String r53 = Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m1997getDateInputHeadlineadMyvUU(), $composer3, 6);
                    $composer3.endReplaceableGroup();
                    headlineText = r53;
                } else {
                    $composer3.startReplaceableGroup(-1138379145);
                    $composer3.endReplaceableGroup();
                    headlineText = str;
                }
            } else {
                headlineText = formattedDate;
            }
            $composer3.endReplaceableGroup();
            int r54 = $this$DatePickerHeadline_u24lambda_u241.getDisplayMode().getValue().m1737unboximpl();
            if (DisplayMode.m1734equalsimpl0(r54, DisplayMode.Companion.m1739getPickerjFl4v0())) {
                $composer3.startReplaceableGroup(933109538);
                ComposerKt.sourceInformation($composer3, "472@21870L48");
                str = Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m2006getDatePickerHeadlineDescriptionadMyvUU(), $composer3, 6);
                $composer3.endReplaceableGroup();
            } else if (DisplayMode.m1734equalsimpl0(r54, DisplayMode.Companion.m1738getInputjFl4v0())) {
                $composer3.startReplaceableGroup(933109624);
                ComposerKt.sourceInformation($composer3, "473@21956L47");
                str = Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m1998getDateInputHeadlineDescriptionadMyvUU(), $composer3, 6);
                $composer3.endReplaceableGroup();
            } else {
                $composer3.startReplaceableGroup(-1138370496);
                $composer3.endReplaceableGroup();
            }
            String headlineDescription = String.format(str, Arrays.copyOf(new Object[]{verboseDateDescription}, 1));
            Intrinsics.checkNotNullExpressionValue(headlineDescription, "format(this, *args)");
            $composer3.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer3.changed((Object) headlineDescription);
            Composer $this$cache$iv$iv = $composer3;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                String str2 = formattedDate;
                value$iv$iv = (Function1) new DatePickerDefaults$DatePickerHeadline$1$1$1(headlineDescription);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                Composer composer = $this$cache$iv$iv;
                String str3 = formattedDate;
                value$iv$iv = it$iv$iv;
            }
            $composer3.endReplaceableGroup();
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier4, false, (Function1) value$iv$iv, 1, (Object) null);
            Modifier modifier5 = modifier4;
            Locale locale = defaultLocale;
            $composer2 = $composer3;
            int i4 = $dirty2;
            TextKt.m2148Text4IGK_g(headlineText, semantics$default, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 3072, 122876);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            $composer2 = $composer3;
            int i5 = $dirty2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerDefaults$DatePickerHeadline$2(this, state, dateFormatter, modifier3, $changed, i));
        }
    }

    public final FlingBehavior rememberSnapFlingBehavior$material3_release(LazyListState lazyListState, DecayAnimationSpec<Float> decayAnimationSpec, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        LazyListState lazyListState2 = lazyListState;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(lazyListState2, "lazyListState");
        composer.startReplaceableGroup(-2036003494);
        ComposerKt.sourceInformation(composer, "C(rememberSnapFlingBehavior)P(1)500@22875L7,501@22898L295:DatePicker.kt#uh7d8r");
        DecayAnimationSpec decayAnimationSpec2 = (i & 2) != 0 ? DecayAnimationSpecKt.exponentialDecay$default(0.0f, 0.0f, 3, (Object) null) : decayAnimationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2036003494, $changed, -1, "androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior (DatePicker.kt:496)");
        } else {
            int i2 = $changed;
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) density);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new SnapFlingBehavior(lazyListState2, decayAnimationSpec2, AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null), density);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return snapFlingBehavior;
    }

    public final IntRange getYearRange() {
        return YearRange;
    }

    /* renamed from: getTonalElevation-D9Ej5fM  reason: not valid java name */
    public final float m1707getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(700927667);
        ComposerKt.sourceInformation($composer, "C518@23583L9:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(700927667, $changed, -1, "androidx.compose.material3.DatePickerDefaults.<get-shape> (DatePicker.kt:518)");
        }
        Shape shape = ShapesKt.toShape(DatePickerModalTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }
}

package androidx.compose.material3;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.R;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.os.ConfigurationCompat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"getString", "", "string", "Landroidx/compose/material3/Strings;", "getString-NWtq2-8", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "formatArgs", "", "", "getString-iSCLEhQ", "(I[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Strings.android.kt */
public final class Strings_androidKt {
    /* renamed from: getString-NWtq2-8  reason: not valid java name */
    public static final String m3763getStringNWtq28(int string, Composer $composer, int $changed) {
        String str;
        ComposerKt.sourceInformationMarkerStart($composer, -176762646, "C(getString)P(0:c#material3.Strings)29@1061L7,30@1102L7:Strings.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-176762646, $changed, -1, "androidx.compose.material3.getString (Strings.android.kt:28)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        $composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Resources resources = ((Context) consume).getResources();
        if (Strings.m3696equalsimpl0(string, Strings.Companion.m3743getNavigationMenuadMyvUU())) {
            str = resources.getString(R.string.navigation_menu);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.navigation_menu)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3705getCloseDraweradMyvUU())) {
            str = resources.getString(R.string.close_drawer);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.close_drawer)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3706getCloseSheetadMyvUU())) {
            str = resources.getString(R.string.close_sheet);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.close_sheet)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3738getDefaultErrorMessageadMyvUU())) {
            str = resources.getString(R.string.default_error_message);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.st…ng.default_error_message)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3740getExposedDropdownMenuadMyvUU())) {
            str = resources.getString(R.string.dropdown_menu);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.dropdown_menu)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3746getSliderRangeStartadMyvUU())) {
            str = resources.getString(R.string.range_start);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.range_start)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3745getSliderRangeEndadMyvUU())) {
            str = resources.getString(R.string.range_end);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.range_end)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3739getDialogadMyvUU())) {
            str = resources.getString(R.string.dialog);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(andr…aterial3.R.string.dialog)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3742getMenuExpandedadMyvUU())) {
            str = resources.getString(R.string.expanded);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(andr…erial3.R.string.expanded)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3741getMenuCollapsedadMyvUU())) {
            str = resources.getString(R.string.collapsed);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(andr…rial3.R.string.collapsed)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3747getSnackbarDismissadMyvUU())) {
            str = resources.getString(R.string.snackbar_dismiss);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …nackbar_dismiss\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3744getSearchBarSearchadMyvUU())) {
            str = resources.getString(R.string.search_bar_search);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …arch_bar_search\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3748getSuggestionsAvailableadMyvUU())) {
            str = resources.getString(R.string.suggestions_available);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(andr…ng.suggestions_available)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3727getDatePickerTitleadMyvUU())) {
            str = resources.getString(R.string.date_picker_title);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …te_picker_title\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3715getDatePickerHeadlineadMyvUU())) {
            str = resources.getString(R.string.date_picker_headline);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …picker_headline\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3729getDatePickerYearPickerPaneTitleadMyvUU())) {
            str = resources.getString(R.string.date_picker_year_picker_pane_title);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …cker_pane_title\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3726getDatePickerSwitchToYearSelectionadMyvUU())) {
            str = resources.getString(R.string.date_picker_switch_to_year_selection);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …_year_selection\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3722getDatePickerSwitchToDaySelectionadMyvUU())) {
            str = resources.getString(R.string.date_picker_switch_to_day_selection);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …o_day_selection\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3724getDatePickerSwitchToNextMonthadMyvUU())) {
            str = resources.getString(R.string.date_picker_switch_to_next_month);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …h_to_next_month\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3725getDatePickerSwitchToPreviousMonthadMyvUU())) {
            str = resources.getString(R.string.date_picker_switch_to_previous_month);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …_previous_month\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3717getDatePickerNavigateToYearDescriptionadMyvUU())) {
            str = resources.getString(R.string.date_picker_navigate_to_year_description);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …ear_description\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3716getDatePickerHeadlineDescriptionadMyvUU())) {
            str = resources.getString(R.string.date_picker_headline_description);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …ine_description\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3718getDatePickerNoSelectionDescriptionadMyvUU())) {
            str = resources.getString(R.string.date_picker_no_selection_description);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …ion_description\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3728getDatePickerTodayDescriptionadMyvUU())) {
            str = resources.getString(R.string.date_picker_today_description);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …day_description\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3720getDatePickerScrollToShowLaterYearsadMyvUU())) {
            str = resources.getString(R.string.date_picker_scroll_to_later_years);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …_to_later_years\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3719getDatePickerScrollToShowEarlierYearsadMyvUU())) {
            str = resources.getString(R.string.date_picker_scroll_to_earlier_years);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …o_earlier_years\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3714getDateInputTitleadMyvUU())) {
            str = resources.getString(R.string.date_input_title);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …ate_input_title\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3707getDateInputHeadlineadMyvUU())) {
            str = resources.getString(R.string.date_input_headline);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …_input_headline\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3712getDateInputLabeladMyvUU())) {
            str = resources.getString(R.string.date_input_label);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …ate_input_label\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3708getDateInputHeadlineDescriptionadMyvUU())) {
            str = resources.getString(R.string.date_input_headline_description);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …ine_description\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3713getDateInputNoInputDescriptionadMyvUU())) {
            str = resources.getString(R.string.date_input_no_input_description);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …put_description\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3710getDateInputInvalidNotAllowedadMyvUU())) {
            str = resources.getString(R.string.date_input_invalid_not_allowed);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …lid_not_allowed\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3709getDateInputInvalidForPatternadMyvUU())) {
            str = resources.getString(R.string.date_input_invalid_for_pattern);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …lid_for_pattern\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3711getDateInputInvalidYearRangeadMyvUU())) {
            str = resources.getString(R.string.date_input_invalid_year_range);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …alid_year_range\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3721getDatePickerSwitchToCalendarModeadMyvUU())) {
            str = resources.getString(R.string.date_picker_switch_to_calendar_mode);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …o_calendar_mode\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3723getDatePickerSwitchToInputModeadMyvUU())) {
            str = resources.getString(R.string.date_picker_switch_to_input_mode);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …h_to_input_mode\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3737getDateRangePickerTitleadMyvUU())) {
            str = resources.getString(R.string.date_range_picker_title);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …ge_picker_title\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3736getDateRangePickerStartHeadlineadMyvUU())) {
            str = resources.getString(R.string.date_range_picker_start_headline);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …_start_headline\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3733getDateRangePickerEndHeadlineadMyvUU())) {
            str = resources.getString(R.string.date_range_picker_end_headline);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …er_end_headline\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3734getDateRangePickerScrollToShowNextMonthadMyvUU())) {
            str = resources.getString(R.string.date_range_picker_scroll_to_next_month);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …l_to_next_month\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3735getDateRangePickerScrollToShowPreviousMonthadMyvUU())) {
            str = resources.getString(R.string.date_range_picker_scroll_to_previous_month);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …_previous_month\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3732getDateRangePickerDayInRangeadMyvUU())) {
            str = resources.getString(R.string.date_range_picker_day_in_range);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …er_day_in_range\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3731getDateRangeInputTitleadMyvUU())) {
            str = resources.getString(R.string.date_range_input_title);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …nge_input_title\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3730getDateRangeInputInvalidRangeInputadMyvUU())) {
            str = resources.getString(R.string.date_range_input_invalid_range_input);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …lid_range_input\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3703getBottomSheetPaneTitleadMyvUU())) {
            str = resources.getString(R.string.m3c_bottom_sheet_pane_title);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …heet_pane_title\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3701getBottomSheetDragHandleDescriptionadMyvUU())) {
            str = resources.getString(R.string.bottom_sheet_drag_handle_description);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …dle_description\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3704getBottomSheetPartialExpandDescriptionadMyvUU())) {
            str = resources.getString(R.string.bottom_sheet_collapse_description);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …pse_description\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3700getBottomSheetDismissDescriptionadMyvUU())) {
            str = resources.getString(R.string.bottom_sheet_dismiss_description);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …iss_description\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3702getBottomSheetExpandDescriptionadMyvUU())) {
            str = resources.getString(R.string.bottom_sheet_expand_description);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …and_description\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3761getTooltipLongPressLabeladMyvUU())) {
            str = resources.getString(R.string.tooltip_long_press_label);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …ong_press_label\n        )");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3750getTimePickerAMadMyvUU())) {
            str = resources.getString(R.string.time_picker_am);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   ….R.string.time_picker_am)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3759getTimePickerPMadMyvUU())) {
            str = resources.getString(R.string.time_picker_pm);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   ….R.string.time_picker_pm)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3760getTimePickerPeriodToggleadMyvUU())) {
            str = resources.getString(R.string.time_picker_period_toggle_description);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …eriod_toggle_description)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3756getTimePickerMinuteSelectionadMyvUU())) {
            str = resources.getString(R.string.time_picker_minute_selection);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …_picker_minute_selection)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3752getTimePickerHourSelectionadMyvUU())) {
            str = resources.getString(R.string.time_picker_hour_selection);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …me_picker_hour_selection)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3753getTimePickerHourSuffixadMyvUU())) {
            str = resources.getString(R.string.time_picker_hour_suffix);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   ….time_picker_hour_suffix)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3757getTimePickerMinuteSuffixadMyvUU())) {
            str = resources.getString(R.string.time_picker_minute_suffix);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …ime_picker_minute_suffix)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3749getTimePicker24HourSuffixadMyvUU())) {
            str = resources.getString(R.string.time_picker_hour_24h_suffix);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …e_picker_hour_24h_suffix)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3751getTimePickerHouradMyvUU())) {
            str = resources.getString(R.string.time_picker_hour);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   ….string.time_picker_hour)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3755getTimePickerMinuteadMyvUU())) {
            str = resources.getString(R.string.time_picker_minute);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …tring.time_picker_minute)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3754getTimePickerHourTextFieldadMyvUU())) {
            str = resources.getString(R.string.time_picker_hour_text_field);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …e_picker_hour_text_field)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3758getTimePickerMinuteTextFieldadMyvUU())) {
            str = resources.getString(R.string.time_picker_minute_text_field);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …picker_minute_text_field)");
        } else if (Strings.m3696equalsimpl0(string, Strings.Companion.m3762getTooltipPaneDescriptionadMyvUU())) {
            str = resources.getString(R.string.tooltip_pane_description);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(\n   …tooltip_pane_description)");
        } else {
            str = "";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return str;
    }

    /* renamed from: getString-iSCLEhQ  reason: not valid java name */
    public static final String m3764getStringiSCLEhQ(int string, Object[] formatArgs, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        ComposerKt.sourceInformationMarkerStart($composer, -1126124681, "C(getString)P(1:c#material3.Strings)205@10113L17,207@10206L7:Strings.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1126124681, $changed, -1, "androidx.compose.material3.getString (Strings.android.kt:204)");
        }
        String raw = m3763getStringNWtq28(string, $composer, $changed & 14);
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Locale locale = ConfigurationCompat.getLocales((Configuration) consume).get(0);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] copyOf = Arrays.copyOf(formatArgs, formatArgs.length);
        String format = String.format(locale, raw, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return format;
    }
}

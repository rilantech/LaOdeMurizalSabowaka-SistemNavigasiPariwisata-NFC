package androidx.compose.material3;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J3\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0016J)\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/DatePickerFormatter;", "", "yearSelectionSkeleton", "", "selectedDateSkeleton", "selectedDateDescriptionSkeleton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSelectedDateDescriptionSkeleton$material3_release", "()Ljava/lang/String;", "getSelectedDateSkeleton$material3_release", "getYearSelectionSkeleton$material3_release", "equals", "", "other", "formatDate", "date", "Landroidx/compose/material3/CalendarDate;", "calendarModel", "Landroidx/compose/material3/CalendarModel;", "locale", "Ljava/util/Locale;", "forContentDescription", "formatDate$material3_release", "formatMonthYear", "month", "Landroidx/compose/material3/CalendarMonth;", "formatMonthYear$material3_release", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
public final class DatePickerFormatter {
    public static final int $stable = 0;
    private final String selectedDateDescriptionSkeleton;
    private final String selectedDateSkeleton;
    private final String yearSelectionSkeleton;

    public DatePickerFormatter() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public DatePickerFormatter(String yearSelectionSkeleton2, String selectedDateSkeleton2, String selectedDateDescriptionSkeleton2) {
        Intrinsics.checkNotNullParameter(yearSelectionSkeleton2, "yearSelectionSkeleton");
        Intrinsics.checkNotNullParameter(selectedDateSkeleton2, "selectedDateSkeleton");
        Intrinsics.checkNotNullParameter(selectedDateDescriptionSkeleton2, "selectedDateDescriptionSkeleton");
        this.yearSelectionSkeleton = yearSelectionSkeleton2;
        this.selectedDateSkeleton = selectedDateSkeleton2;
        this.selectedDateDescriptionSkeleton = selectedDateDescriptionSkeleton2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DatePickerFormatter(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DatePickerDefaults.YearMonthSkeleton : str, (i & 2) != 0 ? DatePickerDefaults.YearAbbrMonthDaySkeleton : str2, (i & 4) != 0 ? DatePickerDefaults.YearMonthWeekdayDaySkeleton : str3);
    }

    public final String getYearSelectionSkeleton$material3_release() {
        return this.yearSelectionSkeleton;
    }

    public final String getSelectedDateSkeleton$material3_release() {
        return this.selectedDateSkeleton;
    }

    public final String getSelectedDateDescriptionSkeleton$material3_release() {
        return this.selectedDateDescriptionSkeleton;
    }

    public final String formatMonthYear$material3_release(CalendarMonth month, CalendarModel calendarModel, Locale locale) {
        Intrinsics.checkNotNullParameter(calendarModel, "calendarModel");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (month == null) {
            return null;
        }
        return calendarModel.formatWithSkeleton(month, this.yearSelectionSkeleton, locale);
    }

    public static /* synthetic */ String formatDate$material3_release$default(DatePickerFormatter datePickerFormatter, CalendarDate calendarDate, CalendarModel calendarModel, Locale locale, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return datePickerFormatter.formatDate$material3_release(calendarDate, calendarModel, locale, z);
    }

    public final String formatDate$material3_release(CalendarDate date, CalendarModel calendarModel, Locale locale, boolean forContentDescription) {
        String str;
        Intrinsics.checkNotNullParameter(calendarModel, "calendarModel");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (date == null) {
            return null;
        }
        if (forContentDescription) {
            str = this.selectedDateDescriptionSkeleton;
        } else {
            str = this.selectedDateSkeleton;
        }
        return calendarModel.formatWithSkeleton(date, str, locale);
    }

    public boolean equals(Object other) {
        if ((other instanceof DatePickerFormatter) && Intrinsics.areEqual((Object) this.yearSelectionSkeleton, (Object) ((DatePickerFormatter) other).yearSelectionSkeleton) && Intrinsics.areEqual((Object) this.selectedDateSkeleton, (Object) ((DatePickerFormatter) other).selectedDateSkeleton) && Intrinsics.areEqual((Object) this.selectedDateDescriptionSkeleton, (Object) ((DatePickerFormatter) other).selectedDateDescriptionSkeleton)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.yearSelectionSkeleton.hashCode() * 31) + this.selectedDateSkeleton.hashCode()) * 31) + this.selectedDateDescriptionSkeleton.hashCode();
    }
}

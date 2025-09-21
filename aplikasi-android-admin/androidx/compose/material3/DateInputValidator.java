package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0002\u0010\u0011J-\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/DateInputValidator;", "", "stateData", "Landroidx/compose/material3/StateData;", "dateInputFormat", "Landroidx/compose/material3/DateInputFormat;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "dateValidator", "Lkotlin/Function1;", "", "", "errorDatePattern", "", "errorDateOutOfYearRange", "errorInvalidNotAllowed", "errorInvalidRangeInput", "(Landroidx/compose/material3/StateData;Landroidx/compose/material3/DateInputFormat;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "validate", "calendarDate", "Landroidx/compose/material3/CalendarDate;", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "locale", "Ljava/util/Locale;", "validate-XivgLIo", "(Landroidx/compose/material3/CalendarDate;ILjava/util/Locale;)Ljava/lang/String;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
public final class DateInputValidator {
    private final DatePickerFormatter dateFormatter;
    private final DateInputFormat dateInputFormat;
    private final Function1<Long, Boolean> dateValidator;
    private final String errorDateOutOfYearRange;
    private final String errorDatePattern;
    private final String errorInvalidNotAllowed;
    private final String errorInvalidRangeInput;
    private final StateData stateData;

    public DateInputValidator(StateData stateData2, DateInputFormat dateInputFormat2, DatePickerFormatter dateFormatter2, Function1<? super Long, Boolean> dateValidator2, String errorDatePattern2, String errorDateOutOfYearRange2, String errorInvalidNotAllowed2, String errorInvalidRangeInput2) {
        Intrinsics.checkNotNullParameter(stateData2, "stateData");
        Intrinsics.checkNotNullParameter(dateInputFormat2, "dateInputFormat");
        Intrinsics.checkNotNullParameter(dateFormatter2, "dateFormatter");
        Intrinsics.checkNotNullParameter(dateValidator2, "dateValidator");
        Intrinsics.checkNotNullParameter(errorDatePattern2, "errorDatePattern");
        Intrinsics.checkNotNullParameter(errorDateOutOfYearRange2, "errorDateOutOfYearRange");
        Intrinsics.checkNotNullParameter(errorInvalidNotAllowed2, "errorInvalidNotAllowed");
        Intrinsics.checkNotNullParameter(errorInvalidRangeInput2, "errorInvalidRangeInput");
        this.stateData = stateData2;
        this.dateInputFormat = dateInputFormat2;
        this.dateFormatter = dateFormatter2;
        this.dateValidator = dateValidator2;
        this.errorDatePattern = errorDatePattern2;
        this.errorDateOutOfYearRange = errorDateOutOfYearRange2;
        this.errorInvalidNotAllowed = errorInvalidNotAllowed2;
        this.errorInvalidRangeInput = errorInvalidRangeInput2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00d5, code lost:
        if (r0 < r2) goto L_0x00d7;
     */
    /* renamed from: validate-XivgLIo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String m3408validateXivgLIo(androidx.compose.material3.CalendarDate r11, int r12, java.util.Locale r13) {
        /*
            r10 = this;
            java.lang.String r0 = "locale"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 1
            java.lang.String r1 = "format(this, *args)"
            if (r11 != 0) goto L_0x002f
            java.lang.String r2 = r10.errorDatePattern
            androidx.compose.material3.DateInputFormat r3 = r10.dateInputFormat
            java.lang.String r3 = r3.getPatternWithDelimiters()
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toUpperCase(r4)
            java.lang.String r4 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r3, r0)
            java.lang.String r0 = java.lang.String.format(r2, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        L_0x002f:
            androidx.compose.material3.StateData r2 = r10.stateData
            kotlin.ranges.IntRange r2 = r2.getYearRange()
            int r3 = r11.getYear()
            boolean r2 = r2.contains((int) r3)
            if (r2 != 0) goto L_0x006f
            java.lang.String r0 = r10.errorDateOutOfYearRange
            androidx.compose.material3.StateData r2 = r10.stateData
            kotlin.ranges.IntRange r2 = r2.getYearRange()
            int r2 = r2.getFirst()
            java.lang.String r2 = androidx.compose.material3.DatePickerKt.toLocalString(r2)
            androidx.compose.material3.StateData r3 = r10.stateData
            kotlin.ranges.IntRange r3 = r3.getYearRange()
            int r3 = r3.getLast()
            java.lang.String r3 = androidx.compose.material3.DatePickerKt.toLocalString(r3)
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r3}
            r3 = 2
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r3)
            java.lang.String r0 = java.lang.String.format(r0, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        L_0x006f:
            kotlin.jvm.functions.Function1<java.lang.Long, java.lang.Boolean> r2 = r10.dateValidator
            long r3 = r11.getUtcTimeMillis()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object r2 = r2.invoke(r3)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x00ab
            java.lang.String r2 = r10.errorInvalidNotAllowed
            androidx.compose.material3.DatePickerFormatter r3 = r10.dateFormatter
            androidx.compose.material3.StateData r4 = r10.stateData
            androidx.compose.material3.CalendarModel r5 = r4.getCalendarModel()
            r8 = 8
            r9 = 0
            r7 = 0
            r4 = r11
            r6 = r13
            java.lang.String r3 = androidx.compose.material3.DatePickerFormatter.formatDate$material3_release$default(r3, r4, r5, r6, r7, r8, r9)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r3, r0)
            java.lang.String r0 = java.lang.String.format(r2, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        L_0x00ab:
            androidx.compose.material3.InputIdentifier$Companion r0 = androidx.compose.material3.InputIdentifier.Companion
            int r0 = r0.m3535getStartDateInputJ2x2o4M()
            boolean r0 = androidx.compose.material3.InputIdentifier.m3529equalsimpl0(r12, r0)
            if (r0 == 0) goto L_0x00d7
            long r0 = r11.getUtcTimeMillis()
            androidx.compose.material3.StateData r2 = r10.stateData
            androidx.compose.runtime.MutableState r2 = r2.getSelectedEndDate()
            java.lang.Object r2 = r2.getValue()
            androidx.compose.material3.CalendarDate r2 = (androidx.compose.material3.CalendarDate) r2
            if (r2 == 0) goto L_0x00ce
            long r2 = r2.getUtcTimeMillis()
            goto L_0x00d3
        L_0x00ce:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00d3:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0100
        L_0x00d7:
            androidx.compose.material3.InputIdentifier$Companion r0 = androidx.compose.material3.InputIdentifier.Companion
            int r0 = r0.m3533getEndDateInputJ2x2o4M()
            boolean r0 = androidx.compose.material3.InputIdentifier.m3529equalsimpl0(r12, r0)
            if (r0 == 0) goto L_0x0103
            long r0 = r11.getUtcTimeMillis()
            androidx.compose.material3.StateData r2 = r10.stateData
            androidx.compose.runtime.MutableState r2 = r2.getSelectedStartDate()
            java.lang.Object r2 = r2.getValue()
            androidx.compose.material3.CalendarDate r2 = (androidx.compose.material3.CalendarDate) r2
            if (r2 == 0) goto L_0x00fa
            long r2 = r2.getUtcTimeMillis()
            goto L_0x00fc
        L_0x00fa:
            r2 = -9223372036854775808
        L_0x00fc:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0103
        L_0x0100:
            java.lang.String r0 = r10.errorInvalidRangeInput
            return r0
        L_0x0103:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputValidator.m3408validateXivgLIo(androidx.compose.material3.CalendarDate, int, java.util.Locale):java.lang.String");
    }
}

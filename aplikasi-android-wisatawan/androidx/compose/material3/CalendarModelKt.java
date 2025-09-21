package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"DaysInWeek", "", "MillisecondsIn24Hours", "", "datePatternAsInputFormat", "Landroidx/compose/material3/DateInputFormat;", "localeFormat", "", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CalendarModel.kt */
public final class CalendarModelKt {
    public static final int DaysInWeek = 7;
    public static final long MillisecondsIn24Hours = 86400000;

    public static final DateInputFormat datePatternAsInputFormat(String localeFormat) {
        Intrinsics.checkNotNullParameter(localeFormat, "localeFormat");
        Regex regex = new Regex("[^dMy/\\-.]");
        Regex regex2 = new Regex("d{1,2}");
        Regex regex3 = new Regex("M{1,2}");
        String patternWithDelimiters = StringsKt.removeSuffix(StringsKt.replace$default(new Regex("y{1,4}").replace((CharSequence) regex3.replace((CharSequence) regex2.replace((CharSequence) regex.replace((CharSequence) localeFormat, ""), "dd"), "MM"), "yyyy"), "My", "M/y", false, 4, (Object) null), (CharSequence) ".");
        MatchResult delimiterMatchResult = Regex.find$default(new Regex("[/\\-.]"), patternWithDelimiters, 0, 2, (Object) null);
        Intrinsics.checkNotNull(delimiterMatchResult);
        MatchGroup matchGroup = delimiterMatchResult.getGroups().get(0);
        Intrinsics.checkNotNull(matchGroup);
        int delimiterIndex = matchGroup.getRange().getFirst();
        String delimiter = patternWithDelimiters.substring(delimiterIndex, delimiterIndex + 1);
        Intrinsics.checkNotNullExpressionValue(delimiter, "this as java.lang.String…ing(startIndex, endIndex)");
        return new DateInputFormat(patternWithDelimiters, delimiter.charAt(0));
    }
}

package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
final class DateInputKt$DateInputTextField$text$2 extends Lambda implements Function0<MutableState<TextFieldValue>> {
    final /* synthetic */ DateInputFormat $dateInputFormat;
    final /* synthetic */ CalendarDate $initialDate;
    final /* synthetic */ Locale $locale;
    final /* synthetic */ StateData $stateData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateInputKt$DateInputTextField$text$2(StateData stateData, CalendarDate calendarDate, DateInputFormat dateInputFormat, Locale locale) {
        super(0);
        this.$stateData = stateData;
        this.$initialDate = calendarDate;
        this.$dateInputFormat = dateInputFormat;
        this.$locale = locale;
    }

    public final MutableState<TextFieldValue> invoke() {
        String str;
        String formatWithPattern;
        StateData $this$invoke_u24lambda_u241 = this.$stateData;
        CalendarDate it = this.$initialDate;
        DateInputFormat dateInputFormat = this.$dateInputFormat;
        Locale locale = this.$locale;
        if (it == null || (formatWithPattern = $this$invoke_u24lambda_u241.getCalendarModel().formatWithPattern(it.getUtcTimeMillis(), dateInputFormat.getPatternWithoutDelimiters(), locale)) == null) {
            str = "";
        } else {
            str = formatWithPattern;
        }
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str, TextRangeKt.TextRange(0, 0), (TextRange) null, 4, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}

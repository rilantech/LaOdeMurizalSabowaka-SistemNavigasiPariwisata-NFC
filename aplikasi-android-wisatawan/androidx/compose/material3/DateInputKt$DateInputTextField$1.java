package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
final class DateInputKt$DateInputTextField$1 extends Lambda implements Function1<TextFieldValue, Unit> {
    final /* synthetic */ DateInputFormat $dateInputFormat;
    final /* synthetic */ DateInputValidator $dateInputValidator;
    final /* synthetic */ MutableState<String> $errorText;
    final /* synthetic */ int $inputIdentifier;
    final /* synthetic */ Locale $locale;
    final /* synthetic */ Function1<CalendarDate, Unit> $onDateChanged;
    final /* synthetic */ StateData $stateData;
    final /* synthetic */ MutableState<TextFieldValue> $text$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateInputKt$DateInputTextField$1(DateInputFormat dateInputFormat, MutableState<String> mutableState, Function1<? super CalendarDate, Unit> function1, StateData stateData, DateInputValidator dateInputValidator, int i, Locale locale, MutableState<TextFieldValue> mutableState2) {
        super(1);
        this.$dateInputFormat = dateInputFormat;
        this.$errorText = mutableState;
        this.$onDateChanged = function1;
        this.$stateData = stateData;
        this.$dateInputValidator = dateInputValidator;
        this.$inputIdentifier = i;
        this.$locale = locale;
        this.$text$delegate = mutableState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((TextFieldValue) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(TextFieldValue input) {
        CharSequence $this$all$iv;
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.getText().length() <= this.$dateInputFormat.getPatternWithoutDelimiters().length()) {
            CharSequence $this$all$iv2 = input.getText();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= $this$all$iv2.length()) {
                    $this$all$iv = 1;
                    break;
                } else if (!Character.isDigit($this$all$iv2.charAt(i))) {
                    $this$all$iv = null;
                    break;
                } else {
                    i++;
                }
            }
            if ($this$all$iv != null) {
                DateInputKt.DateInputTextField_zm97o8M$lambda$4(this.$text$delegate, input);
                String trimmedText = StringsKt.trim((CharSequence) input.getText()).toString();
                CalendarDate calendarDate = null;
                if ((trimmedText.length() == 0) || trimmedText.length() < this.$dateInputFormat.getPatternWithoutDelimiters().length()) {
                    this.$errorText.setValue("");
                    this.$onDateChanged.invoke(null);
                    return;
                }
                CalendarDate parsedDate = this.$stateData.getCalendarModel().parse(trimmedText, this.$dateInputFormat.getPatternWithoutDelimiters());
                this.$errorText.setValue(this.$dateInputValidator.m1698validateXivgLIo(parsedDate, this.$inputIdentifier, this.$locale));
                Function1<CalendarDate, Unit> function1 = this.$onDateChanged;
                if (this.$errorText.getValue().length() == 0) {
                    z = true;
                }
                if (z) {
                    calendarDate = parsedDate;
                }
                function1.invoke(calendarDate);
            }
        }
    }
}

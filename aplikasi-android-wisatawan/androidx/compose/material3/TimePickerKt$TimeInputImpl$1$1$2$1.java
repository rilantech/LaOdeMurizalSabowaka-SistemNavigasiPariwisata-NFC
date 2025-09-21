package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$TimeInputImpl$1$1$2$1 extends Lambda implements Function1<TextFieldValue, Unit> {
    final /* synthetic */ MutableState<TextFieldValue> $hourValue$delegate;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimeInputImpl$1$1$2$1(TimePickerState timePickerState, MutableState<TextFieldValue> mutableState) {
        super(1);
        this.$state = timePickerState;
        this.$hourValue$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((TextFieldValue) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(TextFieldValue newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int r1 = Selection.Companion.m1960getHourJiIwxys();
        TimePickerState timePickerState = this.$state;
        TextFieldValue access$TimeInputImpl$lambda$5 = TimePickerKt.TimeInputImpl$lambda$5(this.$hourValue$delegate);
        int i = this.$state.is24hour() ? 23 : 12;
        final MutableState<TextFieldValue> mutableState = this.$hourValue$delegate;
        TimePickerKt.m2171timeInputOnChangegIWD5Rc(r1, timePickerState, newValue, access$TimeInputImpl$lambda$5, i, new Function1<TextFieldValue, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((TextFieldValue) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(TextFieldValue it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TimePickerKt.TimeInputImpl$lambda$6(mutableState, it);
            }
        });
    }
}

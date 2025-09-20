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
final class TimePickerKt$TimeInputImpl$1$1$5$1 extends Lambda implements Function1<TextFieldValue, Unit> {
    final /* synthetic */ MutableState<TextFieldValue> $minuteValue$delegate;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimeInputImpl$1$1$5$1(TimePickerState timePickerState, MutableState<TextFieldValue> mutableState) {
        super(1);
        this.$state = timePickerState;
        this.$minuteValue$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((TextFieldValue) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(TextFieldValue newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int r1 = Selection.Companion.m1961getMinuteJiIwxys();
        TimePickerState timePickerState = this.$state;
        TextFieldValue access$TimeInputImpl$lambda$8 = TimePickerKt.TimeInputImpl$lambda$8(this.$minuteValue$delegate);
        final MutableState<TextFieldValue> mutableState = this.$minuteValue$delegate;
        TimePickerKt.m2171timeInputOnChangegIWD5Rc(r1, timePickerState, newValue, access$TimeInputImpl$lambda$8, 59, new Function1<TextFieldValue, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((TextFieldValue) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(TextFieldValue it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TimePickerKt.TimeInputImpl$lambda$9(mutableState, it);
            }
        });
    }
}

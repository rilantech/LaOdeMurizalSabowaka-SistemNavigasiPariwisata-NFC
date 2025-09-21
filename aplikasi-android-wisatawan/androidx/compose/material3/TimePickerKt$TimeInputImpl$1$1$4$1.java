package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$TimeInputImpl$1$1$4$1 extends Lambda implements Function1<KeyEvent, Boolean> {
    final /* synthetic */ MutableState<TextFieldValue> $minuteValue$delegate;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimeInputImpl$1$1$4$1(TimePickerState timePickerState, MutableState<TextFieldValue> mutableState) {
        super(1);
        this.$state = timePickerState;
        this.$minuteValue$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return m2175invokeZmokQxo(((KeyEvent) p1).m4322unboximpl());
    }

    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m2175invokeZmokQxo(android.view.KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        boolean switchFocus = KeyEvent_androidKt.m4335getUtf16CodePointZmokQxo(event) == 0 && TextRange.m5325getStartimpl(TimePickerKt.TimeInputImpl$lambda$8(this.$minuteValue$delegate).m5555getSelectiond9O1mEE()) == 0;
        if (switchFocus) {
            this.$state.m2194setSelectioniHAOin8$material3_release(Selection.Companion.m1960getHourJiIwxys());
        }
        return Boolean.valueOf(switchFocus);
    }
}

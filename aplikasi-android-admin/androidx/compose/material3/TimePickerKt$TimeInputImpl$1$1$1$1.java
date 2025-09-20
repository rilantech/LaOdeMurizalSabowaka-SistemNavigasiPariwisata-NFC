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
final class TimePickerKt$TimeInputImpl$1$1$1$1 extends Lambda implements Function1<KeyEvent, Boolean> {
    final /* synthetic */ MutableState<TextFieldValue> $hourValue$delegate;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimeInputImpl$1$1$1$1(TimePickerState timePickerState, MutableState<TextFieldValue> mutableState) {
        super(1);
        this.$state = timePickerState;
        this.$hourValue$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return m3884invokeZmokQxo(((KeyEvent) p1).m6032unboximpl());
    }

    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m3884invokeZmokQxo(android.view.KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        int r0 = KeyEvent_androidKt.m6045getUtf16CodePointZmokQxo(event);
        boolean switchFocus = true;
        if (!((48 <= r0 && r0 < 58) && TextRange.m7035getStartimpl(TimePickerKt.TimeInputImpl$lambda$5(this.$hourValue$delegate).m7265getSelectiond9O1mEE()) == 2 && TimePickerKt.TimeInputImpl$lambda$5(this.$hourValue$delegate).getText().length() == 2)) {
            switchFocus = false;
        }
        if (switchFocus) {
            this.$state.m3904setSelectioniHAOin8$material3_release(Selection.Companion.m3671getMinuteJiIwxys());
        }
        return false;
    }
}

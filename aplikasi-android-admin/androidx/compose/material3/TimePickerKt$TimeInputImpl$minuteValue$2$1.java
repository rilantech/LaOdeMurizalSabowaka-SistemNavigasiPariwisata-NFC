package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$TimeInputImpl$minuteValue$2$1 extends Lambda implements Function0<MutableState<TextFieldValue>> {
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimeInputImpl$minuteValue$2$1(TimePickerState timePickerState) {
        super(0);
        this.$state = timePickerState;
    }

    public final MutableState<TextFieldValue> invoke() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(TimePickerKt.toLocalString(this.$state.getMinute(), 2), 0, (TextRange) null, 6, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}

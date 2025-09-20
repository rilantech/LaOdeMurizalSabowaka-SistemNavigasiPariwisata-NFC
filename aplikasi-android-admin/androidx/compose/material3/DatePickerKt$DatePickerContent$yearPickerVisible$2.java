package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePickerContent$yearPickerVisible$2 extends Lambda implements Function0<MutableState<Boolean>> {
    public static final DatePickerKt$DatePickerContent$yearPickerVisible$2 INSTANCE = new DatePickerKt$DatePickerContent$yearPickerVisible$2();

    DatePickerKt$DatePickerContent$yearPickerVisible$2() {
        super(0);
    }

    public final MutableState<Boolean> invoke() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}

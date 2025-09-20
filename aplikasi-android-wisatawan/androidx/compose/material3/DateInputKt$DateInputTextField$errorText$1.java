package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
final class DateInputKt$DateInputTextField$errorText$1 extends Lambda implements Function0<MutableState<String>> {
    public static final DateInputKt$DateInputTextField$errorText$1 INSTANCE = new DateInputKt$DateInputTextField$errorText$1();

    DateInputKt$DateInputTextField$errorText$1() {
        super(0);
    }

    public final MutableState<String> invoke() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}

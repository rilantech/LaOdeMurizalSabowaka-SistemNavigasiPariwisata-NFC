package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$Month$1$1$1$1$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $dateInMillis;
    final /* synthetic */ Function1<Long, Unit> $onDateSelected;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$Month$1$1$1$1$1$1$1(Function1<? super Long, Unit> function1, long j) {
        super(0);
        this.$onDateSelected = function1;
        this.$dateInMillis = j;
    }

    public final void invoke() {
        this.$onDateSelected.invoke(Long.valueOf(this.$dateInMillis));
    }
}

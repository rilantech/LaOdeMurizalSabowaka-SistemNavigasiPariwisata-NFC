package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePicker$5$1$1 extends Lambda implements Function1<DisplayMode, Unit> {
    final /* synthetic */ DatePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePicker$5$1$1(DatePickerState datePickerState) {
        super(1);
        this.$state = datePickerState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        m3423invokevCnGnXg(((DisplayMode) p1).m3447unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-vCnGnXg  reason: not valid java name */
    public final void m3423invokevCnGnXg(int displayMode) {
        this.$state.getStateData$material3_release().m3691switchDisplayModevCnGnXg(displayMode);
    }
}

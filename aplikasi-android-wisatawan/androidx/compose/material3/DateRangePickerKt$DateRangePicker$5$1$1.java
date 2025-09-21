package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerKt$DateRangePicker$5$1$1 extends Lambda implements Function1<DisplayMode, Unit> {
    final /* synthetic */ DateRangePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$DateRangePicker$5$1$1(DateRangePickerState dateRangePickerState) {
        super(1);
        this.$state = dateRangePickerState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        m1719invokevCnGnXg(((DisplayMode) p1).m1737unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-vCnGnXg  reason: not valid java name */
    public final void m1719invokevCnGnXg(int displayMode) {
        this.$state.getStateData$material3_release().m1981switchDisplayModevCnGnXg(displayMode);
    }
}

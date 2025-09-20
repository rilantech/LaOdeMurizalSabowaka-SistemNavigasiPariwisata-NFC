package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$updateDisplayedMonth$3 implements FlowCollector<Integer> {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ StateData $stateData;

    DatePickerKt$updateDisplayedMonth$3(LazyListState lazyListState, StateData stateData) {
        this.$lazyListState = lazyListState;
        this.$stateData = stateData;
    }

    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
        return emit(((Number) value).intValue(), (Continuation<? super Unit>) $completion);
    }

    public final Object emit(int it, Continuation<? super Unit> $completion) {
        int yearOffset = this.$lazyListState.getFirstVisibleItemIndex() / 12;
        int month = (this.$lazyListState.getFirstVisibleItemIndex() % 12) + 1;
        StateData $this$emit_u24lambda_u240 = this.$stateData;
        if (!($this$emit_u24lambda_u240.getDisplayedMonth().getMonth() == month && $this$emit_u24lambda_u240.getDisplayedMonth().getYear() == $this$emit_u24lambda_u240.getYearRange().getFirst() + yearOffset)) {
            $this$emit_u24lambda_u240.setDisplayedMonth($this$emit_u24lambda_u240.getCalendarModel().getMonth($this$emit_u24lambda_u240.getYearRange().getFirst() + yearOffset, month));
        }
        return Unit.INSTANCE;
    }
}

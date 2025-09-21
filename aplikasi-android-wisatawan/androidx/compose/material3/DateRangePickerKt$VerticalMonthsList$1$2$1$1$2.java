package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerKt$VerticalMonthsList$1$2$1$1$2 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ String $scrollToNextMonthLabel;
    final /* synthetic */ String $scrollToPreviousMonthLabel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$VerticalMonthsList$1$2$1$1$2(LazyListState lazyListState, CoroutineScope coroutineScope, String str, String str2) {
        super(1);
        this.$lazyListState = lazyListState;
        this.$coroutineScope = coroutineScope;
        this.$scrollToPreviousMonthLabel = str;
        this.$scrollToNextMonthLabel = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        SemanticsPropertiesKt.setCustomActions($this$semantics, DateRangePickerKt.customScrollActions(this.$lazyListState, this.$coroutineScope, this.$scrollToPreviousMonthLabel, this.$scrollToNextMonthLabel));
    }
}

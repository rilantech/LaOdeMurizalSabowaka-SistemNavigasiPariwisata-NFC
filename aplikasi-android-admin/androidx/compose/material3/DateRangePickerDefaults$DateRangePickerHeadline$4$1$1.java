package androidx.compose.material3;

import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerDefaults$DateRangePickerHeadline$4$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ String $endHeadlineDescription;
    final /* synthetic */ String $startHeadlineDescription;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerDefaults$DateRangePickerHeadline$4$1$1(String str, String str2) {
        super(1);
        this.$startHeadlineDescription = str;
        this.$endHeadlineDescription = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter($this$clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.m6885setLiveRegionhR3wRGc($this$clearAndSetSemantics, LiveRegionMode.Companion.m6864getPolite0phEisY());
        SemanticsPropertiesKt.setContentDescription($this$clearAndSetSemantics, this.$startHeadlineDescription + ", " + this.$endHeadlineDescription);
    }
}

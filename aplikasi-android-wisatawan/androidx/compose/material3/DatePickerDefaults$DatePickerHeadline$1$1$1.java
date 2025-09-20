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
/* compiled from: DatePicker.kt */
final class DatePickerDefaults$DatePickerHeadline$1$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ String $headlineDescription;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerDefaults$DatePickerHeadline$1$1$1(String str) {
        super(1);
        this.$headlineDescription = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        SemanticsPropertiesKt.m5175setLiveRegionhR3wRGc($this$semantics, LiveRegionMode.Companion.m5154getPolite0phEisY());
        SemanticsPropertiesKt.setContentDescription($this$semantics, this.$headlineDescription);
    }
}

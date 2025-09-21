package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/DpOffset;", "invoke-RKDOV3M", "()J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerState$selectorPos$2 extends Lambda implements Function0<DpOffset> {
    final /* synthetic */ boolean $is24Hour;
    final /* synthetic */ TimePickerState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerState$selectorPos$2(TimePickerState timePickerState, boolean z) {
        super(0);
        this.this$0 = timePickerState;
        this.$is24Hour = z;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return DpOffset.m5899boximpl(m2195invokeRKDOV3M());
    }

    /* renamed from: invoke-RKDOV3M  reason: not valid java name */
    public final long m2195invokeRKDOV3M() {
        float arg0$iv;
        boolean inInnerCircle = this.this$0.isInnerCircle$material3_release();
        float handleRadiusPx = Dp.m5844constructorimpl(TimePickerTokens.INSTANCE.m2764getClockDialSelectorHandleContainerSizeD9Ej5fM() / ((float) 2));
        if (!this.$is24Hour || !inInnerCircle || !Selection.m1956equalsimpl0(this.this$0.m2191getSelectionJiIwxys$material3_release(), Selection.Companion.m1960getHourJiIwxys())) {
            arg0$iv = TimePickerKt.OuterCircleSizeRadius;
        } else {
            arg0$iv = TimePickerKt.InnerCircleRadius;
        }
        float length = Dp.m5844constructorimpl(Dp.m5844constructorimpl(arg0$iv - handleRadiusPx) + handleRadiusPx);
        return DpKt.m5865DpOffsetYgX7TsA(Dp.m5844constructorimpl(Dp.m5844constructorimpl(length * ((float) Math.cos((double) this.this$0.getCurrentAngle$material3_release().getValue().floatValue()))) + Dp.m5844constructorimpl(TimePickerTokens.INSTANCE.m2762getClockDialContainerSizeD9Ej5fM() / ((float) 2))), Dp.m5844constructorimpl(Dp.m5844constructorimpl(length * ((float) Math.sin((double) this.this$0.getCurrentAngle$material3_release().getValue().floatValue()))) + Dp.m5844constructorimpl(TimePickerTokens.INSTANCE.m2762getClockDialContainerSizeD9Ej5fM() / ((float) 2))));
    }
}

package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$CommonDecorationBox$3$1$1 extends Lambda implements Function1<Size, Unit> {
    final /* synthetic */ float $labelProgress;
    final /* synthetic */ MutableState<Size> $labelSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$3$1$1(float f, MutableState<Size> mutableState) {
        super(1);
        this.$labelProgress = f;
        this.$labelSize = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        m2139invokeuvyYCjk(((Size) p1).m3077unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-uvyYCjk  reason: not valid java name */
    public final void m2139invokeuvyYCjk(long it) {
        float labelWidth = Size.m3072getWidthimpl(it) * this.$labelProgress;
        float labelHeight = Size.m3069getHeightimpl(it) * this.$labelProgress;
        boolean z = true;
        if (Size.m3072getWidthimpl(this.$labelSize.getValue().m3077unboximpl()) == labelWidth) {
            if (Size.m3069getHeightimpl(this.$labelSize.getValue().m3077unboximpl()) != labelHeight) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        this.$labelSize.setValue(Size.m3060boximpl(SizeKt.Size(labelWidth, labelHeight)));
    }
}

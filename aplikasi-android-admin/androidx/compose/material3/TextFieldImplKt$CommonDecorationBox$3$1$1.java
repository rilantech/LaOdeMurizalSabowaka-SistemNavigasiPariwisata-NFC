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
        m3849invokeuvyYCjk(((Size) p1).m4787unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-uvyYCjk  reason: not valid java name */
    public final void m3849invokeuvyYCjk(long it) {
        float labelWidth = Size.m4782getWidthimpl(it) * this.$labelProgress;
        float labelHeight = Size.m4779getHeightimpl(it) * this.$labelProgress;
        boolean z = true;
        if (Size.m4782getWidthimpl(this.$labelSize.getValue().m4787unboximpl()) == labelWidth) {
            if (Size.m4779getHeightimpl(this.$labelSize.getValue().m4787unboximpl()) != labelHeight) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        this.$labelSize.setValue(Size.m4770boximpl(SizeKt.Size(labelWidth, labelHeight)));
    }
}

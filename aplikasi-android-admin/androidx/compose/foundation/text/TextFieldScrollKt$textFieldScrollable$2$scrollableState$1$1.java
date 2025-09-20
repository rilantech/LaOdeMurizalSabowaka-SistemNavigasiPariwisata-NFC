package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "delta", "invoke", "(F)Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldScroll.kt */
final class TextFieldScrollKt$textFieldScrollable$2$scrollableState$1$1 extends Lambda implements Function1<Float, Float> {
    final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldScrollKt$textFieldScrollable$2$scrollableState$1$1(TextFieldScrollerPosition textFieldScrollerPosition) {
        super(1);
        this.$scrollerPosition = textFieldScrollerPosition;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).floatValue());
    }

    public final Float invoke(float delta) {
        float consumedDelta;
        float newOffset = this.$scrollerPosition.getOffset() + delta;
        if (newOffset > this.$scrollerPosition.getMaximum()) {
            consumedDelta = this.$scrollerPosition.getMaximum() - this.$scrollerPosition.getOffset();
        } else if (newOffset < 0.0f) {
            consumedDelta = -this.$scrollerPosition.getOffset();
        } else {
            consumedDelta = delta;
        }
        TextFieldScrollerPosition textFieldScrollerPosition = this.$scrollerPosition;
        textFieldScrollerPosition.setOffset(textFieldScrollerPosition.getOffset() + consumedDelta);
        return Float.valueOf(consumedDelta);
    }
}

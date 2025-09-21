package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutSemantics.kt */
final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ Function0<LazyLayoutItemProvider> $itemProviderLambda;
    final /* synthetic */ LazyLayoutSemanticState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$2(Function0<? extends LazyLayoutItemProvider> function0, LazyLayoutSemanticState lazyLayoutSemanticState) {
        super(0);
        this.$itemProviderLambda = function0;
        this.$state = lazyLayoutSemanticState;
    }

    public final Float invoke() {
        float f;
        LazyLayoutItemProvider itemProvider = this.$itemProviderLambda.invoke();
        if (this.$state.getCanScrollForward()) {
            f = ((float) itemProvider.getItemCount()) + 1.0f;
        } else {
            f = this.$state.getCurrentPosition();
        }
        return Float.valueOf(f);
    }
}

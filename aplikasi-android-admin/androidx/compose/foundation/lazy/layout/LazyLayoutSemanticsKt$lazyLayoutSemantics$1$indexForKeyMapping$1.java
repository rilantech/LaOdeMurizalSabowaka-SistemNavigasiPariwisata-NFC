package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "needle", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutSemantics.kt */
final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1 extends Lambda implements Function1<Object, Integer> {
    final /* synthetic */ Function0<LazyLayoutItemProvider> $itemProviderLambda;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1(Function0<? extends LazyLayoutItemProvider> function0) {
        super(1);
        this.$itemProviderLambda = function0;
    }

    public final Integer invoke(Object needle) {
        Intrinsics.checkNotNullParameter(needle, "needle");
        LazyLayoutItemProvider itemProvider = this.$itemProviderLambda.invoke();
        int result = -1;
        int index = 0;
        int itemCount = itemProvider.getItemCount();
        while (true) {
            if (index >= itemCount) {
                break;
            } else if (Intrinsics.areEqual(itemProvider.getKey(index), needle)) {
                result = index;
                break;
            } else {
                index++;
            }
        }
        return Integer.valueOf(result);
    }
}

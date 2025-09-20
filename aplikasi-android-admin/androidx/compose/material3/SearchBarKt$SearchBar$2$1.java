package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.kt */
final class SearchBarKt$SearchBar$2$1 extends Lambda implements Function1<WindowInsets, Unit> {
    final /* synthetic */ MutableWindowInsets $unconsumedInsets;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBarKt$SearchBar$2$1(MutableWindowInsets mutableWindowInsets, WindowInsets windowInsets) {
        super(1);
        this.$unconsumedInsets = mutableWindowInsets;
        this.$windowInsets = windowInsets;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((WindowInsets) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(WindowInsets consumedInsets) {
        Intrinsics.checkNotNullParameter(consumedInsets, "consumedInsets");
        this.$unconsumedInsets.setInsets(WindowInsetsKt.exclude(this.$windowInsets, consumedInsets));
    }
}

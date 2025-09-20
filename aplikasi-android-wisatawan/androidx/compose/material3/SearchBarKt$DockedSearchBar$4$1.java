package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.kt */
final class SearchBarKt$DockedSearchBar$4$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $onActiveChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBarKt$DockedSearchBar$4$1(Function1<? super Boolean, Unit> function1) {
        super(0);
        this.$onActiveChange = function1;
    }

    public final void invoke() {
        this.$onActiveChange.invoke(false);
    }
}

package androidx.compose.material3;

import androidx.compose.foundation.text.KeyboardActionScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.kt */
final class SearchBarKt$SearchBarInputField$4$1 extends Lambda implements Function1<KeyboardActionScope, Unit> {
    final /* synthetic */ Function1<String, Unit> $onSearch;
    final /* synthetic */ String $query;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBarKt$SearchBarInputField$4$1(Function1<? super String, Unit> function1, String str) {
        super(1);
        this.$onSearch = function1;
        this.$query = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((KeyboardActionScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(KeyboardActionScope $this$$receiver) {
        Intrinsics.checkNotNullParameter($this$$receiver, "$this$$receiver");
        this.$onSearch.invoke(this.$query);
    }
}

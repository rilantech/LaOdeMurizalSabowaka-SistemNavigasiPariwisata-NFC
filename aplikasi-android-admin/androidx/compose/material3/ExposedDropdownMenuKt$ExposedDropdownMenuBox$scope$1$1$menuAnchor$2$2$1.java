package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ Function1<Boolean, Unit> $onExpandedChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2$2$1(Function1<? super Boolean, Unit> function1, boolean z) {
        super(0);
        this.$onExpandedChange = function1;
        this.$expanded = z;
    }

    public final void invoke() {
        this.$onExpandedChange.invoke(Boolean.valueOf(!this.$expanded));
    }
}

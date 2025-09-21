package androidx.compose.material3;

import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.kt */
final class SearchBarKt$SearchBarInputField$3$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ boolean $active;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ String $searchSemantics;
    final /* synthetic */ String $suggestionsAvailableSemantics;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBarKt$SearchBarInputField$3$1(String str, boolean z, String str2, FocusRequester focusRequester) {
        super(1);
        this.$searchSemantics = str;
        this.$active = z;
        this.$suggestionsAvailableSemantics = str2;
        this.$focusRequester = focusRequester;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription($this$semantics, this.$searchSemantics);
        if (this.$active) {
            SemanticsPropertiesKt.setStateDescription($this$semantics, this.$suggestionsAvailableSemantics);
        }
        final FocusRequester focusRequester = this.$focusRequester;
        SemanticsPropertiesKt.onClick$default($this$semantics, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                focusRequester.requestFocus();
                return true;
            }
        }, 1, (Object) null);
    }
}

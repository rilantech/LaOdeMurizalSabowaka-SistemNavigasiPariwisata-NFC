package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TooltipPopup.android.kt */
final class TooltipPopup_androidKt$TooltipPopup$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ PopupPositionProvider $popupPositionProvider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TooltipPopup_androidKt$TooltipPopup$1(PopupPositionProvider popupPositionProvider, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$popupPositionProvider = popupPositionProvider;
        this.$onDismissRequest = function0;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TooltipPopup_androidKt.TooltipPopup(this.$popupPositionProvider, this.$onDismissRequest, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}

package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "pointerIcon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerIcon.kt */
final class PointerIconKt$pointerHoverIcon$2$onSetIcon$1 extends Lambda implements Function1<PointerIcon, Unit> {
    final /* synthetic */ PointerIconService $pointerIconService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PointerIconKt$pointerHoverIcon$2$onSetIcon$1(PointerIconService pointerIconService) {
        super(1);
        this.$pointerIconService = pointerIconService;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((PointerIcon) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(PointerIcon pointerIcon) {
        this.$pointerIconService.setIcon(pointerIcon);
    }
}

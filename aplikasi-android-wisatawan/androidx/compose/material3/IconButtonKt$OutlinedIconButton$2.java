package androidx.compose.material3;

import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: IconButton.kt */
final class IconButtonKt$OutlinedIconButton$2 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    public static final IconButtonKt$OutlinedIconButton$2 INSTANCE = new IconButtonKt$OutlinedIconButton$2();

    IconButtonKt$OutlinedIconButton$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        SemanticsPropertiesKt.m5176setRolekuIjeqM($this$semantics, Role.Companion.m5162getButtono7Vup1c());
    }
}

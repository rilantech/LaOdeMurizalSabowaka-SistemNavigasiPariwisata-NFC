package androidx.compose.foundation.selection;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.selection.SelectableKt$selectable-XHw0xAI$$inlined$debugInspectorInfo$1  reason: invalid class name */
/* compiled from: InspectableValue.kt */
public final class SelectableKt$selectableXHw0xAI$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ Function0 $onClick$inlined;
    final /* synthetic */ Role $role$inlined;
    final /* synthetic */ boolean $selected$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableKt$selectableXHw0xAI$$inlined$debugInspectorInfo$1(boolean z, boolean z2, Role role, Function0 function0) {
        super(1);
        this.$selected$inlined = z;
        this.$enabled$inlined = z2;
        this.$role$inlined = role;
        this.$onClick$inlined = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        InspectorInfo $this$selectable_XHw0xAI_u24lambda_u240 = $this$null;
        $this$selectable_XHw0xAI_u24lambda_u240.setName("selectable");
        $this$selectable_XHw0xAI_u24lambda_u240.getProperties().set("selected", Boolean.valueOf(this.$selected$inlined));
        $this$selectable_XHw0xAI_u24lambda_u240.getProperties().set("enabled", Boolean.valueOf(this.$enabled$inlined));
        $this$selectable_XHw0xAI_u24lambda_u240.getProperties().set("role", this.$role$inlined);
        $this$selectable_XHw0xAI_u24lambda_u240.getProperties().set("onClick", this.$onClick$inlined);
    }
}

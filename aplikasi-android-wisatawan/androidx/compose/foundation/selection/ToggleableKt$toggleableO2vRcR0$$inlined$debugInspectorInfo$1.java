package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.selection.ToggleableKt$toggleable-O2vRcR0$$inlined$debugInspectorInfo$1  reason: invalid class name */
/* compiled from: InspectableValue.kt */
public final class ToggleableKt$toggleableO2vRcR0$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ Indication $indication$inlined;
    final /* synthetic */ MutableInteractionSource $interactionSource$inlined;
    final /* synthetic */ Function1 $onValueChange$inlined;
    final /* synthetic */ Role $role$inlined;
    final /* synthetic */ boolean $value$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToggleableKt$toggleableO2vRcR0$$inlined$debugInspectorInfo$1(boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, Function1 function1) {
        super(1);
        this.$value$inlined = z;
        this.$interactionSource$inlined = mutableInteractionSource;
        this.$indication$inlined = indication;
        this.$enabled$inlined = z2;
        this.$role$inlined = role;
        this.$onValueChange$inlined = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        InspectorInfo $this$toggleable_O2vRcR0_u24lambda_u241 = $this$null;
        $this$toggleable_O2vRcR0_u24lambda_u241.setName("toggleable");
        $this$toggleable_O2vRcR0_u24lambda_u241.getProperties().set("value", Boolean.valueOf(this.$value$inlined));
        $this$toggleable_O2vRcR0_u24lambda_u241.getProperties().set("interactionSource", this.$interactionSource$inlined);
        $this$toggleable_O2vRcR0_u24lambda_u241.getProperties().set("indication", this.$indication$inlined);
        $this$toggleable_O2vRcR0_u24lambda_u241.getProperties().set("enabled", Boolean.valueOf(this.$enabled$inlined));
        $this$toggleable_O2vRcR0_u24lambda_u241.getProperties().set("role", this.$role$inlined);
        $this$toggleable_O2vRcR0_u24lambda_u241.getProperties().set("onValueChange", this.$onValueChange$inlined);
    }
}

package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B<\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\f\u0010\u0017\u001a\u00020\r*\u00020\u0018H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\u0004\u0018\u00010\nX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/ClickableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ClickableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableElement extends ModifierNodeElement<ClickableNode> {
    private final boolean enabled;
    private final MutableInteractionSource interactionSource;
    private final Function0<Unit> onClick;
    private final String onClickLabel;
    private final Role role;

    public /* synthetic */ ClickableElement(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role2, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, z, str, role2, function0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ClickableElement(androidx.compose.foundation.interaction.MutableInteractionSource r8, boolean r9, java.lang.String r10, androidx.compose.ui.semantics.Role r11, kotlin.jvm.functions.Function0 r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r13 = r13 & 8
            if (r13 == 0) goto L_0x0007
            r11 = 0
            r4 = r11
            goto L_0x0008
        L_0x0007:
            r4 = r11
        L_0x0008:
            r6 = 0
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableElement.<init>(androidx.compose.foundation.interaction.MutableInteractionSource, boolean, java.lang.String, androidx.compose.ui.semantics.Role, kotlin.jvm.functions.Function0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private ClickableElement(MutableInteractionSource interactionSource2, boolean enabled2, String onClickLabel2, Role role2, Function0<Unit> onClick2) {
        Intrinsics.checkNotNullParameter(interactionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick2, "onClick");
        this.interactionSource = interactionSource2;
        this.enabled = enabled2;
        this.onClickLabel = onClickLabel2;
        this.role = role2;
        this.onClick = onClick2;
    }

    public ClickableNode create() {
        return new ClickableNode(this.interactionSource, this.enabled, this.onClickLabel, this.role, this.onClick, (DefaultConstructorMarker) null);
    }

    public void update(ClickableNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.m209updateXHw0xAI(this.interactionSource, this.enabled, this.onClickLabel, this.role, this.onClick);
    }

    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.compose.foundation.ClickableElement");
        ClickableElement clickableElement = (ClickableElement) other;
        if (Intrinsics.areEqual((Object) this.interactionSource, (Object) ((ClickableElement) other).interactionSource) && this.enabled == ((ClickableElement) other).enabled && Intrinsics.areEqual((Object) this.onClickLabel, (Object) ((ClickableElement) other).onClickLabel) && Intrinsics.areEqual((Object) this.role, (Object) ((ClickableElement) other).role) && Intrinsics.areEqual((Object) this.onClick, (Object) ((ClickableElement) other).onClick)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = ((this.interactionSource.hashCode() * 31) + Boolean.hashCode(this.enabled)) * 31;
        String str = this.onClickLabel;
        int i = 0;
        int result2 = (result + (str != null ? str.hashCode() : 0)) * 31;
        Role role2 = this.role;
        if (role2 != null) {
            i = Role.m5159hashCodeimpl(role2.m5161unboximpl());
        }
        return ((result2 + i) * 31) + this.onClick.hashCode();
    }
}

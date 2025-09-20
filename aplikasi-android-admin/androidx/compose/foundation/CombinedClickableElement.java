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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bf\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fø\u0001\u0000¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\f\u0010\u001a\u001a\u00020\r*\u00020\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\u0004\u0018\u00010\nX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/CombinedClickableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/CombinedClickableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "onLongClick", "onDoubleClick", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class CombinedClickableElement extends ModifierNodeElement<CombinedClickableNode> {
    private final boolean enabled;
    private final MutableInteractionSource interactionSource;
    private final Function0<Unit> onClick;
    private final String onClickLabel;
    private final Function0<Unit> onDoubleClick;
    private final Function0<Unit> onLongClick;
    private final String onLongClickLabel;
    private final Role role;

    public /* synthetic */ CombinedClickableElement(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role2, Function0 function0, String str2, Function0 function02, Function0 function03, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, z, str, role2, function0, str2, function02, function03);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CombinedClickableElement(androidx.compose.foundation.interaction.MutableInteractionSource r12, boolean r13, java.lang.String r14, androidx.compose.ui.semantics.Role r15, kotlin.jvm.functions.Function0 r16, java.lang.String r17, kotlin.jvm.functions.Function0 r18, kotlin.jvm.functions.Function0 r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20 & 8
            if (r0 == 0) goto L_0x0007
            r0 = 0
            r5 = r0
            goto L_0x0008
        L_0x0007:
            r5 = r15
        L_0x0008:
            r10 = 0
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.CombinedClickableElement.<init>(androidx.compose.foundation.interaction.MutableInteractionSource, boolean, java.lang.String, androidx.compose.ui.semantics.Role, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private CombinedClickableElement(MutableInteractionSource interactionSource2, boolean enabled2, String onClickLabel2, Role role2, Function0<Unit> onClick2, String onLongClickLabel2, Function0<Unit> onLongClick2, Function0<Unit> onDoubleClick2) {
        Intrinsics.checkNotNullParameter(interactionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick2, "onClick");
        this.interactionSource = interactionSource2;
        this.enabled = enabled2;
        this.onClickLabel = onClickLabel2;
        this.role = role2;
        this.onClick = onClick2;
        this.onLongClickLabel = onLongClickLabel2;
        this.onLongClick = onLongClick2;
        this.onDoubleClick = onDoubleClick2;
    }

    public CombinedClickableNode create() {
        return new CombinedClickableNode(this.interactionSource, this.enabled, this.onClickLabel, this.role, this.onClick, this.onLongClickLabel, this.onLongClick, this.onDoubleClick, (DefaultConstructorMarker) null);
    }

    public void update(CombinedClickableNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.m1928updatecJG_KMw(this.interactionSource, this.enabled, this.onClickLabel, this.role, this.onClick, this.onLongClickLabel, this.onLongClick, this.onDoubleClick);
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
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.compose.foundation.CombinedClickableElement");
        CombinedClickableElement combinedClickableElement = (CombinedClickableElement) other;
        if (Intrinsics.areEqual((Object) this.interactionSource, (Object) ((CombinedClickableElement) other).interactionSource) && this.enabled == ((CombinedClickableElement) other).enabled && Intrinsics.areEqual((Object) this.onClickLabel, (Object) ((CombinedClickableElement) other).onClickLabel) && Intrinsics.areEqual((Object) this.role, (Object) ((CombinedClickableElement) other).role) && Intrinsics.areEqual((Object) this.onClick, (Object) ((CombinedClickableElement) other).onClick) && Intrinsics.areEqual((Object) this.onLongClickLabel, (Object) ((CombinedClickableElement) other).onLongClickLabel) && Intrinsics.areEqual((Object) this.onLongClick, (Object) ((CombinedClickableElement) other).onLongClick) && Intrinsics.areEqual((Object) this.onDoubleClick, (Object) ((CombinedClickableElement) other).onDoubleClick)) {
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
        int result3 = (((result2 + (role2 != null ? Role.m6869hashCodeimpl(role2.m6871unboximpl()) : 0)) * 31) + this.onClick.hashCode()) * 31;
        String str2 = this.onLongClickLabel;
        int result4 = (result3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Function0<Unit> function0 = this.onLongClick;
        int result5 = (result4 + (function0 != null ? function0.hashCode() : 0)) * 31;
        Function0<Unit> function02 = this.onDoubleClick;
        if (function02 != null) {
            i = function02.hashCode();
        }
        return result5 + i;
    }
}

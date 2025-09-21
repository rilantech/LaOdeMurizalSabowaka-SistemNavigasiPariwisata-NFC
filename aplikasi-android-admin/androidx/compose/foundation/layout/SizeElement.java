package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0013\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\f\u0010\u0019\u001a\u00020\r*\u00020\fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/layout/SizeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/SizeNode;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
final class SizeElement extends ModifierNodeElement<SizeNode> {
    private final boolean enforceIncoming;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final float maxHeight;
    private final float maxWidth;
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ SizeElement(float f, float f2, float f3, float f4, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z, function1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SizeElement(float r10, float r11, float r12, float r13, boolean r14, kotlin.jvm.functions.Function1 r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 1
            if (r0 == 0) goto L_0x000c
            androidx.compose.ui.unit.Dp$Companion r0 = androidx.compose.ui.unit.Dp.Companion
            float r0 = r0.m7574getUnspecifiedD9Ej5fM()
            r2 = r0
            goto L_0x000d
        L_0x000c:
            r2 = r10
        L_0x000d:
            r0 = r16 & 2
            if (r0 == 0) goto L_0x0019
            androidx.compose.ui.unit.Dp$Companion r0 = androidx.compose.ui.unit.Dp.Companion
            float r0 = r0.m7574getUnspecifiedD9Ej5fM()
            r3 = r0
            goto L_0x001a
        L_0x0019:
            r3 = r11
        L_0x001a:
            r0 = r16 & 4
            if (r0 == 0) goto L_0x0026
            androidx.compose.ui.unit.Dp$Companion r0 = androidx.compose.ui.unit.Dp.Companion
            float r0 = r0.m7574getUnspecifiedD9Ej5fM()
            r4 = r0
            goto L_0x0027
        L_0x0026:
            r4 = r12
        L_0x0027:
            r0 = r16 & 8
            if (r0 == 0) goto L_0x0033
            androidx.compose.ui.unit.Dp$Companion r0 = androidx.compose.ui.unit.Dp.Companion
            float r0 = r0.m7574getUnspecifiedD9Ej5fM()
            r5 = r0
            goto L_0x0034
        L_0x0033:
            r5 = r13
        L_0x0034:
            r8 = 0
            r1 = r9
            r6 = r14
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.SizeElement.<init>(float, float, float, float, boolean, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private SizeElement(float minWidth2, float minHeight2, float maxWidth2, float maxHeight2, boolean enforceIncoming2, Function1<? super InspectorInfo, Unit> inspectorInfo2) {
        Intrinsics.checkNotNullParameter(inspectorInfo2, "inspectorInfo");
        this.minWidth = minWidth2;
        this.minHeight = minHeight2;
        this.maxWidth = maxWidth2;
        this.maxHeight = maxHeight2;
        this.enforceIncoming = enforceIncoming2;
        this.inspectorInfo = inspectorInfo2;
    }

    public SizeNode create() {
        return new SizeNode(this.minWidth, this.minHeight, this.maxWidth, this.maxHeight, this.enforceIncoming, (DefaultConstructorMarker) null);
    }

    public void update(SizeNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.m2339setMinWidth0680j_4(this.minWidth);
        node.m2338setMinHeight0680j_4(this.minHeight);
        node.m2337setMaxWidth0680j_4(this.maxWidth);
        node.m2336setMaxHeight0680j_4(this.maxHeight);
        node.setEnforceIncoming(this.enforceIncoming);
    }

    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
        this.inspectorInfo.invoke($this$inspectableProperties);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof SizeElement) && Dp.m7559equalsimpl0(this.minWidth, ((SizeElement) other).minWidth) && Dp.m7559equalsimpl0(this.minHeight, ((SizeElement) other).minHeight) && Dp.m7559equalsimpl0(this.maxWidth, ((SizeElement) other).maxWidth) && Dp.m7559equalsimpl0(this.maxHeight, ((SizeElement) other).maxHeight) && this.enforceIncoming == ((SizeElement) other).enforceIncoming) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Dp.m7560hashCodeimpl(this.minWidth) * 31) + Dp.m7560hashCodeimpl(this.minHeight)) * 31) + Dp.m7560hashCodeimpl(this.maxWidth)) * 31) + Dp.m7560hashCodeimpl(this.maxHeight)) * 31) + Boolean.hashCode(this.enforceIncoming);
    }
}

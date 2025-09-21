package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\b\u0010!\u001a\u00020\u0002H\u0016J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0002H\u0016J\f\u0010)\u001a\u00020\r*\u00020\fH\u0016R%\u0010\u0007\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R%\u0010\u0006\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR%\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R%\u0010\u0005\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/foundation/layout/PaddingElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/PaddingNode;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM", "()F", "setBottom-0680j_4", "(F)V", "F", "getEnd-D9Ej5fM", "setEnd-0680j_4", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "getRtlAware", "()Z", "setRtlAware", "(Z)V", "getStart-D9Ej5fM", "setStart-0680j_4", "getTop-D9Ej5fM", "setTop-0680j_4", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Padding.kt */
final class PaddingElement extends ModifierNodeElement<PaddingNode> {
    private float bottom;
    private float end;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private boolean rtlAware;
    private float start;
    private float top;

    public /* synthetic */ PaddingElement(float f, float f2, float f3, float f4, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z, function1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaddingElement(float r10, float r11, float r12, float r13, boolean r14, kotlin.jvm.functions.Function1 r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 1
            if (r0 == 0) goto L_0x000d
            r0 = 0
            r1 = 0
            float r2 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r2)
            r2 = r0
            goto L_0x000e
        L_0x000d:
            r2 = r10
        L_0x000e:
            r0 = r16 & 2
            if (r0 == 0) goto L_0x001b
            r0 = 0
            r1 = 0
            float r3 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r3)
            r3 = r0
            goto L_0x001c
        L_0x001b:
            r3 = r11
        L_0x001c:
            r0 = r16 & 4
            if (r0 == 0) goto L_0x0029
            r0 = 0
            r1 = 0
            float r4 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r4)
            r4 = r0
            goto L_0x002a
        L_0x0029:
            r4 = r12
        L_0x002a:
            r0 = r16 & 8
            if (r0 == 0) goto L_0x0037
            r0 = 0
            r1 = 0
            float r5 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r5)
            r5 = r0
            goto L_0x0038
        L_0x0037:
            r5 = r13
        L_0x0038:
            r8 = 0
            r1 = r9
            r6 = r14
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.PaddingElement.<init>(float, float, float, float, boolean, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getStart-D9Ej5fM  reason: not valid java name */
    public final float m2235getStartD9Ej5fM() {
        return this.start;
    }

    /* renamed from: setStart-0680j_4  reason: not valid java name */
    public final void m2239setStart0680j_4(float f) {
        this.start = f;
    }

    /* renamed from: getTop-D9Ej5fM  reason: not valid java name */
    public final float m2236getTopD9Ej5fM() {
        return this.top;
    }

    /* renamed from: setTop-0680j_4  reason: not valid java name */
    public final void m2240setTop0680j_4(float f) {
        this.top = f;
    }

    /* renamed from: getEnd-D9Ej5fM  reason: not valid java name */
    public final float m2234getEndD9Ej5fM() {
        return this.end;
    }

    /* renamed from: setEnd-0680j_4  reason: not valid java name */
    public final void m2238setEnd0680j_4(float f) {
        this.end = f;
    }

    /* renamed from: getBottom-D9Ej5fM  reason: not valid java name */
    public final float m2233getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* renamed from: setBottom-0680j_4  reason: not valid java name */
    public final void m2237setBottom0680j_4(float f) {
        this.bottom = f;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    public final void setRtlAware(boolean z) {
        this.rtlAware = z;
    }

    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private PaddingElement(float r4, float r5, float r6, float r7, boolean r8, kotlin.jvm.functions.Function1<? super androidx.compose.ui.platform.InspectorInfo, kotlin.Unit> r9) {
        /*
            r3 = this;
            java.lang.String r0 = "inspectorInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r3.<init>()
            r3.start = r4
            r3.top = r5
            r3.end = r6
            r3.bottom = r7
            r3.rtlAware = r8
            r3.inspectorInfo = r9
            r0 = 0
            int r1 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x0027
            androidx.compose.ui.unit.Dp$Companion r1 = androidx.compose.ui.unit.Dp.Companion
            float r1 = r1.m7574getUnspecifiedD9Ej5fM()
            boolean r1 = androidx.compose.ui.unit.Dp.m7559equalsimpl0(r4, r1)
            if (r1 == 0) goto L_0x005e
        L_0x0027:
            float r1 = r3.top
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0039
            androidx.compose.ui.unit.Dp$Companion r2 = androidx.compose.ui.unit.Dp.Companion
            float r2 = r2.m7574getUnspecifiedD9Ej5fM()
            boolean r1 = androidx.compose.ui.unit.Dp.m7559equalsimpl0(r1, r2)
            if (r1 == 0) goto L_0x005e
        L_0x0039:
            float r1 = r3.end
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x004b
            androidx.compose.ui.unit.Dp$Companion r2 = androidx.compose.ui.unit.Dp.Companion
            float r2 = r2.m7574getUnspecifiedD9Ej5fM()
            boolean r1 = androidx.compose.ui.unit.Dp.m7559equalsimpl0(r1, r2)
            if (r1 == 0) goto L_0x005e
        L_0x004b:
            float r1 = r3.bottom
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0060
            androidx.compose.ui.unit.Dp$Companion r0 = androidx.compose.ui.unit.Dp.Companion
            float r0 = r0.m7574getUnspecifiedD9Ej5fM()
            boolean r0 = androidx.compose.ui.unit.Dp.m7559equalsimpl0(r1, r0)
            if (r0 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r0 = 0
            goto L_0x0061
        L_0x0060:
            r0 = 1
        L_0x0061:
            if (r0 == 0) goto L_0x0065
            return
        L_0x0065:
            r0 = 0
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Padding must be non-negative"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.PaddingElement.<init>(float, float, float, float, boolean, kotlin.jvm.functions.Function1):void");
    }

    public PaddingNode create() {
        return new PaddingNode(this.start, this.top, this.end, this.bottom, this.rtlAware, (DefaultConstructorMarker) null);
    }

    public void update(PaddingNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.m2260setStart0680j_4(this.start);
        node.m2261setTop0680j_4(this.top);
        node.m2259setEnd0680j_4(this.end);
        node.m2258setBottom0680j_4(this.bottom);
        node.setRtlAware(this.rtlAware);
    }

    public int hashCode() {
        return (((((((Dp.m7560hashCodeimpl(this.start) * 31) + Dp.m7560hashCodeimpl(this.top)) * 31) + Dp.m7560hashCodeimpl(this.end)) * 31) + Dp.m7560hashCodeimpl(this.bottom)) * 31) + Boolean.hashCode(this.rtlAware);
    }

    public boolean equals(Object other) {
        PaddingElement otherModifierElement = other instanceof PaddingElement ? (PaddingElement) other : null;
        if (otherModifierElement != null && Dp.m7559equalsimpl0(this.start, otherModifierElement.start) && Dp.m7559equalsimpl0(this.top, otherModifierElement.top) && Dp.m7559equalsimpl0(this.end, otherModifierElement.end) && Dp.m7559equalsimpl0(this.bottom, otherModifierElement.bottom) && this.rtlAware == otherModifierElement.rtlAware) {
            return true;
        }
        return false;
    }

    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
        this.inspectorInfo.invoke($this$inspectableProperties);
    }
}

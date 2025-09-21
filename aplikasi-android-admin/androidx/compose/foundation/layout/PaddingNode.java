package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B8\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\nJ)\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"R%\u0010\u0007\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR%\u0010\u0006\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R%\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR%\u0010\u0005\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/foundation/layout/PaddingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM", "()F", "setBottom-0680j_4", "(F)V", "F", "getEnd-D9Ej5fM", "setEnd-0680j_4", "getRtlAware", "()Z", "setRtlAware", "(Z)V", "getStart-D9Ej5fM", "setStart-0680j_4", "getTop-D9Ej5fM", "setTop-0680j_4", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Padding.kt */
final class PaddingNode extends Modifier.Node implements LayoutModifierNode {
    private float bottom;
    private float end;
    private boolean rtlAware;
    private float start;
    private float top;

    public /* synthetic */ PaddingNode(float f, float f2, float f3, float f4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaddingNode(float r8, float r9, float r10, float r11, boolean r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x000d
            r8 = 0
            r14 = 0
            float r0 = (float) r8
            float r8 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r0)
            r1 = r8
            goto L_0x000e
        L_0x000d:
            r1 = r8
        L_0x000e:
            r8 = r13 & 2
            if (r8 == 0) goto L_0x001b
            r8 = 0
            r9 = 0
            float r14 = (float) r8
            float r9 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r14)
            r2 = r9
            goto L_0x001c
        L_0x001b:
            r2 = r9
        L_0x001c:
            r8 = r13 & 4
            if (r8 == 0) goto L_0x0029
            r8 = 0
            r9 = 0
            float r10 = (float) r8
            float r10 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r10)
            r3 = r10
            goto L_0x002a
        L_0x0029:
            r3 = r10
        L_0x002a:
            r8 = r13 & 8
            if (r8 == 0) goto L_0x0037
            r8 = 0
            r9 = 0
            float r10 = (float) r8
            float r11 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r10)
            r4 = r11
            goto L_0x0038
        L_0x0037:
            r4 = r11
        L_0x0038:
            r6 = 0
            r0 = r7
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.PaddingNode.<init>(float, float, float, float, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getStart-D9Ej5fM  reason: not valid java name */
    public final float m2255getStartD9Ej5fM() {
        return this.start;
    }

    /* renamed from: setStart-0680j_4  reason: not valid java name */
    public final void m2260setStart0680j_4(float f) {
        this.start = f;
    }

    /* renamed from: getTop-D9Ej5fM  reason: not valid java name */
    public final float m2256getTopD9Ej5fM() {
        return this.top;
    }

    /* renamed from: setTop-0680j_4  reason: not valid java name */
    public final void m2261setTop0680j_4(float f) {
        this.top = f;
    }

    /* renamed from: getEnd-D9Ej5fM  reason: not valid java name */
    public final float m2254getEndD9Ej5fM() {
        return this.end;
    }

    /* renamed from: setEnd-0680j_4  reason: not valid java name */
    public final void m2259setEnd0680j_4(float f) {
        this.end = f;
    }

    /* renamed from: getBottom-D9Ej5fM  reason: not valid java name */
    public final float m2253getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* renamed from: setBottom-0680j_4  reason: not valid java name */
    public final void m2258setBottom0680j_4(float f) {
        this.bottom = f;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    public final void setRtlAware(boolean z) {
        this.rtlAware = z;
    }

    private PaddingNode(float start2, float top2, float end2, float bottom2, boolean rtlAware2) {
        this.start = start2;
        this.top = top2;
        this.end = end2;
        this.bottom = bottom2;
        this.rtlAware = rtlAware2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2257measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        MeasureScope measureScope = $this$measure_u2d3p2s80s;
        Measurable measurable2 = measurable;
        long j = constraints;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable2, "measurable");
        int horizontal = measureScope.m7529roundToPx0680j_4(this.start) + measureScope.m7529roundToPx0680j_4(this.end);
        int vertical = measureScope.m7529roundToPx0680j_4(this.top) + measureScope.m7529roundToPx0680j_4(this.bottom);
        Placeable placeable = measurable2.m6399measureBRTryo0(ConstraintsKt.m7514offsetNN6EwU(j, -horizontal, -vertical));
        int width = ConstraintsKt.m7512constrainWidthK40F9xA(j, placeable.getWidth() + horizontal);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, width, ConstraintsKt.m7511constrainHeightK40F9xA(j, placeable.getHeight() + vertical), (Map) null, new PaddingNode$measure$1(this, placeable, measureScope), 4, (Object) null);
    }
}

package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B8\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001c\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020 H\u0016J\u001c\u0010%\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020 H\u0016J)\u0010'\u001a\u00020(*\u00020)2\u0006\u0010\"\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001bH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001c\u0010.\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020 H\u0016J\u001c\u0010/\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020 H\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR%\u0010\u0007\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R%\u0010\u0006\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R%\u0010\u0005\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R%\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R!\u0010\u001a\u001a\u00020\u001b*\u00020\u001c8BX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/SizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "getMaxHeight-D9Ej5fM", "()F", "setMaxHeight-0680j_4", "(F)V", "F", "getMaxWidth-D9Ej5fM", "setMaxWidth-0680j_4", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "getMinWidth-D9Ej5fM", "setMinWidth-0680j_4", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SizeNode(float r8, float r9, float r10, float r11, boolean r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x000c
            androidx.compose.ui.unit.Dp$Companion r8 = androidx.compose.ui.unit.Dp.Companion
            float r8 = r8.m5864getUnspecifiedD9Ej5fM()
            r1 = r8
            goto L_0x000d
        L_0x000c:
            r1 = r8
        L_0x000d:
            r8 = r13 & 2
            if (r8 == 0) goto L_0x0019
            androidx.compose.ui.unit.Dp$Companion r8 = androidx.compose.ui.unit.Dp.Companion
            float r9 = r8.m5864getUnspecifiedD9Ej5fM()
            r2 = r9
            goto L_0x001a
        L_0x0019:
            r2 = r9
        L_0x001a:
            r8 = r13 & 4
            if (r8 == 0) goto L_0x0026
            androidx.compose.ui.unit.Dp$Companion r8 = androidx.compose.ui.unit.Dp.Companion
            float r10 = r8.m5864getUnspecifiedD9Ej5fM()
            r3 = r10
            goto L_0x0027
        L_0x0026:
            r3 = r10
        L_0x0027:
            r8 = r13 & 8
            if (r8 == 0) goto L_0x0033
            androidx.compose.ui.unit.Dp$Companion r8 = androidx.compose.ui.unit.Dp.Companion
            float r11 = r8.m5864getUnspecifiedD9Ej5fM()
            r4 = r11
            goto L_0x0034
        L_0x0033:
            r4 = r11
        L_0x0034:
            r6 = 0
            r0 = r7
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.SizeNode.<init>(float, float, float, float, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m624getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    /* renamed from: setMinWidth-0680j_4  reason: not valid java name */
    public final void m629setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m623getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* renamed from: setMinHeight-0680j_4  reason: not valid java name */
    public final void m628setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* renamed from: getMaxWidth-D9Ej5fM  reason: not valid java name */
    public final float m622getMaxWidthD9Ej5fM() {
        return this.maxWidth;
    }

    /* renamed from: setMaxWidth-0680j_4  reason: not valid java name */
    public final void m627setMaxWidth0680j_4(float f) {
        this.maxWidth = f;
    }

    /* renamed from: getMaxHeight-D9Ej5fM  reason: not valid java name */
    public final float m621getMaxHeightD9Ej5fM() {
        return this.maxHeight;
    }

    /* renamed from: setMaxHeight-0680j_4  reason: not valid java name */
    public final void m626setMaxHeight0680j_4(float f) {
        this.maxHeight = f;
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    public final void setEnforceIncoming(boolean z) {
        this.enforceIncoming = z;
    }

    private SizeNode(float minWidth2, float minHeight2, float maxWidth2, float maxHeight2, boolean enforceIncoming2) {
        this.minWidth = minWidth2;
        this.minHeight = minHeight2;
        this.maxWidth = maxWidth2;
        this.maxHeight = maxHeight2;
        this.enforceIncoming = enforceIncoming2;
    }

    /* renamed from: getTargetConstraints-OenEA2s  reason: not valid java name */
    private final long m620getTargetConstraintsOenEA2s(Density $this$targetConstraints) {
        int maxWidth2;
        int maxHeight2;
        int it;
        int it2;
        int minHeight2 = 0;
        if (!Dp.m5849equalsimpl0(this.maxWidth, Dp.Companion.m5864getUnspecifiedD9Ej5fM())) {
            maxWidth2 = RangesKt.coerceAtLeast($this$targetConstraints.m5819roundToPx0680j_4(this.maxWidth), 0);
        } else {
            maxWidth2 = Integer.MAX_VALUE;
        }
        if (!Dp.m5849equalsimpl0(this.maxHeight, Dp.Companion.m5864getUnspecifiedD9Ej5fM())) {
            maxHeight2 = RangesKt.coerceAtLeast($this$targetConstraints.m5819roundToPx0680j_4(this.maxHeight), 0);
        } else {
            maxHeight2 = Integer.MAX_VALUE;
        }
        if (!Dp.m5849equalsimpl0(this.minWidth, Dp.Companion.m5864getUnspecifiedD9Ej5fM())) {
            it = RangesKt.coerceAtLeast(RangesKt.coerceAtMost($this$targetConstraints.m5819roundToPx0680j_4(this.minWidth), maxWidth2), 0);
            if (it == Integer.MAX_VALUE) {
                it = 0;
            }
        } else {
            it = 0;
        }
        if (!Dp.m5849equalsimpl0(this.minHeight, Dp.Companion.m5864getUnspecifiedD9Ej5fM()) && (it2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost($this$targetConstraints.m5819roundToPx0680j_4(this.minHeight), maxHeight2), 0)) != Integer.MAX_VALUE) {
            minHeight2 = it2;
        }
        return ConstraintsKt.Constraints(it, maxWidth2, minHeight2, maxHeight2);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m625measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        long targetConstraints;
        int resolvedMinWidth;
        int resolvedMaxWidth;
        int resolvedMinHeight;
        int resolvedMaxHeight;
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long targetConstraints2 = m620getTargetConstraintsOenEA2s($this$measure_u2d3p2s80s);
        if (this.enforceIncoming) {
            targetConstraints = ConstraintsKt.m5800constrainN9IONVI(constraints, targetConstraints2);
        } else {
            if (!Dp.m5849equalsimpl0(this.minWidth, Dp.Companion.m5864getUnspecifiedD9Ej5fM())) {
                resolvedMinWidth = Constraints.m5790getMinWidthimpl(targetConstraints2);
            } else {
                resolvedMinWidth = RangesKt.coerceAtMost(Constraints.m5790getMinWidthimpl(constraints), Constraints.m5788getMaxWidthimpl(targetConstraints2));
            }
            if (!Dp.m5849equalsimpl0(this.maxWidth, Dp.Companion.m5864getUnspecifiedD9Ej5fM())) {
                resolvedMaxWidth = Constraints.m5788getMaxWidthimpl(targetConstraints2);
            } else {
                resolvedMaxWidth = RangesKt.coerceAtLeast(Constraints.m5788getMaxWidthimpl(constraints), Constraints.m5790getMinWidthimpl(targetConstraints2));
            }
            if (!Dp.m5849equalsimpl0(this.minHeight, Dp.Companion.m5864getUnspecifiedD9Ej5fM())) {
                resolvedMinHeight = Constraints.m5789getMinHeightimpl(targetConstraints2);
            } else {
                resolvedMinHeight = RangesKt.coerceAtMost(Constraints.m5789getMinHeightimpl(constraints), Constraints.m5787getMaxHeightimpl(targetConstraints2));
            }
            if (!Dp.m5849equalsimpl0(this.maxHeight, Dp.Companion.m5864getUnspecifiedD9Ej5fM())) {
                resolvedMaxHeight = Constraints.m5787getMaxHeightimpl(targetConstraints2);
            } else {
                resolvedMaxHeight = RangesKt.coerceAtLeast(Constraints.m5787getMaxHeightimpl(constraints), Constraints.m5789getMinHeightimpl(targetConstraints2));
            }
            targetConstraints = ConstraintsKt.Constraints(resolvedMinWidth, resolvedMaxWidth, resolvedMinHeight, resolvedMaxHeight);
        }
        Placeable placeable = measurable.m4689measureBRTryo0(targetConstraints);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, placeable.getWidth(), placeable.getHeight(), (Map) null, new SizeNode$measure$1(placeable), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long constraints = m620getTargetConstraintsOenEA2s($this$minIntrinsicWidth);
        if (Constraints.m5786getHasFixedWidthimpl(constraints)) {
            return Constraints.m5788getMaxWidthimpl(constraints);
        }
        return ConstraintsKt.m5802constrainWidthK40F9xA(constraints, measurable.minIntrinsicWidth(height));
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long constraints = m620getTargetConstraintsOenEA2s($this$minIntrinsicHeight);
        if (Constraints.m5785getHasFixedHeightimpl(constraints)) {
            return Constraints.m5787getMaxHeightimpl(constraints);
        }
        return ConstraintsKt.m5801constrainHeightK40F9xA(constraints, measurable.minIntrinsicHeight(width));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long constraints = m620getTargetConstraintsOenEA2s($this$maxIntrinsicWidth);
        if (Constraints.m5786getHasFixedWidthimpl(constraints)) {
            return Constraints.m5788getMaxWidthimpl(constraints);
        }
        return ConstraintsKt.m5802constrainWidthK40F9xA(constraints, measurable.maxIntrinsicWidth(height));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long constraints = m620getTargetConstraintsOenEA2s($this$maxIntrinsicHeight);
        if (Constraints.m5785getHasFixedHeightimpl(constraints)) {
            return Constraints.m5787getMaxHeightimpl(constraints);
        }
        return ConstraintsKt.m5801constrainHeightK40F9xA(constraints, measurable.maxIntrinsicHeight(width));
    }
}

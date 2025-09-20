package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u001d\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J\u001d\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00101J\b\u00106\u001a\u000207H\u0016J\f\u00108\u001a\u000209*\u00020:H\u0016J\u0019\u0010;\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010=J\u001c\u0010@\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010F\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016J)\u0010H\u001a\u00020I*\u00020J2\u0006\u0010C\u001a\u00020K2\u0006\u00104\u001a\u000203H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bL\u0010MJ\u001c\u0010N\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010O\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010'\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006P"}, d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "getSizeToIntrinsics", "setSizeToIntrinsics", "(Z)V", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PainterModifier.kt */
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PainterNode(androidx.compose.ui.graphics.painter.Painter r8, boolean r9, androidx.compose.ui.Alignment r10, androidx.compose.ui.layout.ContentScale r11, float r12, androidx.compose.ui.graphics.ColorFilter r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r15 = r14 & 4
            if (r15 == 0) goto L_0x000c
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r10 = r10.getCenter()
            r3 = r10
            goto L_0x000d
        L_0x000c:
            r3 = r10
        L_0x000d:
            r10 = r14 & 8
            if (r10 == 0) goto L_0x0019
            androidx.compose.ui.layout.ContentScale$Companion r10 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r11 = r10.getInside()
            r4 = r11
            goto L_0x001a
        L_0x0019:
            r4 = r11
        L_0x001a:
            r10 = r14 & 16
            if (r10 == 0) goto L_0x0022
            r12 = 1065353216(0x3f800000, float:1.0)
            r5 = r12
            goto L_0x0023
        L_0x0022:
            r5 = r12
        L_0x0023:
            r10 = r14 & 32
            if (r10 == 0) goto L_0x002a
            r13 = 0
            r6 = r13
            goto L_0x002b
        L_0x002a:
            r6 = r13
        L_0x002b:
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.draw.PainterNode.<init>(androidx.compose.ui.graphics.painter.Painter, boolean, androidx.compose.ui.Alignment, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.ColorFilter, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final void setPainter(Painter painter2) {
        Intrinsics.checkNotNullParameter(painter2, "<set-?>");
        this.painter = painter2;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(Alignment alignment2) {
        Intrinsics.checkNotNullParameter(alignment2, "<set-?>");
        this.alignment = alignment2;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale(ContentScale contentScale2) {
        Intrinsics.checkNotNullParameter(contentScale2, "<set-?>");
        this.contentScale = contentScale2;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final void setColorFilter(ColorFilter colorFilter2) {
        this.colorFilter = colorFilter2;
    }

    public PainterNode(Painter painter2, boolean sizeToIntrinsics2, Alignment alignment2, ContentScale contentScale2, float alpha2, ColorFilter colorFilter2) {
        Intrinsics.checkNotNullParameter(painter2, "painter");
        Intrinsics.checkNotNullParameter(alignment2, "alignment");
        Intrinsics.checkNotNullParameter(contentScale2, "contentScale");
        this.painter = painter2;
        this.sizeToIntrinsics = sizeToIntrinsics2;
        this.alignment = alignment2;
        this.contentScale = contentScale2;
        this.alpha = alpha2;
        this.colorFilter = colorFilter2;
    }

    private final boolean getUseIntrinsicSize() {
        if (!this.sizeToIntrinsics) {
            return false;
        }
        return ((this.painter.m3961getIntrinsicSizeNHjbRc() > Size.Companion.m3080getUnspecifiedNHjbRc() ? 1 : (this.painter.m3961getIntrinsicSizeNHjbRc() == Size.Companion.m3080getUnspecifiedNHjbRc() ? 0 : -1)) != 0 ? 1 : 0) != 0;
    }

    public boolean getShouldAutoInvalidate() {
        return false;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2910measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Placeable placeable = measurable.m4689measureBRTryo0(m2909modifyConstraintsZezNO4M(constraints));
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, placeable.getWidth(), placeable.getHeight(), (Map) null, new PainterNode$measure$1(placeable), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return measurable.minIntrinsicWidth(height);
        }
        long constraints = m2909modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, height, 7, (Object) null));
        return Math.max(Constraints.m5790getMinWidthimpl(constraints), measurable.minIntrinsicWidth(height));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return measurable.maxIntrinsicWidth(height);
        }
        long constraints = m2909modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, height, 7, (Object) null));
        return Math.max(Constraints.m5790getMinWidthimpl(constraints), measurable.maxIntrinsicWidth(height));
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return measurable.minIntrinsicHeight(width);
        }
        long constraints = m2909modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, width, 0, 0, 13, (Object) null));
        return Math.max(Constraints.m5789getMinHeightimpl(constraints), measurable.minIntrinsicHeight(width));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return measurable.maxIntrinsicHeight(width);
        }
        long constraints = m2909modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, width, 0, 0, 13, (Object) null));
        return Math.max(Constraints.m5789getMinHeightimpl(constraints), measurable.maxIntrinsicHeight(width));
    }

    /* renamed from: calculateScaledSize-E7KxVPU  reason: not valid java name */
    private final long m2906calculateScaledSizeE7KxVPU(long dstSize) {
        float srcWidth;
        float srcHeight;
        if (!getUseIntrinsicSize()) {
            return dstSize;
        }
        if (!m2908hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.m3961getIntrinsicSizeNHjbRc())) {
            srcWidth = Size.m3072getWidthimpl(dstSize);
        } else {
            srcWidth = Size.m3072getWidthimpl(this.painter.m3961getIntrinsicSizeNHjbRc());
        }
        if (!m2907hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.m3961getIntrinsicSizeNHjbRc())) {
            srcHeight = Size.m3069getHeightimpl(dstSize);
        } else {
            srcHeight = Size.m3069getHeightimpl(this.painter.m3961getIntrinsicSizeNHjbRc());
        }
        long srcSize = SizeKt.Size(srcWidth, srcHeight);
        boolean z = true;
        if (!(Size.m3072getWidthimpl(dstSize) == 0.0f)) {
            if (Size.m3069getHeightimpl(dstSize) != 0.0f) {
                z = false;
            }
            if (!z) {
                return ScaleFactorKt.m4764timesUQTWf7w(srcSize, this.contentScale.m4608computeScaleFactorH7hwNQA(srcSize, dstSize));
            }
        }
        return Size.Companion.m3081getZeroNHjbRc();
    }

    /* renamed from: modifyConstraints-ZezNO4M  reason: not valid java name */
    private final long m2909modifyConstraintsZezNO4M(long constraints) {
        int i;
        int i2;
        long j = constraints;
        boolean z = true;
        boolean hasBoundedDimens = Constraints.m5784getHasBoundedWidthimpl(constraints) && Constraints.m5783getHasBoundedHeightimpl(constraints);
        if (!Constraints.m5786getHasFixedWidthimpl(constraints) || !Constraints.m5785getHasFixedHeightimpl(constraints)) {
            z = false;
        }
        boolean hasFixedDimens = z;
        if ((getUseIntrinsicSize() || !hasBoundedDimens) && !hasFixedDimens) {
            long intrinsicSize = this.painter.m3961getIntrinsicSizeNHjbRc();
            if (m2908hasSpecifiedAndFiniteWidthuvyYCjk(intrinsicSize)) {
                i = MathKt.roundToInt(Size.m3072getWidthimpl(intrinsicSize));
            } else {
                i = Constraints.m5790getMinWidthimpl(constraints);
            }
            int intrinsicWidth = i;
            if (m2907hasSpecifiedAndFiniteHeightuvyYCjk(intrinsicSize)) {
                i2 = MathKt.roundToInt(Size.m3069getHeightimpl(intrinsicSize));
            } else {
                i2 = Constraints.m5789getMinHeightimpl(constraints);
            }
            int intrinsicHeight = i2;
            int constrainedWidth = ConstraintsKt.m5802constrainWidthK40F9xA(j, intrinsicWidth);
            int constrainedHeight = ConstraintsKt.m5801constrainHeightK40F9xA(j, intrinsicHeight);
            long scaledSize = m2906calculateScaledSizeE7KxVPU(SizeKt.Size((float) constrainedWidth, (float) constrainedHeight));
            int i3 = constrainedHeight;
            int i4 = constrainedWidth;
            int i5 = intrinsicHeight;
            return Constraints.m5779copyZbe2FdA$default(constraints, ConstraintsKt.m5802constrainWidthK40F9xA(j, MathKt.roundToInt(Size.m3072getWidthimpl(scaledSize))), 0, ConstraintsKt.m5801constrainHeightK40F9xA(j, MathKt.roundToInt(Size.m3069getHeightimpl(scaledSize))), 0, 10, (Object) null);
        }
        return Constraints.m5779copyZbe2FdA$default(constraints, Constraints.m5788getMaxWidthimpl(constraints), 0, Constraints.m5787getMaxHeightimpl(constraints), 0, 10, (Object) null);
    }

    public void draw(ContentDrawScope $this$draw) {
        float srcWidth;
        float srcHeight;
        long scaledSize;
        ContentDrawScope contentDrawScope = $this$draw;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        long intrinsicSize = this.painter.m3961getIntrinsicSizeNHjbRc();
        if (m2908hasSpecifiedAndFiniteWidthuvyYCjk(intrinsicSize)) {
            srcWidth = Size.m3072getWidthimpl(intrinsicSize);
        } else {
            srcWidth = Size.m3072getWidthimpl($this$draw.m3866getSizeNHjbRc());
        }
        if (m2907hasSpecifiedAndFiniteHeightuvyYCjk(intrinsicSize)) {
            srcHeight = Size.m3069getHeightimpl(intrinsicSize);
        } else {
            srcHeight = Size.m3069getHeightimpl($this$draw.m3866getSizeNHjbRc());
        }
        long srcSize = SizeKt.Size(srcWidth, srcHeight);
        boolean z = true;
        if (!(Size.m3072getWidthimpl($this$draw.m3866getSizeNHjbRc()) == 0.0f)) {
            if (Size.m3069getHeightimpl($this$draw.m3866getSizeNHjbRc()) != 0.0f) {
                z = false;
            }
            if (!z) {
                scaledSize = ScaleFactorKt.m4764timesUQTWf7w(srcSize, this.contentScale.m4608computeScaleFactorH7hwNQA(srcSize, $this$draw.m3866getSizeNHjbRc()));
                long alignedPosition = this.alignment.m2884alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m3072getWidthimpl(scaledSize)), MathKt.roundToInt(Size.m3069getHeightimpl(scaledSize))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m3072getWidthimpl($this$draw.m3866getSizeNHjbRc())), MathKt.roundToInt(Size.m3069getHeightimpl($this$draw.m3866getSizeNHjbRc()))), $this$draw.getLayoutDirection());
                float dx = (float) IntOffset.m5962getXimpl(alignedPosition);
                float dy = (float) IntOffset.m5963getYimpl(alignedPosition);
                DrawScope $this$translate$iv = contentDrawScope;
                $this$translate$iv.getDrawContext().getTransform().translate(dx, dy);
                Painter $this$draw_u24lambda_u241_u24lambda_u240 = this.painter;
                float dy2 = this.alpha;
                long j = intrinsicSize;
                ColorFilter colorFilter2 = this.colorFilter;
                Painter painter2 = $this$draw_u24lambda_u241_u24lambda_u240;
                $this$draw_u24lambda_u241_u24lambda_u240.m3960drawx_KDEd0($this$translate$iv, scaledSize, dy2, colorFilter2);
                $this$translate$iv.getDrawContext().getTransform().translate(-dx, -dy);
                $this$draw.drawContent();
            }
        }
        scaledSize = Size.Companion.m3081getZeroNHjbRc();
        long alignedPosition2 = this.alignment.m2884alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m3072getWidthimpl(scaledSize)), MathKt.roundToInt(Size.m3069getHeightimpl(scaledSize))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m3072getWidthimpl($this$draw.m3866getSizeNHjbRc())), MathKt.roundToInt(Size.m3069getHeightimpl($this$draw.m3866getSizeNHjbRc()))), $this$draw.getLayoutDirection());
        float dx2 = (float) IntOffset.m5962getXimpl(alignedPosition2);
        float dy3 = (float) IntOffset.m5963getYimpl(alignedPosition2);
        DrawScope $this$translate$iv2 = contentDrawScope;
        $this$translate$iv2.getDrawContext().getTransform().translate(dx2, dy3);
        Painter $this$draw_u24lambda_u241_u24lambda_u2402 = this.painter;
        float dy22 = this.alpha;
        long j2 = intrinsicSize;
        ColorFilter colorFilter22 = this.colorFilter;
        Painter painter22 = $this$draw_u24lambda_u241_u24lambda_u2402;
        $this$draw_u24lambda_u241_u24lambda_u2402.m3960drawx_KDEd0($this$translate$iv2, scaledSize, dy22, colorFilter22);
        $this$translate$iv2.getDrawContext().getTransform().translate(-dx2, -dy3);
        $this$draw.drawContent();
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk  reason: not valid java name */
    private final boolean m2908hasSpecifiedAndFiniteWidthuvyYCjk(long $this$hasSpecifiedAndFiniteWidth_u2duvyYCjk) {
        if (Size.m3068equalsimpl0($this$hasSpecifiedAndFiniteWidth_u2duvyYCjk, Size.Companion.m3080getUnspecifiedNHjbRc())) {
            return false;
        }
        float r0 = Size.m3072getWidthimpl($this$hasSpecifiedAndFiniteWidth_u2duvyYCjk);
        return !Float.isInfinite(r0) && !Float.isNaN(r0);
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk  reason: not valid java name */
    private final boolean m2907hasSpecifiedAndFiniteHeightuvyYCjk(long $this$hasSpecifiedAndFiniteHeight_u2duvyYCjk) {
        if (Size.m3068equalsimpl0($this$hasSpecifiedAndFiniteHeight_u2duvyYCjk, Size.Companion.m3080getUnspecifiedNHjbRc())) {
            return false;
        }
        float r0 = Size.m3069getHeightimpl($this$hasSpecifiedAndFiniteHeight_u2duvyYCjk);
        return !Float.isInfinite(r0) && !Float.isNaN(r0);
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}

package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ,\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002JI\u0010'\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R/\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Border.kt */
public final class BorderModifierNode extends DelegatingNode {
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private Shape shape;
    private float width;

    public /* synthetic */ BorderModifierNode(float f, Brush brush2, Shape shape2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush2, shape2);
    }

    private BorderModifierNode(float widthParameter, Brush brushParameter, Shape shapeParameter) {
        Intrinsics.checkNotNullParameter(brushParameter, "brushParameter");
        Intrinsics.checkNotNullParameter(shapeParameter, "shapeParameter");
        this.width = widthParameter;
        this.brush = brushParameter;
        this.shape = shapeParameter;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new BorderModifierNode$drawWithCacheModifierNode$1(this)));
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m1895getWidthD9Ej5fM() {
        return this.width;
    }

    /* renamed from: setWidth-0680j_4  reason: not valid java name */
    public final void m1896setWidth0680j_4(float value) {
        if (!Dp.m7559equalsimpl0(this.width, value)) {
            this.width = value;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush(Brush value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual((Object) this.brush, (Object) value)) {
            this.brush = value;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final void setShape(Shape value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual((Object) this.shape, (Object) value)) {
            this.shape = value;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ed, code lost:
        if (androidx.compose.ui.graphics.ImageBitmapConfig.m5176equalsimpl(r13, r4) != false) goto L_0x00ef;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.draw.DrawResult drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope r64, androidx.compose.ui.graphics.Brush r65, androidx.compose.ui.graphics.Outline.Generic r66, boolean r67, float r68) {
        /*
            r63 = this;
            r0 = r63
            r1 = r64
            r15 = r65
            if (r67 == 0) goto L_0x001c
            androidx.compose.foundation.BorderModifierNode$drawGenericBorder$1 r2 = new androidx.compose.foundation.BorderModifierNode$drawGenericBorder$1
            r14 = r66
            r2.<init>(r14, r15)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.draw.DrawResult r2 = r1.onDrawWithContent(r2)
            r62 = r2
            r2 = r1
            r1 = r62
            goto L_0x0325
        L_0x001c:
            r14 = r66
            r2 = 0
            r3 = 0
            boolean r4 = r15 instanceof androidx.compose.ui.graphics.SolidColor
            if (r4 == 0) goto L_0x003e
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r4 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r2 = r4.m5181getAlpha8_sVssgQ()
            androidx.compose.ui.graphics.ColorFilter$Companion r4 = androidx.compose.ui.graphics.ColorFilter.Companion
            r5 = r15
            androidx.compose.ui.graphics.SolidColor r5 = (androidx.compose.ui.graphics.SolidColor) r5
            long r5 = r5.m5333getValue0d7_KjU()
            r8 = 2
            r9 = 0
            r7 = 0
            androidx.compose.ui.graphics.ColorFilter r3 = androidx.compose.ui.graphics.ColorFilter.Companion.m5004tintxETnrds$default(r4, r5, r7, r8, r9)
            r13 = r2
            r20 = r3
            goto L_0x0048
        L_0x003e:
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r4 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r2 = r4.m5182getArgb8888_sVssgQ()
            r3 = 0
            r13 = r2
            r20 = r3
        L_0x0048:
            androidx.compose.ui.graphics.Path r2 = r66.getPath()
            androidx.compose.ui.geometry.Rect r11 = r2.getBounds()
            androidx.compose.foundation.BorderCache r2 = r0.borderCache
            if (r2 != 0) goto L_0x0063
            androidx.compose.foundation.BorderCache r2 = new androidx.compose.foundation.BorderCache
            r8 = 15
            r9 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0.borderCache = r2
        L_0x0063:
            androidx.compose.foundation.BorderCache r2 = r0.borderCache
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            androidx.compose.ui.graphics.Path r12 = r2.obtainPath()
            r2 = r12
            r3 = 0
            r2.reset()
            r2.addRect(r11)
            androidx.compose.ui.graphics.Path r4 = r66.getPath()
            androidx.compose.ui.graphics.PathOperation$Companion r5 = androidx.compose.ui.graphics.PathOperation.Companion
            int r5 = r5.m5272getDifferenceb3I0S0c()
            r2.m5246opN5in7k0(r2, r4, r5)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            r3 = r2
            float r2 = r11.getWidth()
            double r4 = (double) r2
            double r4 = java.lang.Math.ceil(r4)
            float r2 = (float) r4
            int r2 = (int) r2
            float r4 = r11.getHeight()
            double r4 = (double) r4
            double r4 = java.lang.Math.ceil(r4)
            float r4 = (float) r4
            int r4 = (int) r4
            long r21 = androidx.compose.ui.unit.IntSizeKt.IntSize(r2, r4)
            androidx.compose.foundation.BorderCache r2 = r0.borderCache
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r23 = r2
            r24 = 0
            r2 = r64
            r10 = r23
            r25 = r2
            r26 = 0
            androidx.compose.ui.graphics.ImageBitmap r2 = r10.imageBitmap
            androidx.compose.ui.graphics.Canvas r16 = r10.canvas
            r4 = 0
            if (r2 == 0) goto L_0x00c8
            int r5 = r2.m5173getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r5 = androidx.compose.ui.graphics.ImageBitmapConfig.m5174boximpl(r5)
            goto L_0x00c9
        L_0x00c8:
            r5 = r4
        L_0x00c9:
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r6 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r6 = r6.m5182getArgb8888_sVssgQ()
            r7 = 0
            if (r5 != 0) goto L_0x00d4
            r5 = r7
            goto L_0x00dc
        L_0x00d4:
            int r5 = r5.m5180unboximpl()
            boolean r5 = androidx.compose.ui.graphics.ImageBitmapConfig.m5177equalsimpl0(r5, r6)
        L_0x00dc:
            r9 = 1
            if (r5 != 0) goto L_0x00ef
            if (r2 == 0) goto L_0x00e9
            int r4 = r2.m5173getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r4 = androidx.compose.ui.graphics.ImageBitmapConfig.m5174boximpl(r4)
        L_0x00e9:
            boolean r4 = androidx.compose.ui.graphics.ImageBitmapConfig.m5176equalsimpl(r13, r4)
            if (r4 == 0) goto L_0x00f0
        L_0x00ef:
            r7 = r9
        L_0x00f0:
            r27 = r7
            if (r2 == 0) goto L_0x0120
            if (r16 == 0) goto L_0x0120
            long r4 = r25.m4614getSizeNHjbRc()
            float r4 = androidx.compose.ui.geometry.Size.m4782getWidthimpl(r4)
            int r5 = r2.getWidth()
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x0120
            long r4 = r25.m4614getSizeNHjbRc()
            float r4 = androidx.compose.ui.geometry.Size.m4779getHeightimpl(r4)
            int r5 = r2.getHeight()
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x0120
            if (r27 != 0) goto L_0x011b
            goto L_0x0120
        L_0x011b:
            r15 = r10
            r9 = r16
            r10 = r2
            goto L_0x0151
        L_0x0120:
            int r4 = androidx.compose.ui.unit.IntSize.m7714getWidthimpl(r21)
            int r5 = androidx.compose.ui.unit.IntSize.m7713getHeightimpl(r21)
            r17 = 24
            r18 = 0
            r7 = 0
            r8 = 0
            r6 = r13
            r9 = r17
            r15 = r10
            r10 = r18
            androidx.compose.ui.graphics.ImageBitmap r4 = androidx.compose.ui.graphics.ImageBitmapKt.m5187ImageBitmapx__hDU$default(r4, r5, r6, r7, r8, r9, r10)
            r5 = r4
            r6 = 0
            r15.imageBitmap = r5
            r2 = r4
            androidx.compose.ui.graphics.Canvas r4 = androidx.compose.ui.graphics.CanvasKt.Canvas(r2)
            r5 = r4
            r6 = 0
            r15.canvas = r5
            r16 = r4
            r10 = r2
            r9 = r16
        L_0x0151:
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r2 = r15.canvasDrawScope
            if (r2 != 0) goto L_0x0161
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r2 = new androidx.compose.ui.graphics.drawscope.CanvasDrawScope
            r2.<init>()
            r4 = r2
            r5 = 0
            r15.canvasDrawScope = r4
        L_0x0161:
            r29 = r2
            long r7 = androidx.compose.ui.unit.IntSizeKt.m7724toSizeozmzZPI(r21)
            androidx.compose.ui.unit.LayoutDirection r2 = r25.getLayoutDirection()
            r6 = r2
            r43 = r29
            r44 = 0
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r2 = r43.getDrawParams()
            androidx.compose.ui.unit.Density r5 = r2.component1()
            androidx.compose.ui.unit.LayoutDirection r4 = r2.component2()
            r16 = r15
            androidx.compose.ui.graphics.Canvas r15 = r2.component3()
            r17 = r15
            long r14 = r2.m5476component4NHjbRc()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r2 = r43.getDrawParams()
            r18 = 0
            r0 = r25
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            r2.setDensity(r0)
            r2.setLayoutDirection(r6)
            r2.setCanvas(r9)
            r2.m5479setSizeuvyYCjk(r7)
            r9.save()
            r0 = r43
            androidx.compose.ui.graphics.drawscope.DrawScope r0 = (androidx.compose.ui.graphics.drawscope.DrawScope) r0
            r45 = 0
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r31 = r2.m4989getBlack0d7_KjU()
            androidx.compose.ui.graphics.BlendMode$Companion r2 = androidx.compose.ui.graphics.BlendMode.Companion
            int r40 = r2.m4869getClear0nO6VwU()
            r41 = 58
            r42 = 0
            r33 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r30 = r0
            r35 = r7
            androidx.compose.ui.graphics.drawscope.DrawScope.m5552drawRectnJ9OG0$default(r30, r31, r33, r35, r37, r38, r39, r40, r41, r42)
            r31 = 0
            float r2 = r11.getLeft()
            float r2 = -r2
            r32 = r0
            float r0 = r11.getTop()
            float r0 = -r0
            r33 = r30
            r34 = 0
            androidx.compose.ui.graphics.drawscope.DrawContext r18 = r33.getDrawContext()
            r19 = r3
            androidx.compose.ui.graphics.drawscope.DrawTransform r3 = r18.getTransform()
            r3.translate(r2, r0)
            r3 = r2
            r2 = r33
            r35 = 0
            androidx.compose.ui.graphics.Path r18 = r66.getPath()
            androidx.compose.ui.graphics.drawscope.Stroke r36 = new androidx.compose.ui.graphics.drawscope.Stroke
            r37 = r3
            r3 = 2
            float r3 = (float) r3
            float r47 = r68 * r3
            r52 = 30
            r53 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r46 = r36
            r46.<init>(r47, r48, r49, r50, r51, r52, r53)
            androidx.compose.ui.graphics.drawscope.DrawStyle r36 = (androidx.compose.ui.graphics.drawscope.DrawStyle) r36
            r38 = 52
            r40 = 0
            r41 = 0
            r42 = 0
            r54 = r19
            r55 = r37
            r3 = r18
            r56 = r4
            r4 = r65
            r57 = r5
            r5 = r40
            r37 = r6
            r6 = r36
            r46 = r7
            r7 = r41
            r8 = r42
            r36 = r9
            r9 = r38
            r38 = r10
            r10 = r39
            androidx.compose.ui.graphics.drawscope.DrawScope.m5547drawPathGBMwjPU$default(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            long r3 = r2.m5576getSizeNHjbRc()
            float r3 = androidx.compose.ui.geometry.Size.m4782getWidthimpl(r3)
            r4 = 1
            float r4 = (float) r4
            float r3 = r3 + r4
            long r5 = r2.m5576getSizeNHjbRc()
            float r5 = androidx.compose.ui.geometry.Size.m4782getWidthimpl(r5)
            float r3 = r3 / r5
            long r5 = r2.m5576getSizeNHjbRc()
            float r5 = androidx.compose.ui.geometry.Size.m4779getHeightimpl(r5)
            float r5 = r5 + r4
            long r6 = r2.m5576getSizeNHjbRc()
            float r4 = androidx.compose.ui.geometry.Size.m4779getHeightimpl(r6)
            float r5 = r5 / r4
            r4 = r5
            r5 = r2
            long r6 = r5.m5575getCenterF1C5BW0()
            r8 = 0
            r9 = r5
            r10 = 0
            r18 = r14
            androidx.compose.ui.graphics.drawscope.DrawContext r15 = r9.getDrawContext()
            r28 = 0
            r39 = r2
            long r1 = r15.m5519getSizeNHjbRc()
            androidx.compose.ui.graphics.Canvas r14 = r15.getCanvas()
            r14.save()
            androidx.compose.ui.graphics.drawscope.DrawTransform r14 = r15.getTransform()
            r40 = 0
            r14.m5635scale0AR0LA0(r3, r4, r6)
            r40 = r11
            r11 = r9
            r41 = 0
            androidx.compose.ui.graphics.BlendMode$Companion r14 = androidx.compose.ui.graphics.BlendMode.Companion
            int r42 = r14.m4869getClear0nO6VwU()
            r48 = 28
            r49 = 0
            r14 = 0
            r50 = 0
            r52 = r13
            r13 = r65
            r53 = r3
            r58 = r4
            r3 = r18
            r61 = r15
            r59 = r16
            r60 = r17
            r15 = r50
            r16 = r51
            r17 = r42
            r18 = r48
            r19 = r49
            androidx.compose.ui.graphics.drawscope.DrawScope.m5547drawPathGBMwjPU$default(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            androidx.compose.ui.graphics.Canvas r11 = r61.getCanvas()
            r11.restore()
            r11 = r61
            r11.m5520setSizeuvyYCjk(r1)
            androidx.compose.ui.graphics.drawscope.DrawContext r1 = r33.getDrawContext()
            androidx.compose.ui.graphics.drawscope.DrawTransform r1 = r1.getTransform()
            r2 = r55
            float r5 = -r2
            float r6 = -r0
            r1.translate(r5, r6)
            r36.restore()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r0 = r43.getDrawParams()
            r1 = 0
            r2 = r57
            r0.setDensity(r2)
            r5 = r56
            r0.setLayoutDirection(r5)
            r6 = r60
            r0.setCanvas(r6)
            r0.m5479setSizeuvyYCjk(r3)
            r38.prepareToDraw()
            r2 = r38
            r0 = r54
            r0.element = r2
            androidx.compose.foundation.BorderModifierNode$drawGenericBorder$3 r1 = new androidx.compose.foundation.BorderModifierNode$drawGenericBorder$3
            r2 = r1
            r3 = r40
            r4 = r0
            r5 = r21
            r7 = r20
            r2.<init>(r3, r4, r5, r7)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r2 = r64
            androidx.compose.ui.draw.DrawResult r1 = r2.onDrawWithContent(r1)
        L_0x0325:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderModifierNode.drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.graphics.Brush, androidx.compose.ui.graphics.Outline$Generic, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    /* access modifiers changed from: private */
    /* renamed from: drawRoundRectBorder-JqoCqck  reason: not valid java name */
    public final DrawResult m1894drawRoundRectBorderJqoCqck(CacheDrawScope $this$drawRoundRectBorder_u2dJqoCqck, Brush brush2, Outline.Rounded outline, long topLeft, long borderSize, boolean fillArea, float strokeWidth) {
        CacheDrawScope cacheDrawScope = $this$drawRoundRectBorder_u2dJqoCqck;
        float f = strokeWidth;
        if (RoundRectKt.isSimple(outline.getRoundRect())) {
            Brush brush3 = brush2;
            boolean z = fillArea;
            return cacheDrawScope.onDrawWithContent(new BorderModifierNode$drawRoundRectBorder$1(fillArea, brush2, outline.getRoundRect().m4763getTopLeftCornerRadiuskKHJgLs(), f / ((float) 2), strokeWidth, topLeft, borderSize, new Stroke(strokeWidth, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null)));
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache((ImageBitmap) null, (Canvas) null, (CanvasDrawScope) null, (Path) null, 15, (DefaultConstructorMarker) null);
        }
        BorderCache borderCache2 = this.borderCache;
        Intrinsics.checkNotNull(borderCache2);
        return cacheDrawScope.onDrawWithContent(new BorderModifierNode$drawRoundRectBorder$2(BorderKt.createRoundRectPath(borderCache2.obtainPath(), outline.getRoundRect(), f, fillArea), brush2));
    }
}

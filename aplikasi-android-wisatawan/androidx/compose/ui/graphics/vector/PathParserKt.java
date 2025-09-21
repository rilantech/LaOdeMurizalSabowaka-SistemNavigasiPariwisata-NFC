package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001aX\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002\u001aX\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002\u001a\u001a\u0010\u001a\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u001a\r\u0010\u001e\u001a\u00020\t*\u00020\tH\b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u001f"}, d2 = {"EmptyArray", "", "getEmptyArray", "()[F", "arcToBezier", "", "p", "Landroidx/compose/ui/graphics/Path;", "cx", "", "cy", "a", "b", "e1x", "e1y", "theta", "start", "sweep", "drawArc", "x0", "y0", "x1", "y1", "isMoreThanHalf", "", "isPositiveArc", "toPath", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "target", "toRadians", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PathParser.kt */
public final class PathParserKt {
    private static final float[] EmptyArray = new float[0];

    public static final float[] getEmptyArray() {
        return EmptyArray;
    }

    public static /* synthetic */ Path toPath$default(List list, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return toPath(list, path);
    }

    public static final Path toPath(List<? extends PathNode> $this$toPath, Path target) {
        int fillType;
        int i;
        List $this$fastForEach$iv;
        int index$iv;
        PathNode node;
        float reflectiveCtrlX;
        float reflectiveCtrlY;
        float reflectiveCtrlY2;
        float reflectiveCtrlX2;
        float reflectiveCtrlX3;
        float reflectiveCtrlY3;
        float reflectiveCtrlY4;
        float reflectiveCtrlX4;
        List<? extends PathNode> list = $this$toPath;
        Path path = target;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(path, TypedValues.AttributesType.S_TARGET);
        int fillType2 = target.m3535getFillTypeRgk1Os();
        target.rewind();
        path.m3537setFillTypeoQ8Xj4U(fillType2);
        Object obj = $this$toPath.isEmpty() ? PathNode.Close.INSTANCE : list.get(0);
        List $this$fastForEach$iv2 = $this$toPath;
        int size = $this$fastForEach$iv2.size();
        float currentY = 0.0f;
        float ctrlX = 0.0f;
        float ctrlY = 0.0f;
        float segmentX = 0.0f;
        float segmentY = 0.0f;
        PathNode pathNode = (PathNode) obj;
        int index$iv2 = 0;
        float currentX = 0.0f;
        while (index$iv2 < size) {
            PathNode node2 = (PathNode) $this$fastForEach$iv2.get(index$iv2);
            if (node2 instanceof PathNode.Close) {
                float currentX2 = segmentX;
                float currentY2 = segmentY;
                target.close();
                path.moveTo(currentX2, currentY2);
                currentX = currentX2;
                currentY = currentY2;
                ctrlX = segmentX;
                ctrlY = segmentY;
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeMoveTo) {
                currentX += ((PathNode.RelativeMoveTo) node2).getDx();
                currentY += ((PathNode.RelativeMoveTo) node2).getDy();
                path.relativeMoveTo(((PathNode.RelativeMoveTo) node2).getDx(), ((PathNode.RelativeMoveTo) node2).getDy());
                segmentX = currentX;
                segmentY = currentY;
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.MoveTo) {
                float currentX3 = ((PathNode.MoveTo) node2).getX();
                float currentY3 = ((PathNode.MoveTo) node2).getY();
                path.moveTo(((PathNode.MoveTo) node2).getX(), ((PathNode.MoveTo) node2).getY());
                currentX = currentX3;
                currentY = currentY3;
                segmentX = currentX3;
                segmentY = currentY3;
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeLineTo) {
                path.relativeLineTo(((PathNode.RelativeLineTo) node2).getDx(), ((PathNode.RelativeLineTo) node2).getDy());
                currentX += ((PathNode.RelativeLineTo) node2).getDx();
                currentY += ((PathNode.RelativeLineTo) node2).getDy();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.LineTo) {
                path.lineTo(((PathNode.LineTo) node2).getX(), ((PathNode.LineTo) node2).getY());
                currentX = ((PathNode.LineTo) node2).getX();
                currentY = ((PathNode.LineTo) node2).getY();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeHorizontalTo) {
                path.relativeLineTo(((PathNode.RelativeHorizontalTo) node2).getDx(), 0.0f);
                currentX += ((PathNode.RelativeHorizontalTo) node2).getDx();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.HorizontalTo) {
                path.lineTo(((PathNode.HorizontalTo) node2).getX(), currentY);
                currentX = ((PathNode.HorizontalTo) node2).getX();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeVerticalTo) {
                path.relativeLineTo(0.0f, ((PathNode.RelativeVerticalTo) node2).getDy());
                currentY += ((PathNode.RelativeVerticalTo) node2).getDy();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.VerticalTo) {
                path.lineTo(currentX, ((PathNode.VerticalTo) node2).getY());
                currentY = ((PathNode.VerticalTo) node2).getY();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeCurveTo) {
                target.relativeCubicTo(((PathNode.RelativeCurveTo) node2).getDx1(), ((PathNode.RelativeCurveTo) node2).getDy1(), ((PathNode.RelativeCurveTo) node2).getDx2(), ((PathNode.RelativeCurveTo) node2).getDy2(), ((PathNode.RelativeCurveTo) node2).getDx3(), ((PathNode.RelativeCurveTo) node2).getDy3());
                float ctrlX2 = ((PathNode.RelativeCurveTo) node2).getDx2() + currentX;
                float ctrlY2 = ((PathNode.RelativeCurveTo) node2).getDy2() + currentY;
                currentX += ((PathNode.RelativeCurveTo) node2).getDx3();
                currentY += ((PathNode.RelativeCurveTo) node2).getDy3();
                ctrlX = ctrlX2;
                ctrlY = ctrlY2;
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.CurveTo) {
                target.cubicTo(((PathNode.CurveTo) node2).getX1(), ((PathNode.CurveTo) node2).getY1(), ((PathNode.CurveTo) node2).getX2(), ((PathNode.CurveTo) node2).getY2(), ((PathNode.CurveTo) node2).getX3(), ((PathNode.CurveTo) node2).getY3());
                ctrlX = ((PathNode.CurveTo) node2).getX2();
                ctrlY = ((PathNode.CurveTo) node2).getY2();
                currentX = ((PathNode.CurveTo) node2).getX3();
                currentY = ((PathNode.CurveTo) node2).getY3();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeReflectiveCurveTo) {
                if (pathNode.isCurve()) {
                    reflectiveCtrlX4 = currentX - ctrlX;
                    reflectiveCtrlY4 = currentY - ctrlY;
                } else {
                    reflectiveCtrlX4 = 0.0f;
                    reflectiveCtrlY4 = 0.0f;
                }
                target.relativeCubicTo(reflectiveCtrlX4, reflectiveCtrlY4, ((PathNode.RelativeReflectiveCurveTo) node2).getDx1(), ((PathNode.RelativeReflectiveCurveTo) node2).getDy1(), ((PathNode.RelativeReflectiveCurveTo) node2).getDx2(), ((PathNode.RelativeReflectiveCurveTo) node2).getDy2());
                float ctrlX3 = ((PathNode.RelativeReflectiveCurveTo) node2).getDx1() + currentX;
                float ctrlY3 = ((PathNode.RelativeReflectiveCurveTo) node2).getDy1() + currentY;
                currentX += ((PathNode.RelativeReflectiveCurveTo) node2).getDx2();
                currentY += ((PathNode.RelativeReflectiveCurveTo) node2).getDy2();
                ctrlX = ctrlX3;
                ctrlY = ctrlY3;
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
                float f = reflectiveCtrlX4;
                float f2 = reflectiveCtrlY4;
            } else if (node2 instanceof PathNode.ReflectiveCurveTo) {
                if (pathNode.isCurve()) {
                    float f3 = (float) 2;
                    reflectiveCtrlY3 = (f3 * currentY) - ctrlY;
                    reflectiveCtrlX3 = (f3 * currentX) - ctrlX;
                } else {
                    reflectiveCtrlY3 = currentY;
                    reflectiveCtrlX3 = currentX;
                }
                target.cubicTo(reflectiveCtrlX3, reflectiveCtrlY3, ((PathNode.ReflectiveCurveTo) node2).getX1(), ((PathNode.ReflectiveCurveTo) node2).getY1(), ((PathNode.ReflectiveCurveTo) node2).getX2(), ((PathNode.ReflectiveCurveTo) node2).getY2());
                ctrlX = ((PathNode.ReflectiveCurveTo) node2).getX1();
                ctrlY = ((PathNode.ReflectiveCurveTo) node2).getY1();
                currentX = ((PathNode.ReflectiveCurveTo) node2).getX2();
                currentY = ((PathNode.ReflectiveCurveTo) node2).getY2();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
                float f4 = reflectiveCtrlY3;
                float f5 = reflectiveCtrlX3;
            } else if (node2 instanceof PathNode.RelativeQuadTo) {
                path.relativeQuadraticBezierTo(((PathNode.RelativeQuadTo) node2).getDx1(), ((PathNode.RelativeQuadTo) node2).getDy1(), ((PathNode.RelativeQuadTo) node2).getDx2(), ((PathNode.RelativeQuadTo) node2).getDy2());
                float ctrlX4 = ((PathNode.RelativeQuadTo) node2).getDx1() + currentX;
                float ctrlY4 = ((PathNode.RelativeQuadTo) node2).getDy1() + currentY;
                currentX += ((PathNode.RelativeQuadTo) node2).getDx2();
                currentY += ((PathNode.RelativeQuadTo) node2).getDy2();
                ctrlX = ctrlX4;
                ctrlY = ctrlY4;
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.QuadTo) {
                path.quadraticBezierTo(((PathNode.QuadTo) node2).getX1(), ((PathNode.QuadTo) node2).getY1(), ((PathNode.QuadTo) node2).getX2(), ((PathNode.QuadTo) node2).getY2());
                ctrlX = ((PathNode.QuadTo) node2).getX1();
                ctrlY = ((PathNode.QuadTo) node2).getY1();
                currentX = ((PathNode.QuadTo) node2).getX2();
                currentY = ((PathNode.QuadTo) node2).getY2();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeReflectiveQuadTo) {
                if (pathNode.isQuad()) {
                    reflectiveCtrlX2 = currentX - ctrlX;
                    reflectiveCtrlY2 = currentY - ctrlY;
                } else {
                    reflectiveCtrlX2 = 0.0f;
                    reflectiveCtrlY2 = 0.0f;
                }
                path.relativeQuadraticBezierTo(reflectiveCtrlX2, reflectiveCtrlY2, ((PathNode.RelativeReflectiveQuadTo) node2).getDx(), ((PathNode.RelativeReflectiveQuadTo) node2).getDy());
                float ctrlX5 = currentX + reflectiveCtrlX2;
                float ctrlY5 = currentY + reflectiveCtrlY2;
                currentX += ((PathNode.RelativeReflectiveQuadTo) node2).getDx();
                currentY += ((PathNode.RelativeReflectiveQuadTo) node2).getDy();
                float f6 = reflectiveCtrlX2;
                float f7 = reflectiveCtrlY2;
                ctrlX = ctrlX5;
                ctrlY = ctrlY5;
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.ReflectiveQuadTo) {
                if (pathNode.isQuad()) {
                    float f8 = (float) 2;
                    reflectiveCtrlX = (f8 * currentX) - ctrlX;
                    reflectiveCtrlY = (f8 * currentY) - ctrlY;
                } else {
                    reflectiveCtrlX = currentX;
                    reflectiveCtrlY = currentY;
                }
                path.quadraticBezierTo(reflectiveCtrlX, reflectiveCtrlY, ((PathNode.ReflectiveQuadTo) node2).getX(), ((PathNode.ReflectiveQuadTo) node2).getY());
                float f9 = reflectiveCtrlY;
                float f10 = reflectiveCtrlX;
                ctrlX = reflectiveCtrlX;
                ctrlY = reflectiveCtrlY;
                currentX = ((PathNode.ReflectiveQuadTo) node2).getX();
                currentY = ((PathNode.ReflectiveQuadTo) node2).getY();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeArcTo) {
                float arcStartX = ((PathNode.RelativeArcTo) node2).getArcStartDx() + currentX;
                float arcStartY = ((PathNode.RelativeArcTo) node2).getArcStartDy() + currentY;
                int index$iv3 = index$iv2;
                double d = (double) arcStartY;
                float arcStartY2 = arcStartY;
                index$iv = index$iv3;
                node = node2;
                float f11 = currentX;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
                float f12 = currentY;
                drawArc(target, (double) currentX, (double) currentY, (double) arcStartX, d, (double) ((PathNode.RelativeArcTo) node).getHorizontalEllipseRadius(), (double) ((PathNode.RelativeArcTo) node).getVerticalEllipseRadius(), (double) ((PathNode.RelativeArcTo) node).getTheta(), ((PathNode.RelativeArcTo) node).isMoreThanHalf(), ((PathNode.RelativeArcTo) node).isPositiveArc());
                float currentX4 = arcStartX;
                float currentY4 = arcStartY2;
                currentX = currentX4;
                currentY = currentY4;
                ctrlX = currentX4;
                ctrlY = currentY4;
            } else {
                index$iv = index$iv2;
                node = node2;
                float currentX5 = currentX;
                float currentY5 = currentY;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
                if (node instanceof PathNode.ArcTo) {
                    float currentX6 = currentX5;
                    float currentY6 = currentY5;
                    float f13 = currentY6;
                    float f14 = currentX6;
                    drawArc(target, (double) currentX6, (double) currentY6, (double) ((PathNode.ArcTo) node).getArcStartX(), (double) ((PathNode.ArcTo) node).getArcStartY(), (double) ((PathNode.ArcTo) node).getHorizontalEllipseRadius(), (double) ((PathNode.ArcTo) node).getVerticalEllipseRadius(), (double) ((PathNode.ArcTo) node).getTheta(), ((PathNode.ArcTo) node).isMoreThanHalf(), ((PathNode.ArcTo) node).isPositiveArc());
                    float currentX7 = ((PathNode.ArcTo) node).getArcStartX();
                    float currentY7 = ((PathNode.ArcTo) node).getArcStartY();
                    currentX = currentX7;
                    currentY = currentY7;
                    ctrlX = currentX7;
                    ctrlY = currentY7;
                } else {
                    currentY = currentY5;
                    currentX = currentX5;
                }
            }
            pathNode = node;
            index$iv2 = index$iv + 1;
            List<? extends PathNode> list2 = $this$toPath;
            path = target;
            $this$fastForEach$iv2 = $this$fastForEach$iv;
            size = i;
            fillType2 = fillType;
        }
        return target;
    }

    private static final void drawArc(Path p, double x0, double y0, double x1, double y1, double a, double b, double theta, boolean isMoreThanHalf, boolean isPositiveArc) {
        double cy;
        double cx;
        double d = x0;
        double d2 = x1;
        boolean z = isPositiveArc;
        double thetaD = (theta / ((double) 180)) * 3.141592653589793d;
        double cosTheta = Math.cos(thetaD);
        double sinTheta = Math.sin(thetaD);
        double x0p = ((d * cosTheta) + (y0 * sinTheta)) / a;
        double y0p = (((-d) * sinTheta) + (y0 * cosTheta)) / b;
        double x1p = ((d2 * cosTheta) + (y1 * sinTheta)) / a;
        double y1p = (((-d2) * sinTheta) + (y1 * cosTheta)) / b;
        double dx = x0p - x1p;
        double dy = y0p - y1p;
        double d3 = (double) 2;
        double xm = (x0p + x1p) / d3;
        double ym = (y0p + y1p) / d3;
        double dsq = (dx * dx) + (dy * dy);
        if (!(dsq == 0.0d)) {
            double disc = (1.0d / dsq) - 0.25d;
            if (disc < 0.0d) {
                float adjust = (float) (Math.sqrt(dsq) / 1.99999d);
                float f = adjust;
                drawArc(p, x0, y0, x1, y1, a * ((double) adjust), b * ((double) adjust), theta, isMoreThanHalf, isPositiveArc);
                return;
            }
            double s = Math.sqrt(disc);
            double sdx = s * dx;
            double sdy = s * dy;
            boolean z2 = isPositiveArc;
            if (isMoreThanHalf == z2) {
                cx = xm - sdy;
                cy = ym + sdx;
            } else {
                cx = xm + sdy;
                cy = ym - sdx;
            }
            double eta0 = Math.atan2(y0p - cy, x0p - cx);
            double d4 = s;
            double sweep = Math.atan2(y1p - cy, x1p - cx) - eta0;
            if (z2 != (sweep >= 0.0d)) {
                if (sweep > 0.0d) {
                    sweep -= 6.283185307179586d;
                } else {
                    sweep += 6.283185307179586d;
                }
            }
            double cx2 = cx * a;
            double cy2 = cy * b;
            arcToBezier(p, (cx2 * cosTheta) - (cy2 * sinTheta), (cx2 * sinTheta) + (cy2 * cosTheta), a, b, x0, y0, thetaD, eta0, sweep);
        }
    }

    private static final void arcToBezier(Path p, double cx, double cy, double a, double b, double e1x, double e1y, double theta, double start, double sweep) {
        double eta1 = a;
        double eta1y = e1y;
        double d = (double) 4;
        int numSegments = (int) Math.ceil(Math.abs((sweep * d) / 3.141592653589793d));
        double eta12 = start;
        double cosTheta = Math.cos(theta);
        double sinTheta = Math.sin(theta);
        double cosEta1 = Math.cos(eta12);
        double sinEta1 = Math.sin(eta12);
        double eta1x = e1x;
        double ep1x = (((-eta1) * cosTheta) * sinEta1) - ((b * sinTheta) * cosEta1);
        double ep1y = ((-eta1) * sinTheta * sinEta1) + (b * cosTheta * cosEta1);
        double anglePerSegment = sweep / ((double) numSegments);
        double d2 = cosEta1;
        int i = 0;
        double d3 = d2;
        while (i < numSegments) {
            double eta2 = eta12 + anglePerSegment;
            double sinEta2 = Math.sin(eta2);
            double cosEta2 = Math.cos(eta2);
            double anglePerSegment2 = anglePerSegment;
            double e2x = (cx + ((eta1 * cosTheta) * cosEta2)) - ((b * sinTheta) * sinEta2);
            double e2y = cy + (eta1 * sinTheta * cosEta2) + (b * cosTheta * sinEta2);
            double ep2x = (((-eta1) * cosTheta) * sinEta2) - ((b * sinTheta) * cosEta2);
            double ep2y = ((-eta1) * sinTheta * sinEta2) + (b * cosTheta * cosEta2);
            double tanDiff2 = Math.tan((eta2 - eta12) / ((double) 2));
            double d4 = tanDiff2;
            double alpha = (Math.sin(eta2 - eta12) * (Math.sqrt(d + ((3.0d * tanDiff2) * tanDiff2)) - ((double) 1))) / ((double) 3);
            double q1x = eta1x + (alpha * ep1x);
            double d5 = d;
            double q1y = eta1y + (alpha * ep1y);
            double d6 = eta1y;
            double q2x = e2x - (alpha * ep2x);
            int numSegments2 = numSegments;
            double d7 = eta12;
            double q2y = e2y - (alpha * ep2y);
            double d8 = q1x;
            float f = (float) q2x;
            double d9 = q2x;
            float f2 = (float) q2y;
            double d10 = q1y;
            double e2x2 = e2x;
            double d11 = q2y;
            double e2y2 = e2y;
            p.cubicTo((float) q1x, (float) q1y, f, f2, (float) e2x2, (float) e2y2);
            eta1x = e2x2;
            ep1x = ep2x;
            ep1y = ep2y;
            i++;
            eta1y = e2y2;
            numSegments = numSegments2;
            cosTheta = cosTheta;
            anglePerSegment = anglePerSegment2;
            d = d5;
            eta12 = eta2;
            eta1 = a;
        }
    }

    private static final double toRadians(double $this$toRadians) {
        return ($this$toRadians / ((double) 180)) * 3.141592653589793d;
    }
}

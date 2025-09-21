package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0000\u001a4\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\u001a \u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a4\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0002\u001a=\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u001bH\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"isInOutline", "", "outline", "Landroidx/compose/ui/graphics/Outline;", "x", "", "y", "tmpTouchPointPath", "Landroidx/compose/ui/graphics/Path;", "tmpOpPath", "isInPath", "path", "isInRectangle", "rect", "Landroidx/compose/ui/geometry/Rect;", "isInRoundedRect", "Landroidx/compose/ui/graphics/Outline$Rounded;", "touchPointPath", "opPath", "isWithinEllipse", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "centerX", "centerY", "isWithinEllipse-VE1yxkc", "(FFJFF)Z", "cornersFit", "Landroidx/compose/ui/geometry/RoundRect;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ShapeContainingUtil.kt */
public final class ShapeContainingUtilKt {
    public static /* synthetic */ boolean isInOutline$default(Outline outline, float f, float f2, Path path, Path path2, int i, Object obj) {
        if ((i & 8) != 0) {
            path = null;
        }
        if ((i & 16) != 0) {
            path2 = null;
        }
        return isInOutline(outline, f, f2, path, path2);
    }

    public static final boolean isInOutline(Outline outline, float x, float y, Path tmpTouchPointPath, Path tmpOpPath) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        if (outline instanceof Outline.Rectangle) {
            return isInRectangle(((Outline.Rectangle) outline).getRect(), x, y);
        }
        if (outline instanceof Outline.Rounded) {
            return isInRoundedRect((Outline.Rounded) outline, x, y, tmpTouchPointPath, tmpOpPath);
        }
        if (outline instanceof Outline.Generic) {
            return isInPath(((Outline.Generic) outline).getPath(), x, y, tmpTouchPointPath, tmpOpPath);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean isInRectangle(Rect rect, float x, float y) {
        return rect.getLeft() <= x && x < rect.getRight() && rect.getTop() <= y && y < rect.getBottom();
    }

    private static final boolean isInRoundedRect(Outline.Rounded outline, float x, float y, Path touchPointPath, Path opPath) {
        float f = x;
        float f2 = y;
        Path path = opPath;
        RoundRect rrect = outline.getRoundRect();
        if (f < rrect.getLeft() || f >= rrect.getRight() || f2 < rrect.getTop()) {
            Path path2 = touchPointPath;
            return false;
        } else if (f2 >= rrect.getBottom()) {
            Path path3 = touchPointPath;
            return false;
        } else if (!cornersFit(rrect)) {
            Path path4 = path == null ? AndroidPath_androidKt.Path() : path;
            path4.addRoundRect(rrect);
            return isInPath(path4, f, f2, touchPointPath, path);
        } else {
            Path path5 = touchPointPath;
            float topLeftX = rrect.getLeft() + CornerRadius.m4688getXimpl(rrect.m4763getTopLeftCornerRadiuskKHJgLs());
            float topLeftY = rrect.getTop() + CornerRadius.m4689getYimpl(rrect.m4763getTopLeftCornerRadiuskKHJgLs());
            float topRightX = rrect.getRight() - CornerRadius.m4688getXimpl(rrect.m4764getTopRightCornerRadiuskKHJgLs());
            float topRightY = rrect.getTop() + CornerRadius.m4689getYimpl(rrect.m4764getTopRightCornerRadiuskKHJgLs());
            float bottomRightX = rrect.getRight() - CornerRadius.m4688getXimpl(rrect.m4762getBottomRightCornerRadiuskKHJgLs());
            float bottomRightY = rrect.getBottom() - CornerRadius.m4689getYimpl(rrect.m4762getBottomRightCornerRadiuskKHJgLs());
            float bottomLeftX = rrect.getBottom() - CornerRadius.m4689getYimpl(rrect.m4761getBottomLeftCornerRadiuskKHJgLs());
            float bottomLeftY = rrect.getLeft() + CornerRadius.m4688getXimpl(rrect.m4761getBottomLeftCornerRadiuskKHJgLs());
            if (f < topLeftX && f2 < topLeftY) {
                return m6839isWithinEllipseVE1yxkc(x, y, rrect.m4763getTopLeftCornerRadiuskKHJgLs(), topLeftX, topLeftY);
            } else if (f < bottomLeftY && f2 > bottomLeftX) {
                return m6839isWithinEllipseVE1yxkc(x, y, rrect.m4761getBottomLeftCornerRadiuskKHJgLs(), bottomLeftY, bottomLeftX);
            } else if (f > topRightX && f2 < topRightY) {
                return m6839isWithinEllipseVE1yxkc(x, y, rrect.m4764getTopRightCornerRadiuskKHJgLs(), topRightX, topRightY);
            } else if (f <= bottomRightX || f2 <= bottomRightY) {
                return true;
            } else {
                return m6839isWithinEllipseVE1yxkc(x, y, rrect.m4762getBottomRightCornerRadiuskKHJgLs(), bottomRightX, bottomRightY);
            }
        }
    }

    private static final boolean cornersFit(RoundRect $this$cornersFit) {
        return CornerRadius.m4688getXimpl($this$cornersFit.m4763getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m4688getXimpl($this$cornersFit.m4764getTopRightCornerRadiuskKHJgLs()) <= $this$cornersFit.getWidth() && CornerRadius.m4688getXimpl($this$cornersFit.m4761getBottomLeftCornerRadiuskKHJgLs()) + CornerRadius.m4688getXimpl($this$cornersFit.m4762getBottomRightCornerRadiuskKHJgLs()) <= $this$cornersFit.getWidth() && CornerRadius.m4689getYimpl($this$cornersFit.m4763getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m4689getYimpl($this$cornersFit.m4761getBottomLeftCornerRadiuskKHJgLs()) <= $this$cornersFit.getHeight() && CornerRadius.m4689getYimpl($this$cornersFit.m4764getTopRightCornerRadiuskKHJgLs()) + CornerRadius.m4689getYimpl($this$cornersFit.m4762getBottomRightCornerRadiuskKHJgLs()) <= $this$cornersFit.getHeight();
    }

    /* renamed from: isWithinEllipse-VE1yxkc  reason: not valid java name */
    private static final boolean m6839isWithinEllipseVE1yxkc(float x, float y, long cornerRadius, float centerX, float centerY) {
        float px = x - centerX;
        float py = y - centerY;
        float radiusX = CornerRadius.m4688getXimpl(cornerRadius);
        float radiusY = CornerRadius.m4689getYimpl(cornerRadius);
        return ((px * px) / (radiusX * radiusX)) + ((py * py) / (radiusY * radiusY)) <= 1.0f;
    }

    private static final boolean isInPath(Path path, float x, float y, Path tmpTouchPointPath, Path tmpOpPath) {
        Rect rect = new Rect(x - 0.005f, y - 0.005f, x + 0.005f, 0.005f + y);
        Path touchPointPath = tmpTouchPointPath == null ? AndroidPath_androidKt.Path() : tmpTouchPointPath;
        touchPointPath.addRect(rect);
        Path opPath = tmpOpPath == null ? AndroidPath_androidKt.Path() : tmpOpPath;
        opPath.m5246opN5in7k0(path, touchPointPath, PathOperation.Companion.m5273getIntersectb3I0S0c());
        boolean isClipped = opPath.isEmpty();
        opPath.reset();
        touchPointPath.reset();
        return !isClipped;
    }
}

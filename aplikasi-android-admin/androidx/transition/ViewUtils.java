package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS = new Property<View, Rect>(Rect.class, "clipBounds") {
        public Rect get(View view) {
            return ViewCompat.getClipBounds(view);
        }

        public void set(View view, Rect clipBounds) {
            ViewCompat.setClipBounds(view, clipBounds);
        }
    };
    private static final ViewUtilsBase IMPL = new ViewUtilsApi29();
    private static final String TAG = "ViewUtils";
    static final Property<View, Float> TRANSITION_ALPHA = new Property<View, Float>(Float.class, "translationAlpha") {
        public Float get(View view) {
            return Float.valueOf(ViewUtils.getTransitionAlpha(view));
        }

        public void set(View view, Float alpha) {
            ViewUtils.setTransitionAlpha(view, alpha.floatValue());
        }
    };

    static ViewOverlayImpl getOverlay(View view) {
        return new ViewOverlayApi18(view);
    }

    static WindowIdImpl getWindowId(View view) {
        return new WindowIdApi18(view);
    }

    static void setTransitionAlpha(View view, float alpha) {
        IMPL.setTransitionAlpha(view, alpha);
    }

    static float getTransitionAlpha(View view) {
        return IMPL.getTransitionAlpha(view);
    }

    static void saveNonTransitionAlpha(View view) {
        IMPL.saveNonTransitionAlpha(view);
    }

    static void clearNonTransitionAlpha(View view) {
        IMPL.clearNonTransitionAlpha(view);
    }

    static void setTransitionVisibility(View view, int visibility) {
        IMPL.setTransitionVisibility(view, visibility);
    }

    static void transformMatrixToGlobal(View view, Matrix matrix) {
        IMPL.transformMatrixToGlobal(view, matrix);
    }

    static void transformMatrixToLocal(View view, Matrix matrix) {
        IMPL.transformMatrixToLocal(view, matrix);
    }

    static void setAnimationMatrix(View v, Matrix m) {
        IMPL.setAnimationMatrix(v, m);
    }

    static void setLeftTopRightBottom(View v, int left, int top, int right, int bottom) {
        IMPL.setLeftTopRightBottom(v, left, top, right, bottom);
    }

    private ViewUtils() {
    }
}

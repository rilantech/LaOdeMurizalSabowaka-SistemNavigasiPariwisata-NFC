package androidx.transition;

import android.graphics.Matrix;
import android.widget.ImageView;
import java.lang.reflect.Field;

class ImageViewUtils {
    private static Field sDrawMatrixField;
    private static boolean sDrawMatrixFieldFetched;
    private static boolean sTryHiddenAnimateTransform = true;

    static void animateTransform(ImageView view, Matrix matrix) {
        view.animateTransform(matrix);
    }

    private static void hiddenAnimateTransform(ImageView view, Matrix matrix) {
        if (sTryHiddenAnimateTransform) {
            try {
                view.animateTransform(matrix);
            } catch (NoSuchMethodError e) {
                sTryHiddenAnimateTransform = false;
            }
        }
    }

    private static void fetchDrawMatrixField() {
        if (!sDrawMatrixFieldFetched) {
            try {
                Field declaredField = ImageView.class.getDeclaredField("mDrawMatrix");
                sDrawMatrixField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            sDrawMatrixFieldFetched = true;
        }
    }

    private ImageViewUtils() {
    }
}

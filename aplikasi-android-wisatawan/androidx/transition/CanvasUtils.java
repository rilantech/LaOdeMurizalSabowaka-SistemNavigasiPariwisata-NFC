package androidx.transition;

import android.graphics.Canvas;
import java.lang.reflect.Method;

class CanvasUtils {
    private static Method sInorderBarrierMethod;
    private static boolean sOrderMethodsFetched;
    private static Method sReorderBarrierMethod;

    static void enableZ(Canvas canvas, boolean enable) {
        if (enable) {
            canvas.enableZ();
        } else {
            canvas.disableZ();
        }
    }

    private CanvasUtils() {
    }
}

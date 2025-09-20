package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public final class ViewConfigurationCompat {
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration config) {
        return config.getScaledPagingTouchSlop();
    }

    @Deprecated
    public static boolean hasPermanentMenuKey(ViewConfiguration config) {
        return config.hasPermanentMenuKey();
    }

    public static float getScaledHorizontalScrollFactor(ViewConfiguration config, Context context) {
        return Api26Impl.getScaledHorizontalScrollFactor(config);
    }

    public static float getScaledVerticalScrollFactor(ViewConfiguration config, Context context) {
        return Api26Impl.getScaledVerticalScrollFactor(config);
    }

    private static float getLegacyScrollFactor(ViewConfiguration config, Context context) {
        Method method = sGetScaledScrollFactorMethod;
        if (method != null) {
            try {
                return (float) ((Integer) method.invoke(config, new Object[0])).intValue();
            } catch (Exception e) {
                Log.i(TAG, "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue outValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16842829, outValue, true)) {
            return outValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static int getScaledHoverSlop(ViewConfiguration config) {
        return Api28Impl.getScaledHoverSlop(config);
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration config, Context context) {
        return Api28Impl.shouldShowMenuShortcutsWhenKeyboardPresent(config);
    }

    public static int getScaledMinimumFlingVelocity(Context context, ViewConfiguration config, int inputDeviceId, int axis, int source) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getScaledMinimumFlingVelocity(config, inputDeviceId, axis, source);
        }
        if (!isInputDeviceInfoValid(inputDeviceId, axis, source)) {
            return Integer.MAX_VALUE;
        }
        Resources res = context.getResources();
        int platformResId = getPreApi34MinimumFlingVelocityResId(res, source, axis);
        if (platformResId == 0) {
            return config.getScaledMinimumFlingVelocity();
        }
        int minFlingVelocity = res.getDimensionPixelSize(platformResId);
        if (minFlingVelocity < 0) {
            return Integer.MAX_VALUE;
        }
        return minFlingVelocity;
    }

    public static int getScaledMaximumFlingVelocity(Context context, ViewConfiguration config, int inputDeviceId, int axis, int source) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getScaledMaximumFlingVelocity(config, inputDeviceId, axis, source);
        }
        if (!isInputDeviceInfoValid(inputDeviceId, axis, source)) {
            return Integer.MIN_VALUE;
        }
        Resources res = context.getResources();
        int platformResId = getPreApi34MaximumFlingVelocityResId(res, source, axis);
        if (platformResId == 0) {
            return config.getScaledMaximumFlingVelocity();
        }
        int maxFlingVelocity = res.getDimensionPixelSize(platformResId);
        if (maxFlingVelocity < 0) {
            return Integer.MIN_VALUE;
        }
        return maxFlingVelocity;
    }

    private ViewConfigurationCompat() {
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static float getScaledHorizontalScrollFactor(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        static float getScaledVerticalScrollFactor(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static int getScaledHoverSlop(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    static class Api34Impl {
        private Api34Impl() {
        }

        static int getScaledMaximumFlingVelocity(ViewConfiguration viewConfiguration, int inputDeviceId, int axis, int source) {
            return viewConfiguration.getScaledMaximumFlingVelocity(inputDeviceId, axis, source);
        }

        static int getScaledMinimumFlingVelocity(ViewConfiguration viewConfiguration, int inputDeviceId, int axis, int source) {
            return viewConfiguration.getScaledMinimumFlingVelocity(inputDeviceId, axis, source);
        }
    }

    private static int getPreApi34MaximumFlingVelocityResId(Resources res, int source, int axis) {
        if (source == 4194304 && axis == 26) {
            return getPlatformResId(res, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
        }
        return 0;
    }

    private static int getPreApi34MinimumFlingVelocityResId(Resources res, int source, int axis) {
        if (source == 4194304 && axis == 26) {
            return getPlatformResId(res, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
        }
        return 0;
    }

    private static int getPlatformResId(Resources res, String name, String defType) {
        return res.getIdentifier(name, defType, "android");
    }

    private static boolean isInputDeviceInfoValid(int id, int axis, int source) {
        InputDevice device = InputDevice.getDevice(id);
        return (device == null || device.getMotionRange(axis, source) == null) ? false : true;
    }
}

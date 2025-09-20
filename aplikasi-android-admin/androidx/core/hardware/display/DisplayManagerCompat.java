package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap<Context, WeakReference<DisplayManagerCompat>> sInstances = new WeakHashMap<>();
    private final Context mContext;

    private DisplayManagerCompat(Context context) {
        this.mContext = context;
    }

    public static DisplayManagerCompat getInstance(Context context) {
        DisplayManagerCompat displayManagerCompat;
        WeakHashMap<Context, WeakReference<DisplayManagerCompat>> weakHashMap = sInstances;
        synchronized (weakHashMap) {
            WeakReference<DisplayManagerCompat> instance = weakHashMap.get(context);
            if (instance == null || instance.get() == null) {
                instance = new WeakReference<>(new DisplayManagerCompat(context));
                weakHashMap.put(context, instance);
            }
            displayManagerCompat = (DisplayManagerCompat) instance.get();
        }
        return displayManagerCompat;
    }

    public Display getDisplay(int displayId) {
        return Api17Impl.getDisplay((DisplayManager) this.mContext.getSystemService("display"), displayId);
    }

    public Display[] getDisplays() {
        return Api17Impl.getDisplays((DisplayManager) this.mContext.getSystemService("display"));
    }

    public Display[] getDisplays(String category) {
        return Api17Impl.getDisplays((DisplayManager) this.mContext.getSystemService("display"));
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static Display getDisplay(DisplayManager displayManager, int displayId) {
            return displayManager.getDisplay(displayId);
        }

        static Display[] getDisplays(DisplayManager displayManager) {
            return displayManager.getDisplays();
        }
    }
}

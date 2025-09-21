package me.dm7.barcodescanner.core;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class DisplayUtils {
    public static Point getScreenResolution(Context context) {
        Display display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point screenResolution = new Point();
        display.getSize(screenResolution);
        return screenResolution;
    }

    public static int getScreenOrientation(Context context) {
        Display display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (display.getWidth() == display.getHeight()) {
            return 3;
        }
        if (display.getWidth() < display.getHeight()) {
            return 1;
        }
        return 2;
    }
}

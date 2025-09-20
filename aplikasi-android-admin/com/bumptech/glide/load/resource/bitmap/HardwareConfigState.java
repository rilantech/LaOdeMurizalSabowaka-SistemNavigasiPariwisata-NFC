package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public final class HardwareConfigState {
    public static final boolean BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED = false;
    private static final File FD_SIZE_LIST = new File("/proc/self/fd");
    public static final boolean HARDWARE_BITMAPS_SUPPORTED = true;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_P = 20000;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;
    @Deprecated
    public static final int NO_MAX_FD_COUNT = -1;
    private static final int REDUCED_MAX_FDS_FOR_HARDWARE_CONFIGS_P = 500;
    private static final String TAG = "HardwareConfig";
    private static volatile HardwareConfigState instance;
    private int decodesSinceLastFdCheck;
    private boolean isFdSizeBelowHardwareLimit = true;
    private final AtomicBoolean isHardwareConfigAllowedByAppState = new AtomicBoolean(false);
    private final int sdkBasedMaxFdCount = 20000;

    public static HardwareConfigState getInstance() {
        if (instance == null) {
            synchronized (HardwareConfigState.class) {
                if (instance == null) {
                    instance = new HardwareConfigState();
                }
            }
        }
        return instance;
    }

    HardwareConfigState() {
    }

    public void blockHardwareBitmaps() {
        Util.assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(false);
    }

    public void unblockHardwareBitmaps() {
        Util.assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(true);
    }

    public boolean isHardwareConfigAllowed(int targetWidth, int targetHeight, boolean isHardwareConfigAllowed, boolean isExifOrientationRequired) {
        if (!isHardwareConfigAllowed) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed by caller");
            }
            return false;
        } else if (!HARDWARE_BITMAPS_SUPPORTED) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed by sdk");
            }
            return false;
        } else if (areHardwareBitmapsBlockedByAppState()) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed by app state");
            }
            return false;
        } else if (isExifOrientationRequired) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed because exif orientation is required");
            }
            return false;
        } else if (targetWidth < 0 || targetHeight < 0) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed because of invalid dimensions");
            }
            return false;
        } else if (isFdSizeBelowHardwareLimit()) {
            return true;
        } else {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed because there are insufficient FDs");
            }
            return false;
        }
    }

    private boolean areHardwareBitmapsBlockedByAppState() {
        return BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED && !this.isHardwareConfigAllowedByAppState.get();
    }

    /* access modifiers changed from: package-private */
    public boolean setHardwareConfigIfAllowed(int targetWidth, int targetHeight, BitmapFactory.Options optionsWithScaling, boolean isHardwareConfigAllowed, boolean isExifOrientationRequired) {
        boolean result = isHardwareConfigAllowed(targetWidth, targetHeight, isHardwareConfigAllowed, isExifOrientationRequired);
        if (result) {
            optionsWithScaling.inPreferredConfig = Bitmap.Config.HARDWARE;
            optionsWithScaling.inMutable = false;
        }
        return result;
    }

    private static boolean isHardwareBitmapCountReducedOnApi28ByB139097735() {
        return false;
    }

    private int getMaxFdCount() {
        if (isHardwareBitmapCountReducedOnApi28ByB139097735()) {
            return REDUCED_MAX_FDS_FOR_HARDWARE_CONFIGS_P;
        }
        return this.sdkBasedMaxFdCount;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        boolean z = true;
        int i = this.decodesSinceLastFdCheck + 1;
        this.decodesSinceLastFdCheck = i;
        if (i >= 50) {
            this.decodesSinceLastFdCheck = 0;
            int currentFds = FD_SIZE_LIST.list().length;
            long maxFdCount = (long) getMaxFdCount();
            if (((long) currentFds) >= maxFdCount) {
                z = false;
            }
            this.isFdSizeBelowHardwareLimit = z;
            if (!z && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + currentFds + ", limit " + maxFdCount);
            }
        }
        return this.isFdSizeBelowHardwareLimit;
    }
}

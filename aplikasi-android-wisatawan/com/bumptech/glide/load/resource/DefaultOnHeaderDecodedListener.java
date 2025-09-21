package com.bumptech.glide.load.resource;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;

public final class DefaultOnHeaderDecodedListener implements ImageDecoder.OnHeaderDecodedListener {
    private static final String TAG = "ImageDecoder";
    private final DecodeFormat decodeFormat;
    private final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    private final boolean isHardwareConfigAllowed;
    private final PreferredColorSpace preferredColorSpace;
    private final int requestedHeight;
    private final int requestedWidth;
    private final DownsampleStrategy strategy;

    public DefaultOnHeaderDecodedListener(int requestedWidth2, int requestedHeight2, Options options) {
        this.requestedWidth = requestedWidth2;
        this.requestedHeight = requestedHeight2;
        this.decodeFormat = (DecodeFormat) options.get(Downsampler.DECODE_FORMAT);
        this.strategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        this.isHardwareConfigAllowed = options.get(Downsampler.ALLOW_HARDWARE_CONFIG) != null && ((Boolean) options.get(Downsampler.ALLOW_HARDWARE_CONFIG)).booleanValue();
        this.preferredColorSpace = (PreferredColorSpace) options.get(Downsampler.PREFERRED_COLOR_SPACE);
    }

    public void onHeaderDecoded(ImageDecoder decoder, ImageDecoder.ImageInfo info, ImageDecoder.Source source) {
        boolean isP3Eligible = false;
        if (this.hardwareConfigState.isHardwareConfigAllowed(this.requestedWidth, this.requestedHeight, this.isHardwareConfigAllowed, false)) {
            decoder.setAllocator(3);
        } else {
            decoder.setAllocator(1);
        }
        if (this.decodeFormat == DecodeFormat.PREFER_RGB_565) {
            decoder.setMemorySizePolicy(0);
        }
        decoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() {
            public boolean onPartialImage(ImageDecoder.DecodeException e) {
                return false;
            }
        });
        Size size = info.getSize();
        int targetWidth = this.requestedWidth;
        if (this.requestedWidth == Integer.MIN_VALUE) {
            targetWidth = size.getWidth();
        }
        int targetHeight = this.requestedHeight;
        if (this.requestedHeight == Integer.MIN_VALUE) {
            targetHeight = size.getHeight();
        }
        float scaleFactor = this.strategy.getScaleFactor(size.getWidth(), size.getHeight(), targetWidth, targetHeight);
        int resizeWidth = Math.round(((float) size.getWidth()) * scaleFactor);
        int resizeHeight = Math.round(((float) size.getHeight()) * scaleFactor);
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + resizeWidth + "x" + resizeHeight + "] scaleFactor: " + scaleFactor);
        }
        decoder.setTargetSize(resizeWidth, resizeHeight);
        if (this.preferredColorSpace != null) {
            if (this.preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && info.getColorSpace() != null && info.getColorSpace().isWideGamut()) {
                isP3Eligible = true;
            }
            decoder.setTargetColorSpace(ColorSpace.get(isP3Eligible ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
        }
    }
}

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;
    private static final DecodeCallbacks EMPTY_CALLBACKS = new DecodeCallbacks() {
        public void onObtainBounds() {
        }

        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap downsampled) {
        }
    };
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{WBMP_MIME_TYPE, ICO_MIME_TYPE})));
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = Util.createQueue(0);
    public static final Option<PreferredColorSpace> PREFERRED_COLOR_SPACE = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
    static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    private final List<ImageHeaderParser> parsers;

    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void onObtainBounds();
    }

    public Downsampler(List<ImageHeaderParser> parsers2, DisplayMetrics displayMetrics2, BitmapPool bitmapPool2, ArrayPool byteArrayPool2) {
        this.parsers = parsers2;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics2);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool2);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(byteArrayPool2);
    }

    public boolean handles(InputStream is) {
        return true;
    }

    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }

    public boolean handles(ParcelFileDescriptor source) {
        return ParcelFileDescriptorRewinder.isSupported();
    }

    public Resource<Bitmap> decode(InputStream is, int outWidth, int outHeight, Options options) throws IOException {
        return decode(is, outWidth, outHeight, options, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(ByteBuffer buffer, int requestedWidth, int requestedHeight, Options options) throws IOException {
        return decode((ImageReader) new ImageReader.ByteBufferReader(buffer, this.parsers, this.byteArrayPool), requestedWidth, requestedHeight, options, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(InputStream is, int requestedWidth, int requestedHeight, Options options, DecodeCallbacks callbacks) throws IOException {
        return decode((ImageReader) new ImageReader.InputStreamImageReader(is, this.parsers, this.byteArrayPool), requestedWidth, requestedHeight, options, callbacks);
    }

    /* access modifiers changed from: package-private */
    public void decode(byte[] bytes, int requestedWidth, int requestedHeight, Options options) throws IOException {
        decode((ImageReader) new ImageReader.ByteArrayReader(bytes, this.parsers, this.byteArrayPool), requestedWidth, requestedHeight, options, EMPTY_CALLBACKS);
    }

    /* access modifiers changed from: package-private */
    public void decode(File file, int requestedWidth, int requestedHeight, Options options) throws IOException {
        decode((ImageReader) new ImageReader.FileReader(file, this.parsers, this.byteArrayPool), requestedWidth, requestedHeight, options, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(ParcelFileDescriptor parcelFileDescriptor, int outWidth, int outHeight, Options options) throws IOException {
        return decode((ImageReader) new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.parsers, this.byteArrayPool), outWidth, outHeight, options, EMPTY_CALLBACKS);
    }

    private Resource<Bitmap> decode(ImageReader imageReader, int requestedWidth, int requestedHeight, Options options, DecodeCallbacks callbacks) throws IOException {
        Options options2 = options;
        byte[] bytesForOptions = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options bitmapFactoryOptions = getDefaultOptions();
        bitmapFactoryOptions.inTempStorage = bytesForOptions;
        DecodeFormat decodeFormat = (DecodeFormat) options2.get(DECODE_FORMAT);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options2.get(PREFERRED_COLOR_SPACE);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options2.get(DownsampleStrategy.OPTION);
        boolean fixBitmapToRequestedDimensions = ((Boolean) options2.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option option = ALLOW_HARDWARE_CONFIG;
        try {
            return BitmapResource.obtain(decodeFromWrappedStreams(imageReader, bitmapFactoryOptions, downsampleStrategy, decodeFormat, preferredColorSpace, options2.get(option) != null && ((Boolean) options2.get(option)).booleanValue(), requestedWidth, requestedHeight, fixBitmapToRequestedDimensions, callbacks), this.bitmapPool);
        } finally {
            releaseOptions(bitmapFactoryOptions);
            this.byteArrayPool.put(bytesForOptions);
        }
    }

    private Bitmap decodeFromWrappedStreams(ImageReader imageReader, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean isHardwareConfigAllowed, int requestedWidth, int requestedHeight, boolean fixBitmapToRequestedDimensions, DecodeCallbacks callbacks) throws IOException {
        boolean isHardwareConfigAllowed2;
        int targetWidth;
        int targetHeight;
        String str;
        int expectedHeight;
        int expectedWidth;
        BitmapFactory.Options options2 = options;
        PreferredColorSpace preferredColorSpace2 = preferredColorSpace;
        DecodeCallbacks decodeCallbacks = callbacks;
        long startTime = LogTime.getLogTime();
        int[] sourceDimensions = getDimensions(imageReader, options2, decodeCallbacks, this.bitmapPool);
        boolean isP3Eligible = false;
        int sourceWidth = sourceDimensions[0];
        int sourceHeight = sourceDimensions[1];
        String sourceMimeType = options2.outMimeType;
        if (sourceWidth == -1 || sourceHeight == -1) {
            isHardwareConfigAllowed2 = false;
        } else {
            isHardwareConfigAllowed2 = isHardwareConfigAllowed;
        }
        int orientation = imageReader.getImageOrientation();
        int degreesToRotate = TransformationUtils.getExifOrientationDegrees(orientation);
        boolean isExifOrientationRequired = TransformationUtils.isExifOrientationRequired(orientation);
        int i = requestedWidth;
        if (i == Integer.MIN_VALUE) {
            targetWidth = isRotationRequired(degreesToRotate) ? sourceHeight : sourceWidth;
        } else {
            targetWidth = i;
        }
        int i2 = requestedHeight;
        if (i2 == Integer.MIN_VALUE) {
            targetHeight = isRotationRequired(degreesToRotate) ? sourceWidth : sourceHeight;
        } else {
            targetHeight = i2;
        }
        ImageHeaderParser.ImageType imageType = imageReader.getImageType();
        ImageHeaderParser.ImageType imageType2 = imageType;
        int orientation2 = orientation;
        calculateScaling(imageType, imageReader, callbacks, this.bitmapPool, downsampleStrategy, degreesToRotate, sourceWidth, sourceHeight, targetWidth, targetHeight, options);
        String sourceMimeType2 = sourceMimeType;
        int sourceHeight2 = sourceHeight;
        int sourceWidth2 = sourceWidth;
        DecodeCallbacks decodeCallbacks2 = decodeCallbacks;
        PreferredColorSpace preferredColorSpace3 = preferredColorSpace2;
        BitmapFactory.Options options3 = options2;
        calculateConfig(imageReader, decodeFormat, isHardwareConfigAllowed2, isExifOrientationRequired, options, targetWidth, targetHeight);
        if (options3.inSampleSize == 1 || 1 != 0) {
            ImageHeaderParser.ImageType imageType3 = imageType2;
            if (shouldUsePool(imageType3)) {
                if (sourceWidth2 < 0 || sourceHeight2 < 0 || !fixBitmapToRequestedDimensions || 1 == 0) {
                    float densityMultiplier = isScaling(options) != 0 ? ((float) options3.inTargetDensity) / ((float) options3.inDensity) : 1.0f;
                    int sampleSize = options3.inSampleSize;
                    String str2 = TAG;
                    int downsampledHeight = (int) Math.ceil((double) (((float) sourceHeight2) / ((float) sampleSize)));
                    int expectedWidth2 = Math.round(((float) ((int) Math.ceil((double) (((float) sourceWidth2) / ((float) sampleSize))))) * densityMultiplier);
                    int expectedHeight2 = Math.round(((float) downsampledHeight) * densityMultiplier);
                    str = str2;
                    if (Log.isLoggable(str, 2)) {
                        ImageHeaderParser.ImageType imageType4 = imageType3;
                        int i3 = downsampledHeight;
                        Log.v(str, "Calculated target [" + expectedWidth2 + "x" + expectedHeight2 + "] for source [" + sourceWidth2 + "x" + sourceHeight2 + "], sampleSize: " + sampleSize + ", targetDensity: " + options3.inTargetDensity + ", density: " + options3.inDensity + ", density multiplier: " + densityMultiplier);
                    } else {
                        int i4 = downsampledHeight;
                    }
                    expectedWidth = expectedWidth2;
                    expectedHeight = expectedHeight2;
                } else {
                    expectedWidth = targetWidth;
                    expectedHeight = targetHeight;
                    ImageHeaderParser.ImageType imageType5 = imageType3;
                    str = TAG;
                }
                if (expectedWidth > 0 && expectedHeight > 0) {
                    setInBitmap(options3, this.bitmapPool, expectedWidth, expectedHeight);
                }
            } else {
                ImageHeaderParser.ImageType imageType6 = imageType3;
                str = TAG;
            }
        } else {
            str = TAG;
        }
        if (preferredColorSpace3 != null) {
            if (preferredColorSpace3 == PreferredColorSpace.DISPLAY_P3 && options3.outColorSpace != null && options3.outColorSpace.isWideGamut()) {
                isP3Eligible = true;
            }
            options3.inPreferredColorSpace = ColorSpace.get(isP3Eligible ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        }
        Bitmap downsampled = decodeStream(imageReader, options3, decodeCallbacks2, this.bitmapPool);
        decodeCallbacks2.onDecodeComplete(this.bitmapPool, downsampled);
        if (Log.isLoggable(str, 2)) {
            logDecode(sourceWidth2, sourceHeight2, sourceMimeType2, options, downsampled, requestedWidth, requestedHeight, startTime);
        }
        Bitmap rotated = null;
        if (downsampled != null) {
            downsampled.setDensity(this.displayMetrics.densityDpi);
            rotated = TransformationUtils.rotateImageExif(this.bitmapPool, downsampled, orientation2);
            if (!downsampled.equals(rotated)) {
                this.bitmapPool.put(downsampled);
            }
        }
        return rotated;
    }

    private static void calculateScaling(ImageHeaderParser.ImageType imageType, ImageReader imageReader, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2, DownsampleStrategy downsampleStrategy, int degreesToRotate, int sourceWidth, int sourceHeight, int targetWidth, int targetHeight, BitmapFactory.Options options) throws IOException {
        int scaleFactor;
        int powerOfTwoHeight;
        int powerOfTwoWidth;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int powerOfTwoWidth2 = sourceWidth;
        int i = sourceHeight;
        int i2 = targetWidth;
        int i3 = targetHeight;
        BitmapFactory.Options options2 = options;
        if (powerOfTwoWidth2 <= 0) {
            int i4 = powerOfTwoWidth2;
            int i5 = i;
        } else if (i <= 0) {
            int i6 = powerOfTwoWidth2;
            int i7 = i;
        } else {
            int orientedSourceWidth = sourceWidth;
            int orientedSourceHeight = sourceHeight;
            if (isRotationRequired(degreesToRotate)) {
                orientedSourceWidth = sourceHeight;
                orientedSourceHeight = sourceWidth;
            }
            float exactScaleFactor = downsampleStrategy2.getScaleFactor(orientedSourceWidth, orientedSourceHeight, i2, i3);
            if (exactScaleFactor > 0.0f) {
                DownsampleStrategy.SampleSizeRounding rounding = downsampleStrategy2.getSampleSizeRounding(orientedSourceWidth, orientedSourceHeight, i2, i3);
                if (rounding != null) {
                    int outWidth = round((double) (((float) orientedSourceWidth) * exactScaleFactor));
                    int outHeight = round((double) (((float) orientedSourceHeight) * exactScaleFactor));
                    int widthScaleFactor = orientedSourceWidth / outWidth;
                    int i8 = outWidth;
                    int heightScaleFactor = orientedSourceHeight / outHeight;
                    int i9 = outHeight;
                    if (rounding == DownsampleStrategy.SampleSizeRounding.MEMORY) {
                        scaleFactor = Math.max(widthScaleFactor, heightScaleFactor);
                    } else {
                        scaleFactor = Math.min(widthScaleFactor, heightScaleFactor);
                    }
                    int i10 = heightScaleFactor;
                    int i11 = scaleFactor;
                    int powerOfTwoSampleSize = Math.max(1, Integer.highestOneBit(scaleFactor));
                    if (rounding == DownsampleStrategy.SampleSizeRounding.MEMORY && ((float) powerOfTwoSampleSize) < 1.0f / exactScaleFactor) {
                        powerOfTwoSampleSize <<= 1;
                    }
                    options2.inSampleSize = powerOfTwoSampleSize;
                    DownsampleStrategy.SampleSizeRounding sampleSizeRounding = rounding;
                    if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                        int nativeScaling = Math.min(powerOfTwoSampleSize, 8);
                        int i12 = widthScaleFactor;
                        powerOfTwoWidth = (int) Math.ceil((double) (((float) orientedSourceWidth) / ((float) nativeScaling)));
                        int i13 = nativeScaling;
                        powerOfTwoHeight = (int) Math.ceil((double) (((float) orientedSourceHeight) / ((float) nativeScaling)));
                        int secondaryScaling = powerOfTwoSampleSize / 8;
                        if (secondaryScaling > 0) {
                            powerOfTwoWidth /= secondaryScaling;
                            powerOfTwoHeight /= secondaryScaling;
                        }
                        BitmapPool bitmapPool3 = bitmapPool2;
                    } else {
                        if (imageType2 == ImageHeaderParser.ImageType.PNG) {
                            ImageReader imageReader2 = imageReader;
                            DecodeCallbacks decodeCallbacks2 = decodeCallbacks;
                            BitmapPool bitmapPool4 = bitmapPool2;
                        } else if (imageType2 == ImageHeaderParser.ImageType.PNG_A) {
                            ImageReader imageReader3 = imageReader;
                            DecodeCallbacks decodeCallbacks3 = decodeCallbacks;
                            BitmapPool bitmapPool5 = bitmapPool2;
                        } else if (imageType.isWebp()) {
                            powerOfTwoWidth = Math.round(((float) orientedSourceWidth) / ((float) powerOfTwoSampleSize));
                            powerOfTwoHeight = Math.round(((float) orientedSourceHeight) / ((float) powerOfTwoSampleSize));
                            BitmapPool bitmapPool6 = bitmapPool2;
                        } else if (orientedSourceWidth % powerOfTwoSampleSize == 0 && orientedSourceHeight % powerOfTwoSampleSize == 0) {
                            powerOfTwoWidth = orientedSourceWidth / powerOfTwoSampleSize;
                            powerOfTwoHeight = orientedSourceHeight / powerOfTwoSampleSize;
                            BitmapPool bitmapPool7 = bitmapPool2;
                        } else {
                            int[] dimensions = getDimensions(imageReader, options2, decodeCallbacks, bitmapPool2);
                            int powerOfTwoWidth3 = dimensions[0];
                            powerOfTwoHeight = dimensions[1];
                            powerOfTwoWidth = powerOfTwoWidth3;
                        }
                        int powerOfTwoWidth4 = (int) Math.floor((double) (((float) orientedSourceWidth) / ((float) powerOfTwoSampleSize)));
                        powerOfTwoHeight = (int) Math.floor((double) (((float) orientedSourceHeight) / ((float) powerOfTwoSampleSize)));
                        powerOfTwoWidth = powerOfTwoWidth4;
                    }
                    int orientedSourceWidth2 = orientedSourceWidth;
                    int i14 = orientedSourceHeight;
                    double adjustedScaleFactor = (double) downsampleStrategy2.getScaleFactor(powerOfTwoWidth, powerOfTwoHeight, i2, i3);
                    options2.inTargetDensity = adjustTargetDensityForError(adjustedScaleFactor);
                    options2.inDensity = getDensityMultiplier(adjustedScaleFactor);
                    if (isScaling(options)) {
                        options2.inScaled = true;
                    } else {
                        options2.inTargetDensity = 0;
                        options2.inDensity = 0;
                    }
                    if (Log.isLoggable(TAG, 2)) {
                        int i15 = orientedSourceWidth2;
                        Log.v(TAG, "Calculate scaling, source: [" + sourceWidth + "x" + sourceHeight + "], degreesToRotate: " + degreesToRotate + ", target: [" + i2 + "x" + i3 + "], power of two scaled: [" + powerOfTwoWidth + "x" + powerOfTwoHeight + "], exact scale factor: " + exactScaleFactor + ", power of 2 sample size: " + powerOfTwoSampleSize + ", adjusted scale factor: " + adjustedScaleFactor + ", target density: " + options2.inTargetDensity + ", density: " + options2.inDensity);
                        return;
                    }
                    int i16 = sourceWidth;
                    int i17 = orientedSourceWidth2;
                    int orientedSourceWidth3 = sourceHeight;
                    return;
                }
                int i18 = powerOfTwoWidth2;
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + exactScaleFactor + " from: " + downsampleStrategy2 + ", source: [" + powerOfTwoWidth2 + "x" + i + "], target: [" + i2 + "x" + i3 + "]");
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Unable to determine dimensions for: " + imageType + " with target [" + i2 + "x" + i3 + "]");
        } else {
            ImageHeaderParser.ImageType imageType3 = imageType;
        }
    }

    private static int adjustTargetDensityForError(double adjustedScaleFactor) {
        int densityMultiplier = getDensityMultiplier(adjustedScaleFactor);
        int targetDensity = round(((double) densityMultiplier) * adjustedScaleFactor);
        return round(((double) targetDensity) * (adjustedScaleFactor / ((double) (((float) targetDensity) / ((float) densityMultiplier)))));
    }

    private static int getDensityMultiplier(double adjustedScaleFactor) {
        return (int) Math.round((adjustedScaleFactor <= 1.0d ? adjustedScaleFactor : 1.0d / adjustedScaleFactor) * 2.147483647E9d);
    }

    private static int round(double value) {
        return (int) (0.5d + value);
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    private void calculateConfig(ImageReader imageReader, DecodeFormat format, boolean isHardwareConfigAllowed, boolean isExifOrientationRequired, BitmapFactory.Options optionsWithScaling, int targetWidth, int targetHeight) {
        if (!this.hardwareConfigState.setHardwareConfigIfAllowed(targetWidth, targetHeight, optionsWithScaling, isHardwareConfigAllowed, isExifOrientationRequired)) {
            if (format != DecodeFormat.PREFER_ARGB_8888) {
                boolean hasAlpha = false;
                try {
                    hasAlpha = imageReader.getImageType().hasAlpha();
                } catch (IOException e) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Cannot determine whether the image has alpha or not from header, format " + format, e);
                    }
                }
                optionsWithScaling.inPreferredConfig = hasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                if (optionsWithScaling.inPreferredConfig == Bitmap.Config.RGB_565) {
                    optionsWithScaling.inDither = true;
                    return;
                }
                return;
            }
            optionsWithScaling.inPreferredConfig = Bitmap.Config.ARGB_8888;
        }
    }

    private static int[] getDimensions(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2) throws IOException {
        options.inJustDecodeBounds = true;
        decodeStream(imageReader, options, decodeCallbacks, bitmapPool2);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static Bitmap decodeStream(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks callbacks, BitmapPool bitmapPool2) throws IOException {
        IOException bitmapAssertionException;
        if (!options.inJustDecodeBounds) {
            callbacks.onObtainBounds();
            imageReader.stopGrowingBuffers();
        }
        int sourceWidth = options.outWidth;
        int sourceHeight = options.outHeight;
        String outMimeType = options.outMimeType;
        TransformationUtils.getBitmapDrawableLock().lock();
        try {
            Bitmap result = imageReader.decodeBitmap(options);
            TransformationUtils.getBitmapDrawableLock().unlock();
            return result;
        } catch (IOException e) {
            throw bitmapAssertionException;
        } catch (IllegalArgumentException e2) {
            bitmapAssertionException = newIoExceptionForInBitmapAssertion(e2, sourceWidth, sourceHeight, outMimeType, options);
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to decode with inBitmap, trying again without Bitmap re-use", bitmapAssertionException);
            }
            if (options.inBitmap != null) {
                bitmapPool2.put(options.inBitmap);
                options.inBitmap = null;
                Bitmap decodeStream = decodeStream(imageReader, options, callbacks, bitmapPool2);
                TransformationUtils.getBitmapDrawableLock().unlock();
                return decodeStream;
            }
            throw bitmapAssertionException;
        } catch (Throwable th) {
            TransformationUtils.getBitmapDrawableLock().unlock();
            throw th;
        }
    }

    private static boolean isScaling(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private static void logDecode(int sourceWidth, int sourceHeight, String outMimeType, BitmapFactory.Options options, Bitmap result, int requestedWidth, int requestedHeight, long startTime) {
        Log.v(TAG, "Decoded " + getBitmapString(result) + " from [" + sourceWidth + "x" + sourceHeight + "] " + outMimeType + " with inBitmap " + getInBitmapString(options) + " for [" + requestedWidth + "x" + requestedHeight + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.getElapsedMillis(startTime));
    }

    private static String getInBitmapString(BitmapFactory.Options options) {
        return getBitmapString(options.inBitmap);
    }

    private static String getBitmapString(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException e, int outWidth, int outHeight, String outMimeType, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + outWidth + ", outHeight: " + outHeight + ", outMimeType: " + outMimeType + ", inBitmap: " + getInBitmapString(options), e);
    }

    private static void setInBitmap(BitmapFactory.Options options, BitmapPool bitmapPool2, int width, int height) {
        if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            Bitmap.Config expectedConfig = options.outConfig;
            if (expectedConfig == null) {
                expectedConfig = options.inPreferredConfig;
            }
            options.inBitmap = bitmapPool2.getDirty(width, height, expectedConfig);
        }
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options decodeBitmapOptions;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
            synchronized (queue) {
                decodeBitmapOptions = queue.poll();
            }
            if (decodeBitmapOptions == null) {
                decodeBitmapOptions = new BitmapFactory.Options();
                resetOptions(decodeBitmapOptions);
            }
        }
        return decodeBitmapOptions;
    }

    private static void releaseOptions(BitmapFactory.Options decodeBitmapOptions) {
        resetOptions(decodeBitmapOptions);
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(decodeBitmapOptions);
        }
    }

    private static void resetOptions(BitmapFactory.Options decodeBitmapOptions) {
        decodeBitmapOptions.inTempStorage = null;
        decodeBitmapOptions.inDither = false;
        decodeBitmapOptions.inScaled = false;
        decodeBitmapOptions.inSampleSize = 1;
        decodeBitmapOptions.inPreferredConfig = null;
        decodeBitmapOptions.inJustDecodeBounds = false;
        decodeBitmapOptions.inDensity = 0;
        decodeBitmapOptions.inTargetDensity = 0;
        decodeBitmapOptions.inPreferredColorSpace = null;
        decodeBitmapOptions.outColorSpace = null;
        decodeBitmapOptions.outConfig = null;
        decodeBitmapOptions.outWidth = 0;
        decodeBitmapOptions.outHeight = 0;
        decodeBitmapOptions.outMimeType = null;
        decodeBitmapOptions.inBitmap = null;
        decodeBitmapOptions.inMutable = true;
    }

    private static boolean isRotationRequired(int degreesToRotate) {
        return degreesToRotate == 90 || degreesToRotate == 270;
    }
}

package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    private static final MediaMetadataRetrieverFactory DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
    public static final long DEFAULT_FRAME = -1;
    static final int DEFAULT_FRAME_OPTION = 2;
    public static final Option<Integer> FRAME_OPTION = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new Option.CacheKeyUpdater<Integer>() {
        private final ByteBuffer buffer = ByteBuffer.allocate(4);

        public void update(byte[] keyBytes, Integer value, MessageDigest messageDigest) {
            if (value != null) {
                messageDigest.update(keyBytes);
                synchronized (this.buffer) {
                    this.buffer.position(0);
                    messageDigest.update(this.buffer.putInt(value.intValue()).array());
                }
            }
        }
    });
    private static final List<String> PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX = Collections.unmodifiableList(Arrays.asList(new String[]{"TP1A", "TD1A.220804.031"}));
    private static final String TAG = "VideoDecoder";
    public static final Option<Long> TARGET_FRAME = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new Option.CacheKeyUpdater<Long>() {
        private final ByteBuffer buffer = ByteBuffer.allocate(8);

        public void update(byte[] keyBytes, Long value, MessageDigest messageDigest) {
            messageDigest.update(keyBytes);
            synchronized (this.buffer) {
                this.buffer.position(0);
                messageDigest.update(this.buffer.putLong(value.longValue()).array());
            }
        }
    });
    private static final String WEBM_MIME_TYPE = "video/webm";
    private final BitmapPool bitmapPool;
    private final MediaMetadataRetrieverFactory factory;
    private final MediaInitializer<T> initializer;

    interface MediaInitializer<T> {
        void initializeExtractor(MediaExtractor mediaExtractor, T t) throws IOException;

        void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> asset(BitmapPool bitmapPool2) {
        return new VideoDecoder(bitmapPool2, new AssetFileDescriptorInitializer());
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel(BitmapPool bitmapPool2) {
        return new VideoDecoder(bitmapPool2, new ParcelFileDescriptorInitializer());
    }

    public static ResourceDecoder<ByteBuffer, Bitmap> byteBuffer(BitmapPool bitmapPool2) {
        return new VideoDecoder(bitmapPool2, new ByteBufferInitializer());
    }

    VideoDecoder(BitmapPool bitmapPool2, MediaInitializer<T> initializer2) {
        this(bitmapPool2, initializer2, DEFAULT_FACTORY);
    }

    VideoDecoder(BitmapPool bitmapPool2, MediaInitializer<T> initializer2, MediaMetadataRetrieverFactory factory2) {
        this.bitmapPool = bitmapPool2;
        this.initializer = initializer2;
        this.factory = factory2;
    }

    public boolean handles(T t, Options options) {
        return true;
    }

    public Resource<Bitmap> decode(T resource, int outWidth, int outHeight, Options options) throws IOException {
        Integer frameOption;
        DownsampleStrategy downsampleStrategy;
        MediaMetadataRetriever mediaMetadataRetriever;
        Options options2 = options;
        long frameTimeMicros = ((Long) options2.get(TARGET_FRAME)).longValue();
        if (frameTimeMicros >= 0 || frameTimeMicros == -1) {
            Integer frameOption2 = (Integer) options2.get(FRAME_OPTION);
            if (frameOption2 == null) {
                frameOption = 2;
            } else {
                frameOption = frameOption2;
            }
            DownsampleStrategy downsampleStrategy2 = (DownsampleStrategy) options2.get(DownsampleStrategy.OPTION);
            if (downsampleStrategy2 == null) {
                downsampleStrategy = DownsampleStrategy.DEFAULT;
            } else {
                downsampleStrategy = downsampleStrategy2;
            }
            MediaMetadataRetriever mediaMetadataRetriever2 = this.factory.build();
            try {
                this.initializer.initializeRetriever(mediaMetadataRetriever2, resource);
                mediaMetadataRetriever = mediaMetadataRetriever2;
                try {
                    Bitmap result = decodeFrame(resource, mediaMetadataRetriever2, frameTimeMicros, frameOption.intValue(), outWidth, outHeight, downsampleStrategy);
                    mediaMetadataRetriever.close();
                    return BitmapResource.obtain(result, this.bitmapPool);
                } catch (Throwable th) {
                    th = th;
                    mediaMetadataRetriever.close();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                mediaMetadataRetriever = mediaMetadataRetriever2;
                mediaMetadataRetriever.close();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + frameTimeMicros);
        }
    }

    private Bitmap decodeFrame(T resource, MediaMetadataRetriever mediaMetadataRetriever, long frameTimeMicros, int frameOption, int outWidth, int outHeight, DownsampleStrategy strategy) {
        if (!isUnsupportedFormat(resource, mediaMetadataRetriever)) {
            Bitmap result = null;
            if (!(outWidth == Integer.MIN_VALUE || outHeight == Integer.MIN_VALUE || strategy == DownsampleStrategy.NONE)) {
                result = decodeScaledFrame(mediaMetadataRetriever, frameTimeMicros, frameOption, outWidth, outHeight, strategy);
            }
            if (result == null) {
                result = decodeOriginalFrame(mediaMetadataRetriever, frameTimeMicros, frameOption);
            }
            Bitmap result2 = correctHdr180DegVideoFrameOrientation(mediaMetadataRetriever, result);
            if (result2 != null) {
                return result2;
            }
            throw new VideoDecoderException();
        }
        throw new IllegalStateException("Cannot decode VP8 video on CrOS.");
    }

    private static Bitmap correctHdr180DegVideoFrameOrientation(MediaMetadataRetriever mediaMetadataRetriever, Bitmap frame) {
        if (!isHdr180RotationFixRequired()) {
            return frame;
        }
        boolean requiresHdr180RotationFix = false;
        try {
            if (isHDR(mediaMetadataRetriever)) {
                requiresHdr180RotationFix = Math.abs(Integer.parseInt(mediaMetadataRetriever.extractMetadata(24))) == 180;
            }
        } catch (NumberFormatException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Exception trying to extract HDR transfer function or rotation");
            }
        }
        if (!requiresHdr180RotationFix) {
            return frame;
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Applying HDR 180 deg thumbnail correction");
        }
        Matrix rotationMatrix = new Matrix();
        rotationMatrix.postRotate(180.0f, ((float) frame.getWidth()) / 2.0f, ((float) frame.getHeight()) / 2.0f);
        return Bitmap.createBitmap(frame, 0, 0, frame.getWidth(), frame.getHeight(), rotationMatrix, true);
    }

    private static boolean isHDR(MediaMetadataRetriever mediaMetadataRetriever) throws NumberFormatException {
        String colorTransferString = mediaMetadataRetriever.extractMetadata(36);
        String colorStandardString = mediaMetadataRetriever.extractMetadata(35);
        int colorTransfer = Integer.parseInt(colorTransferString);
        return (colorTransfer == 7 || colorTransfer == 6) && Integer.parseInt(colorStandardString) == 6;
    }

    static boolean isHdr180RotationFixRequired() {
        if (!Build.MODEL.startsWith("Pixel") || Build.VERSION.SDK_INT != 33) {
            return false;
        }
        return isTBuildRequiringRotationFix();
    }

    private static boolean isTBuildRequiringRotationFix() {
        for (String buildId : PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX) {
            if (Build.ID.startsWith(buildId)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap decodeScaledFrame(android.media.MediaMetadataRetriever r14, long r15, int r17, int r18, int r19, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r20) {
        /*
            r7 = r14
            r0 = 18
            java.lang.String r0 = r14.extractMetadata(r0)     // Catch:{ all -> 0x0054 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0054 }
            r1 = 19
            java.lang.String r1 = r14.extractMetadata(r1)     // Catch:{ all -> 0x0054 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x0054 }
            r2 = 24
            java.lang.String r2 = r14.extractMetadata(r2)     // Catch:{ all -> 0x0054 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x0054 }
            r8 = r2
            r2 = 90
            if (r8 == r2) goto L_0x002d
            r2 = 270(0x10e, float:3.78E-43)
            if (r8 != r2) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r9 = r1
            goto L_0x0031
        L_0x002d:
            r2 = r0
            r0 = r1
            r1 = r2
            r9 = r1
        L_0x0031:
            r10 = r18
            r11 = r19
            r12 = r20
            float r1 = r12.getScaleFactor(r0, r9, r10, r11)     // Catch:{ all -> 0x0052 }
            r13 = r1
            float r1 = (float) r0     // Catch:{ all -> 0x0052 }
            float r1 = r1 * r13
            int r5 = java.lang.Math.round(r1)     // Catch:{ all -> 0x0052 }
            float r1 = (float) r9     // Catch:{ all -> 0x0052 }
            float r1 = r1 * r13
            int r6 = java.lang.Math.round(r1)     // Catch:{ all -> 0x0052 }
            r1 = r14
            r2 = r15
            r4 = r17
            android.graphics.Bitmap r1 = r1.getScaledFrameAtTime(r2, r4, r5, r6)     // Catch:{ all -> 0x0052 }
            return r1
        L_0x0052:
            r0 = move-exception
            goto L_0x005b
        L_0x0054:
            r0 = move-exception
            r10 = r18
            r11 = r19
            r12 = r20
        L_0x005b:
            r1 = 3
            java.lang.String r2 = "VideoDecoder"
            boolean r1 = android.util.Log.isLoggable(r2, r1)
            if (r1 == 0) goto L_0x0069
            java.lang.String r1 = "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame"
            android.util.Log.d(r2, r1, r0)
        L_0x0069:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.VideoDecoder.decodeScaledFrame(android.media.MediaMetadataRetriever, long, int, int, int, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy):android.graphics.Bitmap");
    }

    private static Bitmap decodeOriginalFrame(MediaMetadataRetriever mediaMetadataRetriever, long frameTimeMicros, int frameOption) {
        return mediaMetadataRetriever.getFrameAtTime(frameTimeMicros, frameOption);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0070, code lost:
        if (r4 != null) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isUnsupportedFormat(T r12, android.media.MediaMetadataRetriever r13) {
        /*
            r11 = this;
            java.lang.String r0 = "VideoDecoder"
            java.lang.String r1 = android.os.Build.DEVICE
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0014
            java.lang.String r1 = android.os.Build.DEVICE
            java.lang.String r4 = ".+_cheets|cheets_.+"
            boolean r1 = r1.matches(r4)
            if (r1 == 0) goto L_0x0014
            r1 = r2
            goto L_0x0015
        L_0x0014:
            r1 = r3
        L_0x0015:
            if (r1 != 0) goto L_0x0018
            return r3
        L_0x0018:
            r4 = 0
            r5 = 12
            java.lang.String r5 = r13.extractMetadata(r5)     // Catch:{ all -> 0x0063 }
            java.lang.String r6 = "video/webm"
            boolean r6 = r6.equals(r5)     // Catch:{ all -> 0x0063 }
            if (r6 != 0) goto L_0x0030
            if (r4 == 0) goto L_0x002f
            r4.release()
        L_0x002f:
            return r3
        L_0x0030:
            android.media.MediaExtractor r6 = new android.media.MediaExtractor     // Catch:{ all -> 0x0063 }
            r6.<init>()     // Catch:{ all -> 0x0063 }
            r4 = r6
            com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer<T> r6 = r11.initializer     // Catch:{ all -> 0x0063 }
            r6.initializeExtractor(r4, r12)     // Catch:{ all -> 0x0063 }
            int r6 = r4.getTrackCount()     // Catch:{ all -> 0x0063 }
            r7 = 0
        L_0x0040:
            if (r7 >= r6) goto L_0x005e
            android.media.MediaFormat r8 = r4.getTrackFormat(r7)     // Catch:{ all -> 0x0063 }
            java.lang.String r9 = "mime"
            java.lang.String r9 = r8.getString(r9)     // Catch:{ all -> 0x0063 }
            java.lang.String r10 = "video/x-vnd.on2.vp8"
            boolean r10 = r10.equals(r9)     // Catch:{ all -> 0x0063 }
            if (r10 == 0) goto L_0x005b
            r4.release()
            return r2
        L_0x005b:
            int r7 = r7 + 1
            goto L_0x0040
        L_0x005e:
        L_0x005f:
            r4.release()
            goto L_0x0073
        L_0x0063:
            r2 = move-exception
            r5 = 3
            boolean r5 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x0074 }
            if (r5 == 0) goto L_0x0070
            java.lang.String r5 = "Exception trying to extract track info for a webm video on CrOS."
            android.util.Log.d(r0, r5, r2)     // Catch:{ all -> 0x0074 }
        L_0x0070:
            if (r4 == 0) goto L_0x0073
            goto L_0x005f
        L_0x0073:
            return r3
        L_0x0074:
            r0 = move-exception
            if (r4 == 0) goto L_0x007a
            r4.release()
        L_0x007a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.VideoDecoder.isUnsupportedFormat(java.lang.Object, android.media.MediaMetadataRetriever):boolean");
    }

    static class MediaMetadataRetrieverFactory {
        MediaMetadataRetrieverFactory() {
        }

        public MediaMetadataRetriever build() {
            return new MediaMetadataRetriever();
        }
    }

    private static final class AssetFileDescriptorInitializer implements MediaInitializer<AssetFileDescriptor> {
        private AssetFileDescriptorInitializer() {
        }

        public void initializeRetriever(MediaMetadataRetriever retriever, AssetFileDescriptor data) {
            retriever.setDataSource(data.getFileDescriptor(), data.getStartOffset(), data.getLength());
        }

        public void initializeExtractor(MediaExtractor extractor, AssetFileDescriptor data) throws IOException {
            extractor.setDataSource(data.getFileDescriptor(), data.getStartOffset(), data.getLength());
        }
    }

    static final class ParcelFileDescriptorInitializer implements MediaInitializer<ParcelFileDescriptor> {
        ParcelFileDescriptorInitializer() {
        }

        public void initializeRetriever(MediaMetadataRetriever retriever, ParcelFileDescriptor data) {
            retriever.setDataSource(data.getFileDescriptor());
        }

        public void initializeExtractor(MediaExtractor extractor, ParcelFileDescriptor data) throws IOException {
            extractor.setDataSource(data.getFileDescriptor());
        }
    }

    static final class ByteBufferInitializer implements MediaInitializer<ByteBuffer> {
        ByteBufferInitializer() {
        }

        public void initializeRetriever(MediaMetadataRetriever retriever, ByteBuffer data) {
            retriever.setDataSource(getMediaDataSource(data));
        }

        public void initializeExtractor(MediaExtractor extractor, ByteBuffer data) throws IOException {
            extractor.setDataSource(getMediaDataSource(data));
        }

        private MediaDataSource getMediaDataSource(final ByteBuffer data) {
            return new MediaDataSource() {
                public int readAt(long position, byte[] buffer, int offset, int size) {
                    if (position >= ((long) data.limit())) {
                        return -1;
                    }
                    data.position((int) position);
                    int numBytesRead = Math.min(size, data.remaining());
                    data.get(buffer, offset, numBytesRead);
                    return numBytesRead;
                }

                public long getSize() {
                    return (long) data.limit();
                }

                public void close() {
                }
            };
        }
    }

    private static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }
}

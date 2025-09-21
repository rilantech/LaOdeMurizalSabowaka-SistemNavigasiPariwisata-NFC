package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.tracing.Trace;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.DirectResourceLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.ResourceUriLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.util.GlideSuppliers;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.List;

final class RegistryFactory {
    private RegistryFactory() {
    }

    static GlideSuppliers.GlideSupplier<Registry> lazilyCreateAndInitializeRegistry(final Glide glide, final List<GlideModule> manifestModules, final AppGlideModule annotationGeneratedModule) {
        return new GlideSuppliers.GlideSupplier<Registry>() {
            private boolean isInitializing;

            public Registry get() {
                if (!this.isInitializing) {
                    Trace.beginSection("Glide registry");
                    this.isInitializing = true;
                    try {
                        return RegistryFactory.createAndInitRegistry(Glide.this, manifestModules, annotationGeneratedModule);
                    } finally {
                        this.isInitializing = false;
                        Trace.endSection();
                    }
                } else {
                    throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
                }
            }
        };
    }

    static Registry createAndInitRegistry(Glide glide, List<GlideModule> manifestModules, AppGlideModule annotationGeneratedModule) {
        BitmapPool bitmapPool = glide.getBitmapPool();
        ArrayPool arrayPool = glide.getArrayPool();
        Context context = glide.getGlideContext().getApplicationContext();
        GlideExperiments experiments = glide.getGlideContext().getExperiments();
        Registry registry = new Registry();
        initializeDefaults(context, registry, bitmapPool, arrayPool, experiments);
        initializeModules(context, glide, registry, manifestModules, annotationGeneratedModule);
        return registry;
    }

    private static void initializeDefaults(Context context, Registry registry, BitmapPool bitmapPool, ArrayPool arrayPool, GlideExperiments experiments) {
        ResourceDecoder<ByteBuffer, Bitmap> byteBufferBitmapDecoder;
        ResourceDecoder<InputStream, Bitmap> streamBitmapDecoder;
        Context context2 = context;
        Registry registry2 = registry;
        BitmapPool bitmapPool2 = bitmapPool;
        ArrayPool arrayPool2 = arrayPool;
        registry2.register((ImageHeaderParser) new DefaultImageHeaderParser());
        registry2.register((ImageHeaderParser) new ExifInterfaceImageHeaderParser());
        Resources resources = context.getResources();
        List<ImageHeaderParser> imageHeaderParsers = registry.getImageHeaderParsers();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context2, imageHeaderParsers, bitmapPool2, arrayPool2);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> parcelFileDescriptorVideoDecoder = VideoDecoder.parcel(bitmapPool);
        Downsampler downsampler = new Downsampler(registry.getImageHeaderParsers(), resources.getDisplayMetrics(), bitmapPool2, arrayPool2);
        if (experiments.isEnabled(GlideBuilder.EnableImageDecoderForBitmaps.class)) {
            streamBitmapDecoder = new InputStreamBitmapImageDecoderResourceDecoder();
            byteBufferBitmapDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
        } else {
            byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(downsampler);
            streamBitmapDecoder = new StreamBitmapDecoder(downsampler, arrayPool2);
        }
        registry2.append("Animation", InputStream.class, Drawable.class, AnimatedImageDecoder.streamDecoder(imageHeaderParsers, arrayPool2));
        registry2.append("Animation", ByteBuffer.class, Drawable.class, AnimatedImageDecoder.byteBufferDecoder(imageHeaderParsers, arrayPool2));
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context2);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool2);
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        BitmapBytesTranscoder bitmapBytesTranscoder2 = bitmapBytesTranscoder;
        ContentResolver contentResolver = context.getContentResolver();
        ResourceDrawableDecoder resourceDrawableDecoder2 = resourceDrawableDecoder;
        registry2.append(ByteBuffer.class, new ByteBufferEncoder()).append(InputStream.class, new StreamEncoder(arrayPool2)).append(Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, byteBufferBitmapDecoder).append(Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, streamBitmapDecoder);
        if (ParcelFileDescriptorRewinder.isSupported()) {
            registry2.append(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, new ParcelFileDescriptorBitmapDecoder(downsampler));
        }
        registry2.append(Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, VideoDecoder.asset(bitmapPool));
        Downsampler downsampler2 = downsampler;
        ResourceDecoder<ByteBuffer, Bitmap> resourceDecoder = byteBufferBitmapDecoder;
        ResourceDrawableDecoder resourceDrawableDecoder3 = resourceDrawableDecoder2;
        registry2.append(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, parcelFileDescriptorVideoDecoder).append(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).append(Bitmap.class, bitmapEncoder).append(Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBufferBitmapDecoder)).append(Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, streamBitmapDecoder)).append(Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, parcelFileDescriptorVideoDecoder)).append(BitmapDrawable.class, new BitmapDrawableEncoder(bitmapPool2, bitmapEncoder)).append("Animation", InputStream.class, GifDrawable.class, new StreamGifDecoder(imageHeaderParsers, byteBufferGifDecoder, arrayPool2)).append("Animation", ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).append(GifDrawable.class, new GifDrawableEncoder()).append(GifDecoder.class, GifDecoder.class, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, GifDecoder.class, Bitmap.class, new GifFrameResourceDecoder(bitmapPool2)).append(Uri.class, Drawable.class, resourceDrawableDecoder3).append(Uri.class, Bitmap.class, new ResourceBitmapDecoder(resourceDrawableDecoder3, bitmapPool2)).register((DataRewinder.Factory<?>) new ByteBufferRewinder.Factory()).append(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).append(File.class, InputStream.class, new FileLoader.StreamFactory()).append(File.class, File.class, new FileDecoder()).append(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).append(File.class, File.class, UnitModelLoader.Factory.getInstance()).register((DataRewinder.Factory<?>) new InputStreamRewinder.Factory(arrayPool2));
        if (ParcelFileDescriptorRewinder.isSupported()) {
            registry2.register((DataRewinder.Factory<?>) new ParcelFileDescriptorRewinder.Factory());
        }
        ModelLoaderFactory<Integer, InputStream> directResourceLoaderStreamFactory = DirectResourceLoader.inputStreamFactory(context);
        ModelLoaderFactory<Integer, AssetFileDescriptor> directResourceLoaderAssetFileDescriptorFactory = DirectResourceLoader.assetFileDescriptorFactory(context);
        ModelLoaderFactory<Integer, Drawable> directResourceLaoderDrawableFactory = DirectResourceLoader.drawableFactory(context);
        ModelLoaderFactory<Integer, InputStream> modelLoaderFactory = directResourceLoaderStreamFactory;
        registry2.append(Integer.TYPE, InputStream.class, directResourceLoaderStreamFactory).append(Integer.class, InputStream.class, directResourceLoaderStreamFactory).append(Integer.TYPE, AssetFileDescriptor.class, directResourceLoaderAssetFileDescriptorFactory).append(Integer.class, AssetFileDescriptor.class, directResourceLoaderAssetFileDescriptorFactory).append(Integer.TYPE, Drawable.class, directResourceLaoderDrawableFactory).append(Integer.class, Drawable.class, directResourceLaoderDrawableFactory).append(Uri.class, InputStream.class, ResourceUriLoader.newStreamFactory(context)).append(Uri.class, AssetFileDescriptor.class, ResourceUriLoader.newAssetFileDescriptorFactory(context));
        ResourceLoader.UriFactory resourceLoaderUriFactory = new ResourceLoader.UriFactory(resources);
        ResourceLoader.AssetFileDescriptorFactory resourceLoaderAssetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
        ResourceLoader.StreamFactory resourceLoaderStreamFactory = new ResourceLoader.StreamFactory(resources);
        List<ImageHeaderParser> list = imageHeaderParsers;
        registry2.append(Integer.class, Uri.class, resourceLoaderUriFactory).append(Integer.TYPE, Uri.class, resourceLoaderUriFactory).append(Integer.class, AssetFileDescriptor.class, resourceLoaderAssetFileDescriptorFactory).append(Integer.TYPE, AssetFileDescriptor.class, resourceLoaderAssetFileDescriptorFactory).append(Integer.class, InputStream.class, resourceLoaderStreamFactory).append(Integer.TYPE, InputStream.class, resourceLoaderStreamFactory);
        ResourceLoader.UriFactory uriFactory = resourceLoaderUriFactory;
        ByteBufferGifDecoder byteBufferGifDecoder2 = byteBufferGifDecoder;
        Context context3 = context;
        registry2.append(String.class, InputStream.class, new DataUrlLoader.StreamFactory()).append(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory()).append(String.class, InputStream.class, new StringLoader.StreamFactory()).append(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).append(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).append(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(context.getAssets())).append(Uri.class, AssetFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(context.getAssets())).append(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(context3)).append(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(context3));
        registry2.append(Uri.class, InputStream.class, new QMediaStoreUriLoader.InputStreamFactory(context3));
        registry2.append(Uri.class, ParcelFileDescriptor.class, new QMediaStoreUriLoader.FileDescriptorFactory(context3));
        ContentResolver contentResolver2 = contentResolver;
        ResourceDecoder<ParcelFileDescriptor, Bitmap> resourceDecoder2 = parcelFileDescriptorVideoDecoder;
        Class<byte[]> cls = byte[].class;
        ContentResolver contentResolver3 = contentResolver2;
        BitmapBytesTranscoder bitmapBytesTranscoder3 = bitmapBytesTranscoder2;
        ModelLoaderFactory<Integer, AssetFileDescriptor> modelLoaderFactory2 = directResourceLoaderAssetFileDescriptorFactory;
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder2 = gifDrawableBytesTranscoder;
        registry2.append(Uri.class, InputStream.class, new UriLoader.StreamFactory(contentResolver2)).append(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(contentResolver2)).append(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(contentResolver2)).append(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).append(URL.class, InputStream.class, new UrlLoader.StreamFactory()).append(Uri.class, File.class, new MediaStoreFileLoader.Factory(context3)).append(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory()).append(cls, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory()).append(cls, InputStream.class, new ByteArrayLoader.StreamFactory()).append(Uri.class, Uri.class, UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, new UnitDrawableDecoder()).register(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).register(Bitmap.class, cls, bitmapBytesTranscoder3).register(Drawable.class, cls, new DrawableBytesTranscoder(bitmapPool2, bitmapBytesTranscoder3, gifDrawableBytesTranscoder2)).register(GifDrawable.class, cls, gifDrawableBytesTranscoder2);
        ResourceDecoder<ByteBuffer, Bitmap> byteBufferVideoDecoder = VideoDecoder.byteBuffer(bitmapPool);
        registry2.append(ByteBuffer.class, Bitmap.class, byteBufferVideoDecoder);
        registry2.append(ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBufferVideoDecoder));
    }

    private static void initializeModules(Context context, Glide glide, Registry registry, List<GlideModule> manifestModules, AppGlideModule annotationGeneratedModule) {
        for (GlideModule module : manifestModules) {
            try {
                module.registerComponents(context, glide, registry);
            } catch (AbstractMethodError e) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + module.getClass().getName(), e);
            }
        }
        if (annotationGeneratedModule != null) {
            annotationGeneratedModule.registerComponents(context, glide, registry);
        }
    }
}

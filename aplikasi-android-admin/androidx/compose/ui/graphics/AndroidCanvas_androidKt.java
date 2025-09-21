package androidx.compose.ui.graphics;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00060\u0001j\u0002`\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006*\n\u0010\f\"\u00020\u00012\u00020\u0001¨\u0006\r"}, d2 = {"EmptyCanvas", "Landroid/graphics/Canvas;", "nativeCanvas", "Landroidx/compose/ui/graphics/NativeCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "getNativeCanvas", "(Landroidx/compose/ui/graphics/Canvas;)Landroid/graphics/Canvas;", "ActualCanvas", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "Canvas", "c", "NativeCanvas", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidCanvas.android.kt */
public final class AndroidCanvas_androidKt {
    /* access modifiers changed from: private */
    public static final Canvas EmptyCanvas = new Canvas();

    public static final Canvas ActualCanvas(ImageBitmap image) {
        Intrinsics.checkNotNullParameter(image, "image");
        AndroidCanvas $this$ActualCanvas_u24lambda_u240 = new AndroidCanvas();
        $this$ActualCanvas_u24lambda_u240.setInternalCanvas(new Canvas(AndroidImageBitmap_androidKt.asAndroidBitmap(image)));
        return $this$ActualCanvas_u24lambda_u240;
    }

    public static final Canvas Canvas(Canvas c) {
        Intrinsics.checkNotNullParameter(c, "c");
        AndroidCanvas $this$Canvas_u24lambda_u241 = new AndroidCanvas();
        $this$Canvas_u24lambda_u241.setInternalCanvas(c);
        return $this$Canvas_u24lambda_u241;
    }

    public static final Canvas getNativeCanvas(Canvas $this$nativeCanvas) {
        Intrinsics.checkNotNullParameter($this$nativeCanvas, "<this>");
        return ((AndroidCanvas) $this$nativeCanvas).getInternalCanvas();
    }
}

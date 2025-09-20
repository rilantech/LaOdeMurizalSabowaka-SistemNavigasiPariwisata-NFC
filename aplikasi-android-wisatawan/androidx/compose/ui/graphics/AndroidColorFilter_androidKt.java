package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a\n\u0010\u0012\u001a\u00020\u0013*\u00020\u0001\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0013*\f\b\u0000\u0010\u0015\"\u00020\u00132\u00020\u0013\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"actualColorMatrixColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "colorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "actualColorMatrixColorFilter-jHG-Opc", "([F)Landroidx/compose/ui/graphics/ColorFilter;", "actualLightingColorFilter", "multiply", "Landroidx/compose/ui/graphics/Color;", "add", "actualLightingColorFilter--OWjLjI", "(JJ)Landroidx/compose/ui/graphics/ColorFilter;", "actualTintColorFilter", "color", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "actualTintColorFilter-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "asAndroidColorFilter", "Landroid/graphics/ColorFilter;", "asComposeColorFilter", "NativeColorFilter", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidColorFilter.android.kt */
public final class AndroidColorFilter_androidKt {
    public static final ColorFilter asAndroidColorFilter(ColorFilter $this$asAndroidColorFilter) {
        Intrinsics.checkNotNullParameter($this$asAndroidColorFilter, "<this>");
        return $this$asAndroidColorFilter.getNativeColorFilter$ui_graphics_release();
    }

    public static final ColorFilter asComposeColorFilter(ColorFilter $this$asComposeColorFilter) {
        Intrinsics.checkNotNullParameter($this$asComposeColorFilter, "<this>");
        return new ColorFilter($this$asComposeColorFilter);
    }

    /* renamed from: actualTintColorFilter-xETnrds  reason: not valid java name */
    public static final ColorFilter m3110actualTintColorFilterxETnrds(long color, int blendMode) {
        return new ColorFilter(BlendModeColorFilterHelper.INSTANCE.m3188BlendModeColorFilterxETnrds(color, blendMode));
    }

    /* renamed from: actualColorMatrixColorFilter-jHG-Opc  reason: not valid java name */
    public static final ColorFilter m3108actualColorMatrixColorFilterjHGOpc(float[] colorMatrix) {
        Intrinsics.checkNotNullParameter(colorMatrix, "colorMatrix");
        return new ColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    /* renamed from: actualLightingColorFilter--OWjLjI  reason: not valid java name */
    public static final ColorFilter m3109actualLightingColorFilterOWjLjI(long multiply, long add) {
        return new ColorFilter(new LightingColorFilter(ColorKt.m3307toArgb8_81llA(multiply), ColorKt.m3307toArgb8_81llA(add)));
    }
}

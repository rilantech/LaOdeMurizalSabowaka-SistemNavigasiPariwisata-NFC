package androidx.compose.ui.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\u00020\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidBlendMode.android.kt */
public final class AndroidBlendMode_androidKt {
    /* renamed from: isSupported-s9anfk8  reason: not valid java name */
    public static final boolean m3094isSupporteds9anfk8(int $this$isSupported_u2ds9anfk8) {
        return true;
    }

    /* renamed from: toPorterDuffMode-s9anfk8  reason: not valid java name */
    public static final PorterDuff.Mode m3096toPorterDuffModes9anfk8(int $this$toPorterDuffMode_u2ds9anfk8) {
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3159getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3182getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3165getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3186getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3169getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3184getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3167getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3185getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3168getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3183getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3166getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3187getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3178getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3180getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3177getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3163getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3173getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m3155equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m3175getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toAndroidBlendMode-s9anfk8  reason: not valid java name */
    public static final BlendMode m3095toAndroidBlendModes9anfk8(int $this$toAndroidBlendMode_u2ds9anfk8) {
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3159getClear0nO6VwU())) {
            return BlendMode.CLEAR;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3182getSrc0nO6VwU())) {
            return BlendMode.SRC;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3165getDst0nO6VwU())) {
            return BlendMode.DST;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3186getSrcOver0nO6VwU())) {
            return BlendMode.SRC_OVER;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3169getDstOver0nO6VwU())) {
            return BlendMode.DST_OVER;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3184getSrcIn0nO6VwU())) {
            return BlendMode.SRC_IN;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3167getDstIn0nO6VwU())) {
            return BlendMode.DST_IN;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3185getSrcOut0nO6VwU())) {
            return BlendMode.SRC_OUT;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3168getDstOut0nO6VwU())) {
            return BlendMode.DST_OUT;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3183getSrcAtop0nO6VwU())) {
            return BlendMode.SRC_ATOP;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3166getDstAtop0nO6VwU())) {
            return BlendMode.DST_ATOP;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3187getXor0nO6VwU())) {
            return BlendMode.XOR;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3178getPlus0nO6VwU())) {
            return BlendMode.PLUS;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3175getModulate0nO6VwU())) {
            return BlendMode.MODULATE;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3180getScreen0nO6VwU())) {
            return BlendMode.SCREEN;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3177getOverlay0nO6VwU())) {
            return BlendMode.OVERLAY;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3163getDarken0nO6VwU())) {
            return BlendMode.DARKEN;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3173getLighten0nO6VwU())) {
            return BlendMode.LIGHTEN;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3162getColorDodge0nO6VwU())) {
            return BlendMode.COLOR_DODGE;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3161getColorBurn0nO6VwU())) {
            return BlendMode.COLOR_BURN;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3171getHardlight0nO6VwU())) {
            return BlendMode.HARD_LIGHT;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3181getSoftlight0nO6VwU())) {
            return BlendMode.SOFT_LIGHT;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3164getDifference0nO6VwU())) {
            return BlendMode.DIFFERENCE;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3170getExclusion0nO6VwU())) {
            return BlendMode.EXCLUSION;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3176getMultiply0nO6VwU())) {
            return BlendMode.MULTIPLY;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3172getHue0nO6VwU())) {
            return BlendMode.HUE;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3179getSaturation0nO6VwU())) {
            return BlendMode.SATURATION;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3160getColor0nO6VwU())) {
            return BlendMode.COLOR;
        }
        if (BlendMode.m3155equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m3174getLuminosity0nO6VwU())) {
            return BlendMode.LUMINOSITY;
        }
        return BlendMode.SRC_OVER;
    }
}

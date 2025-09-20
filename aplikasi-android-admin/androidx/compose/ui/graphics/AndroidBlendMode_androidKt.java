package androidx.compose.ui.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\u00020\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidBlendMode.android.kt */
public final class AndroidBlendMode_androidKt {
    /* renamed from: isSupported-s9anfk8  reason: not valid java name */
    public static final boolean m4804isSupporteds9anfk8(int $this$isSupported_u2ds9anfk8) {
        return true;
    }

    /* renamed from: toPorterDuffMode-s9anfk8  reason: not valid java name */
    public static final PorterDuff.Mode m4806toPorterDuffModes9anfk8(int $this$toPorterDuffMode_u2ds9anfk8) {
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4869getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4892getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4875getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4896getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4879getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4894getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4877getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4895getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4878getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4893getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4876getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4897getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4888getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4890getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4887getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4873getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4883getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m4865equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m4885getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toAndroidBlendMode-s9anfk8  reason: not valid java name */
    public static final BlendMode m4805toAndroidBlendModes9anfk8(int $this$toAndroidBlendMode_u2ds9anfk8) {
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4869getClear0nO6VwU())) {
            return BlendMode.CLEAR;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4892getSrc0nO6VwU())) {
            return BlendMode.SRC;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4875getDst0nO6VwU())) {
            return BlendMode.DST;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4896getSrcOver0nO6VwU())) {
            return BlendMode.SRC_OVER;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4879getDstOver0nO6VwU())) {
            return BlendMode.DST_OVER;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4894getSrcIn0nO6VwU())) {
            return BlendMode.SRC_IN;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4877getDstIn0nO6VwU())) {
            return BlendMode.DST_IN;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4895getSrcOut0nO6VwU())) {
            return BlendMode.SRC_OUT;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4878getDstOut0nO6VwU())) {
            return BlendMode.DST_OUT;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4893getSrcAtop0nO6VwU())) {
            return BlendMode.SRC_ATOP;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4876getDstAtop0nO6VwU())) {
            return BlendMode.DST_ATOP;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4897getXor0nO6VwU())) {
            return BlendMode.XOR;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4888getPlus0nO6VwU())) {
            return BlendMode.PLUS;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4885getModulate0nO6VwU())) {
            return BlendMode.MODULATE;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4890getScreen0nO6VwU())) {
            return BlendMode.SCREEN;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4887getOverlay0nO6VwU())) {
            return BlendMode.OVERLAY;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4873getDarken0nO6VwU())) {
            return BlendMode.DARKEN;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4883getLighten0nO6VwU())) {
            return BlendMode.LIGHTEN;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4872getColorDodge0nO6VwU())) {
            return BlendMode.COLOR_DODGE;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4871getColorBurn0nO6VwU())) {
            return BlendMode.COLOR_BURN;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4881getHardlight0nO6VwU())) {
            return BlendMode.HARD_LIGHT;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4891getSoftlight0nO6VwU())) {
            return BlendMode.SOFT_LIGHT;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4874getDifference0nO6VwU())) {
            return BlendMode.DIFFERENCE;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4880getExclusion0nO6VwU())) {
            return BlendMode.EXCLUSION;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4886getMultiply0nO6VwU())) {
            return BlendMode.MULTIPLY;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4882getHue0nO6VwU())) {
            return BlendMode.HUE;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4889getSaturation0nO6VwU())) {
            return BlendMode.SATURATION;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4870getColor0nO6VwU())) {
            return BlendMode.COLOR;
        }
        if (BlendMode.m4865equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m4884getLuminosity0nO6VwU())) {
            return BlendMode.LUMINOSITY;
        }
        return BlendMode.SRC_OVER;
    }
}

package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JvmInline
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 :2\u00020\u0001:\u0001:B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u000bJ\u0010\u0010\u001f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\u000bJ\u0010\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u000bJ\u0010\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u0010\u000bJ\u0010\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b&\u0010\u0013J\u001e\u0010'\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)J@\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007H\u0007ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001a\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u000203HÖ\u0001¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00108FX\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b\u0001\u0002ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "", "value", "Lkotlin/ULong;", "constructor-impl", "(J)J", "alpha", "", "getAlpha$annotations", "()V", "getAlpha-impl", "(J)F", "blue", "getBlue$annotations", "getBlue-impl", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace$annotations", "getColorSpace-impl", "(J)Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "green", "getGreen$annotations", "getGreen-impl", "red", "getRed$annotations", "getRed-impl", "getValue-s-VKNKU", "()J", "J", "component1", "component1-impl", "component2", "component2-impl", "component3", "component3-impl", "component4", "component4-impl", "component5", "component5-impl", "convert", "convert-vNxB06k", "(JLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "copy", "copy-wmQWz5c", "(JFFFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Color.kt */
public final class Color {
    /* access modifiers changed from: private */
    public static final long Black = ColorKt.Color(4278190080L);
    /* access modifiers changed from: private */
    public static final long Blue = ColorKt.Color(4278190335L);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Cyan = ColorKt.Color(4278255615L);
    /* access modifiers changed from: private */
    public static final long DarkGray = ColorKt.Color(4282664004L);
    /* access modifiers changed from: private */
    public static final long Gray = ColorKt.Color(4287137928L);
    /* access modifiers changed from: private */
    public static final long Green = ColorKt.Color(4278255360L);
    /* access modifiers changed from: private */
    public static final long LightGray = ColorKt.Color(4291611852L);
    /* access modifiers changed from: private */
    public static final long Magenta = ColorKt.Color(4294902015L);
    /* access modifiers changed from: private */
    public static final long Red = ColorKt.Color(4294901760L);
    /* access modifiers changed from: private */
    public static final long Transparent = ColorKt.Color(0);
    /* access modifiers changed from: private */
    public static final long Unspecified = ColorKt.Color(0.0f, 0.0f, 0.0f, 0.0f, ColorSpaces.INSTANCE.getUnspecified$ui_graphics_release());
    /* access modifiers changed from: private */
    public static final long White = ColorKt.Color(4294967295L);
    /* access modifiers changed from: private */
    public static final long Yellow = ColorKt.Color(4294967040L);
    private final long value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Color m3243boximpl(long j) {
        return new Color(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m3249constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3253equalsimpl(long j, Object obj) {
        return (obj instanceof Color) && j == ((Color) obj).m3263unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3254equalsimpl0(long j, long j2) {
        return ULong.m6410equalsimpl0(j, j2);
    }

    public static /* synthetic */ void getAlpha$annotations() {
    }

    public static /* synthetic */ void getBlue$annotations() {
    }

    public static /* synthetic */ void getColorSpace$annotations() {
    }

    public static /* synthetic */ void getGreen$annotations() {
    }

    public static /* synthetic */ void getRed$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3260hashCodeimpl(long j) {
        return ULong.m6415hashCodeimpl(j);
    }

    public boolean equals(Object obj) {
        return m3253equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3260hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m3263unboximpl() {
        return this.value;
    }

    private /* synthetic */ Color(long value2) {
        this.value = value2;
    }

    /* renamed from: getValue-s-VKNKU  reason: not valid java name */
    public final long m3262getValuesVKNKU() {
        return this.value;
    }

    /* renamed from: getColorSpace-impl  reason: not valid java name */
    public static final ColorSpace m3257getColorSpaceimpl(long arg0) {
        return ColorSpaces.INSTANCE.getColorSpacesArray$ui_graphics_release()[(int) ULong.m6403constructorimpl(63 & arg0)];
    }

    /* renamed from: convert-vNxB06k  reason: not valid java name */
    public static final long m3250convertvNxB06k(long arg0, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        ColorSpace thisColorSpace = m3257getColorSpaceimpl(arg0);
        if (Intrinsics.areEqual((Object) colorSpace, (Object) thisColorSpace)) {
            return arg0;
        }
        return ColorSpaceKt.m3708connectYBCOT_4$default(thisColorSpace, colorSpace, 0, 2, (Object) null).m3710transformToColorwmQWz5c$ui_graphics_release(m3259getRedimpl(arg0), m3258getGreenimpl(arg0), m3256getBlueimpl(arg0), m3255getAlphaimpl(arg0));
    }

    /* renamed from: getRed-impl  reason: not valid java name */
    public static final float m3259getRedimpl(long arg0) {
        if (ULong.m6403constructorimpl(63 & arg0) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m6403constructorimpl(ULong.m6403constructorimpl(arg0 >>> 48) & 255))) / 255.0f;
        }
        return Float16.m3375toFloatimpl(Float16.m3359constructorimpl((short) ((int) ULong.m6403constructorimpl(ULong.m6403constructorimpl(arg0 >>> 48) & 65535))));
    }

    /* renamed from: getGreen-impl  reason: not valid java name */
    public static final float m3258getGreenimpl(long arg0) {
        if (ULong.m6403constructorimpl(63 & arg0) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m6403constructorimpl(ULong.m6403constructorimpl(arg0 >>> 40) & 255))) / 255.0f;
        }
        return Float16.m3375toFloatimpl(Float16.m3359constructorimpl((short) ((int) ULong.m6403constructorimpl(ULong.m6403constructorimpl(arg0 >>> 32) & 65535))));
    }

    /* renamed from: getBlue-impl  reason: not valid java name */
    public static final float m3256getBlueimpl(long arg0) {
        if (ULong.m6403constructorimpl(63 & arg0) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m6403constructorimpl(ULong.m6403constructorimpl(arg0 >>> 32) & 255))) / 255.0f;
        }
        return Float16.m3375toFloatimpl(Float16.m3359constructorimpl((short) ((int) ULong.m6403constructorimpl(ULong.m6403constructorimpl(arg0 >>> 16) & 65535))));
    }

    /* renamed from: getAlpha-impl  reason: not valid java name */
    public static final float m3255getAlphaimpl(long arg0) {
        if (ULong.m6403constructorimpl(63 & arg0) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m6403constructorimpl(ULong.m6403constructorimpl(arg0 >>> 56) & 255))) / 255.0f;
        }
        return ((float) UnsignedKt.ulongToDouble(ULong.m6403constructorimpl(ULong.m6403constructorimpl(arg0 >>> 6) & 1023))) / 1023.0f;
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m3244component1impl(long arg0) {
        return m3259getRedimpl(arg0);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m3245component2impl(long arg0) {
        return m3258getGreenimpl(arg0);
    }

    /* renamed from: component3-impl  reason: not valid java name */
    public static final float m3246component3impl(long arg0) {
        return m3256getBlueimpl(arg0);
    }

    /* renamed from: component4-impl  reason: not valid java name */
    public static final float m3247component4impl(long arg0) {
        return m3255getAlphaimpl(arg0);
    }

    /* renamed from: component5-impl  reason: not valid java name */
    public static final ColorSpace m3248component5impl(long arg0) {
        return m3257getColorSpaceimpl(arg0);
    }

    /* renamed from: copy-wmQWz5c$default  reason: not valid java name */
    public static /* synthetic */ long m3252copywmQWz5c$default(long j, float f, float f2, float f3, float f4, int i, Object obj) {
        float f5;
        float f6;
        float f7;
        float f8;
        if ((i & 1) != 0) {
            f5 = m3255getAlphaimpl(j);
        } else {
            f5 = f;
        }
        if ((i & 2) != 0) {
            f6 = m3259getRedimpl(j);
        } else {
            f6 = f2;
        }
        if ((i & 4) != 0) {
            f7 = m3258getGreenimpl(j);
        } else {
            f7 = f3;
        }
        if ((i & 8) != 0) {
            f8 = m3256getBlueimpl(j);
        } else {
            f8 = f4;
        }
        return m3251copywmQWz5c(j, f5, f6, f7, f8);
    }

    /* renamed from: copy-wmQWz5c  reason: not valid java name */
    public static final long m3251copywmQWz5c(long arg0, float alpha, float red, float green, float blue) {
        return ColorKt.Color(red, green, blue, alpha, m3257getColorSpaceimpl(arg0));
    }

    public String toString() {
        return m3261toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3261toStringimpl(long arg0) {
        return "Color(" + m3259getRedimpl(arg0) + ", " + m3258getGreenimpl(arg0) + ", " + m3256getBlueimpl(arg0) + ", " + m3255getAlphaimpl(arg0) + ", " + m3257getColorSpaceimpl(arg0).getName() + ')';
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020/2\b\b\u0002\u00103\u001a\u000204ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J(\u00107\u001a\u00020/2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020/H\u0002JB\u0010=\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u0010>\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020/2\b\b\u0002\u00103\u001a\u000204ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u00106J(\u0010@\u001a\u00020/2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020/2\u0006\u0010A\u001a\u00020/H\u0002R'\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R'\u0010\t\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R'\u0010\f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007R'\u0010\u000f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R'\u0010\u0012\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0007R'\u0010\u0015\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0007R'\u0010\u0018\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u0007R'\u0010\u001b\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u0007R'\u0010\u001e\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0007R'\u0010!\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\"\u0010\u0002\u001a\u0004\b#\u0010\u0007R'\u0010$\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b%\u0010\u0002\u001a\u0004\b&\u0010\u0007R'\u0010'\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b(\u0010\u0002\u001a\u0004\b)\u0010\u0007R'\u0010*\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b+\u0010\u0002\u001a\u0004\b,\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/compose/ui/graphics/Color$Companion;", "", "()V", "Black", "Landroidx/compose/ui/graphics/Color;", "getBlack-0d7_KjU$annotations", "getBlack-0d7_KjU", "()J", "J", "Blue", "getBlue-0d7_KjU$annotations", "getBlue-0d7_KjU", "Cyan", "getCyan-0d7_KjU$annotations", "getCyan-0d7_KjU", "DarkGray", "getDarkGray-0d7_KjU$annotations", "getDarkGray-0d7_KjU", "Gray", "getGray-0d7_KjU$annotations", "getGray-0d7_KjU", "Green", "getGreen-0d7_KjU$annotations", "getGreen-0d7_KjU", "LightGray", "getLightGray-0d7_KjU$annotations", "getLightGray-0d7_KjU", "Magenta", "getMagenta-0d7_KjU$annotations", "getMagenta-0d7_KjU", "Red", "getRed-0d7_KjU$annotations", "getRed-0d7_KjU", "Transparent", "getTransparent-0d7_KjU$annotations", "getTransparent-0d7_KjU", "Unspecified", "getUnspecified-0d7_KjU$annotations", "getUnspecified-0d7_KjU", "White", "getWhite-0d7_KjU$annotations", "getWhite-0d7_KjU", "Yellow", "getYellow-0d7_KjU$annotations", "getYellow-0d7_KjU", "hsl", "hue", "", "saturation", "lightness", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "hsl-JlNiLsg", "(FFFFLandroidx/compose/ui/graphics/colorspace/Rgb;)J", "hslToRgbComponent", "n", "", "h", "s", "l", "hsv", "value", "hsv-JlNiLsg", "hsvToRgbComponent", "v", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Color.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getBlack-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3264getBlack0d7_KjU$annotations() {
        }

        /* renamed from: getBlue-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3265getBlue0d7_KjU$annotations() {
        }

        /* renamed from: getCyan-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3266getCyan0d7_KjU$annotations() {
        }

        /* renamed from: getDarkGray-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3267getDarkGray0d7_KjU$annotations() {
        }

        /* renamed from: getGray-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3268getGray0d7_KjU$annotations() {
        }

        /* renamed from: getGreen-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3269getGreen0d7_KjU$annotations() {
        }

        /* renamed from: getLightGray-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3270getLightGray0d7_KjU$annotations() {
        }

        /* renamed from: getMagenta-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3271getMagenta0d7_KjU$annotations() {
        }

        /* renamed from: getRed-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3272getRed0d7_KjU$annotations() {
        }

        /* renamed from: getTransparent-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3273getTransparent0d7_KjU$annotations() {
        }

        /* renamed from: getUnspecified-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3274getUnspecified0d7_KjU$annotations() {
        }

        /* renamed from: getWhite-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3275getWhite0d7_KjU$annotations() {
        }

        /* renamed from: getYellow-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3276getYellow0d7_KjU$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getBlack-0d7_KjU  reason: not valid java name */
        public final long m3279getBlack0d7_KjU() {
            return Color.Black;
        }

        /* renamed from: getDarkGray-0d7_KjU  reason: not valid java name */
        public final long m3282getDarkGray0d7_KjU() {
            return Color.DarkGray;
        }

        /* renamed from: getGray-0d7_KjU  reason: not valid java name */
        public final long m3283getGray0d7_KjU() {
            return Color.Gray;
        }

        /* renamed from: getLightGray-0d7_KjU  reason: not valid java name */
        public final long m3285getLightGray0d7_KjU() {
            return Color.LightGray;
        }

        /* renamed from: getWhite-0d7_KjU  reason: not valid java name */
        public final long m3290getWhite0d7_KjU() {
            return Color.White;
        }

        /* renamed from: getRed-0d7_KjU  reason: not valid java name */
        public final long m3287getRed0d7_KjU() {
            return Color.Red;
        }

        /* renamed from: getGreen-0d7_KjU  reason: not valid java name */
        public final long m3284getGreen0d7_KjU() {
            return Color.Green;
        }

        /* renamed from: getBlue-0d7_KjU  reason: not valid java name */
        public final long m3280getBlue0d7_KjU() {
            return Color.Blue;
        }

        /* renamed from: getYellow-0d7_KjU  reason: not valid java name */
        public final long m3291getYellow0d7_KjU() {
            return Color.Yellow;
        }

        /* renamed from: getCyan-0d7_KjU  reason: not valid java name */
        public final long m3281getCyan0d7_KjU() {
            return Color.Cyan;
        }

        /* renamed from: getMagenta-0d7_KjU  reason: not valid java name */
        public final long m3286getMagenta0d7_KjU() {
            return Color.Magenta;
        }

        /* renamed from: getTransparent-0d7_KjU  reason: not valid java name */
        public final long m3288getTransparent0d7_KjU() {
            return Color.Transparent;
        }

        /* renamed from: getUnspecified-0d7_KjU  reason: not valid java name */
        public final long m3289getUnspecified0d7_KjU() {
            return Color.Unspecified;
        }

        /* renamed from: hsv-JlNiLsg$default  reason: not valid java name */
        public static /* synthetic */ long m3278hsvJlNiLsg$default(Companion companion, float f, float f2, float f3, float f4, Rgb rgb, int i, Object obj) {
            float f5;
            if ((i & 8) != 0) {
                f5 = 1.0f;
            } else {
                f5 = f4;
            }
            return companion.m3293hsvJlNiLsg(f, f2, f3, f5, (i & 16) != 0 ? ColorSpaces.INSTANCE.getSrgb() : rgb);
        }

        /* renamed from: hsv-JlNiLsg  reason: not valid java name */
        public final long m3293hsvJlNiLsg(float hue, float saturation, float value, float alpha, Rgb colorSpace) {
            Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
            boolean z = false;
            if (0.0f <= hue && hue <= 360.0f) {
                if (0.0f <= saturation && saturation <= 1.0f) {
                    if (0.0f <= value && value <= 1.0f) {
                        z = true;
                    }
                }
            }
            if (z) {
                return ColorKt.Color(hsvToRgbComponent(5, hue, saturation, value), hsvToRgbComponent(3, hue, saturation, value), hsvToRgbComponent(1, hue, saturation, value), alpha, colorSpace);
            }
            throw new IllegalArgumentException(("HSV (" + hue + ", " + saturation + ", " + value + ") must be in range (0..360, 0..1, 0..1)").toString());
        }

        private final float hsvToRgbComponent(int n, float h, float s, float v) {
            float k = (((float) n) + (h / 60.0f)) % 6.0f;
            return v - ((v * s) * Math.max(0.0f, Math.min(k, Math.min(((float) 4) - k, 1.0f))));
        }

        /* renamed from: hsl-JlNiLsg$default  reason: not valid java name */
        public static /* synthetic */ long m3277hslJlNiLsg$default(Companion companion, float f, float f2, float f3, float f4, Rgb rgb, int i, Object obj) {
            float f5;
            if ((i & 8) != 0) {
                f5 = 1.0f;
            } else {
                f5 = f4;
            }
            return companion.m3292hslJlNiLsg(f, f2, f3, f5, (i & 16) != 0 ? ColorSpaces.INSTANCE.getSrgb() : rgb);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
            if ((0.0f <= r8 && r8 <= 1.0f) != false) goto L_0x0035;
         */
        /* renamed from: hsl-JlNiLsg  reason: not valid java name */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final long m3292hslJlNiLsg(float r6, float r7, float r8, float r9, androidx.compose.ui.graphics.colorspace.Rgb r10) {
            /*
                r5 = this;
                java.lang.String r0 = "colorSpace"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                r0 = 0
                int r1 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                r2 = 1
                r3 = 0
                if (r1 > 0) goto L_0x0014
                r1 = 1135869952(0x43b40000, float:360.0)
                int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
                if (r1 > 0) goto L_0x0014
                r1 = r2
                goto L_0x0015
            L_0x0014:
                r1 = r3
            L_0x0015:
                if (r1 == 0) goto L_0x0034
                int r1 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                r4 = 1065353216(0x3f800000, float:1.0)
                if (r1 > 0) goto L_0x0023
                int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
                if (r1 > 0) goto L_0x0023
                r1 = r2
                goto L_0x0024
            L_0x0023:
                r1 = r3
            L_0x0024:
                if (r1 == 0) goto L_0x0034
                int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                if (r0 > 0) goto L_0x0030
                int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r0 > 0) goto L_0x0030
                r0 = r2
                goto L_0x0031
            L_0x0030:
                r0 = r3
            L_0x0031:
                if (r0 == 0) goto L_0x0034
                goto L_0x0035
            L_0x0034:
                r2 = r3
            L_0x0035:
                if (r2 == 0) goto L_0x004e
                float r0 = r5.hslToRgbComponent(r3, r6, r7, r8)
                r1 = 8
                float r1 = r5.hslToRgbComponent(r1, r6, r7, r8)
                r2 = 4
                float r2 = r5.hslToRgbComponent(r2, r6, r7, r8)
                r3 = r10
                androidx.compose.ui.graphics.colorspace.ColorSpace r3 = (androidx.compose.ui.graphics.colorspace.ColorSpace) r3
                long r3 = androidx.compose.ui.graphics.ColorKt.Color(r0, r1, r2, r9, r3)
                return r3
            L_0x004e:
                r0 = 0
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "HSL ("
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.StringBuilder r1 = r1.append(r6)
                java.lang.String r2 = ", "
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.StringBuilder r1 = r1.append(r7)
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.StringBuilder r1 = r1.append(r8)
                java.lang.String r2 = ") must be in range (0..360, 0..1, 0..1)"
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r0 = r1.toString()
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r0 = r0.toString()
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.Color.Companion.m3292hslJlNiLsg(float, float, float, float, androidx.compose.ui.graphics.colorspace.Rgb):long");
        }

        private final float hslToRgbComponent(int n, float h, float s, float l) {
            float k = (((float) n) + (h / 30.0f)) % 12.0f;
            return l - (Math.max(-1.0f, Math.min(k - ((float) 3), Math.min(((float) 9) - k, 1.0f))) * (Math.min(l, 1.0f - l) * s));
        }
    }
}

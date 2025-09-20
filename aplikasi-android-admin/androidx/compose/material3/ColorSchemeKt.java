package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001aµ\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+\u001aµ\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010+\u001a)\u0010.\u001a\u00020\b*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010/\u001a\u000200H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\u001a\u001f\u0010\u0007\u001a\u00020\b*\u00020\u00042\u0006\u0010\t\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\u001a\u001c\u00105\u001a\u00020\b*\u00020\u00042\u0006\u00106\u001a\u000207H\u0000ø\u0001\u0001¢\u0006\u0002\u00108\u001a\u001f\u00109\u001a\u00020\b*\u00020\u00042\u0006\u0010/\u001a\u000200ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010;\u001a\u0014\u0010<\u001a\u00020\b*\u000207H\u0001ø\u0001\u0001¢\u0006\u0002\u0010=\u001a\u0014\u0010>\u001a\u00020?*\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006A"}, d2 = {"DisabledAlpha", "", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/ColorScheme;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "contentColorFor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColorScheme", "primary", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "darkColorScheme-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "lightColorScheme", "lightColorScheme-G1PFc-w", "applyTonalElevation", "elevation", "Landroidx/compose/ui/unit/Dp;", "applyTonalElevation-Hht5A8o", "(Landroidx/compose/material3/ColorScheme;JF)J", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "fromToken", "value", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "surfaceColorAtElevation", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "toColor", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "updateColorSchemeFrom", "", "other", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ColorScheme.kt */
public final class ColorSchemeKt {
    public static final float DisabledAlpha = 0.38f;
    private static final ProvidableCompositionLocal<ColorScheme> LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(ColorSchemeKt$LocalColorScheme$1.INSTANCE);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ColorScheme.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ColorSchemeKeyTokens.values().length];
            try {
                iArr[ColorSchemeKeyTokens.Background.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Error.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                iArr[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
            } catch (NoSuchFieldError e26) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
            } catch (NoSuchFieldError e27) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Tertiary.ordinal()] = 28;
            } catch (NoSuchFieldError e28) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 29;
            } catch (NoSuchFieldError e29) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: lightColorScheme-G1PFc-w$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m3373lightColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long j30;
        long j31;
        long j32;
        long j33;
        long j34;
        int i2 = i;
        if ((i2 & 1) != 0) {
            j30 = ColorLightTokens.INSTANCE.m4078getPrimary0d7_KjU();
        } else {
            j30 = j;
        }
        if ((i2 & 2) != 0) {
            j31 = ColorLightTokens.INSTANCE.m4068getOnPrimary0d7_KjU();
        } else {
            j31 = j2;
        }
        if ((i2 & 4) != 0) {
            j32 = ColorLightTokens.INSTANCE.m4079getPrimaryContainer0d7_KjU();
        } else {
            j32 = j3;
        }
        if ((i2 & 8) != 0) {
            j33 = ColorLightTokens.INSTANCE.m4069getOnPrimaryContainer0d7_KjU();
        } else {
            j33 = j4;
        }
        long r9 = (i2 & 16) != 0 ? ColorLightTokens.INSTANCE.m4063getInversePrimary0d7_KjU() : j5;
        long r11 = (i2 & 32) != 0 ? ColorLightTokens.INSTANCE.m4081getSecondary0d7_KjU() : j6;
        long r13 = (i2 & 64) != 0 ? ColorLightTokens.INSTANCE.m4070getOnSecondary0d7_KjU() : j7;
        long r59 = (i2 & 128) != 0 ? ColorLightTokens.INSTANCE.m4082getSecondaryContainer0d7_KjU() : j8;
        long r61 = (i2 & 256) != 0 ? ColorLightTokens.INSTANCE.m4071getOnSecondaryContainer0d7_KjU() : j9;
        long r63 = (i2 & 512) != 0 ? ColorLightTokens.INSTANCE.m4086getTertiary0d7_KjU() : j10;
        long r65 = (i2 & 1024) != 0 ? ColorLightTokens.INSTANCE.m4074getOnTertiary0d7_KjU() : j11;
        long r67 = (i2 & 2048) != 0 ? ColorLightTokens.INSTANCE.m4087getTertiaryContainer0d7_KjU() : j12;
        long r69 = (i2 & 4096) != 0 ? ColorLightTokens.INSTANCE.m4075getOnTertiaryContainer0d7_KjU() : j13;
        long r71 = (i2 & 8192) != 0 ? ColorLightTokens.INSTANCE.m4059getBackground0d7_KjU() : j14;
        long r15 = (i2 & 16384) != 0 ? ColorLightTokens.INSTANCE.m4065getOnBackground0d7_KjU() : j15;
        long r17 = (i2 & 32768) != 0 ? ColorLightTokens.INSTANCE.m4083getSurface0d7_KjU() : j16;
        long r19 = (i2 & 65536) != 0 ? ColorLightTokens.INSTANCE.m4072getOnSurface0d7_KjU() : j17;
        long r21 = (i2 & 131072) != 0 ? ColorLightTokens.INSTANCE.m4085getSurfaceVariant0d7_KjU() : j18;
        long r23 = (i2 & 262144) != 0 ? ColorLightTokens.INSTANCE.m4073getOnSurfaceVariant0d7_KjU() : j19;
        if ((i2 & 524288) != 0) {
            j34 = j30;
        } else {
            j34 = j20;
        }
        return m3372lightColorSchemeG1PFcw(j30, j31, j32, j33, r9, r11, r13, r59, r61, r63, r65, r67, r69, r71, r15, r17, r19, r21, r23, j34, (i2 & 1048576) != 0 ? ColorLightTokens.INSTANCE.m4064getInverseSurface0d7_KjU() : j21, (i2 & 2097152) != 0 ? ColorLightTokens.INSTANCE.m4062getInverseOnSurface0d7_KjU() : j22, (i2 & 4194304) != 0 ? ColorLightTokens.INSTANCE.m4060getError0d7_KjU() : j23, (i2 & 8388608) != 0 ? ColorLightTokens.INSTANCE.m4066getOnError0d7_KjU() : j24, (i2 & 16777216) != 0 ? ColorLightTokens.INSTANCE.m4061getErrorContainer0d7_KjU() : j25, (i2 & 33554432) != 0 ? ColorLightTokens.INSTANCE.m4067getOnErrorContainer0d7_KjU() : j26, (i2 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorLightTokens.INSTANCE.m4076getOutline0d7_KjU() : j27, (i2 & 134217728) != 0 ? ColorLightTokens.INSTANCE.m4077getOutlineVariant0d7_KjU() : j28, (i2 & 268435456) != 0 ? ColorLightTokens.INSTANCE.m4080getScrim0d7_KjU() : j29);
    }

    /* renamed from: lightColorScheme-G1PFc-w  reason: not valid java name */
    public static final ColorScheme m3372lightColorSchemeG1PFcw(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        return new ColorScheme(primary, onPrimary, primaryContainer, onPrimaryContainer, inversePrimary, secondary, onSecondary, secondaryContainer, onSecondaryContainer, tertiary, onTertiary, tertiaryContainer, onTertiaryContainer, background, onBackground, surface, onSurface, surfaceVariant, onSurfaceVariant, surfaceTint, inverseSurface, inverseOnSurface, error, onError, errorContainer, onErrorContainer, outline, outlineVariant, scrim, (DefaultConstructorMarker) null);
    }

    /* renamed from: darkColorScheme-G1PFc-w$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m3371darkColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long j30;
        long j31;
        long j32;
        long j33;
        long j34;
        int i2 = i;
        if ((i2 & 1) != 0) {
            j30 = ColorDarkTokens.INSTANCE.m4049getPrimary0d7_KjU();
        } else {
            j30 = j;
        }
        if ((i2 & 2) != 0) {
            j31 = ColorDarkTokens.INSTANCE.m4039getOnPrimary0d7_KjU();
        } else {
            j31 = j2;
        }
        if ((i2 & 4) != 0) {
            j32 = ColorDarkTokens.INSTANCE.m4050getPrimaryContainer0d7_KjU();
        } else {
            j32 = j3;
        }
        if ((i2 & 8) != 0) {
            j33 = ColorDarkTokens.INSTANCE.m4040getOnPrimaryContainer0d7_KjU();
        } else {
            j33 = j4;
        }
        long r9 = (i2 & 16) != 0 ? ColorDarkTokens.INSTANCE.m4034getInversePrimary0d7_KjU() : j5;
        long r11 = (i2 & 32) != 0 ? ColorDarkTokens.INSTANCE.m4052getSecondary0d7_KjU() : j6;
        long r13 = (i2 & 64) != 0 ? ColorDarkTokens.INSTANCE.m4041getOnSecondary0d7_KjU() : j7;
        long r59 = (i2 & 128) != 0 ? ColorDarkTokens.INSTANCE.m4053getSecondaryContainer0d7_KjU() : j8;
        long r61 = (i2 & 256) != 0 ? ColorDarkTokens.INSTANCE.m4042getOnSecondaryContainer0d7_KjU() : j9;
        long r63 = (i2 & 512) != 0 ? ColorDarkTokens.INSTANCE.m4057getTertiary0d7_KjU() : j10;
        long r65 = (i2 & 1024) != 0 ? ColorDarkTokens.INSTANCE.m4045getOnTertiary0d7_KjU() : j11;
        long r67 = (i2 & 2048) != 0 ? ColorDarkTokens.INSTANCE.m4058getTertiaryContainer0d7_KjU() : j12;
        long r69 = (i2 & 4096) != 0 ? ColorDarkTokens.INSTANCE.m4046getOnTertiaryContainer0d7_KjU() : j13;
        long r71 = (i2 & 8192) != 0 ? ColorDarkTokens.INSTANCE.m4030getBackground0d7_KjU() : j14;
        long r15 = (i2 & 16384) != 0 ? ColorDarkTokens.INSTANCE.m4036getOnBackground0d7_KjU() : j15;
        long r17 = (i2 & 32768) != 0 ? ColorDarkTokens.INSTANCE.m4054getSurface0d7_KjU() : j16;
        long r19 = (i2 & 65536) != 0 ? ColorDarkTokens.INSTANCE.m4043getOnSurface0d7_KjU() : j17;
        long r21 = (i2 & 131072) != 0 ? ColorDarkTokens.INSTANCE.m4056getSurfaceVariant0d7_KjU() : j18;
        long r23 = (i2 & 262144) != 0 ? ColorDarkTokens.INSTANCE.m4044getOnSurfaceVariant0d7_KjU() : j19;
        if ((i2 & 524288) != 0) {
            j34 = j30;
        } else {
            j34 = j20;
        }
        return m3370darkColorSchemeG1PFcw(j30, j31, j32, j33, r9, r11, r13, r59, r61, r63, r65, r67, r69, r71, r15, r17, r19, r21, r23, j34, (i2 & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m4035getInverseSurface0d7_KjU() : j21, (i2 & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m4033getInverseOnSurface0d7_KjU() : j22, (i2 & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m4031getError0d7_KjU() : j23, (i2 & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m4037getOnError0d7_KjU() : j24, (i2 & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m4032getErrorContainer0d7_KjU() : j25, (i2 & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m4038getOnErrorContainer0d7_KjU() : j26, (i2 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorDarkTokens.INSTANCE.m4047getOutline0d7_KjU() : j27, (i2 & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m4048getOutlineVariant0d7_KjU() : j28, (i2 & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m4051getScrim0d7_KjU() : j29);
    }

    /* renamed from: darkColorScheme-G1PFc-w  reason: not valid java name */
    public static final ColorScheme m3370darkColorSchemeG1PFcw(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        return new ColorScheme(primary, onPrimary, primaryContainer, onPrimaryContainer, inversePrimary, secondary, onSecondary, secondaryContainer, onSecondaryContainer, tertiary, onTertiary, tertiaryContainer, onTertiaryContainer, background, onBackground, surface, onSurface, surfaceVariant, onSurfaceVariant, surfaceTint, inverseSurface, inverseOnSurface, error, onError, errorContainer, onErrorContainer, outline, outlineVariant, scrim, (DefaultConstructorMarker) null);
    }

    /* renamed from: contentColorFor-4WTKRHQ  reason: not valid java name */
    public static final long m3368contentColorFor4WTKRHQ(ColorScheme $this$contentColorFor_u2d4WTKRHQ, long backgroundColor) {
        Intrinsics.checkNotNullParameter($this$contentColorFor_u2d4WTKRHQ, "$this$contentColorFor");
        if (Color.m4964equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m3328getPrimary0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m3318getOnPrimary0d7_KjU();
        }
        if (Color.m4964equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m3331getSecondary0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m3320getOnSecondary0d7_KjU();
        }
        if (Color.m4964equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m3336getTertiary0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m3324getOnTertiary0d7_KjU();
        }
        if (Color.m4964equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m3309getBackground0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m3315getOnBackground0d7_KjU();
        }
        if (Color.m4964equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m3310getError0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m3316getOnError0d7_KjU();
        }
        if (Color.m4964equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m3333getSurface0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m3322getOnSurface0d7_KjU();
        }
        if (Color.m4964equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m3335getSurfaceVariant0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m3323getOnSurfaceVariant0d7_KjU();
        }
        if (Color.m4964equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m3329getPrimaryContainer0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m3319getOnPrimaryContainer0d7_KjU();
        }
        if (Color.m4964equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m3332getSecondaryContainer0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m3321getOnSecondaryContainer0d7_KjU();
        }
        if (Color.m4964equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m3337getTertiaryContainer0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m3325getOnTertiaryContainer0d7_KjU();
        }
        if (Color.m4964equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m3311getErrorContainer0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m3317getOnErrorContainer0d7_KjU();
        }
        if (Color.m4964equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m3314getInverseSurface0d7_KjU())) {
            return $this$contentColorFor_u2d4WTKRHQ.m3312getInverseOnSurface0d7_KjU();
        }
        return Color.Companion.m4999getUnspecified0d7_KjU();
    }

    /* renamed from: contentColorFor-ek8zF_U  reason: not valid java name */
    public static final long m3369contentColorForek8zF_U(long backgroundColor, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 509589638, "C(contentColorFor)P(0:c#ui.graphics.Color)*474@21497L11,475@21581L7:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, $changed, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:473)");
        }
        long $this$takeOrElse_u2dDxMtmZc$iv = m3368contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme($composer, 6), backgroundColor);
        if (!($this$takeOrElse_u2dDxMtmZc$iv != Color.Companion.m4999getUnspecified0d7_KjU())) {
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer);
            $this$takeOrElse_u2dDxMtmZc$iv = ((Color) consume).m4973unboximpl();
        }
        if (ComposerKt.isTraceInProgress() != 0) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return $this$takeOrElse_u2dDxMtmZc$iv;
    }

    /* renamed from: applyTonalElevation-Hht5A8o  reason: not valid java name */
    public static final long m3367applyTonalElevationHht5A8o(ColorScheme $this$applyTonalElevation_u2dHht5A8o, long backgroundColor, float elevation) {
        Intrinsics.checkNotNullParameter($this$applyTonalElevation_u2dHht5A8o, "$this$applyTonalElevation");
        if (Color.m4964equalsimpl0(backgroundColor, $this$applyTonalElevation_u2dHht5A8o.m3333getSurface0d7_KjU())) {
            return m3374surfaceColorAtElevation3ABfNKs($this$applyTonalElevation_u2dHht5A8o, elevation);
        }
        return backgroundColor;
    }

    /* renamed from: surfaceColorAtElevation-3ABfNKs  reason: not valid java name */
    public static final long m3374surfaceColorAtElevation3ABfNKs(ColorScheme $this$surfaceColorAtElevation_u2d3ABfNKs, float elevation) {
        Intrinsics.checkNotNullParameter($this$surfaceColorAtElevation_u2d3ABfNKs, "$this$surfaceColorAtElevation");
        if (Dp.m7559equalsimpl0(elevation, Dp.m7554constructorimpl((float) 0)) != 0) {
            return $this$surfaceColorAtElevation_u2d3ABfNKs.m3333getSurface0d7_KjU();
        }
        return ColorKt.m5008compositeOverOWjLjI(Color.m4962copywmQWz5c$default($this$surfaceColorAtElevation_u2d3ABfNKs.m3334getSurfaceTint0d7_KjU(), ((((float) Math.log((double) (((float) 1) + elevation))) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), $this$surfaceColorAtElevation_u2d3ABfNKs.m3333getSurface0d7_KjU());
    }

    public static final void updateColorSchemeFrom(ColorScheme $this$updateColorSchemeFrom, ColorScheme other) {
        Intrinsics.checkNotNullParameter($this$updateColorSchemeFrom, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        $this$updateColorSchemeFrom.m3357setPrimary8_81llA$material3_release(other.m3328getPrimary0d7_KjU());
        $this$updateColorSchemeFrom.m3347setOnPrimary8_81llA$material3_release(other.m3318getOnPrimary0d7_KjU());
        $this$updateColorSchemeFrom.m3358setPrimaryContainer8_81llA$material3_release(other.m3329getPrimaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m3348setOnPrimaryContainer8_81llA$material3_release(other.m3319getOnPrimaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m3342setInversePrimary8_81llA$material3_release(other.m3313getInversePrimary0d7_KjU());
        $this$updateColorSchemeFrom.m3360setSecondary8_81llA$material3_release(other.m3331getSecondary0d7_KjU());
        $this$updateColorSchemeFrom.m3349setOnSecondary8_81llA$material3_release(other.m3320getOnSecondary0d7_KjU());
        $this$updateColorSchemeFrom.m3361setSecondaryContainer8_81llA$material3_release(other.m3332getSecondaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m3350setOnSecondaryContainer8_81llA$material3_release(other.m3321getOnSecondaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m3365setTertiary8_81llA$material3_release(other.m3336getTertiary0d7_KjU());
        $this$updateColorSchemeFrom.m3353setOnTertiary8_81llA$material3_release(other.m3324getOnTertiary0d7_KjU());
        $this$updateColorSchemeFrom.m3366setTertiaryContainer8_81llA$material3_release(other.m3337getTertiaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m3354setOnTertiaryContainer8_81llA$material3_release(other.m3325getOnTertiaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m3338setBackground8_81llA$material3_release(other.m3309getBackground0d7_KjU());
        $this$updateColorSchemeFrom.m3344setOnBackground8_81llA$material3_release(other.m3315getOnBackground0d7_KjU());
        $this$updateColorSchemeFrom.m3362setSurface8_81llA$material3_release(other.m3333getSurface0d7_KjU());
        $this$updateColorSchemeFrom.m3351setOnSurface8_81llA$material3_release(other.m3322getOnSurface0d7_KjU());
        $this$updateColorSchemeFrom.m3364setSurfaceVariant8_81llA$material3_release(other.m3335getSurfaceVariant0d7_KjU());
        $this$updateColorSchemeFrom.m3352setOnSurfaceVariant8_81llA$material3_release(other.m3323getOnSurfaceVariant0d7_KjU());
        $this$updateColorSchemeFrom.m3363setSurfaceTint8_81llA$material3_release(other.m3334getSurfaceTint0d7_KjU());
        $this$updateColorSchemeFrom.m3343setInverseSurface8_81llA$material3_release(other.m3314getInverseSurface0d7_KjU());
        $this$updateColorSchemeFrom.m3341setInverseOnSurface8_81llA$material3_release(other.m3312getInverseOnSurface0d7_KjU());
        $this$updateColorSchemeFrom.m3339setError8_81llA$material3_release(other.m3310getError0d7_KjU());
        $this$updateColorSchemeFrom.m3345setOnError8_81llA$material3_release(other.m3316getOnError0d7_KjU());
        $this$updateColorSchemeFrom.m3340setErrorContainer8_81llA$material3_release(other.m3311getErrorContainer0d7_KjU());
        $this$updateColorSchemeFrom.m3346setOnErrorContainer8_81llA$material3_release(other.m3317getOnErrorContainer0d7_KjU());
        $this$updateColorSchemeFrom.m3355setOutline8_81llA$material3_release(other.m3326getOutline0d7_KjU());
        $this$updateColorSchemeFrom.m3356setOutlineVariant8_81llA$material3_release(other.m3327getOutlineVariant0d7_KjU());
        $this$updateColorSchemeFrom.m3359setScrim8_81llA$material3_release(other.m3330getScrim0d7_KjU());
    }

    public static final long fromToken(ColorScheme $this$fromToken, ColorSchemeKeyTokens value) {
        Intrinsics.checkNotNullParameter($this$fromToken, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
            case 1:
                return $this$fromToken.m3309getBackground0d7_KjU();
            case 2:
                return $this$fromToken.m3310getError0d7_KjU();
            case 3:
                return $this$fromToken.m3311getErrorContainer0d7_KjU();
            case 4:
                return $this$fromToken.m3312getInverseOnSurface0d7_KjU();
            case 5:
                return $this$fromToken.m3313getInversePrimary0d7_KjU();
            case 6:
                return $this$fromToken.m3314getInverseSurface0d7_KjU();
            case 7:
                return $this$fromToken.m3315getOnBackground0d7_KjU();
            case 8:
                return $this$fromToken.m3316getOnError0d7_KjU();
            case 9:
                return $this$fromToken.m3317getOnErrorContainer0d7_KjU();
            case 10:
                return $this$fromToken.m3318getOnPrimary0d7_KjU();
            case 11:
                return $this$fromToken.m3319getOnPrimaryContainer0d7_KjU();
            case 12:
                return $this$fromToken.m3320getOnSecondary0d7_KjU();
            case 13:
                return $this$fromToken.m3321getOnSecondaryContainer0d7_KjU();
            case 14:
                return $this$fromToken.m3322getOnSurface0d7_KjU();
            case 15:
                return $this$fromToken.m3323getOnSurfaceVariant0d7_KjU();
            case 16:
                return $this$fromToken.m3334getSurfaceTint0d7_KjU();
            case 17:
                return $this$fromToken.m3324getOnTertiary0d7_KjU();
            case 18:
                return $this$fromToken.m3325getOnTertiaryContainer0d7_KjU();
            case 19:
                return $this$fromToken.m3326getOutline0d7_KjU();
            case 20:
                return $this$fromToken.m3327getOutlineVariant0d7_KjU();
            case 21:
                return $this$fromToken.m3328getPrimary0d7_KjU();
            case 22:
                return $this$fromToken.m3329getPrimaryContainer0d7_KjU();
            case 23:
                return $this$fromToken.m3330getScrim0d7_KjU();
            case 24:
                return $this$fromToken.m3331getSecondary0d7_KjU();
            case 25:
                return $this$fromToken.m3332getSecondaryContainer0d7_KjU();
            case 26:
                return $this$fromToken.m3333getSurface0d7_KjU();
            case 27:
                return $this$fromToken.m3335getSurfaceVariant0d7_KjU();
            case 28:
                return $this$fromToken.m3336getTertiary0d7_KjU();
            case 29:
                return $this$fromToken.m3337getTertiaryContainer0d7_KjU();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ProvidableCompositionLocal<ColorScheme> getLocalColorScheme() {
        return LocalColorScheme;
    }

    public static final long toColor(ColorSchemeKeyTokens $this$toColor, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$toColor, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, 1330949347, "C(toColor)612@27498L11:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1330949347, $changed, -1, "androidx.compose.material3.toColor (ColorScheme.kt:611)");
        }
        long fromToken = fromToken(MaterialTheme.INSTANCE.getColorScheme($composer, 6), $this$toColor);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return fromToken;
    }
}

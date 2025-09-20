package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J3\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.JG\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J3\u00103\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105J3\u00106\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00105R\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0013\u0010\rR\u000e\u0010\u0014\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\nR\u0019\u0010\u001a\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u001b\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, d2 = {"Landroidx/compose/material/ButtonDefaults;", "", "()V", "ButtonHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonVerticalPadding", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "IconSize", "getIconSize-D9Ej5fM", "()F", "IconSpacing", "getIconSpacing-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "OutlinedBorderOpacity", "", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonHorizontalPadding", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "buttonColors", "Landroidx/compose/material/ButtonColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledBackgroundColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "elevation", "Landroidx/compose/material/ButtonElevation;", "defaultElevation", "pressedElevation", "disabledElevation", "elevation-yajeYGU", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "outlinedButtonColors", "outlinedButtonColors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "textButtonColors", "textButtonColors-RGew2ao", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Button.kt */
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonHorizontalPadding;
    private static final float ButtonVerticalPadding;
    private static final PaddingValues ContentPadding;
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize = Dp.m5844constructorimpl((float) 18);
    private static final float IconSpacing = Dp.m5844constructorimpl((float) 8);
    private static final float MinHeight = Dp.m5844constructorimpl((float) 36);
    private static final float MinWidth = Dp.m5844constructorimpl((float) 64);
    public static final float OutlinedBorderOpacity = 0.12f;
    private static final float OutlinedBorderSize = Dp.m5844constructorimpl((float) 1);
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;

    private ButtonDefaults() {
    }

    static {
        float r0 = Dp.m5844constructorimpl((float) 16);
        ButtonHorizontalPadding = r0;
        float r1 = Dp.m5844constructorimpl((float) 8);
        ButtonVerticalPadding = r1;
        PaddingValues r02 = PaddingKt.m534PaddingValuesa9UjIt4(r0, r1, r0, r1);
        ContentPadding = r02;
        float r12 = Dp.m5844constructorimpl((float) 8);
        TextButtonHorizontalPadding = r12;
        TextButtonContentPadding = PaddingKt.m534PaddingValuesa9UjIt4(r12, r02.m555calculateTopPaddingD9Ej5fM(), r12, r02.m552calculateBottomPaddingD9Ej5fM());
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m1212getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m1211getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1209getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* renamed from: getIconSpacing-D9Ej5fM  reason: not valid java name */
    public final float m1210getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    /* renamed from: elevation-yajeYGU  reason: not valid java name */
    public final /* synthetic */ ButtonElevation m1208elevationyajeYGU(float defaultElevation, float pressedElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float disabledElevation2;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(1428576874);
        ComposerKt.sourceInformation(composer, "C(elevation)P(0:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp)349@14667L161:Button.kt#jmzs0o");
        float defaultElevation2 = (i & 1) != 0 ? Dp.m5844constructorimpl((float) 2) : defaultElevation;
        if ((i & 2) != 0) {
            pressedElevation2 = Dp.m5844constructorimpl((float) 8);
        } else {
            pressedElevation2 = pressedElevation;
        }
        if ((i & 4) != 0) {
            disabledElevation2 = Dp.m5844constructorimpl((float) 0);
        } else {
            disabledElevation2 = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1428576874, i2, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:345)");
        }
        ButtonElevation r0 = m1207elevationR_JCAzs(defaultElevation2, pressedElevation2, disabledElevation2, Dp.m5844constructorimpl((float) 4), Dp.m5844constructorimpl((float) 4), $composer, (i2 & 14) | 27648 | (i2 & 112) | (i2 & 896) | ((i2 << 6) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }

    /* renamed from: elevation-R_JCAzs  reason: not valid java name */
    public final ButtonElevation m1207elevationR_JCAzs(float defaultElevation, float pressedElevation, float disabledElevation, float hoveredElevation, float focusedElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float disabledElevation2;
        float hoveredElevation2;
        float focusedElevation2;
        Composer composer = $composer;
        composer.startReplaceableGroup(-737170518);
        ComposerKt.sourceInformation(composer, "C(elevation)P(0:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,3:c#ui.unit.Dp,2:c#ui.unit.Dp)378@15799L497:Button.kt#jmzs0o");
        float defaultElevation2 = (i & 1) != 0 ? Dp.m5844constructorimpl((float) 2) : defaultElevation;
        if ((i & 2) != 0) {
            pressedElevation2 = Dp.m5844constructorimpl((float) 8);
        } else {
            pressedElevation2 = pressedElevation;
        }
        if ((i & 4) != 0) {
            disabledElevation2 = Dp.m5844constructorimpl((float) 0);
        } else {
            disabledElevation2 = disabledElevation;
        }
        if ((i & 8) != 0) {
            hoveredElevation2 = Dp.m5844constructorimpl((float) 4);
        } else {
            hoveredElevation2 = hoveredElevation;
        }
        if ((i & 16) != 0) {
            focusedElevation2 = Dp.m5844constructorimpl((float) 4);
        } else {
            focusedElevation2 = focusedElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-737170518, $changed, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:371)");
        } else {
            int i2 = $changed;
        }
        Object[] keys$iv = {Dp.m5842boximpl(defaultElevation2), Dp.m5842boximpl(pressedElevation2), Dp.m5842boximpl(disabledElevation2), Dp.m5842boximpl(hoveredElevation2), Dp.m5842boximpl(focusedElevation2)};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv = $composer;
        Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            value$iv$iv = new DefaultButtonElevation(defaultElevation2, pressedElevation2, disabledElevation2, hoveredElevation2, focusedElevation2, (DefaultConstructorMarker) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Object obj2 = value$iv$iv;
            Composer composer2 = $this$cache$iv$iv;
        }
        $composer.endReplaceableGroup();
        DefaultButtonElevation defaultButtonElevation = (DefaultButtonElevation) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultButtonElevation;
    }

    /* renamed from: buttonColors-ro_MJ88  reason: not valid java name */
    public final ButtonColors m1206buttonColorsro_MJ88(long backgroundColor, long contentColor, long disabledBackgroundColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledBackgroundColor2;
        long disabledContentColor2;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(1870371134);
        ComposerKt.sourceInformation(composer, "C(buttonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)406@16865L6,407@16911L32,408@17000L6,409@17078L6,410@17147L6,411@17203L8:Button.kt#jmzs0o");
        long backgroundColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1241getPrimary0d7_KjU() : backgroundColor;
        if ((i & 2) != 0) {
            contentColor2 = ColorsKt.m1259contentColorForek8zF_U(backgroundColor2, composer, i2 & 14);
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            disabledBackgroundColor2 = ColorKt.m3298compositeOverOWjLjI(Color.m3252copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1240getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).m1245getSurface0d7_KjU());
        } else {
            disabledBackgroundColor2 = disabledBackgroundColor;
        }
        if ((i & 8) != 0) {
            disabledContentColor2 = Color.m3252copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1240getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1870371134, i2, -1, "androidx.compose.material.ButtonDefaults.buttonColors (Button.kt:405)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(backgroundColor2, contentColor2, disabledBackgroundColor2, disabledContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    /* renamed from: outlinedButtonColors-RGew2ao  reason: not valid java name */
    public final ButtonColors m1214outlinedButtonColorsRGew2ao(long backgroundColor, long contentColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContentColor2;
        Composer composer = $composer;
        composer.startReplaceableGroup(-2124406093);
        ComposerKt.sourceInformation(composer, "C(outlinedButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color)429@17950L6,430@18010L6,431@18078L6,432@18134L8:Button.kt#jmzs0o");
        long backgroundColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1245getSurface0d7_KjU() : backgroundColor;
        if ((i & 2) != 0) {
            contentColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1241getPrimary0d7_KjU();
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            disabledContentColor2 = Color.m3252copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1240getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2124406093, $changed, -1, "androidx.compose.material.ButtonDefaults.outlinedButtonColors (Button.kt:428)");
        } else {
            int i2 = $changed;
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(backgroundColor2, contentColor2, backgroundColor2, disabledContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    /* renamed from: textButtonColors-RGew2ao  reason: not valid java name */
    public final ButtonColors m1215textButtonColorsRGew2ao(long backgroundColor, long contentColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContentColor2;
        Composer composer = $composer;
        composer.startReplaceableGroup(182742216);
        ComposerKt.sourceInformation(composer, "C(textButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color)451@18901L6,452@18969L6,453@19025L8:Button.kt#jmzs0o");
        long backgroundColor2 = (i & 1) != 0 ? Color.Companion.m3288getTransparent0d7_KjU() : backgroundColor;
        if ((i & 2) != 0) {
            contentColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1241getPrimary0d7_KjU();
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            disabledContentColor2 = Color.m3252copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1240getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(182742216, $changed, -1, "androidx.compose.material.ButtonDefaults.textButtonColors (Button.kt:449)");
        } else {
            int i2 = $changed;
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(backgroundColor2, contentColor2, backgroundColor2, disabledContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    /* renamed from: getOutlinedBorderSize-D9Ej5fM  reason: not valid java name */
    public final float m1213getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    public final BorderStroke getOutlinedBorder(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-2091313033);
        ComposerKt.sourceInformation($composer, "C477@19729L6:Button.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2091313033, $changed, -1, "androidx.compose.material.ButtonDefaults.<get-outlinedBorder> (Button.kt:476)");
        }
        BorderStroke r0 = BorderStrokeKt.m194BorderStrokecXLIe8U(OutlinedBorderSize, Color.m3252copywmQWz5c$default(MaterialTheme.INSTANCE.getColors($composer, 6).m1240getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }
}

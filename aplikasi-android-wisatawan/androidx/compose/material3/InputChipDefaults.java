package androidx.compose.material3;

import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010 \u001a\u00020\u00132\b\b\u0002\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020\u00132\b\b\u0002\u0010&\u001a\u00020\u00132\b\b\u0002\u0010'\u001a\u00020\u00132\b\b\u0002\u0010(\u001a\u00020\u00132\b\b\u0002\u0010)\u001a\u00020\u0013H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+JQ\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u00042\b\b\u0002\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u00042\b\b\u0002\u00103\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, d2 = {"Landroidx/compose/material3/InputChipDefaults;", "", "()V", "AvatarSize", "Landroidx/compose/ui/unit/Dp;", "getAvatarSize-D9Ej5fM", "()F", "F", "Height", "getHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "inputChipBorder", "Landroidx/compose/material3/SelectableChipBorder;", "borderColor", "Landroidx/compose/ui/graphics/Color;", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "inputChipBorder-gHcDVlo", "(JJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipBorder;", "inputChipColors", "Landroidx/compose/material3/SelectableChipColors;", "containerColor", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "inputChipColors-kwJvTHA", "(JJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "inputChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "inputChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class InputChipDefaults {
    public static final int $stable = 0;
    private static final float AvatarSize = InputChipTokens.INSTANCE.m2538getAvatarSizeD9Ej5fM();
    private static final float Height = InputChipTokens.INSTANCE.m2540getContainerHeightD9Ej5fM();
    public static final InputChipDefaults INSTANCE = new InputChipDefaults();
    private static final float IconSize = InputChipTokens.INSTANCE.m2542getLeadingIconSizeD9Ej5fM();

    private InputChipDefaults() {
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m1811getHeightD9Ej5fM() {
        return Height;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1812getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* renamed from: getAvatarSize-D9Ej5fM  reason: not valid java name */
    public final float m1810getAvatarSizeD9Ej5fM() {
        return AvatarSize;
    }

    /* renamed from: inputChipColors-kwJvTHA  reason: not valid java name */
    public final SelectableChipColors m1814inputChipColorskwJvTHA(long containerColor, long labelColor, long leadingIconColor, long trailingIconColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconColor, long disabledTrailingIconColor, long selectedContainerColor, long disabledSelectedContainerColor, long selectedLabelColor, long selectedLeadingIconColor, long selectedTrailingIconColor, Composer $composer, int $changed, int $changed1, int i) {
        long labelColor2;
        long leadingIconColor2;
        long trailingIconColor2;
        long disabledContainerColor2;
        long disabledLabelColor2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long selectedContainerColor2;
        long disabledSelectedContainerColor2;
        long selectedLabelColor2;
        long selectedLeadingIconColor2;
        long selectedTrailingIconColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(1312840646);
        ComposerKt.sourceInformation(composer, "C(inputChipColors)P(0:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color)1040@52762L9,1041@52850L9,1042@52940L9,1044@53085L9,1046@53247L9,1048@53413L9,1050@53574L9,1052@53692L9,1054@53858L9,1055@53952L9,1056@54048L9:Chip.kt#uh7d8r");
        long containerColor2 = (i2 & 1) != 0 ? Color.Companion.m3288getTransparent0d7_KjU() : containerColor;
        if ((i2 & 2) != 0) {
            labelColor2 = ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getUnselectedLabelTextColor(), composer, 6);
        } else {
            labelColor2 = labelColor;
        }
        if ((i2 & 4) != 0) {
            leadingIconColor2 = ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getUnselectedLeadingIconColor(), composer, 6);
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i2 & 8) != 0) {
            trailingIconColor2 = ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getUnselectedTrailingIconColor(), composer, 6);
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i2 & 16) != 0) {
            disabledContainerColor2 = Color.Companion.m3288getTransparent0d7_KjU();
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i2 & 32) != 0) {
            disabledLabelColor2 = Color.m3252copywmQWz5c$default(ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((i2 & 64) != 0) {
            disabledLeadingIconColor2 = Color.m3252copywmQWz5c$default(ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i2 & 128) != 0) {
            disabledTrailingIconColor2 = Color.m3252copywmQWz5c$default(ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getDisabledTrailingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((i2 & 256) != 0) {
            selectedContainerColor2 = ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getSelectedContainerColor(), composer, 6);
        } else {
            selectedContainerColor2 = selectedContainerColor;
        }
        if ((i2 & 512) != 0) {
            disabledSelectedContainerColor2 = Color.m3252copywmQWz5c$default(ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getDisabledSelectedContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledSelectedContainerColor2 = disabledSelectedContainerColor;
        }
        if ((i2 & 1024) != 0) {
            selectedLabelColor2 = ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getSelectedLabelTextColor(), composer, 6);
        } else {
            selectedLabelColor2 = selectedLabelColor;
        }
        if ((i2 & 2048) != 0) {
            selectedLeadingIconColor2 = ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getSelectedLeadingIconColor(), composer, 6);
        } else {
            selectedLeadingIconColor2 = selectedLeadingIconColor;
        }
        if ((i2 & 4096) != 0) {
            selectedTrailingIconColor2 = ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getSelectedTrailingIconColor(), composer, 6);
        } else {
            selectedTrailingIconColor2 = selectedTrailingIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1312840646, $changed, $changed1, "androidx.compose.material3.InputChipDefaults.inputChipColors (Chip.kt:1038)");
        } else {
            int i3 = $changed;
            int i4 = $changed1;
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(containerColor2, labelColor2, leadingIconColor2, trailingIconColor2, disabledContainerColor2, disabledLabelColor2, disabledLeadingIconColor2, disabledTrailingIconColor2, selectedContainerColor2, disabledSelectedContainerColor2, selectedLabelColor2, selectedLeadingIconColor2, selectedTrailingIconColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return selectableChipColors;
    }

    /* renamed from: inputChipElevation-aqJV_2Y  reason: not valid java name */
    public final SelectableChipElevation m1815inputChipElevationaqJV_2Y(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float focusedElevation2;
        float hoveredElevation2;
        float draggedElevation2;
        float disabledElevation2;
        Composer composer = $composer;
        composer.startReplaceableGroup(1745270109);
        ComposerKt.sourceInformation(composer, "C(inputChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        float elevation2 = (i & 1) != 0 ? InputChipTokens.INSTANCE.m2539getContainerElevationD9Ej5fM() : elevation;
        if ((i & 2) != 0) {
            pressedElevation2 = elevation2;
        } else {
            pressedElevation2 = pressedElevation;
        }
        if ((i & 4) != 0) {
            focusedElevation2 = elevation2;
        } else {
            focusedElevation2 = focusedElevation;
        }
        if ((i & 8) != 0) {
            hoveredElevation2 = elevation2;
        } else {
            hoveredElevation2 = hoveredElevation;
        }
        if ((i & 16) != 0) {
            draggedElevation2 = InputChipTokens.INSTANCE.m2541getDraggedContainerElevationD9Ej5fM();
        } else {
            draggedElevation2 = draggedElevation;
        }
        if ((i & 32) != 0) {
            disabledElevation2 = elevation2;
        } else {
            disabledElevation2 = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1745270109, $changed, -1, "androidx.compose.material3.InputChipDefaults.inputChipElevation (Chip.kt:1086)");
        } else {
            int i2 = $changed;
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(elevation2, pressedElevation2, focusedElevation2, hoveredElevation2, draggedElevation2, disabledElevation2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return selectableChipElevation;
    }

    /* renamed from: inputChipBorder-gHcDVlo  reason: not valid java name */
    public final SelectableChipBorder m1813inputChipBordergHcDVlo(long borderColor, long selectedBorderColor, long disabledBorderColor, long disabledSelectedBorderColor, float borderWidth, float selectedBorderWidth, Composer $composer, int $changed, int i) {
        long selectedBorderColor2;
        long disabledBorderColor2;
        long disabledSelectedBorderColor2;
        float borderWidth2;
        float selectedBorderWidth2;
        Composer composer = $composer;
        composer.startReplaceableGroup(-324924235);
        ComposerKt.sourceInformation(composer, "C(inputChipBorder)P(0:c#ui.graphics.Color,4:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,1:c#ui.unit.Dp,5:c#ui.unit.Dp)1116@56932L9,1118@57083L9:Chip.kt#uh7d8r");
        long borderColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getUnselectedOutlineColor(), composer, 6) : borderColor;
        if ((i & 2) != 0) {
            selectedBorderColor2 = Color.Companion.m3288getTransparent0d7_KjU();
        } else {
            selectedBorderColor2 = selectedBorderColor;
        }
        if ((i & 4) != 0) {
            disabledBorderColor2 = Color.m3252copywmQWz5c$default(ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getDisabledUnselectedOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        if ((i & 8) != 0) {
            disabledSelectedBorderColor2 = Color.Companion.m3288getTransparent0d7_KjU();
        } else {
            disabledSelectedBorderColor2 = disabledSelectedBorderColor;
        }
        if ((i & 16) != 0) {
            borderWidth2 = InputChipTokens.INSTANCE.m2545getUnselectedOutlineWidthD9Ej5fM();
        } else {
            borderWidth2 = borderWidth;
        }
        if ((i & 32) != 0) {
            selectedBorderWidth2 = InputChipTokens.INSTANCE.m2543getSelectedOutlineWidthD9Ej5fM();
        } else {
            selectedBorderWidth2 = selectedBorderWidth;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-324924235, $changed, -1, "androidx.compose.material3.InputChipDefaults.inputChipBorder (Chip.kt:1115)");
        } else {
            int i2 = $changed;
        }
        SelectableChipBorder selectableChipBorder = new SelectableChipBorder(borderColor2, selectedBorderColor2, disabledBorderColor2, disabledSelectedBorderColor2, borderWidth2, selectedBorderWidth2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return selectableChipBorder;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1052444143);
        ComposerKt.sourceInformation($composer, "C1133@57835L9:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1052444143, $changed, -1, "androidx.compose.material3.InputChipDefaults.<get-shape> (Chip.kt:1133)");
        }
        Shape shape = ShapesKt.toShape(InputChipTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }
}

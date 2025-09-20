package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.tokens.SearchBarTokens;
import androidx.compose.material3.tokens.SearchViewTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u00192\b\b\u0002\u0010 \u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u00192\b\b\u0002\u0010(\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020\u00192\b\b\u0002\u0010*\u001a\u00020\u00192\b\b\u0002\u0010+\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-J¡\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010.\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020\u00192\b\b\u0002\u0010 \u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u00192\b\b\u0002\u0010(\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020\u00192\b\b\u0002\u00100\u001a\u00020\u00192\b\b\u0002\u00101\u001a\u00020\u00192\b\b\u0002\u0010+\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00064"}, d2 = {"Landroidx/compose/material3/SearchBarDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "InputFieldHeight", "getInputFieldHeight-D9Ej5fM", "dockedShape", "Landroidx/compose/ui/graphics/Shape;", "getDockedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "fullScreenShape", "getFullScreenShape", "inputFieldShape", "getInputFieldShape", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "colors", "Landroidx/compose/material3/SearchBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "dividerColor", "inputFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-Klgx-Pg", "(JJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "textColor", "disabledTextColor", "cursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "placeholderColor", "disabledPlaceholderColor", "inputFieldColors--u-KgnY", "(JJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "unfocusedTextColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "inputFieldColors-ITpI4ow", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.kt */
public final class SearchBarDefaults {
    public static final int $stable = 0;
    private static final float Elevation = SearchBarTokens.INSTANCE.m2704getContainerElevationD9Ej5fM();
    public static final SearchBarDefaults INSTANCE = new SearchBarDefaults();
    private static final float InputFieldHeight = SearchBarTokens.INSTANCE.m2705getContainerHeightD9Ej5fM();

    private SearchBarDefaults() {
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m1944getElevationD9Ej5fM() {
        return Elevation;
    }

    /* renamed from: getInputFieldHeight-D9Ej5fM  reason: not valid java name */
    public final float m1945getInputFieldHeightD9Ej5fM() {
        return InputFieldHeight;
    }

    public final Shape getInputFieldShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1770571533);
        ComposerKt.sourceInformation($composer, "C504@23164L9:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1770571533, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-inputFieldShape> (SearchBar.kt:504)");
        }
        Shape shape = ShapesKt.toShape(SearchBarTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getFullScreenShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-2009956471);
        ComposerKt.sourceInformation($composer, "C508@23340L9:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2009956471, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenShape> (SearchBar.kt:508)");
        }
        Shape shape = ShapesKt.toShape(SearchViewTokens.INSTANCE.getFullScreenContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getDockedShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1447354121);
        ComposerKt.sourceInformation($composer, "C511@23486L9:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1447354121, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-dockedShape> (SearchBar.kt:511)");
        }
        Shape shape = ShapesKt.toShape(SearchViewTokens.INSTANCE.getDockedContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final WindowInsets getWindowInsets(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1795925906);
        ComposerKt.sourceInformation($composer, "C514@23617L10:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1795925906, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-windowInsets> (SearchBar.kt:514)");
        }
        WindowInsets statusBars = WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return statusBars;
    }

    /* renamed from: colors-Klgx-Pg  reason: not valid java name */
    public final SearchBarColors m1943colorsKlgxPg(long containerColor, long dividerColor, TextFieldColors inputFieldColors, Composer $composer, int $changed, int i) {
        long dividerColor2;
        TextFieldColors inputFieldColors2;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(701925149);
        ComposerKt.sourceInformation(composer, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)526@24106L9,527@24177L9,528@24232L18:SearchBar.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6) : containerColor;
        if ((i & 2) != 0) {
            dividerColor2 = ColorSchemeKt.toColor(SearchViewTokens.INSTANCE.getDividerColor(), composer, 6);
        } else {
            dividerColor2 = dividerColor;
        }
        if ((i & 4) != 0) {
            inputFieldColors2 = m1947inputFieldColorsITpI4ow(0, 0, 0, 0, (TextSelectionColors) null, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer, 0, (i2 << 3) & 57344, 16383);
        } else {
            inputFieldColors2 = inputFieldColors;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(701925149, $changed, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.kt:525)");
        } else {
            int i3 = $changed;
        }
        SearchBarColors searchBarColors = new SearchBarColors(containerColor2, dividerColor2, inputFieldColors2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return searchBarColors;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v49, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: inputFieldColors-ITpI4ow  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material3.TextFieldColors m1947inputFieldColorsITpI4ow(long r122, long r124, long r126, long r128, androidx.compose.foundation.text.selection.TextSelectionColors r130, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, androidx.compose.runtime.Composer r149, int r150, int r151, int r152) {
        /*
            r121 = this;
            r5 = r149
            r6 = r150
            r3 = r151
            r0 = r152
            r1 = -2048506052(0xffffffff85e6473c, float:-2.1655263E-35)
            r5.startReplaceableGroup(r1)
            java.lang.String r2 = "C(inputFieldColors)P(7:c#ui.graphics.Color,12:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,9,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,2:c#ui.graphics.Color)561@26199L9,562@26277L9,563@26364L9,565@26507L9,566@26590L7,567@26673L9,568@26760L9,570@26873L9,571@27023L9,572@27112L9,574@27227L9,575@27379L9,576@27469L9,577@27563L9,580@27695L847:SearchBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            r2 = r0 & 1
            r4 = 6
            if (r2 == 0) goto L_0x0025
            androidx.compose.material3.tokens.SearchBarTokens r2 = androidx.compose.material3.tokens.SearchBarTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getInputTextColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r5, r4)
            r94 = r7
            goto L_0x0027
        L_0x0025:
            r94 = r122
        L_0x0027:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0038
            androidx.compose.material3.tokens.SearchBarTokens r2 = androidx.compose.material3.tokens.SearchBarTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getInputTextColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r5, r4)
            r96 = r7
            goto L_0x003a
        L_0x0038:
            r96 = r124
        L_0x003a:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0059
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledInputColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r5, r4)
            r13 = 14
            r14 = 0
            r9 = 1052938076(0x3ec28f5c, float:0.38)
            r10 = 0
            r11 = 0
            r12 = 0
            long r7 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r7, r9, r10, r11, r12, r13, r14)
            r98 = r7
            goto L_0x005b
        L_0x0059:
            r98 = r126
        L_0x005b:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x006c
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getCaretColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r5, r4)
            r100 = r7
            goto L_0x006e
        L_0x006c:
            r100 = r128
        L_0x006e:
            r2 = r0 & 16
            if (r2 == 0) goto L_0x008f
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r7 = 0
            r8 = 0
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r9, r10)
            java.lang.Object r9 = r5.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r149)
            r2 = r9
            androidx.compose.foundation.text.selection.TextSelectionColors r2 = (androidx.compose.foundation.text.selection.TextSelectionColors) r2
            r102 = r2
            goto L_0x0091
        L_0x008f:
            r102 = r130
        L_0x0091:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x00a2
            androidx.compose.material3.tokens.SearchBarTokens r2 = androidx.compose.material3.tokens.SearchBarTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getLeadingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r5, r4)
            r103 = r7
            goto L_0x00a4
        L_0x00a2:
            r103 = r131
        L_0x00a4:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x00b5
            androidx.compose.material3.tokens.SearchBarTokens r2 = androidx.compose.material3.tokens.SearchBarTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getLeadingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r5, r4)
            r105 = r7
            goto L_0x00b7
        L_0x00b5:
            r105 = r133
        L_0x00b7:
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00e4
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledLeadingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r5, r4)
            r2 = 14
            r9 = 0
            r10 = 1052938076(0x3ec28f5c, float:0.38)
            r11 = 0
            r12 = 0
            r13 = 0
            r122 = r7
            r124 = r10
            r125 = r11
            r126 = r12
            r127 = r13
            r128 = r2
            r129 = r9
            long r7 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r122, r124, r125, r126, r127, r128, r129)
            r107 = r7
            goto L_0x00e6
        L_0x00e4:
            r107 = r135
        L_0x00e6:
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x00f7
            androidx.compose.material3.tokens.SearchBarTokens r2 = androidx.compose.material3.tokens.SearchBarTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTrailingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r5, r4)
            r109 = r7
            goto L_0x00f9
        L_0x00f7:
            r109 = r137
        L_0x00f9:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x010a
            androidx.compose.material3.tokens.SearchBarTokens r2 = androidx.compose.material3.tokens.SearchBarTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTrailingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r5, r4)
            r111 = r7
            goto L_0x010c
        L_0x010a:
            r111 = r139
        L_0x010c:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0139
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledTrailingIconColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r5, r4)
            r2 = 14
            r9 = 0
            r10 = 1052938076(0x3ec28f5c, float:0.38)
            r11 = 0
            r12 = 0
            r13 = 0
            r122 = r7
            r124 = r10
            r125 = r11
            r126 = r12
            r127 = r13
            r128 = r2
            r129 = r9
            long r7 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r122, r124, r125, r126, r127, r128, r129)
            r113 = r7
            goto L_0x013b
        L_0x0139:
            r113 = r141
        L_0x013b:
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x014c
            androidx.compose.material3.tokens.SearchBarTokens r2 = androidx.compose.material3.tokens.SearchBarTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getSupportingTextColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r5, r4)
            r115 = r7
            goto L_0x014e
        L_0x014c:
            r115 = r143
        L_0x014e:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x015f
            androidx.compose.material3.tokens.SearchBarTokens r2 = androidx.compose.material3.tokens.SearchBarTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getSupportingTextColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r5, r4)
            r117 = r7
            goto L_0x0161
        L_0x015f:
            r117 = r145
        L_0x0161:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x018e
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getDisabledInputColor()
            long r7 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r5, r4)
            r0 = 14
            r2 = 0
            r4 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r11 = 0
            r122 = r7
            r124 = r4
            r125 = r9
            r126 = r10
            r127 = r11
            r128 = r0
            r129 = r2
            long r7 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r122, r124, r125, r126, r127, r128, r129)
            r119 = r7
            goto L_0x0190
        L_0x018e:
            r119 = r147
        L_0x0190:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x019b
            java.lang.String r0 = "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:560)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r6, r3, r0)
        L_0x019b:
            androidx.compose.material3.TextFieldDefaults r0 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            r1 = r6 & 14
            r2 = r6 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r6 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r6 << 15
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r4
            r87 = r1 | r2
            int r1 = r6 >> 12
            r1 = r1 & 14
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r6
            r1 = r1 | r2
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r6
            r1 = r1 | r2
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r7 = r6 & r2
            r1 = r1 | r7
            int r7 = r6 << 3
            r8 = 1879048192(0x70000000, float:1.58456325E29)
            r7 = r7 & r8
            r88 = r1 | r7
            int r1 = r6 >> 27
            r1 = r1 & 14
            int r7 = r3 << 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            r1 = r1 | r7
            int r7 = r3 << 18
            r2 = r2 & r7
            r1 = r1 | r2
            int r2 = r3 << 18
            r2 = r2 & r4
            r1 = r1 | r2
            int r2 = r3 << 18
            r2 = r2 & r8
            r89 = r1 | r2
            r7 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r19 = 0
            r22 = 0
            r24 = 0
            r26 = 0
            r28 = 0
            r36 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r52 = 0
            r60 = 0
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 0
            r70 = 0
            r72 = 0
            r74 = 0
            r76 = 0
            r78 = 0
            r80 = 0
            r82 = 0
            r84 = 0
            r90 = 0
            r91 = 3072(0xc00, float:4.305E-42)
            r92 = 1204058872(0x47c47af8, float:100597.94)
            r93 = 4095(0xfff, float:5.738E-42)
            r1 = r94
            r3 = r96
            r5 = r98
            r17 = r100
            r21 = r102
            r30 = r103
            r32 = r105
            r34 = r107
            r38 = r109
            r40 = r111
            r42 = r113
            r54 = r115
            r56 = r117
            r58 = r119
            r86 = r149
            androidx.compose.material3.TextFieldColors r0 = r0.m2117colors0hiis_0(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r87, r88, r89, r90, r91, r92, r93)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0255
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0255:
            r149.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarDefaults.m1947inputFieldColorsITpI4ow(long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: inputFieldColors--u-KgnY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ androidx.compose.material3.TextFieldColors m1946inputFieldColorsuKgnY(long r56, long r58, long r60, androidx.compose.foundation.text.selection.TextSelectionColors r62, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, androidx.compose.runtime.Composer r79, int r80, int r81, int r82) {
        /*
            r55 = this;
            r14 = r79
            r15 = r80
            r12 = r81
            r0 = r82
            r1 = 1842555178(0x6dd3292a, float:8.1688877E27)
            r14.startReplaceableGroup(r1)
            java.lang.String r2 = "C(inputFieldColors)P(9:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,8,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,4:c#ui.graphics.Color,7:c#ui.graphics.Color,2:c#ui.graphics.Color)600@28732L9,601@28819L9,603@28962L9,604@29045L7,605@29128L9,606@29215L9,608@29328L9,609@29478L9,610@29567L9,612@29682L9,613@29827L9,614@29921L9,616@30010L765:SearchBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            r2 = r0 & 1
            r3 = 6
            if (r2 == 0) goto L_0x0025
            androidx.compose.material3.tokens.SearchBarTokens r2 = androidx.compose.material3.tokens.SearchBarTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r32 = r4
            goto L_0x0027
        L_0x0025:
            r32 = r56
        L_0x0027:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0046
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledInputColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r10 = 14
            r11 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r4, r6, r7, r8, r9, r10, r11)
            r34 = r4
            goto L_0x0048
        L_0x0046:
            r34 = r58
        L_0x0048:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0059
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r36 = r4
            goto L_0x005b
        L_0x0059:
            r36 = r60
        L_0x005b:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x007c
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r5 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r6, r7)
            java.lang.Object r6 = r14.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r79)
            r2 = r6
            androidx.compose.foundation.text.selection.TextSelectionColors r2 = (androidx.compose.foundation.text.selection.TextSelectionColors) r2
            r38 = r2
            goto L_0x007e
        L_0x007c:
            r38 = r62
        L_0x007e:
            r2 = r0 & 16
            if (r2 == 0) goto L_0x008f
            androidx.compose.material3.tokens.SearchBarTokens r2 = androidx.compose.material3.tokens.SearchBarTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r39 = r4
            goto L_0x0091
        L_0x008f:
            r39 = r63
        L_0x0091:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x00a2
            androidx.compose.material3.tokens.SearchBarTokens r2 = androidx.compose.material3.tokens.SearchBarTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r41 = r4
            goto L_0x00a4
        L_0x00a2:
            r41 = r65
        L_0x00a4:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x00d1
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r56 = r4
            r58 = r7
            r59 = r8
            r60 = r9
            r61 = r10
            r62 = r2
            r63 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r56, r58, r59, r60, r61, r62, r63)
            r43 = r4
            goto L_0x00d3
        L_0x00d1:
            r43 = r67
        L_0x00d3:
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00e4
            androidx.compose.material3.tokens.SearchBarTokens r2 = androidx.compose.material3.tokens.SearchBarTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r45 = r4
            goto L_0x00e6
        L_0x00e4:
            r45 = r69
        L_0x00e6:
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x00f7
            androidx.compose.material3.tokens.SearchBarTokens r2 = androidx.compose.material3.tokens.SearchBarTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r47 = r4
            goto L_0x00f9
        L_0x00f7:
            r47 = r71
        L_0x00f9:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0126
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r56 = r4
            r58 = r7
            r59 = r8
            r60 = r9
            r61 = r10
            r62 = r2
            r63 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r56, r58, r59, r60, r61, r62, r63)
            r49 = r4
            goto L_0x0128
        L_0x0126:
            r49 = r73
        L_0x0128:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0139
            androidx.compose.material3.tokens.SearchBarTokens r2 = androidx.compose.material3.tokens.SearchBarTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r14, r3)
            r51 = r4
            goto L_0x013b
        L_0x0139:
            r51 = r75
        L_0x013b:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0168
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getDisabledInputColor()
            long r2 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r14, r3)
            r0 = 14
            r4 = 0
            r5 = 1052938076(0x3ec28f5c, float:0.38)
            r6 = 0
            r7 = 0
            r8 = 0
            r56 = r2
            r58 = r5
            r59 = r6
            r60 = r7
            r61 = r8
            r62 = r0
            r63 = r4
            long r2 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r56, r58, r59, r60, r61, r62, r63)
            r53 = r2
            goto L_0x016a
        L_0x0168:
            r53 = r77
        L_0x016a:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0175
            java.lang.String r0 = "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:599)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r15, r12, r0)
        L_0x0175:
            r0 = r15 & 14
            int r1 = r15 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r15 << 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r15 << 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r15 << 3
            r2 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r15 << 3
            r3 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r15 << 3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r15 << 3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r15 << 3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r15 << 3
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r3
            r29 = r0 | r1
            int r0 = r15 >> 27
            r0 = r0 & 14
            int r1 = r12 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r12 << 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r12 << 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r12 << 6
            r1 = r1 & r2
            r30 = r0 | r1
            r31 = 0
            r0 = r55
            r1 = r32
            r3 = r32
            r5 = r34
            r7 = r36
            r9 = r38
            r10 = r39
            r12 = r41
            r14 = r43
            r16 = r45
            r18 = r47
            r20 = r49
            r22 = r51
            r24 = r51
            r26 = r53
            r28 = r79
            androidx.compose.material3.TextFieldColors r0 = r0.m1947inputFieldColorsITpI4ow(r1, r3, r5, r7, r9, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r29, r30, r31)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0200
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0200:
            r79.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarDefaults.m1946inputFieldColorsuKgnY(long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int):androidx.compose.material3.TextFieldColors");
    }
}

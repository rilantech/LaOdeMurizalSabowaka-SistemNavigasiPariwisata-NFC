package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011JQ\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J=\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0011JQ\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0017J=\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0011JQ\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u0015\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0007¢\u0006\u0002\u0010$J=\u0010%\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0011J\u001f\u0010'\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010(\u001a\u00020#H\u0007¢\u0006\u0002\u0010)JQ\u0010*\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010\u0017R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006,"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults;", "", "()V", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", "filledIconButtonColors", "Landroidx/compose/material3/IconButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "filledIconButtonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconButtonColors;", "filledIconToggleButtonColors", "Landroidx/compose/material3/IconToggleButtonColors;", "checkedContainerColor", "checkedContentColor", "filledIconToggleButtonColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconToggleButtonColors;", "filledTonalIconButtonColors", "filledTonalIconButtonColors-ro_MJ88", "filledTonalIconToggleButtonColors", "filledTonalIconToggleButtonColors-5tl4gsc", "iconButtonColors", "iconButtonColors-ro_MJ88", "iconToggleButtonColors", "iconToggleButtonColors-5tl4gsc", "outlinedIconButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconButtonColors", "outlinedIconButtonColors-ro_MJ88", "outlinedIconToggleButtonBorder", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconToggleButtonColors", "outlinedIconToggleButtonColors-5tl4gsc", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IconButton.kt */
public final class IconButtonDefaults {
    public static final int $stable = 0;
    public static final IconButtonDefaults INSTANCE = new IconButtonDefaults();

    private IconButtonDefaults() {
    }

    public final Shape getFilledShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1265841879);
        ComposerKt.sourceInformation($composer, "C537@26248L9:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1265841879, $changed, -1, "androidx.compose.material3.IconButtonDefaults.<get-filledShape> (IconButton.kt:537)");
        }
        Shape shape = ShapesKt.toShape(FilledIconButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getOutlinedShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1327125527);
        ComposerKt.sourceInformation($composer, "C542@26422L9:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1327125527, $changed, -1, "androidx.compose.material3.IconButtonDefaults.<get-outlinedShape> (IconButton.kt:541)");
        }
        Shape shape = ShapesKt.toShape(OutlinedIconButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    /* renamed from: iconButtonColors-ro_MJ88  reason: not valid java name */
    public final IconButtonColors m3512iconButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        Composer composer = $composer;
        composer.startReplaceableGroup(999008085);
        ComposerKt.sourceInformation(composer, "C(iconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)555@27040L7:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.Companion.m4998getTransparent0d7_KjU() : containerColor;
        if ((i & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer);
            contentColor2 = ((Color) consume).m4973unboximpl();
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            disabledContainerColor2 = Color.Companion.m4998getTransparent0d7_KjU();
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i & 8) != 0) {
            disabledContentColor2 = Color.m4962copywmQWz5c$default(contentColor2, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(999008085, $changed, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:553)");
        } else {
            int i2 = $changed;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return iconButtonColors;
    }

    /* renamed from: iconToggleButtonColors-5tl4gsc  reason: not valid java name */
    public final IconToggleButtonColors m3513iconToggleButtonColors5tl4gsc(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        long checkedContainerColor2;
        long checkedContentColor2;
        Composer composer = $composer;
        composer.startReplaceableGroup(-2020719549);
        ComposerKt.sourceInformation(composer, "C(iconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)581@28297L7,586@28610L9:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.Companion.m4998getTransparent0d7_KjU() : containerColor;
        if ((i & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer);
            contentColor2 = ((Color) consume).m4973unboximpl();
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            disabledContainerColor2 = Color.Companion.m4998getTransparent0d7_KjU();
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i & 8) != 0) {
            disabledContentColor2 = Color.m4962copywmQWz5c$default(contentColor2, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 16) != 0) {
            checkedContainerColor2 = Color.Companion.m4998getTransparent0d7_KjU();
        } else {
            checkedContainerColor2 = checkedContainerColor;
        }
        if ((i & 32) != 0) {
            checkedContentColor2 = ColorSchemeKt.toColor(IconButtonTokens.INSTANCE.getSelectedIconColor(), composer, 6);
        } else {
            checkedContentColor2 = checkedContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2020719549, $changed, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButton.kt:579)");
        } else {
            int i2 = $changed;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, checkedContainerColor2, checkedContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }

    /* renamed from: filledIconButtonColors-ro_MJ88  reason: not valid java name */
    public final IconButtonColors m3508filledIconButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(-669858473);
        ComposerKt.sourceInformation(composer, "C(filledIconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)607@29603L9,608@29644L31,609@29763L9,611@29924L9:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getContainerColor(), composer, 6) : containerColor;
        if ((i & 2) != 0) {
            contentColor2 = ColorSchemeKt.m3369contentColorForek8zF_U(containerColor2, composer, i2 & 14);
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            disabledContainerColor2 = Color.m4962copywmQWz5c$default(ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i & 8) != 0) {
            disabledContentColor2 = Color.m4962copywmQWz5c$default(ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getDisabledColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-669858473, i2, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButton.kt:606)");
        }
        IconButtonColors iconButtonColors = new IconButtonColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return iconButtonColors;
    }

    /* renamed from: filledIconToggleButtonColors-5tl4gsc  reason: not valid java name */
    public final IconToggleButtonColors m3509filledIconToggleButtonColors5tl4gsc(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        long checkedContainerColor2;
        long checkedContentColor2;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(1887173701);
        ComposerKt.sourceInformation(composer, "C(filledIconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)634@31068L9,637@31287L9,638@31384L9,640@31545L9,642@31707L9,643@31755L38:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getUnselectedContainerColor(), composer, 6) : containerColor;
        if ((i & 2) != 0) {
            contentColor2 = ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getToggleUnselectedColor(), composer, 6);
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            disabledContainerColor2 = Color.m4962copywmQWz5c$default(ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i & 8) != 0) {
            disabledContentColor2 = Color.m4962copywmQWz5c$default(ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getDisabledColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 16) != 0) {
            checkedContainerColor2 = ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getSelectedContainerColor(), composer, 6);
        } else {
            checkedContainerColor2 = checkedContainerColor;
        }
        if ((i & 32) != 0) {
            checkedContentColor2 = ColorSchemeKt.m3369contentColorForek8zF_U(checkedContainerColor2, composer, (i2 >> 12) & 14);
        } else {
            checkedContentColor2 = checkedContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1887173701, i2, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButton.kt:633)");
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, checkedContainerColor2, checkedContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }

    /* renamed from: filledTonalIconButtonColors-ro_MJ88  reason: not valid java name */
    public final IconButtonColors m3510filledTonalIconButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(-18532843);
        ComposerKt.sourceInformation(composer, "C(filledTonalIconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)665@32799L9,666@32840L31,667@32964L9,669@33135L9:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getContainerColor(), composer, 6) : containerColor;
        if ((i & 2) != 0) {
            contentColor2 = ColorSchemeKt.m3369contentColorForek8zF_U(containerColor2, composer, i2 & 14);
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            disabledContainerColor2 = Color.m4962copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i & 8) != 0) {
            disabledContentColor2 = Color.m4962copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getDisabledColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-18532843, i2, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButton.kt:664)");
        }
        IconButtonColors iconButtonColors = new IconButtonColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return iconButtonColors;
    }

    /* renamed from: filledTonalIconToggleButtonColors-5tl4gsc  reason: not valid java name */
    public final IconToggleButtonColors m3511filledTonalIconToggleButtonColors5tl4gsc(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        long checkedContainerColor2;
        long checkedContentColor2;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(-19426557);
        ComposerKt.sourceInformation(composer, "C(filledTonalIconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)692@34299L9,693@34340L31,694@34464L9,696@34635L9,699@34819L9,700@34915L9:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getUnselectedContainerColor(), composer, 6) : containerColor;
        if ((i & 2) != 0) {
            contentColor2 = ColorSchemeKt.m3369contentColorForek8zF_U(containerColor2, composer, i2 & 14);
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            disabledContainerColor2 = Color.m4962copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i & 8) != 0) {
            disabledContentColor2 = Color.m4962copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getDisabledColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 16) != 0) {
            checkedContainerColor2 = ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getSelectedContainerColor(), composer, 6);
        } else {
            checkedContainerColor2 = checkedContainerColor;
        }
        if ((i & 32) != 0) {
            checkedContentColor2 = ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getToggleSelectedColor(), composer, 6);
        } else {
            checkedContentColor2 = checkedContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-19426557, i2, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButton.kt:691)");
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, checkedContainerColor2, checkedContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }

    /* renamed from: outlinedIconButtonColors-ro_MJ88  reason: not valid java name */
    public final IconButtonColors m3514outlinedIconButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        Composer composer = $composer;
        composer.startReplaceableGroup(-1030517545);
        ComposerKt.sourceInformation(composer, "C(outlinedIconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)723@35948L7:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.Companion.m4998getTransparent0d7_KjU() : containerColor;
        if ((i & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer);
            contentColor2 = ((Color) consume).m4973unboximpl();
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            disabledContainerColor2 = Color.Companion.m4998getTransparent0d7_KjU();
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i & 8) != 0) {
            disabledContentColor2 = Color.m4962copywmQWz5c$default(contentColor2, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1030517545, $changed, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButton.kt:721)");
        } else {
            int i2 = $changed;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return iconButtonColors;
    }

    /* renamed from: outlinedIconToggleButtonColors-5tl4gsc  reason: not valid java name */
    public final IconToggleButtonColors m3515outlinedIconToggleButtonColors5tl4gsc(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        long checkedContainerColor2;
        long checkedContentColor2;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(2130592709);
        ComposerKt.sourceInformation(composer, "C(outlinedIconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)749@37225L7,754@37511L9,755@37559L38:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.Companion.m4998getTransparent0d7_KjU() : containerColor;
        if ((i & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer);
            contentColor2 = ((Color) consume).m4973unboximpl();
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            disabledContainerColor2 = Color.Companion.m4998getTransparent0d7_KjU();
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i & 8) != 0) {
            disabledContentColor2 = Color.m4962copywmQWz5c$default(contentColor2, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 16) != 0) {
            checkedContainerColor2 = ColorSchemeKt.toColor(OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor(), composer, 6);
        } else {
            checkedContainerColor2 = checkedContainerColor;
        }
        if ((i & 32) != 0) {
            checkedContentColor2 = ColorSchemeKt.m3369contentColorForek8zF_U(checkedContainerColor2, composer, (i2 >> 12) & 14);
        } else {
            checkedContentColor2 = checkedContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2130592709, i2, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButton.kt:747)");
        }
        long j = checkedContainerColor2;
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, checkedContainerColor2, checkedContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }

    public final BorderStroke outlinedIconToggleButtonBorder(boolean enabled, boolean checked, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1244729690);
        ComposerKt.sourceInformation($composer, "C(outlinedIconToggleButtonBorder)P(1)778@38429L33:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1244729690, $changed, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonBorder (IconButton.kt:774)");
        }
        if (checked) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceableGroup();
            return null;
        }
        BorderStroke outlinedIconButtonBorder = outlinedIconButtonBorder(enabled, $composer, ($changed & 14) | (($changed >> 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return outlinedIconButtonBorder;
    }

    public final BorderStroke outlinedIconButtonBorder(boolean enabled, Composer $composer, int $changed) {
        long color;
        Object value$iv$iv;
        $composer.startReplaceableGroup(-511461558);
        ComposerKt.sourceInformation($composer, "C(outlinedIconButtonBorder)794@38982L108:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511461558, $changed, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonBorder (IconButton.kt:787)");
        }
        if (enabled) {
            $composer.startReplaceableGroup(1252615214);
            ComposerKt.sourceInformation($composer, "789@38805L7");
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer);
            color = ((Color) consume).m4973unboximpl();
            $composer.endReplaceableGroup();
        } else {
            $composer.startReplaceableGroup(1252615269);
            ComposerKt.sourceInformation($composer, "791@38860L7");
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer);
            color = Color.m4962copywmQWz5c$default(((Color) consume2).m4973unboximpl(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            $composer.endReplaceableGroup();
        }
        Object key1$iv = Color.m4953boximpl(color);
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(key1$iv);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = BorderStrokeKt.m1904BorderStrokecXLIe8U(OutlinedIconButtonTokens.INSTANCE.m4316getUnselectedOutlineWidthD9Ej5fM(), color);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        BorderStroke borderStroke = (BorderStroke) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return borderStroke;
    }
}

package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 Jo\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)JQ\u0010*\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010 Jo\u0010,\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010)R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/material/ChipDefaults;", "", "()V", "ContentOpacity", "", "LeadingIconOpacity", "LeadingIconSize", "Landroidx/compose/ui/unit/Dp;", "getLeadingIconSize-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "OutlinedBorderOpacity", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "SelectedIconSize", "getSelectedIconSize-D9Ej5fM", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "chipColors", "Landroidx/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconContentColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconContentColor", "chipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ChipColors;", "filterChipColors", "Landroidx/compose/material/SelectableChipColors;", "leadingIconColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "filterChipColors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/SelectableChipColors;", "outlinedChipColors", "outlinedChipColors-5tl4gsc", "outlinedFilterChipColors", "outlinedFilterChipColors-J08w3-E", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class ChipDefaults {
    public static final int $stable = 0;
    public static final float ContentOpacity = 0.87f;
    public static final ChipDefaults INSTANCE = new ChipDefaults();
    public static final float LeadingIconOpacity = 0.54f;
    private static final float LeadingIconSize = Dp.m7554constructorimpl((float) 20);
    private static final float MinHeight = Dp.m7554constructorimpl((float) 32);
    public static final float OutlinedBorderOpacity = 0.12f;
    private static final float OutlinedBorderSize = Dp.m7554constructorimpl((float) 1);
    private static final float SelectedIconSize = Dp.m7554constructorimpl((float) 18);

    private ChipDefaults() {
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m2937getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: chipColors-5tl4gsc  reason: not valid java name */
    public final ChipColors m2934chipColors5tl4gsc(long backgroundColor, long contentColor, long leadingIconContentColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long leadingIconContentColor2;
        long disabledBackgroundColor2;
        long disabledContentColor2;
        long disabledLeadingIconContentColor2;
        Composer composer = $composer;
        composer.startReplaceableGroup(1838505436);
        ComposerKt.sourceInformation(composer, "C(chipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)385@16874L6,386@16968L6,387@17029L6,390@17231L6,391@17291L8,392@17366L6,394@17473L8,397@17621L8:Chip.kt#jmzs0o");
        long backgroundColor2 = (i & 1) != 0 ? ColorKt.m5008compositeOverOWjLjI(Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).m2955getSurface0d7_KjU()) : backgroundColor;
        if ((i & 2) != 0) {
            contentColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            leadingIconContentColor2 = Color.m4962copywmQWz5c$default(contentColor2, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            leadingIconContentColor2 = leadingIconContentColor;
        }
        if ((i & 8) != 0) {
            disabledBackgroundColor2 = ColorKt.m5008compositeOverOWjLjI(Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.12f * ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).m2955getSurface0d7_KjU());
        } else {
            disabledBackgroundColor2 = disabledBackgroundColor;
        }
        if ((i & 16) != 0) {
            disabledContentColor2 = Color.m4962copywmQWz5c$default(contentColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 32) != 0) {
            disabledLeadingIconContentColor2 = Color.m4962copywmQWz5c$default(leadingIconContentColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLeadingIconContentColor2 = disabledLeadingIconContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1838505436, $changed, -1, "androidx.compose.material.ChipDefaults.chipColors (Chip.kt:384)");
        } else {
            int i2 = $changed;
        }
        DefaultChipColors defaultChipColors = new DefaultChipColors(backgroundColor2, contentColor2, leadingIconContentColor2, disabledBackgroundColor2, disabledContentColor2, disabledLeadingIconContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultChipColors;
    }

    /* renamed from: outlinedChipColors-5tl4gsc  reason: not valid java name */
    public final ChipColors m2940outlinedChipColors5tl4gsc(long backgroundColor, long contentColor, long leadingIconContentColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long leadingIconContentColor2;
        long disabledBackgroundColor2;
        long disabledContentColor2;
        long disabledLeadingIconContentColor2;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(-1763922662);
        ComposerKt.sourceInformation(composer, "C(outlinedChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)421@18817L6,422@18877L6,426@19160L8,429@19308L8,430@19360L342:Chip.kt#jmzs0o");
        long backgroundColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2955getSurface0d7_KjU() : backgroundColor;
        if ((i & 2) != 0) {
            contentColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            leadingIconContentColor2 = Color.m4962copywmQWz5c$default(contentColor2, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            leadingIconContentColor2 = leadingIconContentColor;
        }
        if ((i & 8) != 0) {
            disabledBackgroundColor2 = backgroundColor2;
        } else {
            disabledBackgroundColor2 = disabledBackgroundColor;
        }
        if ((i & 16) != 0) {
            disabledContentColor2 = Color.m4962copywmQWz5c$default(contentColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 32) != 0) {
            disabledLeadingIconContentColor2 = Color.m4962copywmQWz5c$default(leadingIconContentColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLeadingIconContentColor2 = disabledLeadingIconContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1763922662, i2, -1, "androidx.compose.material.ChipDefaults.outlinedChipColors (Chip.kt:420)");
        }
        ChipColors r0 = m2934chipColors5tl4gsc(backgroundColor2, contentColor2, leadingIconContentColor2, disabledBackgroundColor2, disabledContentColor2, disabledLeadingIconContentColor2, $composer, (i2 & 14) | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }

    /* renamed from: filterChipColors-J08w3-E  reason: not valid java name */
    public final SelectableChipColors m2935filterChipColorsJ08w3E(long backgroundColor, long contentColor, long leadingIconColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconColor, long selectedBackgroundColor, long selectedContentColor, long selectedLeadingIconColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long leadingIconColor2;
        long disabledBackgroundColor2;
        long disabledContentColor2;
        long disabledLeadingIconColor2;
        long selectedBackgroundColor2;
        long selectedContentColor2;
        long selectedLeadingIconColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(830140629);
        ComposerKt.sourceInformation(composer, "C(filterChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color)455@20699L6,456@20793L6,457@20854L6,460@21041L6,461@21101L8,462@21176L6,464@21283L8,467@21418L8,469@21514L6,472@21673L6,475@21834L6:Chip.kt#jmzs0o");
        long backgroundColor2 = (i2 & 1) != 0 ? ColorKt.m5008compositeOverOWjLjI(Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).m2955getSurface0d7_KjU()) : backgroundColor;
        if ((i2 & 2) != 0) {
            contentColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            contentColor2 = contentColor;
        }
        if ((i2 & 4) != 0) {
            leadingIconColor2 = Color.m4962copywmQWz5c$default(contentColor2, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i2 & 8) != 0) {
            disabledBackgroundColor2 = ColorKt.m5008compositeOverOWjLjI(Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).m2955getSurface0d7_KjU());
        } else {
            disabledBackgroundColor2 = disabledBackgroundColor;
        }
        if ((i2 & 16) != 0) {
            disabledContentColor2 = Color.m4962copywmQWz5c$default(contentColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i2 & 32) != 0) {
            disabledLeadingIconColor2 = Color.m4962copywmQWz5c$default(leadingIconColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i2 & 64) != 0) {
            selectedBackgroundColor2 = ColorKt.m5008compositeOverOWjLjI(Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), backgroundColor2);
        } else {
            selectedBackgroundColor2 = selectedBackgroundColor;
        }
        if ((i2 & 128) != 0) {
            selectedContentColor2 = ColorKt.m5008compositeOverOWjLjI(Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, (Object) null), contentColor2);
        } else {
            selectedContentColor2 = selectedContentColor;
        }
        if ((i2 & 256) != 0) {
            selectedLeadingIconColor2 = ColorKt.m5008compositeOverOWjLjI(Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, (Object) null), leadingIconColor2);
        } else {
            selectedLeadingIconColor2 = selectedLeadingIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(830140629, $changed, -1, "androidx.compose.material.ChipDefaults.filterChipColors (Chip.kt:454)");
        } else {
            int i3 = $changed;
        }
        long j = leadingIconColor2;
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(backgroundColor2, contentColor2, leadingIconColor2, disabledBackgroundColor2, disabledContentColor2, disabledLeadingIconColor2, selectedBackgroundColor2, selectedContentColor2, selectedLeadingIconColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }

    /* renamed from: outlinedFilterChipColors-J08w3-E  reason: not valid java name */
    public final SelectableChipColors m2941outlinedFilterChipColorsJ08w3E(long backgroundColor, long contentColor, long leadingIconColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconColor, long selectedBackgroundColor, long selectedContentColor, long selectedLeadingIconColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long leadingIconColor2;
        long disabledBackgroundColor2;
        long disabledContentColor2;
        long disabledLeadingIconColor2;
        long selectedBackgroundColor2;
        long selectedContentColor2;
        long selectedLeadingIconColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(346878099);
        ComposerKt.sourceInformation(composer, "C(outlinedFilterChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color)506@23484L6,507@23544L6,511@23804L8,514@23939L8,516@24035L6,519@24195L6,522@24356L6:Chip.kt#jmzs0o");
        long backgroundColor2 = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2955getSurface0d7_KjU() : backgroundColor;
        if ((i2 & 2) != 0) {
            contentColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            contentColor2 = contentColor;
        }
        if ((i2 & 4) != 0) {
            leadingIconColor2 = Color.m4962copywmQWz5c$default(contentColor2, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i2 & 8) != 0) {
            disabledBackgroundColor2 = backgroundColor2;
        } else {
            disabledBackgroundColor2 = disabledBackgroundColor;
        }
        if ((i2 & 16) != 0) {
            disabledContentColor2 = Color.m4962copywmQWz5c$default(contentColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i2 & 32) != 0) {
            disabledLeadingIconColor2 = Color.m4962copywmQWz5c$default(leadingIconColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i2 & 64) != 0) {
            selectedBackgroundColor2 = ColorKt.m5008compositeOverOWjLjI(Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, (Object) null), backgroundColor2);
        } else {
            selectedBackgroundColor2 = selectedBackgroundColor;
        }
        if ((i2 & 128) != 0) {
            selectedContentColor2 = ColorKt.m5008compositeOverOWjLjI(Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, (Object) null), contentColor2);
        } else {
            selectedContentColor2 = selectedContentColor;
        }
        if ((i2 & 256) != 0) {
            selectedLeadingIconColor2 = ColorKt.m5008compositeOverOWjLjI(Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, (Object) null), leadingIconColor2);
        } else {
            selectedLeadingIconColor2 = selectedLeadingIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(346878099, $changed, -1, "androidx.compose.material.ChipDefaults.outlinedFilterChipColors (Chip.kt:505)");
        } else {
            int i3 = $changed;
        }
        long j = leadingIconColor2;
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(backgroundColor2, contentColor2, leadingIconColor2, disabledBackgroundColor2, disabledContentColor2, disabledLeadingIconColor2, selectedBackgroundColor2, selectedContentColor2, selectedLeadingIconColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }

    public final BorderStroke getOutlinedBorder(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1650225597);
        ComposerKt.sourceInformation($composer, "C543@25203L6:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1650225597, $changed, -1, "androidx.compose.material.ChipDefaults.<get-outlinedBorder> (Chip.kt:542)");
        }
        BorderStroke r0 = BorderStrokeKt.m1904BorderStrokecXLIe8U(OutlinedBorderSize, Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors($composer, 6).m2950getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }

    /* renamed from: getOutlinedBorderSize-D9Ej5fM  reason: not valid java name */
    public final float m2938getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    /* renamed from: getLeadingIconSize-D9Ej5fM  reason: not valid java name */
    public final float m2936getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    /* renamed from: getSelectedIconSize-D9Ej5fM  reason: not valid java name */
    public final float m2939getSelectedIconSizeD9Ej5fM() {
        return SelectedIconSize;
    }
}

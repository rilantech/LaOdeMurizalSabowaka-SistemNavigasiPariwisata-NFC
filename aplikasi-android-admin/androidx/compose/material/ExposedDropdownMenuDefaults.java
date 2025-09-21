package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0007¢\u0006\u0002\u0010\tJñ\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$Jñ\u0001\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\b\b\u0002\u0010)\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010$\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006+"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuDefaults;", "", "()V", "TrailingIcon", "", "expanded", "", "onIconClick", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "outlinedTextFieldColors", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "focusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-DlUQjxs", "(JJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-DlUQjxs", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();

    private ExposedDropdownMenuDefaults() {
    }

    public final void TrailingIcon(boolean expanded, Function0<Unit> onIconClick, Composer $composer, int $changed, int i) {
        Composer $composer2 = $composer.startRestartGroup(876077373);
        ComposerKt.sourceInformation($composer2, "C(TrailingIcon)299@11590L394:ExposedDropdownMenu.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(expanded) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(onIconClick) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                onIconClick = ExposedDropdownMenuDefaults$TrailingIcon$1.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(876077373, $dirty2, -1, "androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:291)");
            }
            IconButtonKt.IconButton(onIconClick, SemanticsModifierKt.clearAndSetSemantics(Modifier.Companion, ExposedDropdownMenuDefaults$TrailingIcon$2.INSTANCE), false, (MutableInteractionSource) null, ComposableLambdaKt.composableLambda($composer2, 726122713, true, new ExposedDropdownMenuDefaults$TrailingIcon$3(expanded)), $composer2, (($dirty2 >> 3) & 14) | 24576, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ExposedDropdownMenuDefaults$TrailingIcon$4(this, expanded, onIconClick, $changed, i));
        }
    }

    /* renamed from: textFieldColors-DlUQjxs  reason: not valid java name */
    public final TextFieldColors m3019textFieldColorsDlUQjxs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long focusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long disabledTextColor2;
        long backgroundColor2;
        long cursorColor2;
        long errorCursorColor2;
        long focusedIndicatorColor2;
        long unfocusedIndicatorColor2;
        long disabledIndicatorColor2;
        long errorIndicatorColor2;
        long leadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long trailingIconColor2;
        long focusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(1208167904);
        ComposerKt.sourceInformation(composer, "C(textFieldColors)P(18:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,19:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)358@14663L7,358@14694L7,359@14767L8,361@14837L6,362@14948L6,363@15012L6,365@15091L6,365@15132L4,367@15206L6,370@15406L8,371@15468L6,373@15542L6,374@15689L8,377@15818L6,379@15948L6,379@15989L4,380@16083L8,381@16148L6,383@16223L6,383@16264L4,384@16322L6,384@16357L6,385@16440L8,386@16498L6,387@16560L6,387@16595L6,388@16681L8:ExposedDropdownMenu.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer);
            long r9 = ((Color) consume).m4973unboximpl();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m4962copywmQWz5c$default(r9, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            textColor2 = textColor;
        }
        if ((i2 & 2) != 0) {
            disabledTextColor2 = Color.m4962copywmQWz5c$default(textColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i2 & 4) != 0) {
            backgroundColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i2 & 8) != 0) {
            cursorColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m2951getPrimary0d7_KjU();
        } else {
            cursorColor2 = cursorColor;
        }
        if ((i2 & 16) != 0) {
            errorCursorColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m2945getError0d7_KjU();
        } else {
            errorCursorColor2 = errorCursorColor;
        }
        if ((i2 & 32) != 0) {
            focusedIndicatorColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            focusedIndicatorColor2 = focusedIndicatorColor;
        }
        if ((i2 & 64) != 0) {
            unfocusedIndicatorColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor;
        }
        if ((i2 & 128) != 0) {
            disabledIndicatorColor2 = Color.m4962copywmQWz5c$default(unfocusedIndicatorColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        if ((i2 & 256) != 0) {
            errorIndicatorColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m2945getError0d7_KjU();
        } else {
            errorIndicatorColor2 = errorIndicatorColor;
        }
        if ((i2 & 512) != 0) {
            leadingIconColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i2 & 1024) != 0) {
            disabledLeadingIconColor2 = Color.m4962copywmQWz5c$default(leadingIconColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i2 & 2048) != 0) {
            errorLeadingIconColor2 = leadingIconColor2;
        } else {
            errorLeadingIconColor2 = errorLeadingIconColor;
        }
        if ((i2 & 4096) != 0) {
            trailingIconColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i2 & 8192) != 0) {
            focusedTrailingIconColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        }
        if ((i2 & 16384) != 0) {
            disabledTrailingIconColor2 = Color.m4962copywmQWz5c$default(trailingIconColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((32768 & i2) != 0) {
            errorTrailingIconColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m2945getError0d7_KjU();
        } else {
            errorTrailingIconColor2 = errorTrailingIconColor;
        }
        if ((65536 & i2) != 0) {
            focusedLabelColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((131072 & i2) != 0) {
            unfocusedLabelColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((262144 & i2) != 0) {
            disabledLabelColor2 = Color.m4962copywmQWz5c$default(unfocusedLabelColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((524288 & i2) != 0) {
            errorLabelColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m2945getError0d7_KjU();
        } else {
            errorLabelColor2 = errorLabelColor;
        }
        if ((1048576 & i2) != 0) {
            placeholderColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i2 & 2097152) != 0) {
            disabledPlaceholderColor2 = Color.m4962copywmQWz5c$default(placeholderColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1208167904, $changed, $changed1, "androidx.compose.material.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:357)");
        } else {
            int i3 = $changed;
            int i4 = $changed1;
        }
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedIndicatorColor2, unfocusedIndicatorColor2, errorIndicatorColor2, disabledIndicatorColor2, leadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, trailingIconColor2, focusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }

    /* renamed from: outlinedTextFieldColors-DlUQjxs  reason: not valid java name */
    public final TextFieldColors m3018outlinedTextFieldColorsDlUQjxs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long focusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long disabledTextColor2;
        long backgroundColor2;
        long cursorColor2;
        long errorCursorColor2;
        long focusedBorderColor2;
        long unfocusedBorderColor2;
        long disabledBorderColor2;
        long errorBorderColor2;
        long leadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long trailingIconColor2;
        long focusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(1162641182);
        ComposerKt.sourceInformation(composer, "C(outlinedTextFieldColors)P(18:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,19:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)461@20648L7,461@20679L7,462@20752L8,464@20858L6,465@20922L6,467@20998L6,467@21039L4,469@21110L6,469@21153L8,470@21248L8,471@21307L6,473@21381L6,474@21528L8,477@21657L6,479@21787L6,479@21828L4,480@21922L8,481@21987L6,483@22062L6,483@22103L4,484@22161L6,484@22196L6,485@22279L8,486@22337L6,487@22399L6,487@22434L6,488@22520L8:ExposedDropdownMenu.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer);
            long r9 = ((Color) consume).m4973unboximpl();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m4962copywmQWz5c$default(r9, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            textColor2 = textColor;
        }
        if ((i2 & 2) != 0) {
            disabledTextColor2 = Color.m4962copywmQWz5c$default(textColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i2 & 4) != 0) {
            backgroundColor2 = Color.Companion.m4998getTransparent0d7_KjU();
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i2 & 8) != 0) {
            cursorColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m2951getPrimary0d7_KjU();
        } else {
            cursorColor2 = cursorColor;
        }
        if ((i2 & 16) != 0) {
            errorCursorColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m2945getError0d7_KjU();
        } else {
            errorCursorColor2 = errorCursorColor;
        }
        if ((i2 & 32) != 0) {
            focusedBorderColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            focusedBorderColor2 = focusedBorderColor;
        }
        if ((i2 & 64) != 0) {
            unfocusedBorderColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            unfocusedBorderColor2 = unfocusedBorderColor;
        }
        if ((i2 & 128) != 0) {
            disabledBorderColor2 = Color.m4962copywmQWz5c$default(unfocusedBorderColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        if ((i2 & 256) != 0) {
            errorBorderColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m2945getError0d7_KjU();
        } else {
            errorBorderColor2 = errorBorderColor;
        }
        if ((i2 & 512) != 0) {
            leadingIconColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i2 & 1024) != 0) {
            disabledLeadingIconColor2 = Color.m4962copywmQWz5c$default(leadingIconColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i2 & 2048) != 0) {
            errorLeadingIconColor2 = leadingIconColor2;
        } else {
            errorLeadingIconColor2 = errorLeadingIconColor;
        }
        if ((i2 & 4096) != 0) {
            trailingIconColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i2 & 8192) != 0) {
            focusedTrailingIconColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        }
        if ((i2 & 16384) != 0) {
            disabledTrailingIconColor2 = Color.m4962copywmQWz5c$default(trailingIconColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((32768 & i2) != 0) {
            errorTrailingIconColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m2945getError0d7_KjU();
        } else {
            errorTrailingIconColor2 = errorTrailingIconColor;
        }
        if ((65536 & i2) != 0) {
            focusedLabelColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((131072 & i2) != 0) {
            unfocusedLabelColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((262144 & i2) != 0) {
            disabledLabelColor2 = Color.m4962copywmQWz5c$default(unfocusedLabelColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((524288 & i2) != 0) {
            errorLabelColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m2945getError0d7_KjU();
        } else {
            errorLabelColor2 = errorLabelColor;
        }
        if ((1048576 & i2) != 0) {
            placeholderColor2 = Color.m4962copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i2 & 2097152) != 0) {
            disabledPlaceholderColor2 = Color.m4962copywmQWz5c$default(placeholderColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1162641182, $changed, $changed1, "androidx.compose.material.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:460)");
        } else {
            int i3 = $changed;
            int i4 = $changed1;
        }
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedBorderColor2, unfocusedBorderColor2, errorBorderColor2, disabledBorderColor2, leadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, trailingIconColor2, focusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }
}

package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b3\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJ\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u0003\u0010\f\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u000f2\b\b\u0002\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:J\u0003\u0010\f\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010;\u001a\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020\u000f2\b\b\u0002\u0010=\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u000f2\b\b\u0002\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010?J\u0002\u0010@\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010A\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020\u000f2\b\b\u0002\u0010C\u001a\u00020\u000f2\b\b\u0002\u0010D\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u0010)J\u0003\u0010@\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010A\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020\u000f2\b\b\u0002\u0010C\u001a\u00020\u000f2\b\b\u0002\u0010D\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u000f2\b\b\u0002\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bF\u0010:J\u0003\u0010@\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010;\u001a\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020\u000f2\b\b\u0002\u0010=\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010A\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020\u000f2\b\b\u0002\u0010C\u001a\u00020\u000f2\b\b\u0002\u0010D\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u000f2\b\b\u0002\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010?R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006H"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuDefaults;", "", "()V", "ItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "TrailingIcon", "", "expanded", "", "(ZLandroidx/compose/runtime/Composer;I)V", "outlinedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "containerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-St-qZLY", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "unfocusedTextColor", "errorTextColor", "errorContainerColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "errorPlaceholderColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "outlinedTextFieldColors-tN0la-I", "(JJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "outlinedTextFieldColors-FD9MK7s", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-St-qZLY", "textFieldColors-tN0la-I", "textFieldColors-FD9MK7s", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();
    private static final PaddingValues ItemContentPadding = PaddingKt.m532PaddingValuesYgX7TsA(ExposedDropdownMenuKt.ExposedDropdownMenuItemHorizontalPadding, Dp.m5844constructorimpl((float) 0));

    private ExposedDropdownMenuDefaults() {
    }

    public final void TrailingIcon(boolean expanded, Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1803742020);
        ComposerKt.sourceInformation($composer2, "C(TrailingIcon)301@12373L129:ExposedDropdownMenu.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(expanded) ? 4 : 2;
        }
        if (($dirty & 11) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1803742020, $changed, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:300)");
            }
            IconKt.m1808Iconww6aTOc(ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE), (String) null, RotateKt.rotate(Modifier.Companion, expanded ? 180.0f : 0.0f), 0, $composer2, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ExposedDropdownMenuDefaults$TrailingIcon$1(this, expanded, $changed));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v96, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: textFieldColors-FD9MK7s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material3.TextFieldColors m1766textFieldColorsFD9MK7s(long r172, long r174, long r176, long r178, long r180, long r182, long r184, long r186, long r188, long r190, androidx.compose.foundation.text.selection.TextSelectionColors r192, long r193, long r195, long r197, long r199, long r201, long r203, long r205, long r207, long r209, long r211, long r213, long r215, long r217, long r219, long r221, long r223, long r225, long r227, long r229, long r231, long r233, long r235, long r237, long r239, long r241, long r243, long r245, long r247, androidx.compose.runtime.Composer r249, int r250, int r251, int r252, int r253, int r254, int r255) {
        /*
            r171 = this;
            r15 = r249
            r13 = r250
            r14 = r251
            r11 = r252
            r0 = r254
            r1 = r255
            r2 = -375683630(0xffffffffe99b85d2, float:-2.3501931E25)
            r15.startReplaceableGroup(r2)
            java.lang.String r3 = "C(textFieldColors)P(27:c#ui.graphics.Color,37:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,20:c#ui.graphics.Color,30:c#ui.graphics.Color,1:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,29,21:c#ui.graphics.Color,31:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)358@16485L9,359@16577L9,360@16676L9,362@16851L9,363@16950L9,364@17051L9,365@17151L9,366@17248L9,367@17333L9,368@17433L9,369@17516L7,371@17636L9,373@17755L9,375@17881L9,378@18097L9,380@18217L9,382@18334L9,384@18458L9,387@18668L9,389@18790L9,391@18909L9,393@19035L9,396@19248L9,397@19344L9,398@19437L9,399@19537L9,400@19631L9,402@19745L9,404@19861L9,406@19984L9,408@20175L9,409@20272L9,410@20371L9,412@20490L9,413@20659L9,414@20756L9,415@20855L9,417@20974L9,418@21143L9,420@21205L2230:ExposedDropdownMenu.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
            r3 = r0 & 1
            r4 = 6
            if (r3 == 0) goto L_0x0029
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldFocusInputTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r94 = r5
            goto L_0x002b
        L_0x0029:
            r94 = r172
        L_0x002b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x003c
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldInputTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r96 = r5
            goto L_0x003e
        L_0x003c:
            r96 = r174
        L_0x003e:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0061
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldDisabledInputTextColor()
            long r16 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r22 = 14
            r23 = 0
            r18 = 1052938076(0x3ec28f5c, float:0.38)
            r19 = 0
            r20 = 0
            r21 = 0
            long r5 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r16, r18, r19, r20, r21, r22, r23)
            r98 = r5
            goto L_0x0063
        L_0x0061:
            r98 = r176
        L_0x0063:
            r3 = r0 & 8
            if (r3 == 0) goto L_0x0074
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldErrorInputTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r100 = r5
            goto L_0x0076
        L_0x0074:
            r100 = r178
        L_0x0076:
            r3 = r0 & 16
            if (r3 == 0) goto L_0x0087
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldContainerColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r102 = r5
            goto L_0x0089
        L_0x0087:
            r102 = r180
        L_0x0089:
            r3 = r0 & 32
            if (r3 == 0) goto L_0x009a
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldContainerColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r104 = r5
            goto L_0x009c
        L_0x009a:
            r104 = r182
        L_0x009c:
            r3 = r0 & 64
            if (r3 == 0) goto L_0x00ad
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldContainerColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r106 = r5
            goto L_0x00af
        L_0x00ad:
            r106 = r184
        L_0x00af:
            r3 = r0 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x00c0
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldContainerColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r108 = r5
            goto L_0x00c2
        L_0x00c0:
            r108 = r186
        L_0x00c2:
            r3 = r0 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x00d3
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldCaretColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r110 = r5
            goto L_0x00d5
        L_0x00d3:
            r110 = r188
        L_0x00d5:
            r3 = r0 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x00e6
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldErrorFocusCaretColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r112 = r5
            goto L_0x00e8
        L_0x00e6:
            r112 = r190
        L_0x00e8:
            r3 = r0 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0109
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r5 = 0
            r6 = 0
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r7, r8)
            java.lang.Object r7 = r15.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r249)
            r3 = r7
            androidx.compose.foundation.text.selection.TextSelectionColors r3 = (androidx.compose.foundation.text.selection.TextSelectionColors) r3
            r114 = r3
            goto L_0x010b
        L_0x0109:
            r114 = r192
        L_0x010b:
            r3 = r0 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x011c
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldFocusActiveIndicatorColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r115 = r5
            goto L_0x011e
        L_0x011c:
            r115 = r193
        L_0x011e:
            r3 = r0 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x012f
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldActiveIndicatorColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r117 = r5
            goto L_0x0131
        L_0x012f:
            r117 = r195
        L_0x0131:
            r3 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x015e
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldDisabledActiveIndicatorColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r12 = 0
            r172 = r5
            r174 = r8
            r175 = r9
            r176 = r10
            r177 = r12
            r178 = r3
            r179 = r7
            long r5 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r172, r174, r175, r176, r177, r178, r179)
            r119 = r5
            goto L_0x0160
        L_0x015e:
            r119 = r197
        L_0x0160:
            r3 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x0171
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldErrorActiveIndicatorColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r121 = r5
            goto L_0x0173
        L_0x0171:
            r121 = r199
        L_0x0173:
            r3 = 32768(0x8000, float:4.5918E-41)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0186
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldFocusLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r123 = r5
            goto L_0x0188
        L_0x0186:
            r123 = r201
        L_0x0188:
            r3 = 65536(0x10000, float:9.18355E-41)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x019a
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r125 = r5
            goto L_0x019c
        L_0x019a:
            r125 = r203
        L_0x019c:
            r3 = 131072(0x20000, float:1.83671E-40)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x01ca
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldDisabledLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r12 = 0
            r172 = r5
            r174 = r8
            r175 = r9
            r176 = r10
            r177 = r12
            r178 = r3
            r179 = r7
            long r5 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r172, r174, r175, r176, r177, r178, r179)
            r127 = r5
            goto L_0x01cc
        L_0x01ca:
            r127 = r205
        L_0x01cc:
            r3 = 262144(0x40000, float:3.67342E-40)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x01de
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldErrorLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r129 = r5
            goto L_0x01e0
        L_0x01de:
            r129 = r207
        L_0x01e0:
            r3 = 524288(0x80000, float:7.34684E-40)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x01f2
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldFocusTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r131 = r5
            goto L_0x01f4
        L_0x01f2:
            r131 = r209
        L_0x01f4:
            r3 = 1048576(0x100000, float:1.469368E-39)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0206
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r133 = r5
            goto L_0x0208
        L_0x0206:
            r133 = r211
        L_0x0208:
            r3 = 2097152(0x200000, float:2.938736E-39)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0236
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldDisabledTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r12 = 0
            r172 = r5
            r174 = r8
            r175 = r9
            r176 = r10
            r177 = r12
            r178 = r3
            r179 = r7
            long r5 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r172, r174, r175, r176, r177, r178, r179)
            r135 = r5
            goto L_0x0238
        L_0x0236:
            r135 = r213
        L_0x0238:
            r3 = 4194304(0x400000, float:5.877472E-39)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x024a
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldErrorTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r137 = r5
            goto L_0x024c
        L_0x024a:
            r137 = r215
        L_0x024c:
            r3 = 8388608(0x800000, float:1.17549435E-38)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x025e
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldFocusLabelTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r139 = r5
            goto L_0x0260
        L_0x025e:
            r139 = r217
        L_0x0260:
            r3 = 16777216(0x1000000, float:2.3509887E-38)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0272
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldLabelTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r141 = r5
            goto L_0x0274
        L_0x0272:
            r141 = r219
        L_0x0274:
            r3 = 33554432(0x2000000, float:9.403955E-38)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0286
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldDisabledLabelTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r143 = r5
            goto L_0x0288
        L_0x0286:
            r143 = r221
        L_0x0288:
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x029a
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldErrorLabelTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r145 = r5
            goto L_0x029c
        L_0x029a:
            r145 = r223
        L_0x029c:
            r3 = 134217728(0x8000000, float:3.85186E-34)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x02ae
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r147 = r5
            goto L_0x02b0
        L_0x02ae:
            r147 = r225
        L_0x02b0:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x02c2
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r149 = r5
            goto L_0x02c4
        L_0x02c2:
            r149 = r227
        L_0x02c4:
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x02f2
            androidx.compose.material3.tokens.FilledAutocompleteTokens r3 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldDisabledSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r12 = 0
            r172 = r5
            r174 = r8
            r175 = r9
            r176 = r10
            r177 = r12
            r178 = r3
            r179 = r7
            long r5 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r172, r174, r175, r176, r177, r178, r179)
            r151 = r5
            goto L_0x02f4
        L_0x02f2:
            r151 = r229
        L_0x02f4:
            r3 = 1073741824(0x40000000, float:2.0)
            r0 = r0 & r3
            if (r0 == 0) goto L_0x0306
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r153 = r5
            goto L_0x0308
        L_0x0306:
            r153 = r231
        L_0x0308:
            r0 = r1 & 1
            if (r0 == 0) goto L_0x0319
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r155 = r5
            goto L_0x031b
        L_0x0319:
            r155 = r233
        L_0x031b:
            r0 = r1 & 2
            if (r0 == 0) goto L_0x032c
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r157 = r5
            goto L_0x032e
        L_0x032c:
            r157 = r235
        L_0x032e:
            r0 = r1 & 4
            if (r0 == 0) goto L_0x035b
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r0 = 14
            r3 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r172 = r5
            r174 = r7
            r175 = r8
            r176 = r9
            r177 = r10
            r178 = r0
            r179 = r3
            long r5 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r172, r174, r175, r176, r177, r178, r179)
            r159 = r5
            goto L_0x035d
        L_0x035b:
            r159 = r237
        L_0x035d:
            r0 = r1 & 8
            if (r0 == 0) goto L_0x036e
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r161 = r5
            goto L_0x0370
        L_0x036e:
            r161 = r239
        L_0x0370:
            r0 = r1 & 16
            if (r0 == 0) goto L_0x0381
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r163 = r5
            goto L_0x0383
        L_0x0381:
            r163 = r241
        L_0x0383:
            r0 = r1 & 32
            if (r0 == 0) goto L_0x0394
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r165 = r5
            goto L_0x0396
        L_0x0394:
            r165 = r243
        L_0x0396:
            r0 = r1 & 64
            if (r0 == 0) goto L_0x03c3
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r0 = 14
            r3 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r172 = r5
            r174 = r7
            r175 = r8
            r176 = r9
            r177 = r10
            r178 = r0
            r179 = r3
            long r5 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r172, r174, r175, r176, r177, r178, r179)
            r167 = r5
            goto L_0x03c5
        L_0x03c3:
            r167 = r245
        L_0x03c5:
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x03d6
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r0 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r169 = r0
            goto L_0x03d8
        L_0x03d6:
            r169 = r247
        L_0x03d8:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03e3
            java.lang.String r0 = "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:357)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r13, r14, r0)
        L_0x03e3:
            androidx.compose.material3.TextFieldDefaults r0 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            r1 = r13 & 14
            r2 = r13 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r13 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r13 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r3 = r13 & r2
            r1 = r1 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r4 = r13 & r3
            r1 = r1 | r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r5 = r13 & r4
            r1 = r1 | r5
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r13 & r5
            r1 = r1 | r6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r7 = r13 & r6
            r1 = r1 | r7
            r7 = 1879048192(0x70000000, float:1.58456325E29)
            r8 = r13 & r7
            r87 = r1 | r8
            r1 = r14 & 14
            r8 = r14 & 112(0x70, float:1.57E-43)
            r1 = r1 | r8
            r8 = r14 & 896(0x380, float:1.256E-42)
            r1 = r1 | r8
            r8 = r14 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r8
            r8 = r14 & r2
            r1 = r1 | r8
            r8 = r14 & r3
            r1 = r1 | r8
            r8 = r14 & r4
            r1 = r1 | r8
            r8 = r14 & r5
            r1 = r1 | r8
            r8 = r14 & r6
            r1 = r1 | r8
            r8 = r14 & r7
            r88 = r1 | r8
            r1 = r11 & 14
            r8 = r11 & 112(0x70, float:1.57E-43)
            r1 = r1 | r8
            r8 = r11 & 896(0x380, float:1.256E-42)
            r1 = r1 | r8
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r8
            r2 = r2 & r11
            r1 = r1 | r2
            r2 = r11 & r3
            r1 = r1 | r2
            r2 = r11 & r4
            r1 = r1 | r2
            r2 = r11 & r5
            r1 = r1 | r2
            r2 = r11 & r6
            r1 = r1 | r2
            r2 = r11 & r7
            r89 = r1 | r2
            r1 = r253 & 14
            int r2 = r253 << 12
            r2 = r2 & r3
            r1 = r1 | r2
            int r2 = r253 << 12
            r2 = r2 & r4
            r1 = r1 | r2
            int r2 = r253 << 12
            r2 = r2 & r5
            r1 = r1 | r2
            int r2 = r253 << 12
            r2 = r2 & r6
            r1 = r1 | r2
            int r2 = r253 << 12
            r2 = r2 & r7
            r90 = r1 | r2
            int r1 = r253 >> 18
            r1 = r1 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            int r2 = r253 >> 18
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r253 >> 18
            r2 = r2 & 896(0x380, float:1.256E-42)
            r91 = r1 | r2
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 0
            r92 = 0
            r93 = 15
            r1 = r94
            r3 = r96
            r5 = r98
            r7 = r100
            r9 = r102
            r11 = r104
            r13 = r106
            r15 = r108
            r17 = r110
            r19 = r112
            r21 = r114
            r22 = r115
            r24 = r117
            r26 = r119
            r28 = r121
            r30 = r123
            r32 = r125
            r34 = r127
            r36 = r129
            r38 = r131
            r40 = r133
            r42 = r135
            r44 = r137
            r46 = r139
            r48 = r141
            r50 = r143
            r52 = r145
            r54 = r147
            r56 = r149
            r58 = r151
            r60 = r153
            r70 = r155
            r72 = r157
            r74 = r159
            r76 = r161
            r78 = r163
            r80 = r165
            r82 = r167
            r84 = r169
            r86 = r249
            androidx.compose.material3.TextFieldColors r0 = r0.m2117colors0hiis_0(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r87, r88, r89, r90, r91, r92, r93)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0502
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0502:
            r249.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuDefaults.m1766textFieldColorsFD9MK7s(long, long, long, long, long, long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v97, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: outlinedTextFieldColors-FD9MK7s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material3.TextFieldColors m1763outlinedTextFieldColorsFD9MK7s(long r172, long r174, long r176, long r178, long r180, long r182, long r184, long r186, long r188, long r190, androidx.compose.foundation.text.selection.TextSelectionColors r192, long r193, long r195, long r197, long r199, long r201, long r203, long r205, long r207, long r209, long r211, long r213, long r215, long r217, long r219, long r221, long r223, long r225, long r227, long r229, long r231, long r233, long r235, long r237, long r239, long r241, long r243, long r245, long r247, androidx.compose.runtime.Composer r249, int r250, int r251, int r252, int r253, int r254, int r255) {
        /*
            r171 = this;
            r15 = r249
            r13 = r250
            r14 = r251
            r11 = r252
            r0 = r254
            r1 = r255
            r2 = -325161132(0xffffffffec9e6f54, float:-1.5322881E27)
            r15.startReplaceableGroup(r2)
            java.lang.String r3 = "C(outlinedTextFieldColors)P(27:c#ui.graphics.Color,37:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,21:c#ui.graphics.Color,31:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,29,20:c#ui.graphics.Color,30:c#ui.graphics.Color,1:c#ui.graphics.Color,10:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)511@27400L9,512@27494L9,513@27595L9,515@27774L9,520@28094L9,522@28208L9,523@28291L7,524@28390L9,525@28488L9,527@28605L9,529@28794L9,531@28916L9,533@29035L9,535@29161L9,538@29375L9,540@29499L9,542@29620L9,544@29748L9,547@29965L9,548@30063L9,549@30158L9,550@30260L9,552@30440L9,554@30556L9,556@30674L9,558@30799L9,561@31006L9,562@31105L9,563@31206L9,565@31327L9,566@31500L9,567@31599L9,568@31700L9,570@31821L9,571@31994L9,573@32064L2206:ExposedDropdownMenu.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
            r3 = r0 & 1
            r4 = 6
            if (r3 == 0) goto L_0x0029
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldFocusInputTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r94 = r5
            goto L_0x002b
        L_0x0029:
            r94 = r172
        L_0x002b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x003c
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldInputTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r96 = r5
            goto L_0x003e
        L_0x003c:
            r96 = r174
        L_0x003e:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0061
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldDisabledInputTextColor()
            long r16 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r22 = 14
            r23 = 0
            r18 = 1052938076(0x3ec28f5c, float:0.38)
            r19 = 0
            r20 = 0
            r21 = 0
            long r5 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r16, r18, r19, r20, r21, r22, r23)
            r98 = r5
            goto L_0x0063
        L_0x0061:
            r98 = r176
        L_0x0063:
            r3 = r0 & 8
            if (r3 == 0) goto L_0x0074
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldErrorInputTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r100 = r5
            goto L_0x0076
        L_0x0074:
            r100 = r178
        L_0x0076:
            r3 = r0 & 16
            if (r3 == 0) goto L_0x0083
            androidx.compose.ui.graphics.Color$Companion r3 = androidx.compose.ui.graphics.Color.Companion
            long r5 = r3.m3288getTransparent0d7_KjU()
            r102 = r5
            goto L_0x0085
        L_0x0083:
            r102 = r180
        L_0x0085:
            r3 = r0 & 32
            if (r3 == 0) goto L_0x0092
            androidx.compose.ui.graphics.Color$Companion r3 = androidx.compose.ui.graphics.Color.Companion
            long r5 = r3.m3288getTransparent0d7_KjU()
            r104 = r5
            goto L_0x0094
        L_0x0092:
            r104 = r182
        L_0x0094:
            r3 = r0 & 64
            if (r3 == 0) goto L_0x00a1
            androidx.compose.ui.graphics.Color$Companion r3 = androidx.compose.ui.graphics.Color.Companion
            long r5 = r3.m3288getTransparent0d7_KjU()
            r106 = r5
            goto L_0x00a3
        L_0x00a1:
            r106 = r184
        L_0x00a3:
            r3 = r0 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x00b0
            androidx.compose.ui.graphics.Color$Companion r3 = androidx.compose.ui.graphics.Color.Companion
            long r5 = r3.m3288getTransparent0d7_KjU()
            r108 = r5
            goto L_0x00b2
        L_0x00b0:
            r108 = r186
        L_0x00b2:
            r3 = r0 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x00c3
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldCaretColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r110 = r5
            goto L_0x00c5
        L_0x00c3:
            r110 = r188
        L_0x00c5:
            r3 = r0 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x00d6
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldErrorFocusCaretColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r112 = r5
            goto L_0x00d8
        L_0x00d6:
            r112 = r190
        L_0x00d8:
            r3 = r0 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x00f9
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r5 = 0
            r6 = 0
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r7, r8)
            java.lang.Object r7 = r15.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r249)
            r3 = r7
            androidx.compose.foundation.text.selection.TextSelectionColors r3 = (androidx.compose.foundation.text.selection.TextSelectionColors) r3
            r114 = r3
            goto L_0x00fb
        L_0x00f9:
            r114 = r192
        L_0x00fb:
            r3 = r0 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x010c
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldFocusOutlineColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r115 = r5
            goto L_0x010e
        L_0x010c:
            r115 = r193
        L_0x010e:
            r3 = r0 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x011f
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldOutlineColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r117 = r5
            goto L_0x0121
        L_0x011f:
            r117 = r195
        L_0x0121:
            r3 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x014e
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldDisabledOutlineColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1039516303(0x3df5c28f, float:0.12)
            r9 = 0
            r10 = 0
            r12 = 0
            r172 = r5
            r174 = r8
            r175 = r9
            r176 = r10
            r177 = r12
            r178 = r3
            r179 = r7
            long r5 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r172, r174, r175, r176, r177, r178, r179)
            r119 = r5
            goto L_0x0150
        L_0x014e:
            r119 = r197
        L_0x0150:
            r3 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x0161
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldErrorOutlineColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r121 = r5
            goto L_0x0163
        L_0x0161:
            r121 = r199
        L_0x0163:
            r3 = 32768(0x8000, float:4.5918E-41)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0176
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldFocusLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r123 = r5
            goto L_0x0178
        L_0x0176:
            r123 = r201
        L_0x0178:
            r3 = 65536(0x10000, float:9.18355E-41)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x018a
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r125 = r5
            goto L_0x018c
        L_0x018a:
            r125 = r203
        L_0x018c:
            r3 = 131072(0x20000, float:1.83671E-40)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x01ba
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldDisabledLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r12 = 0
            r172 = r5
            r174 = r8
            r175 = r9
            r176 = r10
            r177 = r12
            r178 = r3
            r179 = r7
            long r5 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r172, r174, r175, r176, r177, r178, r179)
            r127 = r5
            goto L_0x01bc
        L_0x01ba:
            r127 = r205
        L_0x01bc:
            r3 = 262144(0x40000, float:3.67342E-40)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x01ce
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldErrorLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r129 = r5
            goto L_0x01d0
        L_0x01ce:
            r129 = r207
        L_0x01d0:
            r3 = 524288(0x80000, float:7.34684E-40)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x01e2
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldFocusTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r131 = r5
            goto L_0x01e4
        L_0x01e2:
            r131 = r209
        L_0x01e4:
            r3 = 1048576(0x100000, float:1.469368E-39)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x01f6
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r133 = r5
            goto L_0x01f8
        L_0x01f6:
            r133 = r211
        L_0x01f8:
            r3 = 2097152(0x200000, float:2.938736E-39)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0226
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldDisabledTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r12 = 0
            r172 = r5
            r174 = r8
            r175 = r9
            r176 = r10
            r177 = r12
            r178 = r3
            r179 = r7
            long r5 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r172, r174, r175, r176, r177, r178, r179)
            r135 = r5
            goto L_0x0228
        L_0x0226:
            r135 = r213
        L_0x0228:
            r3 = 4194304(0x400000, float:5.877472E-39)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x023a
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTextFieldErrorTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r137 = r5
            goto L_0x023c
        L_0x023a:
            r137 = r215
        L_0x023c:
            r3 = 8388608(0x800000, float:1.17549435E-38)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x024e
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldFocusLabelTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r139 = r5
            goto L_0x0250
        L_0x024e:
            r139 = r217
        L_0x0250:
            r3 = 16777216(0x1000000, float:2.3509887E-38)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0262
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldLabelTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r141 = r5
            goto L_0x0264
        L_0x0262:
            r141 = r219
        L_0x0264:
            r3 = 33554432(0x2000000, float:9.403955E-38)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0292
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldDisabledLabelTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r12 = 0
            r172 = r5
            r174 = r8
            r175 = r9
            r176 = r10
            r177 = r12
            r178 = r3
            r179 = r7
            long r5 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r172, r174, r175, r176, r177, r178, r179)
            r143 = r5
            goto L_0x0294
        L_0x0292:
            r143 = r221
        L_0x0294:
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x02a6
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldErrorLabelTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r145 = r5
            goto L_0x02a8
        L_0x02a6:
            r145 = r223
        L_0x02a8:
            r3 = 134217728(0x8000000, float:3.85186E-34)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x02ba
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r147 = r5
            goto L_0x02bc
        L_0x02ba:
            r147 = r225
        L_0x02bc:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x02ce
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r149 = r5
            goto L_0x02d0
        L_0x02ce:
            r149 = r227
        L_0x02d0:
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x02fe
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r3 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFieldDisabledSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r12 = 0
            r172 = r5
            r174 = r8
            r175 = r9
            r176 = r10
            r177 = r12
            r178 = r3
            r179 = r7
            long r5 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r172, r174, r175, r176, r177, r178, r179)
            r151 = r5
            goto L_0x0300
        L_0x02fe:
            r151 = r229
        L_0x0300:
            r3 = 1073741824(0x40000000, float:2.0)
            r0 = r0 & r3
            if (r0 == 0) goto L_0x0312
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r153 = r5
            goto L_0x0314
        L_0x0312:
            r153 = r231
        L_0x0314:
            r0 = r1 & 1
            if (r0 == 0) goto L_0x0325
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r155 = r5
            goto L_0x0327
        L_0x0325:
            r155 = r233
        L_0x0327:
            r0 = r1 & 2
            if (r0 == 0) goto L_0x0338
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r157 = r5
            goto L_0x033a
        L_0x0338:
            r157 = r235
        L_0x033a:
            r0 = r1 & 4
            if (r0 == 0) goto L_0x0367
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r0 = 14
            r3 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r172 = r5
            r174 = r7
            r175 = r8
            r176 = r9
            r177 = r10
            r178 = r0
            r179 = r3
            long r5 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r172, r174, r175, r176, r177, r178, r179)
            r159 = r5
            goto L_0x0369
        L_0x0367:
            r159 = r237
        L_0x0369:
            r0 = r1 & 8
            if (r0 == 0) goto L_0x037a
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r161 = r5
            goto L_0x037c
        L_0x037a:
            r161 = r239
        L_0x037c:
            r0 = r1 & 16
            if (r0 == 0) goto L_0x038d
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r163 = r5
            goto L_0x038f
        L_0x038d:
            r163 = r241
        L_0x038f:
            r0 = r1 & 32
            if (r0 == 0) goto L_0x03a0
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r165 = r5
            goto L_0x03a2
        L_0x03a0:
            r165 = r243
        L_0x03a2:
            r0 = r1 & 64
            if (r0 == 0) goto L_0x03cf
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledSupportingTextColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r0 = 14
            r3 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r172 = r5
            r174 = r7
            r175 = r8
            r176 = r9
            r177 = r10
            r178 = r0
            r179 = r3
            long r5 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r172, r174, r175, r176, r177, r178, r179)
            r167 = r5
            goto L_0x03d1
        L_0x03cf:
            r167 = r245
        L_0x03d1:
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x03e2
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r0 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r169 = r0
            goto L_0x03e4
        L_0x03e2:
            r169 = r247
        L_0x03e4:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03ef
            java.lang.String r0 = "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:510)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r13, r14, r0)
        L_0x03ef:
            androidx.compose.material3.OutlinedTextFieldDefaults r0 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r1 = r13 & 14
            r2 = r13 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r13 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r13 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r3 = r13 & r2
            r1 = r1 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r4 = r13 & r3
            r1 = r1 | r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r5 = r13 & r4
            r1 = r1 | r5
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r13 & r5
            r1 = r1 | r6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r7 = r13 & r6
            r1 = r1 | r7
            r7 = 1879048192(0x70000000, float:1.58456325E29)
            r8 = r13 & r7
            r87 = r1 | r8
            r1 = r14 & 14
            r8 = r14 & 112(0x70, float:1.57E-43)
            r1 = r1 | r8
            r8 = r14 & 896(0x380, float:1.256E-42)
            r1 = r1 | r8
            r8 = r14 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r8
            r8 = r14 & r2
            r1 = r1 | r8
            r8 = r14 & r3
            r1 = r1 | r8
            r8 = r14 & r4
            r1 = r1 | r8
            r8 = r14 & r5
            r1 = r1 | r8
            r8 = r14 & r6
            r1 = r1 | r8
            r8 = r14 & r7
            r88 = r1 | r8
            r1 = r11 & 14
            r8 = r11 & 112(0x70, float:1.57E-43)
            r1 = r1 | r8
            r8 = r11 & 896(0x380, float:1.256E-42)
            r1 = r1 | r8
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r8
            r2 = r2 & r11
            r1 = r1 | r2
            r2 = r11 & r3
            r1 = r1 | r2
            r2 = r11 & r4
            r1 = r1 | r2
            r2 = r11 & r5
            r1 = r1 | r2
            r2 = r11 & r6
            r1 = r1 | r2
            r2 = r11 & r7
            r89 = r1 | r2
            r1 = r253 & 14
            int r2 = r253 << 12
            r2 = r2 & r3
            r1 = r1 | r2
            int r2 = r253 << 12
            r2 = r2 & r4
            r1 = r1 | r2
            int r2 = r253 << 12
            r2 = r2 & r5
            r1 = r1 | r2
            int r2 = r253 << 12
            r2 = r2 & r6
            r1 = r1 | r2
            int r2 = r253 << 12
            r2 = r2 & r7
            r90 = r1 | r2
            int r1 = r253 >> 18
            r1 = r1 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            int r2 = r253 >> 18
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r253 >> 18
            r2 = r2 & 896(0x380, float:1.256E-42)
            r91 = r1 | r2
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 0
            r92 = 0
            r93 = 15
            r1 = r94
            r3 = r96
            r5 = r98
            r7 = r100
            r9 = r102
            r11 = r104
            r13 = r106
            r15 = r108
            r17 = r110
            r19 = r112
            r21 = r114
            r22 = r115
            r24 = r117
            r26 = r119
            r28 = r121
            r30 = r123
            r32 = r125
            r34 = r127
            r36 = r129
            r38 = r131
            r40 = r133
            r42 = r135
            r44 = r137
            r46 = r139
            r48 = r141
            r50 = r143
            r52 = r145
            r54 = r147
            r56 = r149
            r58 = r151
            r60 = r153
            r70 = r155
            r72 = r157
            r74 = r159
            r76 = r161
            r78 = r163
            r80 = r165
            r82 = r167
            r84 = r169
            r86 = r249
            androidx.compose.material3.TextFieldColors r0 = r0.m1894colors0hiis_0(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r87, r88, r89, r90, r91, r92, r93)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x050e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x050e:
            r249.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuDefaults.m1763outlinedTextFieldColorsFD9MK7s(long, long, long, long, long, long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    public final PaddingValues getItemContentPadding() {
        return ItemContentPadding;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v152, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: textFieldColors-tN0la-I  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ androidx.compose.material3.TextFieldColors m1768textFieldColorstN0laI(long r159, long r161, long r163, long r165, long r167, long r169, long r171, long r173, androidx.compose.foundation.text.selection.TextSelectionColors r175, long r176, long r178, long r180, long r182, long r184, long r186, long r188, long r190, long r192, long r194, long r196, long r198, long r200, long r202, long r204, long r206, long r208, long r210, long r212, long r214, long r216, long r218, long r220, long r222, long r224, long r226, long r228, long r230, androidx.compose.runtime.Composer r232, int r233, int r234, int r235, int r236, int r237, int r238) {
        /*
            r158 = this;
            r15 = r232
            r13 = r233
            r14 = r234
            r0 = r237
            r1 = 1357676928(0x50ec8180, float:3.17432791E10)
            r15.startReplaceableGroup(r1)
            java.lang.String r2 = "C(textFieldColors)P(26:c#ui.graphics.Color,35:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,0:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,28,20:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,22:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,27:c#ui.graphics.Color,36:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,21:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,32:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,24:c#ui.graphics.Color,33:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,25:c#ui.graphics.Color,34:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)627@34809L9,628@34901L9,629@35000L9,631@35175L9,632@35267L9,633@35364L9,634@35449L9,635@35549L9,636@35632L7,638@35752L9,640@35871L9,642@35997L9,645@36213L9,647@36333L9,649@36450L9,651@36574L9,654@36784L9,656@36906L9,658@37025L9,660@37151L9,663@37364L9,664@37460L9,665@37553L9,666@37653L9,667@37747L9,669@37861L9,671@37977L9,673@38100L9,675@38291L9,676@38388L9,677@38487L9,679@38606L9,680@38775L9,681@38872L9,682@38971L9,684@39090L9,685@39259L9,687@39303L2215:ExposedDropdownMenu.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r0 & 1
            r3 = 6
            if (r2 == 0) goto L_0x0025
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldFocusInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r85 = r4
            goto L_0x0027
        L_0x0025:
            r85 = r159
        L_0x0027:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0038
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r87 = r4
            goto L_0x003a
        L_0x0038:
            r87 = r161
        L_0x003a:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0059
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldDisabledInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r10 = 14
            r11 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r4, r6, r7, r8, r9, r10, r11)
            r89 = r4
            goto L_0x005b
        L_0x0059:
            r89 = r163
        L_0x005b:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x006c
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldErrorInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r91 = r4
            goto L_0x006e
        L_0x006c:
            r91 = r165
        L_0x006e:
            r2 = r0 & 16
            if (r2 == 0) goto L_0x007f
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldContainerColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r93 = r4
            goto L_0x0081
        L_0x007f:
            r93 = r167
        L_0x0081:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x0092
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldContainerColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r95 = r4
            goto L_0x0094
        L_0x0092:
            r95 = r169
        L_0x0094:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x00a5
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r97 = r4
            goto L_0x00a7
        L_0x00a5:
            r97 = r171
        L_0x00a7:
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00b8
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorFocusCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r99 = r4
            goto L_0x00ba
        L_0x00b8:
            r99 = r173
        L_0x00ba:
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x00db
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r5 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r6, r7)
            java.lang.Object r6 = r15.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r232)
            r2 = r6
            androidx.compose.foundation.text.selection.TextSelectionColors r2 = (androidx.compose.foundation.text.selection.TextSelectionColors) r2
            r101 = r2
            goto L_0x00dd
        L_0x00db:
            r101 = r175
        L_0x00dd:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x00ee
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r102 = r4
            goto L_0x00f0
        L_0x00ee:
            r102 = r176
        L_0x00f0:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0101
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r104 = r4
            goto L_0x0103
        L_0x0101:
            r104 = r178
        L_0x0103:
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0130
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r159 = r4
            r161 = r7
            r162 = r8
            r163 = r9
            r164 = r10
            r165 = r2
            r166 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r159, r161, r162, r163, r164, r165, r166)
            r106 = r4
            goto L_0x0132
        L_0x0130:
            r106 = r180
        L_0x0132:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x0143
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r108 = r4
            goto L_0x0145
        L_0x0143:
            r108 = r182
        L_0x0145:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0156
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r110 = r4
            goto L_0x0158
        L_0x0156:
            r110 = r184
        L_0x0158:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0169
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r112 = r4
            goto L_0x016b
        L_0x0169:
            r112 = r186
        L_0x016b:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x019a
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r159 = r4
            r161 = r7
            r162 = r8
            r163 = r9
            r164 = r10
            r165 = r2
            r166 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r159, r161, r162, r163, r164, r165, r166)
            r114 = r4
            goto L_0x019c
        L_0x019a:
            r114 = r188
        L_0x019c:
            r2 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01ae
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r116 = r4
            goto L_0x01b0
        L_0x01ae:
            r116 = r190
        L_0x01b0:
            r2 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01c2
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r118 = r4
            goto L_0x01c4
        L_0x01c2:
            r118 = r192
        L_0x01c4:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01d6
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r120 = r4
            goto L_0x01d8
        L_0x01d6:
            r120 = r194
        L_0x01d8:
            r2 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0206
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r159 = r4
            r161 = r7
            r162 = r8
            r163 = r9
            r164 = r10
            r165 = r2
            r166 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r159, r161, r162, r163, r164, r165, r166)
            r122 = r4
            goto L_0x0208
        L_0x0206:
            r122 = r196
        L_0x0208:
            r2 = 1048576(0x100000, float:1.469368E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x021a
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r124 = r4
            goto L_0x021c
        L_0x021a:
            r124 = r198
        L_0x021c:
            r2 = 2097152(0x200000, float:2.938736E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x022e
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldFocusLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r126 = r4
            goto L_0x0230
        L_0x022e:
            r126 = r200
        L_0x0230:
            r2 = 4194304(0x400000, float:5.877472E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0242
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r128 = r4
            goto L_0x0244
        L_0x0242:
            r128 = r202
        L_0x0244:
            r2 = 8388608(0x800000, float:1.17549435E-38)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0256
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldDisabledLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r130 = r4
            goto L_0x0258
        L_0x0256:
            r130 = r204
        L_0x0258:
            r2 = 16777216(0x1000000, float:2.3509887E-38)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x026a
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldErrorLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r132 = r4
            goto L_0x026c
        L_0x026a:
            r132 = r206
        L_0x026c:
            r2 = 33554432(0x2000000, float:9.403955E-38)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x027e
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r134 = r4
            goto L_0x0280
        L_0x027e:
            r134 = r208
        L_0x0280:
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0292
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r136 = r4
            goto L_0x0294
        L_0x0292:
            r136 = r210
        L_0x0294:
            r2 = 134217728(0x8000000, float:3.85186E-34)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x02c2
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldDisabledSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r159 = r4
            r161 = r7
            r162 = r8
            r163 = r9
            r164 = r10
            r165 = r2
            r166 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r159, r161, r162, r163, r164, r165, r166)
            r138 = r4
            goto L_0x02c4
        L_0x02c2:
            r138 = r212
        L_0x02c4:
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x02d6
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r140 = r4
            goto L_0x02d8
        L_0x02d6:
            r140 = r214
        L_0x02d8:
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x02ea
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r142 = r4
            goto L_0x02ec
        L_0x02ea:
            r142 = r216
        L_0x02ec:
            r2 = 1073741824(0x40000000, float:2.0)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x02fe
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r144 = r4
            goto L_0x0300
        L_0x02fe:
            r144 = r218
        L_0x0300:
            r0 = r238 & 1
            if (r0 == 0) goto L_0x032d
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r0 = 14
            r2 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            r159 = r4
            r161 = r6
            r162 = r7
            r163 = r8
            r164 = r9
            r165 = r0
            r166 = r2
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r159, r161, r162, r163, r164, r165, r166)
            r146 = r4
            goto L_0x032f
        L_0x032d:
            r146 = r220
        L_0x032f:
            r0 = r238 & 2
            if (r0 == 0) goto L_0x0340
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r148 = r4
            goto L_0x0342
        L_0x0340:
            r148 = r222
        L_0x0342:
            r0 = r238 & 4
            if (r0 == 0) goto L_0x0353
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r150 = r4
            goto L_0x0355
        L_0x0353:
            r150 = r224
        L_0x0355:
            r0 = r238 & 8
            if (r0 == 0) goto L_0x0366
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r152 = r4
            goto L_0x0368
        L_0x0366:
            r152 = r226
        L_0x0368:
            r0 = r238 & 16
            if (r0 == 0) goto L_0x0395
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r0 = 14
            r2 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            r159 = r4
            r161 = r6
            r162 = r7
            r163 = r8
            r164 = r9
            r165 = r0
            r166 = r2
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r159, r161, r162, r163, r164, r165, r166)
            r154 = r4
            goto L_0x0397
        L_0x0395:
            r154 = r228
        L_0x0397:
            r0 = r238 & 32
            if (r0 == 0) goto L_0x03a8
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r2 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r156 = r2
            goto L_0x03aa
        L_0x03a8:
            r156 = r230
        L_0x03aa:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03b5
            java.lang.String r0 = "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:626)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r13, r14, r0)
        L_0x03b5:
            r0 = r13 & 14
            r1 = r13 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r13 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r13 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            r2 = r13 & r1
            r0 = r0 | r2
            int r2 = r13 << 3
            r3 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r3
            r0 = r0 | r2
            int r2 = r13 << 6
            r4 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r4
            r0 = r0 | r2
            int r2 = r13 << 6
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r5
            r0 = r0 | r2
            int r2 = r13 << 6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r6
            r0 = r0 | r2
            int r2 = r13 << 6
            r7 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r7
            r79 = r0 | r2
            int r0 = r13 >> 24
            r0 = r0 & 14
            int r2 = r13 >> 24
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r1
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r3
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r4
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r5
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r6
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r7
            r80 = r0 | r2
            int r0 = r14 >> 24
            r0 = r0 & 14
            int r2 = r14 >> 24
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & r1
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & r3
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & r4
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & r5
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & r6
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & r7
            r81 = r0 | r2
            int r0 = r235 >> 24
            r0 = r0 & 14
            int r2 = r235 >> 24
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r236 << 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r236 << 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r236 << 6
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r236 << 6
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r236 << 6
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r236 << 6
            r1 = r1 & r5
            r0 = r0 | r1
            int r1 = r236 << 6
            r1 = r1 & r6
            r0 = r0 | r1
            int r1 = r236 << 6
            r1 = r1 & r7
            r82 = r0 | r1
            r83 = 0
            r84 = 0
            r0 = r158
            r1 = r85
            r3 = r87
            r5 = r89
            r7 = r91
            r9 = r93
            r11 = r93
            r13 = r93
            r15 = r95
            r17 = r97
            r19 = r99
            r21 = r101
            r22 = r102
            r24 = r104
            r26 = r106
            r28 = r108
            r30 = r110
            r32 = r112
            r34 = r114
            r36 = r116
            r38 = r118
            r40 = r120
            r42 = r122
            r44 = r124
            r46 = r126
            r48 = r128
            r50 = r130
            r52 = r132
            r54 = r134
            r56 = r136
            r58 = r138
            r60 = r140
            r62 = r142
            r64 = r144
            r66 = r146
            r68 = r148
            r70 = r150
            r72 = r152
            r74 = r154
            r76 = r156
            r78 = r232
            androidx.compose.material3.TextFieldColors r0 = r0.m1766textFieldColorsFD9MK7s(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r79, r80, r81, r82, r83, r84)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x04f2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04f2:
            r232.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuDefaults.m1768textFieldColorstN0laI(long, long, long, long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v153, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: outlinedTextFieldColors-tN0la-I  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ androidx.compose.material3.TextFieldColors m1765outlinedTextFieldColorstN0laI(long r159, long r161, long r163, long r165, long r167, long r169, long r171, long r173, androidx.compose.foundation.text.selection.TextSelectionColors r175, long r176, long r178, long r180, long r182, long r184, long r186, long r188, long r190, long r192, long r194, long r196, long r198, long r200, long r202, long r204, long r206, long r208, long r210, long r212, long r214, long r216, long r218, long r220, long r222, long r224, long r226, long r228, long r230, androidx.compose.runtime.Composer r232, int r233, int r234, int r235, int r236, int r237, int r238) {
        /*
            r158 = this;
            r15 = r232
            r13 = r233
            r14 = r234
            r0 = r237
            r1 = -907010558(0xffffffffc9f01e02, float:-1967040.2)
            r15.startReplaceableGroup(r1)
            java.lang.String r2 = "C(outlinedTextFieldColors)P(26:c#ui.graphics.Color,35:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,28,20:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,10:c#ui.graphics.Color,22:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,27:c#ui.graphics.Color,36:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,21:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,32:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,24:c#ui.graphics.Color,33:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,25:c#ui.graphics.Color,34:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)732@41743L9,733@41837L9,734@41938L9,736@42117L9,739@42311L9,741@42425L9,742@42508L7,743@42607L9,744@42705L9,746@42822L9,748@43011L9,750@43133L9,752@43252L9,754@43378L9,757@43592L9,759@43716L9,761@43837L9,763@43965L9,766@44182L9,767@44280L9,768@44375L9,769@44477L9,771@44657L9,773@44773L9,775@44891L9,777@45016L9,780@45223L9,781@45322L9,782@45423L9,784@45544L9,785@45717L9,786@45816L9,787@45917L9,789@46038L9,790@46211L9,792@46255L2199:ExposedDropdownMenu.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r0 & 1
            r3 = 6
            if (r2 == 0) goto L_0x0025
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldFocusInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r85 = r4
            goto L_0x0027
        L_0x0025:
            r85 = r159
        L_0x0027:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0038
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r87 = r4
            goto L_0x003a
        L_0x0038:
            r87 = r161
        L_0x003a:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0059
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldDisabledInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r10 = 14
            r11 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r4, r6, r7, r8, r9, r10, r11)
            r89 = r4
            goto L_0x005b
        L_0x0059:
            r89 = r163
        L_0x005b:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x006c
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldErrorInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r91 = r4
            goto L_0x006e
        L_0x006c:
            r91 = r165
        L_0x006e:
            r2 = r0 & 16
            if (r2 == 0) goto L_0x007b
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r4 = r2.m3288getTransparent0d7_KjU()
            r93 = r4
            goto L_0x007d
        L_0x007b:
            r93 = r167
        L_0x007d:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x008a
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r4 = r2.m3288getTransparent0d7_KjU()
            r95 = r4
            goto L_0x008c
        L_0x008a:
            r95 = r169
        L_0x008c:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x009d
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r97 = r4
            goto L_0x009f
        L_0x009d:
            r97 = r171
        L_0x009f:
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00b0
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorFocusCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r99 = r4
            goto L_0x00b2
        L_0x00b0:
            r99 = r173
        L_0x00b2:
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x00d3
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r5 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r6, r7)
            java.lang.Object r6 = r15.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r232)
            r2 = r6
            androidx.compose.foundation.text.selection.TextSelectionColors r2 = (androidx.compose.foundation.text.selection.TextSelectionColors) r2
            r101 = r2
            goto L_0x00d5
        L_0x00d3:
            r101 = r175
        L_0x00d5:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x00e6
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r102 = r4
            goto L_0x00e8
        L_0x00e6:
            r102 = r176
        L_0x00e8:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x00f9
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r104 = r4
            goto L_0x00fb
        L_0x00f9:
            r104 = r178
        L_0x00fb:
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0128
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1039516303(0x3df5c28f, float:0.12)
            r8 = 0
            r9 = 0
            r10 = 0
            r159 = r4
            r161 = r7
            r162 = r8
            r163 = r9
            r164 = r10
            r165 = r2
            r166 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r159, r161, r162, r163, r164, r165, r166)
            r106 = r4
            goto L_0x012a
        L_0x0128:
            r106 = r180
        L_0x012a:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x013b
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r108 = r4
            goto L_0x013d
        L_0x013b:
            r108 = r182
        L_0x013d:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x014e
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r110 = r4
            goto L_0x0150
        L_0x014e:
            r110 = r184
        L_0x0150:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0161
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r112 = r4
            goto L_0x0163
        L_0x0161:
            r112 = r186
        L_0x0163:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0192
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r159 = r4
            r161 = r7
            r162 = r8
            r163 = r9
            r164 = r10
            r165 = r2
            r166 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r159, r161, r162, r163, r164, r165, r166)
            r114 = r4
            goto L_0x0194
        L_0x0192:
            r114 = r188
        L_0x0194:
            r2 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01a6
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r116 = r4
            goto L_0x01a8
        L_0x01a6:
            r116 = r190
        L_0x01a8:
            r2 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01ba
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r118 = r4
            goto L_0x01bc
        L_0x01ba:
            r118 = r192
        L_0x01bc:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01ce
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r120 = r4
            goto L_0x01d0
        L_0x01ce:
            r120 = r194
        L_0x01d0:
            r2 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01fe
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r159 = r4
            r161 = r7
            r162 = r8
            r163 = r9
            r164 = r10
            r165 = r2
            r166 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r159, r161, r162, r163, r164, r165, r166)
            r122 = r4
            goto L_0x0200
        L_0x01fe:
            r122 = r196
        L_0x0200:
            r2 = 1048576(0x100000, float:1.469368E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0212
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r124 = r4
            goto L_0x0214
        L_0x0212:
            r124 = r198
        L_0x0214:
            r2 = 2097152(0x200000, float:2.938736E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0226
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldFocusLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r126 = r4
            goto L_0x0228
        L_0x0226:
            r126 = r200
        L_0x0228:
            r2 = 4194304(0x400000, float:5.877472E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x023a
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r128 = r4
            goto L_0x023c
        L_0x023a:
            r128 = r202
        L_0x023c:
            r2 = 8388608(0x800000, float:1.17549435E-38)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x026a
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldDisabledLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r159 = r4
            r161 = r7
            r162 = r8
            r163 = r9
            r164 = r10
            r165 = r2
            r166 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r159, r161, r162, r163, r164, r165, r166)
            r130 = r4
            goto L_0x026c
        L_0x026a:
            r130 = r204
        L_0x026c:
            r2 = 16777216(0x1000000, float:2.3509887E-38)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x027e
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldErrorLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r132 = r4
            goto L_0x0280
        L_0x027e:
            r132 = r206
        L_0x0280:
            r2 = 33554432(0x2000000, float:9.403955E-38)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0292
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r134 = r4
            goto L_0x0294
        L_0x0292:
            r134 = r208
        L_0x0294:
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x02a6
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r136 = r4
            goto L_0x02a8
        L_0x02a6:
            r136 = r210
        L_0x02a8:
            r2 = 134217728(0x8000000, float:3.85186E-34)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x02d6
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldDisabledSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r159 = r4
            r161 = r7
            r162 = r8
            r163 = r9
            r164 = r10
            r165 = r2
            r166 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r159, r161, r162, r163, r164, r165, r166)
            r138 = r4
            goto L_0x02d8
        L_0x02d6:
            r138 = r212
        L_0x02d8:
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x02ea
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r140 = r4
            goto L_0x02ec
        L_0x02ea:
            r140 = r214
        L_0x02ec:
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x02fe
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r142 = r4
            goto L_0x0300
        L_0x02fe:
            r142 = r216
        L_0x0300:
            r2 = 1073741824(0x40000000, float:2.0)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0312
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r144 = r4
            goto L_0x0314
        L_0x0312:
            r144 = r218
        L_0x0314:
            r0 = r238 & 1
            if (r0 == 0) goto L_0x0341
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r0 = 14
            r2 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            r159 = r4
            r161 = r6
            r162 = r7
            r163 = r8
            r164 = r9
            r165 = r0
            r166 = r2
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r159, r161, r162, r163, r164, r165, r166)
            r146 = r4
            goto L_0x0343
        L_0x0341:
            r146 = r220
        L_0x0343:
            r0 = r238 & 2
            if (r0 == 0) goto L_0x0354
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r148 = r4
            goto L_0x0356
        L_0x0354:
            r148 = r222
        L_0x0356:
            r0 = r238 & 4
            if (r0 == 0) goto L_0x0367
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r150 = r4
            goto L_0x0369
        L_0x0367:
            r150 = r224
        L_0x0369:
            r0 = r238 & 8
            if (r0 == 0) goto L_0x037a
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r152 = r4
            goto L_0x037c
        L_0x037a:
            r152 = r226
        L_0x037c:
            r0 = r238 & 16
            if (r0 == 0) goto L_0x03a9
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r0 = 14
            r2 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            r159 = r4
            r161 = r6
            r162 = r7
            r163 = r8
            r164 = r9
            r165 = r0
            r166 = r2
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r159, r161, r162, r163, r164, r165, r166)
            r154 = r4
            goto L_0x03ab
        L_0x03a9:
            r154 = r228
        L_0x03ab:
            r0 = r238 & 32
            if (r0 == 0) goto L_0x03bc
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r2 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r156 = r2
            goto L_0x03be
        L_0x03bc:
            r156 = r230
        L_0x03be:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03c9
            java.lang.String r0 = "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:731)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r13, r14, r0)
        L_0x03c9:
            r0 = r13 & 14
            r1 = r13 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r13 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r13 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            r2 = r13 & r1
            r0 = r0 | r2
            int r2 = r13 << 3
            r3 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r3
            r0 = r0 | r2
            int r2 = r13 << 6
            r4 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r4
            r0 = r0 | r2
            int r2 = r13 << 6
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r5
            r0 = r0 | r2
            int r2 = r13 << 6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r6
            r0 = r0 | r2
            int r2 = r13 << 6
            r7 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r7
            r79 = r0 | r2
            int r0 = r13 >> 24
            r0 = r0 & 14
            int r2 = r13 >> 24
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r1
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r3
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r4
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r5
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r6
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r7
            r80 = r0 | r2
            int r0 = r14 >> 24
            r0 = r0 & 14
            int r2 = r14 >> 24
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & r1
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & r3
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & r4
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & r5
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & r6
            r0 = r0 | r2
            int r2 = r235 << 6
            r2 = r2 & r7
            r81 = r0 | r2
            int r0 = r235 >> 24
            r0 = r0 & 14
            int r2 = r235 >> 24
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r236 << 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r236 << 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r236 << 6
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r236 << 6
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r236 << 6
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r236 << 6
            r1 = r1 & r5
            r0 = r0 | r1
            int r1 = r236 << 6
            r1 = r1 & r6
            r0 = r0 | r1
            int r1 = r236 << 6
            r1 = r1 & r7
            r82 = r0 | r1
            r83 = 0
            r84 = 0
            r0 = r158
            r1 = r85
            r3 = r87
            r5 = r89
            r7 = r91
            r9 = r93
            r11 = r93
            r13 = r93
            r15 = r95
            r17 = r97
            r19 = r99
            r21 = r101
            r22 = r102
            r24 = r104
            r26 = r106
            r28 = r108
            r30 = r110
            r32 = r112
            r34 = r114
            r36 = r116
            r38 = r118
            r40 = r120
            r42 = r122
            r44 = r124
            r46 = r126
            r48 = r128
            r50 = r130
            r52 = r132
            r54 = r134
            r56 = r136
            r58 = r138
            r60 = r140
            r62 = r142
            r64 = r144
            r66 = r146
            r68 = r148
            r70 = r150
            r72 = r152
            r74 = r154
            r76 = r156
            r78 = r232
            androidx.compose.material3.TextFieldColors r0 = r0.m1763outlinedTextFieldColorsFD9MK7s(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r79, r80, r81, r82, r83, r84)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0506
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0506:
            r232.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuDefaults.m1765outlinedTextFieldColorstN0laI(long, long, long, long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v75, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: textFieldColors-St-qZLY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ androidx.compose.material3.TextFieldColors m1767textFieldColorsStqZLY(long r133, long r135, long r137, long r139, long r141, androidx.compose.foundation.text.selection.TextSelectionColors r143, long r144, long r146, long r148, long r150, long r152, long r154, long r156, long r158, long r160, long r162, long r164, long r166, long r168, long r170, long r172, long r174, long r176, long r178, androidx.compose.runtime.Composer r180, int r181, int r182, int r183, int r184) {
        /*
            r132 = this;
            r15 = r180
            r13 = r181
            r14 = r182
            r0 = r184
            r1 = -2013303349(0xffffffff87ff6dcb, float:-3.8432666E-34)
            r15.startReplaceableGroup(r1)
            java.lang.String r2 = "C(textFieldColors)P(19:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,18,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,22:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,16:c#ui.graphics.Color,23:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)837@48657L9,838@48756L9,840@48930L9,841@49015L9,842@49115L9,843@49198L7,845@49318L9,847@49437L9,849@49563L9,852@49779L9,854@49899L9,856@50016L9,858@50140L9,861@50350L9,863@50472L9,865@50591L9,867@50717L9,870@50930L9,871@51026L9,872@51119L9,873@51219L9,874@51313L9,875@51408L9,877@51526L9,911@53335L9,912@53429L9,913@53530L9,915@53709L9,916@53801L9,917@53895L9,918@53996L9,920@54175L9,879@51647L2544:ExposedDropdownMenu.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r0 & 1
            r3 = 6
            if (r2 == 0) goto L_0x0025
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r85 = r4
            goto L_0x0027
        L_0x0025:
            r85 = r133
        L_0x0027:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0046
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldDisabledInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r10 = 14
            r11 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r4, r6, r7, r8, r9, r10, r11)
            r87 = r4
            goto L_0x0048
        L_0x0046:
            r87 = r135
        L_0x0048:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0059
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldContainerColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r89 = r4
            goto L_0x005b
        L_0x0059:
            r89 = r137
        L_0x005b:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x006c
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r91 = r4
            goto L_0x006e
        L_0x006c:
            r91 = r139
        L_0x006e:
            r2 = r0 & 16
            if (r2 == 0) goto L_0x007f
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorFocusCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r93 = r4
            goto L_0x0081
        L_0x007f:
            r93 = r141
        L_0x0081:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x00a2
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r5 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r6, r7)
            java.lang.Object r6 = r15.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r180)
            r2 = r6
            androidx.compose.foundation.text.selection.TextSelectionColors r2 = (androidx.compose.foundation.text.selection.TextSelectionColors) r2
            r95 = r2
            goto L_0x00a4
        L_0x00a2:
            r95 = r143
        L_0x00a4:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x00b5
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r96 = r4
            goto L_0x00b7
        L_0x00b5:
            r96 = r144
        L_0x00b7:
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00c8
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r98 = r4
            goto L_0x00ca
        L_0x00c8:
            r98 = r146
        L_0x00ca:
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x00f7
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r133 = r4
            r135 = r7
            r136 = r8
            r137 = r9
            r138 = r10
            r139 = r2
            r140 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r133, r135, r136, r137, r138, r139, r140)
            r100 = r4
            goto L_0x00f9
        L_0x00f7:
            r100 = r148
        L_0x00f9:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x010a
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r102 = r4
            goto L_0x010c
        L_0x010a:
            r102 = r150
        L_0x010c:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x011d
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r104 = r4
            goto L_0x011f
        L_0x011d:
            r104 = r152
        L_0x011f:
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0130
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r106 = r4
            goto L_0x0132
        L_0x0130:
            r106 = r154
        L_0x0132:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x015f
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r133 = r4
            r135 = r7
            r136 = r8
            r137 = r9
            r138 = r10
            r139 = r2
            r140 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r133, r135, r136, r137, r138, r139, r140)
            r108 = r4
            goto L_0x0161
        L_0x015f:
            r108 = r156
        L_0x0161:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0172
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r110 = r4
            goto L_0x0174
        L_0x0172:
            r110 = r158
        L_0x0174:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0185
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r112 = r4
            goto L_0x0187
        L_0x0185:
            r112 = r160
        L_0x0187:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x019a
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r114 = r4
            goto L_0x019c
        L_0x019a:
            r114 = r162
        L_0x019c:
            r2 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01ca
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r133 = r4
            r135 = r7
            r136 = r8
            r137 = r9
            r138 = r10
            r139 = r2
            r140 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r133, r135, r136, r137, r138, r139, r140)
            r116 = r4
            goto L_0x01cc
        L_0x01ca:
            r116 = r164
        L_0x01cc:
            r2 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01de
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r118 = r4
            goto L_0x01e0
        L_0x01de:
            r118 = r166
        L_0x01e0:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01f2
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldFocusLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r120 = r4
            goto L_0x01f4
        L_0x01f2:
            r120 = r168
        L_0x01f4:
            r2 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0206
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r122 = r4
            goto L_0x0208
        L_0x0206:
            r122 = r170
        L_0x0208:
            r2 = 1048576(0x100000, float:1.469368E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x021a
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldDisabledLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r124 = r4
            goto L_0x021c
        L_0x021a:
            r124 = r172
        L_0x021c:
            r2 = 2097152(0x200000, float:2.938736E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x022e
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldErrorLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r126 = r4
            goto L_0x0230
        L_0x022e:
            r126 = r174
        L_0x0230:
            r2 = 4194304(0x400000, float:5.877472E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0242
            androidx.compose.material3.tokens.FilledAutocompleteTokens r2 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r128 = r4
            goto L_0x0244
        L_0x0242:
            r128 = r176
        L_0x0244:
            r2 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0272
            androidx.compose.material3.tokens.FilledAutocompleteTokens r0 = androidx.compose.material3.tokens.FilledAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r0 = 14
            r2 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            r133 = r4
            r135 = r6
            r136 = r7
            r137 = r8
            r138 = r9
            r139 = r0
            r140 = r2
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r133, r135, r136, r137, r138, r139, r140)
            r130 = r4
            goto L_0x0274
        L_0x0272:
            r130 = r178
        L_0x0274:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x027f
            java.lang.String r0 = "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:836)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r13, r14, r0)
        L_0x027f:
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r62 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r64 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledSupportingTextColor()
            long r0 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r2 = 14
            r4 = 0
            r5 = 1052938076(0x3ec28f5c, float:0.38)
            r6 = 0
            r7 = 0
            r8 = 0
            r133 = r0
            r135 = r5
            r136 = r6
            r137 = r7
            r138 = r8
            r139 = r2
            r140 = r4
            long r66 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r133, r135, r136, r137, r138, r139, r140)
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r68 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r70 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r72 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledSupportingTextColor()
            long r0 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r133 = r0
            long r74 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r133, r135, r136, r137, r138, r139, r140)
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r76 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r0 = r13 & 14
            int r1 = r13 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r13 << 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r13 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r13 << 6
            r2 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r13 << 9
            r3 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r13 << 12
            r4 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r13 << 15
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r5
            r0 = r0 | r1
            int r1 = r13 << 15
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r6
            r0 = r0 | r1
            int r1 = r13 << 15
            r7 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r7
            r79 = r0 | r1
            int r0 = r13 >> 15
            r0 = r0 & 14
            int r1 = r13 >> 15
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r13 >> 15
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r13 >> 15
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r13 >> 15
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r14 << 15
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r14 << 15
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r14 << 15
            r1 = r1 & r5
            r0 = r0 | r1
            int r1 = r14 << 15
            r1 = r1 & r6
            r0 = r0 | r1
            int r1 = r14 << 15
            r1 = r1 & r7
            r80 = r0 | r1
            int r0 = r14 >> 15
            r0 = r0 & 14
            int r1 = r14 >> 15
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r14 >> 15
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r14 >> 15
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r14 >> 15
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r183 << 15
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r183 << 15
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r183 << 15
            r1 = r1 & r5
            r0 = r0 | r1
            int r1 = r183 << 18
            r1 = r1 & r6
            r0 = r0 | r1
            int r1 = r183 << 18
            r1 = r1 & r7
            r81 = r0 | r1
            int r0 = r183 >> 6
            r0 = r0 & 14
            int r1 = r183 << 15
            r1 = r1 & r7
            r82 = r0 | r1
            r83 = 0
            r84 = 0
            r0 = r132
            r1 = r85
            r3 = r85
            r5 = r87
            r7 = r85
            r9 = r89
            r11 = r89
            r13 = r89
            r15 = r89
            r17 = r91
            r19 = r93
            r21 = r95
            r22 = r96
            r24 = r98
            r26 = r100
            r28 = r102
            r30 = r104
            r32 = r106
            r34 = r108
            r36 = r110
            r38 = r112
            r40 = r114
            r42 = r116
            r44 = r118
            r46 = r120
            r48 = r122
            r50 = r124
            r52 = r126
            r54 = r128
            r56 = r128
            r58 = r130
            r60 = r128
            r78 = r180
            androidx.compose.material3.TextFieldColors r0 = r0.m1766textFieldColorsFD9MK7s(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r79, r80, r81, r82, r83, r84)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x03fa
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03fa:
            r180.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuDefaults.m1767textFieldColorsStqZLY(long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v76, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: outlinedTextFieldColors-St-qZLY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ androidx.compose.material3.TextFieldColors m1764outlinedTextFieldColorsStqZLY(long r133, long r135, long r137, long r139, long r141, androidx.compose.foundation.text.selection.TextSelectionColors r143, long r144, long r146, long r148, long r150, long r152, long r154, long r156, long r158, long r160, long r162, long r164, long r166, long r168, long r170, long r172, long r174, long r176, long r178, androidx.compose.runtime.Composer r180, int r181, int r182, int r183, int r184) {
        /*
            r132 = this;
            r15 = r180
            r13 = r181
            r14 = r182
            r0 = r184
            r1 = -83147315(0xfffffffffb0b45cd, float:-7.23145E35)
            r15.startReplaceableGroup(r1)
            java.lang.String r2 = "C(outlinedTextFieldColors)P(19:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,18,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,22:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,16:c#ui.graphics.Color,23:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)926@54404L9,927@54505L9,930@54727L9,932@54841L9,933@54924L7,934@55023L9,935@55121L9,937@55238L9,939@55427L9,941@55549L9,943@55668L9,945@55794L9,948@56008L9,950@56132L9,952@56253L9,954@56381L9,957@56598L9,958@56696L9,959@56791L9,960@56893L9,962@57073L9,963@57170L9,965@57290L9,999@59085L9,1000@59179L9,1001@59280L9,1003@59459L9,1004@59551L9,1005@59645L9,1006@59746L9,1008@59925L9,967@57413L2528:ExposedDropdownMenu.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r0 & 1
            r3 = 6
            if (r2 == 0) goto L_0x0025
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r85 = r4
            goto L_0x0027
        L_0x0025:
            r85 = r133
        L_0x0027:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0046
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldDisabledInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r10 = 14
            r11 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r4, r6, r7, r8, r9, r10, r11)
            r87 = r4
            goto L_0x0048
        L_0x0046:
            r87 = r135
        L_0x0048:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0055
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r4 = r2.m3288getTransparent0d7_KjU()
            r89 = r4
            goto L_0x0057
        L_0x0055:
            r89 = r137
        L_0x0057:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x0068
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r91 = r4
            goto L_0x006a
        L_0x0068:
            r91 = r139
        L_0x006a:
            r2 = r0 & 16
            if (r2 == 0) goto L_0x007b
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorFocusCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r93 = r4
            goto L_0x007d
        L_0x007b:
            r93 = r141
        L_0x007d:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x009e
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r5 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r6, r7)
            java.lang.Object r6 = r15.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r180)
            r2 = r6
            androidx.compose.foundation.text.selection.TextSelectionColors r2 = (androidx.compose.foundation.text.selection.TextSelectionColors) r2
            r95 = r2
            goto L_0x00a0
        L_0x009e:
            r95 = r143
        L_0x00a0:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x00b1
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r96 = r4
            goto L_0x00b3
        L_0x00b1:
            r96 = r144
        L_0x00b3:
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00c4
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r98 = r4
            goto L_0x00c6
        L_0x00c4:
            r98 = r146
        L_0x00c6:
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x00f3
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1039516303(0x3df5c28f, float:0.12)
            r8 = 0
            r9 = 0
            r10 = 0
            r133 = r4
            r135 = r7
            r136 = r8
            r137 = r9
            r138 = r10
            r139 = r2
            r140 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r133, r135, r136, r137, r138, r139, r140)
            r100 = r4
            goto L_0x00f5
        L_0x00f3:
            r100 = r148
        L_0x00f5:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0106
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r102 = r4
            goto L_0x0108
        L_0x0106:
            r102 = r150
        L_0x0108:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0119
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r104 = r4
            goto L_0x011b
        L_0x0119:
            r104 = r152
        L_0x011b:
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x012c
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r106 = r4
            goto L_0x012e
        L_0x012c:
            r106 = r154
        L_0x012e:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x015b
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r133 = r4
            r135 = r7
            r136 = r8
            r137 = r9
            r138 = r10
            r139 = r2
            r140 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r133, r135, r136, r137, r138, r139, r140)
            r108 = r4
            goto L_0x015d
        L_0x015b:
            r108 = r156
        L_0x015d:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x016e
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r110 = r4
            goto L_0x0170
        L_0x016e:
            r110 = r158
        L_0x0170:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0181
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldFocusTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r112 = r4
            goto L_0x0183
        L_0x0181:
            r112 = r160
        L_0x0183:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0196
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r114 = r4
            goto L_0x0198
        L_0x0196:
            r114 = r162
        L_0x0198:
            r2 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01c6
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldDisabledTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r133 = r4
            r135 = r7
            r136 = r8
            r137 = r9
            r138 = r10
            r139 = r2
            r140 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r133, r135, r136, r137, r138, r139, r140)
            r116 = r4
            goto L_0x01c8
        L_0x01c6:
            r116 = r164
        L_0x01c8:
            r2 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01da
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTextFieldErrorTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r118 = r4
            goto L_0x01dc
        L_0x01da:
            r118 = r166
        L_0x01dc:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01ee
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldFocusLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r120 = r4
            goto L_0x01f0
        L_0x01ee:
            r120 = r168
        L_0x01f0:
            r2 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0202
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r122 = r4
            goto L_0x0204
        L_0x0202:
            r122 = r170
        L_0x0204:
            r2 = 1048576(0x100000, float:1.469368E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0232
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldDisabledLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r133 = r4
            r135 = r7
            r136 = r8
            r137 = r9
            r138 = r10
            r139 = r2
            r140 = r6
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r133, r135, r136, r137, r138, r139, r140)
            r124 = r4
            goto L_0x0234
        L_0x0232:
            r124 = r172
        L_0x0234:
            r2 = 2097152(0x200000, float:2.938736E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0246
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldErrorLabelTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r126 = r4
            goto L_0x0248
        L_0x0246:
            r126 = r174
        L_0x0248:
            r2 = 4194304(0x400000, float:5.877472E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x025a
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r2 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFieldSupportingTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r128 = r4
            goto L_0x025c
        L_0x025a:
            r128 = r176
        L_0x025c:
            r2 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x028a
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledInputTextColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r0 = 14
            r2 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            r133 = r4
            r135 = r6
            r136 = r7
            r137 = r8
            r138 = r9
            r139 = r0
            r140 = r2
            long r4 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r133, r135, r136, r137, r138, r139, r140)
            r130 = r4
            goto L_0x028c
        L_0x028a:
            r130 = r178
        L_0x028c:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0297
            java.lang.String r0 = "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:925)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r13, r14, r0)
        L_0x0297:
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r62 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r64 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledSupportingTextColor()
            long r0 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r2 = 14
            r4 = 0
            r5 = 1052938076(0x3ec28f5c, float:0.38)
            r6 = 0
            r7 = 0
            r8 = 0
            r133 = r0
            r135 = r5
            r136 = r6
            r137 = r7
            r138 = r8
            r139 = r2
            r140 = r4
            long r66 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r133, r135, r136, r137, r138, r139, r140)
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r68 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r70 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r72 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldDisabledSupportingTextColor()
            long r0 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r133 = r0
            long r74 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r133, r135, r136, r137, r138, r139, r140)
            androidx.compose.material3.tokens.OutlinedAutocompleteTokens r0 = androidx.compose.material3.tokens.OutlinedAutocompleteTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getFieldSupportingTextColor()
            long r76 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r0 = r13 & 14
            int r1 = r13 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r13 << 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r13 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r13 << 6
            r2 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r13 << 9
            r3 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r13 << 12
            r4 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r13 << 15
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r5
            r0 = r0 | r1
            int r1 = r13 << 15
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r6
            r0 = r0 | r1
            int r1 = r13 << 15
            r7 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r7
            r79 = r0 | r1
            int r0 = r13 >> 15
            r0 = r0 & 14
            int r1 = r13 >> 15
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r13 >> 15
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r13 >> 15
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r13 >> 15
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r14 << 15
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r14 << 15
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r14 << 15
            r1 = r1 & r5
            r0 = r0 | r1
            int r1 = r14 << 15
            r1 = r1 & r6
            r0 = r0 | r1
            int r1 = r14 << 15
            r1 = r1 & r7
            r80 = r0 | r1
            int r0 = r14 >> 15
            r0 = r0 & 14
            int r1 = r14 >> 15
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r14 >> 15
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r14 >> 15
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r14 >> 15
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r183 << 15
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r183 << 15
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r183 << 15
            r1 = r1 & r5
            r0 = r0 | r1
            int r1 = r183 << 18
            r1 = r1 & r6
            r0 = r0 | r1
            int r1 = r183 << 18
            r1 = r1 & r7
            r81 = r0 | r1
            int r0 = r183 >> 6
            r0 = r0 & 14
            int r1 = r183 << 15
            r1 = r1 & r7
            r82 = r0 | r1
            r83 = 0
            r84 = 0
            r0 = r132
            r1 = r85
            r3 = r85
            r5 = r87
            r7 = r85
            r9 = r89
            r11 = r89
            r13 = r89
            r15 = r89
            r17 = r91
            r19 = r93
            r21 = r95
            r22 = r96
            r24 = r98
            r26 = r100
            r28 = r102
            r30 = r104
            r32 = r106
            r34 = r108
            r36 = r110
            r38 = r112
            r40 = r114
            r42 = r116
            r44 = r118
            r46 = r120
            r48 = r122
            r50 = r124
            r52 = r126
            r54 = r128
            r56 = r128
            r58 = r130
            r60 = r128
            r78 = r180
            androidx.compose.material3.TextFieldColors r0 = r0.m1763outlinedTextFieldColorsFD9MK7s(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r79, r80, r81, r82, r83, r84)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0412
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0412:
            r180.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuDefaults.m1764outlinedTextFieldColorsStqZLY(long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }
}

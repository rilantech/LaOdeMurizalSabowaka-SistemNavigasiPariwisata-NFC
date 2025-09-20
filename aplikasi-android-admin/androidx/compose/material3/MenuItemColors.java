package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B:\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013J \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/MenuItemColors;", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "hashCode", "", "Landroidx/compose/runtime/State;", "enabled", "leadingIconColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "textColor$material3_release", "trailingIconColor$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Menu.kt */
public final class MenuItemColors {
    public static final int $stable = 0;
    private final long disabledLeadingIconColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long leadingIconColor;
    private final long textColor;
    private final long trailingIconColor;

    public /* synthetic */ MenuItemColors(long j, long j2, long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6);
    }

    private MenuItemColors(long textColor2, long leadingIconColor2, long trailingIconColor2, long disabledTextColor2, long disabledLeadingIconColor2, long disabledTrailingIconColor2) {
        this.textColor = textColor2;
        this.leadingIconColor = leadingIconColor2;
        this.trailingIconColor = trailingIconColor2;
        this.disabledTextColor = disabledTextColor2;
        this.disabledLeadingIconColor = disabledLeadingIconColor2;
        this.disabledTrailingIconColor = disabledTrailingIconColor2;
    }

    public final State<Color> textColor$material3_release(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1023108655);
        ComposerKt.sourceInformation($composer, "C(textColor)384@14802L67:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1023108655, $changed, -1, "androidx.compose.material3.MenuItemColors.textColor (Menu.kt:383)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4953boximpl(enabled ? this.textColor : this.disabledTextColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> leadingIconColor$material3_release(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1521013607);
        ComposerKt.sourceInformation($composer, "C(leadingIconColor)394@15146L81:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1521013607, $changed, -1, "androidx.compose.material3.MenuItemColors.leadingIconColor (Menu.kt:393)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4953boximpl(enabled ? this.leadingIconColor : this.disabledLeadingIconColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> trailingIconColor$material3_release(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1024062809);
        ComposerKt.sourceInformation($composer, "C(trailingIconColor)404@15506L83:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1024062809, $changed, -1, "androidx.compose.material3.MenuItemColors.trailingIconColor (Menu.kt:403)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4953boximpl(enabled ? this.trailingIconColor : this.disabledTrailingIconColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof MenuItemColors) || !Color.m4964equalsimpl0(this.textColor, ((MenuItemColors) other).textColor) || !Color.m4964equalsimpl0(this.leadingIconColor, ((MenuItemColors) other).leadingIconColor) || !Color.m4964equalsimpl0(this.trailingIconColor, ((MenuItemColors) other).trailingIconColor) || !Color.m4964equalsimpl0(this.disabledTextColor, ((MenuItemColors) other).disabledTextColor) || !Color.m4964equalsimpl0(this.disabledLeadingIconColor, ((MenuItemColors) other).disabledLeadingIconColor) || !Color.m4964equalsimpl0(this.disabledTrailingIconColor, ((MenuItemColors) other).disabledTrailingIconColor)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((Color.m4970hashCodeimpl(this.textColor) * 31) + Color.m4970hashCodeimpl(this.leadingIconColor)) * 31) + Color.m4970hashCodeimpl(this.trailingIconColor)) * 31) + Color.m4970hashCodeimpl(this.disabledTextColor)) * 31) + Color.m4970hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m4970hashCodeimpl(this.disabledTrailingIconColor);
    }
}

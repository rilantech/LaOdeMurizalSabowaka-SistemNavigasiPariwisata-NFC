package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B:\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\tJ(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0010J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/IconToggleButtonColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "checkedContainerColor", "checkedContentColor", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "checked", "containerColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "contentColor$material3_release", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IconButton.kt */
public final class IconToggleButtonColors {
    public static final int $stable = 0;
    private final long checkedContainerColor;
    private final long checkedContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;

    public /* synthetic */ IconToggleButtonColors(long j, long j2, long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6);
    }

    private IconToggleButtonColors(long containerColor2, long contentColor2, long disabledContainerColor2, long disabledContentColor2, long checkedContainerColor2, long checkedContentColor2) {
        this.containerColor = containerColor2;
        this.contentColor = contentColor2;
        this.disabledContainerColor = disabledContainerColor2;
        this.disabledContentColor = disabledContentColor2;
        this.checkedContainerColor = checkedContainerColor2;
        this.checkedContentColor = checkedContentColor2;
    }

    public final State<Color> containerColor$material3_release(boolean enabled, boolean checked, Composer $composer, int $changed) {
        long target;
        $composer.startReplaceableGroup(1175394478);
        ComposerKt.sourceInformation($composer, "C(containerColor)P(1)890@42424L28:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1175394478, $changed, -1, "androidx.compose.material3.IconToggleButtonColors.containerColor (IconButton.kt:884)");
        }
        if (!enabled) {
            target = this.disabledContainerColor;
        } else if (!checked) {
            target = this.containerColor;
        } else {
            target = this.checkedContainerColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4953boximpl(target), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> contentColor$material3_release(boolean enabled, boolean checked, Composer $composer, int $changed) {
        long target;
        $composer.startReplaceableGroup(1340854054);
        ComposerKt.sourceInformation($composer, "C(contentColor)P(1)906@42966L28:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1340854054, $changed, -1, "androidx.compose.material3.IconToggleButtonColors.contentColor (IconButton.kt:900)");
        }
        if (!enabled) {
            target = this.disabledContentColor;
        } else if (!checked) {
            target = this.contentColor;
        } else {
            target = this.checkedContentColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4953boximpl(target), $composer, 0);
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
        if (other == null || !(other instanceof IconToggleButtonColors) || !Color.m4964equalsimpl0(this.containerColor, ((IconToggleButtonColors) other).containerColor) || !Color.m4964equalsimpl0(this.contentColor, ((IconToggleButtonColors) other).contentColor) || !Color.m4964equalsimpl0(this.disabledContainerColor, ((IconToggleButtonColors) other).disabledContainerColor) || !Color.m4964equalsimpl0(this.disabledContentColor, ((IconToggleButtonColors) other).disabledContentColor) || !Color.m4964equalsimpl0(this.checkedContainerColor, ((IconToggleButtonColors) other).checkedContainerColor) || !Color.m4964equalsimpl0(this.checkedContentColor, ((IconToggleButtonColors) other).checkedContentColor)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((Color.m4970hashCodeimpl(this.containerColor) * 31) + Color.m4970hashCodeimpl(this.contentColor)) * 31) + Color.m4970hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m4970hashCodeimpl(this.disabledContentColor)) * 31) + Color.m4970hashCodeimpl(this.checkedContainerColor)) * 31) + Color.m4970hashCodeimpl(this.checkedContentColor);
    }
}

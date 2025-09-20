package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B:\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\bø\u0001\u0000¢\u0006\u0002\u0010\nJ'\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u0019\u0010\t\u001a\u00020\bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/SelectableChipBorder;", "", "borderColor", "Landroidx/compose/ui/graphics/Color;", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "Landroidx/compose/ui/unit/Dp;", "selectedBorderWidth", "(JJJJFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "F", "borderStroke", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "selected", "borderStroke$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class SelectableChipBorder {
    public static final int $stable = 0;
    private final long borderColor;
    private final float borderWidth;
    private final long disabledBorderColor;
    private final long disabledSelectedBorderColor;
    private final long selectedBorderColor;
    private final float selectedBorderWidth;

    public /* synthetic */ SelectableChipBorder(long j, long j2, long j3, long j4, float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, f, f2);
    }

    private SelectableChipBorder(long borderColor2, long selectedBorderColor2, long disabledBorderColor2, long disabledSelectedBorderColor2, float borderWidth2, float selectedBorderWidth2) {
        this.borderColor = borderColor2;
        this.selectedBorderColor = selectedBorderColor2;
        this.disabledBorderColor = disabledBorderColor2;
        this.disabledSelectedBorderColor = disabledSelectedBorderColor2;
        this.borderWidth = borderWidth2;
        this.selectedBorderWidth = selectedBorderWidth2;
    }

    public final State<BorderStroke> borderStroke$material3_release(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long color;
        $composer.startReplaceableGroup(670222826);
        ComposerKt.sourceInformation($composer, "C(borderStroke)1999@92578L115:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(670222826, $changed, -1, "androidx.compose.material3.SelectableChipBorder.borderStroke (Chip.kt:1993)");
        }
        if (enabled) {
            color = selected ? this.selectedBorderColor : this.borderColor;
        } else {
            color = selected ? this.disabledSelectedBorderColor : this.disabledBorderColor;
        }
        State<BorderStroke> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(BorderStrokeKt.m194BorderStrokecXLIe8U(selected ? this.selectedBorderWidth : this.borderWidth, color), $composer, 0);
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
        if (other == null || !(other instanceof SelectableChipBorder) || !Color.m3254equalsimpl0(this.borderColor, ((SelectableChipBorder) other).borderColor) || !Color.m3254equalsimpl0(this.selectedBorderColor, ((SelectableChipBorder) other).selectedBorderColor) || !Color.m3254equalsimpl0(this.disabledBorderColor, ((SelectableChipBorder) other).disabledBorderColor) || !Color.m3254equalsimpl0(this.disabledSelectedBorderColor, ((SelectableChipBorder) other).disabledSelectedBorderColor) || !Dp.m5849equalsimpl0(this.borderWidth, ((SelectableChipBorder) other).borderWidth) || !Dp.m5849equalsimpl0(this.selectedBorderWidth, ((SelectableChipBorder) other).selectedBorderWidth)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((Color.m3260hashCodeimpl(this.borderColor) * 31) + Color.m3260hashCodeimpl(this.selectedBorderColor)) * 31) + Color.m3260hashCodeimpl(this.disabledBorderColor)) * 31) + Color.m3260hashCodeimpl(this.disabledSelectedBorderColor)) * 31) + Dp.m5850hashCodeimpl(this.borderWidth)) * 31) + Dp.m5850hashCodeimpl(this.selectedBorderWidth);
    }
}

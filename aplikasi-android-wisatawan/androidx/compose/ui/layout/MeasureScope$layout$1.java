package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"androidx/compose/ui/layout/MeasureScope$layout$1", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "width", "getWidth", "placeChildren", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MeasureScope.kt */
public final class MeasureScope$layout$1 implements MeasureResult {
    final /* synthetic */ Function1<Placeable.PlacementScope, Unit> $placementBlock;
    final /* synthetic */ int $width;
    private final Map<AlignmentLine, Integer> alignmentLines;
    private final int height;
    final /* synthetic */ MeasureScope this$0;
    private final int width;

    MeasureScope$layout$1(int $width2, int $height, Map<AlignmentLine, Integer> $alignmentLines, MeasureScope $receiver, Function1<? super Placeable.PlacementScope, Unit> $placementBlock2) {
        this.$width = $width2;
        this.this$0 = $receiver;
        this.$placementBlock = $placementBlock2;
        this.width = $width2;
        this.height = $height;
        this.alignmentLines = $alignmentLines;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.alignmentLines;
    }

    public void placeChildren() {
        Placeable.PlacementScope.Companion this_$iv = Placeable.PlacementScope.Companion;
        int parentWidth$iv = this.$width;
        LayoutDirection parentLayoutDirection$iv = this.this$0.getLayoutDirection();
        MeasureScope measureScope = this.this$0;
        LookaheadCapablePlaceable lookaheadCapablePlaceable$iv = measureScope instanceof LookaheadCapablePlaceable ? (LookaheadCapablePlaceable) measureScope : null;
        Function1 block$iv = this.$placementBlock;
        LayoutCoordinates previousLayoutCoordinates$iv = Placeable.PlacementScope._coordinates;
        int previousParentWidth$iv = Placeable.PlacementScope.Companion.getParentWidth();
        LayoutDirection previousParentLayoutDirection$iv = Placeable.PlacementScope.Companion.getParentLayoutDirection();
        LayoutNodeLayoutDelegate previousLayoutDelegate$iv = Placeable.PlacementScope.layoutDelegate;
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentWidth = parentWidth$iv;
        Placeable.PlacementScope.Companion companion2 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection$iv;
        boolean wasPlacingForAlignment$iv = this_$iv.configureForPlacingForAlignment(lookaheadCapablePlaceable$iv);
        block$iv.invoke(this_$iv);
        if (lookaheadCapablePlaceable$iv != null) {
            lookaheadCapablePlaceable$iv.setPlacingForAlignment$ui_release(wasPlacingForAlignment$iv);
        }
        Placeable.PlacementScope.Companion companion3 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentWidth = previousParentWidth$iv;
        Placeable.PlacementScope.Companion companion4 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentLayoutDirection = previousParentLayoutDirection$iv;
        Placeable.PlacementScope._coordinates = previousLayoutCoordinates$iv;
        Placeable.PlacementScope.layoutDelegate = previousLayoutDelegate$iv;
    }
}

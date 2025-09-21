package androidx.compose.ui.layout;

import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"androidx/compose/ui/layout/LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure$1", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "width", "getWidth", "placeChildren", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
public final class LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure$1 implements MeasureResult {
    final /* synthetic */ int $indexAfterMeasure;
    final /* synthetic */ MeasureResult $result;
    final /* synthetic */ LayoutNodeSubcompositionsState this$0;

    LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure$1(MeasureResult $result2, LayoutNodeSubcompositionsState $receiver, int $indexAfterMeasure2) {
        this.$result = $result2;
        this.this$0 = $receiver;
        this.$indexAfterMeasure = $indexAfterMeasure2;
    }

    public int getWidth() {
        return this.$result.getWidth();
    }

    public int getHeight() {
        return this.$result.getHeight();
    }

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$result.getAlignmentLines();
    }

    public void placeChildren() {
        this.this$0.currentIndex = this.$indexAfterMeasure;
        this.$result.placeChildren();
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.this$0;
        layoutNodeSubcompositionsState.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState.currentIndex);
    }
}

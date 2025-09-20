package androidx.compose.ui.viewinterop;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\"\u0010\u0007\u001a\u00020\u0003*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010\f\u001a\u00020\u0003*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J/\u0010\r\u001a\u00020\u000e*\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0015\u001a\u00020\u0003*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010\u0016\u001a\u00020\u0003*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"androidx/compose/ui/viewinterop/AndroidViewHolder$layoutNode$1$5", "Landroidx/compose/ui/layout/MeasurePolicy;", "intrinsicHeight", "", "width", "intrinsicWidth", "height", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidViewHolder.android.kt */
public final class AndroidViewHolder$layoutNode$1$5 implements MeasurePolicy {
    final /* synthetic */ LayoutNode $layoutNode;
    final /* synthetic */ AndroidViewHolder $this_run;

    AndroidViewHolder$layoutNode$1$5(AndroidViewHolder $receiver, LayoutNode $layoutNode2) {
        this.$this_run = $receiver;
        this.$layoutNode = $layoutNode2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m7791measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        if (this.$this_run.getChildCount() == 0) {
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, Constraints.m7500getMinWidthimpl(constraints), Constraints.m7499getMinHeightimpl(constraints), (Map) null, AndroidViewHolder$layoutNode$1$5$measure$1.INSTANCE, 4, (Object) null);
        }
        if (Constraints.m7500getMinWidthimpl(constraints) != 0) {
            this.$this_run.getChildAt(0).setMinimumWidth(Constraints.m7500getMinWidthimpl(constraints));
        }
        if (Constraints.m7499getMinHeightimpl(constraints) != 0) {
            this.$this_run.getChildAt(0).setMinimumHeight(Constraints.m7499getMinHeightimpl(constraints));
        }
        AndroidViewHolder androidViewHolder = this.$this_run;
        int r1 = Constraints.m7500getMinWidthimpl(constraints);
        int r2 = Constraints.m7498getMaxWidthimpl(constraints);
        ViewGroup.LayoutParams layoutParams = this.$this_run.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams);
        int access$obtainMeasureSpec = androidViewHolder.obtainMeasureSpec(r1, r2, layoutParams.width);
        AndroidViewHolder androidViewHolder2 = this.$this_run;
        int r3 = Constraints.m7499getMinHeightimpl(constraints);
        int r4 = Constraints.m7497getMaxHeightimpl(constraints);
        ViewGroup.LayoutParams layoutParams2 = this.$this_run.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2);
        androidViewHolder.measure(access$obtainMeasureSpec, androidViewHolder2.obtainMeasureSpec(r3, r4, layoutParams2.height));
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, this.$this_run.getMeasuredWidth(), this.$this_run.getMeasuredHeight(), (Map) null, new AndroidViewHolder$layoutNode$1$5$measure$2(this.$this_run, this.$layoutNode), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(height);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(height);
    }

    private final int intrinsicWidth(int height) {
        AndroidViewHolder androidViewHolder = this.$this_run;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        AndroidViewHolder androidViewHolder2 = this.$this_run;
        ViewGroup.LayoutParams layoutParams = androidViewHolder2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams);
        androidViewHolder.measure(makeMeasureSpec, androidViewHolder2.obtainMeasureSpec(0, height, layoutParams.height));
        return this.$this_run.getMeasuredWidth();
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight(width);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight(width);
    }

    private final int intrinsicHeight(int width) {
        AndroidViewHolder androidViewHolder = this.$this_run;
        ViewGroup.LayoutParams layoutParams = androidViewHolder.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams);
        androidViewHolder.measure(androidViewHolder.obtainMeasureSpec(0, width, layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.$this_run.getMeasuredHeight();
    }
}

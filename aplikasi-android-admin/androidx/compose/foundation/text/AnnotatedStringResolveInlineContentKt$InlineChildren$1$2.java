package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "children", "", "Landroidx/compose/ui/layout/Measurable;", "constrains", "Landroidx/compose/ui/unit/Constraints;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnnotatedStringResolveInlineContent.kt */
final class AnnotatedStringResolveInlineContentKt$InlineChildren$1$2 implements MeasurePolicy {
    public static final AnnotatedStringResolveInlineContentKt$InlineChildren$1$2 INSTANCE = new AnnotatedStringResolveInlineContentKt$InlineChildren$1$2();

    AnnotatedStringResolveInlineContentKt$InlineChildren$1$2() {
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2586measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> children, long constrains) {
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(children, "children");
        List list = children;
        List target$iv = new ArrayList(list.size());
        List $this$fastForEach$iv$iv = list;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            Object obj = it$iv;
            target$iv.add(((Measurable) it$iv).m6399measureBRTryo0(constrains));
            index$iv$iv++;
            MeasureScope measureScope = $this$Layout;
        }
        long j = constrains;
        return MeasureScope.layout$default($this$Layout, Constraints.m7498getMaxWidthimpl(constrains), Constraints.m7497getMaxHeightimpl(constrains), (Map) null, new AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$measure$1(target$iv), 4, (Object) null);
    }
}

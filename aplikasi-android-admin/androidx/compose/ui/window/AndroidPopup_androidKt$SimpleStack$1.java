package androidx.compose.ui.window;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
public final class AndroidPopup_androidKt$SimpleStack$1 implements MeasurePolicy {
    public static final AndroidPopup_androidKt$SimpleStack$1 INSTANCE = new AndroidPopup_androidKt$SimpleStack$1();

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m7799measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        List<? extends Measurable> list = measurables;
        long j = constraints;
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        switch (measurables.size()) {
            case 0:
                return MeasureScope.layout$default($this$Layout, 0, 0, (Map) null, AndroidPopup_androidKt$SimpleStack$1$measure$1.INSTANCE, 4, (Object) null);
            case 1:
                Placeable p = ((Measurable) list.get(0)).m6399measureBRTryo0(j);
                return MeasureScope.layout$default($this$Layout, p.getWidth(), p.getHeight(), (Map) null, new AndroidPopup_androidKt$SimpleStack$1$measure$2(p), 4, (Object) null);
            default:
                List list2 = measurables;
                List target$iv = new ArrayList(list2.size());
                List $this$fastForEach$iv$iv = list2;
                int size = $this$fastForEach$iv$iv.size();
                for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                    target$iv.add(((Measurable) $this$fastForEach$iv$iv.get(index$iv$iv)).m6399measureBRTryo0(j));
                }
                List placeables = target$iv;
                int width = 0;
                int height = 0;
                int i = 0;
                int lastIndex = CollectionsKt.getLastIndex(placeables);
                if (0 <= lastIndex) {
                    while (true) {
                        Placeable p2 = (Placeable) placeables.get(i);
                        width = Math.max(width, p2.getWidth());
                        height = Math.max(height, p2.getHeight());
                        if (i != lastIndex) {
                            i++;
                        }
                    }
                }
                int width2 = width;
                int height2 = height;
                return MeasureScope.layout$default($this$Layout, width2, height2, (Map) null, new AndroidPopup_androidKt$SimpleStack$1$measure$3(placeables), 4, (Object) null);
        }
    }
}

package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.AnnotatedString;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00050\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$AnnotationRangeListSaver$1 extends Lambda implements Function2<SaverScope, List<? extends AnnotatedString.Range<? extends Object>>, Object> {
    public static final SaversKt$AnnotationRangeListSaver$1 INSTANCE = new SaversKt$AnnotationRangeListSaver$1();

    SaversKt$AnnotationRangeListSaver$1() {
        super(2);
    }

    public final Object invoke(SaverScope $this$Saver, List<? extends AnnotatedString.Range<? extends Object>> it) {
        SaverScope saverScope = $this$Saver;
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        Intrinsics.checkNotNullParameter(it, "it");
        List list = it;
        List target$iv = new ArrayList(list.size());
        List $this$fastForEach$iv$iv = list;
        int size = $this$fastForEach$iv$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            target$iv.add(SaversKt.save((AnnotatedString.Range) $this$fastForEach$iv$iv.get(index$iv$iv), SaversKt.AnnotationRangeSaver, saverScope));
        }
        return target$iv;
    }
}

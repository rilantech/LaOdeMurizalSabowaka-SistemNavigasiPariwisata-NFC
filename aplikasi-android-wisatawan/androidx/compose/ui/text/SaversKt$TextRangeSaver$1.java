package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/text/TextRange;", "invoke-FDrldGo", "(Landroidx/compose/runtime/saveable/SaverScope;J)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$TextRangeSaver$1 extends Lambda implements Function2<SaverScope, TextRange, Object> {
    public static final SaversKt$TextRangeSaver$1 INSTANCE = new SaversKt$TextRangeSaver$1();

    SaversKt$TextRangeSaver$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m5270invokeFDrldGo((SaverScope) p1, ((TextRange) p2).m5329unboximpl());
    }

    /* renamed from: invoke-FDrldGo  reason: not valid java name */
    public final Object m5270invokeFDrldGo(SaverScope $this$Saver, long it) {
        Intrinsics.checkNotNullParameter($this$Saver, "$this$Saver");
        return CollectionsKt.arrayListOf(SaversKt.save(Integer.valueOf(TextRange.m5325getStartimpl(it))), SaversKt.save(Integer.valueOf(TextRange.m5320getEndimpl(it))));
    }
}

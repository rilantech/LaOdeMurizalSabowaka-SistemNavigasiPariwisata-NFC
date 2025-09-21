package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.style.BaselineShift;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/text/style/BaselineShift;", "invoke-8a2Sb4w", "(Landroidx/compose/runtime/saveable/SaverScope;F)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$BaselineShiftSaver$1 extends Lambda implements Function2<SaverScope, BaselineShift, Object> {
    public static final SaversKt$BaselineShiftSaver$1 INSTANCE = new SaversKt$BaselineShiftSaver$1();

    SaversKt$BaselineShiftSaver$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m5264invoke8a2Sb4w((SaverScope) p1, ((BaselineShift) p2).m5605unboximpl());
    }

    /* renamed from: invoke-8a2Sb4w  reason: not valid java name */
    public final Object m5264invoke8a2Sb4w(SaverScope $this$Saver, float it) {
        Intrinsics.checkNotNullParameter($this$Saver, "$this$Saver");
        return Float.valueOf(it);
    }
}

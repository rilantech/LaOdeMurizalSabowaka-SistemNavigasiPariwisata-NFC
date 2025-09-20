package androidx.compose.material3;

import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/material3/StateData;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class StateData$Companion$Saver$1 extends Lambda implements Function2<SaverScope, StateData, List<? extends Object>> {
    public static final StateData$Companion$Saver$1 INSTANCE = new StateData$Companion$Saver$1();

    StateData$Companion$Saver$1() {
        super(2);
    }

    public final List<Object> invoke(SaverScope $this$listSaver, StateData it) {
        Intrinsics.checkNotNullParameter($this$listSaver, "$this$listSaver");
        Intrinsics.checkNotNullParameter(it, "it");
        Object[] objArr = new Object[6];
        CalendarDate value = it.getSelectedStartDate().getValue();
        Long l = null;
        objArr[0] = value != null ? Long.valueOf(value.getUtcTimeMillis()) : null;
        CalendarDate value2 = it.getSelectedEndDate().getValue();
        if (value2 != null) {
            l = Long.valueOf(value2.getUtcTimeMillis());
        }
        objArr[1] = l;
        objArr[2] = Long.valueOf(it.getDisplayedMonth().getStartUtcTimeMillis());
        objArr[3] = Integer.valueOf(it.getYearRange().getFirst());
        objArr[4] = Integer.valueOf(it.getYearRange().getLast());
        objArr[5] = Integer.valueOf(it.getDisplayMode().getValue().m1737unboximpl());
        return CollectionsKt.listOf(objArr);
    }
}

package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"androidx/compose/runtime/SnapshotDoubleStateKt__SnapshotDoubleStateKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotDoubleState.kt */
public final class SnapshotDoubleStateKt {
    public static final double getValue(DoubleState $this$getValue, Object thisObj, KProperty<?> property) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.getValue($this$getValue, thisObj, property);
    }

    public static final MutableDoubleState mutableDoubleStateOf(double value) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.mutableDoubleStateOf(value);
    }

    public static final void setValue(MutableDoubleState $this$setValue, Object thisObj, KProperty<?> property, double value) {
        SnapshotDoubleStateKt__SnapshotDoubleStateKt.setValue($this$setValue, thisObj, property, value);
    }
}

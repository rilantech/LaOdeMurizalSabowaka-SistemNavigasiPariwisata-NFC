package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"androidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotIntState.kt */
public final class SnapshotIntStateKt {
    public static final int getValue(IntState $this$getValue, Object thisObj, KProperty<?> property) {
        return SnapshotIntStateKt__SnapshotIntStateKt.getValue($this$getValue, thisObj, property);
    }

    public static final MutableIntState mutableIntStateOf(int value) {
        return SnapshotIntStateKt__SnapshotIntStateKt.mutableIntStateOf(value);
    }

    public static final void setValue(MutableIntState $this$setValue, Object thisObj, KProperty<?> property, int value) {
        SnapshotIntStateKt__SnapshotIntStateKt.setValue($this$setValue, thisObj, property, value);
    }
}

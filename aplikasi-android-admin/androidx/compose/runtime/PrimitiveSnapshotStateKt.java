package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"androidx/compose/runtime/PrimitiveSnapshotStateKt__SnapshotFloatStateKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotFloatState.kt */
public final class PrimitiveSnapshotStateKt {
    public static final float getValue(FloatState $this$getValue, Object thisObj, KProperty<?> property) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.getValue($this$getValue, thisObj, property);
    }

    public static final MutableFloatState mutableFloatStateOf(float value) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.mutableFloatStateOf(value);
    }

    public static final void setValue(MutableFloatState $this$setValue, Object thisObj, KProperty<?> property, float value) {
        PrimitiveSnapshotStateKt__SnapshotFloatStateKt.setValue($this$setValue, thisObj, property, value);
    }
}

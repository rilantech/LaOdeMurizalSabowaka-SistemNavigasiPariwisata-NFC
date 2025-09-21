package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\bg\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0018\u0010\u0004\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038W@WX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\bø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/MutableIntState;", "Landroidx/compose/runtime/IntState;", "Landroidx/compose/runtime/MutableState;", "", "intValue", "getIntValue", "()I", "setIntValue", "(I)V", "value", "getValue", "()Ljava/lang/Integer;", "setValue", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotIntState.kt */
public interface MutableIntState extends IntState, MutableState<Integer> {
    int getIntValue();

    void setIntValue(int i);

    /* bridge */ /* synthetic */ void setValue(Object obj) {
        setValue(((Number) obj).intValue());
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnapshotIntState.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static Integer getValue(MutableIntState $this) {
            return Integer.valueOf(MutableIntState.super.getValue().intValue());
        }

        @Deprecated
        public static void setValue(MutableIntState $this, int value) {
            MutableIntState.super.setValue(value);
        }
    }

    Integer getValue() {
        return Integer.valueOf(getIntValue());
    }

    void setValue(int value) {
        setIntValue(value);
    }
}

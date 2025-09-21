package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\tJ&\u0010\u0014\u001a\u00020\u00152\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00150\u0017H\bø\u0001\u0000J\u0012\u0010\u0018\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\"\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\tH\u0002J&\u0010\u001c\u001a\u00020\u001d2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001d0\u0017H\bø\u0001\u0000J\u0011\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0001H\u0002J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0001J&\u0010!\u001a\u00020\u001d2\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00150\u0017H\bø\u0001\u0000R0\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004@BX\u000e¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u0007\n\u0005\b20\u0001¨\u0006\""}, d2 = {"Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "", "()V", "<set-?>", "", "keys", "getKeys", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "", "size", "getSize", "()I", "", "values", "getValues", "()[I", "add", "key", "value", "any", "", "predicate", "Lkotlin/Function2;", "find", "findExactIndex", "midIndex", "valueHash", "forEach", "", "block", "get", "remove", "removeValueIf", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IdentityArrayIntMap.kt */
public final class IdentityArrayIntMap {
    private Object[] keys = new Object[4];
    /* access modifiers changed from: private */
    public int size;
    private int[] values = new int[4];

    public final int getSize() {
        return this.size;
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    public final int[] getValues() {
        return this.values;
    }

    public final int get(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int index = find(key);
        if (index >= 0) {
            return this.values[index];
        }
        throw new IllegalStateException("Key not found".toString());
    }

    public final int add(Object key, int value) {
        int index;
        int insertIndex;
        Object obj = key;
        Intrinsics.checkNotNullParameter(obj, "key");
        int[] values2 = this.values;
        if (this.size > 0) {
            int index2 = find(key);
            if (index2 >= 0) {
                int previousValue = values2[index2];
                values2[index2] = value;
                return previousValue;
            }
            index = index2;
        } else {
            index = -1;
        }
        int insertIndex2 = -(index + 1);
        Object[] keys2 = this.keys;
        int size2 = this.size;
        if (size2 == keys2.length) {
            Object[] newKeys = new Object[(keys2.length * 2)];
            int[] newValues = new int[(keys2.length * 2)];
            ArraysKt.copyInto((T[]) keys2, (T[]) newKeys, insertIndex2 + 1, insertIndex2, size2);
            ArraysKt.copyInto(values2, newValues, insertIndex2 + 1, insertIndex2, size2);
            ArraysKt.copyInto$default(keys2, newKeys, 0, 0, insertIndex2, 6, (Object) null);
            int i = size2;
            insertIndex = insertIndex2;
            ArraysKt.copyInto$default(values2, newValues, 0, 0, insertIndex2, 6, (Object) null);
            this.keys = newKeys;
            this.values = newValues;
            Object[] objArr = keys2;
        } else {
            int size3 = size2;
            insertIndex = insertIndex2;
            Object[] keys3 = keys2;
            ArraysKt.copyInto((T[]) keys3, (T[]) keys3, insertIndex + 1, insertIndex, size3);
            ArraysKt.copyInto(values2, values2, insertIndex + 1, insertIndex, size3);
        }
        this.keys[insertIndex] = obj;
        this.values[insertIndex] = value;
        this.size++;
        return -1;
    }

    public final boolean remove(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int index = find(key);
        Object[] keys2 = this.keys;
        int[] values2 = this.values;
        int size2 = this.size;
        if (index < 0) {
            return false;
        }
        if (index < size2 - 1) {
            ArraysKt.copyInto((T[]) keys2, (T[]) keys2, index, index + 1, size2);
            ArraysKt.copyInto(values2, values2, index, index + 1, size2);
        }
        int newSize = size2 - 1;
        keys2[newSize] = null;
        this.size = newSize;
        return true;
    }

    public final void removeValueIf(Function2<Object, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] keys2 = getKeys();
        int[] values2 = getValues();
        int size2 = getSize();
        int destinationIndex = 0;
        for (int i = 0; i < size2; i++) {
            Object key = keys2[i];
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.Any");
            int value = values2[i];
            if (!predicate.invoke(key, Integer.valueOf(value)).booleanValue()) {
                if (destinationIndex != i) {
                    keys2[destinationIndex] = key;
                    values2[destinationIndex] = value;
                }
                destinationIndex++;
            }
        }
        for (int i2 = destinationIndex; i2 < size2; i2++) {
            keys2[i2] = null;
        }
        this.size = destinationIndex;
    }

    public final boolean any(Function2<Object, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] keys2 = getKeys();
        int[] values2 = getValues();
        int size2 = getSize();
        for (int i = 0; i < size2; i++) {
            Object obj = keys2[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
            if (predicate.invoke(obj, Integer.valueOf(values2[i])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final void forEach(Function2<Object, ? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Object[] keys2 = getKeys();
        int[] values2 = getValues();
        int size2 = getSize();
        for (int i = 0; i < size2; i++) {
            Object obj = keys2[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
            block.invoke(obj, Integer.valueOf(values2[i]));
        }
    }

    private final int find(Object key) {
        int low = 0;
        int high = this.size - 1;
        int valueIdentity = ActualJvm_jvmKt.identityHashCode(key);
        Object[] keys2 = this.keys;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Object midVal = keys2[mid];
            int midIdentity = ActualJvm_jvmKt.identityHashCode(midVal);
            if (midIdentity < valueIdentity) {
                low = mid + 1;
            } else if (midIdentity > valueIdentity) {
                high = mid - 1;
            } else if (midVal == key) {
                return mid;
            } else {
                return findExactIndex(mid, key, valueIdentity);
            }
        }
        return -(low + 1);
    }

    private final int findExactIndex(int midIndex, Object value, int valueHash) {
        Object[] keys2 = this.keys;
        int size2 = this.size;
        for (int i = midIndex - 1; -1 < i; i--) {
            Object v = keys2[i];
            if (v == value) {
                return i;
            }
            if (ActualJvm_jvmKt.identityHashCode(v) != valueHash) {
                break;
            }
        }
        for (int i2 = midIndex + 1; i2 < size2; i2++) {
            Object v2 = keys2[i2];
            if (v2 == value) {
                return i2;
            }
            if (ActualJvm_jvmKt.identityHashCode(v2) != valueHash) {
                return -(i2 + 1);
            }
        }
        return -(size2 + 1);
    }
}

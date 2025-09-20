package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u0005H\u0002JD\u0010\u001c\u001a\u00020\u001326\u0010\u001d\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00130\u001eH\bø\u0001\u0000J\u0018\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u0015J\u0006\u0010%\u001a\u00020\u0015J\u0015\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010#JD\u0010'\u001a\u00020\u001326\u0010\u001d\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00150\u001eH\bø\u0001\u0000J/\u0010(\u001a\u00020\u00132!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00150)H\bø\u0001\u0000J\u001e\u0010*\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010!\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010+R0\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b@BX\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR0\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b@BX\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b\u0002\u0007\n\u0005\b20\u0001¨\u0006,"}, d2 = {"Landroidx/compose/runtime/collection/IdentityArrayMap;", "Key", "", "Value", "capacity", "", "(I)V", "<set-?>", "", "keys", "getKeys", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "size", "getSize", "()I", "values", "getValues", "clear", "", "contains", "", "key", "(Ljava/lang/Object;)Z", "find", "findExactIndex", "midIndex", "keyHash", "forEach", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "remove", "removeIf", "removeValueIf", "Lkotlin/Function1;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IdentityArrayMap.kt */
public final class IdentityArrayMap<Key, Value> {
    private Object[] keys;
    /* access modifiers changed from: private */
    public int size;
    private Object[] values;

    public IdentityArrayMap() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public IdentityArrayMap(int capacity) {
        this.keys = new Object[capacity];
        this.values = new Object[capacity];
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IdentityArrayMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public final int getSize() {
        return this.size;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isNotEmpty() {
        return this.size > 0;
    }

    public final boolean contains(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return find(key) >= 0;
    }

    public final Value get(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int index = find(key);
        if (index >= 0) {
            return this.values[index];
        }
        return null;
    }

    public final void set(Key key, Value value) {
        Object[] objArr;
        Object[] destKeys;
        Object[] objArr2;
        Object[] destValues;
        Key key2 = key;
        Intrinsics.checkNotNullParameter(key2, "key");
        Object[] keys2 = this.keys;
        Object[] values2 = this.values;
        int size2 = this.size;
        int index = find(key);
        if (index >= 0) {
            values2[index] = value;
            return;
        }
        int insertIndex = -(index + 1);
        boolean resize = size2 == keys2.length;
        if (resize) {
            objArr = new Object[(size2 * 2)];
        } else {
            objArr = keys2;
        }
        Object[] destKeys2 = objArr;
        ArraysKt.copyInto((T[]) keys2, (T[]) destKeys2, insertIndex + 1, insertIndex, size2);
        if (resize) {
            destKeys = destKeys2;
            ArraysKt.copyInto$default(keys2, destKeys2, 0, 0, insertIndex, 6, (Object) null);
        } else {
            destKeys = destKeys2;
        }
        destKeys[insertIndex] = key2;
        this.keys = destKeys;
        if (resize) {
            objArr2 = new Object[(size2 * 2)];
        } else {
            objArr2 = values2;
        }
        Object[] destValues2 = objArr2;
        ArraysKt.copyInto((T[]) values2, (T[]) destValues2, insertIndex + 1, insertIndex, size2);
        if (resize) {
            destValues = destValues2;
            ArraysKt.copyInto$default(values2, destValues2, 0, 0, insertIndex, 6, (Object) null);
        } else {
            destValues = destValues2;
        }
        destValues[insertIndex] = value;
        this.values = destValues;
        this.size++;
    }

    public final Value remove(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int index = find(key);
        if (index < 0) {
            return null;
        }
        Object value = this.values[index];
        int size2 = this.size;
        Object[] keys2 = this.keys;
        Object[] values2 = this.values;
        ArraysKt.copyInto((T[]) keys2, (T[]) keys2, index, index + 1, size2);
        ArraysKt.copyInto((T[]) values2, (T[]) values2, index, index + 1, size2);
        int newSize = size2 - 1;
        keys2[newSize] = null;
        values2[newSize] = null;
        this.size = newSize;
        return value;
    }

    public final void clear() {
        this.size = 0;
        ArraysKt.fill$default(this.keys, (Object) null, 0, 0, 6, (Object) null);
        ArraysKt.fill$default(this.values, (Object) null, 0, 0, 6, (Object) null);
    }

    public final void removeIf(Function2<? super Key, ? super Value, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int current = 0;
        int size2 = getSize();
        for (int index = 0; index < size2; index++) {
            Object key = getKeys()[index];
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            if (!block.invoke(key, getValues()[index]).booleanValue()) {
                if (current != index) {
                    getKeys()[current] = key;
                    getValues()[current] = getValues()[index];
                }
                current++;
            }
        }
        if (getSize() > current) {
            int size3 = getSize();
            for (int index2 = current; index2 < size3; index2++) {
                getKeys()[index2] = null;
                getValues()[index2] = null;
            }
            this.size = current;
        }
    }

    public final void removeValueIf(Function1<? super Value, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int current$iv = 0;
        int size2 = getSize();
        for (int index$iv = 0; index$iv < size2; index$iv++) {
            Object key$iv = getKeys()[index$iv];
            Intrinsics.checkNotNull(key$iv, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            if (!block.invoke(getValues()[index$iv]).booleanValue()) {
                if (current$iv != index$iv) {
                    getKeys()[current$iv] = key$iv;
                    getValues()[current$iv] = getValues()[index$iv];
                }
                current$iv++;
            }
        }
        if (getSize() > current$iv) {
            int size3 = getSize();
            for (int index$iv2 = current$iv; index$iv2 < size3; index$iv2++) {
                getKeys()[index$iv2] = null;
                getValues()[index$iv2] = null;
            }
            this.size = current$iv;
        }
    }

    public final void forEach(Function2<? super Key, ? super Value, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int size2 = getSize();
        for (int index = 0; index < size2; index++) {
            Object obj = getKeys()[index];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            block.invoke(obj, getValues()[index]);
        }
    }

    private final int find(Object key) {
        int keyIdentity = ActualJvm_jvmKt.identityHashCode(key);
        int low = 0;
        int high = this.size - 1;
        Object[] keys2 = this.keys;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Object midKey = keys2[mid];
            int midKeyHash = ActualJvm_jvmKt.identityHashCode(midKey);
            if (midKeyHash < keyIdentity) {
                low = mid + 1;
            } else if (midKeyHash > keyIdentity) {
                high = mid - 1;
            } else if (key == midKey) {
                return mid;
            } else {
                return findExactIndex(mid, key, keyIdentity);
            }
        }
        return -(low + 1);
    }

    private final int findExactIndex(int midIndex, Object key, int keyHash) {
        Object[] keys2 = this.keys;
        int size2 = this.size;
        for (int i = midIndex - 1; -1 < i; i--) {
            Object k = keys2[i];
            if (k == key) {
                return i;
            }
            if (ActualJvm_jvmKt.identityHashCode(k) != keyHash) {
                break;
            }
        }
        for (int i2 = midIndex + 1; i2 < size2; i2++) {
            Object k2 = keys2[i2];
            if (k2 == key) {
                return i2;
            }
            if (ActualJvm_jvmKt.identityHashCode(k2) != keyHash) {
                return -(i2 + 1);
            }
        }
        return -(size2 + 1);
    }
}

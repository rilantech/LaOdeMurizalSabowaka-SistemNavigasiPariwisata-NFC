package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.WeakReference;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u001eJ%\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\"J\r\u0010#\u001a\u00020\u0019H\u0000¢\u0006\u0002\b$J \u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190(H\bø\u0001\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00120\u0011X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u0002\u0007\n\u0005\b20\u0001¨\u0006)"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "T", "", "()V", "hashes", "", "getHashes$runtime_release", "()[I", "setHashes$runtime_release", "([I)V", "size", "", "getSize$runtime_release", "()I", "setSize$runtime_release", "(I)V", "values", "", "Landroidx/compose/runtime/WeakReference;", "getValues$runtime_release", "()[Landroidx/compose/runtime/WeakReference;", "setValues$runtime_release", "([Landroidx/compose/runtime/WeakReference;)V", "[Landroidx/compose/runtime/WeakReference;", "add", "", "value", "(Ljava/lang/Object;)Z", "find", "hash", "(Ljava/lang/Object;I)I", "findExactIndex", "midIndex", "valueHash", "(ILjava/lang/Object;I)I", "isValid", "isValid$runtime_release", "removeIf", "", "block", "Lkotlin/Function1;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotWeakSet.kt */
public final class SnapshotWeakSet<T> {
    private int[] hashes = new int[16];
    private int size;
    private WeakReference<T>[] values = new WeakReference[16];

    public final int getSize$runtime_release() {
        return this.size;
    }

    public final void setSize$runtime_release(int i) {
        this.size = i;
    }

    public final int[] getHashes$runtime_release() {
        return this.hashes;
    }

    public final void setHashes$runtime_release(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.hashes = iArr;
    }

    public final WeakReference<T>[] getValues$runtime_release() {
        return this.values;
    }

    public final void setValues$runtime_release(WeakReference<T>[] weakReferenceArr) {
        Intrinsics.checkNotNullParameter(weakReferenceArr, "<set-?>");
        this.values = weakReferenceArr;
    }

    public final boolean add(T value) {
        int index;
        T t = value;
        Intrinsics.checkNotNullParameter(t, "value");
        int size2 = this.size;
        int hash = ActualJvm_jvmKt.identityHashCode(value);
        if (size2 > 0) {
            index = find(t, hash);
            if (index >= 0) {
                return false;
            }
        } else {
            index = -1;
        }
        int insertIndex = -(index + 1);
        WeakReference<T>[] weakReferenceArr = this.values;
        int capacity = weakReferenceArr.length;
        if (size2 == capacity) {
            int newCapacity = capacity * 2;
            WeakReference<T>[] weakReferenceArr2 = new WeakReference[newCapacity];
            ArraysKt.copyInto((T[]) weakReferenceArr, (T[]) weakReferenceArr2, insertIndex + 1, insertIndex, size2);
            int i = insertIndex;
            int i2 = index;
            int[] newHashes = new int[newCapacity];
            ArraysKt.copyInto$default((Object[]) this.values, (Object[]) weakReferenceArr2, 0, 0, i, 6, (Object) null);
            ArraysKt.copyInto(this.hashes, newHashes, insertIndex + 1, insertIndex, size2);
            ArraysKt.copyInto$default(this.hashes, newHashes, 0, 0, i, 6, (Object) null);
            this.values = weakReferenceArr2;
            this.hashes = newHashes;
        } else {
            ArraysKt.copyInto((T[]) weakReferenceArr, (T[]) weakReferenceArr, insertIndex + 1, insertIndex, size2);
            int[] iArr = this.hashes;
            ArraysKt.copyInto(iArr, iArr, insertIndex + 1, insertIndex, size2);
        }
        this.values[insertIndex] = new WeakReference<>(t);
        this.hashes[insertIndex] = hash;
        this.size++;
        return true;
    }

    public final void removeIf(Function1<? super T, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int size2 = getSize$runtime_release();
        int currentUsed = 0;
        int i = 0;
        while (true) {
            Object value = null;
            if (i >= size2) {
                break;
            }
            WeakReference entry = getValues$runtime_release()[i];
            if (entry != null) {
                value = entry.get();
            }
            if (value != null && !block.invoke(value).booleanValue()) {
                if (currentUsed != i) {
                    getValues$runtime_release()[currentUsed] = entry;
                    getHashes$runtime_release()[currentUsed] = getHashes$runtime_release()[i];
                }
                currentUsed++;
            }
            i++;
        }
        for (int i2 = currentUsed; i2 < size2; i2++) {
            getValues$runtime_release()[i2] = null;
            getHashes$runtime_release()[i2] = 0;
        }
        if (currentUsed != size2) {
            setSize$runtime_release(currentUsed);
        }
    }

    private final int find(T value, int hash) {
        int low = 0;
        int high = this.size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midHash = this.hashes[mid];
            if (midHash < hash) {
                low = mid + 1;
            } else if (midHash > hash) {
                high = mid - 1;
            } else {
                WeakReference<T> weakReference = this.values[mid];
                if (value == (weakReference != null ? weakReference.get() : null)) {
                    return mid;
                }
                return findExactIndex(mid, value, hash);
            }
        }
        return -(low + 1);
    }

    private final int findExactIndex(int midIndex, T value, int valueHash) {
        int i = midIndex - 1;
        while (true) {
            Object v = null;
            if (-1 >= i || this.hashes[i] != valueHash) {
                int i2 = this.size;
            } else {
                WeakReference<T> weakReference = this.values[i];
                if (weakReference != null) {
                    v = weakReference.get();
                }
                if (v == value) {
                    return i;
                }
                i--;
            }
        }
        int i22 = this.size;
        for (int i3 = midIndex + 1; i3 < i22; i3++) {
            if (this.hashes[i3] != valueHash) {
                return -(i3 + 1);
            }
            WeakReference<T> weakReference2 = this.values[i3];
            if ((weakReference2 != null ? weakReference2.get() : null) == value) {
                return i3;
            }
        }
        return -(this.size + 1);
    }

    public final boolean isValid$runtime_release() {
        WeakReference entry;
        int size2 = this.size;
        WeakReference[] values2 = this.values;
        int[] hashes2 = this.hashes;
        int capacity = values2.length;
        if (size2 > capacity) {
            return false;
        }
        int previous = Integer.MIN_VALUE;
        for (int i = 0; i < size2; i++) {
            int hash = hashes2[i];
            if (hash < previous || (entry = values2[i]) == null) {
                return false;
            }
            Object value = entry.get();
            if (value != null && hash != ActualJvm_jvmKt.identityHashCode(value)) {
                return false;
            }
            previous = hash;
        }
        for (int i2 = size2; i2 < capacity; i2++) {
            if (hashes2[i2] != 0 || values2[i2] != null) {
                return false;
            }
        }
        return true;
    }
}

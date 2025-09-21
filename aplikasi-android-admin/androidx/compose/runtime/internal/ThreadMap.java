package androidx.compose.runtime.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/internal/ThreadMap;", "", "size", "", "keys", "", "values", "", "(I[J[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "find", "key", "", "get", "newWith", "value", "trySet", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ThreadMap.kt */
public final class ThreadMap {
    private final long[] keys;
    private final int size;
    private final Object[] values;

    public ThreadMap(int size2, long[] keys2, Object[] values2) {
        Intrinsics.checkNotNullParameter(keys2, "keys");
        Intrinsics.checkNotNullParameter(values2, "values");
        this.size = size2;
        this.keys = keys2;
        this.values = values2;
    }

    public final Object get(long key) {
        int index = find(key);
        if (index >= 0) {
            return this.values[index];
        }
        return null;
    }

    public final boolean trySet(long key, Object value) {
        int index = find(key);
        if (index < 0) {
            return false;
        }
        this.values[index] = value;
        return true;
    }

    public final ThreadMap newWith(long key, Object value) {
        int size2 = this.size;
        Object[] $this$count$iv = this.values;
        int count$iv = 0;
        int length = $this$count$iv.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            if ($this$count$iv[i] == null) {
                z = false;
            }
            if (z) {
                count$iv++;
            }
            i++;
        }
        int count$iv2 = count$iv + 1;
        long[] newKeys = new long[count$iv2];
        Object[] newValues = new Object[count$iv2];
        if (count$iv2 > 1) {
            int dest = 0;
            int source = 0;
            while (true) {
                if (dest >= count$iv2 || source >= size2) {
                    break;
                }
                long oldKey = this.keys[source];
                Object oldValue = this.values[source];
                if (oldKey > key) {
                    newKeys[dest] = key;
                    newValues[dest] = value;
                    dest++;
                    break;
                }
                if (oldValue != null) {
                    newKeys[dest] = oldKey;
                    newValues[dest] = oldValue;
                    dest++;
                }
                source++;
            }
            if (source == size2) {
                newKeys[count$iv2 - 1] = key;
                newValues[count$iv2 - 1] = value;
            } else {
                while (dest < count$iv2) {
                    long oldKey2 = this.keys[source];
                    Object oldValue2 = this.values[source];
                    if (oldValue2 != null) {
                        newKeys[dest] = oldKey2;
                        newValues[dest] = oldValue2;
                        dest++;
                    }
                    source++;
                }
            }
        } else {
            newKeys[0] = key;
            newValues[0] = value;
        }
        return new ThreadMap(count$iv2, newKeys, newValues);
    }

    private final int find(long key) {
        int high = this.size - 1;
        switch (high) {
            case -1:
                return -1;
            case 0:
                long j = this.keys[0];
                if (j == key) {
                    return 0;
                }
                if (j > key) {
                    return -2;
                }
                return -1;
            default:
                int low = 0;
                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    long comparison = this.keys[mid] - key;
                    if (comparison < 0) {
                        low = mid + 1;
                    } else if (comparison <= 0) {
                        return mid;
                    } else {
                        high = mid - 1;
                    }
                }
                return -(low + 1);
        }
    }
}

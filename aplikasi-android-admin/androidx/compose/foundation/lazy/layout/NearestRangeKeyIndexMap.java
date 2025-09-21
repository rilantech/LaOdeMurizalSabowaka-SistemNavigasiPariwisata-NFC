package androidx.compose.foundation.lazy.layout;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\fH\u0016R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/lazy/layout/NearestRangeKeyIndexMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "nearestRange", "Lkotlin/ranges/IntRange;", "intervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "(Lkotlin/ranges/IntRange;Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;)V", "keys", "", "", "[Ljava/lang/Object;", "keysStartIndex", "", "map", "", "getIndex", "key", "getKey", "index", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutKeyIndexMap.kt */
public final class NearestRangeKeyIndexMap implements LazyLayoutKeyIndexMap {
    /* access modifiers changed from: private */
    public final Object[] keys;
    /* access modifiers changed from: private */
    public final int keysStartIndex;
    private final Map<Object, Integer> map;

    public NearestRangeKeyIndexMap(IntRange nearestRange, LazyLayoutIntervalContent<?> intervalContent) {
        Intrinsics.checkNotNullParameter(nearestRange, "nearestRange");
        Intrinsics.checkNotNullParameter(intervalContent, "intervalContent");
        IntervalList list = intervalContent.getIntervals();
        int first = nearestRange.getFirst();
        if (first >= 0) {
            int last = Math.min(nearestRange.getLast(), list.getSize() - 1);
            if (last < first) {
                this.map = MapsKt.emptyMap();
                this.keys = new Object[0];
                this.keysStartIndex = 0;
                return;
            }
            this.keys = new Object[((last - first) + 1)];
            this.keysStartIndex = first;
            HashMap map2 = new HashMap();
            list.forEach(first, last, new NearestRangeKeyIndexMap$1$1(first, last, map2, this));
            this.map = map2;
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public int getIndex(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = this.map.get(key);
        if (i == null) {
            i = -1;
        }
        return i.intValue();
    }

    public Object getKey(int index) {
        Object[] objArr = this.keys;
        int i = index - this.keysStartIndex;
        if (i >= 0 && i <= ArraysKt.getLastIndex((T[]) objArr)) {
            return objArr[i];
        }
        int i2 = i;
        return null;
    }
}

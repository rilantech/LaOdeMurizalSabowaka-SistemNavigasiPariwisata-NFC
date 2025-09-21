package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent$Interval;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutKeyIndexMap.kt */
final class NearestRangeKeyIndexMap$1$1 extends Lambda implements Function1<IntervalList.Interval<? extends LazyLayoutIntervalContent.Interval>, Unit> {
    final /* synthetic */ int $first;
    final /* synthetic */ int $last;
    final /* synthetic */ HashMap<Object, Integer> $map;
    final /* synthetic */ NearestRangeKeyIndexMap this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NearestRangeKeyIndexMap$1$1(int i, int i2, HashMap<Object, Integer> hashMap, NearestRangeKeyIndexMap nearestRangeKeyIndexMap) {
        super(1);
        this.$first = i;
        this.$last = i2;
        this.$map = hashMap;
        this.this$0 = nearestRangeKeyIndexMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((IntervalList.Interval<? extends LazyLayoutIntervalContent.Interval>) (IntervalList.Interval) p1);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x003e, code lost:
        if (r4 == null) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.lazy.layout.IntervalList.Interval<? extends androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.Object r0 = r8.getValue()
            androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval r0 = (androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval) r0
            kotlin.jvm.functions.Function1 r0 = r0.getKey()
            int r1 = r7.$first
            int r2 = r8.getStartIndex()
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r7.$last
            int r3 = r8.getStartIndex()
            int r4 = r8.getSize()
            int r3 = r3 + r4
            int r3 = r3 + -1
            int r2 = java.lang.Math.min(r2, r3)
            r3 = r1
            if (r3 > r2) goto L_0x0065
        L_0x002e:
            if (r0 == 0) goto L_0x0040
            int r4 = r8.getStartIndex()
            int r4 = r3 - r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r4 = r0.invoke(r4)
            if (r4 != 0) goto L_0x0044
        L_0x0040:
            java.lang.Object r4 = androidx.compose.foundation.lazy.layout.Lazy_androidKt.getDefaultLazyLayoutKey(r3)
        L_0x0044:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            java.util.HashMap<java.lang.Object, java.lang.Integer> r6 = r7.$map
            java.util.Map r6 = (java.util.Map) r6
            r6.put(r4, r5)
            androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap r5 = r7.this$0
            java.lang.Object[] r5 = r5.keys
            androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap r6 = r7.this$0
            int r6 = r6.keysStartIndex
            int r6 = r3 - r6
            r5[r6] = r4
            if (r3 == r2) goto L_0x0065
            int r3 = r3 + 1
            goto L_0x002e
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap$1$1.invoke(androidx.compose.foundation.lazy.layout.IntervalList$Interval):void");
    }
}

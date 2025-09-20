package androidx.compose.material;

import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "anchors", "", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Swipeable.kt */
final class SwipeableState$snapTo$2 implements FlowCollector<Map<Float, ? extends T>> {
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableState<T> this$0;

    SwipeableState$snapTo$2(T t, SwipeableState<T> swipeableState) {
        this.$targetValue = t;
        this.this$0 = swipeableState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(java.util.Map<java.lang.Float, ? extends T> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.material.SwipeableState$snapTo$2$emit$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.material.SwipeableState$snapTo$2$emit$1 r0 = (androidx.compose.material.SwipeableState$snapTo$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.material.SwipeableState$snapTo$2$emit$1 r0 = new androidx.compose.material.SwipeableState$snapTo$2$emit$1
            r0.<init>(r6, r8)
        L_0x0019:
            r8 = r0
            java.lang.Object r0 = r8.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            switch(r2) {
                case 0: goto L_0x0035;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002d:
            java.lang.Object r7 = r8.L$0
            androidx.compose.material.SwipeableState$snapTo$2 r7 = (androidx.compose.material.SwipeableState$snapTo$2) r7
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0054
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r6
            T r3 = r2.$targetValue
            java.lang.Float r7 = androidx.compose.material.SwipeableKt.getOffset(r7, r3)
            if (r7 == 0) goto L_0x005e
            androidx.compose.material.SwipeableState<T> r3 = r2.this$0
            float r4 = r7.floatValue()
            r8.L$0 = r2
            r5 = 1
            r8.label = r5
            java.lang.Object r7 = r3.snapInternalToOffset(r4, r8)
            if (r7 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r7 = r2
        L_0x0054:
            androidx.compose.material.SwipeableState<T> r1 = r7.this$0
            T r2 = r7.$targetValue
            r1.setCurrentValue(r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x005e:
            r7 = 0
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The target value must have an associated anchor."
            java.lang.String r1 = r1.toString()
            r7.<init>(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState$snapTo$2.emit(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

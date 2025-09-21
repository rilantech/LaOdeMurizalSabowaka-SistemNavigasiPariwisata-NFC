package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "anchors", "", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Swipeable.kt */
final class SwipeableState$animateTo$2 implements FlowCollector<Map<Float, ? extends T>> {
    final /* synthetic */ AnimationSpec<Float> $anim;
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableState<T> this$0;

    SwipeableState$animateTo$2(T t, SwipeableState<T> swipeableState, AnimationSpec<Float> animationSpec) {
        this.$targetValue = t;
        this.this$0 = swipeableState;
        this.$anim = animationSpec;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.util.Map<java.lang.Float, ? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: androidx.compose.material3.SwipeableState$animateTo$2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(java.util.Map<java.lang.Float, ? extends T> r16, kotlin.coroutines.Continuation<? super kotlin.Unit> r17) {
        /*
            r15 = this;
            r0 = r17
            boolean r1 = r0 instanceof androidx.compose.material3.SwipeableState$animateTo$2$emit$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            androidx.compose.material3.SwipeableState$animateTo$2$emit$1 r1 = (androidx.compose.material3.SwipeableState$animateTo$2$emit$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r15
            goto L_0x001f
        L_0x0018:
            androidx.compose.material3.SwipeableState$animateTo$2$emit$1 r1 = new androidx.compose.material3.SwipeableState$animateTo$2$emit$1
            r2 = r15
            r1.<init>(r15, r0)
            r0 = r1
        L_0x001f:
            java.lang.Object r3 = r1.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 0
            r6 = 1056964608(0x3f000000, float:0.5)
            r7 = 1
            switch(r4) {
                case 0: goto L_0x0044;
                case 1: goto L_0x0036;
                default: goto L_0x002e;
            }
        L_0x002e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0036:
            java.lang.Object r0 = r1.L$1
            r2 = r0
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r0 = r1.L$0
            r4 = r0
            androidx.compose.material3.SwipeableState$animateTo$2 r4 = (androidx.compose.material3.SwipeableState$animateTo$2) r4
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x00e6 }
            goto L_0x0068
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r3)
            r4 = r15
            r2 = r16
            T r8 = r4.$targetValue     // Catch:{ all -> 0x00e6 }
            java.lang.Float r8 = androidx.compose.material3.SwipeableKt.getOffset(r2, r8)     // Catch:{ all -> 0x00e6 }
            if (r8 == 0) goto L_0x00d9
            androidx.compose.material3.SwipeableState<T> r9 = r4.this$0     // Catch:{ all -> 0x00e6 }
            float r10 = r8.floatValue()     // Catch:{ all -> 0x00e6 }
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r11 = r4.$anim     // Catch:{ all -> 0x00e6 }
            r1.L$0 = r4     // Catch:{ all -> 0x00e6 }
            r1.L$1 = r2     // Catch:{ all -> 0x00e6 }
            r1.label = r7     // Catch:{ all -> 0x00e6 }
            java.lang.Object r9 = r9.animateInternalToOffset(r10, r11, r1)     // Catch:{ all -> 0x00e6 }
            if (r9 != r0) goto L_0x0068
            return r0
        L_0x0068:
            androidx.compose.material3.SwipeableState<T> r0 = r4.this$0
            androidx.compose.runtime.MutableState r0 = r0.absoluteOffset
            java.lang.Object r0 = r0.getValue()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            r8 = 0
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
            java.util.Set r10 = r2.entrySet()
            java.util.Iterator r2 = r10.iterator()
        L_0x0087:
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto L_0x00b9
            java.lang.Object r10 = r2.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r11 = r10.getKey()
            java.lang.Number r11 = (java.lang.Number) r11
            float r11 = r11.floatValue()
            r12 = 0
            float r13 = r11 - r0
            float r11 = java.lang.Math.abs(r13)
            int r11 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r11 >= 0) goto L_0x00aa
            r11 = r7
            goto L_0x00ab
        L_0x00aa:
            r11 = r5
        L_0x00ab:
            if (r11 == 0) goto L_0x0087
            java.lang.Object r11 = r10.getKey()
            java.lang.Object r12 = r10.getValue()
            r9.put(r11, r12)
            goto L_0x0087
        L_0x00b9:
            r0 = r9
            java.util.Map r0 = (java.util.Map) r0
            java.util.Collection r0 = r0.values()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            if (r0 != 0) goto L_0x00cf
            androidx.compose.material3.SwipeableState<T> r0 = r4.this$0
            java.lang.Object r0 = r0.getCurrentValue()
        L_0x00cf:
            androidx.compose.material3.SwipeableState<T> r2 = r4.this$0
            r2.setCurrentValue(r0)
            r0 = r4
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        L_0x00d9:
            r0 = 0
            java.lang.String r8 = "The target value must have an associated anchor."
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00e6 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00e6 }
            r0.<init>(r8)     // Catch:{ all -> 0x00e6 }
            throw r0     // Catch:{ all -> 0x00e6 }
        L_0x00e6:
            r0 = move-exception
            androidx.compose.material3.SwipeableState<T> r8 = r4.this$0
            androidx.compose.runtime.MutableState r8 = r8.absoluteOffset
            java.lang.Object r8 = r8.getValue()
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            r9 = 0
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            r10.<init>()
            java.util.Set r11 = r2.entrySet()
            java.util.Iterator r2 = r11.iterator()
        L_0x0106:
            boolean r11 = r2.hasNext()
            if (r11 == 0) goto L_0x0138
            java.lang.Object r11 = r2.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r12 = r11.getKey()
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            r13 = 0
            float r14 = r12 - r8
            float r12 = java.lang.Math.abs(r14)
            int r12 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r12 >= 0) goto L_0x0129
            r12 = r7
            goto L_0x012a
        L_0x0129:
            r12 = r5
        L_0x012a:
            if (r12 == 0) goto L_0x0106
            java.lang.Object r12 = r11.getKey()
            java.lang.Object r13 = r11.getValue()
            r10.put(r12, r13)
            goto L_0x0106
        L_0x0138:
            r2 = r10
            java.util.Map r2 = (java.util.Map) r2
            java.util.Collection r2 = r2.values()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.lang.Object r2 = kotlin.collections.CollectionsKt.firstOrNull(r2)
            if (r2 != 0) goto L_0x014e
            androidx.compose.material3.SwipeableState<T> r2 = r4.this$0
            java.lang.Object r2 = r2.getCurrentValue()
        L_0x014e:
            androidx.compose.material3.SwipeableState<T> r5 = r4.this$0
            r5.setCurrentValue(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableState$animateTo$2.emit(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.AnchoredDraggableState$doAnchoredDrag$2", f = "AnchoredDraggable.kt", i = {}, l = {441}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableState$doAnchoredDrag$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<AnchoredDragScope, Map<T, Float>, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ MutatePriority $dragPriority;
    final /* synthetic */ T $targetValue;
    int label;
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableState$doAnchoredDrag$2(T t, AnchoredDraggableState<T> anchoredDraggableState, MutatePriority mutatePriority, Function3<? super AnchoredDragScope, ? super Map<T, Float>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super AnchoredDraggableState$doAnchoredDrag$2> continuation) {
        super(2, continuation);
        this.$targetValue = t;
        this.this$0 = anchoredDraggableState;
        this.$dragPriority = mutatePriority;
        this.$block = function3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnchoredDraggableState$doAnchoredDrag$2(this.$targetValue, this.this$0, this.$dragPriority, this.$block, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnchoredDraggableState$doAnchoredDrag$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0077, code lost:
        if (r0.$targetValue == null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        r0.this$0.setAnimationTarget(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        r6 = r0.this$0;
        r8 = r0.this$0.getAnchors$material_release().entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (r8.hasNext() == false) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0098, code lost:
        r1 = r8.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b6, code lost:
        if (java.lang.Math.abs(((java.lang.Number) ((java.util.Map.Entry) r1).getValue()).floatValue() - r6.getOffset()) >= 0.5f) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b8, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ba, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bb, code lost:
        if (r9 == false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00be, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bf, code lost:
        r1 = (java.util.Map.Entry) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c1, code lost:
        if (r1 == null) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c3, code lost:
        r5 = r1.getKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c8, code lost:
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c9, code lost:
        if (r1 == null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00db, code lost:
        if (r0.this$0.getConfirmValueChange$material_release().invoke(r1).booleanValue() == false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00dd, code lost:
        r0.this$0.setCurrentValue(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e2, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e5, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 0
            r3 = 1056964608(0x3f000000, float:0.5)
            r4 = 1
            r5 = 0
            switch(r1) {
                case 0: goto L_0x001e;
                case 1: goto L_0x0016;
                default: goto L_0x000e;
            }
        L_0x000e:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0016:
            r0 = r14
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x001b }
            goto L_0x0075
        L_0x001b:
            r1 = move-exception
            goto L_0x00ea
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r15)
            r1 = r14
            T r6 = r1.$targetValue
            if (r6 == 0) goto L_0x0052
            androidx.compose.material.AnchoredDraggableState<T> r6 = r1.this$0
            java.util.Map r6 = r6.getAnchors$material_release()
            T r7 = r1.$targetValue
            boolean r6 = r6.containsKey(r7)
            if (r6 == 0) goto L_0x0035
            goto L_0x0052
        L_0x0035:
            androidx.compose.material.AnchoredDraggableState<T> r0 = r1.this$0
            kotlin.jvm.functions.Function1 r0 = r0.getConfirmValueChange$material_release()
            T r2 = r1.$targetValue
            java.lang.Object r0 = r0.invoke(r2)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00e3
            androidx.compose.material.AnchoredDraggableState<T> r0 = r1.this$0
            T r2 = r1.$targetValue
            r0.setCurrentValue(r2)
            goto L_0x00e3
        L_0x0052:
            androidx.compose.material.AnchoredDraggableState<T> r6 = r1.this$0     // Catch:{ all -> 0x00e6 }
            androidx.compose.material.InternalMutatorMutex r6 = r6.dragMutex     // Catch:{ all -> 0x00e6 }
            androidx.compose.foundation.MutatePriority r7 = r1.$dragPriority     // Catch:{ all -> 0x00e6 }
            androidx.compose.material.AnchoredDraggableState$doAnchoredDrag$2$1 r8 = new androidx.compose.material.AnchoredDraggableState$doAnchoredDrag$2$1     // Catch:{ all -> 0x00e6 }
            T r9 = r1.$targetValue     // Catch:{ all -> 0x00e6 }
            androidx.compose.material.AnchoredDraggableState<T> r10 = r1.this$0     // Catch:{ all -> 0x00e6 }
            kotlin.jvm.functions.Function3<androidx.compose.material.AnchoredDragScope, java.util.Map<T, java.lang.Float>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r11 = r1.$block     // Catch:{ all -> 0x00e6 }
            r8.<init>(r9, r10, r11, r5)     // Catch:{ all -> 0x00e6 }
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8     // Catch:{ all -> 0x00e6 }
            r9 = r1
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ all -> 0x00e6 }
            r1.label = r4     // Catch:{ all -> 0x00e6 }
            java.lang.Object r6 = r6.mutate(r7, r8, r9)     // Catch:{ all -> 0x00e6 }
            if (r6 != r0) goto L_0x0074
            return r0
        L_0x0074:
            r0 = r1
        L_0x0075:
            T r1 = r0.$targetValue
            if (r1 == 0) goto L_0x007e
            androidx.compose.material.AnchoredDraggableState<T> r1 = r0.this$0
            r1.setAnimationTarget(r5)
        L_0x007e:
            androidx.compose.material.AnchoredDraggableState<T> r1 = r0.this$0
            java.util.Map r1 = r1.getAnchors$material_release()
            java.util.Set r1 = r1.entrySet()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            androidx.compose.material.AnchoredDraggableState<T> r6 = r0.this$0
            r7 = 0
            java.util.Iterator r8 = r1.iterator()
        L_0x0092:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x00be
            java.lang.Object r1 = r8.next()
            r9 = r1
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            r10 = 0
            java.lang.Object r9 = r9.getValue()
            java.lang.Number r9 = (java.lang.Number) r9
            float r9 = r9.floatValue()
            float r11 = r6.getOffset()
            float r11 = r9 - r11
            float r9 = java.lang.Math.abs(r11)
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 >= 0) goto L_0x00ba
            r9 = r4
            goto L_0x00bb
        L_0x00ba:
            r9 = r2
        L_0x00bb:
            if (r9 == 0) goto L_0x0092
            goto L_0x00bf
        L_0x00be:
            r1 = r5
        L_0x00bf:
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            if (r1 == 0) goto L_0x00c8
            java.lang.Object r5 = r1.getKey()
        L_0x00c8:
            r1 = r5
            if (r1 == 0) goto L_0x00e2
            androidx.compose.material.AnchoredDraggableState<T> r2 = r0.this$0
            kotlin.jvm.functions.Function1 r2 = r2.getConfirmValueChange$material_release()
            java.lang.Object r2 = r2.invoke(r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x00e2
            androidx.compose.material.AnchoredDraggableState<T> r2 = r0.this$0
            r2.setCurrentValue(r1)
        L_0x00e2:
            r1 = r0
        L_0x00e3:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00e6:
            r0 = move-exception
            r13 = r1
            r1 = r0
            r0 = r13
        L_0x00ea:
            T r6 = r0.$targetValue
            if (r6 == 0) goto L_0x00f3
            androidx.compose.material.AnchoredDraggableState<T> r6 = r0.this$0
            r6.setAnimationTarget(r5)
        L_0x00f3:
            androidx.compose.material.AnchoredDraggableState<T> r6 = r0.this$0
            java.util.Map r6 = r6.getAnchors$material_release()
            java.util.Set r6 = r6.entrySet()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            androidx.compose.material.AnchoredDraggableState<T> r7 = r0.this$0
            r8 = 0
            java.util.Iterator r9 = r6.iterator()
        L_0x0107:
            boolean r6 = r9.hasNext()
            if (r6 == 0) goto L_0x0133
            java.lang.Object r6 = r9.next()
            r10 = r6
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            r11 = 0
            java.lang.Object r10 = r10.getValue()
            java.lang.Number r10 = (java.lang.Number) r10
            float r10 = r10.floatValue()
            float r12 = r7.getOffset()
            float r12 = r10 - r12
            float r10 = java.lang.Math.abs(r12)
            int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r10 >= 0) goto L_0x012f
            r10 = r4
            goto L_0x0130
        L_0x012f:
            r10 = r2
        L_0x0130:
            if (r10 == 0) goto L_0x0107
            goto L_0x0134
        L_0x0133:
            r6 = r5
        L_0x0134:
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            if (r6 == 0) goto L_0x013d
            java.lang.Object r5 = r6.getKey()
        L_0x013d:
            r2 = r5
            if (r2 == 0) goto L_0x0157
            androidx.compose.material.AnchoredDraggableState<T> r3 = r0.this$0
            kotlin.jvm.functions.Function1 r3 = r3.getConfirmValueChange$material_release()
            java.lang.Object r3 = r3.invoke(r2)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0157
            androidx.compose.material.AnchoredDraggableState<T> r3 = r0.this$0
            r3.setCurrentValue(r2)
        L_0x0157:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AnchoredDraggableState$doAnchoredDrag$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

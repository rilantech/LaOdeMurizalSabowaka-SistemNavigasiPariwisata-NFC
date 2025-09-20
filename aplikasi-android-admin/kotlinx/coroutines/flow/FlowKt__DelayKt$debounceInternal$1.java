package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {222, 355}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue", "timeoutMillis"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
/* compiled from: Delay.kt */
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_debounceInternal;
    final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = flow;
    }

    public final Object invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:9|(7:11|(1:13)|14|(1:16)(1:17)|(1:28)(2:19|(16:21|(1:23)|24|(1:26)|27|31|(3:33|(1:38)(1:37)|(2:40|41))|42|43|44|(1:46)|47|50|(1:52)|(1:54)(4:55|56|7|(1:57)(0))|54))|28|29)|30|31|(0)|42|43|44|(0)|47|50|(0)|(0)|54) */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0141, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0142, code lost:
        r15.handleBuilderException(r0);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0125 A[Catch:{ all -> 0x0141 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r18
            int r2 = r1.label
            r4 = 0
            r6 = 1
            r7 = 0
            switch(r2) {
                case 0: goto L_0x004a;
                case 1: goto L_0x0031;
                case 2: goto L_0x0017;
                default: goto L_0x000f;
            }
        L_0x000f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0017:
            r1 = r18
            r2 = r19
            r8 = 0
            java.lang.Object r9 = r1.L$3
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r9 = r1.L$2
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r11 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x015c
        L_0x0031:
            r1 = r18
            r2 = r19
            java.lang.Object r8 = r1.L$3
            kotlin.jvm.internal.Ref$LongRef r8 = (kotlin.jvm.internal.Ref.LongRef) r8
            java.lang.Object r9 = r1.L$2
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r11 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00c8
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r19)
            r1 = r18
            r2 = r19
            java.lang.Object r8 = r1.L$0
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            java.lang.Object r9 = r1.L$1
            r15 = r9
            kotlinx.coroutines.flow.FlowCollector r15 = (kotlinx.coroutines.flow.FlowCollector) r15
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1 r9 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1
            kotlinx.coroutines.flow.Flow<T> r10 = r1.$this_debounceInternal
            r9.<init>(r10, r7)
            r12 = r9
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r13 = 3
            r14 = 0
            r10 = 0
            r11 = 0
            r9 = r8
            kotlinx.coroutines.channels.ReceiveChannel r8 = kotlinx.coroutines.channels.ProduceKt.produce$default(r9, r10, r11, r12, r13, r14)
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef
            r9.<init>()
            r10 = r8
            r11 = r15
        L_0x0074:
            T r8 = r9.element
            kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.flow.internal.NullSurrogateKt.DONE
            if (r8 == r12) goto L_0x0160
            kotlin.jvm.internal.Ref$LongRef r8 = new kotlin.jvm.internal.Ref$LongRef
            r8.<init>()
            T r12 = r9.element
            if (r12 == 0) goto L_0x00e0
            kotlin.jvm.functions.Function1<T, java.lang.Long> r12 = r1.$timeoutMillisSelector
            kotlinx.coroutines.internal.Symbol r13 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
            T r14 = r9.element
            r15 = 0
            if (r14 != r13) goto L_0x008e
            r14 = r7
        L_0x008e:
            java.lang.Object r12 = r12.invoke(r14)
            java.lang.Number r12 = (java.lang.Number) r12
            long r12 = r12.longValue()
            r8.element = r12
            long r12 = r8.element
            int r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r12 < 0) goto L_0x00a2
            r12 = r6
            goto L_0x00a3
        L_0x00a2:
            r12 = 0
        L_0x00a3:
            if (r12 == 0) goto L_0x00d2
            long r12 = r8.element
            int r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r12 != 0) goto L_0x00e0
            kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
            T r13 = r9.element
            r14 = 0
            if (r13 != r12) goto L_0x00b4
            r13 = r7
        L_0x00b4:
            r12 = r1
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r1.L$0 = r11
            r1.L$1 = r10
            r1.L$2 = r9
            r1.L$3 = r8
            r1.label = r6
            java.lang.Object r12 = r11.emit(r13, r12)
            if (r12 != r0) goto L_0x00c8
            return r0
        L_0x00c8:
            r9.element = r7
            r17 = r1
            r1 = r0
            r0 = r8
            r8 = r2
            r2 = r17
            goto L_0x00e7
        L_0x00d2:
            r0 = 0
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Debounce timeout should not be negative"
            java.lang.String r3 = r3.toString()
            r0.<init>(r3)
            throw r0
        L_0x00e0:
            r17 = r1
            r1 = r0
            r0 = r8
            r8 = r2
            r2 = r17
        L_0x00e7:
            boolean r12 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r12 == 0) goto L_0x0105
            r12 = 0
            T r13 = r9.element
            if (r13 == 0) goto L_0x00fb
            long r13 = r0.element
            int r13 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r13 <= 0) goto L_0x00f9
            goto L_0x00fb
        L_0x00f9:
            r12 = 0
            goto L_0x00fc
        L_0x00fb:
            r12 = r6
        L_0x00fc:
            if (r12 == 0) goto L_0x00ff
            goto L_0x0105
        L_0x00ff:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x0105:
            r12 = 0
            r2.L$0 = r11
            r2.L$1 = r10
            r2.L$2 = r9
            r2.L$3 = r0
            r13 = 2
            r2.label = r13
            r13 = r2
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r14 = 0
            kotlinx.coroutines.selects.SelectBuilderImpl r15 = new kotlinx.coroutines.selects.SelectBuilderImpl
            r15.<init>(r13)
            r13 = r15
            kotlinx.coroutines.selects.SelectBuilder r13 = (kotlinx.coroutines.selects.SelectBuilder) r13     // Catch:{ all -> 0x0141 }
            r16 = 0
            T r3 = r9.element     // Catch:{ all -> 0x0141 }
            if (r3 == 0) goto L_0x0131
            long r4 = r0.element     // Catch:{ all -> 0x0141 }
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1 r3 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1     // Catch:{ all -> 0x0141 }
            r3.<init>(r11, r9, r7)     // Catch:{ all -> 0x0141 }
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3     // Catch:{ all -> 0x0141 }
            r13.onTimeout(r4, r3)     // Catch:{ all -> 0x0141 }
        L_0x0131:
            kotlinx.coroutines.selects.SelectClause1 r0 = r10.getOnReceiveCatching()     // Catch:{ all -> 0x0141 }
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2 r3 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2     // Catch:{ all -> 0x0141 }
            r3.<init>(r9, r11, r7)     // Catch:{ all -> 0x0141 }
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3     // Catch:{ all -> 0x0141 }
            r13.invoke(r0, r3)     // Catch:{ all -> 0x0141 }
            goto L_0x0145
        L_0x0141:
            r0 = move-exception
            r15.handleBuilderException(r0)
        L_0x0145:
            java.lang.Object r0 = r15.getResult()
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r3) goto L_0x0155
            r3 = r2
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r3)
        L_0x0155:
            if (r0 != r1) goto L_0x0158
            return r1
        L_0x0158:
            r0 = r1
            r1 = r2
            r2 = r8
            r8 = r12
        L_0x015c:
            r4 = 0
            goto L_0x0074
        L_0x0160:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

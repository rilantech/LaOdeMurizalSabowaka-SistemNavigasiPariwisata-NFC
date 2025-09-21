package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.TooltipSync$show$6", f = "Tooltip.kt", i = {}, l = {655}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Tooltip.kt */
final class TooltipSync$show$6 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $cleanUp;
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $runBlock;
    final /* synthetic */ TooltipState $state;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TooltipSync$show$6(TooltipState tooltipState, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Function0<Unit> function0, Continuation<? super TooltipSync$show$6> continuation) {
        super(1, continuation);
        this.$state = tooltipState;
        this.$runBlock = function1;
        this.$cleanUp = function0;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TooltipSync$show$6(this.$state, this.$runBlock, this.$cleanUp, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TooltipSync$show$6) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        androidx.compose.material3.TooltipSync.INSTANCE.setMutexOwner((androidx.compose.material3.TooltipState) null);
        r0.$cleanUp.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 0
            switch(r1) {
                case 0: goto L_0x0019;
                case 1: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0012:
            r0 = r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0017 }
            goto L_0x0032
        L_0x0017:
            r1 = move-exception
            goto L_0x0044
        L_0x0019:
            kotlin.ResultKt.throwOnFailure(r7)
            r1 = r6
            androidx.compose.material3.TooltipSync r3 = androidx.compose.material3.TooltipSync.INSTANCE     // Catch:{ all -> 0x0040 }
            androidx.compose.material3.TooltipState r4 = r1.$state     // Catch:{ all -> 0x0040 }
            r3.setMutexOwner(r4)     // Catch:{ all -> 0x0040 }
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r3 = r1.$runBlock     // Catch:{ all -> 0x0040 }
            r4 = 1
            r1.label = r4     // Catch:{ all -> 0x0040 }
            java.lang.Object r3 = r3.invoke(r1)     // Catch:{ all -> 0x0040 }
            if (r3 != r0) goto L_0x0031
            return r0
        L_0x0031:
            r0 = r1
        L_0x0032:
            androidx.compose.material3.TooltipSync r1 = androidx.compose.material3.TooltipSync.INSTANCE
            r1.setMutexOwner(r2)
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r0.$cleanUp
            r1.invoke()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0040:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x0044:
            androidx.compose.material3.TooltipSync r3 = androidx.compose.material3.TooltipSync.INSTANCE
            r3.setMutexOwner(r2)
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r0.$cleanUp
            r2.invoke()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipSync$show$6.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

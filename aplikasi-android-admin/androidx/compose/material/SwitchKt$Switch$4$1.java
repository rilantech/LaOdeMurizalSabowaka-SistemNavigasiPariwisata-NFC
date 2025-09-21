package androidx.compose.material;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SwitchKt$Switch$4$1", f = "Switch.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Switch.kt */
final class SwitchKt$Switch$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnchoredDraggableState<Boolean> $anchoredDraggableState;
    final /* synthetic */ boolean $checked;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwitchKt$Switch$4$1(boolean z, AnchoredDraggableState<Boolean> anchoredDraggableState, Continuation<? super SwitchKt$Switch$4$1> continuation) {
        super(2, continuation);
        this.$checked = z;
        this.$anchoredDraggableState = anchoredDraggableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SwitchKt$Switch$4$1(this.$checked, this.$anchoredDraggableState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SwitchKt$Switch$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            switch(r1) {
                case 0: goto L_0x0016;
                case 1: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0011:
            r0 = r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0043
        L_0x0016:
            kotlin.ResultKt.throwOnFailure(r11)
            r1 = r10
            boolean r2 = r1.$checked
            androidx.compose.material.AnchoredDraggableState<java.lang.Boolean> r3 = r1.$anchoredDraggableState
            java.lang.Object r3 = r3.getCurrentValue()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r2 == r3) goto L_0x0044
            androidx.compose.material.AnchoredDraggableState<java.lang.Boolean> r4 = r1.$anchoredDraggableState
            boolean r2 = r1.$checked
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r7 = r1
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r2 = 1
            r1.label = r2
            r6 = 0
            r8 = 2
            r9 = 0
            java.lang.Object r2 = androidx.compose.material.AnchoredDraggableKt.animateTo$default(r4, r5, r6, r7, r8, r9)
            if (r2 != r0) goto L_0x0042
            return r0
        L_0x0042:
            r0 = r1
        L_0x0043:
            r1 = r0
        L_0x0044:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwitchKt$Switch$4$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package androidx.compose.material;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\u0005H@"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/material/AnchoredDragScope;", "anchors", "", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$animateTo$2", f = "AnchoredDraggable.kt", i = {}, l = {586}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableKt$animateTo$2 extends SuspendLambda implements Function3<AnchoredDragScope, Map<T, ? extends Float>, Continuation<? super Unit>, Object> {
    final /* synthetic */ T $targetValue;
    final /* synthetic */ AnchoredDraggableState<T> $this_animateTo;
    final /* synthetic */ float $velocity;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableKt$animateTo$2(T t, AnchoredDraggableState<T> anchoredDraggableState, float f, Continuation<? super AnchoredDraggableKt$animateTo$2> continuation) {
        super(3, continuation);
        this.$targetValue = t;
        this.$this_animateTo = anchoredDraggableState;
        this.$velocity = f;
    }

    public final Object invoke(AnchoredDragScope anchoredDragScope, Map<T, Float> map, Continuation<? super Unit> continuation) {
        AnchoredDraggableKt$animateTo$2 anchoredDraggableKt$animateTo$2 = new AnchoredDraggableKt$animateTo$2(this.$targetValue, this.$this_animateTo, this.$velocity, continuation);
        anchoredDraggableKt$animateTo$2.L$0 = anchoredDragScope;
        anchoredDraggableKt$animateTo$2.L$1 = map;
        return anchoredDraggableKt$animateTo$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            switch(r1) {
                case 0: goto L_0x0016;
                case 1: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0011:
            r0 = r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x006f
        L_0x0016:
            kotlin.ResultKt.throwOnFailure(r13)
            r1 = r12
            java.lang.Object r2 = r1.L$0
            androidx.compose.material.AnchoredDragScope r2 = (androidx.compose.material.AnchoredDragScope) r2
            java.lang.Object r3 = r1.L$1
            java.util.Map r3 = (java.util.Map) r3
            T r4 = r1.$targetValue
            java.lang.Object r4 = r3.get(r4)
            r3 = r4
            java.lang.Float r3 = (java.lang.Float) r3
            if (r3 == 0) goto L_0x0070
            kotlin.jvm.internal.Ref$FloatRef r4 = new kotlin.jvm.internal.Ref$FloatRef
            r4.<init>()
            androidx.compose.material.AnchoredDraggableState<T> r5 = r1.$this_animateTo
            float r5 = r5.getOffset()
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 == 0) goto L_0x0040
            r5 = 0
            goto L_0x0046
        L_0x0040:
            androidx.compose.material.AnchoredDraggableState<T> r5 = r1.$this_animateTo
            float r5 = r5.getOffset()
        L_0x0046:
            r4.element = r5
            float r6 = r4.element
            float r7 = r3.floatValue()
            float r8 = r1.$velocity
            androidx.compose.material.AnchoredDraggableState<T> r5 = r1.$this_animateTo
            androidx.compose.animation.core.AnimationSpec r9 = r5.getAnimationSpec()
            androidx.compose.material.AnchoredDraggableKt$animateTo$2$1 r5 = new androidx.compose.material.AnchoredDraggableKt$animateTo$2$1
            r5.<init>(r2, r4)
            r10 = r5
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = r1
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r5 = 0
            r1.L$0 = r5
            r5 = 1
            r1.label = r5
            java.lang.Object r2 = androidx.compose.animation.core.SuspendAnimationKt.animate(r6, r7, r8, r9, r10, r11)
            if (r2 != r0) goto L_0x006e
            return r0
        L_0x006e:
            r0 = r1
        L_0x006f:
            r1 = r0
        L_0x0070:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AnchoredDraggableKt$animateTo$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

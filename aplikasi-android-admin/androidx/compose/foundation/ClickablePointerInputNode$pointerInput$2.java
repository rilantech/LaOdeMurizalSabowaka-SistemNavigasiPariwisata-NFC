package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "offset", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.ClickablePointerInputNode$pointerInput$2", f = "Clickable.kt", i = {}, l = {892}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Clickable.kt */
final class ClickablePointerInputNode$pointerInput$2 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ClickablePointerInputNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickablePointerInputNode$pointerInput$2(ClickablePointerInputNode clickablePointerInputNode, Continuation<? super ClickablePointerInputNode$pointerInput$2> continuation) {
        super(3, continuation);
        this.this$0 = clickablePointerInputNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m1920invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m4723unboximpl(), (Continuation) obj3);
    }

    /* renamed from: invoke-d-4ec7I  reason: not valid java name */
    public final Object m1920invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
        ClickablePointerInputNode$pointerInput$2 clickablePointerInputNode$pointerInput$2 = new ClickablePointerInputNode$pointerInput$2(this.this$0, continuation);
        clickablePointerInputNode$pointerInput$2.L$0 = pressGestureScope;
        clickablePointerInputNode$pointerInput$2.J$0 = j;
        return clickablePointerInputNode$pointerInput$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            switch(r1) {
                case 0: goto L_0x0016;
                case 1: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0011:
            r0 = r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0038
        L_0x0016:
            kotlin.ResultKt.throwOnFailure(r9)
            r1 = r8
            java.lang.Object r2 = r1.L$0
            androidx.compose.foundation.gestures.PressGestureScope r2 = (androidx.compose.foundation.gestures.PressGestureScope) r2
            long r3 = r1.J$0
            androidx.compose.foundation.ClickablePointerInputNode r5 = r1.this$0
            boolean r5 = r5.getEnabled()
            if (r5 == 0) goto L_0x0039
            androidx.compose.foundation.ClickablePointerInputNode r5 = r1.this$0
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7 = 1
            r1.label = r7
            java.lang.Object r2 = r5.m1864handlePressInteractiond4ec7I(r2, r3, r6)
            if (r2 != r0) goto L_0x0037
            return r0
        L_0x0037:
            r0 = r1
        L_0x0038:
            r1 = r0
        L_0x0039:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickablePointerInputNode$pointerInput$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

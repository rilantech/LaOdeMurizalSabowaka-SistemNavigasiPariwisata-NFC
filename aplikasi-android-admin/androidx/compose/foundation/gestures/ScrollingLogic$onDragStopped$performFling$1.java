package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1", f = "Scrollable.kt", i = {0, 1, 1, 2, 2}, l = {464, 466, 468}, m = "invokeSuspend", n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, s = {"J$0", "J$0", "J$1", "J$0", "J$1"})
/* compiled from: Scrollable.kt */
final class ScrollingLogic$onDragStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollingLogic$onDragStopped$performFling$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onDragStopped$performFling$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this.this$0, continuation);
        scrollingLogic$onDragStopped$performFling$1.J$0 = ((Velocity) obj).m7788unboximpl();
        return scrollingLogic$onDragStopped$performFling$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m2086invokesFctU(((Velocity) obj).m7788unboximpl(), (Continuation) obj2);
    }

    /* renamed from: invoke-sF-c-tU  reason: not valid java name */
    public final Object m2086invokesFctU(long j, Continuation<? super Velocity> continuation) {
        return ((ScrollingLogic$onDragStopped$performFling$1) create(Velocity.m7770boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006a, code lost:
        r6 = androidx.compose.ui.unit.Velocity.m7782minusAH228Gc(r4, ((androidx.compose.ui.unit.Velocity) r2).m7788unboximpl());
        r1.J$0 = r4;
        r1.J$1 = r6;
        r1.label = 2;
        r2 = r1.this$0.m2074doFlingAnimationQWom1Mo(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0085, code lost:
        if (r2 != r0) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0087, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0088, code lost:
        r16 = r3;
        r3 = r2;
        r2 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x008d, code lost:
        r14 = ((androidx.compose.ui.unit.Velocity) r3).m7788unboximpl();
        r1.J$0 = r4;
        r1.J$1 = r14;
        r1.label = 3;
        r3 = r1.this$0.getNestedScrollDispatcher().getValue().m6071dispatchPostFlingRZ2iAVY(androidx.compose.ui.unit.Velocity.m7782minusAH228Gc(r6, r14), r14, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00b3, code lost:
        if (r3 != r0) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00b5, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b6, code lost:
        r0 = r1;
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00cb, code lost:
        return androidx.compose.ui.unit.Velocity.m7770boximpl(androidx.compose.ui.unit.Velocity.m7782minusAH228Gc(r4, androidx.compose.ui.unit.Velocity.m7782minusAH228Gc(r14, ((androidx.compose.ui.unit.Velocity) r1).m7788unboximpl())));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r18
            int r2 = r1.label
            switch(r2) {
                case 0: goto L_0x0040;
                case 1: goto L_0x0034;
                case 2: goto L_0x0022;
                case 3: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0013:
            r0 = r18
            r1 = r19
            long r2 = r0.J$1
            long r4 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r1)
            r14 = r2
            r2 = r1
            goto L_0x00b8
        L_0x0022:
            r1 = r18
            r2 = r19
            long r3 = r1.J$1
            long r5 = r1.J$0
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r3
            r3 = r2
            r4 = r5
            r6 = r16
            goto L_0x008d
        L_0x0034:
            r1 = r18
            r2 = r19
            long r3 = r1.J$0
            kotlin.ResultKt.throwOnFailure(r2)
            r4 = r3
            r3 = r2
            goto L_0x006a
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r19)
            r1 = r18
            r2 = r19
            long r3 = r1.J$0
            androidx.compose.foundation.gestures.ScrollingLogic r5 = r1.this$0
            androidx.compose.runtime.State r5 = r5.getNestedScrollDispatcher()
            java.lang.Object r5 = r5.getValue()
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r5 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r5
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r1.J$0 = r3
            r7 = 1
            r1.label = r7
            java.lang.Object r5 = r5.m6073dispatchPreFlingQWom1Mo(r3, r6)
            if (r5 != r0) goto L_0x0064
            return r0
        L_0x0064:
            r16 = r3
            r3 = r2
            r2 = r5
            r4 = r16
        L_0x006a:
            androidx.compose.ui.unit.Velocity r2 = (androidx.compose.ui.unit.Velocity) r2
            long r6 = r2.m7788unboximpl()
            long r6 = androidx.compose.ui.unit.Velocity.m7782minusAH228Gc(r4, r6)
            androidx.compose.foundation.gestures.ScrollingLogic r2 = r1.this$0
            r8 = r1
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r1.J$0 = r4
            r1.J$1 = r6
            r9 = 2
            r1.label = r9
            java.lang.Object r2 = r2.m2074doFlingAnimationQWom1Mo(r6, r8)
            if (r2 != r0) goto L_0x0088
            return r0
        L_0x0088:
            r16 = r3
            r3 = r2
            r2 = r16
        L_0x008d:
            androidx.compose.ui.unit.Velocity r3 = (androidx.compose.ui.unit.Velocity) r3
            long r14 = r3.m7788unboximpl()
            androidx.compose.foundation.gestures.ScrollingLogic r3 = r1.this$0
            androidx.compose.runtime.State r3 = r3.getNestedScrollDispatcher()
            java.lang.Object r3 = r3.getValue()
            r8 = r3
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r8 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r8
            long r9 = androidx.compose.ui.unit.Velocity.m7782minusAH228Gc(r6, r14)
            r13 = r1
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r1.J$0 = r4
            r1.J$1 = r14
            r3 = 3
            r1.label = r3
            r11 = r14
            java.lang.Object r3 = r8.m6071dispatchPostFlingRZ2iAVY(r9, r11, r13)
            if (r3 != r0) goto L_0x00b6
            return r0
        L_0x00b6:
            r0 = r1
            r1 = r3
        L_0x00b8:
            androidx.compose.ui.unit.Velocity r1 = (androidx.compose.ui.unit.Velocity) r1
            long r6 = r1.m7788unboximpl()
            long r8 = androidx.compose.ui.unit.Velocity.m7782minusAH228Gc(r14, r6)
            long r10 = androidx.compose.ui.unit.Velocity.m7782minusAH228Gc(r4, r8)
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m7770boximpl(r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

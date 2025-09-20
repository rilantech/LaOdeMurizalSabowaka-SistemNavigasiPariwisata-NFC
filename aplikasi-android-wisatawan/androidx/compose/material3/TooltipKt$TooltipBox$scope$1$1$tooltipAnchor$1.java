package androidx.compose.material3;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1", f = "Tooltip.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Tooltip.kt */
final class TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Job> $onLongPress;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1(Function0<? extends Job> function0, Continuation<? super TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1> continuation) {
        super(2, continuation);
        this.$onLongPress = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1 tooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1 = new TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1(this.$onLongPress, continuation);
        tooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1.L$0 = obj;
        return tooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1$1", f = "Tooltip.kt", i = {0, 0, 0, 1, 1}, l = {217, 221, 229}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "pass", "longPressTimeout", "$this$awaitEachGesture", "pass"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1"})
    /* renamed from: androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1$1  reason: invalid class name */
    /* compiled from: Tooltip.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(function0, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r1.L$0 = r6;
            r1.L$1 = r5;
            r1.label = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x007b, code lost:
            if (r6.withTimeout(r3, new androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1.AnonymousClass1.AnonymousClass1((kotlin.coroutines.Continuation<? super androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1.AnonymousClass1.AnonymousClass1>) null), r1) != r0) goto L_0x007e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x007d, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
            r3 = r5;
            r4 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0082, code lost:
            r3 = r5;
            r4 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0084, code lost:
            r4.invoke();
            r1.L$0 = null;
            r1.L$1 = null;
            r1.label = 3;
            r2 = r4.awaitPointerEvent(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0097, code lost:
            if (r2 == r0) goto L_0x0099;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0099, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x009a, code lost:
            r0 = r14;
            r14 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x009c, code lost:
            r3 = ((androidx.compose.ui.input.pointer.PointerEvent) r14).getChanges().iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ae, code lost:
            if (r3.hasNext() != false) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b0, code lost:
            ((androidx.compose.ui.input.pointer.PointerInputChange) r3.next()).consume();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00bc, code lost:
            r14 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bf, code lost:
            return kotlin.Unit.INSTANCE;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.label
                r2 = 0
                switch(r1) {
                    case 0: goto L_0x0038;
                    case 1: goto L_0x0029;
                    case 2: goto L_0x001a;
                    case 3: goto L_0x0012;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L_0x0012:
                r0 = r13
                kotlin.ResultKt.throwOnFailure(r14)
                r1 = r0
                r0 = r14
                goto L_0x009c
            L_0x001a:
                r1 = r13
                java.lang.Object r3 = r1.L$1
                androidx.compose.ui.input.pointer.PointerEventPass r3 = (androidx.compose.ui.input.pointer.PointerEventPass) r3
                java.lang.Object r4 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0027 }
                goto L_0x0080
            L_0x0027:
                r5 = move-exception
                goto L_0x0084
            L_0x0029:
                r1 = r13
                long r3 = r1.J$0
                java.lang.Object r5 = r1.L$1
                androidx.compose.ui.input.pointer.PointerEventPass r5 = (androidx.compose.ui.input.pointer.PointerEventPass) r5
                java.lang.Object r6 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
                kotlin.ResultKt.throwOnFailure(r14)
                goto L_0x0065
            L_0x0038:
                kotlin.ResultKt.throwOnFailure(r14)
                r1 = r13
                java.lang.Object r3 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                androidx.compose.ui.platform.ViewConfiguration r4 = r3.getViewConfiguration()
                long r10 = r4.getLongPressTimeoutMillis()
                androidx.compose.ui.input.pointer.PointerEventPass r12 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                r7 = r1
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r1.L$0 = r3
                r1.L$1 = r12
                r1.J$0 = r10
                r4 = 1
                r1.label = r4
                r5 = 0
                r8 = 1
                r9 = 0
                r4 = r3
                r6 = r12
                java.lang.Object r4 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r4, r5, r6, r7, r8, r9)
                if (r4 != r0) goto L_0x0062
                return r0
            L_0x0062:
                r6 = r3
                r3 = r10
                r5 = r12
            L_0x0065:
                androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1$1$1 r7 = new androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1$1$1     // Catch:{ PointerEventTimeoutCancellationException -> 0x0081 }
                r7.<init>(r5, r2)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0081 }
                kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch:{ PointerEventTimeoutCancellationException -> 0x0081 }
                r8 = r1
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch:{ PointerEventTimeoutCancellationException -> 0x0081 }
                r1.L$0 = r6     // Catch:{ PointerEventTimeoutCancellationException -> 0x0081 }
                r1.L$1 = r5     // Catch:{ PointerEventTimeoutCancellationException -> 0x0081 }
                r9 = 2
                r1.label = r9     // Catch:{ PointerEventTimeoutCancellationException -> 0x0081 }
                java.lang.Object r2 = r6.withTimeout(r3, r7, r8)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0081 }
                if (r2 != r0) goto L_0x007e
                return r0
            L_0x007e:
                r3 = r5
                r4 = r6
            L_0x0080:
                goto L_0x00bd
            L_0x0081:
                r3 = move-exception
                r3 = r5
                r4 = r6
            L_0x0084:
                kotlin.jvm.functions.Function0<kotlinx.coroutines.Job> r5 = r4
                r5.invoke()
                r5 = r1
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r1.L$0 = r2
                r1.L$1 = r2
                r2 = 3
                r1.label = r2
                java.lang.Object r2 = r4.awaitPointerEvent(r3, r5)
                if (r2 != r0) goto L_0x009a
                return r0
            L_0x009a:
                r0 = r14
                r14 = r2
            L_0x009c:
                androidx.compose.ui.input.pointer.PointerEvent r14 = (androidx.compose.ui.input.pointer.PointerEvent) r14
                java.util.List r2 = r14.getChanges()
                r14 = r2
                java.lang.Iterable r14 = (java.lang.Iterable) r14
                r2 = 0
                java.util.Iterator r3 = r14.iterator()
            L_0x00aa:
                boolean r14 = r3.hasNext()
                if (r14 == 0) goto L_0x00bc
                java.lang.Object r14 = r3.next()
                r4 = r14
                androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                r5 = 0
                r4.consume()
                goto L_0x00aa
            L_0x00bc:
                r14 = r0
            L_0x00bd:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final Function0<Job> function0 = this.$onLongPress;
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture((PointerInputScope) this.L$0, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}

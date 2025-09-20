package androidx.compose.foundation;

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
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1", f = "AndroidOverscroll.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AndroidOverscroll.kt */
final class AndroidEdgeEffectOverscrollEffect$effectModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidEdgeEffectOverscrollEffect$effectModifier$1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super AndroidEdgeEffectOverscrollEffect$effectModifier$1> continuation) {
        super(2, continuation);
        this.this$0 = androidEdgeEffectOverscrollEffect;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidEdgeEffectOverscrollEffect$effectModifier$1 androidEdgeEffectOverscrollEffect$effectModifier$1 = new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this.this$0, continuation);
        androidEdgeEffectOverscrollEffect$effectModifier$1.L$0 = obj;
        return androidEdgeEffectOverscrollEffect$effectModifier$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((AndroidEdgeEffectOverscrollEffect$effectModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1", f = "AndroidOverscroll.kt", i = {0, 1}, l = {317, 321}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0"})
    /* renamed from: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1  reason: invalid class name */
    /* compiled from: AndroidOverscroll.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(androidEdgeEffectOverscrollEffect, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v6, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0056, code lost:
            r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2;
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$setPointerId$p(r4, androidx.compose.ui.input.pointer.PointerId.m4460boximpl(r2.m4479getIdJ3iCeTQ()));
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$setPointerPosition$p(r4, androidx.compose.ui.geometry.Offset.m2992boximpl(r2.m4480getPositionF1C5BW0()));
            r2 = r5;
            r5 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0074, code lost:
            r1.L$0 = r5;
            r1.label = 2;
            r6 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r5, r3, r1, r4, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0080, code lost:
            if (r6 != r0) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0082, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0083, code lost:
            r18 = r5;
            r5 = r2;
            r2 = r6;
            r6 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0089, code lost:
            r2 = ((androidx.compose.ui.input.pointer.PointerEvent) r2).getChanges();
            r8 = new java.util.ArrayList(r2.size());
            r10 = 0;
            r11 = r2.size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a2, code lost:
            if (r10 >= r11) goto L_0x00bf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a4, code lost:
            r12 = r2.get(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b2, code lost:
            if (r12.getPressed() == false) goto L_0x00ba;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b4, code lost:
            r8.add(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00ba, code lost:
            r10 = r10 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00bf, code lost:
            r2 = r8;
            r7 = r2;
            r8 = r4;
            r11 = 0;
            r12 = r7.size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d1, code lost:
            if (r11 >= r12) goto L_0x00f8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d3, code lost:
            r14 = r7.get(r11);
            r19 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ed, code lost:
            if (androidx.compose.ui.input.pointer.PointerId.m4462equalsimpl(r14.m4479getIdJ3iCeTQ(), androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$getPointerId$p(r8)) == false) goto L_0x00f0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f0, code lost:
            r11 = r11 + 1;
            r5 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f8, code lost:
            r19 = r5;
            r14 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00fc, code lost:
            r14 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00fe, code lost:
            if (r14 != null) goto L_0x0107;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0100, code lost:
            r14 = kotlin.collections.CollectionsKt.firstOrNull(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0107, code lost:
            r3 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0108, code lost:
            if (r3 == null) goto L_0x0124;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x010a, code lost:
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$setPointerId$p(r4, androidx.compose.ui.input.pointer.PointerId.m4460boximpl(r3.m4479getIdJ3iCeTQ()));
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$setPointerPosition$p(r4, androidx.compose.ui.geometry.Offset.m2992boximpl(r3.m4480getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x012b, code lost:
            if (r2.isEmpty() != false) goto L_0x012f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x012d, code lost:
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x012f, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0130, code lost:
            if (r2 != false) goto L_0x013b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0132, code lost:
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$setPointerId$p(r4, (androidx.compose.ui.input.pointer.PointerId) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x013a, code lost:
            return kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x013b, code lost:
            r3 = null;
            r5 = r6;
            r4 = 1;
            r2 = r19;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                r1 = r19
                int r2 = r1.label
                r3 = 0
                r4 = 1
                switch(r2) {
                    case 0: goto L_0x0032;
                    case 1: goto L_0x0024;
                    case 2: goto L_0x0015;
                    default: goto L_0x000d;
                }
            L_0x000d:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0015:
                r1 = r19
                r2 = r20
                java.lang.Object r5 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                kotlin.ResultKt.throwOnFailure(r2)
                r6 = r5
                r5 = r2
                goto L_0x0089
            L_0x0024:
                r1 = r19
                r2 = r20
                java.lang.Object r5 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                kotlin.ResultKt.throwOnFailure(r2)
                r6 = r5
                r5 = r2
                goto L_0x0056
            L_0x0032:
                kotlin.ResultKt.throwOnFailure(r20)
                r1 = r19
                r2 = r20
                java.lang.Object r5 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                r9 = r1
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r1.L$0 = r5
                r1.label = r4
                r7 = 0
                r8 = 0
                r10 = 2
                r11 = 0
                r6 = r5
                java.lang.Object r6 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r6, r7, r8, r9, r10, r11)
                if (r6 != r0) goto L_0x0050
                return r0
            L_0x0050:
                r18 = r5
                r5 = r2
                r2 = r6
                r6 = r18
            L_0x0056:
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r7 = r4
                long r8 = r2.m4479getIdJ3iCeTQ()
                androidx.compose.ui.input.pointer.PointerId r8 = androidx.compose.ui.input.pointer.PointerId.m4460boximpl(r8)
                r7.pointerId = r8
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r7 = r4
                long r8 = r2.m4480getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.m2992boximpl(r8)
                r7.pointerPosition = r8
                r2 = r5
                r5 = r6
            L_0x0074:
                r6 = r1
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r1.L$0 = r5
                r7 = 2
                r1.label = r7
                java.lang.Object r6 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r5, r3, r6, r4, r3)
                if (r6 != r0) goto L_0x0083
                return r0
            L_0x0083:
                r18 = r5
                r5 = r2
                r2 = r6
                r6 = r18
            L_0x0089:
                androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
                java.util.List r2 = r2.getChanges()
                r7 = 0
                java.util.ArrayList r8 = new java.util.ArrayList
                int r9 = r2.size()
                r8.<init>(r9)
                r9 = 0
                r10 = 0
                int r11 = r2.size()
            L_0x00a2:
                if (r10 >= r11) goto L_0x00bf
                java.lang.Object r12 = r2.get(r10)
                r13 = 0
                r14 = r12
                androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
                r15 = 0
                boolean r14 = r14.getPressed()
                if (r14 == 0) goto L_0x00ba
                r14 = r8
                java.util.Collection r14 = (java.util.Collection) r14
                r14.add(r12)
            L_0x00ba:
                int r10 = r10 + 1
                goto L_0x00a2
            L_0x00bf:
                r2 = r8
                java.util.List r2 = (java.util.List) r2
                r7 = r2
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r8 = r4
                r9 = 0
                r10 = 0
                r11 = 0
                int r12 = r7.size()
            L_0x00d1:
                if (r11 >= r12) goto L_0x00f8
                java.lang.Object r13 = r7.get(r11)
                r14 = r13
                r15 = 0
                r16 = r14
                androidx.compose.ui.input.pointer.PointerInputChange r16 = (androidx.compose.ui.input.pointer.PointerInputChange) r16
                r17 = 0
                r19 = r5
                long r4 = r16.m4479getIdJ3iCeTQ()
                androidx.compose.ui.input.pointer.PointerId r3 = r8.pointerId
                boolean r3 = androidx.compose.ui.input.pointer.PointerId.m4462equalsimpl(r4, r3)
                if (r3 == 0) goto L_0x00f0
                goto L_0x00fc
            L_0x00f0:
                int r11 = r11 + 1
                r3 = 0
                r4 = 1
                r5 = r19
                goto L_0x00d1
            L_0x00f8:
                r19 = r5
                r14 = 0
            L_0x00fc:
                androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
                if (r14 != 0) goto L_0x0107
                java.lang.Object r3 = kotlin.collections.CollectionsKt.firstOrNull(r2)
                r14 = r3
                androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            L_0x0107:
                r3 = r14
                if (r3 == 0) goto L_0x0124
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r4 = r4
                long r7 = r3.m4479getIdJ3iCeTQ()
                androidx.compose.ui.input.pointer.PointerId r5 = androidx.compose.ui.input.pointer.PointerId.m4460boximpl(r7)
                r4.pointerId = r5
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r4 = r4
                long r7 = r3.m4480getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.m2992boximpl(r7)
                r4.pointerPosition = r5
            L_0x0124:
                r3 = r2
                java.util.Collection r3 = (java.util.Collection) r3
                boolean r3 = r3.isEmpty()
                if (r3 != 0) goto L_0x012f
                r2 = 1
                goto L_0x0130
            L_0x012f:
                r2 = 0
            L_0x0130:
                if (r2 != 0) goto L_0x013b
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r0 = r4
                r2 = 0
                r0.pointerId = r2
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x013b:
                r2 = 0
                r3 = r2
                r5 = r6
                r4 = 1
                r2 = r19
                goto L_0x0074
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = this.this$0;
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

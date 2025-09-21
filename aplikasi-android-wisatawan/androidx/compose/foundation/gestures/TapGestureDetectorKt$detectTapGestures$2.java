package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", f = "TapGestureDetector.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TapGestureDetector.kt */
final class TapGestureDetectorKt$detectTapGestures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
    final /* synthetic */ Function1<Offset, Unit> $onLongPress;
    final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
    final /* synthetic */ Function1<Offset, Unit> $onTap;
    final /* synthetic */ PointerInputScope $this_detectTapGestures;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TapGestureDetectorKt$detectTapGestures$2(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function1<? super Offset, Unit> function13, Continuation<? super TapGestureDetectorKt$detectTapGestures$2> continuation) {
        super(2, continuation);
        this.$this_detectTapGestures = pointerInputScope;
        this.$onPress = function3;
        this.$onLongPress = function1;
        this.$onDoubleTap = function12;
        this.$onTap = function13;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TapGestureDetectorKt$detectTapGestures$2 tapGestureDetectorKt$detectTapGestures$2 = new TapGestureDetectorKt$detectTapGestures$2(this.$this_detectTapGestures, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, continuation);
        tapGestureDetectorKt$detectTapGestures$2.L$0 = obj;
        return tapGestureDetectorKt$detectTapGestures$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TapGestureDetectorKt$detectTapGestures$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final PressGestureScopeImpl pressScope = new PressGestureScopeImpl(this.$this_detectTapGestures);
                PointerInputScope pointerInputScope = this.$this_detectTapGestures;
                final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                final Function1<Offset, Unit> function1 = this.$onLongPress;
                final Function1<Offset, Unit> function12 = this.$onDoubleTap;
                final Function1<Offset, Unit> function13 = this.$onTap;
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) != coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", f = "TapGestureDetector.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {100, 114, 129, 141, 156, 178}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "secondDown"}, s = {"L$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2"})
    /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1  reason: invalid class name */
    /* compiled from: TapGestureDetector.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(coroutineScope, function3, function1, function12, function13, pressScope, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v50, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v26, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v52, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v20, resolved type: androidx.compose.ui.input.pointer.AwaitPointerEventScope} */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00c3, code lost:
            r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r2;
            r8.consume();
            r10 = r4;
            r2 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r10, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass1((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass1>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e2, code lost:
            if (r5 == androidx.compose.foundation.gestures.TapGestureDetectorKt.NoPressGesture) goto L_0x00f9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e4, code lost:
            r10 = r4;
            r2 = r5;
            r6 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r10, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass2((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass2>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00fb, code lost:
            if (r6 == null) goto L_0x0107;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00fd, code lost:
            r6 = r9.getViewConfiguration().getLongPressTimeoutMillis();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0107, code lost:
            r6 = kotlin.time.DurationKt.MAX_MILLIS;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x010c, code lost:
            r2 = new kotlin.jvm.internal.Ref.ObjectRef();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            r4.L$0 = r9;
            r4.L$1 = r8;
            r4.L$2 = r2;
            r4.L$3 = r2;
            r4.J$0 = r6;
            r4.label = 2;
            r0 = r9.withTimeout(r6, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass3((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass3>) null), r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x012f, code lost:
            if (r0 != r1) goto L_0x0132;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0131, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0132, code lost:
            r10 = r9;
            r9 = r8;
            r8 = r2;
            r2 = r4;
            r4 = r0;
            r0 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            r0.element = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x013c, code lost:
            if (r8.element != null) goto L_0x0153;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x013e, code lost:
            r11 = r4;
            r4 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r11, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass4((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass4>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0153, code lost:
            r8.element.consume();
            r11 = r4;
            r4 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r11, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass5((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass5>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x016e, code lost:
            r0 = r5;
            r4 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0172, code lost:
            r0 = r2;
            r2 = r5;
            r4 = r6;
            r6 = r8;
            r8 = r9;
            r7 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x017a, code lost:
            r0 = r4;
            r22 = r6;
            r6 = r2;
            r2 = r5;
            r4 = r22;
            r7 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0186, code lost:
            r9.invoke(androidx.compose.ui.geometry.Offset.m2992boximpl(r8.m4480getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x01a8, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x01c9, code lost:
            if (r7 == null) goto L_0x01cb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x01cb, code lost:
            r1 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x01cd, code lost:
            if (r1 != null) goto L_0x01cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x01cf, code lost:
            r1.invoke(androidx.compose.ui.geometry.Offset.m2992boximpl(r8.element.m4480getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x01e2, code lost:
            r2.L$0 = r10;
            r2.L$1 = r8;
            r2.L$2 = null;
            r2.L$3 = null;
            r2.J$0 = r4;
            r2.label = 4;
            r6 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitSecondDown(r10, r8.element, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x01fa, code lost:
            if (r6 == r1) goto L_0x01fc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x01fc, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x01fd, code lost:
            r7 = r0;
            r15 = r8;
            r14 = r10;
            r22 = r4;
            r4 = r2;
            r2 = r6;
            r5 = r22;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0206, code lost:
            r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0208, code lost:
            if (r2 == null) goto L_0x020a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x020a, code lost:
            r0 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x020c, code lost:
            if (r0 != null) goto L_0x020e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x020e, code lost:
            r0.invoke(androidx.compose.ui.geometry.Offset.m2992boximpl(r15.element.m4480getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x021e, code lost:
            r2 = r4;
            r0 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0222, code lost:
            r8 = r4;
            r9 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r8, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass7((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass7>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x023b, code lost:
            if (r5 != androidx.compose.foundation.gestures.TapGestureDetectorKt.NoPressGesture) goto L_0x023d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x023d, code lost:
            r0 = r4;
            r9 = r5;
            r10 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r0, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass8((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass8>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
            r9 = r4;
            r10 = r7;
            r11 = r8;
            r13 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0264, code lost:
            r8 = r8;
            r12 = r15;
            r3 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            r8 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass9((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass9>) null);
            r4.L$0 = r3;
            r4.L$1 = r15;
            r4.L$2 = r2;
            r4.label = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0280, code lost:
            if (r3.withTimeout(r5, r8, r4) == r1) goto L_0x0282;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0282, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0283, code lost:
            r5 = r2;
            r2 = r4;
            r4 = r7;
            r6 = r15;
            r7 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x0288, code lost:
            r0 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x028b, code lost:
            r5 = r2;
            r0 = r4;
            r6 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0290, code lost:
            r3 = r14;
            r5 = r2;
            r0 = r4;
            r6 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0294, code lost:
            r2 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0296, code lost:
            if (r2 != null) goto L_0x0298;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x0298, code lost:
            r2.invoke(androidx.compose.ui.geometry.Offset.m2992boximpl(r6.element.m4480getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x02a8, code lost:
            r2 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x02aa, code lost:
            if (r2 != null) goto L_0x02ac;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x02ac, code lost:
            r2.invoke(androidx.compose.ui.geometry.Offset.m2992boximpl(r5.m4480getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x02b8, code lost:
            r0.L$0 = null;
            r0.L$1 = null;
            r0.L$2 = null;
            r0.label = 6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x02c9, code lost:
            if (androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(r3, r0) != r1) goto L_0x02cc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x02cb, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x02cc, code lost:
            r1 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x02cd, code lost:
            r2 = r4;
            r4 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r2, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass10((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass10>) null), 3, (java.lang.Object) null);
            r2 = r0;
            r0 = r1;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0186  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x01a8 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x01c7  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x0298  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x02ac  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x02cb A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x02cc  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                r24 = this;
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                r0 = r24
                int r2 = r0.label
                r3 = 0
                switch(r2) {
                    case 0: goto L_0x009d;
                    case 1: goto L_0x008e;
                    case 2: goto L_0x0066;
                    case 3: goto L_0x0053;
                    case 4: goto L_0x003b;
                    case 5: goto L_0x001d;
                    case 6: goto L_0x0014;
                    default: goto L_0x000c;
                }
            L_0x000c:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0014:
                r0 = r24
                r1 = r25
                kotlin.ResultKt.throwOnFailure(r1)
                goto L_0x02cd
            L_0x001d:
                r2 = r24
                r4 = r25
                java.lang.Object r0 = r2.L$2
                r5 = r0
                androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
                java.lang.Object r0 = r2.L$1
                r6 = r0
                kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
                java.lang.Object r0 = r2.L$0
                r7 = r0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
                kotlin.ResultKt.throwOnFailure(r4)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0035 }
                goto L_0x0288
            L_0x0035:
                r0 = move-exception
                r0 = r2
                r3 = r7
                r7 = r4
                goto L_0x0294
            L_0x003b:
                r0 = r24
                r2 = r25
                long r4 = r0.J$0
                java.lang.Object r6 = r0.L$1
                kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
                java.lang.Object r7 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
                kotlin.ResultKt.throwOnFailure(r2)
                r15 = r6
                r14 = r7
                r7 = r2
                r5 = r4
                r4 = r0
                goto L_0x0206
            L_0x0053:
                r0 = r24
                r2 = r25
                long r4 = r0.J$0
                java.lang.Object r6 = r0.L$1
                kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
                java.lang.Object r7 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
                kotlin.ResultKt.throwOnFailure(r2)
                goto L_0x01a9
            L_0x0066:
                r2 = r24
                r4 = r25
                long r5 = r2.J$0
                java.lang.Object r0 = r2.L$3
                kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
                java.lang.Object r7 = r2.L$2
                kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
                java.lang.Object r8 = r2.L$1
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                java.lang.Object r9 = r2.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
                kotlin.ResultKt.throwOnFailure(r4)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0086 }
                r10 = r9
                r9 = r8
                r8 = r7
                r6 = r5
                r5 = r4
                goto L_0x0138
            L_0x0086:
                r0 = move-exception
                r0 = r2
                r2 = r4
                r4 = r5
                r6 = r7
                r7 = r9
                goto L_0x0182
            L_0x008e:
                r0 = r24
                r2 = r25
                java.lang.Object r4 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                kotlin.ResultKt.throwOnFailure(r2)
                r5 = r2
                r9 = r4
                r4 = r0
                goto L_0x00c3
            L_0x009d:
                kotlin.ResultKt.throwOnFailure(r25)
                r0 = r24
                r2 = r25
                java.lang.Object r4 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                r8 = r0
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r0.L$0 = r4
                r5 = 1
                r0.label = r5
                r6 = 0
                r7 = 0
                r9 = 3
                r10 = 0
                r5 = r4
                java.lang.Object r5 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
                if (r5 != r1) goto L_0x00bc
                return r1
            L_0x00bc:
                r9 = r4
                r4 = r0
                r22 = r5
                r5 = r2
                r2 = r22
            L_0x00c3:
                r8 = r2
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                r8.consume()
                kotlinx.coroutines.CoroutineScope r10 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1
                androidx.compose.foundation.gestures.PressGestureScopeImpl r2 = r9
                r0.<init>(r2, r3)
                r13 = r0
                kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
                r14 = 3
                r15 = 0
                r11 = 0
                r12 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r10, r11, r12, r13, r14, r15)
                kotlin.jvm.functions.Function3<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r0 = r5
                kotlin.jvm.functions.Function3 r2 = androidx.compose.foundation.gestures.TapGestureDetectorKt.NoPressGesture
                if (r0 == r2) goto L_0x00f9
                kotlinx.coroutines.CoroutineScope r10 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2
                kotlin.jvm.functions.Function3<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r2 = r5
                androidx.compose.foundation.gestures.PressGestureScopeImpl r6 = r9
                r0.<init>(r2, r6, r8, r3)
                r13 = r0
                kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
                r14 = 3
                r15 = 0
                r11 = 0
                r12 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r10, r11, r12, r13, r14, r15)
            L_0x00f9:
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r0 = r6
                if (r0 == 0) goto L_0x0107
                r0 = 0
                androidx.compose.ui.platform.ViewConfiguration r2 = r9.getViewConfiguration()
                long r6 = r2.getLongPressTimeoutMillis()
                goto L_0x010c
            L_0x0107:
                r6 = 4611686018427387903(0x3fffffffffffffff, double:1.9999999999999998)
            L_0x010c:
                kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
                r0.<init>()
                r2 = r0
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3     // Catch:{ PointerEventTimeoutCancellationException -> 0x0179 }
                r0.<init>(r3)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0179 }
                kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0     // Catch:{ PointerEventTimeoutCancellationException -> 0x0179 }
                r10 = r4
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch:{ PointerEventTimeoutCancellationException -> 0x0179 }
                r4.L$0 = r9     // Catch:{ PointerEventTimeoutCancellationException -> 0x0179 }
                r4.L$1 = r8     // Catch:{ PointerEventTimeoutCancellationException -> 0x0179 }
                r4.L$2 = r2     // Catch:{ PointerEventTimeoutCancellationException -> 0x0179 }
                r4.L$3 = r2     // Catch:{ PointerEventTimeoutCancellationException -> 0x0179 }
                r4.J$0 = r6     // Catch:{ PointerEventTimeoutCancellationException -> 0x0179 }
                r11 = 2
                r4.label = r11     // Catch:{ PointerEventTimeoutCancellationException -> 0x0179 }
                java.lang.Object r0 = r9.withTimeout(r6, r0, r10)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0179 }
                if (r0 != r1) goto L_0x0132
                return r1
            L_0x0132:
                r10 = r9
                r9 = r8
                r8 = r2
                r2 = r4
                r4 = r0
                r0 = r8
            L_0x0138:
                r0.element = r4     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                T r0 = r8.element     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                if (r0 != 0) goto L_0x0153
                kotlinx.coroutines.CoroutineScope r11 = r4     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                androidx.compose.foundation.gestures.PressGestureScopeImpl r4 = r9     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                r0.<init>(r4, r3)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                r14 = r0
                kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                r15 = 3
                r16 = 0
                r12 = 0
                r13 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r11, r12, r13, r14, r15, r16)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                goto L_0x016e
            L_0x0153:
                T r0 = r8.element     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                r0.consume()     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                kotlinx.coroutines.CoroutineScope r11 = r4     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                androidx.compose.foundation.gestures.PressGestureScopeImpl r4 = r9     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                r0.<init>(r4, r3)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                r14 = r0
                kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
                r15 = 3
                r16 = 0
                r12 = 0
                r13 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r11, r12, r13, r14, r15, r16)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0171 }
            L_0x016e:
                r0 = r5
                r4 = r6
                goto L_0x01c3
            L_0x0171:
                r0 = move-exception
                r0 = r2
                r2 = r5
                r4 = r6
                r6 = r8
                r8 = r9
                r7 = r10
                goto L_0x0182
            L_0x0179:
                r0 = move-exception
                r0 = r4
                r22 = r6
                r6 = r2
                r2 = r5
                r4 = r22
                r7 = r9
            L_0x0182:
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r9 = r6
                if (r9 == 0) goto L_0x0192
                long r10 = r8.m4480getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r10 = androidx.compose.ui.geometry.Offset.m2992boximpl(r10)
                r9.invoke(r10)
            L_0x0192:
                r8 = r0
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r0.L$0 = r7
                r0.L$1 = r6
                r0.L$2 = r3
                r0.L$3 = r3
                r0.J$0 = r4
                r9 = 3
                r0.label = r9
                java.lang.Object r8 = androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(r7, r8)
                if (r8 != r1) goto L_0x01a9
                return r1
            L_0x01a9:
                kotlinx.coroutines.CoroutineScope r8 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6 r9 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6
                androidx.compose.foundation.gestures.PressGestureScopeImpl r10 = r9
                r9.<init>(r10, r3)
                r11 = r9
                kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
                r12 = 3
                r13 = 0
                r9 = 0
                r10 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r8, r9, r10, r11, r12, r13)
                r8 = r6
                r10 = r7
                r22 = r2
                r2 = r0
                r0 = r22
            L_0x01c3:
                T r6 = r8.element
                if (r6 == 0) goto L_0x02e3
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r6 = r7
                if (r6 != 0) goto L_0x01e2
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r1 = r8
                if (r1 == 0) goto L_0x01e0
                T r3 = r8.element
                androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3
                long r3 = r3.m4480getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r3 = androidx.compose.ui.geometry.Offset.m2992boximpl(r3)
                r1.invoke(r3)
                goto L_0x02e3
            L_0x01e0:
                goto L_0x02e3
            L_0x01e2:
                T r6 = r8.element
                androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
                r7 = r2
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r2.L$0 = r10
                r2.L$1 = r8
                r2.L$2 = r3
                r2.L$3 = r3
                r2.J$0 = r4
                r9 = 4
                r2.label = r9
                java.lang.Object r6 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitSecondDown(r10, r6, r7)
                if (r6 != r1) goto L_0x01fd
                return r1
            L_0x01fd:
                r7 = r0
                r15 = r8
                r14 = r10
                r22 = r4
                r4 = r2
                r2 = r6
                r5 = r22
            L_0x0206:
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
                if (r2 != 0) goto L_0x0222
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r0 = r8
                if (r0 == 0) goto L_0x021e
                T r1 = r15.element
                androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                long r1 = r1.m4480getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m2992boximpl(r1)
                r0.invoke(r1)
            L_0x021e:
                r2 = r4
                r0 = r7
                goto L_0x02e3
            L_0x0222:
                kotlinx.coroutines.CoroutineScope r8 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7
                androidx.compose.foundation.gestures.PressGestureScopeImpl r9 = r9
                r0.<init>(r9, r3)
                r11 = r0
                kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
                r12 = 3
                r13 = 0
                r9 = 0
                r10 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r8, r9, r10, r11, r12, r13)
                kotlin.jvm.functions.Function3<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r0 = r5
                kotlin.jvm.functions.Function3 r8 = androidx.compose.foundation.gestures.TapGestureDetectorKt.NoPressGesture
                if (r0 == r8) goto L_0x0259
                kotlinx.coroutines.CoroutineScope r0 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8 r8 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8
                kotlin.jvm.functions.Function3<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r9 = r5
                androidx.compose.foundation.gestures.PressGestureScopeImpl r10 = r9
                r8.<init>(r9, r10, r2, r3)
                r19 = r8
                kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19
                r20 = 3
                r21 = 0
                r17 = 0
                r18 = 0
                r16 = r0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r16, r17, r18, r19, r20, r21)
            L_0x0259:
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9     // Catch:{ PointerEventTimeoutCancellationException -> 0x028f }
                kotlinx.coroutines.CoroutineScope r9 = r4     // Catch:{ PointerEventTimeoutCancellationException -> 0x028f }
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r10 = r7     // Catch:{ PointerEventTimeoutCancellationException -> 0x028f }
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r11 = r8     // Catch:{ PointerEventTimeoutCancellationException -> 0x028f }
                androidx.compose.foundation.gestures.PressGestureScopeImpl r13 = r9     // Catch:{ PointerEventTimeoutCancellationException -> 0x028f }
                r16 = 0
                r8 = r0
                r12 = r15
                r3 = r14
                r14 = r16
                r8.<init>(r9, r10, r11, r12, r13, r14)     // Catch:{ PointerEventTimeoutCancellationException -> 0x028a }
                kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0     // Catch:{ PointerEventTimeoutCancellationException -> 0x028a }
                r8 = r4
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch:{ PointerEventTimeoutCancellationException -> 0x028a }
                r4.L$0 = r3     // Catch:{ PointerEventTimeoutCancellationException -> 0x028a }
                r4.L$1 = r15     // Catch:{ PointerEventTimeoutCancellationException -> 0x028a }
                r4.L$2 = r2     // Catch:{ PointerEventTimeoutCancellationException -> 0x028a }
                r9 = 5
                r4.label = r9     // Catch:{ PointerEventTimeoutCancellationException -> 0x028a }
                java.lang.Object r0 = r3.withTimeout(r5, r0, r8)     // Catch:{ PointerEventTimeoutCancellationException -> 0x028a }
                if (r0 != r1) goto L_0x0283
                return r1
            L_0x0283:
                r5 = r2
                r2 = r4
                r4 = r7
                r6 = r15
                r7 = r3
            L_0x0288:
                r0 = r4
                goto L_0x02e3
            L_0x028a:
                r0 = move-exception
                r5 = r2
                r0 = r4
                r6 = r15
                goto L_0x0294
            L_0x028f:
                r0 = move-exception
                r3 = r14
                r5 = r2
                r0 = r4
                r6 = r15
            L_0x0294:
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r2 = r8
                if (r2 == 0) goto L_0x02a8
                T r4 = r6.element
                androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                long r8 = r4.m4480getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m2992boximpl(r8)
                r2.invoke(r4)
            L_0x02a8:
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r2 = r6
                if (r2 == 0) goto L_0x02b8
                long r8 = r5.m4480getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m2992boximpl(r8)
                r2.invoke(r4)
            L_0x02b8:
                r2 = r0
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r4 = 0
                r0.L$0 = r4
                r0.L$1 = r4
                r0.L$2 = r4
                r4 = 6
                r0.label = r4
                java.lang.Object r2 = androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(r3, r2)
                if (r2 != r1) goto L_0x02cc
                return r1
            L_0x02cc:
                r1 = r7
            L_0x02cd:
                kotlinx.coroutines.CoroutineScope r2 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10 r3 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10
                androidx.compose.foundation.gestures.PressGestureScopeImpl r4 = r9
                r5 = 0
                r3.<init>(r4, r5)
                r5 = r3
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                r6 = 3
                r7 = 0
                r3 = 0
                r4 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r2, r3, r4, r5, r6, r7)
                r2 = r0
                r0 = r1
            L_0x02e3:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}

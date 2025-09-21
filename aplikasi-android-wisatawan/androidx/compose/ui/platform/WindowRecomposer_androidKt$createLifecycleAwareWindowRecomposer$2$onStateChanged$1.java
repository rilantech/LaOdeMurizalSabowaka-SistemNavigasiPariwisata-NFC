package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", f = "WindowRecomposer.android.kt", i = {0}, l = {394}, m = "invokeSuspend", n = {"durationScaleJob"}, s = {"L$0"})
/* compiled from: WindowRecomposer.android.kt */
final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 $self;
    final /* synthetic */ LifecycleOwner $source;
    final /* synthetic */ Ref.ObjectRef<MotionDurationScaleImpl> $systemDurationScaleSettingConsumer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(Ref.ObjectRef<MotionDurationScaleImpl> objectRef, Recomposer recomposer, LifecycleOwner lifecycleOwner, WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2, View view, Continuation<? super WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1> continuation) {
        super(2, continuation);
        this.$systemDurationScaleSettingConsumer = objectRef;
        this.$recomposer = recomposer;
        this.$source = lifecycleOwner;
        this.$self = windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2;
        this.$this_createLifecycleAwareWindowRecomposer = view;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 = new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(this.$systemDurationScaleSettingConsumer, this.$recomposer, this.$source, this.$self, this.$this_createLifecycleAwareWindowRecomposer, continuation);
        windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.L$0 = obj;
        return windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: kotlinx.coroutines.Job} */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0082, code lost:
        if (r5 == null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0084, code lost:
        kotlinx.coroutines.Job.DefaultImpls.cancel$default(r5, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0087, code lost:
        r1.$source.getLifecycle().removeObserver(r1.$self);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0097, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r16
            int r2 = r1.label
            r3 = 1
            r4 = 0
            switch(r2) {
                case 0: goto L_0x0025;
                case 1: goto L_0x0015;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0015:
            r1 = r16
            r2 = r17
            java.lang.Object r0 = r1.L$0
            r5 = r0
            kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0022 }
            goto L_0x0081
        L_0x0022:
            r0 = move-exception
            goto L_0x009a
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r17)
            r1 = r16
            r2 = r17
            java.lang.Object r5 = r1.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            r12 = 0
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.platform.MotionDurationScaleImpl> r6 = r1.$systemDurationScaleSettingConsumer     // Catch:{ all -> 0x0098 }
            T r6 = r6.element     // Catch:{ all -> 0x0098 }
            androidx.compose.ui.platform.MotionDurationScaleImpl r6 = (androidx.compose.ui.platform.MotionDurationScaleImpl) r6     // Catch:{ all -> 0x0098 }
            if (r6 == 0) goto L_0x006f
            android.view.View r7 = r1.$this_createLifecycleAwareWindowRecomposer     // Catch:{ all -> 0x0098 }
            r13 = r6
            r14 = 0
            android.content.Context r6 = r7.getContext()     // Catch:{ all -> 0x0098 }
            android.content.Context r6 = r6.getApplicationContext()     // Catch:{ all -> 0x0098 }
            java.lang.String r7 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ all -> 0x0098 }
            kotlinx.coroutines.flow.StateFlow r6 = androidx.compose.ui.platform.WindowRecomposer_androidKt.getAnimationScaleFlowFor(r6)     // Catch:{ all -> 0x0098 }
            r15 = r6
            java.lang.Object r6 = r15.getValue()     // Catch:{ all -> 0x0098 }
            java.lang.Number r6 = (java.lang.Number) r6     // Catch:{ all -> 0x0098 }
            float r6 = r6.floatValue()     // Catch:{ all -> 0x0098 }
            r13.setScaleFactor(r6)     // Catch:{ all -> 0x0098 }
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1 r6 = new androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1     // Catch:{ all -> 0x0098 }
            r6.<init>(r15, r13, r4)     // Catch:{ all -> 0x0098 }
            r9 = r6
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9     // Catch:{ all -> 0x0098 }
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            r6 = r5
            kotlinx.coroutines.Job r6 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0098 }
            goto L_0x0070
        L_0x006f:
            r6 = r4
        L_0x0070:
            r5 = r6
            androidx.compose.runtime.Recomposer r6 = r1.$recomposer     // Catch:{ all -> 0x0022 }
            r7 = r1
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch:{ all -> 0x0022 }
            r1.L$0 = r5     // Catch:{ all -> 0x0022 }
            r1.label = r3     // Catch:{ all -> 0x0022 }
            java.lang.Object r6 = r6.runRecomposeAndApplyChanges(r7)     // Catch:{ all -> 0x0022 }
            if (r6 != r0) goto L_0x0081
            return r0
        L_0x0081:
            if (r5 == 0) goto L_0x0087
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r5, (java.util.concurrent.CancellationException) r4, (int) r3, (java.lang.Object) r4)
        L_0x0087:
            androidx.lifecycle.LifecycleOwner r0 = r1.$source
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r3 = r1.$self
            androidx.lifecycle.LifecycleObserver r3 = (androidx.lifecycle.LifecycleObserver) r3
            r0.removeObserver(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0098:
            r0 = move-exception
            r5 = r12
        L_0x009a:
            if (r5 == 0) goto L_0x009f
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r5, (java.util.concurrent.CancellationException) r4, (int) r3, (java.lang.Object) r4)
        L_0x009f:
            androidx.lifecycle.LifecycleOwner r3 = r1.$source
            androidx.lifecycle.Lifecycle r3 = r3.getLifecycle()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r4 = r1.$self
            androidx.lifecycle.LifecycleObserver r4 = (androidx.lifecycle.LifecycleObserver) r4
            r3.removeObserver(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1", f = "WindowRecomposer.android.kt", i = {0, 1}, l = {115, 121}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
/* compiled from: WindowRecomposer.android.kt */
final class WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $animationScaleUri;
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ Channel<Unit> $channel;
    final /* synthetic */ WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 $contentObserver;
    final /* synthetic */ ContentResolver $resolver;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(ContentResolver contentResolver, Uri uri, WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1, Channel<Unit> channel, Context context, Continuation<? super WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1> continuation) {
        super(2, continuation);
        this.$resolver = contentResolver;
        this.$animationScaleUri = uri;
        this.$contentObserver = windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1;
        this.$channel = channel;
        this.$applicationContext = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 = new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(this.$resolver, this.$animationScaleUri, this.$contentObserver, this.$channel, this.$applicationContext, continuation);
        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.L$0 = obj;
        return windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1;
    }

    public final Object invoke(FlowCollector<? super Float> flowCollector, Continuation<? super Unit> continuation) {
        return ((WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            switch(r1) {
                case 0: goto L_0x0034;
                case 1: goto L_0x0022;
                case 2: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0011:
            r1 = r9
            java.lang.Object r2 = r1.L$1
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r3 = (kotlinx.coroutines.flow.FlowCollector) r3
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x00ad }
            r8 = r3
            r3 = r2
            r2 = r8
            goto L_0x0099
        L_0x0022:
            r1 = r9
            java.lang.Object r2 = r1.L$1
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r3 = (kotlinx.coroutines.flow.FlowCollector) r3
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x00ad }
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r10
            goto L_0x0066
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r10)
            r1 = r9
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            android.content.ContentResolver r3 = r1.$resolver
            android.net.Uri r4 = r1.$animationScaleUri
            androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 r5 = r1.$contentObserver
            android.database.ContentObserver r5 = (android.database.ContentObserver) r5
            r6 = 0
            r3.registerContentObserver(r4, r6, r5)
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r3 = r1.$channel     // Catch:{ all -> 0x00ad }
            kotlinx.coroutines.channels.ChannelIterator r3 = r3.iterator()     // Catch:{ all -> 0x00ad }
        L_0x004f:
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch:{ all -> 0x00ad }
            r1.L$0 = r2     // Catch:{ all -> 0x00ad }
            r1.L$1 = r3     // Catch:{ all -> 0x00ad }
            r5 = 1
            r1.label = r5     // Catch:{ all -> 0x00ad }
            java.lang.Object r4 = r3.hasNext(r4)     // Catch:{ all -> 0x00ad }
            if (r4 != r0) goto L_0x0060
            return r0
        L_0x0060:
            r8 = r0
            r0 = r10
            r10 = r4
            r4 = r2
            r2 = r1
            r1 = r8
        L_0x0066:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00a7 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00a7 }
            if (r10 == 0) goto L_0x009a
            r3.next()     // Catch:{ all -> 0x00a7 }
            android.content.Context r10 = r2.$applicationContext     // Catch:{ all -> 0x00a7 }
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch:{ all -> 0x00a7 }
            java.lang.String r5 = "animator_duration_scale"
            r6 = 1065353216(0x3f800000, float:1.0)
            float r10 = android.provider.Settings.Global.getFloat(r10, r5, r6)     // Catch:{ all -> 0x00a7 }
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)     // Catch:{ all -> 0x00a7 }
            r6 = r2
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch:{ all -> 0x00a7 }
            r2.L$0 = r4     // Catch:{ all -> 0x00a7 }
            r2.L$1 = r3     // Catch:{ all -> 0x00a7 }
            r7 = 2
            r2.label = r7     // Catch:{ all -> 0x00a7 }
            java.lang.Object r5 = r4.emit(r5, r6)     // Catch:{ all -> 0x00a7 }
            if (r5 != r1) goto L_0x0095
            return r1
        L_0x0095:
            r10 = r0
            r0 = r1
            r1 = r2
            r2 = r4
        L_0x0099:
            goto L_0x004f
        L_0x009a:
            android.content.ContentResolver r10 = r2.$resolver
            androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 r1 = r2.$contentObserver
            android.database.ContentObserver r1 = (android.database.ContentObserver) r1
            r10.unregisterContentObserver(r1)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00a7:
            r10 = move-exception
            r1 = r2
            r8 = r0
            r0 = r10
            r10 = r8
            goto L_0x00ae
        L_0x00ad:
            r0 = move-exception
        L_0x00ae:
            android.content.ContentResolver r2 = r1.$resolver
            androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 r3 = r1.$contentObserver
            android.database.ContentObserver r3 = (android.database.ContentObserver) r3
            r2.unregisterContentObserver(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

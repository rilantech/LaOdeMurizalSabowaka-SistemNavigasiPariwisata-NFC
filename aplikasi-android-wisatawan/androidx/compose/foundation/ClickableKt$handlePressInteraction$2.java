package androidx.compose.foundation;

import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$handlePressInteraction$2", f = "Clickable.kt", i = {0, 1, 2}, l = {299, 301, 308, 309, 318}, m = "invokeSuspend", n = {"delayJob", "success", "release"}, s = {"L$0", "Z$0", "L$0"})
/* compiled from: Clickable.kt */
final class ClickableKt$handlePressInteraction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Boolean> $delayPressInteraction;
    final /* synthetic */ AbstractClickableNode.InteractionData $interactionData;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $pressPoint;
    final /* synthetic */ PressGestureScope $this_handlePressInteraction;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$handlePressInteraction$2(PressGestureScope pressGestureScope, long j, MutableInteractionSource mutableInteractionSource, AbstractClickableNode.InteractionData interactionData, Function0<Boolean> function0, Continuation<? super ClickableKt$handlePressInteraction$2> continuation) {
        super(2, continuation);
        this.$this_handlePressInteraction = pressGestureScope;
        this.$pressPoint = j;
        this.$interactionSource = mutableInteractionSource;
        this.$interactionData = interactionData;
        this.$delayPressInteraction = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClickableKt$handlePressInteraction$2 clickableKt$handlePressInteraction$2 = new ClickableKt$handlePressInteraction$2(this.$this_handlePressInteraction, this.$pressPoint, this.$interactionSource, this.$interactionData, this.$delayPressInteraction, continuation);
        clickableKt$handlePressInteraction$2.L$0 = obj;
        return clickableKt$handlePressInteraction$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClickableKt$handlePressInteraction$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0076, code lost:
        r14 = ((java.lang.Boolean) r14).booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0080, code lost:
        if (r4.isActive() == false) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0082, code lost:
        r3.L$0 = null;
        r3.Z$0 = r14;
        r3.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0090, code lost:
        if (kotlinx.coroutines.JobKt.cancelAndJoin(r4, r3) != r0) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0092, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0093, code lost:
        r12 = r3;
        r3 = r14;
        r14 = r1;
        r1 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0097, code lost:
        if (r3 == false) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0099, code lost:
        r3 = new androidx.compose.foundation.interaction.PressInteraction.Press(r1.$pressPoint, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r4 = new androidx.compose.foundation.interaction.PressInteraction.Release(r3);
        r1.L$0 = r4;
        r1.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b6, code lost:
        if (r1.$interactionSource.emit(r3, r1) != r0) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b8, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b9, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ba, code lost:
        r1.L$0 = null;
        r1.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00cb, code lost:
        if (r1.$interactionSource.emit(r3, r1) != r0) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00cd, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ce, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cf, code lost:
        r1 = r14;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d2, code lost:
        r3 = r1;
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d5, code lost:
        r4 = r3.$interactionData.getPressInteraction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00db, code lost:
        if (r4 == null) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00dd, code lost:
        r5 = r3.$interactionSource;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e1, code lost:
        if (r14 == false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e3, code lost:
        r14 = new androidx.compose.foundation.interaction.PressInteraction.Release(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00eb, code lost:
        r14 = new androidx.compose.foundation.interaction.PressInteraction.Cancel(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f2, code lost:
        r3.L$0 = null;
        r3.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ff, code lost:
        if (r5.emit(r14, r3) != r0) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0101, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0102, code lost:
        r14 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0105, code lost:
        r1 = r14;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0109, code lost:
        r3.$interactionData.setPressInteraction((androidx.compose.foundation.interaction.PressInteraction.Press) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0110, code lost:
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
                case 0: goto L_0x003d;
                case 1: goto L_0x0031;
                case 2: goto L_0x0029;
                case 3: goto L_0x001f;
                case 4: goto L_0x0019;
                case 5: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0012:
            r0 = r13
            r1 = 0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0105
        L_0x0019:
            r0 = r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00cf
        L_0x001f:
            r1 = r13
            java.lang.Object r3 = r1.L$0
            androidx.compose.foundation.interaction.PressInteraction$Release r3 = (androidx.compose.foundation.interaction.PressInteraction.Release) r3
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00ba
        L_0x0029:
            r1 = r13
            boolean r3 = r1.Z$0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0097
        L_0x0031:
            r1 = r13
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.Job r3 = (kotlinx.coroutines.Job) r3
            kotlin.ResultKt.throwOnFailure(r14)
            r4 = r3
            r3 = r1
            r1 = r14
            goto L_0x0076
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r14)
            r1 = r13
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1 r11 = new androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1
            kotlin.jvm.functions.Function0<java.lang.Boolean> r5 = r1.$delayPressInteraction
            long r6 = r1.$pressPoint
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = r1.$interactionSource
            androidx.compose.foundation.AbstractClickableNode$InteractionData r9 = r1.$interactionData
            r10 = 0
            r4 = r11
            r4.<init>(r5, r6, r8, r9, r10)
            r7 = r11
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            r4 = r3
            kotlinx.coroutines.Job r3 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r4, r5, r6, r7, r8, r9)
            androidx.compose.foundation.gestures.PressGestureScope r4 = r1.$this_handlePressInteraction
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r1.L$0 = r3
            r6 = 1
            r1.label = r6
            java.lang.Object r4 = r4.tryAwaitRelease(r5)
            if (r4 != r0) goto L_0x0071
            return r0
        L_0x0071:
            r12 = r1
            r1 = r14
            r14 = r4
            r4 = r3
            r3 = r12
        L_0x0076:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            boolean r5 = r4.isActive()
            if (r5 == 0) goto L_0x00d5
            r5 = r3
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r3.L$0 = r2
            r3.Z$0 = r14
            r6 = 2
            r3.label = r6
            java.lang.Object r4 = kotlinx.coroutines.JobKt.cancelAndJoin(r4, r5)
            if (r4 != r0) goto L_0x0093
            return r0
        L_0x0093:
            r12 = r3
            r3 = r14
            r14 = r1
            r1 = r12
        L_0x0097:
            if (r3 == 0) goto L_0x00d2
            androidx.compose.foundation.interaction.PressInteraction$Press r3 = new androidx.compose.foundation.interaction.PressInteraction$Press
            long r4 = r1.$pressPoint
            r3.<init>(r4, r2)
            androidx.compose.foundation.interaction.PressInteraction$Release r4 = new androidx.compose.foundation.interaction.PressInteraction$Release
            r4.<init>(r3)
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r1.$interactionSource
            r6 = r3
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r7 = r1
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r1.L$0 = r4
            r8 = 3
            r1.label = r8
            java.lang.Object r3 = r5.emit(r6, r7)
            if (r3 != r0) goto L_0x00b9
            return r0
        L_0x00b9:
            r3 = r4
        L_0x00ba:
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r1.$interactionSource
            r5 = r3
            androidx.compose.foundation.interaction.Interaction r5 = (androidx.compose.foundation.interaction.Interaction) r5
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r1.L$0 = r2
            r7 = 4
            r1.label = r7
            java.lang.Object r3 = r4.emit(r5, r6)
            if (r3 != r0) goto L_0x00ce
            return r0
        L_0x00ce:
            r0 = r1
        L_0x00cf:
            r1 = r14
            r3 = r0
            goto L_0x0109
        L_0x00d2:
            r3 = r1
            r1 = r14
            goto L_0x0109
        L_0x00d5:
            androidx.compose.foundation.AbstractClickableNode$InteractionData r4 = r3.$interactionData
            androidx.compose.foundation.interaction.PressInteraction$Press r4 = r4.getPressInteraction()
            if (r4 == 0) goto L_0x0109
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r3.$interactionSource
            r6 = 0
            if (r14 == 0) goto L_0x00eb
            androidx.compose.foundation.interaction.PressInteraction$Release r14 = new androidx.compose.foundation.interaction.PressInteraction$Release
            r14.<init>(r4)
            androidx.compose.foundation.interaction.PressInteraction r14 = (androidx.compose.foundation.interaction.PressInteraction) r14
            goto L_0x00f2
        L_0x00eb:
            androidx.compose.foundation.interaction.PressInteraction$Cancel r14 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
            r14.<init>(r4)
            androidx.compose.foundation.interaction.PressInteraction r14 = (androidx.compose.foundation.interaction.PressInteraction) r14
        L_0x00f2:
            r4 = r14
            androidx.compose.foundation.interaction.Interaction r4 = (androidx.compose.foundation.interaction.Interaction) r4
            r3.L$0 = r2
            r7 = 5
            r3.label = r7
            java.lang.Object r14 = r5.emit(r4, r3)
            if (r14 != r0) goto L_0x0102
            return r0
        L_0x0102:
            r14 = r1
            r0 = r3
            r1 = r6
        L_0x0105:
            r1 = r14
            r3 = r0
        L_0x0109:
            androidx.compose.foundation.AbstractClickableNode$InteractionData r14 = r3.$interactionData
            r14.setPressInteraction(r2)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt$handlePressInteraction$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

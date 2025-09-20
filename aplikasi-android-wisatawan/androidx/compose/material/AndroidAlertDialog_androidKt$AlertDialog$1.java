package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidAlertDialog.android.kt */
final class AndroidAlertDialog_androidKt$AlertDialog$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $confirmButton;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissButton;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidAlertDialog_androidKt$AlertDialog$1(Function2<? super Composer, ? super Integer, Unit> function2, int i, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.$dismissButton = function2;
        this.$$dirty = i;
        this.$confirmButton = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r29, int r30) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r2 = r30
            java.lang.String r3 = "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 11
            r4 = 2
            if (r3 != r4) goto L_0x001c
            boolean r3 = r29.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r29.skipToGroupEnd()
            goto L_0x01af
        L_0x001c:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002b
            r3 = -1
            java.lang.String r4 = "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:77)"
            r5 = -1849673151(0xffffffff91c03a41, float:-3.032816E-28)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
        L_0x002b:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r4 = 0
            r5 = 0
            r6 = 1
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r3, r4, r6, r5)
            r4 = 8
            r5 = 0
            float r7 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r7)
            r5 = 2
            r7 = 0
            float r8 = (float) r5
            float r5 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r8)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m539paddingVpY3zN4(r3, r4, r5)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$dismissButton
            int r5 = r0.$$dirty
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r7 = r0.$confirmButton
            r8 = 6
            r9 = 0
            r10 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r1.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r10 = r10.getTopStart()
            r11 = 0
            int r12 = r8 >> 3
            r12 = r12 & 14
            int r13 = r8 >> 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r10, r11, r1, r12)
            int r13 = r8 << 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r14 = 0
            r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r15)
            r15 = 0
            int r15 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r15)
            androidx.compose.runtime.CompositionLocalMap r6 = r29.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r16 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r17 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            int r0 = r13 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r18 = r16
            r16 = r17
            r17 = 0
            androidx.compose.runtime.Applier r2 = r29.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x00ab
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00ab:
            r29.startReusableNode()
            boolean r2 = r29.getInserting()
            if (r2 == 0) goto L_0x00ba
            r2 = r18
            r1.createNode(r2)
            goto L_0x00bf
        L_0x00ba:
            r2 = r18
            r29.useNode()
        L_0x00bf:
            r18 = r2
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m2865constructorimpl(r29)
            r19 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
            r21 = r3
            kotlin.jvm.functions.Function2 r3 = r20.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r2, r12, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r2, r6, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            r20 = 0
            r22 = r2
            r23 = 0
            boolean r24 = r22.getInserting()
            if (r24 != 0) goto L_0x0103
            r24 = r6
            java.lang.Object r6 = r22.rememberedValue()
            r25 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r15)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r9)
            if (r6 != 0) goto L_0x0100
            goto L_0x0107
        L_0x0100:
            r9 = r22
            goto L_0x0117
        L_0x0103:
            r24 = r6
            r25 = r9
        L_0x0107:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r15)
            r9 = r22
            r9.updateRememberedValue(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r15)
            r2.apply(r6, r3)
        L_0x0117:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r29)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r2)
            int r3 = r0 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r6 = r16
            r6.invoke(r2, r1, r3)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r2)
            int r2 = r0 >> 9
            r2 = r2 & 14
            r3 = r29
            r9 = 0
            r16 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r8 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r19 = r3
            r20 = 0
            r22 = r0
            r0 = 350577093(0x14e561c5, float:2.3161654E-26)
            r23 = r1
            java.lang.String r1 = "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o"
            r26 = r2
            r2 = r19
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            r0 = 8
            r1 = 0
            r19 = r1
            float r1 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r1)
            r1 = 12
            r19 = 0
            r27 = r6
            float r6 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r6)
            androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1 r6 = new androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
            r6.<init>(r4, r5, r7)
            r4 = 1789213604(0x6aa53ba4, float:9.98772E25)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r4, r5, r6)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = 438(0x1b6, float:6.14E-43)
            androidx.compose.material.AlertDialogKt.m1154AlertDialogFlowRowixp7dh8(r0, r1, r4, r2, r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r29.endReplaceableGroup()
            r29.endNode()
            r29.endReplaceableGroup()
            r29.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01af
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

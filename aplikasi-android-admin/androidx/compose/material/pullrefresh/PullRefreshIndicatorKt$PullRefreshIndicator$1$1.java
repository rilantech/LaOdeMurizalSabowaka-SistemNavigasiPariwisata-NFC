package androidx.compose.material.pullrefresh;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "refreshing", "", "invoke", "(ZLandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullRefreshIndicator.kt */
final class PullRefreshIndicatorKt$PullRefreshIndicator$1$1 extends Lambda implements Function3<Boolean, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ PullRefreshState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullRefreshIndicatorKt$PullRefreshIndicator$1$1(long j, int i, PullRefreshState pullRefreshState) {
        super(3);
        this.$contentColor = j;
        this.$$dirty = i;
        this.$state = pullRefreshState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke(((Boolean) p1).booleanValue(), (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(boolean r37, androidx.compose.runtime.Composer r38, int r39) {
        /*
            r36 = this;
            r0 = r36
            r1 = r37
            r2 = r38
            r3 = r39
            java.lang.String r4 = "C104@4471L605:PullRefreshIndicator.kt#t44y28"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r4)
            r4 = r39
            r5 = r3 & 14
            if (r5 != 0) goto L_0x001d
            boolean r5 = r2.changed((boolean) r1)
            if (r5 == 0) goto L_0x001b
            r5 = 4
            goto L_0x001c
        L_0x001b:
            r5 = 2
        L_0x001c:
            r4 = r4 | r5
        L_0x001d:
            r5 = r4 & 91
            r6 = 18
            if (r5 != r6) goto L_0x0031
            boolean r5 = r38.getSkipping()
            if (r5 != 0) goto L_0x002a
            goto L_0x0031
        L_0x002a:
            r38.skipToGroupEnd()
            r24 = r4
            goto L_0x020e
        L_0x0031:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0040
            r5 = -1
            java.lang.String r6 = "androidx.compose.material.pullrefresh.PullRefreshIndicator.<anonymous>.<anonymous> (PullRefreshIndicator.kt:103)"
            r7 = 1853731063(0x6e7db0f7, float:1.9628411E28)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r5, r6)
        L_0x0040:
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r6 = 1
            r7 = 0
            r8 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r5, r8, r6, r7)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getCenter()
            long r8 = r0.$contentColor
            int r7 = r0.$$dirty
            androidx.compose.material.pullrefresh.PullRefreshState r10 = r0.$state
            r11 = 54
            r17 = r11
            r18 = 0
            r11 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r11)
            r15 = 0
            int r11 = r17 >> 3
            r11 = r11 & 14
            int r12 = r17 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r6, r15, r2, r11)
            int r11 = r17 << 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r19 = r11
            r20 = 0
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r11)
            r11 = 0
            int r21 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r11)
            androidx.compose.runtime.CompositionLocalMap r13 = r38.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r12 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r5)
            int r0 = r19 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r22 = 0
            androidx.compose.runtime.Applier r3 = r38.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x00b0
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00b0:
            r38.startReusableNode()
            boolean r3 = r38.getInserting()
            if (r3 == 0) goto L_0x00bd
            r2.createNode(r11)
            goto L_0x00c0
        L_0x00bd:
            r38.useNode()
        L_0x00c0:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m4575constructorimpl(r38)
            r16 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r23 = androidx.compose.ui.node.ComposeUiNode.Companion
            r24 = r4
            kotlin.jvm.functions.Function2 r4 = r23.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r14, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r13, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            r23 = 0
            r25 = r3
            r26 = 0
            boolean r27 = r25.getInserting()
            if (r27 != 0) goto L_0x0102
            r27 = r5
            java.lang.Object r5 = r25.rememberedValue()
            r28 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r21)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 != 0) goto L_0x00ff
            goto L_0x0106
        L_0x00ff:
            r6 = r25
            goto L_0x0116
        L_0x0102:
            r27 = r5
            r28 = r6
        L_0x0106:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r21)
            r6 = r25
            r6.updateRememberedValue(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r21)
            r3.apply(r5, r4)
        L_0x0116:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r38)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r3)
            int r4 = r0 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r12.invoke(r3, r2, r4)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r3)
            int r3 = r0 >> 9
            r3 = r3 & 14
            r4 = r38
            r5 = 0
            r6 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r23 = r0
            java.lang.String r0 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r6 = r17 >> 6
            r6 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r25 = r4
            r26 = 0
            r29 = r0
            r0 = -2035147121(0xffffffff86b21e8f, float:-6.700106E-35)
            java.lang.String r2 = "C:PullRefreshIndicator.kt#t44y28"
            r16 = r13
            r13 = r25
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r2)
            float r0 = androidx.compose.material.pullrefresh.PullRefreshIndicatorKt.ArcRadius
            float r2 = androidx.compose.material.pullrefresh.PullRefreshIndicatorKt.StrokeWidth
            r25 = 0
            float r30 = r0 + r2
            float r0 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r30)
            r2 = 2
            r25 = 0
            r30 = r3
            float r3 = (float) r2
            float r3 = r3 * r0
            float r0 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r3)
            if (r1 == 0) goto L_0x01c1
            r2 = -2035147035(0xffffffff86b21ee5, float:-6.7001554E-35)
            r13.startReplaceableGroup(r2)
            java.lang.String r2 = "111@4719L208"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            float r10 = androidx.compose.material.pullrefresh.PullRefreshIndicatorKt.StrokeWidth
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m2322size3ABfNKs(r2, r0)
            int r3 = r7 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 390(0x186, float:5.47E-43)
            r31 = 0
            r25 = 0
            r33 = 24
            r7 = r2
            r2 = r11
            r34 = r12
            r11 = r31
            r32 = r13
            r31 = r16
            r13 = r25
            r25 = r14
            r14 = r32
            r35 = r15
            r15 = r3
            r16 = r33
            androidx.compose.material.ProgressIndicatorKt.m3080CircularProgressIndicatorLxG7B9w(r7, r8, r10, r11, r13, r14, r15, r16)
            r32.endReplaceableGroup()
            r13 = r32
            goto L_0x01ee
        L_0x01c1:
            r2 = r11
            r34 = r12
            r32 = r13
            r25 = r14
            r35 = r15
            r31 = r16
            r3 = -2035146781(0xffffffff86b21fe3, float:-6.700301E-35)
            r13.startReplaceableGroup(r3)
            java.lang.String r3 = "117@4973L71"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m2322size3ABfNKs(r3, r0)
            int r7 = r7 >> 9
            r7 = r7 & 112(0x70, float:1.57E-43)
            r12 = r7 | 392(0x188, float:5.5E-43)
            r7 = r10
            r10 = r3
            r11 = r13
            androidx.compose.material.pullrefresh.PullRefreshIndicatorKt.m3212CircularArrowIndicatoriJQMabo(r7, r8, r10, r11, r12)
            r13.endReplaceableGroup()
        L_0x01ee:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r38.endReplaceableGroup()
            r38.endNode()
            r38.endReplaceableGroup()
            r38.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x020e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x020e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$1$1.invoke(boolean, androidx.compose.runtime.Composer, int):void");
    }
}

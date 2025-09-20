package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlertDialog.kt */
final class AlertDialogKt$AlertDialogContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $buttons;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlertDialogKt$AlertDialogContent$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i) {
        super(2);
        this.$title = function2;
        this.$text = function22;
        this.$buttons = function23;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r31, int r32) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            r2 = r32
            java.lang.String r3 = "C58@2184L895:AlertDialog.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 11
            r4 = 2
            if (r3 != r4) goto L_0x001c
            boolean r3 = r31.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r31.skipToGroupEnd()
            goto L_0x01b3
        L_0x001c:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002b
            r3 = -1
            java.lang.String r4 = "androidx.compose.material.AlertDialogContent.<anonymous> (AlertDialog.kt:57)"
            r5 = 629950291(0x258c4753, float:2.433446E-16)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
        L_0x002b:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$title
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$text
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$buttons
            int r6 = r0.$$dirty
            r7 = 0
            r8 = 0
            r9 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r1.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(Column)P(2,3,1)75@3779L61,76@3845L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r9)
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            androidx.compose.foundation.layout.Arrangement r10 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r10 = r10.getTop()
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r11 = r11.getStart()
            int r12 = r7 >> 3
            r12 = r12 & 14
            int r13 = r7 >> 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r10, r11, r1, r12)
            int r13 = r7 << 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r14 = 0
            r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r15)
            r15 = 0
            int r15 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r15)
            androidx.compose.runtime.CompositionLocalMap r0 = r31.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r16 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r17 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r9)
            int r2 = r13 << 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | 6
            r18 = r16
            r16 = r17
            r17 = 0
            r19 = r8
            androidx.compose.runtime.Applier r8 = r31.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x009a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x009a:
            r31.startReusableNode()
            boolean r8 = r31.getInserting()
            if (r8 == 0) goto L_0x00a9
            r8 = r18
            r1.createNode(r8)
            goto L_0x00ae
        L_0x00a9:
            r8 = r18
            r31.useNode()
        L_0x00ae:
            r18 = r8
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m4575constructorimpl(r31)
            r20 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r21 = androidx.compose.ui.node.ComposeUiNode.Companion
            r22 = r9
            kotlin.jvm.functions.Function2 r9 = r21.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r8, r12, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r8, r0, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetCompositeKeyHash()
            r21 = 0
            r23 = r8
            r24 = 0
            boolean r25 = r23.getInserting()
            if (r25 != 0) goto L_0x00f2
            r25 = r0
            java.lang.Object r0 = r23.rememberedValue()
            r26 = r10
            java.lang.Integer r10 = java.lang.Integer.valueOf(r15)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r10)
            if (r0 != 0) goto L_0x00ef
            goto L_0x00f6
        L_0x00ef:
            r10 = r23
            goto L_0x0106
        L_0x00f2:
            r25 = r0
            r26 = r10
        L_0x00f6:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r15)
            r10 = r23
            r10.updateRememberedValue(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r15)
            r8.apply(r0, r9)
        L_0x0106:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r31)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r0)
            int r8 = r2 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9 = r16
            r9.invoke(r0, r1, r8)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r0)
            int r0 = r2 >> 9
            r0 = r0 & 14
            r8 = r31
            r10 = 0
            r16 = r0
            r0 = 276693570(0x107e0242, float:5.0094407E-29)
            java.lang.String r1 = "C77@3893L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r0, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            int r1 = r7 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            androidx.compose.foundation.layout.ColumnScope r0 = (androidx.compose.foundation.layout.ColumnScope) r0
            r20 = r8
            r21 = 0
            r23 = r2
            r2 = -80835772(0xfffffffffb2e8b44, float:-9.062843E35)
            r24 = r7
            java.lang.String r7 = "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o"
            r27 = r9
            r9 = r20
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r7)
            r2 = 1
            if (r3 == 0) goto L_0x016b
            r20 = r3
            r28 = 0
            androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1 r7 = new androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
            r7.<init>(r3, r6)
            r3 = 620104160(0x24f609e0, float:1.0670222E-16)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r3, r2, r7)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            goto L_0x016c
        L_0x016b:
            r3 = 0
        L_0x016c:
            if (r4 == 0) goto L_0x0184
            r7 = r4
            r20 = 0
            androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1 r2 = new androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
            r2.<init>(r4, r6)
            r4 = 1965858367(0x752c9e3f, float:2.188195E32)
            r29 = r7
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r4, r7, r2)
            r7 = r2
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            goto L_0x0185
        L_0x0184:
            r7 = 0
        L_0x0185:
            r2 = r1 & 14
            androidx.compose.material.AlertDialogKt.AlertDialogBaselineLayout(r0, r3, r7, r9, r2)
            r2 = r6 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5.invoke(r9, r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r31.endReplaceableGroup()
            r31.endNode()
            r31.endReplaceableGroup()
            r31.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01b3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AlertDialogKt$AlertDialogContent$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheet$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheet$3(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$content = function3;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r25, int r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            java.lang.String r3 = "C578@23390L25:BottomSheetScaffold.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 11
            r4 = 2
            if (r3 != r4) goto L_0x001c
            boolean r3 = r25.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r25.skipToGroupEnd()
            goto L_0x0154
        L_0x001c:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002b
            r3 = -1
            java.lang.String r4 = "androidx.compose.material.BottomSheet.<anonymous> (BottomSheetScaffold.kt:578)"
            r5 = 1944994153(0x73ee4169, float:3.7753092E31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
        L_0x002b:
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$content
            int r4 = r0.$$dirty
            int r4 = r4 >> 15
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r5 = 0
            r6 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r1.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(Column)P(2,3,1)75@3779L61,76@3845L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r6)
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r7 = r7.getTop()
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r8 = r8.getStart()
            int r9 = r4 >> 3
            r9 = r9 & 14
            int r10 = r4 >> 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r9 = r9 | r10
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r7, r8, r1, r9)
            int r10 = r4 << 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r11 = 0
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            r12 = 0
            int r12 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r12)
            androidx.compose.runtime.CompositionLocalMap r13 = r25.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r15 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r6)
            int r0 = r10 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r16 = 0
            androidx.compose.runtime.Applier r2 = r25.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x0094
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0094:
            r25.startReusableNode()
            boolean r2 = r25.getInserting()
            if (r2 == 0) goto L_0x00a1
            r1.createNode(r14)
            goto L_0x00a4
        L_0x00a1:
            r25.useNode()
        L_0x00a4:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m4575constructorimpl(r25)
            r17 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            r19 = r5
            kotlin.jvm.functions.Function2 r5 = r18.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r9, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r13, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetCompositeKeyHash()
            r18 = 0
            r20 = r2
            r21 = 0
            boolean r22 = r20.getInserting()
            if (r22 != 0) goto L_0x00e6
            r22 = r6
            java.lang.Object r6 = r20.rememberedValue()
            r23 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r12)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 != 0) goto L_0x00e3
            goto L_0x00ea
        L_0x00e3:
            r7 = r20
            goto L_0x00fa
        L_0x00e6:
            r22 = r6
            r23 = r7
        L_0x00ea:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)
            r7 = r20
            r7.updateRememberedValue(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)
            r2.apply(r6, r5)
        L_0x00fa:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r25)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r2)
            int r5 = r0 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r15.invoke(r2, r1, r5)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r2)
            int r2 = r0 >> 9
            r2 = r2 & 14
            r5 = r25
            r6 = 0
            r7 = 276693570(0x107e0242, float:5.0094407E-29)
            r17 = r0
            java.lang.String r0 = "C77@3893L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r7, r0)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            int r7 = r4 >> 6
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r7 | 6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r3.invoke(r0, r5, r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r25.endReplaceableGroup()
            r25.endNode()
            r25.endReplaceableGroup()
            r25.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0154
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0154:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

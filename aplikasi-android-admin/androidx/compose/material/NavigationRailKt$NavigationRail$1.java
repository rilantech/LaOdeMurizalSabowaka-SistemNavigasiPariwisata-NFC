package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationRail.kt */
final class NavigationRailKt$NavigationRail$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $header;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationRailKt$NavigationRail$1(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32) {
        super(2);
        this.$header = function3;
        this.$$dirty = i;
        this.$content = function32;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r29, int r30) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r2 = r30
            java.lang.String r3 = "C106@4731L392:NavigationRail.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 11
            r4 = 2
            if (r3 != r4) goto L_0x001c
            boolean r3 = r29.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r29.skipToGroupEnd()
            goto L_0x01c0
        L_0x001c:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002b
            r3 = -1
            java.lang.String r4 = "androidx.compose.material.NavigationRail.<anonymous> (NavigationRail.kt:105)"
            r5 = -1571506489(0xffffffffa254b6c7, float:-2.882812E-18)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
        L_0x002b:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r4 = 0
            r5 = 1
            r6 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxHeight$default(r3, r4, r5, r6)
            float r7 = androidx.compose.material.NavigationRailKt.NavigationRailPadding
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m2250paddingVpY3zN4$default(r3, r4, r7, r5, r6)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.selection.SelectableGroupKt.selectableGroup(r3)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r4 = r4.getCenterHorizontally()
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$header
            int r6 = r0.$$dirty
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r7 = r0.$content
            r8 = 384(0x180, float:5.38E-43)
            r9 = 0
            r10 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r1.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(Column)P(2,3,1)75@3779L61,76@3845L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            androidx.compose.foundation.layout.Arrangement r10 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r10 = r10.getTop()
            int r11 = r8 >> 3
            r11 = r11 & 14
            int r12 = r8 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r10, r4, r1, r11)
            int r12 = r8 << 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r13 = 0
            r14 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            r14 = 0
            int r14 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r14)
            androidx.compose.runtime.CompositionLocalMap r15 = r29.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r16 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r17 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            int r0 = r12 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r2 = 6
            r0 = r0 | r2
            r18 = r16
            r16 = r17
            r17 = 0
            androidx.compose.runtime.Applier r2 = r29.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x00aa
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00aa:
            r29.startReusableNode()
            boolean r2 = r29.getInserting()
            if (r2 == 0) goto L_0x00b9
            r2 = r18
            r1.createNode(r2)
            goto L_0x00be
        L_0x00b9:
            r2 = r18
            r29.useNode()
        L_0x00be:
            r18 = r2
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m4575constructorimpl(r29)
            r20 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r21 = androidx.compose.ui.node.ComposeUiNode.Companion
            r22 = r3
            kotlin.jvm.functions.Function2 r3 = r21.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r11, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r15, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            r21 = 0
            r23 = r2
            r24 = 0
            boolean r25 = r23.getInserting()
            if (r25 != 0) goto L_0x0102
            r25 = r4
            java.lang.Object r4 = r23.rememberedValue()
            r26 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r14)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r9)
            if (r4 != 0) goto L_0x00ff
            goto L_0x0106
        L_0x00ff:
            r9 = r23
            goto L_0x0116
        L_0x0102:
            r25 = r4
            r26 = r9
        L_0x0106:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            r9 = r23
            r9.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            r2.apply(r4, r3)
        L_0x0116:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r29)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r2)
            int r3 = r0 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = r16
            r4.invoke(r2, r1, r3)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r2)
            int r2 = r0 >> 9
            r2 = r2 & 14
            r3 = r29
            r9 = 0
            r16 = r0
            r0 = 276693570(0x107e0242, float:5.0094407E-29)
            java.lang.String r1 = "C77@3893L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            int r1 = r8 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r19 = 6
            r1 = r1 | 6
            androidx.compose.foundation.layout.ColumnScope r0 = (androidx.compose.foundation.layout.ColumnScope) r0
            r20 = r3
            r21 = 0
            r23 = r2
            r2 = 65525382(0x3e7d686, float:1.3626212E-36)
            r24 = r4
            java.lang.String r4 = "C117@5104L9:NavigationRail.kt#jmzs0o"
            r27 = r8
            r8 = r20
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r2, r4)
            r8.startReplaceableGroup(r2)
            java.lang.String r2 = "114@5014L8,115@5039L38"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            if (r5 == 0) goto L_0x018f
            r2 = r1 & 14
            int r4 = r6 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            r2 = r2 | r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5.invoke(r0, r8, r2)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r4 = androidx.compose.material.NavigationRailKt.HeaderPadding
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m2308height3ABfNKs(r2, r4)
            r4 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r2, r8, r4)
        L_0x018f:
            r8.endReplaceableGroup()
            r2 = r1 & 14
            int r4 = r6 >> 12
            r4 = r4 & 112(0x70, float:1.57E-43)
            r2 = r2 | r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r7.invoke(r0, r8, r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r29.endReplaceableGroup()
            r29.endNode()
            r29.endReplaceableGroup()
            r29.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01c0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.NavigationRailKt$NavigationRail$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

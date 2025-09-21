package androidx.compose.material;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tab.kt */
final class TabKt$Tab$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Indication $ripple;
    final /* synthetic */ boolean $selected;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabKt$Tab$5(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Function0<Unit> function0, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$modifier = modifier;
        this.$selected = z;
        this.$interactionSource = mutableInteractionSource;
        this.$ripple = indication;
        this.$enabled = z2;
        this.$onClick = function0;
        this.$content = function3;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r22, int r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            java.lang.String r3 = "C238@10708L532:Tab.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 11
            r4 = 2
            if (r3 != r4) goto L_0x001c
            boolean r3 = r22.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r22.skipToGroupEnd()
            goto L_0x016f
        L_0x001c:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002b
            r3 = -1
            java.lang.String r4 = "androidx.compose.material.Tab.<anonymous> (Tab.kt:237)"
            r5 = -1237246709(0xffffffffb6411d0b, float:-2.8776146E-6)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
        L_0x002b:
            androidx.compose.ui.semantics.Role$Companion r3 = androidx.compose.ui.semantics.Role.Companion
            int r3 = r3.m5168getTabo7Vup1c()
            androidx.compose.ui.Modifier r4 = r0.$modifier
            boolean r5 = r0.$selected
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = r0.$interactionSource
            androidx.compose.foundation.Indication r7 = r0.$ripple
            boolean r8 = r0.$enabled
            androidx.compose.ui.semantics.Role r9 = androidx.compose.ui.semantics.Role.m5155boximpl(r3)
            kotlin.jvm.functions.Function0<kotlin.Unit> r10 = r0.$onClick
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.selection.SelectableKt.m833selectableO2vRcR0(r4, r5, r6, r7, r8, r9, r10)
            r4 = 1
            r5 = 0
            r6 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r3, r6, r4, r5)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r4 = r4.getCenterHorizontally()
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r5 = r5.getCenter()
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r6 = r0.$content
            int r7 = r0.$$dirty
            int r7 = r7 >> 12
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | 432(0x1b0, float:6.05E-43)
            r8 = 0
            r9 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r1.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(Column)P(2,3,1)75@3779L61,76@3845L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r9)
            androidx.compose.foundation.layout.Arrangement$Vertical r5 = (androidx.compose.foundation.layout.Arrangement.Vertical) r5
            int r9 = r7 >> 3
            r9 = r9 & 14
            int r10 = r7 >> 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r9 = r9 | r10
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r5, r4, r1, r9)
            int r5 = r7 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r9 = 0
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            r10 = 0
            int r10 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r10)
            androidx.compose.runtime.CompositionLocalMap r11 = r22.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            int r13 = r5 << 9
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r13 = r13 | 6
            r14 = 0
            androidx.compose.runtime.Applier r15 = r22.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x00b5
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00b5:
            r22.startReusableNode()
            boolean r15 = r22.getInserting()
            if (r15 == 0) goto L_0x00c2
            r1.createNode(r12)
            goto L_0x00c5
        L_0x00c2:
            r22.useNode()
        L_0x00c5:
            androidx.compose.runtime.Composer r15 = androidx.compose.runtime.Updater.m2865constructorimpl(r22)
            r16 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r15, r4, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r15, r11, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            r17 = 0
            r18 = r15
            r19 = 0
            boolean r20 = r18.getInserting()
            if (r20 != 0) goto L_0x0103
            java.lang.Object r2 = r18.rememberedValue()
            r20 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r2 != 0) goto L_0x0100
            goto L_0x0105
        L_0x0100:
            r4 = r18
            goto L_0x0115
        L_0x0103:
            r20 = r4
        L_0x0105:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            r4 = r18
            r4.updateRememberedValue(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            r15.apply(r2, r0)
        L_0x0115:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r22)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r0)
            int r2 = r13 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3.invoke(r0, r1, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r0)
            int r0 = r13 >> 9
            r0 = r0 & 14
            r2 = r22
            r4 = 0
            r15 = 276693570(0x107e0242, float:5.0094407E-29)
            r16 = r0
            java.lang.String r0 = "C77@3893L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r15, r0)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            int r15 = r7 >> 6
            r15 = r15 & 112(0x70, float:1.57E-43)
            r15 = r15 | 6
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r6.invoke(r0, r2, r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r22.endReplaceableGroup()
            r22.endNode()
            r22.endReplaceableGroup()
            r22.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x016f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x016f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt$Tab$5.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

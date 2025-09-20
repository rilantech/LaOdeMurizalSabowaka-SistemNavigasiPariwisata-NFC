package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatingActionButton.kt */
final class FloatingActionButtonKt$ExtendedFloatingActionButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FloatingActionButtonKt$ExtendedFloatingActionButton$2(Function2<? super Composer, ? super Integer, Unit> function2, int i, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.$icon = function2;
        this.$$dirty = i;
        this.$text = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r30, int r31) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r2 = r31
            java.lang.String r3 = "C170@8058L375:FloatingActionButton.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 11
            r4 = 2
            if (r3 != r4) goto L_0x001c
            boolean r3 = r30.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r30.skipToGroupEnd()
            goto L_0x01c5
        L_0x001c:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002b
            r3 = -1
            java.lang.String r4 = "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:168)"
            r5 = 1418981691(0x5493f13b, float:5.0832589E12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
        L_0x002b:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$icon
            if (r3 != 0) goto L_0x0034
            float r3 = androidx.compose.material.FloatingActionButtonKt.ExtendedFabTextPadding
            goto L_0x0038
        L_0x0034:
            float r3 = androidx.compose.material.FloatingActionButtonKt.ExtendedFabIconPadding
        L_0x0038:
            r5 = r3
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r4 = r3
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            float r7 = androidx.compose.material.FloatingActionButtonKt.ExtendedFabTextPadding
            r9 = 10
            r10 = 0
            r6 = 0
            r8 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m542paddingqDBjuR0$default(r4, r5, r6, r7, r8, r9, r10)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r4 = r4.getCenterVertically()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r6 = r0.$icon
            int r7 = r0.$$dirty
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r8 = r0.$text
            r9 = 384(0x180, float:5.38E-43)
            r10 = 0
            r11 = 693286680(0x2952b718, float:4.6788176E-14)
            r1.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(Row)P(2,1,3)76@3779L58,77@3842L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            androidx.compose.foundation.layout.Arrangement r11 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r11 = r11.getStart()
            int r12 = r9 >> 3
            r12 = r12 & 14
            int r13 = r9 >> 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r11, r4, r1, r12)
            int r13 = r9 << 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r14 = 0
            r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r15)
            r15 = 0
            int r15 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r15)
            androidx.compose.runtime.CompositionLocalMap r0 = r30.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r16 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r17 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            int r2 = r13 << 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r18 = r3
            r3 = 6
            r2 = r2 | r3
            r19 = r16
            r16 = r17
            r17 = 0
            androidx.compose.runtime.Applier r3 = r30.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x00b7
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00b7:
            r30.startReusableNode()
            boolean r3 = r30.getInserting()
            if (r3 == 0) goto L_0x00c6
            r3 = r19
            r1.createNode(r3)
            goto L_0x00cb
        L_0x00c6:
            r3 = r19
            r30.useNode()
        L_0x00cb:
            r19 = r3
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m2865constructorimpl(r30)
            r21 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r22 = androidx.compose.ui.node.ComposeUiNode.Companion
            r23 = r4
            kotlin.jvm.functions.Function2 r4 = r22.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r3, r12, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r3, r0, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            r22 = 0
            r24 = r3
            r25 = 0
            boolean r26 = r24.getInserting()
            if (r26 != 0) goto L_0x010f
            r26 = r0
            java.lang.Object r0 = r24.rememberedValue()
            r27 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r15)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            if (r0 != 0) goto L_0x010c
            goto L_0x0113
        L_0x010c:
            r5 = r24
            goto L_0x0123
        L_0x010f:
            r26 = r0
            r27 = r5
        L_0x0113:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r15)
            r5 = r24
            r5.updateRememberedValue(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r15)
            r3.apply(r0, r4)
        L_0x0123:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r30)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r0)
            int r3 = r2 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = r16
            r4.invoke(r0, r1, r3)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r0)
            int r0 = r2 >> 9
            r0 = r0 & 14
            r3 = r30
            r5 = 0
            r16 = r0
            r0 = -326682417(0xffffffffec8738cf, float:-1.307786E27)
            java.lang.String r1 = "C78@3887L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r1 = r9 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r20 = 6
            r1 = r1 | 6
            androidx.compose.foundation.layout.RowScope r0 = (androidx.compose.foundation.layout.RowScope) r0
            r21 = r3
            r22 = 0
            r24 = r0
            r0 = -1435223598(0xffffffffaa7439d2, float:-2.1691614E-13)
            r25 = r1
            java.lang.String r1 = "C181@8417L6:FloatingActionButton.kt#jmzs0o"
            r28 = r2
            r2 = r21
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "178@8321L6,179@8344L46"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            if (r6 == 0) goto L_0x0199
            int r0 = r7 >> 9
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6.invoke(r2, r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r1 = androidx.compose.material.FloatingActionButtonKt.ExtendedFabIconPadding
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m617width3ABfNKs(r0, r1)
            r1 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r2, r1)
        L_0x0199:
            r2.endReplaceableGroup()
            r0 = r7 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r8.invoke(r2, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r30.endReplaceableGroup()
            r30.endNode()
            r30.endReplaceableGroup()
            r30.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01c5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomNavigation.kt */
final class BottomNavigationKt$BottomNavigation$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomNavigationKt$BottomNavigation$1(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$content = function3;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r25, int r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            java.lang.String r3 = "C102@4444L243:BottomNavigation.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 11
            r4 = 2
            if (r3 != r4) goto L_0x001c
            boolean r3 = r25.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r25.skipToGroupEnd()
            goto L_0x016c
        L_0x001c:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002b
            r3 = -1
            java.lang.String r4 = "androidx.compose.material.BottomNavigation.<anonymous> (BottomNavigation.kt:101)"
            r5 = 678339930(0x286ea55a, float:1.3247509E-14)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
        L_0x002b:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r4 = 1
            r5 = 0
            r6 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r3, r6, r4, r5)
            float r4 = androidx.compose.material.BottomNavigationKt.BottomNavigationHeight
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m598height3ABfNKs(r3, r4)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.selection.SelectableGroupKt.selectableGroup(r3)
            androidx.compose.foundation.layout.Arrangement r4 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r4 = r4.getSpaceBetween()
            androidx.compose.foundation.layout.Arrangement$Horizontal r4 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r4
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$content
            int r6 = r0.$$dirty
            int r6 = r6 >> 3
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | 48
            r7 = 0
            r8 = 693286680(0x2952b718, float:4.6788176E-14)
            r1.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(Row)P(2,1,3)76@3779L58,77@3842L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r8)
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r8 = r8.getTop()
            int r9 = r6 >> 3
            r9 = r9 & 14
            int r10 = r6 >> 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r9 = r9 | r10
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r4, r8, r1, r9)
            int r10 = r6 << 3
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
            kotlin.jvm.functions.Function3 r15 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            int r0 = r10 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r16 = 0
            androidx.compose.runtime.Applier r2 = r25.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x00ac
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00ac:
            r25.startReusableNode()
            boolean r2 = r25.getInserting()
            if (r2 == 0) goto L_0x00b9
            r1.createNode(r14)
            goto L_0x00bc
        L_0x00b9:
            r25.useNode()
        L_0x00bc:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m2865constructorimpl(r25)
            r17 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            r19 = r3
            kotlin.jvm.functions.Function2 r3 = r18.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r2, r9, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r2, r13, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            r18 = 0
            r20 = r2
            r21 = 0
            boolean r22 = r20.getInserting()
            if (r22 != 0) goto L_0x00fe
            r22 = r4
            java.lang.Object r4 = r20.rememberedValue()
            r23 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r12)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r7)
            if (r4 != 0) goto L_0x00fb
            goto L_0x0102
        L_0x00fb:
            r7 = r20
            goto L_0x0112
        L_0x00fe:
            r22 = r4
            r23 = r7
        L_0x0102:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)
            r7 = r20
            r7.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)
            r2.apply(r4, r3)
        L_0x0112:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r25)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r2)
            int r3 = r0 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r15.invoke(r2, r1, r3)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r2)
            int r2 = r0 >> 9
            r2 = r2 & 14
            r3 = r25
            r4 = 0
            r7 = -326682417(0xffffffffec8738cf, float:-1.307786E27)
            r17 = r0
            java.lang.String r0 = "C78@3887L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r7, r0)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r7 = r6 >> 6
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r7 | 6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r5.invoke(r0, r3, r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r25.endReplaceableGroup()
            r25.endNode()
            r25.endReplaceableGroup()
            r25.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x016c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x016c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomNavigationKt$BottomNavigation$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

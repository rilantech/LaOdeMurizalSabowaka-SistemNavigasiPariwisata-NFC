package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/LookaheadScope;", "invoke", "(Landroidx/compose/ui/layout/LookaheadScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadScope.kt */
final class LookaheadScopeKt$LookaheadLayout$1 extends Lambda implements Function3<LookaheadScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<LookaheadScope, Composer, Integer, Unit> $content;
    final /* synthetic */ MeasurePolicy $measurePolicy;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LookaheadScopeKt$LookaheadLayout$1(Modifier modifier, MeasurePolicy measurePolicy, int i, Function3<? super LookaheadScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$modifier = modifier;
        this.$measurePolicy = measurePolicy;
        this.$$dirty = i;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((LookaheadScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.ui.layout.LookaheadScope r24, androidx.compose.runtime.Composer r25, int r26) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            java.lang.String r3 = "$this$LookaheadScope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "C52@1918L129:LookaheadScope.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r26
            r4 = r26 & 14
            if (r4 != 0) goto L_0x0020
            boolean r4 = r2.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x001e
            r4 = 4
            goto L_0x001f
        L_0x001e:
            r4 = 2
        L_0x001f:
            r3 = r3 | r4
        L_0x0020:
            r4 = r3 & 91
            r5 = 18
            if (r4 != r5) goto L_0x0032
            boolean r4 = r25.getSkipping()
            if (r4 != 0) goto L_0x002d
            goto L_0x0032
        L_0x002d:
            r25.skipToGroupEnd()
            goto L_0x013c
        L_0x0032:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0041
            r4 = -1
            java.lang.String r5 = "androidx.compose.ui.layout.LookaheadLayout.<anonymous> (LookaheadScope.kt:51)"
            r6 = 1705879204(0x65ada6a4, float:1.0250542E23)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r3, r4, r5)
        L_0x0041:
            kotlin.jvm.functions.Function3<androidx.compose.ui.layout.LookaheadScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$content
            int r5 = r0.$$dirty
            androidx.compose.ui.Modifier r6 = r0.$modifier
            androidx.compose.ui.layout.MeasurePolicy r7 = r0.$measurePolicy
            r8 = r5 & 112(0x70, float:1.57E-43)
            r9 = r5 & 896(0x380, float:1.256E-42)
            r8 = r8 | r9
            r9 = 0
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r10)
            r10 = 0
            int r10 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r10)
            androidx.compose.runtime.CompositionLocalMap r11 = r25.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r13 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r6)
            int r14 = r8 << 9
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r14 = r14 | 6
            r15 = 0
            androidx.compose.runtime.Applier r0 = r25.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x0081
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0081:
            r25.startReusableNode()
            boolean r0 = r25.getInserting()
            if (r0 == 0) goto L_0x008e
            r2.createNode(r12)
            goto L_0x0091
        L_0x008e:
            r25.useNode()
        L_0x0091:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m4575constructorimpl(r25)
            r16 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            r18 = r6
            kotlin.jvm.functions.Function2 r6 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r0, r7, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r0, r11, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetCompositeKeyHash()
            r17 = 0
            r19 = r0
            r20 = 0
            boolean r21 = r19.getInserting()
            if (r21 != 0) goto L_0x00d3
            r21 = r7
            java.lang.Object r7 = r19.rememberedValue()
            r22 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 != 0) goto L_0x00d0
            goto L_0x00d7
        L_0x00d0:
            r8 = r19
            goto L_0x00e7
        L_0x00d3:
            r21 = r7
            r22 = r8
        L_0x00d7:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)
            r8 = r19
            r8.updateRememberedValue(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)
            r0.apply(r7, r6)
        L_0x00e7:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r25)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r0)
            int r6 = r14 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r13.invoke(r0, r2, r6)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            int r0 = r14 >> 9
            r0 = r0 & 14
            r6 = r25
            r7 = 0
            r8 = -1525351009(0xffffffffa514fd9f, float:-1.2922884E-16)
            r16 = r0
            java.lang.String r0 = "C53@1950L9:LookaheadScope.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r8, r0)
            r0 = r3 & 14
            int r5 = r5 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r0 = r0 | r5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4.invoke(r1, r6, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r25.endReplaceableGroup()
            r25.endNode()
            r25.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x013c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x013c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadLayout$1.invoke(androidx.compose.ui.layout.LookaheadScope, androidx.compose.runtime.Composer, int):void");
    }
}

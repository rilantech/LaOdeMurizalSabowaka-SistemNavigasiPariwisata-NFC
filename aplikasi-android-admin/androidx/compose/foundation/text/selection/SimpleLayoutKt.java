package androidx.compose.foundation.text.selection;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"SimpleLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SimpleLayout.kt */
public final class SimpleLayoutKt {
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SimpleLayout(androidx.compose.ui.Modifier r20, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r0 = r21
            r1 = r23
            r2 = r24
            java.lang.String r3 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r3 = -2105228848(0xffffffff8284c1d0, float:-1.95069E-37)
            r4 = r22
            androidx.compose.runtime.Composer r4 = r4.startRestartGroup(r3)
            java.lang.String r5 = "C(SimpleLayout)P(1)32@1172L592:SimpleLayout.kt#eksfi3"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r23
            r6 = r2 & 1
            if (r6 == 0) goto L_0x0024
            r5 = r5 | 6
            r7 = r20
            goto L_0x0037
        L_0x0024:
            r7 = r1 & 14
            if (r7 != 0) goto L_0x0035
            r7 = r20
            boolean r8 = r4.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0032
            r8 = 4
            goto L_0x0033
        L_0x0032:
            r8 = 2
        L_0x0033:
            r5 = r5 | r8
            goto L_0x0037
        L_0x0035:
            r7 = r20
        L_0x0037:
            r8 = r2 & 2
            if (r8 == 0) goto L_0x003e
            r5 = r5 | 48
            goto L_0x004e
        L_0x003e:
            r8 = r1 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x004e
            boolean r8 = r4.changedInstance(r0)
            if (r8 == 0) goto L_0x004b
            r8 = 32
            goto L_0x004d
        L_0x004b:
            r8 = 16
        L_0x004d:
            r5 = r5 | r8
        L_0x004e:
            r8 = r5 & 91
            r9 = 18
            if (r8 != r9) goto L_0x0062
            boolean r8 = r4.getSkipping()
            if (r8 != 0) goto L_0x005b
            goto L_0x0062
        L_0x005b:
            r4.skipToGroupEnd()
            r22 = r5
            goto L_0x0159
        L_0x0062:
            if (r6 == 0) goto L_0x0069
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x006a
        L_0x0069:
            r6 = r7
        L_0x006a:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0076
            r7 = -1
            java.lang.String r8 = "androidx.compose.foundation.text.selection.SimpleLayout (SimpleLayout.kt:31)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r5, r7, r8)
        L_0x0076:
            androidx.compose.foundation.text.selection.SimpleLayoutKt$SimpleLayout$1 r3 = androidx.compose.foundation.text.selection.SimpleLayoutKt$SimpleLayout$1.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r3 = (androidx.compose.ui.layout.MeasurePolicy) r3
            int r7 = r5 >> 3
            r7 = r7 & 14
            int r8 = r5 << 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            r7 = r7 | r8
            r8 = 0
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r9)
            r9 = 0
            int r9 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r4, r9)
            androidx.compose.runtime.CompositionLocalMap r10 = r4.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r12 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r6)
            int r13 = r7 << 9
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r13 = r13 | 6
            r14 = 0
            androidx.compose.runtime.Applier r15 = r4.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x00b5
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00b5:
            r4.startReusableNode()
            boolean r15 = r4.getInserting()
            if (r15 == 0) goto L_0x00c2
            r4.createNode(r11)
            goto L_0x00c5
        L_0x00c2:
            r4.useNode()
        L_0x00c5:
            androidx.compose.runtime.Composer r15 = androidx.compose.runtime.Updater.m4575constructorimpl(r4)
            r16 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            r22 = r5
            kotlin.jvm.functions.Function2 r5 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r15, r3, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r15, r10, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            r5 = 0
            r20 = r15
            r17 = 0
            boolean r18 = r20.getInserting()
            if (r18 != 0) goto L_0x0106
            r18 = r5
            java.lang.Object r5 = r20.rememberedValue()
            r19 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 != 0) goto L_0x0103
            goto L_0x010a
        L_0x0103:
            r6 = r20
            goto L_0x011a
        L_0x0106:
            r18 = r5
            r19 = r6
        L_0x010a:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
            r6 = r20
            r6.updateRememberedValue(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
            r15.apply(r5, r3)
        L_0x011a:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r4)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r3)
            int r5 = r13 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r12.invoke(r3, r4, r5)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r4.startReplaceableGroup(r3)
            int r3 = r13 >> 9
            r3 = r3 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.invoke(r4, r3)
            r4.endReplaceableGroup()
            r4.endNode()
            r4.endReplaceableGroup()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0157
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0157:
            r7 = r19
        L_0x0159:
            androidx.compose.runtime.ScopeUpdateScope r3 = r4.endRestartGroup()
            if (r3 != 0) goto L_0x0160
            goto L_0x016a
        L_0x0160:
            androidx.compose.foundation.text.selection.SimpleLayoutKt$SimpleLayout$2 r5 = new androidx.compose.foundation.text.selection.SimpleLayoutKt$SimpleLayout$2
            r5.<init>(r7, r0, r1, r2)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r3.updateScope(r5)
        L_0x016a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SimpleLayoutKt.SimpleLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}

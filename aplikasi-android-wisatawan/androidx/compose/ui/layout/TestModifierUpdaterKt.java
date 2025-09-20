package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"TestModifierUpdaterLayout", "", "onAttached", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/TestModifierUpdater;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TestModifierUpdater.kt */
public final class TestModifierUpdaterKt {
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b1, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r13.rememberedValue(), (java.lang.Object) java.lang.Integer.valueOf(r2)) == false) goto L_0x00b6;
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "It is a test API, do not use it in the real applications")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TestModifierUpdaterLayout(kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.TestModifierUpdater, kotlin.Unit> r16, androidx.compose.runtime.Composer r17, int r18) {
        /*
            r0 = r16
            r1 = r18
            java.lang.String r2 = "onAttached"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = -1673066036(0xffffffff9c4709cc, float:-6.585624E-22)
            r3 = r17
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r2)
            java.lang.String r4 = "C(TestModifierUpdaterLayout)49@1728L23,53@1883L330:TestModifierUpdater.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r18
            r5 = r1 & 14
            r6 = 2
            if (r5 != 0) goto L_0x0029
            boolean r5 = r3.changedInstance(r0)
            if (r5 == 0) goto L_0x0027
            r5 = 4
            goto L_0x0028
        L_0x0027:
            r5 = r6
        L_0x0028:
            r4 = r4 | r5
        L_0x0029:
            r5 = r4 & 11
            if (r5 != r6) goto L_0x003b
            boolean r5 = r3.getSkipping()
            if (r5 != 0) goto L_0x0034
            goto L_0x003b
        L_0x0034:
            r3.skipToGroupEnd()
            r17 = r4
            goto L_0x00e3
        L_0x003b:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0047
            r5 = -1
            java.lang.String r6 = "androidx.compose.ui.layout.TestModifierUpdaterLayout (TestModifierUpdater.kt:48)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r5, r6)
        L_0x0047:
            r2 = 0
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r3, r2)
            androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1 r5 = androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r5 = (androidx.compose.ui.layout.MeasurePolicy) r5
            androidx.compose.ui.node.LayoutNode$Companion r6 = androidx.compose.ui.node.LayoutNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor$ui_release()
            r7 = 6
            r8 = 0
            r9 = 1886828752(0x7076b8d0, float:3.0542695E29)
            r3.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(ComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r9)
            androidx.compose.runtime.Applier r9 = r3.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x006f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x006f:
            r3.startNode()
            boolean r9 = r3.getInserting()
            if (r9 == 0) goto L_0x0083
            androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$$inlined$ComposeNode$1 r9 = new androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$$inlined$ComposeNode$1
            r9.<init>(r6)
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r3.createNode(r9)
            goto L_0x0086
        L_0x0083:
            r3.useNode()
        L_0x0086:
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m2865constructorimpl(r3)
            r10 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r9, r5, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetCompositeKeyHash()
            r12 = 0
            r13 = r9
            r14 = 0
            boolean r15 = r13.getInserting()
            if (r15 != 0) goto L_0x00b4
            java.lang.Object r15 = r13.rememberedValue()
            r17 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r4)
            if (r4 != 0) goto L_0x00c4
            goto L_0x00b6
        L_0x00b4:
            r17 = r4
        L_0x00b6:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r13.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r9.apply(r4, r11)
        L_0x00c4:
            androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1 r4 = new androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1
            r4.<init>(r0)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.runtime.Updater.m2869initimpl(r9, r4)
            r3.endNode()
            r3.endReplaceableGroup()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x00e3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00e3:
            androidx.compose.runtime.ScopeUpdateScope r2 = r3.endRestartGroup()
            if (r2 != 0) goto L_0x00ea
            goto L_0x00f4
        L_0x00ea:
            androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$2 r4 = new androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$2
            r4.<init>(r0, r1)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2.updateScope(r4)
        L_0x00f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.TestModifierUpdaterKt.TestModifierUpdaterLayout(kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }
}

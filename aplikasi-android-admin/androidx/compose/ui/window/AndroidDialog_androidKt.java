package androidx.compose.ui.window;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b\u001a*\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0003¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\u0015\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007X\u0002"}, d2 = {"Dialog", "", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DialogLayout", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDialog.android.kt */
public final class AndroidDialog_androidKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: androidx.compose.ui.window.DialogWrapper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: androidx.compose.ui.window.DialogWrapper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: androidx.compose.ui.window.DialogWrapper} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Dialog(kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.ui.window.DialogProperties r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r7 = r26
            r8 = r28
            r9 = r30
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -2032877254(0xffffffff86d4c13a, float:-8.002946E-35)
            r1 = r29
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Dialog)P(1,2)155@6564L7,156@6603L7,157@6658L7,158@6688L28,159@6743L29,160@6792L38,161@6848L616,182@7470L154,191@7630L193:AndroidDialog.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r30
            r2 = r31 & 1
            if (r2 == 0) goto L_0x0028
            r1 = r1 | 6
            goto L_0x0036
        L_0x0028:
            r2 = r9 & 14
            if (r2 != 0) goto L_0x0036
            boolean r2 = r6.changedInstance(r7)
            if (r2 == 0) goto L_0x0034
            r2 = 4
            goto L_0x0035
        L_0x0034:
            r2 = 2
        L_0x0035:
            r1 = r1 | r2
        L_0x0036:
            r2 = r31 & 2
            if (r2 == 0) goto L_0x003f
            r1 = r1 | 48
            r3 = r27
            goto L_0x0054
        L_0x003f:
            r3 = r9 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0052
            r3 = r27
            boolean r4 = r6.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004e
            r4 = 32
            goto L_0x0050
        L_0x004e:
            r4 = 16
        L_0x0050:
            r1 = r1 | r4
            goto L_0x0054
        L_0x0052:
            r3 = r27
        L_0x0054:
            r4 = r31 & 4
            if (r4 == 0) goto L_0x005b
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x005b:
            r4 = r9 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006b
            boolean r4 = r6.changedInstance(r8)
            if (r4 == 0) goto L_0x0068
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r4 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r1 = r1 | r4
        L_0x006b:
            r5 = r1
            r1 = r5 & 731(0x2db, float:1.024E-42)
            r4 = 146(0x92, float:2.05E-43)
            if (r1 != r4) goto L_0x0081
            boolean r1 = r6.getSkipping()
            if (r1 != 0) goto L_0x0079
            goto L_0x0081
        L_0x0079:
            r6.skipToGroupEnd()
            r8 = r3
            r24 = r5
            goto L_0x01b9
        L_0x0081:
            if (r2 == 0) goto L_0x0090
            androidx.compose.ui.window.DialogProperties r1 = new androidx.compose.ui.window.DialogProperties
            r14 = 7
            r15 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r10 = r1
            r10.<init>((boolean) r11, (boolean) r12, (androidx.compose.ui.window.SecureFlagPolicy) r13, (int) r14, (kotlin.jvm.internal.DefaultConstructorMarker) r15)
            r4 = r1
            goto L_0x0091
        L_0x0090:
            r4 = r3
        L_0x0091:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x009d
            r1 = -1
            java.lang.String r2 = "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:150)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r1, r2)
        L_0x009d:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r10)
            java.lang.Object r11 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r2 = r11
            android.view.View r2 = (android.view.View) r2
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r11 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r10)
            java.lang.Object r12 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r1 = r12
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r11 = 6
            r12 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r10)
            java.lang.Object r3 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            r0 = 0
            androidx.compose.runtime.CompositionContext r15 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r6, r0)
            int r10 = r5 >> 6
            r10 = r10 & 14
            androidx.compose.runtime.State r14 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r8, r6, r10)
            java.lang.Object[] r10 = new java.lang.Object[r0]
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1 r11 = androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1.INSTANCE
            r13 = r11
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r16 = 3080(0xc08, float:4.316E-42)
            r17 = 6
            r11 = 0
            r12 = 0
            r18 = r14
            r14 = r6
            r19 = r15
            r15 = r16
            r16 = r17
            java.lang.Object r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r10, r11, (java.lang.String) r12, r13, (androidx.compose.runtime.Composer) r14, (int) r15, (int) r16)
            java.util.UUID r10 = (java.util.UUID) r10
            r11 = 8
            r12 = r11
            r13 = 0
            r14 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r6.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r14)
            boolean r14 = r6.changed((java.lang.Object) r2)
            boolean r15 = r6.changed((java.lang.Object) r1)
            r14 = r14 | r15
            r15 = r6
            r16 = 0
            java.lang.Object r11 = r15.rememberedValue()
            r17 = 0
            if (r14 != 0) goto L_0x0146
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r20.getEmpty()
            if (r11 != r0) goto L_0x0135
            goto L_0x0146
        L_0x0135:
            r22 = r1
            r23 = r2
            r29 = r3
            r8 = r4
            r24 = r5
            r25 = r6
            r0 = r11
            r3 = r18
            r4 = r19
            goto L_0x018e
        L_0x0146:
            r20 = 0
            androidx.compose.ui.window.DialogWrapper r21 = new androidx.compose.ui.window.DialogWrapper
            java.lang.String r0 = "dialogId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            r8 = 0
            r0 = r21
            r22 = r1
            r1 = r26
            r23 = r2
            r2 = r4
            r29 = r3
            r3 = r23
            r8 = r4
            r4 = r29
            r24 = r5
            r5 = r22
            r25 = r6
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r1 = 0
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1 r2 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1
            r3 = r18
            r2.<init>(r3)
            r4 = 488261145(0x1d1a4619, float:2.041797E-21)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r4, r5, r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r4 = r19
            r0.setContent(r4, r2)
            r15.updateRememberedValue(r0)
        L_0x018e:
            r25.endReplaceableGroup()
            androidx.compose.ui.window.DialogWrapper r0 = (androidx.compose.ui.window.DialogWrapper) r0
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1 r1 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1
            r1.<init>(r0)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r6 = r25
            r2 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r1, (androidx.compose.runtime.Composer) r6, (int) r2)
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2 r1 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2
            r2 = r29
            r1.<init>(r0, r7, r8, r2)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r5 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r1, r6, r5)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01b9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b9:
            androidx.compose.runtime.ScopeUpdateScope r10 = r6.endRestartGroup()
            if (r10 != 0) goto L_0x01c0
            goto L_0x01d4
        L_0x01c0:
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$3 r11 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$3
            r0 = r11
            r1 = r26
            r2 = r8
            r3 = r28
            r4 = r30
            r5 = r31
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x01d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidDialog_androidKt.Dialog(kotlin.jvm.functions.Function0, androidx.compose.ui.window.DialogProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> Dialog$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> $currentContent$delegate) {
        return (Function2) $currentContent$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DialogLayout(androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r0 = r22
            r1 = r24
            r2 = r25
            r3 = -1177876616(0xffffffffb9cb0778, float:-3.8724742E-4)
            r4 = r23
            androidx.compose.runtime.Composer r4 = r4.startRestartGroup(r3)
            java.lang.String r5 = "C(DialogLayout)P(1)453@17860L455:AndroidDialog.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r24
            r6 = r2 & 1
            if (r6 == 0) goto L_0x001f
            r5 = r5 | 6
            r7 = r21
            goto L_0x0032
        L_0x001f:
            r7 = r1 & 14
            if (r7 != 0) goto L_0x0030
            r7 = r21
            boolean r8 = r4.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x002d
            r8 = 4
            goto L_0x002e
        L_0x002d:
            r8 = 2
        L_0x002e:
            r5 = r5 | r8
            goto L_0x0032
        L_0x0030:
            r7 = r21
        L_0x0032:
            r8 = r2 & 2
            if (r8 == 0) goto L_0x0039
            r5 = r5 | 48
            goto L_0x0049
        L_0x0039:
            r8 = r1 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0049
            boolean r8 = r4.changedInstance(r0)
            if (r8 == 0) goto L_0x0046
            r8 = 32
            goto L_0x0048
        L_0x0046:
            r8 = 16
        L_0x0048:
            r5 = r5 | r8
        L_0x0049:
            r8 = r5 & 91
            r9 = 18
            if (r8 != r9) goto L_0x005d
            boolean r8 = r4.getSkipping()
            if (r8 != 0) goto L_0x0056
            goto L_0x005d
        L_0x0056:
            r4.skipToGroupEnd()
            r23 = r5
            goto L_0x0156
        L_0x005d:
            if (r6 == 0) goto L_0x0064
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x0065
        L_0x0064:
            r6 = r7
        L_0x0065:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0071
            r7 = -1
            java.lang.String r8 = "androidx.compose.ui.window.DialogLayout (AndroidDialog.android.kt:449)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r5, r7, r8)
        L_0x0071:
            androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1 r3 = androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1.INSTANCE
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
            if (r15 != 0) goto L_0x00b1
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00b1:
            r4.startReusableNode()
            boolean r15 = r4.getInserting()
            if (r15 == 0) goto L_0x00be
            r4.createNode(r11)
            goto L_0x00c1
        L_0x00be:
            r4.useNode()
        L_0x00c1:
            androidx.compose.runtime.Composer r15 = androidx.compose.runtime.Updater.m4575constructorimpl(r4)
            r16 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            r23 = r5
            kotlin.jvm.functions.Function2 r5 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r15, r3, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r15, r10, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetCompositeKeyHash()
            r17 = 0
            r21 = r15
            r18 = 0
            boolean r19 = r21.getInserting()
            if (r19 != 0) goto L_0x0103
            r19 = r3
            java.lang.Object r3 = r21.rememberedValue()
            r20 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)
            if (r3 != 0) goto L_0x0100
            goto L_0x0107
        L_0x0100:
            r6 = r21
            goto L_0x0117
        L_0x0103:
            r19 = r3
            r20 = r6
        L_0x0107:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            r6 = r21
            r6.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            r15.apply(r3, r5)
        L_0x0117:
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
            if (r3 == 0) goto L_0x0154
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0154:
            r7 = r20
        L_0x0156:
            androidx.compose.runtime.ScopeUpdateScope r3 = r4.endRestartGroup()
            if (r3 != 0) goto L_0x015d
            goto L_0x0167
        L_0x015d:
            androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$2 r5 = new androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$2
            r5.<init>(r7, r0, r1, r2)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r3.updateScope(r5)
        L_0x0167:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidDialog_androidKt.DialogLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}

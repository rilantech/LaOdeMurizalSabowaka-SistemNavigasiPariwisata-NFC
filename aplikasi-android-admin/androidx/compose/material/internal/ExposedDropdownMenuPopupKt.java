package androidx.compose.material.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a:\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0013\b\b\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fH\b¢\u0006\u0002\u0010\u0011\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0012²\u0006\u0015\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fX\u0002"}, d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ExposedDropdownMenuPopup", "", "onDismissRequest", "Lkotlin/Function0;", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenuPopup.kt */
public final class ExposedDropdownMenuPopupKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, ExposedDropdownMenuPopupKt$LocalPopupTestTag$1.INSTANCE, 1, (Object) null);

    /* JADX WARNING: Removed duplicated region for block: B:62:0x02b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ExposedDropdownMenuPopup(kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.window.PopupPositionProvider r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r7 = r29
            r8 = r30
            r9 = r32
            java.lang.String r0 = "popupPositionProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -841446797(0xffffffffcdd88a73, float:-4.54119008E8)
            r1 = r31
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ExposedDropdownMenuPopup)P(1,2)84@3429L7,85@3468L7,86@3512L7,87@3567L7,88@3603L28,89@3658L29,90@3706L38,91@3767L907,118@4680L380,132@5066L192,140@5264L166,149@5608L647:ExposedDropdownMenuPopup.kt#mnwmf7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r32
            r2 = r33 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            r3 = r28
            goto L_0x003d
        L_0x002a:
            r3 = r9 & 14
            if (r3 != 0) goto L_0x003b
            r3 = r28
            boolean r4 = r6.changedInstance(r3)
            if (r4 == 0) goto L_0x0038
            r4 = 4
            goto L_0x0039
        L_0x0038:
            r4 = 2
        L_0x0039:
            r1 = r1 | r4
            goto L_0x003d
        L_0x003b:
            r3 = r28
        L_0x003d:
            r4 = r33 & 2
            if (r4 == 0) goto L_0x0044
            r1 = r1 | 48
            goto L_0x0054
        L_0x0044:
            r4 = r9 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0054
            boolean r4 = r6.changed((java.lang.Object) r7)
            if (r4 == 0) goto L_0x0051
            r4 = 32
            goto L_0x0053
        L_0x0051:
            r4 = 16
        L_0x0053:
            r1 = r1 | r4
        L_0x0054:
            r4 = r33 & 4
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
            r11 = r3
            r24 = r5
            goto L_0x02ba
        L_0x0081:
            if (r2 == 0) goto L_0x0086
            r1 = 0
            r4 = r1
            goto L_0x0087
        L_0x0086:
            r4 = r3
        L_0x0087:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0093
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.internal.ExposedDropdownMenuPopup (ExposedDropdownMenuPopup.kt:79)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r1, r2)
        L_0x0093:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r10)
            java.lang.Object r11 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r17 = r11
            android.view.View r17 = (android.view.View) r17
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r10)
            java.lang.Object r11 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r18 = r11
            androidx.compose.ui.unit.Density r18 = (androidx.compose.ui.unit.Density) r18
            androidx.compose.runtime.ProvidableCompositionLocal<java.lang.String> r0 = LocalPopupTestTag
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r10)
            java.lang.Object r11 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r2 = r11
            java.lang.String r2 = (java.lang.String) r2
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r11 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r10)
            java.lang.Object r3 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            r1 = 0
            androidx.compose.runtime.CompositionContext r0 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r6, r1)
            int r10 = r5 >> 6
            r10 = r10 & 14
            androidx.compose.runtime.State r15 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r8, r6, r10)
            java.lang.Object[] r10 = new java.lang.Object[r1]
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupId$1 r11 = androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupId$1.INSTANCE
            r13 = r11
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r16 = 3080(0xc08, float:4.316E-42)
            r19 = 6
            r11 = 0
            r12 = 0
            r14 = r6
            r20 = r15
            r15 = r16
            r16 = r19
            java.lang.Object r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r10, r11, (java.lang.String) r12, r13, (androidx.compose.runtime.Composer) r14, (int) r15, (int) r16)
            java.util.UUID r10 = (java.util.UUID) r10
            r11 = r1
            r12 = 0
            r13 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r13)
            r13 = 0
            r15 = 0
            java.lang.Object r8 = r14.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r19.getEmpty()
            if (r8 != r1) goto L_0x0178
            r19 = 0
            androidx.compose.material.internal.PopupLayout r21 = new androidx.compose.material.internal.PopupLayout
            java.lang.String r1 = "popupId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r1)
            r1 = r0
            r0 = r21
            r31 = r8
            r9 = 0
            r8 = r1
            r1 = r4
            r28 = r2
            r9 = r3
            r3 = r17
            r23 = r11
            r11 = r4
            r4 = r18
            r24 = r5
            r5 = r29
            r25 = r6
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r1 = 0
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1 r2 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1
            r3 = r20
            r2.<init>(r0, r3)
            r4 = 144472904(0x89c7b48, float:9.417892E-34)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r4, r5, r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.setContent(r8, r2)
            r14.updateRememberedValue(r0)
            goto L_0x0189
        L_0x0178:
            r28 = r2
            r9 = r3
            r24 = r5
            r25 = r6
            r31 = r8
            r23 = r11
            r3 = r20
            r8 = r0
            r11 = r4
            r0 = r31
        L_0x0189:
            r25.endReplaceableGroup()
            androidx.compose.material.internal.PopupLayout r0 = (androidx.compose.material.internal.PopupLayout) r0
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1 r1 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1
            r2 = r28
            r1.<init>(r0, r11, r2, r9)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r4 = 8
            r6 = r25
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r1, (androidx.compose.runtime.Composer) r6, (int) r4)
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$2 r1 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$2
            r1.<init>(r0, r11, r2, r9)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r4 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r1, r6, r4)
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3 r1 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3
            r1.<init>(r0, r7)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            int r4 = r24 >> 3
            r4 = r4 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r7, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r1, (androidx.compose.runtime.Composer) r6, (int) r4)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5 r4 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5
            r4.<init>(r0)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r1, r4)
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6 r4 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6
            r4.<init>(r0, r9)
            androidx.compose.ui.layout.MeasurePolicy r4 = (androidx.compose.ui.layout.MeasurePolicy) r4
            r5 = 0
            r12 = r5
            r13 = 0
            r14 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r6.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r14)
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r6, r5)
            androidx.compose.runtime.CompositionLocalMap r14 = r6.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r16 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r1)
            r28 = r0
            int r0 = r12 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r31 = r16
            r16 = 0
            r19 = r1
            androidx.compose.runtime.Applier r1 = r6.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x020a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x020a:
            r6.startReusableNode()
            boolean r1 = r6.getInserting()
            if (r1 == 0) goto L_0x0217
            r6.createNode(r15)
            goto L_0x021a
        L_0x0217:
            r6.useNode()
        L_0x021a:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m4575constructorimpl(r6)
            r20 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r21 = androidx.compose.ui.node.ComposeUiNode.Companion
            r22 = r2
            kotlin.jvm.functions.Function2 r2 = r21.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r4, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r14, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            r21 = 0
            r23 = r1
            r25 = 0
            boolean r26 = r23.getInserting()
            if (r26 != 0) goto L_0x025c
            r26 = r3
            java.lang.Object r3 = r23.rememberedValue()
            r27 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x0259
            goto L_0x0260
        L_0x0259:
            r4 = r23
            goto L_0x0270
        L_0x025c:
            r26 = r3
            r27 = r4
        L_0x0260:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4 = r23
            r4.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r1.apply(r3, r2)
        L_0x0270:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r6)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r1)
            int r2 = r0 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = r31
            r3.invoke(r1, r6, r2)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r6.startReplaceableGroup(r1)
            int r1 = r0 >> 9
            r1 = r1 & 14
            r2 = r6
            r4 = 0
            r31 = r0
            r0 = 952324125(0x38c3501d, float:9.313247E-5)
            r20 = r1
            java.lang.String r1 = "C:ExposedDropdownMenuPopup.kt#mnwmf7"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r6.endReplaceableGroup()
            r6.endNode()
            r6.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02ba
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02ba:
            androidx.compose.runtime.ScopeUpdateScope r8 = r6.endRestartGroup()
            if (r8 != 0) goto L_0x02c1
            goto L_0x02d5
        L_0x02c1:
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$7 r9 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$7
            r0 = r9
            r1 = r11
            r2 = r29
            r3 = r30
            r4 = r32
            r5 = r33
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x02d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.internal.ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ExposedDropdownMenuPopup$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> $currentContent$delegate) {
        return (Function2) $currentContent$delegate.getValue();
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0094, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r15.rememberedValue(), (java.lang.Object) java.lang.Integer.valueOf(r5)) == false) goto L_0x009b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void SimpleStack(androidx.compose.ui.Modifier r19, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, int r22) {
        /*
            r0 = r21
            r1 = 0
            r2 = 1769324208(0x6975beb0, float:1.8567958E25)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(SimpleStack)P(1)178@6799L979:ExposedDropdownMenuPopup.kt#mnwmf7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$SimpleStack$1 r2 = androidx.compose.material.internal.ExposedDropdownMenuPopupKt$SimpleStack$1.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r2 = (androidx.compose.ui.layout.MeasurePolicy) r2
            int r3 = r22 >> 3
            r3 = r3 & 14
            int r4 = r22 << 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r4 = 0
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            r5 = 0
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r0, r5)
            androidx.compose.runtime.CompositionLocalMap r6 = r21.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r19)
            int r9 = r3 << 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | 6
            r10 = 0
            androidx.compose.runtime.Applier r11 = r21.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x004d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x004d:
            r21.startReusableNode()
            boolean r11 = r21.getInserting()
            if (r11 == 0) goto L_0x005a
            r0.createNode(r7)
            goto L_0x005d
        L_0x005a:
            r21.useNode()
        L_0x005d:
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m4575constructorimpl(r21)
            r12 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r2, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r6, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetCompositeKeyHash()
            r14 = 0
            r15 = r11
            r16 = 0
            boolean r17 = r15.getInserting()
            if (r17 != 0) goto L_0x0097
            r17 = r1
            java.lang.Object r1 = r15.rememberedValue()
            r18 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x00a9
            goto L_0x009b
        L_0x0097:
            r17 = r1
            r18 = r2
        L_0x009b:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r15.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r11.apply(r1, r13)
        L_0x00a9:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r21)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r1)
            int r2 = r9 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r8.invoke(r1, r0, r2)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            int r1 = r9 >> 9
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2 = r20
            r2.invoke(r0, r1)
            r21.endReplaceableGroup()
            r21.endNode()
            r21.endReplaceableGroup()
            r21.endReplaceableGroup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.internal.ExposedDropdownMenuPopupKt.SimpleStack(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }
}

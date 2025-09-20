package androidx.compose.material;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aL\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001aZ\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u00132\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u0014\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"RippleRadius", "Landroidx/compose/ui/unit/Dp;", "F", "IconButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconToggleButton", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: IconButton.kt */
public final class IconButtonKt {
    private static final float RippleRadius = Dp.m5844constructorimpl((float) 24);

    /* JADX WARNING: Removed duplicated region for block: B:90:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void IconButton(kotlin.jvm.functions.Function0<kotlin.Unit> r31, androidx.compose.ui.Modifier r32, boolean r33, androidx.compose.foundation.interaction.MutableInteractionSource r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r9 = r31
            r10 = r35
            r11 = r37
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -111063634(0xfffffffff9614dae, float:-7.3115145E34)
            r1 = r36
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(IconButton)P(4,3,1,2)62@2761L39,73@3140L54,65@2846L607:IconButton.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r37
            r2 = r38 & 1
            if (r2 == 0) goto L_0x0028
            r1 = r1 | 6
            goto L_0x0036
        L_0x0028:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0036
            boolean r2 = r12.changedInstance(r9)
            if (r2 == 0) goto L_0x0034
            r2 = 4
            goto L_0x0035
        L_0x0034:
            r2 = 2
        L_0x0035:
            r1 = r1 | r2
        L_0x0036:
            r2 = r38 & 2
            if (r2 == 0) goto L_0x003f
            r1 = r1 | 48
            r3 = r32
            goto L_0x0054
        L_0x003f:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0052
            r3 = r32
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004e
            r4 = 32
            goto L_0x0050
        L_0x004e:
            r4 = 16
        L_0x0050:
            r1 = r1 | r4
            goto L_0x0054
        L_0x0052:
            r3 = r32
        L_0x0054:
            r4 = r38 & 4
            if (r4 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r33
            goto L_0x0072
        L_0x005d:
            r5 = r11 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0070
            r5 = r33
            boolean r6 = r12.changed((boolean) r5)
            if (r6 == 0) goto L_0x006c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r6
            goto L_0x0072
        L_0x0070:
            r5 = r33
        L_0x0072:
            r6 = r38 & 8
            if (r6 == 0) goto L_0x007b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r34
            goto L_0x0090
        L_0x007b:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x008e
            r7 = r34
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x008a
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x008c
        L_0x008a:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x008c:
            r1 = r1 | r8
            goto L_0x0090
        L_0x008e:
            r7 = r34
        L_0x0090:
            r8 = r38 & 16
            if (r8 == 0) goto L_0x0097
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a9
        L_0x0097:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x00a9
            boolean r8 = r12.changedInstance(r10)
            if (r8 == 0) goto L_0x00a6
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a8
        L_0x00a6:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x00a8:
            r1 = r1 | r8
        L_0x00a9:
            r13 = r1
            r1 = 46811(0xb6db, float:6.5596E-41)
            r1 = r1 & r13
            r8 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r8) goto L_0x00c2
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x00b9
            goto L_0x00c2
        L_0x00b9:
            r12.skipToGroupEnd()
            r14 = r3
            r15 = r5
            r16 = r7
            goto L_0x02e8
        L_0x00c2:
            if (r2 == 0) goto L_0x00ca
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r14 = r1
            goto L_0x00cb
        L_0x00ca:
            r14 = r3
        L_0x00cb:
            if (r4 == 0) goto L_0x00d0
            r1 = 1
            r15 = r1
            goto L_0x00d1
        L_0x00d0:
            r15 = r5
        L_0x00d1:
            if (r6 == 0) goto L_0x0106
            r1 = 0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            r3 = 0
            r4 = r12
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r8 = 0
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r16.getEmpty()
            if (r6 != r0) goto L_0x00fb
            r0 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r4.updateRememberedValue(r0)
            goto L_0x00fc
        L_0x00fb:
            r0 = r6
        L_0x00fc:
            r12.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r16 = r0
            goto L_0x0108
        L_0x0106:
            r16 = r7
        L_0x0108:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0117
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.IconButton (IconButton.kt:58)"
            r2 = -111063634(0xfffffffff9614dae, float:-7.3115145E34)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r13, r0, r1)
        L_0x0117:
            androidx.compose.ui.Modifier r0 = androidx.compose.material.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r14)
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r8 = r1.m5162getButtono7Vup1c()
            float r2 = RippleRadius
            r6 = 54
            r7 = 4
            r1 = 0
            r3 = 0
            r5 = r12
            androidx.compose.foundation.Indication r2 = androidx.compose.material.ripple.RippleKt.m1523rememberRipple9IZ8Weo(r1, r2, r3, r5, r6, r7)
            androidx.compose.ui.semantics.Role r5 = androidx.compose.ui.semantics.Role.m5155boximpl(r8)
            r7 = 8
            r8 = 0
            r4 = 0
            r1 = r16
            r3 = r15
            r6 = r31
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ClickableKt.m198clickableO2vRcR0$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            r2 = 48
            r3 = 0
            r4 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r12.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            r4 = 0
            int r5 = r2 >> 3
            r5 = r5 & 14
            int r6 = r2 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r4, r12, r5)
            int r6 = r2 << 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r7 = 0
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r8)
            r8 = 0
            int r17 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r12, r8)
            androidx.compose.runtime.CompositionLocalMap r8 = r12.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r18 = r18.getConstructor()
            kotlin.jvm.functions.Function3 r19 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            r33 = r0
            int r0 = r6 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r34 = r1
            r1 = 6
            r0 = r0 | r1
            r36 = r18
            r18 = r19
            r19 = 0
            androidx.compose.runtime.Applier r1 = r12.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x01a7
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01a7:
            r12.startReusableNode()
            boolean r1 = r12.getInserting()
            if (r1 == 0) goto L_0x01b6
            r1 = r36
            r12.createNode(r1)
            goto L_0x01bb
        L_0x01b6:
            r1 = r36
            r12.useNode()
        L_0x01bb:
            r36 = r1
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m2865constructorimpl(r12)
            r21 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r22 = androidx.compose.ui.node.ComposeUiNode.Companion
            r23 = r3
            kotlin.jvm.functions.Function2 r3 = r22.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r1, r5, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r1, r8, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            r22 = 0
            r24 = r1
            r25 = 0
            boolean r26 = r24.getInserting()
            if (r26 != 0) goto L_0x01ff
            r26 = r4
            java.lang.Object r4 = r24.rememberedValue()
            r27 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01fc
            goto L_0x0203
        L_0x01fc:
            r5 = r24
            goto L_0x0213
        L_0x01ff:
            r26 = r4
            r27 = r5
        L_0x0203:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            r5 = r24
            r5.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            r1.apply(r4, r3)
        L_0x0213:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r1)
            int r3 = r0 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = r18
            r4.invoke(r1, r12, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r1)
            int r1 = r0 >> 9
            r1 = r1 & 14
            r3 = r12
            r5 = 0
            r18 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r21 = r1
            java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r2 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r20 = 6
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r22 = r3
            r24 = 0
            r25 = r0
            r0 = 753555734(0x2cea5916, float:6.6605705E-12)
            r28 = r1
            java.lang.String r1 = "C78@3363L84:IconButton.kt#jmzs0o"
            r29 = r2
            r2 = r22
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            if (r15 == 0) goto L_0x0295
            r0 = 753555784(0x2cea5948, float:6.660592E-12)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "77@3320L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r20 = 0
            r22 = r1
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            r30 = r4
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r1, r4)
            java.lang.Object r1 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            java.lang.Number r1 = (java.lang.Number) r1
            float r0 = r1.floatValue()
            goto L_0x02a9
        L_0x0295:
            r30 = r4
            r0 = 753555810(0x2cea5962, float:6.6606035E-12)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "77@3346L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            androidx.compose.material.ContentAlpha r0 = androidx.compose.material.ContentAlpha.INSTANCE
            r1 = 6
            float r0 = r0.getDisabled(r2, r1)
        L_0x02a9:
            r2.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            java.lang.Float r4 = java.lang.Float.valueOf(r0)
            androidx.compose.runtime.ProvidedValue r1 = r1.provides(r4)
            r4 = 1
            androidx.compose.runtime.ProvidedValue[] r4 = new androidx.compose.runtime.ProvidedValue[r4]
            r20 = 0
            r4[r20] = r1
            int r1 = r13 >> 9
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 8
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r4, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r10, (androidx.compose.runtime.Composer) r2, (int) r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r12.endReplaceableGroup()
            r12.endNode()
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02e8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02e8:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 != 0) goto L_0x02ef
            goto L_0x0309
        L_0x02ef:
            androidx.compose.material.IconButtonKt$IconButton$3 r17 = new androidx.compose.material.IconButtonKt$IconButton$3
            r0 = r17
            r1 = r31
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r35
            r6 = r37
            r7 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x0309:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.IconButtonKt.IconButton(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void IconToggleButton(boolean r32, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r33, androidx.compose.ui.Modifier r34, boolean r35, androidx.compose.foundation.interaction.MutableInteractionSource r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r9 = r33
            r10 = r37
            r11 = r39
            java.lang.String r0 = "onCheckedChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -54657793(0xfffffffffcbdfcff, float:-7.891804E36)
            r1 = r38
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(IconToggleButton)P(!1,5,4,2,3)106@4699L39,118@5104L54,109@4784L629:IconButton.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r39
            r2 = r40 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            r13 = r32
            goto L_0x003d
        L_0x002a:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x003b
            r13 = r32
            boolean r2 = r12.changed((boolean) r13)
            if (r2 == 0) goto L_0x0038
            r2 = 4
            goto L_0x0039
        L_0x0038:
            r2 = 2
        L_0x0039:
            r1 = r1 | r2
            goto L_0x003d
        L_0x003b:
            r13 = r32
        L_0x003d:
            r2 = r40 & 2
            if (r2 == 0) goto L_0x0044
            r1 = r1 | 48
            goto L_0x0054
        L_0x0044:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r12.changedInstance(r9)
            if (r2 == 0) goto L_0x0051
            r2 = 32
            goto L_0x0053
        L_0x0051:
            r2 = 16
        L_0x0053:
            r1 = r1 | r2
        L_0x0054:
            r2 = r40 & 4
            if (r2 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r34
            goto L_0x0072
        L_0x005d:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0070
            r3 = r34
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x006c
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r4 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r4
            goto L_0x0072
        L_0x0070:
            r3 = r34
        L_0x0072:
            r4 = r40 & 8
            if (r4 == 0) goto L_0x007b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r35
            goto L_0x0090
        L_0x007b:
            r5 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x008e
            r5 = r35
            boolean r6 = r12.changed((boolean) r5)
            if (r6 == 0) goto L_0x008a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x008c
        L_0x008a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x008c:
            r1 = r1 | r6
            goto L_0x0090
        L_0x008e:
            r5 = r35
        L_0x0090:
            r6 = r40 & 16
            if (r6 == 0) goto L_0x0099
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r7 = r36
            goto L_0x00b0
        L_0x0099:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r11
            if (r7 != 0) goto L_0x00ae
            r7 = r36
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x00aa
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ac
        L_0x00aa:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x00ac:
            r1 = r1 | r8
            goto L_0x00b0
        L_0x00ae:
            r7 = r36
        L_0x00b0:
            r8 = r40 & 32
            if (r8 == 0) goto L_0x00b8
            r8 = 196608(0x30000, float:2.75506E-40)
        L_0x00b6:
            r1 = r1 | r8
            goto L_0x00c9
        L_0x00b8:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x00c9
            boolean r8 = r12.changedInstance(r10)
            if (r8 == 0) goto L_0x00c6
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00c6:
            r8 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b6
        L_0x00c9:
            r14 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r14
            r8 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r8) goto L_0x00e4
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x00da
            goto L_0x00e4
        L_0x00da:
            r12.skipToGroupEnd()
            r15 = r3
            r16 = r5
            r17 = r7
            goto L_0x0311
        L_0x00e4:
            if (r2 == 0) goto L_0x00ec
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r8 = r1
            goto L_0x00ed
        L_0x00ec:
            r8 = r3
        L_0x00ed:
            if (r4 == 0) goto L_0x00f2
            r1 = 1
            r15 = r1
            goto L_0x00f3
        L_0x00f2:
            r15 = r5
        L_0x00f3:
            if (r6 == 0) goto L_0x0129
            r1 = 0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            r3 = 0
            r4 = r12
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r17.getEmpty()
            if (r6 != r0) goto L_0x011e
            r0 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r4.updateRememberedValue(r0)
            goto L_0x011f
        L_0x011e:
            r0 = r6
        L_0x011f:
            r12.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r16 = r0
            goto L_0x012b
        L_0x0129:
            r16 = r7
        L_0x012b:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x013a
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.IconToggleButton (IconButton.kt:101)"
            r2 = -54657793(0xfffffffffcbdfcff, float:-7.891804E36)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r14, r0, r1)
        L_0x013a:
            androidx.compose.ui.Modifier r0 = androidx.compose.material.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r8)
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r17 = r1.m5163getCheckboxo7Vup1c()
            float r2 = RippleRadius
            r6 = 54
            r7 = 4
            r1 = 0
            r3 = 0
            r5 = r12
            androidx.compose.foundation.Indication r3 = androidx.compose.material.ripple.RippleKt.m1523rememberRipple9IZ8Weo(r1, r2, r3, r5, r6, r7)
            androidx.compose.ui.semantics.Role r5 = androidx.compose.ui.semantics.Role.m5155boximpl(r17)
            r1 = r32
            r2 = r16
            r4 = r15
            r6 = r33
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.ToggleableKt.m837toggleableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            r2 = 48
            r3 = 0
            r4 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r12.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            r4 = 0
            int r5 = r2 >> 3
            r5 = r5 & 14
            int r6 = r2 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r4, r12, r5)
            int r6 = r2 << 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r7 = 0
            r34 = r1
            r1 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = 0
            int r17 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r12, r1)
            androidx.compose.runtime.CompositionLocalMap r1 = r12.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r18 = r18.getConstructor()
            kotlin.jvm.functions.Function3 r19 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            r36 = r0
            int r0 = r6 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r38 = r3
            r3 = 6
            r0 = r0 | r3
            r20 = r19
            r19 = r18
            r18 = 0
            androidx.compose.runtime.Applier r3 = r12.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x01cb
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01cb:
            r12.startReusableNode()
            boolean r3 = r12.getInserting()
            if (r3 == 0) goto L_0x01da
            r3 = r19
            r12.createNode(r3)
            goto L_0x01df
        L_0x01da:
            r3 = r19
            r12.useNode()
        L_0x01df:
            r19 = r3
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m2865constructorimpl(r12)
            r22 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r23 = androidx.compose.ui.node.ComposeUiNode.Companion
            r24 = r4
            kotlin.jvm.functions.Function2 r4 = r23.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r3, r5, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r3, r1, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            r23 = 0
            r25 = r3
            r26 = 0
            boolean r27 = r25.getInserting()
            if (r27 != 0) goto L_0x0223
            r27 = r1
            java.lang.Object r1 = r25.rememberedValue()
            r28 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
            if (r1 != 0) goto L_0x0220
            goto L_0x0227
        L_0x0220:
            r5 = r25
            goto L_0x0237
        L_0x0223:
            r27 = r1
            r28 = r5
        L_0x0227:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            r5 = r25
            r5.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            r3.apply(r1, r4)
        L_0x0237:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r1)
            int r3 = r0 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = r20
            r4.invoke(r1, r12, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r1)
            int r1 = r0 >> 9
            r1 = r1 & 14
            r3 = r12
            r5 = 0
            r20 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r22 = r1
            java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r2 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r21 = 6
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r23 = r3
            r25 = 0
            r26 = r0
            r0 = -1866758134(0xffffffff90bb880a, float:-7.3968096E-29)
            r29 = r1
            java.lang.String r1 = "C123@5323L84:IconButton.kt#jmzs0o"
            r30 = r2
            r2 = r23
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            if (r15 == 0) goto L_0x02b9
            r0 = -1866758084(0xffffffff90bb883c, float:-7.3968397E-29)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "122@5280L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r21 = 0
            r23 = r1
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            r31 = r4
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r1, r4)
            java.lang.Object r1 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            java.lang.Number r1 = (java.lang.Number) r1
            float r0 = r1.floatValue()
            goto L_0x02cd
        L_0x02b9:
            r31 = r4
            r0 = -1866758058(0xffffffff90bb8856, float:-7.3968553E-29)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "122@5306L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            androidx.compose.material.ContentAlpha r0 = androidx.compose.material.ContentAlpha.INSTANCE
            r1 = 6
            float r0 = r0.getDisabled(r2, r1)
        L_0x02cd:
            r2.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            java.lang.Float r4 = java.lang.Float.valueOf(r0)
            androidx.compose.runtime.ProvidedValue r1 = r1.provides(r4)
            r4 = 1
            androidx.compose.runtime.ProvidedValue[] r4 = new androidx.compose.runtime.ProvidedValue[r4]
            r21 = 0
            r4[r21] = r1
            int r1 = r14 >> 12
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 8
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r4, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r10, (androidx.compose.runtime.Composer) r2, (int) r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r12.endReplaceableGroup()
            r12.endNode()
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x030c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x030c:
            r17 = r16
            r16 = r15
            r15 = r8
        L_0x0311:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 != 0) goto L_0x0318
            goto L_0x0336
        L_0x0318:
            androidx.compose.material.IconButtonKt$IconToggleButton$3 r18 = new androidx.compose.material.IconButtonKt$IconToggleButton$3
            r0 = r18
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r37
            r7 = r39
            r9 = r8
            r8 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0336:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.IconButtonKt.IconToggleButton(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}

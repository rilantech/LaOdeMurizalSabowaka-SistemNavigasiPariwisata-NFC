package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ak\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007¢\u0006\u0002\u0010\u0012\u001a]\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00170\b2.\b\u0002\u0010\u0018\u001a(\u0012\u0004\u0012\u00020\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001b0\u0019¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u001f\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"DismissThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "SwipeToDismiss", "", "state", "Landroidx/compose/material3/DismissState;", "background", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "dismissContent", "modifier", "Landroidx/compose/ui/Modifier;", "directions", "", "Landroidx/compose/material3/DismissDirection;", "(Landroidx/compose/material3/DismissState;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Ljava/util/Set;Landroidx/compose/runtime/Composer;II)V", "rememberDismissState", "initialValue", "Landroidx/compose/material3/DismissValue;", "confirmValueChange", "", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "(Landroidx/compose/material3/DismissValue;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DismissState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismiss.kt */
public final class SwipeToDismissKt {
    /* access modifiers changed from: private */
    public static final float DismissThreshold = Dp.m5844constructorimpl((float) 125);

    public static final DismissState rememberDismissState(DismissValue initialValue, Function1<? super DismissValue, Boolean> confirmValueChange, Function2<? super Density, ? super Float, Float> positionalThreshold, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-263967123);
        ComposerKt.sourceInformation($composer, "C(rememberDismissState)P(1)212@7855L83,211@7760L178:SwipeToDismiss.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialValue = DismissValue.Default;
        }
        Function1<? super DismissValue, Boolean> confirmValueChange2 = confirmValueChange;
        if ((i & 2) != 0) {
            confirmValueChange2 = SwipeToDismissKt$rememberDismissState$1.INSTANCE;
        }
        Function2<Density, Float, Float> positionalThreshold2 = positionalThreshold;
        if ((i & 4) != 0) {
            positionalThreshold2 = SwipeToDismissDefaults.INSTANCE.getFixedPositionalThreshold();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-263967123, $changed, -1, "androidx.compose.material3.rememberDismissState (SwipeToDismiss.kt:205)");
        }
        Object[] objArr = new Object[0];
        Saver<DismissState, DismissValue> Saver = DismissState.Companion.Saver(confirmValueChange2, positionalThreshold2);
        int i2 = ($changed & 14) | ($changed & 112) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) initialValue) | $composer.changed((Object) confirmValueChange2) | $composer.changed((Object) positionalThreshold2);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function0) new SwipeToDismissKt$rememberDismissState$2$1(initialValue, confirmValueChange2, positionalThreshold2);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        DismissState dismissState = (DismissState) RememberSaveableKt.rememberSaveable(objArr, Saver, (String) null, (Function0) value$iv$iv, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return dismissState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:91:0x04b6  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x04c2  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x04c6  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0567  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SwipeToDismiss(androidx.compose.material3.DismissState r54, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, androidx.compose.ui.Modifier r57, java.util.Set<? extends androidx.compose.material3.DismissDirection> r58, androidx.compose.runtime.Composer r59, int r60, int r61) {
        /*
            r8 = r54
            r9 = r55
            r10 = r56
            r11 = r60
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "background"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "dismissContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -373200705(0xffffffffe9c168bf, float:-2.9227167E25)
            r1 = r59
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SwipeToDismiss)P(4!1,2,3)238@8860L7,240@8896L1089:SwipeToDismiss.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r60
            r2 = r61 & 1
            if (r2 == 0) goto L_0x002f
            r1 = r1 | 6
            goto L_0x003d
        L_0x002f:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x003d
            boolean r2 = r12.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x003b
            r2 = 4
            goto L_0x003c
        L_0x003b:
            r2 = 2
        L_0x003c:
            r1 = r1 | r2
        L_0x003d:
            r2 = r61 & 2
            r3 = 16
            if (r2 == 0) goto L_0x0046
            r1 = r1 | 48
            goto L_0x0055
        L_0x0046:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0055
            boolean r2 = r12.changedInstance(r9)
            if (r2 == 0) goto L_0x0053
            r2 = 32
            goto L_0x0054
        L_0x0053:
            r2 = r3
        L_0x0054:
            r1 = r1 | r2
        L_0x0055:
            r2 = r61 & 4
            if (r2 == 0) goto L_0x005c
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x006c
        L_0x005c:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x006c
            boolean r2 = r12.changedInstance(r10)
            if (r2 == 0) goto L_0x0069
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r2 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r1 = r1 | r2
        L_0x006c:
            r2 = r61 & 8
            if (r2 == 0) goto L_0x0075
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r4 = r57
            goto L_0x008a
        L_0x0075:
            r4 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0088
            r4 = r57
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0084
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r1 = r1 | r5
            goto L_0x008a
        L_0x0088:
            r4 = r57
        L_0x008a:
            r5 = r61 & 16
            if (r5 == 0) goto L_0x0090
            r1 = r1 | 8192(0x2000, float:1.14794E-41)
        L_0x0090:
            r13 = r1
            if (r5 != r3) goto L_0x00ad
            r1 = 46811(0xb6db, float:6.5596E-41)
            r1 = r1 & r13
            r3 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r3) goto L_0x00ad
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x00a2
            goto L_0x00ad
        L_0x00a2:
            r12.skipToGroupEnd()
            r20 = r58
            r9 = r4
            r8 = r10
            r47 = r12
            goto L_0x056c
        L_0x00ad:
            if (r2 == 0) goto L_0x00b4
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00b5
        L_0x00b4:
            r1 = r4
        L_0x00b5:
            if (r5 == 0) goto L_0x00c4
            androidx.compose.material3.DismissDirection r2 = androidx.compose.material3.DismissDirection.EndToStart
            androidx.compose.material3.DismissDirection r3 = androidx.compose.material3.DismissDirection.StartToEnd
            androidx.compose.material3.DismissDirection[] r2 = new androidx.compose.material3.DismissDirection[]{r2, r3}
            java.util.Set r2 = kotlin.collections.SetsKt.setOf(r2)
            goto L_0x00c6
        L_0x00c4:
            r2 = r58
        L_0x00c6:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x00d2
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.SwipeToDismiss (SwipeToDismiss.kt:231)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r3, r4)
        L_0x00d2:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r3 = 0
            r4 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r5, r6)
            java.lang.Object r6 = r12.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.LayoutDirection r0 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r3 = 0
            r4 = 1
            if (r6 != r0) goto L_0x00f2
            r18 = r4
            goto L_0x00f4
        L_0x00f2:
            r18 = r3
        L_0x00f4:
            androidx.compose.material3.SwipeableV2State r15 = r54.getSwipeableState$material3_release()
            androidx.compose.foundation.gestures.Orientation r16 = androidx.compose.foundation.gestures.Orientation.Horizontal
            androidx.compose.material3.DismissValue r0 = r54.getCurrentValue()
            androidx.compose.material3.DismissValue r6 = androidx.compose.material3.DismissValue.Default
            if (r0 != r6) goto L_0x0106
            r17 = r4
            goto L_0x0108
        L_0x0106:
            r17 = r3
        L_0x0108:
            r20 = 16
            r21 = 0
            r19 = 0
            r14 = r1
            androidx.compose.ui.Modifier r22 = androidx.compose.material3.SwipeableV2Kt.swipeableV2$default(r14, r15, r16, r17, r18, r19, r20, r21)
            androidx.compose.material3.SwipeableV2State r23 = r54.getSwipeableState$material3_release()
            androidx.compose.material3.DismissValue r0 = androidx.compose.material3.DismissValue.Default
            androidx.compose.material3.DismissValue r4 = androidx.compose.material3.DismissValue.DismissedToEnd
            androidx.compose.material3.DismissValue r6 = androidx.compose.material3.DismissValue.DismissedToStart
            androidx.compose.material3.DismissValue[] r0 = new androidx.compose.material3.DismissValue[]{r0, r4, r6}
            java.util.Set r24 = kotlin.collections.SetsKt.setOf(r0)
            androidx.compose.material3.SwipeToDismissKt$SwipeToDismiss$1 r0 = new androidx.compose.material3.SwipeToDismissKt$SwipeToDismiss$1
            r0.<init>(r2)
            r26 = r0
            kotlin.jvm.functions.Function2 r26 = (kotlin.jvm.functions.Function2) r26
            r27 = 4
            r28 = 0
            r25 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.material3.SwipeableV2Kt.swipeAnchors$default(r22, r23, r24, r25, r26, r27, r28)
            r4 = 0
            r6 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r12.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r6)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getTopStart()
            r7 = 0
            int r14 = r3 >> 3
            r14 = r14 & 14
            int r15 = r3 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r14 = r14 | r15
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r6, r7, r12, r14)
            int r15 = r3 << 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r16 = 0
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r5)
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r59 = r1
            r1 = r17
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r17 = 6
            r19 = 0
            r20 = r2
            java.lang.String r2 = "C:CompositionLocal.kt#9igjgp"
            r21 = r4
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r4, r2)
            java.lang.Object r4 = r12.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r1 = r4
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r17 = 6
            r19 = 0
            r22 = r6
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r6, r2)
            java.lang.Object r6 = r12.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r4 = r6
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r17 = 6
            r19 = 0
            r23 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r7, r2)
            java.lang.Object r7 = r12.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r6 = r7
            androidx.compose.ui.platform.ViewConfiguration r6 = (androidx.compose.ui.platform.ViewConfiguration) r6
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r17 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            r19 = r0
            int r0 = r15 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r24 = r17
            r17 = 0
            androidx.compose.runtime.Applier r11 = r12.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x01ea
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01ea:
            r12.startReusableNode()
            boolean r11 = r12.getInserting()
            if (r11 == 0) goto L_0x01f7
            r12.createNode(r7)
            goto L_0x01fa
        L_0x01f7:
            r12.useNode()
        L_0x01fa:
            r12.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2865constructorimpl(r12)
            r25 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r26 = androidx.compose.ui.node.ComposeUiNode.Companion
            r27 = r7
            kotlin.jvm.functions.Function2 r7 = r26.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r11, r14, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r11, r1, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r11, r4, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r11, r6, r7)
            r12.enableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r7)
            int r11 = r0 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r25 = r1
            r1 = r24
            r1.invoke(r7, r12, r11)
            r7 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r7)
            int r11 = r0 >> 9
            r11 = r11 & 14
            r24 = r12
            r26 = 0
            r7 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r29 = r0
            java.lang.String r0 = "C72@3384L9:Box.kt#2w3rfo"
            r30 = r1
            r1 = r24
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r7, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r7 = r3 >> 6
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r7 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r31 = 0
            r32 = r3
            r3 = 1356535017(0x50db14e9, float:2.94046454E10)
            r33 = r4
            java.lang.String r4 = "C260@9696L110,266@9909L52,264@9819L156:SwipeToDismiss.kt#uh7d8r"
            r34 = r6
            r6 = r24
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r4)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Modifier r3 = r0.matchParentSize(r3)
            int r4 = r13 << 6
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r24 = 0
            r35 = r0
            r0 = 693286680(0x2952b718, float:4.6788176E-14)
            r6.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            androidx.compose.foundation.layout.Arrangement r37 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            r38 = r7
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = r37.getStart()
            androidx.compose.ui.Alignment$Companion r37 = androidx.compose.ui.Alignment.Companion
            r39 = r11
            androidx.compose.ui.Alignment$Vertical r11 = r37.getTop()
            int r37 = r4 >> 3
            r37 = r37 & 14
            int r40 = r4 >> 3
            r40 = r40 & 112(0x70, float:1.57E-43)
            r41 = r14
            r14 = r37 | r40
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r7, r11, r6, r14)
            int r37 = r4 << 3
            r37 = r37 & 112(0x70, float:1.57E-43)
            r40 = 0
            r42 = r7
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r6.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r5)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r43 = 6
            r44 = 0
            r45 = r11
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r11, r2)
            java.lang.Object r11 = r6.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r7 = r11
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r43 = 6
            r44 = 0
            r46 = r15
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r15, r2)
            java.lang.Object r15 = r6.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r11 = r15
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r43 = 6
            r44 = 0
            r47 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r12, r2)
            java.lang.Object r12 = r6.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.platform.ViewConfiguration r12 = (androidx.compose.ui.platform.ViewConfiguration) r12
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            r43 = r1
            int r1 = r37 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | 6
            r44 = 0
            androidx.compose.runtime.Applier r10 = r6.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x033d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x033d:
            r6.startReusableNode()
            boolean r10 = r6.getInserting()
            if (r10 == 0) goto L_0x034a
            r6.createNode(r15)
            goto L_0x034d
        L_0x034a:
            r6.useNode()
        L_0x034d:
            r6.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m2865constructorimpl(r6)
            r48 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r49 = androidx.compose.ui.node.ComposeUiNode.Companion
            r50 = r15
            kotlin.jvm.functions.Function2 r15 = r49.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r10, r14, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r10, r7, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r10, r11, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r10, r12, r15)
            r6.enableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r6)
            androidx.compose.runtime.SkippableUpdater r10 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r10)
            int r15 = r1 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r3.invoke(r10, r6, r15)
            r10 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r6.startReplaceableGroup(r10)
            int r10 = r1 >> 9
            r10 = r10 & 14
            r15 = r6
            r48 = 0
            r49 = r1
            r1 = -326682283(0xffffffffec873955, float:-1.3078058E27)
            r51 = r3
            java.lang.String r3 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r1, r3)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r52 = r4 >> 6
            r52 = r52 & 112(0x70, float:1.57E-43)
            r52 = r52 | 6
            r53 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r52)
            r9.invoke(r1, r15, r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r6.endReplaceableGroup()
            r6.endNode()
            r6.endReplaceableGroup()
            r6.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r4 = r13 & 14
            r7 = 0
            r10 = 1157296644(0x44faf204, float:2007.563)
            r6.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r10)
            boolean r10 = r6.changed((java.lang.Object) r8)
            r11 = r6
            r12 = 0
            java.lang.Object r14 = r11.rememberedValue()
            r15 = 0
            if (r10 != 0) goto L_0x03fc
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r37 = r4
            java.lang.Object r4 = r24.getEmpty()
            if (r14 != r4) goto L_0x03fa
            goto L_0x03fe
        L_0x03fa:
            r4 = r14
            goto L_0x040d
        L_0x03fc:
            r37 = r4
        L_0x03fe:
            r4 = 0
            r24 = r4
            androidx.compose.material3.SwipeToDismissKt$SwipeToDismiss$2$1$1 r4 = new androidx.compose.material3.SwipeToDismissKt$SwipeToDismiss$2$1$1
            r4.<init>(r8)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r11.updateRememberedValue(r4)
        L_0x040d:
            r6.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.OffsetKt.offset(r1, r4)
            int r4 = r13 << 3
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r7 = 0
            r10 = 693286680(0x2952b718, float:4.6788176E-14)
            r6.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r0 = r0.getStart()
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r10 = r10.getTop()
            int r11 = r4 >> 3
            r11 = r11 & 14
            int r12 = r4 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r0, r10, r6, r11)
            int r12 = r4 << 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r14 = 0
            r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r6.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r5)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r15 = 6
            r24 = 0
            r58 = r0
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r2)
            java.lang.Object r0 = r6.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r15 = 6
            r24 = 0
            r36 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r7, r2)
            java.lang.Object r7 = r6.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r5 = r7
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r15 = 6
            r24 = 0
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r8, r2)
            java.lang.Object r2 = r6.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.platform.ViewConfiguration r2 = (androidx.compose.ui.platform.ViewConfiguration) r2
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            int r8 = r12 << 9
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | 6
            r15 = 0
            androidx.compose.runtime.Applier r9 = r6.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x04b9
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x04b9:
            r6.startReusableNode()
            boolean r9 = r6.getInserting()
            if (r9 == 0) goto L_0x04c6
            r6.createNode(r7)
            goto L_0x04c9
        L_0x04c6:
            r6.useNode()
        L_0x04c9:
            r6.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m2865constructorimpl(r6)
            r24 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r37 = androidx.compose.ui.node.ComposeUiNode.Companion
            r57 = r7
            kotlin.jvm.functions.Function2 r7 = r37.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r9, r11, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r9, r0, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r9, r5, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r9, r2, r7)
            r6.enableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r6)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r7)
            int r9 = r8 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r1.invoke(r7, r6, r9)
            r7 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r6.startReplaceableGroup(r7)
            int r7 = r8 >> 9
            r7 = r7 & 14
            r9 = r6
            r24 = 0
            r28 = r0
            r0 = -326682283(0xffffffffec873955, float:-1.3078058E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r0, r3)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r3 = r4 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r37 = r8
            r8 = r56
            r8.invoke(r0, r9, r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r6.endReplaceableGroup()
            r6.endNode()
            r6.endReplaceableGroup()
            r6.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r43)
            r47.endReplaceableGroup()
            r47.endNode()
            r47.endReplaceableGroup()
            r47.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x056a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x056a:
            r9 = r59
        L_0x056c:
            androidx.compose.runtime.ScopeUpdateScope r10 = r47.endRestartGroup()
            if (r10 != 0) goto L_0x0573
            goto L_0x058b
        L_0x0573:
            androidx.compose.material3.SwipeToDismissKt$SwipeToDismiss$3 r11 = new androidx.compose.material3.SwipeToDismissKt$SwipeToDismiss$3
            r0 = r11
            r1 = r54
            r2 = r55
            r3 = r56
            r4 = r9
            r5 = r20
            r6 = r60
            r7 = r61
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x058b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeToDismissKt.SwipeToDismiss(androidx.compose.material3.DismissState, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, java.util.Set, androidx.compose.runtime.Composer, int, int):void");
    }
}

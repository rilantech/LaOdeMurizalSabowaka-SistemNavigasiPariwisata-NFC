package androidx.compose.material;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "invoke", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$ModalDrawer$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerKt$ModalDrawer$1(DrawerState drawerState, boolean z, int i, long j, Shape shape, long j2, long j3, float f, Function2<? super Composer, ? super Integer, Unit> function2, CoroutineScope coroutineScope, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$drawerState = drawerState;
        this.$gesturesEnabled = z;
        this.$$dirty = i;
        this.$scrimColor = j;
        this.$drawerShape = shape;
        this.$drawerBackgroundColor = j2;
        this.$drawerContentColor = j3;
        this.$drawerElevation = f;
        this.$content = function2;
        this.$scope = coroutineScope;
        this.$drawerContent = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((BoxWithConstraintsScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0326  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x03f0  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x048e  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0492  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0522  */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r73, androidx.compose.runtime.Composer r74, int r75) {
        /*
            r72 = this;
            r0 = r72
            r1 = r73
            r2 = r74
            r3 = r75
            java.lang.String r4 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "C531@19307L7,532@19334L217,532@19323L228,538@19594L7,539@19633L2681:Drawer.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r4)
            r4 = r75
            r5 = r3 & 14
            if (r5 != 0) goto L_0x0022
            boolean r5 = r2.changed((java.lang.Object) r1)
            if (r5 == 0) goto L_0x0020
            r5 = 4
            goto L_0x0021
        L_0x0020:
            r5 = 2
        L_0x0021:
            r4 = r4 | r5
        L_0x0022:
            r5 = r4 & 91
            r6 = 18
            if (r5 != r6) goto L_0x0036
            boolean r5 = r74.getSkipping()
            if (r5 != 0) goto L_0x002f
            goto L_0x0036
        L_0x002f:
            r74.skipToGroupEnd()
            r21 = r4
            goto L_0x0525
        L_0x0036:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0045
            r5 = -1
            java.lang.String r6 = "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:522)"
            r7 = 816674999(0x30ad78b7, float:1.2621716E-9)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r5, r6)
        L_0x0045:
            long r5 = r73.m2169getConstraintsmsEJaDk()
            boolean r7 = androidx.compose.ui.unit.Constraints.m7494getHasBoundedWidthimpl(r5)
            if (r7 == 0) goto L_0x0526
            int r7 = androidx.compose.ui.unit.Constraints.m7498getMaxWidthimpl(r5)
            float r7 = (float) r7
            float r7 = -r7
            r8 = 0
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r10 = 0
            r11 = 0
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r12, r13)
            java.lang.Object r14 = r2.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r74)
            r9 = r14
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.material.DrawerState r10 = r0.$drawerState
            java.lang.Float r11 = java.lang.Float.valueOf(r7)
            java.lang.Float r14 = java.lang.Float.valueOf(r8)
            java.lang.Object[] r10 = new java.lang.Object[]{r10, r9, r11, r14}
            androidx.compose.material.DrawerState r11 = r0.$drawerState
            r14 = 8
            r15 = 0
            r12 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r2.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r12)
            r17 = 0
            int r1 = r10.length
            r3 = 0
        L_0x0092:
            if (r3 >= r1) goto L_0x00a3
            r18 = r1
            r1 = r10[r3]
            boolean r19 = r2.changed((java.lang.Object) r1)
            r17 = r17 | r19
            int r3 = r3 + 1
            r1 = r18
            goto L_0x0092
        L_0x00a3:
            r1 = r74
            r3 = 0
            r18 = r3
            java.lang.Object r3 = r1.rememberedValue()
            r19 = 0
            if (r17 != 0) goto L_0x00be
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r4
            java.lang.Object r4 = r20.getEmpty()
            if (r3 != r4) goto L_0x00bb
            goto L_0x00c0
        L_0x00bb:
            r20 = r3
            goto L_0x00cf
        L_0x00be:
            r21 = r4
        L_0x00c0:
            r4 = 0
            r20 = r3
            androidx.compose.material.DrawerKt$ModalDrawer$1$1$1 r3 = new androidx.compose.material.DrawerKt$ModalDrawer$1$1$1
            r3.<init>(r11, r9, r7, r8)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r1.updateRememberedValue(r3)
        L_0x00cf:
            r74.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r1 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r3, r2, r1)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r3 = 0
            r4 = 0
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r10, r13)
            java.lang.Object r10 = r2.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r74)
            androidx.compose.ui.unit.LayoutDirection r1 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r10 != r1) goto L_0x00f6
            r26 = 1
            goto L_0x00f8
        L_0x00f6:
            r26 = 0
        L_0x00f8:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r22 = r1
            androidx.compose.ui.Modifier r22 = (androidx.compose.ui.Modifier) r22
            androidx.compose.material.DrawerState r1 = r0.$drawerState
            androidx.compose.material.AnchoredDraggableState r23 = r1.getAnchoredDraggableState$material_release()
            androidx.compose.foundation.gestures.Orientation r24 = androidx.compose.foundation.gestures.Orientation.Horizontal
            boolean r1 = r0.$gesturesEnabled
            r28 = 16
            r29 = 0
            r27 = 0
            r25 = r1
            androidx.compose.ui.Modifier r1 = androidx.compose.material.AnchoredDraggableKt.anchoredDraggable$default(r22, r23, r24, r25, r26, r27, r28, r29)
            androidx.compose.material.DrawerState r4 = r0.$drawerState
            int r10 = r0.$$dirty
            long r14 = r0.$scrimColor
            androidx.compose.ui.graphics.Shape r11 = r0.$drawerShape
            r18 = r4
            long r3 = r0.$drawerBackgroundColor
            r19 = r3
            long r3 = r0.$drawerContentColor
            r22 = r9
            float r9 = r0.$drawerElevation
            r23 = r9
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r9 = r0.$content
            r24 = r3
            boolean r3 = r0.$gesturesEnabled
            kotlinx.coroutines.CoroutineScope r4 = r0.$scope
            r34 = r11
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r11 = r0.$drawerContent
            r27 = 0
            r39 = r27
            r40 = 0
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            androidx.compose.ui.Alignment$Companion r28 = androidx.compose.ui.Alignment.Companion
            r35 = r11
            androidx.compose.ui.Alignment r11 = r28.getTopStart()
            r36 = r12
            r12 = 0
            int r28 = r39 >> 3
            r28 = r28 & 14
            int r29 = r39 >> 3
            r29 = r29 & 112(0x70, float:1.57E-43)
            r41 = r5
            r5 = r28 | r29
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r11, r12, r2, r5)
            int r6 = r39 << 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r43 = 0
            r44 = r11
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r11)
            r45 = r12
            r12 = 0
            int r46 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r12)
            androidx.compose.runtime.CompositionLocalMap r12 = r74.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r29 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r29 = r29.getConstructor()
            kotlin.jvm.functions.Function3 r30 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r1)
            r47 = r1
            int r1 = r6 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r48 = r6
            r6 = 6
            r1 = r1 | r6
            r49 = r29
            r50 = r30
            r51 = 0
            androidx.compose.runtime.Applier r6 = r74.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x01a7
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01a7:
            r74.startReusableNode()
            boolean r6 = r74.getInserting()
            if (r6 == 0) goto L_0x01b6
            r6 = r49
            r2.createNode(r6)
            goto L_0x01bb
        L_0x01b6:
            r6 = r49
            r74.useNode()
        L_0x01bb:
            r49 = r6
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m4575constructorimpl(r74)
            r29 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r30 = androidx.compose.ui.node.ComposeUiNode.Companion
            r38 = r13
            kotlin.jvm.functions.Function2 r13 = r30.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r6, r5, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r6, r12, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetCompositeKeyHash()
            r30 = 0
            r31 = r6
            r32 = 0
            boolean r33 = r31.getInserting()
            if (r33 != 0) goto L_0x01ff
            r52 = r5
            java.lang.Object r5 = r31.rememberedValue()
            r53 = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r46)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r12)
            if (r5 != 0) goto L_0x01fc
            goto L_0x0203
        L_0x01fc:
            r12 = r31
            goto L_0x0213
        L_0x01ff:
            r52 = r5
            r53 = r12
        L_0x0203:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r46)
            r12 = r31
            r12.updateRememberedValue(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r46)
            r6.apply(r5, r13)
        L_0x0213:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r74)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r5)
            int r6 = r1 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r12 = r50
            r12.invoke(r5, r2, r6)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r5)
            int r6 = r1 >> 9
            r6 = r6 & 14
            r13 = r74
            r50 = 0
            r5 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r54 = r1
            java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r30 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r31 = r39 >> 6
            r31 = r31 & 112(0x70, float:1.57E-43)
            r32 = 6
            r55 = r31 | 6
            r56 = r30
            androidx.compose.foundation.layout.BoxScope r56 = (androidx.compose.foundation.layout.BoxScope) r56
            r57 = r13
            r58 = 0
            r5 = 413829465(0x18aa8959, float:4.4082656E-24)
            java.lang.String r2 = "C548@19951L45,561@20406L106,551@20009L553,566@20596L33,*568@20696L7,577@21160L222,567@20642L1662:Drawer.kt#jmzs0o"
            r59 = r6
            r6 = r57
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r5, r2)
            r2 = 0
            r5 = 0
            r31 = r5
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r6.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            r57 = r12
            r12 = 0
            int r27 = r2 >> 3
            r27 = r27 & 14
            int r32 = r2 >> 3
            r32 = r32 & 112(0x70, float:1.57E-43)
            r60 = r13
            r13 = r27 | r32
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r12, r6, r13)
            int r27 = r2 << 3
            r27 = r27 & 112(0x70, float:1.57E-43)
            r32 = 0
            r33 = r5
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r6.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r11)
            r5 = 0
            int r11 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r6, r5)
            androidx.compose.runtime.CompositionLocalMap r5 = r6.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r28 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r28 = r28.getConstructor()
            kotlin.jvm.functions.Function3 r61 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            r62 = r0
            int r0 = r27 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r37 = 6
            r0 = r0 | 6
            r63 = r28
            r28 = r61
            r61 = 0
            r64 = r12
            androidx.compose.runtime.Applier r12 = r6.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x02cf
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02cf:
            r6.startReusableNode()
            boolean r12 = r6.getInserting()
            if (r12 == 0) goto L_0x02de
            r12 = r63
            r6.createNode(r12)
            goto L_0x02e3
        L_0x02de:
            r12 = r63
            r6.useNode()
        L_0x02e3:
            r63 = r12
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m4575constructorimpl(r6)
            r65 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r66 = androidx.compose.ui.node.ComposeUiNode.Companion
            r67 = r14
            kotlin.jvm.functions.Function2 r14 = r66.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r13, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r5, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetCompositeKeyHash()
            r15 = 0
            r66 = r12
            r69 = 0
            boolean r70 = r66.getInserting()
            if (r70 != 0) goto L_0x0326
            r70 = r5
            java.lang.Object r5 = r66.rememberedValue()
            r71 = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r13)
            if (r5 != 0) goto L_0x0323
            goto L_0x032a
        L_0x0323:
            r13 = r66
            goto L_0x033a
        L_0x0326:
            r70 = r5
            r71 = r13
        L_0x032a:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r13 = r66
            r13.updateRememberedValue(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r12.apply(r5, r14)
        L_0x033a:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r6)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r5)
            int r12 = r0 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r13 = r28
            r13.invoke(r5, r6, r12)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r6.startReplaceableGroup(r5)
            int r5 = r0 >> 9
            r5 = r5 & 14
            r12 = r6
            r14 = 0
            r15 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r15, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r15 = r2 >> 6
            r15 = r15 & 112(0x70, float:1.57E-43)
            r28 = 6
            r15 = r15 | 6
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r28 = r12
            r29 = 0
            r30 = r0
            r0 = 392281232(0x1761bc90, float:7.293942E-25)
            r65 = r1
            java.lang.String r1 = "C549@19973L9:Drawer.kt#jmzs0o"
            r66 = r2
            r2 = r28
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            int r0 = r10 >> 27
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.invoke(r2, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r6.endReplaceableGroup()
            r6.endNode()
            r6.endReplaceableGroup()
            r6.endReplaceableGroup()
            boolean r27 = r18.isOpen()
            androidx.compose.material.DrawerKt$ModalDrawer$1$2$2 r0 = new androidx.compose.material.DrawerKt$ModalDrawer$1$2$2
            r1 = r18
            r0.<init>(r3, r1, r4)
            r28 = r0
            kotlin.jvm.functions.Function0 r28 = (kotlin.jvm.functions.Function0) r28
            java.lang.Float r0 = java.lang.Float.valueOf(r7)
            java.lang.Float r2 = java.lang.Float.valueOf(r8)
            r3 = r10 & 896(0x380, float:1.256E-42)
            r3 = r3 | 48
            r5 = 0
            r9 = 1618982084(0x607fb4c4, float:7.370227E19)
            r6.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r9)
            boolean r9 = r6.changed((java.lang.Object) r0)
            boolean r11 = r6.changed((java.lang.Object) r2)
            r9 = r9 | r11
            boolean r11 = r6.changed((java.lang.Object) r1)
            r9 = r9 | r11
            r11 = r6
            r12 = 0
            java.lang.Object r13 = r11.rememberedValue()
            r14 = 0
            if (r9 != 0) goto L_0x03f4
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r13 != r15) goto L_0x03f0
            goto L_0x03f4
        L_0x03f0:
            r18 = r0
            r0 = r13
            goto L_0x0403
        L_0x03f4:
            r15 = 0
            r18 = r0
            androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1 r0 = new androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
            r0.<init>(r7, r8, r1)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r11.updateRememberedValue(r0)
        L_0x0403:
            r6.endReplaceableGroup()
            r29 = r0
            kotlin.jvm.functions.Function0 r29 = (kotlin.jvm.functions.Function0) r29
            int r0 = r10 >> 15
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r30 = r67
            r32 = r6
            r33 = r0
            androidx.compose.material.DrawerKt.m2995ScrimBx497Mc(r27, r28, r29, r30, r32, r33)
            androidx.compose.material.Strings$Companion r0 = androidx.compose.material.Strings.Companion
            int r0 = r0.m3125getNavigationMenuUdPEhr4()
            r2 = 6
            java.lang.String r0 = androidx.compose.material.Strings_androidKt.m3128getString4foXLRw(r0, r6, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 0
            r5 = 0
            r9 = r38
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r11, r9)
            java.lang.Object r9 = r6.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r2 = r9
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            r3 = 0
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            int r9 = androidx.compose.ui.unit.Constraints.m7500getMinWidthimpl(r41)
            float r9 = r2.m7532toDpu2uoSUM((int) r9)
            int r11 = androidx.compose.ui.unit.Constraints.m7499getMinHeightimpl(r41)
            float r11 = r2.m7532toDpu2uoSUM((int) r11)
            int r12 = androidx.compose.ui.unit.Constraints.m7498getMaxWidthimpl(r41)
            float r12 = r2.m7532toDpu2uoSUM((int) r12)
            int r13 = androidx.compose.ui.unit.Constraints.m7497getMaxHeightimpl(r41)
            float r13 = r2.m7532toDpu2uoSUM((int) r13)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m2325sizeInqDBjuR0(r5, r9, r11, r12, r13)
            int r3 = r10 >> 6
            r3 = r3 & 14
            r5 = 0
            r9 = 1157296644(0x44faf204, float:2007.563)
            r6.startReplaceableGroup(r9)
            r9 = r36
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r9)
            boolean r9 = r6.changed((java.lang.Object) r1)
            r11 = r6
            r12 = 0
            java.lang.Object r13 = r11.rememberedValue()
            r14 = 0
            if (r9 != 0) goto L_0x0492
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r13 != r15) goto L_0x048e
            goto L_0x0492
        L_0x048e:
            r16 = r3
            r3 = r13
            goto L_0x04a1
        L_0x0492:
            r15 = 0
            r16 = r3
            androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1 r3 = new androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
            r3.<init>(r1)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r11.updateRememberedValue(r3)
        L_0x04a1:
            r6.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.ui.Modifier r27 = androidx.compose.foundation.layout.OffsetKt.offset(r2, r3)
            float r30 = androidx.compose.material.DrawerKt.EndDrawerPadding
            r32 = 11
            r33 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m2252paddingqDBjuR0$default(r27, r28, r29, r30, r31, r32, r33)
            androidx.compose.material.DrawerKt$ModalDrawer$1$2$6 r3 = new androidx.compose.material.DrawerKt$ModalDrawer$1$2$6
            r3.<init>(r0, r1, r4)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r1 = 0
            r4 = 1
            r5 = 0
            androidx.compose.ui.Modifier r27 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r5, r3, r4, r1)
            androidx.compose.material.DrawerKt$ModalDrawer$1$2$7 r1 = new androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
            r2 = r35
            r1.<init>(r2, r10)
            r2 = -1941234439(0xffffffff8c4b1cf9, float:-1.564727E-31)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r6, r2, r4, r1)
            r35 = r1
            kotlin.jvm.functions.Function2 r35 = (kotlin.jvm.functions.Function2) r35
            int r1 = r10 >> 9
            r1 = r1 & 112(0x70, float:1.57E-43)
            r2 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r2
            int r2 = r10 >> 12
            r3 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r10
            r37 = r1 | r2
            r38 = 16
            r28 = r34
            r29 = r19
            r31 = r24
            r34 = r23
            r36 = r6
            androidx.compose.material.SurfaceKt.m3130SurfaceFjzlyU(r27, r28, r29, r31, r33, r34, r35, r36, r37, r38)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r60)
            r74.endReplaceableGroup()
            r74.endNode()
            r74.endReplaceableGroup()
            r74.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0525
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0525:
            return
        L_0x0526:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Drawer shouldn't have infinite width"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt$ModalDrawer$1.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }
}

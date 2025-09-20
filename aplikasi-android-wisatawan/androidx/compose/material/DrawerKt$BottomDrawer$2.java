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
final class DrawerKt$BottomDrawer$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ BottomDrawerState $drawerState;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerKt$BottomDrawer$2(boolean z, BottomDrawerState bottomDrawerState, Function2<? super Composer, ? super Integer, Unit> function2, int i, long j, CoroutineScope coroutineScope, Shape shape, long j2, long j3, float f, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$gesturesEnabled = z;
        this.$drawerState = bottomDrawerState;
        this.$content = function2;
        this.$$dirty = i;
        this.$scrimColor = j;
        this.$scope = coroutineScope;
        this.$drawerShape = shape;
        this.$drawerBackgroundColor = j2;
        this.$drawerContentColor = j3;
        this.$drawerElevation = f;
        this.$drawerContent = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((BoxWithConstraintsScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r58, androidx.compose.runtime.Composer r59, int r60) {
        /*
            r57 = this;
            r0 = r57
            r1 = r58
            r2 = r59
            r3 = r60
            java.lang.String r4 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "C*665@25171L7,677@25586L7,688@25934L2655:Drawer.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r4)
            r4 = r60
            r5 = r3 & 14
            r6 = 2
            if (r5 != 0) goto L_0x0023
            boolean r5 = r2.changed((java.lang.Object) r1)
            if (r5 == 0) goto L_0x0021
            r5 = 4
            goto L_0x0022
        L_0x0021:
            r5 = r6
        L_0x0022:
            r4 = r4 | r5
        L_0x0023:
            r5 = r4 & 91
            r7 = 18
            if (r5 != r7) goto L_0x0037
            boolean r5 = r59.getSkipping()
            if (r5 != 0) goto L_0x0030
            goto L_0x0037
        L_0x0030:
            r59.skipToGroupEnd()
            r37 = r4
            goto L_0x033b
        L_0x0037:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0046
            r5 = -1
            java.lang.String r7 = "androidx.compose.material.BottomDrawer.<anonymous> (Drawer.kt:661)"
            r8 = 1220102512(0x48b94970, float:379467.5)
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r3, r5, r7)
        L_0x0046:
            long r7 = r58.m459getConstraintsmsEJaDk()
            int r5 = androidx.compose.ui.unit.Constraints.m5787getMaxHeightimpl(r7)
            float r5 = (float) r5
            long r7 = r58.m459getConstraintsmsEJaDk()
            int r7 = androidx.compose.ui.unit.Constraints.m5788getMaxWidthimpl(r7)
            long r8 = r58.m459getConstraintsmsEJaDk()
            int r8 = androidx.compose.ui.unit.Constraints.m5787getMaxHeightimpl(r8)
            if (r7 <= r8) goto L_0x0063
            r7 = 1
            goto L_0x0064
        L_0x0063:
            r7 = 0
        L_0x0064:
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r11 = 0
            r12 = 0
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r14 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r13, r14)
            java.lang.Object r15 = r2.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r59)
            r8 = r15
            androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
            r11 = 0
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            r15 = r12
            androidx.compose.ui.Modifier r15 = (androidx.compose.ui.Modifier) r15
            long r16 = r58.m459getConstraintsmsEJaDk()
            int r12 = androidx.compose.ui.unit.Constraints.m5788getMaxWidthimpl(r16)
            float r18 = r8.m5822toDpu2uoSUM((int) r12)
            long r16 = r58.m459getConstraintsmsEJaDk()
            int r12 = androidx.compose.ui.unit.Constraints.m5787getMaxHeightimpl(r16)
            float r19 = r8.m5822toDpu2uoSUM((int) r12)
            r20 = 3
            r21 = 0
            r16 = 0
            r17 = 0
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.SizeKt.m616sizeInqDBjuR0$default(r15, r16, r17, r18, r19, r20, r21)
            boolean r11 = r0.$gesturesEnabled
            r12 = 0
            if (r11 == 0) goto L_0x00be
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
            androidx.compose.material.BottomDrawerState r15 = r0.$drawerState
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r15 = r15.getNestedScrollConnection$material_release()
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r11, r15, r12, r6, r12)
            goto L_0x00c2
        L_0x00be:
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
        L_0x00c2:
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r15 = 0
            r16 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r13, r14)
            java.lang.Object r13 = r2.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r59)
            androidx.compose.ui.unit.LayoutDirection r11 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r13 != r11) goto L_0x00dd
            r18 = 1
            goto L_0x00df
        L_0x00dd:
            r18 = 0
        L_0x00df:
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r14 = r11.then(r6)
            androidx.compose.material.BottomDrawerState r11 = r0.$drawerState
            androidx.compose.material.AnchoredDraggableState r15 = r11.getAnchoredDraggableState$material_release()
            androidx.compose.foundation.gestures.Orientation r16 = androidx.compose.foundation.gestures.Orientation.Vertical
            boolean r11 = r0.$gesturesEnabled
            r20 = 16
            r21 = 0
            r19 = 0
            r17 = r11
            androidx.compose.ui.Modifier r11 = androidx.compose.material.AnchoredDraggableKt.anchoredDraggable$default(r14, r15, r16, r17, r18, r19, r20, r21)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r13 = r0.$content
            int r14 = r0.$$dirty
            r16 = r13
            long r12 = r0.$scrimColor
            androidx.compose.material.BottomDrawerState r15 = r0.$drawerState
            kotlinx.coroutines.CoroutineScope r9 = r0.$scope
            androidx.compose.ui.graphics.Shape r10 = r0.$drawerShape
            r37 = r4
            long r3 = r0.$drawerBackgroundColor
            r27 = r3
            long r3 = r0.$drawerContentColor
            float r1 = r0.$drawerElevation
            r38 = r6
            boolean r6 = r0.$gesturesEnabled
            r32 = r1
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$drawerContent
            r39 = 0
            r40 = 0
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getTopStart()
            r29 = r3
            r3 = 0
            int r4 = r39 >> 3
            r4 = r4 & 14
            int r19 = r39 >> 3
            r19 = r19 & 112(0x70, float:1.57E-43)
            r4 = r4 | r19
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r0, r3, r2, r4)
            int r19 = r39 << 3
            r19 = r19 & 112(0x70, float:1.57E-43)
            r41 = r19
            r42 = 0
            r43 = r0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r0 = 0
            int r44 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r0)
            androidx.compose.runtime.CompositionLocalMap r0 = r59.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r19 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r19 = r19.getConstructor()
            kotlin.jvm.functions.Function3 r20 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r11)
            r45 = r3
            int r3 = r41 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r46 = r11
            r11 = 6
            r3 = r3 | r11
            r47 = r20
            r48 = r19
            r49 = 0
            androidx.compose.runtime.Applier r11 = r59.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x0186
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0186:
            r59.startReusableNode()
            boolean r11 = r59.getInserting()
            if (r11 == 0) goto L_0x0195
            r11 = r48
            r2.createNode(r11)
            goto L_0x019a
        L_0x0195:
            r11 = r48
            r59.useNode()
        L_0x019a:
            r48 = r11
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2865constructorimpl(r59)
            r19 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
            r31 = r10
            kotlin.jvm.functions.Function2 r10 = r20.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r11, r4, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r11, r0, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetCompositeKeyHash()
            r20 = 0
            r21 = r11
            r22 = 0
            boolean r23 = r21.getInserting()
            if (r23 != 0) goto L_0x01de
            r50 = r0
            java.lang.Object r0 = r21.rememberedValue()
            r51 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r44)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 != 0) goto L_0x01db
            goto L_0x01e2
        L_0x01db:
            r4 = r21
            goto L_0x01f2
        L_0x01de:
            r50 = r0
            r51 = r4
        L_0x01e2:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r44)
            r4 = r21
            r4.updateRememberedValue(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r44)
            r11.apply(r0, r10)
        L_0x01f2:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r59)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r0)
            int r4 = r3 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r10 = r47
            r10.invoke(r0, r2, r4)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            int r0 = r3 >> 9
            r0 = r0 & 14
            r4 = r59
            r11 = 0
            r47 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            java.lang.String r2 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r2)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r2 = r39 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r19 = 6
            r2 = r2 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r52 = r4
            r53 = 0
            r54 = r0
            r0 = 1720994955(0x66944c8b, float:3.501611E23)
            r55 = r2
            java.lang.String r2 = "C689@25963L9,690@25985L391,701@26410L33,702@26483L113,705@26609L1970:Drawer.kt#jmzs0o"
            r56 = r3
            r3 = r52
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r2)
            int r0 = r14 >> 27
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2 = r16
            r2.invoke(r3, r0)
            androidx.compose.material.DrawerKt$BottomDrawer$2$1$1 r0 = new androidx.compose.material.DrawerKt$BottomDrawer$2$1$1
            r0.<init>(r6, r15, r9)
            r21 = r0
            kotlin.jvm.functions.Function0 r21 = (kotlin.jvm.functions.Function0) r21
            androidx.compose.material.BottomDrawerValue r0 = r15.getTargetValue()
            androidx.compose.material.BottomDrawerValue r2 = androidx.compose.material.BottomDrawerValue.Closed
            if (r0 == r2) goto L_0x0265
            r22 = 1
            goto L_0x0267
        L_0x0265:
            r22 = 0
        L_0x0267:
            int r0 = r14 >> 24
            r24 = r0 & 14
            r19 = r12
            r23 = r3
            androidx.compose.material.DrawerKt.m1283BottomDrawerScrim3JVO9M(r19, r21, r22, r23, r24)
            androidx.compose.material.Strings$Companion r0 = androidx.compose.material.Strings.Companion
            int r0 = r0.m1415getNavigationMenuUdPEhr4()
            r2 = 6
            java.lang.String r0 = androidx.compose.material.Strings_androidKt.m1418getString4foXLRw(r0, r3, r2)
            r2 = 72
            r6 = 0
            r12 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r3.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r12)
            boolean r12 = r3.changed((java.lang.Object) r15)
            boolean r13 = r3.changed((java.lang.Object) r9)
            r12 = r12 | r13
            r13 = r3
            r16 = 0
            r19 = r2
            java.lang.Object r2 = r13.rememberedValue()
            r20 = 0
            if (r12 != 0) goto L_0x02ae
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r22 = r6
            java.lang.Object r6 = r21.getEmpty()
            if (r2 != r6) goto L_0x02ac
            goto L_0x02b0
        L_0x02ac:
            r6 = r2
            goto L_0x02ba
        L_0x02ae:
            r22 = r6
        L_0x02b0:
            r6 = 0
            androidx.compose.material.AnchoredDraggableState$AnchorChangedCallback r6 = androidx.compose.material.DrawerKt.BottomDrawerAnchorChangeCallback(r15, r9)
            r13.updateRememberedValue(r6)
        L_0x02ba:
            r3.endReplaceableGroup()
            r2 = r6
            androidx.compose.material.AnchoredDraggableState$AnchorChangedCallback r2 = (androidx.compose.material.AnchoredDraggableState.AnchorChangedCallback) r2
            androidx.compose.material.DrawerKt$BottomDrawer$2$1$2 r6 = new androidx.compose.material.DrawerKt$BottomDrawer$2$1$2
            r6.<init>(r15, r2, r5, r7)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.layout.OnRemeasuredModifierKt.onSizeChanged(r8, r6)
            androidx.compose.material.DrawerKt$BottomDrawer$2$1$3 r12 = new androidx.compose.material.DrawerKt$BottomDrawer$2$1$3
            r12.<init>(r15)
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.OffsetKt.offset(r6, r12)
            androidx.compose.material.DrawerKt$BottomDrawer$2$1$4 r12 = new androidx.compose.material.DrawerKt$BottomDrawer$2$1$4
            r12.<init>(r0, r15, r9)
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r9 = 0
            r13 = 1
            r15 = 0
            androidx.compose.ui.Modifier r25 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r6, r15, r12, r13, r9)
            androidx.compose.material.DrawerKt$BottomDrawer$2$1$5 r6 = new androidx.compose.material.DrawerKt$BottomDrawer$2$1$5
            r6.<init>(r1, r14)
            r1 = 457750254(0x1b48b6ee, float:1.660272E-22)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r1, r13, r6)
            r33 = r1
            kotlin.jvm.functions.Function2 r33 = (kotlin.jvm.functions.Function2) r33
            int r1 = r14 >> 9
            r1 = r1 & 112(0x70, float:1.57E-43)
            r6 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r6
            int r6 = r14 >> 12
            r9 = r6 & 896(0x380, float:1.256E-42)
            r1 = r1 | r9
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r6
            r6 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r14
            r35 = r1 | r6
            r1 = 0
            r36 = 16
            r26 = r31
            r31 = r1
            r34 = r3
            androidx.compose.material.SurfaceKt.m1420SurfaceFjzlyU(r25, r26, r27, r29, r31, r32, r33, r34, r35, r36)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r59.endReplaceableGroup()
            r59.endNode()
            r59.endReplaceableGroup()
            r59.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x033b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x033b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt$BottomDrawer$2.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }
}

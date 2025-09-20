package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.AnchoredDraggableState;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "invoke", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
final class ModalBottomSheetKt$ModalBottomSheetLayout$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ AnchoredDraggableState.AnchorChangedCallback<ModalBottomSheetValue> $anchorChangeCallback;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ ModalBottomSheetState $sheetState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheetKt$ModalBottomSheetLayout$2(boolean z, ModalBottomSheetState modalBottomSheetState, Orientation orientation, Shape shape, long j, long j2, float f, int i, Function2<? super Composer, ? super Integer, Unit> function2, long j3, CoroutineScope coroutineScope, AnchoredDraggableState.AnchorChangedCallback<ModalBottomSheetValue> anchorChangedCallback, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$sheetGesturesEnabled = z;
        this.$sheetState = modalBottomSheetState;
        this.$orientation = orientation;
        this.$sheetShape = shape;
        this.$sheetBackgroundColor = j;
        this.$sheetContentColor = j2;
        this.$sheetElevation = f;
        this.$$dirty = i;
        this.$content = function2;
        this.$scrimColor = j3;
        this.$scope = coroutineScope;
        this.$anchorChangeCallback = anchorChangedCallback;
        this.$sheetContent = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((BoxWithConstraintsScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r43, androidx.compose.runtime.Composer r44, int r45) {
        /*
            r42 = this;
            r0 = r42
            r1 = r43
            r14 = r44
            r15 = r45
            java.lang.String r2 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "C588@24304L430,600@24743L4244:ModalBottomSheet.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            r2 = r45
            r3 = r15 & 14
            if (r3 != 0) goto L_0x0022
            boolean r3 = r14.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0020
            r3 = 4
            goto L_0x0021
        L_0x0020:
            r3 = 2
        L_0x0021:
            r2 = r2 | r3
        L_0x0022:
            r16 = r2
            r2 = r16 & 91
            r3 = 18
            if (r2 != r3) goto L_0x0036
            boolean r2 = r44.getSkipping()
            if (r2 != 0) goto L_0x0031
            goto L_0x0036
        L_0x0031:
            r44.skipToGroupEnd()
            goto L_0x0314
        L_0x0036:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0045
            r2 = -1
            java.lang.String r3 = "androidx.compose.material.ModalBottomSheetLayout.<anonymous> (ModalBottomSheet.kt:586)"
            r5 = -1731958854(0xffffffff98c467ba, float:-5.076955E-24)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r15, r2, r3)
        L_0x0045:
            long r2 = r43.m459getConstraintsmsEJaDk()
            int r2 = androidx.compose.ui.unit.Constraints.m5787getMaxHeightimpl(r2)
            float r13 = (float) r2
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = 0
            r5 = 1
            r6 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r2, r3, r5, r6)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r7 = r0.$content
            int r8 = r0.$$dirty
            long r9 = r0.$scrimColor
            androidx.compose.material.ModalBottomSheetState r11 = r0.$sheetState
            kotlinx.coroutines.CoroutineScope r12 = r0.$scope
            r17 = 6
            r23 = r17
            r24 = 0
            r4 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r14.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r4)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getTopStart()
            r3 = 0
            int r17 = r23 >> 3
            r17 = r17 & 14
            int r18 = r23 >> 3
            r18 = r18 & 112(0x70, float:1.57E-43)
            r5 = r17 | r18
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r4, r3, r14, r5)
            int r17 = r23 << 3
            r17 = r17 & 112(0x70, float:1.57E-43)
            r25 = r17
            r26 = 0
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r14.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r6)
            r6 = 0
            int r27 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r14, r6)
            androidx.compose.runtime.CompositionLocalMap r6 = r44.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r17 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r18 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r2)
            r28 = r2
            int r2 = r25 << 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | 6
            r29 = r18
            r30 = r17
            r31 = 0
            r32 = r3
            androidx.compose.runtime.Applier r3 = r44.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x00cb
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00cb:
            r44.startReusableNode()
            boolean r3 = r44.getInserting()
            if (r3 == 0) goto L_0x00da
            r3 = r30
            r14.createNode(r3)
            goto L_0x00df
        L_0x00da:
            r3 = r30
            r44.useNode()
        L_0x00df:
            r30 = r3
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m2865constructorimpl(r44)
            r17 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            r33 = r4
            kotlin.jvm.functions.Function2 r4 = r18.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r3, r5, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r3, r6, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            r18 = 0
            r19 = r3
            r20 = 0
            boolean r21 = r19.getInserting()
            if (r21 != 0) goto L_0x0123
            r34 = r5
            java.lang.Object r5 = r19.rememberedValue()
            r35 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r27)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 != 0) goto L_0x0120
            goto L_0x0127
        L_0x0120:
            r6 = r19
            goto L_0x0137
        L_0x0123:
            r34 = r5
            r35 = r6
        L_0x0127:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r27)
            r6 = r19
            r6.updateRememberedValue(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r27)
            r3.apply(r5, r4)
        L_0x0137:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r44)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r3)
            int r4 = r2 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = r29
            r5.invoke(r3, r14, r4)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r3)
            int r3 = r2 >> 9
            r3 = r3 & 14
            r4 = r44
            r6 = 0
            r29 = r2
            r2 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r36 = r3
            java.lang.String r3 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r2, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r23 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r37 = r4
            r38 = 0
            r39 = r2
            r2 = -1295116475(0xffffffffb2ce1745, float:-2.3992138E-8)
            r40 = r3
            java.lang.String r3 = "C589@24346L9,590@24368L356:ModalBottomSheet.kt#jmzs0o"
            r41 = r5
            r5 = r37
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r3)
            int r2 = r8 >> 27
            r2 = r2 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r7.invoke(r5, r2)
            androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$1$1 r2 = new androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$1$1
            r2.<init>(r11, r12)
            r19 = r2
            kotlin.jvm.functions.Function0 r19 = (kotlin.jvm.functions.Function0) r19
            androidx.compose.material.AnchoredDraggableState r2 = r11.getAnchoredDraggableState$material_release()
            java.lang.Object r2 = r2.getTargetValue()
            androidx.compose.material.ModalBottomSheetValue r3 = androidx.compose.material.ModalBottomSheetValue.Hidden
            if (r2 == r3) goto L_0x01ac
            r20 = 1
            goto L_0x01ae
        L_0x01ac:
            r20 = 0
        L_0x01ae:
            int r2 = r8 >> 24
            r22 = r2 & 14
            r17 = r9
            r21 = r5
            androidx.compose.material.ModalBottomSheetKt.m1343Scrim3JVO9M(r17, r19, r20, r21, r22)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r44.endReplaceableGroup()
            r44.endNode()
            r44.endReplaceableGroup()
            r44.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopCenter()
            androidx.compose.ui.Modifier r2 = r1.align(r2, r3)
            float r3 = androidx.compose.material.ModalBottomSheetKt.MaxModalBottomSheetWidth
            r4 = 0
            r5 = 0
            r6 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m619widthInVpY3zN4$default(r2, r4, r3, r6, r5)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r2, r4, r6, r5)
            r3 = 1241536180(0x4a0056b4, float:2102701.0)
            r14.startReplaceableGroup(r3)
            java.lang.String r3 = "608@25105L354"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r3)
            boolean r3 = r0.$sheetGesturesEnabled
            if (r3 == 0) goto L_0x025c
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.material.ModalBottomSheetState r4 = r0.$sheetState
            androidx.compose.material.AnchoredDraggableState r4 = r4.getAnchoredDraggableState$material_release()
            androidx.compose.foundation.gestures.Orientation r5 = r0.$orientation
            androidx.compose.material.ModalBottomSheetState r6 = r0.$sheetState
            androidx.compose.foundation.gestures.Orientation r7 = r0.$orientation
            r8 = 48
            r9 = 0
            r10 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r14.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r10)
            boolean r10 = r14.changed((java.lang.Object) r4)
            boolean r11 = r14.changed((java.lang.Object) r5)
            r10 = r10 | r11
            r11 = r44
            r12 = 0
            java.lang.Object r1 = r11.rememberedValue()
            r17 = 0
            if (r10 != 0) goto L_0x023d
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r19 = r4
            java.lang.Object r4 = r18.getEmpty()
            if (r1 != r4) goto L_0x023b
            goto L_0x023f
        L_0x023b:
            r4 = r1
            goto L_0x024e
        L_0x023d:
            r19 = r4
        L_0x023f:
            r4 = 0
            androidx.compose.material.AnchoredDraggableState r6 = r6.getAnchoredDraggableState$material_release()
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r4 = androidx.compose.material.ModalBottomSheetKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(r6, r7)
            r11.updateRememberedValue(r4)
        L_0x024e:
            r44.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r4 = (androidx.compose.ui.input.nestedscroll.NestedScrollConnection) r4
            r1 = 2
            r5 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r3, r4, r5, r1, r5)
            goto L_0x0260
        L_0x025c:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
        L_0x0260:
            r44.endReplaceableGroup()
            androidx.compose.ui.Modifier r1 = r2.then(r1)
            androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$3 r2 = new androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$3
            androidx.compose.material.ModalBottomSheetState r3 = r0.$sheetState
            r2.<init>(r3)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r1, r2)
            androidx.compose.material.ModalBottomSheetState r1 = r0.$sheetState
            androidx.compose.material.AnchoredDraggableState r4 = r1.getAnchoredDraggableState$material_release()
            androidx.compose.foundation.gestures.Orientation r5 = r0.$orientation
            boolean r1 = r0.$sheetGesturesEnabled
            if (r1 == 0) goto L_0x0290
            androidx.compose.material.ModalBottomSheetState r1 = r0.$sheetState
            androidx.compose.material.AnchoredDraggableState r1 = r1.getAnchoredDraggableState$material_release()
            java.lang.Object r1 = r1.getCurrentValue()
            androidx.compose.material.ModalBottomSheetValue r2 = androidx.compose.material.ModalBottomSheetValue.Hidden
            if (r1 == r2) goto L_0x0290
            r6 = 1
            goto L_0x0291
        L_0x0290:
            r6 = 0
        L_0x0291:
            r9 = 24
            r10 = 0
            r7 = 0
            r8 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.material.AnchoredDraggableKt.anchoredDraggable$default(r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4 r2 = new androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4
            androidx.compose.material.ModalBottomSheetState r3 = r0.$sheetState
            androidx.compose.material.AnchoredDraggableState$AnchorChangedCallback<androidx.compose.material.ModalBottomSheetValue> r4 = r0.$anchorChangeCallback
            r2.<init>(r3, r4, r13)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.OnRemeasuredModifierKt.onSizeChanged(r1, r2)
            boolean r2 = r0.$sheetGesturesEnabled
            if (r2 == 0) goto L_0x02c4
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$5 r3 = new androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$5
            androidx.compose.material.ModalBottomSheetState r4 = r0.$sheetState
            kotlinx.coroutines.CoroutineScope r5 = r0.$scope
            r3.<init>(r4, r5)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = 0
            r5 = 0
            r6 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r4, r3, r6, r5)
            goto L_0x02c8
        L_0x02c4:
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
        L_0x02c8:
            androidx.compose.ui.Modifier r2 = r1.then(r2)
            androidx.compose.ui.graphics.Shape r3 = r0.$sheetShape
            long r4 = r0.$sheetBackgroundColor
            long r6 = r0.$sheetContentColor
            float r9 = r0.$sheetElevation
            androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$6 r1 = new androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$6
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r8 = r0.$sheetContent
            int r10 = r0.$$dirty
            r1.<init>(r8, r10)
            r8 = 1552994302(0x5c90cffe, float:3.26088692E17)
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r8, r10, r1)
            r10 = r1
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            int r1 = r0.$$dirty
            int r8 = r1 >> 9
            r8 = r8 & 112(0x70, float:1.57E-43)
            r11 = 1572864(0x180000, float:2.204052E-39)
            r8 = r8 | r11
            int r11 = r1 >> 12
            r11 = r11 & 896(0x380, float:1.256E-42)
            r8 = r8 | r11
            int r11 = r1 >> 12
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r11
            r12 = r8 | r1
            r8 = 0
            r1 = 16
            r11 = r44
            r17 = r13
            r13 = r1
            androidx.compose.material.SurfaceKt.m1420SurfaceFjzlyU(r2, r3, r4, r6, r8, r9, r10, r11, r12, r13)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0314
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0314:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }
}

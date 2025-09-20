package androidx.compose.material;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "invoke", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismiss.kt */
final class SwipeToDismissKt$SwipeToDismiss$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $background;
    final /* synthetic */ Set<DismissDirection> $directions;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $dismissContent;
    final /* synthetic */ Function1<DismissDirection, ThresholdConfig> $dismissThresholds;
    final /* synthetic */ DismissState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissKt$SwipeToDismiss$2(Set<? extends DismissDirection> set, Function1<? super DismissDirection, ? extends ThresholdConfig> function1, int i, DismissState dismissState, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32) {
        super(3);
        this.$directions = set;
        this.$dismissThresholds = function1;
        this.$$dirty = i;
        this.$state = dismissState;
        this.$background = function3;
        this.$dismissContent = function32;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((BoxWithConstraintsScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x030f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0354  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x03ed  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x03fa  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0473  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x047f  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x04b2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x04c8  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0545  */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r62, androidx.compose.runtime.Composer r63, int r64) {
        /*
            r61 = this;
            r0 = r61
            r1 = r62
            r2 = r63
            r3 = r64
            java.lang.String r4 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "C183@6697L7,189@6938L106,196@7269L718:SwipeToDismiss.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r4)
            r4 = r64
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
            boolean r5 = r63.getSkipping()
            if (r5 != 0) goto L_0x002f
            goto L_0x0036
        L_0x002f:
            r63.skipToGroupEnd()
            r20 = r4
            goto L_0x0548
        L_0x0036:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0045
            r5 = -1
            java.lang.String r6 = "androidx.compose.material.SwipeToDismiss.<anonymous> (SwipeToDismiss.kt:181)"
            r7 = 338007641(0x14259659, float:8.360022E-27)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r5, r6)
        L_0x0045:
            long r5 = r62.m2169getConstraintsmsEJaDk()
            int r5 = androidx.compose.ui.unit.Constraints.m7498getMaxWidthimpl(r5)
            float r5 = (float) r5
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r7 = 0
            r8 = 0
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r9, r10)
            java.lang.Object r9 = r2.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r63)
            androidx.compose.ui.unit.LayoutDirection r6 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r7 = 1
            r8 = 0
            if (r9 != r6) goto L_0x006d
            r15 = r7
            goto L_0x006e
        L_0x006d:
            r15 = r8
        L_0x006e:
            r6 = 0
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            androidx.compose.material.DismissValue r9 = androidx.compose.material.DismissValue.Default
            kotlin.Pair r6 = kotlin.TuplesKt.to(r6, r9)
            kotlin.Pair[] r9 = new kotlin.Pair[r7]
            r9[r8] = r6
            java.util.Map r6 = kotlin.collections.MapsKt.mutableMapOf(r9)
            java.util.Set<androidx.compose.material.DismissDirection> r9 = r0.$directions
            androidx.compose.material.DismissDirection r10 = androidx.compose.material.DismissDirection.StartToEnd
            boolean r9 = r9.contains(r10)
            if (r9 == 0) goto L_0x00a0
            java.lang.Float r9 = java.lang.Float.valueOf(r5)
            androidx.compose.material.DismissValue r10 = androidx.compose.material.DismissValue.DismissedToEnd
            kotlin.Pair r9 = kotlin.TuplesKt.to(r9, r10)
            java.lang.Object r10 = r9.getFirst()
            java.lang.Object r9 = r9.getSecond()
            r6.put(r10, r9)
        L_0x00a0:
            java.util.Set<androidx.compose.material.DismissDirection> r9 = r0.$directions
            androidx.compose.material.DismissDirection r10 = androidx.compose.material.DismissDirection.EndToStart
            boolean r9 = r9.contains(r10)
            if (r9 == 0) goto L_0x00c0
            float r9 = -r5
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            androidx.compose.material.DismissValue r10 = androidx.compose.material.DismissValue.DismissedToStart
            kotlin.Pair r9 = kotlin.TuplesKt.to(r9, r10)
            java.lang.Object r10 = r9.getFirst()
            java.lang.Object r9 = r9.getSecond()
            r6.put(r10, r9)
        L_0x00c0:
            kotlin.jvm.functions.Function1<androidx.compose.material.DismissDirection, androidx.compose.material.ThresholdConfig> r9 = r0.$dismissThresholds
            kotlin.jvm.functions.Function1<androidx.compose.material.DismissDirection, androidx.compose.material.ThresholdConfig> r10 = r0.$dismissThresholds
            int r11 = r0.$$dirty
            int r11 = r11 >> 9
            r11 = r11 & 14
            r12 = 0
            r14 = 1157296644(0x44faf204, float:2007.563)
            r2.startReplaceableGroup(r14)
            java.lang.String r13 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r13)
            boolean r16 = r2.changed((java.lang.Object) r9)
            r17 = r63
            r18 = 0
            java.lang.Object r7 = r17.rememberedValue()
            r20 = 0
            if (r16 != 0) goto L_0x00f3
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r21.getEmpty()
            if (r7 != r14) goto L_0x00ef
            goto L_0x00f3
        L_0x00ef:
            r8 = r7
            r10 = r17
            goto L_0x0102
        L_0x00f3:
            r14 = 0
            androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1 r8 = new androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1
            r8.<init>(r10)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r10 = r17
            r10.updateRememberedValue(r8)
        L_0x0102:
            r63.endReplaceableGroup()
            r7 = r8
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.util.Set<androidx.compose.material.DismissDirection> r8 = r0.$directions
            androidx.compose.material.DismissDirection r9 = androidx.compose.material.DismissDirection.EndToStart
            boolean r8 = r8.contains(r9)
            r9 = 1092616192(0x41200000, float:10.0)
            r10 = 1101004800(0x41a00000, float:20.0)
            if (r8 == 0) goto L_0x011a
            r8 = r9
            goto L_0x011b
        L_0x011a:
            r8 = r10
        L_0x011b:
            java.util.Set<androidx.compose.material.DismissDirection> r11 = r0.$directions
            androidx.compose.material.DismissDirection r12 = androidx.compose.material.DismissDirection.StartToEnd
            boolean r11 = r11.contains(r12)
            if (r11 == 0) goto L_0x0127
            goto L_0x0128
        L_0x0127:
            r9 = r10
        L_0x0128:
            androidx.compose.ui.Modifier$Companion r10 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r14 = androidx.compose.foundation.gestures.Orientation.Horizontal
            androidx.compose.material.DismissState r11 = r0.$state
            java.lang.Object r11 = r11.getCurrentValue()
            androidx.compose.material.DismissValue r12 = androidx.compose.material.DismissValue.Default
            if (r11 != r12) goto L_0x013a
            r19 = 1
            goto L_0x013c
        L_0x013a:
            r19 = 0
        L_0x013c:
            androidx.compose.material.ResistanceConfig r12 = new androidx.compose.material.ResistanceConfig
            r12.<init>(r5, r8, r9)
            androidx.compose.ui.Modifier r10 = (androidx.compose.ui.Modifier) r10
            androidx.compose.material.DismissState r11 = r0.$state
            androidx.compose.material.SwipeableState r11 = (androidx.compose.material.SwipeableState) r11
            r20 = 288(0x120, float:4.04E-43)
            r21 = 0
            r16 = 0
            r24 = 0
            r18 = r12
            r12 = r6
            r1 = r13
            r13 = r14
            r3 = 1157296644(0x44faf204, float:2007.563)
            r14 = r19
            r17 = r7
            r19 = r24
            androidx.compose.ui.Modifier r10 = androidx.compose.material.SwipeableKt.m3141swipeablepPrIpRY$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r11 = r0.$background
            int r12 = r0.$$dirty
            androidx.compose.material.DismissState r13 = r0.$state
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r14 = r0.$dismissContent
            r16 = 0
            r17 = 0
            r3 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopStart()
            r0 = 0
            int r18 = r16 >> 3
            r18 = r18 & 14
            int r19 = r16 >> 3
            r19 = r19 & 112(0x70, float:1.57E-43)
            r20 = r4
            r4 = r18 | r19
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r0, r2, r4)
            int r18 = r16 << 3
            r18 = r18 & 112(0x70, float:1.57E-43)
            r19 = 0
            r21 = r0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r25 = r3
            r3 = 0
            int r26 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r3)
            androidx.compose.runtime.CompositionLocalMap r3 = r63.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r27 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r27 = r27.getConstructor()
            kotlin.jvm.functions.Function3 r28 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r10)
            r29 = r5
            int r5 = r18 << 9
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | 6
            r30 = r27
            r27 = r28
            r28 = 0
            r31 = r6
            androidx.compose.runtime.Applier r6 = r63.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x01dd
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01dd:
            r63.startReusableNode()
            boolean r6 = r63.getInserting()
            if (r6 == 0) goto L_0x01ec
            r6 = r30
            r2.createNode(r6)
            goto L_0x01f1
        L_0x01ec:
            r6 = r30
            r63.useNode()
        L_0x01f1:
            r30 = r6
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m4575constructorimpl(r63)
            r32 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r33 = androidx.compose.ui.node.ComposeUiNode.Companion
            r34 = r7
            kotlin.jvm.functions.Function2 r7 = r33.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r6, r4, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r6, r3, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetCompositeKeyHash()
            r33 = 0
            r35 = r6
            r36 = 0
            boolean r37 = r35.getInserting()
            if (r37 != 0) goto L_0x0235
            r37 = r3
            java.lang.Object r3 = r35.rememberedValue()
            r38 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r26)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x0232
            goto L_0x0239
        L_0x0232:
            r4 = r35
            goto L_0x0249
        L_0x0235:
            r37 = r3
            r38 = r4
        L_0x0239:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r26)
            r4 = r35
            r4.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r26)
            r6.apply(r3, r7)
        L_0x0249:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r63)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r3)
            int r4 = r5 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6 = r27
            r6.invoke(r3, r2, r4)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r3)
            int r4 = r5 >> 9
            r4 = r4 & 14
            r7 = r63
            r27 = 0
            r3 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            java.lang.String r2 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r3, r2)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r16 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r33 = r7
            r35 = 0
            r36 = r3
            r3 = 565741180(0x21b8867c, float:1.2503923E-18)
            r39 = r4
            java.lang.String r4 = "C211@7733L98,217@7922L49,215@7840L141:SwipeToDismiss.kt#jmzs0o"
            r40 = r5
            r5 = r33
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r3, r4)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Modifier r3 = r2.matchParentSize(r3)
            int r4 = r12 >> 3
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r33 = 0
            r41 = r2
            r2 = 693286680(0x2952b718, float:4.6788176E-14)
            r5.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(Row)P(2,1,3)76@3779L58,77@3842L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            androidx.compose.foundation.layout.Arrangement r43 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            r44 = r6
            androidx.compose.foundation.layout.Arrangement$Horizontal r6 = r43.getStart()
            androidx.compose.ui.Alignment$Companion r43 = androidx.compose.ui.Alignment.Companion
            r45 = r8
            androidx.compose.ui.Alignment$Vertical r8 = r43.getTop()
            int r43 = r4 >> 3
            r43 = r43 & 14
            int r46 = r4 >> 3
            r46 = r46 & 112(0x70, float:1.57E-43)
            r47 = r9
            r9 = r43 | r46
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r6, r8, r5, r9)
            int r43 = r4 << 3
            r43 = r43 & 112(0x70, float:1.57E-43)
            r46 = 0
            r48 = r6
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r0)
            r6 = 0
            int r49 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r5, r6)
            androidx.compose.runtime.CompositionLocalMap r6 = r5.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r50 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r50 = r50.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            r51 = r8
            int r8 = r43 << 9
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | 6
            r52 = r50
            r50 = 0
            r53 = r10
            androidx.compose.runtime.Applier r10 = r5.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0312
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0312:
            r5.startReusableNode()
            boolean r10 = r5.getInserting()
            if (r10 == 0) goto L_0x0321
            r10 = r52
            r5.createNode(r10)
            goto L_0x0326
        L_0x0321:
            r10 = r52
            r5.useNode()
        L_0x0326:
            r52 = r10
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m4575constructorimpl(r5)
            r54 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r55 = androidx.compose.ui.node.ComposeUiNode.Companion
            r56 = r15
            kotlin.jvm.functions.Function2 r15 = r55.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r9, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r6, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetCompositeKeyHash()
            r55 = 0
            r57 = r10
            r58 = 0
            boolean r59 = r57.getInserting()
            if (r59 != 0) goto L_0x036a
            r59 = r6
            java.lang.Object r6 = r57.rememberedValue()
            r60 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r49)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r9)
            if (r6 != 0) goto L_0x0367
            goto L_0x036e
        L_0x0367:
            r9 = r57
            goto L_0x037e
        L_0x036a:
            r59 = r6
            r60 = r9
        L_0x036e:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r49)
            r9 = r57
            r9.updateRememberedValue(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r49)
            r10.apply(r6, r15)
        L_0x037e:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r6)
            int r9 = r8 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r3.invoke(r6, r5, r9)
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r6)
            int r6 = r8 >> 9
            r6 = r6 & 14
            r9 = r5
            r10 = 0
            r15 = -326682417(0xffffffffec8738cf, float:-1.307786E27)
            r54 = r3
            java.lang.String r3 = "C78@3887L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r15, r3)
            androidx.compose.foundation.layout.RowScopeInstance r15 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r57 = r4 >> 6
            r57 = r57 & 112(0x70, float:1.57E-43)
            r57 = r57 | 6
            r58 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r57)
            r11.invoke(r15, r9, r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            r5.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r6 = r12 & 14
            r8 = 0
            r9 = 1157296644(0x44faf204, float:2007.563)
            r5.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            boolean r1 = r5.changed((java.lang.Object) r13)
            r9 = r5
            r10 = 0
            java.lang.Object r11 = r9.rememberedValue()
            r15 = 0
            if (r1 != 0) goto L_0x03fa
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r33 = r1
            java.lang.Object r1 = r22.getEmpty()
            if (r11 != r1) goto L_0x03f8
            goto L_0x03fc
        L_0x03f8:
            r1 = r11
            goto L_0x040b
        L_0x03fa:
            r33 = r1
        L_0x03fc:
            r1 = 0
            r22 = r1
            androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1 r1 = new androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1
            r1.<init>(r13)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r9.updateRememberedValue(r1)
        L_0x040b:
            r5.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.OffsetKt.offset(r4, r1)
            int r4 = r12 >> 6
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r6 = 0
            r8 = 693286680(0x2952b718, float:4.6788176E-14)
            r5.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            androidx.compose.foundation.layout.Arrangement r2 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r2 = r2.getStart()
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r8 = r8.getTop()
            int r9 = r4 >> 3
            r9 = r9 & 14
            int r10 = r4 >> 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r9 = r9 | r10
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r2, r8, r5, r9)
            int r10 = r4 << 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r11 = 0
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r0)
            r0 = 0
            int r0 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r5, r0)
            androidx.compose.runtime.CompositionLocalMap r12 = r5.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r1)
            int r15 = r10 << 9
            r15 = r15 & 7168(0x1c00, float:1.0045E-41)
            r15 = r15 | 6
            r22 = 0
            r23 = r2
            androidx.compose.runtime.Applier r2 = r5.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x0476
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0476:
            r5.startReusableNode()
            boolean r2 = r5.getInserting()
            if (r2 == 0) goto L_0x0483
            r5.createNode(r13)
            goto L_0x0486
        L_0x0483:
            r5.useNode()
        L_0x0486:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m4575constructorimpl(r5)
            r24 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r33 = androidx.compose.ui.node.ComposeUiNode.Companion
            r42 = r6
            kotlin.jvm.functions.Function2 r6 = r33.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r9, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r12, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetCompositeKeyHash()
            r33 = 0
            r43 = r2
            r46 = 0
            boolean r48 = r43.getInserting()
            if (r48 != 0) goto L_0x04c8
            r48 = r8
            java.lang.Object r8 = r43.rememberedValue()
            r49 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 != 0) goto L_0x04c5
            goto L_0x04cc
        L_0x04c5:
            r9 = r43
            goto L_0x04dc
        L_0x04c8:
            r48 = r8
            r49 = r9
        L_0x04cc:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r9 = r43
            r9.updateRememberedValue(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r2.apply(r8, r6)
        L_0x04dc:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r2)
            int r6 = r15 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r1.invoke(r2, r5, r6)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r2)
            int r2 = r15 >> 9
            r2 = r2 & 14
            r6 = r5
            r8 = 0
            r9 = -326682417(0xffffffffec8738cf, float:-1.307786E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r9, r3)
            androidx.compose.foundation.layout.RowScopeInstance r3 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r9 = r4 >> 6
            r9 = r9 & 112(0x70, float:1.57E-43)
            r9 = r9 | 6
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r14.invoke(r3, r6, r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            r5.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r63.endReplaceableGroup()
            r63.endNode()
            r63.endReplaceableGroup()
            r63.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0548
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0548:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }
}

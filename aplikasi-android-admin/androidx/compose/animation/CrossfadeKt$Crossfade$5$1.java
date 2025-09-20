package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "T", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Crossfade.kt */
final class CrossfadeKt$Crossfade$5$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
    final /* synthetic */ Function3<T, Composer, Integer, Unit> $content;
    final /* synthetic */ T $stateForContent;
    final /* synthetic */ Transition<T> $this_Crossfade;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CrossfadeKt$Crossfade$5$1(Transition<T> transition, int i, FiniteAnimationSpec<Float> finiteAnimationSpec, T t, Function3<? super T, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$this_Crossfade = transition;
        this.$$dirty = i;
        this.$animationSpec = finiteAnimationSpec;
        this.$stateForContent = t;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final float invoke$lambda$1(State<Float> $alpha$delegate) {
        return ((Number) $alpha$delegate.getValue()).floatValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r30, int r31) {
        /*
            r29 = this;
            r0 = r29
            r9 = r30
            r10 = r31
            java.lang.String r1 = "C128@5454L128,131@5626L22,131@5599L115:Crossfade.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r10 & 11
            r2 = 2
            if (r1 != r2) goto L_0x001c
            boolean r1 = r30.getSkipping()
            if (r1 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r30.skipToGroupEnd()
            goto L_0x02b9
        L_0x001c:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r3 = -1
            if (r1 == 0) goto L_0x002b
            r1 = -1426421288(0xffffffffaafa89d8, float:-4.450457E-13)
            java.lang.String r2 = "androidx.compose.animation.Crossfade.<anonymous>.<anonymous> (Crossfade.kt:127)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r10, r3, r2)
        L_0x002b:
            androidx.compose.animation.core.Transition<T> r11 = r0.$this_Crossfade
            androidx.compose.animation.CrossfadeKt$Crossfade$5$1$alpha$2 r1 = new androidx.compose.animation.CrossfadeKt$Crossfade$5$1$alpha$2
            androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r2 = r0.$animationSpec
            r1.<init>(r2)
            r12 = r1
            kotlin.jvm.functions.Function3 r12 = (kotlin.jvm.functions.Function3) r12
            T r4 = r0.$stateForContent
            int r1 = r0.$$dirty
            r1 = r1 & 14
            r13 = r1
            r14 = 0
            r1 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r9.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(animateFloat)P(2)939@37552L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            java.lang.String r15 = "FloatAnimation"
            kotlin.jvm.internal.FloatCompanionObject r1 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r16 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r1)
            r1 = r13 & 14
            int r2 = r13 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r13 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r13 << 3
            r5 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r5
            r17 = r1 | r2
            r1 = r11
            r18 = 0
            r2 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r9.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(animateValue)P(3,2)857@34142L32,858@34197L31,859@34253L23,861@34289L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            java.lang.Object r2 = r1.getCurrentState()
            int r6 = r17 >> 9
            r6 = r6 & 112(0x70, float:1.57E-43)
            r7 = r30
            r8 = 0
            r5 = -438678252(0xffffffffe5da4d14, float:-1.2886222E23)
            r7.startReplaceableGroup(r5)
            java.lang.String r3 = "C:Crossfade.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r3)
            boolean r21 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r5 = "androidx.compose.animation.Crossfade.<anonymous>.<anonymous>.<anonymous> (Crossfade.kt:130)"
            if (r21 == 0) goto L_0x009c
            r21 = r8
            r8 = -1
            r10 = -438678252(0xffffffffe5da4d14, float:-1.2886222E23)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r6, r8, r5)
            goto L_0x009e
        L_0x009c:
            r21 = r8
        L_0x009e:
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            r23 = 0
            if (r8 == 0) goto L_0x00a9
            r8 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00ab
        L_0x00a9:
            r8 = r23
        L_0x00ab:
            boolean r24 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r24 == 0) goto L_0x00b4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00b4:
            r7.endReplaceableGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r8)
            java.lang.Object r6 = r1.getTargetState()
            int r7 = r17 >> 9
            r7 = r7 & 112(0x70, float:1.57E-43)
            r8 = r30
            r21 = 0
            r10 = -438678252(0xffffffffe5da4d14, float:-1.2886222E23)
            r8.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x00db
            r3 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r7, r3, r5)
        L_0x00db:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x00e4
            r10 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00e6
        L_0x00e4:
            r10 = r23
        L_0x00e6:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x00ef
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00ef:
            r8.endReplaceableGroup()
            java.lang.Float r3 = java.lang.Float.valueOf(r10)
            androidx.compose.animation.core.Transition$Segment r4 = r1.getSegment()
            int r5 = r17 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r4 = r12.invoke(r4, r9, r5)
            r10 = r4
            androidx.compose.animation.core.FiniteAnimationSpec r10 = (androidx.compose.animation.core.FiniteAnimationSpec) r10
            r4 = r17 & 14
            int r5 = r17 << 9
            r6 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r6
            r4 = r4 | r5
            int r5 = r17 << 6
            r6 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r6
            r8 = r4 | r5
            r4 = r10
            r5 = r16
            r6 = r15
            r7 = r30
            androidx.compose.runtime.State r4 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r1, r2, r3, r4, r5, r6, r7, r8)
            r30.endReplaceableGroup()
            r30.endReplaceableGroup()
            r1 = r4
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = 0
            r4 = 0
            r5 = 1157296644(0x44faf204, float:2007.563)
            r9.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r5)
            boolean r5 = r9.changed((java.lang.Object) r1)
            r6 = r30
            r7 = 0
            java.lang.Object r8 = r6.rememberedValue()
            r10 = 0
            if (r5 != 0) goto L_0x0155
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r8 != r11) goto L_0x0153
            goto L_0x0155
        L_0x0153:
            r11 = r8
            goto L_0x0162
        L_0x0155:
            r11 = 0
            androidx.compose.animation.CrossfadeKt$Crossfade$5$1$1$1 r12 = new androidx.compose.animation.CrossfadeKt$Crossfade$5$1$1$1
            r12.<init>(r1)
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r11 = r12
            r6.updateRememberedValue(r11)
        L_0x0162:
            r30.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.graphicsLayer(r2, r11)
            kotlin.jvm.functions.Function3<T, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$content
            T r4 = r0.$stateForContent
            int r5 = r0.$$dirty
            r6 = 0
            r7 = 0
            r8 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r9.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r8)
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r8 = r8.getTopStart()
            r10 = 0
            int r11 = r6 >> 3
            r11 = r11 & 14
            int r12 = r6 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r8, r10, r9, r11)
            int r12 = r6 << 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r13 = 0
            r14 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r14)
            r14 = 0
            int r14 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r14)
            androidx.compose.runtime.CompositionLocalMap r15 = r30.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r16 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r17 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r2)
            int r0 = r12 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r18 = r16
            r16 = r17
            r17 = 0
            r19 = r1
            androidx.compose.runtime.Applier r1 = r30.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x01d1
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01d1:
            r30.startReusableNode()
            boolean r1 = r30.getInserting()
            if (r1 == 0) goto L_0x01e0
            r1 = r18
            r9.createNode(r1)
            goto L_0x01e5
        L_0x01e0:
            r1 = r18
            r30.useNode()
        L_0x01e5:
            r18 = r1
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m4575constructorimpl(r30)
            r20 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r21 = androidx.compose.ui.node.ComposeUiNode.Companion
            r22 = r2
            kotlin.jvm.functions.Function2 r2 = r21.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r11, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r15, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            r21 = 0
            r23 = r1
            r24 = 0
            boolean r25 = r23.getInserting()
            if (r25 != 0) goto L_0x0229
            r25 = r7
            java.lang.Object r7 = r23.rememberedValue()
            r26 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r14)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 != 0) goto L_0x0226
            goto L_0x022d
        L_0x0226:
            r8 = r23
            goto L_0x023d
        L_0x0229:
            r25 = r7
            r26 = r8
        L_0x022d:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r14)
            r8 = r23
            r8.updateRememberedValue(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r14)
            r1.apply(r7, r2)
        L_0x023d:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r30)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r1)
            int r2 = r0 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r7 = r16
            r7.invoke(r1, r9, r2)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r1)
            int r1 = r0 >> 9
            r1 = r1 & 14
            r2 = r30
            r8 = 0
            r16 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r20 = r1
            java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r6 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r21 = r2
            r23 = 0
            r24 = r0
            r0 = 2090121434(0x7c94b8da, float:6.1776734E36)
            r27 = r1
            java.lang.String r1 = "C132@5672L24:Crossfade.kt#xbi5r1"
            r28 = r6
            r6 = r21
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r1)
            int r0 = r5 >> 9
            r0 = r0 & 112(0x70, float:1.57E-43)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3.invoke(r4, r6, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r30.endReplaceableGroup()
            r30.endNode()
            r30.endReplaceableGroup()
            r30.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02b9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.CrossfadeKt$Crossfade$5$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

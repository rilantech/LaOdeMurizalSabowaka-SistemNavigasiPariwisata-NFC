package androidx.compose.material;

import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "children", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "invoke", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnackbarHost.kt */
final class SnackbarHostKt$FadeInFadeOutWithScale$1$1 extends Lambda implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ SnackbarData $current;
    final /* synthetic */ SnackbarData $key;
    final /* synthetic */ List<SnackbarData> $keys;
    final /* synthetic */ FadeInFadeOutState<SnackbarData> $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarHostKt$FadeInFadeOutWithScale$1$1(SnackbarData snackbarData, SnackbarData snackbarData2, List<SnackbarData> list, FadeInFadeOutState<SnackbarData> fadeInFadeOutState) {
        super(3);
        this.$key = snackbarData;
        this.$current = snackbarData2;
        this.$keys = list;
        this.$state = fadeInFadeOutState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, int r42) {
        /*
            r39 = this;
            r0 = r39
            r1 = r40
            r8 = r41
            java.lang.String r2 = "children"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "C275@9962L618,290@10609L292,298@10918L504:SnackbarHost.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            r2 = r42
            r3 = r42 & 14
            if (r3 != 0) goto L_0x0020
            boolean r3 = r8.changedInstance(r1)
            if (r3 == 0) goto L_0x001e
            r3 = 4
            goto L_0x001f
        L_0x001e:
            r3 = 2
        L_0x001f:
            r2 = r2 | r3
        L_0x0020:
            r9 = r2
            r2 = r9 & 91
            r3 = 18
            if (r2 != r3) goto L_0x0033
            boolean r2 = r41.getSkipping()
            if (r2 != 0) goto L_0x002e
            goto L_0x0033
        L_0x002e:
            r41.skipToGroupEnd()
            goto L_0x0241
        L_0x0033:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0042
            r2 = -1
            java.lang.String r3 = "androidx.compose.material.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:270)"
            r4 = -94104314(0xfffffffffa641506, float:-2.9606752E35)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r9, r2, r3)
        L_0x0042:
            androidx.compose.material.SnackbarData r2 = r0.$key
            androidx.compose.material.SnackbarData r3 = r0.$current
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r10 == 0) goto L_0x004f
            r2 = 150(0x96, float:2.1E-43)
            goto L_0x0051
        L_0x004f:
            r2 = 75
        L_0x0051:
            r11 = r2
            r12 = 75
            r13 = 1
            r14 = 0
            if (r10 == 0) goto L_0x0068
            java.util.List<androidx.compose.material.SnackbarData> r2 = r0.$keys
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.filterNotNull(r2)
            int r2 = r2.size()
            if (r2 == r13) goto L_0x0068
            r2 = r12
            goto L_0x0069
        L_0x0068:
            r2 = r14
        L_0x0069:
            r15 = r2
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween(r11, r15, r2)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1 r3 = new androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1
            androidx.compose.material.SnackbarData r4 = r0.$key
            androidx.compose.material.FadeInFadeOutState<androidx.compose.material.SnackbarData> r5 = r0.$state
            r3.<init>(r4, r5)
            r4 = r3
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r6 = 0
            r7 = 0
            r3 = r10
            r5 = r41
            androidx.compose.runtime.State r2 = androidx.compose.material.SnackbarHostKt.animatedOpacity(r2, r3, r4, r5, r6, r7)
            androidx.compose.animation.core.Easing r3 = androidx.compose.animation.core.EasingKt.getFastOutSlowInEasing()
            androidx.compose.animation.core.TweenSpec r3 = androidx.compose.animation.core.AnimationSpecKt.tween(r11, r15, r3)
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            androidx.compose.runtime.State r3 = androidx.compose.material.SnackbarHostKt.animatedScale(r3, r10, r8, r14)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            r16 = r4
            androidx.compose.ui.Modifier r16 = (androidx.compose.ui.Modifier) r16
            java.lang.Object r4 = r3.getValue()
            java.lang.Number r4 = (java.lang.Number) r4
            float r17 = r4.floatValue()
            java.lang.Object r4 = r3.getValue()
            java.lang.Number r4 = (java.lang.Number) r4
            float r18 = r4.floatValue()
            java.lang.Object r4 = r2.getValue()
            java.lang.Number r4 = (java.lang.Number) r4
            float r19 = r4.floatValue()
            r37 = 131064(0x1fff8, float:1.8366E-40)
            r38 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r34 = 0
            r36 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.m5121graphicsLayerAp8cVGQ$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r30, r31, r32, r34, r36, r37, r38)
            androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1 r5 = new androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1
            androidx.compose.material.SnackbarData r6 = r0.$key
            r5.<init>(r6)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r6 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r4, r14, r5, r13, r6)
            r5 = r14
            r6 = 0
            r7 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r8.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r7)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getTopStart()
            r13 = 0
            int r16 = r5 >> 3
            r16 = r16 & 14
            int r17 = r5 >> 3
            r17 = r17 & 112(0x70, float:1.57E-43)
            r14 = r16 | r17
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r7, r13, r8, r14)
            int r16 = r5 << 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r17 = 0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r8.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = 0
            int r0 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r0)
            r18 = r2
            androidx.compose.runtime.CompositionLocalMap r2 = r41.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r19 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r19 = r19.getConstructor()
            kotlin.jvm.functions.Function3 r20 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r4)
            r21 = r3
            int r3 = r16 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | 6
            r22 = r20
            r20 = r19
            r19 = 0
            r23 = r4
            androidx.compose.runtime.Applier r4 = r41.getApplier()
            boolean r4 = r4 instanceof androidx.compose.runtime.Applier
            if (r4 != 0) goto L_0x015b
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x015b:
            r41.startReusableNode()
            boolean r4 = r41.getInserting()
            if (r4 == 0) goto L_0x016a
            r4 = r20
            r8.createNode(r4)
            goto L_0x016f
        L_0x016a:
            r4 = r20
            r41.useNode()
        L_0x016f:
            r20 = r4
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m4575constructorimpl(r41)
            r24 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r25 = androidx.compose.ui.node.ComposeUiNode.Companion
            r26 = r6
            kotlin.jvm.functions.Function2 r6 = r25.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r4, r14, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r4, r2, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetCompositeKeyHash()
            r25 = 0
            r27 = r4
            r28 = 0
            boolean r29 = r27.getInserting()
            if (r29 != 0) goto L_0x01b3
            r29 = r2
            java.lang.Object r2 = r27.rememberedValue()
            r30 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)
            if (r2 != 0) goto L_0x01b0
            goto L_0x01b7
        L_0x01b0:
            r7 = r27
            goto L_0x01c7
        L_0x01b3:
            r29 = r2
            r30 = r7
        L_0x01b7:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r7 = r27
            r7.updateRememberedValue(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r4.apply(r2, r6)
        L_0x01c7:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r41)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r2)
            int r4 = r3 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6 = r22
            r6.invoke(r2, r8, r4)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r8.startReplaceableGroup(r2)
            int r2 = r3 >> 9
            r2 = r2 & 14
            r4 = r41
            r7 = 0
            r22 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r24 = r2
            java.lang.String r2 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r2)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r2 = r5 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r25 = r4
            r27 = 0
            r28 = r0
            r0 = 1863798444(0x6f174eac, float:4.6827345E28)
            r31 = r2
            java.lang.String r2 = "C310@11394L10:SnackbarHost.kt#jmzs0o"
            r32 = r3
            r3 = r25
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r2)
            r0 = r9 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.invoke(r3, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r41.endReplaceableGroup()
            r41.endNode()
            r41.endReplaceableGroup()
            r41.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0241
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0241:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1.invoke(kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }
}

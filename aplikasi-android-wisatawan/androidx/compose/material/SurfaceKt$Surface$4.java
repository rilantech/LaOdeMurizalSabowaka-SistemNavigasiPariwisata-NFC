package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Surface.kt */
final class SurfaceKt$Surface$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ float $absoluteElevation;
    final /* synthetic */ BorderStroke $border;
    final /* synthetic */ long $color;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ float $elevation;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Shape $shape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SurfaceKt$Surface$4(Modifier modifier, Shape shape, long j, float f, int i, BorderStroke borderStroke, float f2, MutableInteractionSource mutableInteractionSource, boolean z, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.$modifier = modifier;
        this.$shape = shape;
        this.$color = j;
        this.$absoluteElevation = f;
        this.$$dirty = i;
        this.$border = borderStroke;
        this.$elevation = f2;
        this.$interactionSource = mutableInteractionSource;
        this.$enabled = z;
        this.$onClick = function0;
        this.$content = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r29, int r30) {
        /*
            r28 = this;
            r0 = r28
            r8 = r29
            r9 = r30
            java.lang.String r1 = "C235@11591L7,233@11462L221,243@11902L16,228@11275L827:Surface.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r9 & 11
            r2 = 2
            if (r1 != r2) goto L_0x001c
            boolean r1 = r29.getSkipping()
            if (r1 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r29.skipToGroupEnd()
            goto L_0x01cd
        L_0x001c:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x002b
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.Surface.<anonymous> (Surface.kt:227)"
            r3 = 2031491085(0x7916180d, float:4.870827E34)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r9, r1, r2)
        L_0x002b:
            androidx.compose.ui.Modifier r1 = r0.$modifier
            androidx.compose.ui.Modifier r7 = androidx.compose.material.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r1)
            androidx.compose.ui.graphics.Shape r10 = r0.$shape
            long r1 = r0.$color
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material.ElevationOverlayKt.getLocalElevationOverlay()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 6
            r5 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r11 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r6, r11)
            java.lang.Object r6 = r8.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r29)
            r3 = r6
            androidx.compose.material.ElevationOverlay r3 = (androidx.compose.material.ElevationOverlay) r3
            float r4 = r0.$absoluteElevation
            int r5 = r0.$$dirty
            int r5 = r5 >> 12
            r6 = r5 & 14
            r5 = r29
            long r4 = androidx.compose.material.SurfaceKt.m1427surfaceColorAtElevationcq6XJ1M(r1, r3, r4, r5, r6)
            androidx.compose.foundation.BorderStroke r6 = r0.$border
            float r1 = r0.$elevation
            r2 = r7
            r3 = r10
            r7 = r1
            androidx.compose.ui.Modifier r11 = androidx.compose.material.SurfaceKt.m1426surface8ww4TTg(r2, r3, r4, r6, r7)
            androidx.compose.foundation.interaction.MutableInteractionSource r12 = r0.$interactionSource
            r1 = 0
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = 7
            r5 = r29
            androidx.compose.foundation.Indication r13 = androidx.compose.material.ripple.RippleKt.m1523rememberRipple9IZ8Weo(r1, r2, r3, r5, r6, r7)
            boolean r14 = r0.$enabled
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r0.$onClick
            r18 = 24
            r19 = 0
            r15 = 0
            r16 = 0
            r17 = r1
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.ClickableKt.m198clickableO2vRcR0$default(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r2 = r0.$content
            int r3 = r0.$$dirty
            r4 = 384(0x180, float:5.38E-43)
            r5 = 1
            r6 = 0
            r7 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r8.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r7)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getTopStart()
            int r10 = r4 >> 3
            r10 = r10 & 14
            int r11 = r4 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r10 = r10 | r11
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r7, r5, r8, r10)
            int r11 = r4 << 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r12 = 0
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r8.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r13)
            r13 = 0
            int r13 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r13)
            androidx.compose.runtime.CompositionLocalMap r14 = r29.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r16 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r1)
            int r0 = r11 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r17 = r16
            r16 = 0
            r18 = r1
            androidx.compose.runtime.Applier r1 = r29.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x00eb
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00eb:
            r29.startReusableNode()
            boolean r1 = r29.getInserting()
            if (r1 == 0) goto L_0x00f8
            r8.createNode(r15)
            goto L_0x00fb
        L_0x00f8:
            r29.useNode()
        L_0x00fb:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m2865constructorimpl(r29)
            r19 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
            r21 = r5
            kotlin.jvm.functions.Function2 r5 = r20.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r1, r10, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r1, r14, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetCompositeKeyHash()
            r20 = 0
            r22 = r1
            r23 = 0
            boolean r24 = r22.getInserting()
            if (r24 != 0) goto L_0x013d
            r24 = r6
            java.lang.Object r6 = r22.rememberedValue()
            r25 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 != 0) goto L_0x013a
            goto L_0x0141
        L_0x013a:
            r7 = r22
            goto L_0x0151
        L_0x013d:
            r24 = r6
            r25 = r7
        L_0x0141:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r13)
            r7 = r22
            r7.updateRememberedValue(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r13)
            r1.apply(r6, r5)
        L_0x0151:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r29)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r1)
            int r5 = r0 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6 = r17
            r6.invoke(r1, r8, r5)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r8.startReplaceableGroup(r1)
            int r1 = r0 >> 9
            r1 = r1 & 14
            r5 = r29
            r7 = 0
            r17 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r19 = r1
            java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r4 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r20 = r5
            r22 = 0
            r23 = r0
            r0 = 1505975758(0x59c35dce, float:6.873845E15)
            r26 = r1
            java.lang.String r1 = "C249@12083L9:Surface.kt#jmzs0o"
            r27 = r4
            r4 = r20
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r1)
            int r0 = r3 >> 27
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.invoke(r4, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r29.endReplaceableGroup()
            r29.endNode()
            r29.endReplaceableGroup()
            r29.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01cd
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt$Surface$4.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

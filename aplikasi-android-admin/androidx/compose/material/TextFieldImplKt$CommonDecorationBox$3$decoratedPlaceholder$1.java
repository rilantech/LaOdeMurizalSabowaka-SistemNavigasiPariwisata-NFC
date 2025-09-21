package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "modifier", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1 extends Lambda implements Function3<Modifier, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ float $placeholderAlphaProgress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1(float f, TextFieldColors textFieldColors, boolean z, int i, int i2, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(3);
        this.$placeholderAlphaProgress = f;
        this.$colors = textFieldColors;
        this.$enabled = z;
        this.$$dirty = i;
        this.$$dirty1 = i2;
        this.$placeholder = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.ui.Modifier r34, androidx.compose.runtime.Composer r35, int r36) {
        /*
            r33 = this;
            r0 = r33
            r1 = r34
            r2 = r35
            r3 = r36
            java.lang.String r4 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "C138@5768L341:TextFieldImpl.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r4)
            r4 = r36
            r5 = r3 & 14
            if (r5 != 0) goto L_0x0023
            boolean r5 = r2.changed((java.lang.Object) r1)
            if (r5 == 0) goto L_0x0021
            r5 = 4
            goto L_0x0022
        L_0x0021:
            r5 = 2
        L_0x0022:
            r4 = r4 | r5
        L_0x0023:
            r5 = r4 & 91
            r6 = 18
            if (r5 != r6) goto L_0x0037
            boolean r5 = r35.getSkipping()
            if (r5 != 0) goto L_0x0030
            goto L_0x0037
        L_0x0030:
            r35.skipToGroupEnd()
            r28 = r4
            goto L_0x01c7
        L_0x0037:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0046
            r5 = -1
            java.lang.String r6 = "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:137)"
            r7 = 1120552650(0x42ca46ca, float:101.13826)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r5, r6)
        L_0x0046:
            float r5 = r0.$placeholderAlphaProgress
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.draw.AlphaKt.alpha(r1, r5)
            androidx.compose.material.TextFieldColors r6 = r0.$colors
            boolean r7 = r0.$enabled
            int r8 = r0.$$dirty
            int r9 = r0.$$dirty1
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r14 = r0.$placeholder
            r18 = 0
            r19 = 0
            r10 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r10)
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r15 = r10.getTopStart()
            r13 = 0
            int r10 = r18 >> 3
            r10 = r10 & 14
            int r11 = r18 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r10 = r10 | r11
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r15, r13, r2, r10)
            int r10 = r18 << 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r20 = r10
            r21 = 0
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r10)
            r10 = 0
            int r22 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r10)
            androidx.compose.runtime.CompositionLocalMap r10 = r35.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r16 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r5)
            int r0 = r20 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = 6
            r0 = r0 | r1
            r23 = r16
            r24 = 0
            androidx.compose.runtime.Applier r1 = r35.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x00b5
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00b5:
            r35.startReusableNode()
            boolean r1 = r35.getInserting()
            if (r1 == 0) goto L_0x00c2
            r2.createNode(r11)
            goto L_0x00c5
        L_0x00c2:
            r35.useNode()
        L_0x00c5:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m4575constructorimpl(r35)
            r17 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r25 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r25.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r12, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r10, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            r25 = 0
            r26 = r1
            r27 = 0
            boolean r28 = r26.getInserting()
            if (r28 != 0) goto L_0x0105
            r28 = r4
            java.lang.Object r4 = r26.rememberedValue()
            r29 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r22)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x0102
            goto L_0x0109
        L_0x0102:
            r5 = r26
            goto L_0x0119
        L_0x0105:
            r28 = r4
            r29 = r5
        L_0x0109:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r22)
            r5 = r26
            r5.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r22)
            r1.apply(r4, r3)
        L_0x0119:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r35)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r1)
            int r3 = r0 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = r23
            r4.invoke(r1, r2, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r1)
            int r1 = r0 >> 9
            r1 = r1 & 14
            r3 = r35
            r5 = 0
            r23 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r25 = r1
            java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r18 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r16 = 6
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r26 = r3
            r27 = 0
            r30 = r0
            r0 = -1536681527(0xffffffffa46819c9, float:-5.0328822E-17)
            r31 = r1
            java.lang.String r1 = "C140@5902L25,141@5990L10,139@5840L247:TextFieldImpl.kt#jmzs0o"
            r17 = r13
            r13 = r26
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r1)
            int r0 = r8 >> 27
            r0 = r0 & 14
            r1 = 6
            int r9 = r9 >> r1
            r9 = r9 & 112(0x70, float:1.57E-43)
            r0 = r0 | r9
            androidx.compose.runtime.State r0 = r6.placeholderColor(r7, r13, r0)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r6 = r0.m4973unboximpl()
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r0 = r0.getTypography(r13, r1)
            androidx.compose.ui.text.TextStyle r0 = r0.getSubtitle1()
            int r1 = r8 >> 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r8 = 0
            r9 = 4
            r26 = r10
            r32 = r11
            r10 = r6
            r6 = r12
            r12 = r0
            r7 = r13
            r0 = r17
            r13 = r8
            r8 = r15
            r15 = r7
            r16 = r1
            r17 = r9
            androidx.compose.material.TextFieldImplKt.m3185DecorationeuL9pac(r10, r12, r13, r14, r15, r16, r17)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r35.endReplaceableGroup()
            r35.endNode()
            r35.endReplaceableGroup()
            r35.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01c7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):void");
    }
}

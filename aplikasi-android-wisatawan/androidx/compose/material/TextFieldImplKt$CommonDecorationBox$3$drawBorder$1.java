package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$CommonDecorationBox$3$drawBorder$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ Function2<Composer, Integer, Unit> $border;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ MutableState<Size> $labelSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$3$drawBorder$1(MutableState<Size> mutableState, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$labelSize = mutableState;
        this.$contentPadding = paddingValues;
        this.$border = function2;
        this.$$dirty1 = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r27, int r28) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r2 = r28
            java.lang.String r3 = "C194@8214L246:TextFieldImpl.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 11
            r4 = 2
            if (r3 != r4) goto L_0x001c
            boolean r3 = r27.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r27.skipToGroupEnd()
            goto L_0x0199
        L_0x001c:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002b
            r3 = -1
            java.lang.String r4 = "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:193)"
            r5 = 139886979(0x8568183, float:6.4550523E-34)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
        L_0x002b:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            java.lang.String r4 = "border"
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r3, r4)
            androidx.compose.runtime.MutableState<androidx.compose.ui.geometry.Size> r4 = r0.$labelSize
            java.lang.Object r4 = r4.getValue()
            androidx.compose.ui.geometry.Size r4 = (androidx.compose.ui.geometry.Size) r4
            long r4 = r4.m3077unboximpl()
            androidx.compose.foundation.layout.PaddingValues r6 = r0.$contentPadding
            androidx.compose.ui.Modifier r3 = androidx.compose.material.OutlinedTextFieldKt.m1366outlineCutout12SF9DM(r3, r4, r6)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$border
            int r5 = r0.$$dirty1
            r6 = 384(0x180, float:5.38E-43)
            r7 = 1
            r8 = 0
            r9 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r1.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r9)
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r9 = r9.getTopStart()
            int r10 = r6 >> 3
            r10 = r10 & 14
            int r11 = r6 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r10 = r10 | r11
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r9, r7, r1, r10)
            int r11 = r6 << 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r12 = 0
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r13)
            r13 = 0
            int r13 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r13)
            androidx.compose.runtime.CompositionLocalMap r14 = r27.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r16 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            int r0 = r11 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r17 = r16
            r16 = 0
            androidx.compose.runtime.Applier r2 = r27.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x00a8
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00a8:
            r27.startReusableNode()
            boolean r2 = r27.getInserting()
            if (r2 == 0) goto L_0x00b5
            r1.createNode(r15)
            goto L_0x00b8
        L_0x00b5:
            r27.useNode()
        L_0x00b8:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m2865constructorimpl(r27)
            r18 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r19 = androidx.compose.ui.node.ComposeUiNode.Companion
            r20 = r3
            kotlin.jvm.functions.Function2 r3 = r19.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r2, r10, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r2, r14, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            r19 = 0
            r21 = r2
            r22 = 0
            boolean r23 = r21.getInserting()
            if (r23 != 0) goto L_0x00fa
            r23 = r7
            java.lang.Object r7 = r21.rememberedValue()
            r24 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r13)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 != 0) goto L_0x00f7
            goto L_0x00fe
        L_0x00f7:
            r8 = r21
            goto L_0x010e
        L_0x00fa:
            r23 = r7
            r24 = r8
        L_0x00fe:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)
            r8 = r21
            r8.updateRememberedValue(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)
            r2.apply(r7, r3)
        L_0x010e:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r27)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r2)
            int r3 = r0 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7 = r17
            r7.invoke(r2, r1, r3)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r2)
            int r2 = r0 >> 9
            r2 = r2 & 14
            r3 = r27
            r8 = 0
            r17 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r6 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r18 = r3
            r19 = 0
            r21 = r0
            r0 = -1536678945(0xffffffffa46823df, float:-5.0337365E-17)
            r22 = r1
            java.lang.String r1 = "C:TextFieldImpl.kt#jmzs0o"
            r25 = r2
            r2 = r18
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            r0 = 1661576646(0x6309a5c6, float:2.5391492E21)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "198@8430L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            if (r4 != 0) goto L_0x016b
            goto L_0x0176
        L_0x016b:
            int r0 = r5 >> 12
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4.invoke(r2, r0)
        L_0x0176:
            r2.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r27.endReplaceableGroup()
            r27.endNode()
            r27.endReplaceableGroup()
            r27.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0199
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0199:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

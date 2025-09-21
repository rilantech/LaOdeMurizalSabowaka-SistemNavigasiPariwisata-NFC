package androidx.compose.ui.window;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
final class AndroidPopup_androidKt$Popup$popupLayout$1$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ State<Function2<Composer, Integer, Unit>> $currentContent$delegate;
    final /* synthetic */ PopupLayout $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidPopup_androidKt$Popup$popupLayout$1$1$1(PopupLayout popupLayout, State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        super(2);
        this.$this_apply = popupLayout;
        this.$currentContent$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r23, int r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            java.lang.String r3 = "C245@10379L533:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 11
            r4 = 2
            if (r3 != r4) goto L_0x001c
            boolean r3 = r23.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r23.skipToGroupEnd()
            goto L_0x0159
        L_0x001c:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002b
            r3 = -1
            java.lang.String r4 = "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:244)"
            r5 = 1302892335(0x4da88f2f, float:3.53494496E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
        L_0x002b:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1 r4 = androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1.AnonymousClass1.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r5 = 0
            r6 = 0
            r7 = 1
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r3, r6, r4, r7, r5)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$2 r4 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$2
            androidx.compose.ui.window.PopupLayout r5 = r0.$this_apply
            r4.<init>(r5)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.layout.OnRemeasuredModifierKt.onSizeChanged(r3, r4)
            androidx.compose.ui.window.PopupLayout r4 = r0.$this_apply
            boolean r4 = r4.getCanCalculatePosition()
            if (r4 == 0) goto L_0x0052
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0053
        L_0x0052:
            r4 = 0
        L_0x0053:
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.draw.AlphaKt.alpha(r3, r4)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$3 r4 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$3
            androidx.compose.runtime.State<kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>> r5 = r0.$currentContent$delegate
            r4.<init>(r5)
            r5 = 606497925(0x24266c85, float:3.6087432E-17)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r5, r7, r4)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = 48
            r7 = 0
            r8 = 1406149896(0x53d02508, float:1.78794896E12)
            r1.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(SimpleStack)P(1)340@14172L979:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r8)
            androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1 r8 = androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r8 = (androidx.compose.ui.layout.MeasurePolicy) r8
            int r9 = r5 >> 3
            r9 = r9 & 14
            int r10 = r5 << 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r9 = r9 | r10
            r10 = 0
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            int r6 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r6)
            androidx.compose.runtime.CompositionLocalMap r11 = r23.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r13 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            int r14 = r9 << 9
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r14 = r14 | 6
            r15 = 0
            androidx.compose.runtime.Applier r0 = r23.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x00b4
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00b4:
            r23.startReusableNode()
            boolean r0 = r23.getInserting()
            if (r0 == 0) goto L_0x00c1
            r1.createNode(r12)
            goto L_0x00c4
        L_0x00c1:
            r23.useNode()
        L_0x00c4:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m2865constructorimpl(r23)
            r16 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r8, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r11, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            r17 = 0
            r18 = r0
            r19 = 0
            boolean r20 = r18.getInserting()
            if (r20 != 0) goto L_0x0104
            r20 = r3
            java.lang.Object r3 = r18.rememberedValue()
            r21 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 != 0) goto L_0x0101
            goto L_0x0108
        L_0x0101:
            r5 = r18
            goto L_0x0118
        L_0x0104:
            r20 = r3
            r21 = r5
        L_0x0108:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            r5 = r18
            r5.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            r0.apply(r3, r2)
        L_0x0118:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r23)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r0)
            int r2 = r14 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r13.invoke(r0, r1, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r0)
            int r0 = r14 >> 9
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4.invoke(r1, r0)
            r23.endReplaceableGroup()
            r23.endNode()
            r23.endReplaceableGroup()
            r23.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0159
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0159:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

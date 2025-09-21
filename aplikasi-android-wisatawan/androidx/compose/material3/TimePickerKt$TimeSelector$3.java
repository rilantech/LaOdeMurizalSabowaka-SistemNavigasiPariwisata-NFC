package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$TimeSelector$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ int $selection;
    final /* synthetic */ TimePickerState $state;
    final /* synthetic */ int $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimeSelector$3(int i, TimePickerState timePickerState, int i2, int i3, long j) {
        super(2);
        this.$selection = i;
        this.$state = timePickerState;
        this.$value = i2;
        this.$$dirty = i3;
        this.$contentColor = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r50, int r51) {
        /*
            r49 = this;
            r0 = r49
            r1 = r50
            r2 = r51
            java.lang.String r3 = "C1107@43374L152,1113@43536L277:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 11
            r4 = 2
            if (r3 != r4) goto L_0x001c
            boolean r3 = r50.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r50.skipToGroupEnd()
            goto L_0x022d
        L_0x001c:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002b
            r3 = -1
            java.lang.String r5 = "androidx.compose.material3.TimeSelector.<anonymous> (TimePicker.kt:1105)"
            r6 = -1338709103(0xffffffffb034eb91, float:-6.581838E-10)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r2, r3, r5)
        L_0x002b:
            int r3 = r0.$selection
            androidx.compose.material3.TimePickerState r5 = r0.$state
            boolean r5 = r5.is24hour()
            int r6 = r0.$value
            int r7 = r0.$$dirty
            int r8 = r7 >> 9
            r8 = r8 & 14
            int r7 = r7 << 3
            r7 = r7 & 896(0x380, float:1.256E-42)
            r7 = r7 | r8
            java.lang.String r3 = androidx.compose.material3.TimePickerKt.m2170numberContentDescriptionYKJpE6Y(r3, r5, r6, r1, r7)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getCenter()
            int r6 = r0.$value
            long r9 = r0.$contentColor
            r32 = 48
            r33 = 0
            r7 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r1.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r7)
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            r34 = r7
            androidx.compose.ui.Modifier r34 = (androidx.compose.ui.Modifier) r34
            r15 = 0
            int r7 = r32 >> 3
            r7 = r7 & 14
            int r8 = r32 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            r7 = r7 | r8
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r15, r1, r7)
            int r7 = r32 << 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            r35 = r7
            r36 = 0
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r7)
            java.lang.String r7 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r8 = 6
            r11 = 0
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r12, r13)
            java.lang.Object r16 = r1.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r50)
            r11 = r16
            androidx.compose.ui.unit.Density r11 = (androidx.compose.ui.unit.Density) r11
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r8 = 6
            r16 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r12, r13)
            java.lang.Object r17 = r1.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r50)
            r7 = r17
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r16 = 6
            r17 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r12, r13)
            java.lang.Object r12 = r1.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r50)
            r13 = r12
            androidx.compose.ui.platform.ViewConfiguration r13 = (androidx.compose.ui.platform.ViewConfiguration) r13
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            kotlin.jvm.functions.Function3 r12 = androidx.compose.ui.layout.LayoutKt.materializerOf(r34)
            int r4 = r35 << 9
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | 6
            r37 = 0
            androidx.compose.runtime.Applier r0 = r50.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x00ec
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00ec:
            r50.startReusableNode()
            boolean r0 = r50.getInserting()
            if (r0 == 0) goto L_0x00f9
            r1.createNode(r8)
            goto L_0x00fc
        L_0x00f9:
            r50.useNode()
        L_0x00fc:
            r50.disableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m2865constructorimpl(r50)
            r17 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r18.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r14, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r11, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r7, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r13, r2)
            r50.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r50)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r0)
            int r2 = r4 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.invoke(r0, r1, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r0)
            int r0 = r4 >> 9
            r0 = r0 & 14
            r2 = r50
            r38 = 0
            r39 = r0
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r32 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r40 = r2
            r41 = 0
            r42 = r0
            r0 = 992575674(0x3b2980ba, float:0.002586408)
            r43 = r1
            java.lang.String r1 = "C1115@43643L48,1114@43591L212:TimePicker.kt#uh7d8r"
            r17 = r15
            r15 = r40
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r0, r1)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r1 = 0
            r18 = 0
            r19 = r1
            r1 = 1157296644(0x44faf204, float:2007.563)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            boolean r1 = r15.changed((java.lang.Object) r3)
            r20 = r15
            r21 = 0
            r40 = r4
            java.lang.Object r4 = r20.rememberedValue()
            r22 = 0
            if (r1 != 0) goto L_0x01ad
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r24 = r1
            java.lang.Object r1 = r23.getEmpty()
            if (r4 != r1) goto L_0x01a7
            goto L_0x01af
        L_0x01a7:
            r44 = r3
            r1 = r4
            r3 = r20
            goto L_0x01c2
        L_0x01ad:
            r24 = r1
        L_0x01af:
            r1 = 0
            r23 = r1
            androidx.compose.material3.TimePickerKt$TimeSelector$3$1$1$1 r1 = new androidx.compose.material3.TimePickerKt$TimeSelector$3$1$1$1
            r1.<init>(r3)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r44 = r3
            r3 = r20
            r3.updateRememberedValue(r1)
        L_0x01c2:
            r15.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r3 = 1
            r4 = 0
            r45 = r5
            r5 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r5, r1, r3, r4)
            r1 = r8
            r8 = r0
            r0 = 2
            java.lang.String r0 = androidx.compose.material3.TimePickerKt.toLocalString(r6, r0)
            r3 = r7
            r7 = r0
            r4 = 0
            r0 = r11
            r6 = r12
            r11 = r4
            r4 = 0
            r5 = r13
            r13 = r4
            r46 = r14
            r14 = r4
            r48 = r15
            r47 = r17
            r15 = r4
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            r30 = 0
            r31 = 131064(0x1fff8, float:1.8366E-40)
            r28 = r48
            androidx.compose.material3.TextKt.m2148Text4IGK_g((java.lang.String) r7, (androidx.compose.ui.Modifier) r8, (long) r9, (long) r11, (androidx.compose.ui.text.font.FontStyle) r13, (androidx.compose.ui.text.font.FontWeight) r14, (androidx.compose.ui.text.font.FontFamily) r15, (long) r16, (androidx.compose.ui.text.style.TextDecoration) r18, (androidx.compose.ui.text.style.TextAlign) r19, (long) r20, (int) r22, (boolean) r23, (int) r24, (int) r25, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r26, (androidx.compose.ui.text.TextStyle) r27, (androidx.compose.runtime.Composer) r28, (int) r29, (int) r30, (int) r31)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r48)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r50.endReplaceableGroup()
            r50.endNode()
            r50.endReplaceableGroup()
            r50.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x022d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x022d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt$TimeSelector$3.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

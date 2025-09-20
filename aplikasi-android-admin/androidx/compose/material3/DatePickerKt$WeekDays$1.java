package androidx.compose.material3;

import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$WeekDays$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ ArrayList<Pair<String, String>> $dayNames;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$WeekDays$1(ArrayList<Pair<String, String>> arrayList) {
        super(2);
        this.$dayNames = arrayList;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1367@56264L10,1368@56338L1151:DatePicker.kt#uh7d8r");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1445541615, $changed, -1, "androidx.compose.material3.WeekDays.<anonymous> (DatePicker.kt:1365)");
            }
            TextStyle textStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer, 6), DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextFont());
            final ArrayList<Pair<String, String>> arrayList = this.$dayNames;
            TextKt.ProvideTextStyle(textStyle, ComposableLambdaKt.composableLambda($composer, 2133710592, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARNING: Removed duplicated region for block: B:27:0x02bf  */
                /* JADX WARNING: Removed duplicated region for block: B:30:0x02cb  */
                /* JADX WARNING: Removed duplicated region for block: B:31:0x02d1  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void invoke(androidx.compose.runtime.Composer r85, int r86) {
                    /*
                        r84 = this;
                        r0 = r85
                        r1 = r86
                        java.lang.String r2 = "C1369@56388L1091:DatePicker.kt#uh7d8r"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
                        r2 = r1 & 11
                        r3 = 2
                        if (r2 != r3) goto L_0x001a
                        boolean r2 = r85.getSkipping()
                        if (r2 != 0) goto L_0x0015
                        goto L_0x001a
                    L_0x0015:
                        r85.skipToGroupEnd()
                        goto L_0x0402
                    L_0x001a:
                        boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                        if (r2 == 0) goto L_0x0029
                        r2 = -1
                        java.lang.String r3 = "androidx.compose.material3.WeekDays.<anonymous>.<anonymous> (DatePicker.kt:1368)"
                        r4 = 2133710592(0x7f2dd700, float:2.3107279E38)
                        androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
                    L_0x0029:
                        androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
                        float r3 = androidx.compose.material3.DatePickerKt.getRecommendedSizeForAccessibility()
                        r4 = 0
                        r5 = 1
                        r6 = 0
                        androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m2307defaultMinSizeVpY3zN4$default(r2, r4, r3, r5, r6)
                        androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r2, r4, r5, r6)
                        androidx.compose.foundation.layout.Arrangement r3 = androidx.compose.foundation.layout.Arrangement.INSTANCE
                        androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r3 = r3.getSpaceEvenly()
                        androidx.compose.foundation.layout.Arrangement$Horizontal r3 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r3
                        androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
                        androidx.compose.ui.Alignment$Vertical r4 = r4.getCenterVertically()
                        r5 = r84
                        java.util.ArrayList<kotlin.Pair<java.lang.String, java.lang.String>> r7 = r2
                        r8 = 438(0x1b6, float:6.14E-43)
                        r9 = 0
                        r10 = 693286680(0x2952b718, float:4.6788176E-14)
                        r0.startReplaceableGroup(r10)
                        java.lang.String r10 = "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r0, r10)
                        int r10 = r8 >> 3
                        r10 = r10 & 14
                        int r11 = r8 >> 3
                        r11 = r11 & 112(0x70, float:1.57E-43)
                        r10 = r10 | r11
                        androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r3, r4, r0, r10)
                        int r11 = r8 << 3
                        r11 = r11 & 112(0x70, float:1.57E-43)
                        r12 = 0
                        r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
                        r0.startReplaceableGroup(r13)
                        java.lang.String r14 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
                        androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
                        androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
                        r16 = 6
                        r17 = 0
                        r6 = 2023513938(0x789c5f52, float:2.5372864E34)
                        java.lang.String r13 = "C:CompositionLocal.kt#9igjgp"
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r13)
                        java.lang.Object r20 = r0.consume(r15)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r85)
                        r15 = r20
                        androidx.compose.ui.unit.Density r15 = (androidx.compose.ui.unit.Density) r15
                        androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
                        r6 = r16
                        androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
                        r16 = 6
                        r20 = 0
                        r1 = 2023513938(0x789c5f52, float:2.5372864E34)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r1, r13)
                        java.lang.Object r1 = r0.consume(r6)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r85)
                        androidx.compose.ui.unit.LayoutDirection r1 = (androidx.compose.ui.unit.LayoutDirection) r1
                        androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
                        androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
                        r16 = 6
                        r20 = 0
                        r21 = r3
                        r3 = 2023513938(0x789c5f52, float:2.5372864E34)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r3, r13)
                        java.lang.Object r3 = r0.consume(r6)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r85)
                        androidx.compose.ui.platform.ViewConfiguration r3 = (androidx.compose.ui.platform.ViewConfiguration) r3
                        androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
                        kotlin.jvm.functions.Function3 r16 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
                        r20 = r2
                        int r2 = r11 << 9
                        r2 = r2 & 7168(0x1c00, float:1.0045E-41)
                        r2 = r2 | 6
                        r22 = r16
                        r16 = 0
                        r23 = r4
                        androidx.compose.runtime.Applier r4 = r85.getApplier()
                        boolean r4 = r4 instanceof androidx.compose.runtime.Applier
                        if (r4 != 0) goto L_0x00f1
                        androidx.compose.runtime.ComposablesKt.invalidApplier()
                    L_0x00f1:
                        r85.startReusableNode()
                        boolean r4 = r85.getInserting()
                        if (r4 == 0) goto L_0x00fe
                        r0.createNode(r6)
                        goto L_0x0101
                    L_0x00fe:
                        r85.useNode()
                    L_0x0101:
                        r85.disableReusing()
                        androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m4575constructorimpl(r85)
                        r24 = 0
                        androidx.compose.ui.node.ComposeUiNode$Companion r25 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r5 = r25.getSetMeasurePolicy()
                        androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r4, r10, r5)
                        androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
                        androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r4, r15, r5)
                        androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
                        androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r4, r1, r5)
                        androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r5 = r5.getSetViewConfiguration()
                        androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r4, r3, r5)
                        r85.enableReusing()
                        androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r85)
                        androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r4)
                        int r5 = r2 >> 3
                        r5 = r5 & 112(0x70, float:1.57E-43)
                        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                        r24 = r1
                        r1 = r22
                        r1.invoke(r4, r0, r5)
                        r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                        r0.startReplaceableGroup(r4)
                        int r5 = r2 >> 9
                        r5 = r5 & 14
                        r22 = r85
                        r25 = 0
                        r4 = -326682283(0xffffffffec873955, float:-1.3078058E27)
                        java.lang.String r0 = "C80@4021L9:Row.kt#2w3rfo"
                        r27 = r1
                        r1 = r22
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r4, r0)
                        androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
                        int r4 = r8 >> 6
                        r4 = r4 & 112(0x70, float:1.57E-43)
                        r4 = r4 | 6
                        androidx.compose.foundation.layout.RowScope r0 = (androidx.compose.foundation.layout.RowScope) r0
                        r28 = 0
                        r29 = r0
                        r0 = 178836230(0xaa8d306, float:1.625719E-32)
                        r30 = r2
                        java.lang.String r2 = "C:DatePicker.kt#uh7d8r"
                        r31 = r3
                        r3 = r22
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r2)
                        r0 = 784203502(0x2ebdfeee, float:8.6400095E-11)
                        r3.startReplaceableGroup(r0)
                        java.lang.String r0 = "*1381@56891L33,1379@56792L655"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
                        r0 = r7
                        java.lang.Iterable r0 = (java.lang.Iterable) r0
                        r2 = 0
                        java.util.Iterator r7 = r0.iterator()
                    L_0x0192:
                        boolean r22 = r7.hasNext()
                        if (r22 == 0) goto L_0x03cf
                        java.lang.Object r22 = r7.next()
                        r32 = r0
                        r0 = r22
                        kotlin.Pair r0 = (kotlin.Pair) r0
                        r33 = 0
                        androidx.compose.ui.Modifier$Companion r34 = androidx.compose.ui.Modifier.Companion
                        r35 = r2
                        r2 = r34
                        androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
                        r34 = r4
                        r4 = 0
                        r36 = r4
                        r37 = 0
                        r4 = 1157296644(0x44faf204, float:2007.563)
                        r3.startReplaceableGroup(r4)
                        java.lang.String r4 = "CC(remember)P(1):Composables.kt#9igjgp"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
                        boolean r4 = r3.changed((java.lang.Object) r0)
                        r38 = r3
                        r39 = 0
                        r40 = r5
                        java.lang.Object r5 = r38.rememberedValue()
                        r41 = 0
                        if (r4 != 0) goto L_0x01e1
                        androidx.compose.runtime.Composer$Companion r42 = androidx.compose.runtime.Composer.Companion
                        r43 = r4
                        java.lang.Object r4 = r42.getEmpty()
                        if (r5 != r4) goto L_0x01db
                        goto L_0x01e3
                    L_0x01db:
                        r4 = r5
                        r42 = r4
                        r5 = r38
                        goto L_0x01f6
                    L_0x01e1:
                        r43 = r4
                    L_0x01e3:
                        r4 = 0
                        r42 = r4
                        androidx.compose.material3.DatePickerKt$WeekDays$1$1$1$1$1$1 r4 = new androidx.compose.material3.DatePickerKt$WeekDays$1$1$1$1$1$1
                        r4.<init>(r0)
                        kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
                        r42 = r5
                        r5 = r38
                        r5.updateRememberedValue(r4)
                    L_0x01f6:
                        r3.endReplaceableGroup()
                        kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
                        androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.clearAndSetSemantics(r2, r4)
                        float r4 = androidx.compose.material3.DatePickerKt.getRecommendedSizeForAccessibility()
                        float r5 = androidx.compose.material3.DatePickerKt.getRecommendedSizeForAccessibility()
                        androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m2324sizeVpY3zN4(r2, r4, r5)
                        androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
                        androidx.compose.ui.Alignment r4 = r4.getCenter()
                        r5 = 48
                        r36 = 0
                        r37 = r6
                        r6 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
                        r3.startReplaceableGroup(r6)
                        java.lang.String r6 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r3, r6)
                        r6 = 0
                        int r38 = r5 >> 3
                        r38 = r38 & 14
                        int r39 = r5 >> 3
                        r39 = r39 & 112(0x70, float:1.57E-43)
                        r41 = r7
                        r7 = r38 | r39
                        androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r4, r6, r3, r7)
                        int r38 = r5 << 3
                        r38 = r38 & 112(0x70, float:1.57E-43)
                        r39 = 0
                        r42 = r4
                        r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
                        r3.startReplaceableGroup(r4)
                        androidx.compose.runtime.ComposerKt.sourceInformation(r3, r14)
                        androidx.compose.runtime.ProvidableCompositionLocal r19 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
                        r4 = r19
                        androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
                        r19 = 6
                        r44 = 0
                        r45 = r6
                        r6 = 2023513938(0x789c5f52, float:2.5372864E34)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r6, r13)
                        java.lang.Object r6 = r3.consume(r4)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
                        r4 = r6
                        androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
                        androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
                        androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
                        r19 = 6
                        r44 = 0
                        r46 = r8
                        r8 = 2023513938(0x789c5f52, float:2.5372864E34)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r8, r13)
                        java.lang.Object r8 = r3.consume(r6)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
                        r6 = r8
                        androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
                        androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
                        androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
                        r19 = 6
                        r44 = 0
                        r47 = r9
                        r9 = 2023513938(0x789c5f52, float:2.5372864E34)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r9, r13)
                        java.lang.Object r17 = r3.consume(r8)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
                        r8 = r17
                        androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
                        androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function0 r17 = r17.getConstructor()
                        kotlin.jvm.functions.Function3 r19 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
                        int r9 = r38 << 9
                        r9 = r9 & 7168(0x1c00, float:1.0045E-41)
                        r9 = r9 | 6
                        r48 = r19
                        r19 = r17
                        r17 = 0
                        r49 = r2
                        androidx.compose.runtime.Applier r2 = r3.getApplier()
                        boolean r2 = r2 instanceof androidx.compose.runtime.Applier
                        if (r2 != 0) goto L_0x02c2
                        androidx.compose.runtime.ComposablesKt.invalidApplier()
                    L_0x02c2:
                        r3.startReusableNode()
                        boolean r2 = r3.getInserting()
                        if (r2 == 0) goto L_0x02d1
                        r2 = r19
                        r3.createNode(r2)
                        goto L_0x02d6
                    L_0x02d1:
                        r2 = r19
                        r3.useNode()
                    L_0x02d6:
                        r3.disableReusing()
                        r19 = r2
                        androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m4575constructorimpl(r3)
                        r50 = 0
                        androidx.compose.ui.node.ComposeUiNode$Companion r51 = androidx.compose.ui.node.ComposeUiNode.Companion
                        r52 = r10
                        kotlin.jvm.functions.Function2 r10 = r51.getSetMeasurePolicy()
                        androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r7, r10)
                        androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r10 = r10.getSetDensity()
                        androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r4, r10)
                        androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r10 = r10.getSetLayoutDirection()
                        androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r6, r10)
                        androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r10 = r10.getSetViewConfiguration()
                        androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r8, r10)
                        r3.enableReusing()
                        androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r3)
                        androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r2)
                        int r10 = r9 >> 3
                        r10 = r10 & 112(0x70, float:1.57E-43)
                        java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
                        r50 = r4
                        r4 = r48
                        r4.invoke(r2, r3, r10)
                        r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                        r3.startReplaceableGroup(r2)
                        int r10 = r9 >> 9
                        r10 = r10 & 14
                        r26 = r3
                        r48 = 0
                        r2 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
                        r53 = r4
                        java.lang.String r4 = "C72@3384L9:Box.kt#2w3rfo"
                        r54 = r6
                        r6 = r26
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r4)
                        androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
                        int r4 = r5 >> 6
                        r4 = r4 & 112(0x70, float:1.57E-43)
                        r4 = r4 | 6
                        androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
                        r76 = r26
                        r80 = 0
                        r81 = r2
                        r2 = -540917601(0xffffffffdfc2409f, float:-2.7994725E19)
                        r82 = r4
                        java.lang.String r4 = "C1387@57224L201:DatePicker.kt#uh7d8r"
                        r83 = r5
                        r5 = r26
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r4)
                        java.lang.Object r2 = r0.getSecond()
                        r55 = r2
                        java.lang.String r55 = (java.lang.String) r55
                        androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
                        r4 = 3
                        r26 = r0
                        r18 = r7
                        r0 = 0
                        r7 = 0
                        androidx.compose.ui.Modifier r56 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r2, r7, r0, r4, r7)
                        androidx.compose.ui.text.style.TextAlign$Companion r0 = androidx.compose.ui.text.style.TextAlign.Companion
                        int r0 = r0.m7417getCentere0LSkKk()
                        androidx.compose.ui.text.style.TextAlign r67 = androidx.compose.ui.text.style.TextAlign.m7410boximpl(r0)
                        r57 = 0
                        r59 = 0
                        r61 = 0
                        r62 = 0
                        r63 = 0
                        r64 = 0
                        r66 = 0
                        r68 = 0
                        r70 = 0
                        r71 = 0
                        r72 = 0
                        r73 = 0
                        r74 = 0
                        r75 = 0
                        r77 = 48
                        r78 = 0
                        r79 = 130556(0x1fdfc, float:1.82948E-40)
                        androidx.compose.material3.TextKt.m3858Text4IGK_g((java.lang.String) r55, (androidx.compose.ui.Modifier) r56, (long) r57, (long) r59, (androidx.compose.ui.text.font.FontStyle) r61, (androidx.compose.ui.text.font.FontWeight) r62, (androidx.compose.ui.text.font.FontFamily) r63, (long) r64, (androidx.compose.ui.text.style.TextDecoration) r66, (androidx.compose.ui.text.style.TextAlign) r67, (long) r68, (int) r70, (boolean) r71, (int) r72, (int) r73, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r74, (androidx.compose.ui.text.TextStyle) r75, (androidx.compose.runtime.Composer) r76, (int) r77, (int) r78, (int) r79)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
                        r3.endReplaceableGroup()
                        r3.endNode()
                        r3.endReplaceableGroup()
                        r3.endReplaceableGroup()
                        r0 = r32
                        r4 = r34
                        r2 = r35
                        r6 = r37
                        r5 = r40
                        r7 = r41
                        r8 = r46
                        r9 = r47
                        r10 = r52
                        goto L_0x0192
                    L_0x03cf:
                        r32 = r0
                        r35 = r2
                        r34 = r4
                        r40 = r5
                        r37 = r6
                        r46 = r8
                        r47 = r9
                        r52 = r10
                        r3.endReplaceableGroup()
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
                        r85.endReplaceableGroup()
                        r85.endNode()
                        r85.endReplaceableGroup()
                        r85.endReplaceableGroup()
                        boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                        if (r0 == 0) goto L_0x0402
                        androidx.compose.runtime.ComposerKt.traceEventEnd()
                    L_0x0402:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt$WeekDays$1.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

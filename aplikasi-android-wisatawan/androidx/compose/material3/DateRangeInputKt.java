package androidx.compose.material3;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0001¢\u0006\u0002\u0010\r\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"TextFieldSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "DateRangeInputContent", "", "stateData", "Landroidx/compose/material3/StateData;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "dateValidator", "Lkotlin/Function1;", "", "", "(Landroidx/compose/material3/StateData;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangeInput.kt */
public final class DateRangeInputKt {
    private static final float TextFieldSpacing = Dp.m5844constructorimpl((float) 8);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: androidx.compose.material3.DateInputFormat} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v84, resolved type: androidx.compose.material3.DateInputFormat} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x03e3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x03f0  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0445  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DateRangeInputContent(androidx.compose.material3.StateData r51, androidx.compose.material3.DatePickerFormatter r52, kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.Boolean> r53, androidx.compose.runtime.Composer r54, int r55) {
        /*
            r12 = r51
            r13 = r52
            r14 = r53
            r15 = r55
            java.lang.String r0 = "stateData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "dateFormatter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "dateValidator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -1163802470(0xffffffffbaa1c89a, float:-0.0012343109)
            r1 = r54
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DateRangeInputContent)P(2)37@1398L15,38@1440L97,41@1565L45,42@1645L44,43@1723L45,44@1797L50,45@1877L482,57@2364L1939:DateRangeInput.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r55
            r2 = r15 & 14
            if (r2 != 0) goto L_0x0036
            boolean r2 = r11.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0034
            r2 = 4
            goto L_0x0035
        L_0x0034:
            r2 = 2
        L_0x0035:
            r1 = r1 | r2
        L_0x0036:
            r2 = r15 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0046
            boolean r2 = r11.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0043
            r2 = 32
            goto L_0x0045
        L_0x0043:
            r2 = 16
        L_0x0045:
            r1 = r1 | r2
        L_0x0046:
            r2 = r15 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0056
            boolean r2 = r11.changedInstance(r14)
            if (r2 == 0) goto L_0x0053
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0055
        L_0x0053:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0055:
            r1 = r1 | r2
        L_0x0056:
            r10 = r1
            r1 = r10 & 731(0x2db, float:1.024E-42)
            r2 = 146(0x92, float:2.05E-43)
            if (r1 != r2) goto L_0x006d
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x0064
            goto L_0x006d
        L_0x0064:
            r11.skipToGroupEnd()
            r49 = r10
            r50 = r11
            goto L_0x0448
        L_0x006d:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0079
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.DateRangeInputContent (DateRangeInput.kt:31)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r1, r2)
        L_0x0079:
            r0 = 0
            java.util.Locale r9 = androidx.compose.material3.CalendarModel_androidKt.defaultLocale(r11, r0)
            r0 = 8
            r1 = 0
            r8 = 1157296644(0x44faf204, float:2007.563)
            r11.startReplaceableGroup(r8)
            java.lang.String r7 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r7)
            boolean r2 = r11.changed((java.lang.Object) r9)
            r3 = r11
            r4 = 0
            java.lang.Object r5 = r3.rememberedValue()
            r6 = 0
            if (r2 != 0) goto L_0x00a6
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r16.getEmpty()
            if (r5 != r8) goto L_0x00a2
            goto L_0x00a6
        L_0x00a2:
            r16 = r0
            r0 = r5
            goto L_0x00b6
        L_0x00a6:
            r8 = 0
            r16 = r0
            androidx.compose.material3.CalendarModel r0 = r51.getCalendarModel()
            androidx.compose.material3.DateInputFormat r0 = r0.getDateInputFormat(r9)
            r3.updateRememberedValue(r0)
        L_0x00b6:
            r11.endReplaceableGroup()
            r8 = r0
            androidx.compose.material3.DateInputFormat r8 = (androidx.compose.material3.DateInputFormat) r8
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m1999getDateInputInvalidForPatternadMyvUU()
            r6 = 6
            java.lang.String r16 = androidx.compose.material3.Strings_androidKt.m2053getStringNWtq28(r0, r11, r6)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m2001getDateInputInvalidYearRangeadMyvUU()
            java.lang.String r17 = androidx.compose.material3.Strings_androidKt.m2053getStringNWtq28(r0, r11, r6)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m2000getDateInputInvalidNotAllowedadMyvUU()
            java.lang.String r18 = androidx.compose.material3.Strings_androidKt.m2053getStringNWtq28(r0, r11, r6)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m2020getDateRangeInputInvalidRangeInputadMyvUU()
            java.lang.String r19 = androidx.compose.material3.Strings_androidKt.m2053getStringNWtq28(r0, r11, r6)
            r0 = r10 & 112(0x70, float:1.57E-43)
            r20 = r0
            r21 = 0
            r0 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            boolean r0 = r11.changed((java.lang.Object) r8)
            boolean r1 = r11.changed((java.lang.Object) r13)
            r0 = r0 | r1
            r5 = r11
            r22 = r0
            r23 = 0
            java.lang.Object r4 = r5.rememberedValue()
            r24 = 0
            if (r22 != 0) goto L_0x0122
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r4 != r0) goto L_0x0117
            goto L_0x0122
        L_0x0117:
            r27 = r4
            r13 = r6
            r29 = r7
            r30 = r8
            r28 = r9
            r9 = r5
            goto L_0x0152
        L_0x0122:
            r25 = 0
            androidx.compose.material3.DateInputValidator r26 = new androidx.compose.material3.DateInputValidator
            r0 = r26
            r1 = r51
            r2 = r8
            r3 = r52
            r27 = r4
            r4 = r53
            r28 = r9
            r9 = r5
            r5 = r16
            r13 = r6
            r6 = r17
            r29 = r7
            r7 = r18
            r30 = r8
            r8 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r4 = r26
            r9.updateRememberedValue(r4)
        L_0x0152:
            r11.endReplaceableGroup()
            r20 = r4
            androidx.compose.material3.DateInputValidator r20 = (androidx.compose.material3.DateInputValidator) r20
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.layout.PaddingValues r1 = androidx.compose.material3.DateInputKt.getInputTextFieldPadding()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.padding(r0, r1)
            androidx.compose.foundation.layout.Arrangement r1 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            float r2 = TextFieldSpacing
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r1 = r1.m422spacedBy0680j_4(r2)
            androidx.compose.foundation.layout.Arrangement$Horizontal r1 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r1
            r9 = r1
            r21 = r0
            r0 = 54
            r22 = r0
            r23 = 0
            r0 = 693286680(0x2952b718, float:4.6788176E-14)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r8 = r0.getTop()
            int r0 = r22 >> 3
            r0 = r0 & 14
            int r1 = r22 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r9, r8, r11, r0)
            int r0 = r22 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r24 = r0
            r25 = 0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r4)
            java.lang.Object r5 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r6 = r5
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r4)
            java.lang.Object r5 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r4)
            java.lang.Object r3 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r4 = r3
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r0 = r0.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r21)
            int r2 = r24 << 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r13
            r3 = r1
            r1 = r0
            r26 = r2
            r27 = 0
            androidx.compose.runtime.Applier r0 = r11.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x020e
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x020e:
            r11.startReusableNode()
            boolean r0 = r11.getInserting()
            if (r0 == 0) goto L_0x021b
            r11.createNode(r1)
            goto L_0x021e
        L_0x021b:
            r11.useNode()
        L_0x021e:
            r11.disableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m2865constructorimpl(r11)
            r2 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r32 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r32.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r7, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r6, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r5, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r4, r13)
            r11.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r11)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r0)
            int r2 = r26 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3.invoke(r0, r11, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r0)
            int r0 = r26 >> 9
            r13 = r0 & 14
            r0 = r11
            r2 = r0
            r32 = 0
            r0 = -326682283(0xffffffffec873955, float:-1.3078058E27)
            r33 = r1
            java.lang.String r1 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r1 = r22 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r34 = 6
            r35 = r1 | 6
            r36 = r0
            androidx.compose.foundation.layout.RowScope r36 = (androidx.compose.foundation.layout.RowScope) r36
            r1 = r2
            r34 = 0
            r0 = 1849028810(0x6e35f0ca, float:1.4076971E28)
            r42 = r2
            java.lang.String r2 = "C62@2625L56,74@3193L52,63@2690L763,80@3481L54,92@4041L50,81@3544L753:DateRangeInput.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r2)
            java.lang.String r0 = r30.getPatternWithDelimiters()
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toUpperCase(r2)
            java.lang.String r2 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r2 = r0
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m2026getDateRangePickerStartHeadlineadMyvUU()
            r43 = r3
            r3 = 6
            java.lang.String r0 = androidx.compose.material3.Strings_androidKt.m2053getStringNWtq28(r0, r1, r3)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r37 = r3
            androidx.compose.ui.Modifier r37 = (androidx.compose.ui.Modifier) r37
            r40 = 2
            r41 = 0
            r38 = 1056964608(0x3f000000, float:0.5)
            r39 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.RowScope.weight$default(r36, r37, r38, r39, r40, r41)
            r37 = r4
            androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$1 r4 = new androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$1
            r4.<init>(r0, r2)
            r38 = r0
            r0 = 576559191(0x225d9857, float:3.0031733E-18)
            r39 = r13
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r13, r4)
            r4 = r0
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$2 r0 = new androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$2
            r0.<init>(r2)
            r40 = r2
            r2 = 1726391478(0x66e6a4b6, float:5.4459134E23)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r2, r13, r0)
            r2 = r0
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.runtime.MutableState r0 = r51.getSelectedStartDate()
            java.lang.Object r0 = r0.getValue()
            r41 = r0
            androidx.compose.material3.CalendarDate r41 = (androidx.compose.material3.CalendarDate) r41
            r0 = r10 & 14
            r44 = 0
            r13 = 1157296644(0x44faf204, float:2007.563)
            r1.startReplaceableGroup(r13)
            r13 = r29
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r13)
            boolean r29 = r1.changed((java.lang.Object) r12)
            r45 = r1
            r46 = 0
            r47 = r0
            java.lang.Object r0 = r45.rememberedValue()
            r48 = 0
            if (r29 != 0) goto L_0x032a
            androidx.compose.runtime.Composer$Companion r49 = androidx.compose.runtime.Composer.Companion
            r50 = r5
            java.lang.Object r5 = r49.getEmpty()
            if (r0 != r5) goto L_0x0325
            goto L_0x032c
        L_0x0325:
            r49 = r0
            r5 = r45
            goto L_0x033d
        L_0x032a:
            r50 = r5
        L_0x032c:
            r5 = 0
            r49 = r0
            androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$3$1 r0 = new androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$3$1
            r0.<init>(r12)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r5 = r45
            r5.updateRememberedValue(r0)
        L_0x033d:
            r1.endReplaceableGroup()
            r5 = r0
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.material3.InputIdentifier$Companion r0 = androidx.compose.material3.InputIdentifier.Companion
            int r29 = r0.m1825getStartDateInputJ2x2o4M()
            int r0 = r10 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r44 = 1075315120(0x401801b0, float:2.375103)
            r45 = r0 | r44
            r0 = r3
            r3 = r1
            r1 = r4
            r4 = r40
            r40 = r42
            r42 = r43
            r43 = r3
            r3 = r51
            r14 = r4
            r4 = r41
            r41 = r50
            r46 = r6
            r6 = r29
            r29 = r7
            r7 = r20
            r47 = r8
            r8 = r30
            r48 = r9
            r9 = r28
            r49 = r10
            r10 = r43
            r50 = r11
            r11 = r45
            androidx.compose.material3.DateInputKt.m1697DateInputTextFieldzm97o8M(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m2023getDateRangePickerEndHeadlineadMyvUU()
            r11 = r43
            r1 = 6
            java.lang.String r10 = androidx.compose.material3.Strings_androidKt.m2053getStringNWtq28(r0, r11, r1)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r2 = r0
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r5 = 2
            r6 = 0
            r3 = 1056964608(0x3f000000, float:0.5)
            r4 = 0
            r1 = r36
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.RowScope.weight$default(r1, r2, r3, r4, r5, r6)
            androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$4 r1 = new androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$4
            r1.<init>(r10, r14)
            r2 = -663502784(0xffffffffd873c040, float:-1.07202813E15)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r2, r3, r1)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$5 r2 = new androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$5
            r2.<init>(r14)
            r4 = 518729951(0x1eeb30df, float:2.4901805E-20)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r4, r3, r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.runtime.MutableState r3 = r51.getSelectedEndDate()
            java.lang.Object r3 = r3.getValue()
            r4 = r3
            androidx.compose.material3.CalendarDate r4 = (androidx.compose.material3.CalendarDate) r4
            r3 = r49 & 14
            r5 = 0
            r6 = 1157296644(0x44faf204, float:2007.563)
            r11.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r13)
            boolean r6 = r11.changed((java.lang.Object) r12)
            r7 = r11
            r8 = 0
            java.lang.Object r9 = r7.rememberedValue()
            r13 = 0
            if (r6 != 0) goto L_0x03f0
            androidx.compose.runtime.Composer$Companion r31 = androidx.compose.runtime.Composer.Companion
            r54 = r3
            java.lang.Object r3 = r31.getEmpty()
            if (r9 != r3) goto L_0x03ee
            goto L_0x03f2
        L_0x03ee:
            r3 = r9
            goto L_0x0401
        L_0x03f0:
            r54 = r3
        L_0x03f2:
            r3 = 0
            r31 = r3
            androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$6$1 r3 = new androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$6$1
            r3.<init>(r12)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r7.updateRememberedValue(r3)
        L_0x0401:
            r11.endReplaceableGroup()
            r5 = r3
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.material3.InputIdentifier$Companion r3 = androidx.compose.material3.InputIdentifier.Companion
            int r6 = r3.m1823getEndDateInputJ2x2o4M()
            int r3 = r49 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r13 = r3 | r44
            r3 = r51
            r7 = r20
            r8 = r30
            r9 = r28
            r31 = r10
            r10 = r11
            r43 = r11
            r11 = r13
            androidx.compose.material3.DateInputKt.m1697DateInputTextFieldzm97o8M(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r43)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r40)
            r50.endReplaceableGroup()
            r50.endNode()
            r50.endReplaceableGroup()
            r50.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0448
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0448:
            androidx.compose.runtime.ScopeUpdateScope r0 = r50.endRestartGroup()
            if (r0 != 0) goto L_0x0453
            r2 = r52
            r3 = r53
            goto L_0x0461
        L_0x0453:
            androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2 r1 = new androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2
            r2 = r52
            r3 = r53
            r1.<init>(r12, r2, r3, r15)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r0.updateScope(r1)
        L_0x0461:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangeInputKt.DateRangeInputContent(androidx.compose.material3.StateData, androidx.compose.material3.DatePickerFormatter, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }
}

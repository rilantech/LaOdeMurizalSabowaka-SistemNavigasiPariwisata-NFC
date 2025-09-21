package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$Month$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ Function1<Long, Boolean> $dateValidator;
    final /* synthetic */ Locale $defaultLocale;
    final /* synthetic */ MutableState<CalendarDate> $endSelection;
    final /* synthetic */ CalendarMonth $month;
    final /* synthetic */ Function1<Long, Unit> $onDateSelected;
    final /* synthetic */ Modifier $rangeSelectionDrawModifier;
    final /* synthetic */ boolean $rangeSelectionEnabled;
    final /* synthetic */ MutableState<CalendarDate> $startSelection;
    final /* synthetic */ StateData $stateData;
    final /* synthetic */ CalendarDate $today;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$Month$1(Modifier modifier, CalendarMonth calendarMonth, CalendarDate calendarDate, MutableState<CalendarDate> mutableState, MutableState<CalendarDate> mutableState2, boolean z, int i, DatePickerFormatter datePickerFormatter, Locale locale, Function1<? super Long, Unit> function1, DatePickerColors datePickerColors, StateData stateData, Function1<? super Long, Boolean> function12) {
        super(2);
        this.$rangeSelectionDrawModifier = modifier;
        this.$month = calendarMonth;
        this.$today = calendarDate;
        this.$startSelection = mutableState;
        this.$endSelection = mutableState2;
        this.$rangeSelectionEnabled = z;
        this.$$dirty = i;
        this.$dateFormatter = datePickerFormatter;
        this.$defaultLocale = locale;
        this.$onDateSelected = function1;
        this.$colors = datePickerColors;
        this.$stateData = stateData;
        this.$dateValidator = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x04e2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x04ef  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x052a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x053b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0573  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x058d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r97, int r98) {
        /*
            r96 = this;
            r0 = r96
            r1 = r97
            r2 = r98
            java.lang.String r3 = "C1446@58969L4887:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 11
            r4 = 2
            if (r3 != r4) goto L_0x001c
            boolean r3 = r97.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r97.skipToGroupEnd()
            goto L_0x06d4
        L_0x001c:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002b
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.Month.<anonymous> (DatePicker.kt:1444)"
            r5 = -1776200645(0xffffffff9621543b, float:-1.3032055E-25)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
        L_0x002b:
            r3 = 0
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            float r5 = androidx.compose.material3.DatePickerKt.getRecommendedSizeForAccessibility()
            r6 = 6
            r7 = 0
            float r8 = (float) r6
            float r8 = r8 * r5
            float r5 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r8)
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.m601requiredHeight3ABfNKs(r4, r5)
            androidx.compose.ui.Modifier r5 = r0.$rangeSelectionDrawModifier
            androidx.compose.ui.Modifier r4 = r4.then(r5)
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r5 = r5.getSpaceEvenly()
            androidx.compose.foundation.layout.Arrangement$Vertical r5 = (androidx.compose.foundation.layout.Arrangement.Vertical) r5
            androidx.compose.material3.CalendarMonth r6 = r0.$month
            androidx.compose.material3.CalendarDate r7 = r0.$today
            androidx.compose.runtime.MutableState<androidx.compose.material3.CalendarDate> r8 = r0.$startSelection
            androidx.compose.runtime.MutableState<androidx.compose.material3.CalendarDate> r9 = r0.$endSelection
            boolean r15 = r0.$rangeSelectionEnabled
            int r14 = r0.$$dirty
            androidx.compose.material3.DatePickerFormatter r13 = r0.$dateFormatter
            java.util.Locale r12 = r0.$defaultLocale
            kotlin.jvm.functions.Function1<java.lang.Long, kotlin.Unit> r10 = r0.$onDateSelected
            androidx.compose.material3.DatePickerColors r11 = r0.$colors
            androidx.compose.material3.StateData r2 = r0.$stateData
            r16 = r3
            kotlin.jvm.functions.Function1<java.lang.Long, java.lang.Boolean> r3 = r0.$dateValidator
            r17 = 48
            r28 = r17
            r29 = 0
            r0 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r0 = r0.getStart()
            int r17 = r28 >> 3
            r17 = r17 & 14
            int r18 = r28 >> 3
            r18 = r18 & 112(0x70, float:1.57E-43)
            r19 = r10
            r10 = r17 | r18
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r5, r0, r1, r10)
            int r17 = r28 << 3
            r17 = r17 & 112(0x70, float:1.57E-43)
            r30 = r17
            r31 = 0
            r32 = r0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r33 = r5
            r5 = r17
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r17 = 6
            r18 = 0
            r34 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            r20 = r13
            java.lang.String r13 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r3, r13)
            java.lang.Object r21 = r1.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r97)
            r5 = r21
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r3 = r17
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r17 = 6
            r18 = 0
            r21 = r11
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r11, r13)
            java.lang.Object r11 = r1.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r97)
            r3 = r11
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r17 = 6
            r18 = 0
            r22 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r12, r13)
            java.lang.Object r12 = r1.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r97)
            androidx.compose.ui.platform.ViewConfiguration r12 = (androidx.compose.ui.platform.ViewConfiguration) r12
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r17 = androidx.compose.ui.layout.LayoutKt.materializerOf(r4)
            r36 = r4
            int r4 = r30 << 9
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r37 = r2
            r2 = 6
            r4 = r4 | r2
            r38 = r17
            r39 = 0
            androidx.compose.runtime.Applier r2 = r97.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x0126
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0126:
            r97.startReusableNode()
            boolean r2 = r97.getInserting()
            if (r2 == 0) goto L_0x0133
            r1.createNode(r11)
            goto L_0x0136
        L_0x0133:
            r97.useNode()
        L_0x0136:
            r97.disableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m2865constructorimpl(r97)
            r17 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            r23 = r11
            kotlin.jvm.functions.Function2 r11 = r18.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r2, r10, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r2, r5, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r2, r3, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r2, r12, r11)
            r97.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r97)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r2)
            int r11 = r4 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r40 = r3
            r3 = r38
            r3.invoke(r2, r1, r11)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r2)
            int r11 = r4 >> 9
            r38 = r11 & 14
            r11 = r97
            r41 = 0
            r2 = 276693704(0x107e02c8, float:5.009481E-29)
            java.lang.String r1 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r2, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r1 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            int r2 = r28 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r17 = 6
            r2 = r2 | 6
            androidx.compose.foundation.layout.ColumnScope r1 = (androidx.compose.foundation.layout.ColumnScope) r1
            r43 = r11
            r44 = 0
            r45 = r1
            r1 = -1111255490(0xffffffffbdc3963e, float:-0.09550141)
            r46 = r2
            java.lang.String r2 = "C:DatePicker.kt#uh7d8r"
            r47 = r3
            r3 = r43
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r1, r2)
            r1 = -713647587(0xffffffffd5769a1d, float:-1.69463607E13)
            r3.startReplaceableGroup(r1)
            java.lang.String r1 = "*1453@59267L4565"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r1)
            r1 = 0
        L_0x01c2:
            r48 = r4
            r4 = 6
            if (r1 >= r4) goto L_0x06a5
            r4 = r1
            r49 = 0
            androidx.compose.ui.Modifier$Companion r17 = androidx.compose.ui.Modifier.Companion
            r50 = r4
            r4 = r17
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r51 = r5
            r5 = 0
            r17 = r10
            r10 = 0
            r52 = r1
            r1 = 1
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r4, r5, r1, r10)
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r5 = r5.getSpaceEvenly()
            androidx.compose.foundation.layout.Arrangement$Horizontal r5 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r5
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r10 = r10.getCenterVertically()
            r18 = 438(0x1b6, float:6.14E-43)
            r53 = r18
            r54 = 0
            r1 = 693286680(0x2952b718, float:4.6788176E-14)
            r3.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r1)
            int r1 = r53 >> 3
            r1 = r1 & 14
            int r18 = r53 >> 3
            r18 = r18 & 112(0x70, float:1.57E-43)
            r1 = r1 | r18
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r5, r10, r3, r1)
            int r18 = r53 << 3
            r18 = r18 & 112(0x70, float:1.57E-43)
            r55 = r18
            r56 = 0
            r57 = r5
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r5 = r18
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r18 = 6
            r24 = 0
            r58 = r0
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r13)
            java.lang.Object r0 = r3.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r18 = 6
            r24 = 0
            r25 = r10
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r10, r13)
            java.lang.Object r10 = r3.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r5 = r10
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r18 = 6
            r24 = 0
            r26 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r12, r13)
            java.lang.Object r27 = r3.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r10 = r27
            androidx.compose.ui.platform.ViewConfiguration r10 = (androidx.compose.ui.platform.ViewConfiguration) r10
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r18 = r18.getConstructor()
            kotlin.jvm.functions.Function3 r24 = androidx.compose.ui.layout.LayoutKt.materializerOf(r4)
            int r12 = r55 << 9
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r27 = 6
            r12 = r12 | 6
            r59 = r18
            r60 = r12
            r12 = r24
            r61 = 0
            r62 = r4
            androidx.compose.runtime.Applier r4 = r3.getApplier()
            boolean r4 = r4 instanceof androidx.compose.runtime.Applier
            if (r4 != 0) goto L_0x029c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x029c:
            r3.startReusableNode()
            boolean r4 = r3.getInserting()
            if (r4 == 0) goto L_0x02ab
            r4 = r59
            r3.createNode(r4)
            goto L_0x02b0
        L_0x02ab:
            r4 = r59
            r3.useNode()
        L_0x02b0:
            r3.disableReusing()
            r59 = r4
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m2865constructorimpl(r3)
            r18 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r24 = androidx.compose.ui.node.ComposeUiNode.Companion
            r27 = r11
            kotlin.jvm.functions.Function2 r11 = r24.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r4, r1, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r4, r0, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r4, r5, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r4, r10, r11)
            r3.enableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r4)
            int r11 = r60 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r12.invoke(r4, r3, r11)
            r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r3.startReplaceableGroup(r4)
            int r11 = r60 >> 9
            r42 = r11 & 14
            r11 = r3
            r63 = 0
            r4 = -326682283(0xffffffffec873955, float:-1.3078058E27)
            r64 = r0
            java.lang.String r0 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r0)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r4 = r53 >> 6
            r4 = r4 & 112(0x70, float:1.57E-43)
            r18 = 6
            r4 = r4 | 6
            androidx.compose.foundation.layout.RowScope r0 = (androidx.compose.foundation.layout.RowScope) r0
            r65 = r11
            r66 = 0
            r67 = r0
            r0 = -1481813225(0xffffffffa7ad5317, float:-4.810723E-15)
            r68 = r1
            r1 = r65
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r2)
            r0 = -1111255211(0xffffffffbdc39755, float:-0.09550349)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            r65 = r2
            r0 = r16
            r2 = 0
        L_0x033b:
            r69 = r4
            r4 = 7
            if (r2 >= r4) goto L_0x0644
            r4 = r2
            r70 = 0
            r71 = r4
            int r4 = r6.getDaysFromStartOfWeekToFirstOfMonth()
            if (r0 < r4) goto L_0x05bb
            int r4 = r6.getDaysFromStartOfWeekToFirstOfMonth()
            int r16 = r6.getNumberOfDays()
            int r4 = r4 + r16
            if (r0 < r4) goto L_0x038c
            r86 = r2
            r82 = r3
            r75 = r5
            r74 = r6
            r80 = r7
            r81 = r8
            r87 = r9
            r85 = r10
            r77 = r11
            r88 = r12
            r91 = r13
            r92 = r14
            r94 = r15
            r83 = r17
            r95 = r19
            r90 = r20
            r72 = r21
            r93 = r22
            r73 = r23
            r84 = r25
            r35 = r26
            r76 = r27
            r3 = r34
            r9 = 1
            r89 = 2023513938(0x789c5f52, float:2.5372864E34)
            goto L_0x05ed
        L_0x038c:
            r4 = 382637385(0x16ce9549, float:3.3375307E-25)
            r1.startReplaceableGroup(r4)
            java.lang.String r4 = "1478@60757L644,1489@61458L366,1504@62314L32,1509@62702L129,1501@62133L1597"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            int r4 = r6.getDaysFromStartOfWeekToFirstOfMonth()
            int r4 = r0 - r4
            long r72 = r6.getStartUtcTimeMillis()
            r75 = r5
            r74 = r6
            long r5 = (long) r4
            r76 = 86400000(0x5265c00, double:4.2687272E-316)
            long r5 = r5 * r76
            long r5 = r72 + r5
            long r72 = r7.getUtcTimeMillis()
            int r16 = (r5 > r72 ? 1 : (r5 == r72 ? 0 : -1))
            if (r16 != 0) goto L_0x03b8
            r16 = 1
            goto L_0x03ba
        L_0x03b8:
            r16 = 0
        L_0x03ba:
            r77 = r11
            r72 = r21
            r73 = r23
            r76 = r27
            r11 = r16
            java.lang.Object r16 = r8.getValue()
            androidx.compose.material3.CalendarDate r16 = (androidx.compose.material3.CalendarDate) r16
            if (r16 == 0) goto L_0x03d7
            long r23 = r16.getUtcTimeMillis()
            int r16 = (r5 > r23 ? 1 : (r5 == r23 ? 0 : -1))
            if (r16 != 0) goto L_0x03d7
            r16 = 1
            goto L_0x03d9
        L_0x03d7:
            r16 = 0
        L_0x03d9:
            r78 = r16
            java.lang.Object r16 = r9.getValue()
            androidx.compose.material3.CalendarDate r16 = (androidx.compose.material3.CalendarDate) r16
            if (r16 == 0) goto L_0x03ee
            long r23 = r16.getUtcTimeMillis()
            int r16 = (r5 > r23 ? 1 : (r5 == r23 ? 0 : -1))
            if (r16 != 0) goto L_0x03ee
            r16 = 1
            goto L_0x03f0
        L_0x03ee:
            r16 = 0
        L_0x03f0:
            r79 = r16
            java.lang.Boolean r16 = java.lang.Boolean.valueOf(r15)
            java.lang.Long r18 = java.lang.Long.valueOf(r5)
            int r21 = r14 >> 12
            r21 = r21 & 14
            r23 = r16
            r16 = r18
            r18 = r21
            r24 = 0
            r80 = r7
            r7 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r1.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r7)
            r81 = r8
            r8 = r23
            boolean r23 = r1.changed((java.lang.Object) r8)
            r82 = r8
            r8 = r16
            boolean r16 = r1.changed((java.lang.Object) r8)
            r16 = r23 | r16
            r23 = r1
            r83 = 0
            r84 = r8
            java.lang.Object r8 = r23.rememberedValue()
            r85 = 0
            if (r16 != 0) goto L_0x0444
            androidx.compose.runtime.Composer$Companion r86 = androidx.compose.runtime.Composer.Companion
            r87 = r9
            java.lang.Object r9 = r86.getEmpty()
            if (r8 != r9) goto L_0x043f
            goto L_0x0446
        L_0x043f:
            r86 = r8
            r9 = r23
            goto L_0x045f
        L_0x0444:
            r87 = r9
        L_0x0446:
            r9 = 0
            r86 = r8
            androidx.compose.material3.DatePickerKt$Month$1$1$1$1$1$inRange$1$1 r8 = new androidx.compose.material3.DatePickerKt$Month$1$1$1$1$1$inRange$1$1
            r88 = r9
            r9 = r37
            r8.<init>(r9, r15, r5)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            androidx.compose.runtime.State r8 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r8)
            r9 = r23
            r9.updateRememberedValue(r8)
        L_0x045f:
            r1.endReplaceableGroup()
            androidx.compose.runtime.State r8 = (androidx.compose.runtime.State) r8
            java.lang.Object r9 = r8.getValue()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            r82 = r3
            r85 = r10
            r83 = r17
            r3 = r19
            r84 = r25
            r10 = r15
            r86 = r2
            r88 = r12
            r2 = r22
            r35 = r26
            r89 = 2023513938(0x789c5f52, float:2.5372864E34)
            r12 = r78
            r91 = r13
            r90 = r20
            r13 = r79
            r92 = r14
            r14 = r9
            r9 = r15
            r15 = r1
            r16 = r21
            java.lang.String r10 = androidx.compose.material3.DatePickerKt.dayContentDescription(r10, r11, r12, r13, r14, r15, r16)
            java.lang.String r12 = r90.getSelectedDateDescriptionSkeleton$material3_release()
            java.lang.String r12 = androidx.compose.material3.CalendarModel_androidKt.formatWithSkeleton(r5, r12, r2)
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            r16 = r13
            androidx.compose.ui.Modifier r16 = (androidx.compose.ui.Modifier) r16
            if (r78 != 0) goto L_0x04b5
            if (r79 == 0) goto L_0x04b2
            goto L_0x04b5
        L_0x04b2:
            r17 = 0
            goto L_0x04b7
        L_0x04b5:
            r17 = 1
        L_0x04b7:
            java.lang.Long r13 = java.lang.Long.valueOf(r5)
            int r14 = r92 >> 3
            r14 = r14 & 14
            r15 = 0
            r93 = r2
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r1.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r7)
            boolean r2 = r1.changed((java.lang.Object) r3)
            boolean r7 = r1.changed((java.lang.Object) r13)
            r2 = r2 | r7
            r7 = r1
            r18 = 0
            r94 = r9
            java.lang.Object r9 = r7.rememberedValue()
            r19 = 0
            if (r2 != 0) goto L_0x04ef
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r2
            java.lang.Object r2 = r20.getEmpty()
            if (r9 != r2) goto L_0x04ed
            goto L_0x04f1
        L_0x04ed:
            r2 = r9
            goto L_0x0500
        L_0x04ef:
            r21 = r2
        L_0x04f1:
            r2 = 0
            r20 = r2
            androidx.compose.material3.DatePickerKt$Month$1$1$1$1$1$1$1 r2 = new androidx.compose.material3.DatePickerKt$Month$1$1$1$1$1$1$1
            r2.<init>(r3, r5)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r7.updateRememberedValue(r2)
        L_0x0500:
            r1.endReplaceableGroup()
            r18 = r2
            kotlin.jvm.functions.Function0 r18 = (kotlin.jvm.functions.Function0) r18
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            r7 = 0
            r9 = r7
            r13 = 0
            r14 = 1157296644(0x44faf204, float:2007.563)
            r1.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            boolean r14 = r1.changed((java.lang.Object) r2)
            r15 = r1
            r19 = 0
            java.lang.Object r7 = r15.rememberedValue()
            r20 = 0
            if (r14 != 0) goto L_0x053b
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r22 = r2
            java.lang.Object r2 = r21.getEmpty()
            if (r7 != r2) goto L_0x0535
            goto L_0x053d
        L_0x0535:
            r95 = r3
            r2 = r7
            r3 = r34
            goto L_0x055b
        L_0x053b:
            r22 = r2
        L_0x053d:
            r2 = 0
            r21 = r2
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            r95 = r3
            r3 = r34
            java.lang.Object r2 = r3.invoke(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r15.updateRememberedValue(r2)
        L_0x055b:
            r1.endReplaceableGroup()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r20 = r2.booleanValue()
            java.lang.Object r2 = r8.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r22 = r2.booleanValue()
            if (r10 == 0) goto L_0x058d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r10)
            java.lang.String r7 = ", "
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.StringBuilder r2 = r2.append(r12)
            java.lang.String r2 = r2.toString()
            r23 = r2
            goto L_0x058f
        L_0x058d:
            r23 = r12
        L_0x058f:
            androidx.compose.material3.DatePickerKt$Month$1$1$1$1$1$3 r2 = new androidx.compose.material3.DatePickerKt$Month$1$1$1$1$1$3
            r2.<init>(r4)
            r7 = 1633583293(0x615e80bd, float:2.5652836E20)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r7, r9, r2)
            r25 = r2
            kotlin.jvm.functions.Function2 r25 = (kotlin.jvm.functions.Function2) r25
            r2 = 234881024(0xe000000, float:1.5777218E-30)
            int r7 = r92 << 3
            r2 = r2 & r7
            r7 = 805306374(0x30000006, float:4.656616E-10)
            r27 = r2 | r7
            r19 = r78
            r21 = r11
            r24 = r72
            r26 = r1
            androidx.compose.material3.DatePickerKt.Day(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r1.endReplaceableGroup()
            r4 = 6
            goto L_0x060f
        L_0x05bb:
            r86 = r2
            r82 = r3
            r75 = r5
            r74 = r6
            r80 = r7
            r81 = r8
            r87 = r9
            r85 = r10
            r77 = r11
            r88 = r12
            r91 = r13
            r92 = r14
            r94 = r15
            r83 = r17
            r95 = r19
            r90 = r20
            r72 = r21
            r93 = r22
            r73 = r23
            r84 = r25
            r35 = r26
            r76 = r27
            r3 = r34
            r9 = 1
            r89 = 2023513938(0x789c5f52, float:2.5372864E34)
        L_0x05ed:
            r2 = 382636990(0x16ce93be, float:3.3374333E-25)
            r1.startReplaceableGroup(r2)
            java.lang.String r2 = "1464@59838L291"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r4 = androidx.compose.material3.DatePickerKt.getRecommendedSizeForAccessibility()
            float r5 = androidx.compose.material3.DatePickerKt.getRecommendedSizeForAccessibility()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m606requiredSizeVpY3zN4(r2, r4, r5)
            r4 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r2, r1, r4)
            r1.endReplaceableGroup()
        L_0x060f:
            int r0 = r0 + 1
            int r2 = r86 + 1
            r34 = r3
            r26 = r35
            r4 = r69
            r21 = r72
            r23 = r73
            r6 = r74
            r5 = r75
            r27 = r76
            r11 = r77
            r7 = r80
            r8 = r81
            r3 = r82
            r17 = r83
            r25 = r84
            r10 = r85
            r9 = r87
            r12 = r88
            r20 = r90
            r13 = r91
            r14 = r92
            r22 = r93
            r15 = r94
            r19 = r95
            goto L_0x033b
        L_0x0644:
            r82 = r3
            r75 = r5
            r74 = r6
            r80 = r7
            r81 = r8
            r87 = r9
            r85 = r10
            r77 = r11
            r88 = r12
            r91 = r13
            r92 = r14
            r94 = r15
            r83 = r17
            r95 = r19
            r90 = r20
            r72 = r21
            r93 = r22
            r73 = r23
            r84 = r25
            r35 = r26
            r76 = r27
            r3 = r34
            r4 = 6
            r89 = 2023513938(0x789c5f52, float:2.5372864E34)
            r1.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r77)
            r82.endReplaceableGroup()
            r82.endNode()
            r82.endReplaceableGroup()
            r82.endReplaceableGroup()
            int r1 = r52 + 1
            r16 = r0
            r12 = r35
            r4 = r48
            r5 = r51
            r0 = r58
            r2 = r65
            r11 = r76
            r3 = r82
            r10 = r83
            goto L_0x01c2
        L_0x06a5:
            r82 = r3
            r51 = r5
            r83 = r10
            r76 = r11
            r35 = r12
            r73 = r23
            r82.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r82)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r76)
            r97.endReplaceableGroup()
            r97.endNode()
            r97.endReplaceableGroup()
            r97.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x06d4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x06d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt$Month$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

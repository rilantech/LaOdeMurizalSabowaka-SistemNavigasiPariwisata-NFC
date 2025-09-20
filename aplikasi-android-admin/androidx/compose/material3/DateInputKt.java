package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0001¢\u0006\u0002\u0010\u0011\u001a\u0001\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0014\u0010\u001b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"InputTextFieldPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getInputTextFieldPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "InputTextNonErroneousBottomPadding", "Landroidx/compose/ui/unit/Dp;", "F", "DateInputContent", "", "stateData", "Landroidx/compose/material3/StateData;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "dateValidator", "Lkotlin/Function1;", "", "", "(Landroidx/compose/material3/StateData;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "DateInputTextField", "modifier", "Landroidx/compose/ui/Modifier;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "initialDate", "Landroidx/compose/material3/CalendarDate;", "onDateChanged", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "dateInputValidator", "Landroidx/compose/material3/DateInputValidator;", "dateInputFormat", "Landroidx/compose/material3/DateInputFormat;", "locale", "Ljava/util/Locale;", "DateInputTextField-zm97o8M", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/StateData;Landroidx/compose/material3/CalendarDate;Lkotlin/jvm/functions/Function1;ILandroidx/compose/material3/DateInputValidator;Landroidx/compose/material3/DateInputFormat;Ljava/util/Locale;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
public final class DateInputKt {
    private static final PaddingValues InputTextFieldPadding = PaddingKt.m2245PaddingValuesa9UjIt4$default(Dp.m7554constructorimpl((float) 24), Dp.m7554constructorimpl((float) 10), Dp.m7554constructorimpl((float) 24), 0.0f, 8, (Object) null);
    private static final float InputTextNonErroneousBottomPadding = Dp.m7554constructorimpl((float) 16);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: androidx.compose.material3.DateInputFormat} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: androidx.compose.material3.DateInputFormat} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x021a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DateInputContent(androidx.compose.material3.StateData r31, androidx.compose.material3.DatePickerFormatter r32, kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.Boolean> r33, androidx.compose.runtime.Composer r34, int r35) {
        /*
            r12 = r31
            r13 = r32
            r14 = r33
            r15 = r35
            java.lang.String r0 = "stateData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "dateFormatter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "dateValidator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 814303288(0x30894838, float:9.988588E-10)
            r1 = r34
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DateInputContent)P(2)54@2202L15,55@2244L97,58@2369L45,59@2449L44,60@2527L45,61@2602L503,74@3194L42,87@3730L52,75@3241L730:DateInput.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r35
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
            r23 = r10
            r24 = r11
            goto L_0x021d
        L_0x006d:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0079
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.DateInputContent (DateInput.kt:48)"
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
            androidx.compose.material3.CalendarModel r0 = r31.getCalendarModel()
            androidx.compose.material3.DateInputFormat r0 = r0.getDateInputFormat(r9)
            r3.updateRememberedValue(r0)
        L_0x00b6:
            r11.endReplaceableGroup()
            r8 = r0
            androidx.compose.material3.DateInputFormat r8 = (androidx.compose.material3.DateInputFormat) r8
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m3709getDateInputInvalidForPatternadMyvUU()
            r6 = 6
            java.lang.String r16 = androidx.compose.material3.Strings_androidKt.m3763getStringNWtq28(r0, r11, r6)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m3711getDateInputInvalidYearRangeadMyvUU()
            java.lang.String r17 = androidx.compose.material3.Strings_androidKt.m3763getStringNWtq28(r0, r11, r6)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m3710getDateInputInvalidNotAllowedadMyvUU()
            java.lang.String r18 = androidx.compose.material3.Strings_androidKt.m3763getStringNWtq28(r0, r11, r6)
            r0 = r10 & 112(0x70, float:1.57E-43)
            r19 = r0
            r20 = 0
            r0 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            boolean r0 = r11.changed((java.lang.Object) r8)
            boolean r1 = r11.changed((java.lang.Object) r13)
            r0 = r0 | r1
            r21 = r0
            r5 = r11
            r22 = 0
            java.lang.Object r4 = r5.rememberedValue()
            r23 = 0
            if (r21 != 0) goto L_0x0118
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r4 != r0) goto L_0x010d
            goto L_0x0118
        L_0x010d:
            r27 = r4
            r13 = r6
            r29 = r7
            r30 = r8
            r28 = r9
            r9 = r5
            goto L_0x014a
        L_0x0118:
            r24 = 0
            androidx.compose.material3.DateInputValidator r25 = new androidx.compose.material3.DateInputValidator
            java.lang.String r26 = ""
            r0 = r25
            r1 = r31
            r2 = r8
            r3 = r32
            r27 = r4
            r4 = r33
            r28 = r9
            r9 = r5
            r5 = r16
            r13 = r6
            r6 = r17
            r29 = r7
            r7 = r18
            r30 = r8
            r8 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r4 = r25
            r9.updateRememberedValue(r4)
        L_0x014a:
            r11.endReplaceableGroup()
            r19 = r4
            androidx.compose.material3.DateInputValidator r19 = (androidx.compose.material3.DateInputValidator) r19
            java.lang.String r0 = r30.getPatternWithDelimiters()
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toUpperCase(r1)
            java.lang.String r1 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r9 = r0
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m3712getDateInputLabeladMyvUU()
            java.lang.String r13 = androidx.compose.material3.Strings_androidKt.m3763getStringNWtq28(r0, r11, r13)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r1 = 0
            r2 = 0
            r3 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r0, r1, r3, r2)
            androidx.compose.foundation.layout.PaddingValues r1 = InputTextFieldPadding
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.padding(r0, r1)
            androidx.compose.material3.DateInputKt$DateInputContent$1 r1 = new androidx.compose.material3.DateInputKt$DateInputContent$1
            r1.<init>(r13, r9)
            r2 = -438341159(0xffffffffe5df71d9, float:-1.3189848E23)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r2, r3, r1)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.material3.DateInputKt$DateInputContent$2 r2 = new androidx.compose.material3.DateInputKt$DateInputContent$2
            r2.<init>(r9)
            r4 = 1914447672(0x721c2738, float:3.0929327E30)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r4, r3, r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.runtime.MutableState r3 = r31.getSelectedStartDate()
            java.lang.Object r3 = r3.getValue()
            r4 = r3
            androidx.compose.material3.CalendarDate r4 = (androidx.compose.material3.CalendarDate) r4
            r3 = r10 & 14
            r5 = 0
            r6 = 1157296644(0x44faf204, float:2007.563)
            r11.startReplaceableGroup(r6)
            r6 = r29
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r6)
            boolean r6 = r11.changed((java.lang.Object) r12)
            r7 = r11
            r8 = 0
            r34 = r3
            java.lang.Object r3 = r7.rememberedValue()
            r20 = 0
            if (r6 != 0) goto L_0x01d4
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r22 = r5
            java.lang.Object r5 = r21.getEmpty()
            if (r3 != r5) goto L_0x01d1
            goto L_0x01d6
        L_0x01d1:
            r21 = r3
            goto L_0x01e5
        L_0x01d4:
            r22 = r5
        L_0x01d6:
            r5 = 0
            r21 = r3
            androidx.compose.material3.DateInputKt$DateInputContent$3$1 r3 = new androidx.compose.material3.DateInputKt$DateInputContent$3$1
            r3.<init>(r12)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r7.updateRememberedValue(r3)
        L_0x01e5:
            r11.endReplaceableGroup()
            r5 = r3
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.material3.InputIdentifier$Companion r3 = androidx.compose.material3.InputIdentifier.Companion
            int r6 = r3.m3534getSingleDateInputJ2x2o4M()
            int r3 = r10 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r7 = 1075315126(0x401801b6, float:2.3751044)
            r20 = r3 | r7
            r3 = r31
            r7 = r19
            r8 = r30
            r22 = r9
            r21 = r28
            r9 = r21
            r23 = r10
            r10 = r11
            r24 = r11
            r11 = r20
            m3407DateInputTextFieldzm97o8M(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x021d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x021d:
            androidx.compose.runtime.ScopeUpdateScope r0 = r24.endRestartGroup()
            if (r0 != 0) goto L_0x0226
            r2 = r32
            goto L_0x0232
        L_0x0226:
            androidx.compose.material3.DateInputKt$DateInputContent$4 r1 = new androidx.compose.material3.DateInputKt$DateInputContent$4
            r2 = r32
            r1.<init>(r12, r2, r14, r15)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r0.updateScope(r1)
        L_0x0232:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputKt.DateInputContent(androidx.compose.material3.StateData, androidx.compose.material3.DatePickerFormatter, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: DateInputTextField-zm97o8M  reason: not valid java name */
    public static final void m3407DateInputTextFieldzm97o8M(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, StateData stateData, CalendarDate initialDate, Function1<? super CalendarDate, Unit> onDateChanged, int inputIdentifier, DateInputValidator dateInputValidator, DateInputFormat dateInputFormat, Locale locale, Composer $composer, int $changed) {
        float f;
        Object value$iv$iv;
        StateData stateData2 = stateData;
        DateInputFormat dateInputFormat2 = dateInputFormat;
        Locale locale2 = locale;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(stateData2, "stateData");
        Intrinsics.checkNotNullParameter(onDateChanged, "onDateChanged");
        Intrinsics.checkNotNullParameter(dateInputValidator, "dateInputValidator");
        Intrinsics.checkNotNullParameter(dateInputFormat2, "dateInputFormat");
        Intrinsics.checkNotNullParameter(locale2, "locale");
        Composer $composer2 = $composer.startRestartGroup(626552973);
        ComposerKt.sourceInformation($composer2, "C(DateInputTextField)P(6,4,8,9,2,7,3:c#material3.InputIdentifier,1)109@4431L39,110@4487L528,166@6737L88,127@5021L2277:DateInput.kt#uh7d8r");
        int $dirty = $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(626552973, $dirty, -1, "androidx.compose.material3.DateInputTextField (DateInput.kt:97)");
        }
        Composer composer = $composer2;
        MutableState errorText = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, DateInputKt$DateInputTextField$errorText$1.INSTANCE, composer, 3080, 6);
        MutableState text$delegate = RememberSaveableKt.rememberSaveable(new Object[0], TextFieldValue.Companion.getSaver(), (String) null, new DateInputKt$DateInputTextField$text$2(stateData2, initialDate, dateInputFormat2, locale2), composer, 72, 4);
        TextFieldValue DateInputTextField_zm97o8M$lambda$3 = DateInputTextField_zm97o8M$lambda$3(text$delegate);
        int $dirty2 = $dirty;
        Function1 dateInputKt$DateInputTextField$1 = new DateInputKt$DateInputTextField$1(dateInputFormat, errorText, onDateChanged, stateData, dateInputValidator, inputIdentifier, locale, text$delegate);
        if (!StringsKt.isBlank((CharSequence) errorText.getValue())) {
            f = Dp.m7554constructorimpl((float) 0);
        } else {
            f = InputTextNonErroneousBottomPadding;
        }
        Modifier r0 = PaddingKt.m2252paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, f, 7, (Object) null);
        $composer2.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
        MutableState errorText2 = errorText;
        boolean invalid$iv$iv = $composer2.changed((Object) errorText2);
        Composer $this$cache$iv$iv = $composer2;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function1) new DateInputKt$DateInputTextField$2$1(errorText2);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer2.endReplaceableGroup();
        KeyboardOptions keyboardOptions = r0;
        KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, false, KeyboardType.Companion.m7254getNumberPjHm6EE(), ImeAction.Companion.m7206getDoneeUduSuo(), 1, (DefaultConstructorMarker) null);
        OutlinedTextFieldKt.OutlinedTextField(DateInputTextField_zm97o8M$lambda$3, (Function1<? super TextFieldValue, Unit>) dateInputKt$DateInputTextField$1, SemanticsModifierKt.semantics$default(r0, false, (Function1) value$iv$iv, 1, (Object) null), false, false, (TextStyle) null, label, placeholder, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 785795078, true, new DateInputKt$DateInputTextField$3(errorText2)), !StringsKt.isBlank((CharSequence) errorText2.getValue()), (VisualTransformation) new DateVisualTransformation(dateInputFormat2), keyboardOptions, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer2, (($dirty2 << 15) & 3670016) | (29360128 & ($dirty2 << 15)), 12779904, 0, 8195896);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            MutableState mutableState = errorText2;
            Composer composer2 = $composer2;
            return;
        }
        MutableState mutableState2 = errorText2;
        Composer composer3 = $composer2;
        endRestartGroup.updateScope(new DateInputKt$DateInputTextField$4(modifier, label, placeholder, stateData, initialDate, onDateChanged, inputIdentifier, dateInputValidator, dateInputFormat, locale, $changed));
    }

    private static final TextFieldValue DateInputTextField_zm97o8M$lambda$3(MutableState<TextFieldValue> $text$delegate) {
        return (TextFieldValue) $text$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final void DateInputTextField_zm97o8M$lambda$4(MutableState<TextFieldValue> $text$delegate, TextFieldValue value) {
        $text$delegate.setValue(value);
    }

    public static final PaddingValues getInputTextFieldPadding() {
        return InputTextFieldPadding;
    }
}

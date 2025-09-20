package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$TimeInputImpl$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ MutableState<TextFieldValue> $hourValue$delegate;
    final /* synthetic */ MutableState<TextFieldValue> $minuteValue$delegate;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimeInputImpl$1$1(MutableState<TextFieldValue> mutableState, TimePickerState timePickerState, int i, TimePickerColors timePickerColors, MutableState<TextFieldValue> mutableState2) {
        super(2);
        this.$hourValue$delegate = mutableState;
        this.$state = timePickerState;
        this.$$dirty = i;
        this.$colors = timePickerColors;
        this.$minuteValue$delegate = mutableState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r35, int r36) {
        /*
            r34 = this;
            r0 = r34
            r12 = r35
            r13 = r36
            java.lang.String r1 = "C718@30707L411,730@31187L353,745@31849L38,716@30618L1318,748@31949L85,751@32143L376,764@32591L331,779@33233L38,749@32047L1273:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r13 & 11
            r2 = 2
            if (r1 != r2) goto L_0x001c
            boolean r1 = r35.getSkipping()
            if (r1 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r35.skipToGroupEnd()
            goto L_0x02ec
        L_0x001c:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x002b
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.TimeInputImpl.<anonymous>.<anonymous> (TimePicker.kt:714)"
            r3 = 1306700887(0x4de2ac57, float:4.7536816E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r13, r1, r2)
        L_0x002b:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r2 = r0.$hourValue$delegate
            androidx.compose.material3.TimePickerState r3 = r0.$state
            androidx.compose.material3.TimePickerState r4 = r0.$state
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r5 = r0.$hourValue$delegate
            int r6 = r0.$$dirty
            int r6 = r6 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r7 = 0
            r14 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r14)
            java.lang.String r15 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r15)
            boolean r8 = r12.changed((java.lang.Object) r2)
            boolean r9 = r12.changed((java.lang.Object) r3)
            r8 = r8 | r9
            r9 = r35
            r10 = 0
            java.lang.Object r11 = r9.rememberedValue()
            r16 = 0
            if (r8 != 0) goto L_0x006a
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r17.getEmpty()
            if (r11 != r14) goto L_0x0066
            goto L_0x006a
        L_0x0066:
            r17 = r2
            r2 = r11
            goto L_0x0079
        L_0x006a:
            r14 = 0
            r17 = r2
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$1 r2 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$1
            r2.<init>(r4, r5)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r9.updateRememberedValue(r2)
        L_0x0079:
            r35.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.input.key.KeyInputModifierKt.onKeyEvent(r1, r2)
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r2 = r0.$hourValue$delegate
            androidx.compose.ui.text.input.TextFieldValue r2 = androidx.compose.material3.TimePickerKt.TimeInputImpl$lambda$5(r2)
            androidx.compose.material3.TimePickerState r3 = r0.$state
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r4 = r0.$hourValue$delegate
            androidx.compose.material3.TimePickerState r5 = r0.$state
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r6 = r0.$hourValue$delegate
            int r7 = r0.$$dirty
            r14 = 6
            int r7 = r7 >> r14
            r7 = r7 & 14
            r8 = 0
            r9 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r15)
            boolean r9 = r12.changed((java.lang.Object) r3)
            boolean r10 = r12.changed((java.lang.Object) r4)
            r9 = r9 | r10
            r10 = r35
            r11 = 0
            java.lang.Object r14 = r10.rememberedValue()
            r17 = 0
            if (r9 != 0) goto L_0x00c3
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r20 = r3
            java.lang.Object r3 = r19.getEmpty()
            if (r14 != r3) goto L_0x00c1
            goto L_0x00c5
        L_0x00c1:
            r3 = r14
            goto L_0x00d4
        L_0x00c3:
            r20 = r3
        L_0x00c5:
            r3 = 0
            r19 = r3
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$2$1 r3 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$2$1
            r3.<init>(r5, r6)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r10.updateRememberedValue(r3)
        L_0x00d4:
            r35.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.material3.TimePickerState r4 = r0.$state
            androidx.compose.material3.Selection$Companion r5 = androidx.compose.material3.Selection.Companion
            int r5 = r5.m3670getHourJiIwxys()
            androidx.compose.ui.text.input.ImeAction$Companion r6 = androidx.compose.ui.text.input.ImeAction.Companion
            int r23 = r6.m7208getNexteUduSuo()
            androidx.compose.ui.text.input.KeyboardType$Companion r6 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r22 = r6.m7254getNumberPjHm6EE()
            androidx.compose.foundation.text.KeyboardOptions r6 = new androidx.compose.foundation.text.KeyboardOptions
            r24 = 3
            r25 = 0
            r20 = 0
            r21 = 0
            r19 = r6
            r19.<init>(r20, r21, r22, r23, r24, r25)
            androidx.compose.material3.TimePickerState r7 = r0.$state
            androidx.compose.material3.TimePickerState r8 = r0.$state
            int r9 = r0.$$dirty
            r10 = 6
            int r9 = r9 >> r10
            r9 = r9 & 14
            r10 = 0
            r14 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r14)
            java.lang.String r11 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r11)
            boolean r17 = r12.changed((java.lang.Object) r7)
            r19 = r35
            r20 = 0
            java.lang.Object r14 = r19.rememberedValue()
            r22 = 0
            if (r17 != 0) goto L_0x0135
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r24 = r7
            java.lang.Object r7 = r23.getEmpty()
            if (r14 != r7) goto L_0x0131
            goto L_0x0137
        L_0x0131:
            r7 = r14
            r8 = r19
            goto L_0x0148
        L_0x0135:
            r24 = r7
        L_0x0137:
            r7 = 0
            r23 = r7
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$3$1 r7 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$3$1
            r7.<init>(r8)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r8 = r19
            r8.updateRememberedValue(r7)
        L_0x0148:
            r35.endReplaceableGroup()
            r28 = r7
            kotlin.jvm.functions.Function1 r28 = (kotlin.jvm.functions.Function1) r28
            androidx.compose.foundation.text.KeyboardActions r7 = new androidx.compose.foundation.text.KeyboardActions
            r26 = 0
            r27 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 59
            r33 = 0
            r25 = r7
            r25.<init>(r26, r27, r28, r29, r30, r31, r32, r33)
            androidx.compose.material3.TimePickerColors r8 = r0.$colors
            int r9 = r0.$$dirty
            int r10 = r9 << 3
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | 24576(0x6000, float:3.4438E-41)
            int r9 = r9 << 18
            r14 = 29360128(0x1c00000, float:7.052966E-38)
            r9 = r9 & r14
            r10 = r10 | r9
            r17 = 0
            r9 = r35
            r14 = r11
            r11 = r17
            androidx.compose.material3.TimePickerKt.m3874TimePickerTextFieldlxUZ_iY(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            float r2 = androidx.compose.material3.TimePickerKt.DisplaySeparatorWidth
            androidx.compose.material3.tokens.TimeInputTokens r3 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r3 = r3.m4466getPeriodSelectorContainerHeightD9Ej5fM()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m2324sizeVpY3zN4(r1, r2, r3)
            r2 = 6
            androidx.compose.material3.TimePickerKt.DisplaySeparator(r1, r12, r2)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r2 = r0.$minuteValue$delegate
            androidx.compose.material3.TimePickerState r3 = r0.$state
            androidx.compose.material3.TimePickerState r4 = r0.$state
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r5 = r0.$minuteValue$delegate
            int r6 = r0.$$dirty
            int r6 = r6 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r7 = 0
            r8 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r15)
            boolean r8 = r12.changed((java.lang.Object) r2)
            boolean r9 = r12.changed((java.lang.Object) r3)
            r8 = r8 | r9
            r9 = r35
            r10 = 0
            java.lang.Object r11 = r9.rememberedValue()
            r17 = 0
            if (r8 != 0) goto L_0x01d3
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r22 = r2
            java.lang.Object r2 = r20.getEmpty()
            if (r11 != r2) goto L_0x01d1
            goto L_0x01d5
        L_0x01d1:
            r2 = r11
            goto L_0x01e4
        L_0x01d3:
            r22 = r2
        L_0x01d5:
            r2 = 0
            r20 = r2
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$4$1 r2 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$4$1
            r2.<init>(r4, r5)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r9.updateRememberedValue(r2)
        L_0x01e4:
            r35.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.input.key.KeyInputModifierKt.onPreviewKeyEvent(r1, r2)
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r2 = r0.$minuteValue$delegate
            androidx.compose.ui.text.input.TextFieldValue r2 = androidx.compose.material3.TimePickerKt.TimeInputImpl$lambda$8(r2)
            androidx.compose.material3.TimePickerState r3 = r0.$state
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r4 = r0.$minuteValue$delegate
            androidx.compose.material3.TimePickerState r5 = r0.$state
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r6 = r0.$minuteValue$delegate
            int r7 = r0.$$dirty
            r8 = 6
            int r7 = r7 >> r8
            r7 = r7 & 14
            r8 = 0
            r9 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r15)
            boolean r9 = r12.changed((java.lang.Object) r3)
            boolean r10 = r12.changed((java.lang.Object) r4)
            r9 = r9 | r10
            r10 = r35
            r11 = 0
            java.lang.Object r15 = r10.rememberedValue()
            r17 = 0
            if (r9 != 0) goto L_0x022e
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r20 = r3
            java.lang.Object r3 = r18.getEmpty()
            if (r15 != r3) goto L_0x022c
            goto L_0x0230
        L_0x022c:
            r3 = r15
            goto L_0x023f
        L_0x022e:
            r20 = r3
        L_0x0230:
            r3 = 0
            r18 = r3
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$5$1 r3 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$5$1
            r3.<init>(r5, r6)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r10.updateRememberedValue(r3)
        L_0x023f:
            r35.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.material3.TimePickerState r4 = r0.$state
            androidx.compose.material3.Selection$Companion r5 = androidx.compose.material3.Selection.Companion
            int r5 = r5.m3671getMinuteJiIwxys()
            androidx.compose.ui.text.input.ImeAction$Companion r6 = androidx.compose.ui.text.input.ImeAction.Companion
            int r26 = r6.m7206getDoneeUduSuo()
            androidx.compose.ui.text.input.KeyboardType$Companion r6 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r25 = r6.m7254getNumberPjHm6EE()
            androidx.compose.foundation.text.KeyboardOptions r6 = new androidx.compose.foundation.text.KeyboardOptions
            r27 = 3
            r28 = 0
            r23 = 0
            r24 = 0
            r22 = r6
            r22.<init>(r23, r24, r25, r26, r27, r28)
            androidx.compose.material3.TimePickerState r7 = r0.$state
            androidx.compose.material3.TimePickerState r8 = r0.$state
            int r9 = r0.$$dirty
            r10 = 6
            int r9 = r9 >> r10
            r9 = r9 & 14
            r10 = 0
            r11 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r14)
            boolean r11 = r12.changed((java.lang.Object) r7)
            r14 = r35
            r15 = 0
            r16 = r7
            java.lang.Object r7 = r14.rememberedValue()
            r17 = 0
            if (r11 != 0) goto L_0x029e
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r20 = r9
            java.lang.Object r9 = r18.getEmpty()
            if (r7 != r9) goto L_0x029b
            goto L_0x02a0
        L_0x029b:
            r18 = r7
            goto L_0x02af
        L_0x029e:
            r20 = r9
        L_0x02a0:
            r9 = 0
            r18 = r7
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$6$1 r7 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$6$1
            r7.<init>(r8)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r14.updateRememberedValue(r7)
        L_0x02af:
            r35.endReplaceableGroup()
            r24 = r7
            kotlin.jvm.functions.Function1 r24 = (kotlin.jvm.functions.Function1) r24
            androidx.compose.foundation.text.KeyboardActions r7 = new androidx.compose.foundation.text.KeyboardActions
            r22 = 0
            r23 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 59
            r29 = 0
            r21 = r7
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29)
            androidx.compose.material3.TimePickerColors r8 = r0.$colors
            int r9 = r0.$$dirty
            int r10 = r9 << 3
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | 24576(0x6000, float:3.4438E-41)
            int r9 = r9 << 18
            r11 = 29360128(0x1c00000, float:7.052966E-38)
            r9 = r9 & r11
            r10 = r10 | r9
            r11 = 0
            r9 = r35
            androidx.compose.material3.TimePickerKt.m3874TimePickerTextFieldlxUZ_iY(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x02ec
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}

package androidx.compose.foundation.text;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001323\b\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001fH\u0001¢\u0006\u0002\u0010#\u001a0\u0010$\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001fH\u0003¢\u0006\u0002\u0010(\u001a\u001d\u0010)\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010+\u001a\u0015\u0010,\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\u0010-\u001a\u0010\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u000200H\u0002\u001a \u00101\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00102\u001a\u000203H\u0002\u001a0\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0002\u001a \u00107\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0013H\u0002\u001a5\u0010;\u001a\u00020\u0001*\u00020<2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\r2\u0006\u00102\u001a\u000203H@ø\u0001\u0000¢\u0006\u0002\u0010@\u001a\u001c\u0010A\u001a\u00020\u0007*\u00020\u00072\u0006\u0010/\u001a\u0002002\u0006\u0010%\u001a\u00020&H\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006B²\u0006\n\u0010C\u001a\u00020\u0013X\u0002"}, d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "endInputSession", "state", "Landroidx/compose/foundation/text/TextFieldState;", "notifyFocusedRect", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release", "writeable"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
public final class CoreTextFieldKt {
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0530, code lost:
        if (r2 == null) goto L_0x0539;
     */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x057c  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x05bf  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0624  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x063d  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x0682  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0692  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x0748  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0767  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x07a1  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x07ac  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x07eb  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0822  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x082d  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x086b  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0958  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x095b  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x09c4  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x09cf  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0a26  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CoreTextField(androidx.compose.ui.text.input.TextFieldValue r67, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r68, androidx.compose.ui.Modifier r69, androidx.compose.ui.text.TextStyle r70, androidx.compose.ui.text.input.VisualTransformation r71, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r72, androidx.compose.foundation.interaction.MutableInteractionSource r73, androidx.compose.ui.graphics.Brush r74, boolean r75, int r76, int r77, androidx.compose.ui.text.input.ImeOptions r78, androidx.compose.foundation.text.KeyboardActions r79, boolean r80, boolean r81, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r82, androidx.compose.runtime.Composer r83, int r84, int r85, int r86) {
        /*
            r15 = r67
            r14 = r68
            r13 = r84
            r12 = r85
            r11 = r86
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -958708118(0xffffffffc6db466a, float:-28067.207)
            r1 = r83
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(CoreTextField)P(14,10,8,13,15,9,4!1,12,6,7,3,5,2,11)205@11428L29,209@11626L7,210@11665L7,211@11726L7,212@11794L7,213@11859L7,221@12168L42,218@12075L135,224@12251L268,236@12824L21,237@12862L324,265@13585L26,268@13671L51,274@13974L7,275@14025L7,276@14082L7,280@14193L24,281@14251L37,571@26067L86,575@26159L515,623@27910L4554:CoreTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r84
            r2 = r85
            r3 = r11 & 1
            if (r3 == 0) goto L_0x002f
            r1 = r1 | 6
            goto L_0x003d
        L_0x002f:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x003d
            boolean r3 = r10.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x003b
            r3 = 4
            goto L_0x003c
        L_0x003b:
            r3 = 2
        L_0x003c:
            r1 = r1 | r3
        L_0x003d:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0044
            r1 = r1 | 48
            goto L_0x0054
        L_0x0044:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0054
            boolean r3 = r10.changedInstance(r14)
            if (r3 == 0) goto L_0x0051
            r3 = 32
            goto L_0x0053
        L_0x0051:
            r3 = 16
        L_0x0053:
            r1 = r1 | r3
        L_0x0054:
            r3 = r11 & 4
            if (r3 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r4 = r69
            goto L_0x0073
        L_0x005d:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0071
            r4 = r69
            boolean r16 = r10.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x006c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r16
            goto L_0x0073
        L_0x0071:
            r4 = r69
        L_0x0073:
            r16 = r11 & 8
            r17 = 1024(0x400, float:1.435E-42)
            r18 = 2048(0x800, float:2.87E-42)
            if (r16 == 0) goto L_0x0080
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r6 = r70
            goto L_0x0096
        L_0x0080:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0094
            r6 = r70
            boolean r20 = r10.changed((java.lang.Object) r6)
            if (r20 == 0) goto L_0x008f
            r20 = r18
            goto L_0x0091
        L_0x008f:
            r20 = r17
        L_0x0091:
            r1 = r1 | r20
            goto L_0x0096
        L_0x0094:
            r6 = r70
        L_0x0096:
            r20 = r11 & 16
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            if (r20 == 0) goto L_0x00a3
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r7 = r71
            goto L_0x00bc
        L_0x00a3:
            r23 = 57344(0xe000, float:8.0356E-41)
            r23 = r13 & r23
            if (r23 != 0) goto L_0x00ba
            r7 = r71
            boolean r24 = r10.changed((java.lang.Object) r7)
            if (r24 == 0) goto L_0x00b5
            r24 = r21
            goto L_0x00b7
        L_0x00b5:
            r24 = r22
        L_0x00b7:
            r1 = r1 | r24
            goto L_0x00bc
        L_0x00ba:
            r7 = r71
        L_0x00bc:
            r24 = r11 & 32
            if (r24 == 0) goto L_0x00c7
            r25 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r25
            r8 = r72
            goto L_0x00df
        L_0x00c7:
            r25 = 458752(0x70000, float:6.42848E-40)
            r25 = r13 & r25
            if (r25 != 0) goto L_0x00dd
            r8 = r72
            boolean r26 = r10.changedInstance(r8)
            if (r26 == 0) goto L_0x00d8
            r26 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00da
        L_0x00d8:
            r26 = 65536(0x10000, float:9.18355E-41)
        L_0x00da:
            r1 = r1 | r26
            goto L_0x00df
        L_0x00dd:
            r8 = r72
        L_0x00df:
            r26 = r11 & 64
            if (r26 == 0) goto L_0x00ea
            r27 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r27
            r9 = r73
            goto L_0x0102
        L_0x00ea:
            r27 = 3670016(0x380000, float:5.142788E-39)
            r27 = r13 & r27
            if (r27 != 0) goto L_0x0100
            r9 = r73
            boolean r28 = r10.changed((java.lang.Object) r9)
            if (r28 == 0) goto L_0x00fb
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fd
        L_0x00fb:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00fd:
            r1 = r1 | r28
            goto L_0x0102
        L_0x0100:
            r9 = r73
        L_0x0102:
            r5 = r11 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x010d
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r29
            r0 = r74
            goto L_0x0125
        L_0x010d:
            r29 = 29360128(0x1c00000, float:7.052966E-38)
            r29 = r13 & r29
            if (r29 != 0) goto L_0x0123
            r0 = r74
            boolean r30 = r10.changed((java.lang.Object) r0)
            if (r30 == 0) goto L_0x011e
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0120
        L_0x011e:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x0120:
            r1 = r1 | r30
            goto L_0x0125
        L_0x0123:
            r0 = r74
        L_0x0125:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0130
            r30 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r30
            r4 = r75
            goto L_0x0148
        L_0x0130:
            r30 = 234881024(0xe000000, float:1.5777218E-30)
            r30 = r13 & r30
            if (r30 != 0) goto L_0x0146
            r4 = r75
            boolean r30 = r10.changed((boolean) r4)
            if (r30 == 0) goto L_0x0141
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0143
        L_0x0141:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0143:
            r1 = r1 | r30
            goto L_0x0148
        L_0x0146:
            r4 = r75
        L_0x0148:
            r4 = r11 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0153
            r30 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r30
            r6 = r76
            goto L_0x016b
        L_0x0153:
            r30 = 1879048192(0x70000000, float:1.58456325E29)
            r30 = r13 & r30
            if (r30 != 0) goto L_0x0169
            r6 = r76
            boolean r30 = r10.changed((int) r6)
            if (r30 == 0) goto L_0x0164
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0166
        L_0x0164:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0166:
            r1 = r1 | r30
            goto L_0x016b
        L_0x0169:
            r6 = r76
        L_0x016b:
            r6 = r11 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x0174
            r2 = r2 | 6
            r7 = r77
            goto L_0x018a
        L_0x0174:
            r30 = r12 & 14
            if (r30 != 0) goto L_0x0188
            r7 = r77
            boolean r30 = r10.changed((int) r7)
            if (r30 == 0) goto L_0x0183
            r30 = 4
            goto L_0x0185
        L_0x0183:
            r30 = 2
        L_0x0185:
            r2 = r2 | r30
            goto L_0x018a
        L_0x0188:
            r7 = r77
        L_0x018a:
            r30 = r12 & 112(0x70, float:1.57E-43)
            if (r30 != 0) goto L_0x01a4
            r7 = r11 & 2048(0x800, float:2.87E-42)
            if (r7 != 0) goto L_0x019d
            r7 = r78
            boolean r30 = r10.changed((java.lang.Object) r7)
            if (r30 == 0) goto L_0x019f
            r19 = 32
            goto L_0x01a1
        L_0x019d:
            r7 = r78
        L_0x019f:
            r19 = 16
        L_0x01a1:
            r2 = r2 | r19
            goto L_0x01a6
        L_0x01a4:
            r7 = r78
        L_0x01a6:
            r7 = r11 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x01af
            r2 = r2 | 384(0x180, float:5.38E-43)
            r8 = r79
            goto L_0x01c5
        L_0x01af:
            r8 = r12 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x01c3
            r8 = r79
            boolean r19 = r10.changed((java.lang.Object) r8)
            if (r19 == 0) goto L_0x01be
            r25 = 256(0x100, float:3.59E-43)
            goto L_0x01c0
        L_0x01be:
            r25 = 128(0x80, float:1.794E-43)
        L_0x01c0:
            r2 = r2 | r25
            goto L_0x01c5
        L_0x01c3:
            r8 = r79
        L_0x01c5:
            r8 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x01ce
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r9 = r80
            goto L_0x01e1
        L_0x01ce:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x01df
            r9 = r80
            boolean r19 = r10.changed((boolean) r9)
            if (r19 == 0) goto L_0x01dc
            r17 = r18
        L_0x01dc:
            r2 = r2 | r17
            goto L_0x01e1
        L_0x01df:
            r9 = r80
        L_0x01e1:
            r9 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x01ea
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r14 = r81
            goto L_0x0201
        L_0x01ea:
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x01ff
            r14 = r81
            boolean r17 = r10.changed((boolean) r14)
            if (r17 == 0) goto L_0x01fa
            goto L_0x01fc
        L_0x01fa:
            r21 = r22
        L_0x01fc:
            r2 = r2 | r21
            goto L_0x0201
        L_0x01ff:
            r14 = r81
        L_0x0201:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r11 & r17
            if (r17 == 0) goto L_0x020f
            r18 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r18
            r12 = r82
            goto L_0x0227
        L_0x020f:
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0225
            r12 = r82
            boolean r18 = r10.changedInstance(r12)
            if (r18 == 0) goto L_0x0220
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0222
        L_0x0220:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x0222:
            r2 = r2 | r18
            goto L_0x0227
        L_0x0225:
            r12 = r82
        L_0x0227:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r1 & r18
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r14) goto L_0x0267
            r12 = 374491(0x5b6db, float:5.24774E-40)
            r12 = r12 & r2
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r12 != r14) goto L_0x0267
            boolean r12 = r10.getSkipping()
            if (r12 != 0) goto L_0x0241
            goto L_0x0267
        L_0x0241:
            r10.skipToGroupEnd()
            r20 = r69
            r31 = r70
            r55 = r71
            r32 = r72
            r21 = r73
            r33 = r74
            r34 = r75
            r57 = r76
            r35 = r77
            r58 = r78
            r36 = r79
            r54 = r80
            r37 = r81
            r38 = r82
            r49 = r1
            r53 = r2
            r15 = r10
            goto L_0x0a2d
        L_0x0267:
            r10.startDefaults()
            r12 = r13 & 1
            r14 = 0
            if (r12 == 0) goto L_0x029e
            boolean r12 = r10.getDefaultsInvalid()
            if (r12 == 0) goto L_0x0276
            goto L_0x029e
        L_0x0276:
            r10.skipToGroupEnd()
            r0 = r11 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x027f
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x027f:
            r13 = r69
            r31 = r70
            r12 = r71
            r32 = r72
            r9 = r73
            r33 = r74
            r34 = r75
            r8 = r76
            r35 = r77
            r7 = r78
            r36 = r79
            r6 = r80
            r37 = r81
            r38 = r82
            r5 = r2
            goto L_0x0358
        L_0x029e:
            if (r3 == 0) goto L_0x02a5
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x02a7
        L_0x02a5:
            r3 = r69
        L_0x02a7:
            if (r16 == 0) goto L_0x02b0
            androidx.compose.ui.text.TextStyle$Companion r12 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r12 = r12.getDefault()
            goto L_0x02b2
        L_0x02b0:
            r12 = r70
        L_0x02b2:
            if (r20 == 0) goto L_0x02bb
            androidx.compose.ui.text.input.VisualTransformation$Companion r16 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r16 = r16.getNone()
            goto L_0x02bd
        L_0x02bb:
            r16 = r71
        L_0x02bd:
            if (r24 == 0) goto L_0x02c4
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1 r18 = androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1.INSTANCE
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18
            goto L_0x02c6
        L_0x02c4:
            r18 = r72
        L_0x02c6:
            if (r26 == 0) goto L_0x02cb
            r19 = 0
            goto L_0x02cd
        L_0x02cb:
            r19 = r73
        L_0x02cd:
            if (r5 == 0) goto L_0x02df
            androidx.compose.ui.graphics.SolidColor r5 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r20 = androidx.compose.ui.graphics.Color.Companion
            r69 = r12
            long r12 = r20.m4999getUnspecified0d7_KjU()
            r5.<init>(r12, r14)
            androidx.compose.ui.graphics.Brush r5 = (androidx.compose.ui.graphics.Brush) r5
            goto L_0x02e3
        L_0x02df:
            r69 = r12
            r5 = r74
        L_0x02e3:
            if (r0 == 0) goto L_0x02e7
            r0 = 1
            goto L_0x02e9
        L_0x02e7:
            r0 = r75
        L_0x02e9:
            if (r4 == 0) goto L_0x02ef
            r4 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02f1
        L_0x02ef:
            r4 = r76
        L_0x02f1:
            if (r6 == 0) goto L_0x02f5
            r6 = 1
            goto L_0x02f7
        L_0x02f5:
            r6 = r77
        L_0x02f7:
            r12 = r11 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0304
            androidx.compose.ui.text.input.ImeOptions$Companion r12 = androidx.compose.ui.text.input.ImeOptions.Companion
            androidx.compose.ui.text.input.ImeOptions r12 = r12.getDefault()
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0306
        L_0x0304:
            r12 = r78
        L_0x0306:
            if (r7 == 0) goto L_0x030f
            androidx.compose.foundation.text.KeyboardActions$Companion r7 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r7 = r7.getDefault()
            goto L_0x0311
        L_0x030f:
            r7 = r79
        L_0x0311:
            if (r8 == 0) goto L_0x0315
            r8 = 1
            goto L_0x0317
        L_0x0315:
            r8 = r80
        L_0x0317:
            if (r9 == 0) goto L_0x031b
            r9 = 0
            goto L_0x031d
        L_0x031b:
            r9 = r81
        L_0x031d:
            if (r17 == 0) goto L_0x033f
            androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt r13 = androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r13 = r13.m2604getLambda1$foundation_release()
            r31 = r69
            r34 = r0
            r33 = r5
            r35 = r6
            r36 = r7
            r6 = r8
            r37 = r9
            r7 = r12
            r38 = r13
            r12 = r16
            r32 = r18
            r9 = r19
            r5 = r2
            r13 = r3
            r8 = r4
            goto L_0x0358
        L_0x033f:
            r31 = r69
            r38 = r82
            r34 = r0
            r13 = r3
            r33 = r5
            r35 = r6
            r36 = r7
            r6 = r8
            r37 = r9
            r7 = r12
            r12 = r16
            r32 = r18
            r9 = r19
            r5 = r2
            r8 = r4
        L_0x0358:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0369
            java.lang.String r0 = "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:186)"
            r2 = -958708118(0xffffffffc6db466a, float:-28067.207)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r5, r0)
        L_0x0369:
            r4 = 0
            r0 = r4
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r3)
            java.lang.String r14 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r16 = 0
            r69 = r10
            r17 = 0
            java.lang.Object r3 = r69.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r19.getEmpty()
            if (r3 != r4) goto L_0x039d
            r4 = 0
            androidx.compose.ui.focus.FocusRequester r19 = new androidx.compose.ui.focus.FocusRequester
            r19.<init>()
            r4 = r19
            r70 = r0
            r0 = r69
            r0.updateRememberedValue(r4)
            goto L_0x03a2
        L_0x039d:
            r70 = r0
            r0 = r69
            r4 = r3
        L_0x03a2:
            r10.endReplaceableGroup()
            androidx.compose.ui.focus.FocusRequester r4 = (androidx.compose.ui.focus.FocusRequester) r4
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalTextInputService()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r2 = 0
            r3 = 0
            r69 = r2
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            r70 = r3
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r2, r3)
            java.lang.Object r16 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r0 = r16
            androidx.compose.ui.text.input.TextInputService r0 = (androidx.compose.ui.text.input.TextInputService) r0
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r2 = r16
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r16 = 0
            r18 = 0
            r19 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r3)
            java.lang.Object r5 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r39 = r5
            androidx.compose.ui.unit.Density r39 = (androidx.compose.ui.unit.Density) r39
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r5 = 0
            r16 = 0
            r69 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r3)
            java.lang.Object r5 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r40 = r5
            androidx.compose.ui.text.font.FontFamily$Resolver r40 = (androidx.compose.ui.text.font.FontFamily.Resolver) r40
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r5 = 6
            r16 = 0
            r69 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r3)
            java.lang.Object r5 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.foundation.text.selection.TextSelectionColors r5 = (androidx.compose.foundation.text.selection.TextSelectionColors) r5
            long r41 = r5.m2861getBackgroundColor0d7_KjU()
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r5 = 0
            r16 = 0
            r69 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r3)
            java.lang.Object r5 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.focus.FocusManager r5 = (androidx.compose.ui.focus.FocusManager) r5
            r2 = 1
            if (r8 != r2) goto L_0x0449
            if (r34 != 0) goto L_0x0449
            boolean r16 = r7.getSingleLine()
            if (r16 == 0) goto L_0x0449
            r16 = r2
            goto L_0x044b
        L_0x0449:
            r16 = 0
        L_0x044b:
            r43 = r16
            if (r43 == 0) goto L_0x0452
            androidx.compose.foundation.gestures.Orientation r16 = androidx.compose.foundation.gestures.Orientation.Horizontal
            goto L_0x0454
        L_0x0452:
            androidx.compose.foundation.gestures.Orientation r16 = androidx.compose.foundation.gestures.Orientation.Vertical
        L_0x0454:
            r44 = r16
            java.lang.Object[] r16 = new java.lang.Object[]{r44}
            androidx.compose.foundation.text.TextFieldScrollerPosition$Companion r18 = androidx.compose.foundation.text.TextFieldScrollerPosition.Companion
            androidx.compose.runtime.saveable.Saver r18 = r18.getSaver()
            r20 = 0
            r21 = r20
            r20 = 0
            r2 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            r2 = r44
            boolean r23 = r10.changed((java.lang.Object) r2)
            r69 = r10
            r24 = 0
            r25 = r8
            java.lang.Object r8 = r69.rememberedValue()
            r26 = 0
            if (r23 != 0) goto L_0x0493
            androidx.compose.runtime.Composer$Companion r27 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r27.getEmpty()
            if (r8 != r11) goto L_0x048e
            goto L_0x0493
        L_0x048e:
            r11 = r69
            r70 = r8
            goto L_0x04a4
        L_0x0493:
            r11 = 0
            r70 = r8
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1 r8 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
            r8.<init>(r2)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r11 = r69
            r11.updateRememberedValue(r8)
        L_0x04a4:
            r10.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r11 = 0
            r20 = 72
            r21 = 4
            r69 = r16
            r70 = r18
            r71 = r11
            r72 = r8
            r73 = r10
            r74 = r20
            r75 = r21
            java.lang.Object r8 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r69, r70, (java.lang.String) r71, r72, (androidx.compose.runtime.Composer) r73, (int) r74, (int) r75)
            r11 = r8
            androidx.compose.foundation.text.TextFieldScrollerPosition r11 = (androidx.compose.foundation.text.TextFieldScrollerPosition) r11
            r8 = r1 & 14
            int r16 = r1 >> 9
            r16 = r16 & 112(0x70, float:1.57E-43)
            r8 = r8 | r16
            r16 = 0
            r18 = r1
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            boolean r1 = r10.changed((java.lang.Object) r15)
            boolean r20 = r10.changed((java.lang.Object) r12)
            r1 = r1 | r20
            r69 = r10
            r20 = 0
            r21 = r2
            java.lang.Object r2 = r69.rememberedValue()
            r23 = 0
            if (r1 != 0) goto L_0x050b
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r70 = r1
            java.lang.Object r1 = r24.getEmpty()
            if (r2 != r1) goto L_0x0500
            goto L_0x050d
        L_0x0500:
            r73 = r2
            r1 = r73
            r72 = r8
            r26 = r9
            r2 = r69
            goto L_0x0542
        L_0x050b:
            r70 = r1
        L_0x050d:
            r1 = 0
            r71 = r1
            androidx.compose.ui.text.AnnotatedString r1 = r67.getAnnotatedString()
            androidx.compose.ui.text.input.TransformedText r1 = androidx.compose.foundation.text.ValidatingOffsetMappingKt.filterWithValidation(r12, r1)
            androidx.compose.ui.text.TextRange r24 = r67.m7264getCompositionMzsxiRA()
            if (r24 == 0) goto L_0x0533
            r72 = r8
            r26 = r9
            long r8 = r24.m7039unboximpl()
            r24 = 0
            r73 = r2
            androidx.compose.foundation.text.TextFieldDelegate$Companion r2 = androidx.compose.foundation.text.TextFieldDelegate.Companion
            androidx.compose.ui.text.input.TransformedText r2 = r2.m2664applyCompositionDecoration72CqOWE(r8, r1)
            if (r2 != 0) goto L_0x053a
            goto L_0x0539
        L_0x0533:
            r73 = r2
            r72 = r8
            r26 = r9
        L_0x0539:
            r2 = r1
        L_0x053a:
            r1 = r2
            r2 = r69
            r2.updateRememberedValue(r1)
        L_0x0542:
            r10.endReplaceableGroup()
            r44 = r1
            androidx.compose.ui.text.input.TransformedText r44 = (androidx.compose.ui.text.input.TransformedText) r44
            androidx.compose.ui.text.AnnotatedString r45 = r44.getText()
            androidx.compose.ui.text.input.OffsetMapping r9 = r44.getOffsetMapping()
            r1 = 0
            androidx.compose.runtime.RecomposeScope r8 = androidx.compose.runtime.ComposablesKt.getCurrentRecomposeScope(r10, r1)
            r2 = r1
            r1 = 0
            r16 = r1
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r1 = 0
            r20 = r10
            r23 = 0
            r24 = r1
            java.lang.Object r1 = r20.rememberedValue()
            r27 = 0
            androidx.compose.runtime.Composer$Companion r29 = androidx.compose.runtime.Composer.Companion
            r30 = r2
            java.lang.Object r2 = r29.getEmpty()
            if (r1 != r2) goto L_0x05bf
            r2 = 0
            r29 = r1
            androidx.compose.foundation.text.TextFieldState r1 = new androidx.compose.foundation.text.TextFieldState
            r46 = r2
            androidx.compose.foundation.text.TextDelegate r2 = new androidx.compose.foundation.text.TextDelegate
            r47 = 300(0x12c, float:4.2E-43)
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = 0
            r69 = r2
            r70 = r45
            r71 = r31
            r72 = r49
            r73 = r50
            r74 = r34
            r75 = r51
            r76 = r39
            r77 = r40
            r78 = r52
            r79 = r47
            r80 = r48
            r69.<init>(r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80)
            r1.<init>(r2, r8)
            r2 = r20
            r2.updateRememberedValue(r1)
            goto L_0x05c3
        L_0x05bf:
            r29 = r1
            r2 = r20
        L_0x05c3:
            r10.endReplaceableGroup()
            r2 = r1
            androidx.compose.foundation.text.TextFieldState r2 = (androidx.compose.foundation.text.TextFieldState) r2
            androidx.compose.ui.text.AnnotatedString r1 = r67.getAnnotatedString()
            r69 = r2
            r70 = r1
            r71 = r45
            r72 = r31
            r73 = r34
            r74 = r39
            r75 = r40
            r76 = r68
            r77 = r36
            r78 = r5
            r79 = r41
            r69.m2686updatefnh65Uc(r70, r71, r72, r73, r74, r75, r76, r77, r78, r79)
            androidx.compose.ui.text.input.EditProcessor r1 = r2.getProcessor()
            r80 = r5
            androidx.compose.ui.text.input.TextInputSession r5 = r2.getInputSession()
            r1.reset(r15, r5)
            r1 = 0
            r5 = r1
            r1 = 0
            r69 = r1
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r1 = 0
            r70 = r10
            r16 = 0
            r71 = r1
            java.lang.Object r1 = r70.rememberedValue()
            r20 = 0
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r72 = r5
            java.lang.Object r5 = r23.getEmpty()
            if (r1 != r5) goto L_0x063d
            r5 = 0
            r73 = r1
            androidx.compose.foundation.text.UndoManager r1 = new androidx.compose.foundation.text.UndoManager
            r74 = r5
            r22 = r8
            r24 = r11
            r5 = 0
            r8 = 0
            r11 = 1
            r1.<init>(r8, r11, r5)
            r5 = r70
            r5.updateRememberedValue(r1)
            goto L_0x0646
        L_0x063d:
            r5 = r70
            r73 = r1
            r22 = r8
            r24 = r11
            r11 = 1
        L_0x0646:
            r10.endReplaceableGroup()
            r8 = r1
            androidx.compose.foundation.text.UndoManager r8 = (androidx.compose.foundation.text.UndoManager) r8
            r1 = 2
            r5 = 0
            r29 = 0
            r69 = r8
            r70 = r67
            r71 = r29
            r73 = r1
            r74 = r5
            androidx.compose.foundation.text.UndoManager.snapshotIfNeeded$default(r69, r70, r71, r73, r74)
            r1 = 0
            r5 = r1
            r1 = 0
            r11 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r11 = 0
            r69 = r10
            r20 = 0
            r70 = r1
            java.lang.Object r1 = r69.rememberedValue()
            r23 = 0
            androidx.compose.runtime.Composer$Companion r27 = androidx.compose.runtime.Composer.Companion
            r71 = r5
            java.lang.Object r5 = r27.getEmpty()
            if (r1 != r5) goto L_0x0692
            r5 = 0
            r72 = r1
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r1 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager
            r1.<init>(r8)
            r5 = r69
            r5.updateRememberedValue(r1)
            goto L_0x0696
        L_0x0692:
            r5 = r69
            r72 = r1
        L_0x0696:
            r10.endReplaceableGroup()
            r11 = r1
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r11 = (androidx.compose.foundation.text.selection.TextFieldSelectionManager) r11
            r11.setOffsetMapping$foundation_release(r9)
            r11.setVisualTransformation$foundation_release(r12)
            kotlin.jvm.functions.Function1 r1 = r2.getOnValueChange()
            r11.setOnValueChange$foundation_release(r1)
            r11.setState$foundation_release(r2)
            r11.setValue$foundation_release(r15)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalClipboardManager()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r5 = 0
            r20 = 0
            r69 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r3)
            java.lang.Object r5 = r10.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.platform.ClipboardManager r5 = (androidx.compose.ui.platform.ClipboardManager) r5
            r11.setClipboardManager$foundation_release(r5)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalTextToolbar()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r5 = 0
            r20 = 0
            r69 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r3)
            java.lang.Object r5 = r10.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.platform.TextToolbar r5 = (androidx.compose.ui.platform.TextToolbar) r5
            r11.setTextToolbar(r5)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalHapticFeedback()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r5 = 0
            r20 = 0
            r69 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r3)
            java.lang.Object r3 = r10.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.hapticfeedback.HapticFeedback r3 = (androidx.compose.ui.hapticfeedback.HapticFeedback) r3
            r11.setHapticFeedBack(r3)
            r11.setFocusRequester(r4)
            r1 = r37 ^ 1
            r11.setEditable(r1)
            r1 = 0
            r3 = r1
            r5 = 0
            r1 = 773894976(0x2e20b340, float:3.6538994E-11)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(rememberCoroutineScope)488@20446L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r10
            r17 = 0
            r20 = r17
            r17 = 0
            r69 = r3
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r3 = 0
            r70 = r10
            r23 = 0
            r71 = r3
            java.lang.Object r3 = r70.rememberedValue()
            r27 = 0
            androidx.compose.runtime.Composer$Companion r29 = androidx.compose.runtime.Composer.Companion
            r72 = r5
            java.lang.Object r5 = r29.getEmpty()
            if (r3 != r5) goto L_0x0767
            r5 = 0
            r29 = 0
            kotlin.coroutines.EmptyCoroutineContext r29 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r73 = r3
            r3 = r29
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
            kotlinx.coroutines.CoroutineScope r3 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r3, r1)
            r74 = r1
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r3)
            r3 = r70
            r3.updateRememberedValue(r1)
            goto L_0x076f
        L_0x0767:
            r74 = r1
            r73 = r3
            r3 = r70
            r1 = r73
        L_0x076f:
            r10.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
            kotlinx.coroutines.CoroutineScope r3 = r1.getCoroutineScope()
            r10.endReplaceableGroup()
            r78 = r3
            r1 = 0
            r3 = r1
            r1 = 0
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r5 = 0
            r14 = r10
            r17 = 0
            r69 = r1
            java.lang.Object r1 = r14.rememberedValue()
            r20 = 0
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r70 = r3
            java.lang.Object r3 = r23.getEmpty()
            if (r1 != r3) goto L_0x07ac
            r3 = 0
            androidx.compose.foundation.relocation.BringIntoViewRequester r3 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.BringIntoViewRequester()
            r14.updateRememberedValue(r3)
            goto L_0x07ad
        L_0x07ac:
            r3 = r1
        L_0x07ad:
            r10.endReplaceableGroup()
            r46 = r3
            androidx.compose.foundation.relocation.BringIntoViewRequester r46 = (androidx.compose.foundation.relocation.BringIntoViewRequester) r46
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1 r3 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
            r69 = r3
            r70 = r2
            r71 = r0
            r72 = r6
            r73 = r37
            r74 = r67
            r75 = r7
            r76 = r9
            r77 = r11
            r79 = r46
            r69.<init>(r70, r71, r72, r73, r74, r75, r76, r77, r78, r79)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r14 = r26
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.textFieldFocusModifier(r1, r6, r4, r14, r3)
            r1 = -55008004(0xfffffffffcb8a4fc, float:-7.669831E36)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "332@16284L42,333@16335L990"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            if (r0 == 0) goto L_0x0822
            if (r6 == 0) goto L_0x07f1
            if (r37 != 0) goto L_0x07f1
            r1 = 1
            goto L_0x07f2
        L_0x07f1:
            r1 = 0
        L_0x07f2:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r3 = 0
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r1, r10, r3)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2 r17 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2
            r20 = 0
            r69 = r17
            r70 = r2
            r71 = r1
            r72 = r0
            r73 = r67
            r74 = r7
            r75 = r9
            r76 = r20
            r69.<init>(r70, r71, r72, r73, r74, r75, r76)
            r75 = r0
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r69 = r1
            r1 = 70
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r3, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r0, (androidx.compose.runtime.Composer) r10, (int) r1)
            goto L_0x0824
        L_0x0822:
            r75 = r0
        L_0x0824:
            r10.endReplaceableGroup()
            boolean r0 = androidx.compose.foundation.text.TouchMode_androidKt.isInTouchMode()
            if (r0 == 0) goto L_0x086b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.text.TextDragObserver r1 = r11.getTouchSelectionObserver$foundation_release()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.longPressDragGestureFilter(r0, r1, r6)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1 r3 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1
            r69 = r3
            r70 = r2
            r71 = r4
            r72 = r37
            r73 = r11
            r74 = r9
            r69.<init>(r70, r71, r72, r73, r74)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.text.TextFieldPressGestureFilterKt.tapPressTextFieldModifier(r1, r14, r6, r3)
            androidx.compose.ui.Modifier r1 = r1.then(r0)
            androidx.compose.ui.input.pointer.PointerIcon r3 = androidx.compose.foundation.text.TextPointerIcon_androidKt.getTextPointerIcon()
            r69 = r0
            r76 = r4
            r77 = r5
            r0 = 0
            r4 = 2
            r5 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.input.pointer.PointerIconKt.pointerHoverIcon$default(r1, r3, r5, r4, r0)
            goto L_0x0887
        L_0x086b:
            r76 = r4
            r77 = r5
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.text.selection.MouseSelectionObserver r1 = r11.getMouseSelectionObserver$foundation_release()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.mouseDragGestureDetector(r0, r1, r6)
            androidx.compose.ui.input.pointer.PointerIcon r1 = androidx.compose.foundation.text.TextPointerIcon_androidKt.getTextPointerIcon()
            r3 = 0
            r4 = 2
            r5 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.input.pointer.PointerIconKt.pointerHoverIcon$default(r0, r1, r5, r4, r3)
        L_0x0887:
            r4 = r0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1 r1 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
            r1.<init>(r2, r15, r9)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.ui.Modifier r47 = androidx.compose.ui.draw.DrawModifierKt.drawBehind(r0, r1)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1 r1 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
            r69 = r1
            r70 = r2
            r71 = r6
            r72 = r11
            r73 = r67
            r74 = r9
            r69.<init>(r70, r71, r72, r73, r74)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.ui.Modifier r48 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r0, r1)
            boolean r3 = r12 instanceof androidx.compose.ui.text.input.PasswordVisualTransformation
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r1 = r0
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1 r17 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
            r26 = r14
            r14 = r75
            r0 = r17
            r49 = r18
            r18 = r12
            r12 = r1
            r1 = r7
            r75 = r2
            r16 = r13
            r50 = r21
            r13 = 1
            r2 = r44
            r51 = r3
            r3 = r67
            r52 = r76
            r21 = r5
            r5 = r4
            r4 = r6
            r55 = r77
            r54 = r80
            r56 = r5
            r53 = r19
            r5 = r51
            r57 = r6
            r6 = r37
            r58 = r7
            r7 = r75
            r61 = r8
            r60 = r22
            r59 = r25
            r8 = r9
            r62 = r9
            r63 = r26
            r9 = r11
            r64 = r10
            r10 = r52
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r17
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r12, r13, r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r10 = r57
            if (r10 == 0) goto L_0x0913
            if (r37 != 0) goto L_0x0913
            r1 = r13
            goto L_0x0915
        L_0x0913:
            r1 = r21
        L_0x0915:
            r69 = r0
            r70 = r75
            r71 = r67
            r72 = r62
            r73 = r33
            r74 = r1
            androidx.compose.ui.Modifier r20 = androidx.compose.foundation.text.TextFieldCursorKt.cursor(r69, r70, r71, r72, r73, r74)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
            r0.<init>(r11)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = 8
            r9 = r64
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r9, (int) r1)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4
            r7 = r75
            r8 = r58
            r0.<init>(r14, r7, r15, r8)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            int r1 = r53 >> 3
            r1 = r1 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r8, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r9, (int) r1)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            kotlin.jvm.functions.Function1 r4 = r7.getOnValueChange()
            r5 = r37 ^ 1
            r6 = r59
            if (r6 != r13) goto L_0x095b
            r17 = r13
            goto L_0x095d
        L_0x095b:
            r17 = r21
        L_0x095d:
            int r19 = r8.m7216getImeActioneUduSuo()
            r1 = r7
            r2 = r11
            r3 = r67
            r57 = r6
            r6 = r17
            r15 = r7
            r7 = r62
            r58 = r8
            r8 = r61
            r65 = r9
            r9 = r19
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.TextFieldKeyInputKt.m2672textFieldKeyInput2WJ9YEU(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r3 = r16
            r1 = r55
            androidx.compose.ui.Modifier r2 = r3.then(r1)
            r4 = r54
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.text.TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(r2, r15, r4)
            androidx.compose.ui.Modifier r2 = previewKeyEventToDeselectOnBack(r2, r15, r11)
            androidx.compose.ui.Modifier r2 = r2.then(r0)
            r5 = r24
            r6 = r63
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.text.TextFieldScrollKt.textFieldScrollable(r2, r5, r6, r10)
            r7 = r56
            androidx.compose.ui.Modifier r2 = r2.then(r7)
            androidx.compose.ui.Modifier r2 = r2.then(r12)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1 r8 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
            r8.<init>(r15)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r2, r8)
            if (r10 == 0) goto L_0x09c0
            boolean r8 = r15.getHasFocus()
            if (r8 == 0) goto L_0x09c0
            boolean r8 = androidx.compose.foundation.text.TouchMode_androidKt.isInTouchMode()
            if (r8 == 0) goto L_0x09c0
            r21 = r13
        L_0x09c0:
            r8 = r21
            if (r8 == 0) goto L_0x09cf
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt.textFieldMagnifier(r9, r11)
            r23 = r9
            goto L_0x09d5
        L_0x09cf:
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            r23 = r9
        L_0x09d5:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5 r9 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
            r54 = r10
            r10 = r9
            r69 = r11
            r11 = r38
            r56 = r12
            r55 = r18
            r12 = r53
            r70 = r0
            r0 = r13
            r13 = r15
            r59 = r14
            r14 = r31
            r63 = r15
            r15 = r35
            r16 = r57
            r17 = r5
            r18 = r67
            r19 = r55
            r21 = r47
            r22 = r48
            r24 = r46
            r25 = r69
            r26 = r8
            r27 = r37
            r28 = r32
            r29 = r62
            r30 = r39
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            r10 = -374338080(0xffffffffe9b00de0, float:-2.6604558E25)
            r15 = r65
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r10, r0, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9 = 448(0x1c0, float:6.28E-43)
            r10 = r69
            CoreTextFieldRootBox(r2, r10, r0, r15, r9)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0a29
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0a29:
            r20 = r3
            r21 = r6
        L_0x0a2d:
            androidx.compose.runtime.ScopeUpdateScope r14 = r15.endRestartGroup()
            if (r14 != 0) goto L_0x0a36
            r23 = r15
            goto L_0x0a70
        L_0x0a36:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6 r22 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6
            r0 = r22
            r1 = r67
            r2 = r68
            r3 = r20
            r4 = r31
            r5 = r55
            r6 = r32
            r7 = r21
            r8 = r33
            r9 = r34
            r10 = r57
            r11 = r35
            r12 = r58
            r13 = r36
            r66 = r14
            r14 = r54
            r23 = r15
            r15 = r37
            r16 = r38
            r17 = r84
            r18 = r85
            r19 = r86
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r22
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r66
            r1.updateScope(r0)
        L_0x0a70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final boolean CoreTextField$lambda$8(State<Boolean> $writeable$delegate) {
        return ((Boolean) $writeable$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x017d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CoreTextFieldRootBox(androidx.compose.ui.Modifier r25, androidx.compose.foundation.text.selection.TextFieldSelectionManager r26, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, int r29) {
        /*
            r0 = r27
            r1 = -20551815(0xfffffffffec66779, float:-1.318622E38)
            r2 = r28
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r1)
            java.lang.String r3 = "C(CoreTextFieldRootBox)P(2,1)728@32622L95:CoreTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r29
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x001e
            r4 = -1
            java.lang.String r5 = "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:723)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r3, r4, r5)
        L_0x001e:
            r1 = 1
            r4 = r3 & 14
            r4 = r4 | 384(0x180, float:5.38E-43)
            r5 = 0
            r6 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r6)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getTopStart()
            int r7 = r4 >> 3
            r7 = r7 & 14
            int r8 = r4 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            r7 = r7 | r8
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r6, r1, r2, r7)
            int r8 = r4 << 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            r9 = 0
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r10)
            r10 = 0
            int r10 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r10)
            androidx.compose.runtime.CompositionLocalMap r11 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r13 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r25)
            int r14 = r8 << 9
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r14 = r14 | 6
            r15 = 0
            r28 = r1
            androidx.compose.runtime.Applier r1 = r2.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x007b
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x007b:
            r2.startReusableNode()
            boolean r1 = r2.getInserting()
            if (r1 == 0) goto L_0x0088
            r2.createNode(r12)
            goto L_0x008b
        L_0x0088:
            r2.useNode()
        L_0x008b:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m4575constructorimpl(r2)
            r16 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            r18 = r5
            kotlin.jvm.functions.Function2 r5 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r7, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r11, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetCompositeKeyHash()
            r17 = 0
            r19 = r1
            r20 = 0
            boolean r21 = r19.getInserting()
            if (r21 != 0) goto L_0x00cd
            r21 = r6
            java.lang.Object r6 = r19.rememberedValue()
            r22 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 != 0) goto L_0x00ca
            goto L_0x00d1
        L_0x00ca:
            r7 = r19
            goto L_0x00e1
        L_0x00cd:
            r21 = r6
            r22 = r7
        L_0x00d1:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)
            r7 = r19
            r7.updateRememberedValue(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)
            r1.apply(r6, r5)
        L_0x00e1:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r1)
            int r5 = r14 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r13.invoke(r1, r2, r5)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r1)
            int r1 = r14 >> 9
            r1 = r1 & 14
            r5 = r2
            r6 = 0
            r7 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r16 = r1
            java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r7, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r7 = r4 >> 6
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r7 | 6
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r17 = r5
            r19 = 0
            r20 = r1
            r1 = -1087269691(0xffffffffbf3194c5, float:-0.6936763)
            r23 = r4
            java.lang.String r4 = "C729@32678L33:CoreTextField.kt#423gt5"
            r24 = r6
            r6 = r17
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r4)
            int r1 = r3 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 8
            r4 = 0
            r17 = r3
            r3 = -1985516685(0xffffffff89a76b73, float:-4.0304832E-33)
            r6.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(ContextMenuArea)P(1)29@1062L9:ContextMenu.android.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r3)
            int r3 = r1 >> 3
            r3 = r3 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.invoke(r6, r3)
            r6.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0170
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0170:
            androidx.compose.runtime.ScopeUpdateScope r1 = r2.endRestartGroup()
            if (r1 != 0) goto L_0x017d
            r4 = r25
            r5 = r26
            r6 = r29
            goto L_0x018d
        L_0x017d:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextFieldRootBox$2 r3 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextFieldRootBox$2
            r4 = r25
            r5 = r26
            r6 = r29
            r3.<init>(r4, r5, r0, r6)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r1.updateScope(r3)
        L_0x018d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextFieldRootBox(androidx.compose.ui.Modifier, androidx.compose.foundation.text.selection.TextFieldSelectionManager, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier $this$previewKeyEventToDeselectOnBack, TextFieldState state, TextFieldSelectionManager manager) {
        return KeyInputModifierKt.onPreviewKeyEvent($this$previewKeyEventToDeselectOnBack, new CoreTextFieldKt$previewKeyEventToDeselectOnBack$1(state, manager));
    }

    /* access modifiers changed from: private */
    public static final void tapToFocus(TextFieldState state, FocusRequester focusRequester, boolean allowKeyboard) {
        TextInputSession inputSession;
        if (!state.getHasFocus()) {
            focusRequester.requestFocus();
        } else if (allowKeyboard && (inputSession = state.getInputSession()) != null) {
            inputSession.showSoftwareKeyboard();
        }
    }

    /* access modifiers changed from: private */
    public static final void startInputSession(TextInputService textInputService, TextFieldState state, TextFieldValue value, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        state.setInputSession(TextFieldDelegate.Companion.onFocus$foundation_release(textInputService, value, state.getProcessor(), imeOptions, state.getOnValueChange(), state.getOnImeActionPerformed()));
        notifyFocusedRect(state, value, offsetMapping);
    }

    /* access modifiers changed from: private */
    public static final void endInputSession(TextFieldState state) {
        TextInputSession session = state.getInputSession();
        if (session != null) {
            TextFieldDelegate.Companion.onBlur$foundation_release(session, state.getProcessor(), state.getOnValueChange());
        }
        state.setInputSession((TextInputSession) null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester $this$bringSelectionEndIntoView, TextFieldValue value, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> $completion) {
        Rect selectionEndBounds;
        int selectionEndInTransformed = offsetMapping.originalToTransformed(TextRange.m7032getMaximpl(value.m7265getSelectiond9O1mEE()));
        if (selectionEndInTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            selectionEndBounds = textLayoutResult.getBoundingBox(selectionEndInTransformed);
        } else if (selectionEndInTransformed != 0) {
            selectionEndBounds = textLayoutResult.getBoundingBox(selectionEndInTransformed - 1);
        } else {
            selectionEndBounds = new Rect(0.0f, 0.0f, 1.0f, (float) IntSize.m7713getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), (String) null, 0, 24, (Object) null)));
        }
        Object bringIntoView = $this$bringSelectionEndIntoView.bringIntoView(selectionEndBounds, $completion);
        return bringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bringIntoView : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(TextFieldSelectionManager manager, boolean show, Composer $composer, int $changed) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer $composer2 = $composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation($composer2, "C(SelectionToolbarAndHandles)1066@46301L202:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(626339208, $changed, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1047)");
        }
        TextFieldSelectionManager $this$SelectionToolbarAndHandles_u24lambda_u2414 = manager;
        if (show) {
            TextFieldState state$foundation_release = $this$SelectionToolbarAndHandles_u24lambda_u2414.getState$foundation_release();
            TextLayoutResult textLayoutResult = null;
            boolean z = true;
            if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (value = layoutResult.getValue()) == null)) {
                TextLayoutResult textLayoutResult2 = value;
                TextFieldState state$foundation_release2 = $this$SelectionToolbarAndHandles_u24lambda_u2414.getState$foundation_release();
                if (!(state$foundation_release2 != null ? state$foundation_release2.isLayoutResultStale() : true)) {
                    textLayoutResult = value;
                }
            }
            if (textLayoutResult != null) {
                TextLayoutResult it = textLayoutResult;
                if (!TextRange.m7029getCollapsedimpl($this$SelectionToolbarAndHandles_u24lambda_u2414.getValue$foundation_release().m7265getSelectiond9O1mEE())) {
                    int startOffset = $this$SelectionToolbarAndHandles_u24lambda_u2414.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m7035getStartimpl($this$SelectionToolbarAndHandles_u24lambda_u2414.getValue$foundation_release().m7265getSelectiond9O1mEE()));
                    int endOffset = $this$SelectionToolbarAndHandles_u24lambda_u2414.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m7030getEndimpl($this$SelectionToolbarAndHandles_u24lambda_u2414.getValue$foundation_release().m7265getSelectiond9O1mEE()));
                    ResolvedTextDirection startDirection = it.getBidiRunDirection(startOffset);
                    ResolvedTextDirection endDirection = it.getBidiRunDirection(Math.max(endOffset - 1, 0));
                    $composer2.startReplaceableGroup(-498388703);
                    ComposerKt.sourceInformation($composer2, "1059@45978L203");
                    TextFieldState state$foundation_release3 = manager.getState$foundation_release();
                    if (state$foundation_release3 != null && state$foundation_release3.getShowSelectionHandleStart()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, startDirection, manager, $composer2, 518);
                    }
                    $composer2.endReplaceableGroup();
                    TextFieldState state$foundation_release4 = manager.getState$foundation_release();
                    if (state$foundation_release4 == null || !state$foundation_release4.getShowSelectionHandleEnd()) {
                        z = false;
                    }
                    if (z) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, endDirection, manager, $composer2, 518);
                    }
                }
                TextFieldState textFieldState = $this$SelectionToolbarAndHandles_u24lambda_u2414.getState$foundation_release();
                if (textFieldState != null) {
                    if ($this$SelectionToolbarAndHandles_u24lambda_u2414.isTextChanged$foundation_release()) {
                        textFieldState.setShowFloatingToolbar(false);
                    }
                    if (textFieldState.getHasFocus()) {
                        if (textFieldState.getShowFloatingToolbar()) {
                            $this$SelectionToolbarAndHandles_u24lambda_u2414.showSelectionToolbar$foundation_release();
                        } else {
                            $this$SelectionToolbarAndHandles_u24lambda_u2414.hideSelectionToolbar$foundation_release();
                        }
                    }
                }
            }
        } else {
            $this$SelectionToolbarAndHandles_u24lambda_u2414.hideSelectionToolbar$foundation_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$SelectionToolbarAndHandles$2(manager, show, $changed));
        }
    }

    public static final void TextFieldCursorHandle(TextFieldSelectionManager manager, Composer $composer, int $changed) {
        TextDragObserver value$iv$iv;
        Object value$iv$iv2;
        TextFieldSelectionManager textFieldSelectionManager = manager;
        int i = $changed;
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "manager");
        Composer $composer2 = $composer.startRestartGroup(-1436003720);
        ComposerKt.sourceInformation($composer2, "C(TextFieldCursorHandle)1092@47346L50,1093@47459L7,1100@47716L205,1094@47476L483:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1436003720, i, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1090)");
        }
        TextFieldState state$foundation_release = manager.getState$foundation_release();
        if (state$foundation_release != null && state$foundation_release.getShowCursorHandle()) {
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed((Object) textFieldSelectionManager);
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = manager.cursorDragObserver$foundation_release();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            TextDragObserver observer = value$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            long position = textFieldSelectionManager.m2842getCursorPositiontuRUvjQ$foundation_release((Density) consume);
            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) observer, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new CoreTextFieldKt$TextFieldCursorHandle$1(observer, (Continuation<? super CoreTextFieldKt$TextFieldCursorHandle$1>) null));
            Object key1$iv = Offset.m4702boximpl(position);
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer2.changed(key1$iv);
            Composer $this$cache$iv$iv2 = $composer2;
            Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv2 == Composer.Companion.getEmpty()) {
                value$iv$iv2 = (Function1) new CoreTextFieldKt$TextFieldCursorHandle$2$1(position);
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            AndroidCursorHandle_androidKt.m2585CursorHandleULxng0E(position, SemanticsModifierKt.semantics$default(pointerInput, false, (Function1) value$iv$iv2, 1, (Object) null), (Function2<? super Composer, ? super Integer, Unit>) null, $composer2, 384);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$TextFieldCursorHandle$3(textFieldSelectionManager, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void notifyFocusedRect(TextFieldState state, TextFieldValue value, OffsetMapping offsetMapping) {
        Snapshot previous$iv$iv;
        Snapshot snapshot$iv = Snapshot.Companion.createNonObservableSnapshot();
        Snapshot this_$iv$iv = snapshot$iv;
        try {
            previous$iv$iv = this_$iv$iv.makeCurrent();
            TextLayoutResultProxy layoutResult = state.getLayoutResult();
            if (layoutResult != null) {
                TextInputSession inputSession = state.getInputSession();
                if (inputSession != null) {
                    LayoutCoordinates layoutCoordinates = state.getLayoutCoordinates();
                    if (layoutCoordinates != null) {
                        TextFieldDelegate.Companion.notifyFocusedRect$foundation_release(value, state.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, state.getHasFocus(), offsetMapping);
                        Unit unit = Unit.INSTANCE;
                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                        snapshot$iv.dispose();
                        return;
                    }
                }
            }
            try {
                this_$iv$iv.restoreCurrent(previous$iv$iv);
                snapshot$iv.dispose();
            } catch (Throwable th) {
                th = th;
                snapshot$iv.dispose();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            snapshot$iv.dispose();
            throw th;
        }
    }
}

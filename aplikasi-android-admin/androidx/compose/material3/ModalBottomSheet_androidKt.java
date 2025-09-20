package androidx.compose.material3;

import android.view.View;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u001a\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a¨\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001aq\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020\u000726\u0010 \u001a2\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110%¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010!2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\u0013H\u0003\u001a6\u0010(\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0011H\u0001¢\u0006\u0002\u0010)\u001a3\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010,\u001a\u00020-H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/\u001a-\u00100\u001a\u00020\u00072\b\b\u0002\u00101\u001a\u00020-2\u0014\b\u0002\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020-0\u0013H\u0007¢\u0006\u0002\u00103\u001aX\u00104\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u00106\u001a\u00020%2,\u00107\u001a(\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u00110%¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b\u0015H\u0003\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00069"}, d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-xOkiWaM", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;Landroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "ModalBottomSheet-EP0qOeE", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;Landroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetAnchorChangeHandler", "Landroidx/compose/material3/AnchorChangeHandler;", "Landroidx/compose/material3/SheetValue;", "state", "animateTo", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "target", "", "velocity", "snapTo", "ModalBottomSheetPopup", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Scrim", "color", "visible", "", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "modalBottomSheetSwipeable", "anchorChangeHandler", "screenHeight", "onDragStopped", "Lkotlinx/coroutines/CoroutineScope;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
public final class ModalBottomSheet_androidKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x03bb  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0414  */
    /* renamed from: ModalBottomSheet-EP0qOeE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m3564ModalBottomSheetEP0qOeE(kotlin.jvm.functions.Function0<kotlin.Unit> r38, androidx.compose.ui.Modifier r39, androidx.compose.material3.SheetState r40, androidx.compose.ui.graphics.Shape r41, long r42, long r44, float r46, long r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, androidx.compose.foundation.layout.WindowInsets r50, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, int r53, int r54, int r55) {
        /*
            r15 = r38
            r14 = r51
            r13 = r53
            r12 = r55
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -879758728(0xffffffffcb8ff278, float:-1.886744E7)
            r1 = r52
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ModalBottomSheet)P(5,4,8,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.unit.Dp,6:c#ui.graphics.Color,3,10)125@5985L31,126@6057L13,127@6120L14,128@6162L31,130@6295L10,132@6442L12,135@6525L24,152@7150L507,167@7663L4907,269@12645L41,269@12618L68:ModalBottomSheet.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r53
            r2 = r54
            r3 = r12 & 1
            if (r3 == 0) goto L_0x002c
            r1 = r1 | 6
            goto L_0x003a
        L_0x002c:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x003a
            boolean r3 = r10.changedInstance(r15)
            if (r3 == 0) goto L_0x0038
            r3 = 4
            goto L_0x0039
        L_0x0038:
            r3 = 2
        L_0x0039:
            r1 = r1 | r3
        L_0x003a:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x0043
            r1 = r1 | 48
            r6 = r39
            goto L_0x0058
        L_0x0043:
            r6 = r13 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0056
            r6 = r39
            boolean r7 = r10.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0052
            r7 = 32
            goto L_0x0054
        L_0x0052:
            r7 = 16
        L_0x0054:
            r1 = r1 | r7
            goto L_0x0058
        L_0x0056:
            r6 = r39
        L_0x0058:
            r7 = r13 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0071
            r7 = r12 & 4
            if (r7 != 0) goto L_0x006b
            r7 = r40
            boolean r8 = r10.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x006d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006f
        L_0x006b:
            r7 = r40
        L_0x006d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006f:
            r1 = r1 | r8
            goto L_0x0073
        L_0x0071:
            r7 = r40
        L_0x0073:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x008c
            r8 = r12 & 8
            if (r8 != 0) goto L_0x0086
            r8 = r41
            boolean r9 = r10.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0088
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x008a
        L_0x0086:
            r8 = r41
        L_0x0088:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x008a:
            r1 = r1 | r9
            goto L_0x008e
        L_0x008c:
            r8 = r41
        L_0x008e:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x00a9
            r9 = r12 & 16
            if (r9 != 0) goto L_0x00a3
            r5 = r42
            boolean r9 = r10.changed((long) r5)
            if (r9 == 0) goto L_0x00a5
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a3:
            r5 = r42
        L_0x00a5:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x00a7:
            r1 = r1 | r9
            goto L_0x00ab
        L_0x00a9:
            r5 = r42
        L_0x00ab:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x00c5
            r9 = r12 & 32
            if (r9 != 0) goto L_0x00bf
            r4 = r44
            boolean r6 = r10.changed((long) r4)
            if (r6 == 0) goto L_0x00c1
            r6 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00bf:
            r4 = r44
        L_0x00c1:
            r6 = 65536(0x10000, float:9.18355E-41)
        L_0x00c3:
            r1 = r1 | r6
            goto L_0x00c7
        L_0x00c5:
            r4 = r44
        L_0x00c7:
            r6 = r12 & 64
            if (r6 == 0) goto L_0x00d1
            r11 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r11
            r11 = r46
            goto L_0x00e8
        L_0x00d1:
            r11 = 3670016(0x380000, float:5.142788E-39)
            r11 = r11 & r13
            if (r11 != 0) goto L_0x00e6
            r11 = r46
            boolean r16 = r10.changed((float) r11)
            if (r16 == 0) goto L_0x00e1
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e3
        L_0x00e1:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e3:
            r1 = r1 | r16
            goto L_0x00e8
        L_0x00e6:
            r11 = r46
        L_0x00e8:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x0108
            r9 = r12 & 128(0x80, float:1.794E-43)
            if (r9 != 0) goto L_0x00ff
            r17 = r1
            r0 = r47
            boolean r18 = r10.changed((long) r0)
            if (r18 == 0) goto L_0x0103
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0105
        L_0x00ff:
            r17 = r1
            r0 = r47
        L_0x0103:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x0105:
            r17 = r17 | r18
            goto L_0x010c
        L_0x0108:
            r17 = r1
            r0 = r47
        L_0x010c:
            r9 = r12 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0117
            r19 = 100663296(0x6000000, float:2.4074124E-35)
            r17 = r17 | r19
            r0 = r49
            goto L_0x012f
        L_0x0117:
            r19 = 234881024(0xe000000, float:1.5777218E-30)
            r19 = r13 & r19
            if (r19 != 0) goto L_0x012d
            r0 = r49
            boolean r1 = r10.changedInstance(r0)
            if (r1 == 0) goto L_0x0128
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012a
        L_0x0128:
            r1 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012a:
            r17 = r17 | r1
            goto L_0x012f
        L_0x012d:
            r0 = r49
        L_0x012f:
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r13
            if (r1 != 0) goto L_0x014a
            r1 = r12 & 512(0x200, float:7.175E-43)
            if (r1 != 0) goto L_0x0143
            r1 = r50
            boolean r19 = r10.changed((java.lang.Object) r1)
            if (r19 == 0) goto L_0x0145
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0147
        L_0x0143:
            r1 = r50
        L_0x0145:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0147:
            r17 = r17 | r19
            goto L_0x014c
        L_0x014a:
            r1 = r50
        L_0x014c:
            r0 = r17
            r1 = r12 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0155
            r2 = r2 | 6
            goto L_0x0163
        L_0x0155:
            r1 = r54 & 14
            if (r1 != 0) goto L_0x0163
            boolean r1 = r10.changedInstance(r14)
            if (r1 == 0) goto L_0x0161
            r1 = 4
            goto L_0x0162
        L_0x0161:
            r1 = 2
        L_0x0162:
            r2 = r2 | r1
        L_0x0163:
            r1 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r1 & r0
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r4) goto L_0x0193
            r1 = r2 & 11
            r4 = 2
            if (r1 != r4) goto L_0x0193
            boolean r1 = r10.getSkipping()
            if (r1 != 0) goto L_0x0178
            goto L_0x0193
        L_0x0178:
            r10.skipToGroupEnd()
            r18 = r39
            r21 = r42
            r23 = r44
            r35 = r47
            r26 = r49
            r27 = r50
            r28 = r0
            r52 = r2
            r19 = r7
            r20 = r8
            r25 = r11
            goto L_0x0429
        L_0x0193:
            r10.startDefaults()
            r1 = r13 & 1
            r5 = -458753(0xfffffffffff8ffff, float:NaN)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r4 = 0
            if (r1 == 0) goto L_0x01e2
            boolean r1 = r10.getDefaultsInvalid()
            if (r1 == 0) goto L_0x01a8
            goto L_0x01e2
        L_0x01a8:
            r10.skipToGroupEnd()
            r1 = r12 & 4
            if (r1 == 0) goto L_0x01b1
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x01b1:
            r1 = r12 & 8
            if (r1 == 0) goto L_0x01b7
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x01b7:
            r1 = r12 & 16
            if (r1 == 0) goto L_0x01bd
            r0 = r0 & r16
        L_0x01bd:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x01c2
            r0 = r0 & r5
        L_0x01c2:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x01ca
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r0 = r0 & r1
        L_0x01ca:
            r1 = r12 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x01d2
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r0 = r0 & r1
        L_0x01d2:
            r1 = r39
            r4 = r42
            r35 = r47
            r9 = r50
            r12 = r0
            r3 = r7
            r6 = r44
            r0 = r49
            goto L_0x027a
        L_0x01e2:
            if (r3 == 0) goto L_0x01e9
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x01eb
        L_0x01e9:
            r1 = r39
        L_0x01eb:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x01f8
            r3 = 3
            r5 = 0
            androidx.compose.material3.SheetState r3 = rememberModalBottomSheetState(r4, r5, r10, r4, r3)
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01f9
        L_0x01f8:
            r3 = r7
        L_0x01f9:
            r5 = r12 & 8
            r7 = 6
            if (r5 == 0) goto L_0x0207
            androidx.compose.material3.BottomSheetDefaults r5 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r5 = r5.getExpandedShape(r10, r7)
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0208
        L_0x0207:
            r5 = r8
        L_0x0208:
            r8 = r12 & 16
            if (r8 == 0) goto L_0x0219
            androidx.compose.material3.BottomSheetDefaults r8 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            long r19 = r8.getContainerColor(r10, r7)
            r0 = r0 & r16
            r39 = r5
            r4 = r19
            goto L_0x021d
        L_0x0219:
            r39 = r5
            r4 = r42
        L_0x021d:
            r16 = r12 & 32
            if (r16 == 0) goto L_0x022e
            int r16 = r0 >> 12
            r8 = r16 & 14
            long r19 = androidx.compose.material3.ColorSchemeKt.m3369contentColorForek8zF_U(r4, r10, r8)
            r8 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r8
            goto L_0x0230
        L_0x022e:
            r19 = r44
        L_0x0230:
            if (r6 == 0) goto L_0x0239
            androidx.compose.material3.BottomSheetDefaults r6 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r6 = r6.m3268getElevationD9Ej5fM()
            goto L_0x023a
        L_0x0239:
            r6 = r11
        L_0x023a:
            r8 = r12 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0249
            androidx.compose.material3.BottomSheetDefaults r8 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            long r16 = r8.getScrimColor(r10, r7)
            r8 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r0 = r0 & r8
            goto L_0x024b
        L_0x0249:
            r16 = r47
        L_0x024b:
            if (r9 == 0) goto L_0x0254
            androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt r8 = androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE
            kotlin.jvm.functions.Function2 r8 = r8.m3392getLambda1$material3_release()
            goto L_0x0256
        L_0x0254:
            r8 = r49
        L_0x0256:
            r9 = r12 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x026f
            androidx.compose.material3.BottomSheetDefaults r9 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r7 = r9.getWindowInsets(r10, r7)
            r9 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r0 = r0 & r9
            r12 = r0
            r11 = r6
            r9 = r7
            r0 = r8
            r35 = r16
            r6 = r19
            r8 = r39
            goto L_0x027a
        L_0x026f:
            r9 = r50
            r12 = r0
            r11 = r6
            r0 = r8
            r35 = r16
            r6 = r19
            r8 = r39
        L_0x027a:
            r10.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x028b
            java.lang.String r13 = "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:122)"
            r14 = -879758728(0xffffffffcb8ff278, float:-1.886744E7)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r12, r2, r13)
        L_0x028b:
            r13 = 0
            r14 = r13
            r16 = 0
            r13 = 773894976(0x2e20b340, float:3.6538994E-11)
            r10.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r13)
            r13 = r10
            r17 = 0
            r18 = 0
            r39 = r14
            r14 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r14 = 0
            r40 = r10
            r19 = 0
            r41 = r14
            java.lang.Object r14 = r40.rememberedValue()
            r20 = 0
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r42 = r9
            java.lang.Object r9 = r21.getEmpty()
            if (r14 != r9) goto L_0x02e4
            r9 = 0
            r21 = 0
            kotlin.coroutines.EmptyCoroutineContext r21 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r43 = r9
            r9 = r21
            kotlin.coroutines.CoroutineContext r9 = (kotlin.coroutines.CoroutineContext) r9
            kotlinx.coroutines.CoroutineScope r9 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r9, r13)
            r44 = r13
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r13 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r13.<init>(r9)
            r9 = r13
            r13 = r40
            r13.updateRememberedValue(r9)
            goto L_0x02e9
        L_0x02e4:
            r44 = r13
            r13 = r40
            r9 = r14
        L_0x02e9:
            r10.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r9 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r9
            kotlinx.coroutines.CoroutineScope r13 = r9.getCoroutineScope()
            r10.endReplaceableGroup()
            r9 = r13
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1 r13 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1
            r13.<init>(r3, r9, r15)
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1 r14 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1
            r14.<init>(r9, r3, r15)
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            int r16 = r12 >> 6
            r16 = r16 & 14
            r16 = r16 | 64
            r17 = 0
            r52 = r2
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            boolean r2 = r10.changed((java.lang.Object) r3)
            boolean r18 = r10.changed((java.lang.Object) r9)
            r2 = r2 | r18
            r39 = r10
            r18 = 0
            r40 = r0
            java.lang.Object r0 = r39.rememberedValue()
            r19 = 0
            if (r2 != 0) goto L_0x0345
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r41 = r2
            java.lang.Object r2 = r20.getEmpty()
            if (r0 != r2) goto L_0x0340
            goto L_0x0347
        L_0x0340:
            r2 = r39
            r43 = r0
            goto L_0x0366
        L_0x0345:
            r41 = r2
        L_0x0347:
            r2 = 0
            r43 = r0
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$anchorChangeHandler$1$1 r0 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$anchorChangeHandler$1$1
            r0.<init>(r9, r3)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r44 = r2
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$anchorChangeHandler$1$2 r2 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$anchorChangeHandler$1$2
            r2.<init>(r3, r9)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.material3.AnchorChangeHandler r0 = ModalBottomSheetAnchorChangeHandler(r3, r0, r2)
            r2 = r39
            r2.updateRememberedValue(r0)
        L_0x0366:
            r10.endReplaceableGroup()
            androidx.compose.material3.AnchorChangeHandler r0 = (androidx.compose.material3.AnchorChangeHandler) r0
            r23 = r0
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1 r2 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1
            r2.<init>(r3, r9, r15)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r39 = r0
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2 r0 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2
            r16 = r0
            r17 = r35
            r19 = r13
            r20 = r3
            r21 = r12
            r22 = r1
            r24 = r14
            r25 = r8
            r26 = r4
            r28 = r6
            r30 = r11
            r31 = r40
            r32 = r51
            r33 = r52
            r34 = r9
            r16.<init>(r17, r19, r20, r21, r22, r23, r24, r25, r26, r28, r30, r31, r32, r33, r34)
            r41 = r1
            r1 = 1424497392(0x54e81af0, float:7.9750748E12)
            r43 = r4
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r1, r4, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r1 = r12 >> 24
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 384(0x180, float:5.38E-43)
            r4 = r42
            ModalBottomSheetPopup(r2, r4, r0, r10, r1)
            boolean r0 = r3.getHasExpandedState()
            if (r0 == 0) goto L_0x040e
            int r0 = r12 >> 6
            r0 = r0 & 14
            r1 = 0
            r2 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            boolean r2 = r10.changed((java.lang.Object) r3)
            r5 = r10
            r16 = 0
            r42 = r0
            java.lang.Object r0 = r5.rememberedValue()
            r17 = 0
            if (r2 != 0) goto L_0x03ea
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r45 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x03e7
            goto L_0x03ec
        L_0x03e7:
            r46 = r0
            goto L_0x03fe
        L_0x03ea:
            r45 = r1
        L_0x03ec:
            r1 = 0
            r46 = r0
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1 r0 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1
            r47 = r1
            r1 = 0
            r0.<init>(r3, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r5.updateRememberedValue(r0)
        L_0x03fe:
            r10.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r1 = r12 >> 6
            r1 = r1 & 14
            r1 = r1 | 64
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r3, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r0, (androidx.compose.runtime.Composer) r10, (int) r1)
        L_0x040e:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0417
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0417:
            r26 = r40
            r18 = r41
            r21 = r43
            r19 = r3
            r27 = r4
            r23 = r6
            r20 = r8
            r25 = r11
            r28 = r12
        L_0x0429:
            androidx.compose.runtime.ScopeUpdateScope r14 = r10.endRestartGroup()
            if (r14 != 0) goto L_0x0434
            r30 = r52
            r31 = r10
            goto L_0x0466
        L_0x0434:
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$4 r29 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$4
            r0 = r29
            r1 = r38
            r30 = r52
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r7 = r23
            r9 = r25
            r31 = r10
            r10 = r35
            r12 = r26
            r13 = r27
            r37 = r14
            r14 = r51
            r15 = r53
            r16 = r54
            r17 = r55
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r12, r13, r14, r15, r16, r17)
            r0 = r29
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r37
            r1.updateScope(r0)
        L_0x0466:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheet_androidKt.m3564ModalBottomSheetEP0qOeE(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, androidx.compose.ui.graphics.Shape, long, long, float, long, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use ModalBottomSheet overload with windowInset parameter.")
    /* renamed from: ModalBottomSheet-xOkiWaM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m3565ModalBottomSheetxOkiWaM(kotlin.jvm.functions.Function0 r33, androidx.compose.ui.Modifier r34, androidx.compose.material3.SheetState r35, androidx.compose.ui.graphics.Shape r36, long r37, long r39, float r41, long r42, kotlin.jvm.functions.Function2 r44, kotlin.jvm.functions.Function3 r45, androidx.compose.runtime.Composer r46, int r47, int r48) {
        /*
            r14 = r33
            r13 = r45
            r11 = r47
            r9 = r48
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -1311611302(0xffffffffb1d2665a, float:-6.1234404E-9)
            r1 = r46
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ModalBottomSheet)P(5,4,8,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.unit.Dp,6:c#ui.graphics.Color,3)284@12980L31,285@13052L13,286@13115L14,287@13157L31,289@13290L10,292@13437L321:ModalBottomSheet.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r47
            r2 = r9 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            goto L_0x0038
        L_0x002a:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r10.changedInstance(r14)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r9 & 2
            if (r2 == 0) goto L_0x0041
            r1 = r1 | 48
            r3 = r34
            goto L_0x0056
        L_0x0041:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0054
            r3 = r34
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0050
            r4 = 32
            goto L_0x0052
        L_0x0050:
            r4 = 16
        L_0x0052:
            r1 = r1 | r4
            goto L_0x0056
        L_0x0054:
            r3 = r34
        L_0x0056:
            r4 = r11 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006f
            r4 = r9 & 4
            if (r4 != 0) goto L_0x0069
            r4 = r35
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x006b
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006d
        L_0x0069:
            r4 = r35
        L_0x006b:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006d:
            r1 = r1 | r5
            goto L_0x0071
        L_0x006f:
            r4 = r35
        L_0x0071:
            r5 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x008a
            r5 = r9 & 8
            if (r5 != 0) goto L_0x0084
            r5 = r36
            boolean r6 = r10.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0086
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0088
        L_0x0084:
            r5 = r36
        L_0x0086:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0088:
            r1 = r1 | r6
            goto L_0x008c
        L_0x008a:
            r5 = r36
        L_0x008c:
            r6 = 57344(0xe000, float:8.0356E-41)
            r7 = r11 & r6
            if (r7 != 0) goto L_0x00a8
            r7 = r9 & 16
            if (r7 != 0) goto L_0x00a2
            r7 = r37
            boolean r12 = r10.changed((long) r7)
            if (r12 == 0) goto L_0x00a4
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a2:
            r7 = r37
        L_0x00a4:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r1 = r1 | r12
            goto L_0x00aa
        L_0x00a8:
            r7 = r37
        L_0x00aa:
            r12 = 458752(0x70000, float:6.42848E-40)
            r15 = r11 & r12
            if (r15 != 0) goto L_0x00c5
            r15 = r9 & 32
            if (r15 != 0) goto L_0x00bf
            r6 = r39
            boolean r8 = r10.changed((long) r6)
            if (r8 == 0) goto L_0x00c1
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00bf:
            r6 = r39
        L_0x00c1:
            r8 = 65536(0x10000, float:9.18355E-41)
        L_0x00c3:
            r1 = r1 | r8
            goto L_0x00c7
        L_0x00c5:
            r6 = r39
        L_0x00c7:
            r8 = r9 & 64
            r15 = 3670016(0x380000, float:5.142788E-39)
            if (r8 == 0) goto L_0x00d4
            r16 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r16
            r15 = r41
            goto L_0x00ea
        L_0x00d4:
            r16 = r11 & r15
            if (r16 != 0) goto L_0x00e8
            r15 = r41
            boolean r17 = r10.changed((float) r15)
            if (r17 == 0) goto L_0x00e3
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e5
        L_0x00e3:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00e5:
            r1 = r1 | r17
            goto L_0x00ea
        L_0x00e8:
            r15 = r41
        L_0x00ea:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r11 & r17
            if (r18 != 0) goto L_0x010a
            r12 = r9 & 128(0x80, float:1.794E-43)
            if (r12 != 0) goto L_0x0101
            r19 = r1
            r0 = r42
            boolean r20 = r10.changed((long) r0)
            if (r20 == 0) goto L_0x0105
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0101:
            r19 = r1
            r0 = r42
        L_0x0105:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x0107:
            r19 = r19 | r20
            goto L_0x010e
        L_0x010a:
            r19 = r1
            r0 = r42
        L_0x010e:
            r12 = r9 & 256(0x100, float:3.59E-43)
            r21 = 234881024(0xe000000, float:1.5777218E-30)
            if (r12 == 0) goto L_0x011b
            r22 = 100663296(0x6000000, float:2.4074124E-35)
            r19 = r19 | r22
            r0 = r44
            goto L_0x0131
        L_0x011b:
            r22 = r11 & r21
            if (r22 != 0) goto L_0x012f
            r0 = r44
            boolean r1 = r10.changedInstance(r0)
            if (r1 == 0) goto L_0x012a
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012c
        L_0x012a:
            r1 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012c:
            r19 = r19 | r1
            goto L_0x0131
        L_0x012f:
            r0 = r44
        L_0x0131:
            r1 = r9 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x013a
            r1 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0137:
            r19 = r19 | r1
            goto L_0x014b
        L_0x013a:
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r11
            if (r1 != 0) goto L_0x014b
            boolean r1 = r10.changedInstance(r13)
            if (r1 == 0) goto L_0x0148
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0137
        L_0x0148:
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0137
        L_0x014b:
            r1 = r19
            r19 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r1 & r19
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r3) goto L_0x0177
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x015e
            goto L_0x0177
        L_0x015e:
            r10.skipToGroupEnd()
            r19 = r34
            r24 = r37
            r29 = r42
            r31 = r44
            r18 = r1
            r22 = r4
            r23 = r5
            r26 = r6
            r20 = r10
            r28 = r15
            goto L_0x02cd
        L_0x0177:
            r10.startDefaults()
            r0 = r11 & 1
            if (r0 == 0) goto L_0x01d2
            boolean r0 = r10.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0185
            goto L_0x01d2
        L_0x0185:
            r10.skipToGroupEnd()
            r0 = r9 & 4
            if (r0 == 0) goto L_0x018e
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x018e:
            r0 = r9 & 8
            if (r0 == 0) goto L_0x0194
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0194:
            r0 = r9 & 16
            if (r0 == 0) goto L_0x019c
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r0
        L_0x019c:
            r0 = r9 & 32
            if (r0 == 0) goto L_0x01a4
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r0
        L_0x01a4:
            r0 = r9 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01bf
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r0 = r0 & r1
            r19 = r34
            r24 = r37
            r29 = r42
            r31 = r44
            r8 = r0
            r22 = r4
            r23 = r5
            r26 = r6
            r28 = r15
            goto L_0x0266
        L_0x01bf:
            r19 = r34
            r24 = r37
            r29 = r42
            r31 = r44
            r8 = r1
            r22 = r4
            r23 = r5
            r26 = r6
            r28 = r15
            goto L_0x0266
        L_0x01d2:
            if (r2 == 0) goto L_0x01d9
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01db
        L_0x01d9:
            r0 = r34
        L_0x01db:
            r2 = r9 & 4
            if (r2 == 0) goto L_0x01eb
            r2 = 0
            r3 = 3
            r34 = r0
            r0 = 0
            androidx.compose.material3.SheetState r0 = rememberModalBottomSheetState(r0, r2, r10, r0, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01ee
        L_0x01eb:
            r34 = r0
            r0 = r4
        L_0x01ee:
            r2 = r9 & 8
            r3 = 6
            if (r2 == 0) goto L_0x01fc
            androidx.compose.material3.BottomSheetDefaults r2 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getExpandedShape(r10, r3)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x01fd
        L_0x01fc:
            r2 = r5
        L_0x01fd:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x020d
            androidx.compose.material3.BottomSheetDefaults r4 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            long r4 = r4.getContainerColor(r10, r3)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r19
            goto L_0x020f
        L_0x020d:
            r4 = r37
        L_0x020f:
            r19 = r9 & 32
            if (r19 == 0) goto L_0x021f
            int r19 = r1 >> 12
            r3 = r19 & 14
            long r6 = androidx.compose.material3.ColorSchemeKt.m3369contentColorForek8zF_U(r4, r10, r3)
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r3
        L_0x021f:
            if (r8 == 0) goto L_0x0228
            androidx.compose.material3.BottomSheetDefaults r3 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r3 = r3.m3268getElevationD9Ej5fM()
            goto L_0x0229
        L_0x0228:
            r3 = r15
        L_0x0229:
            r8 = r9 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0239
            androidx.compose.material3.BottomSheetDefaults r8 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            r15 = 6
            long r22 = r8.getScrimColor(r10, r15)
            r8 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r8
            goto L_0x023b
        L_0x0239:
            r22 = r42
        L_0x023b:
            if (r12 == 0) goto L_0x0255
            androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt r8 = androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE
            kotlin.jvm.functions.Function2 r8 = r8.m3393getLambda2$material3_release()
            r19 = r34
            r28 = r3
            r24 = r4
            r26 = r6
            r31 = r8
            r29 = r22
            r22 = r0
            r8 = r1
            r23 = r2
            goto L_0x0266
        L_0x0255:
            r19 = r34
            r31 = r44
            r8 = r1
            r28 = r3
            r24 = r4
            r26 = r6
            r29 = r22
            r22 = r0
            r23 = r2
        L_0x0266:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0278
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)"
            r2 = -1311611302(0xffffffffb1d2665a, float:-6.1234404E-9)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r8, r0, r1)
        L_0x0278:
            r0 = r8 & 14
            r1 = r8 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r8 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r8 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r8
            r0 = r0 | r1
            r1 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r8
            r0 = r0 | r1
            r1 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r8
            r0 = r0 | r1
            r1 = r8 & r17
            r0 = r0 | r1
            r1 = r8 & r21
            r15 = r0 | r1
            int r0 = r8 >> 27
            r16 = r0 & 14
            r12 = 0
            r17 = 512(0x200, float:7.175E-43)
            r0 = r33
            r1 = r19
            r2 = r22
            r3 = r23
            r4 = r24
            r6 = r26
            r18 = r8
            r8 = r28
            r20 = r10
            r9 = r29
            r11 = r31
            r13 = r45
            r14 = r20
            m3564ModalBottomSheetEP0qOeE(r0, r1, r2, r3, r4, r6, r8, r9, r11, r12, r13, r14, r15, r16, r17)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02cd
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02cd:
            androidx.compose.runtime.ScopeUpdateScope r15 = r20.endRestartGroup()
            if (r15 != 0) goto L_0x02d4
            goto L_0x02fe
        L_0x02d4:
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$5 r16 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$5
            r0 = r16
            r1 = r33
            r2 = r19
            r3 = r22
            r4 = r23
            r5 = r24
            r7 = r26
            r9 = r28
            r10 = r29
            r12 = r31
            r13 = r45
            r14 = r47
            r32 = r15
            r15 = r48
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r12, r13, r14, r15)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r32
            r1.updateScope(r0)
        L_0x02fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheet_androidKt.m3565ModalBottomSheetxOkiWaM(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, androidx.compose.ui.graphics.Shape, long, long, float, long, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final SheetState rememberModalBottomSheetState(boolean skipPartiallyExpanded, Function1<? super SheetValue, Boolean> confirmValueChange, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-1261794383);
        ComposerKt.sourceInformation($composer, "C(rememberModalBottomSheetState)P(1)318@14402L69:ModalBottomSheet.android.kt#uh7d8r");
        if ((i & 1) != 0) {
            skipPartiallyExpanded = false;
        }
        if ((i & 2) != 0) {
            confirmValueChange = ModalBottomSheet_androidKt$rememberModalBottomSheetState$1.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1261794383, $changed, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.android.kt:315)");
        }
        SheetState rememberSheetState = SheetDefaultsKt.rememberSheetState(skipPartiallyExpanded, confirmValueChange, SheetValue.Hidden, false, $composer, ($changed & 14) | 384 | ($changed & 112), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberSheetState;
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M  reason: not valid java name */
    public static final void m3566Scrim3JVO9M(long color, Function0<Unit> onDismissRequest, boolean visible, Composer $composer, int $changed) {
        Modifier dismissSheet;
        Object value$iv$iv;
        long j = color;
        Function0<Unit> function0 = onDismissRequest;
        boolean z = visible;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(1053897700);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color)327@14631L121,346@15192L62,342@15086L168:ModalBottomSheet.android.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed(j) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed(z) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1053897700, $dirty2, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.android.kt:321)");
            }
            if (color != Color.Companion.m4999getUnspecified0d7_KjU()) {
                State alpha$delegate = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null), 0.0f, (String) null, (Function1<? super Float, Unit>) null, $composer2, 48, 28);
                $composer2.startReplaceableGroup(-1858721447);
                ComposerKt.sourceInformation($composer2, "333@14864L124");
                if (z) {
                    Modifier modifier = Modifier.Companion;
                    int i2 = ($dirty2 >> 3) & 14;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed((Object) function0);
                    Composer $this$cache$iv$iv = $composer2;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = (Function2) new ModalBottomSheet_androidKt$Scrim$dismissSheet$1$1(function0, (Continuation<? super ModalBottomSheet_androidKt$Scrim$dismissSheet$1$1>) null);
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        Composer composer = $this$cache$iv$iv;
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    dismissSheet = SemanticsModifierKt.clearAndSetSemantics(SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv), ModalBottomSheet_androidKt$Scrim$dismissSheet$2.INSTANCE);
                } else {
                    dismissSheet = Modifier.Companion;
                }
                $composer2.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(dismissSheet);
                Object r3 = Color.m4953boximpl(color);
                int i3 = $dirty2 & 14;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer2.changed(r3) | $composer2.changed((Object) alpha$delegate);
                Composer $this$cache$iv$iv2 = $composer2;
                Modifier modifier2 = dismissSheet;
                Object value$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
                if (!invalid$iv$iv2) {
                    Color color2 = r3;
                    if (value$iv$iv2 != Composer.Companion.getEmpty()) {
                        Object obj = value$iv$iv2;
                        $composer2.endReplaceableGroup();
                        CanvasKt.Canvas(then, (Function1) value$iv$iv2, $composer2, 0);
                    }
                } else {
                    Object key1$iv = r3;
                }
                Object obj2 = value$iv$iv2;
                value$iv$iv2 = new ModalBottomSheet_androidKt$Scrim$1$1(j, alpha$delegate);
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
                $composer2.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) value$iv$iv2, $composer2, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i4 = $dirty2;
            Composer composer2 = $composer2;
            return;
        }
        int i5 = $dirty2;
        Composer composer3 = $composer2;
        endRestartGroup.updateScope(new ModalBottomSheet_androidKt$Scrim$2(color, onDismissRequest, visible, $changed));
    }

    /* access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$2(State<Float> $alpha$delegate) {
        return ((Number) $alpha$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final Modifier modalBottomSheetSwipeable(Modifier $this$modalBottomSheetSwipeable, SheetState sheetState, AnchorChangeHandler<SheetValue> anchorChangeHandler, float screenHeight, Function2<? super CoroutineScope, ? super Float, Unit> onDragStopped) {
        SheetState sheetState2 = sheetState;
        AnchorChangeHandler<SheetValue> anchorChangeHandler2 = anchorChangeHandler;
        return SwipeableV2Kt.swipeAnchors(DraggableKt.draggable$default($this$modalBottomSheetSwipeable, sheetState.getSwipeableState$material3_release().getSwipeDraggableState$material3_release(), Orientation.Vertical, sheetState.isVisible(), (MutableInteractionSource) null, sheetState.getSwipeableState$material3_release().isAnimationRunning(), (Function3) null, new ModalBottomSheet_androidKt$modalBottomSheetSwipeable$1(onDragStopped), false, 168, (Object) null), sheetState.getSwipeableState$material3_release(), SetsKt.setOf(SheetValue.Hidden, SheetValue.PartiallyExpanded, SheetValue.Expanded), anchorChangeHandler, new ModalBottomSheet_androidKt$modalBottomSheetSwipeable$2(screenHeight, sheetState));
    }

    /* access modifiers changed from: private */
    public static final AnchorChangeHandler<SheetValue> ModalBottomSheetAnchorChangeHandler(SheetState state, Function2<? super SheetValue, ? super Float, Unit> animateTo, Function1<? super SheetValue, Unit> snapTo) {
        return new ModalBottomSheet_androidKt$ModalBottomSheetAnchorChangeHandler$1(state, animateTo, snapTo);
    }

    public static final void ModalBottomSheetPopup(Function0<Unit> onDismissRequest, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Object value$iv$iv;
        Function0<Unit> function0 = onDismissRequest;
        WindowInsets windowInsets2 = windowInsets;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i = $changed;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(windowInsets2, "windowInsets");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-627217336);
        ComposerKt.sourceInformation($composer2, "C(ModalBottomSheetPopup)P(1,2)420@17875L7,421@17896L38,422@17963L28,423@18018L29,424@18081L621,446@18708L217:ModalBottomSheet.android.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed((Object) windowInsets2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-627217336, $dirty2, -1, "androidx.compose.material3.ModalBottomSheetPopup (ModalBottomSheet.android.kt:415)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(AndroidCompositionLocals_androidKt.getLocalView());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            View view = (View) consume;
            UUID id = (UUID) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, ModalBottomSheet_androidKt$ModalBottomSheetPopup$id$1.INSTANCE, $composer2, 3080, 6);
            CompositionContext parentComposition = ComposablesKt.rememberCompositionContext($composer2, 0);
            State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, $composer2, ($dirty2 >> 6) & 14);
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                Object $this$ModalBottomSheetPopup_u24lambda_u247_u24lambda_u246 = new ModalBottomSheetWindow(function0, view, id);
                View view2 = view;
                UUID uuid = id;
                State<T> state = rememberUpdatedState;
                $this$ModalBottomSheetPopup_u24lambda_u247_u24lambda_u246.setCustomContent(parentComposition, ComposableLambdaKt.composableLambdaInstance(861223805, true, new ModalBottomSheet_androidKt$ModalBottomSheetPopup$modalBottomSheetWindow$1$1$1(windowInsets2, rememberUpdatedState)));
                value$iv$iv = $this$ModalBottomSheetPopup_u24lambda_u247_u24lambda_u246;
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                UUID uuid2 = id;
                State<T> state2 = rememberUpdatedState;
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            ModalBottomSheetWindow modalBottomSheetWindow = (ModalBottomSheetWindow) value$iv$iv;
            EffectsKt.DisposableEffect((Object) modalBottomSheetWindow, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new ModalBottomSheet_androidKt$ModalBottomSheetPopup$1(modalBottomSheetWindow), $composer2, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ModalBottomSheet_androidKt$ModalBottomSheetPopup$2(function0, windowInsets2, function2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ModalBottomSheetPopup$lambda$5(State<? extends Function2<? super Composer, ? super Integer, Unit>> $currentContent$delegate) {
        return (Function2) $currentContent$delegate.getValue();
    }
}

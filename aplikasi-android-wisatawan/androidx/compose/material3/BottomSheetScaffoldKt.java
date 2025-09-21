package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0017\u001a\u0002\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\u00052\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u00102\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001aq\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020%26\u0010&\u001a2\u0012\u0013\u0012\u00110#¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110+¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010'2!\u0010-\u001a\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\u0003H\u0003\u001aÃ\u0001\u0010.\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\u00052&\u0010/\u001a\"\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052&\u00101\u001a\"\u0012\u0013\u0012\u001102¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00052\u0006\u0010\u000b\u001a\u00020\f2\f\u00104\u001a\b\u0012\u0004\u0012\u00020+0\u00152\u0006\u00105\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00107\u001a\u0001\u00108\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0006\u00109\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00103\u001a\u00020+2\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\f2\u0013\u0010=\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\u00052\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010?\u001a!\u0010@\u001a\u00020\n2\b\b\u0002\u0010A\u001a\u00020%2\b\b\u0002\u0010B\u001a\u00020\u001aH\u0007¢\u0006\u0002\u0010C\u001a7\u0010D\u001a\u00020%2\b\b\u0002\u0010E\u001a\u00020#2\u0014\b\u0002\u0010F\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0002\u0010G\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010H\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006I"}, d2 = {"BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material3/BottomSheetScaffoldState;", "sheetPeekHeight", "Landroidx/compose/ui/unit/Dp;", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetContainerColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetTonalElevation", "sheetShadowElevation", "sheetDragHandle", "Lkotlin/Function0;", "sheetSwipeEnabled", "", "topBar", "snackbarHost", "Landroidx/compose/material3/SnackbarHostState;", "containerColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-6cEcpDs", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/BottomSheetScaffoldState;FLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldAnchorChangeHandler", "Landroidx/compose/material3/AnchorChangeHandler;", "Landroidx/compose/material3/SheetValue;", "state", "Landroidx/compose/material3/SheetState;", "animateTo", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "target", "", "velocity", "snapTo", "BottomSheetScaffoldLayout", "body", "innerPadding", "bottomSheet", "", "layoutHeight", "sheetOffset", "sheetState", "BottomSheetScaffoldLayout-PxNyym8", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetState;JJLandroidx/compose/runtime/Composer;I)V", "StandardBottomSheet", "peekHeight", "shape", "tonalElevation", "shadowElevation", "dragHandle", "StandardBottomSheet-8oydGBM", "(Landroidx/compose/material3/SheetState;FZFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberBottomSheetScaffoldState", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomSheetScaffoldState;", "rememberStandardBottomSheetState", "initialValue", "confirmValueChange", "skipHiddenState", "(Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
public final class BottomSheetScaffoldKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01d3, code lost:
        if (r10.changed(r62) != false) goto L_0x01dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x01f4, code lost:
        if (r10.changed(r64) != false) goto L_0x01fb;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x04b3  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x04da  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x04dd  */
    /* renamed from: BottomSheetScaffold-6cEcpDs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1560BottomSheetScaffold6cEcpDs(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.ui.Modifier r48, androidx.compose.material3.BottomSheetScaffoldState r49, float r50, androidx.compose.ui.graphics.Shape r51, long r52, long r54, float r56, float r57, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, boolean r59, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r60, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r61, long r62, long r64, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r66, androidx.compose.runtime.Composer r67, int r68, int r69, int r70) {
        /*
            r15 = r47
            r14 = r66
            r13 = r68
            r12 = r69
            r11 = r70
            java.lang.String r0 = "sheetContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 144898711(0x8a2fa97, float:9.808934E-34)
            r1 = r67
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BottomSheetScaffold)P(6,3,4,9:c#ui.unit.Dp,11,5:c#ui.graphics.Color,7:c#ui.graphics.Color,13:c#ui.unit.Dp,10:c#ui.unit.Dp,8,12,15,14,0:c#ui.graphics.Color,2:c#ui.graphics.Color)99@5165L34,101@5308L13,102@5376L14,103@5423L36,110@5880L11,111@5927L31,122@6281L50,114@6017L1096:BottomSheetScaffold.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r68
            r2 = r69
            r3 = r11 & 1
            if (r3 == 0) goto L_0x002e
            r1 = r1 | 6
            goto L_0x003c
        L_0x002e:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x003c
            boolean r3 = r10.changedInstance(r15)
            if (r3 == 0) goto L_0x003a
            r3 = 4
            goto L_0x003b
        L_0x003a:
            r3 = 2
        L_0x003b:
            r1 = r1 | r3
        L_0x003c:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0045
            r1 = r1 | 48
            r8 = r48
            goto L_0x005a
        L_0x0045:
            r8 = r13 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0058
            r8 = r48
            boolean r9 = r10.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0054
            r9 = 32
            goto L_0x0056
        L_0x0054:
            r9 = 16
        L_0x0056:
            r1 = r1 | r9
            goto L_0x005a
        L_0x0058:
            r8 = r48
        L_0x005a:
            r9 = r13 & 896(0x380, float:1.256E-42)
            r16 = 256(0x100, float:3.59E-43)
            r17 = 128(0x80, float:1.794E-43)
            if (r9 != 0) goto L_0x0078
            r9 = r11 & 4
            if (r9 != 0) goto L_0x0071
            r9 = r49
            boolean r18 = r10.changed((java.lang.Object) r9)
            if (r18 == 0) goto L_0x0073
            r18 = r16
            goto L_0x0075
        L_0x0071:
            r9 = r49
        L_0x0073:
            r18 = r17
        L_0x0075:
            r1 = r1 | r18
            goto L_0x007a
        L_0x0078:
            r9 = r49
        L_0x007a:
            r18 = r11 & 8
            r19 = 2048(0x800, float:2.87E-42)
            r20 = 1024(0x400, float:1.435E-42)
            if (r18 == 0) goto L_0x0087
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r4 = r50
            goto L_0x009d
        L_0x0087:
            r4 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x009b
            r4 = r50
            boolean r21 = r10.changed((float) r4)
            if (r21 == 0) goto L_0x0096
            r21 = r19
            goto L_0x0098
        L_0x0096:
            r21 = r20
        L_0x0098:
            r1 = r1 | r21
            goto L_0x009d
        L_0x009b:
            r4 = r50
        L_0x009d:
            r21 = 57344(0xe000, float:8.0356E-41)
            r21 = r13 & r21
            r22 = 16384(0x4000, float:2.2959E-41)
            r23 = 8192(0x2000, float:1.14794E-41)
            if (r21 != 0) goto L_0x00be
            r21 = r11 & 16
            if (r21 != 0) goto L_0x00b7
            r5 = r51
            boolean r24 = r10.changed((java.lang.Object) r5)
            if (r24 == 0) goto L_0x00b9
            r24 = r22
            goto L_0x00bb
        L_0x00b7:
            r5 = r51
        L_0x00b9:
            r24 = r23
        L_0x00bb:
            r1 = r1 | r24
            goto L_0x00c0
        L_0x00be:
            r5 = r51
        L_0x00c0:
            r24 = 458752(0x70000, float:6.42848E-40)
            r25 = r13 & r24
            if (r25 != 0) goto L_0x00dc
            r25 = r11 & 32
            if (r25 != 0) goto L_0x00d5
            r6 = r52
            boolean r27 = r10.changed((long) r6)
            if (r27 == 0) goto L_0x00d7
            r27 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d9
        L_0x00d5:
            r6 = r52
        L_0x00d7:
            r27 = 65536(0x10000, float:9.18355E-41)
        L_0x00d9:
            r1 = r1 | r27
            goto L_0x00de
        L_0x00dc:
            r6 = r52
        L_0x00de:
            r27 = 3670016(0x380000, float:5.142788E-39)
            r27 = r13 & r27
            if (r27 != 0) goto L_0x00fe
            r27 = r11 & 64
            if (r27 != 0) goto L_0x00f5
            r28 = r1
            r0 = r54
            boolean r29 = r10.changed((long) r0)
            if (r29 == 0) goto L_0x00f9
            r29 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fb
        L_0x00f5:
            r28 = r1
            r0 = r54
        L_0x00f9:
            r29 = 524288(0x80000, float:7.34684E-40)
        L_0x00fb:
            r28 = r28 | r29
            goto L_0x0102
        L_0x00fe:
            r28 = r1
            r0 = r54
        L_0x0102:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x010d
            r1 = 12582912(0xc00000, float:1.7632415E-38)
            r28 = r28 | r1
            r1 = r56
            goto L_0x0124
        L_0x010d:
            r1 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r13
            if (r1 != 0) goto L_0x0122
            r1 = r56
            boolean r29 = r10.changed((float) r1)
            if (r29 == 0) goto L_0x011d
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x011f
        L_0x011d:
            r29 = 4194304(0x400000, float:5.877472E-39)
        L_0x011f:
            r28 = r28 | r29
            goto L_0x0124
        L_0x0122:
            r1 = r56
        L_0x0124:
            r1 = r11 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x012f
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            r28 = r28 | r29
            r4 = r57
            goto L_0x0147
        L_0x012f:
            r29 = 234881024(0xe000000, float:1.5777218E-30)
            r29 = r13 & r29
            if (r29 != 0) goto L_0x0145
            r4 = r57
            boolean r29 = r10.changed((float) r4)
            if (r29 == 0) goto L_0x0140
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0142
        L_0x0140:
            r29 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0142:
            r28 = r28 | r29
            goto L_0x0147
        L_0x0145:
            r4 = r57
        L_0x0147:
            r4 = r11 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0150
            r29 = 805306368(0x30000000, float:4.656613E-10)
        L_0x014d:
            r28 = r28 | r29
            goto L_0x0166
        L_0x0150:
            r29 = 1879048192(0x70000000, float:1.58456325E29)
            r29 = r13 & r29
            if (r29 != 0) goto L_0x0164
            r5 = r58
            boolean r29 = r10.changedInstance(r5)
            if (r29 == 0) goto L_0x0161
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014d
        L_0x0161:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x014d
        L_0x0164:
            r5 = r58
        L_0x0166:
            r5 = r28
            r6 = r11 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x0171
            r2 = r2 | 6
            r7 = r59
            goto L_0x0187
        L_0x0171:
            r7 = r12 & 14
            if (r7 != 0) goto L_0x0185
            r7 = r59
            boolean r28 = r10.changed((boolean) r7)
            if (r28 == 0) goto L_0x0180
            r21 = 4
            goto L_0x0182
        L_0x0180:
            r21 = 2
        L_0x0182:
            r2 = r2 | r21
            goto L_0x0187
        L_0x0185:
            r7 = r59
        L_0x0187:
            r7 = r11 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x0190
            r2 = r2 | 48
            r8 = r60
            goto L_0x01a6
        L_0x0190:
            r21 = r12 & 112(0x70, float:1.57E-43)
            if (r21 != 0) goto L_0x01a4
            r8 = r60
            boolean r21 = r10.changedInstance(r8)
            if (r21 == 0) goto L_0x019f
            r25 = 32
            goto L_0x01a1
        L_0x019f:
            r25 = 16
        L_0x01a1:
            r2 = r2 | r25
            goto L_0x01a6
        L_0x01a4:
            r8 = r60
        L_0x01a6:
            r8 = r11 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x01af
            r2 = r2 | 384(0x180, float:5.38E-43)
            r9 = r61
            goto L_0x01c3
        L_0x01af:
            r9 = r12 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x01c1
            r9 = r61
            boolean r21 = r10.changedInstance(r9)
            if (r21 == 0) goto L_0x01bc
            goto L_0x01be
        L_0x01bc:
            r16 = r17
        L_0x01be:
            r2 = r2 | r16
            goto L_0x01c3
        L_0x01c1:
            r9 = r61
        L_0x01c3:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x01df
            r9 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r9 != 0) goto L_0x01d6
            r16 = r8
            r8 = r62
            boolean r17 = r10.changed((long) r8)
            if (r17 == 0) goto L_0x01da
            goto L_0x01dc
        L_0x01d6:
            r16 = r8
            r8 = r62
        L_0x01da:
            r19 = r20
        L_0x01dc:
            r2 = r2 | r19
            goto L_0x01e3
        L_0x01df:
            r16 = r8
            r8 = r62
        L_0x01e3:
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x01fe
            r8 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r8 != 0) goto L_0x01f7
            r8 = r64
            boolean r17 = r10.changed((long) r8)
            if (r17 == 0) goto L_0x01f9
            goto L_0x01fb
        L_0x01f7:
            r8 = r64
        L_0x01f9:
            r22 = r23
        L_0x01fb:
            r2 = r2 | r22
            goto L_0x0200
        L_0x01fe:
            r8 = r64
        L_0x0200:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r11 & r17
            if (r17 == 0) goto L_0x020c
            r17 = 196608(0x30000, float:2.75506E-40)
        L_0x0209:
            r2 = r2 | r17
            goto L_0x021c
        L_0x020c:
            r17 = r12 & r24
            if (r17 != 0) goto L_0x021c
            boolean r17 = r10.changedInstance(r14)
            if (r17 == 0) goto L_0x0219
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0209
        L_0x0219:
            r17 = 65536(0x10000, float:9.18355E-41)
            goto L_0x0209
        L_0x021c:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r5 & r17
            r9 = 306783378(0x12492492, float:6.3469493E-28)
            if (r8 != r9) goto L_0x025b
            r8 = 374491(0x5b6db, float:5.24774E-40)
            r8 = r8 & r2
            r9 = 74898(0x12492, float:1.04954E-40)
            if (r8 != r9) goto L_0x025b
            boolean r8 = r10.getSkipping()
            if (r8 != 0) goto L_0x0236
            goto L_0x025b
        L_0x0236:
            r10.skipToGroupEnd()
            r24 = r48
            r25 = r49
            r26 = r50
            r27 = r51
            r28 = r52
            r30 = r54
            r32 = r56
            r33 = r57
            r34 = r58
            r35 = r59
            r36 = r60
            r37 = r61
            r38 = r62
            r40 = r64
            r42 = r2
            r43 = r5
            goto L_0x04d4
        L_0x025b:
            r10.startDefaults()
            r8 = r13 & 1
            r9 = -57345(0xffffffffffff1fff, float:NaN)
            if (r8 == 0) goto L_0x02d7
            boolean r8 = r10.getDefaultsInvalid()
            if (r8 == 0) goto L_0x026d
            goto L_0x02d7
        L_0x026d:
            r10.skipToGroupEnd()
            r0 = r11 & 4
            if (r0 == 0) goto L_0x0276
            r5 = r5 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0276:
            r0 = r11 & 16
            if (r0 == 0) goto L_0x027b
            r5 = r5 & r9
        L_0x027b:
            r0 = r11 & 32
            if (r0 == 0) goto L_0x0283
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r5 = r5 & r0
        L_0x0283:
            r0 = r11 & 64
            if (r0 == 0) goto L_0x028b
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r5 = r5 & r0
        L_0x028b:
            r0 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0291
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0291:
            r0 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x02b7
            r0 = r2 & r9
            r1 = r49
            r8 = r50
            r9 = r51
            r12 = r52
            r17 = r54
            r2 = r56
            r3 = r57
            r4 = r58
            r6 = r60
            r7 = r61
            r19 = r62
            r21 = r64
            r11 = r0
            r14 = r5
            r0 = r48
            r5 = r59
            goto L_0x03c4
        L_0x02b7:
            r0 = r48
            r1 = r49
            r8 = r50
            r9 = r51
            r12 = r52
            r17 = r54
            r3 = r57
            r4 = r58
            r6 = r60
            r7 = r61
            r19 = r62
            r21 = r64
            r11 = r2
            r14 = r5
            r2 = r56
            r5 = r59
            goto L_0x03c4
        L_0x02d7:
            if (r3 == 0) goto L_0x02de
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x02e0
        L_0x02de:
            r3 = r48
        L_0x02e0:
            r8 = r11 & 4
            if (r8 == 0) goto L_0x02f1
            r8 = 0
            r9 = 3
            r48 = r3
            r3 = 0
            r12 = 0
            androidx.compose.material3.BottomSheetScaffoldState r3 = rememberBottomSheetScaffoldState(r3, r12, r10, r8, r9)
            r5 = r5 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x02f5
        L_0x02f1:
            r48 = r3
            r3 = r49
        L_0x02f5:
            if (r18 == 0) goto L_0x02fe
            androidx.compose.material3.BottomSheetDefaults r8 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r8 = r8.m1559getSheetPeekHeightD9Ej5fM()
            goto L_0x0300
        L_0x02fe:
            r8 = r50
        L_0x0300:
            r9 = r11 & 16
            r12 = 6
            if (r9 == 0) goto L_0x0311
            androidx.compose.material3.BottomSheetDefaults r9 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r9 = r9.getExpandedShape(r10, r12)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r5 = r5 & r17
            goto L_0x0313
        L_0x0311:
            r9 = r51
        L_0x0313:
            r17 = r11 & 32
            if (r17 == 0) goto L_0x0326
            r49 = r3
            androidx.compose.material3.BottomSheetDefaults r3 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            long r17 = r3.getContainerColor(r10, r12)
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            r5 = r5 & r3
            r12 = r17
            goto L_0x032a
        L_0x0326:
            r49 = r3
            r12 = r52
        L_0x032a:
            r3 = r11 & 64
            if (r3 == 0) goto L_0x033b
            int r3 = r5 >> 15
            r3 = r3 & 14
            long r17 = androidx.compose.material3.ColorSchemeKt.m1659contentColorForek8zF_U(r12, r10, r3)
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r5 = r5 & r3
            goto L_0x033d
        L_0x033b:
            r17 = r54
        L_0x033d:
            if (r0 == 0) goto L_0x0346
            androidx.compose.material3.BottomSheetDefaults r0 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r0 = r0.m1558getElevationD9Ej5fM()
            goto L_0x0348
        L_0x0346:
            r0 = r56
        L_0x0348:
            if (r1 == 0) goto L_0x0351
            androidx.compose.material3.BottomSheetDefaults r1 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r1 = r1.m1558getElevationD9Ej5fM()
            goto L_0x0353
        L_0x0351:
            r1 = r57
        L_0x0353:
            if (r4 == 0) goto L_0x035c
            androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt r3 = androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1677getLambda1$material3_release()
            goto L_0x035e
        L_0x035c:
            r3 = r58
        L_0x035e:
            if (r6 == 0) goto L_0x0362
            r4 = 1
            goto L_0x0364
        L_0x0362:
            r4 = r59
        L_0x0364:
            if (r7 == 0) goto L_0x0368
            r6 = 0
            goto L_0x036a
        L_0x0368:
            r6 = r60
        L_0x036a:
            if (r16 == 0) goto L_0x0373
            androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt r7 = androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function3 r7 = r7.m1678getLambda2$material3_release()
            goto L_0x0375
        L_0x0373:
            r7 = r61
        L_0x0375:
            r51 = r0
            r0 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x038b
            androidx.compose.material3.MaterialTheme r0 = androidx.compose.material3.MaterialTheme.INSTANCE
            r52 = r1
            r1 = 6
            androidx.compose.material3.ColorScheme r0 = r0.getColorScheme(r10, r1)
            long r0 = r0.m1623getSurface0d7_KjU()
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x038f
        L_0x038b:
            r52 = r1
            r0 = r62
        L_0x038f:
            r50 = r3
            r3 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x03b3
            int r3 = r2 >> 9
            r3 = r3 & 14
            long r19 = androidx.compose.material3.ColorSchemeKt.m1659contentColorForek8zF_U(r0, r10, r3)
            r3 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = r2 & r3
            r3 = r52
            r11 = r2
            r14 = r5
            r21 = r19
            r2 = r51
            r19 = r0
            r5 = r4
            r0 = r48
            r1 = r49
            r4 = r50
            goto L_0x03c4
        L_0x03b3:
            r3 = r52
            r21 = r64
            r19 = r0
            r11 = r2
            r14 = r5
            r0 = r48
            r1 = r49
            r2 = r51
            r5 = r4
            r4 = r50
        L_0x03c4:
            r10.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x03d8
            java.lang.String r15 = "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)"
            r63 = r6
            r6 = 144898711(0x8a2fa97, float:9.808934E-34)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r14, r11, r15)
            goto L_0x03da
        L_0x03d8:
            r63 = r6
        L_0x03da:
            androidx.compose.material3.SheetState r6 = r1.getBottomSheetState()
            androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1 r15 = new androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
            r48 = r15
            r49 = r1
            r50 = r8
            r51 = r5
            r52 = r9
            r53 = r12
            r55 = r17
            r57 = r2
            r58 = r3
            r59 = r4
            r60 = r47
            r61 = r14
            r62 = r11
            r48.<init>(r49, r50, r51, r52, r53, r55, r57, r58, r59, r60, r61, r62)
            r62 = r2
            r2 = 106433656(0x6580c78, float:4.0634245E-35)
            r64 = r3
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r2, r3, r15)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2 r15 = new androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
            r15.<init>(r7, r1, r11)
            r65 = r4
            r4 = -1629779374(0xffffffff9edb8a52, float:-2.3244735E-20)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r4, r3, r15)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            int r4 = r14 >> 6
            r4 = r4 & 14
            r15 = 0
            r48 = r4
            r4 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r4)
            boolean r4 = r10.changed((java.lang.Object) r1)
            r49 = r10
            r16 = 0
            r67 = r5
            java.lang.Object r5 = r49.rememberedValue()
            r23 = 0
            if (r4 != 0) goto L_0x0454
            androidx.compose.runtime.Composer$Companion r25 = androidx.compose.runtime.Composer.Companion
            r50 = r4
            java.lang.Object r4 = r25.getEmpty()
            if (r5 != r4) goto L_0x044e
            goto L_0x0456
        L_0x044e:
            r25 = r1
            r4 = r5
            r1 = r49
            goto L_0x0469
        L_0x0454:
            r50 = r4
        L_0x0456:
            r4 = 0
            r51 = r4
            androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1 r4 = new androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1
            r4.<init>(r1)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r25 = r1
            r1 = r49
            r1.updateRememberedValue(r4)
        L_0x0469:
            r10.endReplaceableGroup()
            r1 = r4
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            int r4 = r14 >> 3
            r4 = r4 & 14
            r4 = r4 | 27648(0x6c00, float:3.8743E-41)
            r5 = r11 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            int r5 = r11 >> 9
            r5 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r5
            int r5 = r14 << 6
            r5 = r5 & r24
            r4 = r4 | r5
            int r5 = r11 << 15
            r15 = 234881024(0xe000000, float:1.5777218E-30)
            r5 = r5 & r15
            r4 = r4 | r5
            r5 = 1879048192(0x70000000, float:1.58456325E29)
            int r15 = r11 << 15
            r5 = r5 & r15
            r4 = r4 | r5
            r48 = r0
            r49 = r63
            r50 = r66
            r51 = r2
            r52 = r3
            r53 = r8
            r54 = r1
            r55 = r6
            r56 = r19
            r58 = r21
            r60 = r10
            r61 = r4
            m1561BottomSheetScaffoldLayoutPxNyym8(r48, r49, r50, r51, r52, r53, r54, r55, r56, r58, r60, r61)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x04b6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04b6:
            r32 = r62
            r36 = r63
            r33 = r64
            r34 = r65
            r35 = r67
            r24 = r0
            r37 = r7
            r26 = r8
            r27 = r9
            r42 = r11
            r28 = r12
            r43 = r14
            r30 = r17
            r38 = r19
            r40 = r21
        L_0x04d4:
            androidx.compose.runtime.ScopeUpdateScope r15 = r10.endRestartGroup()
            if (r15 != 0) goto L_0x04dd
            r45 = r10
            goto L_0x0517
        L_0x04dd:
            androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$4 r44 = new androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$4
            r0 = r44
            r1 = r47
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r8 = r30
            r45 = r10
            r10 = r32
            r11 = r33
            r12 = r34
            r13 = r35
            r14 = r36
            r46 = r15
            r15 = r37
            r16 = r38
            r18 = r40
            r20 = r66
            r21 = r68
            r22 = r69
            r23 = r70
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16, r18, r20, r21, r22, r23)
            r0 = r44
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r46
            r1.updateScope(r0)
        L_0x0517:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt.m1560BottomSheetScaffold6cEcpDs(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material3.BottomSheetScaffoldState, float, androidx.compose.ui.graphics.Shape, long, long, float, float, kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(SheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        $composer.startReplaceableGroup(-1474606134);
        ComposerKt.sourceInformation($composer, "C(rememberBottomSheetScaffoldState)167@7874L34,168@7953L32,170@8027L196:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 1) != 0) {
            bottomSheetState = rememberStandardBottomSheetState((SheetValue) null, (Function1<? super SheetValue, Boolean>) null, false, $composer, 0, 7);
        }
        if ((i & 2) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv2 = new SnackbarHostState();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) value$iv$iv2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1474606134, $changed, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:166)");
        }
        int i2 = ($changed & 14) | ($changed & 112);
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) bottomSheetState) | $composer.changed((Object) snackbarHostState);
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv = new BottomSheetScaffoldState(bottomSheetState, snackbarHostState);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    public static final SheetState rememberStandardBottomSheetState(SheetValue initialValue, Function1<? super SheetValue, Boolean> confirmValueChange, boolean skipHiddenState, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(678511581);
        ComposerKt.sourceInformation($composer, "C(rememberStandardBottomSheetState)P(1)192@8853L76:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialValue = SheetValue.PartiallyExpanded;
        }
        if ((i & 2) != 0) {
            confirmValueChange = BottomSheetScaffoldKt$rememberStandardBottomSheetState$1.INSTANCE;
        }
        if ((i & 4) != 0) {
            skipHiddenState = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(678511581, $changed, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:188)");
        }
        SheetState rememberSheetState = SheetDefaultsKt.rememberSheetState(false, confirmValueChange, initialValue, skipHiddenState, $composer, ($changed & 112) | 6 | (($changed << 6) & 896) | (($changed << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberSheetState;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x038e  */
    /* renamed from: StandardBottomSheet-8oydGBM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1562StandardBottomSheet8oydGBM(androidx.compose.material3.SheetState r34, float r35, boolean r36, float r37, androidx.compose.ui.graphics.Shape r38, long r39, long r41, float r43, float r44, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, androidx.compose.runtime.Composer r47, int r48, int r49) {
        /*
            r15 = r34
            r14 = r35
            r13 = r37
            r12 = r48
            r0 = -763942484(0xffffffffd27729ac, float:-2.65389015E11)
            r1 = r47
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(StandardBottomSheet)P(9,5:c#ui.unit.Dp,8,4,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,10:c#ui.unit.Dp,6:c#ui.unit.Dp,3)209@9346L24,*210@9412L7,214@9580L467,235@10256L318,252@10976L530,229@10052L3768:BottomSheetScaffold.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r48
            r2 = r49
            r3 = r12 & 14
            r4 = 4
            if (r3 != 0) goto L_0x0029
            boolean r3 = r11.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x0027
            r3 = r4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r1 = r1 | r3
        L_0x0029:
            r3 = r12 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0039
            boolean r3 = r11.changed((float) r14)
            if (r3 == 0) goto L_0x0036
            r3 = 32
            goto L_0x0038
        L_0x0036:
            r3 = 16
        L_0x0038:
            r1 = r1 | r3
        L_0x0039:
            r3 = r12 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x004c
            r10 = r36
            boolean r3 = r11.changed((boolean) r10)
            if (r3 == 0) goto L_0x0048
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x004a
        L_0x0048:
            r3 = 128(0x80, float:1.794E-43)
        L_0x004a:
            r1 = r1 | r3
            goto L_0x004e
        L_0x004c:
            r10 = r36
        L_0x004e:
            r3 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x005e
            boolean r3 = r11.changed((float) r13)
            if (r3 == 0) goto L_0x005b
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x005d
        L_0x005b:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x005d:
            r1 = r1 | r3
        L_0x005e:
            r8 = 57344(0xe000, float:8.0356E-41)
            r3 = r12 & r8
            if (r3 != 0) goto L_0x0074
            r9 = r38
            boolean r3 = r11.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x0070
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0072
        L_0x0070:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x0072:
            r1 = r1 | r3
            goto L_0x0076
        L_0x0074:
            r9 = r38
        L_0x0076:
            r24 = 458752(0x70000, float:6.42848E-40)
            r3 = r12 & r24
            if (r3 != 0) goto L_0x008b
            r6 = r39
            boolean r3 = r11.changed((long) r6)
            if (r3 == 0) goto L_0x0087
            r3 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0089
        L_0x0087:
            r3 = 65536(0x10000, float:9.18355E-41)
        L_0x0089:
            r1 = r1 | r3
            goto L_0x008d
        L_0x008b:
            r6 = r39
        L_0x008d:
            r3 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r12
            if (r3 != 0) goto L_0x00a1
            r8 = r41
            boolean r3 = r11.changed((long) r8)
            if (r3 == 0) goto L_0x009d
            r3 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x009f
        L_0x009d:
            r3 = 524288(0x80000, float:7.34684E-40)
        L_0x009f:
            r1 = r1 | r3
            goto L_0x00a3
        L_0x00a1:
            r8 = r41
        L_0x00a3:
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r12
            if (r3 != 0) goto L_0x00b8
            r3 = r43
            boolean r16 = r11.changed((float) r3)
            if (r16 == 0) goto L_0x00b3
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00b5
        L_0x00b3:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00b5:
            r1 = r1 | r16
            goto L_0x00ba
        L_0x00b8:
            r3 = r43
        L_0x00ba:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00d0
            r0 = r44
            boolean r17 = r11.changed((float) r0)
            if (r17 == 0) goto L_0x00cb
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00cd
        L_0x00cb:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00cd:
            r1 = r1 | r17
            goto L_0x00d2
        L_0x00d0:
            r0 = r44
        L_0x00d2:
            r17 = 1879048192(0x70000000, float:1.58456325E29)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x00e8
            r5 = r45
            boolean r18 = r11.changedInstance(r5)
            if (r18 == 0) goto L_0x00e3
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00e5
        L_0x00e3:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00e5:
            r1 = r1 | r18
            goto L_0x00ea
        L_0x00e8:
            r5 = r45
        L_0x00ea:
            r18 = r49 & 14
            if (r18 != 0) goto L_0x00fa
            r12 = r46
            boolean r18 = r11.changedInstance(r12)
            if (r18 == 0) goto L_0x00f7
            goto L_0x00f8
        L_0x00f7:
            r4 = 2
        L_0x00f8:
            r2 = r2 | r4
            goto L_0x00fc
        L_0x00fa:
            r12 = r46
        L_0x00fc:
            r4 = r2
            r2 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r2 & r1
            r0 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r0) goto L_0x011b
            r0 = r4 & 11
            r2 = 2
            if (r0 != r2) goto L_0x011b
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0112
            goto L_0x011b
        L_0x0112:
            r11.skipToGroupEnd()
            r29 = r1
            r30 = r4
            goto L_0x0391
        L_0x011b:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0129
            java.lang.String r0 = "androidx.compose.material3.StandardBottomSheet (BottomSheetScaffold.kt:196)"
            r2 = -763942484(0xffffffffd27729ac, float:-2.65389015E11)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r4, r0)
        L_0x0129:
            r0 = 0
            r2 = r0
            r16 = 0
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = r11
            r18 = 0
            r19 = 0
            r20 = r2
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            r2 = 0
            r21 = r11
            r22 = 0
            r23 = r2
            java.lang.Object r2 = r21.rememberedValue()
            r25 = 0
            androidx.compose.runtime.Composer$Companion r26 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r26.getEmpty()
            if (r2 != r3) goto L_0x017f
            r3 = 0
            r26 = 0
            kotlin.coroutines.EmptyCoroutineContext r26 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r27 = r2
            r2 = r26
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            kotlinx.coroutines.CoroutineScope r2 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r2, r0)
            r26 = r0
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r0.<init>(r2)
            r2 = r21
            r2.updateRememberedValue(r0)
            goto L_0x0187
        L_0x017f:
            r26 = r0
            r27 = r2
            r2 = r21
            r0 = r27
        L_0x0187:
            r11.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r2 = r0.getCoroutineScope()
            r11.endReplaceableGroup()
            r3 = r2
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r2 = 0
            r16 = 0
            r18 = r2
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r2, r5)
            java.lang.Object r2 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r0 = r2
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            r2 = 0
            float r5 = r0.m5825toPx0680j_4(r14)
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
            r0 = r1 & 14
            r0 = r0 | 64
            r16 = 0
            r18 = r0
            r0 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            boolean r0 = r11.changed((java.lang.Object) r15)
            boolean r19 = r11.changed((java.lang.Object) r3)
            r0 = r0 | r19
            r19 = r11
            r20 = 0
            java.lang.Object r6 = r19.rememberedValue()
            r7 = 0
            if (r0 != 0) goto L_0x01f5
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r22 = r0
            java.lang.Object r0 = r21.getEmpty()
            if (r6 != r0) goto L_0x01ef
            goto L_0x01f7
        L_0x01ef:
            r0 = r6
            r23 = r0
            r6 = r19
            goto L_0x0216
        L_0x01f5:
            r22 = r0
        L_0x01f7:
            r0 = 0
            r21 = r0
            androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$anchorChangeHandler$1$1 r0 = new androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$anchorChangeHandler$1$1
            r0.<init>(r3, r15)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r23 = r6
            androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$anchorChangeHandler$1$2 r6 = new androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$anchorChangeHandler$1$2
            r6.<init>(r3, r15)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.material3.AnchorChangeHandler r0 = BottomSheetScaffoldAnchorChangeHandler(r15, r0, r6)
            r6 = r19
            r6.updateRememberedValue(r0)
        L_0x0216:
            r11.endReplaceableGroup()
            r7 = r0
            androidx.compose.material3.AnchorChangeHandler r7 = (androidx.compose.material3.AnchorChangeHandler) r7
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r6 = androidx.compose.material3.SheetDefaultsKt.getBottomSheetMaxWidth()
            r8 = 0
            r9 = 1
            r10 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m619widthInVpY3zN4$default(r0, r8, r6, r9, r10)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r0, r8, r9, r10)
            r6 = 2
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m603requiredHeightInVpY3zN4$default(r0, r14, r8, r6, r10)
            androidx.compose.material3.SwipeableV2State r6 = r34.getSwipeableState$material3_release()
            r8 = 0
            r16 = 0
            r9 = 1157296644(0x44faf204, float:2007.563)
            r11.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
            boolean r9 = r11.changed((java.lang.Object) r6)
            r18 = r11
            r19 = 0
            java.lang.Object r10 = r18.rememberedValue()
            r21 = 0
            if (r9 != 0) goto L_0x0269
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r23 = r6
            java.lang.Object r6 = r22.getEmpty()
            if (r10 != r6) goto L_0x0263
            goto L_0x026b
        L_0x0263:
            r26 = r3
            r6 = r10
            r3 = r18
            goto L_0x0284
        L_0x0269:
            r23 = r6
        L_0x026b:
            r6 = 0
            r22 = r6
            androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1 r6 = new androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1
            r6.<init>(r3, r15)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r6 = androidx.compose.material3.SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(r15, r2, r6)
            r26 = r3
            r3 = r18
            r3.updateRememberedValue(r6)
        L_0x0284:
            r11.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r6 = (androidx.compose.ui.input.nestedscroll.NestedScrollConnection) r6
            r3 = 0
            r8 = 2
            androidx.compose.ui.Modifier r16 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r0, r6, r3, r8, r3)
            androidx.compose.material3.SwipeableV2State r17 = r34.getSwipeableState$material3_release()
            r22 = 24
            r23 = 0
            r20 = 0
            r21 = 0
            r18 = r2
            r19 = r36
            androidx.compose.ui.Modifier r0 = androidx.compose.material3.SwipeableV2Kt.swipeableV2$default(r16, r17, r18, r19, r20, r21, r22, r23)
            androidx.compose.material3.SwipeableV2State r3 = r34.getSwipeableState$material3_release()
            androidx.compose.material3.SheetValue r6 = androidx.compose.material3.SheetValue.Hidden
            androidx.compose.material3.SheetValue r8 = androidx.compose.material3.SheetValue.PartiallyExpanded
            androidx.compose.material3.SheetValue r9 = androidx.compose.material3.SheetValue.Expanded
            androidx.compose.material3.SheetValue[] r6 = new androidx.compose.material3.SheetValue[]{r6, r8, r9}
            java.util.Set r6 = kotlin.collections.SetsKt.setOf(r6)
            java.lang.Float r8 = java.lang.Float.valueOf(r37)
            java.lang.Float r9 = java.lang.Float.valueOf(r5)
            r10 = r1 & 14
            int r16 = r1 >> 6
            r16 = r16 & 112(0x70, float:1.57E-43)
            r10 = r10 | r16
            r16 = 0
            r17 = r1
            r1 = 1618982084(0x607fb4c4, float:7.370227E19)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            boolean r1 = r11.changed((java.lang.Object) r15)
            boolean r18 = r11.changed((java.lang.Object) r8)
            r1 = r1 | r18
            boolean r18 = r11.changed((java.lang.Object) r9)
            r1 = r1 | r18
            r18 = r11
            r19 = 0
            r20 = r2
            java.lang.Object r2 = r18.rememberedValue()
            r21 = 0
            if (r1 != 0) goto L_0x0308
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r23 = r1
            java.lang.Object r1 = r22.getEmpty()
            if (r2 != r1) goto L_0x0302
            goto L_0x030a
        L_0x0302:
            r1 = r2
            r22 = r1
            r2 = r18
            goto L_0x031d
        L_0x0308:
            r23 = r1
        L_0x030a:
            r1 = 0
            r22 = r1
            androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1 r1 = new androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1
            r1.<init>(r15, r13, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r22 = r2
            r2 = r18
            r2.updateRememberedValue(r1)
        L_0x031d:
            r11.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.ui.Modifier r16 = androidx.compose.material3.SwipeableV2Kt.swipeAnchors(r0, r3, r6, r7, r1)
            androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3 r8 = new androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3
            r0 = r8
            r29 = r17
            r1 = r45
            r9 = r20
            r2 = r46
            r10 = r26
            r3 = r4
            r30 = r4
            r4 = r34
            r31 = r5
            r5 = r36
            r6 = r10
            r32 = r7
            r7 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = -1381492089(0xffffffffada81a87, float:-1.911117E-11)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r0, r1, r8)
            r25 = r0
            kotlin.jvm.functions.Function2 r25 = (kotlin.jvm.functions.Function2) r25
            int r0 = r29 >> 9
            r0 = r0 & 112(0x70, float:1.57E-43)
            r1 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r1
            int r1 = r29 >> 9
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r29 >> 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r29 >> 9
            r2 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r29 >> 9
            r1 = r1 & r24
            r27 = r0 | r1
            r24 = 0
            r28 = 64
            r17 = r38
            r18 = r39
            r20 = r41
            r22 = r43
            r23 = r44
            r26 = r11
            androidx.compose.material3.SurfaceKt.m2062SurfaceT9BRK9s(r16, r17, r18, r20, r22, r23, r24, r25, r26, r27, r28)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0391
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0391:
            androidx.compose.runtime.ScopeUpdateScope r10 = r11.endRestartGroup()
            if (r10 != 0) goto L_0x039a
            r17 = r11
            goto L_0x03c8
        L_0x039a:
            androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$4 r16 = new androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$4
            r0 = r16
            r1 = r34
            r2 = r35
            r3 = r36
            r4 = r37
            r5 = r38
            r6 = r39
            r8 = r41
            r33 = r10
            r10 = r43
            r17 = r11
            r11 = r44
            r12 = r45
            r13 = r46
            r14 = r48
            r15 = r49
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r33
            r1.updateScope(r0)
        L_0x03c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt.m1562StandardBottomSheet8oydGBM(androidx.compose.material3.SheetState, float, boolean, float, androidx.compose.ui.graphics.Shape, long, long, float, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldLayout-PxNyym8  reason: not valid java name */
    public static final void m1561BottomSheetScaffoldLayoutPxNyym8(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> topBar, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> body, Function3<? super Integer, ? super Composer, ? super Integer, Unit> bottomSheet, Function2<? super Composer, ? super Integer, Unit> snackbarHost, float sheetPeekHeight, Function0<Float> sheetOffset, SheetState sheetState, long containerColor, long contentColor, Composer $composer, int $changed) {
        Object value$iv$iv;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1120561936);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetScaffoldLayout)P(4,9!2,8,6:c#ui.unit.Dp,5,7,2:c#ui.graphics.Color,3:c#ui.graphics.Color)328@14299L1935,328@14282L1952:BottomSheetScaffold.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 4 : 2;
        } else {
            Modifier modifier2 = modifier;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changedInstance(topBar) ? 32 : 16;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function2 = topBar;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changedInstance(body) ? 256 : 128;
        } else {
            Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3 = body;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer2.changedInstance(bottomSheet) ? 2048 : 1024;
        } else {
            Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32 = bottomSheet;
        }
        if ((57344 & i) == 0) {
            $dirty |= $composer2.changedInstance(snackbarHost) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = snackbarHost;
        }
        if ((458752 & i) == 0) {
            $dirty |= $composer2.changed(sheetPeekHeight) ? 131072 : 65536;
        } else {
            float f = sheetPeekHeight;
        }
        if ((3670016 & i) == 0) {
            $dirty |= $composer2.changedInstance(sheetOffset) ? 1048576 : 524288;
        } else {
            Function0<Float> function0 = sheetOffset;
        }
        if ((29360128 & i) == 0) {
            $dirty |= $composer2.changed((Object) sheetState) ? 8388608 : 4194304;
        } else {
            SheetState sheetState2 = sheetState;
        }
        if ((234881024 & i) == 0) {
            $dirty |= $composer2.changed(containerColor) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            long j = containerColor;
        }
        if ((1879048192 & i) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 536870912 : 268435456;
        } else {
            long j2 = contentColor;
        }
        if (($dirty & 1533916891) != 306783378 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1120561936, $dirty, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:316)");
            }
            Object[] keys$iv = {bottomSheet, sheetOffset, topBar, modifier, Color.m3243boximpl(containerColor), Color.m3243boximpl(contentColor), body, Dp.m5842boximpl(sheetPeekHeight), snackbarHost, sheetState};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(sheetOffset, topBar, snackbarHost, sheetState, bottomSheet, $dirty, modifier, containerColor, contentColor, body, sheetPeekHeight);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout((Modifier) null, (Function2) value$iv$iv, $composer2, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i2 = $dirty;
            return;
        }
        int i3 = $dirty;
        endRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2(modifier, topBar, body, bottomSheet, snackbarHost, sheetPeekHeight, sheetOffset, sheetState, containerColor, contentColor, $changed));
    }

    /* access modifiers changed from: private */
    public static final AnchorChangeHandler<SheetValue> BottomSheetScaffoldAnchorChangeHandler(SheetState state, Function2<? super SheetValue, ? super Float, Unit> animateTo, Function1<? super SheetValue, Unit> snapTo) {
        return new BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeHandler$1(state, animateTo, snapTo);
    }
}

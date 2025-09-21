package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a3\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001a3\u0010\u0012\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001ac\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u0001H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a{\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u00012\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a \u0010&\u001a\u00020\f2\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010'\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"HeightToFirstLine", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarMinHeightOneLine", "SnackbarMinHeightTwoLines", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "Snackbar", "snackbarData", "Landroidx/compose/material/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "actionColor", "elevation", "Snackbar-sPrSdHI", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJFLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-7zSek6w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TextOnlySnackbar", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snackbar.kt */
public final class SnackbarKt {
    /* access modifiers changed from: private */
    public static final float HeightToFirstLine = Dp.m7554constructorimpl((float) 30);
    private static final float HorizontalSpacing = Dp.m7554constructorimpl((float) 16);
    private static final float HorizontalSpacingButtonSide = Dp.m7554constructorimpl((float) 8);
    private static final float LongButtonVerticalOffset = Dp.m7554constructorimpl((float) 12);
    private static final float SeparateButtonExtraY = Dp.m7554constructorimpl((float) 2);
    /* access modifiers changed from: private */
    public static final float SnackbarMinHeightOneLine = Dp.m7554constructorimpl((float) 48);
    /* access modifiers changed from: private */
    public static final float SnackbarMinHeightTwoLines = Dp.m7554constructorimpl((float) 68);
    private static final float SnackbarVerticalPadding = Dp.m7554constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final float TextEndExtraSpacing = Dp.m7554constructorimpl((float) 8);

    /* JADX WARNING: Removed duplicated region for block: B:135:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0135  */
    /* renamed from: Snackbar-7zSek6w  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m3110Snackbar7zSek6w(androidx.compose.ui.Modifier r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, boolean r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, float r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r13 = r36
            r14 = r38
            r12 = r39
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -558258760(0xffffffffdeb9a5b8, float:-6.6886503E18)
            r1 = r37
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Snackbar)P(6!2,7,2:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.unit.Dp)84@3955L6,85@4015L15,86@4072L6,90@4158L631:Snackbar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r38
            r2 = r12 & 1
            if (r2 == 0) goto L_0x0024
            r1 = r1 | 6
            r3 = r27
            goto L_0x0037
        L_0x0024:
            r3 = r14 & 14
            if (r3 != 0) goto L_0x0035
            r3 = r27
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0032
            r4 = 4
            goto L_0x0033
        L_0x0032:
            r4 = 2
        L_0x0033:
            r1 = r1 | r4
            goto L_0x0037
        L_0x0035:
            r3 = r27
        L_0x0037:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0040
            r1 = r1 | 48
            r5 = r28
            goto L_0x0055
        L_0x0040:
            r5 = r14 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0053
            r5 = r28
            boolean r6 = r11.changedInstance(r5)
            if (r6 == 0) goto L_0x004f
            r6 = 32
            goto L_0x0051
        L_0x004f:
            r6 = 16
        L_0x0051:
            r1 = r1 | r6
            goto L_0x0055
        L_0x0053:
            r5 = r28
        L_0x0055:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x005e
            r1 = r1 | 384(0x180, float:5.38E-43)
            r7 = r29
            goto L_0x0073
        L_0x005e:
            r7 = r14 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0071
            r7 = r29
            boolean r8 = r11.changed((boolean) r7)
            if (r8 == 0) goto L_0x006d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006f
        L_0x006d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006f:
            r1 = r1 | r8
            goto L_0x0073
        L_0x0071:
            r7 = r29
        L_0x0073:
            r8 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x008c
            r8 = r12 & 8
            if (r8 != 0) goto L_0x0086
            r8 = r30
            boolean r9 = r11.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0088
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x008a
        L_0x0086:
            r8 = r30
        L_0x0088:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x008a:
            r1 = r1 | r9
            goto L_0x008e
        L_0x008c:
            r8 = r30
        L_0x008e:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r14
            if (r9 != 0) goto L_0x00a9
            r9 = r12 & 16
            if (r9 != 0) goto L_0x00a3
            r9 = r31
            boolean r15 = r11.changed((long) r9)
            if (r15 == 0) goto L_0x00a5
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a3:
            r9 = r31
        L_0x00a5:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a7:
            r1 = r1 | r15
            goto L_0x00ab
        L_0x00a9:
            r9 = r31
        L_0x00ab:
            r15 = 458752(0x70000, float:6.42848E-40)
            r16 = r14 & r15
            if (r16 != 0) goto L_0x00cb
            r16 = r12 & 32
            if (r16 != 0) goto L_0x00c2
            r37 = r1
            r0 = r33
            boolean r17 = r11.changed((long) r0)
            if (r17 == 0) goto L_0x00c6
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c8
        L_0x00c2:
            r37 = r1
            r0 = r33
        L_0x00c6:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c8:
            r17 = r37 | r17
            goto L_0x00d1
        L_0x00cb:
            r37 = r1
            r0 = r33
            r17 = r37
        L_0x00d1:
            r18 = r12 & 64
            r19 = 1572864(0x180000, float:2.204052E-39)
            if (r18 == 0) goto L_0x00dc
            r17 = r17 | r19
            r15 = r35
            goto L_0x00f4
        L_0x00dc:
            r20 = 3670016(0x380000, float:5.142788E-39)
            r20 = r14 & r20
            if (r20 != 0) goto L_0x00f2
            r15 = r35
            boolean r20 = r11.changed((float) r15)
            if (r20 == 0) goto L_0x00ed
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ef
        L_0x00ed:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00ef:
            r17 = r17 | r20
            goto L_0x00f4
        L_0x00f2:
            r15 = r35
        L_0x00f4:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00fd
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00fa:
            r17 = r17 | r0
            goto L_0x010e
        L_0x00fd:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r14
            if (r0 != 0) goto L_0x010e
            boolean r0 = r11.changedInstance(r13)
            if (r0 == 0) goto L_0x010b
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fa
        L_0x010b:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00fa
        L_0x010e:
            r0 = r17
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r0
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r1 != r3) goto L_0x0135
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x0120
            goto L_0x0135
        L_0x0120:
            r11.skipToGroupEnd()
            r21 = r33
            r24 = r0
            r16 = r5
            r17 = r7
            r18 = r8
            r19 = r9
            r23 = r15
            r15 = r27
            goto L_0x0225
        L_0x0135:
            r11.startDefaults()
            r1 = r14 & 1
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x0164
            boolean r1 = r11.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0149
            goto L_0x0164
        L_0x0149:
            r11.skipToGroupEnd()
            r1 = r12 & 8
            if (r1 == 0) goto L_0x0152
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0152:
            r1 = r12 & 16
            if (r1 == 0) goto L_0x0158
            r0 = r0 & r17
        L_0x0158:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x015d
            r0 = r0 & r3
        L_0x015d:
            r1 = r27
            r2 = r33
            r4 = r0
            r0 = r15
            goto L_0x01b9
        L_0x0164:
            if (r2 == 0) goto L_0x016b
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x016d
        L_0x016b:
            r1 = r27
        L_0x016d:
            if (r4 == 0) goto L_0x0171
            r2 = 0
            r5 = r2
        L_0x0171:
            if (r6 == 0) goto L_0x0175
            r2 = 0
            r7 = r2
        L_0x0175:
            r2 = r12 & 8
            r4 = 6
            if (r2 == 0) goto L_0x0189
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r2 = r2.getShapes(r11, r4)
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.getSmall()
            androidx.compose.ui.graphics.Shape r2 = (androidx.compose.ui.graphics.Shape) r2
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
            r8 = r2
        L_0x0189:
            r2 = r12 & 16
            if (r2 == 0) goto L_0x0195
            androidx.compose.material.SnackbarDefaults r2 = androidx.compose.material.SnackbarDefaults.INSTANCE
            long r9 = r2.getBackgroundColor(r11, r4)
            r0 = r0 & r17
        L_0x0195:
            r2 = r12 & 32
            if (r2 == 0) goto L_0x01a5
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r11, r4)
            long r20 = r2.m2955getSurface0d7_KjU()
            r0 = r0 & r3
            goto L_0x01a7
        L_0x01a5:
            r20 = r33
        L_0x01a7:
            if (r18 == 0) goto L_0x01b5
            r2 = 6
            r3 = 0
            float r4 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r4)
            r4 = r0
            r0 = r2
            r2 = r20
            goto L_0x01b9
        L_0x01b5:
            r4 = r0
            r0 = r15
            r2 = r20
        L_0x01b9:
            r11.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x01cb
            r6 = -1
            java.lang.String r15 = "androidx.compose.material.Snackbar (Snackbar.kt:80)"
            r12 = -558258760(0xffffffffdeb9a5b8, float:-6.6886503E18)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r4, r6, r15)
        L_0x01cb:
            androidx.compose.material.SnackbarKt$Snackbar$1 r6 = new androidx.compose.material.SnackbarKt$Snackbar$1
            r6.<init>(r5, r13, r4, r7)
            r12 = -2084221700(0xffffffff83c54cfc, float:-1.1596294E-36)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r12, r15, r6)
            r23 = r6
            kotlin.jvm.functions.Function2 r23 = (kotlin.jvm.functions.Function2) r23
            r6 = r4 & 14
            r6 = r6 | r19
            int r12 = r4 >> 6
            r12 = r12 & 112(0x70, float:1.57E-43)
            r6 = r6 | r12
            int r12 = r4 >> 6
            r12 = r12 & 896(0x380, float:1.256E-42)
            r6 = r6 | r12
            int r12 = r4 >> 6
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r12
            int r12 = r4 >> 3
            r15 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r15
            r25 = r6 | r12
            r21 = 0
            r26 = 16
            r15 = r1
            r16 = r8
            r17 = r9
            r19 = r2
            r22 = r0
            r24 = r11
            androidx.compose.material.SurfaceKt.m3130SurfaceFjzlyU(r15, r16, r17, r19, r21, r22, r23, r24, r25, r26)
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0216
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0216:
            r23 = r0
            r15 = r1
            r21 = r2
            r24 = r4
            r16 = r5
            r17 = r7
            r18 = r8
            r19 = r9
        L_0x0225:
            androidx.compose.runtime.ScopeUpdateScope r12 = r11.endRestartGroup()
            if (r12 != 0) goto L_0x022e
            r26 = r11
            goto L_0x0252
        L_0x022e:
            androidx.compose.material.SnackbarKt$Snackbar$2 r25 = new androidx.compose.material.SnackbarKt$Snackbar$2
            r0 = r25
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r7 = r21
            r9 = r23
            r10 = r36
            r26 = r11
            r11 = r38
            r13 = r12
            r12 = r39
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12)
            r0 = r25
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0252:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.m3110Snackbar7zSek6w(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.graphics.Shape, long, long, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Snackbar-sPrSdHI  reason: not valid java name */
    public static final void m3111SnackbarsPrSdHI(SnackbarData snackbarData, Modifier modifier, boolean actionOnNewLine, Shape shape, long backgroundColor, long contentColor, long actionColor, float elevation, Composer $composer, int $changed, int i) {
        boolean z;
        Shape shape2;
        long contentColor2;
        long actionColor2;
        float elevation2;
        long actionColor3;
        long contentColor3;
        long backgroundColor2;
        Shape shape3;
        boolean actionOnNewLine2;
        Modifier modifier2;
        long actionColor4;
        Shape shape4;
        float elevation3;
        boolean actionOnNewLine3;
        Modifier modifier3;
        long actionColor5;
        Function2 actionComposable;
        long backgroundColor3;
        long actionColor6;
        int i2;
        int i3;
        int i4;
        int i5;
        SnackbarData snackbarData2 = snackbarData;
        int i6 = $changed;
        int i7 = i;
        Intrinsics.checkNotNullParameter(snackbarData2, "snackbarData");
        Composer $composer2 = $composer.startRestartGroup(258660814);
        ComposerKt.sourceInformation($composer2, "C(Snackbar)P(7,5,1,6,2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.unit.Dp)155@7132L6,156@7192L15,157@7249L6,158@7307L18,173@7784L320:Snackbar.kt#jmzs0o");
        int $dirty = $changed;
        if ((i7 & 1) != 0) {
            $dirty |= 6;
        } else if ((i6 & 14) == 0) {
            $dirty |= $composer2.changed((Object) snackbarData2) ? 4 : 2;
        }
        int i8 = i7 & 2;
        if (i8 != 0) {
            $dirty |= 48;
            Modifier modifier4 = modifier;
        } else if ((i6 & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        int i9 = i7 & 4;
        if (i9 != 0) {
            $dirty |= 384;
            z = actionOnNewLine;
        } else if ((i6 & 896) == 0) {
            z = actionOnNewLine;
            $dirty |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = actionOnNewLine;
        }
        if ((i6 & 7168) == 0) {
            if ((i7 & 8) == 0) {
                shape2 = shape;
                if ($composer2.changed((Object) shape2)) {
                    i5 = 2048;
                    $dirty |= i5;
                }
            } else {
                shape2 = shape;
            }
            i5 = 1024;
            $dirty |= i5;
        } else {
            shape2 = shape;
        }
        if ((i6 & 57344) == 0) {
            if ((i7 & 16) != 0) {
                long j = backgroundColor;
            } else if ($composer2.changed(backgroundColor)) {
                i4 = 16384;
                $dirty |= i4;
            }
            i4 = 8192;
            $dirty |= i4;
        } else {
            long j2 = backgroundColor;
        }
        if ((i6 & 458752) == 0) {
            if ((i7 & 32) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i3 = 131072;
                    $dirty |= i3;
                }
            } else {
                contentColor2 = contentColor;
            }
            i3 = 65536;
            $dirty |= i3;
        } else {
            contentColor2 = contentColor;
        }
        if ((i6 & 3670016) == 0) {
            if ((i7 & 64) == 0) {
                actionColor2 = actionColor;
                if ($composer2.changed(actionColor2)) {
                    i2 = 1048576;
                    $dirty |= i2;
                }
            } else {
                actionColor2 = actionColor;
            }
            i2 = 524288;
            $dirty |= i2;
        } else {
            actionColor2 = actionColor;
        }
        int i10 = i7 & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
            float f = elevation;
        } else if ((i6 & 29360128) == 0) {
            $dirty |= $composer2.changed(elevation) ? 8388608 : 4194304;
        } else {
            float f2 = elevation;
        }
        if (($dirty & 23967451) != 4793490 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i6 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i9 != 0) {
                    actionOnNewLine3 = false;
                } else {
                    actionOnNewLine3 = z;
                }
                if ((i7 & 8) != 0) {
                    shape4 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getSmall();
                    $dirty &= -7169;
                } else {
                    shape4 = shape2;
                }
                if ((i7 & 16) != 0) {
                    backgroundColor3 = SnackbarDefaults.INSTANCE.getBackgroundColor($composer2, 6);
                    $dirty &= -57345;
                } else {
                    backgroundColor3 = backgroundColor;
                }
                if ((i7 & 32) != 0) {
                    contentColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m2955getSurface0d7_KjU();
                    $dirty &= -458753;
                }
                if ((i7 & 64) != 0) {
                    actionColor6 = SnackbarDefaults.INSTANCE.getPrimaryActionColor($composer2, 6);
                    $dirty &= -3670017;
                } else {
                    actionColor6 = actionColor2;
                }
                if (i10 != 0) {
                    elevation3 = Dp.m7554constructorimpl((float) 6);
                    actionColor2 = actionColor6;
                    actionColor4 = backgroundColor3;
                } else {
                    elevation3 = elevation;
                    actionColor2 = actionColor6;
                    actionColor4 = backgroundColor3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i7 & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i7 & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i7 & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i7 & 64) != 0) {
                    elevation3 = elevation;
                    $dirty &= -3670017;
                    actionOnNewLine3 = z;
                    shape4 = shape2;
                    modifier3 = modifier;
                    actionColor4 = backgroundColor;
                } else {
                    modifier3 = modifier;
                    elevation3 = elevation;
                    actionOnNewLine3 = z;
                    shape4 = shape2;
                    actionColor4 = backgroundColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(258660814, $dirty, -1, "androidx.compose.material.Snackbar (Snackbar.kt:151)");
            }
            String actionLabel = snackbarData.getActionLabel();
            if (actionLabel != null) {
                actionColor5 = actionColor2;
                actionComposable = ComposableLambdaKt.composableLambda($composer2, 1843479216, true, new SnackbarKt$Snackbar$actionComposable$1(actionColor2, $dirty, snackbarData, actionLabel));
            } else {
                actionColor5 = actionColor2;
                actionComposable = null;
            }
            m3110Snackbar7zSek6w(PaddingKt.m2248padding3ABfNKs(modifier3, Dp.m7554constructorimpl((float) 12)), actionComposable, actionOnNewLine3, shape4, actionColor4, contentColor2, elevation3, ComposableLambdaKt.composableLambda($composer2, -261845785, true, new SnackbarKt$Snackbar$3(snackbarData2)), $composer2, ($dirty & 896) | 12582912 | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (($dirty >> 3) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            actionColor3 = actionColor5;
            modifier2 = modifier3;
            int i11 = $dirty;
            actionOnNewLine2 = actionOnNewLine3;
            elevation2 = elevation3;
            shape3 = shape4;
            backgroundColor2 = actionColor4;
            contentColor3 = contentColor2;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            backgroundColor2 = backgroundColor;
            elevation2 = elevation;
            int i12 = $dirty;
            actionOnNewLine2 = z;
            shape3 = shape2;
            actionColor3 = actionColor2;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new SnackbarKt$Snackbar$4(snackbarData, modifier2, actionOnNewLine2, shape3, backgroundColor2, contentColor3, actionColor3, elevation2, $changed, i));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0278  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextOnlySnackbar(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, int r42) {
        /*
            r0 = r40
            r1 = r42
            r2 = 917397959(0x36ae61c7, float:5.196987E-6)
            r3 = r41
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r2)
            java.lang.String r4 = "C(TextOnlySnackbar)236@9927L1207:Snackbar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r42
            r5 = r1 & 14
            r6 = 2
            if (r5 != 0) goto L_0x0023
            boolean r5 = r3.changedInstance(r0)
            if (r5 == 0) goto L_0x0021
            r5 = 4
            goto L_0x0022
        L_0x0021:
            r5 = r6
        L_0x0022:
            r4 = r4 | r5
        L_0x0023:
            r5 = r4 & 11
            if (r5 != r6) goto L_0x0033
            boolean r5 = r3.getSkipping()
            if (r5 != 0) goto L_0x002e
            goto L_0x0033
        L_0x002e:
            r3.skipToGroupEnd()
            goto L_0x027b
        L_0x0033:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x003f
            r5 = -1
            java.lang.String r6 = "androidx.compose.material.TextOnlySnackbar (Snackbar.kt:235)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r4, r5, r6)
        L_0x003f:
            androidx.compose.material.SnackbarKt$TextOnlySnackbar$2 r2 = androidx.compose.material.SnackbarKt$TextOnlySnackbar$2.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r2 = (androidx.compose.ui.layout.MeasurePolicy) r2
            r5 = 0
            r6 = r5
            r7 = 0
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r8)
            java.lang.String r9 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r9)
            androidx.compose.ui.Modifier$Companion r10 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r10 = (androidx.compose.ui.Modifier) r10
            int r11 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r3, r5)
            androidx.compose.runtime.CompositionLocalMap r12 = r3.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r14 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r10)
            int r15 = r6 << 9
            r15 = r15 & 7168(0x1c00, float:1.0045E-41)
            r16 = 6
            r15 = r15 | 6
            r17 = 0
            androidx.compose.runtime.Applier r5 = r3.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x007d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x007d:
            r3.startReusableNode()
            boolean r5 = r3.getInserting()
            if (r5 == 0) goto L_0x008a
            r3.createNode(r13)
            goto L_0x008d
        L_0x008a:
            r3.useNode()
        L_0x008d:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m4575constructorimpl(r3)
            r18 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r19 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r19.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r5, r2, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r5, r12, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetCompositeKeyHash()
            r19 = 0
            r21 = r5
            r22 = 0
            boolean r23 = r21.getInserting()
            if (r23 != 0) goto L_0x00cd
            r23 = r2
            java.lang.Object r2 = r21.rememberedValue()
            r24 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r11)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)
            if (r2 != 0) goto L_0x00ca
            goto L_0x00d1
        L_0x00ca:
            r6 = r21
            goto L_0x00e1
        L_0x00cd:
            r23 = r2
            r24 = r6
        L_0x00d1:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            r6 = r21
            r6.updateRememberedValue(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            r5.apply(r2, r8)
        L_0x00e1:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r2)
            int r5 = r15 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r14.invoke(r2, r3, r5)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r3.startReplaceableGroup(r2)
            int r5 = r15 >> 9
            r5 = r5 & 14
            r6 = r3
            r8 = 0
            r2 = -1987608331(0xffffffff898780f5, float:-3.262134E-33)
            r19 = r5
            java.lang.String r5 = "C237@9944L202:Snackbar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r5)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r5 = HorizontalSpacing
            r21 = r7
            float r7 = SnackbarVerticalPadding
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m2249paddingVpY3zN4(r2, r5, r7)
            r5 = r16
            r7 = 0
            r22 = r7
            r7 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r6.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r7)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getTopStart()
            r25 = r8
            r8 = 0
            int r26 = r5 >> 3
            r26 = r26 & 14
            int r27 = r5 >> 3
            r27 = r27 & 112(0x70, float:1.57E-43)
            r28 = r10
            r10 = r26 | r27
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r7, r8, r6, r10)
            int r26 = r5 << 3
            r26 = r26 & 112(0x70, float:1.57E-43)
            r27 = 0
            r29 = r7
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r6.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r9)
            r7 = 0
            int r7 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r6, r7)
            androidx.compose.runtime.CompositionLocalMap r9 = r6.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r20 = r20.getConstructor()
            kotlin.jvm.functions.Function3 r30 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r2)
            r41 = r2
            int r2 = r26 << 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | 6
            r31 = r20
            r20 = r30
            r30 = 0
            r32 = r8
            androidx.compose.runtime.Applier r8 = r6.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x0186
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0186:
            r6.startReusableNode()
            boolean r8 = r6.getInserting()
            if (r8 == 0) goto L_0x0195
            r8 = r31
            r6.createNode(r8)
            goto L_0x019a
        L_0x0195:
            r8 = r31
            r6.useNode()
        L_0x019a:
            r31 = r8
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m4575constructorimpl(r6)
            r33 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r34 = androidx.compose.ui.node.ComposeUiNode.Companion
            r35 = r11
            kotlin.jvm.functions.Function2 r11 = r34.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r8, r10, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r8, r9, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetCompositeKeyHash()
            r34 = 0
            r36 = r8
            r37 = 0
            boolean r38 = r36.getInserting()
            if (r38 != 0) goto L_0x01de
            r38 = r9
            java.lang.Object r9 = r36.rememberedValue()
            r39 = r10
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 != 0) goto L_0x01db
            goto L_0x01e2
        L_0x01db:
            r10 = r36
            goto L_0x01f2
        L_0x01de:
            r38 = r9
            r39 = r10
        L_0x01e2:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            r10 = r36
            r10.updateRememberedValue(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            r8.apply(r9, r11)
        L_0x01f2:
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r6)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r8)
            int r9 = r2 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r10 = r20
            r10.invoke(r8, r6, r9)
            r8 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r6.startReplaceableGroup(r8)
            int r8 = r2 >> 9
            r8 = r8 & 14
            r9 = r6
            r11 = 0
            r18 = r2
            r2 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r20 = r7
            java.lang.String r7 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r7)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r7 = r5 >> 6
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r7 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r16 = r9
            r33 = 0
            r34 = r2
            r2 = 1159675981(0x451f404d, float:2548.0188)
            r36 = r5
            java.lang.String r5 = "C243@10127L9:Snackbar.kt#jmzs0o"
            r37 = r7
            r7 = r16
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r2, r5)
            r2 = r4 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.invoke(r7, r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r6.endReplaceableGroup()
            r6.endNode()
            r6.endReplaceableGroup()
            r6.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r3.endReplaceableGroup()
            r3.endNode()
            r3.endReplaceableGroup()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x027b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x027b:
            androidx.compose.runtime.ScopeUpdateScope r2 = r3.endRestartGroup()
            if (r2 != 0) goto L_0x0282
            goto L_0x028c
        L_0x0282:
            androidx.compose.material.SnackbarKt$TextOnlySnackbar$3 r5 = new androidx.compose.material.SnackbarKt$TextOnlySnackbar$3
            r5.<init>(r0, r1)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r2.updateScope(r5)
        L_0x028c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.TextOnlySnackbar(kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0370  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0382  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x03b5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x03cb  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x046b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NewLineButtonSnackbar(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, androidx.compose.runtime.Composer r59, int r60) {
        /*
            r0 = r57
            r1 = r58
            r2 = r60
            r3 = -1229075900(0xffffffffb6bdca44, float:-5.6561857E-6)
            r4 = r59
            androidx.compose.runtime.Composer r4 = r4.startRestartGroup(r3)
            java.lang.String r5 = "C(NewLineButtonSnackbar)P(1)274@11262L476:Snackbar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r60
            r6 = r2 & 14
            if (r6 != 0) goto L_0x0024
            boolean r6 = r4.changedInstance(r0)
            if (r6 == 0) goto L_0x0022
            r6 = 4
            goto L_0x0023
        L_0x0022:
            r6 = 2
        L_0x0023:
            r5 = r5 | r6
        L_0x0024:
            r6 = r2 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0034
            boolean r6 = r4.changedInstance(r1)
            if (r6 == 0) goto L_0x0031
            r6 = 32
            goto L_0x0033
        L_0x0031:
            r6 = 16
        L_0x0033:
            r5 = r5 | r6
        L_0x0034:
            r6 = r5 & 91
            r7 = 18
            if (r6 != r7) goto L_0x0046
            boolean r6 = r4.getSkipping()
            if (r6 != 0) goto L_0x0041
            goto L_0x0046
        L_0x0041:
            r4.skipToGroupEnd()
            goto L_0x046e
        L_0x0046:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0052
            r6 = -1
            java.lang.String r7 = "androidx.compose.material.NewLineButtonSnackbar (Snackbar.kt:270)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r5, r6, r7)
        L_0x0052:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r6 = 1
            r7 = 0
            r8 = 0
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r3, r8, r6, r7)
            float r10 = HorizontalSpacing
            float r3 = HorizontalSpacingButtonSide
            float r13 = SeparateButtonExtraY
            r14 = 2
            r15 = 0
            r11 = 0
            r12 = r3
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.PaddingKt.m2252paddingqDBjuR0$default(r9, r10, r11, r12, r13, r14, r15)
            r7 = 6
            r8 = r7
            r9 = 0
            r10 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r4.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(Column)P(2,3,1)75@3779L61,76@3845L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r10)
            androidx.compose.foundation.layout.Arrangement r10 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r10 = r10.getTop()
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r15 = r11.getStart()
            int r11 = r8 >> 3
            r11 = r11 & 14
            int r12 = r8 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r10, r15, r4, r11)
            int r11 = r8 << 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r18 = r11
            r19 = 0
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4.startReplaceableGroup(r13)
            java.lang.String r12 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r12)
            r11 = 0
            int r20 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r4, r11)
            r59 = r15
            androidx.compose.runtime.CompositionLocalMap r15 = r4.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r16 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r17 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r6)
            int r11 = r18 << 9
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r7
            r22 = r16
            r23 = r17
            r24 = r11
            r25 = 0
            androidx.compose.runtime.Applier r11 = r4.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x00d3
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00d3:
            r4.startReusableNode()
            boolean r11 = r4.getInserting()
            if (r11 == 0) goto L_0x00e2
            r11 = r22
            r4.createNode(r11)
            goto L_0x00e7
        L_0x00e2:
            r11 = r22
            r4.useNode()
        L_0x00e7:
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m4575constructorimpl(r4)
            r17 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r22 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r22.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r13, r14, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r13, r15, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetCompositeKeyHash()
            r22 = 0
            r27 = r13
            r28 = 0
            boolean r29 = r27.getInserting()
            if (r29 != 0) goto L_0x0127
            r29 = r6
            java.lang.Object r6 = r27.rememberedValue()
            r30 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r20)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r9)
            if (r6 != 0) goto L_0x0124
            goto L_0x012b
        L_0x0124:
            r9 = r27
            goto L_0x013b
        L_0x0127:
            r29 = r6
            r30 = r9
        L_0x012b:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r20)
            r9 = r27
            r9.updateRememberedValue(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r20)
            r13.apply(r6, r7)
        L_0x013b:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r4)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r6)
            int r7 = r24 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r9 = r23
            r9.invoke(r6, r4, r7)
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r4.startReplaceableGroup(r6)
            int r7 = r24 >> 9
            r7 = r7 & 14
            r13 = r4
            r22 = 0
            r6 = 276693570(0x107e0242, float:5.0094407E-29)
            r27 = r7
            java.lang.String r7 = "C77@3893L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r7)
            androidx.compose.foundation.layout.ColumnScopeInstance r6 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            int r7 = r8 >> 6
            r7 = r7 & 112(0x70, float:1.57E-43)
            r17 = 6
            r7 = r7 | 6
            androidx.compose.foundation.layout.ColumnScope r6 = (androidx.compose.foundation.layout.ColumnScope) r6
            r28 = r13
            r31 = 0
            r32 = r7
            r7 = 71171629(0x43dfe2d, float:2.2333555E-36)
            r33 = r8
            java.lang.String r8 = "C282@11505L171,286@11685L47:Snackbar.kt#jmzs0o"
            r17 = r15
            r15 = r28
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r7, r8)
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            float r8 = HeightToFirstLine
            r28 = r9
            float r9 = LongButtonVerticalOffset
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.AlignmentLineKt.m2104paddingFromBaselineVpY3zN4(r7, r8, r9)
            r8 = 11
            r9 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r21 = r11
            r11 = r7
            r7 = r12
            r12 = r34
            r34 = r13
            r13 = r35
            r35 = r14
            r14 = r3
            r3 = r59
            r40 = r15
            r39 = r17
            r15 = r36
            r16 = r8
            r17 = r9
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.PaddingKt.m2252paddingqDBjuR0$default(r11, r12, r13, r14, r15, r16, r17)
            r9 = 6
            r11 = r9
            r9 = 0
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13 = r40
            r13.startReplaceableGroup(r12)
            java.lang.String r14 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r14)
            androidx.compose.ui.Alignment$Companion r15 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r15 = r15.getTopStart()
            r12 = 0
            int r16 = r11 >> 3
            r16 = r16 & 14
            int r17 = r11 >> 3
            r17 = r17 & 112(0x70, float:1.57E-43)
            r36 = r3
            r3 = r16 | r17
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r15, r12, r13, r3)
            int r16 = r11 << 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r17 = 0
            r40 = r9
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r7)
            r9 = 0
            int r37 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r13, r9)
            androidx.compose.runtime.CompositionLocalMap r9 = r13.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r42 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r42 = r42.getConstructor()
            kotlin.jvm.functions.Function3 r43 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r8)
            r44 = r8
            int r8 = r16 << 9
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r26 = 6
            r8 = r8 | 6
            r45 = r42
            r42 = r43
            r43 = 0
            r46 = r10
            androidx.compose.runtime.Applier r10 = r13.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0229
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0229:
            r13.startReusableNode()
            boolean r10 = r13.getInserting()
            if (r10 == 0) goto L_0x0238
            r10 = r45
            r13.createNode(r10)
            goto L_0x023d
        L_0x0238:
            r10 = r45
            r13.useNode()
        L_0x023d:
            r45 = r10
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m4575constructorimpl(r13)
            r47 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r48 = androidx.compose.ui.node.ComposeUiNode.Companion
            r49 = r12
            kotlin.jvm.functions.Function2 r12 = r48.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r3, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r9, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetCompositeKeyHash()
            r48 = 0
            r50 = r10
            r51 = 0
            boolean r52 = r50.getInserting()
            if (r52 != 0) goto L_0x0281
            r52 = r3
            java.lang.Object r3 = r50.rememberedValue()
            r53 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r37)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r9)
            if (r3 != 0) goto L_0x027e
            goto L_0x0285
        L_0x027e:
            r9 = r50
            goto L_0x0295
        L_0x0281:
            r52 = r3
            r53 = r9
        L_0x0285:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r37)
            r9 = r50
            r9.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r37)
            r10.apply(r3, r12)
        L_0x0295:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r3)
            int r9 = r8 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r10 = r42
            r10.invoke(r3, r13, r9)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r3)
            int r3 = r8 >> 9
            r3 = r3 & 14
            r9 = r13
            r12 = 0
            r42 = r3
            r3 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r47 = r8
            java.lang.String r8 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r3, r8)
            androidx.compose.foundation.layout.BoxScopeInstance r48 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r50 = r11 >> 6
            r50 = r50 & 112(0x70, float:1.57E-43)
            r26 = 6
            r50 = r50 | 6
            androidx.compose.foundation.layout.BoxScope r48 = (androidx.compose.foundation.layout.BoxScope) r48
            r51 = r9
            r54 = 0
            r3 = 683214577(0x28b906f1, float:2.0542136E-14)
            r55 = r10
            java.lang.String r10 = "C285@11668L6:Snackbar.kt#jmzs0o"
            r56 = r11
            r11 = r51
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r10)
            r3 = r5 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.invoke(r11, r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r9 = r9.getEnd()
            androidx.compose.ui.Modifier r3 = r6.align(r3, r9)
            r9 = 0
            r10 = 0
            r11 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r14)
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r11 = r11.getTopStart()
            r12 = 0
            int r14 = r9 >> 3
            r14 = r14 & 14
            int r15 = r9 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r14 = r14 | r15
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r11, r12, r13, r14)
            int r15 = r9 << 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r16 = 0
            r59 = r6
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r7)
            r6 = 0
            int r6 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r13, r6)
            androidx.compose.runtime.CompositionLocalMap r7 = r13.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r17 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r37 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            r38 = r3
            int r3 = r15 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r26 = 6
            r3 = r3 | 6
            r40 = r17
            r17 = r37
            r37 = 0
            r41 = r10
            androidx.compose.runtime.Applier r10 = r13.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0373
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0373:
            r13.startReusableNode()
            boolean r10 = r13.getInserting()
            if (r10 == 0) goto L_0x0382
            r10 = r40
            r13.createNode(r10)
            goto L_0x0387
        L_0x0382:
            r10 = r40
            r13.useNode()
        L_0x0387:
            r40 = r10
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m4575constructorimpl(r13)
            r42 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r43 = androidx.compose.ui.node.ComposeUiNode.Companion
            r44 = r11
            kotlin.jvm.functions.Function2 r11 = r43.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r14, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r7, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetCompositeKeyHash()
            r43 = 0
            r45 = r10
            r47 = 0
            boolean r48 = r45.getInserting()
            if (r48 != 0) goto L_0x03cb
            r48 = r7
            java.lang.Object r7 = r45.rememberedValue()
            r49 = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r12)
            if (r7 != 0) goto L_0x03c8
            goto L_0x03cf
        L_0x03c8:
            r12 = r45
            goto L_0x03df
        L_0x03cb:
            r48 = r7
            r49 = r12
        L_0x03cf:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r12 = r45
            r12.updateRememberedValue(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r10.apply(r7, r11)
        L_0x03df:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r7)
            int r10 = r3 >> 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r11 = r17
            r11.invoke(r7, r13, r10)
            r7 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r7)
            int r7 = r3 >> 9
            r7 = r7 & 14
            r10 = r13
            r12 = 0
            r17 = r3
            r3 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r8)
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r8 = r9 >> 6
            r8 = r8 & 112(0x70, float:1.57E-43)
            r23 = 6
            r8 = r8 | 6
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            r23 = r10
            r26 = 0
            r42 = r3
            r3 = 683214631(0x28b90727, float:2.0542228E-14)
            r43 = r6
            java.lang.String r6 = "C286@11722L8:Snackbar.kt#jmzs0o"
            r45 = r7
            r7 = r23
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r3, r6)
            int r3 = r5 >> 3
            r3 = r3 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.invoke(r7, r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r34)
            r4.endReplaceableGroup()
            r4.endNode()
            r4.endReplaceableGroup()
            r4.endReplaceableGroup()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x046e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x046e:
            androidx.compose.runtime.ScopeUpdateScope r3 = r4.endRestartGroup()
            if (r3 != 0) goto L_0x0475
            goto L_0x047f
        L_0x0475:
            androidx.compose.material.SnackbarKt$NewLineButtonSnackbar$2 r6 = new androidx.compose.material.SnackbarKt$NewLineButtonSnackbar$2
            r6.<init>(r0, r1, r2)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r3.updateScope(r6)
        L_0x047f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.NewLineButtonSnackbar(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x030f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x035e  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x03f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void OneRowSnackbar(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, int r53) {
        /*
            r0 = r50
            r1 = r51
            r2 = r53
            r3 = -534813202(0xffffffffe01f65ee, float:-4.5943392E19)
            r4 = r52
            androidx.compose.runtime.Composer r4 = r4.startRestartGroup(r3)
            java.lang.String r5 = "C(OneRowSnackbar)P(1)297@11913L2543:Snackbar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r53
            r6 = r2 & 14
            if (r6 != 0) goto L_0x0024
            boolean r6 = r4.changedInstance(r0)
            if (r6 == 0) goto L_0x0022
            r6 = 4
            goto L_0x0023
        L_0x0022:
            r6 = 2
        L_0x0023:
            r5 = r5 | r6
        L_0x0024:
            r6 = r2 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0034
            boolean r6 = r4.changedInstance(r1)
            if (r6 == 0) goto L_0x0031
            r6 = 32
            goto L_0x0033
        L_0x0031:
            r6 = 16
        L_0x0033:
            r5 = r5 | r6
        L_0x0034:
            r6 = r5 & 91
            r7 = 18
            if (r6 != r7) goto L_0x0046
            boolean r6 = r4.getSkipping()
            if (r6 != 0) goto L_0x0041
            goto L_0x0046
        L_0x0041:
            r4.skipToGroupEnd()
            goto L_0x03f8
        L_0x0046:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0052
            r6 = -1
            java.lang.String r7 = "androidx.compose.material.OneRowSnackbar (Snackbar.kt:291)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r5, r6, r7)
        L_0x0052:
            java.lang.String r3 = "text"
            java.lang.String r6 = "action"
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            r8 = r7
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            float r9 = HorizontalSpacing
            float r11 = HorizontalSpacingButtonSide
            r13 = 10
            r14 = 0
            r10 = 0
            r12 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.PaddingKt.m2252paddingqDBjuR0$default(r8, r9, r10, r11, r12, r13, r14)
            androidx.compose.material.SnackbarKt$OneRowSnackbar$2 r8 = new androidx.compose.material.SnackbarKt$OneRowSnackbar$2
            r8.<init>(r6, r3)
            androidx.compose.ui.layout.MeasurePolicy r8 = (androidx.compose.ui.layout.MeasurePolicy) r8
            r9 = 48
            r10 = 0
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4.startReplaceableGroup(r11)
            java.lang.String r12 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r12)
            r13 = 0
            int r14 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r4, r13)
            androidx.compose.runtime.CompositionLocalMap r15 = r4.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r16 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r17 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r7)
            int r13 = r9 << 9
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r13 = r13 | 6
            r18 = r17
            r17 = r16
            r16 = 0
            androidx.compose.runtime.Applier r11 = r4.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x00ab
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00ab:
            r4.startReusableNode()
            boolean r11 = r4.getInserting()
            if (r11 == 0) goto L_0x00ba
            r11 = r17
            r4.createNode(r11)
            goto L_0x00bf
        L_0x00ba:
            r11 = r17
            r4.useNode()
        L_0x00bf:
            r17 = r7
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m4575constructorimpl(r4)
            r20 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r21 = androidx.compose.ui.node.ComposeUiNode.Companion
            r22 = r9
            kotlin.jvm.functions.Function2 r9 = r21.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r7, r8, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r7, r15, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetCompositeKeyHash()
            r21 = 0
            r23 = r7
            r24 = 0
            boolean r25 = r23.getInserting()
            if (r25 != 0) goto L_0x0103
            r25 = r8
            java.lang.Object r8 = r23.rememberedValue()
            r26 = r10
            java.lang.Integer r10 = java.lang.Integer.valueOf(r14)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r10)
            if (r8 != 0) goto L_0x0100
            goto L_0x0107
        L_0x0100:
            r10 = r23
            goto L_0x0117
        L_0x0103:
            r25 = r8
            r26 = r10
        L_0x0107:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r14)
            r10 = r23
            r10.updateRememberedValue(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r14)
            r7.apply(r8, r9)
        L_0x0117:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r4)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r7)
            int r8 = r13 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9 = r18
            r9.invoke(r7, r4, r8)
            r7 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r4.startReplaceableGroup(r7)
            int r8 = r13 >> 9
            r8 = r8 & 14
            r10 = r4
            r18 = 0
            r7 = -849178871(0xffffffffcd628f09, float:-2.37564048E8)
            r21 = r8
            java.lang.String r8 = "C299@11943L86,300@12042L46:Snackbar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r7, r8)
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r7, r3)
            float r8 = SnackbarVerticalPadding
            r23 = r3
            r3 = 1
            r24 = r9
            r9 = 0
            r27 = r11
            r11 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m2250paddingVpY3zN4$default(r7, r11, r8, r3, r9)
            r7 = 6
            r8 = 0
            r9 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r10.startReplaceableGroup(r9)
            java.lang.String r11 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r11)
            androidx.compose.ui.Alignment$Companion r28 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r9 = r28.getTopStart()
            r28 = r8
            r8 = 0
            int r30 = r7 >> 3
            r30 = r30 & 14
            int r31 = r7 >> 3
            r31 = r31 & 112(0x70, float:1.57E-43)
            r32 = r13
            r13 = r30 | r31
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r9, r8, r10, r13)
            int r30 = r7 << 3
            r30 = r30 & 112(0x70, float:1.57E-43)
            r31 = 0
            r33 = r8
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r10.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r12)
            r8 = 0
            int r34 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r10, r8)
            androidx.compose.runtime.CompositionLocalMap r8 = r10.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r35 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r35 = r35.getConstructor()
            kotlin.jvm.functions.Function3 r36 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            r37 = r3
            int r3 = r30 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | 6
            r38 = r36
            r36 = r35
            r35 = 0
            r39 = r9
            androidx.compose.runtime.Applier r9 = r10.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x01c5
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01c5:
            r10.startReusableNode()
            boolean r9 = r10.getInserting()
            if (r9 == 0) goto L_0x01d4
            r9 = r36
            r10.createNode(r9)
            goto L_0x01d9
        L_0x01d4:
            r9 = r36
            r10.useNode()
        L_0x01d9:
            r36 = r9
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m4575constructorimpl(r10)
            r40 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r41 = androidx.compose.ui.node.ComposeUiNode.Companion
            r42 = r14
            kotlin.jvm.functions.Function2 r14 = r41.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r13, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r8, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetCompositeKeyHash()
            r41 = 0
            r43 = r9
            r44 = 0
            boolean r45 = r43.getInserting()
            if (r45 != 0) goto L_0x021d
            r45 = r8
            java.lang.Object r8 = r43.rememberedValue()
            r46 = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r34)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r13)
            if (r8 != 0) goto L_0x021a
            goto L_0x0221
        L_0x021a:
            r13 = r43
            goto L_0x0231
        L_0x021d:
            r45 = r8
            r46 = r13
        L_0x0221:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r34)
            r13 = r43
            r13.updateRememberedValue(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r34)
            r9.apply(r8, r14)
        L_0x0231:
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r10)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r8)
            int r9 = r3 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r13 = r38
            r13.invoke(r8, r10, r9)
            r8 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r10.startReplaceableGroup(r8)
            int r8 = r3 >> 9
            r8 = r8 & 14
            r9 = r10
            r14 = 0
            r38 = r3
            r3 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r40 = r8
            java.lang.String r8 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r3, r8)
            androidx.compose.foundation.layout.BoxScopeInstance r41 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r43 = r7 >> 6
            r43 = r43 & 112(0x70, float:1.57E-43)
            r43 = r43 | 6
            androidx.compose.foundation.layout.BoxScope r41 = (androidx.compose.foundation.layout.BoxScope) r41
            r44 = r9
            r47 = 0
            r3 = -202240392(0xfffffffff3f20e78, float:-3.8355386E31)
            r48 = r7
            java.lang.String r7 = "C299@12021L6:Snackbar.kt#jmzs0o"
            r49 = r13
            r13 = r44
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r3, r7)
            r3 = r5 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.invoke(r13, r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r10.endReplaceableGroup()
            r10.endNode()
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r3, r6)
            r7 = 6
            r9 = 0
            r13 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r10.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r11)
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r11 = r11.getTopStart()
            r13 = 0
            int r14 = r7 >> 3
            r14 = r14 & 14
            int r28 = r7 >> 3
            r28 = r28 & 112(0x70, float:1.57E-43)
            r14 = r14 | r28
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r11, r13, r10, r14)
            int r28 = r7 << 3
            r28 = r28 & 112(0x70, float:1.57E-43)
            r29 = 0
            r30 = r6
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r10.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r12)
            r6 = 0
            int r6 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r10, r6)
            androidx.compose.runtime.CompositionLocalMap r12 = r10.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r19 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r19 = r19.getConstructor()
            kotlin.jvm.functions.Function3 r31 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            r52 = r3
            int r3 = r28 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | 6
            r33 = r31
            r31 = r19
            r19 = 0
            r34 = r9
            androidx.compose.runtime.Applier r9 = r10.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x0306
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0306:
            r10.startReusableNode()
            boolean r9 = r10.getInserting()
            if (r9 == 0) goto L_0x0315
            r9 = r31
            r10.createNode(r9)
            goto L_0x031a
        L_0x0315:
            r9 = r31
            r10.useNode()
        L_0x031a:
            r31 = r9
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m4575constructorimpl(r10)
            r35 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r36 = androidx.compose.ui.node.ComposeUiNode.Companion
            r37 = r11
            kotlin.jvm.functions.Function2 r11 = r36.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r14, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r12, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetCompositeKeyHash()
            r36 = 0
            r38 = r9
            r39 = 0
            boolean r40 = r38.getInserting()
            if (r40 != 0) goto L_0x035e
            r40 = r12
            java.lang.Object r12 = r38.rememberedValue()
            r41 = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 != 0) goto L_0x035b
            goto L_0x0362
        L_0x035b:
            r13 = r38
            goto L_0x0372
        L_0x035e:
            r40 = r12
            r41 = r13
        L_0x0362:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r13 = r38
            r13.updateRememberedValue(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r9.apply(r12, r11)
        L_0x0372:
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r10)
            androidx.compose.runtime.SkippableUpdater r9 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r9)
            int r11 = r3 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r12 = r33
            r12.invoke(r9, r10, r11)
            r9 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r10.startReplaceableGroup(r9)
            int r9 = r3 >> 9
            r9 = r9 & 14
            r11 = r10
            r13 = 0
            r20 = r3
            r3 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r8)
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r8 = r7 >> 6
            r8 = r8 & 112(0x70, float:1.57E-43)
            r8 = r8 | 6
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            r33 = r11
            r35 = 0
            r36 = r3
            r3 = -202240335(0xfffffffff3f20eb1, float:-3.8355524E31)
            r38 = r6
            java.lang.String r6 = "C300@12078L8:Snackbar.kt#jmzs0o"
            r39 = r7
            r7 = r33
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r3, r6)
            int r3 = r5 >> 3
            r3 = r3 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.invoke(r7, r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r10.endReplaceableGroup()
            r10.endNode()
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r4.endReplaceableGroup()
            r4.endNode()
            r4.endReplaceableGroup()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x03f8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03f8:
            androidx.compose.runtime.ScopeUpdateScope r3 = r4.endRestartGroup()
            if (r3 != 0) goto L_0x03ff
            goto L_0x0409
        L_0x03ff:
            androidx.compose.material.SnackbarKt$OneRowSnackbar$3 r6 = new androidx.compose.material.SnackbarKt$OneRowSnackbar$3
            r6.<init>(r0, r1, r2)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r3.updateScope(r6)
        L_0x0409:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.OneRowSnackbar(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }
}

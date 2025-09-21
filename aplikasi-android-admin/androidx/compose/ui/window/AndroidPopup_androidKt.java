package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aX\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aD\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001a(\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0018\u001a+\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0013\b\b\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\b¢\u0006\u0002\u0010\u001c\u001a\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u001a\f\u0010\"\u001a\u00020\u001e*\u00020 H\u0000\u001a\f\u0010#\u001a\u00020$*\u00020%H\u0002\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006&²\u0006\u0015\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010X\u0002"}, d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Popup", "", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Landroidx/compose/runtime/Composable;", "Popup-K5zGePQ", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PopupTestTag", "tag", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isPopupLayout", "", "view", "Landroid/view/View;", "testTag", "isFlagSecureEnabled", "toIntBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/graphics/Rect;", "ui_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
public final class AndroidPopup_androidKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, AndroidPopup_androidKt$LocalPopupTestTag$1.INSTANCE, 1, (Object) null);

    /* JADX WARNING: Removed duplicated region for block: B:80:0x017c  */
    /* renamed from: Popup-K5zGePQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m7796PopupK5zGePQ(androidx.compose.ui.Alignment r25, long r26, kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.window.PopupProperties r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r9 = r30
            r10 = r32
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 295309329(0x119a1011, float:2.4306818E-28)
            r1 = r31
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Popup)P(!1,2:c#ui.unit.IntOffset,3,4)193@8637L128,200@8771L165:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r32
            r2 = r33 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r25
            goto L_0x0035
        L_0x0022:
            r3 = r10 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r25
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0030
            r4 = 4
            goto L_0x0031
        L_0x0030:
            r4 = 2
        L_0x0031:
            r1 = r1 | r4
            goto L_0x0035
        L_0x0033:
            r3 = r25
        L_0x0035:
            r4 = r33 & 2
            if (r4 == 0) goto L_0x003e
            r1 = r1 | 48
            r5 = r26
            goto L_0x0053
        L_0x003e:
            r5 = r10 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0051
            r5 = r26
            boolean r7 = r11.changed((long) r5)
            if (r7 == 0) goto L_0x004d
            r7 = 32
            goto L_0x004f
        L_0x004d:
            r7 = 16
        L_0x004f:
            r1 = r1 | r7
            goto L_0x0053
        L_0x0051:
            r5 = r26
        L_0x0053:
            r7 = r33 & 4
            if (r7 == 0) goto L_0x005c
            r1 = r1 | 384(0x180, float:5.38E-43)
            r8 = r28
            goto L_0x0071
        L_0x005c:
            r8 = r10 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x006f
            r8 = r28
            boolean r12 = r11.changedInstance(r8)
            if (r12 == 0) goto L_0x006b
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x006d
        L_0x006b:
            r12 = 128(0x80, float:1.794E-43)
        L_0x006d:
            r1 = r1 | r12
            goto L_0x0071
        L_0x006f:
            r8 = r28
        L_0x0071:
            r12 = r33 & 8
            if (r12 == 0) goto L_0x007a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r13 = r29
            goto L_0x008f
        L_0x007a:
            r13 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x008d
            r13 = r29
            boolean r14 = r11.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0089
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x008b
        L_0x0089:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x008b:
            r1 = r1 | r14
            goto L_0x008f
        L_0x008d:
            r13 = r29
        L_0x008f:
            r14 = r33 & 16
            if (r14 == 0) goto L_0x0096
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a8
        L_0x0096:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00a8
            boolean r14 = r11.changedInstance(r9)
            if (r14 == 0) goto L_0x00a5
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a5:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00a7:
            r1 = r1 | r14
        L_0x00a8:
            r14 = r1
            r1 = 46811(0xb6db, float:6.5596E-41)
            r1 = r1 & r14
            r15 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r15) goto L_0x00c1
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x00b8
            goto L_0x00c1
        L_0x00b8:
            r11.skipToGroupEnd()
            r15 = r3
            r17 = r5
            r12 = r8
            goto L_0x0180
        L_0x00c1:
            if (r2 == 0) goto L_0x00cb
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            r15 = r1
            goto L_0x00cc
        L_0x00cb:
            r15 = r3
        L_0x00cc:
            if (r4 == 0) goto L_0x00d4
            r1 = 0
            long r1 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r1, r1)
            r5 = r1
        L_0x00d4:
            if (r7 == 0) goto L_0x00d8
            r1 = 0
            r8 = r1
        L_0x00d8:
            if (r12 == 0) goto L_0x00f2
            androidx.compose.ui.window.PopupProperties r1 = new androidx.compose.ui.window.PopupProperties
            r23 = 63
            r24 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r16 = r1
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)
            r13 = r1
        L_0x00f2:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00fe
            r1 = -1
            java.lang.String r2 = "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r1, r2)
        L_0x00fe:
            androidx.compose.ui.unit.IntOffset r0 = androidx.compose.ui.unit.IntOffset.m7663boximpl(r5)
            r1 = r14 & 14
            r2 = r14 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = 0
            r3 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            boolean r3 = r11.changed((java.lang.Object) r15)
            boolean r4 = r11.changed((java.lang.Object) r0)
            r3 = r3 | r4
            r4 = r11
            r7 = 0
            java.lang.Object r12 = r4.rememberedValue()
            r16 = 0
            if (r3 != 0) goto L_0x0137
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r25 = r0
            java.lang.Object r0 = r17.getEmpty()
            if (r12 != r0) goto L_0x0133
            goto L_0x0139
        L_0x0133:
            r27 = r1
            r0 = r12
            goto L_0x014b
        L_0x0137:
            r25 = r0
        L_0x0139:
            r0 = 0
            r26 = r0
            androidx.compose.ui.window.AlignmentOffsetPositionProvider r0 = new androidx.compose.ui.window.AlignmentOffsetPositionProvider
            r27 = r1
            r1 = 0
            r0.<init>(r15, r5, r1)
            r4.updateRememberedValue(r0)
        L_0x014b:
            r11.endReplaceableGroup()
            r7 = r0
            androidx.compose.ui.window.AlignmentOffsetPositionProvider r7 = (androidx.compose.ui.window.AlignmentOffsetPositionProvider) r7
            r0 = r7
            androidx.compose.ui.window.PopupPositionProvider r0 = (androidx.compose.ui.window.PopupPositionProvider) r0
            int r1 = r14 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            int r2 = r14 >> 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r14 >> 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r12 = r1 | r2
            r16 = 0
            r1 = r8
            r2 = r13
            r3 = r30
            r4 = r11
            r17 = r5
            r5 = r12
            r6 = r16
            Popup(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x017f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x017f:
            r12 = r8
        L_0x0180:
            androidx.compose.runtime.ScopeUpdateScope r8 = r11.endRestartGroup()
            if (r8 != 0) goto L_0x0187
            goto L_0x01a1
        L_0x0187:
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1 r16 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1
            r0 = r16
            r1 = r15
            r2 = r17
            r4 = r12
            r5 = r13
            r6 = r30
            r7 = r32
            r9 = r8
            r8 = r33
            r0.<init>(r1, r2, r4, r5, r6, r7, r8)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x01a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt.m7796PopupK5zGePQ(androidx.compose.ui.Alignment, long, kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x0315  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Popup(androidx.compose.ui.window.PopupPositionProvider r36, kotlin.jvm.functions.Function0<kotlin.Unit> r37, androidx.compose.ui.window.PopupProperties r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r11 = r36
            r12 = r39
            r13 = r41
            java.lang.String r0 = "popupPositionProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -830247068(0xffffffffce836f64, float:-1.1025577E9)
            r1 = r40
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Popup)P(2,1,3)227@9660L7,228@9699L7,229@9743L7,230@9798L7,231@9834L28,232@9889L29,233@9937L38,234@9998L944,262@10948L417,277@11371L229,286@11606L166,298@12335L175,308@12688L771:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r41
            r2 = r42 & 1
            if (r2 == 0) goto L_0x0028
            r1 = r1 | 6
            goto L_0x0036
        L_0x0028:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x0036
            boolean r2 = r14.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x0034
            r2 = 4
            goto L_0x0035
        L_0x0034:
            r2 = 2
        L_0x0035:
            r1 = r1 | r2
        L_0x0036:
            r2 = r42 & 2
            if (r2 == 0) goto L_0x003f
            r1 = r1 | 48
            r3 = r37
            goto L_0x0054
        L_0x003f:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0052
            r3 = r37
            boolean r4 = r14.changedInstance(r3)
            if (r4 == 0) goto L_0x004e
            r4 = 32
            goto L_0x0050
        L_0x004e:
            r4 = 16
        L_0x0050:
            r1 = r1 | r4
            goto L_0x0054
        L_0x0052:
            r3 = r37
        L_0x0054:
            r4 = r42 & 4
            if (r4 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r38
            goto L_0x0072
        L_0x005d:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0070
            r5 = r38
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x006c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r6
            goto L_0x0072
        L_0x0070:
            r5 = r38
        L_0x0072:
            r6 = r42 & 8
            if (r6 == 0) goto L_0x0079
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0079:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0089
            boolean r6 = r14.changedInstance(r12)
            if (r6 == 0) goto L_0x0086
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0088
        L_0x0086:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0088:
            r1 = r1 | r6
        L_0x0089:
            r15 = r1
            r1 = r15 & 5851(0x16db, float:8.199E-42)
            r6 = 1170(0x492, float:1.64E-42)
            if (r1 != r6) goto L_0x00a0
            boolean r1 = r14.getSkipping()
            if (r1 != 0) goto L_0x0097
            goto L_0x00a0
        L_0x0097:
            r14.skipToGroupEnd()
            r16 = r3
            r17 = r5
            goto L_0x0318
        L_0x00a0:
            if (r2 == 0) goto L_0x00a6
            r1 = 0
            r16 = r1
            goto L_0x00a8
        L_0x00a6:
            r16 = r3
        L_0x00a8:
            if (r4 == 0) goto L_0x00c2
            androidx.compose.ui.window.PopupProperties r1 = new androidx.compose.ui.window.PopupProperties
            r24 = 63
            r25 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r17 = r1
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25)
            goto L_0x00c4
        L_0x00c2:
            r17 = r5
        L_0x00c4:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00d0
            r1 = -1
            java.lang.String r2 = "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:221)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r1, r2)
        L_0x00d0:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r4)
            java.lang.Object r5 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r18 = r5
            android.view.View r18 = (android.view.View) r18
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r4)
            java.lang.Object r5 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r19 = r5
            androidx.compose.ui.unit.Density r19 = (androidx.compose.ui.unit.Density) r19
            androidx.compose.runtime.ProvidableCompositionLocal<java.lang.String> r0 = LocalPopupTestTag
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r4)
            java.lang.Object r5 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r20 = r5
            java.lang.String r20 = (java.lang.String) r20
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r4)
            java.lang.Object r3 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r10 = r3
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            r9 = 0
            androidx.compose.runtime.CompositionContext r8 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r14, r9)
            int r0 = r15 >> 9
            r0 = r0 & 14
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r12, r14, r0)
            java.lang.Object[] r1 = new java.lang.Object[r9]
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1 r2 = androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1.INSTANCE
            r4 = r2
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r6 = 3080(0xc08, float:4.316E-42)
            r7 = 6
            r2 = 0
            r3 = 0
            r5 = r14
            java.lang.Object r1 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            r7 = r1
            java.util.UUID r7 = (java.util.UUID) r7
            r21 = r9
            r22 = 0
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r23 = 0
            r6 = r14
            r24 = 0
            java.lang.Object r5 = r6.rememberedValue()
            r25 = 0
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r5 != r1) goto L_0x01ca
            r26 = 0
            androidx.compose.ui.window.PopupLayout r27 = new androidx.compose.ui.window.PopupLayout
            java.lang.String r1 = "popupId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            r28 = 128(0x80, float:1.794E-43)
            r29 = 0
            r30 = 0
            r4 = r0
            r0 = r27
            r1 = r16
            r2 = r17
            r3 = r20
            r31 = r4
            r4 = r18
            r32 = r5
            r5 = r19
            r33 = r6
            r6 = r36
            r34 = r7
            r35 = r8
            r8 = r30
            r9 = r28
            r37 = r10
            r10 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = 0
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1 r2 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1
            r3 = r31
            r2.<init>(r0, r3)
            r4 = 1302892335(0x4da88f2f, float:3.53494496E8)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r4, r5, r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r4 = r35
            r0.setContent(r4, r2)
            r5 = r27
            r0 = r33
            r0.updateRememberedValue(r5)
            goto L_0x01d3
        L_0x01ca:
            r3 = r0
            r32 = r5
            r0 = r6
            r34 = r7
            r4 = r8
            r37 = r10
        L_0x01d3:
            r14.endReplaceableGroup()
            r0 = r5
            androidx.compose.ui.window.PopupLayout r0 = (androidx.compose.ui.window.PopupLayout) r0
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2 r1 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2
            r5 = r1
            r6 = r0
            r7 = r16
            r8 = r17
            r9 = r20
            r10 = r37
            r5.<init>(r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r2 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r1, (androidx.compose.runtime.Composer) r14, (int) r2)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3 r1 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r2 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r1, r14, r2)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4 r1 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4
            r1.<init>(r0, r11)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r5 = r15 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r1, (androidx.compose.runtime.Composer) r14, (int) r5)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5 r1 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5
            r5 = 0
            r1.<init>(r0, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r5 = 72
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r1, (androidx.compose.runtime.Composer) r14, (int) r5)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7 r5 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7
            r5.<init>(r0)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r1, r5)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8 r5 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8
            r6 = r37
            r5.<init>(r0, r6)
            androidx.compose.ui.layout.MeasurePolicy r5 = (androidx.compose.ui.layout.MeasurePolicy) r5
            r7 = r2
            r8 = 0
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r14.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r9)
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r14, r2)
            androidx.compose.runtime.CompositionLocalMap r9 = r14.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r21 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r1)
            r37 = r0
            int r0 = r7 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r38 = r21
            r21 = 0
            r40 = r1
            androidx.compose.runtime.Applier r1 = r14.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x0268
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0268:
            r14.startReusableNode()
            boolean r1 = r14.getInserting()
            if (r1 == 0) goto L_0x0275
            r14.createNode(r10)
            goto L_0x0278
        L_0x0275:
            r14.useNode()
        L_0x0278:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m4575constructorimpl(r14)
            r22 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r23 = androidx.compose.ui.node.ComposeUiNode.Companion
            r31 = r3
            kotlin.jvm.functions.Function2 r3 = r23.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r5, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r9, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            r23 = 0
            r24 = r1
            r25 = 0
            boolean r26 = r24.getInserting()
            if (r26 != 0) goto L_0x02ba
            r35 = r4
            java.lang.Object r4 = r24.rememberedValue()
            r26 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x02b7
            goto L_0x02be
        L_0x02b7:
            r5 = r24
            goto L_0x02ce
        L_0x02ba:
            r35 = r4
            r26 = r5
        L_0x02be:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r5 = r24
            r5.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r1.apply(r4, r3)
        L_0x02ce:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r14)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r1)
            int r3 = r0 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = r38
            r4.invoke(r1, r14, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r1)
            int r1 = r0 >> 9
            r1 = r1 & 14
            r3 = r14
            r5 = 0
            r38 = r0
            r0 = 1097164901(0x41656865, float:14.337987)
            r22 = r1
            java.lang.String r1 = "C:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r14.endReplaceableGroup()
            r14.endNode()
            r14.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0318
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0318:
            androidx.compose.runtime.ScopeUpdateScope r7 = r14.endRestartGroup()
            if (r7 != 0) goto L_0x031f
            goto L_0x0336
        L_0x031f:
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$9 r8 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$9
            r0 = r8
            r1 = r36
            r2 = r16
            r3 = r17
            r4 = r39
            r5 = r41
            r6 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x0336:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt.Popup(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> Popup$lambda$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> $currentContent$delegate) {
        return (Function2) $currentContent$delegate.getValue();
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    public static final void PopupTestTag(String tag, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-498879600);
        ComposerKt.sourceInformation($composer2, "C(PopupTestTag)P(1)332@13834L75:AndroidPopup.android.kt#2oxthz");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) tag) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-498879600, $dirty, -1, "androidx.compose.ui.window.PopupTestTag (AndroidPopup.android.kt:331)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{LocalPopupTestTag.provides(tag)}, content, $composer2, ($dirty & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidPopup_androidKt$PopupTestTag$1(tag, content, $changed));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0094, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r15.rememberedValue(), (java.lang.Object) java.lang.Integer.valueOf(r5)) == false) goto L_0x009b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void SimpleStack(androidx.compose.ui.Modifier r19, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, int r22) {
        /*
            r0 = r21
            r1 = 0
            r2 = 1406149896(0x53d02508, float:1.78794896E12)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(SimpleStack)P(1)340@14172L979:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1 r2 = androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r2 = (androidx.compose.ui.layout.MeasurePolicy) r2
            int r3 = r22 >> 3
            r3 = r3 & 14
            int r4 = r22 << 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r4 = 0
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            r5 = 0
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r0, r5)
            androidx.compose.runtime.CompositionLocalMap r6 = r21.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r19)
            int r9 = r3 << 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | 6
            r10 = 0
            androidx.compose.runtime.Applier r11 = r21.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x004d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x004d:
            r21.startReusableNode()
            boolean r11 = r21.getInserting()
            if (r11 == 0) goto L_0x005a
            r0.createNode(r7)
            goto L_0x005d
        L_0x005a:
            r21.useNode()
        L_0x005d:
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m4575constructorimpl(r21)
            r12 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r2, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r6, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetCompositeKeyHash()
            r14 = 0
            r15 = r11
            r16 = 0
            boolean r17 = r15.getInserting()
            if (r17 != 0) goto L_0x0097
            r17 = r1
            java.lang.Object r1 = r15.rememberedValue()
            r18 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x00a9
            goto L_0x009b
        L_0x0097:
            r17 = r1
            r18 = r2
        L_0x009b:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r15.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r11.apply(r1, r13)
        L_0x00a9:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r21)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r1)
            int r2 = r9 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r8.invoke(r1, r0, r2)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            int r1 = r9 >> 9
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2 = r20
            r2.invoke(r0, r1)
            r21.endReplaceableGroup()
            r21.endNode()
            r21.endReplaceableGroup()
            r21.endReplaceableGroup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt.SimpleStack(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    public static final boolean isFlagSecureEnabled(View $this$isFlagSecureEnabled) {
        Intrinsics.checkNotNullParameter($this$isFlagSecureEnabled, "<this>");
        ViewGroup.LayoutParams layoutParams = $this$isFlagSecureEnabled.getRootView().getLayoutParams();
        WindowManager.LayoutParams windowParams = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        if (windowParams == null || (windowParams.flags & 8192) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final IntRect toIntBounds(Rect $this$toIntBounds) {
        return new IntRect($this$toIntBounds.left, $this$toIntBounds.top, $this$toIntBounds.right, $this$toIntBounds.bottom);
    }

    public static /* synthetic */ boolean isPopupLayout$default(View view, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return isPopupLayout(view, str);
    }

    public static final boolean isPopupLayout(View view, String testTag) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (view instanceof PopupLayout) && (testTag == null || Intrinsics.areEqual((Object) testTag, (Object) ((PopupLayout) view).getTestTag()));
    }
}

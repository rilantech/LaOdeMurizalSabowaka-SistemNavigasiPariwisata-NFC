package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aé\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u001aß\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u001aÉ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\u001aÓ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00106\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Text.kt */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), TextKt$LocalTextStyle$1.INSTANCE);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: Text--4IGK_g  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m3858Text4IGK_g(java.lang.String r65, androidx.compose.ui.Modifier r66, long r67, long r69, androidx.compose.ui.text.font.FontStyle r71, androidx.compose.ui.text.font.FontWeight r72, androidx.compose.ui.text.font.FontFamily r73, long r74, androidx.compose.ui.text.style.TextDecoration r76, androidx.compose.ui.text.style.TextAlign r77, long r78, int r80, boolean r81, int r82, int r83, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r84, androidx.compose.ui.text.TextStyle r85, androidx.compose.runtime.Composer r86, int r87, int r88, int r89) {
        /*
            r14 = r65
            r15 = r87
            r13 = r88
            r12 = r89
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -2055108902(0xffffffff858186da, float:-1.2180638E-35)
            r1 = r86
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12)108@5583L7,131@6301L162:Text.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r87
            r2 = r88
            r3 = r12 & 1
            if (r3 == 0) goto L_0x0027
            r1 = r1 | 6
            goto L_0x0035
        L_0x0027:
            r3 = r15 & 14
            if (r3 != 0) goto L_0x0035
            boolean r3 = r10.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0033
            r3 = 4
            goto L_0x0034
        L_0x0033:
            r3 = 2
        L_0x0034:
            r1 = r1 | r3
        L_0x0035:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x003e
            r1 = r1 | 48
            r8 = r66
            goto L_0x0053
        L_0x003e:
            r8 = r15 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0051
            r8 = r66
            boolean r9 = r10.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x004d
            r9 = 32
            goto L_0x004f
        L_0x004d:
            r9 = 16
        L_0x004f:
            r1 = r1 | r9
            goto L_0x0053
        L_0x0051:
            r8 = r66
        L_0x0053:
            r9 = r12 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x005e
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r67
            goto L_0x0074
        L_0x005e:
            r4 = r15 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0072
            r5 = r67
            boolean r18 = r10.changed((long) r5)
            if (r18 == 0) goto L_0x006d
            r18 = 256(0x100, float:3.59E-43)
            goto L_0x006f
        L_0x006d:
            r18 = r16
        L_0x006f:
            r1 = r1 | r18
            goto L_0x0074
        L_0x0072:
            r5 = r67
        L_0x0074:
            r18 = r12 & 8
            r19 = 2048(0x800, float:2.87E-42)
            r20 = 1024(0x400, float:1.435E-42)
            if (r18 == 0) goto L_0x0081
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r69
            goto L_0x0097
        L_0x0081:
            r4 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0095
            r7 = r69
            boolean r22 = r10.changed((long) r7)
            if (r22 == 0) goto L_0x0090
            r22 = r19
            goto L_0x0092
        L_0x0090:
            r22 = r20
        L_0x0092:
            r1 = r1 | r22
            goto L_0x0097
        L_0x0095:
            r7 = r69
        L_0x0097:
            r22 = r12 & 16
            r23 = 16384(0x4000, float:2.2959E-41)
            r24 = 8192(0x2000, float:1.14794E-41)
            r25 = 57344(0xe000, float:8.0356E-41)
            if (r22 == 0) goto L_0x00a7
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r4 = r71
            goto L_0x00bd
        L_0x00a7:
            r26 = r15 & r25
            if (r26 != 0) goto L_0x00bb
            r4 = r71
            boolean r27 = r10.changed((java.lang.Object) r4)
            if (r27 == 0) goto L_0x00b6
            r27 = r23
            goto L_0x00b8
        L_0x00b6:
            r27 = r24
        L_0x00b8:
            r1 = r1 | r27
            goto L_0x00bd
        L_0x00bb:
            r4 = r71
        L_0x00bd:
            r27 = r12 & 32
            r28 = 458752(0x70000, float:6.42848E-40)
            r29 = 65536(0x10000, float:9.18355E-41)
            if (r27 == 0) goto L_0x00cc
            r30 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r30
            r11 = r72
            goto L_0x00e2
        L_0x00cc:
            r30 = r15 & r28
            if (r30 != 0) goto L_0x00e0
            r11 = r72
            boolean r31 = r10.changed((java.lang.Object) r11)
            if (r31 == 0) goto L_0x00db
            r31 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00dd
        L_0x00db:
            r31 = r29
        L_0x00dd:
            r1 = r1 | r31
            goto L_0x00e2
        L_0x00e0:
            r11 = r72
        L_0x00e2:
            r31 = r12 & 64
            r32 = 3670016(0x380000, float:5.142788E-39)
            if (r31 == 0) goto L_0x00ef
            r33 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r33
            r0 = r73
            goto L_0x0105
        L_0x00ef:
            r33 = r15 & r32
            if (r33 != 0) goto L_0x0103
            r0 = r73
            boolean r34 = r10.changed((java.lang.Object) r0)
            if (r34 == 0) goto L_0x00fe
            r34 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0100
        L_0x00fe:
            r34 = 524288(0x80000, float:7.34684E-40)
        L_0x0100:
            r1 = r1 | r34
            goto L_0x0105
        L_0x0103:
            r0 = r73
        L_0x0105:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0110
            r34 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r34
            r4 = r74
            goto L_0x0127
        L_0x0110:
            r34 = 29360128(0x1c00000, float:7.052966E-38)
            r34 = r15 & r34
            if (r34 != 0) goto L_0x0125
            r4 = r74
            boolean r6 = r10.changed((long) r4)
            if (r6 == 0) goto L_0x0121
            r6 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0123
        L_0x0121:
            r6 = 4194304(0x400000, float:5.877472E-39)
        L_0x0123:
            r1 = r1 | r6
            goto L_0x0127
        L_0x0125:
            r4 = r74
        L_0x0127:
            r6 = r12 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x0132
            r34 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r34
            r4 = r76
            goto L_0x0149
        L_0x0132:
            r34 = 234881024(0xe000000, float:1.5777218E-30)
            r34 = r15 & r34
            if (r34 != 0) goto L_0x0147
            r4 = r76
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0143
            r5 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0145
        L_0x0143:
            r5 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0145:
            r1 = r1 | r5
            goto L_0x0149
        L_0x0147:
            r4 = r76
        L_0x0149:
            r5 = r12 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0154
            r34 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r34
            r4 = r77
            goto L_0x016c
        L_0x0154:
            r34 = 1879048192(0x70000000, float:1.58456325E29)
            r34 = r15 & r34
            if (r34 != 0) goto L_0x016a
            r4 = r77
            boolean r34 = r10.changed((java.lang.Object) r4)
            if (r34 == 0) goto L_0x0165
            r34 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0167
        L_0x0165:
            r34 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0167:
            r1 = r1 | r34
            goto L_0x016c
        L_0x016a:
            r4 = r77
        L_0x016c:
            r4 = r12 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0175
            r2 = r2 | 6
            r7 = r78
            goto L_0x018b
        L_0x0175:
            r34 = r13 & 14
            if (r34 != 0) goto L_0x0189
            r7 = r78
            boolean r34 = r10.changed((long) r7)
            if (r34 == 0) goto L_0x0184
            r21 = 4
            goto L_0x0186
        L_0x0184:
            r21 = 2
        L_0x0186:
            r2 = r2 | r21
            goto L_0x018b
        L_0x0189:
            r7 = r78
        L_0x018b:
            r7 = r12 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x0194
            r2 = r2 | 48
            r8 = r80
            goto L_0x01aa
        L_0x0194:
            r8 = r13 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x01a8
            r8 = r80
            boolean r21 = r10.changed((int) r8)
            if (r21 == 0) goto L_0x01a3
            r26 = 32
            goto L_0x01a5
        L_0x01a3:
            r26 = 16
        L_0x01a5:
            r2 = r2 | r26
            goto L_0x01aa
        L_0x01a8:
            r8 = r80
        L_0x01aa:
            r8 = r12 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x01b3
            r2 = r2 | 384(0x180, float:5.38E-43)
            r11 = r81
            goto L_0x01c9
        L_0x01b3:
            r11 = r13 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x01c7
            r11 = r81
            boolean r17 = r10.changed((boolean) r11)
            if (r17 == 0) goto L_0x01c2
            r30 = 256(0x100, float:3.59E-43)
            goto L_0x01c4
        L_0x01c2:
            r30 = r16
        L_0x01c4:
            r2 = r2 | r30
            goto L_0x01c9
        L_0x01c7:
            r11 = r81
        L_0x01c9:
            r11 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x01d2
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r14 = r82
            goto L_0x01e6
        L_0x01d2:
            r14 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r14 != 0) goto L_0x01e4
            r14 = r82
            boolean r16 = r10.changed((int) r14)
            if (r16 == 0) goto L_0x01df
            goto L_0x01e1
        L_0x01df:
            r19 = r20
        L_0x01e1:
            r2 = r2 | r19
            goto L_0x01e6
        L_0x01e4:
            r14 = r82
        L_0x01e6:
            r14 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r14 == 0) goto L_0x01f1
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r16 = r14
            r14 = r83
            goto L_0x0209
        L_0x01f1:
            r16 = r13 & r25
            if (r16 != 0) goto L_0x0205
            r16 = r14
            r14 = r83
            boolean r17 = r10.changed((int) r14)
            if (r17 == 0) goto L_0x0200
            goto L_0x0202
        L_0x0200:
            r23 = r24
        L_0x0202:
            r2 = r2 | r23
            goto L_0x0209
        L_0x0205:
            r16 = r14
            r14 = r83
        L_0x0209:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r12 & r17
            if (r17 == 0) goto L_0x0217
            r19 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r19
            r14 = r84
            goto L_0x022d
        L_0x0217:
            r19 = r13 & r28
            if (r19 != 0) goto L_0x022b
            r14 = r84
            boolean r19 = r10.changedInstance(r14)
            if (r19 == 0) goto L_0x0226
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0228
        L_0x0226:
            r19 = r29
        L_0x0228:
            r2 = r2 | r19
            goto L_0x022d
        L_0x022b:
            r14 = r84
        L_0x022d:
            r19 = r13 & r32
            if (r19 != 0) goto L_0x0247
            r19 = r12 & r29
            if (r19 != 0) goto L_0x0240
            r13 = r85
            boolean r19 = r10.changed((java.lang.Object) r13)
            if (r19 == 0) goto L_0x0242
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0244
        L_0x0240:
            r13 = r85
        L_0x0242:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x0244:
            r2 = r2 | r19
            goto L_0x0249
        L_0x0247:
            r13 = r85
        L_0x0249:
            r19 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r13 = r1 & r19
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r13 != r14) goto L_0x028a
            r13 = 2995931(0x2db6db, float:4.198194E-39)
            r13 = r13 & r2
            r14 = 599186(0x92492, float:8.39638E-40)
            if (r13 != r14) goto L_0x028a
            boolean r13 = r10.getSkipping()
            if (r13 != 0) goto L_0x0263
            goto L_0x028a
        L_0x0263:
            r10.skipToGroupEnd()
            r25 = r66
            r26 = r67
            r28 = r69
            r30 = r71
            r31 = r72
            r32 = r73
            r33 = r74
            r35 = r76
            r36 = r77
            r37 = r78
            r39 = r80
            r40 = r81
            r41 = r82
            r42 = r83
            r43 = r84
            r44 = r85
            r45 = r2
            goto L_0x04ea
        L_0x028a:
            r10.startDefaults()
            r13 = r15 & 1
            if (r13 == 0) goto L_0x02e9
            boolean r13 = r10.getDefaultsInvalid()
            if (r13 == 0) goto L_0x0298
            goto L_0x02e9
        L_0x0298:
            r10.skipToGroupEnd()
            r0 = r12 & r29
            if (r0 == 0) goto L_0x02c6
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r0 & r2
            r13 = r67
            r18 = r69
            r9 = r71
            r20 = r72
            r21 = r73
            r22 = r74
            r2 = r76
            r5 = r77
            r26 = r78
            r3 = r80
            r6 = r81
            r7 = r82
            r8 = r83
            r11 = r84
            r4 = r85
            r12 = r0
            r0 = r66
            goto L_0x03a8
        L_0x02c6:
            r0 = r66
            r13 = r67
            r18 = r69
            r9 = r71
            r20 = r72
            r21 = r73
            r22 = r74
            r5 = r77
            r26 = r78
            r3 = r80
            r6 = r81
            r7 = r82
            r8 = r83
            r11 = r84
            r4 = r85
            r12 = r2
            r2 = r76
            goto L_0x03a8
        L_0x02e9:
            if (r3 == 0) goto L_0x02f0
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x02f2
        L_0x02f0:
            r3 = r66
        L_0x02f2:
            if (r9 == 0) goto L_0x02fb
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r9.m4999getUnspecified0d7_KjU()
            goto L_0x02fd
        L_0x02fb:
            r13 = r67
        L_0x02fd:
            if (r18 == 0) goto L_0x0306
            androidx.compose.ui.unit.TextUnit$Companion r9 = androidx.compose.ui.unit.TextUnit.Companion
            long r18 = r9.m7746getUnspecifiedXSAIIZE()
            goto L_0x0308
        L_0x0306:
            r18 = r69
        L_0x0308:
            if (r22 == 0) goto L_0x030c
            r9 = 0
            goto L_0x030e
        L_0x030c:
            r9 = r71
        L_0x030e:
            if (r27 == 0) goto L_0x0313
            r20 = 0
            goto L_0x0315
        L_0x0313:
            r20 = r72
        L_0x0315:
            if (r31 == 0) goto L_0x031a
            r21 = 0
            goto L_0x031c
        L_0x031a:
            r21 = r73
        L_0x031c:
            if (r0 == 0) goto L_0x0325
            androidx.compose.ui.unit.TextUnit$Companion r0 = androidx.compose.ui.unit.TextUnit.Companion
            long r22 = r0.m7746getUnspecifiedXSAIIZE()
            goto L_0x0327
        L_0x0325:
            r22 = r74
        L_0x0327:
            if (r6 == 0) goto L_0x032b
            r0 = 0
            goto L_0x032d
        L_0x032b:
            r0 = r76
        L_0x032d:
            if (r5 == 0) goto L_0x0331
            r5 = 0
            goto L_0x0333
        L_0x0331:
            r5 = r77
        L_0x0333:
            if (r4 == 0) goto L_0x033c
            androidx.compose.ui.unit.TextUnit$Companion r4 = androidx.compose.ui.unit.TextUnit.Companion
            long r26 = r4.m7746getUnspecifiedXSAIIZE()
            goto L_0x033e
        L_0x033c:
            r26 = r78
        L_0x033e:
            if (r7 == 0) goto L_0x0347
            androidx.compose.ui.text.style.TextOverflow$Companion r4 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r4 = r4.m7466getClipgIe3tQ8()
            goto L_0x0349
        L_0x0347:
            r4 = r80
        L_0x0349:
            if (r8 == 0) goto L_0x034d
            r6 = 1
            goto L_0x034f
        L_0x034d:
            r6 = r81
        L_0x034f:
            if (r11 == 0) goto L_0x0355
            r7 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0357
        L_0x0355:
            r7 = r82
        L_0x0357:
            if (r16 == 0) goto L_0x035b
            r8 = 1
            goto L_0x035d
        L_0x035b:
            r8 = r83
        L_0x035d:
            if (r17 == 0) goto L_0x0364
            androidx.compose.material3.TextKt$Text$1 r11 = androidx.compose.material3.TextKt$Text$1.INSTANCE
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            goto L_0x0366
        L_0x0364:
            r11 = r84
        L_0x0366:
            r16 = r12 & r29
            if (r16 == 0) goto L_0x0399
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r16 = LocalTextStyle
            r66 = r0
            r0 = r16
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r16 = 6
            r17 = 0
            r86 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            r67 = r4
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r4)
            java.lang.Object r3 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r0 = r3
            androidx.compose.ui.text.TextStyle r0 = (androidx.compose.ui.text.TextStyle) r0
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r2 = r2 & r3
            r3 = r67
            r4 = r0
            r12 = r2
            r2 = r66
            r0 = r86
            goto L_0x03a8
        L_0x0399:
            r66 = r0
            r86 = r3
            r67 = r4
            r3 = r67
            r4 = r85
            r0 = r86
            r12 = r2
            r2 = r66
        L_0x03a8:
            r10.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x03bc
            java.lang.String r15 = "androidx.compose.material3.Text (Text.kt:91)"
            r77 = r8
            r8 = -2055108902(0xffffffff858186da, float:-1.2180638E-35)
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r1, r12, r15)
            goto L_0x03be
        L_0x03bc:
            r77 = r8
        L_0x03be:
            r8 = 79582822(0x4be5666, float:4.474813E-36)
            r10.startReplaceableGroup(r8)
            java.lang.String r8 = "*113@5698L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r8)
            r15 = r13
            r8 = 0
            r29 = r15
            r17 = 0
            androidx.compose.ui.graphics.Color$Companion r24 = androidx.compose.ui.graphics.Color.Companion
            long r33 = r24.m4999getUnspecified0d7_KjU()
            int r24 = (r29 > r33 ? 1 : (r29 == r33 ? 0 : -1))
            r31 = 1
            if (r24 == 0) goto L_0x03de
            r24 = r31
            goto L_0x03e0
        L_0x03de:
            r24 = 0
        L_0x03e0:
            if (r24 == 0) goto L_0x03e7
            r78 = r13
            r35 = r15
            goto L_0x0433
        L_0x03e7:
            r17 = 0
            long r29 = r4.m7056getColor0d7_KjU()
            r24 = 0
            r33 = r29
            r35 = 0
            androidx.compose.ui.graphics.Color$Companion r36 = androidx.compose.ui.graphics.Color.Companion
            long r36 = r36.m4999getUnspecified0d7_KjU()
            int r36 = (r33 > r36 ? 1 : (r33 == r36 ? 0 : -1))
            if (r36 == 0) goto L_0x03fe
            goto L_0x0400
        L_0x03fe:
            r31 = 0
        L_0x0400:
            if (r31 == 0) goto L_0x0407
            r66 = r8
            r78 = r13
            goto L_0x0430
        L_0x0407:
            r31 = 0
            androidx.compose.runtime.ProvidableCompositionLocal r33 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            r66 = r8
            r8 = r33
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r33 = 6
            r34 = 0
            r78 = r13
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r14 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r13, r14)
            java.lang.Object r13 = r10.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.graphics.Color r13 = (androidx.compose.ui.graphics.Color) r13
            long r13 = r13.m4973unboximpl()
            r29 = r13
        L_0x0430:
            r35 = r29
        L_0x0433:
            r10.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r8 = new androidx.compose.ui.text.TextStyle
            r34 = r8
            r62 = 4108112(0x3eaf50, float:5.756691E-39)
            r63 = 0
            r41 = 0
            r43 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r52 = 0
            r54 = 0
            r57 = 0
            r58 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r37 = r18
            r39 = r20
            r40 = r9
            r42 = r21
            r44 = r22
            r51 = r2
            r53 = r5
            r55 = r26
            r34.<init>((long) r35, (long) r37, (androidx.compose.ui.text.font.FontWeight) r39, (androidx.compose.ui.text.font.FontStyle) r40, (androidx.compose.ui.text.font.FontSynthesis) r41, (androidx.compose.ui.text.font.FontFamily) r42, (java.lang.String) r43, (long) r44, (androidx.compose.ui.text.style.BaselineShift) r46, (androidx.compose.ui.text.style.TextGeometricTransform) r47, (androidx.compose.ui.text.intl.LocaleList) r48, (long) r49, (androidx.compose.ui.text.style.TextDecoration) r51, (androidx.compose.ui.graphics.Shadow) r52, (androidx.compose.ui.text.style.TextAlign) r53, (androidx.compose.ui.text.style.TextDirection) r54, (long) r55, (androidx.compose.ui.text.style.TextIndent) r57, (androidx.compose.ui.text.PlatformTextStyle) r58, (androidx.compose.ui.text.style.LineHeightStyle) r59, (androidx.compose.ui.text.style.LineBreak) r60, (androidx.compose.ui.text.style.Hyphens) r61, (int) r62, (kotlin.jvm.internal.DefaultConstructorMarker) r63)
            androidx.compose.ui.text.TextStyle r8 = r4.merge((androidx.compose.ui.text.TextStyle) r8)
            r13 = r1 & 14
            r14 = r1 & 112(0x70, float:1.57E-43)
            r13 = r13 | r14
            int r14 = r12 >> 6
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r13 = r13 | r14
            int r14 = r12 << 9
            r14 = r14 & r25
            r13 = r13 | r14
            int r14 = r12 << 9
            r14 = r14 & r28
            r13 = r13 | r14
            int r14 = r12 << 9
            r14 = r14 & r32
            r13 = r13 | r14
            r14 = 29360128(0x1c00000, float:7.052966E-38)
            int r15 = r12 << 9
            r14 = r14 & r15
            r13 = r13 | r14
            r14 = 0
            r66 = r65
            r67 = r0
            r68 = r8
            r69 = r11
            r70 = r3
            r71 = r6
            r72 = r7
            r73 = r77
            r74 = r10
            r75 = r13
            r76 = r14
            androidx.compose.foundation.text.BasicTextKt.m2588BasicText4YKlhWE((java.lang.String) r66, (androidx.compose.ui.Modifier) r67, (androidx.compose.ui.text.TextStyle) r68, (kotlin.jvm.functions.Function1) r69, (int) r70, (boolean) r71, (int) r72, (int) r73, (androidx.compose.runtime.Composer) r74, (int) r75, (int) r76)
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x04c8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04c8:
            r42 = r77
            r25 = r0
            r35 = r2
            r39 = r3
            r44 = r4
            r36 = r5
            r40 = r6
            r41 = r7
            r30 = r9
            r43 = r11
            r45 = r12
            r28 = r18
            r31 = r20
            r32 = r21
            r33 = r22
            r37 = r26
            r26 = r78
        L_0x04ea:
            androidx.compose.runtime.ScopeUpdateScope r14 = r10.endRestartGroup()
            if (r14 != 0) goto L_0x04f5
            r47 = r1
            r48 = r10
            goto L_0x0533
        L_0x04f5:
            androidx.compose.material3.TextKt$Text$2 r46 = new androidx.compose.material3.TextKt$Text$2
            r0 = r46
            r47 = r1
            r1 = r65
            r2 = r25
            r3 = r26
            r5 = r28
            r7 = r30
            r8 = r31
            r9 = r32
            r48 = r10
            r10 = r33
            r12 = r35
            r13 = r36
            r64 = r14
            r14 = r37
            r16 = r39
            r17 = r40
            r18 = r41
            r19 = r42
            r20 = r43
            r21 = r44
            r22 = r87
            r23 = r88
            r24 = r89
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r0 = r46
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r64
            r1.updateScope(r0)
        L_0x0533:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m3858Text4IGK_g(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text-fLXpl1I  reason: not valid java name */
    public static final /* synthetic */ void m3860TextfLXpl1I(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Function1 onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i) {
        int i2;
        TextStyle style2;
        Function1 onTextLayout2;
        int maxLines2;
        boolean softWrap2;
        int overflow2;
        long lineHeight2;
        TextAlign textAlign2;
        TextDecoration textDecoration2;
        long letterSpacing2;
        FontFamily fontFamily2;
        FontWeight fontWeight2;
        long fontSize2;
        long color2;
        Composer $composer2;
        FontStyle fontStyle2;
        Modifier modifier2;
        int $dirty1;
        Modifier modifier3;
        long color3;
        long fontSize3;
        FontStyle fontStyle3;
        FontWeight fontWeight3;
        FontFamily fontFamily3;
        long letterSpacing3;
        TextDecoration textDecoration3;
        TextAlign textAlign3;
        long lineHeight3;
        int overflow3;
        boolean softWrap3;
        int maxLines3;
        Function1 onTextLayout3;
        int i3;
        String str = text;
        int i4 = $changed;
        int i5 = $changed1;
        int i6 = i;
        Intrinsics.checkNotNullParameter(str, "text");
        Composer $composer3 = $composer.startRestartGroup(1968784669);
        ComposerKt.sourceInformation($composer3, "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)164@7243L7,166@7259L322:Text.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if ((i6 & 1) != 0) {
            $dirty |= 6;
        } else if ((i4 & 14) == 0) {
            $dirty |= $composer3.changed((Object) str) ? 4 : 2;
        }
        int i7 = i6 & 2;
        if (i7 != 0) {
            $dirty |= 48;
            Modifier modifier4 = modifier;
        } else if ((i4 & 112) == 0) {
            $dirty |= $composer3.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        int i8 = i6 & 4;
        if (i8 != 0) {
            $dirty |= 384;
            long j = color;
        } else if ((i4 & 896) == 0) {
            $dirty |= $composer3.changed(color) ? 256 : 128;
        } else {
            long j2 = color;
        }
        int i9 = i6 & 8;
        int i10 = 2048;
        if (i9 != 0) {
            $dirty |= 3072;
            long j3 = fontSize;
        } else if ((i4 & 7168) == 0) {
            $dirty |= $composer3.changed(fontSize) ? 2048 : 1024;
        } else {
            long j4 = fontSize;
        }
        int i11 = i6 & 16;
        int i12 = 16384;
        if (i11 != 0) {
            $dirty |= 24576;
            FontStyle fontStyle4 = fontStyle;
        } else if ((i4 & 57344) == 0) {
            $dirty |= $composer3.changed((Object) fontStyle) ? 16384 : 8192;
        } else {
            FontStyle fontStyle5 = fontStyle;
        }
        int i13 = i6 & 32;
        if (i13 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            FontWeight fontWeight4 = fontWeight;
        } else if ((i4 & 458752) == 0) {
            $dirty |= $composer3.changed((Object) fontWeight) ? 131072 : 65536;
        } else {
            FontWeight fontWeight5 = fontWeight;
        }
        int i14 = i6 & 64;
        if (i14 != 0) {
            $dirty |= 1572864;
            FontFamily fontFamily4 = fontFamily;
        } else if ((i4 & 3670016) == 0) {
            $dirty |= $composer3.changed((Object) fontFamily) ? 1048576 : 524288;
        } else {
            FontFamily fontFamily5 = fontFamily;
        }
        int i15 = i6 & 128;
        if (i15 != 0) {
            $dirty |= 12582912;
            long j5 = letterSpacing;
        } else if ((i4 & 29360128) == 0) {
            $dirty |= $composer3.changed(letterSpacing) ? 8388608 : 4194304;
        } else {
            long j6 = letterSpacing;
        }
        int i16 = i6 & 256;
        if (i16 != 0) {
            $dirty |= 100663296;
            TextDecoration textDecoration4 = textDecoration;
        } else if ((i4 & 234881024) == 0) {
            $dirty |= $composer3.changed((Object) textDecoration) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            TextDecoration textDecoration5 = textDecoration;
        }
        int i17 = i6 & 512;
        if (i17 != 0) {
            $dirty |= 805306368;
            TextAlign textAlign4 = textAlign;
        } else if ((i4 & 1879048192) == 0) {
            $dirty |= $composer3.changed((Object) textAlign) ? 536870912 : 268435456;
        } else {
            TextAlign textAlign5 = textAlign;
        }
        int i18 = i6 & 1024;
        if (i18 != 0) {
            $dirty12 |= 6;
            long j7 = lineHeight;
        } else if ((i5 & 14) == 0) {
            $dirty12 |= $composer3.changed(lineHeight) ? 4 : 2;
        } else {
            long j8 = lineHeight;
        }
        int i19 = i6 & 2048;
        if (i19 != 0) {
            $dirty12 |= 48;
            int i20 = overflow;
        } else if ((i5 & 112) == 0) {
            $dirty12 |= $composer3.changed(overflow) ? 32 : 16;
        } else {
            int i21 = overflow;
        }
        int i22 = i6 & 4096;
        if (i22 != 0) {
            $dirty12 |= 384;
            boolean z = softWrap;
        } else if ((i5 & 896) == 0) {
            $dirty12 |= $composer3.changed(softWrap) ? 256 : 128;
        } else {
            boolean z2 = softWrap;
        }
        int i23 = i6 & 8192;
        if (i23 != 0) {
            $dirty12 |= 3072;
            int i24 = maxLines;
        } else if ((i5 & 7168) == 0) {
            if (!$composer3.changed(maxLines)) {
                i10 = 1024;
            }
            $dirty12 |= i10;
        } else {
            int i25 = maxLines;
        }
        int i26 = i6 & 16384;
        if (i26 != 0) {
            $dirty12 |= 24576;
            i2 = i26;
            Function1 function1 = onTextLayout;
        } else if ((i5 & 57344) == 0) {
            i2 = i26;
            if (!$composer3.changedInstance(onTextLayout)) {
                i12 = 8192;
            }
            $dirty12 |= i12;
        } else {
            i2 = i26;
            Function1 function12 = onTextLayout;
        }
        if ((i5 & 458752) == 0) {
            if ((i6 & 32768) != 0) {
                TextStyle textStyle = style;
            } else if ($composer3.changed((Object) style)) {
                i3 = 131072;
                $dirty12 |= i3;
            }
            i3 = 65536;
            $dirty12 |= i3;
        } else {
            TextStyle textStyle2 = style;
        }
        if (($dirty & 1533916891) == 306783378 && (374491 & $dirty12) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            color2 = color;
            fontSize2 = fontSize;
            fontStyle2 = fontStyle;
            fontWeight2 = fontWeight;
            fontFamily2 = fontFamily;
            letterSpacing2 = letterSpacing;
            textDecoration2 = textDecoration;
            textAlign2 = textAlign;
            lineHeight2 = lineHeight;
            overflow2 = overflow;
            softWrap2 = softWrap;
            maxLines2 = maxLines;
            onTextLayout2 = onTextLayout;
            style2 = style;
            int i27 = $dirty;
            int i28 = $dirty12;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if ((i4 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i8 != 0) {
                    color3 = Color.Companion.m4999getUnspecified0d7_KjU();
                } else {
                    color3 = color;
                }
                if (i9 != 0) {
                    fontSize3 = TextUnit.Companion.m7746getUnspecifiedXSAIIZE();
                } else {
                    fontSize3 = fontSize;
                }
                if (i11 != 0) {
                    fontStyle3 = null;
                } else {
                    fontStyle3 = fontStyle;
                }
                if (i13 != 0) {
                    fontWeight3 = null;
                } else {
                    fontWeight3 = fontWeight;
                }
                if (i14 != 0) {
                    fontFamily3 = null;
                } else {
                    fontFamily3 = fontFamily;
                }
                if (i15 != 0) {
                    letterSpacing3 = TextUnit.Companion.m7746getUnspecifiedXSAIIZE();
                } else {
                    letterSpacing3 = letterSpacing;
                }
                if (i16 != 0) {
                    textDecoration3 = null;
                } else {
                    textDecoration3 = textDecoration;
                }
                if (i17 != 0) {
                    textAlign3 = null;
                } else {
                    textAlign3 = textAlign;
                }
                if (i18 != 0) {
                    lineHeight3 = TextUnit.Companion.m7746getUnspecifiedXSAIIZE();
                } else {
                    lineHeight3 = lineHeight;
                }
                if (i19 != 0) {
                    overflow3 = TextOverflow.Companion.m7466getClipgIe3tQ8();
                } else {
                    overflow3 = overflow;
                }
                if (i22 != 0) {
                    softWrap3 = true;
                } else {
                    softWrap3 = softWrap;
                }
                if (i23 != 0) {
                    maxLines3 = Integer.MAX_VALUE;
                } else {
                    maxLines3 = maxLines;
                }
                if (i2 != 0) {
                    onTextLayout3 = TextKt$Text$3.INSTANCE;
                } else {
                    onTextLayout3 = onTextLayout;
                }
                if ((i6 & 32768) != 0) {
                    TextDecoration textDecoration6 = textDecoration3;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(LocalTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textDecoration2 = textDecoration6;
                    style2 = (TextStyle) consume;
                    overflow2 = overflow3;
                    textAlign2 = textAlign3;
                    softWrap2 = softWrap3;
                    maxLines2 = maxLines3;
                    onTextLayout2 = onTextLayout3;
                    color2 = color3;
                    fontSize2 = fontSize3;
                    fontWeight2 = fontWeight3;
                    fontFamily2 = fontFamily3;
                    letterSpacing2 = letterSpacing3;
                    lineHeight2 = lineHeight3;
                    modifier2 = modifier3;
                    $dirty1 = $dirty12 & -458753;
                    fontStyle2 = fontStyle3;
                } else {
                    textDecoration2 = textDecoration3;
                    style2 = style;
                    overflow2 = overflow3;
                    textAlign2 = textAlign3;
                    softWrap2 = softWrap3;
                    maxLines2 = maxLines3;
                    onTextLayout2 = onTextLayout3;
                    color2 = color3;
                    fontSize2 = fontSize3;
                    fontWeight2 = fontWeight3;
                    fontFamily2 = fontFamily3;
                    letterSpacing2 = letterSpacing3;
                    lineHeight2 = lineHeight3;
                    modifier2 = modifier3;
                    $dirty1 = $dirty12;
                    fontStyle2 = fontStyle3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i6 & 32768) != 0) {
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textDecoration2 = textDecoration;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    onTextLayout2 = onTextLayout;
                    style2 = style;
                    $dirty1 = -458753 & $dirty12;
                } else {
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textDecoration2 = textDecoration;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    onTextLayout2 = onTextLayout;
                    style2 = style;
                    $dirty1 = $dirty12;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1968784669, $dirty, $dirty1, "androidx.compose.material3.Text (Text.kt:148)");
            }
            int i29 = $dirty;
            $composer2 = $composer3;
            int i30 = $dirty1;
            m3858Text4IGK_g(text, modifier2, color2, fontSize2, fontStyle2, fontWeight2, fontFamily2, letterSpacing2, textDecoration2, textAlign2, lineHeight2, overflow2, softWrap2, maxLines2, 1, (Function1<? super TextLayoutResult, Unit>) onTextLayout2, style2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | ($dirty & 57344) | ($dirty & 458752) | ($dirty & 3670016) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), ($dirty1 & 14) | 24576 | ($dirty1 & 112) | ($dirty1 & 896) | ($dirty1 & 7168) | (($dirty1 << 3) & 458752) | (($dirty1 << 3) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextKt$Text$4(text, modifier2, color2, fontSize2, fontStyle2, fontWeight2, fontFamily2, letterSpacing2, textDecoration2, textAlign2, lineHeight2, overflow2, softWrap2, maxLines2, onTextLayout2, style2, $changed, $changed1, i));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: Text-IbK3jfQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m3859TextIbK3jfQ(androidx.compose.ui.text.AnnotatedString r66, androidx.compose.ui.Modifier r67, long r68, long r70, androidx.compose.ui.text.font.FontStyle r72, androidx.compose.ui.text.font.FontWeight r73, androidx.compose.ui.text.font.FontFamily r74, long r75, androidx.compose.ui.text.style.TextDecoration r77, androidx.compose.ui.text.style.TextAlign r78, long r79, int r81, boolean r82, int r83, int r84, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r85, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r86, androidx.compose.ui.text.TextStyle r87, androidx.compose.runtime.Composer r88, int r89, int r90, int r91) {
        /*
            r14 = r66
            r15 = r89
            r13 = r90
            r12 = r91
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 2027001676(0x78d1974c, float:3.4008085E34)
            r1 = r88
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Text)P(15,10,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,17,16:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,12:c#ui.text.style.TextOverflow,13,8,9)258@11733L7,280@12450L286:Text.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r89
            r2 = r90
            r3 = r12 & 1
            if (r3 == 0) goto L_0x0027
            r1 = r1 | 6
            goto L_0x0035
        L_0x0027:
            r3 = r15 & 14
            if (r3 != 0) goto L_0x0035
            boolean r3 = r10.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0033
            r3 = 4
            goto L_0x0034
        L_0x0033:
            r3 = 2
        L_0x0034:
            r1 = r1 | r3
        L_0x0035:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x003e
            r1 = r1 | 48
            r8 = r67
            goto L_0x0053
        L_0x003e:
            r8 = r15 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0051
            r8 = r67
            boolean r9 = r10.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x004d
            r9 = 32
            goto L_0x004f
        L_0x004d:
            r9 = 16
        L_0x004f:
            r1 = r1 | r9
            goto L_0x0053
        L_0x0051:
            r8 = r67
        L_0x0053:
            r9 = r12 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x005e
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r68
            goto L_0x0074
        L_0x005e:
            r4 = r15 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0072
            r5 = r68
            boolean r18 = r10.changed((long) r5)
            if (r18 == 0) goto L_0x006d
            r18 = 256(0x100, float:3.59E-43)
            goto L_0x006f
        L_0x006d:
            r18 = r16
        L_0x006f:
            r1 = r1 | r18
            goto L_0x0074
        L_0x0072:
            r5 = r68
        L_0x0074:
            r18 = r12 & 8
            r19 = 2048(0x800, float:2.87E-42)
            r20 = 1024(0x400, float:1.435E-42)
            if (r18 == 0) goto L_0x0081
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r70
            goto L_0x0097
        L_0x0081:
            r4 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0095
            r7 = r70
            boolean r22 = r10.changed((long) r7)
            if (r22 == 0) goto L_0x0090
            r22 = r19
            goto L_0x0092
        L_0x0090:
            r22 = r20
        L_0x0092:
            r1 = r1 | r22
            goto L_0x0097
        L_0x0095:
            r7 = r70
        L_0x0097:
            r22 = r12 & 16
            r23 = 16384(0x4000, float:2.2959E-41)
            r24 = 8192(0x2000, float:1.14794E-41)
            r25 = 57344(0xe000, float:8.0356E-41)
            if (r22 == 0) goto L_0x00a7
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r4 = r72
            goto L_0x00bd
        L_0x00a7:
            r26 = r15 & r25
            if (r26 != 0) goto L_0x00bb
            r4 = r72
            boolean r27 = r10.changed((java.lang.Object) r4)
            if (r27 == 0) goto L_0x00b6
            r27 = r23
            goto L_0x00b8
        L_0x00b6:
            r27 = r24
        L_0x00b8:
            r1 = r1 | r27
            goto L_0x00bd
        L_0x00bb:
            r4 = r72
        L_0x00bd:
            r27 = r12 & 32
            r28 = 65536(0x10000, float:9.18355E-41)
            r29 = 131072(0x20000, float:1.83671E-40)
            if (r27 == 0) goto L_0x00cc
            r30 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r30
            r11 = r73
            goto L_0x00e4
        L_0x00cc:
            r30 = 458752(0x70000, float:6.42848E-40)
            r30 = r15 & r30
            if (r30 != 0) goto L_0x00e2
            r11 = r73
            boolean r31 = r10.changed((java.lang.Object) r11)
            if (r31 == 0) goto L_0x00dd
            r31 = r29
            goto L_0x00df
        L_0x00dd:
            r31 = r28
        L_0x00df:
            r1 = r1 | r31
            goto L_0x00e4
        L_0x00e2:
            r11 = r73
        L_0x00e4:
            r31 = r12 & 64
            r32 = 3670016(0x380000, float:5.142788E-39)
            if (r31 == 0) goto L_0x00f1
            r33 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r33
            r0 = r74
            goto L_0x0107
        L_0x00f1:
            r33 = r15 & r32
            if (r33 != 0) goto L_0x0105
            r0 = r74
            boolean r34 = r10.changed((java.lang.Object) r0)
            if (r34 == 0) goto L_0x0100
            r34 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0102
        L_0x0100:
            r34 = 524288(0x80000, float:7.34684E-40)
        L_0x0102:
            r1 = r1 | r34
            goto L_0x0107
        L_0x0105:
            r0 = r74
        L_0x0107:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r34 = 29360128(0x1c00000, float:7.052966E-38)
            if (r0 == 0) goto L_0x0114
            r35 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r35
            r4 = r75
            goto L_0x0129
        L_0x0114:
            r35 = r15 & r34
            if (r35 != 0) goto L_0x0127
            r4 = r75
            boolean r6 = r10.changed((long) r4)
            if (r6 == 0) goto L_0x0123
            r6 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0125
        L_0x0123:
            r6 = 4194304(0x400000, float:5.877472E-39)
        L_0x0125:
            r1 = r1 | r6
            goto L_0x0129
        L_0x0127:
            r4 = r75
        L_0x0129:
            r6 = r12 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x0134
            r35 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r35
            r4 = r77
            goto L_0x014b
        L_0x0134:
            r35 = 234881024(0xe000000, float:1.5777218E-30)
            r35 = r15 & r35
            if (r35 != 0) goto L_0x0149
            r4 = r77
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0145
            r5 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0147
        L_0x0145:
            r5 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0147:
            r1 = r1 | r5
            goto L_0x014b
        L_0x0149:
            r4 = r77
        L_0x014b:
            r5 = r12 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0156
            r35 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r35
            r4 = r78
            goto L_0x016e
        L_0x0156:
            r35 = 1879048192(0x70000000, float:1.58456325E29)
            r35 = r15 & r35
            if (r35 != 0) goto L_0x016c
            r4 = r78
            boolean r35 = r10.changed((java.lang.Object) r4)
            if (r35 == 0) goto L_0x0167
            r35 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0169
        L_0x0167:
            r35 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0169:
            r1 = r1 | r35
            goto L_0x016e
        L_0x016c:
            r4 = r78
        L_0x016e:
            r4 = r12 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0177
            r2 = r2 | 6
            r7 = r79
            goto L_0x018d
        L_0x0177:
            r35 = r13 & 14
            if (r35 != 0) goto L_0x018b
            r7 = r79
            boolean r35 = r10.changed((long) r7)
            if (r35 == 0) goto L_0x0186
            r21 = 4
            goto L_0x0188
        L_0x0186:
            r21 = 2
        L_0x0188:
            r2 = r2 | r21
            goto L_0x018d
        L_0x018b:
            r7 = r79
        L_0x018d:
            r7 = r12 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x0196
            r2 = r2 | 48
            r8 = r81
            goto L_0x01ac
        L_0x0196:
            r8 = r13 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x01aa
            r8 = r81
            boolean r21 = r10.changed((int) r8)
            if (r21 == 0) goto L_0x01a5
            r26 = 32
            goto L_0x01a7
        L_0x01a5:
            r26 = 16
        L_0x01a7:
            r2 = r2 | r26
            goto L_0x01ac
        L_0x01aa:
            r8 = r81
        L_0x01ac:
            r8 = r12 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x01b5
            r2 = r2 | 384(0x180, float:5.38E-43)
            r11 = r82
            goto L_0x01cb
        L_0x01b5:
            r11 = r13 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x01c9
            r11 = r82
            boolean r17 = r10.changed((boolean) r11)
            if (r17 == 0) goto L_0x01c4
            r30 = 256(0x100, float:3.59E-43)
            goto L_0x01c6
        L_0x01c4:
            r30 = r16
        L_0x01c6:
            r2 = r2 | r30
            goto L_0x01cb
        L_0x01c9:
            r11 = r82
        L_0x01cb:
            r11 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x01d4
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r14 = r83
            goto L_0x01e8
        L_0x01d4:
            r14 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r14 != 0) goto L_0x01e6
            r14 = r83
            boolean r16 = r10.changed((int) r14)
            if (r16 == 0) goto L_0x01e1
            goto L_0x01e3
        L_0x01e1:
            r19 = r20
        L_0x01e3:
            r2 = r2 | r19
            goto L_0x01e8
        L_0x01e6:
            r14 = r83
        L_0x01e8:
            r14 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r14 == 0) goto L_0x01f3
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r16 = r14
            r14 = r84
            goto L_0x020b
        L_0x01f3:
            r16 = r13 & r25
            if (r16 != 0) goto L_0x0207
            r16 = r14
            r14 = r84
            boolean r17 = r10.changed((int) r14)
            if (r17 == 0) goto L_0x0202
            goto L_0x0204
        L_0x0202:
            r23 = r24
        L_0x0204:
            r2 = r2 | r23
            goto L_0x020b
        L_0x0207:
            r16 = r14
            r14 = r84
        L_0x020b:
            r17 = 32768(0x8000, float:4.5918E-41)
            r14 = r12 & r17
            if (r14 == 0) goto L_0x0214
            r2 = r2 | r28
        L_0x0214:
            r17 = r12 & r28
            if (r17 == 0) goto L_0x0221
            r19 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r19
            r19 = r11
            r11 = r86
            goto L_0x023b
        L_0x0221:
            r19 = r13 & r32
            if (r19 != 0) goto L_0x0237
            r19 = r11
            r11 = r86
            boolean r20 = r10.changedInstance(r11)
            if (r20 == 0) goto L_0x0232
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0234
        L_0x0232:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x0234:
            r2 = r2 | r20
            goto L_0x023b
        L_0x0237:
            r19 = r11
            r11 = r86
        L_0x023b:
            r20 = r13 & r34
            if (r20 != 0) goto L_0x0255
            r20 = r12 & r29
            if (r20 != 0) goto L_0x024e
            r11 = r87
            boolean r20 = r10.changed((java.lang.Object) r11)
            if (r20 == 0) goto L_0x0250
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0252
        L_0x024e:
            r11 = r87
        L_0x0250:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x0252:
            r2 = r2 | r20
            goto L_0x0257
        L_0x0255:
            r11 = r87
        L_0x0257:
            r11 = 32768(0x8000, float:4.5918E-41)
            if (r14 != r11) goto L_0x029e
            r11 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r11 = r11 & r1
            r13 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r13) goto L_0x029e
            r11 = 23967451(0x16db6db, float:4.3661218E-38)
            r11 = r11 & r2
            r13 = 4793490(0x492492, float:6.71711E-39)
            if (r11 != r13) goto L_0x029e
            boolean r11 = r10.getSkipping()
            if (r11 != 0) goto L_0x0275
            goto L_0x029e
        L_0x0275:
            r10.skipToGroupEnd()
            r26 = r67
            r27 = r68
            r29 = r70
            r31 = r72
            r32 = r73
            r33 = r74
            r34 = r75
            r36 = r77
            r37 = r78
            r38 = r79
            r40 = r81
            r41 = r82
            r42 = r83
            r43 = r84
            r44 = r85
            r45 = r86
            r46 = r87
            r47 = r2
            goto L_0x0516
        L_0x029e:
            r10.startDefaults()
            r11 = r15 & 1
            if (r11 == 0) goto L_0x0302
            boolean r11 = r10.getDefaultsInvalid()
            if (r11 == 0) goto L_0x02ad
            goto L_0x0302
        L_0x02ad:
            r10.skipToGroupEnd()
            r0 = r12 & r29
            if (r0 == 0) goto L_0x02dd
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r0 = r0 & r2
            r20 = r68
            r23 = r70
            r9 = r72
            r11 = r73
            r13 = r74
            r26 = r75
            r2 = r77
            r5 = r78
            r30 = r79
            r3 = r81
            r6 = r82
            r7 = r83
            r8 = r84
            r14 = r85
            r16 = r86
            r4 = r87
            r12 = r0
            r0 = r67
            goto L_0x03c8
        L_0x02dd:
            r0 = r67
            r20 = r68
            r23 = r70
            r9 = r72
            r11 = r73
            r13 = r74
            r26 = r75
            r5 = r78
            r30 = r79
            r3 = r81
            r6 = r82
            r7 = r83
            r8 = r84
            r14 = r85
            r16 = r86
            r4 = r87
            r12 = r2
            r2 = r77
            goto L_0x03c8
        L_0x0302:
            if (r3 == 0) goto L_0x0309
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x030b
        L_0x0309:
            r3 = r67
        L_0x030b:
            if (r9 == 0) goto L_0x0314
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r20 = r9.m4999getUnspecified0d7_KjU()
            goto L_0x0316
        L_0x0314:
            r20 = r68
        L_0x0316:
            if (r18 == 0) goto L_0x031f
            androidx.compose.ui.unit.TextUnit$Companion r9 = androidx.compose.ui.unit.TextUnit.Companion
            long r23 = r9.m7746getUnspecifiedXSAIIZE()
            goto L_0x0321
        L_0x031f:
            r23 = r70
        L_0x0321:
            if (r22 == 0) goto L_0x0325
            r9 = 0
            goto L_0x0327
        L_0x0325:
            r9 = r72
        L_0x0327:
            if (r27 == 0) goto L_0x032b
            r11 = 0
            goto L_0x032d
        L_0x032b:
            r11 = r73
        L_0x032d:
            if (r31 == 0) goto L_0x0331
            r13 = 0
            goto L_0x0333
        L_0x0331:
            r13 = r74
        L_0x0333:
            if (r0 == 0) goto L_0x033c
            androidx.compose.ui.unit.TextUnit$Companion r0 = androidx.compose.ui.unit.TextUnit.Companion
            long r26 = r0.m7746getUnspecifiedXSAIIZE()
            goto L_0x033e
        L_0x033c:
            r26 = r75
        L_0x033e:
            if (r6 == 0) goto L_0x0342
            r0 = 0
            goto L_0x0344
        L_0x0342:
            r0 = r77
        L_0x0344:
            if (r5 == 0) goto L_0x0348
            r5 = 0
            goto L_0x034a
        L_0x0348:
            r5 = r78
        L_0x034a:
            if (r4 == 0) goto L_0x0353
            androidx.compose.ui.unit.TextUnit$Companion r4 = androidx.compose.ui.unit.TextUnit.Companion
            long r30 = r4.m7746getUnspecifiedXSAIIZE()
            goto L_0x0355
        L_0x0353:
            r30 = r79
        L_0x0355:
            if (r7 == 0) goto L_0x035e
            androidx.compose.ui.text.style.TextOverflow$Companion r4 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r4 = r4.m7466getClipgIe3tQ8()
            goto L_0x0360
        L_0x035e:
            r4 = r81
        L_0x0360:
            if (r8 == 0) goto L_0x0364
            r6 = 1
            goto L_0x0366
        L_0x0364:
            r6 = r82
        L_0x0366:
            if (r19 == 0) goto L_0x036c
            r7 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x036e
        L_0x036c:
            r7 = r83
        L_0x036e:
            if (r16 == 0) goto L_0x0372
            r8 = 1
            goto L_0x0374
        L_0x0372:
            r8 = r84
        L_0x0374:
            if (r14 == 0) goto L_0x037b
            java.util.Map r14 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x037d
        L_0x037b:
            r14 = r85
        L_0x037d:
            if (r17 == 0) goto L_0x0384
            androidx.compose.material3.TextKt$Text$5 r16 = androidx.compose.material3.TextKt$Text$5.INSTANCE
            kotlin.jvm.functions.Function1 r16 = (kotlin.jvm.functions.Function1) r16
            goto L_0x0386
        L_0x0384:
            r16 = r86
        L_0x0386:
            r17 = r12 & r29
            if (r17 == 0) goto L_0x03b9
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r17 = LocalTextStyle
            r67 = r0
            r0 = r17
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r17 = 6
            r18 = 0
            r88 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            r68 = r4
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r4)
            java.lang.Object r3 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r0 = r3
            androidx.compose.ui.text.TextStyle r0 = (androidx.compose.ui.text.TextStyle) r0
            r3 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r2 = r2 & r3
            r3 = r68
            r4 = r0
            r12 = r2
            r2 = r67
            r0 = r88
            goto L_0x03c8
        L_0x03b9:
            r67 = r0
            r88 = r3
            r68 = r4
            r3 = r68
            r4 = r87
            r0 = r88
            r12 = r2
            r2 = r67
        L_0x03c8:
            r10.endDefaults()
            boolean r17 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r17 == 0) goto L_0x03dc
            java.lang.String r15 = "androidx.compose.material3.Text (Text.kt:240)"
            r79 = r14
            r14 = 2027001676(0x78d1974c, float:3.4008085E34)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r1, r12, r15)
            goto L_0x03de
        L_0x03dc:
            r79 = r14
        L_0x03de:
            r14 = 79588971(0x4be6e6b, float:4.477019E-36)
            r10.startReplaceableGroup(r14)
            java.lang.String r14 = "*262@11847L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r14 = r20
            r17 = 0
            r18 = r14
            r22 = 0
            androidx.compose.ui.graphics.Color$Companion r28 = androidx.compose.ui.graphics.Color.Companion
            long r28 = r28.m4999getUnspecified0d7_KjU()
            int r28 = (r18 > r28 ? 1 : (r18 == r28 ? 0 : -1))
            r29 = 1
            if (r28 == 0) goto L_0x0400
            r28 = r29
            goto L_0x0402
        L_0x0400:
            r28 = 0
        L_0x0402:
            if (r28 == 0) goto L_0x0409
            r80 = r8
            r36 = r14
            goto L_0x0456
        L_0x0409:
            r18 = 0
            long r35 = r4.m7056getColor0d7_KjU()
            r19 = 0
            r37 = r35
            r22 = 0
            androidx.compose.ui.graphics.Color$Companion r28 = androidx.compose.ui.graphics.Color.Companion
            long r39 = r28.m4999getUnspecified0d7_KjU()
            int r28 = (r37 > r39 ? 1 : (r37 == r39 ? 0 : -1))
            if (r28 == 0) goto L_0x0420
            goto L_0x0422
        L_0x0420:
            r29 = 0
        L_0x0422:
            if (r29 == 0) goto L_0x0429
            r80 = r8
            r67 = r14
            goto L_0x0453
        L_0x0429:
            r22 = 0
            androidx.compose.runtime.ProvidableCompositionLocal r28 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            r67 = r14
            r14 = r28
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r15 = 6
            r28 = 0
            r69 = r15
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            r80 = r8
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r15, r8)
            java.lang.Object r8 = r10.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.graphics.Color r8 = (androidx.compose.ui.graphics.Color) r8
            long r14 = r8.m4973unboximpl()
            r35 = r14
        L_0x0453:
            r36 = r35
        L_0x0456:
            r10.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r8 = new androidx.compose.ui.text.TextStyle
            r35 = r8
            r63 = 4108112(0x3eaf50, float:5.756691E-39)
            r64 = 0
            r42 = 0
            r44 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r53 = 0
            r55 = 0
            r58 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            r38 = r23
            r40 = r11
            r41 = r9
            r43 = r13
            r45 = r26
            r52 = r2
            r54 = r5
            r56 = r30
            r35.<init>((long) r36, (long) r38, (androidx.compose.ui.text.font.FontWeight) r40, (androidx.compose.ui.text.font.FontStyle) r41, (androidx.compose.ui.text.font.FontSynthesis) r42, (androidx.compose.ui.text.font.FontFamily) r43, (java.lang.String) r44, (long) r45, (androidx.compose.ui.text.style.BaselineShift) r47, (androidx.compose.ui.text.style.TextGeometricTransform) r48, (androidx.compose.ui.text.intl.LocaleList) r49, (long) r50, (androidx.compose.ui.text.style.TextDecoration) r52, (androidx.compose.ui.graphics.Shadow) r53, (androidx.compose.ui.text.style.TextAlign) r54, (androidx.compose.ui.text.style.TextDirection) r55, (long) r56, (androidx.compose.ui.text.style.TextIndent) r58, (androidx.compose.ui.text.PlatformTextStyle) r59, (androidx.compose.ui.text.style.LineHeightStyle) r60, (androidx.compose.ui.text.style.LineBreak) r61, (androidx.compose.ui.text.style.Hyphens) r62, (int) r63, (kotlin.jvm.internal.DefaultConstructorMarker) r64)
            androidx.compose.ui.text.TextStyle r8 = r4.merge((androidx.compose.ui.text.TextStyle) r8)
            r14 = 134217728(0x8000000, float:3.85186E-34)
            r15 = r1 & 14
            r14 = r14 | r15
            r15 = r1 & 112(0x70, float:1.57E-43)
            r14 = r14 | r15
            int r15 = r12 >> 9
            r15 = r15 & 7168(0x1c00, float:1.0045E-41)
            r14 = r14 | r15
            int r15 = r12 << 9
            r15 = r15 & r25
            r14 = r14 | r15
            int r15 = r12 << 9
            r17 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r17
            r14 = r14 | r15
            int r15 = r12 << 9
            r15 = r15 & r32
            r14 = r14 | r15
            int r15 = r12 << 9
            r15 = r15 & r34
            r14 = r14 | r15
            r15 = 0
            r67 = r66
            r68 = r0
            r69 = r8
            r70 = r16
            r71 = r3
            r72 = r6
            r73 = r7
            r74 = r80
            r75 = r79
            r76 = r10
            r77 = r14
            r78 = r15
            androidx.compose.foundation.text.BasicTextKt.m2591BasicTextVhcvRP8((androidx.compose.ui.text.AnnotatedString) r67, (androidx.compose.ui.Modifier) r68, (androidx.compose.ui.text.TextStyle) r69, (kotlin.jvm.functions.Function1) r70, (int) r71, (boolean) r72, (int) r73, (int) r74, (java.util.Map) r75, (androidx.compose.runtime.Composer) r76, (int) r77, (int) r78)
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x04f2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04f2:
            r44 = r79
            r43 = r80
            r36 = r2
            r40 = r3
            r46 = r4
            r37 = r5
            r41 = r6
            r42 = r7
            r32 = r11
            r47 = r12
            r33 = r13
            r45 = r16
            r34 = r26
            r38 = r30
            r26 = r0
            r31 = r9
            r27 = r20
            r29 = r23
        L_0x0516:
            androidx.compose.runtime.ScopeUpdateScope r14 = r10.endRestartGroup()
            if (r14 != 0) goto L_0x0521
            r49 = r1
            r50 = r10
            goto L_0x0561
        L_0x0521:
            androidx.compose.material3.TextKt$Text$6 r48 = new androidx.compose.material3.TextKt$Text$6
            r0 = r48
            r49 = r1
            r1 = r66
            r2 = r26
            r3 = r27
            r5 = r29
            r7 = r31
            r8 = r32
            r9 = r33
            r50 = r10
            r10 = r34
            r12 = r36
            r13 = r37
            r65 = r14
            r14 = r38
            r16 = r40
            r17 = r41
            r18 = r42
            r19 = r43
            r20 = r44
            r21 = r45
            r22 = r46
            r23 = r89
            r24 = r90
            r25 = r91
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r0 = r48
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r65
            r1.updateScope(r0)
        L_0x0561:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m3859TextIbK3jfQ(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text--4IGK_g  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m3857Text4IGK_g(androidx.compose.ui.text.AnnotatedString r51, androidx.compose.ui.Modifier r52, long r53, long r55, androidx.compose.ui.text.font.FontStyle r57, androidx.compose.ui.text.font.FontWeight r58, androidx.compose.ui.text.font.FontFamily r59, long r60, androidx.compose.ui.text.style.TextDecoration r62, androidx.compose.ui.text.style.TextAlign r63, long r64, int r66, boolean r67, int r68, java.util.Map r69, kotlin.jvm.functions.Function1 r70, androidx.compose.ui.text.TextStyle r71, androidx.compose.runtime.Composer r72, int r73, int r74, int r75) {
        /*
            r15 = r51
            r13 = r73
            r14 = r74
            r12 = r75
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = 224529679(0xd620d0f, float:6.9657345E-31)
            r1 = r72
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)315@13586L7,317@13602L345:Text.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r73
            r2 = r74
            r3 = r12 & 1
            if (r3 == 0) goto L_0x0027
            r1 = r1 | 6
            goto L_0x0035
        L_0x0027:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x0035
            boolean r3 = r11.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x0033
            r3 = 4
            goto L_0x0034
        L_0x0033:
            r3 = 2
        L_0x0034:
            r1 = r1 | r3
        L_0x0035:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x003e
            r1 = r1 | 48
            r8 = r52
            goto L_0x0053
        L_0x003e:
            r8 = r13 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0051
            r8 = r52
            boolean r9 = r11.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x004d
            r9 = 32
            goto L_0x004f
        L_0x004d:
            r9 = 16
        L_0x004f:
            r1 = r1 | r9
            goto L_0x0053
        L_0x0051:
            r8 = r52
        L_0x0053:
            r9 = r12 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x005e
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r53
            goto L_0x0074
        L_0x005e:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0072
            r5 = r53
            boolean r18 = r11.changed((long) r5)
            if (r18 == 0) goto L_0x006d
            r18 = 256(0x100, float:3.59E-43)
            goto L_0x006f
        L_0x006d:
            r18 = r16
        L_0x006f:
            r1 = r1 | r18
            goto L_0x0074
        L_0x0072:
            r5 = r53
        L_0x0074:
            r18 = r12 & 8
            r19 = 2048(0x800, float:2.87E-42)
            r20 = 1024(0x400, float:1.435E-42)
            if (r18 == 0) goto L_0x0081
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r55
            goto L_0x0097
        L_0x0081:
            r4 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0095
            r7 = r55
            boolean r22 = r11.changed((long) r7)
            if (r22 == 0) goto L_0x0090
            r22 = r19
            goto L_0x0092
        L_0x0090:
            r22 = r20
        L_0x0092:
            r1 = r1 | r22
            goto L_0x0097
        L_0x0095:
            r7 = r55
        L_0x0097:
            r22 = r12 & 16
            if (r22 == 0) goto L_0x00a0
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r10 = r57
            goto L_0x00b9
        L_0x00a0:
            r24 = 57344(0xe000, float:8.0356E-41)
            r24 = r13 & r24
            if (r24 != 0) goto L_0x00b7
            r10 = r57
            boolean r25 = r11.changed((java.lang.Object) r10)
            if (r25 == 0) goto L_0x00b2
            r25 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b4
        L_0x00b2:
            r25 = 8192(0x2000, float:1.14794E-41)
        L_0x00b4:
            r1 = r1 | r25
            goto L_0x00b9
        L_0x00b7:
            r10 = r57
        L_0x00b9:
            r25 = r12 & 32
            r26 = 458752(0x70000, float:6.42848E-40)
            r27 = 65536(0x10000, float:9.18355E-41)
            if (r25 == 0) goto L_0x00c8
            r28 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r28
            r0 = r58
            goto L_0x00de
        L_0x00c8:
            r28 = r13 & r26
            if (r28 != 0) goto L_0x00dc
            r0 = r58
            boolean r29 = r11.changed((java.lang.Object) r0)
            if (r29 == 0) goto L_0x00d7
            r29 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d9
        L_0x00d7:
            r29 = r27
        L_0x00d9:
            r1 = r1 | r29
            goto L_0x00de
        L_0x00dc:
            r0 = r58
        L_0x00de:
            r29 = r12 & 64
            r30 = 3670016(0x380000, float:5.142788E-39)
            if (r29 == 0) goto L_0x00eb
            r31 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r31
            r4 = r59
            goto L_0x0101
        L_0x00eb:
            r31 = r13 & r30
            if (r31 != 0) goto L_0x00ff
            r4 = r59
            boolean r32 = r11.changed((java.lang.Object) r4)
            if (r32 == 0) goto L_0x00fa
            r32 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fc
        L_0x00fa:
            r32 = 524288(0x80000, float:7.34684E-40)
        L_0x00fc:
            r1 = r1 | r32
            goto L_0x0101
        L_0x00ff:
            r4 = r59
        L_0x0101:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r32 = 29360128(0x1c00000, float:7.052966E-38)
            if (r0 == 0) goto L_0x010e
            r33 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r33
            r4 = r60
            goto L_0x0123
        L_0x010e:
            r33 = r13 & r32
            if (r33 != 0) goto L_0x0121
            r4 = r60
            boolean r6 = r11.changed((long) r4)
            if (r6 == 0) goto L_0x011d
            r6 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x011f
        L_0x011d:
            r6 = 4194304(0x400000, float:5.877472E-39)
        L_0x011f:
            r1 = r1 | r6
            goto L_0x0123
        L_0x0121:
            r4 = r60
        L_0x0123:
            r6 = r12 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x012e
            r33 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r33
            r4 = r62
            goto L_0x0145
        L_0x012e:
            r33 = 234881024(0xe000000, float:1.5777218E-30)
            r33 = r13 & r33
            if (r33 != 0) goto L_0x0143
            r4 = r62
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x013f
            r5 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0141
        L_0x013f:
            r5 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0141:
            r1 = r1 | r5
            goto L_0x0145
        L_0x0143:
            r4 = r62
        L_0x0145:
            r5 = r12 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0150
            r33 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r33
            r4 = r63
            goto L_0x0168
        L_0x0150:
            r33 = 1879048192(0x70000000, float:1.58456325E29)
            r33 = r13 & r33
            if (r33 != 0) goto L_0x0166
            r4 = r63
            boolean r33 = r11.changed((java.lang.Object) r4)
            if (r33 == 0) goto L_0x0161
            r33 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0163
        L_0x0161:
            r33 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0163:
            r1 = r1 | r33
            goto L_0x0168
        L_0x0166:
            r4 = r63
        L_0x0168:
            r4 = r12 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0171
            r2 = r2 | 6
            r7 = r64
            goto L_0x0187
        L_0x0171:
            r33 = r14 & 14
            if (r33 != 0) goto L_0x0185
            r7 = r64
            boolean r33 = r11.changed((long) r7)
            if (r33 == 0) goto L_0x0180
            r21 = 4
            goto L_0x0182
        L_0x0180:
            r21 = 2
        L_0x0182:
            r2 = r2 | r21
            goto L_0x0187
        L_0x0185:
            r7 = r64
        L_0x0187:
            r7 = r12 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x0190
            r2 = r2 | 48
            r8 = r66
            goto L_0x01a6
        L_0x0190:
            r8 = r14 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x01a4
            r8 = r66
            boolean r21 = r11.changed((int) r8)
            if (r21 == 0) goto L_0x019f
            r23 = 32
            goto L_0x01a1
        L_0x019f:
            r23 = 16
        L_0x01a1:
            r2 = r2 | r23
            goto L_0x01a6
        L_0x01a4:
            r8 = r66
        L_0x01a6:
            r8 = r12 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x01af
            r2 = r2 | 384(0x180, float:5.38E-43)
            r10 = r67
            goto L_0x01c5
        L_0x01af:
            r10 = r14 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x01c3
            r10 = r67
            boolean r17 = r11.changed((boolean) r10)
            if (r17 == 0) goto L_0x01be
            r24 = 256(0x100, float:3.59E-43)
            goto L_0x01c0
        L_0x01be:
            r24 = r16
        L_0x01c0:
            r2 = r2 | r24
            goto L_0x01c5
        L_0x01c3:
            r10 = r67
        L_0x01c5:
            r10 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x01ce
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r15 = r68
            goto L_0x01e2
        L_0x01ce:
            r15 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r15 != 0) goto L_0x01e0
            r15 = r68
            boolean r16 = r11.changed((int) r15)
            if (r16 == 0) goto L_0x01db
            goto L_0x01dd
        L_0x01db:
            r19 = r20
        L_0x01dd:
            r2 = r2 | r19
            goto L_0x01e2
        L_0x01e0:
            r15 = r68
        L_0x01e2:
            r15 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x01e8
            r2 = r2 | 8192(0x2000, float:1.14794E-41)
        L_0x01e8:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r12 & r16
            if (r16 == 0) goto L_0x01f8
            r17 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r17
            r17 = r10
            r10 = r70
            goto L_0x0212
        L_0x01f8:
            r17 = r14 & r26
            if (r17 != 0) goto L_0x020e
            r17 = r10
            r10 = r70
            boolean r19 = r11.changedInstance(r10)
            if (r19 == 0) goto L_0x0209
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x020b
        L_0x0209:
            r19 = r27
        L_0x020b:
            r2 = r2 | r19
            goto L_0x0212
        L_0x020e:
            r17 = r10
            r10 = r70
        L_0x0212:
            r19 = r14 & r30
            if (r19 != 0) goto L_0x022c
            r19 = r12 & r27
            if (r19 != 0) goto L_0x0225
            r10 = r71
            boolean r19 = r11.changed((java.lang.Object) r10)
            if (r19 == 0) goto L_0x0227
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0229
        L_0x0225:
            r10 = r71
        L_0x0227:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x0229:
            r2 = r2 | r19
            goto L_0x022e
        L_0x022c:
            r10 = r71
        L_0x022e:
            r10 = 16384(0x4000, float:2.2959E-41)
            if (r15 != r10) goto L_0x0276
            r10 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r10 = r10 & r1
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r10 != r14) goto L_0x0276
            r10 = 2995931(0x2db6db, float:4.198194E-39)
            r10 = r10 & r2
            r14 = 599186(0x92492, float:8.39638E-40)
            if (r10 != r14) goto L_0x0276
            boolean r10 = r11.getSkipping()
            if (r10 != 0) goto L_0x024b
            goto L_0x0276
        L_0x024b:
            r11.skipToGroupEnd()
            r27 = r52
            r33 = r53
            r35 = r55
            r29 = r57
            r31 = r58
            r37 = r59
            r38 = r60
            r40 = r62
            r41 = r63
            r42 = r64
            r44 = r66
            r45 = r67
            r46 = r68
            r47 = r69
            r48 = r70
            r49 = r71
            r26 = r1
            r30 = r2
            r28 = r11
            goto L_0x0460
        L_0x0276:
            r11.startDefaults()
            r10 = r13 & 1
            if (r10 == 0) goto L_0x02d5
            boolean r10 = r11.getDefaultsInvalid()
            if (r10 == 0) goto L_0x0284
            goto L_0x02d5
        L_0x0284:
            r11.skipToGroupEnd()
            r0 = r12 & r27
            if (r0 == 0) goto L_0x02b2
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r0 & r2
            r27 = r52
            r33 = r53
            r35 = r55
            r29 = r57
            r31 = r58
            r37 = r59
            r38 = r60
            r40 = r62
            r41 = r63
            r42 = r64
            r44 = r66
            r45 = r67
            r46 = r68
            r47 = r69
            r48 = r70
            r49 = r71
            r15 = r0
            goto L_0x03c8
        L_0x02b2:
            r27 = r52
            r33 = r53
            r35 = r55
            r29 = r57
            r31 = r58
            r37 = r59
            r38 = r60
            r40 = r62
            r41 = r63
            r42 = r64
            r44 = r66
            r45 = r67
            r46 = r68
            r47 = r69
            r48 = r70
            r49 = r71
            r15 = r2
            goto L_0x03c8
        L_0x02d5:
            if (r3 == 0) goto L_0x02dc
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x02de
        L_0x02dc:
            r3 = r52
        L_0x02de:
            if (r9 == 0) goto L_0x02e7
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r9 = r9.m4999getUnspecified0d7_KjU()
            goto L_0x02e9
        L_0x02e7:
            r9 = r53
        L_0x02e9:
            if (r18 == 0) goto L_0x02f2
            androidx.compose.ui.unit.TextUnit$Companion r14 = androidx.compose.ui.unit.TextUnit.Companion
            long r18 = r14.m7746getUnspecifiedXSAIIZE()
            goto L_0x02f4
        L_0x02f2:
            r18 = r55
        L_0x02f4:
            if (r22 == 0) goto L_0x02f8
            r14 = 0
            goto L_0x02fa
        L_0x02f8:
            r14 = r57
        L_0x02fa:
            if (r25 == 0) goto L_0x02ff
            r20 = 0
            goto L_0x0301
        L_0x02ff:
            r20 = r58
        L_0x0301:
            if (r29 == 0) goto L_0x0306
            r21 = 0
            goto L_0x0308
        L_0x0306:
            r21 = r59
        L_0x0308:
            if (r0 == 0) goto L_0x0311
            androidx.compose.ui.unit.TextUnit$Companion r0 = androidx.compose.ui.unit.TextUnit.Companion
            long r22 = r0.m7746getUnspecifiedXSAIIZE()
            goto L_0x0313
        L_0x0311:
            r22 = r60
        L_0x0313:
            if (r6 == 0) goto L_0x0317
            r0 = 0
            goto L_0x0319
        L_0x0317:
            r0 = r62
        L_0x0319:
            if (r5 == 0) goto L_0x031d
            r5 = 0
            goto L_0x031f
        L_0x031d:
            r5 = r63
        L_0x031f:
            if (r4 == 0) goto L_0x0328
            androidx.compose.ui.unit.TextUnit$Companion r4 = androidx.compose.ui.unit.TextUnit.Companion
            long r24 = r4.m7746getUnspecifiedXSAIIZE()
            goto L_0x032a
        L_0x0328:
            r24 = r64
        L_0x032a:
            if (r7 == 0) goto L_0x0333
            androidx.compose.ui.text.style.TextOverflow$Companion r4 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r4 = r4.m7466getClipgIe3tQ8()
            goto L_0x0335
        L_0x0333:
            r4 = r66
        L_0x0335:
            if (r8 == 0) goto L_0x0339
            r6 = 1
            goto L_0x033b
        L_0x0339:
            r6 = r67
        L_0x033b:
            if (r17 == 0) goto L_0x0341
            r7 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0343
        L_0x0341:
            r7 = r68
        L_0x0343:
            if (r15 == 0) goto L_0x034a
            java.util.Map r8 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x034c
        L_0x034a:
            r8 = r69
        L_0x034c:
            if (r16 == 0) goto L_0x0353
            androidx.compose.material3.TextKt$Text$7 r15 = androidx.compose.material3.TextKt$Text$7.INSTANCE
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            goto L_0x0355
        L_0x0353:
            r15 = r70
        L_0x0355:
            r16 = r12 & r27
            if (r16 == 0) goto L_0x03a1
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r16 = LocalTextStyle
            r52 = r0
            r0 = r16
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r16 = 6
            r17 = 0
            r72 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            r53 = r4
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r4)
            java.lang.Object r3 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r0 = r3
            androidx.compose.ui.text.TextStyle r0 = (androidx.compose.ui.text.TextStyle) r0
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r2 = r2 & r3
            r40 = r52
            r44 = r53
            r27 = r72
            r49 = r0
            r41 = r5
            r45 = r6
            r46 = r7
            r47 = r8
            r33 = r9
            r29 = r14
            r48 = r15
            r35 = r18
            r31 = r20
            r37 = r21
            r38 = r22
            r42 = r24
            r15 = r2
            goto L_0x03c8
        L_0x03a1:
            r52 = r0
            r72 = r3
            r53 = r4
            r40 = r52
            r44 = r53
            r49 = r71
            r27 = r72
            r41 = r5
            r45 = r6
            r46 = r7
            r47 = r8
            r33 = r9
            r29 = r14
            r48 = r15
            r35 = r18
            r31 = r20
            r37 = r21
            r38 = r22
            r42 = r24
            r15 = r2
        L_0x03c8:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03d9
            java.lang.String r0 = "androidx.compose.material3.Text (Text.kt:298)"
            r2 = 224529679(0xd620d0f, float:6.9657345E-31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r15, r0)
        L_0x03d9:
            r0 = r1 & 14
            r2 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = r1 & r26
            r0 = r0 | r2
            r2 = r1 & r30
            r0 = r0 | r2
            r2 = r1 & r32
            r0 = r0 | r2
            r2 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r1
            r23 = r0 | r2
            r0 = 286720(0x46000, float:4.0178E-40)
            r2 = r15 & 14
            r0 = r0 | r2
            r2 = r15 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = r15 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r15 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r15 << 3
            r2 = r2 & r30
            r0 = r0 | r2
            int r2 = r15 << 3
            r2 = r2 & r32
            r24 = r0 | r2
            r18 = 1
            r25 = 0
            r0 = r51
            r26 = r1
            r1 = r27
            r2 = r33
            r4 = r35
            r6 = r29
            r7 = r31
            r8 = r37
            r9 = r38
            r28 = r11
            r11 = r40
            r12 = r41
            r13 = r42
            r30 = r15
            r15 = r44
            r16 = r45
            r17 = r46
            r19 = r47
            r20 = r48
            r21 = r49
            r22 = r28
            m3859TextIbK3jfQ(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0460
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0460:
            androidx.compose.runtime.ScopeUpdateScope r14 = r28.endRestartGroup()
            if (r14 != 0) goto L_0x0467
            goto L_0x04a1
        L_0x0467:
            androidx.compose.material3.TextKt$Text$8 r25 = new androidx.compose.material3.TextKt$Text$8
            r0 = r25
            r1 = r51
            r2 = r27
            r3 = r33
            r5 = r35
            r7 = r29
            r8 = r31
            r9 = r37
            r10 = r38
            r12 = r40
            r13 = r41
            r50 = r14
            r14 = r42
            r16 = r44
            r17 = r45
            r18 = r46
            r19 = r47
            r20 = r48
            r21 = r49
            r22 = r73
            r23 = r74
            r24 = r75
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r0 = r25
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r50
            r1.updateScope(r0)
        L_0x04a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m3857Text4IGK_g(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(TextStyle value, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-460300127);
        ComposerKt.sourceInformation($composer2, "C(ProvideTextStyle)P(1)358@14903L7,359@14928L80:Text.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) value) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-460300127, $dirty, -1, "androidx.compose.material3.ProvideTextStyle (Text.kt:357)");
            }
            ProvidableCompositionLocal<TextStyle> this_$iv = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{this_$iv.provides(((TextStyle) consume).merge(value))}, content, $composer2, ($dirty & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextKt$ProvideTextStyle$1(value, content, $changed));
        }
    }
}

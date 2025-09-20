package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.StaticTextSelectionParams;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.material.internal.ViewUtils;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001aq\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010 \u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010!\u001a\u001e\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002\u001a¯\u0001\u0010'\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010(\u001a\u00020)2\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,\u0018\u00010+2\u001c\u0010.\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010/0+\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00064"}, d2 = {"BasicText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-VhcvRP8", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "BasicText-RWo7tUw", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "textModifier", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "textModifier-RWo7tUw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
public final class BasicTextKt {
    /* JADX WARNING: Removed duplicated region for block: B:143:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03b8  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x03c3  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x03fa  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0410  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x043a  */
    /* renamed from: BasicText-VhcvRP8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m882BasicTextVhcvRP8(java.lang.String r48, androidx.compose.ui.Modifier r49, androidx.compose.ui.text.TextStyle r50, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r51, int r52, boolean r53, int r54, int r55, androidx.compose.ui.graphics.ColorProducer r56, androidx.compose.runtime.Composer r57, int r58, int r59) {
        /*
            r12 = r48
            r13 = r58
            r11 = r59
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1186827822(0xffffffffb94271d2, float:-1.8543683E-4)
            r1 = r57
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)94@4599L7,138@6175L41:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r58
            r2 = r11 & 1
            if (r2 == 0) goto L_0x0023
            r1 = r1 | 6
            goto L_0x0031
        L_0x0023:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x0031
            boolean r2 = r14.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x002f
            r2 = 4
            goto L_0x0030
        L_0x002f:
            r2 = 2
        L_0x0030:
            r1 = r1 | r2
        L_0x0031:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x003a
            r1 = r1 | 48
            r3 = r49
            goto L_0x004f
        L_0x003a:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004d
            r3 = r49
            boolean r4 = r14.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0049
            r4 = 32
            goto L_0x004b
        L_0x0049:
            r4 = 16
        L_0x004b:
            r1 = r1 | r4
            goto L_0x004f
        L_0x004d:
            r3 = r49
        L_0x004f:
            r4 = r11 & 4
            if (r4 == 0) goto L_0x0058
            r1 = r1 | 384(0x180, float:5.38E-43)
            r6 = r50
            goto L_0x006d
        L_0x0058:
            r6 = r13 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006b
            r6 = r50
            boolean r7 = r14.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0067
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r1 = r1 | r7
            goto L_0x006d
        L_0x006b:
            r6 = r50
        L_0x006d:
            r7 = r11 & 8
            if (r7 == 0) goto L_0x0076
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r8 = r51
            goto L_0x008b
        L_0x0076:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0089
            r8 = r51
            boolean r9 = r14.changedInstance(r8)
            if (r9 == 0) goto L_0x0085
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r1 = r1 | r9
            goto L_0x008b
        L_0x0089:
            r8 = r51
        L_0x008b:
            r9 = r11 & 16
            if (r9 == 0) goto L_0x0094
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r10 = r52
            goto L_0x00ab
        L_0x0094:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r13
            if (r10 != 0) goto L_0x00a9
            r10 = r52
            boolean r15 = r14.changed((int) r10)
            if (r15 == 0) goto L_0x00a5
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a5:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a7:
            r1 = r1 | r15
            goto L_0x00ab
        L_0x00a9:
            r10 = r52
        L_0x00ab:
            r15 = r11 & 32
            if (r15 == 0) goto L_0x00b6
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r0 = r53
            goto L_0x00ce
        L_0x00b6:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00cc
            r0 = r53
            boolean r17 = r14.changed((boolean) r0)
            if (r17 == 0) goto L_0x00c7
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c9:
            r1 = r1 | r17
            goto L_0x00ce
        L_0x00cc:
            r0 = r53
        L_0x00ce:
            r17 = r11 & 64
            if (r17 == 0) goto L_0x00d9
            r18 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r18
            r5 = r54
            goto L_0x00f1
        L_0x00d9:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r13 & r18
            if (r18 != 0) goto L_0x00ef
            r5 = r54
            boolean r18 = r14.changed((int) r5)
            if (r18 == 0) goto L_0x00ea
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ec
        L_0x00ea:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00ec:
            r1 = r1 | r18
            goto L_0x00f1
        L_0x00ef:
            r5 = r54
        L_0x00f1:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00fc
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r18
            r3 = r55
            goto L_0x0114
        L_0x00fc:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r13 & r18
            if (r18 != 0) goto L_0x0112
            r3 = r55
            boolean r18 = r14.changed((int) r3)
            if (r18 == 0) goto L_0x010d
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010f
        L_0x010d:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x010f:
            r1 = r1 | r18
            goto L_0x0114
        L_0x0112:
            r3 = r55
        L_0x0114:
            r3 = r11 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x011c
            r18 = 33554432(0x2000000, float:9.403955E-38)
            r1 = r1 | r18
        L_0x011c:
            r18 = r1
            r1 = 256(0x100, float:3.59E-43)
            if (r3 != r1) goto L_0x0147
            r1 = 191739611(0xb6db6db, float:4.5782105E-32)
            r1 = r18 & r1
            r5 = 38347922(0x2492492, float:1.4777643E-37)
            if (r1 != r5) goto L_0x0147
            boolean r1 = r14.getSkipping()
            if (r1 != 0) goto L_0x0133
            goto L_0x0147
        L_0x0133:
            r14.skipToGroupEnd()
            r42 = r49
            r15 = r53
            r47 = r54
            r46 = r55
            r17 = r56
            r43 = r6
            r44 = r8
            r12 = r10
            goto L_0x043e
        L_0x0147:
            if (r2 == 0) goto L_0x0150
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r42 = r1
            goto L_0x0152
        L_0x0150:
            r42 = r49
        L_0x0152:
            if (r4 == 0) goto L_0x015d
            androidx.compose.ui.text.TextStyle$Companion r1 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r1 = r1.getDefault()
            r43 = r1
            goto L_0x015f
        L_0x015d:
            r43 = r6
        L_0x015f:
            if (r7 == 0) goto L_0x0165
            r1 = 0
            r44 = r1
            goto L_0x0167
        L_0x0165:
            r44 = r8
        L_0x0167:
            if (r9 == 0) goto L_0x0170
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r1 = r1.m5756getClipgIe3tQ8()
            r10 = r1
        L_0x0170:
            if (r15 == 0) goto L_0x0175
            r1 = 1
            r15 = r1
            goto L_0x0177
        L_0x0175:
            r15 = r53
        L_0x0177:
            if (r17 == 0) goto L_0x017e
            r1 = 2147483647(0x7fffffff, float:NaN)
            r9 = r1
            goto L_0x0180
        L_0x017e:
            r9 = r54
        L_0x0180:
            if (r0 == 0) goto L_0x0185
            r0 = 1
            r8 = r0
            goto L_0x0187
        L_0x0185:
            r8 = r55
        L_0x0187:
            if (r3 == 0) goto L_0x018d
            r0 = 0
            r17 = r0
            goto L_0x018f
        L_0x018d:
            r17 = r56
        L_0x018f:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x019e
            r0 = -1
            java.lang.String r1 = "androidx.compose.foundation.text.BasicText (BasicText.kt:79)"
            r2 = -1186827822(0xffffffffb94271d2, float:-1.8543683E-4)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r13, r0, r1)
        L_0x019e:
            androidx.compose.foundation.text.HeightInLinesModifierKt.validateMinMaxLines(r8, r9)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.SelectionRegistrarKt.getLocalSelectionRegistrar()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r4)
            java.lang.Object r5 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r7 = r5
            androidx.compose.foundation.text.selection.SelectionRegistrar r7 = (androidx.compose.foundation.text.selection.SelectionRegistrar) r7
            r0 = 959238473(0x392cd149, float:1.6481163E-4)
            r14.startReplaceableGroup(r0)
            java.lang.String r0 = "96@4735L7,97@4767L190"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r6 = 0
            if (r7 == 0) goto L_0x024b
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r4)
            java.lang.Object r5 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.foundation.text.selection.TextSelectionColors r5 = (androidx.compose.foundation.text.selection.TextSelectionColors) r5
            long r0 = r5.m1151getBackgroundColor0d7_KjU()
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m3243boximpl(r0)
            r5 = r6
            r16 = 0
            r6 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r14.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r6)
            boolean r6 = r14.changed((java.lang.Object) r7)
            boolean r19 = r14.changed((java.lang.Object) r2)
            r6 = r6 | r19
            r57 = r14
            r19 = 0
            java.lang.Object r3 = r57.rememberedValue()
            r20 = 0
            if (r6 != 0) goto L_0x021d
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r22 = r2
            java.lang.Object r2 = r21.getEmpty()
            if (r3 != r2) goto L_0x0217
            goto L_0x021f
        L_0x0217:
            r49 = r0
            r2 = r3
            r0 = r57
            goto L_0x0243
        L_0x021d:
            r22 = r2
        L_0x021f:
            r2 = 0
            androidx.compose.foundation.text.modifiers.SelectionController r21 = new androidx.compose.foundation.text.modifiers.SelectionController
            r23 = 4
            r24 = 0
            r25 = 0
            r49 = r21
            r50 = r7
            r51 = r0
            r53 = r25
            r54 = r23
            r55 = r24
            r49.<init>(r50, r51, r53, r54, r55)
            r2 = r21
            r49 = r0
            r0 = r57
            r0.updateRememberedValue(r2)
        L_0x0243:
            r14.endReplaceableGroup()
            androidx.compose.foundation.text.modifiers.SelectionController r2 = (androidx.compose.foundation.text.modifiers.SelectionController) r2
            goto L_0x024c
        L_0x024b:
            r2 = 0
        L_0x024c:
            r14.endReplaceableGroup()
            r16 = r2
            if (r16 != 0) goto L_0x02df
            if (r44 == 0) goto L_0x025e
            r45 = r7
            r46 = r8
            r47 = r9
            r12 = 0
            goto L_0x02e6
        L_0x025e:
            r0 = 959239577(0x392cd599, float:1.648277E-4)
            r14.startReplaceableGroup(r0)
            java.lang.String r0 = "130@5988L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r40 = 131071(0x1ffff, float:1.8367E-40)
            r41 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r19 = r42
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.m3411graphicsLayerAp8cVGQ$default(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r33, r34, r35, r37, r39, r40, r41)
            androidx.compose.foundation.text.modifiers.TextStringSimpleElement r19 = new androidx.compose.foundation.text.modifiers.TextStringSimpleElement
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r4)
            java.lang.Object r3 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.text.font.FontFamily$Resolver r3 = (androidx.compose.ui.text.font.FontFamily.Resolver) r3
            r20 = 0
            r0 = r19
            r1 = r48
            r2 = r43
            r4 = r10
            r5 = r15
            r11 = r6
            r12 = 0
            r6 = r9
            r45 = r7
            r7 = r8
            r46 = r8
            r8 = r17
            r47 = r9
            r9 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r19
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r0 = r11.then(r0)
            r14.endReplaceableGroup()
            goto L_0x0372
        L_0x02df:
            r45 = r7
            r46 = r8
            r47 = r9
            r12 = 0
        L_0x02e6:
            r0 = 959238907(0x392cd2fb, float:1.6481795E-4)
            r14.startReplaceableGroup(r0)
            java.lang.String r0 = "118@5537L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r40 = 131071(0x1ffff, float:1.8367E-40)
            r41 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r19 = r42
            androidx.compose.ui.Modifier r19 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.m3411graphicsLayerAp8cVGQ$default(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r33, r34, r35, r37, r39, r40, r41)
            androidx.compose.ui.text.AnnotatedString r20 = new androidx.compose.ui.text.AnnotatedString
            r0 = 6
            r1 = 0
            r2 = 0
            r3 = 0
            r49 = r20
            r50 = r48
            r51 = r2
            r52 = r3
            r53 = r0
            r54 = r1
            r49.<init>(r50, r51, r52, r53, r54)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r4)
            java.lang.Object r3 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r27 = r3
            androidx.compose.ui.text.font.FontFamily$Resolver r27 = (androidx.compose.ui.text.font.FontFamily.Resolver) r27
            r28 = 0
            r29 = 0
            r21 = r43
            r22 = r44
            r23 = r10
            r24 = r15
            r25 = r47
            r26 = r46
            r30 = r16
            r31 = r17
            androidx.compose.ui.Modifier r0 = m883textModifierRWo7tUw(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            r14.endReplaceableGroup()
        L_0x0372:
            androidx.compose.foundation.text.EmptyMeasurePolicy r1 = androidx.compose.foundation.text.EmptyMeasurePolicy.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r1 = (androidx.compose.ui.layout.MeasurePolicy) r1
            r2 = 48
            r3 = 0
            r4 = 544976794(0x207baf9a, float:2.1318629E-19)
            r14.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Layout)P(1)122@4734L23,125@4885L385:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r4)
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r14, r12)
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r14, r0)
            androidx.compose.runtime.CompositionLocalMap r6 = r14.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            r8 = 6
            r9 = 0
            r11 = 1405779621(0x53ca7ea5, float:1.73941627E12)
            r14.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(ReusableComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r11)
            androidx.compose.runtime.Applier r11 = r14.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x03af
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03af:
            r14.startReusableNode()
            boolean r11 = r14.getInserting()
            if (r11 == 0) goto L_0x03c3
            androidx.compose.foundation.text.BasicTextKt$BasicText-VhcvRP8$$inlined$Layout$1 r11 = new androidx.compose.foundation.text.BasicTextKt$BasicText-VhcvRP8$$inlined$Layout$1
            r11.<init>(r7)
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r14.createNode(r11)
            goto L_0x03c6
        L_0x03c3:
            r14.useNode()
        L_0x03c6:
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2865constructorimpl(r14)
            r12 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r19 = androidx.compose.ui.node.ComposeUiNode.Companion
            r49 = r0
            kotlin.jvm.functions.Function2 r0 = r19.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r11, r1, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r11, r6, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetModifier()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r11, r5, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            r19 = 0
            r50 = r11
            r20 = 0
            boolean r21 = r50.getInserting()
            if (r21 != 0) goto L_0x0410
            r51 = r1
            java.lang.Object r1 = r50.rememberedValue()
            r52 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x040d
            goto L_0x0414
        L_0x040d:
            r2 = r50
            goto L_0x0424
        L_0x0410:
            r51 = r1
            r52 = r2
        L_0x0414:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r2 = r50
            r2.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r11.apply(r1, r0)
        L_0x0424:
            r14.endNode()
            r14.endReplaceableGroup()
            r14.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x043d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x043d:
            r12 = r10
        L_0x043e:
            androidx.compose.runtime.ScopeUpdateScope r11 = r14.endRestartGroup()
            if (r11 != 0) goto L_0x0447
            r49 = r12
            goto L_0x046c
        L_0x0447:
            androidx.compose.foundation.text.BasicTextKt$BasicText$1 r16 = new androidx.compose.foundation.text.BasicTextKt$BasicText$1
            r0 = r16
            r1 = r48
            r2 = r42
            r3 = r43
            r4 = r44
            r5 = r12
            r6 = r15
            r7 = r47
            r8 = r46
            r9 = r17
            r10 = r58
            r49 = r12
            r12 = r11
            r11 = r59
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x046c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m882BasicTextVhcvRP8(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, int, androidx.compose.ui.graphics.ColorProducer, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: BasicText-RWo7tUw  reason: not valid java name */
    public static final void m880BasicTextRWo7tUw(AnnotatedString text, Modifier modifier, TextStyle style, Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, InlineTextContent> inlineContent, ColorProducer color, Composer $composer, int $changed, int i) {
        int i2;
        int maxLines2;
        int minLines2;
        Map inlineContent2;
        ColorProducer color2;
        boolean softWrap2;
        int overflow2;
        Function1 onTextLayout2;
        TextStyle style2;
        Modifier modifier2;
        Composer $composer2;
        int maxLines3;
        int minLines3;
        Map inlineContent3;
        SelectionController selectionController;
        Object value$iv$iv;
        Function1 function1;
        Object value$iv$iv2;
        Object value$iv$iv3;
        AnnotatedString annotatedString = text;
        int i3 = $changed;
        int i4 = i;
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Composer $composer3 = $composer.startRestartGroup(-1064305212);
        ComposerKt.sourceInformation($composer3, "C(BasicText)P(9,4,8,5,6:c#ui.text.style.TextOverflow,7,2,3,1)183@8574L7:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i4 & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer3.changed((Object) annotatedString) ? 4 : 2;
        }
        int i5 = i4 & 2;
        if (i5 != 0) {
            $dirty |= 48;
            Modifier modifier3 = modifier;
        } else if ((i3 & 112) == 0) {
            $dirty |= $composer3.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier4 = modifier;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            $dirty |= 384;
            TextStyle textStyle = style;
        } else if ((i3 & 896) == 0) {
            $dirty |= $composer3.changed((Object) style) ? 256 : 128;
        } else {
            TextStyle textStyle2 = style;
        }
        int i7 = i4 & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            Function1<? super TextLayoutResult, Unit> function12 = onTextLayout;
        } else if ((i3 & 7168) == 0) {
            $dirty |= $composer3.changedInstance(onTextLayout) ? 2048 : 1024;
        } else {
            Function1<? super TextLayoutResult, Unit> function13 = onTextLayout;
        }
        int i8 = i4 & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            i2 = overflow;
        } else if ((57344 & i3) == 0) {
            i2 = overflow;
            $dirty |= $composer3.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i9 = i4 & 32;
        if (i9 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            boolean z = softWrap;
        } else if ((i3 & 458752) == 0) {
            $dirty |= $composer3.changed(softWrap) ? 131072 : 65536;
        } else {
            boolean z2 = softWrap;
        }
        int i10 = i4 & 64;
        if (i10 != 0) {
            $dirty |= 1572864;
            int i11 = maxLines;
        } else if ((i3 & 3670016) == 0) {
            $dirty |= $composer3.changed(maxLines) ? 1048576 : 524288;
        } else {
            int i12 = maxLines;
        }
        int i13 = i4 & 128;
        if (i13 != 0) {
            $dirty |= 12582912;
            int i14 = minLines;
        } else if ((i3 & 29360128) == 0) {
            $dirty |= $composer3.changed(minLines) ? 8388608 : 4194304;
        } else {
            int i15 = minLines;
        }
        int i16 = i4 & 256;
        if (i16 != 0) {
            $dirty |= 33554432;
        }
        int i17 = i4 & 512;
        if (i17 != 0) {
            $dirty |= 268435456;
        }
        if ((i4 & ViewUtils.EDGE_TO_EDGE_FLAGS) == 768 && (1533916891 & $dirty) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            style2 = style;
            onTextLayout2 = onTextLayout;
            softWrap2 = softWrap;
            maxLines2 = maxLines;
            minLines2 = minLines;
            inlineContent2 = inlineContent;
            color2 = color;
            int i18 = $dirty;
            overflow2 = i2;
            $composer2 = $composer3;
            AnnotatedString annotatedString2 = annotatedString;
        } else {
            if (i5 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i6 != 0) {
                style2 = TextStyle.Companion.getDefault();
            } else {
                style2 = style;
            }
            if (i7 != 0) {
                onTextLayout2 = null;
            } else {
                onTextLayout2 = onTextLayout;
            }
            if (i8 != 0) {
                overflow2 = TextOverflow.Companion.m5756getClipgIe3tQ8();
            } else {
                overflow2 = i2;
            }
            if (i9 != 0) {
                softWrap2 = true;
            } else {
                softWrap2 = softWrap;
            }
            if (i10 != 0) {
                maxLines3 = Integer.MAX_VALUE;
            } else {
                maxLines3 = maxLines;
            }
            if (i13 != 0) {
                minLines3 = 1;
            } else {
                minLines3 = minLines;
            }
            if (i16 != 0) {
                inlineContent3 = MapsKt.emptyMap();
            } else {
                inlineContent3 = inlineContent;
            }
            if (i17 != 0) {
                color2 = null;
            } else {
                color2 = color;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1064305212, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:167)");
            }
            HeightInLinesModifierKt.validateMinMaxLines(minLines3, maxLines3);
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(SelectionRegistrarKt.getLocalSelectionRegistrar());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SelectionRegistrar selectionRegistrar = (SelectionRegistrar) consume;
            $composer3.startReplaceableGroup(959242448);
            ComposerKt.sourceInformation($composer3, "185@8710L7,186@8742L190");
            if (selectionRegistrar != null) {
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2 = $composer3.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                long backgroundSelectionColor = ((TextSelectionColors) consume2).m1151getBackgroundColor0d7_KjU();
                Object key2$iv = Color.m3243boximpl(backgroundSelectionColor);
                $composer3.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer3.changed((Object) selectionRegistrar) | $composer3.changed(key2$iv);
                Composer $this$cache$iv$iv = $composer3;
                Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                    value$iv$iv3 = new SelectionController(selectionRegistrar, backgroundSelectionColor, (StaticTextSelectionParams) null, 4, (DefaultConstructorMarker) null);
                    Object obj = it$iv$iv;
                    $this$cache$iv$iv.updateRememberedValue(value$iv$iv3);
                } else {
                    value$iv$iv3 = it$iv$iv;
                    Object it$iv$iv2 = $this$cache$iv$iv;
                }
                $composer3.endReplaceableGroup();
                selectionController = (SelectionController) value$iv$iv3;
            } else {
                selectionController = null;
            }
            $composer3.endReplaceableGroup();
            if (!AnnotatedStringResolveInlineContentKt.hasInlineContent(text)) {
                $composer3.startReplaceableGroup(959242835);
                ComposerKt.sourceInformation($composer3, "209@9592L7,197@9078L768");
                Modifier r0 = GraphicsLayerModifierKt.m3411graphicsLayerAp8cVGQ$default(modifier2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 0, 131071, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume3 = $composer3.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                int i19 = $dirty;
                SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                inlineContent2 = inlineContent3;
                minLines2 = minLines3;
                maxLines2 = maxLines3;
                Composer $composer4 = $composer3;
                Modifier modifier$iv = m883textModifierRWo7tUw(r0, text, style2, onTextLayout2, overflow2, softWrap2, maxLines3, minLines3, (FontFamily.Resolver) consume3, (List<AnnotatedString.Range<Placeholder>>) null, (Function1<? super List<Rect>, Unit>) null, selectionController, color2);
                MeasurePolicy measurePolicy$iv = EmptyMeasurePolicy.INSTANCE;
                $composer4.startReplaceableGroup(544976794);
                ComposerKt.sourceInformation($composer4, "CC(Layout)P(1)122@4734L23,125@4885L385:Layout.kt#80mrfh");
                int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                CompositionLocalMap localMap$iv = $composer4.getCurrentCompositionLocalMap();
                Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
                $composer4.startReplaceableGroup(1405779621);
                ComposerKt.sourceInformation($composer4, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    $composer4.createNode(new BasicTextKt$BasicTextRWo7tUw$$inlined$Layout$1(factory$iv$iv));
                } else {
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u241$iv = Updater.m2865constructorimpl($composer4);
                Modifier modifier5 = modifier$iv;
                Updater.m2872setimpl($this$Layout_u24lambda_u241$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2872setimpl($this$Layout_u24lambda_u241$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m2872setimpl($this$Layout_u24lambda_u241$iv, materialized$iv, ComposeUiNode.Companion.getSetModifier());
                Function2 block$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
                Composer $this$set_impl_u24lambda_u240$iv$iv = $this$Layout_u24lambda_u241$iv;
                if (!$this$set_impl_u24lambda_u240$iv$iv.getInserting()) {
                    MeasurePolicy measurePolicy = measurePolicy$iv;
                    if (Intrinsics.areEqual($this$set_impl_u24lambda_u240$iv$iv.rememberedValue(), (Object) Integer.valueOf(compositeKeyHash$iv))) {
                        Composer composer = $this$set_impl_u24lambda_u240$iv$iv;
                        $composer4.endNode();
                        $composer4.endReplaceableGroup();
                        $composer4.endReplaceableGroup();
                        $composer4.endReplaceableGroup();
                        $composer2 = $composer4;
                        AnnotatedString annotatedString3 = annotatedString;
                    }
                }
                $this$set_impl_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u241$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
                $composer4.endNode();
                $composer4.endReplaceableGroup();
                $composer4.endReplaceableGroup();
                $composer4.endReplaceableGroup();
                $composer2 = $composer4;
                AnnotatedString annotatedString32 = annotatedString;
            } else {
                int $dirty2 = $dirty;
                SelectionRegistrar selectionRegistrar3 = selectionRegistrar;
                minLines2 = minLines3;
                maxLines2 = maxLines3;
                Composer $composer5 = $composer3;
                $composer5.startReplaceableGroup(959243694);
                ComposerKt.sourceInformation($composer5, "222@10070L81,238@10733L7,240@10825L43,244@11020L38,225@10160L908");
                Map inlineContent4 = inlineContent3;
                Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> resolveInlineContent = AnnotatedStringResolveInlineContentKt.resolveInlineContent(annotatedString, inlineContent4);
                List placeholders = resolveInlineContent.component1();
                List inlineComposables = resolveInlineContent.component2();
                $composer5.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer5, "CC(remember):Composables.kt#9igjgp");
                Composer $this$cache$iv$iv2 = $composer5;
                Object it$iv$iv3 = $this$cache$iv$iv2.rememberedValue();
                if (it$iv$iv3 == Composer.Companion.getEmpty()) {
                    inlineContent2 = inlineContent4;
                    value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                    $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
                } else {
                    inlineContent2 = inlineContent4;
                    value$iv$iv = it$iv$iv3;
                }
                $composer5.endReplaceableGroup();
                MutableState measuredPlaceholderPositions = (MutableState) value$iv$iv;
                Modifier r12 = GraphicsLayerModifierKt.m3411graphicsLayerAp8cVGQ$default(modifier2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 0, 131071, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer5.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                ComposerKt.sourceInformationMarkerEnd($composer5);
                FontFamily.Resolver resolver = (FontFamily.Resolver) consume4;
                $composer5.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer5, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer5.changed((Object) measuredPlaceholderPositions);
                Composer $this$cache$iv$iv3 = $composer5;
                Object it$iv$iv4 = $this$cache$iv$iv3.rememberedValue();
                if (invalid$iv$iv2 || it$iv$iv4 == Composer.Companion.getEmpty()) {
                    function1 = new BasicTextKt$BasicText$3$1(measuredPlaceholderPositions);
                    $this$cache$iv$iv3.updateRememberedValue(function1);
                } else {
                    function1 = it$iv$iv4;
                }
                $composer5.endReplaceableGroup();
                $composer2 = $composer5;
                AnnotatedString annotatedString4 = annotatedString;
                Modifier modifier$iv2 = m883textModifierRWo7tUw(r12, text, style2, onTextLayout2, overflow2, softWrap2, maxLines2, minLines2, resolver, placeholders, function1, selectionController, color2);
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv3 = $composer2.changed((Object) measuredPlaceholderPositions);
                Composer $this$cache$iv$iv4 = $composer2;
                Object it$iv$iv5 = $this$cache$iv$iv4.rememberedValue();
                if (invalid$iv$iv3 || it$iv$iv5 == Composer.Companion.getEmpty()) {
                    value$iv$iv2 = (Function0) new BasicTextKt$BasicText$4$1(measuredPlaceholderPositions);
                    $this$cache$iv$iv4.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv5;
                }
                $composer2.endReplaceableGroup();
                MeasurePolicy measurePolicy$iv2 = new TextMeasurePolicy((Function0) value$iv$iv2);
                $composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int compositeKeyHash$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv2 = $composer2.getCurrentCompositionLocalMap();
                Function0 factory$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv = LayoutKt.modifierMaterializerOf(modifier$iv2);
                int $changed$iv$iv = ((0 << 9) & 7168) | 6;
                MutableState mutableState = measuredPlaceholderPositions;
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    $composer2.createNode(factory$iv$iv2);
                } else {
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv = Updater.m2865constructorimpl($composer2);
                List list = placeholders;
                Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, localMap$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 block$iv$iv2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                Composer $this$set_impl_u24lambda_u240$iv$iv2 = $this$Layout_u24lambda_u240$iv;
                if (!$this$set_impl_u24lambda_u240$iv$iv2.getInserting()) {
                    Modifier modifier6 = modifier$iv2;
                    MeasurePolicy measurePolicy2 = measurePolicy$iv2;
                    if (Intrinsics.areEqual($this$set_impl_u24lambda_u240$iv$iv2.rememberedValue(), (Object) Integer.valueOf(compositeKeyHash$iv2))) {
                        Composer composer2 = $this$set_impl_u24lambda_u240$iv$iv2;
                        skippableUpdate$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
                        $composer2.startReplaceableGroup(2058660585);
                        Composer $composer6 = $composer2;
                        int i20 = ($changed$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer6, 1350731549, "C226@10192L63:BasicText.kt#423gt5");
                        AnnotatedStringResolveInlineContentKt.InlineChildren(annotatedString4, inlineComposables, $composer6, ($dirty2 & 14) | 64);
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        $composer2.endReplaceableGroup();
                        $composer2.endNode();
                        $composer2.endReplaceableGroup();
                        $composer2.endReplaceableGroup();
                    }
                } else {
                    MeasurePolicy measurePolicy3 = measurePolicy$iv2;
                }
                $this$set_impl_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv2));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv2), block$iv$iv2);
                skippableUpdate$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
                $composer2.startReplaceableGroup(2058660585);
                Composer $composer62 = $composer2;
                int i202 = ($changed$iv$iv >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer62, 1350731549, "C226@10192L63:BasicText.kt#423gt5");
                AnnotatedStringResolveInlineContentKt.InlineChildren(annotatedString4, inlineComposables, $composer62, ($dirty2 & 14) | 64);
                ComposerKt.sourceInformationMarkerEnd($composer62);
                $composer2.endReplaceableGroup();
                $composer2.endNode();
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer3 = $composer2;
            return;
        }
        Composer composer4 = $composer2;
        endRestartGroup.updateScope(new BasicTextKt$BasicText$5(text, modifier2, style2, onTextLayout2, overflow2, softWrap2, maxLines2, minLines2, inlineContent2, color2, $changed, i));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-BpD7jsM  reason: not valid java name */
    public static final /* synthetic */ void m879BasicTextBpD7jsM(String text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, Composer $composer, int $changed, int i) {
        TextStyle textStyle;
        Function1 function1;
        int i2;
        boolean softWrap2;
        int i3;
        int overflow2;
        Function1 onTextLayout2;
        TextStyle style2;
        Modifier modifier2;
        int maxLines2;
        String str = text;
        int i4 = $changed;
        Intrinsics.checkNotNullParameter(str, "text");
        Composer $composer2 = $composer.startRestartGroup(1022429478);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(6,1,5,2,3:c#ui.text.style.TextOverflow,4)260@11460L234:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i4 & 14) == 0) {
            $dirty |= $composer2.changed((Object) str) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty |= 48;
            Modifier modifier3 = modifier;
        } else if ((i4 & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier4 = modifier;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty |= 384;
            textStyle = style;
        } else if ((i4 & 896) == 0) {
            textStyle = style;
            $dirty |= $composer2.changed((Object) textStyle) ? 256 : 128;
        } else {
            textStyle = style;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            function1 = onTextLayout;
        } else if ((i4 & 7168) == 0) {
            function1 = onTextLayout;
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        } else {
            function1 = onTextLayout;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            i2 = overflow;
        } else if ((i4 & 57344) == 0) {
            i2 = overflow;
            $dirty |= $composer2.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i9 = i & 32;
        if (i9 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            softWrap2 = softWrap;
        } else if ((i4 & 458752) == 0) {
            softWrap2 = softWrap;
            $dirty |= $composer2.changed(softWrap2) ? 131072 : 65536;
        } else {
            softWrap2 = softWrap;
        }
        int i10 = i & 64;
        if (i10 != 0) {
            $dirty |= 1572864;
            i3 = maxLines;
        } else if ((i4 & 3670016) == 0) {
            i3 = maxLines;
            $dirty |= $composer2.changed(i3) ? 1048576 : 524288;
        } else {
            i3 = maxLines;
        }
        if (($dirty & 2995931) != 599186 || !$composer2.getSkipping()) {
            if (i5 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i6 != 0) {
                style2 = TextStyle.Companion.getDefault();
            } else {
                style2 = textStyle;
            }
            if (i7 != 0) {
                onTextLayout2 = null;
            } else {
                onTextLayout2 = function1;
            }
            if (i8 != 0) {
                overflow2 = TextOverflow.Companion.m5756getClipgIe3tQ8();
            } else {
                overflow2 = i2;
            }
            if (i9 != 0) {
                softWrap2 = true;
            }
            if (i10 != 0) {
                maxLines2 = Integer.MAX_VALUE;
            } else {
                maxLines2 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1022429478, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:251)");
            }
            int i11 = $dirty;
            m882BasicTextVhcvRP8(text, modifier2, style2, (Function1<? super TextLayoutResult, Unit>) onTextLayout2, overflow2, softWrap2, maxLines2, 1, (ColorProducer) null, $composer2, 12582912 | ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | ($dirty & 3670016), 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            int i12 = $dirty;
            style2 = textStyle;
            onTextLayout2 = function1;
            maxLines2 = i3;
            overflow2 = i2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicTextKt$BasicText$6(text, modifier2, style2, onTextLayout2, overflow2, softWrap2, maxLines2, $changed, i));
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-4YKlhWE  reason: not valid java name */
    public static final /* synthetic */ void m877BasicText4YKlhWE(AnnotatedString text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, Map inlineContent, Composer $composer, int $changed, int i) {
        TextStyle textStyle;
        Function1 function1;
        int i2;
        boolean z;
        Map inlineContent2;
        int overflow2;
        Function1 onTextLayout2;
        TextStyle style2;
        Modifier modifier2;
        Composer $composer2;
        int maxLines2;
        boolean softWrap2;
        AnnotatedString annotatedString = text;
        int i3 = $changed;
        int i4 = i;
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Composer $composer3 = $composer.startRestartGroup(-648605928);
        ComposerKt.sourceInformation($composer3, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5,1)284@12151L273:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i4 & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer3.changed((Object) annotatedString) ? 4 : 2;
        }
        int i5 = i4 & 2;
        if (i5 != 0) {
            $dirty |= 48;
            Modifier modifier3 = modifier;
        } else if ((i3 & 112) == 0) {
            $dirty |= $composer3.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier4 = modifier;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            $dirty |= 384;
            textStyle = style;
        } else if ((i3 & 896) == 0) {
            textStyle = style;
            $dirty |= $composer3.changed((Object) textStyle) ? 256 : 128;
        } else {
            textStyle = style;
        }
        int i7 = i4 & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            function1 = onTextLayout;
        } else if ((i3 & 7168) == 0) {
            function1 = onTextLayout;
            $dirty |= $composer3.changedInstance(function1) ? 2048 : 1024;
        } else {
            function1 = onTextLayout;
        }
        int i8 = i4 & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            i2 = overflow;
        } else if ((i3 & 57344) == 0) {
            i2 = overflow;
            $dirty |= $composer3.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i9 = i4 & 32;
        if (i9 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z = softWrap;
        } else if ((i3 & 458752) == 0) {
            z = softWrap;
            $dirty |= $composer3.changed(z) ? 131072 : 65536;
        } else {
            z = softWrap;
        }
        int i10 = i4 & 64;
        if (i10 != 0) {
            $dirty |= 1572864;
            int i11 = maxLines;
        } else if ((i3 & 3670016) == 0) {
            $dirty |= $composer3.changed(maxLines) ? 1048576 : 524288;
        } else {
            int i12 = maxLines;
        }
        int i13 = i4 & 128;
        if (i13 != 0) {
            $dirty |= 4194304;
        }
        if (i13 == 128 && (23967451 & $dirty) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            maxLines2 = maxLines;
            inlineContent2 = inlineContent;
            int i14 = $dirty;
            style2 = textStyle;
            onTextLayout2 = function1;
            softWrap2 = z;
            overflow2 = i2;
            $composer2 = $composer3;
        } else {
            if (i5 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i6 != 0) {
                style2 = TextStyle.Companion.getDefault();
            } else {
                style2 = textStyle;
            }
            if (i7 != 0) {
                onTextLayout2 = null;
            } else {
                onTextLayout2 = function1;
            }
            if (i8 != 0) {
                overflow2 = TextOverflow.Companion.m5756getClipgIe3tQ8();
            } else {
                overflow2 = i2;
            }
            if (i9 != 0) {
                softWrap2 = true;
            } else {
                softWrap2 = z;
            }
            if (i10 != 0) {
                maxLines2 = Integer.MAX_VALUE;
            } else {
                maxLines2 = maxLines;
            }
            if (i13 != 0) {
                inlineContent2 = MapsKt.emptyMap();
            } else {
                inlineContent2 = inlineContent;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-648605928, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:274)");
            }
            int i15 = $dirty;
            $composer2 = $composer3;
            m880BasicTextRWo7tUw(text, modifier2, style2, onTextLayout2, overflow2, softWrap2, maxLines2, 1, inlineContent2, (ColorProducer) null, $composer3, 146800640 | ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752) | ($dirty & 3670016), 512);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicTextKt$BasicText$7(text, modifier2, style2, onTextLayout2, overflow2, softWrap2, maxLines2, inlineContent2, $changed, i));
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* renamed from: BasicText-4YKlhWE  reason: not valid java name */
    public static final /* synthetic */ void m878BasicText4YKlhWE(String text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Composer $composer, int $changed, int i) {
        Function1 function1;
        int i2;
        boolean z;
        int minLines2;
        boolean softWrap2;
        int overflow2;
        Function1 onTextLayout2;
        TextStyle style2;
        Modifier modifier2;
        int maxLines2;
        String str = text;
        int i3 = $changed;
        int i4 = i;
        Intrinsics.checkNotNullParameter(str, "text");
        Composer $composer2 = $composer.startRestartGroup(1542716361);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5)308@12822L86:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i4 & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changed((Object) str) ? 4 : 2;
        }
        int i5 = i4 & 2;
        if (i5 != 0) {
            $dirty |= 48;
            Modifier modifier3 = modifier;
        } else if ((i3 & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier4 = modifier;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            $dirty |= 384;
            TextStyle textStyle = style;
        } else if ((i3 & 896) == 0) {
            $dirty |= $composer2.changed((Object) style) ? 256 : 128;
        } else {
            TextStyle textStyle2 = style;
        }
        int i7 = i4 & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            function1 = onTextLayout;
        } else if ((i3 & 7168) == 0) {
            function1 = onTextLayout;
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        } else {
            function1 = onTextLayout;
        }
        int i8 = i4 & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            i2 = overflow;
        } else if ((i3 & 57344) == 0) {
            i2 = overflow;
            $dirty |= $composer2.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i9 = i4 & 32;
        if (i9 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z = softWrap;
        } else if ((i3 & 458752) == 0) {
            z = softWrap;
            $dirty |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = softWrap;
        }
        int i10 = i4 & 64;
        if (i10 != 0) {
            $dirty |= 1572864;
            int i11 = maxLines;
        } else if ((i3 & 3670016) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 1048576 : 524288;
        } else {
            int i12 = maxLines;
        }
        int i13 = i4 & 128;
        if (i13 != 0) {
            $dirty |= 12582912;
            int i14 = minLines;
        } else if ((i3 & 29360128) == 0) {
            $dirty |= $composer2.changed(minLines) ? 8388608 : 4194304;
        } else {
            int i15 = minLines;
        }
        if (($dirty & 23967451) != 4793490 || !$composer2.getSkipping()) {
            if (i5 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i6 != 0) {
                style2 = TextStyle.Companion.getDefault();
            } else {
                style2 = style;
            }
            if (i7 != 0) {
                onTextLayout2 = null;
            } else {
                onTextLayout2 = function1;
            }
            if (i8 != 0) {
                overflow2 = TextOverflow.Companion.m5756getClipgIe3tQ8();
            } else {
                overflow2 = i2;
            }
            if (i9 != 0) {
                softWrap2 = true;
            } else {
                softWrap2 = z;
            }
            if (i10 != 0) {
                maxLines2 = Integer.MAX_VALUE;
            } else {
                maxLines2 = maxLines;
            }
            if (i13 != 0) {
                minLines2 = 1;
            } else {
                minLines2 = minLines;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1542716361, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:299)");
            }
            int i16 = $dirty;
            m882BasicTextVhcvRP8(text, modifier2, style2, (Function1<? super TextLayoutResult, Unit>) onTextLayout2, overflow2, softWrap2, maxLines2, minLines2, (ColorProducer) null, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752) | ($dirty & 3670016) | ($dirty & 29360128), 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            style2 = style;
            maxLines2 = maxLines;
            minLines2 = minLines;
            int i17 = $dirty;
            onTextLayout2 = function1;
            softWrap2 = z;
            overflow2 = i2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicTextKt$BasicText$8(text, modifier2, style2, onTextLayout2, overflow2, softWrap2, maxLines2, minLines2, $changed, i));
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* renamed from: BasicText-VhcvRP8  reason: not valid java name */
    public static final /* synthetic */ void m881BasicTextVhcvRP8(AnnotatedString text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Map inlineContent, Composer $composer, int $changed, int i) {
        Function1 function1;
        int i2;
        boolean z;
        Map inlineContent2;
        int minLines2;
        int overflow2;
        Function1 onTextLayout2;
        TextStyle style2;
        Modifier modifier2;
        Composer $composer2;
        int maxLines2;
        boolean softWrap2;
        AnnotatedString annotatedString = text;
        int i3 = $changed;
        int i4 = i;
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Composer $composer3 = $composer.startRestartGroup(851408699);
        ComposerKt.sourceInformation($composer3, "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)322@13374L240:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i4 & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer3.changed((Object) annotatedString) ? 4 : 2;
        }
        int i5 = i4 & 2;
        if (i5 != 0) {
            $dirty |= 48;
            Modifier modifier3 = modifier;
        } else if ((i3 & 112) == 0) {
            $dirty |= $composer3.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier4 = modifier;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            $dirty |= 384;
            TextStyle textStyle = style;
        } else if ((i3 & 896) == 0) {
            $dirty |= $composer3.changed((Object) style) ? 256 : 128;
        } else {
            TextStyle textStyle2 = style;
        }
        int i7 = i4 & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            function1 = onTextLayout;
        } else if ((i3 & 7168) == 0) {
            function1 = onTextLayout;
            $dirty |= $composer3.changedInstance(function1) ? 2048 : 1024;
        } else {
            function1 = onTextLayout;
        }
        int i8 = i4 & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            i2 = overflow;
        } else if ((i3 & 57344) == 0) {
            i2 = overflow;
            $dirty |= $composer3.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i9 = i4 & 32;
        if (i9 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z = softWrap;
        } else if ((i3 & 458752) == 0) {
            z = softWrap;
            $dirty |= $composer3.changed(z) ? 131072 : 65536;
        } else {
            z = softWrap;
        }
        int i10 = i4 & 64;
        if (i10 != 0) {
            $dirty |= 1572864;
            int i11 = maxLines;
        } else if ((i3 & 3670016) == 0) {
            $dirty |= $composer3.changed(maxLines) ? 1048576 : 524288;
        } else {
            int i12 = maxLines;
        }
        int i13 = i4 & 128;
        if (i13 != 0) {
            $dirty |= 12582912;
            int i14 = minLines;
        } else if ((i3 & 29360128) == 0) {
            $dirty |= $composer3.changed(minLines) ? 8388608 : 4194304;
        } else {
            int i15 = minLines;
        }
        int i16 = i4 & 256;
        if (i16 != 0) {
            $dirty |= 33554432;
        }
        if (i16 == 256 && (191739611 & $dirty) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            style2 = style;
            maxLines2 = maxLines;
            minLines2 = minLines;
            inlineContent2 = inlineContent;
            int i17 = $dirty;
            onTextLayout2 = function1;
            softWrap2 = z;
            overflow2 = i2;
            $composer2 = $composer3;
        } else {
            if (i5 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i6 != 0) {
                style2 = TextStyle.Companion.getDefault();
            } else {
                style2 = style;
            }
            if (i7 != 0) {
                onTextLayout2 = null;
            } else {
                onTextLayout2 = function1;
            }
            if (i8 != 0) {
                overflow2 = TextOverflow.Companion.m5756getClipgIe3tQ8();
            } else {
                overflow2 = i2;
            }
            if (i9 != 0) {
                softWrap2 = true;
            } else {
                softWrap2 = z;
            }
            if (i10 != 0) {
                maxLines2 = Integer.MAX_VALUE;
            } else {
                maxLines2 = maxLines;
            }
            if (i13 != 0) {
                minLines2 = 1;
            } else {
                minLines2 = minLines;
            }
            if (i16 != 0) {
                inlineContent2 = MapsKt.emptyMap();
            } else {
                inlineContent2 = inlineContent;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(851408699, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:312)");
            }
            int i18 = $dirty;
            $composer2 = $composer3;
            m880BasicTextRWo7tUw(text, modifier2, style2, onTextLayout2, overflow2, softWrap2, maxLines2, minLines2, inlineContent2, (ColorProducer) null, $composer3, 134217728 | ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752) | ($dirty & 3670016) | ($dirty & 29360128), 512);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicTextKt$BasicText$9(text, modifier2, style2, onTextLayout2, overflow2, softWrap2, maxLines2, minLines2, inlineContent2, $changed, i));
        }
    }

    private static final Saver<Long, Long> selectionIdSaver(SelectionRegistrar selectionRegistrar) {
        return SaverKt.Saver(new BasicTextKt$selectionIdSaver$1(selectionRegistrar), BasicTextKt$selectionIdSaver$2.INSTANCE);
    }

    /* renamed from: textModifier-RWo7tUw  reason: not valid java name */
    private static final Modifier m883textModifierRWo7tUw(Modifier $this$textModifier_u2dRWo7tUw, AnnotatedString text, TextStyle style, Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, FontFamily.Resolver fontFamilyResolver, List<AnnotatedString.Range<Placeholder>> placeholders, Function1<? super List<Rect>, Unit> onPlaceholderLayout, SelectionController selectionController, ColorProducer color) {
        Modifier modifier = $this$textModifier_u2dRWo7tUw;
        if (selectionController == null) {
            return modifier.then(Modifier.Companion).then(new TextAnnotatedStringElement(text, style, fontFamilyResolver, onTextLayout, overflow, softWrap, maxLines, minLines, placeholders, onPlaceholderLayout, (SelectionController) null, color, (DefaultConstructorMarker) null));
        }
        return modifier.then(selectionController.getModifier()).then(new SelectableTextAnnotatedStringElement(text, style, fontFamilyResolver, onTextLayout, overflow, softWrap, maxLines, minLines, placeholders, onPlaceholderLayout, selectionController, color, (DefaultConstructorMarker) null));
    }
}

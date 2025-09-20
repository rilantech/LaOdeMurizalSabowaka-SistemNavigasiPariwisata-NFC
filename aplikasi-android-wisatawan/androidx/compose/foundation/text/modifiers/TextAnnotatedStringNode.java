package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B°\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017\u0012\u001e\b\u0002\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fø\u0001\u0000¢\u0006\u0002\u0010 J&\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0012J\u000e\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203J\u0010\u0010'\u001a\u00020\"2\u0006\u00104\u001a\u000205H\u0002J\u001e\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0014J\u001e\u0010<\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010=\u001a\u00020\u0014J+\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u00109\u001a\u00020B2\u0006\u0010C\u001a\u00020Dø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\u001e\u0010G\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0014J\u001e\u0010H\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010=\u001a\u00020\u0014JD\u0010I\u001a\u00020\u00122\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\u001c\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0018\u0010J\u001a\u00020\u00122\b\u0010K\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0007\u001a\u00020\bJY\u0010L\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\u000e\u0010O\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006J\f\u0010P\u001a\u00020\u000e*\u00020QH\u0016J\f\u0010R\u001a\u00020\u000e*\u000203H\u0016J\u001c\u0010S\u001a\u00020\u0014*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0014H\u0016J\u001c\u0010T\u001a\u00020\u0014*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010=\u001a\u00020\u0014H\u0016J)\u0010U\u001a\u00020?*\u00020A2\u0006\u00109\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010FJ\u001c\u0010W\u001a\u00020\u0014*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0014H\u0016J\u001c\u0010X\u001a\u00020\u0014*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010=\u001a\u00020\u0014H\u0016R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0014\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\"8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\u00020\u0010X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\"\u0010*\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0+\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Y"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_layoutCache", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "layoutCache", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "I", "semanticsTextLayoutResult", "", "doInvalidations", "drawChanged", "textChanged", "layoutChanged", "callbacksChanged", "drawNonExtension", "contentDrawScope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "density", "Landroidx/compose/ui/unit/Density;", "maxIntrinsicHeightNonExtension", "intrinsicMeasureScope", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidthNonExtension", "height", "measureNonExtension", "Landroidx/compose/ui/layout/MeasureResult;", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measureNonExtension-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeightNonExtension", "minIntrinsicWidthNonExtension", "updateCallbacks", "updateDraw", "color", "updateLayoutRelatedArgs", "updateLayoutRelatedArgs-MPT68mk", "(Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;I)Z", "updateText", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "measure-3p2s80s", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextAnnotatedStringNode.kt */
public final class TextAnnotatedStringNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    private MultiParagraphLayoutCache _layoutCache;
    private Map<AlignmentLine, Integer> baselineCache;
    private FontFamily.Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private Function1<? super List<Rect>, Unit> onPlaceholderLayout;
    private Function1<? super TextLayoutResult, Unit> onTextLayout;
    private int overflow;
    private ColorProducer overrideColor;
    private List<AnnotatedString.Range<Placeholder>> placeholders;
    private SelectionController selectionController;
    private Function1<? super List<TextLayoutResult>, Boolean> semanticsTextLayoutResult;
    private boolean softWrap;
    private TextStyle style;
    private AnnotatedString text;

    public /* synthetic */ TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i3, List list, Function1 function12, SelectionController selectionController2, ColorProducer colorProducer, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, selectionController2, colorProducer);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextAnnotatedStringNode(androidx.compose.ui.text.AnnotatedString r18, androidx.compose.ui.text.TextStyle r19, androidx.compose.ui.text.font.FontFamily.Resolver r20, kotlin.jvm.functions.Function1 r21, int r22, boolean r23, int r24, int r25, java.util.List r26, kotlin.jvm.functions.Function1 r27, androidx.compose.foundation.text.modifiers.SelectionController r28, androidx.compose.ui.graphics.ColorProducer r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r17 = this;
            r0 = r30
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r7 = r2
            goto L_0x000b
        L_0x0009:
            r7 = r21
        L_0x000b:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0017
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r1 = r1.m5756getClipgIe3tQ8()
            r8 = r1
            goto L_0x0019
        L_0x0017:
            r8 = r22
        L_0x0019:
            r1 = r0 & 32
            r3 = 1
            if (r1 == 0) goto L_0x0020
            r9 = r3
            goto L_0x0022
        L_0x0020:
            r9 = r23
        L_0x0022:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002b
            r1 = 2147483647(0x7fffffff, float:NaN)
            r10 = r1
            goto L_0x002d
        L_0x002b:
            r10 = r24
        L_0x002d:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0033
            r11 = r3
            goto L_0x0035
        L_0x0033:
            r11 = r25
        L_0x0035:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x003b
            r12 = r2
            goto L_0x003d
        L_0x003b:
            r12 = r26
        L_0x003d:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0043
            r13 = r2
            goto L_0x0045
        L_0x0043:
            r13 = r27
        L_0x0045:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x004b
            r14 = r2
            goto L_0x004d
        L_0x004b:
            r14 = r28
        L_0x004d:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0053
            r15 = r2
            goto L_0x0055
        L_0x0053:
            r15 = r29
        L_0x0055:
            r16 = 0
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.font.FontFamily$Resolver, kotlin.jvm.functions.Function1, int, boolean, int, int, java.util.List, kotlin.jvm.functions.Function1, androidx.compose.foundation.text.modifiers.SelectionController, androidx.compose.ui.graphics.ColorProducer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private TextAnnotatedStringNode(AnnotatedString text2, TextStyle style2, FontFamily.Resolver fontFamilyResolver2, Function1<? super TextLayoutResult, Unit> onTextLayout2, int overflow2, boolean softWrap2, int maxLines2, int minLines2, List<AnnotatedString.Range<Placeholder>> placeholders2, Function1<? super List<Rect>, Unit> onPlaceholderLayout2, SelectionController selectionController2, ColorProducer overrideColor2) {
        Intrinsics.checkNotNullParameter(text2, "text");
        Intrinsics.checkNotNullParameter(style2, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver2, "fontFamilyResolver");
        this.text = text2;
        this.style = style2;
        this.fontFamilyResolver = fontFamilyResolver2;
        this.onTextLayout = onTextLayout2;
        this.overflow = overflow2;
        this.softWrap = softWrap2;
        this.maxLines = maxLines2;
        this.minLines = minLines2;
        this.placeholders = placeholders2;
        this.onPlaceholderLayout = onPlaceholderLayout2;
        this.selectionController = selectionController2;
        this.overrideColor = overrideColor2;
    }

    /* access modifiers changed from: private */
    public final MultiParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache == null) {
            this._layoutCache = new MultiParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, (DefaultConstructorMarker) null);
        }
        MultiParagraphLayoutCache multiParagraphLayoutCache = this._layoutCache;
        Intrinsics.checkNotNull(multiParagraphLayoutCache);
        return multiParagraphLayoutCache;
    }

    private final MultiParagraphLayoutCache getLayoutCache(Density density) {
        MultiParagraphLayoutCache it = getLayoutCache();
        it.setDensity$foundation_release(density);
        return it;
    }

    public final boolean updateDraw(ColorProducer color, TextStyle style2) {
        Intrinsics.checkNotNullParameter(style2, "style");
        boolean changed = false;
        if (!Intrinsics.areEqual((Object) color, (Object) this.overrideColor)) {
            changed = true;
        }
        this.overrideColor = color;
        return changed || !style2.hasSameDrawAffectingAttributes(this.style);
    }

    public final boolean updateText(AnnotatedString text2) {
        Intrinsics.checkNotNullParameter(text2, "text");
        if (Intrinsics.areEqual((Object) this.text, (Object) text2)) {
            return false;
        }
        this.text = text2;
        return true;
    }

    /* renamed from: updateLayoutRelatedArgs-MPT68mk  reason: not valid java name */
    public final boolean m1033updateLayoutRelatedArgsMPT68mk(TextStyle style2, List<AnnotatedString.Range<Placeholder>> placeholders2, int minLines2, int maxLines2, boolean softWrap2, FontFamily.Resolver fontFamilyResolver2, int overflow2) {
        Intrinsics.checkNotNullParameter(style2, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver2, "fontFamilyResolver");
        boolean changed = !this.style.hasSameLayoutAffectingAttributes(style2);
        this.style = style2;
        if (!Intrinsics.areEqual((Object) this.placeholders, (Object) placeholders2)) {
            this.placeholders = placeholders2;
            changed = true;
        }
        if (this.minLines != minLines2) {
            this.minLines = minLines2;
            changed = true;
        }
        if (this.maxLines != maxLines2) {
            this.maxLines = maxLines2;
            changed = true;
        }
        if (this.softWrap != softWrap2) {
            this.softWrap = softWrap2;
            changed = true;
        }
        if (!Intrinsics.areEqual((Object) this.fontFamilyResolver, (Object) fontFamilyResolver2)) {
            this.fontFamilyResolver = fontFamilyResolver2;
            changed = true;
        }
        if (TextOverflow.m5749equalsimpl0(this.overflow, overflow2)) {
            return changed;
        }
        this.overflow = overflow2;
        return true;
    }

    public final boolean updateCallbacks(Function1<? super TextLayoutResult, Unit> onTextLayout2, Function1<? super List<Rect>, Unit> onPlaceholderLayout2, SelectionController selectionController2) {
        boolean changed = false;
        if (!Intrinsics.areEqual((Object) this.onTextLayout, (Object) onTextLayout2)) {
            this.onTextLayout = onTextLayout2;
            changed = true;
        }
        if (!Intrinsics.areEqual((Object) this.onPlaceholderLayout, (Object) onPlaceholderLayout2)) {
            this.onPlaceholderLayout = onPlaceholderLayout2;
            changed = true;
        }
        if (Intrinsics.areEqual((Object) this.selectionController, (Object) selectionController2)) {
            return changed;
        }
        this.selectionController = selectionController2;
        return true;
    }

    public final void doInvalidations(boolean drawChanged, boolean textChanged, boolean layoutChanged, boolean callbacksChanged) {
        if (isAttached()) {
            if (textChanged || (drawChanged && this.semanticsTextLayoutResult != null)) {
                SemanticsModifierNodeKt.invalidateSemantics(this);
            }
            if (textChanged || layoutChanged || callbacksChanged) {
                getLayoutCache().m1010updateZNqEYIc(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders);
                LayoutModifierNodeKt.invalidateMeasurement(this);
                DrawModifierNodeKt.invalidateDraw(this);
            }
            if (drawChanged) {
                DrawModifierNodeKt.invalidateDraw(this);
            }
        }
    }

    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        Intrinsics.checkNotNullParameter($this$applySemantics, "<this>");
        Function1 localSemanticsTextLayoutResult = this.semanticsTextLayoutResult;
        if (localSemanticsTextLayoutResult == null) {
            localSemanticsTextLayoutResult = new TextAnnotatedStringNode$applySemantics$1(this);
            this.semanticsTextLayoutResult = localSemanticsTextLayoutResult;
        }
        SemanticsPropertiesKt.setText($this$applySemantics, this.text);
        SemanticsPropertiesKt.getTextLayoutResult$default($this$applySemantics, (String) null, localSemanticsTextLayoutResult, 1, (Object) null);
    }

    /* renamed from: measureNonExtension-3p2s80s  reason: not valid java name */
    public final MeasureResult m1032measureNonExtension3p2s80s(MeasureScope measureScope, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter(measureScope, "measureScope");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return m1031measure3p2s80s(measureScope, measurable, constraints);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m1031measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        MultiParagraphLayoutCache layoutCache = getLayoutCache($this$measure_u2d3p2s80s);
        boolean didChangeLayout = layoutCache.m1009layoutWithConstraintsK40F9xA(constraints, $this$measure_u2d3p2s80s.getLayoutDirection());
        TextLayoutResult textLayoutResult = layoutCache.getTextLayoutResult();
        textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts();
        if (didChangeLayout) {
            LayoutModifierNodeKt.invalidateLayer(this);
            Function1<? super TextLayoutResult, Unit> function1 = this.onTextLayout;
            if (function1 != null) {
                function1.invoke(textLayoutResult);
            }
            SelectionController selectionController2 = this.selectionController;
            if (selectionController2 != null) {
                selectionController2.updateTextLayout(textLayoutResult);
            }
            this.baselineCache = MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(textLayoutResult.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(textLayoutResult.getLastBaseline()))));
        }
        Function1<? super List<Rect>, Unit> function12 = this.onPlaceholderLayout;
        if (function12 != null) {
            function12.invoke(textLayoutResult.getPlaceholderRects());
        }
        Placeable placeable = measurable.m4689measureBRTryo0(Constraints.Companion.m5796fixedJhjzzOo(IntSize.m6004getWidthimpl(textLayoutResult.m5298getSizeYbymL2g()), IntSize.m6003getHeightimpl(textLayoutResult.m5298getSizeYbymL2g())));
        int r4 = IntSize.m6004getWidthimpl(textLayoutResult.m5298getSizeYbymL2g());
        int r5 = IntSize.m6003getHeightimpl(textLayoutResult.m5298getSizeYbymL2g());
        Map<AlignmentLine, Integer> map = this.baselineCache;
        Intrinsics.checkNotNull(map);
        return $this$measure_u2d3p2s80s.layout(r4, r5, map, new TextAnnotatedStringNode$measure$1(placeable));
    }

    public final int minIntrinsicWidthNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return minIntrinsicWidth(intrinsicMeasureScope, measurable, height);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache($this$minIntrinsicWidth).minIntrinsicWidth($this$minIntrinsicWidth.getLayoutDirection());
    }

    public final int minIntrinsicHeightNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return minIntrinsicHeight(intrinsicMeasureScope, measurable, width);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache($this$minIntrinsicHeight).intrinsicHeight(width, $this$minIntrinsicHeight.getLayoutDirection());
    }

    public final int maxIntrinsicWidthNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return maxIntrinsicWidth(intrinsicMeasureScope, measurable, height);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache($this$maxIntrinsicWidth).maxIntrinsicWidth($this$maxIntrinsicWidth.getLayoutDirection());
    }

    public final int maxIntrinsicHeightNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return maxIntrinsicHeight(intrinsicMeasureScope, measurable, width);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache($this$maxIntrinsicHeight).intrinsicHeight(width, $this$maxIntrinsicHeight.getLayoutDirection());
    }

    public final void drawNonExtension(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "contentDrawScope");
        draw(contentDrawScope);
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope r30) {
        /*
            r29 = this;
            r1 = r29
            r2 = r30
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r0 = r29.isAttached()
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            androidx.compose.foundation.text.modifiers.SelectionController r0 = r1.selectionController
            if (r0 == 0) goto L_0x001a
            r3 = r2
            androidx.compose.ui.graphics.drawscope.DrawScope r3 = (androidx.compose.ui.graphics.drawscope.DrawScope) r3
            r0.draw(r3)
        L_0x001a:
            r3 = r2
            androidx.compose.ui.graphics.drawscope.DrawScope r3 = (androidx.compose.ui.graphics.drawscope.DrawScope) r3
            r4 = 0
            androidx.compose.ui.graphics.drawscope.DrawContext r0 = r3.getDrawContext()
            androidx.compose.ui.graphics.Canvas r15 = r0.getCanvas()
            r22 = 0
            androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache r0 = r29.getLayoutCache()
            androidx.compose.ui.text.TextLayoutResult r23 = r0.getTextLayoutResult()
            androidx.compose.ui.text.MultiParagraph r24 = r23.getMultiParagraph()
            boolean r0 = r23.getHasVisualOverflow()
            r25 = 1
            r14 = 0
            if (r0 == 0) goto L_0x004e
            int r0 = r1.overflow
            androidx.compose.ui.text.style.TextOverflow$Companion r5 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r5 = r5.m5758getVisiblegIe3tQ8()
            boolean r0 = androidx.compose.ui.text.style.TextOverflow.m5749equalsimpl0(r0, r5)
            if (r0 != 0) goto L_0x004e
            r0 = r25
            goto L_0x004f
        L_0x004e:
            r0 = r14
        L_0x004f:
            r26 = r0
            if (r26 == 0) goto L_0x007b
            long r5 = r23.m5298getSizeYbymL2g()
            int r0 = androidx.compose.ui.unit.IntSize.m6004getWidthimpl(r5)
            float r0 = (float) r0
            long r5 = r23.m5298getSizeYbymL2g()
            int r5 = androidx.compose.ui.unit.IntSize.m6003getHeightimpl(r5)
            float r5 = (float) r5
            androidx.compose.ui.geometry.Offset$Companion r6 = androidx.compose.ui.geometry.Offset.Companion
            long r6 = r6.m3019getZeroF1C5BW0()
            long r8 = androidx.compose.ui.geometry.SizeKt.Size(r0, r5)
            androidx.compose.ui.geometry.Rect r6 = androidx.compose.ui.geometry.RectKt.m3043Recttz77jQw(r6, r8)
            r15.save()
            r7 = 2
            r8 = 0
            androidx.compose.ui.graphics.Canvas.m3216clipRectmtrdDE$default(r15, r6, r14, r7, r8)
        L_0x007b:
            androidx.compose.ui.text.TextStyle r0 = r1.style     // Catch:{ all -> 0x015c }
            androidx.compose.ui.text.style.TextDecoration r0 = r0.getTextDecoration()     // Catch:{ all -> 0x015c }
            if (r0 != 0) goto L_0x0090
            androidx.compose.ui.text.style.TextDecoration$Companion r0 = androidx.compose.ui.text.style.TextDecoration.Companion     // Catch:{ all -> 0x008b }
            androidx.compose.ui.text.style.TextDecoration r0 = r0.getNone()     // Catch:{ all -> 0x008b }
            goto L_0x0090
        L_0x008b:
            r0 = move-exception
            r28 = r15
            goto L_0x015f
        L_0x0090:
            r10 = r0
            androidx.compose.ui.text.TextStyle r0 = r1.style     // Catch:{ all -> 0x015c }
            androidx.compose.ui.graphics.Shadow r0 = r0.getShadow()     // Catch:{ all -> 0x015c }
            if (r0 != 0) goto L_0x009f
            androidx.compose.ui.graphics.Shadow$Companion r0 = androidx.compose.ui.graphics.Shadow.Companion     // Catch:{ all -> 0x008b }
            androidx.compose.ui.graphics.Shadow r0 = r0.getNone()     // Catch:{ all -> 0x008b }
        L_0x009f:
            r9 = r0
            androidx.compose.ui.text.TextStyle r0 = r1.style     // Catch:{ all -> 0x015c }
            androidx.compose.ui.graphics.drawscope.DrawStyle r0 = r0.getDrawStyle()     // Catch:{ all -> 0x015c }
            if (r0 != 0) goto L_0x00ac
            androidx.compose.ui.graphics.drawscope.Fill r0 = androidx.compose.ui.graphics.drawscope.Fill.INSTANCE     // Catch:{ all -> 0x008b }
            androidx.compose.ui.graphics.drawscope.DrawStyle r0 = (androidx.compose.ui.graphics.drawscope.DrawStyle) r0     // Catch:{ all -> 0x008b }
        L_0x00ac:
            r11 = r0
            androidx.compose.ui.text.TextStyle r0 = r1.style     // Catch:{ all -> 0x015c }
            androidx.compose.ui.graphics.Brush r0 = r0.getBrush()     // Catch:{ all -> 0x015c }
            if (r0 == 0) goto L_0x00d6
            androidx.compose.ui.text.TextStyle r5 = r1.style     // Catch:{ all -> 0x008b }
            float r8 = r5.getAlpha()     // Catch:{ all -> 0x008b }
            r13 = 64
            r16 = 0
            r12 = 0
            r5 = r24
            r6 = r15
            r7 = r0
            r27 = r14
            r14 = r16
            androidx.compose.ui.text.MultiParagraph.m5207painthn5TExg$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x008b }
            r28 = r15
            goto L_0x013d
        L_0x00d6:
            r27 = r14
            androidx.compose.ui.graphics.ColorProducer r5 = r1.overrideColor     // Catch:{ all -> 0x015c }
            if (r5 == 0) goto L_0x00e1
            long r5 = r5.m3330invoke0d7_KjU()     // Catch:{ all -> 0x008b }
            goto L_0x00e7
        L_0x00e1:
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion     // Catch:{ all -> 0x015c }
            long r5 = r5.m3289getUnspecified0d7_KjU()     // Catch:{ all -> 0x015c }
        L_0x00e7:
            r7 = r5
            r12 = 0
            androidx.compose.ui.graphics.Color$Companion r13 = androidx.compose.ui.graphics.Color.Companion     // Catch:{ all -> 0x015c }
            long r13 = r13.m3289getUnspecified0d7_KjU()     // Catch:{ all -> 0x015c }
            int r13 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r13 == 0) goto L_0x00f6
            r14 = r25
            goto L_0x00f8
        L_0x00f6:
            r14 = r27
        L_0x00f8:
            if (r14 == 0) goto L_0x00fc
            r7 = r5
            goto L_0x0121
        L_0x00fc:
            androidx.compose.ui.text.TextStyle r7 = r1.style     // Catch:{ all -> 0x015c }
            long r7 = r7.m5346getColor0d7_KjU()     // Catch:{ all -> 0x015c }
            r12 = 0
            androidx.compose.ui.graphics.Color$Companion r13 = androidx.compose.ui.graphics.Color.Companion     // Catch:{ all -> 0x015c }
            long r13 = r13.m3289getUnspecified0d7_KjU()     // Catch:{ all -> 0x015c }
            int r13 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r13 == 0) goto L_0x0110
            r14 = r25
            goto L_0x0112
        L_0x0110:
            r14 = r27
        L_0x0112:
            if (r14 == 0) goto L_0x011b
            androidx.compose.ui.text.TextStyle r7 = r1.style     // Catch:{ all -> 0x008b }
            long r7 = r7.m5346getColor0d7_KjU()     // Catch:{ all -> 0x008b }
            goto L_0x0121
        L_0x011b:
            androidx.compose.ui.graphics.Color$Companion r7 = androidx.compose.ui.graphics.Color.Companion     // Catch:{ all -> 0x015c }
            long r7 = r7.m3279getBlack0d7_KjU()     // Catch:{ all -> 0x015c }
        L_0x0121:
            r28 = r15
            r14 = r7
            r20 = 32
            r21 = 0
            r19 = 0
            r12 = r24
            r13 = r28
            r16 = r9
            r17 = r10
            r18 = r11
            androidx.compose.ui.text.MultiParagraph.m5205paintLG529CI$default(r12, r13, r14, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x015a }
        L_0x013d:
            if (r26 == 0) goto L_0x0142
            r28.restore()
        L_0x0142:
            java.util.List<androidx.compose.ui.text.AnnotatedString$Range<androidx.compose.ui.text.Placeholder>> r0 = r1.placeholders
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x0154
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0152
            goto L_0x0154
        L_0x0152:
            r25 = r27
        L_0x0154:
            if (r25 != 0) goto L_0x0159
            r30.drawContent()
        L_0x0159:
            return
        L_0x015a:
            r0 = move-exception
            goto L_0x015f
        L_0x015c:
            r0 = move-exception
            r28 = r15
        L_0x015f:
            if (r26 == 0) goto L_0x0164
            r28.restore()
        L_0x0164:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope):void");
    }
}

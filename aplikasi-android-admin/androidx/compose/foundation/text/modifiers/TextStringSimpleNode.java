package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorProducer;
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
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BT\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u001e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000eJ\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0002J\u0018\u0010)\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\bJC\u0010+\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u000e\u0010.\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006J\f\u0010/\u001a\u00020#*\u000200H\u0016J\f\u00101\u001a\u00020#*\u000202H\u0016J\u001c\u00103\u001a\u00020\u0010*\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0010H\u0016J\u001c\u00108\u001a\u00020\u0010*\u0002042\u0006\u00105\u001a\u0002062\u0006\u00109\u001a\u00020\u0010H\u0016J)\u0010:\u001a\u00020;*\u00020<2\u0006\u00105\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u001c\u0010B\u001a\u00020\u0010*\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0010H\u0016J\u001c\u0010C\u001a\u00020\u0010*\u0002042\u0006\u00105\u001a\u0002062\u0006\u00109\u001a\u00020\u0010H\u0016R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\u00020\fX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 \u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006D"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_layoutCache", "Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "layoutCache", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "I", "semanticsTextLayoutResult", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "doInvalidations", "", "drawChanged", "textChanged", "layoutChanged", "density", "Landroidx/compose/ui/unit/Density;", "updateDraw", "color", "updateLayoutRelatedArgs", "updateLayoutRelatedArgs-HuAbxIM", "(Landroidx/compose/ui/text/TextStyle;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;I)Z", "updateText", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextStringSimpleNode.kt */
public final class TextStringSimpleNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    private ParagraphLayoutCache _layoutCache;
    private Map<AlignmentLine, Integer> baselineCache;
    private FontFamily.Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private int overflow;
    private ColorProducer overrideColor;
    private Function1<? super List<TextLayoutResult>, Boolean> semanticsTextLayoutResult;
    private boolean softWrap;
    private TextStyle style;
    private String text;

    public /* synthetic */ TextStringSimpleNode(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, ColorProducer colorProducer, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, resolver, i, z, i2, i3, colorProducer);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStringSimpleNode(java.lang.String r13, androidx.compose.ui.text.TextStyle r14, androidx.compose.ui.text.font.FontFamily.Resolver r15, int r16, boolean r17, int r18, int r19, androidx.compose.ui.graphics.ColorProducer r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 8
            if (r1 == 0) goto L_0x000e
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r1 = r1.m7466getClipgIe3tQ8()
            r6 = r1
            goto L_0x0010
        L_0x000e:
            r6 = r16
        L_0x0010:
            r1 = r0 & 16
            r2 = 1
            if (r1 == 0) goto L_0x0017
            r7 = r2
            goto L_0x0019
        L_0x0017:
            r7 = r17
        L_0x0019:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0022
            r1 = 2147483647(0x7fffffff, float:NaN)
            r8 = r1
            goto L_0x0024
        L_0x0022:
            r8 = r18
        L_0x0024:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002a
            r9 = r2
            goto L_0x002c
        L_0x002a:
            r9 = r19
        L_0x002c:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0033
            r0 = 0
            r10 = r0
            goto L_0x0035
        L_0x0033:
            r10 = r20
        L_0x0035:
            r11 = 0
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextStringSimpleNode.<init>(java.lang.String, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.font.FontFamily$Resolver, int, boolean, int, int, androidx.compose.ui.graphics.ColorProducer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private TextStringSimpleNode(String text2, TextStyle style2, FontFamily.Resolver fontFamilyResolver2, int overflow2, boolean softWrap2, int maxLines2, int minLines2, ColorProducer overrideColor2) {
        Intrinsics.checkNotNullParameter(text2, "text");
        Intrinsics.checkNotNullParameter(style2, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver2, "fontFamilyResolver");
        this.text = text2;
        this.style = style2;
        this.fontFamilyResolver = fontFamilyResolver2;
        this.overflow = overflow2;
        this.softWrap = softWrap2;
        this.maxLines = maxLines2;
        this.minLines = minLines2;
        this.overrideColor = overrideColor2;
    }

    /* access modifiers changed from: private */
    public final ParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache == null) {
            this._layoutCache = new ParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, (DefaultConstructorMarker) null);
        }
        ParagraphLayoutCache paragraphLayoutCache = this._layoutCache;
        Intrinsics.checkNotNull(paragraphLayoutCache);
        return paragraphLayoutCache;
    }

    private final ParagraphLayoutCache getLayoutCache(Density density) {
        ParagraphLayoutCache it = getLayoutCache();
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

    public final boolean updateText(String text2) {
        Intrinsics.checkNotNullParameter(text2, "text");
        if (Intrinsics.areEqual((Object) this.text, (Object) text2)) {
            return false;
        }
        this.text = text2;
        return true;
    }

    /* renamed from: updateLayoutRelatedArgs-HuAbxIM  reason: not valid java name */
    public final boolean m2745updateLayoutRelatedArgsHuAbxIM(TextStyle style2, int minLines2, int maxLines2, boolean softWrap2, FontFamily.Resolver fontFamilyResolver2, int overflow2) {
        Intrinsics.checkNotNullParameter(style2, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver2, "fontFamilyResolver");
        boolean changed = !this.style.hasSameLayoutAffectingAttributes(style2);
        this.style = style2;
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
        if (TextOverflow.m7459equalsimpl0(this.overflow, overflow2)) {
            return changed;
        }
        this.overflow = overflow2;
        return true;
    }

    public final void doInvalidations(boolean drawChanged, boolean textChanged, boolean layoutChanged) {
        if (isAttached()) {
            if (textChanged || (drawChanged && this.semanticsTextLayoutResult != null)) {
                SemanticsModifierNodeKt.invalidateSemantics(this);
            }
            if (textChanged || layoutChanged) {
                getLayoutCache().m2726updateL6sJoHM(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
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
            localSemanticsTextLayoutResult = new TextStringSimpleNode$applySemantics$1(this);
            this.semanticsTextLayoutResult = localSemanticsTextLayoutResult;
        }
        SemanticsPropertiesKt.setText($this$applySemantics, new AnnotatedString(this.text, (List) null, (List) null, 6, (DefaultConstructorMarker) null));
        SemanticsPropertiesKt.getTextLayoutResult$default($this$applySemantics, (String) null, localSemanticsTextLayoutResult, 1, (Object) null);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2744measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        ParagraphLayoutCache layoutCache = getLayoutCache($this$measure_u2d3p2s80s);
        boolean didChangeLayout = layoutCache.m2724layoutWithConstraintsK40F9xA(constraints, $this$measure_u2d3p2s80s.getLayoutDirection());
        layoutCache.getObserveFontChanges$foundation_release();
        Paragraph paragraph = layoutCache.getParagraph$foundation_release();
        Intrinsics.checkNotNull(paragraph);
        long layoutSize = layoutCache.m2723getLayoutSizeYbymL2g$foundation_release();
        if (didChangeLayout) {
            LayoutModifierNodeKt.invalidateLayer(this);
            Map cache = this.baselineCache;
            if (cache == null) {
                cache = new LinkedHashMap(2);
            }
            cache.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(paragraph.getFirstBaseline())));
            cache.put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(paragraph.getLastBaseline())));
            this.baselineCache = cache;
        }
        Placeable placeable = measurable.m6399measureBRTryo0(Constraints.Companion.m7506fixedJhjzzOo(IntSize.m7714getWidthimpl(layoutSize), IntSize.m7713getHeightimpl(layoutSize)));
        int r6 = IntSize.m7714getWidthimpl(layoutSize);
        int r7 = IntSize.m7713getHeightimpl(layoutSize);
        Map<AlignmentLine, Integer> map = this.baselineCache;
        Intrinsics.checkNotNull(map);
        return $this$measure_u2d3p2s80s.layout(r6, r7, map, new TextStringSimpleNode$measure$1(placeable));
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache($this$minIntrinsicWidth).minIntrinsicWidth($this$minIntrinsicWidth.getLayoutDirection());
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache($this$minIntrinsicHeight).intrinsicHeight(width, $this$minIntrinsicHeight.getLayoutDirection());
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache($this$maxIntrinsicWidth).maxIntrinsicWidth($this$maxIntrinsicWidth.getLayoutDirection());
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache($this$maxIntrinsicHeight).intrinsicHeight(width, $this$maxIntrinsicHeight.getLayoutDirection());
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x012d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope r29) {
        /*
            r28 = this;
            r1 = r28
            r2 = r29
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r0 = r28.isAttached()
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            androidx.compose.foundation.text.modifiers.ParagraphLayoutCache r0 = r28.getLayoutCache()
            androidx.compose.ui.text.Paragraph r3 = r0.getParagraph$foundation_release()
            if (r3 == 0) goto L_0x0131
            r13 = r2
            androidx.compose.ui.graphics.drawscope.DrawScope r13 = (androidx.compose.ui.graphics.drawscope.DrawScope) r13
            r14 = 0
            androidx.compose.ui.graphics.drawscope.DrawContext r0 = r13.getDrawContext()
            androidx.compose.ui.graphics.Canvas r15 = r0.getCanvas()
            r25 = 0
            androidx.compose.foundation.text.modifiers.ParagraphLayoutCache r0 = r28.getLayoutCache()
            boolean r26 = r0.getDidOverflow$foundation_release()
            r0 = 0
            if (r26 == 0) goto L_0x0063
            androidx.compose.foundation.text.modifiers.ParagraphLayoutCache r4 = r28.getLayoutCache()
            long r4 = r4.m2723getLayoutSizeYbymL2g$foundation_release()
            int r4 = androidx.compose.ui.unit.IntSize.m7714getWidthimpl(r4)
            float r4 = (float) r4
            androidx.compose.foundation.text.modifiers.ParagraphLayoutCache r5 = r28.getLayoutCache()
            long r5 = r5.m2723getLayoutSizeYbymL2g$foundation_release()
            int r5 = androidx.compose.ui.unit.IntSize.m7713getHeightimpl(r5)
            float r5 = (float) r5
            androidx.compose.ui.geometry.Offset$Companion r6 = androidx.compose.ui.geometry.Offset.Companion
            long r6 = r6.m4729getZeroF1C5BW0()
            long r8 = androidx.compose.ui.geometry.SizeKt.Size(r4, r5)
            androidx.compose.ui.geometry.Rect r6 = androidx.compose.ui.geometry.RectKt.m4753Recttz77jQw(r6, r8)
            r15.save()
            r7 = 2
            r8 = 0
            androidx.compose.ui.graphics.Canvas.m4926clipRectmtrdDE$default(r15, r6, r0, r7, r8)
        L_0x0063:
            androidx.compose.ui.text.TextStyle r4 = r1.style     // Catch:{ all -> 0x0129 }
            androidx.compose.ui.text.style.TextDecoration r4 = r4.getTextDecoration()     // Catch:{ all -> 0x0129 }
            if (r4 != 0) goto L_0x0077
            androidx.compose.ui.text.style.TextDecoration$Companion r4 = androidx.compose.ui.text.style.TextDecoration.Companion     // Catch:{ all -> 0x0073 }
            androidx.compose.ui.text.style.TextDecoration r4 = r4.getNone()     // Catch:{ all -> 0x0073 }
            goto L_0x0077
        L_0x0073:
            r0 = move-exception
            r6 = r15
            goto L_0x012b
        L_0x0077:
            r8 = r4
            androidx.compose.ui.text.TextStyle r4 = r1.style     // Catch:{ all -> 0x0129 }
            androidx.compose.ui.graphics.Shadow r4 = r4.getShadow()     // Catch:{ all -> 0x0129 }
            if (r4 != 0) goto L_0x0086
            androidx.compose.ui.graphics.Shadow$Companion r4 = androidx.compose.ui.graphics.Shadow.Companion     // Catch:{ all -> 0x0073 }
            androidx.compose.ui.graphics.Shadow r4 = r4.getNone()     // Catch:{ all -> 0x0073 }
        L_0x0086:
            r7 = r4
            androidx.compose.ui.text.TextStyle r4 = r1.style     // Catch:{ all -> 0x0129 }
            androidx.compose.ui.graphics.drawscope.DrawStyle r4 = r4.getDrawStyle()     // Catch:{ all -> 0x0129 }
            if (r4 != 0) goto L_0x0093
            androidx.compose.ui.graphics.drawscope.Fill r4 = androidx.compose.ui.graphics.drawscope.Fill.INSTANCE     // Catch:{ all -> 0x0073 }
            androidx.compose.ui.graphics.drawscope.DrawStyle r4 = (androidx.compose.ui.graphics.drawscope.DrawStyle) r4     // Catch:{ all -> 0x0073 }
        L_0x0093:
            r9 = r4
            androidx.compose.ui.text.TextStyle r4 = r1.style     // Catch:{ all -> 0x0129 }
            androidx.compose.ui.graphics.Brush r4 = r4.getBrush()     // Catch:{ all -> 0x0129 }
            r27 = r4
            if (r27 == 0) goto L_0x00b8
            androidx.compose.ui.text.TextStyle r0 = r1.style     // Catch:{ all -> 0x0073 }
            float r6 = r0.getAlpha()     // Catch:{ all -> 0x0073 }
            r11 = 64
            r12 = 0
            r10 = 0
            r4 = r15
            r5 = r27
            androidx.compose.ui.text.Paragraph.m6925painthn5TExg$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0073 }
            r6 = r15
            goto L_0x011e
        L_0x00b8:
            androidx.compose.ui.graphics.ColorProducer r4 = r1.overrideColor     // Catch:{ all -> 0x0129 }
            if (r4 == 0) goto L_0x00c1
            long r4 = r4.m5040invoke0d7_KjU()     // Catch:{ all -> 0x0073 }
            goto L_0x00c7
        L_0x00c1:
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion     // Catch:{ all -> 0x0129 }
            long r4 = r4.m4999getUnspecified0d7_KjU()     // Catch:{ all -> 0x0129 }
        L_0x00c7:
            r10 = r4
            r6 = 0
            androidx.compose.ui.graphics.Color$Companion r12 = androidx.compose.ui.graphics.Color.Companion     // Catch:{ all -> 0x0129 }
            long r16 = r12.m4999getUnspecified0d7_KjU()     // Catch:{ all -> 0x0129 }
            int r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            r16 = 1
            if (r12 == 0) goto L_0x00d8
            r6 = r16
            goto L_0x00d9
        L_0x00d8:
            r6 = r0
        L_0x00d9:
            if (r6 == 0) goto L_0x00de
            r17 = r4
            goto L_0x0104
        L_0x00de:
            androidx.compose.ui.text.TextStyle r6 = r1.style     // Catch:{ all -> 0x0129 }
            long r10 = r6.m7056getColor0d7_KjU()     // Catch:{ all -> 0x0129 }
            r6 = 0
            androidx.compose.ui.graphics.Color$Companion r12 = androidx.compose.ui.graphics.Color.Companion     // Catch:{ all -> 0x0129 }
            long r17 = r12.m4999getUnspecified0d7_KjU()     // Catch:{ all -> 0x0129 }
            int r12 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r12 == 0) goto L_0x00f1
            r0 = r16
        L_0x00f1:
            if (r0 == 0) goto L_0x00fc
            androidx.compose.ui.text.TextStyle r0 = r1.style     // Catch:{ all -> 0x0073 }
            long r10 = r0.m7056getColor0d7_KjU()     // Catch:{ all -> 0x0073 }
            r17 = r10
            goto L_0x0104
        L_0x00fc:
            androidx.compose.ui.graphics.Color$Companion r0 = androidx.compose.ui.graphics.Color.Companion     // Catch:{ all -> 0x0129 }
            long r10 = r0.m4989getBlack0d7_KjU()     // Catch:{ all -> 0x0129 }
            r17 = r10
        L_0x0104:
            r23 = 32
            r24 = 0
            r22 = 0
            r6 = r15
            r15 = r3
            r16 = r6
            r19 = r7
            r20 = r8
            r21 = r9
            androidx.compose.ui.text.Paragraph.m6923paintLG529CI$default(r15, r16, r17, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0127 }
        L_0x011e:
            if (r26 == 0) goto L_0x0123
            r6.restore()
        L_0x0123:
            return
        L_0x0127:
            r0 = move-exception
            goto L_0x012b
        L_0x0129:
            r0 = move-exception
            r6 = r15
        L_0x012b:
            if (r26 == 0) goto L_0x0130
            r6.restore()
        L_0x0130:
            throw r0
        L_0x0131:
            r0 = 0
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "no paragraph"
            java.lang.String r3 = r3.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextStringSimpleNode.draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope):void");
    }
}

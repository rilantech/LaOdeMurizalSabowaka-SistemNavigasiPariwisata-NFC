package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.foundation.text.modifiers.MinLinesConstrainer;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B`\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0016\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\u001eJ%\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00100\u001a\u00020\u001eH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J#\u00107\u001a\u00020\u000b2\u0006\u00103\u001a\u0002042\u0006\u00100\u001a\u00020\u001eø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109J\b\u0010:\u001a\u00020;H\u0002J\u000e\u0010<\u001a\u00020\r2\u0006\u00100\u001a\u00020\u001eJ\u001d\u0010=\u001a\u00020\r2\u0006\u00103\u001a\u000204H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u000e\u0010@\u001a\u00020\r2\u0006\u00100\u001a\u00020\u001eJ\u0010\u0010A\u001a\u00020+2\u0006\u00100\u001a\u00020\u001eH\u0002J-\u0010,\u001a\u00020#2\u0006\u00100\u001a\u00020\u001e2\u0006\u0010B\u001a\u0002042\u0006\u0010C\u001a\u000202H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJa\u0010F\u001a\u00020;2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ+\u0010I\u001a\u00020\u000b*\u0004\u0018\u00010#2\u0006\u00103\u001a\u0002042\u0006\u00100\u001a\u00020\u001eH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010KR\u000e\u0010\u0014\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u001f\u001a\u00020 X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010$\u001a\u0004\u0018\u00010#8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\u00020\tX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b-\u0010&\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006L"}, d2 = {"Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILjava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "cachedIntrinsicHeight", "cachedIntrinsicHeightInputWidth", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastDensity", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "J", "layoutCache", "Landroidx/compose/ui/text/TextLayoutResult;", "layoutOrNull", "getLayoutOrNull", "()Landroidx/compose/ui/text/TextLayoutResult;", "mMinLinesConstrainer", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "I", "paragraphIntrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "textLayoutResult", "getTextLayoutResult", "intrinsicHeight", "width", "layoutDirection", "layoutText", "Landroidx/compose/ui/text/MultiParagraph;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/MultiParagraph;", "layoutWithConstraints", "layoutWithConstraints-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Z", "markDirty", "", "maxIntrinsicWidth", "maxWidth", "maxWidth-BRTryo0", "(J)I", "minIntrinsicWidth", "setLayoutDirection", "finalConstraints", "multiParagraph", "textLayoutResult-VKLhPVY", "(Landroidx/compose/ui/unit/LayoutDirection;JLandroidx/compose/ui/text/MultiParagraph;)Landroidx/compose/ui/text/TextLayoutResult;", "update", "update-ZNqEYIc", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILjava/util/List;)V", "newLayoutWillBeDifferent", "newLayoutWillBeDifferent-VKLhPVY", "(Landroidx/compose/ui/text/TextLayoutResult;JLandroidx/compose/ui/unit/LayoutDirection;)Z", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MultiParagraphLayoutCache.kt */
public final class MultiParagraphLayoutCache {
    private int cachedIntrinsicHeight;
    private int cachedIntrinsicHeightInputWidth;
    private Density density;
    private FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection intrinsicsLayoutDirection;
    private long lastDensity;
    private TextLayoutResult layoutCache;
    private MinLinesConstrainer mMinLinesConstrainer;
    private int maxLines;
    private int minLines;
    private int overflow;
    private MultiParagraphIntrinsics paragraphIntrinsics;
    private List<AnnotatedString.Range<Placeholder>> placeholders;
    private boolean softWrap;
    private TextStyle style;
    private AnnotatedString text;

    public /* synthetic */ MultiParagraphLayoutCache(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, i, z, i2, i3, list);
    }

    private MultiParagraphLayoutCache(AnnotatedString text2, TextStyle style2, FontFamily.Resolver fontFamilyResolver2, int overflow2, boolean softWrap2, int maxLines2, int minLines2, List<AnnotatedString.Range<Placeholder>> placeholders2) {
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
        this.placeholders = placeholders2;
        this.lastDensity = InlineDensity.Companion.m999getUnspecifiedL26CHvs();
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MultiParagraphLayoutCache(androidx.compose.ui.text.AnnotatedString r13, androidx.compose.ui.text.TextStyle r14, androidx.compose.ui.text.font.FontFamily.Resolver r15, int r16, boolean r17, int r18, int r19, java.util.List r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 8
            if (r1 == 0) goto L_0x000e
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r1 = r1.m5756getClipgIe3tQ8()
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.font.FontFamily$Resolver, int, boolean, int, int, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final void setDensity$foundation_release(Density value) {
        Density localField = this.density;
        long newDensity = value != null ? InlineDensity.m991constructorimpl(value) : InlineDensity.Companion.m999getUnspecifiedL26CHvs();
        if (localField == null) {
            this.density = value;
            this.lastDensity = newDensity;
        } else if (value == null || !InlineDensity.m993equalsimpl0(this.lastDensity, newDensity)) {
            this.density = value;
            this.lastDensity = newDensity;
            markDirty();
        }
    }

    public final TextLayoutResult getTextLayoutResult() {
        TextLayoutResult textLayoutResult = this.layoutCache;
        if (textLayoutResult != null) {
            return textLayoutResult;
        }
        throw new IllegalStateException("You must call layoutWithConstraints first");
    }

    public final TextLayoutResult getLayoutOrNull() {
        return this.layoutCache;
    }

    /* renamed from: layoutWithConstraints-K40F9xA  reason: not valid java name */
    public final boolean m1009layoutWithConstraintsK40F9xA(long constraints, LayoutDirection layoutDirection) {
        long finalConstraints;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (this.minLines > 1) {
            MinLinesConstrainer.Companion companion = MinLinesConstrainer.Companion;
            MinLinesConstrainer minLinesConstrainer = this.mMinLinesConstrainer;
            TextStyle textStyle = this.style;
            Density density2 = this.density;
            Intrinsics.checkNotNull(density2);
            MinLinesConstrainer localMin = companion.from(minLinesConstrainer, layoutDirection, textStyle, density2, this.fontFamilyResolver);
            this.mMinLinesConstrainer = localMin;
            finalConstraints = localMin.m1003coerceMinLinesOh53vG4$foundation_release(constraints, this.minLines);
        } else {
            finalConstraints = constraints;
        }
        if (!m1007newLayoutWillBeDifferentVKLhPVY(this.layoutCache, finalConstraints, layoutDirection)) {
            TextLayoutResult textLayoutResult = this.layoutCache;
            Intrinsics.checkNotNull(textLayoutResult);
            if (Constraints.m5781equalsimpl0(finalConstraints, textLayoutResult.getLayoutInput().m5293getConstraintsmsEJaDk())) {
                return false;
            }
            TextLayoutResult textLayoutResult2 = this.layoutCache;
            Intrinsics.checkNotNull(textLayoutResult2);
            this.layoutCache = m1008textLayoutResultVKLhPVY(layoutDirection, finalConstraints, textLayoutResult2.getMultiParagraph());
            return true;
        }
        this.layoutCache = m1008textLayoutResultVKLhPVY(layoutDirection, finalConstraints, m1005layoutTextK40F9xA(finalConstraints, layoutDirection));
        return true;
    }

    /* renamed from: textLayoutResult-VKLhPVY  reason: not valid java name */
    private final TextLayoutResult m1008textLayoutResultVKLhPVY(LayoutDirection layoutDirection, long finalConstraints, MultiParagraph multiParagraph) {
        AnnotatedString annotatedString = this.text;
        TextStyle textStyle = this.style;
        List<AnnotatedString.Range<Placeholder>> list = this.placeholders;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        int i = this.maxLines;
        boolean z = this.softWrap;
        int i2 = this.overflow;
        Density density2 = this.density;
        Intrinsics.checkNotNull(density2);
        return new TextLayoutResult(new TextLayoutInput(annotatedString, textStyle, (List) list, i, z, i2, density2, layoutDirection, this.fontFamilyResolver, finalConstraints, (DefaultConstructorMarker) null), multiParagraph, ConstraintsKt.m5799constrain4WqzIAM(finalConstraints, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(multiParagraph.getWidth()), TextDelegateKt.ceilToIntPx(multiParagraph.getHeight()))), (DefaultConstructorMarker) null);
    }

    public final int intrinsicHeight(int width, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int localWidth = this.cachedIntrinsicHeightInputWidth;
        int localHeght = this.cachedIntrinsicHeight;
        if (width == localWidth && localWidth != -1) {
            return localHeght;
        }
        int result = TextDelegateKt.ceilToIntPx(m1005layoutTextK40F9xA(ConstraintsKt.Constraints(0, width, 0, Integer.MAX_VALUE), layoutDirection).getHeight());
        this.cachedIntrinsicHeightInputWidth = width;
        this.cachedIntrinsicHeight = result;
        return result;
    }

    /* renamed from: update-ZNqEYIc  reason: not valid java name */
    public final void m1010updateZNqEYIc(AnnotatedString text2, TextStyle style2, FontFamily.Resolver fontFamilyResolver2, int overflow2, boolean softWrap2, int maxLines2, int minLines2, List<AnnotatedString.Range<Placeholder>> placeholders2) {
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
        this.placeholders = placeholders2;
        markDirty();
    }

    private final MultiParagraphIntrinsics setLayoutDirection(LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics intrinsics;
        MultiParagraphIntrinsics localIntrinsics = this.paragraphIntrinsics;
        if (localIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || localIntrinsics.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            AnnotatedString annotatedString = this.text;
            TextStyle resolveDefaults = TextStyleKt.resolveDefaults(this.style, layoutDirection);
            Density density2 = this.density;
            Intrinsics.checkNotNull(density2);
            FontFamily.Resolver resolver = this.fontFamilyResolver;
            List<AnnotatedString.Range<Placeholder>> list = this.placeholders;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            intrinsics = new MultiParagraphIntrinsics(annotatedString, resolveDefaults, list, density2, resolver);
        } else {
            intrinsics = localIntrinsics;
        }
        this.paragraphIntrinsics = intrinsics;
        return intrinsics;
    }

    /* renamed from: layoutText-K40F9xA  reason: not valid java name */
    private final MultiParagraph m1005layoutTextK40F9xA(long constraints, LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics localParagraphIntrinsics = setLayoutDirection(layoutDirection);
        return new MultiParagraph(localParagraphIntrinsics, LayoutUtilsKt.m1000finalConstraintstfFHcEY(constraints, this.softWrap, this.overflow, localParagraphIntrinsics.getMaxIntrinsicWidth()), LayoutUtilsKt.m1001finalMaxLinesxdlQI24(this.softWrap, this.overflow, this.maxLines), TextOverflow.m5749equalsimpl0(this.overflow, TextOverflow.Companion.m5757getEllipsisgIe3tQ8()), (DefaultConstructorMarker) null);
    }

    /* renamed from: newLayoutWillBeDifferent-VKLhPVY  reason: not valid java name */
    private final boolean m1007newLayoutWillBeDifferentVKLhPVY(TextLayoutResult $this$newLayoutWillBeDifferent_u2dVKLhPVY, long constraints, LayoutDirection layoutDirection) {
        if ($this$newLayoutWillBeDifferent_u2dVKLhPVY == null || $this$newLayoutWillBeDifferent_u2dVKLhPVY.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts() || layoutDirection != $this$newLayoutWillBeDifferent_u2dVKLhPVY.getLayoutInput().getLayoutDirection()) {
            return true;
        }
        if (Constraints.m5781equalsimpl0(constraints, $this$newLayoutWillBeDifferent_u2dVKLhPVY.getLayoutInput().m5293getConstraintsmsEJaDk())) {
            return false;
        }
        if (Constraints.m5788getMaxWidthimpl(constraints) == Constraints.m5788getMaxWidthimpl($this$newLayoutWillBeDifferent_u2dVKLhPVY.getLayoutInput().m5293getConstraintsmsEJaDk()) && ((float) Constraints.m5787getMaxHeightimpl(constraints)) >= $this$newLayoutWillBeDifferent_u2dVKLhPVY.getMultiParagraph().getHeight() && !$this$newLayoutWillBeDifferent_u2dVKLhPVY.getMultiParagraph().getDidExceedMaxLines()) {
            return false;
        }
        return true;
    }

    /* renamed from: maxWidth-BRTryo0  reason: not valid java name */
    private final int m1006maxWidthBRTryo0(long constraints) {
        boolean z = this.softWrap;
        int i = this.overflow;
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.paragraphIntrinsics;
        Intrinsics.checkNotNull(multiParagraphIntrinsics);
        return LayoutUtilsKt.m1002finalMaxWidthtfFHcEY(constraints, z, i, multiParagraphIntrinsics.getMaxIntrinsicWidth());
    }

    private final void markDirty() {
        this.paragraphIntrinsics = null;
        this.layoutCache = null;
    }

    public final int maxIntrinsicWidth(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMaxIntrinsicWidth());
    }

    public final int minIntrinsicWidth(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMinIntrinsicWidth());
    }
}

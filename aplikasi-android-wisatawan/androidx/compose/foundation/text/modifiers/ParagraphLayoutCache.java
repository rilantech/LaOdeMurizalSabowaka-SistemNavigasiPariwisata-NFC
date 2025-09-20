package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.foundation.text.modifiers.MinLinesConstrainer;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphIntrinsicsKt;
import androidx.compose.ui.text.ParagraphKt;
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
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BH\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\rø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0016\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u001fJ%\u0010=\u001a\u0002012\u0006\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020\u001fH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J#\u0010A\u001a\u00020\u000b2\u0006\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020\u001fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\b\u0010D\u001a\u00020,H\u0002J\u000e\u0010E\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u001fJ\u000e\u0010F\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u001fJ%\u0010G\u001a\u00020\u000b2\u0006\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020\u001fH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010CJ\u0010\u0010I\u001a\u0002072\u0006\u0010<\u001a\u00020\u001fH\u0002J\b\u0010J\u001a\u0004\u0018\u00010KJK\u0010L\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010NR\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010 \u001a\u00020!X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\"R%\u0010#\u001a\u00020$X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,8@X\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0019\u0010\b\u001a\u00020\tX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u0019\u00108\u001a\u000209X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006O"}, d2 = {"Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "cachedIntrinsicHeight", "cachedIntrinsicHeightInputWidth", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "didOverflow", "getDidOverflow$foundation_release", "()Z", "setDidOverflow$foundation_release", "(Z)V", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastDensity", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "J", "layoutSize", "Landroidx/compose/ui/unit/IntSize;", "getLayoutSize-YbymL2g$foundation_release", "()J", "setLayoutSize-ozmzZPI$foundation_release", "(J)V", "mMinLinesConstrainer", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "observeFontChanges", "", "getObserveFontChanges$foundation_release", "()Lkotlin/Unit;", "I", "paragraph", "Landroidx/compose/ui/text/Paragraph;", "getParagraph$foundation_release", "()Landroidx/compose/ui/text/Paragraph;", "setParagraph$foundation_release", "(Landroidx/compose/ui/text/Paragraph;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "prevConstraints", "Landroidx/compose/ui/unit/Constraints;", "intrinsicHeight", "width", "layoutDirection", "layoutText", "constraints", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/Paragraph;", "layoutWithConstraints", "layoutWithConstraints-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Z", "markDirty", "maxIntrinsicWidth", "minIntrinsicWidth", "newLayoutWillBeDifferent", "newLayoutWillBeDifferent-K40F9xA", "setLayoutDirection", "slowCreateTextLayoutResultOrNull", "Landroidx/compose/ui/text/TextLayoutResult;", "update", "update-L6sJoHM", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZII)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ParagraphLayoutCache.kt */
public final class ParagraphLayoutCache {
    private int cachedIntrinsicHeight;
    private int cachedIntrinsicHeightInputWidth;
    private Density density;
    private boolean didOverflow;
    private FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection intrinsicsLayoutDirection;
    private long lastDensity;
    private long layoutSize;
    private MinLinesConstrainer mMinLinesConstrainer;
    private int maxLines;
    private int minLines;
    private int overflow;
    private Paragraph paragraph;
    private ParagraphIntrinsics paragraphIntrinsics;
    private long prevConstraints;
    private boolean softWrap;
    private TextStyle style;
    private String text;

    public /* synthetic */ ParagraphLayoutCache(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, resolver, i, z, i2, i3);
    }

    private ParagraphLayoutCache(String text2, TextStyle style2, FontFamily.Resolver fontFamilyResolver2, int overflow2, boolean softWrap2, int maxLines2, int minLines2) {
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
        this.lastDensity = InlineDensity.Companion.m999getUnspecifiedL26CHvs();
        this.layoutSize = IntSizeKt.IntSize(0, 0);
        this.prevConstraints = Constraints.Companion.m5796fixedJhjzzOo(0, 0);
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ParagraphLayoutCache(java.lang.String r11, androidx.compose.ui.text.TextStyle r12, androidx.compose.ui.text.font.FontFamily.Resolver r13, int r14, boolean r15, int r16, int r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r10 = this;
            r0 = r18 & 8
            if (r0 == 0) goto L_0x000c
            androidx.compose.ui.text.style.TextOverflow$Companion r0 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r0 = r0.m5756getClipgIe3tQ8()
            r5 = r0
            goto L_0x000d
        L_0x000c:
            r5 = r14
        L_0x000d:
            r0 = r18 & 16
            r1 = 1
            if (r0 == 0) goto L_0x0014
            r6 = r1
            goto L_0x0015
        L_0x0014:
            r6 = r15
        L_0x0015:
            r0 = r18 & 32
            if (r0 == 0) goto L_0x001e
            r0 = 2147483647(0x7fffffff, float:NaN)
            r7 = r0
            goto L_0x0020
        L_0x001e:
            r7 = r16
        L_0x0020:
            r0 = r18 & 64
            if (r0 == 0) goto L_0x0026
            r8 = r1
            goto L_0x0028
        L_0x0026:
            r8 = r17
        L_0x0028:
            r9 = 0
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.ParagraphLayoutCache.<init>(java.lang.String, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.font.FontFamily$Resolver, int, boolean, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

    public final Unit getObserveFontChanges$foundation_release() {
        ParagraphIntrinsics paragraphIntrinsics2 = this.paragraphIntrinsics;
        if (paragraphIntrinsics2 != null) {
            paragraphIntrinsics2.getHasStaleResolvedFonts();
        }
        return Unit.INSTANCE;
    }

    public final Paragraph getParagraph$foundation_release() {
        return this.paragraph;
    }

    public final void setParagraph$foundation_release(Paragraph paragraph2) {
        this.paragraph = paragraph2;
    }

    public final boolean getDidOverflow$foundation_release() {
        return this.didOverflow;
    }

    public final void setDidOverflow$foundation_release(boolean z) {
        this.didOverflow = z;
    }

    /* renamed from: getLayoutSize-YbymL2g$foundation_release  reason: not valid java name */
    public final long m1013getLayoutSizeYbymL2g$foundation_release() {
        return this.layoutSize;
    }

    /* renamed from: setLayoutSize-ozmzZPI$foundation_release  reason: not valid java name */
    public final void m1015setLayoutSizeozmzZPI$foundation_release(long j) {
        this.layoutSize = j;
    }

    /* renamed from: layoutWithConstraints-K40F9xA  reason: not valid java name */
    public final boolean m1014layoutWithConstraintsK40F9xA(long constraints, LayoutDirection layoutDirection) {
        long finalConstraints;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        boolean z = true;
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
        boolean z2 = false;
        if (!m1012newLayoutWillBeDifferentK40F9xA(finalConstraints, layoutDirection)) {
            if (!Constraints.m5781equalsimpl0(finalConstraints, this.prevConstraints)) {
                Paragraph localParagraph = this.paragraph;
                Intrinsics.checkNotNull(localParagraph);
                long localSize = ConstraintsKt.m5799constrain4WqzIAM(finalConstraints, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(localParagraph.getWidth()), TextDelegateKt.ceilToIntPx(localParagraph.getHeight())));
                this.layoutSize = localSize;
                if (TextOverflow.m5749equalsimpl0(this.overflow, TextOverflow.Companion.m5758getVisiblegIe3tQ8()) || (((float) IntSize.m6004getWidthimpl(localSize)) >= localParagraph.getWidth() && ((float) IntSize.m6003getHeightimpl(localSize)) >= localParagraph.getHeight())) {
                    z = false;
                }
                this.didOverflow = z;
            }
            return false;
        }
        Paragraph r0 = m1011layoutTextK40F9xA(finalConstraints, layoutDirection);
        Paragraph it = r0;
        this.prevConstraints = finalConstraints;
        long localSize2 = ConstraintsKt.m5799constrain4WqzIAM(finalConstraints, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(it.getWidth()), TextDelegateKt.ceilToIntPx(it.getHeight())));
        this.layoutSize = localSize2;
        if (!TextOverflow.m5749equalsimpl0(this.overflow, TextOverflow.Companion.m5758getVisiblegIe3tQ8()) && (((float) IntSize.m6004getWidthimpl(localSize2)) < it.getWidth() || ((float) IntSize.m6003getHeightimpl(localSize2)) < it.getHeight())) {
            z2 = true;
        }
        this.didOverflow = z2;
        this.paragraph = r0;
        return true;
    }

    public final int intrinsicHeight(int width, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int localWidth = this.cachedIntrinsicHeightInputWidth;
        int localHeght = this.cachedIntrinsicHeight;
        if (width == localWidth && localWidth != -1) {
            return localHeght;
        }
        int result = TextDelegateKt.ceilToIntPx(m1011layoutTextK40F9xA(ConstraintsKt.Constraints(0, width, 0, Integer.MAX_VALUE), layoutDirection).getHeight());
        this.cachedIntrinsicHeightInputWidth = width;
        this.cachedIntrinsicHeight = result;
        return result;
    }

    /* renamed from: update-L6sJoHM  reason: not valid java name */
    public final void m1016updateL6sJoHM(String text2, TextStyle style2, FontFamily.Resolver fontFamilyResolver2, int overflow2, boolean softWrap2, int maxLines2, int minLines2) {
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
        markDirty();
    }

    private final ParagraphIntrinsics setLayoutDirection(LayoutDirection layoutDirection) {
        ParagraphIntrinsics intrinsics;
        ParagraphIntrinsics localIntrinsics = this.paragraphIntrinsics;
        if (localIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || localIntrinsics.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            String str = this.text;
            TextStyle resolveDefaults = TextStyleKt.resolveDefaults(this.style, layoutDirection);
            Density density2 = this.density;
            Intrinsics.checkNotNull(density2);
            intrinsics = ParagraphIntrinsicsKt.ParagraphIntrinsics$default(str, resolveDefaults, (List) null, (List) null, density2, this.fontFamilyResolver, 12, (Object) null);
        } else {
            intrinsics = localIntrinsics;
        }
        this.paragraphIntrinsics = intrinsics;
        return intrinsics;
    }

    /* renamed from: layoutText-K40F9xA  reason: not valid java name */
    private final Paragraph m1011layoutTextK40F9xA(long constraints, LayoutDirection layoutDirection) {
        ParagraphIntrinsics localParagraphIntrinsics = setLayoutDirection(layoutDirection);
        return ParagraphKt.m5225Paragraph_EkL_Y(localParagraphIntrinsics, LayoutUtilsKt.m1000finalConstraintstfFHcEY(constraints, this.softWrap, this.overflow, localParagraphIntrinsics.getMaxIntrinsicWidth()), LayoutUtilsKt.m1001finalMaxLinesxdlQI24(this.softWrap, this.overflow, this.maxLines), TextOverflow.m5749equalsimpl0(this.overflow, TextOverflow.Companion.m5757getEllipsisgIe3tQ8()));
    }

    /* renamed from: newLayoutWillBeDifferent-K40F9xA  reason: not valid java name */
    private final boolean m1012newLayoutWillBeDifferentK40F9xA(long constraints, LayoutDirection layoutDirection) {
        ParagraphIntrinsics localParagraphIntrinsics;
        Paragraph localParagraph = this.paragraph;
        if (localParagraph == null || (localParagraphIntrinsics = this.paragraphIntrinsics) == null || localParagraphIntrinsics.getHasStaleResolvedFonts() || layoutDirection != this.intrinsicsLayoutDirection) {
            return true;
        }
        if (Constraints.m5781equalsimpl0(constraints, this.prevConstraints)) {
            return false;
        }
        if (Constraints.m5788getMaxWidthimpl(constraints) == Constraints.m5788getMaxWidthimpl(this.prevConstraints) && ((float) Constraints.m5787getMaxHeightimpl(constraints)) >= localParagraph.getHeight() && !localParagraph.getDidExceedMaxLines()) {
            return false;
        }
        return true;
    }

    private final void markDirty() {
        this.paragraph = null;
        this.paragraphIntrinsics = null;
        this.intrinsicsLayoutDirection = null;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
        this.prevConstraints = Constraints.Companion.m5796fixedJhjzzOo(0, 0);
        this.layoutSize = IntSizeKt.IntSize(0, 0);
        this.didOverflow = false;
    }

    public final TextLayoutResult slowCreateTextLayoutResultOrNull() {
        Density localDensity;
        LayoutDirection localLayoutDirection = this.intrinsicsLayoutDirection;
        if (localLayoutDirection == null || (localDensity = this.density) == null) {
            return null;
        }
        AnnotatedString annotatedString = new AnnotatedString(this.text, (List) null, (List) null, 6, (DefaultConstructorMarker) null);
        if (this.paragraph == null || this.paragraphIntrinsics == null) {
            return null;
        }
        long finalConstraints = Constraints.m5779copyZbe2FdA$default(this.prevConstraints, 0, 0, 0, 0, 10, (Object) null);
        TextLayoutInput textLayoutInput = new TextLayoutInput(annotatedString, this.style, CollectionsKt.emptyList(), this.maxLines, this.softWrap, this.overflow, localDensity, localLayoutDirection, this.fontFamilyResolver, finalConstraints, (DefaultConstructorMarker) null);
        MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(annotatedString, this.style, (List<AnnotatedString.Range<Placeholder>>) CollectionsKt.emptyList(), localDensity, this.fontFamilyResolver);
        return new TextLayoutResult(textLayoutInput, new MultiParagraph(multiParagraphIntrinsics, finalConstraints, this.maxLines, TextOverflow.m5749equalsimpl0(this.overflow, TextOverflow.Companion.m5757getEllipsisgIe3tQ8()), (DefaultConstructorMarker) null), this.layoutSize, (DefaultConstructorMarker) null);
    }

    public final int minIntrinsicWidth(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMinIntrinsicWidth());
    }

    public final int maxIntrinsicWidth(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMaxIntrinsicWidth());
    }
}

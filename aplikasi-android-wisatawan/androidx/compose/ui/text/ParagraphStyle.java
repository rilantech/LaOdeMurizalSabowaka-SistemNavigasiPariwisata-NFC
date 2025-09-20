package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B8\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tø\u0001\u0000¢\u0006\u0002\u0010\nBP\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fBh\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0014Br\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0017JC\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105J[\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107Js\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109J}\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010?\u001a\u00020@H\u0016J\u0014\u0010A\u001a\u00020\u00002\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0000H\u0007J\u0011\u0010B\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0000H\u0002J\b\u0010C\u001a\u00020DH\u0016R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\u001a\u001a\u00020\u0013X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001f\u0010 \u001a\u00020\u0011X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b!\u0010\u001cR\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001f\u0010+\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b,\u0010\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b1\u00102\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006E"}, d2 = {"Landroidx/compose/ui/text/ParagraphStyle;", "", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "Landroidx/compose/ui/unit/TextUnit;", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "platformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHyphens-EaSxIns", "()Landroidx/compose/ui/text/style/Hyphens;", "hyphensOrDefault", "getHyphensOrDefault-vmbZdU8$ui_text_release", "()I", "I", "getLineBreak-LgCVezo", "()Landroidx/compose/ui/text/style/LineBreak;", "lineBreakOrDefault", "getLineBreakOrDefault-rAG3T2k$ui_text_release", "getLineHeight-XSAIIZE", "()J", "J", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "textAlignOrDefault", "getTextAlignOrDefault-e0LSkKk$ui_text_release", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "getTextMotion", "()Landroidx/compose/ui/text/style/TextMotion;", "copy", "copy-Elsmlbk", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-xPh5V4g", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-ciSxzs0", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-NH1kkwU", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "equals", "", "other", "hashCode", "", "merge", "plus", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ParagraphStyle.kt */
public final class ParagraphStyle {
    public static final int $stable = 0;
    private final Hyphens hyphens;
    private final int hyphensOrDefault;
    private final LineBreak lineBreak;
    private final int lineBreakOrDefault;
    private final long lineHeight;
    private final LineHeightStyle lineHeightStyle;
    private final PlatformParagraphStyle platformStyle;
    private final TextAlign textAlign;
    private final int textAlignOrDefault;
    private final TextDirection textDirection;
    private final TextIndent textIndent;
    private final TextMotion textMotion;

    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2, TextMotion textMotion2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign2, textDirection2, j, textIndent2, platformParagraphStyle, lineHeightStyle2, lineBreak2, hyphens2, textMotion2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that do not take new stable parameters like LineBreak, Hyphens, TextMotion are deprecated. Please use the new stable constructors.")
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign2, textDirection2, j, textIndent2, platformParagraphStyle, lineHeightStyle2, lineBreak2, hyphens2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructors.")
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign2, textDirection2, j, textIndent2, platformParagraphStyle, lineHeightStyle2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign2, textDirection2, j, textIndent2);
    }

    private ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long lineHeight2, TextIndent textIndent2, PlatformParagraphStyle platformStyle2, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2, TextMotion textMotion2) {
        this.textAlign = textAlign2;
        this.textDirection = textDirection2;
        this.lineHeight = lineHeight2;
        this.textIndent = textIndent2;
        this.platformStyle = platformStyle2;
        this.lineHeightStyle = lineHeightStyle2;
        this.lineBreak = lineBreak2;
        this.hyphens = hyphens2;
        this.textMotion = textMotion2;
        this.textAlignOrDefault = textAlign2 != null ? textAlign2.m5706unboximpl() : TextAlign.Companion.m5712getStarte0LSkKk();
        this.lineBreakOrDefault = lineBreak2 != null ? lineBreak2.m5640unboximpl() : LineBreak.Companion.m5643getSimplerAG3T2k();
        this.hyphensOrDefault = hyphens2 != null ? hyphens2.m5625unboximpl() : Hyphens.Companion.m5627getNonevmbZdU8();
        if (!TextUnit.m6022equalsimpl0(lineHeight2, TextUnit.Companion.m6036getUnspecifiedXSAIIZE())) {
            if (!(TextUnit.m6025getValueimpl(lineHeight2) >= 0.0f)) {
                throw new IllegalStateException(("lineHeight can't be negative (" + TextUnit.m6025getValueimpl(lineHeight2) + ')').toString());
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2, TextMotion textMotion2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlign2, (i & 2) != 0 ? null : textDirection2, (i & 4) != 0 ? TextUnit.Companion.m6036getUnspecifiedXSAIIZE() : j, (i & 8) != 0 ? null : textIndent2, (i & 16) != 0 ? null : platformParagraphStyle, (i & 32) != 0 ? null : lineHeightStyle2, (i & 64) != 0 ? null : lineBreak2, (i & 128) != 0 ? null : hyphens2, (i & 256) != 0 ? null : textMotion2, (DefaultConstructorMarker) null);
    }

    /* renamed from: getTextAlign-buA522U  reason: not valid java name */
    public final TextAlign m5240getTextAlignbuA522U() {
        return this.textAlign;
    }

    /* renamed from: getTextDirection-mmuk1to  reason: not valid java name */
    public final TextDirection m5242getTextDirectionmmuk1to() {
        return this.textDirection;
    }

    /* renamed from: getLineHeight-XSAIIZE  reason: not valid java name */
    public final long m5239getLineHeightXSAIIZE() {
        return this.lineHeight;
    }

    public final TextIndent getTextIndent() {
        return this.textIndent;
    }

    public final PlatformParagraphStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.lineHeightStyle;
    }

    /* renamed from: getLineBreak-LgCVezo  reason: not valid java name */
    public final LineBreak m5237getLineBreakLgCVezo() {
        return this.lineBreak;
    }

    /* renamed from: getHyphens-EaSxIns  reason: not valid java name */
    public final Hyphens m5235getHyphensEaSxIns() {
        return this.hyphens;
    }

    public final TextMotion getTextMotion() {
        return this.textMotion;
    }

    /* renamed from: getTextAlignOrDefault-e0LSkKk$ui_text_release  reason: not valid java name */
    public final int m5241getTextAlignOrDefaulte0LSkKk$ui_text_release() {
        return this.textAlignOrDefault;
    }

    /* renamed from: getLineBreakOrDefault-rAG3T2k$ui_text_release  reason: not valid java name */
    public final int m5238getLineBreakOrDefaultrAG3T2k$ui_text_release() {
        return this.lineBreakOrDefault;
    }

    /* renamed from: getHyphensOrDefault-vmbZdU8$ui_text_release  reason: not valid java name */
    public final int m5236getHyphensOrDefaultvmbZdU8$ui_text_release() {
        return this.hyphensOrDefault;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlign2, (i & 2) != 0 ? null : textDirection2, (i & 4) != 0 ? TextUnit.Companion.m6036getUnspecifiedXSAIIZE() : j, (i & 8) != 0 ? null : textIndent2, (DefaultConstructorMarker) null);
    }

    private ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long lineHeight2, TextIndent textIndent2) {
        this(textAlign2, textDirection2, lineHeight2, textIndent2, (PlatformParagraphStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, (TextMotion) null, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlign2, (i & 2) != 0 ? null : textDirection2, (i & 4) != 0 ? TextUnit.Companion.m6036getUnspecifiedXSAIIZE() : j, (i & 8) != 0 ? null : textIndent2, (i & 16) != 0 ? null : platformParagraphStyle, (i & 32) != 0 ? null : lineHeightStyle2, (DefaultConstructorMarker) null);
    }

    private ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long lineHeight2, TextIndent textIndent2, PlatformParagraphStyle platformStyle2, LineHeightStyle lineHeightStyle2) {
        this(textAlign2, textDirection2, lineHeight2, textIndent2, platformStyle2, lineHeightStyle2, (LineBreak) null, (Hyphens) null, (TextMotion) null, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlign2, (i & 2) != 0 ? null : textDirection2, (i & 4) != 0 ? TextUnit.Companion.m6036getUnspecifiedXSAIIZE() : j, (i & 8) != 0 ? null : textIndent2, (i & 16) != 0 ? null : platformParagraphStyle, (i & 32) != 0 ? null : lineHeightStyle2, (i & 64) != 0 ? null : lineBreak2, (i & 128) != 0 ? null : hyphens2, (DefaultConstructorMarker) null);
    }

    private ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long lineHeight2, TextIndent textIndent2, PlatformParagraphStyle platformStyle2, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2) {
        this(textAlign2, textDirection2, lineHeight2, textIndent2, platformStyle2, lineHeightStyle2, lineBreak2, hyphens2, (TextMotion) null, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ParagraphStyle merge$default(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            paragraphStyle2 = null;
        }
        return paragraphStyle.merge(paragraphStyle2);
    }

    public final ParagraphStyle merge(ParagraphStyle other) {
        if (other == null) {
            return this;
        }
        return ParagraphStyleKt.m5243fastMergeHtYhynw(this, other.textAlign, other.textDirection, other.lineHeight, other.textIndent, other.platformStyle, other.lineHeightStyle, other.lineBreak, other.hyphens, other.textMotion);
    }

    public final ParagraphStyle plus(ParagraphStyle other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return merge(other);
    }

    /* renamed from: copy-Elsmlbk$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m5227copyElsmlbk$default(ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, int i, Object obj) {
        TextDirection textDirection3;
        long j2;
        TextIndent textIndent3;
        if ((i & 1) != 0) {
            textAlign2 = paragraphStyle.textAlign;
        }
        if ((i & 2) != 0) {
            textDirection3 = paragraphStyle.textDirection;
        } else {
            textDirection3 = textDirection2;
        }
        if ((i & 4) != 0) {
            j2 = paragraphStyle.lineHeight;
        } else {
            j2 = j;
        }
        if ((i & 8) != 0) {
            textIndent3 = paragraphStyle.textIndent;
        } else {
            textIndent3 = textIndent2;
        }
        return paragraphStyle.m5231copyElsmlbk(textAlign2, textDirection3, j2, textIndent3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-Elsmlbk  reason: not valid java name */
    public final /* synthetic */ ParagraphStyle m5231copyElsmlbk(TextAlign textAlign2, TextDirection textDirection2, long lineHeight2, TextIndent textIndent2) {
        return new ParagraphStyle(textAlign2, textDirection2, lineHeight2, textIndent2, this.platformStyle, this.lineHeightStyle, this.lineBreak, this.hyphens, this.textMotion, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-xPh5V4g$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m5230copyxPh5V4g$default(ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, int i, Object obj) {
        TextDirection textDirection3;
        long j2;
        TextIndent textIndent3;
        PlatformParagraphStyle platformParagraphStyle2;
        LineHeightStyle lineHeightStyle3;
        if ((i & 1) != 0) {
            textAlign2 = paragraphStyle.textAlign;
        }
        if ((i & 2) != 0) {
            textDirection3 = paragraphStyle.textDirection;
        } else {
            textDirection3 = textDirection2;
        }
        if ((i & 4) != 0) {
            j2 = paragraphStyle.lineHeight;
        } else {
            j2 = j;
        }
        if ((i & 8) != 0) {
            textIndent3 = paragraphStyle.textIndent;
        } else {
            textIndent3 = textIndent2;
        }
        if ((i & 16) != 0) {
            platformParagraphStyle2 = paragraphStyle.platformStyle;
        } else {
            platformParagraphStyle2 = platformParagraphStyle;
        }
        if ((i & 32) != 0) {
            lineHeightStyle3 = paragraphStyle.lineHeightStyle;
        } else {
            lineHeightStyle3 = lineHeightStyle2;
        }
        return paragraphStyle.m5234copyxPh5V4g(textAlign2, textDirection3, j2, textIndent3, platformParagraphStyle2, lineHeightStyle3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-xPh5V4g  reason: not valid java name */
    public final /* synthetic */ ParagraphStyle m5234copyxPh5V4g(TextAlign textAlign2, TextDirection textDirection2, long lineHeight2, TextIndent textIndent2, PlatformParagraphStyle platformStyle2, LineHeightStyle lineHeightStyle2) {
        return new ParagraphStyle(textAlign2, textDirection2, lineHeight2, textIndent2, platformStyle2, lineHeightStyle2, this.lineBreak, this.hyphens, this.textMotion, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-ciSxzs0$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m5229copyciSxzs0$default(ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2, int i, Object obj) {
        TextAlign textAlign3;
        TextDirection textDirection3;
        long j2;
        TextIndent textIndent3;
        PlatformParagraphStyle platformParagraphStyle2;
        LineHeightStyle lineHeightStyle3;
        LineBreak lineBreak3;
        Hyphens hyphens3;
        ParagraphStyle paragraphStyle2 = paragraphStyle;
        int i2 = i;
        if ((i2 & 1) != 0) {
            textAlign3 = paragraphStyle2.textAlign;
        } else {
            textAlign3 = textAlign2;
        }
        if ((i2 & 2) != 0) {
            textDirection3 = paragraphStyle2.textDirection;
        } else {
            textDirection3 = textDirection2;
        }
        if ((i2 & 4) != 0) {
            j2 = paragraphStyle2.lineHeight;
        } else {
            j2 = j;
        }
        if ((i2 & 8) != 0) {
            textIndent3 = paragraphStyle2.textIndent;
        } else {
            textIndent3 = textIndent2;
        }
        if ((i2 & 16) != 0) {
            platformParagraphStyle2 = paragraphStyle2.platformStyle;
        } else {
            platformParagraphStyle2 = platformParagraphStyle;
        }
        if ((i2 & 32) != 0) {
            lineHeightStyle3 = paragraphStyle2.lineHeightStyle;
        } else {
            lineHeightStyle3 = lineHeightStyle2;
        }
        if ((i2 & 64) != 0) {
            lineBreak3 = paragraphStyle2.lineBreak;
        } else {
            lineBreak3 = lineBreak2;
        }
        if ((i2 & 128) != 0) {
            hyphens3 = paragraphStyle2.hyphens;
        } else {
            hyphens3 = hyphens2;
        }
        return paragraphStyle.m5233copyciSxzs0(textAlign3, textDirection3, j2, textIndent3, platformParagraphStyle2, lineHeightStyle3, lineBreak3, hyphens3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that do not take new stable parameters like LineBreak, Hyphens, TextMotion are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-ciSxzs0  reason: not valid java name */
    public final /* synthetic */ ParagraphStyle m5233copyciSxzs0(TextAlign textAlign2, TextDirection textDirection2, long lineHeight2, TextIndent textIndent2, PlatformParagraphStyle platformStyle2, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2) {
        return new ParagraphStyle(textAlign2, textDirection2, lineHeight2, textIndent2, platformStyle2, lineHeightStyle2, lineBreak2, hyphens2, this.textMotion, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-NH1kkwU$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m5228copyNH1kkwU$default(ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2, TextMotion textMotion2, int i, Object obj) {
        TextAlign textAlign3;
        TextDirection textDirection3;
        long j2;
        TextIndent textIndent3;
        PlatformParagraphStyle platformParagraphStyle2;
        LineHeightStyle lineHeightStyle3;
        LineBreak lineBreak3;
        Hyphens hyphens3;
        TextMotion textMotion3;
        ParagraphStyle paragraphStyle2 = paragraphStyle;
        int i2 = i;
        if ((i2 & 1) != 0) {
            textAlign3 = paragraphStyle2.textAlign;
        } else {
            textAlign3 = textAlign2;
        }
        if ((i2 & 2) != 0) {
            textDirection3 = paragraphStyle2.textDirection;
        } else {
            textDirection3 = textDirection2;
        }
        if ((i2 & 4) != 0) {
            j2 = paragraphStyle2.lineHeight;
        } else {
            j2 = j;
        }
        if ((i2 & 8) != 0) {
            textIndent3 = paragraphStyle2.textIndent;
        } else {
            textIndent3 = textIndent2;
        }
        if ((i2 & 16) != 0) {
            platformParagraphStyle2 = paragraphStyle2.platformStyle;
        } else {
            platformParagraphStyle2 = platformParagraphStyle;
        }
        if ((i2 & 32) != 0) {
            lineHeightStyle3 = paragraphStyle2.lineHeightStyle;
        } else {
            lineHeightStyle3 = lineHeightStyle2;
        }
        if ((i2 & 64) != 0) {
            lineBreak3 = paragraphStyle2.lineBreak;
        } else {
            lineBreak3 = lineBreak2;
        }
        if ((i2 & 128) != 0) {
            hyphens3 = paragraphStyle2.hyphens;
        } else {
            hyphens3 = hyphens2;
        }
        if ((i2 & 256) != 0) {
            textMotion3 = paragraphStyle2.textMotion;
        } else {
            textMotion3 = textMotion2;
        }
        return paragraphStyle.m5232copyNH1kkwU(textAlign3, textDirection3, j2, textIndent3, platformParagraphStyle2, lineHeightStyle3, lineBreak3, hyphens3, textMotion3);
    }

    /* renamed from: copy-NH1kkwU  reason: not valid java name */
    public final ParagraphStyle m5232copyNH1kkwU(TextAlign textAlign2, TextDirection textDirection2, long lineHeight2, TextIndent textIndent2, PlatformParagraphStyle platformStyle2, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2, TextMotion textMotion2) {
        return new ParagraphStyle(textAlign2, textDirection2, lineHeight2, textIndent2, platformStyle2, lineHeightStyle2, lineBreak2, hyphens2, textMotion2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ParagraphStyle) && Intrinsics.areEqual((Object) this.textAlign, (Object) ((ParagraphStyle) other).textAlign) && Intrinsics.areEqual((Object) this.textDirection, (Object) ((ParagraphStyle) other).textDirection) && TextUnit.m6022equalsimpl0(this.lineHeight, ((ParagraphStyle) other).lineHeight) && Intrinsics.areEqual((Object) this.textIndent, (Object) ((ParagraphStyle) other).textIndent) && Intrinsics.areEqual((Object) this.platformStyle, (Object) ((ParagraphStyle) other).platformStyle) && Intrinsics.areEqual((Object) this.lineHeightStyle, (Object) ((ParagraphStyle) other).lineHeightStyle) && Intrinsics.areEqual((Object) this.lineBreak, (Object) ((ParagraphStyle) other).lineBreak) && Intrinsics.areEqual((Object) this.hyphens, (Object) ((ParagraphStyle) other).hyphens) && Intrinsics.areEqual((Object) this.textMotion, (Object) ((ParagraphStyle) other).textMotion)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        TextAlign textAlign2 = this.textAlign;
        int i = 0;
        int r2 = (textAlign2 != null ? TextAlign.m5704hashCodeimpl(textAlign2.m5706unboximpl()) : 0) * 31;
        TextDirection textDirection2 = this.textDirection;
        int result = (((r2 + (textDirection2 != null ? TextDirection.m5717hashCodeimpl(textDirection2.m5719unboximpl()) : 0)) * 31) + TextUnit.m6026hashCodeimpl(this.lineHeight)) * 31;
        TextIndent textIndent2 = this.textIndent;
        int result2 = (result + (textIndent2 != null ? textIndent2.hashCode() : 0)) * 31;
        PlatformParagraphStyle platformParagraphStyle = this.platformStyle;
        int result3 = (result2 + (platformParagraphStyle != null ? platformParagraphStyle.hashCode() : 0)) * 31;
        LineHeightStyle lineHeightStyle2 = this.lineHeightStyle;
        int result4 = (result3 + (lineHeightStyle2 != null ? lineHeightStyle2.hashCode() : 0)) * 31;
        LineBreak lineBreak2 = this.lineBreak;
        int result5 = (result4 + (lineBreak2 != null ? LineBreak.m5638hashCodeimpl(lineBreak2.m5640unboximpl()) : 0)) * 31;
        Hyphens hyphens2 = this.hyphens;
        int result6 = (result5 + (hyphens2 != null ? Hyphens.m5623hashCodeimpl(hyphens2.m5625unboximpl()) : 0)) * 31;
        TextMotion textMotion2 = this.textMotion;
        if (textMotion2 != null) {
            i = textMotion2.hashCode();
        }
        return result6 + i;
    }

    public String toString() {
        return "ParagraphStyle(textAlign=" + this.textAlign + ", textDirection=" + this.textDirection + ", lineHeight=" + TextUnit.m6032toStringimpl(this.lineHeight) + ", textIndent=" + this.textIndent + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + this.lineHeightStyle + ", lineBreak=" + this.lineBreak + ", hyphens=" + this.hyphens + ", textMotion=" + this.textMotion + ')';
    }
}

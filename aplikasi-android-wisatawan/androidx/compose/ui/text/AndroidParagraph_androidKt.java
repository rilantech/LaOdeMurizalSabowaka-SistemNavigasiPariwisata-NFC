package androidx.compose.ui.text;

import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001d\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\t\u001a\u001d\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\r\u001a\u001d\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0011\u001a\u001d\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0015\u001a\u001d\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0019\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001bH\u0002\u001a\u0014\u0010\u001c\u001a\u00020\u0006*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-AMY3VfE", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-u6PBz3U", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutHyphenationFrequency-0_XeFpE", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-4a2g8L8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-gvcdTPQ", "attachIndentationFixSpan", "", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidParagraph.android.kt */
public final class AndroidParagraph_androidKt {
    /* access modifiers changed from: private */
    /* renamed from: toLayoutAlign-AMY3VfE  reason: not valid java name */
    public static final int m5190toLayoutAlignAMY3VfE(TextAlign align) {
        if (align == null ? false : TextAlign.m5703equalsimpl0(align.m5706unboximpl(), TextAlign.Companion.m5710getLefte0LSkKk())) {
            return 3;
        }
        if (align == null ? false : TextAlign.m5703equalsimpl0(align.m5706unboximpl(), TextAlign.Companion.m5711getRighte0LSkKk())) {
            return 4;
        }
        if (align == null ? false : TextAlign.m5703equalsimpl0(align.m5706unboximpl(), TextAlign.Companion.m5707getCentere0LSkKk())) {
            return 2;
        }
        if (align == null ? false : TextAlign.m5703equalsimpl0(align.m5706unboximpl(), TextAlign.Companion.m5712getStarte0LSkKk())) {
            return 0;
        }
        if (align == null ? false : TextAlign.m5703equalsimpl0(align.m5706unboximpl(), TextAlign.Companion.m5708getEnde0LSkKk())) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutHyphenationFrequency-0_XeFpE  reason: not valid java name */
    public static final int m5192toLayoutHyphenationFrequency0_XeFpE(Hyphens hyphens) {
        if (hyphens == null ? false : Hyphens.m5622equalsimpl0(hyphens.m5625unboximpl(), Hyphens.Companion.m5626getAutovmbZdU8())) {
            return 4;
        }
        int r0 = Hyphens.Companion.m5627getNonevmbZdU8();
        if (hyphens == null) {
            return 0;
        }
        Hyphens.m5622equalsimpl0(hyphens.m5625unboximpl(), r0);
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-u6PBz3U  reason: not valid java name */
    public static final int m5191toLayoutBreakStrategyu6PBz3U(LineBreak.Strategy breakStrategy) {
        if (breakStrategy == null ? false : LineBreak.Strategy.m5647equalsimpl0(breakStrategy.m5650unboximpl(), LineBreak.Strategy.Companion.m5653getSimplefcGXIks())) {
            return 0;
        }
        if (breakStrategy == null ? false : LineBreak.Strategy.m5647equalsimpl0(breakStrategy.m5650unboximpl(), LineBreak.Strategy.Companion.m5652getHighQualityfcGXIks())) {
            return 1;
        }
        if (breakStrategy == null ? false : LineBreak.Strategy.m5647equalsimpl0(breakStrategy.m5650unboximpl(), LineBreak.Strategy.Companion.m5651getBalancedfcGXIks())) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakStyle-4a2g8L8  reason: not valid java name */
    public static final int m5193toLayoutLineBreakStyle4a2g8L8(LineBreak.Strictness lineBreakStrictness) {
        if (lineBreakStrictness == null ? false : LineBreak.Strictness.m5657equalsimpl0(lineBreakStrictness.m5660unboximpl(), LineBreak.Strictness.Companion.m5661getDefaultusljTpc())) {
            return 0;
        }
        if (lineBreakStrictness == null ? false : LineBreak.Strictness.m5657equalsimpl0(lineBreakStrictness.m5660unboximpl(), LineBreak.Strictness.Companion.m5662getLooseusljTpc())) {
            return 1;
        }
        if (lineBreakStrictness == null ? false : LineBreak.Strictness.m5657equalsimpl0(lineBreakStrictness.m5660unboximpl(), LineBreak.Strictness.Companion.m5663getNormalusljTpc())) {
            return 2;
        }
        if (lineBreakStrictness == null ? false : LineBreak.Strictness.m5657equalsimpl0(lineBreakStrictness.m5660unboximpl(), LineBreak.Strictness.Companion.m5664getStrictusljTpc())) {
            return 3;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-gvcdTPQ  reason: not valid java name */
    public static final int m5194toLayoutLineBreakWordStylegvcdTPQ(LineBreak.WordBreak lineBreakWordStyle) {
        if (lineBreakWordStyle == null ? false : LineBreak.WordBreak.m5668equalsimpl0(lineBreakWordStyle.m5671unboximpl(), LineBreak.WordBreak.Companion.m5672getDefaultjp8hJ3c())) {
            return 0;
        }
        if (lineBreakWordStyle == null ? false : LineBreak.WordBreak.m5668equalsimpl0(lineBreakWordStyle.m5671unboximpl(), LineBreak.WordBreak.Companion.m5673getPhrasejp8hJ3c())) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout $this$numberOfLinesThatFitMaxHeight, int maxHeight) {
        int lineCount = $this$numberOfLinesThatFitMaxHeight.getLineCount();
        for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
            if ($this$numberOfLinesThatFitMaxHeight.getLineBottom(lineIndex) > ((float) maxHeight)) {
                return lineIndex;
            }
        }
        return $this$numberOfLinesThatFitMaxHeight.getLineCount();
    }

    /* access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean ellipsis) {
        TextStyle $this$shouldAttachIndentationFixSpan_u24lambda_u240 = textStyle;
        if (!ellipsis || TextUnit.m6022equalsimpl0($this$shouldAttachIndentationFixSpan_u24lambda_u240.m5351getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m6022equalsimpl0($this$shouldAttachIndentationFixSpan_u24lambda_u240.m5351getLetterSpacingXSAIIZE(), TextUnit.Companion.m6036getUnspecifiedXSAIIZE()) || $this$shouldAttachIndentationFixSpan_u24lambda_u240.m5354getTextAlignbuA522U() == null) {
            return false;
        }
        TextAlign r3 = $this$shouldAttachIndentationFixSpan_u24lambda_u240.m5354getTextAlignbuA522U();
        if (r3 == null ? false : TextAlign.m5703equalsimpl0(r3.m5706unboximpl(), TextAlign.Companion.m5712getStarte0LSkKk())) {
            return false;
        }
        TextAlign r32 = $this$shouldAttachIndentationFixSpan_u24lambda_u240.m5354getTextAlignbuA522U();
        if (!(r32 == null ? false : TextAlign.m5703equalsimpl0(r32.m5706unboximpl(), TextAlign.Companion.m5709getJustifye0LSkKk()))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence $this$attachIndentationFixSpan) {
        if ($this$attachIndentationFixSpan.length() == 0) {
            return $this$attachIndentationFixSpan;
        }
        Spannable spannable = $this$attachIndentationFixSpan instanceof Spannable ? (Spannable) $this$attachIndentationFixSpan : new SpannableString($this$attachIndentationFixSpan);
        SpannableExtensions_androidKt.setSpan(spannable, new IndentationFixSpan(), spannable.length() - 1, spannable.length() - 1);
        return spannable;
    }
}

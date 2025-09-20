package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.emoji2.text.EmojiSpan;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a,\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a(\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00190\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\"!\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"!\u0010\u0007\u001a\u00020\u0001*\u00020\b8BX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"spanUnit", "", "Landroidx/compose/ui/unit/TextUnit;", "getSpanUnit--R2X_6o$annotations", "(J)V", "getSpanUnit--R2X_6o", "(J)I", "spanVerticalAlign", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "getSpanVerticalAlign-do9X-Gg$annotations", "(I)V", "getSpanVerticalAlign-do9X-Gg", "(I)I", "setPlaceholder", "", "Landroid/text/Spannable;", "placeholder", "Landroidx/compose/ui/text/Placeholder;", "start", "end", "density", "Landroidx/compose/ui/unit/Density;", "setPlaceholders", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PlaceholderExtensions.android.kt */
public final class PlaceholderExtensions_androidKt {
    /* renamed from: getSpanUnit--R2X_6o$annotations  reason: not valid java name */
    private static /* synthetic */ void m7293getSpanUnitR2X_6o$annotations(long j) {
    }

    /* renamed from: getSpanVerticalAlign-do9X-Gg$annotations  reason: not valid java name */
    private static /* synthetic */ void m7295getSpanVerticalAligndo9XGg$annotations(int i) {
    }

    public static final void setPlaceholders(Spannable $this$setPlaceholders, List<AnnotatedString.Range<Placeholder>> placeholders, Density density) {
        Intrinsics.checkNotNullParameter($this$setPlaceholders, "<this>");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        List $this$fastForEach$iv = placeholders;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            AnnotatedString.Range it = $this$fastForEach$iv.get(index$iv);
            setPlaceholder($this$setPlaceholders, (Placeholder) it.component1(), it.component2(), it.component3(), density);
        }
    }

    private static final void setPlaceholder(Spannable $this$setPlaceholder, Placeholder placeholder, int start, int end, Density density) {
        Object[] $this$forEach$iv = $this$setPlaceholder.getSpans(start, end, EmojiSpan.class);
        Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "getSpans(start, end, EmojiSpan::class.java)");
        for (Object element$iv : $this$forEach$iv) {
            $this$setPlaceholder.removeSpan((EmojiSpan) element$iv);
        }
        Placeholder $this$setPlaceholder_u24lambda_u242 = placeholder;
        SpannableExtensions_androidKt.setSpan($this$setPlaceholder, new PlaceholderSpan(TextUnit.m7735getValueimpl($this$setPlaceholder_u24lambda_u242.m6958getWidthXSAIIZE()), m7292getSpanUnitR2X_6o($this$setPlaceholder_u24lambda_u242.m6958getWidthXSAIIZE()), TextUnit.m7735getValueimpl($this$setPlaceholder_u24lambda_u242.m6956getHeightXSAIIZE()), m7292getSpanUnitR2X_6o($this$setPlaceholder_u24lambda_u242.m6956getHeightXSAIIZE()), density.getDensity() * density.getFontScale(), m7294getSpanVerticalAligndo9XGg($this$setPlaceholder_u24lambda_u242.m6957getPlaceholderVerticalAlignJ6kI3mc())), start, end);
    }

    /* renamed from: getSpanUnit--R2X_6o  reason: not valid java name */
    private static final int m7292getSpanUnitR2X_6o(long $this$spanUnit) {
        long r0 = TextUnit.m7734getTypeUIouoOA($this$spanUnit);
        if (TextUnitType.m7763equalsimpl0(r0, TextUnitType.Companion.m7768getSpUIouoOA())) {
            return 0;
        }
        if (TextUnitType.m7763equalsimpl0(r0, TextUnitType.Companion.m7767getEmUIouoOA())) {
            return 1;
        }
        return 2;
    }

    /* renamed from: getSpanVerticalAlign-do9X-Gg  reason: not valid java name */
    private static final int m7294getSpanVerticalAligndo9XGg(int $this$spanVerticalAlign) {
        if (PlaceholderVerticalAlign.m6962equalsimpl0($this$spanVerticalAlign, PlaceholderVerticalAlign.Companion.m6966getAboveBaselineJ6kI3mc())) {
            return 0;
        }
        if (PlaceholderVerticalAlign.m6962equalsimpl0($this$spanVerticalAlign, PlaceholderVerticalAlign.Companion.m6972getTopJ6kI3mc())) {
            return 1;
        }
        if (PlaceholderVerticalAlign.m6962equalsimpl0($this$spanVerticalAlign, PlaceholderVerticalAlign.Companion.m6967getBottomJ6kI3mc())) {
            return 2;
        }
        if (PlaceholderVerticalAlign.m6962equalsimpl0($this$spanVerticalAlign, PlaceholderVerticalAlign.Companion.m6968getCenterJ6kI3mc())) {
            return 3;
        }
        if (PlaceholderVerticalAlign.m6962equalsimpl0($this$spanVerticalAlign, PlaceholderVerticalAlign.Companion.m6971getTextTopJ6kI3mc())) {
            return 4;
        }
        if (PlaceholderVerticalAlign.m6962equalsimpl0($this$spanVerticalAlign, PlaceholderVerticalAlign.Companion.m6969getTextBottomJ6kI3mc())) {
            return 5;
        }
        if (PlaceholderVerticalAlign.m6962equalsimpl0($this$spanVerticalAlign, PlaceholderVerticalAlign.Companion.m6970getTextCenterJ6kI3mc())) {
            return 6;
        }
        throw new IllegalStateException("Invalid PlaceholderVerticalAlign".toString());
    }
}

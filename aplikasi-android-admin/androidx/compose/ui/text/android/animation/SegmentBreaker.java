package androidx.compose.ui.text.android.animation;

import android.text.Layout;
import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.android.LayoutCompatKt;
import androidx.compose.ui.text.android.LayoutHelper;
import java.text.Bidi;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/android/animation/SegmentBreaker;", "", "()V", "breakInWords", "", "", "layoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "breakOffsets", "segmentType", "Landroidx/compose/ui/text/android/animation/SegmentType;", "breakSegmentWithChar", "Landroidx/compose/ui/text/android/animation/Segment;", "dropSpaces", "", "breakSegmentWithDocument", "breakSegmentWithLine", "breakSegmentWithParagraph", "breakSegmentWithWord", "breakSegments", "breakWithBreakIterator", "text", "", "breaker", "Ljava/text/BreakIterator;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SegmentBreaker.kt */
public final class SegmentBreaker {
    public static final SegmentBreaker INSTANCE = new SegmentBreaker();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SegmentBreaker.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SegmentType.values().length];
            try {
                iArr[SegmentType.Document.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SegmentType.Paragraph.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SegmentType.Line.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SegmentType.Word.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[SegmentType.Character.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SegmentBreaker() {
    }

    private final List<Integer> breakInWords(LayoutHelper layoutHelper) {
        CharSequence text = layoutHelper.getLayout().getText();
        Intrinsics.checkNotNullExpressionValue(text, "text");
        BreakIterator lineInstance = BreakIterator.getLineInstance(Locale.getDefault());
        Intrinsics.checkNotNullExpressionValue(lineInstance, "getLineInstance(Locale.getDefault())");
        List breakWithBreakIterator = breakWithBreakIterator(text, lineInstance);
        TreeSet set = new TreeSet();
        TreeSet $this$breakInWords_u24lambda_u241 = set;
        List $this$fastForEach$iv = breakWithBreakIterator;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            $this$breakInWords_u24lambda_u241.add(Integer.valueOf($this$fastForEach$iv.get(index$iv).intValue()));
        }
        int paragraphCount = layoutHelper.getParagraphCount();
        for (int paraIndex = 0; paraIndex < paragraphCount; paraIndex++) {
            Bidi bidi = layoutHelper.analyzeBidi(paraIndex);
            if (bidi != null) {
                int paragraphStart = layoutHelper.getParagraphStart(paraIndex);
                int runCount = bidi.getRunCount();
                for (int i = 0; i < runCount; i++) {
                    set.add(Integer.valueOf(bidi.getRunStart(i) + paragraphStart));
                }
            }
        }
        return CollectionsKt.toList(set);
    }

    private final List<Integer> breakWithBreakIterator(CharSequence text, BreakIterator breaker) {
        CharSequenceCharacterIterator iter = new CharSequenceCharacterIterator(text, 0, text.length());
        List res = CollectionsKt.mutableListOf(0);
        breaker.setText(iter);
        while (breaker.next() != -1) {
            res.add(Integer.valueOf(breaker.current()));
        }
        return res;
    }

    public final List<Integer> breakOffsets(LayoutHelper layoutHelper, SegmentType segmentType) {
        Intrinsics.checkNotNullParameter(layoutHelper, "layoutHelper");
        Intrinsics.checkNotNullParameter(segmentType, "segmentType");
        Layout layout = layoutHelper.getLayout();
        CharSequence text = layout.getText();
        switch (WhenMappings.$EnumSwitchMapping$0[segmentType.ordinal()]) {
            case 1:
                return CollectionsKt.listOf(0, Integer.valueOf(text.length()));
            case 2:
                List mutableListOf = CollectionsKt.mutableListOf(0);
                List it = mutableListOf;
                int paragraphCount = layoutHelper.getParagraphCount();
                for (int i = 0; i < paragraphCount; i++) {
                    it.add(Integer.valueOf(layoutHelper.getParagraphEnd(i)));
                }
                return mutableListOf;
            case 3:
                List mutableListOf2 = CollectionsKt.mutableListOf(0);
                List it2 = mutableListOf2;
                int lineCount = layout.getLineCount();
                for (int i2 = 0; i2 < lineCount; i2++) {
                    it2.add(Integer.valueOf(layout.getLineEnd(i2)));
                }
                return mutableListOf2;
            case 4:
                return breakInWords(layoutHelper);
            case 5:
                Intrinsics.checkNotNullExpressionValue(text, "text");
                BreakIterator characterInstance = BreakIterator.getCharacterInstance(Locale.getDefault());
                Intrinsics.checkNotNullExpressionValue(characterInstance, "getCharacterInstance(Locale.getDefault())");
                return breakWithBreakIterator(text, characterInstance);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final List<Segment> breakSegments(LayoutHelper layoutHelper, SegmentType segmentType, boolean dropSpaces) {
        Intrinsics.checkNotNullParameter(layoutHelper, "layoutHelper");
        Intrinsics.checkNotNullParameter(segmentType, "segmentType");
        switch (WhenMappings.$EnumSwitchMapping$0[segmentType.ordinal()]) {
            case 1:
                return breakSegmentWithDocument(layoutHelper);
            case 2:
                return breakSegmentWithParagraph(layoutHelper);
            case 3:
                return breakSegmentWithLine(layoutHelper, dropSpaces);
            case 4:
                return breakSegmentWithWord(layoutHelper, dropSpaces);
            case 5:
                return breakSegmentWithChar(layoutHelper, dropSpaces);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final List<Segment> breakSegmentWithDocument(LayoutHelper layoutHelper) {
        return CollectionsKt.listOf(new Segment(0, layoutHelper.getLayout().getText().length(), 0, 0, layoutHelper.getLayout().getWidth(), layoutHelper.getLayout().getHeight()));
    }

    private final List<Segment> breakSegmentWithParagraph(LayoutHelper layoutHelper) {
        LayoutHelper layoutHelper2 = layoutHelper;
        List result = new ArrayList();
        Layout layout = layoutHelper.getLayout();
        int i = 0;
        int paragraphCount = layoutHelper.getParagraphCount();
        while (i < paragraphCount) {
            int paraStart = layoutHelper2.getParagraphStart(i);
            int paraEnd = layoutHelper2.getParagraphEnd(i);
            int i2 = paraStart;
            int i3 = paraEnd;
            Segment segment = r5;
            Segment segment2 = new Segment(i2, i3, 0, layout.getLineTop(LayoutCompatKt.getLineForOffset(layout, paraStart, false)), layout.getWidth(), layout.getLineBottom(LayoutCompatKt.getLineForOffset(layout, paraEnd, true)));
            result.add(segment);
            i++;
            layoutHelper2 = layoutHelper;
        }
        return result;
    }

    private final List<Segment> breakSegmentWithLine(LayoutHelper layoutHelper, boolean dropSpaces) {
        List result = new ArrayList();
        Layout layout = layoutHelper.getLayout();
        int lineCount = layoutHelper.getLayout().getLineCount();
        for (int i = 0; i < lineCount; i++) {
            result.add(new Segment(layout.getLineStart(i), layout.getLineEnd(i), dropSpaces ? (int) ((float) Math.ceil((double) layout.getLineLeft(i))) : 0, layout.getLineTop(i), dropSpaces ? (int) ((float) Math.ceil((double) layout.getLineRight(i))) : layout.getWidth(), layout.getLineBottom(i)));
        }
        return result;
    }

    private final List<Segment> breakSegmentWithWord(LayoutHelper layoutHelper, boolean dropSpaces) {
        LayoutHelper layoutHelper2 = layoutHelper;
        Layout layout = layoutHelper.getLayout();
        int wsWidth = (int) ((float) Math.ceil((double) layout.getPaint().measureText(" ")));
        List result$iv = breakOffsets(layoutHelper2, SegmentType.Word);
        int $i$f$fastZipWithNext = false;
        if (result$iv.size() == 0) {
            List $this$fastZipWithNext$iv = result$iv;
        } else if (result$iv.size() == 1) {
            List<Integer> list = result$iv;
        } else {
            List result$iv2 = new ArrayList();
            boolean z = false;
            Object current$iv = result$iv.get(0);
            int i$iv = 0;
            int lastIndex = CollectionsKt.getLastIndex(result$iv);
            while (i$iv < lastIndex) {
                Object next$iv = result$iv.get(i$iv + 1);
                int end = ((Number) next$iv).intValue();
                int start = ((Number) current$iv).intValue();
                int lineNo = LayoutCompatKt.getLineForOffset(layout, start, z);
                boolean paraRTL = layout.getParagraphDirection(lineNo) == -1;
                boolean runRtl = layout.isRtlCharAt(start);
                List $this$fastZipWithNext$iv2 = result$iv;
                int $i$f$fastZipWithNext2 = $i$f$fastZipWithNext;
                int startPos = (int) ((float) Math.ceil((double) layoutHelper2.getHorizontalPosition(start, runRtl == paraRTL, false)));
                List result$iv3 = result$iv2;
                int endPos = (int) ((float) Math.ceil((double) layoutHelper2.getHorizontalPosition(end, runRtl == paraRTL, true)));
                int left = Math.min(startPos, endPos);
                int right = Math.max(startPos, endPos);
                if (!dropSpaces || end == 0) {
                } else {
                    int i = startPos;
                    if (layout.getText().charAt(end - 1) == ' ' && layout.getLineEnd(lineNo) != end) {
                        if (runRtl) {
                            left += wsWidth;
                        } else {
                            right -= wsWidth;
                        }
                    }
                }
                int i2 = lineNo;
                int i3 = start;
                List result$iv4 = result$iv3;
                result$iv4.add(new Segment(start, end, left, layout.getLineTop(lineNo), right, layout.getLineBottom(lineNo)));
                current$iv = next$iv;
                i$iv++;
                layoutHelper2 = layoutHelper;
                result$iv2 = result$iv4;
                $i$f$fastZipWithNext = $i$f$fastZipWithNext2;
                result$iv = $this$fastZipWithNext$iv2;
                z = false;
            }
            List $this$fastZipWithNext$iv3 = result$iv;
            int i4 = $i$f$fastZipWithNext;
            List $this$fastZipWithNext$iv4 = result$iv2;
            return result$iv2;
        }
        return CollectionsKt.emptyList();
    }

    private final List<Segment> breakSegmentWithChar(LayoutHelper layoutHelper, boolean dropSpaces) {
        List $this$fastZipWithNext$iv;
        int $i$f$fastZipWithNext;
        List result$iv;
        LayoutHelper layoutHelper2 = layoutHelper;
        List res = new ArrayList();
        List $this$fastZipWithNext$iv2 = breakOffsets(layoutHelper2, SegmentType.Character);
        int $i$f$fastZipWithNext2 = false;
        if ($this$fastZipWithNext$iv2.size() == 0) {
        } else if ($this$fastZipWithNext$iv2.size() == 1) {
            List<Integer> list = $this$fastZipWithNext$iv2;
        } else {
            List result$iv2 = new ArrayList();
            boolean z = false;
            Object current$iv = $this$fastZipWithNext$iv2.get(0);
            int i$iv = 0;
            int lastIndex = CollectionsKt.getLastIndex($this$fastZipWithNext$iv2);
            while (i$iv < lastIndex) {
                Object next$iv = $this$fastZipWithNext$iv2.get(i$iv + 1);
                int end = ((Number) next$iv).intValue();
                int start = ((Number) current$iv).intValue();
                Layout layout = layoutHelper.getLayout();
                if (!dropSpaces || end != start + 1 || !layoutHelper2.isLineEndSpace(layout.getText().charAt(start))) {
                    int lineNo = LayoutCompatKt.getLineForOffset(layout, start, z);
                    boolean paraRTL = layout.getParagraphDirection(lineNo) == -1;
                    boolean runRtl = layout.isRtlCharAt(start);
                    $this$fastZipWithNext$iv = $this$fastZipWithNext$iv2;
                    $i$f$fastZipWithNext = $i$f$fastZipWithNext2;
                    int startPos = (int) ((float) Math.ceil((double) layoutHelper2.getHorizontalPosition(start, runRtl == paraRTL, false)));
                    result$iv = result$iv2;
                    int endPos = (int) ((float) Math.ceil((double) layoutHelper2.getHorizontalPosition(end, runRtl == paraRTL, true)));
                    int i = lineNo;
                    Layout layout2 = layout;
                    int i2 = start;
                    res.add(new Segment(start, end, Math.min(startPos, endPos), layout.getLineTop(lineNo), Math.max(startPos, endPos), layout.getLineBottom(lineNo)));
                } else {
                    $this$fastZipWithNext$iv = $this$fastZipWithNext$iv2;
                    $i$f$fastZipWithNext = $i$f$fastZipWithNext2;
                    result$iv = result$iv2;
                }
                List result$iv3 = result$iv;
                result$iv3.add(Unit.INSTANCE);
                current$iv = next$iv;
                i$iv++;
                result$iv2 = result$iv3;
                $i$f$fastZipWithNext2 = $i$f$fastZipWithNext;
                $this$fastZipWithNext$iv2 = $this$fastZipWithNext$iv;
                z = false;
            }
            int i3 = $i$f$fastZipWithNext2;
            List list2 = result$iv2;
            return res;
        }
        CollectionsKt.emptyList();
        return res;
    }
}

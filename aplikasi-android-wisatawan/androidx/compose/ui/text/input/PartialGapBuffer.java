package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/input/PartialGapBuffer;", "", "text", "", "(Ljava/lang/String;)V", "bufEnd", "", "bufStart", "buffer", "Landroidx/compose/ui/text/input/GapBuffer;", "length", "getLength", "()I", "getText", "()Ljava/lang/String;", "setText", "get", "", "index", "replace", "", "start", "end", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GapBuffer.kt */
public final class PartialGapBuffer {
    public static final int $stable = 8;
    public static final int BUF_SIZE = 255;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 64;
    private int bufEnd = -1;
    private int bufStart = -1;
    private GapBuffer buffer;
    private String text;

    public PartialGapBuffer(String text2) {
        Intrinsics.checkNotNullParameter(text2, "text");
        this.text = text2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/input/PartialGapBuffer$Companion;", "", "()V", "BUF_SIZE", "", "NOWHERE", "SURROUNDING_SIZE", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: GapBuffer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final int getLength() {
        GapBuffer buffer2 = this.buffer;
        if (buffer2 == null) {
            return this.text.length();
        }
        return (this.text.length() - (this.bufEnd - this.bufStart)) + buffer2.length();
    }

    public final void replace(int start, int end, String text2) {
        Intrinsics.checkNotNullParameter(text2, "text");
        boolean z = true;
        if (start <= end) {
            if (start < 0) {
                z = false;
            }
            if (z) {
                GapBuffer buffer2 = this.buffer;
                if (buffer2 == null) {
                    char[] charArray = new char[Math.max(255, text2.length() + 128)];
                    int leftCopyCount = Math.min(start, 64);
                    int rightCopyCount = Math.min(this.text.length() - end, 64);
                    GapBuffer_jvmKt.toCharArray(this.text, charArray, 0, start - leftCopyCount, start);
                    GapBuffer_jvmKt.toCharArray(this.text, charArray, charArray.length - rightCopyCount, end, end + rightCopyCount);
                    GapBufferKt.toCharArray(text2, charArray, leftCopyCount);
                    this.buffer = new GapBuffer(charArray, text2.length() + leftCopyCount, charArray.length - rightCopyCount);
                    this.bufStart = start - leftCopyCount;
                    this.bufEnd = end + rightCopyCount;
                    return;
                }
                int i = this.bufStart;
                int bufferStart = start - i;
                int bufferEnd = end - i;
                if (bufferStart < 0 || bufferEnd > buffer2.length()) {
                    this.text = toString();
                    this.buffer = null;
                    this.bufStart = -1;
                    this.bufEnd = -1;
                    replace(start, end, text2);
                    return;
                }
                buffer2.replace(bufferStart, bufferEnd, text2);
                return;
            }
            throw new IllegalArgumentException(("start must be non-negative, but was " + start).toString());
        }
        throw new IllegalArgumentException(("start index must be less than or equal to end index: " + start + " > " + end).toString());
    }

    public final char get(int index) {
        GapBuffer buffer2 = this.buffer;
        if (buffer2 == null) {
            return this.text.charAt(index);
        }
        if (index < this.bufStart) {
            return this.text.charAt(index);
        }
        int gapBufLength = buffer2.length();
        int i = this.bufStart;
        if (index < gapBufLength + i) {
            return buffer2.get(index - i);
        }
        return this.text.charAt(index - ((gapBufLength - this.bufEnd) + i));
    }

    public String toString() {
        GapBuffer b = this.buffer;
        if (b == null) {
            return this.text;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.text, 0, this.bufStart);
        b.append(sb);
        String str = this.text;
        sb.append(str, this.bufEnd, str.length());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}

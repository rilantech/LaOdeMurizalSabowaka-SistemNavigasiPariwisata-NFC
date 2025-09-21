package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/input/TransformedText;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/input/OffsetMapping;)V", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "equals", "", "other", "hashCode", "", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VisualTransformation.kt */
public final class TransformedText {
    public static final int $stable = 8;
    private final OffsetMapping offsetMapping;
    private final AnnotatedString text;

    public TransformedText(AnnotatedString text2, OffsetMapping offsetMapping2) {
        Intrinsics.checkNotNullParameter(text2, "text");
        Intrinsics.checkNotNullParameter(offsetMapping2, "offsetMapping");
        this.text = text2;
        this.offsetMapping = offsetMapping2;
    }

    public final AnnotatedString getText() {
        return this.text;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TransformedText) && Intrinsics.areEqual((Object) this.text, (Object) ((TransformedText) other).text) && Intrinsics.areEqual((Object) this.offsetMapping, (Object) ((TransformedText) other).offsetMapping)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.offsetMapping.hashCode();
    }

    public String toString() {
        return "TransformedText(text=" + this.text + ", offsetMapping=" + this.offsetMapping + ')';
    }
}

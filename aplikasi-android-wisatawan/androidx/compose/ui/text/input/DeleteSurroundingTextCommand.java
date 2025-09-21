package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/input/DeleteSurroundingTextCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "lengthBeforeCursor", "", "lengthAfterCursor", "(II)V", "getLengthAfterCursor", "()I", "getLengthBeforeCursor", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EditCommand.kt */
public final class DeleteSurroundingTextCommand implements EditCommand {
    public static final int $stable = 0;
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;

    public DeleteSurroundingTextCommand(int lengthBeforeCursor2, int lengthAfterCursor2) {
        this.lengthBeforeCursor = lengthBeforeCursor2;
        this.lengthAfterCursor = lengthAfterCursor2;
        if (!(lengthBeforeCursor2 >= 0 && lengthAfterCursor2 >= 0)) {
            throw new IllegalArgumentException(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + lengthBeforeCursor2 + " and " + lengthAfterCursor2 + " respectively.").toString());
        }
    }

    public final int getLengthBeforeCursor() {
        return this.lengthBeforeCursor;
    }

    public final int getLengthAfterCursor() {
        return this.lengthAfterCursor;
    }

    public void applyTo(EditingBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int $this$addExactOrElse$iv = buffer.getSelectionEnd$ui_text_release();
        int right$iv = this.lengthAfterCursor;
        int result$iv = $this$addExactOrElse$iv + right$iv;
        if ((($this$addExactOrElse$iv ^ result$iv) & (right$iv ^ result$iv)) < 0) {
            result$iv = buffer.getLength$ui_text_release();
        }
        buffer.delete$ui_text_release(buffer.getSelectionEnd$ui_text_release(), Math.min(result$iv, buffer.getLength$ui_text_release()));
        buffer.delete$ui_text_release(Math.max(0, MathUtilsKt.subtractExactOrElse(buffer.getSelectionStart$ui_text_release(), this.lengthBeforeCursor, DeleteSurroundingTextCommand$applyTo$start$1.INSTANCE)), buffer.getSelectionStart$ui_text_release());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof DeleteSurroundingTextCommand) && this.lengthBeforeCursor == ((DeleteSurroundingTextCommand) other).lengthBeforeCursor && this.lengthAfterCursor == ((DeleteSurroundingTextCommand) other).lengthAfterCursor) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    public String toString() {
        return "DeleteSurroundingTextCommand(lengthBeforeCursor=" + this.lengthBeforeCursor + ", lengthAfterCursor=" + this.lengthAfterCursor + ')';
    }
}

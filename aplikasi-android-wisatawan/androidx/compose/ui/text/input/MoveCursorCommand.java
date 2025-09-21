package androidx.compose.ui.text.input;

import androidx.compose.ui.text.JvmCharHelpers_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/input/MoveCursorCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "amount", "", "(I)V", "getAmount", "()I", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EditCommand.kt */
public final class MoveCursorCommand implements EditCommand {
    public static final int $stable = 0;
    private final int amount;

    public MoveCursorCommand(int amount2) {
        this.amount = amount2;
    }

    public final int getAmount() {
        return this.amount;
    }

    public void applyTo(EditingBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (buffer.getCursor$ui_text_release() == -1) {
            buffer.setCursor$ui_text_release(buffer.getSelectionStart$ui_text_release());
        }
        int newCursor = buffer.getSelectionStart$ui_text_release();
        String bufferText = buffer.toString();
        int i = this.amount;
        if (i <= 0) {
            int i2 = -i;
            for (int i3 = 0; i3 < i2; i3++) {
                int prev = JvmCharHelpers_androidKt.findPrecedingBreak(bufferText, newCursor);
                if (prev == -1) {
                    break;
                }
                newCursor = prev;
            }
        } else {
            for (int i4 = 0; i4 < i; i4++) {
                int next = JvmCharHelpers_androidKt.findFollowingBreak(bufferText, newCursor);
                if (next == -1) {
                    break;
                }
                newCursor = next;
            }
        }
        buffer.setCursor$ui_text_release(newCursor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof MoveCursorCommand) && this.amount == ((MoveCursorCommand) other).amount) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.amount;
    }

    public String toString() {
        return "MoveCursorCommand(amount=" + this.amount + ')';
    }
}

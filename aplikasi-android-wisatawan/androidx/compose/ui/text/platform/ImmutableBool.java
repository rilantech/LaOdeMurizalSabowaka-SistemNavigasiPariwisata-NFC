package androidx.compose.ui.text.platform;

import androidx.compose.runtime.State;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/platform/ImmutableBool;", "Landroidx/compose/runtime/State;", "", "value", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EmojiCompatStatus.kt */
final class ImmutableBool implements State<Boolean> {
    private final boolean value;

    public ImmutableBool(boolean value2) {
        this.value = value2;
    }

    public Boolean getValue() {
        return Boolean.valueOf(this.value);
    }
}

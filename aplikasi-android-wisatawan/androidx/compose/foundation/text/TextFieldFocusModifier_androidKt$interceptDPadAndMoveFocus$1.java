package androidx.compose.foundation.text;

import android.view.InputDevice;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.core.view.InputDeviceCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "invoke-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldFocusModifier.android.kt */
final class TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1 extends Lambda implements Function1<KeyEvent, Boolean> {
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ TextFieldState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1(FocusManager focusManager, TextFieldState textFieldState) {
        super(1);
        this.$focusManager = focusManager;
        this.$state = textFieldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return m959invokeZmokQxo(((KeyEvent) p1).m4322unboximpl());
    }

    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m959invokeZmokQxo(android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        InputDevice device = keyEvent.getDevice();
        boolean z = false;
        if (device != null && device.supportsSource(InputDeviceCompat.SOURCE_DPAD) && !device.isVirtual() && KeyEventType.m4326equalsimpl0(KeyEvent_androidKt.m4334getTypeZmokQxo(keyEvent), KeyEventType.Companion.m4330getKeyDownCS__XNY())) {
            if (TextFieldFocusModifier_androidKt.m958isKeyCodeYhN2O0w(keyEvent, 19)) {
                z = this.$focusManager.m2937moveFocus3ESFkO8(FocusDirection.Companion.m2936getUpdhqQ8s());
            } else if (TextFieldFocusModifier_androidKt.m958isKeyCodeYhN2O0w(keyEvent, 20)) {
                z = this.$focusManager.m2937moveFocus3ESFkO8(FocusDirection.Companion.m2927getDowndhqQ8s());
            } else if (TextFieldFocusModifier_androidKt.m958isKeyCodeYhN2O0w(keyEvent, 21)) {
                z = this.$focusManager.m2937moveFocus3ESFkO8(FocusDirection.Companion.m2931getLeftdhqQ8s());
            } else if (TextFieldFocusModifier_androidKt.m958isKeyCodeYhN2O0w(keyEvent, 22)) {
                z = this.$focusManager.m2937moveFocus3ESFkO8(FocusDirection.Companion.m2935getRightdhqQ8s());
            } else if (TextFieldFocusModifier_androidKt.m958isKeyCodeYhN2O0w(keyEvent, 23)) {
                TextInputSession inputSession = this.$state.getInputSession();
                if (inputSession != null) {
                    inputSession.showSoftwareKeyboard();
                }
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }
}

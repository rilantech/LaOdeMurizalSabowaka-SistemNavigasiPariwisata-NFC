package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\b"}, d2 = {"androidx/compose/foundation/text/KeyMapping_androidKt$platformDefaultKeyMapping$1", "Landroidx/compose/foundation/text/KeyMapping;", "map", "Landroidx/compose/foundation/text/KeyCommand;", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "map-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/foundation/text/KeyCommand;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeyMapping.android.kt */
public final class KeyMapping_androidKt$platformDefaultKeyMapping$1 implements KeyMapping {
    KeyMapping_androidKt$platformDefaultKeyMapping$1() {
    }

    /* renamed from: map-ZmokQxo  reason: not valid java name */
    public KeyCommand m905mapZmokQxo(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        KeyCommand keyCommand = null;
        if (KeyEvent_androidKt.m4339isShiftPressedZmokQxo(event) && KeyEvent_androidKt.m4336isAltPressedZmokQxo(event)) {
            long r2 = KeyEvent_androidKt.m4333getKeyZmokQxo(event);
            if (Key.m4025equalsimpl0(r2, MappedKeys.INSTANCE.m926getDirectionLeftEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_LINE_LEFT;
            } else if (Key.m4025equalsimpl0(r2, MappedKeys.INSTANCE.m927getDirectionRightEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_LINE_RIGHT;
            } else if (Key.m4025equalsimpl0(r2, MappedKeys.INSTANCE.m928getDirectionUpEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_HOME;
            } else if (Key.m4025equalsimpl0(r2, MappedKeys.INSTANCE.m925getDirectionDownEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_END;
            }
        } else if (KeyEvent_androidKt.m4336isAltPressedZmokQxo(event)) {
            long r22 = KeyEvent_androidKt.m4333getKeyZmokQxo(event);
            if (Key.m4025equalsimpl0(r22, MappedKeys.INSTANCE.m926getDirectionLeftEK5gGoQ())) {
                keyCommand = KeyCommand.LINE_LEFT;
            } else if (Key.m4025equalsimpl0(r22, MappedKeys.INSTANCE.m927getDirectionRightEK5gGoQ())) {
                keyCommand = KeyCommand.LINE_RIGHT;
            } else if (Key.m4025equalsimpl0(r22, MappedKeys.INSTANCE.m928getDirectionUpEK5gGoQ())) {
                keyCommand = KeyCommand.HOME;
            } else if (Key.m4025equalsimpl0(r22, MappedKeys.INSTANCE.m925getDirectionDownEK5gGoQ())) {
                keyCommand = KeyCommand.END;
            }
        }
        return keyCommand == null ? KeyMappingKt.getDefaultKeyMapping().m902mapZmokQxo(event) : keyCommand;
    }
}

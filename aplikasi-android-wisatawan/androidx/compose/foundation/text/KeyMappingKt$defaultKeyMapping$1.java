package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeyMapping.kt */
/* synthetic */ class KeyMappingKt$defaultKeyMapping$1 extends PropertyReference1Impl {
    public static final KeyMappingKt$defaultKeyMapping$1 INSTANCE = new KeyMappingKt$defaultKeyMapping$1();

    KeyMappingKt$defaultKeyMapping$1() {
        super(KeyEvent_androidKt.class, "isCtrlPressed", "isCtrlPressed-ZmokQxo(Landroid/view/KeyEvent;)Z", 1);
    }

    public Object get(Object receiver0) {
        return Boolean.valueOf(KeyEvent_androidKt.m4337isCtrlPressedZmokQxo(((KeyEvent) receiver0).m4322unboximpl()));
    }
}

package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.key.KeyEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/input/key/KeyEvent;", "invoke-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionManager.kt */
final class SelectionManager$modifier$4 extends Lambda implements Function1<KeyEvent, Boolean> {
    final /* synthetic */ SelectionManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionManager$modifier$4(SelectionManager selectionManager) {
        super(1);
        this.this$0 = selectionManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return m2816invokeZmokQxo(((KeyEvent) p1).m6032unboximpl());
    }

    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m2816invokeZmokQxo(android.view.KeyEvent it) {
        boolean z;
        Intrinsics.checkNotNullParameter(it, "it");
        if (SelectionManager_androidKt.m2820isCopyKeyEventZmokQxo(it)) {
            this.this$0.copy$foundation_release();
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}

package androidx.compose.material3;

import android.view.accessibility.AccessibilityManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TouchExplorationStateProvider.android.kt */
final class TouchExplorationStateProvider_androidKt$touchExplorationState$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AccessibilityManager $accessibilityManager;
    final /* synthetic */ Listener $listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TouchExplorationStateProvider_androidKt$touchExplorationState$2(Listener listener, AccessibilityManager accessibilityManager) {
        super(0);
        this.$listener = listener;
        this.$accessibilityManager = accessibilityManager;
    }

    public final void invoke() {
        this.$listener.unregister(this.$accessibilityManager);
    }
}

package androidx.compose.material3;

import android.view.accessibility.AccessibilityManager;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TouchExplorationStateProvider.android.kt */
final class TouchExplorationStateProvider_androidKt$touchExplorationState$1 extends Lambda implements Function1<Lifecycle.Event, Unit> {
    final /* synthetic */ AccessibilityManager $accessibilityManager;
    final /* synthetic */ Listener $listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TouchExplorationStateProvider_androidKt$touchExplorationState$1(Listener listener, AccessibilityManager accessibilityManager) {
        super(1);
        this.$listener = listener;
        this.$accessibilityManager = accessibilityManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Lifecycle.Event) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_RESUME) {
            this.$listener.register(this.$accessibilityManager);
        }
    }
}

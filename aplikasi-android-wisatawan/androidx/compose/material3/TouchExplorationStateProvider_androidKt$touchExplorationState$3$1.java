package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TouchExplorationStateProvider.android.kt */
final class TouchExplorationStateProvider_androidKt$touchExplorationState$3$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Listener $listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TouchExplorationStateProvider_androidKt$touchExplorationState$3$1(Listener listener) {
        super(0);
        this.$listener = listener;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(this.$listener.isEnabled());
    }
}

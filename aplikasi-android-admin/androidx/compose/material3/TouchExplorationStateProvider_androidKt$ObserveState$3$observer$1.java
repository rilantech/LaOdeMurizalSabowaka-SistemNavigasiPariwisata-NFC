package androidx.compose.material3;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TouchExplorationStateProvider.android.kt */
final class TouchExplorationStateProvider_androidKt$ObserveState$3$observer$1 implements LifecycleEventObserver {
    final /* synthetic */ Function1<Lifecycle.Event, Unit> $handleEvent;

    TouchExplorationStateProvider_androidKt$ObserveState$3$observer$1(Function1<? super Lifecycle.Event, Unit> function1) {
        this.$handleEvent = function1;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        this.$handleEvent.invoke(event);
    }
}

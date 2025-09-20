package androidx.compose.ui.platform;

import android.os.Handler;
import android.view.View;
import androidx.compose.runtime.Recomposer;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.android.HandlerDispatcherKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0001J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0001J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0005J-\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0003\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\bø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/platform/WindowRecomposerPolicy;", "", "()V", "factory", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/platform/WindowRecomposerFactory;", "compareAndSetFactory", "", "expected", "createAndInstallWindowRecomposer", "Landroidx/compose/runtime/Recomposer;", "rootView", "Landroid/view/View;", "createAndInstallWindowRecomposer$ui_release", "getAndSetFactory", "setFactory", "", "withFactory", "R", "block", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/WindowRecomposerFactory;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowRecomposer.android.kt */
public final class WindowRecomposerPolicy {
    public static final int $stable = 8;
    public static final WindowRecomposerPolicy INSTANCE = new WindowRecomposerPolicy();
    private static final AtomicReference<WindowRecomposerFactory> factory = new AtomicReference<>(WindowRecomposerFactory.Companion.getLifecycleAware());

    private WindowRecomposerPolicy() {
    }

    public final WindowRecomposerFactory getAndSetFactory(WindowRecomposerFactory factory2) {
        Intrinsics.checkNotNullParameter(factory2, "factory");
        WindowRecomposerFactory andSet = factory.getAndSet(factory2);
        Intrinsics.checkNotNullExpressionValue(andSet, "factory.getAndSet(factory)");
        return andSet;
    }

    public final boolean compareAndSetFactory(WindowRecomposerFactory expected, WindowRecomposerFactory factory2) {
        Intrinsics.checkNotNullParameter(expected, "expected");
        Intrinsics.checkNotNullParameter(factory2, "factory");
        return factory.compareAndSet(expected, factory2);
    }

    public final void setFactory(WindowRecomposerFactory factory2) {
        Intrinsics.checkNotNullParameter(factory2, "factory");
        factory.set(factory2);
    }

    /* Debug info: failed to restart local var, previous not found, register: 7 */
    public final <R> R withFactory(WindowRecomposerFactory factory2, Function0<? extends R> block) {
        Throwable cause;
        Intrinsics.checkNotNullParameter(factory2, "factory");
        Intrinsics.checkNotNullParameter(block, "block");
        WindowRecomposerFactory oldFactory = getAndSetFactory(factory2);
        try {
            R invoke = block.invoke();
            InlineMarker.finallyStart(1);
            if (compareAndSetFactory(factory2, oldFactory)) {
                InlineMarker.finallyEnd(1);
                return invoke;
            }
            throw new IllegalStateException("WindowRecomposerFactory was set to unexpected value; cannot safely restore old state");
        } catch (Throwable t) {
            InlineMarker.finallyStart(1);
            if (!compareAndSetFactory(factory2, oldFactory)) {
                ExceptionsKt.addSuppressed(cause, new IllegalStateException("WindowRecomposerFactory was set to unexpected value; cannot safely restore old state"));
                throw cause;
            }
            InlineMarker.finallyEnd(1);
            throw t;
        }
    }

    public final Recomposer createAndInstallWindowRecomposer$ui_release(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Recomposer newRecomposer = factory.get().createRecomposer(rootView);
        WindowRecomposer_androidKt.setCompositionContext(rootView, newRecomposer);
        Handler handler = rootView.getHandler();
        Intrinsics.checkNotNullExpressionValue(handler, "rootView.handler");
        rootView.addOnAttachStateChangeListener(new WindowRecomposerPolicy$createAndInstallWindowRecomposer$1(BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, HandlerDispatcherKt.from(handler, "windowRecomposer cleanup").getImmediate(), (CoroutineStart) null, new WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1(newRecomposer, rootView, (Continuation<? super WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1>) null), 2, (Object) null)));
        return newRecomposer;
    }
}

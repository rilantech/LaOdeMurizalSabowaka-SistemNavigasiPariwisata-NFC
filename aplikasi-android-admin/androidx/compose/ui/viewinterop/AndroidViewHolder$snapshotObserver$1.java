package androidx.compose.ui.viewinterop;

import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "command", "Lkotlin/Function0;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidViewHolder.android.kt */
final class AndroidViewHolder$snapshotObserver$1 extends Lambda implements Function1<Function0<? extends Unit>, Unit> {
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$snapshotObserver$1(AndroidViewHolder androidViewHolder) {
        super(1);
        this.this$0 = androidViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Function0<Unit>) (Function0) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Function0<Unit> command) {
        Intrinsics.checkNotNullParameter(command, "command");
        if (this.this$0.getHandler().getLooper() == Looper.myLooper()) {
            command.invoke();
        } else {
            this.this$0.getHandler().post(new AndroidViewHolder$snapshotObserver$1$$ExternalSyntheticLambda0(command));
        }
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(Function0 $tmp0) {
        Intrinsics.checkNotNullParameter($tmp0, "$tmp0");
        $tmp0.invoke();
    }
}

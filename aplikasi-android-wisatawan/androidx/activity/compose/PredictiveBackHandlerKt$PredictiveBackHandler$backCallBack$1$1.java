package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"androidx/activity/compose/PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1", "Landroidx/activity/OnBackPressedCallback;", "onBackInstance", "Landroidx/activity/compose/OnBackInstance;", "getOnBackInstance", "()Landroidx/activity/compose/OnBackInstance;", "setOnBackInstance", "(Landroidx/activity/compose/OnBackInstance;)V", "handleOnBackCancelled", "", "handleOnBackPressed", "handleOnBackProgressed", "backEvent", "Landroidx/activity/BackEventCompat;", "handleOnBackStarted", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PredictiveBackHandler.kt */
public final class PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 extends OnBackPressedCallback {
    final /* synthetic */ State<Function2<Flow<BackEventCompat>, Continuation<Unit>, Object>> $currentOnBack$delegate;
    final /* synthetic */ CoroutineScope $onBackScope;
    private OnBackInstance onBackInstance;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1(boolean $enabled, CoroutineScope $onBackScope2, State<? extends Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object>> $currentOnBack$delegate2) {
        super($enabled);
        this.$onBackScope = $onBackScope2;
        this.$currentOnBack$delegate = $currentOnBack$delegate2;
    }

    public final OnBackInstance getOnBackInstance() {
        return this.onBackInstance;
    }

    public final void setOnBackInstance(OnBackInstance onBackInstance2) {
        this.onBackInstance = onBackInstance2;
    }

    public void handleOnBackStarted(BackEventCompat backEvent) {
        super.handleOnBackStarted(backEvent);
        OnBackInstance onBackInstance2 = this.onBackInstance;
        if (onBackInstance2 != null) {
            onBackInstance2.cancel();
        }
        this.onBackInstance = new OnBackInstance(this.$onBackScope, true, PredictiveBackHandlerKt.PredictiveBackHandler$lambda$0(this.$currentOnBack$delegate));
    }

    public void handleOnBackProgressed(BackEventCompat backEvent) {
        super.handleOnBackProgressed(backEvent);
        OnBackInstance onBackInstance2 = this.onBackInstance;
        if (onBackInstance2 != null) {
            ChannelResult.m7752boximpl(onBackInstance2.m6sendJP2dKIU(backEvent));
        }
    }

    public void handleOnBackPressed() {
        OnBackInstance $this$handleOnBackPressed_u24lambda_u240 = this.onBackInstance;
        if ($this$handleOnBackPressed_u24lambda_u240 != null && !$this$handleOnBackPressed_u24lambda_u240.isPredictiveBack()) {
            $this$handleOnBackPressed_u24lambda_u240.cancel();
            this.onBackInstance = null;
        }
        if (this.onBackInstance == null) {
            this.onBackInstance = new OnBackInstance(this.$onBackScope, false, PredictiveBackHandlerKt.PredictiveBackHandler$lambda$0(this.$currentOnBack$delegate));
        }
        OnBackInstance onBackInstance2 = this.onBackInstance;
        if (onBackInstance2 != null) {
            onBackInstance2.close();
        }
    }

    public void handleOnBackCancelled() {
        super.handleOnBackCancelled();
        OnBackInstance onBackInstance2 = this.onBackInstance;
        if (onBackInstance2 != null) {
            onBackInstance2.cancel();
        }
    }
}

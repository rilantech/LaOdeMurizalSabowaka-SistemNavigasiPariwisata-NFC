package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.channels.Channel;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {169, 171, 215}, m = "detectZoom", n = {"$this$detectZoom", "panZoomLock", "channel", "canPan", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", "panZoomLock", "channel", "canPan", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", "panZoomLock", "channel", "canPan", "event", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "canceled"}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "I$2"})
/* compiled from: Transformable.kt */
final class TransformableKt$detectZoom$1 extends ContinuationImpl {
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    TransformableKt$detectZoom$1(Continuation<? super TransformableKt$detectZoom$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TransformableKt.detectZoom((AwaitPointerEventScope) null, (State<Boolean>) null, (Channel<TransformEvent>) null, (State<? extends Function0<Boolean>>) null, this);
    }
}

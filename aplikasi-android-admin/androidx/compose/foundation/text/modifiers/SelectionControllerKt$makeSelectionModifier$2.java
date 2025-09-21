package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$2", f = "SelectionController.kt", i = {}, l = {345}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SelectionController.kt */
final class SelectionControllerKt$makeSelectionModifier$2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1 $mouseSelectionObserver;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionControllerKt$makeSelectionModifier$2(SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1 selectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1, Continuation<? super SelectionControllerKt$makeSelectionModifier$2> continuation) {
        super(2, continuation);
        this.$mouseSelectionObserver = selectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SelectionControllerKt$makeSelectionModifier$2 selectionControllerKt$makeSelectionModifier$2 = new SelectionControllerKt$makeSelectionModifier$2(this.$mouseSelectionObserver, continuation);
        selectionControllerKt$makeSelectionModifier$2.L$0 = obj;
        return selectionControllerKt$makeSelectionModifier$2;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((SelectionControllerKt$makeSelectionModifier$2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (TextSelectionMouseDetectorKt.mouseSelectionDetector((PointerInputScope) this.L$0, this.$mouseSelectionObserver, this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}

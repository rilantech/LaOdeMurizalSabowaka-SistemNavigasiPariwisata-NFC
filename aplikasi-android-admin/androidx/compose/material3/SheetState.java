package androidx.compose.material3;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ%\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u0011\u0010&\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0011\u0010(\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0011\u0010)\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0006\u0010*\u001a\u00020\u0014J\u001b\u0010+\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0011\u0010.\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010'J\u001b\u0010/\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0005H\u0000¢\u0006\u0002\b3R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148@X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b \u0010\f\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Landroidx/compose/material3/SheetState;", "", "skipPartiallyExpanded", "", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "Lkotlin/Function1;", "skipHiddenState", "(ZLandroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;Z)V", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/SheetValue;", "hasExpandedState", "getHasExpandedState", "()Z", "hasPartiallyExpandedState", "getHasPartiallyExpandedState", "isVisible", "offset", "", "getOffset$material3_release", "()Ljava/lang/Float;", "getSkipHiddenState$material3_release", "getSkipPartiallyExpanded$material3_release", "swipeableState", "Landroidx/compose/material3/SwipeableV2State;", "getSwipeableState$material3_release", "()Landroidx/compose/material3/SwipeableV2State;", "setSwipeableState$material3_release", "(Landroidx/compose/material3/SwipeableV2State;)V", "targetValue", "getTargetValue", "animateTo", "", "velocity", "animateTo$material3_release", "(Landroidx/compose/material3/SheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expand", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hide", "partialExpand", "requireOffset", "settle", "settle$material3_release", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "show", "snapTo", "snapTo$material3_release", "(Landroidx/compose/material3/SheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "trySnapTo$material3_release", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SheetDefaults.kt */
public final class SheetState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean skipHiddenState;
    private final boolean skipPartiallyExpanded;
    private SwipeableV2State<SheetValue> swipeableState;

    public SheetState(boolean skipPartiallyExpanded2, SheetValue initialValue, Function1<? super SheetValue, Boolean> confirmValueChange, boolean skipHiddenState2) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        this.skipPartiallyExpanded = skipPartiallyExpanded2;
        this.skipHiddenState = skipHiddenState2;
        boolean z = true;
        if (skipPartiallyExpanded2) {
            if (!(initialValue != SheetValue.PartiallyExpanded)) {
                throw new IllegalArgumentException("The initial value must not be set to PartiallyExpanded if skipPartiallyExpanded is set to true.".toString());
            }
        }
        if (skipHiddenState2) {
            if (!(initialValue == SheetValue.Hidden ? false : z)) {
                throw new IllegalArgumentException("The initial value must not be set to Hidden if skipHiddenState is set to true.".toString());
            }
        }
        this.swipeableState = new SwipeableV2State(initialValue, SwipeableV2Defaults.INSTANCE.getAnimationSpec(), confirmValueChange, (Function2) null, 0.0f, 24, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SheetState(boolean z, SheetValue sheetValue, Function1 function1, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? SheetValue.Hidden : sheetValue, (i & 4) != 0 ? AnonymousClass1.INSTANCE : function1, (i & 8) != 0 ? false : z2);
    }

    public final boolean getSkipPartiallyExpanded$material3_release() {
        return this.skipPartiallyExpanded;
    }

    public final boolean getSkipHiddenState$material3_release() {
        return this.skipHiddenState;
    }

    public final SheetValue getCurrentValue() {
        return this.swipeableState.getCurrentValue();
    }

    public final SheetValue getTargetValue() {
        return this.swipeableState.getTargetValue();
    }

    public final boolean isVisible() {
        return this.swipeableState.getCurrentValue() != SheetValue.Hidden;
    }

    public final float requireOffset() {
        return this.swipeableState.requireOffset();
    }

    public final boolean getHasExpandedState() {
        return this.swipeableState.hasAnchorForValue(SheetValue.Expanded);
    }

    public final boolean getHasPartiallyExpandedState() {
        return this.swipeableState.hasAnchorForValue(SheetValue.PartiallyExpanded);
    }

    public final Object expand(Continuation<? super Unit> $completion) {
        Object animateTo$default = SwipeableV2State.animateTo$default(this.swipeableState, SheetValue.Expanded, 0.0f, $completion, 2, (Object) null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public final Object partialExpand(Continuation<? super Unit> $completion) {
        if (!this.skipPartiallyExpanded) {
            Object animateTo$material3_release$default = animateTo$material3_release$default(this, SheetValue.PartiallyExpanded, 0.0f, $completion, 2, (Object) null);
            return animateTo$material3_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material3_release$default : Unit.INSTANCE;
        }
        throw new IllegalStateException("Attempted to animate to partial expanded when skipPartiallyExpanded was enabled. Set skipPartiallyExpanded to false to use this function.".toString());
    }

    public final Object show(Continuation<? super Unit> $completion) {
        SheetValue targetValue;
        if (getHasPartiallyExpandedState()) {
            targetValue = SheetValue.PartiallyExpanded;
        } else {
            targetValue = SheetValue.Expanded;
        }
        Object animateTo$material3_release$default = animateTo$material3_release$default(this, targetValue, 0.0f, $completion, 2, (Object) null);
        return animateTo$material3_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material3_release$default : Unit.INSTANCE;
    }

    public final Object hide(Continuation<? super Unit> $completion) {
        if (!this.skipHiddenState) {
            Object animateTo$material3_release$default = animateTo$material3_release$default(this, SheetValue.Hidden, 0.0f, $completion, 2, (Object) null);
            return animateTo$material3_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material3_release$default : Unit.INSTANCE;
        }
        throw new IllegalStateException("Attempted to animate to hidden when skipHiddenState was enabled. Set skipHiddenState to false to use this function.".toString());
    }

    public static /* synthetic */ Object animateTo$material3_release$default(SheetState sheetState, SheetValue sheetValue, float f, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            f = sheetState.swipeableState.getLastVelocity();
        }
        return sheetState.animateTo$material3_release(sheetValue, f, continuation);
    }

    public final Object animateTo$material3_release(SheetValue targetValue, float velocity, Continuation<? super Unit> $completion) {
        Object animateTo = this.swipeableState.animateTo(targetValue, velocity, $completion);
        return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
    }

    public final Object snapTo$material3_release(SheetValue targetValue, Continuation<? super Unit> $completion) {
        Object snapTo = this.swipeableState.snapTo(targetValue, $completion);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }

    public final boolean trySnapTo$material3_release(SheetValue targetValue) {
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        return this.swipeableState.trySnapTo$material3_release(targetValue);
    }

    public final Object settle$material3_release(float velocity, Continuation<? super Unit> $completion) {
        Object obj = this.swipeableState.settle(velocity, $completion);
        return obj == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? obj : Unit.INSTANCE;
    }

    public final SwipeableV2State<SheetValue> getSwipeableState$material3_release() {
        return this.swipeableState;
    }

    public final void setSwipeableState$material3_release(SwipeableV2State<SheetValue> swipeableV2State) {
        Intrinsics.checkNotNullParameter(swipeableV2State, "<set-?>");
        this.swipeableState = swipeableV2State;
    }

    public final Float getOffset$material3_release() {
        return this.swipeableState.getOffset();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/SheetState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SheetState;", "Landroidx/compose/material3/SheetValue;", "skipPartiallyExpanded", "", "confirmValueChange", "Lkotlin/Function1;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SheetDefaults.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<SheetState, SheetValue> Saver(boolean skipPartiallyExpanded, Function1<? super SheetValue, Boolean> confirmValueChange) {
            Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
            return SaverKt.Saver(SheetState$Companion$Saver$1.INSTANCE, new SheetState$Companion$Saver$2(skipPartiallyExpanded, confirmValueChange));
        }
    }
}

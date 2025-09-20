package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scroll.kt */
final class ScrollKt$scroll$2$semantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ boolean $isScrollable;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ boolean $reverseScrolling;
    final /* synthetic */ ScrollState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollKt$scroll$2$semantics$1(boolean z, boolean z2, boolean z3, ScrollState scrollState, CoroutineScope coroutineScope) {
        super(1);
        this.$reverseScrolling = z;
        this.$isVertical = z2;
        this.$isScrollable = z3;
        this.$state = scrollState;
        this.$coroutineScope = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalGroup($this$semantics, true);
        ScrollAxisRange accessibilityScrollState = new ScrollAxisRange(new ScrollKt$scroll$2$semantics$1$accessibilityScrollState$1(this.$state), new ScrollKt$scroll$2$semantics$1$accessibilityScrollState$2(this.$state), this.$reverseScrolling);
        if (this.$isVertical) {
            SemanticsPropertiesKt.setVerticalScrollAxisRange($this$semantics, accessibilityScrollState);
        } else {
            SemanticsPropertiesKt.setHorizontalScrollAxisRange($this$semantics, accessibilityScrollState);
        }
        if (this.$isScrollable) {
            final CoroutineScope coroutineScope = this.$coroutineScope;
            final boolean z = this.$isVertical;
            final ScrollState scrollState = this.$state;
            SemanticsPropertiesKt.scrollBy$default($this$semantics, (String) null, new Function2<Float, Float, Boolean>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return invoke(((Number) p1).floatValue(), ((Number) p2).floatValue());
                }

                public final Boolean invoke(float x, float y) {
                    CoroutineScope coroutineScope = coroutineScope;
                    final boolean z = z;
                    final ScrollState scrollState = scrollState;
                    final float f = y;
                    final float f2 = x;
                    Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
                    return true;
                }

                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.ScrollKt$scroll$2$semantics$1$1$1", f = "Scroll.kt", i = {}, l = {288, 290}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.foundation.ScrollKt$scroll$2$semantics$1$1$1  reason: invalid class name */
                /* compiled from: Scroll.kt */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(z, scrollState, f, f2, continuation);
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object $result) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                if (!z) {
                                    ScrollState scrollState = scrollState;
                                    Intrinsics.checkNotNull(scrollState, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableState");
                                    this.label = 2;
                                    if (ScrollExtensionsKt.animateScrollBy$default(scrollState, f2, (AnimationSpec) null, this, 2, (Object) null) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    ScrollState scrollState2 = scrollState;
                                    Intrinsics.checkNotNull(scrollState2, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableState");
                                    this.label = 1;
                                    if (ScrollExtensionsKt.animateScrollBy$default(scrollState2, f, (AnimationSpec) null, this, 2, (Object) null) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                }
                            case 1:
                                ResultKt.throwOnFailure($result);
                                break;
                            case 2:
                                ResultKt.throwOnFailure($result);
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, 1, (Object) null);
        }
    }
}

package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentKt$AnimatedContent$1 extends Lambda implements Function1<AnimatedContentTransitionScope<S>, ContentTransform> {
    public static final AnimatedContentKt$AnimatedContent$1 INSTANCE = new AnimatedContentKt$AnimatedContent$1();

    AnimatedContentKt$AnimatedContent$1() {
        super(1);
    }

    public final ContentTransform invoke(AnimatedContentTransitionScope<S> $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, (Easing) null, 4, (Object) null), 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.m46scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, (Easing) null, 4, (Object) null), 0.92f, 0, 4, (Object) null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null));
    }
}

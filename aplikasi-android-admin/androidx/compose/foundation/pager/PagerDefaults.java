package androidx.compose.foundation.pager;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jk\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/pager/PagerDefaults;", "", "()V", "flingBehavior", "Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "state", "Landroidx/compose/foundation/pager/PagerState;", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "lowVelocityAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "highVelocityAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "snapVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "snapPositionalThreshold", "flingBehavior-PfoAEA0", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/pager/PagerSnapDistance;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;FFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Pager.kt */
public final class PagerDefaults {
    public static final int $stable = 0;
    public static final PagerDefaults INSTANCE = new PagerDefaults();

    private PagerDefaults() {
    }

    /* renamed from: flingBehavior-PfoAEA0  reason: not valid java name */
    public final SnapFlingBehavior m2526flingBehaviorPfoAEA0(PagerState state, PagerSnapDistance pagerSnapDistance, AnimationSpec<Float> lowVelocityAnimationSpec, DecayAnimationSpec<Float> highVelocityAnimationSpec, AnimationSpec<Float> snapAnimationSpec, float snapVelocityThreshold, float snapPositionalThreshold, Composer $composer, int $changed, int i) {
        AnimationSpec lowVelocityAnimationSpec2;
        DecayAnimationSpec<Float> decayAnimationSpec;
        AnimationSpec snapAnimationSpec2;
        float snapVelocityThreshold2;
        float snapPositionalThreshold2;
        PagerState pagerState = state;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(pagerState, "state");
        composer.startReplaceableGroup(-705378306);
        ComposerKt.sourceInformation(composer, "C(flingBehavior)P(6,2,1!2,5:c#ui.unit.Dp)529@26940L26,538@27429L7,539@27452L873:Pager.kt#g6yjnt");
        boolean z = true;
        PagerSnapDistance pagerSnapDistance2 = (i & 2) != 0 ? PagerSnapDistance.Companion.atMost(1) : pagerSnapDistance;
        if ((i & 4) != 0) {
            lowVelocityAnimationSpec2 = AnimationSpecKt.tween$default(500, 0, EasingKt.getLinearEasing(), 2, (Object) null);
        } else {
            lowVelocityAnimationSpec2 = lowVelocityAnimationSpec;
        }
        if ((i & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        } else {
            decayAnimationSpec = highVelocityAnimationSpec;
        }
        if ((i & 16) != 0) {
            snapAnimationSpec2 = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        } else {
            snapAnimationSpec2 = snapAnimationSpec;
        }
        if ((i & 32) != 0) {
            snapVelocityThreshold2 = SnapFlingBehaviorKt.getMinFlingVelocityDp();
        } else {
            snapVelocityThreshold2 = snapVelocityThreshold;
        }
        if ((i & 64) != 0) {
            snapPositionalThreshold2 = 0.5f;
        } else {
            snapPositionalThreshold2 = snapPositionalThreshold;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-705378306, $changed, -1, "androidx.compose.foundation.pager.PagerDefaults.flingBehavior (Pager.kt:522)");
        } else {
            int i2 = $changed;
        }
        if (0.0f > snapPositionalThreshold2 || snapPositionalThreshold2 > 1.0f) {
            z = false;
        }
        if (z) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density = (Density) consume;
            composer.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : new Object[]{state, lowVelocityAnimationSpec2, decayAnimationSpec, snapAnimationSpec2, pagerSnapDistance2, density}) {
                invalid$iv |= composer.changed(key$iv);
            }
            Composer $this$cache$iv$iv = $composer;
            Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv || value$iv$iv == Composer.Companion.getEmpty()) {
                Object obj = value$iv$iv;
                float f = snapPositionalThreshold2;
                DecayAnimationSpec<Float> decayAnimationSpec2 = decayAnimationSpec;
                value$iv$iv = new SnapFlingBehavior(PagerKt.SnapLayoutInfoProvider(pagerState, pagerSnapDistance2, decayAnimationSpec, snapPositionalThreshold2), lowVelocityAnimationSpec2, decayAnimationSpec, snapAnimationSpec2, density, snapVelocityThreshold2, (DefaultConstructorMarker) null);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                Object obj2 = value$iv$iv;
                float f2 = snapPositionalThreshold2;
                DecayAnimationSpec<Float> decayAnimationSpec3 = decayAnimationSpec;
            }
            $composer.endReplaceableGroup();
            SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) value$iv$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceableGroup();
            return snapFlingBehavior;
        }
        throw new IllegalArgumentException(("snapPositionalThreshold should be a number between 0 and 1. You've specified " + snapPositionalThreshold2).toString());
    }

    public final NestedScrollConnection pageNestedScrollConnection(Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == Orientation.Horizontal) {
            return PagerKt.ConsumeHorizontalFlingNestedScrollConnection;
        }
        return PagerKt.ConsumeVerticalFlingNestedScrollConnection;
    }
}

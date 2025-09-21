package androidx.compose.material;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.material.AnchoredDraggableState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0004\b\u0000\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR5\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00050\n8GX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128GX\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Landroidx/compose/material/AnchoredDraggableDefaults;", "", "()V", "AnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "getAnimationSpec$annotations", "getAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "positionalThreshold", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "totalDistance", "getPositionalThreshold$annotations", "getPositionalThreshold", "(Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function1;", "velocityThreshold", "Lkotlin/Function0;", "getVelocityThreshold$annotations", "getVelocityThreshold", "(Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "ReconcileAnimationOnAnchorChangedCallback", "Landroidx/compose/material/AnchoredDraggableState$AnchorChangedCallback;", "T", "state", "Landroidx/compose/material/AnchoredDraggableState;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "ReconcileAnimationOnAnchorChangedCallback$material_release", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
public final class AnchoredDraggableDefaults {
    private static final SpringSpec<Float> AnimationSpec = new SpringSpec(0.0f, 0.0f, (Object) null, 7, (DefaultConstructorMarker) null);
    public static final AnchoredDraggableDefaults INSTANCE = new AnchoredDraggableDefaults();

    public static /* synthetic */ void getAnimationSpec$annotations() {
    }

    public static /* synthetic */ void getPositionalThreshold$annotations() {
    }

    public static /* synthetic */ void getVelocityThreshold$annotations() {
    }

    private AnchoredDraggableDefaults() {
    }

    public final SpringSpec<Float> getAnimationSpec() {
        return AnimationSpec;
    }

    public final Function0<Float> getVelocityThreshold(Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(2030704141);
        ComposerKt.sourceInformation($composer, "C*654@26591L7,654@26602L17:AnchoredDraggable.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2030704141, $changed, -1, "androidx.compose.material.AnchoredDraggableDefaults.<get-velocityThreshold> (AnchoredDraggable.kt:654)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$_get_velocityThreshold__u24lambda_u241 = (Density) consume;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) $this$_get_velocityThreshold__u24lambda_u241);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function0) new AnchoredDraggableDefaults$velocityThreshold$1$1$1($this$_get_velocityThreshold__u24lambda_u241);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function0<Float> function0 = (Function0) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function0;
    }

    public final Function1<Float, Float> getPositionalThreshold(Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(82866976);
        ComposerKt.sourceInformation($composer, "C*663@26944L7,664@26967L16:AnchoredDraggable.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(82866976, $changed, -1, "androidx.compose.material.AnchoredDraggableDefaults.<get-positionalThreshold> (AnchoredDraggable.kt:663)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$_get_positionalThreshold__u24lambda_u243 = (Density) consume;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) $this$_get_positionalThreshold__u24lambda_u243);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function1) new AnchoredDraggableDefaults$positionalThreshold$1$1$1($this$_get_positionalThreshold__u24lambda_u243);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function1<Float, Float> function1 = (Function1) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function1;
    }

    public final <T> AnchoredDraggableState.AnchorChangedCallback<T> ReconcileAnimationOnAnchorChangedCallback$material_release(AnchoredDraggableState<T> state, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new AnchoredDraggableDefaults$ReconcileAnimationOnAnchorChangedCallback$1(scope, state);
    }
}

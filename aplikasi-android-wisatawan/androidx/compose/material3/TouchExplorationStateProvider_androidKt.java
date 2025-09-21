package androidx.compose.material3;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0003\u001a7\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0003¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"touchExplorationState", "Landroidx/compose/runtime/State;", "", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "ObserveState", "", "Landroidx/lifecycle/Lifecycle;", "handleEvent", "Lkotlin/Function1;", "Landroidx/lifecycle/Lifecycle$Event;", "onDispose", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TouchExplorationStateProvider.android.kt */
public final class TouchExplorationStateProvider_androidKt {
    public static final State<Boolean> touchExplorationState(Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Composer composer = $composer;
        composer.startReplaceableGroup(-906157724);
        ComposerKt.sourceInformation(composer, "C(touchExplorationState)41@1687L7,42@1726L104,46@1851L23,48@1900L7,48@1918L273,59@2204L52:TouchExplorationStateProvider.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-906157724, $changed, -1, "androidx.compose.material3.touchExplorationState (TouchExplorationStateProvider.android.kt:40)");
        } else {
            int i = $changed;
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Context context = (Context) consume;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            Object systemService = context.getSystemService("accessibility");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
            value$iv$iv = (AccessibilityManager) systemService;
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        AccessibilityManager accessibilityManager = (AccessibilityManager) value$iv$iv;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv2 = new Listener();
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        Listener listener = (Listener) value$iv$iv2;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Composer $this$cache$iv$iv3 = $composer;
        ObserveState(((LifecycleOwner) consume2).getLifecycle(), new TouchExplorationStateProvider_androidKt$touchExplorationState$1(listener, accessibilityManager), new TouchExplorationStateProvider_androidKt$touchExplorationState$2(listener, accessibilityManager), $this$cache$iv$iv3, 8, 0);
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
        if (it$iv$iv3 == Composer.Companion.getEmpty()) {
            value$iv$iv3 = SnapshotStateKt.derivedStateOf(new TouchExplorationStateProvider_androidKt$touchExplorationState$3$1(listener));
            $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
        } else {
            value$iv$iv3 = it$iv$iv3;
        }
        $composer.endReplaceableGroup();
        State<Boolean> state = (State) value$iv$iv3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return state;
    }

    /* access modifiers changed from: private */
    public static final void ObserveState(Lifecycle $this$ObserveState, Function1<? super Lifecycle.Event, Unit> handleEvent, Function0<Unit> onDispose, Composer $composer, int $changed, int i) {
        Composer $composer2 = $composer.startRestartGroup(-1703772404);
        ComposerKt.sourceInformation($composer2, "C(ObserveState)67@2396L288:TouchExplorationStateProvider.android.kt#uh7d8r");
        if ((i & 1) != 0) {
            handleEvent = TouchExplorationStateProvider_androidKt$ObserveState$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            onDispose = TouchExplorationStateProvider_androidKt$ObserveState$2.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1703772404, $changed, -1, "androidx.compose.material3.ObserveState (TouchExplorationStateProvider.android.kt:63)");
        }
        EffectsKt.DisposableEffect((Object) $this$ObserveState, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new TouchExplorationStateProvider_androidKt$ObserveState$3($this$ObserveState, handleEvent, onDispose), $composer2, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TouchExplorationStateProvider_androidKt$ObserveState$4($this$ObserveState, handleEvent, onDispose, $changed, i));
        }
    }
}

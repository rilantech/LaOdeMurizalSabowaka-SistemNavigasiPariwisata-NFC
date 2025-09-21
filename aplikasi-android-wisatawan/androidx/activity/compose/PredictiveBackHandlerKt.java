package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a]\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032A\u0010\u0004\u001a=\b\u0001\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f²\u0006E\u0010\u0010\u001a=\b\u0001\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005X\u0002"}, d2 = {"PredictiveBackHandler", "", "enabled", "", "onBack", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lkotlin/ParameterName;", "name", "progress", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "activity-compose_release", "currentOnBack"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PredictiveBackHandler.kt */
public final class PredictiveBackHandlerKt {
    public static final void PredictiveBackHandler(boolean enabled, Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object> onBack, Composer $composer, int $changed, int i) {
        boolean enabled2;
        Object value$iv$iv$iv;
        Object value$iv$iv;
        Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object> function2 = onBack;
        int i2 = i;
        Composer $composer2 = $composer.startRestartGroup(-642000585);
        ComposerKt.sourceInformation($composer2, "C(PredictiveBackHandler)77@3028L28,78@3079L24,80@3128L1954,126@5088L72,*130@5234L7,134@5422L7,136@5435L186:PredictiveBackHandler.kt#q1dkbc");
        int $dirty = $changed;
        if ((i2 & 1) != 0) {
            enabled2 = true;
        } else {
            enabled2 = enabled;
        }
        State currentOnBack$delegate = SnapshotStateKt.rememberUpdatedState(function2, $composer2, 8);
        $composer2.startReplaceableGroup(-723524056);
        ComposerKt.sourceInformation($composer2, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
        Composer composer$iv = $composer2;
        $composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv$iv = $composer2;
        Object it$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
        if (it$iv$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer$iv));
            $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
        } else {
            value$iv$iv$iv = it$iv$iv$iv;
        }
        $composer2.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv).getCoroutineScope();
        $composer2.endReplaceableGroup();
        CoroutineScope onBackScope = coroutineScope;
        $composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer2;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1(enabled2, onBackScope, currentOnBack$delegate);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer2.endReplaceableGroup();
        PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 backCallBack = (PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1) value$iv$iv;
        EffectsKt.LaunchedEffect((Object) Boolean.valueOf(enabled2), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new PredictiveBackHandlerKt$PredictiveBackHandler$1(backCallBack, enabled2, (Continuation<? super PredictiveBackHandlerKt$PredictiveBackHandler$1>) null), $composer2, ($dirty & 14) | 64);
        OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent($composer2, 6);
        if (current != null) {
            OnBackPressedDispatcher backDispatcher = current.getOnBackPressedDispatcher();
            ComposerKt.sourceInformationMarkerStart($composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LifecycleOwner lifecycleOwner = (LifecycleOwner) consume;
            EffectsKt.DisposableEffect(lifecycleOwner, backDispatcher, new PredictiveBackHandlerKt$PredictiveBackHandler$2(backDispatcher, lifecycleOwner, backCallBack), $composer2, 72);
            ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
                int i3 = $changed;
            } else {
                endRestartGroup.updateScope(new PredictiveBackHandlerKt$PredictiveBackHandler$3(enabled2, function2, $changed, i2));
            }
        } else {
            int i4 = $changed;
            throw new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner".toString());
        }
    }

    /* access modifiers changed from: private */
    public static final Function2<Flow<BackEventCompat>, Continuation<Unit>, Object> PredictiveBackHandler$lambda$0(State<? extends Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object>> $currentOnBack$delegate) {
        return (Function2) $currentOnBack$delegate.getValue();
    }
}

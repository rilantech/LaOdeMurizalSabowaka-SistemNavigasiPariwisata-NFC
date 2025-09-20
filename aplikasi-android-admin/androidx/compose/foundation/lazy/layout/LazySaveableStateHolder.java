package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B/\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\tB\r\u0012\u0006\u0010\n\u001a\u00020\u0001¢\u0006\u0002\u0010\u000bJ(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00170\u001a¢\u0006\u0002\b\u001bH\u0017¢\u0006\u0002\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0001J\u0013\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0006H\u0001J\u001c\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0005H\u0016J!\u0010\"\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00062\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001aH\u0001J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0016R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0004¢\u0006\u0002\n\u0000R/\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00028F@FX\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\n\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "parentRegistry", "restoredValues", "", "", "", "", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;Ljava/util/Map;)V", "wrappedRegistry", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;)V", "previouslyComposedKeys", "", "<set-?>", "wrappedHolder", "getWrappedHolder", "()Landroidx/compose/runtime/saveable/SaveableStateHolder;", "setWrappedHolder", "(Landroidx/compose/runtime/saveable/SaveableStateHolder;)V", "wrappedHolder$delegate", "Landroidx/compose/runtime/MutableState;", "SaveableStateProvider", "", "key", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "canBeSaved", "", "value", "consumeRestored", "performSave", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "removeState", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazySaveableStateHolder.kt */
final class LazySaveableStateHolder implements SaveableStateRegistry, SaveableStateHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final Set<Object> previouslyComposedKeys;
    private final MutableState wrappedHolder$delegate;
    private final SaveableStateRegistry wrappedRegistry;

    public boolean canBeSaved(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        return this.wrappedRegistry.canBeSaved(obj);
    }

    public Object consumeRestored(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.wrappedRegistry.consumeRestored(str);
    }

    public SaveableStateRegistry.Entry registerProvider(String str, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(function0, "valueProvider");
        return this.wrappedRegistry.registerProvider(str, function0);
    }

    public LazySaveableStateHolder(SaveableStateRegistry wrappedRegistry2) {
        Intrinsics.checkNotNullParameter(wrappedRegistry2, "wrappedRegistry");
        this.wrappedRegistry = wrappedRegistry2;
        this.wrappedHolder$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.previouslyComposedKeys = new LinkedHashSet();
    }

    public LazySaveableStateHolder(final SaveableStateRegistry parentRegistry, Map<String, ? extends List<? extends Object>> restoredValues) {
        this(SaveableStateRegistryKt.SaveableStateRegistry(restoredValues, new Function1<Object, Boolean>() {
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SaveableStateRegistry saveableStateRegistry = parentRegistry;
                return Boolean.valueOf(saveableStateRegistry != null ? saveableStateRegistry.canBeSaved(it) : true);
            }
        }));
    }

    public final SaveableStateHolder getWrappedHolder() {
        return (SaveableStateHolder) this.wrappedHolder$delegate.getValue();
    }

    public final void setWrappedHolder(SaveableStateHolder saveableStateHolder) {
        this.wrappedHolder$delegate.setValue(saveableStateHolder);
    }

    public Map<String, List<Object>> performSave() {
        SaveableStateHolder holder = getWrappedHolder();
        if (holder != null) {
            for (Object element$iv : this.previouslyComposedKeys) {
                holder.removeState(element$iv);
            }
        }
        return this.wrappedRegistry.performSave();
    }

    public void SaveableStateProvider(Object key, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-697180401);
        ComposerKt.sourceInformation($composer2, "C(SaveableStateProvider)P(1)83@3415L35,84@3459L159:LazySaveableStateHolder.kt#wow0x6");
        int $dirty = $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-697180401, $dirty, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.SaveableStateProvider (LazySaveableStateHolder.kt:82)");
        }
        SaveableStateHolder wrappedHolder = getWrappedHolder();
        if (wrappedHolder != null) {
            wrappedHolder.SaveableStateProvider(key, content, $composer2, ($dirty & 112) | 520);
            EffectsKt.DisposableEffect(key, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new LazySaveableStateHolder$SaveableStateProvider$1(this, key), $composer2, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new LazySaveableStateHolder$SaveableStateProvider$2(this, key, content, $changed));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public void removeState(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        SaveableStateHolder wrappedHolder = getWrappedHolder();
        if (wrappedHolder != null) {
            wrappedHolder.removeState(key);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b0\u00060\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder$Companion;", "", "()V", "saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder;", "", "", "", "parentRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazySaveableStateHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<LazySaveableStateHolder, Map<String, List<Object>>> saver(SaveableStateRegistry parentRegistry) {
            return SaverKt.Saver(LazySaveableStateHolder$Companion$saver$1.INSTANCE, new LazySaveableStateHolder$Companion$saver$2(parentRegistry));
        }
    }
}

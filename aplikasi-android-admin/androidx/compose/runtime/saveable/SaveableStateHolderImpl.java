package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB/\u0012(\b\u0002\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00070\u00050\u0003¢\u0006\u0002\u0010\bJ(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0015¢\u0006\u0002\b\u0016H\u0017¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J*\u0010\u0019\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00070\u0005\u0018\u00010\u0003H\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0010R\u00020\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R.\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00070\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/runtime/saveable/SaveableStateHolderImpl;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "savedStates", "", "", "", "", "", "(Ljava/util/Map;)V", "parentSaveableStateRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "getParentSaveableStateRegistry", "()Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "setParentSaveableStateRegistry", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;)V", "registryHolders", "Landroidx/compose/runtime/saveable/SaveableStateHolderImpl$RegistryHolder;", "SaveableStateProvider", "", "key", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "removeState", "saveAll", "Companion", "RegistryHolder", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SaveableStateHolder.kt */
final class SaveableStateHolderImpl implements SaveableStateHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Saver<SaveableStateHolderImpl, ?> Saver = SaverKt.Saver(SaveableStateHolderImpl$Companion$Saver$1.INSTANCE, SaveableStateHolderImpl$Companion$Saver$2.INSTANCE);
    private SaveableStateRegistry parentSaveableStateRegistry;
    /* access modifiers changed from: private */
    public final Map<Object, RegistryHolder> registryHolders;
    /* access modifiers changed from: private */
    public final Map<Object, Map<String, List<Object>>> savedStates;

    public SaveableStateHolderImpl() {
        this((Map) null, 1, (DefaultConstructorMarker) null);
    }

    public SaveableStateHolderImpl(Map<Object, Map<String, List<Object>>> savedStates2) {
        Intrinsics.checkNotNullParameter(savedStates2, "savedStates");
        this.savedStates = savedStates2;
        this.registryHolders = new LinkedHashMap();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SaveableStateHolderImpl(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LinkedHashMap() : map);
    }

    public final SaveableStateRegistry getParentSaveableStateRegistry() {
        return this.parentSaveableStateRegistry;
    }

    public final void setParentSaveableStateRegistry(SaveableStateRegistry saveableStateRegistry) {
        this.parentSaveableStateRegistry = saveableStateRegistry;
    }

    public void SaveableStateProvider(Object key, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object obj = key;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        Intrinsics.checkNotNullParameter(obj, "key");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-1198538093);
        ComposerKt.sourceInformation($composer2, "C(SaveableStateProvider)P(1)75@2967L923:SaveableStateHolder.kt#r2ddri");
        int $dirty = $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1198538093, $dirty, -1, "androidx.compose.runtime.saveable.SaveableStateHolderImpl.SaveableStateProvider (SaveableStateHolder.kt:74)");
        }
        $composer2.startReplaceableGroup(444418301);
        ComposerKt.sourceInformation($composer2, "CC(ReusableContent)P(1)145@5313L9:Composables.kt#9igjgp");
        $composer2.startReusableGroup(ComposerKt.reuseKey, obj);
        int i = (8 >> 3) & 14;
        Composer $composer3 = $composer2;
        ComposerKt.sourceInformationMarkerStart($composer3, 1516495192, "C76@3023L321,83@3357L150,87@3520L360:SaveableStateHolder.kt#r2ddri");
        $composer3.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer3;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            SaveableStateRegistry parentSaveableStateRegistry2 = getParentSaveableStateRegistry();
            if (parentSaveableStateRegistry2 != null ? parentSaveableStateRegistry2.canBeSaved(obj) : true) {
                value$iv$iv = new RegistryHolder(this, obj);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                Object obj2 = it$iv$iv;
            } else {
                Object obj3 = it$iv$iv;
                throw new IllegalArgumentException(("Type of the key " + obj + " is not supported. On Android you can only use types which can be stored inside the Bundle.").toString());
            }
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer3.endReplaceableGroup();
        RegistryHolder registryHolder = (RegistryHolder) value$iv$iv;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(registryHolder.getRegistry())}, function2, $composer3, ($dirty & 112) | 8);
        EffectsKt.DisposableEffect((Object) Unit.INSTANCE, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new SaveableStateHolderImpl$SaveableStateProvider$1$1(this, obj, registryHolder), $composer3, 6);
        ComposerKt.sourceInformationMarkerEnd($composer3);
        $composer2.endReusableGroup();
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i2 = $changed;
        } else {
            endRestartGroup.updateScope(new SaveableStateHolderImpl$SaveableStateProvider$2(this, obj, function2, $changed));
        }
    }

    /* access modifiers changed from: private */
    public final Map<Object, Map<String, List<Object>>> saveAll() {
        Map map = MapsKt.toMutableMap(this.savedStates);
        for (RegistryHolder it : this.registryHolders.values()) {
            it.saveTo(map);
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    public void removeState(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        RegistryHolder registryHolder = this.registryHolders.get(key);
        if (registryHolder != null) {
            registryHolder.setShouldSave(false);
        } else {
            this.savedStates.remove(key);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J.\u0010\u0010\u001a\u00020\u00112&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0015\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00160\u00140\u0013R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/saveable/SaveableStateHolderImpl$RegistryHolder;", "", "key", "(Landroidx/compose/runtime/saveable/SaveableStateHolderImpl;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "registry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "getRegistry", "()Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "shouldSave", "", "getShouldSave", "()Z", "setShouldSave", "(Z)V", "saveTo", "", "map", "", "", "", "", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SaveableStateHolder.kt */
    public final class RegistryHolder {
        private final Object key;
        private final SaveableStateRegistry registry;
        private boolean shouldSave = true;
        final /* synthetic */ SaveableStateHolderImpl this$0;

        public RegistryHolder(SaveableStateHolderImpl this$02, Object key2) {
            Intrinsics.checkNotNullParameter(key2, "key");
            this.this$0 = this$02;
            this.key = key2;
            this.registry = SaveableStateRegistryKt.SaveableStateRegistry((Map) this$02.savedStates.get(key2), new SaveableStateHolderImpl$RegistryHolder$registry$1(this$02));
        }

        public final Object getKey() {
            return this.key;
        }

        public final boolean getShouldSave() {
            return this.shouldSave;
        }

        public final void setShouldSave(boolean z) {
            this.shouldSave = z;
        }

        public final SaveableStateRegistry getRegistry() {
            return this.registry;
        }

        public final void saveTo(Map<Object, Map<String, List<Object>>> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            if (this.shouldSave) {
                Map savedData = this.registry.performSave();
                if (savedData.isEmpty()) {
                    map.remove(this.key);
                } else {
                    map.put(this.key, savedData);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/saveable/SaveableStateHolderImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/runtime/saveable/SaveableStateHolderImpl;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SaveableStateHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<SaveableStateHolderImpl, ?> getSaver() {
            return SaveableStateHolderImpl.Saver;
        }
    }
}

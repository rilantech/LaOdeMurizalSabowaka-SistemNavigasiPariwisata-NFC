package androidx.compose.runtime.internal;

import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMapKt;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.State;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00172\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u00012\u00020\u0005:\u0002\u0016\u0017B1\u0012\"\u0010\u0006\u001a\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0002H\u0002¢\u0006\u0002\u0010\u0015R6\u0010\u000b\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\r0\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "size", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "entries", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "", "getEntries", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "builder", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Builder;", "get", "T", "key", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "Builder", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PersistentCompositionLocalMap.kt */
public final class PersistentCompositionLocalHashMap extends PersistentHashMap<CompositionLocal<Object>, State<? extends Object>> implements PersistentCompositionLocalMap {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final PersistentCompositionLocalHashMap Empty;

    public /* bridge */ boolean containsKey(CompositionLocal<Object> key) {
        return super.containsKey(key);
    }

    public final /* bridge */ boolean containsKey(Object key) {
        if (!(key instanceof CompositionLocal)) {
            return false;
        }
        return containsKey((CompositionLocal<Object>) (CompositionLocal) key);
    }

    public /* bridge */ boolean containsValue(State<? extends Object> value) {
        return super.containsValue(value);
    }

    public final /* bridge */ boolean containsValue(Object value) {
        if (!(value instanceof State)) {
            return false;
        }
        return containsValue((State<? extends Object>) (State) value);
    }

    public /* bridge */ State<Object> get(CompositionLocal<Object> key) {
        return (State) super.get(key);
    }

    public final /* bridge */ State<Object> get(Object key) {
        if (!(key instanceof CompositionLocal)) {
            return null;
        }
        return get((CompositionLocal<Object>) (CompositionLocal) key);
    }

    public /* bridge */ State<Object> getOrDefault(CompositionLocal<Object> key, State<? extends Object> defaultValue) {
        return (State) super.getOrDefault(key, defaultValue);
    }

    public final /* bridge */ State getOrDefault(Object key, State defaultValue) {
        return !(key instanceof CompositionLocal) ? defaultValue : getOrDefault((CompositionLocal<Object>) (CompositionLocal) key, (State<? extends Object>) defaultValue);
    }

    public final /* bridge */ /* synthetic */ Object getOrDefault(Object key, Object defaultValue) {
        return !(key instanceof CompositionLocal) ? defaultValue : getOrDefault((CompositionLocal<Object>) (CompositionLocal) key, (State<? extends Object>) (State) defaultValue);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersistentCompositionLocalHashMap(TrieNode<CompositionLocal<Object>, State<Object>> node, int size) {
        super(node, size);
        Intrinsics.checkNotNullParameter(node, "node");
    }

    public ImmutableSet<Map.Entry<CompositionLocal<Object>, State<Object>>> getEntries() {
        return super.getEntries();
    }

    public <T> T get(CompositionLocal<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return CompositionLocalMapKt.read(this, key);
    }

    public Builder builder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u00012\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Builder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/PersistentCompositionLocalMap$Builder;", "map", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "(Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;)V", "getMap$runtime_release", "()Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "setMap$runtime_release", "build", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PersistentCompositionLocalMap.kt */
    public static final class Builder extends PersistentHashMapBuilder<CompositionLocal<Object>, State<? extends Object>> implements PersistentCompositionLocalMap.Builder {
        public static final int $stable = 8;
        private PersistentCompositionLocalHashMap map;

        public /* bridge */ boolean containsKey(CompositionLocal<Object> key) {
            return super.containsKey(key);
        }

        public final /* bridge */ boolean containsKey(Object key) {
            if (!(key instanceof CompositionLocal)) {
                return false;
            }
            return containsKey((CompositionLocal<Object>) (CompositionLocal) key);
        }

        public /* bridge */ boolean containsValue(State<? extends Object> value) {
            return super.containsValue(value);
        }

        public final /* bridge */ boolean containsValue(Object value) {
            if (!(value instanceof State)) {
                return false;
            }
            return containsValue((State<? extends Object>) (State) value);
        }

        public /* bridge */ State<Object> get(CompositionLocal<Object> key) {
            return (State) super.get(key);
        }

        public final /* bridge */ State<Object> get(Object key) {
            if (!(key instanceof CompositionLocal)) {
                return null;
            }
            return get((CompositionLocal<Object>) (CompositionLocal) key);
        }

        public /* bridge */ State<Object> getOrDefault(CompositionLocal<Object> key, State<? extends Object> defaultValue) {
            return (State) super.getOrDefault(key, defaultValue);
        }

        public final /* bridge */ State getOrDefault(Object key, State defaultValue) {
            return !(key instanceof CompositionLocal) ? defaultValue : getOrDefault((CompositionLocal<Object>) (CompositionLocal) key, (State<? extends Object>) defaultValue);
        }

        public final /* bridge */ /* synthetic */ Object getOrDefault(Object key, Object defaultValue) {
            return !(key instanceof CompositionLocal) ? defaultValue : getOrDefault((CompositionLocal<Object>) (CompositionLocal) key, (State<? extends Object>) (State) defaultValue);
        }

        public /* bridge */ State<Object> remove(CompositionLocal<Object> key) {
            return (State) super.remove(key);
        }

        public final /* bridge */ State<Object> remove(Object key) {
            if (!(key instanceof CompositionLocal)) {
                return null;
            }
            return remove((CompositionLocal<Object>) (CompositionLocal) key);
        }

        public final PersistentCompositionLocalHashMap getMap$runtime_release() {
            return this.map;
        }

        public final void setMap$runtime_release(PersistentCompositionLocalHashMap persistentCompositionLocalHashMap) {
            Intrinsics.checkNotNullParameter(persistentCompositionLocalHashMap, "<set-?>");
            this.map = persistentCompositionLocalHashMap;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(PersistentCompositionLocalHashMap map2) {
            super(map2);
            Intrinsics.checkNotNullParameter(map2, "map");
            this.map = map2;
        }

        public PersistentCompositionLocalHashMap build() {
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMap;
            if (getNode$runtime_release() == this.map.getNode$runtime_release()) {
                persistentCompositionLocalHashMap = this.map;
            } else {
                setOwnership(new MutabilityOwnership());
                persistentCompositionLocalHashMap = new PersistentCompositionLocalHashMap(getNode$runtime_release(), size());
            }
            this.map = persistentCompositionLocalHashMap;
            return persistentCompositionLocalHashMap;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Companion;", "", "()V", "Empty", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "getEmpty$annotations", "getEmpty", "()Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PersistentCompositionLocalMap.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getEmpty$annotations() {
        }

        private Companion() {
        }

        public final PersistentCompositionLocalHashMap getEmpty() {
            return PersistentCompositionLocalHashMap.Empty;
        }
    }

    static {
        TrieNode eMPTY$runtime_release = TrieNode.Companion.getEMPTY$runtime_release();
        Intrinsics.checkNotNull(eMPTY$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>");
        Empty = new PersistentCompositionLocalHashMap(eMPTY$runtime_release, 0);
    }
}

package androidx.compose.runtime.external.kotlinx.collections.immutable.adapters;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00028\u0001H\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\u0003¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u000fH\u0016J\t\u0010\"\u001a\u00020\u0017H\u0001J\b\u0010#\u001a\u00020$H\u0016R&\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/adapters/ImmutableMapAdapter;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableMap;", "", "impl", "(Ljava/util/Map;)V", "entries", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "", "getEntries", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "getValues", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "isEmpty", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ReadOnlyCollectionAdapters.kt */
public final class ImmutableMapAdapter<K, V> implements ImmutableMap<K, V>, Map<K, V>, KMappedMarker {
    private final ImmutableSet<Map.Entry<K, V>> entries;
    private final Map<K, V> impl;
    private final ImmutableSet<K> keys;
    private final ImmutableCollection<V> values;

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public V compute(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(Object obj) {
        return this.impl.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.impl.containsValue(obj);
    }

    public V get(Object obj) {
        return this.impl.get(obj);
    }

    public int getSize() {
        return this.impl.size();
    }

    public boolean isEmpty() {
        return this.impl.isEmpty();
    }

    public V merge(K k, V v, BiFunction<? super V, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public V put(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public V putIfAbsent(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public V replace(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean replace(K k, V v, V v2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public ImmutableMapAdapter(Map<K, ? extends V> impl2) {
        Intrinsics.checkNotNullParameter(impl2, "impl");
        this.impl = impl2;
        this.keys = new ImmutableSetAdapter(impl2.keySet());
        this.values = new ImmutableCollectionAdapter(impl2.values());
        this.entries = new ImmutableSetAdapter(impl2.entrySet());
    }

    public final /* bridge */ ImmutableSet<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public final /* bridge */ ImmutableSet<K> keySet() {
        return getKeys();
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ ImmutableCollection<V> values() {
        return getValues();
    }

    public ImmutableSet<K> getKeys() {
        return this.keys;
    }

    public ImmutableCollection<V> getValues() {
        return this.values;
    }

    public ImmutableSet<Map.Entry<K, V>> getEntries() {
        return this.entries;
    }

    public boolean equals(Object other) {
        return this.impl.equals(other);
    }

    public int hashCode() {
        return this.impl.hashCode();
    }

    public String toString() {
        return this.impl.toString();
    }
}

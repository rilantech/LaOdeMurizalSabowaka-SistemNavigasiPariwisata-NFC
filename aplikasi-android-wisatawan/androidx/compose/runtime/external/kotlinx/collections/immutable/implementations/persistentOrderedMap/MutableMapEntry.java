package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.MapEntry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B5\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0002\u0010\nJ\u0015\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/MutableMapEntry;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/MapEntry;", "", "mutableMap", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "key", "links", "(Ljava/util/Map;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;)V", "value", "getValue", "()Ljava/lang/Object;", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PersistentOrderedMapBuilderContentIterators.kt */
final class MutableMapEntry<K, V> extends MapEntry<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
    private LinkedValue<V> links;
    private final Map<K, LinkedValue<V>> mutableMap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutableMapEntry(Map<K, LinkedValue<V>> mutableMap2, K key, LinkedValue<V> links2) {
        super(key, links2.getValue());
        Intrinsics.checkNotNullParameter(mutableMap2, "mutableMap");
        Intrinsics.checkNotNullParameter(links2, "links");
        this.mutableMap = mutableMap2;
        this.links = links2;
    }

    public V getValue() {
        return this.links.getValue();
    }

    public V setValue(V newValue) {
        Object result = this.links.getValue();
        this.links = this.links.withValue(newValue);
        this.mutableMap.put(getKey(), this.links);
        return result;
    }
}

package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0016R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetIterator;", "E", "", "nextElement", "", "map", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "(Ljava/lang/Object;Ljava/util/Map;)V", "index", "", "getIndex$runtime_release", "()I", "setIndex$runtime_release", "(I)V", "getMap$runtime_release", "()Ljava/util/Map;", "checkHasNext", "", "hasNext", "", "next", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PersistentOrderedSetIterator.kt */
public class PersistentOrderedSetIterator<E> implements Iterator<E>, KMappedMarker {
    private int index;
    private final Map<E, Links> map;
    private Object nextElement;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public PersistentOrderedSetIterator(Object nextElement2, Map<E, Links> map2) {
        Intrinsics.checkNotNullParameter(map2, "map");
        this.nextElement = nextElement2;
        this.map = map2;
    }

    public final Map<E, Links> getMap$runtime_release() {
        return this.map;
    }

    public final int getIndex$runtime_release() {
        return this.index;
    }

    public final void setIndex$runtime_release(int i) {
        this.index = i;
    }

    public boolean hasNext() {
        return this.index < this.map.size();
    }

    public E next() {
        checkHasNext();
        Object result = this.nextElement;
        this.index++;
        Links links = this.map.get(result);
        if (links != null) {
            this.nextElement = links.getNext();
            return result;
        }
        throw new ConcurrentModificationException("Hash code of an element (" + result + ") has changed after it was added to the persistent set.");
    }

    private final void checkHasNext() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }
}

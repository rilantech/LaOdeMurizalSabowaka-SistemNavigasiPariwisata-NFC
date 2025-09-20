package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\t\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0013\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\r\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0015\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u001a\u001a\u00020\rH\u0002R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/snapshots/StateListIterator;", "T", "", "list", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "offset", "", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;I)V", "index", "getList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "modification", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "validateModification", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateList.kt */
final class StateListIterator<T> implements ListIterator<T>, KMutableListIterator {
    private int index;
    private final SnapshotStateList<T> list;
    private int modification;

    public StateListIterator(SnapshotStateList<T> list2, int offset) {
        Intrinsics.checkNotNullParameter(list2, "list");
        this.list = list2;
        this.index = offset - 1;
        this.modification = list2.getModification$runtime_release();
    }

    public final SnapshotStateList<T> getList() {
        return this.list;
    }

    public boolean hasPrevious() {
        return this.index >= 0;
    }

    public int nextIndex() {
        return this.index + 1;
    }

    public T previous() {
        validateModification();
        SnapshotStateListKt.validateRange(this.index, this.list.size());
        T t = this.list.get(this.index);
        T t2 = t;
        this.index--;
        return t;
    }

    public int previousIndex() {
        return this.index;
    }

    public void add(T element) {
        validateModification();
        this.list.add(this.index + 1, element);
        this.index++;
        this.modification = this.list.getModification$runtime_release();
    }

    public boolean hasNext() {
        return this.index < this.list.size() - 1;
    }

    public T next() {
        validateModification();
        int newIndex = this.index + 1;
        SnapshotStateListKt.validateRange(newIndex, this.list.size());
        T t = this.list.get(newIndex);
        T t2 = t;
        this.index = newIndex;
        return t;
    }

    public void remove() {
        validateModification();
        this.list.remove(this.index);
        this.index--;
        this.modification = this.list.getModification$runtime_release();
    }

    public void set(T element) {
        validateModification();
        this.list.set(this.index, element);
        this.modification = this.list.getModification$runtime_release();
    }

    private final void validateModification() {
        if (this.list.getModification$runtime_release() != this.modification) {
            throw new ConcurrentModificationException();
        }
    }
}

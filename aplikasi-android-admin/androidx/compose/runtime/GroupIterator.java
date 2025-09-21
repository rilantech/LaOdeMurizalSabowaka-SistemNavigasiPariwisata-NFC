package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0010H\u0002J\t\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/GroupIterator;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "table", "Landroidx/compose/runtime/SlotTable;", "start", "", "end", "(Landroidx/compose/runtime/SlotTable;II)V", "getEnd", "()I", "index", "getTable", "()Landroidx/compose/runtime/SlotTable;", "version", "hasNext", "", "next", "validateRead", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTable.kt */
final class GroupIterator implements Iterator<CompositionGroup>, KMappedMarker {
    private final int end;
    private int index;
    private final SlotTable table;
    private final int version;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public GroupIterator(SlotTable table2, int start, int end2) {
        Intrinsics.checkNotNullParameter(table2, "table");
        this.table = table2;
        this.end = end2;
        this.index = start;
        this.version = table2.getVersion$runtime_release();
        if (table2.getWriter$runtime_release()) {
            throw new ConcurrentModificationException();
        }
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final int getEnd() {
        return this.end;
    }

    public boolean hasNext() {
        return this.index < this.end;
    }

    public CompositionGroup next() {
        validateRead();
        int group = this.index;
        this.index += SlotTableKt.groupSize(this.table.getGroups(), group);
        return new SlotTableGroup(this.table, group, this.version);
    }

    private final void validateRead() {
        if (this.table.getVersion$runtime_release() != this.version) {
            throw new ConcurrentModificationException();
        }
    }
}

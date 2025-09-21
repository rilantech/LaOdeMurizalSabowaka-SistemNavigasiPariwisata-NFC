package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\n\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000289B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\u0016\u0010\u0016\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\u0018\u0010\u001a\u001a\u00020\u001bH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u0006\u0010 \u001a\u00020\u0014J$\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00142\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110%J,\u0010&\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(2\u0006\u0010#\u001a\u00020\u00142\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110%J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\u0016\u0010+\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(2\u0006\u0010#\u001a\u00020\u0014J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000200H\u0016J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0002002\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u00101\u001a\u00020\u0011H\u0002J\u001a\u00102\u001a\u00020\u00112\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110%H\bø\u0001\u0003J,\u00104\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(2\u0006\u0010#\u001a\u00020\u00142\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110%J\u001e\u00105\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000f\u0002\u0016\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006:"}, d2 = {"Landroidx/compose/ui/node/HitTestResult;", "", "Landroidx/compose/ui/Modifier$Node;", "()V", "distanceFromEdgeAndInLayer", "", "hitDepth", "", "<set-?>", "size", "getSize", "()I", "values", "", "", "[Ljava/lang/Object;", "acceptHits", "", "clear", "contains", "", "element", "containsAll", "elements", "", "ensureContainerSize", "findBestHitDistance", "Landroidx/compose/ui/node/DistanceAndInLayer;", "findBestHitDistance-ptXAw2c", "()J", "get", "index", "hasHit", "hit", "node", "isInLayer", "childHitTest", "Lkotlin/Function0;", "hitInMinimumTouchTarget", "distanceFromEdge", "", "indexOf", "isEmpty", "isHitInMinimumTouchTargetBetter", "iterator", "", "lastIndexOf", "listIterator", "", "resizeToHitDepth", "siblingHits", "block", "speculativeHit", "subList", "fromIndex", "toIndex", "HitTestResultIterator", "SubList", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HitTestResult.kt */
public final class HitTestResult implements List<Modifier.Node>, KMappedMarker {
    private long[] distanceFromEdgeAndInLayer = new long[16];
    /* access modifiers changed from: private */
    public int hitDepth = -1;
    private int size;
    /* access modifiers changed from: private */
    public Object[] values = new Object[16];

    public void add(int i, Modifier.Node node) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Modifier.Node node) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i, Collection<? extends Modifier.Node> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends Modifier.Node> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Modifier.Node remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(UnaryOperator<Modifier.Node> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Modifier.Node set(int i, Modifier.Node node) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void sort(Comparator<? super Modifier.Node> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    public final /* bridge */ boolean contains(Object element) {
        if (!(element instanceof Modifier.Node)) {
            return false;
        }
        return contains((Modifier.Node) element);
    }

    public final /* bridge */ int indexOf(Object element) {
        if (!(element instanceof Modifier.Node)) {
            return -1;
        }
        return indexOf((Modifier.Node) element);
    }

    public final /* bridge */ int lastIndexOf(Object element) {
        if (!(element instanceof Modifier.Node)) {
            return -1;
        }
        return lastIndexOf((Modifier.Node) element);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public int getSize() {
        return this.size;
    }

    public final boolean hasHit() {
        long distance = m6522findBestHitDistanceptXAw2c();
        return DistanceAndInLayer.m6517getDistanceimpl(distance) < 0.0f && DistanceAndInLayer.m6519isInLayerimpl(distance);
    }

    public final void acceptHits() {
        this.hitDepth = size() - 1;
    }

    private final void resizeToHitDepth() {
        int i = this.hitDepth + 1;
        int lastIndex = CollectionsKt.getLastIndex(this);
        if (i <= lastIndex) {
            while (true) {
                this.values[i] = null;
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        this.size = this.hitDepth + 1;
    }

    public final boolean isHitInMinimumTouchTargetBetter(float distanceFromEdge, boolean isInLayer) {
        if (this.hitDepth == CollectionsKt.getLastIndex(this)) {
            return true;
        }
        if (DistanceAndInLayer.m6513compareToS_HNhKs(m6522findBestHitDistanceptXAw2c(), HitTestResultKt.DistanceAndInLayer(distanceFromEdge, isInLayer)) > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: findBestHitDistance-ptXAw2c  reason: not valid java name */
    private final long m6522findBestHitDistanceptXAw2c() {
        long bestDistance = HitTestResultKt.DistanceAndInLayer(Float.POSITIVE_INFINITY, false);
        int i = this.hitDepth + 1;
        int lastIndex = CollectionsKt.getLastIndex(this);
        if (i <= lastIndex) {
            while (true) {
                long distance = DistanceAndInLayer.m6514constructorimpl(this.distanceFromEdgeAndInLayer[i]);
                bestDistance = DistanceAndInLayer.m6513compareToS_HNhKs(distance, bestDistance) < 0 ? distance : bestDistance;
                if (DistanceAndInLayer.m6517getDistanceimpl(bestDistance) >= 0.0f || !DistanceAndInLayer.m6519isInLayerimpl(bestDistance)) {
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                } else {
                    return bestDistance;
                }
            }
        }
        return bestDistance;
    }

    public final void hit(Modifier.Node node, boolean isInLayer, Function0<Unit> childHitTest) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(childHitTest, "childHitTest");
        hitInMinimumTouchTarget(node, -1.0f, isInLayer, childHitTest);
    }

    public final void hitInMinimumTouchTarget(Modifier.Node node, float distanceFromEdge, boolean isInLayer, Function0<Unit> childHitTest) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(childHitTest, "childHitTest");
        int startDepth = this.hitDepth;
        this.hitDepth++;
        ensureContainerSize();
        Object[] objArr = this.values;
        int i = this.hitDepth;
        objArr[i] = node;
        this.distanceFromEdgeAndInLayer[i] = HitTestResultKt.DistanceAndInLayer(distanceFromEdge, isInLayer);
        resizeToHitDepth();
        childHitTest.invoke();
        this.hitDepth = startDepth;
    }

    public final void speculativeHit(Modifier.Node node, float distanceFromEdge, boolean isInLayer, Function0<Unit> childHitTest) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(childHitTest, "childHitTest");
        if (this.hitDepth == CollectionsKt.getLastIndex(this)) {
            hitInMinimumTouchTarget(node, distanceFromEdge, isInLayer, childHitTest);
            if (this.hitDepth + 1 == CollectionsKt.getLastIndex(this)) {
                resizeToHitDepth();
                return;
            }
            return;
        }
        long previousDistance = m6522findBestHitDistanceptXAw2c();
        int previousHitDepth = this.hitDepth;
        this.hitDepth = CollectionsKt.getLastIndex(this);
        hitInMinimumTouchTarget(node, distanceFromEdge, isInLayer, childHitTest);
        if (this.hitDepth + 1 < CollectionsKt.getLastIndex(this) && DistanceAndInLayer.m6513compareToS_HNhKs(previousDistance, m6522findBestHitDistanceptXAw2c()) > 0) {
            int fromIndex = this.hitDepth + 1;
            int toIndex = previousHitDepth + 1;
            Object[] objArr = this.values;
            ArraysKt.copyInto((T[]) objArr, (T[]) objArr, toIndex, fromIndex, size());
            long[] jArr = this.distanceFromEdgeAndInLayer;
            ArraysKt.copyInto(jArr, jArr, toIndex, fromIndex, size());
            this.hitDepth = ((size() + previousHitDepth) - this.hitDepth) - 1;
        }
        resizeToHitDepth();
        this.hitDepth = previousHitDepth;
    }

    public final void siblingHits(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int depth = this.hitDepth;
        block.invoke();
        this.hitDepth = depth;
    }

    private final void ensureContainerSize() {
        int i = this.hitDepth;
        Object[] objArr = this.values;
        if (i >= objArr.length) {
            int newSize = objArr.length + 16;
            Object[] copyOf = Arrays.copyOf(objArr, newSize);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.values = copyOf;
            long[] copyOf2 = Arrays.copyOf(this.distanceFromEdgeAndInLayer, newSize);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.distanceFromEdgeAndInLayer = copyOf2;
        }
    }

    public boolean contains(Modifier.Node element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return indexOf((Object) element) != -1;
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            if (!contains((Object) (Modifier.Node) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Modifier.Node get(int index) {
        Object obj = this.values[index];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
        return (Modifier.Node) obj;
    }

    public int indexOf(Modifier.Node element) {
        Intrinsics.checkNotNullParameter(element, "element");
        int i = 0;
        int lastIndex = CollectionsKt.getLastIndex(this);
        if (0 > lastIndex) {
            return -1;
        }
        while (!Intrinsics.areEqual(this.values[i], (Object) element)) {
            if (i == lastIndex) {
                return -1;
            }
            i++;
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterator<Modifier.Node> iterator() {
        return new HitTestResultIterator(this, 0, 0, 0, 7, (DefaultConstructorMarker) null);
    }

    public int lastIndexOf(Modifier.Node element) {
        Intrinsics.checkNotNullParameter(element, "element");
        for (int i = CollectionsKt.getLastIndex(this); -1 < i; i--) {
            if (Intrinsics.areEqual(this.values[i], (Object) element)) {
                return i;
            }
        }
        return -1;
    }

    public ListIterator<Modifier.Node> listIterator() {
        return new HitTestResultIterator(this, 0, 0, 0, 7, (DefaultConstructorMarker) null);
    }

    public ListIterator<Modifier.Node> listIterator(int index) {
        return new HitTestResultIterator(this, index, 0, 0, 6, (DefaultConstructorMarker) null);
    }

    public List<Modifier.Node> subList(int fromIndex, int toIndex) {
        return new SubList(fromIndex, toIndex);
    }

    public final void clear() {
        this.hitDepth = -1;
        resizeToHitDepth();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\t\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/node/HitTestResult$HitTestResultIterator;", "", "Landroidx/compose/ui/Modifier$Node;", "index", "", "minIndex", "maxIndex", "(Landroidx/compose/ui/node/HitTestResult;III)V", "getIndex", "()I", "setIndex", "(I)V", "getMaxIndex", "getMinIndex", "hasNext", "", "hasPrevious", "next", "nextIndex", "previous", "previousIndex", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: HitTestResult.kt */
    private final class HitTestResultIterator implements ListIterator<Modifier.Node>, KMappedMarker {
        private int index;
        private final int maxIndex;
        private final int minIndex;

        public void add(Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void set(Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public HitTestResultIterator(int index2, int minIndex2, int maxIndex2) {
            this.index = index2;
            this.minIndex = minIndex2;
            this.maxIndex = maxIndex2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ HitTestResultIterator(HitTestResult hitTestResult, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? hitTestResult.size() : i3);
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setIndex(int i) {
            this.index = i;
        }

        public final int getMinIndex() {
            return this.minIndex;
        }

        public final int getMaxIndex() {
            return this.maxIndex;
        }

        public boolean hasNext() {
            return this.index < this.maxIndex;
        }

        public boolean hasPrevious() {
            return this.index > this.minIndex;
        }

        public Modifier.Node next() {
            Object[] access$getValues$p = HitTestResult.this.values;
            int i = this.index;
            this.index = i + 1;
            Object obj = access$getValues$p[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node) obj;
        }

        public int nextIndex() {
            return this.index - this.minIndex;
        }

        public Modifier.Node previous() {
            Object[] access$getValues$p = HitTestResult.this.values;
            int i = this.index - 1;
            this.index = i;
            Object obj = access$getValues$p[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node) obj;
        }

        public int previousIndex() {
            return (this.index - this.minIndex) - 1;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0016\u0010\u000f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016J\u0011\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0016J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0016R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/node/HitTestResult$SubList;", "", "Landroidx/compose/ui/Modifier$Node;", "minIndex", "", "maxIndex", "(Landroidx/compose/ui/node/HitTestResult;II)V", "getMaxIndex", "()I", "getMinIndex", "size", "getSize", "contains", "", "element", "containsAll", "elements", "", "get", "index", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: HitTestResult.kt */
    private final class SubList implements List<Modifier.Node>, KMappedMarker {
        private final int maxIndex;
        private final int minIndex;

        public void add(int i, Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ void add(int i, Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean add(Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean addAll(int i, Collection<? extends Modifier.Node> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean addAll(Collection<? extends Modifier.Node> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Modifier.Node remove(int i) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean removeAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void replaceAll(UnaryOperator<Modifier.Node> unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean retainAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Modifier.Node set(int i, Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void sort(Comparator<? super Modifier.Node> comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        public <T> T[] toArray(T[] tArr) {
            Intrinsics.checkNotNullParameter(tArr, "array");
            return CollectionToArray.toArray(this, tArr);
        }

        public SubList(int minIndex2, int maxIndex2) {
            this.minIndex = minIndex2;
            this.maxIndex = maxIndex2;
        }

        public final /* bridge */ boolean contains(Object element) {
            if (!(element instanceof Modifier.Node)) {
                return false;
            }
            return contains((Modifier.Node) element);
        }

        public final /* bridge */ int indexOf(Object element) {
            if (!(element instanceof Modifier.Node)) {
                return -1;
            }
            return indexOf((Modifier.Node) element);
        }

        public final /* bridge */ int lastIndexOf(Object element) {
            if (!(element instanceof Modifier.Node)) {
                return -1;
            }
            return lastIndexOf((Modifier.Node) element);
        }

        public final /* bridge */ int size() {
            return getSize();
        }

        public final int getMinIndex() {
            return this.minIndex;
        }

        public final int getMaxIndex() {
            return this.maxIndex;
        }

        public int getSize() {
            return this.maxIndex - this.minIndex;
        }

        public boolean contains(Modifier.Node element) {
            Intrinsics.checkNotNullParameter(element, "element");
            return indexOf((Object) element) != -1;
        }

        public boolean containsAll(Collection<? extends Object> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            Iterator it = elements.iterator();
            while (it.hasNext()) {
                if (!contains((Object) (Modifier.Node) it.next())) {
                    return false;
                }
            }
            return true;
        }

        public Modifier.Node get(int index) {
            Object obj = HitTestResult.this.values[this.minIndex + index];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node) obj;
        }

        public int indexOf(Modifier.Node element) {
            Intrinsics.checkNotNullParameter(element, "element");
            int i = this.minIndex;
            int i2 = this.maxIndex;
            if (i > i2) {
                return -1;
            }
            while (!Intrinsics.areEqual(HitTestResult.this.values[i], (Object) element)) {
                if (i == i2) {
                    return -1;
                }
                i++;
            }
            return i - this.minIndex;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public Iterator<Modifier.Node> iterator() {
            HitTestResult hitTestResult = HitTestResult.this;
            int i = this.minIndex;
            return new HitTestResultIterator(i, i, this.maxIndex);
        }

        public int lastIndexOf(Modifier.Node element) {
            Intrinsics.checkNotNullParameter(element, "element");
            int i = this.maxIndex;
            int i2 = this.minIndex;
            if (i2 > i) {
                return -1;
            }
            while (!Intrinsics.areEqual(HitTestResult.this.values[i], (Object) element)) {
                if (i == i2) {
                    return -1;
                }
                i--;
            }
            return i - this.minIndex;
        }

        public ListIterator<Modifier.Node> listIterator() {
            HitTestResult hitTestResult = HitTestResult.this;
            int i = this.minIndex;
            return new HitTestResultIterator(i, i, this.maxIndex);
        }

        public ListIterator<Modifier.Node> listIterator(int index) {
            HitTestResult hitTestResult = HitTestResult.this;
            int i = this.minIndex;
            return new HitTestResultIterator(i + index, i, this.maxIndex);
        }

        public List<Modifier.Node> subList(int fromIndex, int toIndex) {
            HitTestResult hitTestResult = HitTestResult.this;
            int i = this.minIndex;
            return new SubList(i + fromIndex, i + toIndex);
        }
    }
}

package androidx.compose.ui.text.android;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a;\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a`\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b\"\u0010\b\u0002\u0010\u0007*\n\u0012\u0006\b\u0000\u0012\u0002H\b0\t*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\n\u001a\u0002H\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0005H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\f\u001aM\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u000eH\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000f"}, d2 = {"fastForEach", "", "T", "", "action", "Lkotlin/Function1;", "fastMapTo", "C", "R", "", "destination", "transform", "(Ljava/util/List;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fastZipWithNext", "Lkotlin/Function2;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TempListUtils.kt */
public final class TempListUtilsKt {
    public static final <T> void fastForEach(List<? extends T> $this$fastForEach, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter($this$fastForEach, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int size = $this$fastForEach.size();
        for (int index = 0; index < size; index++) {
            action.invoke($this$fastForEach.get(index));
        }
    }

    public static final <T, R, C extends Collection<? super R>> C fastMapTo(List<? extends T> $this$fastMapTo, C destination, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter($this$fastMapTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        List $this$fastForEach$iv = $this$fastMapTo;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            destination.add(transform.invoke($this$fastForEach$iv.get(index$iv)));
        }
        return destination;
    }

    public static final <T, R> List<R> fastZipWithNext(List<? extends T> $this$fastZipWithNext, Function2<? super T, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter($this$fastZipWithNext, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if ($this$fastZipWithNext.size() == 0 || $this$fastZipWithNext.size() == 1) {
            return CollectionsKt.emptyList();
        }
        List result = new ArrayList();
        Object current = $this$fastZipWithNext.get(0);
        int lastIndex = CollectionsKt.getLastIndex($this$fastZipWithNext);
        for (int i = 0; i < lastIndex; i++) {
            Object next = $this$fastZipWithNext.get(i + 1);
            result.add(transform.invoke(current, next));
            current = next;
        }
        return result;
    }
}

package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001e\u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ?\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010\u001aJ\u0001\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000b2#\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00052#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000521\u0010 \u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010\"J?\u0010#\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u0007H\u0017¢\u0006\u0002\u0010\u001aR\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListIntervalContent;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/LazyListInterval;", "Landroidx/compose/foundation/lazy/LazyListScope;", "content", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "_headerIndexes", "", "", "headerIndexes", "", "getHeaderIndexes", "()Ljava/util/List;", "intervals", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "item", "key", "", "contentType", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "Lkotlin/ParameterName;", "name", "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "stickyHeader", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListIntervalContent.kt */
public final class LazyListIntervalContent extends LazyLayoutIntervalContent<LazyListInterval> implements LazyListScope {
    private List<Integer> _headerIndexes;
    private final MutableIntervalList<LazyListInterval> intervals = new MutableIntervalList<>();

    public LazyListIntervalContent(Function1<? super LazyListScope, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        content.invoke(this);
    }

    public MutableIntervalList<LazyListInterval> getIntervals() {
        return this.intervals;
    }

    public final List<Integer> getHeaderIndexes() {
        List<Integer> list = this._headerIndexes;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public void items(int count, Function1<? super Integer, ? extends Object> key, Function1<? super Integer, ? extends Object> contentType, Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        getIntervals().addInterval(count, new LazyListInterval(key, contentType, itemContent));
    }

    public void item(Object key, Object contentType, Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> content) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(content, "content");
        MutableIntervalList intervals2 = getIntervals();
        if (key != null) {
            function1 = new LazyListIntervalContent$item$1(key);
        } else {
            function1 = null;
        }
        intervals2.addInterval(1, new LazyListInterval(function1, new LazyListIntervalContent$item$2(contentType), ComposableLambdaKt.composableLambdaInstance(-1010194746, true, new LazyListIntervalContent$item$3(content))));
    }

    public void stickyHeader(Object key, Object contentType, Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        List headersIndexes = this._headerIndexes;
        if (headersIndexes == null) {
            headersIndexes = new ArrayList();
            this._headerIndexes = headersIndexes;
        }
        headersIndexes.add(Integer.valueOf(getIntervals().getSize()));
        item(key, contentType, content);
    }
}

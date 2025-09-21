package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/pager/PagerState;", "intervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/pager/PagerIntervalContent;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;)V", "itemCount", "", "getItemCount", "()I", "pagerScopeImpl", "Landroidx/compose/foundation/pager/PagerScopeImpl;", "Item", "", "index", "key", "", "(ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "equals", "", "other", "getIndex", "getKey", "hashCode", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutPager.kt */
public final class PagerLazyLayoutItemProvider implements LazyLayoutItemProvider {
    /* access modifiers changed from: private */
    public final LazyLayoutIntervalContent<PagerIntervalContent> intervalContent;
    private final LazyLayoutKeyIndexMap keyIndexMap;
    /* access modifiers changed from: private */
    public final PagerScopeImpl pagerScopeImpl = PagerScopeImpl.INSTANCE;
    private final PagerState state;

    public PagerLazyLayoutItemProvider(PagerState state2, LazyLayoutIntervalContent<PagerIntervalContent> intervalContent2, LazyLayoutKeyIndexMap keyIndexMap2) {
        Intrinsics.checkNotNullParameter(state2, "state");
        Intrinsics.checkNotNullParameter(intervalContent2, "intervalContent");
        Intrinsics.checkNotNullParameter(keyIndexMap2, "keyIndexMap");
        this.state = state2;
        this.intervalContent = intervalContent2;
        this.keyIndexMap = keyIndexMap2;
    }

    public int getItemCount() {
        return this.intervalContent.getItemCount();
    }

    public void Item(int index, Object key, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(key, "key");
        Composer $composer2 = $composer.startRestartGroup(-1201380429);
        ComposerKt.sourceInformation($composer2, "C(Item)188@7566L209:LazyLayoutPager.kt#g6yjnt");
        int $dirty = $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1201380429, $dirty, -1, "androidx.compose.foundation.pager.PagerLazyLayoutItemProvider.Item (LazyLayoutPager.kt:187)");
        }
        LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(key, index, this.state.getPinnedPages$foundation_release(), ComposableLambdaKt.composableLambda($composer2, 1142237095, true, new PagerLazyLayoutItemProvider$Item$1(this, index)), $composer2, (($dirty << 3) & 112) | 3592);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PagerLazyLayoutItemProvider$Item$2(this, index, key, $changed));
        }
    }

    public Object getKey(int index) {
        Object key = this.keyIndexMap.getKey(index);
        return key == null ? this.intervalContent.getKey(index) : key;
    }

    public int getIndex(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.keyIndexMap.getIndex(key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PagerLazyLayoutItemProvider)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.intervalContent, (Object) ((PagerLazyLayoutItemProvider) other).intervalContent);
    }

    public int hashCode() {
        return this.intervalContent.hashCode();
    }
}

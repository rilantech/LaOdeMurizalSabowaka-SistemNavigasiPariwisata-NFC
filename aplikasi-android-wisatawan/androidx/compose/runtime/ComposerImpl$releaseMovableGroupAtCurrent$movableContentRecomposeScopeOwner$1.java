package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"androidx/compose/runtime/ComposerImpl$releaseMovableGroupAtCurrent$movableContentRecomposeScopeOwner$1", "Landroidx/compose/runtime/RecomposeScopeOwner;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "instance", "", "recomposeScopeReleased", "", "recordReadOf", "value", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
public final class ComposerImpl$releaseMovableGroupAtCurrent$movableContentRecomposeScopeOwner$1 implements RecomposeScopeOwner {
    final /* synthetic */ ControlledComposition $composition;
    final /* synthetic */ MovableContentStateReference $reference;

    ComposerImpl$releaseMovableGroupAtCurrent$movableContentRecomposeScopeOwner$1(ControlledComposition $composition2, MovableContentStateReference $reference2) {
        this.$composition = $composition2;
        this.$reference = $reference2;
    }

    public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
        InvalidationResult result;
        Intrinsics.checkNotNullParameter(scope, "scope");
        ControlledComposition controlledComposition = this.$composition;
        Object it = null;
        RecomposeScopeOwner recomposeScopeOwner = controlledComposition instanceof RecomposeScopeOwner ? (RecomposeScopeOwner) controlledComposition : null;
        if (recomposeScopeOwner == null || (result = recomposeScopeOwner.invalidate(scope, instance)) == null) {
            result = InvalidationResult.IGNORED;
        }
        if (result != InvalidationResult.IGNORED) {
            return result;
        }
        MovableContentStateReference movableContentStateReference = this.$reference;
        Collection invalidations$runtime_release = movableContentStateReference.getInvalidations$runtime_release();
        if (instance != null) {
            Object obj = instance;
            Object identityArraySet = new IdentityArraySet();
            IdentityArraySet it2 = identityArraySet;
            it2.add(it2);
            it = identityArraySet;
        }
        movableContentStateReference.setInvalidations$runtime_release(CollectionsKt.plus(invalidations$runtime_release, TuplesKt.to(scope, it)));
        return InvalidationResult.SCHEDULED;
    }

    public void recomposeScopeReleased(RecomposeScopeImpl scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
    }

    public void recordReadOf(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
    }
}

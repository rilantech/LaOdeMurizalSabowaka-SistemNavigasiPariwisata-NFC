package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
final class SnapshotKt$advanceGlobalSnapshot$3 extends Lambda implements Function1<SnapshotIdSet, Unit> {
    public static final SnapshotKt$advanceGlobalSnapshot$3 INSTANCE = new SnapshotKt$advanceGlobalSnapshot$3();

    SnapshotKt$advanceGlobalSnapshot$3() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SnapshotIdSet) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SnapshotIdSet it) {
        Intrinsics.checkNotNullParameter(it, "it");
    }
}

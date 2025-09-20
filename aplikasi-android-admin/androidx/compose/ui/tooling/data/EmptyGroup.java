package androidx.compose.ui.tooling.data;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/tooling/data/EmptyGroup;", "Landroidx/compose/ui/tooling/data/Group;", "()V", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTree.kt */
final class EmptyGroup extends Group {
    public static final EmptyGroup INSTANCE = new EmptyGroup();

    private EmptyGroup() {
        super((Object) null, (String) null, (SourceLocation) null, (Object) null, SlotTreeKt.getEmptyBox(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), false, (DefaultConstructorMarker) null);
    }
}

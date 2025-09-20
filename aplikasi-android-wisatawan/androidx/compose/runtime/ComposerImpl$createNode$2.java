package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "T", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
final class ComposerImpl$createNode$2 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {
    final /* synthetic */ Function0<T> $factory;
    final /* synthetic */ Anchor $groupAnchor;
    final /* synthetic */ int $insertIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposerImpl$createNode$2(Function0<? extends T> function0, Anchor anchor, int i) {
        super(3);
        this.$factory = function0;
        this.$groupAnchor = anchor;
        this.$insertIndex = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((Applier<?>) (Applier) p1, (SlotWriter) p2, (RememberManager) p3);
        return Unit.INSTANCE;
    }

    public final void invoke(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
        Intrinsics.checkNotNullParameter(applier, "applier");
        Intrinsics.checkNotNullParameter(slots, "slots");
        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
        Object node = this.$factory.invoke();
        slots.updateNode(this.$groupAnchor, node);
        applier.insertTopDown(this.$insertIndex, node);
        applier.down(node);
    }
}

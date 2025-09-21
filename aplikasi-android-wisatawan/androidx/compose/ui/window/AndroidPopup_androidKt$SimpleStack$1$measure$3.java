package androidx.compose.ui.window;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
public final class AndroidPopup_androidKt$SimpleStack$1$measure$3 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<Placeable> $placeables;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidPopup_androidKt$SimpleStack$1$measure$3(List<? extends Placeable> list) {
        super(1);
        this.$placeables = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        int i = 0;
        int lastIndex = CollectionsKt.getLastIndex(this.$placeables);
        if (0 <= lastIndex) {
            while (true) {
                Placeable.PlacementScope.placeRelative$default($this$layout, this.$placeables.get(i), 0, 0, 0.0f, 4, (Object) null);
                if (i != lastIndex) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}

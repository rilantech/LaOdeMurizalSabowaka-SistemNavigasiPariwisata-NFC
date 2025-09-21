package androidx.compose.material;

import android.view.View;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ Ref<LayoutCoordinates> $coordinates;
    final /* synthetic */ MutableIntState $menuHeight$delegate;
    final /* synthetic */ int $verticalMarginInPx;
    final /* synthetic */ View $view;
    final /* synthetic */ MutableIntState $width$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuKt$ExposedDropdownMenuBox$1(Ref<LayoutCoordinates> ref, View view, int i, MutableIntState mutableIntState, MutableIntState mutableIntState2) {
        super(1);
        this.$coordinates = ref;
        this.$view = view;
        this.$verticalMarginInPx = i;
        this.$width$delegate = mutableIntState;
        this.$menuHeight$delegate = mutableIntState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((LayoutCoordinates) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$2(this.$width$delegate, IntSize.m6004getWidthimpl(it.m4650getSizeYbymL2g()));
        this.$coordinates.setValue(it);
        View rootView = this.$view.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
        int i = this.$verticalMarginInPx;
        final MutableIntState mutableIntState = this.$menuHeight$delegate;
        ExposedDropdownMenuKt.updateHeight(rootView, this.$coordinates.getValue(), i, new Function1<Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke(((Number) p1).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int newHeight) {
                ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$5(mutableIntState, newHeight);
            }
        });
    }
}

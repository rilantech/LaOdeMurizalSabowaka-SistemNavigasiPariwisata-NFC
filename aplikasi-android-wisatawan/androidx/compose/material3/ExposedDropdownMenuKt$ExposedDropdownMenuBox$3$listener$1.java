package androidx.compose.material3;

import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$3$listener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref<LayoutCoordinates> $coordinates;
    final /* synthetic */ MutableState<Integer> $menuHeight$delegate;
    final /* synthetic */ int $verticalMarginInPx;
    final /* synthetic */ View $view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuKt$ExposedDropdownMenuBox$3$listener$1(View view, Ref<LayoutCoordinates> ref, int i, MutableState<Integer> mutableState) {
        super(0);
        this.$view = view;
        this.$coordinates = ref;
        this.$verticalMarginInPx = i;
        this.$menuHeight$delegate = mutableState;
    }

    public final void invoke() {
        View rootView = this.$view.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
        int i = this.$verticalMarginInPx;
        final MutableState<Integer> mutableState = this.$menuHeight$delegate;
        ExposedDropdownMenuKt.updateHeight(rootView, this.$coordinates.getValue(), i, new Function1<Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke(((Number) p1).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int newHeight) {
                ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$5(mutableState, newHeight);
            }
        });
    }
}

package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.kt */
final class SearchBarKt$SearchBar$topPadding$1$1 extends Lambda implements Function0<Dp> {
    final /* synthetic */ Density $density;
    final /* synthetic */ MutableWindowInsets $unconsumedInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBarKt$SearchBar$topPadding$1$1(MutableWindowInsets mutableWindowInsets, Density density) {
        super(0);
        this.$unconsumedInsets = mutableWindowInsets;
        this.$density = density;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Dp.m7552boximpl(m3662invokeD9Ej5fM());
    }

    /* renamed from: invoke-D9Ej5fM  reason: not valid java name */
    public final float m3662invokeD9Ej5fM() {
        return Dp.m7554constructorimpl(SearchBarKt.getSearchBarVerticalPadding() + WindowInsetsKt.asPaddingValues(this.$unconsumedInsets, this.$density).m2265calculateTopPaddingD9Ej5fM());
    }
}

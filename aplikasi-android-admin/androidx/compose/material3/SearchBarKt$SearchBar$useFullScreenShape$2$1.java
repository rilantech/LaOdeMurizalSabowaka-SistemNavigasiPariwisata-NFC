package androidx.compose.material3;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.kt */
final class SearchBarKt$SearchBar$useFullScreenShape$2$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ State<Float> $animationProgress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBarKt$SearchBar$useFullScreenShape$2$1(State<Float> state) {
        super(0);
        this.$animationProgress = state;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(this.$animationProgress.getValue().floatValue() == 1.0f);
    }
}

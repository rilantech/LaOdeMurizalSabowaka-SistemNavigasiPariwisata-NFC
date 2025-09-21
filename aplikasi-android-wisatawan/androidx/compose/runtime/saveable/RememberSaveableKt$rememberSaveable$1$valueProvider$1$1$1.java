package androidx.compose.runtime.saveable;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: RememberSaveable.kt */
final class RememberSaveableKt$rememberSaveable$1$valueProvider$1$1$1 implements SaverScope {
    final /* synthetic */ SaveableStateRegistry $registry;

    RememberSaveableKt$rememberSaveable$1$valueProvider$1$1$1(SaveableStateRegistry saveableStateRegistry) {
        this.$registry = saveableStateRegistry;
    }

    public final boolean canBeSaved(Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this.$registry.canBeSaved(it);
    }
}

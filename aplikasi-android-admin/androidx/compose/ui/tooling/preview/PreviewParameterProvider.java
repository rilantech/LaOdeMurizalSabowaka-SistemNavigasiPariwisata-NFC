package androidx.compose.ui.tooling.preview;

import kotlin.Metadata;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "T", "", "count", "", "getCount", "()I", "values", "Lkotlin/sequences/Sequence;", "getValues", "()Lkotlin/sequences/Sequence;", "ui-tooling-preview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PreviewParameter.kt */
public interface PreviewParameterProvider<T> {
    Sequence<T> getValues();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PreviewParameter.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static <T> int getCount(PreviewParameterProvider<T> $this) {
            return PreviewParameterProvider.super.getCount();
        }
    }

    int getCount() {
        return SequencesKt.count(getValues());
    }
}

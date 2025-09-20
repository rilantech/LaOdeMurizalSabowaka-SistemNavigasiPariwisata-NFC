package androidx.compose.ui.text;

import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "str", "start", "", "end", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnnotatedString.kt */
final class AnnotatedStringKt$toUpperCase$1 extends Lambda implements Function3<String, Integer, Integer, String> {
    final /* synthetic */ LocaleList $localeList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnnotatedStringKt$toUpperCase$1(LocaleList localeList) {
        super(3);
        this.$localeList = localeList;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((String) p1, ((Number) p2).intValue(), ((Number) p3).intValue());
    }

    public final String invoke(String str, int start, int end) {
        Intrinsics.checkNotNullParameter(str, "str");
        String substring = str.substring(start, end);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return StringKt.toUpperCase(substring, this.$localeList);
    }
}

package androidx.compose.ui.text.platform;

import android.text.style.URLSpan;
import androidx.compose.ui.text.UrlAnnotation;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/platform/URLSpanCache;", "", "()V", "spansByAnnotation", "Ljava/util/WeakHashMap;", "Landroidx/compose/ui/text/UrlAnnotation;", "Landroid/text/style/URLSpan;", "toURLSpan", "urlAnnotation", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: URLSpanCache.kt */
public final class URLSpanCache {
    public static final int $stable = 8;
    private final WeakHashMap<UrlAnnotation, URLSpan> spansByAnnotation = new WeakHashMap<>();

    public final URLSpan toURLSpan(UrlAnnotation urlAnnotation) {
        Object answer$iv;
        Intrinsics.checkNotNullParameter(urlAnnotation, "urlAnnotation");
        Map $this$getOrPut$iv = this.spansByAnnotation;
        Object value$iv = $this$getOrPut$iv.get(urlAnnotation);
        if (value$iv == null) {
            answer$iv = new URLSpan(urlAnnotation.getUrl());
            $this$getOrPut$iv.put(urlAnnotation, answer$iv);
        } else {
            answer$iv = value$iv;
        }
        return (URLSpan) answer$iv;
    }
}

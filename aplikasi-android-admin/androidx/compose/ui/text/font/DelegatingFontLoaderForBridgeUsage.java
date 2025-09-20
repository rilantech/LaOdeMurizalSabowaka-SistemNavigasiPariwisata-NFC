package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.Font;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/font/DelegatingFontLoaderForBridgeUsage;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "loader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "context", "Landroid/content/Context;", "(Landroidx/compose/ui/text/font/Font$ResourceLoader;Landroid/content/Context;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "getLoader$ui_text_release", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "awaitLoad", "font", "Landroidx/compose/ui/text/font/Font;", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DelegatingFontLoaderForDeprecatedUsage.android.kt */
public final class DelegatingFontLoaderForBridgeUsage implements PlatformFontLoader {
    private final Object cacheKey = new Object();
    private final Context context;
    private final Font.ResourceLoader loader;

    public DelegatingFontLoaderForBridgeUsage(Font.ResourceLoader loader2, Context context2) {
        Intrinsics.checkNotNullParameter(loader2, "loader");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.loader = loader2;
        this.context = context2;
    }

    public final Font.ResourceLoader getLoader$ui_text_release() {
        return this.loader;
    }

    public Object getCacheKey() {
        return this.cacheKey;
    }

    public Object loadBlocking(Font font) {
        Intrinsics.checkNotNullParameter(font, "font");
        if (font instanceof AndroidFont) {
            return ((AndroidFont) font).getTypefaceLoader().loadBlocking(this.context, (AndroidFont) font);
        }
        return this.loader.load(font);
    }

    public Object awaitLoad(Font font, Continuation<Object> $completion) {
        if (font instanceof AndroidFont) {
            return ((AndroidFont) font).getTypefaceLoader().awaitLoad(this.context, (AndroidFont) font, $completion);
        }
        return this.loader.load(font);
    }
}

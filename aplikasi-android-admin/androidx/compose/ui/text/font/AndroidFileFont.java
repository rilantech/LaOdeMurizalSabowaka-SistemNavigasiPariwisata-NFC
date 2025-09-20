package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.FontVariation;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B,\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0010¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\fH\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/font/AndroidFileFont;", "Landroidx/compose/ui/text/font/AndroidPreloadedFont;", "file", "Ljava/io/File;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "(Ljava/io/File;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "getFile", "()Ljava/io/File;", "doLoad", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "doLoad$ui_text_release", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPreloadedFont.kt */
public final class AndroidFileFont extends AndroidPreloadedFont {
    private final String cacheKey;
    private final File file;

    public /* synthetic */ AndroidFileFont(File file2, FontWeight fontWeight, int i, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(file2, fontWeight, i, settings);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AndroidFileFont(java.io.File r7, androidx.compose.ui.text.font.FontWeight r8, int r9, androidx.compose.ui.text.font.FontVariation.Settings r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r6 = this;
            r12 = r11 & 2
            if (r12 == 0) goto L_0x000c
            androidx.compose.ui.text.font.FontWeight$Companion r8 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r8 = r8.getNormal()
            r2 = r8
            goto L_0x000d
        L_0x000c:
            r2 = r8
        L_0x000d:
            r8 = r11 & 4
            if (r8 == 0) goto L_0x0019
            androidx.compose.ui.text.font.FontStyle$Companion r8 = androidx.compose.ui.text.font.FontStyle.Companion
            int r9 = r8.m7139getNormal_LCdwA()
            r3 = r9
            goto L_0x001a
        L_0x0019:
            r3 = r9
        L_0x001a:
            r5 = 0
            r0 = r6
            r1 = r7
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AndroidFileFont.<init>(java.io.File, androidx.compose.ui.text.font.FontWeight, int, androidx.compose.ui.text.font.FontVariation$Settings, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final File getFile() {
        return this.file;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private AndroidFileFont(File file2, FontWeight weight, int style, FontVariation.Settings variationSettings) {
        super(weight, style, variationSettings, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(file2, "file");
        Intrinsics.checkNotNullParameter(weight, "weight");
        Intrinsics.checkNotNullParameter(variationSettings, "variationSettings");
        this.file = file2;
        setTypeface$ui_text_release(doLoad$ui_text_release((Context) null));
    }

    public Typeface doLoad$ui_text_release(Context context) {
        return TypefaceBuilderCompat.INSTANCE.createFromFile(this.file, context, getVariationSettings());
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public String toString() {
        return "Font(file=" + this.file + ", weight=" + getWeight() + ", style=" + FontStyle.m7136toStringimpl(m7085getStyle_LCdwA()) + ')';
    }
}

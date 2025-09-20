package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.PlatformStringDelegate;
import androidx.compose.ui.text.intl.AndroidLocale;
import androidx.compose.ui.text.intl.PlatformLocale;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidStringDelegate;", "Landroidx/compose/ui/text/PlatformStringDelegate;", "()V", "capitalize", "", "string", "locale", "Landroidx/compose/ui/text/intl/PlatformLocale;", "decapitalize", "toLowerCase", "toUpperCase", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidStringDelegate.android.kt */
public final class AndroidStringDelegate implements PlatformStringDelegate {
    public String toUpperCase(String string, PlatformLocale locale) {
        Intrinsics.checkNotNullParameter(string, TypedValues.Custom.S_STRING);
        Intrinsics.checkNotNullParameter(locale, "locale");
        String upperCase = string.toUpperCase(((AndroidLocale) locale).getJavaLocale());
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    public String toLowerCase(String string, PlatformLocale locale) {
        Intrinsics.checkNotNullParameter(string, TypedValues.Custom.S_STRING);
        Intrinsics.checkNotNullParameter(locale, "locale");
        String lowerCase = string.toLowerCase(((AndroidLocale) locale).getJavaLocale());
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public String capitalize(String string, PlatformLocale locale) {
        String str;
        Intrinsics.checkNotNullParameter(string, TypedValues.Custom.S_STRING);
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (!(string.length() > 0)) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        char it = string.charAt(0);
        if (Character.isLowerCase(it)) {
            str = CharsKt.titlecase(it, ((AndroidLocale) locale).getJavaLocale());
        } else {
            str = String.valueOf(it);
        }
        StringBuilder append = sb.append(str);
        String substring = string.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return append.append(substring).toString();
    }

    public String decapitalize(String string, PlatformLocale locale) {
        Intrinsics.checkNotNullParameter(string, TypedValues.Custom.S_STRING);
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (!(string.length() > 0)) {
            return string;
        }
        StringBuilder append = new StringBuilder().append(CharsKt.lowercase(string.charAt(0), ((AndroidLocale) locale).getJavaLocale()));
        String substring = string.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return append.append(substring).toString();
    }
}

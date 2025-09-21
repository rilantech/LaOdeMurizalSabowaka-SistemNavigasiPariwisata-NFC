package androidx.compose.ui.text.font;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/text/font/DeviceFontFamilyName;", "", "name", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getName", "()Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: DeviceFontFamilyNameFont.kt */
public final class DeviceFontFamilyName {
    private final String name;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DeviceFontFamilyName m5385boximpl(String str) {
        return new DeviceFontFamilyName(str);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5387equalsimpl(String str, Object obj) {
        return (obj instanceof DeviceFontFamilyName) && Intrinsics.areEqual((Object) str, (Object) ((DeviceFontFamilyName) obj).m5391unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5388equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual((Object) str, (Object) str2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5389hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5390toStringimpl(String str) {
        return "DeviceFontFamilyName(name=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m5387equalsimpl(this.name, obj);
    }

    public int hashCode() {
        return m5389hashCodeimpl(this.name);
    }

    public String toString() {
        return m5390toStringimpl(this.name);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ String m5391unboximpl() {
        return this.name;
    }

    private /* synthetic */ DeviceFontFamilyName(String name2) {
        this.name = name2;
    }

    public final String getName() {
        return this.name;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static String m5386constructorimpl(String name2) {
        Intrinsics.checkNotNullParameter(name2, HintConstants.AUTOFILL_HINT_NAME);
        if (name2.length() > 0) {
            return name2;
        }
        throw new IllegalArgumentException("name may not be empty".toString());
    }
}

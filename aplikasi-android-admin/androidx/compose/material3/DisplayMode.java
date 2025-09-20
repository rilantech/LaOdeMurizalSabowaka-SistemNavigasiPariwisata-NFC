package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/DisplayMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: DatePicker.kt */
public final class DisplayMode {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Input = m3442constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Picker = m3442constructorimpl(0);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DisplayMode m3441boximpl(int i) {
        return new DisplayMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m3442constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3443equalsimpl(int i, Object obj) {
        return (obj instanceof DisplayMode) && i == ((DisplayMode) obj).m3447unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3444equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3445hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m3443equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3445hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m3447unboximpl() {
        return this.value;
    }

    private /* synthetic */ DisplayMode(int value2) {
        this.value = value2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/material3/DisplayMode$Companion;", "", "()V", "Input", "Landroidx/compose/material3/DisplayMode;", "getInput-jFl-4v0", "()I", "I", "Picker", "getPicker-jFl-4v0", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DatePicker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getPicker-jFl-4v0  reason: not valid java name */
        public final int m3449getPickerjFl4v0() {
            return DisplayMode.Picker;
        }

        /* renamed from: getInput-jFl-4v0  reason: not valid java name */
        public final int m3448getInputjFl4v0() {
            return DisplayMode.Input;
        }
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3446toStringimpl(int arg0) {
        if (m3444equalsimpl0(arg0, Picker)) {
            return "Picker";
        }
        if (m3444equalsimpl0(arg0, Input)) {
            return "Input";
        }
        return "Unknown";
    }

    public String toString() {
        return m3446toStringimpl(this.value);
    }
}

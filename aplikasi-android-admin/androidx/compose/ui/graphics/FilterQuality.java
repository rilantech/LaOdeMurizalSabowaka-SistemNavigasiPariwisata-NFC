package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/FilterQuality;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: FilterQuality.kt */
public final class FilterQuality {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int High = m5053constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Low = m5053constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Medium = m5053constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int None = m5053constructorimpl(0);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FilterQuality m5052boximpl(int i) {
        return new FilterQuality(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m5053constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5054equalsimpl(int i, Object obj) {
        return (obj instanceof FilterQuality) && i == ((FilterQuality) obj).m5058unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5055equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5056hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m5054equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5056hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5058unboximpl() {
        return this.value;
    }

    private /* synthetic */ FilterQuality(int value2) {
        this.value = value2;
    }

    public final int getValue() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/graphics/FilterQuality$Companion;", "", "()V", "High", "Landroidx/compose/ui/graphics/FilterQuality;", "getHigh-f-v9h1I", "()I", "I", "Low", "getLow-f-v9h1I", "Medium", "getMedium-f-v9h1I", "None", "getNone-f-v9h1I", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FilterQuality.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getNone-f-v9h1I  reason: not valid java name */
        public final int m5062getNonefv9h1I() {
            return FilterQuality.None;
        }

        /* renamed from: getLow-f-v9h1I  reason: not valid java name */
        public final int m5060getLowfv9h1I() {
            return FilterQuality.Low;
        }

        /* renamed from: getMedium-f-v9h1I  reason: not valid java name */
        public final int m5061getMediumfv9h1I() {
            return FilterQuality.Medium;
        }

        /* renamed from: getHigh-f-v9h1I  reason: not valid java name */
        public final int m5059getHighfv9h1I() {
            return FilterQuality.High;
        }
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5057toStringimpl(int arg0) {
        if (m5055equalsimpl0(arg0, None)) {
            return "None";
        }
        if (m5055equalsimpl0(arg0, Low)) {
            return "Low";
        }
        if (m5055equalsimpl0(arg0, Medium)) {
            return "Medium";
        }
        if (m5055equalsimpl0(arg0, High)) {
            return "High";
        }
        return "Unknown";
    }

    public String toString() {
        return m5057toStringimpl(this.value);
    }
}

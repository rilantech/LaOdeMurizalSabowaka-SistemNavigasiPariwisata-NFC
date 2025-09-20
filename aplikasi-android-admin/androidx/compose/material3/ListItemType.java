package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JvmInline
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/ListItemType;", "", "lines", "", "constructor-impl", "(I)I", "compareTo", "other", "compareTo-yh95HIg", "(II)I", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemType implements Comparable<ListItemType> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int OneLine = m3549constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int ThreeLine = m3549constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int TwoLine = m3549constructorimpl(2);
    private final int lines;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ListItemType m3547boximpl(int i) {
        return new ListItemType(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m3549constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3550equalsimpl(int i, Object obj) {
        return (obj instanceof ListItemType) && i == ((ListItemType) obj).m3555unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3551equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3552hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3553toStringimpl(int i) {
        return "ListItemType(lines=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m3550equalsimpl(this.lines, obj);
    }

    public int hashCode() {
        return m3552hashCodeimpl(this.lines);
    }

    public String toString() {
        return m3553toStringimpl(this.lines);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m3555unboximpl() {
        return this.lines;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object other) {
        return m3554compareToyh95HIg(((ListItemType) other).m3555unboximpl());
    }

    private /* synthetic */ ListItemType(int lines2) {
        this.lines = lines2;
    }

    /* renamed from: compareTo-yh95HIg  reason: not valid java name */
    public static int m3548compareToyh95HIg(int arg0, int other) {
        return Intrinsics.compare(arg0, other);
    }

    /* renamed from: compareTo-yh95HIg  reason: not valid java name */
    public int m3554compareToyh95HIg(int other) {
        return m3548compareToyh95HIg(this.lines, other);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/ListItemType$Companion;", "", "()V", "OneLine", "Landroidx/compose/material3/ListItemType;", "getOneLine-AlXitO8", "()I", "I", "ThreeLine", "getThreeLine-AlXitO8", "TwoLine", "getTwoLine-AlXitO8", "getListItemType", "hasOverline", "", "hasSupporting", "getListItemType-7AlIA9s$material3_release", "(ZZ)I", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ListItem.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getOneLine-AlXitO8  reason: not valid java name */
        public final int m3557getOneLineAlXitO8() {
            return ListItemType.OneLine;
        }

        /* renamed from: getTwoLine-AlXitO8  reason: not valid java name */
        public final int m3559getTwoLineAlXitO8() {
            return ListItemType.TwoLine;
        }

        /* renamed from: getThreeLine-AlXitO8  reason: not valid java name */
        public final int m3558getThreeLineAlXitO8() {
            return ListItemType.ThreeLine;
        }

        /* renamed from: getListItemType-7AlIA9s$material3_release  reason: not valid java name */
        public final int m3556getListItemType7AlIA9s$material3_release(boolean hasOverline, boolean hasSupporting) {
            if (hasOverline && hasSupporting) {
                return m3558getThreeLineAlXitO8();
            }
            if (hasOverline || hasSupporting) {
                return m3559getTwoLineAlXitO8();
            }
            return m3557getOneLineAlXitO8();
        }
    }
}

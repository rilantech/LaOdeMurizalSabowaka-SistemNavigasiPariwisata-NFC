package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B,\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bB\u001c\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\rB\u0014\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u000fJ>\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0011J\u0015\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b$\u0010\"J\u0016\u0010%\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u000fJ\u001e\u0010'\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010\rJ\u0010\u0010)\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,R\u0012\u0010\u0006\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0005\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0012\u0010\u0004\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0002\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011R\u0019\u0010\u000e\u001a\u00020\nX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0015\u0001\u000e\u0001\u00020\nø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "", "mainAxisMin", "", "mainAxisMax", "crossAxisMin", "crossAxisMax", "constructor-impl", "(IIII)J", "c", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)J", "value", "(J)J", "getCrossAxisMax-impl", "(J)I", "getCrossAxisMin-impl", "getMainAxisMax-impl", "getMainAxisMin-impl", "J", "copy", "copy-yUG9Ft0", "(JIIII)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "maxHeight", "maxHeight-impl", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)I", "maxWidth", "maxWidth-impl", "stretchCrossAxis", "stretchCrossAxis-q4ezo7Y", "toBoxConstraints", "toBoxConstraints-OenEA2s", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: RowColumnImpl.kt */
public final class OrientationIndependentConstraints {
    private final long value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ OrientationIndependentConstraints m2214boximpl(long j) {
        return new OrientationIndependentConstraints(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static long m2216constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2220equalsimpl(long j, Object obj) {
        return (obj instanceof OrientationIndependentConstraints) && Constraints.m7491equalsimpl0(j, ((OrientationIndependentConstraints) obj).m2232unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2221equalsimpl0(long j, long j2) {
        return Constraints.m7491equalsimpl0(j, j2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2226hashCodeimpl(long j) {
        return Constraints.m7501hashCodeimpl(j);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2231toStringimpl(long j) {
        return "OrientationIndependentConstraints(value=" + Constraints.m7503toStringimpl(j) + ')';
    }

    public boolean equals(Object obj) {
        return m2220equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2226hashCodeimpl(this.value);
    }

    public String toString() {
        return m2231toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m2232unboximpl() {
        return this.value;
    }

    private /* synthetic */ OrientationIndependentConstraints(long value2) {
        this.value = value2;
    }

    /* renamed from: getMainAxisMin-impl  reason: not valid java name */
    public static final int m2225getMainAxisMinimpl(long arg0) {
        return Constraints.m7500getMinWidthimpl(arg0);
    }

    /* renamed from: getMainAxisMax-impl  reason: not valid java name */
    public static final int m2224getMainAxisMaximpl(long arg0) {
        return Constraints.m7498getMaxWidthimpl(arg0);
    }

    /* renamed from: getCrossAxisMin-impl  reason: not valid java name */
    public static final int m2223getCrossAxisMinimpl(long arg0) {
        return Constraints.m7499getMinHeightimpl(arg0);
    }

    /* renamed from: getCrossAxisMax-impl  reason: not valid java name */
    public static final int m2222getCrossAxisMaximpl(long arg0) {
        return Constraints.m7497getMaxHeightimpl(arg0);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m2215constructorimpl(int mainAxisMin, int mainAxisMax, int crossAxisMin, int crossAxisMax) {
        return m2216constructorimpl(ConstraintsKt.Constraints(mainAxisMin, mainAxisMax, crossAxisMin, crossAxisMax));
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m2217constructorimpl(long c, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return m2215constructorimpl(orientation == LayoutOrientation.Horizontal ? Constraints.m7500getMinWidthimpl(c) : Constraints.m7499getMinHeightimpl(c), orientation == LayoutOrientation.Horizontal ? Constraints.m7498getMaxWidthimpl(c) : Constraints.m7497getMaxHeightimpl(c), orientation == LayoutOrientation.Horizontal ? Constraints.m7499getMinHeightimpl(c) : Constraints.m7500getMinWidthimpl(c), orientation == LayoutOrientation.Horizontal ? Constraints.m7497getMaxHeightimpl(c) : Constraints.m7498getMaxWidthimpl(c));
    }

    /* renamed from: stretchCrossAxis-q4ezo7Y  reason: not valid java name */
    public static final long m2229stretchCrossAxisq4ezo7Y(long arg0) {
        int i;
        int r0 = Constraints.m7500getMinWidthimpl(arg0);
        int r1 = Constraints.m7498getMaxWidthimpl(arg0);
        if (Constraints.m7497getMaxHeightimpl(arg0) != Integer.MAX_VALUE) {
            i = Constraints.m7497getMaxHeightimpl(arg0);
        } else {
            i = Constraints.m7499getMinHeightimpl(arg0);
        }
        return m2215constructorimpl(r0, r1, i, Constraints.m7497getMaxHeightimpl(arg0));
    }

    /* renamed from: toBoxConstraints-OenEA2s  reason: not valid java name */
    public static final long m2230toBoxConstraintsOenEA2s(long arg0, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return ConstraintsKt.Constraints(Constraints.m7500getMinWidthimpl(arg0), Constraints.m7498getMaxWidthimpl(arg0), Constraints.m7499getMinHeightimpl(arg0), Constraints.m7497getMaxHeightimpl(arg0));
        }
        return ConstraintsKt.Constraints(Constraints.m7499getMinHeightimpl(arg0), Constraints.m7497getMaxHeightimpl(arg0), Constraints.m7500getMinWidthimpl(arg0), Constraints.m7498getMaxWidthimpl(arg0));
    }

    /* renamed from: maxWidth-impl  reason: not valid java name */
    public static final int m2228maxWidthimpl(long arg0, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return Constraints.m7498getMaxWidthimpl(arg0);
        }
        return Constraints.m7497getMaxHeightimpl(arg0);
    }

    /* renamed from: maxHeight-impl  reason: not valid java name */
    public static final int m2227maxHeightimpl(long arg0, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return Constraints.m7497getMaxHeightimpl(arg0);
        }
        return Constraints.m7498getMaxWidthimpl(arg0);
    }

    /* renamed from: copy-yUG9Ft0$default  reason: not valid java name */
    public static /* synthetic */ long m2219copyyUG9Ft0$default(long j, int i, int i2, int i3, int i4, int i5, Object obj) {
        int i6;
        int i7;
        int i8;
        int i9;
        if ((i5 & 1) != 0) {
            i6 = Constraints.m7500getMinWidthimpl(j);
        } else {
            i6 = i;
        }
        if ((i5 & 2) != 0) {
            i7 = Constraints.m7498getMaxWidthimpl(j);
        } else {
            i7 = i2;
        }
        if ((i5 & 4) != 0) {
            i8 = Constraints.m7499getMinHeightimpl(j);
        } else {
            i8 = i3;
        }
        if ((i5 & 8) != 0) {
            i9 = Constraints.m7497getMaxHeightimpl(j);
        } else {
            i9 = i4;
        }
        return m2218copyyUG9Ft0(j, i6, i7, i8, i9);
    }

    /* renamed from: copy-yUG9Ft0  reason: not valid java name */
    public static final long m2218copyyUG9Ft0(long arg0, int mainAxisMin, int mainAxisMax, int crossAxisMin, int crossAxisMax) {
        return m2215constructorimpl(mainAxisMin, mainAxisMax, crossAxisMin, crossAxisMax);
    }
}

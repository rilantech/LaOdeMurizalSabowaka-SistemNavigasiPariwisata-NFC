package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0001\u0002ø\u0001\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/node/DistanceAndInLayer;", "", "packedValue", "", "constructor-impl", "(J)J", "distance", "", "getDistance-impl", "(J)F", "isInLayer", "", "isInLayer-impl", "(J)Z", "getPackedValue", "()J", "compareTo", "", "other", "compareTo-S_HNhKs", "(JJ)I", "equals", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: HitTestResult.kt */
final class DistanceAndInLayer {
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DistanceAndInLayer m4802boximpl(long j) {
        return new DistanceAndInLayer(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m4804constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4805equalsimpl(long j, Object obj) {
        return (obj instanceof DistanceAndInLayer) && j == ((DistanceAndInLayer) obj).m4811unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4806equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4808hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4810toStringimpl(long j) {
        return "DistanceAndInLayer(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m4805equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m4808hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m4810toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m4811unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ DistanceAndInLayer(long packedValue2) {
        this.packedValue = packedValue2;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* renamed from: getDistance-impl  reason: not valid java name */
    public static final float m4807getDistanceimpl(long arg0) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (arg0 >> 32));
    }

    /* renamed from: isInLayer-impl  reason: not valid java name */
    public static final boolean m4809isInLayerimpl(long arg0) {
        return ((int) (4294967295L & arg0)) != 0;
    }

    /* renamed from: compareTo-S_HNhKs  reason: not valid java name */
    public static final int m4803compareToS_HNhKs(long arg0, long other) {
        boolean thisIsInLayer = m4809isInLayerimpl(arg0);
        if (thisIsInLayer != m4809isInLayerimpl(other)) {
            return thisIsInLayer ? -1 : 1;
        }
        return (int) Math.signum(m4807getDistanceimpl(arg0) - m4807getDistanceimpl(other));
    }
}

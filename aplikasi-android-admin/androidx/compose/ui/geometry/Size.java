package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

@JvmInline
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 32\u00020\u0001:\u00013B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u0007H\n¢\u0006\u0004\b\u0017\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u0007H\n¢\u0006\u0004\b\u0019\u0010\u000bJ*\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0007H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\"H\u0007¢\u0006\u0004\b+\u0010,J!\u0010-\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0007H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010 J\u000f\u0010/\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/compose/ui/geometry/Size;", "", "packedValue", "", "constructor-impl", "(J)J", "height", "", "getHeight$annotations", "()V", "getHeight-impl", "(J)F", "maxDimension", "getMaxDimension$annotations", "getMaxDimension-impl", "minDimension", "getMinDimension$annotations", "getMinDimension-impl", "getPackedValue$annotations", "width", "getWidth$annotations", "getWidth-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-xjbvk4A", "(JFF)J", "div", "operand", "div-7Ah8Wj8", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "isEmpty", "isEmpty-impl", "(J)Z", "times", "times-7Ah8Wj8", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
public final class Size {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Unspecified = SizeKt.Size(Float.NaN, Float.NaN);
    /* access modifiers changed from: private */
    public static final long Zero = SizeKt.Size(0.0f, 0.0f);
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Size m4770boximpl(long j) {
        return new Size(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m4773constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4777equalsimpl(long j, Object obj) {
        return (obj instanceof Size) && j == ((Size) obj).m4787unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4778equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getHeight$annotations() {
    }

    public static /* synthetic */ void getMaxDimension$annotations() {
    }

    public static /* synthetic */ void getMinDimension$annotations() {
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    public static /* synthetic */ void getWidth$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4783hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m4777equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m4783hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m4787unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ Size(long packedValue2) {
        this.packedValue = packedValue2;
    }

    /* renamed from: getWidth-impl  reason: not valid java name */
    public static final float m4782getWidthimpl(long arg0) {
        if (arg0 != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (arg0 >> 32));
        }
        throw new IllegalStateException("Size is unspecified".toString());
    }

    /* renamed from: getHeight-impl  reason: not valid java name */
    public static final float m4779getHeightimpl(long arg0) {
        if (arg0 != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (4294967295L & arg0));
        }
        throw new IllegalStateException("Size is unspecified".toString());
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m4771component1impl(long arg0) {
        return m4782getWidthimpl(arg0);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m4772component2impl(long arg0) {
        return m4779getHeightimpl(arg0);
    }

    /* renamed from: copy-xjbvk4A  reason: not valid java name */
    public static final long m4774copyxjbvk4A(long arg0, float width, float height) {
        return SizeKt.Size(width, height);
    }

    /* renamed from: copy-xjbvk4A$default  reason: not valid java name */
    public static /* synthetic */ long m4775copyxjbvk4A$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m4782getWidthimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m4779getHeightimpl(j);
        }
        return m4774copyxjbvk4A(j, f, f2);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R'\u0010\t\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/geometry/Size$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/geometry/Size;", "getUnspecified-NH-jbRc$annotations", "getUnspecified-NH-jbRc", "()J", "J", "Zero", "getZero-NH-jbRc$annotations", "getZero-NH-jbRc", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Size.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-NH-jbRc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4788getUnspecifiedNHjbRc$annotations() {
        }

        /* renamed from: getZero-NH-jbRc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4789getZeroNHjbRc$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getZero-NH-jbRc  reason: not valid java name */
        public final long m4791getZeroNHjbRc() {
            return Size.Zero;
        }

        /* renamed from: getUnspecified-NH-jbRc  reason: not valid java name */
        public final long m4790getUnspecifiedNHjbRc() {
            return Size.Unspecified;
        }
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static final boolean m4784isEmptyimpl(long arg0) {
        return m4782getWidthimpl(arg0) <= 0.0f || m4779getHeightimpl(arg0) <= 0.0f;
    }

    /* renamed from: times-7Ah8Wj8  reason: not valid java name */
    public static final long m4785times7Ah8Wj8(long arg0, float operand) {
        return SizeKt.Size(m4782getWidthimpl(arg0) * operand, m4779getHeightimpl(arg0) * operand);
    }

    /* renamed from: div-7Ah8Wj8  reason: not valid java name */
    public static final long m4776div7Ah8Wj8(long arg0, float operand) {
        return SizeKt.Size(m4782getWidthimpl(arg0) / operand, m4779getHeightimpl(arg0) / operand);
    }

    /* renamed from: getMinDimension-impl  reason: not valid java name */
    public static final float m4781getMinDimensionimpl(long arg0) {
        return Math.min(Math.abs(m4782getWidthimpl(arg0)), Math.abs(m4779getHeightimpl(arg0)));
    }

    /* renamed from: getMaxDimension-impl  reason: not valid java name */
    public static final float m4780getMaxDimensionimpl(long arg0) {
        return Math.max(Math.abs(m4782getWidthimpl(arg0)), Math.abs(m4779getHeightimpl(arg0)));
    }

    public String toString() {
        return m4786toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4786toStringimpl(long arg0) {
        if (arg0 != Companion.m4790getUnspecifiedNHjbRc()) {
            return "Size(" + GeometryUtilsKt.toStringAsFixed(m4782getWidthimpl(arg0), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m4779getHeightimpl(arg0), 1) + ')';
        }
        return "Size.Unspecified";
    }
}

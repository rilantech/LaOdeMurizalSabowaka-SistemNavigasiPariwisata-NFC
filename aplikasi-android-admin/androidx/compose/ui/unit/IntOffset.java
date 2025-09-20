package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

@JvmInline
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b@\u0018\u0000 32\u00020\u0001:\u00013B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u0010\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\fJ*\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\"\u0010\fJ\u001e\u0010#\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\nø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u001e\u0010&\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\nø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010%J!\u0010(\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J!\u0010+\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010\u001bJ\u000f\u0010-\u001a\u00020.H\u0017¢\u0006\u0004\b/\u00100J\u0019\u00101\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/compose/ui/unit/IntOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "", "getX$annotations", "getX-impl", "(J)I", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-iSbpLlY", "(JII)J", "div", "operand", "", "div-Bjo55l4", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "minus", "minus-qkQi6aY", "(JJ)J", "plus", "plus-qkQi6aY", "rem", "rem-Bjo55l4", "(JI)J", "times", "times-Bjo55l4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-nOcc-ac", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IntOffset.kt */
public final class IntOffset {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Zero = IntOffsetKt.IntOffset(0, 0);
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ IntOffset m7663boximpl(long j) {
        return new IntOffset(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m7666constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7670equalsimpl(long j, Object obj) {
        return (obj instanceof IntOffset) && j == ((IntOffset) obj).m7681unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7671equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    public static /* synthetic */ void getX$annotations() {
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7674hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m7670equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m7674hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m7681unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ IntOffset(long packedValue2) {
        this.packedValue = packedValue2;
    }

    /* renamed from: getX-impl  reason: not valid java name */
    public static final int m7672getXimpl(long arg0) {
        return (int) (arg0 >> 32);
    }

    /* renamed from: getY-impl  reason: not valid java name */
    public static final int m7673getYimpl(long arg0) {
        return (int) (4294967295L & arg0);
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final int m7664component1impl(long arg0) {
        return m7672getXimpl(arg0);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final int m7665component2impl(long arg0) {
        return m7673getYimpl(arg0);
    }

    /* renamed from: copy-iSbpLlY  reason: not valid java name */
    public static final long m7667copyiSbpLlY(long arg0, int x, int y) {
        return IntOffsetKt.IntOffset(x, y);
    }

    /* renamed from: copy-iSbpLlY$default  reason: not valid java name */
    public static /* synthetic */ long m7668copyiSbpLlY$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = m7672getXimpl(j);
        }
        if ((i3 & 2) != 0) {
            i2 = m7673getYimpl(j);
        }
        return m7667copyiSbpLlY(j, i, i2);
    }

    /* renamed from: minus-qkQi6aY  reason: not valid java name */
    public static final long m7675minusqkQi6aY(long arg0, long other) {
        return IntOffsetKt.IntOffset(m7672getXimpl(arg0) - m7672getXimpl(other), m7673getYimpl(arg0) - m7673getYimpl(other));
    }

    /* renamed from: plus-qkQi6aY  reason: not valid java name */
    public static final long m7676plusqkQi6aY(long arg0, long other) {
        return IntOffsetKt.IntOffset(m7672getXimpl(arg0) + m7672getXimpl(other), m7673getYimpl(arg0) + m7673getYimpl(other));
    }

    /* renamed from: unaryMinus-nOcc-ac  reason: not valid java name */
    public static final long m7680unaryMinusnOccac(long arg0) {
        return IntOffsetKt.IntOffset(-m7672getXimpl(arg0), -m7673getYimpl(arg0));
    }

    /* renamed from: times-Bjo55l4  reason: not valid java name */
    public static final long m7678timesBjo55l4(long arg0, float operand) {
        return IntOffsetKt.IntOffset(MathKt.roundToInt(((float) m7672getXimpl(arg0)) * operand), MathKt.roundToInt(((float) m7673getYimpl(arg0)) * operand));
    }

    /* renamed from: div-Bjo55l4  reason: not valid java name */
    public static final long m7669divBjo55l4(long arg0, float operand) {
        return IntOffsetKt.IntOffset(MathKt.roundToInt(((float) m7672getXimpl(arg0)) / operand), MathKt.roundToInt(((float) m7673getYimpl(arg0)) / operand));
    }

    /* renamed from: rem-Bjo55l4  reason: not valid java name */
    public static final long m7677remBjo55l4(long arg0, int operand) {
        return IntOffsetKt.IntOffset(m7672getXimpl(arg0) % operand, m7673getYimpl(arg0) % operand);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7679toStringimpl(long arg0) {
        return '(' + m7672getXimpl(arg0) + ", " + m7673getYimpl(arg0) + ')';
    }

    public String toString() {
        return m7679toStringimpl(this.packedValue);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/ui/unit/IntOffset$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/IntOffset;", "getZero-nOcc-ac", "()J", "J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: IntOffset.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getZero-nOcc-ac  reason: not valid java name */
        public final long m7682getZeronOccac() {
            return IntOffset.Zero;
        }
    }
}

package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@JvmInline
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0002\b\u0006\b@\u0018\u0000 G2\u00020\u0001:\u0001GB\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020 2\u0006\u0010!\u001a\u00020 ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0015\u0010\u001b\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020$¢\u0006\u0004\b\u001e\u0010%J\r\u0010&\u001a\u00020\u0018¢\u0006\u0004\b'\u0010\u001aJ\u0015\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\b-\u0010+J\u0015\u0010.\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\b/\u0010+J+\u00100\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e¢\u0006\u0004\b4\u00105J(\u00106\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u000eH\n¢\u0006\u0004\b8\u00109J\u001b\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u001e\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010=J\u000f\u0010A\u001a\u00020BH\u0016¢\u0006\u0004\bC\u0010DJ+\u0010E\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e¢\u0006\u0004\bF\u00105R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006H"}, d2 = {"Landroidx/compose/ui/graphics/Matrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "equals", "", "other", "equals-impl", "([FLjava/lang/Object;)Z", "get", "", "row", "", "column", "get-impl", "([FII)F", "hashCode", "hashCode-impl", "([F)I", "invert", "", "invert-impl", "([F)V", "map", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "map-impl", "([FLandroidx/compose/ui/geometry/MutableRect;)V", "Landroidx/compose/ui/geometry/Offset;", "point", "map-MK-Hz9U", "([FJ)J", "Landroidx/compose/ui/geometry/Rect;", "([FLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "reset", "reset-impl", "rotateX", "degrees", "rotateX-impl", "([FF)V", "rotateY", "rotateY-impl", "rotateZ", "rotateZ-impl", "scale", "x", "y", "z", "scale-impl", "([FFFF)V", "set", "v", "set-impl", "([FIIF)V", "setFrom", "matrix", "setFrom-58bKbWc", "([F[F)V", "timesAssign", "m", "timesAssign-58bKbWc", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "translate", "translate-impl", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Matrix.kt */
public final class Matrix {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int Perspective0 = 3;
    public static final int Perspective1 = 7;
    public static final int Perspective2 = 15;
    public static final int ScaleX = 0;
    public static final int ScaleY = 5;
    public static final int ScaleZ = 10;
    public static final int SkewX = 4;
    public static final int SkewY = 1;
    public static final int TranslateX = 12;
    public static final int TranslateY = 13;
    public static final int TranslateZ = 14;
    private final float[] values;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Matrix m5190boximpl(float[] fArr) {
        return new Matrix(fArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static float[] m5191constructorimpl(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "values");
        return fArr;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5193equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof Matrix) && Intrinsics.areEqual((Object) fArr, (Object) ((Matrix) obj).m5213unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5194equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual((Object) fArr, (Object) fArr2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5196hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    public boolean equals(Object obj) {
        return m5193equalsimpl(this.values, obj);
    }

    public int hashCode() {
        return m5196hashCodeimpl(this.values);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ float[] m5213unboximpl() {
        return this.values;
    }

    private /* synthetic */ Matrix(float[] values2) {
        this.values = values2;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ float[] m5192constructorimpl$default(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        return m5191constructorimpl(fArr);
    }

    public final float[] getValues() {
        return this.values;
    }

    /* renamed from: get-impl  reason: not valid java name */
    public static final float m5195getimpl(float[] arg0, int row, int column) {
        return arg0[(row * 4) + column];
    }

    /* renamed from: set-impl  reason: not valid java name */
    public static final void m5207setimpl(float[] arg0, int row, int column, float v) {
        arg0[(row * 4) + column] = v;
    }

    /* renamed from: map-MK-Hz9U  reason: not valid java name */
    public static final long m5198mapMKHz9U(float[] arg0, long point) {
        float x = Offset.m4713getXimpl(point);
        float y = Offset.m4714getYimpl(point);
        boolean z = true;
        float inverseZ = ((float) 1) / (((arg0[(0 * 4) + 3] * x) + (arg0[(1 * 4) + 3] * y)) + arg0[(3 * 4) + 3]);
        if (Float.isInfinite(inverseZ) || Float.isNaN(inverseZ)) {
            z = false;
        }
        float pZ = z ? inverseZ : 0.0f;
        return OffsetKt.Offset(((arg0[(0 * 4) + 0] * x) + (arg0[(1 * 4) + 0] * y) + arg0[(3 * 4) + 0]) * pZ, ((arg0[(0 * 4) + 1] * x) + (arg0[(1 * 4) + 1] * y) + arg0[(3 * 4) + 1]) * pZ);
    }

    /* renamed from: map-impl  reason: not valid java name */
    public static final Rect m5199mapimpl(float[] arg0, Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        long p0 = m5198mapMKHz9U(arg0, OffsetKt.Offset(rect.getLeft(), rect.getTop()));
        long p1 = m5198mapMKHz9U(arg0, OffsetKt.Offset(rect.getLeft(), rect.getBottom()));
        long p3 = m5198mapMKHz9U(arg0, OffsetKt.Offset(rect.getRight(), rect.getTop()));
        long p4 = m5198mapMKHz9U(arg0, OffsetKt.Offset(rect.getRight(), rect.getBottom()));
        return new Rect(Math.min(Math.min(Offset.m4713getXimpl(p0), Offset.m4713getXimpl(p1)), Math.min(Offset.m4713getXimpl(p3), Offset.m4713getXimpl(p4))), Math.min(Math.min(Offset.m4714getYimpl(p0), Offset.m4714getYimpl(p1)), Math.min(Offset.m4714getYimpl(p3), Offset.m4714getYimpl(p4))), Math.max(Math.max(Offset.m4713getXimpl(p0), Offset.m4713getXimpl(p1)), Math.max(Offset.m4713getXimpl(p3), Offset.m4713getXimpl(p4))), Math.max(Math.max(Offset.m4714getYimpl(p0), Offset.m4714getYimpl(p1)), Math.max(Offset.m4714getYimpl(p3), Offset.m4714getYimpl(p4))));
    }

    /* renamed from: map-impl  reason: not valid java name */
    public static final void m5200mapimpl(float[] arg0, MutableRect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        long p0 = m5198mapMKHz9U(arg0, OffsetKt.Offset(rect.getLeft(), rect.getTop()));
        long p1 = m5198mapMKHz9U(arg0, OffsetKt.Offset(rect.getLeft(), rect.getBottom()));
        long p3 = m5198mapMKHz9U(arg0, OffsetKt.Offset(rect.getRight(), rect.getTop()));
        long p4 = m5198mapMKHz9U(arg0, OffsetKt.Offset(rect.getRight(), rect.getBottom()));
        rect.setLeft(Math.min(Math.min(Offset.m4713getXimpl(p0), Offset.m4713getXimpl(p1)), Math.min(Offset.m4713getXimpl(p3), Offset.m4713getXimpl(p4))));
        rect.setTop(Math.min(Math.min(Offset.m4714getYimpl(p0), Offset.m4714getYimpl(p1)), Math.min(Offset.m4714getYimpl(p3), Offset.m4714getYimpl(p4))));
        rect.setRight(Math.max(Math.max(Offset.m4713getXimpl(p0), Offset.m4713getXimpl(p1)), Math.max(Offset.m4713getXimpl(p3), Offset.m4713getXimpl(p4))));
        rect.setBottom(Math.max(Math.max(Offset.m4714getYimpl(p0), Offset.m4714getYimpl(p1)), Math.max(Offset.m4714getYimpl(p3), Offset.m4714getYimpl(p4))));
    }

    /* renamed from: timesAssign-58bKbWc  reason: not valid java name */
    public static final void m5209timesAssign58bKbWc(float[] arg0, float[] m) {
        float[] fArr = arg0;
        float[] fArr2 = m;
        Intrinsics.checkNotNullParameter(fArr2, "m");
        float v00 = MatrixKt.m5215dotp89u6pk(fArr, 0, fArr2, 0);
        float v01 = MatrixKt.m5215dotp89u6pk(fArr, 0, fArr2, 1);
        float v02 = MatrixKt.m5215dotp89u6pk(fArr, 0, fArr2, 2);
        float v03 = MatrixKt.m5215dotp89u6pk(fArr, 0, fArr2, 3);
        float v10 = MatrixKt.m5215dotp89u6pk(fArr, 1, fArr2, 0);
        float v11 = MatrixKt.m5215dotp89u6pk(fArr, 1, fArr2, 1);
        float v12 = MatrixKt.m5215dotp89u6pk(fArr, 1, fArr2, 2);
        float v13 = MatrixKt.m5215dotp89u6pk(fArr, 1, fArr2, 3);
        float v20 = MatrixKt.m5215dotp89u6pk(fArr, 2, fArr2, 0);
        float v21 = MatrixKt.m5215dotp89u6pk(fArr, 2, fArr2, 1);
        float v22 = MatrixKt.m5215dotp89u6pk(fArr, 2, fArr2, 2);
        float v23 = MatrixKt.m5215dotp89u6pk(fArr, 2, fArr2, 3);
        float v30 = MatrixKt.m5215dotp89u6pk(fArr, 3, fArr2, 0);
        float v31 = MatrixKt.m5215dotp89u6pk(fArr, 3, fArr2, 1);
        float v32 = MatrixKt.m5215dotp89u6pk(fArr, 3, fArr2, 2);
        float v33 = MatrixKt.m5215dotp89u6pk(fArr, 3, fArr2, 3);
        fArr[(0 * 4) + 0] = v00;
        fArr[(0 * 4) + 1] = v01;
        fArr[(0 * 4) + 2] = v02;
        fArr[(0 * 4) + 3] = v03;
        fArr[(1 * 4) + 0] = v10;
        fArr[(1 * 4) + 1] = v11;
        fArr[(1 * 4) + 2] = v12;
        fArr[(1 * 4) + 3] = v13;
        fArr[(2 * 4) + 0] = v20;
        fArr[(2 * 4) + 1] = v21;
        fArr[(2 * 4) + 2] = v22;
        fArr[(2 * 4) + 3] = v23;
        fArr[(3 * 4) + 0] = v30;
        fArr[(3 * 4) + 1] = v31;
        fArr[(3 * 4) + 2] = v32;
        fArr[(3 * 4) + 3] = v33;
    }

    public String toString() {
        return m5210toStringimpl(this.values);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5210toStringimpl(float[] arg0) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n            |").append(arg0[(0 * 4) + 0]).append(' ').append(arg0[(0 * 4) + 1]).append(' ').append(arg0[(0 * 4) + 2]).append(' ').append(arg0[(0 * 4) + 3]).append("|\n            |").append(arg0[(1 * 4) + 0]).append(' ').append(arg0[(1 * 4) + 1]).append(' ').append(arg0[(1 * 4) + 2]).append(' ').append(arg0[(1 * 4) + 3]).append("|\n            |").append(arg0[(2 * 4) + 0]).append(' ').append(arg0[(2 * 4) + 1]).append(' ').append(arg0[(2 * 4) + 2]).append(' ');
        sb.append(arg0[(2 * 4) + 3]).append("|\n            |").append(arg0[(3 * 4) + 0]).append(' ').append(arg0[(3 * 4) + 1]).append(' ').append(arg0[(3 * 4) + 2]).append(' ').append(arg0[(3 * 4) + 3]).append("|\n        ");
        return StringsKt.trimIndent(sb.toString());
    }

    /* renamed from: invert-impl  reason: not valid java name */
    public static final void m5197invertimpl(float[] arg0) {
        float row$iv = arg0[(0 * 4) + 0];
        float row$iv2 = arg0[(0 * 4) + 1];
        float a02 = arg0[(0 * 4) + 2];
        float row$iv3 = arg0[(0 * 4) + 3];
        float row$iv4 = arg0[(1 * 4) + 0];
        float row$iv5 = arg0[(1 * 4) + 1];
        float row$iv6 = arg0[(1 * 4) + 2];
        float a13 = arg0[(1 * 4) + 3];
        float row$iv7 = arg0[(2 * 4) + 0];
        float row$iv8 = arg0[(2 * 4) + 1];
        float row$iv9 = arg0[(2 * 4) + 2];
        float row$iv10 = arg0[(2 * 4) + 3];
        float row$iv11 = arg0[(3 * 4) + 0];
        float row$iv12 = arg0[(3 * 4) + 1];
        float row$iv13 = arg0[(3 * 4) + 2];
        float row$iv14 = arg0[(3 * 4) + 3];
        float b00 = (row$iv * row$iv5) - (row$iv2 * row$iv4);
        float b01 = (row$iv * row$iv6) - (a02 * row$iv4);
        float b02 = (row$iv * a13) - (row$iv3 * row$iv4);
        float b03 = (row$iv2 * row$iv6) - (a02 * row$iv5);
        float b04 = (row$iv2 * a13) - (row$iv3 * row$iv5);
        float b05 = (a02 * a13) - (row$iv3 * row$iv6);
        float b06 = (row$iv7 * row$iv12) - (row$iv8 * row$iv11);
        float b07 = (row$iv7 * row$iv13) - (row$iv9 * row$iv11);
        float b08 = (row$iv7 * row$iv14) - (row$iv10 * row$iv11);
        float b09 = (row$iv8 * row$iv13) - (row$iv9 * row$iv12);
        float b10 = (row$iv8 * row$iv14) - (row$iv10 * row$iv12);
        float b11 = (row$iv9 * row$iv14) - (row$iv10 * row$iv13);
        float det = (((((b00 * b11) - (b01 * b10)) + (b02 * b09)) + (b03 * b08)) - (b04 * b07)) + (b05 * b06);
        if (!(det == 0.0f)) {
            float invDet = 1.0f / det;
            arg0[(0 * 4) + 0] = (((row$iv5 * b11) - (row$iv6 * b10)) + (a13 * b09)) * invDet;
            float a11 = row$iv5;
            arg0[(0 * 4) + 1] = ((((-row$iv2) * b11) + (a02 * b10)) - (row$iv3 * b09)) * invDet;
            arg0[(0 * 4) + 2] = (((row$iv12 * b05) - (row$iv13 * b04)) + (row$iv14 * b03)) * invDet;
            float a31 = row$iv12;
            arg0[(0 * 4) + 3] = ((((-row$iv8) * b05) + (row$iv9 * b04)) - (row$iv10 * b03)) * invDet;
            float a21 = row$iv8;
            arg0[(1 * 4) + 0] = ((((-row$iv4) * b11) + (row$iv6 * b08)) - (a13 * b07)) * invDet;
            arg0[(1 * 4) + 1] = (((row$iv * b11) - (a02 * b08)) + (row$iv3 * b07)) * invDet;
            arg0[(1 * 4) + 2] = ((((-row$iv11) * b05) + (row$iv13 * b02)) - (row$iv14 * b01)) * invDet;
            arg0[(1 * 4) + 3] = (((row$iv7 * b05) - (row$iv9 * b02)) + (row$iv10 * b01)) * invDet;
            arg0[(2 * 4) + 0] = (((row$iv4 * b10) - (a11 * b08)) + (a13 * b06)) * invDet;
            arg0[(2 * 4) + 1] = ((((-row$iv) * b10) + (row$iv2 * b08)) - (row$iv3 * b06)) * invDet;
            arg0[(2 * 4) + 2] = (((row$iv11 * b04) - (a31 * b02)) + (row$iv14 * b00)) * invDet;
            arg0[(2 * 4) + 3] = ((((-row$iv7) * b04) + (a21 * b02)) - (row$iv10 * b00)) * invDet;
            arg0[(3 * 4) + 0] = ((((-row$iv4) * b09) + (a11 * b07)) - (row$iv6 * b06)) * invDet;
            arg0[(3 * 4) + 1] = (((row$iv * b09) - (row$iv2 * b07)) + (a02 * b06)) * invDet;
            arg0[(3 * 4) + 2] = ((((-row$iv11) * b03) + (a31 * b01)) - (row$iv13 * b00)) * invDet;
            arg0[(3 * 4) + 3] = (((row$iv7 * b03) - (a21 * b01)) + (row$iv9 * b00)) * invDet;
        }
    }

    /* renamed from: reset-impl  reason: not valid java name */
    public static final void m5201resetimpl(float[] arg0) {
        int c = 0;
        while (c < 4) {
            int r = 0;
            while (r < 4) {
                arg0[(r * 4) + c] = c == r ? 1.0f : 0.0f;
                r++;
            }
            c++;
        }
    }

    /* renamed from: setFrom-58bKbWc  reason: not valid java name */
    public static final void m5208setFrom58bKbWc(float[] arg0, float[] matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        for (int i = 0; i < 16; i++) {
            arg0[i] = matrix[i];
        }
    }

    /* renamed from: rotateX-impl  reason: not valid java name */
    public static final void m5202rotateXimpl(float[] arg0, float degrees) {
        float f = degrees;
        float c = (float) Math.cos((((double) f) * 3.141592653589793d) / 180.0d);
        float s = (float) Math.sin((((double) f) * 3.141592653589793d) / 180.0d);
        int row$iv = arg0[(0 * 4) + 1];
        float a02 = arg0[(0 * 4) + 2];
        int row$iv2 = arg0[(1 * 4) + 1];
        int row$iv3 = arg0[(1 * 4) + 2];
        int row$iv4 = arg0[(2 * 4) + 1];
        int row$iv5 = arg0[(2 * 4) + 2];
        float a31 = arg0[(3 * 4) + 1];
        int row$iv6 = arg0[(3 * 4) + 2];
        arg0[(0 * 4) + 1] = (row$iv * c) - (a02 * s);
        arg0[(0 * 4) + 2] = (row$iv * s) + (a02 * c);
        arg0[(1 * 4) + 1] = (row$iv2 * c) - (row$iv3 * s);
        arg0[(1 * 4) + 2] = (row$iv2 * s) + (row$iv3 * c);
        arg0[(2 * 4) + 1] = (row$iv4 * c) - (row$iv5 * s);
        arg0[(2 * 4) + 2] = (row$iv4 * s) + (row$iv5 * c);
        arg0[(3 * 4) + 1] = (a31 * c) - (row$iv6 * s);
        arg0[(3 * 4) + 2] = (a31 * s) + (row$iv6 * c);
    }

    /* renamed from: rotateY-impl  reason: not valid java name */
    public static final void m5203rotateYimpl(float[] arg0, float degrees) {
        float f = degrees;
        float c = (float) Math.cos((((double) f) * 3.141592653589793d) / 180.0d);
        float s = (float) Math.sin((((double) f) * 3.141592653589793d) / 180.0d);
        int row$iv = arg0[(0 * 4) + 0];
        float a02 = arg0[(0 * 4) + 2];
        int row$iv2 = arg0[(1 * 4) + 0];
        int row$iv3 = arg0[(1 * 4) + 2];
        float a20 = arg0[(2 * 4) + 0];
        int row$iv4 = arg0[(2 * 4) + 2];
        int row$iv5 = arg0[(3 * 4) + 0];
        int row$iv6 = arg0[(3 * 4) + 2];
        arg0[(0 * 4) + 0] = (row$iv * c) + (a02 * s);
        arg0[(0 * 4) + 2] = ((-row$iv) * s) + (a02 * c);
        arg0[(1 * 4) + 0] = (row$iv2 * c) + (row$iv3 * s);
        arg0[(1 * 4) + 2] = ((-row$iv2) * s) + (row$iv3 * c);
        arg0[(2 * 4) + 0] = (a20 * c) + (row$iv4 * s);
        arg0[(2 * 4) + 2] = ((-a20) * s) + (row$iv4 * c);
        arg0[(3 * 4) + 0] = (row$iv5 * c) + (row$iv6 * s);
        arg0[(3 * 4) + 2] = ((-row$iv5) * s) + (row$iv6 * c);
    }

    /* renamed from: rotateZ-impl  reason: not valid java name */
    public static final void m5204rotateZimpl(float[] arg0, float degrees) {
        float f = degrees;
        float c = (float) Math.cos((((double) f) * 3.141592653589793d) / 180.0d);
        float s = (float) Math.sin((((double) f) * 3.141592653589793d) / 180.0d);
        int row$iv = arg0[(0 * 4) + 0];
        int row$iv2 = arg0[(1 * 4) + 0];
        int row$iv3 = arg0[(0 * 4) + 1];
        int row$iv4 = arg0[(1 * 4) + 1];
        float a02 = arg0[(0 * 4) + 2];
        int row$iv5 = arg0[(1 * 4) + 2];
        int row$iv6 = arg0[(0 * 4) + 3];
        float a13 = arg0[(1 * 4) + 3];
        arg0[(0 * 4) + 0] = (c * row$iv) + (s * row$iv2);
        arg0[(0 * 4) + 1] = (c * row$iv3) + (s * row$iv4);
        arg0[(0 * 4) + 2] = (c * a02) + (s * row$iv5);
        arg0[(0 * 4) + 3] = (c * row$iv6) + (s * a13);
        arg0[(1 * 4) + 0] = ((-s) * row$iv) + (c * row$iv2);
        arg0[(1 * 4) + 1] = ((-s) * row$iv3) + (c * row$iv4);
        arg0[(1 * 4) + 2] = ((-s) * a02) + (c * row$iv5);
        arg0[(1 * 4) + 3] = ((-s) * row$iv6) + (c * a13);
    }

    /* renamed from: scale-impl$default  reason: not valid java name */
    public static /* synthetic */ void m5206scaleimpl$default(float[] fArr, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 1.0f;
        }
        m5205scaleimpl(fArr, f, f2, f3);
    }

    /* renamed from: scale-impl  reason: not valid java name */
    public static final void m5205scaleimpl(float[] arg0, float x, float y, float z) {
        arg0[(0 * 4) + 0] = arg0[(0 * 4) + 0] * x;
        arg0[(0 * 4) + 1] = arg0[(0 * 4) + 1] * x;
        arg0[(0 * 4) + 2] = arg0[(0 * 4) + 2] * x;
        arg0[(0 * 4) + 3] = arg0[(0 * 4) + 3] * x;
        arg0[(1 * 4) + 0] = arg0[(1 * 4) + 0] * y;
        arg0[(1 * 4) + 1] = arg0[(1 * 4) + 1] * y;
        arg0[(1 * 4) + 2] = arg0[(1 * 4) + 2] * y;
        arg0[(1 * 4) + 3] = arg0[(1 * 4) + 3] * y;
        arg0[(2 * 4) + 0] = arg0[(2 * 4) + 0] * z;
        arg0[(2 * 4) + 1] = arg0[(2 * 4) + 1] * z;
        arg0[(2 * 4) + 2] = arg0[(2 * 4) + 2] * z;
        arg0[(2 * 4) + 3] = arg0[(2 * 4) + 3] * z;
    }

    /* renamed from: translate-impl$default  reason: not valid java name */
    public static /* synthetic */ void m5212translateimpl$default(float[] fArr, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        m5211translateimpl(fArr, f, f2, f3);
    }

    /* renamed from: translate-impl  reason: not valid java name */
    public static final void m5211translateimpl(float[] arg0, float x, float y, float z) {
        float t1 = (arg0[(0 * 4) + 0] * x) + (arg0[(1 * 4) + 0] * y) + (arg0[(2 * 4) + 0] * z) + arg0[(3 * 4) + 0];
        float t2 = (arg0[(0 * 4) + 1] * x) + (arg0[(1 * 4) + 1] * y) + (arg0[(2 * 4) + 1] * z) + arg0[(3 * 4) + 1];
        float t3 = (arg0[(0 * 4) + 2] * x) + (arg0[(1 * 4) + 2] * y) + (arg0[(2 * 4) + 2] * z) + arg0[(3 * 4) + 2];
        arg0[(3 * 4) + 0] = t1;
        arg0[(3 * 4) + 1] = t2;
        arg0[(3 * 4) + 2] = t3;
        arg0[(3 * 4) + 3] = (arg0[(0 * 4) + 3] * x) + (arg0[(1 * 4) + 3] * y) + (arg0[(2 * 4) + 3] * z) + arg0[(3 * 4) + 3];
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/Matrix$Companion;", "", "()V", "Perspective0", "", "Perspective1", "Perspective2", "ScaleX", "ScaleY", "ScaleZ", "SkewX", "SkewY", "TranslateX", "TranslateY", "TranslateZ", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Matrix.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\"\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007B<\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\fø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J8\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015H\u0010ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\n\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector;", "", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "destination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "transformSource", "transformDestination", "renderIntent", "transform", "", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I[FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDestination", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getRenderIntent-uksYyKA", "()I", "I", "getSource", "r", "", "g", "b", "v", "transformToColor", "Landroidx/compose/ui/graphics/Color;", "a", "transformToColor-wmQWz5c$ui_graphics_release", "(FFFF)J", "Companion", "RgbConnector", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Connector.kt */
public class Connector {
    public static final Companion Companion;
    /* access modifiers changed from: private */
    public static final Connector OklabToSrgbPerceptual = new Connector(ColorSpaces.INSTANCE.getOklab(), ColorSpaces.INSTANCE.getSrgb(), RenderIntent.Companion.m3726getPerceptualuksYyKA(), (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Connector SrgbIdentity;
    /* access modifiers changed from: private */
    public static final Connector SrgbToOklabPerceptual = new Connector(ColorSpaces.INSTANCE.getSrgb(), ColorSpaces.INSTANCE.getOklab(), RenderIntent.Companion.m3726getPerceptualuksYyKA(), (DefaultConstructorMarker) null);
    private final ColorSpace destination;
    private final int renderIntent;
    private final ColorSpace source;
    private final float[] transform;
    private final ColorSpace transformDestination;
    private final ColorSpace transformSource;

    public /* synthetic */ Connector(ColorSpace colorSpace, ColorSpace colorSpace2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorSpace, colorSpace2, i);
    }

    public /* synthetic */ Connector(ColorSpace colorSpace, ColorSpace colorSpace2, ColorSpace colorSpace3, ColorSpace colorSpace4, int i, float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorSpace, colorSpace2, colorSpace3, colorSpace4, i, fArr);
    }

    private Connector(ColorSpace source2, ColorSpace destination2, ColorSpace transformSource2, ColorSpace transformDestination2, int renderIntent2, float[] transform2) {
        Intrinsics.checkNotNullParameter(source2, "source");
        Intrinsics.checkNotNullParameter(destination2, "destination");
        Intrinsics.checkNotNullParameter(transformSource2, "transformSource");
        Intrinsics.checkNotNullParameter(transformDestination2, "transformDestination");
        this.source = source2;
        this.destination = destination2;
        this.transformSource = transformSource2;
        this.transformDestination = transformDestination2;
        this.renderIntent = renderIntent2;
        this.transform = transform2;
    }

    public final ColorSpace getSource() {
        return this.source;
    }

    public final ColorSpace getDestination() {
        return this.destination;
    }

    /* renamed from: getRenderIntent-uksYyKA  reason: not valid java name */
    public final int m3709getRenderIntentuksYyKA() {
        return this.renderIntent;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Connector(androidx.compose.ui.graphics.colorspace.ColorSpace r12, androidx.compose.ui.graphics.colorspace.ColorSpace r13, int r14) {
        /*
            r11 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "destination"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            long r0 = r12.m3705getModelxdoWZVw()
            androidx.compose.ui.graphics.colorspace.ColorModel$Companion r2 = androidx.compose.ui.graphics.colorspace.ColorModel.Companion
            long r2 = r2.m3703getRgbxdoWZVw()
            boolean r0 = androidx.compose.ui.graphics.colorspace.ColorModel.m3696equalsimpl0(r0, r2)
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L_0x002b
            androidx.compose.ui.graphics.colorspace.Illuminant r0 = androidx.compose.ui.graphics.colorspace.Illuminant.INSTANCE
            androidx.compose.ui.graphics.colorspace.WhitePoint r0 = r0.getD50()
            androidx.compose.ui.graphics.colorspace.ColorSpace r0 = androidx.compose.ui.graphics.colorspace.ColorSpaceKt.adapt$default(r12, r0, r2, r1, r2)
            r6 = r0
            goto L_0x002c
        L_0x002b:
            r6 = r12
        L_0x002c:
            long r3 = r13.m3705getModelxdoWZVw()
            androidx.compose.ui.graphics.colorspace.ColorModel$Companion r0 = androidx.compose.ui.graphics.colorspace.ColorModel.Companion
            long r7 = r0.m3703getRgbxdoWZVw()
            boolean r0 = androidx.compose.ui.graphics.colorspace.ColorModel.m3696equalsimpl0(r3, r7)
            if (r0 == 0) goto L_0x0048
            androidx.compose.ui.graphics.colorspace.Illuminant r0 = androidx.compose.ui.graphics.colorspace.Illuminant.INSTANCE
            androidx.compose.ui.graphics.colorspace.WhitePoint r0 = r0.getD50()
            androidx.compose.ui.graphics.colorspace.ColorSpace r0 = androidx.compose.ui.graphics.colorspace.ColorSpaceKt.adapt$default(r13, r0, r2, r1, r2)
            r7 = r0
            goto L_0x0049
        L_0x0048:
            r7 = r13
        L_0x0049:
            androidx.compose.ui.graphics.colorspace.Connector$Companion r0 = Companion
            float[] r9 = r0.m3712computeTransformYBCOT_4(r12, r13, r14)
            r10 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r8 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Connector.<init>(androidx.compose.ui.graphics.colorspace.ColorSpace, androidx.compose.ui.graphics.colorspace.ColorSpace, int):void");
    }

    public final float[] transform(float r, float g, float b) {
        return transform(new float[]{r, g, b});
    }

    public float[] transform(float[] v) {
        Intrinsics.checkNotNullParameter(v, "v");
        float[] xyz = this.transformSource.toXyz(v);
        float[] fArr = this.transform;
        if (fArr != null) {
            xyz[0] = xyz[0] * fArr[0];
            xyz[1] = xyz[1] * fArr[1];
            xyz[2] = xyz[2] * fArr[2];
        }
        return this.transformDestination.fromXyz(xyz);
    }

    /* renamed from: transformToColor-wmQWz5c$ui_graphics_release  reason: not valid java name */
    public long m3710transformToColorwmQWz5c$ui_graphics_release(float r, float g, float b, float a) {
        long packed = this.transformSource.toXy$ui_graphics_release(r, g, b);
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        float x = Float.intBitsToFloat((int) (packed >> 32));
        FloatCompanionObject floatCompanionObject2 = FloatCompanionObject.INSTANCE;
        float y = Float.intBitsToFloat((int) (4294967295L & packed));
        float z = this.transformSource.toZ$ui_graphics_release(r, g, b);
        float[] fArr = this.transform;
        if (fArr != null) {
            x *= fArr[0];
            y *= fArr[1];
            z *= fArr[2];
        }
        return this.transformDestination.m3706xyzaToColorJlNiLsg$ui_graphics_release(x, y, z, a, this.destination);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\"\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J-\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016J8\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0010ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector$RgbConnector;", "Landroidx/compose/ui/graphics/colorspace/Connector;", "mSource", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "mDestination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "mTransform", "", "computeTransform", "source", "destination", "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;I)[F", "transform", "v", "transformToColor", "Landroidx/compose/ui/graphics/Color;", "r", "", "g", "b", "a", "transformToColor-wmQWz5c$ui_graphics_release", "(FFFF)J", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Connector.kt */
    public static final class RgbConnector extends Connector {
        private final Rgb mDestination;
        private final Rgb mSource;
        private final float[] mTransform;

        public /* synthetic */ RgbConnector(Rgb rgb, Rgb rgb2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(rgb, rgb2, i);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private RgbConnector(Rgb mSource2, Rgb mDestination2, int intent) {
            super(mSource2, mDestination2, mSource2, mDestination2, intent, (float[]) null, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(mSource2, "mSource");
            Intrinsics.checkNotNullParameter(mDestination2, "mDestination");
            this.mSource = mSource2;
            this.mDestination = mDestination2;
            this.mTransform = m3714computeTransformYBCOT_4(mSource2, mDestination2, intent);
        }

        public float[] transform(float[] v) {
            Intrinsics.checkNotNullParameter(v, "v");
            v[0] = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke((double) v[0]);
            v[1] = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke((double) v[1]);
            v[2] = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke((double) v[2]);
            ColorSpaceKt.mul3x3Float3(this.mTransform, v);
            v[0] = (float) this.mDestination.getOetfFunc$ui_graphics_release().invoke((double) v[0]);
            v[1] = (float) this.mDestination.getOetfFunc$ui_graphics_release().invoke((double) v[1]);
            v[2] = (float) this.mDestination.getOetfFunc$ui_graphics_release().invoke((double) v[2]);
            return v;
        }

        /* renamed from: transformToColor-wmQWz5c$ui_graphics_release  reason: not valid java name */
        public long m3715transformToColorwmQWz5c$ui_graphics_release(float r, float g, float b, float a) {
            float v0 = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke((double) r);
            float v1 = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke((double) g);
            float v2 = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke((double) b);
            return ColorKt.Color((float) this.mDestination.getOetfFunc$ui_graphics_release().invoke((double) ColorSpaceKt.mul3x3Float3_0(this.mTransform, v0, v1, v2)), (float) this.mDestination.getOetfFunc$ui_graphics_release().invoke((double) ColorSpaceKt.mul3x3Float3_1(this.mTransform, v0, v1, v2)), (float) this.mDestination.getOetfFunc$ui_graphics_release().invoke((double) ColorSpaceKt.mul3x3Float3_2(this.mTransform, v0, v1, v2)), a, this.mDestination);
        }

        /* renamed from: computeTransform-YBCOT_4  reason: not valid java name */
        private final float[] m3714computeTransformYBCOT_4(Rgb source, Rgb destination, int intent) {
            if (ColorSpaceKt.compare(source.getWhitePoint(), destination.getWhitePoint())) {
                return ColorSpaceKt.mul3x3(destination.getInverseTransform$ui_graphics_release(), source.getTransform$ui_graphics_release());
            }
            float[] transform = source.getTransform$ui_graphics_release();
            float[] inverseTransform = destination.getInverseTransform$ui_graphics_release();
            float[] srcXYZ = source.getWhitePoint().toXyz$ui_graphics_release();
            float[] dstXYZ = destination.getWhitePoint().toXyz$ui_graphics_release();
            if (!ColorSpaceKt.compare(source.getWhitePoint(), Illuminant.INSTANCE.getD50())) {
                float[] transform$ui_graphics_release = Adaptation.Companion.getBradford().getTransform$ui_graphics_release();
                float[] d50Xyz$ui_graphics_release = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
                float[] copyOf = Arrays.copyOf(d50Xyz$ui_graphics_release, d50Xyz$ui_graphics_release.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                transform = ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(transform$ui_graphics_release, srcXYZ, copyOf), source.getTransform$ui_graphics_release());
            }
            if (!ColorSpaceKt.compare(destination.getWhitePoint(), Illuminant.INSTANCE.getD50())) {
                float[] transform$ui_graphics_release2 = Adaptation.Companion.getBradford().getTransform$ui_graphics_release();
                float[] d50Xyz$ui_graphics_release2 = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
                float[] copyOf2 = Arrays.copyOf(d50Xyz$ui_graphics_release2, d50Xyz$ui_graphics_release2.length);
                Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, size)");
                inverseTransform = ColorSpaceKt.inverse3x3(ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(transform$ui_graphics_release2, dstXYZ, copyOf2), destination.getTransform$ui_graphics_release()));
            }
            if (RenderIntent.m3721equalsimpl0(intent, RenderIntent.Companion.m3725getAbsoluteuksYyKA())) {
                transform = ColorSpaceKt.mul3x3Diag(new float[]{srcXYZ[0] / dstXYZ[0], srcXYZ[1] / dstXYZ[1], srcXYZ[2] / dstXYZ[2]}, transform);
            }
            return ColorSpaceKt.mul3x3(inverseTransform, transform);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0015R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector$Companion;", "", "()V", "OklabToSrgbPerceptual", "Landroidx/compose/ui/graphics/colorspace/Connector;", "getOklabToSrgbPerceptual$ui_graphics_release", "()Landroidx/compose/ui/graphics/colorspace/Connector;", "SrgbIdentity", "getSrgbIdentity$ui_graphics_release", "SrgbToOklabPerceptual", "getSrgbToOklabPerceptual$ui_graphics_release", "computeTransform", "", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "destination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)[F", "identity", "identity$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Connector.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        /* renamed from: computeTransform-YBCOT_4  reason: not valid java name */
        public final float[] m3712computeTransformYBCOT_4(ColorSpace source, ColorSpace destination, int intent) {
            if (!RenderIntent.m3721equalsimpl0(intent, RenderIntent.Companion.m3725getAbsoluteuksYyKA())) {
                return null;
            }
            boolean srcRGB = ColorModel.m3696equalsimpl0(source.m3705getModelxdoWZVw(), ColorModel.Companion.m3703getRgbxdoWZVw());
            boolean dstRGB = ColorModel.m3696equalsimpl0(destination.m3705getModelxdoWZVw(), ColorModel.Companion.m3703getRgbxdoWZVw());
            if (srcRGB && dstRGB) {
                return null;
            }
            if (!srcRGB && !dstRGB) {
                return null;
            }
            ColorSpace colorSpace = srcRGB ? source : destination;
            Intrinsics.checkNotNull(colorSpace, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            Rgb rgb = (Rgb) colorSpace;
            float[] srcXYZ = srcRGB ? rgb.getWhitePoint().toXyz$ui_graphics_release() : Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            float[] dstXYZ = dstRGB ? rgb.getWhitePoint().toXyz$ui_graphics_release() : Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            return new float[]{srcXYZ[0] / dstXYZ[0], srcXYZ[1] / dstXYZ[1], srcXYZ[2] / dstXYZ[2]};
        }

        public final Connector identity$ui_graphics_release(ColorSpace source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new Connector$Companion$identity$1(source, RenderIntent.Companion.m3727getRelativeuksYyKA());
        }

        public final Connector getSrgbIdentity$ui_graphics_release() {
            return Connector.SrgbIdentity;
        }

        public final Connector getSrgbToOklabPerceptual$ui_graphics_release() {
            return Connector.SrgbToOklabPerceptual;
        }

        public final Connector getOklabToSrgbPerceptual$ui_graphics_release() {
            return Connector.OklabToSrgbPerceptual;
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        SrgbIdentity = companion.identity$ui_graphics_release(ColorSpaces.INSTANCE.getSrgb());
    }
}

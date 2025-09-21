package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B$\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0013\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J%\u0010$\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\f\u0010'\u001a\u00020(*\u00020)H\u0014R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R%\u0010\r\u001a\u00020\u000eX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u00020\u00158VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u0007X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0006\u001a\u00020\u0007X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/ui/graphics/painter/BitmapPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "(Landroidx/compose/ui/graphics/ImageBitmap;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getFilterQuality-f-v9h1I$ui_graphics_release", "()I", "setFilterQuality-vDHp3xo$ui_graphics_release", "(I)V", "I", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "size", "J", "applyAlpha", "", "applyColorFilter", "equals", "other", "", "hashCode", "", "toString", "", "validateSize", "validateSize-N5eqBDc", "(JJ)J", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BitmapPainter.kt */
public final class BitmapPainter extends Painter {
    private float alpha;
    private ColorFilter colorFilter;
    private int filterQuality;
    private final ImageBitmap image;
    private final long size;
    private final long srcOffset;
    private final long srcSize;

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageBitmap, j, j2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BitmapPainter(androidx.compose.ui.graphics.ImageBitmap r8, long r9, long r11, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 2
            if (r14 == 0) goto L_0x000c
            androidx.compose.ui.unit.IntOffset$Companion r9 = androidx.compose.ui.unit.IntOffset.Companion
            long r9 = r9.m5972getZeronOccac()
            r2 = r9
            goto L_0x000d
        L_0x000c:
            r2 = r9
        L_0x000d:
            r9 = r13 & 4
            if (r9 == 0) goto L_0x001f
            int r9 = r8.getWidth()
            int r10 = r8.getHeight()
            long r11 = androidx.compose.ui.unit.IntSizeKt.IntSize(r9, r10)
            r4 = r11
            goto L_0x0020
        L_0x001f:
            r4 = r11
        L_0x0020:
            r6 = 0
            r0 = r7
            r1 = r8
            r0.<init>(r1, r2, r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.painter.BitmapPainter.<init>(androidx.compose.ui.graphics.ImageBitmap, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private BitmapPainter(ImageBitmap image2, long srcOffset2, long srcSize2) {
        Intrinsics.checkNotNullParameter(image2, "image");
        this.image = image2;
        this.srcOffset = srcOffset2;
        this.srcSize = srcSize2;
        this.filterQuality = FilterQuality.Companion.m3350getLowfv9h1I();
        this.size = m3950validateSizeN5eqBDc(srcOffset2, srcSize2);
        this.alpha = 1.0f;
    }

    /* renamed from: getFilterQuality-f-v9h1I$ui_graphics_release  reason: not valid java name */
    public final int m3951getFilterQualityfv9h1I$ui_graphics_release() {
        return this.filterQuality;
    }

    /* renamed from: setFilterQuality-vDHp3xo$ui_graphics_release  reason: not valid java name */
    public final void m3953setFilterQualityvDHp3xo$ui_graphics_release(int i) {
        this.filterQuality = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(DrawScope $this$onDraw) {
        Intrinsics.checkNotNullParameter($this$onDraw, "<this>");
        DrawScope.m3831drawImageAZ2fEMs$default($this$onDraw, this.image, this.srcOffset, this.srcSize, 0, IntSizeKt.IntSize(MathKt.roundToInt(Size.m3072getWidthimpl($this$onDraw.m3866getSizeNHjbRc())), MathKt.roundToInt(Size.m3069getHeightimpl($this$onDraw.m3866getSizeNHjbRc()))), this.alpha, (DrawStyle) null, this.colorFilter, 0, this.filterQuality, 328, (Object) null);
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m3952getIntrinsicSizeNHjbRc() {
        return IntSizeKt.m6014toSizeozmzZPI(this.size);
    }

    /* access modifiers changed from: protected */
    public boolean applyAlpha(float alpha2) {
        this.alpha = alpha2;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean applyColorFilter(ColorFilter colorFilter2) {
        this.colorFilter = colorFilter2;
        return true;
    }

    /* renamed from: validateSize-N5eqBDc  reason: not valid java name */
    private final long m3950validateSizeN5eqBDc(long srcOffset2, long srcSize2) {
        if (IntOffset.m5962getXimpl(srcOffset2) >= 0 && IntOffset.m5963getYimpl(srcOffset2) >= 0 && IntSize.m6004getWidthimpl(srcSize2) >= 0 && IntSize.m6003getHeightimpl(srcSize2) >= 0 && IntSize.m6004getWidthimpl(srcSize2) <= this.image.getWidth() && IntSize.m6003getHeightimpl(srcSize2) <= this.image.getHeight()) {
            return srcSize2;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof BitmapPainter) && Intrinsics.areEqual((Object) this.image, (Object) ((BitmapPainter) other).image) && IntOffset.m5961equalsimpl0(this.srcOffset, ((BitmapPainter) other).srcOffset) && IntSize.m6002equalsimpl0(this.srcSize, ((BitmapPainter) other).srcSize) && FilterQuality.m3345equalsimpl0(this.filterQuality, ((BitmapPainter) other).filterQuality)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.image.hashCode() * 31) + IntOffset.m5964hashCodeimpl(this.srcOffset)) * 31) + IntSize.m6005hashCodeimpl(this.srcSize)) * 31) + FilterQuality.m3346hashCodeimpl(this.filterQuality);
    }

    public String toString() {
        return "BitmapPainter(image=" + this.image + ", srcOffset=" + IntOffset.m5969toStringimpl(this.srcOffset) + ", srcSize=" + IntSize.m6007toStringimpl(this.srcSize) + ", filterQuality=" + FilterQuality.m3347toStringimpl(this.filterQuality) + ')';
    }
}

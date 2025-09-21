package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bf\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0018Bf\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001bBp\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0013\u0010:\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010<\u001a\u00020\u000bH\u0016J\b\u0010=\u001a\u00020>H\u0016R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010*\u001a\u0004\b)\u0010(R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010\u0014\u001a\u00020\u00158FX\u0004¢\u0006\f\u0012\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00106\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006?"}, d2 = {"Landroidx/compose/ui/text/TextLayoutInput;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)V", "_developerSuppliedResourceLoader", "getConstraints-msEJaDk", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getMaxLines", "()I", "getOverflow-gIe3tQ8", "I", "getPlaceholders", "()Ljava/util/List;", "getResourceLoader$annotations", "()V", "getResourceLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getSoftWrap", "()Z", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "copy", "copy-hu-1Yfo", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;J)Landroidx/compose/ui/text/TextLayoutInput;", "equals", "other", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLayoutResult.kt */
public final class TextLayoutInput {
    public static final int $stable = 8;
    private Font.ResourceLoader _developerSuppliedResourceLoader;
    private final long constraints;
    private final Density density;
    private final FontFamily.Resolver fontFamilyResolver;
    private final LayoutDirection layoutDirection;
    private final int maxLines;
    private final int overflow;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    @Deprecated(message = "Font.ResourceLoader is replaced with FontFamily.Resolver", replaceWith = @ReplaceWith(expression = "TextLayoutInput(text, style, placeholders, maxLines, softWrap, overflow, density, layoutDirection, fontFamilyResolver, constraints", imports = {}))
    public /* synthetic */ TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List list, int i, boolean z, int i2, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, (List<AnnotatedString.Range<Placeholder>>) list, i, z, i2, density2, layoutDirection2, resourceLoader, j);
    }

    public /* synthetic */ TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List list, int i, boolean z, int i2, Density density2, LayoutDirection layoutDirection2, FontFamily.Resolver resolver, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, (List<AnnotatedString.Range<Placeholder>>) list, i, z, i2, density2, layoutDirection2, resolver, j);
    }

    @Deprecated(message = "Replaced with FontFamily.Resolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getResourceLoader$annotations() {
    }

    private TextLayoutInput(AnnotatedString text2, TextStyle style2, List<AnnotatedString.Range<Placeholder>> placeholders2, int maxLines2, boolean softWrap2, int overflow2, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader, FontFamily.Resolver fontFamilyResolver2, long constraints2) {
        this.text = text2;
        this.style = style2;
        this.placeholders = placeholders2;
        this.maxLines = maxLines2;
        this.softWrap = softWrap2;
        this.overflow = overflow2;
        this.density = density2;
        this.layoutDirection = layoutDirection2;
        this.fontFamilyResolver = fontFamilyResolver2;
        this.constraints = constraints2;
        this._developerSuppliedResourceLoader = resourceLoader;
    }

    public final AnnotatedString getText() {
        return this.text;
    }

    public final TextStyle getStyle() {
        return this.style;
    }

    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final boolean getSoftWrap() {
        return this.softWrap;
    }

    /* renamed from: getOverflow-gIe3tQ8  reason: not valid java name */
    public final int m7004getOverflowgIe3tQ8() {
        return this.overflow;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public final long m7003getConstraintsmsEJaDk() {
        return this.constraints;
    }

    public final Font.ResourceLoader getResourceLoader() {
        Font.ResourceLoader resourceLoader = this._developerSuppliedResourceLoader;
        if (resourceLoader == null) {
            return DeprecatedBridgeFontResourceLoader.Companion.from(this.fontFamilyResolver);
        }
        return resourceLoader;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextLayoutInput(androidx.compose.ui.text.AnnotatedString r17, androidx.compose.ui.text.TextStyle r18, java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> r19, int r20, boolean r21, int r22, androidx.compose.ui.unit.Density r23, androidx.compose.ui.unit.LayoutDirection r24, androidx.compose.ui.text.font.Font.ResourceLoader r25, long r26) {
        /*
            r16 = this;
            java.lang.String r0 = "text"
            r14 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "style"
            r15 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "placeholders"
            r12 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "density"
            r13 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "layoutDirection"
            r11 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "resourceLoader"
            r10 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            androidx.compose.ui.text.font.FontFamily$Resolver r0 = androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(r25)
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            r11 = r0
            r12 = r26
            r1.<init>((androidx.compose.ui.text.AnnotatedString) r2, (androidx.compose.ui.text.TextStyle) r3, (java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>>) r4, (int) r5, (boolean) r6, (int) r7, (androidx.compose.ui.unit.Density) r8, (androidx.compose.ui.unit.LayoutDirection) r9, (androidx.compose.ui.text.font.Font.ResourceLoader) r10, (androidx.compose.ui.text.font.FontFamily.Resolver) r11, (long) r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextLayoutInput.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, java.util.List, int, boolean, int, androidx.compose.ui.unit.Density, androidx.compose.ui.unit.LayoutDirection, androidx.compose.ui.text.font.Font$ResourceLoader, long):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private TextLayoutInput(AnnotatedString text2, TextStyle style2, List<AnnotatedString.Range<Placeholder>> placeholders2, int maxLines2, boolean softWrap2, int overflow2, Density density2, LayoutDirection layoutDirection2, FontFamily.Resolver fontFamilyResolver2, long constraints2) {
        this(text2, style2, placeholders2, maxLines2, softWrap2, overflow2, density2, layoutDirection2, (Font.ResourceLoader) null, fontFamilyResolver2, constraints2);
        Intrinsics.checkNotNullParameter(text2, "text");
        Intrinsics.checkNotNullParameter(style2, "style");
        Intrinsics.checkNotNullParameter(placeholders2, "placeholders");
        Intrinsics.checkNotNullParameter(density2, "density");
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        Intrinsics.checkNotNullParameter(fontFamilyResolver2, "fontFamilyResolver");
    }

    /* renamed from: copy-hu-1Yfo$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutInput m7001copyhu1Yfo$default(TextLayoutInput textLayoutInput, AnnotatedString annotatedString, TextStyle textStyle, List list, int i, boolean z, int i2, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader, long j, int i3, Object obj) {
        AnnotatedString annotatedString2;
        TextStyle textStyle2;
        List list2;
        int i4;
        boolean z2;
        int i5;
        Density density3;
        LayoutDirection layoutDirection3;
        Font.ResourceLoader resourceLoader2;
        long j2;
        TextLayoutInput textLayoutInput2 = textLayoutInput;
        int i6 = i3;
        if ((i6 & 1) != 0) {
            annotatedString2 = textLayoutInput2.text;
        } else {
            annotatedString2 = annotatedString;
        }
        if ((i6 & 2) != 0) {
            textStyle2 = textLayoutInput2.style;
        } else {
            textStyle2 = textStyle;
        }
        if ((i6 & 4) != 0) {
            list2 = textLayoutInput2.placeholders;
        } else {
            list2 = list;
        }
        if ((i6 & 8) != 0) {
            i4 = textLayoutInput2.maxLines;
        } else {
            i4 = i;
        }
        if ((i6 & 16) != 0) {
            z2 = textLayoutInput2.softWrap;
        } else {
            z2 = z;
        }
        if ((i6 & 32) != 0) {
            i5 = textLayoutInput2.overflow;
        } else {
            i5 = i2;
        }
        if ((i6 & 64) != 0) {
            density3 = textLayoutInput2.density;
        } else {
            density3 = density2;
        }
        if ((i6 & 128) != 0) {
            layoutDirection3 = textLayoutInput2.layoutDirection;
        } else {
            layoutDirection3 = layoutDirection2;
        }
        if ((i6 & 256) != 0) {
            resourceLoader2 = textLayoutInput.getResourceLoader();
        } else {
            resourceLoader2 = resourceLoader;
        }
        if ((i6 & 512) != 0) {
            j2 = textLayoutInput2.constraints;
        } else {
            j2 = j;
        }
        return textLayoutInput.m7002copyhu1Yfo(annotatedString2, textStyle2, list2, i4, z2, i5, density3, layoutDirection3, resourceLoader2, j2);
    }

    @Deprecated(message = "Font.ResourceLoader is deprecated", replaceWith = @ReplaceWith(expression = "TextLayoutInput(text, style, placeholders, maxLines, softWrap, overFlow, density, layoutDirection, fontFamilyResolver, constraints)", imports = {}))
    /* renamed from: copy-hu-1Yfo  reason: not valid java name */
    public final TextLayoutInput m7002copyhu1Yfo(AnnotatedString text2, TextStyle style2, List<AnnotatedString.Range<Placeholder>> placeholders2, int maxLines2, boolean softWrap2, int overflow2, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader, long constraints2) {
        Intrinsics.checkNotNullParameter(text2, "text");
        Intrinsics.checkNotNullParameter(style2, "style");
        Intrinsics.checkNotNullParameter(placeholders2, "placeholders");
        Intrinsics.checkNotNullParameter(density2, "density");
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        Font.ResourceLoader resourceLoader2 = resourceLoader;
        Intrinsics.checkNotNullParameter(resourceLoader2, "resourceLoader");
        return new TextLayoutInput(text2, style2, placeholders2, maxLines2, softWrap2, overflow2, density2, layoutDirection2, resourceLoader2, this.fontFamilyResolver, constraints2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TextLayoutInput) && Intrinsics.areEqual((Object) this.text, (Object) ((TextLayoutInput) other).text) && Intrinsics.areEqual((Object) this.style, (Object) ((TextLayoutInput) other).style) && Intrinsics.areEqual((Object) this.placeholders, (Object) ((TextLayoutInput) other).placeholders) && this.maxLines == ((TextLayoutInput) other).maxLines && this.softWrap == ((TextLayoutInput) other).softWrap && TextOverflow.m7459equalsimpl0(this.overflow, ((TextLayoutInput) other).overflow) && Intrinsics.areEqual((Object) this.density, (Object) ((TextLayoutInput) other).density) && this.layoutDirection == ((TextLayoutInput) other).layoutDirection && Intrinsics.areEqual((Object) this.fontFamilyResolver, (Object) ((TextLayoutInput) other).fontFamilyResolver) && Constraints.m7491equalsimpl0(this.constraints, ((TextLayoutInput) other).constraints)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.text.hashCode() * 31) + this.style.hashCode()) * 31) + this.placeholders.hashCode()) * 31) + this.maxLines) * 31) + Boolean.hashCode(this.softWrap)) * 31) + TextOverflow.m7460hashCodeimpl(this.overflow)) * 31) + this.density.hashCode()) * 31) + this.layoutDirection.hashCode()) * 31) + this.fontFamilyResolver.hashCode()) * 31) + Constraints.m7501hashCodeimpl(this.constraints);
    }

    public String toString() {
        return "TextLayoutInput(text=" + this.text + ", style=" + this.style + ", placeholders=" + this.placeholders + ", maxLines=" + this.maxLines + ", softWrap=" + this.softWrap + ", overflow=" + TextOverflow.m7461toStringimpl(this.overflow) + ", density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", fontFamilyResolver=" + this.fontFamilyResolver + ", constraints=" + Constraints.m7503toStringimpl(this.constraints) + ')';
    }
}

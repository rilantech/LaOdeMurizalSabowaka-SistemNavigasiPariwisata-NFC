package androidx.compose.ui.text;

import android.graphics.RectF;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.selection.WordBoundary;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001Bj\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0016B(\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u0019JJ\u0010Q\u001a\u0002002\u0006\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020\r2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010V\u001a\u00020\r2\u0006\u0010W\u001a\u00020\r2\u0006\u0010X\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\rH\u0002J+\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\rø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010bJ\u0010\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010f\u001a\u00020<2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010g\u001a\u00020<2\u0006\u0010e\u001a\u00020\rH\u0016J\u0018\u0010h\u001a\u00020(2\u0006\u0010e\u001a\u00020\r2\u0006\u0010i\u001a\u00020\u000fH\u0016J\u0015\u0010j\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0000¢\u0006\u0002\blJ\u0015\u0010m\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0000¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u0015\u0010p\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0000¢\u0006\u0002\bqJ\u0018\u0010r\u001a\u00020\r2\u0006\u0010k\u001a\u00020\r2\u0006\u0010s\u001a\u00020\u000fH\u0016J\u0010\u0010t\u001a\u00020\r2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010u\u001a\u00020\r2\u0006\u0010v\u001a\u00020(H\u0016J\u0010\u0010w\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u0010\u0010x\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u0010\u0010y\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u0010\u0010z\u001a\u00020\r2\u0006\u0010k\u001a\u00020\rH\u0016J\u0010\u0010{\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u0010\u0010|\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u001f\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020d2\u0006\u0010e\u001a\u00020\rH\u0016J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\rH\u0016J\"\u0010M\u001a\u00020]2\u0006\u0010e\u001a\u00020\rH\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020\rH\u0016J\u0013\u0010\u0001\u001a\u00020[2\b\u0010\u0001\u001a\u00030\u0001H\u0002Jc\u0010\u0001\u001a\u00020[2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020(2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JD\u0010\u0001\u001a\u00020[2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JZ\u0010\u0001\u001a\u00020[2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010 \u0001\u001a\n\u0012\u0005\u0012\u00030¢\u00010¡\u0001*\u000200H\u0002¢\u0006\u0003\u0010£\u0001R\u001c\u0010\u001a\u001a\u00020\u001b8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010*R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b6\u00103R\u0014\u00107\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b8\u0010*R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@8@X\u0004¢\u0006\f\u0012\u0004\bA\u0010\u001d\u001a\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020E8@X\u0004¢\u0006\f\u0012\u0004\bF\u0010\u001d\u001a\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010*R\u001b\u0010K\u001a\u00020L8BX\u0002¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bM\u0010N\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¤\u0001"}, d2 = {"Landroidx/compose/ui/text/AndroidParagraph;", "Landroidx/compose/ui/text/Paragraph;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "ellipsis", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "density", "Landroidx/compose/ui/unit/Density;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;IZJLandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "(Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;IZJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "charSequence", "", "getCharSequence$ui_text_release$annotations", "()V", "getCharSequence$ui_text_release", "()Ljava/lang/CharSequence;", "getConstraints-msEJaDk", "()J", "J", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "getEllipsis", "firstBaseline", "", "getFirstBaseline", "()F", "height", "getHeight", "lastBaseline", "getLastBaseline", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "getParagraphIntrinsics", "()Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "textLocale", "Ljava/util/Locale;", "getTextLocale$ui_text_release$annotations", "getTextLocale$ui_text_release", "()Ljava/util/Locale;", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text_release$annotations", "getTextPaint$ui_text_release", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "width", "getWidth", "wordBoundary", "Landroidx/compose/ui/text/android/selection/WordBoundary;", "getWordBoundary", "()Landroidx/compose/ui/text/android/selection/WordBoundary;", "wordBoundary$delegate", "Lkotlin/Lazy;", "constructTextLayout", "alignment", "justificationMode", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "hyphens", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "fillBoundingBoxes", "", "range", "Landroidx/compose/ui/text/TextRange;", "array", "", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)V", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineAscent", "lineIndex", "getLineAscent$ui_text_release", "getLineBaseline", "getLineBaseline$ui_text_release", "getLineBottom", "getLineDescent", "getLineDescent$ui_text_release", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getWordBoundary--jx7JFs", "(I)J", "isLineEllipsized", "paint", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "getShaderBrushSpans", "", "Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidParagraph.android.kt */
public final class AndroidParagraph implements Paragraph {
    private final CharSequence charSequence;
    private final long constraints;
    private final boolean ellipsis;
    /* access modifiers changed from: private */
    public final TextLayout layout;
    private final int maxLines;
    private final AndroidParagraphIntrinsics paragraphIntrinsics;
    private final List<Rect> placeholderRects;
    private final Lazy wordBoundary$delegate;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidParagraph.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResolvedTextDirection.values().length];
            try {
                iArr[ResolvedTextDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ResolvedTextDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i, boolean z, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(androidParagraphIntrinsics, i, z, j);
    }

    public /* synthetic */ AndroidParagraph(String str, TextStyle textStyle, List list, List list2, int i, boolean z, long j, FontFamily.Resolver resolver, Density density, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, list, list2, i, z, j, resolver, density);
    }

    public static /* synthetic */ void getCharSequence$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getTextLocale$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getTextPaint$ui_text_release$annotations() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.util.List<androidx.compose.ui.geometry.Rect>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AndroidParagraph(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics r34, int r35, boolean r36, long r37) {
        /*
            r33 = this;
            r13 = r33
            r14 = r34
            r15 = r35
            r12 = r36
            java.lang.String r0 = "paragraphIntrinsics"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r33.<init>()
            r13.paragraphIntrinsics = r14
            r13.maxLines = r15
            r13.ellipsis = r12
            r10 = r37
            r13.constraints = r10
            int r0 = androidx.compose.ui.unit.Constraints.m7499getMinHeightimpl(r37)
            r9 = 0
            r8 = 1
            if (r0 != 0) goto L_0x002c
            int r0 = androidx.compose.ui.unit.Constraints.m7500getMinWidthimpl(r37)
            if (r0 != 0) goto L_0x002c
            r0 = r8
            goto L_0x002d
        L_0x002c:
            r0 = r9
        L_0x002d:
            if (r0 == 0) goto L_0x0340
            if (r15 < r8) goto L_0x0033
            r0 = r8
            goto L_0x0034
        L_0x0033:
            r0 = r9
        L_0x0034:
            if (r0 == 0) goto L_0x0331
            androidx.compose.ui.text.TextStyle r7 = r34.getStyle()
            boolean r0 = androidx.compose.ui.text.AndroidParagraph_androidKt.shouldAttachIndentationFixSpan(r7, r12)
            if (r0 == 0) goto L_0x0049
            java.lang.CharSequence r0 = r34.getCharSequence$ui_text_release()
            java.lang.CharSequence r0 = androidx.compose.ui.text.AndroidParagraph_androidKt.attachIndentationFixSpan(r0)
            goto L_0x004d
        L_0x0049:
            java.lang.CharSequence r0 = r34.getCharSequence$ui_text_release()
        L_0x004d:
            r13.charSequence = r0
            androidx.compose.ui.text.style.TextAlign r0 = r7.m7064getTextAlignbuA522U()
            int r16 = androidx.compose.ui.text.AndroidParagraph_androidKt.m6900toLayoutAlignAMY3VfE(r0)
            androidx.compose.ui.text.style.TextAlign r0 = r7.m7064getTextAlignbuA522U()
            androidx.compose.ui.text.style.TextAlign$Companion r1 = androidx.compose.ui.text.style.TextAlign.Companion
            int r1 = r1.m7419getJustifye0LSkKk()
            if (r0 != 0) goto L_0x0065
            r0 = r9
            goto L_0x006d
        L_0x0065:
            int r0 = r0.m7416unboximpl()
            boolean r0 = androidx.compose.ui.text.style.TextAlign.m7413equalsimpl0(r0, r1)
        L_0x006d:
            if (r0 == 0) goto L_0x0071
            r2 = r8
            goto L_0x0072
        L_0x0071:
            r2 = r9
        L_0x0072:
            androidx.compose.ui.text.ParagraphStyle r0 = r7.getParagraphStyle$ui_text_release()
            androidx.compose.ui.text.style.Hyphens r0 = r0.m6945getHyphensEaSxIns()
            int r17 = androidx.compose.ui.text.AndroidParagraph_androidKt.m6902toLayoutHyphenationFrequency0_XeFpE(r0)
            androidx.compose.ui.text.style.LineBreak r0 = r7.m7062getLineBreakLgCVezo()
            r18 = 0
            if (r0 == 0) goto L_0x0094
            int r0 = r0.m7350unboximpl()
            int r0 = androidx.compose.ui.text.style.LineBreak.m7345getStrategyfcGXIks(r0)
            androidx.compose.ui.text.style.LineBreak$Strategy r0 = androidx.compose.ui.text.style.LineBreak.Strategy.m7354boximpl(r0)
            goto L_0x0096
        L_0x0094:
            r0 = r18
        L_0x0096:
            int r19 = androidx.compose.ui.text.AndroidParagraph_androidKt.m6901toLayoutBreakStrategyu6PBz3U(r0)
            androidx.compose.ui.text.style.LineBreak r0 = r7.m7062getLineBreakLgCVezo()
            if (r0 == 0) goto L_0x00ad
            int r0 = r0.m7350unboximpl()
            int r0 = androidx.compose.ui.text.style.LineBreak.m7346getStrictnessusljTpc(r0)
            androidx.compose.ui.text.style.LineBreak$Strictness r0 = androidx.compose.ui.text.style.LineBreak.Strictness.m7364boximpl(r0)
            goto L_0x00af
        L_0x00ad:
            r0 = r18
        L_0x00af:
            int r20 = androidx.compose.ui.text.AndroidParagraph_androidKt.m6903toLayoutLineBreakStyle4a2g8L8(r0)
            androidx.compose.ui.text.style.LineBreak r0 = r7.m7062getLineBreakLgCVezo()
            if (r0 == 0) goto L_0x00c6
            int r0 = r0.m7350unboximpl()
            int r0 = androidx.compose.ui.text.style.LineBreak.m7347getWordBreakjp8hJ3c(r0)
            androidx.compose.ui.text.style.LineBreak$WordBreak r0 = androidx.compose.ui.text.style.LineBreak.WordBreak.m7375boximpl(r0)
            goto L_0x00c8
        L_0x00c6:
            r0 = r18
        L_0x00c8:
            int r21 = androidx.compose.ui.text.AndroidParagraph_androidKt.m6904toLayoutLineBreakWordStylegvcdTPQ(r0)
            if (r12 == 0) goto L_0x00d2
            android.text.TextUtils$TruncateAt r0 = android.text.TextUtils.TruncateAt.END
            r3 = r0
            goto L_0x00d4
        L_0x00d2:
            r3 = r18
        L_0x00d4:
            r0 = r33
            r1 = r16
            r4 = r35
            r5 = r17
            r6 = r19
            r22 = r7
            r7 = r20
            r14 = r8
            r8 = r21
            androidx.compose.ui.text.android.TextLayout r0 = r0.constructTextLayout(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 == 0) goto L_0x0133
            int r1 = r0.getHeight()
            int r4 = androidx.compose.ui.unit.Constraints.m7497getMaxHeightimpl(r37)
            if (r1 <= r4) goto L_0x0133
            if (r15 <= r14) goto L_0x0133
            int r1 = androidx.compose.ui.unit.Constraints.m7497getMaxHeightimpl(r37)
            int r1 = androidx.compose.ui.text.AndroidParagraph_androidKt.numberOfLinesThatFitMaxHeight(r0, r1)
            if (r1 < 0) goto L_0x012e
            if (r1 == r15) goto L_0x012e
            int r8 = kotlin.ranges.RangesKt.coerceAtLeast((int) r1, (int) r14)
            r4 = r33
            r5 = r16
            r6 = r2
            r7 = r3
            r14 = r9
            r9 = r17
            r10 = r19
            r11 = r20
            r12 = r21
            androidx.compose.ui.text.android.TextLayout r4 = r4.constructTextLayout(r5, r6, r7, r8, r9, r10, r11, r12)
            goto L_0x0130
        L_0x012e:
            r14 = r9
            r4 = r0
        L_0x0130:
            r13.layout = r4
            goto L_0x0136
        L_0x0133:
            r14 = r9
            r13.layout = r0
        L_0x0136:
            androidx.compose.ui.text.platform.AndroidTextPaint r1 = r33.getTextPaint$ui_text_release()
            androidx.compose.ui.graphics.Brush r4 = r22.getBrush()
            float r5 = r33.getWidth()
            float r6 = r33.getHeight()
            long r5 = androidx.compose.ui.geometry.SizeKt.Size(r5, r6)
            float r7 = r22.getAlpha()
            r1.m7287setBrush12SF9DM(r4, r5, r7)
            androidx.compose.ui.text.android.TextLayout r1 = r13.layout
            androidx.compose.ui.text.platform.style.ShaderBrushSpan[] r1 = r13.getShaderBrushSpans(r1)
            r4 = 0
            int r5 = r1.length
            r9 = r14
        L_0x015a:
            if (r9 >= r5) goto L_0x0174
            r6 = r1[r9]
            r7 = r6
            r8 = 0
            float r10 = r33.getWidth()
            float r11 = r33.getHeight()
            long r10 = androidx.compose.ui.geometry.SizeKt.Size(r10, r11)
            r7.m7308setSizeuvyYCjk(r10)
            int r9 = r9 + 1
            goto L_0x015a
        L_0x0174:
            java.lang.CharSequence r0 = r13.charSequence
            r1 = 0
            boolean r2 = r0 instanceof android.text.Spanned
            if (r2 != 0) goto L_0x0183
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x031f
        L_0x0183:
            r2 = r0
            android.text.Spanned r2 = (android.text.Spanned) r2
            int r3 = r0.length()
            java.lang.Class<androidx.compose.ui.text.android.style.PlaceholderSpan> r4 = androidx.compose.ui.text.android.style.PlaceholderSpan.class
            java.lang.Object[] r2 = r2.getSpans(r14, r3, r4)
            java.lang.String r3 = "getSpans(0, length, PlaceholderSpan::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = r2.length
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            r5 = r2
            r6 = 0
            int r7 = r5.length
            r9 = r14
        L_0x01a3:
            if (r9 >= r7) goto L_0x030e
            r8 = r5[r9]
            r10 = r8
            androidx.compose.ui.text.android.style.PlaceholderSpan r10 = (androidx.compose.ui.text.android.style.PlaceholderSpan) r10
            r11 = 0
            r12 = r0
            android.text.Spanned r12 = (android.text.Spanned) r12
            int r12 = r12.getSpanStart(r10)
            r14 = r0
            android.text.Spanned r14 = (android.text.Spanned) r14
            int r14 = r14.getSpanEnd(r10)
            r17 = r0
            androidx.compose.ui.text.android.TextLayout r0 = r13.layout
            int r0 = r0.getLineForOffset(r12)
            r19 = r1
            int r1 = r13.maxLines
            if (r0 < r1) goto L_0x01c9
            r1 = 1
            goto L_0x01ca
        L_0x01c9:
            r1 = 0
        L_0x01ca:
            r20 = r2
            androidx.compose.ui.text.android.TextLayout r2 = r13.layout
            int r2 = r2.getLineEllipsisCount(r0)
            if (r2 <= 0) goto L_0x01de
            androidx.compose.ui.text.android.TextLayout r2 = r13.layout
            int r2 = r2.getLineEllipsisOffset(r0)
            if (r14 <= r2) goto L_0x01de
            r2 = 1
            goto L_0x01df
        L_0x01de:
            r2 = 0
        L_0x01df:
            r21 = r3
            androidx.compose.ui.text.android.TextLayout r3 = r13.layout
            int r3 = r3.getLineEnd(r0)
            if (r14 <= r3) goto L_0x01ec
            r3 = 1
            goto L_0x01ed
        L_0x01ec:
            r3 = 0
        L_0x01ed:
            if (r2 != 0) goto L_0x02ea
            if (r3 != 0) goto L_0x02ea
            if (r1 == 0) goto L_0x0201
            r24 = r1
            r26 = r2
            r25 = r3
            r29 = r5
            r31 = r6
            r32 = r7
            goto L_0x02f6
        L_0x0201:
            androidx.compose.ui.text.style.ResolvedTextDirection r22 = r13.getBidiRunDirection(r12)
            int[] r24 = androidx.compose.ui.text.AndroidParagraph.WhenMappings.$EnumSwitchMapping$0
            int r25 = r22.ordinal()
            r24 = r24[r25]
            switch(r24) {
                case 1: goto L_0x0228;
                case 2: goto L_0x0218;
                default: goto L_0x0210;
            }
        L_0x0210:
            r24 = r1
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x0218:
            r24 = r1
            r1 = 1
            float r23 = r13.getHorizontalPosition(r12, r1)
            int r1 = r10.getWidthPx()
            float r1 = (float) r1
            float r23 = r23 - r1
            r1 = 1
            goto L_0x022f
        L_0x0228:
            r24 = r1
            r1 = 1
            float r23 = r13.getHorizontalPosition(r12, r1)
        L_0x022f:
            r25 = r23
            int r1 = r10.getWidthPx()
            float r1 = (float) r1
            r26 = r2
            r2 = r25
            float r1 = r1 + r2
            r25 = r3
            androidx.compose.ui.text.android.TextLayout r3 = r13.layout
            r27 = 0
            int r28 = r10.getVerticalAlign()
            r29 = r5
            switch(r28) {
                case 0: goto L_0x02cd;
                case 1: goto L_0x02c4;
                case 2: goto L_0x02b4;
                case 3: goto L_0x029c;
                case 4: goto L_0x028b;
                case 5: goto L_0x0273;
                case 6: goto L_0x0255;
                default: goto L_0x024a;
            }
        L_0x024a:
            r31 = r6
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "unexpected verticalAlignment"
            r5.<init>(r6)
            throw r5
        L_0x0255:
            android.graphics.Paint$FontMetricsInt r5 = r10.getFontMetrics()
            r30 = 0
            r31 = r6
            int r6 = r5.ascent
            r32 = r7
            int r7 = r5.descent
            int r6 = r6 + r7
            int r7 = r10.getHeightPx()
            int r6 = r6 - r7
            r7 = 2
            int r6 = r6 / r7
            float r6 = (float) r6
            float r7 = r3.getLineBaseline(r0)
            float r6 = r6 + r7
            goto L_0x02dc
        L_0x0273:
            r31 = r6
            r32 = r7
            android.graphics.Paint$FontMetricsInt r5 = r10.getFontMetrics()
            int r5 = r5.descent
            float r5 = (float) r5
            float r6 = r3.getLineBaseline(r0)
            float r5 = r5 + r6
            int r6 = r10.getHeightPx()
            float r6 = (float) r6
            float r6 = r5 - r6
            goto L_0x02dc
        L_0x028b:
            r31 = r6
            r32 = r7
            android.graphics.Paint$FontMetricsInt r5 = r10.getFontMetrics()
            int r5 = r5.ascent
            float r5 = (float) r5
            float r6 = r3.getLineBaseline(r0)
            float r6 = r6 + r5
            goto L_0x02dc
        L_0x029c:
            r31 = r6
            r32 = r7
            float r5 = r3.getLineTop(r0)
            float r6 = r3.getLineBottom(r0)
            float r5 = r5 + r6
            int r6 = r10.getHeightPx()
            float r6 = (float) r6
            float r5 = r5 - r6
            r6 = 2
            float r6 = (float) r6
            float r6 = r5 / r6
            goto L_0x02dc
        L_0x02b4:
            r31 = r6
            r32 = r7
            float r5 = r3.getLineBottom(r0)
            int r6 = r10.getHeightPx()
            float r6 = (float) r6
            float r6 = r5 - r6
            goto L_0x02dc
        L_0x02c4:
            r31 = r6
            r32 = r7
            float r6 = r3.getLineTop(r0)
            goto L_0x02dc
        L_0x02cd:
            r31 = r6
            r32 = r7
            float r5 = r3.getLineBaseline(r0)
            int r6 = r10.getHeightPx()
            float r6 = (float) r6
            float r6 = r5 - r6
        L_0x02dc:
            r3 = r6
            int r5 = r10.getHeightPx()
            float r5 = (float) r5
            float r5 = r5 + r3
            androidx.compose.ui.geometry.Rect r6 = new androidx.compose.ui.geometry.Rect
            r6.<init>(r2, r3, r1, r5)
            goto L_0x02f8
        L_0x02ea:
            r24 = r1
            r26 = r2
            r25 = r3
            r29 = r5
            r31 = r6
            r32 = r7
        L_0x02f6:
            r6 = r18
        L_0x02f8:
            r4.add(r6)
            int r9 = r9 + 1
            r0 = r17
            r1 = r19
            r2 = r20
            r3 = r21
            r5 = r29
            r6 = r31
            r7 = r32
            r14 = 0
            goto L_0x01a3
        L_0x030e:
            r17 = r0
            r19 = r1
            r20 = r2
            r21 = r3
            r29 = r5
            r31 = r6
            r2 = r4
            java.util.List r2 = (java.util.List) r2
        L_0x031f:
            r13.placeholderRects = r2
            kotlin.LazyThreadSafetyMode r0 = kotlin.LazyThreadSafetyMode.NONE
            androidx.compose.ui.text.AndroidParagraph$wordBoundary$2 r1 = new androidx.compose.ui.text.AndroidParagraph$wordBoundary$2
            r1.<init>(r13)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            kotlin.Lazy r0 = kotlin.LazyKt.lazy((kotlin.LazyThreadSafetyMode) r0, r1)
            r13.wordBoundary$delegate = r0
            return
        L_0x0331:
            r0 = 0
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "maxLines should be greater than 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0340:
            r0 = 0
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AndroidParagraph.<init>(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics, int, boolean, long):void");
    }

    public final AndroidParagraphIntrinsics getParagraphIntrinsics() {
        return this.paragraphIntrinsics;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final boolean getEllipsis() {
        return this.ellipsis;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public final long m6889getConstraintsmsEJaDk() {
        return this.constraints;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private AndroidParagraph(String text, TextStyle style, List<AnnotatedString.Range<SpanStyle>> spanStyles, List<AnnotatedString.Range<Placeholder>> placeholders, int maxLines2, boolean ellipsis2, long constraints2, FontFamily.Resolver fontFamilyResolver, Density density) {
        this(new AndroidParagraphIntrinsics(text, style, spanStyles, placeholders, fontFamilyResolver, density), maxLines2, ellipsis2, constraints2, (DefaultConstructorMarker) null);
        String str = text;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(density, "density");
    }

    public final CharSequence getCharSequence$ui_text_release() {
        return this.charSequence;
    }

    public float getWidth() {
        return (float) Constraints.m7498getMaxWidthimpl(this.constraints);
    }

    public float getHeight() {
        return (float) this.layout.getHeight();
    }

    public float getMaxIntrinsicWidth() {
        return this.paragraphIntrinsics.getMaxIntrinsicWidth();
    }

    public float getMinIntrinsicWidth() {
        return this.paragraphIntrinsics.getMinIntrinsicWidth();
    }

    public float getFirstBaseline() {
        return getLineBaseline$ui_text_release(0);
    }

    public float getLastBaseline() {
        return getLineBaseline$ui_text_release(getLineCount() - 1);
    }

    public boolean getDidExceedMaxLines() {
        return this.layout.getDidExceedMaxLines();
    }

    public final Locale getTextLocale$ui_text_release() {
        Locale textLocale = this.paragraphIntrinsics.getTextPaint$ui_text_release().getTextLocale();
        Intrinsics.checkNotNullExpressionValue(textLocale, "paragraphIntrinsics.textPaint.textLocale");
        return textLocale;
    }

    public int getLineCount() {
        return this.layout.getLineCount();
    }

    public List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final AndroidTextPaint getTextPaint$ui_text_release() {
        return this.paragraphIntrinsics.getTextPaint$ui_text_release();
    }

    public int getLineForVerticalPosition(float vertical) {
        return this.layout.getLineForVertical((int) vertical);
    }

    /* renamed from: getOffsetForPosition-k-4lQ0M  reason: not valid java name */
    public int m6890getOffsetForPositionk4lQ0M(long position) {
        return this.layout.getOffsetForHorizontal(this.layout.getLineForVertical((int) Offset.m4714getYimpl(position)), Offset.m4713getXimpl(position));
    }

    public Rect getBoundingBox(int offset) {
        RectF $this$getBoundingBox_u24lambda_u247 = this.layout.getBoundingBox(offset);
        return new Rect($this$getBoundingBox_u24lambda_u247.left, $this$getBoundingBox_u24lambda_u247.top, $this$getBoundingBox_u24lambda_u247.right, $this$getBoundingBox_u24lambda_u247.bottom);
    }

    /* renamed from: fillBoundingBoxes-8ffj60Q  reason: not valid java name */
    public final void m6888fillBoundingBoxes8ffj60Q(long range, float[] array, int arrayStart) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.layout.fillBoundingBoxes(TextRange.m7033getMinimpl(range), TextRange.m7032getMaximpl(range), array, arrayStart);
    }

    public Path getPathForRange(int start, int end) {
        boolean z = false;
        if (start >= 0 && start <= end) {
            z = true;
        }
        if (!z || end > this.charSequence.length()) {
            throw new AssertionError("Start(" + start + ") or End(" + end + ") is out of Range(0.." + this.charSequence.length() + "), or start > end!");
        }
        android.graphics.Path path = new android.graphics.Path();
        this.layout.getSelectionPath(start, end, path);
        return AndroidPath_androidKt.asComposePath(path);
    }

    public Rect getCursorRect(int offset) {
        if (offset >= 0 && offset <= this.charSequence.length()) {
            float horizontal = TextLayout.getPrimaryHorizontal$default(this.layout, offset, false, 2, (Object) null);
            int line = this.layout.getLineForOffset(offset);
            return new Rect(horizontal, this.layout.getLineTop(line), horizontal, this.layout.getLineBottom(line));
        }
        throw new AssertionError("offset(" + offset + ") is out of bounds (0," + this.charSequence.length());
    }

    private final WordBoundary getWordBoundary() {
        return (WordBoundary) this.wordBoundary$delegate.getValue();
    }

    /* renamed from: getWordBoundary--jx7JFs  reason: not valid java name */
    public long m6891getWordBoundaryjx7JFs(int offset) {
        return TextRangeKt.TextRange(getWordBoundary().getWordStart(offset), getWordBoundary().getWordEnd(offset));
    }

    public float getLineLeft(int lineIndex) {
        return this.layout.getLineLeft(lineIndex);
    }

    public float getLineRight(int lineIndex) {
        return this.layout.getLineRight(lineIndex);
    }

    public float getLineTop(int lineIndex) {
        return this.layout.getLineTop(lineIndex);
    }

    public final float getLineAscent$ui_text_release(int lineIndex) {
        return this.layout.getLineAscent(lineIndex);
    }

    public final float getLineBaseline$ui_text_release(int lineIndex) {
        return this.layout.getLineBaseline(lineIndex);
    }

    public final float getLineDescent$ui_text_release(int lineIndex) {
        return this.layout.getLineDescent(lineIndex);
    }

    public float getLineBottom(int lineIndex) {
        return this.layout.getLineBottom(lineIndex);
    }

    public float getLineHeight(int lineIndex) {
        return this.layout.getLineHeight(lineIndex);
    }

    public float getLineWidth(int lineIndex) {
        return this.layout.getLineWidth(lineIndex);
    }

    public int getLineStart(int lineIndex) {
        return this.layout.getLineStart(lineIndex);
    }

    public int getLineEnd(int lineIndex, boolean visibleEnd) {
        if (visibleEnd) {
            return this.layout.getLineVisibleEnd(lineIndex);
        }
        return this.layout.getLineEnd(lineIndex);
    }

    public boolean isLineEllipsized(int lineIndex) {
        return this.layout.isLineEllipsized(lineIndex);
    }

    public int getLineForOffset(int offset) {
        return this.layout.getLineForOffset(offset);
    }

    public float getHorizontalPosition(int offset, boolean usePrimaryDirection) {
        if (usePrimaryDirection) {
            return TextLayout.getPrimaryHorizontal$default(this.layout, offset, false, 2, (Object) null);
        }
        return TextLayout.getSecondaryHorizontal$default(this.layout, offset, false, 2, (Object) null);
    }

    public ResolvedTextDirection getParagraphDirection(int offset) {
        return this.layout.getParagraphDirection(this.layout.getLineForOffset(offset)) == 1 ? ResolvedTextDirection.Ltr : ResolvedTextDirection.Rtl;
    }

    public ResolvedTextDirection getBidiRunDirection(int offset) {
        if (this.layout.isRtlCharAt(offset)) {
            return ResolvedTextDirection.Rtl;
        }
        return ResolvedTextDirection.Ltr;
    }

    private final ShaderBrushSpan[] getShaderBrushSpans(TextLayout $this$getShaderBrushSpans) {
        if (!($this$getShaderBrushSpans.getText() instanceof Spanned)) {
            return new ShaderBrushSpan[0];
        }
        CharSequence text = $this$getShaderBrushSpans.getText();
        Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
        ShaderBrushSpan[] brushSpans = (ShaderBrushSpan[]) ((Spanned) text).getSpans(0, $this$getShaderBrushSpans.getText().length(), ShaderBrushSpan.class);
        Intrinsics.checkNotNullExpressionValue(brushSpans, "brushSpans");
        if (brushSpans.length == 0) {
            return new ShaderBrushSpan[0];
        }
        return brushSpans;
    }

    /* renamed from: paint-RPmYEkk  reason: not valid java name */
    public void m6893paintRPmYEkk(Canvas canvas, long color, Shadow shadow, TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        AndroidTextPaint $this$paint_RPmYEkk_u24lambda_u248 = getTextPaint$ui_text_release();
        $this$paint_RPmYEkk_u24lambda_u248.m7288setColor8_81llA(color);
        $this$paint_RPmYEkk_u24lambda_u248.setShadow(shadow);
        $this$paint_RPmYEkk_u24lambda_u248.setTextDecoration(textDecoration);
        paint(canvas);
    }

    /* renamed from: paint-LG529CI  reason: not valid java name */
    public void m6892paintLG529CI(Canvas canvas, long color, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int currBlendMode = getTextPaint$ui_text_release().m7285getBlendMode0nO6VwU();
        AndroidTextPaint $this$paint_LG529CI_u24lambda_u249 = getTextPaint$ui_text_release();
        $this$paint_LG529CI_u24lambda_u249.m7288setColor8_81llA(color);
        $this$paint_LG529CI_u24lambda_u249.setShadow(shadow);
        $this$paint_LG529CI_u24lambda_u249.setTextDecoration(textDecoration);
        $this$paint_LG529CI_u24lambda_u249.setDrawStyle(drawStyle);
        $this$paint_LG529CI_u24lambda_u249.m7286setBlendModes9anfk8(blendMode);
        paint(canvas);
        getTextPaint$ui_text_release().m7286setBlendModes9anfk8(currBlendMode);
    }

    /* renamed from: paint-hn5TExg  reason: not valid java name */
    public void m6894painthn5TExg(Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(brush, "brush");
        int currBlendMode = getTextPaint$ui_text_release().m7285getBlendMode0nO6VwU();
        AndroidTextPaint $this$paint_hn5TExg_u24lambda_u2410 = getTextPaint$ui_text_release();
        $this$paint_hn5TExg_u24lambda_u2410.m7287setBrush12SF9DM(brush, SizeKt.Size(getWidth(), getHeight()), alpha);
        $this$paint_hn5TExg_u24lambda_u2410.setShadow(shadow);
        $this$paint_hn5TExg_u24lambda_u2410.setTextDecoration(textDecoration);
        $this$paint_hn5TExg_u24lambda_u2410.setDrawStyle(drawStyle);
        $this$paint_hn5TExg_u24lambda_u2410.m7286setBlendModes9anfk8(blendMode);
        paint(canvas);
        getTextPaint$ui_text_release().m7286setBlendModes9anfk8(currBlendMode);
    }

    private final void paint(Canvas canvas) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.save();
            nativeCanvas.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.layout.paint(nativeCanvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.restore();
        }
    }

    private final TextLayout constructTextLayout(int alignment, int justificationMode, TextUtils.TruncateAt ellipsize, int maxLines2, int hyphens, int breakStrategy, int lineBreakStyle, int lineBreakWordStyle) {
        TextUtils.TruncateAt truncateAt = ellipsize;
        int i = maxLines2;
        int i2 = hyphens;
        int i3 = breakStrategy;
        int i4 = lineBreakStyle;
        int i5 = lineBreakWordStyle;
        CharSequence charSequence2 = this.charSequence;
        float width = getWidth();
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        int textDirectionHeuristic$ui_text_release = this.paragraphIntrinsics.getTextDirectionHeuristic$ui_text_release();
        LayoutIntrinsics layoutIntrinsics$ui_text_release = this.paragraphIntrinsics.getLayoutIntrinsics$ui_text_release();
        return new TextLayout(charSequence2, width, textPaint$ui_text_release, alignment, truncateAt, textDirectionHeuristic$ui_text_release, 1.0f, 0.0f, AndroidParagraphHelper_androidKt.isIncludeFontPaddingEnabled(this.paragraphIntrinsics.getStyle()), true, i, i3, i4, i5, i2, justificationMode, (int[]) null, (int[]) null, layoutIntrinsics$ui_text_release, 196736, (DefaultConstructorMarker) null);
    }
}

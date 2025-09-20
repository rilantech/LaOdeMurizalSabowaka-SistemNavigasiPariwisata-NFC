package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0017\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001a\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Image", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "Image-5h-nEew", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Image.kt */
public final class ImageKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Consider usage of the Image composable that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "Image(bitmap, contentDescription, modifier, alignment, contentScale, alpha, colorFilter, DefaultFilterQuality)", imports = {"androidx.compose.foundation", "androidx.compose.ui.graphics.DefaultAlpha", "androidx.compose.ui.Alignment", "androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality", "androidx.compose.ui.layout.ContentScale.Fit"}))
    public static final /* synthetic */ void Image(ImageBitmap bitmap, String contentDescription, Modifier modifier, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, Composer $composer, int $changed, int i) {
        Alignment alignment2;
        ContentScale contentScale2;
        float alpha2;
        ColorFilter colorFilter2;
        Composer composer = $composer;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        composer.startReplaceableGroup(-2123228673);
        ComposerKt.sourceInformation(composer, "C(Image)P(2,4,6!1,5)96@4585L177:Image.kt#71ulvw");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.Companion : modifier;
        if ((i & 8) != 0) {
            alignment2 = Alignment.Companion.getCenter();
        } else {
            alignment2 = alignment;
        }
        if ((i & 16) != 0) {
            contentScale2 = ContentScale.Companion.getFit();
        } else {
            contentScale2 = contentScale;
        }
        if ((i & 32) != 0) {
            alpha2 = 1.0f;
        } else {
            alpha2 = alpha;
        }
        if ((i & 64) != 0) {
            colorFilter2 = null;
        } else {
            colorFilter2 = colorFilter;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2123228673, i2, -1, "androidx.compose.foundation.Image (Image.kt:87)");
        }
        m224Image5hnEew(bitmap, contentDescription, modifier2, alignment2, contentScale2, alpha2, colorFilter2, FilterQuality.Companion.m3350getLowfv9h1I(), $composer, (i2 & 112) | 8 | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* renamed from: Image-5h-nEew  reason: not valid java name */
    public static final void m224Image5hnEew(ImageBitmap bitmap, String contentDescription, Modifier modifier, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, int filterQuality, Composer $composer, int $changed, int i) {
        Alignment alignment2;
        ContentScale contentScale2;
        float alpha2;
        ColorFilter colorFilter2;
        int filterQuality2;
        ImageBitmap imageBitmap = bitmap;
        Composer composer = $composer;
        int i2 = $changed;
        int i3 = i;
        Intrinsics.checkNotNullParameter(imageBitmap, "bitmap");
        composer.startReplaceableGroup(-1396260732);
        ComposerKt.sourceInformation(composer, "C(Image)P(2,4,7!1,5!,6:c#ui.graphics.FilterQuality)153@7224L73,154@7302L248:Image.kt#71ulvw");
        Modifier modifier2 = (i3 & 4) != 0 ? Modifier.Companion : modifier;
        if ((i3 & 8) != 0) {
            alignment2 = Alignment.Companion.getCenter();
        } else {
            alignment2 = alignment;
        }
        if ((i3 & 16) != 0) {
            contentScale2 = ContentScale.Companion.getFit();
        } else {
            contentScale2 = contentScale;
        }
        if ((i3 & 32) != 0) {
            alpha2 = 1.0f;
        } else {
            alpha2 = alpha;
        }
        if ((i3 & 64) != 0) {
            colorFilter2 = null;
        } else {
            colorFilter2 = colorFilter;
        }
        if ((i3 & 128) != 0) {
            filterQuality2 = DrawScope.Companion.m3868getDefaultFilterQualityfv9h1I();
        } else {
            filterQuality2 = filterQuality;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1396260732, i2, -1, "androidx.compose.foundation.Image (Image.kt:143)");
        }
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) imageBitmap);
        Composer $this$cache$iv$iv = $composer;
        Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            value$iv$iv = BitmapPainterKt.m3955BitmapPainterQZhYCtY$default(bitmap, 0, 0, filterQuality2, 6, (Object) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Object obj2 = value$iv$iv;
        }
        $composer.endReplaceableGroup();
        Image((BitmapPainter) value$iv$iv, contentDescription, modifier2, alignment2, contentScale2, alpha2, colorFilter2, $composer, (i2 & 112) | 8 | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    public static final void Image(ImageVector imageVector, String contentDescription, Modifier modifier, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, Composer $composer, int $changed, int i) {
        Alignment alignment2;
        ContentScale contentScale2;
        float alpha2;
        ColorFilter colorFilter2;
        ImageVector imageVector2 = imageVector;
        Composer composer = $composer;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(imageVector2, "imageVector");
        composer.startReplaceableGroup(1595907091);
        ComposerKt.sourceInformation(composer, "C(Image)P(5,3,6!1,4)198@9330L34,197@9309L237:Image.kt#71ulvw");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.Companion : modifier;
        if ((i & 8) != 0) {
            alignment2 = Alignment.Companion.getCenter();
        } else {
            alignment2 = alignment;
        }
        if ((i & 16) != 0) {
            contentScale2 = ContentScale.Companion.getFit();
        } else {
            contentScale2 = contentScale;
        }
        if ((i & 32) != 0) {
            alpha2 = 1.0f;
        } else {
            alpha2 = alpha;
        }
        if ((i & 64) != 0) {
            colorFilter2 = null;
        } else {
            colorFilter2 = colorFilter;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1595907091, i2, -1, "androidx.compose.foundation.Image (Image.kt:189)");
        }
        Image((Painter) VectorPainterKt.rememberVectorPainter(imageVector2, composer, i2 & 14), contentDescription, modifier2, alignment2, contentScale2, alpha2, colorFilter2, $composer, VectorPainter.$stable | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Image(androidx.compose.ui.graphics.painter.Painter r24, java.lang.String r25, androidx.compose.ui.Modifier r26, androidx.compose.ui.Alignment r27, androidx.compose.ui.layout.ContentScale r28, float r29, androidx.compose.ui.graphics.ColorFilter r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r10 = r25
            java.lang.String r0 = "painter"
            r11 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1142754848(0x441d0e20, float:628.2207)
            r1 = r31
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Image)P(6,3,5!1,4)255@11931L341:Image.kt#71ulvw"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r13 = r32
            r1 = r33 & 4
            if (r1 == 0) goto L_0x0024
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r14 = r1
            goto L_0x0026
        L_0x0024:
            r14 = r26
        L_0x0026:
            r1 = r33 & 8
            if (r1 == 0) goto L_0x0032
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            r15 = r1
            goto L_0x0034
        L_0x0032:
            r15 = r27
        L_0x0034:
            r1 = r33 & 16
            if (r1 == 0) goto L_0x0041
            androidx.compose.ui.layout.ContentScale$Companion r1 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r1 = r1.getFit()
            r16 = r1
            goto L_0x0043
        L_0x0041:
            r16 = r28
        L_0x0043:
            r1 = r33 & 32
            if (r1 == 0) goto L_0x004c
            r1 = 1065353216(0x3f800000, float:1.0)
            r17 = r1
            goto L_0x004e
        L_0x004c:
            r17 = r29
        L_0x004e:
            r1 = r33 & 64
            if (r1 == 0) goto L_0x0056
            r1 = 0
            r18 = r1
            goto L_0x0058
        L_0x0056:
            r18 = r30
        L_0x0058:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0064
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.Image (Image.kt:235)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r1, r2)
        L_0x0064:
            r0 = -816794123(0xffffffffcf50b5f5, float:-3.50158566E9)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "245@11667L103"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            if (r10 == 0) goto L_0x00b9
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            int r2 = r13 >> 3
            r2 = r2 & 14
            r3 = 0
            r4 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            boolean r4 = r12.changed((java.lang.Object) r10)
            r5 = r12
            r6 = 0
            java.lang.Object r7 = r5.rememberedValue()
            r8 = 0
            if (r4 != 0) goto L_0x009d
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r7 != r9) goto L_0x009b
            goto L_0x009d
        L_0x009b:
            r0 = r7
            goto L_0x00aa
        L_0x009d:
            r9 = 0
            androidx.compose.foundation.ImageKt$Image$semantics$1$1 r0 = new androidx.compose.foundation.ImageKt$Image$semantics$1$1
            r0.<init>(r10)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r5.updateRememberedValue(r0)
        L_0x00aa:
            r12.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2 = 1
            r3 = 0
            r4 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r1, r4, r0, r2, r3)
            goto L_0x00bd
        L_0x00b9:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x00bd:
            r12.endReplaceableGroup()
            androidx.compose.ui.Modifier r1 = r14.then(r0)
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.draw.ClipKt.clipToBounds(r1)
            r8 = 2
            r9 = 0
            r3 = 0
            r2 = r24
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.draw.PainterModifierKt.paint$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.foundation.ImageKt$Image$2 r2 = androidx.compose.foundation.ImageKt$Image$2.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r2 = (androidx.compose.ui.layout.MeasurePolicy) r2
            r3 = 0
            r4 = r3
            r5 = 0
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r6)
            int r3 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r12, r3)
            androidx.compose.runtime.CompositionLocalMap r6 = r12.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r1)
            int r9 = r4 << 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | 6
            r19 = 0
            r26 = r0
            androidx.compose.runtime.Applier r0 = r12.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x0118
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0118:
            r12.startReusableNode()
            boolean r0 = r12.getInserting()
            if (r0 == 0) goto L_0x0125
            r12.createNode(r7)
            goto L_0x0128
        L_0x0125:
            r12.useNode()
        L_0x0128:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m2865constructorimpl(r12)
            r20 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r21 = androidx.compose.ui.node.ComposeUiNode.Companion
            r27 = r1
            kotlin.jvm.functions.Function2 r1 = r21.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r2, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r6, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            r21 = 0
            r28 = r0
            r22 = 0
            boolean r23 = r28.getInserting()
            if (r23 != 0) goto L_0x016a
            r29 = r2
            java.lang.Object r2 = r28.rememberedValue()
            r30 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r2 != 0) goto L_0x0167
            goto L_0x016e
        L_0x0167:
            r4 = r28
            goto L_0x017e
        L_0x016a:
            r29 = r2
            r30 = r4
        L_0x016e:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r4 = r28
            r4.updateRememberedValue(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r0.apply(r2, r1)
        L_0x017e:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r0)
            int r1 = r9 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r8.invoke(r0, r12, r1)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r0)
            int r0 = r9 >> 9
            r0 = r0 & 14
            r1 = r12
            r2 = 0
            r4 = -820198676(0xffffffffcf1cc2ec, float:-2.6300201E9)
            r28 = r0
            java.lang.String r0 = "C:Image.kt#71ulvw"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r4, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r12.endReplaceableGroup()
            r12.endNode()
            r12.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01c4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01c4:
            androidx.compose.runtime.ScopeUpdateScope r9 = r12.endRestartGroup()
            if (r9 != 0) goto L_0x01cd
            r20 = r26
            goto L_0x01ee
        L_0x01cd:
            androidx.compose.foundation.ImageKt$Image$3 r19 = new androidx.compose.foundation.ImageKt$Image$3
            r20 = r26
            r0 = r19
            r1 = r24
            r2 = r25
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r32
            r10 = r9
            r9 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ImageKt.Image(androidx.compose.ui.graphics.painter.Painter, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.ColorFilter, androidx.compose.runtime.Composer, int, int):void");
    }
}

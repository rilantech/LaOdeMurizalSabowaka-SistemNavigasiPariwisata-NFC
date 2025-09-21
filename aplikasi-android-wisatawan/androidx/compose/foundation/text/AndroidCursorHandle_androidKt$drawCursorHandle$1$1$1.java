package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidCursorHandle.android.kt */
final class AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1 extends Lambda implements Function1<CacheDrawScope, DrawResult> {
    final /* synthetic */ long $handleColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1(long j) {
        super(1);
        this.$handleColor = j;
    }

    public final DrawResult invoke(CacheDrawScope $this$drawWithCache) {
        Intrinsics.checkNotNullParameter($this$drawWithCache, "$this$drawWithCache");
        final float radius = Size.m3072getWidthimpl($this$drawWithCache.m2904getSizeNHjbRc()) / 2.0f;
        final ImageBitmap imageBitmap = AndroidSelectionHandles_androidKt.createHandleImage($this$drawWithCache, radius);
        final ColorFilter colorFilter = ColorFilter.Companion.m3294tintxETnrds$default(ColorFilter.Companion, this.$handleColor, 0, 2, (Object) null);
        return $this$drawWithCache.onDrawWithContent(new Function1<ContentDrawScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((ContentDrawScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(ContentDrawScope $this$onDrawWithContent) {
                ContentDrawScope contentDrawScope = $this$onDrawWithContent;
                Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
                $this$onDrawWithContent.drawContent();
                DrawScope $this$withTransform$iv = contentDrawScope;
                float f = radius;
                ImageBitmap imageBitmap = imageBitmap;
                ColorFilter colorFilter = colorFilter;
                DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
                long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3809getSizeNHjbRc();
                $this$withTransform_u24lambda_u246$iv.getCanvas().save();
                DrawTransform $this$invoke_u24lambda_u240 = $this$withTransform_u24lambda_u246$iv.getTransform();
                DrawTransform.translate$default($this$invoke_u24lambda_u240, f, 0.0f, 2, (Object) null);
                $this$invoke_u24lambda_u240.m3924rotateUv8p0NA(45.0f, Offset.Companion.m3019getZeroF1C5BW0());
                DrawScope.m3832drawImagegbVJVH8$default($this$withTransform$iv, imageBitmap, 0, 0.0f, (DrawStyle) null, colorFilter, 0, 46, (Object) null);
                $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u246$iv.m3810setSizeuvyYCjk(previousSize$iv);
            }
        });
    }
}

package androidx.compose.ui.text.platform.style;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.graphics.AndroidPathEffect_androidKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0019\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/platform/style/DrawStyleSpan;", "Landroid/text/style/CharacterStyle;", "Landroid/text/style/UpdateAppearance;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "(Landroidx/compose/ui/graphics/drawscope/DrawStyle;)V", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "toAndroidCap", "Landroid/graphics/Paint$Cap;", "Landroidx/compose/ui/graphics/StrokeCap;", "toAndroidCap-BeK7IIE", "(I)Landroid/graphics/Paint$Cap;", "toAndroidJoin", "Landroid/graphics/Paint$Join;", "Landroidx/compose/ui/graphics/StrokeJoin;", "toAndroidJoin-Ww9F2mQ", "(I)Landroid/graphics/Paint$Join;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DrawStyleSpan.android.kt */
public final class DrawStyleSpan extends CharacterStyle implements UpdateAppearance {
    private final DrawStyle drawStyle;

    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    public DrawStyleSpan(DrawStyle drawStyle2) {
        Intrinsics.checkNotNullParameter(drawStyle2, "drawStyle");
        this.drawStyle = drawStyle2;
    }

    public void updateDrawState(TextPaint textPaint) {
        if (textPaint != null) {
            TextPaint $this$updateDrawState_u24lambda_u240 = textPaint;
            DrawStyle drawStyle2 = this.drawStyle;
            if (Intrinsics.areEqual((Object) drawStyle2, (Object) Fill.INSTANCE)) {
                $this$updateDrawState_u24lambda_u240.setStyle(Paint.Style.FILL);
            } else if (drawStyle2 instanceof Stroke) {
                $this$updateDrawState_u24lambda_u240.setStyle(Paint.Style.STROKE);
                $this$updateDrawState_u24lambda_u240.setStrokeWidth(((Stroke) this.drawStyle).getWidth());
                $this$updateDrawState_u24lambda_u240.setStrokeMiter(((Stroke) this.drawStyle).getMiter());
                $this$updateDrawState_u24lambda_u240.setStrokeJoin(m5596toAndroidJoinWw9F2mQ(((Stroke) this.drawStyle).m3947getJoinLxFBmk8()));
                $this$updateDrawState_u24lambda_u240.setStrokeCap(m5595toAndroidCapBeK7IIE(((Stroke) this.drawStyle).m3946getCapKaPHkGw()));
                PathEffect pathEffect = ((Stroke) this.drawStyle).getPathEffect();
                $this$updateDrawState_u24lambda_u240.setPathEffect(pathEffect != null ? AndroidPathEffect_androidKt.asAndroidPathEffect(pathEffect) : null);
            }
        }
    }

    /* renamed from: toAndroidJoin-Ww9F2mQ  reason: not valid java name */
    private final Paint.Join m5596toAndroidJoinWw9F2mQ(int $this$toAndroidJoin_u2dWw9F2mQ) {
        if (StrokeJoin.m3647equalsimpl0($this$toAndroidJoin_u2dWw9F2mQ, StrokeJoin.Companion.m3652getMiterLxFBmk8())) {
            return Paint.Join.MITER;
        }
        if (StrokeJoin.m3647equalsimpl0($this$toAndroidJoin_u2dWw9F2mQ, StrokeJoin.Companion.m3653getRoundLxFBmk8())) {
            return Paint.Join.ROUND;
        }
        if (StrokeJoin.m3647equalsimpl0($this$toAndroidJoin_u2dWw9F2mQ, StrokeJoin.Companion.m3651getBevelLxFBmk8())) {
            return Paint.Join.BEVEL;
        }
        return Paint.Join.MITER;
    }

    /* renamed from: toAndroidCap-BeK7IIE  reason: not valid java name */
    private final Paint.Cap m5595toAndroidCapBeK7IIE(int $this$toAndroidCap_u2dBeK7IIE) {
        if (StrokeCap.m3637equalsimpl0($this$toAndroidCap_u2dBeK7IIE, StrokeCap.Companion.m3641getButtKaPHkGw())) {
            return Paint.Cap.BUTT;
        }
        if (StrokeCap.m3637equalsimpl0($this$toAndroidCap_u2dBeK7IIE, StrokeCap.Companion.m3642getRoundKaPHkGw())) {
            return Paint.Cap.ROUND;
        }
        if (StrokeCap.m3637equalsimpl0($this$toAndroidCap_u2dBeK7IIE, StrokeCap.Companion.m3643getSquareKaPHkGw())) {
            return Paint.Cap.SQUARE;
        }
        return Paint.Cap.BUTT;
    }
}

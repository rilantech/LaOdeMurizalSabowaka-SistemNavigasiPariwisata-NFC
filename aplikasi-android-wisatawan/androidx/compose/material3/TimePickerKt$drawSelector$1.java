package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.DpOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$drawSelector$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$drawSelector$1(TimePickerState timePickerState, TimePickerColors timePickerColors) {
        super(1);
        this.$state = timePickerState;
        this.$colors = timePickerColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((ContentDrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope $this$drawWithContent) {
        ContentDrawScope contentDrawScope = $this$drawWithContent;
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$drawWithContent");
        long selectorOffsetPx = OffsetKt.Offset(contentDrawScope.m5825toPx0680j_4(DpOffset.m5905getXD9Ej5fM(this.$state.m2192getSelectorPosRKDOV3M$material3_release())), contentDrawScope.m5825toPx0680j_4(DpOffset.m5907getYD9Ej5fM(this.$state.m2192getSelectorPosRKDOV3M$material3_release())));
        float f = (float) 2;
        float selectorRadius = contentDrawScope.m5825toPx0680j_4(TimePickerTokens.INSTANCE.m2764getClockDialSelectorHandleContainerSizeD9Ej5fM()) / f;
        long selectorColor = this.$colors.m2155getSelectorColor0d7_KjU$material3_release();
        float f2 = selectorRadius;
        long j = selectorOffsetPx;
        DrawScope.m3829drawCircleVaOC9Bg$default(contentDrawScope, Color.Companion.m3279getBlack0d7_KjU(), f2, j, 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.m3159getClear0nO6VwU(), 56, (Object) null);
        $this$drawWithContent.drawContent();
        DrawScope.m3829drawCircleVaOC9Bg$default(contentDrawScope, selectorColor, f2, j, 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.m3187getXor0nO6VwU(), 56, (Object) null);
        float strokeWidth = contentDrawScope.m5825toPx0680j_4(TimePickerTokens.INSTANCE.m2765getClockDialSelectorTrackContainerWidthD9Ej5fM());
        long j2 = selectorColor;
        DrawScope.m3834drawLineNGM6Ib0$default(contentDrawScope, j2, SizeKt.m3082getCenteruvyYCjk($this$drawWithContent.m3866getSizeNHjbRc()), Offset.m3007minusMKHz9U(selectorOffsetPx, OffsetKt.Offset(((float) Math.cos((double) this.$state.getCurrentAngle$material3_release().getValue().floatValue())) * selectorRadius, ((float) Math.sin((double) this.$state.getCurrentAngle$material3_release().getValue().floatValue())) * selectorRadius)), strokeWidth, 0, (PathEffect) null, 0.0f, (ColorFilter) null, BlendMode.Companion.m3186getSrcOver0nO6VwU(), 240, (Object) null);
        DrawScope drawScope = contentDrawScope;
        DrawScope.m3829drawCircleVaOC9Bg$default(drawScope, j2, contentDrawScope.m5825toPx0680j_4(TimePickerTokens.INSTANCE.m2763getClockDialSelectorCenterContainerSizeD9Ej5fM()) / f, SizeKt.m3082getCenteruvyYCjk($this$drawWithContent.m3866getSizeNHjbRc()), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
        DrawScope.m3829drawCircleVaOC9Bg$default(contentDrawScope, this.$colors.m2151clockDialContentColorvNxB06k$material3_release(true), f2, j, 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.m3169getDstOver0nO6VwU(), 56, (Object) null);
    }
}

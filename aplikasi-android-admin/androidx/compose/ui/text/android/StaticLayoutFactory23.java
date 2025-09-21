package androidx.compose.ui.text.android;

import android.text.StaticLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bH\u0017¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactory23;", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "()V", "create", "Landroid/text/StaticLayout;", "params", "Landroidx/compose/ui/text/android/StaticLayoutParams;", "isFallbackLineSpacingEnabled", "", "layout", "useFallbackLineSpacing", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StaticLayoutFactory.kt */
final class StaticLayoutFactory23 implements StaticLayoutFactoryImpl {
    public StaticLayout create(StaticLayoutParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(params.getText(), params.getStart(), params.getEnd(), params.getPaint(), params.getWidth());
        StaticLayout.Builder $this$create_u24lambda_u240 = obtain;
        $this$create_u24lambda_u240.setTextDirection(params.getTextDir());
        $this$create_u24lambda_u240.setAlignment(params.getAlignment());
        $this$create_u24lambda_u240.setMaxLines(params.getMaxLines());
        $this$create_u24lambda_u240.setEllipsize(params.getEllipsize());
        $this$create_u24lambda_u240.setEllipsizedWidth(params.getEllipsizedWidth());
        $this$create_u24lambda_u240.setLineSpacing(params.getLineSpacingExtra(), params.getLineSpacingMultiplier());
        $this$create_u24lambda_u240.setIncludePad(params.getIncludePadding());
        $this$create_u24lambda_u240.setBreakStrategy(params.getBreakStrategy());
        $this$create_u24lambda_u240.setHyphenationFrequency(params.getHyphenationFrequency());
        $this$create_u24lambda_u240.setIndents(params.getLeftIndents(), params.getRightIndents());
        Intrinsics.checkNotNullExpressionValue($this$create_u24lambda_u240, "this");
        StaticLayoutFactory26.setJustificationMode($this$create_u24lambda_u240, params.getJustificationMode());
        Intrinsics.checkNotNullExpressionValue($this$create_u24lambda_u240, "this");
        StaticLayoutFactory28.setUseLineSpacingFromFallbacks($this$create_u24lambda_u240, params.getUseFallbackLineSpacing());
        Intrinsics.checkNotNullExpressionValue($this$create_u24lambda_u240, "this");
        StaticLayoutFactory33.setLineBreakConfig($this$create_u24lambda_u240, params.getLineBreakStyle(), params.getLineBreakWordStyle());
        StaticLayout build = obtain.build();
        Intrinsics.checkNotNullExpressionValue(build, "obtain(params.text, para…  }\n            }.build()");
        return build;
    }

    public boolean isFallbackLineSpacingEnabled(StaticLayout layout, boolean useFallbackLineSpacing) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        return StaticLayoutFactory33.isFallbackLineSpacingEnabled(layout);
    }
}

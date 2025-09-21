package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl;", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "()V", "canUpdateZoom", "", "getCanUpdateZoom", "()Z", "create", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "style", "Landroidx/compose/foundation/MagnifierStyle;", "view", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "initialZoom", "", "PlatformMagnifierImpl", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PlatformMagnifier.kt */
public final class PlatformMagnifierFactoryApi29Impl implements PlatformMagnifierFactory {
    public static final PlatformMagnifierFactoryApi29Impl INSTANCE = new PlatformMagnifierFactoryApi29Impl();
    private static final boolean canUpdateZoom = true;

    private PlatformMagnifierFactoryApi29Impl() {
    }

    public boolean getCanUpdateZoom() {
        return canUpdateZoom;
    }

    public PlatformMagnifierImpl create(MagnifierStyle style, View view, Density density, float initialZoom) {
        MagnifierStyle magnifierStyle = style;
        View view2 = view;
        Intrinsics.checkNotNullParameter(magnifierStyle, "style");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(density, "density");
        Density $this$create_u24lambda_u241 = density;
        if (Intrinsics.areEqual((Object) magnifierStyle, (Object) MagnifierStyle.Companion.getTextDefault())) {
            return new PlatformMagnifierImpl(new Magnifier(view2));
        }
        long size = $this$create_u24lambda_u241.m5826toSizeXkaWNTQ(style.m231getSizeMYxV2XQ$foundation_release());
        float cornerRadius = $this$create_u24lambda_u241.m5825toPx0680j_4(style.m229getCornerRadiusD9Ej5fM$foundation_release());
        float elevation = $this$create_u24lambda_u241.m5825toPx0680j_4(style.m230getElevationD9Ej5fM$foundation_release());
        Magnifier.Builder $this$create_u24lambda_u241_u24lambda_u240 = new Magnifier.Builder(view2);
        if (size != Size.Companion.m3080getUnspecifiedNHjbRc()) {
            $this$create_u24lambda_u241_u24lambda_u240.setSize(MathKt.roundToInt(Size.m3072getWidthimpl(size)), MathKt.roundToInt(Size.m3069getHeightimpl(size)));
        }
        if (!Float.isNaN(cornerRadius)) {
            $this$create_u24lambda_u241_u24lambda_u240.setCornerRadius(cornerRadius);
        }
        if (!Float.isNaN(elevation)) {
            $this$create_u24lambda_u241_u24lambda_u240.setElevation(elevation);
        }
        if (!Float.isNaN(initialZoom)) {
            $this$create_u24lambda_u241_u24lambda_u240.setInitialZoom(initialZoom);
        } else {
            float f = initialZoom;
        }
        $this$create_u24lambda_u241_u24lambda_u240.setClippingEnabled(style.getClippingEnabled$foundation_release());
        Magnifier magnifier = $this$create_u24lambda_u241_u24lambda_u240.build();
        Intrinsics.checkNotNullExpressionValue(magnifier, "Builder(view).run {\n    …    build()\n            }");
        return new PlatformMagnifierImpl(magnifier);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi28Impl$PlatformMagnifierImpl;", "magnifier", "Landroid/widget/Magnifier;", "(Landroid/widget/Magnifier;)V", "update", "", "sourceCenter", "Landroidx/compose/ui/geometry/Offset;", "magnifierCenter", "zoom", "", "update-Wko1d7g", "(JJF)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PlatformMagnifier.kt */
    public static final class PlatformMagnifierImpl extends PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl {
        public static final int $stable = 0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PlatformMagnifierImpl(Magnifier magnifier) {
            super(magnifier);
            Intrinsics.checkNotNullParameter(magnifier, "magnifier");
        }

        /* renamed from: update-Wko1d7g  reason: not valid java name */
        public void m260updateWko1d7g(long sourceCenter, long magnifierCenter, float zoom) {
            if (!Float.isNaN(zoom)) {
                getMagnifier().setZoom(zoom);
            }
            if (OffsetKt.m3022isSpecifiedk4lQ0M(magnifierCenter)) {
                getMagnifier().show(Offset.m3003getXimpl(sourceCenter), Offset.m3004getYimpl(sourceCenter), Offset.m3003getXimpl(magnifierCenter), Offset.m3004getYimpl(magnifierCenter));
            } else {
                getMagnifier().show(Offset.m3003getXimpl(sourceCenter), Offset.m3004getYimpl(sourceCenter));
            }
        }
    }
}

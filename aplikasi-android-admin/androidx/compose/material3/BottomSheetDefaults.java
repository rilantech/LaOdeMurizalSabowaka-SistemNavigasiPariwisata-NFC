package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.material3.tokens.SheetBottomTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0003\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0015\u0010\nR\u0011\u0010\u0016\u001a\u00020\u00178G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/material3/BottomSheetDefaults;", "", "()V", "ContainerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "ExpandedShape", "Landroidx/compose/ui/graphics/Shape;", "getExpandedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "HiddenShape", "getHiddenShape", "ScrimColor", "getScrimColor", "SheetPeekHeight", "getSheetPeekHeight-D9Ej5fM", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "DragHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "width", "height", "shape", "color", "DragHandle-lgZ2HuY", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;JLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SheetDefaults.kt */
public final class BottomSheetDefaults {
    public static final int $stable = 0;
    private static final float Elevation = SheetBottomTokens.INSTANCE.m4421getDockedModalContainerElevationD9Ej5fM();
    public static final BottomSheetDefaults INSTANCE = new BottomSheetDefaults();
    private static final float SheetPeekHeight = Dp.m7554constructorimpl((float) 56);

    private BottomSheetDefaults() {
    }

    public final Shape getHiddenShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1971658024);
        ComposerKt.sourceInformation($composer, "C289@10707L9:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1971658024, $changed, -1, "androidx.compose.material3.BottomSheetDefaults.<get-HiddenShape> (SheetDefaults.kt:288)");
        }
        Shape shape = ShapesKt.toShape(SheetBottomTokens.INSTANCE.getDockedMinimizedContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getExpandedShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1683783414);
        ComposerKt.sourceInformation($composer, "C294@10917L9:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1683783414, $changed, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ExpandedShape> (SheetDefaults.kt:293)");
        }
        Shape shape = ShapesKt.toShape(SheetBottomTokens.INSTANCE.getDockedContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(433375448);
        ComposerKt.sourceInformation($composer, "C299@11092L9:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(433375448, $changed, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ContainerColor> (SheetDefaults.kt:298)");
        }
        long color = ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedContainerColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return color;
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m3268getElevationD9Ej5fM() {
        return Elevation;
    }

    public final long getScrimColor(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-2040719176);
        ComposerKt.sourceInformation($composer, "C307@11388L9:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2040719176, $changed, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ScrimColor> (SheetDefaults.kt:306)");
        }
        long r0 = Color.m4962copywmQWz5c$default(ColorSchemeKt.toColor(ScrimTokens.INSTANCE.getContainerColor(), $composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }

    /* renamed from: getSheetPeekHeight-D9Ej5fM  reason: not valid java name */
    public final float m3269getSheetPeekHeightD9Ej5fM() {
        return SheetPeekHeight;
    }

    public final WindowInsets getWindowInsets(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-511309409);
        ComposerKt.sourceInformation($composer, "C319@11725L29:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511309409, $changed, -1, "androidx.compose.material3.BottomSheetDefaults.<get-windowInsets> (SheetDefaults.kt:319)");
        }
        WindowInsets r0 = WindowInsetsKt.m2351onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, $composer, 8), WindowInsetsSides.Companion.m2380getVerticalJoeWqyM());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }

    /* renamed from: DragHandle-lgZ2HuY  reason: not valid java name */
    public final void m3267DragHandlelgZ2HuY(Modifier modifier, float width, float height, Shape shape, long color, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        float f;
        float height2;
        Shape shape2;
        long j;
        long color2;
        Shape shape3;
        float height3;
        float width2;
        Modifier modifier3;
        long color3;
        float width3;
        Modifier modifier4;
        Modifier modifier5;
        Object value$iv$iv;
        int i2;
        int i3;
        int i4 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1364277227);
        ComposerKt.sourceInformation($composer2, "C(DragHandle)P(2,4:c#ui.unit.Dp,1:c#ui.unit.Dp,3,0:c#ui.graphics.Color)329@12138L6,330@12220L9,333@12336L51,337@12527L46,334@12396L437:SheetDefaults.kt#uh7d8r");
        int $dirty = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i4 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty |= 48;
            f = width;
        } else if ((i4 & 112) == 0) {
            f = width;
            $dirty |= $composer2.changed(f) ? 32 : 16;
        } else {
            f = width;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty |= 384;
            height2 = height;
        } else if ((i4 & 896) == 0) {
            height2 = height;
            $dirty |= $composer2.changed(height2) ? 256 : 128;
        } else {
            height2 = height;
        }
        if ((i4 & 7168) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                if ($composer2.changed((Object) shape2)) {
                    i3 = 2048;
                    $dirty |= i3;
                }
            } else {
                shape2 = shape;
            }
            i3 = 1024;
            $dirty |= i3;
        } else {
            shape2 = shape;
        }
        if ((57344 & i4) == 0) {
            if ((i & 16) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i2 = 16384;
                    $dirty |= i2;
                }
            } else {
                j = color;
            }
            i2 = 8192;
            $dirty |= i2;
        } else {
            j = color;
        }
        if ((46811 & $dirty) != 9362 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i6 != 0) {
                    width3 = SheetBottomTokens.INSTANCE.m4420getDockedDragHandleWidthD9Ej5fM();
                } else {
                    width3 = f;
                }
                if (i7 != 0) {
                    height2 = SheetBottomTokens.INSTANCE.m4419getDockedDragHandleHeightD9Ej5fM();
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getExtraLarge();
                }
                if ((i & 16) != 0) {
                    color3 = Color.m4962copywmQWz5c$default(ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), $composer2, 6), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    $dirty &= -57345;
                } else {
                    color3 = j;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                modifier4 = modifier2;
                width3 = f;
                color3 = j;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1364277227, $dirty, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:325)");
            }
            String dragHandleDescription = Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3701getBottomSheetDragHandleDescriptionadMyvUU(), $composer2, 6);
            Modifier r6 = PaddingKt.m2250paddingVpY3zN4$default(modifier4, 0.0f, SheetDefaultsKt.DragHandleVerticalPadding, 1, (Object) null);
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed((Object) dragHandleDescription);
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                modifier5 = modifier4;
                value$iv$iv = (Function1) new BottomSheetDefaults$DragHandle$1$1(dragHandleDescription);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                Composer composer = $this$cache$iv$iv;
                modifier5 = modifier4;
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SurfaceKt.m3772SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(r6, false, (Function1) value$iv$iv, 1, (Object) null), shape2, color3, 0, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.composableLambda($composer2, -1039573072, true, new BottomSheetDefaults$DragHandle$2(width3, height2)), $composer2, (($dirty >> 6) & 112) | 12582912 | (($dirty >> 6) & 896), 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            int i8 = $dirty;
            width2 = width3;
            color2 = color3;
            height3 = height2;
            shape3 = shape2;
        } else {
            $composer2.skipToGroupEnd();
            int i9 = $dirty;
            height3 = height2;
            shape3 = shape2;
            color2 = j;
            modifier3 = modifier2;
            width2 = f;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer2 = $composer2;
            return;
        }
        Composer composer3 = $composer2;
        endRestartGroup.updateScope(new BottomSheetDefaults$DragHandle$3(this, modifier3, width2, height3, shape3, color2, $changed, i));
    }
}

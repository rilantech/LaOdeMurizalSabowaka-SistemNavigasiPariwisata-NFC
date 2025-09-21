package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ[\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/NavigationBarItemDefaults;", "", "()V", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "indicatorColor", "unselectedIconColor", "unselectedTextColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationBarItemColors;", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationBarItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationBar.kt */
public final class NavigationBarItemDefaults {
    public static final int $stable = 0;
    public static final NavigationBarItemDefaults INSTANCE = new NavigationBarItemDefaults();

    private NavigationBarItemDefaults() {
    }

    /* renamed from: colors-69fazGs  reason: not valid java name */
    public final NavigationBarItemColors m3573colors69fazGs(long selectedIconColor, long selectedTextColor, long indicatorColor, long unselectedIconColor, long unselectedTextColor, long disabledIconColor, long disabledTextColor, Composer $composer, int $changed, int i) {
        long selectedTextColor2;
        long indicatorColor2;
        long unselectedIconColor2;
        long unselectedTextColor2;
        long disabledIconColor2;
        long disabledTextColor2;
        Composer composer = $composer;
        composer.startReplaceableGroup(-1618564327);
        ComposerKt.sourceInformation(composer, "C(colors)P(3:c#ui.graphics.Color,4:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)294@12969L9,295@13056L9,296@13140L9,297@13226L9,298@13317L9:NavigationBar.kt#uh7d8r");
        long selectedIconColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getActiveIconColor(), composer, 6) : selectedIconColor;
        if ((i & 2) != 0) {
            selectedTextColor2 = ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getActiveLabelTextColor(), composer, 6);
        } else {
            selectedTextColor2 = selectedTextColor;
        }
        if ((i & 4) != 0) {
            indicatorColor2 = ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getActiveIndicatorColor(), composer, 6);
        } else {
            indicatorColor2 = indicatorColor;
        }
        if ((i & 8) != 0) {
            unselectedIconColor2 = ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getInactiveIconColor(), composer, 6);
        } else {
            unselectedIconColor2 = unselectedIconColor;
        }
        if ((i & 16) != 0) {
            unselectedTextColor2 = ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getInactiveLabelTextColor(), composer, 6);
        } else {
            unselectedTextColor2 = unselectedTextColor;
        }
        if ((i & 32) != 0) {
            disabledIconColor2 = Color.m4962copywmQWz5c$default(unselectedIconColor2, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledIconColor2 = disabledIconColor;
        }
        if ((i & 64) != 0) {
            disabledTextColor2 = Color.m4962copywmQWz5c$default(unselectedTextColor2, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1618564327, $changed, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:293)");
        } else {
            int i2 = $changed;
        }
        NavigationBarItemColors navigationBarItemColors = new NavigationBarItemColors(selectedIconColor2, selectedTextColor2, indicatorColor2, unselectedIconColor2, unselectedTextColor2, disabledIconColor2, disabledTextColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return navigationBarItemColors;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with disabledIconColor and disabledTextColor")
    /* renamed from: colors-zjMxDiM  reason: not valid java name */
    public final /* synthetic */ NavigationBarItemColors m3574colorszjMxDiM(long selectedIconColor, long selectedTextColor, long indicatorColor, long unselectedIconColor, long unselectedTextColor, Composer $composer, int $changed, int i) {
        long selectedTextColor2;
        long indicatorColor2;
        long unselectedIconColor2;
        long unselectedTextColor2;
        Composer composer = $composer;
        composer.startReplaceableGroup(-213647161);
        ComposerKt.sourceInformation(composer, "C(colors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)317@14135L9,318@14222L9,319@14306L9,320@14392L9,321@14483L9:NavigationBar.kt#uh7d8r");
        long selectedIconColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getActiveIconColor(), composer, 6) : selectedIconColor;
        if ((i & 2) != 0) {
            selectedTextColor2 = ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getActiveLabelTextColor(), composer, 6);
        } else {
            selectedTextColor2 = selectedTextColor;
        }
        if ((i & 4) != 0) {
            indicatorColor2 = ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getActiveIndicatorColor(), composer, 6);
        } else {
            indicatorColor2 = indicatorColor;
        }
        if ((i & 8) != 0) {
            unselectedIconColor2 = ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getInactiveIconColor(), composer, 6);
        } else {
            unselectedIconColor2 = unselectedIconColor;
        }
        if ((i & 16) != 0) {
            unselectedTextColor2 = ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getInactiveLabelTextColor(), composer, 6);
        } else {
            unselectedTextColor2 = unselectedTextColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-213647161, $changed, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:316)");
        } else {
            int i2 = $changed;
        }
        NavigationBarItemColors navigationBarItemColors = new NavigationBarItemColors(selectedIconColor2, selectedTextColor2, indicatorColor2, unselectedIconColor2, unselectedTextColor2, Color.m4962copywmQWz5c$default(unselectedIconColor2, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4962copywmQWz5c$default(unselectedTextColor2, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return navigationBarItemColors;
    }
}

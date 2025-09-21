package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.ListItemType;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a¬\u0001\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u0001H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\u001c\u0010!\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\"¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a8\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a<\u0010-\u001a\u00020\t*\u00020#2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a<\u00102\u001a\u00020\t*\u00020#2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00101\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"ContentEndPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingContentEndPadding", "ListItemHorizontalPadding", "ListItemThreeLineVerticalPadding", "ListItemVerticalPadding", "TrailingHorizontalPadding", "ListItem", "", "headlineContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "overlineContent", "supportingContent", "leadingContent", "trailingContent", "colors", "Landroidx/compose/material3/ListItemColors;", "tonalElevation", "shadowElevation", "ListItem-HXNGIdc", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ListItemColors;FFLandroidx/compose/runtime/Composer;II)V", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "minHeight", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "ListItem-xOgov6c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ProvideTextStyleFromToken", "color", "textToken", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "ProvideTextStyleFromToken-3J-VO9M", "(JLandroidx/compose/material3/tokens/TypographyKeyTokens;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "LeadingContent", "topAlign", "", "LeadingContent-3IgeMak", "(Landroidx/compose/foundation/layout/RowScope;JZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TrailingContent", "TrailingContent-3IgeMak", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
public final class ListItemKt {
    private static final float ContentEndPadding = Dp.m7554constructorimpl((float) 8);
    /* access modifiers changed from: private */
    public static final float LeadingContentEndPadding = Dp.m7554constructorimpl((float) 16);
    private static final float ListItemHorizontalPadding = Dp.m7554constructorimpl((float) 16);
    private static final float ListItemThreeLineVerticalPadding = Dp.m7554constructorimpl((float) 16);
    private static final float ListItemVerticalPadding = Dp.m7554constructorimpl((float) 8);
    private static final float TrailingHorizontalPadding = Dp.m7554constructorimpl((float) 8);

    /* renamed from: ListItem-HXNGIdc  reason: not valid java name */
    public static final void m3539ListItemHXNGIdc(Function2<? super Composer, ? super Integer, Unit> headlineContent, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> overlineContent, Function2<? super Composer, ? super Integer, Unit> supportingContent, Function2<? super Composer, ? super Integer, Unit> leadingContent, Function2<? super Composer, ? super Integer, Unit> trailingContent, ListItemColors colors, float tonalElevation, float shadowElevation, Composer $composer, int $changed, int i) {
        Function2 function2;
        Function2 function22;
        float shadowElevation2;
        float tonalElevation2;
        ListItemColors colors2;
        Function2 trailingContent2;
        Function2 leadingContent2;
        Function2 supportingContent2;
        Function2 overlineContent2;
        Modifier modifier2;
        ListItemColors colors3;
        Function2 trailingContent3;
        Function2 leadingContent3;
        Function2 supportingContent3;
        Function2 overlineContent3;
        float shadowElevation3;
        Modifier modifier3;
        float tonalElevation3;
        Function2 it;
        Function2 decoratedSupportingContent;
        Function2 overlineContent4;
        Function2 decoratedOverlineContent;
        Function2 leadingContent4;
        Function3 decoratedLeadingContent;
        Function3 decoratedTrailingContent;
        float minHeight;
        float f;
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function23 = headlineContent;
        int i3 = $changed;
        int i4 = i;
        Intrinsics.checkNotNullParameter(function23, "headlineContent");
        Composer $composer2 = $composer.startRestartGroup(-1647707763);
        ComposerKt.sourceInformation($composer2, "C(ListItem)P(1,3,4,6,2,8!1,7:c#ui.unit.Dp,5:c#ui.unit.Dp)80@3784L8,155@6557L16,156@6611L29,153@6486L1021:ListItem.kt#uh7d8r");
        int $dirty = $changed;
        if ((i4 & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changedInstance(function23) ? 4 : 2;
        }
        int i5 = i4 & 2;
        if (i5 != 0) {
            $dirty |= 48;
            Modifier modifier4 = modifier;
        } else if ((i3 & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            $dirty |= 384;
            Function2<? super Composer, ? super Integer, Unit> function24 = overlineContent;
        } else if ((i3 & 896) == 0) {
            $dirty |= $composer2.changedInstance(overlineContent) ? 256 : 128;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function25 = overlineContent;
        }
        int i7 = i4 & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            Function2<? super Composer, ? super Integer, Unit> function26 = supportingContent;
        } else if ((i3 & 7168) == 0) {
            $dirty |= $composer2.changedInstance(supportingContent) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function27 = supportingContent;
        }
        int i8 = i4 & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            function2 = leadingContent;
        } else if ((i3 & 57344) == 0) {
            function2 = leadingContent;
            $dirty |= $composer2.changedInstance(function2) ? 16384 : 8192;
        } else {
            function2 = leadingContent;
        }
        int i9 = i4 & 32;
        if (i9 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function22 = trailingContent;
        } else if ((i3 & 458752) == 0) {
            function22 = trailingContent;
            $dirty |= $composer2.changedInstance(function22) ? 131072 : 65536;
        } else {
            function22 = trailingContent;
        }
        if ((i3 & 3670016) == 0) {
            if ((i4 & 64) != 0) {
                ListItemColors listItemColors = colors;
            } else if ($composer2.changed((Object) colors)) {
                i2 = 1048576;
                $dirty |= i2;
            }
            i2 = 524288;
            $dirty |= i2;
        } else {
            ListItemColors listItemColors2 = colors;
        }
        int i10 = i4 & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
            float f2 = tonalElevation;
        } else if ((i3 & 29360128) == 0) {
            $dirty |= $composer2.changed(tonalElevation) ? 8388608 : 4194304;
        } else {
            float f3 = tonalElevation;
        }
        int i11 = i4 & 256;
        if (i11 != 0) {
            $dirty |= 100663296;
            float f4 = shadowElevation;
        } else if ((i3 & 234881024) == 0) {
            $dirty |= $composer2.changed(shadowElevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            float f5 = shadowElevation;
        }
        if (($dirty & 191739611) != 38347922 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i6 != 0) {
                    overlineContent3 = null;
                } else {
                    overlineContent3 = overlineContent;
                }
                if (i7 != 0) {
                    supportingContent3 = null;
                } else {
                    supportingContent3 = supportingContent;
                }
                if (i8 != 0) {
                    leadingContent3 = null;
                } else {
                    leadingContent3 = function2;
                }
                if (i9 != 0) {
                    trailingContent3 = null;
                } else {
                    trailingContent3 = function22;
                }
                if ((i4 & 64) != 0) {
                    colors3 = ListItemDefaults.INSTANCE.m3536colorsJ08w3E(0, 0, 0, 0, 0, 0, 0, 0, 0, $composer2, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                    $dirty &= -3670017;
                } else {
                    colors3 = colors;
                }
                if (i10 != 0) {
                    tonalElevation3 = ListItemDefaults.INSTANCE.m3537getElevationD9Ej5fM();
                } else {
                    tonalElevation3 = tonalElevation;
                }
                shadowElevation3 = i11 != 0 ? ListItemDefaults.INSTANCE.m3537getElevationD9Ej5fM() : shadowElevation;
            } else {
                $composer2.skipToGroupEnd();
                if ((i4 & 64) != 0) {
                    $dirty &= -3670017;
                }
                modifier3 = modifier;
                overlineContent3 = overlineContent;
                supportingContent3 = supportingContent;
                tonalElevation3 = tonalElevation;
                shadowElevation3 = shadowElevation;
                trailingContent3 = function22;
                leadingContent3 = function2;
                colors3 = colors;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1647707763, $dirty, -1, "androidx.compose.material3.ListItem (ListItem.kt:73)");
            }
            Function2 decoratedHeadlineContent = ComposableLambdaKt.composableLambda($composer2, -403249643, true, new ListItemKt$ListItem$decoratedHeadlineContent$1(colors3, $dirty, function23));
            if (supportingContent3 != null) {
                it = supportingContent3;
                decoratedSupportingContent = ComposableLambdaKt.composableLambda($composer2, -1020860251, true, new ListItemKt$ListItem$decoratedSupportingContent$1$1(colors3, $dirty, it));
            } else {
                it = supportingContent3;
                decoratedSupportingContent = null;
            }
            if (overlineContent3 != null) {
                Function2 it2 = overlineContent3;
                overlineContent4 = overlineContent3;
                Function2 function28 = it2;
                decoratedOverlineContent = ComposableLambdaKt.composableLambda($composer2, -764441232, true, new ListItemKt$ListItem$decoratedOverlineContent$1$1(colors3, $dirty, it2));
            } else {
                overlineContent4 = overlineContent3;
                decoratedOverlineContent = null;
            }
            ListItemType.Companion companion = ListItemType.Companion;
            boolean z = false;
            boolean z2 = decoratedOverlineContent != null;
            if (decoratedSupportingContent != null) {
                z = true;
            }
            int listItemType = companion.m3556getListItemType7AlIA9s$material3_release(z2, z);
            if (leadingContent3 != null) {
                leadingContent4 = leadingContent3;
                decoratedLeadingContent = ComposableLambdaKt.composableLambda($composer2, 1673725255, true, new ListItemKt$ListItem$decoratedLeadingContent$1$1(colors3, $dirty, listItemType, leadingContent3));
            } else {
                leadingContent4 = leadingContent3;
                decoratedLeadingContent = null;
            }
            if (trailingContent3 != null) {
                decoratedTrailingContent = ComposableLambdaKt.composableLambda($composer2, 1392069445, true, new ListItemKt$ListItem$decoratedTrailingContent$1$1(colors3, $dirty, listItemType, trailingContent3));
            } else {
                decoratedTrailingContent = null;
            }
            if (ListItemType.m3551equalsimpl0(listItemType, ListItemType.Companion.m3557getOneLineAlXitO8())) {
                minHeight = ListTokens.INSTANCE.m4266getListItemOneLineContainerHeightD9Ej5fM();
            } else if (ListItemType.m3551equalsimpl0(listItemType, ListItemType.Companion.m3559getTwoLineAlXitO8())) {
                minHeight = ListTokens.INSTANCE.m4270getListItemTwoLineContainerHeightD9Ej5fM();
            } else {
                minHeight = ListTokens.INSTANCE.m4268getListItemThreeLineContainerHeightD9Ej5fM();
            }
            PaddingValues outerPaddingValues = PaddingKt.m2242PaddingValuesYgX7TsA(ListItemHorizontalPadding, ListItemType.m3551equalsimpl0(listItemType, ListItemType.Companion.m3558getThreeLineAlXitO8()) ? ListItemThreeLineVerticalPadding : ListItemVerticalPadding);
            if (ListItemType.m3551equalsimpl0(listItemType, ListItemType.Companion.m3558getThreeLineAlXitO8())) {
                f = ContentEndPadding;
            } else {
                f = Dp.m7554constructorimpl((float) 0);
            }
            m3540ListItemxOgov6c(modifier3, (Shape) null, colors3.containerColor$material3_release($composer2, ($dirty >> 18) & 14).getValue().m4973unboximpl(), colors3.headlineColor$material3_release(true, $composer2, (($dirty >> 15) & 112) | 6).getValue().m4973unboximpl(), tonalElevation3, shadowElevation3, minHeight, outerPaddingValues, ComposableLambdaKt.composableLambda($composer2, -1813277157, true, new ListItemKt$ListItem$1(decoratedLeadingContent, PaddingKt.m2245PaddingValuesa9UjIt4$default(0.0f, 0.0f, f, 0.0f, 11, (Object) null), ListItemType.m3551equalsimpl0(listItemType, ListItemType.Companion.m3558getThreeLineAlXitO8()) ? Alignment.Companion.getTop() : Alignment.Companion.getCenterVertically(), ListItemType.m3551equalsimpl0(listItemType, ListItemType.Companion.m3558getThreeLineAlXitO8()) ? Arrangement.INSTANCE.getTop() : Arrangement.INSTANCE.getCenter(), decoratedTrailingContent, decoratedOverlineContent, decoratedHeadlineContent, decoratedSupportingContent)), $composer2, (($dirty >> 3) & 14) | 100663296 | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752), 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            supportingContent2 = it;
            overlineContent2 = overlineContent4;
            leadingContent2 = leadingContent4;
            tonalElevation2 = tonalElevation3;
            int i12 = $dirty;
            modifier2 = modifier3;
            shadowElevation2 = shadowElevation3;
            trailingContent2 = trailingContent3;
            colors2 = colors3;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            overlineContent2 = overlineContent;
            colors2 = colors;
            tonalElevation2 = tonalElevation;
            shadowElevation2 = shadowElevation;
            int i13 = $dirty;
            trailingContent2 = function22;
            leadingContent2 = function2;
            supportingContent2 = supportingContent;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            Modifier modifier6 = modifier2;
            return;
        }
        Composer composer2 = $composer2;
        Modifier modifier7 = modifier2;
        endRestartGroup.updateScope(new ListItemKt$ListItem$2(headlineContent, modifier2, overlineContent2, supportingContent2, leadingContent2, trailingContent2, colors2, tonalElevation2, shadowElevation2, $changed, i));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0109  */
    /* renamed from: ListItem-xOgov6c  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m3540ListItemxOgov6c(androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, float r35, float r36, float r37, androidx.compose.foundation.layout.PaddingValues r38, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r14 = r37
            r15 = r38
            r13 = r39
            r12 = r41
            r11 = r42
            r0 = 1069030861(0x3fb81dcd, float:1.4384094)
            r1 = r40
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ListItem)P(4,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.unit.Dp,6:c#ui.unit.Dp,3:c#ui.unit.Dp,5)204@8376L5,205@8428L14,206@8487L12,213@8715L451:ListItem.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r41
            r2 = r11 & 1
            if (r2 == 0) goto L_0x0023
            r1 = r1 | 6
            r3 = r29
            goto L_0x0036
        L_0x0023:
            r3 = r12 & 14
            if (r3 != 0) goto L_0x0034
            r3 = r29
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0031
            r4 = 4
            goto L_0x0032
        L_0x0031:
            r4 = 2
        L_0x0032:
            r1 = r1 | r4
            goto L_0x0036
        L_0x0034:
            r3 = r29
        L_0x0036:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004f
            r4 = r11 & 2
            if (r4 != 0) goto L_0x0049
            r4 = r30
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004b
            r5 = 32
            goto L_0x004d
        L_0x0049:
            r4 = r30
        L_0x004b:
            r5 = 16
        L_0x004d:
            r1 = r1 | r5
            goto L_0x0051
        L_0x004f:
            r4 = r30
        L_0x0051:
            r5 = r12 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x006a
            r5 = r11 & 4
            if (r5 != 0) goto L_0x0064
            r5 = r31
            boolean r7 = r10.changed((long) r5)
            if (r7 == 0) goto L_0x0066
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0064:
            r5 = r31
        L_0x0066:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r1 = r1 | r7
            goto L_0x006c
        L_0x006a:
            r5 = r31
        L_0x006c:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0085
            r7 = r11 & 8
            if (r7 != 0) goto L_0x007f
            r7 = r33
            boolean r9 = r10.changed((long) r7)
            if (r9 == 0) goto L_0x0081
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x007f:
            r7 = r33
        L_0x0081:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r1 = r1 | r9
            goto L_0x0087
        L_0x0085:
            r7 = r33
        L_0x0087:
            r9 = r11 & 16
            r16 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0093
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r0 = r35
            goto L_0x00a9
        L_0x0093:
            r17 = r12 & r16
            if (r17 != 0) goto L_0x00a7
            r0 = r35
            boolean r18 = r10.changed((float) r0)
            if (r18 == 0) goto L_0x00a2
            r18 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r18 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r1 = r1 | r18
            goto L_0x00a9
        L_0x00a7:
            r0 = r35
        L_0x00a9:
            r18 = r11 & 32
            r19 = 458752(0x70000, float:6.42848E-40)
            if (r18 == 0) goto L_0x00b6
            r20 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r20
            r0 = r36
            goto L_0x00cc
        L_0x00b6:
            r20 = r12 & r19
            if (r20 != 0) goto L_0x00ca
            r0 = r36
            boolean r20 = r10.changed((float) r0)
            if (r20 == 0) goto L_0x00c5
            r20 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c7
        L_0x00c5:
            r20 = 65536(0x10000, float:9.18355E-41)
        L_0x00c7:
            r1 = r1 | r20
            goto L_0x00cc
        L_0x00ca:
            r0 = r36
        L_0x00cc:
            r20 = r11 & 64
            if (r20 == 0) goto L_0x00d5
            r20 = 1572864(0x180000, float:2.204052E-39)
        L_0x00d2:
            r1 = r1 | r20
            goto L_0x00e7
        L_0x00d5:
            r20 = 3670016(0x380000, float:5.142788E-39)
            r20 = r12 & r20
            if (r20 != 0) goto L_0x00e7
            boolean r20 = r10.changed((float) r14)
            if (r20 == 0) goto L_0x00e4
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00e4:
            r20 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00d2
        L_0x00e7:
            r0 = r11 & 128(0x80, float:1.794E-43)
            r20 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00f0
            r1 = r1 | r20
            goto L_0x0101
        L_0x00f0:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r12
            if (r0 != 0) goto L_0x0101
            boolean r0 = r10.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x00fe
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0100
        L_0x00fe:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x0100:
            r1 = r1 | r0
        L_0x0101:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0109
            r0 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0107:
            r1 = r1 | r0
            goto L_0x011a
        L_0x0109:
            r0 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r12
            if (r0 != 0) goto L_0x011a
            boolean r0 = r10.changedInstance(r13)
            if (r0 == 0) goto L_0x0117
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0107
        L_0x0117:
            r0 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0107
        L_0x011a:
            r0 = 191739611(0xb6db6db, float:4.5782105E-32)
            r0 = r0 & r1
            r3 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r3) goto L_0x013d
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x012a
            goto L_0x013d
        L_0x012a:
            r10.skipToGroupEnd()
            r16 = r29
            r22 = r35
            r23 = r36
            r24 = r1
            r17 = r4
            r18 = r5
            r20 = r7
            goto L_0x0228
        L_0x013d:
            r10.startDefaults()
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0175
            boolean r0 = r10.getDefaultsInvalid()
            if (r0 == 0) goto L_0x014b
            goto L_0x0175
        L_0x014b:
            r10.skipToGroupEnd()
            r0 = r11 & 2
            if (r0 == 0) goto L_0x0154
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0154:
            r0 = r11 & 4
            if (r0 == 0) goto L_0x015a
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x015a:
            r0 = r11 & 8
            if (r0 == 0) goto L_0x016b
            r0 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r3 = r35
            r1 = r0
            r2 = r4
            r4 = r5
            r6 = r7
            r0 = r29
            r8 = r36
            goto L_0x01bf
        L_0x016b:
            r0 = r29
            r3 = r35
            r2 = r4
            r4 = r5
            r6 = r7
            r8 = r36
            goto L_0x01bf
        L_0x0175:
            if (r2 == 0) goto L_0x017c
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x017e
        L_0x017c:
            r0 = r29
        L_0x017e:
            r2 = r11 & 2
            r3 = 6
            if (r2 == 0) goto L_0x018c
            androidx.compose.material3.ListItemDefaults r2 = androidx.compose.material3.ListItemDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r10, r3)
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x018d
        L_0x018c:
            r2 = r4
        L_0x018d:
            r4 = r11 & 4
            if (r4 == 0) goto L_0x019a
            androidx.compose.material3.ListItemDefaults r4 = androidx.compose.material3.ListItemDefaults.INSTANCE
            long r4 = r4.getContainerColor(r10, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x019b
        L_0x019a:
            r4 = r5
        L_0x019b:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x01a8
            androidx.compose.material3.ListItemDefaults r6 = androidx.compose.material3.ListItemDefaults.INSTANCE
            long r6 = r6.getContentColor(r10, r3)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x01a9
        L_0x01a8:
            r6 = r7
        L_0x01a9:
            if (r9 == 0) goto L_0x01b2
            androidx.compose.material3.ListItemDefaults r3 = androidx.compose.material3.ListItemDefaults.INSTANCE
            float r3 = r3.m3537getElevationD9Ej5fM()
            goto L_0x01b4
        L_0x01b2:
            r3 = r35
        L_0x01b4:
            if (r18 == 0) goto L_0x01bd
            androidx.compose.material3.ListItemDefaults r8 = androidx.compose.material3.ListItemDefaults.INSTANCE
            float r8 = r8.m3537getElevationD9Ej5fM()
            goto L_0x01bf
        L_0x01bd:
            r8 = r36
        L_0x01bf:
            r10.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01d1
            r9 = -1
            java.lang.String r11 = "androidx.compose.material3.ListItem (ListItem.kt:202)"
            r12 = 1069030861(0x3fb81dcd, float:1.4384094)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r1, r9, r11)
        L_0x01d1:
            androidx.compose.material3.ListItemKt$ListItem$3 r9 = new androidx.compose.material3.ListItemKt$ListItem$3
            r9.<init>(r14, r15, r13, r1)
            r11 = 1393735016(0x5312b568, float:6.3010872E11)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r11, r12, r9)
            r25 = r9
            kotlin.jvm.functions.Function2 r25 = (kotlin.jvm.functions.Function2) r25
            r9 = r1 & 14
            r9 = r9 | r20
            r11 = r1 & 112(0x70, float:1.57E-43)
            r9 = r9 | r11
            r11 = r1 & 896(0x380, float:1.256E-42)
            r9 = r9 | r11
            r11 = r1 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | r11
            r11 = r1 & r16
            r9 = r9 | r11
            r11 = r1 & r19
            r27 = r9 | r11
            r24 = 0
            r28 = 64
            r16 = r0
            r17 = r2
            r18 = r4
            r20 = r6
            r22 = r3
            r23 = r8
            r26 = r10
            androidx.compose.material3.SurfaceKt.m3772SurfaceT9BRK9s(r16, r17, r18, r20, r22, r23, r24, r25, r26, r27, r28)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x021a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x021a:
            r16 = r0
            r24 = r1
            r17 = r2
            r22 = r3
            r18 = r4
            r20 = r6
            r23 = r8
        L_0x0228:
            androidx.compose.runtime.ScopeUpdateScope r12 = r10.endRestartGroup()
            if (r12 != 0) goto L_0x0231
            r26 = r10
            goto L_0x0258
        L_0x0231:
            androidx.compose.material3.ListItemKt$ListItem$4 r25 = new androidx.compose.material3.ListItemKt$ListItem$4
            r0 = r25
            r1 = r16
            r2 = r17
            r3 = r18
            r5 = r20
            r7 = r22
            r8 = r23
            r9 = r37
            r26 = r10
            r10 = r38
            r11 = r39
            r14 = r12
            r12 = r41
            r13 = r42
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13)
            r0 = r25
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x0258:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ListItemKt.m3540ListItemxOgov6c(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, float, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: LeadingContent-3IgeMak  reason: not valid java name */
    public static final void m3538LeadingContent3IgeMak(RowScope $this$LeadingContent_u2d3IgeMak, long contentColor, boolean topAlign, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        RowScope rowScope = $this$LeadingContent_u2d3IgeMak;
        boolean z = topAlign;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(1383930970);
        ComposerKt.sourceInformation($composer2, "C(LeadingContent)P(1:c#ui.graphics.Color,2)236@9308L274:ListItem.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed((Object) rowScope) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 32 : 16;
        } else {
            long j = contentColor;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1383930970, $dirty2, -1, "androidx.compose.material3.LeadingContent (ListItem.kt:232)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4953boximpl(contentColor))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 315166618, true, new ListItemKt$LeadingContent$1(z, rowScope, function2, $dirty2)), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ListItemKt$LeadingContent$2($this$LeadingContent_u2d3IgeMak, contentColor, topAlign, content, $changed));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: TrailingContent-3IgeMak  reason: not valid java name */
    public static final void m3542TrailingContent3IgeMak(RowScope $this$TrailingContent_u2d3IgeMak, long contentColor, boolean topAlign, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        RowScope rowScope = $this$TrailingContent_u2d3IgeMak;
        boolean z = topAlign;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(1404787004);
        ComposerKt.sourceInformation($composer2, "C(TrailingContent)P(1:c#ui.graphics.Color,2)249@9723L316:ListItem.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed((Object) rowScope) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 32 : 16;
        } else {
            long j = contentColor;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function2 = content;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1404787004, $dirty2, -1, "androidx.compose.material3.TrailingContent (ListItem.kt:245)");
            }
            Modifier r0 = PaddingKt.m2250paddingVpY3zN4$default(Modifier.Companion, TrailingHorizontalPadding, 0.0f, 2, (Object) null);
            Modifier modifier = Modifier.Companion;
            if (!z) {
                modifier = rowScope.align(modifier, Alignment.Companion.getCenterVertically());
            }
            Modifier modifier$iv = r0.then(modifier);
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
            Modifier modifier2 = modifier$iv;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m4575constructorimpl($composer2);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            materializerOf.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            Composer $composer$iv = $composer2;
            int i2 = ($changed$iv$iv$iv >> 9) & 14;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i3 = ((0 >> 6) & 112) | 6;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 1419469451, "C254@9892L141:ListItem.kt#uh7d8r");
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            Density density = density$iv$iv;
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Alignment alignment = contentAlignment$iv;
            m3541ProvideTextStyleFromToken3JVO9M(contentColor, ListTokens.INSTANCE.getListItemTrailingSupportingTextFont(), content, $composer3, (($dirty2 >> 3) & 14) | 48 | (($dirty2 >> 3) & 896));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i4 = $dirty2;
            return;
        }
        int i5 = $dirty2;
        endRestartGroup.updateScope(new ListItemKt$TrailingContent$2($this$TrailingContent_u2d3IgeMak, contentColor, topAlign, content, $changed));
    }

    /* access modifiers changed from: private */
    /* renamed from: ProvideTextStyleFromToken-3J-VO9M  reason: not valid java name */
    public static final void m3541ProvideTextStyleFromToken3JVO9M(long color, TypographyKeyTokens textToken, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1133967795);
        ComposerKt.sourceInformation($composer2, "C(ProvideTextStyleFromToken)P(0:c#ui.graphics.Color,2)394@15546L10,395@15582L111:ListItem.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(color) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed((Object) textToken) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 256 : 128;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1133967795, $dirty, -1, "androidx.compose.material3.ProvideTextStyleFromToken (ListItem.kt:389)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4953boximpl(color))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, -514310925, true, new ListItemKt$ProvideTextStyleFromToken$1(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), textToken), content, $dirty)), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ListItemKt$ProvideTextStyleFromToken$2(color, textToken, content, $changed));
        }
    }
}

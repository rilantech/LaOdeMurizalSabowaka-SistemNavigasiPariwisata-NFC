package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a[\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a=\u0010\u0017\u001a\u00020\t2\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\t0\u0019¢\u0006\u0002\b\u00132\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019¢\u0006\u0002\b\u00132\u0006\u0010\u001b\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010\u001c\u001aU\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2&\u0010\u0010\u001a\"\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u0001\u0010'\u001a\u00020\t*\u00020\u00122\u0006\u0010 \u001a\u00020!2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\t0\u0019¢\u0006\u0002\b\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020!2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019¢\u0006\u0002\b\u00132\b\b\u0002\u0010*\u001a\u00020!2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\r2\b\b\u0002\u0010.\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a)\u00101\u001a\u000202*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a9\u0010:\u001a\u000202*\u0002032\u0006\u0010;\u001a\u0002052\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010\u001b\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006>²\u0006\n\u0010$\u001a\u00020\u0002X\u0002"}, d2 = {"BottomNavigationAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomNavigationHeight", "Landroidx/compose/ui/unit/Dp;", "F", "BottomNavigationItemHorizontalPadding", "CombinedItemTextBaseline", "BottomNavigation", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomNavigation-PEIptTM", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigationItemBaselineLayout", "icon", "Lkotlin/Function0;", "label", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "BottomNavigationTransition", "activeColor", "inactiveColor", "selected", "", "Lkotlin/ParameterName;", "name", "animationProgress", "BottomNavigationTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "BottomNavigationItem", "onClick", "enabled", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "BottomNavigationItem-jY6E1Zs", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;III)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomNavigation.kt */
public final class BottomNavigationKt {
    private static final TweenSpec<Float> BottomNavigationAnimationSpec = new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing(), 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final float BottomNavigationHeight = Dp.m5844constructorimpl((float) 56);
    private static final float BottomNavigationItemHorizontalPadding = Dp.m5844constructorimpl((float) 12);
    private static final float CombinedItemTextBaseline = Dp.m5844constructorimpl((float) 12);

    /* renamed from: BottomNavigation-PEIptTM  reason: not valid java name */
    public static final void m1183BottomNavigationPEIptTM(Modifier modifier, long backgroundColor, long contentColor, float elevation, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        long contentColor2;
        float f;
        float elevation2;
        long contentColor3;
        long backgroundColor2;
        Modifier modifier3;
        float elevation3;
        long backgroundColor3;
        Modifier modifier4;
        int i2;
        int i3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i4 = $changed;
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(456489494);
        ComposerKt.sourceInformation($composer2, "C(BottomNavigation)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)91@4098L6,92@4147L32,96@4290L403:BottomNavigation.kt#jmzs0o");
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
        if ((i4 & 112) == 0) {
            if ((i & 2) == 0) {
                j = backgroundColor;
                if ($composer2.changed(j)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                j = backgroundColor;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            j = backgroundColor;
        }
        if ((i4 & 896) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                contentColor2 = contentColor;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            f = elevation;
        } else if ((i4 & 7168) == 0) {
            f = elevation;
            $dirty |= $composer2.changed(f) ? 2048 : 1024;
        } else {
            f = elevation;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((57344 & i4) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 16384 : 8192;
        }
        if ((46811 & $dirty) != 9362 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    backgroundColor3 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                    $dirty &= -113;
                } else {
                    backgroundColor3 = j;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    contentColor2 = ColorsKt.m1259contentColorForek8zF_U(backgroundColor3, $composer2, ($dirty >> 3) & 14);
                }
                elevation3 = i6 != 0 ? BottomNavigationDefaults.INSTANCE.m1182getElevationD9Ej5fM() : f;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
                backgroundColor3 = j;
                elevation3 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(456489494, $dirty, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:89)");
            }
            SurfaceKt.m1420SurfaceFjzlyU(modifier4, (Shape) null, backgroundColor3, contentColor2, (BorderStroke) null, elevation3, ComposableLambdaKt.composableLambda($composer2, 678339930, true, new BottomNavigationKt$BottomNavigation$1(function3, $dirty)), $composer2, ($dirty & 14) | 1572864 | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 6) & 458752), 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i7 = $dirty;
            modifier3 = modifier4;
            backgroundColor2 = backgroundColor3;
            elevation2 = elevation3;
            contentColor3 = contentColor2;
        } else {
            $composer2.skipToGroupEnd();
            int i8 = $dirty;
            backgroundColor2 = j;
            contentColor3 = contentColor2;
            elevation2 = f;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new BottomNavigationKt$BottomNavigation$2(modifier3, backgroundColor2, contentColor3, elevation2, content, $changed, i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:185:0x0489  */
    /* renamed from: BottomNavigationItem-jY6E1Zs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1184BottomNavigationItemjY6E1Zs(androidx.compose.foundation.layout.RowScope r38, boolean r39, kotlin.jvm.functions.Function0<kotlin.Unit> r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.ui.Modifier r42, boolean r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, boolean r45, androidx.compose.foundation.interaction.MutableInteractionSource r46, long r47, long r49, androidx.compose.runtime.Composer r51, int r52, int r53, int r54) {
        /*
            r15 = r38
            r14 = r40
            r12 = r41
            r13 = r52
            r10 = r54
            java.lang.String r0 = "$this$BottomNavigationItem"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "icon"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1473735525(0xffffffffa828949b, float:-9.358097E-15)
            r1 = r51
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BottomNavigationItem)P(7,6,2,5,1,4!2,8:c#ui.graphics.Color,9:c#ui.graphics.Color)154@7017L39,155@7110L7,156@7202L6,167@7705L61,169@7772L804:BottomNavigation.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r52
            r2 = r53
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r10
            if (r3 == 0) goto L_0x0035
            r1 = r1 | 6
            goto L_0x0043
        L_0x0035:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x0043
            boolean r3 = r11.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x0041
            r3 = 4
            goto L_0x0042
        L_0x0041:
            r3 = 2
        L_0x0042:
            r1 = r1 | r3
        L_0x0043:
            r3 = r10 & 1
            if (r3 == 0) goto L_0x004c
            r1 = r1 | 48
            r9 = r39
            goto L_0x0061
        L_0x004c:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x005f
            r9 = r39
            boolean r3 = r11.changed((boolean) r9)
            if (r3 == 0) goto L_0x005b
            r3 = 32
            goto L_0x005d
        L_0x005b:
            r3 = 16
        L_0x005d:
            r1 = r1 | r3
            goto L_0x0061
        L_0x005f:
            r9 = r39
        L_0x0061:
            r3 = r10 & 2
            if (r3 == 0) goto L_0x0068
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0078
        L_0x0068:
            r3 = r13 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0078
            boolean r3 = r11.changedInstance(r14)
            if (r3 == 0) goto L_0x0075
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0077
        L_0x0075:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0077:
            r1 = r1 | r3
        L_0x0078:
            r3 = r10 & 4
            if (r3 == 0) goto L_0x007f
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x008f
        L_0x007f:
            r3 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x008f
            boolean r3 = r11.changedInstance(r12)
            if (r3 == 0) goto L_0x008c
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x008e
        L_0x008c:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x008e:
            r1 = r1 | r3
        L_0x008f:
            r3 = r10 & 8
            if (r3 == 0) goto L_0x0098
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r6 = r42
            goto L_0x00af
        L_0x0098:
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r13
            if (r6 != 0) goto L_0x00ad
            r6 = r42
            boolean r7 = r11.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x00a9
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ab
        L_0x00a9:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x00ab:
            r1 = r1 | r7
            goto L_0x00af
        L_0x00ad:
            r6 = r42
        L_0x00af:
            r7 = r10 & 16
            if (r7 == 0) goto L_0x00b9
            r8 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r8
            r8 = r43
            goto L_0x00d0
        L_0x00b9:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x00ce
            r8 = r43
            boolean r16 = r11.changed((boolean) r8)
            if (r16 == 0) goto L_0x00c9
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cb
        L_0x00c9:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00cb:
            r1 = r1 | r16
            goto L_0x00d0
        L_0x00ce:
            r8 = r43
        L_0x00d0:
            r16 = r10 & 32
            if (r16 == 0) goto L_0x00db
            r17 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r17
            r4 = r44
            goto L_0x00f3
        L_0x00db:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r13 & r17
            if (r17 != 0) goto L_0x00f1
            r4 = r44
            boolean r17 = r11.changedInstance(r4)
            if (r17 == 0) goto L_0x00ec
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ee
        L_0x00ec:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00ee:
            r1 = r1 | r17
            goto L_0x00f3
        L_0x00f1:
            r4 = r44
        L_0x00f3:
            r17 = r10 & 64
            if (r17 == 0) goto L_0x00fe
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r18
            r0 = r45
            goto L_0x0116
        L_0x00fe:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r13 & r18
            if (r18 != 0) goto L_0x0114
            r0 = r45
            boolean r19 = r11.changed((boolean) r0)
            if (r19 == 0) goto L_0x010f
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0111
        L_0x010f:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x0111:
            r1 = r1 | r19
            goto L_0x0116
        L_0x0114:
            r0 = r45
        L_0x0116:
            r5 = r10 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x0121
            r20 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r20
            r0 = r46
            goto L_0x0139
        L_0x0121:
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            r20 = r13 & r20
            if (r20 != 0) goto L_0x0137
            r0 = r46
            boolean r20 = r11.changed((java.lang.Object) r0)
            if (r20 == 0) goto L_0x0132
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0134
        L_0x0132:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0134:
            r1 = r1 | r20
            goto L_0x0139
        L_0x0137:
            r0 = r46
        L_0x0139:
            r20 = 1879048192(0x70000000, float:1.58456325E29)
            r20 = r13 & r20
            if (r20 != 0) goto L_0x0154
            r0 = r10 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x014e
            r8 = r47
            boolean r0 = r11.changed((long) r8)
            if (r0 == 0) goto L_0x0150
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0152
        L_0x014e:
            r8 = r47
        L_0x0150:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0152:
            r1 = r1 | r0
            goto L_0x0156
        L_0x0154:
            r8 = r47
        L_0x0156:
            r0 = r53 & 14
            if (r0 != 0) goto L_0x016d
            r0 = r10 & 512(0x200, float:7.175E-43)
            if (r0 != 0) goto L_0x0168
            r8 = r49
            boolean r0 = r11.changed((long) r8)
            if (r0 == 0) goto L_0x016a
            r0 = 4
            goto L_0x016b
        L_0x0168:
            r8 = r49
        L_0x016a:
            r0 = 2
        L_0x016b:
            r2 = r2 | r0
            goto L_0x016f
        L_0x016d:
            r8 = r49
        L_0x016f:
            r0 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r0 & r1
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r4) goto L_0x019b
            r0 = r2 & 11
            r4 = 2
            if (r0 != r4) goto L_0x019b
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0184
            goto L_0x019b
        L_0x0184:
            r11.skipToGroupEnd()
            r19 = r43
            r17 = r44
            r18 = r45
            r23 = r46
            r21 = r47
            r26 = r1
            r27 = r2
            r20 = r6
            r24 = r8
            goto L_0x0498
        L_0x019b:
            r11.startDefaults()
            r0 = r13 & 1
            if (r0 == 0) goto L_0x01ca
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x01a9
            goto L_0x01ca
        L_0x01a9:
            r11.skipToGroupEnd()
            r0 = r10 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x01b4
            r0 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r0
        L_0x01b4:
            r0 = r10 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x01ba
            r2 = r2 & -15
        L_0x01ba:
            r0 = r43
            r7 = r45
            r3 = r47
            r5 = r2
            r20 = r6
            r6 = r44
            r2 = r1
            r1 = r46
            goto L_0x0287
        L_0x01ca:
            if (r3 == 0) goto L_0x01d1
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01d2
        L_0x01d1:
            r0 = r6
        L_0x01d2:
            if (r7 == 0) goto L_0x01d6
            r3 = 1
            goto L_0x01d8
        L_0x01d6:
            r3 = r43
        L_0x01d8:
            if (r16 == 0) goto L_0x01dc
            r6 = 0
            goto L_0x01de
        L_0x01dc:
            r6 = r44
        L_0x01de:
            if (r17 == 0) goto L_0x01e2
            r7 = 1
            goto L_0x01e4
        L_0x01e2:
            r7 = r45
        L_0x01e4:
            if (r5 == 0) goto L_0x0229
            r5 = 0
            r16 = 0
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            r4 = 0
            r42 = r11
            r19 = 0
            r20 = r0
            java.lang.Object r0 = r42.rememberedValue()
            r21 = 0
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r43 = r3
            java.lang.Object r3 = r22.getEmpty()
            if (r0 != r3) goto L_0x021a
            r3 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r44 = r0
            r0 = r42
            r0.updateRememberedValue(r3)
            goto L_0x0220
        L_0x021a:
            r44 = r0
            r0 = r42
            r3 = r44
        L_0x0220:
            r11.endReplaceableGroup()
            r0 = r3
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x022f
        L_0x0229:
            r20 = r0
            r43 = r3
            r0 = r46
        L_0x022f:
            r3 = r10 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0259
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 6
            r5 = 0
            r42 = r0
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            r44 = r4
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r4)
            java.lang.Object r0 = r11.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r3 = r0.m3263unboximpl()
            r0 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r0
            goto L_0x025d
        L_0x0259:
            r42 = r0
            r3 = r47
        L_0x025d:
            r0 = r10 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0281
            androidx.compose.material.ContentAlpha r0 = androidx.compose.material.ContentAlpha.INSTANCE
            r5 = 6
            float r23 = r0.getMedium(r11, r5)
            r27 = 14
            r28 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r21 = r3
            long r8 = androidx.compose.ui.graphics.Color.m3252copywmQWz5c$default(r21, r23, r24, r25, r26, r27, r28)
            r2 = r2 & -15
            r0 = r43
            r5 = r2
            r2 = r1
            r1 = r42
            goto L_0x0287
        L_0x0281:
            r0 = r43
            r5 = r2
            r2 = r1
            r1 = r42
        L_0x0287:
            r11.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x0298
            java.lang.String r10 = "androidx.compose.material.BottomNavigationItem (BottomNavigation.kt:146)"
            r13 = -1473735525(0xffffffffa828949b, float:-9.358097E-15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r2, r5, r10)
        L_0x0298:
            if (r6 == 0) goto L_0x02b1
            r13 = r6
            r16 = 0
            androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1 r10 = new androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
            r10.<init>(r6, r2)
            r50 = r6
            r6 = 1343298261(0x50111ad5, float:9.7378191E9)
            r42 = r13
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r6, r13, r10)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            goto L_0x02b4
        L_0x02b1:
            r50 = r6
            r6 = 0
        L_0x02b4:
            int r10 = r2 >> 21
            r10 = r10 & 896(0x380, float:1.256E-42)
            r13 = 6
            r10 = r10 | r13
            r13 = 2
            r16 = 0
            r18 = 0
            r42 = r16
            r43 = r18
            r44 = r3
            r46 = r11
            r47 = r10
            r48 = r13
            androidx.compose.foundation.Indication r10 = androidx.compose.material.ripple.RippleKt.m1523rememberRipple9IZ8Weo(r42, r43, r44, r46, r47, r48)
            androidx.compose.ui.semantics.Role$Companion r13 = androidx.compose.ui.semantics.Role.Companion
            int r13 = r13.m5168getTabo7Vup1c()
            androidx.compose.ui.semantics.Role r13 = androidx.compose.ui.semantics.Role.m5155boximpl(r13)
            r42 = r20
            r43 = r39
            r44 = r1
            r45 = r10
            r46 = r0
            r47 = r13
            r48 = r40
            androidx.compose.ui.Modifier r13 = androidx.compose.foundation.selection.SelectableKt.m833selectableO2vRcR0(r42, r43, r44, r45, r46, r47, r48)
            r16 = 2
            r18 = 0
            r19 = 1065353216(0x3f800000, float:1.0)
            r21 = 0
            r42 = r38
            r43 = r13
            r44 = r19
            r45 = r21
            r46 = r16
            r47 = r18
            androidx.compose.ui.Modifier r13 = androidx.compose.foundation.layout.RowScope.weight$default(r42, r43, r44, r45, r46, r47)
            androidx.compose.ui.Alignment$Companion r16 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r16 = r16.getCenter()
            r18 = 48
            r51 = r16
            r16 = 0
            r19 = r0
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = 0
            int r21 = r18 >> 3
            r21 = r21 & 14
            int r22 = r18 >> 3
            r22 = r22 & 112(0x70, float:1.57E-43)
            r23 = r1
            r1 = r21 | r22
            r21 = r10
            r10 = r51
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r10, r0, r11, r1)
            int r22 = r18 << 3
            r22 = r22 & 112(0x70, float:1.57E-43)
            r24 = 0
            r51 = r0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = 0
            int r0 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r0)
            r25 = r10
            androidx.compose.runtime.CompositionLocalMap r10 = r11.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r26 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r26 = r26.getConstructor()
            kotlin.jvm.functions.Function3 r27 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r13)
            r28 = r13
            int r13 = r22 << 9
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r17 = 6
            r13 = r13 | 6
            r29 = r26
            r26 = r27
            r27 = 0
            androidx.compose.runtime.Applier r14 = r11.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x037d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x037d:
            r11.startReusableNode()
            boolean r14 = r11.getInserting()
            if (r14 == 0) goto L_0x038c
            r14 = r29
            r11.createNode(r14)
            goto L_0x0391
        L_0x038c:
            r14 = r29
            r11.useNode()
        L_0x0391:
            r29 = r14
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m2865constructorimpl(r11)
            r30 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r31 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r31.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r14, r1, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r14, r10, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetCompositeKeyHash()
            r31 = 0
            r42 = r14
            r32 = 0
            boolean r33 = r42.getInserting()
            if (r33 != 0) goto L_0x03d3
            r33 = r1
            java.lang.Object r1 = r42.rememberedValue()
            r34 = r10
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            if (r1 != 0) goto L_0x03d0
            goto L_0x03d7
        L_0x03d0:
            r10 = r42
            goto L_0x03e7
        L_0x03d3:
            r33 = r1
            r34 = r10
        L_0x03d7:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r10 = r42
            r10.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r14.apply(r1, r15)
        L_0x03e7:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r11)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r1)
            int r10 = r13 >> 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r14 = r26
            r14.invoke(r1, r11, r10)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r1)
            int r1 = r13 >> 9
            r1 = r1 & 14
            r10 = r11
            r15 = 0
            r26 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r30 = r1
            java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r18 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r17 = 6
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r17 = r10
            r31 = 0
            r32 = r0
            r0 = -1277963842(0xffffffffb3d3d1be, float:-9.863605E-8)
            r35 = r1
            java.lang.String r1 = "C182@8149L421:BottomNavigation.kt#jmzs0o"
            r36 = r13
            r13 = r17
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r1)
            androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1 r0 = new androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
            r0.<init>(r7, r12, r6, r2)
            r1 = -1411872801(0xffffffffabd887df, float:-1.5385435E-12)
            r17 = r6
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r1, r6, r0)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            int r1 = r2 >> 27
            r1 = r1 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            int r6 = r5 << 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r1 = r1 | r6
            int r6 = r2 << 3
            r6 = r6 & 896(0x380, float:1.256E-42)
            r1 = r1 | r6
            r42 = r3
            r44 = r8
            r46 = r39
            r47 = r0
            r48 = r13
            r49 = r1
            m1185BottomNavigationTransitionKlgxPg(r42, r44, r46, r47, r48, r49)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r11.endReplaceableGroup()
            r11.endNode()
            r11.endReplaceableGroup()
            r11.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x048c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x048c:
            r17 = r50
            r26 = r2
            r21 = r3
            r27 = r5
            r18 = r7
            r24 = r8
        L_0x0498:
            androidx.compose.runtime.ScopeUpdateScope r15 = r11.endRestartGroup()
            if (r15 != 0) goto L_0x04a1
            r29 = r11
            goto L_0x04d1
        L_0x04a1:
            androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3 r28 = new androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
            r0 = r28
            r1 = r38
            r2 = r39
            r3 = r40
            r4 = r41
            r5 = r20
            r6 = r19
            r7 = r17
            r8 = r18
            r9 = r23
            r29 = r11
            r10 = r21
            r12 = r24
            r14 = r52
            r37 = r15
            r15 = r53
            r16 = r54
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r14, r15, r16)
            r0 = r28
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r37
            r1.updateScope(r0)
        L_0x04d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomNavigationKt.m1184BottomNavigationItemjY6E1Zs(androidx.compose.foundation.layout.RowScope, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomNavigationTransition-Klgx-Pg  reason: not valid java name */
    public static final void m1185BottomNavigationTransitionKlgxPg(long activeColor, long inactiveColor, boolean selected, Function3<? super Float, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        long j = activeColor;
        long j2 = inactiveColor;
        boolean z = selected;
        Function3<? super Float, ? super Composer, ? super Integer, Unit> function3 = content;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-985175058);
        ComposerKt.sourceInformation($composer2, "C(BottomNavigationTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)227@9694L128,234@9897L181:BottomNavigation.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed(j) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed(j2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-985175058, $dirty2, -1, "androidx.compose.material.BottomNavigationTransition (BottomNavigation.kt:221)");
            }
            State animationProgress$delegate = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, BottomNavigationAnimationSpec, 0.0f, (String) null, (Function1<? super Float, Unit>) null, $composer2, 48, 28);
            long color = ColorKt.m3304lerpjxsXWHM(j2, j, BottomNavigationTransition_Klgx_Pg$lambda$3(animationProgress$delegate));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3243boximpl(Color.m3252copywmQWz5c$default(color, 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3255getAlphaimpl(color)))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, -138092754, true, new BottomNavigationKt$BottomNavigationTransition$1(function3, $dirty2, animationProgress$delegate)), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i2 = $dirty2;
            Composer composer = $composer2;
            return;
        }
        int i3 = $dirty2;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new BottomNavigationKt$BottomNavigationTransition$2(activeColor, inactiveColor, selected, content, $changed));
    }

    /* access modifiers changed from: private */
    public static final float BottomNavigationTransition_Klgx_Pg$lambda$3(State<Float> $animationProgress$delegate) {
        return ((Number) $animationProgress$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x040b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BottomNavigationItemBaselineLayout(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, float r52, androidx.compose.runtime.Composer r53, int r54) {
        /*
            r0 = r50
            r1 = r51
            r2 = r52
            r3 = r54
            r4 = -1162995092(0xffffffffbaae1a6c, float:-0.0013283021)
            r5 = r53
            androidx.compose.runtime.Composer r5 = r5.startRestartGroup(r4)
            java.lang.String r6 = "C(BottomNavigationItemBaselineLayout)P(!1,2)259@10751L1203:BottomNavigation.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            r6 = r54
            r7 = r3 & 14
            if (r7 != 0) goto L_0x0026
            boolean r7 = r5.changedInstance(r0)
            if (r7 == 0) goto L_0x0024
            r7 = 4
            goto L_0x0025
        L_0x0024:
            r7 = 2
        L_0x0025:
            r6 = r6 | r7
        L_0x0026:
            r7 = r3 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0036
            boolean r7 = r5.changedInstance(r1)
            if (r7 == 0) goto L_0x0033
            r7 = 32
            goto L_0x0035
        L_0x0033:
            r7 = 16
        L_0x0035:
            r6 = r6 | r7
        L_0x0036:
            r7 = r3 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0046
            boolean r7 = r5.changed((float) r2)
            if (r7 == 0) goto L_0x0043
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0045
        L_0x0043:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0045:
            r6 = r6 | r7
        L_0x0046:
            r7 = r6 & 731(0x2db, float:1.024E-42)
            r9 = 146(0x92, float:2.05E-43)
            if (r7 != r9) goto L_0x0058
            boolean r7 = r5.getSkipping()
            if (r7 != 0) goto L_0x0053
            goto L_0x0058
        L_0x0053:
            r5.skipToGroupEnd()
            goto L_0x040e
        L_0x0058:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0064
            r7 = -1
            java.lang.String r9 = "androidx.compose.material.BottomNavigationItemBaselineLayout (BottomNavigation.kt:253)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r6, r7, r9)
        L_0x0064:
            androidx.compose.material.BottomNavigationKt$BottomNavigationItemBaselineLayout$2 r4 = new androidx.compose.material.BottomNavigationKt$BottomNavigationItemBaselineLayout$2
            r4.<init>(r1, r2)
            androidx.compose.ui.layout.MeasurePolicy r4 = (androidx.compose.ui.layout.MeasurePolicy) r4
            r7 = 0
            r9 = r7
            r10 = 0
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r11)
            java.lang.String r12 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r12)
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r13 = (androidx.compose.ui.Modifier) r13
            int r14 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r5, r7)
            androidx.compose.runtime.CompositionLocalMap r15 = r5.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r16 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r17 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r13)
            int r8 = r9 << 9
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | 6
            r18 = r16
            r16 = r17
            r17 = 0
            androidx.compose.runtime.Applier r7 = r5.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x00a7
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00a7:
            r5.startReusableNode()
            boolean r7 = r5.getInserting()
            if (r7 == 0) goto L_0x00b6
            r7 = r18
            r5.createNode(r7)
            goto L_0x00bb
        L_0x00b6:
            r7 = r18
            r5.useNode()
        L_0x00bb:
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2865constructorimpl(r5)
            r20 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r21 = androidx.compose.ui.node.ComposeUiNode.Companion
            r22 = r7
            kotlin.jvm.functions.Function2 r7 = r21.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r11, r4, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r11, r15, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetCompositeKeyHash()
            r21 = 0
            r23 = r11
            r24 = 0
            boolean r25 = r23.getInserting()
            if (r25 != 0) goto L_0x00fd
            r25 = r4
            java.lang.Object r4 = r23.rememberedValue()
            r26 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r14)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r9)
            if (r4 != 0) goto L_0x00fa
            goto L_0x0101
        L_0x00fa:
            r9 = r23
            goto L_0x0111
        L_0x00fd:
            r25 = r4
            r26 = r9
        L_0x0101:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            r9 = r23
            r9.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            r11.apply(r4, r7)
        L_0x0111:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r4)
            int r7 = r8 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r9 = r16
            r9.invoke(r4, r5, r7)
            r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r4)
            int r7 = r8 >> 9
            r7 = r7 & 14
            r11 = r5
            r16 = 0
            r4 = 619997303(0x24f46877, float:1.059951E-16)
            r21 = r7
            java.lang.String r7 = "C261@10781L41:BottomNavigation.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r7)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            java.lang.String r7 = "icon"
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r4, r7)
            r7 = 6
            r23 = 0
            r24 = r8
            r8 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r11.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r8)
            androidx.compose.ui.Alignment$Companion r28 = androidx.compose.ui.Alignment.Companion
            r29 = r9
            androidx.compose.ui.Alignment r9 = r28.getTopStart()
            r28 = r10
            r10 = 0
            int r30 = r7 >> 3
            r30 = r30 & 14
            int r31 = r7 >> 3
            r31 = r31 & 112(0x70, float:1.57E-43)
            r32 = r13
            r13 = r30 | r31
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r9, r10, r11, r13)
            int r30 = r7 << 3
            r30 = r30 & 112(0x70, float:1.57E-43)
            r31 = 0
            r33 = r9
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r11.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r12)
            r9 = 0
            int r34 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r9)
            androidx.compose.runtime.CompositionLocalMap r9 = r11.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r35 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r35 = r35.getConstructor()
            kotlin.jvm.functions.Function3 r36 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r4)
            r37 = r4
            int r4 = r30 << 9
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | 6
            r38 = r35
            r35 = r36
            r36 = 0
            r39 = r10
            androidx.compose.runtime.Applier r10 = r11.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x01b9
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01b9:
            r11.startReusableNode()
            boolean r10 = r11.getInserting()
            if (r10 == 0) goto L_0x01c8
            r10 = r38
            r11.createNode(r10)
            goto L_0x01cd
        L_0x01c8:
            r10 = r38
            r11.useNode()
        L_0x01cd:
            r38 = r10
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m2865constructorimpl(r11)
            r40 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r41 = androidx.compose.ui.node.ComposeUiNode.Companion
            r42 = r14
            kotlin.jvm.functions.Function2 r14 = r41.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r10, r13, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r10, r9, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetCompositeKeyHash()
            r41 = 0
            r43 = r10
            r44 = 0
            boolean r45 = r43.getInserting()
            if (r45 != 0) goto L_0x0211
            r45 = r9
            java.lang.Object r9 = r43.rememberedValue()
            r46 = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r34)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r13)
            if (r9 != 0) goto L_0x020e
            goto L_0x0215
        L_0x020e:
            r13 = r43
            goto L_0x0225
        L_0x0211:
            r45 = r9
            r46 = r13
        L_0x0215:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r34)
            r13 = r43
            r13.updateRememberedValue(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r34)
            r10.apply(r9, r14)
        L_0x0225:
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r11)
            androidx.compose.runtime.SkippableUpdater r9 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r9)
            int r10 = r4 >> 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r13 = r35
            r13.invoke(r9, r11, r10)
            r9 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r9)
            int r9 = r4 >> 9
            r9 = r9 & 14
            r10 = r11
            r14 = 0
            r35 = r4
            r4 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r40 = r9
            java.lang.String r9 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r4, r9)
            androidx.compose.foundation.layout.BoxScopeInstance r41 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r43 = r7 >> 6
            r43 = r43 & 112(0x70, float:1.57E-43)
            r43 = r43 | 6
            androidx.compose.foundation.layout.BoxScope r41 = (androidx.compose.foundation.layout.BoxScope) r41
            r44 = r10
            r47 = 0
            r4 = -1517374535(0xffffffffa58eb3b9, float:-2.4754858E-16)
            r48 = r7
            java.lang.String r7 = "C261@10814L6:BottomNavigation.kt#jmzs0o"
            r49 = r13
            r13 = r44
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r4, r7)
            r4 = r6 & 14
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r0.invoke(r13, r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r11.endReplaceableGroup()
            r11.endNode()
            r11.endReplaceableGroup()
            r11.endReplaceableGroup()
            r4 = -1198312436(0xffffffffb893340c, float:-7.019201E-5)
            r11.startReplaceableGroup(r4)
            java.lang.String r4 = "263@10872L253"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            if (r1 == 0) goto L_0x03f2
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            java.lang.String r7 = "label"
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r4, r7)
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.draw.AlphaKt.alpha(r4, r2)
            float r7 = BottomNavigationItemHorizontalPadding
            r10 = 0
            r13 = 0
            r14 = 2
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.PaddingKt.m540paddingVpY3zN4$default(r4, r7, r10, r14, r13)
            r7 = 0
            r10 = r7
            r7 = 0
            r13 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r11.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r8)
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r8 = r8.getTopStart()
            r13 = 0
            int r14 = r10 >> 3
            r14 = r14 & 14
            int r23 = r10 >> 3
            r23 = r23 & 112(0x70, float:1.57E-43)
            r14 = r14 | r23
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r8, r13, r11, r14)
            int r23 = r10 << 3
            r23 = r23 & 112(0x70, float:1.57E-43)
            r27 = 0
            r53 = r7
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r11.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r12)
            r7 = 0
            int r7 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r7)
            androidx.compose.runtime.CompositionLocalMap r12 = r11.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r18 = r18.getConstructor()
            kotlin.jvm.functions.Function3 r19 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r4)
            r30 = r4
            int r4 = r23 << 9
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | 6
            r31 = r18
            r18 = r19
            r19 = 0
            r33 = r8
            androidx.compose.runtime.Applier r8 = r11.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x0319
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0319:
            r11.startReusableNode()
            boolean r8 = r11.getInserting()
            if (r8 == 0) goto L_0x0328
            r8 = r31
            r11.createNode(r8)
            goto L_0x032d
        L_0x0328:
            r8 = r31
            r11.useNode()
        L_0x032d:
            r31 = r8
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m2865constructorimpl(r11)
            r34 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r35 = androidx.compose.ui.node.ComposeUiNode.Companion
            r36 = r13
            kotlin.jvm.functions.Function2 r13 = r35.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r8, r14, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r8, r12, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetCompositeKeyHash()
            r35 = 0
            r37 = r8
            r38 = 0
            boolean r39 = r37.getInserting()
            if (r39 != 0) goto L_0x0371
            r39 = r12
            java.lang.Object r12 = r37.rememberedValue()
            r40 = r14
            java.lang.Integer r14 = java.lang.Integer.valueOf(r7)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r14)
            if (r12 != 0) goto L_0x036e
            goto L_0x0375
        L_0x036e:
            r14 = r37
            goto L_0x0385
        L_0x0371:
            r39 = r12
            r40 = r14
        L_0x0375:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r7)
            r14 = r37
            r14.updateRememberedValue(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r7)
            r8.apply(r12, r13)
        L_0x0385:
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r11)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r8)
            int r12 = r4 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r13 = r18
            r13.invoke(r8, r11, r12)
            r8 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r8)
            int r8 = r4 >> 9
            r8 = r8 & 14
            r12 = r11
            r14 = 0
            r18 = r4
            r4 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r4, r9)
            androidx.compose.foundation.layout.BoxScopeInstance r4 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r9 = r10 >> 6
            r9 = r9 & 112(0x70, float:1.57E-43)
            r9 = r9 | 6
            androidx.compose.foundation.layout.BoxScope r4 = (androidx.compose.foundation.layout.BoxScope) r4
            r20 = r12
            r34 = 0
            r35 = r4
            r4 = -1517374233(0xffffffffa58eb4e7, float:-2.4755658E-16)
            r37 = r7
            java.lang.String r7 = "C268@11116L7:BottomNavigation.kt#jmzs0o"
            r38 = r8
            r8 = r20
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r7)
            int r4 = r6 >> 3
            r4 = r4 & 14
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.invoke(r8, r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r11.endReplaceableGroup()
            r11.endNode()
            r11.endReplaceableGroup()
            r11.endReplaceableGroup()
        L_0x03f2:
            r11.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x040e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x040e:
            androidx.compose.runtime.ScopeUpdateScope r4 = r5.endRestartGroup()
            if (r4 != 0) goto L_0x0415
            goto L_0x041f
        L_0x0415:
            androidx.compose.material.BottomNavigationKt$BottomNavigationItemBaselineLayout$3 r7 = new androidx.compose.material.BottomNavigationKt$BottomNavigationItemBaselineLayout$3
            r7.<init>(r0, r1, r2, r3)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r4.updateScope(r7)
        L_0x041f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomNavigationKt.BottomNavigationItemBaselineLayout(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, float, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-3p2s80s  reason: not valid java name */
    public static final MeasureResult m1189placeIcon3p2s80s(MeasureScope $this$placeIcon_u2d3p2s80s, Placeable iconPlaceable, long constraints) {
        int height = Constraints.m5787getMaxHeightimpl(constraints);
        return MeasureScope.layout$default($this$placeIcon_u2d3p2s80s, iconPlaceable.getWidth(), height, (Map) null, new BottomNavigationKt$placeIcon$1(iconPlaceable, (height - iconPlaceable.getHeight()) / 2), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-DIyivk0  reason: not valid java name */
    public static final MeasureResult m1190placeLabelAndIconDIyivk0(MeasureScope $this$placeLabelAndIcon_u2dDIyivk0, Placeable labelPlaceable, Placeable iconPlaceable, long constraints, float iconPositionAnimationProgress) {
        int height = Constraints.m5787getMaxHeightimpl(constraints);
        int netBaselineAdjustment = $this$placeLabelAndIcon_u2dDIyivk0.m5819roundToPx0680j_4(CombinedItemTextBaseline) - labelPlaceable.get(AlignmentLineKt.getFirstBaseline());
        int contentVerticalPadding = RangesKt.coerceAtLeast((height - ((iconPlaceable.getHeight() + labelPlaceable.getHeight()) + netBaselineAdjustment)) / 2, 0);
        int unselectedIconY = (height - iconPlaceable.getHeight()) / 2;
        int selectedIconY = contentVerticalPadding;
        int labelY = selectedIconY + iconPlaceable.getHeight() + netBaselineAdjustment;
        int containerWidth = Math.max(labelPlaceable.getWidth(), iconPlaceable.getWidth());
        int iconDistance = unselectedIconY - selectedIconY;
        int i = iconDistance;
        return MeasureScope.layout$default($this$placeLabelAndIcon_u2dDIyivk0, containerWidth, height, (Map) null, new BottomNavigationKt$placeLabelAndIcon$1(iconPositionAnimationProgress, labelPlaceable, (containerWidth - labelPlaceable.getWidth()) / 2, labelY, MathKt.roundToInt(((float) iconDistance) * (((float) 1) - iconPositionAnimationProgress)), iconPlaceable, (containerWidth - iconPlaceable.getWidth()) / 2, selectedIconY), 4, (Object) null);
    }
}

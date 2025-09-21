package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001ae\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00130\u001d¢\u0006\u0002\b\u001f¢\u0006\u0002\b H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001ak\u0010#\u001a\u00020\u00132\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\u0013\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010%¢\u0006\u0002\b\u001f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0003¢\u0006\u0002\u0010-\u001a\u0001\u0010.\u001a\u00020\u0013*\u00020\u001e2\u0006\u0010/\u001a\u00020*2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130%2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u00101\u001a\u00020*2\u0015\b\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010%¢\u0006\u0002\b\u001f2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u000205H\u0007¢\u0006\u0002\u00106\u001a;\u00107\u001a\u000208*\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001aS\u0010B\u001a\u000208*\u0002092\u0006\u0010C\u001a\u00020;2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u00020?2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\r\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f\"\u0019\u0010\u0010\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0011\u0010\u000f\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006F"}, d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalOffset", "IndicatorVerticalPadding", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationBarHeight", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "()F", "NavigationBarItemVerticalPadding", "getNavigationBarItemVerticalPadding", "NavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItemBaselineLayout", "indicatorRipple", "Lkotlin/Function0;", "indicator", "icon", "label", "alwaysShowLabel", "", "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/runtime/Composer;I)V", "NavigationBarItem", "selected", "onClick", "enabled", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationBar.kt */
public final class NavigationBarKt {
    private static final String IconLayoutIdTag = "icon";
    /* access modifiers changed from: private */
    public static final float IndicatorHorizontalPadding = Dp.m5844constructorimpl(Dp.m5844constructorimpl(NavigationBarTokens.INSTANCE.m2566getActiveIndicatorWidthD9Ej5fM() - NavigationBarTokens.INSTANCE.m2569getIconSizeD9Ej5fM()) / ((float) 2));
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset = Dp.m5844constructorimpl((float) 12);
    /* access modifiers changed from: private */
    public static final float IndicatorVerticalPadding = Dp.m5844constructorimpl(Dp.m5844constructorimpl(NavigationBarTokens.INSTANCE.m2565getActiveIndicatorHeightD9Ej5fM() - NavigationBarTokens.INSTANCE.m2569getIconSizeD9Ej5fM()) / ((float) 2));
    private static final int ItemAnimationDurationMillis = 100;
    private static final String LabelLayoutIdTag = "label";
    /* access modifiers changed from: private */
    public static final float NavigationBarHeight = NavigationBarTokens.INSTANCE.m2568getContainerHeightD9Ej5fM();
    private static final float NavigationBarItemHorizontalPadding = Dp.m5844constructorimpl((float) 8);
    private static final float NavigationBarItemVerticalPadding = Dp.m5844constructorimpl((float) 16);

    /* JADX WARNING: Removed duplicated region for block: B:111:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00df  */
    /* renamed from: NavigationBar-HsRjFd4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1865NavigationBarHsRjFd4(androidx.compose.ui.Modifier r26, long r27, long r29, float r31, androidx.compose.foundation.layout.WindowInsets r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r11 = r33
            r12 = r35
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1596802123(0x5f2d444b, float:1.2485187E19)
            r1 = r34
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(NavigationBar)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,5)100@4715L14,101@4771L11,103@4929L12,106@4996L503:NavigationBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r35
            r2 = r36 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r26
            goto L_0x0035
        L_0x0022:
            r3 = r12 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r26
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0030
            r4 = 4
            goto L_0x0031
        L_0x0030:
            r4 = 2
        L_0x0031:
            r1 = r1 | r4
            goto L_0x0035
        L_0x0033:
            r3 = r26
        L_0x0035:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r36 & 2
            if (r4 != 0) goto L_0x0048
            r4 = r27
            boolean r6 = r10.changed((long) r4)
            if (r6 == 0) goto L_0x004a
            r6 = 32
            goto L_0x004c
        L_0x0048:
            r4 = r27
        L_0x004a:
            r6 = 16
        L_0x004c:
            r1 = r1 | r6
            goto L_0x0050
        L_0x004e:
            r4 = r27
        L_0x0050:
            r6 = r12 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0069
            r6 = r36 & 4
            if (r6 != 0) goto L_0x0063
            r6 = r29
            boolean r8 = r10.changed((long) r6)
            if (r8 == 0) goto L_0x0065
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0063:
            r6 = r29
        L_0x0065:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r8
            goto L_0x006b
        L_0x0069:
            r6 = r29
        L_0x006b:
            r8 = r36 & 8
            if (r8 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r9 = r31
            goto L_0x0089
        L_0x0074:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0087
            r9 = r31
            boolean r13 = r10.changed((float) r9)
            if (r13 == 0) goto L_0x0083
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r13
            goto L_0x0089
        L_0x0087:
            r9 = r31
        L_0x0089:
            r13 = 57344(0xe000, float:8.0356E-41)
            r14 = r12 & r13
            if (r14 != 0) goto L_0x00a5
            r14 = r36 & 16
            if (r14 != 0) goto L_0x009f
            r14 = r32
            boolean r15 = r10.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00a1
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x009f:
            r14 = r32
        L_0x00a1:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r1 = r1 | r15
            goto L_0x00a7
        L_0x00a5:
            r14 = r32
        L_0x00a7:
            r15 = r36 & 32
            if (r15 == 0) goto L_0x00af
            r15 = 196608(0x30000, float:2.75506E-40)
        L_0x00ad:
            r1 = r1 | r15
            goto L_0x00c0
        L_0x00af:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r12
            if (r15 != 0) goto L_0x00c0
            boolean r15 = r10.changedInstance(r11)
            if (r15 == 0) goto L_0x00bd
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ad
        L_0x00bd:
            r15 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ad
        L_0x00c0:
            r15 = 374491(0x5b6db, float:5.24774E-40)
            r15 = r15 & r1
            r13 = 74898(0x12492, float:1.04954E-40)
            if (r15 != r13) goto L_0x00df
            boolean r13 = r10.getSkipping()
            if (r13 != 0) goto L_0x00d0
            goto L_0x00df
        L_0x00d0:
            r10.skipToGroupEnd()
            r20 = r1
            r13 = r3
            r16 = r6
            r18 = r9
            r19 = r14
            r14 = r4
            goto L_0x01aa
        L_0x00df:
            r10.startDefaults()
            r13 = r12 & 1
            r15 = -57345(0xffffffffffff1fff, float:NaN)
            if (r13 == 0) goto L_0x010a
            boolean r13 = r10.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00f0
            goto L_0x010a
        L_0x00f0:
            r10.skipToGroupEnd()
            r2 = r36 & 2
            if (r2 == 0) goto L_0x00f9
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00f9:
            r2 = r36 & 4
            if (r2 == 0) goto L_0x00ff
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00ff:
            r2 = r36 & 16
            if (r2 == 0) goto L_0x0104
            r1 = r1 & r15
        L_0x0104:
            r2 = r3
            r3 = r4
            r5 = r6
            r7 = r9
            r8 = r14
            goto L_0x014a
        L_0x010a:
            if (r2 == 0) goto L_0x0111
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0112
        L_0x0111:
            r2 = r3
        L_0x0112:
            r3 = r36 & 2
            r13 = 6
            if (r3 == 0) goto L_0x0120
            androidx.compose.material3.NavigationBarDefaults r3 = androidx.compose.material3.NavigationBarDefaults.INSTANCE
            long r3 = r3.getContainerColor(r10, r13)
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0121
        L_0x0120:
            r3 = r4
        L_0x0121:
            r5 = r36 & 4
            if (r5 == 0) goto L_0x0132
            androidx.compose.material3.MaterialTheme r5 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r5 = r5.getColorScheme(r10, r13)
            long r5 = androidx.compose.material3.ColorSchemeKt.m1658contentColorFor4WTKRHQ(r5, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0133
        L_0x0132:
            r5 = r6
        L_0x0133:
            if (r8 == 0) goto L_0x013c
            androidx.compose.material3.NavigationBarDefaults r7 = androidx.compose.material3.NavigationBarDefaults.INSTANCE
            float r7 = r7.m1861getElevationD9Ej5fM()
            goto L_0x013d
        L_0x013c:
            r7 = r9
        L_0x013d:
            r8 = r36 & 16
            if (r8 == 0) goto L_0x0149
            androidx.compose.material3.NavigationBarDefaults r8 = androidx.compose.material3.NavigationBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r8 = r8.getWindowInsets(r10, r13)
            r1 = r1 & r15
            goto L_0x014a
        L_0x0149:
            r8 = r14
        L_0x014a:
            r10.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0159
            r9 = -1
            java.lang.String r13 = "androidx.compose.material3.NavigationBar (NavigationBar.kt:98)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r9, r13)
        L_0x0159:
            androidx.compose.material3.NavigationBarKt$NavigationBar$1 r0 = new androidx.compose.material3.NavigationBarKt$NavigationBar$1
            r0.<init>(r8, r11, r1)
            r9 = 105663120(0x64c4a90, float:3.8422915E-35)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r9, r13, r0)
            r22 = r0
            kotlin.jvm.functions.Function2 r22 = (kotlin.jvm.functions.Function2) r22
            r0 = 12582912(0xc00000, float:1.7632415E-38)
            r9 = r1 & 14
            r0 = r0 | r9
            int r9 = r1 << 3
            r9 = r9 & 896(0x380, float:1.256E-42)
            r0 = r0 | r9
            int r9 = r1 << 3
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r9
            int r9 = r1 << 3
            r13 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r13
            r24 = r0 | r9
            r14 = 0
            r20 = 0
            r21 = 0
            r25 = 98
            r13 = r2
            r15 = r3
            r17 = r5
            r19 = r7
            r23 = r10
            androidx.compose.material3.SurfaceKt.m2062SurfaceT9BRK9s(r13, r14, r15, r17, r19, r20, r21, r22, r23, r24, r25)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01a0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01a0:
            r20 = r1
            r13 = r2
            r14 = r3
            r16 = r5
            r18 = r7
            r19 = r8
        L_0x01aa:
            androidx.compose.runtime.ScopeUpdateScope r9 = r10.endRestartGroup()
            if (r9 != 0) goto L_0x01b3
            r22 = r10
            goto L_0x01d2
        L_0x01b3:
            androidx.compose.material3.NavigationBarKt$NavigationBar$2 r21 = new androidx.compose.material3.NavigationBarKt$NavigationBar$2
            r0 = r21
            r1 = r13
            r2 = r14
            r4 = r16
            r6 = r18
            r7 = r19
            r8 = r33
            r11 = r9
            r9 = r35
            r22 = r10
            r10 = r36
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10)
            r0 = r21
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x01d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.m1865NavigationBarHsRjFd4(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v34, resolved type: androidx.compose.material3.MappedInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v51, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v69, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v5, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v52, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v54, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03f9  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0405  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0486  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0489  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0528  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x053a  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x05d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavigationBarItem(androidx.compose.foundation.layout.RowScope r50, boolean r51, kotlin.jvm.functions.Function0<kotlin.Unit> r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, androidx.compose.ui.Modifier r54, boolean r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, boolean r57, androidx.compose.material3.NavigationBarItemColors r58, androidx.compose.foundation.interaction.MutableInteractionSource r59, androidx.compose.runtime.Composer r60, int r61, int r62) {
        /*
            r13 = r50
            r14 = r51
            r15 = r52
            r12 = r53
            r11 = r61
            r10 = r62
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "icon"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -663510974(0xffffffffd873a042, float:-1.07147851E15)
            r1 = r60
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(NavigationBarItem)P(8,7,3,6,2,5)167@7728L8,168@7788L39,189@8761L30,202@9139L52,191@8797L2501:NavigationBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r61
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r10
            if (r2 == 0) goto L_0x0035
            r1 = r1 | 6
            goto L_0x0043
        L_0x0035:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0043
            boolean r2 = r9.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0041
            r2 = 4
            goto L_0x0042
        L_0x0041:
            r2 = 2
        L_0x0042:
            r1 = r1 | r2
        L_0x0043:
            r2 = r10 & 1
            if (r2 == 0) goto L_0x004a
            r1 = r1 | 48
            goto L_0x005a
        L_0x004a:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x005a
            boolean r2 = r9.changed((boolean) r14)
            if (r2 == 0) goto L_0x0057
            r2 = 32
            goto L_0x0059
        L_0x0057:
            r2 = 16
        L_0x0059:
            r1 = r1 | r2
        L_0x005a:
            r2 = r10 & 2
            if (r2 == 0) goto L_0x0061
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0071
        L_0x0061:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0071
            boolean r2 = r9.changedInstance(r15)
            if (r2 == 0) goto L_0x006e
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0070
        L_0x006e:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0070:
            r1 = r1 | r2
        L_0x0071:
            r2 = r10 & 4
            if (r2 == 0) goto L_0x0078
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0078:
            r2 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0088
            boolean r2 = r9.changedInstance(r12)
            if (r2 == 0) goto L_0x0085
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r1 = r1 | r2
        L_0x0088:
            r2 = r10 & 8
            r34 = 57344(0xe000, float:8.0356E-41)
            if (r2 == 0) goto L_0x0094
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r3 = r54
            goto L_0x00a9
        L_0x0094:
            r3 = r11 & r34
            if (r3 != 0) goto L_0x00a7
            r3 = r54
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x00a3
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r4 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r1 = r1 | r4
            goto L_0x00a9
        L_0x00a7:
            r3 = r54
        L_0x00a9:
            r4 = r10 & 16
            if (r4 == 0) goto L_0x00b3
            r5 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r5
            r5 = r55
            goto L_0x00c9
        L_0x00b3:
            r5 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r11
            if (r5 != 0) goto L_0x00c7
            r5 = r55
            boolean r6 = r9.changed((boolean) r5)
            if (r6 == 0) goto L_0x00c3
            r6 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c5
        L_0x00c3:
            r6 = 65536(0x10000, float:9.18355E-41)
        L_0x00c5:
            r1 = r1 | r6
            goto L_0x00c9
        L_0x00c7:
            r5 = r55
        L_0x00c9:
            r6 = r10 & 32
            if (r6 == 0) goto L_0x00d3
            r7 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r7
            r7 = r56
            goto L_0x00ea
        L_0x00d3:
            r7 = 3670016(0x380000, float:5.142788E-39)
            r7 = r7 & r11
            if (r7 != 0) goto L_0x00e8
            r7 = r56
            boolean r16 = r9.changedInstance(r7)
            if (r16 == 0) goto L_0x00e3
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e5
        L_0x00e3:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e5:
            r1 = r1 | r16
            goto L_0x00ea
        L_0x00e8:
            r7 = r56
        L_0x00ea:
            r16 = r10 & 64
            if (r16 == 0) goto L_0x00f5
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r17
            r8 = r57
            goto L_0x010d
        L_0x00f5:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r11 & r17
            if (r17 != 0) goto L_0x010b
            r8 = r57
            boolean r17 = r9.changed((boolean) r8)
            if (r17 == 0) goto L_0x0106
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0108
        L_0x0106:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x0108:
            r1 = r1 | r17
            goto L_0x010d
        L_0x010b:
            r8 = r57
        L_0x010d:
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r11 & r17
            if (r17 != 0) goto L_0x0129
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x0122
            r0 = r58
            boolean r17 = r9.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x0124
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0126
        L_0x0122:
            r0 = r58
        L_0x0124:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0126:
            r1 = r1 | r17
            goto L_0x012b
        L_0x0129:
            r0 = r58
        L_0x012b:
            r0 = r10 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0136
            r17 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r17
            r3 = r59
            goto L_0x014e
        L_0x0136:
            r17 = 1879048192(0x70000000, float:1.58456325E29)
            r17 = r11 & r17
            if (r17 != 0) goto L_0x014c
            r3 = r59
            boolean r17 = r9.changed((java.lang.Object) r3)
            if (r17 == 0) goto L_0x0147
            r17 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0149
        L_0x0147:
            r17 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0149:
            r1 = r1 | r17
            goto L_0x014e
        L_0x014c:
            r3 = r59
        L_0x014e:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r1 & r17
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r5) goto L_0x0172
            boolean r3 = r9.getSkipping()
            if (r3 != 0) goto L_0x015f
            goto L_0x0172
        L_0x015f:
            r9.skipToGroupEnd()
            r16 = r54
            r17 = r55
            r21 = r58
            r39 = r59
            r20 = r1
            r18 = r7
            r19 = r8
            goto L_0x05e3
        L_0x0172:
            r9.startDefaults()
            r3 = r11 & 1
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r37 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            if (r3 == 0) goto L_0x019e
            boolean r3 = r9.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0186
            goto L_0x019e
        L_0x0186:
            r9.skipToGroupEnd()
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x018f
            r1 = r1 & r37
        L_0x018f:
            r16 = r55
            r6 = r59
            r5 = r1
            r17 = r7
            r18 = r8
            r8 = r54
            r7 = r58
            goto L_0x0232
        L_0x019e:
            if (r2 == 0) goto L_0x01a5
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x01a7
        L_0x01a5:
            r2 = r54
        L_0x01a7:
            if (r4 == 0) goto L_0x01ab
            r3 = 1
            goto L_0x01ad
        L_0x01ab:
            r3 = r55
        L_0x01ad:
            if (r6 == 0) goto L_0x01b1
            r4 = 0
            goto L_0x01b2
        L_0x01b1:
            r4 = r7
        L_0x01b2:
            if (r16 == 0) goto L_0x01b6
            r6 = 1
            goto L_0x01b7
        L_0x01b6:
            r6 = r8
        L_0x01b7:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x01d8
            androidx.compose.material3.NavigationBarItemDefaults r16 = androidx.compose.material3.NavigationBarItemDefaults.INSTANCE
            r32 = 12582912(0xc00000, float:1.7632415E-38)
            r33 = 127(0x7f, float:1.78E-43)
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = r9
            androidx.compose.material3.NavigationBarItemColors r7 = r16.m1863colors69fazGs(r17, r19, r21, r23, r25, r27, r29, r31, r32, r33)
            r1 = r1 & r37
            goto L_0x01da
        L_0x01d8:
            r7 = r58
        L_0x01da:
            if (r0 == 0) goto L_0x0225
            r0 = 0
            r8 = 0
            r9.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r5)
            r5 = 0
            r54 = r9
            r16 = 0
            r55 = r0
            java.lang.Object r0 = r54.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r56 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x020c
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r57 = r0
            r0 = r54
            r0.updateRememberedValue(r1)
            goto L_0x0212
        L_0x020c:
            r57 = r0
            r0 = r54
            r1 = r57
        L_0x0212:
            r9.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r5 = r56
            r8 = r2
            r16 = r3
            r17 = r4
            r18 = r6
            r6 = r0
            goto L_0x0232
        L_0x0225:
            r56 = r1
            r5 = r56
            r8 = r2
            r16 = r3
            r17 = r4
            r18 = r6
            r6 = r59
        L_0x0232:
            r9.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0244
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:159)"
            r2 = -663510974(0xffffffffd873a042, float:-1.07147851E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r5, r0, r1)
        L_0x0244:
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1 r4 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
            r0 = r4
            r1 = r7
            r2 = r51
            r3 = r16
            r10 = r4
            r4 = r5
            r19 = r5
            r11 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r5 = r17
            r20 = r6
            r6 = r18
            r21 = r7
            r7 = r53
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = -1419576100(0xffffffffab62fcdc, float:-8.064224E-13)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r0, r1, r10)
            r10 = r0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            if (r17 == 0) goto L_0x028c
            r2 = r17
            r3 = 0
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledLabel$1$1 r4 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledLabel$1$1
            r54 = r4
            r55 = r21
            r56 = r51
            r57 = r16
            r58 = r19
            r59 = r17
            r54.<init>(r55, r56, r57, r58, r59)
            r5 = 1644987592(0x620c84c8, float:6.48028E20)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r5, r1, r4)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r3 = r4
            goto L_0x028d
        L_0x028c:
            r3 = 0
        L_0x028d:
            r2 = 0
            r4 = r2
            r5 = 0
            r9.startReplaceableGroup(r11)
            java.lang.String r6 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r6)
            r6 = 0
            r7 = r9
            r11 = 0
            java.lang.Object r1 = r7.rememberedValue()
            r23 = 0
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r24.getEmpty()
            if (r1 != r0) goto L_0x02be
            r0 = 0
            r54 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            r55 = r1
            r1 = 0
            r2 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r1, r2, r1)
            r7.updateRememberedValue(r0)
            goto L_0x02c2
        L_0x02be:
            r55 = r1
            r0 = r55
        L_0x02c2:
            r9.endReplaceableGroup()
            r11 = r0
            androidx.compose.runtime.MutableState r11 = (androidx.compose.runtime.MutableState) r11
            androidx.compose.ui.semantics.Role$Companion r0 = androidx.compose.ui.semantics.Role.Companion
            int r0 = r0.m5168getTabo7Vup1c()
            androidx.compose.ui.semantics.Role r0 = androidx.compose.ui.semantics.Role.m5155boximpl(r0)
            r1 = 0
            r54 = r8
            r55 = r51
            r56 = r20
            r57 = r1
            r58 = r16
            r59 = r0
            r60 = r52
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.SelectableKt.m833selectableO2vRcR0(r54, r55, r56, r57, r58, r59, r60)
            r1 = 2
            r2 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            r54 = r50
            r55 = r0
            r56 = r4
            r57 = r5
            r58 = r1
            r59 = r2
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.RowScope.weight$default(r54, r55, r56, r57, r58, r59)
            r1 = 6
            r2 = r1
            r4 = 0
            r5 = 1157296644(0x44faf204, float:2007.563)
            r9.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r5)
            boolean r5 = r9.changed((java.lang.Object) r11)
            r6 = r9
            r7 = 0
            java.lang.Object r1 = r6.rememberedValue()
            r23 = 0
            if (r5 != 0) goto L_0x032d
            androidx.compose.runtime.Composer$Companion r26 = androidx.compose.runtime.Composer.Companion
            r55 = r2
            java.lang.Object r2 = r26.getEmpty()
            if (r1 != r2) goto L_0x032a
            goto L_0x032f
        L_0x032a:
            r56 = r1
            goto L_0x033e
        L_0x032d:
            r55 = r2
        L_0x032f:
            r2 = 0
            r56 = r1
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$1 r1 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$1
            r1.<init>(r11)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r6.updateRememberedValue(r1)
        L_0x033e:
            r9.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.OnRemeasuredModifierKt.onSizeChanged(r0, r1)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            r23 = r0
            r7 = r1
            r0 = 48
            r26 = r0
            r27 = 0
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r6 = 0
            int r0 = r26 >> 3
            r0 = r0 & 14
            int r1 = r26 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r7, r6, r9, r0)
            int r0 = r26 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r28 = r0
            r29 = 0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            r55 = r1
            java.lang.String r1 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r4, r1)
            java.lang.Object r30 = r9.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r2 = r30
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r30 = 6
            r31 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r4, r1)
            java.lang.Object r32 = r9.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r0 = r32
            androidx.compose.ui.unit.LayoutDirection r0 = (androidx.compose.ui.unit.LayoutDirection) r0
            androidx.compose.runtime.ProvidableCompositionLocal r30 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r4 = r30
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r30 = 6
            r31 = 0
            r56 = r6
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r6, r1)
            java.lang.Object r1 = r9.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r6 = r1
            androidx.compose.ui.platform.ViewConfiguration r6 = (androidx.compose.ui.platform.ViewConfiguration) r6
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r1 = r1.getConstructor()
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.materializerOf(r23)
            r57 = r7
            int r7 = r28 << 9
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r30 = 6
            r7 = r7 | 6
            r30 = r7
            r7 = r4
            r4 = r1
            r31 = 0
            androidx.compose.runtime.Applier r1 = r9.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x03fc
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03fc:
            r9.startReusableNode()
            boolean r1 = r9.getInserting()
            if (r1 == 0) goto L_0x0409
            r9.createNode(r4)
            goto L_0x040c
        L_0x0409:
            r9.useNode()
        L_0x040c:
            r9.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m2865constructorimpl(r9)
            r32 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r33 = androidx.compose.ui.node.ComposeUiNode.Companion
            r58 = r4
            kotlin.jvm.functions.Function2 r4 = r33.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r1, r5, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r1, r2, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r1, r0, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r1, r6, r4)
            r9.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r1)
            int r4 = r30 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r7.invoke(r1, r9, r4)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r1)
            int r1 = r30 >> 9
            r32 = r1 & 14
            r4 = r9
            r33 = 0
            r1 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r59 = r0
            java.lang.String r0 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r1, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r26 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r36 = 6
            r37 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r36 = r0
            r1 = r4
            r46 = 0
            r0 = 1035149591(0x3db32117, float:0.08746546)
            r60 = r2
            java.lang.String r2 = "C207@9285L145,*216@9714L7,223@10014L120,248@11007L285:NavigationBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r2)
            if (r14 == 0) goto L_0x0489
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x048a
        L_0x0489:
            r0 = 0
        L_0x048a:
            r38 = r0
            r0 = 100
            r54 = r4
            r24 = r5
            r2 = 0
            r4 = 0
            r5 = 6
            androidx.compose.animation.core.TweenSpec r0 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r0, r2, r4, r5, r4)
            r39 = r0
            androidx.compose.animation.core.AnimationSpec r39 = (androidx.compose.animation.core.AnimationSpec) r39
            r40 = 0
            r41 = 0
            r42 = 0
            r44 = 48
            r45 = 28
            r43 = r1
            androidx.compose.runtime.State r5 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r38, r39, r40, r41, r42, r43, r44, r45)
            r38 = 0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r2 = 0
            r4 = 0
            r40 = r2
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            r41 = r4
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r4, r2)
            java.lang.Object r2 = r1.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r0 = r2
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            r2 = 0
            androidx.compose.material3.tokens.NavigationBarTokens r4 = androidx.compose.material3.tokens.NavigationBarTokens.INSTANCE
            float r4 = r4.m2566getActiveIndicatorWidthD9Ej5fM()
            int r4 = r0.m5819roundToPx0680j_4(r4)
            int r40 = NavigationBarItem$lambda$3(r11)
            r55 = r2
            int r2 = r40 - r4
            float r2 = (float) r2
            r40 = r4
            r4 = 2
            float r4 = (float) r4
            float r2 = r2 / r4
            float r4 = IndicatorVerticalOffset
            float r4 = r0.m5825toPx0680j_4(r4)
            r35 = r11
            long r11 = androidx.compose.ui.geometry.OffsetKt.Offset(r2, r4)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            androidx.compose.ui.geometry.Offset r0 = androidx.compose.ui.geometry.Offset.m2992boximpl(r11)
            int r2 = r19 >> 27
            r2 = r2 & 14
            r4 = 0
            r55 = r2
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r1.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r20
            boolean r20 = r1.changed((java.lang.Object) r2)
            boolean r38 = r1.changed((java.lang.Object) r0)
            r20 = r20 | r38
            r38 = r1
            r39 = 0
            r40 = r0
            java.lang.Object r0 = r38.rememberedValue()
            r41 = 0
            if (r20 != 0) goto L_0x053a
            androidx.compose.runtime.Composer$Companion r42 = androidx.compose.runtime.Composer.Companion
            r43 = r4
            java.lang.Object r4 = r42.getEmpty()
            if (r0 != r4) goto L_0x0533
            goto L_0x053c
        L_0x0533:
            r42 = r0
            r45 = r2
            r2 = r38
            goto L_0x0553
        L_0x053a:
            r43 = r4
        L_0x053c:
            r4 = 0
            r42 = r0
            androidx.compose.material3.MappedInteractionSource r0 = new androidx.compose.material3.MappedInteractionSource
            r44 = r4
            r4 = r2
            androidx.compose.foundation.interaction.InteractionSource r4 = (androidx.compose.foundation.interaction.InteractionSource) r4
            r45 = r2
            r2 = 0
            r0.<init>(r4, r11, r2)
            r2 = r38
            r2.updateRememberedValue(r0)
        L_0x0553:
            r1.endReplaceableGroup()
            r4 = r0
            androidx.compose.material3.MappedInteractionSource r4 = (androidx.compose.material3.MappedInteractionSource) r4
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1 r0 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
            r0.<init>(r4)
            r2 = 691730997(0x293afa35, float:4.1517317E-14)
            r55 = r4
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r2, r4, r0)
            r20 = r0
            kotlin.jvm.functions.Function2 r20 = (kotlin.jvm.functions.Function2) r20
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1 r0 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
            r2 = r21
            r0.<init>(r2, r5)
            r2 = -474426875(0xffffffffe3b8d205, float:-6.818669E21)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r2, r4, r0)
            r22 = r0
            kotlin.jvm.functions.Function2 r22 = (kotlin.jvm.functions.Function2) r22
            float r25 = NavigationBarItem$lambda$9$lambda$6(r5)
            int r0 = r19 >> 9
            r0 = r0 & r34
            r4 = r0 | 438(0x1b6, float:6.14E-43)
            r34 = r59
            r0 = r20
            r38 = r1
            r1 = r22
            r40 = r60
            r39 = r45
            r2 = r10
            r42 = r54
            r43 = r55
            r41 = r58
            r44 = r4
            r4 = r18
            r45 = r5
            r5 = r25
            r25 = r56
            r47 = r6
            r6 = r38
            r48 = r57
            r49 = r7
            r7 = r44
            NavigationBarItemBaselineLayout(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r38)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r42)
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x05d9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x05d9:
            r20 = r19
            r19 = r18
            r18 = r17
            r17 = r16
            r16 = r8
        L_0x05e3:
            androidx.compose.runtime.ScopeUpdateScope r12 = r9.endRestartGroup()
            if (r12 != 0) goto L_0x05ec
            r23 = r9
            goto L_0x0615
        L_0x05ec:
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$4 r22 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$4
            r0 = r22
            r1 = r50
            r2 = r51
            r3 = r52
            r4 = r53
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r23 = r9
            r9 = r21
            r10 = r39
            r11 = r61
            r13 = r12
            r12 = r62
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r22
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0615:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.NavigationBarItem(androidx.compose.foundation.layout.RowScope, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.NavigationBarItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final int NavigationBarItem$lambda$3(MutableState<Integer> $itemWidth$delegate) {
        return ((Number) $itemWidth$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final void NavigationBarItem$lambda$4(MutableState<Integer> $itemWidth$delegate, int value) {
        $itemWidth$delegate.setValue(Integer.valueOf(value));
    }

    /* access modifiers changed from: private */
    public static final float NavigationBarItem$lambda$9$lambda$6(State<Float> $animationProgress$delegate) {
        return ((Number) $animationProgress$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final void NavigationBarItemBaselineLayout(Function2<? super Composer, ? super Integer, Unit> indicatorRipple, Function2<? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> label, boolean alwaysShowLabel, float animationProgress, Composer $composer, int $changed) {
        Composer $composer2;
        Function2<? super Composer, ? super Integer, Unit> function2 = indicatorRipple;
        Function2<? super Composer, ? super Integer, Unit> function22 = indicator;
        Function2<? super Composer, ? super Integer, Unit> function23 = icon;
        Function2<? super Composer, ? super Integer, Unit> function24 = label;
        boolean z = alwaysShowLabel;
        float f = animationProgress;
        int i = $changed;
        Composer $composer3 = $composer.startRestartGroup(591111291);
        ComposerKt.sourceInformation($composer3, "C(NavigationBarItemBaselineLayout)P(4,3,2,5)434@18867L2465:NavigationBar.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer3.changedInstance(function23) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer3.changedInstance(function24) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            $dirty |= $composer3.changed(z) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            $dirty |= $composer3.changed(f) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(591111291, $dirty2, -1, "androidx.compose.material3.NavigationBarItemBaselineLayout (NavigationBar.kt:426)");
            }
            MeasurePolicy measurePolicy$iv = new NavigationBarKt$NavigationBarItemBaselineLayout$2(f, function24, z);
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2865constructorimpl($composer3);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            materializerOf.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int $changed2 = ($changed$iv$iv >> 9) & 14;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Density density = density$iv;
            Composer $composer4 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer4, -311734425, "C435@18884L17,440@18982L50:NavigationBar.kt#uh7d8r");
            function2.invoke($composer4, Integer.valueOf($dirty2 & 14));
            $composer4.startReplaceableGroup(-311734399);
            ComposerKt.sourceInformation($composer4, "437@18951L11");
            if (f > 0.0f) {
                function22.invoke($composer4, Integer.valueOf(($dirty2 >> 3) & 14));
            }
            $composer4.endReplaceableGroup();
            Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.Companion, IconLayoutIdTag);
            LayoutDirection layoutDirection = layoutDirection$iv;
            $composer4.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            ViewConfiguration viewConfiguration = viewConfiguration$iv;
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            int i2 = $changed2;
            int i3 = $changed$iv$iv;
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            Alignment alignment = contentAlignment$iv;
            $composer4.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Density density$iv$iv = (Density) consume4;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv2);
            Modifier modifier2 = modifier$iv2;
            int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = materializerOf2;
            $composer2 = $composer3;
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                $composer4.createNode(constructor2);
            } else {
                $composer4.useNode();
            }
            $composer4.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2865constructorimpl($composer4);
            Function0<ComposeUiNode> function02 = constructor2;
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer4.enableReusing();
            Density density2 = density$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
            function33.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer4.startReplaceableGroup(2058660585);
            int i4 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer4;
            int i5 = $changed$iv$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = function33;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            int i6 = ((6 >> 6) & 112) | 6;
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            MeasurePolicy measurePolicy2 = measurePolicy$iv2;
            Composer $composer5 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer5, 1248851348, "C440@19024L6:NavigationBar.kt#uh7d8r");
            function23.invoke($composer5, Integer.valueOf(($dirty2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer4.endReplaceableGroup();
            $composer4.endNode();
            $composer4.endReplaceableGroup();
            $composer4.endReplaceableGroup();
            $composer4.startReplaceableGroup(1204551908);
            ComposerKt.sourceInformation($composer4, "443@19075L260");
            if (function24 != null) {
                Modifier modifier$iv3 = PaddingKt.m540paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.Companion, LabelLayoutIdTag), z ? 1.0f : animationProgress), Dp.m5844constructorimpl(NavigationBarItemHorizontalPadding / ((float) 2)), 0.0f, 2, (Object) null);
                $composer4.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                Alignment alignment2 = contentAlignment$iv2;
                $composer4.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume7 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Density density$iv$iv2 = (Density) consume7;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume8 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume8;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume9 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume9;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv3);
                Modifier modifier3 = modifier$iv3;
                int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    $composer4.createNode(constructor3);
                } else {
                    $composer4.useNode();
                }
                $composer4.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2865constructorimpl($composer4);
                Function0<ComposeUiNode> function03 = constructor3;
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer4.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer4.startReplaceableGroup(2058660585);
                int i7 = ($changed$iv$iv$iv2 >> 9) & 14;
                Composer $composer$iv2 = $composer4;
                int i8 = $changed$iv$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                int i9 = ((0 >> 6) & 112) | 6;
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                Density density3 = density$iv$iv2;
                Composer $composer6 = $composer$iv2;
                ComposerKt.sourceInformationMarkerStart($composer6, 1248851650, "C448@19326L7:NavigationBar.kt#uh7d8r");
                function24.invoke($composer6, Integer.valueOf(($dirty2 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer4.endReplaceableGroup();
                $composer4.endNode();
                $composer4.endReplaceableGroup();
                $composer4.endReplaceableGroup();
            }
            $composer4.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i10 = $dirty2;
            return;
        }
        int i11 = $dirty2;
        endRestartGroup.updateScope(new NavigationBarKt$NavigationBarItemBaselineLayout$3(indicatorRipple, indicator, icon, label, alwaysShowLabel, animationProgress, $changed));
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4  reason: not valid java name */
    public static final MeasureResult m1868placeIconX9ElhV4(MeasureScope $this$placeIcon_u2dX9ElhV4, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints) {
        int width = Constraints.m5788getMaxWidthimpl(constraints);
        int height = Constraints.m5787getMaxHeightimpl(constraints);
        return MeasureScope.layout$default($this$placeIcon_u2dX9ElhV4, width, height, (Map) null, new NavigationBarKt$placeIcon$1(indicatorPlaceable, iconPlaceable, (width - iconPlaceable.getWidth()) / 2, (height - iconPlaceable.getHeight()) / 2, indicatorRipplePlaceable, (width - indicatorRipplePlaceable.getWidth()) / 2, (height - indicatorRipplePlaceable.getHeight()) / 2, width, height), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-zUg2_y0  reason: not valid java name */
    public static final MeasureResult m1869placeLabelAndIconzUg2_y0(MeasureScope $this$placeLabelAndIcon_u2dzUg2_y0, Placeable labelPlaceable, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints, boolean alwaysShowLabel, float animationProgress) {
        MeasureScope measureScope = $this$placeLabelAndIcon_u2dzUg2_y0;
        int height = Constraints.m5787getMaxHeightimpl(constraints);
        float f = NavigationBarItemVerticalPadding;
        int labelY = (height - labelPlaceable.getHeight()) - measureScope.m5819roundToPx0680j_4(f);
        int selectedIconY = measureScope.m5819roundToPx0680j_4(f);
        int iconDistance = (alwaysShowLabel ? selectedIconY : (height - iconPlaceable.getHeight()) / 2) - selectedIconY;
        int offset = MathKt.roundToInt(((float) iconDistance) * (((float) 1) - animationProgress));
        int containerWidth = Constraints.m5788getMaxWidthimpl(constraints);
        int i = iconDistance;
        return MeasureScope.layout$default($this$placeLabelAndIcon_u2dzUg2_y0, containerWidth, height, (Map) null, new NavigationBarKt$placeLabelAndIcon$1(indicatorPlaceable, alwaysShowLabel, animationProgress, labelPlaceable, (containerWidth - labelPlaceable.getWidth()) / 2, labelY, offset, iconPlaceable, (containerWidth - iconPlaceable.getWidth()) / 2, selectedIconY, indicatorRipplePlaceable, (containerWidth - indicatorRipplePlaceable.getWidth()) / 2, selectedIconY - measureScope.m5819roundToPx0680j_4(IndicatorVerticalPadding), containerWidth, $this$placeLabelAndIcon_u2dzUg2_y0), 4, (Object) null);
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarItemHorizontalPadding;
    }

    public static final float getNavigationBarItemVerticalPadding() {
        return NavigationBarItemVerticalPadding;
    }
}

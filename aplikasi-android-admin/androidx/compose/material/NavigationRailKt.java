package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a}\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012 \b\u0002\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0001\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001f2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\f0\u001f¢\u0006\u0002\b\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u001d2\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f¢\u0006\u0002\b\u00162\b\b\u0002\u0010#\u001a\u00020\u001d2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u0010H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a=\u0010*\u001a\u00020\f2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\f0\u001f¢\u0006\u0002\b\u00162\u0013\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f¢\u0006\u0002\b\u00162\u0006\u0010+\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010,\u001aU\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2&\u0010\u0018\u001a\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a)\u00105\u001a\u000206*\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a9\u0010>\u001a\u000206*\u0002072\u0006\u0010?\u001a\u0002092\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010+\u001a\u00020\u0007H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006B²\u0006\n\u00102\u001a\u00020\u0007X\u0002"}, d2 = {"HeaderPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ItemIconTopOffset", "ItemLabelBaselineBottomOffset", "NavigationRailAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "NavigationRailItemCompactSize", "NavigationRailItemSize", "NavigationRailPadding", "NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "NavigationRail-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "NavigationRailItem-0S3VyRs", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "NavigationRailItemBaselineLayout", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "NavigationRailTransition", "activeColor", "inactiveColor", "Lkotlin/ParameterName;", "name", "animationProgress", "NavigationRailTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationRail.kt */
public final class NavigationRailKt {
    /* access modifiers changed from: private */
    public static final float HeaderPadding = Dp.m7554constructorimpl((float) 8);
    private static final float ItemIconTopOffset = Dp.m7554constructorimpl((float) 14);
    private static final float ItemLabelBaselineBottomOffset = Dp.m7554constructorimpl((float) 16);
    private static final TweenSpec<Float> NavigationRailAnimationSpec = new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing(), 2, (DefaultConstructorMarker) null);
    private static final float NavigationRailItemCompactSize = Dp.m7554constructorimpl((float) 56);
    private static final float NavigationRailItemSize = Dp.m7554constructorimpl((float) 72);
    /* access modifiers changed from: private */
    public static final float NavigationRailPadding = Dp.m7554constructorimpl((float) 8);

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e2  */
    /* renamed from: NavigationRail-HsRjFd4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m3063NavigationRailHsRjFd4(androidx.compose.ui.Modifier r25, long r26, long r28, float r30, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r11 = r32
            r12 = r34
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1790971523(0x6ac00e83, float:1.1609114E26)
            r1 = r33
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(NavigationRail)P(5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp,4)94@4333L6,95@4375L32,100@4577L552:NavigationRail.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r34
            r2 = r35 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r25
            goto L_0x0035
        L_0x0022:
            r3 = r12 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r25
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
            r3 = r25
        L_0x0035:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r35 & 2
            if (r4 != 0) goto L_0x0048
            r4 = r26
            boolean r6 = r10.changed((long) r4)
            if (r6 == 0) goto L_0x004a
            r6 = 32
            goto L_0x004c
        L_0x0048:
            r4 = r26
        L_0x004a:
            r6 = 16
        L_0x004c:
            r1 = r1 | r6
            goto L_0x0050
        L_0x004e:
            r4 = r26
        L_0x0050:
            r6 = r12 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0069
            r6 = r35 & 4
            if (r6 != 0) goto L_0x0063
            r6 = r28
            boolean r8 = r10.changed((long) r6)
            if (r8 == 0) goto L_0x0065
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0063:
            r6 = r28
        L_0x0065:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r8
            goto L_0x006b
        L_0x0069:
            r6 = r28
        L_0x006b:
            r8 = r35 & 8
            if (r8 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r9 = r30
            goto L_0x0089
        L_0x0074:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0087
            r9 = r30
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
            r9 = r30
        L_0x0089:
            r13 = r35 & 16
            if (r13 == 0) goto L_0x0092
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r31
            goto L_0x00a9
        L_0x0092:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r12
            if (r14 != 0) goto L_0x00a7
            r14 = r31
            boolean r15 = r10.changedInstance(r14)
            if (r15 == 0) goto L_0x00a3
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r1 = r1 | r15
            goto L_0x00a9
        L_0x00a7:
            r14 = r31
        L_0x00a9:
            r15 = r35 & 32
            r16 = 458752(0x70000, float:6.42848E-40)
            if (r15 == 0) goto L_0x00b3
            r15 = 196608(0x30000, float:2.75506E-40)
        L_0x00b1:
            r1 = r1 | r15
            goto L_0x00c3
        L_0x00b3:
            r15 = r12 & r16
            if (r15 != 0) goto L_0x00c3
            boolean r15 = r10.changedInstance(r11)
            if (r15 == 0) goto L_0x00c0
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00c0:
            r15 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b1
        L_0x00c3:
            r15 = 374491(0x5b6db, float:5.24774E-40)
            r15 = r15 & r1
            r0 = 74898(0x12492, float:1.04954E-40)
            if (r15 != r0) goto L_0x00e2
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x00d3
            goto L_0x00e2
        L_0x00d3:
            r10.skipToGroupEnd()
            r20 = r1
            r13 = r3
            r16 = r6
            r18 = r9
            r19 = r14
            r14 = r4
            goto L_0x019f
        L_0x00e2:
            r10.startDefaults()
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0108
            boolean r0 = r10.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00f0
            goto L_0x0108
        L_0x00f0:
            r10.skipToGroupEnd()
            r0 = r35 & 2
            if (r0 == 0) goto L_0x00f9
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00f9:
            r0 = r35 & 4
            if (r0 == 0) goto L_0x0104
            r0 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r1 = r0
            r0 = r3
            r2 = r4
            r4 = r14
            goto L_0x0140
        L_0x0104:
            r0 = r3
            r2 = r4
            r4 = r14
            goto L_0x0140
        L_0x0108:
            if (r2 == 0) goto L_0x010f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0110
        L_0x010f:
            r0 = r3
        L_0x0110:
            r2 = r35 & 2
            if (r2 == 0) goto L_0x0122
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r3 = 6
            androidx.compose.material.Colors r2 = r2.getColors(r10, r3)
            long r2 = r2.m2955getSurface0d7_KjU()
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0123
        L_0x0122:
            r2 = r4
        L_0x0123:
            r4 = r35 & 4
            if (r4 == 0) goto L_0x0132
            int r4 = r1 >> 3
            r4 = r4 & 14
            long r4 = androidx.compose.material.ColorsKt.m2969contentColorForek8zF_U(r2, r10, r4)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r6 = r4
        L_0x0132:
            if (r8 == 0) goto L_0x013b
            androidx.compose.material.NavigationRailDefaults r4 = androidx.compose.material.NavigationRailDefaults.INSTANCE
            float r4 = r4.m3062getElevationD9Ej5fM()
            r9 = r4
        L_0x013b:
            if (r13 == 0) goto L_0x013f
            r4 = 0
            goto L_0x0140
        L_0x013f:
            r4 = r14
        L_0x0140:
            r10.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0152
            r5 = -1
            java.lang.String r8 = "androidx.compose.material.NavigationRail (NavigationRail.kt:92)"
            r13 = 1790971523(0x6ac00e83, float:1.1609114E26)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r1, r5, r8)
        L_0x0152:
            androidx.compose.material.NavigationRailKt$NavigationRail$1 r5 = new androidx.compose.material.NavigationRailKt$NavigationRail$1
            r5.<init>(r4, r1, r11)
            r8 = -1571506489(0xffffffffa254b6c7, float:-2.882812E-18)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r8, r13, r5)
            r21 = r5
            kotlin.jvm.functions.Function2 r21 = (kotlin.jvm.functions.Function2) r21
            r5 = r1 & 14
            r8 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 | r8
            int r8 = r1 << 3
            r8 = r8 & 896(0x380, float:1.256E-42)
            r5 = r5 | r8
            int r8 = r1 << 3
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | r8
            int r8 = r1 << 6
            r8 = r8 & r16
            r23 = r5 | r8
            r14 = 0
            r19 = 0
            r24 = 18
            r13 = r0
            r15 = r2
            r17 = r6
            r20 = r9
            r22 = r10
            androidx.compose.material.SurfaceKt.m3130SurfaceFjzlyU(r13, r14, r15, r17, r19, r20, r21, r22, r23, r24)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0195
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0195:
            r13 = r0
            r20 = r1
            r14 = r2
            r19 = r4
            r16 = r6
            r18 = r9
        L_0x019f:
            androidx.compose.runtime.ScopeUpdateScope r9 = r10.endRestartGroup()
            if (r9 != 0) goto L_0x01a8
            r22 = r10
            goto L_0x01c7
        L_0x01a8:
            androidx.compose.material.NavigationRailKt$NavigationRail$2 r21 = new androidx.compose.material.NavigationRailKt$NavigationRail$2
            r0 = r21
            r1 = r13
            r2 = r14
            r4 = r16
            r6 = r18
            r7 = r19
            r8 = r32
            r11 = r9
            r9 = r34
            r22 = r10
            r10 = r35
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10)
            r0 = r21
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x01c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.NavigationRailKt.m3063NavigationRailHsRjFd4(androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:176:0x0467  */
    /* renamed from: NavigationRailItem-0S3VyRs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m3064NavigationRailItem0S3VyRs(boolean r38, kotlin.jvm.functions.Function0<kotlin.Unit> r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.ui.Modifier r41, boolean r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, boolean r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, long r46, long r48, androidx.compose.runtime.Composer r50, int r51, int r52) {
        /*
            r15 = r39
            r14 = r40
            r13 = r51
            r11 = r52
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "icon"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -1813548445(0xffffffff93e77263, float:-5.8425392E-27)
            r1 = r50
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(NavigationRailItem)P(7,6,2,5,1,4!2,8:c#ui.graphics.Color,9:c#ui.graphics.Color)154@6931L39,155@7020L6,156@7090L7,156@7124L6,171@7922L83,175@8010L791:NavigationRail.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r51
            r2 = r11 & 1
            if (r2 == 0) goto L_0x002d
            r1 = r1 | 6
            r9 = r38
            goto L_0x0040
        L_0x002d:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x003e
            r9 = r38
            boolean r2 = r12.changed((boolean) r9)
            if (r2 == 0) goto L_0x003b
            r2 = 4
            goto L_0x003c
        L_0x003b:
            r2 = 2
        L_0x003c:
            r1 = r1 | r2
            goto L_0x0040
        L_0x003e:
            r9 = r38
        L_0x0040:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x0047
            r1 = r1 | 48
            goto L_0x0057
        L_0x0047:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0057
            boolean r2 = r12.changedInstance(r15)
            if (r2 == 0) goto L_0x0054
            r2 = 32
            goto L_0x0056
        L_0x0054:
            r2 = 16
        L_0x0056:
            r1 = r1 | r2
        L_0x0057:
            r2 = r11 & 4
            if (r2 == 0) goto L_0x005e
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x006e
        L_0x005e:
            r2 = r13 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x006e
            boolean r2 = r12.changedInstance(r14)
            if (r2 == 0) goto L_0x006b
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x006d
        L_0x006b:
            r2 = 128(0x80, float:1.794E-43)
        L_0x006d:
            r1 = r1 | r2
        L_0x006e:
            r2 = r11 & 8
            if (r2 == 0) goto L_0x0077
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r3 = r41
            goto L_0x008c
        L_0x0077:
            r3 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x008a
            r3 = r41
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0086
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0088
        L_0x0086:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x0088:
            r1 = r1 | r4
            goto L_0x008c
        L_0x008a:
            r3 = r41
        L_0x008c:
            r4 = r11 & 16
            if (r4 == 0) goto L_0x0095
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r5 = r42
            goto L_0x00ac
        L_0x0095:
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r13
            if (r5 != 0) goto L_0x00aa
            r5 = r42
            boolean r6 = r12.changed((boolean) r5)
            if (r6 == 0) goto L_0x00a6
            r6 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a8
        L_0x00a6:
            r6 = 8192(0x2000, float:1.14794E-41)
        L_0x00a8:
            r1 = r1 | r6
            goto L_0x00ac
        L_0x00aa:
            r5 = r42
        L_0x00ac:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x00b6
            r7 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r7
            r7 = r43
            goto L_0x00cc
        L_0x00b6:
            r7 = 458752(0x70000, float:6.42848E-40)
            r7 = r7 & r13
            if (r7 != 0) goto L_0x00ca
            r7 = r43
            boolean r8 = r12.changedInstance(r7)
            if (r8 == 0) goto L_0x00c6
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c8
        L_0x00c6:
            r8 = 65536(0x10000, float:9.18355E-41)
        L_0x00c8:
            r1 = r1 | r8
            goto L_0x00cc
        L_0x00ca:
            r7 = r43
        L_0x00cc:
            r8 = r11 & 64
            if (r8 == 0) goto L_0x00d6
            r10 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r10
            r10 = r44
            goto L_0x00ed
        L_0x00d6:
            r10 = 3670016(0x380000, float:5.142788E-39)
            r10 = r10 & r13
            if (r10 != 0) goto L_0x00eb
            r10 = r44
            boolean r16 = r12.changed((boolean) r10)
            if (r16 == 0) goto L_0x00e6
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e8
        L_0x00e6:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e8:
            r1 = r1 | r16
            goto L_0x00ed
        L_0x00eb:
            r10 = r44
        L_0x00ed:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00f8
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r17
            r3 = r45
            goto L_0x0110
        L_0x00f8:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r13 & r17
            if (r17 != 0) goto L_0x010e
            r3 = r45
            boolean r17 = r12.changed((java.lang.Object) r3)
            if (r17 == 0) goto L_0x0109
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010b
        L_0x0109:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x010b:
            r1 = r1 | r17
            goto L_0x0110
        L_0x010e:
            r3 = r45
        L_0x0110:
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r13 & r17
            if (r17 != 0) goto L_0x012b
            r3 = r11 & 256(0x100, float:3.59E-43)
            if (r3 != 0) goto L_0x0125
            r9 = r46
            boolean r3 = r12.changed((long) r9)
            if (r3 == 0) goto L_0x0127
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0129
        L_0x0125:
            r9 = r46
        L_0x0127:
            r3 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0129:
            r1 = r1 | r3
            goto L_0x012d
        L_0x012b:
            r9 = r46
        L_0x012d:
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r13
            if (r3 != 0) goto L_0x0147
            r3 = r11 & 512(0x200, float:7.175E-43)
            if (r3 != 0) goto L_0x0141
            r9 = r48
            boolean r3 = r12.changed((long) r9)
            if (r3 == 0) goto L_0x0143
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0145
        L_0x0141:
            r9 = r48
        L_0x0143:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0145:
            r1 = r1 | r3
            goto L_0x0149
        L_0x0147:
            r9 = r48
        L_0x0149:
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r3 & r1
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r5) goto L_0x016e
            boolean r3 = r12.getSkipping()
            if (r3 != 0) goto L_0x0159
            goto L_0x016e
        L_0x0159:
            r12.skipToGroupEnd()
            r21 = r41
            r16 = r42
            r17 = r44
            r18 = r45
            r19 = r46
            r22 = r1
            r23 = r7
            r24 = r9
            goto L_0x0474
        L_0x016e:
            r12.startDefaults()
            r3 = r13 & 1
            r17 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            if (r3 == 0) goto L_0x01ac
            boolean r3 = r12.getDefaultsInvalid()
            if (r3 == 0) goto L_0x017f
            goto L_0x01ac
        L_0x017f:
            r12.skipToGroupEnd()
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0188
            r1 = r1 & r17
        L_0x0188:
            r0 = r11 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x019e
            r0 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r0 = r0 & r1
            r21 = r41
            r6 = r44
            r1 = r45
            r2 = r0
            r4 = r7
            r0 = r42
            r7 = r46
            goto L_0x026d
        L_0x019e:
            r21 = r41
            r0 = r42
            r6 = r44
            r2 = r1
            r4 = r7
            r1 = r45
            r7 = r46
            goto L_0x026d
        L_0x01ac:
            if (r2 == 0) goto L_0x01b3
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x01b5
        L_0x01b3:
            r2 = r41
        L_0x01b5:
            if (r4 == 0) goto L_0x01b9
            r3 = 1
            goto L_0x01bb
        L_0x01b9:
            r3 = r42
        L_0x01bb:
            if (r6 == 0) goto L_0x01bf
            r4 = 0
            goto L_0x01c0
        L_0x01bf:
            r4 = r7
        L_0x01c0:
            if (r8 == 0) goto L_0x01c4
            r6 = 1
            goto L_0x01c6
        L_0x01c4:
            r6 = r44
        L_0x01c6:
            if (r0 == 0) goto L_0x0206
            r0 = 0
            r7 = 0
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r8)
            r8 = 0
            r41 = r12
            r18 = 0
            java.lang.Object r5 = r41.rememberedValue()
            r20 = 0
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r42 = r0
            java.lang.Object r0 = r21.getEmpty()
            if (r5 != r0) goto L_0x01f9
            r0 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r21 = r2
            r2 = r41
            r2.updateRememberedValue(r0)
            goto L_0x01fe
        L_0x01f9:
            r21 = r2
            r2 = r41
            r0 = r5
        L_0x01fe:
            r12.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x020a
        L_0x0206:
            r21 = r2
            r0 = r45
        L_0x020a:
            r2 = r11 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x021c
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r5 = 6
            androidx.compose.material.Colors r2 = r2.getColors(r12, r5)
            long r7 = r2.m2951getPrimary0d7_KjU()
            r1 = r1 & r17
            goto L_0x021e
        L_0x021c:
            r7 = r46
        L_0x021e:
            r2 = r11 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0264
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r5 = 6
            r17 = 0
            r41 = r0
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            r42 = r3
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r3)
            java.lang.Object r0 = r12.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r22 = r0.m4973unboximpl()
            androidx.compose.material.ContentAlpha r0 = androidx.compose.material.ContentAlpha.INSTANCE
            r2 = 6
            float r24 = r0.getMedium(r12, r2)
            r28 = 14
            r29 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            long r2 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r22, r24, r25, r26, r27, r28, r29)
            r0 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r0 = r0 & r1
            r1 = r41
            r9 = r2
            r2 = r0
            r0 = r42
            goto L_0x026d
        L_0x0264:
            r41 = r0
            r42 = r3
            r0 = r42
            r2 = r1
            r1 = r41
        L_0x026d:
            r12.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x027f
            r3 = -1
            java.lang.String r5 = "androidx.compose.material.NavigationRailItem (NavigationRail.kt:146)"
            r11 = -1813548445(0xffffffff93e77263, float:-5.8425392E-27)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r2, r3, r5)
        L_0x027f:
            if (r4 == 0) goto L_0x0297
            r5 = r4
            r11 = 0
            androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1 r3 = new androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
            r3.<init>(r4, r2)
            r41 = r5
            r5 = -180398615(0xfffffffff53f55e9, float:-2.4254667E32)
            r42 = r11
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r5, r11, r3)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            goto L_0x0298
        L_0x0297:
            r3 = 0
        L_0x0298:
            if (r4 != 0) goto L_0x029d
            float r5 = NavigationRailItemCompactSize
            goto L_0x029f
        L_0x029d:
            float r5 = NavigationRailItemSize
        L_0x029f:
            int r11 = r2 >> 18
            r11 = r11 & 896(0x380, float:1.256E-42)
            r16 = 6
            r11 = r11 | 6
            r16 = 0
            r17 = 0
            r18 = 2
            r41 = r16
            r42 = r17
            r43 = r7
            r45 = r12
            r46 = r11
            r47 = r18
            androidx.compose.foundation.Indication r11 = androidx.compose.material.ripple.RippleKt.m3233rememberRipple9IZ8Weo(r41, r42, r43, r45, r46, r47)
            androidx.compose.ui.semantics.Role$Companion r16 = androidx.compose.ui.semantics.Role.Companion
            int r16 = r16.m6878getTabo7Vup1c()
            androidx.compose.ui.semantics.Role r16 = androidx.compose.ui.semantics.Role.m6865boximpl(r16)
            r41 = r21
            r42 = r38
            r43 = r1
            r44 = r11
            r45 = r0
            r46 = r16
            r47 = r39
            r49 = r0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.SelectableKt.m2543selectableO2vRcR0(r41, r42, r43, r44, r45, r46, r47)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m2322size3ABfNKs(r0, r5)
            androidx.compose.ui.Alignment$Companion r16 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r16 = r16.getCenter()
            r17 = 48
            r50 = r16
            r16 = 0
            r18 = r1
            r1 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r12.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = 0
            int r20 = r17 >> 3
            r20 = r20 & 14
            int r22 = r17 >> 3
            r22 = r22 & 112(0x70, float:1.57E-43)
            r23 = r4
            r4 = r20 | r22
            r20 = r5
            r5 = r50
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r1, r12, r4)
            int r22 = r17 << 3
            r22 = r22 & 112(0x70, float:1.57E-43)
            r24 = 0
            r50 = r1
            r1 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = 0
            int r1 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r12, r1)
            r25 = r5
            androidx.compose.runtime.CompositionLocalMap r5 = r12.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r26 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r26 = r26.getConstructor()
            kotlin.jvm.functions.Function3 r27 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            r28 = r0
            int r0 = r22 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r19 = 6
            r0 = r0 | 6
            r29 = r26
            r26 = r27
            r27 = 0
            r30 = r11
            androidx.compose.runtime.Applier r11 = r12.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x035b
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x035b:
            r12.startReusableNode()
            boolean r11 = r12.getInserting()
            if (r11 == 0) goto L_0x036a
            r11 = r29
            r12.createNode(r11)
            goto L_0x036f
        L_0x036a:
            r11 = r29
            r12.useNode()
        L_0x036f:
            r29 = r11
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m4575constructorimpl(r12)
            r31 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r32 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r32.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r4, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r5, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetCompositeKeyHash()
            r32 = 0
            r41 = r11
            r33 = 0
            boolean r34 = r41.getInserting()
            if (r34 != 0) goto L_0x03b1
            r34 = r4
            java.lang.Object r4 = r41.rememberedValue()
            r35 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x03ae
            goto L_0x03b5
        L_0x03ae:
            r5 = r41
            goto L_0x03c5
        L_0x03b1:
            r34 = r4
            r35 = r5
        L_0x03b5:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            r5 = r41
            r5.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            r11.apply(r4, r13)
        L_0x03c5:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r4)
            int r5 = r0 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r11 = r26
            r11.invoke(r4, r12, r5)
            r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r4)
            int r4 = r0 >> 9
            r4 = r4 & 14
            r5 = r12
            r13 = 0
            r26 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r31 = r1
            java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r17 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r19 = 6
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r19 = r5
            r32 = 0
            r33 = r0
            r0 = -1714406692(0xffffffff99d03adc, float:-2.1530469E-23)
            r36 = r1
            java.lang.String r1 = "C187@8378L417:NavigationRail.kt#jmzs0o"
            r37 = r4
            r4 = r19
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r1)
            androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1 r0 = new androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
            r0.<init>(r6, r14, r3, r2)
            r1 = 670576792(0x27f83098, float:6.8886513E-15)
            r19 = r3
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r4, r1, r3, r0)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            int r1 = r2 >> 24
            r1 = r1 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            int r3 = r2 >> 24
            r3 = r3 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            int r3 = r2 << 6
            r3 = r3 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            r41 = r7
            r43 = r9
            r45 = r38
            r46 = r0
            r47 = r4
            r48 = r1
            m3065NavigationRailTransitionKlgxPg(r41, r43, r45, r46, r47, r48)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r12.endReplaceableGroup()
            r12.endNode()
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x046a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x046a:
            r16 = r49
            r22 = r2
            r17 = r6
            r19 = r7
            r24 = r9
        L_0x0474:
            androidx.compose.runtime.ScopeUpdateScope r13 = r12.endRestartGroup()
            if (r13 != 0) goto L_0x047d
            r27 = r12
            goto L_0x04a6
        L_0x047d:
            androidx.compose.material.NavigationRailKt$NavigationRailItem$3 r26 = new androidx.compose.material.NavigationRailKt$NavigationRailItem$3
            r0 = r26
            r1 = r38
            r2 = r39
            r3 = r40
            r4 = r21
            r5 = r16
            r6 = r23
            r7 = r17
            r8 = r18
            r9 = r19
            r27 = r12
            r11 = r24
            r15 = r13
            r13 = r51
            r14 = r52
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14)
            r0 = r26
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x04a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.NavigationRailKt.m3064NavigationRailItem0S3VyRs(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: NavigationRailTransition-Klgx-Pg  reason: not valid java name */
    public static final void m3065NavigationRailTransitionKlgxPg(long activeColor, long inactiveColor, boolean selected, Function3<? super Float, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        long j = activeColor;
        long j2 = inactiveColor;
        boolean z = selected;
        Function3<? super Float, ? super Composer, ? super Integer, Unit> function3 = content;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-207161906);
        ComposerKt.sourceInformation($composer2, "C(NavigationRailTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)232@9909L126,239@10110L181:NavigationRail.kt#jmzs0o");
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
                ComposerKt.traceEventStart(-207161906, $dirty2, -1, "androidx.compose.material.NavigationRailTransition (NavigationRail.kt:226)");
            }
            State animationProgress$delegate = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, NavigationRailAnimationSpec, 0.0f, (String) null, (Function1<? super Float, Unit>) null, $composer2, 48, 28);
            long color = ColorKt.m5014lerpjxsXWHM(j2, j, NavigationRailTransition_Klgx_Pg$lambda$3(animationProgress$delegate));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4953boximpl(Color.m4962copywmQWz5c$default(color, 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4965getAlphaimpl(color)))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, -1688205042, true, new NavigationRailKt$NavigationRailTransition$1(function3, $dirty2, animationProgress$delegate)), $composer2, 56);
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
        endRestartGroup.updateScope(new NavigationRailKt$NavigationRailTransition$2(activeColor, inactiveColor, selected, content, $changed));
    }

    /* access modifiers changed from: private */
    public static final float NavigationRailTransition_Klgx_Pg$lambda$3(State<Float> $animationProgress$delegate) {
        return ((Number) $animationProgress$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x03fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavigationRailItemBaselineLayout(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, float r51, androidx.compose.runtime.Composer r52, int r53) {
        /*
            r0 = r49
            r1 = r50
            r2 = r51
            r3 = r53
            r4 = -1903861684(0xffffffff8e85604c, float:-3.2879762E-30)
            r5 = r52
            androidx.compose.runtime.Composer r5 = r5.startRestartGroup(r4)
            java.lang.String r6 = "C(NavigationRailItemBaselineLayout)P(!1,2)264@10960L1118:NavigationRail.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            r6 = r53
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
            r8 = 146(0x92, float:2.05E-43)
            if (r7 != r8) goto L_0x0058
            boolean r7 = r5.getSkipping()
            if (r7 != 0) goto L_0x0053
            goto L_0x0058
        L_0x0053:
            r5.skipToGroupEnd()
            goto L_0x03ff
        L_0x0058:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0064
            r7 = -1
            java.lang.String r8 = "androidx.compose.material.NavigationRailItemBaselineLayout (NavigationRail.kt:258)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r6, r7, r8)
        L_0x0064:
            androidx.compose.material.NavigationRailKt$NavigationRailItemBaselineLayout$2 r4 = new androidx.compose.material.NavigationRailKt$NavigationRailItemBaselineLayout$2
            r4.<init>(r1, r2)
            androidx.compose.ui.layout.MeasurePolicy r4 = (androidx.compose.ui.layout.MeasurePolicy) r4
            r7 = 0
            r8 = r7
            r9 = 0
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r10)
            java.lang.String r11 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r11)
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            int r13 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r5, r7)
            androidx.compose.runtime.CompositionLocalMap r14 = r5.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r16 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r12)
            int r7 = r8 << 9
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | 6
            r17 = r16
            r16 = 0
            androidx.compose.runtime.Applier r10 = r5.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x00a5
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00a5:
            r5.startReusableNode()
            boolean r10 = r5.getInserting()
            if (r10 == 0) goto L_0x00b2
            r5.createNode(r15)
            goto L_0x00b5
        L_0x00b2:
            r5.useNode()
        L_0x00b5:
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m4575constructorimpl(r5)
            r19 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
            r21 = r8
            kotlin.jvm.functions.Function2 r8 = r20.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r4, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r14, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetCompositeKeyHash()
            r20 = 0
            r22 = r10
            r23 = 0
            boolean r24 = r22.getInserting()
            if (r24 != 0) goto L_0x00f7
            r24 = r4
            java.lang.Object r4 = r22.rememberedValue()
            r25 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r13)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r9)
            if (r4 != 0) goto L_0x00f4
            goto L_0x00fb
        L_0x00f4:
            r9 = r22
            goto L_0x010b
        L_0x00f7:
            r24 = r4
            r25 = r9
        L_0x00fb:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
            r9 = r22
            r9.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
            r10.apply(r4, r8)
        L_0x010b:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r4)
            int r8 = r7 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9 = r17
            r9.invoke(r4, r5, r8)
            r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r4)
            int r8 = r7 >> 9
            r8 = r8 & 14
            r10 = r5
            r17 = 0
            r4 = 116750785(0x6f579c1, float:9.233766E-35)
            r20 = r7
            java.lang.String r7 = "C266@10990L41:NavigationRail.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r4, r7)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            java.lang.String r7 = "icon"
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r4, r7)
            r7 = 6
            r22 = 0
            r23 = r8
            r8 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r10.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r8)
            androidx.compose.ui.Alignment$Companion r27 = androidx.compose.ui.Alignment.Companion
            r28 = r9
            androidx.compose.ui.Alignment r9 = r27.getTopStart()
            r27 = r12
            r12 = 0
            int r29 = r7 >> 3
            r29 = r29 & 14
            int r30 = r7 >> 3
            r30 = r30 & 112(0x70, float:1.57E-43)
            r31 = r13
            r13 = r29 | r30
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r9, r12, r10, r13)
            int r29 = r7 << 3
            r29 = r29 & 112(0x70, float:1.57E-43)
            r30 = 0
            r32 = r9
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r10.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r11)
            r9 = 0
            int r33 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r10, r9)
            androidx.compose.runtime.CompositionLocalMap r9 = r10.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r34 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r34 = r34.getConstructor()
            kotlin.jvm.functions.Function3 r35 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r4)
            r36 = r4
            int r4 = r29 << 9
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | 6
            r37 = r34
            r34 = r35
            r35 = 0
            r38 = r12
            androidx.compose.runtime.Applier r12 = r10.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x01b3
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01b3:
            r10.startReusableNode()
            boolean r12 = r10.getInserting()
            if (r12 == 0) goto L_0x01c2
            r12 = r37
            r10.createNode(r12)
            goto L_0x01c7
        L_0x01c2:
            r12 = r37
            r10.useNode()
        L_0x01c7:
            r37 = r12
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m4575constructorimpl(r10)
            r39 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r40 = androidx.compose.ui.node.ComposeUiNode.Companion
            r41 = r14
            kotlin.jvm.functions.Function2 r14 = r40.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r13, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r9, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetCompositeKeyHash()
            r40 = 0
            r42 = r12
            r43 = 0
            boolean r44 = r42.getInserting()
            if (r44 != 0) goto L_0x020b
            r44 = r9
            java.lang.Object r9 = r42.rememberedValue()
            r45 = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r33)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r13)
            if (r9 != 0) goto L_0x0208
            goto L_0x020f
        L_0x0208:
            r13 = r42
            goto L_0x021f
        L_0x020b:
            r44 = r9
            r45 = r13
        L_0x020f:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r33)
            r13 = r42
            r13.updateRememberedValue(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r33)
            r12.apply(r9, r14)
        L_0x021f:
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r10)
            androidx.compose.runtime.SkippableUpdater r9 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r9)
            int r12 = r4 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r13 = r34
            r13.invoke(r9, r10, r12)
            r9 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r10.startReplaceableGroup(r9)
            int r9 = r4 >> 9
            r9 = r9 & 14
            r12 = r10
            r14 = 0
            r34 = r4
            r4 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r39 = r9
            java.lang.String r9 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r4, r9)
            androidx.compose.foundation.layout.BoxScopeInstance r40 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r42 = r7 >> 6
            r42 = r42 & 112(0x70, float:1.57E-43)
            r42 = r42 | 6
            androidx.compose.foundation.layout.BoxScope r40 = (androidx.compose.foundation.layout.BoxScope) r40
            r43 = r12
            r46 = 0
            r4 = 2053494659(0x7a65d783, float:2.9835177E35)
            r47 = r7
            java.lang.String r7 = "C266@11023L6:NavigationRail.kt#jmzs0o"
            r48 = r13
            r13 = r43
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r4, r7)
            r4 = r6 & 14
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r0.invoke(r13, r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r10.endReplaceableGroup()
            r10.endNode()
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r4 = 286683862(0x111672d6, float:1.18683E-28)
            r10.startReplaceableGroup(r4)
            java.lang.String r4 = "268@11081L168"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r4)
            if (r1 == 0) goto L_0x03e3
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            java.lang.String r7 = "label"
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r4, r7)
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.draw.AlphaKt.alpha(r4, r2)
            r7 = 0
            r12 = r7
            r7 = 0
            r13 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r10.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r8)
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r8 = r8.getTopStart()
            r13 = 0
            int r14 = r12 >> 3
            r14 = r14 & 14
            int r22 = r12 >> 3
            r22 = r22 & 112(0x70, float:1.57E-43)
            r14 = r14 | r22
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r8, r13, r10, r14)
            int r22 = r12 << 3
            r22 = r22 & 112(0x70, float:1.57E-43)
            r26 = 0
            r29 = r7
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r10.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r11)
            r7 = 0
            int r7 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r10, r7)
            androidx.compose.runtime.CompositionLocalMap r11 = r10.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r18 = r18.getConstructor()
            kotlin.jvm.functions.Function3 r30 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r4)
            r52 = r4
            int r4 = r22 << 9
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | 6
            r32 = r18
            r18 = r30
            r30 = 0
            r33 = r8
            androidx.compose.runtime.Applier r8 = r10.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x030a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x030a:
            r10.startReusableNode()
            boolean r8 = r10.getInserting()
            if (r8 == 0) goto L_0x0319
            r8 = r32
            r10.createNode(r8)
            goto L_0x031e
        L_0x0319:
            r8 = r32
            r10.useNode()
        L_0x031e:
            r32 = r8
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m4575constructorimpl(r10)
            r34 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r35 = androidx.compose.ui.node.ComposeUiNode.Companion
            r36 = r13
            kotlin.jvm.functions.Function2 r13 = r35.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r8, r14, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r8, r11, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetCompositeKeyHash()
            r35 = 0
            r37 = r8
            r38 = 0
            boolean r39 = r37.getInserting()
            if (r39 != 0) goto L_0x0362
            r39 = r11
            java.lang.Object r11 = r37.rememberedValue()
            r40 = r14
            java.lang.Integer r14 = java.lang.Integer.valueOf(r7)
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r14)
            if (r11 != 0) goto L_0x035f
            goto L_0x0366
        L_0x035f:
            r14 = r37
            goto L_0x0376
        L_0x0362:
            r39 = r11
            r40 = r14
        L_0x0366:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
            r14 = r37
            r14.updateRememberedValue(r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
            r8.apply(r11, r13)
        L_0x0376:
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r10)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r8)
            int r11 = r4 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r13 = r18
            r13.invoke(r8, r10, r11)
            r8 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r10.startReplaceableGroup(r8)
            int r8 = r4 >> 9
            r8 = r8 & 14
            r11 = r10
            r14 = 0
            r18 = r4
            r4 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r9)
            androidx.compose.foundation.layout.BoxScopeInstance r4 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r9 = r12 >> 6
            r9 = r9 & 112(0x70, float:1.57E-43)
            r9 = r9 | 6
            androidx.compose.foundation.layout.BoxScope r4 = (androidx.compose.foundation.layout.BoxScope) r4
            r19 = r11
            r34 = 0
            r35 = r4
            r4 = 2053494876(0x7a65d85c, float:2.9835607E35)
            r37 = r7
            java.lang.String r7 = "C272@11240L7:NavigationRail.kt#jmzs0o"
            r38 = r8
            r8 = r19
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r7)
            int r4 = r6 >> 3
            r4 = r4 & 14
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.invoke(r8, r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r10.endReplaceableGroup()
            r10.endNode()
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
        L_0x03e3:
            r10.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x03ff
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03ff:
            androidx.compose.runtime.ScopeUpdateScope r4 = r5.endRestartGroup()
            if (r4 != 0) goto L_0x0406
            goto L_0x0410
        L_0x0406:
            androidx.compose.material.NavigationRailKt$NavigationRailItemBaselineLayout$3 r7 = new androidx.compose.material.NavigationRailKt$NavigationRailItemBaselineLayout$3
            r7.<init>(r0, r1, r2, r3)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r4.updateScope(r7)
        L_0x0410:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.NavigationRailKt.NavigationRailItemBaselineLayout(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, float, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-3p2s80s  reason: not valid java name */
    public static final MeasureResult m3069placeIcon3p2s80s(MeasureScope $this$placeIcon_u2d3p2s80s, Placeable iconPlaceable, long constraints) {
        return MeasureScope.layout$default($this$placeIcon_u2d3p2s80s, Constraints.m7498getMaxWidthimpl(constraints), Constraints.m7497getMaxHeightimpl(constraints), (Map) null, new NavigationRailKt$placeIcon$1(iconPlaceable, Math.max(0, (Constraints.m7498getMaxWidthimpl(constraints) - iconPlaceable.getWidth()) / 2), Math.max(0, (Constraints.m7497getMaxHeightimpl(constraints) - iconPlaceable.getHeight()) / 2)), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-DIyivk0  reason: not valid java name */
    public static final MeasureResult m3070placeLabelAndIconDIyivk0(MeasureScope $this$placeLabelAndIcon_u2dDIyivk0, Placeable labelPlaceable, Placeable iconPlaceable, long constraints, float iconPositionAnimationProgress) {
        MeasureScope measureScope = $this$placeLabelAndIcon_u2dDIyivk0;
        int baseline = labelPlaceable.get(AlignmentLineKt.getLastBaseline());
        int labelY = (Constraints.m7497getMaxHeightimpl(constraints) - baseline) - measureScope.m7529roundToPx0680j_4(ItemLabelBaselineBottomOffset);
        int labelX = (Constraints.m7498getMaxWidthimpl(constraints) - labelPlaceable.getWidth()) / 2;
        int selectedIconY = measureScope.m7529roundToPx0680j_4(ItemIconTopOffset);
        int unselectedIconY = (Constraints.m7497getMaxHeightimpl(constraints) - iconPlaceable.getHeight()) / 2;
        int iconX = (Constraints.m7498getMaxWidthimpl(constraints) - iconPlaceable.getWidth()) / 2;
        int iconDistance = unselectedIconY - selectedIconY;
        int i = iconDistance;
        return MeasureScope.layout$default($this$placeLabelAndIcon_u2dDIyivk0, Constraints.m7498getMaxWidthimpl(constraints), Constraints.m7497getMaxHeightimpl(constraints), (Map) null, new NavigationRailKt$placeLabelAndIcon$1(iconPositionAnimationProgress, labelPlaceable, labelX, labelY, MathKt.roundToInt(((float) iconDistance) * (((float) 1) - iconPositionAnimationProgress)), iconPlaceable, iconX, selectedIconY), 4, (Object) null);
    }
}

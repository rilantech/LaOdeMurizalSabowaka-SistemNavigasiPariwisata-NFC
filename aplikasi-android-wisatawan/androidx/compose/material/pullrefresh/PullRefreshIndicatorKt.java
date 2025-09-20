package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002\u001a-\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aM\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001a2\b\b\u0002\u0010#\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020!H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001aA\u0010'\u001a\u00020\u0016*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0013H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u0013\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000b\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\f\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0011\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00061²\u0006\n\u00102\u001a\u00020!X\u0002²\u0006\n\u00103\u001a\u00020\u0002X\u0002"}, d2 = {"AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "", "ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "Elevation", "IndicatorSize", "MaxAlpha", "MaxProgressArc", "MinAlpha", "SpinnerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "StrokeWidth", "ArrowValues", "Landroidx/compose/material/pullrefresh/ArrowValues;", "progress", "CircularArrowIndicator", "", "state", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "color", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "CircularArrowIndicator-iJQMabo", "(Landroidx/compose/material/pullrefresh/PullRefreshState;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "PullRefreshIndicator", "refreshing", "", "backgroundColor", "contentColor", "scale", "PullRefreshIndicator-jB83MbM", "(ZLandroidx/compose/material/pullrefresh/PullRefreshState;Landroidx/compose/ui/Modifier;JJZLandroidx/compose/runtime/Composer;II)V", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "drawArrow-Bx497Mc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material/pullrefresh/ArrowValues;)V", "material_release", "showElevation", "targetAlpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullRefreshIndicator.kt */
public final class PullRefreshIndicatorKt {
    private static final TweenSpec<Float> AlphaTween = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, (Object) null);
    /* access modifiers changed from: private */
    public static final float ArcRadius = Dp.m5844constructorimpl((float) 7.5d);
    private static final float ArrowHeight = Dp.m5844constructorimpl((float) 5);
    private static final float ArrowWidth = Dp.m5844constructorimpl((float) 10);
    private static final int CrossfadeDurationMs = 100;
    private static final float Elevation = Dp.m5844constructorimpl((float) 6);
    private static final float IndicatorSize = Dp.m5844constructorimpl((float) 40);
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final RoundedCornerShape SpinnerShape = RoundedCornerShapeKt.getCircleShape();
    /* access modifiers changed from: private */
    public static final float StrokeWidth = Dp.m5844constructorimpl((float) 2.5d);

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x02d8  */
    /* renamed from: PullRefreshIndicator-jB83MbM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1503PullRefreshIndicatorjB83MbM(boolean r42, androidx.compose.material.pullrefresh.PullRefreshState r43, androidx.compose.ui.Modifier r44, long r45, long r47, boolean r49, androidx.compose.runtime.Composer r50, int r51, int r52) {
        /*
            r11 = r43
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 308716636(0x1266a45c, float:7.277779E-28)
            r1 = r50
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(PullRefreshIndicator)P(3,5,2,0:c#ui.graphics.Color,1:c#ui.graphics.Color)78@3382L6,79@3424L32,82@3514L98,89@3897L7,93@4025L1067:PullRefreshIndicator.kt#t44y28"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r51
            r2 = r52 & 4
            if (r2 == 0) goto L_0x0022
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r13 = r2
            goto L_0x0024
        L_0x0022:
            r13 = r44
        L_0x0024:
            r2 = r52 & 8
            r3 = 6
            if (r2 == 0) goto L_0x0037
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r12, r3)
            long r4 = r2.m1245getSurface0d7_KjU()
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r14 = r4
            goto L_0x0039
        L_0x0037:
            r14 = r45
        L_0x0039:
            r2 = r52 & 16
            if (r2 == 0) goto L_0x004c
            int r2 = r1 >> 9
            r2 = r2 & 14
            long r4 = androidx.compose.material.ColorsKt.m1259contentColorForek8zF_U(r14, r12, r2)
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r2
            r8 = r1
            r9 = r4
            goto L_0x004f
        L_0x004c:
            r9 = r47
            r8 = r1
        L_0x004f:
            r1 = r52 & 32
            if (r1 == 0) goto L_0x0056
            r1 = 0
            r6 = r1
            goto L_0x0058
        L_0x0056:
            r6 = r49
        L_0x0058:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0064
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.pullrefresh.PullRefreshIndicator (PullRefreshIndicator.kt:74)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r8, r1, r2)
        L_0x0064:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r42)
            r1 = r8 & 14
            r1 = r1 | 64
            r2 = 0
            r4 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            boolean r4 = r12.changed((java.lang.Object) r0)
            boolean r5 = r12.changed((java.lang.Object) r11)
            r4 = r4 | r5
            r5 = r12
            r7 = 0
            java.lang.Object r3 = r5.rememberedValue()
            r16 = 0
            if (r4 != 0) goto L_0x009d
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r44 = r0
            java.lang.Object r0 = r17.getEmpty()
            if (r3 != r0) goto L_0x0097
            goto L_0x009f
        L_0x0097:
            r0 = r3
            r46 = r7
            r7 = r42
            goto L_0x00b6
        L_0x009d:
            r44 = r0
        L_0x009f:
            r0 = 0
            r45 = r0
            androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$showElevation$2$1 r0 = new androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$showElevation$2$1
            r46 = r7
            r7 = r42
            r0.<init>(r7, r11)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r0)
            r5.updateRememberedValue(r0)
        L_0x00b6:
            r12.endReplaceableGroup()
            r16 = r0
            androidx.compose.runtime.State r16 = (androidx.compose.runtime.State) r16
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalElevationOverlay()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r3, r4)
            java.lang.Object r3 = r12.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r17 = r3
            androidx.compose.material.ElevationOverlay r17 = (androidx.compose.material.ElevationOverlay) r17
            r0 = 52228748(0x31cf28c, float:4.612271E-37)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "90@3939L53"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            if (r17 != 0) goto L_0x00e9
            r1 = 0
            goto L_0x0103
        L_0x00e9:
            float r1 = Elevation
            int r2 = r8 >> 9
            r2 = r2 & 14
            r2 = r2 | 48
            r44 = r17
            r45 = r14
            r47 = r1
            r48 = r12
            r49 = r2
            long r1 = r44.m1304apply7g2Lkgo(r45, r47, r48, r49)
            androidx.compose.ui.graphics.Color r1 = androidx.compose.ui.graphics.Color.m3243boximpl(r1)
        L_0x0103:
            r12.endReplaceableGroup()
            if (r1 == 0) goto L_0x010d
            long r1 = r1.m3263unboximpl()
            goto L_0x010e
        L_0x010d:
            r1 = r14
        L_0x010e:
            r4 = r1
            float r1 = IndicatorSize
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m612size3ABfNKs(r13, r1)
            androidx.compose.ui.Modifier r18 = androidx.compose.material.pullrefresh.PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform(r1, r11, r6)
            boolean r1 = PullRefreshIndicator_jB83MbM$lambda$1(r16)
            if (r1 == 0) goto L_0x0125
            float r1 = Elevation
            r19 = r1
            goto L_0x012e
        L_0x0125:
            r1 = 0
            r2 = 0
            float r3 = (float) r1
            float r3 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r3)
            r19 = r3
        L_0x012e:
            androidx.compose.foundation.shape.RoundedCornerShape r1 = SpinnerShape
            r20 = r1
            androidx.compose.ui.graphics.Shape r20 = (androidx.compose.ui.graphics.Shape) r20
            r26 = 24
            r27 = 0
            r21 = 1
            r22 = 0
            r24 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.draw.ShadowKt.m2912shadows4CzXII$default(r18, r19, r20, r21, r22, r24, r26, r27)
            androidx.compose.ui.graphics.Shape r1 = (androidx.compose.ui.graphics.Shape) r1
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.BackgroundKt.m166backgroundbw27NRU(r2, r4, r1)
            r2 = 0
            r3 = r2
            r18 = 0
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getTopStart()
            r2 = 0
            int r19 = r3 >> 3
            r19 = r19 & 14
            int r20 = r3 >> 3
            r20 = r20 & 112(0x70, float:1.57E-43)
            r46 = r4
            r4 = r19 | r20
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r0, r2, r12, r4)
            int r5 = r3 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r19 = 0
            r48 = r0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r0 = 0
            int r20 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r12, r0)
            androidx.compose.runtime.CompositionLocalMap r0 = r12.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r21 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r21 = r21.getConstructor()
            kotlin.jvm.functions.Function3 r22 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r1)
            r49 = r1
            int r1 = r5 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r23 = 6
            r1 = r1 | 6
            r23 = r21
            r21 = r22
            r22 = 0
            r24 = r2
            androidx.compose.runtime.Applier r2 = r12.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x01b4
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01b4:
            r12.startReusableNode()
            boolean r2 = r12.getInserting()
            if (r2 == 0) goto L_0x01c3
            r2 = r23
            r12.createNode(r2)
            goto L_0x01c8
        L_0x01c3:
            r2 = r23
            r12.useNode()
        L_0x01c8:
            r23 = r2
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m2865constructorimpl(r12)
            r25 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r26 = androidx.compose.ui.node.ComposeUiNode.Companion
            r27 = r5
            kotlin.jvm.functions.Function2 r5 = r26.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r2, r4, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r2, r0, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetCompositeKeyHash()
            r26 = 0
            r28 = r2
            r29 = 0
            boolean r30 = r28.getInserting()
            if (r30 != 0) goto L_0x020c
            r30 = r0
            java.lang.Object r0 = r28.rememberedValue()
            r31 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r20)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 != 0) goto L_0x0209
            goto L_0x0210
        L_0x0209:
            r4 = r28
            goto L_0x0220
        L_0x020c:
            r30 = r0
            r31 = r4
        L_0x0210:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)
            r4 = r28
            r4.updateRememberedValue(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)
            r2.apply(r0, r5)
        L_0x0220:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r0)
            int r2 = r1 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4 = r21
            r4.invoke(r0, r12, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r0)
            int r0 = r1 >> 9
            r0 = r0 & 14
            r2 = r12
            r5 = 0
            r21 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r25 = r1
            java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r3 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r26 = 6
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r26 = r2
            r28 = 0
            r29 = r0
            r0 = 1406369954(0x53d380a2, float:1.8167924E12)
            r40 = r1
            java.lang.String r1 = "C100@4312L774:PullRefreshIndicator.kt#t44y28"
            r41 = r3
            r3 = r26
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            java.lang.Boolean r32 = java.lang.Boolean.valueOf(r42)
            r0 = 100
            r26 = r4
            r44 = r5
            r1 = 0
            r4 = 0
            r5 = 6
            androidx.compose.animation.core.TweenSpec r0 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r0, r1, r4, r5, r4)
            r34 = r0
            androidx.compose.animation.core.FiniteAnimationSpec r34 = (androidx.compose.animation.core.FiniteAnimationSpec) r34
            androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$1$1 r0 = new androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$1$1
            r0.<init>(r9, r8, r11)
            r1 = 1853731063(0x6e7db0f7, float:1.9628411E28)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r1, r4, r0)
            r36 = r0
            kotlin.jvm.functions.Function3 r36 = (kotlin.jvm.functions.Function3) r36
            r0 = r8 & 14
            r0 = r0 | 24960(0x6180, float:3.4976E-41)
            r33 = 0
            r35 = 0
            r39 = 10
            r37 = r3
            r38 = r0
            androidx.compose.animation.CrossfadeKt.Crossfade(r32, (androidx.compose.ui.Modifier) r33, (androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float>) r34, (java.lang.String) r35, r36, (androidx.compose.runtime.Composer) r37, (int) r38, (int) r39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r12.endReplaceableGroup()
            r12.endNode()
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02c9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02c9:
            androidx.compose.runtime.ScopeUpdateScope r4 = r12.endRestartGroup()
            if (r4 != 0) goto L_0x02d8
            r19 = r46
            r21 = r6
            r22 = r8
            r23 = r9
            goto L_0x02fc
        L_0x02d8:
            androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$2 r18 = new androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$2
            r0 = r18
            r1 = r42
            r2 = r43
            r3 = r13
            r19 = r46
            r11 = r4
            r4 = r14
            r21 = r6
            r6 = r9
            r22 = r8
            r8 = r21
            r23 = r9
            r9 = r51
            r10 = r52
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x02fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt.m1503PullRefreshIndicatorjB83MbM(boolean, androidx.compose.material.pullrefresh.PullRefreshState, androidx.compose.ui.Modifier, long, long, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean PullRefreshIndicator_jB83MbM$lambda$1(State<Boolean> $showElevation$delegate) {
        return ((Boolean) $showElevation$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: CircularArrowIndicator-iJQMabo  reason: not valid java name */
    public static final void m1502CircularArrowIndicatoriJQMabo(PullRefreshState state, long color, Modifier modifier, Composer $composer, int $changed) {
        Object value$iv$iv;
        State value$iv$iv2;
        PullRefreshState pullRefreshState = state;
        Composer $composer2 = $composer.startRestartGroup(-486016981);
        ComposerKt.sourceInformation($composer2, "C(CircularArrowIndicator)P(2,0:c#ui.graphics.Color)134@5303L61,136@5389L119,142@5531L74,145@5644L1000:PullRefreshIndicator.kt#t44y28");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-486016981, $changed, -1, "androidx.compose.material.pullrefresh.CircularArrowIndicator (PullRefreshIndicator.kt:129)");
        } else {
            int i = $changed;
        }
        $composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer2;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            Object $this$CircularArrowIndicator_iJQMabo_u24lambda_u244_u24lambda_u243 = AndroidPath_androidKt.Path();
            $this$CircularArrowIndicator_iJQMabo_u24lambda_u244_u24lambda_u243.m3537setFillTypeoQ8Xj4U(PathFillType.Companion.m3551getEvenOddRgk1Os());
            value$iv$iv = $this$CircularArrowIndicator_iJQMabo_u24lambda_u244_u24lambda_u243;
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer2.endReplaceableGroup();
        Path path = (Path) value$iv$iv;
        $composer2.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer2.changed((Object) pullRefreshState);
        Composer $this$cache$iv$iv2 = $composer2;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv2 = SnapshotStateKt.derivedStateOf(new PullRefreshIndicatorKt$CircularArrowIndicator$targetAlpha$2$1(pullRefreshState));
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer2.endReplaceableGroup();
        Modifier modifier2 = modifier;
        CanvasKt.Canvas(SemanticsModifierKt.semantics$default(modifier2, false, PullRefreshIndicatorKt$CircularArrowIndicator$1.INSTANCE, 1, (Object) null), new PullRefreshIndicatorKt$CircularArrowIndicator$2(state, AnimateAsStateKt.animateFloatAsState(CircularArrowIndicator_iJQMabo$lambda$6(value$iv$iv2), AlphaTween, 0.0f, (String) null, (Function1<? super Float, Unit>) null, $composer2, 48, 28), color, path), $composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PullRefreshIndicatorKt$CircularArrowIndicator$3(state, color, modifier, $changed));
        }
    }

    private static final float CircularArrowIndicator_iJQMabo$lambda$6(State<Float> $targetAlpha$delegate) {
        return ((Number) $targetAlpha$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float progress) {
        float adjustedPercent = (Math.max(Math.min(1.0f, progress) - 0.4f, 0.0f) * ((float) 5)) / ((float) 3);
        float linearTension = RangesKt.coerceIn(Math.abs(progress) - 1.0f, 0.0f, 2.0f);
        float rotation = (((0.4f * adjustedPercent) - 16.0f) + (linearTension - (((float) Math.pow((double) linearTension, (double) 2)) / ((float) 4)))) * 0.5f;
        float f = (float) 360;
        return new ArrowValues(rotation, rotation * f, (rotation + (MaxProgressArc * adjustedPercent)) * f, Math.min(1.0f, adjustedPercent));
    }

    /* access modifiers changed from: private */
    /* renamed from: drawArrow-Bx497Mc  reason: not valid java name */
    public static final void m1506drawArrowBx497Mc(DrawScope $this$drawArrow_u2dBx497Mc, Path arrow, Rect bounds, long color, float alpha, ArrowValues values) {
        DrawScope drawScope = $this$drawArrow_u2dBx497Mc;
        Path path = arrow;
        arrow.reset();
        path.moveTo(0.0f, 0.0f);
        float f = ArrowWidth;
        path.lineTo(drawScope.m5825toPx0680j_4(f) * values.getScale(), 0.0f);
        path.lineTo((drawScope.m5825toPx0680j_4(f) * values.getScale()) / ((float) 2), drawScope.m5825toPx0680j_4(ArrowHeight) * values.getScale());
        float radius = Math.min(bounds.getWidth(), bounds.getHeight()) / 2.0f;
        path.m3539translatek4lQ0M(OffsetKt.Offset((Offset.m3003getXimpl(bounds.m3033getCenterF1C5BW0()) + radius) - ((drawScope.m5825toPx0680j_4(f) * values.getScale()) / 2.0f), Offset.m3004getYimpl(bounds.m3033getCenterF1C5BW0()) + (drawScope.m5825toPx0680j_4(StrokeWidth) / 2.0f)));
        arrow.close();
        DrawScope $this$rotate_u2dRg1IO4c_u24default$iv = $this$drawArrow_u2dBx497Mc;
        float degrees$iv = values.getEndAngle();
        long pivot$iv = $this$rotate_u2dRg1IO4c_u24default$iv.m3865getCenterF1C5BW0();
        DrawScope $this$withTransform$iv$iv = $this$rotate_u2dRg1IO4c_u24default$iv;
        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform$iv$iv.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.m3809getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv$iv.getTransform().m3924rotateUv8p0NA(degrees$iv, pivot$iv);
        DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv;
        long j = pivot$iv;
        DrawScope.m3838drawPathLG529CI$default($this$withTransform$iv$iv, arrow, color, alpha, (DrawStyle) null, (ColorFilter) null, 0, 56, (Object) null);
        $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv$iv2.m3810setSizeuvyYCjk(previousSize$iv$iv);
    }
}

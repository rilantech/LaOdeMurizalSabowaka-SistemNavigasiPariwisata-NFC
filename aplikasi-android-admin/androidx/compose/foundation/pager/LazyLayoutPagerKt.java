package androidx.compose.foundation.pager;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.reflect.KProperty0;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÙ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 21\u0010!\u001a-\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(\u001a\u0001\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010\u0004\u001a\u00020\u000521\u0010!\u001a-\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&2#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00182\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100*H\u0003¢\u0006\u0002\u0010-\u001a\u0014\u0010.\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006/"}, d2 = {"Pager", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "flingBehavior", "Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "userScrollEnabled", "beyondBoundsPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Pager-fs30GE4", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZIFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "rememberPagerItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "pageCount", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "dragDirectionDetector", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutPager.kt */
public final class LazyLayoutPagerKt {
    /* JADX WARNING: Removed duplicated region for block: B:25:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0328  */
    /* renamed from: Pager-fs30GE4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2522Pagerfs30GE4(androidx.compose.ui.Modifier r31, androidx.compose.foundation.pager.PagerState r32, androidx.compose.foundation.layout.PaddingValues r33, boolean r34, androidx.compose.foundation.gestures.Orientation r35, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r36, boolean r37, int r38, float r39, androidx.compose.foundation.pager.PageSize r40, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r41, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r42, androidx.compose.ui.Alignment.Horizontal r43, androidx.compose.ui.Alignment.Vertical r44, kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, androidx.compose.runtime.Composer r46, int r47, int r48, int r49) {
        /*
            r15 = r31
            r14 = r32
            r13 = r34
            r12 = r35
            r11 = r36
            r10 = r41
            r9 = r49
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "contentPadding"
            r8 = r33
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "orientation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "flingBehavior"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "pageSize"
            r7 = r40
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "pageNestedScrollConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "horizontalAlignment"
            r6 = r43
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "verticalAlignment"
            r5 = r44
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "pageContent"
            r4 = r45
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = -301644943(0xffffffffee054371, float:-1.031076E28)
            r1 = r46
            androidx.compose.runtime.Composer r3 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Pager)P(5,12,1,11,6,2,13!1,10:c#ui.unit.Dp,9,8,4!1,14)95@4489L18,101@4652L19,97@4537L134,114@5148L19,103@4697L477,117@5205L94,127@5488L115,138@5788L276,146@6128L161,156@6513L7,133@5609L1489:LazyLayoutPager.kt#g6yjnt"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r1)
            r2 = r47
            r1 = r48
            r0 = r9 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x006a
            r0 = 0
            goto L_0x006c
        L_0x006a:
            r0 = r38
        L_0x006c:
            r4 = r9 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x007b
            r4 = 0
            r17 = 0
            float r5 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r5)
            r19 = r4
            goto L_0x007d
        L_0x007b:
            r19 = r39
        L_0x007d:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x008b
            java.lang.String r4 = "androidx.compose.foundation.pager.Pager (LazyLayoutPager.kt:58)"
            r5 = -301644943(0xffffffffee054371, float:-1.031076E28)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r1, r4)
        L_0x008b:
            r16 = 1
            r17 = 0
            if (r0 < 0) goto L_0x0094
            r4 = r16
            goto L_0x0096
        L_0x0094:
            r4 = r17
        L_0x0096:
            if (r4 == 0) goto L_0x0365
            androidx.compose.foundation.gestures.ScrollableDefaults r4 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r5 = 6
            androidx.compose.foundation.OverscrollEffect r4 = r4.overscrollEffect(r3, r5)
            int r18 = r2 >> 3
            r18 = r18 & 14
            r20 = 0
            r6 = 1157296644(0x44faf204, float:2007.563)
            r3.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r6)
            boolean r21 = r3.changed((java.lang.Object) r14)
            r39 = r3
            r22 = 0
            java.lang.Object r5 = r39.rememberedValue()
            r23 = 0
            if (r21 != 0) goto L_0x00d4
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r25 = r0
            java.lang.Object r0 = r24.getEmpty()
            if (r5 != r0) goto L_0x00ce
            goto L_0x00d6
        L_0x00ce:
            r24 = r4
            r0 = r5
            r4 = r39
            goto L_0x00e9
        L_0x00d4:
            r25 = r0
        L_0x00d6:
            r0 = 0
            r24 = r0
            androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$pagerItemProvider$1$1 r0 = new androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$pagerItemProvider$1$1
            r0.<init>(r14)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r24 = r4
            r4 = r39
            r4.updateRememberedValue(r0)
        L_0x00e9:
            r3.endReplaceableGroup()
            r4 = r0
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            int r0 = r2 >> 3
            r0 = r0 & 14
            int r5 = r1 >> 9
            r5 = r5 & 112(0x70, float:1.57E-43)
            r0 = r0 | r5
            int r5 = r1 << 3
            r5 = r5 & 896(0x380, float:1.256E-42)
            r5 = r5 | r0
            r39 = r25
            r0 = r32
            r20 = r1
            r1 = r45
            r13 = r2
            r2 = r42
            r21 = r3
            r3 = r4
            r26 = r24
            r4 = r21
            r18 = 6
            kotlin.jvm.functions.Function0 r22 = rememberPagerItemProviderLambda(r0, r1, r2, r3, r4, r5)
            int r0 = r13 >> 3
            r0 = r0 & 14
            r1 = 0
            r5 = r21
            r2 = 1157296644(0x44faf204, float:2007.563)
            r5.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            boolean r2 = r5.changed((java.lang.Object) r14)
            r3 = r5
            r4 = 0
            java.lang.Object r6 = r3.rememberedValue()
            r21 = 0
            if (r2 != 0) goto L_0x014c
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r38 = r0
            java.lang.Object r0 = r23.getEmpty()
            if (r6 != r0) goto L_0x014a
            goto L_0x014e
        L_0x014a:
            r0 = r6
            goto L_0x015d
        L_0x014c:
            r38 = r0
        L_0x014e:
            r0 = 0
            r46 = r0
            androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$measurePolicy$1$1 r0 = new androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$measurePolicy$1$1
            r0.<init>(r14)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r3.updateRememberedValue(r0)
        L_0x015d:
            r5.endReplaceableGroup()
            r21 = r0
            kotlin.jvm.functions.Function0 r21 = (kotlin.jvm.functions.Function0) r21
            r0 = r13 & 112(0x70, float:1.57E-43)
            r1 = r13 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r13 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r23 = 57344(0xe000, float:8.0356E-41)
            r1 = r13 & r23
            r0 = r0 | r1
            int r1 = r13 >> 6
            r24 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r24
            r0 = r0 | r1
            int r1 = r13 >> 6
            r2 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r13 >> 6
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r20 << 18
            r2 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r2
            r0 = r0 | r1
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            int r2 = r20 << 18
            r1 = r1 & r2
            r25 = r0 | r1
            r27 = 0
            r0 = r22
            r1 = r32
            r2 = r33
            r3 = r34
            r4 = r35
            r6 = r5
            r5 = r39
            r38 = r6
            r6 = r19
            r7 = r40
            r8 = r43
            r9 = r44
            r10 = r21
            r11 = r38
            r15 = r12
            r12 = r25
            r15 = r13
            r13 = r27
            kotlin.jvm.functions.Function2 r21 = androidx.compose.foundation.pager.PagerMeasurePolicyKt.m2535rememberPagerMeasurePolicyBxUkNYg(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            int r0 = r15 >> 15
            r0 = r0 & 14
            r1 = r15 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = 0
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r13 = r38
            r13.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            r12 = r36
            boolean r2 = r13.changed((java.lang.Object) r12)
            boolean r3 = r13.changed((java.lang.Object) r14)
            r2 = r2 | r3
            r3 = r13
            r4 = 0
            java.lang.Object r5 = r3.rememberedValue()
            r6 = 0
            if (r2 != 0) goto L_0x01f1
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r5 != r7) goto L_0x01ef
            goto L_0x01f1
        L_0x01ef:
            r7 = r5
            goto L_0x01fc
        L_0x01f1:
            r7 = 0
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior r8 = new androidx.compose.foundation.pager.PagerWrapperFlingBehavior
            r8.<init>(r12, r14)
            r7 = r8
            r3.updateRememberedValue(r7)
        L_0x01fc:
            r13.endReplaceableGroup()
            r25 = r7
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior r25 = (androidx.compose.foundation.pager.PagerWrapperFlingBehavior) r25
            r0 = 1445586192(0x5629e510, float:4.670032E13)
            r13.startReplaceableGroup(r0)
            java.lang.String r0 = "122@5368L58"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            if (r37 == 0) goto L_0x022a
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Vertical
            r2 = r35
            if (r2 != r1) goto L_0x021f
            r1 = r16
            goto L_0x0221
        L_0x021f:
            r1 = r17
        L_0x0221:
            r3 = r15 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.pager.PagerKt.pagerSemantics(r0, r14, r1, r13, r3)
            goto L_0x0230
        L_0x022a:
            r2 = r35
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x0230:
            r13.endReplaceableGroup()
            r11 = r0
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r2 != r0) goto L_0x023d
            r0 = r16
            goto L_0x023f
        L_0x023d:
            r0 = r17
        L_0x023f:
            int r1 = r15 >> 3
            r1 = r1 & 14
            int r3 = r15 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            r10 = r34
            androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState r27 = androidx.compose.foundation.pager.PagerSemanticsKt.rememberPagerSemanticState(r14, r10, r0, r13, r1)
            androidx.compose.ui.layout.RemeasurementModifier r0 = r32.getRemeasurementModifier$foundation_release()
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r9 = r31
            r8 = r2
            androidx.compose.ui.Modifier r0 = r9.then(r0)
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r1 = r32.getAwaitLayoutModifier$foundation_release()
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r0 = r0.then(r1)
            androidx.compose.ui.Modifier r0 = r0.then(r11)
            int r1 = r15 >> 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            int r2 = r15 >> 6
            r2 = r2 & r23
            r1 = r1 | r2
            int r2 = r15 << 6
            r2 = r2 & r24
            r7 = r1 | r2
            r1 = r22
            r2 = r27
            r3 = r35
            r4 = r37
            r5 = r34
            r6 = r13
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt.lazyLayoutSemantics(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ClipScrollableContainerKt.clipScrollableContainer(r0, r8)
            r1 = r15 & 112(0x70, float:1.57E-43)
            int r2 = r15 >> 15
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r15 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = r15 & r23
            r6 = r1 | r2
            r1 = r32
            r2 = r39
            r3 = r34
            r4 = r35
            r5 = r13
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.pager.PagerBeyondBoundsModifierKt.pagerBeyondBoundsModifier(r0, r1, r2, r3, r4, r5, r6)
            r7 = r26
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.OverscrollKt.overscroll(r0, r7)
            androidx.compose.foundation.gestures.ScrollableDefaults r1 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 0
            r4 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r6)
            java.lang.Object r5 = r13.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            boolean r5 = r1.reverseDirection(r5, r8, r10)
            androidx.compose.foundation.interaction.MutableInteractionSource r16 = r32.getInternalInteractionSource$foundation_release()
            r1 = r14
            androidx.compose.foundation.gestures.ScrollableState r1 = (androidx.compose.foundation.gestures.ScrollableState) r1
            r6 = r25
            androidx.compose.foundation.gestures.FlingBehavior r6 = (androidx.compose.foundation.gestures.FlingBehavior) r6
            r2 = r35
            r3 = r7
            r4 = r37
            r23 = r7
            r7 = r16
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.gestures.ScrollableKt.scrollable(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.Modifier r0 = dragDirectionDetector(r0, r14)
            r1 = 2
            r2 = 0
            r7 = r41
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r0, r7, r2, r1, r2)
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r3 = r32.getPrefetchState$foundation_release()
            r6 = 0
            r0 = 0
            r1 = r22
            r4 = r21
            r5 = r13
            r7 = r0
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout((kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider>) r1, (androidx.compose.ui.Modifier) r2, (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult>) r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x031b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x031b:
            androidx.compose.runtime.ScopeUpdateScope r7 = r13.endRestartGroup()
            if (r7 != 0) goto L_0x0328
            r26 = r11
            r29 = r13
            r30 = r15
            goto L_0x0364
        L_0x0328:
            androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$2 r24 = new androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$2
            r0 = r24
            r1 = r31
            r2 = r32
            r3 = r33
            r4 = r34
            r5 = r35
            r6 = r36
            r28 = r7
            r7 = r37
            r8 = r39
            r9 = r19
            r10 = r40
            r26 = r11
            r11 = r41
            r12 = r42
            r29 = r13
            r13 = r43
            r14 = r44
            r30 = r15
            r15 = r45
            r16 = r47
            r17 = r48
            r18 = r49
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r24
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r28
            r1.updateScope(r0)
        L_0x0364:
            return
        L_0x0365:
            r39 = r0
            r20 = r1
            r30 = r2
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "beyondBoundsPageCount should be greater than or equal to 0, you selected "
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = r39
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.LazyLayoutPagerKt.m2522Pagerfs30GE4(androidx.compose.ui.Modifier, androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.Orientation, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, boolean, int, float, androidx.compose.foundation.pager.PageSize, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment$Horizontal, androidx.compose.ui.Alignment$Vertical, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final Function0<PagerLazyLayoutItemProvider> rememberPagerItemProviderLambda(PagerState state, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Function1<? super Integer, ? extends Object> key, Function0<Integer> pageCount, Composer $composer, int $changed) {
        Object value$iv$iv;
        PagerState pagerState = state;
        Function1<? super Integer, ? extends Object> function1 = key;
        Function0<Integer> function0 = pageCount;
        Composer composer = $composer;
        int i = $changed;
        composer.startReplaceableGroup(-1372505274);
        ComposerKt.sourceInformation(composer, "C(rememberPagerItemProviderLambda)P(3,1)240@9459L33,241@9504L659:LazyLayoutPager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1372505274, i, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:234)");
        }
        State latestContent = SnapshotStateKt.rememberUpdatedState(pageContent, composer, (i >> 3) & 14);
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : new Object[]{pagerState, latestContent, function1, function0}) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (KProperty0) new LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$itemProviderState$1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$intervalContentState$1(latestContent, function1, function0)), pagerState)));
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        KProperty0 kProperty0 = (KProperty0) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return kProperty0;
    }

    private static final Modifier dragDirectionDetector(Modifier $this$dragDirectionDetector, PagerState state) {
        return $this$dragDirectionDetector.then(SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) state, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new LazyLayoutPagerKt$dragDirectionDetector$1(state, (Continuation<? super LazyLayoutPagerKt$dragDirectionDetector$1>) null)));
    }
}

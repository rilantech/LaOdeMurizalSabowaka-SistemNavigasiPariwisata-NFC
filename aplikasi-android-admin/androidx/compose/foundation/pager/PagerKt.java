package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001aÛ\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020!21\u0010\"\u001a-\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0#¢\u0006\u0002\b&¢\u0006\u0002\b'H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001aå\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020!21\u0010\"\u001a-\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0#¢\u0006\u0002\b&¢\u0006\u0002\b'H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,\u001a.\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u000204032\u0006\u00105\u001a\u000204H\u0002\u001aÛ\u0001\u00106\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020!21\u0010\"\u001a-\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0#¢\u0006\u0002\b&¢\u0006\u0002\b'H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:\u001aå\u0001\u00106\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020!21\u0010\"\u001a-\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0#¢\u0006\u0002\b&¢\u0006\u0002\b'H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<\u001a\u0017\u0010=\u001a\u00020\b2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?H\b\u001a\f\u0010A\u001a\u000204*\u00020\nH\u0002\u001a\f\u0010B\u001a\u00020\u0004*\u00020\nH\u0002\u001a!\u0010C\u001a\u00020\f*\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010E\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006F"}, d2 = {"ConsumeHorizontalFlingNestedScrollConnection", "Landroidx/compose/foundation/pager/ConsumeAllFlingOnDirection;", "ConsumeVerticalFlingNestedScrollConnection", "DEBUG", "", "LowVelocityAnimationDefaultDuration", "", "HorizontalPager", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondBoundsPageCount", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "userScrollEnabled", "reverseLayout", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-xYaah8o", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "pageCount", "HorizontalPager-AlbwjTQ", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "pagerState", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapPositionalThreshold", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager-xYaah8o", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager-AlbwjTQ", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "dragGestureDelta", "isScrollingForward", "pagerSemantics", "isVertical", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Pager.kt */
public final class PagerKt {
    /* access modifiers changed from: private */
    public static final ConsumeAllFlingOnDirection ConsumeHorizontalFlingNestedScrollConnection = new ConsumeAllFlingOnDirection(Orientation.Horizontal);
    /* access modifiers changed from: private */
    public static final ConsumeAllFlingOnDirection ConsumeVerticalFlingNestedScrollConnection = new ConsumeAllFlingOnDirection(Orientation.Vertical);
    private static final boolean DEBUG = false;
    private static final int LowVelocityAnimationDefaultDuration = 500;

    /* renamed from: HorizontalPager-xYaah8o  reason: not valid java name */
    public static final void m2528HorizontalPagerxYaah8o(PagerState state, Modifier modifier, PaddingValues contentPadding, PageSize pageSize, int beyondBoundsPageCount, float pageSpacing, Alignment.Vertical verticalAlignment, SnapFlingBehavior flingBehavior, boolean userScrollEnabled, boolean reverseLayout, Function1<? super Integer, ? extends Object> key, NestedScrollConnection pageNestedScrollConnection, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer $composer, int $changed, int $changed1, int i) {
        Modifier modifier2;
        PageSize pageSize2;
        int i2;
        Alignment.Vertical vertical;
        int i3;
        int $dirty;
        int i4;
        Composer $composer2;
        NestedScrollConnection pageNestedScrollConnection2;
        Function1 key2;
        boolean reverseLayout2;
        boolean userScrollEnabled2;
        SnapFlingBehavior flingBehavior2;
        Alignment.Vertical verticalAlignment2;
        float pageSpacing2;
        int beyondBoundsPageCount2;
        PageSize pageSize3;
        PaddingValues contentPadding2;
        Modifier modifier3;
        int i5;
        int $dirty1;
        int $dirty2;
        Modifier modifier4;
        PageSize pageSize4;
        int beyondBoundsPageCount3;
        float pageSpacing3;
        Alignment.Vertical verticalAlignment3;
        int $dirty12;
        int i6;
        int i7;
        int i8;
        SnapFlingBehavior flingBehavior3;
        boolean userScrollEnabled3;
        boolean reverseLayout3;
        Function1 key3;
        int i9;
        PagerState pagerState = state;
        Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = pageContent;
        int i10 = $changed;
        int i11 = $changed1;
        int i12 = i;
        Intrinsics.checkNotNullParameter(pagerState, "state");
        Intrinsics.checkNotNullParameter(function4, "pageContent");
        Composer $composer3 = $composer.startRestartGroup(1491175841);
        ComposerKt.sourceInformation($composer3, "C(HorizontalPager)P(10,4,1,7!1,8:c#ui.unit.Dp,12!1,11,9!1,6)113@6091L28,122@6441L620:Pager.kt#g6yjnt");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
        if ((i12 & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i10 & 14) == 0) {
            $dirty3 |= $composer3.changed((Object) pagerState) ? 4 : 2;
        }
        int i13 = i12 & 2;
        if (i13 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if ((i10 & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i14 = i12 & 4;
        if (i14 != 0) {
            $dirty3 |= 384;
            PaddingValues paddingValues = contentPadding;
        } else if ((i10 & 896) == 0) {
            $dirty3 |= $composer3.changed((Object) contentPadding) ? 256 : 128;
        } else {
            PaddingValues paddingValues2 = contentPadding;
        }
        int i15 = i12 & 8;
        if (i15 != 0) {
            $dirty3 |= 3072;
            pageSize2 = pageSize;
        } else if ((i10 & 7168) == 0) {
            pageSize2 = pageSize;
            $dirty3 |= $composer3.changed((Object) pageSize2) ? 2048 : 1024;
        } else {
            pageSize2 = pageSize;
        }
        int i16 = i12 & 16;
        if (i16 != 0) {
            $dirty3 |= 24576;
            i2 = beyondBoundsPageCount;
        } else if ((i10 & 57344) == 0) {
            i2 = beyondBoundsPageCount;
            $dirty3 |= $composer3.changed(i2) ? 16384 : 8192;
        } else {
            i2 = beyondBoundsPageCount;
        }
        int i17 = i12 & 32;
        if (i17 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            float f = pageSpacing;
        } else if ((i10 & 458752) == 0) {
            $dirty3 |= $composer3.changed(pageSpacing) ? 131072 : 65536;
        } else {
            float f2 = pageSpacing;
        }
        int i18 = i12 & 64;
        if (i18 != 0) {
            $dirty3 |= 1572864;
            vertical = verticalAlignment;
        } else if ((i10 & 3670016) == 0) {
            vertical = verticalAlignment;
            $dirty3 |= $composer3.changed((Object) vertical) ? 1048576 : 524288;
        } else {
            vertical = verticalAlignment;
        }
        if ((i10 & 29360128) == 0) {
            if ((i12 & 128) != 0) {
                SnapFlingBehavior snapFlingBehavior = flingBehavior;
            } else if ($composer3.changed((Object) flingBehavior)) {
                i9 = 8388608;
                $dirty3 |= i9;
            }
            i9 = 4194304;
            $dirty3 |= i9;
        } else {
            SnapFlingBehavior snapFlingBehavior2 = flingBehavior;
        }
        int i19 = i12 & 256;
        if (i19 != 0) {
            $dirty3 |= 100663296;
            i3 = i19;
            boolean z = userScrollEnabled;
        } else if ((i10 & 234881024) == 0) {
            i3 = i19;
            $dirty3 |= $composer3.changed(userScrollEnabled) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i19;
            boolean z2 = userScrollEnabled;
        }
        int i20 = i12 & 512;
        if (i20 != 0) {
            $dirty = $dirty3 | 805306368;
            i4 = i20;
            boolean z3 = reverseLayout;
        } else {
            if ((i10 & 1879048192) == 0) {
                i4 = i20;
                $dirty3 |= $composer3.changed(reverseLayout) ? 536870912 : 268435456;
            } else {
                i4 = i20;
                boolean z4 = reverseLayout;
            }
            $dirty = $dirty3;
        }
        int $dirty4 = i12 & 1024;
        if ($dirty4 != 0) {
            $dirty13 |= 6;
            Function1<? super Integer, ? extends Object> function1 = key;
        } else if ((i11 & 14) == 0) {
            $dirty13 |= $composer3.changedInstance(key) ? 4 : 2;
        } else {
            Function1<? super Integer, ? extends Object> function12 = key;
        }
        int i21 = i12 & 2048;
        if (i21 != 0) {
            $dirty13 |= 16;
        }
        int i22 = $dirty4;
        if ((i12 & 4096) != 0) {
            $dirty13 |= 384;
        } else if ((i11 & 896) == 0) {
            $dirty13 |= $composer3.changedInstance(function4) ? 256 : 128;
        }
        if (i21 == 2048 && ($dirty & 1533916891) == 306783378 && ($dirty13 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            contentPadding2 = contentPadding;
            pageSpacing2 = pageSpacing;
            flingBehavior2 = flingBehavior;
            userScrollEnabled2 = userScrollEnabled;
            key2 = key;
            pageNestedScrollConnection2 = pageNestedScrollConnection;
            int i23 = $dirty13;
            verticalAlignment2 = vertical;
            modifier3 = modifier2;
            pageSize3 = pageSize2;
            beyondBoundsPageCount2 = i2;
            $composer2 = $composer3;
            int i24 = $dirty;
            reverseLayout2 = reverseLayout;
        } else {
            $composer3.startDefaults();
            if ((i10 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i13 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i14 != 0) {
                    contentPadding2 = PaddingKt.m2241PaddingValues0680j_4(Dp.m7554constructorimpl((float) 0));
                } else {
                    contentPadding2 = contentPadding;
                }
                if (i15 != 0) {
                    pageSize4 = PageSize.Fill.INSTANCE;
                } else {
                    pageSize4 = pageSize2;
                }
                if (i16 != 0) {
                    beyondBoundsPageCount3 = 0;
                } else {
                    beyondBoundsPageCount3 = i2;
                }
                if (i17 != 0) {
                    pageSpacing3 = Dp.m7554constructorimpl((float) 0);
                } else {
                    pageSpacing3 = pageSpacing;
                }
                if (i18 != 0) {
                    verticalAlignment3 = Alignment.Companion.getCenterVertically();
                } else {
                    verticalAlignment3 = vertical;
                }
                if ((i12 & 128) != 0) {
                    $dirty12 = $dirty13;
                    $composer2 = $composer3;
                    i8 = i3;
                    i7 = i4;
                    i5 = 1491175841;
                    i6 = i21;
                    flingBehavior3 = PagerDefaults.INSTANCE.m2526flingBehaviorPfoAEA0(state, (PagerSnapDistance) null, (AnimationSpec<Float>) null, (DecayAnimationSpec<Float>) null, (AnimationSpec<Float>) null, 0.0f, 0.0f, $composer3, ($dirty & 14) | 12582912, 126);
                    $dirty &= -29360129;
                } else {
                    $dirty12 = $dirty13;
                    $composer2 = $composer3;
                    i8 = i3;
                    i7 = i4;
                    i5 = 1491175841;
                    i6 = i21;
                    flingBehavior3 = flingBehavior;
                }
                if (i8 != 0) {
                    userScrollEnabled3 = true;
                } else {
                    userScrollEnabled3 = userScrollEnabled;
                }
                if (i7 != 0) {
                    reverseLayout3 = false;
                } else {
                    reverseLayout3 = reverseLayout;
                }
                if (i22 != 0) {
                    key3 = null;
                } else {
                    key3 = key;
                }
                if (i6 != 0) {
                    int i25 = $dirty12 & -113;
                    flingBehavior2 = flingBehavior3;
                    userScrollEnabled2 = userScrollEnabled3;
                    key2 = key3;
                    pageNestedScrollConnection2 = PagerDefaults.INSTANCE.pageNestedScrollConnection(Orientation.Horizontal);
                    $dirty1 = i25;
                    beyondBoundsPageCount2 = beyondBoundsPageCount3;
                    verticalAlignment2 = verticalAlignment3;
                    $dirty2 = $dirty;
                    reverseLayout2 = reverseLayout3;
                    modifier3 = modifier4;
                    pageSpacing2 = pageSpacing3;
                    pageSize3 = pageSize4;
                } else {
                    flingBehavior2 = flingBehavior3;
                    userScrollEnabled2 = userScrollEnabled3;
                    key2 = key3;
                    beyondBoundsPageCount2 = beyondBoundsPageCount3;
                    verticalAlignment2 = verticalAlignment3;
                    $dirty2 = $dirty;
                    $dirty1 = $dirty12;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    reverseLayout2 = reverseLayout3;
                    modifier3 = modifier4;
                    pageSpacing2 = pageSpacing3;
                    pageSize3 = pageSize4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i12 & 128) != 0) {
                    $dirty &= -29360129;
                }
                if (i21 != 0) {
                    contentPadding2 = contentPadding;
                    pageSpacing2 = pageSpacing;
                    flingBehavior2 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    key2 = key;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty1 = $dirty13 & -113;
                    verticalAlignment2 = vertical;
                    modifier3 = modifier2;
                    pageSize3 = pageSize2;
                    beyondBoundsPageCount2 = i2;
                    $composer2 = $composer3;
                    $dirty2 = $dirty;
                    i5 = 1491175841;
                    reverseLayout2 = reverseLayout;
                } else {
                    contentPadding2 = contentPadding;
                    pageSpacing2 = pageSpacing;
                    flingBehavior2 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    key2 = key;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty1 = $dirty13;
                    verticalAlignment2 = vertical;
                    modifier3 = modifier2;
                    pageSize3 = pageSize2;
                    beyondBoundsPageCount2 = i2;
                    $composer2 = $composer3;
                    $dirty2 = $dirty;
                    i5 = 1491175841;
                    reverseLayout2 = reverseLayout;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i5, $dirty2, $dirty1, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:105)");
            }
            int i26 = $dirty2;
            int i27 = $dirty1;
            LazyLayoutPagerKt.m2522Pagerfs30GE4(modifier3, state, contentPadding2, reverseLayout2, Orientation.Horizontal, flingBehavior2, userScrollEnabled2, beyondBoundsPageCount2, pageSpacing2, pageSize3, pageNestedScrollConnection2, key2, Alignment.Companion.getCenterHorizontally(), verticalAlignment2, pageContent, $composer2, (($dirty2 >> 3) & 14) | 24576 | (($dirty2 << 3) & 112) | ($dirty2 & 896) | (($dirty2 >> 18) & 7168) | (($dirty2 >> 6) & 458752) | (($dirty2 >> 6) & 3670016) | (($dirty2 << 9) & 29360128) | (($dirty2 << 9) & 234881024) | (($dirty2 << 18) & 1879048192), (($dirty1 << 3) & 112) | 392 | (($dirty2 >> 9) & 7168) | (($dirty1 << 6) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PagerKt$HorizontalPager$1(state, modifier3, contentPadding2, pageSize3, beyondBoundsPageCount2, pageSpacing2, verticalAlignment2, flingBehavior2, userScrollEnabled2, reverseLayout2, key2, pageNestedScrollConnection2, pageContent, $changed, $changed1, i));
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Please use the overload without pageCount. pageCount should be provided through PagerState.", replaceWith = @ReplaceWith(expression = "HorizontalPager(\n            modifier = modifier,\n            state = state,\n            pageSpacing = pageSpacing,\n            horizontalAlignment = horizontalAlignment,\n            userScrollEnabled = userScrollEnabled,\n            reverseLayout = reverseLayout,\n            contentPadding = contentPadding,\n            beyondBoundsPageCount = beyondBoundsPageCount,\n            pageSize = pageSize,\n            flingBehavior = flingBehavior,\n            key = key,\n            pageNestedScrollConnection = pageNestedScrollConnection,\n            pageContent = pageContent\n        )", imports = {"androidx.compose.foundation.gestures.Orientation", "androidx.compose.foundation.layout.PaddingValues", "androidx.compose.foundation.pager.PageSize", "androidx.compose.foundation.pager.PagerDefaults"}))
    /* renamed from: HorizontalPager-AlbwjTQ  reason: not valid java name */
    public static final void m2527HorizontalPagerAlbwjTQ(int pageCount, Modifier modifier, PagerState state, PaddingValues contentPadding, PageSize pageSize, int beyondBoundsPageCount, float pageSpacing, Alignment.Vertical verticalAlignment, SnapFlingBehavior flingBehavior, boolean userScrollEnabled, boolean reverseLayout, Function1<? super Integer, ? extends Object> key, NestedScrollConnection pageNestedScrollConnection, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer $composer, int $changed, int $changed1, int i) {
        Modifier modifier2;
        PagerState state2;
        PageSize pageSize2;
        int i2;
        SnapFlingBehavior snapFlingBehavior;
        int i3;
        int i4;
        int i5;
        NestedScrollConnection pageNestedScrollConnection2;
        Function1 key2;
        boolean reverseLayout2;
        boolean userScrollEnabled2;
        SnapFlingBehavior flingBehavior2;
        Alignment.Vertical verticalAlignment2;
        float pageSpacing2;
        int beyondBoundsPageCount2;
        PageSize pageSize3;
        PaddingValues contentPadding2;
        PagerState state3;
        Modifier modifier3;
        int $dirty;
        int $dirty1;
        Alignment.Vertical verticalAlignment3;
        float pageSpacing3;
        int beyondBoundsPageCount3;
        PageSize pageSize4;
        PaddingValues contentPadding3;
        boolean reverseLayout3;
        boolean userScrollEnabled3;
        SnapFlingBehavior flingBehavior3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int $dirty2;
        PagerState state4;
        SnapFlingBehavior flingBehavior4;
        boolean userScrollEnabled4;
        boolean reverseLayout4;
        Function1 key3;
        Function0 value$iv$iv;
        int i11;
        int i12;
        int i13 = pageCount;
        Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = pageContent;
        int i14 = $changed;
        int i15 = $changed1;
        int i16 = i;
        Intrinsics.checkNotNullParameter(function4, "pageContent");
        Composer $composer2 = $composer.startRestartGroup(1817327312);
        ComposerKt.sourceInformation($composer2, "C(HorizontalPager)P(6,4,11,1,8!1,9:c#ui.unit.Dp,13!1,12,10!1,7)215@11194L13,215@11175L32,221@11495L28,230@11845L620:Pager.kt#g6yjnt");
        int $dirty3 = $changed;
        int $dirty12 = $changed1;
        if ((i16 & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i14 & 14) == 0) {
            $dirty3 |= $composer2.changed(i13) ? 4 : 2;
        }
        int i17 = i16 & 2;
        if (i17 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if ((i14 & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i14 & 896) == 0) {
            if ((i16 & 4) == 0) {
                state2 = state;
                if ($composer2.changed((Object) state2)) {
                    i12 = 256;
                    $dirty3 |= i12;
                }
            } else {
                state2 = state;
            }
            i12 = 128;
            $dirty3 |= i12;
        } else {
            state2 = state;
        }
        int i18 = i16 & 8;
        int i19 = 2048;
        if (i18 != 0) {
            $dirty3 |= 3072;
            PaddingValues paddingValues = contentPadding;
        } else if ((i14 & 7168) == 0) {
            $dirty3 |= $composer2.changed((Object) contentPadding) ? 2048 : 1024;
        } else {
            PaddingValues paddingValues2 = contentPadding;
        }
        int i20 = i16 & 16;
        if (i20 != 0) {
            $dirty3 |= 24576;
            pageSize2 = pageSize;
        } else if ((i14 & 57344) == 0) {
            pageSize2 = pageSize;
            $dirty3 |= $composer2.changed((Object) pageSize2) ? 16384 : 8192;
        } else {
            pageSize2 = pageSize;
        }
        int i21 = i16 & 32;
        if (i21 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            int i22 = beyondBoundsPageCount;
        } else if ((i14 & 458752) == 0) {
            $dirty3 |= $composer2.changed(beyondBoundsPageCount) ? 131072 : 65536;
        } else {
            int i23 = beyondBoundsPageCount;
        }
        int i24 = i16 & 64;
        if (i24 != 0) {
            $dirty3 |= 1572864;
            float f = pageSpacing;
        } else if ((i14 & 3670016) == 0) {
            $dirty3 |= $composer2.changed(pageSpacing) ? 1048576 : 524288;
        } else {
            float f2 = pageSpacing;
        }
        int i25 = i16 & 128;
        if (i25 != 0) {
            $dirty3 |= 12582912;
            i2 = i25;
            Alignment.Vertical vertical = verticalAlignment;
        } else if ((i14 & 29360128) == 0) {
            i2 = i25;
            $dirty3 |= $composer2.changed((Object) verticalAlignment) ? 8388608 : 4194304;
        } else {
            i2 = i25;
            Alignment.Vertical vertical2 = verticalAlignment;
        }
        if ((i14 & 234881024) == 0) {
            if ((i16 & 256) == 0) {
                snapFlingBehavior = flingBehavior;
                if ($composer2.changed((Object) snapFlingBehavior)) {
                    i11 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    $dirty3 |= i11;
                }
            } else {
                snapFlingBehavior = flingBehavior;
            }
            i11 = 33554432;
            $dirty3 |= i11;
        } else {
            snapFlingBehavior = flingBehavior;
        }
        int i26 = i16 & 512;
        if (i26 != 0) {
            $dirty3 |= 805306368;
            i3 = i26;
            boolean z = userScrollEnabled;
        } else if ((i14 & 1879048192) == 0) {
            i3 = i26;
            $dirty3 |= $composer2.changed(userScrollEnabled) ? 536870912 : 268435456;
        } else {
            i3 = i26;
            boolean z2 = userScrollEnabled;
        }
        int i27 = i16 & 1024;
        if (i27 != 0) {
            $dirty12 |= 6;
            i4 = i27;
            boolean z3 = reverseLayout;
        } else if ((i15 & 14) == 0) {
            i4 = i27;
            $dirty12 |= $composer2.changed(reverseLayout) ? 4 : 2;
        } else {
            i4 = i27;
            boolean z4 = reverseLayout;
        }
        int i28 = i16 & 2048;
        if (i28 != 0) {
            $dirty12 |= 48;
            i5 = i28;
            Function1<? super Integer, ? extends Object> function1 = key;
        } else if ((i15 & 112) == 0) {
            i5 = i28;
            $dirty12 |= $composer2.changedInstance(key) ? 32 : 16;
        } else {
            i5 = i28;
            Function1<? super Integer, ? extends Object> function12 = key;
        }
        int i29 = i16 & 4096;
        if (i29 != 0) {
            $dirty12 |= 128;
        }
        if ((i16 & 8192) != 0) {
            $dirty12 |= 3072;
        } else if ((i15 & 7168) == 0) {
            if (!$composer2.changedInstance(function4)) {
                i19 = 1024;
            }
            $dirty12 |= i19;
        }
        int $dirty13 = $dirty12;
        if (i29 == 4096 && (1533916891 & $dirty3) == 306783378 && ($dirty13 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            contentPadding2 = contentPadding;
            beyondBoundsPageCount2 = beyondBoundsPageCount;
            pageSpacing2 = pageSpacing;
            verticalAlignment2 = verticalAlignment;
            userScrollEnabled2 = userScrollEnabled;
            reverseLayout2 = reverseLayout;
            key2 = key;
            pageNestedScrollConnection2 = pageNestedScrollConnection;
            int i30 = $dirty13;
            int i31 = $dirty3;
            flingBehavior2 = snapFlingBehavior;
            pageSize3 = pageSize2;
            modifier3 = modifier2;
            state3 = state2;
        } else {
            $composer2.startDefaults();
            if ((i14 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i17 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i16 & 4) != 0) {
                    Integer valueOf = Integer.valueOf(pageCount);
                    int i32 = $dirty3 & 14;
                    int $dirty4 = $dirty3;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed((Object) valueOf);
                    Composer $this$cache$iv$iv = $composer2;
                    Integer num = valueOf;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (!invalid$iv$iv) {
                        boolean z5 = invalid$iv$iv;
                        if (it$iv$iv != Composer.Companion.getEmpty()) {
                            value$iv$iv = it$iv$iv;
                            Object obj = value$iv$iv;
                            Object it$iv$iv2 = $this$cache$iv$iv;
                            $composer2.endReplaceableGroup();
                            i6 = i29;
                            i10 = i2;
                            i7 = i5;
                            i8 = i4;
                            i9 = i3;
                            state4 = PagerStateKt.rememberPagerState(0, 0.0f, value$iv$iv, $composer2, 0, 3);
                            $dirty2 = $dirty4 & -897;
                        }
                    }
                    value$iv$iv = new PagerKt$HorizontalPager$2$1(i13);
                    Object obj2 = it$iv$iv;
                    $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    $composer2.endReplaceableGroup();
                    i6 = i29;
                    i10 = i2;
                    i7 = i5;
                    i8 = i4;
                    i9 = i3;
                    state4 = PagerStateKt.rememberPagerState(0, 0.0f, value$iv$iv, $composer2, 0, 3);
                    $dirty2 = $dirty4 & -897;
                } else {
                    $dirty2 = $dirty3;
                    i6 = i29;
                    i10 = i2;
                    i7 = i5;
                    i8 = i4;
                    i9 = i3;
                    state4 = state2;
                }
                if (i18 != 0) {
                    contentPadding3 = PaddingKt.m2241PaddingValues0680j_4(Dp.m7554constructorimpl((float) 0));
                } else {
                    contentPadding3 = contentPadding;
                }
                if (i20 != 0) {
                    pageSize4 = PageSize.Fill.INSTANCE;
                } else {
                    pageSize4 = pageSize2;
                }
                if (i21 != 0) {
                    beyondBoundsPageCount3 = 0;
                } else {
                    beyondBoundsPageCount3 = beyondBoundsPageCount;
                }
                if (i24 != 0) {
                    pageSpacing3 = Dp.m7554constructorimpl((float) 0);
                } else {
                    pageSpacing3 = pageSpacing;
                }
                if (i10 != 0) {
                    verticalAlignment3 = Alignment.Companion.getCenterVertically();
                } else {
                    verticalAlignment3 = verticalAlignment;
                }
                if ((i16 & 256) != 0) {
                    flingBehavior4 = PagerDefaults.INSTANCE.m2526flingBehaviorPfoAEA0(state4, (PagerSnapDistance) null, (AnimationSpec<Float>) null, (DecayAnimationSpec<Float>) null, (AnimationSpec<Float>) null, 0.0f, 0.0f, $composer2, (($dirty2 >> 6) & 14) | 12582912, 126);
                    $dirty2 &= -234881025;
                } else {
                    flingBehavior4 = flingBehavior;
                }
                if (i9 != 0) {
                    userScrollEnabled4 = true;
                } else {
                    userScrollEnabled4 = userScrollEnabled;
                }
                if (i8 != 0) {
                    reverseLayout4 = false;
                } else {
                    reverseLayout4 = reverseLayout;
                }
                if (i7 != 0) {
                    key3 = null;
                } else {
                    key3 = key;
                }
                if (i6 != 0) {
                    PagerState state5 = state4;
                    $dirty = $dirty2;
                    $dirty1 = $dirty13 & -897;
                    pageNestedScrollConnection2 = PagerDefaults.INSTANCE.pageNestedScrollConnection(Orientation.Horizontal);
                    flingBehavior3 = flingBehavior4;
                    userScrollEnabled3 = userScrollEnabled4;
                    reverseLayout3 = reverseLayout4;
                    key2 = key3;
                    state2 = state5;
                } else {
                    PagerState state6 = state4;
                    $dirty = $dirty2;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty1 = $dirty13;
                    flingBehavior3 = flingBehavior4;
                    userScrollEnabled3 = userScrollEnabled4;
                    reverseLayout3 = reverseLayout4;
                    key2 = key3;
                    state2 = state6;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i16 & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i16 & 256) != 0) {
                    $dirty3 &= -234881025;
                }
                if (i29 != 0) {
                    $dirty13 &= -897;
                }
                contentPadding3 = contentPadding;
                pageSpacing3 = pageSpacing;
                reverseLayout3 = reverseLayout;
                key2 = key;
                pageNestedScrollConnection2 = pageNestedScrollConnection;
                $dirty1 = $dirty13;
                $dirty = $dirty3;
                flingBehavior3 = snapFlingBehavior;
                pageSize4 = pageSize2;
                beyondBoundsPageCount3 = beyondBoundsPageCount;
                verticalAlignment3 = verticalAlignment;
                userScrollEnabled3 = userScrollEnabled;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1817327312, $dirty, $dirty1, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:212)");
            }
            LazyLayoutPagerKt.m2522Pagerfs30GE4(modifier2, state2, contentPadding3, reverseLayout3, Orientation.Horizontal, flingBehavior3, userScrollEnabled3, beyondBoundsPageCount3, pageSpacing3, pageSize4, pageNestedScrollConnection2, key2, Alignment.Companion.getCenterHorizontally(), verticalAlignment3, pageContent, $composer2, (($dirty >> 3) & 14) | 24576 | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty1 << 9) & 7168) | (($dirty >> 9) & 458752) | (($dirty >> 9) & 3670016) | (($dirty << 6) & 29360128) | (($dirty << 6) & 234881024) | (($dirty << 15) & 1879048192), ($dirty1 & 112) | 392 | (($dirty >> 12) & 7168) | (($dirty1 << 3) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            flingBehavior2 = flingBehavior3;
            userScrollEnabled2 = userScrollEnabled3;
            reverseLayout2 = reverseLayout3;
            contentPadding2 = contentPadding3;
            pageSize3 = pageSize4;
            beyondBoundsPageCount2 = beyondBoundsPageCount3;
            pageSpacing2 = pageSpacing3;
            verticalAlignment2 = verticalAlignment3;
            modifier3 = modifier2;
            state3 = state2;
            int i33 = $dirty1;
            int i34 = $dirty;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new PagerKt$HorizontalPager$3(pageCount, modifier3, state3, contentPadding2, pageSize3, beyondBoundsPageCount2, pageSpacing2, verticalAlignment2, flingBehavior2, userScrollEnabled2, reverseLayout2, key2, pageNestedScrollConnection2, pageContent, $changed, $changed1, i));
    }

    /* renamed from: VerticalPager-xYaah8o  reason: not valid java name */
    public static final void m2530VerticalPagerxYaah8o(PagerState state, Modifier modifier, PaddingValues contentPadding, PageSize pageSize, int beyondBoundsPageCount, float pageSpacing, Alignment.Horizontal horizontalAlignment, SnapFlingBehavior flingBehavior, boolean userScrollEnabled, boolean reverseLayout, Function1<? super Integer, ? extends Object> key, NestedScrollConnection pageNestedScrollConnection, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer $composer, int $changed, int $changed1, int i) {
        Modifier modifier2;
        PageSize pageSize2;
        int i2;
        Alignment.Horizontal horizontal;
        int i3;
        int $dirty;
        int i4;
        Composer $composer2;
        NestedScrollConnection pageNestedScrollConnection2;
        Function1 key2;
        boolean reverseLayout2;
        boolean userScrollEnabled2;
        SnapFlingBehavior flingBehavior2;
        Alignment.Horizontal horizontalAlignment2;
        float pageSpacing2;
        int beyondBoundsPageCount2;
        PageSize pageSize3;
        PaddingValues contentPadding2;
        Modifier modifier3;
        int i5;
        int $dirty1;
        int $dirty2;
        Modifier modifier4;
        PageSize pageSize4;
        int beyondBoundsPageCount3;
        float pageSpacing3;
        Alignment.Horizontal horizontalAlignment3;
        int $dirty12;
        int i6;
        int i7;
        int i8;
        SnapFlingBehavior flingBehavior3;
        boolean userScrollEnabled3;
        boolean reverseLayout3;
        Function1 key3;
        int i9;
        PagerState pagerState = state;
        Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = pageContent;
        int i10 = $changed;
        int i11 = $changed1;
        int i12 = i;
        Intrinsics.checkNotNullParameter(pagerState, "state");
        Intrinsics.checkNotNullParameter(function4, "pageContent");
        Composer $composer3 = $composer.startRestartGroup(-1457068767);
        ComposerKt.sourceInformation($composer3, "C(VerticalPager)P(11,5,1,8!1,9:c#ui.unit.Dp,3!1,12,10!1,7)299@15710L28,308@16058L618:Pager.kt#g6yjnt");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
        if ((i12 & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i10 & 14) == 0) {
            $dirty3 |= $composer3.changed((Object) pagerState) ? 4 : 2;
        }
        int i13 = i12 & 2;
        if (i13 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if ((i10 & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i14 = i12 & 4;
        if (i14 != 0) {
            $dirty3 |= 384;
            PaddingValues paddingValues = contentPadding;
        } else if ((i10 & 896) == 0) {
            $dirty3 |= $composer3.changed((Object) contentPadding) ? 256 : 128;
        } else {
            PaddingValues paddingValues2 = contentPadding;
        }
        int i15 = i12 & 8;
        if (i15 != 0) {
            $dirty3 |= 3072;
            pageSize2 = pageSize;
        } else if ((i10 & 7168) == 0) {
            pageSize2 = pageSize;
            $dirty3 |= $composer3.changed((Object) pageSize2) ? 2048 : 1024;
        } else {
            pageSize2 = pageSize;
        }
        int i16 = i12 & 16;
        if (i16 != 0) {
            $dirty3 |= 24576;
            i2 = beyondBoundsPageCount;
        } else if ((i10 & 57344) == 0) {
            i2 = beyondBoundsPageCount;
            $dirty3 |= $composer3.changed(i2) ? 16384 : 8192;
        } else {
            i2 = beyondBoundsPageCount;
        }
        int i17 = i12 & 32;
        if (i17 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            float f = pageSpacing;
        } else if ((i10 & 458752) == 0) {
            $dirty3 |= $composer3.changed(pageSpacing) ? 131072 : 65536;
        } else {
            float f2 = pageSpacing;
        }
        int i18 = i12 & 64;
        if (i18 != 0) {
            $dirty3 |= 1572864;
            horizontal = horizontalAlignment;
        } else if ((i10 & 3670016) == 0) {
            horizontal = horizontalAlignment;
            $dirty3 |= $composer3.changed((Object) horizontal) ? 1048576 : 524288;
        } else {
            horizontal = horizontalAlignment;
        }
        if ((i10 & 29360128) == 0) {
            if ((i12 & 128) != 0) {
                SnapFlingBehavior snapFlingBehavior = flingBehavior;
            } else if ($composer3.changed((Object) flingBehavior)) {
                i9 = 8388608;
                $dirty3 |= i9;
            }
            i9 = 4194304;
            $dirty3 |= i9;
        } else {
            SnapFlingBehavior snapFlingBehavior2 = flingBehavior;
        }
        int i19 = i12 & 256;
        if (i19 != 0) {
            $dirty3 |= 100663296;
            i3 = i19;
            boolean z = userScrollEnabled;
        } else if ((i10 & 234881024) == 0) {
            i3 = i19;
            $dirty3 |= $composer3.changed(userScrollEnabled) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i19;
            boolean z2 = userScrollEnabled;
        }
        int i20 = i12 & 512;
        if (i20 != 0) {
            $dirty = $dirty3 | 805306368;
            i4 = i20;
            boolean z3 = reverseLayout;
        } else {
            if ((i10 & 1879048192) == 0) {
                i4 = i20;
                $dirty3 |= $composer3.changed(reverseLayout) ? 536870912 : 268435456;
            } else {
                i4 = i20;
                boolean z4 = reverseLayout;
            }
            $dirty = $dirty3;
        }
        int $dirty4 = i12 & 1024;
        if ($dirty4 != 0) {
            $dirty13 |= 6;
            Function1<? super Integer, ? extends Object> function1 = key;
        } else if ((i11 & 14) == 0) {
            $dirty13 |= $composer3.changedInstance(key) ? 4 : 2;
        } else {
            Function1<? super Integer, ? extends Object> function12 = key;
        }
        int i21 = i12 & 2048;
        if (i21 != 0) {
            $dirty13 |= 16;
        }
        int i22 = $dirty4;
        if ((i12 & 4096) != 0) {
            $dirty13 |= 384;
        } else if ((i11 & 896) == 0) {
            $dirty13 |= $composer3.changedInstance(function4) ? 256 : 128;
        }
        if (i21 == 2048 && ($dirty & 1533916891) == 306783378 && ($dirty13 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            contentPadding2 = contentPadding;
            pageSpacing2 = pageSpacing;
            flingBehavior2 = flingBehavior;
            userScrollEnabled2 = userScrollEnabled;
            key2 = key;
            pageNestedScrollConnection2 = pageNestedScrollConnection;
            int i23 = $dirty13;
            horizontalAlignment2 = horizontal;
            modifier3 = modifier2;
            pageSize3 = pageSize2;
            beyondBoundsPageCount2 = i2;
            $composer2 = $composer3;
            int i24 = $dirty;
            reverseLayout2 = reverseLayout;
        } else {
            $composer3.startDefaults();
            if ((i10 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i13 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i14 != 0) {
                    contentPadding2 = PaddingKt.m2241PaddingValues0680j_4(Dp.m7554constructorimpl((float) 0));
                } else {
                    contentPadding2 = contentPadding;
                }
                if (i15 != 0) {
                    pageSize4 = PageSize.Fill.INSTANCE;
                } else {
                    pageSize4 = pageSize2;
                }
                if (i16 != 0) {
                    beyondBoundsPageCount3 = 0;
                } else {
                    beyondBoundsPageCount3 = i2;
                }
                if (i17 != 0) {
                    pageSpacing3 = Dp.m7554constructorimpl((float) 0);
                } else {
                    pageSpacing3 = pageSpacing;
                }
                if (i18 != 0) {
                    horizontalAlignment3 = Alignment.Companion.getCenterHorizontally();
                } else {
                    horizontalAlignment3 = horizontal;
                }
                if ((i12 & 128) != 0) {
                    $dirty12 = $dirty13;
                    $composer2 = $composer3;
                    i8 = i3;
                    i7 = i4;
                    i5 = -1457068767;
                    i6 = i21;
                    flingBehavior3 = PagerDefaults.INSTANCE.m2526flingBehaviorPfoAEA0(state, (PagerSnapDistance) null, (AnimationSpec<Float>) null, (DecayAnimationSpec<Float>) null, (AnimationSpec<Float>) null, 0.0f, 0.0f, $composer3, ($dirty & 14) | 12582912, 126);
                    $dirty &= -29360129;
                } else {
                    $dirty12 = $dirty13;
                    $composer2 = $composer3;
                    i8 = i3;
                    i7 = i4;
                    i5 = -1457068767;
                    i6 = i21;
                    flingBehavior3 = flingBehavior;
                }
                if (i8 != 0) {
                    userScrollEnabled3 = true;
                } else {
                    userScrollEnabled3 = userScrollEnabled;
                }
                if (i7 != 0) {
                    reverseLayout3 = false;
                } else {
                    reverseLayout3 = reverseLayout;
                }
                if (i22 != 0) {
                    key3 = null;
                } else {
                    key3 = key;
                }
                if (i6 != 0) {
                    int i25 = $dirty12 & -113;
                    flingBehavior2 = flingBehavior3;
                    userScrollEnabled2 = userScrollEnabled3;
                    key2 = key3;
                    pageNestedScrollConnection2 = PagerDefaults.INSTANCE.pageNestedScrollConnection(Orientation.Vertical);
                    $dirty1 = i25;
                    beyondBoundsPageCount2 = beyondBoundsPageCount3;
                    horizontalAlignment2 = horizontalAlignment3;
                    $dirty2 = $dirty;
                    reverseLayout2 = reverseLayout3;
                    modifier3 = modifier4;
                    pageSpacing2 = pageSpacing3;
                    pageSize3 = pageSize4;
                } else {
                    flingBehavior2 = flingBehavior3;
                    userScrollEnabled2 = userScrollEnabled3;
                    key2 = key3;
                    beyondBoundsPageCount2 = beyondBoundsPageCount3;
                    horizontalAlignment2 = horizontalAlignment3;
                    $dirty2 = $dirty;
                    $dirty1 = $dirty12;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    reverseLayout2 = reverseLayout3;
                    modifier3 = modifier4;
                    pageSpacing2 = pageSpacing3;
                    pageSize3 = pageSize4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i12 & 128) != 0) {
                    $dirty &= -29360129;
                }
                if (i21 != 0) {
                    contentPadding2 = contentPadding;
                    pageSpacing2 = pageSpacing;
                    flingBehavior2 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    key2 = key;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty1 = $dirty13 & -113;
                    horizontalAlignment2 = horizontal;
                    modifier3 = modifier2;
                    pageSize3 = pageSize2;
                    beyondBoundsPageCount2 = i2;
                    $composer2 = $composer3;
                    $dirty2 = $dirty;
                    i5 = -1457068767;
                    reverseLayout2 = reverseLayout;
                } else {
                    contentPadding2 = contentPadding;
                    pageSpacing2 = pageSpacing;
                    flingBehavior2 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    key2 = key;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty1 = $dirty13;
                    horizontalAlignment2 = horizontal;
                    modifier3 = modifier2;
                    pageSize3 = pageSize2;
                    beyondBoundsPageCount2 = i2;
                    $composer2 = $composer3;
                    $dirty2 = $dirty;
                    i5 = -1457068767;
                    reverseLayout2 = reverseLayout;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i5, $dirty2, $dirty1, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:291)");
            }
            int i26 = $dirty2;
            int i27 = $dirty1;
            LazyLayoutPagerKt.m2522Pagerfs30GE4(modifier3, state, contentPadding2, reverseLayout2, Orientation.Vertical, flingBehavior2, userScrollEnabled2, beyondBoundsPageCount2, pageSpacing2, pageSize3, pageNestedScrollConnection2, key2, horizontalAlignment2, Alignment.Companion.getCenterVertically(), pageContent, $composer2, (($dirty2 >> 3) & 14) | 24576 | (($dirty2 << 3) & 112) | ($dirty2 & 896) | (($dirty2 >> 18) & 7168) | (($dirty2 >> 6) & 458752) | (($dirty2 >> 6) & 3670016) | (($dirty2 << 9) & 29360128) | (($dirty2 << 9) & 234881024) | (($dirty2 << 18) & 1879048192), (($dirty1 << 3) & 112) | 3080 | (($dirty2 >> 12) & 896) | (($dirty1 << 6) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PagerKt$VerticalPager$1(state, modifier3, contentPadding2, pageSize3, beyondBoundsPageCount2, pageSpacing2, horizontalAlignment2, flingBehavior2, userScrollEnabled2, reverseLayout2, key2, pageNestedScrollConnection2, pageContent, $changed, $changed1, i));
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Please use the overload without pageCount. pageCount should be provided through PagerState.", replaceWith = @ReplaceWith(expression = "VerticalPager(\n            modifier = modifier,\n            state = state,\n            pageSpacing = pageSpacing,\n            horizontalAlignment = horizontalAlignment,\n            userScrollEnabled = userScrollEnabled,\n            reverseLayout = reverseLayout,\n            contentPadding = contentPadding,\n            beyondBoundsPageCount = beyondBoundsPageCount,\n            pageSize = pageSize,\n            flingBehavior = flingBehavior,\n            key = key,\n            pageNestedScrollConnection = pageNestedScrollConnection,\n            pageContent = pageContent\n        )", imports = {"androidx.compose.foundation.gestures.Orientation", "androidx.compose.foundation.layout.PaddingValues", "androidx.compose.foundation.pager.PageSize", "androidx.compose.foundation.pager.PagerDefaults"}))
    /* renamed from: VerticalPager-AlbwjTQ  reason: not valid java name */
    public static final void m2529VerticalPagerAlbwjTQ(int pageCount, Modifier modifier, PagerState state, PaddingValues contentPadding, PageSize pageSize, int beyondBoundsPageCount, float pageSpacing, Alignment.Horizontal horizontalAlignment, SnapFlingBehavior flingBehavior, boolean userScrollEnabled, boolean reverseLayout, Function1<? super Integer, ? extends Object> key, NestedScrollConnection pageNestedScrollConnection, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer $composer, int $changed, int $changed1, int i) {
        Modifier modifier2;
        PagerState state2;
        PageSize pageSize2;
        int i2;
        SnapFlingBehavior snapFlingBehavior;
        int i3;
        int i4;
        int i5;
        NestedScrollConnection pageNestedScrollConnection2;
        Function1 key2;
        boolean reverseLayout2;
        boolean userScrollEnabled2;
        SnapFlingBehavior flingBehavior2;
        Alignment.Horizontal horizontalAlignment2;
        float pageSpacing2;
        int beyondBoundsPageCount2;
        PageSize pageSize3;
        PaddingValues contentPadding2;
        PagerState state3;
        Modifier modifier3;
        int $dirty;
        int $dirty1;
        Alignment.Horizontal horizontalAlignment3;
        float pageSpacing3;
        int beyondBoundsPageCount3;
        PageSize pageSize4;
        PaddingValues contentPadding3;
        boolean reverseLayout3;
        boolean userScrollEnabled3;
        SnapFlingBehavior flingBehavior3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int $dirty2;
        PagerState state4;
        SnapFlingBehavior flingBehavior4;
        boolean userScrollEnabled4;
        boolean reverseLayout4;
        Function1 key3;
        Function0 value$iv$iv;
        int i11;
        int i12;
        int i13 = pageCount;
        Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = pageContent;
        int i14 = $changed;
        int i15 = $changed1;
        int i16 = i;
        Intrinsics.checkNotNullParameter(function4, "pageContent");
        Composer $composer2 = $composer.startRestartGroup(-1904588400);
        ComposerKt.sourceInformation($composer2, "C(VerticalPager)P(7,5,12,1,9!1,10:c#ui.unit.Dp,3!1,13,11!1,8)400@20798L13,400@20779L32,406@21105L28,415@21453L618:Pager.kt#g6yjnt");
        int $dirty3 = $changed;
        int $dirty12 = $changed1;
        if ((i16 & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i14 & 14) == 0) {
            $dirty3 |= $composer2.changed(i13) ? 4 : 2;
        }
        int i17 = i16 & 2;
        if (i17 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if ((i14 & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i14 & 896) == 0) {
            if ((i16 & 4) == 0) {
                state2 = state;
                if ($composer2.changed((Object) state2)) {
                    i12 = 256;
                    $dirty3 |= i12;
                }
            } else {
                state2 = state;
            }
            i12 = 128;
            $dirty3 |= i12;
        } else {
            state2 = state;
        }
        int i18 = i16 & 8;
        int i19 = 2048;
        if (i18 != 0) {
            $dirty3 |= 3072;
            PaddingValues paddingValues = contentPadding;
        } else if ((i14 & 7168) == 0) {
            $dirty3 |= $composer2.changed((Object) contentPadding) ? 2048 : 1024;
        } else {
            PaddingValues paddingValues2 = contentPadding;
        }
        int i20 = i16 & 16;
        if (i20 != 0) {
            $dirty3 |= 24576;
            pageSize2 = pageSize;
        } else if ((i14 & 57344) == 0) {
            pageSize2 = pageSize;
            $dirty3 |= $composer2.changed((Object) pageSize2) ? 16384 : 8192;
        } else {
            pageSize2 = pageSize;
        }
        int i21 = i16 & 32;
        if (i21 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            int i22 = beyondBoundsPageCount;
        } else if ((i14 & 458752) == 0) {
            $dirty3 |= $composer2.changed(beyondBoundsPageCount) ? 131072 : 65536;
        } else {
            int i23 = beyondBoundsPageCount;
        }
        int i24 = i16 & 64;
        if (i24 != 0) {
            $dirty3 |= 1572864;
            float f = pageSpacing;
        } else if ((i14 & 3670016) == 0) {
            $dirty3 |= $composer2.changed(pageSpacing) ? 1048576 : 524288;
        } else {
            float f2 = pageSpacing;
        }
        int i25 = i16 & 128;
        if (i25 != 0) {
            $dirty3 |= 12582912;
            i2 = i25;
            Alignment.Horizontal horizontal = horizontalAlignment;
        } else if ((i14 & 29360128) == 0) {
            i2 = i25;
            $dirty3 |= $composer2.changed((Object) horizontalAlignment) ? 8388608 : 4194304;
        } else {
            i2 = i25;
            Alignment.Horizontal horizontal2 = horizontalAlignment;
        }
        if ((i14 & 234881024) == 0) {
            if ((i16 & 256) == 0) {
                snapFlingBehavior = flingBehavior;
                if ($composer2.changed((Object) snapFlingBehavior)) {
                    i11 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    $dirty3 |= i11;
                }
            } else {
                snapFlingBehavior = flingBehavior;
            }
            i11 = 33554432;
            $dirty3 |= i11;
        } else {
            snapFlingBehavior = flingBehavior;
        }
        int i26 = i16 & 512;
        if (i26 != 0) {
            $dirty3 |= 805306368;
            i3 = i26;
            boolean z = userScrollEnabled;
        } else if ((i14 & 1879048192) == 0) {
            i3 = i26;
            $dirty3 |= $composer2.changed(userScrollEnabled) ? 536870912 : 268435456;
        } else {
            i3 = i26;
            boolean z2 = userScrollEnabled;
        }
        int i27 = i16 & 1024;
        if (i27 != 0) {
            $dirty12 |= 6;
            i4 = i27;
            boolean z3 = reverseLayout;
        } else if ((i15 & 14) == 0) {
            i4 = i27;
            $dirty12 |= $composer2.changed(reverseLayout) ? 4 : 2;
        } else {
            i4 = i27;
            boolean z4 = reverseLayout;
        }
        int i28 = i16 & 2048;
        if (i28 != 0) {
            $dirty12 |= 48;
            i5 = i28;
            Function1<? super Integer, ? extends Object> function1 = key;
        } else if ((i15 & 112) == 0) {
            i5 = i28;
            $dirty12 |= $composer2.changedInstance(key) ? 32 : 16;
        } else {
            i5 = i28;
            Function1<? super Integer, ? extends Object> function12 = key;
        }
        int i29 = i16 & 4096;
        if (i29 != 0) {
            $dirty12 |= 128;
        }
        if ((i16 & 8192) != 0) {
            $dirty12 |= 3072;
        } else if ((i15 & 7168) == 0) {
            if (!$composer2.changedInstance(function4)) {
                i19 = 1024;
            }
            $dirty12 |= i19;
        }
        int $dirty13 = $dirty12;
        if (i29 == 4096 && (1533916891 & $dirty3) == 306783378 && ($dirty13 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            contentPadding2 = contentPadding;
            beyondBoundsPageCount2 = beyondBoundsPageCount;
            pageSpacing2 = pageSpacing;
            horizontalAlignment2 = horizontalAlignment;
            userScrollEnabled2 = userScrollEnabled;
            reverseLayout2 = reverseLayout;
            key2 = key;
            pageNestedScrollConnection2 = pageNestedScrollConnection;
            int i30 = $dirty13;
            int i31 = $dirty3;
            flingBehavior2 = snapFlingBehavior;
            pageSize3 = pageSize2;
            modifier3 = modifier2;
            state3 = state2;
        } else {
            $composer2.startDefaults();
            if ((i14 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i17 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i16 & 4) != 0) {
                    Integer valueOf = Integer.valueOf(pageCount);
                    int i32 = $dirty3 & 14;
                    int $dirty4 = $dirty3;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed((Object) valueOf);
                    Composer $this$cache$iv$iv = $composer2;
                    Integer num = valueOf;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (!invalid$iv$iv) {
                        boolean z5 = invalid$iv$iv;
                        if (it$iv$iv != Composer.Companion.getEmpty()) {
                            value$iv$iv = it$iv$iv;
                            Object obj = value$iv$iv;
                            Object it$iv$iv2 = $this$cache$iv$iv;
                            $composer2.endReplaceableGroup();
                            i6 = i29;
                            i10 = i2;
                            i7 = i5;
                            i8 = i4;
                            i9 = i3;
                            state4 = PagerStateKt.rememberPagerState(0, 0.0f, value$iv$iv, $composer2, 0, 3);
                            $dirty2 = $dirty4 & -897;
                        }
                    }
                    value$iv$iv = new PagerKt$VerticalPager$2$1(i13);
                    Object obj2 = it$iv$iv;
                    $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    $composer2.endReplaceableGroup();
                    i6 = i29;
                    i10 = i2;
                    i7 = i5;
                    i8 = i4;
                    i9 = i3;
                    state4 = PagerStateKt.rememberPagerState(0, 0.0f, value$iv$iv, $composer2, 0, 3);
                    $dirty2 = $dirty4 & -897;
                } else {
                    $dirty2 = $dirty3;
                    i6 = i29;
                    i10 = i2;
                    i7 = i5;
                    i8 = i4;
                    i9 = i3;
                    state4 = state2;
                }
                if (i18 != 0) {
                    contentPadding3 = PaddingKt.m2241PaddingValues0680j_4(Dp.m7554constructorimpl((float) 0));
                } else {
                    contentPadding3 = contentPadding;
                }
                if (i20 != 0) {
                    pageSize4 = PageSize.Fill.INSTANCE;
                } else {
                    pageSize4 = pageSize2;
                }
                if (i21 != 0) {
                    beyondBoundsPageCount3 = 0;
                } else {
                    beyondBoundsPageCount3 = beyondBoundsPageCount;
                }
                if (i24 != 0) {
                    pageSpacing3 = Dp.m7554constructorimpl((float) 0);
                } else {
                    pageSpacing3 = pageSpacing;
                }
                if (i10 != 0) {
                    horizontalAlignment3 = Alignment.Companion.getCenterHorizontally();
                } else {
                    horizontalAlignment3 = horizontalAlignment;
                }
                if ((i16 & 256) != 0) {
                    flingBehavior4 = PagerDefaults.INSTANCE.m2526flingBehaviorPfoAEA0(state4, (PagerSnapDistance) null, (AnimationSpec<Float>) null, (DecayAnimationSpec<Float>) null, (AnimationSpec<Float>) null, 0.0f, 0.0f, $composer2, (($dirty2 >> 6) & 14) | 12582912, 126);
                    $dirty2 &= -234881025;
                } else {
                    flingBehavior4 = flingBehavior;
                }
                if (i9 != 0) {
                    userScrollEnabled4 = true;
                } else {
                    userScrollEnabled4 = userScrollEnabled;
                }
                if (i8 != 0) {
                    reverseLayout4 = false;
                } else {
                    reverseLayout4 = reverseLayout;
                }
                if (i7 != 0) {
                    key3 = null;
                } else {
                    key3 = key;
                }
                if (i6 != 0) {
                    PagerState state5 = state4;
                    $dirty = $dirty2;
                    $dirty1 = $dirty13 & -897;
                    pageNestedScrollConnection2 = PagerDefaults.INSTANCE.pageNestedScrollConnection(Orientation.Vertical);
                    flingBehavior3 = flingBehavior4;
                    userScrollEnabled3 = userScrollEnabled4;
                    reverseLayout3 = reverseLayout4;
                    key2 = key3;
                    state2 = state5;
                } else {
                    PagerState state6 = state4;
                    $dirty = $dirty2;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty1 = $dirty13;
                    flingBehavior3 = flingBehavior4;
                    userScrollEnabled3 = userScrollEnabled4;
                    reverseLayout3 = reverseLayout4;
                    key2 = key3;
                    state2 = state6;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i16 & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i16 & 256) != 0) {
                    $dirty3 &= -234881025;
                }
                if (i29 != 0) {
                    $dirty13 &= -897;
                }
                contentPadding3 = contentPadding;
                pageSpacing3 = pageSpacing;
                reverseLayout3 = reverseLayout;
                key2 = key;
                pageNestedScrollConnection2 = pageNestedScrollConnection;
                $dirty1 = $dirty13;
                $dirty = $dirty3;
                flingBehavior3 = snapFlingBehavior;
                pageSize4 = pageSize2;
                beyondBoundsPageCount3 = beyondBoundsPageCount;
                horizontalAlignment3 = horizontalAlignment;
                userScrollEnabled3 = userScrollEnabled;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1904588400, $dirty, $dirty1, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:397)");
            }
            LazyLayoutPagerKt.m2522Pagerfs30GE4(modifier2, state2, contentPadding3, reverseLayout3, Orientation.Vertical, flingBehavior3, userScrollEnabled3, beyondBoundsPageCount3, pageSpacing3, pageSize4, pageNestedScrollConnection2, key2, horizontalAlignment3, Alignment.Companion.getCenterVertically(), pageContent, $composer2, (($dirty >> 3) & 14) | 24576 | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty1 << 9) & 7168) | (($dirty >> 9) & 458752) | (($dirty >> 9) & 3670016) | (($dirty << 6) & 29360128) | (($dirty << 6) & 234881024) | (($dirty << 15) & 1879048192), ($dirty1 & 112) | 3080 | (($dirty >> 15) & 896) | (($dirty1 << 3) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            flingBehavior2 = flingBehavior3;
            userScrollEnabled2 = userScrollEnabled3;
            reverseLayout2 = reverseLayout3;
            contentPadding2 = contentPadding3;
            pageSize3 = pageSize4;
            beyondBoundsPageCount2 = beyondBoundsPageCount3;
            pageSpacing2 = pageSpacing3;
            horizontalAlignment2 = horizontalAlignment3;
            modifier3 = modifier2;
            state3 = state2;
            int i33 = $dirty1;
            int i34 = $dirty;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new PagerKt$VerticalPager$3(pageCount, modifier3, state3, contentPadding2, pageSize3, beyondBoundsPageCount2, pageSpacing2, horizontalAlignment2, flingBehavior2, userScrollEnabled2, reverseLayout2, key2, pageNestedScrollConnection2, pageContent, $changed, $changed1, i));
    }

    /* access modifiers changed from: private */
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(PagerState pagerState, PagerSnapDistance pagerSnapDistance, DecayAnimationSpec<Float> decayAnimationSpec, float snapPositionalThreshold) {
        return new PagerKt$SnapLayoutInfoProvider$1(pagerState, snapPositionalThreshold, decayAnimationSpec, pagerSnapDistance);
    }

    public static final Modifier pagerSemantics(Modifier $this$pagerSemantics, PagerState state, boolean isVertical, Composer $composer, int $changed) {
        Object value$iv$iv$iv;
        Modifier modifier = $this$pagerSemantics;
        PagerState pagerState = state;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(pagerState, "state");
        composer.startReplaceableGroup(1509835088);
        ComposerKt.sourceInformation(composer, "C(pagerSemantics)P(1)843@38529L24:Pager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1509835088, $changed, -1, "androidx.compose.foundation.pager.pagerSemantics (Pager.kt:842)");
        } else {
            int i = $changed;
        }
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)488@20446L144:Effects.kt#9igjgp");
        Composer composer$iv = $composer;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv$iv = $composer;
        Object it$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
        if (it$iv$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer$iv));
            $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
        } else {
            value$iv$iv$iv = it$iv$iv$iv;
        }
        $composer.endReplaceableGroup();
        CoroutineScope scope = ((CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv).getCoroutineScope();
        $composer.endReplaceableGroup();
        Modifier then = modifier.then(SemanticsModifierKt.semantics$default(Modifier.Companion, false, new PagerKt$pagerSemantics$1(isVertical, pagerState, scope), 1, (Object) null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return then;
    }

    /* access modifiers changed from: private */
    public static final boolean pagerSemantics$performForwardPaging(PagerState $state, CoroutineScope scope) {
        if (!$state.getCanScrollForward()) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new PagerKt$pagerSemantics$performForwardPaging$1($state, (Continuation<? super PagerKt$pagerSemantics$performForwardPaging$1>) null), 3, (Object) null);
        return true;
    }

    /* access modifiers changed from: private */
    public static final boolean pagerSemantics$performBackwardPaging(PagerState $state, CoroutineScope scope) {
        if (!$state.getCanScrollBackward()) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new PagerKt$pagerSemantics$performBackwardPaging$1($state, (Continuation<? super PagerKt$pagerSemantics$performBackwardPaging$1>) null), 3, (Object) null);
        return true;
    }

    private static final void debugLog(Function0<String> generateMsg) {
    }

    /* access modifiers changed from: private */
    public static final boolean isScrollingForward(PagerState $this$isScrollingForward) {
        return dragGestureDelta($this$isScrollingForward) < 0.0f;
    }

    /* access modifiers changed from: private */
    public static final float dragGestureDelta(PagerState $this$dragGestureDelta) {
        if ($this$dragGestureDelta.getLayoutInfo$foundation_release().getOrientation() == Orientation.Horizontal) {
            return Offset.m4713getXimpl($this$dragGestureDelta.m2539getUpDownDifferenceF1C5BW0$foundation_release());
        }
        return Offset.m4714getYimpl($this$dragGestureDelta.m2539getUpDownDifferenceF1C5BW0$foundation_release());
    }
}

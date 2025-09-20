package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000M\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0018\u001a\u0017\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\b\u001a!\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010#\u001a/\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100\u001dH\u0007¢\u0006\u0002\u0010%\u001a\u0015\u0010&\u001a\u00020\u001b*\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010'\u001a\u0015\u0010(\u001a\u00020\u001b*\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010'\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u001a\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\u0016\"\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"DEBUG", "", "DefaultPositionThreshold", "Landroidx/compose/ui/unit/Dp;", "getDefaultPositionThreshold", "()F", "F", "EmptyLayoutInfo", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getEmptyLayoutInfo$annotations", "()V", "getEmptyLayoutInfo", "()Landroidx/compose/foundation/pager/PagerLayoutInfo;", "MaxPageOffset", "", "MaxPagesForAnimateScroll", "", "MinPageOffset", "SnapAlignmentStartToStart", "Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "getSnapAlignmentStartToStart$annotations", "getSnapAlignmentStartToStart", "()Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "UnitDensity", "androidx/compose/foundation/pager/PagerStateKt$UnitDensity$1", "Landroidx/compose/foundation/pager/PagerStateKt$UnitDensity$1;", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "rememberPagerState", "Landroidx/compose/foundation/pager/PagerState;", "initialPage", "initialPageOffsetFraction", "(IFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/pager/PagerState;", "pageCount", "(IFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/pager/PagerState;", "animateToNextPage", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToPreviousPage", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
public final class PagerStateKt {
    private static final boolean DEBUG = false;
    private static final float DefaultPositionThreshold = Dp.m7554constructorimpl((float) 56);
    private static final PagerLayoutInfo EmptyLayoutInfo = new PagerStateKt$EmptyLayoutInfo$1();
    private static final float MaxPageOffset = 0.5f;
    private static final int MaxPagesForAnimateScroll = 3;
    private static final float MinPageOffset = -0.5f;
    private static final SnapPositionInLayout SnapAlignmentStartToStart = PagerStateKt$SnapAlignmentStartToStart$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final PagerStateKt$UnitDensity$1 UnitDensity = new PagerStateKt$UnitDensity$1();

    public static /* synthetic */ void getEmptyLayoutInfo$annotations() {
    }

    public static /* synthetic */ void getSnapAlignmentStartToStart$annotations() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.pager.PagerState rememberPagerState(int r17, float r18, kotlin.jvm.functions.Function0<java.lang.Integer> r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r0 = r19
            r8 = r20
            r9 = r21
            java.lang.String r1 = "pageCount"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = -1210768637(0xffffffffb7d52303, float:-2.5407882E-5)
            r8.startReplaceableGroup(r1)
            java.lang.String r2 = "C(rememberPagerState)*78@3520L127,78@3473L174:PagerState.kt#g6yjnt"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            r2 = r22 & 1
            if (r2 == 0) goto L_0x001e
            r2 = 0
            r10 = r2
            goto L_0x0020
        L_0x001e:
            r10 = r17
        L_0x0020:
            r2 = r22 & 2
            if (r2 == 0) goto L_0x0027
            r2 = 0
            r11 = r2
            goto L_0x0029
        L_0x0027:
            r11 = r18
        L_0x0029:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0035
            r2 = -1
            java.lang.String r3 = "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:73)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r9, r2, r3)
        L_0x0035:
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            androidx.compose.foundation.pager.PagerStateImpl$Companion r2 = androidx.compose.foundation.pager.PagerStateImpl.Companion
            androidx.compose.runtime.saveable.Saver r2 = r2.getSaver()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            java.lang.Float r4 = java.lang.Float.valueOf(r11)
            r5 = r9 & 14
            r6 = r9 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            r6 = r9 & 896(0x380, float:1.256E-42)
            r5 = r5 | r6
            r6 = 0
            r7 = 1618982084(0x607fb4c4, float:7.370227E19)
            r8.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r7)
            boolean r7 = r8.changed((java.lang.Object) r3)
            boolean r12 = r8.changed((java.lang.Object) r4)
            r7 = r7 | r12
            boolean r12 = r8.changed((java.lang.Object) r0)
            r7 = r7 | r12
            r12 = r20
            r13 = 0
            java.lang.Object r14 = r12.rememberedValue()
            r15 = 0
            if (r7 != 0) goto L_0x0080
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r17 = r3
            java.lang.Object r3 = r16.getEmpty()
            if (r14 != r3) goto L_0x007e
            goto L_0x0082
        L_0x007e:
            r3 = r14
            goto L_0x0091
        L_0x0080:
            r17 = r3
        L_0x0082:
            r3 = 0
            r18 = r3
            androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1 r3 = new androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1
            r3.<init>(r10, r11, r0)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r12.updateRememberedValue(r3)
        L_0x0091:
            r20.endReplaceableGroup()
            r4 = r3
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r3 = 0
            r6 = 72
            r7 = 4
            r5 = r20
            java.lang.Object r1 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            r2 = r1
            androidx.compose.foundation.pager.PagerStateImpl r2 = (androidx.compose.foundation.pager.PagerStateImpl) r2
            r3 = 0
            androidx.compose.runtime.MutableState r4 = r2.getPageCountState()
            r4.setValue(r0)
            androidx.compose.foundation.pager.PagerStateImpl r1 = (androidx.compose.foundation.pager.PagerStateImpl) r1
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00ba
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00ba:
            r20.endReplaceableGroup()
            androidx.compose.foundation.pager.PagerState r1 = (androidx.compose.foundation.pager.PagerState) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerStateKt.rememberPagerState(int, float, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):androidx.compose.foundation.pager.PagerState");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Please use the overload where you can provide a source of truth for the pageCount.", replaceWith = @ReplaceWith(expression = "rememberPagerState(\n                initialPage = initialPage,\n                initialPageOffsetFraction = initialPageOffsetFraction\n            ){\n                // provide pageCount\n            }", imports = {}))
    public static final PagerState rememberPagerState(int initialPage, float initialPageOffsetFraction, Composer $composer, int $changed, int i) {
        float initialPageOffsetFraction2;
        Object key1$iv;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(144687223);
        ComposerKt.sourceInformation(composer, "C(rememberPagerState)117@4766L152,117@4719L199:PagerState.kt#g6yjnt");
        int initialPage2 = (i & 1) != 0 ? 0 : initialPage;
        if ((i & 2) != 0) {
            initialPageOffsetFraction2 = 0.0f;
        } else {
            initialPageOffsetFraction2 = initialPageOffsetFraction;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(144687223, i2, -1, "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:113)");
        }
        Object[] objArr = new Object[0];
        Saver saver = PagerStateImpl.Companion.getSaver();
        Integer valueOf = Integer.valueOf(initialPage2);
        Object key2$iv = Float.valueOf(initialPageOffsetFraction2);
        int i3 = (i2 & 14) | (i2 & 112);
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) valueOf) | composer.changed(key2$iv);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            Integer num = valueOf;
            key1$iv = (Function0) new PagerStateKt$rememberPagerState$3$1(initialPage2, initialPageOffsetFraction2);
            $this$cache$iv$iv.updateRememberedValue(key1$iv);
        } else {
            Integer num2 = valueOf;
            key1$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        PagerStateImpl pagerStateImpl = (PagerStateImpl) RememberSaveableKt.rememberSaveable(objArr, saver, (String) null, key1$iv, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return pagerStateImpl;
    }

    public static final Object animateToNextPage(PagerState $this$animateToNextPage, Continuation<? super Unit> $completion) {
        if ($this$animateToNextPage.getCurrentPage() + 1 >= $this$animateToNextPage.getPageCount()) {
            return Unit.INSTANCE;
        }
        Object animateScrollToPage$default = PagerState.animateScrollToPage$default($this$animateToNextPage, $this$animateToNextPage.getCurrentPage() + 1, 0.0f, (AnimationSpec) null, $completion, 6, (Object) null);
        return animateScrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToPage$default : Unit.INSTANCE;
    }

    public static final Object animateToPreviousPage(PagerState $this$animateToPreviousPage, Continuation<? super Unit> $completion) {
        if ($this$animateToPreviousPage.getCurrentPage() - 1 < 0) {
            return Unit.INSTANCE;
        }
        Object animateScrollToPage$default = PagerState.animateScrollToPage$default($this$animateToPreviousPage, $this$animateToPreviousPage.getCurrentPage() - 1, 0.0f, (AnimationSpec) null, $completion, 6, (Object) null);
        return animateScrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToPage$default : Unit.INSTANCE;
    }

    public static final float getDefaultPositionThreshold() {
        return DefaultPositionThreshold;
    }

    public static final PagerLayoutInfo getEmptyLayoutInfo() {
        return EmptyLayoutInfo;
    }

    public static final SnapPositionInLayout getSnapAlignmentStartToStart() {
        return SnapAlignmentStartToStart;
    }

    private static final void debugLog(Function0<String> generateMsg) {
    }
}

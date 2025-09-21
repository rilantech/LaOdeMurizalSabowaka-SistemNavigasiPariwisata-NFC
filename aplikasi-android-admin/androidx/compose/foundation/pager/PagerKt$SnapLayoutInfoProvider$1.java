package androidx.compose.foundation.pager;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\f\u0010\n\u001a\u00020\u0007*\u00020\bH\u0016J\u0014\u0010\u000b\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\n\u0010\r\u001a\u00020\u000e*\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"androidx/compose/foundation/pager/PagerKt$SnapLayoutInfoProvider$1", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "layoutInfo", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/pager/PagerLayoutInfo;", "calculateApproachOffset", "", "Landroidx/compose/ui/unit/Density;", "initialVelocity", "calculateSnapStepSize", "calculateSnappingOffset", "currentVelocity", "isValidDistance", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Pager.kt */
public final class PagerKt$SnapLayoutInfoProvider$1 implements SnapLayoutInfoProvider {
    final /* synthetic */ DecayAnimationSpec<Float> $decayAnimationSpec;
    final /* synthetic */ PagerSnapDistance $pagerSnapDistance;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ float $snapPositionalThreshold;

    PagerKt$SnapLayoutInfoProvider$1(PagerState $pagerState2, float $snapPositionalThreshold2, DecayAnimationSpec<Float> $decayAnimationSpec2, PagerSnapDistance $pagerSnapDistance2) {
        this.$pagerState = $pagerState2;
        this.$snapPositionalThreshold = $snapPositionalThreshold2;
        this.$decayAnimationSpec = $decayAnimationSpec2;
        this.$pagerSnapDistance = $pagerSnapDistance2;
    }

    public final PagerLayoutInfo getLayoutInfo() {
        return this.$pagerState.getLayoutInfo$foundation_release();
    }

    public final boolean isValidDistance(float $this$isValidDistance) {
        if (!($this$isValidDistance == Float.POSITIVE_INFINITY)) {
            if (!($this$isValidDistance == Float.NEGATIVE_INFINITY)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float calculateSnappingOffset(androidx.compose.ui.unit.Density r21, float r22) {
        /*
            r20 = this;
            r0 = r20
            java.lang.String r1 = "<this>"
            r10 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            r1 = 0
            r1 = -8388608(0xffffffffff800000, float:-Infinity)
            r2 = 0
            r2 = 2139095040(0x7f800000, float:Infinity)
            androidx.compose.foundation.pager.PagerLayoutInfo r3 = r20.getLayoutInfo()
            java.util.List r11 = r3.getVisiblePagesInfo()
            r12 = 0
            r3 = 0
            int r13 = r11.size()
            r14 = r2
            r15 = r3
        L_0x0020:
            r16 = 0
            if (r15 >= r13) goto L_0x0079
            java.lang.Object r17 = r11.get(r15)
            r18 = r17
            androidx.compose.foundation.pager.PageInfo r18 = (androidx.compose.foundation.pager.PageInfo) r18
            r19 = 0
            androidx.compose.foundation.pager.PagerLayoutInfo r2 = r20.getLayoutInfo()
            int r3 = androidx.compose.foundation.pager.PagerLayoutInfoKt.getMainAxisViewportSize(r2)
            androidx.compose.foundation.pager.PagerLayoutInfo r2 = r20.getLayoutInfo()
            int r4 = r2.getBeforeContentPadding()
            androidx.compose.foundation.pager.PagerLayoutInfo r2 = r20.getLayoutInfo()
            int r5 = r2.getAfterContentPadding()
            androidx.compose.foundation.pager.PagerLayoutInfo r2 = r20.getLayoutInfo()
            int r6 = r2.getPageSize()
            int r7 = r18.getOffset()
            int r8 = r18.getIndex()
            androidx.compose.foundation.gestures.snapping.SnapPositionInLayout r9 = androidx.compose.foundation.pager.PagerStateKt.getSnapAlignmentStartToStart()
            r2 = r21
            float r2 = androidx.compose.foundation.gestures.snapping.SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(r2, r3, r4, r5, r6, r7, r8, r9)
            int r3 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r3 > 0) goto L_0x006a
            int r3 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x006a
            r1 = r2
        L_0x006a:
            int r3 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r3 < 0) goto L_0x0074
            int r3 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r3 >= 0) goto L_0x0074
            r3 = r2
            r14 = r3
        L_0x0074:
            int r15 = r15 + 1
            goto L_0x0020
        L_0x0079:
            androidx.compose.foundation.pager.PagerState r2 = r0.$pagerState
            boolean r2 = androidx.compose.foundation.pager.PagerKt.isScrollingForward(r2)
            androidx.compose.foundation.pager.PagerState r3 = r0.$pagerState
            float r3 = androidx.compose.foundation.pager.PagerKt.dragGestureDelta(r3)
            androidx.compose.foundation.pager.PagerLayoutInfo r4 = r20.getLayoutInfo()
            int r4 = r4.getPageSize()
            float r4 = (float) r4
            float r3 = r3 / r4
            int r4 = (int) r3
            float r4 = (float) r4
            float r4 = r3 - r4
            float r5 = java.lang.Math.signum(r22)
            int r6 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            r7 = 0
            r8 = 1
            if (r6 != 0) goto L_0x00a2
            r6 = r8
            goto L_0x00a3
        L_0x00a2:
            r6 = r7
        L_0x00a3:
            if (r6 == 0) goto L_0x00b5
            float r5 = java.lang.Math.abs(r4)
            float r6 = r0.$snapPositionalThreshold
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x00b2
            if (r2 == 0) goto L_0x00cb
            goto L_0x00c0
        L_0x00b2:
            if (r2 == 0) goto L_0x00c0
            goto L_0x00cb
        L_0x00b5:
            r6 = 1065353216(0x3f800000, float:1.0)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x00bd
            r6 = r8
            goto L_0x00be
        L_0x00bd:
            r6 = r7
        L_0x00be:
            if (r6 == 0) goto L_0x00c2
        L_0x00c0:
            r5 = r14
            goto L_0x00cf
        L_0x00c2:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 != 0) goto L_0x00c9
            r7 = r8
        L_0x00c9:
            if (r7 == 0) goto L_0x00cd
        L_0x00cb:
            r5 = r1
            goto L_0x00cf
        L_0x00cd:
            r5 = r16
        L_0x00cf:
            boolean r6 = r0.isValidDistance(r5)
            if (r6 == 0) goto L_0x00d9
            r16 = r5
            goto L_0x00da
        L_0x00d9:
        L_0x00da:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt$SnapLayoutInfoProvider$1.calculateSnappingOffset(androidx.compose.ui.unit.Density, float):float");
    }

    public float calculateSnapStepSize(Density $this$calculateSnapStepSize) {
        Intrinsics.checkNotNullParameter($this$calculateSnapStepSize, "<this>");
        return (float) getLayoutInfo().getPageSize();
    }

    public float calculateApproachOffset(Density $this$calculateApproachOffset, float initialVelocity) {
        int i;
        Object it$iv;
        float f;
        float f2;
        float f3 = initialVelocity;
        Intrinsics.checkNotNullParameter($this$calculateApproachOffset, "<this>");
        int effectivePageSizePx = this.$pagerState.getPageSize$foundation_release() + this.$pagerState.getPageSpacing$foundation_release();
        float animationOffsetPx = DecayAnimationSpecKt.calculateTargetValue(this.$decayAnimationSpec, 0.0f, f3);
        if (f3 < 0.0f) {
            i = this.$pagerState.getFirstVisiblePage$foundation_release() + 1;
        } else {
            i = this.$pagerState.getFirstVisiblePage$foundation_release();
        }
        int startPage = i;
        List $this$fastForEach$iv$iv = getLayoutInfo().getVisiblePagesInfo();
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (true) {
            if (index$iv$iv >= size) {
                it$iv = null;
                break;
            }
            it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            if (((PageInfo) it$iv).getIndex() == startPage) {
                break;
            }
            index$iv$iv++;
        }
        PageInfo pageInfo = (PageInfo) it$iv;
        int scrollOffset = pageInfo != null ? pageInfo.getOffset() : 0;
        float targetPageValue = (((float) (startPage * effectivePageSizePx)) + animationOffsetPx) / ((float) effectivePageSizePx);
        if (f3 > 0.0f) {
            f = (float) Math.ceil((double) targetPageValue);
        } else {
            f = (float) Math.floor((double) targetPageValue);
        }
        int flingApproachOffsetPx = RangesKt.coerceAtLeast(Math.abs((RangesKt.coerceIn(this.$pagerSnapDistance.calculateTargetPage(startPage, RangesKt.coerceIn((int) f, 0, this.$pagerState.getPageCount()), initialVelocity, this.$pagerState.getPageSize$foundation_release(), this.$pagerState.getPageSpacing$foundation_release()), 0, this.$pagerState.getPageCount()) - startPage) * effectivePageSizePx) - Math.abs(scrollOffset), 0);
        if (flingApproachOffsetPx == 0) {
            f2 = (float) flingApproachOffsetPx;
        } else {
            f2 = ((float) flingApproachOffsetPx) * Math.signum(initialVelocity);
        }
        float f4 = f2;
        return f2;
    }
}

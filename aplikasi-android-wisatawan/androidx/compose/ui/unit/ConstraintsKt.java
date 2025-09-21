package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\u001a8\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002\u001a\u001f\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a!\u0010\u000b\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000e\u001a!\u0010\u0012\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0003H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a!\u0010\u0016\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0003H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0015\u001a!\u0010\u0019\u001a\u00020\u001a*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a-\u0010\u001d\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Constraints", "Landroidx/compose/ui/unit/Constraints;", "minWidth", "", "maxWidth", "minHeight", "maxHeight", "(IIII)J", "addMaxWithMinimum", "max", "value", "constrain", "otherConstraints", "constrain-N9IONVI", "(JJ)J", "Landroidx/compose/ui/unit/IntSize;", "size", "constrain-4WqzIAM", "constrainHeight", "height", "constrainHeight-K40F9xA", "(JI)I", "constrainWidth", "width", "constrainWidth-K40F9xA", "isSatisfiedBy", "", "isSatisfiedBy-4WqzIAM", "(JJ)Z", "offset", "horizontal", "vertical", "offset-NN6Ew-U", "(JII)J", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Constraints.kt */
public final class ConstraintsKt {
    public static /* synthetic */ long Constraints$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return Constraints(i, i2, i3, i4);
    }

    public static final long Constraints(int minWidth, int maxWidth, int minHeight, int maxHeight) {
        boolean z = true;
        if (maxWidth >= minWidth) {
            if (maxHeight >= minHeight) {
                if (minWidth < 0 || minHeight < 0) {
                    z = false;
                }
                if (z) {
                    return Constraints.Companion.m5795createConstraintsZbe2FdA$ui_unit_release(minWidth, maxWidth, minHeight, maxHeight);
                }
                throw new IllegalArgumentException(("minWidth(" + minWidth + ") and minHeight(" + minHeight + ") must be >= 0").toString());
            }
            throw new IllegalArgumentException(("maxHeight(" + maxHeight + ") must be >= than minHeight(" + minHeight + ')').toString());
        }
        throw new IllegalArgumentException(("maxWidth(" + maxWidth + ") must be >= than minWidth(" + minWidth + ')').toString());
    }

    /* renamed from: constrain-N9IONVI  reason: not valid java name */
    public static final long m5800constrainN9IONVI(long $this$constrain_u2dN9IONVI, long otherConstraints) {
        return Constraints(RangesKt.coerceIn(Constraints.m5790getMinWidthimpl(otherConstraints), Constraints.m5790getMinWidthimpl($this$constrain_u2dN9IONVI), Constraints.m5788getMaxWidthimpl($this$constrain_u2dN9IONVI)), RangesKt.coerceIn(Constraints.m5788getMaxWidthimpl(otherConstraints), Constraints.m5790getMinWidthimpl($this$constrain_u2dN9IONVI), Constraints.m5788getMaxWidthimpl($this$constrain_u2dN9IONVI)), RangesKt.coerceIn(Constraints.m5789getMinHeightimpl(otherConstraints), Constraints.m5789getMinHeightimpl($this$constrain_u2dN9IONVI), Constraints.m5787getMaxHeightimpl($this$constrain_u2dN9IONVI)), RangesKt.coerceIn(Constraints.m5787getMaxHeightimpl(otherConstraints), Constraints.m5789getMinHeightimpl($this$constrain_u2dN9IONVI), Constraints.m5787getMaxHeightimpl($this$constrain_u2dN9IONVI)));
    }

    /* renamed from: constrain-4WqzIAM  reason: not valid java name */
    public static final long m5799constrain4WqzIAM(long $this$constrain_u2d4WqzIAM, long size) {
        return IntSizeKt.IntSize(RangesKt.coerceIn(IntSize.m6004getWidthimpl(size), Constraints.m5790getMinWidthimpl($this$constrain_u2d4WqzIAM), Constraints.m5788getMaxWidthimpl($this$constrain_u2d4WqzIAM)), RangesKt.coerceIn(IntSize.m6003getHeightimpl(size), Constraints.m5789getMinHeightimpl($this$constrain_u2d4WqzIAM), Constraints.m5787getMaxHeightimpl($this$constrain_u2d4WqzIAM)));
    }

    /* renamed from: constrainWidth-K40F9xA  reason: not valid java name */
    public static final int m5802constrainWidthK40F9xA(long $this$constrainWidth_u2dK40F9xA, int width) {
        return RangesKt.coerceIn(width, Constraints.m5790getMinWidthimpl($this$constrainWidth_u2dK40F9xA), Constraints.m5788getMaxWidthimpl($this$constrainWidth_u2dK40F9xA));
    }

    /* renamed from: constrainHeight-K40F9xA  reason: not valid java name */
    public static final int m5801constrainHeightK40F9xA(long $this$constrainHeight_u2dK40F9xA, int height) {
        return RangesKt.coerceIn(height, Constraints.m5789getMinHeightimpl($this$constrainHeight_u2dK40F9xA), Constraints.m5787getMaxHeightimpl($this$constrainHeight_u2dK40F9xA));
    }

    /* renamed from: isSatisfiedBy-4WqzIAM  reason: not valid java name */
    public static final boolean m5803isSatisfiedBy4WqzIAM(long $this$isSatisfiedBy_u2d4WqzIAM, long size) {
        int r0 = Constraints.m5790getMinWidthimpl($this$isSatisfiedBy_u2d4WqzIAM);
        int r1 = Constraints.m5788getMaxWidthimpl($this$isSatisfiedBy_u2d4WqzIAM);
        int r2 = IntSize.m6004getWidthimpl(size);
        if (r0 <= r2 && r2 <= r1) {
            int r02 = Constraints.m5789getMinHeightimpl($this$isSatisfiedBy_u2d4WqzIAM);
            int r12 = Constraints.m5787getMaxHeightimpl($this$isSatisfiedBy_u2d4WqzIAM);
            int r22 = IntSize.m6003getHeightimpl(size);
            if (r02 <= r22 && r22 <= r12) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: offset-NN6Ew-U$default  reason: not valid java name */
    public static /* synthetic */ long m5805offsetNN6EwU$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m5804offsetNN6EwU(j, i, i2);
    }

    /* renamed from: offset-NN6Ew-U  reason: not valid java name */
    public static final long m5804offsetNN6EwU(long $this$offset_u2dNN6Ew_u2dU, int horizontal, int vertical) {
        return Constraints(RangesKt.coerceAtLeast(Constraints.m5790getMinWidthimpl($this$offset_u2dNN6Ew_u2dU) + horizontal, 0), addMaxWithMinimum(Constraints.m5788getMaxWidthimpl($this$offset_u2dNN6Ew_u2dU), horizontal), RangesKt.coerceAtLeast(Constraints.m5789getMinHeightimpl($this$offset_u2dNN6Ew_u2dU) + vertical, 0), addMaxWithMinimum(Constraints.m5787getMaxHeightimpl($this$offset_u2dNN6Ew_u2dU), vertical));
    }

    private static final int addMaxWithMinimum(int max, int value) {
        if (max == Integer.MAX_VALUE) {
            return max;
        }
        return RangesKt.coerceAtLeast(max + value, 0);
    }
}

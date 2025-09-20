package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.DpRect;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0016ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MeasureScope.kt */
public interface MeasureScope extends IntrinsicMeasureScope {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MeasureScope.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isLookingAhead(MeasureScope $this) {
            return MeasureScope.super.isLookingAhead();
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m6413roundToPxR2X_6o(MeasureScope $this, long $receiver) {
            return MeasureScope.super.m7528roundToPxR2X_6o($receiver);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m6414roundToPx0680j_4(MeasureScope $this, float $receiver) {
            return MeasureScope.super.m7529roundToPx0680j_4($receiver);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m6415toDpGaN1DYA(MeasureScope $this, long $receiver) {
            return MeasureScope.super.m7530toDpGaN1DYA($receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m6416toDpu2uoSUM(MeasureScope $this, float $receiver) {
            return MeasureScope.super.m7531toDpu2uoSUM($receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m6417toDpu2uoSUM(MeasureScope $this, int $receiver) {
            return MeasureScope.super.m7532toDpu2uoSUM($receiver);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m6418toDpSizekrfVVM(MeasureScope $this, long $receiver) {
            return MeasureScope.super.m7533toDpSizekrfVVM($receiver);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m6419toPxR2X_6o(MeasureScope $this, long $receiver) {
            return MeasureScope.super.m7534toPxR2X_6o($receiver);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m6420toPx0680j_4(MeasureScope $this, float $receiver) {
            return MeasureScope.super.m7535toPx0680j_4($receiver);
        }

        @Deprecated
        public static Rect toRect(MeasureScope $this, DpRect $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return MeasureScope.super.toRect($receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m6421toSizeXkaWNTQ(MeasureScope $this, long $receiver) {
            return MeasureScope.super.m7536toSizeXkaWNTQ($receiver);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m6422toSp0xMU5do(MeasureScope $this, float $receiver) {
            return MeasureScope.super.m7537toSp0xMU5do($receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m6423toSpkPz2Gy4(MeasureScope $this, float $receiver) {
            return MeasureScope.super.m7538toSpkPz2Gy4($receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m6424toSpkPz2Gy4(MeasureScope $this, int $receiver) {
            return MeasureScope.super.m7539toSpkPz2Gy4($receiver);
        }

        @Deprecated
        public static MeasureResult layout(MeasureScope $this, int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
            Intrinsics.checkNotNullParameter(alignmentLines, "alignmentLines");
            Intrinsics.checkNotNullParameter(placementBlock, "placementBlock");
            return MeasureScope.super.layout(width, height, alignmentLines, placementBlock);
        }
    }

    static /* synthetic */ MeasureResult layout$default(MeasureScope measureScope, int i, int i2, Map map, Function1 function1, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            return measureScope.layout(i, i2, map, function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
    }

    MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        Intrinsics.checkNotNullParameter(alignmentLines, "alignmentLines");
        Intrinsics.checkNotNullParameter(placementBlock, "placementBlock");
        return new MeasureScope$layout$1(width, height, alignmentLines, this, placementBlock);
    }
}

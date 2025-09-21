package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006ø\u0001\u0000\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a&\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006ø\u0001\u0000\u001a-\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"absoluteOffset", "Landroidx/compose/ui/Modifier;", "offset", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/ExtensionFunctionType;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "absoluteOffset-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "offset-VpY3zN4", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Offset.kt */
public final class OffsetKt {
    /* renamed from: offset-VpY3zN4  reason: not valid java name */
    public static final Modifier m496offsetVpY3zN4(Modifier $this$offset_u2dVpY3zN4, float x, float y) {
        Intrinsics.checkNotNullParameter($this$offset_u2dVpY3zN4, "$this$offset");
        return $this$offset_u2dVpY3zN4.then(new OffsetElement(x, y, true, new OffsetKt$offset$1(x, y), (DefaultConstructorMarker) null));
    }

    /* renamed from: offset-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m497offsetVpY3zN4$default(Modifier modifier, float $this$dp$iv, float $this$dp$iv2, int i, Object obj) {
        if ((i & 1) != 0) {
            $this$dp$iv = Dp.m5844constructorimpl((float) 0);
        }
        if ((i & 2) != 0) {
            $this$dp$iv2 = Dp.m5844constructorimpl((float) 0);
        }
        return m496offsetVpY3zN4(modifier, $this$dp$iv, $this$dp$iv2);
    }

    /* renamed from: absoluteOffset-VpY3zN4  reason: not valid java name */
    public static final Modifier m494absoluteOffsetVpY3zN4(Modifier $this$absoluteOffset_u2dVpY3zN4, float x, float y) {
        Intrinsics.checkNotNullParameter($this$absoluteOffset_u2dVpY3zN4, "$this$absoluteOffset");
        return $this$absoluteOffset_u2dVpY3zN4.then(new OffsetElement(x, y, false, new OffsetKt$absoluteOffset$1(x, y), (DefaultConstructorMarker) null));
    }

    /* renamed from: absoluteOffset-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m495absoluteOffsetVpY3zN4$default(Modifier modifier, float $this$dp$iv, float $this$dp$iv2, int i, Object obj) {
        if ((i & 1) != 0) {
            $this$dp$iv = Dp.m5844constructorimpl((float) 0);
        }
        if ((i & 2) != 0) {
            $this$dp$iv2 = Dp.m5844constructorimpl((float) 0);
        }
        return m494absoluteOffsetVpY3zN4(modifier, $this$dp$iv, $this$dp$iv2);
    }

    public static final Modifier offset(Modifier $this$offset, Function1<? super Density, IntOffset> offset) {
        Intrinsics.checkNotNullParameter($this$offset, "<this>");
        Intrinsics.checkNotNullParameter(offset, TypedValues.CycleType.S_WAVE_OFFSET);
        return $this$offset.then(new OffsetPxElement(offset, true, new OffsetKt$offset$2(offset)));
    }

    public static final Modifier absoluteOffset(Modifier $this$absoluteOffset, Function1<? super Density, IntOffset> offset) {
        Intrinsics.checkNotNullParameter($this$absoluteOffset, "<this>");
        Intrinsics.checkNotNullParameter(offset, TypedValues.CycleType.S_WAVE_OFFSET);
        return $this$absoluteOffset.then(new OffsetPxElement(offset, false, new OffsetKt$absoluteOffset$2(offset)));
    }
}

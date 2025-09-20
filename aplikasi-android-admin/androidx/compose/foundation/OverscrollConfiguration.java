package androidx.compose.foundation;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001c\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/OverscrollConfiguration;", "", "glowColor", "Landroidx/compose/ui/graphics/Color;", "drawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "(JLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDrawPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "getGlowColor-0d7_KjU", "()J", "J", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OverscrollConfiguration.kt */
public final class OverscrollConfiguration {
    public static final int $stable = 0;
    private final PaddingValues drawPadding;
    private final long glowColor;

    public /* synthetic */ OverscrollConfiguration(long j, PaddingValues paddingValues, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, paddingValues);
    }

    private OverscrollConfiguration(long glowColor2, PaddingValues drawPadding2) {
        Intrinsics.checkNotNullParameter(drawPadding2, "drawPadding");
        this.glowColor = glowColor2;
        this.drawPadding = drawPadding2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OverscrollConfiguration(long j, PaddingValues paddingValues, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ColorKt.Color(4284900966L) : j, (i & 2) != 0 ? PaddingKt.m2243PaddingValuesYgX7TsA$default(0.0f, 0.0f, 3, (Object) null) : paddingValues, (DefaultConstructorMarker) null);
    }

    /* renamed from: getGlowColor-0d7_KjU  reason: not valid java name */
    public final long m1963getGlowColor0d7_KjU() {
        return this.glowColor;
    }

    public final PaddingValues getDrawPadding() {
        return this.drawPadding;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.compose.foundation.OverscrollConfiguration");
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) other;
        if (Color.m4964equalsimpl0(this.glowColor, ((OverscrollConfiguration) other).glowColor) && Intrinsics.areEqual((Object) this.drawPadding, (Object) ((OverscrollConfiguration) other).drawPadding)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Color.m4970hashCodeimpl(this.glowColor) * 31) + this.drawPadding.hashCode();
    }

    public String toString() {
        return "OverscrollConfiguration(glowColor=" + Color.m4971toStringimpl(this.glowColor) + ", drawPadding=" + this.drawPadding + ')';
    }
}

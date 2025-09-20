package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\t\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\u001a\f\u0010\f\u001a\u00020\u0001*\u00020\rH\u0000\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000f\u001a\u0012\u0010\u000e\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\u001a\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"WindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "WindowInsets-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/WindowInsets;", "", "add", "insets", "asInsets", "Landroidx/compose/foundation/layout/PaddingValues;", "asPaddingValues", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/PaddingValues;", "density", "Landroidx/compose/ui/unit/Density;", "exclude", "only", "sides", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "only-bOOhFvg", "(Landroidx/compose/foundation/layout/WindowInsets;I)Landroidx/compose/foundation/layout/WindowInsets;", "union", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsets.kt */
public final class WindowInsetsKt {
    public static final WindowInsets union(WindowInsets $this$union, WindowInsets insets) {
        Intrinsics.checkNotNullParameter($this$union, "<this>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        return new UnionInsets($this$union, insets);
    }

    public static final WindowInsets exclude(WindowInsets $this$exclude, WindowInsets insets) {
        Intrinsics.checkNotNullParameter($this$exclude, "<this>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        return new ExcludeInsets($this$exclude, insets);
    }

    public static final WindowInsets add(WindowInsets $this$add, WindowInsets insets) {
        Intrinsics.checkNotNullParameter($this$add, "<this>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        return new AddedInsets($this$add, insets);
    }

    /* renamed from: only-bOOhFvg  reason: not valid java name */
    public static final WindowInsets m2351onlybOOhFvg(WindowInsets $this$only_u2dbOOhFvg, int sides) {
        Intrinsics.checkNotNullParameter($this$only_u2dbOOhFvg, "$this$only");
        return new LimitInsets($this$only_u2dbOOhFvg, sides, (DefaultConstructorMarker) null);
    }

    public static final PaddingValues asPaddingValues(WindowInsets $this$asPaddingValues, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$asPaddingValues, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, -1485016250, "C(asPaddingValues)242@9134L7:WindowInsets.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1485016250, $changed, -1, "androidx.compose.foundation.layout.asPaddingValues (WindowInsets.kt:242)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        InsetsPaddingValues insetsPaddingValues = new InsetsPaddingValues($this$asPaddingValues, (Density) consume);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return insetsPaddingValues;
    }

    public static final PaddingValues asPaddingValues(WindowInsets $this$asPaddingValues, Density density) {
        Intrinsics.checkNotNullParameter($this$asPaddingValues, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        return new InsetsPaddingValues($this$asPaddingValues, density);
    }

    public static final WindowInsets asInsets(PaddingValues $this$asInsets) {
        Intrinsics.checkNotNullParameter($this$asInsets, "<this>");
        return new PaddingValuesInsets($this$asInsets);
    }

    public static /* synthetic */ WindowInsets WindowInsets$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        return WindowInsets(i, i2, i3, i4);
    }

    public static final WindowInsets WindowInsets(int left, int top, int right, int bottom) {
        return new FixedIntInsets(left, top, right, bottom);
    }

    /* renamed from: WindowInsets-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ WindowInsets m2350WindowInsetsa9UjIt4$default(float $this$dp$iv, float $this$dp$iv2, float $this$dp$iv3, float $this$dp$iv4, int i, Object obj) {
        if ((i & 1) != 0) {
            $this$dp$iv = Dp.m7554constructorimpl((float) 0);
        }
        if ((i & 2) != 0) {
            $this$dp$iv2 = Dp.m7554constructorimpl((float) 0);
        }
        if ((i & 4) != 0) {
            $this$dp$iv3 = Dp.m7554constructorimpl((float) 0);
        }
        if ((i & 8) != 0) {
            $this$dp$iv4 = Dp.m7554constructorimpl((float) 0);
        }
        return m2349WindowInsetsa9UjIt4($this$dp$iv, $this$dp$iv2, $this$dp$iv3, $this$dp$iv4);
    }

    /* renamed from: WindowInsets-a9UjIt4  reason: not valid java name */
    public static final WindowInsets m2349WindowInsetsa9UjIt4(float left, float top, float right, float bottom) {
        return new FixedDpInsets(left, top, right, bottom, (DefaultConstructorMarker) null);
    }
}

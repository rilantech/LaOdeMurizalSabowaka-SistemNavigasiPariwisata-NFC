package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 ,2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0002:\u0001,B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ@\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0019\u0010\u001e\u001a\u0015\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u0001H\u001d0\u001f¢\u0006\u0002\b!H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#J!\u0010$\u001a\u00020\b*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u00020\b*\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\b*\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010)R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006-"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "reverseLayout", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;ZLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/gestures/Orientation;)V", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "addNextInterval", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "currentInterval", "direction", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "addNextInterval-FR3nfPY", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "layout", "T", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "hasMoreContent", "hasMoreContent-FR3nfPY", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;I)Z", "isForward", "isForward-4vf7U8o", "(I)Z", "isOppositeToOrientation", "isOppositeToOrientation-4vf7U8o", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
public final class LazyLayoutBeyondBoundsModifierLocal implements ModifierLocalProvider<BeyondBoundsLayout>, BeyondBoundsLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1 emptyBeyondBoundsScope = new LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1();
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final LayoutDirection layoutDirection;
    private final Orientation orientation;
    private final boolean reverseLayout;
    private final LazyLayoutBeyondBoundsState state;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LazyLayoutBeyondBoundsModifierLocal(LazyLayoutBeyondBoundsState state2, LazyLayoutBeyondBoundsInfo beyondBoundsInfo2, boolean reverseLayout2, LayoutDirection layoutDirection2, Orientation orientation2) {
        Intrinsics.checkNotNullParameter(state2, "state");
        Intrinsics.checkNotNullParameter(beyondBoundsInfo2, "beyondBoundsInfo");
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        this.state = state2;
        this.beyondBoundsInfo = beyondBoundsInfo2;
        this.reverseLayout = reverseLayout2;
        this.layoutDirection = layoutDirection2;
        this.orientation = orientation2;
    }

    public ProvidableModifierLocal<BeyondBoundsLayout> getKey() {
        return BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout();
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal$Companion;", "", "()V", "emptyBeyondBoundsScope", "androidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BeyondBoundsLayout getValue() {
        return this;
    }

    /* renamed from: layout-o7g1Pn8  reason: not valid java name */
    public <T> T m2443layouto7g1Pn8(int direction, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        int startIndex;
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.state.getItemCount() <= 0 || !this.state.getHasVisibleItems()) {
            return block.invoke(emptyBeyondBoundsScope);
        }
        if (m2441isForward4vf7U8o(direction)) {
            startIndex = this.state.getLastPlacedIndex();
        } else {
            startIndex = this.state.getFirstPlacedIndex();
        }
        Ref.ObjectRef interval = new Ref.ObjectRef();
        interval.element = this.beyondBoundsInfo.addInterval(startIndex, startIndex);
        Object found = null;
        while (found == null && m2440hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) interval.element, direction)) {
            T r3 = m2439addNextIntervalFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) interval.element, direction);
            T t = r3;
            this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval) interval.element);
            interval.element = r3;
            this.state.remeasure();
            found = block.invoke(new LazyLayoutBeyondBoundsModifierLocal$layout$2(this, interval, direction));
        }
        this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval) interval.element);
        this.state.remeasure();
        return found;
    }

    /* renamed from: isForward-4vf7U8o  reason: not valid java name */
    private final boolean m2441isForward4vf7U8o(int $this$isForward_u2d4vf7U8o) {
        if (BeyondBoundsLayout.LayoutDirection.m6307equalsimpl0($this$isForward_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m6313getBeforehoxUOeE())) {
            return false;
        }
        if (BeyondBoundsLayout.LayoutDirection.m6307equalsimpl0($this$isForward_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m6312getAfterhoxUOeE())) {
            return true;
        }
        if (BeyondBoundsLayout.LayoutDirection.m6307equalsimpl0($this$isForward_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m6311getAbovehoxUOeE())) {
            return this.reverseLayout;
        }
        if (BeyondBoundsLayout.LayoutDirection.m6307equalsimpl0($this$isForward_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m6314getBelowhoxUOeE())) {
            if (!this.reverseLayout) {
                return true;
            }
            return false;
        } else if (BeyondBoundsLayout.LayoutDirection.m6307equalsimpl0($this$isForward_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m6315getLefthoxUOeE())) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()]) {
                case 1:
                    return this.reverseLayout;
                case 2:
                    if (!this.reverseLayout) {
                        return true;
                    }
                    return false;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else if (BeyondBoundsLayout.LayoutDirection.m6307equalsimpl0($this$isForward_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m6316getRighthoxUOeE())) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()]) {
                case 1:
                    if (!this.reverseLayout) {
                        return true;
                    }
                    return false;
                case 2:
                    return this.reverseLayout;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            Void unused = LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: addNextInterval-FR3nfPY  reason: not valid java name */
    private final LazyLayoutBeyondBoundsInfo.Interval m2439addNextIntervalFR3nfPY(LazyLayoutBeyondBoundsInfo.Interval currentInterval, int direction) {
        int start = currentInterval.getStart();
        int end = currentInterval.getEnd();
        if (m2441isForward4vf7U8o(direction)) {
            end++;
        } else {
            start--;
        }
        return this.beyondBoundsInfo.addInterval(start, end);
    }

    /* access modifiers changed from: private */
    /* renamed from: hasMoreContent-FR3nfPY  reason: not valid java name */
    public final boolean m2440hasMoreContentFR3nfPY(LazyLayoutBeyondBoundsInfo.Interval $this$hasMoreContent_u2dFR3nfPY, int direction) {
        if (m2442isOppositeToOrientation4vf7U8o(direction)) {
            return false;
        }
        if (m2441isForward4vf7U8o(direction)) {
            if ($this$hasMoreContent_u2dFR3nfPY.getEnd() >= this.state.getItemCount() - 1) {
                return false;
            }
        } else if ($this$hasMoreContent_u2dFR3nfPY.getStart() <= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: isOppositeToOrientation-4vf7U8o  reason: not valid java name */
    private final boolean m2442isOppositeToOrientation4vf7U8o(int $this$isOppositeToOrientation_u2d4vf7U8o) {
        boolean z = true;
        if (BeyondBoundsLayout.LayoutDirection.m6307equalsimpl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m6311getAbovehoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m6307equalsimpl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m6314getBelowhoxUOeE())) {
            return this.orientation == Orientation.Horizontal;
        }
        if (!(BeyondBoundsLayout.LayoutDirection.m6307equalsimpl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m6315getLefthoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m6307equalsimpl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m6316getRighthoxUOeE()))) {
            if (!BeyondBoundsLayout.LayoutDirection.m6307equalsimpl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m6313getBeforehoxUOeE())) {
                z = BeyondBoundsLayout.LayoutDirection.m6307equalsimpl0($this$isOppositeToOrientation_u2d4vf7U8o, BeyondBoundsLayout.LayoutDirection.Companion.m6312getAfterhoxUOeE());
            }
            if (z) {
                return false;
            }
            Void unused = LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
            throw new KotlinNothingValueException();
        } else if (this.orientation == Orientation.Vertical) {
            return true;
        } else {
            return false;
        }
    }
}

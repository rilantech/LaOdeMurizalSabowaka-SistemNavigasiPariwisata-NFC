package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u001bJR\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2#\b\u0002\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\f0\u000bH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011JR\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2#\b\u0002\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\f0\u000bH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u0018*\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH¦\u0004\u0001\u0001\u001cø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0001"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "slideIntoContainer", "Landroidx/compose/animation/EnterTransition;", "towards", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "initialOffset", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "offsetForFullSlide", "slideIntoContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "slideOutOfContainer", "Landroidx/compose/animation/ExitTransition;", "targetOffset", "slideOutOfContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "using", "Landroidx/compose/animation/ContentTransform;", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "SlideDirection", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
public interface AnimatedContentTransitionScope<S> extends Transition.Segment<S> {
    /* renamed from: slideIntoContainer-mOhB8PU  reason: not valid java name */
    EnterTransition m1724slideIntoContainermOhB8PU(int i, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1);

    /* renamed from: slideOutOfContainer-mOhB8PU  reason: not valid java name */
    ExitTransition m1725slideOutOfContainermOhB8PU(int i, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1);

    ContentTransform using(ContentTransform contentTransform, SizeTransform sizeTransform);

    @JvmInline
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimatedContent.kt */
    public static final class SlideDirection {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int Down = m1727constructorimpl(3);
        /* access modifiers changed from: private */
        public static final int End = m1727constructorimpl(5);
        /* access modifiers changed from: private */
        public static final int Left = m1727constructorimpl(0);
        /* access modifiers changed from: private */
        public static final int Right = m1727constructorimpl(1);
        /* access modifiers changed from: private */
        public static final int Start = m1727constructorimpl(4);
        /* access modifiers changed from: private */
        public static final int Up = m1727constructorimpl(2);
        private final int value;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ SlideDirection m1726boximpl(int i) {
            return new SlideDirection(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m1727constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m1728equalsimpl(int i, Object obj) {
            return (obj instanceof SlideDirection) && i == ((SlideDirection) obj).m1732unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m1729equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m1730hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m1728equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m1730hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m1732unboximpl() {
            return this.value;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection$Companion;", "", "()V", "Down", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "getDown-DKzdypw", "()I", "I", "End", "getEnd-DKzdypw", "Left", "getLeft-DKzdypw", "Right", "getRight-DKzdypw", "Start", "getStart-DKzdypw", "Up", "getUp-DKzdypw", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnimatedContent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getLeft-DKzdypw  reason: not valid java name */
            public final int m1735getLeftDKzdypw() {
                return SlideDirection.Left;
            }

            /* renamed from: getRight-DKzdypw  reason: not valid java name */
            public final int m1736getRightDKzdypw() {
                return SlideDirection.Right;
            }

            /* renamed from: getUp-DKzdypw  reason: not valid java name */
            public final int m1738getUpDKzdypw() {
                return SlideDirection.Up;
            }

            /* renamed from: getDown-DKzdypw  reason: not valid java name */
            public final int m1733getDownDKzdypw() {
                return SlideDirection.Down;
            }

            /* renamed from: getStart-DKzdypw  reason: not valid java name */
            public final int m1737getStartDKzdypw() {
                return SlideDirection.Start;
            }

            /* renamed from: getEnd-DKzdypw  reason: not valid java name */
            public final int m1734getEndDKzdypw() {
                return SlideDirection.End;
            }
        }

        private /* synthetic */ SlideDirection(int value2) {
            this.value = value2;
        }

        public String toString() {
            return m1731toStringimpl(this.value);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m1731toStringimpl(int arg0) {
            if (m1729equalsimpl0(arg0, Left)) {
                return "Left";
            }
            if (m1729equalsimpl0(arg0, Right)) {
                return "Right";
            }
            if (m1729equalsimpl0(arg0, Up)) {
                return "Up";
            }
            if (m1729equalsimpl0(arg0, Down)) {
                return "Down";
            }
            if (m1729equalsimpl0(arg0, Start)) {
                return "Start";
            }
            if (m1729equalsimpl0(arg0, End)) {
                return "End";
            }
            return "Invalid";
        }
    }

    /* renamed from: slideIntoContainer-mOhB8PU$default  reason: not valid java name */
    static /* synthetic */ EnterTransition m1722slideIntoContainermOhB8PU$default(AnimatedContentTransitionScope animatedContentTransitionScope, int i, FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m7663boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, (Object) null);
            }
            if ((i2 & 4) != 0) {
                function1 = AnimatedContentTransitionScope$slideIntoContainer$1.INSTANCE;
            }
            return animatedContentTransitionScope.m1724slideIntoContainermOhB8PU(i, finiteAnimationSpec, function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slideIntoContainer-mOhB8PU");
    }

    /* renamed from: slideOutOfContainer-mOhB8PU$default  reason: not valid java name */
    static /* synthetic */ ExitTransition m1723slideOutOfContainermOhB8PU$default(AnimatedContentTransitionScope animatedContentTransitionScope, int i, FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m7663boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, (Object) null);
            }
            if ((i2 & 4) != 0) {
                function1 = AnimatedContentTransitionScope$slideOutOfContainer$1.INSTANCE;
            }
            return animatedContentTransitionScope.m1725slideOutOfContainermOhB8PU(i, finiteAnimationSpec, function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slideOutOfContainer-mOhB8PU");
    }
}

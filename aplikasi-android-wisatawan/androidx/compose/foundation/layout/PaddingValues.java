package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0018\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\f\u0010\nJ\u0018\u0010\r\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000e\u0010\u0005ø\u0001\u0003\u0002\u0015\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValues;", "", "calculateBottomPadding", "Landroidx/compose/ui/unit/Dp;", "calculateBottomPadding-D9Ej5fM", "()F", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "Absolute", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Padding.kt */
public interface PaddingValues {
    /* renamed from: calculateBottomPadding-D9Ej5fM  reason: not valid java name */
    float m552calculateBottomPaddingD9Ej5fM();

    /* renamed from: calculateLeftPadding-u2uoSUM  reason: not valid java name */
    float m553calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection);

    /* renamed from: calculateRightPadding-u2uoSUM  reason: not valid java name */
    float m554calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection);

    /* renamed from: calculateTopPadding-D9Ej5fM  reason: not valid java name */
    float m555calculateTopPaddingD9Ej5fM();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B0\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u0003H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\u0003H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0010J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R!\u0010\u0006\u001a\u00020\u00038\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u0012\u0004\b\b\u0010\tR!\u0010\u0002\u001a\u00020\u00038\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u0012\u0004\b\u000b\u0010\tR!\u0010\u0005\u001a\u00020\u00038\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u0012\u0004\b\f\u0010\tR!\u0010\u0004\u001a\u00020\u00038\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u0012\u0004\b\r\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/compose/foundation/layout/PaddingValues$Absolute;", "Landroidx/compose/foundation/layout/PaddingValues;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM$annotations", "()V", "F", "getLeft-D9Ej5fM$annotations", "getRight-D9Ej5fM$annotations", "getTop-D9Ej5fM$annotations", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "()F", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Padding.kt */
    public static final class Absolute implements PaddingValues {
        public static final int $stable = 0;
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        public /* synthetic */ Absolute(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2, f3, f4);
        }

        /* renamed from: getBottom-D9Ej5fM$annotations  reason: not valid java name */
        private static /* synthetic */ void m556getBottomD9Ej5fM$annotations() {
        }

        /* renamed from: getLeft-D9Ej5fM$annotations  reason: not valid java name */
        private static /* synthetic */ void m557getLeftD9Ej5fM$annotations() {
        }

        /* renamed from: getRight-D9Ej5fM$annotations  reason: not valid java name */
        private static /* synthetic */ void m558getRightD9Ej5fM$annotations() {
        }

        /* renamed from: getTop-D9Ej5fM$annotations  reason: not valid java name */
        private static /* synthetic */ void m559getTopD9Ej5fM$annotations() {
        }

        private Absolute(float left2, float top2, float right2, float bottom2) {
            this.left = left2;
            this.top = top2;
            this.right = right2;
            this.bottom = bottom2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Absolute(float r7, float r8, float r9, float r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
            /*
                r6 = this;
                r12 = r11 & 1
                if (r12 == 0) goto L_0x000d
                r7 = 0
                r12 = 0
                float r0 = (float) r7
                float r7 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r0)
                r1 = r7
                goto L_0x000e
            L_0x000d:
                r1 = r7
            L_0x000e:
                r7 = r11 & 2
                if (r7 == 0) goto L_0x001b
                r7 = 0
                r8 = 0
                float r12 = (float) r7
                float r8 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r12)
                r2 = r8
                goto L_0x001c
            L_0x001b:
                r2 = r8
            L_0x001c:
                r7 = r11 & 4
                if (r7 == 0) goto L_0x0029
                r7 = 0
                r8 = 0
                float r9 = (float) r7
                float r9 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r9)
                r3 = r9
                goto L_0x002a
            L_0x0029:
                r3 = r9
            L_0x002a:
                r7 = r11 & 8
                if (r7 == 0) goto L_0x0037
                r7 = 0
                r8 = 0
                float r9 = (float) r7
                float r10 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r9)
                r4 = r10
                goto L_0x0038
            L_0x0037:
                r4 = r10
            L_0x0038:
                r5 = 0
                r0 = r6
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.PaddingValues.Absolute.<init>(float, float, float, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        /* renamed from: calculateLeftPadding-u2uoSUM  reason: not valid java name */
        public float m561calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            return this.left;
        }

        /* renamed from: calculateTopPadding-D9Ej5fM  reason: not valid java name */
        public float m563calculateTopPaddingD9Ej5fM() {
            return this.top;
        }

        /* renamed from: calculateRightPadding-u2uoSUM  reason: not valid java name */
        public float m562calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            return this.right;
        }

        /* renamed from: calculateBottomPadding-D9Ej5fM  reason: not valid java name */
        public float m560calculateBottomPaddingD9Ej5fM() {
            return this.bottom;
        }

        public boolean equals(Object other) {
            if ((other instanceof Absolute) && Dp.m5849equalsimpl0(this.left, ((Absolute) other).left) && Dp.m5849equalsimpl0(this.top, ((Absolute) other).top) && Dp.m5849equalsimpl0(this.right, ((Absolute) other).right) && Dp.m5849equalsimpl0(this.bottom, ((Absolute) other).bottom)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((Dp.m5850hashCodeimpl(this.left) * 31) + Dp.m5850hashCodeimpl(this.top)) * 31) + Dp.m5850hashCodeimpl(this.right)) * 31) + Dp.m5850hashCodeimpl(this.bottom);
        }

        public String toString() {
            return "PaddingValues.Absolute(left=" + Dp.m5855toStringimpl(this.left) + ", top=" + Dp.m5855toStringimpl(this.top) + ", right=" + Dp.m5855toStringimpl(this.right) + ", bottom=" + Dp.m5855toStringimpl(this.bottom) + ')';
        }
    }
}

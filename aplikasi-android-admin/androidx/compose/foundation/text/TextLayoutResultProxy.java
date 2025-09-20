package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J%\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u001a*\u00020\u001aH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u00020\u001a*\u00020\u001aH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010$R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006'"}, d2 = {"Landroidx/compose/foundation/text/TextLayoutResultProxy;", "", "value", "Landroidx/compose/ui/text/TextLayoutResult;", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "decorationBoxCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getDecorationBoxCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setDecorationBoxCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "innerTextFieldCoordinates", "getInnerTextFieldCoordinates", "setInnerTextFieldCoordinates", "getValue", "()Landroidx/compose/ui/text/TextLayoutResult;", "getLineEnd", "", "lineIndex", "visibleEnd", "", "getLineForVerticalPosition", "vertical", "", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "coerceInVisibleBounds", "getOffsetForPosition-3MmeM6k", "(JZ)I", "isPositionOnText", "offset", "isPositionOnText-k-4lQ0M", "(J)Z", "coercedInVisibleBoundsOfInputText", "coercedInVisibleBoundsOfInputText-MK-Hz9U", "(J)J", "relativeToInputText", "relativeToInputText-MK-Hz9U", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLayoutResultProxy.kt */
public final class TextLayoutResultProxy {
    private LayoutCoordinates decorationBoxCoordinates;
    private LayoutCoordinates innerTextFieldCoordinates;
    private final TextLayoutResult value;

    public TextLayoutResultProxy(TextLayoutResult value2) {
        Intrinsics.checkNotNullParameter(value2, "value");
        this.value = value2;
    }

    public final TextLayoutResult getValue() {
        return this.value;
    }

    /* renamed from: getOffsetForPosition-3MmeM6k$default  reason: not valid java name */
    public static /* synthetic */ int m2690getOffsetForPosition3MmeM6k$default(TextLayoutResultProxy textLayoutResultProxy, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return textLayoutResultProxy.m2692getOffsetForPosition3MmeM6k(j, z);
    }

    /* renamed from: getOffsetForPosition-3MmeM6k  reason: not valid java name */
    public final int m2692getOffsetForPosition3MmeM6k(long position, boolean coerceInVisibleBounds) {
        long it = position;
        if (coerceInVisibleBounds) {
            it = m2689coercedInVisibleBoundsOfInputTextMKHz9U(it);
        }
        return this.value.m7007getOffsetForPositionk4lQ0M(m2691relativeToInputTextMKHz9U(it));
    }

    public final int getLineForVerticalPosition(float vertical) {
        return this.value.getLineForVerticalPosition(Offset.m4714getYimpl(m2691relativeToInputTextMKHz9U(m2689coercedInVisibleBoundsOfInputTextMKHz9U(OffsetKt.Offset(0.0f, vertical)))));
    }

    public static /* synthetic */ int getLineEnd$default(TextLayoutResultProxy textLayoutResultProxy, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayoutResultProxy.getLineEnd(i, z);
    }

    public final int getLineEnd(int lineIndex, boolean visibleEnd) {
        return this.value.getLineEnd(lineIndex, visibleEnd);
    }

    /* renamed from: isPositionOnText-k-4lQ0M  reason: not valid java name */
    public final boolean m2693isPositionOnTextk4lQ0M(long offset) {
        long relativeOffset = m2691relativeToInputTextMKHz9U(m2689coercedInVisibleBoundsOfInputTextMKHz9U(offset));
        int line = this.value.getLineForVerticalPosition(Offset.m4714getYimpl(relativeOffset));
        return Offset.m4713getXimpl(relativeOffset) >= this.value.getLineLeft(line) && Offset.m4713getXimpl(relativeOffset) <= this.value.getLineRight(line);
    }

    public final LayoutCoordinates getInnerTextFieldCoordinates() {
        return this.innerTextFieldCoordinates;
    }

    public final void setInnerTextFieldCoordinates(LayoutCoordinates layoutCoordinates) {
        this.innerTextFieldCoordinates = layoutCoordinates;
    }

    public final LayoutCoordinates getDecorationBoxCoordinates() {
        return this.decorationBoxCoordinates;
    }

    public final void setDecorationBoxCoordinates(LayoutCoordinates layoutCoordinates) {
        this.decorationBoxCoordinates = layoutCoordinates;
    }

    /* renamed from: relativeToInputText-MK-Hz9U  reason: not valid java name */
    private final long m2691relativeToInputTextMKHz9U(long $this$relativeToInputText_u2dMK_u2dHz9U) {
        Offset offset;
        long j;
        LayoutCoordinates innerTextFieldCoordinates2 = this.innerTextFieldCoordinates;
        if (innerTextFieldCoordinates2 != null) {
            LayoutCoordinates decorationBoxCoordinates2 = this.decorationBoxCoordinates;
            if (decorationBoxCoordinates2 != null) {
                if (!innerTextFieldCoordinates2.isAttached() || !decorationBoxCoordinates2.isAttached()) {
                    j = $this$relativeToInputText_u2dMK_u2dHz9U;
                } else {
                    j = innerTextFieldCoordinates2.m6361localPositionOfR5De75A(decorationBoxCoordinates2, $this$relativeToInputText_u2dMK_u2dHz9U);
                }
                offset = Offset.m4702boximpl(j);
            } else {
                offset = null;
            }
            if (offset != null) {
                return offset.m4723unboximpl();
            }
        }
        return $this$relativeToInputText_u2dMK_u2dHz9U;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r3 == null) goto L_0x0020;
     */
    /* renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long m2689coercedInVisibleBoundsOfInputTextMKHz9U(long r7) {
        /*
            r6 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r6.innerTextFieldCoordinates
            if (r0 == 0) goto L_0x0020
            r1 = 0
            boolean r2 = r0.isAttached()
            if (r2 == 0) goto L_0x0017
            androidx.compose.ui.layout.LayoutCoordinates r2 = r6.decorationBoxCoordinates
            r3 = 0
            if (r2 == 0) goto L_0x001d
            r4 = 0
            r5 = 2
            androidx.compose.ui.geometry.Rect r3 = androidx.compose.ui.layout.LayoutCoordinates.localBoundingBoxOf$default(r2, r0, r4, r5, r3)
            goto L_0x001d
        L_0x0017:
            androidx.compose.ui.geometry.Rect$Companion r2 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r3 = r2.getZero()
        L_0x001d:
            if (r3 != 0) goto L_0x0026
        L_0x0020:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r3 = r0.getZero()
        L_0x0026:
            r0 = r3
            long r1 = androidx.compose.foundation.text.TextLayoutResultProxyKt.m2695coerceIn3MmeM6k(r7, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextLayoutResultProxy.m2689coercedInVisibleBoundsOfInputTextMKHz9U(long):long");
    }
}

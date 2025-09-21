package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\u0007J(\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006\u000f"}, d2 = {"androidx/compose/foundation/gestures/DragGestureDetectorKt$VerticalPointerDirectionConfig$1", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "crossAxisDelta", "", "offset", "Landroidx/compose/ui/geometry/Offset;", "crossAxisDelta-k-4lQ0M", "(J)F", "mainAxisDelta", "mainAxisDelta-k-4lQ0M", "offsetFromChanges", "mainChange", "crossChange", "offsetFromChanges-dBAh8RU", "(FF)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragGestureDetector.kt */
public final class DragGestureDetectorKt$VerticalPointerDirectionConfig$1 implements PointerDirectionConfig {
    DragGestureDetectorKt$VerticalPointerDirectionConfig$1() {
    }

    /* renamed from: mainAxisDelta-k-4lQ0M  reason: not valid java name */
    public float m2009mainAxisDeltak4lQ0M(long offset) {
        return Offset.m4714getYimpl(offset);
    }

    /* renamed from: crossAxisDelta-k-4lQ0M  reason: not valid java name */
    public float m2008crossAxisDeltak4lQ0M(long offset) {
        return Offset.m4713getXimpl(offset);
    }

    /* renamed from: offsetFromChanges-dBAh8RU  reason: not valid java name */
    public long m2010offsetFromChangesdBAh8RU(float mainChange, float crossChange) {
        return OffsetKt.Offset(crossChange, mainChange);
    }
}

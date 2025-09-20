package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\t"}, d2 = {"androidx/compose/ui/layout/ContentScale$Companion$FillWidth$1", "Landroidx/compose/ui/layout/ContentScale;", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentScale.kt */
public final class ContentScale$Companion$FillWidth$1 implements ContentScale {
    ContentScale$Companion$FillWidth$1() {
    }

    /* renamed from: computeScaleFactor-H7hwNQA  reason: not valid java name */
    public long m6322computeScaleFactorH7hwNQA(long srcSize, long dstSize) {
        float it = ContentScaleKt.m6332computeFillWidthiLBOSCw(srcSize, dstSize);
        return ScaleFactorKt.ScaleFactor(it, it);
    }
}

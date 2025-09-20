package androidx.compose.material.pullrefresh;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Landroidx/compose/material/pullrefresh/ArrowValues;", "", "rotation", "", "startAngle", "endAngle", "scale", "(FFFF)V", "getEndAngle", "()F", "getRotation", "getScale", "getStartAngle", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullRefreshIndicator.kt */
final class ArrowValues {
    private final float endAngle;
    private final float rotation;
    private final float scale;
    private final float startAngle;

    public ArrowValues(float rotation2, float startAngle2, float endAngle2, float scale2) {
        this.rotation = rotation2;
        this.startAngle = startAngle2;
        this.endAngle = endAngle2;
        this.scale = scale2;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getStartAngle() {
        return this.startAngle;
    }

    public final float getEndAngle() {
        return this.endAngle;
    }

    public final float getScale() {
        return this.scale;
    }
}

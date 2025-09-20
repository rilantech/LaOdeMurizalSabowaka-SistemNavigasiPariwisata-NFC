package androidx.compose.ui.platform;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityManager;", "", "calculateRecommendedTimeoutMillis", "", "originalTimeoutMillis", "containsIcons", "", "containsText", "containsControls", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AccessibilityManager.kt */
public interface AccessibilityManager {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AccessibilityManager.kt */
    public static final class DefaultImpls {
    }

    long calculateRecommendedTimeoutMillis(long j, boolean z, boolean z2, boolean z3);

    static /* synthetic */ long calculateRecommendedTimeoutMillis$default(AccessibilityManager accessibilityManager, long j, boolean z, boolean z2, boolean z3, int i, Object obj) {
        boolean z4;
        boolean z5;
        boolean z6;
        if (obj == null) {
            if ((i & 2) != 0) {
                z4 = false;
            } else {
                z4 = z;
            }
            if ((i & 4) != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if ((i & 8) != 0) {
                z6 = false;
            } else {
                z6 = z3;
            }
            return accessibilityManager.calculateRecommendedTimeoutMillis(j, z4, z5, z6);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateRecommendedTimeoutMillis");
    }
}

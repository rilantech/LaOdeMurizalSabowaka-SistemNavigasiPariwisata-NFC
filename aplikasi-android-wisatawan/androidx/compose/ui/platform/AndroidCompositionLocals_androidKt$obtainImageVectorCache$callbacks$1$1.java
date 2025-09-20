package androidx.compose.ui.platform;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import androidx.compose.ui.res.ImageVectorCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"androidx/compose/ui/platform/AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1", "Landroid/content/ComponentCallbacks2;", "onConfigurationChanged", "", "configuration", "Landroid/content/res/Configuration;", "onLowMemory", "onTrimMemory", "level", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidCompositionLocals.android.kt */
public final class AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 implements ComponentCallbacks2 {
    final /* synthetic */ Configuration $currentConfiguration;
    final /* synthetic */ ImageVectorCache $imageVectorCache;

    AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1(Configuration $currentConfiguration2, ImageVectorCache $imageVectorCache2) {
        this.$currentConfiguration = $currentConfiguration2;
        this.$imageVectorCache = $imageVectorCache2;
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.$imageVectorCache.prune(this.$currentConfiguration.updateFrom(configuration));
        this.$currentConfiguration.setTo(configuration);
    }

    public void onLowMemory() {
        this.$imageVectorCache.clear();
    }

    public void onTrimMemory(int level) {
        this.$imageVectorCache.clear();
    }
}

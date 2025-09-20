package androidx.compose.ui.graphics;

import android.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/AndroidRenderEffect;", "Landroidx/compose/ui/graphics/RenderEffect;", "androidRenderEffect", "Landroid/graphics/RenderEffect;", "(Landroid/graphics/RenderEffect;)V", "getAndroidRenderEffect", "()Landroid/graphics/RenderEffect;", "createRenderEffect", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidRenderEffect.android.kt */
public final class AndroidRenderEffect extends RenderEffect {
    private final RenderEffect androidRenderEffect;

    public final RenderEffect getAndroidRenderEffect() {
        return this.androidRenderEffect;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidRenderEffect(RenderEffect androidRenderEffect2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(androidRenderEffect2, "androidRenderEffect");
        this.androidRenderEffect = androidRenderEffect2;
    }

    /* access modifiers changed from: protected */
    public RenderEffect createRenderEffect() {
        return this.androidRenderEffect;
    }
}

package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\u0004H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bX\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Brush;", "()V", "createdSize", "Landroidx/compose/ui/geometry/Size;", "J", "internalShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "applyTo", "", "size", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "createShader", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Brush.kt */
public abstract class ShaderBrush extends Brush {
    private long createdSize = Size.Companion.m4790getUnspecifiedNHjbRc();
    private Shader internalShader;

    /* renamed from: createShader-uvyYCjk  reason: not valid java name */
    public abstract Shader m5307createShaderuvyYCjk(long j);

    public ShaderBrush() {
        super((DefaultConstructorMarker) null);
    }

    /* renamed from: applyTo-Pq9zytI  reason: not valid java name */
    public final void m5306applyToPq9zytI(long size, Paint p, float alpha) {
        Intrinsics.checkNotNullParameter(p, "p");
        Shader shader = this.internalShader;
        if (shader == null || !Size.m4778equalsimpl0(this.createdSize, size)) {
            if (Size.m4784isEmptyimpl(size)) {
                shader = null;
                this.internalShader = null;
                this.createdSize = Size.Companion.m4790getUnspecifiedNHjbRc();
            } else {
                Shader it = m5307createShaderuvyYCjk(size);
                this.internalShader = it;
                shader = it;
                this.createdSize = size;
            }
        }
        if (!Color.m4964equalsimpl0(p.m5222getColor0d7_KjU(), Color.Companion.m4989getBlack0d7_KjU())) {
            p.m5228setColor8_81llA(Color.Companion.m4989getBlack0d7_KjU());
        }
        if (!Intrinsics.areEqual((Object) p.getShader(), (Object) shader)) {
            p.setShader(shader);
        }
        if (!(p.getAlpha() == alpha)) {
            p.setAlpha(alpha);
        }
    }
}

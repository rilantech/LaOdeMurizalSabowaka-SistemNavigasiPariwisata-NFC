package androidx.compose.ui.graphics;

import android.graphics.Shader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u0006*\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0012\u0010\t\u001a\u00020\u0002*\u00020\u0006ø\u0001\u0001¢\u0006\u0002\u0010\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/TileMode;", "isSupported-0vamqd0", "(I)Z", "toAndroidTileMode", "Landroid/graphics/Shader$TileMode;", "toAndroidTileMode-0vamqd0", "(I)Landroid/graphics/Shader$TileMode;", "toComposeTileMode", "(Landroid/graphics/Shader$TileMode;)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidTileMode.android.kt */
public final class AndroidTileMode_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidTileMode.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Shader.TileMode.values().length];
            try {
                iArr[Shader.TileMode.CLAMP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Shader.TileMode.MIRROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Shader.TileMode.REPEAT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: isSupported-0vamqd0  reason: not valid java name */
    public static final boolean m3148isSupported0vamqd0(int $this$isSupported_u2d0vamqd0) {
        return true;
    }

    /* renamed from: toAndroidTileMode-0vamqd0  reason: not valid java name */
    public static final Shader.TileMode m3149toAndroidTileMode0vamqd0(int $this$toAndroidTileMode_u2d0vamqd0) {
        if (TileMode.m3658equalsimpl0($this$toAndroidTileMode_u2d0vamqd0, TileMode.Companion.m3662getClamp3opZhB0())) {
            return Shader.TileMode.CLAMP;
        }
        if (TileMode.m3658equalsimpl0($this$toAndroidTileMode_u2d0vamqd0, TileMode.Companion.m3665getRepeated3opZhB0())) {
            return Shader.TileMode.REPEAT;
        }
        if (TileMode.m3658equalsimpl0($this$toAndroidTileMode_u2d0vamqd0, TileMode.Companion.m3664getMirror3opZhB0())) {
            return Shader.TileMode.MIRROR;
        }
        if (TileMode.m3658equalsimpl0($this$toAndroidTileMode_u2d0vamqd0, TileMode.Companion.m3663getDecal3opZhB0())) {
            return TileModeVerificationHelper.INSTANCE.getFrameworkTileModeDecal();
        }
        return Shader.TileMode.CLAMP;
    }

    public static final int toComposeTileMode(Shader.TileMode $this$toComposeTileMode) {
        Intrinsics.checkNotNullParameter($this$toComposeTileMode, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toComposeTileMode.ordinal()]) {
            case 1:
                return TileMode.Companion.m3662getClamp3opZhB0();
            case 2:
                return TileMode.Companion.m3664getMirror3opZhB0();
            case 3:
                return TileMode.Companion.m3665getRepeated3opZhB0();
            default:
                if ($this$toComposeTileMode == Shader.TileMode.DECAL) {
                    return TileModeVerificationHelper.INSTANCE.m3666getComposeTileModeDecal3opZhB0();
                }
                return TileMode.Companion.m3662getClamp3opZhB0();
        }
    }
}

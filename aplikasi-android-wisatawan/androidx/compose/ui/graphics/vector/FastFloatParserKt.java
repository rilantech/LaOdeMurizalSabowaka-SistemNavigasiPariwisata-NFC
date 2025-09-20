package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u0019\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\b\u001a\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\b\u001a\u0019\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\b\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0010"}, d2 = {"isDigit", "", "", "(C)Z", "charAt", "s", "", "index", "", "fullMultiplicationHighBits", "", "x", "y", "parseFourDigits", "str", "offset", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FastFloatParser.kt */
public final class FastFloatParserKt {
    private static final boolean isDigit(char $this$isDigit) {
        return ((char) ($this$isDigit + 65488)) < 10;
    }

    private static final char charAt(CharSequence s, int index) {
        if (index < s.length()) {
            return s.charAt(index);
        }
        return 0;
    }

    private static final long fullMultiplicationHighBits(long x, long y) {
        long xLo = x & 4294967295L;
        long xHi = x >>> 32;
        long yLo = y & 4294967295L;
        long yHi = y >>> 32;
        long xTimesYMid = xLo * yHi;
        return (xHi * yHi) + ((((xHi * yLo) + ((xLo * yLo) >>> 32)) + (4294967295L & xTimesYMid)) >>> 32) + (xTimesYMid >>> 32);
    }

    private static final int parseFourDigits(CharSequence str, int offset) {
        long v = ((long) str.charAt(offset)) | (((long) str.charAt(offset + 1)) << 16) | (((long) str.charAt(offset + 2)) << 32) | (((long) str.charAt(offset + 3)) << 48);
        long base = v - 13511005043687472L;
        if ((-35747867511423104L & ((19703549022044230L + v) | base)) != 0) {
            return -1;
        }
        return (int) ((281475406208040961L * base) >>> 48);
    }
}

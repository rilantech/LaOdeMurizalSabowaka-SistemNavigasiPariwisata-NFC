package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001Bª\u0001\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bø\u0001\u0000¢\u0006\u0002\u0010\u001cB¶\u0001\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eø\u0001\u0000¢\u0006\u0002\u0010\u001fBÂ\u0001\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!ø\u0001\u0000¢\u0006\u0002\u0010\"BÌ\u0001\b\u0016\u0012\b\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!ø\u0001\u0000¢\u0006\u0002\u0010'BÀ\u0001\b\u0000\u0012\u0006\u0010(\u001a\u00020)\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!ø\u0001\u0000¢\u0006\u0002\u0010*JÕ\u0001\u0010O\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJµ\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010SJÁ\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJË\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u0013\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010\u0001H\u0002J\u0015\u0010[\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\\J\u0015\u0010]\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u0000H\u0000¢\u0006\u0002\b^J\b\u0010_\u001a\u00020`H\u0016J\r\u0010a\u001a\u00020`H\u0000¢\u0006\u0002\bbJ\u0014\u0010c\u001a\u00020\u00002\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0000H\u0007J\u0011\u0010d\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020\u0000H\u0002J\b\u0010e\u001a\u00020\u000fH\u0016R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001c\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010#\u001a\u0004\u0018\u00010$8F¢\u0006\u0006\u001a\u0004\b2\u00103R\u001a\u0010\u0002\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b4\u0010.R\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010/\u001a\u0004\b;\u0010.R\u001c\u0010\b\u001a\u0004\u0018\u00010\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001c\u0010\u0010\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010/\u001a\u0004\bB\u0010.R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0014\u0010(\u001a\u00020)X\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\bM\u0010N\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006f"}, d2 = {"Landroidx/compose/ui/text/SpanStyle;", "", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "platformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "textForegroundStyle", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "(Landroidx/compose/ui/text/style/TextForegroundStyle;JLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlpha", "()F", "getBackground-0d7_KjU", "()J", "J", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getColor-0d7_KjU", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getFontSize-XSAIIZE", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getLetterSpacing-XSAIIZE", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformSpanStyle;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getTextForegroundStyle$ui_text_release", "()Landroidx/compose/ui/text/style/TextForegroundStyle;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "copy", "copy-NcG25M8", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "copy-IuqyXdg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;)Landroidx/compose/ui/text/SpanStyle;", "copy-2BkPm_w", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;)Landroidx/compose/ui/text/SpanStyle;", "copy-GSF8kmg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "equals", "", "other", "hasSameLayoutAffectingAttributes", "hasSameLayoutAffectingAttributes$ui_text_release", "hasSameNonLayoutAttributes", "hasSameNonLayoutAttributes$ui_text_release", "hashCode", "", "hashCodeLayoutAffectingAttributes", "hashCodeLayoutAffectingAttributes$ui_text_release", "merge", "plus", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SpanStyle.kt */
public final class SpanStyle {
    public static final int $stable = 0;
    private final long background;
    private final BaselineShift baselineShift;
    private final DrawStyle drawStyle;
    private final FontFamily fontFamily;
    private final String fontFeatureSettings;
    private final long fontSize;
    private final FontStyle fontStyle;
    private final FontSynthesis fontSynthesis;
    private final FontWeight fontWeight;
    private final long letterSpacing;
    private final LocaleList localeList;
    private final PlatformSpanStyle platformStyle;
    private final Shadow shadow;
    private final TextDecoration textDecoration;
    private final TextForegroundStyle textForegroundStyle;
    private final TextGeometricTransform textGeometricTransform;

    public /* synthetic */ SpanStyle(long j, long j2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j3, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j4, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j3, baselineShift2, textGeometricTransform2, localeList2, j4, textDecoration2, shadow2, platformSpanStyle, drawStyle2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "SpanStyle constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable constructor.")
    public /* synthetic */ SpanStyle(long j, long j2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j3, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j4, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformSpanStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j3, baselineShift2, textGeometricTransform2, localeList2, j4, textDecoration2, shadow2, platformSpanStyle);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "SpanStyle constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable constructor.")
    public /* synthetic */ SpanStyle(long j, long j2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j3, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j4, TextDecoration textDecoration2, Shadow shadow2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j3, baselineShift2, textGeometricTransform2, localeList2, j4, textDecoration2, shadow2);
    }

    public /* synthetic */ SpanStyle(Brush brush, float f, long j, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j2, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j3, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, f, j, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j2, baselineShift2, textGeometricTransform2, localeList2, j3, textDecoration2, shadow2, platformSpanStyle, drawStyle2);
    }

    public /* synthetic */ SpanStyle(TextForegroundStyle textForegroundStyle2, long j, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j2, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j3, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textForegroundStyle2, j, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j2, baselineShift2, textGeometricTransform2, localeList2, j3, textDecoration2, shadow2, platformSpanStyle, drawStyle2);
    }

    private SpanStyle(TextForegroundStyle textForegroundStyle2, long fontSize2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String fontFeatureSettings2, long letterSpacing2, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long background2, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformStyle2, DrawStyle drawStyle2) {
        TextForegroundStyle textForegroundStyle3 = textForegroundStyle2;
        Intrinsics.checkNotNullParameter(textForegroundStyle3, "textForegroundStyle");
        this.textForegroundStyle = textForegroundStyle3;
        this.fontSize = fontSize2;
        this.fontWeight = fontWeight2;
        this.fontStyle = fontStyle2;
        this.fontSynthesis = fontSynthesis2;
        this.fontFamily = fontFamily2;
        this.fontFeatureSettings = fontFeatureSettings2;
        this.letterSpacing = letterSpacing2;
        this.baselineShift = baselineShift2;
        this.textGeometricTransform = textGeometricTransform2;
        this.localeList = localeList2;
        this.background = background2;
        this.textDecoration = textDecoration2;
        this.shadow = shadow2;
        this.platformStyle = platformStyle2;
        this.drawStyle = drawStyle2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SpanStyle(androidx.compose.ui.text.style.TextForegroundStyle r25, long r26, androidx.compose.ui.text.font.FontWeight r28, androidx.compose.ui.text.font.FontStyle r29, androidx.compose.ui.text.font.FontSynthesis r30, androidx.compose.ui.text.font.FontFamily r31, java.lang.String r32, long r33, androidx.compose.ui.text.style.BaselineShift r35, androidx.compose.ui.text.style.TextGeometricTransform r36, androidx.compose.ui.text.intl.LocaleList r37, long r38, androidx.compose.ui.text.style.TextDecoration r40, androidx.compose.ui.graphics.Shadow r41, androidx.compose.ui.text.PlatformSpanStyle r42, androidx.compose.ui.graphics.drawscope.DrawStyle r43, int r44, kotlin.jvm.internal.DefaultConstructorMarker r45) {
        /*
            r24 = this;
            r0 = r44
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000e
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r1 = r1.m7746getUnspecifiedXSAIIZE()
            r5 = r1
            goto L_0x0010
        L_0x000e:
            r5 = r26
        L_0x0010:
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0017
            r7 = r2
            goto L_0x0019
        L_0x0017:
            r7 = r28
        L_0x0019:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001f
            r8 = r2
            goto L_0x0021
        L_0x001f:
            r8 = r29
        L_0x0021:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0027
            r9 = r2
            goto L_0x0029
        L_0x0027:
            r9 = r30
        L_0x0029:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x002f
            r10 = r2
            goto L_0x0031
        L_0x002f:
            r10 = r31
        L_0x0031:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0037
            r11 = r2
            goto L_0x0039
        L_0x0037:
            r11 = r32
        L_0x0039:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0045
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r1.m7746getUnspecifiedXSAIIZE()
            r12 = r3
            goto L_0x0047
        L_0x0045:
            r12 = r33
        L_0x0047:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004d
            r14 = r2
            goto L_0x004f
        L_0x004d:
            r14 = r35
        L_0x004f:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0055
            r15 = r2
            goto L_0x0057
        L_0x0055:
            r15 = r36
        L_0x0057:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x005e
            r16 = r2
            goto L_0x0060
        L_0x005e:
            r16 = r37
        L_0x0060:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x006d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r3 = r1.m4999getUnspecified0d7_KjU()
            r17 = r3
            goto L_0x006f
        L_0x006d:
            r17 = r38
        L_0x006f:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0076
            r19 = r2
            goto L_0x0078
        L_0x0076:
            r19 = r40
        L_0x0078:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x007f
            r20 = r2
            goto L_0x0081
        L_0x007f:
            r20 = r41
        L_0x0081:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0088
            r21 = r2
            goto L_0x008a
        L_0x0088:
            r21 = r42
        L_0x008a:
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0093
            r22 = r2
            goto L_0x0095
        L_0x0093:
            r22 = r43
        L_0x0095:
            r23 = 0
            r3 = r24
            r4 = r25
            r3.<init>((androidx.compose.ui.text.style.TextForegroundStyle) r4, (long) r5, (androidx.compose.ui.text.font.FontWeight) r7, (androidx.compose.ui.text.font.FontStyle) r8, (androidx.compose.ui.text.font.FontSynthesis) r9, (androidx.compose.ui.text.font.FontFamily) r10, (java.lang.String) r11, (long) r12, (androidx.compose.ui.text.style.BaselineShift) r14, (androidx.compose.ui.text.style.TextGeometricTransform) r15, (androidx.compose.ui.text.intl.LocaleList) r16, (long) r17, (androidx.compose.ui.text.style.TextDecoration) r19, (androidx.compose.ui.graphics.Shadow) r20, (androidx.compose.ui.text.PlatformSpanStyle) r21, (androidx.compose.ui.graphics.drawscope.DrawStyle) r22, (kotlin.jvm.internal.DefaultConstructorMarker) r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyle.<init>(androidx.compose.ui.text.style.TextForegroundStyle, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.PlatformSpanStyle, androidx.compose.ui.graphics.drawscope.DrawStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final TextForegroundStyle getTextForegroundStyle$ui_text_release() {
        return this.textForegroundStyle;
    }

    /* renamed from: getFontSize-XSAIIZE  reason: not valid java name */
    public final long m6995getFontSizeXSAIIZE() {
        return this.fontSize;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* renamed from: getFontStyle-4Lr2A7w  reason: not valid java name */
    public final FontStyle m6996getFontStyle4Lr2A7w() {
        return this.fontStyle;
    }

    /* renamed from: getFontSynthesis-ZQGJjVo  reason: not valid java name */
    public final FontSynthesis m6997getFontSynthesisZQGJjVo() {
        return this.fontSynthesis;
    }

    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    /* renamed from: getLetterSpacing-XSAIIZE  reason: not valid java name */
    public final long m6998getLetterSpacingXSAIIZE() {
        return this.letterSpacing;
    }

    /* renamed from: getBaselineShift-5SSeXJ0  reason: not valid java name */
    public final BaselineShift m6993getBaselineShift5SSeXJ0() {
        return this.baselineShift;
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.textGeometricTransform;
    }

    public final LocaleList getLocaleList() {
        return this.localeList;
    }

    /* renamed from: getBackground-0d7_KjU  reason: not valid java name */
    public final long m6992getBackground0d7_KjU() {
        return this.background;
    }

    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    public final PlatformSpanStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SpanStyle(long r20, long r22, androidx.compose.ui.text.font.FontWeight r24, androidx.compose.ui.text.font.FontStyle r25, androidx.compose.ui.text.font.FontSynthesis r26, androidx.compose.ui.text.font.FontFamily r27, java.lang.String r28, long r29, androidx.compose.ui.text.style.BaselineShift r31, androidx.compose.ui.text.style.TextGeometricTransform r32, androidx.compose.ui.text.intl.LocaleList r33, long r34, androidx.compose.ui.text.style.TextDecoration r36, androidx.compose.ui.graphics.Shadow r37, int r38, kotlin.jvm.internal.DefaultConstructorMarker r39) {
        /*
            r19 = this;
            r0 = r38
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m4999getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r20
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m7746getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r22
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r24
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r25
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r26
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r27
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r28
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m7746getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r29
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r31
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r32
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r33
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m4999getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r34
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r36
        L_0x007e:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0084
            r0 = 0
            goto L_0x0086
        L_0x0084:
            r0 = r37
        L_0x0086:
            r18 = 0
            r39 = r18
            r20 = r19
            r21 = r1
            r23 = r3
            r25 = r5
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r10
            r30 = r11
            r32 = r13
            r33 = r14
            r34 = r15
            r35 = r16
            r37 = r6
            r38 = r0
            r20.<init>((long) r21, (long) r23, (androidx.compose.ui.text.font.FontWeight) r25, (androidx.compose.ui.text.font.FontStyle) r26, (androidx.compose.ui.text.font.FontSynthesis) r27, (androidx.compose.ui.text.font.FontFamily) r28, (java.lang.String) r29, (long) r30, (androidx.compose.ui.text.style.BaselineShift) r32, (androidx.compose.ui.text.style.TextGeometricTransform) r33, (androidx.compose.ui.text.intl.LocaleList) r34, (long) r35, (androidx.compose.ui.text.style.TextDecoration) r37, (androidx.compose.ui.graphics.Shadow) r38, (kotlin.jvm.internal.DefaultConstructorMarker) r39)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private SpanStyle(long color, long fontSize2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String fontFeatureSettings2, long letterSpacing2, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long background2, TextDecoration textDecoration2, Shadow shadow2) {
        this(TextForegroundStyle.Companion.m7437from8_81llA(color), fontSize2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings2, letterSpacing2, baselineShift2, textGeometricTransform2, localeList2, background2, textDecoration2, shadow2, (PlatformSpanStyle) null, (DrawStyle) null, 32768, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SpanStyle(long r21, long r23, androidx.compose.ui.text.font.FontWeight r25, androidx.compose.ui.text.font.FontStyle r26, androidx.compose.ui.text.font.FontSynthesis r27, androidx.compose.ui.text.font.FontFamily r28, java.lang.String r29, long r30, androidx.compose.ui.text.style.BaselineShift r32, androidx.compose.ui.text.style.TextGeometricTransform r33, androidx.compose.ui.text.intl.LocaleList r34, long r35, androidx.compose.ui.text.style.TextDecoration r37, androidx.compose.ui.graphics.Shadow r38, androidx.compose.ui.text.PlatformSpanStyle r39, int r40, kotlin.jvm.internal.DefaultConstructorMarker r41) {
        /*
            r20 = this;
            r0 = r40
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m4999getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r21
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m7746getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r23
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r25
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r26
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r27
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r28
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r29
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m7746getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r30
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r32
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r33
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r34
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m4999getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r35
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r37
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r38
        L_0x0088:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x008e
            r0 = 0
            goto L_0x0090
        L_0x008e:
            r0 = r39
        L_0x0090:
            r19 = 0
            r41 = r19
            r21 = r20
            r22 = r1
            r24 = r3
            r26 = r5
            r27 = r7
            r28 = r8
            r29 = r9
            r30 = r10
            r31 = r11
            r33 = r13
            r34 = r14
            r35 = r15
            r36 = r16
            r38 = r18
            r39 = r6
            r40 = r0
            r21.<init>((long) r22, (long) r24, (androidx.compose.ui.text.font.FontWeight) r26, (androidx.compose.ui.text.font.FontStyle) r27, (androidx.compose.ui.text.font.FontSynthesis) r28, (androidx.compose.ui.text.font.FontFamily) r29, (java.lang.String) r30, (long) r31, (androidx.compose.ui.text.style.BaselineShift) r33, (androidx.compose.ui.text.style.TextGeometricTransform) r34, (androidx.compose.ui.text.intl.LocaleList) r35, (long) r36, (androidx.compose.ui.text.style.TextDecoration) r38, (androidx.compose.ui.graphics.Shadow) r39, (androidx.compose.ui.text.PlatformSpanStyle) r40, (kotlin.jvm.internal.DefaultConstructorMarker) r41)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.PlatformSpanStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private SpanStyle(long color, long fontSize2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String fontFeatureSettings2, long letterSpacing2, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long background2, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformStyle2) {
        this(TextForegroundStyle.Companion.m7437from8_81llA(color), fontSize2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings2, letterSpacing2, baselineShift2, textGeometricTransform2, localeList2, background2, textDecoration2, shadow2, platformStyle2, (DrawStyle) null, 32768, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SpanStyle(long r22, long r24, androidx.compose.ui.text.font.FontWeight r26, androidx.compose.ui.text.font.FontStyle r27, androidx.compose.ui.text.font.FontSynthesis r28, androidx.compose.ui.text.font.FontFamily r29, java.lang.String r30, long r31, androidx.compose.ui.text.style.BaselineShift r33, androidx.compose.ui.text.style.TextGeometricTransform r34, androidx.compose.ui.text.intl.LocaleList r35, long r36, androidx.compose.ui.text.style.TextDecoration r38, androidx.compose.ui.graphics.Shadow r39, androidx.compose.ui.text.PlatformSpanStyle r40, androidx.compose.ui.graphics.drawscope.DrawStyle r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r21 = this;
            r0 = r42
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m4999getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r22
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m7746getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r24
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r26
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r27
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r28
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r29
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r30
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m7746getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r31
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r33
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r34
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r35
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m4999getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r36
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r38
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r39
        L_0x0088:
            r19 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0090
            r6 = 0
            goto L_0x0092
        L_0x0090:
            r6 = r40
        L_0x0092:
            r20 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r20
            if (r0 == 0) goto L_0x009b
            r0 = 0
            goto L_0x009d
        L_0x009b:
            r0 = r41
        L_0x009d:
            r20 = 0
            r43 = r20
            r22 = r21
            r23 = r1
            r25 = r3
            r27 = r5
            r28 = r7
            r29 = r8
            r30 = r9
            r31 = r10
            r32 = r11
            r34 = r13
            r35 = r14
            r36 = r15
            r37 = r16
            r39 = r18
            r40 = r19
            r41 = r6
            r42 = r0
            r22.<init>((long) r23, (long) r25, (androidx.compose.ui.text.font.FontWeight) r27, (androidx.compose.ui.text.font.FontStyle) r28, (androidx.compose.ui.text.font.FontSynthesis) r29, (androidx.compose.ui.text.font.FontFamily) r30, (java.lang.String) r31, (long) r32, (androidx.compose.ui.text.style.BaselineShift) r34, (androidx.compose.ui.text.style.TextGeometricTransform) r35, (androidx.compose.ui.text.intl.LocaleList) r36, (long) r37, (androidx.compose.ui.text.style.TextDecoration) r39, (androidx.compose.ui.graphics.Shadow) r40, (androidx.compose.ui.text.PlatformSpanStyle) r41, (androidx.compose.ui.graphics.drawscope.DrawStyle) r42, (kotlin.jvm.internal.DefaultConstructorMarker) r43)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.PlatformSpanStyle, androidx.compose.ui.graphics.drawscope.DrawStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private SpanStyle(long color, long fontSize2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String fontFeatureSettings2, long letterSpacing2, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long background2, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformStyle2, DrawStyle drawStyle2) {
        this(TextForegroundStyle.Companion.m7437from8_81llA(color), fontSize2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings2, letterSpacing2, baselineShift2, textGeometricTransform2, localeList2, background2, textDecoration2, shadow2, platformStyle2, drawStyle2, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SpanStyle(androidx.compose.ui.graphics.Brush r25, float r26, long r27, androidx.compose.ui.text.font.FontWeight r29, androidx.compose.ui.text.font.FontStyle r30, androidx.compose.ui.text.font.FontSynthesis r31, androidx.compose.ui.text.font.FontFamily r32, java.lang.String r33, long r34, androidx.compose.ui.text.style.BaselineShift r36, androidx.compose.ui.text.style.TextGeometricTransform r37, androidx.compose.ui.text.intl.LocaleList r38, long r39, androidx.compose.ui.text.style.TextDecoration r41, androidx.compose.ui.graphics.Shadow r42, androidx.compose.ui.text.PlatformSpanStyle r43, androidx.compose.ui.graphics.drawscope.DrawStyle r44, int r45, kotlin.jvm.internal.DefaultConstructorMarker r46) {
        /*
            r24 = this;
            r0 = r45
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            r1 = 2143289344(0x7fc00000, float:NaN)
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r26
        L_0x000c:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0018
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r1 = r1.m7746getUnspecifiedXSAIIZE()
            r5 = r1
            goto L_0x001a
        L_0x0018:
            r5 = r27
        L_0x001a:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0021
            r7 = r2
            goto L_0x0023
        L_0x0021:
            r7 = r29
        L_0x0023:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0029
            r8 = r2
            goto L_0x002b
        L_0x0029:
            r8 = r30
        L_0x002b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0031
            r9 = r2
            goto L_0x0033
        L_0x0031:
            r9 = r31
        L_0x0033:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0039
            r10 = r2
            goto L_0x003b
        L_0x0039:
            r10 = r32
        L_0x003b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0041
            r11 = r2
            goto L_0x0043
        L_0x0041:
            r11 = r33
        L_0x0043:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004e
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r12 = r1.m7746getUnspecifiedXSAIIZE()
            goto L_0x0050
        L_0x004e:
            r12 = r34
        L_0x0050:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0056
            r14 = r2
            goto L_0x0058
        L_0x0056:
            r14 = r36
        L_0x0058:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x005e
            r15 = r2
            goto L_0x0060
        L_0x005e:
            r15 = r37
        L_0x0060:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0067
            r16 = r2
            goto L_0x0069
        L_0x0067:
            r16 = r38
        L_0x0069:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r17 = r1.m4999getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r17 = r39
        L_0x0076:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x007d
            r19 = r2
            goto L_0x007f
        L_0x007d:
            r19 = r41
        L_0x007f:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0086
            r20 = r2
            goto L_0x0088
        L_0x0086:
            r20 = r42
        L_0x0088:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0091
            r21 = r2
            goto L_0x0093
        L_0x0091:
            r21 = r43
        L_0x0093:
            r1 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x009b
            r22 = r2
            goto L_0x009d
        L_0x009b:
            r22 = r44
        L_0x009d:
            r23 = 0
            r2 = r24
            r3 = r25
            r2.<init>((androidx.compose.ui.graphics.Brush) r3, (float) r4, (long) r5, (androidx.compose.ui.text.font.FontWeight) r7, (androidx.compose.ui.text.font.FontStyle) r8, (androidx.compose.ui.text.font.FontSynthesis) r9, (androidx.compose.ui.text.font.FontFamily) r10, (java.lang.String) r11, (long) r12, (androidx.compose.ui.text.style.BaselineShift) r14, (androidx.compose.ui.text.style.TextGeometricTransform) r15, (androidx.compose.ui.text.intl.LocaleList) r16, (long) r17, (androidx.compose.ui.text.style.TextDecoration) r19, (androidx.compose.ui.graphics.Shadow) r20, (androidx.compose.ui.text.PlatformSpanStyle) r21, (androidx.compose.ui.graphics.drawscope.DrawStyle) r22, (kotlin.jvm.internal.DefaultConstructorMarker) r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyle.<init>(androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.PlatformSpanStyle, androidx.compose.ui.graphics.drawscope.DrawStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private SpanStyle(Brush brush, float alpha, long fontSize2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String fontFeatureSettings2, long letterSpacing2, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long background2, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformStyle2, DrawStyle drawStyle2) {
        this(TextForegroundStyle.Companion.from(brush, alpha), fontSize2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings2, letterSpacing2, baselineShift2, textGeometricTransform2, localeList2, background2, textDecoration2, shadow2, platformStyle2, drawStyle2, (DefaultConstructorMarker) null);
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m6994getColor0d7_KjU() {
        return this.textForegroundStyle.m7436getColor0d7_KjU();
    }

    public final Brush getBrush() {
        return this.textForegroundStyle.getBrush();
    }

    public final float getAlpha() {
        return this.textForegroundStyle.getAlpha();
    }

    public static /* synthetic */ SpanStyle merge$default(SpanStyle spanStyle, SpanStyle spanStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            spanStyle2 = null;
        }
        return spanStyle.merge(spanStyle2);
    }

    public final SpanStyle merge(SpanStyle other) {
        SpanStyle spanStyle = other;
        if (spanStyle == null) {
            return this;
        }
        return SpanStyleKt.m6999fastMergedSHsh3o(this, spanStyle.textForegroundStyle.m7436getColor0d7_KjU(), spanStyle.textForegroundStyle.getBrush(), spanStyle.textForegroundStyle.getAlpha(), spanStyle.fontSize, spanStyle.fontWeight, spanStyle.fontStyle, spanStyle.fontSynthesis, spanStyle.fontFamily, spanStyle.fontFeatureSettings, spanStyle.letterSpacing, spanStyle.baselineShift, spanStyle.textGeometricTransform, spanStyle.localeList, spanStyle.background, spanStyle.textDecoration, spanStyle.shadow, spanStyle.platformStyle, spanStyle.drawStyle);
    }

    public final SpanStyle plus(SpanStyle other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return merge(other);
    }

    /* renamed from: copy-IuqyXdg$default  reason: not valid java name */
    public static /* synthetic */ SpanStyle m6986copyIuqyXdg$default(SpanStyle spanStyle, long j, long j2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j3, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j4, TextDecoration textDecoration2, Shadow shadow2, int i, Object obj) {
        long j5;
        long j6;
        FontWeight fontWeight3;
        FontStyle fontStyle3;
        FontSynthesis fontSynthesis3;
        FontFamily fontFamily3;
        String str2;
        long j7;
        BaselineShift baselineShift3;
        TextGeometricTransform textGeometricTransform3;
        LocaleList localeList3;
        TextGeometricTransform textGeometricTransform4;
        long j8;
        TextDecoration textDecoration3;
        Shadow shadow3;
        SpanStyle spanStyle2 = spanStyle;
        int i2 = i;
        if ((i2 & 1) != 0) {
            j5 = spanStyle.m6994getColor0d7_KjU();
        } else {
            j5 = j;
        }
        if ((i2 & 2) != 0) {
            j6 = spanStyle2.fontSize;
        } else {
            j6 = j2;
        }
        if ((i2 & 4) != 0) {
            fontWeight3 = spanStyle2.fontWeight;
        } else {
            fontWeight3 = fontWeight2;
        }
        if ((i2 & 8) != 0) {
            fontStyle3 = spanStyle2.fontStyle;
        } else {
            fontStyle3 = fontStyle2;
        }
        if ((i2 & 16) != 0) {
            fontSynthesis3 = spanStyle2.fontSynthesis;
        } else {
            fontSynthesis3 = fontSynthesis2;
        }
        if ((i2 & 32) != 0) {
            fontFamily3 = spanStyle2.fontFamily;
        } else {
            fontFamily3 = fontFamily2;
        }
        if ((i2 & 64) != 0) {
            str2 = spanStyle2.fontFeatureSettings;
        } else {
            str2 = str;
        }
        if ((i2 & 128) != 0) {
            j7 = spanStyle2.letterSpacing;
        } else {
            j7 = j3;
        }
        if ((i2 & 256) != 0) {
            baselineShift3 = spanStyle2.baselineShift;
        } else {
            baselineShift3 = baselineShift2;
        }
        if ((i2 & 512) != 0) {
            textGeometricTransform3 = spanStyle2.textGeometricTransform;
        } else {
            textGeometricTransform3 = textGeometricTransform2;
        }
        if ((i2 & 1024) != 0) {
            localeList3 = spanStyle2.localeList;
        } else {
            localeList3 = localeList2;
        }
        LocaleList localeList4 = localeList3;
        if ((i2 & 2048) != 0) {
            textGeometricTransform4 = textGeometricTransform3;
            j8 = spanStyle2.background;
        } else {
            textGeometricTransform4 = textGeometricTransform3;
            j8 = j4;
        }
        long j9 = j8;
        if ((i2 & 4096) != 0) {
            textDecoration3 = spanStyle2.textDecoration;
        } else {
            textDecoration3 = textDecoration2;
        }
        if ((i2 & 8192) != 0) {
            shadow3 = spanStyle2.shadow;
        } else {
            shadow3 = shadow2;
        }
        return spanStyle.m6990copyIuqyXdg(j5, j6, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str2, j7, baselineShift3, textGeometricTransform4, localeList4, j9, textDecoration3, shadow3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "SpanStyle copy constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-IuqyXdg  reason: not valid java name */
    public final /* synthetic */ SpanStyle m6990copyIuqyXdg(long color, long fontSize2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String fontFeatureSettings2, long letterSpacing2, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long background2, TextDecoration textDecoration2, Shadow shadow2) {
        TextForegroundStyle textForegroundStyle2;
        long j = color;
        if (Color.m4964equalsimpl0(j, m6994getColor0d7_KjU())) {
            textForegroundStyle2 = this.textForegroundStyle;
        } else {
            textForegroundStyle2 = TextForegroundStyle.Companion.m7437from8_81llA(j);
        }
        return new SpanStyle(textForegroundStyle2, fontSize2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings2, letterSpacing2, baselineShift2, textGeometricTransform2, localeList2, background2, textDecoration2, shadow2, this.platformStyle, this.drawStyle, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-2BkPm_w$default  reason: not valid java name */
    public static /* synthetic */ SpanStyle m6984copy2BkPm_w$default(SpanStyle spanStyle, long j, long j2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j3, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j4, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformSpanStyle, int i, Object obj) {
        long j5;
        long j6;
        FontWeight fontWeight3;
        FontStyle fontStyle3;
        FontSynthesis fontSynthesis3;
        FontFamily fontFamily3;
        String str2;
        long j7;
        BaselineShift baselineShift3;
        TextGeometricTransform textGeometricTransform3;
        LocaleList localeList3;
        TextGeometricTransform textGeometricTransform4;
        long j8;
        TextDecoration textDecoration3;
        Shadow shadow3;
        PlatformSpanStyle platformSpanStyle2;
        SpanStyle spanStyle2 = spanStyle;
        int i2 = i;
        if ((i2 & 1) != 0) {
            j5 = spanStyle.m6994getColor0d7_KjU();
        } else {
            j5 = j;
        }
        if ((i2 & 2) != 0) {
            j6 = spanStyle2.fontSize;
        } else {
            j6 = j2;
        }
        if ((i2 & 4) != 0) {
            fontWeight3 = spanStyle2.fontWeight;
        } else {
            fontWeight3 = fontWeight2;
        }
        if ((i2 & 8) != 0) {
            fontStyle3 = spanStyle2.fontStyle;
        } else {
            fontStyle3 = fontStyle2;
        }
        if ((i2 & 16) != 0) {
            fontSynthesis3 = spanStyle2.fontSynthesis;
        } else {
            fontSynthesis3 = fontSynthesis2;
        }
        if ((i2 & 32) != 0) {
            fontFamily3 = spanStyle2.fontFamily;
        } else {
            fontFamily3 = fontFamily2;
        }
        if ((i2 & 64) != 0) {
            str2 = spanStyle2.fontFeatureSettings;
        } else {
            str2 = str;
        }
        if ((i2 & 128) != 0) {
            j7 = spanStyle2.letterSpacing;
        } else {
            j7 = j3;
        }
        if ((i2 & 256) != 0) {
            baselineShift3 = spanStyle2.baselineShift;
        } else {
            baselineShift3 = baselineShift2;
        }
        if ((i2 & 512) != 0) {
            textGeometricTransform3 = spanStyle2.textGeometricTransform;
        } else {
            textGeometricTransform3 = textGeometricTransform2;
        }
        if ((i2 & 1024) != 0) {
            localeList3 = spanStyle2.localeList;
        } else {
            localeList3 = localeList2;
        }
        LocaleList localeList4 = localeList3;
        if ((i2 & 2048) != 0) {
            textGeometricTransform4 = textGeometricTransform3;
            j8 = spanStyle2.background;
        } else {
            textGeometricTransform4 = textGeometricTransform3;
            j8 = j4;
        }
        long j9 = j8;
        if ((i2 & 4096) != 0) {
            textDecoration3 = spanStyle2.textDecoration;
        } else {
            textDecoration3 = textDecoration2;
        }
        if ((i2 & 8192) != 0) {
            shadow3 = spanStyle2.shadow;
        } else {
            shadow3 = shadow2;
        }
        if ((i2 & 16384) != 0) {
            platformSpanStyle2 = spanStyle2.platformStyle;
        } else {
            platformSpanStyle2 = platformSpanStyle;
        }
        return spanStyle.m6988copy2BkPm_w(j5, j6, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str2, j7, baselineShift3, textGeometricTransform4, localeList4, j9, textDecoration3, shadow3, platformSpanStyle2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "SpanStyle copy constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-2BkPm_w  reason: not valid java name */
    public final /* synthetic */ SpanStyle m6988copy2BkPm_w(long color, long fontSize2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String fontFeatureSettings2, long letterSpacing2, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long background2, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformStyle2) {
        TextForegroundStyle textForegroundStyle2;
        long j = color;
        if (Color.m4964equalsimpl0(j, m6994getColor0d7_KjU())) {
            textForegroundStyle2 = this.textForegroundStyle;
        } else {
            textForegroundStyle2 = TextForegroundStyle.Companion.m7437from8_81llA(j);
        }
        return new SpanStyle(textForegroundStyle2, fontSize2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings2, letterSpacing2, baselineShift2, textGeometricTransform2, localeList2, background2, textDecoration2, shadow2, platformStyle2, (DrawStyle) null, 32768, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-GSF8kmg$default  reason: not valid java name */
    public static /* synthetic */ SpanStyle m6985copyGSF8kmg$default(SpanStyle spanStyle, long j, long j2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j3, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j4, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle2, int i, Object obj) {
        long j5;
        long j6;
        FontWeight fontWeight3;
        FontStyle fontStyle3;
        FontSynthesis fontSynthesis3;
        FontFamily fontFamily3;
        String str2;
        long j7;
        BaselineShift baselineShift3;
        TextGeometricTransform textGeometricTransform3;
        LocaleList localeList3;
        TextGeometricTransform textGeometricTransform4;
        long j8;
        TextDecoration textDecoration3;
        Shadow shadow3;
        PlatformSpanStyle platformSpanStyle2;
        DrawStyle drawStyle3;
        SpanStyle spanStyle2 = spanStyle;
        int i2 = i;
        if ((i2 & 1) != 0) {
            j5 = spanStyle.m6994getColor0d7_KjU();
        } else {
            j5 = j;
        }
        if ((i2 & 2) != 0) {
            j6 = spanStyle2.fontSize;
        } else {
            j6 = j2;
        }
        if ((i2 & 4) != 0) {
            fontWeight3 = spanStyle2.fontWeight;
        } else {
            fontWeight3 = fontWeight2;
        }
        if ((i2 & 8) != 0) {
            fontStyle3 = spanStyle2.fontStyle;
        } else {
            fontStyle3 = fontStyle2;
        }
        if ((i2 & 16) != 0) {
            fontSynthesis3 = spanStyle2.fontSynthesis;
        } else {
            fontSynthesis3 = fontSynthesis2;
        }
        if ((i2 & 32) != 0) {
            fontFamily3 = spanStyle2.fontFamily;
        } else {
            fontFamily3 = fontFamily2;
        }
        if ((i2 & 64) != 0) {
            str2 = spanStyle2.fontFeatureSettings;
        } else {
            str2 = str;
        }
        if ((i2 & 128) != 0) {
            j7 = spanStyle2.letterSpacing;
        } else {
            j7 = j3;
        }
        if ((i2 & 256) != 0) {
            baselineShift3 = spanStyle2.baselineShift;
        } else {
            baselineShift3 = baselineShift2;
        }
        if ((i2 & 512) != 0) {
            textGeometricTransform3 = spanStyle2.textGeometricTransform;
        } else {
            textGeometricTransform3 = textGeometricTransform2;
        }
        if ((i2 & 1024) != 0) {
            localeList3 = spanStyle2.localeList;
        } else {
            localeList3 = localeList2;
        }
        LocaleList localeList4 = localeList3;
        if ((i2 & 2048) != 0) {
            textGeometricTransform4 = textGeometricTransform3;
            j8 = spanStyle2.background;
        } else {
            textGeometricTransform4 = textGeometricTransform3;
            j8 = j4;
        }
        long j9 = j8;
        if ((i2 & 4096) != 0) {
            textDecoration3 = spanStyle2.textDecoration;
        } else {
            textDecoration3 = textDecoration2;
        }
        if ((i2 & 8192) != 0) {
            shadow3 = spanStyle2.shadow;
        } else {
            shadow3 = shadow2;
        }
        Shadow shadow4 = shadow3;
        if ((i2 & 16384) != 0) {
            platformSpanStyle2 = spanStyle2.platformStyle;
        } else {
            platformSpanStyle2 = platformSpanStyle;
        }
        if ((i2 & 32768) != 0) {
            drawStyle3 = spanStyle2.drawStyle;
        } else {
            drawStyle3 = drawStyle2;
        }
        return spanStyle.m6989copyGSF8kmg(j5, j6, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str2, j7, baselineShift3, textGeometricTransform4, localeList4, j9, textDecoration3, shadow4, platformSpanStyle2, drawStyle3);
    }

    /* renamed from: copy-GSF8kmg  reason: not valid java name */
    public final SpanStyle m6989copyGSF8kmg(long color, long fontSize2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String fontFeatureSettings2, long letterSpacing2, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long background2, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformStyle2, DrawStyle drawStyle2) {
        TextForegroundStyle textForegroundStyle2;
        long j = color;
        if (Color.m4964equalsimpl0(j, m6994getColor0d7_KjU())) {
            textForegroundStyle2 = this.textForegroundStyle;
        } else {
            textForegroundStyle2 = TextForegroundStyle.Companion.m7437from8_81llA(j);
        }
        return new SpanStyle(textForegroundStyle2, fontSize2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings2, letterSpacing2, baselineShift2, textGeometricTransform2, localeList2, background2, textDecoration2, shadow2, platformStyle2, drawStyle2, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-NcG25M8$default  reason: not valid java name */
    public static /* synthetic */ SpanStyle m6987copyNcG25M8$default(SpanStyle spanStyle, Brush brush, float f, long j, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j2, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j3, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle2, int i, Object obj) {
        float f2;
        long j4;
        FontWeight fontWeight3;
        FontStyle fontStyle3;
        FontSynthesis fontSynthesis3;
        FontFamily fontFamily3;
        String str2;
        long j5;
        BaselineShift baselineShift3;
        TextGeometricTransform textGeometricTransform3;
        LocaleList localeList3;
        LocaleList localeList4;
        long j6;
        TextDecoration textDecoration3;
        Shadow shadow3;
        Shadow shadow4;
        PlatformSpanStyle platformSpanStyle2;
        DrawStyle drawStyle3;
        SpanStyle spanStyle2 = spanStyle;
        int i2 = i;
        if ((i2 & 2) != 0) {
            f2 = spanStyle.getAlpha();
        } else {
            f2 = f;
        }
        if ((i2 & 4) != 0) {
            j4 = spanStyle2.fontSize;
        } else {
            j4 = j;
        }
        if ((i2 & 8) != 0) {
            fontWeight3 = spanStyle2.fontWeight;
        } else {
            fontWeight3 = fontWeight2;
        }
        if ((i2 & 16) != 0) {
            fontStyle3 = spanStyle2.fontStyle;
        } else {
            fontStyle3 = fontStyle2;
        }
        if ((i2 & 32) != 0) {
            fontSynthesis3 = spanStyle2.fontSynthesis;
        } else {
            fontSynthesis3 = fontSynthesis2;
        }
        if ((i2 & 64) != 0) {
            fontFamily3 = spanStyle2.fontFamily;
        } else {
            fontFamily3 = fontFamily2;
        }
        if ((i2 & 128) != 0) {
            str2 = spanStyle2.fontFeatureSettings;
        } else {
            str2 = str;
        }
        if ((i2 & 256) != 0) {
            j5 = spanStyle2.letterSpacing;
        } else {
            j5 = j2;
        }
        if ((i2 & 512) != 0) {
            baselineShift3 = spanStyle2.baselineShift;
        } else {
            baselineShift3 = baselineShift2;
        }
        if ((i2 & 1024) != 0) {
            textGeometricTransform3 = spanStyle2.textGeometricTransform;
        } else {
            textGeometricTransform3 = textGeometricTransform2;
        }
        if ((i2 & 2048) != 0) {
            localeList3 = spanStyle2.localeList;
        } else {
            localeList3 = localeList2;
        }
        if ((i2 & 4096) != 0) {
            localeList4 = localeList3;
            j6 = spanStyle2.background;
        } else {
            localeList4 = localeList3;
            j6 = j3;
        }
        long j7 = j6;
        if ((i2 & 8192) != 0) {
            textDecoration3 = spanStyle2.textDecoration;
        } else {
            textDecoration3 = textDecoration2;
        }
        if ((i2 & 16384) != 0) {
            shadow3 = spanStyle2.shadow;
        } else {
            shadow3 = shadow2;
        }
        if ((i2 & 32768) != 0) {
            shadow4 = shadow3;
            platformSpanStyle2 = spanStyle2.platformStyle;
        } else {
            shadow4 = shadow3;
            platformSpanStyle2 = platformSpanStyle;
        }
        if ((i2 & 65536) != 0) {
            drawStyle3 = spanStyle2.drawStyle;
        } else {
            drawStyle3 = drawStyle2;
        }
        return spanStyle.m6991copyNcG25M8(brush, f2, j4, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str2, j5, baselineShift3, textGeometricTransform3, localeList4, j7, textDecoration3, shadow4, platformSpanStyle2, drawStyle3);
    }

    /* renamed from: copy-NcG25M8  reason: not valid java name */
    public final SpanStyle m6991copyNcG25M8(Brush brush, float alpha, long fontSize2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String fontFeatureSettings2, long letterSpacing2, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long background2, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformStyle2, DrawStyle drawStyle2) {
        return new SpanStyle(TextForegroundStyle.Companion.from(brush, alpha), fontSize2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings2, letterSpacing2, baselineShift2, textGeometricTransform2, localeList2, background2, textDecoration2, shadow2, platformStyle2, drawStyle2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpanStyle)) {
            return false;
        }
        if (!hasSameLayoutAffectingAttributes$ui_text_release((SpanStyle) other) || !hasSameNonLayoutAttributes$ui_text_release((SpanStyle) other)) {
            return false;
        }
        return true;
    }

    public final boolean hasSameLayoutAffectingAttributes$ui_text_release(SpanStyle other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this == other) {
            return true;
        }
        if (TextUnit.m7732equalsimpl0(this.fontSize, other.fontSize) && Intrinsics.areEqual((Object) this.fontWeight, (Object) other.fontWeight) && Intrinsics.areEqual((Object) this.fontStyle, (Object) other.fontStyle) && Intrinsics.areEqual((Object) this.fontSynthesis, (Object) other.fontSynthesis) && Intrinsics.areEqual((Object) this.fontFamily, (Object) other.fontFamily) && Intrinsics.areEqual((Object) this.fontFeatureSettings, (Object) other.fontFeatureSettings) && TextUnit.m7732equalsimpl0(this.letterSpacing, other.letterSpacing) && Intrinsics.areEqual((Object) this.baselineShift, (Object) other.baselineShift) && Intrinsics.areEqual((Object) this.textGeometricTransform, (Object) other.textGeometricTransform) && Intrinsics.areEqual((Object) this.localeList, (Object) other.localeList) && Color.m4964equalsimpl0(this.background, other.background) && Intrinsics.areEqual((Object) this.platformStyle, (Object) other.platformStyle)) {
            return true;
        }
        return false;
    }

    public final boolean hasSameNonLayoutAttributes$ui_text_release(SpanStyle other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual((Object) this.textForegroundStyle, (Object) other.textForegroundStyle) && Intrinsics.areEqual((Object) this.textDecoration, (Object) other.textDecoration) && Intrinsics.areEqual((Object) this.shadow, (Object) other.shadow) && Intrinsics.areEqual((Object) this.drawStyle, (Object) other.drawStyle)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int r1 = Color.m4970hashCodeimpl(m6994getColor0d7_KjU()) * 31;
        Brush brush = getBrush();
        int i = 0;
        int result = (((((r1 + (brush != null ? brush.hashCode() : 0)) * 31) + Float.hashCode(getAlpha())) * 31) + TextUnit.m7736hashCodeimpl(this.fontSize)) * 31;
        FontWeight fontWeight2 = this.fontWeight;
        int result2 = (result + (fontWeight2 != null ? fontWeight2.hashCode() : 0)) * 31;
        FontStyle fontStyle2 = this.fontStyle;
        int result3 = (result2 + (fontStyle2 != null ? FontStyle.m7135hashCodeimpl(fontStyle2.m7137unboximpl()) : 0)) * 31;
        FontSynthesis fontSynthesis2 = this.fontSynthesis;
        int result4 = (result3 + (fontSynthesis2 != null ? FontSynthesis.m7144hashCodeimpl(fontSynthesis2.m7148unboximpl()) : 0)) * 31;
        FontFamily fontFamily2 = this.fontFamily;
        int result5 = (result4 + (fontFamily2 != null ? fontFamily2.hashCode() : 0)) * 31;
        String str = this.fontFeatureSettings;
        int result6 = (((result5 + (str != null ? str.hashCode() : 0)) * 31) + TextUnit.m7736hashCodeimpl(this.letterSpacing)) * 31;
        BaselineShift baselineShift2 = this.baselineShift;
        int result7 = (result6 + (baselineShift2 != null ? BaselineShift.m7313hashCodeimpl(baselineShift2.m7315unboximpl()) : 0)) * 31;
        TextGeometricTransform textGeometricTransform2 = this.textGeometricTransform;
        int result8 = (result7 + (textGeometricTransform2 != null ? textGeometricTransform2.hashCode() : 0)) * 31;
        LocaleList localeList2 = this.localeList;
        int result9 = (((result8 + (localeList2 != null ? localeList2.hashCode() : 0)) * 31) + Color.m4970hashCodeimpl(this.background)) * 31;
        TextDecoration textDecoration2 = this.textDecoration;
        int result10 = (result9 + (textDecoration2 != null ? textDecoration2.hashCode() : 0)) * 31;
        Shadow shadow2 = this.shadow;
        int result11 = (result10 + (shadow2 != null ? shadow2.hashCode() : 0)) * 31;
        PlatformSpanStyle platformSpanStyle = this.platformStyle;
        int result12 = (result11 + (platformSpanStyle != null ? platformSpanStyle.hashCode() : 0)) * 31;
        DrawStyle drawStyle2 = this.drawStyle;
        if (drawStyle2 != null) {
            i = drawStyle2.hashCode();
        }
        return result12 + i;
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text_release() {
        int r1 = TextUnit.m7736hashCodeimpl(this.fontSize) * 31;
        FontWeight fontWeight2 = this.fontWeight;
        int i = 0;
        int result = (r1 + (fontWeight2 != null ? fontWeight2.hashCode() : 0)) * 31;
        FontStyle fontStyle2 = this.fontStyle;
        int result2 = (result + (fontStyle2 != null ? FontStyle.m7135hashCodeimpl(fontStyle2.m7137unboximpl()) : 0)) * 31;
        FontSynthesis fontSynthesis2 = this.fontSynthesis;
        int result3 = (result2 + (fontSynthesis2 != null ? FontSynthesis.m7144hashCodeimpl(fontSynthesis2.m7148unboximpl()) : 0)) * 31;
        FontFamily fontFamily2 = this.fontFamily;
        int result4 = (result3 + (fontFamily2 != null ? fontFamily2.hashCode() : 0)) * 31;
        String str = this.fontFeatureSettings;
        int result5 = (((result4 + (str != null ? str.hashCode() : 0)) * 31) + TextUnit.m7736hashCodeimpl(this.letterSpacing)) * 31;
        BaselineShift baselineShift2 = this.baselineShift;
        int result6 = (result5 + (baselineShift2 != null ? BaselineShift.m7313hashCodeimpl(baselineShift2.m7315unboximpl()) : 0)) * 31;
        TextGeometricTransform textGeometricTransform2 = this.textGeometricTransform;
        int result7 = (result6 + (textGeometricTransform2 != null ? textGeometricTransform2.hashCode() : 0)) * 31;
        LocaleList localeList2 = this.localeList;
        int result8 = (((result7 + (localeList2 != null ? localeList2.hashCode() : 0)) * 31) + Color.m4970hashCodeimpl(this.background)) * 31;
        PlatformSpanStyle platformSpanStyle = this.platformStyle;
        if (platformSpanStyle != null) {
            i = platformSpanStyle.hashCode();
        }
        return result8 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SpanStyle(color=").append(Color.m4971toStringimpl(m6994getColor0d7_KjU())).append(", brush=").append(getBrush()).append(", alpha=").append(getAlpha()).append(", fontSize=").append(TextUnit.m7742toStringimpl(this.fontSize)).append(", fontWeight=").append(this.fontWeight).append(", fontStyle=").append(this.fontStyle).append(", fontSynthesis=").append(this.fontSynthesis).append(", fontFamily=").append(this.fontFamily).append(", fontFeatureSettings=").append(this.fontFeatureSettings).append(", letterSpacing=").append(TextUnit.m7742toStringimpl(this.letterSpacing)).append(", baselineShift=").append(this.baselineShift).append(", textGeometricTransform=");
        sb.append(this.textGeometricTransform).append(", localeList=").append(this.localeList).append(", background=").append(Color.m4971toStringimpl(this.background)).append(", textDecoration=").append(this.textDecoration).append(", shadow=").append(this.shadow).append(", platformStyle=").append(this.platformStyle).append(", drawStyle=").append(this.drawStyle).append(')');
        return sb.toString();
    }
}

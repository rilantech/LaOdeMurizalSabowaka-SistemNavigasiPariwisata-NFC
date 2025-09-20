package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J5\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020#H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%Jt\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106Jt\u0010&\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\\\u0010;\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010<\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\\\u0010;\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010<\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\b\u0010A\u001a\u00020\u001eH\u0016J5\u0010B\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DJR\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010IJp\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020K2\b\b\u0002\u0010O\u001a\u00020M2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJz\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020K2\b\b\u0002\u0010O\u001a\u00020M2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u0010R\u001a\u00020SH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJn\u0010V\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00072\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0002\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010_Jn\u0010V\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00072\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0002\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010aJ\\\u0010b\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bc\u0010dJ\\\u0010b\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\be\u0010fJP\u0010g\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020i2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bj\u0010kJP\u0010g\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020i2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010mJt\u0010n\u001a\u00020\u001e2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00070p2\u0006\u0010q\u001a\u00020r2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0002\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bs\u0010tJt\u0010n\u001a\u00020\u001e2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00070p2\u0006\u0010q\u001a\u00020r2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0002\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bu\u0010vJ\\\u0010w\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bx\u0010dJ\\\u0010w\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\by\u0010fJf\u0010z\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010{\u001a\u00020|2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b}\u0010~Jg\u0010z\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010{\u001a\u00020|2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0005\b\u0010\u0001J\u0013\u0010\u0001\u001a\u00020\u001e*\u00020\u00132\u0006\u0010\u001f\u001a\u00020 J\u001f\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\u00030\u0001*\u00020\u000bH\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\"\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00030\u0001*\u00020\u001bH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u000b*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u000b*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0010\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001J\u001e\u0010\u0001\u001a\u00020\u001b*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\u00030\u0001*\u00020\u000bH\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\"\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010 \u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u00020\u00078VX\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u000b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0012\u0010\u0016\u001a\u00020\u0017X\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u00020\u001b8VX\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001c\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¡\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawNode", "Landroidx/compose/ui/node/DrawModifierNode;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/Modifier$Node;", "draw-x_KDEd0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/Modifier$Node;)V", "drawArc", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawContent", "drawDirect", "drawDirect-x_KDEd0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/node/DrawModifierNode;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "performDraw", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeDrawScope.kt */
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {
    private final CanvasDrawScope canvasDrawScope;
    private DrawModifierNode drawNode;

    public LayoutNodeDrawScope() {
        this((CanvasDrawScope) null, 1, (DefaultConstructorMarker) null);
    }

    /* renamed from: drawArc-illE91I  reason: not valid java name */
    public void m4839drawArcillE91I(Brush brush, float f, float f2, boolean z, long j, long j2, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3746drawArcillE91I(brush, f, f2, z, j, j2, f3, drawStyle, colorFilter, i);
    }

    /* renamed from: drawArc-yD3GUKo  reason: not valid java name */
    public void m4840drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3747drawArcyD3GUKo(j, f, f2, z, j2, j3, f3, drawStyle, colorFilter, i);
    }

    /* renamed from: drawCircle-V9BoPsw  reason: not valid java name */
    public void m4841drawCircleV9BoPsw(Brush brush, float f, long j, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Brush brush2 = brush;
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3748drawCircleV9BoPsw(brush, f, j, f2, drawStyle, colorFilter, i);
    }

    /* renamed from: drawCircle-VaOC9Bg  reason: not valid java name */
    public void m4842drawCircleVaOC9Bg(long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3749drawCircleVaOC9Bg(j, f, j2, f2, drawStyle, colorFilter, i);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE  reason: not valid java name */
    public /* synthetic */ void m4844drawImage9jGpkUE(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3750drawImage9jGpkUE(imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
    public void m4845drawImageAZ2fEMs(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3751drawImageAZ2fEMs(imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, i2);
    }

    /* renamed from: drawImage-gbVJVH8  reason: not valid java name */
    public void m4846drawImagegbVJVH8(ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        ImageBitmap imageBitmap2 = imageBitmap;
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3752drawImagegbVJVH8(imageBitmap, j, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawLine-1RTmtNc  reason: not valid java name */
    public void m4847drawLine1RTmtNc(Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2) {
        Brush brush2 = brush;
        Intrinsics.checkNotNullParameter(brush, "brush");
        this.canvasDrawScope.m3753drawLine1RTmtNc(brush, j, j2, f, i, pathEffect, f2, colorFilter, i2);
    }

    /* renamed from: drawLine-NGM6Ib0  reason: not valid java name */
    public void m4848drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2) {
        this.canvasDrawScope.m3754drawLineNGM6Ib0(j, j2, j3, f, i, pathEffect, f2, colorFilter, i2);
    }

    /* renamed from: drawOval-AsUm42w  reason: not valid java name */
    public void m4849drawOvalAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Brush brush2 = brush;
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3755drawOvalAsUm42w(brush, j, j2, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawOval-n-J9OG0  reason: not valid java name */
    public void m4850drawOvalnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3756drawOvalnJ9OG0(j, j2, j3, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawPath-GBMwjPU  reason: not valid java name */
    public void m4851drawPathGBMwjPU(Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3757drawPathGBMwjPU(path, brush, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawPath-LG529CI  reason: not valid java name */
    public void m4852drawPathLG529CI(Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Path path2 = path;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3758drawPathLG529CI(path, j, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawPoints-F8ZwMP8  reason: not valid java name */
    public void m4853drawPointsF8ZwMP8(List<Offset> list, int i, long j, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3) {
        List<Offset> list2 = list;
        Intrinsics.checkNotNullParameter(list, "points");
        this.canvasDrawScope.m3759drawPointsF8ZwMP8(list, i, j, f, i2, pathEffect, f2, colorFilter, i3);
    }

    /* renamed from: drawPoints-Gsft0Ws  reason: not valid java name */
    public void m4854drawPointsGsft0Ws(List<Offset> list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3) {
        List<Offset> list2 = list;
        Intrinsics.checkNotNullParameter(list, "points");
        Intrinsics.checkNotNullParameter(brush, "brush");
        this.canvasDrawScope.m3760drawPointsGsft0Ws(list, i, brush, f, i2, pathEffect, f2, colorFilter, i3);
    }

    /* renamed from: drawRect-AsUm42w  reason: not valid java name */
    public void m4855drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Brush brush2 = brush;
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3761drawRectAsUm42w(brush, j, j2, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawRect-n-J9OG0  reason: not valid java name */
    public void m4856drawRectnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3762drawRectnJ9OG0(j, j2, j3, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawRoundRect-ZuiqVtQ  reason: not valid java name */
    public void m4857drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3763drawRoundRectZuiqVtQ(brush, j, j2, j3, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawRoundRect-u-Aw5IA  reason: not valid java name */
    public void m4858drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3764drawRoundRectuAw5IA(j, j2, j3, j4, drawStyle, f, colorFilter, i);
    }

    /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
    public long m4859getCenterF1C5BW0() {
        return this.canvasDrawScope.m3865getCenterF1C5BW0();
    }

    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m4860getSizeNHjbRc() {
        return this.canvasDrawScope.m3866getSizeNHjbRc();
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m4861roundToPxR2X_6o(long j) {
        return this.canvasDrawScope.m5818roundToPxR2X_6o(j);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m4862roundToPx0680j_4(float f) {
        return this.canvasDrawScope.m5819roundToPx0680j_4(f);
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m4863toDpGaN1DYA(long j) {
        return this.canvasDrawScope.m5820toDpGaN1DYA(j);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m4864toDpu2uoSUM(float f) {
        return this.canvasDrawScope.m5821toDpu2uoSUM(f);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m4865toDpu2uoSUM(int i) {
        return this.canvasDrawScope.m5822toDpu2uoSUM(i);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m4866toDpSizekrfVVM(long j) {
        return this.canvasDrawScope.m5823toDpSizekrfVVM(j);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m4867toPxR2X_6o(long j) {
        return this.canvasDrawScope.m5824toPxR2X_6o(j);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m4868toPx0680j_4(float f) {
        return this.canvasDrawScope.m5825toPx0680j_4(f);
    }

    public Rect toRect(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.canvasDrawScope.toRect(dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m4869toSizeXkaWNTQ(long j) {
        return this.canvasDrawScope.m5826toSizeXkaWNTQ(j);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m4870toSp0xMU5do(float f) {
        return this.canvasDrawScope.m5827toSp0xMU5do(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m4871toSpkPz2Gy4(float f) {
        return this.canvasDrawScope.m5828toSpkPz2Gy4(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m4872toSpkPz2Gy4(int i) {
        return this.canvasDrawScope.m5829toSpkPz2Gy4(i);
    }

    public LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope2) {
        Intrinsics.checkNotNullParameter(canvasDrawScope2, "canvasDrawScope");
        this.canvasDrawScope = canvasDrawScope2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CanvasDrawScope() : canvasDrawScope2);
    }

    public void drawContent() {
        NodeCoordinator nextCoordinator;
        int $i$f$drawIntoCanvas;
        DrawScope $this$drawIntoCanvas$iv;
        int $i$f$drawIntoCanvas2;
        DrawScope $this$drawIntoCanvas$iv2;
        MutableVector mutableVector;
        LayoutNodeDrawScope layoutNodeDrawScope = this;
        DrawScope $this$drawIntoCanvas$iv3 = layoutNodeDrawScope;
        int $i$f$drawIntoCanvas3 = false;
        Canvas canvas = $this$drawIntoCanvas$iv3.getDrawContext().getCanvas();
        DrawModifierNode drawNode2 = layoutNodeDrawScope.drawNode;
        Intrinsics.checkNotNull(drawNode2);
        Modifier.Node nextDrawNode = LayoutNodeDrawScopeKt.nextDrawNode(drawNode2);
        if (nextDrawNode != null) {
            int kind$iv = NodeKind.m4956constructorimpl(4);
            MutableVector mutableVector2 = null;
            Modifier.Node this_$iv$iv = nextDrawNode;
            while (this_$iv$iv != null) {
                if (this_$iv$iv instanceof DrawModifierNode) {
                    layoutNodeDrawScope.performDraw((DrawModifierNode) this_$iv$iv, canvas);
                    $this$drawIntoCanvas$iv = $this$drawIntoCanvas$iv3;
                    $i$f$drawIntoCanvas = $i$f$drawIntoCanvas3;
                } else {
                    int i = 1;
                    if (((this_$iv$iv.getKindSet$ui_release() & kind$iv) != 0 ? 1 : null) == null || !(this_$iv$iv instanceof DelegatingNode)) {
                        $this$drawIntoCanvas$iv = $this$drawIntoCanvas$iv3;
                        $i$f$drawIntoCanvas = $i$f$drawIntoCanvas3;
                    } else {
                        int count$iv = 0;
                        Modifier.Node node$iv$iv = ((DelegatingNode) this_$iv$iv).getDelegate$ui_release();
                        while (node$iv$iv != null) {
                            Modifier.Node next$iv = node$iv$iv;
                            if (((next$iv.getKindSet$ui_release() & kind$iv) != 0 ? i : 0) != 0) {
                                count$iv++;
                                if (count$iv == i) {
                                    this_$iv$iv = next$iv;
                                    $this$drawIntoCanvas$iv2 = $this$drawIntoCanvas$iv3;
                                    $i$f$drawIntoCanvas2 = $i$f$drawIntoCanvas3;
                                    Modifier.Node node = next$iv;
                                } else {
                                    if (mutableVector2 == null) {
                                        $this$drawIntoCanvas$iv2 = $this$drawIntoCanvas$iv3;
                                        $i$f$drawIntoCanvas2 = $i$f$drawIntoCanvas3;
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    } else {
                                        $this$drawIntoCanvas$iv2 = $this$drawIntoCanvas$iv3;
                                        $i$f$drawIntoCanvas2 = $i$f$drawIntoCanvas3;
                                        mutableVector = mutableVector2;
                                    }
                                    mutableVector2 = mutableVector;
                                    Modifier.Node theNode$iv = this_$iv$iv;
                                    if (theNode$iv != null) {
                                        if (mutableVector2 != null) {
                                            mutableVector2.add(theNode$iv);
                                        }
                                        this_$iv$iv = null;
                                    }
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(next$iv);
                                    }
                                }
                            } else {
                                $this$drawIntoCanvas$iv2 = $this$drawIntoCanvas$iv3;
                                $i$f$drawIntoCanvas2 = $i$f$drawIntoCanvas3;
                                Modifier.Node node2 = next$iv;
                            }
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                            $this$drawIntoCanvas$iv3 = $this$drawIntoCanvas$iv2;
                            $i$f$drawIntoCanvas3 = $i$f$drawIntoCanvas2;
                            i = 1;
                        }
                        $this$drawIntoCanvas$iv = $this$drawIntoCanvas$iv3;
                        $i$f$drawIntoCanvas = $i$f$drawIntoCanvas3;
                        if (count$iv == 1) {
                            layoutNodeDrawScope = this;
                            $this$drawIntoCanvas$iv3 = $this$drawIntoCanvas$iv;
                            $i$f$drawIntoCanvas3 = $i$f$drawIntoCanvas;
                        }
                    }
                }
                this_$iv$iv = DelegatableNodeKt.pop(mutableVector2);
                layoutNodeDrawScope = this;
                $this$drawIntoCanvas$iv3 = $this$drawIntoCanvas$iv;
                $i$f$drawIntoCanvas3 = $i$f$drawIntoCanvas;
            }
            int i2 = $i$f$drawIntoCanvas3;
            return;
        }
        NodeCoordinator coordinator = DelegatableNodeKt.m4792requireCoordinator64DMado(drawNode2, NodeKind.m4956constructorimpl(4));
        if (coordinator.getTail() == drawNode2.getNode()) {
            nextCoordinator = coordinator.getWrapped$ui_release();
            Intrinsics.checkNotNull(nextCoordinator);
        } else {
            nextCoordinator = coordinator;
        }
        nextCoordinator.performDraw(canvas);
    }

    public final void performDraw(DrawModifierNode $this$performDraw, Canvas canvas) {
        Intrinsics.checkNotNullParameter($this$performDraw, "<this>");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        NodeCoordinator coordinator = DelegatableNodeKt.m4792requireCoordinator64DMado($this$performDraw, NodeKind.m4956constructorimpl(4));
        coordinator.getLayoutNode().getMDrawScope$ui_release().m4843drawDirectx_KDEd0$ui_release(canvas, IntSizeKt.m6014toSizeozmzZPI(coordinator.m4930getSizeYbymL2g()), coordinator, $this$performDraw);
    }

    /* renamed from: draw-x_KDEd0$ui_release  reason: not valid java name */
    public final void m4838drawx_KDEd0$ui_release(Canvas canvas, long size, NodeCoordinator coordinator, Modifier.Node drawNode2) {
        int kind$iv;
        int kind$iv2;
        int count$iv;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        Intrinsics.checkNotNullParameter(drawNode2, "drawNode");
        int kind$iv3 = NodeKind.m4956constructorimpl(4);
        MutableVector mutableVector2 = null;
        Modifier.Node this_$iv$iv = drawNode2;
        while (this_$iv$iv != null) {
            if (this_$iv$iv instanceof DrawModifierNode) {
                m4843drawDirectx_KDEd0$ui_release(canvas, size, coordinator, (DrawModifierNode) this_$iv$iv);
                kind$iv = kind$iv3;
            } else {
                int i = 1;
                if (((this_$iv$iv.getKindSet$ui_release() & kind$iv3) != 0 ? 1 : null) == null || !(this_$iv$iv instanceof DelegatingNode)) {
                    kind$iv = kind$iv3;
                } else {
                    int count$iv2 = 0;
                    Modifier.Node node$iv$iv = ((DelegatingNode) this_$iv$iv).getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        Modifier.Node next$iv = node$iv$iv;
                        if (((next$iv.getKindSet$ui_release() & kind$iv3) != 0 ? i : 0) != 0) {
                            count$iv2++;
                            if (count$iv2 == i) {
                                this_$iv$iv = next$iv;
                                kind$iv2 = kind$iv3;
                            } else {
                                if (mutableVector2 == null) {
                                    kind$iv2 = kind$iv3;
                                    count$iv = count$iv2;
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                } else {
                                    kind$iv2 = kind$iv3;
                                    count$iv = count$iv2;
                                    mutableVector = mutableVector2;
                                }
                                mutableVector2 = mutableVector;
                                Modifier.Node theNode$iv = this_$iv$iv;
                                if (theNode$iv != null) {
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(theNode$iv);
                                    }
                                    this_$iv$iv = null;
                                }
                                if (mutableVector2 != null) {
                                    mutableVector2.add(next$iv);
                                }
                                count$iv2 = count$iv;
                            }
                        } else {
                            kind$iv2 = kind$iv3;
                        }
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        kind$iv3 = kind$iv2;
                        i = 1;
                    }
                    kind$iv = kind$iv3;
                    if (count$iv2 == 1) {
                        kind$iv3 = kind$iv;
                    }
                }
            }
            this_$iv$iv = DelegatableNodeKt.pop(mutableVector2);
            kind$iv3 = kind$iv;
        }
    }

    /* renamed from: drawDirect-x_KDEd0$ui_release  reason: not valid java name */
    public final void m4843drawDirectx_KDEd0$ui_release(Canvas canvas, long size, NodeCoordinator coordinator, DrawModifierNode drawNode2) {
        Canvas canvas2 = canvas;
        NodeCoordinator nodeCoordinator = coordinator;
        DrawModifierNode drawModifierNode = drawNode2;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        Intrinsics.checkNotNullParameter(nodeCoordinator, "coordinator");
        Intrinsics.checkNotNullParameter(drawModifierNode, "drawNode");
        DrawModifierNode previousDrawNode = this.drawNode;
        this.drawNode = drawModifierNode;
        CanvasDrawScope this_$iv = this.canvasDrawScope;
        LayoutDirection layoutDirection$iv = coordinator.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = this_$iv.getDrawParams();
        Density prevDensity$iv = drawParams.component1();
        LayoutDirection prevLayoutDirection$iv = drawParams.component2();
        Canvas prevCanvas$iv = drawParams.component3();
        long prevSize$iv = drawParams.m3766component4NHjbRc();
        CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u240$iv = this_$iv.getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u240$iv.setDensity(nodeCoordinator);
        $this$draw_yzxVdVo_u24lambda_u240$iv.setLayoutDirection(layoutDirection$iv);
        $this$draw_yzxVdVo_u24lambda_u240$iv.setCanvas(canvas2);
        $this$draw_yzxVdVo_u24lambda_u240$iv.m3769setSizeuvyYCjk(size);
        canvas.save();
        DrawScope drawScope = this_$iv;
        drawNode2.draw(this);
        canvas.restore();
        CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u241$iv = this_$iv.getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u241$iv.setDensity(prevDensity$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.setLayoutDirection(prevLayoutDirection$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.setCanvas(prevCanvas$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.m3769setSizeuvyYCjk(prevSize$iv);
        this.drawNode = previousDrawNode;
    }
}

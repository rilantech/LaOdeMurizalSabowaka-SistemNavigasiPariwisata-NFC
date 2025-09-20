package androidx.compose.ui.node;

import android.view.View;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000Ì\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b?\b\u0000\u0018\u0000 à\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\bà\u0002á\u0002â\u0002ã\u0002B\u0019\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001a\u0010ä\u0001\u001a\u00030µ\u00012\b\u0010¿\u0001\u001a\u00030´\u0001H\u0000¢\u0006\u0003\bå\u0001J\u0010\u0010æ\u0001\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bç\u0001J\n\u0010è\u0001\u001a\u00030µ\u0001H\u0002J\u0014\u0010é\u0001\u001a\u00030ê\u00012\b\b\u0002\u0010H\u001a\u00020\u000bH\u0002J\u0010\u0010ë\u0001\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bì\u0001J\u0010\u0010í\u0001\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bî\u0001J\u001a\u0010ï\u0001\u001a\u00030µ\u00012\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0000¢\u0006\u0003\bò\u0001J%\u0010ó\u0001\u001a\u00030µ\u00012\u0015\u0010ô\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030µ\u00010³\u0001H\bø\u0001\u0000J+\u0010õ\u0001\u001a\u00030µ\u00012\u001b\u0010ô\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030µ\u00010ö\u0001H\bø\u0001\u0000J,\u0010÷\u0001\u001a\u00030µ\u00012\u0016\u0010ô\u0001\u001a\u0011\u0012\u0005\u0012\u00030ø\u0001\u0012\u0005\u0012\u00030µ\u00010³\u0001H\bø\u0001\u0000¢\u0006\u0003\bù\u0001J+\u0010ú\u0001\u001a\u00030µ\u00012\u0015\u0010ô\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030µ\u00010³\u0001H\bø\u0001\u0000¢\u0006\u0003\bû\u0001J\n\u0010ü\u0001\u001a\u00030µ\u0001H\u0016J\u0013\u0010ý\u0001\u001a\f\u0018\u00010þ\u0001j\u0005\u0018\u0001`ÿ\u0001H\u0017J\u0010\u0010\u0002\u001a\t\u0012\u0005\u0012\u00030\u00020$H\u0016JC\u0010\u0002\u001a\u00030µ\u00012\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u00022\t\b\u0002\u0010\u0002\u001a\u00020\t2\t\b\u0002\u0010\u0002\u001a\u00020\tH\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\b\u0002\u0010\u0002JC\u0010\u0002\u001a\u00030µ\u00012\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u00022\t\b\u0002\u0010\u0002\u001a\u00020\t2\t\b\u0002\u0010\u0002\u001a\u00020\tH\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\b\u0002\u0010\u0002J$\u0010Q\u001a\u00030µ\u00012\u000f\u0010ô\u0001\u001a\n\u0012\u0005\u0012\u00030µ\u00010\u0002H\bø\u0001\u0000¢\u0006\u0003\b\u0002J\"\u0010\u0002\u001a\u00030µ\u00012\u0007\u0010\u0002\u001a\u00020\u000b2\u0007\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u0002J\n\u0010\u0002\u001a\u00030µ\u0001H\u0002J\n\u0010\u0002\u001a\u00030µ\u0001H\u0002J\u0010\u0010\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b\u0002J\u0013\u0010 \u0002\u001a\u00030µ\u00012\t\b\u0002\u0010¡\u0002\u001a\u00020\tJ\n\u0010¢\u0002\u001a\u00030µ\u0001H\u0002J#\u0010£\u0002\u001a\u00020\t2\f\b\u0002\u0010¤\u0002\u001a\u0005\u0018\u00010¥\u0002H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0003\b¦\u0002J\u0010\u0010§\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b¨\u0002J\u0010\u0010©\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bª\u0002J\u0010\u0010«\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b¬\u0002J\u0010\u0010­\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b®\u0002J\u0010\u0010¯\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b°\u0002J+\u0010±\u0002\u001a\u00030µ\u00012\u0007\u0010²\u0002\u001a\u00020\u000b2\u0007\u0010³\u0002\u001a\u00020\u000b2\u0007\u0010´\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\bµ\u0002J\u0013\u0010¶\u0002\u001a\u00030µ\u00012\u0007\u0010·\u0002\u001a\u00020\u0000H\u0002J\n\u0010¸\u0002\u001a\u00030µ\u0001H\u0016J\n\u0010¹\u0002\u001a\u00030µ\u0001H\u0002J\n\u0010º\u0002\u001a\u00030µ\u0001H\u0016J\n\u0010»\u0002\u001a\u00030µ\u0001H\u0016J\n\u0010¼\u0002\u001a\u00030µ\u0001H\u0016J\u0010\u0010½\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b¾\u0002J\"\u0010¿\u0002\u001a\u00030µ\u00012\u0007\u0010À\u0002\u001a\u00020\u000b2\u0007\u0010Á\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\bÂ\u0002J\n\u0010Ã\u0002\u001a\u00030µ\u0001H\u0002J#\u0010Ä\u0002\u001a\u00020\t2\f\b\u0002\u0010¤\u0002\u001a\u0005\u0018\u00010¥\u0002H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0003\bÅ\u0002J\u0010\u0010Æ\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bÇ\u0002J\"\u0010È\u0002\u001a\u00030µ\u00012\u0007\u0010\u0002\u001a\u00020\u000b2\u0007\u0010´\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\bÉ\u0002J\u0010\u0010Ê\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bË\u0002J\u001b\u0010Ì\u0002\u001a\u00030µ\u00012\t\b\u0002\u0010Í\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÎ\u0002J&\u0010Ï\u0002\u001a\u00030µ\u00012\t\b\u0002\u0010Í\u0002\u001a\u00020\t2\t\b\u0002\u0010Ð\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÑ\u0002J\u001b\u0010Ò\u0002\u001a\u00030µ\u00012\t\b\u0002\u0010Í\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÓ\u0002J&\u0010Ô\u0002\u001a\u00030µ\u00012\t\b\u0002\u0010Í\u0002\u001a\u00020\t2\t\b\u0002\u0010Ð\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÕ\u0002J\u0019\u0010Ö\u0002\u001a\u00030µ\u00012\u0007\u0010×\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\bØ\u0002J\n\u0010Ù\u0002\u001a\u00030µ\u0001H\u0002J\u0010\u0010Ú\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bÛ\u0002J\t\u0010Ü\u0002\u001a\u00020\tH\u0002J\n\u0010Ý\u0002\u001a\u00030ê\u0001H\u0016J\u0010\u0010Þ\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bß\u0002R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$8@X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8@X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00000$8@X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0016\u0010,\u001a\u0004\u0018\u00010\u00128@X\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R,\u00100\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000b8W@WX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u001f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00108\u001a\u0002072\u0006\u00106\u001a\u000207@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020>8VX\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R$\u0010C\u001a\u00020B2\u0006\u00106\u001a\u00020B@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00103\"\u0004\bJ\u00105R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00000$8@X\u0004¢\u0006\u0006\u001a\u0004\bL\u0010'R\u0014\u0010M\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\u001cR\u0014\u0010O\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\bP\u00103R\u000e\u0010Q\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020\u00178@X\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0016\u0010U\u001a\u0004\u0018\u00010\u00178BX\u0004¢\u0006\u0006\u001a\u0004\bV\u0010TR\u001a\u0010W\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u001c\"\u0004\bY\u0010\"R\"\u0010Z\u001a\n\u0018\u00010[j\u0004\u0018\u0001`\\X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020bX\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0014\u0010k\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\bk\u0010\u001cR\u0014\u0010l\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\bl\u0010\u001cR\u0013\u0010m\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0014\u0010o\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\bo\u0010\u001cR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010p\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u001c\"\u0004\br\u0010\"R\u0014\u0010s\u001a\u00020tX\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR$\u0010x\u001a\u00020w2\u0006\u00106\u001a\u00020w@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0014\u0010}\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u001cR\u0017\u0010\u001a\u00030\u00018@X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\u00020\t8@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u001cR\u0016\u0010\u0001\u001a\u00020\t8@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u001cR\u001e\u0010\u0001\u001a\t\u0018\u00010\u0001R\u00020t8@X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R.\u0010\u0001\u001a\u0004\u0018\u00010\u00002\t\u0010\u0001\u001a\u0004\u0018\u00010\u0000@BX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00030\u00018@X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u00070\u0001R\u00020t8@X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\u00020\t8@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u001cR+\u0010\u0001\u001a\u00030\u00012\u0007\u00106\u001a\u00030\u0001@VX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010 \u0001R\u0016\u0010¡\u0001\u001a\u00020f8@X\u0004¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010hR\u0016\u0010£\u0001\u001a\u00020f8@X\u0004¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010hR+\u0010¦\u0001\u001a\u00030¥\u00012\u0007\u00106\u001a\u00030¥\u0001@VX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R\u001d\u0010«\u0001\u001a\u00020\tX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010\u001c\"\u0005\b­\u0001\u0010\"R\u0018\u0010®\u0001\u001a\u00030¯\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b°\u0001\u0010±\u0001R0\u0010²\u0001\u001a\u0013\u0012\u0005\u0012\u00030´\u0001\u0012\u0005\u0012\u00030µ\u0001\u0018\u00010³\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R0\u0010º\u0001\u001a\u0013\u0012\u0005\u0012\u00030´\u0001\u0012\u0005\u0012\u00030µ\u0001\u0018\u00010³\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0001\u0010·\u0001\"\u0006\b¼\u0001\u0010¹\u0001R\u0016\u0010½\u0001\u001a\u00020\u00178@X\u0004¢\u0006\u0007\u001a\u0005\b¾\u0001\u0010TR'\u0010¿\u0001\u001a\u0005\u0018\u00010´\u00012\t\u0010/\u001a\u0005\u0018\u00010´\u0001@BX\u000e¢\u0006\n\n\u0000\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u0019\u0010Â\u0001\u001a\u0004\u0018\u00010\u00008@X\u0004¢\u0006\b\u001a\u0006\bÃ\u0001\u0010\u0001R\u0019\u0010Ä\u0001\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\b\u001a\u0006\bÅ\u0001\u0010Æ\u0001R\u0016\u0010Ç\u0001\u001a\u00020\u000b8@X\u0004¢\u0006\u0007\u001a\u0005\bÈ\u0001\u00103R\u000f\u0010É\u0001\u001a\u00020fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÊ\u0001\u00103\"\u0005\bË\u0001\u00105R\"\u0010Ì\u0001\u001a\u0005\u0018\u00010Í\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÎ\u0001\u0010Ï\u0001\"\u0006\bÐ\u0001\u0010Ñ\u0001R\u000f\u0010Ò\u0001\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R+\u0010Ô\u0001\u001a\u00030Ó\u00012\u0007\u00106\u001a\u00030Ó\u0001@VX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÕ\u0001\u0010Ö\u0001\"\u0006\b×\u0001\u0010Ø\u0001R\u000f\u0010Ù\u0001\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Ú\u0001\u001a\u00020\u000b8VX\u0004¢\u0006\u0007\u001a\u0005\bÛ\u0001\u00103R\u0018\u0010Ü\u0001\u001a\u00030Ý\u00018BX\u0004¢\u0006\b\u001a\u0006\bÞ\u0001\u0010ß\u0001R#\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0004¢\u0006\u000e\u0012\u0005\bá\u0001\u0010\u001f\u001a\u0005\bâ\u0001\u0010\u0010R\u000f\u0010ã\u0001\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006ä\u0002"}, d2 = {"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", "Landroidx/compose/ui/node/InteroperableComposeUiNode;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "isVirtual", "", "semanticsId", "", "(ZI)V", "_children", "Landroidx/compose/runtime/collection/MutableVector;", "get_children$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "_collapsedSemantics", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "_foldedChildren", "Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "_foldedParent", "_innerLayerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "_unfoldedChildren", "_zSortedChildren", "alignmentLinesRequired", "getAlignmentLinesRequired$ui_release", "()Z", "canMultiMeasure", "getCanMultiMeasure$ui_release$annotations", "()V", "getCanMultiMeasure$ui_release", "setCanMultiMeasure$ui_release", "(Z)V", "childLookaheadMeasurables", "", "Landroidx/compose/ui/layout/Measurable;", "getChildLookaheadMeasurables$ui_release", "()Ljava/util/List;", "childMeasurables", "getChildMeasurables$ui_release", "children", "getChildren$ui_release", "collapsedSemantics", "getCollapsedSemantics$ui_release", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "<set-?>", "compositeKeyHash", "getCompositeKeyHash$annotations", "getCompositeKeyHash", "()I", "setCompositeKeyHash", "(I)V", "value", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalMap", "getCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "setCompositionLocalMap", "(Landroidx/compose/runtime/CompositionLocalMap;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "deactivated", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "depth", "getDepth$ui_release", "setDepth$ui_release", "foldedChildren", "getFoldedChildren$ui_release", "hasFixedInnerContentConstraints", "getHasFixedInnerContentConstraints$ui_release", "height", "getHeight", "ignoreRemeasureRequests", "innerCoordinator", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerLayerCoordinator", "getInnerLayerCoordinator", "innerLayerCoordinatorIsDirty", "getInnerLayerCoordinatorIsDirty$ui_release", "setInnerLayerCoordinatorIsDirty$ui_release", "interopViewFactoryHolder", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/viewinterop/InteropViewFactoryHolder;", "getInteropViewFactoryHolder$ui_release", "()Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "setInteropViewFactoryHolder$ui_release", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;)V", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "getIntrinsicsPolicy$ui_release", "()Landroidx/compose/ui/node/IntrinsicsPolicy;", "intrinsicsUsageByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getIntrinsicsUsageByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setIntrinsicsUsageByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "isAttached", "isPlaced", "isPlacedInLookahead", "()Ljava/lang/Boolean;", "isValidOwnerScope", "isVirtualLookaheadRoot", "isVirtualLookaheadRoot$ui_release", "setVirtualLookaheadRoot$ui_release", "layoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "getLayoutDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutPending", "getLayoutPending$ui_release", "layoutState", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "getLookaheadPassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "newRoot", "lookaheadRoot", "getLookaheadRoot$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "setLookaheadRoot", "(Landroidx/compose/ui/node/LayoutNode;)V", "mDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui_release", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "measuredByParent", "getMeasuredByParent$ui_release", "measuredByParentInLookahead", "getMeasuredByParentInLookahead$ui_release", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "needsOnPositionedDispatch", "getNeedsOnPositionedDispatch$ui_release", "setNeedsOnPositionedDispatch$ui_release", "nodes", "Landroidx/compose/ui/node/NodeChain;", "getNodes$ui_release", "()Landroidx/compose/ui/node/NodeChain;", "onAttach", "Lkotlin/Function1;", "Landroidx/compose/ui/node/Owner;", "", "getOnAttach$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui_release", "setOnDetach$ui_release", "outerCoordinator", "getOuterCoordinator$ui_release", "owner", "getOwner$ui_release", "()Landroidx/compose/ui/node/Owner;", "parent", "getParent$ui_release", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "placeOrder", "getPlaceOrder$ui_release", "previousIntrinsicsUsageByParent", "getSemanticsId", "setSemanticsId", "subcompositionsState", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "getSubcompositionsState$ui_release", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setSubcompositionsState$ui_release", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "unfoldedVirtualChildrenListDirty", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "virtualChildrenCount", "width", "getWidth", "zIndex", "", "getZIndex", "()F", "zSortedChildren", "getZSortedChildren$annotations", "getZSortedChildren", "zSortedChildrenInvalidated", "attach", "attach$ui_release", "clearSubtreeIntrinsicsUsage", "clearSubtreeIntrinsicsUsage$ui_release", "clearSubtreePlacementIntrinsicsUsage", "debugTreeToString", "", "detach", "detach$ui_release", "dispatchOnPositionedCallbacks", "dispatchOnPositionedCallbacks$ui_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "draw$ui_release", "forEachChild", "block", "forEachChildIndexed", "Lkotlin/Function2;", "forEachCoordinator", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "forEachCoordinator$ui_release", "forEachCoordinatorIncludingInner", "forEachCoordinatorIncludingInner$ui_release", "forceRemeasure", "getInteropView", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/InteropView;", "getModifierInfo", "Landroidx/compose/ui/layout/ModifierInfo;", "hitTest", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-M_7yMNQ$ui_release", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestSemantics", "hitSemanticsEntities", "hitTestSemantics-M_7yMNQ$ui_release", "Lkotlin/Function0;", "ignoreRemeasureRequests$ui_release", "insertAt", "index", "instance", "insertAt$ui_release", "invalidateFocusOnAttach", "invalidateFocusOnDetach", "invalidateLayer", "invalidateLayer$ui_release", "invalidateLayers", "invalidateLayers$ui_release", "invalidateMeasurements", "invalidateMeasurements$ui_release", "invalidateParentData", "invalidateParentData$ui_release", "invalidateSemantics", "invalidateSemantics$ui_release", "invalidateSubtree", "isRootOfInvalidation", "invalidateUnfoldedVirtualChildren", "lookaheadRemeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadRemeasure-_Sx5XlM$ui_release", "lookaheadReplace", "lookaheadReplace$ui_release", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "move", "from", "to", "count", "move$ui_release", "onChildRemoved", "child", "onDeactivate", "onDensityOrLayoutDirectionChanged", "onLayoutComplete", "onRelease", "onReuse", "onZSortedChildrenInvalidated", "onZSortedChildrenInvalidated$ui_release", "place", "x", "y", "place$ui_release", "recreateUnfoldedChildrenIfDirty", "remeasure", "remeasure-_Sx5XlM$ui_release", "removeAll", "removeAll$ui_release", "removeAt", "removeAt$ui_release", "replace", "replace$ui_release", "requestLookaheadRelayout", "forceRequest", "requestLookaheadRelayout$ui_release", "requestLookaheadRemeasure", "scheduleMeasureAndLayout", "requestLookaheadRemeasure$ui_release", "requestRelayout", "requestRelayout$ui_release", "requestRemeasure", "requestRemeasure$ui_release", "rescheduleRemeasureOrRelayout", "it", "rescheduleRemeasureOrRelayout$ui_release", "resetModifierState", "resetSubtreeIntrinsicsUsage", "resetSubtreeIntrinsicsUsage$ui_release", "shouldInvalidateParentLayer", "toString", "updateChildrenIfDirty", "updateChildrenIfDirty$ui_release", "Companion", "LayoutState", "NoIntrinsicsMeasurePolicy", "UsageByParent", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNode.kt */
public final class LayoutNode implements ComposeNodeLifecycleCallback, Remeasurement, OwnerScope, LayoutInfo, ComposeUiNode, InteroperableComposeUiNode, Owner.OnLayoutCompletedListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Function0<LayoutNode> Constructor = LayoutNode$Companion$Constructor$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final ViewConfiguration DummyViewConfiguration = new LayoutNode$Companion$DummyViewConfiguration$1();
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = new LayoutNode$Companion$ErrorMeasurePolicy$1();
    public static final int NotPlacedPlaceOrder = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public static final Comparator<LayoutNode> ZComparator = new LayoutNode$$ExternalSyntheticLambda0();
    private SemanticsConfiguration _collapsedSemantics;
    private final MutableVectorWithMutationTracking<LayoutNode> _foldedChildren;
    private LayoutNode _foldedParent;
    private NodeCoordinator _innerLayerCoordinator;
    private MutableVector<LayoutNode> _unfoldedChildren;
    private final MutableVector<LayoutNode> _zSortedChildren;
    private boolean canMultiMeasure;
    private int compositeKeyHash;
    private CompositionLocalMap compositionLocalMap;
    private boolean deactivated;
    private Density density;
    private int depth;
    /* access modifiers changed from: private */
    public boolean ignoreRemeasureRequests;
    private boolean innerLayerCoordinatorIsDirty;
    private AndroidViewHolder interopViewFactoryHolder;
    private final IntrinsicsPolicy intrinsicsPolicy;
    private UsageByParent intrinsicsUsageByParent;
    private final boolean isVirtual;
    private boolean isVirtualLookaheadRoot;
    private final LayoutNodeLayoutDelegate layoutDelegate;
    private LayoutDirection layoutDirection;
    private LayoutNode lookaheadRoot;
    private MeasurePolicy measurePolicy;
    private Modifier modifier;
    private boolean needsOnPositionedDispatch;
    private final NodeChain nodes;
    private Function1<? super Owner, Unit> onAttach;
    private Function1<? super Owner, Unit> onDetach;
    private Owner owner;
    private UsageByParent previousIntrinsicsUsageByParent;
    private int semanticsId;
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    private boolean zSortedChildrenInvalidated;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "(Ljava/lang/String;I)V", "Measuring", "LookaheadMeasuring", "LayingOut", "LookaheadLayingOut", "Idle", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public enum LayoutState {
        Measuring,
        LookaheadMeasuring,
        LayingOut,
        LookaheadLayingOut,
        Idle
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutState.values().length];
            try {
                iArr[LayoutState.Idle.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LayoutNode() {
        this(false, 0, 3, (DefaultConstructorMarker) null);
    }

    @Deprecated(message = "Temporary API to support ConstraintLayout prototyping.")
    public static /* synthetic */ void getCanMultiMeasure$ui_release$annotations() {
    }

    public static /* synthetic */ void getCompositeKeyHash$annotations() {
    }

    public static /* synthetic */ void getZSortedChildren$annotations() {
    }

    public LayoutNode(boolean isVirtual2, int semanticsId2) {
        this.isVirtual = isVirtual2;
        this.semanticsId = semanticsId2;
        this._foldedChildren = new MutableVectorWithMutationTracking<>(new MutableVector(new LayoutNode[16], 0), new LayoutNode$_foldedChildren$1(this));
        this._zSortedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.intrinsicsPolicy = new IntrinsicsPolicy(this);
        this.density = LayoutNodeKt.DefaultDensity;
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        this.compositionLocalMap = CompositionLocalMap.Companion.getEmpty();
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        this.previousIntrinsicsUsageByParent = UsageByParent.NotUsed;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this.modifier = Modifier.Companion;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LayoutNode(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? SemanticsModifierKt.generateSemanticsId() : i);
    }

    public int getSemanticsId() {
        return this.semanticsId;
    }

    public void setSemanticsId(int i) {
        this.semanticsId = i;
    }

    public int getCompositeKeyHash() {
        return this.compositeKeyHash;
    }

    public void setCompositeKeyHash(int i) {
        this.compositeKeyHash = i;
    }

    public final boolean isVirtualLookaheadRoot$ui_release() {
        return this.isVirtualLookaheadRoot;
    }

    public final void setVirtualLookaheadRoot$ui_release(boolean z) {
        this.isVirtualLookaheadRoot = z;
    }

    public final LayoutNode getLookaheadRoot$ui_release() {
        return this.lookaheadRoot;
    }

    private final void setLookaheadRoot(LayoutNode newRoot) {
        if (!Intrinsics.areEqual((Object) newRoot, (Object) this.lookaheadRoot)) {
            this.lookaheadRoot = newRoot;
            if (newRoot != null) {
                this.layoutDelegate.ensureLookaheadDelegateCreated$ui_release();
                NodeCoordinator delegate$iv = getOuterCoordinator$ui_release();
                NodeCoordinator final$iv = getInnerCoordinator$ui_release().getWrapped$ui_release();
                while (!Intrinsics.areEqual((Object) delegate$iv, (Object) final$iv) && delegate$iv != null) {
                    delegate$iv.ensureLookaheadDelegateCreated();
                    delegate$iv = delegate$iv.getWrapped$ui_release();
                }
            }
            invalidateMeasurements$ui_release();
        }
    }

    public final Boolean isPlacedInLookahead() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release != null) {
            return Boolean.valueOf(lookaheadPassDelegate$ui_release.isPlaced());
        }
        return null;
    }

    public final List<LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.asList();
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if (this.unfoldedVirtualChildrenListDirty) {
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector mutableVector = this._unfoldedChildren;
            if (mutableVector == null) {
                MutableVector it = new MutableVector(new LayoutNode[16], 0);
                this._unfoldedChildren = it;
                mutableVector = it;
            }
            MutableVector unfoldedChildren = mutableVector;
            unfoldedChildren.clear();
            MutableVector this_$iv$iv = this._foldedChildren.getVector();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    LayoutNode it2 = (LayoutNode) content$iv$iv[i$iv$iv];
                    if (it2.isVirtual) {
                        MutableVector this_$iv = unfoldedChildren;
                        this_$iv.addAll(this_$iv.getSize(), it2.get_children$ui_release());
                    } else {
                        unfoldedChildren.add(it2);
                    }
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
            this.layoutDelegate.markChildrenDirty();
        }
    }

    public final List<Measurable> getChildMeasurables$ui_release() {
        return getMeasurePassDelegate$ui_release().getChildDelegates$ui_release();
    }

    public final List<Measurable> getChildLookaheadMeasurables$ui_release() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        return lookaheadPassDelegate$ui_release.getChildDelegates$ui_release();
    }

    private final void invalidateUnfoldedVirtualChildren() {
        LayoutNode layoutNode;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (this.isVirtual && (layoutNode = this._foldedParent) != null) {
            layoutNode.invalidateUnfoldedVirtualChildren();
        }
    }

    public final MutableVector<LayoutNode> get_children$ui_release() {
        updateChildrenIfDirty$ui_release();
        if (this.virtualChildrenCount == 0) {
            return this._foldedChildren.getVector();
        }
        MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
        Intrinsics.checkNotNull(mutableVector);
        return mutableVector;
    }

    public final void updateChildrenIfDirty$ui_release() {
        if (this.virtualChildrenCount > 0) {
            recreateUnfoldedChildrenIfDirty();
        }
    }

    public final void forEachChild(Function1<? super LayoutNode, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MutableVector this_$iv = get_children$ui_release();
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                block.invoke(content$iv[i$iv]);
                i$iv++;
            } while (i$iv < size$iv);
        }
    }

    public final void forEachChildIndexed(Function2<? super Integer, ? super LayoutNode, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MutableVector this_$iv = get_children$ui_release();
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                block.invoke(Integer.valueOf(i$iv), content$iv[i$iv]);
                i$iv++;
            } while (i$iv < size$iv);
        }
    }

    public final List<LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    public final LayoutNode getParent$ui_release() {
        LayoutNode parent = this._foldedParent;
        while (true) {
            boolean z = false;
            if (parent != null && parent.isVirtual) {
                z = true;
            }
            if (!z) {
                return parent;
            }
            parent = parent._foldedParent;
        }
    }

    public final Owner getOwner$ui_release() {
        return this.owner;
    }

    public final AndroidViewHolder getInteropViewFactoryHolder$ui_release() {
        return this.interopViewFactoryHolder;
    }

    public final void setInteropViewFactoryHolder$ui_release(AndroidViewHolder androidViewHolder) {
        this.interopViewFactoryHolder = androidViewHolder;
    }

    public View getInteropView() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            return androidViewHolder.getInteropView();
        }
        return null;
    }

    public boolean isAttached() {
        return this.owner != null;
    }

    public final int getDepth$ui_release() {
        return this.depth;
    }

    public final void setDepth$ui_release(int i) {
        this.depth = i;
    }

    public final LayoutState getLayoutState$ui_release() {
        return this.layoutDelegate.getLayoutState$ui_release();
    }

    public final LayoutNodeLayoutDelegate.LookaheadPassDelegate getLookaheadPassDelegate$ui_release() {
        return this.layoutDelegate.getLookaheadPassDelegate$ui_release();
    }

    public final LayoutNodeLayoutDelegate.MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.layoutDelegate.getMeasurePassDelegate$ui_release();
    }

    public final void insertAt$ui_release(int index, LayoutNode instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        String str = null;
        if (!(instance._foldedParent == null)) {
            StringBuilder append = new StringBuilder().append("Cannot insert ").append(instance).append(" because it already has a parent. This tree: ").append(debugTreeToString$default(this, 0, 1, (Object) null)).append(" Other tree: ");
            LayoutNode layoutNode = instance._foldedParent;
            if (layoutNode != null) {
                str = debugTreeToString$default(layoutNode, 0, 1, (Object) null);
            }
            throw new IllegalStateException(append.append(str).toString().toString());
        }
        if (instance.owner == null) {
            instance._foldedParent = this;
            this._foldedChildren.add(index, instance);
            onZSortedChildrenInvalidated$ui_release();
            if (instance.isVirtual) {
                this.virtualChildrenCount++;
            }
            invalidateUnfoldedVirtualChildren();
            Owner owner2 = this.owner;
            if (owner2 != null) {
                instance.attach$ui_release(owner2);
            }
            if (instance.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
                layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() + 1);
                return;
            }
            return;
        }
        throw new IllegalStateException(("Cannot insert " + instance + " because it already has an owner. This tree: " + debugTreeToString$default(this, 0, 1, (Object) null) + " Other tree: " + debugTreeToString$default(instance, 0, 1, (Object) null)).toString());
    }

    public final void onZSortedChildrenInvalidated$ui_release() {
        if (this.isVirtual) {
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated$ui_release();
                return;
            }
            return;
        }
        this.zSortedChildrenInvalidated = true;
    }

    public final void removeAt$ui_release(int index, int count) {
        if (count >= 0) {
            int i = (index + count) - 1;
            if (index <= i) {
                while (true) {
                    onChildRemoved(this._foldedChildren.removeAt(i));
                    if (i != index) {
                        i--;
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException(("count (" + count + ") must be greater than 0").toString());
        }
    }

    public final void removeAll$ui_release() {
        int i = this._foldedChildren.getSize();
        while (true) {
            i--;
            if (-1 < i) {
                onChildRemoved(this._foldedChildren.get(i));
            } else {
                this._foldedChildren.clear();
                return;
            }
        }
    }

    private final void onChildRemoved(LayoutNode child) {
        if (child.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() - 1);
        }
        if (this.owner != null) {
            child.detach$ui_release();
        }
        child._foldedParent = null;
        child.getOuterCoordinator$ui_release().setWrappedBy$ui_release((NodeCoordinator) null);
        if (child.isVirtual) {
            this.virtualChildrenCount--;
            MutableVector this_$iv$iv = child._foldedChildren.getVector();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    ((LayoutNode) content$iv$iv[i$iv$iv]).getOuterCoordinator$ui_release().setWrappedBy$ui_release((NodeCoordinator) null);
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui_release();
    }

    public final void move$ui_release(int from, int to, int count) {
        if (from != to) {
            for (int i = 0; i < count; i++) {
                this._foldedChildren.add(from > to ? to + i : (to + count) - 2, this._foldedChildren.removeAt(from > to ? from + i : from));
            }
            onZSortedChildrenInvalidated$ui_release();
            invalidateUnfoldedVirtualChildren();
            invalidateMeasurements$ui_release();
        }
    }

    public final void invalidateSemantics$ui_release() {
        this._collapsedSemantics = null;
        LayoutNodeKt.requireOwner(this).onSemanticsChange();
    }

    public final SemanticsConfiguration getCollapsedSemantics$ui_release() {
        if (!this.nodes.m6616hasH91voCI$ui_release(NodeKind.m6666constructorimpl(8)) || this._collapsedSemantics != null) {
            return this._collapsedSemantics;
        }
        Ref.ObjectRef config = new Ref.ObjectRef();
        config.element = new SemanticsConfiguration();
        LayoutNodeKt.requireOwner(this).getSnapshotObserver().observeSemanticsReads$ui_release(this, new LayoutNode$collapsedSemantics$1(this, config));
        this._collapsedSemantics = (SemanticsConfiguration) config.element;
        return (SemanticsConfiguration) config.element;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [androidx.compose.ui.node.NodeCoordinator] */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void attach$ui_release(androidx.compose.ui.node.Owner r12) {
        /*
            r11 = this;
            java.lang.String r0 = "owner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            androidx.compose.ui.node.Owner r0 = r11.owner
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000e
            r0 = r2
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            r3 = 0
            if (r0 == 0) goto L_0x0147
            androidx.compose.ui.node.LayoutNode r0 = r11._foldedParent
            if (r0 == 0) goto L_0x0025
            if (r0 == 0) goto L_0x001b
            androidx.compose.ui.node.Owner r0 = r0.owner
            goto L_0x001c
        L_0x001b:
            r0 = r3
        L_0x001c:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r12)
            if (r0 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r0 = r1
            goto L_0x0026
        L_0x0025:
            r0 = r2
        L_0x0026:
            if (r0 != 0) goto L_0x007b
            r0 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Attaching to a different owner("
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r12)
            java.lang.String r5 = ") than the parent's owner("
            java.lang.StringBuilder r4 = r4.append(r5)
            androidx.compose.ui.node.LayoutNode r5 = r11.getParent$ui_release()
            if (r5 == 0) goto L_0x0047
            androidx.compose.ui.node.Owner r5 = r5.owner
            goto L_0x0048
        L_0x0047:
            r5 = r3
        L_0x0048:
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = "). This tree: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = debugTreeToString$default(r11, r1, r2, r3)
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = " Parent tree: "
            java.lang.StringBuilder r4 = r4.append(r5)
            androidx.compose.ui.node.LayoutNode r5 = r11._foldedParent
            if (r5 == 0) goto L_0x0069
            java.lang.String r3 = debugTreeToString$default(r5, r1, r2, r3)
        L_0x0069:
            java.lang.StringBuilder r1 = r4.append(r3)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x007b:
            androidx.compose.ui.node.LayoutNode r0 = r11.getParent$ui_release()
            if (r0 != 0) goto L_0x0092
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate r1 = r11.getMeasurePassDelegate$ui_release()
            r1.setPlaced$ui_release(r2)
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate r1 = r11.getLookaheadPassDelegate$ui_release()
            if (r1 == 0) goto L_0x0092
            r4 = 0
            r1.setPlaced(r2)
        L_0x0092:
            androidx.compose.ui.node.NodeCoordinator r1 = r11.getOuterCoordinator$ui_release()
            if (r0 == 0) goto L_0x009c
            androidx.compose.ui.node.NodeCoordinator r3 = r0.getInnerCoordinator$ui_release()
        L_0x009c:
            r1.setWrappedBy$ui_release(r3)
            r11.owner = r12
            if (r0 == 0) goto L_0x00a6
            int r1 = r0.depth
            goto L_0x00a7
        L_0x00a6:
            r1 = -1
        L_0x00a7:
            int r1 = r1 + r2
            r11.depth = r1
            androidx.compose.ui.node.NodeChain r1 = r11.nodes
            r3 = 0
            r4 = 8
            int r3 = androidx.compose.ui.node.NodeKind.m6666constructorimpl(r4)
            boolean r1 = r1.m6616hasH91voCI$ui_release(r3)
            if (r1 == 0) goto L_0x00bc
            r11.invalidateSemantics$ui_release()
        L_0x00bc:
            r12.onAttach(r11)
            boolean r1 = r11.isVirtualLookaheadRoot
            if (r1 == 0) goto L_0x00c7
            r11.setLookaheadRoot(r11)
            goto L_0x00d4
        L_0x00c7:
            androidx.compose.ui.node.LayoutNode r1 = r11._foldedParent
            if (r1 == 0) goto L_0x00cf
            androidx.compose.ui.node.LayoutNode r1 = r1.lookaheadRoot
            if (r1 != 0) goto L_0x00d1
        L_0x00cf:
            androidx.compose.ui.node.LayoutNode r1 = r11.lookaheadRoot
        L_0x00d1:
            r11.setLookaheadRoot(r1)
        L_0x00d4:
            boolean r1 = r11.deactivated
            if (r1 != 0) goto L_0x00dd
            androidx.compose.ui.node.NodeChain r1 = r11.nodes
            r1.markAsAttached()
        L_0x00dd:
            androidx.compose.ui.node.MutableVectorWithMutationTracking<androidx.compose.ui.node.LayoutNode> r1 = r11._foldedChildren
            r3 = 0
            androidx.compose.runtime.collection.MutableVector r4 = r1.getVector()
            r5 = 0
            int r6 = r4.getSize()
            if (r6 <= 0) goto L_0x00fe
            r7 = 0
            java.lang.Object[] r8 = r4.getContent()
        L_0x00f1:
            r9 = r8[r7]
            androidx.compose.ui.node.LayoutNode r9 = (androidx.compose.ui.node.LayoutNode) r9
            r10 = 0
            r9.attach$ui_release(r12)
            int r7 = r7 + r2
            if (r7 < r6) goto L_0x00f1
        L_0x00fe:
            boolean r1 = r11.deactivated
            if (r1 != 0) goto L_0x0109
            androidx.compose.ui.node.NodeChain r1 = r11.nodes
            r1.runAttachLifecycle()
        L_0x0109:
            r11.invalidateMeasurements$ui_release()
            if (r0 == 0) goto L_0x0111
            r0.invalidateMeasurements$ui_release()
        L_0x0111:
            r1 = r11
            r2 = 0
            androidx.compose.ui.node.NodeCoordinator r3 = r1.getOuterCoordinator$ui_release()
            androidx.compose.ui.node.NodeCoordinator r4 = r1.getInnerCoordinator$ui_release()
            androidx.compose.ui.node.NodeCoordinator r4 = r4.getWrapped$ui_release()
        L_0x011f:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r5 != 0) goto L_0x0132
            if (r3 == 0) goto L_0x0132
            r5 = r3
            r6 = 0
            r5.onLayoutNodeAttach()
            androidx.compose.ui.node.NodeCoordinator r3 = r3.getWrapped$ui_release()
            goto L_0x011f
        L_0x0132:
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.node.Owner, kotlin.Unit> r1 = r11.onAttach
            if (r1 == 0) goto L_0x013a
            r1.invoke(r12)
        L_0x013a:
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r1 = r11.layoutDelegate
            r1.updateParentData()
            boolean r1 = r11.deactivated
            if (r1 != 0) goto L_0x0146
            r11.invalidateFocusOnAttach()
        L_0x0146:
            return
        L_0x0147:
            r0 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Cannot attach "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r11)
            java.lang.String r5 = " as it already is attached.  Tree: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r1 = debugTreeToString$default(r11, r1, r2, r3)
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.attach$ui_release(androidx.compose.ui.node.Owner):void");
    }

    public final void detach$ui_release() {
        Owner owner2 = this.owner;
        String str = null;
        if (owner2 == null) {
            StringBuilder append = new StringBuilder().append("Cannot detach node that is already detached!  Tree: ");
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                str = debugTreeToString$default(parent$ui_release, 0, 1, (Object) null);
            }
            throw new IllegalStateException(append.append(str).toString().toString());
        }
        invalidateFocusOnDetach();
        LayoutNode parent = getParent$ui_release();
        if (parent != null) {
            parent.invalidateLayer$ui_release();
            parent.invalidateMeasurements$ui_release();
            getMeasurePassDelegate$ui_release().setMeasuredByParent$ui_release(UsageByParent.NotUsed);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate it = getLookaheadPassDelegate$ui_release();
            if (it != null) {
                it.setMeasuredByParent$ui_release(UsageByParent.NotUsed);
            }
        }
        this.layoutDelegate.resetAlignmentLines();
        Function1<? super Owner, Unit> function1 = this.onDetach;
        if (function1 != null) {
            function1.invoke(owner2);
        }
        if (this.nodes.m6616hasH91voCI$ui_release(NodeKind.m6666constructorimpl(8))) {
            invalidateSemantics$ui_release();
        }
        this.nodes.runDetachLifecycle$ui_release();
        this.ignoreRemeasureRequests = true;
        MutableVector this_$iv$iv = this._foldedChildren.getVector();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                ((LayoutNode) content$iv$iv[i$iv$iv]).detach$ui_release();
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
        this.ignoreRemeasureRequests = false;
        this.nodes.markAsDetached$ui_release();
        owner2.onDetach(this);
        this.owner = null;
        setLookaheadRoot((LayoutNode) null);
        this.depth = 0;
        getMeasurePassDelegate$ui_release().onNodeDetached();
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release != null) {
            lookaheadPassDelegate$ui_release.onNodeDetached();
        }
    }

    public final MutableVector<LayoutNode> getZSortedChildren() {
        if (this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            MutableVector this_$iv = this._zSortedChildren;
            this_$iv.addAll(this_$iv.getSize(), get_children$ui_release());
            this._zSortedChildren.sortWith(ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return this._zSortedChildren;
    }

    public boolean isValidOwnerScope() {
        return isAttached();
    }

    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, (String) null) + " children: " + getChildren$ui_release().size() + " measurePolicy: " + getMeasurePolicy();
    }

    public final boolean getHasFixedInnerContentConstraints$ui_release() {
        long innerContentConstraints = getInnerCoordinator$ui_release().m6637getLastMeasurementConstraintsmsEJaDk$ui_release();
        return Constraints.m7496getHasFixedWidthimpl(innerContentConstraints) && Constraints.m7495getHasFixedHeightimpl(innerContentConstraints);
    }

    static /* synthetic */ String debugTreeToString$default(LayoutNode layoutNode, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return layoutNode.debugTreeToString(i);
    }

    private final String debugTreeToString(int depth2) {
        StringBuilder tree = new StringBuilder();
        for (int i = 0; i < depth2; i++) {
            tree.append("  ");
        }
        tree.append("|-");
        tree.append(toString());
        tree.append(10);
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                tree.append(((LayoutNode) content$iv$iv[i$iv$iv]).debugTreeToString(depth2 + 1));
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
        String treeString = tree.toString();
        Intrinsics.checkNotNullExpressionValue(treeString, "tree.toString()");
        if (depth2 != 0) {
            return treeString;
        }
        String treeString2 = treeString.substring(0, treeString.length() - 1);
        Intrinsics.checkNotNullExpressionValue(treeString2, "this as java.lang.String…ing(startIndex, endIndex)");
        return treeString2;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\"\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0010\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", "", "(Ljava/lang/String;)V", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        private final String error;

        public NoIntrinsicsMeasurePolicy(String error2) {
            Intrinsics.checkNotNullParameter(error2, "error");
            this.error = error2;
        }

        public Void minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
            Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        public Void minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
            Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        public Void maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
            Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        public Void maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
            Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }
    }

    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    public void setMeasurePolicy(MeasurePolicy value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual((Object) this.measurePolicy, (Object) value)) {
            this.measurePolicy = value;
            this.intrinsicsPolicy.updateFrom(getMeasurePolicy());
            invalidateMeasurements$ui_release();
        }
    }

    public final IntrinsicsPolicy getIntrinsicsPolicy$ui_release() {
        return this.intrinsicsPolicy;
    }

    public Density getDensity() {
        return this.density;
    }

    public void setDensity(Density value) {
        int i;
        int type$iv;
        NodeChain this_$iv;
        int i2;
        int type$iv2;
        NodeChain this_$iv2;
        int i3;
        int type$iv3;
        NodeChain this_$iv3;
        int i4;
        int type$iv4;
        NodeChain this_$iv4;
        int count$iv$iv;
        MutableVector mutableVector;
        Density density2 = value;
        Intrinsics.checkNotNullParameter(density2, "value");
        if (!Intrinsics.areEqual((Object) this.density, (Object) density2)) {
            this.density = density2;
            onDensityOrLayoutDirectionChanged();
            NodeChain this_$iv5 = this.nodes;
            int type$iv5 = NodeKind.m6666constructorimpl(16);
            int i5 = false;
            int mask$iv$iv = type$iv5;
            NodeChain this_$iv$iv = this_$iv5;
            if ((this_$iv$iv.getAggregateChildKindSet() & mask$iv$iv) != 0) {
                Modifier.Node node$iv$iv$iv = this_$iv$iv.getHead$ui_release();
                while (node$iv$iv$iv != null) {
                    Modifier.Node it$iv$iv = node$iv$iv$iv;
                    if ((it$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                        MutableVector mutableVector2 = null;
                        Modifier.Node node = it$iv$iv;
                        while (node != null) {
                            if (node instanceof PointerInputModifierNode) {
                                ((PointerInputModifierNode) node).onDensityChange();
                                this_$iv3 = this_$iv;
                                type$iv3 = type$iv;
                                i3 = i;
                            } else {
                                Modifier.Node this_$iv$iv$iv = node;
                                Modifier.Node node2 = this_$iv$iv$iv;
                                if (((this_$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                    this_$iv3 = this_$iv;
                                    type$iv3 = type$iv;
                                    i3 = i;
                                } else {
                                    int count$iv$iv2 = 0;
                                    Modifier.Node node$iv$iv$iv2 = ((DelegatingNode) node).getDelegate$ui_release();
                                    while (node$iv$iv$iv2 != null) {
                                        Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                        if ((next$iv$iv.getKindSet$ui_release() & type$iv) != 0) {
                                            count$iv$iv2++;
                                            this_$iv4 = this_$iv;
                                            if (count$iv$iv2 == 1) {
                                                node = next$iv$iv;
                                                type$iv4 = type$iv;
                                                i4 = i;
                                                Modifier.Node node3 = next$iv$iv;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    count$iv$iv = count$iv$iv2;
                                                    type$iv4 = type$iv;
                                                    i4 = i;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    count$iv$iv = count$iv$iv2;
                                                    type$iv4 = type$iv;
                                                    i4 = i;
                                                    mutableVector = mutableVector2;
                                                }
                                                MutableVector mutableVector3 = mutableVector;
                                                Modifier.Node theNode$iv$iv = node;
                                                if (theNode$iv$iv != null) {
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(theNode$iv$iv);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(next$iv$iv);
                                                }
                                                mutableVector2 = mutableVector3;
                                                count$iv$iv2 = count$iv$iv;
                                            }
                                        } else {
                                            this_$iv4 = this_$iv;
                                            type$iv4 = type$iv;
                                            i4 = i;
                                            Modifier.Node node4 = next$iv$iv;
                                        }
                                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                        this_$iv = this_$iv4;
                                        type$iv = type$iv4;
                                        i = i4;
                                    }
                                    this_$iv3 = this_$iv;
                                    type$iv3 = type$iv;
                                    i3 = i;
                                    if (count$iv$iv2 == 1) {
                                        Density density3 = value;
                                        this_$iv = this_$iv3;
                                        type$iv = type$iv3;
                                        i = i3;
                                    }
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                            Density density4 = value;
                            this_$iv = this_$iv3;
                            type$iv = type$iv3;
                            i = i3;
                        }
                        this_$iv2 = this_$iv;
                        type$iv2 = type$iv;
                        i2 = i;
                    } else {
                        this_$iv2 = this_$iv;
                        type$iv2 = type$iv;
                        i2 = i;
                    }
                    if ((it$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        Density density5 = value;
                        this_$iv5 = this_$iv2;
                        type$iv5 = type$iv2;
                        i5 = i2;
                    } else {
                        return;
                    }
                }
                int i6 = type$iv;
                int i7 = i;
                return;
            }
            int i8 = type$iv5;
        }
    }

    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public void setLayoutDirection(LayoutDirection value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.layoutDirection != value) {
            this.layoutDirection = value;
            onDensityOrLayoutDirectionChanged();
        }
    }

    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public void setViewConfiguration(ViewConfiguration value) {
        int i;
        int type$iv;
        NodeChain this_$iv;
        int i2;
        int type$iv2;
        NodeChain this_$iv2;
        int i3;
        int type$iv3;
        NodeChain this_$iv3;
        int i4;
        int type$iv4;
        NodeChain this_$iv4;
        int count$iv$iv;
        MutableVector mutableVector;
        ViewConfiguration viewConfiguration2 = value;
        Intrinsics.checkNotNullParameter(viewConfiguration2, "value");
        if (!Intrinsics.areEqual((Object) this.viewConfiguration, (Object) viewConfiguration2)) {
            this.viewConfiguration = viewConfiguration2;
            NodeChain this_$iv5 = this.nodes;
            int type$iv5 = NodeKind.m6666constructorimpl(16);
            int i5 = false;
            int mask$iv$iv = type$iv5;
            NodeChain this_$iv$iv = this_$iv5;
            if ((this_$iv$iv.getAggregateChildKindSet() & mask$iv$iv) != 0) {
                Modifier.Node node$iv$iv$iv = this_$iv$iv.getHead$ui_release();
                while (node$iv$iv$iv != null) {
                    Modifier.Node it$iv$iv = node$iv$iv$iv;
                    if ((it$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                        MutableVector mutableVector2 = null;
                        Modifier.Node node = it$iv$iv;
                        while (node != null) {
                            if (node instanceof PointerInputModifierNode) {
                                ((PointerInputModifierNode) node).onViewConfigurationChange();
                                this_$iv3 = this_$iv;
                                type$iv3 = type$iv;
                                i3 = i;
                            } else {
                                Modifier.Node this_$iv$iv$iv = node;
                                Modifier.Node node2 = this_$iv$iv$iv;
                                if (((this_$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                    this_$iv3 = this_$iv;
                                    type$iv3 = type$iv;
                                    i3 = i;
                                } else {
                                    int count$iv$iv2 = 0;
                                    Modifier.Node node$iv$iv$iv2 = ((DelegatingNode) node).getDelegate$ui_release();
                                    while (node$iv$iv$iv2 != null) {
                                        Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                        if ((next$iv$iv.getKindSet$ui_release() & type$iv) != 0) {
                                            count$iv$iv2++;
                                            this_$iv4 = this_$iv;
                                            if (count$iv$iv2 == 1) {
                                                node = next$iv$iv;
                                                type$iv4 = type$iv;
                                                i4 = i;
                                                Modifier.Node node3 = next$iv$iv;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    count$iv$iv = count$iv$iv2;
                                                    type$iv4 = type$iv;
                                                    i4 = i;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    count$iv$iv = count$iv$iv2;
                                                    type$iv4 = type$iv;
                                                    i4 = i;
                                                    mutableVector = mutableVector2;
                                                }
                                                MutableVector mutableVector3 = mutableVector;
                                                Modifier.Node theNode$iv$iv = node;
                                                if (theNode$iv$iv != null) {
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(theNode$iv$iv);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(next$iv$iv);
                                                }
                                                mutableVector2 = mutableVector3;
                                                count$iv$iv2 = count$iv$iv;
                                            }
                                        } else {
                                            this_$iv4 = this_$iv;
                                            type$iv4 = type$iv;
                                            i4 = i;
                                            Modifier.Node node4 = next$iv$iv;
                                        }
                                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                        this_$iv = this_$iv4;
                                        type$iv = type$iv4;
                                        i = i4;
                                    }
                                    this_$iv3 = this_$iv;
                                    type$iv3 = type$iv;
                                    i3 = i;
                                    if (count$iv$iv2 == 1) {
                                        ViewConfiguration viewConfiguration3 = value;
                                        this_$iv = this_$iv3;
                                        type$iv = type$iv3;
                                        i = i3;
                                    }
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                            ViewConfiguration viewConfiguration4 = value;
                            this_$iv = this_$iv3;
                            type$iv = type$iv3;
                            i = i3;
                        }
                        this_$iv2 = this_$iv;
                        type$iv2 = type$iv;
                        i2 = i;
                    } else {
                        this_$iv2 = this_$iv;
                        type$iv2 = type$iv;
                        i2 = i;
                    }
                    if ((it$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        ViewConfiguration viewConfiguration5 = value;
                        this_$iv5 = this_$iv2;
                        type$iv5 = type$iv2;
                        i5 = i2;
                    } else {
                        return;
                    }
                }
                int i6 = type$iv;
                int i7 = i;
                return;
            }
            int i8 = type$iv5;
        }
    }

    public CompositionLocalMap getCompositionLocalMap() {
        return this.compositionLocalMap;
    }

    public void setCompositionLocalMap(CompositionLocalMap value) {
        int type$iv;
        NodeChain this_$iv;
        int type$iv2;
        NodeChain this_$iv2;
        int type$iv3;
        int type$iv4;
        int count$iv$iv;
        MutableVector mutableVector;
        CompositionLocalMap compositionLocalMap2 = value;
        Intrinsics.checkNotNullParameter(compositionLocalMap2, "value");
        this.compositionLocalMap = compositionLocalMap2;
        setDensity((Density) compositionLocalMap2.get(CompositionLocalsKt.getLocalDensity()));
        setLayoutDirection((LayoutDirection) compositionLocalMap2.get(CompositionLocalsKt.getLocalLayoutDirection()));
        setViewConfiguration((ViewConfiguration) compositionLocalMap2.get(CompositionLocalsKt.getLocalViewConfiguration()));
        NodeChain this_$iv3 = this.nodes;
        int type$iv5 = NodeKind.m6666constructorimpl(32768);
        int mask$iv$iv = type$iv5;
        NodeChain this_$iv$iv = this_$iv3;
        if ((this_$iv$iv.getAggregateChildKindSet() & mask$iv$iv) != 0) {
            Modifier.Node node$iv$iv$iv = this_$iv$iv.getHead$ui_release();
            while (node$iv$iv$iv != null) {
                Modifier.Node it$iv$iv = node$iv$iv$iv;
                if ((it$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                    MutableVector mutableVector2 = null;
                    Modifier.Node node = it$iv$iv;
                    while (node != null) {
                        NodeChain this_$iv4 = this_$iv;
                        if (node instanceof CompositionLocalConsumerModifierNode) {
                            CompositionLocalConsumerModifierNode modifierNode = (CompositionLocalConsumerModifierNode) node;
                            Modifier.Node delegatedNode = modifierNode.getNode();
                            if (delegatedNode.isAttached()) {
                                NodeKindKt.autoInvalidateUpdatedNode(delegatedNode);
                                CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode = modifierNode;
                            } else {
                                CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode2 = modifierNode;
                                delegatedNode.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                            }
                            type$iv3 = type$iv;
                        } else {
                            Modifier.Node this_$iv$iv$iv = node;
                            Modifier.Node node2 = this_$iv$iv$iv;
                            if (((this_$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                type$iv3 = type$iv;
                            } else {
                                int count$iv$iv2 = 0;
                                Modifier.Node node$iv$iv$iv2 = ((DelegatingNode) node).getDelegate$ui_release();
                                while (node$iv$iv$iv2 != null) {
                                    Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                    if ((next$iv$iv.getKindSet$ui_release() & type$iv) != 0) {
                                        count$iv$iv2++;
                                        if (count$iv$iv2 == 1) {
                                            node = next$iv$iv;
                                            type$iv4 = type$iv;
                                            Modifier.Node node3 = next$iv$iv;
                                        } else {
                                            if (mutableVector2 == null) {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv4 = type$iv;
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv4 = type$iv;
                                                mutableVector = mutableVector2;
                                            }
                                            Modifier.Node theNode$iv$iv = node;
                                            if (theNode$iv$iv != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(theNode$iv$iv);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(next$iv$iv);
                                            }
                                            mutableVector2 = mutableVector;
                                            count$iv$iv2 = count$iv$iv;
                                        }
                                    } else {
                                        type$iv4 = type$iv;
                                        Modifier.Node node4 = next$iv$iv;
                                    }
                                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                    type$iv = type$iv4;
                                }
                                type$iv3 = type$iv;
                                if (count$iv$iv2 == 1) {
                                    CompositionLocalMap compositionLocalMap3 = value;
                                    this_$iv = this_$iv4;
                                    type$iv = type$iv3;
                                }
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector2);
                        CompositionLocalMap compositionLocalMap4 = value;
                        this_$iv = this_$iv4;
                        type$iv = type$iv3;
                    }
                    this_$iv2 = this_$iv;
                    type$iv2 = type$iv;
                } else {
                    this_$iv2 = this_$iv;
                    type$iv2 = type$iv;
                }
                if ((it$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    CompositionLocalMap compositionLocalMap5 = value;
                    this_$iv3 = this_$iv2;
                    type$iv5 = type$iv2;
                } else {
                    return;
                }
            }
            int i = type$iv;
            return;
        }
        int i2 = type$iv5;
    }

    private final void onDensityOrLayoutDirectionChanged() {
        invalidateMeasurements$ui_release();
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateLayers$ui_release();
    }

    public int getWidth() {
        return this.layoutDelegate.getWidth$ui_release();
    }

    public int getHeight() {
        return this.layoutDelegate.getHeight$ui_release();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        r2 = r2.getAlignmentLines();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean getAlignmentLinesRequired$ui_release() {
        /*
            r5 = this;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = r5.layoutDelegate
            r1 = 0
            androidx.compose.ui.node.AlignmentLinesOwner r2 = r0.getAlignmentLinesOwner$ui_release()
            androidx.compose.ui.node.AlignmentLines r2 = r2.getAlignmentLines()
            boolean r2 = r2.getRequired$ui_release()
            r3 = 1
            if (r2 != 0) goto L_0x002d
            androidx.compose.ui.node.AlignmentLinesOwner r2 = r0.getLookaheadAlignmentLinesOwner$ui_release()
            r4 = 0
            if (r2 == 0) goto L_0x0027
            androidx.compose.ui.node.AlignmentLines r2 = r2.getAlignmentLines()
            if (r2 == 0) goto L_0x0027
            boolean r2 = r2.getRequired$ui_release()
            if (r2 != r3) goto L_0x0027
            r2 = r3
            goto L_0x0028
        L_0x0027:
            r2 = r4
        L_0x0028:
            if (r2 == 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r3 = r4
            goto L_0x002e
        L_0x002d:
        L_0x002e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.getAlignmentLinesRequired$ui_release():boolean");
    }

    public final LayoutNodeDrawScope getMDrawScope$ui_release() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    public boolean isPlaced() {
        return getMeasurePassDelegate$ui_release().isPlaced();
    }

    public final int getPlaceOrder$ui_release() {
        return getMeasurePassDelegate$ui_release().getPlaceOrder$ui_release();
    }

    public final UsageByParent getMeasuredByParent$ui_release() {
        return getMeasurePassDelegate$ui_release().getMeasuredByParent$ui_release();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getMeasuredByParent$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.node.LayoutNode.UsageByParent getMeasuredByParentInLookahead$ui_release() {
        /*
            r1 = this;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate r0 = r1.getLookaheadPassDelegate$ui_release()
            if (r0 == 0) goto L_0x000c
            androidx.compose.ui.node.LayoutNode$UsageByParent r0 = r0.getMeasuredByParent$ui_release()
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            androidx.compose.ui.node.LayoutNode$UsageByParent r0 = androidx.compose.ui.node.LayoutNode.UsageByParent.NotUsed
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.getMeasuredByParentInLookahead$ui_release():androidx.compose.ui.node.LayoutNode$UsageByParent");
    }

    public final UsageByParent getIntrinsicsUsageByParent$ui_release() {
        return this.intrinsicsUsageByParent;
    }

    public final void setIntrinsicsUsageByParent$ui_release(UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.intrinsicsUsageByParent = usageByParent;
    }

    public final boolean getCanMultiMeasure$ui_release() {
        return this.canMultiMeasure;
    }

    public final void setCanMultiMeasure$ui_release(boolean z) {
        this.canMultiMeasure = z;
    }

    public final NodeChain getNodes$ui_release() {
        return this.nodes;
    }

    public final NodeCoordinator getInnerCoordinator$ui_release() {
        return this.nodes.getInnerCoordinator$ui_release();
    }

    public final LayoutNodeLayoutDelegate getLayoutDelegate$ui_release() {
        return this.layoutDelegate;
    }

    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.nodes.getOuterCoordinator$ui_release();
    }

    private final float getZIndex() {
        return getMeasurePassDelegate$ui_release().getZIndex$ui_release();
    }

    public final LayoutNodeSubcompositionsState getSubcompositionsState$ui_release() {
        return this.subcompositionsState;
    }

    public final void setSubcompositionsState$ui_release(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.subcompositionsState = layoutNodeSubcompositionsState;
    }

    public final boolean getInnerLayerCoordinatorIsDirty$ui_release() {
        return this.innerLayerCoordinatorIsDirty;
    }

    public final void setInnerLayerCoordinatorIsDirty$ui_release(boolean z) {
        this.innerLayerCoordinatorIsDirty = z;
    }

    private final NodeCoordinator getInnerLayerCoordinator() {
        if (this.innerLayerCoordinatorIsDirty) {
            NodeCoordinator coordinator = getInnerCoordinator$ui_release();
            NodeCoordinator wrappedBy$ui_release = getOuterCoordinator$ui_release().getWrappedBy$ui_release();
            this._innerLayerCoordinator = null;
            while (true) {
                if (Intrinsics.areEqual((Object) coordinator, (Object) wrappedBy$ui_release)) {
                    break;
                }
                if ((coordinator != null ? coordinator.getLayer() : null) != null) {
                    this._innerLayerCoordinator = coordinator;
                    break;
                }
                coordinator = coordinator != null ? coordinator.getWrappedBy$ui_release() : null;
            }
        }
        NodeCoordinator layerCoordinator = this._innerLayerCoordinator;
        if (layerCoordinator == null || layerCoordinator.getLayer() != null) {
            return layerCoordinator;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void invalidateLayer$ui_release() {
        NodeCoordinator innerLayerCoordinator = getInnerLayerCoordinator();
        if (innerLayerCoordinator != null) {
            innerLayerCoordinator.invalidateLayer();
            return;
        }
        LayoutNode parent = getParent$ui_release();
        if (parent != null) {
            parent.invalidateLayer$ui_release();
        }
    }

    public Modifier getModifier() {
        return this.modifier;
    }

    public void setModifier(Modifier value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!this.isVirtual || getModifier() == Modifier.Companion) {
            this.modifier = value;
            this.nodes.updateFrom$ui_release(value);
            this.layoutDelegate.updateParentData();
            if (this.nodes.m6616hasH91voCI$ui_release(NodeKind.m6666constructorimpl(512)) && this.lookaheadRoot == null) {
                setLookaheadRoot(this);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Modifiers are not supported on virtual LayoutNodes".toString());
    }

    private final void resetModifierState() {
        this.nodes.resetState$ui_release();
    }

    public final void invalidateParentData$ui_release() {
        this.layoutDelegate.invalidateParentData();
    }

    public LayoutCoordinates getCoordinates() {
        return getInnerCoordinator$ui_release();
    }

    public final Function1<Owner, Unit> getOnAttach$ui_release() {
        return this.onAttach;
    }

    public final void setOnAttach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onAttach = function1;
    }

    public final Function1<Owner, Unit> getOnDetach$ui_release() {
        return this.onDetach;
    }

    public final void setOnDetach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onDetach = function1;
    }

    public final boolean getNeedsOnPositionedDispatch$ui_release() {
        return this.needsOnPositionedDispatch;
    }

    public final void setNeedsOnPositionedDispatch$ui_release(boolean z) {
        this.needsOnPositionedDispatch = z;
    }

    public final void place$ui_release(int x, int y) {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.MeasurePassDelegate $this$place_u24lambda_u2423 = getMeasurePassDelegate$ui_release();
        Placeable.PlacementScope.Companion this_$iv = Placeable.PlacementScope.Companion;
        int parentWidth$iv = $this$place_u24lambda_u2423.getMeasuredWidth();
        LayoutDirection parentLayoutDirection$iv = getLayoutDirection();
        LayoutNode parent$ui_release = getParent$ui_release();
        LookaheadCapablePlaceable lookaheadCapablePlaceable$iv = parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null;
        LayoutCoordinates previousLayoutCoordinates$iv = Placeable.PlacementScope._coordinates;
        int previousParentWidth$iv = Placeable.PlacementScope.Companion.getParentWidth();
        LayoutDirection previousParentLayoutDirection$iv = Placeable.PlacementScope.Companion.getParentLayoutDirection();
        LayoutNodeLayoutDelegate previousLayoutDelegate$iv = Placeable.PlacementScope.layoutDelegate;
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentWidth = parentWidth$iv;
        Placeable.PlacementScope.Companion companion2 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection$iv;
        boolean wasPlacingForAlignment$iv = this_$iv.configureForPlacingForAlignment(lookaheadCapablePlaceable$iv);
        Placeable.PlacementScope.placeRelative$default(this_$iv, $this$place_u24lambda_u2423, x, y, 0.0f, 4, (Object) null);
        if (lookaheadCapablePlaceable$iv != null) {
            lookaheadCapablePlaceable$iv.setPlacingForAlignment$ui_release(wasPlacingForAlignment$iv);
        }
        Placeable.PlacementScope.Companion companion3 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentWidth = previousParentWidth$iv;
        Placeable.PlacementScope.Companion companion4 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentLayoutDirection = previousParentLayoutDirection$iv;
        Placeable.PlacementScope._coordinates = previousLayoutCoordinates$iv;
        Placeable.PlacementScope.layoutDelegate = previousLayoutDelegate$iv;
    }

    public final void replace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        getMeasurePassDelegate$ui_release().replace();
    }

    public final void lookaheadReplace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        lookaheadPassDelegate$ui_release.replace();
    }

    public final void draw$ui_release(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getOuterCoordinator$ui_release().draw(canvas);
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release$default  reason: not valid java name */
    public static /* synthetic */ void m6536hitTestM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        boolean z3;
        boolean z4;
        if ((i & 4) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i & 8) != 0) {
            z4 = true;
        } else {
            z4 = z2;
        }
        layoutNode.m6540hitTestM_7yMNQ$ui_release(j, hitTestResult, z3, z4);
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release  reason: not valid java name */
    public final void m6540hitTestM_7yMNQ$ui_release(long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        getOuterCoordinator$ui_release().m6642hitTestYqVAtuI(NodeCoordinator.Companion.getPointerInputSource(), getOuterCoordinator$ui_release().m6636fromParentPositionMKHz9U(pointerPosition), hitTestResult, isTouchEvent, isInLayer);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release$default  reason: not valid java name */
    public static /* synthetic */ void m6537hitTestSemanticsM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        boolean z3;
        boolean z4;
        if ((i & 4) != 0) {
            z3 = true;
        } else {
            z3 = z;
        }
        if ((i & 8) != 0) {
            z4 = true;
        } else {
            z4 = z2;
        }
        layoutNode.m6541hitTestSemanticsM_7yMNQ$ui_release(j, hitTestResult, z3, z4);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release  reason: not valid java name */
    public final void m6541hitTestSemanticsM_7yMNQ$ui_release(long pointerPosition, HitTestResult hitSemanticsEntities, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitSemanticsEntities, "hitSemanticsEntities");
        getOuterCoordinator$ui_release().m6642hitTestYqVAtuI(NodeCoordinator.Companion.getSemanticsSource(), getOuterCoordinator$ui_release().m6636fromParentPositionMKHz9U(pointerPosition), hitSemanticsEntities, true, isInLayer);
    }

    public final void rescheduleRemeasureOrRelayout$ui_release(LayoutNode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (WhenMappings.$EnumSwitchMapping$0[it.getLayoutState$ui_release().ordinal()] != 1) {
            throw new IllegalStateException("Unexpected state " + it.getLayoutState$ui_release());
        } else if (it.getMeasurePending$ui_release()) {
            requestRemeasure$ui_release$default(it, true, false, 2, (Object) null);
        } else if (it.getLayoutPending$ui_release()) {
            it.requestRelayout$ui_release(true);
        } else if (it.getLookaheadMeasurePending$ui_release()) {
            requestLookaheadRemeasure$ui_release$default(it, true, false, 2, (Object) null);
        } else if (it.getLookaheadLayoutPending$ui_release()) {
            it.requestLookaheadRelayout$ui_release(true);
        }
    }

    public static /* synthetic */ void requestRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        layoutNode.requestRemeasure$ui_release(z, z2);
    }

    public final void requestRemeasure$ui_release(boolean forceRequest, boolean scheduleMeasureAndLayout) {
        Owner owner2;
        if (!this.ignoreRemeasureRequests && !this.isVirtual && (owner2 = this.owner) != null) {
            Owner.onRequestMeasure$default(owner2, this, false, forceRequest, scheduleMeasureAndLayout, 2, (Object) null);
            getMeasurePassDelegate$ui_release().invalidateIntrinsicsParent(forceRequest);
        }
    }

    public static /* synthetic */ void requestLookaheadRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        layoutNode.requestLookaheadRemeasure$ui_release(z, z2);
    }

    public final void requestLookaheadRemeasure$ui_release(boolean forceRequest, boolean scheduleMeasureAndLayout) {
        if (this.lookaheadRoot != null) {
            Owner owner2 = this.owner;
            if (owner2 != null && !this.ignoreRemeasureRequests && !this.isVirtual) {
                owner2.onRequestMeasure(this, true, forceRequest, scheduleMeasureAndLayout);
                LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                lookaheadPassDelegate$ui_release.invalidateIntrinsicsParent(forceRequest);
                return;
            }
            return;
        }
        throw new IllegalStateException("Lookahead measure cannot be requested on a node that is not a part of theLookaheadLayout".toString());
    }

    public final void invalidateMeasurements$ui_release() {
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, false, 3, (Object) null);
        } else {
            requestRemeasure$ui_release$default(this, false, false, 3, (Object) null);
        }
    }

    private final void invalidateFocusOnAttach() {
        if (this.nodes.has$ui_release(NodeKind.m6666constructorimpl(1024) | NodeKind.m6666constructorimpl(2048) | NodeKind.m6666constructorimpl(4096))) {
            for (Modifier.Node node$iv = this.nodes.getHead$ui_release(); node$iv != null; node$iv = node$iv.getChild$ui_release()) {
                Modifier.Node it = node$iv;
                int i = 1;
                int i2 = ((it.getKindSet$ui_release() & NodeKind.m6666constructorimpl(1024)) != 0 ? 1 : 0) | ((it.getKindSet$ui_release() & NodeKind.m6666constructorimpl(2048)) != 0 ? 1 : 0);
                if ((it.getKindSet$ui_release() & NodeKind.m6666constructorimpl(4096)) == 0) {
                    i = 0;
                }
                if ((i2 | i) != 0) {
                    NodeKindKt.autoInvalidateInsertedNode(it);
                }
            }
        }
    }

    private final void invalidateFocusOnDetach() {
        NodeChain this_$iv$iv;
        int mask$iv$iv;
        int i;
        int type$iv;
        NodeChain this_$iv;
        int type$iv2;
        int mask$iv$iv2;
        NodeChain this_$iv$iv2;
        int type$iv3;
        int count$iv$iv;
        MutableVector mutableVector;
        NodeChain this_$iv2 = this.nodes;
        int type$iv4 = NodeKind.m6666constructorimpl(1024);
        int i2 = false;
        int mask$iv$iv3 = type$iv4;
        NodeChain this_$iv$iv3 = this_$iv2;
        if ((this_$iv$iv3.getAggregateChildKindSet() & mask$iv$iv3) != 0) {
            Modifier.Node node$iv$iv$iv = this_$iv$iv3.getTail$ui_release();
            while (node$iv$iv$iv != null) {
                Modifier.Node it$iv$iv = node$iv$iv$iv;
                if ((it$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                    MutableVector mutableVector2 = null;
                    Modifier.Node this_$iv$iv$iv = it$iv$iv;
                    while (this_$iv$iv$iv != null) {
                        NodeChain this_$iv3 = this_$iv;
                        int i3 = i;
                        int i4 = 1;
                        if (this_$iv$iv$iv instanceof FocusTargetNode) {
                            FocusTargetNode it = (FocusTargetNode) this_$iv$iv$iv;
                            if (it.getFocusState().isFocused()) {
                                mask$iv$iv2 = mask$iv$iv;
                                this_$iv$iv2 = this_$iv$iv;
                                LayoutNodeKt.requireOwner(this).getFocusOwner().clearFocus(true, false);
                                it.scheduleInvalidationForFocusEvents$ui_release();
                            } else {
                                mask$iv$iv2 = mask$iv$iv;
                                this_$iv$iv2 = this_$iv$iv;
                            }
                            type$iv2 = type$iv;
                        } else {
                            mask$iv$iv2 = mask$iv$iv;
                            this_$iv$iv2 = this_$iv$iv;
                            if (!((this_$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0) || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                                type$iv2 = type$iv;
                            } else {
                                int count$iv$iv2 = 0;
                                Modifier.Node node$iv$iv$iv2 = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                                while (node$iv$iv$iv2 != null) {
                                    Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                    if (((next$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? i4 : 0) != 0) {
                                        count$iv$iv2++;
                                        if (count$iv$iv2 == i4) {
                                            this_$iv$iv$iv = next$iv$iv;
                                            type$iv3 = type$iv;
                                            Modifier.Node node = next$iv$iv;
                                        } else {
                                            if (mutableVector2 == null) {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv3 = type$iv;
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv3 = type$iv;
                                                mutableVector = mutableVector2;
                                            }
                                            Modifier.Node theNode$iv$iv = this_$iv$iv$iv;
                                            if (theNode$iv$iv != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(theNode$iv$iv);
                                                }
                                                this_$iv$iv$iv = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(next$iv$iv);
                                            }
                                            mutableVector2 = mutableVector;
                                            count$iv$iv2 = count$iv$iv;
                                        }
                                    } else {
                                        type$iv3 = type$iv;
                                        Modifier.Node node2 = next$iv$iv;
                                    }
                                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                    type$iv = type$iv3;
                                    i4 = 1;
                                }
                                type$iv2 = type$iv;
                                if (count$iv$iv2 == 1) {
                                    this_$iv = this_$iv3;
                                    i = i3;
                                    this_$iv$iv = this_$iv$iv2;
                                    mask$iv$iv = mask$iv$iv2;
                                    type$iv = type$iv2;
                                }
                            }
                        }
                        this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector2);
                        this_$iv = this_$iv3;
                        i = i3;
                        this_$iv$iv = this_$iv$iv2;
                        mask$iv$iv = mask$iv$iv2;
                        type$iv = type$iv2;
                    }
                }
                node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                this_$iv2 = this_$iv;
                i2 = i;
                this_$iv$iv3 = this_$iv$iv;
                mask$iv$iv3 = mask$iv$iv;
                type$iv4 = type$iv;
            }
            int i5 = type$iv;
            int i6 = i;
            int i7 = mask$iv$iv;
            NodeChain nodeChain = this_$iv$iv;
            return;
        }
        int i8 = type$iv4;
        int i9 = mask$iv$iv3;
        NodeChain nodeChain2 = this_$iv$iv3;
    }

    public final void ignoreRemeasureRequests$ui_release(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.ignoreRemeasureRequests = true;
        block.invoke();
        this.ignoreRemeasureRequests = false;
    }

    public static /* synthetic */ void requestRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestRelayout$ui_release(z);
    }

    public final void requestRelayout$ui_release(boolean forceRequest) {
        Owner owner2;
        if (!this.isVirtual && (owner2 = this.owner) != null) {
            Owner.onRequestRelayout$default(owner2, this, false, forceRequest, 2, (Object) null);
        }
    }

    public static /* synthetic */ void requestLookaheadRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestLookaheadRelayout$ui_release(z);
    }

    public final void requestLookaheadRelayout$ui_release(boolean forceRequest) {
        Owner owner2;
        if (!this.isVirtual && (owner2 = this.owner) != null) {
            owner2.onRequestRelayout(this, true, forceRequest);
        }
    }

    public final void dispatchOnPositionedCallbacks$ui_release() {
        int i;
        int type$iv;
        NodeChain this_$iv;
        int type$iv2;
        int i2;
        NodeChain this_$iv2;
        char c;
        int type$iv3;
        int i3;
        NodeChain this_$iv3;
        int type$iv4;
        int count$iv$iv;
        MutableVector mutableVector;
        if (getLayoutState$ui_release() == LayoutState.Idle && !getLayoutPending$ui_release() && !getMeasurePending$ui_release() && isPlaced()) {
            NodeChain this_$iv4 = this.nodes;
            char c2 = 256;
            int type$iv5 = NodeKind.m6666constructorimpl(256);
            int i4 = false;
            int mask$iv$iv = type$iv5;
            NodeChain this_$iv$iv = this_$iv4;
            if ((this_$iv$iv.getAggregateChildKindSet() & mask$iv$iv) != 0) {
                Modifier.Node node$iv$iv$iv = this_$iv$iv.getHead$ui_release();
                while (node$iv$iv$iv != null) {
                    Modifier.Node it$iv$iv = node$iv$iv$iv;
                    if ((it$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                        MutableVector mutableVector2 = null;
                        Modifier.Node node = it$iv$iv;
                        while (node != null) {
                            if (node instanceof GlobalPositionAwareModifierNode) {
                                GlobalPositionAwareModifierNode it = (GlobalPositionAwareModifierNode) node;
                                this_$iv3 = this_$iv;
                                i3 = i;
                                it.onGloballyPositioned(DelegatableNodeKt.m6502requireCoordinator64DMado(it, NodeKind.m6666constructorimpl(256)));
                                type$iv3 = type$iv;
                            } else {
                                this_$iv3 = this_$iv;
                                i3 = i;
                                Modifier.Node this_$iv$iv$iv = node;
                                int kindSet$ui_release = this_$iv$iv$iv.getKindSet$ui_release() & type$iv;
                                Modifier.Node node2 = this_$iv$iv$iv;
                                int i5 = 1;
                                if ((kindSet$ui_release != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                    type$iv3 = type$iv;
                                } else {
                                    int count$iv$iv2 = 0;
                                    Modifier.Node node$iv$iv$iv2 = ((DelegatingNode) node).getDelegate$ui_release();
                                    while (node$iv$iv$iv2 != null) {
                                        Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                        if (((next$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? i5 : 0) != 0) {
                                            count$iv$iv2++;
                                            if (count$iv$iv2 == i5) {
                                                node = next$iv$iv;
                                                type$iv4 = type$iv;
                                                Modifier.Node node3 = next$iv$iv;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    count$iv$iv = count$iv$iv2;
                                                    type$iv4 = type$iv;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    count$iv$iv = count$iv$iv2;
                                                    type$iv4 = type$iv;
                                                    mutableVector = mutableVector2;
                                                }
                                                Modifier.Node theNode$iv$iv = node;
                                                if (theNode$iv$iv != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(theNode$iv$iv);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(next$iv$iv);
                                                }
                                                mutableVector2 = mutableVector;
                                                count$iv$iv2 = count$iv$iv;
                                            }
                                        } else {
                                            type$iv4 = type$iv;
                                            Modifier.Node node4 = next$iv$iv;
                                        }
                                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                        type$iv = type$iv4;
                                        i5 = 1;
                                    }
                                    type$iv3 = type$iv;
                                    if (count$iv$iv2 == 1) {
                                        this_$iv = this_$iv3;
                                        i = i3;
                                        type$iv = type$iv3;
                                    }
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                            this_$iv = this_$iv3;
                            i = i3;
                            type$iv = type$iv3;
                        }
                        this_$iv2 = this_$iv;
                        type$iv2 = type$iv;
                        i2 = i;
                        c = 256;
                    } else {
                        this_$iv2 = this_$iv;
                        type$iv2 = type$iv;
                        c = c2;
                        i2 = i;
                    }
                    if ((it$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        c2 = c;
                        this_$iv4 = this_$iv2;
                        i4 = i2;
                        type$iv5 = type$iv2;
                    } else {
                        return;
                    }
                }
                int i6 = type$iv;
                int i7 = i;
                return;
            }
            int i8 = type$iv5;
        }
    }

    public List<ModifierInfo> getModifierInfo() {
        return this.nodes.getModifierInfo();
    }

    public final void invalidateLayers$ui_release() {
        NodeCoordinator inner$iv = getInnerCoordinator$ui_release();
        for (NodeCoordinator coordinator$iv = getOuterCoordinator$ui_release(); coordinator$iv != inner$iv; coordinator$iv = ((LayoutModifierNodeCoordinator) coordinator$iv).getWrapped$ui_release()) {
            Intrinsics.checkNotNull(coordinator$iv, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            OwnedLayer layer = ((LayoutModifierNodeCoordinator) coordinator$iv).getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
        OwnedLayer layer2 = getInnerCoordinator$ui_release().getLayer();
        if (layer2 != null) {
            layer2.invalidate();
        }
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release$default  reason: not valid java name */
    public static /* synthetic */ boolean m6538lookaheadRemeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m6588getLastLookaheadConstraintsDWUhwKw();
        }
        return layoutNode.m6542lookaheadRemeasure_Sx5XlM$ui_release(constraints);
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release  reason: not valid java name */
    public final boolean m6542lookaheadRemeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints == null || this.lookaheadRoot == null) {
            return false;
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        return lookaheadPassDelegate$ui_release.m6593remeasureBRTryo0(constraints.m7504unboximpl());
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release$default  reason: not valid java name */
    public static /* synthetic */ boolean m6539remeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m6587getLastConstraintsDWUhwKw();
        }
        return layoutNode.m6543remeasure_Sx5XlM$ui_release(constraints);
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release  reason: not valid java name */
    public final boolean m6543remeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints == null) {
            return false;
        }
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreeIntrinsicsUsage$ui_release();
        }
        return getMeasurePassDelegate$ui_release().m6598remeasureBRTryo0(constraints.m7504unboximpl());
    }

    public final boolean getMeasurePending$ui_release() {
        return this.layoutDelegate.getMeasurePending$ui_release();
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutDelegate.getLayoutPending$ui_release();
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.layoutDelegate.getLookaheadMeasurePending$ui_release();
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.layoutDelegate.getLookaheadLayoutPending$ui_release();
    }

    public final void markLayoutPending$ui_release() {
        this.layoutDelegate.markLayoutPending$ui_release();
    }

    public final void markMeasurePending$ui_release() {
        this.layoutDelegate.markMeasurePending$ui_release();
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.layoutDelegate.markLookaheadLayoutPending$ui_release();
    }

    public static /* synthetic */ void invalidateSubtree$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        layoutNode.invalidateSubtree(z);
    }

    public final void invalidateSubtree(boolean isRootOfInvalidation) {
        char c;
        int type$iv;
        NodeChain this_$iv;
        int type$iv2;
        NodeChain this_$iv2;
        char c2;
        int type$iv3;
        NodeChain this_$iv3;
        char c3;
        int type$iv4;
        NodeChain this_$iv4;
        int count$iv$iv;
        MutableVector mutableVector;
        LayoutNode parent$ui_release;
        if (isRootOfInvalidation && (parent$ui_release = getParent$ui_release()) != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateSemantics$ui_release();
        requestRemeasure$ui_release$default(this, false, false, 3, (Object) null);
        NodeChain this_$iv5 = this.nodes;
        char c4 = 2;
        int type$iv5 = NodeKind.m6666constructorimpl(2);
        int mask$iv$iv = type$iv5;
        NodeChain this_$iv$iv = this_$iv5;
        if ((this_$iv$iv.getAggregateChildKindSet() & mask$iv$iv) != 0) {
            Modifier.Node node$iv$iv$iv = this_$iv$iv.getHead$ui_release();
            while (true) {
                if (node$iv$iv$iv == null) {
                    int i = type$iv;
                    break;
                }
                Modifier.Node it$iv$iv = node$iv$iv$iv;
                if ((it$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                    MutableVector mutableVector2 = null;
                    Modifier.Node this_$iv$iv$iv = it$iv$iv;
                    while (this_$iv$iv$iv != null) {
                        if (this_$iv$iv$iv instanceof LayoutModifierNode) {
                            c3 = 2;
                            OwnedLayer layer = DelegatableNodeKt.m6502requireCoordinator64DMado((LayoutModifierNode) this_$iv$iv$iv, NodeKind.m6666constructorimpl(2)).getLayer();
                            if (layer != null) {
                                layer.invalidate();
                            }
                            this_$iv3 = this_$iv;
                            type$iv3 = type$iv;
                        } else {
                            c3 = c;
                            if (!((this_$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0) || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                                this_$iv3 = this_$iv;
                                type$iv3 = type$iv;
                            } else {
                                int count$iv$iv2 = 0;
                                Modifier.Node node$iv$iv$iv2 = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                                while (node$iv$iv$iv2 != null) {
                                    Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                    if ((next$iv$iv.getKindSet$ui_release() & type$iv) != 0) {
                                        count$iv$iv2++;
                                        this_$iv4 = this_$iv;
                                        if (count$iv$iv2 == 1) {
                                            this_$iv$iv$iv = next$iv$iv;
                                            type$iv4 = type$iv;
                                            Modifier.Node node = next$iv$iv;
                                        } else {
                                            if (mutableVector2 == null) {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv4 = type$iv;
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv4 = type$iv;
                                                mutableVector = mutableVector2;
                                            }
                                            MutableVector mutableVector3 = mutableVector;
                                            Modifier.Node theNode$iv$iv = this_$iv$iv$iv;
                                            if (theNode$iv$iv != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(theNode$iv$iv);
                                                }
                                                this_$iv$iv$iv = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(next$iv$iv);
                                            }
                                            mutableVector2 = mutableVector3;
                                            count$iv$iv2 = count$iv$iv;
                                        }
                                    } else {
                                        this_$iv4 = this_$iv;
                                        type$iv4 = type$iv;
                                        Modifier.Node node2 = next$iv$iv;
                                    }
                                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                    this_$iv = this_$iv4;
                                    type$iv = type$iv4;
                                }
                                this_$iv3 = this_$iv;
                                type$iv3 = type$iv;
                                if (count$iv$iv2 == 1) {
                                    c = c3;
                                    this_$iv = this_$iv3;
                                    type$iv = type$iv3;
                                }
                            }
                        }
                        this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector2);
                        c = c3;
                        this_$iv = this_$iv3;
                        type$iv = type$iv3;
                    }
                    this_$iv2 = this_$iv;
                    type$iv2 = type$iv;
                    c2 = c;
                } else {
                    this_$iv2 = this_$iv;
                    type$iv2 = type$iv;
                    c2 = c;
                }
                if ((it$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) == 0) {
                    break;
                }
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                c4 = c2;
                this_$iv5 = this_$iv2;
                type$iv5 = type$iv2;
            }
        } else {
            int i2 = type$iv5;
        }
        MutableVector this_$iv6 = get_children$ui_release();
        int size$iv = this_$iv6.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv6.getContent();
            do {
                ((LayoutNode) content$iv[i$iv]).invalidateSubtree(false);
                i$iv++;
            } while (i$iv < size$iv);
        }
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.layoutDelegate.markLookaheadMeasurePending$ui_release();
    }

    public void forceRemeasure() {
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, false, 1, (Object) null);
        } else {
            requestRemeasure$ui_release$default(this, false, false, 1, (Object) null);
        }
        Constraints lastConstraints = this.layoutDelegate.m6587getLastConstraintsDWUhwKw();
        if (lastConstraints != null) {
            Owner owner2 = this.owner;
            if (owner2 != null) {
                owner2.m6724measureAndLayout0kLqBqw(this, lastConstraints.m7504unboximpl());
                return;
            }
            return;
        }
        Owner owner3 = this.owner;
        if (owner3 != null) {
            Owner.measureAndLayout$default(owner3, false, 1, (Object) null);
        }
    }

    public void onLayoutComplete() {
        int i;
        int type$iv;
        NodeCoordinator this_$iv;
        int i2;
        int type$iv2;
        NodeCoordinator this_$iv2;
        int i3;
        int type$iv3;
        NodeCoordinator this_$iv3;
        int i4;
        int type$iv4;
        MutableVector mutableVector;
        NodeCoordinator this_$iv4 = getInnerCoordinator$ui_release();
        int type$iv5 = NodeKind.m6666constructorimpl(128);
        int i5 = false;
        boolean includeTail$iv$iv = NodeKindKt.m6675getIncludeSelfInTraversalH91voCI(type$iv5);
        NodeCoordinator this_$iv$iv = this_$iv4;
        int mask$iv$iv = type$iv5;
        Modifier.Node stopNode$iv$iv = this_$iv$iv.getTail();
        if (!includeTail$iv$iv && (stopNode$iv$iv = stopNode$iv$iv.getParent$ui_release()) == null) {
            NodeCoordinator nodeCoordinator = this_$iv4;
            int i6 = type$iv5;
            return;
        }
        Modifier.Node node$iv$iv = this_$iv$iv.headNode(includeTail$iv$iv);
        while (node$iv$iv != null) {
            if ((node$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                    MutableVector mutableVector2 = null;
                    Modifier.Node node = node$iv$iv;
                    while (node != null) {
                        if (node instanceof LayoutAwareModifierNode) {
                            this_$iv3 = this_$iv;
                            ((LayoutAwareModifierNode) node).onPlaced(getInnerCoordinator$ui_release());
                            type$iv3 = type$iv;
                            i3 = i;
                        } else {
                            this_$iv3 = this_$iv;
                            Modifier.Node this_$iv$iv$iv = node;
                            int kindSet$ui_release = this_$iv$iv$iv.getKindSet$ui_release() & type$iv;
                            Modifier.Node node2 = this_$iv$iv$iv;
                            int i7 = 1;
                            if ((kindSet$ui_release != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                type$iv3 = type$iv;
                                i3 = i;
                            } else {
                                int count$iv$iv = 0;
                                Modifier.Node node$iv$iv$iv = ((DelegatingNode) node).getDelegate$ui_release();
                                while (node$iv$iv$iv != null) {
                                    Modifier.Node next$iv$iv = node$iv$iv$iv;
                                    if (((next$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? i7 : 0) != 0) {
                                        count$iv$iv++;
                                        if (count$iv$iv == i7) {
                                            node = next$iv$iv;
                                            type$iv4 = type$iv;
                                            i4 = i;
                                            Modifier.Node node3 = next$iv$iv;
                                        } else {
                                            if (mutableVector2 == null) {
                                                type$iv4 = type$iv;
                                                i4 = i;
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                type$iv4 = type$iv;
                                                i4 = i;
                                                mutableVector = mutableVector2;
                                            }
                                            mutableVector2 = mutableVector;
                                            Modifier.Node theNode$iv$iv = node;
                                            if (theNode$iv$iv != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(theNode$iv$iv);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(next$iv$iv);
                                            }
                                        }
                                    } else {
                                        type$iv4 = type$iv;
                                        i4 = i;
                                        Modifier.Node node4 = next$iv$iv;
                                    }
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    type$iv = type$iv4;
                                    i = i4;
                                    i7 = 1;
                                }
                                type$iv3 = type$iv;
                                i3 = i;
                                if (count$iv$iv == 1) {
                                    this_$iv = this_$iv3;
                                    type$iv = type$iv3;
                                    i = i3;
                                }
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector2);
                        this_$iv = this_$iv3;
                        type$iv = type$iv3;
                        i = i3;
                    }
                    this_$iv2 = this_$iv;
                    type$iv2 = type$iv;
                    i2 = i;
                } else {
                    this_$iv2 = this_$iv;
                    type$iv2 = type$iv;
                    i2 = i;
                }
                if (node$iv$iv != stopNode$iv$iv) {
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    this_$iv4 = this_$iv2;
                    type$iv5 = type$iv2;
                    i5 = i2;
                } else {
                    return;
                }
            } else {
                int i8 = type$iv;
                int i9 = i;
                return;
            }
        }
        int i10 = type$iv;
        int i11 = i;
    }

    public final void forEachCoordinator$ui_release(Function1<? super LayoutModifierNodeCoordinator, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        NodeCoordinator inner = getInnerCoordinator$ui_release();
        for (NodeCoordinator coordinator = getOuterCoordinator$ui_release(); coordinator != inner; coordinator = ((LayoutModifierNodeCoordinator) coordinator).getWrapped$ui_release()) {
            Intrinsics.checkNotNull(coordinator, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            block.invoke((LayoutModifierNodeCoordinator) coordinator);
        }
    }

    public final void forEachCoordinatorIncludingInner$ui_release(Function1<? super NodeCoordinator, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        NodeCoordinator delegate = getOuterCoordinator$ui_release();
        NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
        while (!Intrinsics.areEqual((Object) delegate, (Object) wrapped$ui_release) && delegate != null) {
            block.invoke(delegate);
            delegate = delegate.getWrapped$ui_release();
        }
    }

    private final boolean shouldInvalidateParentLayer() {
        if (this.nodes.m6616hasH91voCI$ui_release(NodeKind.m6666constructorimpl(4)) && !this.nodes.m6616hasH91voCI$ui_release(NodeKind.m6666constructorimpl(2))) {
            return true;
        }
        for (Modifier.Node node$iv = this.nodes.getHead$ui_release(); node$iv != null; node$iv = node$iv.getChild$ui_release()) {
            Modifier.Node it = node$iv;
            boolean z = false;
            if (((it.getKindSet$ui_release() & NodeKind.m6666constructorimpl(2)) != 0 ? 1 : 0) != 0 && DelegatableNodeKt.m6502requireCoordinator64DMado(it, NodeKind.m6666constructorimpl(2)).getLayer() != null) {
                return false;
            }
            if ((it.getKindSet$ui_release() & NodeKind.m6666constructorimpl(4)) != 0) {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return true;
    }

    public final void clearSubtreeIntrinsicsUsage$ui_release() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                if (it.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                    it.clearSubtreeIntrinsicsUsage$ui_release();
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                if (it.intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                    it.clearSubtreePlacementIntrinsicsUsage();
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
    }

    public final void resetSubtreeIntrinsicsUsage$ui_release() {
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                UsageByParent usageByParent = it.previousIntrinsicsUsageByParent;
                it.intrinsicsUsageByParent = usageByParent;
                if (usageByParent != UsageByParent.NotUsed) {
                    it.resetSubtreeIntrinsicsUsage$ui_release();
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
    }

    public LayoutInfo getParentInfo() {
        return getParent$ui_release();
    }

    public void onReuse() {
        if (isAttached()) {
            AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
            if (androidViewHolder != null) {
                androidViewHolder.onReuse();
            }
            if (this.deactivated) {
                this.deactivated = false;
            } else {
                resetModifierState();
            }
            setSemanticsId(SemanticsModifierKt.generateSemanticsId());
            this.nodes.markAsAttached();
            this.nodes.runAttachLifecycle();
            return;
        }
        throw new IllegalArgumentException("onReuse is only expected on attached node".toString());
    }

    public void onDeactivate() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onDeactivate();
        }
        this.deactivated = true;
        resetModifierState();
    }

    public void onRelease() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onRelease();
        }
        NodeCoordinator delegate$iv = getOuterCoordinator$ui_release();
        NodeCoordinator final$iv = getInnerCoordinator$ui_release().getWrapped$ui_release();
        while (!Intrinsics.areEqual((Object) delegate$iv, (Object) final$iv) && delegate$iv != null) {
            delegate$iv.onRelease();
            delegate$iv = delegate$iv.getWrapped$ui_release();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$Companion;", "", "()V", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "getConstructor$ui_release", "()Lkotlin/jvm/functions/Function0;", "DummyViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getDummyViewConfiguration$ui_release", "()Landroidx/compose/ui/platform/ViewConfiguration;", "ErrorMeasurePolicy", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "NotPlacedPlaceOrder", "", "ZComparator", "Ljava/util/Comparator;", "getZComparator$ui_release", "()Ljava/util/Comparator;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function0<LayoutNode> getConstructor$ui_release() {
            return LayoutNode.Constructor;
        }

        public final ViewConfiguration getDummyViewConfiguration$ui_release() {
            return LayoutNode.DummyViewConfiguration;
        }

        public final Comparator<LayoutNode> getZComparator$ui_release() {
            return LayoutNode.ZComparator;
        }
    }

    /* access modifiers changed from: private */
    public static final int ZComparator$lambda$38(LayoutNode node1, LayoutNode node2) {
        if (node1.getZIndex() == node2.getZIndex()) {
            return Intrinsics.compare(node1.getPlaceOrder$ui_release(), node2.getPlaceOrder$ui_release());
        }
        return Float.compare(node1.getZIndex(), node2.getZIndex());
    }
}

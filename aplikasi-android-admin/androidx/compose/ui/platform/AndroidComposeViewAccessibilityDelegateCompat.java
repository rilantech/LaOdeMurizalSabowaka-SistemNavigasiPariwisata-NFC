package androidx.compose.ui.platform;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R;
import androidx.compose.ui.TempListUtilsKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AccessibilityIterators;
import androidx.compose.ui.platform.accessibility.CollectionInfoKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.platform.coreshims.ViewStructureCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.text.platform.URLSpanCache;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1 = {"\u0000â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00022\u00020\u0001:\u000e\u0002\u0002\u0002\u0002\u0002\u0002\u0002B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010|\u001a\u00020\u001e2\u0006\u0010}\u001a\u00020\f2\u0006\u0010~\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00062\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0013\u0010\u0001\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\f2\t\u0010\u0001\u001a\u0004\u0018\u00010!H\u0002J\u0012\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\fH\u0002J4\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\f2\b\u0010\u0001\u001a\u00030\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JC\u0010\u0001\u001a\u00020\u000e2\r\u00102\u001a\t\u0012\u0004\u0012\u0002040\u00012\u0007\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\f2\b\u0010\u0001\u001a\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0001\u001a\u00020\u001eH\u0002J\u0011\u0010\u0001\u001a\u00020\u000e2\u0006\u0010}\u001a\u00020\fH\u0002J!\u0010\u0001\u001a\u00030\u00012\u0006\u0010}\u001a\u00020\f2\u0007\u0010\u0001\u001a\u00020\fH\u0001¢\u0006\u0003\b\u0001J\u0013\u0010\u0001\u001a\u0004\u0018\u000102\u0006\u0010}\u001a\u00020\fH\u0002JD\u0010\u0001\u001a\u00030\u00012\u0006\u0010}\u001a\u00020\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0003\u0010\u0001J\u0011\u0010 \u0001\u001a\u00020\u000e2\b\u0010¡\u0001\u001a\u00030¢\u0001J\u0013\u0010£\u0001\u001a\u00020^2\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0016J\u0013\u0010¦\u0001\u001a\u00020\f2\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u0013\u0010©\u0001\u001a\u00020\f2\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u0013\u0010ª\u0001\u001a\u00020\u000e2\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u0015\u0010«\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u0016\u0010¬\u0001\u001a\u0005\u0018\u00010­\u00012\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u0017\u0010®\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0002J!\u0010¯\u0001\u001a\u0005\u0018\u00010°\u00012\n\u0010§\u0001\u001a\u0005\u0018\u00010¨\u00012\u0007\u0010±\u0001\u001a\u00020\fH\u0002J#\u0010²\u0001\u001a\u00020\f2\b\u0010³\u0001\u001a\u00030´\u00012\b\u0010µ\u0001\u001a\u00030´\u0001H\u0001¢\u0006\u0003\b¶\u0001J\u0011\u0010·\u0001\u001a\u00020\u000e2\u0006\u0010}\u001a\u00020\fH\u0002J\u0013\u0010¸\u0001\u001a\u00020\u000e2\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u0013\u0010¹\u0001\u001a\u00020\u000e2\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\t\u0010º\u0001\u001a\u00020\u001eH\u0002J\u0012\u0010»\u0001\u001a\u00020\u001e2\u0007\u0010¼\u0001\u001a\u00020rH\u0002J\u0013\u0010½\u0001\u001a\u00020\u001e2\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u0018\u0010¾\u0001\u001a\u00020\u001e2\u0007\u0010¼\u0001\u001a\u00020rH\u0000¢\u0006\u0003\b¿\u0001J\u000f\u0010À\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0003\bÁ\u0001J&\u0010Â\u0001\u001a\u00020\u000e2\u0006\u0010}\u001a\u00020\f2\u0007\u0010Ã\u0001\u001a\u00020\f2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J$\u0010Ä\u0001\u001a\u00020\u001e2\u0006\u0010}\u001a\u00020\f2\u0007\u0010~\u001a\u00030Å\u00012\b\u0010Æ\u0001\u001a\u00030¨\u0001H\u0007J!\u0010Ç\u0001\u001a\u00020\u000e2\u0007\u0010È\u0001\u001a\u00020\f2\r\u0010É\u0001\u001a\b\u0012\u0004\u0012\u00020l0>H\u0002J\u0011\u0010Ê\u0001\u001a\u00020\u000e2\u0006\u0010}\u001a\u00020\fH\u0002J&\u0010Ë\u0001\u001a\u0016\u0012\u0005\u0012\u00030¨\u00010Ì\u0001j\n\u0012\u0005\u0012\u00030¨\u0001`Í\u00012\u0007\u0010Î\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010Ï\u0001\u001a\u00020\f2\u0007\u0010È\u0001\u001a\u00020\fH\u0002J\u001c\u0010Ð\u0001\u001a\u00020\u001e2\b\u0010Ñ\u0001\u001a\u00030¨\u00012\u0007\u0010Ò\u0001\u001a\u00020dH\u0002J\"\u0010Ó\u0001\u001a\u00020\u001e2\b\u0010Ñ\u0001\u001a\u00030¨\u00012\u0007\u0010Ò\u0001\u001a\u00020dH\u0001¢\u0006\u0003\bÔ\u0001J\u001b\u0010Õ\u0001\u001a\u00020\u001e2\u0007\u0010È\u0001\u001a\u00020\f2\u0007\u0010Ö\u0001\u001a\u00020\u0006H\u0002J\u0013\u0010×\u0001\u001a\u00020\u000e2\b\u0010¡\u0001\u001a\u00030\u0001H\u0002J@\u0010Ø\u0001\u001a\u00020\u000e2\u0006\u0010}\u001a\u00020\f2\u0007\u0010\u0001\u001a\u00020\f2\u000b\b\u0002\u0010Ù\u0001\u001a\u0004\u0018\u00010\f2\u0011\b\u0002\u0010Ú\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010>H\u0002¢\u0006\u0003\u0010Û\u0001J&\u0010Ü\u0001\u001a\u00020\u001e2\u0007\u0010Ý\u0001\u001a\u00020\f2\u0007\u0010Ù\u0001\u001a\u00020\f2\t\u0010Þ\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010ß\u0001\u001a\u00020\u001e2\u0007\u0010Ý\u0001\u001a\u00020\fH\u0002J\u0012\u0010à\u0001\u001a\u00020\u001e2\u0007\u0010á\u0001\u001a\u00020lH\u0002J$\u0010â\u0001\u001a\u00020\u001e2\u0013\u0010ã\u0001\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020403H\u0001¢\u0006\u0003\bä\u0001J!\u0010å\u0001\u001a\u00020\u001e2\u0007\u0010¼\u0001\u001a\u00020r2\r\u0010æ\u0001\u001a\b\u0012\u0004\u0012\u00020\f0%H\u0002J.\u0010ç\u0001\u001a\u00020\u000e2\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010è\u0001\u001a\u00020\f2\u0007\u0010é\u0001\u001a\u00020\f2\u0007\u0010ê\u0001\u001a\u00020\u000eH\u0002J\u001c\u0010ë\u0001\u001a\u00020\u001e2\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010~\u001a\u00030Å\u0001H\u0002J\u001c\u0010ì\u0001\u001a\u00020\u001e2\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010~\u001a\u00030Å\u0001H\u0002J\u001c\u0010í\u0001\u001a\u00020\u001e2\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010~\u001a\u00030Å\u0001H\u0002J\u001c\u0010î\u0001\u001a\u00020\u001e2\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010~\u001a\u00030Å\u0001H\u0002J\t\u0010ï\u0001\u001a\u00020\u001eH\u0002JG\u0010ð\u0001\u001a\t\u0012\u0005\u0012\u00030¨\u00010;2\u0007\u0010Î\u0001\u001a\u00020\u000e2\u000e\u0010ñ\u0001\u001a\t\u0012\u0005\u0012\u00030¨\u00010;2\u001c\b\u0002\u0010ò\u0001\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¨\u00010;0cH\u0002J)\u0010ó\u0001\u001a\t\u0012\u0005\u0012\u00030¨\u00010;2\u0007\u0010Î\u0001\u001a\u00020\u000e2\u000e\u0010ô\u0001\u001a\t\u0012\u0005\u0012\u00030¨\u00010;H\u0002J\"\u0010õ\u0001\u001a\u0005\u0018\u00010ö\u00012\n\u0010÷\u0001\u001a\u0005\u0018\u00010¨\u00012\b\u0010ø\u0001\u001a\u00030ù\u0001H\u0002J.\u0010ú\u0001\u001a\u00020\u000e2\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010±\u0001\u001a\u00020\f2\u0007\u0010û\u0001\u001a\u00020\u000e2\u0007\u0010ü\u0001\u001a\u00020\u000eH\u0002J4\u0010ý\u0001\u001a\u0005\u0018\u0001Hþ\u0001\"\t\b\u0000\u0010þ\u0001*\u00020\u001b2\n\u0010\u0001\u001a\u0005\u0018\u0001Hþ\u00012\t\b\u0001\u0010ÿ\u0001\u001a\u00020\fH\u0002¢\u0006\u0003\u0010\u0002J\u0011\u0010\u0002\u001a\u00020\u001e2\u0006\u0010}\u001a\u00020\fH\u0002J\t\u0010\u0002\u001a\u00020\u001eH\u0002J\u0010\u0010\u0002\u001a\u0004\u0018\u00010-*\u00030¥\u0001H\u0002J\u0011\u0010\u0002\u001a\u0005\u0018\u00010\u0002*\u00030\u0002H\u0002J\u0010\u0010\u0002\u001a\u0004\u0018\u00010!*\u00030¨\u0001H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u00148\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u001aX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0004¢\u0006\u0002\n\u0000R \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020!0 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0%X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0010\"\u0004\b+\u0010\u0012R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00102\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u000204038@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R2\u0010:\u001a&\u0012\f\u0012\n =*\u0004\u0018\u00010<0< =*\u0012\u0012\f\u0012\n =*\u0004\u0018\u00010<0<\u0018\u00010>0;X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010?\u001a\u00020@8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010\u0016\u001a\u0004\bB\u0010CR\u000e\u0010D\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR6\u0010L\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0Mj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR6\u0010S\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0Mj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010P\"\u0004\bU\u0010RR\u001a\u0010V\u001a\u00020\u000e8@X\u0004¢\u0006\f\u0012\u0004\bW\u0010\u0016\u001a\u0004\bX\u0010\u0010R\u0014\u0010Y\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\bY\u0010\u0010R\u0014\u0010Z\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010\u0010R\u0014\u0010[\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u0010R \u0010\\\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f030\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020\f0%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u000e¢\u0006\u0002\n\u0000R0\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020d0c8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\be\u0010\u0016\u001a\u0004\bf\u00106\"\u0004\bg\u00108R\u000e\u0010h\u001a\u00020dX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010i\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010jR\u0014\u0010k\u001a\b\u0012\u0004\u0012\u00020l0;X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010o\u001a\u000e\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020\u001e0pX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010q\u001a\b\u0012\u0004\u0012\u00020r0%X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010s\u001a\u00020t8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bu\u0010\u0016\u001a\u0004\bv\u0010wR\u000e\u0010x\u001a\u00020yX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0002"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "EXTRA_DATA_TEST_TRAVERSALAFTER_VAL", "", "getEXTRA_DATA_TEST_TRAVERSALAFTER_VAL$ui_release", "()Ljava/lang/String;", "EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL", "getEXTRA_DATA_TEST_TRAVERSALBEFORE_VAL$ui_release", "accessibilityCursorPosition", "", "accessibilityForceEnabledForTesting", "", "getAccessibilityForceEnabledForTesting$ui_release", "()Z", "setAccessibilityForceEnabledForTesting$ui_release", "(Z)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "getAccessibilityManager$ui_release$annotations", "()V", "getAccessibilityManager$ui_release", "()Landroid/view/accessibility/AccessibilityManager;", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "bufferedContentCaptureAppearedNodes", "Landroidx/collection/ArrayMap;", "Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;", "getBufferedContentCaptureAppearedNodes$ui_release", "()Landroidx/collection/ArrayMap;", "bufferedContentCaptureDisappearedNodes", "Landroidx/collection/ArraySet;", "getBufferedContentCaptureDisappearedNodes$ui_release", "()Landroidx/collection/ArraySet;", "checkingForSemanticsChanges", "contentCaptureForceEnabledForTesting", "getContentCaptureForceEnabledForTesting$ui_release", "setContentCaptureForceEnabledForTesting$ui_release", "contentCaptureSession", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "getContentCaptureSession$ui_release", "()Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "setContentCaptureSession$ui_release", "(Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;)V", "currentSemanticsNodes", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes$ui_release", "()Ljava/util/Map;", "setCurrentSemanticsNodes$ui_release", "(Ljava/util/Map;)V", "currentSemanticsNodesInvalidated", "enabledServices", "", "Landroid/accessibilityservice/AccessibilityServiceInfo;", "kotlin.jvm.PlatformType", "", "enabledStateListener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "getEnabledStateListener$ui_release$annotations", "getEnabledStateListener$ui_release", "()Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "focusedVirtualViewId", "handler", "Landroid/os/Handler;", "hoveredVirtualViewId", "getHoveredVirtualViewId$ui_release", "()I", "setHoveredVirtualViewId$ui_release", "(I)V", "idToAfterMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getIdToAfterMap$ui_release", "()Ljava/util/HashMap;", "setIdToAfterMap$ui_release", "(Ljava/util/HashMap;)V", "idToBeforeMap", "getIdToBeforeMap$ui_release", "setIdToBeforeMap$ui_release", "isEnabled", "isEnabled$ui_release$annotations", "isEnabled$ui_release", "isEnabledForAccessibility", "isEnabledForContentCapture", "isTouchExplorationEnabled", "labelToActionId", "nodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "paneDisplayed", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "previousSemanticsNodes", "", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "getPreviousSemanticsNodes$ui_release$annotations", "getPreviousSemanticsNodes$ui_release", "setPreviousSemanticsNodes$ui_release", "previousSemanticsRoot", "previousTraversedNode", "Ljava/lang/Integer;", "scrollObservationScopes", "Landroidx/compose/ui/platform/ScrollObservationScope;", "semanticsChangeChecker", "Ljava/lang/Runnable;", "sendScrollEventIfNeededLambda", "Lkotlin/Function1;", "subtreeChangedLayoutNodes", "Landroidx/compose/ui/node/LayoutNode;", "touchExplorationStateListener", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "getTouchExplorationStateListener$ui_release$annotations", "getTouchExplorationStateListener$ui_release", "()Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "arguments", "Landroid/os/Bundle;", "boundsUpdatesEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bufferContentCaptureViewAppeared", "virtualId", "viewStructure", "bufferContentCaptureViewDisappeared", "canScroll", "vertical", "direction", "position", "Landroidx/compose/ui/geometry/Offset;", "canScroll-0AR0LA0$ui_release", "(ZIJ)Z", "", "canScroll-moWRBKg$ui_release", "(Ljava/util/Collection;ZIJ)Z", "checkForSemanticsChanges", "clearAccessibilityFocus", "createEvent", "Landroid/view/accessibility/AccessibilityEvent;", "eventType", "createEvent$ui_release", "createNodeInfo", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;)Landroid/view/accessibility/AccessibilityEvent;", "dispatchHoverEvent", "event", "Landroid/view/MotionEvent;", "getAccessibilityNodeProvider", "host", "Landroid/view/View;", "getAccessibilitySelectionEnd", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "getAccessibilitySelectionStart", "getInfoIsCheckable", "getInfoStateDescriptionOrNull", "getInfoText", "Landroid/text/SpannableString;", "getIterableTextForAccessibility", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "granularity", "hitTestSemanticsAt", "x", "", "y", "hitTestSemanticsAt$ui_release", "isAccessibilityFocused", "isAccessibilitySelectionExtendable", "isScreenReaderFocusable", "notifyContentCaptureChanges", "notifySubtreeAccessibilityStateChangedIfNeeded", "layoutNode", "notifySubtreeAppeared", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "performActionHelper", "action", "populateAccessibilityNodeInfoProperties", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "registerScrollingId", "id", "oldScrollObservationScopes", "requestAccessibilityFocus", "semanticComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "layoutIsRtl", "semanticsNodeIdToAccessibilityVirtualNodeId", "sendAccessibilitySemanticsStructureChangeEvents", "newNode", "oldNode", "sendContentCaptureSemanticsStructureChangeEvents", "sendContentCaptureSemanticsStructureChangeEvents$ui_release", "sendContentCaptureTextUpdateEvent", "newText", "sendEvent", "sendEventForVirtualView", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendPendingTextTraversedAtGranularityEvent", "sendScrollEventIfNeeded", "scrollObservationScope", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "sendSemanticsPropertyChangeEvents$ui_release", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "setAccessibilitySelection", "start", "end", "traversalMode", "setContentInvalid", "setIsCheckable", "setStateDescription", "setText", "setTraversalValues", "sortByGeometryGroupings", "parentListToSort", "containerChildrenMapping", "subtreeSortedByGeometryGrouping", "listToSort", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "Landroidx/compose/ui/geometry/Rect;", "traverseAtGranularity", "forward", "extendSelection", "trimToSize", "T", "size", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "updateHoveredVirtualView", "updateSemanticsNodesCopyAndPanes", "getContentCaptureSessionCompat", "getTextForTextField", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "toViewStructure", "Api24Impl", "Api28Impl", "Api29Impl", "Companion", "MyNodeProvider", "PendingTextTraversedEvent", "SemanticsNodeCopy", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    private static final int[] AccessibilityActionsResourceIds = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    public static final String ClassName = "android.view.View";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ExtraDataIdKey = "androidx.compose.ui.semantics.id";
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final long SendRecurringAccessibilityEventsIntervalMillis = 100;
    public static final String TextClassName = "android.widget.TextView";
    public static final String TextFieldClassName = "android.widget.EditText";
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private final String EXTRA_DATA_TEST_TRAVERSALAFTER_VAL;
    private final String EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL;
    private int accessibilityCursorPosition;
    private boolean accessibilityForceEnabledForTesting;
    private final AccessibilityManager accessibilityManager;
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    private final Channel<Unit> boundsUpdateChannel;
    private final ArrayMap<Integer, ViewStructureCompat> bufferedContentCaptureAppearedNodes;
    private final ArraySet<Integer> bufferedContentCaptureDisappearedNodes;
    private boolean checkingForSemanticsChanges;
    private boolean contentCaptureForceEnabledForTesting;
    private ContentCaptureSessionCompat contentCaptureSession;
    private Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private List<AccessibilityServiceInfo> enabledServices;
    private final AccessibilityManager.AccessibilityStateChangeListener enabledStateListener;
    private int focusedVirtualViewId;
    /* access modifiers changed from: private */
    public final Handler handler;
    private int hoveredVirtualViewId = Integer.MIN_VALUE;
    private HashMap<Integer, Integer> idToAfterMap;
    private HashMap<Integer, Integer> idToBeforeMap;
    private SparseArrayCompat<Map<CharSequence, Integer>> labelToActionId;
    private AccessibilityNodeProviderCompat nodeProvider;
    private ArraySet<Integer> paneDisplayed;
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    private Map<Integer, SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private final List<ScrollObservationScope> scrollObservationScopes;
    /* access modifiers changed from: private */
    public final Runnable semanticsChangeChecker;
    private final Function1<ScrollObservationScope, Unit> sendScrollEventIfNeededLambda;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateListener;
    private final URLSpanCache urlSpanCache;
    private final AndroidComposeView view;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getAccessibilityManager$ui_release$annotations() {
    }

    public static /* synthetic */ void getEnabledStateListener$ui_release$annotations() {
    }

    public static /* synthetic */ void getPreviousSemanticsNodes$ui_release$annotations() {
    }

    public static /* synthetic */ void getTouchExplorationStateListener$ui_release$annotations() {
    }

    public static /* synthetic */ void isEnabled$ui_release$annotations() {
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Companion;", "", "()V", "AccessibilityActionsResourceIds", "", "AccessibilityCursorPositionUndefined", "", "AccessibilitySliderStepsCount", "ClassName", "", "ExtraDataIdKey", "ExtraDataTestTagKey", "InvalidId", "LogTag", "ParcelSafeTextLength", "SendRecurringAccessibilityEventsIntervalMillis", "", "TextClassName", "TextFieldClassName", "TextTraversedEventTimeoutMillis", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.view = view2;
        Object systemService = view2.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        AccessibilityManager accessibilityManager2 = (AccessibilityManager) systemService;
        this.accessibilityManager = accessibilityManager2;
        this.enabledStateListener = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0(this);
        this.touchExplorationStateListener = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1(this);
        this.enabledServices = accessibilityManager2.getEnabledAccessibilityServiceList(-1);
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new AccessibilityNodeProviderCompat(new MyNodeProvider());
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.actionIdToLabel = new SparseArrayCompat<>();
        this.labelToActionId = new SparseArrayCompat<>();
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>();
        this.boundsUpdateChannel = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.currentSemanticsNodesInvalidated = true;
        this.bufferedContentCaptureAppearedNodes = new ArrayMap<>();
        this.bufferedContentCaptureDisappearedNodes = new ArraySet<>();
        this.currentSemanticsNodes = MapsKt.emptyMap();
        this.paneDisplayed = new ArraySet<>();
        this.idToBeforeMap = new HashMap<>();
        this.idToAfterMap = new HashMap<>();
        this.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.urlSpanCache = new URLSpanCache();
        this.previousSemanticsNodes = new LinkedHashMap();
        this.previousSemanticsRoot = new SemanticsNodeCopy(view2.getSemanticsOwner().getUnmergedRootSemanticsNode(), MapsKt.emptyMap());
        view2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) {
            final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

            {
                this.this$0 = $receiver;
            }

            public void onViewAttachedToWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.this$0.getAccessibilityManager$ui_release().addAccessibilityStateChangeListener(this.this$0.getEnabledStateListener$ui_release());
                this.this$0.getAccessibilityManager$ui_release().addTouchExplorationStateChangeListener(this.this$0.getTouchExplorationStateListener$ui_release());
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.this$0;
                androidComposeViewAccessibilityDelegateCompat.setContentCaptureSession$ui_release(androidComposeViewAccessibilityDelegateCompat.getContentCaptureSessionCompat(view));
            }

            public void onViewDetachedFromWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.this$0.handler.removeCallbacks(this.this$0.semanticsChangeChecker);
                this.this$0.getAccessibilityManager$ui_release().removeAccessibilityStateChangeListener(this.this$0.getEnabledStateListener$ui_release());
                this.this$0.getAccessibilityManager$ui_release().removeTouchExplorationStateChangeListener(this.this$0.getTouchExplorationStateListener$ui_release());
                this.this$0.setContentCaptureSession$ui_release((ContentCaptureSessionCompat) null);
            }
        });
        this.semanticsChangeChecker = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2(this);
        this.scrollObservationScopes = new ArrayList();
        this.sendScrollEventIfNeededLambda = new AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeededLambda$1(this);
    }

    public final int getHoveredVirtualViewId$ui_release() {
        return this.hoveredVirtualViewId;
    }

    public final void setHoveredVirtualViewId$ui_release(int i) {
        this.hoveredVirtualViewId = i;
    }

    public final AccessibilityManager getAccessibilityManager$ui_release() {
        return this.accessibilityManager;
    }

    public final boolean getAccessibilityForceEnabledForTesting$ui_release() {
        return this.accessibilityForceEnabledForTesting;
    }

    public final void setAccessibilityForceEnabledForTesting$ui_release(boolean z) {
        this.accessibilityForceEnabledForTesting = z;
    }

    public final AccessibilityManager.AccessibilityStateChangeListener getEnabledStateListener$ui_release() {
        return this.enabledStateListener;
    }

    /* access modifiers changed from: private */
    public static final void enabledStateListener$lambda$0(AndroidComposeViewAccessibilityDelegateCompat this$0, boolean enabled) {
        List<AccessibilityServiceInfo> list;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (enabled) {
            list = this$0.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        } else {
            list = CollectionsKt.emptyList();
        }
        this$0.enabledServices = list;
    }

    public final AccessibilityManager.TouchExplorationStateChangeListener getTouchExplorationStateListener$ui_release() {
        return this.touchExplorationStateListener;
    }

    /* access modifiers changed from: private */
    public static final void touchExplorationStateListener$lambda$1(AndroidComposeViewAccessibilityDelegateCompat this$0, boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.enabledServices = this$0.accessibilityManager.getEnabledAccessibilityServiceList(-1);
    }

    public final boolean isEnabled$ui_release() {
        return isEnabledForAccessibility() || isEnabledForContentCapture();
    }

    private final boolean isEnabledForAccessibility() {
        if (this.accessibilityForceEnabledForTesting) {
            return true;
        }
        if (this.accessibilityManager.isEnabled()) {
            List<AccessibilityServiceInfo> list = this.enabledServices;
            Intrinsics.checkNotNullExpressionValue(list, "enabledServices");
            if (!list.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private final boolean isEnabledForContentCapture() {
        return this.contentCaptureForceEnabledForTesting;
    }

    private final boolean isTouchExplorationEnabled() {
        return this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled());
    }

    public final boolean getContentCaptureForceEnabledForTesting$ui_release() {
        return this.contentCaptureForceEnabledForTesting;
    }

    public final void setContentCaptureForceEnabledForTesting$ui_release(boolean z) {
        this.contentCaptureForceEnabledForTesting = z;
    }

    public final ContentCaptureSessionCompat getContentCaptureSession$ui_release() {
        return this.contentCaptureSession;
    }

    public final void setContentCaptureSession$ui_release(ContentCaptureSessionCompat contentCaptureSessionCompat) {
        this.contentCaptureSession = contentCaptureSessionCompat;
    }

    public final ArrayMap<Integer, ViewStructureCompat> getBufferedContentCaptureAppearedNodes$ui_release() {
        return this.bufferedContentCaptureAppearedNodes;
    }

    public final ArraySet<Integer> getBufferedContentCaptureDisappearedNodes$ui_release() {
        return this.bufferedContentCaptureDisappearedNodes;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getAction", "()I", "getFromIndex", "getGranularity", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getToIndex", "getTraverseTime", "()J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode node2, int action2, int granularity2, int fromIndex2, int toIndex2, long traverseTime2) {
            Intrinsics.checkNotNullParameter(node2, "node");
            this.node = node2;
            this.action = action2;
            this.granularity = granularity2;
            this.fromIndex = fromIndex2;
            this.toIndex = toIndex2;
            this.traverseTime = traverseTime2;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    public final void setCurrentSemanticsNodes$ui_release(Map<Integer, SemanticsNodeWithAdjustedBounds> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.currentSemanticsNodes = map;
    }

    public final Map<Integer, SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes$ui_release() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getAllUncoveredSemanticsNodesToMap(this.view.getSemanticsOwner());
            setTraversalValues();
        }
        return this.currentSemanticsNodes;
    }

    public final HashMap<Integer, Integer> getIdToBeforeMap$ui_release() {
        return this.idToBeforeMap;
    }

    public final void setIdToBeforeMap$ui_release(HashMap<Integer, Integer> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.idToBeforeMap = hashMap;
    }

    public final HashMap<Integer, Integer> getIdToAfterMap$ui_release() {
        return this.idToAfterMap;
    }

    public final void setIdToAfterMap$ui_release(HashMap<Integer, Integer> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.idToAfterMap = hashMap;
    }

    public final String getEXTRA_DATA_TEST_TRAVERSALBEFORE_VAL$ui_release() {
        return this.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL;
    }

    public final String getEXTRA_DATA_TEST_TRAVERSALAFTER_VAL$ui_release() {
        return this.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "currentSemanticsNodes", "", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "(Landroidx/compose/ui/semantics/SemanticsNode;Ljava/util/Map;)V", "children", "", "getChildren", "()Ljava/util/Set;", "getSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUnmergedConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "hasPaneTitle", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public static final class SemanticsNodeCopy {
        private final Set<Integer> children = new LinkedHashSet();
        private final SemanticsNode semanticsNode;
        private final SemanticsConfiguration unmergedConfig;

        public SemanticsNodeCopy(SemanticsNode semanticsNode2, Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes) {
            Intrinsics.checkNotNullParameter(semanticsNode2, "semanticsNode");
            Intrinsics.checkNotNullParameter(currentSemanticsNodes, "currentSemanticsNodes");
            this.semanticsNode = semanticsNode2;
            this.unmergedConfig = semanticsNode2.getUnmergedConfig$ui_release();
            List $this$fastForEach$iv = semanticsNode2.getReplacedChildren$ui_release();
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                SemanticsNode child = $this$fastForEach$iv.get(index$iv);
                if (currentSemanticsNodes.containsKey(Integer.valueOf(child.getId()))) {
                    this.children.add(Integer.valueOf(child.getId()));
                }
            }
        }

        public final SemanticsNode getSemanticsNode() {
            return this.semanticsNode;
        }

        public final SemanticsConfiguration getUnmergedConfig() {
            return this.unmergedConfig;
        }

        public final Set<Integer> getChildren() {
            return this.children;
        }

        public final boolean hasPaneTitle() {
            return this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getPaneTitle());
        }
    }

    public final Map<Integer, SemanticsNodeCopy> getPreviousSemanticsNodes$ui_release() {
        return this.previousSemanticsNodes;
    }

    public final void setPreviousSemanticsNodes$ui_release(Map<Integer, SemanticsNodeCopy> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.previousSemanticsNodes = map;
    }

    /* renamed from: canScroll-0AR0LA0$ui_release  reason: not valid java name */
    public final boolean m6764canScroll0AR0LA0$ui_release(boolean vertical, int direction, long position) {
        if (!Intrinsics.areEqual((Object) Looper.getMainLooper().getThread(), (Object) Thread.currentThread())) {
            return false;
        }
        return m6765canScrollmoWRBKg$ui_release(getCurrentSemanticsNodes$ui_release().values(), vertical, direction, position);
    }

    /* renamed from: canScroll-moWRBKg$ui_release  reason: not valid java name */
    public final boolean m6765canScrollmoWRBKg$ui_release(Collection<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes2, boolean vertical, int direction, long position) {
        SemanticsPropertyKey scrollRangeProperty;
        boolean z;
        Collection<SemanticsNodeWithAdjustedBounds> collection = currentSemanticsNodes2;
        boolean z2 = vertical;
        int i = direction;
        long j = position;
        Intrinsics.checkNotNullParameter(collection, "currentSemanticsNodes");
        if (Offset.m4710equalsimpl0(j, Offset.Companion.m4728getUnspecifiedF1C5BW0()) || !Offset.m4716isValidimpl(position)) {
            return false;
        }
        if (z2) {
            scrollRangeProperty = SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
        } else if (!z2) {
            scrollRangeProperty = SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Iterable<SemanticsNodeWithAdjustedBounds> $this$any$iv = collection;
        if (((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (SemanticsNodeWithAdjustedBounds node : $this$any$iv) {
            if (!RectHelper_androidKt.toComposeRect(node.getAdjustedBounds()).m4739containsk4lQ0M(j)) {
                z = false;
                continue;
            } else {
                ScrollAxisRange scrollRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(node.getSemanticsNode().getConfig(), scrollRangeProperty);
                if (scrollRange == null) {
                    z = false;
                    continue;
                } else {
                    int actualDirection = scrollRange.getReverseScrolling() ? -i : i;
                    if (i == 0 && scrollRange.getReverseScrolling()) {
                        actualDirection = -1;
                    }
                    if (actualDirection < 0) {
                        if (scrollRange.getValue().invoke().floatValue() > 0.0f) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                    } else if (scrollRange.getValue().invoke().floatValue() < scrollRange.getMaxValue().invoke().floatValue()) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: type inference failed for: r4v16, types: [android.view.ViewParent] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = (r0 = r0.getLifecycleOwner()).getLifecycle();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.accessibility.AccessibilityNodeInfo createNodeInfo(int r15) {
        /*
            r14 = this;
            androidx.compose.ui.platform.AndroidComposeView r0 = r14.view
            androidx.compose.ui.platform.AndroidComposeView$ViewTreeOwners r0 = r0.getViewTreeOwners()
            r1 = 0
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.LifecycleOwner r0 = r0.getLifecycleOwner()
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.Lifecycle$State r0 = r0.getCurrentState()
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.DESTROYED
            if (r0 != r2) goto L_0x0020
            return r1
        L_0x0020:
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r0 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.obtain()
            java.lang.String r2 = "obtain()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.util.Map r2 = r14.getCurrentSemanticsNodes$ui_release()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r15)
            java.lang.Object r2 = r2.get(r3)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r2 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r2
            if (r2 != 0) goto L_0x003b
            return r1
        L_0x003b:
            androidx.compose.ui.semantics.SemanticsNode r3 = r2.getSemanticsNode()
            r4 = -1
            if (r15 != r4) goto L_0x0055
            androidx.compose.ui.platform.AndroidComposeView r4 = r14.view
            android.view.View r4 = (android.view.View) r4
            android.view.ViewParent r4 = androidx.core.view.ViewCompat.getParentForAccessibility(r4)
            boolean r5 = r4 instanceof android.view.View
            if (r5 == 0) goto L_0x0051
            r1 = r4
            android.view.View r1 = (android.view.View) r1
        L_0x0051:
            r0.setParent(r1)
            goto L_0x007e
        L_0x0055:
            androidx.compose.ui.semantics.SemanticsNode r1 = r3.getParent()
            if (r1 == 0) goto L_0x00e8
            androidx.compose.ui.semantics.SemanticsNode r1 = r3.getParent()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getId()
            androidx.compose.ui.platform.AndroidComposeView r4 = r14.view
            androidx.compose.ui.semantics.SemanticsOwner r4 = r4.getSemanticsOwner()
            androidx.compose.ui.semantics.SemanticsNode r4 = r4.getUnmergedRootSemanticsNode()
            int r4 = r4.getId()
            if (r1 != r4) goto L_0x0077
            r1 = -1
        L_0x0077:
            androidx.compose.ui.platform.AndroidComposeView r4 = r14.view
            android.view.View r4 = (android.view.View) r4
            r0.setParent(r4, r1)
        L_0x007e:
            androidx.compose.ui.platform.AndroidComposeView r1 = r14.view
            android.view.View r1 = (android.view.View) r1
            r0.setSource(r1, r15)
            android.graphics.Rect r1 = r2.getAdjustedBounds()
            androidx.compose.ui.platform.AndroidComposeView r4 = r14.view
            int r5 = r1.left
            float r5 = (float) r5
            int r6 = r1.top
            float r6 = (float) r6
            long r5 = androidx.compose.ui.geometry.OffsetKt.Offset(r5, r6)
            long r4 = r4.m6755localToScreenMKHz9U(r5)
            androidx.compose.ui.platform.AndroidComposeView r6 = r14.view
            int r7 = r1.right
            float r7 = (float) r7
            int r8 = r1.bottom
            float r8 = (float) r8
            long r7 = androidx.compose.ui.geometry.OffsetKt.Offset(r7, r8)
            long r6 = r6.m6755localToScreenMKHz9U(r7)
            android.graphics.Rect r8 = new android.graphics.Rect
            float r9 = androidx.compose.ui.geometry.Offset.m4713getXimpl(r4)
            double r9 = (double) r9
            double r9 = java.lang.Math.floor(r9)
            float r9 = (float) r9
            int r9 = (int) r9
            float r10 = androidx.compose.ui.geometry.Offset.m4714getYimpl(r4)
            double r10 = (double) r10
            double r10 = java.lang.Math.floor(r10)
            float r10 = (float) r10
            int r10 = (int) r10
            float r11 = androidx.compose.ui.geometry.Offset.m4713getXimpl(r6)
            double r11 = (double) r11
            double r11 = java.lang.Math.ceil(r11)
            float r11 = (float) r11
            int r11 = (int) r11
            float r12 = androidx.compose.ui.geometry.Offset.m4714getYimpl(r6)
            double r12 = (double) r12
            double r12 = java.lang.Math.ceil(r12)
            float r12 = (float) r12
            int r12 = (int) r12
            r8.<init>(r9, r10, r11, r12)
            r0.setBoundsInScreen(r8)
            r14.populateAccessibilityNodeInfoProperties(r15, r0, r3)
            android.view.accessibility.AccessibilityNodeInfo r8 = r0.unwrap()
            return r8
        L_0x00e8:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "semanticsNode "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r15)
            java.lang.String r5 = " has null parent"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r1.<init>(r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.createNodeInfo(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    private final Comparator<SemanticsNode> semanticComparator(boolean layoutIsRtl) {
        Comparator comparator = ComparisonsKt.compareBy((Function1<? super T, ? extends Comparable<?>>[]) new Function1[]{AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$1.INSTANCE, AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$2.INSTANCE, AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$3.INSTANCE, AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$4.INSTANCE});
        if (layoutIsRtl) {
            comparator = ComparisonsKt.compareBy((Function1<? super T, ? extends Comparable<?>>[]) new Function1[]{AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$1.INSTANCE, AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$2.INSTANCE, AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$3.INSTANCE, AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$4.INSTANCE});
        }
        return new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$2<>(new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1(comparator, LayoutNode.Companion.getZComparator$ui_release()));
    }

    static /* synthetic */ List sortByGeometryGroupings$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z, List list, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = new LinkedHashMap();
        }
        return androidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings(z, list, map);
    }

    private final List<SemanticsNode> sortByGeometryGroupings(boolean layoutIsRtl, List<SemanticsNode> parentListToSort, Map<Integer, List<SemanticsNode>> containerChildrenMapping) {
        List rowGroupings = new ArrayList();
        int entryIndex = 0;
        int lastIndex = CollectionsKt.getLastIndex(parentListToSort);
        if (0 <= lastIndex) {
            while (true) {
                SemanticsNode currEntry = parentListToSort.get(entryIndex);
                if (entryIndex == 0 || !sortByGeometryGroupings$placedEntryRowOverlaps(rowGroupings, currEntry)) {
                    rowGroupings.add(new Pair(currEntry.getBoundsInWindow(), CollectionsKt.mutableListOf(currEntry)));
                }
                if (entryIndex == lastIndex) {
                    break;
                }
                entryIndex++;
            }
        }
        CollectionsKt.sortWith(rowGroupings, ComparisonsKt.compareBy((Function1<? super T, ? extends Comparable<?>>[]) new Function1[]{AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$1.INSTANCE, AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2.INSTANCE}));
        List returnList = new ArrayList();
        List $this$fastForEach$iv = rowGroupings;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Pair row = (Pair) $this$fastForEach$iv.get(index$iv);
            CollectionsKt.sortWith((List) row.getSecond(), semanticComparator(layoutIsRtl));
            returnList.addAll((Collection) row.getSecond());
        }
        CollectionsKt.sortWith(returnList, new AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$$inlined$compareBy$1());
        int i = 0;
        while (i <= CollectionsKt.getLastIndex(returnList)) {
            List containersChildrenList = containerChildrenMapping.get(Integer.valueOf(returnList.get(i).getId()));
            if (containersChildrenList != null) {
                if (!isScreenReaderFocusable(returnList.get(i))) {
                    returnList.remove(i);
                } else {
                    i++;
                }
                returnList.addAll(i, containersChildrenList);
                i += containersChildrenList.size();
            } else {
                i++;
            }
        }
        return returnList;
    }

    private static final boolean sortByGeometryGroupings$placedEntryRowOverlaps(List<Pair<Rect, List<SemanticsNode>>> rowGroupings, SemanticsNode node) {
        float entryTopCoord = node.getBoundsInWindow().getTop();
        float entryBottomCoord = node.getBoundsInWindow().getBottom();
        OpenEndRange entryRange = AndroidComposeViewAccessibilityDelegateCompat_androidKt.rangeUntil(entryTopCoord, entryBottomCoord);
        int currIndex = 0;
        int lastIndex = CollectionsKt.getLastIndex(rowGroupings);
        if (0 > lastIndex) {
            return false;
        }
        while (true) {
            Rect currRect = (Rect) rowGroupings.get(currIndex).getFirst();
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.overlaps(AndroidComposeViewAccessibilityDelegateCompat_androidKt.rangeUntil(currRect.getTop(), currRect.getBottom()), entryRange)) {
                rowGroupings.set(currIndex, new Pair(currRect.intersect(new Rect(0.0f, entryTopCoord, Float.POSITIVE_INFINITY, entryBottomCoord)), rowGroupings.get(currIndex).getSecond()));
                ((List) rowGroupings.get(currIndex).getSecond()).add(node);
                return true;
            } else if (currIndex == lastIndex) {
                return false;
            } else {
                currIndex++;
            }
        }
    }

    private final List<SemanticsNode> subtreeSortedByGeometryGrouping(boolean layoutIsRtl, List<SemanticsNode> listToSort) {
        Map containerMapToChildren = new LinkedHashMap();
        List geometryList = new ArrayList();
        List $this$fastForEach$iv = listToSort;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            subtreeSortedByGeometryGrouping$depthFirstSearch(this, geometryList, containerMapToChildren, layoutIsRtl, $this$fastForEach$iv.get(index$iv));
        }
        return sortByGeometryGroupings(layoutIsRtl, geometryList, containerMapToChildren);
    }

    private static final void subtreeSortedByGeometryGrouping$depthFirstSearch(AndroidComposeViewAccessibilityDelegateCompat this$0, List<SemanticsNode> geometryList, Map<Integer, List<SemanticsNode>> containerMapToChildren, boolean $layoutIsRtl, SemanticsNode currNode) {
        if ((Intrinsics.areEqual((Object) AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTraversalGroup(currNode), (Object) true) || this$0.isScreenReaderFocusable(currNode)) && this$0.getCurrentSemanticsNodes$ui_release().keySet().contains(Integer.valueOf(currNode.getId()))) {
            geometryList.add(currNode);
        }
        if (Intrinsics.areEqual((Object) AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTraversalGroup(currNode), (Object) true)) {
            containerMapToChildren.put(Integer.valueOf(currNode.getId()), this$0.subtreeSortedByGeometryGrouping($layoutIsRtl, CollectionsKt.toMutableList(currNode.getChildren())));
            return;
        }
        List $this$fastForEach$iv = currNode.getChildren();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            subtreeSortedByGeometryGrouping$depthFirstSearch(this$0, geometryList, containerMapToChildren, $layoutIsRtl, $this$fastForEach$iv.get(index$iv));
        }
    }

    private final void setTraversalValues() {
        this.idToBeforeMap.clear();
        this.idToAfterMap.clear();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes$ui_release().get(-1);
        SemanticsNode hostSemanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
        Intrinsics.checkNotNull(hostSemanticsNode);
        List semanticsOrderList = subtreeSortedByGeometryGrouping(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(hostSemanticsNode), CollectionsKt.mutableListOf(hostSemanticsNode));
        int i = 1;
        int lastIndex = CollectionsKt.getLastIndex(semanticsOrderList);
        if (1 <= lastIndex) {
            while (true) {
                int prevId = semanticsOrderList.get(i - 1).getId();
                int currId = semanticsOrderList.get(i).getId();
                this.idToBeforeMap.put(Integer.valueOf(prevId), Integer.valueOf(currId));
                this.idToAfterMap.put(Integer.valueOf(currId), Integer.valueOf(prevId));
                if (i != lastIndex) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final boolean isScreenReaderFocusable(SemanticsNode node) {
        boolean isSpeakingNode = (AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoContentDescriptionOrNull(node) == null && getInfoText(node) == null && getInfoStateDescriptionOrNull(node) == null && !getInfoIsCheckable(node)) ? false : true;
        if (node.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants() || (node.isUnmergedLeafNode$ui_release() && isSpeakingNode)) {
            return true;
        }
        return false;
    }

    public final void populateAccessibilityNodeInfoProperties(int virtualViewId, AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
        AccessibilityAction scrollAction;
        Map oldLabelToActionId;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2;
        int i = virtualViewId;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = info;
        SemanticsNode semanticsNode2 = semanticsNode;
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
        Intrinsics.checkNotNullParameter(semanticsNode2, "semanticsNode");
        accessibilityNodeInfoCompat.setClassName(ClassName);
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
        if (role != null) {
            int r5 = role.m6871unboximpl();
            if (semanticsNode.isFake$ui_release() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
                if (Role.m6868equalsimpl0(role.m6871unboximpl(), Role.Companion.m6878getTabo7Vup1c())) {
                    accessibilityNodeInfoCompat.setRoleDescription(this.view.getContext().getResources().getString(R.string.tab));
                } else {
                    if (Role.m6868equalsimpl0(role.m6871unboximpl(), Role.Companion.m6877getSwitcho7Vup1c())) {
                        accessibilityNodeInfoCompat.setRoleDescription(this.view.getContext().getResources().getString(R.string.switch_role));
                    } else {
                        String className = AndroidComposeViewAccessibilityDelegateCompat_androidKt.m6767toLegacyClassNameV4PA4sw(role.m6871unboximpl());
                        if (!Role.m6868equalsimpl0(role.m6871unboximpl(), Role.Companion.m6875getImageo7Vup1c()) || semanticsNode.isUnmergedLeafNode$ui_release() || semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants()) {
                            accessibilityNodeInfoCompat.setClassName(className);
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode)) {
            accessibilityNodeInfoCompat.setClassName(TextFieldClassName);
        }
        if (semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getText())) {
            accessibilityNodeInfoCompat.setClassName(TextClassName);
        }
        accessibilityNodeInfoCompat.setPackageName(this.view.getContext().getPackageName());
        accessibilityNodeInfoCompat.setImportantForAccessibility(true);
        List $this$fastForEach$iv = semanticsNode.getReplacedChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            SemanticsNode child = $this$fastForEach$iv.get(index$iv);
            if (getCurrentSemanticsNodes$ui_release().containsKey(Integer.valueOf(child.getId()))) {
                AndroidViewHolder holder = this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(child.getLayoutNode$ui_release());
                if (holder != null) {
                    accessibilityNodeInfoCompat.addChild(holder);
                } else {
                    accessibilityNodeInfoCompat.addChild(this.view, child.getId());
                }
            }
        }
        boolean z = false;
        if (this.focusedVirtualViewId == i) {
            accessibilityNodeInfoCompat.setAccessibilityFocused(true);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            accessibilityNodeInfoCompat.setAccessibilityFocused(false);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }
        setText(semanticsNode2, accessibilityNodeInfoCompat);
        setContentInvalid(semanticsNode2, accessibilityNodeInfoCompat);
        setStateDescription(semanticsNode2, accessibilityNodeInfoCompat);
        setIsCheckable(semanticsNode2, accessibilityNodeInfoCompat);
        ToggleableState toggleState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getToggleableState());
        if (toggleState != null) {
            ToggleableState toggleableState = toggleState;
            if (toggleState == ToggleableState.On) {
                accessibilityNodeInfoCompat.setChecked(true);
            } else if (toggleState == ToggleableState.Off) {
                accessibilityNodeInfoCompat.setChecked(false);
            }
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean it = bool.booleanValue();
            if (role == null ? false : Role.m6868equalsimpl0(role.m6871unboximpl(), Role.Companion.m6878getTabo7Vup1c())) {
                accessibilityNodeInfoCompat.setSelected(it);
            } else {
                accessibilityNodeInfoCompat.setChecked(it);
            }
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        if (!semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
            accessibilityNodeInfoCompat.setContentDescription(AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoContentDescriptionOrNull(semanticsNode));
        }
        String testTag = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getTestTag());
        if (testTag != null) {
            boolean testTagsAsResourceId = false;
            SemanticsNode current = semanticsNode;
            while (true) {
                if (current == null) {
                    break;
                } else if (current.getUnmergedConfig$ui_release().contains(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())) {
                    testTagsAsResourceId = ((Boolean) current.getUnmergedConfig$ui_release().get(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())).booleanValue();
                    break;
                } else {
                    current = current.getParent();
                }
            }
            if (testTagsAsResourceId) {
                accessibilityNodeInfoCompat.setViewIdResourceName(testTag);
            }
        }
        if (((Unit) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHeading())) != null) {
            accessibilityNodeInfoCompat.setHeading(true);
            Unit it2 = Unit.INSTANCE;
            Unit unit7 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat.setPassword(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(semanticsNode));
        accessibilityNodeInfoCompat.setEditable(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode));
        accessibilityNodeInfoCompat.setEnabled(AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode));
        accessibilityNodeInfoCompat.setFocusable(semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getFocused()));
        int i2 = 2;
        if (info.isFocusable()) {
            accessibilityNodeInfoCompat.setFocused(((Boolean) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getFocused())).booleanValue());
            if (info.isFocused()) {
                accessibilityNodeInfoCompat.addAction(2);
            } else {
                accessibilityNodeInfoCompat.addAction(1);
            }
        }
        accessibilityNodeInfoCompat.setVisibleToUser(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isVisible(semanticsNode));
        LiveRegionMode liveRegionMode = (LiveRegionMode) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getLiveRegion());
        if (liveRegionMode != null) {
            int it3 = liveRegionMode.m6862unboximpl();
            if (LiveRegionMode.m6859equalsimpl0(it3, LiveRegionMode.Companion.m6864getPolite0phEisY())) {
                i2 = 1;
            } else if (!LiveRegionMode.m6859equalsimpl0(it3, LiveRegionMode.Companion.m6863getAssertive0phEisY())) {
                i2 = 1;
            }
            accessibilityNodeInfoCompat.setLiveRegion(i2);
            Unit unit8 = Unit.INSTANCE;
            Unit unit9 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat.setClickable(false);
        AccessibilityAction it4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnClick());
        if (it4 != null) {
            boolean isSelected = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected()), (Object) true);
            accessibilityNodeInfoCompat.setClickable(!isSelected);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) && !isSelected) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, it4.getLabel()));
            }
            Unit unit10 = Unit.INSTANCE;
            Unit unit11 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat.setLongClickable(false);
        AccessibilityAction it5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnLongClick());
        if (it5 != null) {
            accessibilityNodeInfoCompat.setLongClickable(true);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, it5.getLabel()));
            }
            Unit unit12 = Unit.INSTANCE;
            Unit unit13 = Unit.INSTANCE;
        }
        AccessibilityAction it6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCopyText());
        if (it6 != null) {
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, it6.getLabel()));
            Unit unit14 = Unit.INSTANCE;
            Unit unit15 = Unit.INSTANCE;
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            AccessibilityAction it7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetText());
            if (it7 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, it7.getLabel()));
                Unit unit16 = Unit.INSTANCE;
                Unit unit17 = Unit.INSTANCE;
            }
            AccessibilityAction it8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPerformImeAction());
            if (it8 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908372, it8.getLabel()));
                Unit unit18 = Unit.INSTANCE;
                Unit unit19 = Unit.INSTANCE;
            }
            AccessibilityAction it9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCutText());
            if (it9 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, it9.getLabel()));
                Unit unit20 = Unit.INSTANCE;
                Unit unit21 = Unit.INSTANCE;
            }
            AccessibilityAction it10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPasteText());
            if (it10 != null) {
                if (info.isFocused() && this.view.getClipboardManager().hasText()) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, it10.getLabel()));
                }
                Unit unit22 = Unit.INSTANCE;
                Unit unit23 = Unit.INSTANCE;
            }
        }
        String text = getIterableTextForAccessibility(semanticsNode2);
        CharSequence charSequence = text;
        if (!(charSequence == null || charSequence.length() == 0)) {
            accessibilityNodeInfoCompat.setTextSelection(getAccessibilitySelectionStart(semanticsNode2), getAccessibilitySelectionEnd(semanticsNode2));
            AccessibilityAction setSelectionAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetSelection());
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, setSelectionAction != null ? setSelectionAction.getLabel() : null));
            accessibilityNodeInfoCompat.addAction(256);
            accessibilityNodeInfoCompat.addAction(512);
            accessibilityNodeInfoCompat.setMovementGranularities(11);
            Collection collection = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getContentDescription());
            if ((collection == null || collection.isEmpty()) && semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && !AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities(semanticsNode)) {
                accessibilityNodeInfoCompat.setMovementGranularities(16 | info.getMovementGranularities() | 4);
            }
        }
        List extraDataKeys = new ArrayList();
        extraDataKeys.add(ExtraDataIdKey);
        CharSequence text2 = info.getText();
        if (text2 == null || text2.length() == 0) {
            z = true;
        }
        if (!z && semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
            extraDataKeys.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
        }
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTestTag())) {
            extraDataKeys.add(ExtraDataTestTagKey);
        }
        AccessibilityNodeInfoVerificationHelperMethods accessibilityNodeInfoVerificationHelperMethods = AccessibilityNodeInfoVerificationHelperMethods.INSTANCE;
        AccessibilityNodeInfo unwrap = info.unwrap();
        Intrinsics.checkNotNullExpressionValue(unwrap, "info.unwrap()");
        accessibilityNodeInfoVerificationHelperMethods.setAvailableExtraData(unwrap, extraDataKeys);
        ProgressBarRangeInfo rangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (rangeInfo != null) {
            if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                accessibilityNodeInfoCompat.setClassName("android.widget.SeekBar");
            } else {
                accessibilityNodeInfoCompat.setClassName("android.widget.ProgressBar");
            }
            if (rangeInfo != ProgressBarRangeInfo.Companion.getIndeterminate()) {
                accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, rangeInfo.getRange().getStart().floatValue(), rangeInfo.getRange().getEndInclusive().floatValue(), rangeInfo.getCurrent()));
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetProgress()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (rangeInfo.getCurrent() < RangesKt.coerceAtLeast(rangeInfo.getRange().getEndInclusive().floatValue(), rangeInfo.getRange().getStart().floatValue())) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                }
                if (rangeInfo.getCurrent() > RangesKt.coerceAtMost(rangeInfo.getRange().getStart().floatValue(), rangeInfo.getRange().getEndInclusive().floatValue())) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                }
            }
        }
        Api24Impl.addSetProgressAction(info, semanticsNode);
        CollectionInfoKt.setCollectionInfo(semanticsNode2, accessibilityNodeInfoCompat);
        CollectionInfoKt.setCollectionItemInfo(semanticsNode2, accessibilityNodeInfoCompat);
        ScrollAxisRange xScrollState = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
        AccessibilityAction scrollAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getScrollBy());
        if (!(xScrollState == null || scrollAction2 == null)) {
            if (!CollectionInfoKt.hasCollectionInfo(semanticsNode)) {
                accessibilityNodeInfoCompat.setClassName("android.widget.HorizontalScrollView");
            }
            if (xScrollState.getMaxValue().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(xScrollState)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode)) {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    } else {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    }
                    accessibilityNodeInfoCompat.addAction(accessibilityActionCompat2);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(xScrollState)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode)) {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    } else {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    }
                    accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
                }
            }
        }
        ScrollAxisRange yScrollState = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        if (!(yScrollState == null || scrollAction2 == null)) {
            if (!CollectionInfoKt.hasCollectionInfo(semanticsNode)) {
                accessibilityNodeInfoCompat.setClassName("android.widget.ScrollView");
            }
            if (yScrollState.getMaxValue().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(yScrollState)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(yScrollState)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
            }
        }
        Api29Impl.addPageActions(info, semanticsNode);
        accessibilityNodeInfoCompat.setPaneTitle((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getPaneTitle()));
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            AccessibilityAction it11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getExpand());
            if (it11 != null) {
                Role role2 = role;
                AccessibilityAction accessibilityAction = it11;
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, it11.getLabel()));
                Unit unit24 = Unit.INSTANCE;
                Unit unit25 = Unit.INSTANCE;
            }
            AccessibilityAction it12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCollapse());
            if (it12 != null) {
                AccessibilityAction accessibilityAction2 = it12;
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, it12.getLabel()));
                Unit unit26 = Unit.INSTANCE;
                Unit unit27 = Unit.INSTANCE;
            }
            AccessibilityAction it13 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getDismiss());
            if (it13 != null) {
                AccessibilityAction accessibilityAction3 = it13;
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, it13.getLabel()));
                Unit unit28 = Unit.INSTANCE;
                Unit unit29 = Unit.INSTANCE;
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getCustomActions())) {
                List customActions = (List) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getCustomActions());
                int size2 = customActions.size();
                int[] iArr = AccessibilityActionsResourceIds;
                if (size2 < iArr.length) {
                    SparseArrayCompat currentActionIdToLabel = new SparseArrayCompat();
                    Map currentLabelToActionId = new LinkedHashMap();
                    ToggleableState toggleableState2 = toggleState;
                    if (this.labelToActionId.containsKey(i)) {
                        Map oldLabelToActionId2 = this.labelToActionId.get(i);
                        List availableIds = ArraysKt.toMutableList(iArr);
                        ProgressBarRangeInfo progressBarRangeInfo = rangeInfo;
                        List unassignedActions = new ArrayList();
                        List $this$fastForEach$iv2 = customActions;
                        String str = testTag;
                        int size3 = $this$fastForEach$iv2.size();
                        String str2 = text;
                        int index$iv2 = 0;
                        while (index$iv2 < size3) {
                            int i3 = size3;
                            List $this$fastForEach$iv3 = $this$fastForEach$iv2;
                            List $this$fastForEach$iv4 = $this$fastForEach$iv3;
                            CustomAccessibilityAction action = (CustomAccessibilityAction) $this$fastForEach$iv3.get(index$iv2);
                            Intrinsics.checkNotNull(oldLabelToActionId2);
                            ScrollAxisRange xScrollState2 = xScrollState;
                            if (oldLabelToActionId2.containsKey(action.getLabel())) {
                                Integer actionId = (Integer) oldLabelToActionId2.get(action.getLabel());
                                Intrinsics.checkNotNull(actionId);
                                oldLabelToActionId = oldLabelToActionId2;
                                scrollAction = scrollAction2;
                                currentActionIdToLabel.put(actionId.intValue(), action.getLabel());
                                currentLabelToActionId.put(action.getLabel(), actionId);
                                availableIds.remove(actionId);
                                Integer num = actionId;
                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionId.intValue(), action.getLabel()));
                            } else {
                                oldLabelToActionId = oldLabelToActionId2;
                                scrollAction = scrollAction2;
                                unassignedActions.add(action);
                            }
                            index$iv2++;
                            size3 = i3;
                            $this$fastForEach$iv2 = $this$fastForEach$iv4;
                            xScrollState = xScrollState2;
                            oldLabelToActionId2 = oldLabelToActionId;
                            scrollAction2 = scrollAction;
                        }
                        ScrollAxisRange scrollAxisRange = xScrollState;
                        AccessibilityAction accessibilityAction4 = scrollAction2;
                        List list = $this$fastForEach$iv2;
                        List $this$fastForEachIndexed$iv = unassignedActions;
                        int $i$f$fastForEachIndexed = false;
                        int index$iv3 = 0;
                        int size4 = $this$fastForEachIndexed$iv.size();
                        while (index$iv3 < size4) {
                            CustomAccessibilityAction action2 = (CustomAccessibilityAction) $this$fastForEachIndexed$iv.get(index$iv3);
                            List $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv;
                            int index = index$iv3;
                            int i4 = index;
                            int actionId2 = availableIds.get(index).intValue();
                            currentActionIdToLabel.put(actionId2, action2.getLabel());
                            currentLabelToActionId.put(action2.getLabel(), Integer.valueOf(actionId2));
                            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionId2, action2.getLabel()));
                            index$iv3++;
                            unassignedActions = unassignedActions;
                            $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
                            $i$f$fastForEachIndexed = $i$f$fastForEachIndexed;
                        }
                        List list2 = unassignedActions;
                        int i5 = $i$f$fastForEachIndexed;
                        List list3 = customActions;
                    } else {
                        String str3 = testTag;
                        String str4 = text;
                        ScrollAxisRange scrollAxisRange2 = xScrollState;
                        AccessibilityAction accessibilityAction5 = scrollAction2;
                        List $this$fastForEachIndexed$iv3 = customActions;
                        int $i$f$fastForEachIndexed2 = false;
                        int index$iv4 = 0;
                        int size5 = $this$fastForEachIndexed$iv3.size();
                        while (index$iv4 < size5) {
                            CustomAccessibilityAction action3 = (CustomAccessibilityAction) $this$fastForEachIndexed$iv3.get(index$iv4);
                            List customActions2 = customActions;
                            int actionId3 = AccessibilityActionsResourceIds[index$iv4];
                            currentActionIdToLabel.put(actionId3, action3.getLabel());
                            currentLabelToActionId.put(action3.getLabel(), Integer.valueOf(actionId3));
                            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionId3, action3.getLabel()));
                            index$iv4++;
                            $this$fastForEachIndexed$iv3 = $this$fastForEachIndexed$iv3;
                            customActions = customActions2;
                            $i$f$fastForEachIndexed2 = $i$f$fastForEachIndexed2;
                        }
                        List list4 = $this$fastForEachIndexed$iv3;
                        int i6 = $i$f$fastForEachIndexed2;
                    }
                    this.actionIdToLabel.put(i, currentActionIdToLabel);
                    this.labelToActionId.put(i, currentLabelToActionId);
                } else {
                    ToggleableState toggleableState3 = toggleState;
                    throw new IllegalStateException("Can't have more than " + iArr.length + " custom actions for one widget");
                }
            } else {
                ProgressBarRangeInfo progressBarRangeInfo2 = rangeInfo;
                String str5 = testTag;
                String str6 = text;
                ScrollAxisRange scrollAxisRange3 = xScrollState;
                AccessibilityAction accessibilityAction6 = scrollAction2;
            }
        } else {
            ToggleableState toggleableState4 = toggleState;
            ProgressBarRangeInfo progressBarRangeInfo3 = rangeInfo;
            String str7 = testTag;
            String str8 = text;
            ScrollAxisRange scrollAxisRange4 = xScrollState;
            AccessibilityAction accessibilityAction7 = scrollAction2;
        }
        accessibilityNodeInfoCompat.setScreenReaderFocusable(isScreenReaderFocusable(semanticsNode2));
        Integer beforeId = this.idToBeforeMap.get(Integer.valueOf(virtualViewId));
        if (beforeId != null) {
            int intValue = beforeId.intValue();
            View beforeView = AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui_release(), beforeId.intValue());
            if (beforeView != null) {
                accessibilityNodeInfoCompat.setTraversalBefore(beforeView);
            } else {
                accessibilityNodeInfoCompat.setTraversalBefore(this.view, beforeId.intValue());
            }
            AccessibilityNodeInfo unwrap2 = info.unwrap();
            Intrinsics.checkNotNullExpressionValue(unwrap2, "info.unwrap()");
            addExtraDataToAccessibilityNodeInfoHelper(i, unwrap2, this.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL, (Bundle) null);
            Unit unit30 = Unit.INSTANCE;
            Unit unit31 = Unit.INSTANCE;
        }
        Integer afterId = this.idToAfterMap.get(Integer.valueOf(virtualViewId));
        if (afterId != null) {
            int intValue2 = afterId.intValue();
            View afterView = AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui_release(), afterId.intValue());
            if (afterView != null) {
                accessibilityNodeInfoCompat.setTraversalAfter(afterView);
                AccessibilityNodeInfo unwrap3 = info.unwrap();
                Intrinsics.checkNotNullExpressionValue(unwrap3, "info.unwrap()");
                addExtraDataToAccessibilityNodeInfoHelper(i, unwrap3, this.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL, (Bundle) null);
            }
            Unit unit32 = Unit.INSTANCE;
            Unit unit33 = Unit.INSTANCE;
        }
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange $this$populateAccessibilityNodeInfoProperties_u24canScrollForward) {
        return ($this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getValue().invoke().floatValue() < $this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getMaxValue().invoke().floatValue() && !$this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getReverseScrolling()) || ($this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getValue().invoke().floatValue() > 0.0f && $this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getReverseScrolling());
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward) {
        return ($this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getValue().invoke().floatValue() > 0.0f && !$this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getReverseScrolling()) || ($this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getValue().invoke().floatValue() < $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getMaxValue().invoke().floatValue() && $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getReverseScrolling());
    }

    private final void setContentInvalid(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getError())) {
            info.setContentInvalid(true);
            info.setError((CharSequence) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getError()));
        }
    }

    private final String getInfoStateDescriptionOrNull(SemanticsNode node) {
        float f;
        Object obj;
        Object stateDescription = SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getStateDescription());
        ToggleableState toggleState = (ToggleableState) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
        int percent = 0;
        if (toggleState != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[toggleState.ordinal()]) {
                case 1:
                    if ((role == null ? false : Role.m6868equalsimpl0(role.m6871unboximpl(), Role.Companion.m6877getSwitcho7Vup1c())) && stateDescription == null) {
                        stateDescription = this.view.getContext().getResources().getString(R.string.on);
                        break;
                    }
                case 2:
                    if ((role == null ? false : Role.m6868equalsimpl0(role.m6871unboximpl(), Role.Companion.m6877getSwitcho7Vup1c())) && stateDescription == null) {
                        stateDescription = this.view.getContext().getResources().getString(R.string.off);
                        break;
                    }
                case 3:
                    if (stateDescription == null) {
                        stateDescription = this.view.getContext().getResources().getString(R.string.indeterminate);
                        break;
                    }
                    break;
            }
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean it = bool.booleanValue();
            if (!(role == null ? false : Role.m6868equalsimpl0(role.m6871unboximpl(), Role.Companion.m6878getTabo7Vup1c())) && stateDescription == null) {
                if (it) {
                    obj = this.view.getContext().getResources().getString(R.string.selected);
                } else {
                    obj = this.view.getContext().getResources().getString(R.string.not_selected);
                }
                stateDescription = obj;
            }
        }
        ProgressBarRangeInfo rangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (rangeInfo != null) {
            ProgressBarRangeInfo progressBarRangeInfo = rangeInfo;
            if (rangeInfo != ProgressBarRangeInfo.Companion.getIndeterminate()) {
                if (stateDescription == null) {
                    ClosedFloatingPointRange valueRange = rangeInfo.getRange();
                    if (valueRange.getEndInclusive().floatValue() - valueRange.getStart().floatValue() == 0.0f) {
                        f = 0.0f;
                    } else {
                        f = (rangeInfo.getCurrent() - valueRange.getStart().floatValue()) / (valueRange.getEndInclusive().floatValue() - valueRange.getStart().floatValue());
                    }
                    float progress = RangesKt.coerceIn(f, 0.0f, 1.0f);
                    if (!(progress == 0.0f)) {
                        if (progress == 1.0f) {
                            percent = 1;
                        }
                        if (percent != 0) {
                            percent = 100;
                        } else {
                            percent = RangesKt.coerceIn(MathKt.roundToInt(((float) 100) * progress), 1, 99);
                        }
                    }
                    stateDescription = this.view.getContext().getResources().getString(R.string.template_percent, new Object[]{Integer.valueOf(percent)});
                }
            } else if (stateDescription == null) {
                stateDescription = this.view.getContext().getResources().getString(R.string.in_progress);
            }
        }
        return (String) stateDescription;
    }

    private final void setStateDescription(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        info.setStateDescription(getInfoStateDescriptionOrNull(node));
    }

    private final boolean getInfoIsCheckable(SemanticsNode node) {
        boolean isCheckable = false;
        ToggleableState toggleState = (ToggleableState) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
        if (toggleState != null) {
            ToggleableState toggleableState = toggleState;
            isCheckable = true;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected());
        if (bool == null) {
            return isCheckable;
        }
        boolean booleanValue = bool.booleanValue();
        if (!(role == null ? false : Role.m6868equalsimpl0(role.m6871unboximpl(), Role.Companion.m6878getTabo7Vup1c()))) {
            return true;
        }
        return isCheckable;
    }

    private final void setIsCheckable(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        info.setCheckable(getInfoIsCheckable(node));
    }

    private final SpannableString getInfoText(SemanticsNode node) {
        AnnotatedString annotatedString;
        FontFamily.Resolver fontFamilyResolver = this.view.getFontFamilyResolver();
        AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig$ui_release());
        SpannableString spannableString = null;
        SpannableString editableTextToAssign = (SpannableString) trimToSize(textForTextField != null ? AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(textForTextField, this.view.getDensity(), fontFamilyResolver, this.urlSpanCache) : null, ParcelSafeTextLength);
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        if (!(list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null)) {
            spannableString = AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, this.view.getDensity(), fontFamilyResolver, this.urlSpanCache);
        }
        return editableTextToAssign == null ? (SpannableString) trimToSize(spannableString, ParcelSafeTextLength) : editableTextToAssign;
    }

    private final void setText(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        info.setText(getInfoText(node));
    }

    private final boolean isAccessibilityFocused(int virtualViewId) {
        return this.focusedVirtualViewId == virtualViewId;
    }

    private final boolean requestAccessibilityFocus(int virtualViewId) {
        if (!isTouchExplorationEnabled() || isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        int i = this.focusedVirtualViewId;
        if (i != Integer.MIN_VALUE) {
            sendEventForVirtualView$default(this, i, 65536, (Integer) null, (List) null, 12, (Object) null);
        }
        this.focusedVirtualViewId = virtualViewId;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 32768, (Integer) null, (List) null, 12, (Object) null);
        return true;
    }

    static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, list);
    }

    private final boolean sendEventForVirtualView(int virtualViewId, int eventType, Integer contentChangeType, List<String> contentDescription) {
        if (virtualViewId == Integer.MIN_VALUE || !isEnabled$ui_release()) {
            return false;
        }
        AccessibilityEvent event = createEvent$ui_release(virtualViewId, eventType);
        if (contentChangeType != null) {
            event.setContentChangeTypes(contentChangeType.intValue());
        }
        if (contentDescription != null) {
            event.setContentDescription(TempListUtilsKt.fastJoinToString$default(contentDescription, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        return sendEvent(event);
    }

    /* access modifiers changed from: private */
    public final boolean sendEvent(AccessibilityEvent event) {
        if (!isEnabledForAccessibility()) {
            return false;
        }
        return this.view.getParent().requestSendAccessibilityEvent(this.view, event);
    }

    public final AccessibilityEvent createEvent$ui_release(int virtualViewId, int eventType) {
        AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
        Intrinsics.checkNotNullExpressionValue(event, "obtain(eventType)");
        event.setEnabled(true);
        event.setClassName(ClassName);
        event.setPackageName(this.view.getContext().getPackageName());
        event.setSource(this.view, virtualViewId);
        SemanticsNodeWithAdjustedBounds it = getCurrentSemanticsNodes$ui_release().get(Integer.valueOf(virtualViewId));
        if (it != null) {
            event.setPassword(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(it.getSemanticsNode()));
        }
        return event;
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int virtualViewId, Integer fromIndex, Integer toIndex, Integer itemCount, CharSequence text) {
        AccessibilityEvent createEvent$ui_release = createEvent$ui_release(virtualViewId, 8192);
        AccessibilityEvent $this$createTextSelectionChangedEvent_u24lambda_u2440 = createEvent$ui_release;
        if (fromIndex != null) {
            $this$createTextSelectionChangedEvent_u24lambda_u2440.setFromIndex(fromIndex.intValue());
        }
        if (toIndex != null) {
            $this$createTextSelectionChangedEvent_u24lambda_u2440.setToIndex(toIndex.intValue());
        }
        if (itemCount != null) {
            $this$createTextSelectionChangedEvent_u24lambda_u2440.setItemCount(itemCount.intValue());
        }
        if (text != null) {
            $this$createTextSelectionChangedEvent_u24lambda_u2440.getText().add(text);
        }
        return createEvent$ui_release;
    }

    private final boolean clearAccessibilityFocus(int virtualViewId) {
        if (!isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 65536, (Integer) null, (List) null, 12, (Object) null);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v41, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v109, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v44, types: [java.lang.String] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean performActionHelper(int r23, int r24, android.os.Bundle r25) {
        /*
            r22 = this;
            r7 = r22
            r8 = r24
            r9 = r25
            java.util.Map r0 = r22.getCurrentSemanticsNodes$ui_release()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r23)
            java.lang.Object r0 = r0.get(r1)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r0 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r0
            r10 = 0
            if (r0 == 0) goto L_0x06c9
            androidx.compose.ui.semantics.SemanticsNode r0 = r0.getSemanticsNode()
            if (r0 != 0) goto L_0x0022
            r1 = r23
            r3 = r10
            goto L_0x06cc
        L_0x0022:
            r11 = r0
            r0 = 1
            switch(r8) {
                case 64: goto L_0x00af;
                case 128: goto L_0x00aa;
                case 256: goto L_0x008a;
                case 512: goto L_0x008a;
                case 16384: goto L_0x0063;
                case 131072: goto L_0x002e;
                default: goto L_0x0027;
            }
        L_0x0027:
            boolean r1 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(r11)
            if (r1 != 0) goto L_0x00b4
            return r10
        L_0x002e:
            r0 = -1
            if (r9 == 0) goto L_0x0039
            java.lang.String r1 = "ACTION_ARGUMENT_SELECTION_START_INT"
            int r1 = r9.getInt(r1, r0)
            goto L_0x003a
        L_0x0039:
            r1 = r0
        L_0x003a:
            r12 = r1
            if (r9 == 0) goto L_0x0045
            java.lang.String r1 = "ACTION_ARGUMENT_SELECTION_END_INT"
            int r0 = r9.getInt(r1, r0)
            goto L_0x0046
        L_0x0045:
        L_0x0046:
            r13 = r0
            boolean r10 = r7.setAccessibilitySelection(r11, r12, r13, r10)
            if (r10 == 0) goto L_0x0062
            int r0 = r11.getId()
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r0)
            r5 = 12
            r6 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r0 = r22
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
        L_0x0062:
            return r10
        L_0x0063:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getCopyText()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x0089
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x0089
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
        L_0x0089:
            return r10
        L_0x008a:
            if (r9 == 0) goto L_0x00a9
            java.lang.String r1 = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT"
            int r1 = r9.getInt(r1)
            java.lang.String r2 = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN"
            boolean r2 = r9.getBoolean(r2)
            r3 = 256(0x100, float:3.59E-43)
            if (r8 != r3) goto L_0x00a3
            r10 = r0
        L_0x00a3:
            boolean r0 = r7.traverseAtGranularity(r11, r1, r10, r2)
            return r0
        L_0x00a9:
            return r10
        L_0x00aa:
            boolean r0 = r22.clearAccessibilityFocus(r23)
            return r0
        L_0x00af:
            boolean r0 = r22.requestAccessibilityFocus(r23)
            return r0
        L_0x00b4:
            r1 = 0
            switch(r8) {
                case 1: goto L_0x0658;
                case 2: goto L_0x062f;
                case 16: goto L_0x05f7;
                case 32: goto L_0x05d0;
                case 4096: goto L_0x03ea;
                case 8192: goto L_0x03ea;
                case 32768: goto L_0x03c2;
                case 65536: goto L_0x039a;
                case 262144: goto L_0x0372;
                case 524288: goto L_0x034a;
                case 1048576: goto L_0x0322;
                case 2097152: goto L_0x02dd;
                case 16908342: goto L_0x01c6;
                case 16908344: goto L_0x03ea;
                case 16908345: goto L_0x03ea;
                case 16908346: goto L_0x03ea;
                case 16908347: goto L_0x03ea;
                case 16908349: goto L_0x018a;
                case 16908358: goto L_0x0165;
                case 16908359: goto L_0x0140;
                case 16908360: goto L_0x011b;
                case 16908361: goto L_0x00f6;
                case 16908372: goto L_0x00cf;
                default: goto L_0x00b8;
            }
        L_0x00b8:
            androidx.collection.SparseArrayCompat<androidx.collection.SparseArrayCompat<java.lang.CharSequence>> r0 = r7.actionIdToLabel
            r1 = r23
            java.lang.Object r0 = r0.get(r1)
            androidx.collection.SparseArrayCompat r0 = (androidx.collection.SparseArrayCompat) r0
            if (r0 == 0) goto L_0x06c7
            java.lang.Object r0 = r0.get(r8)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 != 0) goto L_0x0680
            r3 = 0
            goto L_0x06c8
        L_0x00cf:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getPerformImeAction()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x00f5
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x00f5
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
        L_0x00f5:
            return r10
        L_0x00f6:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getPageRight()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x011a
            kotlin.Function r1 = r0.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x011a
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r10 = r1.booleanValue()
        L_0x011a:
            return r10
        L_0x011b:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getPageLeft()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x013f
            kotlin.Function r1 = r0.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x013f
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r10 = r1.booleanValue()
        L_0x013f:
            return r10
        L_0x0140:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getPageDown()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x0164
            kotlin.Function r1 = r0.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x0164
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r10 = r1.booleanValue()
        L_0x0164:
            return r10
        L_0x0165:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getPageUp()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x0189
            kotlin.Function r1 = r0.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x0189
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r10 = r1.booleanValue()
        L_0x0189:
            return r10
        L_0x018a:
            if (r9 == 0) goto L_0x01c5
            java.lang.String r0 = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"
            boolean r1 = r9.containsKey(r0)
            if (r1 != 0) goto L_0x0196
            goto L_0x01c5
        L_0x0196:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getSetProgress()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x01c3
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            if (r1 == 0) goto L_0x01c3
            float r0 = r9.getFloat(r0)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            java.lang.Object r0 = r1.invoke(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x01c4
        L_0x01c3:
        L_0x01c4:
            return r10
        L_0x01c5:
            return r10
        L_0x01c6:
            androidx.compose.ui.semantics.SemanticsNode r2 = r11.getParent()
            if (r2 == 0) goto L_0x01df
            androidx.compose.ui.semantics.SemanticsConfiguration r3 = r2.getConfig()
            if (r3 == 0) goto L_0x01df
            androidx.compose.ui.semantics.SemanticsActions r4 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r4 = r4.getScrollBy()
            java.lang.Object r3 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r3, r4)
            androidx.compose.ui.semantics.AccessibilityAction r3 = (androidx.compose.ui.semantics.AccessibilityAction) r3
            goto L_0x01e0
        L_0x01df:
            r3 = r1
        L_0x01e0:
            if (r2 == 0) goto L_0x0201
            if (r3 == 0) goto L_0x01e5
            goto L_0x0201
        L_0x01e5:
            androidx.compose.ui.semantics.SemanticsNode r2 = r2.getParent()
            if (r2 == 0) goto L_0x01fe
            androidx.compose.ui.semantics.SemanticsConfiguration r4 = r2.getConfig()
            if (r4 == 0) goto L_0x01fe
            androidx.compose.ui.semantics.SemanticsActions r5 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r5 = r5.getScrollBy()
            java.lang.Object r4 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r4, r5)
            androidx.compose.ui.semantics.AccessibilityAction r4 = (androidx.compose.ui.semantics.AccessibilityAction) r4
            goto L_0x01ff
        L_0x01fe:
            r4 = r1
        L_0x01ff:
            r3 = r4
            goto L_0x01e0
        L_0x0201:
            if (r2 != 0) goto L_0x0204
            return r10
        L_0x0204:
            androidx.compose.ui.layout.LayoutInfo r1 = r2.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r1 = r1.getCoordinates()
            androidx.compose.ui.geometry.Rect r1 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInParent(r1)
            androidx.compose.ui.layout.LayoutInfo r4 = r2.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r4 = r4.getCoordinates()
            androidx.compose.ui.layout.LayoutCoordinates r4 = r4.getParentLayoutCoordinates()
            if (r4 == 0) goto L_0x0223
            long r4 = androidx.compose.ui.layout.LayoutCoordinatesKt.positionInRoot(r4)
            goto L_0x0229
        L_0x0223:
            androidx.compose.ui.geometry.Offset$Companion r4 = androidx.compose.ui.geometry.Offset.Companion
            long r4 = r4.m4729getZeroF1C5BW0()
        L_0x0229:
            androidx.compose.ui.geometry.Rect r6 = r1.m4750translatek4lQ0M(r4)
            long r12 = r11.m6880getPositionInRootF1C5BW0()
            long r14 = r11.m6882getSizeYbymL2g()
            long r14 = androidx.compose.ui.unit.IntSizeKt.m7724toSizeozmzZPI(r14)
            androidx.compose.ui.geometry.Rect r12 = androidx.compose.ui.geometry.RectKt.m4753Recttz77jQw(r12, r14)
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r2.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r14 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getHorizontalScrollAxisRange()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.ScrollAxisRange r13 = (androidx.compose.ui.semantics.ScrollAxisRange) r13
            androidx.compose.ui.semantics.SemanticsConfiguration r14 = r2.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r15 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r15 = r15.getVerticalScrollAxisRange()
            java.lang.Object r14 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r14, r15)
            androidx.compose.ui.semantics.ScrollAxisRange r14 = (androidx.compose.ui.semantics.ScrollAxisRange) r14
            float r15 = r12.getLeft()
            float r16 = r6.getLeft()
            float r15 = r15 - r16
            float r16 = r12.getRight()
            float r17 = r6.getRight()
            float r10 = r16 - r17
            float r10 = performActionHelper$scrollDelta(r15, r10)
            if (r13 == 0) goto L_0x0282
            boolean r15 = r13.getReverseScrolling()
            if (r15 != r0) goto L_0x0282
            r15 = r0
            goto L_0x0283
        L_0x0282:
            r15 = 0
        L_0x0283:
            if (r15 == 0) goto L_0x0286
            float r10 = -r10
        L_0x0286:
            boolean r15 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(r11)
            if (r15 == 0) goto L_0x028d
            float r10 = -r10
        L_0x028d:
            float r15 = r12.getTop()
            float r16 = r6.getTop()
            float r15 = r15 - r16
            float r16 = r12.getBottom()
            float r17 = r6.getBottom()
            float r0 = r16 - r17
            float r0 = performActionHelper$scrollDelta(r15, r0)
            if (r14 == 0) goto L_0x02b3
            boolean r15 = r14.getReverseScrolling()
            r16 = r1
            r1 = 1
            if (r15 != r1) goto L_0x02b5
            r19 = 1
            goto L_0x02b7
        L_0x02b3:
            r16 = r1
        L_0x02b5:
            r19 = 0
        L_0x02b7:
            if (r19 == 0) goto L_0x02ba
            float r0 = -r0
        L_0x02ba:
            if (r3 == 0) goto L_0x02d9
            kotlin.Function r1 = r3.getAction()
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            if (r1 == 0) goto L_0x02d9
            java.lang.Float r15 = java.lang.Float.valueOf(r10)
            r17 = r2
            java.lang.Float r2 = java.lang.Float.valueOf(r0)
            java.lang.Object r1 = r1.invoke(r15, r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            goto L_0x02dc
        L_0x02d9:
            r17 = r2
            r1 = 0
        L_0x02dc:
            return r1
        L_0x02dd:
            if (r9 == 0) goto L_0x02e6
            java.lang.String r0 = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE"
            java.lang.String r1 = r9.getString(r0)
        L_0x02e6:
            r0 = r1
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getSetText()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x0320
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            if (r1 == 0) goto L_0x0320
            androidx.compose.ui.text.AnnotatedString r2 = new androidx.compose.ui.text.AnnotatedString
            if (r0 != 0) goto L_0x030a
            java.lang.String r3 = ""
            r13 = r3
            goto L_0x030b
        L_0x030a:
            r13 = r0
        L_0x030b:
            r16 = 6
            r17 = 0
            r14 = 0
            r15 = 0
            r12 = r2
            r12.<init>(r13, r14, r15, r16, r17)
            java.lang.Object r1 = r1.invoke(r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r10 = r1.booleanValue()
            goto L_0x0321
        L_0x0320:
            r10 = 0
        L_0x0321:
            return r10
        L_0x0322:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getDismiss()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x0348
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x0348
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x0349
        L_0x0348:
            r10 = 0
        L_0x0349:
            return r10
        L_0x034a:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getCollapse()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x0370
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x0370
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x0371
        L_0x0370:
            r10 = 0
        L_0x0371:
            return r10
        L_0x0372:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getExpand()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x0398
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x0398
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x0399
        L_0x0398:
            r10 = 0
        L_0x0399:
            return r10
        L_0x039a:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getCutText()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x03c0
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x03c0
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x03c1
        L_0x03c0:
            r10 = 0
        L_0x03c1:
            return r10
        L_0x03c2:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getPasteText()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x03e8
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x03e8
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x03e9
        L_0x03e8:
            r10 = 0
        L_0x03e9:
            return r10
        L_0x03ea:
            r0 = 4096(0x1000, float:5.74E-42)
            if (r8 != r0) goto L_0x03f0
            r0 = 1
            goto L_0x03f1
        L_0x03f0:
            r0 = 0
        L_0x03f1:
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r8 != r1) goto L_0x03f7
            r1 = 1
            goto L_0x03f8
        L_0x03f7:
            r1 = 0
        L_0x03f8:
            r2 = 16908345(0x1020039, float:2.387739E-38)
            if (r8 != r2) goto L_0x03ff
            r2 = 1
            goto L_0x0400
        L_0x03ff:
            r2 = 0
        L_0x0400:
            r3 = 16908347(0x102003b, float:2.3877394E-38)
            if (r8 != r3) goto L_0x0407
            r3 = 1
            goto L_0x0408
        L_0x0407:
            r3 = 0
        L_0x0408:
            r4 = 16908344(0x1020038, float:2.3877386E-38)
            if (r8 != r4) goto L_0x040f
            r4 = 1
            goto L_0x0410
        L_0x040f:
            r4 = 0
        L_0x0410:
            r5 = 16908346(0x102003a, float:2.3877392E-38)
            if (r8 != r5) goto L_0x0417
            r5 = 1
            goto L_0x0418
        L_0x0417:
            r5 = 0
        L_0x0418:
            if (r2 != 0) goto L_0x0423
            if (r3 != 0) goto L_0x0423
            if (r0 != 0) goto L_0x0423
            if (r1 == 0) goto L_0x0421
            goto L_0x0423
        L_0x0421:
            r6 = 0
            goto L_0x0424
        L_0x0423:
            r6 = 1
        L_0x0424:
            if (r4 != 0) goto L_0x042f
            if (r5 != 0) goto L_0x042f
            if (r0 != 0) goto L_0x042f
            if (r1 == 0) goto L_0x042d
            goto L_0x042f
        L_0x042d:
            r10 = 0
            goto L_0x0430
        L_0x042f:
            r10 = 1
        L_0x0430:
            if (r0 != 0) goto L_0x043b
            if (r1 == 0) goto L_0x0435
            goto L_0x043b
        L_0x0435:
            r17 = r0
            r20 = r5
            goto L_0x04ec
        L_0x043b:
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r13 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = r13.getProgressBarRangeInfo()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r13)
            androidx.compose.ui.semantics.ProgressBarRangeInfo r12 = (androidx.compose.ui.semantics.ProgressBarRangeInfo) r12
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getSetProgress()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r12 == 0) goto L_0x04e8
            if (r13 == 0) goto L_0x04e8
            kotlin.ranges.ClosedFloatingPointRange r14 = r12.getRange()
            java.lang.Comparable r14 = r14.getEndInclusive()
            java.lang.Number r14 = (java.lang.Number) r14
            float r14 = r14.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r15 = r12.getRange()
            java.lang.Comparable r15 = r15.getStart()
            java.lang.Number r15 = (java.lang.Number) r15
            float r15 = r15.floatValue()
            float r14 = kotlin.ranges.RangesKt.coerceAtLeast((float) r14, (float) r15)
            kotlin.ranges.ClosedFloatingPointRange r15 = r12.getRange()
            java.lang.Comparable r15 = r15.getStart()
            java.lang.Number r15 = (java.lang.Number) r15
            float r15 = r15.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r16 = r12.getRange()
            java.lang.Comparable r16 = r16.getEndInclusive()
            java.lang.Number r16 = (java.lang.Number) r16
            r17 = r0
            float r0 = r16.floatValue()
            float r0 = kotlin.ranges.RangesKt.coerceAtMost((float) r15, (float) r0)
            int r15 = r12.getSteps()
            if (r15 <= 0) goto L_0x04b8
            float r15 = r14 - r0
            int r16 = r12.getSteps()
            r20 = r5
            r19 = 1
            int r5 = r16 + 1
            float r5 = (float) r5
            float r15 = r15 / r5
            goto L_0x04c1
        L_0x04b8:
            r20 = r5
            float r5 = r14 - r0
            r15 = 20
            float r15 = (float) r15
            float r15 = r5 / r15
        L_0x04c1:
            r5 = r15
            if (r1 == 0) goto L_0x04c5
            float r5 = -r5
        L_0x04c5:
            kotlin.Function r15 = r13.getAction()
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            if (r15 == 0) goto L_0x04e4
            float r16 = r12.getCurrent()
            float r16 = r16 + r5
            r19 = r0
            java.lang.Float r0 = java.lang.Float.valueOf(r16)
            java.lang.Object r0 = r15.invoke(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto L_0x04e7
        L_0x04e4:
            r19 = r0
            r0 = 0
        L_0x04e7:
            return r0
        L_0x04e8:
            r17 = r0
            r20 = r5
        L_0x04ec:
            androidx.compose.ui.layout.LayoutInfo r0 = r11.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r0 = r0.getCoordinates()
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInParent(r0)
            long r12 = r0.m4746getSizeNHjbRc()
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r5 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r5 = r5.getScrollBy()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r5)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 != 0) goto L_0x0510
            r0 = 0
            return r0
        L_0x0510:
            androidx.compose.ui.semantics.SemanticsConfiguration r5 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r14 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getHorizontalScrollAxisRange()
            java.lang.Object r5 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r5, r14)
            androidx.compose.ui.semantics.ScrollAxisRange r5 = (androidx.compose.ui.semantics.ScrollAxisRange) r5
            if (r5 == 0) goto L_0x0578
            if (r6 == 0) goto L_0x0578
            float r15 = androidx.compose.ui.geometry.Size.m4782getWidthimpl(r12)
            if (r2 != 0) goto L_0x052e
            if (r1 == 0) goto L_0x052f
        L_0x052e:
            float r15 = -r15
        L_0x052f:
            boolean r16 = r5.getReverseScrolling()
            if (r16 == 0) goto L_0x0536
            float r15 = -r15
        L_0x0536:
            boolean r16 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(r11)
            if (r16 == 0) goto L_0x0541
            if (r2 != 0) goto L_0x0540
            if (r3 == 0) goto L_0x0541
        L_0x0540:
            float r15 = -r15
        L_0x0541:
            boolean r16 = performActionHelper$canScroll(r5, r15)
            if (r16 == 0) goto L_0x0573
            kotlin.Function r16 = r0.getAction()
            r14 = r16
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            if (r14 == 0) goto L_0x056c
            r16 = r2
            java.lang.Float r2 = java.lang.Float.valueOf(r15)
            r21 = r3
            r18 = 0
            java.lang.Float r3 = java.lang.Float.valueOf(r18)
            java.lang.Object r2 = r14.invoke(r2, r3)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r18 = r2
            goto L_0x0572
        L_0x056c:
            r16 = r2
            r21 = r3
            r18 = 0
        L_0x0572:
            return r18
        L_0x0573:
            r16 = r2
            r21 = r3
            goto L_0x057c
        L_0x0578:
            r16 = r2
            r21 = r3
        L_0x057c:
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r3 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getVerticalScrollAxisRange()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            androidx.compose.ui.semantics.ScrollAxisRange r2 = (androidx.compose.ui.semantics.ScrollAxisRange) r2
            if (r2 == 0) goto L_0x05cc
            if (r10 == 0) goto L_0x05cc
            float r3 = androidx.compose.ui.geometry.Size.m4779getHeightimpl(r12)
            if (r4 != 0) goto L_0x0599
            if (r1 == 0) goto L_0x059a
        L_0x0599:
            float r3 = -r3
        L_0x059a:
            boolean r14 = r2.getReverseScrolling()
            if (r14 == 0) goto L_0x05a1
            float r3 = -r3
        L_0x05a1:
            boolean r14 = performActionHelper$canScroll(r2, r3)
            if (r14 == 0) goto L_0x05c9
            kotlin.Function r14 = r0.getAction()
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            if (r14 == 0) goto L_0x05c5
            r15 = 0
            java.lang.Float r15 = java.lang.Float.valueOf(r15)
            r19 = r0
            java.lang.Float r0 = java.lang.Float.valueOf(r3)
            java.lang.Object r0 = r14.invoke(r15, r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto L_0x05c8
        L_0x05c5:
            r19 = r0
            r0 = 0
        L_0x05c8:
            return r0
        L_0x05c9:
            r19 = r0
            goto L_0x05ce
        L_0x05cc:
            r19 = r0
        L_0x05ce:
            r0 = 0
            return r0
        L_0x05d0:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getOnLongClick()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x05f5
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x05f5
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x05f6
        L_0x05f5:
            r10 = 0
        L_0x05f6:
            return r10
        L_0x05f7:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getOnClick()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r2)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x0618
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x0618
            java.lang.Object r0 = r0.invoke()
            r1 = r0
            java.lang.Boolean r1 = (java.lang.Boolean) r1
        L_0x0618:
            r10 = r1
            r5 = 12
            r6 = 0
            r2 = 1
            r3 = 0
            r4 = 0
            r0 = r22
            r1 = r23
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            if (r10 == 0) goto L_0x062d
            boolean r0 = r10.booleanValue()
            goto L_0x062e
        L_0x062d:
            r0 = 0
        L_0x062e:
            return r0
        L_0x062f:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getFocused()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r2)
            r2 = 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0656
            androidx.compose.ui.platform.AndroidComposeView r0 = r7.view
            androidx.compose.ui.focus.FocusOwner r0 = r0.getFocusOwner()
            androidx.compose.ui.focus.FocusManager r0 = (androidx.compose.ui.focus.FocusManager) r0
            r3 = 0
            androidx.compose.ui.focus.FocusManager.clearFocus$default(r0, r3, r2, r1)
            r10 = r2
            goto L_0x0657
        L_0x0656:
            r10 = 0
        L_0x0657:
            return r10
        L_0x0658:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getRequestFocus()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.AccessibilityAction r0 = (androidx.compose.ui.semantics.AccessibilityAction) r0
            if (r0 == 0) goto L_0x067e
            kotlin.Function r0 = r0.getAction()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            if (r0 == 0) goto L_0x067e
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            goto L_0x067f
        L_0x067e:
            r10 = 0
        L_0x067f:
            return r10
        L_0x0680:
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r11.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r3 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getCustomActions()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            java.util.List r2 = (java.util.List) r2
            if (r2 != 0) goto L_0x0694
            r2 = 0
            return r2
        L_0x0694:
            r3 = r2
            r4 = 0
            r5 = 0
            int r6 = r3.size()
        L_0x069c:
            if (r5 >= r6) goto L_0x06c4
            java.lang.Object r10 = r3.get(r5)
            r12 = r10
            androidx.compose.ui.semantics.CustomAccessibilityAction r12 = (androidx.compose.ui.semantics.CustomAccessibilityAction) r12
            r13 = 0
            java.lang.String r14 = r12.getLabel()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r0)
            if (r14 == 0) goto L_0x06bf
            kotlin.jvm.functions.Function0 r6 = r12.getAction()
            java.lang.Object r6 = r6.invoke()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            return r6
        L_0x06bf:
            int r5 = r5 + 1
            goto L_0x069c
        L_0x06c4:
            r3 = 0
            return r3
        L_0x06c7:
            r3 = 0
        L_0x06c8:
            return r3
        L_0x06c9:
            r1 = r23
            r3 = r10
        L_0x06cc:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.performActionHelper(int, int, android.os.Bundle):boolean");
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange $this$performActionHelper_u24canScroll, float amount) {
        return (amount < 0.0f && $this$performActionHelper_u24canScroll.getValue().invoke().floatValue() > 0.0f) || (amount > 0.0f && $this$performActionHelper_u24canScroll.getValue().invoke().floatValue() < $this$performActionHelper_u24canScroll.getMaxValue().invoke().floatValue());
    }

    private static final float performActionHelper$scrollDelta(float a, float b) {
        if (Math.signum(a) == Math.signum(b)) {
            return Math.abs(a) < Math.abs(b) ? a : b;
        }
        return 0.0f;
    }

    /* access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey, Bundle arguments) {
        SemanticsNode node;
        String str = extraDataKey;
        Bundle bundle = arguments;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes$ui_release().get(Integer.valueOf(virtualViewId));
        if (semanticsNodeWithAdjustedBounds != null && (node = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null) {
            String text = getIterableTextForAccessibility(node);
            if (Intrinsics.areEqual((Object) str, (Object) this.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL)) {
                Integer it = this.idToBeforeMap.get(Integer.valueOf(virtualViewId));
                if (it != null) {
                    info.getExtras().putInt(str, it.intValue());
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) this.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL)) {
                Integer it2 = this.idToAfterMap.get(Integer.valueOf(virtualViewId));
                if (it2 != null) {
                    info.getExtras().putInt(str, it2.intValue());
                }
            } else if (node.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && bundle != null && Intrinsics.areEqual((Object) str, (Object) "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
                int positionInfoStartIndex = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
                int positionInfoLength = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
                if (positionInfoLength > 0 && positionInfoStartIndex >= 0) {
                    if (positionInfoStartIndex < (text != null ? text.length() : Integer.MAX_VALUE)) {
                        List textLayoutResults = new ArrayList();
                        Function1 function1 = (Function1) ((AccessibilityAction) node.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getGetTextLayoutResult())).getAction();
                        if (Intrinsics.areEqual((Object) function1 != null ? (Boolean) function1.invoke(textLayoutResults) : null, (Object) true)) {
                            TextLayoutResult textLayoutResult = (TextLayoutResult) textLayoutResults.get(0);
                            List boundingRects = new ArrayList();
                            for (int i = 0; i < positionInfoLength; i++) {
                                if (positionInfoStartIndex + i >= textLayoutResult.getLayoutInput().getText().length()) {
                                    boundingRects.add((Object) null);
                                } else {
                                    boundingRects.add(toScreenCoords(node, textLayoutResult.getBoundingBox(positionInfoStartIndex + i)));
                                }
                            }
                            info.getExtras().putParcelableArray(str, (Parcelable[]) boundingRects.toArray(new RectF[0]));
                            return;
                        }
                        return;
                    }
                }
                Log.e(LogTag, "Invalid arguments for accessibility character locations");
            } else if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTestTag()) && bundle != null && Intrinsics.areEqual((Object) str, (Object) ExtraDataTestTagKey)) {
                String testTag = (String) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getTestTag());
                if (testTag != null) {
                    info.getExtras().putCharSequence(str, testTag);
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) ExtraDataIdKey)) {
                info.getExtras().putInt(str, node.getId());
            }
        }
    }

    private final RectF toScreenCoords(SemanticsNode textNode, Rect bounds) {
        Rect visibleBounds;
        if (textNode == null) {
            return null;
        }
        Rect boundsInRoot = bounds.m4750translatek4lQ0M(textNode.m6880getPositionInRootF1C5BW0());
        Rect textNodeBoundsInRoot = textNode.getBoundsInRoot();
        if (boundsInRoot.overlaps(textNodeBoundsInRoot)) {
            visibleBounds = boundsInRoot.intersect(textNodeBoundsInRoot);
        } else {
            visibleBounds = null;
        }
        if (visibleBounds == null) {
            return null;
        }
        long topLeftInScreen = this.view.m6755localToScreenMKHz9U(OffsetKt.Offset(visibleBounds.getLeft(), visibleBounds.getTop()));
        long bottomRightInScreen = this.view.m6755localToScreenMKHz9U(OffsetKt.Offset(visibleBounds.getRight(), visibleBounds.getBottom()));
        return new RectF(Offset.m4713getXimpl(topLeftInScreen), Offset.m4714getYimpl(topLeftInScreen), Offset.m4713getXimpl(bottomRightInScreen), Offset.m4714getYimpl(bottomRightInScreen));
    }

    public final boolean dispatchHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (!isTouchExplorationEnabled()) {
            return false;
        }
        switch (event.getAction()) {
            case 7:
            case 9:
                int virtualViewId = hitTestSemanticsAt$ui_release(event.getX(), event.getY());
                boolean handled = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
                updateHoveredVirtualView(virtualViewId);
                if (virtualViewId == Integer.MIN_VALUE) {
                    return handled;
                }
                return true;
            case 10:
                if (this.hoveredVirtualViewId == Integer.MIN_VALUE) {
                    return this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
                }
                updateHoveredVirtualView(Integer.MIN_VALUE);
                return true;
            default:
                return false;
        }
    }

    public final int hitTestSemanticsAt$ui_release(float x, float y) {
        NodeChain nodes$ui_release;
        boolean z = true;
        LayoutNode layoutNode = null;
        Owner.measureAndLayout$default(this.view, false, 1, (Object) null);
        HitTestResult hitSemanticsEntities = new HitTestResult();
        LayoutNode.m6537hitTestSemanticsM_7yMNQ$ui_release$default(this.view.getRoot(), OffsetKt.Offset(x, y), hitSemanticsEntities, false, false, 12, (Object) null);
        Modifier.Node node = (Modifier.Node) CollectionsKt.lastOrNull(hitSemanticsEntities);
        if (node != null) {
            layoutNode = DelegatableNodeKt.requireLayoutNode(node);
        }
        if (layoutNode == null || (nodes$ui_release = layoutNode.getNodes$ui_release()) == null || !nodes$ui_release.m6616hasH91voCI$ui_release(NodeKind.m6666constructorimpl(8))) {
            z = false;
        }
        if (!z || !AndroidComposeViewAccessibilityDelegateCompat_androidKt.isVisible(SemanticsNodeKt.SemanticsNode(layoutNode, false)) || this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(layoutNode) != null) {
            return Integer.MIN_VALUE;
        }
        return semanticsNodeIdToAccessibilityVirtualNodeId(layoutNode.getSemanticsId());
    }

    private final void updateHoveredVirtualView(int virtualViewId) {
        if (this.hoveredVirtualViewId != virtualViewId) {
            int previousVirtualViewId = this.hoveredVirtualViewId;
            this.hoveredVirtualViewId = virtualViewId;
            sendEventForVirtualView$default(this, virtualViewId, 128, (Integer) null, (List) null, 12, (Object) null);
            sendEventForVirtualView$default(this, previousVirtualViewId, 256, (Integer) null, (List) null, 12, (Object) null);
        }
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        Intrinsics.checkNotNullParameter(host, "host");
        return this.nodeProvider;
    }

    private final <T extends CharSequence> T trimToSize(T text, int size) {
        boolean z = true;
        if (size > 0) {
            int len = size;
            if (!(text == null || text.length() == 0)) {
                z = false;
            }
            if (z || text.length() <= size) {
                return text;
            }
            if (Character.isHighSurrogate(text.charAt(size - 1)) && Character.isLowSurrogate(text.charAt(size))) {
                len = size - 1;
            }
            T subSequence = text.subSequence(0, len);
            Intrinsics.checkNotNull(subSequence, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
            return subSequence;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* access modifiers changed from: private */
    public static final void semanticsChangeChecker$lambda$44(AndroidComposeViewAccessibilityDelegateCompat this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Owner.measureAndLayout$default(this$0.view, false, 1, (Object) null);
        this$0.checkForSemanticsChanges();
        this$0.checkingForSemanticsChanges = false;
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release() && !this.checkingForSemanticsChanges) {
            this.checkingForSemanticsChanges = true;
            this.handler.post(this.semanticsChangeChecker);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object boundsUpdatesEventLoop(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 r0 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 r0 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1
            r0.<init>(r10, r11)
        L_0x0019:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x0057;
                case 1: goto L_0x0042;
                case 2: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x002e:
            java.lang.Object r2 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r4 = r11.L$1
            androidx.collection.ArraySet r4 = (androidx.collection.ArraySet) r4
            java.lang.Object r5 = r11.L$0
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r5 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat) r5
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00ed }
            r9 = r4
            r4 = r2
            r2 = r9
            goto L_0x00dd
        L_0x0042:
            java.lang.Object r2 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r4 = r11.L$1
            androidx.collection.ArraySet r4 = (androidx.collection.ArraySet) r4
            java.lang.Object r5 = r11.L$0
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r5 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat) r5
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00ed }
            r6 = r5
            r5 = r4
            r4 = r2
            r2 = r1
            r1 = r0
            goto L_0x007c
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r0)
            r5 = r10
            androidx.collection.ArraySet r2 = new androidx.collection.ArraySet     // Catch:{ all -> 0x00ed }
            r2.<init>()     // Catch:{ all -> 0x00ed }
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r4 = r5.boundsUpdateChannel     // Catch:{ all -> 0x00ed }
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()     // Catch:{ all -> 0x00ed }
        L_0x0067:
            r11.L$0 = r5     // Catch:{ all -> 0x00ed }
            r11.L$1 = r2     // Catch:{ all -> 0x00ed }
            r11.L$2 = r4     // Catch:{ all -> 0x00ed }
            r11.label = r3     // Catch:{ all -> 0x00ed }
            java.lang.Object r6 = r4.hasNext(r11)     // Catch:{ all -> 0x00ed }
            if (r6 != r1) goto L_0x0076
            return r1
        L_0x0076:
            r9 = r1
            r1 = r0
            r0 = r6
            r6 = r5
            r5 = r2
            r2 = r9
        L_0x007c:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00e7 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00e7 }
            if (r0 == 0) goto L_0x00de
            r4.next()     // Catch:{ all -> 0x00e7 }
            boolean r0 = r6.isEnabledForContentCapture()     // Catch:{ all -> 0x00e7 }
            if (r0 == 0) goto L_0x0090
            r6.notifyContentCaptureChanges()     // Catch:{ all -> 0x00e7 }
        L_0x0090:
            boolean r0 = r6.isEnabledForAccessibility()     // Catch:{ all -> 0x00e7 }
            if (r0 == 0) goto L_0x00c2
            r0 = 0
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r7 = r6.subtreeChangedLayoutNodes     // Catch:{ all -> 0x00e7 }
            int r7 = r7.size()     // Catch:{ all -> 0x00e7 }
        L_0x009d:
            if (r0 >= r7) goto L_0x00b2
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r8 = r6.subtreeChangedLayoutNodes     // Catch:{ all -> 0x00e7 }
            java.lang.Object r8 = r8.valueAt(r0)     // Catch:{ all -> 0x00e7 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)     // Catch:{ all -> 0x00e7 }
            androidx.compose.ui.node.LayoutNode r8 = (androidx.compose.ui.node.LayoutNode) r8     // Catch:{ all -> 0x00e7 }
            r6.sendSubtreeChangeAccessibilityEvents(r8, r5)     // Catch:{ all -> 0x00e7 }
            int r0 = r0 + 1
            goto L_0x009d
        L_0x00b2:
            r5.clear()     // Catch:{ all -> 0x00e7 }
            boolean r0 = r6.checkingForSemanticsChanges     // Catch:{ all -> 0x00e7 }
            if (r0 != 0) goto L_0x00c2
            r6.checkingForSemanticsChanges = r3     // Catch:{ all -> 0x00e7 }
            android.os.Handler r0 = r6.handler     // Catch:{ all -> 0x00e7 }
            java.lang.Runnable r7 = r6.semanticsChangeChecker     // Catch:{ all -> 0x00e7 }
            r0.post(r7)     // Catch:{ all -> 0x00e7 }
        L_0x00c2:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r0 = r6.subtreeChangedLayoutNodes     // Catch:{ all -> 0x00e7 }
            r0.clear()     // Catch:{ all -> 0x00e7 }
            r11.L$0 = r6     // Catch:{ all -> 0x00e7 }
            r11.L$1 = r5     // Catch:{ all -> 0x00e7 }
            r11.L$2 = r4     // Catch:{ all -> 0x00e7 }
            r0 = 2
            r11.label = r0     // Catch:{ all -> 0x00e7 }
            r7 = 100
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r7, r11)     // Catch:{ all -> 0x00e7 }
            if (r0 != r2) goto L_0x00d9
            return r2
        L_0x00d9:
            r0 = r1
            r1 = r2
            r2 = r5
            r5 = r6
        L_0x00dd:
            goto L_0x0067
        L_0x00de:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r0 = r6.subtreeChangedLayoutNodes
            r0.clear()
            r0 = r6
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        L_0x00e7:
            r0 = move-exception
            r5 = r6
            r9 = r1
            r1 = r0
            r0 = r9
            goto L_0x00ee
        L_0x00ed:
            r1 = move-exception
        L_0x00ee:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r2 = r5.subtreeChangedLayoutNodes
            r2.clear()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release()) {
            notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
    }

    private final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.m1676trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, ArraySet<Integer> subtreeChangedSemanticsNodesIds) {
        LayoutNode layoutNode2;
        SemanticsConfiguration config;
        LayoutNode it;
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            if (layoutNode.getNodes$ui_release().m6616hasH91voCI$ui_release(NodeKind.m6666constructorimpl(8))) {
                layoutNode2 = layoutNode;
            } else {
                layoutNode2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.INSTANCE);
            }
            LayoutNode layoutNode3 = layoutNode2;
            if (layoutNode3 != null && (config = layoutNode3.getCollapsedSemantics$ui_release()) != null) {
                if (!config.isMergingSemanticsOfDescendants() && (it = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode3, AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE)) != null) {
                    layoutNode3 = it;
                }
                if (layoutNode3 != null) {
                    int id = layoutNode3.getSemanticsId();
                    if (subtreeChangedSemanticsNodesIds.add(Integer.valueOf(id))) {
                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 1, (List) null, 8, (Object) null);
                    }
                }
            }
        }
    }

    private final void checkForSemanticsChanges() {
        sendAccessibilitySemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
        sendContentCaptureSemanticsStructureChangeEvents$ui_release(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
        sendSemanticsPropertyChangeEvents$ui_release(getCurrentSemanticsNodes$ui_release());
        updateSemanticsNodesCopyAndPanes();
    }

    private final void updateSemanticsNodesCopyAndPanes() {
        SemanticsConfiguration unmergedConfig;
        ArraySet toRemove = new ArraySet();
        Iterator<Integer> it = this.paneDisplayed.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes$ui_release().get(id);
            String str = null;
            SemanticsNode currentNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
            if (currentNode == null || !AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(currentNode)) {
                toRemove.add(id);
                Intrinsics.checkNotNullExpressionValue(id, "id");
                int intValue = id.intValue();
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(id);
                if (!(semanticsNodeCopy == null || (unmergedConfig = semanticsNodeCopy.getUnmergedConfig()) == null)) {
                    str = (String) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getPaneTitle());
                }
                sendPaneChangeEvents(intValue, 32, str);
            }
        }
        this.paneDisplayed.removeAll(toRemove);
        this.previousSemanticsNodes.clear();
        for (Map.Entry entry : getCurrentSemanticsNodes$ui_release().entrySet()) {
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(((SemanticsNodeWithAdjustedBounds) entry.getValue()).getSemanticsNode()) && this.paneDisplayed.add(entry.getKey())) {
                sendPaneChangeEvents(((Number) entry.getKey()).intValue(), 16, (String) ((SemanticsNodeWithAdjustedBounds) entry.getValue()).getSemanticsNode().getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getPaneTitle()));
            }
            this.previousSemanticsNodes.put(entry.getKey(), new SemanticsNodeCopy(((SemanticsNodeWithAdjustedBounds) entry.getValue()).getSemanticsNode(), getCurrentSemanticsNodes$ui_release()));
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes$ui_release());
    }

    public final void sendSemanticsPropertyChangeEvents$ui_release(Map<Integer, SemanticsNodeWithAdjustedBounds> newSemanticsNodes) {
        boolean newlyObservingScroll;
        boolean z;
        String text;
        int endCount;
        AccessibilityEvent accessibilityEvent;
        Map<Integer, SemanticsNodeWithAdjustedBounds> map = newSemanticsNodes;
        Intrinsics.checkNotNullParameter(map, "newSemanticsNodes");
        ArrayList oldScrollObservationScopes = new ArrayList(this.scrollObservationScopes);
        this.scrollObservationScopes.clear();
        for (Integer intValue : newSemanticsNodes.keySet()) {
            int id = intValue.intValue();
            SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(Integer.valueOf(id));
            if (semanticsNodeCopy != null) {
                SemanticsNodeCopy oldNode = semanticsNodeCopy;
                SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = map.get(Integer.valueOf(id));
                SemanticsNode newNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                Intrinsics.checkNotNull(newNode);
                Iterator<Map.Entry<SemanticsPropertyKey<?>, Object>> it = newNode.getUnmergedConfig$ui_release().iterator();
                boolean propertyChanged = false;
                while (true) {
                    boolean z2 = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry entry = it.next();
                    if (Intrinsics.areEqual(entry.getKey(), (Object) SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()) || Intrinsics.areEqual(entry.getKey(), (Object) SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())) {
                        newlyObservingScroll = registerScrollingId(id, oldScrollObservationScopes);
                    } else {
                        newlyObservingScroll = false;
                    }
                    if (newlyObservingScroll || !Intrinsics.areEqual(entry.getValue(), SemanticsConfigurationKt.getOrNull(oldNode.getUnmergedConfig(), (SemanticsPropertyKey) entry.getKey()))) {
                        SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) entry.getKey();
                        if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getText())) {
                            List list = (List) SemanticsConfigurationKt.getOrNull(oldNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
                            AnnotatedString oldText = list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null;
                            List list2 = (List) SemanticsConfigurationKt.getOrNull(newNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
                            AnnotatedString newText = list2 != null ? (AnnotatedString) CollectionsKt.firstOrNull(list2) : null;
                            if (!Intrinsics.areEqual((Object) oldText, (Object) newText)) {
                                sendContentCaptureTextUpdateEvent(newNode.getId(), String.valueOf(newText));
                            }
                        } else if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getPaneTitle())) {
                            Object value = entry.getValue();
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                            String paneTitle = (String) value;
                            if (oldNode.hasPaneTitle()) {
                                sendPaneChangeEvents(id, 8, paneTitle);
                            }
                        } else {
                            if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getStateDescription()) ? true : Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getToggleableState())) {
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 64, (List) null, 8, (Object) null);
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, (List) null, 8, (Object) null);
                            } else if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getProgressBarRangeInfo())) {
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 64, (List) null, 8, (Object) null);
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, (List) null, 8, (Object) null);
                            } else if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getSelected())) {
                                Role role = (Role) SemanticsConfigurationKt.getOrNull(newNode.getConfig(), SemanticsProperties.INSTANCE.getRole());
                                if (!(role == null ? false : Role.m6868equalsimpl0(role.m6871unboximpl(), Role.Companion.m6878getTabo7Vup1c()))) {
                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 64, (List) null, 8, (Object) null);
                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, (List) null, 8, (Object) null);
                                } else if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(newNode.getConfig(), SemanticsProperties.INSTANCE.getSelected()), (Object) true)) {
                                    AccessibilityEvent event = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(id), 4);
                                    SemanticsNode mergedNode = newNode.copyWithMergingEnabled$ui_release();
                                    List list3 = (List) SemanticsConfigurationKt.getOrNull(mergedNode.getConfig(), SemanticsProperties.INSTANCE.getContentDescription());
                                    String contentDescription = list3 != null ? TempListUtilsKt.fastJoinToString$default(list3, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : null;
                                    List list4 = (List) SemanticsConfigurationKt.getOrNull(mergedNode.getConfig(), SemanticsProperties.INSTANCE.getText());
                                    String text2 = list4 != null ? TempListUtilsKt.fastJoinToString$default(list4, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : null;
                                    if (contentDescription != null) {
                                        event.setContentDescription(contentDescription);
                                    }
                                    if (text2 != null) {
                                        event.getText().add(text2);
                                    }
                                    sendEvent(event);
                                } else {
                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, (List) null, 8, (Object) null);
                                }
                            } else if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getContentDescription())) {
                                int semanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(id);
                                Object value2 = entry.getValue();
                                Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                                sendEventForVirtualView(semanticsNodeIdToAccessibilityVirtualNodeId, 2048, 4, (List) value2);
                            } else {
                                String str = "";
                                if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getEditableText())) {
                                    if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(newNode)) {
                                        AnnotatedString textForTextField = getTextForTextField(oldNode.getUnmergedConfig());
                                        CharSequence oldText2 = textForTextField != null ? textForTextField : str;
                                        AnnotatedString textForTextField2 = getTextForTextField(newNode.getUnmergedConfig$ui_release());
                                        CharSequence newText2 = textForTextField2 != null ? textForTextField2 : str;
                                        CharSequence trimmedNewText = trimToSize(newText2, ParcelSafeTextLength);
                                        int startCount = 0;
                                        int endCount2 = 0;
                                        int oldTextLen = oldText2.length();
                                        int newTextLen = newText2.length();
                                        int minLength = RangesKt.coerceAtMost(oldTextLen, newTextLen);
                                        while (true) {
                                            if (startCount >= minLength) {
                                                endCount = endCount2;
                                                break;
                                            }
                                            endCount = endCount2;
                                            if (oldText2.charAt(startCount) != newText2.charAt(startCount)) {
                                                break;
                                            }
                                            startCount++;
                                            endCount2 = endCount;
                                        }
                                        int endCount3 = endCount;
                                        while (true) {
                                            if (endCount3 >= minLength - startCount) {
                                                break;
                                            }
                                            int minLength2 = minLength;
                                            if (oldText2.charAt((oldTextLen - 1) - endCount3) != newText2.charAt((newTextLen - 1) - endCount3)) {
                                                break;
                                            }
                                            endCount3++;
                                            minLength = minLength2;
                                        }
                                        int removedCount = (oldTextLen - endCount3) - startCount;
                                        int addedCount = (newTextLen - endCount3) - startCount;
                                        boolean becamePasswordNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(oldNode.getSemanticsNode()) && !AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(oldNode.getSemanticsNode()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(newNode);
                                        boolean becameNotPasswordNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(oldNode.getSemanticsNode()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(oldNode.getSemanticsNode()) && !AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(newNode);
                                        if (becamePasswordNode) {
                                            int i = oldTextLen;
                                            int i2 = endCount3;
                                        } else if (becameNotPasswordNode) {
                                            int i3 = startCount;
                                            int i4 = oldTextLen;
                                            int i5 = endCount3;
                                        } else {
                                            int i6 = oldTextLen;
                                            int i7 = endCount3;
                                            accessibilityEvent = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(id), 16);
                                            AccessibilityEvent $this$sendSemanticsPropertyChangeEvents_u24lambda_u2448 = accessibilityEvent;
                                            $this$sendSemanticsPropertyChangeEvents_u24lambda_u2448.setFromIndex(startCount);
                                            $this$sendSemanticsPropertyChangeEvents_u24lambda_u2448.setRemovedCount(removedCount);
                                            $this$sendSemanticsPropertyChangeEvents_u24lambda_u2448.setAddedCount(addedCount);
                                            $this$sendSemanticsPropertyChangeEvents_u24lambda_u2448.setBeforeText(oldText2);
                                            int i8 = startCount;
                                            $this$sendSemanticsPropertyChangeEvents_u24lambda_u2448.getText().add(trimmedNewText);
                                            int i9 = addedCount;
                                            CharSequence charSequence = trimmedNewText;
                                            CharSequence charSequence2 = newText2;
                                            AccessibilityEvent event2 = accessibilityEvent;
                                            event2.setClassName(TextFieldClassName);
                                            sendEvent(event2);
                                            if (becamePasswordNode || becameNotPasswordNode) {
                                                long textRange = ((TextRange) newNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m7039unboximpl();
                                                event2.setFromIndex(TextRange.m7035getStartimpl(textRange));
                                                event2.setToIndex(TextRange.m7030getEndimpl(textRange));
                                                sendEvent(event2);
                                            }
                                        }
                                        int i10 = addedCount;
                                        CharSequence charSequence3 = newText2;
                                        accessibilityEvent = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(id), (Integer) null, (Integer) null, Integer.valueOf(newTextLen), trimmedNewText);
                                        AccessibilityEvent event22 = accessibilityEvent;
                                        event22.setClassName(TextFieldClassName);
                                        sendEvent(event22);
                                        long textRange2 = ((TextRange) newNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m7039unboximpl();
                                        event22.setFromIndex(TextRange.m7035getStartimpl(textRange2));
                                        event22.setToIndex(TextRange.m7030getEndimpl(textRange2));
                                        sendEvent(event22);
                                    } else {
                                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 2, (List) null, 8, (Object) null);
                                    }
                                } else if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getTextSelectionRange())) {
                                    AnnotatedString textForTextField3 = getTextForTextField(newNode.getUnmergedConfig$ui_release());
                                    if (!(textForTextField3 == null || (text = textForTextField3.getText()) == null)) {
                                        str = text;
                                    }
                                    String newText3 = str;
                                    long textRange3 = ((TextRange) newNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m7039unboximpl();
                                    sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(id), Integer.valueOf(TextRange.m7035getStartimpl(textRange3)), Integer.valueOf(TextRange.m7030getEndimpl(textRange3)), Integer.valueOf(newText3.length()), trimToSize(newText3, ParcelSafeTextLength)));
                                    sendPendingTextTraversedAtGranularityEvent(newNode.getId());
                                } else {
                                    if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange())) {
                                        z = true;
                                    } else {
                                        z = Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
                                    }
                                    if (z) {
                                        notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode$ui_release());
                                        ScrollObservationScope scope = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(this.scrollObservationScopes, id);
                                        Intrinsics.checkNotNull(scope);
                                        scope.setHorizontalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(newNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()));
                                        scope.setVerticalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(newNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange()));
                                        sendScrollEventIfNeeded(scope);
                                    } else if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsProperties.INSTANCE.getFocused())) {
                                        Object value3 = entry.getValue();
                                        Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.Boolean");
                                        if (((Boolean) value3).booleanValue()) {
                                            sendEvent(createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(newNode.getId()), 8));
                                        }
                                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(newNode.getId()), 2048, 0, (List) null, 8, (Object) null);
                                    } else if (Intrinsics.areEqual((Object) semanticsPropertyKey, (Object) SemanticsActions.INSTANCE.getCustomActions())) {
                                        List actions = (List) newNode.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getCustomActions());
                                        List oldActions = (List) SemanticsConfigurationKt.getOrNull(oldNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCustomActions());
                                        if (oldActions != null) {
                                            Set labels = new LinkedHashSet();
                                            List $this$fastForEach$iv = actions;
                                            int index$iv = 0;
                                            int size = $this$fastForEach$iv.size();
                                            while (index$iv < size) {
                                                labels.add(((CustomAccessibilityAction) $this$fastForEach$iv.get(index$iv)).getLabel());
                                                index$iv++;
                                                $this$fastForEach$iv = $this$fastForEach$iv;
                                            }
                                            Set oldLabels = new LinkedHashSet();
                                            List $this$fastForEach$iv2 = oldActions;
                                            int index$iv2 = 0;
                                            int size2 = $this$fastForEach$iv2.size();
                                            while (index$iv2 < size2) {
                                                oldLabels.add(((CustomAccessibilityAction) $this$fastForEach$iv2.get(index$iv2)).getLabel());
                                                index$iv2++;
                                                oldActions = oldActions;
                                            }
                                            if (!labels.containsAll(oldLabels) || !oldLabels.containsAll(labels)) {
                                                z2 = true;
                                            }
                                            propertyChanged = z2;
                                            Map<Integer, SemanticsNodeWithAdjustedBounds> map2 = newSemanticsNodes;
                                        } else {
                                            if (!actions.isEmpty()) {
                                                propertyChanged = true;
                                                Map<Integer, SemanticsNodeWithAdjustedBounds> map3 = newSemanticsNodes;
                                            }
                                        }
                                    } else if (entry.getValue() instanceof AccessibilityAction) {
                                        Object value4 = entry.getValue();
                                        Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                                        propertyChanged = !AndroidComposeViewAccessibilityDelegateCompat_androidKt.accessibilityEquals((AccessibilityAction) value4, SemanticsConfigurationKt.getOrNull(oldNode.getUnmergedConfig(), (SemanticsPropertyKey) entry.getKey()));
                                        Map<Integer, SemanticsNodeWithAdjustedBounds> map4 = newSemanticsNodes;
                                    } else {
                                        propertyChanged = true;
                                        Map<Integer, SemanticsNodeWithAdjustedBounds> map5 = newSemanticsNodes;
                                    }
                                }
                            }
                        }
                    }
                    Map<Integer, SemanticsNodeWithAdjustedBounds> map6 = newSemanticsNodes;
                }
                if (!propertyChanged) {
                    propertyChanged = AndroidComposeViewAccessibilityDelegateCompat_androidKt.propertiesDeleted(newNode, oldNode);
                }
                if (propertyChanged) {
                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, (List) null, 8, (Object) null);
                    map = newSemanticsNodes;
                } else {
                    map = newSemanticsNodes;
                }
            }
        }
    }

    private final void sendContentCaptureTextUpdateEvent(int id, String newText) {
        ContentCaptureSessionCompat session = this.contentCaptureSession;
        if (session != null) {
            AutofillId autofillId = session.newAutofillId((long) id);
            if (autofillId != null) {
                session.notifyViewTextChanged(autofillId, newText);
                return;
            }
            throw new IllegalStateException("Invalid content capture ID".toString());
        }
    }

    private final boolean registerScrollingId(int id, List<ScrollObservationScope> oldScrollObservationScopes) {
        ScrollObservationScope newScope;
        boolean newlyObservingScroll = false;
        ScrollObservationScope oldScope = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(oldScrollObservationScopes, id);
        if (oldScope != null) {
            newScope = oldScope;
        } else {
            newlyObservingScroll = true;
            newScope = new ScrollObservationScope(id, this.scrollObservationScopes, (Float) null, (Float) null, (ScrollAxisRange) null, (ScrollAxisRange) null);
        }
        this.scrollObservationScopes.add(newScope);
        return newlyObservingScroll;
    }

    /* access modifiers changed from: private */
    public final void sendScrollEventIfNeeded(ScrollObservationScope scrollObservationScope) {
        if (scrollObservationScope.isValidOwnerScope()) {
            this.view.getSnapshotObserver().observeReads$ui_release(scrollObservationScope, this.sendScrollEventIfNeededLambda, new AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeeded$1(scrollObservationScope, this));
        }
    }

    private final void sendPaneChangeEvents(int semanticsNodeId, int contentChangeType, String title) {
        AccessibilityEvent event = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNodeId), 32);
        event.setContentChangeTypes(contentChangeType);
        if (title != null) {
            event.getText().add(title);
        }
        sendEvent(event);
    }

    /* access modifiers changed from: private */
    public final ContentCaptureSessionCompat getContentCaptureSessionCompat(View $this$getContentCaptureSessionCompat) {
        ViewCompatShims.setImportantForContentCapture($this$getContentCaptureSessionCompat, 1);
        return ViewCompatShims.getContentCaptureSession($this$getContentCaptureSessionCompat);
    }

    private final ViewStructureCompat toViewStructure(SemanticsNode $this$toViewStructure) {
        AutofillIdCompat rootAutofillId;
        AutofillId parentAutofillId;
        String it;
        ContentCaptureSessionCompat session = this.contentCaptureSession;
        if (session == null || (rootAutofillId = ViewCompatShims.getAutofillId(this.view)) == null) {
            return null;
        }
        SemanticsNode parentNode = $this$toViewStructure.getParent();
        if (parentNode != null) {
            parentAutofillId = session.newAutofillId((long) parentNode.getId());
            if (parentAutofillId == null) {
                return null;
            }
        } else {
            parentAutofillId = rootAutofillId.toAutofillId();
        }
        Intrinsics.checkNotNullExpressionValue(parentAutofillId, "if (parentNode != null) ….toAutofillId()\n        }");
        ViewStructureCompat structure = session.newVirtualViewStructure(parentAutofillId, (long) $this$toViewStructure.getId());
        if (structure == null) {
            return null;
        }
        SemanticsConfiguration configuration = $this$toViewStructure.getUnmergedConfig$ui_release();
        if (configuration.contains(SemanticsProperties.INSTANCE.getPassword())) {
            return null;
        }
        List it2 = (List) SemanticsConfigurationKt.getOrNull(configuration, SemanticsProperties.INSTANCE.getText());
        if (it2 != null) {
            structure.setClassName(TextClassName);
            structure.setText(TempListUtilsKt.fastJoinToString$default(it2, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        AnnotatedString it3 = (AnnotatedString) SemanticsConfigurationKt.getOrNull(configuration, SemanticsProperties.INSTANCE.getEditableText());
        if (it3 != null) {
            structure.setClassName(TextFieldClassName);
            structure.setText(it3);
        }
        List it4 = (List) SemanticsConfigurationKt.getOrNull(configuration, SemanticsProperties.INSTANCE.getContentDescription());
        if (it4 != null) {
            structure.setContentDescription(TempListUtilsKt.fastJoinToString$default(it4, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        Role role = (Role) SemanticsConfigurationKt.getOrNull(configuration, SemanticsProperties.INSTANCE.getRole());
        if (!(role == null || (it = AndroidComposeViewAccessibilityDelegateCompat_androidKt.m6767toLegacyClassNameV4PA4sw(role.m6871unboximpl())) == null)) {
            structure.setClassName(it);
        }
        Rect $this$toViewStructure_u24lambda_u2456 = $this$toViewStructure.getBoundsInWindow();
        structure.setDimens((int) $this$toViewStructure_u24lambda_u2456.getLeft(), (int) $this$toViewStructure_u24lambda_u2456.getTop(), 0, 0, (int) $this$toViewStructure_u24lambda_u2456.getWidth(), (int) $this$toViewStructure_u24lambda_u2456.getHeight());
        return structure;
    }

    private final void bufferContentCaptureViewAppeared(int virtualId, ViewStructureCompat viewStructure) {
        if (viewStructure != null) {
            if (this.bufferedContentCaptureDisappearedNodes.contains(Integer.valueOf(virtualId))) {
                this.bufferedContentCaptureDisappearedNodes.remove(Integer.valueOf(virtualId));
                return;
            }
            this.bufferedContentCaptureAppearedNodes.put(Integer.valueOf(virtualId), viewStructure);
        }
    }

    private final void bufferContentCaptureViewDisappeared(int virtualId) {
        if (this.bufferedContentCaptureAppearedNodes.containsKey(Integer.valueOf(virtualId))) {
            this.bufferedContentCaptureAppearedNodes.remove(Integer.valueOf(virtualId));
        } else {
            this.bufferedContentCaptureDisappearedNodes.add(Integer.valueOf(virtualId));
        }
    }

    private final void notifyContentCaptureChanges() {
        ContentCaptureSessionCompat session = this.contentCaptureSession;
        if (session != null) {
            if (!this.bufferedContentCaptureAppearedNodes.isEmpty()) {
                Collection<ViewStructureCompat> values = this.bufferedContentCaptureAppearedNodes.values();
                Intrinsics.checkNotNullExpressionValue(values, "bufferedContentCaptureAppearedNodes.values");
                List $this$fastMap$iv = CollectionsKt.toList(values);
                List target$iv = new ArrayList($this$fastMap$iv.size());
                List $this$fastForEach$iv$iv = $this$fastMap$iv;
                int size = $this$fastForEach$iv$iv.size();
                for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                    target$iv.add(((ViewStructureCompat) $this$fastForEach$iv$iv.get(index$iv$iv)).toViewStructure());
                }
                session.notifyViewsAppeared(target$iv);
                this.bufferedContentCaptureAppearedNodes.clear();
            }
            if (!this.bufferedContentCaptureDisappearedNodes.isEmpty()) {
                List $this$fastMap$iv2 = CollectionsKt.toList(this.bufferedContentCaptureDisappearedNodes);
                List target$iv2 = new ArrayList($this$fastMap$iv2.size());
                List $this$fastForEach$iv$iv2 = $this$fastMap$iv2;
                int size2 = $this$fastForEach$iv$iv2.size();
                for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                    target$iv2.add(Long.valueOf((long) ((Integer) $this$fastForEach$iv$iv2.get(index$iv$iv2)).intValue()));
                }
                session.notifyViewsDisappeared(CollectionsKt.toLongArray(target$iv2));
                this.bufferedContentCaptureDisappearedNodes.clear();
            }
        }
    }

    private final void notifySubtreeAppeared(SemanticsNode node) {
        bufferContentCaptureViewAppeared(node.getId(), toViewStructure(node));
        List $this$fastForEach$iv = node.getReplacedChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            notifySubtreeAppeared($this$fastForEach$iv.get(index$iv));
        }
    }

    private final void sendAccessibilitySemanticsStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        Set newChildren = new LinkedHashSet();
        List $this$fastForEach$iv = newNode.getReplacedChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            SemanticsNode child = $this$fastForEach$iv.get(index$iv);
            if (getCurrentSemanticsNodes$ui_release().containsKey(Integer.valueOf(child.getId()))) {
                if (!oldNode.getChildren().contains(Integer.valueOf(child.getId()))) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode$ui_release());
                    return;
                }
                newChildren.add(Integer.valueOf(child.getId()));
            }
        }
        for (Integer intValue : oldNode.getChildren()) {
            if (!newChildren.contains(Integer.valueOf(intValue.intValue()))) {
                notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode$ui_release());
                return;
            }
        }
        List $this$fastForEach$iv2 = newNode.getReplacedChildren$ui_release();
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            SemanticsNode child2 = $this$fastForEach$iv2.get(index$iv2);
            if (getCurrentSemanticsNodes$ui_release().containsKey(Integer.valueOf(child2.getId()))) {
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(Integer.valueOf(child2.getId()));
                Intrinsics.checkNotNull(semanticsNodeCopy);
                sendAccessibilitySemanticsStructureChangeEvents(child2, semanticsNodeCopy);
            }
        }
    }

    public final void sendContentCaptureSemanticsStructureChangeEvents$ui_release(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        Intrinsics.checkNotNullParameter(newNode, "newNode");
        Intrinsics.checkNotNullParameter(oldNode, "oldNode");
        List $this$fastForEach$iv = newNode.getReplacedChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            SemanticsNode child = $this$fastForEach$iv.get(index$iv);
            if (getCurrentSemanticsNodes$ui_release().containsKey(Integer.valueOf(child.getId())) && !oldNode.getChildren().contains(Integer.valueOf(child.getId()))) {
                notifySubtreeAppeared(child);
            }
        }
        for (Map.Entry entry : this.previousSemanticsNodes.entrySet()) {
            if (!getCurrentSemanticsNodes$ui_release().containsKey(entry.getKey())) {
                bufferContentCaptureViewDisappeared(((Number) entry.getKey()).intValue());
            }
        }
        List $this$fastForEach$iv2 = newNode.getReplacedChildren$ui_release();
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            SemanticsNode child2 = $this$fastForEach$iv2.get(index$iv2);
            if (getCurrentSemanticsNodes$ui_release().containsKey(Integer.valueOf(child2.getId())) && this.previousSemanticsNodes.containsKey(Integer.valueOf(child2.getId()))) {
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(Integer.valueOf(child2.getId()));
                Intrinsics.checkNotNull(semanticsNodeCopy);
                sendContentCaptureSemanticsStructureChangeEvents$ui_release(child2, semanticsNodeCopy);
            }
        }
    }

    /* access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int id) {
        if (id == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return id;
    }

    private final boolean traverseAtGranularity(SemanticsNode node, int granularity, boolean forward, boolean extendSelection) {
        AccessibilityIterators.TextSegmentIterator iterator;
        int selectionStart;
        int selectionEnd;
        int action;
        int id = node.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(node.getId());
        }
        String text = getIterableTextForAccessibility(node);
        CharSequence charSequence = text;
        if ((charSequence == null || charSequence.length() == 0) || (iterator = getIteratorForGranularity(node, granularity)) == null) {
            return false;
        }
        int current = getAccessibilitySelectionEnd(node);
        if (current == -1) {
            current = forward ? 0 : text.length();
        }
        int[] range = forward ? iterator.following(current) : iterator.preceding(current);
        if (range == null) {
            return false;
        }
        int segmentStart = range[0];
        int segmentEnd = range[1];
        if (!extendSelection || !isAccessibilitySelectionExtendable(node)) {
            selectionEnd = forward ? segmentEnd : segmentStart;
            selectionStart = selectionEnd;
        } else {
            int selectionStart2 = getAccessibilitySelectionStart(node);
            if (selectionStart2 == -1) {
                selectionStart2 = forward ? segmentStart : segmentEnd;
            }
            selectionEnd = forward ? segmentEnd : segmentStart;
            selectionStart = selectionStart2;
        }
        if (forward) {
            action = 256;
        } else {
            action = 512;
        }
        String str = text;
        PendingTextTraversedEvent pendingTextTraversedEvent2 = r8;
        PendingTextTraversedEvent pendingTextTraversedEvent3 = new PendingTextTraversedEvent(node, action, granularity, segmentStart, segmentEnd, SystemClock.uptimeMillis());
        this.pendingTextTraversedEvent = pendingTextTraversedEvent2;
        setAccessibilitySelection(node, selectionStart, selectionEnd, true);
        return true;
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int semanticsNodeId) {
        PendingTextTraversedEvent it = this.pendingTextTraversedEvent;
        if (it != null) {
            if (semanticsNodeId == it.getNode().getId()) {
                if (SystemClock.uptimeMillis() - it.getTraverseTime() <= 1000) {
                    AccessibilityEvent event = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(it.getNode().getId()), 131072);
                    event.setFromIndex(it.getFromIndex());
                    event.setToIndex(it.getToIndex());
                    event.setAction(it.getAction());
                    event.setMovementGranularity(it.getGranularity());
                    event.getText().add(getIterableTextForAccessibility(it.getNode()));
                    sendEvent(event);
                }
            } else {
                return;
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    private final boolean setAccessibilitySelection(SemanticsNode node, int start, int end, boolean traversalMode) {
        String text;
        int i;
        boolean nonEmptyText = false;
        if (node.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetSelection()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(node)) {
            Function3 function3 = (Function3) ((AccessibilityAction) node.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getSetSelection())).getAction();
            if (function3 != null) {
                return ((Boolean) function3.invoke(Integer.valueOf(start), Integer.valueOf(end), Boolean.valueOf(traversalMode))).booleanValue();
            }
            return false;
        } else if ((start == end && end == this.accessibilityCursorPosition) || (text = getIterableTextForAccessibility(node)) == null) {
            return false;
        } else {
            if (start < 0 || start != end || end > text.length()) {
                i = -1;
            } else {
                i = start;
            }
            this.accessibilityCursorPosition = i;
            if (text.length() > 0) {
                nonEmptyText = true;
            }
            int semanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(node.getId());
            Integer num = null;
            Integer valueOf = nonEmptyText ? Integer.valueOf(this.accessibilityCursorPosition) : null;
            Integer valueOf2 = nonEmptyText ? Integer.valueOf(this.accessibilityCursorPosition) : null;
            if (nonEmptyText) {
                num = Integer.valueOf(text.length());
            }
            sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId, valueOf, valueOf2, num, text));
            sendPendingTextTraversedAtGranularityEvent(node.getId());
            return true;
        }
    }

    private final int getAccessibilitySelectionStart(SemanticsNode node) {
        if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) || !node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return this.accessibilityCursorPosition;
        }
        return TextRange.m7035getStartimpl(((TextRange) node.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m7039unboximpl());
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode node) {
        if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) || !node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return this.accessibilityCursorPosition;
        }
        return TextRange.m7030getEndimpl(((TextRange) node.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m7039unboximpl());
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode node) {
        return !node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getEditableText());
    }

    private final AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(SemanticsNode node, int granularity) {
        AccessibilityIterators.AbstractTextSegmentIterator iterator;
        if (node == null) {
            return null;
        }
        String text = getIterableTextForAccessibility(node);
        CharSequence charSequence = text;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        switch (granularity) {
            case 1:
                AccessibilityIterators.CharacterTextSegmentIterator.Companion companion = AccessibilityIterators.CharacterTextSegmentIterator.Companion;
                Locale locale = this.view.getContext().getResources().getConfiguration().locale;
                Intrinsics.checkNotNullExpressionValue(locale, "view.context.resources.configuration.locale");
                iterator = companion.getInstance(locale);
                iterator.initialize(text);
                break;
            case 2:
                AccessibilityIterators.WordTextSegmentIterator.Companion companion2 = AccessibilityIterators.WordTextSegmentIterator.Companion;
                Locale locale2 = this.view.getContext().getResources().getConfiguration().locale;
                Intrinsics.checkNotNullExpressionValue(locale2, "view.context.resources.configuration.locale");
                iterator = companion2.getInstance(locale2);
                iterator.initialize(text);
                break;
            case 4:
            case 16:
                if (!node.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                    return null;
                }
                List textLayoutResults = new ArrayList();
                Function1 function1 = (Function1) ((AccessibilityAction) node.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getGetTextLayoutResult())).getAction();
                if (Intrinsics.areEqual((Object) function1 != null ? (Boolean) function1.invoke(textLayoutResults) : null, (Object) true)) {
                    TextLayoutResult textLayoutResult = (TextLayoutResult) textLayoutResults.get(0);
                    if (granularity != 4) {
                        AccessibilityIterators.AbstractTextSegmentIterator iterator2 = AccessibilityIterators.PageTextSegmentIterator.Companion.getInstance();
                        ((AccessibilityIterators.PageTextSegmentIterator) iterator2).initialize(text, textLayoutResult, node);
                        iterator = iterator2;
                        break;
                    } else {
                        AccessibilityIterators.AbstractTextSegmentIterator iterator3 = AccessibilityIterators.LineTextSegmentIterator.Companion.getInstance();
                        ((AccessibilityIterators.LineTextSegmentIterator) iterator3).initialize(text, textLayoutResult);
                        iterator = iterator3;
                        break;
                    }
                } else {
                    return null;
                }
            case 8:
                iterator = AccessibilityIterators.ParagraphTextSegmentIterator.Companion.getInstance();
                iterator.initialize(text);
                break;
            default:
                return null;
        }
        return iterator;
    }

    private final String getIterableTextForAccessibility(SemanticsNode node) {
        AnnotatedString annotatedString;
        if (node == null) {
            return null;
        }
        if (node.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription())) {
            return TempListUtilsKt.fastJoinToString$default((List) node.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getContentDescription()), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(node)) {
            AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig$ui_release());
            if (textForTextField != null) {
                return textForTextField.getText();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        return annotatedString.getText();
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration $this$getTextForTextField) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull($this$getTextForTextField, SemanticsProperties.INSTANCE.getEditableText());
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$MyNodeProvider;", "Landroid/view/accessibility/AccessibilityNodeProvider;", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "addExtraDataToAccessibilityNodeInfo", "", "virtualViewId", "", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "createAccessibilityNodeInfo", "performAction", "", "action", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public final class MyNodeProvider extends AccessibilityNodeProvider {
        public MyNodeProvider() {
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.createNodeInfo(virtualViewId);
        }

        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(virtualViewId, action, arguments);
        }

        public void addExtraDataToAccessibilityNodeInfo(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey, Bundle arguments) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(extraDataKey, "extraDataKey");
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info, extraDataKey, arguments);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @JvmStatic
        public static final void addSetProgressAction(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            AccessibilityAction it;
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) && (it = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetProgress())) != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908349, it.getLabel()));
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api28Impl;", "", "()V", "setScrollEventDelta", "", "event", "Landroid/view/accessibility/AccessibilityEvent;", "deltaX", "", "deltaY", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class Api28Impl {
        public static final Api28Impl INSTANCE = new Api28Impl();

        private Api28Impl() {
        }

        @JvmStatic
        public static final void setScrollEventDelta(AccessibilityEvent event, int deltaX, int deltaY) {
            Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
            event.setScrollDeltaX(deltaX);
            event.setScrollDeltaY(deltaY);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api29Impl;", "", "()V", "addPageActions", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class Api29Impl {
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @JvmStatic
        public static final void addPageActions(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                AccessibilityAction it = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageUp());
                if (it != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, it.getLabel()));
                }
                AccessibilityAction it2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageDown());
                if (it2 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, it2.getLabel()));
                }
                AccessibilityAction it3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageLeft());
                if (it3 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908360, it3.getLabel()));
                }
                AccessibilityAction it4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageRight());
                if (it4 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908361, it4.getLabel()));
                }
            }
        }
    }
}

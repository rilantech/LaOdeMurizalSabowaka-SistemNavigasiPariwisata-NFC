package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b#\b \u0018\u0000 \u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005:\u0004\u0002\u0002B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ$\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020 H\u0002J,\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J \u0010\u0001\u001a\u00020Q2\u0006\u0010P\u001a\u00020QH\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J*\u0010\u0001\u001a\u00020\u001a2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010P\u001a\u00020QH\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0010\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0006J\u001c\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00062\b\u0010\u0001\u001a\u00030\u0001H\u0004J\u0012\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0006H\u0002J\t\u0010\u0001\u001a\u00020\u0007H&J\u0018\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u0001J\"\u0010\u0001\u001a\u00030\u00012\u0007\u0010b\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b \u0001\u0010\u0001J\u001b\u0010¡\u0001\u001a\u00020\u00072\u0007\u0010¢\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020 H\u0002J&\u0010£\u0001\u001a\u00020 2\f\u0010¤\u0001\u001a\u0007\u0012\u0002\b\u00030¥\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¦\u0001\u0010§\u0001J&\u0010¨\u0001\u001a\u0004\u0018\u00010w2\f\u0010¤\u0001\u001a\u0007\u0012\u0002\b\u00030¥\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u0014\u0010«\u0001\u001a\u0004\u0018\u00010w2\u0007\u0010¬\u0001\u001a\u00020 H\u0002JF\u0010­\u0001\u001a\u00020\u00072\b\u0010®\u0001\u001a\u00030¯\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010°\u0001\u001a\u00030±\u00012\u0007\u0010²\u0001\u001a\u00020 2\u0007\u0010³\u0001\u001a\u00020 ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b´\u0001\u0010µ\u0001JH\u0010¶\u0001\u001a\u00020\u00072\b\u0010®\u0001\u001a\u00030¯\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010°\u0001\u001a\u00030±\u00012\u0007\u0010²\u0001\u001a\u00020 2\u0007\u0010³\u0001\u001a\u00020 H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b·\u0001\u0010µ\u0001J\t\u0010¸\u0001\u001a\u00020\u0007H\u0016J\u0013\u0010¹\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0006H\u0002J\"\u0010º\u0001\u001a\u00020 2\b\u0010\u0001\u001a\u00030\u0001H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b»\u0001\u0010¼\u0001J\u0007\u0010½\u0001\u001a\u00020 J\u001c\u0010¾\u0001\u001a\u00030¿\u00012\u0007\u0010À\u0001\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020 H\u0016J,\u0010Á\u0001\u001a\u00030\u00012\u0007\u0010À\u0001\u001a\u00020\u00032\b\u0010Â\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001J#\u0010Å\u0001\u001a\u00030\u00012\b\u0010Æ\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÇ\u0001\u0010\u0001J#\u0010È\u0001\u001a\u00030\u00012\b\u0010Æ\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÉ\u0001\u0010\u0001J#\u0010Ê\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bË\u0001\u0010\u0001J\u000f\u0010Ì\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\bÍ\u0001J\t\u0010Î\u0001\u001a\u00020\u0007H\u0016J\u0007\u0010Ï\u0001\u001a\u00020\u0007J\u001b\u0010Ð\u0001\u001a\u00020\u00072\u0007\u0010Ñ\u0001\u001a\u00020V2\u0007\u0010Ò\u0001\u001a\u00020VH\u0014J\u0007\u0010Ó\u0001\u001a\u00020\u0007J\u0007\u0010Ô\u0001\u001a\u00020\u0007J\u0007\u0010Õ\u0001\u001a\u00020\u0007J\u0012\u0010Ö\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0006H\u0016J8\u0010×\u0001\u001a\u00030Ø\u00012\u0007\u0010Ù\u0001\u001a\u00020-2\u0010\b\u0004\u0010Ú\u0001\u001a\t\u0012\u0005\u0012\u00030Ø\u00010$H\bø\u0001\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001JD\u0010Ý\u0001\u001a\u00020\u00072\u0006\u0010b\u001a\u00020a2\u0007\u0010\u0001\u001a\u00020\u001a2\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b5H\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÞ\u0001\u0010ß\u0001JD\u0010à\u0001\u001a\u00020\u00072\u0006\u0010b\u001a\u00020a2\u0007\u0010\u0001\u001a\u00020\u001a2\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b5H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bá\u0001\u0010ß\u0001JB\u0010â\u0001\u001a\u00020\u00072\u0006\u0010b\u001a\u00020a2\u0007\u0010\u0001\u001a\u00020\u001a2\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b5ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bã\u0001\u0010ß\u0001J\u001d\u0010ä\u0001\u001a\u00020\u00072\b\u0010\u0001\u001a\u00030¿\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010å\u0001J,\u0010æ\u0001\u001a\u00020\u00072\u0007\u0010¢\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020 2\t\b\u0002\u0010ç\u0001\u001a\u00020 H\u0000¢\u0006\u0003\bè\u0001J\u000f\u0010é\u0001\u001a\u00020\u0007H\u0010¢\u0006\u0003\bê\u0001J\u0007\u0010ë\u0001\u001a\u00020 J\"\u0010ì\u0001\u001a\u00030\u00012\u0007\u0010b\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bí\u0001\u0010\u0001J\b\u0010î\u0001\u001a\u00030¿\u0001J+\u0010ï\u0001\u001a\u00020\u00072\u0007\u0010À\u0001\u001a\u00020\u00032\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bò\u0001\u0010ó\u0001J+\u0010ô\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bõ\u0001\u0010ö\u0001J+\u0010÷\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bø\u0001\u0010ö\u0001J-\u0010ù\u0001\u001a\u00020\u00072\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b52\t\b\u0002\u0010ú\u0001\u001a\u00020 J\u0014\u0010û\u0001\u001a\u00020\u00072\t\b\u0002\u0010ü\u0001\u001a\u00020 H\u0002JL\u0010ý\u0001\u001a\u00020\u0007\"\u0007\b\u0000\u0010þ\u0001\u0018\u00012\u000f\u0010¤\u0001\u001a\n\u0012\u0005\u0012\u0003Hþ\u00010¥\u00012\u0014\u0010Ú\u0001\u001a\u000f\u0012\u0005\u0012\u0003Hþ\u0001\u0012\u0004\u0012\u00020\u00070\u0005H\bø\u0001\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÿ\u0001\u0010\u0002J4\u0010ý\u0001\u001a\u00020\u00072\u0007\u0010\u0002\u001a\u00020V2\u0007\u0010¬\u0001\u001a\u00020 2\u0013\u0010Ú\u0001\u001a\u000e\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020\u00070\u0005H\bø\u0001\u0003J#\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0001J+\u0010\u0002\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00062\u0013\u0010Ú\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\bø\u0001\u0003J\"\u0010\u0002\u001a\u00020 2\b\u0010\u0001\u001a\u00030\u0001H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010¼\u0001JN\u0010\u0002\u001a\u00020\u0007*\u0004\u0018\u00010w2\b\u0010®\u0001\u001a\u00030¯\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010°\u0001\u001a\u00030±\u00012\u0007\u0010²\u0001\u001a\u00020 2\u0007\u0010³\u0001\u001a\u00020 H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002JW\u0010\u0002\u001a\u00020\u0007*\u0004\u0018\u00010w2\b\u0010®\u0001\u001a\u00030¯\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010°\u0001\u001a\u00030±\u00012\u0007\u0010²\u0001\u001a\u00020 2\u0007\u0010³\u0001\u001a\u00020 2\u0007\u0010\u0002\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002JW\u0010\u0002\u001a\u00020\u0007*\u0004\u0018\u00010w2\b\u0010®\u0001\u001a\u00030¯\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010°\u0001\u001a\u00030±\u00012\u0007\u0010²\u0001\u001a\u00020 2\u0007\u0010³\u0001\u001a\u00020 2\u0007\u0010\u0002\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J\r\u0010\u0002\u001a\u00020\u0000*\u00020\u0003H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070$X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\"R\u000e\u0010(\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020 2\u0006\u0010)\u001a\u00020 @BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u001d\u0010,\u001a\u00020-8@X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b.\u0010/R\"\u00101\u001a\u0004\u0018\u0001002\b\u0010)\u001a\u0004\u0018\u000100@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103RD\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b52\u0019\u0010)\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b5@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u00020<8VX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR&\u0010E\u001a\u0004\u0018\u00010D2\b\u0010)\u001a\u0004\u0018\u00010D@dX¦\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010K\u001a\u00020\f2\u0006\u0010J\u001a\u00020\f8P@PX\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020Q8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bR\u0010/R\u001c\u0010S\u001a\u0010\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020V\u0018\u00010TX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010W\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\u0015R\u0013\u0010Y\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bZ\u0010\u0018R\u0016\u0010[\u001a\u0004\u0018\u00010\\8VX\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0013\u0010_\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b`\u0010\u0018R/\u0010b\u001a\u00020a2\u0006\u0010)\u001a\u00020a@TX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010f\u001a\u0004\bc\u0010/\"\u0004\bd\u0010eR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020U0h8VX\u0004¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0014\u0010k\u001a\u00020\u000e8DX\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u000e\u0010n\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010o\u001a\u00020p8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bq\u0010/R\u0014\u0010r\u001a\u00020s8BX\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR\u0012\u0010v\u001a\u00020wX¦\u0004¢\u0006\u0006\u001a\u0004\bx\u0010yR\u001c\u0010z\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001e\u0010\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010|\"\u0005\b\u0001\u0010~R(\u0010\u0001\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a@DX\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0001\u0010\u001c\"\u0006\b\u0001\u0010\u0001\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b20\u0001¨\u0006\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isValidOwnerScope", "lastLayerAlpha", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "lastMeasurementConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastMeasurementConstraints-msEJaDk$ui_release", "()J", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "value", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "oldAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "parent", "getParent", "parentCoordinates", "getParentCoordinates", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "released", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "zIndex", "getZIndex", "setZIndex", "(F)V", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", "offset", "ancestorToLocal-R5De75A", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "(J)J", "distanceInMinimumTouchTarget", "pointerPosition", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "draw", "canvas", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawContainedDrawModifiers", "ensureLookaheadDelegateCreated", "findCommonAncestor", "other", "findCommonAncestor$ui_release", "fromParentPosition", "fromParentPosition-MK-Hz9U", "fromParentRect", "bounds", "hasNode", "type", "Landroidx/compose/ui/node/NodeKind;", "hasNode-H91voCI", "(I)Z", "head", "head-H91voCI", "(I)Landroidx/compose/ui/Modifier$Node;", "headNode", "includeTail", "hitTest", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestChild", "hitTestChild-YqVAtuI", "invalidateLayer", "invoke", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "isTransparent", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "onCoordinatesUsed", "onCoordinatesUsed$ui_release", "onLayoutModifierNodeChanged", "onLayoutNodeAttach", "onMeasureResultChanged", "width", "height", "onMeasured", "onPlaced", "onRelease", "performDraw", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeSelf", "placeSelf-f8xVGno", "placeSelfApparentToRealOffset", "placeSelfApparentToRealOffset-f8xVGno", "propagateRelocationRequest", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rectInParent", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "replace", "replace$ui_release", "shouldSharePointerInputWithSiblings", "toParentPosition", "toParentPosition-MK-Hz9U", "touchBoundsInRoot", "transformFrom", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFromAncestor", "transformFromAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformToAncestor-EL8BTi8", "updateLayerBlock", "forceUpdateLayerParameters", "updateLayerParameters", "invokeOnLayoutChange", "visitNodes", "T", "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "mask", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "hit", "hit-1hIXUjU", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitNear", "distanceFromEdge", "hitNear-JHbHoSQ", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZF)V", "speculativeHit", "speculativeHit-JHbHoSQ", "toCoordinator", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeCoordinator.kt */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope, Function1<Canvas, Unit> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    /* access modifiers changed from: private */
    public static final HitTestSource PointerInputSource = new NodeCoordinator$Companion$PointerInputSource$1();
    /* access modifiers changed from: private */
    public static final HitTestSource SemanticsSource = new NodeCoordinator$Companion$SemanticsSource$1();
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    /* access modifiers changed from: private */
    public static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = NodeCoordinator$Companion$onCommitAffectingLayer$1.INSTANCE;
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = NodeCoordinator$Companion$onCommitAffectingLayerParams$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m3482constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private final Function0<Unit> invalidateParentLayer = new NodeCoordinator$invalidateParentLayer$1(this);
    private boolean isClipping;
    private float lastLayerAlpha = 0.8f;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private Density layerDensity = getLayoutNode().getDensity();
    private LayoutDirection layerLayoutDirection = getLayoutNode().getLayoutDirection();
    /* access modifiers changed from: private */
    public LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position = IntOffset.Companion.m5972getZeronOccac();
    private boolean released;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J=\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H&ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H&ø\u0001\u0003\u0002\u0015\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NodeCoordinator.kt */
    public interface HitTestSource {
        /* renamed from: childHitTest-YqVAtuI  reason: not valid java name */
        void m4951childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2);

        /* renamed from: entityType-OLwlOKw  reason: not valid java name */
        int m4952entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shouldHitTestChildren(LayoutNode layoutNode);
    }

    public abstract void ensureLookaheadDelegateCreated();

    public abstract LookaheadDelegate getLookaheadDelegate();

    public abstract Modifier.Node getTail();

    public Object propagateRelocationRequest(Rect rect, Continuation<? super Unit> continuation) {
        return propagateRelocationRequest$suspendImpl(this, rect, continuation);
    }

    /* access modifiers changed from: protected */
    public abstract void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate);

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Canvas) p1);
        return Unit.INSTANCE;
    }

    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public NodeCoordinator(LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        this.layoutNode = layoutNode2;
    }

    public final NodeCoordinator getWrapped$ui_release() {
        return this.wrapped;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    public final NodeCoordinator getWrappedBy$ui_release() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    public LayoutCoordinates getCoordinates() {
        return this;
    }

    /* access modifiers changed from: private */
    public final Modifier.Node headNode(boolean includeTail) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes$ui_release().getHead$ui_release();
        }
        if (includeTail) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator == null || (tail = nodeCoordinator.getTail()) == null) {
                return null;
            }
            return tail.getChild$ui_release();
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            return nodeCoordinator2.getTail();
        }
        return null;
    }

    public final void visitNodes(int mask, boolean includeTail, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Modifier.Node stopNode = getTail();
        if (includeTail || (stopNode = stopNode.getParent$ui_release()) != null) {
            Modifier.Node node = headNode(includeTail);
            while (node != null && (node.getAggregateChildKindSet$ui_release() & mask) != 0) {
                if ((node.getKindSet$ui_release() & mask) != 0) {
                    block.invoke(node);
                }
                if (node != stopNode) {
                    node = node.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: visitNodes-aLcG6gQ  reason: not valid java name */
    public final /* synthetic */ <T> void m4944visitNodesaLcG6gQ(int type, Function1<? super T, Unit> block) {
        NodeCoordinator this_$iv;
        boolean includeTail$iv;
        int i;
        Function1<? super T, Unit> function1;
        NodeCoordinator this_$iv2;
        boolean includeTail$iv2;
        int i2;
        NodeCoordinator this_$iv3;
        boolean includeTail$iv3;
        int i3;
        NodeCoordinator this_$iv4;
        boolean includeTail$iv4;
        int i4;
        Object obj;
        Function1<? super T, Unit> function12 = block;
        Intrinsics.checkNotNullParameter(function12, "block");
        int i5 = false;
        boolean includeTail$iv5 = NodeKindKt.m4965getIncludeSelfInTraversalH91voCI(type);
        NodeCoordinator this_$iv5 = this;
        int mask$iv = type;
        Modifier.Node stopNode$iv = this_$iv5.getTail();
        if (includeTail$iv5 || (stopNode$iv = stopNode$iv.getParent$ui_release()) != null) {
            Modifier.Node node$iv = this_$iv5.headNode(includeTail$iv5);
            while (node$iv != null) {
                if ((node$iv.getAggregateChildKindSet$ui_release() & mask$iv) != 0) {
                    if ((node$iv.getKindSet$ui_release() & mask$iv) != 0) {
                        Object stack$iv = null;
                        Object node$iv2 = node$iv;
                        while (node$iv2 != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (node$iv2 instanceof Object) {
                                function1.invoke(node$iv2);
                                i3 = i;
                                includeTail$iv3 = includeTail$iv;
                                this_$iv3 = this_$iv;
                            } else {
                                if (!((((Modifier.Node) node$iv2).getKindSet$ui_release() & type) != 0) || !(node$iv2 instanceof DelegatingNode)) {
                                    i3 = i;
                                    includeTail$iv3 = includeTail$iv;
                                    this_$iv3 = this_$iv;
                                } else {
                                    int count$iv = 0;
                                    Modifier.Node node$iv$iv = ((DelegatingNode) node$iv2).getDelegate$ui_release();
                                    while (node$iv$iv != null) {
                                        Object next$iv = node$iv$iv;
                                        if ((next$iv.getKindSet$ui_release() & type) != 0) {
                                            count$iv++;
                                            i4 = i;
                                            if (count$iv == 1) {
                                                node$iv2 = next$iv;
                                                includeTail$iv4 = includeTail$iv;
                                                this_$iv4 = this_$iv;
                                            } else {
                                                Object obj2 = (MutableVector) stack$iv;
                                                if (obj2 == null) {
                                                    includeTail$iv4 = includeTail$iv;
                                                    this_$iv4 = this_$iv;
                                                    obj = new MutableVector(new Modifier.Node[16], 0);
                                                    MutableVector mutableVector = (MutableVector) obj;
                                                } else {
                                                    includeTail$iv4 = includeTail$iv;
                                                    this_$iv4 = this_$iv;
                                                    obj = obj2;
                                                }
                                                stack$iv = obj;
                                                Modifier.Node theNode$iv = (Modifier.Node) node$iv2;
                                                if (theNode$iv != null) {
                                                    MutableVector mutableVector2 = (MutableVector) stack$iv;
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(theNode$iv);
                                                    }
                                                    node$iv2 = null;
                                                }
                                                MutableVector mutableVector3 = (MutableVector) stack$iv;
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(next$iv);
                                                }
                                            }
                                        } else {
                                            i4 = i;
                                            includeTail$iv4 = includeTail$iv;
                                            this_$iv4 = this_$iv;
                                        }
                                        node$iv$iv = node$iv$iv.getChild$ui_release();
                                        i = i4;
                                        includeTail$iv = includeTail$iv4;
                                        this_$iv = this_$iv4;
                                    }
                                    i3 = i;
                                    includeTail$iv3 = includeTail$iv;
                                    this_$iv3 = this_$iv;
                                    if (count$iv == 1) {
                                        function1 = block;
                                        i = i3;
                                        includeTail$iv = includeTail$iv3;
                                        this_$iv = this_$iv3;
                                    }
                                }
                            }
                            node$iv2 = DelegatableNodeKt.pop((MutableVector) stack$iv);
                            function1 = block;
                            i = i3;
                            includeTail$iv = includeTail$iv3;
                            this_$iv = this_$iv3;
                        }
                        i2 = i;
                        includeTail$iv2 = includeTail$iv;
                        this_$iv2 = this_$iv;
                    } else {
                        i2 = i;
                        includeTail$iv2 = includeTail$iv;
                        this_$iv2 = this_$iv;
                    }
                    if (node$iv != stopNode$iv) {
                        node$iv = node$iv.getChild$ui_release();
                        function12 = block;
                        i5 = i2;
                        includeTail$iv5 = includeTail$iv2;
                        this_$iv5 = this_$iv2;
                    } else {
                        return;
                    }
                } else {
                    int i6 = i;
                    boolean z = includeTail$iv;
                    NodeCoordinator nodeCoordinator = this_$iv;
                    return;
                }
            }
            int i7 = i;
            boolean z2 = includeTail$iv;
            NodeCoordinator nodeCoordinator2 = this_$iv;
        }
    }

    /* renamed from: hasNode-H91voCI  reason: not valid java name */
    private final boolean m4916hasNodeH91voCI(int type) {
        Modifier.Node headNode = headNode(NodeKindKt.m4965getIncludeSelfInTraversalH91voCI(type));
        return headNode != null && DelegatableNodeKt.m4790has64DMado(headNode, type);
    }

    /* renamed from: head-H91voCI  reason: not valid java name */
    public final Modifier.Node m4931headH91voCI(int type) {
        boolean includeTail$iv = NodeKindKt.m4965getIncludeSelfInTraversalH91voCI(type);
        int mask$iv = type;
        Modifier.Node stopNode$iv = getTail();
        if (!includeTail$iv && (stopNode$iv = stopNode$iv.getParent$ui_release()) == null) {
            return null;
        }
        Modifier.Node node$iv = headNode(includeTail$iv);
        while (node$iv != null && (node$iv.getAggregateChildKindSet$ui_release() & mask$iv) != 0) {
            if ((node$iv.getKindSet$ui_release() & mask$iv) != 0) {
                return node$iv;
            }
            if (node$iv == stopNode$iv) {
                return null;
            }
            node$iv = node$iv.getChild$ui_release();
        }
        return null;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public final long m4930getSizeYbymL2g() {
        return m4724getMeasuredSizeYbymL2g();
    }

    /* access modifiers changed from: protected */
    public final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release();
    }

    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    public void replace$ui_release() {
        m4939placeAtf8xVGno(m4929getPositionnOccac(), this.zIndex, this.layerBlock);
    }

    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    public boolean isAttached() {
        return !this.released && getLayoutNode().isAttached();
    }

    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    public void setMeasureResult$ui_release(MeasureResult value) {
        Intrinsics.checkNotNullParameter(value, "value");
        MeasureResult old = this._measureResult;
        if (value != old) {
            this._measureResult = value;
            if (!(old != null && value.getWidth() == old.getWidth() && value.getHeight() == old.getHeight())) {
                onMeasureResultChanged(value.getWidth(), value.getHeight());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if ((!(map == null || map.isEmpty()) || (!value.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual((Object) value.getAlignmentLines(), (Object) this.oldAlignmentLines)) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                Map oldLines = this.oldAlignmentLines;
                if (oldLines == null) {
                    oldLines = new LinkedHashMap();
                    this.oldAlignmentLines = oldLines;
                }
                oldLines.clear();
                oldLines.putAll(value.getAlignmentLines());
            }
        }
    }

    public Set<AlignmentLine> getProvidedAlignmentLines() {
        Set set = null;
        for (NodeCoordinator coordinator = this; coordinator != null; coordinator = coordinator.wrapped) {
            MeasureResult measureResult = coordinator._measureResult;
            Map alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            boolean z = false;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                z = true;
            }
            if (z) {
                if (set == null) {
                    set = new LinkedHashSet();
                }
                set.addAll(alignmentLines.keySet());
            }
        }
        return set == null ? SetsKt.emptySet() : set;
    }

    /* access modifiers changed from: protected */
    public void onMeasureResultChanged(int width, int height) {
        NodeCoordinator this_$iv;
        int type$iv;
        OwnedLayer layer2;
        NodeCoordinator this_$iv2;
        int type$iv2;
        OwnedLayer layer3;
        NodeCoordinator this_$iv3;
        NodeCoordinator this_$iv4;
        int type$iv3;
        OwnedLayer layer4;
        NodeCoordinator this_$iv5;
        int type$iv4;
        OwnedLayer layer5;
        int count$iv$iv;
        MutableVector mutableVector;
        OwnedLayer layer6 = this.layer;
        if (layer6 != null) {
            layer6.m5008resizeozmzZPI(IntSizeKt.IntSize(width, height));
        } else {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                nodeCoordinator.invalidateLayer();
            }
        }
        m4727setMeasuredSizeozmzZPI(IntSizeKt.IntSize(width, height));
        NodeCoordinator nodeCoordinator2 = null;
        updateLayerParameters(false);
        int type$iv5 = NodeKind.m4956constructorimpl(4);
        NodeCoordinator this_$iv6 = this;
        boolean includeTail$iv$iv = NodeKindKt.m4965getIncludeSelfInTraversalH91voCI(type$iv5);
        int mask$iv$iv = type$iv5;
        NodeCoordinator this_$iv$iv = this_$iv6;
        Modifier.Node stopNode$iv$iv = this_$iv$iv.getTail();
        if (includeTail$iv$iv || (stopNode$iv$iv = stopNode$iv$iv.getParent$ui_release()) != null) {
            Modifier.Node node$iv$iv = this_$iv$iv.headNode(includeTail$iv$iv);
            while (true) {
                if (node$iv$iv != null) {
                    if ((node$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) == 0) {
                        int i = type$iv;
                        NodeCoordinator nodeCoordinator3 = this_$iv;
                        break;
                    }
                    if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                        MutableVector mutableVector2 = null;
                        Modifier.Node node = node$iv$iv;
                        while (node != null) {
                            if (node instanceof DrawModifierNode) {
                                ((DrawModifierNode) node).onMeasureResultChanged();
                                layer4 = layer2;
                                type$iv3 = type$iv;
                                this_$iv4 = this_$iv;
                            } else {
                                Modifier.Node this_$iv$iv$iv = node;
                                Modifier.Node node2 = this_$iv$iv$iv;
                                if (((this_$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                    layer4 = layer2;
                                    type$iv3 = type$iv;
                                    this_$iv4 = this_$iv;
                                } else {
                                    int count$iv$iv2 = 0;
                                    Modifier.Node node$iv$iv$iv = ((DelegatingNode) node).getDelegate$ui_release();
                                    while (node$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv = node$iv$iv$iv;
                                        if ((next$iv$iv.getKindSet$ui_release() & type$iv) != 0) {
                                            count$iv$iv2++;
                                            layer5 = layer2;
                                            if (count$iv$iv2 == 1) {
                                                node = next$iv$iv;
                                                type$iv4 = type$iv;
                                                this_$iv5 = this_$iv;
                                                Modifier.Node node3 = next$iv$iv;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    count$iv$iv = count$iv$iv2;
                                                    type$iv4 = type$iv;
                                                    this_$iv5 = this_$iv;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    count$iv$iv = count$iv$iv2;
                                                    type$iv4 = type$iv;
                                                    this_$iv5 = this_$iv;
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
                                            layer5 = layer2;
                                            type$iv4 = type$iv;
                                            this_$iv5 = this_$iv;
                                            Modifier.Node node4 = next$iv$iv;
                                        }
                                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                        layer2 = layer5;
                                        type$iv = type$iv4;
                                        this_$iv = this_$iv5;
                                    }
                                    layer4 = layer2;
                                    type$iv3 = type$iv;
                                    this_$iv4 = this_$iv;
                                    if (count$iv$iv2 == 1) {
                                        layer2 = layer4;
                                        type$iv = type$iv3;
                                        this_$iv = this_$iv4;
                                    }
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                            layer2 = layer4;
                            type$iv = type$iv3;
                            this_$iv = this_$iv4;
                        }
                        layer3 = layer2;
                        type$iv2 = type$iv;
                        this_$iv2 = this_$iv;
                        this_$iv3 = null;
                    } else {
                        layer3 = layer2;
                        type$iv2 = type$iv;
                        this_$iv2 = this_$iv;
                        this_$iv3 = nodeCoordinator2;
                    }
                    if (node$iv$iv == stopNode$iv$iv) {
                        break;
                    }
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    nodeCoordinator2 = this_$iv3;
                    layer6 = layer3;
                    type$iv5 = type$iv2;
                    this_$iv6 = this_$iv2;
                } else {
                    int i2 = type$iv;
                    NodeCoordinator nodeCoordinator4 = this_$iv;
                    break;
                }
            }
        } else {
            OwnedLayer ownedLayer = layer6;
            int i3 = type$iv5;
            NodeCoordinator nodeCoordinator5 = this_$iv6;
        }
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
    }

    /* renamed from: getPosition-nOcc-ac  reason: not valid java name */
    public long m4929getPositionnOccac() {
        return this.position;
    }

    /* access modifiers changed from: protected */
    /* renamed from: setPosition--gyyYBs  reason: not valid java name */
    public void m4941setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    /* access modifiers changed from: protected */
    public final void setZIndex(float f) {
        this.zIndex = f;
    }

    public Object getParentData() {
        NodeChain this_$iv;
        Modifier.Node thisNode;
        NodeChain this_$iv2;
        Modifier.Node thisNode2;
        NodeChain this_$iv3;
        Modifier.Node thisNode3;
        int count$iv;
        MutableVector mutableVector;
        int i = 64;
        if (!getLayoutNode().getNodes$ui_release().m4906hasH91voCI$ui_release(NodeKind.m4956constructorimpl(64))) {
            return null;
        }
        Modifier.Node thisNode4 = getTail();
        Ref.ObjectRef data = new Ref.ObjectRef();
        NodeChain this_$iv4 = getLayoutNode().getNodes$ui_release();
        Modifier.Node node$iv = this_$iv4.getTail$ui_release();
        while (node$iv != null) {
            Modifier.Node node = node$iv;
            if (((node.getKindSet$ui_release() & NodeKind.m4956constructorimpl(i)) != 0 ? 1 : 0) != 0) {
                int kind$iv = NodeKind.m4956constructorimpl(i);
                MutableVector mutableVector2 = null;
                Modifier.Node this_$iv$iv = node;
                while (this_$iv$iv != null) {
                    if (this_$iv$iv instanceof ParentDataModifierNode) {
                        data.element = ((ParentDataModifierNode) this_$iv$iv).modifyParentData(getLayoutNode().getDensity(), data.element);
                        thisNode2 = thisNode;
                        this_$iv2 = this_$iv;
                    } else {
                        if (!((this_$iv$iv.getKindSet$ui_release() & kind$iv) != 0) || !(this_$iv$iv instanceof DelegatingNode)) {
                            thisNode2 = thisNode;
                            this_$iv2 = this_$iv;
                        } else {
                            int count$iv2 = 0;
                            Modifier.Node node$iv$iv = ((DelegatingNode) this_$iv$iv).getDelegate$ui_release();
                            while (node$iv$iv != null) {
                                Modifier.Node next$iv = node$iv$iv;
                                if ((next$iv.getKindSet$ui_release() & kind$iv) != 0) {
                                    count$iv2++;
                                    thisNode3 = thisNode;
                                    if (count$iv2 == 1) {
                                        this_$iv$iv = next$iv;
                                        this_$iv3 = this_$iv;
                                        Modifier.Node node2 = next$iv;
                                    } else {
                                        if (mutableVector2 == null) {
                                            count$iv = count$iv2;
                                            this_$iv3 = this_$iv;
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        } else {
                                            count$iv = count$iv2;
                                            this_$iv3 = this_$iv;
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
                                    thisNode3 = thisNode;
                                    this_$iv3 = this_$iv;
                                    Modifier.Node node3 = next$iv;
                                }
                                node$iv$iv = node$iv$iv.getChild$ui_release();
                                thisNode = thisNode3;
                                this_$iv = this_$iv3;
                            }
                            thisNode2 = thisNode;
                            this_$iv2 = this_$iv;
                            if (count$iv2 == 1) {
                                thisNode = thisNode2;
                                this_$iv = this_$iv2;
                            }
                        }
                    }
                    this_$iv$iv = DelegatableNodeKt.pop(mutableVector2);
                    thisNode = thisNode2;
                    this_$iv = this_$iv2;
                }
            }
            node$iv = node$iv.getParent$ui_release();
            thisNode4 = thisNode;
            this_$iv4 = this_$iv;
            i = 64;
        }
        return data.element;
    }

    public final void onCoordinatesUsed$ui_release() {
        getLayoutNode().getLayoutDelegate$ui_release().onCoordinatesUsed();
    }

    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (isAttached()) {
            onCoordinatesUsed$ui_release();
            return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    public final LayoutCoordinates getParentCoordinates() {
        if (isAttached()) {
            onCoordinatesUsed$ui_release();
            return this.wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* access modifiers changed from: protected */
    public final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect it = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = it;
        return it;
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* renamed from: getLastMeasurementConstraints-msEJaDk$ui_release  reason: not valid java name */
    public final long m4927getLastMeasurementConstraintsmsEJaDk$ui_release() {
        return m4725getMeasurementConstraintsmsEJaDk();
    }

    /* access modifiers changed from: protected */
    /* renamed from: performingMeasure-K40F9xA  reason: not valid java name */
    public final Placeable m4938performingMeasureK40F9xA(long constraints, Function0<? extends Placeable> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        m4728setMeasurementConstraintsBRTryo0(constraints);
        return (Placeable) block.invoke();
    }

    /* Debug info: failed to restart local var, previous not found, register: 35 */
    public final void onMeasured() {
        Modifier.Node stopNode$iv$iv;
        int i;
        NodeCoordinator this_$iv;
        int $i$f$withoutReadObservation;
        Snapshot.Companion this_$iv2;
        int type$iv;
        int $i$f$withoutReadObservation2;
        int type$iv2;
        int i2;
        NodeCoordinator this_$iv3;
        Snapshot.Companion this_$iv4;
        int $i$f$withoutReadObservation3;
        int type$iv3;
        int i3;
        NodeCoordinator this_$iv5;
        int $i$f$withoutReadObservation4;
        int type$iv4;
        MutableVector mutableVector;
        if (m4916hasNodeH91voCI(NodeKind.m4956constructorimpl(128))) {
            Snapshot.Companion this_$iv6 = Snapshot.Companion;
            int $i$f$withoutReadObservation5 = false;
            Snapshot snapshot$iv = this_$iv6.createNonObservableSnapshot();
            Snapshot this_$iv$iv = snapshot$iv;
            try {
                Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
                try {
                    int type$iv5 = NodeKind.m4956constructorimpl(128);
                    NodeCoordinator this_$iv7 = this;
                    int i4 = false;
                    boolean includeTail$iv$iv = NodeKindKt.m4965getIncludeSelfInTraversalH91voCI(type$iv5);
                    int mask$iv$iv = type$iv5;
                    NodeCoordinator this_$iv$iv2 = this_$iv7;
                    if (includeTail$iv$iv) {
                        try {
                            stopNode$iv$iv = this_$iv$iv2.getTail();
                        } catch (Throwable th) {
                            th = th;
                            Snapshot.Companion companion = this_$iv6;
                            this_$iv$iv.restoreCurrent(previous$iv$iv);
                            throw th;
                        }
                    } else {
                        stopNode$iv$iv = this_$iv$iv2.getTail().getParent$ui_release();
                        if (stopNode$iv$iv == null) {
                            int i5 = type$iv5;
                            Snapshot.Companion companion2 = this_$iv6;
                            NodeCoordinator nodeCoordinator = this_$iv7;
                            Unit unit = Unit.INSTANCE;
                            this_$iv$iv.restoreCurrent(previous$iv$iv);
                            snapshot$iv.dispose();
                        }
                    }
                    Modifier.Node node$iv$iv = this_$iv$iv2.headNode(includeTail$iv$iv);
                    while (true) {
                        if (node$iv$iv != null) {
                            if ((node$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) == 0) {
                                Snapshot.Companion companion3 = this_$iv2;
                                int i6 = $i$f$withoutReadObservation;
                                NodeCoordinator nodeCoordinator2 = this_$iv;
                                int i7 = i;
                                break;
                            }
                            if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                                MutableVector mutableVector2 = null;
                                Modifier.Node node = node$iv$iv;
                                while (node != null) {
                                    Snapshot.Companion this_$iv8 = this_$iv2;
                                    try {
                                        if (node instanceof LayoutAwareModifierNode) {
                                            try {
                                                this_$iv5 = this_$iv;
                                                i3 = i;
                                                ((LayoutAwareModifierNode) node).m4817onRemeasuredozmzZPI(m4724getMeasuredSizeYbymL2g());
                                                type$iv3 = type$iv;
                                                $i$f$withoutReadObservation3 = $i$f$withoutReadObservation;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                int i8 = $i$f$withoutReadObservation;
                                                this_$iv$iv.restoreCurrent(previous$iv$iv);
                                                throw th;
                                            }
                                        } else {
                                            this_$iv5 = this_$iv;
                                            i3 = i;
                                            Modifier.Node this_$iv$iv$iv = node;
                                            int kindSet$ui_release = this_$iv$iv$iv.getKindSet$ui_release() & type$iv;
                                            Modifier.Node node2 = this_$iv$iv$iv;
                                            int i9 = 1;
                                            if ((kindSet$ui_release != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                                type$iv3 = type$iv;
                                                $i$f$withoutReadObservation3 = $i$f$withoutReadObservation;
                                            } else {
                                                int count$iv$iv = 0;
                                                Modifier.Node node$iv$iv$iv = ((DelegatingNode) node).getDelegate$ui_release();
                                                while (node$iv$iv$iv != null) {
                                                    Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                    if (((next$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? i9 : 0) != 0) {
                                                        count$iv$iv++;
                                                        if (count$iv$iv == i9) {
                                                            node = next$iv$iv;
                                                            type$iv4 = type$iv;
                                                            $i$f$withoutReadObservation4 = $i$f$withoutReadObservation;
                                                            Modifier.Node node3 = next$iv$iv;
                                                        } else {
                                                            if (mutableVector2 == null) {
                                                                type$iv4 = type$iv;
                                                                $i$f$withoutReadObservation4 = $i$f$withoutReadObservation;
                                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                            } else {
                                                                type$iv4 = type$iv;
                                                                $i$f$withoutReadObservation4 = $i$f$withoutReadObservation;
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
                                                        }
                                                    } else {
                                                        type$iv4 = type$iv;
                                                        $i$f$withoutReadObservation4 = $i$f$withoutReadObservation;
                                                        Modifier.Node node4 = next$iv$iv;
                                                    }
                                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                                    type$iv = type$iv4;
                                                    $i$f$withoutReadObservation = $i$f$withoutReadObservation4;
                                                    i9 = 1;
                                                }
                                                type$iv3 = type$iv;
                                                $i$f$withoutReadObservation3 = $i$f$withoutReadObservation;
                                                if (count$iv$iv == 1) {
                                                    this_$iv2 = this_$iv8;
                                                    this_$iv = this_$iv5;
                                                    i = i3;
                                                    type$iv = type$iv3;
                                                    $i$f$withoutReadObservation = $i$f$withoutReadObservation3;
                                                }
                                            }
                                        }
                                        node = DelegatableNodeKt.pop(mutableVector2);
                                        this_$iv2 = this_$iv8;
                                        this_$iv = this_$iv5;
                                        i = i3;
                                        type$iv = type$iv3;
                                        $i$f$withoutReadObservation = $i$f$withoutReadObservation3;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                                        throw th;
                                    }
                                }
                                type$iv2 = type$iv;
                                this_$iv4 = this_$iv2;
                                $i$f$withoutReadObservation2 = $i$f$withoutReadObservation;
                                this_$iv3 = this_$iv;
                                i2 = i;
                            } else {
                                type$iv2 = type$iv;
                                this_$iv4 = this_$iv2;
                                $i$f$withoutReadObservation2 = $i$f$withoutReadObservation;
                                this_$iv3 = this_$iv;
                                i2 = i;
                            }
                            if (node$iv$iv == stopNode$iv$iv) {
                                break;
                            }
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                            this_$iv6 = this_$iv4;
                            this_$iv7 = this_$iv3;
                            i4 = i2;
                            type$iv5 = type$iv2;
                            $i$f$withoutReadObservation5 = $i$f$withoutReadObservation2;
                        } else {
                            Snapshot.Companion companion4 = this_$iv2;
                            int i10 = $i$f$withoutReadObservation;
                            NodeCoordinator nodeCoordinator3 = this_$iv;
                            int i11 = i;
                            break;
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    try {
                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                        snapshot$iv.dispose();
                    } catch (Throwable th4) {
                        th = th4;
                        snapshot$iv.dispose();
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    Snapshot.Companion companion5 = this_$iv6;
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                Snapshot.Companion companion6 = this_$iv6;
                snapshot$iv.dispose();
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m4939placeAtf8xVGno(long position2, float zIndex2, Function1<? super GraphicsLayerScope, Unit> layerBlock2) {
        m4920placeSelff8xVGno(position2, zIndex2, layerBlock2);
    }

    /* renamed from: placeSelf-f8xVGno  reason: not valid java name */
    private final void m4920placeSelff8xVGno(long position2, float zIndex2, Function1<? super GraphicsLayerScope, Unit> layerBlock2) {
        updateLayerBlock$default(this, layerBlock2, false, 2, (Object) null);
        if (!IntOffset.m5961equalsimpl0(m4929getPositionnOccac(), position2)) {
            m4941setPositiongyyYBs(position2);
            getLayoutNode().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer layer2 = this.layer;
            if (layer2 != null) {
                layer2.m5007movegyyYBs(position2);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = zIndex2;
    }

    /* renamed from: placeSelfApparentToRealOffset-f8xVGno  reason: not valid java name */
    public final void m4940placeSelfApparentToRealOffsetf8xVGno(long position2, float zIndex2, Function1<? super GraphicsLayerScope, Unit> layerBlock2) {
        long other$iv = m4723getApparentToRealOffsetnOccac();
        m4920placeSelff8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position2) + IntOffset.m5962getXimpl(other$iv), IntOffset.m5963getYimpl(position2) + IntOffset.m5963getYimpl(other$iv)), zIndex2, layerBlock2);
    }

    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        OwnedLayer layer2 = this.layer;
        if (layer2 != null) {
            layer2.drawLayer(canvas);
            return;
        }
        float x = (float) IntOffset.m5962getXimpl(m4929getPositionnOccac());
        float y = (float) IntOffset.m5963getYimpl(m4929getPositionnOccac());
        canvas.translate(x, y);
        drawContainedDrawModifiers(canvas);
        canvas.translate(-x, -y);
    }

    /* access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas) {
        Modifier.Node head = m4931headH91voCI(NodeKind.m4956constructorimpl(4));
        if (head == null) {
            performDraw(canvas);
            return;
        }
        getLayoutNode().getMDrawScope$ui_release().m4838drawx_KDEd0$ui_release(canvas, IntSizeKt.m6014toSizeozmzZPI(m4930getSizeYbymL2g()), this, head);
    }

    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas);
        }
    }

    public final void onPlaced() {
        int i;
        NodeCoordinator this_$iv;
        int type$iv;
        int i2;
        int type$iv2;
        NodeCoordinator this_$iv2;
        int i3;
        int type$iv3;
        NodeCoordinator this_$iv3;
        int i4;
        int type$iv4;
        MutableVector mutableVector;
        int type$iv5 = NodeKind.m4956constructorimpl(128);
        NodeCoordinator this_$iv4 = this;
        int i5 = false;
        boolean includeTail$iv$iv = NodeKindKt.m4965getIncludeSelfInTraversalH91voCI(type$iv5);
        NodeCoordinator this_$iv$iv = this_$iv4;
        int mask$iv$iv = type$iv5;
        Modifier.Node stopNode$iv$iv = this_$iv$iv.getTail();
        if (!includeTail$iv$iv && (stopNode$iv$iv = stopNode$iv$iv.getParent$ui_release()) == null) {
            int i6 = type$iv5;
            NodeCoordinator nodeCoordinator = this_$iv4;
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
                            ((LayoutAwareModifierNode) node).onPlaced(this);
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
                    type$iv2 = type$iv;
                    this_$iv2 = this_$iv;
                    i2 = i;
                } else {
                    type$iv2 = type$iv;
                    this_$iv2 = this_$iv;
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
                NodeCoordinator nodeCoordinator2 = this_$iv;
                int i8 = i;
                return;
            }
        }
        NodeCoordinator nodeCoordinator3 = this_$iv;
        int i9 = i;
    }

    public void invoke(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getLayoutNode().isPlaced()) {
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayer, new NodeCoordinator$invoke$1(this, canvas));
            this.lastLayerDrawingWasSkipped = false;
            return;
        }
        this.lastLayerDrawingWasSkipped = true;
    }

    public static /* synthetic */ void updateLayerBlock$default(NodeCoordinator nodeCoordinator, Function1 function1, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            nodeCoordinator.updateLayerBlock(function1, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
    }

    public final void updateLayerBlock(Function1<? super GraphicsLayerScope, Unit> layerBlock2, boolean forceUpdateLayerParameters) {
        Owner owner$ui_release;
        LayoutNode layoutNode2 = getLayoutNode();
        boolean updateParameters = forceUpdateLayerParameters || this.layerBlock != layerBlock2 || !Intrinsics.areEqual((Object) this.layerDensity, (Object) layoutNode2.getDensity()) || this.layerLayoutDirection != layoutNode2.getLayoutDirection();
        this.layerBlock = layerBlock2;
        this.layerDensity = layoutNode2.getDensity();
        this.layerLayoutDirection = layoutNode2.getLayoutDirection();
        if (!isAttached() || layerBlock2 == null) {
            OwnedLayer it = this.layer;
            if (it != null) {
                it.destroy();
                layoutNode2.setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                if (isAttached() && (owner$ui_release = layoutNode2.getOwner$ui_release()) != null) {
                    owner$ui_release.onLayoutChange(layoutNode2);
                }
            }
            this.layer = null;
            this.lastLayerDrawingWasSkipped = false;
        } else if (this.layer == null) {
            OwnedLayer createLayer = LayoutNodeKt.requireOwner(layoutNode2).createLayer(this, this.invalidateParentLayer);
            OwnedLayer $this$updateLayerBlock_u24lambda_u2413 = createLayer;
            $this$updateLayerBlock_u24lambda_u2413.m5008resizeozmzZPI(m4724getMeasuredSizeYbymL2g());
            $this$updateLayerBlock_u24lambda_u2413.m5007movegyyYBs(m4929getPositionnOccac());
            this.layer = createLayer;
            updateLayerParameters$default(this, false, 1, (Object) null);
            layoutNode2.setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
        } else if (updateParameters) {
            updateLayerParameters$default(this, false, 1, (Object) null);
        }
    }

    static /* synthetic */ void updateLayerParameters$default(NodeCoordinator nodeCoordinator, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            nodeCoordinator.updateLayerParameters(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
    }

    private final void updateLayerParameters(boolean invokeOnLayoutChange) {
        Owner owner$ui_release;
        OwnedLayer layer2 = this.layer;
        if (layer2 != null) {
            Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
            if (function1 != null) {
                Function1<? super GraphicsLayerScope, Unit> function12 = function1;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
                reusableGraphicsLayerScope.reset();
                reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
                reusableGraphicsLayerScope.m3593setSizeuvyYCjk(IntSizeKt.m6014toSizeozmzZPI(m4930getSizeYbymL2g()));
                getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new NodeCoordinator$updateLayerParameters$1(function12));
                LayerPositionalProperties it = this.layerPositionalProperties;
                if (it == null) {
                    it = new LayerPositionalProperties();
                    this.layerPositionalProperties = it;
                }
                LayerPositionalProperties layerPositionalProperties2 = it;
                layerPositionalProperties2.copyFrom((GraphicsLayerScope) reusableGraphicsLayerScope);
                LayerPositionalProperties layerPositionalProperties3 = layerPositionalProperties2;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = reusableGraphicsLayerScope;
                Function1<? super GraphicsLayerScope, Unit> function13 = function12;
                OwnedLayer ownedLayer = layer2;
                layer2.m5010updateLayerPropertiesdDxrwY(reusableGraphicsLayerScope.getScaleX(), reusableGraphicsLayerScope.getScaleY(), reusableGraphicsLayerScope.getAlpha(), reusableGraphicsLayerScope.getTranslationX(), reusableGraphicsLayerScope.getTranslationY(), reusableGraphicsLayerScope.getShadowElevation(), reusableGraphicsLayerScope.getRotationX(), reusableGraphicsLayerScope.getRotationY(), reusableGraphicsLayerScope.getRotationZ(), reusableGraphicsLayerScope.getCameraDistance(), reusableGraphicsLayerScope.m3590getTransformOriginSzJe1aQ(), reusableGraphicsLayerScope.getShape(), reusableGraphicsLayerScope2.getClip(), reusableGraphicsLayerScope2.getRenderEffect(), reusableGraphicsLayerScope.m3586getAmbientShadowColor0d7_KjU(), reusableGraphicsLayerScope.m3589getSpotShadowColor0d7_KjU(), reusableGraphicsLayerScope2.m3587getCompositingStrategyNrFUSI(), getLayoutNode().getLayoutDirection(), getLayoutNode().getDensity());
                this.isClipping = reusableGraphicsLayerScope2.getClip();
                this.lastLayerAlpha = reusableGraphicsLayerScope2.getAlpha();
                if (invokeOnLayoutChange && (owner$ui_release = getLayoutNode().getOwner$ui_release()) != null) {
                    owner$ui_release.onLayoutChange(getLayoutNode());
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (!(this.layerBlock == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final boolean getLastLayerDrawingWasSkipped$ui_release() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    public boolean isValidOwnerScope() {
        return this.layer != null && isAttached();
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc  reason: not valid java name */
    public final long m4928getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.m5826toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().m5131getMinimumTouchTargetSizeMYxV2XQ());
    }

    /* renamed from: hitTest-YqVAtuI  reason: not valid java name */
    public final void m4932hitTestYqVAtuI(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        float f;
        long j = pointerPosition;
        HitTestResult hitTestResult2 = hitTestResult;
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult2, "hitTestResult");
        Modifier.Node head = m4931headH91voCI(hitTestSource.m4952entityTypeOLwlOKw());
        boolean z = true;
        if (!m4946withinLayerBoundsk4lQ0M(j)) {
            if (isTouchEvent) {
                float distanceFromEdge = m4925distanceInMinimumTouchTargettz77jQw(j, m4928getMinimumTouchTargetSizeNHjbRc());
                if (Float.isInfinite(distanceFromEdge) || Float.isNaN(distanceFromEdge)) {
                    z = false;
                }
                if (z && hitTestResult2.isHitInMinimumTouchTargetBetter(distanceFromEdge, false)) {
                    m4918hitNearJHbHoSQ(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, false, distanceFromEdge);
                }
            }
        } else if (head == null) {
            m4933hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        } else if (m4934isPointerInBoundsk4lQ0M(j)) {
            m4917hit1hIXUjU(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        } else {
            if (!isTouchEvent) {
                f = Float.POSITIVE_INFINITY;
            } else {
                f = m4925distanceInMinimumTouchTargettz77jQw(j, m4928getMinimumTouchTargetSizeNHjbRc());
            }
            float distanceFromEdge2 = f;
            if (Float.isInfinite(distanceFromEdge2) || Float.isNaN(distanceFromEdge2)) {
                z = false;
            }
            if (!z || !hitTestResult2.isHitInMinimumTouchTargetBetter(distanceFromEdge2, isInLayer)) {
                m4921speculativeHitJHbHoSQ(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge2);
            } else {
                m4918hitNearJHbHoSQ(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hit-1hIXUjU  reason: not valid java name */
    public final void m4917hit1hIXUjU(Modifier.Node $this$hit_u2d1hIXUjU, HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        if ($this$hit_u2d1hIXUjU == null) {
            m4933hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            HitTestResult hitTestResult2 = hitTestResult;
            boolean z = isInLayer;
            return;
        }
        hitTestResult.hit($this$hit_u2d1hIXUjU, isInLayer, new NodeCoordinator$hit$1(this, $this$hit_u2d1hIXUjU, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer));
    }

    /* access modifiers changed from: private */
    /* renamed from: hitNear-JHbHoSQ  reason: not valid java name */
    public final void m4918hitNearJHbHoSQ(Modifier.Node $this$hitNear_u2dJHbHoSQ, HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer, float distanceFromEdge) {
        if ($this$hitNear_u2dJHbHoSQ == null) {
            m4933hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            HitTestResult hitTestResult2 = hitTestResult;
            boolean z = isInLayer;
            float f = distanceFromEdge;
            return;
        }
        float f2 = distanceFromEdge;
        hitTestResult.hitInMinimumTouchTarget($this$hitNear_u2dJHbHoSQ, f2, isInLayer, new NodeCoordinator$hitNear$1(this, $this$hitNear_u2dJHbHoSQ, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge));
    }

    /* access modifiers changed from: private */
    /* renamed from: speculativeHit-JHbHoSQ  reason: not valid java name */
    public final void m4921speculativeHitJHbHoSQ(Modifier.Node $this$speculativeHit_u2dJHbHoSQ, HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer, float distanceFromEdge) {
        Modifier.Node node = $this$speculativeHit_u2dJHbHoSQ;
        if (node == null) {
            m4933hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            HitTestSource hitTestSource2 = hitTestSource;
            HitTestResult hitTestResult2 = hitTestResult;
            boolean z = isInLayer;
            float f = distanceFromEdge;
        } else if (hitTestSource.interceptOutOfBoundsChildEvents(node)) {
            float f2 = distanceFromEdge;
            hitTestResult.speculativeHit(node, f2, isInLayer, new NodeCoordinator$speculativeHit$1(this, $this$speculativeHit_u2dJHbHoSQ, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge));
        } else {
            HitTestResult hitTestResult3 = hitTestResult;
            boolean z2 = isInLayer;
            float f3 = distanceFromEdge;
            m4921speculativeHitJHbHoSQ(NodeCoordinatorKt.m4954nextUntilhw7D004(node, hitTestSource.m4952entityTypeOLwlOKw(), NodeKind.m4956constructorimpl(2)), hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge);
        }
    }

    /* renamed from: hitTestChild-YqVAtuI  reason: not valid java name */
    public void m4933hitTestChildYqVAtuI(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        NodeCoordinator wrapped2 = this.wrapped;
        if (wrapped2 != null) {
            wrapped2.m4932hitTestYqVAtuI(hitTestSource, wrapped2.m4926fromParentPositionMKHz9U(pointerPosition), hitTestResult, isTouchEvent, isInLayer);
        } else {
            long j = pointerPosition;
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates root = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect bounds = getRectCache();
        long padding = m4924calculateMinimumTouchTargetPaddingE7KxVPU(m4928getMinimumTouchTargetSizeNHjbRc());
        bounds.setLeft(-Size.m3072getWidthimpl(padding));
        bounds.setTop(-Size.m3069getHeightimpl(padding));
        bounds.setRight(((float) getMeasuredWidth()) + Size.m3072getWidthimpl(padding));
        bounds.setBottom(((float) getMeasuredHeight()) + Size.m3069getHeightimpl(padding));
        NodeCoordinator coordinator = this;
        while (coordinator != root) {
            coordinator.rectInParent$ui_release(bounds, false, true);
            if (bounds.isEmpty()) {
                return Rect.Companion.getZero();
            }
            NodeCoordinator nodeCoordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            coordinator = nodeCoordinator;
        }
        return MutableRectKt.toRect(bounds);
    }

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    public long m4945windowToLocalMKHz9U(long relativeToWindow) {
        if (isAttached()) {
            LayoutCoordinates root = LayoutCoordinatesKt.findRootCoordinates(this);
            return m4935localPositionOfR5De75A(root, Offset.m3007minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).m5011calculateLocalPositionMKHz9U(relativeToWindow), LayoutCoordinatesKt.positionInRoot(root)));
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    public long m4937localToWindowMKHz9U(long relativeToLocal) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).m5012calculatePositionInWindowMKHz9U(m4936localToRootMKHz9U(relativeToLocal));
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates $this$toCoordinator) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl = $this$toCoordinator instanceof LookaheadLayoutCoordinatesImpl ? (LookaheadLayoutCoordinatesImpl) $this$toCoordinator : null;
        if (lookaheadLayoutCoordinatesImpl != null && (coordinator = lookaheadLayoutCoordinatesImpl.getCoordinator()) != null) {
            return coordinator;
        }
        Intrinsics.checkNotNull($this$toCoordinator, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) $this$toCoordinator;
    }

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    public long m4935localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        if (sourceCoordinates instanceof LookaheadLayoutCoordinatesImpl) {
            return Offset.m3012unaryMinusF1C5BW0(sourceCoordinates.m4651localPositionOfR5De75A(this, Offset.m3012unaryMinusF1C5BW0(relativeToSource)));
        }
        NodeCoordinator nodeCoordinator = toCoordinator(sourceCoordinates);
        nodeCoordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator commonAncestor = findCommonAncestor$ui_release(nodeCoordinator);
        long position2 = relativeToSource;
        NodeCoordinator coordinator = nodeCoordinator;
        while (coordinator != commonAncestor) {
            position2 = coordinator.m4942toParentPositionMKHz9U(position2);
            NodeCoordinator nodeCoordinator2 = coordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
            coordinator = nodeCoordinator2;
        }
        return m4915ancestorToLocalR5De75A(commonAncestor, position2);
    }

    /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
    public void m4943transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator commonAncestor = findCommonAncestor$ui_release(coordinator);
        Matrix.m3491resetimpl(matrix);
        coordinator.m4923transformToAncestorEL8BTi8(commonAncestor, matrix);
        m4922transformFromAncestorEL8BTi8(commonAncestor, matrix);
    }

    /* renamed from: transformToAncestor-EL8BTi8  reason: not valid java name */
    private final void m4923transformToAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        NodeCoordinator wrapper = this;
        while (!Intrinsics.areEqual((Object) wrapper, (Object) ancestor)) {
            OwnedLayer ownedLayer = wrapper.layer;
            if (ownedLayer != null) {
                ownedLayer.m5009transform58bKbWc(matrix);
            }
            long position2 = wrapper.m4929getPositionnOccac();
            if (!IntOffset.m5961equalsimpl0(position2, IntOffset.Companion.m5972getZeronOccac())) {
                float[] fArr = tmpMatrix;
                Matrix.m3491resetimpl(fArr);
                Matrix.m3502translateimpl$default(fArr, (float) IntOffset.m5962getXimpl(position2), (float) IntOffset.m5963getYimpl(position2), 0.0f, 4, (Object) null);
                Matrix.m3499timesAssign58bKbWc(matrix, fArr);
            }
            NodeCoordinator nodeCoordinator = wrapper.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            wrapper = nodeCoordinator;
        }
    }

    /* renamed from: transformFromAncestor-EL8BTi8  reason: not valid java name */
    private final void m4922transformFromAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        if (!Intrinsics.areEqual((Object) ancestor, (Object) this)) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            nodeCoordinator.m4922transformFromAncestorEL8BTi8(ancestor, matrix);
            if (!IntOffset.m5961equalsimpl0(m4929getPositionnOccac(), IntOffset.Companion.m5972getZeronOccac())) {
                float[] fArr = tmpMatrix;
                Matrix.m3491resetimpl(fArr);
                Matrix.m3502translateimpl$default(fArr, -((float) IntOffset.m5962getXimpl(m4929getPositionnOccac())), -((float) IntOffset.m5963getYimpl(m4929getPositionnOccac())), 0.0f, 4, (Object) null);
                Matrix.m3499timesAssign58bKbWc(matrix, fArr);
            }
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.m5004inverseTransform58bKbWc(matrix);
            }
        }
    }

    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        } else if (sourceCoordinates.isAttached()) {
            NodeCoordinator srcCoordinator = toCoordinator(sourceCoordinates);
            srcCoordinator.onCoordinatesUsed$ui_release();
            NodeCoordinator commonAncestor = findCommonAncestor$ui_release(srcCoordinator);
            MutableRect bounds = getRectCache();
            bounds.setLeft(0.0f);
            bounds.setTop(0.0f);
            bounds.setRight((float) IntSize.m6004getWidthimpl(sourceCoordinates.m4650getSizeYbymL2g()));
            bounds.setBottom((float) IntSize.m6003getHeightimpl(sourceCoordinates.m4650getSizeYbymL2g()));
            NodeCoordinator coordinator = srcCoordinator;
            while (coordinator != commonAncestor) {
                rectInParent$ui_release$default(coordinator, bounds, clipBounds, false, 4, (Object) null);
                if (bounds.isEmpty()) {
                    return Rect.Companion.getZero();
                }
                NodeCoordinator nodeCoordinator = coordinator.wrappedBy;
                Intrinsics.checkNotNull(nodeCoordinator);
                coordinator = nodeCoordinator;
            }
            ancestorToLocal(commonAncestor, bounds, clipBounds);
            return MutableRectKt.toRect(bounds);
        } else {
            throw new IllegalStateException(("LayoutCoordinates " + sourceCoordinates + " is not attached!").toString());
        }
    }

    /* renamed from: ancestorToLocal-R5De75A  reason: not valid java name */
    private final long m4915ancestorToLocalR5De75A(NodeCoordinator ancestor, long offset) {
        if (ancestor == this) {
            return offset;
        }
        NodeCoordinator wrappedBy2 = this.wrappedBy;
        if (wrappedBy2 == null || Intrinsics.areEqual((Object) ancestor, (Object) wrappedBy2)) {
            return m4926fromParentPositionMKHz9U(offset);
        }
        return m4926fromParentPositionMKHz9U(wrappedBy2.m4915ancestorToLocalR5De75A(ancestor, offset));
    }

    private final void ancestorToLocal(NodeCoordinator ancestor, MutableRect rect, boolean clipBounds) {
        if (ancestor != this) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                nodeCoordinator.ancestorToLocal(ancestor, rect, clipBounds);
            }
            fromParentRect(rect, clipBounds);
        }
    }

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    public long m4936localToRootMKHz9U(long relativeToLocal) {
        if (isAttached()) {
            onCoordinatesUsed$ui_release();
            long position2 = relativeToLocal;
            for (NodeCoordinator coordinator = this; coordinator != null; coordinator = coordinator.wrappedBy) {
                position2 = coordinator.m4942toParentPositionMKHz9U(position2);
            }
            return position2;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* access modifiers changed from: protected */
    public final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(block, "block");
        float x = (float) IntOffset.m5962getXimpl(m4929getPositionnOccac());
        float y = (float) IntOffset.m5963getYimpl(m4929getPositionnOccac());
        canvas.translate(x, y);
        block.invoke(canvas);
        canvas.translate(-x, -y);
    }

    /* renamed from: toParentPosition-MK-Hz9U  reason: not valid java name */
    public long m4942toParentPositionMKHz9U(long position2) {
        OwnedLayer layer2 = this.layer;
        return IntOffsetKt.m5976plusNvtHpc(layer2 != null ? layer2.m5006mapOffset8S9VItk(position2, false) : position2, m4929getPositionnOccac());
    }

    /* renamed from: fromParentPosition-MK-Hz9U  reason: not valid java name */
    public long m4926fromParentPositionMKHz9U(long position2) {
        long relativeToPosition = IntOffsetKt.m5974minusNvtHpc(position2, m4929getPositionnOccac());
        OwnedLayer layer2 = this.layer;
        if (layer2 != null) {
            return layer2.m5006mapOffset8S9VItk(relativeToPosition, true);
        }
        return relativeToPosition;
    }

    /* access modifiers changed from: protected */
    public final void drawBorder(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawRect(new Rect(0.5f, 0.5f, ((float) IntSize.m6004getWidthimpl(m4724getMeasuredSizeYbymL2g())) - 0.5f, ((float) IntSize.m6003getHeightimpl(m4724getMeasuredSizeYbymL2g())) - 0.5f), paint);
    }

    public final void onLayoutNodeAttach() {
        updateLayerBlock(this.layerBlock, true);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onRelease() {
        this.released = true;
        if (this.layer != null) {
            updateLayerBlock$default(this, (Function1) null, false, 2, (Object) null);
        }
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
    }

    public final void rectInParent$ui_release(MutableRect bounds, boolean clipBounds, boolean clipToMinimumTouchTargetSize) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        OwnedLayer layer2 = this.layer;
        if (layer2 != null) {
            if (this.isClipping) {
                if (clipToMinimumTouchTargetSize) {
                    long minTouch = m4928getMinimumTouchTargetSizeNHjbRc();
                    float horz = Size.m3072getWidthimpl(minTouch) / 2.0f;
                    float vert = Size.m3069getHeightimpl(minTouch) / 2.0f;
                    bounds.intersect(-horz, -vert, ((float) IntSize.m6004getWidthimpl(m4930getSizeYbymL2g())) + horz, ((float) IntSize.m6003getHeightimpl(m4930getSizeYbymL2g())) + vert);
                } else if (clipBounds) {
                    bounds.intersect(0.0f, 0.0f, (float) IntSize.m6004getWidthimpl(m4930getSizeYbymL2g()), (float) IntSize.m6003getHeightimpl(m4930getSizeYbymL2g()));
                }
                if (bounds.isEmpty()) {
                    return;
                }
            }
            layer2.mapBounds(bounds, false);
        }
        int x = IntOffset.m5962getXimpl(m4929getPositionnOccac());
        bounds.setLeft(bounds.getLeft() + ((float) x));
        bounds.setRight(bounds.getRight() + ((float) x));
        int y = IntOffset.m5963getYimpl(m4929getPositionnOccac());
        bounds.setTop(bounds.getTop() + ((float) y));
        bounds.setBottom(bounds.getBottom() + ((float) y));
    }

    private final void fromParentRect(MutableRect bounds, boolean clipBounds) {
        int x = IntOffset.m5962getXimpl(m4929getPositionnOccac());
        bounds.setLeft(bounds.getLeft() - ((float) x));
        bounds.setRight(bounds.getRight() - ((float) x));
        int y = IntOffset.m5963getYimpl(m4929getPositionnOccac());
        bounds.setTop(bounds.getTop() - ((float) y));
        bounds.setBottom(bounds.getBottom() - ((float) y));
        OwnedLayer layer2 = this.layer;
        if (layer2 != null) {
            layer2.mapBounds(bounds, true);
            if (this.isClipping && clipBounds) {
                bounds.intersect(0.0f, 0.0f, (float) IntSize.m6004getWidthimpl(m4930getSizeYbymL2g()), (float) IntSize.m6003getHeightimpl(m4930getSizeYbymL2g()));
                bounds.isEmpty();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: withinLayerBounds-k-4lQ0M  reason: not valid java name */
    public final boolean m4946withinLayerBoundsk4lQ0M(long pointerPosition) {
        if (!OffsetKt.m3020isFinitek4lQ0M(pointerPosition)) {
            return false;
        }
        OwnedLayer layer2 = this.layer;
        if (layer2 == null || !this.isClipping || layer2.m5005isInLayerk4lQ0M(pointerPosition)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: isPointerInBounds-k-4lQ0M  reason: not valid java name */
    public final boolean m4934isPointerInBoundsk4lQ0M(long pointerPosition) {
        float x = Offset.m3003getXimpl(pointerPosition);
        float y = Offset.m3004getYimpl(pointerPosition);
        return x >= 0.0f && y >= 0.0f && x < ((float) getMeasuredWidth()) && y < ((float) getMeasuredHeight());
    }

    public void invalidateLayer() {
        OwnedLayer layer2 = this.layer;
        if (layer2 != null) {
            layer2.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    static /* synthetic */ Object propagateRelocationRequest$suspendImpl(NodeCoordinator $this, Rect rect, Continuation<? super Unit> $completion) {
        NodeCoordinator parent = $this.wrappedBy;
        if (parent == null) {
            return Unit.INSTANCE;
        }
        Object propagateRelocationRequest = parent.propagateRelocationRequest(rect.m3040translatek4lQ0M(parent.localBoundingBoxOf($this, false).m3038getTopLeftF1C5BW0()), $completion);
        return propagateRelocationRequest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? propagateRelocationRequest : Unit.INSTANCE;
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator other) {
        Intrinsics.checkNotNullParameter(other, "other");
        LayoutNode ancestor1 = other.getLayoutNode();
        LayoutNode ancestor2 = getLayoutNode();
        if (ancestor1 == ancestor2) {
            Modifier.Node otherNode = other.getTail();
            DelegatableNode $this$visitLocalAncestors$iv = getTail();
            int mask$iv = NodeKind.m4956constructorimpl(2);
            if ($this$visitLocalAncestors$iv.getNode().isAttached()) {
                for (Modifier.Node next$iv = $this$visitLocalAncestors$iv.getNode().getParent$ui_release(); next$iv != null; next$iv = next$iv.getParent$ui_release()) {
                    if ((next$iv.getKindSet$ui_release() & mask$iv) != 0 && next$iv == otherNode) {
                        return other;
                    }
                }
                return this;
            }
            throw new IllegalStateException("visitLocalAncestors called on an unattached node".toString());
        }
        while (ancestor1.getDepth$ui_release() > ancestor2.getDepth$ui_release()) {
            LayoutNode parent$ui_release = ancestor1.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release);
            ancestor1 = parent$ui_release;
        }
        while (ancestor2.getDepth$ui_release() > ancestor1.getDepth$ui_release()) {
            LayoutNode parent$ui_release2 = ancestor2.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release2);
            ancestor2 = parent$ui_release2;
        }
        while (ancestor1 != ancestor2) {
            LayoutNode parent1 = ancestor1.getParent$ui_release();
            LayoutNode parent2 = ancestor2.getParent$ui_release();
            if (parent1 == null || parent2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
            ancestor1 = parent1;
            ancestor2 = parent2;
        }
        if (ancestor2 == getLayoutNode()) {
            return this;
        }
        if (ancestor1 == other.getLayoutNode()) {
            return other;
        }
        return ancestor1.getInnerCoordinator$ui_release();
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        int type$iv;
        Modifier.Node start;
        int type$iv2;
        int type$iv3;
        int count$iv$iv;
        MutableVector mutableVector;
        Modifier.Node start2 = headNode(NodeKindKt.m4965getIncludeSelfInTraversalH91voCI(NodeKind.m4956constructorimpl(16)));
        if (start2 == null) {
            return false;
        }
        int type$iv4 = NodeKind.m4956constructorimpl(16);
        int mask$iv$iv = type$iv4;
        DelegatableNode $this$visitLocalDescendants$iv$iv = start2;
        if ($this$visitLocalDescendants$iv$iv.getNode().isAttached()) {
            Modifier.Node self$iv$iv = $this$visitLocalDescendants$iv$iv.getNode();
            if ((self$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                Modifier.Node next$iv$iv = self$iv$iv.getChild$ui_release();
                while (next$iv$iv != null) {
                    if ((next$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                        MutableVector mutableVector2 = null;
                        Modifier.Node this_$iv$iv$iv = next$iv$iv;
                        while (this_$iv$iv$iv != null) {
                            Modifier.Node start3 = start;
                            int i = 1;
                            if (!(this_$iv$iv$iv instanceof PointerInputModifierNode)) {
                                if (((this_$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0 ? 1 : null) == null || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                                    type$iv2 = type$iv;
                                } else {
                                    int count$iv$iv2 = 0;
                                    Modifier.Node node$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                                    while (node$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv2 = node$iv$iv$iv;
                                        if (((next$iv$iv2.getKindSet$ui_release() & type$iv) != 0 ? i : 0) != 0) {
                                            count$iv$iv2++;
                                            if (count$iv$iv2 == i) {
                                                this_$iv$iv$iv = next$iv$iv2;
                                                type$iv3 = type$iv;
                                                Modifier.Node node = next$iv$iv2;
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
                                                mutableVector2 = mutableVector;
                                                Modifier.Node theNode$iv$iv = this_$iv$iv$iv;
                                                if (theNode$iv$iv != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(theNode$iv$iv);
                                                    }
                                                    this_$iv$iv$iv = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(next$iv$iv2);
                                                }
                                                count$iv$iv2 = count$iv$iv;
                                            }
                                        } else {
                                            type$iv3 = type$iv;
                                            Modifier.Node node2 = next$iv$iv2;
                                        }
                                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                        type$iv = type$iv3;
                                        i = 1;
                                    }
                                    type$iv2 = type$iv;
                                    if (count$iv$iv2 == 1) {
                                        start = start3;
                                        type$iv = type$iv2;
                                    }
                                }
                            } else if (((PointerInputModifierNode) this_$iv$iv$iv).sharePointerInputWithSiblings()) {
                                return true;
                            } else {
                                type$iv2 = type$iv;
                            }
                            this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector2);
                            start = start3;
                            type$iv = type$iv2;
                        }
                        continue;
                    }
                    next$iv$iv = next$iv$iv.getChild$ui_release();
                    start2 = start;
                    type$iv4 = type$iv;
                }
                int i2 = type$iv;
                return false;
            }
            int i3 = type$iv4;
            return false;
        }
        int i4 = type$iv4;
        throw new IllegalStateException("visitLocalDescendants called on an unattached node".toString());
    }

    /* renamed from: offsetFromEdge-MK-Hz9U  reason: not valid java name */
    private final long m4919offsetFromEdgeMKHz9U(long pointerPosition) {
        float x = Offset.m3003getXimpl(pointerPosition);
        float horizontal = Math.max(0.0f, x < 0.0f ? -x : x - ((float) getMeasuredWidth()));
        float y = Offset.m3004getYimpl(pointerPosition);
        return OffsetKt.Offset(horizontal, Math.max(0.0f, y < 0.0f ? -y : y - ((float) getMeasuredHeight())));
    }

    /* access modifiers changed from: protected */
    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU  reason: not valid java name */
    public final long m4924calculateMinimumTouchTargetPaddingE7KxVPU(long minimumTouchTargetSize) {
        return SizeKt.Size(Math.max(0.0f, (Size.m3072getWidthimpl(minimumTouchTargetSize) - ((float) getMeasuredWidth())) / 2.0f), Math.max(0.0f, (Size.m3069getHeightimpl(minimumTouchTargetSize) - ((float) getMeasuredHeight())) / 2.0f));
    }

    /* access modifiers changed from: protected */
    /* renamed from: distanceInMinimumTouchTarget-tz77jQw  reason: not valid java name */
    public final float m4925distanceInMinimumTouchTargettz77jQw(long pointerPosition, long minimumTouchTargetSize) {
        if (((float) getMeasuredWidth()) >= Size.m3072getWidthimpl(minimumTouchTargetSize) && ((float) getMeasuredHeight()) >= Size.m3069getHeightimpl(minimumTouchTargetSize)) {
            return Float.POSITIVE_INFINITY;
        }
        long r2 = m4924calculateMinimumTouchTargetPaddingE7KxVPU(minimumTouchTargetSize);
        float width = Size.m3072getWidthimpl(r2);
        float height = Size.m3069getHeightimpl(r2);
        long offsetFromEdge = m4919offsetFromEdgeMKHz9U(pointerPosition);
        if ((width > 0.0f || height > 0.0f) && Offset.m3003getXimpl(offsetFromEdge) <= width && Offset.m3004getYimpl(offsetFromEdge) <= height) {
            return Offset.m3002getDistanceSquaredimpl(offsetFromEdge);
        }
        return Float.POSITIVE_INFINITY;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\u00020\u0016X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0017\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NodeCoordinator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HitTestSource getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }
}

package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001c\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010'J¦\u0002\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-2\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\"\u001a\u00020!2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00108\u001a\u0002092\u0013\b\u0002\u0010:\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-H\u0007¢\u0006\u0002\u0010;J7\u0010<\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001c\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010'JS\u0010=\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010>\u001a\u00020\u00042\b\b\u0002\u0010?\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u0002\u0010B\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-2\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\"\u001a\u00020!2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00108\u001a\u0002092\u0013\b\u0002\u0010:\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-H\u0007¢\u0006\u0002\u0010CJî\u0001\u0010B\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-2\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\"\u001a\u00020!2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00108\u001a\u0002092\u0013\b\u0002\u0010:\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-H\u0007¢\u0006\u0002\u0010DJ¦\u0002\u0010E\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-2\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\"\u001a\u00020!2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00108\u001a\u0002092\u0013\b\u0002\u0010:\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-H\u0007¢\u0006\u0002\u0010;Jø\u0001\u0010E\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-2\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\"\u001a\u00020!2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010,¢\u0006\u0002\b-2\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00108\u001a\u0002092\u0013\b\u0002\u0010:\u001a\r\u0012\u0004\u0012\u00020\u001f0,¢\u0006\u0002\b-H\u0007¢\u0006\u0002\u0010FJÃ\u0003\u0010%\u001a\u00020&2\b\b\u0002\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020H2\b\b\u0002\u0010J\u001a\u00020H2\b\b\u0002\u0010K\u001a\u00020H2\b\b\u0002\u0010L\u001a\u00020H2\b\b\u0002\u0010M\u001a\u00020H2\b\b\u0002\u0010N\u001a\u00020H2\b\b\u0002\u0010O\u001a\u00020H2\b\b\u0002\u0010P\u001a\u00020H2\b\b\u0002\u0010Q\u001a\u00020H2\b\b\u0002\u0010R\u001a\u00020S2\b\b\u0002\u0010T\u001a\u00020H2\b\b\u0002\u0010U\u001a\u00020H2\b\b\u0002\u0010V\u001a\u00020H2\b\b\u0002\u0010W\u001a\u00020H2\b\b\u0002\u0010X\u001a\u00020H2\b\b\u0002\u0010Y\u001a\u00020H2\b\b\u0002\u0010Z\u001a\u00020H2\b\b\u0002\u0010[\u001a\u00020H2\b\b\u0002\u0010\\\u001a\u00020H2\b\b\u0002\u0010]\u001a\u00020H2\b\b\u0002\u0010^\u001a\u00020H2\b\b\u0002\u0010_\u001a\u00020H2\b\b\u0002\u0010`\u001a\u00020H2\b\b\u0002\u0010a\u001a\u00020H2\b\b\u0002\u0010b\u001a\u00020H2\b\b\u0002\u0010c\u001a\u00020H2\b\b\u0002\u0010d\u001a\u00020H2\b\b\u0002\u0010e\u001a\u00020H2\b\b\u0002\u0010f\u001a\u00020H2\b\b\u0002\u0010g\u001a\u00020H2\b\b\u0002\u0010h\u001a\u00020H2\b\b\u0002\u0010i\u001a\u00020H2\b\b\u0002\u0010j\u001a\u00020H2\b\b\u0002\u0010k\u001a\u00020H2\b\b\u0002\u0010l\u001a\u00020H2\b\b\u0002\u0010m\u001a\u00020H2\b\b\u0002\u0010n\u001a\u00020H2\b\b\u0002\u0010o\u001a\u00020H2\b\b\u0002\u0010p\u001a\u00020H2\b\b\u0002\u0010q\u001a\u00020H2\b\b\u0002\u0010r\u001a\u00020H2\b\b\u0002\u0010s\u001a\u00020HH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bt\u0010uJ;\u0010v\u001a\u0002092\b\b\u0002\u0010w\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b{\u0010|J;\u0010}\u001a\u0002092\b\b\u0002\u0010w\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b~\u0010|J\u0003\u0010\u001a\u00020&2\t\b\u0002\u0010\u0001\u001a\u00020H2\b\b\u0002\u0010J\u001a\u00020H2\t\b\u0002\u0010\u0001\u001a\u00020H2\b\b\u0002\u0010P\u001a\u00020H2\b\b\u0002\u0010Q\u001a\u00020H2\b\b\u0002\u0010R\u001a\u00020S2\t\b\u0002\u0010\u0001\u001a\u00020H2\t\b\u0002\u0010\u0001\u001a\u00020H2\t\b\u0002\u0010\u0001\u001a\u00020H2\t\b\u0002\u0010\u0001\u001a\u00020H2\b\b\u0002\u0010X\u001a\u00020H2\b\b\u0002\u0010Y\u001a\u00020H2\b\b\u0002\u0010Z\u001a\u00020H2\b\b\u0002\u0010[\u001a\u00020H2\b\b\u0002\u0010\\\u001a\u00020H2\b\b\u0002\u0010]\u001a\u00020H2\b\b\u0002\u0010^\u001a\u00020H2\b\b\u0002\u0010_\u001a\u00020H2\b\b\u0002\u0010`\u001a\u00020H2\b\b\u0002\u0010a\u001a\u00020H2\b\b\u0002\u0010b\u001a\u00020H2\b\b\u0002\u0010c\u001a\u00020H2\t\b\u0002\u0010\u0001\u001a\u00020H2\b\b\u0002\u0010f\u001a\u00020H2\b\b\u0002\u0010h\u001a\u00020H2\b\b\u0002\u0010i\u001a\u00020H2\b\b\u0002\u0010j\u001a\u00020H2\b\b\u0002\u0010k\u001a\u00020H2\b\b\u0002\u0010l\u001a\u00020H2\b\b\u0002\u0010m\u001a\u00020H2\b\b\u0002\u0010n\u001a\u00020H2\b\b\u0002\u0010o\u001a\u00020H2\b\b\u0002\u0010p\u001a\u00020H2\b\b\u0002\u0010q\u001a\u00020H2\b\b\u0002\u0010r\u001a\u00020H2\b\b\u0002\u0010s\u001a\u00020HH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J¶\u0003\u0010\u001a\u00020&2\b\b\u0002\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020H2\b\b\u0002\u0010J\u001a\u00020H2\b\b\u0002\u0010K\u001a\u00020H2\t\b\u0002\u0010\u0001\u001a\u00020H2\b\b\u0002\u0010O\u001a\u00020H2\b\b\u0002\u0010P\u001a\u00020H2\b\b\u0002\u0010Q\u001a\u00020H2\b\b\u0002\u0010R\u001a\u00020S2\t\b\u0002\u0010\u0001\u001a\u00020H2\t\b\u0002\u0010\u0001\u001a\u00020H2\t\b\u0002\u0010\u0001\u001a\u00020H2\t\b\u0002\u0010\u0001\u001a\u00020H2\b\b\u0002\u0010X\u001a\u00020H2\b\b\u0002\u0010Y\u001a\u00020H2\b\b\u0002\u0010Z\u001a\u00020H2\b\b\u0002\u0010[\u001a\u00020H2\b\b\u0002\u0010\\\u001a\u00020H2\b\b\u0002\u0010]\u001a\u00020H2\b\b\u0002\u0010^\u001a\u00020H2\b\b\u0002\u0010_\u001a\u00020H2\b\b\u0002\u0010`\u001a\u00020H2\b\b\u0002\u0010a\u001a\u00020H2\b\b\u0002\u0010b\u001a\u00020H2\b\b\u0002\u0010c\u001a\u00020H2\b\b\u0002\u0010d\u001a\u00020H2\b\b\u0002\u0010e\u001a\u00020H2\b\b\u0002\u0010f\u001a\u00020H2\b\b\u0002\u0010g\u001a\u00020H2\b\b\u0002\u0010h\u001a\u00020H2\b\b\u0002\u0010i\u001a\u00020H2\b\b\u0002\u0010j\u001a\u00020H2\b\b\u0002\u0010k\u001a\u00020H2\b\b\u0002\u0010l\u001a\u00020H2\b\b\u0002\u0010m\u001a\u00020H2\b\b\u0002\u0010n\u001a\u00020H2\b\b\u0002\u0010o\u001a\u00020H2\b\b\u0002\u0010p\u001a\u00020H2\b\b\u0002\u0010q\u001a\u00020H2\b\b\u0002\u0010r\u001a\u00020H2\b\b\u0002\u0010s\u001a\u00020HH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J?\u0010\u0001\u001a\u0002092\b\b\u0002\u0010w\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010|J?\u0010\u0001\u001a\u0002092\b\b\u0002\u0010w\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u0004H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010|J\u0003\u0010\u0001\u001a\u00020&2\t\b\u0002\u0010\u0001\u001a\u00020H2\b\b\u0002\u0010J\u001a\u00020H2\t\b\u0002\u0010\u0001\u001a\u00020H2\b\b\u0002\u0010P\u001a\u00020H2\b\b\u0002\u0010Q\u001a\u00020H2\b\b\u0002\u0010R\u001a\u00020S2\b\b\u0002\u0010T\u001a\u00020H2\b\b\u0002\u0010U\u001a\u00020H2\b\b\u0002\u0010V\u001a\u00020H2\b\b\u0002\u0010W\u001a\u00020H2\b\b\u0002\u0010X\u001a\u00020H2\b\b\u0002\u0010Y\u001a\u00020H2\b\b\u0002\u0010Z\u001a\u00020H2\b\b\u0002\u0010[\u001a\u00020H2\b\b\u0002\u0010\\\u001a\u00020H2\b\b\u0002\u0010]\u001a\u00020H2\b\b\u0002\u0010^\u001a\u00020H2\b\b\u0002\u0010_\u001a\u00020H2\b\b\u0002\u0010`\u001a\u00020H2\b\b\u0002\u0010a\u001a\u00020H2\b\b\u0002\u0010b\u001a\u00020H2\b\b\u0002\u0010c\u001a\u00020H2\t\b\u0002\u0010\u0001\u001a\u00020H2\b\b\u0002\u0010f\u001a\u00020H2\b\b\u0002\u0010h\u001a\u00020H2\b\b\u0002\u0010i\u001a\u00020H2\b\b\u0002\u0010j\u001a\u00020H2\b\b\u0002\u0010k\u001a\u00020H2\b\b\u0002\u0010l\u001a\u00020H2\b\b\u0002\u0010m\u001a\u00020H2\b\b\u0002\u0010n\u001a\u00020H2\b\b\u0002\u0010o\u001a\u00020H2\b\b\u0002\u0010p\u001a\u00020H2\b\b\u0002\u0010q\u001a\u00020H2\b\b\u0002\u0010r\u001a\u00020H2\b\b\u0002\u0010s\u001a\u00020HH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J³\u0003\u0010\u0001\u001a\u00020&2\b\b\u0002\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020H2\b\b\u0002\u0010J\u001a\u00020H2\b\b\u0002\u0010K\u001a\u00020H2\t\b\u0002\u0010\u0001\u001a\u00020H2\b\b\u0002\u0010O\u001a\u00020H2\b\b\u0002\u0010P\u001a\u00020H2\b\b\u0002\u0010Q\u001a\u00020H2\b\b\u0002\u0010R\u001a\u00020S2\b\b\u0002\u0010T\u001a\u00020H2\b\b\u0002\u0010U\u001a\u00020H2\b\b\u0002\u0010V\u001a\u00020H2\b\b\u0002\u0010W\u001a\u00020H2\b\b\u0002\u0010X\u001a\u00020H2\b\b\u0002\u0010Y\u001a\u00020H2\b\b\u0002\u0010Z\u001a\u00020H2\b\b\u0002\u0010[\u001a\u00020H2\b\b\u0002\u0010\\\u001a\u00020H2\b\b\u0002\u0010]\u001a\u00020H2\b\b\u0002\u0010^\u001a\u00020H2\b\b\u0002\u0010_\u001a\u00020H2\b\b\u0002\u0010`\u001a\u00020H2\b\b\u0002\u0010a\u001a\u00020H2\b\b\u0002\u0010b\u001a\u00020H2\b\b\u0002\u0010c\u001a\u00020H2\b\b\u0002\u0010d\u001a\u00020H2\b\b\u0002\u0010e\u001a\u00020H2\b\b\u0002\u0010f\u001a\u00020H2\b\b\u0002\u0010g\u001a\u00020H2\b\b\u0002\u0010h\u001a\u00020H2\b\b\u0002\u0010i\u001a\u00020H2\b\b\u0002\u0010j\u001a\u00020H2\b\b\u0002\u0010k\u001a\u00020H2\b\b\u0002\u0010l\u001a\u00020H2\b\b\u0002\u0010m\u001a\u00020H2\b\b\u0002\u0010n\u001a\u00020H2\b\b\u0002\u0010o\u001a\u00020H2\b\b\u0002\u0010p\u001a\u00020H2\b\b\u0002\u0010q\u001a\u00020H2\b\b\u0002\u0010r\u001a\u00020H2\b\b\u0002\u0010s\u001a\u00020HH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J?\u0010\u0001\u001a\u0002092\b\b\u0002\u0010w\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010|J?\u0010\u0001\u001a\u0002092\b\b\u0002\u0010w\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010|JT\u0010\u0001\u001a\u00030\u0001*\u00030\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\t\b\u0002\u0010\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0001\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001R'\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u001c\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R'\u0010\u000f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00158GX\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00158GX\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u001c\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/material3/TextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM$annotations", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "FocusedIndicatorThickness", "getFocusedIndicatorThickness-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM$annotations", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorThickness", "getUnfocusedIndicatorThickness-D9Ej5fM", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape$annotations", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape$annotations", "getOutlinedShape", "shape", "getShape", "ContainerBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "FilledContainerBox", "OutlinedBorderContainerBox", "focusedBorderThickness", "unfocusedBorderThickness", "OutlinedBorderContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "OutlinedTextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "contentPaddingWithLabel", "start", "end", "top", "bottom", "contentPaddingWithLabel-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "contentPaddingWithoutLabel", "contentPaddingWithoutLabel-a9UjIt4", "outlinedTextFieldColors", "textColor", "containerColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "placeholderColor", "outlinedTextFieldColors-eS1Emto", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldColors-M37tBTI", "(JJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldPadding", "outlinedTextFieldPadding-a9UjIt4", "supportingTextPadding", "supportingTextPadding-a9UjIt4$material3_release", "textFieldColors", "textFieldColors-eS1Emto", "textFieldColors-M37tBTI", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
public final class TextFieldDefaults {
    public static final int $stable = 0;
    private static final float FocusedBorderThickness;
    private static final float FocusedIndicatorThickness;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.m7554constructorimpl((float) 56);
    private static final float MinWidth = Dp.m7554constructorimpl((float) 280);
    private static final float UnfocusedBorderThickness;
    private static final float UnfocusedIndicatorThickness;

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.shape", imports = {}))
    public static /* synthetic */ void getFilledShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.FocusedIndicatorThickness` and `OutlinedTextFieldDefaults.FocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.FocusedIndicatorThickness", imports = {}))
    /* renamed from: getFocusedBorderThickness-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m3819getFocusedBorderThicknessD9Ej5fM$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.shape", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    public static /* synthetic */ void getOutlinedShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.UnfocusedIndicatorThickness` and `OutlinedTextFieldDefaults.UnfocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.UnfocusedIndicatorThickness", imports = {}))
    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m3820getUnfocusedBorderThicknessD9Ej5fM$annotations() {
    }

    private TextFieldDefaults() {
    }

    public final Shape getShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1941327459);
        ComposerKt.sourceInformation($composer, "C57@2544L9:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1941327459, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-shape> (TextFieldDefaults.kt:57)");
        }
        Shape shape = ShapesKt.toShape(FilledTextFieldTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    static {
        float r0 = Dp.m7554constructorimpl((float) 1);
        UnfocusedIndicatorThickness = r0;
        float r1 = Dp.m7554constructorimpl((float) 2);
        FocusedIndicatorThickness = r1;
        UnfocusedBorderThickness = r0;
        FocusedBorderThickness = r1;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m3832getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m3833getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getUnfocusedIndicatorThickness-D9Ej5fM  reason: not valid java name */
    public final float m3835getUnfocusedIndicatorThicknessD9Ej5fM() {
        return UnfocusedIndicatorThickness;
    }

    /* renamed from: getFocusedIndicatorThickness-D9Ej5fM  reason: not valid java name */
    public final float m3831getFocusedIndicatorThicknessD9Ej5fM() {
        return FocusedIndicatorThickness;
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ContainerBox(boolean r21, boolean r22, androidx.compose.foundation.interaction.InteractionSource r23, androidx.compose.material3.TextFieldColors r24, androidx.compose.ui.graphics.Shape r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r20 = this;
            r10 = r23
            r11 = r24
            r12 = r27
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "colors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 918564008(0x36c02ca8, float:5.7272446E-6)
            r1 = r26
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ContainerBox)P(1,3,2)100@4155L5,104@4239L51,102@4178L203:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r27
            r2 = r28 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            r14 = r21
            goto L_0x003d
        L_0x002a:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x003b
            r14 = r21
            boolean r2 = r13.changed((boolean) r14)
            if (r2 == 0) goto L_0x0038
            r2 = 4
            goto L_0x0039
        L_0x0038:
            r2 = 2
        L_0x0039:
            r1 = r1 | r2
            goto L_0x003d
        L_0x003b:
            r14 = r21
        L_0x003d:
            r2 = r28 & 2
            if (r2 == 0) goto L_0x0046
            r1 = r1 | 48
            r15 = r22
            goto L_0x005b
        L_0x0046:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0059
            r15 = r22
            boolean r2 = r13.changed((boolean) r15)
            if (r2 == 0) goto L_0x0055
            r2 = 32
            goto L_0x0057
        L_0x0055:
            r2 = 16
        L_0x0057:
            r1 = r1 | r2
            goto L_0x005b
        L_0x0059:
            r15 = r22
        L_0x005b:
            r2 = r28 & 4
            if (r2 == 0) goto L_0x0062
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0072
        L_0x0062:
            r2 = r12 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0072
            boolean r2 = r13.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x006f
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0071
        L_0x006f:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0071:
            r1 = r1 | r2
        L_0x0072:
            r2 = r28 & 8
            if (r2 == 0) goto L_0x0079
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0079:
            r2 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0089
            boolean r2 = r13.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x0086
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0088
        L_0x0086:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0088:
            r1 = r1 | r2
        L_0x0089:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x00a4
            r2 = r28 & 16
            if (r2 != 0) goto L_0x009e
            r2 = r25
            boolean r3 = r13.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x00a0
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a2
        L_0x009e:
            r2 = r25
        L_0x00a0:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x00a2:
            r1 = r1 | r3
            goto L_0x00a6
        L_0x00a4:
            r2 = r25
        L_0x00a6:
            r3 = r28 & 32
            if (r3 == 0) goto L_0x00b0
            r3 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r3
            r9 = r20
            goto L_0x00c6
        L_0x00b0:
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r12
            if (r3 != 0) goto L_0x00c4
            r9 = r20
            boolean r3 = r13.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x00c0
            r3 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00c0:
            r3 = 65536(0x10000, float:9.18355E-41)
        L_0x00c2:
            r1 = r1 | r3
            goto L_0x00c6
        L_0x00c4:
            r9 = r20
        L_0x00c6:
            r3 = 374491(0x5b6db, float:5.24774E-40)
            r3 = r3 & r1
            r4 = 74898(0x12492, float:1.04954E-40)
            if (r3 != r4) goto L_0x00df
            boolean r3 = r13.getSkipping()
            if (r3 != 0) goto L_0x00d6
            goto L_0x00df
        L_0x00d6:
            r13.skipToGroupEnd()
            r19 = r1
            r18 = r2
            goto L_0x0174
        L_0x00df:
            r13.startDefaults()
            r3 = r12 & 1
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x00fb
            boolean r3 = r13.getDefaultsInvalid()
            if (r3 == 0) goto L_0x00f0
            goto L_0x00fb
        L_0x00f0:
            r13.skipToGroupEnd()
            r3 = r28 & 16
            if (r3 == 0) goto L_0x010a
            r1 = r1 & r4
            r7 = r1
            r8 = r2
            goto L_0x010c
        L_0x00fb:
            r3 = r28 & 16
            if (r3 == 0) goto L_0x010a
            androidx.compose.material3.TextFieldDefaults r3 = INSTANCE
            r5 = 6
            androidx.compose.ui.graphics.Shape r2 = r3.getShape(r13, r5)
            r1 = r1 & r4
            r7 = r1
            r8 = r2
            goto L_0x010c
        L_0x010a:
            r7 = r1
            r8 = r2
        L_0x010c:
            r13.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x011b
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.TextFieldDefaults.ContainerBox (TextFieldDefaults.kt:95)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r7, r1, r2)
        L_0x011b:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r6 = r0
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            r0 = r7 & 14
            r1 = r7 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r7 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r7 & 7168(0x1c00, float:1.0045E-41)
            r5 = r0 | r1
            r0 = r24
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r13
            androidx.compose.runtime.State r0 = r0.containerColor$material3_release(r1, r2, r3, r4, r5)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r0 = r0.m4973unboximpl()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.BackgroundKt.m1876backgroundbw27NRU(r6, r0, r8)
            r16 = 48
            r17 = 0
            r6 = 0
            r18 = 0
            r0 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r19 = r7
            r7 = r18
            r18 = r8
            r8 = r16
            r9 = r17
            androidx.compose.ui.Modifier r0 = m3821indicatorLinegv0btCI$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = 0
            androidx.compose.foundation.layout.BoxKt.Box(r0, r13, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0174
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0174:
            androidx.compose.runtime.ScopeUpdateScope r9 = r13.endRestartGroup()
            if (r9 != 0) goto L_0x017b
            goto L_0x0199
        L_0x017b:
            androidx.compose.material3.TextFieldDefaults$ContainerBox$1 r16 = new androidx.compose.material3.TextFieldDefaults$ContainerBox$1
            r0 = r16
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r18
            r7 = r27
            r8 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0199:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.ContainerBox(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: indicatorLine-gv0btCI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m3821indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        float f3;
        float f4;
        if ((i & 16) != 0) {
            f3 = FocusedIndicatorThickness;
        } else {
            f3 = f;
        }
        if ((i & 32) != 0) {
            f4 = UnfocusedIndicatorThickness;
        } else {
            f4 = f2;
        }
        return textFieldDefaults.m3836indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f3, f4);
    }

    /* renamed from: indicatorLine-gv0btCI  reason: not valid java name */
    public final Modifier m3836indicatorLinegv0btCI(Modifier $this$indicatorLine_u2dgv0btCI, boolean enabled, boolean isError, InteractionSource interactionSource, TextFieldColors colors, float focusedIndicatorLineThickness, float unfocusedIndicatorLineThickness) {
        Modifier modifier = $this$indicatorLine_u2dgv0btCI;
        Intrinsics.checkNotNullParameter($this$indicatorLine_u2dgv0btCI, "$this$indicatorLine");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(colors, "colors");
        return ComposedModifierKt.composed($this$indicatorLine_u2dgv0btCI, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TextFieldDefaults$indicatorLinegv0btCI$$inlined$debugInspectorInfo$1(enabled, isError, interactionSource, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness) : InspectableValueKt.getNoInspectorInfo(), new TextFieldDefaults$indicatorLine$2(enabled, isError, interactionSource, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness));
    }

    /* renamed from: contentPaddingWithLabel-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m3817contentPaddingWithLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m3828contentPaddingWithLabela9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPaddingWithLabel-a9UjIt4  reason: not valid java name */
    public final PaddingValues m3828contentPaddingWithLabela9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m2244PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: contentPaddingWithoutLabel-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m3818contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m3829contentPaddingWithoutLabela9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPaddingWithoutLabel-a9UjIt4  reason: not valid java name */
    public final PaddingValues m3829contentPaddingWithoutLabela9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m2244PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: supportingTextPadding-a9UjIt4$material3_release$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m3823supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float $this$dp$iv, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getSupportingTopPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            $this$dp$iv = Dp.m7554constructorimpl((float) 0);
        }
        return textFieldDefaults.m3840supportingTextPaddinga9UjIt4$material3_release(f, f2, f3, $this$dp$iv);
    }

    /* renamed from: supportingTextPadding-a9UjIt4$material3_release  reason: not valid java name */
    public final PaddingValues m3840supportingTextPaddinga9UjIt4$material3_release(float start, float top, float end, float bottom) {
        return PaddingKt.m2244PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: colors-0hiis_0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material3.TextFieldColors m3827colors0hiis_0(long r176, long r178, long r180, long r182, long r184, long r186, long r188, long r190, long r192, long r194, androidx.compose.foundation.text.selection.TextSelectionColors r196, long r197, long r199, long r201, long r203, long r205, long r207, long r209, long r211, long r213, long r215, long r217, long r219, long r221, long r223, long r225, long r227, long r229, long r231, long r233, long r235, long r237, long r239, long r241, long r243, long r245, long r247, long r249, long r251, long r253, long r255, long r257, long r259, androidx.compose.runtime.Composer r261, int r262, int r263, int r264, int r265, int r266, int r267, int r268) {
        /*
            r175 = this;
            r0 = r261
            r1 = r267
            r2 = r268
            r3 = 1513344955(0x5a33cfbb, float:1.26531057E16)
            r0.startReplaceableGroup(r3)
            java.lang.String r4 = "C(colors)P(30:c#ui.graphics.Color,41:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,22:c#ui.graphics.Color,33:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,32,23:c#ui.graphics.Color,34:c#ui.graphics.Color,2:c#ui.graphics.Color,13:c#ui.graphics.Color,25:c#ui.graphics.Color,36:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,31:c#ui.graphics.Color,42:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,24:c#ui.graphics.Color,35:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,26:c#ui.graphics.Color,37:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,29:c#ui.graphics.Color,40:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,38:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,28:c#ui.graphics.Color,39:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)247@12192L9,248@12272L9,249@12359L9,251@12510L9,252@12597L9,253@12686L9,254@12774L9,255@12859L9,256@12932L9,257@13020L9,258@13103L7,259@13199L9,260@13294L9,261@13396L9,263@13572L9,264@13668L9,265@13761L9,266@13861L9,268@14031L9,269@14129L9,270@14224L9,271@14326L9,273@14499L9,274@14583L9,275@14664L9,276@14752L9,278@14904L9,279@15000L9,280@15098L9,281@15192L9,283@15356L9,284@15454L9,285@15549L9,286@15651L9,288@15822L9,289@15908L9,290@15996L9,291@16083L9,293@16237L9,294@16323L9,295@16411L9,296@16498L9,298@16652L9:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            r4 = r1 & 1
            r5 = 6
            if (r4 == 0) goto L_0x0021
            androidx.compose.material3.tokens.FilledTextFieldTokens r4 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getFocusInputColor()
            long r6 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            goto L_0x0023
        L_0x0021:
            r6 = r176
        L_0x0023:
            r4 = r1 & 2
            if (r4 == 0) goto L_0x0034
            androidx.compose.material3.tokens.FilledTextFieldTokens r4 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getInputColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            r95 = r8
            goto L_0x0036
        L_0x0034:
            r95 = r178
        L_0x0036:
            r4 = r1 & 4
            if (r4 == 0) goto L_0x0055
            androidx.compose.material3.tokens.FilledTextFieldTokens r4 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getDisabledInputColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            r14 = 14
            r15 = 0
            r10 = 1052938076(0x3ec28f5c, float:0.38)
            r11 = 0
            r12 = 0
            r13 = 0
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r8, r10, r11, r12, r13, r14, r15)
            r97 = r8
            goto L_0x0057
        L_0x0055:
            r97 = r180
        L_0x0057:
            r4 = r1 & 8
            if (r4 == 0) goto L_0x0068
            androidx.compose.material3.tokens.FilledTextFieldTokens r4 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getErrorInputColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            r99 = r8
            goto L_0x006a
        L_0x0068:
            r99 = r182
        L_0x006a:
            r4 = r1 & 16
            if (r4 == 0) goto L_0x007b
            androidx.compose.material3.tokens.FilledTextFieldTokens r4 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getContainerColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            r101 = r8
            goto L_0x007d
        L_0x007b:
            r101 = r184
        L_0x007d:
            r4 = r1 & 32
            if (r4 == 0) goto L_0x008e
            androidx.compose.material3.tokens.FilledTextFieldTokens r4 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getContainerColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            r103 = r8
            goto L_0x0090
        L_0x008e:
            r103 = r186
        L_0x0090:
            r4 = r1 & 64
            if (r4 == 0) goto L_0x00a1
            androidx.compose.material3.tokens.FilledTextFieldTokens r4 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getContainerColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            r105 = r8
            goto L_0x00a3
        L_0x00a1:
            r105 = r188
        L_0x00a3:
            r4 = r1 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x00b4
            androidx.compose.material3.tokens.FilledTextFieldTokens r4 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getContainerColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            r107 = r8
            goto L_0x00b6
        L_0x00b4:
            r107 = r190
        L_0x00b6:
            r4 = r1 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x00c7
            androidx.compose.material3.tokens.FilledTextFieldTokens r4 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getCaretColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            r109 = r8
            goto L_0x00c9
        L_0x00c7:
            r109 = r192
        L_0x00c9:
            r4 = r1 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x00da
            androidx.compose.material3.tokens.FilledTextFieldTokens r4 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getErrorFocusCaretColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            r111 = r8
            goto L_0x00dc
        L_0x00da:
            r111 = r194
        L_0x00dc:
            r4 = r1 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x00fb
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r8 = 0
            r9 = 0
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r11 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r10, r11)
            java.lang.Object r10 = r0.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r261)
            r4 = r10
            androidx.compose.foundation.text.selection.TextSelectionColors r4 = (androidx.compose.foundation.text.selection.TextSelectionColors) r4
            goto L_0x00fd
        L_0x00fb:
            r4 = r196
        L_0x00fd:
            r8 = r1 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x010e
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getFocusActiveIndicatorColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r113 = r8
            goto L_0x0110
        L_0x010e:
            r113 = r197
        L_0x0110:
            r8 = r1 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x0121
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getActiveIndicatorColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r115 = r8
            goto L_0x0123
        L_0x0121:
            r115 = r199
        L_0x0123:
            r8 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x0150
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getDisabledActiveIndicatorColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r10 = 14
            r11 = 0
            r12 = 1052938076(0x3ec28f5c, float:0.38)
            r13 = 0
            r14 = 0
            r15 = 0
            r176 = r8
            r178 = r12
            r179 = r13
            r180 = r14
            r181 = r15
            r182 = r10
            r183 = r11
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r117 = r8
            goto L_0x0152
        L_0x0150:
            r117 = r201
        L_0x0152:
            r8 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x0163
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getErrorActiveIndicatorColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r119 = r8
            goto L_0x0165
        L_0x0163:
            r119 = r203
        L_0x0165:
            r8 = 32768(0x8000, float:4.5918E-41)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x0178
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getFocusLeadingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r121 = r8
            goto L_0x017a
        L_0x0178:
            r121 = r205
        L_0x017a:
            r8 = 65536(0x10000, float:9.18355E-41)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x018c
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getLeadingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r123 = r8
            goto L_0x018e
        L_0x018c:
            r123 = r207
        L_0x018e:
            r8 = 131072(0x20000, float:1.83671E-40)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x01bc
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getDisabledLeadingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r10 = 14
            r11 = 0
            r12 = 1052938076(0x3ec28f5c, float:0.38)
            r13 = 0
            r14 = 0
            r15 = 0
            r176 = r8
            r178 = r12
            r179 = r13
            r180 = r14
            r181 = r15
            r182 = r10
            r183 = r11
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r125 = r8
            goto L_0x01be
        L_0x01bc:
            r125 = r209
        L_0x01be:
            r8 = 262144(0x40000, float:3.67342E-40)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x01d0
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getErrorLeadingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r127 = r8
            goto L_0x01d2
        L_0x01d0:
            r127 = r211
        L_0x01d2:
            r8 = 524288(0x80000, float:7.34684E-40)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x01e4
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getFocusTrailingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r129 = r8
            goto L_0x01e6
        L_0x01e4:
            r129 = r213
        L_0x01e6:
            r8 = 1048576(0x100000, float:1.469368E-39)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x01f8
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getTrailingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r131 = r8
            goto L_0x01fa
        L_0x01f8:
            r131 = r215
        L_0x01fa:
            r8 = 2097152(0x200000, float:2.938736E-39)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x0228
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getDisabledTrailingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r10 = 14
            r11 = 0
            r12 = 1052938076(0x3ec28f5c, float:0.38)
            r13 = 0
            r14 = 0
            r15 = 0
            r176 = r8
            r178 = r12
            r179 = r13
            r180 = r14
            r181 = r15
            r182 = r10
            r183 = r11
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r133 = r8
            goto L_0x022a
        L_0x0228:
            r133 = r217
        L_0x022a:
            r8 = 4194304(0x400000, float:5.877472E-39)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x023c
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getErrorTrailingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r135 = r8
            goto L_0x023e
        L_0x023c:
            r135 = r219
        L_0x023e:
            r8 = 8388608(0x800000, float:1.17549435E-38)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x0250
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getFocusLabelColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r137 = r8
            goto L_0x0252
        L_0x0250:
            r137 = r221
        L_0x0252:
            r8 = 16777216(0x1000000, float:2.3509887E-38)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x0264
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getLabelColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r139 = r8
            goto L_0x0266
        L_0x0264:
            r139 = r223
        L_0x0266:
            r8 = 33554432(0x2000000, float:9.403955E-38)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x0294
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getDisabledLabelColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r10 = 14
            r11 = 0
            r12 = 1052938076(0x3ec28f5c, float:0.38)
            r13 = 0
            r14 = 0
            r15 = 0
            r176 = r8
            r178 = r12
            r179 = r13
            r180 = r14
            r181 = r15
            r182 = r10
            r183 = r11
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r141 = r8
            goto L_0x0296
        L_0x0294:
            r141 = r225
        L_0x0296:
            r8 = 67108864(0x4000000, float:1.5046328E-36)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x02a8
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getErrorLabelColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r143 = r8
            goto L_0x02aa
        L_0x02a8:
            r143 = r227
        L_0x02aa:
            r8 = 134217728(0x8000000, float:3.85186E-34)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x02bc
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getInputPlaceholderColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r145 = r8
            goto L_0x02be
        L_0x02bc:
            r145 = r229
        L_0x02be:
            r8 = 268435456(0x10000000, float:2.5243549E-29)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x02d0
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getInputPlaceholderColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r147 = r8
            goto L_0x02d2
        L_0x02d0:
            r147 = r231
        L_0x02d2:
            r8 = 536870912(0x20000000, float:1.0842022E-19)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x0300
            androidx.compose.material3.tokens.FilledTextFieldTokens r8 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getDisabledInputColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r10 = 14
            r11 = 0
            r12 = 1052938076(0x3ec28f5c, float:0.38)
            r13 = 0
            r14 = 0
            r15 = 0
            r176 = r8
            r178 = r12
            r179 = r13
            r180 = r14
            r181 = r15
            r182 = r10
            r183 = r11
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r149 = r8
            goto L_0x0302
        L_0x0300:
            r149 = r233
        L_0x0302:
            r8 = 1073741824(0x40000000, float:2.0)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x0314
            androidx.compose.material3.tokens.FilledTextFieldTokens r1 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputPlaceholderColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r151 = r8
            goto L_0x0316
        L_0x0314:
            r151 = r235
        L_0x0316:
            r1 = r2 & 1
            if (r1 == 0) goto L_0x0327
            androidx.compose.material3.tokens.FilledTextFieldTokens r1 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getFocusSupportingColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r153 = r8
            goto L_0x0329
        L_0x0327:
            r153 = r237
        L_0x0329:
            r1 = r2 & 2
            if (r1 == 0) goto L_0x033a
            androidx.compose.material3.tokens.FilledTextFieldTokens r1 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getSupportingColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r155 = r8
            goto L_0x033c
        L_0x033a:
            r155 = r239
        L_0x033c:
            r1 = r2 & 4
            if (r1 == 0) goto L_0x0369
            androidx.compose.material3.tokens.FilledTextFieldTokens r1 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getDisabledSupportingColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r1 = 14
            r10 = 0
            r11 = 1052938076(0x3ec28f5c, float:0.38)
            r12 = 0
            r13 = 0
            r14 = 0
            r176 = r8
            r178 = r11
            r179 = r12
            r180 = r13
            r181 = r14
            r182 = r1
            r183 = r10
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r157 = r8
            goto L_0x036b
        L_0x0369:
            r157 = r241
        L_0x036b:
            r1 = r2 & 8
            if (r1 == 0) goto L_0x037c
            androidx.compose.material3.tokens.FilledTextFieldTokens r1 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getErrorSupportingColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r159 = r8
            goto L_0x037e
        L_0x037c:
            r159 = r243
        L_0x037e:
            r1 = r2 & 16
            if (r1 == 0) goto L_0x038f
            androidx.compose.material3.tokens.FilledTextFieldTokens r1 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputPrefixColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r161 = r8
            goto L_0x0391
        L_0x038f:
            r161 = r245
        L_0x0391:
            r1 = r2 & 32
            if (r1 == 0) goto L_0x03a2
            androidx.compose.material3.tokens.FilledTextFieldTokens r1 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputPrefixColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r163 = r8
            goto L_0x03a4
        L_0x03a2:
            r163 = r247
        L_0x03a4:
            r1 = r2 & 64
            if (r1 == 0) goto L_0x03d1
            androidx.compose.material3.tokens.FilledTextFieldTokens r1 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputPrefixColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r1 = 14
            r10 = 0
            r11 = 1052938076(0x3ec28f5c, float:0.38)
            r12 = 0
            r13 = 0
            r14 = 0
            r176 = r8
            r178 = r11
            r179 = r12
            r180 = r13
            r181 = r14
            r182 = r1
            r183 = r10
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r165 = r8
            goto L_0x03d3
        L_0x03d1:
            r165 = r249
        L_0x03d3:
            r1 = r2 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x03e4
            androidx.compose.material3.tokens.FilledTextFieldTokens r1 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputPrefixColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r167 = r8
            goto L_0x03e6
        L_0x03e4:
            r167 = r251
        L_0x03e6:
            r1 = r2 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x03f7
            androidx.compose.material3.tokens.FilledTextFieldTokens r1 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputSuffixColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r169 = r8
            goto L_0x03f9
        L_0x03f7:
            r169 = r253
        L_0x03f9:
            r1 = r2 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x040a
            androidx.compose.material3.tokens.FilledTextFieldTokens r1 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputSuffixColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r171 = r8
            goto L_0x040c
        L_0x040a:
            r171 = r255
        L_0x040c:
            r1 = r2 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0439
            androidx.compose.material3.tokens.FilledTextFieldTokens r1 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputSuffixColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r1 = 14
            r10 = 0
            r11 = 1052938076(0x3ec28f5c, float:0.38)
            r12 = 0
            r13 = 0
            r14 = 0
            r176 = r8
            r178 = r11
            r179 = r12
            r180 = r13
            r181 = r14
            r182 = r1
            r183 = r10
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r173 = r8
            goto L_0x043b
        L_0x0439:
            r173 = r257
        L_0x043b:
            r1 = r2 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x044a
            androidx.compose.material3.tokens.FilledTextFieldTokens r1 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputSuffixColor()
            long r1 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            goto L_0x044c
        L_0x044a:
            r1 = r259
        L_0x044c:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x045c
            java.lang.String r5 = "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:246)"
            r15 = r262
            r13 = r263
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r15, r13, r5)
            goto L_0x0460
        L_0x045c:
            r15 = r262
            r13 = r263
        L_0x0460:
            androidx.compose.material3.TextFieldColors r3 = new androidx.compose.material3.TextFieldColors
            r8 = r3
            r94 = 0
            r9 = r6
            r11 = r95
            r13 = r97
            r15 = r99
            r17 = r101
            r19 = r103
            r21 = r105
            r23 = r107
            r25 = r109
            r27 = r111
            r29 = r4
            r30 = r113
            r32 = r115
            r34 = r117
            r36 = r119
            r38 = r121
            r40 = r123
            r42 = r125
            r44 = r127
            r46 = r129
            r48 = r131
            r50 = r133
            r52 = r135
            r54 = r137
            r56 = r139
            r58 = r141
            r60 = r143
            r62 = r145
            r64 = r147
            r66 = r149
            r68 = r151
            r70 = r153
            r72 = r155
            r74 = r157
            r76 = r159
            r78 = r161
            r80 = r163
            r82 = r165
            r84 = r167
            r86 = r169
            r88 = r171
            r90 = r173
            r92 = r1
            r8.<init>(r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r88, r90, r92, r94)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x04f1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04f1:
            r261.endReplaceableGroup()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.m3827colors0hiis_0(long, long, long, long, long, long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:153:0x01f3, code lost:
        if (r8.changed((java.lang.Object) r133) != false) goto L_0x01fa;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x0545  */
    /* JADX WARNING: Removed duplicated region for block: B:276:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0156  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void DecorationBox(java.lang.String r119, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r120, boolean r121, boolean r122, androidx.compose.ui.text.input.VisualTransformation r123, androidx.compose.foundation.interaction.InteractionSource r124, boolean r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r131, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r132, androidx.compose.ui.graphics.Shape r133, androidx.compose.material3.TextFieldColors r134, androidx.compose.foundation.layout.PaddingValues r135, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r136, androidx.compose.runtime.Composer r137, int r138, int r139, int r140) {
        /*
            r118 = this;
            r15 = r119
            r14 = r120
            r13 = r123
            r12 = r124
            r11 = r138
            r10 = r139
            r9 = r140
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "innerTextField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 289640444(0x11438ffc, float:1.5427156E-28)
            r1 = r137
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(DecorationBox)P(16,4,3,12,17,5,6,7,9,8,15,10,13,14,11!1,2)425@24643L5,426@24684L8,437@25039L707:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = r138
            r1 = r139
            r2 = r9 & 1
            if (r2 == 0) goto L_0x003f
            r0 = r0 | 6
            goto L_0x004d
        L_0x003f:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x004d
            boolean r2 = r8.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x004b
            r2 = 4
            goto L_0x004c
        L_0x004b:
            r2 = 2
        L_0x004c:
            r0 = r0 | r2
        L_0x004d:
            r2 = r9 & 2
            if (r2 == 0) goto L_0x0054
            r0 = r0 | 48
            goto L_0x0064
        L_0x0054:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0064
            boolean r2 = r8.changedInstance(r14)
            if (r2 == 0) goto L_0x0061
            r2 = 32
            goto L_0x0063
        L_0x0061:
            r2 = 16
        L_0x0063:
            r0 = r0 | r2
        L_0x0064:
            r2 = r9 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x006f
            r0 = r0 | 384(0x180, float:5.38E-43)
            r2 = r121
            goto L_0x0085
        L_0x006f:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0083
            r2 = r121
            boolean r17 = r8.changed((boolean) r2)
            if (r17 == 0) goto L_0x007e
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x0080
        L_0x007e:
            r17 = r16
        L_0x0080:
            r0 = r0 | r17
            goto L_0x0085
        L_0x0083:
            r2 = r121
        L_0x0085:
            r17 = r9 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r17 == 0) goto L_0x0092
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r3 = r122
            goto L_0x00a8
        L_0x0092:
            r3 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x00a6
            r3 = r122
            boolean r17 = r8.changed((boolean) r3)
            if (r17 == 0) goto L_0x00a1
            r17 = r18
            goto L_0x00a3
        L_0x00a1:
            r17 = r19
        L_0x00a3:
            r0 = r0 | r17
            goto L_0x00a8
        L_0x00a6:
            r3 = r122
        L_0x00a8:
            r17 = r9 & 16
            r110 = 57344(0xe000, float:8.0356E-41)
            r20 = 16384(0x4000, float:2.2959E-41)
            if (r17 == 0) goto L_0x00b4
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00c5
        L_0x00b4:
            r17 = r11 & r110
            if (r17 != 0) goto L_0x00c5
            boolean r17 = r8.changed((java.lang.Object) r13)
            if (r17 == 0) goto L_0x00c1
            r17 = r20
            goto L_0x00c3
        L_0x00c1:
            r17 = 8192(0x2000, float:1.14794E-41)
        L_0x00c3:
            r0 = r0 | r17
        L_0x00c5:
            r17 = r9 & 32
            r111 = 458752(0x70000, float:6.42848E-40)
            r112 = 65536(0x10000, float:9.18355E-41)
            if (r17 == 0) goto L_0x00d2
            r17 = 196608(0x30000, float:2.75506E-40)
        L_0x00cf:
            r0 = r0 | r17
            goto L_0x00e2
        L_0x00d2:
            r17 = r11 & r111
            if (r17 != 0) goto L_0x00e2
            boolean r17 = r8.changed((java.lang.Object) r12)
            if (r17 == 0) goto L_0x00df
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cf
        L_0x00df:
            r17 = r112
            goto L_0x00cf
        L_0x00e2:
            r17 = r9 & 64
            r113 = 3670016(0x380000, float:5.142788E-39)
            if (r17 == 0) goto L_0x00ef
            r21 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r21
            r4 = r125
            goto L_0x0105
        L_0x00ef:
            r21 = r11 & r113
            if (r21 != 0) goto L_0x0103
            r4 = r125
            boolean r22 = r8.changed((boolean) r4)
            if (r22 == 0) goto L_0x00fe
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0100
        L_0x00fe:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x0100:
            r0 = r0 | r22
            goto L_0x0105
        L_0x0103:
            r4 = r125
        L_0x0105:
            r5 = r9 & 128(0x80, float:1.794E-43)
            r114 = 29360128(0x1c00000, float:7.052966E-38)
            if (r5 == 0) goto L_0x0112
            r23 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r23
            r6 = r126
            goto L_0x0128
        L_0x0112:
            r23 = r11 & r114
            if (r23 != 0) goto L_0x0126
            r6 = r126
            boolean r24 = r8.changedInstance(r6)
            if (r24 == 0) goto L_0x0121
            r24 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0123
        L_0x0121:
            r24 = 4194304(0x400000, float:5.877472E-39)
        L_0x0123:
            r0 = r0 | r24
            goto L_0x0128
        L_0x0126:
            r6 = r126
        L_0x0128:
            r7 = r9 & 256(0x100, float:3.59E-43)
            if (r7 == 0) goto L_0x0133
            r25 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r25
            r2 = r127
            goto L_0x014b
        L_0x0133:
            r25 = 234881024(0xe000000, float:1.5777218E-30)
            r25 = r11 & r25
            if (r25 != 0) goto L_0x0149
            r2 = r127
            boolean r25 = r8.changedInstance(r2)
            if (r25 == 0) goto L_0x0144
            r25 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0146
        L_0x0144:
            r25 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0146:
            r0 = r0 | r25
            goto L_0x014b
        L_0x0149:
            r2 = r127
        L_0x014b:
            r2 = r9 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0156
            r25 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r25
            r3 = r128
            goto L_0x016e
        L_0x0156:
            r25 = 1879048192(0x70000000, float:1.58456325E29)
            r25 = r11 & r25
            if (r25 != 0) goto L_0x016c
            r3 = r128
            boolean r25 = r8.changedInstance(r3)
            if (r25 == 0) goto L_0x0167
            r25 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0169
        L_0x0167:
            r25 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0169:
            r0 = r0 | r25
            goto L_0x016e
        L_0x016c:
            r3 = r128
        L_0x016e:
            r3 = r9 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0177
            r1 = r1 | 6
            r4 = r129
            goto L_0x018d
        L_0x0177:
            r25 = r10 & 14
            if (r25 != 0) goto L_0x018b
            r4 = r129
            boolean r25 = r8.changedInstance(r4)
            if (r25 == 0) goto L_0x0186
            r21 = 4
            goto L_0x0188
        L_0x0186:
            r21 = 2
        L_0x0188:
            r1 = r1 | r21
            goto L_0x018d
        L_0x018b:
            r4 = r129
        L_0x018d:
            r4 = r9 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0196
            r1 = r1 | 48
            r6 = r130
            goto L_0x01ac
        L_0x0196:
            r21 = r10 & 112(0x70, float:1.57E-43)
            if (r21 != 0) goto L_0x01aa
            r6 = r130
            boolean r21 = r8.changedInstance(r6)
            if (r21 == 0) goto L_0x01a5
            r22 = 32
            goto L_0x01a7
        L_0x01a5:
            r22 = 16
        L_0x01a7:
            r1 = r1 | r22
            goto L_0x01ac
        L_0x01aa:
            r6 = r130
        L_0x01ac:
            r6 = r9 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x01b5
            r1 = r1 | 384(0x180, float:5.38E-43)
            r12 = r131
            goto L_0x01c8
        L_0x01b5:
            r12 = r10 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x01c6
            r12 = r131
            boolean r21 = r8.changedInstance(r12)
            if (r21 == 0) goto L_0x01c3
            r16 = 256(0x100, float:3.59E-43)
        L_0x01c3:
            r1 = r1 | r16
            goto L_0x01c8
        L_0x01c6:
            r12 = r131
        L_0x01c8:
            r12 = r9 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x01d1
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r13 = r132
            goto L_0x01e5
        L_0x01d1:
            r13 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x01e3
            r13 = r132
            boolean r16 = r8.changedInstance(r13)
            if (r16 == 0) goto L_0x01de
            goto L_0x01e0
        L_0x01de:
            r18 = r19
        L_0x01e0:
            r1 = r1 | r18
            goto L_0x01e5
        L_0x01e3:
            r13 = r132
        L_0x01e5:
            r16 = r10 & r110
            if (r16 != 0) goto L_0x01fd
            r13 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r13 != 0) goto L_0x01f6
            r13 = r133
            boolean r16 = r8.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x01f8
            goto L_0x01fa
        L_0x01f6:
            r13 = r133
        L_0x01f8:
            r20 = 8192(0x2000, float:1.14794E-41)
        L_0x01fa:
            r1 = r1 | r20
            goto L_0x01ff
        L_0x01fd:
            r13 = r133
        L_0x01ff:
            r16 = r10 & r111
            if (r16 != 0) goto L_0x021c
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r9 & r16
            if (r16 != 0) goto L_0x0215
            r13 = r134
            boolean r16 = r8.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x0217
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0219
        L_0x0215:
            r13 = r134
        L_0x0217:
            r16 = r112
        L_0x0219:
            r1 = r1 | r16
            goto L_0x021e
        L_0x021c:
            r13 = r134
        L_0x021e:
            r16 = r10 & r113
            if (r16 != 0) goto L_0x0238
            r16 = r9 & r112
            if (r16 != 0) goto L_0x0231
            r13 = r135
            boolean r16 = r8.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x0233
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0235
        L_0x0231:
            r13 = r135
        L_0x0233:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x0235:
            r1 = r1 | r16
            goto L_0x023a
        L_0x0238:
            r13 = r135
        L_0x023a:
            r16 = 131072(0x20000, float:1.83671E-40)
            r115 = r9 & r16
            if (r115 == 0) goto L_0x0247
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r16
            r13 = r136
            goto L_0x025d
        L_0x0247:
            r16 = r10 & r114
            if (r16 != 0) goto L_0x025b
            r13 = r136
            boolean r16 = r8.changedInstance(r13)
            if (r16 == 0) goto L_0x0256
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0258
        L_0x0256:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x0258:
            r1 = r1 | r16
            goto L_0x025d
        L_0x025b:
            r13 = r136
        L_0x025d:
            r16 = 262144(0x40000, float:3.67342E-40)
            r16 = r9 & r16
            if (r16 == 0) goto L_0x026a
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r16
            r15 = r118
            goto L_0x0282
        L_0x026a:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x0280
            r15 = r118
            boolean r16 = r8.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x027b
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x027d
        L_0x027b:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x027d:
            r1 = r1 | r16
            goto L_0x0282
        L_0x0280:
            r15 = r118
        L_0x0282:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r10 = r0 & r16
            r13 = 306783378(0x12492492, float:6.3469493E-28)
            if (r10 != r13) goto L_0x02bf
            r10 = 191739611(0xb6db6db, float:4.5782105E-32)
            r10 = r10 & r1
            r13 = 38347922(0x2492492, float:1.4777643E-37)
            if (r10 != r13) goto L_0x02bf
            boolean r10 = r8.getSkipping()
            if (r10 != 0) goto L_0x029c
            goto L_0x02bf
        L_0x029c:
            r8.skipToGroupEnd()
            r23 = r125
            r24 = r126
            r25 = r127
            r116 = r128
            r26 = r129
            r27 = r130
            r28 = r131
            r29 = r132
            r30 = r133
            r31 = r134
            r32 = r135
            r35 = r136
            r34 = r0
            r36 = r1
            r33 = r8
            goto L_0x053e
        L_0x02bf:
            r8.startDefaults()
            r10 = r11 & 1
            if (r10 == 0) goto L_0x0305
            boolean r10 = r8.getDefaultsInvalid()
            if (r10 == 0) goto L_0x02cd
            goto L_0x0305
        L_0x02cd:
            r8.skipToGroupEnd()
            r2 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x02d8
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r2
        L_0x02d8:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r9
            if (r2 == 0) goto L_0x02e2
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r2
        L_0x02e2:
            r2 = r9 & r112
            if (r2 == 0) goto L_0x02ea
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r2
        L_0x02ea:
            r22 = r125
            r23 = r126
            r24 = r127
            r116 = r128
            r25 = r129
            r26 = r130
            r27 = r131
            r28 = r132
            r29 = r133
            r30 = r134
            r31 = r135
            r32 = r136
            r13 = r1
            goto L_0x0474
        L_0x0305:
            if (r17 == 0) goto L_0x0309
            r10 = 0
            goto L_0x030b
        L_0x0309:
            r10 = r125
        L_0x030b:
            if (r5 == 0) goto L_0x030f
            r5 = 0
            goto L_0x0311
        L_0x030f:
            r5 = r126
        L_0x0311:
            if (r7 == 0) goto L_0x0315
            r7 = 0
            goto L_0x0317
        L_0x0315:
            r7 = r127
        L_0x0317:
            if (r2 == 0) goto L_0x031b
            r2 = 0
            goto L_0x031d
        L_0x031b:
            r2 = r128
        L_0x031d:
            if (r3 == 0) goto L_0x0321
            r3 = 0
            goto L_0x0323
        L_0x0321:
            r3 = r129
        L_0x0323:
            if (r4 == 0) goto L_0x0327
            r4 = 0
            goto L_0x0329
        L_0x0327:
            r4 = r130
        L_0x0329:
            if (r6 == 0) goto L_0x032d
            r6 = 0
            goto L_0x032f
        L_0x032d:
            r6 = r131
        L_0x032f:
            if (r12 == 0) goto L_0x0333
            r12 = 0
            goto L_0x0335
        L_0x0333:
            r12 = r132
        L_0x0335:
            r13 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r13 == 0) goto L_0x0347
            androidx.compose.material3.TextFieldDefaults r13 = INSTANCE
            r116 = r2
            r2 = 6
            androidx.compose.ui.graphics.Shape r13 = r13.getShape(r8, r2)
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r2
            goto L_0x034b
        L_0x0347:
            r116 = r2
            r13 = r133
        L_0x034b:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r9
            if (r2 == 0) goto L_0x03c8
            int r2 = r1 >> 15
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r107 = r2
            r108 = 2147483647(0x7fffffff, float:NaN)
            r109 = 4095(0xfff, float:5.738E-42)
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r38 = 0
            r40 = 0
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r52 = 0
            r54 = 0
            r56 = 0
            r58 = 0
            r60 = 0
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 0
            r70 = 0
            r72 = 0
            r74 = 0
            r76 = 0
            r78 = 0
            r80 = 0
            r82 = 0
            r84 = 0
            r86 = 0
            r88 = 0
            r90 = 0
            r92 = 0
            r94 = 0
            r96 = 0
            r98 = 0
            r100 = 0
            r103 = 0
            r104 = 0
            r105 = 0
            r106 = 0
            r16 = r118
            r102 = r8
            androidx.compose.material3.TextFieldColors r2 = r16.m3827colors0hiis_0(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r88, r90, r92, r94, r96, r98, r100, r102, r103, r104, r105, r106, r107, r108, r109)
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r16
            goto L_0x03ca
        L_0x03c8:
            r2 = r134
        L_0x03ca:
            r16 = r9 & r112
            if (r16 == 0) goto L_0x0414
            if (r5 != 0) goto L_0x03ef
            r16 = 15
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r125 = r118
            r126 = r18
            r127 = r19
            r128 = r20
            r129 = r21
            r130 = r16
            r131 = r17
            androidx.compose.foundation.layout.PaddingValues r16 = m3818contentPaddingWithoutLabela9UjIt4$default(r125, r126, r127, r128, r129, r130, r131)
            goto L_0x040d
        L_0x03ef:
            r16 = 15
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r125 = r118
            r126 = r18
            r127 = r19
            r128 = r20
            r129 = r21
            r130 = r16
            r131 = r17
            androidx.compose.foundation.layout.PaddingValues r16 = m3817contentPaddingWithLabela9UjIt4$default(r125, r126, r127, r128, r129, r130, r131)
        L_0x040d:
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r17
            goto L_0x0416
        L_0x0414:
            r16 = r135
        L_0x0416:
            if (r115 == 0) goto L_0x0456
            r17 = r3
            androidx.compose.material3.TextFieldDefaults$DecorationBox$1 r3 = new androidx.compose.material3.TextFieldDefaults$DecorationBox$1
            r125 = r3
            r126 = r121
            r127 = r10
            r128 = r124
            r129 = r2
            r130 = r13
            r131 = r0
            r132 = r1
            r125.<init>(r126, r127, r128, r129, r130, r131, r132)
            r125 = r1
            r1 = -435523791(0xffffffffe60a6f31, float:-1.6343442E23)
            r126 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r1, r2, r3)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r30 = r126
            r32 = r1
            r26 = r4
            r23 = r5
            r27 = r6
            r24 = r7
            r22 = r10
            r28 = r12
            r29 = r13
            r31 = r16
            r25 = r17
            r13 = r125
            goto L_0x0474
        L_0x0456:
            r125 = r1
            r126 = r2
            r17 = r3
            r30 = r126
            r32 = r136
            r26 = r4
            r23 = r5
            r27 = r6
            r24 = r7
            r22 = r10
            r28 = r12
            r29 = r13
            r31 = r16
            r25 = r17
            r13 = r125
        L_0x0474:
            r8.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0485
            r1 = 289640444(0x11438ffc, float:1.5427156E-28)
            java.lang.String r2 = "androidx.compose.material3.TextFieldDefaults.DecorationBox (TextFieldDefaults.kt:410)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r0, r13, r2)
        L_0x0485:
            androidx.compose.material3.TextFieldType r1 = androidx.compose.material3.TextFieldType.Filled
            r12 = r0
            r0 = r1
            int r1 = r12 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r2 = 6
            r1 = r1 | r2
            int r2 = r12 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r12 >> 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r12 >> 9
            r2 = r2 & r110
            r1 = r1 | r2
            int r2 = r12 >> 9
            r2 = r2 & r111
            r1 = r1 | r2
            int r2 = r12 >> 9
            r2 = r2 & r113
            r1 = r1 | r2
            int r2 = r13 << 21
            r2 = r2 & r114
            r1 = r1 | r2
            int r2 = r13 << 21
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r3
            r1 = r1 | r2
            int r2 = r13 << 21
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r3
            r19 = r1 | r2
            int r1 = r13 >> 9
            r1 = r1 & 14
            int r2 = r12 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r12 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r12 >> 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r12 >> 3
            r2 = r2 & r110
            r1 = r1 | r2
            int r2 = r13 >> 3
            r2 = r2 & r111
            r1 = r1 | r2
            int r2 = r13 << 3
            r2 = r2 & r113
            r1 = r1 | r2
            r2 = r13 & r114
            r20 = r1 | r2
            r21 = 0
            r1 = r119
            r2 = r120
            r3 = r123
            r4 = r23
            r5 = r24
            r6 = r116
            r7 = r25
            r33 = r8
            r8 = r26
            r9 = r27
            r10 = r28
            r11 = r122
            r34 = r12
            r12 = r121
            r35 = r13
            r13 = r22
            r14 = r124
            r15 = r31
            r16 = r30
            r17 = r32
            r18 = r33
            androidx.compose.material3.TextFieldImplKt.CommonDecorationBox(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0526
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0526:
            r36 = r35
            r35 = r32
            r32 = r31
            r31 = r30
            r30 = r29
            r29 = r28
            r28 = r27
            r27 = r26
            r26 = r25
            r25 = r24
            r24 = r23
            r23 = r22
        L_0x053e:
            androidx.compose.runtime.ScopeUpdateScope r15 = r33.endRestartGroup()
            if (r15 != 0) goto L_0x0545
            goto L_0x0583
        L_0x0545:
            androidx.compose.material3.TextFieldDefaults$DecorationBox$2 r37 = new androidx.compose.material3.TextFieldDefaults$DecorationBox$2
            r0 = r37
            r1 = r118
            r2 = r119
            r3 = r120
            r4 = r121
            r5 = r122
            r6 = r123
            r7 = r124
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r116
            r12 = r26
            r13 = r27
            r14 = r28
            r117 = r15
            r15 = r29
            r16 = r30
            r17 = r31
            r18 = r32
            r19 = r35
            r20 = r138
            r21 = r139
            r22 = r140
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r37
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r117
            r1.updateScope(r0)
        L_0x0583:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.DecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public final Shape getOutlinedShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-584749279);
        ComposerKt.sourceInformation($composer, "C465@26096L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-584749279, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-outlinedShape> (TextFieldDefaults.kt:465)");
        }
        Shape shape = OutlinedTextFieldDefaults.INSTANCE.getShape($composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getFilledShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(611926497);
        ComposerKt.sourceInformation($composer, "C472@26334L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611926497, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-filledShape> (TextFieldDefaults.kt:472)");
        }
        Shape shape = getShape($composer, $changed & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m3834getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m3830getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0152  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.ContainerBox`", replaceWith = @kotlin.ReplaceWith(expression = "TextFieldDefaults.ContainerBox(\n        enabled = enabled,\n        isError = isError,\n        interactionSource = interactionSource,\n        colors = colors,\n        shape = shape,\n    )", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void FilledContainerBox(boolean r20, boolean r21, androidx.compose.foundation.interaction.InteractionSource r22, androidx.compose.material3.TextFieldColors r23, androidx.compose.ui.graphics.Shape r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r19 = this;
            r9 = r22
            r10 = r23
            r11 = r26
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "colors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -1358797526(0xffffffffaf02652a, float:-1.1859372E-10)
            r1 = r25
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(FilledContainerBox)P(1,3,2)508@27835L5,509@27850L168:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r26
            r2 = r27 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            r13 = r20
            goto L_0x003d
        L_0x002a:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x003b
            r13 = r20
            boolean r2 = r12.changed((boolean) r13)
            if (r2 == 0) goto L_0x0038
            r2 = 4
            goto L_0x0039
        L_0x0038:
            r2 = 2
        L_0x0039:
            r1 = r1 | r2
            goto L_0x003d
        L_0x003b:
            r13 = r20
        L_0x003d:
            r2 = r27 & 2
            if (r2 == 0) goto L_0x0046
            r1 = r1 | 48
            r14 = r21
            goto L_0x005b
        L_0x0046:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0059
            r14 = r21
            boolean r2 = r12.changed((boolean) r14)
            if (r2 == 0) goto L_0x0055
            r2 = 32
            goto L_0x0057
        L_0x0055:
            r2 = 16
        L_0x0057:
            r1 = r1 | r2
            goto L_0x005b
        L_0x0059:
            r14 = r21
        L_0x005b:
            r2 = r27 & 4
            if (r2 == 0) goto L_0x0062
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0072
        L_0x0062:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0072
            boolean r2 = r12.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x006f
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0071
        L_0x006f:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0071:
            r1 = r1 | r2
        L_0x0072:
            r2 = r27 & 8
            if (r2 == 0) goto L_0x0079
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0079:
            r2 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0089
            boolean r2 = r12.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x0086
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0088
        L_0x0086:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0088:
            r1 = r1 | r2
        L_0x0089:
            r2 = 57344(0xe000, float:8.0356E-41)
            r3 = r11 & r2
            if (r3 != 0) goto L_0x00a5
            r3 = r27 & 16
            if (r3 != 0) goto L_0x009f
            r3 = r24
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x00a1
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x009f:
            r3 = r24
        L_0x00a1:
            r4 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r1 = r1 | r4
            goto L_0x00a7
        L_0x00a5:
            r3 = r24
        L_0x00a7:
            r4 = r27 & 32
            r5 = 458752(0x70000, float:6.42848E-40)
            if (r4 == 0) goto L_0x00b3
            r4 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r4
            r15 = r19
            goto L_0x00c8
        L_0x00b3:
            r4 = r11 & r5
            if (r4 != 0) goto L_0x00c6
            r15 = r19
            boolean r4 = r12.changed((java.lang.Object) r15)
            if (r4 == 0) goto L_0x00c2
            r4 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c4
        L_0x00c2:
            r4 = 65536(0x10000, float:9.18355E-41)
        L_0x00c4:
            r1 = r1 | r4
            goto L_0x00c8
        L_0x00c6:
            r15 = r19
        L_0x00c8:
            r4 = 374491(0x5b6db, float:5.24774E-40)
            r4 = r4 & r1
            r6 = 74898(0x12492, float:1.04954E-40)
            if (r4 != r6) goto L_0x00e1
            boolean r4 = r12.getSkipping()
            if (r4 != 0) goto L_0x00d8
            goto L_0x00e1
        L_0x00d8:
            r12.skipToGroupEnd()
            r18 = r1
            r16 = r3
            goto L_0x0155
        L_0x00e1:
            r12.startDefaults()
            r4 = r11 & 1
            r6 = -57345(0xffffffffffff1fff, float:NaN)
            if (r4 == 0) goto L_0x00fe
            boolean r4 = r12.getDefaultsInvalid()
            if (r4 == 0) goto L_0x00f2
            goto L_0x00fe
        L_0x00f2:
            r12.skipToGroupEnd()
            r4 = r27 & 16
            if (r4 == 0) goto L_0x010e
            r1 = r1 & r6
            r8 = r1
            r16 = r3
            goto L_0x0111
        L_0x00fe:
            r4 = r27 & 16
            if (r4 == 0) goto L_0x010e
            androidx.compose.material3.TextFieldDefaults r4 = INSTANCE
            r7 = 6
            androidx.compose.ui.graphics.Shape r3 = r4.getShape(r12, r7)
            r1 = r1 & r6
            r8 = r1
            r16 = r3
            goto L_0x0111
        L_0x010e:
            r8 = r1
            r16 = r3
        L_0x0111:
            r12.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0120
            r1 = -1
            java.lang.String r3 = "androidx.compose.material3.TextFieldDefaults.FilledContainerBox (TextFieldDefaults.kt:503)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r8, r1, r3)
        L_0x0120:
            r0 = r8 & 14
            r1 = r8 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r8 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r8 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r8 & r2
            r0 = r0 | r1
            r1 = r8 & r5
            r7 = r0 | r1
            r17 = 0
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r16
            r6 = r12
            r18 = r8
            r8 = r17
            r0.ContainerBox(r1, r2, r3, r4, r5, r6, r7, r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0155
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0155:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 != 0) goto L_0x015c
            goto L_0x017b
        L_0x015c:
            androidx.compose.material3.TextFieldDefaults$FilledContainerBox$1 r17 = new androidx.compose.material3.TextFieldDefaults$FilledContainerBox$1
            r0 = r17
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r16
            r7 = r26
            r9 = r8
            r8 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x017b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.FilledContainerBox(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.ContainerBox`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.ContainerBox(\n        enabled = enabled,\n        isError = isError,\n        interactionSource = interactionSource,\n        colors = colors,\n        shape = shape,\n        focusedBorderThickness = focusedBorderThickness,\n        unfocusedBorderThickness = unfocusedBorderThickness,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* renamed from: OutlinedBorderContainerBox-nbWgWpA  reason: not valid java name */
    public final void m3826OutlinedBorderContainerBoxnbWgWpA(boolean enabled, boolean isError, InteractionSource interactionSource, TextFieldColors colors, Shape shape, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, int $changed, int i) {
        Shape shape2;
        float focusedBorderThickness2;
        float f;
        float unfocusedBorderThickness2;
        float focusedBorderThickness3;
        Shape shape3;
        int $dirty;
        Shape shape4;
        int i2;
        InteractionSource interactionSource2 = interactionSource;
        TextFieldColors textFieldColors = colors;
        int i3 = $changed;
        Intrinsics.checkNotNullParameter(interactionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(textFieldColors, "colors");
        Composer $composer2 = $composer.startRestartGroup(-1998946250);
        ComposerKt.sourceInformation($composer2, "C(OutlinedBorderContainerBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)538@28994L9,541@29216L286:TextFieldDefaults.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
            boolean z = enabled;
        } else if ((i3 & 14) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 4 : 2;
        } else {
            boolean z2 = enabled;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
            boolean z3 = isError;
        } else if ((i3 & 112) == 0) {
            $dirty2 |= $composer2.changed(isError) ? 32 : 16;
        } else {
            boolean z4 = isError;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if ((i3 & 896) == 0) {
            $dirty2 |= $composer2.changed((Object) interactionSource2) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if ((i3 & 7168) == 0) {
            $dirty2 |= $composer2.changed((Object) textFieldColors) ? 2048 : 1024;
        }
        if ((i3 & 57344) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                if ($composer2.changed((Object) shape2)) {
                    i2 = 16384;
                    $dirty2 |= i2;
                }
            } else {
                shape2 = shape;
            }
            i2 = 8192;
            $dirty2 |= i2;
        } else {
            shape2 = shape;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            focusedBorderThickness2 = focusedBorderThickness;
        } else if ((i3 & 458752) == 0) {
            focusedBorderThickness2 = focusedBorderThickness;
            $dirty2 |= $composer2.changed(focusedBorderThickness2) ? 131072 : 65536;
        } else {
            focusedBorderThickness2 = focusedBorderThickness;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty2 |= 1572864;
            f = unfocusedBorderThickness;
        } else if ((i3 & 3670016) == 0) {
            f = unfocusedBorderThickness;
            $dirty2 |= $composer2.changed(f) ? 1048576 : 524288;
        } else {
            f = unfocusedBorderThickness;
        }
        if (($dirty2 & 2995931) != 599186 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 16) != 0) {
                    shape4 = ShapesKt.toShape(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), $composer2, 6);
                    $dirty2 &= -57345;
                } else {
                    shape4 = shape2;
                }
                if (i4 != 0) {
                    focusedBorderThickness2 = OutlinedTextFieldDefaults.INSTANCE.m3606getFocusedBorderThicknessD9Ej5fM();
                }
                if (i5 != 0) {
                    $dirty = $dirty2;
                    shape3 = shape4;
                    unfocusedBorderThickness2 = OutlinedTextFieldDefaults.INSTANCE.m3609getUnfocusedBorderThicknessD9Ej5fM();
                    focusedBorderThickness3 = focusedBorderThickness2;
                } else {
                    shape3 = shape4;
                    focusedBorderThickness3 = focusedBorderThickness2;
                    unfocusedBorderThickness2 = f;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                shape3 = shape2;
                focusedBorderThickness3 = focusedBorderThickness2;
                unfocusedBorderThickness2 = f;
                $dirty = $dirty2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1998946250, $dirty, -1, "androidx.compose.material3.TextFieldDefaults.OutlinedBorderContainerBox (TextFieldDefaults.kt:533)");
            }
            int i6 = $dirty;
            OutlinedTextFieldDefaults.INSTANCE.m3603ContainerBoxnbWgWpA(enabled, isError, interactionSource, colors, shape3, focusedBorderThickness3, unfocusedBorderThickness2, $composer2, 12582912 | ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty2;
            shape3 = shape2;
            focusedBorderThickness3 = focusedBorderThickness2;
            unfocusedBorderThickness2 = f;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldDefaults$OutlinedBorderContainerBox$1(this, enabled, isError, interactionSource, colors, shape3, focusedBorderThickness3, unfocusedBorderThickness2, $changed, i));
        }
    }

    /* renamed from: textFieldWithLabelPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m3824textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m3843textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* renamed from: textFieldWithLabelPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m3843textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return m3828contentPaddingWithLabela9UjIt4(start, end, top, bottom);
    }

    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m3825textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m3844textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithoutLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithoutLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m3844textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return m3829contentPaddingWithoutLabela9UjIt4(start, top, end, bottom);
    }

    /* renamed from: outlinedTextFieldPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m3822outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m3839outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.contentPadding`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.contentPadding(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* renamed from: outlinedTextFieldPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m3839outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return OutlinedTextFieldDefaults.INSTANCE.m3605contentPaddinga9UjIt4(start, top, end, bottom);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v101, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.colors` with additional parameters to controlcontainer color based on state.", replaceWith = @kotlin.ReplaceWith(expression = "TextFieldDefaults.colors(\n        focusedTextColor = focusedTextColor,\n        unfocusedTextColor = unfocusedTextColor,\n        disabledTextColor = disabledTextColor,\n        errorTextColor = errorTextColor,\n        focusedContainerColor = containerColor,\n        unfocusedContainerColor = containerColor,\n        disabledContainerColor = containerColor,\n        errorContainerColor = errorContainerColor,\n        cursorColor = cursorColor,\n        errorCursorColor = errorCursorColor,\n        selectionColors = selectionColors,\n        focusedIndicatorColor = focusedIndicatorColor,\n        unfocusedIndicatorColor = unfocusedIndicatorColor,\n        disabledIndicatorColor = disabledIndicatorColor,\n        errorIndicatorColor = errorIndicatorColor,\n        focusedLeadingIconColor = focusedLeadingIconColor,\n        unfocusedLeadingIconColor = unfocusedLeadingIconColor,\n        disabledLeadingIconColor = disabledLeadingIconColor,\n        errorLeadingIconColor = errorLeadingIconColor,\n        focusedTrailingIconColor = focusedTrailingIconColor,\n        unfocusedTrailingIconColor = unfocusedTrailingIconColor,\n        disabledTrailingIconColor = disabledTrailingIconColor,\n        errorTrailingIconColor = errorTrailingIconColor,\n        focusedLabelColor = focusedLabelColor,\n        unfocusedLabelColor = unfocusedLabelColor,\n        disabledLabelColor = disabledLabelColor,\n        errorLabelColor = errorLabelColor,\n        focusedPlaceholderColor = focusedPlaceholderColor,\n        unfocusedPlaceholderColor = unfocusedPlaceholderColor,\n        disabledPlaceholderColor = disabledPlaceholderColor,\n        errorPlaceholderColor = errorPlaceholderColor,\n        focusedSupportingTextColor = focusedSupportingTextColor,\n        unfocusedSupportingTextColor = unfocusedSupportingTextColor,\n        disabledSupportingTextColor = disabledSupportingTextColor,\n        errorSupportingTextColor = errorSupportingTextColor,\n        focusedPrefixColor = focusedPrefixColor,\n        unfocusedPrefixColor = unfocusedPrefixColor,\n        disabledPrefixColor = disabledPrefixColor,\n        errorPrefixColor = errorPrefixColor,\n        focusedSuffixColor = focusedSuffixColor,\n        unfocusedSuffixColor = unfocusedSuffixColor,\n        disabledSuffixColor = disabledSuffixColor,\n        errorSuffixColor = errorSuffixColor,\n    )", imports = {}))
    /* renamed from: textFieldColors-M37tBTI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material3.TextFieldColors m3841textFieldColorsM37tBTI(long r179, long r181, long r183, long r185, long r187, long r189, long r191, long r193, androidx.compose.foundation.text.selection.TextSelectionColors r195, long r196, long r198, long r200, long r202, long r204, long r206, long r208, long r210, long r212, long r214, long r216, long r218, long r220, long r222, long r224, long r226, long r228, long r230, long r232, long r234, long r236, long r238, long r240, long r242, long r244, long r246, long r248, long r250, long r252, long r254, long r256, long r258, androidx.compose.runtime.Composer r260, int r261, int r262, int r263, int r264, int r265, int r266, int r267) {
        /*
            r178 = this;
            r15 = r260
            r13 = r261
            r14 = r262
            r94 = r263
            r95 = r264
            r96 = r265
            r0 = r266
            r1 = r267
            r2 = 568209592(0x21de30b8, float:1.5056201E-18)
            r15.startReplaceableGroup(r2)
            java.lang.String r3 = "C(textFieldColors)P(29:c#ui.graphics.Color,39:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,31,22:c#ui.graphics.Color,32:c#ui.graphics.Color,2:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,30:c#ui.graphics.Color,40:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,27:c#ui.graphics.Color,37:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)671@35322L9,672@35402L9,673@35489L9,675@35640L9,676@35720L9,677@35805L9,678@35878L9,679@35966L9,680@36049L7,681@36145L9,682@36240L9,683@36342L9,685@36518L9,686@36614L9,687@36707L9,688@36807L9,690@36977L9,691@37075L9,692@37170L9,693@37272L9,695@37445L9,696@37529L9,697@37610L9,698@37698L9,700@37850L9,701@37946L9,702@38044L9,703@38138L9,705@38302L9,706@38400L9,707@38495L9,708@38597L9,710@38768L9,711@38854L9,712@38942L9,713@39029L9,715@39183L9,716@39269L9,717@39357L9,718@39444L9,720@39598L9,721@39634L2308:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
            r3 = r0 & 1
            r4 = 6
            if (r3 == 0) goto L_0x002d
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFocusInputColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r97 = r5
            goto L_0x002f
        L_0x002d:
            r97 = r179
        L_0x002f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0040
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getInputColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r99 = r5
            goto L_0x0042
        L_0x0040:
            r99 = r181
        L_0x0042:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0061
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getDisabledInputColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r11 = 14
            r12 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r5, r7, r8, r9, r10, r11, r12)
            r101 = r5
            goto L_0x0063
        L_0x0061:
            r101 = r183
        L_0x0063:
            r3 = r0 & 8
            if (r3 == 0) goto L_0x0074
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getErrorInputColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r103 = r5
            goto L_0x0076
        L_0x0074:
            r103 = r185
        L_0x0076:
            r3 = r0 & 16
            if (r3 == 0) goto L_0x0087
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getContainerColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r105 = r5
            goto L_0x0089
        L_0x0087:
            r105 = r187
        L_0x0089:
            r3 = r0 & 32
            if (r3 == 0) goto L_0x009a
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getContainerColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r107 = r5
            goto L_0x009c
        L_0x009a:
            r107 = r189
        L_0x009c:
            r3 = r0 & 64
            if (r3 == 0) goto L_0x00ad
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getCaretColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r109 = r5
            goto L_0x00af
        L_0x00ad:
            r109 = r191
        L_0x00af:
            r3 = r0 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x00c0
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getErrorFocusCaretColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r111 = r5
            goto L_0x00c2
        L_0x00c0:
            r111 = r193
        L_0x00c2:
            r3 = r0 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x00e3
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r5 = 0
            r6 = 0
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r7, r8)
            java.lang.Object r7 = r15.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r260)
            r3 = r7
            androidx.compose.foundation.text.selection.TextSelectionColors r3 = (androidx.compose.foundation.text.selection.TextSelectionColors) r3
            r113 = r3
            goto L_0x00e5
        L_0x00e3:
            r113 = r195
        L_0x00e5:
            r3 = r0 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x00f6
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFocusActiveIndicatorColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r114 = r5
            goto L_0x00f8
        L_0x00f6:
            r114 = r196
        L_0x00f8:
            r3 = r0 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0109
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getActiveIndicatorColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r116 = r5
            goto L_0x010b
        L_0x0109:
            r116 = r198
        L_0x010b:
            r3 = r0 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x0138
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getDisabledActiveIndicatorColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r11 = 0
            r179 = r5
            r181 = r8
            r182 = r9
            r183 = r10
            r184 = r11
            r185 = r3
            r186 = r7
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r118 = r5
            goto L_0x013a
        L_0x0138:
            r118 = r200
        L_0x013a:
            r3 = r0 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x014b
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getErrorActiveIndicatorColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r120 = r5
            goto L_0x014d
        L_0x014b:
            r120 = r202
        L_0x014d:
            r3 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x015e
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFocusLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r122 = r5
            goto L_0x0160
        L_0x015e:
            r122 = r204
        L_0x0160:
            r3 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x0171
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r124 = r5
            goto L_0x0173
        L_0x0171:
            r124 = r206
        L_0x0173:
            r3 = 32768(0x8000, float:4.5918E-41)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x01a2
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getDisabledLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r11 = 0
            r179 = r5
            r181 = r8
            r182 = r9
            r183 = r10
            r184 = r11
            r185 = r3
            r186 = r7
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r126 = r5
            goto L_0x01a4
        L_0x01a2:
            r126 = r208
        L_0x01a4:
            r3 = 65536(0x10000, float:9.18355E-41)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x01b6
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getErrorLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r128 = r5
            goto L_0x01b8
        L_0x01b6:
            r128 = r210
        L_0x01b8:
            r3 = 131072(0x20000, float:1.83671E-40)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x01ca
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFocusTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r130 = r5
            goto L_0x01cc
        L_0x01ca:
            r130 = r212
        L_0x01cc:
            r3 = 262144(0x40000, float:3.67342E-40)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x01de
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r132 = r5
            goto L_0x01e0
        L_0x01de:
            r132 = r214
        L_0x01e0:
            r3 = 524288(0x80000, float:7.34684E-40)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x020e
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getDisabledTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r11 = 0
            r179 = r5
            r181 = r8
            r182 = r9
            r183 = r10
            r184 = r11
            r185 = r3
            r186 = r7
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r134 = r5
            goto L_0x0210
        L_0x020e:
            r134 = r216
        L_0x0210:
            r3 = 1048576(0x100000, float:1.469368E-39)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0222
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getErrorTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r136 = r5
            goto L_0x0224
        L_0x0222:
            r136 = r218
        L_0x0224:
            r3 = 2097152(0x200000, float:2.938736E-39)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0236
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFocusLabelColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r138 = r5
            goto L_0x0238
        L_0x0236:
            r138 = r220
        L_0x0238:
            r3 = 4194304(0x400000, float:5.877472E-39)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x024a
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getLabelColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r140 = r5
            goto L_0x024c
        L_0x024a:
            r140 = r222
        L_0x024c:
            r3 = 8388608(0x800000, float:1.17549435E-38)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x027a
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getDisabledLabelColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r11 = 0
            r179 = r5
            r181 = r8
            r182 = r9
            r183 = r10
            r184 = r11
            r185 = r3
            r186 = r7
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r142 = r5
            goto L_0x027c
        L_0x027a:
            r142 = r224
        L_0x027c:
            r3 = 16777216(0x1000000, float:2.3509887E-38)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x028e
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getErrorLabelColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r144 = r5
            goto L_0x0290
        L_0x028e:
            r144 = r226
        L_0x0290:
            r3 = 33554432(0x2000000, float:9.403955E-38)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x02a2
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getInputPlaceholderColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r146 = r5
            goto L_0x02a4
        L_0x02a2:
            r146 = r228
        L_0x02a4:
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x02b6
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getInputPlaceholderColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r148 = r5
            goto L_0x02b8
        L_0x02b6:
            r148 = r230
        L_0x02b8:
            r3 = 134217728(0x8000000, float:3.85186E-34)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x02e6
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getDisabledInputColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r11 = 0
            r179 = r5
            r181 = r8
            r182 = r9
            r183 = r10
            r184 = r11
            r185 = r3
            r186 = r7
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r150 = r5
            goto L_0x02e8
        L_0x02e6:
            r150 = r232
        L_0x02e8:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x02fa
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getInputPlaceholderColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r152 = r5
            goto L_0x02fc
        L_0x02fa:
            r152 = r234
        L_0x02fc:
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x030e
            androidx.compose.material3.tokens.FilledTextFieldTokens r3 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFocusSupportingColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r154 = r5
            goto L_0x0310
        L_0x030e:
            r154 = r236
        L_0x0310:
            r3 = 1073741824(0x40000000, float:2.0)
            r0 = r0 & r3
            if (r0 == 0) goto L_0x0322
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getSupportingColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r156 = r5
            goto L_0x0324
        L_0x0322:
            r156 = r238
        L_0x0324:
            r0 = r1 & 1
            if (r0 == 0) goto L_0x0351
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getDisabledSupportingColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r0 = 14
            r3 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r179 = r5
            r181 = r7
            r182 = r8
            r183 = r9
            r184 = r10
            r185 = r0
            r186 = r3
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r158 = r5
            goto L_0x0353
        L_0x0351:
            r158 = r240
        L_0x0353:
            r0 = r1 & 2
            if (r0 == 0) goto L_0x0364
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getErrorSupportingColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r160 = r5
            goto L_0x0366
        L_0x0364:
            r160 = r242
        L_0x0366:
            r0 = r1 & 4
            if (r0 == 0) goto L_0x0377
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputPrefixColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r162 = r5
            goto L_0x0379
        L_0x0377:
            r162 = r244
        L_0x0379:
            r0 = r1 & 8
            if (r0 == 0) goto L_0x038a
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputPrefixColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r164 = r5
            goto L_0x038c
        L_0x038a:
            r164 = r246
        L_0x038c:
            r0 = r1 & 16
            if (r0 == 0) goto L_0x03b9
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputPrefixColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r0 = 14
            r3 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r179 = r5
            r181 = r7
            r182 = r8
            r183 = r9
            r184 = r10
            r185 = r0
            r186 = r3
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r166 = r5
            goto L_0x03bb
        L_0x03b9:
            r166 = r248
        L_0x03bb:
            r0 = r1 & 32
            if (r0 == 0) goto L_0x03cc
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputPrefixColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r168 = r5
            goto L_0x03ce
        L_0x03cc:
            r168 = r250
        L_0x03ce:
            r0 = r1 & 64
            if (r0 == 0) goto L_0x03df
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r170 = r5
            goto L_0x03e1
        L_0x03df:
            r170 = r252
        L_0x03e1:
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x03f2
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r172 = r5
            goto L_0x03f4
        L_0x03f2:
            r172 = r254
        L_0x03f4:
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0421
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r0 = 14
            r3 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r179 = r5
            r181 = r7
            r182 = r8
            r183 = r9
            r184 = r10
            r185 = r0
            r186 = r3
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r174 = r5
            goto L_0x0423
        L_0x0421:
            r174 = r256
        L_0x0423:
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0434
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r0 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r176 = r0
            goto L_0x0436
        L_0x0434:
            r176 = r258
        L_0x0436:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0441
            java.lang.String r0 = "androidx.compose.material3.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:670)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r13, r14, r0)
        L_0x0441:
            r0 = r13 & 14
            r1 = r13 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r13 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r13 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            r2 = r13 & r1
            r0 = r0 | r2
            int r2 = r13 << 3
            r3 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r3
            r0 = r0 | r2
            int r2 = r13 << 6
            r4 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r4
            r0 = r0 | r2
            int r2 = r13 << 6
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r5
            r0 = r0 | r2
            int r2 = r13 << 6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r6
            r0 = r0 | r2
            int r2 = r13 << 6
            r7 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r7
            r87 = r0 | r2
            int r0 = r13 >> 24
            r0 = r0 & 14
            int r2 = r13 >> 24
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r1
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r3
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r4
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r5
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r6
            r0 = r0 | r2
            int r2 = r14 << 6
            r2 = r2 & r7
            r88 = r0 | r2
            int r0 = r14 >> 24
            r0 = r0 & 14
            int r2 = r14 >> 24
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r94 << 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r94 << 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r94 << 6
            r2 = r2 & r1
            r0 = r0 | r2
            int r2 = r94 << 6
            r2 = r2 & r3
            r0 = r0 | r2
            int r2 = r94 << 6
            r2 = r2 & r4
            r0 = r0 | r2
            int r2 = r94 << 6
            r2 = r2 & r5
            r0 = r0 | r2
            int r2 = r94 << 6
            r2 = r2 & r6
            r0 = r0 | r2
            int r2 = r94 << 6
            r2 = r2 & r7
            r89 = r0 | r2
            int r0 = r94 >> 24
            r0 = r0 & 14
            int r2 = r94 >> 24
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r95 << 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r95 << 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r95 << 6
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r95 << 6
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r95 << 6
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r95 << 6
            r1 = r1 & r5
            r0 = r0 | r1
            int r1 = r95 << 6
            r1 = r1 & r6
            r0 = r0 | r1
            int r1 = r95 << 6
            r1 = r1 & r7
            r90 = r0 | r1
            int r0 = r95 >> 24
            r0 = r0 & 14
            int r1 = r95 >> 24
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r96 << 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r96 << 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r91 = r0 | r1
            r92 = 0
            r93 = 0
            r0 = r178
            r1 = r97
            r3 = r99
            r5 = r101
            r7 = r103
            r9 = r105
            r11 = r105
            r13 = r105
            r15 = r107
            r17 = r109
            r19 = r111
            r21 = r113
            r22 = r114
            r24 = r116
            r26 = r118
            r28 = r120
            r30 = r122
            r32 = r124
            r34 = r126
            r36 = r128
            r38 = r130
            r40 = r132
            r42 = r134
            r44 = r136
            r46 = r138
            r48 = r140
            r50 = r142
            r52 = r144
            r54 = r146
            r56 = r148
            r58 = r150
            r60 = r152
            r62 = r154
            r64 = r156
            r66 = r158
            r68 = r160
            r70 = r162
            r72 = r164
            r74 = r166
            r76 = r168
            r78 = r170
            r80 = r172
            r82 = r174
            r84 = r176
            r86 = r260
            androidx.compose.material3.TextFieldColors r0 = r0.m3827colors0hiis_0(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r87, r88, r89, r90, r91, r92, r93)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x059e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x059e:
            r260.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.m3841textFieldColorsM37tBTI(long, long, long, long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v154, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.colors` with additional parameters tocontrol container color based on state.", replaceWith = @kotlin.ReplaceWith(expression = "OutlinedTextFieldDefaults.colors(\n        focusedTextColor = focusedTextColor,\n        unfocusedTextColor = unfocusedTextColor,\n        disabledTextColor = disabledTextColor,\n        errorTextColor = errorTextColor,\n        focusedContainerColor = containerColor,\n        unfocusedContainerColor = containerColor,\n        disabledContainerColor = containerColor,\n        errorContainerColor = errorContainerColor,\n        cursorColor = cursorColor,\n        errorCursorColor = errorCursorColor,\n        selectionColors = selectionColors,\n        focusedBorderColor = focusedBorderColor,\n        unfocusedBorderColor = unfocusedBorderColor,\n        disabledBorderColor = disabledBorderColor,\n        errorBorderColor = errorBorderColor,\n        focusedLeadingIconColor = focusedLeadingIconColor,\n        unfocusedLeadingIconColor = unfocusedLeadingIconColor,\n        disabledLeadingIconColor = disabledLeadingIconColor,\n        errorLeadingIconColor = errorLeadingIconColor,\n        focusedTrailingIconColor = focusedTrailingIconColor,\n        unfocusedTrailingIconColor = unfocusedTrailingIconColor,\n        disabledTrailingIconColor = disabledTrailingIconColor,\n        errorTrailingIconColor = errorTrailingIconColor,\n        focusedLabelColor = focusedLabelColor,\n        unfocusedLabelColor = unfocusedLabelColor,\n        disabledLabelColor = disabledLabelColor,\n        errorLabelColor = errorLabelColor,\n        focusedPlaceholderColor = focusedPlaceholderColor,\n        unfocusedPlaceholderColor = unfocusedPlaceholderColor,\n        disabledPlaceholderColor = disabledPlaceholderColor,\n        errorPlaceholderColor = errorPlaceholderColor,\n        focusedSupportingTextColor = focusedSupportingTextColor,\n        unfocusedSupportingTextColor = unfocusedSupportingTextColor,\n        disabledSupportingTextColor = disabledSupportingTextColor,\n        errorSupportingTextColor = errorSupportingTextColor,\n        focusedPrefixColor = focusedPrefixColor,\n        unfocusedPrefixColor = unfocusedPrefixColor,\n        disabledPrefixColor = disabledPrefixColor,\n        errorPrefixColor = errorPrefixColor,\n        focusedSuffixColor = focusedSuffixColor,\n        unfocusedSuffixColor = unfocusedSuffixColor,\n        disabledSuffixColor = disabledSuffixColor,\n        errorSuffixColor = errorSuffixColor,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* renamed from: outlinedTextFieldColors-M37tBTI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material3.TextFieldColors m3837outlinedTextFieldColorsM37tBTI(long r179, long r181, long r183, long r185, long r187, long r189, long r191, long r193, androidx.compose.foundation.text.selection.TextSelectionColors r195, long r196, long r198, long r200, long r202, long r204, long r206, long r208, long r210, long r212, long r214, long r216, long r218, long r220, long r222, long r224, long r226, long r228, long r230, long r232, long r234, long r236, long r238, long r240, long r242, long r244, long r246, long r248, long r250, long r252, long r254, long r256, long r258, androidx.compose.runtime.Composer r260, int r261, int r262, int r263, int r264, int r265, int r266, int r267) {
        /*
            r178 = this;
            r15 = r260
            r13 = r261
            r14 = r262
            r94 = r263
            r95 = r264
            r0 = r266
            r1 = r267
            r2 = 618732090(0x24e11a3a, float:9.7622625E-17)
            r15.startReplaceableGroup(r2)
            java.lang.String r3 = "C(outlinedTextFieldColors)P(29:c#ui.graphics.Color,39:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,1:c#ui.graphics.Color,13:c#ui.graphics.Color,31,22:c#ui.graphics.Color,32:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,30:c#ui.graphics.Color,40:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,27:c#ui.graphics.Color,37:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)821@45523L9,822@45605L9,823@45694L9,825@45849L9,828@46031L9,829@46121L9,830@46204L7,831@46291L9,832@46377L9,833@46470L9,835@46631L9,836@46729L9,837@46824L9,838@46926L9,840@47100L9,841@47200L9,842@47297L9,844@47414L9,845@47578L9,846@47664L9,847@47747L9,848@47837L9,850@47993L9,851@48091L9,852@48191L9,853@48287L9,855@48455L9,856@48555L9,857@48652L9,859@48769L9,860@48931L9,861@49019L9,862@49109L9,863@49198L9,865@49356L9,866@49444L9,867@49534L9,868@49623L9,870@49781L9,871@49843L2284:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
            r3 = r0 & 1
            r4 = 6
            if (r3 == 0) goto L_0x002b
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFocusInputColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r96 = r5
            goto L_0x002d
        L_0x002b:
            r96 = r179
        L_0x002d:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x003e
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getInputColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r98 = r5
            goto L_0x0040
        L_0x003e:
            r98 = r181
        L_0x0040:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x005f
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getDisabledInputColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r11 = 14
            r12 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r5, r7, r8, r9, r10, r11, r12)
            r100 = r5
            goto L_0x0061
        L_0x005f:
            r100 = r183
        L_0x0061:
            r3 = r0 & 8
            if (r3 == 0) goto L_0x0072
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getErrorInputColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r102 = r5
            goto L_0x0074
        L_0x0072:
            r102 = r185
        L_0x0074:
            r3 = r0 & 16
            if (r3 == 0) goto L_0x0081
            androidx.compose.ui.graphics.Color$Companion r3 = androidx.compose.ui.graphics.Color.Companion
            long r5 = r3.m4998getTransparent0d7_KjU()
            r104 = r5
            goto L_0x0083
        L_0x0081:
            r104 = r187
        L_0x0083:
            r3 = r0 & 32
            if (r3 == 0) goto L_0x0090
            androidx.compose.ui.graphics.Color$Companion r3 = androidx.compose.ui.graphics.Color.Companion
            long r5 = r3.m4998getTransparent0d7_KjU()
            r106 = r5
            goto L_0x0092
        L_0x0090:
            r106 = r189
        L_0x0092:
            r3 = r0 & 64
            if (r3 == 0) goto L_0x00a3
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getCaretColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r108 = r5
            goto L_0x00a5
        L_0x00a3:
            r108 = r191
        L_0x00a5:
            r3 = r0 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x00b6
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getErrorFocusCaretColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r110 = r5
            goto L_0x00b8
        L_0x00b6:
            r110 = r193
        L_0x00b8:
            r3 = r0 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x00d9
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r5 = 0
            r6 = 0
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r7, r8)
            java.lang.Object r7 = r15.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r260)
            r3 = r7
            androidx.compose.foundation.text.selection.TextSelectionColors r3 = (androidx.compose.foundation.text.selection.TextSelectionColors) r3
            r112 = r3
            goto L_0x00db
        L_0x00d9:
            r112 = r195
        L_0x00db:
            r3 = r0 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x00ec
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFocusOutlineColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r113 = r5
            goto L_0x00ee
        L_0x00ec:
            r113 = r196
        L_0x00ee:
            r3 = r0 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x00ff
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getOutlineColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r115 = r5
            goto L_0x0101
        L_0x00ff:
            r115 = r198
        L_0x0101:
            r3 = r0 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x012e
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getDisabledOutlineColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1039516303(0x3df5c28f, float:0.12)
            r9 = 0
            r10 = 0
            r11 = 0
            r179 = r5
            r181 = r8
            r182 = r9
            r183 = r10
            r184 = r11
            r185 = r3
            r186 = r7
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r117 = r5
            goto L_0x0130
        L_0x012e:
            r117 = r200
        L_0x0130:
            r3 = r0 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x0141
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getErrorOutlineColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r119 = r5
            goto L_0x0143
        L_0x0141:
            r119 = r202
        L_0x0143:
            r3 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x0154
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFocusLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r121 = r5
            goto L_0x0156
        L_0x0154:
            r121 = r204
        L_0x0156:
            r3 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x0167
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r123 = r5
            goto L_0x0169
        L_0x0167:
            r123 = r206
        L_0x0169:
            r3 = 32768(0x8000, float:4.5918E-41)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0198
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getDisabledLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r11 = 0
            r179 = r5
            r181 = r8
            r182 = r9
            r183 = r10
            r184 = r11
            r185 = r3
            r186 = r7
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r125 = r5
            goto L_0x019a
        L_0x0198:
            r125 = r208
        L_0x019a:
            r3 = 65536(0x10000, float:9.18355E-41)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x01ac
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getErrorLeadingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r127 = r5
            goto L_0x01ae
        L_0x01ac:
            r127 = r210
        L_0x01ae:
            r3 = 131072(0x20000, float:1.83671E-40)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x01c0
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFocusTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r129 = r5
            goto L_0x01c2
        L_0x01c0:
            r129 = r212
        L_0x01c2:
            r3 = 262144(0x40000, float:3.67342E-40)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x01d4
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r131 = r5
            goto L_0x01d6
        L_0x01d4:
            r131 = r214
        L_0x01d6:
            r3 = 524288(0x80000, float:7.34684E-40)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0204
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getDisabledTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r11 = 0
            r179 = r5
            r181 = r8
            r182 = r9
            r183 = r10
            r184 = r11
            r185 = r3
            r186 = r7
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r133 = r5
            goto L_0x0206
        L_0x0204:
            r133 = r216
        L_0x0206:
            r3 = 1048576(0x100000, float:1.469368E-39)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0218
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getErrorTrailingIconColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r135 = r5
            goto L_0x021a
        L_0x0218:
            r135 = r218
        L_0x021a:
            r3 = 2097152(0x200000, float:2.938736E-39)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x022c
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFocusLabelColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r137 = r5
            goto L_0x022e
        L_0x022c:
            r137 = r220
        L_0x022e:
            r3 = 4194304(0x400000, float:5.877472E-39)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0240
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getLabelColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r139 = r5
            goto L_0x0242
        L_0x0240:
            r139 = r222
        L_0x0242:
            r3 = 8388608(0x800000, float:1.17549435E-38)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0270
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getDisabledLabelColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r11 = 0
            r179 = r5
            r181 = r8
            r182 = r9
            r183 = r10
            r184 = r11
            r185 = r3
            r186 = r7
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r141 = r5
            goto L_0x0272
        L_0x0270:
            r141 = r224
        L_0x0272:
            r3 = 16777216(0x1000000, float:2.3509887E-38)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0284
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getErrorLabelColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r143 = r5
            goto L_0x0286
        L_0x0284:
            r143 = r226
        L_0x0286:
            r3 = 33554432(0x2000000, float:9.403955E-38)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0298
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getInputPlaceholderColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r145 = r5
            goto L_0x029a
        L_0x0298:
            r145 = r228
        L_0x029a:
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x02ac
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getInputPlaceholderColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r147 = r5
            goto L_0x02ae
        L_0x02ac:
            r147 = r230
        L_0x02ae:
            r3 = 134217728(0x8000000, float:3.85186E-34)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x02dc
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getDisabledInputColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r3 = 14
            r7 = 0
            r8 = 1052938076(0x3ec28f5c, float:0.38)
            r9 = 0
            r10 = 0
            r11 = 0
            r179 = r5
            r181 = r8
            r182 = r9
            r183 = r10
            r184 = r11
            r185 = r3
            r186 = r7
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r149 = r5
            goto L_0x02de
        L_0x02dc:
            r149 = r232
        L_0x02de:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x02f0
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getInputPlaceholderColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r151 = r5
            goto L_0x02f2
        L_0x02f0:
            r151 = r234
        L_0x02f2:
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0304
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r3 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getFocusSupportingColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r3, r15, r4)
            r153 = r5
            goto L_0x0306
        L_0x0304:
            r153 = r236
        L_0x0306:
            r3 = 1073741824(0x40000000, float:2.0)
            r0 = r0 & r3
            if (r0 == 0) goto L_0x0318
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getSupportingColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r155 = r5
            goto L_0x031a
        L_0x0318:
            r155 = r238
        L_0x031a:
            r0 = r1 & 1
            if (r0 == 0) goto L_0x0347
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getDisabledSupportingColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r0 = 14
            r3 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r179 = r5
            r181 = r7
            r182 = r8
            r183 = r9
            r184 = r10
            r185 = r0
            r186 = r3
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r157 = r5
            goto L_0x0349
        L_0x0347:
            r157 = r240
        L_0x0349:
            r0 = r1 & 2
            if (r0 == 0) goto L_0x035a
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getErrorSupportingColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r159 = r5
            goto L_0x035c
        L_0x035a:
            r159 = r242
        L_0x035c:
            r0 = r1 & 4
            if (r0 == 0) goto L_0x036d
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputPrefixColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r161 = r5
            goto L_0x036f
        L_0x036d:
            r161 = r244
        L_0x036f:
            r0 = r1 & 8
            if (r0 == 0) goto L_0x0380
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputPrefixColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r163 = r5
            goto L_0x0382
        L_0x0380:
            r163 = r246
        L_0x0382:
            r0 = r1 & 16
            if (r0 == 0) goto L_0x03af
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputPrefixColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r0 = 14
            r3 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r179 = r5
            r181 = r7
            r182 = r8
            r183 = r9
            r184 = r10
            r185 = r0
            r186 = r3
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r165 = r5
            goto L_0x03b1
        L_0x03af:
            r165 = r248
        L_0x03b1:
            r0 = r1 & 32
            if (r0 == 0) goto L_0x03c2
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputPrefixColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r167 = r5
            goto L_0x03c4
        L_0x03c2:
            r167 = r250
        L_0x03c4:
            r0 = r1 & 64
            if (r0 == 0) goto L_0x03d5
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r169 = r5
            goto L_0x03d7
        L_0x03d5:
            r169 = r252
        L_0x03d7:
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x03e8
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r171 = r5
            goto L_0x03ea
        L_0x03e8:
            r171 = r254
        L_0x03ea:
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0417
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r5 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r0 = 14
            r3 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r179 = r5
            r181 = r7
            r182 = r8
            r183 = r9
            r184 = r10
            r185 = r0
            r186 = r3
            long r5 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r179, r181, r182, r183, r184, r185, r186)
            r173 = r5
            goto L_0x0419
        L_0x0417:
            r173 = r256
        L_0x0419:
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x042a
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r0 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r4)
            r175 = r0
            goto L_0x042c
        L_0x042a:
            r175 = r258
        L_0x042c:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0437
            java.lang.String r0 = "androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:820)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r13, r14, r0)
        L_0x0437:
            androidx.compose.material3.OutlinedTextFieldDefaults r0 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r1 = r13 & 14
            r2 = r13 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r13 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r13 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r3 = r13 & r2
            r1 = r1 | r3
            int r3 = r13 << 3
            r4 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r4
            r1 = r1 | r3
            int r3 = r13 << 6
            r5 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r5
            r1 = r1 | r3
            int r3 = r13 << 6
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r6
            r1 = r1 | r3
            int r3 = r13 << 6
            r7 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r7
            r1 = r1 | r3
            int r3 = r13 << 6
            r8 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r8
            r87 = r1 | r3
            int r1 = r13 >> 24
            r1 = r1 & 14
            int r3 = r13 >> 24
            r3 = r3 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            int r3 = r14 << 6
            r3 = r3 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            int r3 = r14 << 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r3
            int r3 = r14 << 6
            r3 = r3 & r2
            r1 = r1 | r3
            int r3 = r14 << 6
            r3 = r3 & r4
            r1 = r1 | r3
            int r3 = r14 << 6
            r3 = r3 & r5
            r1 = r1 | r3
            int r3 = r14 << 6
            r3 = r3 & r6
            r1 = r1 | r3
            int r3 = r14 << 6
            r3 = r3 & r7
            r1 = r1 | r3
            int r3 = r14 << 6
            r3 = r3 & r8
            r88 = r1 | r3
            int r1 = r14 >> 24
            r1 = r1 & 14
            int r3 = r14 >> 24
            r3 = r3 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            int r3 = r94 << 6
            r3 = r3 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            int r3 = r94 << 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r3
            int r3 = r94 << 6
            r3 = r3 & r2
            r1 = r1 | r3
            int r3 = r94 << 6
            r3 = r3 & r4
            r1 = r1 | r3
            int r3 = r94 << 6
            r3 = r3 & r5
            r1 = r1 | r3
            int r3 = r94 << 6
            r3 = r3 & r6
            r1 = r1 | r3
            int r3 = r94 << 6
            r3 = r3 & r7
            r1 = r1 | r3
            int r3 = r94 << 6
            r3 = r3 & r8
            r89 = r1 | r3
            int r1 = r94 >> 24
            r1 = r1 & 14
            int r3 = r94 >> 24
            r3 = r3 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            int r3 = r95 << 6
            r3 = r3 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            int r3 = r95 << 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r3
            int r3 = r95 << 6
            r2 = r2 & r3
            r1 = r1 | r2
            int r2 = r95 << 6
            r2 = r2 & r4
            r1 = r1 | r2
            int r2 = r95 << 6
            r2 = r2 & r5
            r1 = r1 | r2
            int r2 = r95 << 6
            r2 = r2 & r6
            r1 = r1 | r2
            int r2 = r95 << 6
            r2 = r2 & r7
            r1 = r1 | r2
            int r2 = r95 << 6
            r2 = r2 & r8
            r90 = r1 | r2
            int r1 = r95 >> 24
            r1 = r1 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            int r2 = r95 >> 24
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r177 = r265
            int r2 = r177 << 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r91 = r1 | r2
            r92 = 0
            r93 = 0
            r1 = r96
            r3 = r98
            r5 = r100
            r7 = r102
            r9 = r104
            r11 = r104
            r13 = r104
            r15 = r106
            r17 = r108
            r19 = r110
            r21 = r112
            r22 = r113
            r24 = r115
            r26 = r117
            r28 = r119
            r30 = r121
            r32 = r123
            r34 = r125
            r36 = r127
            r38 = r129
            r40 = r131
            r42 = r133
            r44 = r135
            r46 = r137
            r48 = r139
            r50 = r141
            r52 = r143
            r54 = r145
            r56 = r147
            r58 = r149
            r60 = r151
            r62 = r153
            r64 = r155
            r66 = r157
            r68 = r159
            r70 = r161
            r72 = r163
            r74 = r165
            r76 = r167
            r78 = r169
            r80 = r171
            r82 = r173
            r84 = r175
            r86 = r260
            androidx.compose.material3.TextFieldColors r0 = r0.m3604colors0hiis_0(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r87, r88, r89, r90, r91, r92, r93)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0593
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0593:
            r260.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.m3837outlinedTextFieldColorsM37tBTI(long, long, long, long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x051a  */
    /* JADX WARNING: Removed duplicated region for block: B:276:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0158  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.DecorationBox`", replaceWith = @kotlin.ReplaceWith(expression = "TextFieldDefaults.DecorationBox(\n        value = value,\n        innerTextField = innerTextField,\n        enabled = enabled,\n        singleLine = singleLine,\n        visualTransformation = visualTransformation,\n        interactionSource = interactionSource,\n        isError = isError,\n        label = label,\n        placeholder = placeholder,\n        leadingIcon = leadingIcon,\n        trailingIcon = trailingIcon,\n        prefix = prefix,\n        suffix = suffix,\n        supportingText = supportingText,\n        shape = shape,\n        colors = colors,\n        contentPadding = contentPadding,\n        container = container,\n    )", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void TextFieldDecorationBox(java.lang.String r119, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r120, boolean r121, boolean r122, androidx.compose.ui.text.input.VisualTransformation r123, androidx.compose.foundation.interaction.InteractionSource r124, boolean r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r131, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r132, androidx.compose.ui.graphics.Shape r133, androidx.compose.material3.TextFieldColors r134, androidx.compose.foundation.layout.PaddingValues r135, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r136, androidx.compose.runtime.Composer r137, int r138, int r139, int r140) {
        /*
            r118 = this;
            r15 = r119
            r14 = r120
            r13 = r123
            r12 = r124
            r11 = r138
            r10 = r139
            r9 = r140
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "innerTextField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1042273141(0xffffffffc1e02c8b, float:-28.02175)
            r1 = r137
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(TextFieldDecorationBox)P(16,4,3,12,17,5,6,7,9,8,15,10,13,14,11!1,2)958@54020L5,959@54061L8,969@54408L612:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = r138
            r1 = r139
            r2 = r9 & 1
            if (r2 == 0) goto L_0x003f
            r0 = r0 | 6
            goto L_0x004d
        L_0x003f:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x004d
            boolean r2 = r8.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x004b
            r2 = 4
            goto L_0x004c
        L_0x004b:
            r2 = 2
        L_0x004c:
            r0 = r0 | r2
        L_0x004d:
            r2 = r9 & 2
            if (r2 == 0) goto L_0x0054
            r0 = r0 | 48
            goto L_0x0064
        L_0x0054:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0064
            boolean r2 = r8.changedInstance(r14)
            if (r2 == 0) goto L_0x0061
            r2 = 32
            goto L_0x0063
        L_0x0061:
            r2 = 16
        L_0x0063:
            r0 = r0 | r2
        L_0x0064:
            r2 = r9 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x006f
            r0 = r0 | 384(0x180, float:5.38E-43)
            r2 = r121
            goto L_0x0085
        L_0x006f:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0083
            r2 = r121
            boolean r17 = r8.changed((boolean) r2)
            if (r17 == 0) goto L_0x007e
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x0080
        L_0x007e:
            r17 = r16
        L_0x0080:
            r0 = r0 | r17
            goto L_0x0085
        L_0x0083:
            r2 = r121
        L_0x0085:
            r17 = r9 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r17 == 0) goto L_0x0092
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r3 = r122
            goto L_0x00a8
        L_0x0092:
            r3 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x00a6
            r3 = r122
            boolean r17 = r8.changed((boolean) r3)
            if (r17 == 0) goto L_0x00a1
            r17 = r18
            goto L_0x00a3
        L_0x00a1:
            r17 = r19
        L_0x00a3:
            r0 = r0 | r17
            goto L_0x00a8
        L_0x00a6:
            r3 = r122
        L_0x00a8:
            r17 = r9 & 16
            r20 = 8192(0x2000, float:1.14794E-41)
            r110 = 57344(0xe000, float:8.0356E-41)
            r21 = 16384(0x4000, float:2.2959E-41)
            if (r17 == 0) goto L_0x00b6
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00c7
        L_0x00b6:
            r17 = r11 & r110
            if (r17 != 0) goto L_0x00c7
            boolean r17 = r8.changed((java.lang.Object) r13)
            if (r17 == 0) goto L_0x00c3
            r17 = r21
            goto L_0x00c5
        L_0x00c3:
            r17 = r20
        L_0x00c5:
            r0 = r0 | r17
        L_0x00c7:
            r17 = r9 & 32
            r111 = 458752(0x70000, float:6.42848E-40)
            r112 = 65536(0x10000, float:9.18355E-41)
            if (r17 == 0) goto L_0x00d4
            r17 = 196608(0x30000, float:2.75506E-40)
        L_0x00d1:
            r0 = r0 | r17
            goto L_0x00e4
        L_0x00d4:
            r17 = r11 & r111
            if (r17 != 0) goto L_0x00e4
            boolean r17 = r8.changed((java.lang.Object) r12)
            if (r17 == 0) goto L_0x00e1
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d1
        L_0x00e1:
            r17 = r112
            goto L_0x00d1
        L_0x00e4:
            r17 = r9 & 64
            r113 = 3670016(0x380000, float:5.142788E-39)
            if (r17 == 0) goto L_0x00f1
            r22 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r22
            r4 = r125
            goto L_0x0107
        L_0x00f1:
            r22 = r11 & r113
            if (r22 != 0) goto L_0x0105
            r4 = r125
            boolean r23 = r8.changed((boolean) r4)
            if (r23 == 0) goto L_0x0100
            r23 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0102
        L_0x0100:
            r23 = 524288(0x80000, float:7.34684E-40)
        L_0x0102:
            r0 = r0 | r23
            goto L_0x0107
        L_0x0105:
            r4 = r125
        L_0x0107:
            r5 = r9 & 128(0x80, float:1.794E-43)
            r114 = 29360128(0x1c00000, float:7.052966E-38)
            if (r5 == 0) goto L_0x0114
            r24 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r24
            r6 = r126
            goto L_0x012a
        L_0x0114:
            r24 = r11 & r114
            if (r24 != 0) goto L_0x0128
            r6 = r126
            boolean r25 = r8.changedInstance(r6)
            if (r25 == 0) goto L_0x0123
            r25 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0125
        L_0x0123:
            r25 = 4194304(0x400000, float:5.877472E-39)
        L_0x0125:
            r0 = r0 | r25
            goto L_0x012a
        L_0x0128:
            r6 = r126
        L_0x012a:
            r7 = r9 & 256(0x100, float:3.59E-43)
            r115 = 234881024(0xe000000, float:1.5777218E-30)
            if (r7 == 0) goto L_0x0137
            r26 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r26
            r2 = r127
            goto L_0x014d
        L_0x0137:
            r26 = r11 & r115
            if (r26 != 0) goto L_0x014b
            r2 = r127
            boolean r26 = r8.changedInstance(r2)
            if (r26 == 0) goto L_0x0146
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0148
        L_0x0146:
            r26 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0148:
            r0 = r0 | r26
            goto L_0x014d
        L_0x014b:
            r2 = r127
        L_0x014d:
            r2 = r9 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0158
            r26 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r26
            r3 = r128
            goto L_0x0170
        L_0x0158:
            r26 = 1879048192(0x70000000, float:1.58456325E29)
            r26 = r11 & r26
            if (r26 != 0) goto L_0x016e
            r3 = r128
            boolean r26 = r8.changedInstance(r3)
            if (r26 == 0) goto L_0x0169
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x016b
        L_0x0169:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x016b:
            r0 = r0 | r26
            goto L_0x0170
        L_0x016e:
            r3 = r128
        L_0x0170:
            r3 = r9 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0179
            r1 = r1 | 6
            r4 = r129
            goto L_0x018f
        L_0x0179:
            r26 = r10 & 14
            if (r26 != 0) goto L_0x018d
            r4 = r129
            boolean r26 = r8.changedInstance(r4)
            if (r26 == 0) goto L_0x0188
            r22 = 4
            goto L_0x018a
        L_0x0188:
            r22 = 2
        L_0x018a:
            r1 = r1 | r22
            goto L_0x018f
        L_0x018d:
            r4 = r129
        L_0x018f:
            r4 = r9 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0198
            r1 = r1 | 48
            r6 = r130
            goto L_0x01ae
        L_0x0198:
            r22 = r10 & 112(0x70, float:1.57E-43)
            if (r22 != 0) goto L_0x01ac
            r6 = r130
            boolean r22 = r8.changedInstance(r6)
            if (r22 == 0) goto L_0x01a7
            r23 = 32
            goto L_0x01a9
        L_0x01a7:
            r23 = 16
        L_0x01a9:
            r1 = r1 | r23
            goto L_0x01ae
        L_0x01ac:
            r6 = r130
        L_0x01ae:
            r6 = r9 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x01b7
            r1 = r1 | 384(0x180, float:5.38E-43)
            r12 = r131
            goto L_0x01cd
        L_0x01b7:
            r12 = r10 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x01cb
            r12 = r131
            boolean r22 = r8.changedInstance(r12)
            if (r22 == 0) goto L_0x01c6
            r25 = 256(0x100, float:3.59E-43)
            goto L_0x01c8
        L_0x01c6:
            r25 = r16
        L_0x01c8:
            r1 = r1 | r25
            goto L_0x01cd
        L_0x01cb:
            r12 = r131
        L_0x01cd:
            r12 = r9 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x01d6
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r13 = r132
            goto L_0x01ea
        L_0x01d6:
            r13 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x01e8
            r13 = r132
            boolean r16 = r8.changedInstance(r13)
            if (r16 == 0) goto L_0x01e3
            goto L_0x01e5
        L_0x01e3:
            r18 = r19
        L_0x01e5:
            r1 = r1 | r18
            goto L_0x01ea
        L_0x01e8:
            r13 = r132
        L_0x01ea:
            r16 = r10 & r110
            if (r16 != 0) goto L_0x0202
            r13 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r13 != 0) goto L_0x01fd
            r13 = r133
            boolean r16 = r8.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x01ff
            r20 = r21
            goto L_0x01ff
        L_0x01fd:
            r13 = r133
        L_0x01ff:
            r1 = r1 | r20
            goto L_0x0204
        L_0x0202:
            r13 = r133
        L_0x0204:
            r16 = r10 & r111
            if (r16 != 0) goto L_0x0221
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r9 & r16
            if (r16 != 0) goto L_0x021a
            r13 = r134
            boolean r16 = r8.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x021c
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x021e
        L_0x021a:
            r13 = r134
        L_0x021c:
            r16 = r112
        L_0x021e:
            r1 = r1 | r16
            goto L_0x0223
        L_0x0221:
            r13 = r134
        L_0x0223:
            r16 = r10 & r113
            if (r16 != 0) goto L_0x023d
            r16 = r9 & r112
            if (r16 != 0) goto L_0x0236
            r13 = r135
            boolean r16 = r8.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x0238
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x023a
        L_0x0236:
            r13 = r135
        L_0x0238:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x023a:
            r1 = r1 | r16
            goto L_0x023f
        L_0x023d:
            r13 = r135
        L_0x023f:
            r16 = 131072(0x20000, float:1.83671E-40)
            r116 = r9 & r16
            if (r116 == 0) goto L_0x024c
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r16
            r13 = r136
            goto L_0x0262
        L_0x024c:
            r16 = r10 & r114
            if (r16 != 0) goto L_0x0260
            r13 = r136
            boolean r16 = r8.changedInstance(r13)
            if (r16 == 0) goto L_0x025b
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x025d
        L_0x025b:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x025d:
            r1 = r1 | r16
            goto L_0x0262
        L_0x0260:
            r13 = r136
        L_0x0262:
            r16 = 262144(0x40000, float:3.67342E-40)
            r16 = r9 & r16
            if (r16 == 0) goto L_0x026f
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r16
            r15 = r118
            goto L_0x0285
        L_0x026f:
            r16 = r10 & r115
            if (r16 != 0) goto L_0x0283
            r15 = r118
            boolean r16 = r8.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x027e
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0280
        L_0x027e:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0280:
            r1 = r1 | r16
            goto L_0x0285
        L_0x0283:
            r15 = r118
        L_0x0285:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r10 = r0 & r16
            r13 = 306783378(0x12492492, float:6.3469493E-28)
            if (r10 != r13) goto L_0x02c2
            r10 = 191739611(0xb6db6db, float:4.5782105E-32)
            r10 = r10 & r1
            r13 = 38347922(0x2492492, float:1.4777643E-37)
            if (r10 != r13) goto L_0x02c2
            boolean r10 = r8.getSkipping()
            if (r10 != 0) goto L_0x029f
            goto L_0x02c2
        L_0x029f:
            r8.skipToGroupEnd()
            r23 = r125
            r24 = r126
            r25 = r127
            r26 = r128
            r27 = r129
            r28 = r130
            r29 = r131
            r30 = r132
            r31 = r133
            r32 = r134
            r33 = r135
            r34 = r136
            r35 = r0
            r37 = r1
            r36 = r8
            goto L_0x0513
        L_0x02c2:
            r8.startDefaults()
            r10 = r11 & 1
            if (r10 == 0) goto L_0x0308
            boolean r10 = r8.getDefaultsInvalid()
            if (r10 == 0) goto L_0x02d0
            goto L_0x0308
        L_0x02d0:
            r8.skipToGroupEnd()
            r2 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x02db
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r2
        L_0x02db:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r9
            if (r2 == 0) goto L_0x02e5
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r2
        L_0x02e5:
            r2 = r9 & r112
            if (r2 == 0) goto L_0x02ed
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r2
        L_0x02ed:
            r23 = r125
            r24 = r126
            r25 = r127
            r26 = r128
            r27 = r129
            r28 = r130
            r29 = r131
            r30 = r132
            r31 = r133
            r32 = r134
            r33 = r135
            r34 = r136
            r13 = r1
            goto L_0x047b
        L_0x0308:
            if (r17 == 0) goto L_0x030c
            r10 = 0
            goto L_0x030e
        L_0x030c:
            r10 = r125
        L_0x030e:
            if (r5 == 0) goto L_0x0312
            r5 = 0
            goto L_0x0314
        L_0x0312:
            r5 = r126
        L_0x0314:
            if (r7 == 0) goto L_0x0318
            r7 = 0
            goto L_0x031a
        L_0x0318:
            r7 = r127
        L_0x031a:
            if (r2 == 0) goto L_0x031e
            r2 = 0
            goto L_0x0320
        L_0x031e:
            r2 = r128
        L_0x0320:
            if (r3 == 0) goto L_0x0324
            r3 = 0
            goto L_0x0326
        L_0x0324:
            r3 = r129
        L_0x0326:
            if (r4 == 0) goto L_0x032a
            r4 = 0
            goto L_0x032c
        L_0x032a:
            r4 = r130
        L_0x032c:
            if (r6 == 0) goto L_0x0330
            r6 = 0
            goto L_0x0332
        L_0x0330:
            r6 = r131
        L_0x0332:
            if (r12 == 0) goto L_0x0336
            r12 = 0
            goto L_0x0338
        L_0x0336:
            r12 = r132
        L_0x0338:
            r13 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r13 == 0) goto L_0x034a
            androidx.compose.material3.TextFieldDefaults r13 = INSTANCE
            r137 = r2
            r2 = 6
            androidx.compose.ui.graphics.Shape r2 = r13.getShape(r8, r2)
            r13 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r13
            goto L_0x034e
        L_0x034a:
            r137 = r2
            r2 = r133
        L_0x034e:
            r13 = 32768(0x8000, float:4.5918E-41)
            r13 = r13 & r9
            if (r13 == 0) goto L_0x03cb
            int r13 = r1 >> 15
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r107 = r13
            r108 = 2147483647(0x7fffffff, float:NaN)
            r109 = 4095(0xfff, float:5.738E-42)
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r38 = 0
            r40 = 0
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r52 = 0
            r54 = 0
            r56 = 0
            r58 = 0
            r60 = 0
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 0
            r70 = 0
            r72 = 0
            r74 = 0
            r76 = 0
            r78 = 0
            r80 = 0
            r82 = 0
            r84 = 0
            r86 = 0
            r88 = 0
            r90 = 0
            r92 = 0
            r94 = 0
            r96 = 0
            r98 = 0
            r100 = 0
            r103 = 0
            r104 = 0
            r105 = 0
            r106 = 0
            r16 = r118
            r102 = r8
            androidx.compose.material3.TextFieldColors r13 = r16.m3827colors0hiis_0(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r88, r90, r92, r94, r96, r98, r100, r102, r103, r104, r105, r106, r107, r108, r109)
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r16
            goto L_0x03cd
        L_0x03cb:
            r13 = r134
        L_0x03cd:
            r16 = r9 & r112
            if (r16 == 0) goto L_0x0417
            if (r5 != 0) goto L_0x03f2
            r16 = 15
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r125 = r118
            r126 = r18
            r127 = r19
            r128 = r20
            r129 = r21
            r130 = r16
            r131 = r17
            androidx.compose.foundation.layout.PaddingValues r16 = m3818contentPaddingWithoutLabela9UjIt4$default(r125, r126, r127, r128, r129, r130, r131)
            goto L_0x0410
        L_0x03f2:
            r16 = 15
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r125 = r118
            r126 = r18
            r127 = r19
            r128 = r20
            r129 = r21
            r130 = r16
            r131 = r17
            androidx.compose.foundation.layout.PaddingValues r16 = m3817contentPaddingWithLabela9UjIt4$default(r125, r126, r127, r128, r129, r130, r131)
        L_0x0410:
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r17
            goto L_0x0419
        L_0x0417:
            r16 = r135
        L_0x0419:
            if (r116 == 0) goto L_0x045b
            r17 = r3
            androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$1 r3 = new androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$1
            r125 = r3
            r126 = r121
            r127 = r10
            r128 = r124
            r129 = r13
            r130 = r2
            r131 = r0
            r132 = r1
            r125.<init>(r126, r127, r128, r129, r130, r131, r132)
            r125 = r1
            r1 = 2023266550(0x789898f6, float:2.476036E34)
            r126 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r1, r2, r3)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r31 = r126
            r26 = r137
            r34 = r1
            r28 = r4
            r24 = r5
            r29 = r6
            r25 = r7
            r23 = r10
            r30 = r12
            r32 = r13
            r33 = r16
            r27 = r17
            r13 = r125
            goto L_0x047b
        L_0x045b:
            r125 = r1
            r126 = r2
            r17 = r3
            r31 = r126
            r34 = r136
            r26 = r137
            r28 = r4
            r24 = r5
            r29 = r6
            r25 = r7
            r23 = r10
            r30 = r12
            r32 = r13
            r33 = r16
            r27 = r17
            r13 = r125
        L_0x047b:
            r8.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x048c
            r1 = -1042273141(0xffffffffc1e02c8b, float:-28.02175)
            java.lang.String r2 = "androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:943)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r0, r13, r2)
        L_0x048c:
            r1 = r0 & 14
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = r0 & r110
            r1 = r1 | r2
            r2 = r0 & r111
            r1 = r1 | r2
            r2 = r0 & r113
            r1 = r1 | r2
            r2 = r0 & r114
            r1 = r1 | r2
            r2 = r0 & r115
            r1 = r1 | r2
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r0
            r20 = r1 | r2
            r1 = r13 & 14
            r2 = r13 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r13 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r13 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = r13 & r110
            r1 = r1 | r2
            r2 = r13 & r111
            r1 = r1 | r2
            r2 = r13 & r113
            r1 = r1 | r2
            r2 = r13 & r114
            r1 = r1 | r2
            r2 = r13 & r115
            r21 = r1 | r2
            r22 = 0
            r35 = r0
            r0 = r118
            r1 = r119
            r2 = r120
            r3 = r121
            r4 = r122
            r5 = r123
            r6 = r124
            r7 = r23
            r36 = r8
            r8 = r24
            r9 = r25
            r10 = r26
            r11 = r27
            r12 = r28
            r37 = r13
            r13 = r29
            r14 = r30
            r15 = r31
            r16 = r32
            r17 = r33
            r18 = r34
            r19 = r36
            r0.DecorationBox(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0513
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0513:
            androidx.compose.runtime.ScopeUpdateScope r15 = r36.endRestartGroup()
            if (r15 != 0) goto L_0x051a
            goto L_0x0558
        L_0x051a:
            androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$2 r38 = new androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$2
            r0 = r38
            r1 = r118
            r2 = r119
            r3 = r120
            r4 = r121
            r5 = r122
            r6 = r123
            r7 = r124
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r26
            r12 = r27
            r13 = r28
            r14 = r29
            r117 = r15
            r15 = r30
            r16 = r31
            r17 = r32
            r18 = r33
            r19 = r34
            r20 = r138
            r21 = r139
            r22 = r140
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r38
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r117
            r1.updateScope(r0)
        L_0x0558:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x049e  */
    /* JADX WARNING: Removed duplicated region for block: B:243:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x015a  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.DecorationBox`", replaceWith = @kotlin.ReplaceWith(expression = "OutlinedTextFieldDefaults.DecorationBox(\n        value = value,\n        innerTextField = innerTextField,\n        enabled = enabled,\n        singleLine = singleLine,\n        visualTransformation = visualTransformation,\n        interactionSource = interactionSource,\n        isError = isError,\n        label = label,\n        placeholder = placeholder,\n        leadingIcon = leadingIcon,\n        trailingIcon = trailingIcon,\n        prefix = prefix,\n        suffix = suffix,\n        supportingText = supportingText,\n        colors = colors,\n        contentPadding = contentPadding,\n        container = container,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void OutlinedTextFieldDecorationBox(java.lang.String r117, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r118, boolean r119, boolean r120, androidx.compose.ui.text.input.VisualTransformation r121, androidx.compose.foundation.interaction.InteractionSource r122, boolean r123, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r124, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, androidx.compose.material3.TextFieldColors r131, androidx.compose.foundation.layout.PaddingValues r132, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r133, androidx.compose.runtime.Composer r134, int r135, int r136, int r137) {
        /*
            r116 = this;
            r15 = r117
            r14 = r118
            r13 = r121
            r12 = r122
            r11 = r135
            r10 = r136
            r9 = r137
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "innerTextField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -789275592(0xffffffffd0f49c38, float:-3.28310292E10)
            r1 = r134
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(OutlinedTextFieldDecorationBox)P(15,4,3,11,16,5,6,7,9,8,14,10,12,13!1,2)1031@56982L8,1036@57262L589:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r135
            r2 = r136
            r3 = r9 & 1
            if (r3 == 0) goto L_0x003f
            r1 = r1 | 6
            goto L_0x004d
        L_0x003f:
            r3 = r11 & 14
            if (r3 != 0) goto L_0x004d
            boolean r3 = r8.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x004b
            r3 = 4
            goto L_0x004c
        L_0x004b:
            r3 = 2
        L_0x004c:
            r1 = r1 | r3
        L_0x004d:
            r3 = r9 & 2
            if (r3 == 0) goto L_0x0054
            r1 = r1 | 48
            goto L_0x0064
        L_0x0054:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0064
            boolean r3 = r8.changedInstance(r14)
            if (r3 == 0) goto L_0x0061
            r3 = 32
            goto L_0x0063
        L_0x0061:
            r3 = 16
        L_0x0063:
            r1 = r1 | r3
        L_0x0064:
            r3 = r9 & 4
            r16 = 256(0x100, float:3.59E-43)
            r17 = 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0071
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r119
            goto L_0x0087
        L_0x0071:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0085
            r3 = r119
            boolean r18 = r8.changed((boolean) r3)
            if (r18 == 0) goto L_0x0080
            r18 = r16
            goto L_0x0082
        L_0x0080:
            r18 = r17
        L_0x0082:
            r1 = r1 | r18
            goto L_0x0087
        L_0x0085:
            r3 = r119
        L_0x0087:
            r18 = r9 & 8
            r19 = 2048(0x800, float:2.87E-42)
            r20 = 1024(0x400, float:1.435E-42)
            if (r18 == 0) goto L_0x0094
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r4 = r120
            goto L_0x00aa
        L_0x0094:
            r4 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x00a8
            r4 = r120
            boolean r18 = r8.changed((boolean) r4)
            if (r18 == 0) goto L_0x00a3
            r18 = r19
            goto L_0x00a5
        L_0x00a3:
            r18 = r20
        L_0x00a5:
            r1 = r1 | r18
            goto L_0x00aa
        L_0x00a8:
            r4 = r120
        L_0x00aa:
            r18 = r9 & 16
            r21 = 8192(0x2000, float:1.14794E-41)
            r110 = 57344(0xe000, float:8.0356E-41)
            r22 = 16384(0x4000, float:2.2959E-41)
            if (r18 == 0) goto L_0x00b8
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00c9
        L_0x00b8:
            r18 = r11 & r110
            if (r18 != 0) goto L_0x00c9
            boolean r18 = r8.changed((java.lang.Object) r13)
            if (r18 == 0) goto L_0x00c5
            r18 = r22
            goto L_0x00c7
        L_0x00c5:
            r18 = r21
        L_0x00c7:
            r1 = r1 | r18
        L_0x00c9:
            r18 = r9 & 32
            r23 = 65536(0x10000, float:9.18355E-41)
            r111 = 458752(0x70000, float:6.42848E-40)
            if (r18 == 0) goto L_0x00d6
            r18 = 196608(0x30000, float:2.75506E-40)
        L_0x00d3:
            r1 = r1 | r18
            goto L_0x00e6
        L_0x00d6:
            r18 = r11 & r111
            if (r18 != 0) goto L_0x00e6
            boolean r18 = r8.changed((java.lang.Object) r12)
            if (r18 == 0) goto L_0x00e3
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d3
        L_0x00e3:
            r18 = r23
            goto L_0x00d3
        L_0x00e6:
            r18 = r9 & 64
            r112 = 3670016(0x380000, float:5.142788E-39)
            if (r18 == 0) goto L_0x00f3
            r24 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r24
            r5 = r123
            goto L_0x0109
        L_0x00f3:
            r24 = r11 & r112
            if (r24 != 0) goto L_0x0107
            r5 = r123
            boolean r25 = r8.changed((boolean) r5)
            if (r25 == 0) goto L_0x0102
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0104
        L_0x0102:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x0104:
            r1 = r1 | r25
            goto L_0x0109
        L_0x0107:
            r5 = r123
        L_0x0109:
            r6 = r9 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x0114
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r26
            r7 = r124
            goto L_0x012c
        L_0x0114:
            r26 = 29360128(0x1c00000, float:7.052966E-38)
            r26 = r11 & r26
            if (r26 != 0) goto L_0x012a
            r7 = r124
            boolean r27 = r8.changedInstance(r7)
            if (r27 == 0) goto L_0x0125
            r27 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0127
        L_0x0125:
            r27 = 4194304(0x400000, float:5.877472E-39)
        L_0x0127:
            r1 = r1 | r27
            goto L_0x012c
        L_0x012a:
            r7 = r124
        L_0x012c:
            r0 = r9 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0137
            r27 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r27
            r3 = r125
            goto L_0x014f
        L_0x0137:
            r27 = 234881024(0xe000000, float:1.5777218E-30)
            r27 = r11 & r27
            if (r27 != 0) goto L_0x014d
            r3 = r125
            boolean r27 = r8.changedInstance(r3)
            if (r27 == 0) goto L_0x0148
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x014a
        L_0x0148:
            r27 = 33554432(0x2000000, float:9.403955E-38)
        L_0x014a:
            r1 = r1 | r27
            goto L_0x014f
        L_0x014d:
            r3 = r125
        L_0x014f:
            r3 = r9 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x015a
            r27 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r27
            r4 = r126
            goto L_0x0172
        L_0x015a:
            r27 = 1879048192(0x70000000, float:1.58456325E29)
            r27 = r11 & r27
            if (r27 != 0) goto L_0x0170
            r4 = r126
            boolean r27 = r8.changedInstance(r4)
            if (r27 == 0) goto L_0x016b
            r27 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x016d
        L_0x016b:
            r27 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x016d:
            r1 = r1 | r27
            goto L_0x0172
        L_0x0170:
            r4 = r126
        L_0x0172:
            r4 = r9 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x017b
            r2 = r2 | 6
            r5 = r127
            goto L_0x0191
        L_0x017b:
            r27 = r10 & 14
            if (r27 != 0) goto L_0x018f
            r5 = r127
            boolean r27 = r8.changedInstance(r5)
            if (r27 == 0) goto L_0x018a
            r24 = 4
            goto L_0x018c
        L_0x018a:
            r24 = 2
        L_0x018c:
            r2 = r2 | r24
            goto L_0x0191
        L_0x018f:
            r5 = r127
        L_0x0191:
            r5 = r9 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x019a
            r2 = r2 | 48
            r7 = r128
            goto L_0x01b0
        L_0x019a:
            r24 = r10 & 112(0x70, float:1.57E-43)
            if (r24 != 0) goto L_0x01ae
            r7 = r128
            boolean r24 = r8.changedInstance(r7)
            if (r24 == 0) goto L_0x01a9
            r26 = 32
            goto L_0x01ab
        L_0x01a9:
            r26 = 16
        L_0x01ab:
            r2 = r2 | r26
            goto L_0x01b0
        L_0x01ae:
            r7 = r128
        L_0x01b0:
            r7 = r9 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x01b9
            r2 = r2 | 384(0x180, float:5.38E-43)
            r12 = r129
            goto L_0x01cd
        L_0x01b9:
            r12 = r10 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x01cb
            r12 = r129
            boolean r24 = r8.changedInstance(r12)
            if (r24 == 0) goto L_0x01c6
            goto L_0x01c8
        L_0x01c6:
            r16 = r17
        L_0x01c8:
            r2 = r2 | r16
            goto L_0x01cd
        L_0x01cb:
            r12 = r129
        L_0x01cd:
            r12 = r9 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x01d6
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r13 = r130
            goto L_0x01ea
        L_0x01d6:
            r13 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x01e8
            r13 = r130
            boolean r16 = r8.changedInstance(r13)
            if (r16 == 0) goto L_0x01e3
            goto L_0x01e5
        L_0x01e3:
            r19 = r20
        L_0x01e5:
            r2 = r2 | r19
            goto L_0x01ea
        L_0x01e8:
            r13 = r130
        L_0x01ea:
            r16 = r10 & r110
            if (r16 != 0) goto L_0x0202
            r13 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r13 != 0) goto L_0x01fd
            r13 = r131
            boolean r16 = r8.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x01ff
            r21 = r22
            goto L_0x01ff
        L_0x01fd:
            r13 = r131
        L_0x01ff:
            r2 = r2 | r21
            goto L_0x0204
        L_0x0202:
            r13 = r131
        L_0x0204:
            r16 = r10 & r111
            r113 = 32768(0x8000, float:4.5918E-41)
            if (r16 != 0) goto L_0x0221
            r16 = r9 & r113
            if (r16 != 0) goto L_0x021a
            r13 = r132
            boolean r16 = r8.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x021c
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x021e
        L_0x021a:
            r13 = r132
        L_0x021c:
            r16 = r23
        L_0x021e:
            r2 = r2 | r16
            goto L_0x0223
        L_0x0221:
            r13 = r132
        L_0x0223:
            r114 = r9 & r23
            if (r114 == 0) goto L_0x022e
            r16 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r16
            r10 = r133
            goto L_0x0244
        L_0x022e:
            r16 = r10 & r112
            if (r16 != 0) goto L_0x0242
            r10 = r133
            boolean r16 = r8.changedInstance(r10)
            if (r16 == 0) goto L_0x023d
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x023f
        L_0x023d:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x023f:
            r2 = r2 | r16
            goto L_0x0244
        L_0x0242:
            r10 = r133
        L_0x0244:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r10 = r1 & r16
            r13 = 306783378(0x12492492, float:6.3469493E-28)
            if (r10 != r13) goto L_0x027f
            r10 = 2995931(0x2db6db, float:4.198194E-39)
            r10 = r10 & r2
            r13 = 599186(0x92492, float:8.39638E-40)
            if (r10 != r13) goto L_0x027f
            boolean r10 = r8.getSkipping()
            if (r10 != 0) goto L_0x025e
            goto L_0x027f
        L_0x025e:
            r8.skipToGroupEnd()
            r22 = r123
            r23 = r124
            r24 = r125
            r25 = r126
            r26 = r127
            r27 = r128
            r28 = r129
            r29 = r130
            r30 = r131
            r31 = r132
            r32 = r133
            r33 = r1
            r35 = r2
            r34 = r8
            goto L_0x0497
        L_0x027f:
            r8.startDefaults()
            r10 = r11 & 1
            if (r10 == 0) goto L_0x02d2
            boolean r10 = r8.getDefaultsInvalid()
            if (r10 == 0) goto L_0x028d
            goto L_0x02d2
        L_0x028d:
            r8.skipToGroupEnd()
            r0 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0298
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = r2 & r0
        L_0x0298:
            r0 = r9 & r113
            if (r0 == 0) goto L_0x02b9
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r2
            r22 = r123
            r23 = r124
            r24 = r125
            r25 = r126
            r26 = r127
            r27 = r128
            r28 = r129
            r29 = r130
            r30 = r131
            r31 = r132
            r32 = r133
            r13 = r0
            goto L_0x0403
        L_0x02b9:
            r22 = r123
            r23 = r124
            r24 = r125
            r25 = r126
            r26 = r127
            r27 = r128
            r28 = r129
            r29 = r130
            r30 = r131
            r31 = r132
            r32 = r133
            r13 = r2
            goto L_0x0403
        L_0x02d2:
            if (r18 == 0) goto L_0x02d6
            r10 = 0
            goto L_0x02d8
        L_0x02d6:
            r10 = r123
        L_0x02d8:
            if (r6 == 0) goto L_0x02dc
            r6 = 0
            goto L_0x02de
        L_0x02dc:
            r6 = r124
        L_0x02de:
            if (r0 == 0) goto L_0x02e2
            r0 = 0
            goto L_0x02e4
        L_0x02e2:
            r0 = r125
        L_0x02e4:
            if (r3 == 0) goto L_0x02e8
            r3 = 0
            goto L_0x02ea
        L_0x02e8:
            r3 = r126
        L_0x02ea:
            if (r4 == 0) goto L_0x02ee
            r4 = 0
            goto L_0x02f0
        L_0x02ee:
            r4 = r127
        L_0x02f0:
            if (r5 == 0) goto L_0x02f4
            r5 = 0
            goto L_0x02f6
        L_0x02f4:
            r5 = r128
        L_0x02f6:
            if (r7 == 0) goto L_0x02fa
            r7 = 0
            goto L_0x02fc
        L_0x02fa:
            r7 = r129
        L_0x02fc:
            if (r12 == 0) goto L_0x0300
            r12 = 0
            goto L_0x0302
        L_0x0300:
            r12 = r130
        L_0x0302:
            r13 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r13 == 0) goto L_0x0379
            androidx.compose.material3.OutlinedTextFieldDefaults r16 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r108 = 2147483647(0x7fffffff, float:NaN)
            r109 = 4095(0xfff, float:5.738E-42)
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r38 = 0
            r40 = 0
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r52 = 0
            r54 = 0
            r56 = 0
            r58 = 0
            r60 = 0
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 0
            r70 = 0
            r72 = 0
            r74 = 0
            r76 = 0
            r78 = 0
            r80 = 0
            r82 = 0
            r84 = 0
            r86 = 0
            r88 = 0
            r90 = 0
            r92 = 0
            r94 = 0
            r96 = 0
            r98 = 0
            r100 = 0
            r103 = 0
            r104 = 0
            r105 = 0
            r106 = 0
            r107 = 3072(0xc00, float:4.305E-42)
            r102 = r8
            androidx.compose.material3.TextFieldColors r13 = r16.m3604colors0hiis_0(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r88, r90, r92, r94, r96, r98, r100, r102, r103, r104, r105, r106, r107, r108, r109)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = r2 & r16
            goto L_0x037b
        L_0x0379:
            r13 = r131
        L_0x037b:
            r16 = r9 & r113
            if (r16 == 0) goto L_0x03a5
            androidx.compose.material3.OutlinedTextFieldDefaults r16 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r17 = 15
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r123 = r16
            r124 = r19
            r125 = r20
            r126 = r21
            r127 = r22
            r128 = r17
            r129 = r18
            androidx.compose.foundation.layout.PaddingValues r16 = androidx.compose.material3.OutlinedTextFieldDefaults.m3602contentPaddinga9UjIt4$default(r123, r124, r125, r126, r127, r128, r129)
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r2 = r2 & r17
            goto L_0x03a7
        L_0x03a5:
            r16 = r132
        L_0x03a7:
            if (r114 == 0) goto L_0x03e5
            r134 = r0
            androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$1 r0 = new androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$1
            r123 = r0
            r124 = r119
            r125 = r10
            r126 = r122
            r127 = r13
            r128 = r1
            r129 = r2
            r123.<init>(r124, r125, r126, r127, r128, r129)
            r123 = r2
            r2 = -1153197597(0xffffffffbb4399e3, float:-0.0029846362)
            r124 = r3
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r2, r3, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r25 = r124
            r24 = r134
            r32 = r0
            r26 = r4
            r27 = r5
            r23 = r6
            r28 = r7
            r22 = r10
            r29 = r12
            r30 = r13
            r31 = r16
            r13 = r123
            goto L_0x0403
        L_0x03e5:
            r134 = r0
            r123 = r2
            r124 = r3
            r25 = r124
            r32 = r133
            r24 = r134
            r26 = r4
            r27 = r5
            r23 = r6
            r28 = r7
            r22 = r10
            r29 = r12
            r30 = r13
            r31 = r16
            r13 = r123
        L_0x0403:
            r8.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0414
            java.lang.String r0 = "androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:1016)"
            r2 = -789275592(0xffffffffd0f49c38, float:-3.28310292E10)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r13, r0)
        L_0x0414:
            androidx.compose.material3.OutlinedTextFieldDefaults r0 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r2 = r1 & 14
            r3 = r1 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = r1 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r3 = r1 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            r3 = r1 & r110
            r2 = r2 | r3
            r3 = r1 & r111
            r2 = r2 | r3
            r3 = r1 & r112
            r2 = r2 | r3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r1
            r2 = r2 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r1
            r2 = r2 | r3
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r1
            r19 = r2 | r3
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r13 & 14
            r2 = r2 | r3
            r3 = r13 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = r13 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r3 = r13 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            r3 = r13 & r110
            r2 = r2 | r3
            r3 = r13 & r111
            r2 = r2 | r3
            r3 = r13 & r112
            r20 = r2 | r3
            r21 = 0
            r33 = r1
            r1 = r117
            r2 = r118
            r3 = r119
            r4 = r120
            r5 = r121
            r6 = r122
            r7 = r22
            r34 = r8
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r26
            r12 = r27
            r35 = r13
            r13 = r28
            r14 = r29
            r15 = r30
            r16 = r31
            r17 = r32
            r18 = r34
            r0.DecorationBox(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0497
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0497:
            androidx.compose.runtime.ScopeUpdateScope r15 = r34.endRestartGroup()
            if (r15 != 0) goto L_0x049e
            goto L_0x04da
        L_0x049e:
            androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$2 r36 = new androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$2
            r0 = r36
            r1 = r116
            r2 = r117
            r3 = r118
            r4 = r119
            r5 = r120
            r6 = r121
            r7 = r122
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r12 = r26
            r13 = r27
            r14 = r28
            r115 = r15
            r15 = r29
            r16 = r30
            r17 = r31
            r18 = r32
            r19 = r135
            r20 = r136
            r21 = r137
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r0 = r36
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r115
            r1.updateScope(r0)
        L_0x04da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v107, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: textFieldColors-eS1Emto  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ androidx.compose.material3.TextFieldColors m3842textFieldColorseS1Emto(long r166, long r168, long r170, long r172, long r174, androidx.compose.foundation.text.selection.TextSelectionColors r176, long r177, long r179, long r181, long r183, long r185, long r187, long r189, long r191, long r193, long r195, long r197, long r199, long r201, long r203, long r205, long r207, long r209, long r211, long r213, long r215, long r217, long r219, long r221, long r223, long r225, long r227, long r229, long r231, long r233, long r235, androidx.compose.runtime.Composer r237, int r238, int r239, int r240, int r241, int r242, int r243) {
        /*
            r165 = this;
            r15 = r237
            r13 = r238
            r14 = r239
            r0 = r242
            r1 = -595874869(0xffffffffdc7babcb, float:-2.8335643E17)
            r15.startReplaceableGroup(r1)
            java.lang.String r2 = "C(textFieldColors)P(28:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,27,19:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,21:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,10:c#ui.graphics.Color,18:c#ui.graphics.Color,20:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,26:c#ui.graphics.Color,5:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,8:c#ui.graphics.Color,17:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,6:c#ui.graphics.Color,15:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,7:c#ui.graphics.Color,16:c#ui.graphics.Color)1060@58072L9,1061@58159L9,1063@58309L9,1064@58382L9,1065@58470L9,1066@58553L7,1067@58649L9,1068@58744L9,1069@58846L9,1071@59022L9,1072@59118L9,1073@59211L9,1074@59311L9,1076@59481L9,1077@59579L9,1078@59674L9,1079@59776L9,1081@59949L9,1082@60033L9,1083@60114L9,1084@60202L9,1086@60354L9,1087@60443L9,1088@60537L9,1090@60705L9,1091@60800L9,1092@60902L9,1094@61073L9,1095@61159L9,1096@61247L9,1097@61334L9,1099@61488L9,1100@61574L9,1101@61662L9,1102@61749L9,1104@61903L9,1105@61939L2261:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r0 & 1
            r3 = 6
            if (r2 == 0) goto L_0x0025
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getInputColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r94 = r4
            goto L_0x0027
        L_0x0025:
            r94 = r166
        L_0x0027:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0046
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledInputColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r10 = 14
            r11 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r4, r6, r7, r8, r9, r10, r11)
            r96 = r4
            goto L_0x0048
        L_0x0046:
            r96 = r168
        L_0x0048:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0059
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getContainerColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r98 = r4
            goto L_0x005b
        L_0x0059:
            r98 = r170
        L_0x005b:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x006c
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r100 = r4
            goto L_0x006e
        L_0x006c:
            r100 = r172
        L_0x006e:
            r2 = r0 & 16
            if (r2 == 0) goto L_0x007f
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getErrorFocusCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r102 = r4
            goto L_0x0081
        L_0x007f:
            r102 = r174
        L_0x0081:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x00a2
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r5 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r6, r7)
            java.lang.Object r6 = r15.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r237)
            r2 = r6
            androidx.compose.foundation.text.selection.TextSelectionColors r2 = (androidx.compose.foundation.text.selection.TextSelectionColors) r2
            r104 = r2
            goto L_0x00a4
        L_0x00a2:
            r104 = r176
        L_0x00a4:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x00b5
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFocusActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r105 = r4
            goto L_0x00b7
        L_0x00b5:
            r105 = r177
        L_0x00b7:
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00c8
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r107 = r4
            goto L_0x00ca
        L_0x00c8:
            r107 = r179
        L_0x00ca:
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x00f7
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r166 = r4
            r168 = r7
            r169 = r8
            r170 = r9
            r171 = r10
            r172 = r2
            r173 = r6
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r109 = r4
            goto L_0x00f9
        L_0x00f7:
            r109 = r181
        L_0x00f9:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x010a
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getErrorActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r111 = r4
            goto L_0x010c
        L_0x010a:
            r111 = r183
        L_0x010c:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x011d
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFocusLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r113 = r4
            goto L_0x011f
        L_0x011d:
            r113 = r185
        L_0x011f:
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0130
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r115 = r4
            goto L_0x0132
        L_0x0130:
            r115 = r187
        L_0x0132:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x015f
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r166 = r4
            r168 = r7
            r169 = r8
            r170 = r9
            r171 = r10
            r172 = r2
            r173 = r6
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r117 = r4
            goto L_0x0161
        L_0x015f:
            r117 = r189
        L_0x0161:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0172
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getErrorLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r119 = r4
            goto L_0x0174
        L_0x0172:
            r119 = r191
        L_0x0174:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0185
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFocusTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r121 = r4
            goto L_0x0187
        L_0x0185:
            r121 = r193
        L_0x0187:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x019a
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r123 = r4
            goto L_0x019c
        L_0x019a:
            r123 = r195
        L_0x019c:
            r2 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01ca
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r166 = r4
            r168 = r7
            r169 = r8
            r170 = r9
            r171 = r10
            r172 = r2
            r173 = r6
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r125 = r4
            goto L_0x01cc
        L_0x01ca:
            r125 = r197
        L_0x01cc:
            r2 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01de
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getErrorTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r127 = r4
            goto L_0x01e0
        L_0x01de:
            r127 = r199
        L_0x01e0:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01f2
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFocusLabelColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r129 = r4
            goto L_0x01f4
        L_0x01f2:
            r129 = r201
        L_0x01f4:
            r2 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0206
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getLabelColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r131 = r4
            goto L_0x0208
        L_0x0206:
            r131 = r203
        L_0x0208:
            r2 = 1048576(0x100000, float:1.469368E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0236
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledLabelColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r166 = r4
            r168 = r7
            r169 = r8
            r170 = r9
            r171 = r10
            r172 = r2
            r173 = r6
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r133 = r4
            goto L_0x0238
        L_0x0236:
            r133 = r205
        L_0x0238:
            r2 = 2097152(0x200000, float:2.938736E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x024a
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getErrorLabelColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r135 = r4
            goto L_0x024c
        L_0x024a:
            r135 = r207
        L_0x024c:
            r2 = 4194304(0x400000, float:5.877472E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x025e
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getInputPlaceholderColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r137 = r4
            goto L_0x0260
        L_0x025e:
            r137 = r209
        L_0x0260:
            r2 = 8388608(0x800000, float:1.17549435E-38)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x028e
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledInputColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r166 = r4
            r168 = r7
            r169 = r8
            r170 = r9
            r171 = r10
            r172 = r2
            r173 = r6
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r139 = r4
            goto L_0x0290
        L_0x028e:
            r139 = r211
        L_0x0290:
            r2 = 16777216(0x1000000, float:2.3509887E-38)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x02a2
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFocusSupportingColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r141 = r4
            goto L_0x02a4
        L_0x02a2:
            r141 = r213
        L_0x02a4:
            r2 = 33554432(0x2000000, float:9.403955E-38)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x02b6
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getSupportingColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r143 = r4
            goto L_0x02b8
        L_0x02b6:
            r143 = r215
        L_0x02b8:
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x02e6
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledSupportingColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r166 = r4
            r168 = r7
            r169 = r8
            r170 = r9
            r171 = r10
            r172 = r2
            r173 = r6
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r145 = r4
            goto L_0x02e8
        L_0x02e6:
            r145 = r217
        L_0x02e8:
            r2 = 134217728(0x8000000, float:3.85186E-34)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x02fa
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getErrorSupportingColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r147 = r4
            goto L_0x02fc
        L_0x02fa:
            r147 = r219
        L_0x02fc:
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x030e
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getInputPrefixColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r149 = r4
            goto L_0x0310
        L_0x030e:
            r149 = r221
        L_0x0310:
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0322
            androidx.compose.material3.tokens.FilledTextFieldTokens r2 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getInputPrefixColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r151 = r4
            goto L_0x0324
        L_0x0322:
            r151 = r223
        L_0x0324:
            r2 = 1073741824(0x40000000, float:2.0)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0352
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputPrefixColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r0 = 14
            r2 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            r166 = r4
            r168 = r6
            r169 = r7
            r170 = r8
            r171 = r9
            r172 = r0
            r173 = r2
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r153 = r4
            goto L_0x0354
        L_0x0352:
            r153 = r225
        L_0x0354:
            r0 = r243 & 1
            if (r0 == 0) goto L_0x0365
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputPrefixColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r155 = r4
            goto L_0x0367
        L_0x0365:
            r155 = r227
        L_0x0367:
            r0 = r243 & 2
            if (r0 == 0) goto L_0x0378
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r157 = r4
            goto L_0x037a
        L_0x0378:
            r157 = r229
        L_0x037a:
            r0 = r243 & 4
            if (r0 == 0) goto L_0x038b
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r159 = r4
            goto L_0x038d
        L_0x038b:
            r159 = r231
        L_0x038d:
            r0 = r243 & 8
            if (r0 == 0) goto L_0x03ba
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r0 = 14
            r2 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            r166 = r4
            r168 = r6
            r169 = r7
            r170 = r8
            r171 = r9
            r172 = r0
            r173 = r2
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r161 = r4
            goto L_0x03bc
        L_0x03ba:
            r161 = r233
        L_0x03bc:
            r0 = r243 & 16
            if (r0 == 0) goto L_0x03cd
            androidx.compose.material3.tokens.FilledTextFieldTokens r0 = androidx.compose.material3.tokens.FilledTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r2 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r163 = r2
            goto L_0x03cf
        L_0x03cd:
            r163 = r235
        L_0x03cf:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03da
            java.lang.String r0 = "androidx.compose.material3.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:1059)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r13, r14, r0)
        L_0x03da:
            r0 = r13 & 14
            int r1 = r13 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r13 << 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r13 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r13 << 6
            r2 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r13 << 9
            r3 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r13 << 12
            r4 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r13 << 15
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r5
            r0 = r0 | r1
            int r1 = r13 << 15
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r6
            r0 = r0 | r1
            int r1 = r13 << 15
            r7 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r7
            r87 = r0 | r1
            int r0 = r13 >> 15
            r0 = r0 & 14
            int r1 = r13 >> 15
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r13 >> 15
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r13 >> 15
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r13 >> 15
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r14 << 15
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r14 << 15
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r14 << 15
            r1 = r1 & r5
            r0 = r0 | r1
            int r1 = r14 << 15
            r1 = r1 & r6
            r0 = r0 | r1
            int r1 = r14 << 15
            r1 = r1 & r7
            r88 = r0 | r1
            int r0 = r14 >> 15
            r0 = r0 & 14
            int r1 = r14 >> 15
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r14 >> 15
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r14 >> 15
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r14 >> 15
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r240 << 15
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r240 << 15
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r240 << 15
            r1 = r1 & r5
            r0 = r0 | r1
            int r1 = r240 << 18
            r1 = r1 & r6
            r0 = r0 | r1
            int r1 = r240 << 18
            r1 = r1 & r7
            r89 = r0 | r1
            int r0 = r240 >> 6
            r0 = r0 & 14
            int r1 = r240 >> 9
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r240 >> 9
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r240 >> 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r240 >> 9
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r240 >> 9
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r240 >> 9
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r241 << 21
            r1 = r1 & r5
            r0 = r0 | r1
            int r1 = r241 << 21
            r1 = r1 & r6
            r0 = r0 | r1
            int r1 = r241 << 21
            r1 = r1 & r7
            r90 = r0 | r1
            int r0 = r241 >> 9
            r0 = r0 & 14
            int r1 = r241 >> 9
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r241 >> 9
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r241 >> 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r91 = r0 | r1
            r92 = 0
            r93 = 0
            r0 = r165
            r1 = r94
            r3 = r94
            r5 = r96
            r7 = r94
            r9 = r98
            r11 = r98
            r13 = r98
            r15 = r98
            r17 = r100
            r19 = r102
            r21 = r104
            r22 = r105
            r24 = r107
            r26 = r109
            r28 = r111
            r30 = r113
            r32 = r115
            r34 = r117
            r36 = r119
            r38 = r121
            r40 = r123
            r42 = r125
            r44 = r127
            r46 = r129
            r48 = r131
            r50 = r133
            r52 = r135
            r54 = r137
            r56 = r137
            r58 = r139
            r60 = r137
            r62 = r141
            r64 = r143
            r66 = r145
            r68 = r147
            r70 = r149
            r72 = r151
            r74 = r153
            r76 = r155
            r78 = r157
            r80 = r159
            r82 = r161
            r84 = r163
            r86 = r237
            androidx.compose.material3.TextFieldColors r0 = r0.m3827colors0hiis_0(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r87, r88, r89, r90, r91, r92, r93)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x053e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x053e:
            r237.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.m3842textFieldColorseS1Emto(long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v182, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: outlinedTextFieldColors-eS1Emto  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ androidx.compose.material3.TextFieldColors m3838outlinedTextFieldColorseS1Emto(long r166, long r168, long r170, long r172, long r174, androidx.compose.foundation.text.selection.TextSelectionColors r176, long r177, long r179, long r181, long r183, long r185, long r187, long r189, long r191, long r193, long r195, long r197, long r199, long r201, long r203, long r205, long r207, long r209, long r211, long r213, long r215, long r217, long r219, long r221, long r223, long r225, long r227, long r229, long r231, long r233, long r235, androidx.compose.runtime.Composer r237, int r238, int r239, int r240, int r241, int r242, int r243) {
        /*
            r165 = this;
            r15 = r237
            r13 = r238
            r14 = r239
            r0 = r242
            r1 = 1767818445(0x695ec4cd, float:1.6831931E25)
            r15.startReplaceableGroup(r1)
            java.lang.String r2 = "C(outlinedTextFieldColors)P(28:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,27,19:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.graphics.Color,21:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,10:c#ui.graphics.Color,18:c#ui.graphics.Color,20:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,26:c#ui.graphics.Color,5:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,8:c#ui.graphics.Color,17:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,6:c#ui.graphics.Color,15:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,7:c#ui.graphics.Color,16:c#ui.graphics.Color)1155@64431L9,1156@64520L9,1159@64718L9,1160@64808L9,1161@64891L7,1162@64978L9,1163@65064L9,1164@65157L9,1166@65318L9,1167@65416L9,1168@65511L9,1169@65613L9,1171@65787L9,1172@65887L9,1173@65984L9,1175@66101L9,1176@66265L9,1177@66351L9,1178@66434L9,1179@66524L9,1181@66680L9,1182@66771L9,1183@66867L9,1185@67039L9,1186@67136L9,1188@67253L9,1189@67415L9,1190@67503L9,1191@67593L9,1192@67682L9,1194@67840L9,1195@67928L9,1196@68018L9,1197@68107L9,1199@68265L9,1200@68327L2237:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r0 & 1
            r3 = 6
            if (r2 == 0) goto L_0x0025
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getInputColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r94 = r4
            goto L_0x0027
        L_0x0025:
            r94 = r166
        L_0x0027:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0046
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledInputColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r10 = 14
            r11 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r4, r6, r7, r8, r9, r10, r11)
            r96 = r4
            goto L_0x0048
        L_0x0046:
            r96 = r168
        L_0x0048:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0055
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r4 = r2.m4998getTransparent0d7_KjU()
            r98 = r4
            goto L_0x0057
        L_0x0055:
            r98 = r170
        L_0x0057:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x0068
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r100 = r4
            goto L_0x006a
        L_0x0068:
            r100 = r172
        L_0x006a:
            r2 = r0 & 16
            if (r2 == 0) goto L_0x007b
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getErrorFocusCaretColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r102 = r4
            goto L_0x007d
        L_0x007b:
            r102 = r174
        L_0x007d:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x009e
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r5 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r6, r7)
            java.lang.Object r6 = r15.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r237)
            r2 = r6
            androidx.compose.foundation.text.selection.TextSelectionColors r2 = (androidx.compose.foundation.text.selection.TextSelectionColors) r2
            r104 = r2
            goto L_0x00a0
        L_0x009e:
            r104 = r176
        L_0x00a0:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x00b1
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFocusOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r105 = r4
            goto L_0x00b3
        L_0x00b1:
            r105 = r177
        L_0x00b3:
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00c4
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r107 = r4
            goto L_0x00c6
        L_0x00c4:
            r107 = r179
        L_0x00c6:
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x00f3
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1039516303(0x3df5c28f, float:0.12)
            r8 = 0
            r9 = 0
            r10 = 0
            r166 = r4
            r168 = r7
            r169 = r8
            r170 = r9
            r171 = r10
            r172 = r2
            r173 = r6
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r109 = r4
            goto L_0x00f5
        L_0x00f3:
            r109 = r181
        L_0x00f5:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0106
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getErrorOutlineColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r111 = r4
            goto L_0x0108
        L_0x0106:
            r111 = r183
        L_0x0108:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0119
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFocusLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r113 = r4
            goto L_0x011b
        L_0x0119:
            r113 = r185
        L_0x011b:
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x012c
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r115 = r4
            goto L_0x012e
        L_0x012c:
            r115 = r187
        L_0x012e:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x015b
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r166 = r4
            r168 = r7
            r169 = r8
            r170 = r9
            r171 = r10
            r172 = r2
            r173 = r6
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r117 = r4
            goto L_0x015d
        L_0x015b:
            r117 = r189
        L_0x015d:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x016e
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getErrorLeadingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r119 = r4
            goto L_0x0170
        L_0x016e:
            r119 = r191
        L_0x0170:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0181
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFocusTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r121 = r4
            goto L_0x0183
        L_0x0181:
            r121 = r193
        L_0x0183:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0196
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r123 = r4
            goto L_0x0198
        L_0x0196:
            r123 = r195
        L_0x0198:
            r2 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01c6
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r166 = r4
            r168 = r7
            r169 = r8
            r170 = r9
            r171 = r10
            r172 = r2
            r173 = r6
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r125 = r4
            goto L_0x01c8
        L_0x01c6:
            r125 = r197
        L_0x01c8:
            r2 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01da
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getErrorTrailingIconColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r127 = r4
            goto L_0x01dc
        L_0x01da:
            r127 = r199
        L_0x01dc:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x01ee
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFocusLabelColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r129 = r4
            goto L_0x01f0
        L_0x01ee:
            r129 = r201
        L_0x01f0:
            r2 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0202
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getLabelColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r131 = r4
            goto L_0x0204
        L_0x0202:
            r131 = r203
        L_0x0204:
            r2 = 1048576(0x100000, float:1.469368E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0232
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledLabelColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r166 = r4
            r168 = r7
            r169 = r8
            r170 = r9
            r171 = r10
            r172 = r2
            r173 = r6
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r133 = r4
            goto L_0x0234
        L_0x0232:
            r133 = r205
        L_0x0234:
            r2 = 2097152(0x200000, float:2.938736E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0246
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getErrorLabelColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r135 = r4
            goto L_0x0248
        L_0x0246:
            r135 = r207
        L_0x0248:
            r2 = 4194304(0x400000, float:5.877472E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x025a
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getInputPlaceholderColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r137 = r4
            goto L_0x025c
        L_0x025a:
            r137 = r209
        L_0x025c:
            r2 = 8388608(0x800000, float:1.17549435E-38)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x028a
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledInputColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r166 = r4
            r168 = r7
            r169 = r8
            r170 = r9
            r171 = r10
            r172 = r2
            r173 = r6
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r139 = r4
            goto L_0x028c
        L_0x028a:
            r139 = r211
        L_0x028c:
            r2 = 16777216(0x1000000, float:2.3509887E-38)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x029e
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getFocusSupportingColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r141 = r4
            goto L_0x02a0
        L_0x029e:
            r141 = r213
        L_0x02a0:
            r2 = 33554432(0x2000000, float:9.403955E-38)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x02b2
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getSupportingColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r143 = r4
            goto L_0x02b4
        L_0x02b2:
            r143 = r215
        L_0x02b4:
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x02e2
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getDisabledSupportingColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r2 = 14
            r6 = 0
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r8 = 0
            r9 = 0
            r10 = 0
            r166 = r4
            r168 = r7
            r169 = r8
            r170 = r9
            r171 = r10
            r172 = r2
            r173 = r6
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r145 = r4
            goto L_0x02e4
        L_0x02e2:
            r145 = r217
        L_0x02e4:
            r2 = 134217728(0x8000000, float:3.85186E-34)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x02f6
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getErrorSupportingColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r147 = r4
            goto L_0x02f8
        L_0x02f6:
            r147 = r219
        L_0x02f8:
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x030a
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getInputPrefixColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r149 = r4
            goto L_0x030c
        L_0x030a:
            r149 = r221
        L_0x030c:
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x031e
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getInputPrefixColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r2, r15, r3)
            r151 = r4
            goto L_0x0320
        L_0x031e:
            r151 = r223
        L_0x0320:
            r2 = 1073741824(0x40000000, float:2.0)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x034e
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputPrefixColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r0 = 14
            r2 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            r166 = r4
            r168 = r6
            r169 = r7
            r170 = r8
            r171 = r9
            r172 = r0
            r173 = r2
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r153 = r4
            goto L_0x0350
        L_0x034e:
            r153 = r225
        L_0x0350:
            r0 = r243 & 1
            if (r0 == 0) goto L_0x0361
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputPrefixColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r155 = r4
            goto L_0x0363
        L_0x0361:
            r155 = r227
        L_0x0363:
            r0 = r243 & 2
            if (r0 == 0) goto L_0x0374
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r157 = r4
            goto L_0x0376
        L_0x0374:
            r157 = r229
        L_0x0376:
            r0 = r243 & 4
            if (r0 == 0) goto L_0x0387
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r159 = r4
            goto L_0x0389
        L_0x0387:
            r159 = r231
        L_0x0389:
            r0 = r243 & 8
            if (r0 == 0) goto L_0x03b6
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r0 = 14
            r2 = 0
            r6 = 1052938076(0x3ec28f5c, float:0.38)
            r7 = 0
            r8 = 0
            r9 = 0
            r166 = r4
            r168 = r6
            r169 = r7
            r170 = r8
            r171 = r9
            r172 = r0
            r173 = r2
            long r4 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r166, r168, r169, r170, r171, r172, r173)
            r161 = r4
            goto L_0x03b8
        L_0x03b6:
            r161 = r233
        L_0x03b8:
            r0 = r243 & 16
            if (r0 == 0) goto L_0x03c9
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r0 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getInputSuffixColor()
            long r2 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r15, r3)
            r163 = r2
            goto L_0x03cb
        L_0x03c9:
            r163 = r235
        L_0x03cb:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03d6
            java.lang.String r0 = "androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:1154)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r13, r14, r0)
        L_0x03d6:
            androidx.compose.material3.OutlinedTextFieldDefaults r0 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r1 = r13 & 14
            int r2 = r13 << 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r13 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r13 << 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r13 << 6
            r3 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r3
            r1 = r1 | r2
            int r2 = r13 << 9
            r4 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r4
            r1 = r1 | r2
            int r2 = r13 << 12
            r5 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r5
            r1 = r1 | r2
            int r2 = r13 << 15
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r6
            r1 = r1 | r2
            int r2 = r13 << 15
            r7 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r7
            r1 = r1 | r2
            int r2 = r13 << 15
            r8 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r8
            r87 = r1 | r2
            int r1 = r13 >> 15
            r1 = r1 & 14
            int r2 = r13 >> 15
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r13 >> 15
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r13 >> 15
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r13 >> 15
            r2 = r2 & r3
            r1 = r1 | r2
            int r2 = r14 << 15
            r2 = r2 & r4
            r1 = r1 | r2
            int r2 = r14 << 15
            r2 = r2 & r5
            r1 = r1 | r2
            int r2 = r14 << 15
            r2 = r2 & r6
            r1 = r1 | r2
            int r2 = r14 << 15
            r2 = r2 & r7
            r1 = r1 | r2
            int r2 = r14 << 15
            r2 = r2 & r8
            r88 = r1 | r2
            int r1 = r14 >> 15
            r1 = r1 & 14
            int r2 = r14 >> 15
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r14 >> 15
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r14 >> 15
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r14 >> 15
            r2 = r2 & r3
            r1 = r1 | r2
            int r2 = r240 << 15
            r2 = r2 & r4
            r1 = r1 | r2
            int r2 = r240 << 15
            r2 = r2 & r5
            r1 = r1 | r2
            int r2 = r240 << 15
            r2 = r2 & r6
            r1 = r1 | r2
            int r2 = r240 << 18
            r2 = r2 & r7
            r1 = r1 | r2
            int r2 = r240 << 18
            r2 = r2 & r8
            r89 = r1 | r2
            int r1 = r240 >> 6
            r1 = r1 & 14
            int r2 = r240 >> 9
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r240 >> 9
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r240 >> 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r240 >> 9
            r2 = r2 & r3
            r1 = r1 | r2
            int r2 = r240 >> 9
            r2 = r2 & r4
            r1 = r1 | r2
            int r2 = r240 >> 9
            r2 = r2 & r5
            r1 = r1 | r2
            int r2 = r241 << 21
            r2 = r2 & r6
            r1 = r1 | r2
            int r2 = r241 << 21
            r2 = r2 & r7
            r1 = r1 | r2
            int r2 = r241 << 21
            r2 = r2 & r8
            r90 = r1 | r2
            int r1 = r241 >> 9
            r1 = r1 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            int r2 = r241 >> 9
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r241 >> 9
            r2 = r2 & 896(0x380, float:1.256E-42)
            r91 = r1 | r2
            r92 = 0
            r93 = 0
            r1 = r94
            r3 = r94
            r5 = r96
            r7 = r94
            r9 = r98
            r11 = r98
            r13 = r98
            r15 = r98
            r17 = r100
            r19 = r102
            r21 = r104
            r22 = r105
            r24 = r107
            r26 = r109
            r28 = r111
            r30 = r113
            r32 = r115
            r34 = r117
            r36 = r119
            r38 = r121
            r40 = r123
            r42 = r125
            r44 = r127
            r46 = r129
            r48 = r131
            r50 = r133
            r52 = r135
            r54 = r137
            r56 = r137
            r58 = r139
            r60 = r137
            r62 = r141
            r64 = r143
            r66 = r145
            r68 = r147
            r70 = r149
            r72 = r151
            r74 = r153
            r76 = r155
            r78 = r157
            r80 = r159
            r82 = r161
            r84 = r163
            r86 = r237
            androidx.compose.material3.TextFieldColors r0 = r0.m3604colors0hiis_0(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r87, r88, r89, r90, r91, r92, r93)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0537
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0537:
            r237.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.m3838outlinedTextFieldColorseS1Emto(long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:143:0x01d6, code lost:
        if (r6.changed((java.lang.Object) r131) != false) goto L_0x01dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x01f0, code lost:
        if (r6.changed((java.lang.Object) r132) != false) goto L_0x01f7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x04b7  */
    /* JADX WARNING: Removed duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0158  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void TextFieldDecorationBox(java.lang.String r118, kotlin.jvm.functions.Function2 r119, boolean r120, boolean r121, androidx.compose.ui.text.input.VisualTransformation r122, androidx.compose.foundation.interaction.InteractionSource r123, boolean r124, kotlin.jvm.functions.Function2 r125, kotlin.jvm.functions.Function2 r126, kotlin.jvm.functions.Function2 r127, kotlin.jvm.functions.Function2 r128, kotlin.jvm.functions.Function2 r129, androidx.compose.ui.graphics.Shape r130, androidx.compose.material3.TextFieldColors r131, androidx.compose.foundation.layout.PaddingValues r132, kotlin.jvm.functions.Function2 r133, androidx.compose.runtime.Composer r134, int r135, int r136, int r137) {
        /*
            r117 = this;
            r15 = r118
            r14 = r119
            r11 = r122
            r10 = r123
            r9 = r135
            r8 = r136
            r7 = r137
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "innerTextField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -1224712461(0xffffffffb7005ef3, float:-7.651502E-6)
            r1 = r134
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(TextFieldDecorationBox)P(14,4,3,11,15,5,6,7,9,8,13,12,10!1,2)1262@71315L5,1263@71356L8,1274@71711L684:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r0 = r135
            r1 = r136
            r2 = r7 & 1
            if (r2 == 0) goto L_0x003f
            r0 = r0 | 6
            goto L_0x004d
        L_0x003f:
            r2 = r9 & 14
            if (r2 != 0) goto L_0x004d
            boolean r2 = r6.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x004b
            r2 = 4
            goto L_0x004c
        L_0x004b:
            r2 = 2
        L_0x004c:
            r0 = r0 | r2
        L_0x004d:
            r2 = r7 & 2
            if (r2 == 0) goto L_0x0054
            r0 = r0 | 48
            goto L_0x0064
        L_0x0054:
            r2 = r9 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0064
            boolean r2 = r6.changedInstance(r14)
            if (r2 == 0) goto L_0x0061
            r2 = 32
            goto L_0x0063
        L_0x0061:
            r2 = 16
        L_0x0063:
            r0 = r0 | r2
        L_0x0064:
            r2 = r7 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x006f
            r0 = r0 | 384(0x180, float:5.38E-43)
            r2 = r120
            goto L_0x0085
        L_0x006f:
            r2 = r9 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0083
            r2 = r120
            boolean r17 = r6.changed((boolean) r2)
            if (r17 == 0) goto L_0x007e
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x0080
        L_0x007e:
            r17 = r16
        L_0x0080:
            r0 = r0 | r17
            goto L_0x0085
        L_0x0083:
            r2 = r120
        L_0x0085:
            r17 = r7 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r17 == 0) goto L_0x0092
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r3 = r121
            goto L_0x00a8
        L_0x0092:
            r3 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x00a6
            r3 = r121
            boolean r17 = r6.changed((boolean) r3)
            if (r17 == 0) goto L_0x00a1
            r17 = r18
            goto L_0x00a3
        L_0x00a1:
            r17 = r19
        L_0x00a3:
            r0 = r0 | r17
            goto L_0x00a8
        L_0x00a6:
            r3 = r121
        L_0x00a8:
            r17 = r7 & 16
            r110 = 57344(0xe000, float:8.0356E-41)
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r17 == 0) goto L_0x00b6
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00c7
        L_0x00b6:
            r17 = r9 & r110
            if (r17 != 0) goto L_0x00c7
            boolean r17 = r6.changed((java.lang.Object) r11)
            if (r17 == 0) goto L_0x00c3
            r17 = r20
            goto L_0x00c5
        L_0x00c3:
            r17 = r21
        L_0x00c5:
            r0 = r0 | r17
        L_0x00c7:
            r17 = r7 & 32
            r22 = 65536(0x10000, float:9.18355E-41)
            r111 = 458752(0x70000, float:6.42848E-40)
            if (r17 == 0) goto L_0x00d4
            r17 = 196608(0x30000, float:2.75506E-40)
        L_0x00d1:
            r0 = r0 | r17
            goto L_0x00e4
        L_0x00d4:
            r17 = r9 & r111
            if (r17 != 0) goto L_0x00e4
            boolean r17 = r6.changed((java.lang.Object) r10)
            if (r17 == 0) goto L_0x00e1
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d1
        L_0x00e1:
            r17 = r22
            goto L_0x00d1
        L_0x00e4:
            r17 = r7 & 64
            r112 = 3670016(0x380000, float:5.142788E-39)
            if (r17 == 0) goto L_0x00f1
            r23 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r23
            r4 = r124
            goto L_0x0107
        L_0x00f1:
            r23 = r9 & r112
            if (r23 != 0) goto L_0x0105
            r4 = r124
            boolean r24 = r6.changed((boolean) r4)
            if (r24 == 0) goto L_0x0100
            r24 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0102
        L_0x0100:
            r24 = 524288(0x80000, float:7.34684E-40)
        L_0x0102:
            r0 = r0 | r24
            goto L_0x0107
        L_0x0105:
            r4 = r124
        L_0x0107:
            r5 = r7 & 128(0x80, float:1.794E-43)
            r113 = 29360128(0x1c00000, float:7.052966E-38)
            if (r5 == 0) goto L_0x0114
            r25 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r25
            r12 = r125
            goto L_0x012a
        L_0x0114:
            r25 = r9 & r113
            if (r25 != 0) goto L_0x0128
            r12 = r125
            boolean r26 = r6.changedInstance(r12)
            if (r26 == 0) goto L_0x0123
            r26 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0125
        L_0x0123:
            r26 = 4194304(0x400000, float:5.877472E-39)
        L_0x0125:
            r0 = r0 | r26
            goto L_0x012a
        L_0x0128:
            r12 = r125
        L_0x012a:
            r13 = r7 & 256(0x100, float:3.59E-43)
            r114 = 234881024(0xe000000, float:1.5777218E-30)
            if (r13 == 0) goto L_0x0137
            r27 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r27
            r2 = r126
            goto L_0x014d
        L_0x0137:
            r27 = r9 & r114
            if (r27 != 0) goto L_0x014b
            r2 = r126
            boolean r27 = r6.changedInstance(r2)
            if (r27 == 0) goto L_0x0146
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0148
        L_0x0146:
            r27 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0148:
            r0 = r0 | r27
            goto L_0x014d
        L_0x014b:
            r2 = r126
        L_0x014d:
            r2 = r7 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0158
            r27 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r27
            r3 = r127
            goto L_0x0170
        L_0x0158:
            r27 = 1879048192(0x70000000, float:1.58456325E29)
            r27 = r9 & r27
            if (r27 != 0) goto L_0x016e
            r3 = r127
            boolean r27 = r6.changedInstance(r3)
            if (r27 == 0) goto L_0x0169
            r27 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x016b
        L_0x0169:
            r27 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x016b:
            r0 = r0 | r27
            goto L_0x0170
        L_0x016e:
            r3 = r127
        L_0x0170:
            r3 = r7 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0179
            r1 = r1 | 6
            r4 = r128
            goto L_0x018f
        L_0x0179:
            r27 = r8 & 14
            if (r27 != 0) goto L_0x018d
            r4 = r128
            boolean r27 = r6.changedInstance(r4)
            if (r27 == 0) goto L_0x0188
            r23 = 4
            goto L_0x018a
        L_0x0188:
            r23 = 2
        L_0x018a:
            r1 = r1 | r23
            goto L_0x018f
        L_0x018d:
            r4 = r128
        L_0x018f:
            r4 = r7 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0198
            r1 = r1 | 48
            r10 = r129
            goto L_0x01ae
        L_0x0198:
            r23 = r8 & 112(0x70, float:1.57E-43)
            if (r23 != 0) goto L_0x01ac
            r10 = r129
            boolean r23 = r6.changedInstance(r10)
            if (r23 == 0) goto L_0x01a7
            r24 = 32
            goto L_0x01a9
        L_0x01a7:
            r24 = 16
        L_0x01a9:
            r1 = r1 | r24
            goto L_0x01ae
        L_0x01ac:
            r10 = r129
        L_0x01ae:
            r10 = r8 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x01c6
            r10 = r7 & 4096(0x1000, float:5.74E-42)
            if (r10 != 0) goto L_0x01c1
            r10 = r130
            boolean r23 = r6.changed((java.lang.Object) r10)
            if (r23 == 0) goto L_0x01c3
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x01c3
        L_0x01c1:
            r10 = r130
        L_0x01c3:
            r1 = r1 | r16
            goto L_0x01c8
        L_0x01c6:
            r10 = r130
        L_0x01c8:
            r10 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x01e0
            r10 = r7 & 8192(0x2000, float:1.14794E-41)
            if (r10 != 0) goto L_0x01d9
            r10 = r131
            boolean r16 = r6.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x01db
            goto L_0x01dd
        L_0x01d9:
            r10 = r131
        L_0x01db:
            r18 = r19
        L_0x01dd:
            r1 = r1 | r18
            goto L_0x01e2
        L_0x01e0:
            r10 = r131
        L_0x01e2:
            r16 = r8 & r110
            if (r16 != 0) goto L_0x01fa
            r10 = r7 & 16384(0x4000, float:2.2959E-41)
            if (r10 != 0) goto L_0x01f3
            r10 = r132
            boolean r16 = r6.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x01f5
            goto L_0x01f7
        L_0x01f3:
            r10 = r132
        L_0x01f5:
            r20 = r21
        L_0x01f7:
            r1 = r1 | r20
            goto L_0x01fc
        L_0x01fa:
            r10 = r132
        L_0x01fc:
            r16 = 32768(0x8000, float:4.5918E-41)
            r115 = r7 & r16
            if (r115 == 0) goto L_0x020a
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r10 = r133
            goto L_0x0220
        L_0x020a:
            r16 = r8 & r111
            if (r16 != 0) goto L_0x021e
            r10 = r133
            boolean r16 = r6.changedInstance(r10)
            if (r16 == 0) goto L_0x0219
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x021b
        L_0x0219:
            r16 = r22
        L_0x021b:
            r1 = r1 | r16
            goto L_0x0220
        L_0x021e:
            r10 = r133
        L_0x0220:
            r16 = r7 & r22
            if (r16 == 0) goto L_0x022b
            r16 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r16
            r12 = r117
            goto L_0x0241
        L_0x022b:
            r16 = r8 & r112
            if (r16 != 0) goto L_0x023f
            r12 = r117
            boolean r16 = r6.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x023a
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x023c
        L_0x023a:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x023c:
            r1 = r1 | r16
            goto L_0x0241
        L_0x023f:
            r12 = r117
        L_0x0241:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r0 & r16
            r10 = 306783378(0x12492492, float:6.3469493E-28)
            if (r8 != r10) goto L_0x027a
            r8 = 2995931(0x2db6db, float:4.198194E-39)
            r8 = r8 & r1
            r10 = 599186(0x92492, float:8.39638E-40)
            if (r8 != r10) goto L_0x027a
            boolean r8 = r6.getSkipping()
            if (r8 != 0) goto L_0x025b
            goto L_0x027a
        L_0x025b:
            r6.skipToGroupEnd()
            r23 = r124
            r24 = r125
            r25 = r126
            r26 = r127
            r27 = r128
            r28 = r129
            r29 = r130
            r30 = r131
            r31 = r132
            r32 = r133
            r33 = r0
            r35 = r1
            r34 = r6
            goto L_0x04b0
        L_0x027a:
            r6.startDefaults()
            r8 = r9 & 1
            if (r8 == 0) goto L_0x02b6
            boolean r8 = r6.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0288
            goto L_0x02b6
        L_0x0288:
            r6.skipToGroupEnd()
            r2 = r7 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x0291
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0291:
            r2 = r7 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0297
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0297:
            r2 = r7 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x029f
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r2
        L_0x029f:
            r23 = r124
            r24 = r125
            r25 = r126
            r26 = r127
            r27 = r128
            r28 = r129
            r29 = r130
            r30 = r131
            r31 = r132
            r32 = r133
            r10 = r1
            goto L_0x0410
        L_0x02b6:
            if (r17 == 0) goto L_0x02ba
            r8 = 0
            goto L_0x02bc
        L_0x02ba:
            r8 = r124
        L_0x02bc:
            if (r5 == 0) goto L_0x02c0
            r5 = 0
            goto L_0x02c2
        L_0x02c0:
            r5 = r125
        L_0x02c2:
            if (r13 == 0) goto L_0x02c6
            r10 = 0
            goto L_0x02c8
        L_0x02c6:
            r10 = r126
        L_0x02c8:
            if (r2 == 0) goto L_0x02cc
            r2 = 0
            goto L_0x02ce
        L_0x02cc:
            r2 = r127
        L_0x02ce:
            if (r3 == 0) goto L_0x02d2
            r3 = 0
            goto L_0x02d4
        L_0x02d2:
            r3 = r128
        L_0x02d4:
            if (r4 == 0) goto L_0x02d8
            r4 = 0
            goto L_0x02da
        L_0x02d8:
            r4 = r129
        L_0x02da:
            r13 = r7 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x02ea
            androidx.compose.material3.TextFieldDefaults r13 = INSTANCE
            r134 = r2
            r2 = 6
            androidx.compose.ui.graphics.Shape r2 = r13.getShape(r6, r2)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x02ee
        L_0x02ea:
            r134 = r2
            r2 = r130
        L_0x02ee:
            r13 = r7 & 8192(0x2000, float:1.14794E-41)
            if (r13 == 0) goto L_0x0366
            int r13 = r1 >> 9
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r107 = r13
            r108 = 2147483647(0x7fffffff, float:NaN)
            r109 = 4095(0xfff, float:5.738E-42)
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r38 = 0
            r40 = 0
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r52 = 0
            r54 = 0
            r56 = 0
            r58 = 0
            r60 = 0
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 0
            r70 = 0
            r72 = 0
            r74 = 0
            r76 = 0
            r78 = 0
            r80 = 0
            r82 = 0
            r84 = 0
            r86 = 0
            r88 = 0
            r90 = 0
            r92 = 0
            r94 = 0
            r96 = 0
            r98 = 0
            r100 = 0
            r103 = 0
            r104 = 0
            r105 = 0
            r106 = 0
            r16 = r117
            r102 = r6
            androidx.compose.material3.TextFieldColors r13 = r16.m3827colors0hiis_0(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r88, r90, r92, r94, r96, r98, r100, r102, r103, r104, r105, r106, r107, r108, r109)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0368
        L_0x0366:
            r13 = r131
        L_0x0368:
            r16 = r3
            r3 = r7 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x03b4
            if (r5 != 0) goto L_0x038f
            r3 = 15
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r124 = r117
            r125 = r18
            r126 = r19
            r127 = r20
            r128 = r21
            r129 = r3
            r130 = r17
            androidx.compose.foundation.layout.PaddingValues r3 = m3818contentPaddingWithoutLabela9UjIt4$default(r124, r125, r126, r127, r128, r129, r130)
            goto L_0x03ad
        L_0x038f:
            r3 = 15
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r124 = r117
            r125 = r18
            r126 = r19
            r127 = r20
            r128 = r21
            r129 = r3
            r130 = r17
            androidx.compose.foundation.layout.PaddingValues r3 = m3817contentPaddingWithLabela9UjIt4$default(r124, r125, r126, r127, r128, r129, r130)
        L_0x03ad:
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r17
            goto L_0x03b6
        L_0x03b4:
            r3 = r132
        L_0x03b6:
            if (r115 == 0) goto L_0x03f4
            r132 = r3
            androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$3 r3 = new androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$3
            r124 = r3
            r125 = r120
            r126 = r8
            r127 = r123
            r128 = r13
            r129 = r2
            r130 = r0
            r131 = r1
            r124.<init>(r125, r126, r127, r128, r129, r130, r131)
            r124 = r1
            r1 = -1171460386(0xffffffffba2ceede, float:-6.596873E-4)
            r125 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r6, r1, r2, r3)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r29 = r125
            r31 = r132
            r26 = r134
            r32 = r1
            r28 = r4
            r24 = r5
            r23 = r8
            r25 = r10
            r30 = r13
            r27 = r16
            r10 = r124
            goto L_0x0410
        L_0x03f4:
            r124 = r1
            r125 = r2
            r132 = r3
            r29 = r125
            r31 = r132
            r32 = r133
            r26 = r134
            r28 = r4
            r24 = r5
            r23 = r8
            r25 = r10
            r30 = r13
            r27 = r16
            r10 = r124
        L_0x0410:
            r6.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0421
            r1 = -1224712461(0xffffffffb7005ef3, float:-7.651502E-6)
            java.lang.String r2 = "androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:1249)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r0, r10, r2)
        L_0x0421:
            r1 = r0 & 14
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = r0 & r110
            r1 = r1 | r2
            r2 = r0 & r111
            r1 = r1 | r2
            r2 = r0 & r112
            r1 = r1 | r2
            r2 = r0 & r113
            r1 = r1 | r2
            r2 = r0 & r114
            r1 = r1 | r2
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r0
            r20 = r1 | r2
            r1 = r10 & 14
            r1 = r1 | 432(0x1b0, float:6.05E-43)
            int r2 = r10 << 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r10 << 6
            r2 = r2 & r110
            r1 = r1 | r2
            int r2 = r10 << 6
            r2 = r2 & r111
            r1 = r1 | r2
            int r2 = r10 << 6
            r2 = r2 & r112
            r1 = r1 | r2
            int r2 = r10 << 6
            r2 = r2 & r113
            r1 = r1 | r2
            int r2 = r10 << 6
            r2 = r2 & r114
            r21 = r1 | r2
            r1 = 0
            r12 = r1
            r13 = 0
            r22 = 0
            r33 = r0
            r0 = r117
            r1 = r118
            r2 = r119
            r3 = r120
            r4 = r121
            r5 = r122
            r34 = r6
            r6 = r123
            r7 = r23
            r8 = r24
            r9 = r25
            r35 = r10
            r10 = r26
            r11 = r27
            r14 = r28
            r15 = r29
            r16 = r30
            r17 = r31
            r18 = r32
            r19 = r34
            r0.DecorationBox(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x04b0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04b0:
            androidx.compose.runtime.ScopeUpdateScope r15 = r34.endRestartGroup()
            if (r15 != 0) goto L_0x04b7
            goto L_0x04f1
        L_0x04b7:
            androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$4 r21 = new androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$4
            r0 = r21
            r1 = r117
            r2 = r118
            r3 = r119
            r4 = r120
            r5 = r121
            r6 = r122
            r7 = r123
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r26
            r12 = r27
            r13 = r28
            r14 = r29
            r116 = r15
            r15 = r30
            r16 = r31
            r17 = r32
            r18 = r135
            r19 = r136
            r20 = r137
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r0 = r21
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r116
            r1.updateScope(r0)
        L_0x04f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01bc, code lost:
        if (r6.changed((java.lang.Object) r127) != false) goto L_0x01c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x01d6, code lost:
        if (r6.changed((java.lang.Object) r128) != false) goto L_0x01dd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0429  */
    /* JADX WARNING: Removed duplicated region for block: B:214:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0158  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void OutlinedTextFieldDecorationBox(java.lang.String r115, kotlin.jvm.functions.Function2 r116, boolean r117, boolean r118, androidx.compose.ui.text.input.VisualTransformation r119, androidx.compose.foundation.interaction.InteractionSource r120, boolean r121, kotlin.jvm.functions.Function2 r122, kotlin.jvm.functions.Function2 r123, kotlin.jvm.functions.Function2 r124, kotlin.jvm.functions.Function2 r125, kotlin.jvm.functions.Function2 r126, androidx.compose.material3.TextFieldColors r127, androidx.compose.foundation.layout.PaddingValues r128, kotlin.jvm.functions.Function2 r129, androidx.compose.runtime.Composer r130, int r131, int r132, int r133) {
        /*
            r114 = this;
            r15 = r115
            r14 = r116
            r11 = r119
            r10 = r120
            r9 = r131
            r8 = r132
            r7 = r133
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "innerTextField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 508645792(0x1e5151a0, float:1.10812475E-20)
            r1 = r130
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(OutlinedTextFieldDecorationBox)P(13,4,3,10,14,5,6,7,9,8,12,11!1,2)1312@73179L8,1318@73467L656:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r131
            r2 = r132
            r3 = r7 & 1
            if (r3 == 0) goto L_0x003f
            r1 = r1 | 6
            goto L_0x004d
        L_0x003f:
            r3 = r9 & 14
            if (r3 != 0) goto L_0x004d
            boolean r3 = r6.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x004b
            r3 = 4
            goto L_0x004c
        L_0x004b:
            r3 = 2
        L_0x004c:
            r1 = r1 | r3
        L_0x004d:
            r3 = r7 & 2
            if (r3 == 0) goto L_0x0054
            r1 = r1 | 48
            goto L_0x0064
        L_0x0054:
            r3 = r9 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0064
            boolean r3 = r6.changedInstance(r14)
            if (r3 == 0) goto L_0x0061
            r3 = 32
            goto L_0x0063
        L_0x0061:
            r3 = 16
        L_0x0063:
            r1 = r1 | r3
        L_0x0064:
            r3 = r7 & 4
            r16 = 256(0x100, float:3.59E-43)
            r17 = 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0071
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r117
            goto L_0x0087
        L_0x0071:
            r3 = r9 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0085
            r3 = r117
            boolean r18 = r6.changed((boolean) r3)
            if (r18 == 0) goto L_0x0080
            r18 = r16
            goto L_0x0082
        L_0x0080:
            r18 = r17
        L_0x0082:
            r1 = r1 | r18
            goto L_0x0087
        L_0x0085:
            r3 = r117
        L_0x0087:
            r18 = r7 & 8
            r19 = 2048(0x800, float:2.87E-42)
            r20 = 1024(0x400, float:1.435E-42)
            if (r18 == 0) goto L_0x0094
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r4 = r118
            goto L_0x00aa
        L_0x0094:
            r4 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x00a8
            r4 = r118
            boolean r18 = r6.changed((boolean) r4)
            if (r18 == 0) goto L_0x00a3
            r18 = r19
            goto L_0x00a5
        L_0x00a3:
            r18 = r20
        L_0x00a5:
            r1 = r1 | r18
            goto L_0x00aa
        L_0x00a8:
            r4 = r118
        L_0x00aa:
            r18 = r7 & 16
            r21 = 16384(0x4000, float:2.2959E-41)
            r110 = 57344(0xe000, float:8.0356E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x00b8
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00c9
        L_0x00b8:
            r18 = r9 & r110
            if (r18 != 0) goto L_0x00c9
            boolean r18 = r6.changed((java.lang.Object) r11)
            if (r18 == 0) goto L_0x00c5
            r18 = r21
            goto L_0x00c7
        L_0x00c5:
            r18 = r22
        L_0x00c7:
            r1 = r1 | r18
        L_0x00c9:
            r18 = r7 & 32
            r111 = 458752(0x70000, float:6.42848E-40)
            if (r18 == 0) goto L_0x00d4
            r18 = 196608(0x30000, float:2.75506E-40)
        L_0x00d1:
            r1 = r1 | r18
            goto L_0x00e4
        L_0x00d4:
            r18 = r9 & r111
            if (r18 != 0) goto L_0x00e4
            boolean r18 = r6.changed((java.lang.Object) r10)
            if (r18 == 0) goto L_0x00e1
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d1
        L_0x00e1:
            r18 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00d1
        L_0x00e4:
            r18 = r7 & 64
            r112 = 3670016(0x380000, float:5.142788E-39)
            if (r18 == 0) goto L_0x00f1
            r23 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r23
            r5 = r121
            goto L_0x0107
        L_0x00f1:
            r23 = r9 & r112
            if (r23 != 0) goto L_0x0105
            r5 = r121
            boolean r24 = r6.changed((boolean) r5)
            if (r24 == 0) goto L_0x0100
            r24 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0102
        L_0x0100:
            r24 = 524288(0x80000, float:7.34684E-40)
        L_0x0102:
            r1 = r1 | r24
            goto L_0x0107
        L_0x0105:
            r5 = r121
        L_0x0107:
            r12 = r7 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0112
            r25 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r25
            r13 = r122
            goto L_0x012a
        L_0x0112:
            r25 = 29360128(0x1c00000, float:7.052966E-38)
            r25 = r9 & r25
            if (r25 != 0) goto L_0x0128
            r13 = r122
            boolean r26 = r6.changedInstance(r13)
            if (r26 == 0) goto L_0x0123
            r26 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0125
        L_0x0123:
            r26 = 4194304(0x400000, float:5.877472E-39)
        L_0x0125:
            r1 = r1 | r26
            goto L_0x012a
        L_0x0128:
            r13 = r122
        L_0x012a:
            r0 = r7 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0135
            r26 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r26
            r3 = r123
            goto L_0x014d
        L_0x0135:
            r26 = 234881024(0xe000000, float:1.5777218E-30)
            r26 = r9 & r26
            if (r26 != 0) goto L_0x014b
            r3 = r123
            boolean r26 = r6.changedInstance(r3)
            if (r26 == 0) goto L_0x0146
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0148
        L_0x0146:
            r26 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0148:
            r1 = r1 | r26
            goto L_0x014d
        L_0x014b:
            r3 = r123
        L_0x014d:
            r3 = r7 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x0158
            r26 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r26
            r4 = r124
            goto L_0x0170
        L_0x0158:
            r26 = 1879048192(0x70000000, float:1.58456325E29)
            r26 = r9 & r26
            if (r26 != 0) goto L_0x016e
            r4 = r124
            boolean r26 = r6.changedInstance(r4)
            if (r26 == 0) goto L_0x0169
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x016b
        L_0x0169:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x016b:
            r1 = r1 | r26
            goto L_0x0170
        L_0x016e:
            r4 = r124
        L_0x0170:
            r4 = r7 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0179
            r2 = r2 | 6
            r5 = r125
            goto L_0x018f
        L_0x0179:
            r26 = r8 & 14
            if (r26 != 0) goto L_0x018d
            r5 = r125
            boolean r26 = r6.changedInstance(r5)
            if (r26 == 0) goto L_0x0188
            r23 = 4
            goto L_0x018a
        L_0x0188:
            r23 = 2
        L_0x018a:
            r2 = r2 | r23
            goto L_0x018f
        L_0x018d:
            r5 = r125
        L_0x018f:
            r5 = r7 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0198
            r2 = r2 | 48
            r10 = r126
            goto L_0x01ae
        L_0x0198:
            r23 = r8 & 112(0x70, float:1.57E-43)
            if (r23 != 0) goto L_0x01ac
            r10 = r126
            boolean r23 = r6.changedInstance(r10)
            if (r23 == 0) goto L_0x01a7
            r24 = 32
            goto L_0x01a9
        L_0x01a7:
            r24 = 16
        L_0x01a9:
            r2 = r2 | r24
            goto L_0x01ae
        L_0x01ac:
            r10 = r126
        L_0x01ae:
            r10 = r8 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x01c6
            r10 = r7 & 4096(0x1000, float:5.74E-42)
            if (r10 != 0) goto L_0x01bf
            r10 = r127
            boolean r23 = r6.changed((java.lang.Object) r10)
            if (r23 == 0) goto L_0x01c1
            goto L_0x01c3
        L_0x01bf:
            r10 = r127
        L_0x01c1:
            r16 = r17
        L_0x01c3:
            r2 = r2 | r16
            goto L_0x01c8
        L_0x01c6:
            r10 = r127
        L_0x01c8:
            r10 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x01e0
            r10 = r7 & 8192(0x2000, float:1.14794E-41)
            if (r10 != 0) goto L_0x01d9
            r10 = r128
            boolean r16 = r6.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x01db
            goto L_0x01dd
        L_0x01d9:
            r10 = r128
        L_0x01db:
            r19 = r20
        L_0x01dd:
            r2 = r2 | r19
            goto L_0x01e2
        L_0x01e0:
            r10 = r128
        L_0x01e2:
            r10 = r7 & 16384(0x4000, float:2.2959E-41)
            if (r10 == 0) goto L_0x01eb
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r8 = r129
            goto L_0x01ff
        L_0x01eb:
            r16 = r8 & r110
            if (r16 != 0) goto L_0x01fd
            r8 = r129
            boolean r16 = r6.changedInstance(r8)
            if (r16 == 0) goto L_0x01f8
            goto L_0x01fa
        L_0x01f8:
            r21 = r22
        L_0x01fa:
            r2 = r2 | r21
            goto L_0x01ff
        L_0x01fd:
            r8 = r129
        L_0x01ff:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r1 & r16
            r11 = 306783378(0x12492492, float:6.3469493E-28)
            if (r8 != r11) goto L_0x0235
            r8 = 46811(0xb6db, float:6.5596E-41)
            r8 = r8 & r2
            r11 = 9362(0x2492, float:1.3119E-41)
            if (r8 != r11) goto L_0x0235
            boolean r8 = r6.getSkipping()
            if (r8 != 0) goto L_0x0218
            goto L_0x0235
        L_0x0218:
            r6.skipToGroupEnd()
            r22 = r121
            r24 = r123
            r25 = r124
            r26 = r125
            r27 = r126
            r28 = r127
            r29 = r128
            r30 = r129
            r31 = r1
            r33 = r2
            r32 = r6
            r23 = r13
            goto L_0x0422
        L_0x0235:
            r6.startDefaults()
            r8 = r9 & 1
            if (r8 == 0) goto L_0x027c
            boolean r8 = r6.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0243
            goto L_0x027c
        L_0x0243:
            r6.skipToGroupEnd()
            r0 = r7 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x024c
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x024c:
            r0 = r7 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0267
            r0 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            r22 = r121
            r24 = r123
            r25 = r124
            r26 = r125
            r27 = r126
            r28 = r127
            r29 = r128
            r30 = r129
            r11 = r0
            r23 = r13
            goto L_0x038d
        L_0x0267:
            r22 = r121
            r24 = r123
            r25 = r124
            r26 = r125
            r27 = r126
            r28 = r127
            r29 = r128
            r30 = r129
            r11 = r2
            r23 = r13
            goto L_0x038d
        L_0x027c:
            if (r18 == 0) goto L_0x0280
            r8 = 0
            goto L_0x0282
        L_0x0280:
            r8 = r121
        L_0x0282:
            if (r12 == 0) goto L_0x0286
            r11 = 0
            r13 = r11
        L_0x0286:
            if (r0 == 0) goto L_0x028a
            r0 = 0
            goto L_0x028c
        L_0x028a:
            r0 = r123
        L_0x028c:
            if (r3 == 0) goto L_0x0290
            r3 = 0
            goto L_0x0292
        L_0x0290:
            r3 = r124
        L_0x0292:
            if (r4 == 0) goto L_0x0296
            r4 = 0
            goto L_0x0298
        L_0x0296:
            r4 = r125
        L_0x0298:
            if (r5 == 0) goto L_0x029c
            r5 = 0
            goto L_0x029e
        L_0x029c:
            r5 = r126
        L_0x029e:
            r11 = r7 & 4096(0x1000, float:5.74E-42)
            if (r11 == 0) goto L_0x0312
            androidx.compose.material3.OutlinedTextFieldDefaults r16 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r108 = 2147483647(0x7fffffff, float:NaN)
            r109 = 4095(0xfff, float:5.738E-42)
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r38 = 0
            r40 = 0
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r52 = 0
            r54 = 0
            r56 = 0
            r58 = 0
            r60 = 0
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 0
            r70 = 0
            r72 = 0
            r74 = 0
            r76 = 0
            r78 = 0
            r80 = 0
            r82 = 0
            r84 = 0
            r86 = 0
            r88 = 0
            r90 = 0
            r92 = 0
            r94 = 0
            r96 = 0
            r98 = 0
            r100 = 0
            r103 = 0
            r104 = 0
            r105 = 0
            r106 = 0
            r107 = 3072(0xc00, float:4.305E-42)
            r102 = r6
            androidx.compose.material3.TextFieldColors r11 = r16.m3604colors0hiis_0(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r88, r90, r92, r94, r96, r98, r100, r102, r103, r104, r105, r106, r107, r108, r109)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0314
        L_0x0312:
            r11 = r127
        L_0x0314:
            r12 = r7 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x033b
            androidx.compose.material3.OutlinedTextFieldDefaults r12 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r16 = 15
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r121 = r12
            r122 = r18
            r123 = r19
            r124 = r20
            r125 = r21
            r126 = r16
            r127 = r17
            androidx.compose.foundation.layout.PaddingValues r12 = androidx.compose.material3.OutlinedTextFieldDefaults.m3602contentPaddinga9UjIt4$default(r121, r122, r123, r124, r125, r126, r127)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x033d
        L_0x033b:
            r12 = r128
        L_0x033d:
            if (r10 == 0) goto L_0x0375
            androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$3 r10 = new androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$3
            r121 = r10
            r122 = r117
            r123 = r8
            r124 = r120
            r125 = r11
            r126 = r1
            r127 = r2
            r121.<init>(r122, r123, r124, r125, r126, r127)
            r121 = r0
            r0 = 144282315(0x89992cb, float:9.242863E-34)
            r122 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r6, r0, r2, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r24 = r121
            r30 = r0
            r25 = r3
            r26 = r4
            r27 = r5
            r22 = r8
            r28 = r11
            r29 = r12
            r23 = r13
            r11 = r122
            goto L_0x038d
        L_0x0375:
            r121 = r0
            r122 = r2
            r24 = r121
            r30 = r129
            r25 = r3
            r26 = r4
            r27 = r5
            r22 = r8
            r28 = r11
            r29 = r12
            r23 = r13
            r11 = r122
        L_0x038d:
            r6.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x039e
            java.lang.String r0 = "androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:1299)"
            r2 = 508645792(0x1e5151a0, float:1.10812475E-20)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r11, r0)
        L_0x039e:
            androidx.compose.material3.OutlinedTextFieldDefaults r0 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r2 = r1 & 14
            r3 = r1 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = r1 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r3 = r1 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            r3 = r1 & r110
            r2 = r2 | r3
            r3 = r1 & r111
            r2 = r2 | r3
            r3 = r1 & r112
            r2 = r2 | r3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r1
            r2 = r2 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r1
            r2 = r2 | r3
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r1
            r19 = r2 | r3
            r2 = 12583344(0xc001b0, float:1.763302E-38)
            r3 = r11 & 14
            r2 = r2 | r3
            int r3 = r11 << 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            int r3 = r11 << 6
            r3 = r3 & r110
            r2 = r2 | r3
            int r3 = r11 << 6
            r3 = r3 & r111
            r2 = r2 | r3
            int r3 = r11 << 6
            r3 = r3 & r112
            r20 = r2 | r3
            r12 = 0
            r13 = 0
            r21 = 0
            r31 = r1
            r1 = r115
            r2 = r116
            r3 = r117
            r4 = r118
            r5 = r119
            r32 = r6
            r6 = r120
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r25
            r33 = r11
            r11 = r26
            r14 = r27
            r15 = r28
            r16 = r29
            r17 = r30
            r18 = r32
            r0.DecorationBox(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0422
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0422:
            androidx.compose.runtime.ScopeUpdateScope r15 = r32.endRestartGroup()
            if (r15 != 0) goto L_0x0429
            goto L_0x0461
        L_0x0429:
            androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$4 r20 = new androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$4
            r0 = r20
            r1 = r114
            r2 = r115
            r3 = r116
            r4 = r117
            r5 = r118
            r6 = r119
            r7 = r120
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r12 = r26
            r13 = r27
            r14 = r28
            r113 = r15
            r15 = r29
            r16 = r30
            r17 = r131
            r18 = r132
            r19 = r133
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r113
            r1.updateScope(r0)
        L_0x0461:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }
}

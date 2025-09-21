package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.Color;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b|\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bð\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010 Jµ\u0002\u0010|\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b}\u0010~J\t\u0010\u001a\u00030\u0001H\u0016R4\u0010\u0010\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R4\u0010\u0019\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b*\u0010'\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R4\u0010\u001b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b+\u0010#\"\u0004\b,\u0010%R4\u0010\u0018\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b0\u0010'\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R4\u0010\u0007\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b3\u0010'\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%R4\u0010\u0017\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b6\u0010'\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R4\u0010\u0011\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b9\u0010'\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%R4\u0010\u001a\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b<\u0010'\u001a\u0004\b:\u0010#\"\u0004\b;\u0010%R4\u0010\u001c\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b?\u0010'\u001a\u0004\b=\u0010#\"\u0004\b>\u0010%R4\u0010\u0004\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bB\u0010'\u001a\u0004\b@\u0010#\"\u0004\bA\u0010%R4\u0010\u0006\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bE\u0010'\u001a\u0004\bC\u0010#\"\u0004\bD\u0010%R4\u0010\t\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bH\u0010'\u001a\u0004\bF\u0010#\"\u0004\bG\u0010%R4\u0010\u000b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bK\u0010'\u001a\u0004\bI\u0010#\"\u0004\bJ\u0010%R4\u0010\u0013\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bN\u0010'\u001a\u0004\bL\u0010#\"\u0004\bM\u0010%R4\u0010\u0015\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bQ\u0010'\u001a\u0004\bO\u0010#\"\u0004\bP\u0010%R4\u0010\r\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bT\u0010'\u001a\u0004\bR\u0010#\"\u0004\bS\u0010%R4\u0010\u000f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bW\u0010'\u001a\u0004\bU\u0010#\"\u0004\bV\u0010%R4\u0010\u001d\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bZ\u0010'\u001a\u0004\bX\u0010#\"\u0004\bY\u0010%R4\u0010\u001e\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b]\u0010'\u001a\u0004\b[\u0010#\"\u0004\b\\\u0010%R4\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b`\u0010'\u001a\u0004\b^\u0010#\"\u0004\b_\u0010%R4\u0010\u0005\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bc\u0010'\u001a\u0004\ba\u0010#\"\u0004\bb\u0010%R4\u0010\u001f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bf\u0010'\u001a\u0004\bd\u0010#\"\u0004\be\u0010%R4\u0010\b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bi\u0010'\u001a\u0004\bg\u0010#\"\u0004\bh\u0010%R4\u0010\n\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bl\u0010'\u001a\u0004\bj\u0010#\"\u0004\bk\u0010%R4\u0010\u0012\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bo\u0010'\u001a\u0004\bm\u0010#\"\u0004\bn\u0010%R4\u0010\u0016\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\br\u0010'\u001a\u0004\bp\u0010#\"\u0004\bq\u0010%R4\u0010\u0014\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bu\u0010'\u001a\u0004\bs\u0010#\"\u0004\bt\u0010%R4\u0010\f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bx\u0010'\u001a\u0004\bv\u0010#\"\u0004\bw\u0010%R4\u0010\u000e\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b{\u0010'\u001a\u0004\by\u0010#\"\u0004\bz\u0010%\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/material3/ColorScheme;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getBackground-0d7_KjU", "()J", "setBackground-8_81llA$material3_release", "(J)V", "background$delegate", "Landroidx/compose/runtime/MutableState;", "getError-0d7_KjU", "setError-8_81llA$material3_release", "error$delegate", "getErrorContainer-0d7_KjU", "setErrorContainer-8_81llA$material3_release", "errorContainer$delegate", "getInverseOnSurface-0d7_KjU", "setInverseOnSurface-8_81llA$material3_release", "inverseOnSurface$delegate", "getInversePrimary-0d7_KjU", "setInversePrimary-8_81llA$material3_release", "inversePrimary$delegate", "getInverseSurface-0d7_KjU", "setInverseSurface-8_81llA$material3_release", "inverseSurface$delegate", "getOnBackground-0d7_KjU", "setOnBackground-8_81llA$material3_release", "onBackground$delegate", "getOnError-0d7_KjU", "setOnError-8_81llA$material3_release", "onError$delegate", "getOnErrorContainer-0d7_KjU", "setOnErrorContainer-8_81llA$material3_release", "onErrorContainer$delegate", "getOnPrimary-0d7_KjU", "setOnPrimary-8_81llA$material3_release", "onPrimary$delegate", "getOnPrimaryContainer-0d7_KjU", "setOnPrimaryContainer-8_81llA$material3_release", "onPrimaryContainer$delegate", "getOnSecondary-0d7_KjU", "setOnSecondary-8_81llA$material3_release", "onSecondary$delegate", "getOnSecondaryContainer-0d7_KjU", "setOnSecondaryContainer-8_81llA$material3_release", "onSecondaryContainer$delegate", "getOnSurface-0d7_KjU", "setOnSurface-8_81llA$material3_release", "onSurface$delegate", "getOnSurfaceVariant-0d7_KjU", "setOnSurfaceVariant-8_81llA$material3_release", "onSurfaceVariant$delegate", "getOnTertiary-0d7_KjU", "setOnTertiary-8_81llA$material3_release", "onTertiary$delegate", "getOnTertiaryContainer-0d7_KjU", "setOnTertiaryContainer-8_81llA$material3_release", "onTertiaryContainer$delegate", "getOutline-0d7_KjU", "setOutline-8_81llA$material3_release", "outline$delegate", "getOutlineVariant-0d7_KjU", "setOutlineVariant-8_81llA$material3_release", "outlineVariant$delegate", "getPrimary-0d7_KjU", "setPrimary-8_81llA$material3_release", "primary$delegate", "getPrimaryContainer-0d7_KjU", "setPrimaryContainer-8_81llA$material3_release", "primaryContainer$delegate", "getScrim-0d7_KjU", "setScrim-8_81llA$material3_release", "scrim$delegate", "getSecondary-0d7_KjU", "setSecondary-8_81llA$material3_release", "secondary$delegate", "getSecondaryContainer-0d7_KjU", "setSecondaryContainer-8_81llA$material3_release", "secondaryContainer$delegate", "getSurface-0d7_KjU", "setSurface-8_81llA$material3_release", "surface$delegate", "getSurfaceTint-0d7_KjU", "setSurfaceTint-8_81llA$material3_release", "surfaceTint$delegate", "getSurfaceVariant-0d7_KjU", "setSurfaceVariant-8_81llA$material3_release", "surfaceVariant$delegate", "getTertiary-0d7_KjU", "setTertiary-8_81llA$material3_release", "tertiary$delegate", "getTertiaryContainer-0d7_KjU", "setTertiaryContainer-8_81llA$material3_release", "tertiaryContainer$delegate", "copy", "copy-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ColorScheme.kt */
public final class ColorScheme {
    public static final int $stable = 0;
    private final MutableState background$delegate;
    private final MutableState error$delegate;
    private final MutableState errorContainer$delegate;
    private final MutableState inverseOnSurface$delegate;
    private final MutableState inversePrimary$delegate;
    private final MutableState inverseSurface$delegate;
    private final MutableState onBackground$delegate;
    private final MutableState onError$delegate;
    private final MutableState onErrorContainer$delegate;
    private final MutableState onPrimary$delegate;
    private final MutableState onPrimaryContainer$delegate;
    private final MutableState onSecondary$delegate;
    private final MutableState onSecondaryContainer$delegate;
    private final MutableState onSurface$delegate;
    private final MutableState onSurfaceVariant$delegate;
    private final MutableState onTertiary$delegate;
    private final MutableState onTertiaryContainer$delegate;
    private final MutableState outline$delegate;
    private final MutableState outlineVariant$delegate;
    private final MutableState primary$delegate;
    private final MutableState primaryContainer$delegate;
    private final MutableState scrim$delegate;
    private final MutableState secondary$delegate;
    private final MutableState secondaryContainer$delegate;
    private final MutableState surface$delegate;
    private final MutableState surfaceTint$delegate;
    private final MutableState surfaceVariant$delegate;
    private final MutableState tertiary$delegate;
    private final MutableState tertiaryContainer$delegate;

    public /* synthetic */ ColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29);
    }

    private ColorScheme(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        this.primary$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(primary), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(onPrimary), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(primaryContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(onPrimaryContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.inversePrimary$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(inversePrimary), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(secondary), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(onSecondary), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(secondaryContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(onSecondaryContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.tertiary$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(tertiary), SnapshotStateKt.structuralEqualityPolicy());
        this.onTertiary$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(onTertiary), SnapshotStateKt.structuralEqualityPolicy());
        this.tertiaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(tertiaryContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.onTertiaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(onTertiaryContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.background$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(background), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(onBackground), SnapshotStateKt.structuralEqualityPolicy());
        this.surface$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(surface), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(onSurface), SnapshotStateKt.structuralEqualityPolicy());
        this.surfaceVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(surfaceVariant), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurfaceVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(onSurfaceVariant), SnapshotStateKt.structuralEqualityPolicy());
        this.surfaceTint$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(surfaceTint), SnapshotStateKt.structuralEqualityPolicy());
        this.inverseSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(inverseSurface), SnapshotStateKt.structuralEqualityPolicy());
        this.inverseOnSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(inverseOnSurface), SnapshotStateKt.structuralEqualityPolicy());
        this.error$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(error), SnapshotStateKt.structuralEqualityPolicy());
        this.onError$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(onError), SnapshotStateKt.structuralEqualityPolicy());
        this.errorContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(errorContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.onErrorContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(onErrorContainer), SnapshotStateKt.structuralEqualityPolicy());
        this.outline$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(outline), SnapshotStateKt.structuralEqualityPolicy());
        this.outlineVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(outlineVariant), SnapshotStateKt.structuralEqualityPolicy());
        this.scrim$delegate = SnapshotStateKt.mutableStateOf(Color.m4953boximpl(scrim), SnapshotStateKt.structuralEqualityPolicy());
    }

    /* renamed from: getPrimary-0d7_KjU  reason: not valid java name */
    public final long m3328getPrimary0d7_KjU() {
        return ((Color) this.primary$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setPrimary-8_81llA$material3_release  reason: not valid java name */
    public final void m3357setPrimary8_81llA$material3_release(long j) {
        this.primary$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getOnPrimary-0d7_KjU  reason: not valid java name */
    public final long m3318getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setOnPrimary-8_81llA$material3_release  reason: not valid java name */
    public final void m3347setOnPrimary8_81llA$material3_release(long j) {
        this.onPrimary$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getPrimaryContainer-0d7_KjU  reason: not valid java name */
    public final long m3329getPrimaryContainer0d7_KjU() {
        return ((Color) this.primaryContainer$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setPrimaryContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m3358setPrimaryContainer8_81llA$material3_release(long j) {
        this.primaryContainer$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getOnPrimaryContainer-0d7_KjU  reason: not valid java name */
    public final long m3319getOnPrimaryContainer0d7_KjU() {
        return ((Color) this.onPrimaryContainer$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setOnPrimaryContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m3348setOnPrimaryContainer8_81llA$material3_release(long j) {
        this.onPrimaryContainer$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getInversePrimary-0d7_KjU  reason: not valid java name */
    public final long m3313getInversePrimary0d7_KjU() {
        return ((Color) this.inversePrimary$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setInversePrimary-8_81llA$material3_release  reason: not valid java name */
    public final void m3342setInversePrimary8_81llA$material3_release(long j) {
        this.inversePrimary$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getSecondary-0d7_KjU  reason: not valid java name */
    public final long m3331getSecondary0d7_KjU() {
        return ((Color) this.secondary$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setSecondary-8_81llA$material3_release  reason: not valid java name */
    public final void m3360setSecondary8_81llA$material3_release(long j) {
        this.secondary$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getOnSecondary-0d7_KjU  reason: not valid java name */
    public final long m3320getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setOnSecondary-8_81llA$material3_release  reason: not valid java name */
    public final void m3349setOnSecondary8_81llA$material3_release(long j) {
        this.onSecondary$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getSecondaryContainer-0d7_KjU  reason: not valid java name */
    public final long m3332getSecondaryContainer0d7_KjU() {
        return ((Color) this.secondaryContainer$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setSecondaryContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m3361setSecondaryContainer8_81llA$material3_release(long j) {
        this.secondaryContainer$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getOnSecondaryContainer-0d7_KjU  reason: not valid java name */
    public final long m3321getOnSecondaryContainer0d7_KjU() {
        return ((Color) this.onSecondaryContainer$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setOnSecondaryContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m3350setOnSecondaryContainer8_81llA$material3_release(long j) {
        this.onSecondaryContainer$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getTertiary-0d7_KjU  reason: not valid java name */
    public final long m3336getTertiary0d7_KjU() {
        return ((Color) this.tertiary$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setTertiary-8_81llA$material3_release  reason: not valid java name */
    public final void m3365setTertiary8_81llA$material3_release(long j) {
        this.tertiary$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getOnTertiary-0d7_KjU  reason: not valid java name */
    public final long m3324getOnTertiary0d7_KjU() {
        return ((Color) this.onTertiary$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setOnTertiary-8_81llA$material3_release  reason: not valid java name */
    public final void m3353setOnTertiary8_81llA$material3_release(long j) {
        this.onTertiary$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getTertiaryContainer-0d7_KjU  reason: not valid java name */
    public final long m3337getTertiaryContainer0d7_KjU() {
        return ((Color) this.tertiaryContainer$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setTertiaryContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m3366setTertiaryContainer8_81llA$material3_release(long j) {
        this.tertiaryContainer$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getOnTertiaryContainer-0d7_KjU  reason: not valid java name */
    public final long m3325getOnTertiaryContainer0d7_KjU() {
        return ((Color) this.onTertiaryContainer$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setOnTertiaryContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m3354setOnTertiaryContainer8_81llA$material3_release(long j) {
        this.onTertiaryContainer$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getBackground-0d7_KjU  reason: not valid java name */
    public final long m3309getBackground0d7_KjU() {
        return ((Color) this.background$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setBackground-8_81llA$material3_release  reason: not valid java name */
    public final void m3338setBackground8_81llA$material3_release(long j) {
        this.background$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getOnBackground-0d7_KjU  reason: not valid java name */
    public final long m3315getOnBackground0d7_KjU() {
        return ((Color) this.onBackground$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setOnBackground-8_81llA$material3_release  reason: not valid java name */
    public final void m3344setOnBackground8_81llA$material3_release(long j) {
        this.onBackground$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getSurface-0d7_KjU  reason: not valid java name */
    public final long m3333getSurface0d7_KjU() {
        return ((Color) this.surface$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setSurface-8_81llA$material3_release  reason: not valid java name */
    public final void m3362setSurface8_81llA$material3_release(long j) {
        this.surface$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getOnSurface-0d7_KjU  reason: not valid java name */
    public final long m3322getOnSurface0d7_KjU() {
        return ((Color) this.onSurface$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setOnSurface-8_81llA$material3_release  reason: not valid java name */
    public final void m3351setOnSurface8_81llA$material3_release(long j) {
        this.onSurface$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getSurfaceVariant-0d7_KjU  reason: not valid java name */
    public final long m3335getSurfaceVariant0d7_KjU() {
        return ((Color) this.surfaceVariant$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setSurfaceVariant-8_81llA$material3_release  reason: not valid java name */
    public final void m3364setSurfaceVariant8_81llA$material3_release(long j) {
        this.surfaceVariant$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getOnSurfaceVariant-0d7_KjU  reason: not valid java name */
    public final long m3323getOnSurfaceVariant0d7_KjU() {
        return ((Color) this.onSurfaceVariant$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setOnSurfaceVariant-8_81llA$material3_release  reason: not valid java name */
    public final void m3352setOnSurfaceVariant8_81llA$material3_release(long j) {
        this.onSurfaceVariant$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getSurfaceTint-0d7_KjU  reason: not valid java name */
    public final long m3334getSurfaceTint0d7_KjU() {
        return ((Color) this.surfaceTint$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setSurfaceTint-8_81llA$material3_release  reason: not valid java name */
    public final void m3363setSurfaceTint8_81llA$material3_release(long j) {
        this.surfaceTint$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getInverseSurface-0d7_KjU  reason: not valid java name */
    public final long m3314getInverseSurface0d7_KjU() {
        return ((Color) this.inverseSurface$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setInverseSurface-8_81llA$material3_release  reason: not valid java name */
    public final void m3343setInverseSurface8_81llA$material3_release(long j) {
        this.inverseSurface$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getInverseOnSurface-0d7_KjU  reason: not valid java name */
    public final long m3312getInverseOnSurface0d7_KjU() {
        return ((Color) this.inverseOnSurface$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setInverseOnSurface-8_81llA$material3_release  reason: not valid java name */
    public final void m3341setInverseOnSurface8_81llA$material3_release(long j) {
        this.inverseOnSurface$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getError-0d7_KjU  reason: not valid java name */
    public final long m3310getError0d7_KjU() {
        return ((Color) this.error$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setError-8_81llA$material3_release  reason: not valid java name */
    public final void m3339setError8_81llA$material3_release(long j) {
        this.error$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getOnError-0d7_KjU  reason: not valid java name */
    public final long m3316getOnError0d7_KjU() {
        return ((Color) this.onError$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setOnError-8_81llA$material3_release  reason: not valid java name */
    public final void m3345setOnError8_81llA$material3_release(long j) {
        this.onError$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getErrorContainer-0d7_KjU  reason: not valid java name */
    public final long m3311getErrorContainer0d7_KjU() {
        return ((Color) this.errorContainer$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setErrorContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m3340setErrorContainer8_81llA$material3_release(long j) {
        this.errorContainer$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getOnErrorContainer-0d7_KjU  reason: not valid java name */
    public final long m3317getOnErrorContainer0d7_KjU() {
        return ((Color) this.onErrorContainer$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setOnErrorContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m3346setOnErrorContainer8_81llA$material3_release(long j) {
        this.onErrorContainer$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getOutline-0d7_KjU  reason: not valid java name */
    public final long m3326getOutline0d7_KjU() {
        return ((Color) this.outline$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setOutline-8_81llA$material3_release  reason: not valid java name */
    public final void m3355setOutline8_81llA$material3_release(long j) {
        this.outline$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getOutlineVariant-0d7_KjU  reason: not valid java name */
    public final long m3327getOutlineVariant0d7_KjU() {
        return ((Color) this.outlineVariant$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setOutlineVariant-8_81llA$material3_release  reason: not valid java name */
    public final void m3356setOutlineVariant8_81llA$material3_release(long j) {
        this.outlineVariant$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: getScrim-0d7_KjU  reason: not valid java name */
    public final long m3330getScrim0d7_KjU() {
        return ((Color) this.scrim$delegate.getValue()).m4973unboximpl();
    }

    /* renamed from: setScrim-8_81llA$material3_release  reason: not valid java name */
    public final void m3359setScrim8_81llA$material3_release(long j) {
        this.scrim$delegate.setValue(Color.m4953boximpl(j));
    }

    /* renamed from: copy-G1PFc-w$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m3307copyG1PFcw$default(ColorScheme colorScheme, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long j30;
        long j31;
        long j32;
        long j33;
        long j34;
        long j35;
        long j36;
        long j37;
        long j38;
        long j39;
        long j40;
        long j41;
        long j42;
        long j43;
        long j44;
        long j45;
        long j46;
        long j47;
        long j48;
        long j49;
        long j50;
        long j51;
        long j52;
        long j53;
        long j54;
        long j55;
        long j56;
        long j57;
        long j58;
        int i2 = i;
        if ((i2 & 1) != 0) {
            j30 = colorScheme.m3328getPrimary0d7_KjU();
        } else {
            j30 = j;
        }
        if ((i2 & 2) != 0) {
            j31 = colorScheme.m3318getOnPrimary0d7_KjU();
        } else {
            j31 = j2;
        }
        if ((i2 & 4) != 0) {
            j32 = colorScheme.m3329getPrimaryContainer0d7_KjU();
        } else {
            j32 = j3;
        }
        if ((i2 & 8) != 0) {
            j33 = colorScheme.m3319getOnPrimaryContainer0d7_KjU();
        } else {
            j33 = j4;
        }
        if ((i2 & 16) != 0) {
            j34 = colorScheme.m3313getInversePrimary0d7_KjU();
        } else {
            j34 = j5;
        }
        if ((i2 & 32) != 0) {
            j35 = colorScheme.m3331getSecondary0d7_KjU();
        } else {
            j35 = j6;
        }
        if ((i2 & 64) != 0) {
            j36 = colorScheme.m3320getOnSecondary0d7_KjU();
        } else {
            j36 = j7;
        }
        if ((i2 & 128) != 0) {
            j37 = colorScheme.m3332getSecondaryContainer0d7_KjU();
        } else {
            j37 = j8;
        }
        long j59 = j37;
        if ((i2 & 256) != 0) {
            j38 = colorScheme.m3321getOnSecondaryContainer0d7_KjU();
        } else {
            j38 = j9;
        }
        long j60 = j38;
        if ((i2 & 512) != 0) {
            j39 = colorScheme.m3336getTertiary0d7_KjU();
        } else {
            j39 = j10;
        }
        long j61 = j39;
        if ((i2 & 1024) != 0) {
            j40 = colorScheme.m3324getOnTertiary0d7_KjU();
        } else {
            j40 = j11;
        }
        long j62 = j40;
        if ((i2 & 2048) != 0) {
            j41 = colorScheme.m3337getTertiaryContainer0d7_KjU();
        } else {
            j41 = j12;
        }
        long j63 = j41;
        if ((i2 & 4096) != 0) {
            j42 = colorScheme.m3325getOnTertiaryContainer0d7_KjU();
        } else {
            j42 = j13;
        }
        long j64 = j42;
        if ((i2 & 8192) != 0) {
            j43 = colorScheme.m3309getBackground0d7_KjU();
        } else {
            j43 = j14;
        }
        long j65 = j43;
        if ((i2 & 16384) != 0) {
            j44 = colorScheme.m3315getOnBackground0d7_KjU();
        } else {
            j44 = j15;
        }
        if ((i2 & 32768) != 0) {
            j45 = colorScheme.m3333getSurface0d7_KjU();
        } else {
            j45 = j16;
        }
        if ((i2 & 65536) != 0) {
            j46 = colorScheme.m3322getOnSurface0d7_KjU();
        } else {
            j46 = j17;
        }
        if ((i2 & 131072) != 0) {
            j47 = colorScheme.m3335getSurfaceVariant0d7_KjU();
        } else {
            j47 = j18;
        }
        if ((i2 & 262144) != 0) {
            j48 = colorScheme.m3323getOnSurfaceVariant0d7_KjU();
        } else {
            j48 = j19;
        }
        if ((i2 & 524288) != 0) {
            j49 = colorScheme.m3334getSurfaceTint0d7_KjU();
        } else {
            j49 = j20;
        }
        if ((i2 & 1048576) != 0) {
            j50 = colorScheme.m3314getInverseSurface0d7_KjU();
        } else {
            j50 = j21;
        }
        if ((i2 & 2097152) != 0) {
            j51 = colorScheme.m3312getInverseOnSurface0d7_KjU();
        } else {
            j51 = j22;
        }
        if ((i2 & 4194304) != 0) {
            j52 = colorScheme.m3310getError0d7_KjU();
        } else {
            j52 = j23;
        }
        if ((i2 & 8388608) != 0) {
            j53 = colorScheme.m3316getOnError0d7_KjU();
        } else {
            j53 = j24;
        }
        if ((i2 & 16777216) != 0) {
            j54 = colorScheme.m3311getErrorContainer0d7_KjU();
        } else {
            j54 = j25;
        }
        if ((i2 & 33554432) != 0) {
            j55 = colorScheme.m3317getOnErrorContainer0d7_KjU();
        } else {
            j55 = j26;
        }
        if ((i2 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0) {
            j56 = colorScheme.m3326getOutline0d7_KjU();
        } else {
            j56 = j27;
        }
        if ((i2 & 134217728) != 0) {
            j57 = colorScheme.m3327getOutlineVariant0d7_KjU();
        } else {
            j57 = j28;
        }
        if ((i2 & 268435456) != 0) {
            j58 = colorScheme.m3330getScrim0d7_KjU();
        } else {
            j58 = j29;
        }
        return colorScheme.m3308copyG1PFcw(j30, j31, j32, j33, j34, j35, j36, j59, j60, j61, j62, j63, j64, j65, j44, j45, j46, j47, j48, j49, j50, j51, j52, j53, j54, j55, j56, j57, j58);
    }

    /* renamed from: copy-G1PFc-w  reason: not valid java name */
    public final ColorScheme m3308copyG1PFcw(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        return new ColorScheme(primary, onPrimary, primaryContainer, onPrimaryContainer, inversePrimary, secondary, onSecondary, secondaryContainer, onSecondaryContainer, tertiary, onTertiary, tertiaryContainer, onTertiaryContainer, background, onBackground, surface, onSurface, surfaceVariant, onSurfaceVariant, surfaceTint, inverseSurface, inverseOnSurface, error, onError, errorContainer, onErrorContainer, outline, outlineVariant, scrim, (DefaultConstructorMarker) null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorScheme(primary=").append(Color.m4971toStringimpl(m3328getPrimary0d7_KjU())).append("onPrimary=").append(Color.m4971toStringimpl(m3318getOnPrimary0d7_KjU())).append("primaryContainer=").append(Color.m4971toStringimpl(m3329getPrimaryContainer0d7_KjU())).append("onPrimaryContainer=").append(Color.m4971toStringimpl(m3319getOnPrimaryContainer0d7_KjU())).append("inversePrimary=").append(Color.m4971toStringimpl(m3313getInversePrimary0d7_KjU())).append("secondary=").append(Color.m4971toStringimpl(m3331getSecondary0d7_KjU())).append("onSecondary=").append(Color.m4971toStringimpl(m3320getOnSecondary0d7_KjU())).append("secondaryContainer=").append(Color.m4971toStringimpl(m3332getSecondaryContainer0d7_KjU())).append("onSecondaryContainer=").append(Color.m4971toStringimpl(m3321getOnSecondaryContainer0d7_KjU())).append("tertiary=").append(Color.m4971toStringimpl(m3336getTertiary0d7_KjU())).append("onTertiary=").append(Color.m4971toStringimpl(m3324getOnTertiary0d7_KjU())).append("tertiaryContainer=");
        sb.append(Color.m4971toStringimpl(m3337getTertiaryContainer0d7_KjU())).append("onTertiaryContainer=").append(Color.m4971toStringimpl(m3325getOnTertiaryContainer0d7_KjU())).append("background=").append(Color.m4971toStringimpl(m3309getBackground0d7_KjU())).append("onBackground=").append(Color.m4971toStringimpl(m3315getOnBackground0d7_KjU())).append("surface=").append(Color.m4971toStringimpl(m3333getSurface0d7_KjU())).append("onSurface=").append(Color.m4971toStringimpl(m3322getOnSurface0d7_KjU())).append("surfaceVariant=").append(Color.m4971toStringimpl(m3335getSurfaceVariant0d7_KjU())).append("onSurfaceVariant=").append(Color.m4971toStringimpl(m3323getOnSurfaceVariant0d7_KjU())).append("surfaceTint=").append(Color.m4971toStringimpl(m3334getSurfaceTint0d7_KjU())).append("inverseSurface=").append(Color.m4971toStringimpl(m3314getInverseSurface0d7_KjU())).append("inverseOnSurface=").append(Color.m4971toStringimpl(m3312getInverseOnSurface0d7_KjU())).append("error=").append(Color.m4971toStringimpl(m3310getError0d7_KjU()));
        sb.append("onError=").append(Color.m4971toStringimpl(m3316getOnError0d7_KjU())).append("errorContainer=").append(Color.m4971toStringimpl(m3311getErrorContainer0d7_KjU())).append("onErrorContainer=").append(Color.m4971toStringimpl(m3317getOnErrorContainer0d7_KjU())).append("outline=").append(Color.m4971toStringimpl(m3326getOutline0d7_KjU())).append("outlineVariant=").append(Color.m4971toStringimpl(m3327getOutlineVariant0d7_KjU())).append("scrim=").append(Color.m4971toStringimpl(m3330getScrim0d7_KjU())).append(')');
        return sb.toString();
    }
}

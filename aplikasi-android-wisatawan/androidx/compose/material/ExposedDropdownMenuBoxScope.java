package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.internal.ExposedDropdownMenuPopupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001JU\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0017¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exposedDropdownSize", "matchTextFieldWidth", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
public interface ExposedDropdownMenuBoxScope {
    Modifier exposedDropdownSize(Modifier modifier, boolean z);

    static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ExposedDropdownMenu.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static void ExposedDropdownMenu(ExposedDropdownMenuBoxScope $this, boolean expanded, Function0<Unit> onDismissRequest, Modifier modifier, ScrollState scrollState, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
            Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
            Intrinsics.checkNotNullParameter(content, "content");
            ExposedDropdownMenuBoxScope.super.ExposedDropdownMenu(expanded, onDismissRequest, modifier, scrollState, content, $composer, $changed, i);
        }
    }

    void ExposedDropdownMenu(boolean expanded, Function0<Unit> onDismissRequest, Modifier modifier, ScrollState scrollState, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        ScrollState scrollState2;
        ScrollState scrollState3;
        Modifier modifier3;
        int $dirty;
        Object value$iv$iv;
        Object value$iv$iv2;
        Function2 value$iv$iv3;
        Modifier modifier4;
        int i2;
        Function0<Unit> function0 = onDismissRequest;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i3 = $changed;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(1081438217);
        ComposerKt.sourceInformation($composer2, "C(ExposedDropdownMenu)P(1,3,2,4)236@9131L21,248@9631L42,252@9833L51,253@9924L7,257@10071L139,261@10224L491:ExposedDropdownMenu.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
            boolean z = expanded;
        } else if ((i3 & 14) == 0) {
            $dirty2 |= $composer2.changed(expanded) ? 4 : 2;
        } else {
            boolean z2 = expanded;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i3 & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if ((i3 & 896) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed((Object) modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i3 & 7168) == 0) {
            if ((i & 8) == 0) {
                scrollState2 = scrollState;
                if ($composer2.changed((Object) scrollState2)) {
                    i2 = 2048;
                    $dirty2 |= i2;
                }
            } else {
                scrollState2 = scrollState;
            }
            i2 = 1024;
            $dirty2 |= i2;
        } else {
            scrollState2 = scrollState;
        }
        if ((i & 16) != 0) {
            $dirty2 |= 24576;
        } else if ((57344 & i3) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((458752 & i3) == 0) {
            $dirty2 |= $composer2.changed((Object) this) ? 131072 : 65536;
        }
        if ((374491 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 8) != 0) {
                    $dirty = $dirty2 & -7169;
                    modifier3 = modifier4;
                    scrollState3 = ScrollKt.rememberScrollState(0, $composer2, 0, 1);
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    scrollState3 = scrollState2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                scrollState3 = scrollState2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1081438217, $dirty, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:232)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new MutableTransitionState(false);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            MutableTransitionState expandedStates = (MutableTransitionState) value$iv$iv;
            expandedStates.setTargetState(Boolean.valueOf(expanded));
            if (((Boolean) expandedStates.getCurrentState()).booleanValue() || ((Boolean) expandedStates.getTargetState()).booleanValue()) {
                $composer2.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                Composer $this$cache$iv$iv2 = $composer2;
                Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
                if (it$iv$iv2 == Composer.Companion.getEmpty()) {
                    value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3667boximpl(TransformOrigin.Companion.m3680getCenterSzJe1aQ()), (SnapshotMutationPolicy) null, 2, (Object) null);
                    $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv2;
                }
                $composer2.endReplaceableGroup();
                MutableState transformOriginState = (MutableState) value$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density density = (Density) consume;
                long r18 = DpOffset.Companion.m5915getZeroRKDOV3M();
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changed((Object) transformOriginState);
                Composer $this$cache$iv$iv3 = $composer2;
                Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
                if (!invalid$iv$iv) {
                    if (it$iv$iv3 != Composer.Companion.getEmpty()) {
                        value$iv$iv3 = it$iv$iv3;
                        $composer2.endReplaceableGroup();
                        MutableTransitionState mutableTransitionState = expandedStates;
                        ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 exposedDropdownMenuBoxScope$ExposedDropdownMenu$1 = r0;
                        int $dirty3 = $dirty;
                        MutableState mutableState = transformOriginState;
                        ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 exposedDropdownMenuBoxScope$ExposedDropdownMenu$12 = new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1(expandedStates, transformOriginState, scrollState3, this, modifier3, content, $dirty3);
                        ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(onDismissRequest, new DropdownMenuPositionProvider(r18, density, value$iv$iv3, (DefaultConstructorMarker) null), ComposableLambdaKt.composableLambda($composer2, -1167205969, true, exposedDropdownMenuBoxScope$ExposedDropdownMenu$1), $composer2, (($dirty3 >> 3) & 14) | 384, 0);
                    }
                }
                value$iv$iv3 = new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1(transformOriginState);
                $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
                $composer2.endReplaceableGroup();
                MutableTransitionState mutableTransitionState2 = expandedStates;
                ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 exposedDropdownMenuBoxScope$ExposedDropdownMenu$13 = exposedDropdownMenuBoxScope$ExposedDropdownMenu$12;
                int $dirty32 = $dirty;
                MutableState mutableState2 = transformOriginState;
                ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 exposedDropdownMenuBoxScope$ExposedDropdownMenu$122 = new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1(expandedStates, transformOriginState, scrollState3, this, modifier3, content, $dirty32);
                ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(onDismissRequest, new DropdownMenuPositionProvider(r18, density, value$iv$iv3, (DefaultConstructorMarker) null), ComposableLambdaKt.composableLambda($composer2, -1167205969, true, exposedDropdownMenuBoxScope$ExposedDropdownMenu$13), $composer2, (($dirty32 >> 3) & 14) | 384, 0);
            } else {
                int i5 = $dirty;
                MutableTransitionState mutableTransitionState3 = expandedStates;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            int i6 = $dirty2;
            modifier3 = modifier2;
            scrollState3 = scrollState2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2(this, expanded, onDismissRequest, modifier3, scrollState3, content, $changed, i));
        }
    }
}

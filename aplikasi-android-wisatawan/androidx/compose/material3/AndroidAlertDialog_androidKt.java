package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aâ\u0001\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aB\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u001d\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"ButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonsMainAxisSpacing", "AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-Oix01E0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "content", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidAlertDialog.android.kt */
public final class AndroidAlertDialog_androidKt {
    /* access modifiers changed from: private */
    public static final float ButtonsCrossAxisSpacing = Dp.m5844constructorimpl((float) 12);
    /* access modifiers changed from: private */
    public static final float ButtonsMainAxisSpacing = Dp.m5844constructorimpl((float) 8);

    /* renamed from: AlertDialog-Oix01E0  reason: not valid java name */
    public static final void m1534AlertDialogOix01E0(Function0<Unit> onDismissRequest, Function2<? super Composer, ? super Integer, Unit> confirmButton, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> dismissButton, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> text, Shape shape, long containerColor, long iconContentColor, long titleContentColor, long textContentColor, float tonalElevation, DialogProperties properties, Composer $composer, int $changed, int $changed1, int i) {
        Function2 title2;
        Function2 text2;
        Shape shape2;
        DialogProperties properties2;
        float tonalElevation2;
        long textContentColor2;
        long titleContentColor2;
        long iconContentColor2;
        long containerColor2;
        Shape shape3;
        Function2 text3;
        Function2 title3;
        Function2 icon2;
        Function2 dismissButton2;
        Modifier modifier2;
        int $dirty1;
        int $dirty;
        long iconContentColor3;
        Function2 dismissButton3;
        long containerColor3;
        Function2 icon3;
        Modifier modifier3;
        Modifier modifier4;
        Function2 icon4;
        long containerColor4;
        long iconContentColor4;
        long titleContentColor3;
        long textContentColor3;
        float tonalElevation3;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Function0<Unit> function0 = onDismissRequest;
        Function2<? super Composer, ? super Integer, Unit> function2 = confirmButton;
        int i7 = $changed;
        int i8 = $changed1;
        int i9 = i;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function2, "confirmButton");
        Composer $composer2 = $composer.startRestartGroup(-2081346864);
        ComposerKt.sourceInformation($composer2, "C(AlertDialog)P(6!1,5,2,3,11,9,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,10:c#ui.graphics.Color,13:c#ui.unit.Dp)84@4214L5,85@4269L14,86@4335L16,87@4404L17,88@4473L16,91@4610L1104:AndroidAlertDialog.android.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty12 = $changed1;
        if ((i9 & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i7 & 14) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        if ((i9 & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i7 & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        int i10 = i9 & 4;
        if (i10 != 0) {
            $dirty2 |= 384;
            Modifier modifier5 = modifier;
        } else if ((i7 & 896) == 0) {
            $dirty2 |= $composer2.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier6 = modifier;
        }
        int i11 = i9 & 8;
        int i12 = 2048;
        if (i11 != 0) {
            $dirty2 |= 3072;
            Function2<? super Composer, ? super Integer, Unit> function22 = dismissButton;
        } else if ((i7 & 7168) == 0) {
            $dirty2 |= $composer2.changedInstance(dismissButton) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = dismissButton;
        }
        int i13 = i9 & 16;
        if (i13 != 0) {
            $dirty2 |= 24576;
            Function2<? super Composer, ? super Integer, Unit> function24 = icon;
        } else if ((i7 & 57344) == 0) {
            $dirty2 |= $composer2.changedInstance(icon) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function25 = icon;
        }
        int i14 = i9 & 32;
        if (i14 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            title2 = title;
        } else if ((i7 & 458752) == 0) {
            title2 = title;
            $dirty2 |= $composer2.changedInstance(title2) ? 131072 : 65536;
        } else {
            title2 = title;
        }
        int i15 = i9 & 64;
        if (i15 != 0) {
            $dirty2 |= 1572864;
            text2 = text;
        } else if ((i7 & 3670016) == 0) {
            text2 = text;
            $dirty2 |= $composer2.changedInstance(text2) ? 1048576 : 524288;
        } else {
            text2 = text;
        }
        if ((i7 & 29360128) == 0) {
            if ((i9 & 128) == 0) {
                shape2 = shape;
                if ($composer2.changed((Object) shape2)) {
                    i6 = 8388608;
                    $dirty2 |= i6;
                }
            } else {
                shape2 = shape;
            }
            i6 = 4194304;
            $dirty2 |= i6;
        } else {
            shape2 = shape;
        }
        if ((i7 & 234881024) == 0) {
            if ((i9 & 256) != 0) {
                long j = containerColor;
            } else if ($composer2.changed(containerColor)) {
                i5 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty2 |= i5;
            }
            i5 = 33554432;
            $dirty2 |= i5;
        } else {
            long j2 = containerColor;
        }
        if ((1879048192 & i7) == 0) {
            if ((i9 & 512) != 0) {
                long j3 = iconContentColor;
            } else if ($composer2.changed(iconContentColor)) {
                i4 = 536870912;
                $dirty2 |= i4;
            }
            i4 = 268435456;
            $dirty2 |= i4;
        } else {
            long j4 = iconContentColor;
        }
        if ((i8 & 14) == 0) {
            if ((i9 & 1024) != 0) {
                long j5 = titleContentColor;
            } else if ($composer2.changed(titleContentColor)) {
                i3 = 4;
                $dirty12 |= i3;
            }
            i3 = 2;
            $dirty12 |= i3;
        } else {
            long j6 = titleContentColor;
        }
        if ((i8 & 112) == 0) {
            if ((i9 & 2048) != 0) {
                long j7 = textContentColor;
            } else if ($composer2.changed(textContentColor)) {
                i2 = 32;
                $dirty12 |= i2;
            }
            i2 = 16;
            $dirty12 |= i2;
        } else {
            long j8 = textContentColor;
        }
        int i16 = i9 & 4096;
        if (i16 != 0) {
            $dirty12 |= 384;
            float f = tonalElevation;
        } else if ((i8 & 896) == 0) {
            $dirty12 |= $composer2.changed(tonalElevation) ? 256 : 128;
        } else {
            float f2 = tonalElevation;
        }
        int i17 = i9 & 8192;
        if (i17 != 0) {
            $dirty12 |= 3072;
            DialogProperties dialogProperties = properties;
        } else if ((i8 & 7168) == 0) {
            if (!$composer2.changed((Object) properties)) {
                i12 = 1024;
            }
            $dirty12 |= i12;
        } else {
            DialogProperties dialogProperties2 = properties;
        }
        if (($dirty2 & 1533916891) == 306783378 && ($dirty12 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            dismissButton2 = dismissButton;
            icon2 = icon;
            containerColor2 = containerColor;
            iconContentColor2 = iconContentColor;
            titleContentColor2 = titleContentColor;
            textContentColor2 = textContentColor;
            tonalElevation2 = tonalElevation;
            properties2 = properties;
            int i18 = $dirty2;
            int i19 = $dirty12;
            title3 = title2;
            text3 = text2;
            shape3 = shape2;
        } else {
            $composer2.startDefaults();
            if ((i7 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i10 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier;
                }
                if (i11 != 0) {
                    dismissButton3 = null;
                } else {
                    dismissButton3 = dismissButton;
                }
                if (i13 != 0) {
                    icon4 = null;
                } else {
                    icon4 = icon;
                }
                if (i14 != 0) {
                    title2 = null;
                }
                if (i15 != 0) {
                    text2 = null;
                }
                Modifier modifier7 = modifier4;
                if ((i9 & 128) != 0) {
                    $dirty2 &= -29360129;
                    shape2 = AlertDialogDefaults.INSTANCE.getShape($composer2, 6);
                }
                if ((i9 & 256) != 0) {
                    containerColor4 = AlertDialogDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty2 &= -234881025;
                } else {
                    containerColor4 = containerColor;
                }
                if ((i9 & 512) != 0) {
                    iconContentColor4 = AlertDialogDefaults.INSTANCE.getIconContentColor($composer2, 6);
                    $dirty2 &= -1879048193;
                } else {
                    iconContentColor4 = iconContentColor;
                }
                if ((i9 & 1024) != 0) {
                    titleContentColor3 = AlertDialogDefaults.INSTANCE.getTitleContentColor($composer2, 6);
                    $dirty12 &= -15;
                } else {
                    titleContentColor3 = titleContentColor;
                }
                if ((i9 & 2048) != 0) {
                    textContentColor3 = AlertDialogDefaults.INSTANCE.getTextContentColor($composer2, 6);
                    $dirty12 &= -113;
                } else {
                    textContentColor3 = textContentColor;
                }
                if (i16 != 0) {
                    tonalElevation3 = AlertDialogDefaults.INSTANCE.m1530getTonalElevationD9Ej5fM();
                } else {
                    tonalElevation3 = tonalElevation;
                }
                if (i17 != 0) {
                    tonalElevation2 = tonalElevation3;
                    $dirty = $dirty2;
                    $dirty1 = $dirty12;
                    properties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                    icon3 = icon4;
                    containerColor3 = containerColor4;
                    iconContentColor3 = iconContentColor4;
                    titleContentColor2 = titleContentColor3;
                    textContentColor2 = textContentColor3;
                    modifier3 = modifier7;
                } else {
                    properties2 = properties;
                    tonalElevation2 = tonalElevation3;
                    $dirty = $dirty2;
                    $dirty1 = $dirty12;
                    icon3 = icon4;
                    containerColor3 = containerColor4;
                    iconContentColor3 = iconContentColor4;
                    titleContentColor2 = titleContentColor3;
                    textContentColor2 = textContentColor3;
                    modifier3 = modifier7;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i9 & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                if ((i9 & 256) != 0) {
                    $dirty2 &= -234881025;
                }
                if ((i9 & 512) != 0) {
                    $dirty2 &= -1879048193;
                }
                if ((i9 & 1024) != 0) {
                    $dirty12 &= -15;
                }
                if ((i9 & 2048) != 0) {
                    int i20 = $dirty12 & -113;
                    dismissButton3 = dismissButton;
                    containerColor3 = containerColor;
                    iconContentColor3 = iconContentColor;
                    titleContentColor2 = titleContentColor;
                    textContentColor2 = textContentColor;
                    tonalElevation2 = tonalElevation;
                    properties2 = properties;
                    $dirty1 = i20;
                    $dirty = $dirty2;
                    modifier3 = modifier;
                    icon3 = icon;
                } else {
                    modifier3 = modifier;
                    dismissButton3 = dismissButton;
                    iconContentColor3 = iconContentColor;
                    titleContentColor2 = titleContentColor;
                    textContentColor2 = textContentColor;
                    tonalElevation2 = tonalElevation;
                    properties2 = properties;
                    $dirty = $dirty2;
                    $dirty1 = $dirty12;
                    icon3 = icon;
                    containerColor3 = containerColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2081346864, $dirty, $dirty1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
            }
            Function2 icon5 = icon3;
            AlertDialog(onDismissRequest, modifier3, properties2, ComposableLambdaKt.composableLambda($composer2, 741647174, true, new AndroidAlertDialog_androidKt$AlertDialog$1(icon3, title2, text2, shape2, containerColor3, tonalElevation2, iconContentColor3, titleContentColor2, textContentColor2, $dirty, $dirty1, dismissButton3, confirmButton)), $composer2, ($dirty & 14) | 3072 | (($dirty >> 3) & 112) | (($dirty1 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            icon2 = icon5;
            modifier2 = modifier3;
            containerColor2 = containerColor3;
            dismissButton2 = dismissButton3;
            iconContentColor2 = iconContentColor3;
            title3 = title2;
            text3 = text2;
            shape3 = shape2;
            int i21 = $dirty;
            int i22 = $dirty1;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$2(onDismissRequest, confirmButton, modifier2, dismissButton2, icon2, title3, text3, shape3, containerColor2, iconContentColor2, titleContentColor2, textContentColor2, tonalElevation2, properties2, $changed, $changed1, i));
    }

    public static final void AlertDialog(Function0<Unit> onDismissRequest, Modifier modifier, DialogProperties properties, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        DialogProperties dialogProperties;
        DialogProperties properties2;
        Modifier modifier3;
        Modifier modifier4;
        DialogProperties properties3;
        Function0<Unit> function0 = onDismissRequest;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(63450171);
        ComposerKt.sourceInformation($composer2, "C(AlertDialog)P(2,1,3)150@7189L452:AndroidAlertDialog.android.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            dialogProperties = properties;
        } else if ((i2 & 896) == 0) {
            dialogProperties = properties;
            $dirty |= $composer2.changed((Object) dialogProperties) ? 256 : 128;
        } else {
            dialogProperties = properties;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                properties3 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
            } else {
                properties3 = dialogProperties;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(63450171, $dirty2, -1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:144)");
            }
            AndroidDialog_androidKt.Dialog(onDismissRequest, properties3, ComposableLambdaKt.composableLambda($composer2, 823217604, true, new AndroidAlertDialog_androidKt$AlertDialog$3(modifier4, function2, $dirty2)), $composer2, ($dirty2 & 14) | 384 | (($dirty2 >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            properties2 = properties3;
            modifier3 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            properties2 = dialogProperties;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(onDismissRequest, modifier3, properties2, content, $changed, i));
        }
    }
}

package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000J\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Landroidx/compose/material/ElevationDefaults;", "", "()V", "incomingAnimationSpecForInteraction", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/ui/unit/Dp;", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "outgoingAnimationSpecForInteraction", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Elevation.kt */
final class ElevationDefaults {
    public static final ElevationDefaults INSTANCE = new ElevationDefaults();

    private ElevationDefaults() {
    }

    public final AnimationSpec<Dp> incomingAnimationSpecForInteraction(Interaction interaction) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        if (interaction instanceof PressInteraction.Press) {
            return ElevationKt.DefaultIncomingSpec;
        }
        if (interaction instanceof DragInteraction.Start) {
            return ElevationKt.DefaultIncomingSpec;
        }
        if (interaction instanceof HoverInteraction.Enter) {
            return ElevationKt.DefaultIncomingSpec;
        }
        if (interaction instanceof FocusInteraction.Focus) {
            return ElevationKt.DefaultIncomingSpec;
        }
        return null;
    }

    public final AnimationSpec<Dp> outgoingAnimationSpecForInteraction(Interaction interaction) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        if (interaction instanceof PressInteraction.Press) {
            return ElevationKt.DefaultOutgoingSpec;
        }
        if (interaction instanceof DragInteraction.Start) {
            return ElevationKt.DefaultOutgoingSpec;
        }
        if (interaction instanceof HoverInteraction.Enter) {
            return ElevationKt.HoveredOutgoingSpec;
        }
        if (interaction instanceof FocusInteraction.Focus) {
            return ElevationKt.DefaultOutgoingSpec;
        }
        return null;
    }
}

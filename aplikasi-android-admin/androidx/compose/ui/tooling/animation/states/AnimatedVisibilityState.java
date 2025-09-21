package androidx.compose.ui.tooling.animation.states;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b@\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/tooling/animation/states/AnimatedVisibilityState;", "Landroidx/compose/ui/tooling/animation/states/ComposeAnimationState;", "value", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "Companion", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: AnimatedVisibilityState.kt */
public final class AnimatedVisibilityState implements ComposeAnimationState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String Enter = m7478constructorimpl("Enter");
    /* access modifiers changed from: private */
    public static final String Exit = m7478constructorimpl("Exit");
    private final String value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ AnimatedVisibilityState m7477boximpl(String str) {
        return new AnimatedVisibilityState(str);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static String m7478constructorimpl(String str) {
        return str;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7479equalsimpl(String str, Object obj) {
        return (obj instanceof AnimatedVisibilityState) && Intrinsics.areEqual((Object) str, (Object) ((AnimatedVisibilityState) obj).m7483unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7480equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual((Object) str, (Object) str2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7481hashCodeimpl(String str) {
        return str.hashCode();
    }

    public boolean equals(Object obj) {
        return m7479equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m7481hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ String m7483unboximpl() {
        return this.value;
    }

    private /* synthetic */ AnimatedVisibilityState(String value2) {
        this.value = value2;
    }

    public final String getValue() {
        return this.value;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7482toStringimpl(String arg0) {
        return arg0;
    }

    public String toString() {
        return m7482toStringimpl(this.value);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/tooling/animation/states/AnimatedVisibilityState$Companion;", "", "()V", "Enter", "Landroidx/compose/ui/tooling/animation/states/AnimatedVisibilityState;", "getEnter-jXw82LU", "()Ljava/lang/String;", "Ljava/lang/String;", "Exit", "getExit-jXw82LU", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimatedVisibilityState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getEnter-jXw82LU  reason: not valid java name */
        public final String m7484getEnterjXw82LU() {
            return AnimatedVisibilityState.Enter;
        }

        /* renamed from: getExit-jXw82LU  reason: not valid java name */
        public final String m7485getExitjXw82LU() {
            return AnimatedVisibilityState.Exit;
        }
    }
}

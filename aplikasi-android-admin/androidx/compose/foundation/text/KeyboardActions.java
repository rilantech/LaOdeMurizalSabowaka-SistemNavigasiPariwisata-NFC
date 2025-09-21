package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B³\u0001\u0012\u001b\b\u0002\u0010\u0002\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006\u0012\u001b\b\u0002\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006\u0012\u001b\b\u0002\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006\u0012\u001b\b\u0002\u0010\t\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006\u0012\u001b\b\u0002\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006\u0012\u001b\b\u0002\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\fJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R$\u0010\u0002\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR$\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR$\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR$\u0010\t\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR$\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR$\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/KeyboardActions;", "", "onDone", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/KeyboardActionScope;", "", "Lkotlin/ExtensionFunctionType;", "onGo", "onNext", "onPrevious", "onSearch", "onSend", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnDone", "()Lkotlin/jvm/functions/Function1;", "getOnGo", "getOnNext", "getOnPrevious", "getOnSearch", "getOnSend", "equals", "", "other", "hashCode", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeyboardActions.kt */
public final class KeyboardActions {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final KeyboardActions Default = new KeyboardActions((Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, 63, (DefaultConstructorMarker) null);
    private final Function1<KeyboardActionScope, Unit> onDone;
    private final Function1<KeyboardActionScope, Unit> onGo;
    private final Function1<KeyboardActionScope, Unit> onNext;
    private final Function1<KeyboardActionScope, Unit> onPrevious;
    private final Function1<KeyboardActionScope, Unit> onSearch;
    private final Function1<KeyboardActionScope, Unit> onSend;

    public KeyboardActions() {
        this((Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, 63, (DefaultConstructorMarker) null);
    }

    public KeyboardActions(Function1<? super KeyboardActionScope, Unit> onDone2, Function1<? super KeyboardActionScope, Unit> onGo2, Function1<? super KeyboardActionScope, Unit> onNext2, Function1<? super KeyboardActionScope, Unit> onPrevious2, Function1<? super KeyboardActionScope, Unit> onSearch2, Function1<? super KeyboardActionScope, Unit> onSend2) {
        this.onDone = onDone2;
        this.onGo = onGo2;
        this.onNext = onNext2;
        this.onPrevious = onPrevious2;
        this.onSearch = onSearch2;
        this.onSend = onSend2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KeyboardActions(Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1, (i & 2) != 0 ? null : function12, (i & 4) != 0 ? null : function13, (i & 8) != 0 ? null : function14, (i & 16) != 0 ? null : function15, (i & 32) != 0 ? null : function16);
    }

    public final Function1<KeyboardActionScope, Unit> getOnDone() {
        return this.onDone;
    }

    public final Function1<KeyboardActionScope, Unit> getOnGo() {
        return this.onGo;
    }

    public final Function1<KeyboardActionScope, Unit> getOnNext() {
        return this.onNext;
    }

    public final Function1<KeyboardActionScope, Unit> getOnPrevious() {
        return this.onPrevious;
    }

    public final Function1<KeyboardActionScope, Unit> getOnSearch() {
        return this.onSearch;
    }

    public final Function1<KeyboardActionScope, Unit> getOnSend() {
        return this.onSend;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyboardActions)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object) this.onDone, (Object) ((KeyboardActions) other).onDone) || !Intrinsics.areEqual((Object) this.onGo, (Object) ((KeyboardActions) other).onGo) || !Intrinsics.areEqual((Object) this.onNext, (Object) ((KeyboardActions) other).onNext) || !Intrinsics.areEqual((Object) this.onPrevious, (Object) ((KeyboardActions) other).onPrevious) || !Intrinsics.areEqual((Object) this.onSearch, (Object) ((KeyboardActions) other).onSearch) || !Intrinsics.areEqual((Object) this.onSend, (Object) ((KeyboardActions) other).onSend)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Function1<KeyboardActionScope, Unit> function1 = this.onDone;
        int i = 0;
        int hashCode = (function1 != null ? function1.hashCode() : 0) * 31;
        Function1<KeyboardActionScope, Unit> function12 = this.onGo;
        int result = (hashCode + (function12 != null ? function12.hashCode() : 0)) * 31;
        Function1<KeyboardActionScope, Unit> function13 = this.onNext;
        int result2 = (result + (function13 != null ? function13.hashCode() : 0)) * 31;
        Function1<KeyboardActionScope, Unit> function14 = this.onPrevious;
        int result3 = (result2 + (function14 != null ? function14.hashCode() : 0)) * 31;
        Function1<KeyboardActionScope, Unit> function15 = this.onSearch;
        int result4 = (result3 + (function15 != null ? function15.hashCode() : 0)) * 31;
        Function1<KeyboardActionScope, Unit> function16 = this.onSend;
        if (function16 != null) {
            i = function16.hashCode();
        }
        return result4 + i;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/KeyboardActions$Companion;", "", "()V", "Default", "Landroidx/compose/foundation/text/KeyboardActions;", "getDefault$annotations", "getDefault", "()Landroidx/compose/foundation/text/KeyboardActions;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: KeyboardActions.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDefault$annotations() {
        }

        private Companion() {
        }

        public final KeyboardActions getDefault() {
            return KeyboardActions.Default;
        }
    }
}

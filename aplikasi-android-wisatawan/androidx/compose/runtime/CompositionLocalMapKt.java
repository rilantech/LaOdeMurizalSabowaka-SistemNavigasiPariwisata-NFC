package androidx.compose.runtime;

import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a \u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000\u001a%\u0010\f\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000¢\u0006\u0002\u0010\r\u001a@\u0010\u000e\u001a\u00020\u0001*\u00020\u00012.\u0010\u000f\u001a*\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00130\u0011\u0012\u0004\u0012\u00020\u00140\u0010H\bø\u0001\u0000\u001a%\u0010\u0015\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000¢\u0006\u0002\u0010\r\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, d2 = {"compositionLocalMapOf", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "parentScope", "([Landroidx/compose/runtime/ProvidedValue;Landroidx/compose/runtime/PersistentCompositionLocalMap;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/PersistentCompositionLocalMap;", "contains", "", "T", "key", "Landroidx/compose/runtime/CompositionLocal;", "getValueOf", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "mutate", "mutator", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/State;", "", "read", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CompositionLocalMap.kt */
public final class CompositionLocalMapKt {
    public static final PersistentCompositionLocalMap mutate(PersistentCompositionLocalMap $this$mutate, Function1<? super Map<CompositionLocal<Object>, State<Object>>, Unit> mutator) {
        Intrinsics.checkNotNullParameter($this$mutate, "<this>");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        PersistentCompositionLocalMap.Builder builder = $this$mutate.builder();
        mutator.invoke(builder);
        return builder.build();
    }

    public static final <T> boolean contains(PersistentCompositionLocalMap $this$contains, CompositionLocal<T> key) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return $this$contains.containsKey(key);
    }

    public static final <T> T getValueOf(PersistentCompositionLocalMap $this$getValueOf, CompositionLocal<T> key) {
        Intrinsics.checkNotNullParameter($this$getValueOf, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        State state = (State) $this$getValueOf.get(key);
        if (state != null) {
            return state.getValue();
        }
        return null;
    }

    public static final <T> T read(PersistentCompositionLocalMap $this$read, CompositionLocal<T> key) {
        Intrinsics.checkNotNullParameter($this$read, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (contains($this$read, key)) {
            return getValueOf($this$read, key);
        }
        return key.getDefaultValueHolder$runtime_release().getValue();
    }

    public static final PersistentCompositionLocalMap compositionLocalMapOf(ProvidedValue<?>[] values, PersistentCompositionLocalMap parentScope, Composer $composer, int $changed) {
        ProvidedValue[] providedValueArr = values;
        PersistentCompositionLocalMap persistentCompositionLocalMap = parentScope;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(providedValueArr, "values");
        Intrinsics.checkNotNullParameter(persistentCompositionLocalMap, "parentScope");
        composer.startReplaceableGroup(-300354947);
        ComposerKt.sourceInformation(composer, "C(compositionLocalMapOf)P(1):CompositionLocalMap.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-300354947, $changed, -1, "androidx.compose.runtime.compositionLocalMapOf (CompositionLocalMap.kt:91)");
        } else {
            int i = $changed;
        }
        PersistentCompositionLocalMap.Builder builder = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf().builder();
        Map it = builder;
        int length = providedValueArr.length;
        int i2 = 0;
        while (i2 < length) {
            ProvidedValue provided = providedValueArr[i2];
            composer.startReplaceableGroup(680845765);
            ComposerKt.sourceInformation(composer, "*101@4372L24");
            if (provided.getCanOverride() || !contains(persistentCompositionLocalMap, provided.getCompositionLocal())) {
                CompositionLocal<?> compositionLocal = provided.getCompositionLocal();
                Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
                it.put(compositionLocal, provided.getCompositionLocal().provided$runtime_release(provided.getValue(), composer, 8));
            }
            $composer.endReplaceableGroup();
            i2++;
            providedValueArr = values;
        }
        PersistentCompositionLocalMap build = builder.build();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return build;
    }
}

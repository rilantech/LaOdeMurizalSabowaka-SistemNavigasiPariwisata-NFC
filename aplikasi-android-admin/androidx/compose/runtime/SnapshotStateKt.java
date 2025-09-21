package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"androidx/compose/runtime/SnapshotStateKt__DerivedStateKt", "androidx/compose/runtime/SnapshotStateKt__ProduceStateKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotMutationPolicyKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotStateKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class SnapshotStateKt {
    public static final <T extends R, R> State<R> collectAsState(Flow<? extends T> $this$collectAsState, R initial, CoroutineContext context, Composer $composer, int $changed, int i) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState($this$collectAsState, initial, context, $composer, $changed, i);
    }

    public static final <T> State<T> collectAsState(StateFlow<? extends T> $this$collectAsState, CoroutineContext context, Composer $composer, int $changed, int i) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState($this$collectAsState, context, $composer, $changed, i);
    }

    public static final MutableVector<DerivedStateObserver> derivedStateObservers() {
        return SnapshotStateKt__DerivedStateKt.derivedStateObservers();
    }

    public static final <T> State<T> derivedStateOf(SnapshotMutationPolicy<T> policy, Function0<? extends T> calculation) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(policy, calculation);
    }

    public static final <T> State<T> derivedStateOf(Function0<? extends T> calculation) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(calculation);
    }

    public static final <T> T getValue(State<? extends T> $this$getValue, Object thisObj, KProperty<?> property) {
        return SnapshotStateKt__SnapshotStateKt.getValue($this$getValue, thisObj, property);
    }

    public static final <T> SnapshotStateList<T> mutableStateListOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf();
    }

    public static final <T> SnapshotStateList<T> mutableStateListOf(T... elements) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf(elements);
    }

    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf();
    }

    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf(Pair<? extends K, ? extends V>... pairs) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf(pairs);
    }

    public static final <T> MutableState<T> mutableStateOf(T value, SnapshotMutationPolicy<T> policy) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf(value, policy);
    }

    public static final <T> SnapshotMutationPolicy<T> neverEqualPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.neverEqualPolicy();
    }

    public static final <R> void observeDerivedStateRecalculations(DerivedStateObserver observer, Function0<? extends R> block) {
        SnapshotStateKt__DerivedStateKt.observeDerivedStateRecalculations(observer, block);
    }

    public static final <T> State<T> produceState(T initialValue, Object key1, Object key2, Object key3, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> producer, Composer $composer, int $changed) {
        return SnapshotStateKt__ProduceStateKt.produceState(initialValue, key1, key2, key3, producer, $composer, $changed);
    }

    public static final <T> State<T> produceState(T initialValue, Object key1, Object key2, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> producer, Composer $composer, int $changed) {
        return SnapshotStateKt__ProduceStateKt.produceState(initialValue, key1, key2, producer, $composer, $changed);
    }

    public static final <T> State<T> produceState(T initialValue, Object key1, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> producer, Composer $composer, int $changed) {
        return SnapshotStateKt__ProduceStateKt.produceState(initialValue, key1, producer, $composer, $changed);
    }

    public static final <T> State<T> produceState(T initialValue, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> producer, Composer $composer, int $changed) {
        return SnapshotStateKt__ProduceStateKt.produceState(initialValue, producer, $composer, $changed);
    }

    public static final <T> State<T> produceState(T initialValue, Object[] keys, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> producer, Composer $composer, int $changed) {
        return SnapshotStateKt__ProduceStateKt.produceState(initialValue, keys, producer, $composer, $changed);
    }

    public static final <T> SnapshotMutationPolicy<T> referentialEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.referentialEqualityPolicy();
    }

    public static final <T> State<T> rememberUpdatedState(T newValue, Composer $composer, int $changed) {
        return SnapshotStateKt__SnapshotStateKt.rememberUpdatedState(newValue, $composer, $changed);
    }

    public static final <T> void setValue(MutableState<T> $this$setValue, Object thisObj, KProperty<?> property, T value) {
        SnapshotStateKt__SnapshotStateKt.setValue($this$setValue, thisObj, property, value);
    }

    public static final <T> Flow<T> snapshotFlow(Function0<? extends T> block) {
        return SnapshotStateKt__SnapshotFlowKt.snapshotFlow(block);
    }

    public static final <T> SnapshotMutationPolicy<T> structuralEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.structuralEqualityPolicy();
    }

    public static final <T> SnapshotStateList<T> toMutableStateList(Collection<? extends T> $this$toMutableStateList) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateList($this$toMutableStateList);
    }

    public static final <K, V> SnapshotStateMap<K, V> toMutableStateMap(Iterable<? extends Pair<? extends K, ? extends V>> $this$toMutableStateMap) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateMap($this$toMutableStateMap);
    }
}

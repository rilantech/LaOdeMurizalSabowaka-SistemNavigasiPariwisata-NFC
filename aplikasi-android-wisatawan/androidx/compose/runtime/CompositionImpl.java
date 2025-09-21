package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010U\u001a\u00020\u001cH\u0002J\u001e\u0010V\u001a\u00020\u001c2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020/0X2\u0006\u0010Y\u001a\u00020\u0010H\u0002J\b\u0010Z\u001a\u00020\u001cH\u0016Jc\u0010[\u001a\u00020\u001c2Y\u0010\u0013\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0015j\u0002`\u001d0\u0014H\u0002J\b\u0010\\\u001a\u00020\u001cH\u0016J\b\u0010]\u001a\u00020\u001cH\u0016J\b\u0010^\u001a\u00020\u001cH\u0002J \u0010_\u001a\u00020\u001c2\u0011\u0010`\u001a\r\u0012\u0004\u0012\u00020\u001c0\u001f¢\u0006\u0002\b H\u0016¢\u0006\u0002\u0010$J3\u0010a\u001a\u0002Hb\"\u0004\b\u0000\u0010b2\b\u0010c\u001a\u0004\u0018\u00010\u00012\u0006\u0010d\u001a\u00020;2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002Hb0\u001fH\u0016¢\u0006\u0002\u0010fJ\b\u0010g\u001a\u00020\u001cH\u0016J\u0010\u0010h\u001a\u00020\u001c2\u0006\u0010i\u001a\u00020jH\u0016J\b\u0010k\u001a\u00020\u001cH\u0002J\b\u0010l\u001a\u00020\u001cH\u0002J\"\u0010m\u001a\u0002Hn\"\u0004\b\u0000\u0010n2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002Hn0\u001fH\b¢\u0006\u0002\u0010oJK\u0010p\u001a\u0002Hn\"\u0004\b\u0000\u0010n25\u0010e\u001a1\u0012'\u0012%\u0012\u0004\u0012\u00020*\u0012\f\u0012\n\u0012\u0004\u0012\u00020/\u0018\u00010>0=¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002Hn0qH\b¢\u0006\u0002\u0010rJ$\u0010s\u001a\u00020\u001c2\u001a\u0010t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020v\u0012\u0006\u0012\u0004\u0018\u00010v0u0)H\u0016J\u001a\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020*2\b\u0010z\u001a\u0004\u0018\u00010/H\u0016J\b\u0010{\u001a\u00020\u001cH\u0016J\"\u0010|\u001a\u00020x2\u0006\u0010y\u001a\u00020*2\u0006\u0010}\u001a\u00020~2\b\u0010z\u001a\u0004\u0018\u00010/H\u0002J\u000f\u0010\u001a\u00020\u001c2\u0007\u0010\u0001\u001a\u00020;J\u0012\u0010\u0001\u001a\u00020\u001c2\u0007\u0010\u0001\u001a\u00020/H\u0002J\u0017\u0010\u0001\u001a\u00020\u00102\f\u0010W\u001a\b\u0012\u0004\u0012\u00020/0XH\u0016J\u0017\u0010\u0001\u001a\u00020\u001c2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001fH\u0016J\t\u0010\u0001\u001a\u00020\u0010H\u0016J\u0011\u0010\u0001\u001a\u00020\u001c2\u0006\u0010y\u001a\u00020*H\u0016J\u0017\u0010\u0001\u001a\u00020\u001c2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020/0XH\u0016J\u0012\u0010\u0001\u001a\u00020\u001c2\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u001c2\u0007\u0010\u0001\u001a\u00020/H\u0016J\u001b\u0010\u0001\u001a\u00020\u001c2\n\u0010i\u001a\u0006\u0012\u0002\b\u000303H\u0000¢\u0006\u0003\b\u0001J\u001f\u0010\u0001\u001a\u00020\u001c2\u0006\u0010z\u001a\u00020/2\u0006\u0010y\u001a\u00020*H\u0000¢\u0006\u0003\b\u0001J!\u0010\u0001\u001a\u00020\u001c2\u0011\u0010`\u001a\r\u0012\u0004\u0012\u00020\u001c0\u001f¢\u0006\u0002\b H\u0016¢\u0006\u0002\u0010$J\u001d\u0010\u0001\u001a\u0016\u0012\u0004\u0012\u00020*\u0012\f\u0012\n\u0012\u0004\u0012\u00020/\u0018\u00010>0=H\u0002J#\u0010\u0001\u001a\u0002Hn\"\u0004\b\u0000\u0010n2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002Hn0\u001fH\b¢\u0006\u0002\u0010oJ\u001b\u0010\u0001\u001a\u00020\u00102\u0006\u0010y\u001a\u00020*2\b\u0010z\u001a\u0004\u0018\u00010/H\u0002J\u0011\u0010\u0001\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020RH\u0002J\t\u0010\u0001\u001a\u00020\u001cH\u0016JE\u0010V\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010\fj\n\u0012\u0004\u0012\u00020*\u0018\u0001`\u000e*\u0016\u0012\u0004\u0012\u00020*\u0018\u00010\fj\n\u0012\u0004\u0012\u00020*\u0018\u0001`\u000e2\u0007\u0010\u0001\u001a\u00020/2\u0006\u0010Y\u001a\u00020\u0010H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012Ra\u0010\u0013\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0015j\u0002`\u001d0\u0014X\u0004¢\u0006\u0002\n\u0000R'\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u001c0\u001f¢\u0006\u0002\b X\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)8@X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001e\u0010-\u001a\u0012\u0012\u0004\u0012\u00020*0\fj\b\u0012\u0004\u0012\u00020*`\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020/0)8@X\u0004¢\u0006\u0006\u001a\u0004\b0\u0010,R\u0018\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030302X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0012R\u0014\u00107\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0012R\u0010\u00109\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\"\u0010<\u001a\u0016\u0012\u0004\u0012\u00020*\u0012\f\u0012\n\u0012\u0004\u0012\u00020/\u0018\u00010>0=X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0012R\u0014\u0010@\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u0012R\u0011\u0010A\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0012Ra\u0010B\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0015j\u0002`\u001d0\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020*02X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020*02X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020/0)8@X\u0004¢\u0006\u0006\u001a\u0004\bG\u0010,R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0012\"\u0004\bJ\u0010KR\"\u0010L\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010/0Mj\n\u0012\u0006\u0012\u0004\u0018\u00010/`NX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020RX\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010T¨\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "Ljava/util/HashSet;", "Landroidx/compose/runtime/RememberObserver;", "Lkotlin/collections/HashSet;", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "composable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "conditionalScopes", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getConditionalScopes$runtime_release", "()Ljava/util/List;", "conditionallyInvalidatedScopes", "derivedStateDependencies", "", "getDerivedStateDependencies$runtime_release", "derivedStates", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "Landroidx/compose/runtime/DerivedState;", "disposed", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidationDelegate", "invalidationDelegateGroup", "", "invalidations", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "isComposing", "isDisposed", "isRoot", "lateChanges", "lock", "observations", "observationsProcessed", "observedObjects", "getObservedObjects$runtime_release", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "abandonChanges", "addPendingInvalidationsLocked", "values", "", "forgetConditionalScopes", "applyChanges", "applyChangesInLocked", "applyLateChanges", "changesApplied", "cleanUpDerivedStateObservations", "composeContent", "content", "delegateInvalidations", "R", "to", "groupIndex", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dispose", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "guardChanges", "T", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "guardInvalidationsLocked", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "insertMovableContent", "references", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "invalidateAll", "invalidateChecked", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidateGroupsWithKey", "key", "invalidateScopeOfLocked", "value", "observesAnyOf", "prepareCompose", "recompose", "recomposeScopeReleased", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime_release", "removeObservation", "removeObservation$runtime_release", "setContent", "takeInvalidations", "trackAbandonedValues", "tryImminentInvalidation", "validateRecomposeScopeAnchors", "verifyConsistent", "RememberEventDispatcher", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composition.kt */
public final class CompositionImpl implements ControlledComposition, RecomposeScopeOwner {
    private final CoroutineContext _recomposeContext;
    private final HashSet<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final HashSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final IdentityScopeMap<DerivedState<?>> derivedStates;
    private boolean disposed;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidations;
    private final boolean isRoot;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> lateChanges;
    private final Object lock;
    private final IdentityScopeMap<RecomposeScopeImpl> observations;
    private final IdentityScopeMap<RecomposeScopeImpl> observationsProcessed;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final SlotTable slotTable;

    public CompositionImpl(CompositionContext parent2, Applier<?> applier2, CoroutineContext recomposeContext) {
        Intrinsics.checkNotNullParameter(parent2, "parent");
        Intrinsics.checkNotNullParameter(applier2, "applier");
        this.parent = parent2;
        this.applier = applier2;
        this.pendingModifications = new AtomicReference<>((Object) null);
        this.lock = new Object();
        HashSet<RememberObserver> hashSet = new HashSet<>();
        this.abandonSet = hashSet;
        SlotTable slotTable2 = new SlotTable();
        this.slotTable = slotTable2;
        this.observations = new IdentityScopeMap<>();
        this.conditionallyInvalidatedScopes = new HashSet<>();
        this.derivedStates = new IdentityScopeMap<>();
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> arrayList = new ArrayList<>();
        this.changes = arrayList;
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> arrayList2 = new ArrayList<>();
        this.lateChanges = arrayList2;
        this.observationsProcessed = new IdentityScopeMap<>();
        this.invalidations = new IdentityArrayMap<>(0, 1, (DefaultConstructorMarker) null);
        ComposerImpl it = new ComposerImpl(applier2, parent2, slotTable2, hashSet, arrayList, arrayList2, this);
        parent2.registerComposer$runtime_release(it);
        this.composer = it;
        this._recomposeContext = recomposeContext;
        this.isRoot = parent2 instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m2840getLambda1$runtime_release();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier2, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier2, (i & 4) != 0 ? null : coroutineContext);
    }

    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }

    public final List<Object> getObservedObjects$runtime_release() {
        return ArraysKt.filterNotNull(this.observations.getValues());
    }

    public final List<Object> getDerivedStateDependencies$runtime_release() {
        return ArraysKt.filterNotNull(this.derivedStates.getValues());
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes);
    }

    public final boolean getPendingInvalidScopes$runtime_release() {
        return this.pendingInvalidScopes;
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z) {
        this.pendingInvalidScopes = z;
    }

    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : coroutineContext;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.composable = function2;
    }

    public boolean isComposing() {
        return this.composer.isComposing$runtime_release();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        synchronized (this.lock) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (!this.disposed) {
            this.composable = content;
            this.parent.composeInitial$runtime_release(this, content);
            return;
        }
        throw new IllegalStateException("The composition is disposed".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        if (r0 == null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        r6 = r0;
        r8 = 0;
        r9 = r6.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r8 >= r9) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (((androidx.compose.runtime.RecomposeScopeImpl) r6.get(r8)).invalidateForResult((java.lang.Object) null) != androidx.compose.runtime.InvalidationResult.IGNORED) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        if (r2 == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        if (r2 == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r2 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (r1.composer.forceRecomposeScopes$runtime_release() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0052, code lost:
        r1.parent.invalidate$runtime_release(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r0 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invalidateGroupsWithKey(int r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.Object r2 = r1.lock
            r3 = 0
            monitor-enter(r2)
            r0 = 0
            androidx.compose.runtime.SlotTable r4 = r1.slotTable     // Catch:{ all -> 0x005d }
            r5 = r17
            java.util.List r4 = r4.invalidateGroupsWithKey$runtime_release(r5)     // Catch:{ all -> 0x005b }
            monitor-exit(r2)
            r0 = r4
            if (r0 == 0) goto L_0x0046
            r3 = r0
            r4 = 0
            r6 = r3
            r7 = 0
            r8 = 0
            int r9 = r6.size()
        L_0x001e:
            if (r8 >= r9) goto L_0x003f
            java.lang.Object r11 = r6.get(r8)
            r12 = r11
            r13 = 0
            r14 = r12
            androidx.compose.runtime.RecomposeScopeImpl r14 = (androidx.compose.runtime.RecomposeScopeImpl) r14
            r15 = 0
            r2 = 0
            androidx.compose.runtime.InvalidationResult r2 = r14.invalidateForResult(r2)
            androidx.compose.runtime.InvalidationResult r10 = androidx.compose.runtime.InvalidationResult.IGNORED
            if (r2 != r10) goto L_0x0035
            r2 = 1
            goto L_0x0036
        L_0x0035:
            r2 = 0
        L_0x0036:
            if (r2 == 0) goto L_0x003a
            r2 = 1
            goto L_0x0041
        L_0x003a:
            int r8 = r8 + 1
            goto L_0x001e
        L_0x003f:
            r2 = 0
        L_0x0041:
            if (r2 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r2 = 0
            goto L_0x0047
        L_0x0046:
            r2 = 1
        L_0x0047:
            if (r2 == 0) goto L_0x005a
            androidx.compose.runtime.ComposerImpl r3 = r1.composer
            boolean r3 = r3.forceRecomposeScopes$runtime_release()
            if (r3 == 0) goto L_0x005a
            androidx.compose.runtime.CompositionContext r3 = r1.parent
            r4 = r1
            androidx.compose.runtime.ControlledComposition r4 = (androidx.compose.runtime.ControlledComposition) r4
            r3.invalidate$runtime_release(r4)
        L_0x005a:
            return
        L_0x005b:
            r0 = move-exception
            goto L_0x0060
        L_0x005d:
            r0 = move-exception
            r5 = r17
        L_0x0060:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.invalidateGroupsWithKey(int):void");
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object toRecord = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (toRecord == null) {
            return;
        }
        if (Intrinsics.areEqual(toRecord, CompositionKt.PendingApplyNoModifications)) {
            ComposerKt.composeRuntimeError("pending composition has not been applied");
            throw new KotlinNothingValueException();
        } else if (toRecord instanceof Set) {
            addPendingInvalidationsLocked((Set) toRecord, true);
        } else if (toRecord instanceof Object[]) {
            for (Set changed : (Set[]) toRecord) {
                addPendingInvalidationsLocked(changed, true);
            }
        } else {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    private final void drainPendingModificationsLocked() {
        Object toRecord = this.pendingModifications.getAndSet((Object) null);
        if (Intrinsics.areEqual(toRecord, CompositionKt.PendingApplyNoModifications)) {
            return;
        }
        if (toRecord instanceof Set) {
            addPendingInvalidationsLocked((Set) toRecord, false);
        } else if (toRecord instanceof Object[]) {
            for (Set changed : (Set[]) toRecord) {
                addPendingInvalidationsLocked(changed, false);
            }
        } else if (toRecord == null) {
            ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        } else {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 17 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056 A[SYNTHETIC, Splitter:B:31:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void composeContent(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r3 = r17
            r4 = 0
            r5 = r3
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.Object r0 = r1.lock     // Catch:{ all -> 0x0051 }
            r9 = r0
            r10 = 0
            monitor-enter(r9)     // Catch:{ all -> 0x0051 }
            r11 = 0
            r17.drainPendingModificationsForCompositionLocked()     // Catch:{ all -> 0x004a }
            r12 = r17
            r13 = 0
            androidx.compose.runtime.collection.IdentityArrayMap r0 = r12.takeInvalidations()     // Catch:{ all -> 0x004a }
            r14 = r0
            r0 = r14
            r15 = 0
            r16 = r4
            androidx.compose.runtime.ComposerImpl r4 = r1.composer     // Catch:{ Exception -> 0x0045 }
            r4.composeContent$runtime_release(r0, r2)     // Catch:{ Exception -> 0x0045 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0045 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0043 }
            monitor-exit(r9)     // Catch:{ all -> 0x004f }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004f }
            r4 = 0
            r7 = 1
            return
        L_0x0043:
            r0 = move-exception
            goto L_0x004d
        L_0x0045:
            r0 = move-exception
            r12.invalidations = r14     // Catch:{ all -> 0x0043 }
            throw r0     // Catch:{ all -> 0x0043 }
        L_0x004a:
            r0 = move-exception
            r16 = r4
        L_0x004d:
            monitor-exit(r9)     // Catch:{ all -> 0x004f }
            throw r0     // Catch:{ all -> 0x004f }
        L_0x004f:
            r0 = move-exception
            goto L_0x0054
        L_0x0051:
            r0 = move-exception
            r16 = r4
        L_0x0054:
            if (r7 != 0) goto L_0x006e
            java.util.HashSet<androidx.compose.runtime.RememberObserver> r4 = r5.abandonSet     // Catch:{ Exception -> 0x0070 }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ Exception -> 0x0070 }
            boolean r4 = r4.isEmpty()     // Catch:{ Exception -> 0x0070 }
            r4 = r4 ^ 1
            if (r4 == 0) goto L_0x006e
            androidx.compose.runtime.CompositionImpl$RememberEventDispatcher r4 = new androidx.compose.runtime.CompositionImpl$RememberEventDispatcher     // Catch:{ Exception -> 0x0070 }
            java.util.HashSet<androidx.compose.runtime.RememberObserver> r8 = r5.abandonSet     // Catch:{ Exception -> 0x0070 }
            java.util.Set r8 = (java.util.Set) r8     // Catch:{ Exception -> 0x0070 }
            r4.<init>(r8)     // Catch:{ Exception -> 0x0070 }
            r4.dispatchAbandons()     // Catch:{ Exception -> 0x0070 }
        L_0x006e:
            throw r0     // Catch:{ Exception -> 0x0070 }
        L_0x0070:
            r0 = move-exception
            r3.abandonChanges()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.composeContent(kotlin.jvm.functions.Function2):void");
    }

    /* Debug info: failed to restart local var, previous not found, register: 13 */
    /* JADX INFO: finally extract failed */
    public void dispose() {
        synchronized (this.lock) {
            if (!this.disposed) {
                this.disposed = true;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.m2841getLambda2$runtime_release();
                List deferredChanges = this.composer.getDeferredChanges$runtime_release();
                if (deferredChanges != null) {
                    applyChangesInLocked(deferredChanges);
                }
                boolean nonEmptySlotTable = this.slotTable.getGroupsSize() > 0;
                if (nonEmptySlotTable || (true ^ this.abandonSet.isEmpty())) {
                    RememberEventDispatcher manager = new RememberEventDispatcher(this.abandonSet);
                    if (nonEmptySlotTable) {
                        this.applier.onBeginChanges();
                        SlotWriter writer$iv = this.slotTable.openWriter();
                        try {
                            ComposerKt.removeCurrentGroup(writer$iv, manager);
                            Unit unit = Unit.INSTANCE;
                            writer$iv.close();
                            this.applier.clear();
                            this.applier.onEndChanges();
                            manager.dispatchRememberObservers();
                        } catch (Throwable th) {
                            writer$iv.close();
                            throw th;
                        }
                    }
                    manager.dispatchAbandons();
                }
                this.composer.dispose$runtime_release();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = this.invalidations.getSize() > 0;
        }
        return z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX WARNING: type inference failed for: r2v13, types: [java.util.Set[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void recordModificationsOf(java.util.Set<? extends java.lang.Object> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
        L_0x0006:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r5.pendingModifications
            java.lang.Object r0 = r0.get()
            r1 = 1
            if (r0 != 0) goto L_0x0013
            r2 = r1
            goto L_0x001b
        L_0x0013:
            java.lang.Object r2 = androidx.compose.runtime.CompositionKt.PendingApplyNoModifications
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
        L_0x001b:
            if (r2 == 0) goto L_0x001f
            r2 = r6
            goto L_0x003d
        L_0x001f:
            boolean r2 = r0 instanceof java.util.Set
            if (r2 == 0) goto L_0x002c
            r2 = 2
            java.util.Set[] r2 = new java.util.Set[r2]
            r3 = 0
            r2[r3] = r0
            r2[r1] = r6
            goto L_0x003d
        L_0x002c:
            boolean r1 = r0 instanceof java.lang.Object[]
            if (r1 == 0) goto L_0x005a
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            r1 = r0
            java.util.Set[] r1 = (java.util.Set[]) r1
            java.lang.Object[] r2 = kotlin.collections.ArraysKt.plus((T[]) r1, r6)
        L_0x003d:
            r1 = r2
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r2 = r5.pendingModifications
            boolean r2 = r2.compareAndSet(r0, r1)
            if (r2 == 0) goto L_0x0006
            if (r0 != 0) goto L_0x0058
            java.lang.Object r2 = r5.lock
            r3 = 0
            monitor-enter(r2)
            r4 = 0
            r5.drainPendingModificationsLocked()     // Catch:{ all -> 0x0055 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0055 }
            monitor-exit(r2)
            goto L_0x0058
        L_0x0055:
            r4 = move-exception
            monitor-exit(r2)
            throw r4
        L_0x0058:
            return
        L_0x005a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "corrupt pendingModifications: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r3 = r5.pendingModifications
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.recordModificationsOf(java.util.Set):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean observesAnyOf(java.util.Set<? extends java.lang.Object> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.Iterator r0 = r4.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0026
            java.lang.Object r1 = r0.next()
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r2 = r3.observations
            boolean r2 = r2.contains(r1)
            if (r2 != 0) goto L_0x0024
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.DerivedState<?>> r2 = r3.derivedStates
            boolean r2 = r2.contains(r1)
            if (r2 == 0) goto L_0x000a
        L_0x0024:
            r0 = 1
            return r0
        L_0x0026:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.observesAnyOf(java.util.Set):boolean");
    }

    public void prepareCompose(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.composer.prepareCompose$runtime_release(block);
    }

    private final HashSet<RecomposeScopeImpl> addPendingInvalidationsLocked(HashSet<RecomposeScopeImpl> $this$addPendingInvalidationsLocked, Object value, boolean forgetConditionalScopes) {
        Object obj = value;
        HashSet<RecomposeScopeImpl> hashSet = $this$addPendingInvalidationsLocked;
        IdentityScopeMap this_$iv = this.observations;
        int index$iv = this_$iv.find(obj);
        if (index$iv >= 0) {
            IdentityArraySet this_$iv$iv = this_$iv.scopeSetAt(index$iv);
            Object[] values$iv$iv = this_$iv$iv.getValues();
            int size = this_$iv$iv.size();
            for (int i$iv$iv = 0; i$iv$iv < size; i$iv$iv++) {
                Object obj2 = values$iv$iv[i$iv$iv];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                RecomposeScopeImpl scope = (RecomposeScopeImpl) obj2;
                if (!this.observationsProcessed.remove(obj, scope) && scope.invalidateForResult(obj) != InvalidationResult.IGNORED) {
                    if (!scope.isConditional() || forgetConditionalScopes) {
                        if (hashSet == null) {
                            hashSet = new HashSet<>();
                        }
                        hashSet.add(scope);
                    } else {
                        this.conditionallyInvalidatedScopes.add(scope);
                    }
                }
            }
        }
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x01a1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x019b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addPendingInvalidationsLocked(java.util.Set<? extends java.lang.Object> r32, boolean r33) {
        /*
            r31 = this;
            r0 = r31
            r1 = r33
            r2 = 0
            r3 = r32
            r4 = 0
            boolean r5 = r3 instanceof androidx.compose.runtime.collection.IdentityArraySet
            java.lang.String r6 = "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet"
            r7 = 0
            if (r5 == 0) goto L_0x0097
            r5 = r3
            androidx.compose.runtime.collection.IdentityArraySet r5 = (androidx.compose.runtime.collection.IdentityArraySet) r5
            r8 = 0
            java.lang.Object[] r9 = r5.getValues()
            r10 = 0
            int r11 = r5.size()
        L_0x001e:
            if (r10 >= r11) goto L_0x008f
            r12 = r9[r10]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r6)
            r13 = 0
            boolean r14 = r12 instanceof androidx.compose.runtime.RecomposeScopeImpl
            if (r14 == 0) goto L_0x0035
            r14 = r12
            androidx.compose.runtime.RecomposeScopeImpl r14 = (androidx.compose.runtime.RecomposeScopeImpl) r14
            r14.invalidateForResult(r7)
            r21 = r4
            r19 = r5
            goto L_0x0085
        L_0x0035:
            java.util.HashSet r14 = r0.addPendingInvalidationsLocked(r2, r12, r1)
            r2 = r14
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.DerivedState<?>> r14 = r0.derivedStates
            r15 = 0
            int r7 = r14.find(r12)
            if (r7 < 0) goto L_0x007e
            androidx.compose.runtime.collection.IdentityArraySet r16 = r14.scopeSetAt(r7)
            r17 = 0
            java.lang.Object[] r18 = r16.getValues()
            r19 = 0
            r20 = r2
            int r2 = r16.size()
            r21 = r4
            r4 = r20
            r30 = r19
            r19 = r5
            r5 = r30
        L_0x0061:
            if (r5 >= r2) goto L_0x007c
            r22 = r2
            r2 = r18[r5]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r6)
            androidx.compose.runtime.DerivedState r2 = (androidx.compose.runtime.DerivedState) r2
            r20 = 0
            java.util.HashSet r23 = r0.addPendingInvalidationsLocked(r4, r2, r1)
            r4 = r23
            int r5 = r5 + 1
            r2 = r22
            goto L_0x0061
        L_0x007c:
            r2 = r4
            goto L_0x0084
        L_0x007e:
            r20 = r2
            r21 = r4
            r19 = r5
        L_0x0084:
        L_0x0085:
            int r10 = r10 + 1
            r5 = r19
            r4 = r21
            r7 = 0
            goto L_0x001e
        L_0x008f:
            r21 = r4
            r19 = r5
            r19 = r3
            goto L_0x0116
        L_0x0097:
            r21 = r4
            r4 = r3
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r5 = 0
            java.util.Iterator r7 = r4.iterator()
        L_0x00a1:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0112
            java.lang.Object r8 = r7.next()
            r9 = r8
            r10 = 0
            boolean r11 = r9 instanceof androidx.compose.runtime.RecomposeScopeImpl
            if (r11 == 0) goto L_0x00bd
            r11 = r9
            androidx.compose.runtime.RecomposeScopeImpl r11 = (androidx.compose.runtime.RecomposeScopeImpl) r11
            r12 = 0
            r11.invalidateForResult(r12)
            r19 = r3
            r17 = r4
            goto L_0x010c
        L_0x00bd:
            java.util.HashSet r11 = r0.addPendingInvalidationsLocked(r2, r9, r1)
            r2 = r11
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.DerivedState<?>> r11 = r0.derivedStates
            r12 = 0
            int r13 = r11.find(r9)
            if (r13 < 0) goto L_0x0105
            androidx.compose.runtime.collection.IdentityArraySet r14 = r11.scopeSetAt(r13)
            r15 = 0
            java.lang.Object[] r16 = r14.getValues()
            r17 = 0
            r18 = r2
            int r2 = r14.size()
            r19 = r3
            r3 = r18
            r30 = r17
            r17 = r4
            r4 = r30
        L_0x00e8:
            if (r4 >= r2) goto L_0x0103
            r20 = r2
            r2 = r16[r4]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r6)
            androidx.compose.runtime.DerivedState r2 = (androidx.compose.runtime.DerivedState) r2
            r18 = 0
            java.util.HashSet r22 = r0.addPendingInvalidationsLocked(r3, r2, r1)
            r3 = r22
            int r4 = r4 + 1
            r2 = r20
            goto L_0x00e8
        L_0x0103:
            r2 = r3
            goto L_0x010b
        L_0x0105:
            r18 = r2
            r19 = r3
            r17 = r4
        L_0x010b:
        L_0x010c:
            r4 = r17
            r3 = r19
            goto L_0x00a1
        L_0x0112:
            r19 = r3
            r17 = r4
        L_0x0116:
            if (r1 == 0) goto L_0x0209
            java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl> r3 = r0.conditionallyInvalidatedScopes
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r4 = 1
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x0209
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r3 = r0.observations
            r5 = 0
            r7 = r3
            r8 = 0
            int[] r9 = r7.getValueOrder()
            androidx.compose.runtime.collection.IdentityArraySet[] r10 = r7.getScopeSets()
            java.lang.Object[] r11 = r7.getValues()
            r12 = 0
            r13 = 0
            int r14 = r7.getSize()
        L_0x013c:
            if (r13 >= r14) goto L_0x01e1
            r15 = r9[r13]
            r16 = r10[r15]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r16)
            r17 = r16
            r18 = 0
            r19 = r17
            r20 = 0
            java.lang.Object[] r21 = r19.getValues()
            int r4 = r19.size()
            r23 = 0
            r24 = 0
            r1 = r23
            r23 = r3
            r3 = r24
        L_0x015f:
            if (r3 >= r4) goto L_0x01aa
            r24 = r5
            r5 = r21[r3]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r6)
            r25 = r8
            r8 = r5
            androidx.compose.runtime.RecomposeScopeImpl r8 = (androidx.compose.runtime.RecomposeScopeImpl) r8
            r26 = 0
            r27 = r10
            java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl> r10 = r0.conditionallyInvalidatedScopes
            boolean r10 = r10.contains(r8)
            if (r10 != 0) goto L_0x0195
            if (r2 == 0) goto L_0x018c
            r28 = r2
            r29 = 0
            r10 = r28
            boolean r10 = r10.contains(r8)
            r28 = r8
            r8 = 1
            if (r10 != r8) goto L_0x018f
            r10 = r8
            goto L_0x0190
        L_0x018c:
            r28 = r8
            r8 = 1
        L_0x018f:
            r10 = 0
        L_0x0190:
            if (r10 == 0) goto L_0x0193
            goto L_0x0198
        L_0x0193:
            r10 = 0
            goto L_0x0199
        L_0x0195:
            r28 = r8
            r8 = 1
        L_0x0198:
            r10 = r8
        L_0x0199:
            if (r10 != 0) goto L_0x01a1
            if (r1 == r3) goto L_0x019f
            r21[r1] = r5
        L_0x019f:
            int r1 = r1 + 1
        L_0x01a1:
            int r3 = r3 + 1
            r5 = r24
            r8 = r25
            r10 = r27
            goto L_0x015f
        L_0x01aa:
            r24 = r5
            r25 = r8
            r27 = r10
            r8 = 1
            r3 = r1
        L_0x01b2:
            if (r3 >= r4) goto L_0x01ba
            r5 = 0
            r21[r3] = r5
            int r3 = r3 + 1
            goto L_0x01b2
        L_0x01ba:
            r3 = r19
            r3.size = r1
            int r1 = r16.size()
            if (r1 <= 0) goto L_0x01d2
            if (r12 == r13) goto L_0x01d0
            r1 = r9[r12]
            r9[r12] = r15
            r9[r13] = r1
        L_0x01d0:
            int r12 = r12 + 1
        L_0x01d2:
            int r13 = r13 + 1
            r1 = r33
            r4 = r8
            r3 = r23
            r5 = r24
            r8 = r25
            r10 = r27
            goto L_0x013c
        L_0x01e1:
            r23 = r3
            r24 = r5
            r25 = r8
            r27 = r10
            r1 = r12
            int r3 = r7.getSize()
        L_0x01ee:
            if (r1 >= r3) goto L_0x01f8
            r4 = r9[r1]
            r5 = 0
            r11[r4] = r5
            int r1 = r1 + 1
            goto L_0x01ee
        L_0x01f8:
            r7.setSize(r12)
            java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl> r1 = r0.conditionallyInvalidatedScopes
            r1.clear()
            r31.cleanUpDerivedStateObservations()
            r24 = r2
            goto L_0x02c2
        L_0x0209:
            if (r2 == 0) goto L_0x02bf
            r1 = r2
            r3 = 0
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r4 = r0.observations
            r5 = 0
            r7 = r4
            r8 = 0
            int[] r9 = r7.getValueOrder()
            androidx.compose.runtime.collection.IdentityArraySet[] r10 = r7.getScopeSets()
            java.lang.Object[] r11 = r7.getValues()
            r12 = 0
            r13 = 0
            int r14 = r7.getSize()
        L_0x0224:
            if (r13 >= r14) goto L_0x029e
            r15 = r9[r13]
            r16 = r10[r15]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r16)
            r17 = r16
            r18 = 0
            r19 = r17
            r20 = 0
            java.lang.Object[] r21 = r19.getValues()
            int r0 = r19.size()
            r22 = 0
            r23 = 0
            r24 = r2
            r2 = r22
            r22 = r3
            r3 = r23
        L_0x0249:
            if (r3 >= r0) goto L_0x026c
            r23 = r4
            r4 = r21[r3]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r6)
            r25 = r5
            r5 = r4
            androidx.compose.runtime.RecomposeScopeImpl r5 = (androidx.compose.runtime.RecomposeScopeImpl) r5
            r26 = 0
            boolean r5 = r1.contains(r5)
            if (r5 != 0) goto L_0x0265
            if (r2 == r3) goto L_0x0263
            r21[r2] = r4
        L_0x0263:
            int r2 = r2 + 1
        L_0x0265:
            int r3 = r3 + 1
            r4 = r23
            r5 = r25
            goto L_0x0249
        L_0x026c:
            r23 = r4
            r25 = r5
            r3 = r2
        L_0x0271:
            if (r3 >= r0) goto L_0x0279
            r4 = 0
            r21[r3] = r4
            int r3 = r3 + 1
            goto L_0x0271
        L_0x0279:
            r3 = r19
            r3.size = r2
            int r0 = r16.size()
            if (r0 <= 0) goto L_0x0291
            if (r12 == r13) goto L_0x028f
            r0 = r9[r12]
            r9[r12] = r15
            r9[r13] = r0
        L_0x028f:
            int r12 = r12 + 1
        L_0x0291:
            int r13 = r13 + 1
            r0 = r31
            r3 = r22
            r4 = r23
            r2 = r24
            r5 = r25
            goto L_0x0224
        L_0x029e:
            r24 = r2
            r22 = r3
            r23 = r4
            r25 = r5
            r0 = r12
            int r2 = r7.getSize()
        L_0x02ab:
            if (r0 >= r2) goto L_0x02b5
            r3 = r9[r0]
            r4 = 0
            r11[r3] = r4
            int r0 = r0 + 1
            goto L_0x02ab
        L_0x02b5:
            r7.setSize(r12)
            r31.cleanUpDerivedStateObservations()
            goto L_0x02c1
        L_0x02bf:
            r24 = r2
        L_0x02c1:
        L_0x02c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.addPendingInvalidationsLocked(java.util.Set, boolean):void");
    }

    private final void cleanUpDerivedStateObservations() {
        IdentityScopeMap this_$iv = this.derivedStates;
        int $i$f$removeValueIf = false;
        IdentityScopeMap this_$iv$iv = this_$iv;
        int $i$f$removingScopes = false;
        int[] valueOrder$iv$iv = this_$iv$iv.getValueOrder();
        IdentityArraySet[] scopeSets$iv$iv = this_$iv$iv.getScopeSets();
        Object[] values$iv$iv = this_$iv$iv.getValues();
        int destinationIndex$iv$iv = 0;
        int i$iv$iv = 0;
        int size = this_$iv$iv.getSize();
        while (i$iv$iv < size) {
            int valueIndex$iv$iv = valueOrder$iv$iv[i$iv$iv];
            IdentityArraySet set$iv$iv = scopeSets$iv$iv[valueIndex$iv$iv];
            Intrinsics.checkNotNull(set$iv$iv);
            IdentityArraySet this_$iv$iv2 = set$iv$iv;
            Object[] values$iv$iv2 = this_$iv$iv2.getValues();
            int size$iv$iv = this_$iv$iv2.size();
            IdentityScopeMap this_$iv2 = this_$iv;
            int destinationIndex$iv$iv2 = 0;
            int destinationIndex$iv$iv3 = $i$f$removeValueIf;
            int i$iv$iv2 = 0;
            while (i$iv$iv2 < size$iv$iv) {
                int $i$f$removingScopes2 = $i$f$removingScopes;
                Object item$iv$iv = values$iv$iv2[i$iv$iv2];
                IdentityArraySet[] scopeSets$iv$iv2 = scopeSets$iv$iv;
                Intrinsics.checkNotNull(item$iv$iv, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                int i = size;
                if (!(!this.observations.contains((DerivedState) item$iv$iv))) {
                    if (destinationIndex$iv$iv2 != i$iv$iv2) {
                        values$iv$iv2[destinationIndex$iv$iv2] = item$iv$iv;
                    }
                    destinationIndex$iv$iv2++;
                }
                i$iv$iv2++;
                $i$f$removingScopes = $i$f$removingScopes2;
                scopeSets$iv$iv = scopeSets$iv$iv2;
                size = i;
            }
            int $i$f$removingScopes3 = $i$f$removingScopes;
            IdentityArraySet[] scopeSets$iv$iv3 = scopeSets$iv$iv;
            int i2 = size;
            for (int i$iv$iv3 = destinationIndex$iv$iv2; i$iv$iv3 < size$iv$iv; i$iv$iv3++) {
                values$iv$iv2[i$iv$iv3] = null;
            }
            this_$iv$iv2.size = destinationIndex$iv$iv2;
            if (set$iv$iv.size() > 0) {
                if (destinationIndex$iv$iv != i$iv$iv) {
                    int destinationKeyOrder$iv$iv = valueOrder$iv$iv[destinationIndex$iv$iv];
                    valueOrder$iv$iv[destinationIndex$iv$iv] = valueIndex$iv$iv;
                    valueOrder$iv$iv[i$iv$iv] = destinationKeyOrder$iv$iv;
                }
                destinationIndex$iv$iv++;
            }
            i$iv$iv++;
            $i$f$removeValueIf = destinationIndex$iv$iv3;
            $i$f$removingScopes = $i$f$removingScopes3;
            this_$iv = this_$iv2;
            scopeSets$iv$iv = scopeSets$iv$iv3;
            size = i2;
        }
        int i3 = $i$f$removeValueIf;
        int i4 = $i$f$removingScopes;
        IdentityArraySet[] identityArraySetArr = scopeSets$iv$iv;
        int size2 = this_$iv$iv.getSize();
        for (int i$iv$iv4 = destinationIndex$iv$iv; i$iv$iv4 < size2; i$iv$iv4++) {
            values$iv$iv[valueOrder$iv$iv[i$iv$iv4]] = null;
        }
        this_$iv$iv.setSize(destinationIndex$iv$iv);
        if (!this.conditionallyInvalidatedScopes.isEmpty()) {
            Iterator iter$iv = this.conditionallyInvalidatedScopes.iterator();
            Intrinsics.checkNotNullExpressionValue(iter$iv, "iterator()");
            while (iter$iv.hasNext()) {
                if (!iter$iv.next().isConditional()) {
                    iter$iv.remove();
                }
            }
        }
    }

    public void recordReadOf(Object value) {
        RecomposeScopeImpl it;
        Intrinsics.checkNotNullParameter(value, "value");
        if (!getAreChildrenComposing() && (it = this.composer.getCurrentRecomposeScope$runtime_release()) != null) {
            it.setUsed(true);
            if (!it.recordRead(value)) {
                this.observations.add(value, it);
                if (value instanceof DerivedState) {
                    this.derivedStates.removeScope(value);
                    Object[] dependencies = ((DerivedState) value).getCurrentRecord().getDependencies();
                    int length = dependencies.length;
                    int i = 0;
                    while (i < length) {
                        Object dependency = dependencies[i];
                        if (dependency != null) {
                            this.derivedStates.add(dependency, value);
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private final void invalidateScopeOfLocked(Object value) {
        IdentityScopeMap this_$iv = this.observations;
        int index$iv = this_$iv.find(value);
        if (index$iv >= 0) {
            IdentityArraySet this_$iv$iv = this_$iv.scopeSetAt(index$iv);
            Object[] values$iv$iv = this_$iv$iv.getValues();
            int size = this_$iv$iv.size();
            for (int i$iv$iv = 0; i$iv$iv < size; i$iv$iv++) {
                Object obj = values$iv$iv[i$iv$iv];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                RecomposeScopeImpl scope = (RecomposeScopeImpl) obj;
                if (scope.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                    this.observationsProcessed.add(value, scope);
                }
            }
        }
    }

    public void recordWriteOf(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.lock) {
            invalidateScopeOfLocked(value);
            IdentityScopeMap this_$iv = this.derivedStates;
            int index$iv = this_$iv.find(value);
            if (index$iv >= 0) {
                IdentityArraySet this_$iv$iv = this_$iv.scopeSetAt(index$iv);
                Object[] values$iv$iv = this_$iv$iv.getValues();
                int size = this_$iv$iv.size();
                for (int i$iv$iv = 0; i$iv$iv < size; i$iv$iv++) {
                    Object obj = values$iv$iv[i$iv$iv];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    invalidateScopeOfLocked((DerivedState) obj);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 18 */
    public boolean recompose() {
        IdentityArrayMap invalidations$iv;
        boolean shouldDrain;
        synchronized (this.lock) {
            drainPendingModificationsForCompositionLocked();
            try {
                invalidations$iv = takeInvalidations();
                shouldDrain = this.composer.recompose$runtime_release(invalidations$iv);
                if (!shouldDrain) {
                    drainPendingModificationsLocked();
                }
                boolean z = shouldDrain;
            } catch (Exception e$iv) {
                this.invalidations = invalidations$iv;
                throw e$iv;
            } catch (Throwable e$iv2) {
                if (0 == 0) {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                    } catch (Exception e$iv3) {
                        abandonChanges();
                        throw e$iv3;
                    }
                }
                throw e$iv2;
            }
        }
        return shouldDrain;
    }

    /* Debug info: failed to restart local var, previous not found, register: 13 */
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        boolean z;
        Intrinsics.checkNotNullParameter(references, "references");
        List $this$fastForEach$iv$iv = references;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (true) {
            if (index$iv$iv >= size) {
                z = true;
                break;
            } else if (!Intrinsics.areEqual((Object) ((MovableContentStateReference) ((Pair) $this$fastForEach$iv$iv.get(index$iv$iv)).getFirst()).getComposition$runtime_release(), (Object) this)) {
                z = false;
                break;
            } else {
                index$iv$iv++;
            }
        }
        ComposerKt.runtimeCheck(z);
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } catch (Exception e$iv) {
            abandonChanges();
            throw e$iv;
        } catch (Throwable th) {
            if (0 == 0) {
                if (true ^ this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public void disposeUnusedMovableContent(MovableContentState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        RememberEventDispatcher manager = new RememberEventDispatcher(this.abandonSet);
        SlotWriter writer$iv = state.getSlotTable$runtime_release().openWriter();
        try {
            ComposerKt.removeCurrentGroup(writer$iv, manager);
            Unit unit = Unit.INSTANCE;
            writer$iv.close();
            manager.dispatchRememberObservers();
        } catch (Throwable th) {
            writer$iv.close();
            throw th;
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 31 */
    private final void applyChangesInLocked(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes2) {
        Object token$iv;
        int $i$f$trace;
        int $i$f$trace2;
        RememberEventDispatcher manager = new RememberEventDispatcher(this.abandonSet);
        try {
            if (!changes2.isEmpty()) {
                String sectionName$iv = "Compose:applyChanges";
                Object token$iv2 = Trace.INSTANCE.beginSection(sectionName$iv);
                try {
                    this.applier.onBeginChanges();
                    SlotWriter writer$iv = this.slotTable.openWriter();
                    SlotWriter slots = writer$iv;
                    try {
                        Applier applier2 = this.applier;
                        List $this$fastForEach$iv = changes2;
                        int index$iv = 0;
                        String str = sectionName$iv;
                        try {
                            for (int size = $this$fastForEach$iv.size(); index$iv < size; size = size) {
                                $this$fastForEach$iv.get(index$iv).invoke(applier2, slots, manager);
                                index$iv++;
                            }
                            changes2.clear();
                            Unit unit = Unit.INSTANCE;
                            try {
                                writer$iv.close();
                                this.applier.onEndChanges();
                                Unit unit2 = Unit.INSTANCE;
                                Trace.INSTANCE.endSection(token$iv2);
                                manager.dispatchRememberObservers();
                                manager.dispatchSideEffects();
                                if (this.pendingInvalidScopes) {
                                    String sectionName$iv2 = "Compose:unobserve";
                                    int size$iv$iv = false;
                                    token$iv = Trace.INSTANCE.beginSection(sectionName$iv2);
                                    int i = 0;
                                    try {
                                        this.pendingInvalidScopes = false;
                                        IdentityScopeMap this_$iv = this.observations;
                                        int $i$f$removeValueIf = false;
                                        IdentityScopeMap this_$iv$iv = this_$iv;
                                        int[] valueOrder$iv$iv = this_$iv$iv.getValueOrder();
                                        IdentityArraySet[] scopeSets$iv$iv = this_$iv$iv.getScopeSets();
                                        Object[] values$iv$iv = this_$iv$iv.getValues();
                                        int destinationIndex$iv$iv = 0;
                                        int i$iv$iv = 0;
                                        int size2 = this_$iv$iv.getSize();
                                        while (i$iv$iv < size2) {
                                            int valueIndex$iv$iv = valueOrder$iv$iv[i$iv$iv];
                                            IdentityArraySet set$iv$iv = scopeSets$iv$iv[valueIndex$iv$iv];
                                            Intrinsics.checkNotNull(set$iv$iv);
                                            IdentityArraySet this_$iv$iv2 = set$iv$iv;
                                            Object[] values$iv$iv2 = this_$iv$iv2.getValues();
                                            int size$iv$iv2 = this_$iv$iv2.size();
                                            int i2 = i;
                                            int destinationIndex$iv$iv2 = 0;
                                            String sectionName$iv3 = sectionName$iv2;
                                            int i$iv$iv2 = 0;
                                            while (true) {
                                                $i$f$trace = size$iv$iv;
                                                $i$f$trace2 = size$iv$iv2;
                                                if (i$iv$iv2 >= $i$f$trace2) {
                                                    break;
                                                }
                                                IdentityScopeMap this_$iv2 = this_$iv;
                                                Object item$iv$iv = values$iv$iv2[i$iv$iv2];
                                                int $i$f$removeValueIf2 = $i$f$removeValueIf;
                                                Intrinsics.checkNotNull(item$iv$iv, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                                if (!(!((RecomposeScopeImpl) item$iv$iv).getValid())) {
                                                    if (destinationIndex$iv$iv2 != i$iv$iv2) {
                                                        values$iv$iv2[destinationIndex$iv$iv2] = item$iv$iv;
                                                    }
                                                    destinationIndex$iv$iv2++;
                                                }
                                                i$iv$iv2++;
                                                this_$iv = this_$iv2;
                                                $i$f$removeValueIf = $i$f$removeValueIf2;
                                                size$iv$iv2 = $i$f$trace2;
                                                size$iv$iv = $i$f$trace;
                                            }
                                            IdentityScopeMap identityScopeMap = this_$iv;
                                            int $i$f$removeValueIf3 = $i$f$removeValueIf;
                                            for (int i$iv$iv3 = destinationIndex$iv$iv2; i$iv$iv3 < $i$f$trace2; i$iv$iv3++) {
                                                values$iv$iv2[i$iv$iv3] = null;
                                            }
                                            this_$iv$iv2.size = destinationIndex$iv$iv2;
                                            if (set$iv$iv.size() > 0) {
                                                if (destinationIndex$iv$iv != i$iv$iv) {
                                                    int destinationKeyOrder$iv$iv = valueOrder$iv$iv[destinationIndex$iv$iv];
                                                    valueOrder$iv$iv[destinationIndex$iv$iv] = valueIndex$iv$iv;
                                                    valueOrder$iv$iv[i$iv$iv] = destinationKeyOrder$iv$iv;
                                                }
                                                destinationIndex$iv$iv++;
                                            }
                                            i$iv$iv++;
                                            sectionName$iv2 = sectionName$iv3;
                                            this_$iv = identityScopeMap;
                                            size$iv$iv = $i$f$trace;
                                            i = i2;
                                            $i$f$removeValueIf = $i$f$removeValueIf3;
                                        }
                                        int i3 = i;
                                        String str2 = sectionName$iv2;
                                        int i4 = size$iv$iv;
                                        IdentityScopeMap identityScopeMap2 = this_$iv;
                                        int i5 = $i$f$removeValueIf;
                                        int size3 = this_$iv$iv.getSize();
                                        for (int i$iv$iv4 = destinationIndex$iv$iv; i$iv$iv4 < size3; i$iv$iv4++) {
                                            values$iv$iv[valueOrder$iv$iv[i$iv$iv4]] = null;
                                        }
                                        this_$iv$iv.setSize(destinationIndex$iv$iv);
                                        cleanUpDerivedStateObservations();
                                        Unit unit3 = Unit.INSTANCE;
                                        Trace.INSTANCE.endSection(token$iv);
                                    } catch (Throwable th) {
                                        th = th;
                                        String str3 = sectionName$iv2;
                                        Trace.INSTANCE.endSection(token$iv);
                                        throw th;
                                    }
                                }
                                if (this.lateChanges.isEmpty()) {
                                    manager.dispatchAbandons();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            writer$iv.close();
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        String str4 = sectionName$iv;
                        writer$iv.close();
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    String str5 = sectionName$iv;
                    Trace.INSTANCE.endSection(token$iv2);
                    throw th;
                }
            } else if (this.lateChanges.isEmpty()) {
                manager.dispatchAbandons();
            }
        } catch (Throwable th6) {
            if (this.lateChanges.isEmpty()) {
                manager.dispatchAbandons();
            }
            throw th6;
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 11 */
    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Exception e$iv) {
                abandonChanges();
                throw e$iv;
            } catch (Throwable th) {
                if (0 == 0) {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                }
                throw th;
            }
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 11 */
    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (!this.lateChanges.isEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Exception e$iv) {
                abandonChanges();
                throw e$iv;
            } catch (Throwable th) {
                if (0 == 0) {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                }
                throw th;
            }
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 11 */
    public void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime_release();
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Exception e$iv) {
                abandonChanges();
                throw e$iv;
            } catch (Throwable th) {
                if (0 == 0) {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                }
                throw th;
            }
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>>, ? extends T> block) {
        IdentityArrayMap invalidations2 = takeInvalidations();
        try {
            return block.invoke(invalidations2);
        } catch (Exception e) {
            this.invalidations = invalidations2;
            throw e;
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 8 */
    private final <T> T guardChanges(Function0<? extends T> block) {
        try {
            T invoke = block.invoke();
            T t = invoke;
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Exception e) {
            abandonChanges();
            throw e;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (0 == 0 && (!this.abandonSet.isEmpty())) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    private final void abandonChanges() {
        this.pendingModifications.set((Object) null);
        this.changes.clear();
        this.lateChanges.clear();
        this.abandonSet.clear();
    }

    public void invalidateAll() {
        synchronized (this.lock) {
            for (Object it : this.slotTable.getSlots()) {
                RecomposeScopeImpl recomposeScopeImpl = it instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) it : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime_release();
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public <R> R delegateInvalidations(ControlledComposition to, int groupIndex, Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (to == null || Intrinsics.areEqual((Object) to, (Object) this) || groupIndex < 0) {
            return block.invoke();
        }
        this.invalidationDelegate = (CompositionImpl) to;
        this.invalidationDelegateGroup = groupIndex;
        try {
            return block.invoke();
        } finally {
            this.invalidationDelegate = null;
            this.invalidationDelegateGroup = 0;
        }
    }

    public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
        CompositionImpl compositionImpl;
        Intrinsics.checkNotNullParameter(scope, "scope");
        boolean z = true;
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!this.slotTable.ownsAnchor(anchor)) {
            synchronized (this.lock) {
                compositionImpl = this.invalidationDelegate;
            }
            CompositionImpl delegate = compositionImpl;
            if (delegate == null || !delegate.tryImminentInvalidation(scope, instance)) {
                z = false;
            }
            if (z) {
                return InvalidationResult.IMMINENT;
            }
            return InvalidationResult.IGNORED;
        } else if (!scope.getCanRecompose()) {
            return InvalidationResult.IGNORED;
        } else {
            return invalidateChecked(scope, anchor, instance);
        }
    }

    public void recomposeScopeReleased(RecomposeScopeImpl scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.pendingInvalidScopes = true;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl scope, Object instance) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime_release(scope, instance);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0037, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0038, code lost:
        if (r0 == null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003e, code lost:
        return r0.invalidateChecked(r9, r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003f, code lost:
        r8.parent.invalidate$runtime_release(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004b, code lost:
        if (isComposing() == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return androidx.compose.runtime.InvalidationResult.SCHEDULED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return androidx.compose.runtime.InvalidationResult.DEFERRED;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.InvalidationResult invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl r9, androidx.compose.runtime.Anchor r10, java.lang.Object r11) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.lock
            r1 = 0
            monitor-enter(r0)
            r2 = 0
            androidx.compose.runtime.CompositionImpl r3 = r8.invalidationDelegate     // Catch:{ all -> 0x0053 }
            r4 = 0
            if (r3 == 0) goto L_0x001a
            r5 = 0
            androidx.compose.runtime.SlotTable r6 = r8.slotTable     // Catch:{ all -> 0x0053 }
            int r7 = r8.invalidationDelegateGroup     // Catch:{ all -> 0x0053 }
            boolean r6 = r6.groupContainsAnchor(r7, r10)     // Catch:{ all -> 0x0053 }
            if (r6 == 0) goto L_0x0017
            r6 = r3
            goto L_0x0018
        L_0x0017:
            r6 = r4
        L_0x0018:
            goto L_0x001b
        L_0x001a:
            r6 = r4
        L_0x001b:
            r3 = r6
            if (r3 != 0) goto L_0x0035
            boolean r5 = r8.tryImminentInvalidation(r9, r11)     // Catch:{ all -> 0x0053 }
            if (r5 == 0) goto L_0x0028
            androidx.compose.runtime.InvalidationResult r4 = androidx.compose.runtime.InvalidationResult.IMMINENT     // Catch:{ all -> 0x0053 }
            monitor-exit(r0)
            return r4
        L_0x0028:
            if (r11 != 0) goto L_0x0030
            androidx.compose.runtime.collection.IdentityArrayMap<androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object>> r5 = r8.invalidations     // Catch:{ all -> 0x0053 }
            r5.set(r9, r4)     // Catch:{ all -> 0x0053 }
            goto L_0x0035
        L_0x0030:
            androidx.compose.runtime.collection.IdentityArrayMap<androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object>> r4 = r8.invalidations     // Catch:{ all -> 0x0053 }
            androidx.compose.runtime.CompositionKt.addValue(r4, r9, r11)     // Catch:{ all -> 0x0053 }
        L_0x0035:
            monitor-exit(r0)
            r0 = r3
            if (r0 == 0) goto L_0x003f
            androidx.compose.runtime.InvalidationResult r1 = r0.invalidateChecked(r9, r10, r11)
            return r1
        L_0x003f:
            androidx.compose.runtime.CompositionContext r1 = r8.parent
            r2 = r8
            androidx.compose.runtime.ControlledComposition r2 = (androidx.compose.runtime.ControlledComposition) r2
            r1.invalidate$runtime_release(r2)
            boolean r1 = r8.isComposing()
            if (r1 == 0) goto L_0x0050
            androidx.compose.runtime.InvalidationResult r1 = androidx.compose.runtime.InvalidationResult.DEFERRED
            goto L_0x0052
        L_0x0050:
            androidx.compose.runtime.InvalidationResult r1 = androidx.compose.runtime.InvalidationResult.SCHEDULED
        L_0x0052:
            return r1
        L_0x0053:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.Anchor, java.lang.Object):androidx.compose.runtime.InvalidationResult");
    }

    public final void removeObservation$runtime_release(Object instance, RecomposeScopeImpl scope) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.observations.remove(instance, scope);
    }

    public final void removeDerivedStateObservation$runtime_release(DerivedState<?> state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!this.observations.contains(state)) {
            this.derivedStates.removeScope(state);
        }
    }

    private final IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations() {
        IdentityArrayMap invalidations2 = this.invalidations;
        this.invalidations = new IdentityArrayMap<>(0, 1, (DefaultConstructorMarker) null);
        return invalidations2;
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable2) {
        SlotTable slotTable3 = slotTable2;
        Object[] $this$mapNotNull$iv = slotTable2.getSlots();
        Collection destination$iv$iv = new ArrayList();
        for (Object it : $this$mapNotNull$iv) {
            Object it$iv$iv = it instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) it : null;
            if (it$iv$iv != null) {
                destination$iv$iv.add(it$iv$iv);
            }
        }
        List $this$fastForEach$iv = (List) destination$iv$iv;
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (index$iv < size) {
            RecomposeScopeImpl scope = (RecomposeScopeImpl) $this$fastForEach$iv.get(index$iv);
            Anchor anchor = scope.getAnchor();
            if (anchor == null || slotTable3.slotsOf$runtime_release(anchor.toIndexFor(slotTable3)).contains(scope)) {
                index$iv++;
            } else {
                throw new IllegalStateException(("Misaligned anchor " + anchor + " in scope " + scope + " encountered, scope found at " + ArraysKt.indexOf((T[]) slotTable2.getSlots(), scope)).toString());
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private final <T> T trackAbandonedValues(Function0<? extends T> block) {
        try {
            T invoke = block.invoke();
            T t = invoke;
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (0 == 0 && (!this.abandonSet.isEmpty())) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\t\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0016\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "deactivating", "", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "forgetting", "releasing", "remembering", "sideEffects", "Lkotlin/Function0;", "", "instance", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", "sideEffect", "effect", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Composition.kt */
    private static final class RememberEventDispatcher implements RememberManager {
        private final Set<RememberObserver> abandoning;
        private List<ComposeNodeLifecycleCallback> deactivating;
        private final List<RememberObserver> forgetting = new ArrayList();
        private List<ComposeNodeLifecycleCallback> releasing;
        private final List<RememberObserver> remembering = new ArrayList();
        private final List<Function0<Unit>> sideEffects = new ArrayList();

        public RememberEventDispatcher(Set<RememberObserver> abandoning2) {
            Intrinsics.checkNotNullParameter(abandoning2, "abandoning");
            this.abandoning = abandoning2;
        }

        public void remembering(RememberObserver instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            int index = this.forgetting.lastIndexOf(instance);
            if (index >= 0) {
                this.forgetting.remove(index);
                this.abandoning.remove(instance);
                return;
            }
            this.remembering.add(instance);
        }

        public void forgetting(RememberObserver instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            int index = this.remembering.lastIndexOf(instance);
            if (index >= 0) {
                this.remembering.remove(index);
                this.abandoning.remove(instance);
                return;
            }
            this.forgetting.add(instance);
        }

        public void sideEffect(Function0<Unit> effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            this.sideEffects.add(effect);
        }

        public void deactivating(ComposeNodeLifecycleCallback instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            List it = this.deactivating;
            if (it == null) {
                it = new ArrayList();
                this.deactivating = it;
            }
            it.add(instance);
        }

        public void releasing(ComposeNodeLifecycleCallback instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            List it = this.releasing;
            if (it == null) {
                it = new ArrayList();
                this.releasing = it;
            }
            it.add(instance);
        }

        /* JADX INFO: finally extract failed */
        public final void dispatchRememberObservers() {
            List<ComposeNodeLifecycleCallback> list = this.deactivating;
            Collection collection = list;
            if (!(collection == null || collection.isEmpty())) {
                Object token$iv = Trace.INSTANCE.beginSection("Compose:deactivations");
                try {
                    for (int i = list.size() - 1; -1 < i; i--) {
                        list.get(i).onDeactivate();
                    }
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(token$iv);
                    list.clear();
                } catch (Throwable th) {
                    Trace.INSTANCE.endSection(token$iv);
                    throw th;
                }
            }
            if (!this.forgetting.isEmpty()) {
                Object token$iv2 = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    for (int i2 = this.forgetting.size() - 1; -1 < i2; i2--) {
                        RememberObserver instance = this.forgetting.get(i2);
                        if (!this.abandoning.contains(instance)) {
                            instance.onForgotten();
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(token$iv2);
                }
            }
            if (!this.remembering.isEmpty()) {
                Object token$iv3 = Trace.INSTANCE.beginSection("Compose:onRemembered");
                try {
                    List $this$fastForEach$iv = this.remembering;
                    int size = $this$fastForEach$iv.size();
                    for (int index$iv = 0; index$iv < size; index$iv++) {
                        RememberObserver instance2 = $this$fastForEach$iv.get(index$iv);
                        this.abandoning.remove(instance2);
                        instance2.onRemembered();
                    }
                    Unit unit3 = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(token$iv3);
                }
            }
            List<ComposeNodeLifecycleCallback> list2 = this.releasing;
            Collection collection2 = list2;
            if (!(collection2 == null || collection2.isEmpty())) {
                Object token$iv4 = Trace.INSTANCE.beginSection("Compose:releases");
                try {
                    for (int i3 = list2.size() - 1; -1 < i3; i3--) {
                        list2.get(i3).onRelease();
                    }
                    Unit unit4 = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(token$iv4);
                    list2.clear();
                } catch (Throwable th2) {
                    Trace.INSTANCE.endSection(token$iv4);
                    throw th2;
                }
            }
        }

        public final void dispatchSideEffects() {
            if (!this.sideEffects.isEmpty()) {
                Object token$iv = Trace.INSTANCE.beginSection("Compose:sideeffects");
                try {
                    List $this$fastForEach$iv = this.sideEffects;
                    int size = $this$fastForEach$iv.size();
                    for (int index$iv = 0; index$iv < size; index$iv++) {
                        $this$fastForEach$iv.get(index$iv).invoke();
                    }
                    this.sideEffects.clear();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(token$iv);
                }
            }
        }

        public final void dispatchAbandons() {
            if (!this.abandoning.isEmpty()) {
                Object token$iv = Trace.INSTANCE.beginSection("Compose:abandons");
                try {
                    Iterator iterator = this.abandoning.iterator();
                    while (iterator.hasNext()) {
                        iterator.remove();
                        iterator.next().onAbandoned();
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(token$iv);
                }
            }
        }
    }
}

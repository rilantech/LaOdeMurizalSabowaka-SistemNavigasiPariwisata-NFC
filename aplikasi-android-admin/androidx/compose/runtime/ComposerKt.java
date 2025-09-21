package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0000\u001a(\u0010C\u001a\u0004\u0018\u00010\u00012\b\u0010D\u001a\u0004\u0018\u00010\u00012\b\u0010E\u001a\u0004\u0018\u00010\u00012\b\u0010F\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\b\u0010G\u001a\u00020HH\u0007\u001aP\u0010I\u001a>\u0012\u0004\u0012\u0002HK\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HM0Lj\b\u0012\u0004\u0012\u0002HM`N0Jj\u001e\u0012\u0004\u0012\u0002HK\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HM0Lj\b\u0012\u0004\u0012\u0002HM`N`O\"\u0004\b\u0000\u0010K\"\u0004\b\u0001\u0010MH\u0002\u001a\u0010\u0010P\u001a\u00020\u00172\u0006\u0010D\u001a\u00020HH\u0000\u001a\"\u0010P\u001a\u00020\u00172\u0006\u0010D\u001a\u00020H2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00010RH\bø\u0001\u0000\u001a\u0018\u0010S\u001a\u00020\u00172\u0006\u0010T\u001a\u00020U2\u0006\u0010S\u001a\u00020BH\u0007\u001a\u0010\u0010V\u001a\u00020\u00172\u0006\u0010T\u001a\u00020UH\u0007\u001a \u0010W\u001a\u00020\u00172\u0006\u0010T\u001a\u00020U2\u0006\u0010X\u001a\u00020\u00072\u0006\u0010S\u001a\u00020BH\u0007\u001a\b\u0010Y\u001a\u00020\u0017H\u0007\u001a(\u0010Z\u001a\u00020\u00172\u0006\u0010X\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u00072\u0006\u0010]\u001a\u00020BH\u0007\u001a\u0018\u0010Z\u001a\u00020\u00172\u0006\u0010X\u001a\u00020\u00072\u0006\u0010]\u001a\u00020BH\u0007\u001a\f\u0010^\u001a\u00020H*\u00020\u0007H\u0002\u001a\f\u0010_\u001a\u00020\u0007*\u00020HH\u0002\u001a6\u0010`\u001a\u0002Ha\"\u0004\b\u0000\u0010a*\u00020U2\u0006\u0010b\u001a\u00020H2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u0002Ha0R¢\u0006\u0002\bdH\bø\u0001\u0000¢\u0006\u0002\u0010e\u001a\u001c\u0010f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010g*\u00020h2\u0006\u0010i\u001a\u00020jH\u0002\u001a\u001c\u0010k\u001a\u00020\u0007*\u00020l2\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u0007H\u0002\u001a(\u0010o\u001a\b\u0012\u0004\u0012\u00020q0p*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u0007H\u0002\u001a\u001a\u0010t\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010u\u001a\u00020\u0007H\u0002\u001a\u001a\u0010v\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010u\u001a\u00020\u0007H\u0002\u001a$\u0010w\u001a\u0004\u0018\u00010q*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u0007H\u0002\u001a,\u0010x\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010u\u001a\u00020\u00072\u0006\u0010y\u001a\u00020z2\b\u0010{\u001a\u0004\u0018\u00010\u0001H\u0002\u001a$\u0010|\u001a\u00020\u0007*\u00020l2\u0006\u0010}\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u00072\u0006\u0010\u001a\u00020\u0007H\u0002\u001a[\u0010\u0001\u001a\u0004\u0018\u0001HM\"\u0004\b\u0000\u0010K\"\u0004\b\u0001\u0010M*4\u0012\u0004\u0012\u0002HK\u0012\n\u0012\b\u0012\u0004\u0012\u0002HM0L0Jj\u001e\u0012\u0004\u0012\u0002HK\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HM0Lj\b\u0012\u0004\u0012\u0002HM`N`O2\u0006\u0010X\u001a\u0002HKH\u0002¢\u0006\u0003\u0010\u0001\u001aa\u0010\u0001\u001a\u00020H\"\u0004\b\u0000\u0010K\"\u0004\b\u0001\u0010M*4\u0012\u0004\u0012\u0002HK\u0012\n\u0012\b\u0012\u0004\u0012\u0002HM0L0Jj\u001e\u0012\u0004\u0012\u0002HK\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HM0Lj\b\u0012\u0004\u0012\u0002HM`N`O2\u0006\u0010X\u001a\u0002HK2\u0006\u0010D\u001a\u0002HMH\u0002¢\u0006\u0003\u0010\u0001\u001ac\u0010\u0001\u001a\u0004\u0018\u00010\u0017\"\u0004\b\u0000\u0010K\"\u0004\b\u0001\u0010M*4\u0012\u0004\u0012\u0002HK\u0012\n\u0012\b\u0012\u0004\u0012\u0002HM0L0Jj\u001e\u0012\u0004\u0012\u0002HK\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HM0Lj\b\u0012\u0004\u0012\u0002HM`N`O2\u0006\u0010X\u001a\u0002HK2\u0006\u0010D\u001a\u0002HMH\u0002¢\u0006\u0003\u0010\u0001\u001a\u0015\u0010\u0001\u001a\u00020\u0017*\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0000\u001a\u001d\u0010\u0001\u001a\u0004\u0018\u00010q*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010u\u001a\u00020\u0007H\u0002\u001a#\u0010\u0001\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u0007H\u0002\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"[\u0010\r\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u001c\u0010\u001a\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u0005\"\u0016\u0010\u001d\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0003\"\u000e\u0010\u001f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u001c\u0010 \u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0003\u001a\u0004\b\"\u0010\u0005\"\u0016\u0010#\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u0003\"\u001c\u0010%\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010\u0005\"\u0016\u0010(\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b)\u0010\u0003\"\u001c\u0010*\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0003\u001a\u0004\b,\u0010\u0005\"\u0016\u0010-\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b.\u0010\u0003\"\u001c\u0010/\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0003\u001a\u0004\b1\u0010\u0005\"\u0016\u00102\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b3\u0010\u0003\"[\u00104\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0004¢\u0006\u0002\n\u0000\"[\u00105\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0004¢\u0006\u0002\n\u0000\"\u0016\u00106\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b7\u0010\u0003\"\u000e\u00108\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"[\u00109\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0004¢\u0006\u0002\n\u0000\"[\u0010:\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010;\u001a\u00020\u0001*\u00020<8BX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>*\u0001\b\u0000\u0010\u0001\"K\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000e2K\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000e\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0001"}, d2 = {"compositionLocalMap", "", "getCompositionLocalMap$annotations", "()V", "getCompositionLocalMap", "()Ljava/lang/Object;", "compositionLocalMapKey", "", "getCompositionLocalMapKey$annotations", "compositionTracer", "Landroidx/compose/runtime/CompositionTracer;", "getCompositionTracer$annotations", "defaultsKey", "endGroupInstance", "Lkotlin/Function3;", "Landroidx/compose/runtime/Applier;", "Lkotlin/ParameterName;", "name", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "invalidGroupLocation", "invocation", "getInvocation$annotations", "getInvocation", "invocationKey", "getInvocationKey$annotations", "nodeKey", "provider", "getProvider$annotations", "getProvider", "providerKey", "getProviderKey$annotations", "providerMaps", "getProviderMaps$annotations", "getProviderMaps", "providerMapsKey", "getProviderMapsKey$annotations", "providerValues", "getProviderValues$annotations", "getProviderValues", "providerValuesKey", "getProviderValuesKey$annotations", "reference", "getReference$annotations", "getReference", "referenceKey", "getReferenceKey$annotations", "removeCurrentGroupInstance", "resetSlotsInstance", "reuseKey", "getReuseKey$annotations", "rootKey", "skipToGroupEndInstance", "startRootGroup", "joinedKey", "Landroidx/compose/runtime/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/KeyInfo;)Ljava/lang/Object;", "composeRuntimeError", "", "message", "", "getKey", "value", "left", "right", "isTraceInProgress", "", "multiMap", "Ljava/util/HashMap;", "K", "Ljava/util/LinkedHashSet;", "V", "Lkotlin/collections/LinkedHashSet;", "Lkotlin/collections/HashMap;", "runtimeCheck", "lazyMessage", "Lkotlin/Function0;", "sourceInformation", "composer", "Landroidx/compose/runtime/Composer;", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "key", "traceEventEnd", "traceEventStart", "dirty1", "dirty2", "info", "asBool", "asInt", "cache", "T", "invalid", "block", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Landroidx/compose/runtime/Composer;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "collectNodesFrom", "", "Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "distanceFrom", "Landroidx/compose/runtime/SlotReader;", "index", "root", "filterToRange", "", "Landroidx/compose/runtime/Invalidation;", "start", "end", "findInsertLocation", "location", "findLocation", "firstInRange", "insertIfMissing", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "instance", "nearestCommonRootOf", "a", "b", "common", "pop", "(Ljava/util/HashMap;Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)Z", "remove", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Unit;", "removeCurrentGroup", "removeLocation", "removeRange", "Change", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
public final class ComposerKt {
    private static final Object compositionLocalMap = new OpaqueKey("compositionLocalMap");
    public static final int compositionLocalMapKey = 202;
    /* access modifiers changed from: private */
    public static CompositionTracer compositionTracer = null;
    private static final int defaultsKey = -127;
    /* access modifiers changed from: private */
    public static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> endGroupInstance = ComposerKt$endGroupInstance$1.INSTANCE;
    private static final int invalidGroupLocation = -2;
    private static final Object invocation = new OpaqueKey("provider");
    public static final int invocationKey = 200;
    private static final int nodeKey = 125;
    private static final Object provider = new OpaqueKey("provider");
    public static final int providerKey = 201;
    private static final Object providerMaps = new OpaqueKey("providers");
    public static final int providerMapsKey = 204;
    private static final Object providerValues = new OpaqueKey("providerValues");
    public static final int providerValuesKey = 203;
    private static final Object reference = new OpaqueKey("reference");
    public static final int referenceKey = 206;
    /* access modifiers changed from: private */
    public static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> removeCurrentGroupInstance = ComposerKt$removeCurrentGroupInstance$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> resetSlotsInstance = ComposerKt$resetSlotsInstance$1.INSTANCE;
    public static final int reuseKey = 207;
    private static final int rootKey = 100;
    /* access modifiers changed from: private */
    public static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> skipToGroupEndInstance = ComposerKt$skipToGroupEndInstance$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> startRootGroup = ComposerKt$startRootGroup$1.INSTANCE;

    public static /* synthetic */ void getCompositionLocalMap$annotations() {
    }

    public static /* synthetic */ void getCompositionLocalMapKey$annotations() {
    }

    private static /* synthetic */ void getCompositionTracer$annotations() {
    }

    public static /* synthetic */ void getInvocation$annotations() {
    }

    public static /* synthetic */ void getInvocationKey$annotations() {
    }

    public static /* synthetic */ void getProvider$annotations() {
    }

    public static /* synthetic */ void getProviderKey$annotations() {
    }

    public static /* synthetic */ void getProviderMaps$annotations() {
    }

    public static /* synthetic */ void getProviderMapsKey$annotations() {
    }

    public static /* synthetic */ void getProviderValues$annotations() {
    }

    public static /* synthetic */ void getProviderValuesKey$annotations() {
    }

    public static /* synthetic */ void getReference$annotations() {
    }

    public static /* synthetic */ void getReferenceKey$annotations() {
    }

    public static /* synthetic */ void getReuseKey$annotations() {
    }

    @ComposeCompilerApi
    public static final <T> T cache(Composer $this$cache, boolean invalid, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter($this$cache, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Object it = $this$cache.rememberedValue();
        if (!invalid && it != Composer.Companion.getEmpty()) {
            return it;
        }
        Object value = block.invoke();
        $this$cache.updateRememberedValue(value);
        return value;
    }

    @ComposeCompilerApi
    public static final void sourceInformation(Composer composer, String sourceInformation) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(sourceInformation, "sourceInformation");
        composer.sourceInformation(sourceInformation);
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerStart(Composer composer, int key, String sourceInformation) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(sourceInformation, "sourceInformation");
        composer.sourceInformationMarkerStart(key, sourceInformation);
    }

    @ComposeCompilerApi
    public static final boolean isTraceInProgress() {
        CompositionTracer it = compositionTracer;
        return it != null && it.isTraceInProgress();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload with $dirty metadata instead", replaceWith = @ReplaceWith(expression = "traceEventStart(key, dirty1, dirty2, info)", imports = {}))
    @ComposeCompilerApi
    public static final /* synthetic */ void traceEventStart(int key, String info) {
        Intrinsics.checkNotNullParameter(info, "info");
        traceEventStart(key, -1, -1, info);
    }

    @ComposeCompilerApi
    public static final void traceEventStart(int key, int dirty1, int dirty2, String info) {
        Intrinsics.checkNotNullParameter(info, "info");
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventStart(key, dirty1, dirty2, info);
        }
    }

    @ComposeCompilerApi
    public static final void traceEventEnd() {
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventEnd();
        }
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerEnd(Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        composer.sourceInformationMarkerEnd();
    }

    public static final void removeCurrentGroup(SlotWriter $this$removeCurrentGroup, RememberManager rememberManager) {
        Intrinsics.checkNotNullParameter($this$removeCurrentGroup, "<this>");
        Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
        Iterator<Object> groupSlots = $this$removeCurrentGroup.groupSlots();
        while (groupSlots.hasNext()) {
            Object slot = groupSlots.next();
            if (slot instanceof ComposeNodeLifecycleCallback) {
                rememberManager.releasing((ComposeNodeLifecycleCallback) slot);
            }
            if (slot instanceof RememberObserver) {
                rememberManager.forgetting((RememberObserver) slot);
            }
            if (slot instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) slot).release();
            }
        }
        $this$removeCurrentGroup.removeGroup();
    }

    /* access modifiers changed from: private */
    public static final <K, V> HashMap<K, LinkedHashSet<V>> multiMap() {
        return new HashMap<>();
    }

    /* access modifiers changed from: private */
    public static final <K, V> boolean put(HashMap<K, LinkedHashSet<V>> $this$put, K key, V value) {
        Object answer$iv;
        Map $this$getOrPut$iv = $this$put;
        Object value$iv = $this$getOrPut$iv.get(key);
        if (value$iv == null) {
            answer$iv = new LinkedHashSet();
            $this$getOrPut$iv.put(key, answer$iv);
        } else {
            answer$iv = value$iv;
        }
        return ((LinkedHashSet) answer$iv).add(value);
    }

    private static final <K, V> Unit remove(HashMap<K, LinkedHashSet<V>> $this$remove, K key, V value) {
        LinkedHashSet it = $this$remove.get(key);
        if (it == null) {
            return null;
        }
        it.remove(value);
        if (it.isEmpty()) {
            $this$remove.remove(key);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final <K, V> V pop(HashMap<K, LinkedHashSet<V>> $this$pop, K key) {
        Object it;
        LinkedHashSet linkedHashSet = $this$pop.get(key);
        if (linkedHashSet == null || (it = CollectionsKt.firstOrNull(linkedHashSet)) == null) {
            return null;
        }
        remove($this$pop, key, it);
        return it;
    }

    /* access modifiers changed from: private */
    public static final Object getKey(Object value, Object left, Object right) {
        Object obj;
        JoinedKey it = value instanceof JoinedKey ? (JoinedKey) value : null;
        if (it == null) {
            return null;
        }
        if (!Intrinsics.areEqual(it.getLeft(), left) || !Intrinsics.areEqual(it.getRight(), right)) {
            obj = getKey(it.getLeft(), left, right);
            if (obj == null) {
                obj = getKey(it.getRight(), left, right);
            }
        } else {
            obj = value;
        }
        return obj;
    }

    private static final int findLocation(List<Invalidation> $this$findLocation, int location) {
        int low = 0;
        int high = $this$findLocation.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = Intrinsics.compare($this$findLocation.get(mid).getLocation(), location);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    private static final int findInsertLocation(List<Invalidation> $this$findInsertLocation, int location) {
        int it = findLocation($this$findInsertLocation, location);
        return it < 0 ? -(it + 1) : it;
    }

    /* access modifiers changed from: private */
    public static final void insertIfMissing(List<Invalidation> $this$insertIfMissing, int location, RecomposeScopeImpl scope, Object instance) {
        int index = findLocation($this$insertIfMissing, location);
        IdentityArraySet identityArraySet = null;
        if (index < 0) {
            int i = -(index + 1);
            if (instance != null) {
                IdentityArraySet it = new IdentityArraySet();
                it.add(instance);
                identityArraySet = it;
            }
            $this$insertIfMissing.add(i, new Invalidation(scope, location, identityArraySet));
        } else if (instance == null) {
            $this$insertIfMissing.get(index).setInstances((IdentityArraySet<Object>) null);
        } else {
            IdentityArraySet<Object> instances = $this$insertIfMissing.get(index).getInstances();
            if (instances != null) {
                instances.add(instance);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Invalidation firstInRange(List<Invalidation> $this$firstInRange, int start, int end) {
        int index = findInsertLocation($this$firstInRange, start);
        if (index >= $this$firstInRange.size()) {
            return null;
        }
        Invalidation firstInvalidation = $this$firstInRange.get(index);
        if (firstInvalidation.getLocation() < end) {
            return firstInvalidation;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final Invalidation removeLocation(List<Invalidation> $this$removeLocation, int location) {
        int index = findLocation($this$removeLocation, location);
        if (index >= 0) {
            return $this$removeLocation.remove(index);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final void removeRange(List<Invalidation> $this$removeRange, int start, int end) {
        int index = findInsertLocation($this$removeRange, start);
        while (index < $this$removeRange.size() && $this$removeRange.get(index).getLocation() < end) {
            $this$removeRange.remove(index);
        }
    }

    /* access modifiers changed from: private */
    public static final List<Invalidation> filterToRange(List<Invalidation> $this$filterToRange, int start, int end) {
        List result = new ArrayList();
        for (int index = findInsertLocation($this$filterToRange, start); index < $this$filterToRange.size(); index++) {
            Invalidation invalidation = $this$filterToRange.get(index);
            if (invalidation.getLocation() >= end) {
                break;
            }
            result.add(invalidation);
        }
        return result;
    }

    /* access modifiers changed from: private */
    public static final int asInt(boolean $this$asInt) {
        return $this$asInt;
    }

    /* access modifiers changed from: private */
    public static final boolean asBool(int $this$asBool) {
        return $this$asBool != 0;
    }

    /* access modifiers changed from: private */
    public static final List<Object> collectNodesFrom(SlotTable $this$collectNodesFrom, Anchor anchor) {
        List result = new ArrayList();
        SlotReader reader$iv = $this$collectNodesFrom.openReader();
        try {
            collectNodesFrom$lambda$9$collectFromGroup(reader$iv, result, $this$collectNodesFrom.anchorIndex(anchor));
            Unit unit = Unit.INSTANCE;
            return result;
        } finally {
            reader$iv.close();
        }
    }

    private static final void collectNodesFrom$lambda$9$collectFromGroup(SlotReader $reader, List<Object> result, int group) {
        if ($reader.isNode(group)) {
            result.add($reader.node(group));
            return;
        }
        int current = group + 1;
        int end = $reader.groupSize(group) + group;
        while (current < end) {
            collectNodesFrom$lambda$9$collectFromGroup($reader, result, current);
            current += $reader.groupSize(current);
        }
    }

    private static final int distanceFrom(SlotReader $this$distanceFrom, int index, int root) {
        int count = 0;
        int current = index;
        while (current > 0 && current != root) {
            current = $this$distanceFrom.parent(current);
            count++;
        }
        return count;
    }

    /* access modifiers changed from: private */
    public static final int nearestCommonRootOf(SlotReader $this$nearestCommonRootOf, int a, int b, int common) {
        if (a == b) {
            return a;
        }
        if (a == common || b == common) {
            return common;
        }
        if ($this$nearestCommonRootOf.parent(a) == b) {
            return b;
        }
        if ($this$nearestCommonRootOf.parent(b) == a) {
            return a;
        }
        if ($this$nearestCommonRootOf.parent(a) == $this$nearestCommonRootOf.parent(b)) {
            return $this$nearestCommonRootOf.parent(a);
        }
        int currentA = a;
        int currentB = b;
        int aDistance = distanceFrom($this$nearestCommonRootOf, a, common);
        int bDistance = distanceFrom($this$nearestCommonRootOf, b, common);
        int i = aDistance - bDistance;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2;
            currentA = $this$nearestCommonRootOf.parent(currentA);
        }
        int i4 = bDistance - aDistance;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5;
            currentB = $this$nearestCommonRootOf.parent(currentB);
        }
        while (currentA != currentB) {
            currentA = $this$nearestCommonRootOf.parent(currentA);
            currentB = $this$nearestCommonRootOf.parent(currentB);
        }
        return currentA;
    }

    /* access modifiers changed from: private */
    public static final Object getJoinedKey(KeyInfo $this$joinedKey) {
        return $this$joinedKey.getObjectKey() != null ? new JoinedKey(Integer.valueOf($this$joinedKey.getKey()), $this$joinedKey.getObjectKey()) : Integer.valueOf($this$joinedKey.getKey());
    }

    public static final Object getInvocation() {
        return invocation;
    }

    public static final Object getProvider() {
        return provider;
    }

    public static final Object getCompositionLocalMap() {
        return compositionLocalMap;
    }

    public static final Object getProviderValues() {
        return providerValues;
    }

    public static final Object getProviderMaps() {
        return providerMaps;
    }

    public static final Object getReference() {
        return reference;
    }

    public static final void runtimeCheck(boolean value, Function0<? extends Object> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (!value) {
            composeRuntimeError(lazyMessage.invoke().toString());
            throw new KotlinNothingValueException();
        }
    }

    public static final void runtimeCheck(boolean value) {
        if (!value) {
            composeRuntimeError("Check failed".toString());
            throw new KotlinNothingValueException();
        }
    }

    public static final Void composeRuntimeError(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + message + "). Please report to Google or use https://goo.gle/compose-feedback");
    }
}

package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0006\u001aU\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062<\u0010\u0007\u001a8\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0002\b\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a?\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0014*\u0014\u0012\u0004\u0012\u0002H\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00160\u00152\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u0002H\u0014H\u0000¢\u0006\u0002\u0010\u0019\u001a9\u0010\u001a\u001a\u0004\u0018\u0001H\u0014\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0014*\u0014\u0012\u0004\u0012\u0002H\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00160\u00152\u0006\u0010\u0017\u001a\u0002H\u0013H\u0000¢\u0006\u0002\u0010\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"FramePending", "", "ProduceAnotherFrame", "RecomposerCompoundHashKey", "", "withRunningRecomposer", "R", "block", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/Recomposer;", "Lkotlin/ParameterName;", "name", "recomposer", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addMultiValue", "", "K", "V", "", "", "key", "value", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Z", "removeLastMultiValue", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Recomposer.kt */
public final class RecomposerKt {
    /* access modifiers changed from: private */
    public static final Object FramePending = new Object();
    /* access modifiers changed from: private */
    public static final Object ProduceAnotherFrame = new Object();
    private static final int RecomposerCompoundHashKey = 1000;

    public static final <R> Object withRunningRecomposer(Function3<? super CoroutineScope, ? super Recomposer, ? super Continuation<? super R>, ? extends Object> block, Continuation<? super R> $completion) {
        return CoroutineScopeKt.coroutineScope(new RecomposerKt$withRunningRecomposer$2(block, (Continuation<? super RecomposerKt$withRunningRecomposer$2>) null), $completion);
    }

    public static final <K, V> boolean addMultiValue(Map<K, List<V>> $this$addMultiValue, K key, V value) {
        Object answer$iv;
        Intrinsics.checkNotNullParameter($this$addMultiValue, "<this>");
        Map $this$getOrPut$iv = $this$addMultiValue;
        Object value$iv = $this$getOrPut$iv.get(key);
        if (value$iv == null) {
            answer$iv = (List) new ArrayList();
            $this$getOrPut$iv.put(key, answer$iv);
        } else {
            answer$iv = value$iv;
        }
        return ((List) answer$iv).add(value);
    }

    public static final <K, V> V removeLastMultiValue(Map<K, List<V>> $this$removeLastMultiValue, K key) {
        Intrinsics.checkNotNullParameter($this$removeLastMultiValue, "<this>");
        List list = $this$removeLastMultiValue.get(key);
        if (list == null) {
            return null;
        }
        V removeFirst = CollectionsKt.removeFirst(list);
        V v = removeFirst;
        if (!list.isEmpty()) {
            return removeFirst;
        }
        $this$removeLastMultiValue.remove(key);
        return removeFirst;
    }
}

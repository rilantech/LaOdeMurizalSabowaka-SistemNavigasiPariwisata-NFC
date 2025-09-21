package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0003J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0016J:\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Landroidx/compose/runtime/reflect/ComposableMethod;", "", "method", "Ljava/lang/reflect/Method;", "composableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "(Ljava/lang/reflect/Method;Landroidx/compose/runtime/reflect/ComposableInfo;)V", "parameterCount", "", "getParameterCount", "()I", "parameterTypes", "", "Ljava/lang/Class;", "getParameterTypes", "()[Ljava/lang/Class;", "parameters", "Ljava/lang/reflect/Parameter;", "getParameters", "()[Ljava/lang/reflect/Parameter;", "asMethod", "equals", "", "other", "hashCode", "invoke", "composer", "Landroidx/compose/runtime/Composer;", "instance", "args", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposableMethod.kt */
public final class ComposableMethod {
    public static final int $stable = 8;
    private final ComposableInfo composableInfo;
    private final Method method;

    public ComposableMethod(Method method2, ComposableInfo composableInfo2) {
        Intrinsics.checkNotNullParameter(method2, "method");
        Intrinsics.checkNotNullParameter(composableInfo2, "composableInfo");
        this.method = method2;
        this.composableInfo = composableInfo2;
    }

    public final Method asMethod() {
        return this.method;
    }

    public final int getParameterCount() {
        return this.composableInfo.getRealParamsCount();
    }

    public final Parameter[] getParameters() {
        Parameter[] parameters = this.method.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "method.parameters");
        return (Parameter[]) ArraysKt.copyOfRange((T[]) (Object[]) parameters, 0, this.composableInfo.getRealParamsCount());
    }

    public final Class<?>[] getParameterTypes() {
        Class[] parameterTypes = this.method.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
        return (Class[]) ArraysKt.copyOfRange((T[]) (Object[]) parameterTypes, 0, this.composableInfo.getRealParamsCount());
    }

    public final Object invoke(Composer composer, Object instance, Object... args) {
        Object obj;
        Object[] objArr = args;
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(objArr, "args");
        ComposableInfo composableInfo2 = this.composableInfo;
        int realParamsCount = composableInfo2.component2();
        int changedParams = composableInfo2.component3();
        int defaultParams = composableInfo2.component4();
        int totalParams = this.method.getParameterTypes().length;
        int changedStartIndex = realParamsCount + 1;
        int defaultStartIndex = changedStartIndex + changedParams;
        Integer[] numArr = new Integer[defaultParams];
        int i = 0;
        while (i < defaultParams) {
            int start = i * 31;
            Iterable $this$map$iv = RangesKt.until(start, Math.min(start + 31, realParamsCount));
            int defaultParams2 = defaultParams;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            Iterator it = $this$map$iv.iterator();
            while (it.hasNext()) {
                int length = objArr.length;
                int changedParams2 = changedParams;
                int it2 = ((IntIterator) it).nextInt();
                destination$iv$iv.add(Integer.valueOf((it2 >= length || objArr[it2] == null) ? 1 : 0));
                Composer composer2 = composer;
                changedParams = changedParams2;
            }
            int changedParams3 = changedParams;
            int index$iv = 0;
            int accumulator$iv = 0;
            for (Object element$iv : (List) destination$iv$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                accumulator$iv |= ((Number) element$iv).intValue() << index$iv;
                index$iv = index$iv2;
            }
            numArr[i] = Integer.valueOf(accumulator$iv);
            i++;
            Composer composer3 = composer;
            defaultParams = defaultParams2;
            changedParams = changedParams3;
        }
        int i2 = changedParams;
        Integer[] defaultsMasks = numArr;
        Object[] arguments = new Object[totalParams];
        int i3 = 0;
        while (i3 < totalParams) {
            if (i3 >= 0 && i3 < realParamsCount) {
                if (i3 < 0 || i3 > ArraysKt.getLastIndex((T[]) args)) {
                    int i4 = i3;
                    Class cls = this.method.getParameterTypes()[i3];
                    Intrinsics.checkNotNullExpressionValue(cls, "method.parameterTypes[idx]");
                    obj = ComposableMethodKt.getDefaultValue(cls);
                } else {
                    obj = objArr[i3];
                }
            } else if (i3 == realParamsCount) {
                obj = composer;
            } else if (i3 == changedStartIndex) {
                obj = 0;
            } else {
                if (changedStartIndex + 1 <= i3 && i3 < defaultStartIndex) {
                    obj = 0;
                } else {
                    if (defaultStartIndex <= i3 && i3 < totalParams) {
                        obj = defaultsMasks[i3 - defaultStartIndex];
                    } else {
                        throw new IllegalStateException("Unexpected index".toString());
                    }
                }
            }
            arguments[i3] = obj;
            i3++;
        }
        return this.method.invoke(instance, Arrays.copyOf(arguments, arguments.length));
    }

    public boolean equals(Object other) {
        if (other instanceof ComposableMethod) {
            return Intrinsics.areEqual((Object) this.method, (Object) ((ComposableMethod) other).method);
        }
        return false;
    }

    public int hashCode() {
        return this.method.hashCode();
    }
}

package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composition.kt */
public final class ComposableSingletons$CompositionKt {
    public static final ComposableSingletons$CompositionKt INSTANCE = new ComposableSingletons$CompositionKt();

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f52lambda1 = ComposableLambdaKt.composableLambdaInstance(954879418, false, ComposableSingletons$CompositionKt$lambda1$1.INSTANCE);

    /* renamed from: lambda-2  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f53lambda2 = ComposableLambdaKt.composableLambdaInstance(1918065384, false, ComposableSingletons$CompositionKt$lambda2$1.INSTANCE);

    /* renamed from: getLambda-1$runtime_release  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4550getLambda1$runtime_release() {
        return f52lambda1;
    }

    /* renamed from: getLambda-2$runtime_release  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4551getLambda2$runtime_release() {
        return f53lambda2;
    }
}

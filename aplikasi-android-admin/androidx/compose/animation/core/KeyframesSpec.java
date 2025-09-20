package androidx.compose.animation.core;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u0014\u0015B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J,\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\b\b\u0001\u0010\u0010*\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Landroidx/compose/animation/core/KeyframesSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "config", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "(Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;)V", "getConfig", "()Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "equals", "", "other", "", "hashCode", "", "vectorize", "Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "KeyframeEntity", "KeyframesSpecConfig", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimationSpec.kt */
public final class KeyframesSpec<T> implements DurationBasedAnimationSpec<T> {
    public static final int $stable = 0;
    private final KeyframesSpecConfig<T> config;

    public KeyframesSpec(KeyframesSpecConfig<T> config2) {
        Intrinsics.checkNotNullParameter(config2, "config");
        this.config = config2;
    }

    public final KeyframesSpecConfig<T> getConfig() {
        return this.config;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0016J \u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f*\u00028\u00012\u0006\u0010\u0017\u001a\u00020\u0005H\u0004¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f*\u00028\u00012\u0006\u0010\u001a\u001a\u00020\u001bH\u0004¢\u0006\u0002\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u001e*\b\u0012\u0004\u0012\u00028\u00010\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0004R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000f0\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "T", "", "()V", "delayMillis", "", "getDelayMillis", "()I", "setDelayMillis", "(I)V", "durationMillis", "getDurationMillis", "setDurationMillis", "keyframes", "", "Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "getKeyframes$animation_core_release", "()Ljava/util/Map;", "equals", "", "other", "hashCode", "at", "timeStamp", "(Ljava/lang/Object;I)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "atFraction", "fraction", "", "(Ljava/lang/Object;F)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "with", "", "easing", "Landroidx/compose/animation/core/Easing;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimationSpec.kt */
    public static final class KeyframesSpecConfig<T> {
        public static final int $stable = 8;
        private int delayMillis;
        private int durationMillis = 300;
        private final Map<Integer, KeyframeEntity<T>> keyframes = new LinkedHashMap();

        public final int getDurationMillis() {
            return this.durationMillis;
        }

        public final void setDurationMillis(int i) {
            this.durationMillis = i;
        }

        public final int getDelayMillis() {
            return this.delayMillis;
        }

        public final void setDelayMillis(int i) {
            this.delayMillis = i;
        }

        public final Map<Integer, KeyframeEntity<T>> getKeyframes$animation_core_release() {
            return this.keyframes;
        }

        public final KeyframeEntity<T> at(T $this$at, int timeStamp) {
            KeyframeEntity it = new KeyframeEntity($this$at, (Easing) null, 2, (DefaultConstructorMarker) null);
            Integer valueOf = Integer.valueOf(timeStamp);
            this.keyframes.put(valueOf, it);
            return it;
        }

        public final KeyframeEntity<T> atFraction(T $this$atFraction, float fraction) {
            return at($this$atFraction, MathKt.roundToInt(((float) this.durationMillis) * fraction));
        }

        public final void with(KeyframeEntity<T> $this$with, Easing easing) {
            Intrinsics.checkNotNullParameter($this$with, "<this>");
            Intrinsics.checkNotNullParameter(easing, "easing");
            $this$with.setEasing$animation_core_release(easing);
        }

        public boolean equals(Object other) {
            return (other instanceof KeyframesSpecConfig) && this.delayMillis == ((KeyframesSpecConfig) other).delayMillis && this.durationMillis == ((KeyframesSpecConfig) other).durationMillis && Intrinsics.areEqual((Object) this.keyframes, (Object) ((KeyframesSpecConfig) other).keyframes);
        }

        public int hashCode() {
            return (((this.durationMillis * 31) + this.delayMillis) * 31) + this.keyframes.hashCode();
        }
    }

    public boolean equals(Object other) {
        return (other instanceof KeyframesSpec) && Intrinsics.areEqual((Object) this.config, (Object) ((KeyframesSpec) other).config);
    }

    public int hashCode() {
        return this.config.hashCode();
    }

    public <V extends AnimationVector> VectorizedKeyframesSpec<V> vectorize(TwoWayConverter<T, V> converter) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        Map $this$mapValuesTo$iv$iv = this.config.getKeyframes$animation_core_release();
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValuesTo$iv$iv.size()));
        for (Object element$iv$iv$iv : $this$mapValuesTo$iv$iv.entrySet()) {
            destination$iv$iv.put(((Map.Entry) element$iv$iv$iv).getKey(), ((KeyframeEntity) ((Map.Entry) element$iv$iv$iv).getValue()).toPair$animation_core_release(converter.getConvertToVector()));
        }
        return new VectorizedKeyframesSpec<>(destination$iv$iv, this.config.getDurationMillis(), this.config.getDelayMillis());
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J7\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00050\u0014\"\b\b\u0002\u0010\u0015*\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u00150\u0018H\u0000¢\u0006\u0002\b\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00028\u0001X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "T", "", "value", "easing", "Landroidx/compose/animation/core/Easing;", "(Ljava/lang/Object;Landroidx/compose/animation/core/Easing;)V", "getEasing$animation_core_release", "()Landroidx/compose/animation/core/Easing;", "setEasing$animation_core_release", "(Landroidx/compose/animation/core/Easing;)V", "getValue$animation_core_release", "()Ljava/lang/Object;", "Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toPair", "Lkotlin/Pair;", "V", "Landroidx/compose/animation/core/AnimationVector;", "convertToVector", "Lkotlin/Function1;", "toPair$animation_core_release", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimationSpec.kt */
    public static final class KeyframeEntity<T> {
        public static final int $stable = 8;
        private Easing easing;
        private final T value;

        public KeyframeEntity(T value2, Easing easing2) {
            Intrinsics.checkNotNullParameter(easing2, "easing");
            this.value = value2;
            this.easing = easing2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ KeyframeEntity(Object obj, Easing easing2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i & 2) != 0 ? EasingKt.getLinearEasing() : easing2);
        }

        public final T getValue$animation_core_release() {
            return this.value;
        }

        public final Easing getEasing$animation_core_release() {
            return this.easing;
        }

        public final void setEasing$animation_core_release(Easing easing2) {
            Intrinsics.checkNotNullParameter(easing2, "<set-?>");
            this.easing = easing2;
        }

        public final <V extends AnimationVector> Pair<V, Easing> toPair$animation_core_release(Function1<? super T, ? extends V> convertToVector) {
            Intrinsics.checkNotNullParameter(convertToVector, "convertToVector");
            return TuplesKt.to(convertToVector.invoke(this.value), this.easing);
        }

        public boolean equals(Object other) {
            return (other instanceof KeyframeEntity) && Intrinsics.areEqual((Object) ((KeyframeEntity) other).value, (Object) this.value) && Intrinsics.areEqual((Object) ((KeyframeEntity) other).easing, (Object) this.easing);
        }

        public int hashCode() {
            T t = this.value;
            return ((t != null ? t.hashCode() : 0) * 31) + this.easing.hashCode();
        }
    }
}

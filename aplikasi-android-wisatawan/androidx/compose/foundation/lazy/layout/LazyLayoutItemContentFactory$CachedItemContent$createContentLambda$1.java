package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutItemContentFactory.kt */
final class LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ LazyLayoutItemContentFactory this$0;
    final /* synthetic */ LazyLayoutItemContentFactory.CachedItemContent this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, LazyLayoutItemContentFactory.CachedItemContent cachedItemContent) {
        super(2);
        this.this$0 = lazyLayoutItemContentFactory;
        this.this$1 = cachedItemContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        int index;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C99@3691L258,107@3962L219:LazyLayoutItemContentFactory.kt#wow0x6");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1403994769, i, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:90)");
            }
            LazyLayoutItemProvider itemProvider = this.this$0.getItemProvider().invoke();
            int index2 = this.this$1.getIndex();
            if (index2 >= itemProvider.getItemCount() || !Intrinsics.areEqual(itemProvider.getKey(index2), this.this$1.getKey())) {
                int index3 = itemProvider.getIndex(this.this$1.getKey());
                if (index3 != -1) {
                    this.this$1.index = index3;
                }
                index = index3;
            } else {
                index = index2;
            }
            boolean active$iv = index != -1;
            LazyLayoutItemContentFactory lazyLayoutItemContentFactory = this.this$0;
            LazyLayoutItemContentFactory.CachedItemContent cachedItemContent = this.this$1;
            composer.startReusableGroup(ComposerKt.reuseKey, Boolean.valueOf(active$iv));
            boolean activeChanged$iv = composer.changed(active$iv);
            if (active$iv) {
                int i2 = (0 >> 3) & 14;
                Composer $composer2 = $composer;
                ComposerKt.sourceInformationMarkerStart($composer2, -1642427977, "C100@3751L184:LazyLayoutItemContentFactory.kt#wow0x6");
                LazyLayoutItemContentFactoryKt.m734SkippableItemJVlU9Rs(itemProvider, StableValue.m764constructorimpl(lazyLayoutItemContentFactory.saveableStateHolder), index, StableValue.m764constructorimpl(cachedItemContent.getKey()), $composer2, 0);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                composer.deactivateToEndGroup(activeChanged$iv);
            }
            $composer.endReusableGroup();
            Object key = this.this$1.getKey();
            final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent2 = this.this$1;
            EffectsKt.DisposableEffect(key, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() {
                public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                    Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
                    DisposableEffectScope disposableEffectScope = $this$DisposableEffect;
                    return new LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$2$invoke$$inlined$onDispose$1(cachedItemContent2);
                }
            }, composer, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Landroid/graphics/Typeface;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.text.font.AndroidFontLoader_androidKt$loadAsync$2", f = "AndroidFontLoader.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AndroidFontLoader.android.kt */
final class AndroidFontLoader_androidKt$loadAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Typeface>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ResourceFont $this_loadAsync;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidFontLoader_androidKt$loadAsync$2(ResourceFont resourceFont, Context context, Continuation<? super AndroidFontLoader_androidKt$loadAsync$2> continuation) {
        super(2, continuation);
        this.$this_loadAsync = resourceFont;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidFontLoader_androidKt$loadAsync$2(this.$this_loadAsync, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Typeface> continuation) {
        return ((AndroidFontLoader_androidKt$loadAsync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                return AndroidFontLoader_androidKt.load(this.$this_loadAsync, this.$context);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a´\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0017\u001aS\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2>\b\u0002\u0010\u001c\u001a8\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 0\u0014ø\u0001\u0000\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020!2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\"\u001a\u0015\u0010#\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0004\u001a\u0015\u0010'\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"AnimatedContent", "", "S", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "label", "", "contentKey", "Lkotlin/ParameterName;", "name", "", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "togetherWith", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "with", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
public final class AnimatedContentKt {
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S> void AnimatedContent(S r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentTransitionScope<S>, androidx.compose.animation.ContentTransform> r23, androidx.compose.ui.Alignment r24, java.lang.String r25, kotlin.jvm.functions.Function1<? super S, ? extends java.lang.Object> r26, kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedContentScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r10 = r21
            r11 = r27
            r12 = r29
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 2132720749(0x7f1ebc6d, float:2.1099639E38)
            r1 = r28
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedContent)P(5,4,6,1,3,2)140@7413L58,141@7487L136:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r29
            r2 = r30 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            goto L_0x0030
        L_0x0022:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x0030
            boolean r2 = r13.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x002e
            r2 = 4
            goto L_0x002f
        L_0x002e:
            r2 = 2
        L_0x002f:
            r1 = r1 | r2
        L_0x0030:
            r2 = r30 & 2
            if (r2 == 0) goto L_0x0039
            r1 = r1 | 48
            r3 = r22
            goto L_0x004e
        L_0x0039:
            r3 = r12 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004c
            r3 = r22
            boolean r4 = r13.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0048
            r4 = 32
            goto L_0x004a
        L_0x0048:
            r4 = 16
        L_0x004a:
            r1 = r1 | r4
            goto L_0x004e
        L_0x004c:
            r3 = r22
        L_0x004e:
            r4 = r30 & 4
            if (r4 == 0) goto L_0x0057
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r23
            goto L_0x006c
        L_0x0057:
            r5 = r12 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x006a
            r5 = r23
            boolean r6 = r13.changedInstance(r5)
            if (r6 == 0) goto L_0x0066
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r1 = r1 | r6
            goto L_0x006c
        L_0x006a:
            r5 = r23
        L_0x006c:
            r6 = r30 & 8
            if (r6 == 0) goto L_0x0075
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r24
            goto L_0x008a
        L_0x0075:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0088
            r7 = r24
            boolean r8 = r13.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0084
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r1 = r1 | r8
            goto L_0x008a
        L_0x0088:
            r7 = r24
        L_0x008a:
            r8 = r30 & 16
            r9 = 57344(0xe000, float:8.0356E-41)
            if (r8 == 0) goto L_0x0096
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r25
            goto L_0x00ab
        L_0x0096:
            r14 = r12 & r9
            if (r14 != 0) goto L_0x00a9
            r14 = r25
            boolean r15 = r13.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00a5
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a5:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a7:
            r1 = r1 | r15
            goto L_0x00ab
        L_0x00a9:
            r14 = r25
        L_0x00ab:
            r15 = r30 & 32
            r16 = 458752(0x70000, float:6.42848E-40)
            if (r15 == 0) goto L_0x00b8
            r17 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r17
            r9 = r26
            goto L_0x00ce
        L_0x00b8:
            r17 = r12 & r16
            if (r17 != 0) goto L_0x00cc
            r9 = r26
            boolean r17 = r13.changedInstance(r9)
            if (r17 == 0) goto L_0x00c7
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c9:
            r1 = r1 | r17
            goto L_0x00ce
        L_0x00cc:
            r9 = r26
        L_0x00ce:
            r17 = r30 & 64
            if (r17 == 0) goto L_0x00d7
            r17 = 1572864(0x180000, float:2.204052E-39)
        L_0x00d4:
            r1 = r1 | r17
            goto L_0x00e9
        L_0x00d7:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x00e9
            boolean r17 = r13.changedInstance(r11)
            if (r17 == 0) goto L_0x00e6
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d4
        L_0x00e6:
            r17 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00d4
        L_0x00e9:
            r17 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r1 & r17
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x0108
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x00fa
            goto L_0x0108
        L_0x00fa:
            r13.skipToGroupEnd()
            r17 = r22
            r16 = r1
            r19 = r5
            r20 = r7
            r15 = r9
            goto L_0x018a
        L_0x0108:
            if (r2 == 0) goto L_0x0111
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r17 = r0
            goto L_0x0113
        L_0x0111:
            r17 = r22
        L_0x0113:
            if (r4 == 0) goto L_0x011c
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$1 r0 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r19 = r0
            goto L_0x011e
        L_0x011c:
            r19 = r5
        L_0x011e:
            if (r6 == 0) goto L_0x0129
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getTopStart()
            r20 = r0
            goto L_0x012b
        L_0x0129:
            r20 = r7
        L_0x012b:
            if (r8 == 0) goto L_0x0130
            java.lang.String r0 = "AnimatedContent"
            r14 = r0
        L_0x0130:
            if (r15 == 0) goto L_0x0137
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$2 r0 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$2.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r9 = r0
        L_0x0137:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0146
            r0 = -1
            java.lang.String r2 = "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)"
            r3 = 2132720749(0x7f1ebc6d, float:2.1099639E38)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x0146:
            r0 = r1 & 8
            r2 = r1 & 14
            r0 = r0 | r2
            int r2 = r1 >> 9
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = 0
            androidx.compose.animation.core.Transition r15 = androidx.compose.animation.core.TransitionKt.updateTransition(r10, (java.lang.String) r14, (androidx.compose.runtime.Composer) r13, (int) r0, (int) r2)
            r0 = r1 & 112(0x70, float:1.57E-43)
            r2 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r1 >> 3
            r3 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r3
            r0 = r0 | r2
            int r2 = r1 >> 3
            r2 = r2 & r16
            r7 = r0 | r2
            r8 = 0
            r0 = r15
            r16 = r1
            r1 = r17
            r2 = r19
            r3 = r20
            r4 = r9
            r5 = r27
            r6 = r13
            AnimatedContent(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0189
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0189:
            r15 = r9
        L_0x018a:
            androidx.compose.runtime.ScopeUpdateScope r9 = r13.endRestartGroup()
            if (r9 != 0) goto L_0x0191
            goto L_0x01b0
        L_0x0191:
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$3 r18 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$3
            r0 = r18
            r1 = r21
            r2 = r17
            r3 = r19
            r4 = r20
            r5 = r14
            r6 = r15
            r7 = r27
            r8 = r29
            r10 = r9
            r9 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(java.lang.Object, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = AnimatedContentKt$SizeTransform$1.INSTANCE;
        }
        return SizeTransform(z, function2);
    }

    public static final SizeTransform SizeTransform(boolean clip, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> sizeAnimationSpec) {
        Intrinsics.checkNotNullParameter(sizeAnimationSpec, "sizeAnimationSpec");
        return new SizeTransformImpl(clip, sizeAnimationSpec);
    }

    public static final ContentTransform togetherWith(EnterTransition $this$togetherWith, ExitTransition exit) {
        Intrinsics.checkNotNullParameter($this$togetherWith, "<this>");
        Intrinsics.checkNotNullParameter(exit, "exit");
        return new ContentTransform($this$togetherWith, exit, 0.0f, (SizeTransform) null, 12, (DefaultConstructorMarker) null);
    }

    @Deprecated(message = "Infix fun EnterTransition.with(ExitTransition) has been renamed to togetherWith", replaceWith = @ReplaceWith(expression = "togetherWith(exit)", imports = {}))
    public static final ContentTransform with(EnterTransition $this$with, ExitTransition exit) {
        Intrinsics.checkNotNullParameter($this$with, "<this>");
        Intrinsics.checkNotNullParameter(exit, "exit");
        return new ContentTransform($this$with, exit, 0.0f, (SizeTransform) null, 12, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x037a  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x03de  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x041c  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0428  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x042c  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x045c  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0472  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x04ce  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x052a  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0534  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x02a5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:186:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S> void AnimatedContent(androidx.compose.animation.core.Transition<S> r29, androidx.compose.ui.Modifier r30, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentTransitionScope<S>, androidx.compose.animation.ContentTransform> r31, androidx.compose.ui.Alignment r32, kotlin.jvm.functions.Function1<? super S, ? extends java.lang.Object> r33, kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedContentScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r9 = r29
            r10 = r34
            r11 = r36
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -114689412(0xfffffffff929fa7c, float:-5.516116E34)
            r1 = r35
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedContent)P(3,4,1,2)692@32995L7,693@33023L106,698@33218L51,699@33291L62,786@37539L58,787@37631L45,797@37946L52,788@37681L323:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r36
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r37 & r2
            if (r2 == 0) goto L_0x0029
            r1 = r1 | 6
            goto L_0x0037
        L_0x0029:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0037
            boolean r2 = r12.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x0035
            r2 = 4
            goto L_0x0036
        L_0x0035:
            r2 = 2
        L_0x0036:
            r1 = r1 | r2
        L_0x0037:
            r2 = r37 & 1
            if (r2 == 0) goto L_0x0040
            r1 = r1 | 48
            r3 = r30
            goto L_0x0055
        L_0x0040:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0053
            r3 = r30
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004f
            r4 = 32
            goto L_0x0051
        L_0x004f:
            r4 = 16
        L_0x0051:
            r1 = r1 | r4
            goto L_0x0055
        L_0x0053:
            r3 = r30
        L_0x0055:
            r4 = r37 & 2
            if (r4 == 0) goto L_0x005e
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r31
            goto L_0x0073
        L_0x005e:
            r5 = r11 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0071
            r5 = r31
            boolean r6 = r12.changedInstance(r5)
            if (r6 == 0) goto L_0x006d
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006f
        L_0x006d:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006f:
            r1 = r1 | r6
            goto L_0x0073
        L_0x0071:
            r5 = r31
        L_0x0073:
            r6 = r37 & 4
            if (r6 == 0) goto L_0x007c
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r32
            goto L_0x0091
        L_0x007c:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x008f
            r7 = r32
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x008b
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x008d
        L_0x008b:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x008d:
            r1 = r1 | r8
            goto L_0x0091
        L_0x008f:
            r7 = r32
        L_0x0091:
            r8 = r37 & 8
            if (r8 == 0) goto L_0x009a
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r13 = r33
            goto L_0x00b1
        L_0x009a:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00af
            r13 = r33
            boolean r14 = r12.changedInstance(r13)
            if (r14 == 0) goto L_0x00ab
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ad
        L_0x00ab:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00ad:
            r1 = r1 | r14
            goto L_0x00b1
        L_0x00af:
            r13 = r33
        L_0x00b1:
            r14 = r37 & 16
            if (r14 == 0) goto L_0x00b9
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00b7:
            r1 = r1 | r14
            goto L_0x00ca
        L_0x00b9:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r11
            if (r14 != 0) goto L_0x00ca
            boolean r14 = r12.changedInstance(r10)
            if (r14 == 0) goto L_0x00c7
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00c7:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b7
        L_0x00ca:
            r14 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r14
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r15) goto L_0x00e5
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x00db
            goto L_0x00e5
        L_0x00db:
            r12.skipToGroupEnd()
            r15 = r3
            r24 = r5
            r26 = r7
            goto L_0x052d
        L_0x00e5:
            if (r2 == 0) goto L_0x00ed
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r15 = r1
            goto L_0x00ee
        L_0x00ed:
            r15 = r3
        L_0x00ee:
            if (r4 == 0) goto L_0x00f5
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$4 r1 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$4.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r5 = r1
        L_0x00f5:
            if (r6 == 0) goto L_0x00fe
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            r7 = r1
        L_0x00fe:
            if (r8 == 0) goto L_0x0105
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$5 r1 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$5.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r13 = r1
        L_0x0105:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r2 = -1
            if (r1 == 0) goto L_0x0111
            java.lang.String r1 = "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r2, r1)
        L_0x0111:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r3 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r4, r6)
            java.lang.Object r4 = r12.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r8 = r4
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            r0 = r14 & 14
            r1 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r3)
            java.lang.String r4 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            boolean r6 = r12.changed((java.lang.Object) r9)
            r30 = r12
            r16 = 0
            java.lang.Object r2 = r30.rememberedValue()
            r17 = 0
            if (r6 != 0) goto L_0x0159
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r18.getEmpty()
            if (r2 != r3) goto L_0x0153
            goto L_0x0159
        L_0x0153:
            r3 = r30
            r33 = r0
            r0 = r2
            goto L_0x0168
        L_0x0159:
            r3 = 0
            r33 = r0
            androidx.compose.animation.AnimatedContentTransitionScopeImpl r0 = new androidx.compose.animation.AnimatedContentTransitionScopeImpl
            r0.<init>(r9, r7, r8)
            r3 = r30
            r3.updateRememberedValue(r0)
        L_0x0168:
            r12.endReplaceableGroup()
            r6 = r0
            androidx.compose.animation.AnimatedContentTransitionScopeImpl r6 = (androidx.compose.animation.AnimatedContentTransitionScopeImpl) r6
            r0 = r14 & 14
            r1 = 0
            r2 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            boolean r2 = r12.changed((java.lang.Object) r9)
            r3 = r12
            r16 = 0
            r30 = r0
            java.lang.Object r0 = r3.rememberedValue()
            r17 = 0
            if (r2 != 0) goto L_0x019b
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r33 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x0199
            goto L_0x019d
        L_0x0199:
            r1 = r0
            goto L_0x01af
        L_0x019b:
            r33 = r1
        L_0x019d:
            r1 = 0
            java.lang.Object r18 = r29.getCurrentState()
            java.lang.Object[] r18 = new java.lang.Object[]{r18}
            androidx.compose.runtime.snapshots.SnapshotStateList r1 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf(r18)
            r3.updateRememberedValue(r1)
        L_0x01af:
            r12.endReplaceableGroup()
            r3 = r1
            androidx.compose.runtime.snapshots.SnapshotStateList r3 = (androidx.compose.runtime.snapshots.SnapshotStateList) r3
            r0 = r14 & 14
            r1 = 0
            r2 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            boolean r2 = r12.changed((java.lang.Object) r9)
            r4 = r12
            r16 = 0
            r30 = r0
            java.lang.Object r0 = r4.rememberedValue()
            r17 = 0
            if (r2 != 0) goto L_0x01e2
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r32 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x01e0
            goto L_0x01e4
        L_0x01e0:
            r1 = r0
            goto L_0x01f2
        L_0x01e2:
            r32 = r1
        L_0x01e4:
            r1 = 0
            java.util.LinkedHashMap r18 = new java.util.LinkedHashMap
            r18.<init>()
            java.util.Map r18 = (java.util.Map) r18
            r1 = r18
            r4.updateRememberedValue(r1)
        L_0x01f2:
            r12.endReplaceableGroup()
            r4 = r1
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r0 = r29.getCurrentState()
            boolean r0 = r3.contains(r0)
            if (r0 != 0) goto L_0x020e
            r3.clear()
            java.lang.Object r0 = r29.getCurrentState()
            r3.add(r0)
        L_0x020e:
            java.lang.Object r0 = r29.getCurrentState()
            java.lang.Object r1 = r29.getTargetState()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r2 = 0
            r1 = 1
            if (r0 == 0) goto L_0x0255
            int r0 = r3.size()
            if (r0 != r1) goto L_0x0232
            java.lang.Object r0 = r3.get(r2)
            java.lang.Object r2 = r29.getCurrentState()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 != 0) goto L_0x023c
        L_0x0232:
            r3.clear()
            java.lang.Object r0 = r29.getCurrentState()
            r3.add(r0)
        L_0x023c:
            int r0 = r4.size()
            if (r0 != r1) goto L_0x024c
            java.lang.Object r0 = r29.getCurrentState()
            boolean r0 = r4.containsKey(r0)
            if (r0 == 0) goto L_0x024f
        L_0x024c:
            r4.clear()
        L_0x024f:
            r6.setContentAlignment$animation_release(r7)
            r6.setLayoutDirection$animation_release(r8)
        L_0x0255:
            java.lang.Object r0 = r29.getCurrentState()
            java.lang.Object r2 = r29.getTargetState()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 != 0) goto L_0x02bd
            java.lang.Object r0 = r29.getTargetState()
            boolean r0 = r3.contains(r0)
            if (r0 != 0) goto L_0x02bd
            r0 = r3
            java.util.List r0 = (java.util.List) r0
            r2 = 0
            r16 = 0
            java.util.Iterator r17 = r0.iterator()
        L_0x0277:
            boolean r18 = r17.hasNext()
            if (r18 == 0) goto L_0x02a5
            java.lang.Object r18 = r17.next()
            r32 = r18
            r19 = 0
            r1 = r32
            r32 = r0
            java.lang.Object r0 = r13.invoke(r1)
            r35 = r1
            java.lang.Object r1 = r29.getTargetState()
            java.lang.Object r1 = r13.invoke(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x029e
            goto L_0x02a9
        L_0x029e:
            int r16 = r16 + 1
            r0 = r32
            r1 = 1
            goto L_0x0277
        L_0x02a5:
            r32 = r0
            r16 = -1
        L_0x02a9:
            r0 = r16
            r1 = -1
            if (r0 != r1) goto L_0x02b6
            java.lang.Object r1 = r29.getTargetState()
            r3.add(r1)
            goto L_0x02bd
        L_0x02b6:
            java.lang.Object r1 = r29.getTargetState()
            r3.set(r0, r1)
        L_0x02bd:
            java.lang.Object r0 = r29.getTargetState()
            boolean r0 = r4.containsKey(r0)
            if (r0 == 0) goto L_0x02e1
            java.lang.Object r0 = r29.getCurrentState()
            boolean r0 = r4.containsKey(r0)
            if (r0 != 0) goto L_0x02d2
            goto L_0x02e1
        L_0x02d2:
            r22 = r3
            r1 = r4
            r24 = r5
            r25 = r6
            r26 = r7
            r32 = r8
            r30 = 0
            goto L_0x0353
        L_0x02e1:
            r4.clear()
            r2 = r3
            java.util.List r2 = (java.util.List) r2
            r16 = 0
            r0 = 0
            int r1 = r2.size()
        L_0x02ef:
            if (r0 >= r1) goto L_0x0341
            java.lang.Object r17 = r2.get(r0)
            r31 = r17
            r18 = 0
            r32 = r8
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1 r8 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1
            r19 = r0
            r0 = r8
            r20 = r1
            r9 = 1
            r1 = r29
            r21 = r2
            r30 = 0
            r2 = r31
            r22 = r3
            r3 = r14
            r23 = r4
            r4 = r5
            r24 = r5
            r5 = r6
            r25 = r6
            r6 = r22
            r26 = r7
            r7 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = 885640742(0x34c9ce26, float:3.758916E-7)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r0, r9, r8)
            r1 = r23
            r1.put(r2, r0)
            int r0 = r19 + 1
            r9 = r29
            r8 = r32
            r4 = r1
            r1 = r20
            r2 = r21
            r3 = r22
            r5 = r24
            r6 = r25
            r7 = r26
            goto L_0x02ef
        L_0x0341:
            r19 = r0
            r21 = r2
            r22 = r3
            r1 = r4
            r24 = r5
            r25 = r6
            r26 = r7
            r32 = r8
            r30 = 0
        L_0x0353:
            androidx.compose.animation.core.Transition$Segment r0 = r29.getSegment()
            r2 = 72
            r3 = 0
            r4 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            r4 = r25
            boolean r5 = r12.changed((java.lang.Object) r4)
            boolean r6 = r12.changed((java.lang.Object) r0)
            r5 = r5 | r6
            r6 = r12
            r7 = 0
            java.lang.Object r8 = r6.rememberedValue()
            r9 = 0
            if (r5 != 0) goto L_0x0387
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r31 = r0
            java.lang.Object r0 = r16.getEmpty()
            if (r8 != r0) goto L_0x0385
            goto L_0x0389
        L_0x0385:
            r0 = r8
            goto L_0x039c
        L_0x0387:
            r31 = r0
        L_0x0389:
            r0 = 0
            r33 = r0
            r0 = r24
            java.lang.Object r16 = r0.invoke(r4)
            androidx.compose.animation.ContentTransform r16 = (androidx.compose.animation.ContentTransform) r16
            r33 = r16
            r0 = r33
            r6.updateRememberedValue(r0)
        L_0x039c:
            r12.endReplaceableGroup()
            androidx.compose.animation.ContentTransform r0 = (androidx.compose.animation.ContentTransform) r0
            r2 = 72
            androidx.compose.ui.Modifier r2 = r4.createSizeAnimationModifier$animation_release(r0, r12, r2)
            androidx.compose.ui.Modifier r3 = r15.then(r2)
            r5 = r30
            r6 = 0
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r7)
            r7 = 0
            r8 = r12
            r9 = 0
            r31 = r0
            java.lang.Object r0 = r8.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r33 = r2
            java.lang.Object r2 = r17.getEmpty()
            if (r0 != r2) goto L_0x03de
            r2 = 0
            r35 = r0
            androidx.compose.animation.AnimatedContentMeasurePolicy r0 = new androidx.compose.animation.AnimatedContentMeasurePolicy
            r0.<init>(r4)
            r8.updateRememberedValue(r0)
            goto L_0x03e0
        L_0x03de:
            r35 = r0
        L_0x03e0:
            r12.endReplaceableGroup()
            androidx.compose.animation.AnimatedContentMeasurePolicy r0 = (androidx.compose.animation.AnimatedContentMeasurePolicy) r0
            r2 = 384(0x180, float:5.38E-43)
            r5 = 0
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r6)
            r6 = r30
            int r7 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r12, r6)
            androidx.compose.runtime.CompositionLocalMap r8 = r12.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            int r6 = r2 << 9
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | 6
            r16 = 0
            r35 = r2
            androidx.compose.runtime.Applier r2 = r12.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x041f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x041f:
            r12.startReusableNode()
            boolean r2 = r12.getInserting()
            if (r2 == 0) goto L_0x042c
            r12.createNode(r9)
            goto L_0x042f
        L_0x042c:
            r12.useNode()
        L_0x042f:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m4575constructorimpl(r12)
            r17 = 0
            androidx.compose.ui.layout.MeasurePolicy r0 = (androidx.compose.ui.layout.MeasurePolicy) r0
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            r25 = r4
            kotlin.jvm.functions.Function2 r4 = r18.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r0, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r8, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            r4 = 0
            r18 = r2
            r19 = 0
            boolean r20 = r18.getInserting()
            if (r20 != 0) goto L_0x0472
            r20 = r4
            java.lang.Object r4 = r18.rememberedValue()
            r21 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x046f
            goto L_0x0476
        L_0x046f:
            r5 = r18
            goto L_0x0486
        L_0x0472:
            r20 = r4
            r21 = r5
        L_0x0476:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r5 = r18
            r5.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r2.apply(r4, r0)
        L_0x0486:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r0)
            int r2 = r6 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3.invoke(r0, r12, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r0)
            int r0 = r6 >> 9
            r0 = r0 & 14
            r2 = r12
            r4 = 0
            r5 = -740836641(0xffffffffd3d7badf, float:-1.85310629E12)
            r17 = r0
            java.lang.String r0 = "C:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r0)
            r0 = -441507761(0xffffffffe5af204f, float:-1.03376265E23)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r0 = r22
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r5 = 0
            java.util.Iterator r18 = r0.iterator()
        L_0x04c8:
            boolean r19 = r18.hasNext()
            if (r19 == 0) goto L_0x050b
            java.lang.Object r19 = r18.next()
            r20 = r19
            r23 = 0
            r27 = r0
            r0 = r20
            r20 = r3
            java.lang.Object r3 = r13.invoke(r0)
            r28 = r4
            r4 = -1739559893(0xffffffff98506c2b, float:-2.693798E-24)
            r2.startMovableGroup(r4, r3)
            java.lang.String r3 = "793@37870L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            java.lang.Object r3 = r1.get(r0)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r30 = r0
            r4 = 0
            if (r3 != 0) goto L_0x04f9
            goto L_0x0500
        L_0x04f9:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            r3.invoke(r2, r0)
        L_0x0500:
            r2.endMovableGroup()
            r3 = r20
            r0 = r27
            r4 = r28
            goto L_0x04c8
        L_0x050b:
            r27 = r0
            r20 = r3
            r28 = r4
            r2.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r12.endReplaceableGroup()
            r12.endNode()
            r12.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x052d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x052d:
            androidx.compose.runtime.ScopeUpdateScope r9 = r12.endRestartGroup()
            if (r9 != 0) goto L_0x0534
            goto L_0x0550
        L_0x0534:
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$9 r16 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$9
            r0 = r16
            r1 = r29
            r2 = r15
            r3 = r24
            r4 = r26
            r5 = r13
            r6 = r34
            r7 = r36
            r8 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0550:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(androidx.compose.animation.core.Transition, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }
}

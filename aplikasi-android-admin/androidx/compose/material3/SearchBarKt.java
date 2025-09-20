package androidx.compose.material3;

import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0002\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u0002092\u001c\u0010:\u001a\u0018\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b0¢\u0006\u0002\b<H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a\u0002\u0010?\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00102\b\b\u0002\u0010@\u001a\u00020A2\b\b\u0002\u00108\u001a\u0002092\u001c\u0010:\u001a\u0018\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b0¢\u0006\u0002\b<H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001aÆ\u0001\u0010D\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00105\u001a\u00020E2\b\b\u0002\u00108\u001a\u000209H\u0003¢\u0006\u0002\u0010F\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u000f\u001a\u00020\u0010X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0018\u001a\u00020\u0010X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0013\u0012\u0004\b\u0019\u0010\u001a\"\u0013\u0010\u001b\u001a\u00020\u0010X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0013\"\u0013\u0010\u001c\u001a\u00020\u0010X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0013\"\u0019\u0010\u001d\u001a\u00020\u0010X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012\"\u0019\u0010\u001f\u001a\u00020\u0010X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b \u0010\u0012\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006G"}, d2 = {"AnimationDelayMillis", "", "AnimationEnterDurationMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitDurationMillis", "AnimationExitEasing", "AnimationExitFloatSpec", "AnimationExitSizeSpec", "DockedActiveTableMaxHeightScreenRatio", "DockedActiveTableMinHeight", "Landroidx/compose/ui/unit/Dp;", "getDockedActiveTableMinHeight", "()F", "F", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "SearchBarIconOffsetX", "SearchBarMaxWidth", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "DockedSearchBar", "", "query", "", "onQueryChange", "Lkotlin/Function1;", "onSearch", "active", "", "onActiveChange", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "placeholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DockedSearchBar-rpjkMjA", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "SearchBar-Id_Pb_0", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarInputField", "Landroidx/compose/material3/TextFieldColors;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.kt */
public final class SearchBarKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing;
    private static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing;
    private static final FiniteAnimationSpec<Float> AnimationExitFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec;
    private static final float DockedActiveTableMaxHeightScreenRatio = 0.6666667f;
    private static final float DockedActiveTableMinHeight = Dp.m7554constructorimpl((float) 240);
    /* access modifiers changed from: private */
    public static final EnterTransition DockedEnterTransition;
    /* access modifiers changed from: private */
    public static final ExitTransition DockedExitTransition;
    /* access modifiers changed from: private */
    public static final float SearchBarCornerRadius = Dp.m7554constructorimpl(SearchBarDefaults.INSTANCE.m3655getInputFieldHeightD9Ej5fM() / ((float) 2));
    /* access modifiers changed from: private */
    public static final float SearchBarIconOffsetX = Dp.m7554constructorimpl((float) 4);
    /* access modifiers changed from: private */
    public static final float SearchBarMaxWidth = Dp.m7554constructorimpl((float) 720);
    private static final float SearchBarMinWidth = Dp.m7554constructorimpl((float) 360);
    private static final float SearchBarVerticalPadding = Dp.m7554constructorimpl((float) 8);

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:121:0x019e, code lost:
        if (r6.changed((java.lang.Object) r58) != false) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x01d5, code lost:
        if (r6.changed((java.lang.Object) r60) != false) goto L_0x01dc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x04fb  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x050c  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x0537  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0548  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x05a9  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x05b9  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0601  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x060e  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x06d7  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x06d9  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x06fb  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x0712  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x0715  */
    /* renamed from: SearchBar-Id_Pb_0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m3659SearchBarId_Pb_0(java.lang.String r47, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r48, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r49, boolean r50, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r51, androidx.compose.ui.Modifier r52, boolean r53, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, androidx.compose.ui.graphics.Shape r57, androidx.compose.material3.SearchBarColors r58, float r59, androidx.compose.foundation.layout.WindowInsets r60, androidx.compose.foundation.interaction.MutableInteractionSource r61, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r62, androidx.compose.runtime.Composer r63, int r64, int r65, int r66) {
        /*
            r15 = r47
            r14 = r48
            r13 = r49
            r12 = r50
            r11 = r51
            r10 = r62
            r9 = r64
            r8 = r65
            r7 = r66
            java.lang.String r0 = "query"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onQueryChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "onSearch"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "onActiveChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 156000634(0x94c617a, float:2.460144E-33)
            r1 = r63
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SearchBar)P(11,8,9!1,7,6,3,10,5,14,12!1,13:c#ui.unit.Dp,15,4)170@8704L15,171@8769L8,173@8884L12,174@8948L39,177@9084L160,182@9287L7,183@9326L7,185@9386L15,186@9453L15,187@9499L101,190@9625L578,210@10651L34,211@10707L179,221@10994L38,225@11170L112,229@11354L1074,218@10892L2701,282@13599L306,291@13941L37,291@13911L67:SearchBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r64
            r2 = r65
            r3 = r7 & 1
            if (r3 == 0) goto L_0x0048
            r1 = r1 | 6
            goto L_0x0056
        L_0x0048:
            r3 = r9 & 14
            if (r3 != 0) goto L_0x0056
            boolean r3 = r6.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x0054
            r3 = 4
            goto L_0x0055
        L_0x0054:
            r3 = 2
        L_0x0055:
            r1 = r1 | r3
        L_0x0056:
            r3 = r7 & 2
            r16 = 32
            r17 = 16
            if (r3 == 0) goto L_0x0061
            r1 = r1 | 48
            goto L_0x0071
        L_0x0061:
            r3 = r9 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0071
            boolean r3 = r6.changedInstance(r14)
            if (r3 == 0) goto L_0x006e
            r3 = r16
            goto L_0x0070
        L_0x006e:
            r3 = r17
        L_0x0070:
            r1 = r1 | r3
        L_0x0071:
            r3 = r7 & 4
            r18 = 256(0x100, float:3.59E-43)
            r19 = 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x007c
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x008c
        L_0x007c:
            r3 = r9 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x008c
            boolean r3 = r6.changedInstance(r13)
            if (r3 == 0) goto L_0x0089
            r3 = r18
            goto L_0x008b
        L_0x0089:
            r3 = r19
        L_0x008b:
            r1 = r1 | r3
        L_0x008c:
            r3 = r7 & 8
            r20 = 2048(0x800, float:2.87E-42)
            r21 = 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0097
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x00a7
        L_0x0097:
            r3 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x00a7
            boolean r3 = r6.changed((boolean) r12)
            if (r3 == 0) goto L_0x00a4
            r3 = r20
            goto L_0x00a6
        L_0x00a4:
            r3 = r21
        L_0x00a6:
            r1 = r1 | r3
        L_0x00a7:
            r3 = r7 & 16
            r22 = 16384(0x4000, float:2.2959E-41)
            r25 = 57344(0xe000, float:8.0356E-41)
            r23 = 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x00b5
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00c5
        L_0x00b5:
            r3 = r9 & r25
            if (r3 != 0) goto L_0x00c5
            boolean r3 = r6.changedInstance(r11)
            if (r3 == 0) goto L_0x00c2
            r3 = r22
            goto L_0x00c4
        L_0x00c2:
            r3 = r23
        L_0x00c4:
            r1 = r1 | r3
        L_0x00c5:
            r3 = r7 & 32
            if (r3 == 0) goto L_0x00d0
            r24 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r24
            r4 = r52
            goto L_0x00e8
        L_0x00d0:
            r24 = 458752(0x70000, float:6.42848E-40)
            r24 = r9 & r24
            if (r24 != 0) goto L_0x00e6
            r4 = r52
            boolean r24 = r6.changed((java.lang.Object) r4)
            if (r24 == 0) goto L_0x00e1
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00e3
        L_0x00e1:
            r24 = 65536(0x10000, float:9.18355E-41)
        L_0x00e3:
            r1 = r1 | r24
            goto L_0x00e8
        L_0x00e6:
            r4 = r52
        L_0x00e8:
            r24 = r7 & 64
            if (r24 == 0) goto L_0x00f3
            r26 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r26
            r5 = r53
            goto L_0x010b
        L_0x00f3:
            r26 = 3670016(0x380000, float:5.142788E-39)
            r26 = r9 & r26
            if (r26 != 0) goto L_0x0109
            r5 = r53
            boolean r27 = r6.changed((boolean) r5)
            if (r27 == 0) goto L_0x0104
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0106
        L_0x0104:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x0106:
            r1 = r1 | r27
            goto L_0x010b
        L_0x0109:
            r5 = r53
        L_0x010b:
            r0 = r7 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0116
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r28
            r4 = r54
            goto L_0x012e
        L_0x0116:
            r28 = 29360128(0x1c00000, float:7.052966E-38)
            r28 = r9 & r28
            if (r28 != 0) goto L_0x012c
            r4 = r54
            boolean r28 = r6.changedInstance(r4)
            if (r28 == 0) goto L_0x0127
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0129
        L_0x0127:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x0129:
            r1 = r1 | r28
            goto L_0x012e
        L_0x012c:
            r4 = r54
        L_0x012e:
            r4 = r7 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x0139
            r28 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r28
            r5 = r55
            goto L_0x0151
        L_0x0139:
            r28 = 234881024(0xe000000, float:1.5777218E-30)
            r28 = r9 & r28
            if (r28 != 0) goto L_0x014f
            r5 = r55
            boolean r28 = r6.changedInstance(r5)
            if (r28 == 0) goto L_0x014a
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x014c
        L_0x014a:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x014c:
            r1 = r1 | r28
            goto L_0x0151
        L_0x014f:
            r5 = r55
        L_0x0151:
            r5 = r7 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x015c
            r28 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r28
            r11 = r56
            goto L_0x0174
        L_0x015c:
            r28 = 1879048192(0x70000000, float:1.58456325E29)
            r28 = r9 & r28
            if (r28 != 0) goto L_0x0172
            r11 = r56
            boolean r28 = r6.changedInstance(r11)
            if (r28 == 0) goto L_0x016d
            r28 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x016f
        L_0x016d:
            r28 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x016f:
            r1 = r1 | r28
            goto L_0x0174
        L_0x0172:
            r11 = r56
        L_0x0174:
            r28 = r8 & 14
            if (r28 != 0) goto L_0x018e
            r11 = r7 & 1024(0x400, float:1.435E-42)
            if (r11 != 0) goto L_0x0187
            r11 = r57
            boolean r28 = r6.changed((java.lang.Object) r11)
            if (r28 == 0) goto L_0x0189
            r26 = 4
            goto L_0x018b
        L_0x0187:
            r11 = r57
        L_0x0189:
            r26 = 2
        L_0x018b:
            r2 = r2 | r26
            goto L_0x0190
        L_0x018e:
            r11 = r57
        L_0x0190:
            r26 = r8 & 112(0x70, float:1.57E-43)
            if (r26 != 0) goto L_0x01a8
            r11 = r7 & 2048(0x800, float:2.87E-42)
            if (r11 != 0) goto L_0x01a1
            r11 = r58
            boolean r26 = r6.changed((java.lang.Object) r11)
            if (r26 == 0) goto L_0x01a3
            goto L_0x01a5
        L_0x01a1:
            r11 = r58
        L_0x01a3:
            r16 = r17
        L_0x01a5:
            r2 = r2 | r16
            goto L_0x01aa
        L_0x01a8:
            r11 = r58
        L_0x01aa:
            r11 = r7 & 4096(0x1000, float:5.74E-42)
            if (r11 == 0) goto L_0x01b3
            r2 = r2 | 384(0x180, float:5.38E-43)
            r13 = r59
            goto L_0x01c7
        L_0x01b3:
            r13 = r8 & 896(0x380, float:1.256E-42)
            if (r13 != 0) goto L_0x01c5
            r13 = r59
            boolean r16 = r6.changed((float) r13)
            if (r16 == 0) goto L_0x01c0
            goto L_0x01c2
        L_0x01c0:
            r18 = r19
        L_0x01c2:
            r2 = r2 | r18
            goto L_0x01c7
        L_0x01c5:
            r13 = r59
        L_0x01c7:
            r13 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x01df
            r13 = r7 & 8192(0x2000, float:1.14794E-41)
            if (r13 != 0) goto L_0x01d8
            r13 = r60
            boolean r16 = r6.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x01da
            goto L_0x01dc
        L_0x01d8:
            r13 = r60
        L_0x01da:
            r20 = r21
        L_0x01dc:
            r2 = r2 | r20
            goto L_0x01e1
        L_0x01df:
            r13 = r60
        L_0x01e1:
            r13 = r7 & 16384(0x4000, float:2.2959E-41)
            if (r13 == 0) goto L_0x01ea
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r14 = r61
            goto L_0x01fe
        L_0x01ea:
            r16 = r8 & r25
            if (r16 != 0) goto L_0x01fc
            r14 = r61
            boolean r16 = r6.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x01f7
            goto L_0x01f9
        L_0x01f7:
            r22 = r23
        L_0x01f9:
            r2 = r2 | r22
            goto L_0x01fe
        L_0x01fc:
            r14 = r61
        L_0x01fe:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r7 & r16
            if (r16 == 0) goto L_0x020a
            r16 = 196608(0x30000, float:2.75506E-40)
        L_0x0207:
            r2 = r2 | r16
            goto L_0x021c
        L_0x020a:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r8 & r16
            if (r16 != 0) goto L_0x021c
            boolean r16 = r6.changedInstance(r10)
            if (r16 == 0) goto L_0x0219
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0207
        L_0x0219:
            r16 = 65536(0x10000, float:9.18355E-41)
            goto L_0x0207
        L_0x021c:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r1 & r16
            r10 = 306783378(0x12492492, float:6.3469493E-28)
            if (r8 != r10) goto L_0x0257
            r8 = 374491(0x5b6db, float:5.24774E-40)
            r8 = r8 & r2
            r10 = 74898(0x12492, float:1.04954E-40)
            if (r8 != r10) goto L_0x0257
            boolean r8 = r6.getSkipping()
            if (r8 != 0) goto L_0x0236
            goto L_0x0257
        L_0x0236:
            r6.skipToGroupEnd()
            r13 = r51
            r44 = r52
            r20 = r53
            r21 = r54
            r22 = r55
            r23 = r56
            r31 = r57
            r24 = r58
            r25 = r59
            r42 = r60
            r34 = r1
            r40 = r2
            r15 = r6
            r26 = r14
            r14 = r12
            goto L_0x070c
        L_0x0257:
            r6.startDefaults()
            r8 = r9 & 1
            java.lang.String r10 = "CC(remember):Composables.kt#9igjgp"
            if (r8 == 0) goto L_0x02aa
            boolean r8 = r6.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0267
            goto L_0x02aa
        L_0x0267:
            r6.skipToGroupEnd()
            r0 = r7 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0270
            r2 = r2 & -15
        L_0x0270:
            r0 = r7 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0276
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0276:
            r0 = r7 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0293
            r0 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            r17 = r53
            r18 = r54
            r19 = r55
            r20 = r56
            r13 = r57
            r21 = r58
            r22 = r59
            r11 = r60
            r9 = r0
            r23 = r14
            r14 = r52
            goto L_0x038d
        L_0x0293:
            r17 = r53
            r18 = r54
            r19 = r55
            r20 = r56
            r13 = r57
            r21 = r58
            r22 = r59
            r11 = r60
            r9 = r2
            r23 = r14
            r14 = r52
            goto L_0x038d
        L_0x02aa:
            if (r3 == 0) goto L_0x02b1
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x02b3
        L_0x02b1:
            r3 = r52
        L_0x02b3:
            if (r24 == 0) goto L_0x02b7
            r8 = 1
            goto L_0x02b9
        L_0x02b7:
            r8 = r53
        L_0x02b9:
            if (r0 == 0) goto L_0x02bd
            r0 = 0
            goto L_0x02bf
        L_0x02bd:
            r0 = r54
        L_0x02bf:
            if (r4 == 0) goto L_0x02c3
            r4 = 0
            goto L_0x02c5
        L_0x02c3:
            r4 = r55
        L_0x02c5:
            if (r5 == 0) goto L_0x02c9
            r5 = 0
            goto L_0x02cb
        L_0x02c9:
            r5 = r56
        L_0x02cb:
            r9 = r7 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x02db
            androidx.compose.material3.SearchBarDefaults r9 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r52 = r0
            r0 = 6
            androidx.compose.ui.graphics.Shape r9 = r9.getInputFieldShape(r6, r0)
            r2 = r2 & -15
            goto L_0x02df
        L_0x02db:
            r52 = r0
            r9 = r57
        L_0x02df:
            r0 = r7 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x02f8
            androidx.compose.material3.SearchBarDefaults r16 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r23 = 3072(0xc00, float:4.305E-42)
            r24 = 7
            r17 = 0
            r19 = 0
            r21 = 0
            r22 = r6
            androidx.compose.material3.SearchBarColors r0 = r16.m3653colorsKlgxPg(r17, r19, r21, r22, r23, r24)
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x02fa
        L_0x02f8:
            r0 = r58
        L_0x02fa:
            if (r11 == 0) goto L_0x0303
            androidx.compose.material3.SearchBarDefaults r11 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r11 = r11.m3654getElevationD9Ej5fM()
            goto L_0x0305
        L_0x0303:
            r11 = r59
        L_0x0305:
            r53 = r0
            r0 = r7 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0317
            androidx.compose.material3.SearchBarDefaults r0 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r16 = r3
            r3 = 6
            androidx.compose.foundation.layout.WindowInsets r0 = r0.getWindowInsets(r6, r3)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x031b
        L_0x0317:
            r16 = r3
            r0 = r60
        L_0x031b:
            if (r13 == 0) goto L_0x0374
            r3 = 0
            r13 = 0
            r54 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r10)
            r0 = 0
            r55 = r6
            r17 = 0
            r56 = r0
            java.lang.Object r0 = r55.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r57 = r2
            java.lang.Object r2 = r19.getEmpty()
            if (r0 != r2) goto L_0x0350
            r2 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r58 = r0
            r0 = r55
            r0.updateRememberedValue(r2)
            goto L_0x0356
        L_0x0350:
            r58 = r0
            r0 = r55
            r2 = r58
        L_0x0356:
            r6.endReplaceableGroup()
            r0 = r2
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r18 = r52
            r21 = r53
            r23 = r0
            r19 = r4
            r20 = r5
            r17 = r8
            r13 = r9
            r22 = r11
            r14 = r16
            r11 = r54
            r9 = r57
            goto L_0x038d
        L_0x0374:
            r54 = r0
            r57 = r2
            r18 = r52
            r21 = r53
            r19 = r4
            r20 = r5
            r17 = r8
            r13 = r9
            r22 = r11
            r23 = r14
            r14 = r16
            r11 = r54
            r9 = r57
        L_0x038d:
            r6.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x039e
            java.lang.String r0 = "androidx.compose.material3.SearchBar (SearchBar.kt:159)"
            r2 = 156000634(0x94c617a, float:2.460144E-33)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r9, r0)
        L_0x039e:
            if (r12 == 0) goto L_0x03a3
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x03a4
        L_0x03a3:
            r0 = 0
        L_0x03a4:
            if (r12 == 0) goto L_0x03a9
            androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r2 = AnimationEnterFloatSpec
            goto L_0x03ab
        L_0x03a9:
            androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r2 = AnimationExitFloatSpec
        L_0x03ab:
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r3 = 0
            r4 = 0
            r5 = 0
            r8 = 64
            r16 = 28
            r52 = r0
            r53 = r2
            r54 = r3
            r55 = r4
            r56 = r5
            r57 = r6
            r58 = r8
            r59 = r16
            androidx.compose.runtime.State r8 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r52, r53, r54, r55, r56, r57, r58, r59)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r2 = 0
            r3 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r4, r5)
            java.lang.Object r4 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r5 = r4
            androidx.compose.ui.focus.FocusManager r5 = (androidx.compose.ui.focus.FocusManager) r5
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r2 = 0
            r3 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            r16 = r1
            java.lang.String r1 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r4, r1)
            java.lang.Object r1 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r4 = r1
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.material3.SearchBarDefaults r0 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r1 = 6
            androidx.compose.ui.graphics.Shape r3 = r0.getInputFieldShape(r6, r1)
            androidx.compose.material3.SearchBarDefaults r0 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r24 = r0.getFullScreenShape(r6, r1)
            r2 = 0
            r0 = r2
            r1 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r10)
            r2 = 0
            r53 = r6
            r27 = 0
            r54 = r0
            java.lang.Object r0 = r53.rememberedValue()
            r28 = 0
            androidx.compose.runtime.Composer$Companion r29 = androidx.compose.runtime.Composer.Companion
            r55 = r1
            java.lang.Object r1 = r29.getEmpty()
            if (r0 != r1) goto L_0x044a
            r1 = 0
            r56 = r0
            androidx.compose.runtime.SnapshotMutationPolicy r0 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
            r57 = r1
            androidx.compose.material3.SearchBarKt$SearchBar$useFullScreenShape$2$1 r1 = new androidx.compose.material3.SearchBarKt$SearchBar$useFullScreenShape$2$1
            r1.<init>(r8)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r0, r1)
            r1 = r53
            r1.updateRememberedValue(r0)
            goto L_0x044e
        L_0x044a:
            r1 = r53
            r56 = r0
        L_0x044e:
            r6.endReplaceableGroup()
            r27 = r0
            androidx.compose.runtime.State r27 = (androidx.compose.runtime.State) r27
            boolean r0 = SearchBar_Id_Pb_0$lambda$2(r27)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            int r1 = r9 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r2 = 0
            r53 = r1
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r6.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            boolean r28 = r6.changed((java.lang.Object) r0)
            boolean r29 = r6.changed((java.lang.Object) r13)
            r28 = r28 | r29
            r55 = r6
            r29 = 0
            r56 = r0
            java.lang.Object r0 = r55.rememberedValue()
            r30 = 0
            if (r28 != 0) goto L_0x049a
            androidx.compose.runtime.Composer$Companion r31 = androidx.compose.runtime.Composer.Companion
            r57 = r2
            java.lang.Object r2 = r31.getEmpty()
            if (r0 != r2) goto L_0x0495
            goto L_0x049c
        L_0x0495:
            r2 = r55
            r58 = r0
            goto L_0x04cd
        L_0x049a:
            r57 = r2
        L_0x049c:
            r2 = 0
            boolean r31 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r3)
            if (r31 == 0) goto L_0x04b7
            r58 = r0
            androidx.compose.foundation.shape.GenericShape r0 = new androidx.compose.foundation.shape.GenericShape
            r59 = r2
            androidx.compose.material3.SearchBarKt$SearchBar$animatedShape$1$1 r2 = new androidx.compose.material3.SearchBarKt$SearchBar$animatedShape$1$1
            r2.<init>(r4, r8)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r0.<init>(r2)
            androidx.compose.ui.graphics.Shape r0 = (androidx.compose.ui.graphics.Shape) r0
            goto L_0x04c5
        L_0x04b7:
            r58 = r0
            r59 = r2
            boolean r0 = SearchBar_Id_Pb_0$lambda$2(r27)
            if (r0 == 0) goto L_0x04c4
            r0 = r24
            goto L_0x04c5
        L_0x04c4:
            r0 = r13
        L_0x04c5:
            r2 = r55
            r2.updateRememberedValue(r0)
        L_0x04cd:
            r6.endReplaceableGroup()
            r28 = r0
            androidx.compose.ui.graphics.Shape r28 = (androidx.compose.ui.graphics.Shape) r28
            r0 = 0
            r2 = r0
            r0 = 0
            r53 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r10)
            r0 = 0
            r10 = r6
            r29 = 0
            r55 = r0
            java.lang.Object r0 = r10.rememberedValue()
            r30 = 0
            androidx.compose.runtime.Composer$Companion r31 = androidx.compose.runtime.Composer.Companion
            r56 = r2
            java.lang.Object r2 = r31.getEmpty()
            r15 = 1
            if (r0 != r2) goto L_0x050c
            r2 = 0
            r58 = r0
            androidx.compose.material3.MutableWindowInsets r0 = new androidx.compose.material3.MutableWindowInsets
            r31 = r13
            r13 = 0
            r0.<init>(r13, r15, r13)
            r10.updateRememberedValue(r0)
            goto L_0x0511
        L_0x050c:
            r58 = r0
            r31 = r13
            r13 = 0
        L_0x0511:
            r6.endReplaceableGroup()
            r10 = r0
            androidx.compose.material3.MutableWindowInsets r10 = (androidx.compose.material3.MutableWindowInsets) r10
            r0 = 0
            r2 = r0
            r0 = 0
            r13 = 1157296644(0x44faf204, float:2007.563)
            r6.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r13)
            boolean r13 = r6.changed((java.lang.Object) r4)
            r53 = r6
            r29 = 0
            java.lang.Object r15 = r53.rememberedValue()
            r30 = 0
            if (r13 != 0) goto L_0x0548
            androidx.compose.runtime.Composer$Companion r32 = androidx.compose.runtime.Composer.Companion
            r56 = r0
            java.lang.Object r0 = r32.getEmpty()
            if (r15 != r0) goto L_0x0542
            goto L_0x054a
        L_0x0542:
            r58 = r2
            r0 = r15
            r2 = r53
            goto L_0x0561
        L_0x0548:
            r56 = r0
        L_0x054a:
            r0 = 0
            r58 = r0
            androidx.compose.material3.SearchBarKt$SearchBar$topPadding$1$1 r0 = new androidx.compose.material3.SearchBarKt$SearchBar$topPadding$1$1
            r0.<init>(r10, r4)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r0)
            r58 = r2
            r2 = r53
            r2.updateRememberedValue(r0)
        L_0x0561:
            r6.endReplaceableGroup()
            r15 = r0
            androidx.compose.runtime.State r15 = (androidx.compose.runtime.State) r15
            long r29 = r21.m3651getContainerColor0d7_KjU()
            r53 = r3
            long r2 = r21.m3651getContainerColor0d7_KjU()
            r0 = 0
            long r32 = androidx.compose.material3.ColorSchemeKt.m3369contentColorForek8zF_U(r2, r6, r0)
            r0 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ZIndexModifierKt.zIndex(r14, r0)
            int r2 = r9 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r3 = 6
            r2 = r2 | r3
            r3 = 0
            r13 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r6.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            boolean r13 = r6.changed((java.lang.Object) r10)
            boolean r26 = r6.changed((java.lang.Object) r11)
            r13 = r13 | r26
            r56 = r6
            r26 = 0
            r58 = r2
            java.lang.Object r2 = r56.rememberedValue()
            r34 = 0
            if (r13 != 0) goto L_0x05b9
            androidx.compose.runtime.Composer$Companion r35 = androidx.compose.runtime.Composer.Companion
            r59 = r3
            java.lang.Object r3 = r35.getEmpty()
            if (r2 != r3) goto L_0x05b4
            goto L_0x05bb
        L_0x05b4:
            r3 = r56
            r60 = r2
            goto L_0x05cc
        L_0x05b9:
            r59 = r3
        L_0x05bb:
            r3 = 0
            r60 = r2
            androidx.compose.material3.SearchBarKt$SearchBar$2$1 r2 = new androidx.compose.material3.SearchBarKt$SearchBar$2$1
            r2.<init>(r10, r11)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r3 = r56
            r3.updateRememberedValue(r2)
        L_0x05cc:
            r6.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(r0, r2)
            r2 = r10
            androidx.compose.foundation.layout.WindowInsets r2 = (androidx.compose.foundation.layout.WindowInsets) r2
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.WindowInsetsPaddingKt.consumeWindowInsets((androidx.compose.ui.Modifier) r0, (androidx.compose.foundation.layout.WindowInsets) r2)
            r2 = 0
            r3 = r2
            r13 = 0
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r6.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            boolean r1 = r6.changed((java.lang.Object) r15)
            boolean r2 = r6.changed((java.lang.Object) r8)
            r1 = r1 | r2
            r2 = r6
            r26 = 0
            r54 = r3
            java.lang.Object r3 = r2.rememberedValue()
            r34 = 0
            if (r1 != 0) goto L_0x060e
            androidx.compose.runtime.Composer$Companion r35 = androidx.compose.runtime.Composer.Companion
            r56 = r1
            java.lang.Object r1 = r35.getEmpty()
            if (r3 != r1) goto L_0x060c
            goto L_0x0610
        L_0x060c:
            r1 = r3
            goto L_0x061f
        L_0x060e:
            r56 = r1
        L_0x0610:
            r1 = 0
            r58 = r1
            androidx.compose.material3.SearchBarKt$SearchBar$3$1 r1 = new androidx.compose.material3.SearchBarKt$SearchBar$3$1
            r1.<init>(r15, r8)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r2.updateRememberedValue(r1)
        L_0x061f:
            r6.endReplaceableGroup()
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            androidx.compose.ui.Modifier r26 = androidx.compose.ui.layout.LayoutModifierKt.layout(r0, r1)
            androidx.compose.material3.SearchBarKt$SearchBar$4 r13 = new androidx.compose.material3.SearchBarKt$SearchBar$4
            r0 = r13
            r34 = r16
            r1 = r47
            r3 = 0
            r2 = r48
            r35 = r53
            r3 = r49
            r36 = r4
            r4 = r50
            r37 = r5
            r5 = r51
            r38 = r6
            r6 = r17
            r7 = r18
            r39 = r8
            r8 = r19
            r40 = r9
            r9 = r20
            r41 = r10
            r10 = r21
            r42 = r11
            r11 = r23
            r12 = r34
            r43 = r13
            r16 = 0
            r13 = r40
            r44 = r14
            r14 = r39
            r45 = r15
            r16 = r62
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = -867266817(0xffffffffcc4e8eff, float:-5.4148092E7)
            r15 = r38
            r1 = r43
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r2, r1)
            r10 = r0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            int r0 = r40 << 6
            r0 = r0 & r25
            r1 = 12582912(0xc00000, float:1.7632415E-38)
            r12 = r0 | r1
            r8 = 0
            r9 = 0
            r13 = 96
            r1 = r26
            r2 = r28
            r3 = r29
            r5 = r32
            r7 = r22
            r11 = r15
            androidx.compose.material3.SurfaceKt.m3772SurfaceT9BRK9s(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r50)
            androidx.compose.material3.SearchBarKt$SearchBar$5 r1 = new androidx.compose.material3.SearchBarKt$SearchBar$5
            r14 = r50
            r2 = r37
            r3 = 0
            r1.<init>(r14, r2, r3)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            int r3 = r34 >> 9
            r3 = r3 & 14
            r3 = r3 | 64
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r1, (androidx.compose.runtime.Composer) r15, (int) r3)
            int r0 = r34 >> 12
            r0 = r0 & 14
            r1 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r15.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
            r13 = r51
            boolean r3 = r15.changed((java.lang.Object) r13)
            r4 = r15
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r7 = 0
            if (r3 != 0) goto L_0x06d9
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r6 != r8) goto L_0x06d7
            goto L_0x06d9
        L_0x06d7:
            r8 = r6
            goto L_0x06e6
        L_0x06d9:
            r8 = 0
            androidx.compose.material3.SearchBarKt$SearchBar$6$1 r9 = new androidx.compose.material3.SearchBarKt$SearchBar$6$1
            r9.<init>(r13)
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r8 = r9
            r4.updateRememberedValue(r8)
        L_0x06e6:
            r15.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            int r0 = r34 >> 9
            r0 = r0 & 14
            r1 = 0
            androidx.activity.compose.BackHandlerKt.BackHandler(r14, r8, r15, r0, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x06fe
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x06fe:
            r24 = r21
            r25 = r22
            r26 = r23
            r21 = r18
            r22 = r19
            r23 = r20
            r20 = r17
        L_0x070c:
            androidx.compose.runtime.ScopeUpdateScope r12 = r15.endRestartGroup()
            if (r12 != 0) goto L_0x0715
            r28 = r15
            goto L_0x074f
        L_0x0715:
            androidx.compose.material3.SearchBarKt$SearchBar$7 r27 = new androidx.compose.material3.SearchBarKt$SearchBar$7
            r0 = r27
            r1 = r47
            r2 = r48
            r3 = r49
            r4 = r50
            r5 = r51
            r6 = r44
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r31
            r46 = r12
            r12 = r24
            r13 = r25
            r14 = r42
            r28 = r15
            r15 = r26
            r16 = r62
            r17 = r64
            r18 = r65
            r19 = r66
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r27
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r46
            r1.updateScope(r0)
        L_0x074f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.m3659SearchBarId_Pb_0(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final boolean SearchBar_Id_Pb_0$lambda$2(State<Boolean> $useFullScreenShape$delegate) {
        return ((Boolean) $useFullScreenShape$delegate.getValue()).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:121:0x019e, code lost:
        if (r6.changed((java.lang.Object) r47) != false) goto L_0x01a5;
     */
    /* renamed from: DockedSearchBar-rpjkMjA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m3658DockedSearchBarrpjkMjA(java.lang.String r36, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r37, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r38, boolean r39, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r40, androidx.compose.ui.Modifier r41, boolean r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, androidx.compose.ui.graphics.Shape r46, androidx.compose.material3.SearchBarColors r47, float r48, androidx.compose.foundation.interaction.MutableInteractionSource r49, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, androidx.compose.runtime.Composer r51, int r52, int r53, int r54) {
        /*
            r15 = r36
            r14 = r37
            r13 = r38
            r12 = r39
            r11 = r40
            r10 = r50
            r9 = r52
            r8 = r53
            r7 = r54
            java.lang.String r0 = "query"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onQueryChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "onSearch"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "onActiveChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -451213062(0xffffffffe51b08fa, float:-4.5758275E22)
            r1 = r51
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DockedSearchBar)P(11,8,9!1,7,6,3,10,5,14,12!1,13:c#ui.unit.Dp,4)353@17339L11,354@17400L8,356@17514L39,359@17649L7,364@17756L38,361@17662L1564,406@19232L306,415@19574L37,415@19544L67:SearchBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r52
            r2 = r53
            r3 = r7 & 1
            if (r3 == 0) goto L_0x0048
            r1 = r1 | 6
            goto L_0x0056
        L_0x0048:
            r3 = r9 & 14
            if (r3 != 0) goto L_0x0056
            boolean r3 = r6.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x0054
            r3 = 4
            goto L_0x0055
        L_0x0054:
            r3 = 2
        L_0x0055:
            r1 = r1 | r3
        L_0x0056:
            r3 = r7 & 2
            r16 = 32
            r17 = 16
            if (r3 == 0) goto L_0x0061
            r1 = r1 | 48
            goto L_0x0071
        L_0x0061:
            r3 = r9 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0071
            boolean r3 = r6.changedInstance(r14)
            if (r3 == 0) goto L_0x006e
            r3 = r16
            goto L_0x0070
        L_0x006e:
            r3 = r17
        L_0x0070:
            r1 = r1 | r3
        L_0x0071:
            r3 = r7 & 4
            r18 = 256(0x100, float:3.59E-43)
            r19 = 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x007c
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x008c
        L_0x007c:
            r3 = r9 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x008c
            boolean r3 = r6.changedInstance(r13)
            if (r3 == 0) goto L_0x0089
            r3 = r18
            goto L_0x008b
        L_0x0089:
            r3 = r19
        L_0x008b:
            r1 = r1 | r3
        L_0x008c:
            r3 = r7 & 8
            r20 = 2048(0x800, float:2.87E-42)
            r21 = 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0097
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x00a7
        L_0x0097:
            r3 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x00a7
            boolean r3 = r6.changed((boolean) r12)
            if (r3 == 0) goto L_0x00a4
            r3 = r20
            goto L_0x00a6
        L_0x00a4:
            r3 = r21
        L_0x00a6:
            r1 = r1 | r3
        L_0x00a7:
            r3 = r7 & 16
            r22 = 16384(0x4000, float:2.2959E-41)
            r23 = 8192(0x2000, float:1.14794E-41)
            r25 = 57344(0xe000, float:8.0356E-41)
            if (r3 == 0) goto L_0x00b5
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00c5
        L_0x00b5:
            r3 = r9 & r25
            if (r3 != 0) goto L_0x00c5
            boolean r3 = r6.changedInstance(r11)
            if (r3 == 0) goto L_0x00c2
            r3 = r22
            goto L_0x00c4
        L_0x00c2:
            r3 = r23
        L_0x00c4:
            r1 = r1 | r3
        L_0x00c5:
            r3 = r7 & 32
            if (r3 == 0) goto L_0x00d0
            r24 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r24
            r4 = r41
            goto L_0x00e8
        L_0x00d0:
            r24 = 458752(0x70000, float:6.42848E-40)
            r24 = r9 & r24
            if (r24 != 0) goto L_0x00e6
            r4 = r41
            boolean r24 = r6.changed((java.lang.Object) r4)
            if (r24 == 0) goto L_0x00e1
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00e3
        L_0x00e1:
            r24 = 65536(0x10000, float:9.18355E-41)
        L_0x00e3:
            r1 = r1 | r24
            goto L_0x00e8
        L_0x00e6:
            r4 = r41
        L_0x00e8:
            r24 = r7 & 64
            if (r24 == 0) goto L_0x00f3
            r26 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r26
            r5 = r42
            goto L_0x010b
        L_0x00f3:
            r26 = 3670016(0x380000, float:5.142788E-39)
            r26 = r9 & r26
            if (r26 != 0) goto L_0x0109
            r5 = r42
            boolean r27 = r6.changed((boolean) r5)
            if (r27 == 0) goto L_0x0104
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0106
        L_0x0104:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x0106:
            r1 = r1 | r27
            goto L_0x010b
        L_0x0109:
            r5 = r42
        L_0x010b:
            r0 = r7 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0116
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r28
            r4 = r43
            goto L_0x012e
        L_0x0116:
            r28 = 29360128(0x1c00000, float:7.052966E-38)
            r28 = r9 & r28
            if (r28 != 0) goto L_0x012c
            r4 = r43
            boolean r28 = r6.changedInstance(r4)
            if (r28 == 0) goto L_0x0127
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0129
        L_0x0127:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x0129:
            r1 = r1 | r28
            goto L_0x012e
        L_0x012c:
            r4 = r43
        L_0x012e:
            r4 = r7 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x0139
            r28 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r28
            r5 = r44
            goto L_0x0151
        L_0x0139:
            r28 = 234881024(0xe000000, float:1.5777218E-30)
            r28 = r9 & r28
            if (r28 != 0) goto L_0x014f
            r5 = r44
            boolean r28 = r6.changedInstance(r5)
            if (r28 == 0) goto L_0x014a
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x014c
        L_0x014a:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x014c:
            r1 = r1 | r28
            goto L_0x0151
        L_0x014f:
            r5 = r44
        L_0x0151:
            r5 = r7 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x015c
            r28 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r28
            r11 = r45
            goto L_0x0174
        L_0x015c:
            r28 = 1879048192(0x70000000, float:1.58456325E29)
            r28 = r9 & r28
            if (r28 != 0) goto L_0x0172
            r11 = r45
            boolean r28 = r6.changedInstance(r11)
            if (r28 == 0) goto L_0x016d
            r28 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x016f
        L_0x016d:
            r28 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x016f:
            r1 = r1 | r28
            goto L_0x0174
        L_0x0172:
            r11 = r45
        L_0x0174:
            r28 = r8 & 14
            if (r28 != 0) goto L_0x018e
            r11 = r7 & 1024(0x400, float:1.435E-42)
            if (r11 != 0) goto L_0x0187
            r11 = r46
            boolean r28 = r6.changed((java.lang.Object) r11)
            if (r28 == 0) goto L_0x0189
            r26 = 4
            goto L_0x018b
        L_0x0187:
            r11 = r46
        L_0x0189:
            r26 = 2
        L_0x018b:
            r2 = r2 | r26
            goto L_0x0190
        L_0x018e:
            r11 = r46
        L_0x0190:
            r26 = r8 & 112(0x70, float:1.57E-43)
            if (r26 != 0) goto L_0x01a8
            r11 = r7 & 2048(0x800, float:2.87E-42)
            if (r11 != 0) goto L_0x01a1
            r11 = r47
            boolean r26 = r6.changed((java.lang.Object) r11)
            if (r26 == 0) goto L_0x01a3
            goto L_0x01a5
        L_0x01a1:
            r11 = r47
        L_0x01a3:
            r16 = r17
        L_0x01a5:
            r2 = r2 | r16
            goto L_0x01aa
        L_0x01a8:
            r11 = r47
        L_0x01aa:
            r11 = r7 & 4096(0x1000, float:5.74E-42)
            if (r11 == 0) goto L_0x01b3
            r2 = r2 | 384(0x180, float:5.38E-43)
            r12 = r48
            goto L_0x01c7
        L_0x01b3:
            r12 = r8 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x01c5
            r12 = r48
            boolean r16 = r6.changed((float) r12)
            if (r16 == 0) goto L_0x01c0
            goto L_0x01c2
        L_0x01c0:
            r18 = r19
        L_0x01c2:
            r2 = r2 | r18
            goto L_0x01c7
        L_0x01c5:
            r12 = r48
        L_0x01c7:
            r12 = r7 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x01d0
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r13 = r49
            goto L_0x01e4
        L_0x01d0:
            r13 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x01e2
            r13 = r49
            boolean r16 = r6.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x01dd
            goto L_0x01df
        L_0x01dd:
            r20 = r21
        L_0x01df:
            r2 = r2 | r20
            goto L_0x01e4
        L_0x01e2:
            r13 = r49
        L_0x01e4:
            r13 = r7 & 16384(0x4000, float:2.2959E-41)
            if (r13 == 0) goto L_0x01eb
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01fa
        L_0x01eb:
            r13 = r8 & r25
            if (r13 != 0) goto L_0x01fa
            boolean r13 = r6.changedInstance(r10)
            if (r13 == 0) goto L_0x01f6
            goto L_0x01f8
        L_0x01f6:
            r22 = r23
        L_0x01f8:
            r2 = r2 | r22
        L_0x01fa:
            r13 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r13 = r13 & r1
            r8 = 306783378(0x12492492, float:6.3469493E-28)
            if (r13 != r8) goto L_0x0232
            r8 = 46811(0xb6db, float:6.5596E-41)
            r8 = r8 & r2
            r13 = 9362(0x2492, float:1.3119E-41)
            if (r8 != r13) goto L_0x0232
            boolean r8 = r6.getSkipping()
            if (r8 != 0) goto L_0x0212
            goto L_0x0232
        L_0x0212:
            r6.skipToGroupEnd()
            r14 = r39
            r13 = r40
            r34 = r41
            r19 = r42
            r20 = r43
            r21 = r44
            r22 = r45
            r23 = r46
            r24 = r47
            r25 = r48
            r26 = r49
            r30 = r1
            r33 = r2
            r15 = r6
            goto L_0x045f
        L_0x0232:
            r6.startDefaults()
            r8 = r9 & 1
            if (r8 == 0) goto L_0x0279
            boolean r8 = r6.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0240
            goto L_0x0279
        L_0x0240:
            r6.skipToGroupEnd()
            r0 = r7 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0249
            r2 = r2 & -15
        L_0x0249:
            r0 = r7 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0264
            r0 = r2 & -113(0xffffffffffffff8f, float:NaN)
            r13 = r41
            r16 = r42
            r17 = r43
            r18 = r44
            r19 = r45
            r20 = r46
            r21 = r47
            r22 = r48
            r23 = r49
            r12 = r0
            goto L_0x0345
        L_0x0264:
            r13 = r41
            r16 = r42
            r17 = r43
            r18 = r44
            r19 = r45
            r20 = r46
            r21 = r47
            r22 = r48
            r23 = r49
            r12 = r2
            goto L_0x0345
        L_0x0279:
            if (r3 == 0) goto L_0x0280
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x0282
        L_0x0280:
            r3 = r41
        L_0x0282:
            if (r24 == 0) goto L_0x0286
            r8 = 1
            goto L_0x0288
        L_0x0286:
            r8 = r42
        L_0x0288:
            if (r0 == 0) goto L_0x028c
            r0 = 0
            goto L_0x028e
        L_0x028c:
            r0 = r43
        L_0x028e:
            if (r4 == 0) goto L_0x0292
            r4 = 0
            goto L_0x0294
        L_0x0292:
            r4 = r44
        L_0x0294:
            if (r5 == 0) goto L_0x0298
            r5 = 0
            goto L_0x029a
        L_0x0298:
            r5 = r45
        L_0x029a:
            r13 = r7 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x02aa
            androidx.compose.material3.SearchBarDefaults r13 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r41 = r0
            r0 = 6
            androidx.compose.ui.graphics.Shape r0 = r13.getDockedShape(r6, r0)
            r2 = r2 & -15
            goto L_0x02ae
        L_0x02aa:
            r41 = r0
            r0 = r46
        L_0x02ae:
            r13 = r7 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x02c7
            androidx.compose.material3.SearchBarDefaults r16 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r23 = 3072(0xc00, float:4.305E-42)
            r24 = 7
            r17 = 0
            r19 = 0
            r21 = 0
            r22 = r6
            androidx.compose.material3.SearchBarColors r13 = r16.m3653colorsKlgxPg(r17, r19, r21, r22, r23, r24)
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x02c9
        L_0x02c7:
            r13 = r47
        L_0x02c9:
            if (r11 == 0) goto L_0x02d2
            androidx.compose.material3.SearchBarDefaults r11 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r11 = r11.m3654getElevationD9Ej5fM()
            goto L_0x02d4
        L_0x02d2:
            r11 = r48
        L_0x02d4:
            if (r12 == 0) goto L_0x032e
            r12 = 0
            r16 = 0
            r42 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r0 = 0
            r43 = r6
            r17 = 0
            r44 = r0
            java.lang.Object r0 = r43.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r45 = r2
            java.lang.Object r2 = r19.getEmpty()
            if (r0 != r2) goto L_0x030c
            r2 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r46 = r0
            r0 = r43
            r0.updateRememberedValue(r2)
            goto L_0x0312
        L_0x030c:
            r46 = r0
            r0 = r43
            r2 = r46
        L_0x0312:
            r6.endReplaceableGroup()
            r0 = r2
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r17 = r41
            r20 = r42
            r12 = r45
            r23 = r0
            r18 = r4
            r19 = r5
            r16 = r8
            r22 = r11
            r21 = r13
            r13 = r3
            goto L_0x0345
        L_0x032e:
            r42 = r0
            r45 = r2
            r17 = r41
            r20 = r42
            r12 = r45
            r23 = r49
            r18 = r4
            r19 = r5
            r16 = r8
            r22 = r11
            r21 = r13
            r13 = r3
        L_0x0345:
            r6.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0356
            java.lang.String r0 = "androidx.compose.material3.DockedSearchBar (SearchBar.kt:342)"
            r2 = -451213062(0xffffffffe51b08fa, float:-4.5758275E22)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r12, r0)
        L_0x0356:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r2 = 0
            r3 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r4, r5)
            java.lang.Object r4 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r11 = r4
            androidx.compose.ui.focus.FocusManager r11 = (androidx.compose.ui.focus.FocusManager) r11
            long r26 = r21.m3651getContainerColor0d7_KjU()
            long r2 = r21.m3651getContainerColor0d7_KjU()
            r0 = 0
            long r28 = androidx.compose.material3.ColorSchemeKt.m3369contentColorForek8zF_U(r2, r6, r0)
            r0 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ZIndexModifierKt.zIndex(r13, r0)
            float r2 = SearchBarMinWidth
            androidx.compose.ui.Modifier r24 = androidx.compose.foundation.layout.SizeKt.m2327width3ABfNKs(r0, r2)
            androidx.compose.material3.SearchBarKt$DockedSearchBar$2 r8 = new androidx.compose.material3.SearchBarKt$DockedSearchBar$2
            r0 = r8
            r30 = r1
            r1 = r36
            r2 = r37
            r3 = r38
            r4 = r39
            r5 = r40
            r15 = r6
            r6 = r16
            r7 = r17
            r31 = r8
            r8 = r18
            r9 = r19
            r10 = r21
            r32 = r11
            r11 = r23
            r33 = r12
            r12 = r30
            r34 = r13
            r13 = r33
            r14 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = -1764436203(0xffffffff96d4d715, float:-3.4386183E-25)
            r1 = 1
            r2 = r31
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r1, r2)
            r10 = r0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            int r0 = r33 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r1 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r1
            int r1 = r33 << 6
            r1 = r1 & r25
            r12 = r0 | r1
            r8 = 0
            r9 = 0
            r13 = 96
            r1 = r24
            r2 = r20
            r3 = r26
            r5 = r28
            r7 = r22
            r11 = r15
            androidx.compose.material3.SurfaceKt.m3772SurfaceT9BRK9s(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r39)
            androidx.compose.material3.SearchBarKt$DockedSearchBar$3 r1 = new androidx.compose.material3.SearchBarKt$DockedSearchBar$3
            r2 = 0
            r14 = r39
            r3 = r32
            r1.<init>(r14, r3, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            int r2 = r30 >> 9
            r2 = r2 & 14
            r2 = r2 | 64
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r1, (androidx.compose.runtime.Composer) r15, (int) r2)
            int r0 = r30 >> 12
            r0 = r0 & 14
            r1 = 0
            r2 = 1157296644(0x44faf204, float:2007.563)
            r15.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r13 = r40
            boolean r2 = r15.changed((java.lang.Object) r13)
            r4 = r15
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r7 = 0
            if (r2 != 0) goto L_0x042a
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r6 != r8) goto L_0x0428
            goto L_0x042a
        L_0x0428:
            r8 = r6
            goto L_0x0437
        L_0x042a:
            r8 = 0
            androidx.compose.material3.SearchBarKt$DockedSearchBar$4$1 r9 = new androidx.compose.material3.SearchBarKt$DockedSearchBar$4$1
            r9.<init>(r13)
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r8 = r9
            r4.updateRememberedValue(r8)
        L_0x0437:
            r15.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            int r0 = r30 >> 9
            r0 = r0 & 14
            r1 = 0
            androidx.activity.compose.BackHandlerKt.BackHandler(r14, r8, r15, r0, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x044f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x044f:
            r24 = r21
            r25 = r22
            r26 = r23
            r21 = r18
            r22 = r19
            r23 = r20
            r19 = r16
            r20 = r17
        L_0x045f:
            androidx.compose.runtime.ScopeUpdateScope r12 = r15.endRestartGroup()
            if (r12 != 0) goto L_0x0468
            r28 = r15
            goto L_0x04a0
        L_0x0468:
            androidx.compose.material3.SearchBarKt$DockedSearchBar$5 r27 = new androidx.compose.material3.SearchBarKt$DockedSearchBar$5
            r0 = r27
            r1 = r36
            r2 = r37
            r3 = r38
            r4 = r39
            r5 = r40
            r6 = r34
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r11 = r23
            r35 = r12
            r12 = r24
            r13 = r25
            r14 = r26
            r28 = r15
            r15 = r50
            r16 = r52
            r17 = r53
            r18 = r54
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r27
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r35
            r1.updateScope(r0)
        L_0x04a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.m3658DockedSearchBarrpjkMjA(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r40v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v48, resolved type: androidx.compose.ui.focus.FocusRequester} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v52, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v49, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r89v4, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v53, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v55, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x03f2 A[LOOP:0: B:191:0x03f0->B:192:0x03f2, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x040d  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x041b  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x04eb  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x04f9  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x05a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SearchBarInputField(java.lang.String r80, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r81, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r82, boolean r83, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r84, androidx.compose.ui.Modifier r85, boolean r86, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r87, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r88, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r89, androidx.compose.material3.TextFieldColors r90, androidx.compose.foundation.interaction.MutableInteractionSource r91, androidx.compose.runtime.Composer r92, int r93, int r94, int r95) {
        /*
            r15 = r80
            r13 = r82
            r12 = r83
            r11 = r84
            r10 = r93
            r14 = r95
            r0 = -1330051158(0xffffffffb0b907aa, float:-1.34627E-9)
            r1 = r92
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SearchBarInputField)P(10,7,8!1,6,5,2,9,4,11)433@20114L18,434@20184L39,436@20254L29,437@20310L34,438@20385L39,450@20838L42,451@20904L304,463@21299L7,464@21384L28,466@21547L19,443@20594L2004:SearchBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r93
            r2 = r94
            r3 = r14 & 1
            if (r3 == 0) goto L_0x0025
            r1 = r1 | 6
            goto L_0x0033
        L_0x0025:
            r3 = r10 & 14
            if (r3 != 0) goto L_0x0033
            boolean r3 = r9.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x0031
            r3 = 4
            goto L_0x0032
        L_0x0031:
            r3 = 2
        L_0x0032:
            r1 = r1 | r3
        L_0x0033:
            r3 = r14 & 2
            if (r3 == 0) goto L_0x003c
            r1 = r1 | 48
            r8 = r81
            goto L_0x0051
        L_0x003c:
            r3 = r10 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004f
            r8 = r81
            boolean r3 = r9.changedInstance(r8)
            if (r3 == 0) goto L_0x004b
            r3 = 32
            goto L_0x004d
        L_0x004b:
            r3 = 16
        L_0x004d:
            r1 = r1 | r3
            goto L_0x0051
        L_0x004f:
            r8 = r81
        L_0x0051:
            r3 = r14 & 4
            if (r3 == 0) goto L_0x0058
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0058:
            r3 = r10 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0068
            boolean r3 = r9.changedInstance(r13)
            if (r3 == 0) goto L_0x0065
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r3
        L_0x0068:
            r3 = r14 & 8
            if (r3 == 0) goto L_0x006f
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006f:
            r3 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x007f
            boolean r3 = r9.changed((boolean) r12)
            if (r3 == 0) goto L_0x007c
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r1 = r1 | r3
        L_0x007f:
            r3 = r14 & 16
            if (r3 == 0) goto L_0x0086
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0086:
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r10
            if (r3 != 0) goto L_0x0098
            boolean r3 = r9.changedInstance(r11)
            if (r3 == 0) goto L_0x0095
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r3
        L_0x0098:
            r3 = r14 & 32
            r48 = 196608(0x30000, float:2.75506E-40)
            if (r3 == 0) goto L_0x00a3
            r1 = r1 | r48
            r4 = r85
            goto L_0x00bb
        L_0x00a3:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x00b9
            r4 = r85
            boolean r16 = r9.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x00b4
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00b4:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r1 = r1 | r16
            goto L_0x00bb
        L_0x00b9:
            r4 = r85
        L_0x00bb:
            r16 = r14 & 64
            if (r16 == 0) goto L_0x00c6
            r17 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r17
            r5 = r86
            goto L_0x00de
        L_0x00c6:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r10 & r17
            if (r17 != 0) goto L_0x00dc
            r5 = r86
            boolean r18 = r9.changed((boolean) r5)
            if (r18 == 0) goto L_0x00d7
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d7:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r1 = r1 | r18
            goto L_0x00de
        L_0x00dc:
            r5 = r86
        L_0x00de:
            r6 = r14 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00e9
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r19
            r7 = r87
            goto L_0x0101
        L_0x00e9:
            r19 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r10 & r19
            if (r19 != 0) goto L_0x00ff
            r7 = r87
            boolean r20 = r9.changedInstance(r7)
            if (r20 == 0) goto L_0x00fa
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fc
        L_0x00fa:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fc:
            r1 = r1 | r20
            goto L_0x0101
        L_0x00ff:
            r7 = r87
        L_0x0101:
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x010c
            r20 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r20
            r4 = r88
            goto L_0x0124
        L_0x010c:
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            r20 = r10 & r20
            if (r20 != 0) goto L_0x0122
            r4 = r88
            boolean r20 = r9.changedInstance(r4)
            if (r20 == 0) goto L_0x011d
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011f
        L_0x011d:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011f:
            r1 = r1 | r20
            goto L_0x0124
        L_0x0122:
            r4 = r88
        L_0x0124:
            r4 = r14 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x012f
            r20 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r20
            r5 = r89
            goto L_0x0147
        L_0x012f:
            r20 = 1879048192(0x70000000, float:1.58456325E29)
            r20 = r10 & r20
            if (r20 != 0) goto L_0x0145
            r5 = r89
            boolean r20 = r9.changedInstance(r5)
            if (r20 == 0) goto L_0x0140
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0142
        L_0x0140:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0142:
            r1 = r1 | r20
            goto L_0x0147
        L_0x0145:
            r5 = r89
        L_0x0147:
            r20 = r94 & 14
            if (r20 != 0) goto L_0x0161
            r5 = r14 & 1024(0x400, float:1.435E-42)
            if (r5 != 0) goto L_0x015a
            r5 = r90
            boolean r20 = r9.changed((java.lang.Object) r5)
            if (r20 == 0) goto L_0x015c
            r17 = 4
            goto L_0x015e
        L_0x015a:
            r5 = r90
        L_0x015c:
            r17 = 2
        L_0x015e:
            r2 = r2 | r17
            goto L_0x0163
        L_0x0161:
            r5 = r90
        L_0x0163:
            r5 = r14 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x016c
            r2 = r2 | 48
            r7 = r91
            goto L_0x0182
        L_0x016c:
            r17 = r94 & 112(0x70, float:1.57E-43)
            if (r17 != 0) goto L_0x0180
            r7 = r91
            boolean r17 = r9.changed((java.lang.Object) r7)
            if (r17 == 0) goto L_0x017b
            r18 = 32
            goto L_0x017d
        L_0x017b:
            r18 = 16
        L_0x017d:
            r2 = r2 | r18
            goto L_0x0182
        L_0x0180:
            r7 = r91
        L_0x0182:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r7 = r1 & r17
            r8 = 306783378(0x12492492, float:6.3469493E-28)
            if (r7 != r8) goto L_0x01b2
            r7 = r2 & 91
            r8 = 18
            if (r7 != r8) goto L_0x01b2
            boolean r7 = r9.getSkipping()
            if (r7 != 0) goto L_0x0199
            goto L_0x01b2
        L_0x0199:
            r9.skipToGroupEnd()
            r41 = r85
            r30 = r86
            r31 = r87
            r32 = r88
            r33 = r89
            r40 = r90
            r34 = r91
            r35 = r1
            r39 = r2
            r42 = r9
            goto L_0x05a6
        L_0x01b2:
            r9.startDefaults()
            r7 = r10 & 1
            if (r7 == 0) goto L_0x01da
            boolean r7 = r9.getDefaultsInvalid()
            if (r7 == 0) goto L_0x01c0
            goto L_0x01da
        L_0x01c0:
            r9.skipToGroupEnd()
            r0 = r14 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01c9
            r2 = r2 & -15
        L_0x01c9:
            r8 = r85
            r30 = r86
            r31 = r87
            r32 = r88
            r33 = r89
            r7 = r90
            r34 = r91
            r6 = r2
            goto L_0x0295
        L_0x01da:
            if (r3 == 0) goto L_0x01e1
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x01e3
        L_0x01e1:
            r3 = r85
        L_0x01e3:
            if (r16 == 0) goto L_0x01e7
            r7 = 1
            goto L_0x01e9
        L_0x01e7:
            r7 = r86
        L_0x01e9:
            if (r6 == 0) goto L_0x01ed
            r6 = 0
            goto L_0x01ef
        L_0x01ed:
            r6 = r87
        L_0x01ef:
            if (r0 == 0) goto L_0x01f3
            r0 = 0
            goto L_0x01f5
        L_0x01f3:
            r0 = r88
        L_0x01f5:
            if (r4 == 0) goto L_0x01f9
            r4 = 0
            goto L_0x01fb
        L_0x01f9:
            r4 = r89
        L_0x01fb:
            r8 = r14 & 1024(0x400, float:1.435E-42)
            if (r8 == 0) goto L_0x022c
            androidx.compose.material3.SearchBarDefaults r16 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r46 = 24576(0x6000, float:3.4438E-41)
            r47 = 16383(0x3fff, float:2.2957E-41)
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r26 = 0
            r28 = 0
            r30 = 0
            r32 = 0
            r34 = 0
            r36 = 0
            r38 = 0
            r40 = 0
            r42 = 0
            r45 = 0
            r44 = r9
            androidx.compose.material3.TextFieldColors r8 = r16.m3657inputFieldColorsITpI4ow(r17, r19, r21, r23, r25, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r45, r46, r47)
            r2 = r2 & -15
            goto L_0x022e
        L_0x022c:
            r8 = r90
        L_0x022e:
            if (r5 == 0) goto L_0x0283
            r5 = 0
            r16 = 0
            r85 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r0 = 0
            r86 = r9
            r17 = 0
            r87 = r0
            java.lang.Object r0 = r86.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r88 = r2
            java.lang.Object r2 = r19.getEmpty()
            if (r0 != r2) goto L_0x0266
            r2 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r89 = r0
            r0 = r86
            r0.updateRememberedValue(r2)
            goto L_0x026c
        L_0x0266:
            r89 = r0
            r0 = r86
            r2 = r89
        L_0x026c:
            r9.endReplaceableGroup()
            r0 = r2
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r32 = r85
            r34 = r0
            r33 = r4
            r31 = r6
            r30 = r7
            r7 = r8
            r6 = r88
            r8 = r3
            goto L_0x0295
        L_0x0283:
            r85 = r0
            r88 = r2
            r32 = r85
            r34 = r91
            r33 = r4
            r31 = r6
            r30 = r7
            r7 = r8
            r6 = r88
            r8 = r3
        L_0x0295:
            r9.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02a6
            java.lang.String r0 = "androidx.compose.material3.SearchBarInputField (SearchBar.kt:422)"
            r2 = -1330051158(0xffffffffb0b907aa, float:-1.34627E-9)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r6, r0)
        L_0x02a6:
            r0 = 0
            r2 = r0
            r3 = 0
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r9.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r4)
            r4 = 0
            r5 = r9
            r16 = 0
            java.lang.Object r0 = r5.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r85 = r2
            java.lang.Object r2 = r18.getEmpty()
            if (r0 != r2) goto L_0x02d6
            r2 = 0
            androidx.compose.ui.focus.FocusRequester r18 = new androidx.compose.ui.focus.FocusRequester
            r18.<init>()
            r2 = r18
            r5.updateRememberedValue(r2)
            goto L_0x02d7
        L_0x02d6:
            r2 = r0
        L_0x02d7:
            r9.endReplaceableGroup()
            r5 = r2
            androidx.compose.ui.focus.FocusRequester r5 = (androidx.compose.ui.focus.FocusRequester) r5
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m3744getSearchBarSearchadMyvUU()
            r2 = 6
            java.lang.String r4 = androidx.compose.material3.Strings_androidKt.m3763getStringNWtq28(r0, r9, r2)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m3748getSuggestionsAvailableadMyvUU()
            java.lang.String r3 = androidx.compose.material3.Strings_androidKt.m3763getStringNWtq28(r0, r9, r2)
            r0 = 462567106(0x1b9236c2, float:2.418906E-22)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "*439@20460L7,440@20502L74"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r16 = 6
            r17 = 0
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r10)
            java.lang.Object r2 = r9.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.ui.text.TextStyle r2 = (androidx.compose.ui.text.TextStyle) r2
            long r16 = r2.m7056getColor0d7_KjU()
            r0 = 0
            r18 = r16
            r2 = 0
            androidx.compose.ui.graphics.Color$Companion r10 = androidx.compose.ui.graphics.Color.Companion
            long r20 = r10.m4999getUnspecified0d7_KjU()
            int r10 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r10 == 0) goto L_0x032e
            r2 = 1
            goto L_0x032f
        L_0x032e:
            r2 = 0
        L_0x032f:
            if (r2 == 0) goto L_0x0334
            r50 = r16
            goto L_0x0369
        L_0x0334:
            r2 = 0
            r10 = r34
            androidx.compose.foundation.interaction.InteractionSource r10 = (androidx.compose.foundation.interaction.InteractionSource) r10
            int r18 = r1 >> 18
            r18 = r18 & 14
            r18 = r18 | 48
            int r14 = r6 << 3
            r14 = r14 & 896(0x380, float:1.256E-42)
            r14 = r18 | r14
            r18 = r0
            int r0 = r6 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r14
            r14 = 0
            r85 = r7
            r86 = r30
            r87 = r14
            r88 = r10
            r89 = r9
            r90 = r0
            androidx.compose.runtime.State r0 = r85.textColor$material3_release(r86, r87, r88, r89, r90)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r20 = r0.m4973unboximpl()
            r50 = r20
        L_0x0369:
            r9.endReplaceableGroup()
            androidx.compose.material3.SearchBarDefaults r0 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r0 = r0.m3655getInputFieldHeightD9Ej5fM()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m2308height3ABfNKs(r8, r0)
            r2 = 0
            r10 = 0
            r14 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r0, r2, r14, r10)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.focus.FocusRequesterModifierKt.focusRequester(r0, r5)
            int r2 = r1 >> 12
            r2 = r2 & 14
            r14 = 0
            r10 = 1157296644(0x44faf204, float:2007.563)
            r9.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r10)
            boolean r10 = r9.changed((java.lang.Object) r11)
            r86 = r9
            r16 = 0
            r87 = r2
            java.lang.Object r2 = r86.rememberedValue()
            r17 = 0
            if (r10 != 0) goto L_0x03b5
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r20 = r8
            java.lang.Object r8 = r18.getEmpty()
            if (r2 != r8) goto L_0x03b0
            goto L_0x03b7
        L_0x03b0:
            r8 = r86
            r88 = r2
            goto L_0x03c8
        L_0x03b5:
            r20 = r8
        L_0x03b7:
            r8 = 0
            r88 = r2
            androidx.compose.material3.SearchBarKt$SearchBarInputField$2$1 r2 = new androidx.compose.material3.SearchBarKt$SearchBarInputField$2$1
            r2.<init>(r11)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r8 = r86
            r8.updateRememberedValue(r2)
        L_0x03c8:
            r9.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.focus.FocusChangedModifierKt.onFocusChanged(r0, r2)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r83)
            java.lang.Object[] r2 = new java.lang.Object[]{r4, r2, r3, r5}
            r8 = 8
            r10 = 0
            r14 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r9.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r14)
            r14 = 0
            r86 = r8
            int r8 = r2.length
            r16 = r14
            r14 = 0
        L_0x03f0:
            if (r14 >= r8) goto L_0x0401
            r17 = r8
            r8 = r2[r14]
            boolean r18 = r9.changed((java.lang.Object) r8)
            r16 = r16 | r18
            int r14 = r14 + 1
            r8 = r17
            goto L_0x03f0
        L_0x0401:
            r8 = r9
            r14 = 0
            r87 = r2
            java.lang.Object r2 = r8.rememberedValue()
            r17 = 0
            if (r16 != 0) goto L_0x041b
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r88 = r10
            java.lang.Object r10 = r18.getEmpty()
            if (r2 != r10) goto L_0x0418
            goto L_0x041d
        L_0x0418:
            r89 = r2
            goto L_0x042c
        L_0x041b:
            r88 = r10
        L_0x041d:
            r10 = 0
            r89 = r2
            androidx.compose.material3.SearchBarKt$SearchBarInputField$3$1 r2 = new androidx.compose.material3.SearchBarKt$SearchBarInputField$3$1
            r2.<init>(r4, r12, r3, r5)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r8.updateRememberedValue(r2)
        L_0x042c:
            r9.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r8 = 0
            r10 = 0
            r14 = 1
            androidx.compose.ui.Modifier r16 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r10, r2, r14, r8)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r2 = 6
            r8 = 0
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r14 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r10, r14)
            java.lang.Object r10 = r9.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.ui.text.TextStyle r10 = (androidx.compose.ui.text.TextStyle) r10
            androidx.compose.ui.text.TextStyle r0 = new androidx.compose.ui.text.TextStyle
            r49 = r0
            r77 = 4194302(0x3ffffe, float:5.877469E-39)
            r78 = 0
            r52 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r58 = 0
            r59 = 0
            r61 = 0
            r62 = 0
            r63 = 0
            r64 = 0
            r66 = 0
            r67 = 0
            r68 = 0
            r69 = 0
            r70 = 0
            r72 = 0
            r73 = 0
            r74 = 0
            r75 = 0
            r76 = 0
            r49.<init>((long) r50, (long) r52, (androidx.compose.ui.text.font.FontWeight) r54, (androidx.compose.ui.text.font.FontStyle) r55, (androidx.compose.ui.text.font.FontSynthesis) r56, (androidx.compose.ui.text.font.FontFamily) r57, (java.lang.String) r58, (long) r59, (androidx.compose.ui.text.style.BaselineShift) r61, (androidx.compose.ui.text.style.TextGeometricTransform) r62, (androidx.compose.ui.text.intl.LocaleList) r63, (long) r64, (androidx.compose.ui.text.style.TextDecoration) r66, (androidx.compose.ui.graphics.Shadow) r67, (androidx.compose.ui.text.style.TextAlign) r68, (androidx.compose.ui.text.style.TextDirection) r69, (long) r70, (androidx.compose.ui.text.style.TextIndent) r72, (androidx.compose.ui.text.PlatformTextStyle) r73, (androidx.compose.ui.text.style.LineHeightStyle) r74, (androidx.compose.ui.text.style.LineBreak) r75, (androidx.compose.ui.text.style.Hyphens) r76, (int) r77, (kotlin.jvm.internal.DefaultConstructorMarker) r78)
            androidx.compose.ui.text.TextStyle r23 = r10.merge((androidx.compose.ui.text.TextStyle) r0)
            androidx.compose.ui.graphics.SolidColor r0 = new androidx.compose.ui.graphics.SolidColor
            int r2 = r6 << 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r8 = 6
            r2 = r2 | r8
            r8 = 0
            androidx.compose.runtime.State r2 = r7.cursorColor$material3_release(r8, r9, r2)
            java.lang.Object r2 = r2.getValue()
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            r86 = r3
            long r2 = r2.m4973unboximpl()
            r8 = 0
            r0.<init>(r2, r8)
            androidx.compose.foundation.text.KeyboardOptions r26 = new androidx.compose.foundation.text.KeyboardOptions
            androidx.compose.ui.text.input.ImeAction$Companion r2 = androidx.compose.ui.text.input.ImeAction.Companion
            int r39 = r2.m7211getSearcheUduSuo()
            r40 = 7
            r41 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r35 = r26
            r35.<init>(r36, r37, r38, r39, r40, r41)
            int r2 = r1 >> 6
            r2 = r2 & 14
            int r3 = r1 << 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = 0
            r8 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r9.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r8)
            boolean r8 = r9.changed((java.lang.Object) r13)
            boolean r10 = r9.changed((java.lang.Object) r15)
            r8 = r8 | r10
            r10 = r9
            r14 = 0
            r92 = r1
            java.lang.Object r1 = r10.rememberedValue()
            r17 = 0
            if (r8 != 0) goto L_0x04f9
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r85 = r2
            java.lang.Object r2 = r18.getEmpty()
            if (r1 != r2) goto L_0x04f6
            goto L_0x04fb
        L_0x04f6:
            r87 = r1
            goto L_0x050a
        L_0x04f9:
            r85 = r2
        L_0x04fb:
            r2 = 0
            r87 = r1
            androidx.compose.material3.SearchBarKt$SearchBarInputField$4$1 r1 = new androidx.compose.material3.SearchBarKt$SearchBarInputField$4$1
            r1.<init>(r13, r15)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r10.updateRememberedValue(r1)
        L_0x050a:
            r9.endReplaceableGroup()
            r40 = r1
            kotlin.jvm.functions.Function1 r40 = (kotlin.jvm.functions.Function1) r40
            androidx.compose.foundation.text.KeyboardActions r35 = new androidx.compose.foundation.text.KeyboardActions
            r17 = r35
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r41 = 0
            r42 = 47
            r43 = 0
            r35.<init>(r36, r37, r38, r39, r40, r41, r42, r43)
            r24 = r0
            androidx.compose.ui.graphics.Brush r24 = (androidx.compose.ui.graphics.Brush) r24
            androidx.compose.material3.SearchBarKt$SearchBarInputField$5 r10 = new androidx.compose.material3.SearchBarKt$SearchBarInputField$5
            r0 = r10
            r35 = r92
            r1 = r80
            r2 = r30
            r36 = r86
            r3 = r34
            r37 = r4
            r4 = r31
            r38 = r5
            r5 = r32
            r39 = r6
            r6 = r33
            r40 = r7
            r41 = r20
            r8 = r35
            r14 = r9
            r9 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = 584727264(0x22da3ae0, float:5.9151355E-18)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r0, r1, r10)
            r25 = r0
            kotlin.jvm.functions.Function3 r25 = (kotlin.jvm.functions.Function3) r25
            r0 = r35 & 14
            r1 = 102236160(0x6180000, float:2.8588023E-35)
            r0 = r0 | r1
            r1 = r35 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r35 >> 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r27 = r0 | r1
            int r0 = r39 << 6
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r28 = r0 | r48
            r0 = 0
            r42 = r14
            r14 = r0
            r18 = 1
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r29 = 7696(0x1e10, float:1.0784E-41)
            r10 = r80
            r11 = r81
            r12 = r16
            r13 = r30
            r15 = r23
            r16 = r26
            r23 = r34
            r26 = r42
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((java.lang.String) r10, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r11, (androidx.compose.ui.Modifier) r12, (boolean) r13, (boolean) r14, (androidx.compose.ui.text.TextStyle) r15, (androidx.compose.foundation.text.KeyboardOptions) r16, (androidx.compose.foundation.text.KeyboardActions) r17, (boolean) r18, (int) r19, (int) r20, (androidx.compose.ui.text.input.VisualTransformation) r21, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r22, (androidx.compose.foundation.interaction.MutableInteractionSource) r23, (androidx.compose.ui.graphics.Brush) r24, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r25, (androidx.compose.runtime.Composer) r26, (int) r27, (int) r28, (int) r29)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x05a6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x05a6:
            androidx.compose.runtime.ScopeUpdateScope r15 = r42.endRestartGroup()
            if (r15 != 0) goto L_0x05ad
            goto L_0x05dd
        L_0x05ad:
            androidx.compose.material3.SearchBarKt$SearchBarInputField$6 r16 = new androidx.compose.material3.SearchBarKt$SearchBarInputField$6
            r0 = r16
            r1 = r80
            r2 = r81
            r3 = r82
            r4 = r83
            r5 = r84
            r6 = r41
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r40
            r12 = r34
            r13 = r93
            r14 = r94
            r79 = r15
            r15 = r95
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r79
            r1.updateScope(r0)
        L_0x05dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.SearchBarInputField(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    static {
        CubicBezierEasing easingEmphasizedDecelerateCubicBezier = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        AnimationEnterEasing = easingEmphasizedDecelerateCubicBezier;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.0f, 1.0f, 0.0f, 1.0f);
        AnimationExitEasing = cubicBezierEasing;
        FiniteAnimationSpec<Float> tween = AnimationSpecKt.tween(600, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterFloatSpec = tween;
        FiniteAnimationSpec<Float> tween2 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitFloatSpec = tween2;
        FiniteAnimationSpec<IntSize> tween3 = AnimationSpecKt.tween(600, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterSizeSpec = tween3;
        FiniteAnimationSpec<IntSize> tween4 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitSizeSpec = tween4;
        DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(tween, 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.expandVertically$default(tween3, (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null));
        DockedExitTransition = EnterExitTransitionKt.fadeOut$default(tween2, 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.shrinkVertically$default(tween4, (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null));
    }

    public static final float getDockedActiveTableMinHeight() {
        return DockedActiveTableMinHeight;
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarVerticalPadding;
    }
}

package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    final /* synthetic */ Modifier $cursorModifier;
    final /* synthetic */ Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> $decorationBox;
    final /* synthetic */ Density $density;
    final /* synthetic */ Modifier $drawModifier;
    final /* synthetic */ Modifier $magnifierModifier;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ int $minLines;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ Modifier $onPositionedModifier;
    final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;
    final /* synthetic */ boolean $showHandleAndMagnifier;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$5(Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, int i, TextFieldState textFieldState, TextStyle textStyle, int i2, int i3, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, TextFieldSelectionManager textFieldSelectionManager, boolean z, boolean z2, Function1<? super TextLayoutResult, Unit> function1, OffsetMapping offsetMapping, Density density) {
        super(2);
        this.$decorationBox = function3;
        this.$$dirty1 = i;
        this.$state = textFieldState;
        this.$textStyle = textStyle;
        this.$minLines = i2;
        this.$maxLines = i3;
        this.$scrollerPosition = textFieldScrollerPosition;
        this.$value = textFieldValue;
        this.$visualTransformation = visualTransformation;
        this.$cursorModifier = modifier;
        this.$drawModifier = modifier2;
        this.$onPositionedModifier = modifier3;
        this.$magnifierModifier = modifier4;
        this.$bringIntoViewRequester = bringIntoViewRequester;
        this.$manager = textFieldSelectionManager;
        this.$showHandleAndMagnifier = z;
        this.$readOnly = z2;
        this.$onTextLayout = function1;
        this.$offsetMapping = offsetMapping;
        this.$density = density;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C624@27973L4485:CoreTextField.kt#423gt5");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-374338080, i, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:623)");
            }
            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function3 = this.$decorationBox;
            final TextFieldState textFieldState = this.$state;
            final TextStyle textStyle = this.$textStyle;
            final int i2 = this.$minLines;
            final int i3 = this.$maxLines;
            final TextFieldScrollerPosition textFieldScrollerPosition = this.$scrollerPosition;
            final TextFieldValue textFieldValue = this.$value;
            final VisualTransformation visualTransformation = this.$visualTransformation;
            final Modifier modifier = this.$cursorModifier;
            final Modifier modifier2 = this.$drawModifier;
            final Modifier modifier3 = this.$onPositionedModifier;
            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function32 = function3;
            AnonymousClass1 r3 = r4;
            final Modifier modifier4 = this.$magnifierModifier;
            final BringIntoViewRequester bringIntoViewRequester = this.$bringIntoViewRequester;
            final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
            final boolean z = this.$showHandleAndMagnifier;
            final boolean z2 = this.$readOnly;
            final Function1<TextLayoutResult, Unit> function1 = this.$onTextLayout;
            final OffsetMapping offsetMapping = this.$offsetMapping;
            final Density density = this.$density;
            AnonymousClass1 r4 = new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C649@29077L3371:CoreTextField.kt#423gt5");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2032502107, $changed, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:624)");
                        }
                        Modifier coreTextFieldModifier = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(HeightInLinesModifierKt.heightInLines(SizeKt.m2310heightInVpY3zN4$default(Modifier.Companion, textFieldState.m2684getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, (Object) null), textStyle, i2, i3), textFieldScrollerPosition, textFieldValue, visualTransformation, new CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1(textFieldState)).then(modifier).then(modifier2), textStyle).then(modifier3).then(modifier4), bringIntoViewRequester);
                        final TextFieldSelectionManager textFieldSelectionManager = textFieldSelectionManager;
                        final TextFieldState textFieldState = textFieldState;
                        final boolean z = z;
                        final boolean z2 = z2;
                        final Function1<TextLayoutResult, Unit> function1 = function1;
                        final TextFieldValue textFieldValue = textFieldValue;
                        final OffsetMapping offsetMapping = offsetMapping;
                        final Density density = density;
                        final int i = i3;
                        SimpleLayoutKt.SimpleLayout(coreTextFieldModifier, ComposableLambdaKt.composableLambda($composer, -363167407, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                invoke((Composer) p1, ((Number) p2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARNING: Removed duplicated region for block: B:41:0x015f  */
                            /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void invoke(androidx.compose.runtime.Composer r21, int r22) {
                                /*
                                    r20 = this;
                                    r0 = r20
                                    r1 = r21
                                    r2 = r22
                                    java.lang.String r3 = "C650@29131L2699,703@31848L327,715@32376L40:CoreTextField.kt#423gt5"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
                                    r3 = r2 & 11
                                    r4 = 2
                                    if (r3 != r4) goto L_0x001c
                                    boolean r3 = r21.getSkipping()
                                    if (r3 != 0) goto L_0x0017
                                    goto L_0x001c
                                L_0x0017:
                                    r21.skipToGroupEnd()
                                    goto L_0x0162
                                L_0x001c:
                                    boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r3 == 0) goto L_0x002b
                                    r3 = -1
                                    java.lang.String r4 = "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:649)"
                                    r5 = -363167407(0xffffffffea5a8151, float:-6.6039127E25)
                                    androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
                                L_0x002b:
                                    androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2 r3 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2
                                    androidx.compose.foundation.text.TextFieldState r7 = r3
                                    kotlin.jvm.functions.Function1<androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r8 = r6
                                    androidx.compose.ui.text.input.TextFieldValue r9 = r7
                                    androidx.compose.ui.text.input.OffsetMapping r10 = r8
                                    androidx.compose.ui.unit.Density r11 = r9
                                    int r12 = r10
                                    r6 = r3
                                    r6.<init>(r7, r8, r9, r10, r11, r12)
                                    androidx.compose.ui.layout.MeasurePolicy r3 = (androidx.compose.ui.layout.MeasurePolicy) r3
                                    r4 = 0
                                    r5 = r4
                                    r6 = 0
                                    r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
                                    r1.startReplaceableGroup(r7)
                                    java.lang.String r7 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r1, r7)
                                    androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
                                    androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
                                    int r8 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r4)
                                    androidx.compose.runtime.CompositionLocalMap r9 = r21.getCurrentCompositionLocalMap()
                                    androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
                                    kotlin.jvm.functions.Function3 r11 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r7)
                                    int r12 = r5 << 9
                                    r12 = r12 & 7168(0x1c00, float:1.0045E-41)
                                    r12 = r12 | 6
                                    r13 = 0
                                    androidx.compose.runtime.Applier r14 = r21.getApplier()
                                    boolean r14 = r14 instanceof androidx.compose.runtime.Applier
                                    if (r14 != 0) goto L_0x0077
                                    androidx.compose.runtime.ComposablesKt.invalidApplier()
                                L_0x0077:
                                    r21.startReusableNode()
                                    boolean r14 = r21.getInserting()
                                    if (r14 == 0) goto L_0x0084
                                    r1.createNode(r10)
                                    goto L_0x0087
                                L_0x0084:
                                    r21.useNode()
                                L_0x0087:
                                    androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m4575constructorimpl(r21)
                                    r15 = 0
                                    androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r4 = r16.getSetMeasurePolicy()
                                    androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r14, r3, r4)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
                                    androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r14, r9, r4)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
                                    r16 = 0
                                    r17 = r14
                                    r18 = 0
                                    boolean r19 = r17.getInserting()
                                    if (r19 != 0) goto L_0x00c4
                                    java.lang.Object r2 = r17.rememberedValue()
                                    r19 = r3
                                    java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
                                    boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
                                    if (r2 != 0) goto L_0x00c1
                                    goto L_0x00c6
                                L_0x00c1:
                                    r3 = r17
                                    goto L_0x00d6
                                L_0x00c4:
                                    r19 = r3
                                L_0x00c6:
                                    java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
                                    r3 = r17
                                    r3.updateRememberedValue(r2)
                                    java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
                                    r14.apply(r2, r4)
                                L_0x00d6:
                                    androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r21)
                                    androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r2)
                                    int r3 = r12 >> 3
                                    r3 = r3 & 112(0x70, float:1.57E-43)
                                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                                    r11.invoke(r2, r1, r3)
                                    r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                                    r1.startReplaceableGroup(r2)
                                    int r2 = r12 >> 9
                                    r2 = r2 & 14
                                    r3 = r21
                                    r4 = 0
                                    r14 = 1017245968(0x3ca1f110, float:0.019768268)
                                    java.lang.String r15 = "C:CoreTextField.kt#423gt5"
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r14, r15)
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
                                    r21.endReplaceableGroup()
                                    r21.endNode()
                                    r21.endReplaceableGroup()
                                    androidx.compose.foundation.text.selection.TextFieldSelectionManager r2 = r2
                                    androidx.compose.foundation.text.TextFieldState r3 = r3
                                    androidx.compose.foundation.text.HandleState r3 = r3.getHandleState()
                                    androidx.compose.foundation.text.HandleState r4 = androidx.compose.foundation.text.HandleState.Selection
                                    if (r3 != r4) goto L_0x013b
                                    androidx.compose.foundation.text.TextFieldState r3 = r3
                                    androidx.compose.ui.layout.LayoutCoordinates r3 = r3.getLayoutCoordinates()
                                    if (r3 == 0) goto L_0x013b
                                    androidx.compose.foundation.text.TextFieldState r3 = r3
                                    androidx.compose.ui.layout.LayoutCoordinates r3 = r3.getLayoutCoordinates()
                                    kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
                                    boolean r3 = r3.isAttached()
                                    if (r3 == 0) goto L_0x013b
                                    boolean r3 = r4
                                    if (r3 == 0) goto L_0x013b
                                    r4 = 1
                                    goto L_0x013c
                                L_0x013b:
                                    r4 = 0
                                L_0x013c:
                                    r3 = 8
                                    androidx.compose.foundation.text.CoreTextFieldKt.SelectionToolbarAndHandles(r2, r4, r1, r3)
                                    androidx.compose.foundation.text.TextFieldState r2 = r3
                                    androidx.compose.foundation.text.HandleState r2 = r2.getHandleState()
                                    androidx.compose.foundation.text.HandleState r4 = androidx.compose.foundation.text.HandleState.Cursor
                                    if (r2 != r4) goto L_0x0159
                                    boolean r2 = r5
                                    if (r2 != 0) goto L_0x0159
                                    boolean r2 = r4
                                    if (r2 == 0) goto L_0x0159
                                    androidx.compose.foundation.text.selection.TextFieldSelectionManager r2 = r2
                                    androidx.compose.foundation.text.CoreTextFieldKt.TextFieldCursorHandle(r2, r1, r3)
                                L_0x0159:
                                    boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r2 == 0) goto L_0x0162
                                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                                L_0x0162:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.AnonymousClass1.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                            }
                        }), $composer, 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            };
            function32.invoke(ComposableLambdaKt.composableLambda(composer, 2032502107, true, r3), composer, Integer.valueOf(((this.$$dirty1 >> 12) & 112) | 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}

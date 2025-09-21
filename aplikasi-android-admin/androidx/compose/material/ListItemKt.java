package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0001\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u0013\u001a:\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0013\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\tH\u0002¢\u0006\u0002\u0010\u001d\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"BaselinesOffsetColumn", "", "offsets", "", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ListItem", "icon", "secondaryText", "singleLineSecondaryText", "", "overlineText", "trailing", "text", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OffsetToBaselineOrCenter", "offset", "OffsetToBaselineOrCenter-Kz89ssw", "(FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "applyTextStyle", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "(Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
public final class ListItemKt {
    public static final void ListItem(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> secondaryText, boolean singleLineSecondaryText, Function2<? super Composer, ? super Integer, Unit> overlineText, Function2<? super Composer, ? super Integer, Unit> trailing, Function2<? super Composer, ? super Integer, Unit> text, Composer $composer, int $changed, int i) {
        Function2 function2;
        Function2 secondaryText2;
        boolean z;
        Function2 overlineText2;
        Function2 secondaryText3;
        boolean singleLineSecondaryText2;
        Function2 icon2;
        Function2 trailing2;
        Modifier modifier2;
        Modifier modifier3;
        Function2 trailing3;
        Function2 overlineText3;
        Function2 trailing4;
        Function2<? super Composer, ? super Integer, Unit> function22 = text;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function22, "text");
        Composer $composer2 = $composer.startRestartGroup(-450923337);
        ComposerKt.sourceInformation($composer2, "C(ListItem)P(1!1,3,4!1,6)81@3397L10,83@3480L4,84@3570L6,85@3671L4,86@3764L4:ListItem.kt#jmzs0o");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            Modifier modifier4 = modifier;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 4 : 2;
        } else {
            Modifier modifier5 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            function2 = icon;
        } else if ((i2 & 112) == 0) {
            function2 = icon;
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        } else {
            function2 = icon;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            secondaryText2 = secondaryText;
        } else if ((i2 & 896) == 0) {
            secondaryText2 = secondaryText;
            $dirty |= $composer2.changedInstance(secondaryText2) ? 256 : 128;
        } else {
            secondaryText2 = secondaryText;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            z = singleLineSecondaryText;
        } else if ((i2 & 7168) == 0) {
            z = singleLineSecondaryText;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = singleLineSecondaryText;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            overlineText2 = overlineText;
        } else if ((57344 & i2) == 0) {
            overlineText2 = overlineText;
            $dirty |= $composer2.changedInstance(overlineText2) ? 16384 : 8192;
        } else {
            overlineText2 = overlineText;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            Function2<? super Composer, ? super Integer, Unit> function23 = trailing;
        } else if ((i2 & 458752) == 0) {
            $dirty |= $composer2.changedInstance(trailing) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = trailing;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if ((i2 & 3670016) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 1048576 : 524288;
        }
        if (($dirty & 2995931) != 599186 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i4 != 0) {
                icon2 = null;
            } else {
                icon2 = function2;
            }
            if (i5 != 0) {
                secondaryText2 = null;
            }
            if (i6 != 0) {
                singleLineSecondaryText2 = true;
            } else {
                singleLineSecondaryText2 = z;
            }
            if (i7 != 0) {
                overlineText2 = null;
            }
            if (i8 != 0) {
                trailing3 = null;
            } else {
                trailing3 = trailing;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-450923337, $dirty, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
            }
            Typography typography = MaterialTheme.INSTANCE.getTypography($composer2, 6);
            Function2 trailing5 = applyTextStyle(typography.getSubtitle1(), ContentAlpha.INSTANCE.getHigh($composer2, 6), function22);
            Intrinsics.checkNotNull(trailing5);
            Function2 styledSecondaryText = applyTextStyle(typography.getBody2(), ContentAlpha.INSTANCE.getMedium($composer2, 6), secondaryText2);
            Function2 styledOverlineText = applyTextStyle(typography.getOverline(), ContentAlpha.INSTANCE.getHigh($composer2, 6), overlineText2);
            Function2<Composer, Integer, Unit> applyTextStyle = applyTextStyle(typography.getCaption(), ContentAlpha.INSTANCE.getHigh($composer2, 6), trailing3);
            Modifier semanticsModifier = SemanticsModifierKt.semantics(modifier3, true, ListItemKt$ListItem$semanticsModifier$1.INSTANCE);
            if (styledSecondaryText == null && styledOverlineText == null) {
                $composer2.startReplaceableGroup(-210280579);
                ComposerKt.sourceInformation($composer2, "91@3942L61");
                int i9 = $dirty;
                secondaryText3 = secondaryText2;
                OneLine.INSTANCE.ListItem(semanticsModifier, icon2, trailing5, applyTextStyle, $composer2, ($dirty & 112) | 24576, 0);
                $composer2.endReplaceableGroup();
                overlineText3 = overlineText2;
                trailing4 = trailing3;
            } else {
                int $dirty2 = $dirty;
                secondaryText3 = secondaryText2;
                if ((styledOverlineText != null || !singleLineSecondaryText2) && styledSecondaryText != null) {
                    overlineText3 = overlineText2;
                    trailing4 = trailing3;
                    $composer2.startReplaceableGroup(-210280168);
                    ComposerKt.sourceInformation($composer2, "104@4355L184");
                    ThreeLine.INSTANCE.ListItem(semanticsModifier, icon2, trailing5, styledSecondaryText, styledOverlineText, applyTextStyle, $composer2, ($dirty2 & 112) | 1572864, 0);
                    $composer2.endReplaceableGroup();
                } else {
                    $composer2.startReplaceableGroup(-210280382);
                    ComposerKt.sourceInformation($composer2, "95@4139L184");
                    overlineText3 = overlineText2;
                    trailing4 = trailing3;
                    TwoLine.INSTANCE.ListItem(semanticsModifier, icon2, trailing5, styledSecondaryText, styledOverlineText, applyTextStyle, $composer2, ($dirty2 & 112) | 1572864, 0);
                    $composer2.endReplaceableGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            trailing2 = trailing4;
            overlineText2 = overlineText3;
        } else {
            $composer2.skipToGroupEnd();
            trailing2 = trailing;
            int i10 = $dirty;
            icon2 = function2;
            secondaryText3 = secondaryText2;
            singleLineSecondaryText2 = z;
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new ListItemKt$ListItem$1(modifier2, icon2, secondaryText3, singleLineSecondaryText2, overlineText2, trailing2, text, $changed, i));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BaselinesOffsetColumn(java.util.List<androidx.compose.ui.unit.Dp> r19, androidx.compose.ui.Modifier r20, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r0 = 1631148337(0x61395931, float:2.1369216E20)
            r1 = r22
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BaselinesOffsetColumn)P(2,1)352@13107L1127:ListItem.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r23
            r3 = r24 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r9 = r3
            goto L_0x001c
        L_0x001a:
            r9 = r20
        L_0x001c:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0028
            r3 = -1
            java.lang.String r4 = "androidx.compose.material.BaselinesOffsetColumn (ListItem.kt:347)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r4)
        L_0x0028:
            androidx.compose.material.ListItemKt$BaselinesOffsetColumn$1 r0 = new androidx.compose.material.ListItemKt$BaselinesOffsetColumn$1
            r10 = r19
            r0.<init>(r10)
            androidx.compose.ui.layout.MeasurePolicy r0 = (androidx.compose.ui.layout.MeasurePolicy) r0
            int r3 = r2 >> 6
            r3 = r3 & 14
            r4 = r2 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r4 = 0
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            r5 = 0
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r5)
            androidx.compose.runtime.CompositionLocalMap r6 = r1.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r9)
            int r11 = r3 << 9
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | 6
            r12 = 0
            androidx.compose.runtime.Applier r13 = r1.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x006a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x006a:
            r1.startReusableNode()
            boolean r13 = r1.getInserting()
            if (r13 == 0) goto L_0x0077
            r1.createNode(r7)
            goto L_0x007a
        L_0x0077:
            r1.useNode()
        L_0x007a:
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m4575constructorimpl(r1)
            r14 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r13, r0, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r13, r6, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetCompositeKeyHash()
            r16 = 0
            r20 = r13
            r17 = 0
            boolean r18 = r20.getInserting()
            if (r18 != 0) goto L_0x00b9
            r22 = r0
            java.lang.Object r0 = r20.rememberedValue()
            r18 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 != 0) goto L_0x00b6
            goto L_0x00bd
        L_0x00b6:
            r2 = r20
            goto L_0x00cd
        L_0x00b9:
            r22 = r0
            r18 = r2
        L_0x00bd:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r2 = r20
            r2.updateRememberedValue(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r13.apply(r0, r15)
        L_0x00cd:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r1)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r0)
            int r2 = r11 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r8.invoke(r0, r1, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r0)
            int r0 = r11 >> 9
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2 = r21
            r2.invoke(r1, r0)
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x010c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x010c:
            androidx.compose.runtime.ScopeUpdateScope r0 = r1.endRestartGroup()
            if (r0 != 0) goto L_0x0113
            goto L_0x0127
        L_0x0113:
            androidx.compose.material.ListItemKt$BaselinesOffsetColumn$2 r11 = new androidx.compose.material.ListItemKt$BaselinesOffsetColumn$2
            r3 = r11
            r4 = r19
            r5 = r9
            r6 = r21
            r7 = r23
            r8 = r24
            r3.<init>(r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r0.updateScope(r11)
        L_0x0127:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ListItemKt.BaselinesOffsetColumn(java.util.List, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0168  */
    /* renamed from: OffsetToBaselineOrCenter-Kz89ssw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m3040OffsetToBaselineOrCenterKz89ssw(float r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r6 = r21
            r7 = r23
            r8 = r25
            r0 = -1062692685(0xffffffffc0a898b3, float:-5.26864)
            r1 = r24
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(OffsetToBaselineOrCenter)P(2:c#ui.unit.Dp,1)394@14762L806:ListItem.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r25
            r2 = r26 & 1
            if (r2 == 0) goto L_0x001d
            r1 = r1 | 6
            goto L_0x002b
        L_0x001d:
            r2 = r8 & 14
            if (r2 != 0) goto L_0x002b
            boolean r2 = r9.changed((float) r6)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r1 = r1 | r2
        L_0x002b:
            r2 = r26 & 2
            if (r2 == 0) goto L_0x0034
            r1 = r1 | 48
            r3 = r22
            goto L_0x0049
        L_0x0034:
            r3 = r8 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0047
            r3 = r22
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0043
            r4 = 32
            goto L_0x0045
        L_0x0043:
            r4 = 16
        L_0x0045:
            r1 = r1 | r4
            goto L_0x0049
        L_0x0047:
            r3 = r22
        L_0x0049:
            r4 = r26 & 4
            if (r4 == 0) goto L_0x0050
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x0050:
            r4 = r8 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0060
            boolean r4 = r9.changedInstance(r7)
            if (r4 == 0) goto L_0x005d
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r1 = r1 | r4
        L_0x0060:
            r10 = r1
            r1 = r10 & 731(0x2db, float:1.024E-42)
            r4 = 146(0x92, float:2.05E-43)
            if (r1 != r4) goto L_0x0074
            boolean r1 = r9.getSkipping()
            if (r1 != 0) goto L_0x006e
            goto L_0x0074
        L_0x006e:
            r9.skipToGroupEnd()
            r11 = r3
            goto L_0x016d
        L_0x0074:
            if (r2 == 0) goto L_0x007b
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x007c
        L_0x007b:
            r1 = r3
        L_0x007c:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0088
            r2 = -1
            java.lang.String r3 = "androidx.compose.material.OffsetToBaselineOrCenter (ListItem.kt:389)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r2, r3)
        L_0x0088:
            androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$1 r0 = new androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$1
            r0.<init>(r6)
            androidx.compose.ui.layout.MeasurePolicy r0 = (androidx.compose.ui.layout.MeasurePolicy) r0
            int r2 = r10 >> 6
            r2 = r2 & 14
            r3 = r10 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = 0
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r4)
            r4 = 0
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r4)
            androidx.compose.runtime.CompositionLocalMap r5 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r12 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r1)
            int r13 = r2 << 9
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r13 = r13 | 6
            r14 = 0
            androidx.compose.runtime.Applier r15 = r9.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x00c8
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00c8:
            r9.startReusableNode()
            boolean r15 = r9.getInserting()
            if (r15 == 0) goto L_0x00d5
            r9.createNode(r11)
            goto L_0x00d8
        L_0x00d5:
            r9.useNode()
        L_0x00d8:
            androidx.compose.runtime.Composer r15 = androidx.compose.runtime.Updater.m4575constructorimpl(r9)
            r16 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            r22 = r1
            kotlin.jvm.functions.Function2 r1 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r15, r0, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r15, r5, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            r17 = 0
            r24 = r15
            r18 = 0
            boolean r19 = r24.getInserting()
            if (r19 != 0) goto L_0x011a
            r19 = r0
            java.lang.Object r0 = r24.rememberedValue()
            r20 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 != 0) goto L_0x0117
            goto L_0x011e
        L_0x0117:
            r2 = r24
            goto L_0x012e
        L_0x011a:
            r19 = r0
            r20 = r2
        L_0x011e:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            r2 = r24
            r2.updateRememberedValue(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            r15.apply(r0, r1)
        L_0x012e:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r0)
            int r1 = r13 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r12.invoke(r0, r9, r1)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r0)
            int r0 = r13 >> 9
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.invoke(r9, r0)
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x016b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x016b:
            r11 = r22
        L_0x016d:
            androidx.compose.runtime.ScopeUpdateScope r12 = r9.endRestartGroup()
            if (r12 != 0) goto L_0x0174
            goto L_0x0188
        L_0x0174:
            androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$2 r13 = new androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$2
            r0 = r13
            r1 = r21
            r2 = r11
            r3 = r23
            r4 = r25
            r5 = r26
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0188:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ListItemKt.m3040OffsetToBaselineOrCenterKz89ssw(float, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function2<Composer, Integer, Unit> applyTextStyle(TextStyle textStyle, float contentAlpha, Function2<? super Composer, ? super Integer, Unit> icon) {
        if (icon == null) {
            return null;
        }
        return ComposableLambdaKt.composableLambdaInstance(-830176860, true, new ListItemKt$applyTextStyle$1(contentAlpha, textStyle, icon));
    }
}

package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.unit.IntRect;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BC\u0012&\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\u0010\u000bJ\u0012\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\tH\u0002J$\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00152\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000000J\u0010\u00101\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u0005H\u0002J\u0012\u00102\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u00020\u0015H\u0002J\b\u00104\u001a\u00020\u0005H\u0002J\u0010\u00105\u001a\u0002062\u0006\u0010-\u001a\u00020\u0005H\u0002R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R.\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010\t8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050(X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Landroidx/compose/ui/tooling/data/CompositionCallStack;", "T", "Landroidx/compose/ui/tooling/data/SourceContext;", "factory", "Lkotlin/Function3;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", "contexts", "", "", "", "(Lkotlin/jvm/functions/Function3;Ljava/util/Map;)V", "<set-?>", "Landroidx/compose/ui/unit/IntRect;", "bounds", "getBounds", "()Landroidx/compose/ui/unit/IntRect;", "current", "getCurrent", "()Landroidx/compose/runtime/tooling/CompositionGroup;", "currentCallIndex", "", "depth", "getDepth", "()I", "isInline", "", "()Z", "location", "Landroidx/compose/ui/tooling/data/SourceLocation;", "getLocation", "()Landroidx/compose/ui/tooling/data/SourceLocation;", "name", "getName", "()Ljava/lang/String;", "parameters", "Landroidx/compose/ui/tooling/data/ParameterInformation;", "getParameters", "()Ljava/util/List;", "stack", "Lkotlin/collections/ArrayDeque;", "contextOf", "Landroidx/compose/ui/tooling/data/SourceInformationContext;", "information", "convert", "group", "callIndex", "out", "", "isCall", "parentGroup", "parentDepth", "pop", "push", "", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTree.kt */
final class CompositionCallStack<T> implements SourceContext {
    private IntRect bounds = SlotTreeKt.getEmptyBox();
    private final Map<String, Object> contexts;
    private int currentCallIndex;
    private final Function3<CompositionGroup, SourceContext, List<? extends T>, T> factory;
    private final ArrayDeque<CompositionGroup> stack = new ArrayDeque<>();

    public CompositionCallStack(Function3<? super CompositionGroup, ? super SourceContext, ? super List<? extends T>, ? extends T> factory2, Map<String, Object> contexts2) {
        Intrinsics.checkNotNullParameter(factory2, "factory");
        Intrinsics.checkNotNullParameter(contexts2, "contexts");
        this.factory = factory2;
        this.contexts = contexts2;
    }

    public final IntRect convert(CompositionGroup group, int callIndex, List<T> out) {
        IntRect intRect;
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(out, "out");
        List children = new ArrayList();
        IntRect emptyBox = SlotTreeKt.getEmptyBox();
        push(group);
        int childCallIndex = 0;
        for (CompositionGroup child : group.getCompositionGroups()) {
            emptyBox = SlotTreeKt.union(emptyBox, convert(child, childCallIndex, children));
            if (isCall(child)) {
                childCallIndex++;
            }
        }
        Object node = group.getNode();
        LayoutInfo it = node instanceof LayoutInfo ? (LayoutInfo) node : null;
        if (it == null || (intRect = SlotTreeKt.boundsOfLayoutNode(it)) == null) {
            intRect = emptyBox;
        }
        IntRect intRect2 = intRect;
        this.currentCallIndex = callIndex;
        this.bounds = intRect2;
        Object it2 = this.factory.invoke(group, this, children);
        if (it2 != null) {
            out.add(it2);
        }
        pop();
        return intRect2;
    }

    public String getName() {
        int startIndex;
        String info = getCurrent().getSourceInfo();
        if (info == null) {
            return null;
        }
        if (StringsKt.startsWith$default(info, "CC(", false, 2, (Object) null)) {
            startIndex = 3;
        } else if (!StringsKt.startsWith$default(info, "C(", false, 2, (Object) null)) {
            return null;
        } else {
            startIndex = 2;
        }
        int endIndex = StringsKt.indexOf$default((CharSequence) info, ')', 0, false, 6, (Object) null);
        if (endIndex <= 2) {
            return null;
        }
        String substring = info.substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public boolean isInline() {
        String sourceInfo = getCurrent().getSourceInfo();
        return sourceInfo != null && StringsKt.startsWith$default(sourceInfo, "CC", false, 2, (Object) null);
    }

    public IntRect getBounds() {
        return this.bounds;
    }

    public SourceLocation getLocation() {
        String it;
        SourceInformationContext context;
        String it2;
        CompositionGroup parentGroup = parentGroup(1);
        if (parentGroup == null || (it = parentGroup.getSourceInfo()) == null || (context = contextOf(it)) == null) {
            return null;
        }
        SourceInformationContext parentContext = context;
        int index = 2;
        while (index < this.stack.size()) {
            if ((parentContext != null ? parentContext.getSourceFile() : null) != null) {
                break;
            }
            int index2 = index + 1;
            CompositionGroup parentGroup2 = parentGroup(index);
            parentContext = (parentGroup2 == null || (it2 = parentGroup2.getSourceInfo()) == null) ? null : contextOf(it2);
            index = index2;
        }
        return context.sourceLocation(this.currentCallIndex, parentContext);
    }

    public List<ParameterInformation> getParameters() {
        SourceInformationContext context;
        CompositionGroup group = getCurrent();
        String it = group.getSourceInfo();
        if (it == null || (context = contextOf(it)) == null) {
            return CollectionsKt.emptyList();
        }
        List data = new ArrayList();
        CollectionsKt.addAll(data, group.getData());
        return SlotTreeKt.extractParameterInfo(data, context);
    }

    public int getDepth() {
        return this.stack.size();
    }

    private final void push(CompositionGroup group) {
        this.stack.addLast(group);
    }

    private final CompositionGroup pop() {
        return this.stack.removeLast();
    }

    private final CompositionGroup getCurrent() {
        return this.stack.last();
    }

    private final CompositionGroup parentGroup(int parentDepth) {
        if (this.stack.size() <= parentDepth) {
            return null;
        }
        ArrayDeque<CompositionGroup> arrayDeque = this.stack;
        return arrayDeque.get((arrayDeque.size() - parentDepth) - 1);
    }

    private final SourceInformationContext contextOf(String information) {
        Object answer$iv;
        Map $this$getOrPut$iv = this.contexts;
        Object value$iv = $this$getOrPut$iv.get(information);
        if (value$iv == null) {
            answer$iv = SlotTreeKt.sourceInformationContextOf$default(information, (SourceInformationContext) null, 2, (Object) null);
            $this$getOrPut$iv.put(information, answer$iv);
        } else {
            answer$iv = value$iv;
        }
        if (answer$iv instanceof SourceInformationContext) {
            return (SourceInformationContext) answer$iv;
        }
        return null;
    }

    private final boolean isCall(CompositionGroup group) {
        String sourceInfo = group.getSourceInfo();
        if (sourceInfo != null) {
            return StringsKt.startsWith$default(sourceInfo, "C", false, 2, (Object) null);
        }
        return false;
    }
}

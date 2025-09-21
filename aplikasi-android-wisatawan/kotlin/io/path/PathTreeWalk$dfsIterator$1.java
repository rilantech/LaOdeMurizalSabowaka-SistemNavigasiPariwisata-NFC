package kotlin.io.path;

import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {184, 190, 199, 205}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader", "$this$iterator", "stack", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
/* compiled from: PathTreeWalk.kt */
final class PathTreeWalk$dfsIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ PathTreeWalk this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PathTreeWalk$dfsIterator$1(PathTreeWalk pathTreeWalk, Continuation<? super PathTreeWalk$dfsIterator$1> continuation) {
        super(2, continuation);
        this.this$0 = pathTreeWalk;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PathTreeWalk$dfsIterator$1 pathTreeWalk$dfsIterator$1 = new PathTreeWalk$dfsIterator$1(this.this$0, continuation);
        pathTreeWalk$dfsIterator$1.L$0 = obj;
        return pathTreeWalk$dfsIterator$1;
    }

    public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
        return ((PathTreeWalk$dfsIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x010d, code lost:
        r13 = r7;
        r7 = r10;
        r10 = r8;
        r8 = r11;
        r16 = r12;
        r12 = r6;
        r6 = r9;
        r9 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0117, code lost:
        r11 = r10.getLinkOptions();
        r10 = (java.nio.file.LinkOption[]) java.util.Arrays.copyOf(r11, r11.length);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x012d, code lost:
        if (java.nio.file.Files.isDirectory(r13, (java.nio.file.LinkOption[]) java.util.Arrays.copyOf(r10, r10.length)) == false) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x012f, code lost:
        r6.setContentIterator(r7.readEntries(r6).iterator());
        r8.addLast(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0179, code lost:
        if ((!r8.isEmpty()) == false) goto L_0x0256;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x017b, code lost:
        r10 = ((kotlin.io.path.PathNode) r8.last()).getContentIterator();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        r6 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x018d, code lost:
        if (r6.hasNext() == false) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x018f, code lost:
        r6 = r6.next();
        r10 = r1.this$0;
        r11 = r9;
        r13 = r6.getPath();
        r14 = r10.getLinkOptions();
        r14 = (java.nio.file.LinkOption[]) java.util.Arrays.copyOf(r14, r14.length);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x01b4, code lost:
        if (java.nio.file.Files.isDirectory(r13, (java.nio.file.LinkOption[]) java.util.Arrays.copyOf(r14, r14.length)) == false) goto L_0x0223;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01ba, code lost:
        if (kotlin.io.path.PathTreeWalkKt.createsCycle(r6) != false) goto L_0x0219;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01c0, code lost:
        if (r10.getIncludeDirectories() == false) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01c2, code lost:
        r1.L$0 = r9;
        r1.L$1 = r8;
        r1.L$2 = r7;
        r1.L$3 = r6;
        r1.L$4 = r10;
        r1.L$5 = r13;
        r1.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01d8, code lost:
        if (r11.yield(r13, r1) != r0) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01da, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01db, code lost:
        r11 = r8;
        r8 = r10;
        r10 = r7;
        r7 = r13;
        r16 = r9;
        r9 = r6;
        r6 = false;
        r12 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01e5, code lost:
        r13 = r7;
        r7 = r10;
        r10 = r8;
        r8 = r11;
        r16 = r12;
        r12 = r6;
        r6 = r9;
        r9 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01ef, code lost:
        r11 = r10.getLinkOptions();
        r10 = (java.nio.file.LinkOption[]) java.util.Arrays.copyOf(r11, r11.length);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0205, code lost:
        if (java.nio.file.Files.isDirectory(r13, (java.nio.file.LinkOption[]) java.util.Arrays.copyOf(r10, r10.length)) == false) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0207, code lost:
        r6.setContentIterator(r7.readEntries(r6).iterator());
        r8.addLast(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0222, code lost:
        throw new java.nio.file.FileSystemLoopException(r13.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0233, code lost:
        if (java.nio.file.Files.exists(r13, (java.nio.file.LinkOption[]) java.util.Arrays.copyOf(new java.nio.file.LinkOption[]{java.nio.file.LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0235, code lost:
        r1.L$0 = r9;
        r1.L$1 = r8;
        r1.L$2 = r7;
        r1.L$3 = null;
        r1.L$4 = null;
        r1.L$5 = null;
        r1.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x024b, code lost:
        if (r11.yield(r13, r1) != r0) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x024d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0251, code lost:
        r8.removeLast();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0258, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r17
            int r2 = r1.label
            r3 = 0
            r4 = 0
            r5 = 1
            switch(r2) {
                case 0: goto L_0x0086;
                case 1: goto L_0x0064;
                case 2: goto L_0x004e;
                case 3: goto L_0x002c;
                case 4: goto L_0x0016;
                default: goto L_0x000e;
            }
        L_0x000e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0016:
            r1 = r17
            r2 = r18
            r6 = 0
            java.lang.Object r7 = r1.L$2
            kotlin.io.path.DirectoryEntriesReader r7 = (kotlin.io.path.DirectoryEntriesReader) r7
            java.lang.Object r8 = r1.L$1
            kotlin.collections.ArrayDeque r8 = (kotlin.collections.ArrayDeque) r8
            java.lang.Object r9 = r1.L$0
            kotlin.sequences.SequenceScope r9 = (kotlin.sequences.SequenceScope) r9
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x024f
        L_0x002c:
            r1 = r17
            r2 = r18
            r6 = 0
            java.lang.Object r7 = r1.L$5
            java.nio.file.Path r7 = (java.nio.file.Path) r7
            java.lang.Object r8 = r1.L$4
            kotlin.io.path.PathTreeWalk r8 = (kotlin.io.path.PathTreeWalk) r8
            java.lang.Object r9 = r1.L$3
            kotlin.io.path.PathNode r9 = (kotlin.io.path.PathNode) r9
            java.lang.Object r10 = r1.L$2
            kotlin.io.path.DirectoryEntriesReader r10 = (kotlin.io.path.DirectoryEntriesReader) r10
            java.lang.Object r11 = r1.L$1
            kotlin.collections.ArrayDeque r11 = (kotlin.collections.ArrayDeque) r11
            java.lang.Object r12 = r1.L$0
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x01e5
        L_0x004e:
            r1 = r17
            r2 = r18
            r6 = 0
            java.lang.Object r7 = r1.L$2
            kotlin.io.path.DirectoryEntriesReader r7 = (kotlin.io.path.DirectoryEntriesReader) r7
            java.lang.Object r8 = r1.L$1
            kotlin.collections.ArrayDeque r8 = (kotlin.collections.ArrayDeque) r8
            java.lang.Object r9 = r1.L$0
            kotlin.sequences.SequenceScope r9 = (kotlin.sequences.SequenceScope) r9
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0170
        L_0x0064:
            r1 = r17
            r2 = r18
            r6 = 0
            java.lang.Object r7 = r1.L$5
            java.nio.file.Path r7 = (java.nio.file.Path) r7
            java.lang.Object r8 = r1.L$4
            kotlin.io.path.PathTreeWalk r8 = (kotlin.io.path.PathTreeWalk) r8
            java.lang.Object r9 = r1.L$3
            kotlin.io.path.PathNode r9 = (kotlin.io.path.PathNode) r9
            java.lang.Object r10 = r1.L$2
            kotlin.io.path.DirectoryEntriesReader r10 = (kotlin.io.path.DirectoryEntriesReader) r10
            java.lang.Object r11 = r1.L$1
            kotlin.collections.ArrayDeque r11 = (kotlin.collections.ArrayDeque) r11
            java.lang.Object r12 = r1.L$0
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x010d
        L_0x0086:
            kotlin.ResultKt.throwOnFailure(r18)
            r1 = r17
            r2 = r18
            java.lang.Object r6 = r1.L$0
            r9 = r6
            kotlin.sequences.SequenceScope r9 = (kotlin.sequences.SequenceScope) r9
            kotlin.collections.ArrayDeque r6 = new kotlin.collections.ArrayDeque
            r6.<init>()
            r8 = r6
            kotlin.io.path.DirectoryEntriesReader r6 = new kotlin.io.path.DirectoryEntriesReader
            kotlin.io.path.PathTreeWalk r7 = r1.this$0
            boolean r7 = r7.getFollowLinks()
            r6.<init>(r7)
            r7 = r6
            kotlin.io.path.PathNode r6 = new kotlin.io.path.PathNode
            kotlin.io.path.PathTreeWalk r10 = r1.this$0
            java.nio.file.Path r10 = r10.start
            kotlin.io.path.PathTreeWalk r11 = r1.this$0
            java.nio.file.Path r11 = r11.start
            kotlin.io.path.PathTreeWalk r12 = r1.this$0
            java.nio.file.LinkOption[] r12 = r12.getLinkOptions()
            java.lang.Object r11 = kotlin.io.path.PathTreeWalkKt.keyOf(r11, r12)
            r6.<init>(r10, r11, r4)
            kotlin.io.path.PathTreeWalk r10 = r1.this$0
            r11 = r9
            r12 = 0
            java.nio.file.Path r13 = r6.getPath()
            java.nio.file.LinkOption[] r14 = r10.getLinkOptions()
            int r15 = r14.length
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r15)
            java.nio.file.LinkOption[] r14 = (java.nio.file.LinkOption[]) r14
            int r15 = r14.length
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r15)
            java.nio.file.LinkOption[] r14 = (java.nio.file.LinkOption[]) r14
            boolean r14 = java.nio.file.Files.isDirectory(r13, r14)
            if (r14 == 0) goto L_0x014a
            boolean r14 = kotlin.io.path.PathTreeWalkKt.createsCycle(r6)
            if (r14 != 0) goto L_0x0140
            boolean r14 = r10.getIncludeDirectories()
            if (r14 == 0) goto L_0x0117
            r14 = r1
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
            r1.L$0 = r9
            r1.L$1 = r8
            r1.L$2 = r7
            r1.L$3 = r6
            r1.L$4 = r10
            r1.L$5 = r13
            r1.label = r5
            java.lang.Object r11 = r11.yield(r13, r14)
            if (r11 != r0) goto L_0x0103
            return r0
        L_0x0103:
            r11 = r8
            r8 = r10
            r10 = r7
            r7 = r13
            r16 = r9
            r9 = r6
            r6 = r12
            r12 = r16
        L_0x010d:
            r13 = r7
            r7 = r10
            r10 = r8
            r8 = r11
            r16 = r12
            r12 = r6
            r6 = r9
            r9 = r16
        L_0x0117:
            java.nio.file.LinkOption[] r11 = r10.getLinkOptions()
            int r10 = r11.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r11, r10)
            java.nio.file.LinkOption[] r10 = (java.nio.file.LinkOption[]) r10
            int r11 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r11)
            java.nio.file.LinkOption[] r10 = (java.nio.file.LinkOption[]) r10
            boolean r10 = java.nio.file.Files.isDirectory(r13, r10)
            if (r10 == 0) goto L_0x0171
            java.util.List r10 = r7.readEntries(r6)
            r11 = 0
            java.util.Iterator r13 = r10.iterator()
            r6.setContentIterator(r13)
            r8.addLast(r6)
            goto L_0x0171
        L_0x0140:
            java.nio.file.FileSystemLoopException r0 = new java.nio.file.FileSystemLoopException
            java.lang.String r3 = r13.toString()
            r0.<init>(r3)
            throw r0
        L_0x014a:
            java.nio.file.LinkOption[] r6 = new java.nio.file.LinkOption[r5]
            java.nio.file.LinkOption r10 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r6[r3] = r10
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r5)
            java.nio.file.LinkOption[] r6 = (java.nio.file.LinkOption[]) r6
            boolean r6 = java.nio.file.Files.exists(r13, r6)
            if (r6 == 0) goto L_0x0171
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r1.L$0 = r9
            r1.L$1 = r8
            r1.L$2 = r7
            r10 = 2
            r1.label = r10
            java.lang.Object r6 = r11.yield(r13, r6)
            if (r6 != r0) goto L_0x016f
            return r0
        L_0x016f:
            r6 = r12
        L_0x0170:
        L_0x0171:
            r6 = r8
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r5
            if (r6 == 0) goto L_0x0256
            java.lang.Object r6 = r8.last()
            kotlin.io.path.PathNode r6 = (kotlin.io.path.PathNode) r6
            java.util.Iterator r10 = r6.getContentIterator()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r6 = r10
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L_0x0251
            java.lang.Object r10 = r6.next()
            r6 = r10
            kotlin.io.path.PathNode r6 = (kotlin.io.path.PathNode) r6
            kotlin.io.path.PathTreeWalk r10 = r1.this$0
            r11 = r9
            r12 = 0
            java.nio.file.Path r13 = r6.getPath()
            java.nio.file.LinkOption[] r14 = r10.getLinkOptions()
            int r15 = r14.length
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r15)
            java.nio.file.LinkOption[] r14 = (java.nio.file.LinkOption[]) r14
            int r15 = r14.length
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r15)
            java.nio.file.LinkOption[] r14 = (java.nio.file.LinkOption[]) r14
            boolean r14 = java.nio.file.Files.isDirectory(r13, r14)
            if (r14 == 0) goto L_0x0223
            boolean r14 = kotlin.io.path.PathTreeWalkKt.createsCycle(r6)
            if (r14 != 0) goto L_0x0219
            boolean r14 = r10.getIncludeDirectories()
            if (r14 == 0) goto L_0x01ef
            r14 = r1
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
            r1.L$0 = r9
            r1.L$1 = r8
            r1.L$2 = r7
            r1.L$3 = r6
            r1.L$4 = r10
            r1.L$5 = r13
            r15 = 3
            r1.label = r15
            java.lang.Object r11 = r11.yield(r13, r14)
            if (r11 != r0) goto L_0x01db
            return r0
        L_0x01db:
            r11 = r8
            r8 = r10
            r10 = r7
            r7 = r13
            r16 = r9
            r9 = r6
            r6 = r12
            r12 = r16
        L_0x01e5:
            r13 = r7
            r7 = r10
            r10 = r8
            r8 = r11
            r16 = r12
            r12 = r6
            r6 = r9
            r9 = r16
        L_0x01ef:
            java.nio.file.LinkOption[] r11 = r10.getLinkOptions()
            int r10 = r11.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r11, r10)
            java.nio.file.LinkOption[] r10 = (java.nio.file.LinkOption[]) r10
            int r11 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r11)
            java.nio.file.LinkOption[] r10 = (java.nio.file.LinkOption[]) r10
            boolean r10 = java.nio.file.Files.isDirectory(r13, r10)
            if (r10 == 0) goto L_0x0171
            java.util.List r10 = r7.readEntries(r6)
            r11 = 0
            java.util.Iterator r13 = r10.iterator()
            r6.setContentIterator(r13)
            r8.addLast(r6)
            goto L_0x0171
        L_0x0219:
            java.nio.file.FileSystemLoopException r0 = new java.nio.file.FileSystemLoopException
            java.lang.String r3 = r13.toString()
            r0.<init>(r3)
            throw r0
        L_0x0223:
            java.nio.file.LinkOption[] r6 = new java.nio.file.LinkOption[r5]
            java.nio.file.LinkOption r10 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r6[r3] = r10
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r5)
            java.nio.file.LinkOption[] r6 = (java.nio.file.LinkOption[]) r6
            boolean r6 = java.nio.file.Files.exists(r13, r6)
            if (r6 == 0) goto L_0x0171
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r1.L$0 = r9
            r1.L$1 = r8
            r1.L$2 = r7
            r1.L$3 = r4
            r1.L$4 = r4
            r1.L$5 = r4
            r10 = 4
            r1.label = r10
            java.lang.Object r6 = r11.yield(r13, r6)
            if (r6 != r0) goto L_0x024e
            return r0
        L_0x024e:
            r6 = r12
        L_0x024f:
            goto L_0x0171
        L_0x0251:
            r8.removeLast()
            goto L_0x0171
        L_0x0256:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$dfsIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

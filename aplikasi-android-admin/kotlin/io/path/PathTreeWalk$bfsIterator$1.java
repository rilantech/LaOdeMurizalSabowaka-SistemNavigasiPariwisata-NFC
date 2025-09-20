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
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {184, 190}, m = "invokeSuspend", n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "queue", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
/* compiled from: PathTreeWalk.kt */
final class PathTreeWalk$bfsIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ PathTreeWalk this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PathTreeWalk$bfsIterator$1(PathTreeWalk pathTreeWalk, Continuation<? super PathTreeWalk$bfsIterator$1> continuation) {
        super(2, continuation);
        this.this$0 = pathTreeWalk;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PathTreeWalk$bfsIterator$1 pathTreeWalk$bfsIterator$1 = new PathTreeWalk$bfsIterator$1(this.this$0, continuation);
        pathTreeWalk$bfsIterator$1.L$0 = obj;
        return pathTreeWalk$bfsIterator$1;
    }

    public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
        return ((PathTreeWalk$bfsIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x014d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0094  */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r16
            int r2 = r1.label
            r3 = 0
            switch(r2) {
                case 0: goto L_0x004c;
                case 1: goto L_0x002a;
                case 2: goto L_0x0014;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0014:
            r1 = r16
            r2 = r17
            r4 = 0
            java.lang.Object r5 = r1.L$2
            kotlin.io.path.DirectoryEntriesReader r5 = (kotlin.io.path.DirectoryEntriesReader) r5
            java.lang.Object r6 = r1.L$1
            kotlin.collections.ArrayDeque r6 = (kotlin.collections.ArrayDeque) r6
            java.lang.Object r7 = r1.L$0
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x014b
        L_0x002a:
            r1 = r16
            r2 = r17
            r4 = 0
            java.lang.Object r5 = r1.L$5
            java.nio.file.Path r5 = (java.nio.file.Path) r5
            java.lang.Object r6 = r1.L$4
            kotlin.io.path.PathTreeWalk r6 = (kotlin.io.path.PathTreeWalk) r6
            java.lang.Object r7 = r1.L$3
            kotlin.io.path.PathNode r7 = (kotlin.io.path.PathNode) r7
            java.lang.Object r8 = r1.L$2
            kotlin.io.path.DirectoryEntriesReader r8 = (kotlin.io.path.DirectoryEntriesReader) r8
            java.lang.Object r9 = r1.L$1
            kotlin.collections.ArrayDeque r9 = (kotlin.collections.ArrayDeque) r9
            java.lang.Object r10 = r1.L$0
            kotlin.sequences.SequenceScope r10 = (kotlin.sequences.SequenceScope) r10
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00e6
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r17)
            r1 = r16
            r2 = r17
            java.lang.Object r4 = r1.L$0
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.collections.ArrayDeque r5 = new kotlin.collections.ArrayDeque
            r5.<init>()
            kotlin.io.path.DirectoryEntriesReader r6 = new kotlin.io.path.DirectoryEntriesReader
            kotlin.io.path.PathTreeWalk r7 = r1.this$0
            boolean r7 = r7.getFollowLinks()
            r6.<init>(r7)
            kotlin.io.path.PathNode r7 = new kotlin.io.path.PathNode
            kotlin.io.path.PathTreeWalk r8 = r1.this$0
            java.nio.file.Path r8 = r8.start
            kotlin.io.path.PathTreeWalk r9 = r1.this$0
            java.nio.file.Path r9 = r9.start
            kotlin.io.path.PathTreeWalk r10 = r1.this$0
            java.nio.file.LinkOption[] r10 = r10.getLinkOptions()
            java.lang.Object r9 = kotlin.io.path.PathTreeWalkKt.keyOf(r9, r10)
            r7.<init>(r8, r9, r3)
            r5.addLast(r7)
            r7 = r4
            r15 = r6
            r6 = r5
            r5 = r15
        L_0x0089:
            r4 = r6
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r8 = 1
            r4 = r4 ^ r8
            if (r4 == 0) goto L_0x014d
            java.lang.Object r4 = r6.removeFirst()
            kotlin.io.path.PathNode r4 = (kotlin.io.path.PathNode) r4
            kotlin.io.path.PathTreeWalk r9 = r1.this$0
            r10 = r7
            r11 = 0
            java.nio.file.Path r12 = r4.getPath()
            java.nio.file.LinkOption[] r13 = r9.getLinkOptions()
            int r14 = r13.length
            java.lang.Object[] r13 = java.util.Arrays.copyOf(r13, r14)
            java.nio.file.LinkOption[] r13 = (java.nio.file.LinkOption[]) r13
            int r14 = r13.length
            java.lang.Object[] r13 = java.util.Arrays.copyOf(r13, r14)
            java.nio.file.LinkOption[] r13 = (java.nio.file.LinkOption[]) r13
            boolean r13 = java.nio.file.Files.isDirectory(r12, r13)
            if (r13 == 0) goto L_0x011e
            boolean r13 = kotlin.io.path.PathTreeWalkKt.createsCycle(r4)
            if (r13 != 0) goto L_0x0114
            boolean r13 = r9.getIncludeDirectories()
            if (r13 == 0) goto L_0x00ee
            r13 = r1
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r1.L$0 = r7
            r1.L$1 = r6
            r1.L$2 = r5
            r1.L$3 = r4
            r1.L$4 = r9
            r1.L$5 = r12
            r1.label = r8
            java.lang.Object r8 = r10.yield(r12, r13)
            if (r8 != r0) goto L_0x00de
            return r0
        L_0x00de:
            r8 = r5
            r10 = r7
            r5 = r12
            r7 = r4
            r4 = r11
            r15 = r9
            r9 = r6
            r6 = r15
        L_0x00e6:
            r11 = r4
            r12 = r5
            r4 = r7
            r5 = r8
            r7 = r10
            r15 = r9
            r9 = r6
            r6 = r15
        L_0x00ee:
            java.nio.file.LinkOption[] r8 = r9.getLinkOptions()
            int r9 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r9)
            java.nio.file.LinkOption[] r8 = (java.nio.file.LinkOption[]) r8
            int r9 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r9)
            java.nio.file.LinkOption[] r8 = (java.nio.file.LinkOption[]) r8
            boolean r8 = java.nio.file.Files.isDirectory(r12, r8)
            if (r8 == 0) goto L_0x0089
            java.util.List r4 = r5.readEntries(r4)
            r8 = 0
            r9 = r4
            java.util.Collection r9 = (java.util.Collection) r9
            r6.addAll(r9)
            goto L_0x0089
        L_0x0114:
            java.nio.file.FileSystemLoopException r0 = new java.nio.file.FileSystemLoopException
            java.lang.String r3 = r12.toString()
            r0.<init>(r3)
            throw r0
        L_0x011e:
            java.nio.file.LinkOption[] r4 = new java.nio.file.LinkOption[r8]
            java.nio.file.LinkOption r9 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r13 = 0
            r4[r13] = r9
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r8)
            java.nio.file.LinkOption[] r4 = (java.nio.file.LinkOption[]) r4
            boolean r4 = java.nio.file.Files.exists(r12, r4)
            if (r4 == 0) goto L_0x0089
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r1.L$0 = r7
            r1.L$1 = r6
            r1.L$2 = r5
            r1.L$3 = r3
            r1.L$4 = r3
            r1.L$5 = r3
            r8 = 2
            r1.label = r8
            java.lang.Object r4 = r10.yield(r12, r4)
            if (r4 != r0) goto L_0x014a
            return r0
        L_0x014a:
            r4 = r11
        L_0x014b:
            goto L_0x0089
        L_0x014d:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$bfsIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

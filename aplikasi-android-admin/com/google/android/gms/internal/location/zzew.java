package com.google.android.gms.internal.location;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
enum zzew implements Executor {
    INSTANCE;

    public final void execute(Runnable runnable) {
        runnable.run();
    }

    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}

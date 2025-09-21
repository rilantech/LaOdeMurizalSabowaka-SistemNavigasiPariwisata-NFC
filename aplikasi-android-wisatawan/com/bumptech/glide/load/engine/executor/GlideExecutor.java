package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public final class GlideExecutor implements ExecutorService {
    static final String DEFAULT_ANIMATION_EXECUTOR_NAME = "animation";
    static final String DEFAULT_DISK_CACHE_EXECUTOR_NAME = "disk-cache";
    static final int DEFAULT_DISK_CACHE_EXECUTOR_THREADS = 1;
    static final String DEFAULT_SOURCE_EXECUTOR_NAME = "source";
    private static final String DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME = "source-unlimited";
    private static final long KEEP_ALIVE_TIME_MS = TimeUnit.SECONDS.toMillis(10);
    private static final int MAXIMUM_AUTOMATIC_THREAD_COUNT = 4;
    private static final String TAG = "GlideExecutor";
    private static volatile int bestThreadCount;
    private final ExecutorService delegate;

    public static Builder newDiskCacheBuilder() {
        return new Builder(true).setThreadCount(1).setName(DEFAULT_DISK_CACHE_EXECUTOR_NAME);
    }

    public static GlideExecutor newDiskCacheExecutor() {
        return newDiskCacheBuilder().build();
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newDiskCacheBuilder().setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(int threadCount, String name, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newDiskCacheBuilder().setThreadCount(threadCount).setName(name).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    public static Builder newSourceBuilder() {
        return new Builder(false).setThreadCount(calculateBestThreadCount()).setName(DEFAULT_SOURCE_EXECUTOR_NAME);
    }

    public static GlideExecutor newSourceExecutor() {
        return newSourceBuilder().build();
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newSourceBuilder().setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(int threadCount, String name, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newSourceBuilder().setThreadCount(threadCount).setName(name).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    public static GlideExecutor newUnlimitedSourceExecutor() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, KEEP_ALIVE_TIME_MS, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(new DefaultPriorityThreadFactory(), DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT, false)));
    }

    public static Builder newAnimationBuilder() {
        return new Builder(true).setThreadCount(calculateAnimationExecutorThreadCount()).setName(DEFAULT_ANIMATION_EXECUTOR_NAME);
    }

    static int calculateAnimationExecutorThreadCount() {
        return calculateBestThreadCount() >= 4 ? 2 : 1;
    }

    public static GlideExecutor newAnimationExecutor() {
        return newAnimationBuilder().build();
    }

    @Deprecated
    public static GlideExecutor newAnimationExecutor(int threadCount, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newAnimationBuilder().setThreadCount(threadCount).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    GlideExecutor(ExecutorService delegate2) {
        this.delegate = delegate2;
    }

    public void execute(Runnable command) {
        this.delegate.execute(command);
    }

    public Future<?> submit(Runnable task) {
        return this.delegate.submit(task);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return this.delegate.invokeAll(tasks);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return this.delegate.invokeAll(tasks, timeout, unit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return this.delegate.invokeAny(tasks);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.delegate.invokeAny(tasks, timeout, unit);
    }

    public <T> Future<T> submit(Runnable task, T result) {
        return this.delegate.submit(task, result);
    }

    public <T> Future<T> submit(Callable<T> task) {
        return this.delegate.submit(task);
    }

    public void shutdown() {
        this.delegate.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return this.delegate.awaitTermination(timeout, unit);
    }

    public String toString() {
        return this.delegate.toString();
    }

    public static int calculateBestThreadCount() {
        if (bestThreadCount == 0) {
            bestThreadCount = Math.min(4, RuntimeCompat.availableProcessors());
        }
        return bestThreadCount;
    }

    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy DEFAULT;
        public static final UncaughtThrowableStrategy IGNORE = new UncaughtThrowableStrategy() {
            public void handle(Throwable t) {
            }
        };
        public static final UncaughtThrowableStrategy LOG;
        public static final UncaughtThrowableStrategy THROW = new UncaughtThrowableStrategy() {
            public void handle(Throwable t) {
                if (t != null) {
                    throw new RuntimeException("Request threw uncaught throwable", t);
                }
            }
        };

        void handle(Throwable th);

        static {
            AnonymousClass2 r0 = new UncaughtThrowableStrategy() {
                public void handle(Throwable t) {
                    if (t != null && Log.isLoggable(GlideExecutor.TAG, 6)) {
                        Log.e(GlideExecutor.TAG, "Request threw uncaught throwable", t);
                    }
                }
            };
            LOG = r0;
            DEFAULT = r0;
        }
    }

    private static final class DefaultPriorityThreadFactory implements ThreadFactory {
        private static final int DEFAULT_PRIORITY = 9;

        private DefaultPriorityThreadFactory() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable) {
                public void run() {
                    Process.setThreadPriority(9);
                    super.run();
                }
            };
        }
    }

    private static final class DefaultThreadFactory implements ThreadFactory {
        private final ThreadFactory delegate;
        private final String name;
        final boolean preventNetworkOperations;
        private final AtomicInteger threadNum = new AtomicInteger();
        final UncaughtThrowableStrategy uncaughtThrowableStrategy;

        DefaultThreadFactory(ThreadFactory delegate2, String name2, UncaughtThrowableStrategy uncaughtThrowableStrategy2, boolean preventNetworkOperations2) {
            this.delegate = delegate2;
            this.name = name2;
            this.uncaughtThrowableStrategy = uncaughtThrowableStrategy2;
            this.preventNetworkOperations = preventNetworkOperations2;
        }

        public Thread newThread(final Runnable runnable) {
            Thread newThread = this.delegate.newThread(new Runnable() {
                public void run() {
                    if (DefaultThreadFactory.this.preventNetworkOperations) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        runnable.run();
                    } catch (Throwable t) {
                        DefaultThreadFactory.this.uncaughtThrowableStrategy.handle(t);
                    }
                }
            });
            newThread.setName("glide-" + this.name + "-thread-" + this.threadNum.getAndIncrement());
            return newThread;
        }
    }

    public static final class Builder {
        public static final long NO_THREAD_TIMEOUT = 0;
        private int corePoolSize;
        private int maximumPoolSize;
        private String name;
        private final boolean preventNetworkOperations;
        private ThreadFactory threadFactory = new DefaultPriorityThreadFactory();
        private long threadTimeoutMillis;
        private UncaughtThrowableStrategy uncaughtThrowableStrategy = UncaughtThrowableStrategy.DEFAULT;

        Builder(boolean preventNetworkOperations2) {
            this.preventNetworkOperations = preventNetworkOperations2;
        }

        public Builder setThreadTimeoutMillis(long threadTimeoutMillis2) {
            this.threadTimeoutMillis = threadTimeoutMillis2;
            return this;
        }

        public Builder setThreadCount(int threadCount) {
            this.corePoolSize = threadCount;
            this.maximumPoolSize = threadCount;
            return this;
        }

        @Deprecated
        public Builder setThreadFactory(ThreadFactory threadFactory2) {
            this.threadFactory = threadFactory2;
            return this;
        }

        public Builder setUncaughtThrowableStrategy(UncaughtThrowableStrategy strategy) {
            this.uncaughtThrowableStrategy = strategy;
            return this;
        }

        public Builder setName(String name2) {
            this.name = name2;
            return this;
        }

        public GlideExecutor build() {
            if (!TextUtils.isEmpty(this.name)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.corePoolSize, this.maximumPoolSize, this.threadTimeoutMillis, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.threadFactory, this.name, this.uncaughtThrowableStrategy, this.preventNetworkOperations));
                if (this.threadTimeoutMillis != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new GlideExecutor(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.name);
        }
    }
}

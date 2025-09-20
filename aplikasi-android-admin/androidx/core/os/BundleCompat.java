package androidx.core.os;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class BundleCompat {
    private BundleCompat() {
    }

    public static <T> T getParcelable(Bundle in, String key, Class<T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelable(in, key, clazz);
        }
        T parcelable = in.getParcelable(key);
        if (clazz.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    public static Parcelable[] getParcelableArray(Bundle in, String key, Class<? extends Parcelable> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (Parcelable[]) Api33Impl.getParcelableArray(in, key, clazz);
        }
        return in.getParcelableArray(key);
    }

    public static <T> ArrayList<T> getParcelableArrayList(Bundle in, String key, Class<? extends T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelableArrayList(in, key, clazz);
        }
        return in.getParcelableArrayList(key);
    }

    public static <T> SparseArray<T> getSparseParcelableArray(Bundle in, String key, Class<? extends T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.getSparseParcelableArray(in, key, clazz);
        }
        return in.getSparseParcelableArray(key);
    }

    public static IBinder getBinder(Bundle bundle, String key) {
        return Api18Impl.getBinder(bundle, key);
    }

    public static void putBinder(Bundle bundle, String key, IBinder binder) {
        Api18Impl.putBinder(bundle, key, binder);
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static <T> T getParcelable(Bundle in, String key, Class<T> clazz) {
            return in.getParcelable(key, clazz);
        }

        static <T> T[] getParcelableArray(Bundle in, String key, Class<T> clazz) {
            return in.getParcelableArray(key, clazz);
        }

        static <T> ArrayList<T> getParcelableArrayList(Bundle in, String key, Class<? extends T> clazz) {
            return in.getParcelableArrayList(key, clazz);
        }

        static <T> SparseArray<T> getSparseParcelableArray(Bundle in, String key, Class<? extends T> clazz) {
            return in.getSparseParcelableArray(key, clazz);
        }
    }

    static class Api18Impl {
        private Api18Impl() {
        }

        static IBinder getBinder(Bundle bundle, String key) {
            return bundle.getBinder(key);
        }

        static void putBinder(Bundle bundle, String key, IBinder value) {
            bundle.putBinder(key, value);
        }
    }

    static class BeforeApi18Impl {
        private static final String TAG = "BundleCompat";
        private static Method sGetIBinderMethod;
        private static boolean sGetIBinderMethodFetched;
        private static Method sPutIBinderMethod;
        private static boolean sPutIBinderMethodFetched;

        private BeforeApi18Impl() {
        }

        public static IBinder getBinder(Bundle bundle, String key) {
            if (!sGetIBinderMethodFetched) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    sGetIBinderMethod = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i(TAG, "Failed to retrieve getIBinder method", e);
                }
                sGetIBinderMethodFetched = true;
            }
            Method method2 = sGetIBinderMethod;
            if (method2 != null) {
                try {
                    return (IBinder) method2.invoke(bundle, new Object[]{key});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i(TAG, "Failed to invoke getIBinder via reflection", e2);
                    sGetIBinderMethod = null;
                }
            }
            return null;
        }

        public static void putBinder(Bundle bundle, String key, IBinder binder) {
            if (!sPutIBinderMethodFetched) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                    sPutIBinderMethod = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i(TAG, "Failed to retrieve putIBinder method", e);
                }
                sPutIBinderMethodFetched = true;
            }
            Method method2 = sPutIBinderMethod;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, new Object[]{key, binder});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i(TAG, "Failed to invoke putIBinder via reflection", e2);
                    sPutIBinderMethod = null;
                }
            }
        }
    }
}

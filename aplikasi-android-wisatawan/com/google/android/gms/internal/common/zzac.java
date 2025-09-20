package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;

@NullMarked
@DoNotMock("Use ImmutableList.of or another implementation")
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public abstract class zzac extends AbstractCollection implements Serializable {
    private static final Object[] zza = new Object[0];

    zzac() {
    }

    @Deprecated
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(zza);
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public int zzb() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public int zzc() {
        throw null;
    }

    public zzag zzd() {
        throw null;
    }

    /* renamed from: zze */
    public abstract zzaj iterator();

    /* access modifiers changed from: package-private */
    public abstract boolean zzf();

    /* access modifiers changed from: package-private */
    @CheckForNull
    public Object[] zzg() {
        throw null;
    }

    public final Object[] toArray(Object[] objArr) {
        if (objArr != null) {
            int size = size();
            int length = objArr.length;
            if (length < size) {
                Object[] zzg = zzg();
                if (zzg != null) {
                    return Arrays.copyOfRange(zzg, zzc(), zzb(), objArr.getClass());
                }
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
            } else if (length > size) {
                objArr[size] = null;
            }
            zza(objArr, 0);
            return objArr;
        }
        throw null;
    }
}

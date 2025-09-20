package com.google.android.gms.internal.maps;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public abstract class zzba extends zzaw implements Set {
    @CheckForNull
    private transient zzaz zza;

    zzba() {
    }

    static int zzf(int i) {
        int max = Math.max(i, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (((double) highestOneBit) * 0.7d < ((double) max));
            return highestOneBit;
        } else if (max < 1073741824) {
            return BasicMeasure.EXACTLY;
        } else {
            throw new IllegalArgumentException("collection too large");
        }
    }

    @SafeVarargs
    public static zzba zzi(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = {"ADMINISTRATIVE_AREA_LEVEL_1", "ADMINISTRATIVE_AREA_LEVEL_2", "COUNTRY", "LOCALITY", "POSTAL_CODE", "SCHOOL_DISTRICT"};
        System.arraycopy(objArr, 0, objArr2, 6, 0);
        return zzk(6, objArr2);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzba) && zzj() && ((zzba) obj).zzj() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException e) {
            }
        }
        return false;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }

    /* renamed from: zzd */
    public abstract zzbf iterator();

    public final zzaz zzg() {
        zzaz zzaz = this.zza;
        if (zzaz != null) {
            return zzaz;
        }
        zzaz zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    /* access modifiers changed from: package-private */
    public zzaz zzh() {
        Object[] array = toArray();
        int i = zzaz.zzd;
        return zzaz.zzg(array, array.length);
    }

    /* access modifiers changed from: package-private */
    public boolean zzj() {
        return false;
    }

    private static zzba zzk(int i, Object... objArr) {
        Object[] objArr2;
        switch (i) {
            case 0:
                return zzbd.zza;
            case 1:
                Object obj = objArr[0];
                obj.getClass();
                return new zzbe(obj);
            default:
                int zzf = zzf(i);
                Object[] objArr3 = new Object[zzf];
                int i2 = zzf - 1;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i3 < i) {
                    Object obj2 = objArr[i3];
                    if (obj2 != null) {
                        int hashCode = obj2.hashCode();
                        int zza2 = zzav.zza(hashCode);
                        while (true) {
                            int i6 = zza2 & i2;
                            Object obj3 = objArr3[i6];
                            if (obj3 == null) {
                                objArr[i5] = obj2;
                                objArr3[i6] = obj2;
                                i4 += hashCode;
                                i5++;
                            } else if (!obj3.equals(obj2)) {
                                zza2++;
                            }
                        }
                        i3++;
                    } else {
                        throw new NullPointerException("at index " + i3);
                    }
                }
                Arrays.fill(objArr, i5, i, (Object) null);
                if (i5 == 1) {
                    Object obj4 = objArr[0];
                    obj4.getClass();
                    return new zzbe(obj4);
                }
                if (zzf(i5) < zzf / 2) {
                    return zzk(i5, objArr);
                }
                if (i5 < 4) {
                    objArr2 = Arrays.copyOf(objArr, i5);
                } else {
                    objArr2 = objArr;
                }
                return new zzbd(objArr2, i4, objArr3, i2, i5);
        }
    }
}

package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J%\u0010\t\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"androidx/compose/runtime/ParcelableSnapshotMutableState$Companion$CREATOR$1", "Landroid/os/Parcelable$ClassLoaderCreator;", "Landroidx/compose/runtime/ParcelableSnapshotMutableState;", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "loader", "Ljava/lang/ClassLoader;", "newArray", "", "size", "", "(I)[Landroidx/compose/runtime/ParcelableSnapshotMutableState;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ParcelableSnapshotMutableState.kt */
public final class ParcelableSnapshotMutableState$Companion$CREATOR$1 implements Parcelable.ClassLoaderCreator<ParcelableSnapshotMutableState<Object>> {
    ParcelableSnapshotMutableState$Companion$CREATOR$1() {
    }

    public ParcelableSnapshotMutableState<Object> createFromParcel(Parcel parcel, ClassLoader loader) {
        SnapshotMutationPolicy snapshotMutationPolicy;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Object value = parcel.readValue(loader == null ? getClass().getClassLoader() : loader);
        int policyIndex = parcel.readInt();
        switch (policyIndex) {
            case 0:
                snapshotMutationPolicy = SnapshotStateKt.neverEqualPolicy();
                break;
            case 1:
                snapshotMutationPolicy = SnapshotStateKt.structuralEqualityPolicy();
                break;
            case 2:
                snapshotMutationPolicy = SnapshotStateKt.referentialEqualityPolicy();
                break;
            default:
                throw new IllegalStateException("Unsupported MutableState policy " + policyIndex + " was restored");
        }
        return new ParcelableSnapshotMutableState<>(value, snapshotMutationPolicy);
    }

    public ParcelableSnapshotMutableState<Object> createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return createFromParcel(parcel, (ClassLoader) null);
    }

    public ParcelableSnapshotMutableState<Object>[] newArray(int size) {
        return new ParcelableSnapshotMutableState[size];
    }
}

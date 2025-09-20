package com.example.belajar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.example.belajar.R;

public final class TentangaplikasiBinding implements ViewBinding {
    private final LinearLayout rootView;

    private TentangaplikasiBinding(LinearLayout rootView2) {
        this.rootView = rootView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TentangaplikasiBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static TentangaplikasiBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.tentangaplikasi, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static TentangaplikasiBinding bind(View rootView2) {
        if (rootView2 != null) {
            return new TentangaplikasiBinding((LinearLayout) rootView2);
        }
        throw new NullPointerException("rootView");
    }
}

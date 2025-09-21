package com.example.aplikasiwisatawan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.example.aplikasiwisatawan.R;

public final class ActivityMainBinding implements ViewBinding {
    public final LinearLayout main;
    private final LinearLayout rootView;

    private ActivityMainBinding(LinearLayout rootView2, LinearLayout main2) {
        this.rootView = rootView2;
        this.main = main2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_main, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityMainBinding bind(View rootView2) {
        if (rootView2 != null) {
            return new ActivityMainBinding((LinearLayout) rootView2, (LinearLayout) rootView2);
        }
        throw new NullPointerException("rootView");
    }
}

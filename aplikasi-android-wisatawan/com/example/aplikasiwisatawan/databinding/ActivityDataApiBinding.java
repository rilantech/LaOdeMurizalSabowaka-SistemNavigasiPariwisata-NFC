package com.example.aplikasiwisatawan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.aplikasiwisatawan.R;

public final class ActivityDataApiBinding implements ViewBinding {
    public final ListView list;
    public final LinearLayoutCompat main;
    private final LinearLayoutCompat rootView;

    private ActivityDataApiBinding(LinearLayoutCompat rootView2, ListView list2, LinearLayoutCompat main2) {
        this.rootView = rootView2;
        this.list = list2;
        this.main = main2;
    }

    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static ActivityDataApiBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityDataApiBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_data_api, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityDataApiBinding bind(View rootView2) {
        ListView list2 = (ListView) ViewBindings.findChildViewById(rootView2, R.id.list);
        if (list2 != null) {
            return new ActivityDataApiBinding((LinearLayoutCompat) rootView2, list2, (LinearLayoutCompat) rootView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.list)));
    }
}

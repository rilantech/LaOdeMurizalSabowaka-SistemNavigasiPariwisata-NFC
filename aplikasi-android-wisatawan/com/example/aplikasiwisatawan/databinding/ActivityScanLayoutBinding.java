package com.example.aplikasiwisatawan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.aplikasiwisatawan.R;

public final class ActivityScanLayoutBinding implements ViewBinding {
    public final FrameLayout frameLayoutCamera;
    public final LinearLayout main;
    private final LinearLayout rootView;

    private ActivityScanLayoutBinding(LinearLayout rootView2, FrameLayout frameLayoutCamera2, LinearLayout main2) {
        this.rootView = rootView2;
        this.frameLayoutCamera = frameLayoutCamera2;
        this.main = main2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityScanLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityScanLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_scan_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityScanLayoutBinding bind(View rootView2) {
        FrameLayout frameLayoutCamera2 = (FrameLayout) ViewBindings.findChildViewById(rootView2, R.id.frame_layout_camera);
        if (frameLayoutCamera2 != null) {
            return new ActivityScanLayoutBinding((LinearLayout) rootView2, frameLayoutCamera2, (LinearLayout) rootView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.frame_layout_camera)));
    }
}

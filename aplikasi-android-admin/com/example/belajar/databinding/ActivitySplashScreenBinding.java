package com.example.belajar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.belajar.R;

public final class ActivitySplashScreenBinding implements ViewBinding {
    public final ImageView imageView;
    public final RelativeLayout main;
    private final RelativeLayout rootView;

    private ActivitySplashScreenBinding(RelativeLayout rootView2, ImageView imageView2, RelativeLayout main2) {
        this.rootView = rootView2;
        this.imageView = imageView2;
        this.main = main2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySplashScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivitySplashScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_splash_screen, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivitySplashScreenBinding bind(View rootView2) {
        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView2, R.id.imageView);
        if (imageView2 != null) {
            return new ActivitySplashScreenBinding((RelativeLayout) rootView2, imageView2, (RelativeLayout) rootView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.imageView)));
    }
}

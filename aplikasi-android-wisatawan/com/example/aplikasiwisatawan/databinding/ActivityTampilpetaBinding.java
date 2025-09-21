package com.example.aplikasiwisatawan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.aplikasiwisatawan.R;

public final class ActivityTampilpetaBinding implements ViewBinding {
    public final LinearLayout main;
    public final WebView myWebView;
    private final LinearLayout rootView;

    private ActivityTampilpetaBinding(LinearLayout rootView2, LinearLayout main2, WebView myWebView2) {
        this.rootView = rootView2;
        this.main = main2;
        this.myWebView = myWebView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTampilpetaBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityTampilpetaBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_tampilpeta, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityTampilpetaBinding bind(View rootView2) {
        LinearLayout main2 = (LinearLayout) rootView2;
        WebView myWebView2 = (WebView) ViewBindings.findChildViewById(rootView2, R.id.myWebView);
        if (myWebView2 != null) {
            return new ActivityTampilpetaBinding((LinearLayout) rootView2, main2, myWebView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.myWebView)));
    }
}

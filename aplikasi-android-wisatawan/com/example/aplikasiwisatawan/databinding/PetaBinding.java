package com.example.aplikasiwisatawan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.aplikasiwisatawan.R;

public final class PetaBinding implements ViewBinding {
    public final LinearLayout main;
    private final LinearLayout rootView;
    public final WebView webviewku;

    private PetaBinding(LinearLayout rootView2, LinearLayout main2, WebView webviewku2) {
        this.rootView = rootView2;
        this.main = main2;
        this.webviewku = webviewku2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PetaBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static PetaBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.peta, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static PetaBinding bind(View rootView2) {
        LinearLayout main2 = (LinearLayout) rootView2;
        WebView webviewku2 = (WebView) ViewBindings.findChildViewById(rootView2, R.id.webviewku);
        if (webviewku2 != null) {
            return new PetaBinding((LinearLayout) rootView2, main2, webviewku2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.webviewku)));
    }
}

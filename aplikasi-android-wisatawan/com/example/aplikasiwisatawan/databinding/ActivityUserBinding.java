package com.example.aplikasiwisatawan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.aplikasiwisatawan.R;

public final class ActivityUserBinding implements ViewBinding {
    public final Button btnLogout;
    public final LinearLayout main;
    private final LinearLayout rootView;
    public final TextView tvNama;
    public final TextView tvUsername;

    private ActivityUserBinding(LinearLayout rootView2, Button btnLogout2, LinearLayout main2, TextView tvNama2, TextView tvUsername2) {
        this.rootView = rootView2;
        this.btnLogout = btnLogout2;
        this.main = main2;
        this.tvNama = tvNama2;
        this.tvUsername = tvUsername2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUserBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityUserBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_user, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityUserBinding bind(View rootView2) {
        int id = R.id.btnLogout;
        Button btnLogout2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.btnLogout);
        if (btnLogout2 != null) {
            LinearLayout main2 = (LinearLayout) rootView2;
            id = R.id.tvNama;
            TextView tvNama2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.tvNama);
            if (tvNama2 != null) {
                id = R.id.tvUsername;
                TextView tvUsername2 = (TextView) ViewBindings.findChildViewById(rootView2, R.id.tvUsername);
                if (tvUsername2 != null) {
                    return new ActivityUserBinding((LinearLayout) rootView2, btnLogout2, main2, tvNama2, tvUsername2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

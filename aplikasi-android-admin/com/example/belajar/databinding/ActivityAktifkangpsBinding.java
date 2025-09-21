package com.example.belajar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.belajar.R;

public final class ActivityAktifkangpsBinding implements ViewBinding {
    public final Button aktifgps;
    public final ConstraintLayout main;
    private final ConstraintLayout rootView;

    private ActivityAktifkangpsBinding(ConstraintLayout rootView2, Button aktifgps2, ConstraintLayout main2) {
        this.rootView = rootView2;
        this.aktifgps = aktifgps2;
        this.main = main2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAktifkangpsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityAktifkangpsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_aktifkangps, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityAktifkangpsBinding bind(View rootView2) {
        Button aktifgps2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.aktifgps);
        if (aktifgps2 != null) {
            return new ActivityAktifkangpsBinding((ConstraintLayout) rootView2, aktifgps2, (ConstraintLayout) rootView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.aktifgps)));
    }
}

package com.example.aplikasiwisatawan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.aplikasiwisatawan.R;

public final class InputKodeWisataBinding implements ViewBinding {
    public final EditText kodewisata;
    public final LinearLayout main;
    public final Button mulaiwritenfc;
    public final Button resettagnfc;
    private final LinearLayout rootView;

    private InputKodeWisataBinding(LinearLayout rootView2, EditText kodewisata2, LinearLayout main2, Button mulaiwritenfc2, Button resettagnfc2) {
        this.rootView = rootView2;
        this.kodewisata = kodewisata2;
        this.main = main2;
        this.mulaiwritenfc = mulaiwritenfc2;
        this.resettagnfc = resettagnfc2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static InputKodeWisataBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static InputKodeWisataBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.input_kode_wisata, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static InputKodeWisataBinding bind(View rootView2) {
        int id = R.id.kodewisata;
        EditText kodewisata2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.kodewisata);
        if (kodewisata2 != null) {
            LinearLayout main2 = (LinearLayout) rootView2;
            id = R.id.mulaiwritenfc;
            Button mulaiwritenfc2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.mulaiwritenfc);
            if (mulaiwritenfc2 != null) {
                id = R.id.resettagnfc;
                Button resettagnfc2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.resettagnfc);
                if (resettagnfc2 != null) {
                    return new InputKodeWisataBinding((LinearLayout) rootView2, kodewisata2, main2, mulaiwritenfc2, resettagnfc2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

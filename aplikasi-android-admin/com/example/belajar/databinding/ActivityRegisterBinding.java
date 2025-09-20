package com.example.belajar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.belajar.R;

public final class ActivityRegisterBinding implements ViewBinding {
    public final Button btnRegister;
    public final EditText etNama;
    public final EditText etPassword;
    public final EditText etUsername;
    public final LinearLayout main;
    private final LinearLayout rootView;
    public final TextView tvlogin;

    private ActivityRegisterBinding(LinearLayout rootView2, Button btnRegister2, EditText etNama2, EditText etPassword2, EditText etUsername2, LinearLayout main2, TextView tvlogin2) {
        this.rootView = rootView2;
        this.btnRegister = btnRegister2;
        this.etNama = etNama2;
        this.etPassword = etPassword2;
        this.etUsername = etUsername2;
        this.main = main2;
        this.tvlogin = tvlogin2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityRegisterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityRegisterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_register, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityRegisterBinding bind(View rootView2) {
        View view = rootView2;
        int id = R.id.btnRegister;
        Button btnRegister2 = (Button) ViewBindings.findChildViewById(view, R.id.btnRegister);
        if (btnRegister2 != null) {
            id = R.id.etNama;
            EditText etNama2 = (EditText) ViewBindings.findChildViewById(view, R.id.etNama);
            if (etNama2 != null) {
                id = R.id.etPassword;
                EditText etPassword2 = (EditText) ViewBindings.findChildViewById(view, R.id.etPassword);
                if (etPassword2 != null) {
                    id = R.id.etUsername;
                    EditText etUsername2 = (EditText) ViewBindings.findChildViewById(view, R.id.etUsername);
                    if (etUsername2 != null) {
                        LinearLayout main2 = (LinearLayout) view;
                        id = R.id.tvlogin;
                        TextView tvlogin2 = (TextView) ViewBindings.findChildViewById(view, R.id.tvlogin);
                        if (tvlogin2 != null) {
                            return new ActivityRegisterBinding((LinearLayout) view, btnRegister2, etNama2, etPassword2, etUsername2, main2, tvlogin2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

package com.example.belajar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.belajar.R;

public final class ActivityLoginBinding implements ViewBinding {
    public final Button btnLogin;
    public final Button btnRegister;
    public final EditText etPassword;
    public final EditText etUsername;
    public final LinearLayout main;
    private final LinearLayout rootView;

    private ActivityLoginBinding(LinearLayout rootView2, Button btnLogin2, Button btnRegister2, EditText etPassword2, EditText etUsername2, LinearLayout main2) {
        this.rootView = rootView2;
        this.btnLogin = btnLogin2;
        this.btnRegister = btnRegister2;
        this.etPassword = etPassword2;
        this.etUsername = etUsername2;
        this.main = main2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLoginBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityLoginBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_login, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityLoginBinding bind(View rootView2) {
        int id = R.id.btnLogin;
        Button btnLogin2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.btnLogin);
        if (btnLogin2 != null) {
            id = R.id.btnRegister;
            Button btnRegister2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.btnRegister);
            if (btnRegister2 != null) {
                id = R.id.etPassword;
                EditText etPassword2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.etPassword);
                if (etPassword2 != null) {
                    id = R.id.etUsername;
                    EditText etUsername2 = (EditText) ViewBindings.findChildViewById(rootView2, R.id.etUsername);
                    if (etUsername2 != null) {
                        return new ActivityLoginBinding((LinearLayout) rootView2, btnLogin2, btnRegister2, etPassword2, etUsername2, (LinearLayout) rootView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

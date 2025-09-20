package com.example.aplikasiwisatawan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.aplikasiwisatawan.R;

public final class LoginBinding implements ViewBinding {
    public final Button btnLogin;
    public final TextView copyright;
    public final EditText etPassword;
    public final EditText etUsername;
    public final LinearLayout main;
    private final LinearLayout rootView;
    public final TextView tvRegister;

    private LoginBinding(LinearLayout rootView2, Button btnLogin2, TextView copyright2, EditText etPassword2, EditText etUsername2, LinearLayout main2, TextView tvRegister2) {
        this.rootView = rootView2;
        this.btnLogin = btnLogin2;
        this.copyright = copyright2;
        this.etPassword = etPassword2;
        this.etUsername = etUsername2;
        this.main = main2;
        this.tvRegister = tvRegister2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LoginBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static LoginBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.login, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LoginBinding bind(View rootView2) {
        View view = rootView2;
        int id = R.id.btnLogin;
        Button btnLogin2 = (Button) ViewBindings.findChildViewById(view, R.id.btnLogin);
        if (btnLogin2 != null) {
            id = R.id.copyright;
            TextView copyright2 = (TextView) ViewBindings.findChildViewById(view, R.id.copyright);
            if (copyright2 != null) {
                id = R.id.etPassword;
                EditText etPassword2 = (EditText) ViewBindings.findChildViewById(view, R.id.etPassword);
                if (etPassword2 != null) {
                    id = R.id.etUsername;
                    EditText etUsername2 = (EditText) ViewBindings.findChildViewById(view, R.id.etUsername);
                    if (etUsername2 != null) {
                        LinearLayout main2 = (LinearLayout) view;
                        id = R.id.tvRegister;
                        TextView tvRegister2 = (TextView) ViewBindings.findChildViewById(view, R.id.tvRegister);
                        if (tvRegister2 != null) {
                            return new LoginBinding((LinearLayout) view, btnLogin2, copyright2, etPassword2, etUsername2, main2, tvRegister2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

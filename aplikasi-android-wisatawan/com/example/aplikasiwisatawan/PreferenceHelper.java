package com.example.aplikasiwisatawan;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.autofill.HintConstants;

public class PreferenceHelper {
    private final String INTRO = "intro";
    private final String NAMA = "nama";
    private final String PASSWORD = HintConstants.AUTOFILL_HINT_PASSWORD;
    private final String USERNAME = HintConstants.AUTOFILL_HINT_USERNAME;
    private SharedPreferences app_prefs;
    private Context context;

    public PreferenceHelper(Context context2) {
        this.app_prefs = context2.getSharedPreferences("shared", 0);
        this.context = context2;
    }

    public void putIsLogin(boolean loginorout) {
        SharedPreferences.Editor edit = this.app_prefs.edit();
        edit.putBoolean("intro", loginorout);
        edit.commit();
    }

    public boolean getIsLogin() {
        return this.app_prefs.getBoolean("intro", false);
    }

    public void putNama(String loginorout) {
        SharedPreferences.Editor edit = this.app_prefs.edit();
        edit.putString("nama", loginorout);
        edit.commit();
    }

    public String getNama() {
        return this.app_prefs.getString("nama", "");
    }

    public void putUsername(String loginorout) {
        SharedPreferences.Editor edit = this.app_prefs.edit();
        edit.putString(HintConstants.AUTOFILL_HINT_USERNAME, loginorout);
        edit.commit();
    }

    public String getUsername() {
        return this.app_prefs.getString(HintConstants.AUTOFILL_HINT_USERNAME, "");
    }

    public void putPassword(String loginorout) {
        SharedPreferences.Editor edit = this.app_prefs.edit();
        edit.putString(HintConstants.AUTOFILL_HINT_PASSWORD, loginorout);
        edit.commit();
    }

    public String getPassword() {
        return this.app_prefs.getString(HintConstants.AUTOFILL_HINT_PASSWORD, "");
    }
}

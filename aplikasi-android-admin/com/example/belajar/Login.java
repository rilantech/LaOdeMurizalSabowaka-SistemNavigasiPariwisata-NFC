package com.example.belajar;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import cn.pedant.SweetAlert.SweetAlertDialog;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    public static String nama = "";
    public static Boolean status;
    private String URLline = (KoneksiApi.URL_API + "api/loginadmin");
    private Button btnLogin;
    /* access modifiers changed from: private */
    public EditText etPassword;
    private EditText etUsername;
    boolean passwordVisible;
    private PreferenceHelper preferenceHelper;
    /* access modifiers changed from: private */
    public RequestQueue rQueue;
    View view;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((int) R.layout.login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new Login$$ExternalSyntheticLambda0());
        this.preferenceHelper = new PreferenceHelper(this);
        this.etUsername = (EditText) findViewById(R.id.etUsername);
        this.etPassword = (EditText) findViewById(R.id.etPassword);
        this.btnLogin = (Button) findViewById(R.id.btnLogin);
        this.etPassword.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 1 || event.getRawX() < ((float) (Login.this.etPassword.getRight() - Login.this.etPassword.getCompoundDrawables()[2].getBounds().width()))) {
                    return false;
                }
                int selection = Login.this.etPassword.getSelectionEnd();
                if (Login.this.passwordVisible) {
                    Login.this.etPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.showpassword, 0);
                    Login.this.etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    Login.this.passwordVisible = false;
                } else {
                    Login.this.etPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.hidepassword, 0);
                    Login.this.etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    Login.this.passwordVisible = true;
                }
                Login.this.etPassword.setSelection(selection);
                return true;
            }
        });
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Login.this.loginUser();
            }
        });
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View v, WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    }

    /* access modifiers changed from: private */
    public void loginUser() {
        String username = this.etUsername.getText().toString().trim();
        final String str = username;
        final String trim = this.etPassword.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(1, this.URLline, new Response.Listener<String>() {
            public void onResponse(String response) {
                Login.this.rQueue.getCache().clear();
                Login.status = true;
                Login.this.parseData(response);
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, "Gagal Login", 0).show();
            }
        }) {
            /* access modifiers changed from: protected */
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put(HintConstants.AUTOFILL_HINT_USERNAME, str);
                params.put(HintConstants.AUTOFILL_HINT_PASSWORD, trim);
                return params;
            }
        };
        RequestQueue newRequestQueue = Volley.newRequestQueue(this);
        this.rQueue = newRequestQueue;
        newRequestQueue.add(stringRequest);
    }

    /* access modifiers changed from: private */
    public void parseData(String response) {
        try {
            if (new JSONObject(response).getString(NotificationCompat.CATEGORY_STATUS).equals("true")) {
                saveInfo(response);
                Intent intent = new Intent(this, HalamanUtamaAdmin.class);
                intent.addFlags(268468224);
                startActivity(intent);
                return;
            }
            new SweetAlertDialog(this, 1).setTitleText("Info").setContentText("Gagal Login!").show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void saveInfo(String response) {
        this.preferenceHelper.putIsLogin(true);
        try {
            JSONObject jsonObject = new JSONObject(response);
            nama = jsonObject.getString("namaadmin");
            if (jsonObject.getString(NotificationCompat.CATEGORY_STATUS).equals("true")) {
                JSONArray dataArray = jsonObject.getJSONArray("dataadmin");
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataobj = dataArray.getJSONObject(i);
                    this.preferenceHelper.putNama(dataobj.getString(HintConstants.AUTOFILL_HINT_NAME));
                    this.preferenceHelper.putUsername(dataobj.getString(HintConstants.AUTOFILL_HINT_USERNAME));
                    this.preferenceHelper.putPassword(dataobj.getString(HintConstants.AUTOFILL_HINT_PASSWORD));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

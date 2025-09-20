package com.example.belajar;

import android.content.Intent;
import android.os.Bundle;
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

public class LoginActivity extends AppCompatActivity {
    private String URLline = "http://192.168.124.119:8000/api/login";
    private Button btnLogin;
    private Button btnRegister;
    private EditText etPassword;
    private EditText etUsername;
    private PreferenceHelper preferenceHelper;
    /* access modifiers changed from: private */
    public RequestQueue rQueue;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((int) R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new LoginActivity$$ExternalSyntheticLambda0());
        this.preferenceHelper = new PreferenceHelper(this);
        this.etUsername = (EditText) findViewById(R.id.etUsername);
        this.etPassword = (EditText) findViewById(R.id.etPassword);
        this.btnLogin = (Button) findViewById(R.id.btnLogin);
        Button button = (Button) findViewById(R.id.btnRegister);
        this.btnRegister = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                LoginActivity.this.finish();
            }
        });
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoginActivity.this.loginUser();
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
                LoginActivity.this.rQueue.getCache().clear();
                Toast.makeText(LoginActivity.this, response, 0).show();
                LoginActivity.this.parseData(response);
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "Gagal Login", 0).show();
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
                Toast.makeText(this, "Login Successfully", 0).show();
                Intent intent = new Intent(this, UserActivity.class);
                intent.addFlags(268468224);
                startActivity(intent);
                finish();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void saveInfo(String response) {
        this.preferenceHelper.putIsLogin(true);
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString(NotificationCompat.CATEGORY_STATUS).equals("true")) {
                JSONArray dataArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataobj = dataArray.getJSONObject(i);
                    this.preferenceHelper.putNama(dataobj.getString("nama"));
                    this.preferenceHelper.putUsername(dataobj.getString(HintConstants.AUTOFILL_HINT_USERNAME));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

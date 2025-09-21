package com.example.aplikasiwisatawan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class Registrasi extends AppCompatActivity {
    private Button btnRegister;
    private EditText etNama;
    private EditText etPassword;
    private EditText etUsername;
    private PreferenceHelper preferenceHelper;
    /* access modifiers changed from: private */
    public RequestQueue rQueue;
    private String registerURL = (KoneksiApi.URL_API + "api/register");
    private TextView tvLogin;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((int) R.layout.registrasi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new Registrasi$$ExternalSyntheticLambda0());
        this.etNama = (EditText) findViewById(R.id.etNama);
        this.etUsername = (EditText) findViewById(R.id.etUsername);
        this.etPassword = (EditText) findViewById(R.id.etPassword);
        this.btnRegister = (Button) findViewById(R.id.btnRegister);
        TextView textView = (TextView) findViewById(R.id.tvLogin);
        this.tvLogin = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Registrasi.this.startActivity(new Intent(Registrasi.this, Login.class));
                Registrasi.this.finish();
            }
        });
        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Registrasi.this.registerMe();
            }
        });
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View v, WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    }

    /* access modifiers changed from: private */
    public void registerMe() {
        String nama = this.etNama.getText().toString();
        String username = this.etUsername.getText().toString();
        final String str = nama;
        final String str2 = username;
        final String obj = this.etPassword.getText().toString();
        StringRequest stringRequest = new StringRequest(1, this.registerURL, new Response.Listener<String>() {
            public void onResponse(String response) {
                Registrasi.this.rQueue.getCache().clear();
                try {
                    Registrasi.this.parseData(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                new SweetAlertDialog(Registrasi.this, 1).setTitleText("Info").setContentText("Registrasi Gagal").show();
            }
        }) {
            /* access modifiers changed from: protected */
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("nama", str);
                params.put(HintConstants.AUTOFILL_HINT_USERNAME, str2);
                params.put(HintConstants.AUTOFILL_HINT_PASSWORD, obj);
                return params;
            }
        };
        RequestQueue newRequestQueue = Volley.newRequestQueue(this);
        this.rQueue = newRequestQueue;
        newRequestQueue.add(stringRequest);
    }

    /* access modifiers changed from: private */
    public void parseData(String response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        if (jsonObject.optString(NotificationCompat.CATEGORY_STATUS).equals("true")) {
            new SweetAlertDialog(this, 2).setTitleText("Info").setContentText("Registrasi Sukses").show();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Registrasi.this.startActivity(new Intent(Registrasi.this, Login.class));
                    Registrasi.this.finish();
                }
            }, 3000);
            return;
        }
        Toast.makeText(this, jsonObject.getString("message"), 0).show();
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
                    this.preferenceHelper.putPassword(dataobj.getString(HintConstants.AUTOFILL_HINT_PASSWORD));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

package com.example.belajar;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
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
import org.json.JSONException;
import org.json.JSONObject;

public class Baca_Tag_Wisata extends AppCompatActivity {
    public static Tag mTag;
    public static boolean status;
    public static String userData;
    private String URLline = (KoneksiApi.URL_API + "api/cekkodewisata");
    NfcAdapter mAdapter;
    IntentFilter[] mFilter;
    PendingIntent mPI;
    /* access modifiers changed from: private */
    public RequestQueue rQueue;
    Button tombol_baca_tag;
    ImageView tombol_kembali;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((int) R.layout.baca_tag_wisata);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new Baca_Tag_Wisata$$ExternalSyntheticLambda0());
        this.tombol_baca_tag = (Button) findViewById(R.id.tombolbacatag);
        this.mAdapter = NfcAdapter.getDefaultAdapter(this);
        this.mPI = PendingIntent.getActivity(getApplicationContext(), 0, new Intent(this, getClass()).addFlags(536870912), 33554432);
        this.mFilter = new IntentFilter[]{new IntentFilter("android.nfc.action.TAG_DISCOVERED"), new IntentFilter("android.nfc.action.NDEF_DISCOVERED")};
        ImageView imageView = (ImageView) findViewById(R.id.tombol_kembali);
        this.tombol_kembali = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Baca_Tag_Wisata.this.finish();
            }
        });
        this.tombol_baca_tag.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Baca_Tag_Wisata.mTag == null) {
                    new SweetAlertDialog(Baca_Tag_Wisata.this, 3).setTitleText("Info").setContentText("Tag Wisata Tidak Terdeteksi!").show();
                } else if (Baca_Tag_Wisata.userData.isEmpty()) {
                    new SweetAlertDialog(Baca_Tag_Wisata.this, 3).setTitleText("Info").setContentText("Tag Wisata Kosong!").show();
                } else {
                    Baca_Tag_Wisata.this.bacaKode();
                }
            }
        });
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View v, WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getAction().equals("android.nfc.action.NDEF_DISCOVERED")) {
            Toast.makeText(getApplicationContext(), "Ndefdiscovered", 0).show();
        } else if (intent.getAction().equals("android.nfc.action.TAG_DISCOVERED")) {
            mTag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            new SweetAlertDialog(this).setTitleText("Info").setContentText("Tag Wisata Terdeteksi").show();
            NdefMessage[] messages = getNdefMessage(intent);
            if (messages != null) {
                userData = new String(messages[0].getRecords()[0].getPayload());
            }
        } else {
            Toast.makeText(getApplicationContext(), "Undefined smartcard", 0).show();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        userData = "";
        mTag = null;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        userData = "";
        mTag = null;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mAdapter.disableForegroundDispatch(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mAdapter.enableForegroundDispatch(this, this.mPI, this.mFilter, (String[][]) null);
    }

    private NdefRecord createRecord(byte[] payload) {
        return new NdefRecord(1, NdefRecord.RTD_TEXT, new byte[0], payload);
    }

    /* access modifiers changed from: package-private */
    public NdefMessage[] getNdefMessage(Intent intent) {
        NdefMessage[] msgs = null;
        Parcelable[] rawMsgs = intent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
        if (rawMsgs != null) {
            msgs = new NdefMessage[rawMsgs.length];
            for (int i = 0; i < rawMsgs.length; i++) {
                msgs[i] = (NdefMessage) rawMsgs[i];
            }
        }
        return msgs;
    }

    /* access modifiers changed from: private */
    public void bacaKode() {
        final String trim = userData.trim();
        StringRequest stringRequest = new StringRequest(1, this.URLline, new Response.Listener<String>() {
            public void onResponse(String response) {
                Baca_Tag_Wisata.this.rQueue.getCache().clear();
                Baca_Tag_Wisata.this.parseData(response);
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            /* access modifiers changed from: protected */
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id", trim);
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
                new SweetAlertDialog(this, 2).setTitleText("Info").setContentText("Kode Wisata Terbaca!").show();
                startActivity(new Intent(this, Halaman_Navigasi.class));
                finish();
                return;
            }
            new SweetAlertDialog(this, 1).setTitleText("Info").setContentText("Kode Wisata Tidak Terdaftar!").show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

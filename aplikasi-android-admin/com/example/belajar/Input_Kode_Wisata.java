package com.example.belajar;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import cn.pedant.SweetAlert.SweetAlertDialog;
import java.io.IOException;

public class Input_Kode_Wisata extends AppCompatActivity {
    public static NdefMessage message;
    EditText kodewisata;
    NfcAdapter mAdapter;
    IntentFilter[] mFilter;
    PendingIntent mPI;
    Tag mTag;
    Button mulaiwritenfc;
    Button resettagnfc;
    ImageView tombol_kembali;
    String userData;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((int) R.layout.input_kode_wisata);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new Input_Kode_Wisata$$ExternalSyntheticLambda0());
        this.kodewisata = (EditText) findViewById(R.id.kodewisata);
        this.mulaiwritenfc = (Button) findViewById(R.id.mulaiwritenfc);
        this.resettagnfc = (Button) findViewById(R.id.resettagnfc);
        this.tombol_kembali = (ImageView) findViewById(R.id.tombol_kembali);
        this.kodewisata.setText(ScannerActivity.hasil_scan);
        this.mAdapter = NfcAdapter.getDefaultAdapter(this);
        this.mPI = PendingIntent.getActivity(getApplicationContext(), 0, new Intent(this, getClass()).addFlags(536870912), 33554432);
        this.mFilter = new IntentFilter[]{new IntentFilter("android.nfc.action.TAG_DISCOVERED"), new IntentFilter("android.nfc.action.NDEF_DISCOVERED")};
        this.tombol_kembali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Input_Kode_Wisata.this.finish();
            }
        });
        this.mulaiwritenfc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Input_Kode_Wisata.this.mTag == null) {
                    new SweetAlertDialog(Input_Kode_Wisata.this, 3).setTitleText("Info").setContentText("Tag Wisata Tidak Terdeteksi !").show();
                    return;
                }
                NdefMessage message = new NdefMessage(new NdefRecord[]{Input_Kode_Wisata.this.createRecord(Input_Kode_Wisata.this.kodewisata.getText().toString().getBytes())});
                try {
                    NdefFormatable mNdef = NdefFormatable.get(Input_Kode_Wisata.this.mTag);
                    if (mNdef != null) {
                        mNdef.connect();
                        mNdef.format(message);
                        mNdef.close();
                    } else {
                        Ndef mNdef2 = Ndef.get(Input_Kode_Wisata.this.mTag);
                        if (mNdef2 != null) {
                            mNdef2.connect();
                            mNdef2.writeNdefMessage(message);
                            mNdef2.close();
                        } else {
                            Toast.makeText(Input_Kode_Wisata.this.getApplicationContext(), "Penulisan data gagal", 0).show();
                        }
                    }
                } catch (FormatException | IOException e) {
                }
                new SweetAlertDialog(Input_Kode_Wisata.this, 2).setTitleText("Info").setContentText("Kode Wisata Berhasil Tertulis ").show();
            }
        });
        this.resettagnfc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Input_Kode_Wisata.this.mTag == null) {
                    new SweetAlertDialog(Input_Kode_Wisata.this, 3).setTitleText("Info").setContentText("Tag Wisata Tidak Terdeteksi !").show();
                    return;
                }
                Input_Kode_Wisata input_Kode_Wisata = Input_Kode_Wisata.this;
                new NdefMessage(new NdefRecord[]{input_Kode_Wisata.createRecord(input_Kode_Wisata.userData.getBytes())});
                try {
                    Ndef mNdef3 = Ndef.get(Input_Kode_Wisata.this.mTag);
                    if (mNdef3 != null) {
                        mNdef3.connect();
                        mNdef3.writeNdefMessage(new NdefMessage(new NdefRecord(0, (byte[]) null, (byte[]) null, (byte[]) null), new NdefRecord[0]));
                        mNdef3.close();
                    } else {
                        Toast.makeText(Input_Kode_Wisata.this.getApplicationContext(), "Penulisan data gagal", 0).show();
                    }
                } catch (FormatException | IOException e) {
                }
                new SweetAlertDialog(Input_Kode_Wisata.this, 2).setTitleText("Info").setContentText("Kode Wisata Berhasil Terhapus! ").show();
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
            this.mTag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            new SweetAlertDialog(this, 0).setTitleText("Info").setContentText("Tag Wisata Terdeteksi !").show();
            NdefMessage[] messages = getNdefMessage(intent);
            if (messages == null) {
                Toast.makeText(getApplicationContext(), "Data di dalam kartu kosong", 0).show();
            } else {
                this.userData = new String(messages[0].getRecords()[0].getPayload());
            }
        } else {
            Toast.makeText(getApplicationContext(), "Undefined smartcard", 0).show();
        }
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

    /* access modifiers changed from: private */
    public NdefRecord createRecord(byte[] payload) {
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
}

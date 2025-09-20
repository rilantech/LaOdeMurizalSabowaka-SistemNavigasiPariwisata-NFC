package com.example.aplikasiwisatawan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserActivity extends AppCompatActivity {
    private Button btnLogout;
    /* access modifiers changed from: private */
    public PreferenceHelper preferenceHelper;
    private TextView tvNama;
    private TextView tvUsername;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((int) R.layout.activity_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new UserActivity$$ExternalSyntheticLambda0());
        this.preferenceHelper = new PreferenceHelper(this);
        this.tvNama = (TextView) findViewById(R.id.tvNama);
        this.tvUsername = (TextView) findViewById(R.id.tvUsername);
        this.btnLogout = (Button) findViewById(R.id.btnLogout);
        this.tvNama.setText("Welcome " + this.preferenceHelper.getNama());
        this.tvUsername.setText("Username : " + this.preferenceHelper.getUsername());
        this.btnLogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UserActivity.this.preferenceHelper.putIsLogin(false);
                Intent intent = new Intent(UserActivity.this, LoginActivity.class);
                intent.addFlags(268468224);
                UserActivity.this.startActivity(intent);
                UserActivity.this.finish();
            }
        });
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View v, WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    }
}

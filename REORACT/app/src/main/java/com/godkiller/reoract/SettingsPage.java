package com.godkiller.reoract;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import es.dmoral.toasty.Toasty;

public class SettingsPage extends AppCompatActivity {

    public Button Logout;
        public Button repo;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);

        mAuth = FirebaseAuth.getInstance();

        Logout = findViewById(R.id.logout);
        repo = findViewById(R.id.report);

        Logout.setOnClickListener(view -> out());

        repo.setOnClickListener(v -> {
            Intent i = new Intent(SettingsPage.this,Feedback.class);
            startActivity(i);
        });
    }
    public void out()
    {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(),LoginPage.class);
        Toasty.success(SettingsPage.this, "Logged Out.",Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}

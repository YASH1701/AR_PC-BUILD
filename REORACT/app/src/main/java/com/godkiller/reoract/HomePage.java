package com.godkiller.reoract;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomePage extends AppCompatActivity {

    public Button Start,History,Exit,Settings;
    public TextView Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        Exit = findViewById(R.id.exit);
        Settings = findViewById(R.id.settings);
        Start = findViewById(R.id.start);
        History = findViewById(R.id.uhistory);
        Name = findViewById(R.id.name);

        if(user != null)
        {
            Name.append("Welcome, Mr." + Html.fromHtml("<br>") + user.getDisplayName());
        }
        Start.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this,ComponentSelection.class);
            startActivity(intent);
        });
        History.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this,PreviousBuilds.class);
            startActivity(intent);
        });
        Settings.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this,SettingsPage.class);
            startActivity(intent);
        });
        Exit.setOnClickListener(view -> finish());
    }

}
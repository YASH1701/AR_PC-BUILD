package com.godkiller.reoract;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PreviousBuilds extends AppCompatActivity {

    ImageButton hist1;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_builds);

        hist1 = findViewById(R.id.imageButton);

        ComponentSelection c = new ComponentSelection();

            hist1.setVisibility(View.INVISIBLE);
            hist1.setVisibility(View.VISIBLE);

        hist1.setOnClickListener(view -> {

            Intent i = new Intent(PreviousBuilds.this,links.class);
            startActivity(i);

        });
    }
}

package com.godkiller.reoract;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import es.dmoral.toasty.Toasty;
import static java.lang.Thread.sleep;

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;

    public TextView Lg;
    public TextView Incorrect;
    public TextView FirstName;
    public TextView LastName;
    public Button Reg;
    public EditText Email;
    public EditText Password;
    public EditText C_Password;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        Email = findViewById(R.id.remail);
        Password = findViewById(R.id.rlpass);
        C_Password = findViewById(R.id.cpass);
        Lg = findViewById(R.id.lg);
        Incorrect = findViewById(R.id.incorrect);
        Reg = findViewById(R.id.reg);
        FirstName = findViewById(R.id.fname);
        LastName = findViewById(R.id.lname);

        mAuth = FirebaseAuth.getInstance();

        Lg.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),LoginPage.class);
            finish();
            startActivity(intent);
        });

        Reg.setOnClickListener(view -> {
            if(FirstName.getText().toString().isEmpty() || LastName.getText().toString().isEmpty() || Email.getText().toString().isEmpty() || Password.getText().toString().isEmpty() || C_Password.getText().toString().isEmpty() )
            {
                Incorrect.setText("Please fill all details");
            }
            else
            {
                if(C_Password.getText().toString().equals(Password.getText().toString()))
                {
                    OnRegister(view);
                }
                else
                {
                    Incorrect.setText("Please check your password");
                }

            }
        });


    }
    public void OnRegister(View view)
    {
        mAuth.createUserWithEmailAndPassword(Email.getText().toString(),Password.getText().toString())
                .addOnCompleteListener(Register.this, task -> {
                    if (task.isSuccessful())
                    {
                        Log.i("TAG", "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toasty.success(Register.this, "Registration Successful.",Toast.LENGTH_LONG).show();
                        try {
                            Info();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else
                     {
                        Log.i("TAG", "createUserWithEmail:failure", task.getException());
                        Toasty.error(Register.this, "Registration failed.",Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void Info() throws InterruptedException {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(FirstName.getText().toString() + " " + LastName.getText().toString())
                .build();

        user.updateProfile(profileUpdates)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.d("TAG", "User profile updated.");
                    }
                });
        sleep(200);
        Intent intent = new Intent(getApplicationContext(),HomePage.class);
        finish();
        startActivity(intent);
    }
}

package com.godkiller.reoract;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import es.dmoral.toasty.Toasty;

public class  LoginPage extends AppCompatActivity {

    public EditText Email;
    public EditText Password;
    public Button Login;
    public ImageButton showhide;
    public TextView Info;
    public TextView Rege;
    public int count = 0;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        if(currentUser != null)
        {
            Intent intent = new Intent(LoginPage.this,HomePage.class);
            finish();
            startActivity(intent);
        }
    }

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        Email = findViewById(R.id.lemail);
        Password = findViewById(R.id.rlpass);
        Login = findViewById(R.id.login);
        Info = findViewById(R.id.inpass);
        Rege = findViewById(R.id.rege);
        showhide = findViewById(R.id.sh);


        mAuth = FirebaseAuth.getInstance();

        showhide.setOnClickListener(view -> {
            if(count == 0)
            {
                    Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    showhide.setImageResource(R.drawable.ic_iconfinder___eye_show_view_watch_see_disable_inactive_unavailable_off_3844443);
                    count = 1;
            }
            else
            {
                Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                showhide.setImageResource(R.drawable.ic_iconfinder_eye_24_103177);
                count = 0;
            }
        });

        Login.setOnClickListener(view -> {

            final String remail = Email.getText().toString();
            final String rpass = Password.getText().toString();
            if(remail.isEmpty() || rpass.isEmpty())
            {
                Info.setText("Please fill all Details");
            }
            else
            {
                OnLogin(view);
            }

        });

        Rege.setOnClickListener(view -> {
            Intent intent = new Intent(LoginPage.this,Register.class);
            finish();
            startActivity(intent);
        });
    }


    public void OnLogin(View view)
    {
        mAuth.signInWithEmailAndPassword(Email.getText().toString(),Password.getText().toString())
                .addOnCompleteListener(LoginPage.this, task -> {
                    if (task.isSuccessful())
                    {
                        Log.i("TAG", "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toasty.success(LoginPage.this, "Authentication Successful.",
                                Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginPage.this,HomePage.class);
                        finish();
                        startActivity(intent);
                        updateUI(user);
                    }
                    else
                    {
                        Log.i("TAG", "signInWithEmail:failure", task.getException());
                        Info.setText("Incorrect Credentials");
                        Toasty.error(LoginPage.this, "Authentication failed.", Toast.LENGTH_LONG).show();
                        updateUI(null);
                    }
                });
    }
}

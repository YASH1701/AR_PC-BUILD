package com.godkiller.reoract;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import es.dmoral.toasty.Toasty;

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

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //Toast.makeText(this,"Already Logged In",Toast.LENGTH_LONG).show();
    }

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

        Lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginPage.class);
                finish();
                startActivity(intent);
            }
        });

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            }
        });


    }
   //changing some code here
    /* public void OnRegister(View view)
    {
        mAuth.createUserWithEmailAndPassword(Email.getText().toString(),Password.getText().toString())
                .addOnCompleteListener(Register.this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Log.i("TAG", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(getApplicationContext(),LoginPage.class);
                            Toasty.success(Register.this, "Registration Successful.",
                                    Toast.LENGTH_LONG).show();
                            startActivity(intent);
                        }
                        else
                         {
                            Log.i("TAG", "createUserWithEmail:failure", task.getException());
                            Toasty.error(Register.this, "Registration failed.",
                            Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}*/
    //Correct Code without errors
     public void OnRegister(View view)
    {
        mAuth.createUserWithEmailAndPassword(Email.getText().toString(),Password.getText().toString())
                .addOnCompleteListener(Register.this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Log.i("TAG", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(getApplicationContext(),LoginPage.class);
                            Toasty.success(Register.this, "Registration Successful.",
                                    Toast.LENGTH_LONG).show();
                            startActivity(intent);
                        }
                        else
                         {
                            Log.i("TAG", "createUserWithEmail:failure", task.getException());
                            Toasty.error(Register.this, "Registration failed.",
                            Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}

package com.example.shopsfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    Button loginbtn;
    TextView btnsignup;
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        loginbtn=findViewById(R.id.Loginbutton);
        email=findViewById(R.id.emailetlogin);
        password=findViewById(R.id.loginPassword);
        btnsignup=findViewById(R.id.signuplinktextview);

        firebaseAuth=FirebaseAuth.getInstance();
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SignUpPage.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void login()
    {
        String emailstr=email.getText().toString();
        String passwordstr=password.getText().toString();
        if(emailstr.isEmpty() || passwordstr.isEmpty())
        {
            Toast.makeText(LoginPage.this,"Email or password cannot be empty",Toast.LENGTH_SHORT).show();
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(emailstr,passwordstr).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(LoginPage.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(LoginPage.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
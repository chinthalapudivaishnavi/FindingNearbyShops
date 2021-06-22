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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpPage extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firestore;
    Button signupbtn;
    TextView btnlogin;
    String emailstr,passwordstr,confirmpassstr,lastnamestr,firstnamestr,mobilenumstr,userID;
    EditText email,password,confirmPassword,lastnameet,firstnameet,mobilenumet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        signupbtn=findViewById(R.id.Signupbutton);
        email=findViewById(R.id.emailetsignup);
        password=findViewById(R.id.signupPassword);
        confirmPassword=findViewById(R.id.signupconfirmPassword);
        btnlogin=findViewById(R.id.logilinktextview);
        lastnameet=findViewById(R.id.lastnameid);
        firstnameet=findViewById(R.id.firstnameid);
        mobilenumet=findViewById(R.id.mobilenumid);

        firebaseAuth=FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUser();
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginPage.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void signUpUser()
    {
        emailstr=email.getText().toString();
        passwordstr=password.getText().toString();
        confirmpassstr=confirmPassword.getText().toString();
        lastnamestr=lastnameet.getText().toString();
        firstnamestr=firstnameet.getText().toString();
        mobilenumstr=mobilenumet.getText().toString();

        if(emailstr.isEmpty() || passwordstr.isEmpty() || confirmpassstr.isEmpty()) {
            Toast.makeText(SignUpPage.this, "Email and passwrod can't be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!(passwordstr.equals(confirmpassstr)))
        {
            Toast.makeText(SignUpPage.this,"Password and Confirm password not matches",Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(emailstr,passwordstr).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(SignUpPage.this,"SignUp Successfully",Toast.LENGTH_SHORT).show();

                    userID=firebaseAuth.getCurrentUser().getUid();
                    DocumentReference documentReference=firestore.collection("users").document(userID);
                    Map<String,Object> user=new HashMap<>();
                    user.put("first_name",firstnamestr);
                    user.put("last_name",lastnamestr);
                    user.put("email",emailstr);
                    user.put("mobile_number",mobilenumstr);

                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(SignUpPage.this, "your data stored in firestore", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull @org.jetbrains.annotations.NotNull Exception e) {
                            Toast.makeText(SignUpPage.this, "Something wrong may be your internet is turn off.!!", Toast.LENGTH_SHORT).show();
                        }
                    });

                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(SignUpPage.this,"Signup Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
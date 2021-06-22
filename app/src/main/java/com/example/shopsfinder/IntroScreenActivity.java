package com.example.shopsfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class IntroScreenActivity extends AppCompatActivity {

    Button getstartedbtn;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);

        getstartedbtn=findViewById(R.id.getstartedbtnid);
        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null)
        {
            Toast.makeText(this, "user is already logged in...!", Toast.LENGTH_SHORT).show();
            redirectToMain();
        }

        getstartedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginPage.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void redirectToMain()
    {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

}
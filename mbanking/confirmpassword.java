package com.example.mbanking;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class confirmpassword extends AppCompatActivity {
 TextView t6;
 EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmpassword);
        t6=(TextView)findViewById(R.id.t6);
        e1=findViewById(R.id.e12);
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i2);
            }
        });

    }
    public void createAccount(View view) {
        String s=e1.getText().toString();
        if(s.length()==0){
            e1.setError("This field cannot be empty.");
            return;
        }
        if(!s.equals(signupMbanking.pwd)){
            e1.setError("Password mismatch");
            return;
        }

        DataBaseHandler db = new DataBaseHandler(this);
        db.addContact(new Contact(signupMbanking.username, signupMbanking.pwd));

        Intent i=new Intent(getApplicationContext(),HomePage.class);
        startActivity(i);
    }
}

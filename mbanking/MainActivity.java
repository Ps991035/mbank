package com.example.mbanking;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
 Button b2,b1;
 TextView t1;
 EditText user,pass;
 String getuserid,getpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DataBaseHandler db = new DataBaseHandler(this);
        b1=(Button)findViewById(R.id.b1);
        t1=(TextView)findViewById(R.id.t1);
        b2=(Button)findViewById(R.id.b2);
        user=(EditText)findViewById(R.id.e1);
        pass=(EditText)findViewById(R.id.e2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getuserid=user.getText().toString();
                getpass=pass.getText().toString();
                if(TextUtils.isEmpty(getuserid)){
                    user.setError("This field cannot be empty...");
                    return;
                }
                    //Toast.makeText(MainActivity.this, "Name is Empty", Toast.LENGTH_SHORT).show();
                else if(TextUtils.isEmpty(getpass)){
                    pass.setError("This field cannot be empty...");
                    return;
                }
                    //Toast.makeText(MainActivity.this, "Password Recquired", Toast.LENGTH_SHORT).show();
                else if(getpass.length()!=4){
                    pass.setError("Password must be 4 digit number");
                    return;
                }
                    //Toast.makeText(MainActivity.this, "Password Length must be 4", Toast.LENGTH_SHORT).show();

                ArrayList<Contact> contacts = db.getAllContacts(getuserid);
                if(contacts.size()==0){
                    user.requestFocus();
                    user.setError("You are not registered...");
                    return;
                }
                if(!contacts.get(0)._phone_number.equals(getpass)){
                    pass.requestFocus();
                    pass.setError("Wrong Password");
                    return;
                }

                Intent i=new Intent(getApplicationContext(),HomePage.class);
                startActivity(i);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),signupMbanking.class);
                startActivity(i);
            }

        });
 t1.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         //Intent i=new Intent(getApplicationContext(),HomePage.class);
         //startActivity(i);

         if(TextUtils.isEmpty(user.getText().toString())){
             user.setError("Enter your userid..");
             //Toast.makeText(MainActivity.this, "forgot clicked", Toast.LENGTH_SHORT).show();
             return;
         }
         ArrayList<Contact> contacts = db.getAllContacts(user.getText().toString());
         if(contacts.size()==0){
             user.requestFocus();
             user.setError("You are not registered...");
             //Toast.makeText(MainActivity.this, "forgot clicked", Toast.LENGTH_SHORT).show();
             return;
         }
         Toast.makeText(MainActivity.this, "Your password : "+contacts.get(0)._phone_number, Toast.LENGTH_LONG).show();
     }
 });
    }

}

package com.example.mbanking;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    public static int balance=0;
    public static int type=0;
    public static ArrayList<Integer>barray=new ArrayList<>();
    public static ArrayList<String>typearray=new ArrayList<>();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);



        TextView tvname=findViewById(R.id.tvname);
        tvname.setText(signupMbanking.name1);
        intent=new Intent(this,Balance.class);
    }

    public void onBackPressed() {
        //Display alert message when back button has been pressed
        //backButtonHandler();
        finish();
        moveTaskToBack(true);
        return;
    }


    public void checkbalance(View view) {
        type=0;
        startActivity(intent);
    }

    public void lasttransactions(View view) {
        type=1;
        startActivity(intent);
    }

    public void depositbalance(View view) {
        type=2;
        startActivity(intent);
    }

    public void withdrawamount(View view) {
        type=3;
        startActivity(intent);
    }

    public void locatemap(View view) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=Atm");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void supportfun(View view) {
        Intent i= new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL,new String []{"manasgupta@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT,"Help");
        i.putExtra(Intent.EXTRA_TEXT,"Write your query...");
        i.setType("message/rfc822");
        startActivity(Intent.createChooser(i,"CHOOSE"));
    }

    public void logoutfun(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}

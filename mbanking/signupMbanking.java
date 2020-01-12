package com.example.mbanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class signupMbanking extends AppCompatActivity {
    public static String pwd,username;public static String name1;
  Button b3;
  TextView t5;
  EditText password,name,age,mobile,email,dob,accno,userid;
  String validpass,names,ages,radio1,radio2,mobiles,emails,dobs,accnos,userids;
  RadioGroup rg;
  RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_mbanking);
        b3 = (Button) findViewById(R.id.b3);
        t5 = (TextView) findViewById(R.id.t5);
        password = (EditText) findViewById(R.id.e11);
        name = (EditText) findViewById(R.id.e3);
        age = (EditText) findViewById(R.id.e4);
        mobile = (EditText) findViewById(R.id.e6);
        email = (EditText) findViewById(R.id.e7);
        dob = (EditText) findViewById(R.id.e8);
        accno = (EditText) findViewById(R.id.e9);
        userid = (EditText) findViewById(R.id.e10);
        rg = (RadioGroup) findViewById(R.id.radiogroup1);


//        void fun(View v){
//            public void onCheckedChanged (RadioGroup group,int checkedId){
//                switch (checkedId) {
//                    case R.id.r1:
//                        Toast.makeText(signupMbanking.this, "Male ", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.r2:
//                        Toast.makeText(signupMbanking.this, "Female", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//            }
//        }

    }

    public void loginfun(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }


    public void buttonvalidate(View v){
        int index = rg.indexOfChild(findViewById(rg.getCheckedRadioButtonId()));
        //Toast.makeText(this, ""+index, Toast.LENGTH_SHORT).show();
        String s;
        s=name.getText().toString();
        name1=s;
        int space=0,s1=0,c1=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ') space++;
            if(s.charAt(i)>64&&s.charAt(i)<91) c1++;
            if(s.charAt(i)>96&&s.charAt(i)<123) s1++;
        }
        if(s.length()==0){
            name.setError("This field cannot be empty.");
            return;
        }
        if(space+c1+s1!=s.length()){
            name.setError("Enter valid name.");
            return;
        }
        s=age.getText().toString();
        c1=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>47&&s.charAt(i)<58) c1++;
        }
        if(s.length()==0){
            age.setError("This field cannot be empty.");
            return;
        }
        if(s.length()!=c1||(Integer.parseInt(s)<18||Integer.parseInt(s)>90)){
            //Toast.makeText(this, "You are not eligible to open bank acount", Toast.LENGTH_SHORT).show();
            //age.setFocusable(true);
            age.setError("Not eligible.");
            return;
        }

        s=mobile.getText().toString();
        c1=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>47&&s.charAt(i)<58) c1++;
        }
        if(s.length()==0){
            mobile.setError("This field cannot be empty.");
            return;
        }
        if(s.length()!=c1||s.length()!=10){
            //Toast.makeText(this, "You are not eligible to open bank acount", Toast.LENGTH_SHORT).show();
            //age.setFocusable(true);
            mobile.setError("Enter valid number");
            return;
        }

        s=email.getText().toString();
        c1=s.indexOf('@');
        if(s.length()==0){
            email.setError("This field cannot be empty.");
            return;
        }
        //Toast.makeText(this, s.substring(c1,s.length()), Toast.LENGTH_SHORT).show();
        if(c1==-1||!s.substring(c1+1,s.length()).equals("gmail.com")||c1<4){
            //Toast.makeText(this, "You are not eligible to open bank acount", Toast.LENGTH_SHORT).show();
            //age.setFocusable(true);
            email.setError("Enter valid email ID");
            return;
        }

        s=dob.getText().toString();
        if(s.length()==0){
            dob.setError("This field cannot be empty.");
            return;
        }
        int[]a={-1,-1};
        c1=0;
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)=='/'||s.charAt(i)=='-'||s.charAt(i)=='.')&&c1<2){
                a[c1]=i;
                c1++;
            }
        }
        try{
            //Toast.makeText(this, s.substring(0,a[0])+" "+s.substring(a[0]+1,a[1])+" "+s.substring(a[1]+1,s.length()), Toast.LENGTH_SHORT).show();
            int d=Integer.parseInt(s.substring(0,a[0]));
            int m=Integer.parseInt(s.substring(a[0]+1,a[1]));
            int y=Integer.parseInt(s.substring(a[1]+1,s.length()));
            //Toast.makeText(this, ""+d+" "+m+" "+y, Toast.LENGTH_SHORT).show();
            if(d<1||d>31||m<1||m>12||y>2001||y<1919){
                dob.setError("Enter valid DD-MM-YYYY.");
                return;
            }
        }
        catch (Exception e){
            dob.setError("Enter valid date.");
            return;
        }

        s=accno.getText().toString();
        if(s.length()==0){
            accno.setError("This field cannot be empty.");
            return;
        }
        if(s.length()<8||s.length()>15){
            accno.setError("Enter valid Ac no.");
            return;
        }

        s=userid.getText().toString();
        if(s.length()==0){
            userid.setError("This field cannot be empty.");
            return;
        }
        c1=0;s1=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>47&&s.charAt(i)<58) c1++;
            if(s.charAt(i)>96&&s.charAt(i)<123) s1++;
        }
        if(c1+s1!=s.length()||s.length()<8||s.length()>15||(s.charAt(0)>47&&s.charAt(0)<58)){
            userid.setError("Invalid username.");
            return;
        }
        username=userid.getText().toString();

        s=password.getText().toString();
        if(s.length()==0){
            password.setError("This field cannot be empty.");
            return;
        }
        if(s.length()!=4){
            password.setError("Enter 4 digit number.");
            return;
        }
        pwd=s;
        Intent intent=new Intent(this,confirmpassword.class);
        startActivity(intent);
    }


}

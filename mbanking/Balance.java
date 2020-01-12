package com.example.mbanking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Balance extends AppCompatActivity {
    TextView tv1;
    EditText et1;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        tv1=findViewById(R.id.tv1);
        et1=findViewById(R.id.et1);
        btn1=findViewById(R.id.btn1);
        if(HomePage.type<2){
            et1.setVisibility(View.INVISIBLE);
            btn1.setVisibility(View.INVISIBLE);
        }
        else{
            //tv1.setVisibility(View.INVISIBLE);
        }
        if(HomePage.type==0){
            tv1.setText("Balance : "+HomePage.balance);
        }
        else if(HomePage.type==1){
            int l=HomePage.barray.size();
            if(l==0){
                tv1.setText("No Transactions\nDone Yet");
            }
            else if(l>4){
                String s="";
                for(int i=0;i<5;i++){
                    s=s+HomePage.typearray.get(l-5+i)+" : "+HomePage.barray.get(l-5+i)+"\n";
                }
                tv1.setText(s);
            }
            else{
            String s="";
            for(int i=0;i<HomePage.barray.size();i++){
                    s=s+HomePage.typearray.get(i)+" : "+HomePage.barray.get(i)+"\n";
                }
                tv1.setText(s);
            }
        }
        else if(HomePage.type==2){
            btn1.setText("Desposit");
        }
        else{
            btn1.setText("Withdraw");
        }

    }


    public void fun(View view) {
        if(HomePage.type==2){
            try{
                int a=Integer.parseInt(et1.getText().toString());
                if(a<=0||a>100000){
                    et1.setError("Enter valid amount");
                    return;
                }
                HomePage.balance+=a;
                HomePage.barray.add(a);
                HomePage.typearray.add("Credit");
                tv1.setText("Balance deposited "+a);
                et1.setText("");
            }
            catch (Exception e){
                et1.setError("Invalid amount");
            }
        }
        else{
            try{
                int a=Integer.parseInt(et1.getText().toString());
                if(a<100||a>25000||a%100!=0){
                    et1.setError("Enter valid amount");
                    return;
                }
                if(a>HomePage.balance){
                    et1.setError("Insufficient balance");
                    return;
                }
                HomePage.balance-=a;
                HomePage.barray.add(a);
                HomePage.typearray.add("Dedit");
                tv1.setText("Balance debited "+a);
                et1.setText("");
            }
            catch (Exception e){
                et1.setError("Invalid amount");
            }
        }
    }
}


















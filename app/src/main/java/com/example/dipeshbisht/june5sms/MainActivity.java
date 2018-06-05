package com.example.dipeshbisht.june5sms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;
import java.util.ArrayList;

class Student {

        String names;
        String address,college;
        long contact;

        Student(String names,String address,String college,long contact)
        {
            this.names=names;
            this.address=address;
            this.college=college;
            this.contact=contact;
        }

    }

public class MainActivity extends AppCompatActivity {

    Button obj1,obj2;
    EditText ob1,ob2,ob3,ob4;
    TextView obj;
    ArrayList<Student> al=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        obj1=findViewById(R.id.btn1);
        obj2=findViewById(R.id.btn2);
        ob1=findViewById(R.id.edit1);
        ob2=findViewById(R.id.edit2);
        ob3=findViewById(R.id.edit3);
        ob4=findViewById(R.id.edit4);
        obj=findViewById(R.id.txt1);

        obj1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names= String.valueOf(ob1.getText());
                long contact=0;
                try{
                    contact=Long.parseLong(String.valueOf(ob2.getText()));
                }
                catch(NumberFormatException e){


                    Toast.makeText(getApplicationContext(),"Enter a valid phone number",Toast.LENGTH_SHORT).show();

                }


                String college=String.valueOf(ob3.getText());
                String address=String.valueOf(ob4.getText());
                al.add(new Student(names,address,college,contact));


            }
        });


        obj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i=0;i<al.size();i++) {


                    obj.setText(obj.getText()+al.get(i).names+"\n");
                    obj.setText(obj.getText()+al.get(i).address+"\n");
                    obj.setText(obj.getText()+al.get(i).college+"\n");

                    obj.setText(obj.getText()+""+al.get(i).contact+"\n"+"************\n");
                }
            }
        });



    }
}

package com.example.voterapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Registration extends AppCompatActivity {
EditText name,email,age;
Button clr,sbt;
DBHelper db;

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Log.d("Govind","BackPressed Called");

        AlertDialog.Builder exit=new AlertDialog.Builder(Registration.this);
        exit.setTitle("Confirm Exit");
        exit.setIcon(R.drawable.exit_app);
        exit.setMessage("are you sure you want to exit");

        exit.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        exit.setNegativeButton("No",null);
        exit.show();    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        age=findViewById(R.id.age);
        clr=findViewById(R.id.clear);
        sbt=findViewById(R.id.submit);
        db=new DBHelper(this);

        //clear button action
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText(null);
                email.setText(null);
                age.setText(null);
            }
        });

        //submit button action
        sbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n=name.getText().toString().trim();
                String e=email.getText().toString().trim();
                String a=age.getText().toString().trim();

                if(n.equals("")||e.equals("")||a.equals("")){
                    Toast.makeText(Registration.this,"plaese fill all details",Toast.LENGTH_SHORT).show();
                }else{

                    int ages = Integer.parseInt(a);

                    if (ages>= 18) {

                        boolean insert = db.insertdata(n, e, a);

                        if (insert == true) {

                            Toast.makeText(Registration.this, "Registration Completed", Toast.LENGTH_SHORT).show();
                            Intent inet=new Intent(Registration.this, MainActivity.class);
                            startActivity(inet);

                        }

                    }else{

                        Toast.makeText(Registration.this,"You are not eligible for voting",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });









    }
}
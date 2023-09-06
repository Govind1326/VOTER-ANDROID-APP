package com.example.voterapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bjpbtn,cgsbtn,notabtn;

    Result dbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding the component by id
        bjpbtn=findViewById(R.id.bjpbtn);
        cgsbtn=findViewById(R.id.cgsbtn);
        notabtn=findViewById(R.id.nota);
        dbr=new Result(this);


        bjpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cgsbtn.setVisibility(view.INVISIBLE);
                bjpbtn.setVisibility(view.INVISIBLE);
                notabtn.setVisibility(view.INVISIBLE);
                Intent inet=new Intent(MainActivity.this,Result_Exit.class);
                startActivity(inet);

                //vote method by database
                boolean insert = dbr.insertvote("1","0");
                Toast.makeText(MainActivity.this, "You voted to BJP", Toast.LENGTH_SHORT).show();

            }
        });

        cgsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cgsbtn.setVisibility(view.INVISIBLE);
                bjpbtn.setVisibility(view.INVISIBLE);
                notabtn.setVisibility(view.INVISIBLE);

                Intent inet=new Intent(MainActivity.this,Result_Exit.class);
                startActivity(inet);

                boolean insert = dbr.insertvote("0","1");
                Toast.makeText(MainActivity.this, "You voted to CONGRESS", Toast.LENGTH_SHORT).show();

            }
        });

        notabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cgsbtn.setVisibility(view.INVISIBLE);
                bjpbtn.setVisibility(view.INVISIBLE);
                notabtn.setVisibility(view.INVISIBLE);
                Intent inet=new Intent(MainActivity.this,Result_Exit.class);
                startActivity(inet);

//                boolean insert = dbr.insertvote(null,null);
                Toast.makeText(MainActivity.this, "You voted to No one", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
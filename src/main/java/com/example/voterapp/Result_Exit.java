package com.example.voterapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Result_Exit extends AppCompatActivity {

    Button btn,res;
    Result dbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_exit);
    btn=findViewById(R.id.button);
    res=findViewById(R.id.result);
    dbr=new Result(this);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent inet=new Intent(Result_Exit.this,Registration.class);
            startActivity(inet);
        }
    });

    res.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Cursor cdata = dbr.view_data();

        if(cdata.getCount()>=1){

            StringBuffer buffer=new StringBuffer();
            while(cdata.moveToNext()) {
                buffer.append("BJP Vote : " + cdata.getString(0)+"\n\n");
                buffer.append("CONGRESS Vote : " + cdata.getString(1)+"\n\n");
                int B=Integer.parseInt(cdata.getString(0));
                int C=Integer.parseInt(cdata.getString(1));

                if(B>C){
                    buffer.append("BJP is Leading ! ");
                }else if(C>B){
                    buffer.append("Congress is Leading !");
                }else{
                    buffer.append("Both are Equal!");
                }

            }
            AlertDialog.Builder build=new AlertDialog.Builder(Result_Exit.this);
            build.setCancelable(true);
            build.setTitle("Voting Result");
            build.setIcon(R.drawable.result);
            build.setMessage(buffer.toString());
            build.show();
        }
        }
    });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        Intent tent=new Intent(Result_Exit.this,Registration.class);
//        startActivity(tent);
        Log.d("Govind","BackPressed Called");

        AlertDialog.Builder exit=new AlertDialog.Builder(Result_Exit.this);
        exit.setTitle("Confirm Exit");
        exit.setIcon(R.drawable.exit_app);
        exit.setMessage("are you sure you want to exit");

        exit.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                Intent tent=new Intent(Result_Exit.this,Registration.class);
                startActivity(tent);
        Toast.makeText(Result_Exit.this,"You Redirect To Registratoin Page",Toast.LENGTH_LONG).show();
            }
        });
        exit.setNegativeButton("No",null);
        exit.show();
    }
}
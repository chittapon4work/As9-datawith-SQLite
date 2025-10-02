package com.example.as9;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class Viewdata extends AppCompatActivity {


    DBhelper dbh;
    Cursor student;
    TextView tvshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_viewdata);

        dbh = new DBhelper(this);
        student = dbh.getStudent();
        tvshow = findViewById(R.id.txtvivew);
        if(student.getCount() == 0){
            showinfo("Massage","No Data");
        }else {
            StringBuffer datbuff = new StringBuffer();
            while (student.moveToNext()){
                datbuff.append("รหัส :" +student.getString(0)+"\n");
                datbuff.append("ชื่อ :" +student.getString(1)+"\n");
                datbuff.append("นามสกุล :" +student.getString(2)+"\n");
                datbuff.append("อายุ :" +student.getString(3)+"\n");
                datbuff.append("เบอร์โทร :" +student.getString(4)+"\n");
                datbuff.append("อีเมล :" +student.getString(5)+"\n");
                datbuff.append("คณะ :" +student.getString(6)+"\n");
                datbuff.append("--------------------------------------------"+"\n");

            }
            tvshow.setMovementMethod(new ScrollingMovementMethod());
            tvshow.setTextColor(Color.parseColor("344F1F"));
            tvshow.setText("รายชื่อนักศึกษา\n"+datbuff);
        }
    }
    public void showinfo(String title,String msg) {
        AlertDialog.Builder show = new AlertDialog.Builder(this);
        show.setCancelable(true);
        show.setTitle(title);
        show.setMessage(msg);
        show.show();
    }
    public void clickhome(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
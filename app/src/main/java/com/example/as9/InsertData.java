package com.example.as9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class InsertData extends AppCompatActivity {
    EditText edtName,edtLname,edtAge,edtTel,edtEmail,edtFac;
    DBhelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_insert_data);
        dbhelper = new DBhelper(this);
        edtName = findViewById(R.id.edtname);
        edtLname = findViewById(R.id.edtlname);
        edtAge = findViewById(R.id.edtage);
        edtTel = findViewById(R.id.edttel);
        edtEmail = findViewById(R.id.edtemail);
        edtFac = findViewById(R.id.edtfac);
    }
    public void clickSubmit(View view){
        int numage = Integer.parseInt(edtAge.getText().toString());
        boolean isData = dbhelper.insertData(edtName.getText().toString(),edtLname.getText().toString(),numage,edtTel.getText().toString(),edtEmail.getText().toString(),edtFac.getText().toString());
        if(isData){
            ClearText();
            showinfo("Message","เพิ่มข้อมูลสำเร็จ");
        }else{
            showinfo("Message","ไม่สามารถเพิ่มข้อมูลได้");
        }
    }
    public void ClearText(){
        edtName.setText("");
        edtLname.setText("");
        edtAge.setText("");
        edtTel.setText("");
        edtEmail.setText("");
        edtFac.setText("");
    }
    public void showinfo(String title,String msg) {
        AlertDialog.Builder show = new AlertDialog.Builder(this);
        show.setCancelable(true);
        show.setTitle(title);
        show.setMessage(msg);
        show.show();
    }
    public void clickhome(View view){
        Intent clickhome = new Intent(this, MainActivity.class);
        startActivity(clickhome);
    }
}
package com.example.as9;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class editData extends AppCompatActivity {
    EditText edtName,edtLname,edtAge,edtTel,edtEmail,edtFac,edtId;
    DBhelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_data);

        dbhelper = new DBhelper(this);
        edtName = findViewById(R.id.edtname);
        edtLname = findViewById(R.id.edtlname);
        edtAge = findViewById(R.id.edtage);
        edtTel = findViewById(R.id.edttel);
        edtEmail = findViewById(R.id.edtemail);
        edtFac = findViewById(R.id.edtfac);
        edtId = findViewById(R.id.edtid);
    }
    public void clickSearch(View view){
        int id = Integer.parseInt(edtId.getText().toString());
        Cursor searchid = dbhelper.searchID(id);
        if (!searchid.moveToFirst()){
            showinfo("Message","ไม่พบข้อมูล");
        }else {
            edtName.setText(searchid.getString(1));
            edtLname.setText(searchid.getString(2));
            edtAge.setText(searchid.getString(3));
            edtTel.setText(searchid.getString(4));
            edtEmail.setText(searchid.getString(5));
            edtFac.setText(searchid.getString(6));
        }
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
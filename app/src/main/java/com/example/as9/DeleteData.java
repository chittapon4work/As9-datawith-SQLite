package com.example.as9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DeleteData extends AppCompatActivity {
    EditText edtid;
    DBhelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete_data);

        dbhelper = new DBhelper(this);
        edtid = findViewById(R.id.edtid);
    }
    public void clickhome(View view){
        Intent clickhome = new Intent(this, MainActivity.class);
        startActivity(clickhome);
    }
    public void bttDelete(View view){
        int id = Integer.parseInt(edtid.getText().toString());
        int isDelete = dbhelper.deleteID(id);
        if (isDelete > 0){
            showinfo("Message","สำเร็จ");
            edtid.setText("");
        }else {
            showinfo("Message","ไม่สำเร็จ");
        }
    }
    public void showinfo(String title,String msg) {
        AlertDialog.Builder show = new AlertDialog.Builder(this);
        show.setCancelable(true);
        show.setTitle(title);
        show.setMessage(msg);
        show.show();
    }
}
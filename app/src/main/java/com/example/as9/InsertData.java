package com.example.as9;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class InsertData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_insert_data);
    }
    public void clickhome(View view){
        Intent clickhome = new Intent(this, MainActivity.class);
        startActivity(clickhome);
    }
}
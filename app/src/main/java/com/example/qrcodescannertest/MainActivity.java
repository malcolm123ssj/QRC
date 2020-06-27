package com.example.qrcodescannertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView normalscan1;
    private TextView encryptedscan1;
    private ImageView normalscanimage;
    private ImageView encryptedscanimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        normalscan1 = (TextView) findViewById(R.id.normalscan);
        encryptedscan1 = (TextView) findViewById(R.id.encryptedscan);
        encryptedscanimage = (ImageView) findViewById(R.id.qrencoded);
        normalscanimage = (ImageView) findViewById(R.id.qr);

        normalscan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Scanner = new Intent(getApplicationContext(), NormalScanner.class);
                startActivity(Scanner);
            }
        });
        normalscanimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Scanner = new Intent(getApplicationContext(), NormalScanner.class);
                startActivity(Scanner);
            }
        });
        encryptedscan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Scanner = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(Scanner);
            }
        });
        encryptedscanimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Scanner = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(Scanner);
            }
        });
    }
}
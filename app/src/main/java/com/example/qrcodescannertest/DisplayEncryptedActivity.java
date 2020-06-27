package com.example.qrcodescannertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

public class DisplayEncryptedActivity extends AppCompatActivity {
    TextView receiver_msg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayencryptedactivity);

        receiver_msg1 = (TextView)findViewById(R.id.received_value_id1);
        Linkify.addLinks(receiver_msg1, Linkify.PHONE_NUMBERS | Linkify.WEB_URLS);
        receiver_msg1.setMovementMethod(LinkMovementMethod.getInstance());

        Intent intent = getIntent();
        String str1 = intent.getStringExtra("decryptedmessage");

        receiver_msg1.setText(str1);

    }
}
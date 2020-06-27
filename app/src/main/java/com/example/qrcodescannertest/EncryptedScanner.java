package com.example.qrcodescannertest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class EncryptedScanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private Helper helper;
    int MY_PERMISSIONS_REQUEST_CAMERA = 0;
    ZXingScannerView ScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = new Helper();
        ScannerView = new ZXingScannerView(this);
        setContentView(ScannerView);
    }
    @Override
    public void handleResult(Result result) {
        String str = result.getText();
        Intent displayResult = new Intent(this, DisplayEncryptedActivity.class);
        String decryptedResult = decryptPattern(str);
        displayResult.putExtra("decryptedmessage", decryptedResult);
        startActivity(displayResult);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ScannerView.stopCamera();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
        }
        ScannerView.setResultHandler(this);
        ScannerView.startCamera();
    }

    public String decryptPattern(String encrypted) {
        int [] pattern = helper.getValue();
        char [] arr = encrypted.toCharArray();
        int j = 0, x = 0;
        for (int i = 0; i < arr.length; i++) {
            x = (int) arr[i];
            if (x < pattern[j]) {
                arr[i] = (char) (128 + x - pattern[j]);
                j++;
            } else if (x >= pattern[j]) {
                arr[i] = (char) (x - pattern[j]);
                j++;
            }
            if (j == 9) {
                j = 0;
            }
        }
        return String.valueOf(arr);
    }
}
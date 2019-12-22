package com.example.askpermissions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAskInternet,btnAskAudio,btnAskReadExternal,btnWriteExternal,btnAskCamera;
    private static final int MY_PERMISSIONS_REQUEST_INTERNET = 100;
    private static final int MY_PERMISSIONS_REQUEST_AUDIO_SOURCE = 200;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 300;
    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 400;
    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Permissions!");
        setId();
        setListener();
    }
    public void setId(){
        btnAskInternet=findViewById(R.id.askInternet);
        btnAskAudio=findViewById(R.id.askRecordAudio);
        btnAskReadExternal=findViewById(R.id.askReadExternal);
        btnWriteExternal=findViewById(R.id.askWriteExternal);
        btnAskCamera=findViewById(R.id.askCamera);
    }
    public void setListener(){
        btnAskInternet.setOnClickListener(this);
        btnAskAudio.setOnClickListener(this);
        btnAskReadExternal.setOnClickListener(this);
        btnWriteExternal.setOnClickListener(this);
        btnAskCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.askInternet:
                if (ActivityCompat.checkSelfPermission(this,Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET},MY_PERMISSIONS_REQUEST_INTERNET);
                }else {
                    Toast.makeText(this, "Internet Permission Granted Already!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.askRecordAudio:
                if (ActivityCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO)!=PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},MY_PERMISSIONS_REQUEST_AUDIO_SOURCE);
                }else {
                    Toast.makeText(this, "Audio Source Permission Granted Already!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.askReadExternal:
                if (ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                }else {
                    Toast.makeText(this, "Read External Storage Permission Granted Already!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.askWriteExternal:
                if (ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                }else {
                    Toast.makeText(this, "Write External Storage Permission Granted Already!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.askCamera:
                if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},MY_PERMISSIONS_REQUEST_CAMERA);
                }else {
                    Toast.makeText(this, "Camera Permission Granted Already!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case MY_PERMISSIONS_REQUEST_INTERNET:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Internet Permission is now granted!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Internet Boooooo!", Toast.LENGTH_SHORT).show();
                }
                return;
            case MY_PERMISSIONS_REQUEST_AUDIO_SOURCE:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Audio Source Permission is now granted!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Audio Source Booooooo!", Toast.LENGTH_SHORT).show();
                }
                return;
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Read External Storage Permission is now granted!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Read External Storage Booooooo!", Toast.LENGTH_SHORT).show();
                }
                return;
            case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Write External Storage Permission is now granted!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Write External Storage Booooooo!", Toast.LENGTH_SHORT).show();
                }
                return;
            case MY_PERMISSIONS_REQUEST_CAMERA:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Camera Permission is now granted!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Camera Booooooo!", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }
}

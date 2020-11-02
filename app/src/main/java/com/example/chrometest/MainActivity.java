package com.example.chrometest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text);

        try {
            PackageInfo packageInfo= getPackageManager().getPackageInfo("com.android.chrome", PackageManager.GET_ACTIVITIES);
            Log.e(TAG, "onCreate: "+packageInfo);
            String text="Version Name="+ packageInfo.versionName+"\n"+ "Package Name= " +packageInfo.packageName+ "\nVersion Code= "+packageInfo.versionCode;
            textView.setText(text);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            textView.setText("Chrome not installed");
        }
    }
}
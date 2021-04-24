package com.huawei.os.mmmonitorchart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.huawei.os.mmmonitorchart.charts.fragment.LineChartFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private LineChartFragment mLineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
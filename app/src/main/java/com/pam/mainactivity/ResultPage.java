package com.pam.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity {
    TextView tTask, tJenis, tTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        tTask = findViewById(R.id.intask);
        tJenis = findViewById(R.id.injtask);
        tTime = findViewById(R.id.injtask);

        Bundle bundle = getIntent().getExtras();

        String task = bundle.getString("a");
        String jenis = bundle.getString("b");
        String time = bundle.getString("c");

        tTask.setText(task);
        tJenis.setText(jenis);
        tTime.setText(time);
    }
}